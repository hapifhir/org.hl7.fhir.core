package org.hl7.fhir.services.terminology;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

public class CacheToken {
  @Getter @Setter
  private String name;

  @Getter @Setter
  private String key;
  @Getter @Setter
  private String request;

  @Getter @Setter
  private boolean hasVersion;

//  public void setName(String n) {
//    String systemName = getSystemNameKeyGenerator().getNameForSystem(n);
//    if (name == null)
//      name = systemName;
//    else if (!systemName.equals(name))
//      name = NAME_FOR_NO_SYSTEM;
//  }
}
