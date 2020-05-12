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
public class ImmunizationRecommendation40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ImmunizationRecommendation convertImmunizationRecommendation(org.hl7.fhir.r4.model.ImmunizationRecommendation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ImmunizationRecommendation tgt = new org.hl7.fhir.r5.model.ImmunizationRecommendation();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasAuthority())
            tgt.setAuthority(convertReference(src.getAuthority()));
        for (org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent t : src.getRecommendation()) tgt.addRecommendation(convertImmunizationRecommendationRecommendationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImmunizationRecommendation convertImmunizationRecommendation(org.hl7.fhir.r5.model.ImmunizationRecommendation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImmunizationRecommendation tgt = new org.hl7.fhir.r4.model.ImmunizationRecommendation();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasAuthority())
            tgt.setAuthority(convertReference(src.getAuthority()));
        for (org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent t : src.getRecommendation()) tgt.addRecommendation(convertImmunizationRecommendationRecommendationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent convertImmunizationRecommendationRecommendationComponent(org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent tgt = new org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getVaccineCode()) tgt.addVaccineCode(convertCodeableConcept(t));
        if (src.hasTargetDisease())
            tgt.addTargetDisease(convertCodeableConcept(src.getTargetDisease()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getContraindicatedVaccineCode()) tgt.addContraindicatedVaccineCode(convertCodeableConcept(t));
        if (src.hasForecastStatus())
            tgt.setForecastStatus(convertCodeableConcept(src.getForecastStatus()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getForecastReason()) tgt.addForecastReason(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent t : src.getDateCriterion()) tgt.addDateCriterion(convertImmunizationRecommendationRecommendationDateCriterionComponent(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSeries())
            tgt.setSeriesElement(convertString(src.getSeriesElement()));
        if (src.hasDoseNumber())
            tgt.setDoseNumber(src.getDoseNumber().primitiveValue());
        if (src.hasSeriesDoses())
            tgt.setSeriesDoses(src.getSeriesDoses().primitiveValue());
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingImmunization()) tgt.addSupportingImmunization(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingPatientInformation()) tgt.addSupportingPatientInformation(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent convertImmunizationRecommendationRecommendationComponent(org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent tgt = new org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getVaccineCode()) tgt.addVaccineCode(convertCodeableConcept(t));
        if (src.hasTargetDisease())
            tgt.setTargetDisease(convertCodeableConcept(src.getTargetDiseaseFirstRep()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getContraindicatedVaccineCode()) tgt.addContraindicatedVaccineCode(convertCodeableConcept(t));
        if (src.hasForecastStatus())
            tgt.setForecastStatus(convertCodeableConcept(src.getForecastStatus()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getForecastReason()) tgt.addForecastReason(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent t : src.getDateCriterion()) tgt.addDateCriterion(convertImmunizationRecommendationRecommendationDateCriterionComponent(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSeries())
            tgt.setSeriesElement(convertString(src.getSeriesElement()));
        if (src.hasDoseNumber())
            tgt.setDoseNumber(convertType(src.getDoseNumberElement()));
        if (src.hasSeriesDoses())
            tgt.setSeriesDoses(convertType(src.getSeriesDosesElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingImmunization()) tgt.addSupportingImmunization(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingPatientInformation()) tgt.addSupportingPatientInformation(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent convertImmunizationRecommendationRecommendationDateCriterionComponent(org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent tgt = new org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValueElement(convertDateTime(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent convertImmunizationRecommendationRecommendationDateCriterionComponent(org.hl7.fhir.r5.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent tgt = new org.hl7.fhir.r4.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValueElement(convertDateTime(src.getValueElement()));
        return tgt;
    }
}