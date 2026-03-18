package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.validation.cli.picocli.options.InstanceValidatorOptions;
import org.hl7.fhir.validation.service.ValidationOutputRenderSummary;
import org.hl7.fhir.validation.service.ValidationOutputRenderUtilities;
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
import org.hl7.fhir.validation.http.ParamNames;

/**
 * HTTP client command for interacting with the FHIR validator HTTP server.
 * <p/>
 * This command sends requests to a running validator HTTP server, including
 * validation and stop requests.
 * <p/>
 * Usage:
 * <pre>
 * java -jar validator_cli.jar client -port 3000 ./resources/resource.json
 * java -jar validator_cli.jar client -port 3000 -stop
 * </pre>
 */
@Slf4j
@CommandLine.Command(
  name = "client",
  description = """
    HTTP client for interacting with the FHIR validator HTTP server.

    This command is intended to send requests to a running validator
    HTTP server, such as validation and server stop requests.

    Examples:
      java -jar validator_cli.jar client -port 3000 ./resources/resource.json
      java -jar validator_cli.jar client -port 3000 stop
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


  @CommandLine.Option(
    names = {"-host"},
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

    final URI uri;

    if (stop) {
      try {
        uri = host != null ? getStopUri(host) : getStopUri(hostname, port);
        HttpRequest.newBuilder()
          .uri(uri)
          .POST(HttpRequest.BodyPublishers.ofString("{}"))
          .build();
        return 0;
      }  catch (URISyntaxException e) {
        logExceptionOnURIGet(e);
        return 1;
      }
    }

    try {
      uri = host != null ? getValidationUriFromOptions(host, instanceValidatorOptions) : getValidationUriFromOptions(hostname, port, instanceValidatorOptions);
    } catch (URISyntaxException e) {
      logExceptionOnURIGet(e);
      return 1;
    }

    if (whatToValidate == null) {
      return 0;
    }

    for (String source : whatToValidate) {
      try {
        HttpRequest request = HttpRequest.newBuilder()
          .uri(uri)
          .POST(HttpRequest.BodyPublishers.ofFile(Path.of(source)))
          .header("Content-Type", "application/fhir+json")
          .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        JsonParser jsonParser = new JsonParser();
        Resource resource = jsonParser.parse(response.body());
        ValidationOutputRenderSummary renderSummary = ValidationOutputRenderUtilities.renderValidationOutput(resource, null, null, false, false, "NOW!", null);
        if (renderSummary.totalErrors() > 0) {
          System.exit(1);
        }
      } catch (IOException | InterruptedException e) {
        log.error(e.getMessage(), e);
        return 1;
      }
    }

    return 0;
  }

  private void logExceptionOnURIGet(URISyntaxException e) {
    log.error("Unable to construct URI from options host={} hostname={} port={}", host, hostname, port, e);
  }

  public URI getStopUri(String host, int port) throws URISyntaxException {
    URIBuilder uriBuilder = new URIBuilder()
      .setScheme("http")
      .setHost(host)
      .setPort(port);
    return getStopUri(uriBuilder);
  }
  public URI getStopUri(String hostname) throws URISyntaxException {
    URIBuilder uriBuilder = new URIBuilder(hostname);
    return getStopUri(uriBuilder);
  }

  public URI getStopUri(URIBuilder uriBuilder) throws URISyntaxException {
    uriBuilder.setPath("/stop");
    return uriBuilder.build();
  }

  public URI getValidationUriFromOptions(String hostname, InstanceValidatorOptions instanceValidatorOptions) throws URISyntaxException {
    URIBuilder uriBuilder = new URIBuilder(hostname).setScheme("http");
    return getValidationUriFromOptions(uriBuilder, instanceValidatorOptions);
  }

  public URI getValidationUriFromOptions(String host, int port, InstanceValidatorOptions instanceValidatorOptions) throws URISyntaxException {
    URIBuilder uriBuilder = new URIBuilder()
      .setScheme("http")
      .setHost(host)
      .setPort(port);
    return getValidationUriFromOptions(uriBuilder, instanceValidatorOptions);
  }

  // Created by claude-sonnet-4-6
  public URI getValidationUriFromOptions(URIBuilder uriBuilder, InstanceValidatorOptions instanceValidatorOptions) throws URISyntaxException {
    uriBuilder.setPath("/validateResource");

    // String fields
    if (instanceValidatorOptions.jurisdiction != null) {
      uriBuilder.addParameter(ParamNames.JURISDICTION, instanceValidatorOptions.jurisdiction);
    }
    if (instanceValidatorOptions.expansionParameters != null) {
      uriBuilder.addParameter(ParamNames.EXPANSION_PARAMETERS, instanceValidatorOptions.expansionParameters);
    }
    if (instanceValidatorOptions.htmlOutput != null) {
      uriBuilder.addParameter(ParamNames.HTML_OUTPUT, instanceValidatorOptions.htmlOutput);
    }
    if (instanceValidatorOptions.outputStyle != null) {
      uriBuilder.addParameter(ParamNames.OUTPUT_STYLE, instanceValidatorOptions.outputStyle);
    }
    if (instanceValidatorOptions.r5BundleRelativeReferencePolicy != null) {
      uriBuilder.addParameter(ParamNames.R5_BUNDLE_RELATIVE_REFERENCE_POLICY, instanceValidatorOptions.r5BundleRelativeReferencePolicy);
    }
    if (instanceValidatorOptions.questionnaireMode != null) {
      uriBuilder.addParameter(ParamNames.QUESTIONNAIRE_MODE, instanceValidatorOptions.questionnaireMode);
    }
    if (instanceValidatorOptions.level != null) {
      uriBuilder.addParameter(ParamNames.LEVEL, instanceValidatorOptions.level);
    }
    if (instanceValidatorOptions.bestPracticeLevel != null) {
      uriBuilder.addParameter(ParamNames.BEST_PRACTICE_LEVEL, instanceValidatorOptions.bestPracticeLevel);
    }
    if (instanceValidatorOptions.htmlInMarkdownCheck != null) {
      uriBuilder.addParameter(ParamNames.HTML_IN_MARKDOWN_CHECK, instanceValidatorOptions.htmlInMarkdownCheck);
    }
    if (instanceValidatorOptions.checkDisplay != null) {
      uriBuilder.addParameter(ParamNames.CHECK_DISPLAY, instanceValidatorOptions.checkDisplay);
    }
    if (instanceValidatorOptions.resourceIdRule != null) {
      uriBuilder.addParameter(ParamNames.RESOURCE_ID_RULE, instanceValidatorOptions.resourceIdRule);
    }

    // Boolean flags - only add when true (non-default)
    if (instanceValidatorOptions.assumeValidRestReferences) {
      uriBuilder.addParameter(ParamNames.ASSUME_VALID_REST_REFERENCES, "true");
    }
    if (instanceValidatorOptions.hintAboutNonMustSupport) {
      uriBuilder.addParameter(ParamNames.HINT_ABOUT_NON_MUST_SUPPORT, "true");
    }
    if (instanceValidatorOptions.wantInvariantsInMessages) {
      uriBuilder.addParameter(ParamNames.WANT_INVARIANTS_IN_MESSAGES, "true");
    }
    if (instanceValidatorOptions.noInvariants) {
      uriBuilder.addParameter(ParamNames.NO_INVARIANTS, "true");
    }
    if (instanceValidatorOptions.unknownCodeSystemsCauseErrors) {
      uriBuilder.addParameter(ParamNames.UNKNOWN_CODE_SYSTEMS_CAUSE_ERRORS, "true");
    }
    if (instanceValidatorOptions.forPublication) {
      uriBuilder.addParameter(ParamNames.FOR_PUBLICATION, "true");
    }
    if (instanceValidatorOptions.noUnicodeBiDiControlChars) {
      uriBuilder.addParameter(ParamNames.NO_UNICODE_BI_DI_CONTROL_CHARS, "true");
    }
    if (instanceValidatorOptions.verbose) {
      uriBuilder.addParameter(ParamNames.VERBOSE, "true");
    }
    if (instanceValidatorOptions.showMessageIds) {
      uriBuilder.addParameter(ParamNames.SHOW_MESSAGE_IDS, "true");
    }
    if (instanceValidatorOptions.allowExampleUrls) {
      uriBuilder.addParameter(ParamNames.ALLOW_EXAMPLE_URLS, "true");
    }
    if (instanceValidatorOptions.showMessagesFromReferences) {
      uriBuilder.addParameter(ParamNames.SHOW_MESSAGES_FROM_REFERENCES, "true");
    }
    if (instanceValidatorOptions.securityChecks) {
      uriBuilder.addParameter(ParamNames.SECURITY_CHECKS, "true");
    }
    if (instanceValidatorOptions.noExperimentalContent) {
      uriBuilder.addParameter(ParamNames.NO_EXPERIMENTAL_CONTENT, "true");
    }
    if (instanceValidatorOptions.showTerminologyRouting) {
      uriBuilder.addParameter(ParamNames.SHOW_TERMINOLOGY_ROUTING, "true");
    }
    if (instanceValidatorOptions.doImplicitFHIRPathStringConversion) {
      uriBuilder.addParameter(ParamNames.DO_IMPLICIT_FHIR_PATH_STRING_CONVERSION, "true");
    }
    if (instanceValidatorOptions.allowDoubleQuotesInFHIRPath) {
      uriBuilder.addParameter(ParamNames.ALLOW_DOUBLE_QUOTES_IN_FHIR_PATH, "true");
    }
    if (instanceValidatorOptions.checkIPSCodes) {
      uriBuilder.addParameter(ParamNames.CHECK_IPS_CODES, "true");
    }

    // Numeric fields
    if (instanceValidatorOptions.maxValidationMessages != null && instanceValidatorOptions.maxValidationMessages > 0) {
      uriBuilder.addParameter(ParamNames.MAX_VALIDATION_MESSAGES, String.valueOf(instanceValidatorOptions.maxValidationMessages));
    }
    if (instanceValidatorOptions.validationTimeout != null && instanceValidatorOptions.validationTimeout > 0) {
      uriBuilder.addParameter(ParamNames.VALIDATION_TIMEOUT, String.valueOf(instanceValidatorOptions.validationTimeout));
    }

    // extensions - list, values may be URIs; addParameter handles percent-encoding
    if (instanceValidatorOptions.extensions != null) {
      for (String extension : instanceValidatorOptions.extensions) {
        uriBuilder.addParameter(ParamNames.EXTENSION, extension);
      }
    }

    // profiles - list, values may be URIs
    if (instanceValidatorOptions.profiles != null) {
      for (String profile : instanceValidatorOptions.profiles) {
        uriBuilder.addParameter(ParamNames.PROFILE, profile);
      }
    }

    // compactProfiles - each entry is a comma-delimited list of profiles
    if (instanceValidatorOptions.compactProfiles != null) {
      for (String compactProfile : instanceValidatorOptions.compactProfiles) {
        for (String profile : compactProfile.split(",")) {
          String trimmed = profile.trim();
          if (!trimmed.isEmpty()) {
            uriBuilder.addParameter(ParamNames.PROFILE, trimmed);
          }
        }
      }
    }

    // bundleValidationRules - list of alternating (rule, profile) pairs
    if (instanceValidatorOptions.bundleValidationRules != null) {
      java.util.List<String> rules = instanceValidatorOptions.bundleValidationRules;
      for (int i = 0; i + 1 < rules.size(); i += 2) {
        uriBuilder.addParameter(ParamNames.BUNDLE_VALIDATION_RULE, rules.get(i));
        uriBuilder.addParameter(ParamNames.BUNDLE_VALIDATION_PROFILE, rules.get(i + 1));
      }
    }

    return uriBuilder.build();
  }
}
