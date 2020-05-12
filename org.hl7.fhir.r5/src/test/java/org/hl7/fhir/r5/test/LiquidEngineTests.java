package org.hl7.fhir.r5.test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.collections4.map.HashedMap;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.LiquidEngine;
import org.hl7.fhir.r5.utils.LiquidEngine.ILiquidEngineIcludeResolver;
import org.hl7.fhir.r5.utils.LiquidEngine.LiquidDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LiquidEngineTests implements ILiquidEngineIcludeResolver {

  private static Map<String, Resource> resources = new HashedMap<>();
  private static JsonObject testdoc = null;

  private JsonObject test;
  private LiquidEngine engine;

  @BeforeEach
  public void setUp() throws Exception {
    engine = new LiquidEngine(TestingUtilities.context(), null);
    engine.setIncludeResolver(this);
  }

  public static Stream<Arguments> data() throws ParserConfigurationException, SAXException, IOException {
    testdoc = (JsonObject) new com.google.gson.JsonParser().parse(TestingUtilities.loadTestResource("r5", "liquid", "liquid-tests.json"));
    JsonArray tests = testdoc.getAsJsonArray("tests");
    List<Arguments> objects = new ArrayList<>();
    for (JsonElement n : tests) {
      objects.add(Arguments.of(n));
    }
    return objects.stream();
  }

  @ParameterizedTest(name = "{index}: file{0}")
  @MethodSource("data")
  public void test(JsonObject test) throws Exception {
    this.test = test;
    LiquidDocument doc = engine.parse(test.get("template").getAsString(), "test-script");
    String output = engine.evaluate(doc, loadResource(), null);
    Assertions.assertTrue(test.get("output").getAsString().equals(output));
  }

  @Override
  public String fetchInclude(LiquidEngine engine, String name) {
    if (test.has("includes") && test.getAsJsonObject("includes").has(name))
      return test.getAsJsonObject("includes").get(name).getAsString();
    else
      return null;
  }

  private Resource loadResource() throws IOException, FHIRFormatError {
    String name = test.get("focus").getAsString();
    if (!resources.containsKey(name)) {
      resources.put(name, new XmlParser().parse(TestingUtilities.loadTestResourceStream("r5", (name.replace("/", "-") + ".xml").toLowerCase())));
    }
    return resources.get(test.get("focus").getAsString());
  }

}