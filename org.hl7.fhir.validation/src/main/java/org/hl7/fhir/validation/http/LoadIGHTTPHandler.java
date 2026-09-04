package org.hl7.fhir.validation.http;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.IgLoader;

import java.io.IOException;

/**
 * Handler for dynamically loading an Implementation Guide into the running server.
 * Accepts a JSON body with an "ig" field specifying the IG package (e.g., "hl7.fhir.us.core#5.0.1").
 */
@Slf4j
class LoadIGHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  private final FhirValidatorHttpService fhirValidatorHttpService;

  public LoadIGHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      byte[] body = readRequestBody(exchange);
      JsonObject wrapper = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(body);

      String ig = wrapper.asString("ig");
      if (ig == null || ig.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError("Missing required field: ig"), getAcceptHeader(exchange));
        return;
      }
      if (!fhirValidatorHttpService.isLoopbackOnly() && !isRemoteLoadableSource(ig.trim())) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createError(
          "Loading an IG from a server-local path is only permitted when the server is bound to loopback; "
          + "supply a package reference (id#version) or an http(s) URL instead"), getAcceptHeader(exchange));
        return;
      }

      log.info("Loading IG: " + ig);
      org.hl7.fhir.validation.ValidationEngine engine = fhirValidatorHttpService.getValidationEngine();
      engine.getIgLoader().loadIg(engine.getIgs(), engine.getBinaries(), ig, false);
      log.info("IG loaded successfully: " + ig);

      sendOperationOutcome(exchange, 200, OperationOutcomeUtilities.createSuccess("IG loaded successfully: " + ig), getAcceptHeader(exchange));

    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("Failed to load IG: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }

  protected static String stripVersionFromSource(String src) throws FHIRException {
    return new IgLoader.SourceWithFHIRVersion(src).getSource();
  }

  /**
   * Whether {@code src} is something a caller on the network may legitimately name: a package
   * reference ({@code id} or {@code id#version}, optionally prefixed with a {@code [version]}
   * hint as {@code IgLoader} accepts) or an http(s) URL. A filesystem path is neither - and
   * neither is a package-shaped name that happens to exist as a file here, since
   * {@code IgLoader} would read the file. The point is that a remote caller never gets to name
   * a path on this host.
   */
  static boolean isRemoteLoadableSource(String src) {
    String versionLessSrc;
    try {
      versionLessSrc = stripVersionFromSource(src);
    } catch (FHIRException e) {
      return false;
    }

    String lower = versionLessSrc.toLowerCase(java.util.Locale.ROOT);
    if (lower.startsWith("http://") || lower.startsWith("https://")) {
      return true;
    }
    // A dotted file name matches the package pattern too (package.tgz, secrets.json), and
    // IgLoader resolves that ambiguity in favour of a file that exists. Mirror both rules here:
    // archive names are never package references (IgLoader makes the same exclusion), and a
    // package-shaped name that exists on this host's file system is a file, not a package.
    if (lower.endsWith(".tgz") || lower.endsWith(".zip") || lower.endsWith(".pack")) {
      return false;
    }
    if (!versionLessSrc.matches(FilesystemPackageCacheManager.PACKAGE_VERSION_REGEX_OPT)) {
      return false;
    }
    try {
      return !ManagedFileAccess.file(versionLessSrc).exists();
    } catch (IOException e) {
      return false;
    }
  }
}
