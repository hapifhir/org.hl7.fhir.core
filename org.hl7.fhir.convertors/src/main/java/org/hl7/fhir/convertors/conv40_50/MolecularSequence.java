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


public class MolecularSequence extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MolecularSequence convertMolecularSequence(org.hl7.fhir.r4.model.MolecularSequence src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MolecularSequence tgt = new org.hl7.fhir.r5.model.MolecularSequence();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertSequenceType(src.getType()));
    if (src.hasCoordinateSystem())
      tgt.setCoordinateSystemElement(convertInteger(src.getCoordinateSystemElement()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasSpecimen())
      tgt.setSpecimen(convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(convertReference(src.getDevice()));
    if (src.hasPerformer())
      tgt.setPerformer(convertReference(src.getPerformer()));
    if (src.hasQuantity())
      tgt.setQuantity(convertQuantity(src.getQuantity()));
    if (src.hasReferenceSeq())
      tgt.setReferenceSeq(convertMolecularSequenceReferenceSeqComponent(src.getReferenceSeq()));
    for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent t : src.getVariant())
      tgt.addVariant(convertMolecularSequenceVariantComponent(t));
    if (src.hasObservedSeq())
      tgt.setObservedSeqElement(convertString(src.getObservedSeqElement()));
    for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent t : src.getQuality())
      tgt.addQuality(convertMolecularSequenceQualityComponent(t));
    if (src.hasReadCoverage())
      tgt.setReadCoverageElement(convertInteger(src.getReadCoverageElement()));
    for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent t : src.getRepository())
      tgt.addRepository(convertMolecularSequenceRepositoryComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPointer())
      tgt.addPointer(convertReference(t));
    for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantComponent t : src.getStructureVariant())
      tgt.addStructureVariant(convertMolecularSequenceStructureVariantComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MolecularSequence convertMolecularSequence(org.hl7.fhir.r5.model.MolecularSequence src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MolecularSequence tgt = new org.hl7.fhir.r4.model.MolecularSequence();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasType())
      tgt.setType(convertSequenceType(src.getType()));
    if (src.hasCoordinateSystem())
      tgt.setCoordinateSystemElement(convertInteger(src.getCoordinateSystemElement()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasSpecimen())
      tgt.setSpecimen(convertReference(src.getSpecimen()));
    if (src.hasDevice())
      tgt.setDevice(convertReference(src.getDevice()));
    if (src.hasPerformer())
      tgt.setPerformer(convertReference(src.getPerformer()));
    if (src.hasQuantity())
      tgt.setQuantity(convertQuantity(src.getQuantity()));
    if (src.hasReferenceSeq())
      tgt.setReferenceSeq(convertMolecularSequenceReferenceSeqComponent(src.getReferenceSeq()));
    for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent t : src.getVariant())
      tgt.addVariant(convertMolecularSequenceVariantComponent(t));
    if (src.hasObservedSeq())
      tgt.setObservedSeqElement(convertString(src.getObservedSeqElement()));
    for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent t : src.getQuality())
      tgt.addQuality(convertMolecularSequenceQualityComponent(t));
    if (src.hasReadCoverage())
      tgt.setReadCoverageElement(convertInteger(src.getReadCoverageElement()));
    for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent t : src.getRepository())
      tgt.addRepository(convertMolecularSequenceRepositoryComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPointer())
      tgt.addPointer(convertReference(t));
    for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantComponent t : src.getStructureVariant())
      tgt.addStructureVariant(convertMolecularSequenceStructureVariantComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MolecularSequence.SequenceType convertSequenceType(org.hl7.fhir.r4.model.MolecularSequence.SequenceType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AA: return org.hl7.fhir.r5.model.MolecularSequence.SequenceType.AA;
    case DNA: return org.hl7.fhir.r5.model.MolecularSequence.SequenceType.DNA;
    case RNA: return org.hl7.fhir.r5.model.MolecularSequence.SequenceType.RNA;
    default: return org.hl7.fhir.r5.model.MolecularSequence.SequenceType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MolecularSequence.SequenceType convertSequenceType(org.hl7.fhir.r5.model.MolecularSequence.SequenceType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AA: return org.hl7.fhir.r4.model.MolecularSequence.SequenceType.AA;
    case DNA: return org.hl7.fhir.r4.model.MolecularSequence.SequenceType.DNA;
    case RNA: return org.hl7.fhir.r4.model.MolecularSequence.SequenceType.RNA;
    default: return org.hl7.fhir.r4.model.MolecularSequence.SequenceType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent convertMolecularSequenceReferenceSeqComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent();
    copyElement(src, tgt);
    if (src.hasChromosome())
      tgt.setChromosome(convertCodeableConcept(src.getChromosome()));
    if (src.hasGenomeBuild())
      tgt.setGenomeBuildElement(convertString(src.getGenomeBuildElement()));
    if (src.hasOrientation())
      tgt.setOrientation(convertOrientationType(src.getOrientation()));
    if (src.hasReferenceSeqId())
      tgt.setReferenceSeqId(convertCodeableConcept(src.getReferenceSeqId()));
    if (src.hasReferenceSeqPointer())
      tgt.setReferenceSeqPointer(convertReference(src.getReferenceSeqPointer()));
    if (src.hasReferenceSeqString())
      tgt.setReferenceSeqStringElement(convertString(src.getReferenceSeqStringElement()));
    if (src.hasStrand())
      tgt.setStrand(convertStrandType(src.getStrand()));
    if (src.hasWindowStart())
      tgt.setWindowStartElement(convertInteger(src.getWindowStartElement()));
    if (src.hasWindowEnd())
      tgt.setWindowEndElement(convertInteger(src.getWindowEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent convertMolecularSequenceReferenceSeqComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent();
    copyElement(src, tgt);
    if (src.hasChromosome())
      tgt.setChromosome(convertCodeableConcept(src.getChromosome()));
    if (src.hasGenomeBuild())
      tgt.setGenomeBuildElement(convertString(src.getGenomeBuildElement()));
    if (src.hasOrientation())
      tgt.setOrientation(convertOrientationType(src.getOrientation()));
    if (src.hasReferenceSeqId())
      tgt.setReferenceSeqId(convertCodeableConcept(src.getReferenceSeqId()));
    if (src.hasReferenceSeqPointer())
      tgt.setReferenceSeqPointer(convertReference(src.getReferenceSeqPointer()));
    if (src.hasReferenceSeqString())
      tgt.setReferenceSeqStringElement(convertString(src.getReferenceSeqStringElement()));
    if (src.hasStrand())
      tgt.setStrand(convertStrandType(src.getStrand()));
    if (src.hasWindowStart())
      tgt.setWindowStartElement(convertInteger(src.getWindowStartElement()));
    if (src.hasWindowEnd())
      tgt.setWindowEndElement(convertInteger(src.getWindowEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MolecularSequence.OrientationType convertOrientationType(org.hl7.fhir.r4.model.MolecularSequence.OrientationType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SENSE: return org.hl7.fhir.r5.model.MolecularSequence.OrientationType.SENSE;
    case ANTISENSE: return org.hl7.fhir.r5.model.MolecularSequence.OrientationType.ANTISENSE;
    default: return org.hl7.fhir.r5.model.MolecularSequence.OrientationType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MolecularSequence.OrientationType convertOrientationType(org.hl7.fhir.r5.model.MolecularSequence.OrientationType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SENSE: return org.hl7.fhir.r4.model.MolecularSequence.OrientationType.SENSE;
    case ANTISENSE: return org.hl7.fhir.r4.model.MolecularSequence.OrientationType.ANTISENSE;
    default: return org.hl7.fhir.r4.model.MolecularSequence.OrientationType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MolecularSequence.StrandType convertStrandType(org.hl7.fhir.r4.model.MolecularSequence.StrandType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case WATSON: return org.hl7.fhir.r5.model.MolecularSequence.StrandType.WATSON;
    case CRICK: return org.hl7.fhir.r5.model.MolecularSequence.StrandType.CRICK;
    default: return org.hl7.fhir.r5.model.MolecularSequence.StrandType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MolecularSequence.StrandType convertStrandType(org.hl7.fhir.r5.model.MolecularSequence.StrandType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case WATSON: return org.hl7.fhir.r4.model.MolecularSequence.StrandType.WATSON;
    case CRICK: return org.hl7.fhir.r4.model.MolecularSequence.StrandType.CRICK;
    default: return org.hl7.fhir.r4.model.MolecularSequence.StrandType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent convertMolecularSequenceVariantComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent();
    copyElement(src, tgt);
    if (src.hasStart())
      tgt.setStartElement(convertInteger(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertInteger(src.getEndElement()));
    if (src.hasObservedAllele())
      tgt.setObservedAlleleElement(convertString(src.getObservedAlleleElement()));
    if (src.hasReferenceAllele())
      tgt.setReferenceAlleleElement(convertString(src.getReferenceAlleleElement()));
    if (src.hasCigar())
      tgt.setCigarElement(convertString(src.getCigarElement()));
    if (src.hasVariantPointer())
      tgt.setVariantPointer(convertReference(src.getVariantPointer()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent convertMolecularSequenceVariantComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent();
    copyElement(src, tgt);
    if (src.hasStart())
      tgt.setStartElement(convertInteger(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertInteger(src.getEndElement()));
    if (src.hasObservedAllele())
      tgt.setObservedAlleleElement(convertString(src.getObservedAlleleElement()));
    if (src.hasReferenceAllele())
      tgt.setReferenceAlleleElement(convertString(src.getReferenceAlleleElement()));
    if (src.hasCigar())
      tgt.setCigarElement(convertString(src.getCigarElement()));
    if (src.hasVariantPointer())
      tgt.setVariantPointer(convertReference(src.getVariantPointer()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent convertMolecularSequenceQualityComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertQualityType(src.getType()));
    if (src.hasStandardSequence())
      tgt.setStandardSequence(convertCodeableConcept(src.getStandardSequence()));
    if (src.hasStart())
      tgt.setStartElement(convertInteger(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertInteger(src.getEndElement()));
    if (src.hasScore())
      tgt.setScore(convertQuantity(src.getScore()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasTruthTP())
      tgt.setTruthTPElement(convertDecimal(src.getTruthTPElement()));
    if (src.hasQueryTP())
      tgt.setQueryTPElement(convertDecimal(src.getQueryTPElement()));
    if (src.hasTruthFN())
      tgt.setTruthFNElement(convertDecimal(src.getTruthFNElement()));
    if (src.hasQueryFP())
      tgt.setQueryFPElement(convertDecimal(src.getQueryFPElement()));
    if (src.hasGtFP())
      tgt.setGtFPElement(convertDecimal(src.getGtFPElement()));
    if (src.hasPrecision())
      tgt.setPrecisionElement(convertDecimal(src.getPrecisionElement()));
    if (src.hasRecall())
      tgt.setRecallElement(convertDecimal(src.getRecallElement()));
    if (src.hasFScore())
      tgt.setFScoreElement(convertDecimal(src.getFScoreElement()));
    if (src.hasRoc())
      tgt.setRoc(convertMolecularSequenceQualityRocComponent(src.getRoc()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent convertMolecularSequenceQualityComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertQualityType(src.getType()));
    if (src.hasStandardSequence())
      tgt.setStandardSequence(convertCodeableConcept(src.getStandardSequence()));
    if (src.hasStart())
      tgt.setStartElement(convertInteger(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertInteger(src.getEndElement()));
    if (src.hasScore())
      tgt.setScore(convertQuantity(src.getScore()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    if (src.hasTruthTP())
      tgt.setTruthTPElement(convertDecimal(src.getTruthTPElement()));
    if (src.hasQueryTP())
      tgt.setQueryTPElement(convertDecimal(src.getQueryTPElement()));
    if (src.hasTruthFN())
      tgt.setTruthFNElement(convertDecimal(src.getTruthFNElement()));
    if (src.hasQueryFP())
      tgt.setQueryFPElement(convertDecimal(src.getQueryFPElement()));
    if (src.hasGtFP())
      tgt.setGtFPElement(convertDecimal(src.getGtFPElement()));
    if (src.hasPrecision())
      tgt.setPrecisionElement(convertDecimal(src.getPrecisionElement()));
    if (src.hasRecall())
      tgt.setRecallElement(convertDecimal(src.getRecallElement()));
    if (src.hasFScore())
      tgt.setFScoreElement(convertDecimal(src.getFScoreElement()));
    if (src.hasRoc())
      tgt.setRoc(convertMolecularSequenceQualityRocComponent(src.getRoc()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MolecularSequence.QualityType convertQualityType(org.hl7.fhir.r4.model.MolecularSequence.QualityType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INDEL: return org.hl7.fhir.r5.model.MolecularSequence.QualityType.INDEL;
    case SNP: return org.hl7.fhir.r5.model.MolecularSequence.QualityType.SNP;
    case UNKNOWN: return org.hl7.fhir.r5.model.MolecularSequence.QualityType.UNKNOWN;
    default: return org.hl7.fhir.r5.model.MolecularSequence.QualityType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MolecularSequence.QualityType convertQualityType(org.hl7.fhir.r5.model.MolecularSequence.QualityType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INDEL: return org.hl7.fhir.r4.model.MolecularSequence.QualityType.INDEL;
    case SNP: return org.hl7.fhir.r4.model.MolecularSequence.QualityType.SNP;
    case UNKNOWN: return org.hl7.fhir.r4.model.MolecularSequence.QualityType.UNKNOWN;
    default: return org.hl7.fhir.r4.model.MolecularSequence.QualityType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityRocComponent convertMolecularSequenceQualityRocComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityRocComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityRocComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityRocComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.IntegerType t : src.getScore())
      tgt.getScore().add(convertInteger(t));
    for (org.hl7.fhir.r4.model.IntegerType t : src.getNumTP())
      tgt.getNumTP().add(convertInteger(t));
    for (org.hl7.fhir.r4.model.IntegerType t : src.getNumFP())
      tgt.getNumFP().add(convertInteger(t));
    for (org.hl7.fhir.r4.model.IntegerType t : src.getNumFN())
      tgt.getNumFN().add(convertInteger(t));
    for (org.hl7.fhir.r4.model.DecimalType t : src.getPrecision())
      tgt.getPrecision().add(convertDecimal(t));
    for (org.hl7.fhir.r4.model.DecimalType t : src.getSensitivity())
      tgt.getSensitivity().add(convertDecimal(t));
    for (org.hl7.fhir.r4.model.DecimalType t : src.getFMeasure())
      tgt.getFMeasure().add(convertDecimal(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityRocComponent convertMolecularSequenceQualityRocComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityRocComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityRocComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityRocComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.IntegerType t : src.getScore())
      tgt.getScore().add(convertInteger(t));
    for (org.hl7.fhir.r5.model.IntegerType t : src.getNumTP())
      tgt.getNumTP().add(convertInteger(t));
    for (org.hl7.fhir.r5.model.IntegerType t : src.getNumFP())
      tgt.getNumFP().add(convertInteger(t));
    for (org.hl7.fhir.r5.model.IntegerType t : src.getNumFN())
      tgt.getNumFN().add(convertInteger(t));
    for (org.hl7.fhir.r5.model.DecimalType t : src.getPrecision())
      tgt.getPrecision().add(convertDecimal(t));
    for (org.hl7.fhir.r5.model.DecimalType t : src.getSensitivity())
      tgt.getSensitivity().add(convertDecimal(t));
    for (org.hl7.fhir.r5.model.DecimalType t : src.getFMeasure())
      tgt.getFMeasure().add(convertDecimal(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent convertMolecularSequenceRepositoryComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertRepositoryType(src.getType()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDatasetId())
      tgt.setDatasetIdElement(convertString(src.getDatasetIdElement()));
    if (src.hasVariantsetId())
      tgt.setVariantsetIdElement(convertString(src.getVariantsetIdElement()));
    if (src.hasReadsetId())
      tgt.setReadsetIdElement(convertString(src.getReadsetIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent convertMolecularSequenceRepositoryComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertRepositoryType(src.getType()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDatasetId())
      tgt.setDatasetIdElement(convertString(src.getDatasetIdElement()));
    if (src.hasVariantsetId())
      tgt.setVariantsetIdElement(convertString(src.getVariantsetIdElement()));
    if (src.hasReadsetId())
      tgt.setReadsetIdElement(convertString(src.getReadsetIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MolecularSequence.RepositoryType convertRepositoryType(org.hl7.fhir.r4.model.MolecularSequence.RepositoryType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DIRECTLINK: return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.DIRECTLINK;
    case OPENAPI: return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.OPENAPI;
    case LOGIN: return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.LOGIN;
    case OAUTH: return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.OAUTH;
    case OTHER: return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.OTHER;
    default: return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MolecularSequence.RepositoryType convertRepositoryType(org.hl7.fhir.r5.model.MolecularSequence.RepositoryType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DIRECTLINK: return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.DIRECTLINK;
    case OPENAPI: return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.OPENAPI;
    case LOGIN: return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.LOGIN;
    case OAUTH: return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.OAUTH;
    case OTHER: return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.OTHER;
    default: return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantComponent convertMolecularSequenceStructureVariantComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantComponent();
    copyElement(src, tgt);
    if (src.hasVariantType())
      tgt.setVariantType(convertCodeableConcept(src.getVariantType()));
    if (src.hasExact())
      tgt.setExactElement(convertBoolean(src.getExactElement()));
    if (src.hasLength())
      tgt.setLengthElement(convertInteger(src.getLengthElement()));
    if (src.hasOuter())
      tgt.setOuter(convertMolecularSequenceStructureVariantOuterComponent(src.getOuter()));
    if (src.hasInner())
      tgt.setInner(convertMolecularSequenceStructureVariantInnerComponent(src.getInner()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantComponent convertMolecularSequenceStructureVariantComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantComponent();
    copyElement(src, tgt);
    if (src.hasVariantType())
      tgt.setVariantType(convertCodeableConcept(src.getVariantType()));
    if (src.hasExact())
      tgt.setExactElement(convertBoolean(src.getExactElement()));
    if (src.hasLength())
      tgt.setLengthElement(convertInteger(src.getLengthElement()));
    if (src.hasOuter())
      tgt.setOuter(convertMolecularSequenceStructureVariantOuterComponent(src.getOuter()));
    if (src.hasInner())
      tgt.setInner(convertMolecularSequenceStructureVariantInnerComponent(src.getInner()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent convertMolecularSequenceStructureVariantOuterComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent();
    copyElement(src, tgt);
    if (src.hasStart())
      tgt.setStartElement(convertInteger(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertInteger(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent convertMolecularSequenceStructureVariantOuterComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent();
    copyElement(src, tgt);
    if (src.hasStart())
      tgt.setStartElement(convertInteger(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertInteger(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent convertMolecularSequenceStructureVariantInnerComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent();
    copyElement(src, tgt);
    if (src.hasStart())
      tgt.setStartElement(convertInteger(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertInteger(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent convertMolecularSequenceStructureVariantInnerComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent();
    copyElement(src, tgt);
    if (src.hasStart())
      tgt.setStartElement(convertInteger(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(convertInteger(src.getEndElement()));
    return tgt;
  }


}
