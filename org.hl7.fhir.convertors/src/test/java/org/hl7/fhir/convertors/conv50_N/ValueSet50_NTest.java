package org.hl7.fhir.convertors.conv50_N;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValueSet50_NTest {

  private static final String EXT_SCOPE = "http://hl7.org/fhir/StructureDefinition/valueset-scope";

  @Test
  @DisplayName("Test ValueSet.scope R5 <-> R6 via the valueset-scope extension")
  public void testScopeConversion50_N() {
    org.hl7.fhir.r5.model.ValueSet r5 = new org.hl7.fhir.r5.model.ValueSet();
    r5.setUrl("http://example.org/fhir/ValueSet/scope-test");
    r5.getScope().setInclusionCriteria("all the codes we want");
    r5.getScope().setExclusionCriteria("none of the ones we don't");

    org.hl7.fhir.model.core.ValueSet r6 = (org.hl7.fhir.model.core.ValueSet) VersionConvertorFactory_50_N.convertResource(r5);
    org.hl7.fhir.model.core.Extension ext = r6.getExtensionByUrl(EXT_SCOPE);
    Assertions.assertNotNull(ext);
    Assertions.assertEquals("all the codes we want", ext.getExtensionByUrl("inclusionCriteria").getValue().primitiveValue());
    Assertions.assertEquals("none of the ones we don't", ext.getExtensionByUrl("exclusionCriteria").getValue().primitiveValue());

    org.hl7.fhir.r5.model.ValueSet back = (org.hl7.fhir.r5.model.ValueSet) VersionConvertorFactory_50_N.convertResource(r6);
    Assertions.assertEquals("all the codes we want", back.getScope().getInclusionCriteria());
    Assertions.assertEquals("none of the ones we don't", back.getScope().getExclusionCriteria());
    Assertions.assertFalse(back.hasExtension(EXT_SCOPE));
  }

  @Test
  @DisplayName("Test ValueSet without scope R5 -> R6 adds no extension")
  public void testNoScopeConversion50_N() {
    org.hl7.fhir.r5.model.ValueSet r5 = new org.hl7.fhir.r5.model.ValueSet();
    r5.setUrl("http://example.org/fhir/ValueSet/no-scope-test");
    org.hl7.fhir.model.core.ValueSet r6 = (org.hl7.fhir.model.core.ValueSet) VersionConvertorFactory_50_N.convertResource(r5);
    Assertions.assertFalse(r6.hasExtension(EXT_SCOPE));
  }
}
