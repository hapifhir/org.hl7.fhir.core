package org.hl7.fhir.terminologies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.ValueSet.ConceptSetComponent;
import org.hl7.fhir.model.core.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.services.terminology.ValueSetExpansionOutcome;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.terminology.expansion.ValueSetExpander;
import org.hl7.fhir.standalone.terminology.utilities.TerminologyOperationContext;
import org.hl7.fhir.standalone.terminology.utilities.ValueSetProcessBase.TerminologyOperationDetails;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;

/**
 * Parameters and properties without a value are skipped, not dereferenced. ValueSet.expansion.parameter.value[x] is
 * 0..1, and terminology servers report such parameters (HL7/fhir-ig-publisher#1490).
 */
class ValueSetExpanderParameterWithoutValueTests {

  private static final String LOCAL = "http://example.org/fhir/CodeSystem/local";
  private static final String REMOTE = "http://example.org/fhir/CodeSystem/remote";

  private static ValueSet valueSet(String system) {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/test");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem(system);
    return vs;
  }

  private static Parameters includeAlternateCodes() {
    Parameters params = new Parameters();
    params.addParameter("includeAlternateCodes", true);
    return params;
  }

  private static ValueSetExpansionOutcome expand(SimpleWorkerContext context, ValueSet vs, Parameters params) {
    TerminologyOperationContext opContext = new TerminologyOperationContext(context, ValidationOptions.defaults(), "test");
    return new ValueSetExpander(context, opContext).expand(vs, params);
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

    ValueSetExpansionOutcome outcome = expand(context, valueSet(LOCAL), includeAlternateCodes());

    assertTrue(outcome.isOk(), outcome.getError());
    assertEquals("a", outcome.getValueset().getExpansion().getContainsFirstRep().getCode());
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

    ValueSetExpansionOutcome outcome = expand(context, valueSet(LOCAL), params);

    assertTrue(outcome.isOk(), outcome.getError());
    assertEquals("a", outcome.getValueset().getExpansion().getContainsFirstRep().getCode());
  }

  /**
   * The server's expansion of an include has displayLanguage and used-valueset parameters without a value, and a
   * concept with an alternateCode property without a value.
   */
  @Test
  void serverExpansionWithParametersWithoutValue() throws IOException {
    SimpleWorkerContext context = spy(new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing());
    ValueSet server = new ValueSet();
    server.getExpansion().addParameter().setName("displayLanguage");
    server.getExpansion().addParameter().setName("used-valueset");
    ValueSetExpansionContainsComponent x = server.getExpansion().addContains().setSystem(REMOTE).setCode("x");
    x.addProperty().setCode("alternateCode");
    doReturn(new ValueSetExpansionOutcome(server)).when(context)
        .expandVS(any(TerminologyOperationDetails.class), any(ConceptSetComponent.class), anyBoolean(), anyBoolean());

    ValueSetExpansionOutcome outcome = expand(context, valueSet(REMOTE), includeAlternateCodes());

    assertTrue(outcome.isOk(), outcome.getError());
    assertEquals("x", outcome.getValueset().getExpansion().getContainsFirstRep().getCode());
  }
}
