package org.hl7.fhir.dstu2016may.model;

import org.junit.jupiter.api.Test;

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
      .addFamily(expected);

    String actual = humanName.getNameAsSingleString();
    assertEquals(expected, actual);
  }

  @Test
  public void getNameAsSingleStringPreferText() {
    final String expected = "dummy value";
    HumanName humanName = new HumanName()
      .setTextElement(new StringType(expected)).addFamily("wrong value");

    String actual = humanName.getNameAsSingleString();
    assertEquals(expected, actual);
  }
}