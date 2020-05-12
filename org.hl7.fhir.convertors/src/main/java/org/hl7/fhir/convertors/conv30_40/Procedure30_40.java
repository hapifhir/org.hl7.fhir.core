package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Procedure30_40 {

    static public org.hl7.fhir.r4.model.Procedure convertProcedure(org.hl7.fhir.dstu3.model.Procedure src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Procedure tgt = new org.hl7.fhir.r4.model.Procedure();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) {
            tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        }
        if (src.getNotDone()) {
            tgt.setStatus(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.NOTDONE);
        } else {
            if (src.hasStatus())
                tgt.setStatusElement(convertProcedureStatus(src.getStatusElement()));
        }
        if (src.hasNotDoneReason()) {
            if (src.hasNotDoneReason())
                tgt.setStatusReason(VersionConvertor_30_40.convertCodeableConcept(src.getNotDoneReason()));
        }
        if (src.hasCategory()) {
            if (src.hasCategory())
                tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasCode()) {
            if (src.hasCode())
                tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        }
        if (src.hasSubject()) {
            if (src.hasSubject())
                tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        }
        if (src.hasContext()) {
            if (src.hasContext())
                tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        }
        if (src.hasPerformed()) {
            if (src.hasPerformed())
                tgt.setPerformed(VersionConvertor_30_40.convertType(src.getPerformed()));
        }
        for (org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent t : src.getPerformer()) {
            tgt.addPerformer(convertProcedurePerformerComponent(t));
        }
        if (src.hasLocation()) {
            if (src.hasLocation())
                tgt.setLocation(VersionConvertor_30_40.convertReference(src.getLocation()));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) {
            tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) {
            tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite()) {
            tgt.addBodySite(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasOutcome()) {
            if (src.hasOutcome())
                tgt.setOutcome(VersionConvertor_30_40.convertCodeableConcept(src.getOutcome()));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReport()) {
            tgt.addReport(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getComplication()) {
            tgt.addComplication(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getComplicationDetail()) {
            tgt.addComplicationDetail(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getFollowUp()) {
            tgt.addFollowUp(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) {
            tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        for (org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice()) {
            tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getUsedReference()) {
            tgt.addUsedReference(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getUsedCode()) {
            tgt.addUsedCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Procedure convertProcedure(org.hl7.fhir.r4.model.Procedure src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Procedure tgt = new org.hl7.fhir.dstu3.model.Procedure();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) {
            tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStatus()) {
            org.hl7.fhir.r4.model.Procedure.ProcedureStatus status = src.getStatus();
            if (org.hl7.fhir.r4.model.Procedure.ProcedureStatus.NOTDONE.equals(status)) {
                tgt.setStatus(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.SUSPENDED);
                tgt.setNotDone(true);
                if (src.hasStatusReason())
                    tgt.setNotDoneReason(VersionConvertor_30_40.convertCodeableConcept(src.getStatusReason()));
            } else {
                if (src.hasStatus())
                    tgt.setStatusElement(convertProcedureStatus(src.getStatusElement()));
                tgt.setNotDone(false);
            }
        }
        if (src.hasCategory()) {
            if (src.hasCategory())
                tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        }
        if (src.hasCode()) {
            if (src.hasCode())
                tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        }
        if (src.hasSubject()) {
            if (src.hasSubject())
                tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            if (src.hasEncounter())
                tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        }
        if (src.hasPerformed()) {
            if (src.hasPerformed())
                tgt.setPerformed(VersionConvertor_30_40.convertType(src.getPerformed()));
        }
        for (org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent t : src.getPerformer()) {
            tgt.addPerformer(convertProcedurePerformerComponent(t));
        }
        if (src.hasLocation()) {
            if (src.hasLocation())
                tgt.setLocation(VersionConvertor_30_40.convertReference(src.getLocation()));
        }
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) {
            tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) {
            tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite()) {
            tgt.addBodySite(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasOutcome()) {
            if (src.hasOutcome())
                tgt.setOutcome(VersionConvertor_30_40.convertCodeableConcept(src.getOutcome()));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getReport()) {
            tgt.addReport(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getComplication()) {
            tgt.addComplication(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getComplicationDetail()) {
            tgt.addComplicationDetail(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getFollowUp()) {
            tgt.addFollowUp(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) {
            tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        for (org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice()) {
            tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
        }
        for (org.hl7.fhir.r4.model.Reference t : src.getUsedReference()) {
            tgt.addUsedReference(VersionConvertor_30_40.convertReference(t));
        }
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getUsedCode()) {
            tgt.addUsedCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            if (src.hasAction())
                tgt.setAction(VersionConvertor_30_40.convertCodeableConcept(src.getAction()));
        }
        if (src.hasManipulated()) {
            if (src.hasManipulated())
                tgt.setManipulated(VersionConvertor_30_40.convertReference(src.getManipulated()));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            if (src.hasAction())
                tgt.setAction(VersionConvertor_30_40.convertCodeableConcept(src.getAction()));
        }
        if (src.hasManipulated()) {
            if (src.hasManipulated())
                tgt.setManipulated(VersionConvertor_30_40.convertReference(src.getManipulated()));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole()) {
            if (src.hasRole())
                tgt.setFunction(VersionConvertor_30_40.convertCodeableConcept(src.getRole()));
        }
        if (src.hasActor()) {
            if (src.hasActor())
                tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        }
        if (src.hasOnBehalfOf()) {
            if (src.hasOnBehalfOf())
                tgt.setOnBehalfOf(VersionConvertor_30_40.convertReference(src.getOnBehalfOf()));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasFunction()) {
            if (src.hasFunction())
                tgt.setRole(VersionConvertor_30_40.convertCodeableConcept(src.getFunction()));
        }
        if (src.hasActor()) {
            if (src.hasActor())
                tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        }
        if (src.hasOnBehalfOf()) {
            if (src.hasOnBehalfOf())
                tgt.setOnBehalfOf(VersionConvertor_30_40.convertReference(src.getOnBehalfOf()));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Procedure.ProcedureStatus> convertProcedureStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Procedure.ProcedureStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Procedure.ProcedureStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PREPARATION:
                tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.PREPARATION);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.INPROGRESS);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.ONHOLD);
                break;
            case ABORTED:
                tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.STOPPED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus> convertProcedureStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Procedure.ProcedureStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Procedure.ProcedureStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PREPARATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.PREPARATION);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.INPROGRESS);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.SUSPENDED);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.ABORTED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.NULL);
                break;
        }
        return tgt;
    }
}