package org.hl7.fhir.validation.cli.picocli.options;

import picocli.CommandLine;

public class WatchOptions {

  @CommandLine.Option(
    names = {"-watch-mode"},
    description = """
    Specify that the validator remain running and re-validate when any of the validated files changes.
    Valid values:
    * none (default - don't wait, just stop when finished)
    * single (when any of the validated files changes, re-validate it)
    * all (when any of the validated files change, re-validate all of them)
    ll is useful when the content includes internal dependencies e.g.\s
           a profile and it's value sets.
    The validator has to be terminated with ctrl-c etc in this mode.
    """
  )
  public String watchMode = null;

  @CommandLine.Option(
    names = {"-watch-scan-delay"},
    description = "Control how often the validator looks at the content to decide to run again (in milliseconds). Default: 1000"
  )
  public int watchScanDelay = 1000;

  @CommandLine.Option(
    names = {"-watch-settle-time"},
    description = "Control how long the validator waits before seeing a change, and revalidating (in milliseconds). Default: 100"
  )
  public int watchSettleTime = 100;
}
