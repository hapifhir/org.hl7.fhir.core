package org.hl7.fhir.terminology.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
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
    testData = new TxTestData();
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
    if (baseEngine == null) {
      baseEngine = TestUtilities.getValidationEngineNoTxServer("hl7.fhir.r5.core#5.0.0", FhirPublication.R5, "5.0.0");
    }
    ValidationEngine engine = new ValidationEngine(this.baseEngine);
    for (String s : setup.getSuite().forceArray("setup").asStrings()) {
      // System.out.println(s);
      Resource res = loadResource(s);
      engine.seeResource(res);
    }
    Resource req = loadResource(setup.getTest().asString("request"));
    String fn = setup.getTest().has("response:tx.fhir.org") ? setup.getTest().asString("response:tx.fhir.org") : setup.getTest().asString("response");
    String resp = TestingUtilities.loadTestResource("tx", fn);
    String fp = Utilities.path("[tmp]", "tx", fn);
    JsonObject ext = testData.getExternals() == null ? null : testData.getExternals().getJsonObject(fn);
    File fo = new File(fp);
    if (fo.exists()) {
      fo.delete();
    }
    if (setup.getTest().has("profile")) {
      engine.getContext().setExpansionParameters((org.hl7.fhir.r5.model.Parameters) loadResource(setup.getTest().asString("profile")));
    } else {
      engine.getContext().setExpansionParameters((org.hl7.fhir.r5.model.Parameters) loadResource("parameters-default.json"));
    }
    if (setup.getTest().asString("operation").equals("expand")) {
      expand(engine, req, resp, setup.getTest().asString("Content-Language"), fp, ext);
    } else if (setup.getTest().asString("operation").equals("validate-code")) {
      String diff = TxServiceTestHelper.getDiffForValidation(engine.getContext(), setup.getTest().asString("name"), req, resp, setup.getTest().asString("Content-Language"), fp, ext, false);
      assertNull(diff, diff);
    } else if (setup.getTest().asString("operation").equals("cs-validate-code")) {
      String diff = TxServiceTestHelper.getDiffForValidation(engine.getContext(), setup.getTest().asString("name"), req, resp, setup.getTest().asString("Content-Language"), fp, ext, true);
      assertNull(diff, diff);
    } else {
      Assertions.fail("Unknown Operation "+ setup.getTest().asString("operation"));
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
    ValueSetExpansionOutcome vse = engine.getContext().expandVS(vs, false, hierarchical, false, p, true);
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