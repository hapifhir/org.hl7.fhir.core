package org.hl7.fhir.r5.terminologies.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

/**
 * Regression tests for #2540: ValueSetValidator.resolveCodeSystem dereferenced cs without a
 * null check while merging required supplements, so a ValueSet that declares a supplement and
 * includes a code system the context cannot resolve threw NPE from the constructor.
 */
class ValueSetValidatorSupplementTest {

  private static final String SUPPLEMENT_URL = "http://example.org/fhir/CodeSystem/supplement";
  private static final String SUPPLEMENTED_URL = "http://example.org/fhir/CodeSystem/base";
  private static final String UNRESOLVABLE_URL = "http://example.org/fhir/CodeSystem/not-here";

  private SimpleWorkerContext contextWithSupplement() throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    CodeSystem supplement = new CodeSystem();
    supplement.setUrl(SUPPLEMENT_URL);
    supplement.setStatus(PublicationStatus.ACTIVE);
    supplement.setContent(CodeSystemContentMode.SUPPLEMENT);
    supplement.setSupplements(SUPPLEMENTED_URL);
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
   * A server-side code system can't have the supplement merged into it locally, so the membership
   * check sent to the server has to carry it, rather than the supplement being reported as not found.
   */
  @Test
  void requiredSupplementForServerSideSystemIsSentToServer() throws Exception {
    ArgumentCaptor<ValueSet> sent = ArgumentCaptor.forClass(ValueSet.class);
    ValueSetValidator vsv = validatorWithServer(SUPPLEMENT_URL, sent);
    ValidationResult res = assertDoesNotThrow(() -> vsv.validateCode(new CodeableConcept(new Coding(SUPPLEMENTED_URL, "x", null))));
    assertTrue(res.isOk());
    ValueSet toServer = sent.getAllValues().stream().filter(Objects::nonNull).findFirst().orElseThrow();
    assertEquals(SUPPLEMENT_URL, toServer.getExtensionString(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED));
  }

  /** A required supplement that can't be found is still an error when the code system is server-side. */
  @Test
  void missingSupplementForServerSideSystemIsStillReported() throws Exception {
    ValueSetValidator vsv = validatorWithServer("http://example.org/fhir/CodeSystem/missing-supplement", ArgumentCaptor.forClass(ValueSet.class));
    assertThrows(TerminologyServiceProtectionException.class, () -> vsv.validateCode(new CodeableConcept(new Coding(SUPPLEMENTED_URL, "x", null))));
  }

  private ValueSetValidator validatorWithServer(String supplement, ArgumentCaptor<ValueSet> sent) throws Exception {
    SimpleWorkerContext ctxt = spy(contextWithSupplement());
    doReturn(false).when(ctxt).isNoTerminologyServer();
    doReturn(new ValidationResult(SUPPLEMENTED_URL, null, new ConceptDefinitionComponent("x"), "x"))
        .when(ctxt).validateCode(any(ValidationOptions.class), any(Coding.class), sent.capture());
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/test3");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.addExtension(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED, new org.hl7.fhir.r5.model.CanonicalType(supplement));
    vs.getCompose().addInclude().setSystem(SUPPLEMENTED_URL);
    ValueSetValidator vsv = newValidator(ctxt, vs);
    vsv.setThrowToServer(true);
    return vsv;
  }
}
