package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.Enumerations.ConceptMapRelationship;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.CanonicalPair;

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
public class ConceptMap43_50 {

  public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.r4b.model.ConceptMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasSource())
      tgt.setSourceScope(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSource()));
    if (src.hasTarget())
      tgt.setTargetScope(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTarget()));
    for (org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertConceptMapGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ConceptMap convertConceptMap(org.hl7.fhir.r5.model.ConceptMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ConceptMap tgt = new org.hl7.fhir.r4b.model.ConceptMap();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasSourceScope())
      tgt.setSource(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSourceScope()));
    if (src.hasTargetScope())
      tgt.setTarget(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTargetScope()));
    for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertConceptMapGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSource() || src.hasSourceVersion())
      tgt.setSourceElement(convertUriAndVersionToCanonical(src.getSourceElement(), src.getSourceVersionElement()));
    if (src.hasTarget() || src.hasTargetVersion())
      tgt.setTargetElement(convertUriAndVersionToCanonical(src.getTargetElement(), src.getTargetVersionElement()));
    for (org.hl7.fhir.r4b.model.ConceptMap.SourceElementComponent t : src.getElement())
      tgt.addElement(convertSourceElementComponent(t));
    if (src.hasUnmapped())
      tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
    return tgt;
  }

  private static CanonicalType convertUriAndVersionToCanonical(org.hl7.fhir.r4b.model.UriType srcUri, org.hl7.fhir.r4b.model.StringType srcVersion) {
    if (srcUri == null && srcVersion == null)
      return null;
    org.hl7.fhir.r5.model.CanonicalType tgt = new org.hl7.fhir.r5.model.CanonicalType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(srcUri == null ? srcVersion : srcUri, tgt);
    if (srcUri.hasValue()) {
      if (srcVersion.hasValue()) {
        tgt.setValue(srcUri.getValue() + "|" + srcVersion.getValue());
      } else {
        tgt.setValue(srcUri.getValue());
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
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
    for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : src.getElement())
      tgt.addElement(convertSourceElementComponent(t));
    if (src.hasUnmapped())
      tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r4b.model.ConceptMap.SourceElementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r4b.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
      if (t.getEquivalence() == org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence.UNMATCHED) {
        tgt.setNoMap(true);
      } else {
        tgt.addTarget(convertTargetElementComponent(t));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r4b.model.ConceptMap.SourceElementComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasNoMap() && src.getNoMap() == true) {
      tgt.addTarget(new org.hl7.fhir.r4b.model.ConceptMap.TargetElementComponent().setEquivalence(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence.UNMATCHED));
    } else {
      for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget())
        tgt.addTarget(convertTargetElementComponent(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r4b.model.ConceptMap.TargetElementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasEquivalence())
      tgt.setRelationshipElement(convertConceptMapRelationship(src.getEquivalenceElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4b.model.ConceptMap.OtherElementComponent t : src.getDependsOn())
      tgt.addDependsOn(convertOtherElementComponent(t));
    for (org.hl7.fhir.r4b.model.ConceptMap.OtherElementComponent t : src.getProduct())
      tgt.addProduct(convertOtherElementComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r4b.model.ConceptMap.TargetElementComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasRelationship())
      tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getRelationshipElement()));
    else
      tgt.setEquivalence(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence.RELATEDTO);
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn())
      tgt.addDependsOn(convertOtherElementComponent(t));
    for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct())
      tgt.addProduct(convertOtherElementComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence> convertConceptMapEquivalence(Enumeration<ConceptMapRelationship> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence> tgt = new org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence>(new org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalenceEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE);
    if (src.hasExtension(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE));
    } else {
      switch (src.getValue()) {
        case RELATEDTO:
          tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence.RELATEDTO);
          break;
        case EQUIVALENT:
          tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence.EQUIVALENT);
          break;
        case SOURCEISNARROWERTHANTARGET:
          tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence.WIDER);
          break;
        case SOURCEISBROADERTHANTARGET:
          tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence.NARROWER);
          break;
        case NOTRELATEDTO:
          tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence.DISJOINT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence.NULL);
          break;
      }
    }
    return tgt;
  }

  public static Enumeration<ConceptMapRelationship> convertConceptMapRelationship(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ConceptMap.ConceptMapEquivalence> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<ConceptMapRelationship> tgt = new Enumeration<ConceptMapRelationship>(new Enumerations.ConceptMapRelationshipEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    ToolingExtensions.setCodeExtension(tgt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE, src.getValueAsString());
    switch (src.getValue()) {
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

  public static org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r4b.model.ConceptMap.OtherElementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProperty())
      tgt.setPropertyElement(Uri43_50.convertUri(src.getPropertyElement()));
    if (src.hasSystem()) {
      tgt.setValue(new Coding().setSystem(src.getSystem()).setCode(src.getValue()).setDisplay(src.getDisplay()));
    } else if (src.hasValueElement()) {
      tgt.setValue(String43_50.convertString(src.getValueElement()));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r4b.model.ConceptMap.OtherElementComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasProperty())
      tgt.setPropertyElement(Uri43_50.convertUri(src.getPropertyElement()));
    
    if (src.hasValueCoding()) {
      tgt.setSystem(src.getValueCoding().getSystem());
      tgt.setValue(src.getValueCoding().getCode());
      tgt.setDisplay(src.getValueCoding().getDisplay());
    } else if (src.hasValue()) {
        tgt.setValue(src.getValue().primitiveValue());
    }

    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasUrl())
      tgt.setOtherMapElement(Canonical43_50.convertCanonical(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    if (src.hasOtherMap())
      tgt.setUrlElement(Canonical43_50.convertCanonical(src.getOtherMapElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROVIDED:
        tgt.setValue(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.USESOURCECODE);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case USESOURCECODE:
        tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedMode.PROVIDED);
        break;
      case FIXED:
        tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedMode.FIXED);
        break;
      case OTHERMAP:
        tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedMode.OTHERMAP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ConceptMap.ConceptMapGroupUnmappedMode.NULL);
        break;
    }
    return tgt;
  }
}