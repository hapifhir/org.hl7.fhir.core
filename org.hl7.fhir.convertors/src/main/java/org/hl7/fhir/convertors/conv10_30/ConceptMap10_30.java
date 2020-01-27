package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.ConceptMap;
import org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.ArrayList;
import java.util.List;

public class ConceptMap10_30 {

    public static org.hl7.fhir.dstu2.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu3.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap tgt = new org.hl7.fhir.dstu2.model.ConceptMap();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setRequirements(src.getPurpose());
        tgt.setCopyright(src.getCopyright());
        tgt.setSource(VersionConvertor_10_30.convertType(src.getSource()));
        tgt.setTarget(VersionConvertor_10_30.convertType(src.getTarget()));
        for (org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent g : src.getGroup()) for (org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent t : g.getElement()) tgt.addElement(convertSourceElementComponent(t, g));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu2.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap tgt = new org.hl7.fhir.dstu3.model.ConceptMap();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConceptToUsageContext(t));
        tgt.setPurpose(src.getRequirements());
        tgt.setCopyright(src.getCopyright());
        tgt.setSource(VersionConvertor_10_30.convertType(src.getSource()));
        tgt.setTarget(VersionConvertor_10_30.convertType(src.getTarget()));
        for (org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent t : src.getElement()) {
            List<VersionConvertor_10_30.SourceElementComponentWrapper> ws = convertSourceElementComponent(t);
            for (VersionConvertor_10_30.SourceElementComponentWrapper w : ws) getGroup(tgt, w.source, w.target).addElement(w.comp);
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertConceptMapContactComponent(org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent convertConceptMapContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence convertConceptMapEquivalence(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUIVALENT:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.EQUIVALENT;
            case EQUAL:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.EQUAL;
            case WIDER:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.WIDER;
            case SUBSUMES:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.SUBSUMES;
            case NARROWER:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.NARROWER;
            case SPECIALIZES:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.SPECIALIZES;
            case INEXACT:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.INEXACT;
            case UNMATCHED:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.UNMATCHED;
            case DISJOINT:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.DISJOINT;
            default:
                return org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence convertConceptMapEquivalence(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUIVALENT:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.EQUIVALENT;
            case EQUAL:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.EQUAL;
            case WIDER:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.WIDER;
            case SUBSUMES:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.SUBSUMES;
            case NARROWER:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.NARROWER;
            case SPECIALIZES:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.SPECIALIZES;
            case INEXACT:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.INEXACT;
            case UNMATCHED:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.UNMATCHED;
            case DISJOINT:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.DISJOINT;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setProperty(src.getElement());
        tgt.setSystem(src.getCodeSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setElement(src.getProperty());
        tgt.setCodeSystem(src.getSystem());
        tgt.setCode(src.getCode());
        return tgt;
    }

    public static List<VersionConvertor_10_30.SourceElementComponentWrapper> convertSourceElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        List<VersionConvertor_10_30.SourceElementComponentWrapper> res = new ArrayList<VersionConvertor_10_30.SourceElementComponentWrapper>();
        if (src == null || src.isEmpty())
            return res;
        for (org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
            org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent();
            VersionConvertor_10_30.copyElement(src, tgt);
            tgt.setCode(src.getCode());
            tgt.addTarget(convertTargetElementComponent(t));
            res.add(new VersionConvertor_10_30.SourceElementComponentWrapper(tgt, src.getCodeSystem(), t.getCodeSystem()));
        }
        return res;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setCodeSystem(g.getSource());
        tgt.setCode(src.getCode());
        for (org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t, g));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setCodeSystem(g.getTarget());
        tgt.setCode(src.getCode());
        tgt.setEquivalence(convertConceptMapEquivalence(src.getEquivalence()));
        tgt.setComments(src.getComment());
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setCode(src.getCode());
        tgt.setEquivalence(convertConceptMapEquivalence(src.getEquivalence()));
        tgt.setComment(src.getComments());
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
