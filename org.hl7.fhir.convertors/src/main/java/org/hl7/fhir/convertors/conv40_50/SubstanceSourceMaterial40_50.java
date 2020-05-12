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
public class SubstanceSourceMaterial40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.SubstanceSourceMaterial convertSubstanceSourceMaterial(org.hl7.fhir.r4.model.SubstanceSourceMaterial src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceSourceMaterial tgt = new org.hl7.fhir.r5.model.SubstanceSourceMaterial();
        copyDomainResource(src, tgt);
        if (src.hasSourceMaterialClass())
            tgt.setSourceMaterialClass(convertCodeableConcept(src.getSourceMaterialClass()));
        if (src.hasSourceMaterialType())
            tgt.setSourceMaterialType(convertCodeableConcept(src.getSourceMaterialType()));
        if (src.hasSourceMaterialState())
            tgt.setSourceMaterialState(convertCodeableConcept(src.getSourceMaterialState()));
        if (src.hasOrganismId())
            tgt.setOrganismId(convertIdentifier(src.getOrganismId()));
        if (src.hasOrganismName())
            tgt.setOrganismNameElement(convertString(src.getOrganismNameElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getParentSubstanceId()) tgt.addParentSubstanceId(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getParentSubstanceName()) tgt.getParentSubstanceName().add(convertString(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCountryOfOrigin()) tgt.addCountryOfOrigin(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getGeographicalLocation()) tgt.getGeographicalLocation().add(convertString(t));
        if (src.hasDevelopmentStage())
            tgt.setDevelopmentStage(convertCodeableConcept(src.getDevelopmentStage()));
        for (org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent t : src.getFractionDescription()) tgt.addFractionDescription(convertSubstanceSourceMaterialFractionDescriptionComponent(t));
        if (src.hasOrganism())
            tgt.setOrganism(convertSubstanceSourceMaterialOrganismComponent(src.getOrganism()));
        for (org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent t : src.getPartDescription()) tgt.addPartDescription(convertSubstanceSourceMaterialPartDescriptionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceSourceMaterial convertSubstanceSourceMaterial(org.hl7.fhir.r5.model.SubstanceSourceMaterial src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceSourceMaterial tgt = new org.hl7.fhir.r4.model.SubstanceSourceMaterial();
        copyDomainResource(src, tgt);
        if (src.hasSourceMaterialClass())
            tgt.setSourceMaterialClass(convertCodeableConcept(src.getSourceMaterialClass()));
        if (src.hasSourceMaterialType())
            tgt.setSourceMaterialType(convertCodeableConcept(src.getSourceMaterialType()));
        if (src.hasSourceMaterialState())
            tgt.setSourceMaterialState(convertCodeableConcept(src.getSourceMaterialState()));
        if (src.hasOrganismId())
            tgt.setOrganismId(convertIdentifier(src.getOrganismId()));
        if (src.hasOrganismName())
            tgt.setOrganismNameElement(convertString(src.getOrganismNameElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getParentSubstanceId()) tgt.addParentSubstanceId(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getParentSubstanceName()) tgt.getParentSubstanceName().add(convertString(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCountryOfOrigin()) tgt.addCountryOfOrigin(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getGeographicalLocation()) tgt.getGeographicalLocation().add(convertString(t));
        if (src.hasDevelopmentStage())
            tgt.setDevelopmentStage(convertCodeableConcept(src.getDevelopmentStage()));
        for (org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent t : src.getFractionDescription()) tgt.addFractionDescription(convertSubstanceSourceMaterialFractionDescriptionComponent(t));
        if (src.hasOrganism())
            tgt.setOrganism(convertSubstanceSourceMaterialOrganismComponent(src.getOrganism()));
        for (org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent t : src.getPartDescription()) tgt.addPartDescription(convertSubstanceSourceMaterialPartDescriptionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent convertSubstanceSourceMaterialFractionDescriptionComponent(org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent tgt = new org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent();
        copyElement(src, tgt);
        if (src.hasFraction())
            tgt.setFractionElement(convertString(src.getFractionElement()));
        if (src.hasMaterialType())
            tgt.setMaterialType(convertCodeableConcept(src.getMaterialType()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent convertSubstanceSourceMaterialFractionDescriptionComponent(org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent tgt = new org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialFractionDescriptionComponent();
        copyElement(src, tgt);
        if (src.hasFraction())
            tgt.setFractionElement(convertString(src.getFractionElement()));
        if (src.hasMaterialType())
            tgt.setMaterialType(convertCodeableConcept(src.getMaterialType()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismComponent convertSubstanceSourceMaterialOrganismComponent(org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismComponent tgt = new org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismComponent();
        copyElement(src, tgt);
        if (src.hasFamily())
            tgt.setFamily(convertCodeableConcept(src.getFamily()));
        if (src.hasGenus())
            tgt.setGenus(convertCodeableConcept(src.getGenus()));
        if (src.hasSpecies())
            tgt.setSpecies(convertCodeableConcept(src.getSpecies()));
        if (src.hasIntraspecificType())
            tgt.setIntraspecificType(convertCodeableConcept(src.getIntraspecificType()));
        if (src.hasIntraspecificDescription())
            tgt.setIntraspecificDescriptionElement(convertString(src.getIntraspecificDescriptionElement()));
        for (org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent t : src.getAuthor()) tgt.addAuthor(convertSubstanceSourceMaterialOrganismAuthorComponent(t));
        if (src.hasHybrid())
            tgt.setHybrid(convertSubstanceSourceMaterialOrganismHybridComponent(src.getHybrid()));
        if (src.hasOrganismGeneral())
            tgt.setOrganismGeneral(convertSubstanceSourceMaterialOrganismOrganismGeneralComponent(src.getOrganismGeneral()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismComponent convertSubstanceSourceMaterialOrganismComponent(org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismComponent tgt = new org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismComponent();
        copyElement(src, tgt);
        if (src.hasFamily())
            tgt.setFamily(convertCodeableConcept(src.getFamily()));
        if (src.hasGenus())
            tgt.setGenus(convertCodeableConcept(src.getGenus()));
        if (src.hasSpecies())
            tgt.setSpecies(convertCodeableConcept(src.getSpecies()));
        if (src.hasIntraspecificType())
            tgt.setIntraspecificType(convertCodeableConcept(src.getIntraspecificType()));
        if (src.hasIntraspecificDescription())
            tgt.setIntraspecificDescriptionElement(convertString(src.getIntraspecificDescriptionElement()));
        for (org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent t : src.getAuthor()) tgt.addAuthor(convertSubstanceSourceMaterialOrganismAuthorComponent(t));
        if (src.hasHybrid())
            tgt.setHybrid(convertSubstanceSourceMaterialOrganismHybridComponent(src.getHybrid()));
        if (src.hasOrganismGeneral())
            tgt.setOrganismGeneral(convertSubstanceSourceMaterialOrganismOrganismGeneralComponent(src.getOrganismGeneral()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent convertSubstanceSourceMaterialOrganismAuthorComponent(org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent tgt = new org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent();
        copyElement(src, tgt);
        if (src.hasAuthorType())
            tgt.setAuthorType(convertCodeableConcept(src.getAuthorType()));
        if (src.hasAuthorDescription())
            tgt.setAuthorDescriptionElement(convertString(src.getAuthorDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent convertSubstanceSourceMaterialOrganismAuthorComponent(org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent tgt = new org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismAuthorComponent();
        copyElement(src, tgt);
        if (src.hasAuthorType())
            tgt.setAuthorType(convertCodeableConcept(src.getAuthorType()));
        if (src.hasAuthorDescription())
            tgt.setAuthorDescriptionElement(convertString(src.getAuthorDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismHybridComponent convertSubstanceSourceMaterialOrganismHybridComponent(org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismHybridComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismHybridComponent tgt = new org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismHybridComponent();
        copyElement(src, tgt);
        if (src.hasMaternalOrganismId())
            tgt.setMaternalOrganismIdElement(convertString(src.getMaternalOrganismIdElement()));
        if (src.hasMaternalOrganismName())
            tgt.setMaternalOrganismNameElement(convertString(src.getMaternalOrganismNameElement()));
        if (src.hasPaternalOrganismId())
            tgt.setPaternalOrganismIdElement(convertString(src.getPaternalOrganismIdElement()));
        if (src.hasPaternalOrganismName())
            tgt.setPaternalOrganismNameElement(convertString(src.getPaternalOrganismNameElement()));
        if (src.hasHybridType())
            tgt.setHybridType(convertCodeableConcept(src.getHybridType()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismHybridComponent convertSubstanceSourceMaterialOrganismHybridComponent(org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismHybridComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismHybridComponent tgt = new org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismHybridComponent();
        copyElement(src, tgt);
        if (src.hasMaternalOrganismId())
            tgt.setMaternalOrganismIdElement(convertString(src.getMaternalOrganismIdElement()));
        if (src.hasMaternalOrganismName())
            tgt.setMaternalOrganismNameElement(convertString(src.getMaternalOrganismNameElement()));
        if (src.hasPaternalOrganismId())
            tgt.setPaternalOrganismIdElement(convertString(src.getPaternalOrganismIdElement()));
        if (src.hasPaternalOrganismName())
            tgt.setPaternalOrganismNameElement(convertString(src.getPaternalOrganismNameElement()));
        if (src.hasHybridType())
            tgt.setHybridType(convertCodeableConcept(src.getHybridType()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismOrganismGeneralComponent convertSubstanceSourceMaterialOrganismOrganismGeneralComponent(org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismOrganismGeneralComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismOrganismGeneralComponent tgt = new org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismOrganismGeneralComponent();
        copyElement(src, tgt);
        if (src.hasKingdom())
            tgt.setKingdom(convertCodeableConcept(src.getKingdom()));
        if (src.hasPhylum())
            tgt.setPhylum(convertCodeableConcept(src.getPhylum()));
        if (src.hasClass_())
            tgt.setClass_(convertCodeableConcept(src.getClass_()));
        if (src.hasOrder())
            tgt.setOrder(convertCodeableConcept(src.getOrder()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismOrganismGeneralComponent convertSubstanceSourceMaterialOrganismOrganismGeneralComponent(org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismOrganismGeneralComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismOrganismGeneralComponent tgt = new org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialOrganismOrganismGeneralComponent();
        copyElement(src, tgt);
        if (src.hasKingdom())
            tgt.setKingdom(convertCodeableConcept(src.getKingdom()));
        if (src.hasPhylum())
            tgt.setPhylum(convertCodeableConcept(src.getPhylum()));
        if (src.hasClass_())
            tgt.setClass_(convertCodeableConcept(src.getClass_()));
        if (src.hasOrder())
            tgt.setOrder(convertCodeableConcept(src.getOrder()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent convertSubstanceSourceMaterialPartDescriptionComponent(org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent tgt = new org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent();
        copyElement(src, tgt);
        if (src.hasPart())
            tgt.setPart(convertCodeableConcept(src.getPart()));
        if (src.hasPartLocation())
            tgt.setPartLocation(convertCodeableConcept(src.getPartLocation()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent convertSubstanceSourceMaterialPartDescriptionComponent(org.hl7.fhir.r5.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent tgt = new org.hl7.fhir.r4.model.SubstanceSourceMaterial.SubstanceSourceMaterialPartDescriptionComponent();
        copyElement(src, tgt);
        if (src.hasPart())
            tgt.setPart(convertCodeableConcept(src.getPart()));
        if (src.hasPartLocation())
            tgt.setPartLocation(convertCodeableConcept(src.getPartLocation()));
        return tgt;
    }
}