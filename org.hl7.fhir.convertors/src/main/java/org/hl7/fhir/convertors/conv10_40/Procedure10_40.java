package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Procedure;

public class Procedure10_40 {

    public static org.hl7.fhir.r4.model.Procedure convertProcedure(org.hl7.fhir.dstu2.model.Procedure src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Procedure tgt = new org.hl7.fhir.r4.model.Procedure();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        if (src.hasStatus() && src.hasNotPerformed()) {
            if (src.getNotPerformed()) {
                tgt.setStatus(Procedure.ProcedureStatus.NOTDONE);
            } else {
                tgt.setStatus(convertProcedureStatus(src.getStatus()));
            }
        }
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_10_40.convertCodeableConcept(src.getCategory()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasReasonNotPerformed())
            tgt.setStatusReason(VersionConvertor_10_40.convertCodeableConcept(src.getReasonNotPerformed().get(0)));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(VersionConvertor_10_40.convertCodeableConcept(t));
        if (src.hasReasonCodeableConcept())
            tgt.addReasonCode(VersionConvertor_10_40.convertCodeableConcept(src.getReasonCodeableConcept()));
        if (src.hasReasonReference())
            tgt.addReasonReference(VersionConvertor_10_40.convertReference(src.getReasonReference()));
        if (src.hasPerformed())
            tgt.setPerformed(VersionConvertor_10_40.convertType(src.getPerformed()));
        for (org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent t : src.getPerformer()) tgt.addPerformer(convertProcedurePerformerComponent(t));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_40.convertReference(src.getLocation()));
        if (src.hasOutcome())
            tgt.setOutcome(VersionConvertor_10_40.convertCodeableConcept(src.getOutcome()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getReport()) tgt.addReport(VersionConvertor_10_40.convertReference(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getComplication()) tgt.addComplication(VersionConvertor_10_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getFollowUp()) tgt.addFollowUp(VersionConvertor_10_40.convertCodeableConcept(t));
        if (src.hasRequest())
            tgt.addBasedOn(VersionConvertor_10_40.convertReference(src.getRequest()));
        for (org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice()) tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
        for (org.hl7.fhir.dstu2.model.Annotation note : src.getNotes()) tgt.addNote(VersionConvertor_10_40.convertAnnotation(note));
        for (org.hl7.fhir.dstu2.model.Reference r : src.getUsed()) tgt.addUsedReference(VersionConvertor_10_40.convertReference(r));
        return tgt;
    }

    private static org.hl7.fhir.r4.model.Procedure.ProcedureStatus convertProcedureStatus(org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus src) {
        switch(src) {
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.ENTEREDINERROR;
            case INPROGRESS:
                return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.INPROGRESS;
            case ABORTED:
                return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.STOPPED;
            case COMPLETED:
                return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.COMPLETED;
            default:
                return org.hl7.fhir.r4.model.Procedure.ProcedureStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_10_40.convertReference(src.getActor()));
        if (src.hasRole())
            tgt.setFunction(VersionConvertor_10_40.convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasAction())
            tgt.setAction(VersionConvertor_10_40.convertCodeableConcept(src.getAction()));
        if (src.hasManipulated())
            tgt.setManipulated(VersionConvertor_10_40.convertReference(src.getManipulated()));
        return tgt;
    }
}