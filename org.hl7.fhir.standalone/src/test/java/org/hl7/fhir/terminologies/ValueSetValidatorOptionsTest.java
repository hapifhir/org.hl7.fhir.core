package org.hl7.fhir.terminologies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.StringType;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
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
  private static final String VS_DISPLAY_UZ_URL = "http://example.org/fhir/ValueSet/status-display-uz";
  private static final String VS_PLAIN_URL = "http://example.org/fhir/ValueSet/status";

  private SimpleWorkerContext ctxt;
  // the code's display is the English designation; the code system's own display is Uzbek
  private final CodeableConcept accepted = new CodeableConcept().addCoding(new Coding(CS_URL, "acc", "Accepted"));

  @BeforeEach
  void setUp() throws Exception {
    ctxt = newContext();
  }

  private static SimpleWorkerContext newContext() throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    ctxt.setExpansionParameters(new Parameters());
    CodeSystem cs = new CodeSystem();
    cs.setUrl(CS_URL);
    cs.setVersion("1");
    cs.setLanguage("uz");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("acc").setDisplay("Qabul qilindi").addDesignation().setLanguage("en").setValue("Accepted");
    ctxt.cacheResource(cs);
    ValueSet uz = valueSet(VS_UZ_URL);
    uz.setLanguage("uz");
    ctxt.cacheResource(uz);
    // the language comes from a displayLanguage expansion parameter instead
    ValueSet displayUz = valueSet(VS_DISPLAY_UZ_URL);
    Extension param = displayUz.getCompose().addExtension().setUrl(ExtensionDefinitions.EXT_VS_EXP_PARAM_NEW);
    param.addExtension("name", new StringType("displayLanguage"));
    param.addExtension("value", new CodeType("uz"));
    ctxt.cacheResource(displayUz);
    ctxt.cacheResource(valueSet(VS_PLAIN_URL));
    return ctxt;
  }

  private static ValueSet valueSet(String url) {
    ValueSet vs = new ValueSet();
    vs.setUrl(url);
    vs.setVersion("1");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem(CS_URL);
    return vs;
  }

  private ValueSet fetch(String url) {
    return ctxt.fetchResource(ValueSet.class, url);
  }

  private static boolean memberOf(FHIRPathEngine fpe, CodeableConcept cc, String url) {
    return fpe.evaluateToBoolean(null, null, null, cc, fpe.parse("memberOf('" + url + "')"));
  }

  @Test
  void validateCodeLeavesTheCallersOptionsAlone() {
    ValidationOptions options = new ValidationOptions();
    // the value set's language still applies to its own check: "Accepted" is not the Uzbek display
    assertFalse(ctxt.validateCode(options, accepted, fetch(VS_UZ_URL)).isOk());
    assertFalse(options.hasLanguages());
    assertTrue(ctxt.validateCode(options, accepted, fetch(VS_PLAIN_URL)).isOk());
  }

  @Test
  void displayLanguageParameterDoesNotReplaceTheCallersLanguage() {
    ValidationOptions options = new ValidationOptions().setLanguages("en");
    ctxt.validateCode(options, accepted, fetch(VS_DISPLAY_UZ_URL));
    assertEquals("en", options.getLanguages().getSource());
  }

  @Test
  void memberOfIsNotAffectedByAnEarlierValueSetLanguage() throws Exception {
    FHIRPathEngine fpe = new FHIRPathEngine(ctxt);
    memberOf(fpe, accepted, VS_UZ_URL);
    boolean after = memberOf(fpe, accepted, VS_PLAIN_URL);

    // a fresh engine on its own context, so the answer can't come from the tx cache entry the first engine left
    FHIRPathEngine fresh = new FHIRPathEngine(newContext());
    assertTrue(memberOf(fresh, accepted, VS_PLAIN_URL));
    assertTrue(after);
    assertNull(fpe.getTerminologyServiceOptions().getLanguages());
  }
}
