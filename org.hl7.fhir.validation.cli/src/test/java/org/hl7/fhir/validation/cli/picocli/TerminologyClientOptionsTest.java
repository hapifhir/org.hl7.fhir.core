package org.hl7.fhir.validation.cli.picocli;

import static org.assertj.core.api.Assertions.assertThat;

import org.hl7.fhir.standalone.terminology.client.TerminologyClientContext;
import org.hl7.fhir.validation.cli.picocli.options.TerminologyClientOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/**
 * -authorise-non-conformant-tx-servers must set the flags on the TerminologyClientContext that
 * the validator actually connects through (the org.hl7.fhir.standalone copy), not on the r5 copy,
 * which nothing in the validator reads any more. See core issue #2695.
 */
public class TerminologyClientOptionsTest {

  @AfterEach
  public void resetStatics() {
    TerminologyClientContext.setAllowNonConformantServers(false);
    TerminologyClientContext.setCanAllowNonConformantServers(false);
  }

  @Test
  public void testAuthoriseSetsStandaloneFlags() {
    new TerminologyClientOptions().setAuthNonconformantServers(true);
    assertThat(TerminologyClientContext.isAllowNonConformantServers()).isTrue();
    assertThat(TerminologyClientContext.isCanAllowNonConformantServers()).isTrue();
  }

  @Test
  public void testNotAuthorisedOnlyEnablesTheHint() {
    new TerminologyClientOptions().setAuthNonconformantServers(false);
    assertThat(TerminologyClientContext.isAllowNonConformantServers()).isFalse();
    assertThat(TerminologyClientContext.isCanAllowNonConformantServers()).isTrue();
  }
}
