package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.utilities.http.ManagedWebAccess;
import picocli.CommandLine;

public class HttpAccessOptions implements GlobalOptions{
  public static final String NO_HTTP_ACCESS = "-no-http-access";

  @CommandLine.Option(names = (NO_HTTP_ACCESS))
  public boolean noHttpAccess = false;

  @Override
  public int apply(CommandLine.ParseResult parseResult) {
    if (parseResult.hasMatchedOption(NO_HTTP_ACCESS)) {
      ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.PROHIBITED);
    }
    return 0;
  }
}
