package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Money40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.r4.model.Claim;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class Claim40_N {

  public static org.hl7.fhir.model.core.Claim convertClaim(org.hl7.fhir.r4.model.Claim src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim tgt = new org.hl7.fhir.model.core.Claim();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept40_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference40_N.convertReference(src.getPatient()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(Period40_N.convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference40_N.convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_N.convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_N.convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept40_N.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r4.model.Claim.RelatedClaimComponent t : src.getRelated())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasPrescription())
      tgt.setRequest(Reference40_N.convertReference(src.getPrescription()));
    if (src.hasOriginalPrescription())
      tgt.setOriginalPrescription(Reference40_N.convertReference(src.getOriginalPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference40_N.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference40_N.convertReference(src.getFacility()));
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
    for (org.hl7.fhir.r4.model.Claim.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
    if (src.hasTotal())
      tgt.setTotal(Money40_N.convertMoney(src.getTotal()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim convertClaim(org.hl7.fhir.model.core.Claim src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim tgt = new org.hl7.fhir.r4.model.Claim();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept40_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasSubject())
      tgt.setPatient(Reference40_N.convertReference(src.getSubject()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(Period40_N.convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference40_N.convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_N.convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_N.convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept40_N.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.model.core.Claim.RelatedClaimComponent t : src.getRelatedList())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasRequest())
      tgt.setPrescription(Reference40_N.convertReference(src.getRequest()));
    if (src.hasOriginalPrescription())
      tgt.setOriginalPrescription(Reference40_N.convertReference(src.getOriginalPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference40_N.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference40_N.convertReference(src.getFacility()));
    for (org.hl7.fhir.model.core.Claim.CareTeamComponent t : src.getCareTeamList())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.model.core.Claim.SupportingInformationComponent t : src.getSupportingInfoList())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.model.core.Claim.DiagnosisComponent t : src.getDiagnosisList())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.model.core.Claim.ProcedureComponent t : src.getProcedureList())
      tgt.addProcedure(convertProcedureComponent(t));
    for (org.hl7.fhir.model.core.Claim.InsuranceComponent t : src.getInsuranceList())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasAccident())
      tgt.setAccident(convertAccidentComponent(src.getAccident()));
    for (org.hl7.fhir.model.core.Claim.ItemComponent t : src.getItemList()) tgt.addItem(convertItemComponent(t));
    if (src.hasTotal())
      tgt.setTotal(Money40_N.convertMoney(src.getTotal()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertClaimStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Claim.ClaimStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FinancialResourceStatusCodes> tgt = new Enumeration<>(new Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Claim.ClaimStatus> convertClaimStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Claim.ClaimStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Claim.ClaimStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Claim.ClaimStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(Claim.ClaimStatus.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(Claim.ClaimStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Claim.ClaimStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Claim.ClaimStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> convertUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Claim.Use> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.Use> tgt = new Enumeration<>(new Enumerations.UseEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CLAIM:
                  tgt.setValue(Enumerations.Use.CLAIM);
                  break;
              case PREAUTHORIZATION:
                  tgt.setValue(Enumerations.Use.PREAUTHORIZATION);
                  break;
              case PREDETERMINATION:
                  tgt.setValue(Enumerations.Use.PREDETERMINATION);
                  break;
              default:
                  tgt.setValue(Enumerations.Use.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Claim.Use> convertUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Claim.Use> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Claim.UseEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CLAIM:
                  tgt.setValue(Claim.Use.CLAIM);
                  break;
              case PREAUTHORIZATION:
                  tgt.setValue(Claim.Use.PREAUTHORIZATION);
                  break;
              case PREDETERMINATION:
                  tgt.setValue(Claim.Use.PREDETERMINATION);
                  break;
              default:
                  tgt.setValue(Claim.Use.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r4.model.Claim.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.RelatedClaimComponent tgt = new org.hl7.fhir.model.core.Claim.RelatedClaimComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference40_N.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier40_N.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.model.core.Claim.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.RelatedClaimComponent tgt = new org.hl7.fhir.r4.model.Claim.RelatedClaimComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference40_N.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier40_N.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.PayeeComponent convertPayeeComponent(org.hl7.fhir.r4.model.Claim.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.PayeeComponent tgt = new org.hl7.fhir.model.core.Claim.PayeeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference40_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.PayeeComponent convertPayeeComponent(org.hl7.fhir.model.core.Claim.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.PayeeComponent tgt = new org.hl7.fhir.r4.model.Claim.PayeeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference40_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r4.model.Claim.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.CareTeamComponent tgt = new org.hl7.fhir.model.core.Claim.CareTeamComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_N.convertReference(src.getProvider()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasQualification())
      tgt.setSpecialty(CodeableConcept40_N.convertCodeableConcept(src.getQualification()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.model.core.Claim.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.CareTeamComponent tgt = new org.hl7.fhir.r4.model.Claim.CareTeamComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_N.convertReference(src.getProvider()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasSpecialty())
      tgt.setQualification(CodeableConcept40_N.convertCodeableConcept(src.getSpecialty()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4.model.Claim.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.SupportingInformationComponent tgt = new org.hl7.fhir.model.core.Claim.SupportingInformationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_N.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.model.core.Claim.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.SupportingInformationComponent tgt = new org.hl7.fhir.r4.model.Claim.SupportingInformationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept40_N.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.Claim.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.DiagnosisComponent tgt = new org.hl7.fhir.model.core.Claim.DiagnosisComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosisCodeableConcept())
      tgt.getDiagnosis().setConcept(CodeableConcept40_N.convertCodeableConcept(src.getDiagnosisCodeableConcept()));
    if (src.hasDiagnosisReference())
      tgt.getDiagnosis().setReference(Reference40_N.convertReference(src.getDiagnosisReference()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(CodeableConcept40_N.convertCodeableConcept(src.getOnAdmission()));
//    if (src.hasPackageCode())
//      tgt.setPackageCode(CodeableConcept40_N.convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.model.core.Claim.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.Claim.DiagnosisComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosis())
      tgt.setDiagnosis(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDiagnosis()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(CodeableConcept40_N.convertCodeableConcept(src.getOnAdmission()));
//    if (src.hasPackageCode())
//      tgt.setPackageCode(CodeableConcept40_N.convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r4.model.Claim.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.ProcedureComponent tgt = new org.hl7.fhir.model.core.Claim.ProcedureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasProcedureReference())
      tgt.getProcedure().setReference(Reference40_N.convertReference(src.getProcedureReference()));
    if (src.hasProcedureCodeableConcept())
      tgt.getProcedure().setConcept(CodeableConcept40_N.convertCodeableConcept(src.getProcedureCodeableConcept()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.ProcedureComponent convertProcedureComponent(org.hl7.fhir.model.core.Claim.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.ProcedureComponent tgt = new org.hl7.fhir.r4.model.Claim.ProcedureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasProcedure())
      tgt.setProcedure(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProcedure()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.Claim.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.InsuranceComponent tgt = new org.hl7.fhir.model.core.Claim.InsuranceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_N.convertBoolean(src.getFocalElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String40_N.convertString(src.getBusinessArrangementElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRefList().add(String40_N.convertString(t));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference40_N.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.model.core.Claim.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.InsuranceComponent tgt = new org.hl7.fhir.r4.model.Claim.InsuranceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_N.convertBoolean(src.getFocalElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String40_N.convertString(src.getBusinessArrangementElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getPreAuthRefList())
      tgt.getPreAuthRef().add(String40_N.convertString(t));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference40_N.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.AccidentComponent convertAccidentComponent(org.hl7.fhir.r4.model.Claim.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.AccidentComponent tgt = new org.hl7.fhir.model.core.Claim.AccidentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date40_N.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.AccidentComponent convertAccidentComponent(org.hl7.fhir.model.core.Claim.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.AccidentComponent tgt = new org.hl7.fhir.r4.model.Claim.AccidentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date40_N.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.ItemComponent convertItemComponent(org.hl7.fhir.r4.model.Claim.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.ItemComponent tgt = new org.hl7.fhir.model.core.Claim.ItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getCareTeamSequence())
      tgt.getCareTeamSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getDiagnosisSequence())
      tgt.getDiagnosisSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getProcedureSequence())
      tgt.getProcedureSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getInformationSequence())
      tgt.getInformationSequenceList().add(PositiveInt40_N.convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(Reference40_N.convertReference(t));
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEncounter()) tgt.addEncounter(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Claim.DetailComponent t : src.getDetail()) tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.ItemComponent convertItemComponent(org.hl7.fhir.model.core.Claim.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.ItemComponent tgt = new org.hl7.fhir.r4.model.Claim.ItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getCareTeamSequenceList())
      tgt.getCareTeamSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getDiagnosisSequenceList())
      tgt.getDiagnosisSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getProcedureSequenceList())
      tgt.getProcedureSequence().add(PositiveInt40_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getInformationSequenceList())
      tgt.getInformationSequence().add(PositiveInt40_N.convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference40_N.convertReference(t));
    if (src.getBodySiteFirstRep().hasSite())
      tgt.setBodySite(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getBodySiteFirstRep().getSubSiteList())
      tgt.addSubSite(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEncounterList()) tgt.addEncounter(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Claim.DetailComponent t : src.getDetailList()) tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.DetailComponent convertDetailComponent(org.hl7.fhir.r4.model.Claim.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.DetailComponent tgt = new org.hl7.fhir.model.core.Claim.DetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Claim.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.DetailComponent convertDetailComponent(org.hl7.fhir.model.core.Claim.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.DetailComponent tgt = new org.hl7.fhir.r4.model.Claim.DetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Claim.SubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4.model.Claim.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.SubDetailComponent tgt = new org.hl7.fhir.model.core.Claim.SubDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Claim.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.model.core.Claim.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Claim.SubDetailComponent tgt = new org.hl7.fhir.r4.model.Claim.SubDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept40_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money40_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference40_N.convertReference(t));
    return tgt;
  }
}