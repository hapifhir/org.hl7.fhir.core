package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamingSystem40_50Test {


  @Test
  @DisplayName("Test r5 -> r4 NamingSystem conversion.")
  public void testR5_R4() throws IOException {
    InputStream r4b_input = this.getClass().getResourceAsStream("/naming_system_r4.xml");

    org.hl7.fhir.r4.model.NamingSystem r4b_actual = (org.hl7.fhir.r4.model.NamingSystem) new org.hl7.fhir.r4.formats.XmlParser().parse(r4b_input);
    org.hl7.fhir.r5.model.NamingSystem r5_conv = (org.hl7.fhir.r5.model.NamingSystem) VersionConvertorFactory_40_50.convertResource(r4b_actual);
    org.hl7.fhir.r4.model.NamingSystem r4b_conv = (org.hl7.fhir.r4.model.NamingSystem) VersionConvertorFactory_40_50.convertResource(r5_conv);

    assertEquals(1, r4b_actual.getExtensionsByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE).size());
    assertEquals(0, r5_conv.getExtensionsByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE).size());
    assertEquals("American Dental Association Area of Oral Cavity System", r5_conv.getTitle());
    assertEquals("http://terminology.hl7.org/NamingSystem/ADAAreaOralCavitySystem", r5_conv.getUrl());
    assertEquals("1.0.0", r5_conv.getVersion());
    assertEquals(1, r4b_conv.getExtensionsByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE).size());
    
  }
}
