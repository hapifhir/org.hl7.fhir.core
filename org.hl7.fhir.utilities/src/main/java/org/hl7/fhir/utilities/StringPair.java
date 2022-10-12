package org.hl7.fhir.utilities;

public class StringPair {
  private String name;
  private String value;

  public StringPair(String name, String value) {
    super();
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public String getValue() {
    return value;
  }
}
