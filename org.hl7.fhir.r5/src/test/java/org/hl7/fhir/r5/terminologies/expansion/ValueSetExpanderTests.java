package org.hl7.fhir.r5.terminologies.expansion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;

class ValueSetExpanderTests {

  private static final String SYSTEM = "http://acme.test/cs";

  private static CodeSystem codeSystem(String version) {
    CodeSystem cs = new CodeSystem();
    cs.setUrl(SYSTEM);
    cs.setVersion(version);
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("a");
    return cs;
  }

  private static ValueSet valueSet(String systemVersion) {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://acme.test/vs");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem(SYSTEM).setVersion(systemVersion).addConcept().setCode("a");
    return vs;
  }

  private static ValueSetExpansionOutcome expand(SimpleWorkerContext context, ValueSet vs) {
    TerminologyOperationContext opContext = new TerminologyOperationContext(context, ValidationOptions.defaults(), "test");
    ValueSetExpander expander = new ValueSetExpander(context, opContext);
    expander.setNoTerminologyServer(true);
    return expander.expand(vs, new Parameters());
  }

  @Test
  void testUnknownVersionWhenALoadedCodeSystemHasNoVersion() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext(TestingUtilities.getSharedWorkerContext());
    context.cacheResource(codeSystem(null));
    context.cacheResource(codeSystem("1"));

    ValueSetExpansionOutcome outcome = expand(context, valueSet("2"));

    assertFalse(outcome.isOk());
    assertNotNull(outcome.getError());
    assertTrue(outcome.getError().contains("version '2' could not be found"), outcome.getError());
    assertTrue(outcome.getError().contains("1"), outcome.getError());
    assertFalse(outcome.getError().contains("NullPointerException"), outcome.getError());
  }

  @Test
  void testExceptionWithoutAMessageIsNotOk() throws IOException {
    SimpleWorkerContext context = spy(new SimpleWorkerContext(TestingUtilities.getSharedWorkerContext()));
    doThrow(new NullPointerException()).when(context)
        .fetchSupplementedCodeSystem(anyString(), any(), any(), any(), any());

    ValueSetExpansionOutcome outcome = expand(context, valueSet(null));

    assertFalse(outcome.isOk());
    assertEquals(NullPointerException.class.getName(), outcome.getError());
  }
}
