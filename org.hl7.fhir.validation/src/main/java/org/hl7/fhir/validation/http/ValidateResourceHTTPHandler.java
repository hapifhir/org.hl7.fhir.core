package org.hl7.fhir.validation.http;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
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

    List<String> profiles = null;
    IdStatus resourceIdRule = null;
    boolean anyExtensionsAllowed = false;
    BestPracticeWarningLevel bpWarnings = null;
    CheckDisplayOption displayOption = null;
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

    } catch (Exception e) {
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

  public InstanceValidatorParameters getInstanceValidatorParameters(String httpQueryString) {
    InstanceValidatorParameters params = new InstanceValidatorParameters();
    if (httpQueryString == null || httpQueryString.isEmpty()) {
      return params;
    }

    List<NameValuePair> pairs = URLEncodedUtils.parse(httpQueryString, StandardCharsets.UTF_8);

    List<String> bundleRules = new ArrayList<>();
    List<String> bundleProfiles = new ArrayList<>();

    for (NameValuePair pair : pairs) {
      switch (pair.getName()) {
        case "jurisdiction":
          params.setJurisdiction(pair.getValue());
          break;
        case "expansionParameters":
          params.setExpansionParameters(pair.getValue());
          break;
        case "htmlOutput":
          params.setHtmlOutput(pair.getValue());
          break;
        case "outputStyle":
          params.setOutputStyle(pair.getValue());
          break;
        case "r5BundleRelativeReferencePolicy":
          params.setR5BundleRelativeReferencePolicy(R5BundleRelativeReferencePolicy.fromCode(pair.getValue()));
          break;
        case "questionnaireMode":
          params.setQuestionnaireMode(QuestionnaireMode.fromCode(pair.getValue()));
          break;
        case "level":
          params.setLevel(ValidationLevel.fromCode(pair.getValue()));
          break;
        case "bestPracticeLevel":
          params.setBestPracticeLevel(BestPracticeWarningLevel.valueOf(pair.getValue()));
          break;
        case "htmlInMarkdownCheck":
          params.setHtmlInMarkdownCheck(HtmlInMarkdownCheck.fromCode(pair.getValue()));
          break;
        case "assumeValidRestReferences":
          params.setAssumeValidRestReferences(Boolean.parseBoolean(pair.getValue()));
          break;
        case "hintAboutNonMustSupport":
          params.setHintAboutNonMustSupport(Boolean.parseBoolean(pair.getValue()));
          break;
        case "wantInvariantsInMessages":
          params.setWantInvariantsInMessages(Boolean.parseBoolean(pair.getValue()));
          break;
        case "noInvariants":
          params.setNoInvariants(Boolean.parseBoolean(pair.getValue()));
          break;
        case "unknownCodeSystemsCauseErrors":
          params.setUnknownCodeSystemsCauseErrors(Boolean.parseBoolean(pair.getValue()));
          break;
        case "forPublication":
          params.setForPublication(Boolean.parseBoolean(pair.getValue()));
          break;
        case "noUnicodeBiDiControlChars":
          params.setNoUnicodeBiDiControlChars(Boolean.parseBoolean(pair.getValue()));
          break;
        case "showMessageIds":
          params.setShowMessageIds(Boolean.parseBoolean(pair.getValue()));
          break;
        case "allowExampleUrls":
          params.setAllowExampleUrls(Boolean.parseBoolean(pair.getValue()));
          break;
        case "showMessagesFromReferences":
          params.setShowMessagesFromReferences(Boolean.parseBoolean(pair.getValue()));
          break;
        case "securityChecks":
          params.setSecurityChecks(Boolean.parseBoolean(pair.getValue()));
          break;
        case "noExperimentalContent":
          params.setNoExperimentalContent(Boolean.parseBoolean(pair.getValue()));
          break;
        case "showTerminologyRouting":
          params.setShowTerminologyRouting(Boolean.parseBoolean(pair.getValue()));
          break;
        case "doImplicitFHIRPathStringConversion":
          params.setDoImplicitFHIRPathStringConversion(Boolean.parseBoolean(pair.getValue()));
          break;
        case "allowDoubleQuotesInFHIRPath":
          params.setAllowDoubleQuotesInFHIRPath(Boolean.parseBoolean(pair.getValue()));
          break;
        case "checkIPSCodes":
          params.setCheckIPSCodes(Boolean.parseBoolean(pair.getValue()));
          break;
        case "validationTimeout":
          params.setTimeout(new ValidationTimeout(Long.parseLong(pair.getValue()), "http-query"));
          break;
        case "extension":
          params.addExtension(pair.getValue());
          break;
        case "profile":
          params.addProfile(pair.getValue());
          break;
        case "bundleValidationRule":
          bundleRules.add(pair.getValue());
          break;
        case "bundleValidationProfile":
          bundleProfiles.add(pair.getValue());
          break;
      }
    }

    for (int i = 0; i < Math.min(bundleRules.size(), bundleProfiles.size()); i++) {
      params.addBundleValidationRule(new BundleValidationRule()
        .setRule(bundleRules.get(i))
        .setProfile(bundleProfiles.get(i)));
    }

    return params;
  }
}
