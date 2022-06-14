package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.dstu3.model.StructureDefinition;
import org.hl7.fhir.exceptions.FHIRFormatError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class Extension30_40Test {
  
  private void convert(String filename) throws FHIRFormatError, IOException {    
    InputStream r3_input = this.getClass().getResourceAsStream("/"+filename);

    org.hl7.fhir.dstu3.model.StructureDefinition r3_source = (org.hl7.fhir.dstu3.model.StructureDefinition) new org.hl7.fhir.dstu3.formats.JsonParser().parse(r3_input);
    org.hl7.fhir.r4.model.Resource r4 = VersionConvertorFactory_30_40.convertResource(r3_source, new BaseAdvisor_30_40(false));
    org.hl7.fhir.dstu3.model.StructureDefinition r3_roundtrip = (StructureDefinition) VersionConvertorFactory_30_40.convertResource(r4, new BaseAdvisor_30_40(false));

    Assertions.assertTrue(r3_source.getContextType().equals(r3_roundtrip.getContextType()),
      "Failed comparing " + r3_source.getContextType() + " and " + r3_roundtrip.getContextType());
  }
  
  @Test
  public void testExtension_r3_res_base() throws IOException {
    convert("extension_r3_res_base.json");
  }


  @Test
  public void testExtension_r3_res_path() throws IOException {
    convert("extension_r3_res_path.json");
  }

  @Test
  public void testExtension_r3_dt_base() throws IOException {
    convert("extension_r3_dt_base.json");
  }

  @Test
  public void testExtension_r3_dt_path() throws IOException {
    convert("extension_r3_dt_path.json");
  }
}