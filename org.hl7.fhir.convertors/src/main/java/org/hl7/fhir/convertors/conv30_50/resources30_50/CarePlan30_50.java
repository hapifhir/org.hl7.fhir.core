package org.hl7.fhir.convertors.conv30_50.resources30_50;

import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.dstu3.model.CarePlan;
import org.hl7.fhir.dstu3.model.Enumeration;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Enumerations;

public class CarePlan30_50 {

  public static org.hl7.fhir.r5.model.CarePlan convertCarePlan(org.hl7.fhir.dstu3.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CarePlan tgt = new org.hl7.fhir.r5.model.CarePlan();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_50.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReplaces()) {
      tgt.addReplaces(Reference30_50.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) {
      tgt.addPartOf(Reference30_50.convertReference(t));
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
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
    }
    if (src.hasTitle()) {
      if (src.hasTitleElement())
        tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    }
    if (src.hasSubject()) {
      if (src.hasSubject())
        tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    }
    if (src.hasContext()) {
      if (src.hasContext())
        tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    }
    if (src.hasPeriod()) {
      if (src.hasPeriod())
        tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    }
    List<Reference> authors = src.getAuthor();
    if (authors.size() > 0) {
      tgt.setCustodian(Reference30_50.convertReference(authors.get(0)));
      if (authors.size() > 1) {
      }
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getCareTeam()) {
      tgt.addCareTeam(Reference30_50.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAddresses()) {
      tgt.addAddresses(Reference30_50.convertReferenceToCodableReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInfo()) {
      tgt.addSupportingInfo(Reference30_50.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getGoal()) {
      tgt.addGoal(Reference30_50.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) {
      tgt.addActivity(convertCarePlanActivityComponent(t));
    }
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_50.convertAnnotation(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CarePlan convertCarePlan(org.hl7.fhir.r5.model.CarePlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CarePlan tgt = new org.hl7.fhir.dstu3.model.CarePlan();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_50.convertReference(t));
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) {
      tgt.addReplaces(Reference30_50.convertReference(t));
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) {
      tgt.addPartOf(Reference30_50.convertReference(t));
    }
    if (src.hasStatus()) {
      if (src.hasStatus())
        tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
    }
    if (src.hasIntent()) {
      if (src.hasIntent())
        tgt.setIntentElement(convertCarePlanIntent(src.getIntentElement()));
    }
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) {
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
    }
    if (src.hasTitle()) {
      if (src.hasTitleElement())
        tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    }
    if (src.hasDescription()) {
      if (src.hasDescriptionElement())
        tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    }
    if (src.hasSubject()) {
      if (src.hasSubject())
        tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    }
    if (src.hasEncounter()) {
      if (src.hasEncounter())
        tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    }
    if (src.hasPeriod()) {
      if (src.hasPeriod())
        tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    }
    if (src.hasCustodian()) {
      tgt.addAuthor(Reference30_50.convertReference(src.getCustodian()));
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getCareTeam()) {
      tgt.addCareTeam(Reference30_50.convertReference(t));
    }
    for (CodeableReference t : src.getAddresses()) {
      if (t.hasReference())
        tgt.addAddresses(Reference30_50.convertReference(t.getReference()));
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo()) {
      tgt.addSupportingInfo(Reference30_50.convertReference(t));
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) {
      tgt.addGoal(Reference30_50.convertReference(t));
    }
    for (org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) {
      tgt.addActivity(convertCarePlanActivityComponent(t));
    }
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_50.convertAnnotation(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (CodeableReference t : src.getPerformedActivity()) {
      if (t.hasConcept())
        tgt.addOutcomeCodeableConcept(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    }
    for (CodeableReference t : src.getPerformedActivity()) {
      if (t.hasReference())
        tgt.addOutcomeReference(Reference30_50.convertReference(t.getReference()));
    }
    for (org.hl7.fhir.r5.model.Annotation t : src.getProgress()) {
      tgt.addProgress(Annotation30_50.convertAnnotation(t));
    }
    if (src.hasPlannedActivityReference()) {
      if (src.hasPlannedActivityReference())
        tgt.setReference(Reference30_50.convertReference(src.getPlannedActivityReference()));
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.dstu3.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getOutcomeCodeableConcept()) {
      tgt.addPerformedActivity(Reference30_50.convertCodeableConceptToCodableReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getOutcomeReference()) {
      tgt.addPerformedActivity(Reference30_50.convertReferenceToCodableReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getProgress()) {
      tgt.addProgress(Annotation30_50.convertAnnotation(t));
    }
    if (src.hasReference()) {
      if (src.hasReference())
        tgt.setPlannedActivityReference(Reference30_50.convertReference(src.getReference()));
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<CarePlan.CarePlanIntent> tgt = new Enumeration<>(new CarePlan.CarePlanIntentEnumFactory());
      ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OPTION:
                  tgt.setValue(CarePlan.CarePlanIntent.OPTION);
                  break;
              case ORDER:
                  tgt.setValue(CarePlan.CarePlanIntent.ORDER);
                  break;
              case PLAN:
                  tgt.setValue(CarePlan.CarePlanIntent.PLAN);
                  break;
              case PROPOSAL:
                  tgt.setValue(CarePlan.CarePlanIntent.PROPOSAL);
                  break;
              default:
                  tgt.setValue(CarePlan.CarePlanIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CarePlan.CarePlanIntentEnumFactory());
      ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OPTION:
                  tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.OPTION);
                  break;
              case ORDER:
                  tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.ORDER);
                  break;
              case PLAN:
                  tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PLAN);
                  break;
              case PROPOSAL:
                  tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PROPOSAL);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus> convertCarePlanStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<CarePlan.CarePlanStatus> tgt = new Enumeration<>(new CarePlan.CarePlanStatusEnumFactory());
      ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(CarePlan.CarePlanStatus.ACTIVE);
                  break;
              case REVOKED:
                  tgt.setValue(CarePlan.CarePlanStatus.CANCELLED);
                  break;
              case COMPLETED:
                  tgt.setValue(CarePlan.CarePlanStatus.COMPLETED);
                  break;
              case DRAFT:
                  tgt.setValue(CarePlan.CarePlanStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(CarePlan.CarePlanStatus.ENTEREDINERROR);
                  break;
              case ONHOLD:
                  tgt.setValue(CarePlan.CarePlanStatus.SUSPENDED);
                  break;
              case UNKNOWN:
                  tgt.setValue(CarePlan.CarePlanStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(CarePlan.CarePlanStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertCarePlanStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CarePlan.CarePlanStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<Enumerations.RequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Enumerations.RequestStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(Enumerations.RequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(Enumerations.RequestStatus.COMPLETED);
                  break;
              case DRAFT:
                  tgt.setValue(Enumerations.RequestStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.RequestStatus.ENTEREDINERROR);
                  break;
              case SUSPENDED:
                  tgt.setValue(Enumerations.RequestStatus.ONHOLD);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.RequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}