package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.junit.jupiter.api.Test;

class StructureMap40_NTest {

  @Test
  void testMissingGroupTypeModeConvertsToR4None() throws IOException {
    org.hl7.fhir.model.fml.StructureMap source = new org.hl7.fhir.model.fml.StructureMap();
    source.addGroup().setName("test");

    org.hl7.fhir.r4.model.StructureMap target =
        (org.hl7.fhir.r4.model.StructureMap) VersionConvertorFactory_40_N.convertResource(source);

    assertEquals(
        org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NONE,
        target.getGroupFirstRep().getTypeMode());

    String json = new org.hl7.fhir.r4.formats.JsonParser().composeString(target);
    assertTrue(json.matches("(?s).*\"typeMode\"\\s*:\\s*\"none\".*"));
  }
}
