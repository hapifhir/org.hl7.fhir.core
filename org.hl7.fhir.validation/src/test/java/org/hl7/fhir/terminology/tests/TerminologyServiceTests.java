package org.hl7.fhir.terminology.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Parameters.ParametersParameterComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.UriType;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.special.TxTesterScrubbers;
import org.hl7.fhir.validation.special.TxTesterSorters;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Charsets;
import com.google.gson.JsonSyntaxException;



@RunWith(Parameterized.class)
public class TerminologyServiceTests {

  public static class JsonObjectPair {
    public JsonObjectPair(JsonObject suite, JsonObject test) {
      this.suite = suite;
      this.test = test;
    }
    private JsonObject suite;
    private JsonObject test;
  }

  @Parameters(name = "{index}: id {0}")
  public static Iterable<Object[]> data() throws IOException {

    String contents = TestingUtilities.loadTestResource("tx", "test-cases.json");
    String externalSource = TestingUtilities.loadTestResource("tx", "messages-tx.fhir.org.json");
    externals = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(externalSource);

    Map<String, JsonObjectPair> examples = new HashMap<String, JsonObjectPair>();
    manifest = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(contents);
    for (org.hl7.fhir.utilities.json.model.JsonObject suite : manifest.getJsonObjects("suites")) {
      if (!"tx.fhir.org".equals(suite.asString("mode"))) {
        String sn = suite.asString("name");
        for (org.hl7.fhir.utilities.json.model.JsonObject test : suite.getJsonObjects("tests")) {
          String tn = test.asString("name");
          examples.put(sn+"."+tn, new JsonObjectPair(suite, test));
        }
      }
    }

    List<String> names = new ArrayList<String>(examples.size());
    names.addAll(examples.keySet());
    Collections.sort(names);

    List<Object[]> objects = new ArrayList<Object[]>(examples.size());
    for (String id : names) {
      objects.add(new Object[]{id, examples.get(id)});
    }
    return objects;
  }

  private static org.hl7.fhir.utilities.json.model.JsonObject manifest;
  private static org.hl7.fhir.utilities.json.model.JsonObject externals;
  private JsonObjectPair setup;
  private String version;
  private String name;


  private static ValidationEngine baseEngine;

  public TerminologyServiceTests(String name, JsonObjectPair setup) {
    this.name = name;
    this.setup = setup;
    version = "5.0.0";
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    if (baseEngine == null) {
      baseEngine = TestUtilities.getValidationEngineNoTxServer("hl7.fhir.r5.core#5.0.0", FhirPublication.R5, "5.0.0");
    }
    ValidationEngine engine = new ValidationEngine(this.baseEngine);
    for (String s : setup.suite.forceArray("setup").asStrings()) {
      // System.out.println(s);
      Resource res = loadResource(s);
      engine.seeResource(res);
    }
    Resource req = loadResource(setup.test.asString("request"));
    String fn = setup.test.has("response:tx.fhir.org") ? setup.test.asString("response:tx.fhir.org") : setup.test.asString("response");
    String resp = TestingUtilities.loadTestResource("tx", fn);
    String fp = Utilities.path("[tmp]", "tx", fn);
    JsonObject ext = externals == null ? null : externals.getJsonObject(fn);
    File fo = new File(fp);
    if (fo.exists()) {
      fo.delete();
    }
    if (setup.test.has("profile")) {
      engine.getContext().setExpansionParameters((org.hl7.fhir.r5.model.Parameters) loadResource(setup.test.asString("profile")));
    } else {
      engine.getContext().setExpansionParameters((org.hl7.fhir.r5.model.Parameters) loadResource("parameters-default.json"));
    }
    if (setup.test.asString("operation").equals("expand")) {
      expand(engine, req, resp, setup.test.asString("Content-Language"), fp, ext);
    } else if (setup.test.asString("operation").equals("validate-code")) {
      validate(engine, setup.test.asString("name"), req, resp, setup.test.asString("Content-Language"), fp, ext, false);      
    } else if (setup.test.asString("operation").equals("cs-validate-code")) {
      validate(engine, setup.test.asString("name"), req, resp, setup.test.asString("Content-Language"), fp, ext, true);      
    } else {
      Assertions.fail("Unknown Operation "+setup.test.asString("operation"));
    }
  }

