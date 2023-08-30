package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Range30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.SimpleQuantity30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Instant30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Observation30_50 {

  public static org.hl7.fhir.dstu3.model.Observation convertObservation(org.hl7.fhir.r5.model.Observation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Observation tgt = new org.hl7.fhir.dstu3.model.Observation();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant30_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference30_50.convertReference(t));

    if (src.hasValue()) {
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    }
    
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept30_50.convertCodeableConcept(src.getDataAbsentReason()));
    if (src.hasInterpretation())
      tgt.setInterpretation(CodeableConcept30_50.convertCodeableConcept(src.getInterpretationFirstRep()));
    if (src.hasNote())
      tgt.setComment(src.getNoteFirstRep().getText());
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept30_50.convertCodeableConcept(src.getBodySite()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept30_50.convertCodeableConcept(src.getMethod()));
    if (src.hasSpecimen())
      tgt.setSpecimen(Reference30_50.convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(Reference30_50.convertReference(src.getDevice()));
    for (org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getHasMember())
      tgt.addRelated(convertObservationRelatedComponent(t, org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.HASMEMBER));
    for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom())
      tgt.addRelated(convertObservationRelatedComponent(t, org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.DERIVEDFROM));
    for (org.hl7.fhir.r5.model.Observation.ObservationComponentComponent t : src.getComponent())
      tgt.addComponent(convertObservationComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Observation convertObservation(org.hl7.fhir.dstu3.model.Observation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Observation tgt = new org.hl7.fhir.r5.model.Observation();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant30_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getPerformer())
      tgt.addPerformer(Reference30_50.convertReference(t));

    if (src.hasValue()) {
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    }

    
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept30_50.convertCodeableConcept(src.getDataAbsentReason()));
    if (src.hasInterpretation())
      tgt.addInterpretation(CodeableConcept30_50.convertCodeableConcept(src.getInterpretation()));
    if (src.hasComment())
      tgt.addNote().setText(src.getComment());
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept30_50.convertCodeableConcept(src.getBodySite()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept30_50.convertCodeableConcept(src.getMethod()));
    if (src.hasSpecimen())
      tgt.setSpecimen(Reference30_50.convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(Reference30_50.convertReference(src.getDevice()));
    for (org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    for (org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent t : src.getRelated())
      if (t.getType() == org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.HASMEMBER)
        tgt.addHasMember(Reference30_50.convertReference(t.getTarget()));
      else if (t.getType() == org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.DERIVEDFROM)
        tgt.addDerivedFrom(Reference30_50.convertReference(t.getTarget()));
    for (org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent t : src.getComponent())
      tgt.addComponent(convertObservationComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r5.model.Observation.ObservationComponentComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept30_50.convertCodeableConcept(src.getDataAbsentReason()));
    if (src.hasInterpretation())
      tgt.addInterpretation(CodeableConcept30_50.convertCodeableConcept(src.getInterpretation()));
    for (org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r5.model.Observation.ObservationComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getValue()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept30_50.convertCodeableConcept(src.getDataAbsentReason()));
    if (src.hasInterpretation())
      tgt.setInterpretation(CodeableConcept30_50.convertCodeableConcept(src.getInterpretationFirstRep()));
    for (org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange())
      tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasLow())
      tgt.setLow(SimpleQuantity30_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(SimpleQuantity30_50.convertSimpleQuantity(src.getHigh()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasAge())
      tgt.setAge(Range30_50.convertRange(src.getAge()));
    if (src.hasText())
      tgt.setTextElement(String30_50.convertStringToMarkdown(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r5.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasLow())
      tgt.setLow(SimpleQuantity30_50.convertSimpleQuantity(src.getLow()));
    if (src.hasHigh())
      tgt.setHigh(SimpleQuantity30_50.convertSimpleQuantity(src.getHigh()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAppliesTo())
      tgt.addAppliesTo(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasAge())
      tgt.setAge(Range30_50.convertRange(src.getAge()));
    if (src.hasText())
      tgt.setTextElement(String30_50.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent convertObservationRelatedComponent(org.hl7.fhir.r5.model.Reference src, org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType type) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    tgt.setType(type);
    tgt.setTarget(Reference30_50.convertReference(src));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> convertObservationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Observation.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ObservationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Observation.ObservationStatus> convertObservationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Observation.ObservationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Observation.ObservationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.REGISTERED);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.CORRECTED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.NULL);
        break;
    }
    return tgt;
  }
}