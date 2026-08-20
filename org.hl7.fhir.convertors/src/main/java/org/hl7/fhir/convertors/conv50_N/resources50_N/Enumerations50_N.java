package org.hl7.fhir.convertors.conv50_N.resources50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Enumerations50_N {
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionApplicabilityBehavior> convertActionApplicabilityBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionApplicabilityBehavior> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionApplicabilityBehavior> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActionApplicabilityBehaviorEnumFactory());
//    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
//    if (src.getValue() == null) {
//      tgt.setValue(null);
//    } else {
//      switch (src.getValue()) {
//        case ALL:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionApplicabilityBehavior.ALL);
//          break;
//        case ANY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionApplicabilityBehavior.ANY);
//          break;
//        default:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionApplicabilityBehavior.NULL);
//          break;
//      }
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionApplicabilityBehavior> convertActionApplicabilityBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionApplicabilityBehavior> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionApplicabilityBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionApplicabilityBehaviorEnumFactory());
//    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
//    if (src.getValue() == null) {
//      tgt.setValue(null);
//    } else {
//      switch (src.getValue()) {
//        case ALL:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionApplicabilityBehavior.ALL);
//          break;
//        case ANY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionApplicabilityBehavior.ANY);
//          break;
//        default:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionApplicabilityBehavior.NULL);
//          break;
//      }
//    }
//    return tgt;
//  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case SINGLE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior.SINGLE);
          break;
        case MULTIPLE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior.MULTIPLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
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
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionConditionKind> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActionConditionKindEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case APPLICABILITY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionConditionKind.APPLICABILITY);
          break;
        case START:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionConditionKind.START);
          break;
        case STOP:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionConditionKind.STOP);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionConditionKind.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionConditionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionConditionKindEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
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
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActionGroupingBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case VISUALGROUP:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior.VISUALGROUP);
          break;
        case LOGICALGROUP:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior.LOGICALGROUP);
          break;
        case SENTENCEGROUP:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior.SENTENCEGROUP);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
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
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionParticipantType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActionParticipantTypeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case CARETEAM:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.CARETEAM);
          break;
        case DEVICE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.DEVICE);
          break;
        case GROUP:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.GROUP);
          break;
        case HEALTHCARESERVICE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.HEALTHCARESERVICE);
          break;
        case LOCATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.LOCATION);
          break;
        case ORGANIZATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.ORGANIZATION);
          break;
        case PATIENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.PATIENT);
          break;
        case PRACTITIONER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.PRACTITIONER);
          break;
        case PRACTITIONERROLE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.PRACTITIONERROLE);
          break;
        case RELATEDPERSON:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.RELATEDPERSON);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionParticipantType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionParticipantTypeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case CARETEAM:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.CARETEAM);
          break;
        case DEVICE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.DEVICE);
          break;
        case GROUP:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.GROUP);
          break;
        case HEALTHCARESERVICE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.HEALTHCARESERVICE);
          break;
        case LOCATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.LOCATION);
          break;
        case ORGANIZATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.ORGANIZATION);
          break;
        case PATIENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.PATIENT);
          break;
        case PRACTITIONER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.PRACTITIONER);
          break;
        case PRACTITIONERROLE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.PRACTITIONERROLE);
          break;
        case RELATEDPERSON:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.RELATEDPERSON);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case YES:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior.YES);
          break;
        case NO:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior.NO);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
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
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRelationshipType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActionRelationshipTypeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case BEFORE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.BEFORE);
          break;
        case BEFORESTART:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.BEFORESTART);
          break;
        case BEFOREEND:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.BEFOREEND);
          break;
        case CONCURRENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.CONCURRENT);
          break;
        case CONCURRENTWITHSTART:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.CONCURRENTWITHSTART);
          break;
        case CONCURRENTWITHEND:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.CONCURRENTWITHEND);
          break;
        case AFTER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.AFTER);
          break;
        case AFTERSTART:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.AFTERSTART);
          break;
        case AFTEREND:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.AFTEREND);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRelationshipType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionRelationshipTypeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case BEFORE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFORE);
          break;
        case BEFORESTART:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFORESTART);
          break;
        case BEFOREEND:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFOREEND);
          break;
        case CONCURRENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENT);
          break;
        case CONCURRENTWITHSTART:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENTWITHSTART);
          break;
        case CONCURRENTWITHEND:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENTWITHEND);
          break;
        case AFTER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTER);
          break;
        case AFTERSTART:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTERSTART);
          break;
        case AFTEREND:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTEREND);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActionRequiredBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case MUST:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior.MUST);
          break;
        case COULD:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior.COULD);
          break;
        case MUSTUNLESSDOCUMENTED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
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
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActionSelectionBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case ANY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior.ANY);
          break;
        case ALL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior.ALL);
          break;
        case ALLORNONE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior.ALLORNONE);
          break;
        case EXACTLYONE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior.EXACTLYONE);
          break;
        case ATMOSTONE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior.ATMOSTONE);
          break;
        case ONEORMORE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior.ONEORMORE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehaviorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
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
    }
    return tgt;
  }

//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType> convertActorDefinitionActorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActorDefinitionActorType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorTypeEnumFactory());
//    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
//    if (src.getValue() == null) {
//      tgt.setValue(null);
//    } else {
//      switch (src.getValue()) {
//        case PERSON:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType.PERSON);
//          break;
//        case SYSTEM:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType.SYSTEM);
//          break;
//        case COLLECTIVE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType.COLLECTIVE);
//          break;
//        case OTHER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType.OTHER);
//          break;
//        default:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType.NULL);
//          break;
//      }
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActorDefinitionActorType> convertActorDefinitionActorType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActorDefinitionActorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActorDefinitionActorTypeEnumFactory());
//    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
//    if (src.getValue() == null) {
//      tgt.setValue(null);
//    } else {
//      switch (src.getValue()) {
//        case PERSON:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActorDefinitionActorType.PERSON);
//          break;
//        case SYSTEM:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActorDefinitionActorType.SYSTEM);
//          break;
//        case COLLECTIVE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActorDefinitionActorType.COLLECTIVE);
//          break;
//        case OTHER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActorDefinitionActorType.OTHER);
//          break;
//        default:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActorDefinitionActorType.NULL);
//          break;
//      }
//    }
//    return tgt;
//  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case MALE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.AdministrativeGender.MALE);
          break;
        case FEMALE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.AdministrativeGender.FEMALE);
          break;
        case OTHER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.AdministrativeGender.OTHER);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.AdministrativeGender.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.AdministrativeGender.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> convertAdministrativeGender(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.AdministrativeGender> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.AdministrativeGender> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.AdministrativeGenderEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case MALE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.MALE);
          break;
        case FEMALE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.FEMALE);
          break;
        case OTHER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.OTHER);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.AdministrativeGender.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.BindingStrength> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.BindingStrengthEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case REQUIRED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.BindingStrength.REQUIRED);
          break;
        case EXTENSIBLE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.BindingStrength.EXTENSIBLE);
          break;
        case PREFERRED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.BindingStrength.PREFERRED);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.BindingStrength.EXAMPLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.BindingStrength.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> convertBindingStrength(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.BindingStrength> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.BindingStrength> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.BindingStrengthEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case REQUIRED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.REQUIRED);
          break;
        case EXTENSIBLE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXTENSIBLE);
          break;
        case PREFERRED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.PREFERRED);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.EXAMPLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.BindingStrength.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.CapabilityStatementKindEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case INSTANCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind.INSTANCE);
          break;
        case CAPABILITY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind.CAPABILITY);
          break;
        case REQUIREMENTS:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind.REQUIREMENTS);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKindEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case INSTANCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.INSTANCE);
          break;
        case CAPABILITY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.CAPABILITY);
          break;
        case REQUIREMENTS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.REQUIREMENTS);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> convertClaimProcessingCodes(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodesEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case QUEUED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes.QUEUED);
          break;
        case COMPLETE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes.COMPLETE);
          break;
        case ERROR:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes.ERROR);
          break;
        case PARTIAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes.PARTIAL);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> convertClaimProcessingCodes(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodesEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case QUEUED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.QUEUED);
          break;
        case COMPLETE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.COMPLETE);
          break;
        case ERROR:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.ERROR);
          break;
        case PARTIAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.PARTIAL);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.CodeSystemContentModeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case NOTPRESENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode.NOTPRESENT);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode.EXAMPLE);
          break;
        case FRAGMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode.FRAGMENT);
          break;
        case COMPLETE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode.COMPLETE);
          break;
        case SUPPLEMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode.SUPPLEMENT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode> convertCodeSystemContentMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CodeSystemContentMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CodeSystemContentModeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case NOTPRESENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.NOTPRESENT);
          break;
        case EXAMPLE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.EXAMPLE);
          break;
        case FRAGMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.FRAGMENT);
          break;
        case COMPLETE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.COMPLETE);
          break;
        case SUPPLEMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.SUPPLEMENT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CodeSystemContentMode.NULL);
          break;
      }
    }
    return tgt;
  }

