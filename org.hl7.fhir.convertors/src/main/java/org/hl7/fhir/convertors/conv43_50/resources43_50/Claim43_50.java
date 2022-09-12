package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Money43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Date43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.PositiveInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class Claim43_50 {

  public static org.hl7.fhir.r5.model.Claim convertClaim(org.hl7.fhir.r4b.model.Claim src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim tgt = new org.hl7.fhir.r5.model.Claim();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_50.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(Period43_50.convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_50.convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_50.convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_50.convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_50.convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_50.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent t : src.getRelated())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasPrescription())
      tgt.setPrescription(Reference43_50.convertReference(src.getPrescription()));
    if (src.hasOriginalPrescription())
      tgt.setOriginalPrescription(Reference43_50.convertReference(src.getOriginalPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference43_50.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_50.convertReference(src.getFacility()));
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
      tgt.setTotal(Money43_50.convertMoney(src.getTotal()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim convertClaim(org.hl7.fhir.r5.model.Claim src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim tgt = new org.hl7.fhir.r4b.model.Claim();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClaimStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_50.convertCodeableConcept(src.getSubType()));
    if (src.hasUse())
      tgt.setUseElement(convertUse(src.getUseElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasBillablePeriod())
      tgt.setBillablePeriod(Period43_50.convertPeriod(src.getBillablePeriod()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_50.convertReference(src.getEnterer()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_50.convertReference(src.getInsurer()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_50.convertReference(src.getProvider()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_50.convertCodeableConcept(src.getPriority()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_50.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r5.model.Claim.RelatedClaimComponent t : src.getRelated())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasPrescription())
      tgt.setPrescription(Reference43_50.convertReference(src.getPrescription()));
    if (src.hasOriginalPrescription())
      tgt.setOriginalPrescription(Reference43_50.convertReference(src.getOriginalPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference43_50.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_50.convertReference(src.getFacility()));
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
    for (org.hl7.fhir.r5.model.Claim.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
    if (src.hasTotal())
      tgt.setTotal(Money43_50.convertMoney(src.getTotal()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertClaimStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertClaimStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> convertUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.UseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CLAIM:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.CLAIM);
        break;
      case PREAUTHORIZATION:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.PREAUTHORIZATION);
        break;
      case PREDETERMINATION:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.PREDETERMINATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.Use.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> convertUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.Use> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.UseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.RelatedClaimComponent tgt = new org.hl7.fhir.r5.model.Claim.RelatedClaimComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference43_50.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_50.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier43_50.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r5.model.Claim.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent tgt = new org.hl7.fhir.r4b.model.Claim.RelatedClaimComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference43_50.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_50.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier43_50.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.PayeeComponent convertPayeeComponent(org.hl7.fhir.r4b.model.Claim.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.PayeeComponent tgt = new org.hl7.fhir.r5.model.Claim.PayeeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.PayeeComponent convertPayeeComponent(org.hl7.fhir.r5.model.Claim.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.PayeeComponent tgt = new org.hl7.fhir.r4b.model.Claim.PayeeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r4b.model.Claim.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.CareTeamComponent tgt = new org.hl7.fhir.r5.model.Claim.CareTeamComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_50.convertReference(src.getProvider()));
    if (src.hasResponsible())
      tgt.setResponsibleElement(Boolean43_50.convertBoolean(src.getResponsibleElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    if (src.hasQualification())
      tgt.setSpecialty(CodeableConcept43_50.convertCodeableConcept(src.getQualification()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r5.model.Claim.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.CareTeamComponent tgt = new org.hl7.fhir.r4b.model.Claim.CareTeamComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_50.convertReference(src.getProvider()));
    if (src.hasResponsible())
      tgt.setResponsibleElement(Boolean43_50.convertBoolean(src.getResponsibleElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    if (src.hasSpecialty())
      tgt.setQualification(CodeableConcept43_50.convertCodeableConcept(src.getSpecialty()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4b.model.Claim.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.SupportingInformationComponent tgt = new org.hl7.fhir.r5.model.Claim.SupportingInformationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_50.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r5.model.Claim.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.SupportingInformationComponent tgt = new org.hl7.fhir.r4b.model.Claim.SupportingInformationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTiming()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_50.convertCodeableConcept(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4b.model.Claim.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.Claim.DiagnosisComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosis())
      tgt.setDiagnosis(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDiagnosis()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(CodeableConcept43_50.convertCodeableConcept(src.getOnAdmission()));
//    if (src.hasPackageCode())
//      tgt.setPackageCode(CodeableConcept43_50.convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.Claim.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.DiagnosisComponent tgt = new org.hl7.fhir.r4b.model.Claim.DiagnosisComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosis())
      tgt.setDiagnosis(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDiagnosis()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(CodeableConcept43_50.convertCodeableConcept(src.getOnAdmission()));
//    if (src.hasPackageCode())
//      tgt.setPackageCode(CodeableConcept43_50.convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r4b.model.Claim.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.ProcedureComponent tgt = new org.hl7.fhir.r5.model.Claim.ProcedureComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasProcedure())
      tgt.setProcedure(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProcedure()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r5.model.Claim.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.ProcedureComponent tgt = new org.hl7.fhir.r4b.model.Claim.ProcedureComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasProcedure())
      tgt.setProcedure(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProcedure()));
    for (org.hl7.fhir.r5.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4b.model.Claim.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.InsuranceComponent tgt = new org.hl7.fhir.r5.model.Claim.InsuranceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_50.convertBoolean(src.getFocalElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_50.convertString(src.getBusinessArrangementElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRef().add(String43_50.convertString(t));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_50.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.Claim.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.InsuranceComponent tgt = new org.hl7.fhir.r4b.model.Claim.InsuranceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_50.convertBoolean(src.getFocalElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_50.convertString(src.getBusinessArrangementElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRef().add(String43_50.convertString(t));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_50.convertReference(src.getClaimResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.AccidentComponent convertAccidentComponent(org.hl7.fhir.r4b.model.Claim.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.AccidentComponent tgt = new org.hl7.fhir.r5.model.Claim.AccidentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.AccidentComponent convertAccidentComponent(org.hl7.fhir.r5.model.Claim.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.AccidentComponent tgt = new org.hl7.fhir.r4b.model.Claim.AccidentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.ItemComponent convertItemComponent(org.hl7.fhir.r4b.model.Claim.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.ItemComponent tgt = new org.hl7.fhir.r5.model.Claim.ItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getCareTeamSequence())
      tgt.getCareTeamSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getDiagnosisSequence())
      tgt.getDiagnosisSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getProcedureSequence())
      tgt.getProcedureSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getInformationSequence())
      tgt.getInformationSequence().add(PositiveInt43_50.convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_50.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_50.convertReference(t));
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept43_50.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEncounter()) tgt.addEncounter(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Claim.DetailComponent t : src.getDetail()) tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.ItemComponent convertItemComponent(org.hl7.fhir.r5.model.Claim.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.ItemComponent tgt = new org.hl7.fhir.r4b.model.Claim.ItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getCareTeamSequence())
      tgt.getCareTeamSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getDiagnosisSequence())
      tgt.getDiagnosisSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getProcedureSequence())
      tgt.getProcedureSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getInformationSequence())
      tgt.getInformationSequence().add(PositiveInt43_50.convertPositiveInt(t));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_50.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getServiced()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLocation()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_50.convertReference(t));
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept43_50.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySiteFirstRep().getSubSite())
      tgt.addSubSite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEncounter()) tgt.addEncounter(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Claim.DetailComponent t : src.getDetail()) tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.DetailComponent convertDetailComponent(org.hl7.fhir.r4b.model.Claim.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.DetailComponent tgt = new org.hl7.fhir.r5.model.Claim.DetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_50.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Claim.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.DetailComponent convertDetailComponent(org.hl7.fhir.r5.model.Claim.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.DetailComponent tgt = new org.hl7.fhir.r4b.model.Claim.DetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_50.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Claim.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Claim.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4b.model.Claim.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Claim.SubDetailComponent tgt = new org.hl7.fhir.r5.model.Claim.SubDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_50.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Claim.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r5.model.Claim.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Claim.SubDetailComponent tgt = new org.hl7.fhir.r4b.model.Claim.SubDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasRevenue())
      tgt.setRevenue(CodeableConcept43_50.convertCodeableConcept(src.getRevenue()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode())
      tgt.addProgramCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.Reference t : src.getUdi()) tgt.addUdi(Reference43_50.convertReference(t));
    return tgt;
  }
}