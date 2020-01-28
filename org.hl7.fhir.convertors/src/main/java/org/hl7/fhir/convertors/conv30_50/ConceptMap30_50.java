package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ConceptMap30_50 {

    public static org.hl7.fhir.dstu3.model.ConceptMap convertConceptMap(org.hl7.fhir.r5.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap tgt = new org.hl7.fhir.dstu3.model.ConceptMap();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_50.convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_50.convertType(src.getTarget()));
        for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup()) tgt.addGroup(convertConceptMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu3.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
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
        if (src.hasSource())
            tgt.setSource(src.getSource());
        if (src.hasSourceVersion())
            tgt.setSourceVersion(src.getSourceVersion());
        if (src.hasTarget())
            tgt.setTarget(src.getTarget());
        if (src.hasTargetVersion())
            tgt.setTargetVersion(src.getTargetVersion());
        for (org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
        if (src.hasUnmapped())
            tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSource())
            tgt.setSource(src.getSource());
        if (src.hasSourceVersion())
            tgt.setSourceVersion(src.getSourceVersion());
        if (src.hasTarget())
            tgt.setTarget(src.getTarget());
        if (src.hasTargetVersion())
            tgt.setTargetVersion(src.getTargetVersion());
        for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
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
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertConceptMapGroupUnmappedMode(src.getMode()));
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
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
        if (src.hasProperty())
            tgt.setProperty(src.getProperty());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setValue(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasProperty())
            tgt.setProperty(src.getProperty());
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasValue())
            tgt.setCode(src.getValue());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        if (src.hasNoMap() && src.getNoMap() == true) {
            tgt.addTarget(new org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent().setEquivalence(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.UNMATCHED));
        } else {
            for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
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
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        if (src.hasEquivalence())
            tgt.setRelationship(convertConceptMapRelationship(src.getEquivalence()));
        if (src.hasComment())
            tgt.setComment(src.getComment());
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        if (src.hasRelationship())
            tgt.setEquivalence(convertConceptMapEquivalence(src.getRelationship()));
        if (src.hasComment())
            tgt.setComment(src.getComment());
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }
}
