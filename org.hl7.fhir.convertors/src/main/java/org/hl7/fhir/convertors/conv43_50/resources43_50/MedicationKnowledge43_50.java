package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.*;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgePackagingComponent;
import org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeStatusCodesEnumFactory;

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
public class MedicationKnowledge43_50 {

  public static org.hl7.fhir.r5.model.MedicationKnowledge convertMedicationKnowledge(org.hl7.fhir.r4b.model.MedicationKnowledge src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge tgt = new org.hl7.fhir.r5.model.MedicationKnowledge();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationKnowledgeStatus(src.getStatusElement()));
//    if (src.hasManufacturer())
//      tgt.setSponsor(Reference43_50.convertReference(src.getManufacturer()));
//    if (src.hasDoseForm())
//      tgt.setDoseForm(CodeableConcept43_50.convertCodeableConcept(src.getDoseForm()));
//    if (src.hasAmount())
//      tgt.setAmount(SimpleQuantity43_50.convertSimpleQuantity(src.getAmount()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getSynonym()) tgt.getName().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent t : src.getRelatedMedicationKnowledge())
      tgt.addRelatedMedicationKnowledge(convertMedicationKnowledgeRelatedMedicationKnowledgeComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAssociatedMedication())
      tgt.addAssociatedMedication(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProductType())
      tgt.addProductType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonographComponent t : src.getMonograph())
      tgt.addMonograph(convertMedicationKnowledgeMonographComponent(t));
//    for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent t : src.getIngredient())
//      tgt.addIngredient(convertMedicationKnowledgeIngredientComponent(t));
    if (src.hasPreparationInstruction())
      tgt.setPreparationInstructionElement(MarkDown43_50.convertMarkdown(src.getPreparationInstructionElement()));
//    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getIntendedRoute())
//      tgt.addIntendedRoute(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeCostComponent t : src.getCost())
      tgt.addCost(convertMedicationKnowledgeCostComponent(t));
    for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent t : src.getMonitoringProgram())
      tgt.addMonitoringProgram(convertMedicationKnowledgeMonitoringProgramComponent(t));
    // for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent t : src.getAdministrationGuidelines())
    // tgt.addAdministrationGuidelines(convertMedicationKnowledgeAdministrationGuidelinesComponent(t));
    for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent t : src.getMedicineClassification())
      tgt.addMedicineClassification(convertMedicationKnowledgeMedicineClassificationComponent(t));
    if (src.hasPackaging())
      tgt.addPackaging(convertMedicationKnowledgePackagingComponent(src.getPackaging()));
//    for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent t : src.getDrugCharacteristic())
//      tgt.addDrugCharacteristic(convertMedicationKnowledgeDrugCharacteristicComponent(t));
    // for (org.hl7.fhir.r4b.model.Reference t : src.getContraindication())
    // tgt.addContraindication(convertReference(t));
    for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent t : src.getRegulatory())
      tgt.addRegulatory(convertMedicationKnowledgeRegulatoryComponent(t));
    // for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent t : src.getKinetics())
    // tgt.addKinetics(convertMedicationKnowledgeKineticsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge convertMedicationKnowledge(org.hl7.fhir.r5.model.MedicationKnowledge src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatusElement(convertMedicationKnowledgeStatus(src.getStatusElement()));
//    if (src.hasSponsor())
//      tgt.setManufacturer(Reference43_50.convertReference(src.getSponsor()));
//    if (src.hasDoseForm())
//      tgt.setDoseForm(CodeableConcept43_50.convertCodeableConcept(src.getDoseForm()));
//    if (src.hasAmount())
//      tgt.setAmount(SimpleQuantity43_50.convertSimpleQuantity(src.getAmount()));
    for (org.hl7.fhir.r5.model.StringType t : src.getName()) tgt.getSynonym().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent t : src.getRelatedMedicationKnowledge())
      tgt.addRelatedMedicationKnowledge(convertMedicationKnowledgeRelatedMedicationKnowledgeComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAssociatedMedication())
      tgt.addAssociatedMedication(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getProductType())
      tgt.addProductType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonographComponent t : src.getMonograph())
      tgt.addMonograph(convertMedicationKnowledgeMonographComponent(t));
