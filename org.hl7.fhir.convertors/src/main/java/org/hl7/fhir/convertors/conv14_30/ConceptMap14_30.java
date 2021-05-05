package org.hl7.fhir.convertors.conv14_30;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.SourceElementComponentWrapper;
import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.dstu3.model.ConceptMap;
import org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.exceptions.FHIRException;

public class ConceptMap14_30 {

    public static org.hl7.fhir.dstu2016may.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu3.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_30.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_14_30.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_30.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasSource())
            tgt.setSource(VersionConvertor_14_30.convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_14_30.convertType(src.getTarget()));
        for (org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent g : src.getGroup()) for (org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent t : g.getElement()) tgt.addElement(convertSourceElementComponent(t, g));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu2016may.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap tgt = new org.hl7.fhir.dstu3.model.ConceptMap();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_30.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_14_30.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_30.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_30.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasSource())
            tgt.setSource(VersionConvertor_14_30.convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_14_30.convertType(src.getTarget()));
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent t : src.getElement()) {
            List<SourceElementComponentWrapper<ConceptMap.SourceElementComponent>> ws = convertSourceElementComponent(t);
            for (SourceElementComponentWrapper<ConceptMap.SourceElementComponent> w : ws) getGroup(tgt, w.getSource(), w.getTarget()).addElement(w.getComp());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent convertConceptMapContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertConceptMapContactComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence> convertConceptMapEquivalence(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case EQUIVALENT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.EQUIVALENT);
                break;
            case EQUAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.EQUAL);
                break;
            case WIDER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.WIDER);
                break;
            case SUBSUMES:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.SUBSUMES);
                break;
            case NARROWER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.NARROWER);
                break;
            case SPECIALIZES:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.SPECIALIZES);
                break;
            case INEXACT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.INEXACT);
                break;
            case UNMATCHED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.UNMATCHED);
                break;
            case DISJOINT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.DISJOINT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence> convertConceptMapEquivalence(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
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

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setElementElement(VersionConvertor_14_30.convertUri(src.getPropertyElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_14_30.convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_30.convertString(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasElementElement())
            tgt.setPropertyElement(VersionConvertor_14_30.convertUri(src.getElementElement()));
        if (src.hasSystemElement())
            tgt.setSystemElement(VersionConvertor_14_30.convertUri(src.getSystemElement()));
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_14_30.convertString(src.getCodeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (g.hasSource())
            tgt.setSystem(g.getSource());
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_14_30.convertCode(src.getCodeElement()));
        for (org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t, g));
        return tgt;
    }

    public static List<SourceElementComponentWrapper<ConceptMap.SourceElementComponent>> convertSourceElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        List<SourceElementComponentWrapper<ConceptMap.SourceElementComponent>> res = new ArrayList<>();
        if (src == null || src.isEmpty())
            return res;
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
            org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent();
            VersionConvertor_14_30.copyElement(src, tgt);
            if (src.hasCode())
                tgt.setCode(src.getCode());
            tgt.addTarget(convertTargetElementComponent(t));
            res.add(new SourceElementComponentWrapper<>(tgt, src.getSystem(), t.getSystem()));
        }
        return res;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (g.hasTarget())
            tgt.setSystem(g.getTarget());
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_14_30.convertCode(src.getCodeElement()));
        if (src.hasEquivalence())
            tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getEquivalenceElement()));
        if (src.hasComment())
            tgt.setCommentsElement(VersionConvertor_14_30.convertString(src.getCommentElement()));
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_14_30.convertCode(src.getCodeElement()));
        if (src.hasEquivalence())
            tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getEquivalenceElement()));
        if (src.hasComments())
            tgt.setCommentElement(VersionConvertor_14_30.convertString(src.getCommentsElement()));
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
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