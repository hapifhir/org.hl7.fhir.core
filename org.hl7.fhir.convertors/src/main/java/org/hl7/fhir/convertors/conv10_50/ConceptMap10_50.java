package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;

import java.util.ArrayList;
import java.util.List;

public class ConceptMap10_50 {

    public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu2.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_50.convertCodeableConceptToUsageContext(t));
        tgt.setPurpose(src.getRequirements());
        tgt.setCopyright(src.getCopyright());
        org.hl7.fhir.r5.model.DataType r = VersionConvertor_10_50.convertType(src.getSource());
        tgt.setSource(r instanceof org.hl7.fhir.r5.model.Reference ? new CanonicalType(((org.hl7.fhir.r5.model.Reference) r).getReference()) : r);
        r = VersionConvertor_10_50.convertType(src.getTarget());
        tgt.setTarget(r instanceof org.hl7.fhir.r5.model.Reference ? new CanonicalType(((org.hl7.fhir.r5.model.Reference) r).getReference()) : r);
        for (org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent t : src.getElement()) {
            List<VersionConvertor_10_50.SourceElementComponentWrapper> ws = convertSourceElementComponent(t);
            for (VersionConvertor_10_50.SourceElementComponentWrapper w : ws) getGroup(tgt, w.source, w.target).addElement(w.comp);
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap convertConceptMap(org.hl7.fhir.r5.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap tgt = new org.hl7.fhir.dstu2.model.ConceptMap();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifierFirstRep()));
        }
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setRequirements(src.getPurpose());
        tgt.setCopyright(src.getCopyright());
        tgt.setSource(VersionConvertor_10_50.convertType(src.getSource()));
        tgt.setTarget(VersionConvertor_10_50.convertType(src.getTarget()));
        for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g : src.getGroup()) for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : g.getElement()) tgt.addElement(convertSourceElementComponent(t, g));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertConceptMapContactComponent(org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent convertConceptMapContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence convertConceptMapEquivalence(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUIVALENT:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.EQUIVALENT;
            case BROADER:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.WIDER;
            case NARROWER:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.NARROWER;
            case NOTRELATEDTO:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.DISJOINT;
            default:
                return org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship convertConceptMapRelationship(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
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

    public static org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setElement(src.getProperty());
        tgt.setCodeSystem(src.getSystem());
        tgt.setCode(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setProperty(src.getElement());
        tgt.setSystem(src.getCodeSystem());
        tgt.setValue(src.getCode());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCodeSystem(g.getSource());
        tgt.setCode(src.getCode());
        if (src.hasNoMap() && src.getNoMap() == true) {
            tgt.addTarget(new org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent().setEquivalence(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.UNMATCHED));
        } else {
            for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t, g));
        }
        return tgt;
    }

    public static List<VersionConvertor_10_50.SourceElementComponentWrapper> convertSourceElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        List<VersionConvertor_10_50.SourceElementComponentWrapper> res = new ArrayList<VersionConvertor_10_50.SourceElementComponentWrapper>();
        if (src == null || src.isEmpty())
            return res;
        for (org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
            org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent();
            VersionConvertor_10_50.copyElement(src, tgt);
            tgt.setCode(src.getCode());
            if (t.getEquivalence() == org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.UNMATCHED) {
                tgt.setNoMap(true);
            } else {
                tgt.addTarget(convertTargetElementComponent(t));
            }
            res.add(new VersionConvertor_10_50.SourceElementComponentWrapper(tgt, src.getCodeSystem(), t.getCodeSystem()));
        }
        return res;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCodeSystem(g.getTarget());
        tgt.setCode(src.getCode());
        tgt.setEquivalence(convertConceptMapEquivalence(src.getRelationship()));
        tgt.setComments(src.getComment());
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(src.getCode());
        tgt.setRelationship(convertConceptMapRelationship(src.getEquivalence()));
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
