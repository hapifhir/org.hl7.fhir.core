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
   * What the answer depends on (see TerminologyCache.DependencyResolver), worked out on a miss, before the answer is
   * (see TerminologyCache.captureDependencies), so that a hit costs no more than it did
   */
  @Getter @Setter
  private Supplier<Map<String, String>> dependencies;

}
