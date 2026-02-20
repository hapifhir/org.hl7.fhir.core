package org.hl7.fhir.terminology.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.VersionUtil;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.special.TxTestData;
import org.hl7.fhir.validation.special.TxTester;
import org.hl7.fhir.validation.special.TxTester.ITxTesterLoader;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.base.Charsets;

@RunWith(Parameterized.class)
public class ExternalTerminologyServiceTests implements ITxTesterLoader {

  public static class JsonObjectPair {
    public JsonObjectPair(JsonObject suite, JsonObject test) {
      this.suite = suite;
      this.test = test;
    }
    private JsonObject suite;
    private JsonObject test;
  }

  private static final String SERVER = FhirSettings.getTxFhirDevelopment()+"/r5";


  @Parameters(name = "{index}: id {0}")
  public static Iterable<Object[]> data() throws IOException {

    txtests = TxTestData.loadTestDataFromPackage("hl7.fhir.uv.tx-ecosystem#dev");

    String contents = txtests.load("test-cases.json");
    externals = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(txtests.load("messages-tx.fhir.org.json"));

    Map<String, JsonObjectPair> examples = new HashMap<String, JsonObjectPair>();
    manifest = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(contents);
    for (org.hl7.fhir.utilities.json.model.JsonObject suite : manifest.getJsonObjects("suites")) {
      if (!suite.has("version") || suite.asString("version").startsWith("5.0")) {
        String sn = suite.asString("name");
        for (org.hl7.fhir.utilities.json.model.JsonObject test : suite.getJsonObjects("tests")) {
          if (!test.has("version") || test.asString("version").startsWith("5.0")) {
            String tn = test.asString("name");
            examples.put(sn + "." + tn, new JsonObjectPair(suite, test));
          }
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
    objects.add(new Object[]{"final", null});
    return objects;
  }

  private static org.hl7.fhir.utilities.json.model.JsonObject manifest;
  private static org.hl7.fhir.utilities.json.model.JsonObject externals;
  private JsonObjectPair setup;
  private String version = "5.0.0";
  private static TxTester tester;
  private Set<String> modes = new HashSet<>();
  private static int error = 0;
  private static int skipped = 0;
  private static int count = 0;
  private static TxTestData txtests;

  public ExternalTerminologyServiceTests(String name, JsonObjectPair setup) {
    this.setup = setup;
    modes.add("tx.fhir.org");
    modes.add("omop");
    modes.add("general");
    modes.add("snomed");
  }

  @SuppressWarnings("deprecation")
  @Test
  public void test() throws Exception {
    if (setup == null) {
      if (error == 0) {
        System.out.println("tx.fhir.org passed all "+(count - skipped)+" HL7 terminology service tests (mode 'tx.fhir.org', tests v"+loadVersion()+", runner v"+VersionUtil.getBaseVersion()+")");
      } else {
        System.out.println("tx.fhir.org failed "+error+" of "+(count - skipped)+" HL7 terminology service tests (mode 'tx.fhir.org', tests v"+loadVersion()+", runner v"+VersionUtil.getBaseVersion()+")");
      }
      Assertions.assertTrue(error == 0);
    } else {
      count++;
      if (SERVER != null) {
        if (tester == null) {
          tester = new TxTester(this, SERVER, true, externals, "5.0.0");
        }

        if (setup.suite.asBoolean("disabled") || setup.test.asBoolean("disabled")) {
          return;
        }
        String err = tester.executeTest(this, setup.suite, setup.test, modes);
        if (err != null) {
          if ("n/a".equals(err)) {
            skipped++;
            err = null;
          } else {
            error++;
          }
        }
        Assertions.assertTrue(err == null, err);
      } else {
        Assertions.assertTrue(true);
      }
    }
  }

  private String loadVersion() throws JsonException, IOException {
    return txtests.loadVersion();
  }

  public Resource loadResource(String filename) throws IOException, FHIRFormatError, FileNotFoundException, FHIRException, DefinitionException {
    String contents = txtests.load(filename);
    try (InputStream inputStream = IOUtils.toInputStream(contents, Charsets.UTF_8)) {
      if (filename.contains(".json")) {
        return new JsonParser().parse(inputStream);
      } else {
        return new XmlParser().parse(inputStream);
      }
    }
  }

  @Override
  public String describe() {
    return "Test cases";
  }

  @Override
  public byte[] loadContent(String filename) throws FileNotFoundException, IOException {
    return txtests.loadBytes(filename);
  }

  @Override
  public boolean hasContent(String filename) throws IOException {
    return txtests.hasFile(filename);
  }

  @Override
  public String code() {
    return "external";
  }

  @Override
  public String version() throws JsonException, IOException {
    return txtests.loadVersion();
  }

  @Override
  public String testFileName() {
    return txtests.testFileName();
  }
}