package org.hl7.fhir.dstu2016may.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.dstu2016may.formats.IParser;
import org.hl7.fhir.dstu2016may.formats.JsonParser;
import org.hl7.fhir.dstu2016may.model.Bundle;
import org.hl7.fhir.dstu2016may.model.Resource;
import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@Deprecated
class MessageTest {

  @Test
  void test() throws FHIRException {
    // Create new Atom Feed
    Bundle feed = new Bundle();

    assertDoesNotThrow(() -> {
      // Serialize Atom Feed
      IParser comp = new JsonParser();
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      comp.compose(os, feed);
      os.close();
      String json = os.toString();

      // Deserialize Atom Feed
      JsonParser parser = new JsonParser();
      InputStream is = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
      Resource result = parser.parse(is);
      if (result == null)
        throw new FHIRException("Bundle was null");
    });
  }
}