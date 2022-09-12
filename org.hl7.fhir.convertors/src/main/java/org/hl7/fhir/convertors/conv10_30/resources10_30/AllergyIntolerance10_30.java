package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Annotation10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.dstu2.model.AllergyIntolerance;
import org.hl7.fhir.exceptions.FHIRException;

public class AllergyIntolerance10_30 {
  public static org.hl7.fhir.dstu3.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.dstu2.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AllergyIntolerance tgt = new org.hl7.fhir.dstu3.model.AllergyIntolerance();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier identifier : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(identifier));
    if (src.hasOnset())
      tgt.setOnset(DateTime10_30.convertDateTime(src.getOnsetElement()));
    if (src.hasRecordedDate())
      tgt.setAssertedDateElement(DateTime10_30.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference10_30.convertReference(src.getRecorder()));
    if (src.hasPatient())
      tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
    if (src.hasReporter())
      tgt.setAsserter(Reference10_30.convertReference(src.getReporter()));
    if (src.hasSubstance())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getSubstance()));
    if (src.hasStatus()) {
      if (src.getStatus() != org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus.REFUTED
        && src.getStatus() != org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus.ENTEREDINERROR) {
        tgt.setClinicalStatus(translateAllergyIntoleranceClinicalStatus(src.getStatus()));
      }
      if (src.getStatus() != org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus.ACTIVE
        && src.getStatus() != org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus.RESOLVED) {
        tgt.setVerificationStatus(translateAllergyIntoleranceVerificationStatus(src.getStatus()));
      }
    }
    if (src.hasCriticality())
      tgt.setCriticality(translateAllergyIntoleranceCriticality(src.getCriticality()));
    if (src.hasType())
      tgt.setType(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType.fromCode(src.getType().toCode()));
    if (src.hasCategory())
      tgt.addCategory(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.fromCode(src.getCategory().toCode()));
    if (src.hasLastOccurence())
      tgt.setLastOccurrenceElement(DateTime10_30.convertDateTime(src.getLastOccurenceElement()));
    if (src.hasNote())
      tgt.addNote(Annotation10_30.convertAnnotation(src.getNote()));
    for (org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceReactionComponent reaction : src.getReaction())
      tgt.addReaction(algReaction(reaction));
    return tgt;
  }

  private static org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent algReaction(AllergyIntolerance.AllergyIntoleranceReactionComponent src) {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept10_30.convertCodeableConcept(src.getSubstance()));
    if (src.hasCertainty())
      tgt.addExtension(new org.hl7.fhir.dstu3.model.Extension(
        "http://hl7.org/fhir/AllergyIntolerance-r2-certainty",
        new org.hl7.fhir.dstu3.model.StringType(src.getCertainty().toCode())
      ));
    for (org.hl7.fhir.dstu2.model.CodeableConcept concept : src.getManifestation())
      tgt.addManifestation(CodeableConcept10_30.convertCodeableConcept(concept));
    if (src.hasDescription())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime10_30.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverity(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.fromCode(src.getSeverity().toCode()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept10_30.convertCodeableConcept(src.getExposureRoute()));
    if (src.hasNote())
      tgt.addNote(Annotation10_30.convertAnnotation(src.getNote()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus translateAllergyIntoleranceVerificationStatus(org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus src) {
    switch (src) {
      case UNCONFIRMED:
      case INACTIVE:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.UNCONFIRMED;
      case CONFIRMED:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.CONFIRMED;
      case REFUTED:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.REFUTED;
      case ENTEREDINERROR:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.ENTEREDINERROR;
      default:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.NULL;
    }
  }

  public static org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus translateAllergyIntoleranceClinicalStatus(org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus src) {
    switch (src) {
      case ACTIVE:
      case UNCONFIRMED:
      case CONFIRMED:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.ACTIVE;
      case INACTIVE:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.INACTIVE;
      case RESOLVED:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.RESOLVED;
      default:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.NULL;
    }
  }

  public static org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality translateAllergyIntoleranceCriticality(org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceCriticality src) {
    switch (src) {
      case CRITL:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW;
      case CRITH:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH;
      case CRITU:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS;
      default:
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL;
    }
  }

}
