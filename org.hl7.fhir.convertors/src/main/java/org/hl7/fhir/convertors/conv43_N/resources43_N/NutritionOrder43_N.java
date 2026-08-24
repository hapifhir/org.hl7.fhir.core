package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Timing43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.NutritionOrder;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class NutritionOrder43_N {

  public static org.hl7.fhir.model.core.NutritionOrder convertNutritionOrder(org.hl7.fhir.r4b.model.NutritionOrder src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder tgt = new org.hl7.fhir.model.core.NutritionOrder();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertNutritionOrderStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertNutritiionOrderIntent(src.getIntentElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference43_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(DateTime43_N.convertDateTime(src.getDateTimeElement()));
    if (src.hasOrderer())
      tgt.setRequester(Reference43_N.convertReference(src.getOrderer()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAllergyIntolerance())
      tgt.addAllergyIntolerance(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getFoodPreferenceModifier())
      tgt.addFoodPreferenceModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getExcludeFoodModifier())
      tgt.addExcludeFoodModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasOralDiet())
      tgt.setOralDiet(convertNutritionOrderOralDietComponent(src.getOralDiet()));
    for (org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent t : src.getSupplement())
      tgt.addSupplement(convertNutritionOrderSupplementComponent(t));
    if (src.hasEnteralFormula())
      tgt.setEnteralFormula(convertNutritionOrderEnteralFormulaComponent(src.getEnteralFormula()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder convertNutritionOrder(org.hl7.fhir.model.core.NutritionOrder src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder tgt = new org.hl7.fhir.r4b.model.NutritionOrder();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertNutritionOrderStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertNutritiionOrderIntent(src.getIntentElement()));
    if (src.hasSubject())
      tgt.setPatient(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(DateTime43_N.convertDateTime(src.getDateTimeElement()));
    if (src.hasRequester())
      tgt.setOrderer(Reference43_N.convertReference(src.getRequester()));
    for (org.hl7.fhir.model.core.Reference t : src.getAllergyIntoleranceList())
      tgt.addAllergyIntolerance(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getFoodPreferenceModifierList())
      tgt.addFoodPreferenceModifier(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getExcludeFoodModifierList())
      tgt.addExcludeFoodModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasOralDiet())
      tgt.setOralDiet(convertNutritionOrderOralDietComponent(src.getOralDiet()));
    for (org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent t : src.getSupplementList())
      tgt.addSupplement(convertNutritionOrderSupplementComponent(t));
    if (src.hasEnteralFormula())
      tgt.setEnteralFormula(convertNutritionOrderEnteralFormulaComponent(src.getEnteralFormula()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> convertNutritionOrderStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestStatus> tgt = new Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(Enumerations.RequestStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(Enumerations.RequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(Enumerations.RequestStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(Enumerations.RequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(Enumerations.RequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.RequestStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.RequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> convertNutritionOrderStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> convertNutritiionOrderIntent(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestIntent> tgt = new Enumeration<>(new Enumerations.RequestIntentEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(Enumerations.RequestIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(Enumerations.RequestIntent.PLAN);
                  break;
              case DIRECTIVE:
                  tgt.setValue(Enumerations.RequestIntent.DIRECTIVE);
                  break;
              case ORDER:
                  tgt.setValue(Enumerations.RequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(Enumerations.RequestIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(Enumerations.RequestIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(Enumerations.RequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(Enumerations.RequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(Enumerations.RequestIntent.OPTION);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> convertNutritiionOrderIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestIntentEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietComponent convertNutritionOrderOralDietComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Timing t : src.getSchedule()) tgt.getSchedule().addTiming(Timing43_N.convertTiming(t));
    for (org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent t : src.getNutrient())
      tgt.addNutrient(convertNutritionOrderOralDietNutrientComponent(t));
    for (org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent t : src.getTexture())
      tgt.addTexture(convertNutritionOrderOralDietTextureComponent(t));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_N.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietComponent convertNutritionOrderOralDietComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Timing t : src.getSchedule().getTimingList()) tgt.addSchedule(Timing43_N.convertTiming(t));
    for (org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent t : src.getNutrientList())
      tgt.addNutrient(convertNutritionOrderOralDietNutrientComponent(t));
    for (org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent t : src.getTextureList())
      tgt.addTexture(convertNutritionOrderOralDietTextureComponent(t));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_N.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent convertNutritionOrderOralDietNutrientComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept43_N.convertCodeableConcept(src.getModifier()));
    if (src.hasAmount())
      tgt.setAmount(SimpleQuantity43_N.convertSimpleQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent convertNutritionOrderOralDietNutrientComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietNutrientComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept43_N.convertCodeableConcept(src.getModifier()));
    if (src.hasAmount())
      tgt.setAmount(SimpleQuantity43_N.convertSimpleQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent convertNutritionOrderOralDietTextureComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept43_N.convertCodeableConcept(src.getModifier()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent convertNutritionOrderOralDietTextureComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderOralDietTextureComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept43_N.convertCodeableConcept(src.getModifier()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent convertNutritionOrderSupplementComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConceptToCodeableReference(src.getType()));
    if (src.hasProductName())
      tgt.setProductNameElement(String43_N.convertString(src.getProductNameElement()));
    for (org.hl7.fhir.r4b.model.Timing t : src.getSchedule()) tgt.getSchedule().addTiming(Timing43_N.convertTiming(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_N.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent convertNutritionOrderSupplementComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderSupplementComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableReferenceToCodeableConcept(src.getType()));
    if (src.hasProductName())
      tgt.setProductNameElement(String43_N.convertString(src.getProductNameElement()));
    for (org.hl7.fhir.model.core.Timing t : src.getSchedule().getTimingList()) tgt.addSchedule(Timing43_N.convertTiming(t));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String43_N.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaComponent convertNutritionOrderEnteralFormulaComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasBaseFormulaType())
      tgt.setType(CodeableConcept43_N.convertCodeableConceptToCodeableReference(src.getBaseFormulaType()));
    if (src.hasBaseFormulaProductName())
      tgt.setProductNameElement(String43_N.convertString(src.getBaseFormulaProductNameElement()));
//    if (src.hasAdditiveType())
//      tgt.setAdditiveType(CodeableConcept43_N.convertCodeableConcept(src.getAdditiveType()));
//    if (src.hasAdditiveProductName())
//      tgt.setAdditiveProductNameElement(String43_N.convertString(src.getAdditiveProductNameElement()));
    if (src.hasCaloricDensity())
      tgt.setCaloricDensity(SimpleQuantity43_N.convertSimpleQuantity(src.getCaloricDensity()));
    if (src.hasRouteofAdministration())
      tgt.addRouteOfAdministration(CodeableConcept43_N.convertCodeableConcept(src.getRouteofAdministration()));
    for (org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent t : src.getAdministration())
      tgt.addAdministration(convertNutritionOrderEnteralFormulaAdministrationComponent(t));
    if (src.hasMaxVolumeToDeliver())
      tgt.setMaxVolumeToAdminister(SimpleQuantity43_N.convertSimpleQuantity(src.getMaxVolumeToDeliver()));
    if (src.hasAdministrationInstruction())
      tgt.setAdministrationInstructionElement(String43_N.convertStringToMarkdown(src.getAdministrationInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaComponent convertNutritionOrderEnteralFormulaComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setBaseFormulaType(CodeableConcept43_N.convertCodeableReferenceToCodeableConcept(src.getType()));
    if (src.hasProductName())
      tgt.setBaseFormulaProductNameElement(String43_N.convertString(src.getProductNameElement()));
      tgt.setBaseFormulaProductNameElement(String43_N.convertString(src.getProductNameElement()));
//    if (src.hasAdditeProductNameElement(String43_N.convertString(src.getAdditiveProductNameElement()));
    if (src.hasCaloricDensity())
      tgt.setCaloricDensity(SimpleQuantity43_N.convertSimpleQuantity(src.getCaloricDensity()));
    if (src.hasRouteOfAdministration())
      tgt.setRouteofAdministration(CodeableConcept43_N.convertCodeableConcept(src.getRouteOfAdministrationFirstRep()));
    for (org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent t : src.getAdministrationList())
      tgt.addAdministration(convertNutritionOrderEnteralFormulaAdministrationComponent(t));
    if (src.hasMaxVolumeToAdminister())
      tgt.setMaxVolumeToDeliver(SimpleQuantity43_N.convertSimpleQuantity(src.getMaxVolumeToAdminister()));
    if (src.hasAdministrationInstruction())
      tgt.setAdministrationInstructionElement(String43_N.convertString(src.getAdministrationInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent convertNutritionOrderEnteralFormulaAdministrationComponent(org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSchedule())
      tgt.getSchedule().addTiming(Timing43_N.convertTiming(src.getSchedule()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent convertNutritionOrderEnteralFormulaAdministrationComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent tgt = new org.hl7.fhir.r4b.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.getSchedule().hasTiming())
      tgt.setSchedule(Timing43_N.convertTiming(src.getSchedule().getTimingFirstRep()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getRate()));
    return tgt;
  }
}