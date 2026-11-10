package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.junit.jupiter.api.Test;

/**
 * Which of a test's responses applies, given what the server did - see TxTestResponses.
 */
class TxTestResponsesTests {

  private static final Set<String> MODES = Set.of("tx.fhir.org");

  private static TxTestResponses responses(String json) {
    try {
      return new TxTestResponses(JsonParser.parseObject(json), MODES);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  @Test
  void defaultIs2xx() {
    TxTestResponses r = responses("{\"name\":\"t\",\"response\":\"r.json\"}");
    assertEquals("2xx", r.getHttpCode());
    assertFalse(r.isChoice());
    assertEquals("r.json", r.fileFor("2xx"));
    assertEquals("2xx", r.choiceForCode(200));
    assertNull(r.choiceForCode(404));
  }

  @Test
  void choice() {
    TxTestResponses r = responses("{\"name\":\"t\",\"http-code\":\"200|4xx\",\"response:200\":\"vs.json\",\"response:4xx\":\"oo.json\"}");
    assertTrue(r.isChoice());
    assertEquals(List.of("200", "4xx"), r.getChoices());
    assertEquals(List.of("vs.json", "oo.json"), r.files());
    assertEquals("vs.json", r.fileFor(r.choiceForCode(200)));
    assertEquals("oo.json", r.fileFor(r.choiceForCode(422)));
    assertNull(r.choiceForCode(201));
    assertNull(r.choiceForCode(500));
    assertEquals("vs.json", r.fileFor(r.choiceForOutcome(false)));
    assertEquals("oo.json", r.fileFor(r.choiceForOutcome(true)));
  }

  @Test
  void choiceFallsBackToResponse() {
    TxTestResponses r = responses("{\"name\":\"t\",\"http-code\":\"2xx|4xx\",\"response\":\"vs.json\",\"response:4xx\":\"oo.json\"}");
    assertEquals("vs.json", r.fileFor("2xx"));
    assertEquals("oo.json", r.fileFor("4xx"));
  }

  @Test
  void modeSpecificResponses() {
    TxTestResponses r = responses("{\"name\":\"t\",\"http-code\":\"200|4xx\",\"response\":\"vs.json\",\"response:tx.fhir.org\":\"vs-tx.json\","
      + "\"response:4xx\":\"oo.json\",\"response:4xx:tx.fhir.org\":\"oo-tx.json\"}");
    assertEquals("vs-tx.json", r.fileFor("200"));
    assertEquals("oo-tx.json", r.fileFor("4xx"));
  }

  @Test
  void outcomeNotAllowed() {
    TxTestResponses r = responses("{\"name\":\"t\",\"http-code\":\"4xx\",\"response\":\"oo.json\"}");
    assertNull(r.choiceForOutcome(false));
    assertEquals("4xx", r.choiceForOutcome(true));
    TxTestResponses r2 = responses("{\"name\":\"t\",\"http-code\":\"200|5xx\",\"response\":\"x.json\"}");
    assertEquals("5xx", r2.choiceForOutcome(true));
  }

  @Test
  void errors() {
    assertThrows(FHIRException.class, () -> responses("{\"name\":\"t\",\"http-code\":\"200|oops\",\"response\":\"r.json\"}"));
    assertThrows(FHIRException.class, () -> responses("{\"name\":\"t\",\"http-code\":\"200|4xx\",\"response:200\":\"r.json\"}"));
  }

  @Test
  void httpCodeMatching() {
    assertTrue(TxTestResponses.httpCodeOk("2xx", 200));
    assertTrue(TxTestResponses.httpCodeOk("4xx", 499));
    assertFalse(TxTestResponses.httpCodeOk("4xx", 500));
    assertTrue(TxTestResponses.httpCodeOk("422", 422));
    assertFalse(TxTestResponses.httpCodeOk("422", 400));
    assertThrows(FHIRException.class, () -> TxTestResponses.httpCodeOk("4x", 400));
  }
}
