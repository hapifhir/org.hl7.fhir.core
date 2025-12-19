package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.utilities.http.ManagedWebAccess;
import picocli.CommandLine;

public class HttpAccessOptions {
  public static final String NO_HTTP_ACCESS = "-no-http-access";

  @CommandLine.Option(names = (NO_HTTP_ACCESS), scope = CommandLine.ScopeType.INHERIT)
  public void setNoHttpAccess(boolean noHttpAccess) {
    if (noHttpAccess) {
      ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.PROHIBITED);
    }
  }
}
