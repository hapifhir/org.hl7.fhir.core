package org.hl7.fhir.r5.terminologies.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.Objects;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext.TerminologyServiceProtectionException;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.r5.utils.validation.ValidationContextCarrier;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;

/**
 * Required supplements to code systems the context can't resolve.
 * <p>
 * #2540: ValueSetValidator.resolveCodeSystem dereferenced cs without a null check while merging
 * required supplements, so a ValueSet that declares a supplement and includes a code system the
 * context cannot resolve threw NPE from the constructor.
 * <p>
 * #2636: codes from such a code system are checked on the terminology server, so the supplement
 * has to go with the check, and count as used, rather than failing every code with "Required
 * supplement not found".
 */
class ValueSetValidatorSupplementTest {

  private static final String SUPPLEMENT_URL = "http://example.org/fhir/CodeSystem/supplement";
  private static final String SUPPLEMENTED_URL = "http://example.org/fhir/CodeSystem/base";
  private static final String UNRESOLVABLE_URL = "http://example.org/fhir/CodeSystem/not-here";
  private static final String LOCAL_URL = "http://example.org/fhir/CodeSystem/local";

  private final ArgumentCaptor<ValueSet> sent = ArgumentCaptor.forClass(ValueSet.class);

  private SimpleWorkerContext contextWithSupplement() throws Exception {
    return contextWithSupplement(SUPPLEMENTED_URL);
  }

