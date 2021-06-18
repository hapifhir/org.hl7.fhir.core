package org.hl7.fhir.convertors.conv40_50.resources40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Element40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Quantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.*;
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
public class MolecularSequence40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.MolecularSequence convertMolecularSequence(org.hl7.fhir.r4.model.MolecularSequence src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence tgt = new org.hl7.fhir.r5.model.MolecularSequence();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        if (src.hasType())
            tgt.setTypeElement(convertSequenceType(src.getTypeElement()));
        if (src.hasCoordinateSystem())
            tgt.setCoordinateSystemElement(Integer40_50.convertInteger(src.getCoordinateSystemElement()));
        if (src.hasPatient())
            tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
        if (src.hasSpecimen())
            tgt.setSpecimen(Reference40_50.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(Reference40_50.convertReference(src.getDevice()));
        if (src.hasPerformer())
            tgt.setPerformer(Reference40_50.convertReference(src.getPerformer()));
        if (src.hasQuantity())
            tgt.setQuantity(Quantity40_50.convertQuantity(src.getQuantity()));
        if (src.hasReferenceSeq())
            tgt.setReferenceSeq(convertMolecularSequenceReferenceSeqComponent(src.getReferenceSeq()));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent t : src.getVariant()) tgt.addVariant(convertMolecularSequenceVariantComponent(t));
        if (src.hasObservedSeq())
            tgt.setObservedSeqElement(String40_50.convertString(src.getObservedSeqElement()));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent t : src.getQuality()) tgt.addQuality(convertMolecularSequenceQualityComponent(t));
        if (src.hasReadCoverage())
            tgt.setReadCoverageElement(Integer40_50.convertInteger(src.getReadCoverageElement()));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent t : src.getRepository()) tgt.addRepository(convertMolecularSequenceRepositoryComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPointer()) tgt.addPointer(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantComponent t : src.getStructureVariant()) tgt.addStructureVariant(convertMolecularSequenceStructureVariantComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence convertMolecularSequence(org.hl7.fhir.r5.model.MolecularSequence src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence tgt = new org.hl7.fhir.r4.model.MolecularSequence();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        if (src.hasType())
            tgt.setTypeElement(convertSequenceType(src.getTypeElement()));
        if (src.hasCoordinateSystem())
            tgt.setCoordinateSystemElement(Integer40_50.convertInteger(src.getCoordinateSystemElement()));
        if (src.hasPatient())
            tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
        if (src.hasSpecimen())
            tgt.setSpecimen(Reference40_50.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(Reference40_50.convertReference(src.getDevice()));
        if (src.hasPerformer())
            tgt.setPerformer(Reference40_50.convertReference(src.getPerformer()));
        if (src.hasQuantity())
            tgt.setQuantity(Quantity40_50.convertQuantity(src.getQuantity()));
        if (src.hasReferenceSeq())
            tgt.setReferenceSeq(convertMolecularSequenceReferenceSeqComponent(src.getReferenceSeq()));
        for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent t : src.getVariant()) tgt.addVariant(convertMolecularSequenceVariantComponent(t));
        if (src.hasObservedSeq())
            tgt.setObservedSeqElement(String40_50.convertString(src.getObservedSeqElement()));
        for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent t : src.getQuality()) tgt.addQuality(convertMolecularSequenceQualityComponent(t));
        if (src.hasReadCoverage())
            tgt.setReadCoverageElement(Integer40_50.convertInteger(src.getReadCoverageElement()));
        for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent t : src.getRepository()) tgt.addRepository(convertMolecularSequenceRepositoryComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getPointer()) tgt.addPointer(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantComponent t : src.getStructureVariant()) tgt.addStructureVariant(convertMolecularSequenceStructureVariantComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.SequenceType> convertSequenceType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.SequenceType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.SequenceType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MolecularSequence.SequenceTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AA:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.SequenceType.AA);
                break;
            case DNA:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.SequenceType.DNA);
                break;
            case RNA:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.SequenceType.RNA);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.SequenceType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.SequenceType> convertSequenceType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.SequenceType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.SequenceType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MolecularSequence.SequenceTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AA:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.SequenceType.AA);
                break;
            case DNA:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.SequenceType.DNA);
                break;
            case RNA:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.SequenceType.RNA);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.SequenceType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent convertMolecularSequenceReferenceSeqComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasChromosome())
            tgt.setChromosome(CodeableConcept40_50.convertCodeableConcept(src.getChromosome()));
        if (src.hasGenomeBuild())
            tgt.setGenomeBuildElement(String40_50.convertString(src.getGenomeBuildElement()));
        if (src.hasOrientation())
            tgt.setOrientationElement(convertOrientationType(src.getOrientationElement()));
        if (src.hasReferenceSeqId())
            tgt.setReferenceSeqId(CodeableConcept40_50.convertCodeableConcept(src.getReferenceSeqId()));
        if (src.hasReferenceSeqPointer())
            tgt.setReferenceSeqPointer(Reference40_50.convertReference(src.getReferenceSeqPointer()));
        if (src.hasReferenceSeqString())
            tgt.setReferenceSeqStringElement(String40_50.convertString(src.getReferenceSeqStringElement()));
        if (src.hasStrand())
            tgt.setStrandElement(convertStrandType(src.getStrandElement()));
        if (src.hasWindowStart())
            tgt.setWindowStartElement(Integer40_50.convertInteger(src.getWindowStartElement()));
        if (src.hasWindowEnd())
            tgt.setWindowEndElement(Integer40_50.convertInteger(src.getWindowEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent convertMolecularSequenceReferenceSeqComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasChromosome())
            tgt.setChromosome(CodeableConcept40_50.convertCodeableConcept(src.getChromosome()));
        if (src.hasGenomeBuild())
            tgt.setGenomeBuildElement(String40_50.convertString(src.getGenomeBuildElement()));
        if (src.hasOrientation())
            tgt.setOrientationElement(convertOrientationType(src.getOrientationElement()));
        if (src.hasReferenceSeqId())
            tgt.setReferenceSeqId(CodeableConcept40_50.convertCodeableConcept(src.getReferenceSeqId()));
        if (src.hasReferenceSeqPointer())
            tgt.setReferenceSeqPointer(Reference40_50.convertReference(src.getReferenceSeqPointer()));
        if (src.hasReferenceSeqString())
            tgt.setReferenceSeqStringElement(String40_50.convertString(src.getReferenceSeqStringElement()));
        if (src.hasStrand())
            tgt.setStrandElement(convertStrandType(src.getStrandElement()));
        if (src.hasWindowStart())
            tgt.setWindowStartElement(Integer40_50.convertInteger(src.getWindowStartElement()));
        if (src.hasWindowEnd())
            tgt.setWindowEndElement(Integer40_50.convertInteger(src.getWindowEndElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.OrientationType> convertOrientationType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.OrientationType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.OrientationType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MolecularSequence.OrientationTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SENSE:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.OrientationType.SENSE);
                break;
            case ANTISENSE:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.OrientationType.ANTISENSE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.OrientationType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.OrientationType> convertOrientationType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.OrientationType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.OrientationType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MolecularSequence.OrientationTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SENSE:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.OrientationType.SENSE);
                break;
            case ANTISENSE:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.OrientationType.ANTISENSE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.OrientationType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.StrandType> convertStrandType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.StrandType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.StrandType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MolecularSequence.StrandTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case WATSON:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.StrandType.WATSON);
                break;
            case CRICK:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.StrandType.CRICK);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.StrandType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.StrandType> convertStrandType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.StrandType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.StrandType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MolecularSequence.StrandTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case WATSON:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.StrandType.WATSON);
                break;
            case CRICK:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.StrandType.CRICK);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.StrandType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent convertMolecularSequenceVariantComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(Integer40_50.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer40_50.convertInteger(src.getEndElement()));
        if (src.hasObservedAllele())
            tgt.setObservedAlleleElement(String40_50.convertString(src.getObservedAlleleElement()));
        if (src.hasReferenceAllele())
            tgt.setReferenceAlleleElement(String40_50.convertString(src.getReferenceAlleleElement()));
        if (src.hasCigar())
            tgt.setCigarElement(String40_50.convertString(src.getCigarElement()));
        if (src.hasVariantPointer())
            tgt.setVariantPointer(Reference40_50.convertReference(src.getVariantPointer()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent convertMolecularSequenceVariantComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(Integer40_50.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer40_50.convertInteger(src.getEndElement()));
        if (src.hasObservedAllele())
            tgt.setObservedAlleleElement(String40_50.convertString(src.getObservedAlleleElement()));
        if (src.hasReferenceAllele())
            tgt.setReferenceAlleleElement(String40_50.convertString(src.getReferenceAlleleElement()));
        if (src.hasCigar())
            tgt.setCigarElement(String40_50.convertString(src.getCigarElement()));
        if (src.hasVariantPointer())
            tgt.setVariantPointer(Reference40_50.convertReference(src.getVariantPointer()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent convertMolecularSequenceQualityComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertQualityType(src.getTypeElement()));
        if (src.hasStandardSequence())
            tgt.setStandardSequence(CodeableConcept40_50.convertCodeableConcept(src.getStandardSequence()));
        if (src.hasStart())
            tgt.setStartElement(Integer40_50.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer40_50.convertInteger(src.getEndElement()));
        if (src.hasScore())
            tgt.setScore(Quantity40_50.convertQuantity(src.getScore()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept40_50.convertCodeableConcept(src.getMethod()));
        if (src.hasTruthTP())
            tgt.setTruthTPElement(Decimal40_50.convertDecimal(src.getTruthTPElement()));
        if (src.hasQueryTP())
            tgt.setQueryTPElement(Decimal40_50.convertDecimal(src.getQueryTPElement()));
        if (src.hasTruthFN())
            tgt.setTruthFNElement(Decimal40_50.convertDecimal(src.getTruthFNElement()));
        if (src.hasQueryFP())
            tgt.setQueryFPElement(Decimal40_50.convertDecimal(src.getQueryFPElement()));
        if (src.hasGtFP())
            tgt.setGtFPElement(Decimal40_50.convertDecimal(src.getGtFPElement()));
        if (src.hasPrecision())
            tgt.setPrecisionElement(Decimal40_50.convertDecimal(src.getPrecisionElement()));
        if (src.hasRecall())
            tgt.setRecallElement(Decimal40_50.convertDecimal(src.getRecallElement()));
        if (src.hasFScore())
            tgt.setFScoreElement(Decimal40_50.convertDecimal(src.getFScoreElement()));
        if (src.hasRoc())
            tgt.setRoc(convertMolecularSequenceQualityRocComponent(src.getRoc()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent convertMolecularSequenceQualityComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertQualityType(src.getTypeElement()));
        if (src.hasStandardSequence())
            tgt.setStandardSequence(CodeableConcept40_50.convertCodeableConcept(src.getStandardSequence()));
        if (src.hasStart())
            tgt.setStartElement(Integer40_50.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer40_50.convertInteger(src.getEndElement()));
        if (src.hasScore())
            tgt.setScore(Quantity40_50.convertQuantity(src.getScore()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept40_50.convertCodeableConcept(src.getMethod()));
        if (src.hasTruthTP())
            tgt.setTruthTPElement(Decimal40_50.convertDecimal(src.getTruthTPElement()));
        if (src.hasQueryTP())
            tgt.setQueryTPElement(Decimal40_50.convertDecimal(src.getQueryTPElement()));
        if (src.hasTruthFN())
            tgt.setTruthFNElement(Decimal40_50.convertDecimal(src.getTruthFNElement()));
        if (src.hasQueryFP())
            tgt.setQueryFPElement(Decimal40_50.convertDecimal(src.getQueryFPElement()));
        if (src.hasGtFP())
            tgt.setGtFPElement(Decimal40_50.convertDecimal(src.getGtFPElement()));
        if (src.hasPrecision())
            tgt.setPrecisionElement(Decimal40_50.convertDecimal(src.getPrecisionElement()));
        if (src.hasRecall())
            tgt.setRecallElement(Decimal40_50.convertDecimal(src.getRecallElement()));
        if (src.hasFScore())
            tgt.setFScoreElement(Decimal40_50.convertDecimal(src.getFScoreElement()));
        if (src.hasRoc())
            tgt.setRoc(convertMolecularSequenceQualityRocComponent(src.getRoc()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.QualityType> convertQualityType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.QualityType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.QualityType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MolecularSequence.QualityTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INDEL:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.QualityType.INDEL);
                break;
            case SNP:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.QualityType.SNP);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.QualityType.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.QualityType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.QualityType> convertQualityType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.QualityType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.QualityType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MolecularSequence.QualityTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INDEL:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.QualityType.INDEL);
                break;
            case SNP:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.QualityType.SNP);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.QualityType.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.QualityType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityRocComponent convertMolecularSequenceQualityRocComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityRocComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityRocComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityRocComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.IntegerType t : src.getScore()) tgt.getScore().add(Integer40_50.convertInteger(t));
        for (org.hl7.fhir.r4.model.IntegerType t : src.getNumTP()) tgt.getNumTP().add(Integer40_50.convertInteger(t));
        for (org.hl7.fhir.r4.model.IntegerType t : src.getNumFP()) tgt.getNumFP().add(Integer40_50.convertInteger(t));
        for (org.hl7.fhir.r4.model.IntegerType t : src.getNumFN()) tgt.getNumFN().add(Integer40_50.convertInteger(t));
        for (org.hl7.fhir.r4.model.DecimalType t : src.getPrecision()) tgt.getPrecision().add(Decimal40_50.convertDecimal(t));
        for (org.hl7.fhir.r4.model.DecimalType t : src.getSensitivity()) tgt.getSensitivity().add(Decimal40_50.convertDecimal(t));
        for (org.hl7.fhir.r4.model.DecimalType t : src.getFMeasure()) tgt.getFMeasure().add(Decimal40_50.convertDecimal(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityRocComponent convertMolecularSequenceQualityRocComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityRocComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityRocComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityRocComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.IntegerType t : src.getScore()) tgt.getScore().add(Integer40_50.convertInteger(t));
        for (org.hl7.fhir.r5.model.IntegerType t : src.getNumTP()) tgt.getNumTP().add(Integer40_50.convertInteger(t));
        for (org.hl7.fhir.r5.model.IntegerType t : src.getNumFP()) tgt.getNumFP().add(Integer40_50.convertInteger(t));
        for (org.hl7.fhir.r5.model.IntegerType t : src.getNumFN()) tgt.getNumFN().add(Integer40_50.convertInteger(t));
        for (org.hl7.fhir.r5.model.DecimalType t : src.getPrecision()) tgt.getPrecision().add(Decimal40_50.convertDecimal(t));
        for (org.hl7.fhir.r5.model.DecimalType t : src.getSensitivity()) tgt.getSensitivity().add(Decimal40_50.convertDecimal(t));
        for (org.hl7.fhir.r5.model.DecimalType t : src.getFMeasure()) tgt.getFMeasure().add(Decimal40_50.convertDecimal(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent convertMolecularSequenceRepositoryComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertRepositoryType(src.getTypeElement()));
        if (src.hasUrl())
            tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
        if (src.hasName())
            tgt.setNameElement(String40_50.convertString(src.getNameElement()));
        if (src.hasDatasetId())
            tgt.setDatasetIdElement(String40_50.convertString(src.getDatasetIdElement()));
        if (src.hasVariantsetId())
            tgt.setVariantsetIdElement(String40_50.convertString(src.getVariantsetIdElement()));
        if (src.hasReadsetId())
            tgt.setReadsetIdElement(String40_50.convertString(src.getReadsetIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent convertMolecularSequenceRepositoryComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertRepositoryType(src.getTypeElement()));
        if (src.hasUrl())
            tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
        if (src.hasName())
            tgt.setNameElement(String40_50.convertString(src.getNameElement()));
        if (src.hasDatasetId())
            tgt.setDatasetIdElement(String40_50.convertString(src.getDatasetIdElement()));
        if (src.hasVariantsetId())
            tgt.setVariantsetIdElement(String40_50.convertString(src.getVariantsetIdElement()));
        if (src.hasReadsetId())
            tgt.setReadsetIdElement(String40_50.convertString(src.getReadsetIdElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.RepositoryType> convertRepositoryType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.RepositoryType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.RepositoryType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MolecularSequence.RepositoryTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DIRECTLINK:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.DIRECTLINK);
                break;
            case OPENAPI:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.OPENAPI);
                break;
            case LOGIN:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.LOGIN);
                break;
            case OAUTH:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.OAUTH);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.RepositoryType> convertRepositoryType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MolecularSequence.RepositoryType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.RepositoryType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MolecularSequence.RepositoryTypeEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DIRECTLINK:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.DIRECTLINK);
                break;
            case OPENAPI:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.OPENAPI);
                break;
            case LOGIN:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.LOGIN);
                break;
            case OAUTH:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.OAUTH);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantComponent convertMolecularSequenceStructureVariantComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasVariantType())
            tgt.setVariantType(CodeableConcept40_50.convertCodeableConcept(src.getVariantType()));
        if (src.hasExact())
            tgt.setExactElement(Boolean40_50.convertBoolean(src.getExactElement()));
        if (src.hasLength())
            tgt.setLengthElement(Integer40_50.convertInteger(src.getLengthElement()));
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
        Element40_50.copyElement(src, tgt);
        if (src.hasVariantType())
            tgt.setVariantType(CodeableConcept40_50.convertCodeableConcept(src.getVariantType()));
        if (src.hasExact())
            tgt.setExactElement(Boolean40_50.convertBoolean(src.getExactElement()));
        if (src.hasLength())
            tgt.setLengthElement(Integer40_50.convertInteger(src.getLengthElement()));
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
        Element40_50.copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(Integer40_50.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer40_50.convertInteger(src.getEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent convertMolecularSequenceStructureVariantOuterComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantOuterComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(Integer40_50.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer40_50.convertInteger(src.getEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent convertMolecularSequenceStructureVariantInnerComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(Integer40_50.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer40_50.convertInteger(src.getEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent convertMolecularSequenceStructureVariantInnerComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceStructureVariantInnerComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(Integer40_50.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer40_50.convertInteger(src.getEndElement()));
        return tgt;
    }
}