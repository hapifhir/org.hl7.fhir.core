package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Sequence30_40 {

    static public org.hl7.fhir.dstu3.model.Sequence.QualityType convertQualityType(org.hl7.fhir.r4.model.MolecularSequence.QualityType src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.MolecularSequence.QualityType convertQualityType(org.hl7.fhir.dstu3.model.Sequence.QualityType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INDEL:
                return org.hl7.fhir.r4.model.MolecularSequence.QualityType.INDEL;
            case SNP:
                return org.hl7.fhir.r4.model.MolecularSequence.QualityType.SNP;
            case UNKNOWN:
                return org.hl7.fhir.r4.model.MolecularSequence.QualityType.UNKNOWN;
            default:
                return org.hl7.fhir.r4.model.MolecularSequence.QualityType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Sequence.RepositoryType convertRepositoryType(org.hl7.fhir.r4.model.MolecularSequence.RepositoryType src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.MolecularSequence.RepositoryType convertRepositoryType(org.hl7.fhir.dstu3.model.Sequence.RepositoryType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DIRECTLINK:
                return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.DIRECTLINK;
            case OPENAPI:
                return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.OPENAPI;
            case LOGIN:
                return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.LOGIN;
            case OAUTH:
                return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.OAUTH;
            case OTHER:
                return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.OTHER;
            default:
                return org.hl7.fhir.r4.model.MolecularSequence.RepositoryType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Sequence convertSequence(org.hl7.fhir.r4.model.MolecularSequence src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence tgt = new org.hl7.fhir.dstu3.model.Sequence();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasType())
            tgt.setType(convertSequenceType(src.getType()));
        if (src.hasCoordinateSystem())
            tgt.setCoordinateSystemElement(VersionConvertor_30_40.convertInteger(src.getCoordinateSystemElement()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_30_40.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_30_40.convertReference(src.getDevice()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_40.convertReference(src.getPerformer()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertQuantity(src.getQuantity()));
        if (src.hasReferenceSeq())
            tgt.setReferenceSeq(convertSequenceReferenceSeqComponent(src.getReferenceSeq()));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent t : src.getVariant()) tgt.addVariant(convertSequenceVariantComponent(t));
        if (src.hasObservedSeq())
            tgt.setObservedSeqElement(VersionConvertor_30_40.convertString(src.getObservedSeqElement()));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent t : src.getQuality()) tgt.addQuality(convertSequenceQualityComponent(t));
        if (src.hasReadCoverage())
            tgt.setReadCoverageElement(VersionConvertor_30_40.convertInteger(src.getReadCoverageElement()));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent t : src.getRepository()) tgt.addRepository(convertSequenceRepositoryComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPointer()) tgt.addPointer(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence convertSequence(org.hl7.fhir.dstu3.model.Sequence src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence tgt = new org.hl7.fhir.r4.model.MolecularSequence();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasType())
            tgt.setType(convertSequenceType(src.getType()));
        if (src.hasCoordinateSystem())
            tgt.setCoordinateSystemElement(VersionConvertor_30_40.convertInteger(src.getCoordinateSystemElement()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_30_40.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_30_40.convertReference(src.getDevice()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_40.convertReference(src.getPerformer()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertQuantity(src.getQuantity()));
        if (src.hasReferenceSeq())
            tgt.setReferenceSeq(convertSequenceReferenceSeqComponent(src.getReferenceSeq()));
        for (org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent t : src.getVariant()) tgt.addVariant(convertSequenceVariantComponent(t));
        if (src.hasObservedSeq())
            tgt.setObservedSeqElement(VersionConvertor_30_40.convertString(src.getObservedSeqElement()));
        for (org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent t : src.getQuality()) tgt.addQuality(convertSequenceQualityComponent(t));
        if (src.hasReadCoverage())
            tgt.setReadCoverageElement(VersionConvertor_30_40.convertInteger(src.getReadCoverageElement()));
        for (org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent t : src.getRepository()) tgt.addRepository(convertSequenceRepositoryComponent(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPointer()) tgt.addPointer(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent convertSequenceQualityComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertQualityType(src.getType()));
        if (src.hasStandardSequence())
            tgt.setStandardSequence(VersionConvertor_30_40.convertCodeableConcept(src.getStandardSequence()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(VersionConvertor_30_40.convertInteger(src.getEndElement()));
        if (src.hasScore())
            tgt.setScore(VersionConvertor_30_40.convertQuantity(src.getScore()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasTruthTP())
            tgt.setTruthTPElement(VersionConvertor_30_40.convertDecimal(src.getTruthTPElement()));
        if (src.hasQueryTP())
            tgt.setQueryTPElement(VersionConvertor_30_40.convertDecimal(src.getQueryTPElement()));
        if (src.hasTruthFN())
            tgt.setTruthFNElement(VersionConvertor_30_40.convertDecimal(src.getTruthFNElement()));
        if (src.hasQueryFP())
            tgt.setQueryFPElement(VersionConvertor_30_40.convertDecimal(src.getQueryFPElement()));
        if (src.hasGtFP())
            tgt.setGtFPElement(VersionConvertor_30_40.convertDecimal(src.getGtFPElement()));
        if (src.hasPrecision())
            tgt.setPrecisionElement(VersionConvertor_30_40.convertDecimal(src.getPrecisionElement()));
        if (src.hasRecall())
            tgt.setRecallElement(VersionConvertor_30_40.convertDecimal(src.getRecallElement()));
        if (src.hasFScore())
            tgt.setFScoreElement(VersionConvertor_30_40.convertDecimal(src.getFScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent convertSequenceQualityComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertQualityType(src.getType()));
        if (src.hasStandardSequence())
            tgt.setStandardSequence(VersionConvertor_30_40.convertCodeableConcept(src.getStandardSequence()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(VersionConvertor_30_40.convertInteger(src.getEndElement()));
        if (src.hasScore())
            tgt.setScore(VersionConvertor_30_40.convertQuantity(src.getScore()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasTruthTP())
            tgt.setTruthTPElement(VersionConvertor_30_40.convertDecimal(src.getTruthTPElement()));
        if (src.hasQueryTP())
            tgt.setQueryTPElement(VersionConvertor_30_40.convertDecimal(src.getQueryTPElement()));
        if (src.hasTruthFN())
            tgt.setTruthFNElement(VersionConvertor_30_40.convertDecimal(src.getTruthFNElement()));
        if (src.hasQueryFP())
            tgt.setQueryFPElement(VersionConvertor_30_40.convertDecimal(src.getQueryFPElement()));
        if (src.hasGtFP())
            tgt.setGtFPElement(VersionConvertor_30_40.convertDecimal(src.getGtFPElement()));
        if (src.hasPrecision())
            tgt.setPrecisionElement(VersionConvertor_30_40.convertDecimal(src.getPrecisionElement()));
        if (src.hasRecall())
            tgt.setRecallElement(VersionConvertor_30_40.convertDecimal(src.getRecallElement()));
        if (src.hasFScore())
            tgt.setFScoreElement(VersionConvertor_30_40.convertDecimal(src.getFScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent convertSequenceReferenceSeqComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasChromosome())
            tgt.setChromosome(VersionConvertor_30_40.convertCodeableConcept(src.getChromosome()));
        if (src.hasGenomeBuild())
            tgt.setGenomeBuildElement(VersionConvertor_30_40.convertString(src.getGenomeBuildElement()));
        if (src.hasReferenceSeqId())
            tgt.setReferenceSeqId(VersionConvertor_30_40.convertCodeableConcept(src.getReferenceSeqId()));
        if (src.hasReferenceSeqPointer())
            tgt.setReferenceSeqPointer(VersionConvertor_30_40.convertReference(src.getReferenceSeqPointer()));
        if (src.hasReferenceSeqString())
            tgt.setReferenceSeqStringElement(VersionConvertor_30_40.convertString(src.getReferenceSeqStringElement()));
        if (src.hasWindowStart())
            tgt.setWindowStartElement(VersionConvertor_30_40.convertInteger(src.getWindowStartElement()));
        if (src.hasWindowEnd())
            tgt.setWindowEndElement(VersionConvertor_30_40.convertInteger(src.getWindowEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent convertSequenceReferenceSeqComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasChromosome())
            tgt.setChromosome(VersionConvertor_30_40.convertCodeableConcept(src.getChromosome()));
        if (src.hasGenomeBuild())
            tgt.setGenomeBuildElement(VersionConvertor_30_40.convertString(src.getGenomeBuildElement()));
        if (src.hasReferenceSeqId())
            tgt.setReferenceSeqId(VersionConvertor_30_40.convertCodeableConcept(src.getReferenceSeqId()));
        if (src.hasReferenceSeqPointer())
            tgt.setReferenceSeqPointer(VersionConvertor_30_40.convertReference(src.getReferenceSeqPointer()));
        if (src.hasReferenceSeqString())
            tgt.setReferenceSeqStringElement(VersionConvertor_30_40.convertString(src.getReferenceSeqStringElement()));
        if (src.hasWindowStart())
            tgt.setWindowStartElement(VersionConvertor_30_40.convertInteger(src.getWindowStartElement()));
        if (src.hasWindowEnd())
            tgt.setWindowEndElement(VersionConvertor_30_40.convertInteger(src.getWindowEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent convertSequenceRepositoryComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertRepositoryType(src.getType()));
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasDatasetId())
            tgt.setDatasetIdElement(VersionConvertor_30_40.convertString(src.getDatasetIdElement()));
        if (src.hasVariantsetId())
            tgt.setVariantsetIdElement(VersionConvertor_30_40.convertString(src.getVariantsetIdElement()));
        if (src.hasReadsetId())
            tgt.setReadsetIdElement(VersionConvertor_30_40.convertString(src.getReadsetIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent convertSequenceRepositoryComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertRepositoryType(src.getType()));
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasDatasetId())
            tgt.setDatasetIdElement(VersionConvertor_30_40.convertString(src.getDatasetIdElement()));
        if (src.hasVariantsetId())
            tgt.setVariantsetIdElement(VersionConvertor_30_40.convertString(src.getVariantsetIdElement()));
        if (src.hasReadsetId())
            tgt.setReadsetIdElement(VersionConvertor_30_40.convertString(src.getReadsetIdElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Sequence.SequenceType convertSequenceType(org.hl7.fhir.r4.model.MolecularSequence.SequenceType src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.MolecularSequence.SequenceType convertSequenceType(org.hl7.fhir.dstu3.model.Sequence.SequenceType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case AA:
                return org.hl7.fhir.r4.model.MolecularSequence.SequenceType.AA;
            case DNA:
                return org.hl7.fhir.r4.model.MolecularSequence.SequenceType.DNA;
            case RNA:
                return org.hl7.fhir.r4.model.MolecularSequence.SequenceType.RNA;
            default:
                return org.hl7.fhir.r4.model.MolecularSequence.SequenceType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent convertSequenceVariantComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(VersionConvertor_30_40.convertInteger(src.getEndElement()));
        if (src.hasObservedAllele())
            tgt.setObservedAlleleElement(VersionConvertor_30_40.convertString(src.getObservedAlleleElement()));
        if (src.hasReferenceAllele())
            tgt.setReferenceAlleleElement(VersionConvertor_30_40.convertString(src.getReferenceAlleleElement()));
        if (src.hasCigar())
            tgt.setCigarElement(VersionConvertor_30_40.convertString(src.getCigarElement()));
        if (src.hasVariantPointer())
            tgt.setVariantPointer(VersionConvertor_30_40.convertReference(src.getVariantPointer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent convertSequenceVariantComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(VersionConvertor_30_40.convertInteger(src.getEndElement()));
        if (src.hasObservedAllele())
            tgt.setObservedAlleleElement(VersionConvertor_30_40.convertString(src.getObservedAlleleElement()));
        if (src.hasReferenceAllele())
            tgt.setReferenceAlleleElement(VersionConvertor_30_40.convertString(src.getReferenceAlleleElement()));
        if (src.hasCigar())
            tgt.setCigarElement(VersionConvertor_30_40.convertString(src.getCigarElement()));
        if (src.hasVariantPointer())
            tgt.setVariantPointer(VersionConvertor_30_40.convertReference(src.getVariantPointer()));
        return tgt;
    }
}
