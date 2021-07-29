package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40; import org.hl7.fhir.convertors.context.ConversionContext30_40; import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Quantity30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Decimal30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Integer30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Sequence30_40 {

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Sequence.QualityType> convertQualityType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.QualityType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Sequence.QualityType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Sequence.QualityTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case INDEL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.QualityType.INDEL);
                break;
            case SNP:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.QualityType.SNP);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.QualityType.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.QualityType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.QualityType> convertQualityType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Sequence.QualityType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.QualityType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MolecularSequence.QualityTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Sequence.RepositoryType> convertRepositoryType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.RepositoryType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Sequence.RepositoryType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Sequence.RepositoryTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case DIRECTLINK:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.RepositoryType.DIRECTLINK);
                break;
            case OPENAPI:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.RepositoryType.OPENAPI);
                break;
            case LOGIN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.RepositoryType.LOGIN);
                break;
            case OAUTH:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.RepositoryType.OAUTH);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.RepositoryType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.RepositoryType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.RepositoryType> convertRepositoryType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Sequence.RepositoryType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.RepositoryType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MolecularSequence.RepositoryTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

    public static org.hl7.fhir.dstu3.model.Sequence convertSequence(org.hl7.fhir.r4.model.MolecularSequence src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence tgt = new org.hl7.fhir.dstu3.model.Sequence();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasType())
            tgt.setTypeElement(convertSequenceType(src.getTypeElement()));
        if (src.hasCoordinateSystem())
            tgt.setCoordinateSystemElement(Integer30_40.convertInteger(src.getCoordinateSystemElement()));
        if (src.hasPatient())
            tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
        if (src.hasSpecimen())
            tgt.setSpecimen(Reference30_40.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(Reference30_40.convertReference(src.getDevice()));
        if (src.hasPerformer())
            tgt.setPerformer(Reference30_40.convertReference(src.getPerformer()));
        if (src.hasQuantity())
            tgt.setQuantity(Quantity30_40.convertQuantity(src.getQuantity()));
        if (src.hasReferenceSeq())
            tgt.setReferenceSeq(convertSequenceReferenceSeqComponent(src.getReferenceSeq()));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent t : src.getVariant()) tgt.addVariant(convertSequenceVariantComponent(t));
        if (src.hasObservedSeq())
            tgt.setObservedSeqElement(String30_40.convertString(src.getObservedSeqElement()));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent t : src.getQuality()) tgt.addQuality(convertSequenceQualityComponent(t));
        if (src.hasReadCoverage())
            tgt.setReadCoverageElement(Integer30_40.convertInteger(src.getReadCoverageElement()));
        for (org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent t : src.getRepository()) tgt.addRepository(convertSequenceRepositoryComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPointer()) tgt.addPointer(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence convertSequence(org.hl7.fhir.dstu3.model.Sequence src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence tgt = new org.hl7.fhir.r4.model.MolecularSequence();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasType())
            tgt.setTypeElement(convertSequenceType(src.getTypeElement()));
        if (src.hasCoordinateSystem())
            tgt.setCoordinateSystemElement(Integer30_40.convertInteger(src.getCoordinateSystemElement()));
        if (src.hasPatient())
            tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
        if (src.hasSpecimen())
            tgt.setSpecimen(Reference30_40.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(Reference30_40.convertReference(src.getDevice()));
        if (src.hasPerformer())
            tgt.setPerformer(Reference30_40.convertReference(src.getPerformer()));
        if (src.hasQuantity())
            tgt.setQuantity(Quantity30_40.convertQuantity(src.getQuantity()));
        if (src.hasReferenceSeq())
            tgt.setReferenceSeq(convertSequenceReferenceSeqComponent(src.getReferenceSeq()));
        for (org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent t : src.getVariant()) tgt.addVariant(convertSequenceVariantComponent(t));
        if (src.hasObservedSeq())
            tgt.setObservedSeqElement(String30_40.convertString(src.getObservedSeqElement()));
        for (org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent t : src.getQuality()) tgt.addQuality(convertSequenceQualityComponent(t));
        if (src.hasReadCoverage())
            tgt.setReadCoverageElement(Integer30_40.convertInteger(src.getReadCoverageElement()));
        for (org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent t : src.getRepository()) tgt.addRepository(convertSequenceRepositoryComponent(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPointer()) tgt.addPointer(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent convertSequenceQualityComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertQualityType(src.getTypeElement()));
        if (src.hasStandardSequence())
            tgt.setStandardSequence(CodeableConcept30_40.convertCodeableConcept(src.getStandardSequence()));
        if (src.hasStart())
            tgt.setStartElement(Integer30_40.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer30_40.convertInteger(src.getEndElement()));
        if (src.hasScore())
            tgt.setScore(Quantity30_40.convertQuantity(src.getScore()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasTruthTP())
            tgt.setTruthTPElement(Decimal30_40.convertDecimal(src.getTruthTPElement()));
        if (src.hasQueryTP())
            tgt.setQueryTPElement(Decimal30_40.convertDecimal(src.getQueryTPElement()));
        if (src.hasTruthFN())
            tgt.setTruthFNElement(Decimal30_40.convertDecimal(src.getTruthFNElement()));
        if (src.hasQueryFP())
            tgt.setQueryFPElement(Decimal30_40.convertDecimal(src.getQueryFPElement()));
        if (src.hasGtFP())
            tgt.setGtFPElement(Decimal30_40.convertDecimal(src.getGtFPElement()));
        if (src.hasPrecision())
            tgt.setPrecisionElement(Decimal30_40.convertDecimal(src.getPrecisionElement()));
        if (src.hasRecall())
            tgt.setRecallElement(Decimal30_40.convertDecimal(src.getRecallElement()));
        if (src.hasFScore())
            tgt.setFScoreElement(Decimal30_40.convertDecimal(src.getFScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent convertSequenceQualityComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceQualityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceQualityComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertQualityType(src.getTypeElement()));
        if (src.hasStandardSequence())
            tgt.setStandardSequence(CodeableConcept30_40.convertCodeableConcept(src.getStandardSequence()));
        if (src.hasStart())
            tgt.setStartElement(Integer30_40.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer30_40.convertInteger(src.getEndElement()));
        if (src.hasScore())
            tgt.setScore(Quantity30_40.convertQuantity(src.getScore()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasTruthTP())
            tgt.setTruthTPElement(Decimal30_40.convertDecimal(src.getTruthTPElement()));
        if (src.hasQueryTP())
            tgt.setQueryTPElement(Decimal30_40.convertDecimal(src.getQueryTPElement()));
        if (src.hasTruthFN())
            tgt.setTruthFNElement(Decimal30_40.convertDecimal(src.getTruthFNElement()));
        if (src.hasQueryFP())
            tgt.setQueryFPElement(Decimal30_40.convertDecimal(src.getQueryFPElement()));
        if (src.hasGtFP())
            tgt.setGtFPElement(Decimal30_40.convertDecimal(src.getGtFPElement()));
        if (src.hasPrecision())
            tgt.setPrecisionElement(Decimal30_40.convertDecimal(src.getPrecisionElement()));
        if (src.hasRecall())
            tgt.setRecallElement(Decimal30_40.convertDecimal(src.getRecallElement()));
        if (src.hasFScore())
            tgt.setFScoreElement(Decimal30_40.convertDecimal(src.getFScoreElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent convertSequenceReferenceSeqComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasChromosome())
            tgt.setChromosome(CodeableConcept30_40.convertCodeableConcept(src.getChromosome()));
        if (src.hasGenomeBuild())
            tgt.setGenomeBuildElement(String30_40.convertString(src.getGenomeBuildElement()));
        if (src.hasReferenceSeqId())
            tgt.setReferenceSeqId(CodeableConcept30_40.convertCodeableConcept(src.getReferenceSeqId()));
        if (src.hasReferenceSeqPointer())
            tgt.setReferenceSeqPointer(Reference30_40.convertReference(src.getReferenceSeqPointer()));
        if (src.hasReferenceSeqString())
            tgt.setReferenceSeqStringElement(String30_40.convertString(src.getReferenceSeqStringElement()));
        if (src.hasWindowStart())
            tgt.setWindowStartElement(Integer30_40.convertInteger(src.getWindowStartElement()));
        if (src.hasWindowEnd())
            tgt.setWindowEndElement(Integer30_40.convertInteger(src.getWindowEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent convertSequenceReferenceSeqComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceReferenceSeqComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceReferenceSeqComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasChromosome())
            tgt.setChromosome(CodeableConcept30_40.convertCodeableConcept(src.getChromosome()));
        if (src.hasGenomeBuild())
            tgt.setGenomeBuildElement(String30_40.convertString(src.getGenomeBuildElement()));
        if (src.hasReferenceSeqId())
            tgt.setReferenceSeqId(CodeableConcept30_40.convertCodeableConcept(src.getReferenceSeqId()));
        if (src.hasReferenceSeqPointer())
            tgt.setReferenceSeqPointer(Reference30_40.convertReference(src.getReferenceSeqPointer()));
        if (src.hasReferenceSeqString())
            tgt.setReferenceSeqStringElement(String30_40.convertString(src.getReferenceSeqStringElement()));
        if (src.hasWindowStart())
            tgt.setWindowStartElement(Integer30_40.convertInteger(src.getWindowStartElement()));
        if (src.hasWindowEnd())
            tgt.setWindowEndElement(Integer30_40.convertInteger(src.getWindowEndElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent convertSequenceRepositoryComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertRepositoryType(src.getTypeElement()));
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasDatasetId())
            tgt.setDatasetIdElement(String30_40.convertString(src.getDatasetIdElement()));
        if (src.hasVariantsetId())
            tgt.setVariantsetIdElement(String30_40.convertString(src.getVariantsetIdElement()));
        if (src.hasReadsetId())
            tgt.setReadsetIdElement(String30_40.convertString(src.getReadsetIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent convertSequenceRepositoryComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceRepositoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceRepositoryComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertRepositoryType(src.getTypeElement()));
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasDatasetId())
            tgt.setDatasetIdElement(String30_40.convertString(src.getDatasetIdElement()));
        if (src.hasVariantsetId())
            tgt.setVariantsetIdElement(String30_40.convertString(src.getVariantsetIdElement()));
        if (src.hasReadsetId())
            tgt.setReadsetIdElement(String30_40.convertString(src.getReadsetIdElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Sequence.SequenceType> convertSequenceType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.SequenceType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Sequence.SequenceType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Sequence.SequenceTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case AA:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.SequenceType.AA);
                break;
            case DNA:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.SequenceType.DNA);
                break;
            case RNA:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.SequenceType.RNA);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Sequence.SequenceType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.SequenceType> convertSequenceType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Sequence.SequenceType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MolecularSequence.SequenceType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MolecularSequence.SequenceTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

    public static org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent convertSequenceVariantComponent(org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent tgt = new org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(Integer30_40.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer30_40.convertInteger(src.getEndElement()));
        if (src.hasObservedAllele())
            tgt.setObservedAlleleElement(String30_40.convertString(src.getObservedAlleleElement()));
        if (src.hasReferenceAllele())
            tgt.setReferenceAlleleElement(String30_40.convertString(src.getReferenceAlleleElement()));
        if (src.hasCigar())
            tgt.setCigarElement(String30_40.convertString(src.getCigarElement()));
        if (src.hasVariantPointer())
            tgt.setVariantPointer(Reference30_40.convertReference(src.getVariantPointer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent convertSequenceVariantComponent(org.hl7.fhir.r4.model.MolecularSequence.MolecularSequenceVariantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent tgt = new org.hl7.fhir.dstu3.model.Sequence.SequenceVariantComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasStart())
            tgt.setStartElement(Integer30_40.convertInteger(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(Integer30_40.convertInteger(src.getEndElement()));
        if (src.hasObservedAllele())
            tgt.setObservedAlleleElement(String30_40.convertString(src.getObservedAlleleElement()));
        if (src.hasReferenceAllele())
            tgt.setReferenceAlleleElement(String30_40.convertString(src.getReferenceAlleleElement()));
        if (src.hasCigar())
            tgt.setCigarElement(String30_40.convertString(src.getCigarElement()));
        if (src.hasVariantPointer())
            tgt.setVariantPointer(Reference30_40.convertReference(src.getVariantPointer()));
        return tgt;
    }
}