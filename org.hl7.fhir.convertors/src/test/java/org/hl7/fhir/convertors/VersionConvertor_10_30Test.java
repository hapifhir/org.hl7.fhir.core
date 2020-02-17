package org.hl7.fhir.convertors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VersionConvertor_10_30Test {

  @Test
  public void testConvertUnsignedInt() {

    org.hl7.fhir.dstu3.model.UnsignedIntType output;
    output = (org.hl7.fhir.dstu3.model.UnsignedIntType)VersionConvertor_10_30.convertType(new org.hl7.fhir.dstu2.model.UnsignedIntType(33));
    assertEquals(33, output.getValue().intValue());

  }

}
