package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Dosage43_50;
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
public class MedicationStatement43_50 {

  public static org.hl7.fhir.r5.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r4b.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationStatement tgt = new org.hl7.fhir.r5.model.MedicationStatement();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
//    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getStatusReason())
//      tgt.addStatusReason(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasMedicationCodeableConcept()) {
      tgt.getMedication().setConcept(CodeableConcept43_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
    }
    if (src.hasMedicationReference()) {
      tgt.getMedication().setReference(Reference43_50.convertReference(src.getMedicationReference()));
    }
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference43_50.convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime43_50.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.addInformationSource(Reference43_50.convertReference(src.getInformationSource()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage43_50.convertDosage(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r5.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationStatement tgt = new org.hl7.fhir.r4b.model.MedicationStatement();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
//    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
//    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
//    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getStatusReason())
//      tgt.addStatusReason(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.getMedication().hasConcept()) {
      tgt.setMedication(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getMedication().getConcept()));
    }
    if (src.getMedication().hasReference()) {
      tgt.setMedication(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getMedication().getReference()));
    }
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(DateTime43_50.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setInformationSource(Reference43_50.convertReference(src.getInformationSourceFirstRep()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference43_50.convertReference(t));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage43_50.convertDosage(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> convertMedicationStatementStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes> convertMedicationStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
//            case ACTIVE:
//                tgt.setValue(org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes.ACTIVE);
//                break;
      case RECORDED:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes.ENTEREDINERROR);
        break;
//            case UNKNOWN:
//                tgt.setValue(org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes.INTENDED);
//                break;
//            case STOPPED:
//                tgt.setValue(org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes.STOPPED);
//                break;
//            case ONHOLD:
//                tgt.setValue(org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes.ONHOLD);
//                break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes.UNKNOWN);
        break;
//            case NOTTAKEN:
//                tgt.setValue(org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes.NOTTAKEN);
//                break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationStatement.MedicationStatusCodes.NULL);
        break;
    }
    return tgt;
  }
}