package org.hl7.fhir.validation.special;

import com.google.gson.JsonSyntaxException;
import lombok.Getter;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.validation.ValidationOptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TxServiceTestHelper {


  public static class TestSetup {
    public TestSetup(JsonObject suite, JsonObject test) {
      this.suite = suite;
      this.test = test;
    }
    @Getter
    private JsonObject suite;
    @Getter
    private JsonObject test;

  }

  public static class TestData {

    @Getter
    private final JsonObject manifest;

    @Getter
    private final JsonObject externals;

    @Getter
    private final List<Object[]> testData;

    public TestData() throws IOException {
      String contents = TestingUtilities.loadTestResource("tx", "test-cases.json");
      String externalSource = TestingUtilities.loadTestResource("tx", "messages-tx.fhir.org.json");
      externals = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(externalSource);

      Map<String, TestSetup> examples = new HashMap<String, TestSetup>();
      manifest = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(contents);
      for (org.hl7.fhir.utilities.json.model.JsonObject suite : manifest.getJsonObjects("suites")) {
        if (!"tx.fhir.org".equals(suite.asString("mode"))) {
          String sn = suite.asString("name");
          for (org.hl7.fhir.utilities.json.model.JsonObject test : suite.getJsonObjects("tests")) {
            String tn = test.asString("name");
            examples.put(sn+"."+tn, new TestSetup(suite, test));
          }
        }
      }

      List<String> names = new ArrayList<String>(examples.size());
      names.addAll(examples.keySet());
      Collections.sort(names);

      testData = new ArrayList<Object[]>(examples.size());
      for (String id : names) {
        testData.add(new Object[]{id, examples.get(id)});
      }
    }
  }

  public static String getDiffForValidation(IWorkerContext context, String name, Resource req, String resp, String lang, String fp, JsonObject ext, boolean isCS) throws JsonSyntaxException, FileNotFoundException, IOException {
    org.hl7.fhir.r5.model.Parameters p = (org.hl7.fhir.r5.model.Parameters) req;
    ValueSet vs = null;
    String vsurl = null;
    if (!isCS) {
      if (p.hasParameter("valueSetVersion")) {
        vsurl = p.getParameterValue("url").primitiveValue()+"|"+p.getParameterValue("valueSetVersion").primitiveValue();
        vs = context.fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue(), p.getParameterValue("valueSetVersion").primitiveValue());
      } else {
        vsurl = p.getParameterValue("url").primitiveValue();
        vs = context.fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue());
      }
    }
    ValidationResult vm = null;
    String code = null;
    String system = null;
    String version = null;
    String display = null;
    CodeableConcept cc = null;
    org.hl7.fhir.r5.model.Parameters res = null;
    OperationOutcome oo = null;

    if (vs == null && vsurl != null) {
      String msg = context.formatMessage(I18nConstants.UNABLE_TO_RESOLVE_VALUE_SET_, vsurl);
      oo = new OperationOutcome();
      CodeableConcept cct = oo.addIssue().setSeverity(OperationOutcome.IssueSeverity.ERROR).setCode(OperationOutcome.IssueType.NOTFOUND).getDetails();
      cct.addCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "not-found", null);
      cct.setText(msg);
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
      context.getExpansionParameters().clearParameters("includeAlternateCodes");
      for (Parameters.ParametersParameterComponent pp : p.getParameter()) {
        if ("includeAlternateCodes".equals(pp.getName())) {
          context.getExpansionParameters().addParameter(pp.copy());
        }
      }
      if (p.hasParameter("code")) {
        code = p.getParameterString("code");
        system = p.getParameterString(isCS ? "url" : "system");
        version = p.getParameterString(isCS ? "version" : "systemVersion");
        display = p.getParameterString("display");
        vm = context.validateCode(options.withGuessSystem(),
          p.getParameterString(isCS ? "url" : "system"), p.getParameterString(isCS ? "version" : "systemVersion"),
          p.getParameterString("code"), p.getParameterString("display"), vs);
      } else if (p.hasParameter("coding")) {
        Coding coding = (Coding) p.getParameterValue("coding");
        code = coding.getCode();
        system = coding.getSystem();
        version = coding.getVersion();
        display = coding.getDisplay();
        vm = context.validateCode(options, coding, vs);
      } else if (p.hasParameter("codeableConcept")) {
        cc = (CodeableConcept) p.getParameterValue("codeableConcept");
        vm = context.validateCode(options, cc, vs);
      } else {
        throw new Error("validate not done yet for this steup");
      }
    }
    if (oo == null && vm != null && vm.getSeverity() == org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.FATAL) {
      oo = new OperationOutcome();
      oo.getIssue().addAll(vm.getIssues());
    }
    if (oo != null) {
      TxTesterSorters.sortOperationOutcome(oo);
      TxTesterScrubbers.scrubOO(oo, false);

      String pj = new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).composeString(oo);
      String diff = CompareUtilities.checkJsonSrcIsSame(resp, pj, ext);
      if (diff != null) {
        Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
        TextFile.stringToFile(pj, fp);
        System.out.println("Test "+name+"failed: "+diff);
      }
      return diff;
    } else {
      if (res == null) {
        res = new org.hl7.fhir.r5.model.Parameters();
        if (vm.getSystem() != null) {
          res.addParameter("system", new UriType(vm.getSystem()));
        } else if (system != null) {
          res.addParameter("system", new UriType(system));
        }
        if (vm.getCode() != null) {
          if (code != null && !code.equals(vm.getCode())) {
            res.addParameter("code", new CodeType(code));
            res.addParameter("normalized-code", new CodeType(vm.getCode()));
          } else {
            res.addParameter("code", new CodeType(vm.getCode()));
          }
        } else if (code != null) {
          res.addParameter("code", new CodeType(code));
        }
        if (vm.getSeverity() == org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.ERROR) {
          res.addParameter("result", false);
        } else {
          res.addParameter("result", true);
        }
        if (vm.getMessage() != null) {
          res.addParameter("message", vm.getMessage());
        }
        if (vm.getVersion() != null) {
          res.addParameter("version", vm.getVersion());
        } else if (version != null) {
          res.addParameter("version", new StringType(version));
        }
        if (vm.getDisplay() != null) {
          res.addParameter("display", vm.getDisplay());
        } else if (display != null) {
          res.addParameter("display", new StringType(display));
        }
        //      if (vm.getCodeableConcept() != null) {
        //        res.addParameter("codeableConcept", vm.getCodeableConcept());
        //      } else
        if (cc != null) {
          res.addParameter("codeableConcept", cc);
        }
        if (vm.isInactive()) {
          res.addParameter("inactive", true);
        }
        if (vm.getStatus() != null) {
          res.addParameter("status", vm.getStatus());
        }
        if (vm.getUnknownSystems() != null) {
          for (String s : vm.getUnknownSystems()) {
            res.addParameter(vm.getErrorClass() == TerminologyServiceErrorClass.CODESYSTEM_UNSUPPORTED ? "x-caused-by-unknown-system" :  "x-unknown-system", new CanonicalType(s));
          }
        }
        if (vm.getIssues().size() > 0) {
          oo = new OperationOutcome();
          oo.getIssue().addAll(vm.getIssues());
          res.addParameter().setName("issues").setResource(oo);
        }
      }

      TxTesterSorters.sortParameters(res);
      TxTesterScrubbers.scrubParams(res);

      String pj = new JsonParser().setOutputStyle(IParser.OutputStyle.PRETTY).composeString(res);
      String diff = CompareUtilities.checkJsonSrcIsSame(resp, pj, ext);
      if (diff != null) {
        Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
        TextFile.stringToFile(pj, fp);
        System.out.println("Test "+name+"failed: "+diff);
      }
      return diff;
    }
  }
}
