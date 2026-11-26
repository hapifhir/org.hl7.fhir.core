package org.hl7.fhir.validation.tests;

import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.utilities.npm.RegistryAnswerCache;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * The registry answers the IG validator keeps belong to the host: an engine shares one cache with the validators
 * it makes, and a host can give it its own.
 */
class RegistryAnswerCacheEngineTests {

  @Test
  void validatorsShareTheEnginesCache() throws Exception {
    ValidationEngine engine = TestUtilities.getValidationEngineNoTxServer("hl7.fhir.r5.core#5.0.0", "5.0.0");
    RegistryAnswerCache answers = engine.getRegistryAnswerCache();
    assertNotNull(answers);
    assertSame(answers, engine.getValidator(FhirFormat.JSON).getSettings().getRegistryAnswerCache());
    assertSame(answers, engine.getValidator(FhirFormat.XML).getSettings().getRegistryAnswerCache());
    assertSame(answers, new ValidationEngine(engine).getValidator(FhirFormat.JSON).getSettings().getRegistryAnswerCache());

    RegistryAnswerCache hosts = new RegistryAnswerCache();
    engine.setRegistryAnswerCache(hosts);
    assertSame(hosts, engine.getValidator(FhirFormat.JSON).getSettings().getRegistryAnswerCache());
  }
}
