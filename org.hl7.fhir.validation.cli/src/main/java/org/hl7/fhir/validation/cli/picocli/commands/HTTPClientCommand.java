package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import org.hl7.fhir.validation.service.ValidationOutputRenderSummary;
import org.hl7.fhir.validation.service.ValidationOutputRenderUtilities;
import org.hl7.fhir.validation.service.renderers.*;
import picocli.CommandLine;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;
import java.util.concurrent.Callable;

import org.hl7.fhir.r5.model.Resource;

/**
 * HTTP client command for interacting with the FHIR validator HTTP server.
 * <p/>
 * This command is intended to send commands to a running validator HTTP server,
 * such as stopping the server remotely or checking its status.
 * <p/>
 * Note: This command is not yet fully implemented. It currently serves as a
 * placeholder for future HTTP client functionality.
 * <p/>
 * Planned usage:
 * <pre>
 * java -jar validator_cli.jar client --stop -port 8080
 * java -jar validator_cli.jar client --status -host localhost -port 8080
 * </pre>
 */
@Slf4j
@CommandLine.Command(
  name = "client",
  description = """
    HTTP client for interacting with the FHIR validator HTTP server.

    This command is intended to send commands to a running validator
    HTTP server, such as stopping the server remotely.

    Note: This command is not yet fully implemented.

    Example (planned):
      java -jar validator_cli.jar client --stop -port 8080
    """,
  hidden = false
)
public class HTTPClientCommand implements Callable<Integer> {

  @CommandLine.Option(
    names = {"-stop"},
    description = "Stop the running HTTP server"
  )
  private boolean stop;

  @CommandLine.Option(
    names = {"-hostname"},
    description = "Server host (default: localhost)",
    defaultValue = "localhost",
    arity = "1"
  )
  private String hostname;

  @CommandLine.Option(
    names = {"-port"},
    description = "Server port (default: 80)",
    defaultValue = "80",
    arity = "1"
  )
  private Integer port;

  @CommandLine.Parameters(
    index = "0",
    description = "Hostname and port combo (or default http port)",
    arity = "1"
  )
  private String host;

  @CommandLine.ArgGroup(validate = false, heading = "Instance Validator Options%n")
  InstanceValidatorOptions instanceValidatorOptions = new InstanceValidatorOptions();

  @CommandLine.Parameters(
    description = "The input file(s) to validate.")
  private String[] whatToValidate;

  @Override
  public Integer call() {

    HttpClient httpClient = HttpClient.newBuilder()
      .connectTimeout(Duration.ofSeconds(10))
      .build();

    final String BASE_URL = "localhost";

    if (stop) {
      log.info("Sent stop command to HTTP server");
      return 0;
    }

    for (String source : whatToValidate) {
      try {
        HttpRequest request = HttpRequest.newBuilder()
          .uri(getUriFromOptions(BASE_URL, port, instanceValidatorOptions))
          .POST(HttpRequest.BodyPublishers.ofFile(Path.of(source)))
          .header("Content-Type", "application/fhir+json")
          .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JsonParser jsonParser = new JsonParser();
        Resource resource = jsonParser.parse(response.body());
        ValidationOutputRenderSummary renderSummary = ValidationOutputRenderUtilities.renderValidationOutput(resource, null, null, false, false, "NOW!");
        if (renderSummary.totalErrors() > 0) {
          System.exit(1);
        }
      } catch (IOException | URISyntaxException | InterruptedException e) {
        log.error(e.getMessage(), e);
        return 1;
      }
    }

    return 0;
  }

