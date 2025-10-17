package org.hl7.fhir.validation.special;

import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
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
import java.util.Set;

@Slf4j
public class TxServiceTestHelper {
  public static String getDiffForValidation(String id, IWorkerContext context, String name, Resource requestParameters, String expectedResponse, String lang, String fp, JsonObject externals, boolean isCodeSystem, Set<String> modes) throws JsonSyntaxException, FileNotFoundException, IOException {
    org.hl7.fhir.r5.model.Parameters p = (org.hl7.fhir.r5.model.Parameters) requestParameters;
    ValueSet valueSet = null;
    String valueSetUrl = null;
    if (!isCodeSystem) {
      if (p.hasParameter("valueSetVersion")) {
        valueSetUrl = p.getParameterValue("url").primitiveValue()+"|"+p.getParameterValue("valueSetVersion").primitiveValue();
        valueSet = context.fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue(), p.getParameterValue("valueSetVersion").primitiveValue(), null);
      } else {
        valueSetUrl = p.getParameterValue("url").primitiveValue();
        valueSet = context.fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue());
      }
    }
    ValidationResult validationResult = null;
    String code = null;
    String system = null;
    String version = null;
    String display = null;
    CodeableConcept codeableConcept = null;
    org.hl7.fhir.r5.model.Parameters parameters = null;
    OperationOutcome operationOutcome = null;

    if (valueSet == null && valueSetUrl != null) {
      String msg = context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_, valueSetUrl);
      operationOutcome = new OperationOutcome();
      OperationOutcome.OperationOutcomeIssueComponent issue = operationOutcome.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(OperationOutcome.IssueType.NOTFOUND);
      issue.addExtension(ExtensionDefinitions.EXT_ISSUE_MSG_ID, new StringType(I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_));
      CodeableConcept codeableConceptWhenNullValueSet = issue.getDetails();
      codeableConceptWhenNullValueSet.addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "not-found", null);
      codeableConceptWhenNullValueSet.setText(msg);
    } else {
      ValidationOptions options = new ValidationOptions(FhirPublication.R5);
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
      Parameters newParameters = context.getExpansionParameters();
      for (ParametersParameterComponent pp : p.getParameter()) {
        if (Utilities.existsInList(pp.getName(), "default-valueset-version", "system-version", "force-system-version", "default-system-version")) {
          //FIXME this is changing a reference to a copied object so breaks.
          newParameters.getParameter().add(pp);
        }
      }
      newParameters.clearParameters("includeAlternateCodes");
      for (Parameters.ParametersParameterComponent pp : p.getParameter()) {
        if ("includeAlternateCodes".equals(pp.getName())) {
          newParameters.addParameter(pp.copy());
        }
      }
      context.getManager().setExpansionParameters(newParameters);
      if (p.hasParameter("code")) {
        code = p.getParameterString("code");
        system = p.getParameterString(isCodeSystem ? "url" : "system");
        version = p.getParameterString(isCodeSystem ? "version" : "systemVersion");
        display = p.getParameterString("display");
        validationResult = context.validateCode(options.withGuessSystem(),
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
      operationOutcome.getIssue().addAll(validationResult.getIssues());
    }
    if (operationOutcome != null) {
      TxTesterSorters.sortOperationOutcome(operationOutcome);
      TxTesterScrubbers.scrubOO(operationOutcome, false);

      String actualResponse = new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).composeString(operationOutcome);



      writeDiffToFileSystem( name, expectedResponse, actualResponse);

      String diff = new CompareUtilities(modes, externals).checkJsonSrcIsSame(id, expectedResponse, actualResponse);
      if (diff != null) {
        FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fp));
        FileUtilities.stringToFile(actualResponse, fp);
        log.error("Test "+name+" failed: "+diff);
      }
      return diff;
    } else {
      if (parameters == null) {
        parameters = new org.hl7.fhir.r5.model.Parameters();
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
        if (validationResult.getSeverity() == org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.ERROR) {
          parameters.addParameter("result", false);
        } else {
          parameters.addParameter("result", true);
        }
        if (validationResult.getMessage() != null) {
          parameters.addParameter("message", validationResult.getMessage());
        }
        if (validationResult.getVersion() != null) {
          parameters.addParameter("version", validationResult.getVersion());
        }
        if (validationResult.getDisplay() != null) {
          parameters.addParameter("display", validationResult.getDisplay());
        } else if (display != null) {
          parameters.addParameter("display", new StringType(display));
        }
        //      if (vm.getCodeableConcept() != null) {
        //        res.addParameter("codeableConcept", vm.getCodeableConcept());
        //      } else
        if (codeableConcept != null) {
          parameters.addParameter("codeableConcept", codeableConcept);
        }
        if (validationResult.isInactive()) {
          parameters.addParameter("inactive", true);
        }
        if (validationResult.getStatus() != null) {
          parameters.addParameter("status", validationResult.getStatus());
        }
        if (validationResult.getUnknownSystems() != null) {
          for (String s : validationResult.getUnknownSystems()) {
            parameters.addParameter(validationResult.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED ? "x-caused-by-unknown-system" :  "x-unknown-system", new CanonicalType(s));
          }
        }
        if (validationResult.getIssues().size() > 0) { 
          operationOutcome = new OperationOutcome();
          operationOutcome.getIssue().addAll(validationResult.getIssues());
          parameters.addParameter().setName("issues").setResource(operationOutcome);
        }
      }

      TxTesterSorters.sortParameters(parameters);
      TxTesterScrubbers.scrubParams(parameters, false);

      String actualResponse = new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).composeString(parameters);

      writeDiffToFileSystem(name, expectedResponse, actualResponse);

      String diff = new CompareUtilities(modes, externals).checkJsonSrcIsSame(id, expectedResponse, actualResponse);
      if (diff != null) {
         FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fp));
        FileUtilities.stringToFile(actualResponse, fp);
        log.error("Test "+name+" failed: "+diff);
      }
      return diff;
    }
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
}
