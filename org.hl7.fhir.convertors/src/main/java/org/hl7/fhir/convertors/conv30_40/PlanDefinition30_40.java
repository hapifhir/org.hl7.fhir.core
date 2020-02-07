package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.dstu3.model.ContactDetail;
import org.hl7.fhir.dstu3.model.Contributor.ContributorType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.StringType;

import java.util.Collections;

public class PlanDefinition30_40 {

    static public org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior convertActionCardinalityBehavior(org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SINGLE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.SINGLE;
            case MULTIPLE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.MULTIPLE;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior convertActionCardinalityBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SINGLE:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior.SINGLE;
            case MULTIPLE:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior.MULTIPLE;
            default:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind convertActionConditionKind(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case APPLICABILITY:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind.APPLICABILITY;
            case START:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind.START;
            case STOP:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind.STOP;
            default:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind convertActionConditionKind(org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case APPLICABILITY:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.APPLICABILITY;
            case START:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.START;
            case STOP:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.STOP;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior convertActionGroupingBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case VISUALGROUP:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior.VISUALGROUP;
            case LOGICALGROUP:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior.LOGICALGROUP;
            case SENTENCEGROUP:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior.SENTENCEGROUP;
            default:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior convertActionGroupingBehavior(org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case VISUALGROUP:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.VISUALGROUP;
            case LOGICALGROUP:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.LOGICALGROUP;
            case SENTENCEGROUP:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.SENTENCEGROUP;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType convertActionParticipantType(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PATIENT:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType.PATIENT;
            case PRACTITIONER:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType.PRACTITIONER;
            case RELATEDPERSON:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType.RELATEDPERSON;
            default:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType convertActionParticipantType(org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PATIENT:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.PATIENT;
            case PRACTITIONER:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.PRACTITIONER;
            case RELATEDPERSON:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.RELATEDPERSON;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior convertActionPrecheckBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case YES:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior.YES;
            case NO:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior.NO;
            default:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior convertActionPrecheckBehavior(org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case YES:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.YES;
            case NO:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.NO;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType convertActionRelationshipType(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BEFORESTART:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFORESTART;
            case BEFORE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFORE;
            case BEFOREEND:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFOREEND;
            case CONCURRENTWITHSTART:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHSTART;
            case CONCURRENT:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENT;
            case CONCURRENTWITHEND:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHEND;
            case AFTERSTART:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTERSTART;
            case AFTER:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTER;
            case AFTEREND:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTEREND;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType convertActionRelationshipType(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BEFORESTART:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.BEFORESTART;
            case BEFORE:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.BEFORE;
            case BEFOREEND:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.BEFOREEND;
            case CONCURRENTWITHSTART:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHSTART;
            case CONCURRENT:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.CONCURRENT;
            case CONCURRENTWITHEND:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHEND;
            case AFTERSTART:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.AFTERSTART;
            case AFTER:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.AFTER;
            case AFTEREND:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.AFTEREND;
            default:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior convertActionRequiredBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MUST:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior.MUST;
            case COULD:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior.COULD;
            case MUSTUNLESSDOCUMENTED:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED;
            default:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior convertActionRequiredBehavior(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MUST:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.MUST;
            case COULD:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.COULD;
            case MUSTUNLESSDOCUMENTED:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior convertActionSelectionBehavior(org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ANY:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ANY;
            case ALL:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ALL;
            case ALLORNONE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ALLORNONE;
            case EXACTLYONE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.EXACTLYONE;
            case ATMOSTONE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ATMOSTONE;
            case ONEORMORE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ONEORMORE;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior convertActionSelectionBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ANY:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ANY;
            case ALL:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ALL;
            case ALLORNONE:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ALLORNONE;
            case EXACTLYONE:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.EXACTLYONE;
            case ATMOSTONE:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ATMOSTONE;
            case ONEORMORE:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ONEORMORE;
            default:
                return org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.dstu3.model.PlanDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition tgt = new org.hl7.fhir.r4.model.PlanDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasUsageElement())
            tgt.setUsageElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getUsageElement()));
        if (src.hasApprovalDate())
          tgt.setApprovalDateElement(VersionConvertor_30_40.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
          tgt.setLastReviewDateElement(VersionConvertor_30_40.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_40.convertPeriod(src.getEffectivePeriod()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasTopic()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getTopic()) tgt.addTopic(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.dstu3.model.Contributor t : src.getContributor()) {
            if (t.getType() == ContributorType.AUTHOR)
                for (ContactDetail c : t.getContact()) tgt.addAuthor(VersionConvertor_30_40.convertContactDetail(c));
            if (t.getType() == ContributorType.EDITOR)
                for (ContactDetail c : t.getContact()) tgt.addEditor(VersionConvertor_30_40.convertContactDetail(c));
            if (t.getType() == ContributorType.REVIEWER)
                for (ContactDetail c : t.getContact()) tgt.addReviewer(VersionConvertor_30_40.convertContactDetail(c));
            if (t.getType() == ContributorType.ENDORSER)
                for (ContactDetail c : t.getContact()) tgt.addEndorser(VersionConvertor_30_40.convertContactDetail(c));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getCopyrightElement()));
        if (src.hasRelatedArtifact()) {
            for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_40.convertRelatedArtifact(t));
        }
        if (src.hasLibrary()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getLibrary()) tgt.getLibrary().add(VersionConvertor_30_40.convertReferenceToCanonical(t));
        }
        if (src.hasGoal()) {
            for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal()) tgt.addGoal(convertPlanDefinitionGoalComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.r4.model.PlanDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition tgt = new org.hl7.fhir.dstu3.model.PlanDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasUsageElement())
            tgt.setUsageElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getUsageElement()));
        if (src.hasApprovalDate())
          tgt.setApprovalDateElement(VersionConvertor_30_40.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
          tgt.setLastReviewDateElement(VersionConvertor_30_40.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_40.convertPeriod(src.getEffectivePeriod()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasTopic()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic()) tgt.addTopic(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.AUTHOR);
            c.addContact(VersionConvertor_30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.EDITOR);
            c.addContact(VersionConvertor_30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.REVIEWER);
            c.addContact(VersionConvertor_30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.ENDORSER);
            c.addContact(VersionConvertor_30_40.convertContactDetail(t));
            tgt.addContributor(c);
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getCopyrightElement()));
        if (src.hasRelatedArtifact()) {
            for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_40.convertRelatedArtifact(t));
        }
        if (src.hasLibrary()) {
            for (org.hl7.fhir.r4.model.CanonicalType t : src.getLibrary()) tgt.addLibrary(VersionConvertor_30_40.convertCanonicalToReference(t));
        }
        if (src.hasGoal()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal()) tgt.addGoal(convertPlanDefinitionGoalComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLabel())
            tgt.setPrefix(src.getLabel());
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasTextEquivalentElement())
            tgt.setTextEquivalentElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getTextEquivalentElement()));
        if (src.hasCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasDocumentation()) {
            for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(VersionConvertor_30_40.convertRelatedArtifact(t));
        }
        if (src.hasGoalId()) {
            for (org.hl7.fhir.dstu3.model.IdType t : src.getGoalId()) tgt.addGoalId(t.getValue());
        }
        if (src.hasTriggerDefinition()) {
            for (org.hl7.fhir.dstu3.model.TriggerDefinition t : src.getTriggerDefinition()) tgt.addTrigger(VersionConvertor_30_40.convertTriggerDefinition(t));
        }
        if (src.hasCondition()) {
            for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition()) tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
        }
        if (src.hasInput()) {
            for (org.hl7.fhir.dstu3.model.DataRequirement t : src.getInput()) tgt.addInput(VersionConvertor_30_40.convertDataRequirement(t));
        }
        if (src.hasOutput()) {
            for (org.hl7.fhir.dstu3.model.DataRequirement t : src.getOutput()) tgt.addOutput(VersionConvertor_30_40.convertDataRequirement(t));
        }
        if (src.hasRelatedAction()) {
            for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction()) tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
        }
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_30_40.convertType(src.getTiming()));
        if (src.hasParticipant()) {
            for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
        }
        if (src.hasType())
            tgt.getType().addCoding(VersionConvertor_30_40.convertCoding(src.getType()));
        if (src.hasGroupingBehavior())
            tgt.setGroupingBehavior(convertActionGroupingBehavior(src.getGroupingBehavior()));
        if (src.hasSelectionBehavior())
            tgt.setSelectionBehavior(convertActionSelectionBehavior(src.getSelectionBehavior()));
        if (src.hasRequiredBehavior())
            tgt.setRequiredBehavior(convertActionRequiredBehavior(src.getRequiredBehavior()));
        if (src.hasPrecheckBehavior())
            tgt.setPrecheckBehavior(convertActionPrecheckBehavior(src.getPrecheckBehavior()));
        if (src.hasCardinalityBehavior())
            tgt.setCardinalityBehavior(convertActionCardinalityBehavior(src.getCardinalityBehavior()));
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_30_40.convertReferenceToCanonical(src.getDefinition()));
        if (src.hasTransform())
            tgt.setTransformElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getTransform()));
        if (src.hasDynamicValue()) {
            for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue()) tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasPrefix())
            tgt.setLabel(src.getPrefix());
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasTextEquivalentElement())
            tgt.setTextEquivalentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getTextEquivalentElement()));
        if (src.hasCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasDocumentation()) {
            for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(VersionConvertor_30_40.convertRelatedArtifact(t));
        }
        if (src.hasGoalId()) {
            for (org.hl7.fhir.r4.model.IdType t : src.getGoalId()) tgt.addGoalId(t.getValue());
        }
        if (src.hasTrigger()) {
            for (org.hl7.fhir.r4.model.TriggerDefinition t : src.getTrigger()) tgt.addTriggerDefinition(VersionConvertor_30_40.convertTriggerDefinition(t));
        }
        if (src.hasCondition()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition()) tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
        }
        if (src.hasInput()) {
            for (org.hl7.fhir.r4.model.DataRequirement t : src.getInput()) tgt.addInput(VersionConvertor_30_40.convertDataRequirement(t));
        }
        if (src.hasOutput()) {
            for (org.hl7.fhir.r4.model.DataRequirement t : src.getOutput()) tgt.addOutput(VersionConvertor_30_40.convertDataRequirement(t));
        }
        if (src.hasRelatedAction()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction()) tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
        }
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_30_40.convertType(src.getTiming()));
        if (src.hasParticipant()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
        }
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCoding(src.getType().getCodingFirstRep()));
        if (src.hasGroupingBehavior())
            tgt.setGroupingBehavior(convertActionGroupingBehavior(src.getGroupingBehavior()));
        if (src.hasSelectionBehavior())
            tgt.setSelectionBehavior(convertActionSelectionBehavior(src.getSelectionBehavior()));
        if (src.hasRequiredBehavior())
            tgt.setRequiredBehavior(convertActionRequiredBehavior(src.getRequiredBehavior()));
        if (src.hasPrecheckBehavior())
            tgt.setPrecheckBehavior(convertActionPrecheckBehavior(src.getPrecheckBehavior()));
        if (src.hasCardinalityBehavior())
            tgt.setCardinalityBehavior(convertActionCardinalityBehavior(src.getCardinalityBehavior()));
        if (src.hasDefinitionCanonicalType())
            tgt.setDefinition(VersionConvertor_30_40.convertCanonicalToReference(src.getDefinitionCanonicalType()));
        if (src.hasTransform())
            tgt.setTransform(VersionConvertor_30_40.convertCanonicalToReference(src.getTransformElement()));
        if (src.hasDynamicValue()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue()) tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKind(convertActionConditionKind(src.getKind()));
        if (src.hasDescriptionElement())
            tgt.getExpression().setDescriptionElement((StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasLanguageElement())
            tgt.getExpression().setLanguageElement((CodeType) VersionConvertor_30_40.convertType(src.getLanguageElement()));
        if (src.hasExpressionElement())
            tgt.getExpression().setExpressionElement((StringType) VersionConvertor_30_40.convertType(src.getExpressionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKind(convertActionConditionKind(src.getKind()));
        if (src.getExpression().hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getExpression().getDescriptionElement()));
        if (src.getExpression().hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getExpression().getLanguageElement()));
        if (src.getExpression().hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getExpression().getExpressionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasDescriptionElement())
          tgt.getExpression().setDescriptionElement((StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getPathElement()));
        if (src.hasLanguageElement())
            tgt.getExpression().setLanguageElement((CodeType) VersionConvertor_30_40.convertType(src.getLanguageElement()));
        if (src.hasExpressionElement())
            tgt.getExpression().setExpressionElement((StringType) VersionConvertor_30_40.convertType(src.getExpressionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.getExpression().hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getExpression().getDescriptionElement()));
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getPathElement()));
        if (src.getExpression().hasLanguageElement())
            tgt.setLanguageElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getExpression().getLanguageElement()));
        if (src.getExpression().hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getExpression().getExpressionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertActionParticipantType(src.getType()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_40.convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertActionParticipantType(src.getType()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_40.convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasActionIdElement())
            tgt.setActionIdElement((org.hl7.fhir.r4.model.IdType) VersionConvertor_30_40.convertType(src.getActionIdElement()));
        if (src.hasRelationship())
            tgt.setRelationship(convertActionRelationshipType(src.getRelationship()));
        if (src.hasOffset())
            tgt.setOffset(VersionConvertor_30_40.convertType(src.getOffset()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasActionIdElement())
            tgt.setActionIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_30_40.convertType(src.getActionIdElement()));
        if (src.hasRelationship())
            tgt.setRelationship(convertActionRelationshipType(src.getRelationship()));
        if (src.hasOffset())
            tgt.setOffset(VersionConvertor_30_40.convertType(src.getOffset()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasDescription())
            tgt.setDescription(VersionConvertor_30_40.convertCodeableConcept(src.getDescription()));
        if (src.hasPriority())
            tgt.setPriority(VersionConvertor_30_40.convertCodeableConcept(src.getPriority()));
        if (src.hasStart())
            tgt.setStart(VersionConvertor_30_40.convertCodeableConcept(src.getStart()));
        if (src.hasAddresses()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAddresses()) tgt.addAddresses(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasDocumentation()) {
            for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(VersionConvertor_30_40.convertRelatedArtifact(t));
        }
        if (src.hasTarget()) {
            for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget()) tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasDescription())
            tgt.setDescription(VersionConvertor_30_40.convertCodeableConcept(src.getDescription()));
        if (src.hasPriority())
            tgt.setPriority(VersionConvertor_30_40.convertCodeableConcept(src.getPriority()));
        if (src.hasStart())
            tgt.setStart(VersionConvertor_30_40.convertCodeableConcept(src.getStart()));
        if (src.hasAddresses()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAddresses()) tgt.addAddresses(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasDocumentation()) {
            for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(VersionConvertor_30_40.convertRelatedArtifact(t));
        }
        if (src.hasTarget()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget()) tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(VersionConvertor_30_40.convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(VersionConvertor_30_40.convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(VersionConvertor_30_40.convertDuration(src.getDue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(VersionConvertor_30_40.convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(VersionConvertor_30_40.convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(VersionConvertor_30_40.convertDuration(src.getDue()));
        return tgt;
    }
}