//    for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent t : src.getIngredient())
//      tgt.addIngredient(convertMedicationKnowledgeIngredientComponent(t));
    if (src.hasPreparationInstruction())
      tgt.setPreparationInstructionElement(MarkDown43_50.convertMarkdown(src.getPreparationInstructionElement()));
//    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getIntendedRoute())
//      tgt.addIntendedRoute(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeCostComponent t : src.getCost())
      tgt.addCost(convertMedicationKnowledgeCostComponent(t));
    for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent t : src.getMonitoringProgram())
      tgt.addMonitoringProgram(convertMedicationKnowledgeMonitoringProgramComponent(t));
    // for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent t : src.getAdministrationGuidelines())
    // tgt.addAdministrationGuidelines(convertMedicationKnowledgeAdministrationGuidelinesComponent(t));
    for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent t : src.getMedicineClassification())
      tgt.addMedicineClassification(convertMedicationKnowledgeMedicineClassificationComponent(t));
    for (MedicationKnowledgePackagingComponent t : src.getPackaging())
      tgt.setPackaging(convertMedicationKnowledgePackagingComponent(t));
//    for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent t : src.getDrugCharacteristic())
//      tgt.addDrugCharacteristic(convertMedicationKnowledgeDrugCharacteristicComponent(t));
    // for (org.hl7.fhir.r5.model.Reference t : src.getContraindication())
    // tgt.addContraindication(convertReference(t));
    for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent t : src.getRegulatory())
      tgt.addRegulatory(convertMedicationKnowledgeRegulatoryComponent(t));
    // for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent t : src.getKinetics())
    // tgt.addKinetics(convertMedicationKnowledgeKineticsComponent(t));
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeStatusCodes> convertMedicationKnowledgeStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeStatusCodes> src) {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeStatusCodes.ACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeStatusCodes.ENTEREDINERROR);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeStatusCodes.INACTIVE);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeStatusCodes> convertMedicationKnowledgeStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeStatusCodes> src) {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new MedicationKnowledgeStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeStatusCodes.ACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeStatusCodes.ENTEREDINERROR);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeStatusCodes.INACTIVE);
        break;
      case NULL:
        tgt.setValue(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeStatusCodes.NULL);
        break;
    }
    return tgt;
  }


  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent convertMedicationKnowledgeRelatedMedicationKnowledgeComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReference()) tgt.addReference(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent convertMedicationKnowledgeRelatedMedicationKnowledgeComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRelatedMedicationKnowledgeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReference()) tgt.addReference(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonographComponent convertMedicationKnowledgeMonographComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonographComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonographComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonographComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSource())
      tgt.setSource(Reference43_50.convertReference(src.getSource()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonographComponent convertMedicationKnowledgeMonographComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonographComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonographComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonographComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSource())
      tgt.setSource(Reference43_50.convertReference(src.getSource()));
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent convertMedicationKnowledgeIngredientComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasItemCodeableConcept())
//      tgt.getItem().setConcept(CodeableConcept43_50.convertCodeableConcept(src.getItemCodeableConcept()));
//    if (src.hasItemReference())
//      tgt.getItem().setReference(Reference43_50.convertReference(src.getItemReference()));
//    if (src.getIsActive())
//      tgt.setIsActive(new CodeableConcept(new Coding("ttp://terminology.hl7.org/CodeSystem/v3-RoleClass", "ACTI", "active ingredient ")));
//    if (src.hasStrength())
//      tgt.setStrength(Ratio43_50.convertRatio(src.getStrength()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent convertMedicationKnowledgeIngredientComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeIngredientComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.getItem().hasConcept())
//      tgt.setItem(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getItem().getConcept()));
//    if (src.getItem().hasReference())
//      tgt.setItem(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getItem().getReference()));
//    if (src.hasIsActive())
//      tgt.setIsActive(src.getIsActive().hasCoding("http://terminology.hl7.org/CodeSystem/v3-RoleClass", "ACTI"));
//    if (src.hasStrengthRatio())
//      tgt.setStrength(Ratio43_50.convertRatio(src.getStrengthRatio()));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeCostComponent convertMedicationKnowledgeCostComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeCostComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeCostComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeCostComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSource())
      tgt.setSourceElement(String43_50.convertString(src.getSourceElement()));
    if (src.hasCost())
      tgt.setCost(Money43_50.convertMoney(src.getCost()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeCostComponent convertMedicationKnowledgeCostComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeCostComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeCostComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeCostComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSource())
      tgt.setSourceElement(String43_50.convertString(src.getSourceElement()));
    if (src.hasCostMoney())
      tgt.setCost(Money43_50.convertMoney(src.getCostMoney()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent convertMedicationKnowledgeMonitoringProgramComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent convertMedicationKnowledgeMonitoringProgramComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMonitoringProgramComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    return tgt;
  }

  // public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent convertMedicationKnowledgeAdministrationGuidelinesComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent();
  // copyElement(src, tgt);
  // for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent t : src.getDosage())
  // tgt.addDosage(convertMedicationKnowledgeAdministrationGuidelinesDosageComponent(t));
  // if (src.hasIndication())
  // tgt.setIndication(convertType(src.getIndication()));
  // for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent t : src.getPatientCharacteristics())
  // tgt.addPatientCharacteristics(convertMedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent(t));
  // return tgt;
  // }
  //
  // public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent convertMedicationKnowledgeAdministrationGuidelinesComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesComponent();
  // copyElement(src, tgt);
  // for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent t : src.getDosage())
  // tgt.addDosage(convertMedicationKnowledgeAdministrationGuidelinesDosageComponent(t));
  // if (src.hasIndication())
  // tgt.setIndication(convertType(src.getIndication()));
  // for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent t : src.getPatientCharacteristics())
  // tgt.addPatientCharacteristics(convertMedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent(t));
  // return tgt;
  // }
  //
  // public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent convertMedicationKnowledgeAdministrationGuidelinesDosageComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent();
  // copyElement(src, tgt);
  // if (src.hasType())
  // tgt.setType(convertCodeableConcept(src.getType()));
  // for (org.hl7.fhir.r4b.model.Dosage t : src.getDosage())
  // tgt.addDosage(convertDosage(t));
  // return tgt;
  // }
  //
  // public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent convertMedicationKnowledgeAdministrationGuidelinesDosageComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesDosageComponent();
  // copyElement(src, tgt);
  // if (src.hasType())
  // tgt.setType(convertCodeableConcept(src.getType()));
  // for (org.hl7.fhir.r5.model.Dosage t : src.getDosage())
  // tgt.addDosage(convertDosage(t));
  // return tgt;
  // }
  //
  // public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent convertMedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent();
  // copyElement(src, tgt);
  // if (src.hasCharacteristic())
  // tgt.setCharacteristic(convertType(src.getCharacteristic()));
  // for (org.hl7.fhir.r4b.model.StringType t : src.getValue())
  // tgt.getValue().add(convertString(t));
  // return tgt;
  // }
  //
  // public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent convertMedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeAdministrationGuidelinesPatientCharacteristicsComponent();
  // copyElement(src, tgt);
  // if (src.hasCharacteristic())
  // tgt.setCharacteristic(convertType(src.getCharacteristic()));
  // for (org.hl7.fhir.r5.model.StringType t : src.getValue())
  // tgt.getValue().add(convertString(t));
  // return tgt;
  // }
  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent convertMedicationKnowledgeMedicineClassificationComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getClassification())
      tgt.addClassification(CodeableConcept43_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent convertMedicationKnowledgeMedicineClassificationComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeMedicineClassificationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getClassification())
      tgt.addClassification(CodeableConcept43_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgePackagingComponent convertMedicationKnowledgePackagingComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgePackagingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgePackagingComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgePackagingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgePackagingComponent convertMedicationKnowledgePackagingComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgePackagingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgePackagingComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgePackagingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    if (src.hasQuantity())
//      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent convertMedicationKnowledgeDrugCharacteristicComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    if (src.hasValue())
//      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent convertMedicationKnowledgeDrugCharacteristicComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeDrugCharacteristicComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    if (src.hasValue())
//      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent convertMedicationKnowledgeRegulatoryComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRegulatoryAuthority())
      tgt.setRegulatoryAuthority(Reference43_50.convertReference(src.getRegulatoryAuthority()));
    for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent t : src.getSubstitution())
      tgt.addSubstitution(convertMedicationKnowledgeRegulatorySubstitutionComponent(t));
    // for (org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent t : src.getSchedule())
    // tgt.addSchedule(convertMedicationKnowledgeRegulatoryScheduleComponent(t));
    if (src.hasMaxDispense())
      tgt.setMaxDispense(convertMedicationKnowledgeRegulatoryMaxDispenseComponent(src.getMaxDispense()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent convertMedicationKnowledgeRegulatoryComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRegulatoryAuthority())
      tgt.setRegulatoryAuthority(Reference43_50.convertReference(src.getRegulatoryAuthority()));
    for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent t : src.getSubstitution())
      tgt.addSubstitution(convertMedicationKnowledgeRegulatorySubstitutionComponent(t));
    // for (org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent t : src.getSchedule())
    // tgt.addSchedule(convertMedicationKnowledgeRegulatoryScheduleComponent(t));
    if (src.hasMaxDispense())
      tgt.setMaxDispense(convertMedicationKnowledgeRegulatoryMaxDispenseComponent(src.getMaxDispense()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent convertMedicationKnowledgeRegulatorySubstitutionComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowedElement(Boolean43_50.convertBoolean(src.getAllowedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent convertMedicationKnowledgeRegulatorySubstitutionComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatorySubstitutionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowedElement(Boolean43_50.convertBoolean(src.getAllowedElement()));
    return tgt;
  }

  // public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent convertMedicationKnowledgeRegulatoryScheduleComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent();
  // copyElement(src, tgt);
  // if (src.hasSchedule())
  // tgt.setSchedule(convertCodeableConcept(src.getSchedule()));
  // return tgt;
  // }
  //
  // public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent convertMedicationKnowledgeRegulatoryScheduleComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryScheduleComponent();
  // copyElement(src, tgt);
  // if (src.hasSchedule())
  // tgt.setSchedule(convertCodeableConcept(src.getSchedule()));
  // return tgt;
  // }
  //
  public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryMaxDispenseComponent convertMedicationKnowledgeRegulatoryMaxDispenseComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryMaxDispenseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryMaxDispenseComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryMaxDispenseComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasPeriod())
      tgt.setPeriod(Duration43_50.convertDuration(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryMaxDispenseComponent convertMedicationKnowledgeRegulatoryMaxDispenseComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeRegulatoryMaxDispenseComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryMaxDispenseComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeRegulatoryMaxDispenseComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasPeriod())
      tgt.setPeriod(Duration43_50.convertDuration(src.getPeriod()));
    return tgt;
  }
  // public static org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent convertMedicationKnowledgeKineticsComponent(org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent tgt = new org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent();
  // copyElement(src, tgt);
  // for (org.hl7.fhir.r4b.model.Quantity t : src.getAreaUnderCurve())
  // tgt.addAreaUnderCurve(convertSimpleQuantity(t));
  // for (org.hl7.fhir.r4b.model.Quantity t : src.getLethalDose50())
  // tgt.addLethalDose50(convertSimpleQuantity(t));
  // if (src.hasHalfLifePeriod())
  // tgt.setHalfLifePeriod(convertDuration(src.getHalfLifePeriod()));
  // return tgt;
  // }
  //
  // public static org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent convertMedicationKnowledgeKineticsComponent(org.hl7.fhir.r5.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent src) throws FHIRException {
  // if (src == null)
  // return null;
  // org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent tgt = new org.hl7.fhir.r4b.model.MedicationKnowledge.MedicationKnowledgeKineticsComponent();
  // copyElement(src, tgt);
  // for (org.hl7.fhir.r5.model.Quantity t : src.getAreaUnderCurve())
  // tgt.addAreaUnderCurve(convertSimpleQuantity(t));
  // for (org.hl7.fhir.r5.model.Quantity t : src.getLethalDose50())
  // tgt.addLethalDose50(convertSimpleQuantity(t));
  // if (src.hasHalfLifePeriod())
  // tgt.setHalfLifePeriod(convertDuration(src.getHalfLifePeriod()));
  // return tgt;
  // }
}
