package org.hl7.fhir.validation.special;

import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.formats.JsonParser;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.terminology.ValidationResult;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public class TxServiceTestHelper {
  public static String getDiffForValidation(String id, IWorkerContext context, String name, Resource requestParameters, String expectedResponse, String expectedResponse2, String lang, String fp, JsonObject externals, boolean isCodeSystem, Set<String> modes) throws JsonSyntaxException, FileNotFoundException, IOException {
    org.hl7.fhir.model.core.Parameters p = (org.hl7.fhir.model.core.Parameters) requestParameters;
    OperationOutcome operationOutcome = checkRequest(p, isCodeSystem);
    ValueSet valueSet = null;
    String valueSetUrl = null;
    if (operationOutcome == null && !isCodeSystem) {
      if (p.hasParameter("valueSet")) {
        valueSet = (ValueSet) p.getParameter("valueSet").getResource();
        valueSetUrl = valueSet.getVUrl();
      } else if (p.hasParameter("valueSetVersion")) {
        valueSetUrl = p.getParameterValue("url").primitiveValue()+"|"+p.getParameterValue("valueSetVersion").primitiveValue();
        valueSet = context.fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue(), VersionResolutionRules.defaultRule(), p.getParameterValue("valueSetVersion").primitiveValue(), null);
      } else {
        valueSetUrl = p.getParameterValue("url").primitiveValue();
        valueSet = context.fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue(), VersionResolutionRules.defaultRule());
      }
    }
    ValidationResult validationResult = null;
    String code = null;
    String system = null;
    String version = null;
    String display = null;
    CodeableConcept codeableConcept = null;
    org.hl7.fhir.model.core.Parameters parameters = null;

    if (operationOutcome != null) {
      // the request never added up to something to validate - checkRequest has said so already
    } else if (valueSet == null && valueSetUrl != null) {
      String msg = context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_, valueSetUrl);
      operationOutcome = new OperationOutcome();
      OperationOutcome.OperationOutcomeIssueComponent issue = operationOutcome.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(OperationOutcome.IssueType.NOTFOUND);
      issue.addExtension(ExtensionDefinitions.EXT_ISSUE_MSG_ID, new StringType(I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_));
      CodeableConcept codeableConceptWhenNullValueSet = issue.getDetails();
      codeableConceptWhenNullValueSet.addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "not-found", null);
      codeableConceptWhenNullValueSet.setText(msg);
    } else {
      ValidationOptions options = new ValidationOptions(FhirPublication.R5);
      boolean inferSystem = valueSet != null;
      if (p.hasParameter("displayLanguage")) {
        options = options.withLanguage(p.getParameterString("displayLanguage"));
      } else if (lang != null ) {
        options = options.withLanguage(lang);
      }
      if (p.hasParameter("valueset-membership-only") && "true".equals(p.getParameterString("valueset-membership-only"))) {
        options = options.withCheckValueSetOnly();
      }
      if (p.hasParameter("lenient-display-validation") && "true".equals(p.getParameterString("lenient-display-validation"))) {
        options = options.setDisplayWarningMode(true);
      }
      if (p.hasParameter("activeOnly") && "true".equals(p.getParameterString("activeOnly"))) {
        options = options.setActiveOnly(true);
      }
      if (p.hasParameter("abstract") && "false".equals(p.getParameterString("abstract"))) {
        options = options.setNoAbstract(true);
      }
      Parameters newParameters = context.getExpansionParameters();
      for (Parameters.ParametersParameterComponent pp : p.getParameterList()) {
        if (Utilities.existsInList(pp.getName(), "default-valueset-version", "system-version", "force-system-version", "default-system-version")) {
          newParameters.getParameterList().add(pp);
        }
      }
      newParameters.clearParameters("includeAlternateCodes");
      for (Parameters.ParametersParameterComponent pp : p.getParameterList()) {
        if ("includeAlternateCodes".equals(pp.getName())) {
          newParameters.addParameter(pp.copy(Base.COPY_NOTHING));
        }
        if ("useSupplement".equals(pp.getName())) {
          newParameters.addParameter(pp.copy(Base.COPY_NOTHING));
        }
      }
      context.getManager().setExpansionParameters(newParameters);
      if (p.hasParameter("code")) {
        code = p.getParameterString("code");
        system = p.getParameterString(isCodeSystem ? "url" : "system");
        version = p.getParameterString(isCodeSystem ? "version" : "systemVersion");
        display = p.getParameterString("display");
        validationResult = context.validateCode(inferSystem ? options.withGuessSystem() : options,
          p.getParameterString(isCodeSystem ? "url" : "system"), p.getParameterString(isCodeSystem ? "version" : "systemVersion"),
          p.getParameterString("code"), p.getParameterString("display"), valueSet);
      } else if (p.hasParameter("coding")) {
        Coding coding = (Coding) p.getParameterValue("coding");
        code = coding.getCode();
        system = coding.getSystem();
        version = coding.getVersion();
        display = coding.getDisplay();
        validationResult = context.validateCode(options, coding, valueSet);
      } else if (p.hasParameter("codeableConcept")) {
        codeableConcept = (CodeableConcept) p.getParameterValue("codeableConcept");
        validationResult = context.validateCode(options, codeableConcept, valueSet);
      } else {
        throw new Error("validate not done yet for this steup");
      }
    }
    if (operationOutcome == null && validationResult != null && validationResult.getSeverity() == org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.FATAL) {
      operationOutcome = new OperationOutcome();
      operationOutcome.getIssueList().addAll(validationResult.getIssues());
    }
    if (operationOutcome != null) {
      TxTesterSorters.sortOperationOutcome(operationOutcome);
      TxTesterScrubbers.scrubOperationOutcome(operationOutcome, false);

      String actualResponse = new JsonParser(context.getModelContext()).setOutputStyle(OutputStyle.PRETTY).composeString(operationOutcome);


      boolean option2 = false;
      String diff = new CompareUtilities(modes, externals, vars()).checkJsonSrcIsSame(id, expectedResponse, actualResponse);
      if (diff != null && expectedResponse2 != null) {
        diff = new CompareUtilities(modes, externals, vars()).checkJsonSrcIsSame(id, expectedResponse2, actualResponse);
        if (diff == null) {
          option2 = true;
        }
      }

      writeDiffToFileSystem( name, option2 ? expectedResponse2 : expectedResponse, actualResponse);

      if (diff != null) {
        FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fp));
        FileUtilities.stringToFile(actualResponse, fp);
        log.error("Test "+name+" failed: "+diff);
      }
      return diff;
    } else {
      if (parameters == null) {
        parameters = new org.hl7.fhir.model.core.Parameters();
        if (validationResult.getSystem() != null) {
          parameters.addParameter("system", new UriType(validationResult.getSystem()));
        } else if (system != null) {
          parameters.addParameter("system", new UriType(system));
        }
        if (validationResult.getCode() != null) {
          if (code != null && !code.equals(validationResult.getCode())) {
            parameters.addParameter("code", new CodeType(code));
            parameters.addParameter("normalized-code", new CodeType(validationResult.getCode()));
          } else {
            parameters.addParameter("code", new CodeType(validationResult.getCode()));
          }
        } else if (code != null) {
          parameters.addParameter("code", new CodeType(code));
        }
        parameters.addParameter("result", isValidated(validationResult));
        if (validationResult.getMessage() != null) {
          parameters.addParameter("message", validationResult.getMessage());
        }
        if (validationResult.getVersion() != null) {
          parameters.addParameter("version", validationResult.getVersion());
        }
        if (validationResult.getDisplay() != null) {
          parameters.addParameter("display", validationResult.getDisplay());
        }
        if (codeableConcept != null) {
          parameters.addParameter("codeableConcept", codeableConcept);
        }
        if (validationResult.isInactive()) {
          parameters.addParameter("inactive", true);
        }
        if (validationResult.getStatus() != null) {
          parameters.addCodeParameter("status", validationResult.getStatus());
        }
        if (validationResult.getUnknownSystems() != null) {
          for (String s : validationResult.getUnknownSystems()) {
            parameters.addParameter(validationResult.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED ? "x-caused-by-unknown-system" :  "x-unknown-system", new CanonicalType(s));
          }
        }
        if (validationResult.getIssues().size() > 0) { 
          operationOutcome = new OperationOutcome();
          operationOutcome.getIssueList().addAll(validationResult.getIssues());
          parameters.addParameter().setName("issues").setResource(operationOutcome);
        }
      }

      TxTesterSorters.sortParameters(parameters);
      TxTesterScrubbers.scrubParameters(parameters, false);

      String actualResponse = new JsonParser(context.getModelContext()).setOutputStyle(OutputStyle.PRETTY).composeString(parameters);

      boolean option2 = false;
      String diff = new CompareUtilities(modes, externals, vars()).checkJsonSrcIsSame(id, expectedResponse, actualResponse);
      if (diff != null && expectedResponse2 != null) {
        diff = new CompareUtilities(modes, externals, vars()).checkJsonSrcIsSame(id, expectedResponse2, actualResponse);
        if (diff == null) {
          option2 = true;
        }
      }

      writeDiffToFileSystem(name, option2 ? expectedResponse2 : expectedResponse, actualResponse);

      if (diff != null) {
         FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fp));
        FileUtilities.stringToFile(actualResponse, fp);
        log.error("Test "+name+" failed: "+diff);
      }
      return diff;
    }
  }


  /**
   * result = true means the server validated the code, not merely that it found nothing wrong.
   * An invalid-data issue (no code, no system) says the server could not validate what it was
   * given, and that is a negative result even though the issue is only a warning. Where a code was
   * established anyway - a CodeableConcept with one bad coding and one good one - the result stands.
   */
  private static boolean isValidated(ValidationResult validationResult) {
    if (validationResult.getSeverity() == org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.ERROR) {
      return false;
    }
    if (validationResult.getCode() == null) {
      for (OperationOutcome.OperationOutcomeIssueComponent iss : validationResult.getIssues()) {
        if (iss.hasDetails()) {
          for (Coding c : iss.getDetails().getCodingList()) {
            if ("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type".equals(c.getSystem()) && "invalid-data".equals(c.getCode())) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }

  /**
   * The operation parameters have to add up to something to validate before any of this is worth
   * doing: a request with no code, coding or codeableConcept asks nothing, and a code with no
   * system (and no inferSystem) names nothing. A server reports these from its operation layer,
   * as a 4xx with an OperationOutcome, before its terminology engine ever sees them. There is no
   * HTTP layer here and no API to report it through, so the tester answers them itself rather
   * than making the terminology engine invent a way to say "your request was malformed"
   */
  private static OperationOutcome checkRequest(org.hl7.fhir.model.core.Parameters p, boolean isCodeSystem) {
    String msg;
    if (p.hasParameter("coding") || p.hasParameter("codeableConcept")) {
      return null;
    } else if (!p.hasParameter("code")) {
      msg = "No code to validate: the request has no code, coding or codeableConcept parameter";
    } else if (!p.hasParameter(isCodeSystem ? "url" : "system") && !p.getParameterBool("inferSystem")) {
      msg = "No system for the code to validate: the request has a code, but no "+(isCodeSystem ? "url" : "system")+" parameter, and did not ask for the system to be inferred";
    } else {
      return null;
    }
    OperationOutcome operationOutcome = new OperationOutcome();
    OperationOutcome.OperationOutcomeIssueComponent issue = operationOutcome.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(OperationOutcome.IssueType.INVALID);
    CodeableConcept details = issue.getDetails();
    details.addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "invalid-data", null);
    details.setText(msg);
    return operationOutcome;
  }

  public static void writeDiffToFileSystem(String testName, String expected, String actual) throws IOException {
    String rootDirectory = System.getenv("TX_SERVICE_TEST_DIFF_TARGET");
    if (rootDirectory == null || rootDirectory.isEmpty()) {
      return;
    }
    String fullExpected = rootDirectory + "/expected/";
    String fullActual = rootDirectory + "/actual/";
    File expectedDirectory = ManagedFileAccess.file(fullExpected);
    if (!expectedDirectory.exists()) {
      expectedDirectory.mkdirs();
    }

    File actualDirectory = ManagedFileAccess.file(fullActual);
    if (!actualDirectory.exists()) {
      actualDirectory.mkdirs();
    }
    FileUtilities.stringToFile(expected, fullExpected + testName + ".json");
    FileUtilities.stringToFile(actual, fullActual + testName + ".json");

  }


  private static Map<String, String> vars() {
    Map<String, String> vars = new HashMap<String, String>();
    vars.put("version", "5.0.0");
    return vars;

  }
}
