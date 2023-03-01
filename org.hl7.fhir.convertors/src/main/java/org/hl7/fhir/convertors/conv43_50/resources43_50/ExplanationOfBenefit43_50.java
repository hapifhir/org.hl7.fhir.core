package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
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
public class ExplanationOfBenefit43_50 {

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit convertExplanationOfBenefit(org.hl7.fhir.r4b.model.ExplanationOfBenefit src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertExplanationOfBenefitStatus(src.getStatusElement()));
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
    if (src.hasFundsReserveRequested())
      tgt.setFundsReserveRequested(CodeableConcept43_50.convertCodeableConcept(src.getFundsReserveRequested()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_50.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent t : src.getRelated())
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
    if (src.hasClaim())
      tgt.setClaim(Reference43_50.convertReference(src.getClaim()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_50.convertReference(src.getClaimResponse()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String43_50.convertString(src.getDispositionElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRef().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.Period t : src.getPreAuthRefPeriod())
      tgt.addPreAuthRefPeriod(Period43_50.convertPeriod(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent t : src.getCareTeam())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent t : src.getProcedure())
      tgt.addProcedure(convertProcedureComponent(t));
    if (src.hasPrecedence())
      tgt.setPrecedenceElement(PositiveInt43_50.convertPositiveInt(src.getPrecedenceElement()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasAccident())
      tgt.setAccident(convertAccidentComponent(src.getAccident()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.ItemComponent t : src.getItem())
      tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemComponent t : src.getAddItem())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.TotalComponent t : src.getTotal())
      tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept43_50.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment43_50.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(Period43_50.convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent t : src.getBenefitBalance())
      tgt.addBenefitBalance(convertBenefitBalanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit convertExplanationOfBenefit(org.hl7.fhir.r5.model.ExplanationOfBenefit src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertExplanationOfBenefitStatus(src.getStatusElement()));
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
    if (src.hasFundsReserveRequested())
      tgt.setFundsReserveRequested(CodeableConcept43_50.convertCodeableConcept(src.getFundsReserveRequested()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_50.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent t : src.getRelated())
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
    if (src.hasClaim())
      tgt.setClaim(Reference43_50.convertReference(src.getClaim()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_50.convertReference(src.getClaimResponse()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String43_50.convertString(src.getDispositionElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRef().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.Period t : src.getPreAuthRefPeriod())
      tgt.addPreAuthRefPeriod(Period43_50.convertPeriod(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent t : src.getCareTeam())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent t : src.getProcedure())
      tgt.addProcedure(convertProcedureComponent(t));
    if (src.hasPrecedence())
      tgt.setPrecedenceElement(PositiveInt43_50.convertPositiveInt(src.getPrecedenceElement()));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasAccident())
      tgt.setAccident(convertAccidentComponent(src.getAccident()));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent t : src.getItem())
      tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent t : src.getAddItem())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent t : src.getTotal())
      tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept43_50.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment43_50.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(Period43_50.convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent t : src.getBenefitBalance())
      tgt.addBenefitBalance(convertBenefitBalanceComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> convertExplanationOfBenefitStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> convertExplanationOfBenefitStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.NULL);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> convertRemittanceOutcome(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case QUEUED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.QUEUED);
        break;
      case COMPLETE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.COMPLETE);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.ERROR);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.PARTIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> convertRemittanceOutcome(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcomeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case QUEUED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.QUEUED);
        break;
      case COMPLETE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.COMPLETE);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.ERROR);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.PARTIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference43_50.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_50.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier43_50.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference43_50.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_50.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier43_50.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.PayeeComponent convertPayeeComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.PayeeComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.PayeeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.PayeeComponent convertPayeeComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.PayeeComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.PayeeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent();
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

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent();
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

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent();
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
      tgt.setReason(Coding43_50.convertCoding(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent();
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
      tgt.setReason(Coding43_50.convertCoding(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent();
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

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent();
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

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent();
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

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent();
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

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRef().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.InsuranceComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.InsuranceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    for (org.hl7.fhir.r5.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRef().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AccidentComponent convertAccidentComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.AccidentComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AccidentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AccidentComponent convertAccidentComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AccidentComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AccidentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent convertItemComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent();
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
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent t : src.getDetail())
      tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.ItemComponent convertItemComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.ItemComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.ItemComponent();
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
    if (src.getBodySiteFirstRep().hasSite())
      tgt.setBodySite(CodeableConcept43_50.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySiteFirstRep().getSubSite())
      tgt.addSubSite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEncounter()) tgt.addEncounter(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent t : src.getDetail())
      tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_50.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasValue())
      tgt.setQuantity(Decimal43_50.convertDecimalToQuantity(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_50.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasQuantity())
      tgt.setValueElement(Decimal43_50.convertDecimal(src.getQuantity().getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent convertDetailComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent();
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
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent convertDetailComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent();
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
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent();
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
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent();
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
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getSubDetailSequence())
      tgt.getSubDetailSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getProvider()) tgt.addProvider(Reference43_50.convertReference(t));
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
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept43_50.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getSubDetailSequence())
      tgt.getSubDetailSequence().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getProvider()) tgt.addProvider(Reference43_50.convertReference(t));
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
    if (src.hasBodySite())
      tgt.setBodySite(CodeableConcept43_50.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySiteFirstRep().getSubSite())
      tgt.addSubSite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemDetailSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemDetailSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent convertAddedItemDetailSubDetailComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent convertAddedItemDetailSubDetailComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumber().add(PositiveInt43_50.convertPositiveInt(t));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent convertTotalComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.TotalComponent convertTotalComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.TotalComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.TotalComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.PaymentComponent convertPaymentComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.PaymentComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.PaymentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money43_50.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept43_50.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.PaymentComponent convertPaymentComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.PaymentComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.PaymentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money43_50.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept43_50.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date43_50.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent convertNoteComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt43_50.convertPositiveInt(src.getNumberElement()));
    if (src.hasType())
      tgt.getType().addCoding().setSystem("http://hl7.org/fhir/note-type").setCode(src.getType().toCode());
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_50.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent convertNoteComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt43_50.convertPositiveInt(src.getNumberElement()));
    if (src.hasType() && src.getType().hasCoding("http://hl7.org/fhir/note-type"))
      tgt.setType(org.hl7.fhir.r4b.model.Enumerations.NoteType.fromCode(src.getType().getCode("http://hl7.org/fhir/note-type")));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_50.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent convertBenefitBalanceComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasExcluded())
      tgt.setExcludedElement(Boolean43_50.convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(CodeableConcept43_50.convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept43_50.convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(CodeableConcept43_50.convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent t : src.getFinancial())
      tgt.addFinancial(convertBenefitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent convertBenefitBalanceComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasExcluded())
      tgt.setExcludedElement(Boolean43_50.convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(CodeableConcept43_50.convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept43_50.convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(CodeableConcept43_50.convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent t : src.getFinancial())
      tgt.addFinancial(convertBenefitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent convertBenefitComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAllowed()));
    if (src.hasUsed())
      tgt.setUsed(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getUsed()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent convertBenefitComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAllowed()));
    if (src.hasUsed())
      tgt.setUsed(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getUsed()));
    return tgt;
  }
}