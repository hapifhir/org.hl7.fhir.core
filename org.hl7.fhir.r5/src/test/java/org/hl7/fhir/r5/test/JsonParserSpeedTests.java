package org.hl7.fhir.r5.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;
import org.hl7.fhir.utilities.json.JsonTrackingParser.LocationData;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class JsonParserSpeedTests {

  private static final int MAX = 20;

  @Test
  public void testSpeed() throws IOException {
    String cnt = TestingUtilities.loadTestResource("r5", "structuredefinition-language.json");
    com.google.gson.JsonObject g = JsonTrackingParser.parse(cnt, null);
    JsonObject j = JsonParser.parseObject(cnt);
    JsonElement ge = new com.google.gson.JsonParser().parse(cnt);
    
    long t1 = 0;
    long t2 = 0;
    long t3 = 0;
    long t4 = 0;
    for (int k = 0; k < MAX; k++) {
      long l = System.currentTimeMillis();
      for (int i = 0; i < MAX; i++) {
        new com.google.gson.JsonParser().parse(cnt);
      }
      t4 = t4 + System.currentTimeMillis() - l;
      l = System.currentTimeMillis();
      for (int i = 0; i < MAX; i++) {
        JsonTrackingParser.parse(cnt, null);
      }
      t1 = t1 + System.currentTimeMillis() - l;
      l = System.currentTimeMillis();
      for (int i = 0; i < MAX; i++) {
        Map<JsonElement, LocationData> map = new HashMap<>();
        JsonTrackingParser.parse(cnt, map);
      }
      t2 = t2 + System.currentTimeMillis() - l;
      l = System.currentTimeMillis();
      for (int i = 0; i < MAX; i++) {
        JsonParser.parseObject(cnt);
      }
      t3 = t3 + System.currentTimeMillis() - l;
    }
    System.out.println("jtp- = "+t1);
    System.out.println("jtp+ = "+t2);
    System.out.println("jp = "+t3);
    System.out.println("gson = "+t4);
    
    Assertions.assertTrue(t1 > 0);
  }
}
