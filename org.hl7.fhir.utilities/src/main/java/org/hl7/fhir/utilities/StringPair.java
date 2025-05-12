package org.hl7.fhir.utilities;

import java.util.Comparator;

public class StringPair {
  
  public static class Sorter implements Comparator<StringPair> {

    @Override
    public int compare(StringPair o1, StringPair o2) {
      int res = o1.name.compareTo(o2.name);
      if (res == 0) {
        res = o1.value.compareTo(o2.value);
      }
      return res;
    }
    
  }
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
