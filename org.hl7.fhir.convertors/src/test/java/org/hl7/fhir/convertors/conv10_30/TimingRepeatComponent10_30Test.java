package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_30;
import org.hl7.fhir.dstu3.model.Timing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TimingRepeatComponent10_30Test {

  @Test
  @DisplayName("Issue #383 - Test 10_30 TimingRepeatComponent with Timing.when as null")
  public void testMedicationRequestConversion() {
    final int SET_COUNT = 11;
    org.hl7.fhir.dstu2.model.Timing src_timing = new org.hl7.fhir.dstu2.model.Timing();
    org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent src_timing_repeat = new org.hl7.fhir.dstu2.model.Timing.TimingRepeatComponent();
    src_timing_repeat.setCount(SET_COUNT);
    src_timing.setRepeat(src_timing_repeat);

    org.hl7.fhir.dstu3.model.Timing tgt_timing = (Timing) VersionConvertorFactory_10_30.convertType(src_timing);
    org.hl7.fhir.dstu3.model.Timing.TimingRepeatComponent tgt_timing_repeat = tgt_timing.getRepeat();

    Assertions.assertEquals(SET_COUNT, tgt_timing_repeat.getCount(), "Count field not preserved through version conversion.");
    Assertions.assertFalse(tgt_timing_repeat.hasWhen(), "hasWhen() should return false for this conversion.");
    Assertions.assertTrue(tgt_timing_repeat.getWhen().isEmpty(), "When no _when time_ is provided, getWhen() should return an empty list.");
  }
}
