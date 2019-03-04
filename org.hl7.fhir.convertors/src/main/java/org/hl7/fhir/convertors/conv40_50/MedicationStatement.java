package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class MedicationStatement extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r4.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationStatement tgt = new org.hl7.fhir.r5.model.MedicationStatement();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertMedicationStatementStatus(src.getStatus()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getStatusReason())
      tgt.addStatusReason(convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasMedication())
      tgt.setMedication(convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setInformationSource(convertReference(src.getInformationSource()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosage())
      tgt.addDosage(convertDosage(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r5.model.MedicationStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicationStatement tgt = new org.hl7.fhir.r4.model.MedicationStatement();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf())
      tgt.addPartOf(convertReference(t));
    if (src.hasStatus())
      tgt.setStatus(convertMedicationStatementStatus(src.getStatus()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getStatusReason())
      tgt.addStatusReason(convertCodeableConcept(t));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasMedication())
      tgt.setMedication(convertType(src.getMedication()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(convertType(src.getEffective()));
    if (src.hasDateAsserted())
      tgt.setDateAssertedElement(convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setInformationSource(convertReference(src.getInformationSource()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosage())
      tgt.addDosage(convertDosage(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus convertMedicationStatementStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus.ACTIVE;
    case COMPLETED: return org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR;
    case INTENDED: return org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus.INTENDED;
    case STOPPED: return org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus.STOPPED;
    case ONHOLD: return org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus.ONHOLD;
    case UNKNOWN: return org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus.UNKNOWN;
    case NOTTAKEN: return org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN;
    default: return org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus convertMedicationStatementStatus(org.hl7.fhir.r5.model.MedicationStatement.MedicationStatementStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE;
    case COMPLETED: return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR;
    case INTENDED: return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.INTENDED;
    case STOPPED: return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.STOPPED;
    case ONHOLD: return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ONHOLD;
    case UNKNOWN: return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.UNKNOWN;
    case NOTTAKEN: return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NOTTAKEN;
    default: return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NULL;
  }
}


}
