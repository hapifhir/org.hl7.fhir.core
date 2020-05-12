package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class ExplanationOfBenefit40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit convertExplanationOfBenefit(org.hl7.fhir.r4.model.ExplanationOfBenefit src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertExplanationOfBenefitStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(convertCodeableConcept(src.getSubType()));
        if (src.hasUse())
            tgt.setUseElement(convertUse(src.getUseElement()));
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
        if (src.hasFundsReserveRequested())
            tgt.setFundsReserveRequested(convertCodeableConcept(src.getFundsReserveRequested()));
        if (src.hasFundsReserve())
            tgt.setFundsReserve(convertCodeableConcept(src.getFundsReserve()));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent t : src.getRelated()) tgt.addRelated(convertRelatedClaimComponent(t));
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
        if (src.hasClaim())
            tgt.setClaim(convertReference(src.getClaim()));
        if (src.hasClaimResponse())
            tgt.setClaimResponse(convertReference(src.getClaimResponse()));
        if (src.hasOutcome())
            tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
        if (src.hasDisposition())
            tgt.setDispositionElement(convertString(src.getDispositionElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getPreAuthRef()) tgt.getPreAuthRef().add(convertString(t));
        for (org.hl7.fhir.r4.model.Period t : src.getPreAuthRefPeriod()) tgt.addPreAuthRefPeriod(convertPeriod(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent t : src.getCareTeam()) tgt.addCareTeam(convertCareTeamComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent t : src.getSupportingInfo()) tgt.addSupportingInfo(convertSupportingInformationComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent t : src.getDiagnosis()) tgt.addDiagnosis(convertDiagnosisComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent t : src.getProcedure()) tgt.addProcedure(convertProcedureComponent(t));
        if (src.hasPrecedence())
            tgt.setPrecedenceElement(convertPositiveInt(src.getPrecedenceElement()));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent t : src.getInsurance()) tgt.addInsurance(convertInsuranceComponent(t));
        if (src.hasAccident())
            tgt.setAccident(convertAccidentComponent(src.getAccident()));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent t : src.getAddItem()) tgt.addAddItem(convertAddedItemComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent t : src.getTotal()) tgt.addTotal(convertTotalComponent(t));
        if (src.hasPayment())
            tgt.setPayment(convertPaymentComponent(src.getPayment()));
        if (src.hasFormCode())
            tgt.setFormCode(convertCodeableConcept(src.getFormCode()));
        if (src.hasForm())
            tgt.setForm(convertAttachment(src.getForm()));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent t : src.getProcessNote()) tgt.addProcessNote(convertNoteComponent(t));
        if (src.hasBenefitPeriod())
            tgt.setBenefitPeriod(convertPeriod(src.getBenefitPeriod()));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent t : src.getBenefitBalance()) tgt.addBenefitBalance(convertBenefitBalanceComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit convertExplanationOfBenefit(org.hl7.fhir.r5.model.ExplanationOfBenefit src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertExplanationOfBenefitStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(convertCodeableConcept(src.getSubType()));
        if (src.hasUse())
            tgt.setUseElement(convertUse(src.getUseElement()));
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
        if (src.hasFundsReserveRequested())
            tgt.setFundsReserveRequested(convertCodeableConcept(src.getFundsReserveRequested()));
        if (src.hasFundsReserve())
            tgt.setFundsReserve(convertCodeableConcept(src.getFundsReserve()));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent t : src.getRelated()) tgt.addRelated(convertRelatedClaimComponent(t));
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
        if (src.hasClaim())
            tgt.setClaim(convertReference(src.getClaim()));
        if (src.hasClaimResponse())
            tgt.setClaimResponse(convertReference(src.getClaimResponse()));
        if (src.hasOutcome())
            tgt.setOutcomeElement(convertRemittanceOutcome(src.getOutcomeElement()));
        if (src.hasDisposition())
            tgt.setDispositionElement(convertString(src.getDispositionElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getPreAuthRef()) tgt.getPreAuthRef().add(convertString(t));
        for (org.hl7.fhir.r5.model.Period t : src.getPreAuthRefPeriod()) tgt.addPreAuthRefPeriod(convertPeriod(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent t : src.getCareTeam()) tgt.addCareTeam(convertCareTeamComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent t : src.getSupportingInfo()) tgt.addSupportingInfo(convertSupportingInformationComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent t : src.getDiagnosis()) tgt.addDiagnosis(convertDiagnosisComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent t : src.getProcedure()) tgt.addProcedure(convertProcedureComponent(t));
        if (src.hasPrecedence())
            tgt.setPrecedenceElement(convertPositiveInt(src.getPrecedenceElement()));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent t : src.getInsurance()) tgt.addInsurance(convertInsuranceComponent(t));
        if (src.hasAccident())
            tgt.setAccident(convertAccidentComponent(src.getAccident()));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent t : src.getItem()) tgt.addItem(convertItemComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent t : src.getAddItem()) tgt.addAddItem(convertAddedItemComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent t : src.getTotal()) tgt.addTotal(convertTotalComponent(t));
        if (src.hasPayment())
            tgt.setPayment(convertPaymentComponent(src.getPayment()));
        if (src.hasFormCode())
            tgt.setFormCode(convertCodeableConcept(src.getFormCode()));
        if (src.hasForm())
            tgt.setForm(convertAttachment(src.getForm()));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent t : src.getProcessNote()) tgt.addProcessNote(convertNoteComponent(t));
        if (src.hasBenefitPeriod())
            tgt.setBenefitPeriod(convertPeriod(src.getBenefitPeriod()));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent t : src.getBenefitBalance()) tgt.addBenefitBalance(convertBenefitBalanceComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> convertExplanationOfBenefitStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> convertExplanationOfBenefitStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.ACTIVE);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.CANCELLED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.DRAFT);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.ExplanationOfBenefitStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> convertUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.Use> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.UseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.Use> convertUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.Use> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.Use> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ExplanationOfBenefit.UseEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLAIM:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.Use.CLAIM);
                break;
            case PREAUTHORIZATION:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.Use.PREAUTHORIZATION);
                break;
            case PREDETERMINATION:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.Use.PREDETERMINATION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.Use.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> convertRemittanceOutcome(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodesEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome> convertRemittanceOutcome(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ClaimProcessingCodes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcomeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case QUEUED:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.QUEUED);
                break;
            case COMPLETE:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.COMPLETE);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.ERROR);
                break;
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.PARTIAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ExplanationOfBenefit.RemittanceOutcome.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent();
        copyElement(src, tgt);
        if (src.hasClaim())
            tgt.setClaim(convertReference(src.getClaim()));
        if (src.hasRelationship())
            tgt.setRelationship(convertCodeableConcept(src.getRelationship()));
        if (src.hasReference())
            tgt.setReference(convertIdentifier(src.getReference()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent convertRelatedClaimComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.RelatedClaimComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.RelatedClaimComponent();
        copyElement(src, tgt);
        if (src.hasClaim())
            tgt.setClaim(convertReference(src.getClaim()));
        if (src.hasRelationship())
            tgt.setRelationship(convertCodeableConcept(src.getRelationship()));
        if (src.hasReference())
            tgt.setReference(convertIdentifier(src.getReference()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.PayeeComponent convertPayeeComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.PayeeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.PayeeComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.PayeeComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasParty())
            tgt.setParty(convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.PayeeComponent convertPayeeComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.PayeeComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.PayeeComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.PayeeComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasParty())
            tgt.setParty(convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent();
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

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent convertCareTeamComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.CareTeamComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.CareTeamComponent();
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

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent();
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
            tgt.setReason(convertCoding(src.getReason()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.SupportingInformationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.SupportingInformationComponent();
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
            tgt.setReason(convertCoding(src.getReason()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        if (src.hasDiagnosis())
            tgt.setDiagnosis(convertType(src.getDiagnosis()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasOnAdmission())
            tgt.setOnAdmission(convertCodeableConcept(src.getOnAdmission()));
        if (src.hasPackageCode())
            tgt.setPackageCode(convertCodeableConcept(src.getPackageCode()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.DiagnosisComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.DiagnosisComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        if (src.hasDiagnosis())
            tgt.setDiagnosis(convertType(src.getDiagnosis()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasOnAdmission())
            tgt.setOnAdmission(convertCodeableConcept(src.getOnAdmission()));
        if (src.hasPackageCode())
            tgt.setPackageCode(convertCodeableConcept(src.getPackageCode()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasProcedure())
            tgt.setProcedure(convertType(src.getProcedure()));
        for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent convertProcedureComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.ProcedureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.ProcedureComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasProcedure())
            tgt.setProcedure(convertType(src.getProcedure()));
        for (org.hl7.fhir.r5.model.Reference t : src.getUdi()) tgt.addUdi(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent();
        copyElement(src, tgt);
        if (src.hasFocal())
            tgt.setFocalElement(convertBoolean(src.getFocalElement()));
        if (src.hasCoverage())
            tgt.setCoverage(convertReference(src.getCoverage()));
        for (org.hl7.fhir.r4.model.StringType t : src.getPreAuthRef()) tgt.getPreAuthRef().add(convertString(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.InsuranceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.InsuranceComponent();
        copyElement(src, tgt);
        if (src.hasFocal())
            tgt.setFocalElement(convertBoolean(src.getFocalElement()));
        if (src.hasCoverage())
            tgt.setCoverage(convertReference(src.getCoverage()));
        for (org.hl7.fhir.r5.model.StringType t : src.getPreAuthRef()) tgt.getPreAuthRef().add(convertString(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AccidentComponent convertAccidentComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AccidentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.AccidentComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AccidentComponent();
        copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDateElement(convertDate(src.getDateElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasLocation())
            tgt.setLocation(convertType(src.getLocation()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AccidentComponent convertAccidentComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AccidentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.AccidentComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AccidentComponent();
        copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDateElement(convertDate(src.getDateElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasLocation())
            tgt.setLocation(convertType(src.getLocation()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent convertItemComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getCareTeamSequence()) tgt.getCareTeamSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getDiagnosisSequence()) tgt.getDiagnosisSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getProcedureSequence()) tgt.getProcedureSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getInformationSequence()) tgt.getInformationSequence().add(convertPositiveInt(t));
        if (src.hasRevenue())
            tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode()) tgt.addProgramCode(convertCodeableConcept(t));
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
        for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(convertReference(t));
        if (src.hasBodySite())
            tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubSite()) tgt.addSubSite(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getEncounter()) tgt.addEncounter(convertReference(t));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent t : src.getDetail()) tgt.addDetail(convertDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent convertItemComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.ItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.ItemComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getCareTeamSequence()) tgt.getCareTeamSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getDiagnosisSequence()) tgt.getDiagnosisSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getProcedureSequence()) tgt.getProcedureSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getInformationSequence()) tgt.getInformationSequence().add(convertPositiveInt(t));
        if (src.hasRevenue())
            tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode()) tgt.addProgramCode(convertCodeableConcept(t));
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
        for (org.hl7.fhir.r5.model.Reference t : src.getUdi()) tgt.addUdi(convertReference(t));
        if (src.hasBodySite())
            tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubSite()) tgt.addSubSite(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getEncounter()) tgt.addEncounter(convertReference(t));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent t : src.getDetail()) tgt.addDetail(convertDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasReason())
            tgt.setReason(convertCodeableConcept(src.getReason()));
        if (src.hasAmount())
            tgt.setAmount(convertMoney(src.getAmount()));
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent convertAdjudicationComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasReason())
            tgt.setReason(convertCodeableConcept(src.getReason()));
        if (src.hasAmount())
            tgt.setAmount(convertMoney(src.getAmount()));
        if (src.hasValue())
            tgt.setValueElement(convertDecimal(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent convertDetailComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        if (src.hasRevenue())
            tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode()) tgt.addProgramCode(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(convertReference(t));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent t : src.getSubDetail()) tgt.addSubDetail(convertSubDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent convertDetailComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.DetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.DetailComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        if (src.hasRevenue())
            tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode()) tgt.addProgramCode(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        for (org.hl7.fhir.r5.model.Reference t : src.getUdi()) tgt.addUdi(convertReference(t));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent t : src.getSubDetail()) tgt.addSubDetail(convertSubDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        if (src.hasRevenue())
            tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode()) tgt.addProgramCode(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        for (org.hl7.fhir.r4.model.Reference t : src.getUdi()) tgt.addUdi(convertReference(t));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent convertSubDetailComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.SubDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.SubDetailComponent();
        copyElement(src, tgt);
        if (src.hasSequence())
            tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
        if (src.hasRevenue())
            tgt.setRevenue(convertCodeableConcept(src.getRevenue()));
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode()) tgt.addProgramCode(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        for (org.hl7.fhir.r5.model.Reference t : src.getUdi()) tgt.addUdi(convertReference(t));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getItemSequence()) tgt.getItemSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getDetailSequence()) tgt.getDetailSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getSubDetailSequence()) tgt.getSubDetailSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getProvider()) tgt.addProvider(convertReference(t));
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProgramCode()) tgt.addProgramCode(convertCodeableConcept(t));
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
        if (src.hasBodySite())
            tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubSite()) tgt.addSubSite(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent t : src.getDetail()) tgt.addDetail(convertAddedItemDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent convertAddedItemComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getItemSequence()) tgt.getItemSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getDetailSequence()) tgt.getDetailSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getSubDetailSequence()) tgt.getSubDetailSequence().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getProvider()) tgt.addProvider(convertReference(t));
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProgramCode()) tgt.addProgramCode(convertCodeableConcept(t));
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
        if (src.hasBodySite())
            tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubSite()) tgt.addSubSite(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent t : src.getDetail()) tgt.addDetail(convertAddedItemDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent();
        copyElement(src, tgt);
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent t : src.getSubDetail()) tgt.addSubDetail(convertAddedItemDetailSubDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent convertAddedItemDetailComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailComponent();
        copyElement(src, tgt);
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent t : src.getSubDetail()) tgt.addSubDetail(convertAddedItemDetailSubDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent convertAddedItemDetailSubDetailComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent();
        copyElement(src, tgt);
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        for (org.hl7.fhir.r4.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent convertAddedItemDetailSubDetailComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.AddedItemDetailSubDetailComponent();
        copyElement(src, tgt);
        if (src.hasProductOrService())
            tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier()) tgt.addModifier(convertCodeableConcept(t));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        for (org.hl7.fhir.r5.model.PositiveIntType t : src.getNoteNumber()) tgt.getNoteNumber().add(convertPositiveInt(t));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.AdjudicationComponent t : src.getAdjudication()) tgt.addAdjudication(convertAdjudicationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent convertTotalComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasAmount())
            tgt.setAmount(convertMoney(src.getAmount()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent convertTotalComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.TotalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.TotalComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasAmount())
            tgt.setAmount(convertMoney(src.getAmount()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.PaymentComponent convertPaymentComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.PaymentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.PaymentComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.PaymentComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasAdjustment())
            tgt.setAdjustment(convertMoney(src.getAdjustment()));
        if (src.hasAdjustmentReason())
            tgt.setAdjustmentReason(convertCodeableConcept(src.getAdjustmentReason()));
        if (src.hasDate())
            tgt.setDateElement(convertDate(src.getDateElement()));
        if (src.hasAmount())
            tgt.setAmount(convertMoney(src.getAmount()));
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.PaymentComponent convertPaymentComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.PaymentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.PaymentComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.PaymentComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasAdjustment())
            tgt.setAdjustment(convertMoney(src.getAdjustment()));
        if (src.hasAdjustmentReason())
            tgt.setAdjustmentReason(convertCodeableConcept(src.getAdjustmentReason()));
        if (src.hasDate())
            tgt.setDateElement(convertDate(src.getDateElement()));
        if (src.hasAmount())
            tgt.setAmount(convertMoney(src.getAmount()));
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent convertNoteComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent();
        copyElement(src, tgt);
        if (src.hasNumber())
            tgt.setNumberElement(convertPositiveInt(src.getNumberElement()));
        if (src.hasType())
            tgt.setTypeElement(Enumerations40_50.convertNoteType(src.getTypeElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasLanguage())
            tgt.setLanguage(convertCodeableConcept(src.getLanguage()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent convertNoteComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.NoteComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.NoteComponent();
        copyElement(src, tgt);
        if (src.hasNumber())
            tgt.setNumberElement(convertPositiveInt(src.getNumberElement()));
        if (src.hasType())
            tgt.setTypeElement(Enumerations40_50.convertNoteType(src.getTypeElement()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        if (src.hasLanguage())
            tgt.setLanguage(convertCodeableConcept(src.getLanguage()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent convertBenefitBalanceComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasExcluded())
            tgt.setExcludedElement(convertBoolean(src.getExcludedElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasNetwork())
            tgt.setNetwork(convertCodeableConcept(src.getNetwork()));
        if (src.hasUnit())
            tgt.setUnit(convertCodeableConcept(src.getUnit()));
        if (src.hasTerm())
            tgt.setTerm(convertCodeableConcept(src.getTerm()));
        for (org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent t : src.getFinancial()) tgt.addFinancial(convertBenefitComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent convertBenefitBalanceComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitBalanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitBalanceComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasExcluded())
            tgt.setExcludedElement(convertBoolean(src.getExcludedElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasNetwork())
            tgt.setNetwork(convertCodeableConcept(src.getNetwork()));
        if (src.hasUnit())
            tgt.setUnit(convertCodeableConcept(src.getUnit()));
        if (src.hasTerm())
            tgt.setTerm(convertCodeableConcept(src.getTerm()));
        for (org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent t : src.getFinancial()) tgt.addFinancial(convertBenefitComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent convertBenefitComponent(org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent tgt = new org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasAllowed())
            tgt.setAllowed(convertType(src.getAllowed()));
        if (src.hasUsed())
            tgt.setUsed(convertType(src.getUsed()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent convertBenefitComponent(org.hl7.fhir.r5.model.ExplanationOfBenefit.BenefitComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent tgt = new org.hl7.fhir.r4.model.ExplanationOfBenefit.BenefitComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasAllowed())
            tgt.setAllowed(convertType(src.getAllowed()));
        if (src.hasUsed())
            tgt.setUsed(convertType(src.getUsed()));
        return tgt;
    }
}