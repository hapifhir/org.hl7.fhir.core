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
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.terminology.tests.TerminologyServiceTests.JsonObjectPair;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.ValidationEngineTests;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Charsets;



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

    Map<String, JsonObjectPair> examples = new HashMap<String, JsonObjectPair>();
    manifest = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(contents);
    for (org.hl7.fhir.utilities.json.model.JsonObject suite : manifest.getJsonObjects("suites")) {
      String sn = suite.asString("name");
      for (org.hl7.fhir.utilities.json.model.JsonObject test : suite.getJsonObjects("tests")) {
        String tn = test.asString("name");
        examples.put(sn+"."+tn, new JsonObjectPair(suite, test));
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
      baseEngine = TestUtilities.getValidationEngine("hl7.fhir.r5.core#5.0.0", ValidationEngineTests.DEF_TX, null, FhirPublication.R5, true, "5.0.0");
    }
    ValidationEngine engine = new ValidationEngine(this.baseEngine);
    for (String s : setup.suite.forceArray("setup").asStrings()) {
      Resource res = loadResource(s);
      engine.seeResource(res);
    }
    Resource req = loadResource(setup.test.asString("request"));
    String resp = TestingUtilities.loadTestResource("tx", setup.test.asString("response"));
    if (setup.test.asString("operation").equals("expand")) {
      expand(engine, req, resp, setup.test.asString("response"));
    } else if (setup.test.asString("operation").equals("validate-code")) {
      validate(engine, req, resp);      
    } else {
      Assertions.fail("Unknown Operation "+setup.test.asString("operation"));
    }
  }

  private void expand(ValidationEngine engine, Resource req, String resp, String fn) throws IOException {
    String fp = Utilities.path("[tmp]", "tx", fn);
    File fo = new File(fp);
    if (fo.exists()) {
      fo.delete();
    }
    
    org.hl7.fhir.r5.model.Parameters p = ( org.hl7.fhir.r5.model.Parameters) req;
    ValueSet vs = engine.getContext().fetchResource(ValueSet.class, p.getParameterValue("url").primitiveValue());
    boolean hierarchical = p.hasParameter("excludeNested") ? p.getParameterBool("excludeNested") == false : true;
    Assertions.assertNotNull(vs);
    ValueSetExpansionOutcome vse = engine.getContext().expandVS(vs, false, hierarchical, false, p);
    if (resp.contains("\"ValueSet\"")) {
      if (vse.getValueset() == null) {
        Assertions.fail(vse.getError());
      } else {
        if (!p.hasParameter("excludeNested")) {
          removeParameter(vse.getValueset(), "excludeNested");
        }
        String vsj = new JsonParser().setOutputStyle(OutputStyle.PRETTY).composeString(vse.getValueset());
        String diff = CompareUtilities.checkJsonSrcIsSame(resp, vsj);
        if (diff != null) {
          Utilities.createDirectory(Utilities.getDirectoryForFile(fp));
          TextFile.stringToFile(vsj, fp);        
        }
        Assertions.assertTrue(diff == null, diff);
      }
    } else {
      Assertions.fail("expand error not done yet");
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

  private void validate(ValidationEngine engine2, Resource req, String resp) {
    Assertions.fail("validate not done yet");
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