package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Dosage40_50;
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
public class MedicationStatement40_50 {

  public static org.hl7.fhir.r5.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r4.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationStatement tgt = new org.hl7.fhir.r5.model.MedicationStatement();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
//    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
//    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
//    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getStatusReason())
//      tgt.addStatusReason(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasMedicationCodeableConcept()) {
      tgt.getMedication().setConcept(CodeableConcept40_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
    }
    if (src.hasMedicationReference()) {
      tgt.getMedication().setReference(Reference40_50.convertReference(src.getMedicationReference()));
    }
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference40_50.convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime40_50.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.addInformationSource(Reference40_50.convertReference(src.getInformationSource()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage40_50.convertDosage(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r5.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationStatement tgt = new org.hl7.fhir.r4.model.MedicationStatement();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
//    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
//    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
//    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getStatusReason())
//      tgt.addStatusReason(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.getMedication().hasConcept()) {
      tgt.setMedication(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMedication().getConcept()));
    }
    if (src.getMedication().hasReference()) {
      tgt.setMedication(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getMedication().getReference()));
    }
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime40_50.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setInformationSource(Reference40_50.convertReference(src.getInformationSourceFirstRep()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference40_50.convertReference(t));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage40_50.convertDosage(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> convertMedicationStatementStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.ENTEREDINERROR);
        break;
      case INTENDED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      case NOTTAKEN:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.RECORDED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
//            case ACTIVE:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
//                break;
      case RECORDED:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
        break;
//            case UNKNOWN:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.INTENDED);
//                break;
//            case STOPPED:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.STOPPED);
//                break;
//            case ONHOLD:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ONHOLD);
//                break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.UNKNOWN);
        break;
//            case NOTTAKEN:
//                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN);
//                break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NULL);
        break;
    }
    return tgt;
  }
}