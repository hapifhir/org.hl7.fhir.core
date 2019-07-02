package org.hl7.fhir.convertors.conv40_50;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


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


public class Immunization extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Immunization convertImmunization(org.hl7.fhir.r4.model.Immunization src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization tgt = new org.hl7.fhir.r5.model.Immunization();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertImmunizationStatus(src.getStatus()));
    if (src.hasStatusReason())
      tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(convertType(src.getOccurrence()));
    if (src.hasRecorded())
      tgt.setRecordedElement(convertDateTime(src.getRecordedElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(convertBoolean(src.getPrimarySourceElement()));
    if (src.hasReportOrigin())
      tgt.setReportOrigin(convertCodeableConcept(src.getReportOrigin()));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(convertReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubpotentReason())
      tgt.addSubpotentReason(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent t : src.getEducation())
      tgt.addEducation(convertImmunizationEducationComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramEligibility())
      tgt.addProgramEligibility(convertCodeableConcept(t));
    if (src.hasFundingSource())
      tgt.setFundingSource(convertCodeableConcept(src.getFundingSource()));
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
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertImmunizationStatus(src.getStatus()));
    if (src.hasStatusReason())
      tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
    if (src.hasVaccineCode())
      tgt.setVaccineCode(convertCodeableConcept(src.getVaccineCode()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(convertType(src.getOccurrence()));
    if (src.hasRecorded())
      tgt.setRecordedElement(convertDateTime(src.getRecordedElement()));
    if (src.hasPrimarySource())
      tgt.setPrimarySourceElement(convertBoolean(src.getPrimarySourceElement()));
    if (src.hasReportOrigin())
      tgt.setReportOrigin(convertCodeableConcept(src.getReportOrigin()));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasManufacturer())
      tgt.setManufacturer(convertReference(src.getManufacturer()));
    if (src.hasLotNumber())
      tgt.setLotNumberElement(convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(convertDate(src.getExpirationDateElement()));
    if (src.hasSite())
      tgt.setSite(convertCodeableConcept(src.getSite()));
    if (src.hasRoute())
      tgt.setRoute(convertCodeableConcept(src.getRoute()));
    if (src.hasDoseQuantity())
      tgt.setDoseQuantity(convertSimpleQuantity(src.getDoseQuantity()));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImmunizationPerformerComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    if (src.hasIsSubpotent())
      tgt.setIsSubpotentElement(convertBoolean(src.getIsSubpotentElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubpotentReason())
      tgt.addSubpotentReason(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent t : src.getEducation())
      tgt.addEducation(convertImmunizationEducationComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramEligibility())
      tgt.addProgramEligibility(convertCodeableConcept(t));
    if (src.hasFundingSource())
      tgt.setFundingSource(convertCodeableConcept(src.getFundingSource()));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent t : src.getReaction())
      tgt.addReaction(convertImmunizationReactionComponent(t));
    for (org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent t : src.getProtocolApplied())
      tgt.addProtocolApplied(convertImmunizationProtocolAppliedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationStatus convertImmunizationStatus(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case COMPLETED: return org.hl7.fhir.r5.model.Immunization.ImmunizationStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Immunization.ImmunizationStatus.ENTEREDINERROR;
    case NOTDONE: return org.hl7.fhir.r5.model.Immunization.ImmunizationStatus.NOTDONE;
    default: return org.hl7.fhir.r5.model.Immunization.ImmunizationStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationStatus convertImmunizationStatus(org.hl7.fhir.r5.model.Immunization.ImmunizationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case COMPLETED: return org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.ENTEREDINERROR;
    case NOTDONE: return org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.NOTDONE;
    default: return org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent();
    copyElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent convertImmunizationPerformerComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationPerformerComponent();
    copyElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent();
    copyElement(src, tgt);
    if (src.hasDocumentType())
      tgt.setDocumentTypeElement(convertString(src.getDocumentTypeElement()));
    if (src.hasReference())
      tgt.setReferenceElement(convertUri(src.getReferenceElement()));
    if (src.hasPublicationDate())
      tgt.setPublicationDateElement(convertDateTime(src.getPublicationDateElement()));
    if (src.hasPresentationDate())
      tgt.setPresentationDateElement(convertDateTime(src.getPresentationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent convertImmunizationEducationComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationEducationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationEducationComponent();
    copyElement(src, tgt);
    if (src.hasDocumentType())
      tgt.setDocumentTypeElement(convertString(src.getDocumentTypeElement()));
    if (src.hasReference())
      tgt.setReferenceElement(convertUri(src.getReferenceElement()));
    if (src.hasPublicationDate())
      tgt.setPublicationDateElement(convertDateTime(src.getPublicationDateElement()));
    if (src.hasPresentationDate())
      tgt.setPresentationDateElement(convertDateTime(src.getPresentationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent();
    copyElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasDetail())
      tgt.setDetail(convertReference(src.getDetail()));
    if (src.hasReported())
      tgt.setReportedElement(convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationReactionComponent();
    copyElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasDetail())
      tgt.setDetail(convertReference(src.getDetail()));
    if (src.hasReported())
      tgt.setReportedElement(convertBoolean(src.getReportedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent();
    copyElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(convertReference(src.getAuthority()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(convertType(src.getDoseNumber()));
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(convertType(src.getSeriesDoses()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent convertImmunizationProtocolAppliedComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationProtocolAppliedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent tgt = new org.hl7.fhir.r4.model.Immunization.ImmunizationProtocolAppliedComponent();
    copyElement(src, tgt);
    if (src.hasSeries())
      tgt.setSeriesElement(convertString(src.getSeriesElement()));
    if (src.hasAuthority())
      tgt.setAuthority(convertReference(src.getAuthority()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTargetDisease())
      tgt.addTargetDisease(convertCodeableConcept(t));
    if (src.hasDoseNumber())
      tgt.setDoseNumber(convertType(src.getDoseNumber()));
    if (src.hasSeriesDoses())
      tgt.setSeriesDoses(convertType(src.getSeriesDoses()));
    return tgt;
  }


}
