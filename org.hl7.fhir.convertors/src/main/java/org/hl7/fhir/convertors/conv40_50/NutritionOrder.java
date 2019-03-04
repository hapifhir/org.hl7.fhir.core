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


public class NutritionOrder extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.NutritionOrder convertNutritionOrder(org.hl7.fhir.r4.model.NutritionOrder src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder tgt = new org.hl7.fhir.r5.model.NutritionOrder();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiates())
      tgt.getInstantiates().add(convertUri(t));
    if (src.hasStatus())
      tgt.setStatus(convertNutritionOrderStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertNutritiionOrderIntent(src.getIntent()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(convertDateTime(src.getDateTimeElement()));
    if (src.hasOrderer())
      tgt.setOrderer(convertReference(src.getOrderer()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAllergyIntolerance())
      tgt.addAllergyIntolerance(convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getFoodPreferenceModifier())
      tgt.addFoodPreferenceModifier(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getExcludeFoodModifier())
      tgt.addExcludeFoodModifier(convertCodeableConcept(t));
    if (src.hasOralDiet())
      tgt.setOralDiet(convertNutritionOrderOralDietComponent(src.getOralDiet()));
    for (org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent t : src.getSupplement())
      tgt.addSupplement(convertNutritionOrderSupplementComponent(t));
    if (src.hasEnteralFormula())
      tgt.setEnteralFormula(convertNutritionOrderEnteralFormulaComponent(src.getEnteralFormula()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder convertNutritionOrder(org.hl7.fhir.r5.model.NutritionOrder src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder tgt = new org.hl7.fhir.r4.model.NutritionOrder();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiates())
      tgt.getInstantiates().add(convertUri(t));
    if (src.hasStatus())
      tgt.setStatus(convertNutritionOrderStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertNutritiionOrderIntent(src.getIntent()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(convertDateTime(src.getDateTimeElement()));
    if (src.hasOrderer())
      tgt.setOrderer(convertReference(src.getOrderer()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAllergyIntolerance())
      tgt.addAllergyIntolerance(convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getFoodPreferenceModifier())
      tgt.addFoodPreferenceModifier(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getExcludeFoodModifier())
      tgt.addExcludeFoodModifier(convertCodeableConcept(t));
    if (src.hasOralDiet())
      tgt.setOralDiet(convertNutritionOrderOralDietComponent(src.getOralDiet()));
    for (org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent t : src.getSupplement())
      tgt.addSupplement(convertNutritionOrderSupplementComponent(t));
    if (src.hasEnteralFormula())
      tgt.setEnteralFormula(convertNutritionOrderEnteralFormulaComponent(src.getEnteralFormula()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus convertNutritionOrderStatus(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus convertNutritionOrderStatus(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent convertNutritiionOrderIntent(org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.OPTION;
    default: return org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent.NULL;
  }
}

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent convertNutritiionOrderIntent(org.hl7.fhir.r5.model.NutritionOrder.NutritiionOrderIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.OPTION;
    default: return org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent.NULL;
  }
}

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent convertNutritionOrderOralDietComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Timing t : src.getSchedule())
      tgt.addSchedule(convertTiming(t));
    for (org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent t : src.getNutrient())
      tgt.addNutrient(convertNutritionOrderOralDietNutrientComponent(t));
    for (org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent t : src.getTexture())
      tgt.addTexture(convertNutritionOrderOralDietTextureComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getFluidConsistencyType())
      tgt.addFluidConsistencyType(convertCodeableConcept(t));
    if (src.hasInstruction())
      tgt.setInstructionElement(convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietComponent convertNutritionOrderOralDietComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Timing t : src.getSchedule())
      tgt.addSchedule(convertTiming(t));
    for (org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent t : src.getNutrient())
      tgt.addNutrient(convertNutritionOrderOralDietNutrientComponent(t));
    for (org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent t : src.getTexture())
      tgt.addTexture(convertNutritionOrderOralDietTextureComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getFluidConsistencyType())
      tgt.addFluidConsistencyType(convertCodeableConcept(t));
    if (src.hasInstruction())
      tgt.setInstructionElement(convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent convertNutritionOrderOralDietNutrientComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent();
    copyElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(convertCodeableConcept(src.getModifier()));
    if (src.hasAmount())
      tgt.setAmount(convertSimpleQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent convertNutritionOrderOralDietNutrientComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent();
    copyElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(convertCodeableConcept(src.getModifier()));
    if (src.hasAmount())
      tgt.setAmount(convertSimpleQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent convertNutritionOrderOralDietTextureComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent();
    copyElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(convertCodeableConcept(src.getModifier()));
    if (src.hasFoodType())
      tgt.setFoodType(convertCodeableConcept(src.getFoodType()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent convertNutritionOrderOralDietTextureComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent();
    copyElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(convertCodeableConcept(src.getModifier()));
    if (src.hasFoodType())
      tgt.setFoodType(convertCodeableConcept(src.getFoodType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent convertNutritionOrderSupplementComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasProductName())
      tgt.setProductNameElement(convertString(src.getProductNameElement()));
    for (org.hl7.fhir.r4.model.Timing t : src.getSchedule())
      tgt.addSchedule(convertTiming(t));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasInstruction())
      tgt.setInstructionElement(convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent convertNutritionOrderSupplementComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasProductName())
      tgt.setProductNameElement(convertString(src.getProductNameElement()));
    for (org.hl7.fhir.r5.model.Timing t : src.getSchedule())
      tgt.addSchedule(convertTiming(t));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasInstruction())
      tgt.setInstructionElement(convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaComponent convertNutritionOrderEnteralFormulaComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaComponent();
    copyElement(src, tgt);
    if (src.hasBaseFormulaType())
      tgt.setBaseFormulaType(convertCodeableConcept(src.getBaseFormulaType()));
    if (src.hasBaseFormulaProductName())
      tgt.setBaseFormulaProductNameElement(convertString(src.getBaseFormulaProductNameElement()));
    if (src.hasAdditiveType())
      tgt.setAdditiveType(convertCodeableConcept(src.getAdditiveType()));
    if (src.hasAdditiveProductName())
      tgt.setAdditiveProductNameElement(convertString(src.getAdditiveProductNameElement()));
    if (src.hasCaloricDensity())
      tgt.setCaloricDensity(convertSimpleQuantity(src.getCaloricDensity()));
    if (src.hasRouteofAdministration())
      tgt.setRouteofAdministration(convertCodeableConcept(src.getRouteofAdministration()));
    for (org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent t : src.getAdministration())
      tgt.addAdministration(convertNutritionOrderEnteralFormulaAdministrationComponent(t));
    if (src.hasMaxVolumeToDeliver())
      tgt.setMaxVolumeToDeliver(convertSimpleQuantity(src.getMaxVolumeToDeliver()));
    if (src.hasAdministrationInstruction())
      tgt.setAdministrationInstructionElement(convertString(src.getAdministrationInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaComponent convertNutritionOrderEnteralFormulaComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaComponent();
    copyElement(src, tgt);
    if (src.hasBaseFormulaType())
      tgt.setBaseFormulaType(convertCodeableConcept(src.getBaseFormulaType()));
    if (src.hasBaseFormulaProductName())
      tgt.setBaseFormulaProductNameElement(convertString(src.getBaseFormulaProductNameElement()));
    if (src.hasAdditiveType())
      tgt.setAdditiveType(convertCodeableConcept(src.getAdditiveType()));
    if (src.hasAdditiveProductName())
      tgt.setAdditiveProductNameElement(convertString(src.getAdditiveProductNameElement()));
    if (src.hasCaloricDensity())
      tgt.setCaloricDensity(convertSimpleQuantity(src.getCaloricDensity()));
    if (src.hasRouteofAdministration())
      tgt.setRouteofAdministration(convertCodeableConcept(src.getRouteofAdministration()));
    for (org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent t : src.getAdministration())
      tgt.addAdministration(convertNutritionOrderEnteralFormulaAdministrationComponent(t));
    if (src.hasMaxVolumeToDeliver())
      tgt.setMaxVolumeToDeliver(convertSimpleQuantity(src.getMaxVolumeToDeliver()));
    if (src.hasAdministrationInstruction())
      tgt.setAdministrationInstructionElement(convertString(src.getAdministrationInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent convertNutritionOrderEnteralFormulaAdministrationComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent();
    copyElement(src, tgt);
    if (src.hasSchedule())
      tgt.setSchedule(convertTiming(src.getSchedule()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasRate())
      tgt.setRate(convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent convertNutritionOrderEnteralFormulaAdministrationComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent();
    copyElement(src, tgt);
    if (src.hasSchedule())
      tgt.setSchedule(convertTiming(src.getSchedule()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasRate())
      tgt.setRate(convertType(src.getRate()));
    return tgt;
  }


}
