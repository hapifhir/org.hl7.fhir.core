package org.hl7.fhir.services.terminology;

import java.util.Map;
import java.util.function.Supplier;

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

  /**
   * What the answer depends on (see TerminologyCache.DependencyResolver), worked out only when the answer is stored,
   * so that a look up costs no more than it did
   */
  @Getter @Setter
  private Supplier<Map<String, String>> dependencies;

}
