package org.hl7.fhir.r4.formats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.hl7.fhir.r4.formats.IParser.OutputStyle;
import org.hl7.fhir.r4.model.CarePlan;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * An empty object or array must still be followed by a comma when something comes after it - it used to produce
 * invalid JSON ({}{...}) because only primitive values counted as having been written
 */
class JsonCreatorDirectTest {

  @ParameterizedTest
  @EnumSource(value = OutputStyle.class, names = {"NORMAL", "PRETTY"})
  void testEmptyObjectInArray(OutputStyle style) throws IOException {
    CarePlan cp = new CarePlan();
    cp.addActivity().addOutcomeReference().setReference("Goal/1");
    cp.addActivity(); // empty
    cp.addActivity().addOutcomeReference().setReference("Goal/2");
    String json = new JsonParser().setOutputStyle(style).composeString(cp);
    assertEquals("{\"resourceType\":\"CarePlan\",\"activity\":[{\"outcomeReference\":[{\"reference\":\"Goal/1\"}]},{},{\"outcomeReference\":[{\"reference\":\"Goal/2\"}]}]}",
      json.replaceAll("\\s", ""));
    // and it reads back
    CarePlan back = (CarePlan) new JsonParser().parse(json);
    assertEquals(3, back.getActivity().size());
    assertEquals("Goal/2", back.getActivity().get(2).getOutcomeReferenceFirstRep().getReference());
  }

  @ParameterizedTest
  @EnumSource(value = OutputStyle.class, names = {"NORMAL", "PRETTY"})
  void testEmptyObjectFirstInArray(OutputStyle style) throws IOException {
    CarePlan cp = new CarePlan();
    cp.addActivity(); // empty
    cp.addActivity().addOutcomeReference().setReference("Goal/2");
    String json = new JsonParser().setOutputStyle(style).composeString(cp);
    assertEquals("{\"resourceType\":\"CarePlan\",\"activity\":[{},{\"outcomeReference\":[{\"reference\":\"Goal/2\"}]}]}",
      json.replaceAll("\\s", ""));
  }
}
