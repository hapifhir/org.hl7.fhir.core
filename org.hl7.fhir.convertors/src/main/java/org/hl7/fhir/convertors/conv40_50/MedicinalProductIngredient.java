package org.hl7.fhir.convertors.conv40_50;

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


public class MedicinalProductIngredient extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MedicinalProductIngredient convertMedicinalProductIngredient(org.hl7.fhir.r4.model.MedicinalProductIngredient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductIngredient tgt = new org.hl7.fhir.r5.model.MedicinalProductIngredient();
    copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(convertBoolean(src.getAllergenicIndicatorElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getManufacturer())
      tgt.addManufacturer(convertReference(t));
    for (org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent t : src.getSpecifiedSubstance())
      tgt.addSpecifiedSubstance(convertMedicinalProductIngredientSpecifiedSubstanceComponent(t));
    if (src.hasSubstance())
      tgt.setSubstance(convertMedicinalProductIngredientSubstanceComponent(src.getSubstance()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductIngredient convertMedicinalProductIngredient(org.hl7.fhir.r5.model.MedicinalProductIngredient src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductIngredient tgt = new org.hl7.fhir.r4.model.MedicinalProductIngredient();
    copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasAllergenicIndicator())
      tgt.setAllergenicIndicatorElement(convertBoolean(src.getAllergenicIndicatorElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getManufacturer())
      tgt.addManufacturer(convertReference(t));
    for (org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent t : src.getSpecifiedSubstance())
      tgt.addSpecifiedSubstance(convertMedicinalProductIngredientSpecifiedSubstanceComponent(t));
    if (src.hasSubstance())
      tgt.setSubstance(convertMedicinalProductIngredientSubstanceComponent(src.getSubstance()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent convertMedicinalProductIngredientSpecifiedSubstanceComponent(org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasGroup())
      tgt.setGroup(convertCodeableConcept(src.getGroup()));
    if (src.hasConfidentiality())
      tgt.setConfidentiality(convertCodeableConcept(src.getConfidentiality()));
    for (org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent t : src.getStrength())
      tgt.addStrength(convertMedicinalProductIngredientSpecifiedSubstanceStrengthComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent convertMedicinalProductIngredientSpecifiedSubstanceComponent(org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasGroup())
      tgt.setGroup(convertCodeableConcept(src.getGroup()));
    if (src.hasConfidentiality())
      tgt.setConfidentiality(convertCodeableConcept(src.getConfidentiality()));
    for (org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent t : src.getStrength())
      tgt.addStrength(convertMedicinalProductIngredientSpecifiedSubstanceStrengthComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent convertMedicinalProductIngredientSpecifiedSubstanceStrengthComponent(org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent();
    copyElement(src, tgt);
    if (src.hasPresentation())
      tgt.setPresentation(convertRatio(src.getPresentation()));
    if (src.hasPresentationLowLimit())
      tgt.setPresentationLowLimit(convertRatio(src.getPresentationLowLimit()));
    if (src.hasConcentration())
      tgt.setConcentration(convertRatio(src.getConcentration()));
    if (src.hasConcentrationLowLimit())
      tgt.setConcentrationLowLimit(convertRatio(src.getConcentrationLowLimit()));
    if (src.hasMeasurementPoint())
      tgt.setMeasurementPointElement(convertString(src.getMeasurementPointElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCountry())
      tgt.addCountry(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent t : src.getReferenceStrength())
      tgt.addReferenceStrength(convertMedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent convertMedicinalProductIngredientSpecifiedSubstanceStrengthComponent(org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent();
    copyElement(src, tgt);
    if (src.hasPresentation())
      tgt.setPresentation(convertRatio(src.getPresentation()));
    if (src.hasPresentationLowLimit())
      tgt.setPresentationLowLimit(convertRatio(src.getPresentationLowLimit()));
    if (src.hasConcentration())
      tgt.setConcentration(convertRatio(src.getConcentration()));
    if (src.hasConcentrationLowLimit())
      tgt.setConcentrationLowLimit(convertRatio(src.getConcentrationLowLimit()));
    if (src.hasMeasurementPoint())
      tgt.setMeasurementPointElement(convertString(src.getMeasurementPointElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCountry())
      tgt.addCountry(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent t : src.getReferenceStrength())
      tgt.addReferenceStrength(convertMedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent convertMedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent(org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent();
    copyElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(convertCodeableConcept(src.getSubstance()));
    if (src.hasStrength())
      tgt.setStrength(convertRatio(src.getStrength()));
    if (src.hasStrengthLowLimit())
      tgt.setStrengthLowLimit(convertRatio(src.getStrengthLowLimit()));
    if (src.hasMeasurementPoint())
      tgt.setMeasurementPointElement(convertString(src.getMeasurementPointElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCountry())
      tgt.addCountry(convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent convertMedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent(org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthReferenceStrengthComponent();
    copyElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(convertCodeableConcept(src.getSubstance()));
    if (src.hasStrength())
      tgt.setStrength(convertRatio(src.getStrength()));
    if (src.hasStrengthLowLimit())
      tgt.setStrengthLowLimit(convertRatio(src.getStrengthLowLimit()));
    if (src.hasMeasurementPoint())
      tgt.setMeasurementPointElement(convertString(src.getMeasurementPointElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCountry())
      tgt.addCountry(convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSubstanceComponent convertMedicinalProductIngredientSubstanceComponent(org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSubstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSubstanceComponent tgt = new org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSubstanceComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent t : src.getStrength())
      tgt.addStrength(convertMedicinalProductIngredientSpecifiedSubstanceStrengthComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSubstanceComponent convertMedicinalProductIngredientSubstanceComponent(org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSubstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSubstanceComponent tgt = new org.hl7.fhir.r4.model.MedicinalProductIngredient.MedicinalProductIngredientSubstanceComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.MedicinalProductIngredient.MedicinalProductIngredientSpecifiedSubstanceStrengthComponent t : src.getStrength())
      tgt.addStrength(convertMedicinalProductIngredientSpecifiedSubstanceStrengthComponent(t));
    return tgt;
  }


}
