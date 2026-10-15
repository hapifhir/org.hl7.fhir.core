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

}
