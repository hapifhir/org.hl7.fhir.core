package org.hl7.fhir.convertors.conv40_50.resources40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Element40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Type40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.PositiveInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class Coverage40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Coverage convertCoverage(org.hl7.fhir.r4.model.Coverage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Coverage tgt = new org.hl7.fhir.r5.model.Coverage();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCoverageStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasPolicyHolder())
            tgt.setPolicyHolder(Reference40_50.convertReference(src.getPolicyHolder()));
        if (src.hasSubscriber())
            tgt.setSubscriber(Reference40_50.convertReference(src.getSubscriber()));
        if (src.hasSubscriberId())
            tgt.getSubscriberId().setValueElement(String40_50.convertString(src.getSubscriberIdElement()));
        if (src.hasBeneficiary())
            tgt.setBeneficiary(Reference40_50.convertReference(src.getBeneficiary()));
        if (src.hasDependent())
            tgt.setDependentElement(String40_50.convertString(src.getDependentElement()));
        if (src.hasRelationship())
            tgt.setRelationship(CodeableConcept40_50.convertCodeableConcept(src.getRelationship()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r4.model.Reference t : src.getPayor()) tgt.addPayor(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.Coverage.ClassComponent t : src.getClass_()) tgt.addClass_(convertClassComponent(t));
        if (src.hasOrder())
            tgt.setOrderElement(PositiveInt40_50.convertPositiveInt(src.getOrderElement()));
        if (src.hasNetwork())
            tgt.setNetworkElement(String40_50.convertString(src.getNetworkElement()));
        for (org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent t : src.getCostToBeneficiary()) tgt.addCostToBeneficiary(convertCostToBeneficiaryComponent(t));
        if (src.hasSubrogation())
            tgt.setSubrogationElement(Boolean40_50.convertBoolean(src.getSubrogationElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getContract()) tgt.addContract(Reference40_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Coverage convertCoverage(org.hl7.fhir.r5.model.Coverage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Coverage tgt = new org.hl7.fhir.r4.model.Coverage();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCoverageStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasPolicyHolder())
            tgt.setPolicyHolder(Reference40_50.convertReference(src.getPolicyHolder()));
        if (src.hasSubscriber())
            tgt.setSubscriber(Reference40_50.convertReference(src.getSubscriber()));
        if (src.hasSubscriberId())
            tgt.setSubscriberIdElement(String40_50.convertString(src.getSubscriberId().getValueElement()));
        if (src.hasBeneficiary())
            tgt.setBeneficiary(Reference40_50.convertReference(src.getBeneficiary()));
        if (src.hasDependent())
            tgt.setDependentElement(String40_50.convertString(src.getDependentElement()));
        if (src.hasRelationship())
            tgt.setRelationship(CodeableConcept40_50.convertCodeableConcept(src.getRelationship()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r5.model.Reference t : src.getPayor()) tgt.addPayor(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Coverage.ClassComponent t : src.getClass_()) tgt.addClass_(convertClassComponent(t));
        if (src.hasOrder())
            tgt.setOrderElement(PositiveInt40_50.convertPositiveInt(src.getOrderElement()));
        if (src.hasNetwork())
            tgt.setNetworkElement(String40_50.convertString(src.getNetworkElement()));
        for (org.hl7.fhir.r5.model.Coverage.CostToBeneficiaryComponent t : src.getCostToBeneficiary()) tgt.addCostToBeneficiary(convertCostToBeneficiaryComponent(t));
        if (src.hasSubrogation())
            tgt.setSubrogationElement(Boolean40_50.convertBoolean(src.getSubrogationElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getContract()) tgt.addContract(Reference40_50.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertCoverageStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> convertCoverageStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Coverage.CoverageStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Coverage.CoverageStatusEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.ACTIVE);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.CANCELLED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.DRAFT);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Coverage.CoverageStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Coverage.ClassComponent convertClassComponent(org.hl7.fhir.r4.model.Coverage.ClassComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Coverage.ClassComponent tgt = new org.hl7.fhir.r5.model.Coverage.ClassComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasValue())
            tgt.setValueElement(String40_50.convertString(src.getValueElement()));
        if (src.hasName())
            tgt.setNameElement(String40_50.convertString(src.getNameElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Coverage.ClassComponent convertClassComponent(org.hl7.fhir.r5.model.Coverage.ClassComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Coverage.ClassComponent tgt = new org.hl7.fhir.r4.model.Coverage.ClassComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasValue())
            tgt.setValueElement(String40_50.convertString(src.getValueElement()));
        if (src.hasName())
            tgt.setNameElement(String40_50.convertString(src.getNameElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Coverage.CostToBeneficiaryComponent convertCostToBeneficiaryComponent(org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Coverage.CostToBeneficiaryComponent tgt = new org.hl7.fhir.r5.model.Coverage.CostToBeneficiaryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasValue())
            tgt.setValue(Type40_50.convertType(src.getValue()));
        for (org.hl7.fhir.r4.model.Coverage.ExemptionComponent t : src.getException()) tgt.addException(convertExemptionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent convertCostToBeneficiaryComponent(org.hl7.fhir.r5.model.Coverage.CostToBeneficiaryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent tgt = new org.hl7.fhir.r4.model.Coverage.CostToBeneficiaryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasValue())
            tgt.setValue(Type40_50.convertType(src.getValue()));
        for (org.hl7.fhir.r5.model.Coverage.ExemptionComponent t : src.getException()) tgt.addException(convertExemptionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Coverage.ExemptionComponent convertExemptionComponent(org.hl7.fhir.r4.model.Coverage.ExemptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Coverage.ExemptionComponent tgt = new org.hl7.fhir.r5.model.Coverage.ExemptionComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Coverage.ExemptionComponent convertExemptionComponent(org.hl7.fhir.r5.model.Coverage.ExemptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Coverage.ExemptionComponent tgt = new org.hl7.fhir.r4.model.Coverage.ExemptionComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        return tgt;
    }
}