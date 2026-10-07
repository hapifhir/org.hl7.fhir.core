package org.hl7.fhir.convertors.conv43_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_N;
import org.junit.jupiter.api.Test;

class StructureMap43_NTest {

  @Test
  void testMissingGroupTypeModeConvertsToR4BNone() throws IOException {
    org.hl7.fhir.model.fml.StructureMap source = new org.hl7.fhir.model.fml.StructureMap();
    source.addGroup().setName("test");

    org.hl7.fhir.r4b.model.StructureMap target =
        (org.hl7.fhir.r4b.model.StructureMap) VersionConvertorFactory_43_N.convertResource(source);

    assertEquals(
        org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeMode.NONE,
        target.getGroupFirstRep().getTypeMode());

    String json = new org.hl7.fhir.r4b.formats.JsonParser().composeString(target);
    assertTrue(json.matches("(?s).*\"typeMode\"\\s*:\\s*\"none\".*"));
  }
}
