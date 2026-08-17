package org.hl7.fhir.context.terminology;

import lombok.Getter;
import lombok.experimental.Accessors;

public class CacheToken {
  @Getter
  private String name;
  private String key;
  @Getter
  private String request;
  @Accessors(fluent = true)
  @Getter
  private boolean hasVersion;

//  public void setName(String n) {
//    String systemName = getSystemNameKeyGenerator().getNameForSystem(n);
//    if (name == null)
//      name = systemName;
//    else if (!systemName.equals(name))
//      name = NAME_FOR_NO_SYSTEM;
//  }
}
