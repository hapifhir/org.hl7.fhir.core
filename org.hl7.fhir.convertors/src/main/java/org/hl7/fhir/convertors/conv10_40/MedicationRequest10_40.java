package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationRequest10_40 {
    public static org.hl7.fhir.r4.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.dstu2.model.MedicationOrder src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationRequest tgt = new org.hl7.fhir.r4.model.MedicationRequest();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setIntent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.ORDER);
        for (org.hl7.fhir.dstu2.model.Identifier identifier : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(identifier));
        if (src.hasDateWritten())
            tgt.setAuthoredOn(src.getDateWritten());
        if (src.hasStatus())
            tgt.setStatus(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.fromCode(src.getStatus().toCode()));
        if (src.hasPatient())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getPatient()));
        if (src.hasPrescriber())
            tgt.setRequester(VersionConvertor_10_40.convertReference(src.getPrescriber());
        if (src.hasReasonCodeableConcept())
            tgt.addReasonCode(VersionConvertor_10_40.convertCodeableConcept(src.getReasonCodeableConcept()));
        if (src.hasReasonReference())
            tgt.addReasonReference(VersionConvertor_10_40.convertReference((src.getReasonReference()));
        if (src.hasNote())
            tgt.addNote(new org.hl7.fhir.r4.model.Annotation(new org.hl7.fhir.r4.model.MarkdownType((src.getNote())));
        if (src.hasMedicationCodeableConcept())
            tgt.setMedication(VersionConvertor_10_40.convertCodeableConcept(src.getMedicationCodeableConcept()));
        if (src.hasMedicationReference())
            tgt.setMedication(VersionConvertor_10_40.convertReference(src.getMedicationReference()));
        // TODO dosage instruction
        // TODO dispense request
        // TODO substitution
        if (src.hasPriorPrescription())
            tgt.setPriorPrescription(VersionConvertor_10_40.convertReference(src.getPriorPrescription()));
        return tgt;
    }
}
