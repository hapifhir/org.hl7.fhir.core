package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Timing40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.NutritionOrder;
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

public class NutritionOrder40_N {

  public static org.hl7.fhir.model.core.NutritionOrder convertNutritionOrder(org.hl7.fhir.r4.model.NutritionOrder src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder tgt = new org.hl7.fhir.model.core.NutritionOrder();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("NutritionOrder", "5.0", new String[] {"basedOn", "groupIdentifier", "priority", "supportingInformation", "performer", "outsideFoodAllowed"}, CrossVersionElements40_N.urls("NutritionOrder", "6.0", new String[] {}, CrossVersionElements40_N.url("NutritionOrder", "6.0", "additive"))));
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "NutritionOrder", tgt.getExtension(), "instantiatesCanonical", "instantiatesUri", "instantiates");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "basedOn", "groupIdentifier", "priority", "supportingInformation", "performer", "outsideFoodAllowed");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertNutritionOrderStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasIntent())
      tgt.setIntentElement(CrossVersionElements40_N.toR6Code(src.getIntentElement(), convertNutritiionOrderIntent(src.getIntentElement()), src.fhirType(), "intent"));
    if (src.hasPatient())
      tgt.setSubject(Reference40_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(DateTime40_N.convertDateTime(src.getDateTimeElement()));
    if (src.hasOrderer())
      tgt.setRequester(Reference40_N.convertReference(src.getOrderer()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAllergyIntolerance())
      tgt.addAllergyIntolerance(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getFoodPreferenceModifier())
      tgt.addFoodPreferenceModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getExcludeFoodModifier())
      tgt.addExcludeFoodModifier(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasOralDiet())
      tgt.setOralDiet(convertNutritionOrderOralDietComponent(src.getOralDiet()));
    for (org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent t : src.getSupplement())
      tgt.addSupplement(convertNutritionOrderSupplementComponent(t));
    if (src.hasEnteralFormula())
      tgt.setEnteralFormula(convertNutritionOrderEnteralFormulaComponent(src.getEnteralFormula()));
    // R4 enteralFormula.additiveType/additiveProductName is the first R6 additive; the others are 6.0 extensions
    if (src.hasEnteralFormula() && (src.getEnteralFormula().hasAdditiveType() || src.getEnteralFormula().hasAdditiveProductName())) {
      org.hl7.fhir.model.core.NutritionOrder.NutritionOrderAdditiveComponent a = tgt.addAdditive();
      if (src.getEnteralFormula().hasAdditiveType())
        a.setModularType(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getEnteralFormula().getAdditiveType()));
      if (src.getEnteralFormula().hasAdditiveProductName())
        a.setProductNameElement(String40_N.convertString(src.getEnteralFormula().getAdditiveProductNameElement()));
    }
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "additive");
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder convertNutritionOrder(org.hl7.fhir.model.core.NutritionOrder src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder tgt = new org.hl7.fhir.r4.model.NutritionOrder();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("NutritionOrder", "4.0", new String[] {"instantiatesCanonical", "instantiatesUri", "instantiates"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "NutritionOrder", "instantiatesCanonical", "instantiatesUri", "instantiates");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "basedOn", "groupIdentifier", "priority", "supportingInformation", "performer", "outsideFoodAllowed");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertNutritionOrderStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasIntent())
      tgt.setIntentElement(CrossVersionElements40_N.toR4Code(src.getIntentElement(), convertNutritiionOrderIntent(src.getIntentElement()), src.fhirType(), "intent"));
    if (src.hasSubject())
      tgt.setPatient(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(DateTime40_N.convertDateTime(src.getDateTimeElement()));
    if (src.hasRequester())
      tgt.setOrderer(Reference40_N.convertReference(src.getRequester()));
    for (org.hl7.fhir.model.core.Reference t : src.getAllergyIntoleranceList())
      tgt.addAllergyIntolerance(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getFoodPreferenceModifierList())
      tgt.addFoodPreferenceModifier(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getExcludeFoodModifierList())
      tgt.addExcludeFoodModifier(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasOralDiet())
      tgt.setOralDiet(convertNutritionOrderOralDietComponent(src.getOralDiet()));
    for (org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent t : src.getSupplementList())
      tgt.addSupplement(convertNutritionOrderSupplementComponent(t));
    if (src.hasEnteralFormula())
      tgt.setEnteralFormula(convertNutritionOrderEnteralFormulaComponent(src.getEnteralFormula()));
    // the first additive goes in R4 enteralFormula.additiveType/additiveProductName, if there's an enteral formula
    // and that's all there is to it; the others are 6.0 extensions
    boolean first = true;
    for (org.hl7.fhir.model.core.NutritionOrder.NutritionOrderAdditiveComponent t : src.getAdditiveList()) {
      if (first && tgt.hasEnteralFormula() && isSimpleAdditive(t)) {
        if (t.hasModularType())
          tgt.getEnteralFormula().setAdditiveType(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t.getModularType()));
        if (t.hasProductName())
          tgt.getEnteralFormula().setAdditiveProductNameElement(String40_N.convertString(t.getProductNameElement()));
      } else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("NutritionOrder", "6.0", "additive"), t));
      first = false;
    }
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> convertNutritionOrderStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestStatus> tgt = new Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderStatus> convertNutritionOrderStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<NutritionOrder.NutritionOrderStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new NutritionOrder.NutritionOrderStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(NutritionOrder.NutritionOrderStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(NutritionOrder.NutritionOrderStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(NutritionOrder.NutritionOrderStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(NutritionOrder.NutritionOrderStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(NutritionOrder.NutritionOrderStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(NutritionOrder.NutritionOrderStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(NutritionOrder.NutritionOrderStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(NutritionOrder.NutritionOrderStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> convertNutritiionOrderIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestIntent> tgt = new Enumeration<>(new Enumerations.RequestIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NutritionOrder.NutritiionOrderIntent> convertNutritiionOrderIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<NutritionOrder.NutritiionOrderIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new NutritionOrder.NutritiionOrderIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.PLAN);
                  break;
              case DIRECTIVE:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.DIRECTIVE);
                  break;
              case ORDER:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.OPTION);
                  break;
              default:
                  tgt.setValue(NutritionOrder.NutritiionOrderIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietComponent convertNutritionOrderOralDietComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("NutritionOrder.oralDiet", "6.0", "caloricDensity"), CrossVersionElements40_N.url("NutritionOrder.oralDiet.schedule", "5.0", "asNeeded"), CrossVersionElements40_N.url("NutritionOrder.oralDiet.schedule", "5.0", "asNeededFor"));
    CrossVersionElements40_N.r4ElementsToExtensions(src, "NutritionOrder.oralDiet", tgt.getExtension(), "fluidConsistencyType");
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "NutritionOrder.oralDiet", "6.0", "caloricDensity");
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Timing t : src.getSchedule()) tgt.getSchedule().addTiming(Timing40_N.convertTiming(t));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt.getSchedule(), "NutritionOrder.oralDiet.schedule", "5.0", "asNeeded", "asNeededFor");
    for (org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent t : src.getNutrient())
      tgt.addNutrient(convertNutritionOrderOralDietNutrientComponent(t));
    for (org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent t : src.getTexture())
      tgt.addTexture(convertNutritionOrderOralDietTextureComponent(t));
    if (src.hasInstruction())
      tgt.setInstructionElement(String40_N.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietComponent convertNutritionOrderOralDietComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("NutritionOrder.oralDiet", "4.0", "fluidConsistencyType"));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "NutritionOrder.oralDiet", "fluidConsistencyType");
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "NutritionOrder.oralDiet", tgt.getExtension(), "6.0", "caloricDensity");
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Timing t : src.getSchedule().getTimingList()) tgt.addSchedule(Timing40_N.convertTiming(t));
    if (src.hasSchedule())
      CrossVersionElements40_N.elementsToExtensionsForPath(src.getSchedule(), "NutritionOrder.oralDiet.schedule", tgt.getExtension(), "5.0", "asNeeded", "asNeededFor");
    for (org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent t : src.getNutrientList())
      tgt.addNutrient(convertNutritionOrderOralDietNutrientComponent(t));
    for (org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent t : src.getTextureList())
      tgt.addTexture(convertNutritionOrderOralDietTextureComponent(t));
    if (src.hasInstruction())
      tgt.setInstructionElement(String40_N.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent convertNutritionOrderOralDietNutrientComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept40_N.convertCodeableConcept(src.getModifier()));
    if (src.hasAmount())
      tgt.setAmount(SimpleQuantity40_N.convertSimpleQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent convertNutritionOrderOralDietNutrientComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietNutrientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietNutrientComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept40_N.convertCodeableConcept(src.getModifier()));
    if (src.hasAmount())
      tgt.setAmount(SimpleQuantity40_N.convertSimpleQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent convertNutritionOrderOralDietTextureComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept40_N.convertCodeableConcept(src.getModifier()));
    if (src.hasFoodType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getFoodType()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent convertNutritionOrderOralDietTextureComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderOralDietTextureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderOralDietTextureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasModifier())
      tgt.setModifier(CodeableConcept40_N.convertCodeableConcept(src.getModifier()));
    if (src.hasType())
      tgt.setFoodType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent convertNutritionOrderSupplementComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("NutritionOrder.supplement", "6.0", "caloricDensity"), CrossVersionElements40_N.url("NutritionOrder.supplement.schedule", "5.0", "asNeeded"), CrossVersionElements40_N.url("NutritionOrder.supplement.schedule", "5.0", "asNeededFor"));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "NutritionOrder.supplement", "6.0", "caloricDensity");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getType()));
    if (src.hasProductName())
      tgt.setProductNameElement(String40_N.convertString(src.getProductNameElement()));
    for (org.hl7.fhir.r4.model.Timing t : src.getSchedule()) tgt.getSchedule().addTiming(Timing40_N.convertTiming(t));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt.getSchedule(), "NutritionOrder.supplement.schedule", "5.0", "asNeeded", "asNeededFor");
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String40_N.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent convertNutritionOrderSupplementComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderSupplementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderSupplementComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "NutritionOrder.supplement", tgt.getExtension(), "6.0", "caloricDensity");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(src.getType()));
    if (src.hasProductName())
      tgt.setProductNameElement(String40_N.convertString(src.getProductNameElement()));
    for (org.hl7.fhir.model.core.Timing t : src.getSchedule().getTimingList()) tgt.addSchedule(Timing40_N.convertTiming(t));
    if (src.hasSchedule())
      CrossVersionElements40_N.elementsToExtensionsForPath(src.getSchedule(), "NutritionOrder.supplement.schedule", tgt.getExtension(), "5.0", "asNeeded", "asNeededFor");
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasInstruction())
      tgt.setInstructionElement(String40_N.convertString(src.getInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaComponent convertNutritionOrderEnteralFormulaComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("NutritionOrder.enteralFormula", "6.0", "type"), CrossVersionElements40_N.url("NutritionOrder.enteralFormula", "5.0", "deliveryDevice"), CrossVersionElements40_N.url("NutritionOrder.enteralFormula", "5.0", "routeOfAdministration"));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "NutritionOrder.enteralFormula", "5.0", "deliveryDevice");
    if (src.hasBaseFormulaType())
      tgt.addType(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getBaseFormulaType()));
    // the types R4's single baseFormulaType couldn't hold
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "NutritionOrder.enteralFormula", "6.0", "type");
    if (src.hasBaseFormulaProductName())
      tgt.setProductNameElement(String40_N.convertString(src.getBaseFormulaProductNameElement()));
    // additiveType and additiveProductName are the first NutritionOrder.additive (see convertNutritionOrder)
    if (src.hasCaloricDensity())
      tgt.setCaloricDensity(SimpleQuantity40_N.convertSimpleQuantity(src.getCaloricDensity()));
    if (src.hasRouteofAdministration())
      tgt.addRouteOfAdministration(CodeableConcept40_N.convertCodeableConcept(src.getRouteofAdministration()));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "NutritionOrder.enteralFormula", "5.0", "routeOfAdministration");
    for (org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent t : src.getAdministration())
      tgt.addAdministration(convertNutritionOrderEnteralFormulaAdministrationComponent(t));
    if (src.hasMaxVolumeToDeliver())
      tgt.setMaxVolumeToAdminister(SimpleQuantity40_N.convertSimpleQuantity(src.getMaxVolumeToDeliver()));
    if (src.hasAdministrationInstruction())
      tgt.setAdministrationInstructionElement(String40_N.convertStringToMarkdown(src.getAdministrationInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaComponent convertNutritionOrderEnteralFormulaComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "NutritionOrder.enteralFormula", tgt.getExtension(), "5.0", "deliveryDevice");
    // R4 baseFormulaType is single: the first type, and the rest in 6.0 extensions
    for (org.hl7.fhir.model.core.CodeableReference t : src.getTypeList()) {
      if (!tgt.hasBaseFormulaType())
        tgt.setBaseFormulaType(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("NutritionOrder.enteralFormula", "6.0", "type"), t));
    }
    if (src.hasProductName())
      tgt.setBaseFormulaProductNameElement(String40_N.convertString(src.getProductNameElement()));
    if (src.hasCaloricDensity())
      tgt.setCaloricDensity(SimpleQuantity40_N.convertSimpleQuantity(src.getCaloricDensity()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRouteOfAdministrationList()) {
      if (!tgt.hasRouteofAdministration())
        tgt.setRouteofAdministration(CodeableConcept40_N.convertCodeableConcept(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("NutritionOrder.enteralFormula", "5.0", "routeOfAdministration"), CodeableConcept40_N.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent t : src.getAdministrationList())
      tgt.addAdministration(convertNutritionOrderEnteralFormulaAdministrationComponent(t));
    if (src.hasMaxVolumeToAdminister())
      tgt.setMaxVolumeToDeliver(SimpleQuantity40_N.convertSimpleQuantity(src.getMaxVolumeToAdminister()));
    if (src.hasAdministrationInstruction())
      tgt.setAdministrationInstructionElement(String40_N.convertString(src.getAdministrationInstructionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent convertNutritionOrderEnteralFormulaAdministrationComponent(org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent tgt = new org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("NutritionOrder.enteralFormula.administration.schedule", "5.0", new String[] {"timing", "asNeeded", "asNeededFor"}));
    if (src.hasSchedule())
      tgt.getSchedule().addTiming(Timing40_N.convertTiming(src.getSchedule()));
    // the other timings, and asNeeded
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt.getSchedule(), "NutritionOrder.enteralFormula.administration.schedule", "5.0", "timing", "asNeeded", "asNeededFor");
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "rate", tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent convertNutritionOrderEnteralFormulaAdministrationComponent(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent tgt = new org.hl7.fhir.r4.model.NutritionOrder.NutritionOrderEnteralFormulaAdministrationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    // R4 schedule is a single Timing: the first, and the rest (and asNeeded) in 5.0 extensions
    if (src.hasSchedule()) {
      for (org.hl7.fhir.model.core.Timing t : src.getSchedule().getTimingList()) {
        if (!tgt.hasSchedule())
          tgt.setSchedule(Timing40_N.convertTiming(t));
        else
          tgt.addExtension(CrossVersionElements40_N.url("NutritionOrder.enteralFormula.administration.schedule", "5.0", "timing"), Timing40_N.convertTiming(t));
      }
      CrossVersionElements40_N.elementsToExtensionsForPath(src.getSchedule(), "NutritionOrder.enteralFormula.administration.schedule", tgt.getExtension(), "5.0", "asNeeded", "asNeededFor");
    }
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "rate", tgt, tgt.getExtension());
    return tgt;
  }

  private static boolean isSimpleAdditive(org.hl7.fhir.model.core.NutritionOrder.NutritionOrderAdditiveComponent t) {
    return !t.hasId() && !t.hasExtension() && !t.hasModifierExtension() && !t.hasQuantity() && !t.hasRouteOfAdministration()
      && (t.hasModularType() || t.hasProductName());
  }
}
