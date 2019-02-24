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


public class SubstanceSpecification extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.SubstanceSpecification convertSubstanceSpecification(org.hl7.fhir.r4.model.SubstanceSpecification src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification tgt = new org.hl7.fhir.r5.model.SubstanceSpecification();
    copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasDomain())
      tgt.setDomain(convertCodeableConcept(src.getDomain()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent t : src.getMoiety())
      tgt.addMoiety(convertSubstanceSpecificationMoietyComponent(t));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent t : src.getProperty())
      tgt.addProperty(convertSubstanceSpecificationPropertyComponent(t));
    if (src.hasReferenceInformation())
      tgt.setReferenceInformation(convertReference(src.getReferenceInformation()));
    if (src.hasStructure())
      tgt.setStructure(convertSubstanceSpecificationStructureComponent(src.getStructure()));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationCodeComponent t : src.getCode())
      tgt.addCode(convertSubstanceSpecificationCodeComponent(t));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameComponent t : src.getName())
      tgt.addName(convertSubstanceSpecificationNameComponent(t));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent t : src.getMolecularWeight())
      tgt.addMolecularWeight(convertSubstanceSpecificationStructureIsotopeMolecularWeightComponent(t));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent t : src.getRelationship())
      tgt.addRelationship(convertSubstanceSpecificationRelationshipComponent(t));
    if (src.hasNucleicAcid())
      tgt.setNucleicAcid(convertReference(src.getNucleicAcid()));
    if (src.hasPolymer())
      tgt.setPolymer(convertReference(src.getPolymer()));
    if (src.hasProtein())
      tgt.setProtein(convertReference(src.getProtein()));
    if (src.hasSourceMaterial())
      tgt.setSourceMaterial(convertReference(src.getSourceMaterial()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification convertSubstanceSpecification(org.hl7.fhir.r5.model.SubstanceSpecification src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification tgt = new org.hl7.fhir.r4.model.SubstanceSpecification();
    copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasDomain())
      tgt.setDomain(convertCodeableConcept(src.getDomain()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent t : src.getMoiety())
      tgt.addMoiety(convertSubstanceSpecificationMoietyComponent(t));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent t : src.getProperty())
      tgt.addProperty(convertSubstanceSpecificationPropertyComponent(t));
    if (src.hasReferenceInformation())
      tgt.setReferenceInformation(convertReference(src.getReferenceInformation()));
    if (src.hasStructure())
      tgt.setStructure(convertSubstanceSpecificationStructureComponent(src.getStructure()));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationCodeComponent t : src.getCode())
      tgt.addCode(convertSubstanceSpecificationCodeComponent(t));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameComponent t : src.getName())
      tgt.addName(convertSubstanceSpecificationNameComponent(t));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent t : src.getMolecularWeight())
      tgt.addMolecularWeight(convertSubstanceSpecificationStructureIsotopeMolecularWeightComponent(t));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent t : src.getRelationship())
      tgt.addRelationship(convertSubstanceSpecificationRelationshipComponent(t));
    if (src.hasNucleicAcid())
      tgt.setNucleicAcid(convertReference(src.getNucleicAcid()));
    if (src.hasPolymer())
      tgt.setPolymer(convertReference(src.getPolymer()));
    if (src.hasProtein())
      tgt.setProtein(convertReference(src.getProtein()));
    if (src.hasSourceMaterial())
      tgt.setSourceMaterial(convertReference(src.getSourceMaterial()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent convertSubstanceSpecificationMoietyComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent();
    copyElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasStereochemistry())
      tgt.setStereochemistry(convertCodeableConcept(src.getStereochemistry()));
    if (src.hasOpticalActivity())
      tgt.setOpticalActivity(convertCodeableConcept(src.getOpticalActivity()));
    if (src.hasMolecularFormula())
      tgt.setMolecularFormulaElement(convertString(src.getMolecularFormulaElement()));
    if (src.hasAmount())
      tgt.setAmount(convertType(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent convertSubstanceSpecificationMoietyComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationMoietyComponent();
    copyElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasStereochemistry())
      tgt.setStereochemistry(convertCodeableConcept(src.getStereochemistry()));
    if (src.hasOpticalActivity())
      tgt.setOpticalActivity(convertCodeableConcept(src.getOpticalActivity()));
    if (src.hasMolecularFormula())
      tgt.setMolecularFormulaElement(convertString(src.getMolecularFormulaElement()));
    if (src.hasAmount())
      tgt.setAmount(convertType(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent convertSubstanceSpecificationPropertyComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent();
    copyElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasParameters())
      tgt.setParametersElement(convertString(src.getParametersElement()));
    if (src.hasDefiningSubstance())
      tgt.setDefiningSubstance(convertType(src.getDefiningSubstance()));
    if (src.hasAmount())
      tgt.setAmount(convertType(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent convertSubstanceSpecificationPropertyComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationPropertyComponent();
    copyElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasParameters())
      tgt.setParametersElement(convertString(src.getParametersElement()));
    if (src.hasDefiningSubstance())
      tgt.setDefiningSubstance(convertType(src.getDefiningSubstance()));
    if (src.hasAmount())
      tgt.setAmount(convertType(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureComponent convertSubstanceSpecificationStructureComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureComponent();
    copyElement(src, tgt);
    if (src.hasStereochemistry())
      tgt.setStereochemistry(convertCodeableConcept(src.getStereochemistry()));
    if (src.hasOpticalActivity())
      tgt.setOpticalActivity(convertCodeableConcept(src.getOpticalActivity()));
    if (src.hasMolecularFormula())
      tgt.setMolecularFormulaElement(convertString(src.getMolecularFormulaElement()));
    if (src.hasMolecularFormulaByMoiety())
      tgt.setMolecularFormulaByMoietyElement(convertString(src.getMolecularFormulaByMoietyElement()));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent t : src.getIsotope())
      tgt.addIsotope(convertSubstanceSpecificationStructureIsotopeComponent(t));
    if (src.hasMolecularWeight())
      tgt.setMolecularWeight(convertSubstanceSpecificationStructureIsotopeMolecularWeightComponent(src.getMolecularWeight()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent t : src.getRepresentation())
      tgt.addRepresentation(convertSubstanceSpecificationStructureRepresentationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureComponent convertSubstanceSpecificationStructureComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureComponent();
    copyElement(src, tgt);
    if (src.hasStereochemistry())
      tgt.setStereochemistry(convertCodeableConcept(src.getStereochemistry()));
    if (src.hasOpticalActivity())
      tgt.setOpticalActivity(convertCodeableConcept(src.getOpticalActivity()));
    if (src.hasMolecularFormula())
      tgt.setMolecularFormulaElement(convertString(src.getMolecularFormulaElement()));
    if (src.hasMolecularFormulaByMoiety())
      tgt.setMolecularFormulaByMoietyElement(convertString(src.getMolecularFormulaByMoietyElement()));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent t : src.getIsotope())
      tgt.addIsotope(convertSubstanceSpecificationStructureIsotopeComponent(t));
    if (src.hasMolecularWeight())
      tgt.setMolecularWeight(convertSubstanceSpecificationStructureIsotopeMolecularWeightComponent(src.getMolecularWeight()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent t : src.getRepresentation())
      tgt.addRepresentation(convertSubstanceSpecificationStructureRepresentationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent convertSubstanceSpecificationStructureIsotopeComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent();
    copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setName(convertCodeableConcept(src.getName()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertCodeableConcept(src.getSubstitution()));
    if (src.hasHalfLife())
      tgt.setHalfLife(convertQuantity(src.getHalfLife()));
    if (src.hasMolecularWeight())
      tgt.setMolecularWeight(convertSubstanceSpecificationStructureIsotopeMolecularWeightComponent(src.getMolecularWeight()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent convertSubstanceSpecificationStructureIsotopeComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeComponent();
    copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setName(convertCodeableConcept(src.getName()));
    if (src.hasSubstitution())
      tgt.setSubstitution(convertCodeableConcept(src.getSubstitution()));
    if (src.hasHalfLife())
      tgt.setHalfLife(convertQuantity(src.getHalfLife()));
    if (src.hasMolecularWeight())
      tgt.setMolecularWeight(convertSubstanceSpecificationStructureIsotopeMolecularWeightComponent(src.getMolecularWeight()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent convertSubstanceSpecificationStructureIsotopeMolecularWeightComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent();
    copyElement(src, tgt);
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasAmount())
      tgt.setAmount(convertQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent convertSubstanceSpecificationStructureIsotopeMolecularWeightComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureIsotopeMolecularWeightComponent();
    copyElement(src, tgt);
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasAmount())
      tgt.setAmount(convertQuantity(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent convertSubstanceSpecificationStructureRepresentationComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasRepresentation())
      tgt.setRepresentationElement(convertString(src.getRepresentationElement()));
    if (src.hasAttachment())
      tgt.setAttachment(convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent convertSubstanceSpecificationStructureRepresentationComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationStructureRepresentationComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasRepresentation())
      tgt.setRepresentationElement(convertString(src.getRepresentationElement()));
    if (src.hasAttachment())
      tgt.setAttachment(convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationCodeComponent convertSubstanceSpecificationCodeComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationCodeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationCodeComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationCodeComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(convertDateTime(src.getStatusDateElement()));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationCodeComponent convertSubstanceSpecificationCodeComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationCodeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationCodeComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationCodeComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(convertDateTime(src.getStatusDateElement()));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameComponent convertSubstanceSpecificationNameComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasPreferred())
      tgt.setPreferredElement(convertBoolean(src.getPreferredElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLanguage())
      tgt.addLanguage(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDomain())
      tgt.addDomain(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameComponent t : src.getSynonym())
      tgt.addSynonym(convertSubstanceSpecificationNameComponent(t));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameComponent t : src.getTranslation())
      tgt.addTranslation(convertSubstanceSpecificationNameComponent(t));
    for (org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent t : src.getOfficial())
      tgt.addOfficial(convertSubstanceSpecificationNameOfficialComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameComponent convertSubstanceSpecificationNameComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasPreferred())
      tgt.setPreferredElement(convertBoolean(src.getPreferredElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getLanguage())
      tgt.addLanguage(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDomain())
      tgt.addDomain(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameComponent t : src.getSynonym())
      tgt.addSynonym(convertSubstanceSpecificationNameComponent(t));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameComponent t : src.getTranslation())
      tgt.addTranslation(convertSubstanceSpecificationNameComponent(t));
    for (org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent t : src.getOfficial())
      tgt.addOfficial(convertSubstanceSpecificationNameOfficialComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent convertSubstanceSpecificationNameOfficialComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent();
    copyElement(src, tgt);
    if (src.hasAuthority())
      tgt.setAuthority(convertCodeableConcept(src.getAuthority()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent convertSubstanceSpecificationNameOfficialComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationNameOfficialComponent();
    copyElement(src, tgt);
    if (src.hasAuthority())
      tgt.setAuthority(convertCodeableConcept(src.getAuthority()));
    if (src.hasStatus())
      tgt.setStatus(convertCodeableConcept(src.getStatus()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent convertSubstanceSpecificationRelationshipComponent(org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent tgt = new org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent();
    copyElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(convertType(src.getSubstance()));
    if (src.hasRelationship())
      tgt.setRelationship(convertCodeableConcept(src.getRelationship()));
    if (src.hasIsDefining())
      tgt.setIsDefiningElement(convertBoolean(src.getIsDefiningElement()));
    if (src.hasAmount())
      tgt.setAmount(convertType(src.getAmount()));
    if (src.hasAmountRatioLowLimit())
      tgt.setAmountRatioLowLimit(convertRatio(src.getAmountRatioLowLimit()));
    if (src.hasAmountType())
      tgt.setAmountType(convertCodeableConcept(src.getAmountType()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent convertSubstanceSpecificationRelationshipComponent(org.hl7.fhir.r5.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent tgt = new org.hl7.fhir.r4.model.SubstanceSpecification.SubstanceSpecificationRelationshipComponent();
    copyElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(convertType(src.getSubstance()));
    if (src.hasRelationship())
      tgt.setRelationship(convertCodeableConcept(src.getRelationship()));
    if (src.hasIsDefining())
      tgt.setIsDefiningElement(convertBoolean(src.getIsDefiningElement()));
    if (src.hasAmount())
      tgt.setAmount(convertType(src.getAmount()));
    if (src.hasAmountRatioLowLimit())
      tgt.setAmountRatioLowLimit(convertRatio(src.getAmountRatioLowLimit()));
    if (src.hasAmountType())
      tgt.setAmountType(convertCodeableConcept(src.getAmountType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSource())
      tgt.addSource(convertReference(t));
    return tgt;
  }


}
