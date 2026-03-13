package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.utils.OperationOutcomeUtilities;
import org.hl7.fhir.r5.utils.validation.BundleValidationRule;
import org.hl7.fhir.r5.utils.validation.constants.BestPracticeWarningLevel;
import org.hl7.fhir.r5.utils.validation.constants.CheckDisplayOption;
import org.hl7.fhir.r5.utils.validation.constants.IdStatus;
import org.hl7.fhir.utilities.ByteProvider;
import org.hl7.fhir.utilities.validation.ValidationOptions.R5BundleRelativeReferencePolicy;
import org.hl7.fhir.validation.ValidationRecord;
import org.hl7.fhir.validation.instance.ValidatorMaxMessages;
import org.hl7.fhir.validation.instance.ValidationTimeout;
import org.hl7.fhir.validation.service.model.HtmlInMarkdownCheck;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.utils.QuestionnaireMode;
import org.hl7.fhir.validation.service.utils.ValidationLevel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Handler for validating resources
 */
class ValidateResourceHTTPHandler extends BaseHTTPHandler implements HttpHandler {
  public static final String VALIDATE_LOCATION = "http-request";

  private final FhirValidatorHttpService fhirValidatorHttpService;

  public ValidateResourceHTTPHandler(FhirValidatorHttpService fhirValidatorHttpService) {
    this.fhirValidatorHttpService = fhirValidatorHttpService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    if (!"POST".equals(exchange.getRequestMethod())) {
      sendResponse(exchange, 405, "Method not allowed", "text/plain");
      return;
    }

    byte[] resourceBytes = null;
    Manager.FhirFormat format = null;
    InstanceValidatorParameters instanceValidatorParameters = new InstanceValidatorParameters();
    try {
      // Read resource bytes from request body
      resourceBytes = readRequestBody(exchange);
      // Get content type and determine format
      String contentType = exchange.getRequestHeaders().getFirst("Content-Type");
      format = determineFormat(contentType);

      // Get InstanceValidatorParameters objects from query string exchange.getRequestURI().getQuery();
      instanceValidatorParameters = getInstanceValidatorParameters(exchange.getRequestURI().getQuery());

    } catch (IllegalArgumentException e) {
      OperationOutcome outcome = OperationOutcomeUtilities.createError("Operation failed: " + e.getMessage());
      sendOperationOutcome(exchange, 400, outcome, getAcceptHeader(exchange));
      return;
    }
    try {
      ByteProvider byteProvider = ByteProvider.forBytes(resourceBytes);
      List<ValidationRecord> validationRecords = new ArrayList<>();
      OperationOutcome outcome = fhirValidatorHttpService.getValidationEngine().validate(VALIDATE_LOCATION, byteProvider, format, instanceValidatorParameters, validationRecords);

      sendOperationOutcome(exchange, 200, outcome, getAcceptHeader(exchange));

    } catch (Throwable e) {
      OperationOutcome outcome = OperationOutcomeUtilities.createError("Validation failed: " + e.getMessage());
      sendOperationOutcome(exchange, 500, outcome, getAcceptHeader(exchange));
    }
  }

