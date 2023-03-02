package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Timing43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
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
public class NutritionOrder43_50 {

  public static org.hl7.fhir.r5.model.NutritionOrder convertNutritionOrder(org.hl7.fhir.r4b.model.NutritionOrder src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder tgt = new org.hl7.fhir.r5.model.NutritionOrder();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiates()) tgt.getInstantiates().add(Uri43_50.convertUri(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertNutritionOrderStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertNutritiionOrderIntent(src.getIntentElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference43_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(DateTime43_50.convertDateTime(src.getDateTimeElement()));
    if (src.hasOrderer())
      tgt.setOrderer(Reference43_50.convertReference(src.getOrderer()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAllergyIntolerance())
      tgt.addAllergyIntolerance(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getFoodPreferenceModifier())
      tgt.addFoodPreferenceModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getExcludeFoodModifier())
      tgt.addExcludeFoodModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasOralDiet())
      tgt.setOralDiet(convertNutritionOrderOralDietComponent(src.getOralDiet()));
    for (org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent t : src.getSupplement())
      tgt.addSupplement(convertNutritionOrderSupplementComponent(t));
    if (src.hasEnteralFormula())
      tgt.setEnteralFormula(convertNutritionOrderEnteralFormulaComponent(src.getEnteralFormula()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder convertNutritionOrder(org.hl7.fhir.r5.model.NutritionOrder src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder tgt = new org.hl7.fhir.r4b.model.NutritionOrder();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiates()) tgt.getInstantiates().add(Uri43_50.convertUri(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertNutritionOrderStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertNutritiionOrderIntent(src.getIntentElement()));
    if (src.hasSubject())
      tgt.setPatient(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(DateTime43_50.convertDateTime(src.getDateTimeElement()));
    if (src.hasOrderer())
      tgt.setOrderer(Reference43_50.convertReference(src.getOrderer()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAllergyIntolerance())
      tgt.addAllergyIntolerance(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getFoodPreferenceModifier())
      tgt.addFoodPreferenceModifier(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getExcludeFoodModifier())
      tgt.addExcludeFoodModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasOralDiet())
      tgt.setOralDiet(convertNutritionOrderOralDietComponent(src.getOralDiet()));
    for (org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent t : src.getSupplement())
      tgt.addSupplement(convertNutritionOrderSupplementComponent(t));
    if (src.hasEnteralFormula())
      tgt.setEnteralFormula(convertNutritionOrderEnteralFormulaComponent(src.getEnteralFormula()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertNutritionOrderStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ONHOLD);
        break;
      case REVOKED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> convertNutritionOrderStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ONHOLD);
        break;
      case REVOKED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.REVOKED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> convertNutritiionOrderIntent(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestIntentEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PLAN);
        break;
      case DIRECTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.DIRECTIVE);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORDER);
        break;
      case ORIGINALORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORIGINALORDER);
        break;
      case REFLEXORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.REFLEXORDER);
        break;
      case FILLERORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.FILLERORDER);
        break;
      case INSTANCEORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.INSTANCEORDER);
        break;
      case OPTION:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.OPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> convertNutritiionOrderIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestIntentEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.PLAN);
        break;
      case DIRECTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.DIRECTIVE);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.ORDER);
        break;
      case ORIGINALORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.ORIGINALORDER);
        break;
      case REFLEXORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.REFLEXORDER);
        break;
      case FILLERORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.FILLERORDER);
        break;
      case INSTANCEORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.INSTANCEORDER);
        break;
      case OPTION:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.OPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent convertNutritionOrderOralDietComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Timing t : src.getSchedule()) tgt.getSchedule().addTiming(Timing43_50.convertTiming(t));
    for (org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent t : src.getNutrient())
      tgt.addNutrient(convertNutritionOrderOralDietNutrientComponent(t));
    for (org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent t : src.getTexture())
      tgt.addTexture(convertNutritionOrderOralDietTextureComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getFluidConsistencyType())
      tgt.addFluidConsistencyType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_50.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietComponent convertNutritionOrderOralDietComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Timing t : src.getSchedule().getTiming()) tgt.addSchedule(Timing43_50.convertTiming(t));
    for (org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent t : src.getNutrient())
      tgt.addNutrient(convertNutritionOrderOralDietNutrientComponent(t));
    for (org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent t : src.getTexture())
      tgt.addTexture(convertNutritionOrderOralDietTextureComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getFluidConsistencyType())
      tgt.addFluidConsistencyType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_50.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent convertNutritionOrderOralDietNutrientComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept43_50.convertCodeableConcept(src.getModifier()));
    if (src.hasAmount())
      tgt.setAmount(SimpleQuantity43_50.convertSimpleQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent convertNutritionOrderOralDietNutrientComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietNutrientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept43_50.convertCodeableConcept(src.getModifier()));
    if (src.hasAmount())
      tgt.setAmount(SimpleQuantity43_50.convertSimpleQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent convertNutritionOrderOralDietTextureComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept43_50.convertCodeableConcept(src.getModifier()));
    if (src.hasFoodType())
      tgt.setFoodType(CodeableConcept43_50.convertCodeableConcept(src.getFoodType()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent convertNutritionOrderOralDietTextureComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderOralDietTextureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept43_50.convertCodeableConcept(src.getModifier()));
    if (src.hasFoodType())
      tgt.setFoodType(CodeableConcept43_50.convertCodeableConcept(src.getFoodType()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent convertNutritionOrderSupplementComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConceptToCodeableReference(src.getType()));
    if (src.hasProductName())
      tgt.setProductNameElement(String43_50.convertString(src.getProductNameElement()));
    for (org.hl7.fhir.r4b.model.Timing t : src.getSchedule()) tgt.getSchedule().addTiming(Timing43_50.convertTiming(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_50.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent convertNutritionOrderSupplementComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderSupplementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableReferenceToCodeableConcept(src.getType()));
    if (src.hasProductName())
      tgt.setProductNameElement(String43_50.convertString(src.getProductNameElement()));
    for (org.hl7.fhir.r5.model.Timing t : src.getSchedule().getTiming()) tgt.addSchedule(Timing43_50.convertTiming(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_50.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaComponent convertNutritionOrderEnteralFormulaComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasBaseFormulaType())
      tgt.setBaseFormulaType(CodeableConcept43_50.convertCodeableConceptToCodeableReference(src.getBaseFormulaType()));
    if (src.hasBaseFormulaProductName())
      tgt.setBaseFormulaProductNameElement(String43_50.convertString(src.getBaseFormulaProductNameElement()));
//    if (src.hasAdditiveType())
//      tgt.setAdditiveType(CodeableConcept43_50.convertCodeableConcept(src.getAdditiveType()));
//    if (src.hasAdditiveProductName())
//      tgt.setAdditiveProductNameElement(String43_50.convertString(src.getAdditiveProductNameElement()));
    if (src.hasCaloricDensity())
      tgt.setCaloricDensity(SimpleQuantity43_50.convertSimpleQuantity(src.getCaloricDensity()));
    if (src.hasRouteofAdministration())
      tgt.setRouteOfAdministration(CodeableConcept43_50.convertCodeableConcept(src.getRouteofAdministration()));
    for (org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent t : src.getAdministration())
      tgt.addAdministration(convertNutritionOrderEnteralFormulaAdministrationComponent(t));
    if (src.hasMaxVolumeToDeliver())
      tgt.setMaxVolumeToDeliver(SimpleQuantity43_50.convertSimpleQuantity(src.getMaxVolumeToDeliver()));
    if (src.hasAdministrationInstruction())
      tgt.setAdministrationInstructionElement(String43_50.convertStringToMarkdown(src.getAdministrationInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaComponent convertNutritionOrderEnteralFormulaComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasBaseFormulaType())
      tgt.setBaseFormulaType(CodeableConcept43_50.convertCodeableReferenceToCodeableConcept(src.getBaseFormulaType()));
    if (src.hasBaseFormulaProductName())
      tgt.setBaseFormulaProductNameElement(String43_50.convertString(src.getBaseFormulaProductNameElement()));
//    if (src.hasAdditiveType())
//      tgt.setAdditiveType(CodeableConcept43_50.convertCodeableConcept(src.getAdditiveType()));
//    if (src.hasAdditiveProductName())
//      tgt.setAdditiveProductNameElement(String43_50.convertString(src.getAdditiveProductNameElement()));
    if (src.hasCaloricDensity())
      tgt.setCaloricDensity(SimpleQuantity43_50.convertSimpleQuantity(src.getCaloricDensity()));
    if (src.hasRouteOfAdministration())
      tgt.setRouteofAdministration(CodeableConcept43_50.convertCodeableConcept(src.getRouteOfAdministration()));
    for (org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent t : src.getAdministration())
      tgt.addAdministration(convertNutritionOrderEnteralFormulaAdministrationComponent(t));
    if (src.hasMaxVolumeToDeliver())
      tgt.setMaxVolumeToDeliver(SimpleQuantity43_50.convertSimpleQuantity(src.getMaxVolumeToDeliver()));
    if (src.hasAdministrationInstruction())
      tgt.setAdministrationInstructionElement(String43_50.convertString(src.getAdministrationInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent convertNutritionOrderEnteralFormulaAdministrationComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent tgt = new org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSchedule())
      tgt.getSchedule().addTiming(Timing43_50.convertTiming(src.getSchedule()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent convertNutritionOrderEnteralFormulaAdministrationComponent(org.hl7.fhir.r5.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.getSchedule().hasTiming())
      tgt.setSchedule(Timing43_50.convertTiming(src.getSchedule().getTimingFirstRep()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getRate()));
    return tgt;
  }
}