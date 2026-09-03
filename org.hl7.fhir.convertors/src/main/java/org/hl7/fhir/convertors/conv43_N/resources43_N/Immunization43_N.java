package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Date43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Immunization;

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

public class Immunization43_N {

  public static org.hl7.fhir.model.core.Immunization convertImmunization(org.hl7.fhir.r4b.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Immunization tgt = new org.hl7.fhir.model.core.Immunization();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_N.convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept43_N.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurrence()));
//    if (src.hasRecorded())
//      tgt.setRecordedElement(DateTime43_N.convertDateTime(src.getRecordedElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean43_N.convertBoolean(src.getPrimarySourceElement()));
    if (src.hasReportOrigin())
      tgt.setInformationSource(new CodeableReference().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getReportOrigin())));
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference43_N.convertReferenceToCodeableReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String43_N.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date43_N.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept43_N.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept43_N.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(Boolean43_N.convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubpotentReason())
      tgt.addSubpotentReason(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent t : src.getEducation())
//      tgt.addEducation(convertImmunizationEducationComponent(t));
//    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramEligibility())
//      tgt.addProgramEligibility(CodeableConcept43_N.convertCodeableConcept(t));
//    if (src.hasFundingSource())
      tgt.setFundingSource(CodeableConcept43_N.convertCodeableConcept(src.getFundingSource()));
    for (org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent t : src.getReaction())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent t : src.getProtocolApplied())
      tgt.addProtocolApplied(convertImmunizationProtocolAppliedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Immunization convertImmunization(org.hl7.fhir.model.core.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Immunization tgt = new org.hl7.fhir.r4b.model.Immunization();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImmunizationStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_N.convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(CodeableConcept43_N.convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurrence()));
//    if (src.hasRecorded())
//      tgt.setRecordedElement(DateTime43_N.convertDateTime(src.getRecordedElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(Boolean43_N.convertBoolean(src.getPrimarySourceElement()));
    if (src.getInformationSource().hasConcept())
      tgt.setReportOrigin(CodeableConcept43_N.convertCodeableConcept(src.getInformationSource().getConcept()));
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(Reference43_N.convertCodeableReferenceToReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String43_N.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(Date43_N.convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(CodeableConcept43_N.convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(CodeableConcept43_N.convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent t : src.getPerformerList())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(Boolean43_N.convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSubpotentReasonList())
      tgt.addSubpotentReason(CodeableConcept43_N.convertCodeableConcept(t));
//    for (org.hl7.fhir.model.core.Immunization.ImmunizationEducationComponent t : src.getEducationList())
//      tgt.addEducation(convertImmunizationEducationComponent(t));
//    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramEligibilityList())
//      tgt.addProgramEligibility(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasFundingSource())
      tgt.setFundingSource(CodeableConcept43_N.convertCodeableConcept(src.getFundingSource()));
    for (org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent t : src.getReactionList())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent t : src.getProtocolAppliedList())
      tgt.addProtocolApplied(convertImmunizationProtocolAppliedComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Immunization.ImmunizationStatusCodes> convertImmunizationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Immunization.ImmunizationStatusCodes> tgt = new Enumeration<>(new Immunization.ImmunizationStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETED:
                  tgt.setValue(Immunization.ImmunizationStatusCodes.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Immunization.ImmunizationStatusCodes.ENTEREDINERROR);
                  break;
              case NOTDONE:
                  tgt.setValue(Immunization.ImmunizationStatusCodes.NOTDONE);
                  break;
              default:
                  tgt.setValue(Immunization.ImmunizationStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes> convertImmunizationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Immunization.ImmunizationStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Immunization.ImmunizationStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.model.core.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r4b.model.Immunization.ImmunizationPerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    return tgt;
  }

//  public static org.hl7.fhir.model.core.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.model.core.Immunization.ImmunizationEducationComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasDocumentType())
//      tgt.setDocumentTypeElement(String43_N.convertString(src.getDocumentTypeElement()));
//    if (src.hasReference())
//      tgt.setReferenceElement(Uri43_N.convertUri(src.getReferenceElement()));
//    if (src.hasPublicationDate())
//      tgt.setPublicationDateElement(DateTime43_N.convertDateTime(src.getPublicationDateElement()));
//    if (src.hasPresentationDate())
//      tgt.setPresentationDateElement(DateTime43_N.convertDateTime(src.getPresentationDateElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.model.core.Immunization.ImmunizationEducationComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.r4b.model.Immunization.ImmunizationEducationComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasDocumentType())
//      tgt.setDocumentTypeElement(String43_N.convertString(src.getDocumentTypeElement()));
//    if (src.hasReference())
//      tgt.setReferenceElement(Uri43_N.convertUri(src.getReferenceElement()));
//    if (src.hasPublicationDate())
//      tgt.setPublicationDateElement(DateTime43_N.convertDateTime(src.getPublicationDateElement()));
//    if (src.hasPresentationDate())
//      tgt.setPresentationDateElement(DateTime43_N.convertDateTime(src.getPresentationDateElement()));
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasDetail())
      tgt.setManifestation(new CodeableReference().setReference(Reference43_N.convertReference(src.getDetail())));
    if (src.hasReported())
      tgt.setReportedElement(Boolean43_N.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.model.core.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.r4b.model.Immunization.ImmunizationReactionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasManifestation())
      tgt.setDetail(Reference43_N.convertReference(src.getManifestation().getReference()));
    if (src.hasReported())
      tgt.setReportedElement(Boolean43_N.convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(String43_N.convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference43_N.convertReference(src.getAuthority()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(new org.hl7.fhir.model.core.CodeableConcept().setText(src.getDoseNumber().primitiveValue()));
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(new org.hl7.fhir.model.core.CodeableConcept().setText(src.getSeriesDoses().primitiveValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.model.core.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r4b.model.Immunization.ImmunizationProtocolAppliedComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(String43_N.convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(Reference43_N.convertReference(src.getAuthority()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTargetDiseaseList())
      tgt.addTargetDisease(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDoseNumber().getTextElement()));
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSeriesDoses().getTextElement()));
    return tgt;
  }
}