  public InstanceValidatorParameters getInstanceValidatorParameters(String httpQueryString) throws IllegalArgumentException{
    InstanceValidatorParameters params = new InstanceValidatorParameters();
    if (httpQueryString == null || httpQueryString.isEmpty()) {
      return params;
    }

    List<NameValuePair> pairs = URLEncodedUtils.parse(httpQueryString, StandardCharsets.UTF_8);

    List<String> bundleRules = new ArrayList<>();
    List<String> bundleProfiles = new ArrayList<>();

    for (NameValuePair pair : pairs) {
      switch (pair.getName()) {
        case ParamNames.JURISDICTION:
          params.setJurisdiction(pair.getValue());
          break;
        case ParamNames.EXPANSION_PARAMETERS:
          params.setExpansionParameters(pair.getValue());
          break;
        case ParamNames.HTML_OUTPUT:
          params.setHtmlOutput(pair.getValue());
          break;
        case ParamNames.OUTPUT_STYLE:
          params.setOutputStyle(pair.getValue());
          break;
        case ParamNames.R5_BUNDLE_RELATIVE_REFERENCE_POLICY:
          params.setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.fromCode(pair.getValue()));
          break;
        case ParamNames.QUESTIONNAIRE_MODE:
          params.setQuestionnaireMode(QuestionnaireMode.fromCode(pair.getValue()));
          break;
        case ParamNames.LEVEL:
          params.setLevel(ValidationLevel.fromCode(pair.getValue()));
          break;
        case ParamNames.BEST_PRACTICE_LEVEL:
          params.setBestPracticeLevel(BestPracticeWarningLevel.valueOf(pair.getValue()));
          break;
        case ParamNames.HTML_IN_MARKDOWN_CHECK:
          params.setHtmlInMarkdownCheck(HtmlInMarkdownCheck.fromCode(pair.getValue()));
          break;
        case ParamNames.ASSUME_VALID_REST_REFERENCES:
          params.setAssumeValidRestReferences(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.HINT_ABOUT_NON_MUST_SUPPORT:
          params.setHintAboutNonMustSupport(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.WANT_INVARIANTS_IN_MESSAGES:
          params.setWantInvariantsInMessages(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.NO_INVARIANTS:
          params.setNoInvariants(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.UNKNOWN_CODE_SYSTEMS_CAUSE_ERRORS:
          params.setUnknownCodeSystemsCauseErrors(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.FOR_PUBLICATION:
          params.setForPublication(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.NO_UNICODE_BI_DI_CONTROL_CHARS:
          params.setNoUnicodeBiDiControlChars(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.VERBOSE:
          if (Boolean.parseBoolean(pair.getValue())) {
            params.setCrumbTrails(true);
            params.setShowMessageIds(true);
          }
          break;
        case ParamNames.SHOW_MESSAGE_IDS:
          params.setShowMessageIds(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.ALLOW_EXAMPLE_URLS:
          params.setAllowExampleUrls(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.SHOW_MESSAGES_FROM_REFERENCES:
          params.setShowMessagesFromReferences(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.SECURITY_CHECKS:
          params.setSecurityChecks(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.NO_EXPERIMENTAL_CONTENT:
          params.setNoExperimentalContent(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.SHOW_TERMINOLOGY_ROUTING:
          params.setShowTerminologyRouting(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.DO_IMPLICIT_FHIR_PATH_STRING_CONVERSION:
          params.setDoImplicitFHIRPathStringConversion(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.ALLOW_DOUBLE_QUOTES_IN_FHIR_PATH:
          params.setAllowDoubleQuotesInFHIRPath(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.CHECK_IPS_CODES:
          params.setCheckIPSCodes(Boolean.parseBoolean(pair.getValue()));
          break;
        case ParamNames.CHECK_DISPLAY:
          CheckDisplayOption checkDisplayOption = CheckDisplayOption.valueOf(pair.getValue());
          params.setCheckDisplay(checkDisplayOption);
          break;
        case ParamNames.RESOURCE_ID_RULE:
          try {
            IdStatus resourceIdRule = IdStatus.fromCode(pair.getValue());
            params.setResourceIdRule(resourceIdRule);
          } catch (FHIRException e) {
            throwIllegalArgumentException(pair, e);
          }
          break;
        case ParamNames.MAX_VALIDATION_MESSAGES:
          int maxMessages = Integer.parseInt(pair.getValue());
          if (maxMessages > 0) {
            params.setMaxValidationMessages(new ValidatorMaxMessages(maxMessages, "http-query"));
          }
          break;
        case ParamNames.VALIDATION_TIMEOUT:
          params.setTimeout(new ValidationTimeout(Long.parseLong(pair.getValue()), "http-query"));
          break;
        case ParamNames.EXTENSION:
          params.addExtension(pair.getValue());
          break;
        case ParamNames.PROFILE:
          params.addProfile(pair.getValue());
          break;
        case ParamNames.BUNDLE_VALIDATION_RULE:
          bundleRules.add(pair.getValue());
          break;
        case ParamNames.BUNDLE_VALIDATION_PROFILE:
          bundleProfiles.add(pair.getValue());
          break;
        default:
          throwIllegalArgumentException(pair, null);
      }
    }

    for (int i = 0; i < Math.min(bundleRules.size(), bundleProfiles.size()); i++) {
      params.addBundleValidationRule(new BundleValidationRule()
        .setRule(bundleRules.get(i))
        .setProfile(bundleProfiles.get(i)));
    }
    return params;
  }

  private static void throwIllegalArgumentException(NameValuePair pair, Exception e) {
    throw new IllegalArgumentException("Unable to process param " + pair.getName() + "=" + pair.getValue(), e);
  }
}
