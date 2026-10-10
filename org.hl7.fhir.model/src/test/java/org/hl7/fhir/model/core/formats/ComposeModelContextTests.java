package org.hl7.fhir.model.core.formats;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.Patient;
import org.hl7.fhir.model.core.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The model context check of the serialisers (Base.checkModelContext)
 */
class ComposeModelContextTests {

  private static final String PATIENT = "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Muster\",\"given\":[\"Max\"]}]}";

  @Test
  void testComposeAdoptsTheContext() throws IOException {
    Patient patient = new Patient();
    patient.addName().setFamily("Muster").addGiven("Max");
    Assertions.assertNull(patient.getModelContext());

    String json = new JsonParser(ModelContext.minimalContext()).composeString(patient);

    Assertions.assertEquals(PATIENT, json);
    Assertions.assertSame(ModelContext.minimalContext(), patient.getModelContext());
    Assertions.assertSame(ModelContext.minimalContext(), patient.getNameFirstRep().getModelContext());
    Assertions.assertSame(ModelContext.minimalContext(), patient.getNameFirstRep().getGivenList().get(0).getModelContext());
  }

  @Test
  void testComposeWithTheSameContext() throws IOException {
    Resource patient = parse(PATIENT);
    Assertions.assertEquals(PATIENT, new JsonParser(ModelContext.minimalContext()).composeString(patient));
    Assertions.assertTrue(new XmlParser(ModelContext.minimalContext()).composeString(patient).contains("Muster"));
  }

  @Test
  void testComposeRejectsAnIncompatibleContext() throws IOException {
    Resource patient = new JsonParser(ModelContext.fullCoreContext())
        .parse(new ByteArrayInputStream(PATIENT.getBytes(StandardCharsets.UTF_8)));
    Assertions.assertFalse(ModelContext.fullCoreContext().isCompatibleModelContext(ModelContext.minimalContext()));

    Assertions.assertThrows(FHIRException.class, () -> new JsonParser(ModelContext.minimalContext()).composeString(patient));
    Assertions.assertThrows(FHIRException.class, () -> new XmlParser(ModelContext.minimalContext()).composeString(patient));
  }

  private static Resource parse(String json) throws IOException {
    return new JsonParser(ModelContext.minimalContext()).parse(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)));
  }
}
