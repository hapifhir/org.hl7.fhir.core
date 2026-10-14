package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Extensions and modifier extensions on elements and backbone elements are copied in both directions,
 * and elements without any are left without any
 */
public class ElementExtensions40_50Test {

  @Test
  public void extensionsAreCopiedBothWays() {
    org.hl7.fhir.r4.model.Patient src = new org.hl7.fhir.r4.model.Patient();
    org.hl7.fhir.r4.model.HumanName name = src.addName().setFamily("Doe");
    name.addExtension("http://example.org/ext-a", new org.hl7.fhir.r4.model.StringType("a"));
    name.addExtension("http://example.org/ext-b", new org.hl7.fhir.r4.model.StringType("b"));
    org.hl7.fhir.r4.model.Patient.ContactComponent contact = src.addContact();
    contact.setGender(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.FEMALE);
    contact.addModifierExtension().setUrl("http://example.org/mod").setValue(new org.hl7.fhir.r4.model.BooleanType(true));
    src.addContact().setGender(org.hl7.fhir.r4.model.Enumerations.AdministrativeGender.MALE);

    org.hl7.fhir.r5.model.Patient r5 = (org.hl7.fhir.r5.model.Patient) VersionConvertorFactory_40_50.convertResource(src);
    Assertions.assertEquals(2, r5.getNameFirstRep().getExtension().size());
    Assertions.assertEquals("http://example.org/ext-a", r5.getNameFirstRep().getExtension().get(0).getUrl());
    Assertions.assertEquals("b", r5.getNameFirstRep().getExtension().get(1).getValue().primitiveValue());
    Assertions.assertEquals(1, r5.getContact().get(0).getModifierExtension().size());
    Assertions.assertEquals("http://example.org/mod", r5.getContact().get(0).getModifierExtension().get(0).getUrl());
    Assertions.assertFalse(r5.getContact().get(1).hasModifierExtension());
    Assertions.assertFalse(r5.getContact().get(1).hasExtension());

    org.hl7.fhir.r4.model.Patient back = (org.hl7.fhir.r4.model.Patient) VersionConvertorFactory_40_50.convertResource(r5);
    Assertions.assertTrue(src.equalsDeep(back));
  }
}
