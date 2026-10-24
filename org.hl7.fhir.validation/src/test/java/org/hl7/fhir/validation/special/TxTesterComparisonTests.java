package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Set;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Test;

/**
 * The comparison form of an actual response puts back the patterns the expected response matches
 * by ($external$, $uuid$, $instant$...), so that a diff against the expected response only shows
 * what matters, and collects the server's wording of each $external$ message.
 */
class TxTesterComparisonTests {

  private static final String EXPECTED = "{\"resourceType\":\"Parameters\",\"parameter\":["
      + "{\"name\":\"display\",\"valueString\":\"Cholera\"},"
      + "{\"name\":\"issues\",\"resource\":{\"$optional-properties$\":[\"location\"],\"resourceType\":\"OperationOutcome\",\"issue\":[{"
      + "  \"severity\":\"error\",\"details\":{\"text\":\"$external:1:1A01$\"},"
      + "  \"extension\":[{\"$optional$\":\"!tx.fhir.org\",\"url\":\"http://hl7.org/fhir/StructureDefinition/operationoutcome-message-id\",\"valueString\":\"X\"}]}]}},"
      + "{\"name\":\"message\",\"valueString\":\"$external:2:1A01$\"},"
      + "{\"$optional$\":true,\"name\":\"optional-thing\",\"valueString\":\"x\"},"
      + "{\"name\":\"id\",\"valueString\":\"$uuid$\"},"
      + "{\"name\":\"when\",\"valueString\":\"$instant$\"},"
      + "{\"name\":\"result\",\"valueBoolean\":false}]}";

  private JsonObject normalise(TxTesterComparison c, String actual) throws Exception {
    return c.normalise(JsonParser.parse(EXPECTED), JsonParser.parse(actual)).asJsonObject();
  }

  private TxTesterComparison comparison() {
    return new TxTesterComparison(Set.of("tx.fhir.org"), new HashMap<>());
  }

  private String param(JsonObject p, String name) {
    return p.getJsonArray("parameter").findByStringProp("name", name).asString("valueString");
  }

  @Test
  void externalsArePutBackAndTheWordingKept() throws Exception {
    TxTesterComparison c = comparison();
    JsonObject n = normalise(c, "{\"resourceType\":\"Parameters\",\"parameter\":["
        + "{\"name\":\"display\",\"valueString\":\"Cholera\"},"
        + "{\"name\":\"issues\",\"resource\":{\"resourceType\":\"OperationOutcome\",\"issue\":[{\"severity\":\"error\",\"details\":{\"text\":\"Our wording: 1A01 is wrong\"},\"location\":[\"Coding.extension[0]\"]}]}},"
        + "{\"name\":\"message\",\"valueString\":\"Our wording: 1A01 is wrong (2)\"},"
        + "{\"name\":\"id\",\"valueString\":\"urn:uuid:6f1c1d8e-1a2b-4c3d-9e8f-0123456789ab\"},"
        + "{\"name\":\"when\",\"valueString\":\"2026-10-19T10:00:00.000Z\"},"
        + "{\"name\":\"result\",\"valueBoolean\":false}]}");
    assertEquals("$external:2:1A01$", param(n, "message"));
    JsonObject issue = n.getJsonArray("parameter").findByStringProp("name", "issues").getJsonObject("resource").getJsonArray("issue").get(0).asJsonObject();
    assertEquals("$external:1:1A01$", issue.getJsonObject("details").asString("text"));
    // what the expected response doesn't say anything about stays as it was
    assertEquals("Coding.extension[0]", issue.getJsonArray("location").get(0).asJsonString().getValue());
    assertEquals("Our wording: 1A01 is wrong", c.getMessages().get("1"));
    assertEquals("Our wording: 1A01 is wrong (2)", c.getMessages().get("2"));
    // patterns the actual value matches are put back
    assertEquals("$uuid$", param(n, "id"));
    assertEquals("$instant$", param(n, "when"));
  }

  @Test
  void valuesThatDontMatchStay() throws Exception {
    TxTesterComparison c = comparison();
    JsonObject n = normalise(c, "{\"resourceType\":\"Parameters\",\"parameter\":["
        + "{\"name\":\"display\",\"valueString\":\"Cholera (wrong)\"},"
        + "{\"name\":\"message\",\"valueString\":\"the message\"},"
        + "{\"name\":\"id\",\"valueString\":\"not-a-uuid\"},"
        + "{\"name\":\"when\",\"valueString\":\"yesterday\"},"
        + "{\"name\":\"result\",\"valueBoolean\":true}]}");
    // a real difference shows: the display, the uuid and the instant are left as the server sent them
    assertEquals("Cholera (wrong)", param(n, "display"));
    assertEquals("not-a-uuid", param(n, "id"));
    assertEquals("yesterday", param(n, "when"));
    // the issues are missing, but the message still lines up with its expected parameter
    assertEquals("$external:2:1A01$", param(n, "message"));
    assertEquals("the message", c.getMessages().get("2"));
    assertTrue(!c.getMessages().containsKey("1"));
  }
}
