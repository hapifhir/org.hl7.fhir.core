package org.hl7.fhir.r5.terminologies.expansion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.io.IOException;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.model.ValueSet.ConceptSetComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionParameterComponent;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyOperationContext;
import org.hl7.fhir.r5.terminologies.utilities.ValueSetProcessBase.TerminologyOperationDetails;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;

/**
 * Parameters, properties and extensions without a value are skipped, not dereferenced. ValueSet.expansion.parameter.value[x]
 * is 0..1, and terminology servers report such parameters (HL7/fhir-ig-publisher#1490).
 */
class ValueSetExpanderParameterWithoutValueTests {

  private static final String LOCAL = "http://example.org/fhir/CodeSystem/local";
  private static final String REMOTE = "http://example.org/fhir/CodeSystem/remote";
  private static final String DATA_ABSENT_REASON = "http://hl7.org/fhir/StructureDefinition/data-absent-reason";

  private static ValueSet valueSet(String system) {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/test");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem(system);
    return vs;
  }

  private static SimpleWorkerContext contextWithLocalCodeSystem() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    CodeSystem cs = new CodeSystem();
    cs.setUrl(LOCAL);
    cs.setVersion("1.0");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("a");
    context.cacheResource(cs);
    return context;
  }

  // a primitive with only an extension: hasValue() is true, primitiveValue() is null
  private static CodeType codeWithoutValue() {
    CodeType c = new CodeType();
    c.addExtension(DATA_ABSENT_REASON, new CodeType("unknown"));
    return c;
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

  private static void assertExpandedLocalCode(ValueSetExpansionOutcome outcome) {
    assertTrue(outcome.isOk(), outcome.getError());
    assertEquals("a", outcome.getValueset().getExpansion().getContainsFirstRep().getCode());
  }

  /** A concept of a local code system has an alternateCode property without a value. */
  @Test
  void alternateCodeWithoutValueInCodeSystem() throws IOException {
    SimpleWorkerContext context = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    CodeSystem cs = new CodeSystem();
    cs.setUrl(LOCAL);
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("a").addProperty().setCode("alternateCode");
    context.cacheResource(cs);

    assertExpandedLocalCode(expand(context, valueSet(LOCAL), includeAlternateCodes()));
  }

  /** system-version, force-system-version and check-system-version parameters without a value. */
  @Test
  void versionParametersWithoutValue() throws IOException {
    Parameters params = new Parameters();
    params.addParameter().setName("system-version");
    params.addParameter().setName("force-system-version");
    params.addParameter().setName("check-system-version");

    assertExpandedLocalCode(expand(contextWithLocalCodeSystem(), valueSet(LOCAL), params));
  }

  /** Request parameters without a value are ignored, and not echoed in the expansion. */
  @Test
  void requestParametersWithoutValue() throws IOException {
    Parameters params = new Parameters();
    for (String name : new String[] {"displayLanguage", "designation", "versionsMatch", "default-valueset-version", "useSupplement", "count", "activeOnly", "includeDesignations", "excludeNested"}) {
      params.addParameter().setName(name);
    }
    params.addParameter().setName("displayLanguage").setValue(codeWithoutValue());

    ValueSetExpansionOutcome outcome = expand(contextWithLocalCodeSystem(), valueSet(LOCAL), params);

    assertExpandedLocalCode(outcome);
    for (ValueSetExpansionParameterComponent p : outcome.getValueset().getExpansion().getParameter()) {
      assertTrue(p.hasValue() && p.getValue().primitiveValue() != null, "expansion parameter " + p.getName() + " has no value");
    }
  }

  /** Expansion parameters in compose extensions, with a value extension without a value, or without one. */
  @Test
  void composeParameterExtensionsWithoutValue() throws IOException {
    ValueSet vs = valueSet(LOCAL);
    Extension emptyValue = vs.getCompose().addExtension().setUrl(ExtensionDefinitions.EXT_VS_EXP_PARAM_NEW);
    emptyValue.addExtension("name", new CodeType("displayLanguage"));
    emptyValue.addExtension().setUrl("value");
    Extension noValue = vs.getCompose().addExtension().setUrl(ExtensionDefinitions.EXT_VS_EXP_PARAM_NEW);
    noValue.addExtension("name", new CodeType("displayLanguage"));

    assertExpandedLocalCode(expand(contextWithLocalCodeSystem(), vs, new Parameters()));
  }

  /** valueset-supplement extensions without a value. */
  @Test
  void supplementExtensionWithoutValue() throws IOException {
    ValueSet vs = valueSet(LOCAL);
    vs.addExtension().setUrl(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED);
    CanonicalType absent = new CanonicalType();
    absent.addExtension(DATA_ABSENT_REASON, new CodeType("unknown"));
    vs.addExtension(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED, absent);

    assertExpandedLocalCode(expand(contextWithLocalCodeSystem(), vs, new Parameters()));
  }

  /**
   * The server's expansion of an include has displayLanguage and used-valueset parameters without a value, and a
   * concept with an alternateCode property without a value.
   */
  @Test
  void serverExpansionWithParametersWithoutValue() throws IOException {
    SimpleWorkerContext context = spy(new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing());
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
