package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Type30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ContactDetail30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.UsageContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.*;
import org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.CanonicalPair;

public class ConceptMap30_50 {

    public static org.hl7.fhir.dstu3.model.ConceptMap convertConceptMap(org.hl7.fhir.r5.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap tgt = new org.hl7.fhir.dstu3.model.ConceptMap();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersion())
            tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_50.convertMarkdown(src.getCopyrightElement()));
        if (src.hasSource())
            tgt.setSource(Type30_50.convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(Type30_50.convertType(src.getTarget()));
        for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup()) tgt.addGroup(convertConceptMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.dstu3.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_50.convertMarkdown(src.getCopyrightElement()));
        if (src.hasSource()) {
            org.hl7.fhir.r5.model.DataType t = Type30_50.convertType(src.getSource());
            tgt.setSource(t instanceof org.hl7.fhir.r5.model.Reference ? new org.hl7.fhir.r5.model.CanonicalType(((org.hl7.fhir.r5.model.Reference) t).getReference()) : t);
        }
        if (src.hasTarget()) {
            org.hl7.fhir.r5.model.DataType t = Type30_50.convertType(src.getTarget());
            tgt.setTarget(t instanceof org.hl7.fhir.r5.model.Reference ? new org.hl7.fhir.r5.model.CanonicalType(((org.hl7.fhir.r5.model.Reference) t).getReference()) : t);
        }
        for (org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup()) tgt.addGroup(convertConceptMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasSource() || src.hasSourceVersion())
          tgt.setSourceElement(convertUriAndVersionToCanonical(src.getSourceElement(), src.getSourceVersionElement()));
        if (src.hasTarget() || src.hasTargetVersion())
          tgt.setSourceElement(convertUriAndVersionToCanonical(src.getTargetElement(), src.getTargetVersionElement()));

        for (org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
        if (src.hasUnmapped())
            tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasSource()) {
          CanonicalPair cp = new CanonicalPair(src.getSource());
          tgt.setSource(cp.getUrl());
          tgt.setSourceVersion(cp.getVersion());
        }
        if (src.hasTarget()) {
          CanonicalPair cp = new CanonicalPair(src.getTarget());
          tgt.setTarget(cp.getUrl());
          tgt.setTargetVersion(cp.getVersion());
        }
        for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
        if (src.hasUnmapped())
            tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
        return tgt;
    }

    private static CanonicalType convertUriAndVersionToCanonical(org.hl7.fhir.dstu3.model.UriType srcUri, org.hl7.fhir.dstu3.model.StringType srcVersion) {
      if (srcUri == null && srcVersion == null)
        return null;
      org.hl7.fhir.r5.model.CanonicalType tgt = new org.hl7.fhir.r5.model.CanonicalType();
      Element30_50.copyElement(srcUri == null ? srcVersion : srcUri, tgt);
      if (srcUri.hasValue()) {
        if (srcVersion.hasValue()) {
          tgt.setValue(srcUri.getValue()+"|"+srcVersion.getValue());
        } else {
          tgt.setValue(srcUri.getValue());        
        }
      }
      return tgt;
    }


    public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
        if (src.hasCode())
            tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
        if (src.hasCode())
            tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
        Element30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROVIDED:
                tgt.setValue(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.PROVIDED);
                break;
            case FIXED:
                tgt.setValue(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.FIXED);
                break;
            case OTHERMAP:
                tgt.setValue(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.OTHERMAP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
        Element30_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.dstu3.model.Enumeration<ConceptMapEquivalence> convertConceptMapEquivalence(Enumeration<ConceptMapRelationship> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<ConceptMapEquivalence> tgt = new org.hl7.fhir.dstu3.model.Enumeration<ConceptMapEquivalence>(new org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        Element30_50.copyElement(src, tgt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE);
        if (src.hasExtension(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE)) {
            tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE));
        } else {
            switch(src.getValue()) {
                case EQUIVALENT:
                    tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.EQUIVALENT);
                    break;
                case SOURCEISNARROWERTHANTARGET:
                    tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.WIDER);
                    break;
                case SOURCEISBROADERTHANTARGET:
                    tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.NARROWER);
                    break;
                case NOTRELATEDTO:
                    tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.DISJOINT);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.ConceptMapEquivalence.NULL);
                    break;
            }
        }
        return tgt;
    }

    public static Enumeration<ConceptMapRelationship> convertConceptMapRelationship(org.hl7.fhir.dstu3.model.Enumeration<ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        Enumeration<ConceptMapRelationship> tgt = new Enumeration<ConceptMapRelationship>(new Enumerations.ConceptMapRelationshipEnumFactory());
        Element30_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasProperty())
            tgt.setPropertyElement(Uri30_50.convertUri(src.getPropertyElement()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasCode())
            tgt.setValueElement(String30_50.convertString(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasProperty())
            tgt.setPropertyElement(Uri30_50.convertUri(src.getPropertyElement()));
        if (src.hasSystem())
            tgt.setSystem(src.getSystem());
        if (src.hasValue())
            tgt.setCodeElement(String30_50.convertString(src.getValueElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.SourceElementComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
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
        Element30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
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
        Element30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
        if (src.hasEquivalence())
            tgt.setRelationshipElement(convertConceptMapRelationship(src.getEquivalenceElement()));
        if (src.hasComment())
            tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.dstu3.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.dstu3.model.ConceptMap.TargetElementComponent();
        Element30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
        if (src.hasRelationship())
            tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getRelationshipElement()));
        if (src.hasComment())
            tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }
}