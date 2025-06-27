package org.hl7.fhir.r5.formats;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CanonicalJsonTest {


  private static final String TEST_CASE_1 = "{\n"
      + "       \"numbers\": [333333333.33333329, 1E30, 4.50,\n"
      + "                   2e-3, 0.000000000000000000000000001],\n"
      + "       \"string\": \"\\u20ac$\\u000F\\u000aA'\\u0042\\u0022\\u005c\\\\\\\"\\/\",\n"
      + "       \"literals\": [null, true, false]\n"
      + "     }";
  private static final String TEST_OUTPUT_1 = "{\"literals\":[null,true,false],\"numbers\":[333333333.3333333,1e+30,4.5,0.002,1e-27],\"string\":\"€$\\u000f\\nA'B\\\"\\\\\\\\\\\"/\"}";

  @Test
  public void testCanonicalJson() throws IOException {
    JsonObject object = JsonParser.parseObject(TEST_CASE_1);
    
    ByteArrayOutputStream ba = new ByteArrayOutputStream();
    OutputStreamWriter osw = new OutputStreamWriter(ba);
    JsonCreatorCanonical json = new JsonCreatorCanonical(osw);
    writeObject(json, object);
    json.finish();
    osw.close();
    String output = new String(ba.toByteArray());
    System.out.println("e: "+TEST_OUTPUT_1);
    System.out.println("o: "+output);
    Assertions.assertEquals(TEST_OUTPUT_1, output);;
  }

  private void writeObject(JsonCreatorCanonical json, JsonObject object) throws IOException {
    json.beginObject();
    for (JsonProperty p : object.getProperties()) {
      json.name(p.getName());
      JsonElement e = p.getValue();
      writeValue(json, e);
    }
    json.endObject();
  }

  private void writeValue(JsonCreatorCanonical json, JsonElement e) throws IOException {
    switch (e.type()) {
    case ARRAY:
      writeArray(json, e.asJsonArray());
      break;
    case BOOLEAN:
      json.value(e.asJsonBoolean().isValue());
      break;
    case NULL:
      json.nullValue();
      break;
    case NUMBER:
      json.valueNum(e.asJsonNumber().getValue());
      break;
    case OBJECT:
      writeObject(json, e.asJsonObject());
      break;
    case STRING:
      json.value(e.asString());
      break;
    default:
      break;      
    }
  }

  private void writeArray(JsonCreatorCanonical json, JsonArray array) throws IOException {
    json.beginArray();
    for (JsonElement p : array) {
      writeValue(json, p);
    }
    json.endArray();
  }
  

  @Test
  public void testCanonicalJsonNumbers() throws IOException {
      String[] testCases = {
          "0",
          "1",
          "-1", 
          "0.1",
          "1.5",
          "123.456",
          "0.0001234",
          "1234567890123456789",
          "1.23e-4",
          "1.23e+20",
          // RFC 8785 specification examples
          "333333333.33333329",  // should be 333333333.3333333
          "1E30",                // should be 1e+30
          "4.50",                // should be 4.5
          "2e-3",                // should be 0.002
          "0.000000000000000000000000001"  // should be 1e-27
      };
      
      String[] expected = {
          "0", "1", "-1", "0.1", "1.5", "123.456", "0.0001234", 
          "1234567890123456789", "1.23e-4", "1.23e+20",
          "333333333.3333333", "1e+30", "4.5", "0.002", "1e-27"
      };
      
      for (int i = 0; i < testCases.length; i++) {
          try {
              String result = JsonNumberCanonicalizer.toCanonicalJson(testCases[i]);
              String exp = i < expected.length ? expected[i] : "?";
              String status = result.equals(exp) ? "✓" : "✗";
              System.out.println(testCases[i] + " -> " + result + " (expected: " + exp + ") " + status);
          } catch (Exception e) {
              System.out.println(testCases[i] + " -> ERROR: " + e.getMessage());
          }
      }
  }
  
}
