package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.model.core.ValueSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The R5 elements R4 ValueSet doesn't have go in extensions: the metadata (as for CodeSystem) and expansion.next
 */
class ValueSet40_NTest {

  @Test
  @DisplayName("copyrightLabel and expansion.next round trip through R4")
  void testR5Elements() {
    ValueSet src = new ValueSet();
    src.setUrl("http://example.org/vs");
    src.setStatus(org.hl7.fhir.model.core.Enumerations.PublicationStatus.DRAFT);
    src.setCopyrightLabel("(c) Example");
    src.getExpansion().setTimestampElement(new org.hl7.fhir.model.core.DateTimeType("2026-11-22T10:00:00Z"));
    src.getExpansion().setNext("http://example.org/fhir/ValueSet/$expand?page=2");

    org.hl7.fhir.r4.model.ValueSet r4 = (org.hl7.fhir.r4.model.ValueSet) VersionConvertorFactory_40_N.convertResource(src);
    assertEquals("(c) Example", r4.getExtensionString("http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.copyrightLabel"));
    assertEquals("http://example.org/fhir/ValueSet/$expand?page=2", r4.getExpansion().getExtensionString("http://hl7.org/fhir/5.0/StructureDefinition/extension-ValueSet.expansion.next"));

    ValueSet back = (ValueSet) VersionConvertorFactory_40_N.convertResource(r4);
    assertTrue(src.equalsDeep(back));
  }
}
