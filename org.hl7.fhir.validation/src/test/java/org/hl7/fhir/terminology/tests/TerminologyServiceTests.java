package org.hl7.fhir.terminology.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.context.ExpansionOptions;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.terminologies.expansion.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.special.TxServiceTestHelper;
import org.hl7.fhir.validation.special.TxTestSetup;
import org.hl7.fhir.validation.special.TxTestData;
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

import static org.junit.Assert.assertNull;


@RunWith(Parameterized.class)
public class TerminologyServiceTests {


private static TxTestData testData;

  @Parameters(name = "{index}: id {0}")
  public static Iterable<Object[]> data() throws IOException {
    testData = TxTestData.loadTestDataFromPackage("hl7.fhir.uv.tx-ecosystem#dev");
    return testData.getTestData();
  }

  private final TxTestSetup setup;
  private final String version;
  private final String name;


  private static ValidationEngine baseEngine;

  public TerminologyServiceTests(String name, TxTestSetup setup) {
    this.name = name;
    this.setup = setup;
    version = "5.0.0";
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    if (setup.getSuite().asBoolean("disabled") || setup.getTest().asBoolean("disabled")) {
      return;
    }
    if (!passesModes(setup.getSuite()) || !passesModes(setup.getTest())) {
      return;
    }

    if (baseEngine == null) {
      baseEngine = TestUtilities.getValidationEngineNoTxServer("hl7.fhir.r5.core#5.0.0", "5.0.0");
    }

    ValidationEngine engine = new ValidationEngine(this.baseEngine);
    for (String s : setup.getSuite().forceArray("setup").asStrings()) {
      // System.out.println(s);
      Resource res = loadResource(s);
      engine.seeResource(res);
    }
    String reqFile = setup.getTest().asString("request");
    Resource req = reqFile == null ? null : loadResource(reqFile);
    String fn = setup.getTest().has("response:tx.fhir.org") ? setup.getTest().asString("response:tx.fhir.org") : setup.getTest().asString("response");
    String resp = testData.load(fn);
    String fp = Utilities.path("[tmp]", "tx", fn);
    JsonObject ext = testData.getExternals() == null ? null : testData.getExternals().getJsonObject(fn);
    File fo = ManagedFileAccess.file(fp);
    if (fo.exists()) {
      fo.delete();
    }

    if (setup.getTest().has("profile")) {
      engine.getContext().setExpansionParameters((org.hl7.fhir.r5.model.Parameters) loadResource(setup.getTest().asString("profile")));
    } else {
      engine.getContext().setExpansionParameters((org.hl7.fhir.r5.model.Parameters) loadResource("parameters-default.json"));
    }
    engine.getContext().setNoTerminologyServer(true);
    if (setup.getTest().asString("operation").equals("expand")) {
      expand(setup.getTest().str("name"), engine, req, resp, setup.getTest().asString("Accept-Language"), fp, ext);
    } else if (setup.getTest().asString("operation").equals("validate-code")) {
      String diff = TxServiceTestHelper.getDiffForValidation(setup.getTest().str("name"), engine.getContext(), setup.getTest().asString("name"), req, resp, setup.getTest().asString("Accept-Language"), fp, ext, false, modes());
      assertNull(diff, diff);
    } else if (setup.getTest().asString("operation").equals("cs-validate-code")) {
      String diff = TxServiceTestHelper.getDiffForValidation(setup.getTest().str("name"), engine.getContext(), setup.getTest().asString("name"), req, resp, setup.getTest().asString("Accept-Language"), fp, ext, true, modes());
      assertNull(diff, diff);
    } else if (Utilities.existsInList(setup.getTest().asString("operation"), "lookup", "translate", "metadata", "term-caps")) {
      Assertions.assertTrue(true); // we don't test these for the internal server
    } else if (!Utilities.existsInList(setup.getTest().asString("operation"), "batch-validate")) { // the internal terminologgy server doesn't implement this method
      Assertions.fail("Unknown Operation "+ setup.getTest().asString("operation"));
    }
  }

  private boolean passesModes(JsonObject obj) {
    Set<String> modes = new HashSet<>();
    modes.add("general");

    if (obj.has("modes")) {
      for (String mode : obj.getStrings("modes")) {
        if (modes.contains(mode)) {
          return true;
        }
      }
    }
    if (obj.has("mode")) {
      return modes.contains(obj.asString("mode"));
    }
    return true;

  }

  private void expand(String id, ValidationEngine engine, Resource req, String resp, String lang, String fp, JsonObject ext) throws IOException {
    org.hl7.fhir.r5.model.Parameters p = ( org.hl7.fhir.r5.model.Parameters) req;
    ValueSet vs;
    if (p.hasParameter("valueSetVersion")) {      
      vs = engine.getContext().fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue(), p.getParameterValue("valueSetVersion").primitiveValue());
    } else {
      vs = engine.getContext().fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue());
    }
    boolean hierarchical = p.hasParameter("excludeNested") ? p.getParameterBool("excludeNested") == false : true;
    Assertions.assertNotNull(vs);
    if (lang != null && !p.hasParameter("displayLanguage")) {
      p.addParameter("displayLanguage", new CodeType(lang));
    }
    ValueSetExpansionOutcome vse = engine.getContext().expandVS(new ExpansionOptions( false, hierarchical, 0, false, null), vs,p, true);
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
        String diff = new CompareUtilities(modes(), ext).checkJsonSrcIsSame(id, resp, vsj);
        if (diff != null) {
          FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fp));
          FileUtilities.stringToFile(vsj, fp);        
        }
        Assertions.assertTrue(diff == null, diff);
      }
    } else {
      OperationOutcome oo = new OperationOutcome();
      if (vse.getIssues() != null) {
        oo.getIssue().addAll(vse.getIssues());
      } else {
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
        case VALUESET_UNKNOWN:
          e.setCode(IssueType.NOTFOUND);
          e.getDetails().addCoding().setSystem("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type").setCode("not-found");
          break;
        case VALUESET_UNSUPPORTED:
          e.setCode(IssueType.NOTSUPPORTED);
          break;
        }
        e.getDetails().setText(vse.getError());
        oo.addIssue(e);
      }
      TxTesterSorters.sortOperationOutcome(oo);
      TxTesterScrubbers.scrubOO(oo, false);

      String ooj = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(oo);
      String diff = new CompareUtilities(modes(), ext).checkJsonSrcIsSame(id, resp, ooj);
      if (diff != null) {
        FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(fp));
        FileUtilities.stringToFile(ooj, fp);        
      }
      Assertions.assertTrue(diff == null, diff);
    }
  }

  private Set<String> modes() {
    Set<String> modes = new HashSet<String>();
    modes.add("tx.fhir.org");
    return modes;
  }

  private void removeParameter(ValueSet valueset, String name) {
    for (ValueSetExpansionParameterComponent exp : valueset.getExpansion().getParameter()) {
      if (exp.getName().equals(name)) {
        valueset.getExpansion().getParameter().remove(exp);
        return;
      }
    }
  }



  public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    String contents = testData.load(filename);
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