package org.hl7.fhir.convertors.conv50_N;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Extensions and modifier extensions on elements and backbone elements are copied in both directions,
 * and elements without any are left without any
 */
public class ElementExtensions50_NTest {

  @Test
  public void extensionsAreCopiedBothWays() {
    org.hl7.fhir.r5.model.Patient src = new org.hl7.fhir.r5.model.Patient();
    org.hl7.fhir.r5.model.HumanName name = src.addName().setFamily("Doe");
    name.addExtension("http://example.org/ext-a", new org.hl7.fhir.r5.model.StringType("a"));
    name.addExtension("http://example.org/ext-b", new org.hl7.fhir.r5.model.StringType("b"));
    org.hl7.fhir.r5.model.Patient.ContactComponent contact = src.addContact();
    contact.setGender(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.FEMALE);
    contact.addModifierExtension().setUrl("http://example.org/mod").setValue(new org.hl7.fhir.r5.model.BooleanType(true));
    src.addContact().setGender(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.MALE);

    org.hl7.fhir.model.core.Patient r6 = (org.hl7.fhir.model.core.Patient) VersionConvertorFactory_50_N.convertResource(src);
    Assertions.assertEquals(2, r6.getNameFirstRep().getExtension().size());
    Assertions.assertEquals("http://example.org/ext-a", r6.getNameFirstRep().getExtension().get(0).getUrl());
    Assertions.assertEquals("b", r6.getNameFirstRep().getExtension().get(1).getValue().primitiveValue());
    Assertions.assertEquals(1, r6.getContactList().get(0).getModifierExtensionList().size());
    Assertions.assertEquals("http://example.org/mod", r6.getContactList().get(0).getModifierExtensionList().get(0).getUrl());
    Assertions.assertFalse(r6.getContactList().get(1).hasModifierExtension());
    Assertions.assertFalse(r6.getContactList().get(1).hasExtension());

    org.hl7.fhir.r5.model.Patient back = (org.hl7.fhir.r5.model.Patient) VersionConvertorFactory_50_N.convertResource(r6);
    Assertions.assertTrue(src.equalsDeep(back));
  }
}