//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompartmentType> convertCompartmentType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompartmentType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.CompartmentTypeEnumFactory());
//    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
//    if (src.getValue() == null) {
//      tgt.setValue(null);
//    } else {
//      switch (src.getValue()) {
//        case PATIENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.PATIENT);
//          break;
//        case ENCOUNTER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.ENCOUNTER);
//          break;
//        case RELATEDPERSON:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.RELATEDPERSON);
//          break;
//        case PRACTITIONER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.PRACTITIONER);
//          break;
//        case DEVICE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.DEVICE);
//          break;
//        case EPISODEOFCARE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.EPISODEOFCARE);
//          break;
//        default:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompartmentType.NULL);
//          break;
//      }
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> convertCompartmentType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompartmentType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompartmentTypeEnumFactory());
//    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
//    if (src.getValue() == null) {
//      tgt.setValue(null);
//    } else {
//      switch (src.getValue()) {
//        case PATIENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PATIENT);
//          break;
//        case ENCOUNTER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.ENCOUNTER);
//          break;
//        case RELATEDPERSON:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.RELATEDPERSON);
//          break;
//        case PRACTITIONER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PRACTITIONER);
//          break;
//        case DEVICE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.DEVICE);
//          break;
//        case EPISODEOFCARE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.EPISODEOFCARE);
//          break;
//        default:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.NULL);
//          break;
//      }
//    }
//    return tgt;
//  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.CompositionStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case REGISTERED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.REGISTERED);
          break;
        case PARTIAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.PARTIAL);
          break;
        case PRELIMINARY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.PRELIMINARY);
          break;
        case FINAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.FINAL);
          break;
        case AMENDED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.AMENDED);
          break;
        case CORRECTED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.CORRECTED);
          break;
        case APPENDED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.APPENDED);
          break;
        case CANCELLED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.CANCELLED);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.ENTEREDINERROR);
          break;
        case DEPRECATED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.DEPRECATED);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.CompositionStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompositionStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case REGISTERED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.REGISTERED);
          break;
        case PARTIAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.PARTIAL);
          break;
        case PRELIMINARY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.PRELIMINARY);
          break;
        case FINAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.FINAL);
          break;
        case AMENDED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.AMENDED);
          break;
        case CORRECTED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.CORRECTED);
          break;
        case APPENDED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.APPENDED);
          break;
        case CANCELLED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.CANCELLED);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.ENTEREDINERROR);
          break;
        case DEPRECATED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.DEPRECATED);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship> convertConceptMapRelationship(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ConceptMapRelationshipEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case RELATEDTO:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship.RELATEDTO);
          break;
        case EQUIVALENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship.EQUIVALENT);
          break;
        case SOURCEISNARROWERTHANTARGET:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
          break;
        case SOURCEISBROADERTHANTARGET:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
          break;
        case NOTRELATEDTO:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship.NOTRELATEDTO);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship> convertConceptMapRelationship(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationshipEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case RELATEDTO:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.RELATEDTO);
          break;
        case EQUIVALENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.EQUIVALENT);
          break;
        case SOURCEISNARROWERTHANTARGET:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
          break;
        case SOURCEISBROADERTHANTARGET:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
          break;
        case NOTRELATEDTO:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NOTRELATEDTO);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case MON:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.MON);
          break;
        case TUE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.TUE);
          break;
        case WED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.WED);
          break;
        case THU:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.THU);
          break;
        case FRI:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.FRI);
          break;
        case SAT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.SAT);
          break;
        case SUN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.SUN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> convertDaysOfWeek(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.DaysOfWeek> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DaysOfWeek> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DaysOfWeekEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case MON:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.MON);
          break;
        case TUE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.TUE);
          break;
        case WED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.WED);
          break;
        case THU:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.THU);
          break;
        case FRI:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.FRI);
          break;
        case SAT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SAT);
          break;
        case SUN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.SUN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DaysOfWeek.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.EventStatus> convertEventStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.EventStatus> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.EventStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case PREPARATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.EventStatus.PREPARATION);
          break;
        case INPROGRESS:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.EventStatus.INPROGRESS);
          break;
        case NOTDONE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.EventStatus.NOTDONE);
          break;
        case ONHOLD:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.EventStatus.ONHOLD);
          break;
        case STOPPED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.EventStatus.STOPPED);
          break;
        case COMPLETED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.EventStatus.COMPLETED);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.EventStatus.ENTEREDINERROR);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.EventStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.EventStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> convertEventStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.EventStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.EventStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case PREPARATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.PREPARATION);
          break;
        case INPROGRESS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS);
          break;
        case NOTDONE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.NOTDONE);
          break;
        case ONHOLD:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.ONHOLD);
          break;
        case STOPPED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.STOPPED);
          break;
        case COMPLETED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FHIRTypes> convertFHIRTypes(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FHIRTypes> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.FHIRTypesEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case BASE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BASE);
          break;
        case ELEMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ELEMENT);
          break;
        case BACKBONEELEMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BACKBONEELEMENT);
          break;
        case DATATYPE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DATATYPE);
          break;
        case ADDRESS:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ADDRESS);
          break;
        case ANNOTATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ANNOTATION);
          break;
        case ATTACHMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ATTACHMENT);
          break;
        case AVAILABILITY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.AVAILABILITY);
          break;
        case BACKBONETYPE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BACKBONETYPE);
          break;
        case DOSAGE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DOSAGE);
          break;
        case ELEMENTDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ELEMENTDEFINITION);
          break;
        case MARKETINGSTATUS:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MARKETINGSTATUS);
          break;
        case PRODUCTSHELFLIFE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PRODUCTSHELFLIFE);
          break;
        case TIMING:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.TIMING);
          break;
        case CODEABLECONCEPT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CODEABLECONCEPT);
          break;
        case CODEABLEREFERENCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CODEABLEREFERENCE);
          break;
        case CODING:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CODING);
          break;
        case CONTACTDETAIL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CONTACTDETAIL);
          break;
        case CONTACTPOINT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CONTACTPOINT);
          break;
        case DATAREQUIREMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DATAREQUIREMENT);
          break;
        case EXPRESSION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.EXPRESSION);
          break;
        case EXTENDEDCONTACTDETAIL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.EXTENDEDCONTACTDETAIL);
          break;
        case EXTENSION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.EXTENSION);
          break;
        case HUMANNAME:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.HUMANNAME);
          break;
        case IDENTIFIER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.IDENTIFIER);
          break;
        case META:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.META);
          break;
        case MONETARYCOMPONENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MONETARYCOMPONENT);
          break;
        case MONEY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MONEY);
          break;
        case NARRATIVE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.NARRATIVE);
          break;
        case PARAMETERDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PARAMETERDEFINITION);
          break;
        case PERIOD:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PERIOD);
          break;
        case PRIMITIVETYPE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PRIMITIVETYPE);
          break;
        case BASE64BINARY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BASE64BINARY);
          break;
        case BOOLEAN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BOOLEAN);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DATE);
          break;
        case DATETIME:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DATETIME);
          break;
        case DECIMAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DECIMAL);
          break;
        case INSTANT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.INSTANT);
          break;
        case INTEGER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.INTEGER);
          break;
        case POSITIVEINT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.POSITIVEINT);
          break;
        case UNSIGNEDINT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.UNSIGNEDINT);
          break;
        case INTEGER64:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.INTEGER64);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.STRING);
          break;
        case CODE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CODE);
          break;
        case ID:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ID);
          break;
        case MARKDOWN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MARKDOWN);
          break;
        case TIME:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.TIME);
          break;
        case URI:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.URI);
          break;
        case CANONICAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CANONICAL);
          break;
        case OID:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.OID);
          break;
        case URL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.URL);
          break;
        case UUID:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.UUID);
          break;
        case XHTML:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.XHTML);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.QUANTITY);
          break;
        case AGE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.AGE);
          break;
        case COUNT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.COUNT);
          break;
        case DISTANCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DISTANCE);
          break;
        case DURATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DURATION);
          break;
        case RANGE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.RANGE);
          break;
        case RATIO:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.RATIO);
          break;
        case RATIORANGE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.RATIORANGE);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.REFERENCE);
          break;
        case RELATEDARTIFACT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.RELATEDARTIFACT);
          break;
        case SAMPLEDDATA:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SAMPLEDDATA);
          break;
        case SIGNATURE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SIGNATURE);
          break;
        case TRIGGERDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.TRIGGERDEFINITION);
          break;
        case USAGECONTEXT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.USAGECONTEXT);
          break;
        case VIRTUALSERVICEDETAIL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.VIRTUALSERVICEDETAIL);
          break;
        case RESOURCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.RESOURCE);
          break;
        case BINARY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BINARY);
          break;
        case BUNDLE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BUNDLE);
          break;
        case DOMAINRESOURCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DOMAINRESOURCE);
          break;
        case ACCOUNT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ACCOUNT);
          break;
        case ACTIVITYDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ACTIVITYDEFINITION);
          break;
        case ACTORDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ACTORDEFINITION);
          break;
        case ADMINISTRABLEPRODUCTDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ADMINISTRABLEPRODUCTDEFINITION);
          break;
        case ADVERSEEVENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ADVERSEEVENT);
          break;
        case ALLERGYINTOLERANCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ALLERGYINTOLERANCE);
          break;
        case APPOINTMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.APPOINTMENT);
          break;
        case APPOINTMENTRESPONSE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.APPOINTMENTRESPONSE);
          break;
        case ARTIFACTASSESSMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ARTIFACTASSESSMENT);
          break;
        case AUDITEVENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.AUDITEVENT);
          break;
        case BASIC:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BASIC);
          break;
        case BIOLOGICALLYDERIVEDPRODUCT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BIOLOGICALLYDERIVEDPRODUCT);
          break;
        case BODYSTRUCTURE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.BODYSTRUCTURE);
          break;
        case CANONICALRESOURCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CANONICALRESOURCE);
          break;
        case CAPABILITYSTATEMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CAPABILITYSTATEMENT);
          break;
        case CAREPLAN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CAREPLAN);
          break;
        case CARETEAM:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CARETEAM);
          break;
        case CLAIM:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CLAIM);
          break;
        case CLAIMRESPONSE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CLAIMRESPONSE);
          break;
        case CLINICALUSEDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CLINICALUSEDEFINITION);
          break;
        case CODESYSTEM:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CODESYSTEM);
          break;
        case COMMUNICATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.COMMUNICATION);
          break;
        case COMMUNICATIONREQUEST:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.COMMUNICATIONREQUEST);
          break;
        case COMPARTMENTDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.COMPARTMENTDEFINITION);
          break;
        case COMPOSITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.COMPOSITION);
          break;
        case CONCEPTMAP:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CONCEPTMAP);
          break;
        case CONDITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CONDITION);
          break;
        case CONSENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.CONSENT);
          break;
        case COVERAGE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.COVERAGE);
          break;
        case COVERAGEELIGIBILITYREQUEST:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.COVERAGEELIGIBILITYREQUEST);
          break;
        case COVERAGEELIGIBILITYRESPONSE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.COVERAGEELIGIBILITYRESPONSE);
          break;
        case DETECTEDISSUE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DETECTEDISSUE);
          break;
        case DEVICE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DEVICE);
          break;
        case DEVICEASSOCIATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DEVICEASSOCIATION);
          break;
        case DEVICEDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DEVICEDEFINITION);
          break;
        case DEVICEMETRIC:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DEVICEMETRIC);
          break;
        case DEVICEREQUEST:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DEVICEREQUEST);
          break;
        case DIAGNOSTICREPORT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DIAGNOSTICREPORT);
          break;
        case DOCUMENTREFERENCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.DOCUMENTREFERENCE);
          break;
        case ENCOUNTER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ENCOUNTER);
          break;
        case ENDPOINT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ENDPOINT);
          break;
        case EPISODEOFCARE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.EPISODEOFCARE);
          break;
        case EVENTDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.EVENTDEFINITION);
          break;
        case EVIDENCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.EVIDENCE);
          break;
        case EVIDENCEVARIABLE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.EVIDENCEVARIABLE);
          break;
        case EXAMPLESCENARIO:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.EXAMPLESCENARIO);
          break;
        case EXPLANATIONOFBENEFIT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.EXPLANATIONOFBENEFIT);
          break;
        case FAMILYMEMBERHISTORY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.FAMILYMEMBERHISTORY);
          break;
        case FLAG:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.FLAG);
          break;
        case GOAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.GOAL);
          break;
        case GROUP:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.GROUP);
          break;
        case GUIDANCERESPONSE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.GUIDANCERESPONSE);
          break;
        case HEALTHCARESERVICE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.HEALTHCARESERVICE);
          break;
        case IMAGINGSELECTION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.IMAGINGSELECTION);
          break;
        case IMAGINGSTUDY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.IMAGINGSTUDY);
          break;
        case IMMUNIZATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.IMMUNIZATION);
          break;
        case IMPLEMENTATIONGUIDE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.IMPLEMENTATIONGUIDE);
          break;
        case INGREDIENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.INGREDIENT);
          break;
        case LIBRARY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.LIBRARY);
          break;
        case LIST:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.LIST);
          break;
        case LOCATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.LOCATION);
          break;
        case MANUFACTUREDITEMDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MANUFACTUREDITEMDEFINITION);
          break;
        case MEASURE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MEASURE);
          break;
        case MEASUREREPORT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MEASUREREPORT);
          break;
        case MEDICATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MEDICATION);
          break;
        case MEDICATIONADMINISTRATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MEDICATIONADMINISTRATION);
          break;
        case MEDICATIONDISPENSE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MEDICATIONDISPENSE);
          break;
        case MEDICATIONREQUEST:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MEDICATIONREQUEST);
          break;
        case MEDICATIONSTATEMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MEDICATIONSTATEMENT);
          break;
        case MEDICINALPRODUCTDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MEDICINALPRODUCTDEFINITION);
          break;
        case MESSAGEDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MESSAGEDEFINITION);
          break;
        case MESSAGEHEADER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.MESSAGEHEADER);
          break;
        case METADATARESOURCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.METADATARESOURCE);
          break;
        case NAMINGSYSTEM:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.NAMINGSYSTEM);
          break;
        case NUTRITIONINTAKE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.NUTRITIONINTAKE);
          break;
        case NUTRITIONORDER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.NUTRITIONORDER);
          break;
        case NUTRITIONPRODUCT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.NUTRITIONPRODUCT);
          break;
        case OBSERVATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.OBSERVATION);
          break;
        case OBSERVATIONDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.OBSERVATIONDEFINITION);
          break;
        case OPERATIONDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.OPERATIONDEFINITION);
          break;
        case OPERATIONOUTCOME:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.OPERATIONOUTCOME);
          break;
        case ORGANIZATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ORGANIZATION);
          break;
        case ORGANIZATIONAFFILIATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.ORGANIZATIONAFFILIATION);
          break;
        case PACKAGEDPRODUCTDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PACKAGEDPRODUCTDEFINITION);
          break;
        case PATIENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PATIENT);
          break;
        case PAYMENTNOTICE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PAYMENTNOTICE);
          break;
        case PAYMENTRECONCILIATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PAYMENTRECONCILIATION);
          break;
        case PERSON:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PERSON);
          break;
        case PLANDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PLANDEFINITION);
          break;
        case PRACTITIONER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PRACTITIONER);
          break;
        case PRACTITIONERROLE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PRACTITIONERROLE);
          break;
        case PROCEDURE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PROCEDURE);
          break;
        case PROVENANCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PROVENANCE);
          break;
        case QUESTIONNAIRE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.QUESTIONNAIRE);
          break;
        case QUESTIONNAIRERESPONSE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.QUESTIONNAIRERESPONSE);
          break;
        case REGULATEDAUTHORIZATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.REGULATEDAUTHORIZATION);
          break;
        case RELATEDPERSON:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.RELATEDPERSON);
          break;
        case REQUESTORCHESTRATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.REQUESTORCHESTRATION);
          break;
        case REQUIREMENTS:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.REQUIREMENTS);
          break;
        case RESEARCHSTUDY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.RESEARCHSTUDY);
          break;
        case RESEARCHSUBJECT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.RESEARCHSUBJECT);
          break;
        case RISKASSESSMENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.RISKASSESSMENT);
          break;
        case SCHEDULE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SCHEDULE);
          break;
        case SEARCHPARAMETER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SEARCHPARAMETER);
          break;
        case SERVICEREQUEST:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SERVICEREQUEST);
          break;
        case SLOT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SLOT);
          break;
        case SPECIMEN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SPECIMEN);
          break;
        case SPECIMENDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SPECIMENDEFINITION);
          break;
        case STRUCTUREDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.STRUCTUREDEFINITION);
          break;
        case SUBSCRIPTION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SUBSCRIPTION);
          break;
        case SUBSCRIPTIONSTATUS:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SUBSCRIPTIONSTATUS);
          break;
        case SUBSCRIPTIONTOPIC:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SUBSCRIPTIONTOPIC);
          break;
        case SUBSTANCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SUBSTANCE);
          break;
        case SUBSTANCEDEFINITION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.SUBSTANCEDEFINITION);
          break;
        case TASK:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.TASK);
          break;
        case TERMINOLOGYCAPABILITIES:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.TERMINOLOGYCAPABILITIES);
          break;
        case VALUESET:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.VALUESET);
          break;
        case VISIONPRESCRIPTION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.VISIONPRESCRIPTION);
          break;
        case PARAMETERS:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.PARAMETERS);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRTypes.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRTypes> convertFHIRTypes(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FHIRTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRTypes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FHIRTypesEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case BASE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BASE);
          break;
        case ELEMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ELEMENT);
          break;
        case BACKBONEELEMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BACKBONEELEMENT);
          break;
        case DATATYPE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DATATYPE);
          break;
        case ADDRESS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ADDRESS);
          break;
        case ANNOTATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ANNOTATION);
          break;
        case ATTACHMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ATTACHMENT);
          break;
        case AVAILABILITY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.AVAILABILITY);
          break;
        case BACKBONETYPE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BACKBONETYPE);
          break;
        case DOSAGE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DOSAGE);
          break;
        case ELEMENTDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ELEMENTDEFINITION);
          break;
        case MARKETINGSTATUS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MARKETINGSTATUS);
          break;
        case PRODUCTSHELFLIFE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PRODUCTSHELFLIFE);
          break;
        case TIMING:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.TIMING);
          break;
        case CODEABLECONCEPT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CODEABLECONCEPT);
          break;
        case CODEABLEREFERENCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CODEABLEREFERENCE);
          break;
        case CODING:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CODING);
          break;
        case CONTACTDETAIL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CONTACTDETAIL);
          break;
        case CONTACTPOINT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CONTACTPOINT);
          break;
        case DATAREQUIREMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DATAREQUIREMENT);
          break;
        case EXPRESSION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.EXPRESSION);
          break;
        case EXTENDEDCONTACTDETAIL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.EXTENDEDCONTACTDETAIL);
          break;
        case EXTENSION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.EXTENSION);
          break;
        case HUMANNAME:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.HUMANNAME);
          break;
        case IDENTIFIER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.IDENTIFIER);
          break;
        case META:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.META);
          break;
        case MONETARYCOMPONENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MONETARYCOMPONENT);
          break;
        case MONEY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MONEY);
          break;
        case NARRATIVE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.NARRATIVE);
          break;
        case PARAMETERDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PARAMETERDEFINITION);
          break;
        case PERIOD:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PERIOD);
          break;
        case PRIMITIVETYPE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PRIMITIVETYPE);
          break;
        case BASE64BINARY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BASE64BINARY);
          break;
        case BOOLEAN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BOOLEAN);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DATE);
          break;
        case DATETIME:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DATETIME);
          break;
        case DECIMAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DECIMAL);
          break;
        case INSTANT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.INSTANT);
          break;
        case INTEGER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.INTEGER);
          break;
        case POSITIVEINT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.POSITIVEINT);
          break;
        case UNSIGNEDINT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.UNSIGNEDINT);
          break;
        case INTEGER64:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.INTEGER64);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.STRING);
          break;
        case CODE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CODE);
          break;
        case ID:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ID);
          break;
        case MARKDOWN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MARKDOWN);
          break;
        case TIME:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.TIME);
          break;
        case URI:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.URI);
          break;
        case CANONICAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CANONICAL);
          break;
        case OID:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.OID);
          break;
        case URL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.URL);
          break;
        case UUID:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.UUID);
          break;
        case XHTML:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.XHTML);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.QUANTITY);
          break;
        case AGE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.AGE);
          break;
        case COUNT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.COUNT);
          break;
        case DISTANCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DISTANCE);
          break;
        case DURATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DURATION);
          break;
        case RANGE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.RANGE);
          break;
        case RATIO:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.RATIO);
          break;
        case RATIORANGE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.RATIORANGE);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.REFERENCE);
          break;
        case RELATEDARTIFACT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.RELATEDARTIFACT);
          break;
        case SAMPLEDDATA:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SAMPLEDDATA);
          break;
        case SIGNATURE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SIGNATURE);
          break;
        case TRIGGERDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.TRIGGERDEFINITION);
          break;
        case USAGECONTEXT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.USAGECONTEXT);
          break;
        case VIRTUALSERVICEDETAIL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.VIRTUALSERVICEDETAIL);
          break;
        case RESOURCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.RESOURCE);
          break;
        case BINARY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BINARY);
          break;
        case BUNDLE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BUNDLE);
          break;
        case DOMAINRESOURCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DOMAINRESOURCE);
          break;
        case ACCOUNT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ACCOUNT);
          break;
        case ACTIVITYDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ACTIVITYDEFINITION);
          break;
        case ACTORDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ACTORDEFINITION);
          break;
        case ADMINISTRABLEPRODUCTDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ADMINISTRABLEPRODUCTDEFINITION);
          break;
        case ADVERSEEVENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ADVERSEEVENT);
          break;
        case ALLERGYINTOLERANCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ALLERGYINTOLERANCE);
          break;
        case APPOINTMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.APPOINTMENT);
          break;
        case APPOINTMENTRESPONSE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.APPOINTMENTRESPONSE);
          break;
        case ARTIFACTASSESSMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ARTIFACTASSESSMENT);
          break;
        case AUDITEVENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.AUDITEVENT);
          break;
        case BASIC:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BASIC);
          break;
        case BIOLOGICALLYDERIVEDPRODUCT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BIOLOGICALLYDERIVEDPRODUCT);
          break;
        case BODYSTRUCTURE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.BODYSTRUCTURE);
          break;
        case CANONICALRESOURCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CANONICALRESOURCE);
          break;
        case CAPABILITYSTATEMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CAPABILITYSTATEMENT);
          break;
        case CAREPLAN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CAREPLAN);
          break;
        case CARETEAM:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CARETEAM);
          break;
        case CLAIM:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CLAIM);
          break;
        case CLAIMRESPONSE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CLAIMRESPONSE);
          break;
        case CLINICALUSEDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CLINICALUSEDEFINITION);
          break;
        case CODESYSTEM:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CODESYSTEM);
          break;
        case COMMUNICATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.COMMUNICATION);
          break;
        case COMMUNICATIONREQUEST:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.COMMUNICATIONREQUEST);
          break;
        case COMPARTMENTDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.COMPARTMENTDEFINITION);
          break;
        case COMPOSITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.COMPOSITION);
          break;
        case CONCEPTMAP:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CONCEPTMAP);
          break;
        case CONDITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CONDITION);
          break;
        case CONSENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.CONSENT);
          break;
        case COVERAGE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.COVERAGE);
          break;
        case COVERAGEELIGIBILITYREQUEST:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.COVERAGEELIGIBILITYREQUEST);
          break;
        case COVERAGEELIGIBILITYRESPONSE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.COVERAGEELIGIBILITYRESPONSE);
          break;
        case DETECTEDISSUE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DETECTEDISSUE);
          break;
        case DEVICE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DEVICE);
          break;
        case DEVICEASSOCIATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DEVICEASSOCIATION);
          break;
        case DEVICEDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DEVICEDEFINITION);
          break;
        case DEVICEMETRIC:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DEVICEMETRIC);
          break;
        case DEVICEREQUEST:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DEVICEREQUEST);
          break;
        case DIAGNOSTICREPORT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DIAGNOSTICREPORT);
          break;
        case DOCUMENTREFERENCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.DOCUMENTREFERENCE);
          break;
        case ENCOUNTER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ENCOUNTER);
          break;
        case ENDPOINT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ENDPOINT);
          break;
        case EPISODEOFCARE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.EPISODEOFCARE);
          break;
        case EVENTDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.EVENTDEFINITION);
          break;
        case EVIDENCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.EVIDENCE);
          break;
        case EVIDENCEVARIABLE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.EVIDENCEVARIABLE);
          break;
        case EXAMPLESCENARIO:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.EXAMPLESCENARIO);
          break;
        case EXPLANATIONOFBENEFIT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.EXPLANATIONOFBENEFIT);
          break;
        case FAMILYMEMBERHISTORY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.FAMILYMEMBERHISTORY);
          break;
        case FLAG:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.FLAG);
          break;
        case GOAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.GOAL);
          break;
        case GROUP:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.GROUP);
          break;
        case GUIDANCERESPONSE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.GUIDANCERESPONSE);
          break;
        case HEALTHCARESERVICE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.HEALTHCARESERVICE);
          break;
        case IMAGINGSELECTION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.IMAGINGSELECTION);
          break;
        case IMAGINGSTUDY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.IMAGINGSTUDY);
          break;
        case IMMUNIZATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.IMMUNIZATION);
          break;
        case IMPLEMENTATIONGUIDE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.IMPLEMENTATIONGUIDE);
          break;
        case INGREDIENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.INGREDIENT);
          break;
        case LIBRARY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.LIBRARY);
          break;
        case LIST:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.LIST);
          break;
        case LOCATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.LOCATION);
          break;
        case MANUFACTUREDITEMDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MANUFACTUREDITEMDEFINITION);
          break;
        case MEASURE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MEASURE);
          break;
        case MEASUREREPORT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MEASUREREPORT);
          break;
        case MEDICATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MEDICATION);
          break;
        case MEDICATIONADMINISTRATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MEDICATIONADMINISTRATION);
          break;
        case MEDICATIONDISPENSE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MEDICATIONDISPENSE);
          break;
        case MEDICATIONREQUEST:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MEDICATIONREQUEST);
          break;
        case MEDICATIONSTATEMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MEDICATIONSTATEMENT);
          break;
        case MEDICINALPRODUCTDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MEDICINALPRODUCTDEFINITION);
          break;
        case MESSAGEDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MESSAGEDEFINITION);
          break;
        case MESSAGEHEADER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.MESSAGEHEADER);
          break;
        case METADATARESOURCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.METADATARESOURCE);
          break;
        case NAMINGSYSTEM:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.NAMINGSYSTEM);
          break;
        case NUTRITIONINTAKE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.NUTRITIONINTAKE);
          break;
        case NUTRITIONORDER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.NUTRITIONORDER);
          break;
        case NUTRITIONPRODUCT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.NUTRITIONPRODUCT);
          break;
        case OBSERVATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.OBSERVATION);
          break;
        case OBSERVATIONDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.OBSERVATIONDEFINITION);
          break;
        case OPERATIONDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.OPERATIONDEFINITION);
          break;
        case OPERATIONOUTCOME:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.OPERATIONOUTCOME);
          break;
        case ORGANIZATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ORGANIZATION);
          break;
        case ORGANIZATIONAFFILIATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.ORGANIZATIONAFFILIATION);
          break;
        case PACKAGEDPRODUCTDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PACKAGEDPRODUCTDEFINITION);
          break;
        case PATIENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PATIENT);
          break;
        case PAYMENTNOTICE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PAYMENTNOTICE);
          break;
        case PAYMENTRECONCILIATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PAYMENTRECONCILIATION);
          break;
        case PERSON:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PERSON);
          break;
        case PLANDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PLANDEFINITION);
          break;
        case PRACTITIONER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PRACTITIONER);
          break;
        case PRACTITIONERROLE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PRACTITIONERROLE);
          break;
        case PROCEDURE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PROCEDURE);
          break;
        case PROVENANCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PROVENANCE);
          break;
        case QUESTIONNAIRE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.QUESTIONNAIRE);
          break;
        case QUESTIONNAIRERESPONSE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.QUESTIONNAIRERESPONSE);
          break;
        case REGULATEDAUTHORIZATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.REGULATEDAUTHORIZATION);
          break;
        case RELATEDPERSON:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.RELATEDPERSON);
          break;
        case REQUESTORCHESTRATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.REQUESTORCHESTRATION);
          break;
        case REQUIREMENTS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.REQUIREMENTS);
          break;
        case RESEARCHSTUDY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.RESEARCHSTUDY);
          break;
        case RESEARCHSUBJECT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.RESEARCHSUBJECT);
          break;
        case RISKASSESSMENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.RISKASSESSMENT);
          break;
        case SCHEDULE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SCHEDULE);
          break;
        case SEARCHPARAMETER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SEARCHPARAMETER);
          break;
        case SERVICEREQUEST:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SERVICEREQUEST);
          break;
        case SLOT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SLOT);
          break;
        case SPECIMEN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SPECIMEN);
          break;
        case SPECIMENDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SPECIMENDEFINITION);
          break;
        case STRUCTUREDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.STRUCTUREDEFINITION);
          break;
        case SUBSCRIPTION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SUBSCRIPTION);
          break;
        case SUBSCRIPTIONSTATUS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SUBSCRIPTIONSTATUS);
          break;
        case SUBSCRIPTIONTOPIC:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SUBSCRIPTIONTOPIC);
          break;
        case SUBSTANCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SUBSTANCE);
          break;
        case SUBSTANCEDEFINITION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.SUBSTANCEDEFINITION);
          break;
        case TASK:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.TASK);
          break;
        case TERMINOLOGYCAPABILITIES:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.TERMINOLOGYCAPABILITIES);
          break;
        case VALUESET:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.VALUESET);
          break;
        case VISIONPRESCRIPTION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.VISIONPRESCRIPTION);
          break;
        case PARAMETERS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.PARAMETERS);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FHIRVersion> convertFHIRVersion(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FHIRVersion> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.FHIRVersionEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case _0_01:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_01);
          break;
        case _0_05:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_05);
          break;
        case _0_06:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_06);
          break;
        case _0_11:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_11);
          break;
        case _0_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_0);
          break;
        case _0_0_80:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_0_80);
          break;
        case _0_0_81:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_0_81);
          break;
        case _0_0_82:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_0_82);
          break;
        case _0_4:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_4);
          break;
        case _0_4_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_4_0);
          break;
        case _0_5:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_5);
          break;
        case _0_5_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._0_5_0);
          break;
        case _1_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_0);
          break;
        case _1_0_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_0_0);
          break;
        case _1_0_1:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_0_1);
          break;
        case _1_0_2:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_0_2);
          break;
        case _1_1:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_1);
          break;
        case _1_1_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_1_0);
          break;
        case _1_4:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_4);
          break;
        case _1_4_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_4_0);
          break;
        case _1_6:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_6);
          break;
        case _1_6_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_6_0);
          break;
        case _1_8:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_8);
          break;
        case _1_8_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._1_8_0);
          break;
        case _3_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._3_0);
          break;
        case _3_0_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._3_0_0);
          break;
        case _3_0_1:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._3_0_1);
          break;
        case _3_0_2:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._3_0_2);
          break;
        case _3_3:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._3_3);
          break;
        case _3_3_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._3_3_0);
          break;
        case _3_5:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._3_5);
          break;
        case _3_5_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._3_5_0);
          break;
        case _4_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_0);
          break;
        case _4_0_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_0_0);
          break;
        case _4_0_1:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_0_1);
          break;
        case _4_1:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_1);
          break;
        case _4_1_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_1_0);
          break;
        case _4_2:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_2);
          break;
        case _4_2_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_2_0);
          break;
        case _4_3:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_3);
          break;
        case _4_3_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_3_0);
          break;
        case _4_3_0CIBUILD:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_3_0CIBUILD);
          break;
        case _4_3_0SNAPSHOT1:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_3_0SNAPSHOT1);
          break;
        case _4_4:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_4);
          break;
        case _4_4_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_4_0);
          break;
        case _4_5:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_5);
          break;
        case _4_5_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_5_0);
          break;
        case _4_6:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_6);
          break;
        case _4_6_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._4_6_0);
          break;
        case _5_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._5_0);
          break;
        case _5_0_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._5_0_0);
          break;
        case _5_0_0CIBUILD:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._5_0_0CIBUILD);
          break;
        case _5_0_0SNAPSHOT1:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._5_0_0SNAPSHOT1);
          break;
        case _5_0_0SNAPSHOT2:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._5_0_0SNAPSHOT2);
          break;
        case _5_0_0BALLOT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._5_0_0BALLOT);
          break;
        case _5_0_0SNAPSHOT3:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._5_0_0SNAPSHOT3);
          break;
        case _5_0_0DRAFTFINAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._5_0_0DRAFTFINAL);
          break;
        case _6_0_0:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion._6_0_0);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FHIRVersion.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> convertFHIRVersion(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FHIRVersion> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FHIRVersion> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FHIRVersionEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case _0_01:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_01);
          break;
        case _0_05:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_05);
          break;
        case _0_06:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_06);
          break;
        case _0_11:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_11);
          break;
        case _0_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0);
          break;
        case _0_0_80:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0_80);
          break;
        case _0_0_81:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0_81);
          break;
        case _0_0_82:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_0_82);
          break;
        case _0_4:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_4);
          break;
        case _0_4_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_4_0);
          break;
        case _0_5:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_5);
          break;
        case _0_5_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._0_5_0);
          break;
        case _1_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0);
          break;
        case _1_0_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0_0);
          break;
        case _1_0_1:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0_1);
          break;
        case _1_0_2:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_0_2);
          break;
        case _1_1:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_1);
          break;
        case _1_1_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_1_0);
          break;
        case _1_4:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_4);
          break;
        case _1_4_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_4_0);
          break;
        case _1_6:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_6);
          break;
        case _1_6_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_6_0);
          break;
        case _1_8:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_8);
          break;
        case _1_8_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._1_8_0);
          break;
        case _3_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_0);
          break;
        case _3_0_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_0_0);
          break;
        case _3_0_1:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_0_1);
          break;
        case _3_0_2:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_0_2);
          break;
        case _3_3:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_3);
          break;
        case _3_3_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_3_0);
          break;
        case _3_5:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_5);
          break;
        case _3_5_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._3_5_0);
          break;
        case _4_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_0);
          break;
        case _4_0_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_0_0);
          break;
        case _4_0_1:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_0_1);
          break;
        case _4_1:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_1);
          break;
        case _4_1_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_1_0);
          break;
        case _4_2:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_2);
          break;
        case _4_2_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_2_0);
          break;
        case _4_3:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_3);
          break;
        case _4_3_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_3_0);
          break;
        case _4_3_0CIBUILD:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_3_0CIBUILD);
          break;
        case _4_3_0SNAPSHOT1:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_3_0SNAPSHOT1);
          break;
        case _4_4:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_4);
          break;
        case _4_4_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_4_0);
          break;
        case _4_5:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_5);
          break;
        case _4_5_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_5_0);
          break;
        case _4_6:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_6);
          break;
        case _4_6_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._4_6_0);
          break;
        case _5_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._5_0);
          break;
        case _5_0_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._5_0_0);
          break;
        case _5_0_0CIBUILD:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._5_0_0CIBUILD);
          break;
        case _5_0_0SNAPSHOT1:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._5_0_0SNAPSHOT1);
          break;
        case _5_0_0SNAPSHOT2:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._5_0_0SNAPSHOT2);
          break;
        case _5_0_0BALLOT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._5_0_0BALLOT);
          break;
        case _5_0_0SNAPSHOT3:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._5_0_0SNAPSHOT3);
          break;
        case _5_0_0DRAFTFINAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._5_0_0DRAFTFINAL);
          break;
        case _6_0_0:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion._6_0_0);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FilterOperator> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.FilterOperatorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case EQUAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.EQUAL);
          break;
        case ISA:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.ISA);
          break;
        case DESCENDENTOF:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.DESCENDENTOF);
          break;
        case ISNOTA:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.ISNOTA);
          break;
        case REGEX:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.REGEX);
          break;
        case IN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.IN);
          break;
        case NOTIN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.NOTIN);
          break;
        case GENERALIZES:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.GENERALIZES);
          break;
        case CHILDOF:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.CHILDOF);
          break;
        case DESCENDENTLEAF:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.DESCENDENTLEAF);
          break;
        case EXISTS:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.EXISTS);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FilterOperator.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> convertFilterOperator(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FilterOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FilterOperator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FilterOperatorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case EQUAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EQUAL);
          break;
        case ISA:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISA);
          break;
        case DESCENDENTOF:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.DESCENDENTOF);
          break;
        case ISNOTA:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.ISNOTA);
          break;
        case REGEX:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.REGEX);
          break;
        case IN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.IN);
          break;
        case NOTIN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NOTIN);
          break;
        case GENERALIZES:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.GENERALIZES);
          break;
        case CHILDOF:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.CHILDOF);
          break;
        case DESCENDENTLEAF:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.DESCENDENTLEAF);
          break;
        case EXISTS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.EXISTS);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FilterOperator.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertFinancialResourceStatusCodes(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes.ACTIVE);
          break;
        case CANCELLED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes.CANCELLED);
          break;
        case DRAFT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes.DRAFT);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertFinancialResourceStatusCodes(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
          break;
        case CANCELLED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
          break;
        case DRAFT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ObservationStatus> convertObservationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.ObservationStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case REGISTERED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ObservationStatus.REGISTERED);
          break;
        case PRELIMINARY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ObservationStatus.PRELIMINARY);
          break;
        case FINAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ObservationStatus.FINAL);
          break;
        case AMENDED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ObservationStatus.AMENDED);
          break;
        case CORRECTED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ObservationStatus.CORRECTED);
          break;
        case CANCELLED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ObservationStatus.CANCELLED);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ObservationStatus.ENTEREDINERROR);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ObservationStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.ObservationStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> convertObservationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ObservationStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case REGISTERED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.REGISTERED);
          break;
        case PRELIMINARY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.PRELIMINARY);
          break;
        case FINAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.FINAL);
          break;
        case AMENDED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.AMENDED);
          break;
        case CORRECTED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CORRECTED);
          break;
        case CANCELLED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CANCELLED);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.ENTEREDINERROR);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case IN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.OperationParameterUse.IN);
          break;
        case OUT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.OperationParameterUse.OUT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.OperationParameterUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case IN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.IN);
          break;
        case OUT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.OUT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.PublicationStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case DRAFT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.PublicationStatus.DRAFT);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.PublicationStatus.ACTIVE);
          break;
        case RETIRED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.PublicationStatus.RETIRED);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.PublicationStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.PublicationStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> convertPublicationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.PublicationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.PublicationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.PublicationStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case DRAFT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.ACTIVE);
          break;
        case RETIRED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.RETIRED);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.QuantityComparatorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case LESS_THAN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.QuantityComparator.LESS_THAN);
          break;
        case LESS_OR_EQUAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.QuantityComparator.LESS_OR_EQUAL);
          break;
        case GREATER_OR_EQUAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.QuantityComparator.GREATER_OR_EQUAL);
          break;
        case GREATER_THAN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.QuantityComparator.GREATER_THAN);
          break;
        case AD:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.QuantityComparator.AD);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.QuantityComparator.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> convertQuantityComparator(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.QuantityComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.QuantityComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.QuantityComparatorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case LESS_THAN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.LESS_THAN);
          break;
        case LESS_OR_EQUAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.LESS_OR_EQUAL);
          break;
        case GREATER_OR_EQUAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.GREATER_OR_EQUAL);
          break;
        case GREATER_THAN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.GREATER_THAN);
          break;
        case AD:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.AD);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.QuantityComparator.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> convertRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.RequestIntentEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case PROPOSAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.PROPOSAL);
          break;
        case PLAN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.PLAN);
          break;
        case DIRECTIVE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.DIRECTIVE);
          break;
        case ORDER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.ORDER);
          break;
        case ORIGINALORDER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.ORIGINALORDER);
          break;
        case REFLEXORDER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.REFLEXORDER);
          break;
        case FILLERORDER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.FILLERORDER);
          break;
        case INSTANCEORDER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.INSTANCEORDER);
          break;
        case OPTION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.OPTION);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestIntent.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> convertRequestIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestIntentEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case PROPOSAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PROPOSAL);
          break;
        case PLAN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PLAN);
          break;
        case DIRECTIVE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.DIRECTIVE);
          break;
        case ORDER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORDER);
          break;
        case ORIGINALORDER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORIGINALORDER);
          break;
        case REFLEXORDER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.REFLEXORDER);
          break;
        case FILLERORDER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.FILLERORDER);
          break;
        case INSTANCEORDER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.INSTANCEORDER);
          break;
        case OPTION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.OPTION);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.RequestPriorityEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case ROUTINE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestPriority.ROUTINE);
          break;
        case URGENT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestPriority.URGENT);
          break;
        case ASAP:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestPriority.ASAP);
          break;
        case STAT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestPriority.STAT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestPriority.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case ROUTINE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE);
          break;
        case URGENT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT);
          break;
        case ASAP:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP);
          break;
        case STAT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> convertRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.RequestStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case DRAFT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestStatus.DRAFT);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestStatus.ACTIVE);
          break;
        case ONHOLD:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestStatus.ONHOLD);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestStatus.ENTEREDINERROR);
          break;
        case COMPLETED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestStatus.COMPLETED);
          break;
        case REVOKED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestStatus.REVOKED);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.RequestStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertRequestStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case DRAFT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE);
          break;
        case ONHOLD:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ONHOLD);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ENTEREDINERROR);
          break;
        case COMPLETED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED);
          break;
        case REVOKED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED);
          break;
        case UNKNOWN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.UNKNOWN);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchComparator> convertSearchComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchComparator> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.SearchComparatorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case EQ:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.EQ);
          break;
        case NE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.NE);
          break;
        case GT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.GT);
          break;
        case LT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.LT);
          break;
        case GE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.GE);
          break;
        case LE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.LE);
          break;
        case SA:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.SA);
          break;
        case EB:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.EB);
          break;
        case AP:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.AP);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchComparator.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchComparator> convertSearchComparator(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchComparatorEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case EQ:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.EQ);
          break;
        case NE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.NE);
          break;
        case GT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.GT);
          break;
        case LT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.LT);
          break;
        case GE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.GE);
          break;
        case LE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.LE);
          break;
        case SA:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.SA);
          break;
        case EB:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.EB);
          break;
        case AP:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.AP);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchComparator.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchModifierCode> convertSearchModifierCode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchModifierCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchModifierCode> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.SearchModifierCodeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case MISSING:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.MISSING);
          break;
        case EXACT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.EXACT);
          break;
        case CONTAINS:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.CONTAINS);
          break;
        case NOT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.NOT);
          break;
        case TEXT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.TEXT);
          break;
        case IN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.IN);
          break;
        case NOTIN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.NOTIN);
          break;
        case BELOW:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.BELOW);
          break;
        case ABOVE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.ABOVE);
          break;
        case TYPE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.TYPE);
          break;
        case IDENTIFIER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.IDENTIFIER);
          break;
        case OFTYPE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.OFTYPE);
          break;
        case CODETEXT:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.CODETEXT);
          break;
        case TEXTADVANCED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.TEXTADVANCED);
          break;
        case ITERATE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.ITERATE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchModifierCode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchModifierCode> convertSearchModifierCode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchModifierCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchModifierCode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchModifierCodeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case MISSING:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.MISSING);
          break;
        case EXACT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.EXACT);
          break;
        case CONTAINS:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.CONTAINS);
          break;
        case NOT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.NOT);
          break;
        case TEXT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.TEXT);
          break;
        case IN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.IN);
          break;
        case NOTIN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.NOTIN);
          break;
        case BELOW:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.BELOW);
          break;
        case ABOVE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.ABOVE);
          break;
        case TYPE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.TYPE);
          break;
        case IDENTIFIER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.IDENTIFIER);
          break;
        case OFTYPE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.OFTYPE);
          break;
        case CODETEXT:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.CODETEXT);
          break;
        case TEXTADVANCED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.TEXTADVANCED);
          break;
        case ITERATE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.ITERATE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchModifierCode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchParamType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case NUMBER:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.NUMBER);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.DATE);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.STRING);
          break;
        case TOKEN:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.TOKEN);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.REFERENCE);
          break;
        case COMPOSITE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.COMPOSITE);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.QUANTITY);
          break;
        case URI:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.URI);
          break;
        case SPECIAL:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.SPECIAL);
          break;
        case RESOURCE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.RESOURCE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SearchParamType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> convertSearchParamType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SearchParamType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SearchParamType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SearchParamTypeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case NUMBER:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NUMBER);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.DATE);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.STRING);
          break;
        case TOKEN:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.TOKEN);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.REFERENCE);
          break;
        case COMPOSITE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.COMPOSITE);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.QUANTITY);
          break;
        case URI:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.URI);
          break;
        case SPECIAL:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.SPECIAL);
          break;
        case RESOURCE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.RESOURCE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SearchParamType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes> convertSubscriptionStatusCodes(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodesEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case REQUESTED:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.REQUESTED);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.ACTIVE);
          break;
        case ERROR:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.ERROR);
          break;
        case OFF:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.OFF);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.ENTEREDINERROR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes> convertSubscriptionStatusCodes(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodesEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case REQUESTED:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.REQUESTED);
          break;
        case ACTIVE:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.ACTIVE);
          break;
        case ERROR:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.ERROR);
          break;
        case OFF:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.OFF);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.ENTEREDINERROR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> convertUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.UseEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case CLAIM:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.Use.CLAIM);
          break;
        case PREAUTHORIZATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.Use.PREAUTHORIZATION);
          break;
        case PREDETERMINATION:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.Use.PREDETERMINATION);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.Enumerations.Use.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> convertUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.UseEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case CLAIM:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.CLAIM);
          break;
        case PREAUTHORIZATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.PREAUTHORIZATION);
          break;
        case PREDETERMINATION:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.PREDETERMINATION);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.NULL);
          break;
      }
    }
    return tgt;
  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll> convertVersionIndependentResourceTypesAll(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAllEnumFactory());
