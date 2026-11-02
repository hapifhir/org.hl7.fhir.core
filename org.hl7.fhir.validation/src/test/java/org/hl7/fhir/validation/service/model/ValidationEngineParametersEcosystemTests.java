package org.hl7.fhir.validation.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.hl7.fhir.utilities.settings.FhirSettings;
import org.junit.jupiter.api.Test;

/**
 * Which ecosystem (tx-reg) a validation uses, when it's set up from ValidationEngineParameters - as the
 * validator wrapper and other library callers do. A terminology server other than the default means no
 * ecosystem unless one is set explicitly, so that requests for a private server aren't routed elsewhere.
 */
class ValidationEngineParametersEcosystemTests {

  @Test
  void defaultServerUsesDefaultEcosystem() {
    ValidationEngineParameters p = new ValidationEngineParameters();
    assertEquals(FhirSettings.getTxEcosystem(), p.getEffectiveEcosystem());
  }

  @Test
  void otherServerUsesNoEcosystem() {
    ValidationEngineParameters p = new ValidationEngineParameters().setTxServer("https://tx.example.org/fhir");
    assertNull(p.getEffectiveEcosystem());
  }

  @Test
  void otherServerWithExplicitEcosystem() {
    ValidationEngineParameters p = new ValidationEngineParameters().setTxServer("https://tx.example.org/fhir").setEcosystem("https://reg.example.org/tx-reg");
    assertEquals("https://reg.example.org/tx-reg", p.getEffectiveEcosystem());
  }

  @Test
  void noEcosystemWins() {
    ValidationEngineParameters p = new ValidationEngineParameters().setEcosystem("https://reg.example.org/tx-reg");
    p.setNoEcosystem(true);
    assertNull(p.getEffectiveEcosystem());
  }
}
