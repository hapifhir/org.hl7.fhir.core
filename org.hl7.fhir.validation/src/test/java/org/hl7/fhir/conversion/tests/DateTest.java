package org.hl7.fhir.conversion.tests;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTest {
  @Test
  public void testDateConversion() {
    org.hl7.fhir.r4.model.DateType date4 = new org.hl7.fhir.r4.model.DateType();
    date4.setValueAsString("1933");
    org.hl7.fhir.r5.model.DateType date5 = ( org.hl7.fhir.r5.model.DateType) VersionConvertorFactory_40_50.convertType(date4);
    Assertions.assertEquals(date4.getValueAsString(), date5.getValueAsString());
  }
}
