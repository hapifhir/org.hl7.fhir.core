package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Attachment43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
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
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.ExplanationOfBenefit;

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

public class ExplanationOfBenefit43_N {

  public static org.hl7.fhir.model.core.ExplanationOfBenefit convertExplanationOfBenefit(org.hl7.fhir.r4b.model.ExplanationOfBenefit src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertExplanationOfBenefitStatus(src.getStatusElement()));
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
    if (src.hasFundsReserveRequested())
      tgt.setFundsReserveRequested(CodeableConcept43_N.convertCodeableConcept(src.getFundsReserveRequested()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_N.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent t : src.getRelated())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasPrescription())
      tgt.setRequest(Reference43_N.convertReference(src.getPrescription()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference43_N.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_N.convertReference(src.getFacility()));
    if (src.hasClaim())
      tgt.setClaim(Reference43_N.convertReference(src.getClaim()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_N.convertReference(src.getClaimResponse()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String43_N.convertString(src.getDispositionElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRefList().add(String43_N.convertString(t));
    for (org.hl7.fhir.r4b.model.Period t : src.getPreAuthRefPeriod())
      tgt.addPreAuthRefPeriod(Period43_N.convertPeriod(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent t : src.getCareTeam())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent t : src.getProcedure())
      tgt.addProcedure(convertProcedureComponent(t));
    if (src.hasPrecedence())
      tgt.setPrecedenceElement(PositiveInt43_N.convertPositiveInt(src.getPrecedenceElement()));
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
      tgt.setFormCode(CodeableConcept43_N.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment43_N.convertAttachment(src.getForm()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent t : src.getProcessNote())
      tgt.addProcessNote(convertNoteComponent(t));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(Period43_N.convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent t : src.getBenefitBalance())
      tgt.addBenefitBalance(convertBenefitBalanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit convertExplanationOfBenefit(org.hl7.fhir.model.core.ExplanationOfBenefit src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertExplanationOfBenefitStatus(src.getStatusElement()));
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
    if (src.hasFundsReserveRequested())
      tgt.setFundsReserveRequested(CodeableConcept43_N.convertCodeableConcept(src.getFundsReserveRequested()));
    if (src.hasFundsReserve())
      tgt.setFundsReserve(CodeableConcept43_N.convertCodeableConcept(src.getFundsReserve()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent t : src.getRelatedList())
      tgt.addRelated(convertRelatedClaimComponent(t));
    if (src.hasRequest())
      tgt.setPrescription(Reference43_N.convertReference(src.getRequest()));
    if (src.hasPayee())
      tgt.setPayee(convertPayeeComponent(src.getPayee()));
    if (src.hasReferral())
      tgt.setReferral(Reference43_N.convertReference(src.getReferral()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_N.convertReference(src.getFacility()));
    if (src.hasClaim())
      tgt.setClaim(Reference43_N.convertReference(src.getClaim()));
    if (src.hasClaimResponse())
      tgt.setClaimResponse(Reference43_N.convertReference(src.getClaimResponse()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
    if (src.hasDisposition())
      tgt.setDispositionElement(String43_N.convertString(src.getDispositionElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getPreAuthRefList())
      tgt.getPreAuthRef().add(String43_N.convertString(t));
    for (org.hl7.fhir.model.core.Period t : src.getPreAuthRefPeriodList())
      tgt.addPreAuthRefPeriod(Period43_N.convertPeriod(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent t : src.getCareTeamList())
      tgt.addCareTeam(convertCareTeamComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent t : src.getSupportingInfoList())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent t : src.getDiagnosisList())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent t : src.getProcedureList())
      tgt.addProcedure(convertProcedureComponent(t));
    if (src.hasPrecedence())
      tgt.setPrecedenceElement(PositiveInt43_N.convertPositiveInt(src.getPrecedenceElement()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent t : src.getInsuranceList())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasAccident())
      tgt.setAccident(convertAccidentComponent(src.getAccident()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent t : src.getItemList())
      tgt.addItem(convertItemComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent t : src.getAddItemList())
      tgt.addAddItem(convertAddedItemComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent t : src.getTotalList())
      tgt.addTotal(convertTotalComponent(t));
    if (src.hasPayment())
      tgt.setPayment(convertPaymentComponent(src.getPayment()));
    if (src.hasFormCode())
      tgt.setFormCode(CodeableConcept43_N.convertCodeableConcept(src.getFormCode()));
    if (src.hasForm())
      tgt.setForm(Attachment43_N.convertAttachment(src.getForm()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent t : src.getProcessNoteList())
      tgt.addProcessNote(convertNoteComponent(t));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(Period43_N.convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent t : src.getBenefitBalanceList())
      tgt.addBenefitBalance(convertBenefitBalanceComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ExplanationOfBenefit.ExplanationOfBenefitStatus> convertExplanationOfBenefitStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ExplanationOfBenefit.ExplanationOfBenefitStatus> tgt = new Enumeration<>(new ExplanationOfBenefit.ExplanationOfBenefitStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(ExplanationOfBenefit.ExplanationOfBenefitStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> convertExplanationOfBenefitStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ExplanationOfBenefit.ExplanationOfBenefitStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ExplanationOfBenefit.ExplanationOfBenefitStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> convertRemittanceOutcome(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ClaimProcessingCodes> tgt = new Enumeration<>(new Enumerations.ClaimProcessingCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case QUEUED:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.QUEUED);
                  break;
              case COMPLETE:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.COMPLETE);
                  break;
              case ERROR:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.ERROR);
                  break;
              case PARTIAL:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.PARTIAL);
                  break;
              default:
                  tgt.setValue(Enumerations.ClaimProcessingCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> convertRemittanceOutcome(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcome> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RemittanceOutcomeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference43_N.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier43_N.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.RelatedClaimComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.RelatedClaimComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasClaim())
      tgt.setClaim(Reference43_N.convertReference(src.getClaim()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasReference())
      tgt.setReference(Identifier43_N.convertIdentifier(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.PayeeComponent convertPayeeComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.PayeeComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.PayeeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.PayeeComponent convertPayeeComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.PayeeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.PayeeComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.PayeeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent();
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

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.CareTeamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.CareTeamComponent();
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

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent();
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
      tgt.setReason(Coding43_N.convertCoding(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.SupportingInformationComponent();
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
      tgt.setReason(Coding43_N.convertCoding(src.getReason()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasDiagnosisReference()) {
      tgt.getDiagnosis().setReference(Reference43_N.convertReference(src.getDiagnosisReference()));
    } else if (src.hasDiagnosisCodeableConcept()) {
      tgt.getDiagnosis().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getDiagnosisCodeableConcept()));
    }
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasOnAdmission())
      tgt.setOnAdmission(CodeableConcept43_N.convertCodeableConcept(src.getOnAdmission()));
//    if (src.hasPackageCode())
//      tgt.setPackageCode(CodeableConcept43_N.convertCodeableConcept(src.getPackageCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.DiagnosisComponent();
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

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent();
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

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent convertProcedureComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.ProcedureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.ProcedureComponent();
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

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getPreAuthRef())
      tgt.getPreAuthRefList().add(String43_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.InsuranceComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.InsuranceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    for (org.hl7.fhir.model.core.StringType t : src.getPreAuthRefList())
      tgt.getPreAuthRef().add(String43_N.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AccidentComponent convertAccidentComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AccidentComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AccidentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date43_N.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AccidentComponent convertAccidentComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AccidentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AccidentComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AccidentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDate())
      tgt.setDateElement(Date43_N.convertDate(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasLocation())
      tgt.setLocation(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getLocation()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent convertItemComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent();
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
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent t : src.getDetail())
      tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.ItemComponent convertItemComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.ItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.ItemComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.ItemComponent();
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
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent t : src.getDetailList())
      tgt.addDetail(convertDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_N.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    if (src.hasValue())
      tgt.setQuantity(Decimal43_N.convertDecimalToQuantity(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasReason())
      tgt.setReason(CodeableConcept43_N.convertCodeableConcept(src.getReason()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    if (src.hasQuantity())
      tgt.setValueElement(Decimal43_N.convertDecimal(src.getQuantity().getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent convertDetailComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent();
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
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent convertDetailComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.DetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.DetailComponent();
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
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent();
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
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.SubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.SubDetailComponent();
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
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getItemSequence())
      tgt.getItemSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getDetailSequence())
      tgt.getDetailSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getSubDetailSequence())
      tgt.getSubDetailSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getProvider()) tgt.addProvider(Reference43_N.convertReference(t));
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
    if (src.hasBodySite())
      tgt.getBodySiteFirstRep().addSite(CodeableConcept43_N.convertCodeableConceptToCodeableReference(src.getBodySite()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubSite())
      tgt.getBodySiteFirstRep().addSubSite(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent t : src.getDetail())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getItemSequenceList())
      tgt.getItemSequence().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getDetailSequenceList())
      tgt.getDetailSequence().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getSubDetailSequenceList())
      tgt.getSubDetailSequence().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.Reference t : src.getProviderList()) tgt.addProvider(Reference43_N.convertReference(t));
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
    if (src.getBodySiteFirstRep().hasSite())
      tgt.setBodySite(CodeableConcept43_N.convertCodeableReferenceToCodeableConcept(src.getBodySiteFirstRep().getSiteFirstRep()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getBodySiteFirstRep().getSubSiteList())
      tgt.addSubSite(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent t : src.getDetailList())
      tgt.addDetail(convertAddedItemDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent t : src.getSubDetail())
      tgt.addSubDetail(convertAddedItemDetailSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent t : src.getSubDetailList())
      tgt.addSubDetail(convertAddedItemDetailSubDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent convertAddedItemDetailSubDetailComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getNoteNumber())
      tgt.getNoteNumberList().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent convertAddedItemDetailSubDetailComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.AddedItemDetailSubDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasNet())
      tgt.setNet(Money43_N.convertMoney(src.getNet()));
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getNoteNumberList())
      tgt.getNoteNumber().add(PositiveInt43_N.convertPositiveInt(t));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudicationList())
      tgt.addAdjudication(convertAdjudicationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent convertTotalComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.TotalComponent convertTotalComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.TotalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.TotalComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.TotalComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.PaymentComponent convertPaymentComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.PaymentComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.PaymentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money43_N.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept43_N.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date43_N.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.PaymentComponent convertPaymentComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.PaymentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.PaymentComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.PaymentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasAdjustment())
      tgt.setAdjustment(Money43_N.convertMoney(src.getAdjustment()));
    if (src.hasAdjustmentReason())
      tgt.setAdjustmentReason(CodeableConcept43_N.convertCodeableConcept(src.getAdjustmentReason()));
    if (src.hasDate())
      tgt.setDateElement(Date43_N.convertDate(src.getDateElement()));
    if (src.hasAmount())
      tgt.setAmount(Money43_N.convertMoney(src.getAmount()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent convertNoteComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt43_N.convertPositiveInt(src.getNumberElement()));
    if (src.hasType())
      tgt.getType().addCoding().setSystem("http://hl7.org/fhir/note-type").setCode(src.getType().toCode());
    if (src.hasText())
      tgt.setTextElement(String43_N.convertStringToMarkdown(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_N.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent convertNoteComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.NoteComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.NoteComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(PositiveInt43_N.convertPositiveInt(src.getNumberElement()));
    if (src.hasType() && src.getType().hasCoding("http://hl7.org/fhir/note-type"))
      tgt.setType(org.hl7.fhir.r4b.model.Enumerations.NoteType.fromCode(src.getType().getCode("http://hl7.org/fhir/note-type")));
    if (src.hasText())
      tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept43_N.convertCodeableConcept(src.getLanguage()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent convertBenefitBalanceComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasExcluded())
      tgt.setExcludedElement(Boolean43_N.convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(CodeableConcept43_N.convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept43_N.convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(CodeableConcept43_N.convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent t : src.getFinancial())
      tgt.addFinancial(convertBenefitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent convertBenefitBalanceComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitBalanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitBalanceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasExcluded())
      tgt.setExcludedElement(Boolean43_N.convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(CodeableConcept43_N.convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(CodeableConcept43_N.convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(CodeableConcept43_N.convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent t : src.getFinancialList())
      tgt.addFinancial(convertBenefitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent convertBenefitComponent(org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent tgt = new org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getAllowed()));
    if (src.hasUsed())
      tgt.setUsed(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getUsed()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent convertBenefitComponent(org.hl7.fhir.model.core.ExplanationOfBenefit.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent tgt = new org.hl7.fhir.r4b.model.ExplanationOfBenefit.BenefitComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowed(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getAllowed()));
    if (src.hasUsed())
      tgt.setUsed(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getUsed()));
    return tgt;
  }
}