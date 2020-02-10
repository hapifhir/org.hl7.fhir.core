package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.StringType;

import java.util.Collections;

public class ConceptMap30_50 {

    public static org.hl7.fhir.dstu3.model.ConceptMap convertConceptMap(org.hl7.fhir.r5.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap tgt = new org.hl7.fhir.dstu3.model.ConceptMap();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_50.convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_50.convertType(src.getTarget()));
        if (src.hasGroup()) {
            for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup()) tgt.addGroup(convertConceptMapGroupComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu3.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
        if (src.hasSource()) {
            org.hl7.fhir.r5.model.DataType t = VersionConvertor_30_50.convertType(src.getSource());
            tgt.setSource(t instanceof org.hl7.fhir.r5.model.Reference ? new org.hl7.fhir.r5.model.CanonicalType(((org.hl7.fhir.r5.model.Reference) t).getReference()) : t);
        }
        if (src.hasTarget()) {
            org.hl7.fhir.r5.model.DataType t = VersionConvertor_30_50.convertType(src.getTarget());
            tgt.setTarget(t instanceof org.hl7.fhir.r5.model.Reference ? new org.hl7.fhir.r5.model.CanonicalType(((org.hl7.fhir.r5.model.Reference) t).getReference()) : t);
        }
        for (org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup()) tgt.addGroup(convertConceptMapGroupComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence convertConceptMapEquivalence(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RELATEDTO:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.RELATEDTO;
            case EQUIVALENT:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.EQUIVALENT;
            case BROADER:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.WIDER;
            case NARROWER:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.NARROWER;
            case NOTRELATEDTO:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.DISJOINT;
            default:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSourceElement())
            tgt.setSourceElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getSourceElement()));
        if (src.hasSourceVersionElement())
            tgt.setSourceVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getSourceVersionElement()));
        if (src.hasTarget())
            tgt.setTarget(src.getTarget());
        if (src.hasTargetVersion())
            tgt.setTargetVersion(src.getTargetVersion());
        if (src.hasElement()) {
            for (org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
        }
        if (src.hasUnmapped())
            tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSourceElement())
            tgt.setSourceElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getSourceElement()));
        if (src.hasSourceVersionElement())
            tgt.setSourceVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getSourceVersionElement()));
        if (src.hasTarget())
            tgt.setTarget(src.getTarget());
        if (src.hasTargetVersion())
            tgt.setTargetVersion(src.getTargetVersion());
        if (src.hasElement()) {
            for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
        }
        if (src.hasUnmapped())
            tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertConceptMapGroupUnmappedMode(src.getMode()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.CanonicalType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertConceptMapGroupUnmappedMode(src.getMode()));
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode convertConceptMapGroupUnmappedMode(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROVIDED:
                return org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.PROVIDED;
            case FIXED:
                return org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.FIXED;
            case OTHERMAP:
                return org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.OTHERMAP;
            default:
                return org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode convertConceptMapGroupUnmappedMode(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROVIDED:
                return org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode.PROVIDED;
            case FIXED:
                return org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode.FIXED;
            case OTHERMAP:
                return org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode.OTHERMAP;
            default:
                return org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship convertConceptMapRelationship(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RELATEDTO:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.RELATEDTO;
            case EQUIVALENT:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.EQUIVALENT;
            case EQUAL:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.EQUIVALENT;
            case WIDER:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.BROADER;
            case SUBSUMES:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.BROADER;
            case NARROWER:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NARROWER;
            case SPECIALIZES:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NARROWER;
            case INEXACT:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.RELATEDTO;
            case UNMATCHED:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NULL;
            case DISJOINT:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NOTRELATEDTO;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getPropertyElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.r5.model.CanonicalType) VersionConvertor_30_50.convertType(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setValueElement((StringType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setPropertyElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getPropertyElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getSystemElement()));
        if (src.hasValueElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getValueElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasNoMap() && src.getNoMap() == true) {
            tgt.addTarget(new org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent().setEquivalence(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.UNMATCHED));
        } else {
            if (src.hasTarget()) {
                for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t));
            }
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        for (org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent t : src.getTarget()) if (t.getEquivalence() == org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.UNMATCHED) {
            tgt.setNoMap(true);
        } else {
            tgt.addTarget(convertTargetElementComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasEquivalence())
            tgt.setRelationship(convertConceptMapRelationship(src.getEquivalence()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getCommentElement()));
        if (src.hasDependsOn()) {
            for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        }
        if (src.hasProduct()) {
            for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getCodeElement()));
        if (src.hasDisplayElement())
            tgt.setDisplayElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDisplayElement()));
        if (src.hasRelationship())
            tgt.setEquivalence(convertConceptMapEquivalence(src.getRelationship()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getCommentElement()));
        if (src.hasDependsOn()) {
            for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        }
        if (src.hasProduct()) {
            for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        }
        return tgt;
    }
}
