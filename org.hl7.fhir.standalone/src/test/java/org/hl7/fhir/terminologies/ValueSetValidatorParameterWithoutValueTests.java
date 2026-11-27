package org.hl7.fhir.terminologies;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.HashSet;

import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.services.terminology.ValidationContextCarrier;
import org.hl7.fhir.services.terminology.ValidationResult;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.terminology.client.TerminologyClientManager;
import org.hl7.fhir.standalone.terminology.utilities.TerminologyOperationContext;
import org.hl7.fhir.standalone.terminology.validation.ValueSetValidator;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;

/**
 * Parameters and properties without a value are skipped, not dereferenced. ValueSet.expansion.parameter.value[x] and
 * Parameters.parameter.value[x] are 0..1, and terminology servers report such parameters
 * (HL7/fhir-ig-publisher#1490).
 */
class ValueSetValidatorParameterWithoutValueTests {

  private static final String LOCAL = "http://example.org/fhir/CodeSystem/local";
  private static final String UNKNOWN = "http://example.org/fhir/CodeSystem/unknown";

  private static ValueSet valueSet(String system) {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/test");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem(system);
    return vs;
  }

  // as the worker context makes it (constructValueSetCheckerSimple)
  private static ValueSetValidator validator(SimpleWorkerContext context, ValueSet vs, Parameters params) {
    ValidationOptions options = new ValidationOptions();
    ValueSetValidator vsv = new ValueSetValidator(context, new TerminologyOperationContext(context, options, "validation"),
        options, vs, new ValidationContextCarrier(), params, mock(TerminologyClientManager.class), null);
    vsv.setUnknownSystems(new HashSet<>());
    return vsv;
  }

  /** A useSupplement parameter without a value. */
  @Test
  void useSupplementWithoutValue() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    Parameters params = new Parameters();
    params.addParameter().setName("useSupplement");

    assertDoesNotThrow(() -> validator(context, valueSet(LOCAL), params));
  }

  /** The expansion of a value set whose code system is unknown has a used-supplement parameter without a value. */
  @Test
  void usedSupplementWithoutValueInExpansion() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    ValueSet vs = valueSet(UNKNOWN);
    vs.getExpansion().addParameter().setName("used-supplement");
    vs.getExpansion().addContains().setSystem(UNKNOWN).setCode("x");
    ValueSetValidator vsv = validator(context, vs, new Parameters());

    ValidationResult res = assertDoesNotThrow(() -> vsv.validateCode(new Coding(UNKNOWN, "x", null)));
    assertTrue(res.isOk(), res.getMessage());
  }

  /** A concept of a local code system has an alternateCode property without a value. */
  @Test
  void alternateCodeWithoutValueInCodeSystem() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    CodeSystem cs = new CodeSystem();
    cs.setUrl(LOCAL);
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("a").addProperty().setCode("alternateCode");
    context.cacheResource(cs);
    Parameters params = new Parameters();
    params.addParameter("includeAlternateCodes", true);
    ValueSetValidator vsv = validator(context, valueSet(LOCAL), params);

    ValidationResult res = assertDoesNotThrow(() -> vsv.validateCode(new Coding(LOCAL, "b", null)));
    assertFalse(res.isOk(), res.getMessage());
  }

  /** system-version, force-system-version and check-system-version parameters without a value. */
  @Test
  void versionParametersWithoutValue() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
    CodeSystem cs = new CodeSystem();
    cs.setUrl(LOCAL);
    cs.setVersion("1.0");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("a");
    context.cacheResource(cs);
    Parameters params = new Parameters();
    params.addParameter().setName("system-version");
    params.addParameter().setName("force-system-version");
    params.addParameter().setName("check-system-version");
    ValueSetValidator vsv = validator(context, valueSet(LOCAL), params);

    ValidationResult res = assertDoesNotThrow(() -> vsv.validateCode(new Coding(LOCAL, "a", null)));
    assertTrue(res.isOk(), res.getMessage());
  }
}
