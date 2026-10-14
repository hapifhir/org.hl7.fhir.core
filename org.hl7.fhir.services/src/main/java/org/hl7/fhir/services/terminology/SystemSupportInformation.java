package org.hl7.fhir.services.terminology;

import lombok.Getter;

public class SystemSupportInformation {
  // whether the system(/version) is supported
  @Getter
  private boolean supported;

  // the reason it's not supported (if known)
  private String reason;

  // the server that supports the system(/version)
  // may be null for some systems where we never consult any server
  @Getter
  private String server;

  // if the server supports it, the set of test cases the server claims to pass (or null)
  @Getter
  private String testVersion;

  public boolean isServerSide() {
    return server != null;
  }

  public SystemSupportInformation(boolean supported, String server, String testVersion, String reason) {
    this.supported = supported;
    this.server = server;
    this.testVersion = testVersion;
    this.reason = reason;
  }

  public SystemSupportInformation(boolean supported) {
    this.supported = supported;
  }

  public String reason() {
    return reason;
  }
}
