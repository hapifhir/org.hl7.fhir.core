package org.hl7.fhir.r5.test;

import java.io.IOException;

import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonParserTests {

  @Test
  public void testLocations() throws IOException {
    String cnt = TestingUtilities.loadTestResource("validator", "slice23", "AuditEvent-ex-FirstSliceProfile.json");
    JsonObject json = JsonParser.parseObject(cnt);
    checkLine(json, 1, 1);
    checkLine(json.get("resourceType"), 2, 19);
    checkLine(json.get("id"), 3, 9);
    checkLine(json.get("meta"), 4, 11);
    checkLine(json.getJsonObject("meta").get("security"), 5, 17);
    checkLine(json.get("agent"), 15, 12);
    checkLine(json.getJsonArray("agent").get(0), 16, 5);
    checkLine(json.getJsonArray("agent").get(0).asJsonObject().get("type"), 17, 15);
    checkLine(json.getJsonArray("agent").get(0).asJsonObject().get("requestor"), 32, 20);
    checkLine(json.getJsonArray("agent").get(1), 34, 5);
    
    checkLine(json.get("type"), 50, 11);
  }

  private void checkLine(JsonElement e, int line, int col) {
    Assertions.assertEquals(line, e.getStart().getLine(), "line");
    Assertions.assertEquals(col, e.getStart().getCol(), "col");
    
  }
}
