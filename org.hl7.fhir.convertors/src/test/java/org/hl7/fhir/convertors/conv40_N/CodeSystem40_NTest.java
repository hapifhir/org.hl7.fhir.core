package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.model.core.CodeSystem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The R5 metadata elements on CodeSystem (R4 doesn't have them) go in extensions: the R4 core extensions for
 * approvalDate, lastReviewDate and effectivePeriod, and cross-version extensions for the rest
 */
class CodeSystem40_NTest {

  @Test
  @DisplayName("copyrightLabel round trips through R4")
  void testCopyrightLabel() {
    CodeSystem src = new CodeSystem();
    src.setUrl("http://example.org/cs");
    src.setStatus(org.hl7.fhir.model.core.Enumerations.PublicationStatus.DRAFT);
    src.setContent(org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode.COMPLETE);
    src.setCopyrightLabel("(c) Example");

    org.hl7.fhir.r4.model.CodeSystem r4 = (org.hl7.fhir.r4.model.CodeSystem) VersionConvertorFactory_40_N.convertResource(src);
    assertEquals("(c) Example", r4.getExtensionString("http://hl7.org/fhir/5.0/StructureDefinition/extension-CodeSystem.copyrightLabel"));

    CodeSystem back = (CodeSystem) VersionConvertorFactory_40_N.convertResource(r4);
    assertTrue(src.equalsDeep(back));
  }

  @Test
  @DisplayName("R4 content using the core resource-approvalDate extension gets the R6 element, and comes back the same")
  void testR4CoreExtension() {
    org.hl7.fhir.r4.model.CodeSystem src = new org.hl7.fhir.r4.model.CodeSystem();
    src.setUrl("http://example.org/cs");
    src.setStatus(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT);
    src.setContent(org.hl7.fhir.r4.model.CodeSystem.CodeSystemContentMode.COMPLETE);
    src.addExtension("http://hl7.org/fhir/StructureDefinition/resource-approvalDate", new org.hl7.fhir.r4.model.DateType("2021-07-21"));

    CodeSystem r6 = (CodeSystem) VersionConvertorFactory_40_N.convertResource(src);
    assertEquals("2021-07-21", r6.getApprovalDateElement().asStringValue());
    assertFalse(r6.hasExtension(), "the extension should have become the element");

    org.hl7.fhir.r4.model.CodeSystem back = (org.hl7.fhir.r4.model.CodeSystem) VersionConvertorFactory_40_N.convertResource(r6);
    assertTrue(src.equalsDeep(back));
  }
}
