package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Ratio40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Medication;

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

public class Medication40_N {

  public static org.hl7.fhir.model.core.Medication convertMedication(org.hl7.fhir.r4.model.Medication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Medication tgt = new org.hl7.fhir.model.core.Medication();
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Medication", tgt.getExtension(), "amount");
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Medication", "5.0", new String[] {"definition"}, CrossVersionElements40_N.urls("Medication", "6.0", new String[] {"packageSize"})));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "definition");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "packageSize");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertMedicationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasManufacturer())
      tgt.setMarketingAuthorizationHolder(Reference40_N.convertReference(src.getManufacturer()));
    if (src.hasForm())
      tgt.setDoseForm(CodeableConcept40_N.convertCodeableConcept(src.getForm()));
    for (org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertMedicationIngredientComponent(t));
    if (src.hasBatch())
      tgt.setInstance(convertMedicationBatchComponent(src.getBatch()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Medication convertMedication(org.hl7.fhir.model.core.Medication src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Medication tgt = new org.hl7.fhir.r4.model.Medication();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Medication", "4.0", new String[] {"amount"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Medication", "amount");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "definition");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "packageSize");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertMedicationStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasMarketingAuthorizationHolder())
      tgt.setManufacturer(Reference40_N.convertReference(src.getMarketingAuthorizationHolder()));
    if (src.hasDoseForm())
      tgt.setForm(CodeableConcept40_N.convertCodeableConcept(src.getDoseForm()));
    for (org.hl7.fhir.model.core.Medication.MedicationIngredientComponent t : src.getIngredientList())
      tgt.addIngredient(convertMedicationIngredientComponent(t));
    if (src.hasInstance())
      tgt.setBatch(convertMedicationBatchComponent(src.getInstance()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Medication.MedicationStatusCodes> convertMedicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Medication.MedicationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Medication.MedicationStatusCodes> tgt = new Enumeration<>(new Medication.MedicationStatusCodesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Medication.MedicationStatusCodes.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(Medication.MedicationStatusCodes.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Medication.MedicationStatusCodes.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Medication.MedicationStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Medication.MedicationStatus> convertMedicationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Medication.MedicationStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Medication.MedicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Medication.MedicationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Medication.MedicationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.model.core.Medication.MedicationIngredientComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Medication.ingredient", "5.0", new String[] {}, CrossVersionElements40_N.urls("Medication.ingredient", "6.0", new String[] {"role"}, CrossVersionElements40_N.url("Medication.ingredient", "5.0", "strength"))));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "role");
    if (src.hasItem())
      tgt.setItem(CodeableConcept40_N.convertChoiceToCodeableReference(src.getItem()));
    if (src.hasIsActive())
      tgt.setIsActiveElement(Boolean40_N.convertBoolean(src.getIsActiveElement()));
    if (src.hasStrength())
      tgt.setStrength(Ratio40_N.convertRatio(src.getStrength()));
    // R6 strength can also be a CodeableConcept or a Quantity
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Medication.ingredient", "5.0", "strength");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent convertMedicationIngredientComponent(org.hl7.fhir.model.core.Medication.MedicationIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationIngredientComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "role");
    if (src.hasItem())
      tgt.setItem(CodeableConcept40_N.convertCodeableReferenceToChoice(src.getItem()));
    if (src.hasIsActive())
      tgt.setIsActiveElement(Boolean40_N.convertBoolean(src.getIsActiveElement()));
    if (src.hasStrengthRatio())
      tgt.setStrength(Ratio40_N.convertRatio(src.getStrengthRatio()));
    else if (src.hasStrength())
      tgt.addExtension(CrossVersionElements40_N.url("Medication.ingredient", "5.0", "strength"), ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getStrength()));
    return tgt;
  }

  public static Medication.MedicationInstanceComponent convertMedicationBatchComponent(org.hl7.fhir.r4.model.Medication.MedicationBatchComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Medication.MedicationInstanceComponent tgt = new org.hl7.fhir.model.core.Medication.MedicationInstanceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("Medication.instance", "6.0", "identifier"));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Medication.instance", "6.0", "identifier");
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String40_N.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime40_N.convertDateTime(src.getExpirationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Medication.MedicationBatchComponent convertMedicationBatchComponent(org.hl7.fhir.model.core.Medication.MedicationInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Medication.MedicationBatchComponent tgt = new org.hl7.fhir.r4.model.Medication.MedicationBatchComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Medication.instance", tgt.getExtension(), "6.0", "identifier");
    if (src.hasLotNumber())
      tgt.setLotNumberElement(String40_N.convertString(src.getLotNumberElement()));
    if (src.hasExpirationDate())
      tgt.setExpirationDateElement(DateTime40_N.convertDateTime(src.getExpirationDateElement()));
    return tgt;
  }
}