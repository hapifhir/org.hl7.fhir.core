package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40; import org.hl7.fhir.convertors.context.ConversionContext30_40; import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Type30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Date30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Goal30_40 {

    public static org.hl7.fhir.dstu3.model.Goal convertGoal(org.hl7.fhir.r4.model.Goal src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Goal tgt = new org.hl7.fhir.dstu3.model.Goal();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasLifecycleStatus())
            tgt.setStatusElement(convertGoalStatus(src.getLifecycleStatusElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriority(CodeableConcept30_40.convertCodeableConcept(src.getPriority()));
        if (src.hasDescription())
            tgt.setDescription(CodeableConcept30_40.convertCodeableConcept(src.getDescription()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
        if (src.hasStart())
            tgt.setStart(VersionConvertorFactory_30_40.convertType(src.getStart()));
        if (src.hasTarget())
            tgt.setTarget(convertGoalTargetComponent(src.getTargetFirstRep()));
        if (src.hasStatusDate())
            tgt.setStatusDateElement(Date30_40.convertDate(src.getStatusDateElement()));
        if (src.hasStatusReason())
            tgt.setStatusReasonElement(String30_40.convertString(src.getStatusReasonElement()));
        if (src.hasExpressedBy())
            tgt.setExpressedBy(Reference30_40.convertReference(src.getExpressedBy()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAddresses()) tgt.addAddresses(Reference30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOutcomeCode()) tgt.addOutcomeCode(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getOutcomeReference()) tgt.addOutcomeReference(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Goal convertGoal(org.hl7.fhir.dstu3.model.Goal src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Goal tgt = new org.hl7.fhir.r4.model.Goal();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setLifecycleStatusElement(convertGoalStatus(src.getStatusElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriority(CodeableConcept30_40.convertCodeableConcept(src.getPriority()));
        if (src.hasDescription())
            tgt.setDescription(CodeableConcept30_40.convertCodeableConcept(src.getDescription()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
        if (src.hasStart())
            tgt.setStart(VersionConvertorFactory_30_40.convertType(src.getStart()));
        if (src.hasTarget())
            tgt.addTarget(convertGoalTargetComponent(src.getTarget()));
        if (src.hasStatusDate())
            tgt.setStatusDateElement(Date30_40.convertDate(src.getStatusDateElement()));
        if (src.hasStatusReason())
            tgt.setStatusReasonElement(String30_40.convertString(src.getStatusReasonElement()));
        if (src.hasExpressedBy())
            tgt.setExpressedBy(Reference30_40.convertReference(src.getExpressedBy()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAddresses()) tgt.addAddresses(Reference30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getOutcomeCode()) tgt.addOutcomeCode(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getOutcomeReference()) tgt.addOutcomeReference(Reference30_40.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus> convertGoalStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Goal.GoalStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Goal.GoalLifecycleStatusEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.PROPOSED);
                break;
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACCEPTED);
                break;
            case PLANNED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.PLANNED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case ONTARGET:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case AHEADOFTARGET:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case BEHINDTARGET:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case SUSTAINING:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                break;
            case ACHIEVED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.COMPLETED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ONHOLD);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ENTEREDINERROR);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.REJECTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Goal.GoalStatus> convertGoalStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Goal.GoalStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Goal.GoalStatusEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.PROPOSED);
                break;
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.ACCEPTED);
                break;
            case PLANNED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.PLANNED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.INPROGRESS);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.ACHIEVED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.ONHOLD);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.ENTEREDINERROR);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.REJECTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Goal.GoalStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.dstu3.model.Goal.GoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Goal.GoalTargetComponent tgt = new org.hl7.fhir.r4.model.Goal.GoalTargetComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(CodeableConcept30_40.convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(VersionConvertorFactory_30_40.convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(VersionConvertorFactory_30_40.convertType(src.getDue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.r4.model.Goal.GoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Goal.GoalTargetComponent tgt = new org.hl7.fhir.dstu3.model.Goal.GoalTargetComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(CodeableConcept30_40.convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(VersionConvertorFactory_30_40.convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(VersionConvertorFactory_30_40.convertType(src.getDue()));
        return tgt;
    }
}