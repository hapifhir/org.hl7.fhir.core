package org.hl7.fhir.convertors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VersionConvertor_10_30Test {

  @Test
  @DisplayName("Test 10_30 UnsignedIntType preserves value on conversion.")
  public void testConvertUnsignedInt() {
    org.hl7.fhir.dstu3.model.UnsignedIntType output;
    output = (org.hl7.fhir.dstu3.model.UnsignedIntType)VersionConvertor_10_30.convertType(new org.hl7.fhir.dstu2.model.UnsignedIntType(33));
    Assertions.assertEquals(33, output.getValue().intValue());
  }

}