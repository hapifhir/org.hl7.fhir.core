package org.hl7.fhir.validation.cli.picocli.options;

import lombok.AllArgsConstructor;
import lombok.With;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import picocli.CommandLine;

@AllArgsConstructor
public class ManagedWebAccessOptions {

  @CommandLine.Option(names = ("-no-http-access"),
    description = "disable all http(s) access across the application.",
    scope = CommandLine.ScopeType.INHERIT,
    arity = "0")
  @With
  public boolean noHttpAccess = false;

  @CommandLine.Option(names = ("-ssrf-protection-enabled"),
    description = "sets whether or not to enable Server-Side Request Forgery protection. This blocks non-https requests and non-public server access for security reasons. This is enabled by default, and should always be enabled in production. If access to http or non-public servers is required, it should be configured via the fhir-settings.json file",
    scope = CommandLine.ScopeType.INHERIT,
    arity = "1"
  )
  @With
  public boolean ssrfProtectionEnabled = true;

  public void applyOptions() {
    if (noHttpAccess) {
      ManagedWebAccess.setAccessPolicy(ManagedWebAccess.WebAccessPolicy.PROHIBITED);
    }
    ManagedWebAccess.setSsrfProtectionEnabled(ssrfProtectionEnabled);
  }

  public ManagedWebAccessOptions () {
// All public fields should be set in their declaration for Picocli purposes, so we do nothing here.
  }
}