//    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
//    if (src.getValue() == null) {
//      tgt.setValue(null);
//    } else {
//      switch (src.getValue()) {
//        case ACCOUNT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ACCOUNT);
//          break;
//        case ACTIVITYDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ACTIVITYDEFINITION);
//          break;
//        case ACTORDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ACTORDEFINITION);
//          break;
//        case ADMINISTRABLEPRODUCTDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ADMINISTRABLEPRODUCTDEFINITION);
//          break;
//        case ADVERSEEVENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ADVERSEEVENT);
//          break;
//        case ALLERGYINTOLERANCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ALLERGYINTOLERANCE);
//          break;
//        case APPOINTMENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.APPOINTMENT);
//          break;
//        case APPOINTMENTRESPONSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.APPOINTMENTRESPONSE);
//          break;
//        case ARTIFACTASSESSMENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ARTIFACTASSESSMENT);
//          break;
//        case AUDITEVENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.AUDITEVENT);
//          break;
//        case BASIC:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.BASIC);
//          break;
//        case BINARY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.BINARY);
//          break;
//        case BIOLOGICALLYDERIVEDPRODUCT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.BIOLOGICALLYDERIVEDPRODUCT);
//          break;
//        case BIOLOGICALLYDERIVEDPRODUCTDISPENSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.BIOLOGICALLYDERIVEDPRODUCTDISPENSE);
//          break;
//        case BODYSTRUCTURE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.BODYSTRUCTURE);
//          break;
//        case BUNDLE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.BUNDLE);
//          break;
//        case CANONICALRESOURCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CANONICALRESOURCE);
//          break;
//        case CAPABILITYSTATEMENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CAPABILITYSTATEMENT);
//          break;
//        case CAREPLAN:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CAREPLAN);
//          break;
//        case CARETEAM:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CARETEAM);
//          break;
//        case CHARGEITEM:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CHARGEITEM);
//          break;
//        case CHARGEITEMDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CHARGEITEMDEFINITION);
//          break;
//        case CITATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CITATION);
//          break;
//        case CLAIM:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CLAIM);
//          break;
//        case CLAIMRESPONSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CLAIMRESPONSE);
//          break;
//        case CLINICALIMPRESSION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CLINICALIMPRESSION);
//          break;
//        case CLINICALUSEDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CLINICALUSEDEFINITION);
//          break;
//        case CODESYSTEM:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CODESYSTEM);
//          break;
//        case COMMUNICATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.COMMUNICATION);
//          break;
//        case COMMUNICATIONREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.COMMUNICATIONREQUEST);
//          break;
//        case COMPARTMENTDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.COMPARTMENTDEFINITION);
//          break;
//        case COMPOSITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.COMPOSITION);
//          break;
//        case CONCEPTMAP:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CONCEPTMAP);
//          break;
//        case CONDITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CONDITION);
//          break;
//        case CONDITIONDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CONDITIONDEFINITION);
//          break;
//        case CONSENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CONSENT);
//          break;
//        case CONTRACT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CONTRACT);
//          break;
//        case COVERAGE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.COVERAGE);
//          break;
//        case COVERAGEELIGIBILITYREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.COVERAGEELIGIBILITYREQUEST);
//          break;
//        case COVERAGEELIGIBILITYRESPONSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.COVERAGEELIGIBILITYRESPONSE);
//          break;
//        case DETECTEDISSUE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DETECTEDISSUE);
//          break;
//        case DEVICE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICE);
//          break;
//        case DEVICEASSOCIATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICEASSOCIATION);
//          break;
//        case DEVICEDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICEDEFINITION);
//          break;
//        case DEVICEDISPENSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICEDISPENSE);
//          break;
//        case DEVICEMETRIC:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICEMETRIC);
//          break;
//        case DEVICEREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICEREQUEST);
//          break;
//        case DEVICEUSAGE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICEUSAGE);
//          break;
//        case DIAGNOSTICREPORT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DIAGNOSTICREPORT);
//          break;
//        case DOCUMENTREFERENCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DOCUMENTREFERENCE);
//          break;
//        case DOMAINRESOURCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DOMAINRESOURCE);
//          break;
//        case ENCOUNTER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ENCOUNTER);
//          break;
//        case ENCOUNTERHISTORY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ENCOUNTERHISTORY);
//          break;
//        case ENDPOINT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ENDPOINT);
//          break;
//        case ENROLLMENTREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ENROLLMENTREQUEST);
//          break;
//        case ENROLLMENTRESPONSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ENROLLMENTRESPONSE);
//          break;
//        case EPISODEOFCARE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.EPISODEOFCARE);
//          break;
//        case EVENTDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.EVENTDEFINITION);
//          break;
//        case EVIDENCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.EVIDENCE);
//          break;
//        case EVIDENCEREPORT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.EVIDENCEREPORT);
//          break;
//        case EVIDENCEVARIABLE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.EVIDENCEVARIABLE);
//          break;
//        case EXAMPLESCENARIO:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.EXAMPLESCENARIO);
//          break;
//        case EXPLANATIONOFBENEFIT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.EXPLANATIONOFBENEFIT);
//          break;
//        case FAMILYMEMBERHISTORY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.FAMILYMEMBERHISTORY);
//          break;
//        case FLAG:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.FLAG);
//          break;
//        case FORMULARYITEM:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.FORMULARYITEM);
//          break;
//        case GENOMICSTUDY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.GENOMICSTUDY);
//          break;
//        case GOAL:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.GOAL);
//          break;
//        case GRAPHDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.GRAPHDEFINITION);
//          break;
//        case GROUP:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.GROUP);
//          break;
//        case GUIDANCERESPONSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.GUIDANCERESPONSE);
//          break;
//        case HEALTHCARESERVICE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.HEALTHCARESERVICE);
//          break;
//        case IMAGINGSELECTION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.IMAGINGSELECTION);
//          break;
//        case IMAGINGSTUDY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.IMAGINGSTUDY);
//          break;
//        case IMMUNIZATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.IMMUNIZATION);
//          break;
//        case IMMUNIZATIONEVALUATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.IMMUNIZATIONEVALUATION);
//          break;
//        case IMMUNIZATIONRECOMMENDATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.IMMUNIZATIONRECOMMENDATION);
//          break;
//        case IMPLEMENTATIONGUIDE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.IMPLEMENTATIONGUIDE);
//          break;
//        case INGREDIENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.INGREDIENT);
//          break;
//        case INSURANCEPLAN:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.INSURANCEPLAN);
//          break;
//        case INVENTORYITEM:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.INVENTORYITEM);
//          break;
//        case INVENTORYREPORT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.INVENTORYREPORT);
//          break;
//        case INVOICE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.INVOICE);
//          break;
//        case LIBRARY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.LIBRARY);
//          break;
//        case LINKAGE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.LINKAGE);
//          break;
//        case LIST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.LIST);
//          break;
//        case LOCATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.LOCATION);
//          break;
//        case MANUFACTUREDITEMDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MANUFACTUREDITEMDEFINITION);
//          break;
//        case MEASURE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEASURE);
//          break;
//        case MEASUREREPORT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEASUREREPORT);
//          break;
//        case MEDICATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICATION);
//          break;
//        case MEDICATIONADMINISTRATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONADMINISTRATION);
//          break;
//        case MEDICATIONDISPENSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONDISPENSE);
//          break;
//        case MEDICATIONKNOWLEDGE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONKNOWLEDGE);
//          break;
//        case MEDICATIONREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONREQUEST);
//          break;
//        case MEDICATIONSTATEMENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONSTATEMENT);
//          break;
//        case MEDICINALPRODUCTDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTDEFINITION);
//          break;
//        case MESSAGEDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MESSAGEDEFINITION);
//          break;
//        case MESSAGEHEADER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MESSAGEHEADER);
//          break;
//        case METADATARESOURCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.METADATARESOURCE);
//          break;
//        case MOLECULARSEQUENCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MOLECULARSEQUENCE);
//          break;
//        case NAMINGSYSTEM:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.NAMINGSYSTEM);
//          break;
//        case NUTRITIONINTAKE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.NUTRITIONINTAKE);
//          break;
//        case NUTRITIONORDER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.NUTRITIONORDER);
//          break;
//        case NUTRITIONPRODUCT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.NUTRITIONPRODUCT);
//          break;
//        case OBSERVATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.OBSERVATION);
//          break;
//        case OBSERVATIONDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.OBSERVATIONDEFINITION);
//          break;
//        case OPERATIONDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.OPERATIONDEFINITION);
//          break;
//        case OPERATIONOUTCOME:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.OPERATIONOUTCOME);
//          break;
//        case ORGANIZATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ORGANIZATION);
//          break;
//        case ORGANIZATIONAFFILIATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ORGANIZATIONAFFILIATION);
//          break;
//        case PACKAGEDPRODUCTDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PACKAGEDPRODUCTDEFINITION);
//          break;
//        case PARAMETERS:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PARAMETERS);
//          break;
//        case PATIENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PATIENT);
//          break;
//        case PAYMENTNOTICE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PAYMENTNOTICE);
//          break;
//        case PAYMENTRECONCILIATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PAYMENTRECONCILIATION);
//          break;
//        case PERMISSION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PERMISSION);
//          break;
//        case PERSON:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PERSON);
//          break;
//        case PLANDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PLANDEFINITION);
//          break;
//        case PRACTITIONER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PRACTITIONER);
//          break;
//        case PRACTITIONERROLE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PRACTITIONERROLE);
//          break;
//        case PROCEDURE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PROCEDURE);
//          break;
//        case PROVENANCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PROVENANCE);
//          break;
//        case QUESTIONNAIRE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.QUESTIONNAIRE);
//          break;
//        case QUESTIONNAIRERESPONSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.QUESTIONNAIRERESPONSE);
//          break;
//        case REGULATEDAUTHORIZATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.REGULATEDAUTHORIZATION);
//          break;
//        case RELATEDPERSON:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.RELATEDPERSON);
//          break;
//        case REQUESTORCHESTRATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.REQUESTORCHESTRATION);
//          break;
//        case REQUIREMENTS:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.REQUIREMENTS);
//          break;
//        case RESEARCHSTUDY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.RESEARCHSTUDY);
//          break;
//        case RESEARCHSUBJECT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.RESEARCHSUBJECT);
//          break;
//        case RESOURCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.RESOURCE);
//          break;
//        case RISKASSESSMENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.RISKASSESSMENT);
//          break;
//        case SCHEDULE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SCHEDULE);
//          break;
//        case SEARCHPARAMETER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SEARCHPARAMETER);
//          break;
//        case SERVICEREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SERVICEREQUEST);
//          break;
//        case SLOT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SLOT);
//          break;
//        case SPECIMEN:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SPECIMEN);
//          break;
//        case SPECIMENDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SPECIMENDEFINITION);
//          break;
//        case STRUCTUREDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.STRUCTUREDEFINITION);
//          break;
//        case STRUCTUREMAP:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.STRUCTUREMAP);
//          break;
//        case SUBSCRIPTION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSCRIPTION);
//          break;
//        case SUBSCRIPTIONSTATUS:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSCRIPTIONSTATUS);
//          break;
//        case SUBSCRIPTIONTOPIC:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSCRIPTIONTOPIC);
//          break;
//        case SUBSTANCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCE);
//          break;
//        case SUBSTANCEDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCEDEFINITION);
//          break;
//        case SUBSTANCENUCLEICACID:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCENUCLEICACID);
//          break;
//        case SUBSTANCEPOLYMER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCEPOLYMER);
//          break;
//        case SUBSTANCEPROTEIN:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCEPROTEIN);
//          break;
//        case SUBSTANCEREFERENCEINFORMATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCEREFERENCEINFORMATION);
//          break;
//        case SUBSTANCESOURCEMATERIAL:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCESOURCEMATERIAL);
//          break;
//        case SUPPLYDELIVERY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUPPLYDELIVERY);
//          break;
//        case SUPPLYREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUPPLYREQUEST);
//          break;
//        case TASK:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.TASK);
//          break;
//        case TERMINOLOGYCAPABILITIES:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.TERMINOLOGYCAPABILITIES);
//          break;
//        case TESTPLAN:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.TESTPLAN);
//          break;
//        case TESTREPORT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.TESTREPORT);
//          break;
//        case TESTSCRIPT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.TESTSCRIPT);
//          break;
//        case TRANSPORT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.TRANSPORT);
//          break;
//        case VALUESET:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.VALUESET);
//          break;
//        case VERIFICATIONRESULT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.VERIFICATIONRESULT);
//          break;
//        case VISIONPRESCRIPTION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.VISIONPRESCRIPTION);
//          break;
//        case BODYSITE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.BODYSITE);
//          break;
//        case CATALOGENTRY:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CATALOGENTRY);
//          break;
//        case CONFORMANCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.CONFORMANCE);
//          break;
//        case DATAELEMENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DATAELEMENT);
//          break;
//        case DEVICECOMPONENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICECOMPONENT);
//          break;
//        case DEVICEUSEREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICEUSEREQUEST);
//          break;
//        case DEVICEUSESTATEMENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DEVICEUSESTATEMENT);
//          break;
//        case DIAGNOSTICORDER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DIAGNOSTICORDER);
//          break;
//        case DOCUMENTMANIFEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.DOCUMENTMANIFEST);
//          break;
//        case EFFECTEVIDENCESYNTHESIS:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.EFFECTEVIDENCESYNTHESIS);
//          break;
//        case ELIGIBILITYREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ELIGIBILITYREQUEST);
//          break;
//        case ELIGIBILITYRESPONSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ELIGIBILITYRESPONSE);
//          break;
//        case EXPANSIONPROFILE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.EXPANSIONPROFILE);
//          break;
//        case IMAGINGMANIFEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.IMAGINGMANIFEST);
//          break;
//        case IMAGINGOBJECTSELECTION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.IMAGINGOBJECTSELECTION);
//          break;
//        case MEDIA:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDIA);
//          break;
//        case MEDICATIONORDER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONORDER);
//          break;
//        case MEDICATIONUSAGE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONUSAGE);
//          break;
//        case MEDICINALPRODUCT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCT);
//          break;
//        case MEDICINALPRODUCTAUTHORIZATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTAUTHORIZATION);
//          break;
//        case MEDICINALPRODUCTCONTRAINDICATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTCONTRAINDICATION);
//          break;
//        case MEDICINALPRODUCTINDICATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTINDICATION);
//          break;
//        case MEDICINALPRODUCTINGREDIENT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTINGREDIENT);
//          break;
//        case MEDICINALPRODUCTINTERACTION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTINTERACTION);
//          break;
//        case MEDICINALPRODUCTMANUFACTURED:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTMANUFACTURED);
//          break;
//        case MEDICINALPRODUCTPACKAGED:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTPACKAGED);
//          break;
//        case MEDICINALPRODUCTPHARMACEUTICAL:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTPHARMACEUTICAL);
//          break;
//        case MEDICINALPRODUCTUNDESIRABLEEFFECT:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTUNDESIRABLEEFFECT);
//          break;
//        case ORDER:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ORDER);
//          break;
//        case ORDERRESPONSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.ORDERRESPONSE);
//          break;
//        case PROCEDUREREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PROCEDUREREQUEST);
//          break;
//        case PROCESSREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PROCESSREQUEST);
//          break;
//        case PROCESSRESPONSE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.PROCESSRESPONSE);
//          break;
//        case REFERRALREQUEST:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.REFERRALREQUEST);
//          break;
//        case REQUESTGROUP:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.REQUESTGROUP);
//          break;
//        case RESEARCHDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.RESEARCHDEFINITION);
//          break;
//        case RESEARCHELEMENTDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.RESEARCHELEMENTDEFINITION);
//          break;
//        case RISKEVIDENCESYNTHESIS:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.RISKEVIDENCESYNTHESIS);
//          break;
//        case SEQUENCE:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SEQUENCE);
//          break;
//        case SERVICEDEFINITION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SERVICEDEFINITION);
//          break;
//        case SUBSTANCESPECIFICATION:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCESPECIFICATION);
//          break;
//        default:
//          tgt.setValue(org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll.NULL);
//          break;
//      }
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll> convertVersionIndependentResourceTypesAll(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.VersionIndependentResourceTypesAll> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAllEnumFactory());
//    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
//    if (src.getValue() == null) {
//      tgt.setValue(null);
//    } else {
//      switch (src.getValue()) {
//        case ACCOUNT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ACCOUNT);
//          break;
//        case ACTIVITYDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ACTIVITYDEFINITION);
//          break;
//        case ACTORDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ACTORDEFINITION);
//          break;
//        case ADMINISTRABLEPRODUCTDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ADMINISTRABLEPRODUCTDEFINITION);
//          break;
//        case ADVERSEEVENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ADVERSEEVENT);
//          break;
//        case ALLERGYINTOLERANCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ALLERGYINTOLERANCE);
//          break;
//        case APPOINTMENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.APPOINTMENT);
//          break;
//        case APPOINTMENTRESPONSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.APPOINTMENTRESPONSE);
//          break;
//        case ARTIFACTASSESSMENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ARTIFACTASSESSMENT);
//          break;
//        case AUDITEVENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.AUDITEVENT);
//          break;
//        case BASIC:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.BASIC);
//          break;
//        case BINARY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.BINARY);
//          break;
//        case BIOLOGICALLYDERIVEDPRODUCT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.BIOLOGICALLYDERIVEDPRODUCT);
//          break;
//        case BIOLOGICALLYDERIVEDPRODUCTDISPENSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.BIOLOGICALLYDERIVEDPRODUCTDISPENSE);
//          break;
//        case BODYSTRUCTURE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.BODYSTRUCTURE);
//          break;
//        case BUNDLE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.BUNDLE);
//          break;
//        case CANONICALRESOURCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CANONICALRESOURCE);
//          break;
//        case CAPABILITYSTATEMENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CAPABILITYSTATEMENT);
//          break;
//        case CAREPLAN:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CAREPLAN);
//          break;
//        case CARETEAM:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CARETEAM);
//          break;
//        case CHARGEITEM:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CHARGEITEM);
//          break;
//        case CHARGEITEMDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CHARGEITEMDEFINITION);
//          break;
//        case CITATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CITATION);
//          break;
//        case CLAIM:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CLAIM);
//          break;
//        case CLAIMRESPONSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CLAIMRESPONSE);
//          break;
//        case CLINICALIMPRESSION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CLINICALIMPRESSION);
//          break;
//        case CLINICALUSEDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CLINICALUSEDEFINITION);
//          break;
//        case CODESYSTEM:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CODESYSTEM);
//          break;
//        case COMMUNICATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.COMMUNICATION);
//          break;
//        case COMMUNICATIONREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.COMMUNICATIONREQUEST);
//          break;
//        case COMPARTMENTDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.COMPARTMENTDEFINITION);
//          break;
//        case COMPOSITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.COMPOSITION);
//          break;
//        case CONCEPTMAP:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CONCEPTMAP);
//          break;
//        case CONDITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CONDITION);
//          break;
//        case CONDITIONDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CONDITIONDEFINITION);
//          break;
//        case CONSENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CONSENT);
//          break;
//        case CONTRACT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CONTRACT);
//          break;
//        case COVERAGE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.COVERAGE);
//          break;
//        case COVERAGEELIGIBILITYREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.COVERAGEELIGIBILITYREQUEST);
//          break;
//        case COVERAGEELIGIBILITYRESPONSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.COVERAGEELIGIBILITYRESPONSE);
//          break;
//        case DETECTEDISSUE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DETECTEDISSUE);
//          break;
//        case DEVICE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICE);
//          break;
//        case DEVICEASSOCIATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICEASSOCIATION);
//          break;
//        case DEVICEDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICEDEFINITION);
//          break;
//        case DEVICEDISPENSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICEDISPENSE);
//          break;
//        case DEVICEMETRIC:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICEMETRIC);
//          break;
//        case DEVICEREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICEREQUEST);
//          break;
//        case DEVICEUSAGE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICEUSAGE);
//          break;
//        case DIAGNOSTICREPORT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DIAGNOSTICREPORT);
//          break;
//        case DOCUMENTREFERENCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DOCUMENTREFERENCE);
//          break;
//        case DOMAINRESOURCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DOMAINRESOURCE);
//          break;
//        case ENCOUNTER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ENCOUNTER);
//          break;
//        case ENCOUNTERHISTORY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ENCOUNTERHISTORY);
//          break;
//        case ENDPOINT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ENDPOINT);
//          break;
//        case ENROLLMENTREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ENROLLMENTREQUEST);
//          break;
//        case ENROLLMENTRESPONSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ENROLLMENTRESPONSE);
//          break;
//        case EPISODEOFCARE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.EPISODEOFCARE);
//          break;
//        case EVENTDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.EVENTDEFINITION);
//          break;
//        case EVIDENCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.EVIDENCE);
//          break;
//        case EVIDENCEREPORT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.EVIDENCEREPORT);
//          break;
//        case EVIDENCEVARIABLE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.EVIDENCEVARIABLE);
//          break;
//        case EXAMPLESCENARIO:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.EXAMPLESCENARIO);
//          break;
//        case EXPLANATIONOFBENEFIT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.EXPLANATIONOFBENEFIT);
//          break;
//        case FAMILYMEMBERHISTORY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.FAMILYMEMBERHISTORY);
//          break;
//        case FLAG:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.FLAG);
//          break;
//        case FORMULARYITEM:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.FORMULARYITEM);
//          break;
//        case GENOMICSTUDY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.GENOMICSTUDY);
//          break;
//        case GOAL:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.GOAL);
//          break;
//        case GRAPHDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.GRAPHDEFINITION);
//          break;
//        case GROUP:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.GROUP);
//          break;
//        case GUIDANCERESPONSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.GUIDANCERESPONSE);
//          break;
//        case HEALTHCARESERVICE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.HEALTHCARESERVICE);
//          break;
//        case IMAGINGSELECTION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.IMAGINGSELECTION);
//          break;
//        case IMAGINGSTUDY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.IMAGINGSTUDY);
//          break;
//        case IMMUNIZATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.IMMUNIZATION);
//          break;
//        case IMMUNIZATIONEVALUATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.IMMUNIZATIONEVALUATION);
//          break;
//        case IMMUNIZATIONRECOMMENDATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.IMMUNIZATIONRECOMMENDATION);
//          break;
//        case IMPLEMENTATIONGUIDE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.IMPLEMENTATIONGUIDE);
//          break;
//        case INGREDIENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.INGREDIENT);
//          break;
//        case INSURANCEPLAN:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.INSURANCEPLAN);
//          break;
//        case INVENTORYITEM:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.INVENTORYITEM);
//          break;
//        case INVENTORYREPORT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.INVENTORYREPORT);
//          break;
//        case INVOICE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.INVOICE);
//          break;
//        case LIBRARY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.LIBRARY);
//          break;
//        case LINKAGE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.LINKAGE);
//          break;
//        case LIST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.LIST);
//          break;
//        case LOCATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.LOCATION);
//          break;
//        case MANUFACTUREDITEMDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MANUFACTUREDITEMDEFINITION);
//          break;
//        case MEASURE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEASURE);
//          break;
//        case MEASUREREPORT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEASUREREPORT);
//          break;
//        case MEDICATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICATION);
//          break;
//        case MEDICATIONADMINISTRATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONADMINISTRATION);
//          break;
//        case MEDICATIONDISPENSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONDISPENSE);
//          break;
//        case MEDICATIONKNOWLEDGE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONKNOWLEDGE);
//          break;
//        case MEDICATIONREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONREQUEST);
//          break;
//        case MEDICATIONSTATEMENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONSTATEMENT);
//          break;
//        case MEDICINALPRODUCTDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTDEFINITION);
//          break;
//        case MESSAGEDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MESSAGEDEFINITION);
//          break;
//        case MESSAGEHEADER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MESSAGEHEADER);
//          break;
//        case METADATARESOURCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.METADATARESOURCE);
//          break;
//        case MOLECULARSEQUENCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MOLECULARSEQUENCE);
//          break;
//        case NAMINGSYSTEM:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.NAMINGSYSTEM);
//          break;
//        case NUTRITIONINTAKE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.NUTRITIONINTAKE);
//          break;
//        case NUTRITIONORDER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.NUTRITIONORDER);
//          break;
//        case NUTRITIONPRODUCT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.NUTRITIONPRODUCT);
//          break;
//        case OBSERVATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.OBSERVATION);
//          break;
//        case OBSERVATIONDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.OBSERVATIONDEFINITION);
//          break;
//        case OPERATIONDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.OPERATIONDEFINITION);
//          break;
//        case OPERATIONOUTCOME:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.OPERATIONOUTCOME);
//          break;
//        case ORGANIZATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ORGANIZATION);
//          break;
//        case ORGANIZATIONAFFILIATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ORGANIZATIONAFFILIATION);
//          break;
//        case PACKAGEDPRODUCTDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PACKAGEDPRODUCTDEFINITION);
//          break;
//        case PARAMETERS:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PARAMETERS);
//          break;
//        case PATIENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PATIENT);
//          break;
//        case PAYMENTNOTICE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PAYMENTNOTICE);
//          break;
//        case PAYMENTRECONCILIATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PAYMENTRECONCILIATION);
//          break;
//        case PERMISSION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PERMISSION);
//          break;
//        case PERSON:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PERSON);
//          break;
//        case PLANDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PLANDEFINITION);
//          break;
//        case PRACTITIONER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PRACTITIONER);
//          break;
//        case PRACTITIONERROLE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PRACTITIONERROLE);
//          break;
//        case PROCEDURE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PROCEDURE);
//          break;
//        case PROVENANCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PROVENANCE);
//          break;
//        case QUESTIONNAIRE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.QUESTIONNAIRE);
//          break;
//        case QUESTIONNAIRERESPONSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.QUESTIONNAIRERESPONSE);
//          break;
//        case REGULATEDAUTHORIZATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.REGULATEDAUTHORIZATION);
//          break;
//        case RELATEDPERSON:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.RELATEDPERSON);
//          break;
//        case REQUESTORCHESTRATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.REQUESTORCHESTRATION);
//          break;
//        case REQUIREMENTS:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.REQUIREMENTS);
//          break;
//        case RESEARCHSTUDY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.RESEARCHSTUDY);
//          break;
//        case RESEARCHSUBJECT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.RESEARCHSUBJECT);
//          break;
//        case RESOURCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.RESOURCE);
//          break;
//        case RISKASSESSMENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.RISKASSESSMENT);
//          break;
//        case SCHEDULE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SCHEDULE);
//          break;
//        case SEARCHPARAMETER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SEARCHPARAMETER);
//          break;
//        case SERVICEREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SERVICEREQUEST);
//          break;
//        case SLOT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SLOT);
//          break;
//        case SPECIMEN:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SPECIMEN);
//          break;
//        case SPECIMENDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SPECIMENDEFINITION);
//          break;
//        case STRUCTUREDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.STRUCTUREDEFINITION);
//          break;
//        case STRUCTUREMAP:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.STRUCTUREMAP);
//          break;
//        case SUBSCRIPTION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSCRIPTION);
//          break;
//        case SUBSCRIPTIONSTATUS:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSCRIPTIONSTATUS);
//          break;
//        case SUBSCRIPTIONTOPIC:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSCRIPTIONTOPIC);
//          break;
//        case SUBSTANCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCE);
//          break;
//        case SUBSTANCEDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCEDEFINITION);
//          break;
//        case SUBSTANCENUCLEICACID:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCENUCLEICACID);
//          break;
//        case SUBSTANCEPOLYMER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCEPOLYMER);
//          break;
//        case SUBSTANCEPROTEIN:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCEPROTEIN);
//          break;
//        case SUBSTANCEREFERENCEINFORMATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCEREFERENCEINFORMATION);
//          break;
//        case SUBSTANCESOURCEMATERIAL:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCESOURCEMATERIAL);
//          break;
//        case SUPPLYDELIVERY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUPPLYDELIVERY);
//          break;
//        case SUPPLYREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUPPLYREQUEST);
//          break;
//        case TASK:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.TASK);
//          break;
//        case TERMINOLOGYCAPABILITIES:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.TERMINOLOGYCAPABILITIES);
//          break;
//        case TESTPLAN:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.TESTPLAN);
//          break;
//        case TESTREPORT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.TESTREPORT);
//          break;
//        case TESTSCRIPT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.TESTSCRIPT);
//          break;
//        case TRANSPORT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.TRANSPORT);
//          break;
//        case VALUESET:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.VALUESET);
//          break;
//        case VERIFICATIONRESULT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.VERIFICATIONRESULT);
//          break;
//        case VISIONPRESCRIPTION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.VISIONPRESCRIPTION);
//          break;
//        case BODYSITE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.BODYSITE);
//          break;
//        case CATALOGENTRY:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CATALOGENTRY);
//          break;
//        case CONFORMANCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.CONFORMANCE);
//          break;
//        case DATAELEMENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DATAELEMENT);
//          break;
//        case DEVICECOMPONENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICECOMPONENT);
//          break;
//        case DEVICEUSEREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICEUSEREQUEST);
//          break;
//        case DEVICEUSESTATEMENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DEVICEUSESTATEMENT);
//          break;
//        case DIAGNOSTICORDER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DIAGNOSTICORDER);
//          break;
//        case DOCUMENTMANIFEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.DOCUMENTMANIFEST);
//          break;
//        case EFFECTEVIDENCESYNTHESIS:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.EFFECTEVIDENCESYNTHESIS);
//          break;
//        case ELIGIBILITYREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ELIGIBILITYREQUEST);
//          break;
//        case ELIGIBILITYRESPONSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ELIGIBILITYRESPONSE);
//          break;
//        case EXPANSIONPROFILE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.EXPANSIONPROFILE);
//          break;
//        case IMAGINGMANIFEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.IMAGINGMANIFEST);
//          break;
//        case IMAGINGOBJECTSELECTION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.IMAGINGOBJECTSELECTION);
//          break;
//        case MEDIA:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDIA);
//          break;
//        case MEDICATIONORDER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONORDER);
//          break;
//        case MEDICATIONUSAGE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICATIONUSAGE);
//          break;
//        case MEDICINALPRODUCT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCT);
//          break;
//        case MEDICINALPRODUCTAUTHORIZATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTAUTHORIZATION);
//          break;
//        case MEDICINALPRODUCTCONTRAINDICATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTCONTRAINDICATION);
//          break;
//        case MEDICINALPRODUCTINDICATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTINDICATION);
//          break;
//        case MEDICINALPRODUCTINGREDIENT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTINGREDIENT);
//          break;
//        case MEDICINALPRODUCTINTERACTION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTINTERACTION);
//          break;
//        case MEDICINALPRODUCTMANUFACTURED:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTMANUFACTURED);
//          break;
//        case MEDICINALPRODUCTPACKAGED:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTPACKAGED);
//          break;
//        case MEDICINALPRODUCTPHARMACEUTICAL:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTPHARMACEUTICAL);
//          break;
//        case MEDICINALPRODUCTUNDESIRABLEEFFECT:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.MEDICINALPRODUCTUNDESIRABLEEFFECT);
//          break;
//        case ORDER:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ORDER);
//          break;
//        case ORDERRESPONSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.ORDERRESPONSE);
//          break;
//        case PROCEDUREREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PROCEDUREREQUEST);
//          break;
//        case PROCESSREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PROCESSREQUEST);
//          break;
//        case PROCESSRESPONSE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.PROCESSRESPONSE);
//          break;
//        case REFERRALREQUEST:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.REFERRALREQUEST);
//          break;
//        case REQUESTGROUP:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.REQUESTGROUP);
//          break;
//        case RESEARCHDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.RESEARCHDEFINITION);
//          break;
//        case RESEARCHELEMENTDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.RESEARCHELEMENTDEFINITION);
//          break;
//        case RISKEVIDENCESYNTHESIS:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.RISKEVIDENCESYNTHESIS);
//          break;
//        case SEQUENCE:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SEQUENCE);
//          break;
//        case SERVICEDEFINITION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SERVICEDEFINITION);
//          break;
//        case SUBSTANCESPECIFICATION:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.SUBSTANCESPECIFICATION);
//          break;
//        default:
//          tgt.setValue(org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll.NULL);
//          break;
//      }
//    }
//    return tgt;
//  }

}
