package org.hl7.fhir.convertors.conv10_40;

import java.util.ArrayList;
import java.util.List;
import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.ConceptMap;
import org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent;

public class ConceptMap10_40 {

    public static org.hl7.fhir.r4.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu2.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ConceptMap tgt = new org.hl7.fhir.r4.model.ConceptMap();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_40.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        org.hl7.fhir.r4.model.Type r = VersionConvertor_10_40.convertType(src.getSource());
        tgt.setSource(r instanceof org.hl7.fhir.r4.model.Reference ? new CanonicalType(((org.hl7.fhir.r4.model.Reference) r).getReference()) : r);
        r = VersionConvertor_10_40.convertType(src.getTarget());
        tgt.setTarget(r instanceof org.hl7.fhir.r4.model.Reference ? new CanonicalType(((org.hl7.fhir.r4.model.Reference) r).getReference()) : r);
        for (org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent t : src.getElement()) {
            List<VersionConvertor_10_40.SourceElementComponentWrapper> ws = convertSourceElementComponent(t);
            for (VersionConvertor_10_40.SourceElementComponentWrapper w : ws) getGroup(tgt, w.source, w.target).addElement(w.comp);
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap convertConceptMap(org.hl7.fhir.r4.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap tgt = new org.hl7.fhir.dstu2.model.ConceptMap();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_40.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasSource())
            tgt.setSource(VersionConvertor_10_40.convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_10_40.convertType(src.getTarget()));
        for (org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent g : src.getGroup()) for (org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent t : g.getElement()) tgt.addElement(convertSourceElementComponent(t, g));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent convertConceptMapContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertConceptMapContactComponent(org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence> convertConceptMapEquivalence(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUIVALENT:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.EQUIVALENT);
                break;
            case EQUAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.EQUAL);
                break;
            case WIDER:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.WIDER);
                break;
            case SUBSUMES:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.SUBSUMES);
                break;
            case NARROWER:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.NARROWER);
                break;
            case SPECIALIZES:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.SPECIALIZES);
                break;
            case INEXACT:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.INEXACT);
                break;
            case UNMATCHED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.UNMATCHED);
                break;
            case DISJOINT:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.DISJOINT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence> convertConceptMapEquivalence(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
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

    public static org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasElementElement())
            tgt.setPropertyElement(VersionConvertor_10_40.convertUri(src.getElementElement()));
        if (src.hasCodeSystem())
            tgt.setSystem(src.getCodeSystem());
        if (src.hasCodeElement())
            tgt.setValueElement(VersionConvertor_10_40.convertString(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setElementElement(VersionConvertor_10_40.convertUri(src.getPropertyElement()));
        if (src.hasSystem())
            tgt.setCodeSystem(src.getSystem());
        if (src.hasValueElement())
            tgt.setCodeElement(VersionConvertor_10_40.convertString(src.getValueElement()));
        return tgt;
    }

    public static List<VersionConvertor_10_40.SourceElementComponentWrapper> convertSourceElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        List<VersionConvertor_10_40.SourceElementComponentWrapper> res = new ArrayList<VersionConvertor_10_40.SourceElementComponentWrapper>();
        if (src == null || src.isEmpty())
            return res;
        for (org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
            org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent();
            VersionConvertor_10_40.copyElement(src, tgt);
            tgt.setCode(src.getCode());
            tgt.addTarget(convertTargetElementComponent(t));
            res.add(new VersionConvertor_10_40.SourceElementComponentWrapper(tgt, src.getCodeSystem(), t.getCodeSystem()));
        }
        return res;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setCodeSystem(g.getSource());
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_40.convertCode(src.getCodeElement()));
        for (org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t, g));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setCodeSystem(g.getTarget());
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_40.convertCode(src.getCodeElement()));
        if (src.hasEquivalence())
            tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getEquivalenceElement()));
        if (src.hasCommentElement())
            tgt.setCommentsElement(VersionConvertor_10_40.convertString(src.getCommentElement()));
        for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_40.convertCode(src.getCodeElement()));
        if (src.hasEquivalence())
            tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getEquivalenceElement()));
        if (src.hasCommentsElement())
            tgt.setCommentElement(VersionConvertor_10_40.convertString(src.getCommentsElement()));
        for (org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    static public ConceptMapGroupComponent getGroup(ConceptMap map, String srcs, String tgts) {
        for (ConceptMapGroupComponent grp : map.getGroup()) {
            if (grp.getSource().equals(srcs) && grp.getTarget().equals(tgts))
                return grp;
        }
        ConceptMapGroupComponent grp = map.addGroup();
        grp.setSource(srcs);
        grp.setTarget(tgts);
        return grp;
    }
}