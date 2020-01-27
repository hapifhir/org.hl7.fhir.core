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
        tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        tgt.setStatus(convertCarePlanStatus(src.getStatus()));
        tgt.setEncounter(VersionConvertor_10_50.convertReference(src.getContext()));
        tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) if (!tgt.hasAuthor())
            tgt.setAuthor(VersionConvertor_10_50.convertReference(t));
        else
            tgt.addContributor(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setDescription(src.getDescription());
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
        tgt.setSubject(VersionConvertor_10_50.convertReference(src.getSubject()));
        tgt.setStatus(convertCarePlanStatus(src.getStatus()));
        tgt.setContext(VersionConvertor_10_50.convertReference(src.getEncounter()));
        tgt.setPeriod(VersionConvertor_10_50.convertPeriod(src.getPeriod()));
        if (src.hasAuthor())
            tgt.addAuthor(VersionConvertor_10_50.convertReference(src.getAuthor()));
        for (org.hl7.fhir.r5.model.Reference t : src.getContributor()) tgt.addAuthor(VersionConvertor_10_50.convertReference(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setDescription(src.getDescription());
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
        tgt.setReference(VersionConvertor_10_50.convertReference(src.getReference()));
        tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Annotation t : src.getProgress()) tgt.addProgress(VersionConvertor_10_50.convertAnnotation(t));
        tgt.setReference(VersionConvertor_10_50.convertReference(src.getReference()));
        tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_10_50.convertCodeableConceptToCodableReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodableReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getGoal()) tgt.addGoal(VersionConvertor_10_50.convertReference(t));
        tgt.setStatus(convertCarePlanActivityStatus(src.getStatus()));
        tgt.setDoNotPerform(src.getProhibited());
        tgt.setScheduled(VersionConvertor_10_50.convertType(src.getScheduled()));
        tgt.setLocation(VersionConvertor_10_50.convertReference(src.getLocation()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_50.convertReference(t));
        tgt.setProduct(VersionConvertor_10_50.convertType(src.getProduct()));
        tgt.setDailyAmount(VersionConvertor_10_50.convertSimpleQuantity(src.getDailyAmount()));
        tgt.setQuantity(VersionConvertor_10_50.convertSimpleQuantity(src.getQuantity()));
        tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(VersionConvertor_10_50.convertCodeableConcept(src.getCode()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(VersionConvertor_10_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(VersionConvertor_10_50.convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) tgt.addGoal(VersionConvertor_10_50.convertReference(t));
        tgt.setStatus(convertCarePlanActivityStatus(src.getStatus()));
        tgt.setProhibited(src.getDoNotPerform());
        tgt.setScheduled(VersionConvertor_10_50.convertType(src.getScheduled()));
        tgt.setLocation(VersionConvertor_10_50.convertReference(src.getLocation()));
        for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_50.convertReference(t));
        tgt.setProduct(VersionConvertor_10_50.convertType(src.getProduct()));
        tgt.setDailyAmount(VersionConvertor_10_50.convertSimpleQuantity(src.getDailyAmount()));
        tgt.setQuantity(VersionConvertor_10_50.convertSimpleQuantity(src.getQuantity()));
        tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus convertCarePlanActivityStatus(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTSTARTED:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NOTSTARTED;
            case SCHEDULED:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.SCHEDULED;
            case INPROGRESS:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.INPROGRESS;
            case ONHOLD:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ONHOLD;
            case COMPLETED:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.COMPLETED;
            case CANCELLED:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.CANCELLED;
            default:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus convertCarePlanActivityStatus(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTSTARTED:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.NOTSTARTED;
            case SCHEDULED:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.SCHEDULED;
            case INPROGRESS:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.INPROGRESS;
            case ONHOLD:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.ONHOLD;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.COMPLETED;
            case CANCELLED:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.CANCELLED;
            default:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus convertCarePlanStatus(org.hl7.fhir.r5.model.Enumerations.RequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.COMPLETED;
            case REVOKED:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.CANCELLED;
            default:
                return org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.RequestStatus convertCarePlanStatus(org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT;
            case DRAFT:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT;
            case ACTIVE:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED;
            case CANCELLED:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED;
            default:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL;
        }
    }

    static public CodeableReference convertReferenceToCodableReference(Reference src) {
        CodeableReference tgt = new CodeableReference();
        tgt.setReference(VersionConvertor_10_50.convertReference(src));
        return tgt;
    }
}
