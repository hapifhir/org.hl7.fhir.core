package org.hl7.fhir.model;

import org.hl7.fhir.model.core.IdType;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class IdTypeTest {

  @Test
  public void testAsString() {
    IdType t = new IdType("Patient/123");
    assertEquals("Patient/123", t.asStringValue());
    assertEquals("Patient/123", t.getValueAsString());
    assertEquals("Patient/123", t.getValue());
  }

  @Test
  public void testAsStringFromComponentParts() {
    IdType t = new IdType("http://foo", "Patient", "123", "1");
    assertEquals("http://foo/Patient/123/_history/1", t.asStringValue());
    assertEquals("http://foo/Patient/123/_history/1", t.getValueAsString());
    assertEquals("http://foo/Patient/123/_history/1", t.getValue());
  }

}
