package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Reference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Where an R6 CodeableReference goes into an R4 choice element (CodeableConcept|Reference), and it has both,
 * the concept wins, and the reference rides along on the concept in the CodeableReference.reference
 * cross-version extension. And R6 Procedure.outcome (0..*) goes to R4 outcome (0..1) + cross-version extensions
 */
class CodeableReference40_NTest {

  private static CodeableConcept concept(String code) {
    CodeableConcept cc = new CodeableConcept();
    cc.addCoding().setSystem("http://example.org/cs").setCode(code);
    return cc;
  }

  private static CodeableReference both(String code, String ref) {
    return new CodeableReference()
      .setConcept(concept(code))
      .setReference(new Reference().setReference(ref));
  }

  private static org.hl7.fhir.model.core.Resource roundTrip(org.hl7.fhir.model.core.Resource src) {
    return VersionConvertorFactory_40_N.convertResource(VersionConvertorFactory_40_N.convertResource(src));
  }

  @Test
  @DisplayName("Claim.diagnosis with both a concept and a reference: concept wins in R4, and both come back")
  void testClaimDiagnosisBoth() {
    org.hl7.fhir.model.core.Claim src = new org.hl7.fhir.model.core.Claim();
    src.addDiagnosis().setSequence(1).setDiagnosis(both("d1", "Condition/c1"));

    org.hl7.fhir.r4.model.Claim r4 = (org.hl7.fhir.r4.model.Claim) VersionConvertorFactory_40_N.convertResource(src);
    org.hl7.fhir.r4.model.Type d = r4.getDiagnosisFirstRep().getDiagnosis();
    assertTrue(d instanceof org.hl7.fhir.r4.model.CodeableConcept, "expected the concept, not a " + d.fhirType());
    assertEquals("d1", ((org.hl7.fhir.r4.model.CodeableConcept) d).getCodingFirstRep().getCode());
    assertEquals("Condition/c1", ((org.hl7.fhir.r4.model.Reference) d.getExtensionByUrl(VersionConvertorConstants.EXT_CODEABLE_REFERENCE_REFERENCE).getValue()).getReference());

    CodeableReference back = ((org.hl7.fhir.model.core.Claim) VersionConvertorFactory_40_N.convertResource(r4)).getDiagnosisFirstRep().getDiagnosis();
    assertEquals("d1", back.getConcept().getCodingFirstRep().getCode());
    assertEquals("Condition/c1", back.getReference().getReference());
    assertFalse(back.getConcept().hasExtension(), "the cross-version extension should not be left on the concept");
  }

  @Test
  @DisplayName("MedicationRequest.medication with both round trips")
  void testMedicationBoth() {
    org.hl7.fhir.model.core.MedicationRequest src = new org.hl7.fhir.model.core.MedicationRequest();
    src.setMedication(both("m1", "Medication/m1"));
    org.hl7.fhir.model.core.MedicationRequest back = (org.hl7.fhir.model.core.MedicationRequest) roundTrip(src);
    assertEquals("m1", back.getMedication().getConcept().getCodingFirstRep().getCode());
    assertEquals("Medication/m1", back.getMedication().getReference().getReference());
  }

  @Test
  @DisplayName("A reference-only choice is still a Reference in R4")
  void testReferenceOnly() {
    org.hl7.fhir.model.core.MedicationRequest src = new org.hl7.fhir.model.core.MedicationRequest();
    src.setMedication(new CodeableReference().setReference(new Reference().setReference("Medication/m1")));
    org.hl7.fhir.r4.model.MedicationRequest r4 = (org.hl7.fhir.r4.model.MedicationRequest) VersionConvertorFactory_40_N.convertResource(src);
    assertTrue(r4.hasMedicationReference());
    org.hl7.fhir.model.core.MedicationRequest back = (org.hl7.fhir.model.core.MedicationRequest) VersionConvertorFactory_40_N.convertResource(r4);
    assertFalse(back.getMedication().hasConcept());
    assertEquals("Medication/m1", back.getMedication().getReference().getReference());
  }

  @Test
  @DisplayName("Procedure.outcome: first in outcome, the rest in cross-version extensions, in order")
  void testProcedureOutcomes() {
    org.hl7.fhir.model.core.Procedure src = new org.hl7.fhir.model.core.Procedure();
    src.setStatus(org.hl7.fhir.model.core.Enumerations.EventStatus.COMPLETED);
    src.addOutcome(new CodeableReference().setConcept(concept("o1")));
    src.addOutcome(both("o2", "Observation/o2"));
    src.addOutcome(new CodeableReference().setReference(new Reference().setReference("Observation/o3")));

    org.hl7.fhir.r4.model.Procedure r4 = (org.hl7.fhir.r4.model.Procedure) VersionConvertorFactory_40_N.convertResource(src);
    assertEquals("o1", r4.getOutcome().getCodingFirstRep().getCode());
    assertEquals(2, r4.getExtensionsByUrl(VersionConvertorConstants.EXT_PROCEDURE_OUTCOME).size());

    org.hl7.fhir.model.core.Procedure back = (org.hl7.fhir.model.core.Procedure) VersionConvertorFactory_40_N.convertResource(r4);
    assertEquals(3, back.getOutcomeList().size());
    assertEquals("o1", back.getOutcomeList().get(0).getConcept().getCodingFirstRep().getCode());
    assertEquals("o2", back.getOutcomeList().get(1).getConcept().getCodingFirstRep().getCode());
    assertEquals("Observation/o2", back.getOutcomeList().get(1).getReference().getReference());
    assertEquals("Observation/o3", back.getOutcomeList().get(2).getReference().getReference());
    assertFalse(back.getOutcomeList().get(2).hasConcept());
    assertFalse(back.hasExtension(VersionConvertorConstants.EXT_PROCEDURE_OUTCOME), "the cross-version extensions should not be carried into R6");
  }

  @Test
  @DisplayName("Procedure.outcome: a reference-only first outcome goes in the extension, and order is kept")
  void testProcedureReferenceFirst() {
    org.hl7.fhir.model.core.Procedure src = new org.hl7.fhir.model.core.Procedure();
    src.setStatus(org.hl7.fhir.model.core.Enumerations.EventStatus.COMPLETED);
    src.addOutcome(new CodeableReference().setReference(new Reference().setReference("Observation/o1")));
    src.addOutcome(new CodeableReference().setConcept(concept("o2")));

    org.hl7.fhir.r4.model.Procedure r4 = (org.hl7.fhir.r4.model.Procedure) VersionConvertorFactory_40_N.convertResource(src);
    assertFalse(r4.hasOutcome());
    assertEquals(2, r4.getExtensionsByUrl(VersionConvertorConstants.EXT_PROCEDURE_OUTCOME).size());

    org.hl7.fhir.model.core.Procedure back = (org.hl7.fhir.model.core.Procedure) VersionConvertorFactory_40_N.convertResource(r4);
    assertEquals("Observation/o1", back.getOutcomeList().get(0).getReference().getReference());
    assertEquals("o2", back.getOutcomeList().get(1).getConcept().getCodingFirstRep().getCode());
  }
}
