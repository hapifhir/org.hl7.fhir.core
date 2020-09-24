package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.MedicationOrder;
import org.hl7.fhir.dstu3.model.Dosage;
import org.hl7.fhir.dstu3.model.MedicationRequest;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.List;

public class MedicationRequest10_30 {
  public static org.hl7.fhir.dstu3.model.MedicationRequest convertMedicationOrder(org.hl7.fhir.dstu2.model.MedicationOrder src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.MedicationRequest tgt = new org.hl7.fhir.dstu3.model.MedicationRequest();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    tgt.setIntent(MedicationRequest.MedicationRequestIntent.ORDER);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
    if (src.hasDateWritten())
      tgt.setAuthoredOn(src.getDateWritten());
    if (src.hasStatus())
      tgt.setStatus(MedicationRequest.MedicationRequestStatus.fromCode(src.getStatus().toCode()));
    if (src.hasPatient())
      tgt.setSubject(VersionConvertor_10_30.convertReference(src.getPatient()));
    if (src.hasPrescriber())
      tgt.setRequester(medRequestor(src));
    if (src.hasEncounter())
      tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
    if (src.hasReasonCodeableConcept())
      tgt.addReasonCode(VersionConvertor_10_30.convertCodeableConcept(src.getReasonCodeableConcept()));
    if (src.hasReasonReference())
      tgt.addReasonReference(VersionConvertor_10_30.convertReference(src.getReasonReference()));
    if (src.hasNote())
      tgt.addNote(new org.hl7.fhir.dstu3.model.Annotation(new StringType(src.getNote())));
    if (src.hasMedication())
      tgt.setMedication(VersionConvertor_10_30.convertType(src.getMedication()));
    for (MedicationOrder.MedicationOrderDosageInstructionComponent dosage : src.getDosageInstruction())
      tgt.addDosageInstruction(medDosageInstruction(dosage));
    if (src.hasDispenseRequest())
      tgt.setDispenseRequest(medDispenseRequest(src.getDispenseRequest()));
    if (src.hasSubstitution())
      tgt.setSubstitution(medSubstitution(src.getSubstitution()));
    if (src.hasPriorPrescription())
      tgt.setPriorPrescription(VersionConvertor_10_30.convertReference(src.getPriorPrescription()));
    return tgt;
  }

  private static org.hl7.fhir.dstu3.model.Dosage medDosageInstruction(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent src) {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
    if (src.hasText())
      tgt.setText(src.getText());
    if (src.hasAdditionalInstructions())
      tgt.addAdditionalInstruction(VersionConvertor_10_30.convertCodeableConcept(src.getAdditionalInstructions()));
    if (src.hasTiming())
      tgt.setTiming(VersionConvertor_10_30.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(VersionConvertor_10_30.convertType(src.getAsNeeded()));
    if (src.hasSiteCodeableConcept())
      tgt.setSite(VersionConvertor_10_30.convertCodeableConcept(src.getSiteCodeableConcept()));
    if (src.hasRoute())
      tgt.setRoute(VersionConvertor_10_30.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod())
      tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
    if (src.hasDose())
      tgt.setDose(VersionConvertor_10_30.convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(VersionConvertor_10_30.convertType(src.getRate()));
    if (src.hasMaxDosePerPeriod())
      tgt.setMaxDosePerPeriod(VersionConvertor_10_30.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  private static org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent medDispenseRequest(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDispenseRequestComponent src) {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
    if (src.hasValidityPeriod())
      tgt.setValidityPeriod(VersionConvertor_10_30.convertPeriod(src.getValidityPeriod()));
    if (src.hasNumberOfRepeatsAllowed())
      tgt.setNumberOfRepeatsAllowed(src.getNumberOfRepeatsAllowed());
    if (src.hasQuantity())
      tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
    if (src.hasExpectedSupplyDuration())
      tgt.setExpectedSupplyDuration(VersionConvertor_10_30.convertDuration(src.getExpectedSupplyDuration()));
    return tgt;
  }

  private static org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent medSubstitution(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderSubstitutionComponent src) {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new MedicationRequest.MedicationRequestSubstitutionComponent();
    if (src.hasReason())
      tgt.setReason(VersionConvertor_10_30.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestRequesterComponent
  medRequestor(org.hl7.fhir.dstu2.model.MedicationOrder src) {
    org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestRequesterComponent tgt = new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestRequesterComponent();
    tgt.setAgent(VersionConvertor_10_30.convertReference(src.getPrescriber()));
    return tgt;
  }
}
