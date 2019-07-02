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


public class Claim extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Claim convertClaim(org.hl7.fhir.r4.model.Claim src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim tgt = new org.hl7.fhir.r5.model.Claim();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertClaimStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUse(convertUse(src.getUse()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r4.model.Claim.RelatedClaimComponent t : src.getRelated())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasPrescription())
      tgt.setPrescription(convertReference(src.getPrescription()));
    if (src.hasOriginalPrescription())
      tgt.setOriginalPrescription(convertReference(src.getOriginalPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(convertReference(src.getFacility()));
    for (org.hl7.fhir.r4.model.Claim.CareTeamComponent t : src.getCareTeam())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.r4.model.Claim.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r4.model.Claim.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4.model.Claim.ProcedureComponent t : src.getProcedure())
      tgt.addProcedure(convertProcedureComponent(t));
    for (org.hl7.fhir.r4.model.Claim.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasAccident())
      tgt.setAccident(convertAccidentComponent(src.getAccident()));
    for (org.hl7.fhir.r4.model.Claim.ItemComponent t : src.getItem())
      tgt.addItem(convertItemComponent(t));
    if (src.hasTotal())
      tgt.setTotal(convertMoney(src.getTotal()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim convertClaim(org.hl7.fhir.r5.model.Claim src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim tgt = new org.hl7.fhir.r4.model.Claim();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertClaimStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUse(convertUse(src.getUse()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r5.model.Claim.RelatedClaimComponent t : src.getRelated())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasPrescription())
      tgt.setPrescription(convertReference(src.getPrescription()));
    if (src.hasOriginalPrescription())
      tgt.setOriginalPrescription(convertReference(src.getOriginalPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(convertReference(src.getFacility()));
    for (org.hl7.fhir.r5.model.Claim.CareTeamComponent t : src.getCareTeam())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.r5.model.Claim.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r5.model.Claim.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r5.model.Claim.ProcedureComponent t : src.getProcedure())
      tgt.addProcedure(convertProcedureComponent(t));
    for (org.hl7.fhir.r5.model.Claim.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasAccident())
      tgt.setAccident(convertAccidentComponent(src.getAccident()));
    for (org.hl7.fhir.r5.model.Claim.ItemComponent t : src.getItem())
      tgt.addItem(convertItemComponent(t));
    if (src.hasTotal())
      tgt.setTotal(convertMoney(src.getTotal()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.ClaimStatus convertClaimStatus(org.hl7.fhir.r4.model.Claim.ClaimStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.Claim.ClaimStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r5.model.Claim.ClaimStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r5.model.Claim.ClaimStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Claim.ClaimStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.Claim.ClaimStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Claim.ClaimStatus convertClaimStatus(org.hl7.fhir.r5.model.Claim.ClaimStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.Claim.ClaimStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r4.model.Claim.ClaimStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r4.model.Claim.ClaimStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Claim.ClaimStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.Claim.ClaimStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Claim.Use convertUse(org.hl7.fhir.r4.model.Claim.Use src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CLAIM: return org.hl7.fhir.r5.model.Claim.Use.CLAIM;
    case PREAUTHORIZATION: return org.hl7.fhir.r5.model.Claim.Use.PREAUTHORIZATION;
    case PREDETERMINATION: return org.hl7.fhir.r5.model.Claim.Use.PREDETERMINATION;
    default: return org.hl7.fhir.r5.model.Claim.Use.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Claim.Use convertUse(org.hl7.fhir.r5.model.Claim.Use src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CLAIM: return org.hl7.fhir.r4.model.Claim.Use.CLAIM;
    case PREAUTHORIZATION: return org.hl7.fhir.r4.model.Claim.Use.PREAUTHORIZATION;
    case PREDETERMINATION: return org.hl7.fhir.r4.model.Claim.Use.PREDETERMINATION;
    default: return org.hl7.fhir.r4.model.Claim.Use.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Claim.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r4.model.Claim.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.RelatedClaimComponent tgt = new org.hl7.fhir.r5.model.Claim.RelatedClaimComponent();
    copyElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r5.model.Claim.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.RelatedClaimComponent tgt = new org.hl7.fhir.r4.model.Claim.RelatedClaimComponent();
    copyElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.PayeeComponent convertPayeeComponent(org.hl7.fhir.r4.model.Claim.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.PayeeComponent tgt = new org.hl7.fhir.r5.model.Claim.PayeeComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.PayeeComponent convertPayeeComponent(org.hl7.fhir.r5.model.Claim.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.PayeeComponent tgt = new org.hl7.fhir.r4.model.Claim.PayeeComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r4.model.Claim.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.CareTeamComponent tgt = new org.hl7.fhir.r5.model.Claim.CareTeamComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasResponsible())
      tgt.setResponsibleElement(convertBoolean(src.getResponsibleElement()));
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasQualification())
      tgt.setQualification(convertCodeableConcept(src.getQualification()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r5.model.Claim.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.CareTeamComponent tgt = new org.hl7.fhir.r4.model.Claim.CareTeamComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasResponsible())
      tgt.setResponsibleElement(convertBoolean(src.getResponsibleElement()));
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasQualification())
      tgt.setQualification(convertCodeableConcept(src.getQualification()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4.model.Claim.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.SupportingInformationComponent tgt = new org.hl7.fhir.r5.model.Claim.SupportingInformationComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r5.model.Claim.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.SupportingInformationComponent tgt = new org.hl7.fhir.r4.model.Claim.SupportingInformationComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.Claim.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.Claim.DiagnosisComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosis())
      tgt.setDiagnosis(convertType(src.getDiagnosis()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(convertCodeableConcept(src.getOnAdmission()));
    if (src.hasPackageCode())
      tgt.setPackageCode(convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.Claim.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.Claim.DiagnosisComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosis())
      tgt.setDiagnosis(convertType(src.getDiagnosis()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(convertCodeableConcept(src.getOnAdmission()));
    if (src.hasPackageCode())
      tgt.setPackageCode(convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r4.model.Claim.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.ProcedureComponent tgt = new org.hl7.fhir.r5.model.Claim.ProcedureComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasProcedure())
      tgt.setProcedure(convertType(src.getProcedure()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi())
      tgt.addUdi(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r5.model.Claim.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.ProcedureComponent tgt = new org.hl7.fhir.r4.model.Claim.ProcedureComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasProcedure())
      tgt.setProcedure(convertType(src.getProcedure()));
    for (org.hl7.fhir.r5.model.Reference t : src.getUdi())
      tgt.addUdi(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.Claim.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.InsuranceComponent tgt = new org.hl7.fhir.r5.model.Claim.InsuranceComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(convertBoolean(src.getFocalElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasCoverage())
      tgt.setCoverage(convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(convertString(src.getBusinessArrangementElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRef().add(convertString(t));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.Claim.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.InsuranceComponent tgt = new org.hl7.fhir.r4.model.Claim.InsuranceComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(convertBoolean(src.getFocalElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasCoverage())
      tgt.setCoverage(convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(convertString(src.getBusinessArrangementElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRef().add(convertString(t));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.AccidentComponent convertAccidentComponent(org.hl7.fhir.r4.model.Claim.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.AccidentComponent tgt = new org.hl7.fhir.r5.model.Claim.AccidentComponent();
    copyElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.AccidentComponent convertAccidentComponent(org.hl7.fhir.r5.model.Claim.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.AccidentComponent tgt = new org.hl7.fhir.r4.model.Claim.AccidentComponent();
    copyElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.ItemComponent convertItemComponent(org.hl7.fhir.r4.model.Claim.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.ItemComponent tgt = new org.hl7.fhir.r5.model.Claim.ItemComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getCareTeamSequence())
      tgt.getCareTeamSequence().add(convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getDiagnosisSequence())
      tgt.getDiagnosisSequence().add(convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getProcedureSequence())
      tgt.getProcedureSequence().add(convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getInformationSequence())
      tgt.getInformationSequence().add(convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi())
      tgt.addUdi(convertReference(t));
    if (src.hasBodySite())
      tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubSite())
      tgt.addSubSite(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEncounter())
      tgt.addEncounter(convertReference(t));
    for (org.hl7.fhir.r4.model.Claim.DetailComponent t : src.getDetail())
      tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.ItemComponent convertItemComponent(org.hl7.fhir.r5.model.Claim.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.ItemComponent tgt = new org.hl7.fhir.r4.model.Claim.ItemComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getCareTeamSequence())
      tgt.getCareTeamSequence().add(convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getDiagnosisSequence())
      tgt.getDiagnosisSequence().add(convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getProcedureSequence())
      tgt.getProcedureSequence().add(convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getInformationSequence())
      tgt.getInformationSequence().add(convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.Reference t : src.getUdi())
      tgt.addUdi(convertReference(t));
    if (src.hasBodySite())
      tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubSite())
      tgt.addSubSite(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEncounter())
      tgt.addEncounter(convertReference(t));
    for (org.hl7.fhir.r5.model.Claim.DetailComponent t : src.getDetail())
      tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.DetailComponent convertDetailComponent(org.hl7.fhir.r4.model.Claim.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.DetailComponent tgt = new org.hl7.fhir.r5.model.Claim.DetailComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi())
      tgt.addUdi(convertReference(t));
    for (org.hl7.fhir.r4.model.Claim.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.DetailComponent convertDetailComponent(org.hl7.fhir.r5.model.Claim.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.DetailComponent tgt = new org.hl7.fhir.r4.model.Claim.DetailComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.Reference t : src.getUdi())
      tgt.addUdi(convertReference(t));
    for (org.hl7.fhir.r5.model.Claim.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4.model.Claim.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.SubDetailComponent tgt = new org.hl7.fhir.r5.model.Claim.SubDetailComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi())
      tgt.addUdi(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r5.model.Claim.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.SubDetailComponent tgt = new org.hl7.fhir.r4.model.Claim.SubDetailComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.Reference t : src.getUdi())
      tgt.addUdi(convertReference(t));
    return tgt;
  }


}
