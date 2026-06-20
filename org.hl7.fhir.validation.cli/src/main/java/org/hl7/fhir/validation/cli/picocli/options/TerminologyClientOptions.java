package org.hl7.fhir.validation.cli.picocli.options;

import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import picocli.CommandLine;

public class TerminologyClientOptions {
  public static final String AUTH_NONCONFORMANT_SERVERS
    = "-authorise-non-conformant-tx-servers";
  @CommandLine.Option(names = (AUTH_NONCONFORMANT_SERVERS), scope = CommandLine.ScopeType.INHERIT)
  public void setAuthNonconformantServers(boolean authorizeNonConformantServers) {
    if (authorizeNonConformantServers) {
      TerminologyClientContext.setAllowNonConformantServers(true);
    }
    TerminologyClientContext.setCanAllowNonConformantServers(true);
  }
}
