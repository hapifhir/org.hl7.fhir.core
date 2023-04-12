package org.hl7.fhir.r5.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanNameTest {

  @Test
  public void getNameAsSingleStringWithoutFamilyElement() {
    final String expected = "dummy value";
    HumanName humanName = new HumanName()
      .setTextElement(new StringType(expected));

    String actual = humanName.getNameAsSingleString();
    assertEquals(expected, actual);
  }

  @Test
  public void getNameAsSingleStringWithFamilyElement() {
    final String expected = "good value";
    HumanName humanName = new HumanName()
      .setFamily(expected);

    String actual = humanName.getNameAsSingleString();
    assertEquals(expected, actual);
  }
}
