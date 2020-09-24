package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.dstu2.model.MedicationOrder;
import org.hl7.fhir.dstu3.model.MedicationRequest;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Dosage;

public class MedicationRequest10_40 {
    public static org.hl7.fhir.r4.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.dstu2.model.MedicationOrder src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationRequest tgt = new org.hl7.fhir.r4.model.MedicationRequest();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setIntent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.ORDER);
        for (org.hl7.fhir.dstu2.model.Identifier identifier : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(identifier));
        if (src.hasDateWritten())
            tgt.setAuthoredOnElement(VersionConvertor_10_40.convertDateTime(src.getDateWrittenElement()));
        if (src.hasStatus())
            tgt.setStatus(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.fromCode(src.getStatus().toCode()));
        if (src.hasPatient())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getPatient()));
        if (src.hasPrescriber())
            tgt.setRequester(VersionConvertor_10_40.convertReference(src.getPrescriber()));
        if (src.hasReasonCodeableConcept())
            tgt.addReasonCode(VersionConvertor_10_40.convertCodeableConcept(src.getReasonCodeableConcept()));
        if (src.hasReasonReference())
            tgt.addReasonReference(VersionConvertor_10_40.convertReference((src.getReasonReference())));
        if (src.hasNote())
            tgt.addNote(new org.hl7.fhir.r4.model.Annotation(new org.hl7.fhir.r4.model.MarkdownType((src.getNote()))));
        if (src.hasMedicationCodeableConcept())
            tgt.setMedication(VersionConvertor_10_40.convertCodeableConcept(src.getMedicationCodeableConcept()));
        if (src.hasMedicationReference())
            tgt.setMedication(VersionConvertor_10_40.convertReference(src.getMedicationReference()));
        for (MedicationOrder.MedicationOrderDosageInstructionComponent dosage : src.getDosageInstruction())
            tgt.addDosageInstruction(medDosageInstruction(dosage));
        if (src.hasDispenseRequest())
            tgt.setDispenseRequest(medDispenseRequest(src.getDispenseRequest()));
        if (src.hasSubstitution())
            tgt.setSubstitution(medSubstitution(src.getSubstitution()));
        if (src.hasPriorPrescription())
            tgt.setPriorPrescription(VersionConvertor_10_40.convertReference(src.getPriorPrescription()));
        return tgt;
    }

    private static org.hl7.fhir.r4.model.Dosage medDosageInstruction(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent src) {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_10_40.convertString(src.getTextElement()));
        if (src.hasAdditionalInstructions())
            tgt.addAdditionalInstruction(VersionConvertor_10_40.convertCodeableConcept(src.getAdditionalInstructions()));
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_10_40.convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(VersionConvertor_10_40.convertType(src.getAsNeeded()));
        if (src.hasSiteCodeableConcept())
            tgt.setSite(VersionConvertor_10_40.convertCodeableConcept(src.getSiteCodeableConcept()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_10_40.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_40.convertCodeableConcept(src.getMethod()));
        Dosage.DosageDoseAndRateComponent dose_and_rate = new Dosage.DosageDoseAndRateComponent();
        if (src.hasDose())
            dose_and_rate.setDose(VersionConvertor_10_40.convertType(src.getDose()));
        if (src.hasRate())
            dose_and_rate.setDose(VersionConvertor_10_40.convertType(src.getRate()));
        tgt.addDoseAndRate(dose_and_rate);
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(VersionConvertor_10_40.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    private static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent medDispenseRequest(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDispenseRequestComponent src) {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
        if (src.hasValidityPeriod())
            tgt.setValidityPeriod(VersionConvertor_10_40.convertPeriod(src.getValidityPeriod()));
        if (src.hasNumberOfRepeatsAllowed())
            tgt.setNumberOfRepeatsAllowedElement(VersionConvertor_10_40.convertUnsignedIntToPositive(src.getNumberOfRepeatsAllowedElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasExpectedSupplyDuration())
            tgt.setExpectedSupplyDuration(VersionConvertor_10_40.convertDuration(src.getExpectedSupplyDuration()));
        return tgt;
    }

    private static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent medSubstitution(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderSubstitutionComponent src) {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent();
        if (src.hasReason())
            tgt.setReason(VersionConvertor_10_40.convertCodeableConcept(src.getReason()));
        return tgt;
    }
}
