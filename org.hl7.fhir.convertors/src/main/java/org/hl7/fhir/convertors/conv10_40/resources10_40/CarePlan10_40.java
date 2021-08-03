package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Type10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.*;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class CarePlan10_40 {

  public static org.hl7.fhir.r4.model.CarePlan convertCarePlan(org.hl7.fhir.dstu2.model.CarePlan src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.CarePlan tgt = new org.hl7.fhir.r4.model.CarePlan();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    if (src.hasContext())
      tgt.setEncounter(Reference10_40.convertReference(src.getContext()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor())
      if (!tgt.hasAuthor())
        tgt.setAuthor(Reference10_40.convertReference(t));
      else
        tgt.addContributor(Reference10_40.convertReference(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAddresses())
      tgt.addAddresses(Reference10_40.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getGoal()) tgt.addGoal(Reference10_40.convertReference(t));
    for (org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CarePlan convertCarePlan(org.hl7.fhir.r4.model.CarePlan src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.CarePlan tgt = new org.hl7.fhir.dstu2.model.CarePlan();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    if (src.hasEncounter())
      tgt.setContext(Reference10_40.convertReference(src.getEncounter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasAuthor())
      tgt.addAuthor(Reference10_40.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4.model.Reference t : src.getContributor()) tgt.addAuthor(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAddresses()) tgt.addAddresses(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getGoal()) tgt.addGoal(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent t : src.getActivity())
      tgt.addActivity(convertCarePlanActivityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.Annotation t : src.getProgress())
      tgt.addProgress(Annotation10_40.convertAnnotation(t));
    if (src.hasReference())
      tgt.setReference(Reference10_40.convertReference(src.getReference()));
    if (src.hasDetail())
      tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Annotation t : src.getProgress()) tgt.addProgress(Annotation10_40.convertAnnotation(t));
    if (src.hasReference())
      tgt.setReference(Reference10_40.convertReference(src.getReference()));
    if (src.hasDetail())
      tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(Reference10_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getGoal()) tgt.addGoal(Reference10_40.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
    if (src.hasDoNotPerformElement())
      tgt.setProhibitedElement(Boolean10_40.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasScheduled())
      tgt.setScheduled(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getScheduled()));
    if (src.hasLocation())
      tgt.setLocation(Reference10_40.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference10_40.convertReference(t));
    if (src.hasProduct())
      tgt.setProduct(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getProduct()));
    if (src.hasDailyAmount())
      tgt.setDailyAmount(SimpleQuantity10_40.convertSimpleQuantity(src.getDailyAmount()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_40.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(CodeableConcept10_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(Reference10_40.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getGoal()) tgt.addGoal(Reference10_40.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
    if (src.hasProhibitedElement())
      tgt.setDoNotPerformElement(Boolean10_40.convertBoolean(src.getProhibitedElement()));
    if (src.hasScheduled())
      tgt.setScheduled(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getScheduled()));
    if (src.hasLocation())
      tgt.setLocation(Reference10_40.convertReference(src.getLocation()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getPerformer())
      tgt.addPerformer(Reference10_40.convertReference(t));
    if (src.hasProduct())
      tgt.setProduct(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getProduct()));
    if (src.hasDailyAmount())
      tgt.setDailyAmount(SimpleQuantity10_40.convertSimpleQuantity(src.getDailyAmount()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity10_40.convertSimpleQuantity(src.getQuantity()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case NOTSTARTED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
        break;
      case SCHEDULED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.ONHOLD);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.COMPLETED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.CANCELLED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.CarePlan.CarePlanActivityStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> convertCarePlanStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.DRAFT);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ACTIVE);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.COMPLETED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.REVOKED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus> convertCarePlanStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.CarePlan.CarePlanStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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
}