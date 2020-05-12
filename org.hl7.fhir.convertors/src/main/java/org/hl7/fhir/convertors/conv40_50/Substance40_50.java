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
public class Substance40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Substance convertSubstance(org.hl7.fhir.r4.model.Substance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Substance tgt = new org.hl7.fhir.r5.model.Substance();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        for (org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Substance convertSubstance(org.hl7.fhir.r5.model.Substance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Substance tgt = new org.hl7.fhir.r4.model.Substance();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertFHIRSubstanceStatus(src.getStatusElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent t : src.getInstance()) tgt.addInstance(convertSubstanceInstanceComponent(t));
        for (org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent t : src.getIngredient()) tgt.addIngredient(convertSubstanceIngredientComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus> convertFHIRSubstanceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Substance.FHIRSubstanceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.ACTIVE);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.INACTIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Substance.FHIRSubstanceStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent();
        copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasExpiry())
            tgt.setExpiryElement(convertDateTime(src.getExpiryElement()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent convertSubstanceInstanceComponent(org.hl7.fhir.r5.model.Substance.SubstanceInstanceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent tgt = new org.hl7.fhir.r4.model.Substance.SubstanceInstanceComponent();
        copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasExpiry())
            tgt.setExpiryElement(convertDateTime(src.getExpiryElement()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent();
        copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(convertRatio(src.getQuantity()));
        if (src.hasSubstance())
            tgt.setSubstance(convertType(src.getSubstance()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent convertSubstanceIngredientComponent(org.hl7.fhir.r5.model.Substance.SubstanceIngredientComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent tgt = new org.hl7.fhir.r4.model.Substance.SubstanceIngredientComponent();
        copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(convertRatio(src.getQuantity()));
        if (src.hasSubstance())
            tgt.setSubstance(convertType(src.getSubstance()));
        return tgt;
    }
}