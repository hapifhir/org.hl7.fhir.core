package org.hl7.fhir.convertors.conv30_50.resources30_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Annotation30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceParticipantComponent;

public class AllergyIntolerance30_50 {

  public static org.hl7.fhir.dstu3.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r5.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AllergyIntolerance tgt = new org.hl7.fhir.dstu3.model.AllergyIntolerance();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(convertAllergyIntoleranceClinicalStatus(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(convertAllergyIntoleranceVerificationStatus(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setTypeElement(convertAllergyIntoleranceType(src.getType()));
    tgt.setCategory(src.getCategory().stream()
      .map(AllergyIntolerance30_50::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setAssertedDateElement(DateTime30_50.convertDateTime(src.getRecordedDateElement()));
    for (AllergyIntoleranceParticipantComponent t : src.getParticipant()) {
      if (t.getFunction().hasCoding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "author"))
        tgt.setRecorder(Reference30_50.convertReference(t.getActor()));
      if (t.getFunction().hasCoding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "attester"))
        tgt.setAsserter(Reference30_50.convertReference(t.getActor()));
    }
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime30_50.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.dstu3.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AllergyIntolerance tgt = new org.hl7.fhir.r5.model.AllergyIntolerance();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(convertAllergyIntoleranceClinicalStatus(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(convertAllergyIntoleranceVerificationStatus(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setType(convertAllergyIntoleranceType(src.getTypeElement()));
    tgt.setCategory(src.getCategory().stream()
      .map(AllergyIntolerance30_50::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getOnset()));
    if (src.hasAssertedDate())
      tgt.setRecordedDateElement(DateTime30_50.convertDateTime(src.getAssertedDateElement()));
    if (src.hasRecorder())
      tgt.addParticipant(new AllergyIntoleranceParticipantComponent()
          .setFunction(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "author", "Author")))
          .setActor(Reference30_50.convertReference(src.getRecorder())));
    if (src.hasAsserter())
      tgt.addParticipant(new AllergyIntoleranceParticipantComponent()
          .setFunction(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "attester", "Attester")))
          .setActor(Reference30_50.convertReference(src.getRecorder())));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime30_50.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    for (org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory> convertAllergyIntoleranceCategory(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<AllergyIntolerance.AllergyIntoleranceCategory> tgt = new Enumeration<>(new AllergyIntolerance.AllergyIntoleranceCategoryEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case FOOD:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceCategory.FOOD);
          break;
        case MEDICATION:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION);
          break;
        case ENVIRONMENT:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT);
          break;
        case BIOLOGIC:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC);
          break;
        default:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceCategory.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory> convertAllergyIntoleranceCategory(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategoryEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case FOOD:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD);
          break;
        case MEDICATION:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION);
          break;
        case ENVIRONMENT:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT);
          break;
        case BIOLOGIC:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus convertAllergyIntoleranceClinicalStatus(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null)
      return null;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "active"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.ACTIVE;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "inactive"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.INACTIVE;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "resolved"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.RESOLVED;
    return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.NULL;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertAllergyIntoleranceClinicalStatus(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case ACTIVE:
        return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical").setCode("active"));
      case INACTIVE:
        return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical").setCode("inactive"));
      case RESOLVED:
        return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical").setCode("resolved"));
      default:
        return null;
    }
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case LOW:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW);
          break;
        case HIGH:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH);
          break;
        case UNABLETOASSESS:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new Enumeration<>(new AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case LOW:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceCriticality.LOW);
          break;
        case HIGH:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceCriticality.HIGH);
          break;
        case UNABLETOASSESS:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS);
          break;
        default:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceCriticality.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept30_50.convertCodeableConcept(src.getSubstance()));
    for (CodeableReference t : src.getManifestation())
      if (t.hasConcept()) tgt.addManifestation(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime30_50.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept30_50.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept30_50.convertCodeableConcept(src.getSubstance()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getManifestation())
      tgt.addManifestation(new CodeableReference(CodeableConcept30_50.convertCodeableConcept(t)));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime30_50.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept30_50.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new Enumeration<>(new AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case MILD:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceSeverity.MILD);
          break;
        case MODERATE:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE);
          break;
        case SEVERE:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE);
          break;
        default:
          tgt.setValue(AllergyIntolerance.AllergyIntoleranceSeverity.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case MILD:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD);
          break;
        case MODERATE:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE);
          break;
        case SEVERE:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType> convertAllergyIntoleranceType(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasCoding("http://hl7.org/fhir/allergy-intolerance-type", "allergy")) {
      tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY);
    } else if (src.hasCoding("http://hl7.org/fhir/allergy-intolerance-type", "intolerance")) {
      tgt.setValue(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE);
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertAllergyIntoleranceType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    CodeableConcept tgt = new CodeableConcept();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      // Add nothing
    } else {
      switch (src.getValue()) {
        case ALLERGY:
          tgt.addCoding("http://hl7.org/fhir/allergy-intolerance-type", "allergy", "Allergy");
          break;
        case INTOLERANCE:
          tgt.addCoding("http://hl7.org/fhir/allergy-intolerance-type", "intolerance", "Intolerance");
          break;
        default:
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertAllergyIntoleranceVerificationStatus(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case UNCONFIRMED:
        return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("unconfirmed"));
      case CONFIRMED:
        return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("confirmed"));
      case REFUTED:
        return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("refuted"));
      case ENTEREDINERROR:
        return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("entered-in-error"));
      default:
        return null;
    }
  }

  static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus convertAllergyIntoleranceVerificationStatus(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null)
      return null;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "unconfirmed"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.UNCONFIRMED;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "confirmed"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.CONFIRMED;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "refuted"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.REFUTED;
    if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "entered-in-error"))
      return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.ENTEREDINERROR;
    return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.NULL;
  }
}