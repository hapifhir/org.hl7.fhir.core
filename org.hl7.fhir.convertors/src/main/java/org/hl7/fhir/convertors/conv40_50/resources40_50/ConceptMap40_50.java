package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence;
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
public class ConceptMap40_50 {

  public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.r4.model.ConceptMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasSource())
      tgt.setSourceScope(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSource()));
    if (src.hasTarget())
      tgt.setTargetScope(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getTarget()));
    for (org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertConceptMapGroupComponent(t, tgt));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap convertConceptMap(org.hl7.fhir.r5.model.ConceptMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap tgt = new org.hl7.fhir.r4.model.ConceptMap();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasSourceScope())
      tgt.setSource(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSourceScope()));
    if (src.hasTargetScope())
      tgt.setTarget(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getTargetScope()));
    for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertConceptMapGroupComponent(t, src));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent src, org.hl7.fhir.r5.model.ConceptMap tgtMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSource() || src.hasSourceVersion())
      tgt.setSourceElement(convertUriAndVersionToCanonical(src.getSourceElement(), src.getSourceVersionElement()));
    if (src.hasTarget() || src.hasTargetVersion())
      tgt.setTargetElement(convertUriAndVersionToCanonical(src.getTargetElement(), src.getTargetVersionElement()));
    for (org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent t : src.getElement())
      tgt.addElement(convertSourceElementComponent(t, tgtMap));
    if (src.hasUnmapped())
      tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
    return tgt;
  }

  private static CanonicalType convertUriAndVersionToCanonical(org.hl7.fhir.r4.model.UriType srcUri, org.hl7.fhir.r4.model.StringType srcVersion) {
    if (srcUri == null && srcVersion == null)
      return null;
    org.hl7.fhir.r5.model.CanonicalType tgt = new org.hl7.fhir.r5.model.CanonicalType();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(srcUri == null ? srcVersion : srcUri, tgt);
    if (srcUri.hasValue()) {
      if (srcVersion.hasValue()) {
        tgt.setValue(srcUri.getValue() + "|" + srcVersion.getValue());
      } else {
        tgt.setValue(srcUri.getValue());
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent src, org.hl7.fhir.r5.model.ConceptMap srcMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
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
      tgt.addElement(convertSourceElementComponent(t, srcMap));
    if (src.hasUnmapped())
      tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.r5.model.ConceptMap tgtMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
      if (t.getEquivalence() == org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.UNMATCHED) {
        tgt.setNoMap(true);
      } else {
        tgt.addTarget(convertTargetElementComponent(t, tgtMap));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.r5.model.ConceptMap srcMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    if (src.hasNoMap() && src.getNoMap() == true) {
      tgt.addTarget(new org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent().setEquivalence(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.UNMATCHED));
    } else {
      for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget())
        tgt.addTarget(convertTargetElementComponent(t, srcMap));
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.r5.model.ConceptMap tgtMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    if (src.hasEquivalence())
      tgt.setRelationshipElement(convertConceptMapRelationship(src.getEquivalenceElement()));
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getDependsOn())
      tgt.addDependsOn(convertOtherElementComponent(t, tgtMap));
    for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getProduct())
      tgt.addProduct(convertOtherElementComponent(t, tgtMap));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.r5.model.ConceptMap srcMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    if (src.hasRelationship())
      tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getRelationshipElement()));
    else
      tgt.setEquivalence(ConceptMapEquivalence.RELATEDTO);
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn())
      tgt.addDependsOn(convertOtherElementComponent(t, srcMap));
    for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct())
      tgt.addProduct(convertOtherElementComponent(t, srcMap));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence> convertConceptMapEquivalence(Enumeration<ConceptMapRelationship> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence> tgt = new org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence>(new org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalenceEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE);
    if (src.hasExtension(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE));
    } else {
      switch (src.getValue()) {
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
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent src, org.hl7.fhir.r5.model.ConceptMap tgtMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasProperty())
      tgt.setAttribute(tgtMap.registerAttribute(src.getProperty()));
    if (src.hasSystem()) {
      tgt.setValue(new Coding().setSystem(src.getSystem()).setCode(src.getValue()).setDisplay(src.getDisplay()));
    } else if (src.hasValueElement()) {
      tgt.setValue(String40_50.convertString(src.getValueElement()));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent src, org.hl7.fhir.r5.model.ConceptMap srcMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasAttribute())
      tgt.setProperty(srcMap.getAttributeUri(src.getAttribute()));    

    if (src.hasValueCoding()) {
      tgt.setSystem(src.getValueCoding().getSystem());
      tgt.setValue(src.getValueCoding().getCode());
      tgt.setDisplay(src.getValueCoding().getDisplay());
    } else if (src.hasValue()) {
        tgt.setValue(src.getValue().primitiveValue());
    }

    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    if (src.hasUrl())
      tgt.setOtherMapElement(Canonical40_50.convertCanonical(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    if (src.hasOtherMap())
      tgt.setUrlElement(Canonical40_50.convertCanonical(src.getOtherMapElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case USESOURCECODE:
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