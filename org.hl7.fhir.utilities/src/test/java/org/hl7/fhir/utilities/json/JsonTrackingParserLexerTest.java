package org.hl7.fhir.utilities.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.hl7.fhir.utilities.json.JsonTrackingParser.LocationData;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Checks the values and source locations JsonTrackingParser reports for strings,
 * escapes, line breaks and comments. The expected values were captured from the
 * lexer before it copied runs of plain characters in one go.
 */
class JsonTrackingParserLexerTest {

  private static String describe(JsonElement e, Map<JsonElement, LocationData> map) {
    StringBuilder b = new StringBuilder();
    describe(e, map, b);
    return b.toString();
  }

  private static void describe(JsonElement e, Map<JsonElement, LocationData> map, StringBuilder b) {
    LocationData l = map.get(e);
    b.append(l == null ? "?" : l.getLine() + ":" + l.getCol());
    if (e instanceof JsonObject) {
      b.append("{");
      for (Map.Entry<String, JsonElement> p : ((JsonObject) e).entrySet()) {
        b.append(p.getKey()).append("=");
        describe(p.getValue(), map, b);
        b.append(";");
      }
      b.append("}");
    } else if (e instanceof JsonArray) {
      b.append("[");
      for (JsonElement i : (JsonArray) e) {
        describe(i, map, b);
        b.append(",");
      }
      b.append("]");
    } else {
      b.append("<").append(e.toString()).append(">");
    }
  }

  static Stream<Arguments> cases() {
    return Stream.of(
      Arguments.of("{\"a\":\"plain\"}", "1:2{a=1:14<\"plain\">;}"),
      Arguments.of("{\n  \"a\" : \"x\\\"y\\\\z\\/w\\n\\r\\t\\u00e9\\u0041\",\n  \"b\":\"\"\n}", "1:2{a=2:40<\"x\\\"y\\\\z/w\\n\\r\\t\u00e9A\">;b=4:2<\"\">;}"),
      Arguments.of("{\"multi\":\"line one\nline two\n\nend\", \"after\" : 1}", "1:2{multi=4:6<\"line one\\nline two\\n\\nend\">;after=4:19<1>;}"),
      Arguments.of("{\r\n\t\"arr\": [\"a\", \"bb\", \"ccc\\u2603ddd\", 12.5e3, -3, true, false, null],\r\n\t\"o\": {\"k\": \"v\"}\r\n}", "1:2{arr=2:10[2:14<\"a\">,2:20<\"bb\">,2:36<\"ccc\u2603ddd\">,2:44<1.25E+4>,2:48<-3>,2:67<null>,];o=3:17{k=3:17<\"v\">;};}"),
      Arguments.of("{\"unicode\":\"\u00e9\u4e2d\ud83d\ude00\", \"q\":\"'single'\\'\"}", "1:2{unicode=1:19<\"\u00e9\u4e2d\ud83d\ude00\">;q=1:37<\"'single''\">;}"),
      Arguments.of("{\"a\":\"x\" // comment \"here\"\n, \"b\":\"y\"}", "1:2{a=2:2<\"x\">;b=2:11<\"y\">;}")
    );
  }

  @ParameterizedTest
  @MethodSource("cases")
  void valuesAndLocations(String source, String expected) throws IOException {
    Map<JsonElement, LocationData> map = new IdentityHashMap<>();
    JsonObject obj = JsonTrackingParser.parse(source, map, false, true);
    String actual = describe(obj, map);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("badSources")
  void errors(String source, String message) {
    IOException e = assertThrows(IOException.class, () -> JsonTrackingParser.parse(source, null));
    assertEquals(message, e.getMessage());
  }

  static Stream<Arguments> badSources() {
    return Stream.of(
      Arguments.of("{\"a\":\"unterminated", "Error parsing JSON source: premature termination of json stream during a string at Line 1 (path=[/a])"),
      Arguments.of("{\"a\":\"line\nbreak\nthen unterminated", "Error parsing JSON source: premature termination of json stream during a string at Line 3 (path=[/a])"),
      Arguments.of("{\"a\":\"bad \\q escape\"}", "Error parsing JSON source: unknown escape sequence: \\q at Line 1 (path=[/a])")
    );
  }
}