  private SimpleWorkerContext contextWithSupplement(String supplementTarget) throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    CodeSystem supplement = new CodeSystem();
    supplement.setUrl(SUPPLEMENT_URL);
    supplement.setStatus(PublicationStatus.ACTIVE);
    supplement.setContent(CodeSystemContentMode.SUPPLEMENT);
    supplement.setSupplements(supplementTarget);
    ctxt.cacheResource(supplement);
    return ctxt;
  }

  /** ValueSet that requires a (resolvable) supplement but includes an unresolvable system. */
  private ValueSet valueSetRequiringSupplement() {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/test");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.addExtension("http://hl7.org/fhir/StructureDefinition/valueset-supplement",
        new org.hl7.fhir.r5.model.CanonicalType(SUPPLEMENT_URL));
    vs.getCompose().addInclude().setSystem(UNRESOLVABLE_URL);
    return vs;
  }

  private ValueSetValidator newValidator(SimpleWorkerContext ctxt, ValueSet vs) {
    ValidationOptions options = new ValidationOptions();
    return new ValueSetValidator(ctxt, new TerminologyOperationContext(ctxt, options, "validation"),
        options, vs, new Parameters(), null, null);
  }

  @Test
  void constructorDoesNotThrowWhenIncludedCodeSystemIsUnresolvable() throws Exception {
    SimpleWorkerContext ctxt = contextWithSupplement();
    ValueSet vs = valueSetRequiringSupplement();
    assertNotNull(assertDoesNotThrow(() -> newValidator(ctxt, vs)));
  }

  @Test
  void resolveCodeSystemReturnsNullForUnresolvableSystemWithRequiredSupplement()
      throws Exception {
    SimpleWorkerContext ctxt = contextWithSupplement();
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/test2");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.addExtension("http://hl7.org/fhir/StructureDefinition/valueset-supplement",
        new org.hl7.fhir.r5.model.CanonicalType(SUPPLEMENT_URL));
    // no include - constructor does no eager resolution, so we can call resolveCodeSystem directly
    ValueSetValidator vsv = newValidator(ctxt, vs);
    assertNull(assertDoesNotThrow(
        () -> vsv.resolveCodeSystem(UNRESOLVABLE_URL, null, null, vs)));
  }

  /** The ValidationContextCarrier constructor takes the same path. */
  @Test
  void constructorWithLocalContextDoesNotThrow() throws Exception {
    SimpleWorkerContext ctxt = contextWithSupplement();
    ValueSet vs = valueSetRequiringSupplement();
    ValidationOptions options = new ValidationOptions();
    assertNotNull(assertDoesNotThrow(() -> new ValueSetValidator(ctxt,
        new TerminologyOperationContext(ctxt, options, "validation"), options, vs,
        new ValidationContextCarrier(), new Parameters(), null, null)));
  }

  /**
   * A code system we don't have locally can't have the supplement merged into it, so the membership
   * check sent to the server has to carry it, rather than the supplement being reported as not found.
   */
  @Test
  void requiredSupplementIsSentToServer() throws Exception {
    ValueSetValidator vsv = validatorWithServer(SUPPLEMENTED_URL, SUPPLEMENT_URL, null, false, new ValidationOptions());
    ValidationResult res = assertDoesNotThrow(() -> vsv.validateCode(new CodeableConcept(new Coding(SUPPLEMENTED_URL, "x", null))));
    assertTrue(res.isOk());
    assertEquals(SUPPLEMENT_URL, sentToServer().getExtensionString(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED));
  }

  /** A required supplement that can't be found is still an error. */
  @Test
  void missingSupplementIsStillReported() throws Exception {
    ValueSetValidator vsv = validatorWithServer(SUPPLEMENTED_URL, "http://example.org/fhir/CodeSystem/missing-supplement", null, false, new ValidationOptions());
    assertSupplementMissing(() -> vsv.validateCode(new CodeableConcept(new Coding(SUPPLEMENTED_URL, "x", null))));
  }

  /** A supplement to one version of the code system is sent when that version is the one being checked. */
  @Test
  void versionedSupplementIsSentForItsVersion() throws Exception {
    ValueSetValidator vsv = validatorWithServer(SUPPLEMENTED_URL + "|1.0", SUPPLEMENT_URL, "1.0", false, new ValidationOptions());
    ValidationResult res = assertDoesNotThrow(() -> vsv.validateCode(new CodeableConcept(new Coding(SUPPLEMENTED_URL, "x", null))));
    assertTrue(res.isOk());
    assertEquals(SUPPLEMENT_URL, sentToServer().getExtensionString(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED));
  }

  /** It doesn't apply to another version, so it isn't sent, and is still reported as not found. */
  @Test
  void versionedSupplementIsNotSentForAnotherVersion() throws Exception {
    ValueSetValidator vsv = validatorWithServer(SUPPLEMENTED_URL + "|1.0", SUPPLEMENT_URL, "2.0", false, new ValidationOptions());
    assertSupplementMissing(() -> vsv.validateCode(new CodeableConcept(new Coding(SUPPLEMENTED_URL, "x", null))));
    assertFalse(sentToServer().hasExtension(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED));
  }

  /** A code from another, local, code system in the value set never reaches the server, but the supplement is still found. */
  @Test
  void supplementIsFoundForCodeFromAnotherSystem() throws Exception {
    ValueSetValidator vsv = validatorWithServer(SUPPLEMENTED_URL, SUPPLEMENT_URL, null, true, new ValidationOptions());
    ValidationResult res = assertDoesNotThrow(() -> vsv.validateCode(new CodeableConcept(new Coding(LOCAL_URL, "a", null))));
    assertTrue(res.isOk());
  }

  /** When only membership is checked, the supplement check comes before the server is asked. */
  @Test
  void supplementIsFoundWhenOnlyMembershipIsChecked() throws Exception {
    ValueSetValidator vsv = validatorWithServer(SUPPLEMENTED_URL, SUPPLEMENT_URL, null, false, new ValidationOptions().withCheckValueSetOnly());
    ValidationResult res = assertDoesNotThrow(() -> vsv.validateCode(new Coding(SUPPLEMENTED_URL, "x", null)));
    assertTrue(res.isOk());
    assertEquals(SUPPLEMENT_URL, sentToServer().getExtensionString(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED));
  }

  private void assertSupplementMissing(Executable validation) {
    TerminologyServiceProtectionException e = assertThrows(TerminologyServiceProtectionException.class, validation);
    assertEquals(I18nConstants.VALUESET_SUPPLEMENT_MISSING, e.getMsgId());
  }

  // validation of the codings themselves passes a null value set
  private ValueSet sentToServer() {
    return sent.getAllValues().stream().filter(Objects::nonNull).findFirst().orElseThrow();
  }

  private ValueSetValidator validatorWithServer(String supplementTarget, String supplement, String includeVersion, boolean withLocalSystem, ValidationOptions options) throws Exception {
    SimpleWorkerContext ctxt = spy(contextWithSupplement(supplementTarget));
    doReturn(false).when(ctxt).isNoTerminologyServer();
    doReturn(new ValidationResult(SUPPLEMENTED_URL, null, new ConceptDefinitionComponent("x"), "x"))
        .when(ctxt).validateCode(any(ValidationOptions.class), any(Coding.class), sent.capture());
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/test3");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.addExtension(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED, new org.hl7.fhir.r5.model.CanonicalType(supplement));
    if (withLocalSystem) {
      CodeSystem local = new CodeSystem();
      local.setUrl(LOCAL_URL);
      local.setStatus(PublicationStatus.ACTIVE);
      local.setContent(CodeSystemContentMode.COMPLETE);
      local.addConcept().setCode("a").setDisplay("A");
      ctxt.cacheResource(local);
      vs.getCompose().addInclude().setSystem(LOCAL_URL);
    }
    vs.getCompose().addInclude().setSystem(SUPPLEMENTED_URL).setVersion(includeVersion);
    ValueSetValidator vsv = new ValueSetValidator(ctxt, new TerminologyOperationContext(ctxt, options, "validation"),
        options, vs, new Parameters(), null, null);
    vsv.setThrowToServer(true);
    return vsv;
  }
}
