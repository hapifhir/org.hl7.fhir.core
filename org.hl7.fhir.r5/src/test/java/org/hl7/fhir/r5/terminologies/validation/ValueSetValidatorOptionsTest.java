package org.hl7.fhir.r5.terminologies.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Checking a CodeableConcept against a value set that has a language used to add that language to the caller's
 * ValidationOptions (ValueSetValidator kept the caller's object and checkValueSetOptions() changed it). For
 * memberOf() that is the FHIRPath engine's own options, so every later memberOf() checked displays in that
 * language.
 */
class ValueSetValidatorOptionsTest {

  private static final String CS_URL = "http://example.org/fhir/CodeSystem/status";
  private static final String VS_UZ_URL = "http://example.org/fhir/ValueSet/status-uz";
  private static final String VS_PLAIN_URL = "http://example.org/fhir/ValueSet/status";

  private SimpleWorkerContext ctxt;
  // the code's display is the English designation; the code system's own display is Uzbek
  private final CodeableConcept accepted = new CodeableConcept().addCoding(new Coding(CS_URL, "acc", "Accepted"));

  @BeforeEach
  void setUp() throws Exception {
    ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    ctxt.setExpansionParameters(new Parameters());
    CodeSystem cs = new CodeSystem();
    cs.setUrl(CS_URL);
    cs.setVersion("1");
    cs.setLanguage("uz");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("acc").setDisplay("Qabul qilindi").addDesignation().setLanguage("en").setValue("Accepted");
    ctxt.cacheResource(cs);
    ctxt.cacheResource(valueSet(VS_UZ_URL, "uz"));
    ctxt.cacheResource(valueSet(VS_PLAIN_URL, null));
  }

  private static ValueSet valueSet(String url, String language) {
    ValueSet vs = new ValueSet();
    vs.setUrl(url);
    vs.setVersion("1");
    vs.setStatus(PublicationStatus.ACTIVE);
    if (language != null) {
      vs.setLanguage(language);
    }
    vs.getCompose().addInclude().setSystem(CS_URL);
    return vs;
  }

  private static boolean memberOf(FHIRPathEngine fpe, CodeableConcept cc, String url) {
    return fpe.evaluateToBoolean(null, null, null, cc, fpe.parse("memberOf('" + url + "')"));
  }

  @Test
  void validateCodeLeavesTheCallersOptionsAlone() {
    ValidationOptions options = new ValidationOptions();
    ctxt.validateCode(options, accepted, ctxt.fetchResource(ValueSet.class, VS_UZ_URL));
    assertFalse(options.hasLanguages());
  }

  @Test
  void memberOfIsNotAffectedByAnEarlierValueSetLanguage() {
    FHIRPathEngine fpe = new FHIRPathEngine(ctxt);
    memberOf(fpe, accepted, VS_UZ_URL);
    boolean after = memberOf(fpe, accepted, VS_PLAIN_URL);

    FHIRPathEngine fresh = new FHIRPathEngine(ctxt);
    boolean onFreshEngine = memberOf(fresh, accepted, VS_PLAIN_URL);
    assertTrue(onFreshEngine);
    assertEquals(onFreshEngine, after);
    assertNull(fpe.getTerminologyServiceOptions().getLanguages());
  }
}
