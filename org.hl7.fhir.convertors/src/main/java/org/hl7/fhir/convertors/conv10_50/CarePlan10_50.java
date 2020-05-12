package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class CarePlan10_50 {

    public static org.hl7.fhir.r5.model.CarePlan convertCarePlan(org.hl7.fhir.dstu2.model.CarePlan src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CarePlan tgt = new org.hl7.fhir.r5.model.CarePlan();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getContext()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) if (!tgt.hasAuthor())
            tgt.setAuthor(VersionConvertor_10_50.convertReference(t));
        else
            tgt.addContributor(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAddresses()) tgt.addAddresses(convertReferenceToCodableReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getGoal()) tgt.addGoal(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) tgt.addActivity(convertCarePlanActivityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CarePlan convertCarePlan(org.hl7.fhir.r5.model.CarePlan src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CarePlan tgt = new org.hl7.fhir.dstu2.model.CarePlan();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_10_50.convertReference(src.getEncounter()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        if (src.hasAuthor())
            tgt.addAuthor(VersionConvertor_10_50.convertReference(src.getAuthor()));
        for (org.hl7.fhir.r5.model.Reference t : src.getContributor()) tgt.addAuthor(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        for (CodeableReference t : src.getAddresses()) {
            if (t.hasReference()) {
                tgt.addAddresses(VersionConvertor_10_50.convertReference(t.getReference()));
            }
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) tgt.addGoal(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) tgt.addActivity(convertCarePlanActivityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Annotation t : src.getProgress()) tgt.addProgress(VersionConvertor_10_50.convertAnnotation(t));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_10_50.convertReference(src.getReference()));
        if (src.hasDetail())
            tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Annotation t : src.getProgress()) tgt.addProgress(VersionConvertor_10_50.convertAnnotation(t));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_10_50.convertReference(src.getReference()));
        if (src.hasDetail())
            tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_10_50.convertCodeableConceptToCodableReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodableReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getGoal()) tgt.addGoal(VersionConvertor_10_50.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
        if (src.hasProhibitedElement())
            tgt.setDoNotPerformElement(VersionConvertor_10_50.convertBoolean(src.getProhibitedElement()));
        if (src.hasScheduled())
            tgt.setScheduled(VersionConvertor_10_50.convertType(src.getScheduled()));
        if (src.hasLocation())
            tgt.getLocation().setReference(VersionConvertor_10_50.convertReference(src.getLocation()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_50.convertReference(t));
        if (src.hasProduct())
            tgt.setProduct(VersionConvertor_10_50.convertType(src.getProduct()));
        if (src.hasDailyAmount())
            tgt.setDailyAmount(VersionConvertor_10_50.convertSimpleQuantity(src.getDailyAmount()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_50.convertSimpleQuantity(src.getQuantity()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(VersionConvertor_10_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(VersionConvertor_10_50.convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) tgt.addGoal(VersionConvertor_10_50.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
        if (src.hasDoNotPerformElement())
            tgt.setProhibitedElement(VersionConvertor_10_50.convertBoolean(src.getDoNotPerformElement()));
        if (src.hasScheduled())
            tgt.setScheduled(VersionConvertor_10_50.convertType(src.getScheduled()));
        if (src.getLocation().hasReference())
            tgt.setLocation(VersionConvertor_10_50.convertReference(src.getLocation().getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_50.convertReference(t));
        if (src.hasProduct())
            tgt.setProduct(VersionConvertor_10_50.convertType(src.getProduct()));
        if (src.hasDailyAmount())
            tgt.setDailyAmount(VersionConvertor_10_50.convertSimpleQuantity(src.getDailyAmount()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_50.convertSimpleQuantity(src.getQuantity()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSTARTED:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
                break;
            case SCHEDULED:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ONHOLD);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.COMPLETED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.CANCELLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSTARTED:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
                break;
            case SCHEDULED:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.ONHOLD);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.COMPLETED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.CANCELLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus> convertCarePlanStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.COMPLETED);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.CANCELLED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertCarePlanStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public CodeableReference convertReferenceToCodableReference(Reference src) {
        CodeableReference tgt = new CodeableReference();
        tgt.setReference(VersionConvertor_10_50.convertReference(src));
        return tgt;
    }
}