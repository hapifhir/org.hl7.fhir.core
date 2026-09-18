package org.hl7.fhir.r5.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.stream.Collectors;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CanonicalResource;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.client.TerminologyClientContext;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;

/**
 * A value set's required supplements have to reach the server with it. Looking them up through its
 * code systems only finds a supplement to a particular version when the copy of the code system we
 * resolve is that version - and here we don't have one at all.
 */
class RequiredSupplementUploadTest {

  private static final String BASE_URL = "http://example.org/fhir/CodeSystem/base";
  private static final String SUPPLEMENT_URL = "http://example.org/fhir/CodeSystem/supplement";
  private static final String VS_URL = "http://example.org/fhir/ValueSet/test";
  private static final String IMPORTED_VS_URL = "http://example.org/fhir/ValueSet/imported";

  @Test
  void versionedSupplementIsSent() throws Exception {
    SimpleWorkerContext ctxt = contextWithSupplement(BASE_URL + "|1.0");
    ValueSet vs = valueSet(VS_URL, true);
    vs.getCompose().addInclude().setSystem(BASE_URL);
    assertEquals(List.of(SUPPLEMENT_URL + "|0.1"), txResources(ctxt, vs));
  }

  @Test
  void unversionedSupplementIsSentOnce() throws Exception {
    SimpleWorkerContext ctxt = contextWithSupplement(BASE_URL);
    ValueSet vs = valueSet(VS_URL, true);
    vs.getCompose().addInclude().setSystem(BASE_URL);
    assertEquals(List.of(SUPPLEMENT_URL + "|0.1"), txResources(ctxt, vs));
  }

  @Test
  void supplementOfImportedValueSetIsSent() throws Exception {
    SimpleWorkerContext ctxt = contextWithImportedValueSet();
    ValueSet vs = valueSet(VS_URL, false);
    vs.getCompose().addInclude().addValueSet(IMPORTED_VS_URL);
    assertEquals(List.of(IMPORTED_VS_URL, SUPPLEMENT_URL + "|0.1"), txResources(ctxt, vs));
  }

  @Test
  void supplementRequiredByBothValueSetsIsSentOnce() throws Exception {
    SimpleWorkerContext ctxt = contextWithImportedValueSet();
    ValueSet vs = valueSet(VS_URL, true);
    vs.getCompose().addInclude().addValueSet(IMPORTED_VS_URL);
    assertEquals(List.of(SUPPLEMENT_URL + "|0.1", IMPORTED_VS_URL), txResources(ctxt, vs));
  }

  private SimpleWorkerContext contextWithImportedValueSet() throws Exception {
    SimpleWorkerContext ctxt = contextWithSupplement(BASE_URL + "|1.0");
    ValueSet imported = valueSet(IMPORTED_VS_URL, true);
    imported.getCompose().addInclude().setSystem(BASE_URL);
    ctxt.cacheResource(imported);
    return ctxt;
  }

  private SimpleWorkerContext contextWithSupplement(String supplementTarget) throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    ctxt.setExpansionParameters(new Parameters());
    CodeSystem supplement = new CodeSystem();
    supplement.setUrl(SUPPLEMENT_URL);
    supplement.setVersion("0.1");
    supplement.setStatus(PublicationStatus.ACTIVE);
    supplement.setContent(CodeSystemContentMode.SUPPLEMENT);
    supplement.setSupplements(supplementTarget);
    ctxt.cacheResource(supplement);
    return ctxt;
  }

  private ValueSet valueSet(String url, boolean requiresSupplement) {
    ValueSet vs = new ValueSet();
    vs.setUrl(url);
    vs.setStatus(PublicationStatus.ACTIVE);
    if (requiresSupplement) {
      vs.addExtension(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED, new CanonicalType(SUPPLEMENT_URL));
    }
    return vs;
  }

  private List<String> txResources(SimpleWorkerContext ctxt, ValueSet vs) throws Exception {
    TerminologyClientContext tc = mock(TerminologyClientContext.class);
    doReturn(false).when(tc).usingCache();
    Parameters pin = new Parameters();
    ctxt.addServerValidationParameters(null, tc, vs, pin, new ValidationOptions());
    return pin.getParameters("tx-resource").stream()
        .map(p -> ((CanonicalResource) p.getResource()).getVUrl()).collect(Collectors.toList());
  }
}