  // Created by claude-sonnet-4-6
  public URI getUriFromOptions(String host, int port, InstanceValidatorOptions instanceValidatorOptions) throws URISyntaxException {
    URIBuilder uriBuilder = new URIBuilder()
      .setScheme("http")
      .setHost(host)
      .setPort(port)
      .setPath("/validateResource");

    // String fields
    if (instanceValidatorOptions.jurisdiction != null) {
      uriBuilder.addParameter("jurisdiction", instanceValidatorOptions.jurisdiction);
    }
    if (instanceValidatorOptions.expansionParameters != null) {
      uriBuilder.addParameter("expansionParameters", instanceValidatorOptions.expansionParameters);
    }
    if (instanceValidatorOptions.htmlOutput != null) {
      uriBuilder.addParameter("htmlOutput", instanceValidatorOptions.htmlOutput);
    }
    if (instanceValidatorOptions.outputStyle != null) {
      uriBuilder.addParameter("outputStyle", instanceValidatorOptions.outputStyle);
    }
    if (instanceValidatorOptions.r5BundleRelativeReferencePolicy != null) {
      uriBuilder.addParameter("r5BundleRelativeReferencePolicy", instanceValidatorOptions.r5BundleRelativeReferencePolicy);
    }
    if (instanceValidatorOptions.questionnaireMode != null) {
      uriBuilder.addParameter("questionnaireMode", instanceValidatorOptions.questionnaireMode);
    }
    if (instanceValidatorOptions.level != null) {
      uriBuilder.addParameter("level", instanceValidatorOptions.level);
    }
    if (instanceValidatorOptions.bestPracticeLevel != null) {
      uriBuilder.addParameter("bestPracticeLevel", instanceValidatorOptions.bestPracticeLevel);
    }
    if (instanceValidatorOptions.htmlInMarkdownCheck != null) {
      uriBuilder.addParameter("htmlInMarkdownCheck", instanceValidatorOptions.htmlInMarkdownCheck);
    }

    // Boolean flags - only add when true (non-default)
    if (instanceValidatorOptions.assumeValidRestReferences) {
      uriBuilder.addParameter("assumeValidRestReferences", "true");
    }
    if (instanceValidatorOptions.hintAboutNonMustSupport) {
      uriBuilder.addParameter("hintAboutNonMustSupport", "true");
    }
    if (instanceValidatorOptions.wantInvariantsInMessages) {
      uriBuilder.addParameter("wantInvariantsInMessages", "true");
    }
    if (instanceValidatorOptions.noInvariants) {
      uriBuilder.addParameter("noInvariants", "true");
    }
    if (instanceValidatorOptions.unknownCodeSystemsCauseErrors) {
      uriBuilder.addParameter("unknownCodeSystemsCauseErrors", "true");
    }
    if (instanceValidatorOptions.forPublication) {
      uriBuilder.addParameter("forPublication", "true");
    }
    if (instanceValidatorOptions.noUnicodeBiDiControlChars) {
      uriBuilder.addParameter("noUnicodeBiDiControlChars", "true");
    }
    if (instanceValidatorOptions.verbose) {
      uriBuilder.addParameter("verbose", "true");
    }
    if (instanceValidatorOptions.showMessageIds) {
      uriBuilder.addParameter("showMessageIds", "true");
    }
    if (instanceValidatorOptions.allowExampleUrls) {
      uriBuilder.addParameter("allowExampleUrls", "true");
    }
    if (instanceValidatorOptions.showMessagesFromReferences) {
      uriBuilder.addParameter("showMessagesFromReferences", "true");
    }
    if (instanceValidatorOptions.securityChecks) {
      uriBuilder.addParameter("securityChecks", "true");
    }
    if (instanceValidatorOptions.noExperimentalContent) {
      uriBuilder.addParameter("noExperimentalContent", "true");
    }
    if (instanceValidatorOptions.showTerminologyRouting) {
      uriBuilder.addParameter("showTerminologyRouting", "true");
    }
    if (instanceValidatorOptions.doImplicitFHIRPathStringConversion) {
      uriBuilder.addParameter("doImplicitFHIRPathStringConversion", "true");
    }
    if (instanceValidatorOptions.allowDoubleQuotesInFHIRPath) {
      uriBuilder.addParameter("allowDoubleQuotesInFHIRPath", "true");
    }
    if (instanceValidatorOptions.checkIPSCodes) {
      uriBuilder.addParameter("checkIPSCodes", "true");
    }

    // Numeric fields
    if (instanceValidatorOptions.validationTimeout != null && instanceValidatorOptions.validationTimeout > 0) {
      uriBuilder.addParameter("validationTimeout", String.valueOf(instanceValidatorOptions.validationTimeout));
    }

    // extensions - list, values may be URIs; addParameter handles percent-encoding
    if (instanceValidatorOptions.extensions != null) {
      for (String extension : instanceValidatorOptions.extensions) {
        uriBuilder.addParameter("extension", extension);
      }
    }

    // profiles - list, values may be URIs
    if (instanceValidatorOptions.profiles != null) {
      for (String profile : instanceValidatorOptions.profiles) {
        uriBuilder.addParameter("profile", profile);
      }
    }

    // compactProfiles - each entry is a comma-delimited list of profiles
    if (instanceValidatorOptions.compactProfiles != null) {
      for (String compactProfile : instanceValidatorOptions.compactProfiles) {
        for (String profile : compactProfile.split(",")) {
          String trimmed = profile.trim();
          if (!trimmed.isEmpty()) {
            uriBuilder.addParameter("profile", trimmed);
          }
        }
      }
    }

    // bundleValidationRules - list of alternating (rule, profile) pairs
    if (instanceValidatorOptions.bundleValidationRules != null) {
      java.util.List<String> rules = instanceValidatorOptions.bundleValidationRules;
      for (int i = 0; i + 1 < rules.size(); i += 2) {
        uriBuilder.addParameter("bundleValidationRule", rules.get(i));
        uriBuilder.addParameter("bundleValidationProfile", rules.get(i + 1));
      }
    }

    return uriBuilder.build();
  }
}
