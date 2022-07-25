package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Attachment40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
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
public class SubstancePolymer40_50 {

  public static org.hl7.fhir.r5.model.SubstancePolymer convertSubstancePolymer(org.hl7.fhir.r4.model.SubstancePolymer src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstancePolymer tgt = new org.hl7.fhir.r5.model.SubstancePolymer();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasClass_())
      tgt.setClass_(CodeableConcept40_50.convertCodeableConcept(src.getClass_()));
    if (src.hasGeometry())
      tgt.setGeometry(CodeableConcept40_50.convertCodeableConcept(src.getGeometry()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCopolymerConnectivity())
      tgt.addCopolymerConnectivity(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getModification())
      tgt.setModificationElement(String40_50.convertString(t));
    for (org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetComponent t : src.getMonomerSet())
      tgt.addMonomerSet(convertSubstancePolymerMonomerSetComponent(t));
    for (org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatComponent t : src.getRepeat())
      tgt.addRepeat(convertSubstancePolymerRepeatComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstancePolymer convertSubstancePolymer(org.hl7.fhir.r5.model.SubstancePolymer src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstancePolymer tgt = new org.hl7.fhir.r4.model.SubstancePolymer();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasClass_())
      tgt.setClass_(CodeableConcept40_50.convertCodeableConcept(src.getClass_()));
    if (src.hasGeometry())
      tgt.setGeometry(CodeableConcept40_50.convertCodeableConcept(src.getGeometry()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCopolymerConnectivity())
      tgt.addCopolymerConnectivity(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasModification()) tgt.getModification().add(String40_50.convertString(src.getModificationElement()));
    for (org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetComponent t : src.getMonomerSet())
      tgt.addMonomerSet(convertSubstancePolymerMonomerSetComponent(t));
    for (org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatComponent t : src.getRepeat())
      tgt.addRepeat(convertSubstancePolymerRepeatComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetComponent convertSubstancePolymerMonomerSetComponent(org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetComponent tgt = new org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRatioType())
      tgt.setRatioType(CodeableConcept40_50.convertCodeableConcept(src.getRatioType()));
    for (org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent t : src.getStartingMaterial())
      tgt.addStartingMaterial(convertSubstancePolymerMonomerSetStartingMaterialComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetComponent convertSubstancePolymerMonomerSetComponent(org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetComponent tgt = new org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRatioType())
      tgt.setRatioType(CodeableConcept40_50.convertCodeableConcept(src.getRatioType()));
    for (org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent t : src.getStartingMaterial())
      tgt.addStartingMaterial(convertSubstancePolymerMonomerSetStartingMaterialComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent convertSubstancePolymerMonomerSetStartingMaterialComponent(org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent tgt = new org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMaterial())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getMaterial()));
    if (src.hasType())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasIsDefining())
      tgt.setIsDefiningElement(Boolean40_50.convertBoolean(src.getIsDefiningElement()));
// todo
//        if (src.hasAmount())
//            tgt.setAmount(convertSubstanceAmount(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent convertSubstancePolymerMonomerSetStartingMaterialComponent(org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent tgt = new org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerMonomerSetStartingMaterialComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setMaterial(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasIsDefining())
      tgt.setIsDefiningElement(Boolean40_50.convertBoolean(src.getIsDefiningElement()));
    // todo
//        if (src.hasAmount())
//            tgt.setAmount(convertSubstanceAmount(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatComponent convertSubstancePolymerRepeatComponent(org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatComponent tgt = new org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    // todo
//        if (src.hasNumberOfUnits())
//            tgt.setNumberOfUnitsElement(convertInteger(src.getNumberOfUnitsElement()));
    if (src.hasAverageMolecularFormula())
      tgt.setAverageMolecularFormulaElement(String40_50.convertString(src.getAverageMolecularFormulaElement()));
    if (src.hasRepeatUnitAmountType())
      tgt.setRepeatUnitAmountType(CodeableConcept40_50.convertCodeableConcept(src.getRepeatUnitAmountType()));
    for (org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent t : src.getRepeatUnit())
      tgt.addRepeatUnit(convertSubstancePolymerRepeatRepeatUnitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatComponent convertSubstancePolymerRepeatComponent(org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatComponent tgt = new org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    // todo
//        if (src.hasNumberOfUnits())
//            tgt.setNumberOfUnitsElement(convertInteger(src.getNumberOfUnitsElement()));
    if (src.hasAverageMolecularFormula())
      tgt.setAverageMolecularFormulaElement(String40_50.convertString(src.getAverageMolecularFormulaElement()));
    if (src.hasRepeatUnitAmountType())
      tgt.setRepeatUnitAmountType(CodeableConcept40_50.convertCodeableConcept(src.getRepeatUnitAmountType()));
    for (org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent t : src.getRepeatUnit())
      tgt.addRepeatUnit(convertSubstancePolymerRepeatRepeatUnitComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent convertSubstancePolymerRepeatRepeatUnitComponent(org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent tgt = new org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOrientationOfPolymerisation())
      tgt.setOrientation(CodeableConcept40_50.convertCodeableConcept(src.getOrientationOfPolymerisation()));
    if (src.hasRepeatUnit())
      tgt.setUnitElement(String40_50.convertString(src.getRepeatUnitElement()));
    // todo
//        if (src.hasAmount())
//            tgt.setAmount(convertSubstanceAmount(src.getAmount()));
    for (org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent t : src.getDegreeOfPolymerisation())
      tgt.addDegreeOfPolymerisation(convertSubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent(t));
    for (org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent t : src.getStructuralRepresentation())
      tgt.addStructuralRepresentation(convertSubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent convertSubstancePolymerRepeatRepeatUnitComponent(org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent tgt = new org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOrientation())
      tgt.setOrientationOfPolymerisation(CodeableConcept40_50.convertCodeableConcept(src.getOrientation()));
    if (src.hasUnit())
      tgt.setRepeatUnitElement(String40_50.convertString(src.getUnitElement()));
    // todo
//        if (src.hasAmount())
//            tgt.setAmount(convertSubstanceAmount(src.getAmount()));
    for (org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent t : src.getDegreeOfPolymerisation())
      tgt.addDegreeOfPolymerisation(convertSubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent(t));
    for (org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent t : src.getStructuralRepresentation())
      tgt.addStructuralRepresentation(convertSubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent convertSubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent(org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent tgt = new org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    // todo
//        if (src.hasDegree())
//            tgt.setDegree(convertCodeableConcept(src.getDegree()));
//        if (src.hasAmount())
//            tgt.setAmount(convertSubstanceAmount(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent convertSubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent(org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent tgt = new org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitDegreeOfPolymerisationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    // todo
//        if (src.hasDegree())
//            tgt.setDegree(convertCodeableConcept(src.getDegree()));
//        if (src.hasAmount())
//            tgt.setAmount(convertSubstanceAmount(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent convertSubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent(org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent tgt = new org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasRepresentation())
      tgt.setRepresentationElement(String40_50.convertString(src.getRepresentationElement()));
    if (src.hasAttachment())
      tgt.setAttachment(Attachment40_50.convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent convertSubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent(org.hl7.fhir.r5.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent tgt = new org.hl7.fhir.r4.model.SubstancePolymer.SubstancePolymerRepeatRepeatUnitStructuralRepresentationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasRepresentation())
      tgt.setRepresentationElement(String40_50.convertString(src.getRepresentationElement()));
    if (src.hasAttachment())
      tgt.setAttachment(Attachment40_50.convertAttachment(src.getAttachment()));
    return tgt;
  }
}