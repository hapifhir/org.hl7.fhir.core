package org.hl7.fhir.utilities.json;

import java.io.IOException;

import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonBoolean;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonElementType;
import org.hl7.fhir.utilities.json.model.JsonNull;
import org.hl7.fhir.utilities.json.model.JsonNumber;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.model.JsonString;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonParserTests {

  @Test
  public void testComments1() throws IOException, JsonException {
    Assertions.assertThrows(IOException.class, () -> JsonParser.parseObject("{\n  // some comment \n  \"n1\" : \"v1\"\n}\n", false));
  }
  
  @Test
  public void testComments2() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\n  // some comment \n  \"n1\" : \"v1\"\n}\n", true);
    Assertions.assertEquals(0, obj.getComments().size());
    JsonString c = obj.getStr("n1");
    Assertions.assertEquals(1, c.getComments().size());
    Assertions.assertEquals("some comment", c.getComments().get(0));
    Assertions.assertEquals("{\"n1\":\"v1\"}", JsonParser.compose(obj, false));
    Assertions.assertEquals("{\n  // some comment\n  \"n1\" : \"v1\"\n}\n", JsonParser.compose(obj, true));
  }

  @Test
  public void testComments3() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("// some comment\n{\n  \"n1\" : \"v1\"\n}\n", true);
    Assertions.assertEquals(1, obj.getComments().size());
    Assertions.assertEquals("some comment", obj.getComments().get(0));
    JsonString c = obj.getStr("n1");
    Assertions.assertEquals(0, c.getComments().size());
    Assertions.assertEquals("{\"n1\":\"v1\"}", JsonParser.compose(obj, false));
    Assertions.assertEquals("// some comment\n{\n  \"n1\" : \"v1\"\n}\n", JsonParser.compose(obj, true));
  }

  @Test
  public void testEmpty1() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{}");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(3, obj.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testEmpty2() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\r\n}\r\n");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(2, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
  }


  private void checkSubstring(String src, JsonElement obj, String tgt) {
    String s = src.substring(obj.getStart().getCol()-1, obj.getEnd().getCol()-1);
    Assertions.assertEquals(tgt, s);
  }

  @Test
  public void testString1() throws IOException, JsonException {
    String src = "{\"name\":\"value\"}";
    JsonObject obj = JsonParser.parseObject(src);
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(17, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    checkSubstring(src, obj, src);
    JsonProperty p = obj.getProperties().get(0);
    Assertions.assertNotNull(p);
    JsonElement e = obj.get("name");
    Assertions.assertSame(p.getValue(), e);
    JsonString j = (JsonString) e;
    checkSubstring(src, j, "\"value\"");
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(9, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(16, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testString2() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\r\n  \"name\" : \"value\"\r\n}\r\n");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(3, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonElement e = obj.get("name");
    JsonString j = (JsonString) e;
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(2, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(12, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(2, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(19, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testString3() throws IOException, JsonException {
    String src = "{\"name\":\"value\",\"n1\":\"v1\"}";
    JsonObject obj = JsonParser.parseObject(src);
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(27, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(2, obj.getProperties().size(), "prop count is wrong");
    checkSubstring(src, obj, src);

    JsonProperty p = obj.getProperties().get(0);
    Assertions.assertNotNull(p);
    JsonElement e = obj.get("name");
    Assertions.assertSame(p.getValue(), e);
    JsonString j = (JsonString) e;
    checkSubstring(src, j, "\"value\"");
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(9, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(16, j.getEnd().getCol(), "end col is wrong");

    p = obj.getProperties().get(1);
    Assertions.assertNotNull(p);
    e = obj.get("n1");
    j = (JsonString) e;
    Assertions.assertSame(p.getValue(), e);
    checkSubstring(src, j, "\"v1\"");
    s = obj.str("n1");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(22, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(26, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testString4() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\r\n  \"name\" : \"value\"\r\n}\r\n");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(3, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonElement e = obj.get("name");
    JsonString j = (JsonString) e;
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(2, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(12, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(2, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(19, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testStringE1() throws IOException, JsonException {
    String src = "{\"name\":\"\"}";
    JsonObject obj = JsonParser.parseObject(src);
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(12, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    checkSubstring(src, obj, src);
    JsonProperty p = obj.getProperties().get(0);
    Assertions.assertNotNull(p);
    JsonElement e = obj.get("name");
    JsonString j = (JsonString) e;
    checkSubstring(src, j, "\"\"");
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(9, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(11, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testStringE2() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\r\n  \"name\" : \"\"\r\n}\r\n");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(3, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonElement e = obj.get("name");
    JsonString j = (JsonString) e;
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(2, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(12, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(2, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(14, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testInt1() throws IOException, JsonException {
    String src = "{\"name\":1}";
    JsonObject obj = JsonParser.parseObject(src);
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(11, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    checkSubstring(src, obj, src);
    JsonElement e = obj.get("name");
    JsonNumber j = (JsonNumber) e;
    checkSubstring(src, j, "1");
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(9, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(10, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testInt2() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\r\n  \"name\" : 1\r\n}\r\n");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(3, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonProperty p = obj.getProperties().get(0);
    Assertions.assertNotNull(p);
    JsonElement e = obj.get("name");
    JsonNumber j = (JsonNumber) e;
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(2, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(12, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(2, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(13, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testBool1() throws IOException, JsonException {
    String src = "{\"name\":true}";
    JsonObject obj = JsonParser.parseObject(src);
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(14, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    checkSubstring(src, obj, src);
    JsonElement e = obj.get("name");
    JsonBoolean j = (JsonBoolean) e;
    checkSubstring(src, j, "true");
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(9, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(13, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testBool2() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\r\n  \"name\" : false\r\n}\r\n");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(3, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonProperty p = obj.getProperties().get(0);
    Assertions.assertNotNull(p);
    JsonElement e = obj.get("name");
    JsonBoolean j = (JsonBoolean) e;
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(2, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(12, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(2, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(17, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testNull1() throws IOException, JsonException {
    String src = "{\"name\":null}";
    JsonObject obj = JsonParser.parseObject(src);
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(14, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    checkSubstring(src, obj, src);
    JsonElement e = obj.get("name");
    JsonNull j = (JsonNull) e;
    checkSubstring(src, j, "null");
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(9, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(13, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testNull2() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\r\n  \"name\" : null\r\n}\r\n");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(3, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonProperty p = obj.getProperties().get(0);
    Assertions.assertNotNull(p);
    JsonElement e = obj.get("name");
    JsonNull j = (JsonNull) e;
    String s = obj.str("name");
    Assertions.assertEquals(j.getValue(), s, "string prop value");
    Assertions.assertEquals(2, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(12, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(2, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(16, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testObject1() throws IOException, JsonException {
    String src = "{\"name\":{\"n1\":\"v1\"}}";
    JsonObject obj = JsonParser.parseObject(src);
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(21, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    checkSubstring(src, obj, src);
    JsonElement e = obj.get("name");
    JsonObject j = (JsonObject) e;
    checkSubstring(src, j, "{\"n1\":\"v1\"}");
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(9, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(20, j.getEnd().getCol(), "end col is wrong");

    JsonElement e1 = j.get("n1");
    JsonString j1 = (JsonString) e1;
    checkSubstring(src, j1, "\"v1\"");
    Assertions.assertEquals("v1", j1.getValue());
    Assertions.assertEquals(1, j1.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(15, j1.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j1.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(19, j1.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testObject2() throws IOException, JsonException {
    String src = "{\r\n  \"name\" : {\r\n    \"n1\":\"v1\"\r\n  }\r\n}\r\n";
    JsonObject obj = JsonParser.parseObject(src);
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(5, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonElement e = obj.get("name");
    JsonObject j = (JsonObject) e;
    Assertions.assertEquals(2, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(12, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(4, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(4, j.getEnd().getCol(), "end col is wrong");

    JsonElement e1 = j.get("n1");
    JsonString j1 = (JsonString) e1;
    Assertions.assertEquals("v1", j1.getValue());
    Assertions.assertEquals(3, j1.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(10, j1.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(3, j1.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(14, j1.getEnd().getCol(), "end col is wrong");
  }
  
  @Test
  public void testArrEmpty1() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\"name\":[]}");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(12, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonElement e = obj.get("name");
    JsonArray j = (JsonArray) e;
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(9, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(11, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testArrEmpty2() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\r\n  \"name\" : [ ]\r\n}\r\n");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(3, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
    JsonElement e = obj.get("name");
    JsonArray j = (JsonArray) e;
    Assertions.assertEquals(2, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(12, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(2, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(15, j.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testArr() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\"name\":[\"v\",{\"n\":\"v1\"}]}");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(26, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonElement e = obj.get("name");
    JsonArray j = (JsonArray) e;
    Assertions.assertEquals(1, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(9, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(25, j.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(2, j.size());

    JsonElement e1 = j.getItems().get(0);
    JsonString j1 = (JsonString) e1;
    Assertions.assertEquals(1, j1.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(10, j1.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j1.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(13, j1.getEnd().getCol(), "end col is wrong");
    JsonElement e2 = j.getItems().get(1);
    JsonObject j2 = (JsonObject) e2;
    Assertions.assertEquals(1, j2.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(14, j2.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(1, j2.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(24, j2.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testArr2() throws IOException, JsonException {
    JsonObject obj = JsonParser.parseObject("{\n  \"name\" : [\n    \"v\",\n    {\n      \"n\" : \"v1\"\n    }\n  ]\n}\n");
    Assertions.assertEquals(1, obj.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(1, obj.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(8, obj.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(2, obj.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(1, obj.getProperties().size(), "prop count is wrong");
    JsonElement e = obj.get("name");
    JsonArray j = (JsonArray) e;
    Assertions.assertEquals(2, j.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(12, j.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(7, j.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(4, j.getEnd().getCol(), "end col is wrong");
    Assertions.assertEquals(2, j.size());

    JsonElement e1 = j.getItems().get(0);
    JsonString j1 = (JsonString) e1;
    Assertions.assertEquals(3, j1.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(5, j1.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(3, j1.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(8, j1.getEnd().getCol(), "end col is wrong");
    JsonElement e2 = j.getItems().get(1);
    JsonObject j2 = (JsonObject) e2;
    Assertions.assertEquals(4, j2.getStart().getLine(), "start line is wrong");
    Assertions.assertEquals(5, j2.getStart().getCol(), "start col is wrong");
    Assertions.assertEquals(6, j2.getEnd().getLine(), "end line is wrong");
    Assertions.assertEquals(6, j2.getEnd().getCol(), "end col is wrong");
  }

  @Test
  public void testElementBool() throws IOException, JsonException {
    JsonElement e = JsonParser.parse("true");
    Assertions.assertEquals(JsonElementType.BOOLEAN, e.elementType());
    Assertions.assertEquals(true, ((JsonBoolean) e).isValue());
    e = JsonParser.parse("// comment\nfalse", true);
    Assertions.assertEquals(JsonElementType.BOOLEAN, e.elementType());
    Assertions.assertEquals(false, ((JsonBoolean) e).isValue());
    Assertions.assertEquals("false", JsonParser.compose(e));
    Assertions.assertEquals("// comment\nfalse\n", JsonParser.compose(e, true));
  }

  @Test
  public void testElementNumber() throws IOException, JsonException {
    JsonElement e = JsonParser.parse("1");
    Assertions.assertEquals(JsonElementType.NUMBER, e.elementType());
    Assertions.assertEquals("1", ((JsonNumber) e).getValue());
    e = JsonParser.parse("// comment \n-1.2e10", true);
    Assertions.assertEquals(JsonElementType.NUMBER, e.elementType());
    Assertions.assertEquals("-1.2e10", ((JsonNumber) e).getValue());
    Assertions.assertEquals("-1.2e10", JsonParser.compose(e));
    Assertions.assertEquals("// comment\n-1.2e10\n", JsonParser.compose(e, true));
  }
  
  @Test
  public void testElementString() throws IOException, JsonException {
    JsonElement e = JsonParser.parse("\"str\\ning\"");
    Assertions.assertEquals(JsonElementType.STRING, e.elementType());
    Assertions.assertEquals("str\ning", ((JsonString) e).getValue());
    Assertions.assertEquals("\"str\\ning\"", JsonParser.compose(e));
    Assertions.assertEquals("\"str\\ning\"\n", JsonParser.compose(e, true));
    e = JsonParser.parse("// comment\n\"\"", true);
    Assertions.assertEquals(JsonElementType.STRING, e.elementType());
    Assertions.assertEquals("", ((JsonString) e).getValue());
  }
  
  @Test
  public void testElementNull() throws IOException, JsonException {
    JsonElement e = JsonParser.parse("null");
    Assertions.assertEquals(JsonElementType.NULL, e.elementType());
    Assertions.assertEquals("null", JsonParser.compose(e));
    Assertions.assertEquals("null\n", JsonParser.compose(e, true));
  }
  
  @Test
  public void testElementArray() throws IOException, JsonException {
    JsonElement e = JsonParser.parse("[\"test\", null, true]");
    Assertions.assertEquals(JsonElementType.ARRAY, e.elementType());
    Assertions.assertEquals(3, ((JsonArray) e).size());
    Assertions.assertEquals("[\"test\",null,true]", JsonParser.compose(e));
    Assertions.assertEquals("[\"test\", null, true]\n", JsonParser.compose(e, true));
    e = JsonParser.parse("// comment\n[]", true);
    Assertions.assertEquals(JsonElementType.ARRAY, e.elementType());
    Assertions.assertEquals(0, ((JsonArray) e).size());
  }
  
  @Test
  public void testDuplicates1() throws IOException, JsonException {
    Assertions.assertThrows(IOException.class, () -> JsonParser.parseObject("{ \"n\" : 1, \"n\" : 2 }", false, false));
  }
  
  @Test
  public void testDuplicates2() throws IOException, JsonException {
    JsonObject e = JsonParser.parseObject("{ \"n\" : 1, \"n\" : 2 }", false, true);
    Assertions.assertEquals(2, e.getProperties().size());
    Assertions.assertEquals(2, e.getInteger("n"));
    Assertions.assertEquals("{\"n\":1,\"n\":2}", JsonParser.compose(e));
  }
  
  @Test
  public void testNoComma1() throws IOException, JsonException {
    Assertions.assertThrows(IOException.class, () -> JsonParser.parseObject("{ \"n1\" : 1 \"n2\" : 2 }", false));
  }
  
  @Test
  public void testNoComma2() throws IOException, JsonException {
    JsonObject e = JsonParser.parseObject("{ \"n1\" : 1 \"n2\" : 2 }", true);
    Assertions.assertEquals(2, e.getProperties().size());
    Assertions.assertEquals(false, e.getProperties().get(0).isNoComma());
    Assertions.assertEquals(true, e.getProperties().get(1).isNoComma());
  }
  
  @Test
  public void testNoCommaInArr1() throws IOException, JsonException {
    Assertions.assertThrows(IOException.class, () -> JsonParser.parseObject("[1 2]", false));
  }
  
  @Test
  public void testNoCommainArr2() throws IOException, JsonException {
    JsonArray e = (JsonArray) JsonParser.parse("[1 2]", true);
    Assertions.assertEquals(2, e.size());
    Assertions.assertEquals(false, e.isNoComma(0));
    Assertions.assertEquals(true, e.isNoComma(1));
  }
  

  @Test
  public void testUnquoted1() throws IOException, JsonException {
    Assertions.assertThrows(IOException.class, () -> JsonParser.parseObject("{ this: that, \"the\" : other}", false));
  }
  
  @Test
  public void testUnquoted2() throws IOException, JsonException {
    JsonObject e = JsonParser.parseObject("{ this: that, \"the\" : other}", true);
    Assertions.assertEquals(2, e.getProperties().size());
    Assertions.assertEquals(true, e.getProperties().get(0).isUnquotedName());
    Assertions.assertEquals(true, e.getProperties().get(0).isUnquotedValue());
    Assertions.assertEquals(false, e.getProperties().get(1).isUnquotedName());
    Assertions.assertEquals(true, e.getProperties().get(1).isUnquotedValue());
  }
}
