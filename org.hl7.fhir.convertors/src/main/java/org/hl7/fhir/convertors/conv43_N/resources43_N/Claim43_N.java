package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Money43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Date43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Decimal43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.r4b.model.Claim;
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

public class Claim43_N {

  public static org.hl7.fhir.model.core.Claim convertClaim(org.hl7.fhir.r4b.model.Claim src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim tgt = new org.hl7.fhir.model.core.Claim();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference43_N.convertReference(src.getPatient()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(Period43_N.convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_N.convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_N.convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_N.convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_N.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent t : src.getRelated())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasPrescription())
      tgt.setRequest(Reference43_N.convertReference(src.getPrescription()));
    if (src.hasOriginalPrescription())
      tgt.setOriginalPrescription(Reference43_N.convertReference(src.getOriginalPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference43_N.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_N.convertReference(src.getFacility()));
    for (org.hl7.fhir.r4b.model.Claim.CareTeamComponent t : src.getCareTeam())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.r4b.model.Claim.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r4b.model.Claim.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4b.model.Claim.ProcedureComponent t : src.getProcedure())
      tgt.addProcedure(convertProcedureComponent(t));
    for (org.hl7.fhir.r4b.model.Claim.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasAccident())
      tgt.setAccident(convertAccidentComponent(src.getAccident()));
    for (org.hl7.fhir.r4b.model.Claim.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
    if (src.hasTotal())
      tgt.setTotal(Money43_N.convertMoney(src.getTotal()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim convertClaim(org.hl7.fhir.model.core.Claim src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim tgt = new org.hl7.fhir.r4b.model.Claim();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_N.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasSubject())
      tgt.setPatient(Reference43_N.convertReference(src.getSubject()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(Period43_N.convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_N.convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_N.convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_N.convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_N.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.model.core.Claim.RelatedClaimComponent t : src.getRelatedList())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasRequest())
      tgt.setPrescription(Reference43_N.convertReference(src.getRequest()));
    if (src.hasOriginalPrescription())
      tgt.setOriginalPrescription(Reference43_N.convertReference(src.getOriginalPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference43_N.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_N.convertReference(src.getFacility()));
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
      tgt.setTotal(Money43_N.convertMoney(src.getTotal()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertClaimStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FinancialResourceStatusCodes> tgt = new Enumeration<>(new Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertClaimStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> convertUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.Use> tgt = new Enumeration<>(new Enumerations.UseEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> convertUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.Use> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.UseEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CLAIM:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.Use.CLAIM);
                  break;
              case PREAUTHORIZATION:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.Use.PREAUTHORIZATION);
                  break;
              case PREDETERMINATION:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.Use.PREDETERMINATION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.Use.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.RelatedClaimComponent tgt = new org.hl7.fhir.model.core.Claim.RelatedClaimComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference43_N.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier43_N.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.model.core.Claim.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent tgt = new org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference43_N.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier43_N.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.PayeeComponent convertPayeeComponent(org.hl7.fhir.r4b.model.Claim.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.PayeeComponent tgt = new org.hl7.fhir.model.core.Claim.PayeeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.PayeeComponent convertPayeeComponent(org.hl7.fhir.model.core.Claim.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.PayeeComponent tgt = new org.hl7.fhir.r4b.model.Claim.PayeeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r4b.model.Claim.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.CareTeamComponent tgt = new org.hl7.fhir.model.core.Claim.CareTeamComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_N.convertReference(src.getProvider()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_N.convertCodeableConcept(src.getRole()));
    if (src.hasQualification())
      tgt.setSpecialty(CodeableConcept43_N.convertCodeableConcept(src.getQualification()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.model.core.Claim.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.CareTeamComponent tgt = new org.hl7.fhir.r4b.model.Claim.CareTeamComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_N.convertReference(src.getProvider()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_N.convertCodeableConcept(src.getRole()));
    if (src.hasSpecialty())
      tgt.setQualification(CodeableConcept43_N.convertCodeableConcept(src.getSpecialty()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4b.model.Claim.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.SupportingInformationComponent tgt = new org.hl7.fhir.model.core.Claim.SupportingInformationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_N.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.model.core.Claim.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.SupportingInformationComponent tgt = new org.hl7.fhir.r4b.model.Claim.SupportingInformationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_N.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4b.model.Claim.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.DiagnosisComponent tgt = new org.hl7.fhir.model.core.Claim.DiagnosisComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosisCodeableConcept())
      tgt.getDiagnosis().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getDiagnosisCodeableConcept()));
    if (src.hasDiagnosisReference())
      tgt.getDiagnosis().setReference(Reference43_N.convertReference(src.getDiagnosisReference()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(CodeableConcept43_N.convertCodeableConcept(src.getOnAdmission()));
//    if (src.hasPackageCode())
//      tgt.setPackageCode(CodeableConcept43_N.convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.model.core.Claim.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.DiagnosisComponent tgt = new org.hl7.fhir.r4b.model.Claim.DiagnosisComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosis())
      tgt.setDiagnosis(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDiagnosis()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(CodeableConcept43_N.convertCodeableConcept(src.getOnAdmission()));
//    if (src.hasPackageCode())
//      tgt.setPackageCode(CodeableConcept43_N.convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r4b.model.Claim.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.ProcedureComponent tgt = new org.hl7.fhir.model.core.Claim.ProcedureComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasProcedureReference())
      tgt.getProcedure().setReference(Reference43_N.convertReference(src.getProcedureReference()));
    if (src.hasProcedureCodeableConcept())
      tgt.getProcedure().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getProcedureCodeableConcept()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.ProcedureComponent convertProcedureComponent(org.hl7.fhir.model.core.Claim.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.ProcedureComponent tgt = new org.hl7.fhir.r4b.model.Claim.ProcedureComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasProcedure())
      tgt.setProcedure(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getProcedure()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4b.model.Claim.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.InsuranceComponent tgt = new org.hl7.fhir.model.core.Claim.InsuranceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_N.convertBoolean(src.getFocalElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_N.convertString(src.getBusinessArrangementElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRefList().add(String43_N.convertString(t));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_N.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.model.core.Claim.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.InsuranceComponent tgt = new org.hl7.fhir.r4b.model.Claim.InsuranceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_N.convertBoolean(src.getFocalElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_N.convertString(src.getBusinessArrangementElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getPreAuthRefList())
      tgt.getPreAuthRef().add(String43_N.convertString(t));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_N.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.AccidentComponent convertAccidentComponent(org.hl7.fhir.r4b.model.Claim.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.AccidentComponent tgt = new org.hl7.fhir.model.core.Claim.AccidentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date43_N.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.AccidentComponent convertAccidentComponent(org.hl7.fhir.model.core.Claim.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.AccidentComponent tgt = new org.hl7.fhir.r4b.model.Claim.AccidentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date43_N.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.ItemComponent convertItemComponent(org.hl7.fhir.r4b.model.Claim.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.ItemComponent tgt = new org.hl7.fhir.model.core.Claim.ItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getCareTeamSequence())
      tgt.getCareTeamSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getDiagnosisSequence())
      tgt.getDiagnosisSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getProcedureSequence())
      tgt.getProcedureSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getInformationSequence())
      tgt.getInformationSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_N.convertReference(t));
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept43_N.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEncounter()) tgt.addEncounter(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Claim.DetailComponent t : src.getDetail()) tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.ItemComponent convertItemComponent(org.hl7.fhir.model.core.Claim.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.ItemComponent tgt = new org.hl7.fhir.r4b.model.Claim.ItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getCareTeamSequenceList())
      tgt.getCareTeamSequence().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getDiagnosisSequenceList())
      tgt.getDiagnosisSequence().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getProcedureSequenceList())
      tgt.getProcedureSequence().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getInformationSequenceList())
      tgt.getInformationSequence().add(PositiveInt43_N.convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference43_N.convertReference(t));
    if (src.getBodySiteFirstRep().hasSite())
      tgt.setBodySite(CodeableConcept43_N.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getBodySiteFirstRep().getSubSiteList())
      tgt.addSubSite(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEncounterList()) tgt.addEncounter(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Claim.DetailComponent t : src.getDetailList()) tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.DetailComponent convertDetailComponent(org.hl7.fhir.r4b.model.Claim.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.DetailComponent tgt = new org.hl7.fhir.model.core.Claim.DetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Claim.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.DetailComponent convertDetailComponent(org.hl7.fhir.model.core.Claim.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.DetailComponent tgt = new org.hl7.fhir.r4b.model.Claim.DetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Claim.SubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Claim.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4b.model.Claim.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Claim.SubDetailComponent tgt = new org.hl7.fhir.model.core.Claim.SubDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.model.core.Claim.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.SubDetailComponent tgt = new org.hl7.fhir.r4b.model.Claim.SubDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_N.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getProgramCodeList())
      tgt.addProgramCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.Reference t : src.getUdiList()) tgt.addUdi(Reference43_N.convertReference(t));
    return tgt;
  }
}