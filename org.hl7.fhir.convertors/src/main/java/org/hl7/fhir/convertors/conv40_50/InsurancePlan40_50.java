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
public class InsurancePlan40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.InsurancePlan convertInsurancePlan(org.hl7.fhir.r4.model.InsurancePlan src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan tgt = new org.hl7.fhir.r5.model.InsurancePlan();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAlias().add(convertString(t));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasOwnedBy())
            tgt.setOwnedBy(convertReference(src.getOwnedBy()));
        if (src.hasAdministeredBy())
            tgt.setAdministeredBy(convertReference(src.getAdministeredBy()));
        for (org.hl7.fhir.r4.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(convertReference(t));
        for (org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanContactComponent t : src.getContact()) tgt.addContact(convertInsurancePlanContactComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getNetwork()) tgt.addNetwork(convertReference(t));
        for (org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanCoverageComponent t : src.getCoverage()) tgt.addCoverage(convertInsurancePlanCoverageComponent(t));
        for (org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanComponent t : src.getPlan()) tgt.addPlan(convertInsurancePlanPlanComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan convertInsurancePlan(org.hl7.fhir.r5.model.InsurancePlan src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan tgt = new org.hl7.fhir.r4.model.InsurancePlan();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.getAlias().add(convertString(t));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasOwnedBy())
            tgt.setOwnedBy(convertReference(src.getOwnedBy()));
        if (src.hasAdministeredBy())
            tgt.setAdministeredBy(convertReference(src.getAdministeredBy()));
        for (org.hl7.fhir.r5.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(convertReference(t));
        for (org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanContactComponent t : src.getContact()) tgt.addContact(convertInsurancePlanContactComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getNetwork()) tgt.addNetwork(convertReference(t));
        for (org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanCoverageComponent t : src.getCoverage()) tgt.addCoverage(convertInsurancePlanCoverageComponent(t));
        for (org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanComponent t : src.getPlan()) tgt.addPlan(convertInsurancePlanPlanComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanContactComponent convertInsurancePlanContactComponent(org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanContactComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanContactComponent tgt = new org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanContactComponent();
        copyElement(src, tgt);
        if (src.hasPurpose())
            tgt.setPurpose(convertCodeableConcept(src.getPurpose()));
        if (src.hasName())
            tgt.setName(convertHumanName(src.getName()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(convertAddress(src.getAddress()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanContactComponent convertInsurancePlanContactComponent(org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanContactComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanContactComponent tgt = new org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanContactComponent();
        copyElement(src, tgt);
        if (src.hasPurpose())
            tgt.setPurpose(convertCodeableConcept(src.getPurpose()));
        if (src.hasName())
            tgt.setName(convertHumanName(src.getName()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(convertAddress(src.getAddress()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanCoverageComponent convertInsurancePlanCoverageComponent(org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanCoverageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanCoverageComponent tgt = new org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanCoverageComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.Reference t : src.getNetwork()) tgt.addNetwork(convertReference(t));
        for (org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitComponent t : src.getBenefit()) tgt.addBenefit(convertCoverageBenefitComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanCoverageComponent convertInsurancePlanCoverageComponent(org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanCoverageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanCoverageComponent tgt = new org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanCoverageComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.Reference t : src.getNetwork()) tgt.addNetwork(convertReference(t));
        for (org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitComponent t : src.getBenefit()) tgt.addBenefit(convertCoverageBenefitComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitComponent convertCoverageBenefitComponent(org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitComponent tgt = new org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasRequirement())
            tgt.setRequirementElement(convertString(src.getRequirementElement()));
        for (org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitLimitComponent t : src.getLimit()) tgt.addLimit(convertCoverageBenefitLimitComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitComponent convertCoverageBenefitComponent(org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitComponent tgt = new org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasRequirement())
            tgt.setRequirementElement(convertString(src.getRequirementElement()));
        for (org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitLimitComponent t : src.getLimit()) tgt.addLimit(convertCoverageBenefitLimitComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitLimitComponent convertCoverageBenefitLimitComponent(org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitLimitComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitLimitComponent tgt = new org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitLimitComponent();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(convertQuantity(src.getValue()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitLimitComponent convertCoverageBenefitLimitComponent(org.hl7.fhir.r5.model.InsurancePlan.CoverageBenefitLimitComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitLimitComponent tgt = new org.hl7.fhir.r4.model.InsurancePlan.CoverageBenefitLimitComponent();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(convertQuantity(src.getValue()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanComponent convertInsurancePlanPlanComponent(org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanComponent tgt = new org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getNetwork()) tgt.addNetwork(convertReference(t));
        for (org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent t : src.getGeneralCost()) tgt.addGeneralCost(convertInsurancePlanPlanGeneralCostComponent(t));
        for (org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent t : src.getSpecificCost()) tgt.addSpecificCost(convertInsurancePlanPlanSpecificCostComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanComponent convertInsurancePlanPlanComponent(org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanComponent tgt = new org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.Reference t : src.getCoverageArea()) tgt.addCoverageArea(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getNetwork()) tgt.addNetwork(convertReference(t));
        for (org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent t : src.getGeneralCost()) tgt.addGeneralCost(convertInsurancePlanPlanGeneralCostComponent(t));
        for (org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent t : src.getSpecificCost()) tgt.addSpecificCost(convertInsurancePlanPlanSpecificCostComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent convertInsurancePlanPlanGeneralCostComponent(org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent tgt = new org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasGroupSize())
            tgt.setGroupSizeElement(convertPositiveInt(src.getGroupSizeElement()));
        if (src.hasCost())
            tgt.setCost(convertMoney(src.getCost()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent convertInsurancePlanPlanGeneralCostComponent(org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent tgt = new org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanGeneralCostComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasGroupSize())
            tgt.setGroupSizeElement(convertPositiveInt(src.getGroupSizeElement()));
        if (src.hasCost())
            tgt.setCost(convertMoney(src.getCost()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent convertInsurancePlanPlanSpecificCostComponent(org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent tgt = new org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        for (org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitComponent t : src.getBenefit()) tgt.addBenefit(convertPlanBenefitComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent convertInsurancePlanPlanSpecificCostComponent(org.hl7.fhir.r5.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent tgt = new org.hl7.fhir.r4.model.InsurancePlan.InsurancePlanPlanSpecificCostComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        for (org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitComponent t : src.getBenefit()) tgt.addBenefit(convertPlanBenefitComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitComponent convertPlanBenefitComponent(org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitComponent tgt = new org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitCostComponent t : src.getCost()) tgt.addCost(convertPlanBenefitCostComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitComponent convertPlanBenefitComponent(org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitComponent tgt = new org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitCostComponent t : src.getCost()) tgt.addCost(convertPlanBenefitCostComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitCostComponent convertPlanBenefitCostComponent(org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitCostComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitCostComponent tgt = new org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitCostComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasApplicability())
            tgt.setApplicability(convertCodeableConcept(src.getApplicability()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getQualifiers()) tgt.addQualifiers(convertCodeableConcept(t));
        if (src.hasValue())
            tgt.setValue(convertQuantity(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitCostComponent convertPlanBenefitCostComponent(org.hl7.fhir.r5.model.InsurancePlan.PlanBenefitCostComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitCostComponent tgt = new org.hl7.fhir.r4.model.InsurancePlan.PlanBenefitCostComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasApplicability())
            tgt.setApplicability(convertCodeableConcept(src.getApplicability()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getQualifiers()) tgt.addQualifiers(convertCodeableConcept(t));
        if (src.hasValue())
            tgt.setValue(convertQuantity(src.getValue()));
        return tgt;
    }
}