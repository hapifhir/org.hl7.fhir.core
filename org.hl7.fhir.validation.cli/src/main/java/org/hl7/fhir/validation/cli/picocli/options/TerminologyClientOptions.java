package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import picocli.CommandLine;

public class TerminologyClientOptions implements GlobalOptions{
  public static final String AUTH_NONCONFORMANT_SERVERS
    = "-authorise-non-conformant-tx-servers";
  @CommandLine.Option(names = (AUTH_NONCONFORMANT_SERVERS))
  public boolean authorizeNonConformantServers = false;

  @Override
  public int apply(CommandLine.ParseResult parseResult) {
    if (parseResult.hasMatchedOption(AUTH_NONCONFORMANT_SERVERS)) {
      TerminologyClientContext.setAllowNonConformantServers(true);
    }
    TerminologyClientContext.setCanAllowNonConformantServers(true);
    return 0;
  }
}
