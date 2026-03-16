package org.hl7.fhir.utilities.http;

import lombok.Getter;
import org.hl7.fhir.utilities.settings.ServerDetailsPOJO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ManagedWebAccessorBase<B extends ManagedWebAccessorBase<B>> {
  @Getter
  private final Iterable<String> serverTypes;
  
  @Getter
  private final String userAgent;

  @Getter
  private final IHTTPAuthenticationProvider httpAuthHeaderProvider;

  @Getter
  private final Map<String, String> headers = new HashMap<>();

  ManagedWebAccessorBase(Iterable<String> serverTypes, String userAgent, IHTTPAuthenticationProvider httpAuthHeaderProvider) {
    this.serverTypes = serverTypes;
    this.userAgent = userAgent;
    this.httpAuthHeaderProvider = httpAuthHeaderProvider;
  }
}
