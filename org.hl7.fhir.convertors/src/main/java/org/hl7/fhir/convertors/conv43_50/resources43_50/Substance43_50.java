package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Ratio43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Identifier;

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
public class Substance43_50 {

  public static org.hl7.fhir.r5.model.Substance convertSubstance(org.hl7.fhir.r4b.model.Substance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Substance tgt = new org.hl7.fhir.r5.model.Substance();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.getCode().setConcept(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent t : src.getInstance())
      convertSubstanceInstanceComponent(t, tgt);
    for (org.hl7.fhir.r4b.model.Substance.SubstanceIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertSubstanceIngredientComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Substance convertSubstance(org.hl7.fhir.r5.model.Substance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Substance tgt = new org.hl7.fhir.r4b.model.Substance();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.getCode().hasConcept())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode().getConcept()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.getInstance()) {
      tgt.addInstance(convertSubstanceInstanceComponent(src));
    }
    for (org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent t : src.getIngredient())
      tgt.addIngredient(convertSubstanceIngredientComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Substance.FHIRSubstanceStatus.NULL);
        break;
    }
    return tgt;
  }

  public static void convertSubstanceInstanceComponent(org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent src, org.hl7.fhir.r5.model.Substance tgt) throws FHIRException {
    tgt.setInstance(true);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasExpiry())
      tgt.setExpiryElement(DateTime43_50.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
  }

  public static org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.r5.model.Substance src) throws FHIRException {
    org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r4b.model.Substance.SubstanceInstanceComponent();
    for (Identifier t : src.getIdentifier()) {
      tgt.setIdentifier(Identifier43_50.convertIdentifier(t));
    }
    if (src.hasExpiry())
      tgt.setExpiryElement(DateTime43_50.convertDateTime(src.getExpiryElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.r4b.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(Ratio43_50.convertRatio(src.getQuantity()));
    if (src.hasSubstance())
      tgt.setSubstance(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSubstance()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.r4b.model.Substance.SubstanceIngredientComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(Ratio43_50.convertRatio(src.getQuantity()));
    if (src.hasSubstance())
      tgt.setSubstance(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSubstance()));
    return tgt;
  }
}