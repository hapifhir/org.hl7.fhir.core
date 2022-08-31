package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
public class Immunization43_50 {

  public static org.hl7.fhir.r5.model.Immunization convertImmunization(org.hl7.fhir.r4b.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization tgt = new org.hl7.fhir.r5.model.Immunization();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept43_50.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
//    if (src.hasRecorded())
//      tgt.setRecordedElement(DateTime43_50.convertDateTime(src.getRecordedElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean43_50.convertBoolean(src.getPrimarySourceElement()));
    if (src.hasReportOrigin())
      tgt.setInformationSource(new CodeableReference(CodeableConcept43_50.convertCodeableConcept(src.getReportOrigin())));
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference43_50.convertReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String43_50.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date43_50.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept43_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept43_50.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(Boolean43_50.convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubpotentReason())
      tgt.addSubpotentReason(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent t : src.getEducation())
      tgt.addEducation(convertImmunizationEducationComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramEligibility())
      tgt.addProgramEligibility(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasFundingSource())
      tgt.setFundingSource(CodeableConcept43_50.convertCodeableConcept(src.getFundingSource()));
    for (org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent t : src.getReaction())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent t : src.getProtocolApplied())
      tgt.addProtocolApplied(convertImmunizationProtocolAppliedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Immunization convertImmunization(org.hl7.fhir.r5.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Immunization tgt = new org.hl7.fhir.r4b.model.Immunization();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept43_50.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
//    if (src.hasRecorded())
//      tgt.setRecordedElement(DateTime43_50.convertDateTime(src.getRecordedElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean43_50.convertBoolean(src.getPrimarySourceElement()));
    if (src.getInformationSource().hasConcept())
      tgt.setReportOrigin(CodeableConcept43_50.convertCodeableConcept(src.getInformationSource().getConcept()));
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference43_50.convertReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String43_50.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date43_50.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept43_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept43_50.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(Boolean43_50.convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubpotentReason())
      tgt.addSubpotentReason(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent t : src.getEducation())
      tgt.addEducation(convertImmunizationEducationComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramEligibility())
      tgt.addProgramEligibility(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasFundingSource())
      tgt.setFundingSource(CodeableConcept43_50.convertCodeableConcept(src.getFundingSource()));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent t : src.getReaction())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent t : src.getProtocolApplied())
      tgt.addProtocolApplied(convertImmunizationProtocolAppliedComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes> convertImmunizationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes> convertImmunizationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes.ENTEREDINERROR);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes.NOTDONE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDocumentType())
      tgt.setDocumentTypeElement(String43_50.convertString(src.getDocumentTypeElement()));
    if (src.hasReference())
      tgt.setReferenceElement(Uri43_50.convertUri(src.getReferenceElement()));
    if (src.hasPublicationDate())
      tgt.setPublicationDateElement(DateTime43_50.convertDateTime(src.getPublicationDateElement()));
    if (src.hasPresentationDate())
      tgt.setPresentationDateElement(DateTime43_50.convertDateTime(src.getPresentationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDocumentType())
      tgt.setDocumentTypeElement(String43_50.convertString(src.getDocumentTypeElement()));
    if (src.hasReference())
      tgt.setReferenceElement(Uri43_50.convertUri(src.getReferenceElement()));
    if (src.hasPublicationDate())
      tgt.setPublicationDateElement(DateTime43_50.convertDateTime(src.getPublicationDateElement()));
    if (src.hasPresentationDate())
      tgt.setPresentationDateElement(DateTime43_50.convertDateTime(src.getPresentationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasDetail())
      tgt.setManifestation(new CodeableReference(Reference43_50.convertReference(src.getDetail())));
    if (src.hasReported())
      tgt.setReportedElement(Boolean43_50.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasManifestation())
      tgt.setDetail(Reference43_50.convertReference(src.getManifestation().getReference()));
    if (src.hasReported())
      tgt.setReportedElement(Boolean43_50.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(String43_50.convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference43_50.convertReference(src.getAuthority()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(src.getDoseNumber().primitiveValue());
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(src.getSeriesDoses().primitiveValue());
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(String43_50.convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference43_50.convertReference(src.getAuthority()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDoseNumberElement()));
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSeriesDosesElement()));
    return tgt;
  }
}