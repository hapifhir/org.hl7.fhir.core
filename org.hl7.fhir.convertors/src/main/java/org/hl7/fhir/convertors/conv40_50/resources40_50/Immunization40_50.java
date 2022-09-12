package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.SimpleQuantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class Immunization40_50 {

  public static org.hl7.fhir.r5.model.Immunization convertImmunization(org.hl7.fhir.r4.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization tgt = new org.hl7.fhir.r5.model.Immunization();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_50.convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept40_50.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOccurrence()));
//    if (src.hasRecorded())
//      tgt.setRecordedElement(DateTime40_50.convertDateTime(src.getRecordedElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean40_50.convertBoolean(src.getPrimarySourceElement()));
    if (src.hasReportOrigin())
      tgt.setInformationSource(new CodeableReference(CodeableConcept40_50.convertCodeableConcept(src.getReportOrigin())));
    if (src.hasLocation())
      tgt.setLocation(Reference40_50.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference40_50.convertReferenceToCodeableReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String40_50.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date40_50.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept40_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept40_50.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_50.convertReferenceToCodeableReference(t));
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(Boolean40_50.convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubpotentReason())
      tgt.addSubpotentReason(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent t : src.getEducation())
//      tgt.addEducation(convertImmunizationEducationComponent(t));
//    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramEligibility())
//      tgt.addProgramEligibility(CodeableConcept40_50.convertCodeableConcept(t));
//    if (src.hasFundingSource())
      tgt.setFundingSource(CodeableConcept40_50.convertCodeableConcept(src.getFundingSource()));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent t : src.getReaction())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent t : src.getProtocolApplied())
      tgt.addProtocolApplied(convertImmunizationProtocolAppliedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization convertImmunization(org.hl7.fhir.r5.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization tgt = new org.hl7.fhir.r4.model.Immunization();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_50.convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept40_50.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOccurrence()));
//    if (src.hasRecorded())
//      tgt.setRecordedElement(DateTime40_50.convertDateTime(src.getRecordedElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean40_50.convertBoolean(src.getPrimarySourceElement()));
    if (src.getInformationSource().hasConcept())
      tgt.setReportOrigin(CodeableConcept40_50.convertCodeableConcept(src.getInformationSource().getConcept()));
    if (src.hasLocation())
      tgt.setLocation(Reference40_50.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference40_50.convertCodeableReferenceToReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String40_50.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date40_50.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept40_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept40_50.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(Boolean40_50.convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubpotentReason())
      tgt.addSubpotentReason(CodeableConcept40_50.convertCodeableConcept(t));
//    for (org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent t : src.getEducation())
//      tgt.addEducation(convertImmunizationEducationComponent(t));
//    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramEligibility())
//      tgt.addProgramEligibility(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasFundingSource())
      tgt.setFundingSource(CodeableConcept40_50.convertCodeableConcept(src.getFundingSource()));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent t : src.getReaction())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent t : src.getProtocolApplied())
      tgt.addProtocolApplied(convertImmunizationProtocolAppliedComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes> convertImmunizationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.ENTEREDINERROR);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.NOTDONE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> convertImmunizationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Immunization.ImmunizationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Immunization.ImmunizationStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.ENTEREDINERROR);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.NOTDONE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasDocumentType())
//      tgt.setDocumentTypeElement(String40_50.convertString(src.getDocumentTypeElement()));
//    if (src.hasReference())
//      tgt.setReferenceElement(Uri40_50.convertUri(src.getReferenceElement()));
//    if (src.hasPublicationDate())
//      tgt.setPublicationDateElement(DateTime40_50.convertDateTime(src.getPublicationDateElement()));
//    if (src.hasPresentationDate())
//      tgt.setPresentationDateElement(DateTime40_50.convertDateTime(src.getPresentationDateElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasDocumentType())
//      tgt.setDocumentTypeElement(String40_50.convertString(src.getDocumentTypeElement()));
//    if (src.hasReference())
//      tgt.setReferenceElement(Uri40_50.convertUri(src.getReferenceElement()));
//    if (src.hasPublicationDate())
//      tgt.setPublicationDateElement(DateTime40_50.convertDateTime(src.getPublicationDateElement()));
//    if (src.hasPresentationDate())
//      tgt.setPresentationDateElement(DateTime40_50.convertDateTime(src.getPresentationDateElement()));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasDetail())
      tgt.setManifestation(new CodeableReference(Reference40_50.convertReference(src.getDetail())));
    if (src.hasReported())
      tgt.setReportedElement(Boolean40_50.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasManifestation())
      tgt.setDetail(Reference40_50.convertReference(src.getManifestation().getReference()));
    if (src.hasReported())
      tgt.setReportedElement(Boolean40_50.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(String40_50.convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference40_50.convertReference(src.getAuthority()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(src.getDoseNumber().primitiveValue());
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(src.getSeriesDoses().primitiveValue());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(String40_50.convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference40_50.convertReference(src.getAuthority()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDoseNumberElement()));
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSeriesDosesElement()));
    return tgt;
  }
}