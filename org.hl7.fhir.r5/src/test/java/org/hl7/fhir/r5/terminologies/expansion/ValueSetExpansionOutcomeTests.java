package org.hl7.fhir.r5.terminologies.expansion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.junit.jupiter.api.Test;

class ValueSetExpansionOutcomeTests {

  @Test
  void testNullErrListIsAllowed() {
    ValueSetExpansionOutcome o = new ValueSetExpansionOutcome("err", TerminologyServiceErrorClass.NOSERVICE, null, false);
    assertEquals(List.of("err"), o.getAllErrors());
    o = new ValueSetExpansionOutcome("err", TerminologyServiceErrorClass.NOSERVICE, null, false, null, null);
    assertEquals(List.of("err"), o.getAllErrors());
    o = new ValueSetExpansionOutcome("err", TerminologyServiceErrorClass.NOSERVICE, null, (List) null);
    assertEquals(List.of("err"), o.getAllErrors());
  }

  @Test
  void testErrListReceivesError() {
    List<String> errs = new ArrayList<>();
    ValueSetExpansionOutcome o = new ValueSetExpansionOutcome("err", TerminologyServiceErrorClass.NOSERVICE, errs, false);
    assertEquals(List.of("err"), errs);
    assertEquals(List.of("err"), o.getAllErrors());
  }
}
