package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class SubstanceReferenceInformation40_50 {

  public static org.hl7.fhir.r5.model.SubstanceReferenceInformation convertSubstanceReferenceInformation(org.hl7.fhir.r4.model.SubstanceReferenceInformation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceReferenceInformation tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent t : src.getGene())
      tgt.addGene(convertSubstanceReferenceInformationGeneComponent(t));
    for (org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent t : src.getGeneElement())
      tgt.addGeneElement(convertSubstanceReferenceInformationGeneElementComponent(t));
//        for (org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent t : src.getClassification()) tgt.addClassification(convertSubstanceReferenceInformationClassificationComponent(t));
    for (org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent t : src.getTarget())
      tgt.addTarget(convertSubstanceReferenceInformationTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceReferenceInformation convertSubstanceReferenceInformation(org.hl7.fhir.r5.model.SubstanceReferenceInformation src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceReferenceInformation tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent t : src.getGene())
      tgt.addGene(convertSubstanceReferenceInformationGeneComponent(t));
    for (org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent t : src.getGeneElement())
      tgt.addGeneElement(convertSubstanceReferenceInformationGeneElementComponent(t));
//        for (org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent t : src.getClassification()) tgt.addClassification(convertSubstanceReferenceInformationClassificationComponent(t));
    for (org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent t : src.getTarget())
      tgt.addTarget(convertSubstanceReferenceInformationTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent convertSubstanceReferenceInformationGeneComponent(org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasGeneSequenceOrigin())
      tgt.setGeneSequenceOrigin(CodeableConcept40_50.convertCodeableConcept(src.getGeneSequenceOrigin()));
    if (src.hasGene())
      tgt.setGene(CodeableConcept40_50.convertCodeableConcept(src.getGene()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSource()) tgt.addSource(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent convertSubstanceReferenceInformationGeneComponent(org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasGeneSequenceOrigin())
      tgt.setGeneSequenceOrigin(CodeableConcept40_50.convertCodeableConcept(src.getGeneSequenceOrigin()));
    if (src.hasGene())
      tgt.setGene(CodeableConcept40_50.convertCodeableConcept(src.getGene()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSource()) tgt.addSource(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent convertSubstanceReferenceInformationGeneElementComponent(org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasElement())
      tgt.setElement(Identifier40_50.convertIdentifier(src.getElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSource()) tgt.addSource(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent convertSubstanceReferenceInformationGeneElementComponent(org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationGeneElementComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasElement())
      tgt.setElement(Identifier40_50.convertIdentifier(src.getElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSource()) tgt.addSource(Reference40_50.convertReference(t));
    return tgt;
  }

  //    public static org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent convertSubstanceReferenceInformationClassificationComponent(org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent src) throws FHIRException {
//        if (src == null)
//            return null;
//        org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent();
//        copyElement(src, tgt);
//        if (src.hasDomain())
//            tgt.setDomain(convertCodeableConcept(src.getDomain()));
//        if (src.hasClassification())
//            tgt.setClassification(convertCodeableConcept(src.getClassification()));
//        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubtype()) tgt.addSubtype(convertCodeableConcept(t));
//        for (org.hl7.fhir.r4.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
//        return tgt;
//    }
//
//    public static org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent convertSubstanceReferenceInformationClassificationComponent(org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent src) throws FHIRException {
//        if (src == null)
//            return null;
//        org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationClassificationComponent();
//        copyElement(src, tgt);
//        if (src.hasDomain())
//            tgt.setDomain(convertCodeableConcept(src.getDomain()));
//        if (src.hasClassification())
//            tgt.setClassification(convertCodeableConcept(src.getClassification()));
//        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubtype()) tgt.addSubtype(convertCodeableConcept(t));
//        for (org.hl7.fhir.r5.model.Reference t : src.getSource()) tgt.addSource(convertReference(t));
//        return tgt;
//    }
//
  public static org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent convertSubstanceReferenceInformationTargetComponent(org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent tgt = new org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Identifier40_50.convertIdentifier(src.getTarget()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasInteraction())
      tgt.setInteraction(CodeableConcept40_50.convertCodeableConcept(src.getInteraction()));
    if (src.hasOrganism())
      tgt.setOrganism(CodeableConcept40_50.convertCodeableConcept(src.getOrganism()));
    if (src.hasOrganismType())
      tgt.setOrganismType(CodeableConcept40_50.convertCodeableConcept(src.getOrganismType()));
    if (src.hasAmount())
      tgt.setAmount(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAmount()));
    if (src.hasAmountType())
      tgt.setAmountType(CodeableConcept40_50.convertCodeableConcept(src.getAmountType()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSource()) tgt.addSource(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent convertSubstanceReferenceInformationTargetComponent(org.hl7.fhir.r5.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent tgt = new org.hl7.fhir.r4.model.SubstanceReferenceInformation.SubstanceReferenceInformationTargetComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Identifier40_50.convertIdentifier(src.getTarget()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasInteraction())
      tgt.setInteraction(CodeableConcept40_50.convertCodeableConcept(src.getInteraction()));
    if (src.hasOrganism())
      tgt.setOrganism(CodeableConcept40_50.convertCodeableConcept(src.getOrganism()));
    if (src.hasOrganismType())
      tgt.setOrganismType(CodeableConcept40_50.convertCodeableConcept(src.getOrganismType()));
    if (src.hasAmount())
      tgt.setAmount(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAmount()));
    if (src.hasAmountType())
      tgt.setAmountType(CodeableConcept40_50.convertCodeableConcept(src.getAmountType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSource()) tgt.addSource(Reference40_50.convertReference(t));
    return tgt;
  }
}