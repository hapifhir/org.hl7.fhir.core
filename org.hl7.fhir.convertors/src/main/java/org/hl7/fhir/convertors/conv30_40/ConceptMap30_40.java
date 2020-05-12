package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class ConceptMap30_40 {

    public static org.hl7.fhir.dstu3.model.ConceptMap convertConceptMap(org.hl7.fhir.r4.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap tgt = new org.hl7.fhir.dstu3.model.ConceptMap();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_40.convertMarkdown(src.getCopyrightElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_40.convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_40.convertType(src.getTarget()));
        for (org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup()) tgt.addGroup(convertConceptMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu3.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap tgt = new org.hl7.fhir.r4.model.ConceptMap();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_40.convertMarkdown(src.getCopyrightElement()));
        if (src.hasSource()) {
            org.hl7.fhir.r4.model.Type t = VersionConvertor_30_40.convertType(src.getSource());
            tgt.setSource(t instanceof org.hl7.fhir.r4.model.Reference ? new org.hl7.fhir.r4.model.CanonicalType(((org.hl7.fhir.r4.model.Reference) t).getReference()) : t);
        }
        if (src.hasTarget()) {
            org.hl7.fhir.r4.model.Type t = VersionConvertor_30_40.convertType(src.getTarget());
            tgt.setTarget(t instanceof org.hl7.fhir.r4.model.Reference ? new org.hl7.fhir.r4.model.CanonicalType(((org.hl7.fhir.r4.model.Reference) t).getReference()) : t);
        }
        for (org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup()) tgt.addGroup(convertConceptMapGroupComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence> convertConceptMapEquivalence(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case RELATEDTO:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.RELATEDTO);
                break;
            case EQUIVALENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.EQUIVALENT);
                break;
            case EQUAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.EQUAL);
                break;
            case WIDER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.WIDER);
                break;
            case SUBSUMES:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.SUBSUMES);
                break;
            case NARROWER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.NARROWER);
                break;
            case SPECIALIZES:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.SPECIALIZES);
                break;
            case INEXACT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.INEXACT);
                break;
            case UNMATCHED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.UNMATCHED);
                break;
            case DISJOINT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.DISJOINT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence> convertConceptMapEquivalence(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case RELATEDTO:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.RELATEDTO);
                break;
            case EQUIVALENT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.EQUIVALENT);
                break;
            case EQUAL:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.EQUAL);
                break;
            case WIDER:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.WIDER);
                break;
            case SUBSUMES:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.SUBSUMES);
                break;
            case NARROWER:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NARROWER);
                break;
            case SPECIALIZES:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.SPECIALIZES);
                break;
            case INEXACT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.INEXACT);
                break;
            case UNMATCHED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.UNMATCHED);
                break;
            case DISJOINT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.DISJOINT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasSource())
            tgt.setSourceElement(VersionConvertor_30_40.convertUri(src.getSourceElement()));
        if (src.hasSourceVersion())
            tgt.setSourceVersionElement(VersionConvertor_30_40.convertString(src.getSourceVersionElement()));
        if (src.hasTarget())
            tgt.setTarget(src.getTarget());
        if (src.hasTargetVersion())
            tgt.setTargetVersion(src.getTargetVersion());
        for (org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
        if (src.hasUnmapped())
            tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasSource())
            tgt.setSourceElement(VersionConvertor_30_40.convertUri(src.getSourceElement()));
        if (src.hasSourceVersion())
            tgt.setSourceVersionElement(VersionConvertor_30_40.convertString(src.getSourceVersionElement()));
        if (src.hasTarget())
            tgt.setTarget(src.getTarget());
        if (src.hasTargetVersion())
            tgt.setTargetVersion(src.getTargetVersion());
        for (org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
        if (src.hasUnmapped())
            tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROVIDED:
                tgt.setValue(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode.PROVIDED);
                break;
            case FIXED:
                tgt.setValue(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode.FIXED);
                break;
            case OTHERMAP:
                tgt.setValue(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode.OTHERMAP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROVIDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode.PROVIDED);
                break;
            case FIXED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode.FIXED);
                break;
            case OTHERMAP:
                tgt.setValue(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode.OTHERMAP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasProperty())
            tgt.setPropertyElement(VersionConvertor_30_40.convertUri(src.getPropertyElement()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasValue())
            tgt.setCodeElement(VersionConvertor_30_40.convertString(src.getValueElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasProperty())
            tgt.setPropertyElement(VersionConvertor_30_40.convertUri(src.getPropertyElement()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setValueElement(VersionConvertor_30_40.convertString(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        for (org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        if (src.hasEquivalence())
            tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getEquivalenceElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
        for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_40.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        if (src.hasEquivalence())
            tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getEquivalenceElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }
}