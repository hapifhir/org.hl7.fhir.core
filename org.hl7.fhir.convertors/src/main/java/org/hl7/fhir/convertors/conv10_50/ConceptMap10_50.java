package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.UriType;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ConceptMap10_50 {

    public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu2.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement()) tgt.setUrlElement((UriType) VersionConvertor_10_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement()) tgt.setVersionElement((StringType) VersionConvertor_10_50.convertType(src.getVersionElement()));
        if (src.hasNameElement()) tgt.setNameElement((StringType) VersionConvertor_10_50.convertType(src.getNameElement()));
        if (src.hasStatus()) tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_10_50.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement()) tgt.setPublisherElement((StringType) VersionConvertor_10_50.convertType(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_10_50.convertType(src.getDateElement()));
        if (src.hasDescription()) tgt.setDescription(src.getDescription());
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
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            if (src.hasIdentifier()) {
                tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifierFirstRep()));
            }
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu2.model.BooleanType) VersionConvertor_10_50.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_50.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_50.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_50.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement()) {
            tgt.setRequirementsElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getPurposeElement()));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getCopyrightElement()));
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_10_50.convertType(src.getSource()));
        }
        if (src.hasTarget()) {
            tgt.setTarget(VersionConvertor_10_50.convertType(src.getTarget()));
        }
        if (src.hasGroup()) {
            for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g : src.getGroup()) for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : g.getElement()) tgt.addElement(convertSourceElementComponent(t, g));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertConceptMapContactComponent(org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_10_50.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent convertConceptMapContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.ConceptMapContactComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        }
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
        if (src.hasPropertyElement()) {
            tgt.setElementElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_50.convertType(src.getPropertyElement()));
        }
        if (src.hasSystemElement()) {
            tgt.setCodeSystemElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_50.convertType(src.getSystemElement()));
        }
        if (src.hasValueElement()) {
            tgt.setCodeElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getValueElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasElementElement()) {
            tgt.setPropertyElement((UriType) VersionConvertor_10_50.convertType(src.getElementElement()));
        }
        if (src.hasCodeSystemElement()) {
            tgt.setSystemElement((CanonicalType) VersionConvertor_10_50.convertType(src.getCodeSystemElement()));
        }
        if (src.hasCodeElement()) {
            tgt.setValueElement((StringType) VersionConvertor_10_50.convertType(src.getCodeElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.SourceElementComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCodeSystem(g.getSource());
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu2.model.CodeType) VersionConvertor_10_50.convertType(src.getCodeElement()));
        if (src.hasNoMap() && src.getNoMap() == true) {
            tgt.addTarget(new org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent().setEquivalence(org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.UNMATCHED));
        } else {
            if (src.hasTarget()) {
                for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t, g));
            }
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
            if (src.hasCodeElement())
                tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_10_50.convertType(src.getCodeElement()));
            if (t.getEquivalence() == org.hl7.fhir.dstu2.model.Enumerations.ConceptMapEquivalence.UNMATCHED) {
                tgt.setNoMap(true);
            } else {
                tgt.addTarget(convertTargetElementComponent(t));
            }
            if (src.hasCodeSystem()) {
                res.add(new VersionConvertor_10_50.SourceElementComponentWrapper(tgt, src.getCodeSystem(), t.getCodeSystem()));
            }
        }
        return res;
    }

    public static org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCodeSystem(g.getTarget());
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu2.model.CodeType) VersionConvertor_10_50.convertType(src.getCodeElement()));
        if (src.hasRelationship()) {
            tgt.setEquivalence(convertConceptMapEquivalence(src.getRelationship()));
        }
        if (src.hasCommentElement()) {
            tgt.setCommentsElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_50.convertType(src.getCommentElement()));
        }
        if (src.hasDependsOn()) {
            for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        }
        if (src.hasProduct()) {
            for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu2.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_10_50.convertType(src.getCodeElement()));
        if (src.hasEquivalence()) {
            tgt.setRelationship(convertConceptMapRelationship(src.getEquivalence()));
        }
        if (src.hasCommentsElement()) {
            tgt.setCommentElement((StringType) VersionConvertor_10_50.convertType(src.getCommentsElement()));
        }
        if (src.hasDependsOn()) {
            for (org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        }
        if (src.hasProduct()) {
            for (org.hl7.fhir.dstu2.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
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