  private void expand(ValidationEngine engine, Resource req, String resp, String lang, String fp, JsonObject ext) throws IOException {
    org.hl7.fhir.r5.model.Parameters p = ( org.hl7.fhir.r5.model.Parameters) req;
    ValueSet vs = engine.getContext().fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue());
    boolean hierarchical = p.hasParameter("excludeNested") ? p.getParameterBool("excludeNested") == false : true;
    Assertions.assertNotNull(vs);
    if (lang != null && !p.hasParameter("displayLanguage")) {
      p.addParameter("displayLanguage", new CodeType(lang));
    }
    ValueSetExpansionOutcome vse = engine.getContext().expandVS(vs, false, hierarchical, false, p);
    if (resp.contains("\"ValueSet\"")) {
      if (vse.getValueset() == null) {
        Assertions.fail(vse.getError());
      } else {
        if (!p.hasParameter("excludeNested")) {
          removeParameter(vse.getValueset(), "excludeNested");
        }
        TxTesterSorters.sortValueSet(vse.getValueset());
        TxTesterScrubbers.scrubVS(vse.getValueset(), false);
        String vsj = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(vse.getValueset());
        String diff = CompareUtilities.checkJsonSrcIsSame(resp, vsj, ext);
        if (diff != null) {
          Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
          TextFile.stringToFile(vsj, fp);        
        }
        Assertions.assertTrue(diff == null, diff);
      }
    } else {
      OperationOutcome oo = new OperationOutcome();
      OperationOutcomeIssueComponent e = new OperationOutcomeIssueComponent();
      e.setSeverity(IssueSeverity.ERROR);
      switch (vse.getErrorClass()) {
      case BLOCKED_BY_OPTIONS:
        e.setCode(IssueType.FORBIDDEN);
        break;
      case BUSINESS_RULE:
        e.setCode(IssueType.BUSINESSRULE);
        break;
      case CODESYSTEM_UNSUPPORTED:
        e.setCode(IssueType.CODEINVALID);
        break;
      case INTERNAL_ERROR:
        e.setCode(IssueType.EXCEPTION);
        break;
      case NOSERVICE:
        e.setCode(IssueType.CONFLICT);
        break;
      case SERVER_ERROR:
        e.setCode(IssueType.EXCEPTION);
        break;
      case TOO_COSTLY:
        e.setCode(IssueType.TOOCOSTLY);
        break;
      case PROCESSING:
        e.setCode(IssueType.PROCESSING);
        break;
      case UNKNOWN:
        e.setCode(IssueType.UNKNOWN);
        break;
      case VALUESET_UNSUPPORTED:
        e.setCode(IssueType.NOTSUPPORTED);
        break;
      }
      e.getDetails().setText(vse.getError());
      oo.addIssue(e);
      TxTesterSorters.sortOperationOutcome(oo);
      TxTesterScrubbers.scrubOO(oo, false);

      String ooj = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
      String diff = CompareUtilities.checkJsonSrcIsSame(resp, ooj, ext);
      if (diff != null) {
        Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
        TextFile.stringToFile(ooj, fp);        
      }
      Assertions.assertTrue(diff == null, diff);
    }
  }

  private void removeParameter(ValueSet valueset, String name) {
    for (ValueSetExpansionParameterComponent exp : valueset.getExpansion().getParameter()) {
      if (exp.getName().equals(name)) {
        valueset.getExpansion().getParameter().remove(exp);
        return;
      }
    }
  }

  private void validate(ValidationEngine engine, String name, Resource req, String resp, String lang, String fp, JsonObject ext, boolean isCS) throws JsonSyntaxException, FileNotFoundException, IOException {
    org.hl7.fhir.r5.model.Parameters p = (org.hl7.fhir.r5.model.Parameters) req;
    ValueSet vs = null;
    if (!isCS) {
      if (p.hasParameter("valueSetVersion")) {
        vs = engine.getContext().fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue(), p.getParameterValue("valueSetVersion").primitiveValue());      
      } else {
        vs = engine.getContext().fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue());
      }
    }
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
    engine.getContext().getExpansionParameters().clearParameters("includeAlternateCodes");
    for (ParametersParameterComponent pp : p.getParameter()) {
      if ("includeAlternateCodes".equals(pp.getName())) {
        engine.getContext().getExpansionParameters().addParameter(pp.copy());
      }
    }
    ValidationResult vm;
    String code = null;
    String system = null;
    String version = null;
    String display = null;
    CodeableConcept cc = null;
    if (p.hasParameter("code")) {
      code = p.getParameterString("code");
      system = p.getParameterString(isCS ? "url" : "system");
      version = p.getParameterString(isCS ? "version" : "systemVersion"); 
      display = p.getParameterString("display"); 
      vm = engine.getContext().validateCode(options.withGuessSystem(), 
          p.getParameterString(isCS ? "url" : "system"), p.getParameterString(isCS ? "version" : "systemVersion"), 
          p.getParameterString("code"), p.getParameterString("display"), vs);
    } else if (p.hasParameter("coding")) {
      Coding coding = (Coding) p.getParameterValue("coding");
      code = coding.getCode();
      system = coding.getSystem();
      version = coding.getVersion();
      display = coding.getDisplay();
      vm = engine.getContext().validateCode(options, coding, vs);
    } else if (p.hasParameter("codeableConcept")) {
      cc = (CodeableConcept) p.getParameterValue("codeableConcept");
      vm = engine.getContext().validateCode(options, cc, vs);
    } else {
      throw new Error("validate not done yet for this steup");
    }
    if (vm.getSeverity() == org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.FATAL) {
      OperationOutcome oo = new OperationOutcome();
      oo.getIssue().addAll(vm.getIssues());
      TxTesterSorters.sortOperationOutcome(oo);
      TxTesterScrubbers.scrubOO(oo, false);
      
      String pj = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
      String diff = CompareUtilities.checkJsonSrcIsSame(resp, pj, ext);
      if (diff != null) {
        Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
        TextFile.stringToFile(pj, fp); 
        System.out.println("Test "+name+"failed: "+diff);
      }
      Assertions.assertTrue(diff == null, diff);
    } else {
      org.hl7.fhir.r5.model.Parameters res = new org.hl7.fhir.r5.model.Parameters();
      if (vm.getSystem() != null) {
        res.addParameter("system", new UriType(vm.getSystem()));
      } else if (system != null) {
        res.addParameter("system", new UriType(system));
      }
      if (vm.getCode() != null) {
        res.addParameter("code", new CodeType(vm.getCode()));
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
          res.addParameter("x-caused-by-unknown-system", new CanonicalType(s));
        }
      }
      if (vm.getIssues().size() > 0) {
        OperationOutcome oo = new OperationOutcome();
        oo.getIssue().addAll(vm.getIssues());
        res.addParameter().setName("issues").setResource(oo);
      }
      TxTesterSorters.sortParameters(res);
      TxTesterScrubbers.scrubParams(res);

      String pj = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(res);
      String diff = CompareUtilities.checkJsonSrcIsSame(resp, pj, ext);
      if (diff != null) {
        Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
        TextFile.stringToFile(pj, fp); 
        System.out.println("Test "+name+"failed: "+diff);
      }
      Assertions.assertTrue(diff == null, diff);
    }
  }

  public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    String contents = TestingUtilities.loadTestResource("tx", filename);
    try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
      if (filename.contains(".json")) {
        if (Constants.VERSION.equals(version) || "5.0".equals(version))
          return new JsonParser().parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
          return VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
          return VersionConvertorFactory_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
          return VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.JsonParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
          return VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.JsonParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + version);
      } else {
        if (Constants.VERSION.equals(version) || "5.0".equals(version))
          return new XmlParser().parse(inputStream);
        else if (org.hl7.fhir.dstu3.model.Constants.VERSION.equals(version) || "3.0".equals(version))
          return VersionConvertorFactory_30_50.convertResource(new org.hl7.fhir.dstu3.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2016may.model.Constants.VERSION.equals(version) || "1.4".equals(version))
          return VersionConvertorFactory_14_50.convertResource(new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.dstu2.model.Constants.VERSION.equals(version) || "1.0".equals(version))
          return VersionConvertorFactory_10_50.convertResource(new org.hl7.fhir.dstu2.formats.XmlParser().parse(inputStream));
        else if (org.hl7.fhir.r4.model.Constants.VERSION.equals(version) || "4.0".equals(version))
          return VersionConvertorFactory_40_50.convertResource(new org.hl7.fhir.r4.formats.XmlParser().parse(inputStream));
        else
          throw new FHIRException("unknown version " + version);
      }
    }
  }

  @AfterClass
  public static void saveWhenDone() throws IOException {

  }

}