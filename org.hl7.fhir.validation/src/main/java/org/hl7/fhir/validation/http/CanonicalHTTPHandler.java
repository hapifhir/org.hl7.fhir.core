package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.hl7.fhir.model.IModelContext;
import org.hl7.fhir.model.core.CanonicalResource;
import org.hl7.fhir.model.core.OperationOutcome.IssueSeverity;
import org.hl7.fhir.model.core.OperationOutcome.IssueType;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.core.VersionResolutionRules;
import org.hl7.fhir.model.utilities.OperationOutcomeUtilities;
import org.hl7.fhir.utilities.Utilities;

import java.io.IOException;
import java.util.Map;

/**
 * Handler for looking up a canonical resource (a StructureDefinition, ValueSet, CodeSystem...)
 * by its canonical URL: the resource as the engine's context knows it, or 404 when it doesn't.
 * Only what is already in the context (the core package, the loaded IGs, and what they bring)
 * is looked in; nothing is fetched from anywhere else.
 */
class CanonicalHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  static final int MAX_URL_LENGTH = 4096;

  private final FhirValidatorHttpService fhirValidatorHttpService;

  public CanonicalHTTPHandler(IModelContext context, FhirValidatorHttpService fhirValidatorHttpService) {
    super(context);
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"GET".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    try {
      Map<String, String> params = parseQueryParams(exchange.getRequestURI().getRawQuery());
      String url = params.get("url");
      String version = params.get("version");
      if (url == null || url.trim().isEmpty()) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createOutcome("Missing required query parameter: url", IssueSeverity.ERROR, IssueType.REQUIRED), getAcceptHeader(exchange));
        return;
      }
      url = url.trim();
      if (url.length() > MAX_URL_LENGTH || (version != null && version.length() > MAX_URL_LENGTH)) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createOutcome("The url or version is longer than " + MAX_URL_LENGTH + " characters", IssueSeverity.ERROR, IssueType.TOOLONG), getAcceptHeader(exchange));
        return;
      }
      // a canonical URL, not a relative reference or a logical id (which the context would also take)
      if (!Utilities.isAbsoluteUrl(url)) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createOutcome("The url must be an absolute canonical URL: " + url, IssueSeverity.ERROR, IssueType.INVALID), getAcceptHeader(exchange));
        return;
      }
      if (version != null && version.trim().isEmpty()) {
        version = null;
      }
      if (version != null && url.contains("|")) {
        sendOperationOutcome(exchange, 400, OperationOutcomeUtilities.createOutcome("Give the version as a |version suffix on the url, or as the version parameter, not both", IssueSeverity.ERROR, IssueType.INVALID), getAcceptHeader(exchange));
        return;
      }
      // Resource, not CanonicalResource: the context looks in all its kinds of resources for Resource
      Resource resource = fhirValidatorHttpService.getValidationEngine().getContext()
        .fetchResource(Resource.class, url, VersionResolutionRules.defaultRule(), version, null);
      if (!(resource instanceof CanonicalResource)) {
        sendOperationOutcome(exchange, 404, OperationOutcomeUtilities.createOutcome("No canonical resource is known for " + url + (version == null ? "" : " version " + version),
          IssueSeverity.ERROR, IssueType.NOTFOUND), getAcceptHeader(exchange));
        return;
      }
      sendResource(exchange, 200, resource, getAcceptHeader(exchange));
    } catch (Throwable e) {
      sendOperationOutcome(exchange, 500, OperationOutcomeUtilities.createError("Canonical lookup failed: " + e.getMessage()), getAcceptHeader(exchange));
    }
  }
}
