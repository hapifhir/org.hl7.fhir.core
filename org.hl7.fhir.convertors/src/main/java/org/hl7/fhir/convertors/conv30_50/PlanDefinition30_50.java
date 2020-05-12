package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.dstu3.model.ContactDetail;
import org.hl7.fhir.dstu3.model.Contributor.ContributorType;
import org.hl7.fhir.exceptions.FHIRException;

public class PlanDefinition30_50 {

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SINGLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior.SINGLE);
                break;
            case MULTIPLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior.MULTIPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SINGLE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior.SINGLE);
                break;
            case MULTIPLE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior.MULTIPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionConditionKindEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPLICABILITY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.APPLICABILITY);
                break;
            case START:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.START);
                break;
            case STOP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.STOP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKindEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPLICABILITY:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind.APPLICABILITY);
                break;
            case START:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind.START);
                break;
            case STOP:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind.STOP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case VISUALGROUP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.VISUALGROUP);
                break;
            case LOGICALGROUP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.LOGICALGROUP);
                break;
            case SENTENCEGROUP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.SENTENCEGROUP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case VISUALGROUP:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior.VISUALGROUP);
                break;
            case LOGICALGROUP:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior.LOGICALGROUP);
                break;
            case SENTENCEGROUP:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior.SENTENCEGROUP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionParticipantTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PATIENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.PATIENT);
                break;
            case PRACTITIONER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.PRACTITIONER);
                break;
            case RELATEDPERSON:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.RELATEDPERSON);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PATIENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType.PATIENT);
                break;
            case PRACTITIONER:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType.PRACTITIONER);
                break;
            case RELATEDPERSON:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType.RELATEDPERSON);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case YES:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior.YES);
                break;
            case NO:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior.NO);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case YES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior.YES);
                break;
            case NO:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior.NO);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionRelationshipTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case BEFORESTART:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFORESTART);
                break;
            case BEFORE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFORE);
                break;
            case BEFOREEND:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFOREEND);
                break;
            case CONCURRENTWITHSTART:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENTWITHSTART);
                break;
            case CONCURRENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENT);
                break;
            case CONCURRENTWITHEND:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENTWITHEND);
                break;
            case AFTERSTART:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTERSTART);
                break;
            case AFTER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTER);
                break;
            case AFTEREND:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTEREND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case BEFORESTART:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.BEFORESTART);
                break;
            case BEFORE:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.BEFORE);
                break;
            case BEFOREEND:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.BEFOREEND);
                break;
            case CONCURRENTWITHSTART:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHSTART);
                break;
            case CONCURRENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.CONCURRENT);
                break;
            case CONCURRENTWITHEND:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHEND);
                break;
            case AFTERSTART:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.AFTERSTART);
                break;
            case AFTER:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.AFTER);
                break;
            case AFTEREND:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.AFTEREND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MUST:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior.MUST);
                break;
            case COULD:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior.COULD);
                break;
            case MUSTUNLESSDOCUMENTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MUST:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.MUST);
                break;
            case COULD:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.COULD);
                break;
            case MUSTUNLESSDOCUMENTED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ANY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ANY);
                break;
            case ALL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ALL);
                break;
            case ALLORNONE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ALLORNONE);
                break;
            case EXACTLYONE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.EXACTLYONE);
                break;
            case ATMOSTONE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ATMOSTONE);
                break;
            case ONEORMORE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ONEORMORE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehaviorEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ANY:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ANY);
                break;
            case ALL:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ALL);
                break;
            case ALLORNONE:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ALLORNONE);
                break;
            case EXACTLYONE:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.EXACTLYONE);
                break;
            case ATMOSTONE:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ATMOSTONE);
                break;
            case ONEORMORE:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.ONEORMORE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.r5.model.PlanDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition tgt = new org.hl7.fhir.dstu3.model.PlanDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_30_50.convertString(src.getUsageElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(VersionConvertor_30_50.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(VersionConvertor_30_50.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTopic()) tgt.addTopic(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getAuthor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.AUTHOR);
            c.addContact(VersionConvertor_30_50.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getEditor()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.EDITOR);
            c.addContact(VersionConvertor_30_50.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getReviewer()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.REVIEWER);
            c.addContact(VersionConvertor_30_50.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getEndorser()) {
            org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
            c.setType(ContributorType.ENDORSER);
            c.addContact(VersionConvertor_30_50.convertContactDetail(t));
            tgt.addContributor(c);
        }
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_50.convertRelatedArtifact(t));
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getLibrary()) tgt.addLibrary(VersionConvertor_30_50.convertCanonicalToReference(t));
        for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal()) tgt.addGoal(convertPlanDefinitionGoalComponent(t));
        for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.dstu3.model.PlanDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition tgt = new org.hl7.fhir.r5.model.PlanDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_30_50.convertString(src.getUsageElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(VersionConvertor_30_50.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(VersionConvertor_30_50.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getTopic()) tgt.addTopic(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Contributor t : src.getContributor()) {
            if (t.getType() == ContributorType.AUTHOR)
                for (ContactDetail c : t.getContact()) tgt.addAuthor(VersionConvertor_30_50.convertContactDetail(c));
            if (t.getType() == ContributorType.EDITOR)
                for (ContactDetail c : t.getContact()) tgt.addEditor(VersionConvertor_30_50.convertContactDetail(c));
            if (t.getType() == ContributorType.REVIEWER)
                for (ContactDetail c : t.getContact()) tgt.addReviewer(VersionConvertor_30_50.convertContactDetail(c));
            if (t.getType() == ContributorType.ENDORSER)
                for (ContactDetail c : t.getContact()) tgt.addEndorser(VersionConvertor_30_50.convertContactDetail(c));
        }
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(VersionConvertor_30_50.convertRelatedArtifact(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getLibrary()) tgt.getLibrary().add(VersionConvertor_30_50.convertReferenceToCanonical(t));
        for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal()) tgt.addGoal(convertPlanDefinitionGoalComponent(t));
        for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLabel())
            tgt.setPrefixElement(VersionConvertor_30_50.convertString(src.getLabelElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasTextEquivalent())
            tgt.setTextEquivalentElement(VersionConvertor_30_50.convertString(src.getTextEquivalentElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(VersionConvertor_30_50.convertRelatedArtifact(t));
        for (org.hl7.fhir.dstu3.model.IdType t : src.getGoalId()) tgt.addGoalId(t.getValue());
        for (org.hl7.fhir.dstu3.model.TriggerDefinition t : src.getTriggerDefinition()) tgt.addTrigger(VersionConvertor_30_50.convertTriggerDefinition(t));
        for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition()) tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
        for (org.hl7.fhir.dstu3.model.DataRequirement t : src.getInput()) tgt.addInput(VersionConvertor_30_50.convertDataRequirement(t));
        for (org.hl7.fhir.dstu3.model.DataRequirement t : src.getOutput()) tgt.addOutput(VersionConvertor_30_50.convertDataRequirement(t));
        for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction()) tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_30_50.convertType(src.getTiming()));
        for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
        if (src.hasType())
            tgt.getType().addCoding(VersionConvertor_30_50.convertCoding(src.getType()));
        if (src.hasGroupingBehavior())
            tgt.setGroupingBehaviorElement(convertActionGroupingBehavior(src.getGroupingBehaviorElement()));
        if (src.hasSelectionBehavior())
            tgt.setSelectionBehaviorElement(convertActionSelectionBehavior(src.getSelectionBehaviorElement()));
        if (src.hasRequiredBehavior())
            tgt.setRequiredBehaviorElement(convertActionRequiredBehavior(src.getRequiredBehaviorElement()));
        if (src.hasPrecheckBehavior())
            tgt.setPrecheckBehaviorElement(convertActionPrecheckBehavior(src.getPrecheckBehaviorElement()));
        if (src.hasCardinalityBehavior())
            tgt.setCardinalityBehaviorElement(convertActionCardinalityBehavior(src.getCardinalityBehaviorElement()));
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_30_50.convertReferenceToCanonical(src.getDefinition()));
        if (src.hasTransform())
            tgt.setTransformElement(VersionConvertor_30_50.convertReferenceToCanonical(src.getTransform()));
        for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue()) tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
        for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasPrefix())
            tgt.setLabelElement(VersionConvertor_30_50.convertString(src.getPrefixElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasTextEquivalent())
            tgt.setTextEquivalentElement(VersionConvertor_30_50.convertString(src.getTextEquivalentElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(VersionConvertor_30_50.convertRelatedArtifact(t));
        for (org.hl7.fhir.r5.model.IdType t : src.getGoalId()) tgt.addGoalId(t.getValue());
        for (org.hl7.fhir.r5.model.TriggerDefinition t : src.getTrigger()) tgt.addTriggerDefinition(VersionConvertor_30_50.convertTriggerDefinition(t));
        for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition()) tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
        for (org.hl7.fhir.r5.model.DataRequirement t : src.getInput()) tgt.addInput(VersionConvertor_30_50.convertDataRequirement(t));
        for (org.hl7.fhir.r5.model.DataRequirement t : src.getOutput()) tgt.addOutput(VersionConvertor_30_50.convertDataRequirement(t));
        for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction()) tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_30_50.convertType(src.getTiming()));
        for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCoding(src.getType().getCodingFirstRep()));
        if (src.hasGroupingBehavior())
            tgt.setGroupingBehaviorElement(convertActionGroupingBehavior(src.getGroupingBehaviorElement()));
        if (src.hasSelectionBehavior())
            tgt.setSelectionBehaviorElement(convertActionSelectionBehavior(src.getSelectionBehaviorElement()));
        if (src.hasRequiredBehavior())
            tgt.setRequiredBehaviorElement(convertActionRequiredBehavior(src.getRequiredBehaviorElement()));
        if (src.hasPrecheckBehavior())
            tgt.setPrecheckBehaviorElement(convertActionPrecheckBehavior(src.getPrecheckBehaviorElement()));
        if (src.hasCardinalityBehavior())
            tgt.setCardinalityBehaviorElement(convertActionCardinalityBehavior(src.getCardinalityBehaviorElement()));
        if (src.hasDefinitionCanonicalType())
            tgt.setDefinition(VersionConvertor_30_50.convertCanonicalToReference(src.getDefinitionCanonicalType()));
        if (src.hasTransform())
            tgt.setTransform(VersionConvertor_30_50.convertCanonicalToReference(src.getTransformElement()));
        for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue()) tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
        for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
        if (src.hasDescription())
            tgt.getExpression().setDescription(src.getDescription());
        if (src.hasLanguage())
            tgt.getExpression().setLanguage(src.getLanguage());
        if (src.hasExpression())
            tgt.getExpression().setExpression(src.getExpression());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
        if (src.getExpression().hasDescription())
            tgt.setDescription(src.getExpression().getDescription());
        if (src.getExpression().hasLanguage())
            tgt.setLanguage(src.getExpression().getLanguage());
        if (src.getExpression().hasExpression())
            tgt.setExpression(src.getExpression().getExpression());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.getExpression().hasDescription())
            tgt.setDescription(src.getExpression().getDescription());
        if (src.hasPath())
            tgt.setPathElement(VersionConvertor_30_50.convertString(src.getPathElement()));
        if (src.getExpression().hasLanguage())
            tgt.setLanguage(src.getExpression().getLanguage());
        if (src.getExpression().hasExpression())
            tgt.setExpression(src.getExpression().getExpression());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.getExpression().setDescription(src.getDescription());
        if (src.hasPath())
            tgt.setPathElement(VersionConvertor_30_50.convertString(src.getPathElement()));
        if (src.hasLanguage())
            tgt.getExpression().setLanguage(src.getLanguage());
        if (src.hasExpression())
            tgt.getExpression().setExpression(src.getExpression());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_50.convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_50.convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasActionId())
            tgt.setActionIdElement(VersionConvertor_30_50.convertId(src.getActionIdElement()));
        if (src.hasRelationship())
            tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
        if (src.hasOffset())
            tgt.setOffset(VersionConvertor_30_50.convertType(src.getOffset()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasActionId())
            tgt.setActionIdElement(VersionConvertor_30_50.convertId(src.getActionIdElement()));
        if (src.hasRelationship())
            tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
        if (src.hasOffset())
            tgt.setOffset(VersionConvertor_30_50.convertType(src.getOffset()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategory()));
        if (src.hasDescription())
            tgt.setDescription(VersionConvertor_30_50.convertCodeableConcept(src.getDescription()));
        if (src.hasPriority())
            tgt.setPriority(VersionConvertor_30_50.convertCodeableConcept(src.getPriority()));
        if (src.hasStart())
            tgt.setStart(VersionConvertor_30_50.convertCodeableConcept(src.getStart()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAddresses()) tgt.addAddresses(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(VersionConvertor_30_50.convertRelatedArtifact(t));
        for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget()) tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategory()));
        if (src.hasDescription())
            tgt.setDescription(VersionConvertor_30_50.convertCodeableConcept(src.getDescription()));
        if (src.hasPriority())
            tgt.setPriority(VersionConvertor_30_50.convertCodeableConcept(src.getPriority()));
        if (src.hasStart())
            tgt.setStart(VersionConvertor_30_50.convertCodeableConcept(src.getStart()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAddresses()) tgt.addAddresses(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(VersionConvertor_30_50.convertRelatedArtifact(t));
        for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget()) tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(VersionConvertor_30_50.convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(VersionConvertor_30_50.convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(VersionConvertor_30_50.convertDuration(src.getDue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(VersionConvertor_30_50.convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(VersionConvertor_30_50.convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(VersionConvertor_30_50.convertDuration(src.getDue()));
        return tgt;
    }
}