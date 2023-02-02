package org.hl7.fhir.utilities.json;

import java.text.ParseException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JsonObjectTests {

  @Test
  void asInstantReturnsNonNull() throws ParseException {
    JsonObject json = new JsonObject();
    json.set("date", "2022-10-12");
    System.out.println(json.asString("date"));
    Assertions.assertNotNull(json.asInstant("date"));
  }

  @Test
  void jsonInstantEqualsJavaInstant() throws ParseException {
    Instant instant = Instant.now();
    JsonObject json = new JsonObject();
    json.set("date", instant);
    System.out.println(json.asString("date"));
    Assertions.assertEquals(instant, json.asInstant("date"));
  }

  @Test
  void differentInstantsArentEqual() throws InterruptedException {
    Instant instant = Instant.now();
    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM-yyyy").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());
    System.out.println(df.format(instant));
    df = DateTimeFormatter.ofPattern("yyyy-MM-dd").withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());
    System.out.println(df.format(instant));

    // We need to sleep here, as some machines are fast enough for differentInstant to have the same values to the
    // nanosecond even after processing the above lines.
    Thread.sleep(1);
    Instant differentInstant = Instant.now();
    Assertions.assertNotEquals(instant, differentInstant);
  }

}
