package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Coding;

import java.util.List;

public class CarePlan30_40 {

  private static final String CarePlanActivityDetailComponentExtension = "http://hl7.org/fhir/3.0/StructureDefinition/extension-CarePlan.activity.detail.category";

  public static org.hl7.fhir.dstu3.model.CarePlan convertCarePlan(org.hl7.fhir.r4.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CarePlan tgt = new org.hl7.fhir.dstu3.model.CarePlan();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) {
      tgt.addReplaces(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) {
      tgt.addPartOf(Reference30_40.convertReference(t));
    }
    if (src.hasStatus()) {
      if (src.hasStatus())
        tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    }
    if (src.hasIntent()) {
      if (src.hasIntent())
        tgt.setIntentElement(convertCarePlanIntent(src.getIntentElement()));
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) {
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    }
    if (src.hasTitle()) {
      if (src.hasTitleElement())
        tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    }
    if (src.hasSubject()) {
      if (src.hasSubject())
        tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    }
    if (src.hasEncounter()) {
      if (src.hasEncounter())
        tgt.setContext(Reference30_40.convertReference(src.getEncounter()));
    }
    if (src.hasPeriod()) {
      if (src.hasPeriod())
        tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    }
    if (src.hasAuthor()) {
      if (src.hasAuthor())
        tgt.addAuthor(Reference30_40.convertReference(src.getAuthor()));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getCareTeam()) {
      tgt.addCareTeam(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getAddresses()) {
      tgt.addAddresses(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo()) {
      tgt.addSupportingInfo(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getGoal()) {
      tgt.addGoal(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) {
      tgt.addActivity(convertCarePlanActivityComponent(t));
    }
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan convertCarePlan(org.hl7.fhir.dstu3.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CarePlan tgt = new org.hl7.fhir.r4.model.CarePlan();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReplaces()) {
      tgt.addReplaces(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) {
      tgt.addPartOf(Reference30_40.convertReference(t));
    }
    if (src.hasStatus()) {
      if (src.hasStatus())
        tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    }
    if (src.hasIntent()) {
      if (src.hasIntent())
        tgt.setIntentElement(convertCarePlanIntent(src.getIntentElement()));
    }
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) {
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    }
    if (src.hasTitle()) {
      if (src.hasTitleElement())
        tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    }
    if (src.hasSubject()) {
      if (src.hasSubject())
        tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    }
    if (src.hasContext()) {
      if (src.hasContext())
        tgt.setEncounter(Reference30_40.convertReference(src.getContext()));
    }
    if (src.hasPeriod()) {
      if (src.hasPeriod())
        tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    }
    List<Reference> authors = src.getAuthor();
    if (authors.size() > 0) {
      tgt.setAuthor(Reference30_40.convertReference(authors.get(0)));
      if (authors.size() > 1) {
      }
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getCareTeam()) {
      tgt.addCareTeam(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAddresses()) {
      tgt.addAddresses(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInfo()) {
      tgt.addSupportingInfo(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getGoal()) {
      tgt.addGoal(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) {
      tgt.addActivity(convertCarePlanActivityComponent(t));
    }
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getOutcomeCodeableConcept()) {
      tgt.addOutcomeCodeableConcept(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getOutcomeReference()) {
      tgt.addOutcomeReference(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getProgress()) {
      tgt.addProgress(Annotation30_40.convertAnnotation(t));
    }
    if (src.hasReference()) {
      if (src.hasReference())
        tgt.setReference(Reference30_40.convertReference(src.getReference()));
    }
    if (src.hasDetail()) {
      if (src.hasDetail())
        tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOutcomeCodeableConcept()) {
      tgt.addOutcomeCodeableConcept(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getOutcomeReference()) {
      tgt.addOutcomeReference(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Annotation t : src.getProgress()) {
      tgt.addProgress(Annotation30_40.convertAnnotation(t));
    }
    if (src.hasReference()) {
      if (src.hasReference())
        tgt.setReference(Reference30_40.convertReference(src.getReference()));
    }
    if (src.hasDetail()) {
      if (src.hasDetail())
        tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasCategory()) {
      org.hl7.fhir.r4.model.Extension t = new org.hl7.fhir.r4.model.Extension();
      t.setUrl(CarePlanActivityDetailComponentExtension);
      t.setValue(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getCategory()));
      tgt.addExtension(t);
    }
    if (src.hasCode()) {
      if (src.hasCode())
        tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    }
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) {
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) {
      tgt.addReasonReference(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getGoal()) {
      tgt.addGoal(Reference30_40.convertReference(t));
    }
    if (src.hasStatus()) {
      if (src.hasStatus())
        tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
    }
    if (src.hasStatusReason()) {
      org.hl7.fhir.r4.model.Coding code = new org.hl7.fhir.r4.model.Coding();
      code.setCode(src.getStatusReason());
      org.hl7.fhir.r4.model.CodeableConcept t = new org.hl7.fhir.r4.model.CodeableConcept(code);
      tgt.setStatusReason(t);
    }
    if (src.hasProhibited()) {
      if (src.hasProhibitedElement())
        tgt.setDoNotPerformElement(Boolean30_40.convertBoolean(src.getProhibitedElement()));
    }
    if (src.hasScheduled()) {
      if (src.hasScheduled())
        tgt.setScheduled(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getScheduled()));
    }
    if (src.hasLocation()) {
      if (src.hasLocation())
        tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPerformer()) {
      tgt.addPerformer(Reference30_40.convertReference(t));
    }
    if (src.hasProduct()) {
      if (src.hasProduct())
        tgt.setProduct(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getProduct()));
    }
    if (src.hasDailyAmount()) {
      if (src.hasDailyAmount())
        tgt.setDailyAmount(SimpleQuantity30_40.convertSimpleQuantity(src.getDailyAmount()));
    }
    if (src.hasQuantity()) {
      if (src.hasQuantity())
        tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityDetailComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasExtension()) {
      org.hl7.fhir.r4.model.Extension extension = src.getExtensionByUrl(CarePlanActivityDetailComponentExtension);
      if (extension != null) {
        org.hl7.fhir.r4.model.Type value = extension.getValue();
        if (value instanceof org.hl7.fhir.r4.model.CodeableConcept) {
          tgt.setCategory(CodeableConcept30_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) value));
        }
      }
    }
    if (src.hasCode()) {
      if (src.hasCode())
        tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) {
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) {
      tgt.addReasonReference(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getGoal()) {
      tgt.addGoal(Reference30_40.convertReference(t));
    }
    if (src.hasStatus()) {
      if (src.hasStatus())
        tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
    }
    if (src.hasStatusReason()) {
      List<Coding> coding = src.getStatusReason().getCoding();
      if (coding.size() > 0) {
        tgt.setStatusReason(coding.get(0).getCode());
      }
    }
    if (src.hasDoNotPerform()) {
      if (src.hasDoNotPerformElement())
        tgt.setProhibitedElement(Boolean30_40.convertBoolean(src.getDoNotPerformElement()));
    }
    if (src.hasScheduled()) {
      if (src.hasScheduled())
        tgt.setScheduled(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getScheduled()));
    }
    if (src.hasLocation()) {
      if (src.hasLocation())
        tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) {
      tgt.addPerformer(Reference30_40.convertReference(t));
    }
    if (src.hasProduct()) {
      if (src.hasProduct())
        tgt.setProduct(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getProduct()));
    }
    if (src.hasDailyAmount()) {
      if (src.hasDailyAmount())
        tgt.setDailyAmount(SimpleQuantity30_40.convertSimpleQuantity(src.getDailyAmount()));
    }
    if (src.hasQuantity()) {
      if (src.hasQuantity())
        tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.COMPLETED);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
        break;
      case NOTSTARTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.ONHOLD);
        break;
      case SCHEDULED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.COMPLETED);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
        break;
      case NOTSTARTED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.ONHOLD);
        break;
      case SCHEDULED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanIntentEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case OPTION:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.OPTION);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.ORDER);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.PLAN);
        break;
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.PROPOSAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntentEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case OPTION:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.OPTION);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.ORDER);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.PLAN);
        break;
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.PROPOSAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus> convertCarePlanStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.ACTIVE);
        break;
      case REVOKED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.COMPLETED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.ENTEREDINERROR);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.SUSPENDED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> convertCarePlanStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.REVOKED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.COMPLETED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ENTEREDINERROR);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ONHOLD);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.NULL);
        break;
    }
    return tgt;
  }
}