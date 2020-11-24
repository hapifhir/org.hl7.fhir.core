package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimingRepeatComponent10_30Test {

  @Test
  @DisplayName("Issue #383 - Test 10_30 TimingRepeatComponent with Timing.when as null")
  public void testMedicationRequestConversion() {
    final int SET_COUNT = 11;
    org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent src = new org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent();
    src.setCount(SET_COUNT);

    org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent tgt = VersionConvertor_10_30.convertTimingRepeatComponent(src);

    Assertions.assertEquals(SET_COUNT, tgt.getCount(), "Count field not preserved through version conversion.");
    Assertions.assertFalse(tgt.hasWhen(), "hasWhen() should return false for this conversion.");
    Assertions.assertTrue(tgt.getWhen().isEmpty(), "When no _when time_ is provided, getWhen() should return an empty list.");
  }

}
