package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.dstu3.model.DecimalType;
import org.hl7.fhir.dstu3.model.IntegerType;
import org.hl7.fhir.dstu3.model.UriType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.StringType;

import java.util.Collections;

public class Sequence30_50 {

    static public org.hl7.fhir.r5.model.MolecularSequence.QualityType convertQualityType(org.hl7.fhir.dstu3.model.Sequence.QualityType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INDEL:
                return org.hl7.fhir.r5.model.MolecularSequence.QualityType.INDEL;
            case SNP:
                return org.hl7.fhir.r5.model.MolecularSequence.QualityType.SNP;
            case UNKNOWN:
                return org.hl7.fhir.r5.model.MolecularSequence.QualityType.UNKNOWN;
            default:
                return org.hl7.fhir.r5.model.MolecularSequence.QualityType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Sequence.QualityType convertQualityType(org.hl7.fhir.r5.model.MolecularSequence.QualityType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INDEL:
                return org.hl7.fhir.dstu3.model.Sequence.QualityType.INDEL;
            case SNP:
                return org.hl7.fhir.dstu3.model.Sequence.QualityType.SNP;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.Sequence.QualityType.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.Sequence.QualityType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Sequence.RepositoryType convertRepositoryType(org.hl7.fhir.r5.model.MolecularSequence.RepositoryType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DIRECTLINK:
                return org.hl7.fhir.dstu3.model.Sequence.RepositoryType.DIRECTLINK;
            case OPENAPI:
                return org.hl7.fhir.dstu3.model.Sequence.RepositoryType.OPENAPI;
            case LOGIN:
                return org.hl7.fhir.dstu3.model.Sequence.RepositoryType.LOGIN;
            case OAUTH:
                return org.hl7.fhir.dstu3.model.Sequence.RepositoryType.OAUTH;
            case OTHER:
                return org.hl7.fhir.dstu3.model.Sequence.RepositoryType.OTHER;
            default:
                return org.hl7.fhir.dstu3.model.Sequence.RepositoryType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.MolecularSequence.RepositoryType convertRepositoryType(org.hl7.fhir.dstu3.model.Sequence.RepositoryType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DIRECTLINK:
                return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.DIRECTLINK;
            case OPENAPI:
                return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.OPENAPI;
            case LOGIN:
                return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.LOGIN;
            case OAUTH:
                return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.OAUTH;
            case OTHER:
                return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.OTHER;
            default:
                return org.hl7.fhir.r5.model.MolecularSequence.RepositoryType.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.MolecularSequence convertSequence(org.hl7.fhir.dstu3.model.Sequence src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence tgt = new org.hl7.fhir.r5.model.MolecularSequence();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasType())
            tgt.setType(convertSequenceType(src.getType()));
        if (src.hasCoordinateSystem())
            tgt.setCoordinateSystem(src.getCoordinateSystem());
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_30_50.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_30_50.convertReference(src.getDevice()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_50.convertReference(src.getPerformer()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertQuantity(src.getQuantity()));
        if (src.hasReferenceSeq())
            tgt.setReferenceSeq(convertSequenceReferenceSeqComponent(src.getReferenceSeq()));
        if (src.hasVariant()) {
            for (org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent t : src.getVariant()) tgt.addVariant(convertSequenceVariantComponent(t));
        }
        if (src.hasObservedSeq())
            tgt.setObservedSeq(src.getObservedSeq());
        if (src.hasQuality()) {
            for (org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent t : src.getQuality()) tgt.addQuality(convertSequenceQualityComponent(t));
        }
        if (src.hasReadCoverage())
            tgt.setReadCoverage(src.getReadCoverage());
        if (src.hasRepository()) {
            for (org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent t : src.getRepository()) tgt.addRepository(convertSequenceRepositoryComponent(t));
        }
        if (src.hasPointer()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getPointer()) tgt.addPointer(VersionConvertor_30_50.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence convertSequence(org.hl7.fhir.r5.model.MolecularSequence src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence tgt = new org.hl7.fhir.dstu3.model.Sequence();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasType())
            tgt.setType(convertSequenceType(src.getType()));
        if (src.hasCoordinateSystemElement())
            tgt.setCoordinateSystemElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_50.convertType(src.getCoordinateSystemElement()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_30_50.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_30_50.convertReference(src.getDevice()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_50.convertReference(src.getPerformer()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertQuantity(src.getQuantity()));
        if (src.hasReferenceSeq())
            tgt.setReferenceSeq(convertSequenceReferenceSeqComponent(src.getReferenceSeq()));
        if (src.hasVariant()) {
            for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent t : src.getVariant()) tgt.addVariant(convertSequenceVariantComponent(t));
        }
        if (src.hasObservedSeqElement())
            tgt.setObservedSeqElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getObservedSeqElement()));
        if (src.hasQuality()) {
            for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent t : src.getQuality()) tgt.addQuality(convertSequenceQualityComponent(t));
        }
        if (src.hasReadCoverageElement())
            tgt.setReadCoverageElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_50.convertType(src.getReadCoverageElement()));
        if (src.hasRepository()) {
            for (org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent t : src.getRepository()) tgt.addRepository(convertSequenceRepositoryComponent(t));
        }
        if (src.hasPointer()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getPointer()) tgt.addPointer(VersionConvertor_30_50.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent convertSequenceQualityComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertQualityType(src.getType()));
        if (src.hasStandardSequence())
            tgt.setStandardSequence(VersionConvertor_30_50.convertCodeableConcept(src.getStandardSequence()));
        if (src.hasStartElement())
            tgt.setStartElement((IntegerType) VersionConvertor_30_50.convertType(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((IntegerType) VersionConvertor_30_50.convertType(src.getEndElement()));
        if (src.hasScore())
            tgt.setScore(VersionConvertor_30_50.convertQuantity(src.getScore()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_50.convertCodeableConcept(src.getMethod()));
        if (src.hasTruthTPElement())
            tgt.setTruthTPElement((DecimalType) VersionConvertor_30_50.convertType(src.getTruthTPElement()));
        if (src.hasQueryTPElement())
            tgt.setQueryTPElement((DecimalType) VersionConvertor_30_50.convertType(src.getQueryTPElement()));
        if (src.hasTruthFNElement())
            tgt.setTruthFNElement((DecimalType) VersionConvertor_30_50.convertType(src.getTruthFNElement()));
        if (src.hasQueryFPElement())
            tgt.setQueryFPElement((DecimalType) VersionConvertor_30_50.convertType(src.getQueryFPElement()));
        if (src.hasGtFPElement())
            tgt.setGtFPElement((DecimalType) VersionConvertor_30_50.convertType(src.getGtFPElement()));
        if (src.hasPrecisionElement())
            tgt.setPrecisionElement((DecimalType) VersionConvertor_30_50.convertType(src.getPrecisionElement()));
        if (src.hasRecallElement())
            tgt.setRecallElement((DecimalType) VersionConvertor_30_50.convertType(src.getRecallElement()));
        if (src.hasFScoreElement())
            tgt.setFScoreElement((DecimalType) VersionConvertor_30_50.convertType(src.getFScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent convertSequenceQualityComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceQualityComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertQualityType(src.getType()));
        if (src.hasStandardSequence())
            tgt.setStandardSequence(VersionConvertor_30_50.convertCodeableConcept(src.getStandardSequence()));
        if (src.hasStartElement())
            tgt.setStartElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_30_50.convertType(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_30_50.convertType(src.getEndElement()));
        if (src.hasScore())
            tgt.setScore(VersionConvertor_30_50.convertQuantity(src.getScore()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_50.convertCodeableConcept(src.getMethod()));
        if (src.hasTruthTPElement())
            tgt.setTruthTPElement((org.hl7.fhir.r5.model.DecimalType) VersionConvertor_30_50.convertType(src.getTruthTPElement()));
        if (src.hasQueryTPElement())
            tgt.setQueryTPElement((org.hl7.fhir.r5.model.DecimalType) VersionConvertor_30_50.convertType(src.getQueryTPElement()));
        if (src.hasTruthFNElement())
            tgt.setTruthFNElement((org.hl7.fhir.r5.model.DecimalType) VersionConvertor_30_50.convertType(src.getTruthFNElement()));
        if (src.hasQueryFPElement())
            tgt.setQueryFPElement((org.hl7.fhir.r5.model.DecimalType) VersionConvertor_30_50.convertType(src.getQueryFPElement()));
        if (src.hasGtFPElement())
            tgt.setGtFPElement((org.hl7.fhir.r5.model.DecimalType) VersionConvertor_30_50.convertType(src.getGtFPElement()));
        if (src.hasPrecisionElement())
            tgt.setPrecisionElement((org.hl7.fhir.r5.model.DecimalType) VersionConvertor_30_50.convertType(src.getPrecisionElement()));
        if (src.hasRecallElement())
            tgt.setRecallElement((org.hl7.fhir.r5.model.DecimalType) VersionConvertor_30_50.convertType(src.getRecallElement()));
        if (src.hasFScoreElement())
            tgt.setFScoreElement((org.hl7.fhir.r5.model.DecimalType) VersionConvertor_30_50.convertType(src.getFScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent convertSequenceReferenceSeqComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasChromosome())
            tgt.setChromosome(VersionConvertor_30_50.convertCodeableConcept(src.getChromosome()));
        if (src.hasGenomeBuildElement())
            tgt.setGenomeBuildElement((StringType) VersionConvertor_30_50.convertType(src.getGenomeBuildElement()));
        if (src.hasReferenceSeqId())
            tgt.setReferenceSeqId(VersionConvertor_30_50.convertCodeableConcept(src.getReferenceSeqId()));
        if (src.hasReferenceSeqPointer())
            tgt.setReferenceSeqPointer(VersionConvertor_30_50.convertReference(src.getReferenceSeqPointer()));
        if (src.hasReferenceSeqStringElement())
            tgt.setReferenceSeqStringElement((StringType) VersionConvertor_30_50.convertType(src.getReferenceSeqStringElement()));
        if (src.hasWindowStartElement())
            tgt.setWindowStartElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_30_50.convertType(src.getWindowStartElement()));
        if (src.hasWindowEndElement())
            tgt.setWindowEndElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_30_50.convertType(src.getWindowEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent convertSequenceReferenceSeqComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceReferenceSeqComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasChromosome())
            tgt.setChromosome(VersionConvertor_30_50.convertCodeableConcept(src.getChromosome()));
        if (src.hasGenomeBuildElement())
            tgt.setGenomeBuildElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getGenomeBuildElement()));
        if (src.hasReferenceSeqId())
            tgt.setReferenceSeqId(VersionConvertor_30_50.convertCodeableConcept(src.getReferenceSeqId()));
        if (src.hasReferenceSeqPointer())
            tgt.setReferenceSeqPointer(VersionConvertor_30_50.convertReference(src.getReferenceSeqPointer()));
        if (src.hasReferenceSeqStringElement())
            tgt.setReferenceSeqStringElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getReferenceSeqStringElement()));
        if (src.hasWindowStartElement())
            tgt.setWindowStartElement((IntegerType) VersionConvertor_30_50.convertType(src.getWindowStartElement()));
        if (src.hasWindowEndElement())
            tgt.setWindowEndElement((IntegerType) VersionConvertor_30_50.convertType(src.getWindowEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent convertSequenceRepositoryComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertRepositoryType(src.getType()));
        if (src.hasUrlElement())
            tgt.setUrlElement((UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasDatasetIdElement())
            tgt.setDatasetIdElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDatasetIdElement()));
        if (src.hasVariantsetIdElement())
            tgt.setVariantsetIdElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getVariantsetIdElement()));
        if (src.hasReadsetIdElement())
            tgt.setReadsetIdElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getReadsetIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent convertSequenceRepositoryComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceRepositoryComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertRepositoryType(src.getType()));
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement((StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasDatasetIdElement())
            tgt.setDatasetIdElement((StringType) VersionConvertor_30_50.convertType(src.getDatasetIdElement()));
        if (src.hasVariantsetIdElement())
            tgt.setVariantsetIdElement((StringType) VersionConvertor_30_50.convertType(src.getVariantsetIdElement()));
        if (src.hasReadsetIdElement())
            tgt.setReadsetIdElement((StringType) VersionConvertor_30_50.convertType(src.getReadsetIdElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Sequence.SequenceType convertSequenceType(org.hl7.fhir.r5.model.MolecularSequence.SequenceType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case AA:
                return org.hl7.fhir.dstu3.model.Sequence.SequenceType.AA;
            case DNA:
                return org.hl7.fhir.dstu3.model.Sequence.SequenceType.DNA;
            case RNA:
                return org.hl7.fhir.dstu3.model.Sequence.SequenceType.RNA;
            default:
                return org.hl7.fhir.dstu3.model.Sequence.SequenceType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.MolecularSequence.SequenceType convertSequenceType(org.hl7.fhir.dstu3.model.Sequence.SequenceType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case AA:
                return org.hl7.fhir.r5.model.MolecularSequence.SequenceType.AA;
            case DNA:
                return org.hl7.fhir.r5.model.MolecularSequence.SequenceType.DNA;
            case RNA:
                return org.hl7.fhir.r5.model.MolecularSequence.SequenceType.RNA;
            default:
                return org.hl7.fhir.r5.model.MolecularSequence.SequenceType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent convertSequenceVariantComponent(org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasStartElement())
            tgt.setStartElement((IntegerType) VersionConvertor_30_50.convertType(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((IntegerType) VersionConvertor_30_50.convertType(src.getEndElement()));
        if (src.hasObservedAlleleElement())
            tgt.setObservedAlleleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getObservedAlleleElement()));
        if (src.hasReferenceAlleleElement())
            tgt.setReferenceAlleleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getReferenceAlleleElement()));
        if (src.hasCigarElement())
            tgt.setCigarElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getCigarElement()));
        if (src.hasVariantPointer())
            tgt.setVariantPointer(VersionConvertor_30_50.convertReference(src.getVariantPointer()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent convertSequenceVariantComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent tgt = new org.hl7.fhir.r5.model.MolecularSequence.MolecularSequenceVariantComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasStartElement())
            tgt.setStartElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_30_50.convertType(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_30_50.convertType(src.getEndElement()));
        if (src.hasObservedAlleleElement())
            tgt.setObservedAlleleElement((StringType) VersionConvertor_30_50.convertType(src.getObservedAlleleElement()));
        if (src.hasReferenceAlleleElement())
            tgt.setReferenceAlleleElement((StringType) VersionConvertor_30_50.convertType(src.getReferenceAlleleElement()));
        if (src.hasCigarElement())
            tgt.setCigarElement((StringType) VersionConvertor_30_50.convertType(src.getCigarElement()));
        if (src.hasVariantPointer())
            tgt.setVariantPointer(VersionConvertor_30_50.convertReference(src.getVariantPointer()));
        return tgt;
    }
}
