package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;

import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.utils.ToolingExtensions;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class ConceptMap40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.r4.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        if (src.hasSource())
            tgt.setSource(convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(convertType(src.getTarget()));
        for (org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup()) tgt.addGroup(convertConceptMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap convertConceptMap(org.hl7.fhir.r5.model.ConceptMap src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap tgt = new org.hl7.fhir.r4.model.ConceptMap();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        if (src.hasSource())
            tgt.setSource(convertType(src.getSource()));
        if (src.hasTarget())
            tgt.setTarget(convertType(src.getTarget()));
        for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup()) tgt.addGroup(convertConceptMapGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent();
        copyElement(src, tgt);
        if (src.hasSource())
            tgt.setSourceElement(convertUri(src.getSourceElement()));
        if (src.hasSourceVersion())
            tgt.setSourceVersionElement(convertString(src.getSourceVersionElement()));
        if (src.hasTarget())
            tgt.setTargetElement(convertUri(src.getTargetElement()));
        if (src.hasTargetVersion())
            tgt.setTargetVersionElement(convertString(src.getTargetVersionElement()));
        for (org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
        if (src.hasUnmapped())
            tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent();
        copyElement(src, tgt);
        if (src.hasSource())
            tgt.setSourceElement(convertUri(src.getSourceElement()));
        if (src.hasSourceVersion())
            tgt.setSourceVersionElement(convertString(src.getSourceVersionElement()));
        if (src.hasTarget())
            tgt.setTargetElement(convertUri(src.getTargetElement()));
        if (src.hasTargetVersion())
            tgt.setTargetVersionElement(convertString(src.getTargetVersionElement()));
        for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : src.getElement()) tgt.addElement(convertSourceElementComponent(t));
        if (src.hasUnmapped())
            tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        for (org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent t : src.getTarget()) if (t.getEquivalence() == org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.UNMATCHED) {
            tgt.setNoMap(true);
        } else {
            tgt.addTarget(convertTargetElementComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasNoMap() && src.getNoMap() == true) {
            tgt.addTarget(new org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent().setEquivalence(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.UNMATCHED));
        } else {
            for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget()) tgt.addTarget(convertTargetElementComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasEquivalence())
            tgt.setRelationshipElement(convertConceptMapRelationship(src.getEquivalenceElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasRelationship())
            tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getRelationshipElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn()) tgt.addDependsOn(convertOtherElementComponent(t));
        for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct()) tgt.addProduct(convertOtherElementComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence> convertConceptMapEquivalence(Enumeration<ConceptMapRelationship> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence> tgt = new org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence>(new org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalenceEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE);
        if (src.hasExtension(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE)) {
            tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE));
        } else {
            switch(src.getValue()) {
            case RELATEDTO:
              tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.RELATEDTO);
              break;
                case EQUIVALENT:
                    tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.EQUIVALENT);
                    break;
                case SOURCEISNARROWERTHANTARGET:
                    tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.WIDER);
                    break;
                case SOURCEISBROADERTHANTARGET:
                    tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NARROWER);
                    break;
                case NOTRELATEDTO:
                    tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.DISJOINT);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.NULL);
                    break;
            }
        }
        return tgt;
    }

    public static Enumeration<ConceptMapRelationship> convertConceptMapRelationship(org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        Enumeration<ConceptMapRelationship> tgt = new Enumeration<ConceptMapRelationship>(new Enumerations.ConceptMapRelationshipEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
            case RELATEDTO:
              tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship.RELATEDTO);
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

    public static org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent();
        copyElement(src, tgt);
        if (src.hasProperty())
            tgt.setPropertyElement(convertUri(src.getPropertyElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertCanonical(src.getSystemElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent();
        copyElement(src, tgt);
        if (src.hasProperty())
            tgt.setPropertyElement(convertUri(src.getPropertyElement()));
        if (src.hasSystem())
            tgt.setSystemElement(convertCanonical(src.getSystemElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent();
        copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasUrl())
            tgt.setUrlElement(convertCanonical(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent();
        copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertCode(src.getCodeElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        if (src.hasUrl())
            tgt.setUrlElement(convertCanonical(src.getUrlElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
}