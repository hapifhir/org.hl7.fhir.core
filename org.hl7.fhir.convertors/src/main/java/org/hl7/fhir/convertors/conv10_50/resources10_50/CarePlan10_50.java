package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Annotation10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Period10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.dstu2.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class CarePlan10_50 {

  public static org.hl7.fhir.r5.model.CarePlan convertCarePlan(org.hl7.fhir.dstu2.model.CarePlan src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.CarePlan tgt = new org.hl7.fhir.r5.model.CarePlan();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    if (src.hasContext())
      tgt.setEncounter(Reference10_50.convertReference(src.getContext()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor())
      if (!tgt.hasCustodian())
        tgt.setCustodian(Reference10_50.convertReference(t));
      else
        tgt.addContributor(Reference10_50.convertReference(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAddresses())
      tgt.addAddresses(convertReferenceToCodableReference(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getGoal()) tgt.addGoal(Reference10_50.convertReference(t));
    for (org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CarePlan convertCarePlan(org.hl7.fhir.r5.model.CarePlan src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.CarePlan tgt = new org.hl7.fhir.dstu2.model.CarePlan();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    if (src.hasEncounter())
      tgt.setContext(Reference10_50.convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasCustodian())
      tgt.addAuthor(Reference10_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r5.model.Reference t : src.getContributor()) tgt.addAuthor(Reference10_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    for (CodeableReference t : src.getAddresses()) {
      if (t.hasReference()) {
        tgt.addAddresses(Reference10_50.convertReference(t.getReference()));
      }
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) tgt.addGoal(Reference10_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.Annotation t : src.getProgress()) tgt.addProgress(Annotation10_50.convertAnnotation(t));
    if (src.hasPlannedActivityReference())
      tgt.setReference(Reference10_50.convertReference(src.getPlannedActivityReference()));
//    if (src.hasPlannedActivityDetail())
//      tgt.setDetail(convertCarePlanActivityDetailComponent(src.getPlannedActivityDetail()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.Annotation t : src.getProgress())
      tgt.addProgress(Annotation10_50.convertAnnotation(t));
    if (src.hasReference())
      tgt.setPlannedActivityReference(Reference10_50.convertReference(src.getReference()));
//    if (src.hasDetail())
//      tgt.setPlannedActivityDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityPlannedActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.CarePlan.CarePlanActivityPlannedActivityDetailComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityPlannedActivityDetailComponent();
//    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
//    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReasonCode())
//      tgt.addReason(CodeableConcept10_50.convertCodeableConceptToCodableReference(t));
//    for (org.hl7.fhir.dstu2.model.Reference t : src.getReasonReference())
//      tgt.addReason(convertReferenceToCodableReference(t));
//    for (org.hl7.fhir.dstu2.model.Reference t : src.getGoal()) tgt.addGoal(Reference10_50.convertReference(t));
//    if (src.hasStatus())
//      tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
//    if (src.hasProhibitedElement())
//      tgt.setDoNotPerformElement(Boolean10_50.convertBoolean(src.getProhibitedElement()));
//    if (src.hasScheduled())
//      tgt.setScheduled(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getScheduled()));
//    if (src.hasLocation())
//      tgt.getLocation().setReference(Reference10_50.convertReference(src.getLocation()));
//    for (org.hl7.fhir.dstu2.model.Reference t : src.getPerformer())
//      tgt.addPerformer(Reference10_50.convertReference(t));
//    if (src.hasProduct())
//      tgt.setProduct(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getProduct()));
//    if (src.hasDailyAmount())
//      tgt.setDailyAmount(SimpleQuantity10_50.convertSimpleQuantity(src.getDailyAmount()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity10_50.convertSimpleQuantity(src.getQuantity()));
//    if (src.hasDescriptionElement())
//      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityPlannedActivityDetailComponent src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent();
//    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
//    for (CodeableReference t : src.getReason())
//      if (t.hasConcept())
//        tgt.addReasonCode(CodeableConcept10_50.convertCodeableConcept(t.getConcept()));
//    for (CodeableReference t : src.getReason())
//      if (t.hasReference())
//        tgt.addReasonReference(Reference10_50.convertReference(t.getReference()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) tgt.addGoal(Reference10_50.convertReference(t));
//    if (src.hasStatus())
//      tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
//    if (src.hasDoNotPerformElement())
//      tgt.setProhibitedElement(Boolean10_50.convertBoolean(src.getDoNotPerformElement()));
//    if (src.hasScheduled())
//      tgt.setScheduled(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getScheduled()));
//    if (src.getLocation().hasReference())
//      tgt.setLocation(Reference10_50.convertReference(src.getLocation().getReference()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference10_50.convertReference(t));
//    if (src.hasProduct())
//      tgt.setProduct(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getProduct()));
//    if (src.hasDailyAmount())
//      tgt.setDailyAmount(SimpleQuantity10_50.convertSimpleQuantity(src.getDailyAmount()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity10_50.convertSimpleQuantity(src.getQuantity()));
//    if (src.hasDescriptionElement())
//      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatusEnumFactory());
//    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case NOTSTARTED:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
//        break;
//      case SCHEDULED:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
//        break;
//      case INPROGRESS:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
//        break;
//      case ONHOLD:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ONHOLD);
//        break;
//      case COMPLETED:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.COMPLETED);
//        break;
//      case CANCELLED:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.CANCELLED);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatusEnumFactory());
//    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case NOTSTARTED:
//        tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
//        break;
//      case SCHEDULED:
//        tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
//        break;
//      case INPROGRESS:
//        tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
//        break;
//      case ONHOLD:
//        tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.ONHOLD);
//        break;
//      case COMPLETED:
//        tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.COMPLETED);
//        break;
//      case CANCELLED:
//        tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.CANCELLED);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus.NULL);
//        break;
//    }
//    return tgt;
//  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus> convertCarePlanStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
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
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
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
    tgt.setReference(Reference10_50.convertReference(src));
    return tgt;
  }
}