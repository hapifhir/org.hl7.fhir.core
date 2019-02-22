package org.hl7.fhir.r4.test;

import ca.uhn.fhir.context.FhirContext;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import junit.framework.Assert;
import org.apache.commons.collections4.map.HashedMap;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r4.formats.XmlParser;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.narrative.LiquidHostServices;
import org.hl7.fhir.r4.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.liquid.LiquidEngine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(Parameterized.class)
public class UtilitiesLiquidEngineTests implements LiquidEngine.ILiquidEngineIncludeResolver {

  private static Map<String, Resource> resources = new HashedMap<>();
  private static JsonObject testdoc = null;
  private static final FhirContext fhirContext = FhirContext.forR4();

  private JsonObject test;
  private LiquidEngine engine;

  @Parameters(name = "{index}: file{0}")
  public static Iterable<Object[]> data() throws ParserConfigurationException, SAXException, IOException {
    testdoc = (JsonObject) new com.google.gson.JsonParser().parse(new InputStreamReader(UtilitiesLiquidEngineTests.class.getResourceAsStream("/liquid/liquid-tests.json")));
    JsonArray tests = testdoc.getAsJsonArray("tests");
    List<Object[]> objects = new ArrayList<Object[]>(tests.size());
    for (JsonElement n : tests) {
      objects.add(new Object[] {n});
    }
    return objects;
  }

  public UtilitiesLiquidEngineTests(JsonObject test) {
    super();
    this.test = test;
  }

  @Before
  public void setUp() throws Exception {
    engine = new LiquidEngine(fhirContext);
    LiquidHostServices liquidHostServices = new LiquidHostServices(engine);
    liquidHostServices.setEnvironmentVariable("FHIR_VERSION", fhirContext.getVersion().getVersion().name());
    engine.setHostServices(liquidHostServices);
    engine.setIncludeResolver(this);
  }

  @Override
  public String fetchInclude(String name) {
    if (test.has("includes") && test.getAsJsonObject("includes").has(name))
      return test.getAsJsonObject("includes").get(name).getAsString();
    else
      return null;
  }

  private Resource loadResource() throws IOException, FHIRFormatError {
    String name = test.get("focus").getAsString();
    if (!resources.containsKey(name)) {
      String fn = TestingUtilities.resourceNameToFile(name.replace("/", "-")+".xml");
      resources.put(name, new XmlParser().parse(new FileInputStream(fn)));
    }
    return resources.get(test.get("focus").getAsString());
  }

  @Test
  public void test() throws Exception {
    LiquidEngine.LiquidDocument doc = engine.parse(test.get("template").getAsString(), "test-script");
    String output = engine.evaluate(doc, loadResource(), null);
    Assert.assertEquals(test.get("output").getAsString(), output);
  }

}
