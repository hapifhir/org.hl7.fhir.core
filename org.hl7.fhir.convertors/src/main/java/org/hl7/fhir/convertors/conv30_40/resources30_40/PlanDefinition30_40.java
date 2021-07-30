package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.RelatedArtifact30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.TriggerDefinition30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.dstu3.model.ContactDetail;
import org.hl7.fhir.dstu3.model.Contributor.ContributorType;
import org.hl7.fhir.exceptions.FHIRException;

public class PlanDefinition30_40 {

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case SINGLE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.SINGLE);
        break;
      case MULTIPLE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.MULTIPLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionCardinalityBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKindEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionConditionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKindEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case APPLICABILITY:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.APPLICABILITY);
        break;
      case START:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.START);
        break;
      case STOP:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.STOP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionGroupingBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case VISUALGROUP:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.VISUALGROUP);
        break;
      case LOGICALGROUP:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.LOGICALGROUP);
        break;
      case SENTENCEGROUP:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.SENTENCEGROUP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.PATIENT);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.PRACTITIONER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.RELATEDPERSON);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionPrecheckBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case YES:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.YES);
        break;
      case NO:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.NO);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case BEFORESTART:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFORESTART);
        break;
      case BEFORE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFORE);
        break;
      case BEFOREEND:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFOREEND);
        break;
      case CONCURRENTWITHSTART:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHSTART);
        break;
      case CONCURRENT:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENT);
        break;
      case CONCURRENTWITHEND:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHEND);
        break;
      case AFTERSTART:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTERSTART);
        break;
      case AFTER:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTER);
        break;
      case AFTEREND:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTEREND);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionRelationshipTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionRequiredBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case MUST:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.MUST);
        break;
      case COULD:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.COULD);
        break;
      case MUSTUNLESSDOCUMENTED:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ANY:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ANY);
        break;
      case ALL:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ALL);
        break;
      case ALLORNONE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ALLORNONE);
        break;
      case EXACTLYONE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.EXACTLYONE);
        break;
      case ATMOSTONE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ATMOSTONE);
        break;
      case ONEORMORE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ONEORMORE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehavior> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PlanDefinition.ActionSelectionBehaviorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  public static org.hl7.fhir.r4.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.dstu3.model.PlanDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition tgt = new org.hl7.fhir.r4.model.PlanDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String30_40.convertString(src.getUsageElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date30_40.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date30_40.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period30_40.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Contributor t : src.getContributor()) {
      if (t.getType() == ContributorType.AUTHOR)
        for (ContactDetail c : t.getContact()) tgt.addAuthor(ContactDetail30_40.convertContactDetail(c));
      if (t.getType() == ContributorType.EDITOR)
        for (ContactDetail c : t.getContact()) tgt.addEditor(ContactDetail30_40.convertContactDetail(c));
      if (t.getType() == ContributorType.REVIEWER)
        for (ContactDetail c : t.getContact()) tgt.addReviewer(ContactDetail30_40.convertContactDetail(c));
      if (t.getType() == ContributorType.ENDORSER)
        for (ContactDetail c : t.getContact()) tgt.addEndorser(ContactDetail30_40.convertContactDetail(c));
    }
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_40.convertContactDetail(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact30_40.convertRelatedArtifact(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getLibrary())
      tgt.getLibrary().add(Reference30_40.convertReferenceToCanonical(t));
    for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal())
      tgt.addGoal(convertPlanDefinitionGoalComponent(t));
    for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.r4.model.PlanDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PlanDefinition tgt = new org.hl7.fhir.dstu3.model.PlanDefinition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String30_40.convertString(src.getUsageElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date30_40.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date30_40.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period30_40.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor()) {
      org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
      c.setType(ContributorType.AUTHOR);
      c.addContact(ContactDetail30_40.convertContactDetail(t));
      tgt.addContributor(c);
    }
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor()) {
      org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
      c.setType(ContributorType.EDITOR);
      c.addContact(ContactDetail30_40.convertContactDetail(t));
      tgt.addContributor(c);
    }
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer()) {
      org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
      c.setType(ContributorType.REVIEWER);
      c.addContact(ContactDetail30_40.convertContactDetail(t));
      tgt.addContributor(c);
    }
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser()) {
      org.hl7.fhir.dstu3.model.Contributor c = new org.hl7.fhir.dstu3.model.Contributor();
      c.setType(ContributorType.ENDORSER);
      c.addContact(ContactDetail30_40.convertContactDetail(t));
      tgt.addContributor(c);
    }
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_40.convertContactDetail(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact30_40.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getLibrary())
      tgt.addLibrary(Reference30_40.convertCanonicalToReference(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal())
      tgt.addGoal(convertPlanDefinitionGoalComponent(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasLabel())
      tgt.setPrefixElement(String30_40.convertString(src.getLabelElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(String30_40.convertString(src.getTextEquivalentElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact30_40.convertRelatedArtifact(t));
    for (org.hl7.fhir.dstu3.model.IdType t : src.getGoalId()) tgt.addGoalId(t.getValue());
    for (org.hl7.fhir.dstu3.model.TriggerDefinition t : src.getTriggerDefinition())
      tgt.addTrigger(TriggerDefinition30_40.convertTriggerDefinition(t));
    for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition())
      tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
    for (org.hl7.fhir.dstu3.model.DataRequirement t : src.getInput())
      tgt.addInput(TriggerDefinition30_40.convertDataRequirement(t));
    for (org.hl7.fhir.dstu3.model.DataRequirement t : src.getOutput())
      tgt.addOutput(TriggerDefinition30_40.convertDataRequirement(t));
    for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction())
      tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(VersionConvertorFactory_30_40.convertType(src.getTiming()));
    for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
    if (src.hasType())
      tgt.getType().addCoding(Coding30_40.convertCoding(src.getType()));
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
      tgt.setDefinition(Reference30_40.convertReferenceToCanonical(src.getDefinition()));
    if (src.hasTransform())
      tgt.setTransformElement(Reference30_40.convertReferenceToCanonical(src.getTransform()));
    for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
    for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasPrefix())
      tgt.setLabelElement(String30_40.convertString(src.getPrefixElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(String30_40.convertString(src.getTextEquivalentElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact30_40.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.IdType t : src.getGoalId()) tgt.addGoalId(t.getValue());
    for (org.hl7.fhir.r4.model.TriggerDefinition t : src.getTrigger())
      tgt.addTriggerDefinition(TriggerDefinition30_40.convertTriggerDefinition(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition())
      tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
    for (org.hl7.fhir.r4.model.DataRequirement t : src.getInput())
      tgt.addInput(TriggerDefinition30_40.convertDataRequirement(t));
    for (org.hl7.fhir.r4.model.DataRequirement t : src.getOutput())
      tgt.addOutput(TriggerDefinition30_40.convertDataRequirement(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction())
      tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(VersionConvertorFactory_30_40.convertType(src.getTiming()));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
    if (src.hasType())
      tgt.setType(Coding30_40.convertCoding(src.getType().getCodingFirstRep()));
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
      tgt.setDefinition(Reference30_40.convertCanonicalToReference(src.getDefinitionCanonicalType()));
    if (src.hasTransform())
      tgt.setTransform(Reference30_40.convertCanonicalToReference(src.getTransformElement()));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionConditionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasDescription())
      tgt.getExpression().setDescription(src.getDescription());
    if (src.hasPath())
      tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasLanguage())
      tgt.getExpression().setLanguage(src.getLanguage());
    if (src.hasExpression())
      tgt.getExpression().setExpression(src.getExpression());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.getExpression().hasDescription())
      tgt.setDescription(src.getExpression().getDescription());
    if (src.hasPath())
      tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.getExpression().hasLanguage())
      tgt.setLanguage(src.getExpression().getLanguage());
    if (src.getExpression().hasExpression())
      tgt.setExpression(src.getExpression().getExpression());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasActionId())
      tgt.setActionIdElement(Id30_40.convertId(src.getActionIdElement()));
    if (src.hasRelationship())
      tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
    if (src.hasOffset())
      tgt.setOffset(VersionConvertorFactory_30_40.convertType(src.getOffset()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasActionId())
      tgt.setActionIdElement(Id30_40.convertId(src.getActionIdElement()));
    if (src.hasRelationship())
      tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
    if (src.hasOffset())
      tgt.setOffset(VersionConvertorFactory_30_40.convertType(src.getOffset()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategory()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept30_40.convertCodeableConcept(src.getDescription()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept30_40.convertCodeableConcept(src.getPriority()));
    if (src.hasStart())
      tgt.setStart(CodeableConcept30_40.convertCodeableConcept(src.getStart()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAddresses())
      tgt.addAddresses(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact30_40.convertRelatedArtifact(t));
    for (org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategory()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept30_40.convertCodeableConcept(src.getDescription()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept30_40.convertCodeableConcept(src.getPriority()));
    if (src.hasStart())
      tgt.setStart(CodeableConcept30_40.convertCodeableConcept(src.getStart()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAddresses())
      tgt.addAddresses(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact30_40.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept30_40.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(VersionConvertorFactory_30_40.convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(Duration30_40.convertDuration(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.dstu3.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept30_40.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(VersionConvertorFactory_30_40.convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(Duration30_40.convertDuration(src.getDue()));
    return tgt;
  }
}