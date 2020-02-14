package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;
import java.util.List;

public class CarePlan30_50 {

    private static final String CarePlanActivityDetailComponentExtension = "http://hl7.org/fhir/3.0/StructureDefinition/extension-CarePlan.activity.detail.category";

    public static org.hl7.fhir.r5.model.CarePlan convertCarePlan(org.hl7.fhir.dstu3.model.CarePlan src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CarePlan tgt = new org.hl7.fhir.r5.model.CarePlan();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReplaces()) {
            tgt.addReplaces(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) {
            tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasStatus()) {
            if (src.hasStatus())
                tgt.setStatus(convertCarePlanStatus(src.getStatus()));
        }
        if (src.hasIntent()) {
            if (src.hasIntent())
                tgt.setIntent(convertCarePlanIntent(src.getIntent()));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) {
            tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasTitle()) {
            if (src.hasTitleElement())
                tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        }
        if (src.hasDescription()) {
            if (src.hasDescriptionElement())
                tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        }
        if (src.hasSubject()) {
            if (src.hasSubject())
                tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        }
        if (src.hasContext()) {
            if (src.hasContext())
                tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getContext()));
        }
        if (src.hasPeriod()) {
            if (src.hasPeriod())
                tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        }
        List<Reference> authors = src.getAuthor();
        if (authors.size() > 0) {
            tgt.setAuthor(VersionConvertor_30_50.convertReference(authors.get(0)));
            if (authors.size() > 1) {
            }
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getCareTeam()) {
            tgt.addCareTeam(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAddresses()) {
            tgt.addAddresses(VersionConvertor_30_50.convertReferenceToCodableReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInfo()) {
            tgt.addSupportingInfo(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getGoal()) {
            tgt.addGoal(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) {
            tgt.addActivity(convertCarePlanActivityComponent(t));
        }
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) {
            tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CarePlan convertCarePlan(org.hl7.fhir.r5.model.CarePlan src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CarePlan tgt = new org.hl7.fhir.dstu3.model.CarePlan();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) {
            tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) {
            tgt.addReplaces(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) {
            tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasStatus()) {
            if (src.hasStatus())
                tgt.setStatus(convertCarePlanStatus(src.getStatus()));
        }
        if (src.hasIntent()) {
            if (src.hasIntent())
                tgt.setIntent(convertCarePlanIntent(src.getIntent()));
        }
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) {
            tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasTitle()) {
            if (src.hasTitleElement())
                tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        }
        if (src.hasDescription()) {
            if (src.hasDescriptionElement())
                tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        }
        if (src.hasSubject()) {
            if (src.hasSubject())
                tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        }
        if (src.hasEncounter()) {
            if (src.hasEncounter())
                tgt.setContext(VersionConvertor_30_50.convertReference(src.getEncounter()));
        }
        if (src.hasPeriod()) {
            if (src.hasPeriod())
                tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        }
        if (src.hasAuthor()) {
            if (src.hasAuthor())
                tgt.addAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getCareTeam()) {
            tgt.addCareTeam(VersionConvertor_30_50.convertReference(t));
        }
        for (CodeableReference t : src.getAddresses()) {
            if (t.hasReference())
                tgt.addAddresses(VersionConvertor_30_50.convertReference(t.getReference()));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo()) {
            tgt.addSupportingInfo(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) {
            tgt.addGoal(VersionConvertor_30_50.convertReference(t));
        }
        for (org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) {
            tgt.addActivity(convertCarePlanActivityComponent(t));
        }
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) {
            tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (CodeableReference t : src.getOutcome()) {
            if (t.hasConcept())
                tgt.addOutcomeCodeableConcept(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
        }
        for (CodeableReference t : src.getOutcome()) {
            if (t.hasReference())
                tgt.addOutcomeReference(VersionConvertor_30_50.convertReference(t.getReference()));
        }
        for (org.hl7.fhir.r5.model.Annotation t : src.getProgress()) {
            tgt.addProgress(VersionConvertor_30_50.convertAnnotation(t));
        }
        if (src.hasReference()) {
            if (src.hasReference())
                tgt.setReference(VersionConvertor_30_50.convertReference(src.getReference()));
        }
        if (src.hasDetail()) {
            if (src.hasDetail())
                tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getOutcomeCodeableConcept()) {
            tgt.addOutcome(VersionConvertor_30_50.convertCodeableConceptToCodableReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getOutcomeReference()) {
            tgt.addOutcome(VersionConvertor_30_50.convertReferenceToCodableReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getProgress()) {
            tgt.addProgress(VersionConvertor_30_50.convertAnnotation(t));
        }
        if (src.hasReference()) {
            if (src.hasReference())
                tgt.setReference(VersionConvertor_30_50.convertReference(src.getReference()));
        }
        if (src.hasDetail()) {
            if (src.hasDetail())
                tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasExtension()) {
            org.hl7.fhir.r5.model.Extension extension = src.getExtensionByUrl(CarePlanActivityDetailComponentExtension);
            if (extension != null) {
                org.hl7.fhir.r5.model.DataType value = extension.getValue();
                if (value instanceof org.hl7.fhir.r5.model.CodeableConcept) {
                    tgt.setCategory(VersionConvertor_30_50.convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) value));
                }
            }
        }
        if (src.hasCode()) {
            if (src.hasCode())
                tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        }
        for (CodeableReference t : src.getReason()) {
            if (t.hasConcept())
                tgt.addReasonCode(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
        }
        for (CodeableReference t : src.getReason()) {
            if (t.hasReference())
                tgt.addReasonReference(VersionConvertor_30_50.convertReference(t.getReference()));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) {
            tgt.addGoal(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasStatus()) {
            if (src.hasStatus())
                tgt.setStatus(convertCarePlanActivityStatus(src.getStatus()));
        }
        if (src.hasStatusReason()) {
            List<Coding> coding = src.getStatusReason().getCoding();
            if (coding.size() > 0) {
                tgt.setStatusReason(coding.get(0).getCode());
            }
        }
        if (src.hasDoNotPerform()) {
            if (src.hasDoNotPerformElement())
                tgt.setProhibitedElement(VersionConvertor_30_50.convertBoolean(src.getDoNotPerformElement()));
        }
        if (src.hasScheduled()) {
            if (src.hasScheduled())
                tgt.setScheduled(VersionConvertor_30_50.convertType(src.getScheduled()));
        }
        if (src.hasLocation()) {
            if (src.hasLocation())
                tgt.setLocation(VersionConvertor_30_50.convertReference(src.getLocation()));
        }
        for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) {
            tgt.addPerformer(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasProduct()) {
            if (src.hasProduct())
                tgt.setProduct(VersionConvertor_30_50.convertType(src.getProduct()));
        }
        if (src.hasDailyAmount()) {
            if (src.hasDailyAmount())
                tgt.setDailyAmount(VersionConvertor_30_50.convertSimpleQuantity(src.getDailyAmount()));
        }
        if (src.hasQuantity()) {
            if (src.hasQuantity())
                tgt.setQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getQuantity()));
        }
        if (src.hasDescription()) {
            if (src.hasDescriptionElement())
                tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCategory()) {
            org.hl7.fhir.r5.model.Extension t = new org.hl7.fhir.r5.model.Extension();
            t.setUrl(CarePlanActivityDetailComponentExtension);
            t.setValue(VersionConvertor_30_50.convertType(src.getCategory()));
            tgt.addExtension(t);
        }
        if (src.hasCode()) {
            if (src.hasCode())
                tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        }
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) {
            tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) {
            tgt.addReason(VersionConvertor_30_50.convertReferenceToCodableReference(t));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getGoal()) {
            tgt.addGoal(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasStatus()) {
            if (src.hasStatus())
                tgt.setStatus(convertCarePlanActivityStatus(src.getStatus()));
        }
        if (src.hasStatusReason()) {
            org.hl7.fhir.r5.model.Coding code = new org.hl7.fhir.r5.model.Coding();
            code.setCode(src.getStatusReason());
            org.hl7.fhir.r5.model.CodeableConcept t = new org.hl7.fhir.r5.model.CodeableConcept(code);
            tgt.setStatusReason(t);
        }
        if (src.hasProhibited()) {
            if (src.hasProhibitedElement())
                tgt.setDoNotPerformElement(VersionConvertor_30_50.convertBoolean(src.getProhibitedElement()));
        }
        if (src.hasScheduled()) {
            if (src.hasScheduled())
                tgt.setScheduled(VersionConvertor_30_50.convertType(src.getScheduled()));
        }
        if (src.hasLocation()) {
            if (src.hasLocation())
                tgt.setLocation(VersionConvertor_30_50.convertReference(src.getLocation()));
        }
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPerformer()) {
            tgt.addPerformer(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasProduct()) {
            if (src.hasProduct())
                tgt.setProduct(VersionConvertor_30_50.convertType(src.getProduct()));
        }
        if (src.hasDailyAmount()) {
            if (src.hasDailyAmount())
                tgt.setDailyAmount(VersionConvertor_30_50.convertSimpleQuantity(src.getDailyAmount()));
        }
        if (src.hasQuantity()) {
            if (src.hasQuantity())
                tgt.setQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getQuantity()));
        }
        if (src.hasDescription()) {
            if (src.hasDescriptionElement())
                tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus convertCarePlanActivityStatus(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus src) {
        if (src == null)
            return null;
        switch(src) {
            case CANCELLED:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.CANCELLED;
            case COMPLETED:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.COMPLETED;
            case INPROGRESS:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.INPROGRESS;
            case NOTSTARTED:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NOTSTARTED;
            case ONHOLD:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ONHOLD;
            case SCHEDULED:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.SCHEDULED;
            case UNKNOWN:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus convertCarePlanActivityStatus(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus src) {
        if (src == null)
            return null;
        switch(src) {
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.CANCELLED;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.COMPLETED;
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.INPROGRESS;
            case NOTSTARTED:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.NOTSTARTED;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.ONHOLD;
            case SCHEDULED:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.SCHEDULED;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent convertCarePlanIntent(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPTION:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.OPTION;
            case ORDER:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.ORDER;
            case PLAN:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.PLAN;
            case PROPOSAL:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.PROPOSAL;
            default:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.CarePlan.CarePlanIntent convertCarePlanIntent(org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OPTION:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.OPTION;
            case ORDER:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.ORDER;
            case PLAN:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PLAN;
            case PROPOSAL:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PROPOSAL;
            default:
                return org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus convertCarePlanStatus(org.hl7.fhir.r5.model.Enumerations.RequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.ACTIVE;
            case REVOKED:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.CANCELLED;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.COMPLETED;
            case DRAFT:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.DRAFT;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.ENTEREDINERROR;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.SUSPENDED;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Enumerations.RequestStatus convertCarePlanStatus(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE;
            case CANCELLED:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED;
            case COMPLETED:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED;
            case DRAFT:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.ENTEREDINERROR;
            case SUSPENDED:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.ONHOLD;
            case UNKNOWN:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL;
        }
    }
}
