package org.hl7.fhir.convertors.conv14_50;

import java.util.ArrayList;
import java.util.List;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.utils.ToolingExtensions;

public class ConceptMap14_50 {

    public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu2016may.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_14_50.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_50.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        org.hl7.fhir.r5.model.DataType tt = VersionConvertor_14_50.convertType(src.getSource());
        tgt.setSource(tt instanceof org.hl7.fhir.r5.model.Reference ? new CanonicalType(((org.hl7.fhir.r5.model.Reference) tt).getReference()) : tt);
        tt = VersionConvertor_14_50.convertType(src.getTarget());
        tgt.setTarget(tt instanceof org.hl7.fhir.r5.model.Reference ? new CanonicalType(((org.hl7.fhir.r5.model.Reference) tt).getReference()) : tt);
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent t : src.getElement()) {
            List<VersionConvertor_14_50.SourceElementComponentWrapper> ws = convertSourceElementComponent(t);
            for (VersionConvertor_14_50.SourceElementComponentWrapper w : ws) getGroup(tgt, w.source, w.target).addElement(w.comp);
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap convertConceptMap(org.hl7.fhir.r5.model.ConceptMap src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_50.convertUri(src.getUrlElement()));
        if (src.hasIdentifier()) {
            if (src.hasIdentifier())
                tgt.setIdentifier(VersionConvertor_14_50.convertIdentifier(src.getIdentifierFirstRep()));
        }
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertConceptMapContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_50.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.getSource() instanceof CanonicalType)
            tgt.setSource(VersionConvertor_14_50.convertCanonicalToReference((CanonicalType) src.getSource()));
        else if (src.hasSource())
            tgt.setSource(VersionConvertor_14_50.convertType(src.getSource()));
        if (src.getTarget() instanceof CanonicalType)
            tgt.setTarget(VersionConvertor_14_50.convertCanonicalToReference((CanonicalType) src.getTarget()));
        else if (src.hasTarget())
            tgt.setTarget(VersionConvertor_14_50.convertType(src.getTarget()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_14_50.convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_14_50.convertType(src.getTarget()));
        for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g : src.getGroup()) for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : g.getElement()) tgt.addElement(convertSourceElementComponent(t, g));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertConceptMapContactComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent convertConceptMapContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.ConceptMapContactComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Enumeration<ConceptMapEquivalence> convertConceptMapEquivalence(Enumeration<ConceptMapRelationship> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<ConceptMapEquivalence> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<ConceptMapEquivalence>(new org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE);
        if (src.hasExtension(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE)) {
            tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE));
        } else {
            switch(src.getValue()) {
                case EQUIVALENT:
                    tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.EQUIVALENT);
                    break;
                case SOURCEISNARROWERTHANTARGET:
                    tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.WIDER);
                    break;
                case SOURCEISBROADERTHANTARGET:
                    tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.NARROWER);
                    break;
                case NOTRELATEDTO:
                    tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.DISJOINT);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.NULL);
                    break;
            }
        }
        return tgt;
    }

    public static Enumeration<ConceptMapRelationship> convertConceptMapRelationship(org.hl7.fhir.dstu2016may.model.Enumeration<ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        Enumeration<ConceptMapRelationship> tgt = new Enumeration<ConceptMapRelationship>(new Enumerations.ConceptMapRelationshipEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        ToolingExtensions.setCodeExtension(tgt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE, src.getValueAsString());
        switch(src.getValue()) {
            case EQUIVALENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.EQUIVALENT);
                break;
            case EQUAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.EQUIVALENT);
                break;
            case WIDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
                break;
            case SUBSUMES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
                break;
            case NARROWER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
                break;
            case SPECIALIZES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
                break;
            case INEXACT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.RELATEDTO);
                break;
            case UNMATCHED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NULL);
                break;
            case DISJOINT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NOTRELATEDTO);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasPropertyElement())
            tgt.setElementElement(VersionConvertor_14_50.convertUri(src.getPropertyElement()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasValueElement())
            tgt.setCodeElement(VersionConvertor_14_50.convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasElementElement())
            tgt.setPropertyElement(VersionConvertor_14_50.convertUri(src.getElementElement()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCodeElement())
            tgt.setValueElement(VersionConvertor_14_50.convertString(src.getCodeElement()));
        return tgt;
    }

    public static List<VersionConvertor_14_50.SourceElementComponentWrapper> convertSourceElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        List<VersionConvertor_14_50.SourceElementComponentWrapper> res = new ArrayList<VersionConvertor_14_50.SourceElementComponentWrapper>();
        if (src == null || src.isEmpty())
            return res;
        for (org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
            org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent();
            VersionConvertor_14_50.copyElement(src, tgt);
            if (src.hasCode())
                tgt.setCode(src.getCode());
            if (t.getEquivalence() == org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.UNMATCHED) {
                tgt.setNoMap(true);
            } else {
                tgt.addTarget(convertTargetElementComponent(t));
            }
            res.add(new VersionConvertor_14_50.SourceElementComponentWrapper(tgt, src.getSystem(), t.getSystem()));
        }
        return res;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.SourceElementComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (g.hasSource())
            tgt.setSystem(g.getSource());
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasNoMap() && src.getNoMap() == true) {
            tgt.addTarget(new org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent().setEquivalence(org.hl7.fhir.dstu2016may.model.Enumerations.ConceptMapEquivalence.UNMATCHED));
        } else {
            for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t, g));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent g) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (g.hasTarget())
            tgt.setSystem(g.getTarget());
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasRelationship())
            tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getRelationshipElement()));
        if (src.hasComment())
            tgt.setCommentsElement(VersionConvertor_14_50.convertString(src.getCommentElement()));
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.dstu2016may.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_14_50.convertCode(src.getCodeElement()));
        if (src.hasEquivalence())
            tgt.setRelationshipElement(convertConceptMapRelationship(src.getEquivalenceElement()));
        if (src.hasComments())
            tgt.setCommentElement(VersionConvertor_14_50.convertString(src.getCommentsElement()));
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