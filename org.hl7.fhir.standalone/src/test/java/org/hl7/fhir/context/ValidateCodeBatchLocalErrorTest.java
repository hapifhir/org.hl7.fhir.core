package org.hl7.fhir.context;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.hl7.fhir.model.extensions.ExtensionDefinitions;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.CodeSystem;
import org.hl7.fhir.model.core.Coding;
import org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode;
import org.hl7.fhir.model.core.Enumerations.FilterOperator;
import org.hl7.fhir.model.core.Enumerations.PublicationStatus;
import org.hl7.fhir.model.core.Parameters;
import org.hl7.fhir.model.core.ValueSet;
import org.hl7.fhir.services.terminology.CodingValidationRequest;
import org.hl7.fhir.services.terminology.ValidationResult;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.utilities.validation.ValidationOptions;
import org.hl7.fhir.model.extensions.ExtensionUtilities;
import org.hl7.fhir.model.core.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.Test;

/**
 * validateCodeBatch has to give the same answer as validateCode when the local check fails, rather than
 * dropping the local error and asking a server (#2851)
 */
class ValidateCodeBatchLocalErrorTest {

  private static final String CS_URL = "http://example.org/fhir/CodeSystem/status";

  @Test
  void missingRequiredSupplementNoServer() throws Exception {
    checkSame(true, needsSupplement(), I18nConstants.VALUESET_SUPPLEMENT_MISSING);
  }

  @Test
  void filterWithNoValueNoServer() throws Exception {
    checkSame(true, filterWithNoValue(), I18nConstants.UNABLE_TO_HANDLE_SYSTEM_FILTER_WITH_NO_VALUE);
  }

  @Test
  void missingRequiredSupplementNoClient() throws Exception {
    checkSame(false, needsSupplement(), I18nConstants.VALUESET_SUPPLEMENT_MISSING); // no server client, but not told there is no server
  }

  @Test
  void filterWithNoValueNoClient() throws Exception {
    checkSame(false, filterWithNoValue(), I18nConstants.UNABLE_TO_HANDLE_SYSTEM_FILTER_WITH_NO_VALUE); // no server client, but not told there is no server
  }

  /**
   * each on its own context, so neither answer can come from the other's cache entry. Both have to be the local error
   * itself - fatal, with its message id - and not just the same as each other
   */
  private void checkSame(boolean noTerminologyServer, ValueSet vs, String messageId) throws Exception {
    Coding c = new Coding(CS_URL, "acc", null);
    ValidationResult single = context(noTerminologyServer).validateCode(new ValidationOptions(), c, vs);

    CodingValidationRequest req = new CodingValidationRequest(c);
    context(noTerminologyServer).validateCodeBatch(new ValidationOptions(), List.of(req), vs);
    ValidationResult batch = req.getResult();

    assertNotNull(batch);
    assertEquals(single.getSeverity(), batch.getSeverity());
    assertEquals(single.getMessage(), batch.getMessage());
    assertFalse(batch.getMessage().contains("running without terminology services"), batch.getMessage());
    for (ValidationResult res : List.of(single, batch)) {
      assertEquals(IssueSeverity.FATAL, res.getSeverity(), res.getMessage());
      assertTrue(hasMessageId(res, messageId), res.getMessage());
    }
  }

  private boolean hasMessageId(ValidationResult res, String messageId) {
    if (res.getIssues() != null) {
      for (OperationOutcomeIssueComponent iss : res.getIssues()) {
        if (messageId.equals(ExtensionUtilities.readStringExtension(iss, ExtensionDefinitions.EXT_ISSUE_MSG_ID))) {
          return true;
        }
      }
    }
    return false;
  }

  private SimpleWorkerContext context(boolean noTerminologyServer) throws Exception {
    SimpleWorkerContext ctxt = new SimpleWorkerContext.SimpleWorkerContextBuilder(ModelContext.fullCoreContext()).fromNothing();
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
