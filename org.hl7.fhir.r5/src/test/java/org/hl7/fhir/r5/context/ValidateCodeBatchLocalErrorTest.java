package org.hl7.fhir.r5.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.r5.model.Enumerations.FilterOperator;
import org.hl7.fhir.r5.model.Enumerations.PublicationStatus;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.ValueSet;
import org.hl7.fhir.r5.terminologies.utilities.CodingValidationRequest;
import org.hl7.fhir.r5.terminologies.utilities.ValidationResult;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.junit.jupiter.api.Test;

/**
 * validateCodeBatch has to give the same answer as validateCode when the local check fails, rather than
 * dropping the local error and asking a server (#2851)
 */
class ValidateCodeBatchLocalErrorTest {

  private static final String CS_URL = "http://example.org/fhir/CodeSystem/status";

  @Test
  void missingRequiredSupplementNoServer() throws Exception {
    checkSame(true, needsSupplement());
  }

  @Test
  void filterWithNoValueNoServer() throws Exception {
    checkSame(true, filterWithNoValue());
  }

  @Test
  void missingRequiredSupplementNoClient() throws Exception {
    checkSame(false, needsSupplement()); // was a NullPointerException
  }

  @Test
  void filterWithNoValueNoClient() throws Exception {
    checkSame(false, filterWithNoValue()); // was a NullPointerException
  }

  /** each on its own context, so neither answer can come from the other's cache entry */
  private void checkSame(boolean noTerminologyServer, ValueSet vs) throws Exception {
    Coding c = new Coding(CS_URL, "acc", null);
    ValidationResult single = context(noTerminologyServer).validateCode(new ValidationOptions(), c, vs);

    CodingValidationRequest req = new CodingValidationRequest(c);
    context(noTerminologyServer).validateCodeBatch(new ValidationOptions(), List.of(req), vs);
    ValidationResult batch = req.getResult();

    assertNotNull(batch);
    assertEquals(single.getSeverity(), batch.getSeverity());
    assertEquals(single.getMessage(), batch.getMessage());
    assertFalse(batch.getMessage().contains("running without terminology services"), batch.getMessage());
  }

  private SimpleWorkerContext context(boolean noTerminologyServer) throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder().fromNothing();
    ctxt.setExpansionParameters(new Parameters());
    ctxt.setNoTerminologyServer(noTerminologyServer);
    CodeSystem cs = new CodeSystem();
    cs.setUrl(CS_URL);
    cs.setVersion("1");
    cs.setStatus(PublicationStatus.ACTIVE);
    cs.setContent(CodeSystemContentMode.COMPLETE);
    cs.addConcept().setCode("acc").setDisplay("Accepted");
    ctxt.cacheResource(cs);
    return ctxt;
  }

  private ValueSet needsSupplement() {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/needs-supplement");
    vs.setVersion("1");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.addExtension(ExtensionDefinitions.EXT_VS_CS_SUPPL_NEEDED, new CanonicalType("http://example.org/fhir/CodeSystem/missing-supplement"));
    vs.getCompose().addInclude().setSystem(CS_URL);
    return vs;
  }

  private ValueSet filterWithNoValue() {
    ValueSet vs = new ValueSet();
    vs.setUrl("http://example.org/fhir/ValueSet/filter-no-value");
    vs.setVersion("1");
    vs.setStatus(PublicationStatus.ACTIVE);
    vs.getCompose().addInclude().setSystem(CS_URL).addFilter().setProperty("concept").setOp(FilterOperator.ISA);
    return vs;
  }
}
