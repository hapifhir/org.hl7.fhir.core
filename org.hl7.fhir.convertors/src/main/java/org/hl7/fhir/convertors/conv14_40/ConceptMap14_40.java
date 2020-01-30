package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.ConceptMap;
import org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent;
import java.util.ArrayList;
import java.util.List;

public class ConceptMap14_40 {

    public static org.hl7.fhir.r4.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu2016may.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ConceptMap tgt = new org.hl7.fhir.r4.model.ConceptMap();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        tgt.setIdentifier(VersionConvertor_14_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        org.hl7.fhir.r4.model.Type tt = VersionConvertor_14_40.convertType(src.getSource());
        tgt.setSource(tt instanceof org.hl7.fhir.r4.model.Reference ? new CanonicalType(((org.hl7.fhir.r4.model.Reference) tt).getReference()) : tt);
        tt = VersionConvertor_14_40.convertType(src.getTarget());
        tgt.setTarget(tt instanceof org.hl7.fhir.r4.model.Reference ? new CanonicalType(((org.hl7.fhir.r4.model.Reference) tt).getReference()) : tt);
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent t : src.getElement()) {
            List<VersionConvertor_14_40.SourceElementComponentWrapper> ws = convertSourceElementComponent(t);
            for (VersionConvertor_14_40.SourceElementComponentWrapper w : ws) getGroup(tgt, w.source, w.target).addElement(w.comp);
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap convertConceptMap(org.hl7.fhir.r4.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_14_40.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.getSource() instanceof CanonicalType)
            tgt.setSource(VersionConvertor_14_40.convertCanonicalToReference((CanonicalType) src.getSource()));
        else if (src.hasSource()) {
            tgt.setSource(VersionConvertor_14_40.convertType(src.getSource()));
        }
        if (src.getTarget() instanceof CanonicalType)
            tgt.setTarget(VersionConvertor_14_40.convertCanonicalToReference((CanonicalType) src.getTarget()));
        else if (src.hasTarget()) {
            tgt.setTarget(VersionConvertor_14_40.convertType(src.getTarget()));
        }
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_14_40.convertType(src.getSource()));
        }
        if (src.hasTarget()) {
            tgt.setTarget(VersionConvertor_14_40.convertType(src.getTarget()));
        }
        if (src.hasGroup()) {
            for (org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent g : src.getGroup()) for (org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent t : g.getElement()) tgt.addElement(convertSourceElementComponent(t, g));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent convertConceptMapContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertConceptMapContactComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence convertConceptMapEquivalence(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUIVALENT:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.EQUIVALENT;
            case EQUAL:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.EQUAL;
            case WIDER:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.WIDER;
            case SUBSUMES:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.SUBSUMES;
            case NARROWER:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NARROWER;
            case SPECIALIZES:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.SPECIALIZES;
            case INEXACT:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.INEXACT;
            case UNMATCHED:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.UNMATCHED;
            case DISJOINT:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.DISJOINT;
            default:
                return org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence convertConceptMapEquivalence(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUIVALENT:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.EQUIVALENT;
            case EQUAL:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.EQUAL;
            case WIDER:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.WIDER;
            case SUBSUMES:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.SUBSUMES;
            case NARROWER:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.NARROWER;
            case SPECIALIZES:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.SPECIALIZES;
            case INEXACT:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.INEXACT;
            case UNMATCHED:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.UNMATCHED;
            case DISJOINT:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.DISJOINT;
            default:
                return org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasElement()) {
            tgt.setProperty(src.getElement());
        }
        if (src.hasSystem()) {
            tgt.setSystem(src.getSystem());
        }
        if (src.hasCode()) {
            tgt.setValue(src.getCode());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasProperty()) {
            tgt.setElement(src.getProperty());
        }
        if (src.hasSystem()) {
            tgt.setSystem(src.getSystem());
        }
        if (src.hasValue()) {
            tgt.setCode(src.getValue());
        }
        return tgt;
    }

    public static List<VersionConvertor_14_40.SourceElementComponentWrapper> convertSourceElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        List<VersionConvertor_14_40.SourceElementComponentWrapper> res = new ArrayList<VersionConvertor_14_40.SourceElementComponentWrapper>();
        if (src == null || src.isEmpty())
            return res;
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
            org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent();
            VersionConvertor_14_40.copyElement(src, tgt);
            if (src.hasCode())
                tgt.setCode(src.getCode());
            tgt.addTarget(convertTargetElementComponent(t));
            if (src.hasSystem()) {
                res.add(new VersionConvertor_14_40.SourceElementComponentWrapper(tgt, src.getSystem(), t.getSystem()));
            }
        }
        return res;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (g.hasSource())
            tgt.setSystem(g.getSource());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasTarget()) {
            for (org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t, g));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasEquivalence()) {
            tgt.setEquivalence(convertConceptMapEquivalence(src.getEquivalence()));
        }
        if (src.hasComments())
            tgt.setComment(src.getComments());
        if (src.hasDependsOn()) {
            for (org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        }
        if (src.hasProduct()) {
            for (org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (g.hasTarget())
            tgt.setSystem(g.getTarget());
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasEquivalence()) {
            tgt.setEquivalence(convertConceptMapEquivalence(src.getEquivalence()));
        }
        if (src.hasComment())
            tgt.setComments(src.getComment());
        if (src.hasDependsOn()) {
            for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        }
        if (src.hasProduct()) {
            for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        }
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
