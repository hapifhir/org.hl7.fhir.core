package org.hl7.fhir.utilities;

public class KeyIssuer {

  private String prefix;
  private int lastKey;

  public KeyIssuer(String prefix) {
    super();
    this.prefix = prefix;
  }
  
  public String issueKey() {
    int k = ++lastKey;
    return (prefix == null ? "" : prefix) + k;
  }
}
