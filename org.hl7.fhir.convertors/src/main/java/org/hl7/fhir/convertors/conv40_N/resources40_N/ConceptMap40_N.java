package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.model.core.Enumerations.ConceptMapRelationship;
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

public class ConceptMap40_N {

  public static org.hl7.fhir.model.core.ConceptMap convertConceptMap(org.hl7.fhir.r4.model.ConceptMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ConceptMap tgt = new org.hl7.fhir.model.core.ConceptMap();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasSource())
      tgt.setSourceScope(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSource()));
    if (src.hasTarget())
      tgt.setTargetScope(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTarget()));
    for (org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertConceptMapGroupComponent(t, tgt));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap convertConceptMap(org.hl7.fhir.model.core.ConceptMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap tgt = new org.hl7.fhir.r4.model.ConceptMap();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasSourceScope())
      tgt.setSource(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSourceScope()));
    if (src.hasTargetScope())
      tgt.setTarget(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTargetScope()));
    for (org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent t : src.getGroupList())
      tgt.addGroup(convertConceptMapGroupComponent(t, src));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent src, org.hl7.fhir.model.core.ConceptMap tgtMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
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
    org.hl7.fhir.model.core.CanonicalType tgt = new org.hl7.fhir.model.core.CanonicalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(srcUri == null ? srcVersion : srcUri, tgt);
    if (srcUri.hasValue()) {
      if (srcVersion.hasValue()) {
        tgt.setValue(srcUri.getValue() + "|" + srcVersion.getValue());
      } else {
        tgt.setValue(srcUri.getValue());
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent convertConceptMapGroupComponent(org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupComponent src, org.hl7.fhir.model.core.ConceptMap srcMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
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
    for (org.hl7.fhir.model.core.ConceptMap.SourceElementComponent t : src.getElementList())
      tgt.addElement(convertSourceElementComponent(t, srcMap));
    if (src.hasUnmapped())
      tgt.setUnmapped(convertConceptMapGroupUnmappedComponent(src.getUnmapped()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent src, org.hl7.fhir.model.core.ConceptMap tgtMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.model.core.ConceptMap.SourceElementComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    for (org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent t : src.getTarget()) {
      if (t.getEquivalence() == org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.UNMATCHED) {
        tgt.setNoMap(true);
        if (t.hasComment()) {
          if (tgt.hasExtension(ExtensionDefinitions.EXT_CM_NOMAP_COMMENT)) {
            throw new FHIRException("A source can only have one 'unmatched' relationship. Consider using 'disjoint' ");
          }
          tgt.addExtension(ExtensionDefinitions.EXT_CM_NOMAP_COMMENT, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(t.getCommentElement()));
        }
      } else {
        tgt.addTarget(convertTargetElementComponent(t, tgtMap));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent convertSourceElementComponent(org.hl7.fhir.model.core.ConceptMap.SourceElementComponent src, org.hl7.fhir.model.core.ConceptMap srcMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, ExtensionDefinitions.EXT_CM_NOMAP_COMMENT);
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    if (src.hasNoMap() && src.getNoMap() == true) {
      org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent t = new org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent();
      t.setEquivalence(org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalence.UNMATCHED);
      if (src.hasExtension(ExtensionDefinitions.EXT_CM_NOMAP_COMMENT)) {
        t.setCommentElement((org.hl7.fhir.r4.model.StringType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(ExtensionDefinitions.EXT_CM_NOMAP_COMMENT).getValue()));
      }
      tgt.addTarget(t);
    } else {
      for (org.hl7.fhir.model.core.ConceptMap.TargetElementComponent t : src.getTargetList())
        tgt.addTarget(convertTargetElementComponent(t, srcMap));
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent src, org.hl7.fhir.model.core.ConceptMap tgtMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.model.core.ConceptMap.TargetElementComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    if (src.hasEquivalence())
      tgt.setRelationshipElement(convertConceptMapRelationship(src.getEquivalenceElement(), tgt));
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getDependsOn())
      tgt.addDependsOn(convertOtherElementComponent(t, tgtMap));
    for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getProduct())
      tgt.addProduct(convertOtherElementComponent(t, tgtMap));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent convertTargetElementComponent(org.hl7.fhir.model.core.ConceptMap.TargetElementComponent src, org.hl7.fhir.model.core.ConceptMap srcMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE);
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    if (src.hasRelationship())
      tgt.setEquivalenceElement(convertConceptMapEquivalence(src.getRelationshipElement(), src));
    else
      tgt.setEquivalence(ConceptMapEquivalence.RELATEDTO);
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertString(src.getCommentElement()));
    for (org.hl7.fhir.model.core.ConceptMap.OtherElementComponent t : src.getDependsOnList())
      tgt.addDependsOn(convertOtherElementComponent(t, srcMap));
    for (org.hl7.fhir.model.core.ConceptMap.OtherElementComponent t : src.getProductList())
      tgt.addProduct(convertOtherElementComponent(t, srcMap));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence> convertConceptMapEquivalence(Enumeration<ConceptMapRelationship> src, org.hl7.fhir.model.core.ConceptMap.TargetElementComponent ccm) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence> tgt = new org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence>(new org.hl7.fhir.r4.model.Enumerations.ConceptMapEquivalenceEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (ccm.hasExtension(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE)) {
      tgt.setValueAsString(ccm.getExtensionString(VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE));
    } else {
        if (src.getValue() == null) {
            tgt.setValue(null);
        } else {
            switch (src.getValue()) {
                case RELATEDTO:
                    tgt.setValue(ConceptMapEquivalence.RELATEDTO);
                    break;
                case EQUIVALENT:
                    tgt.setValue(ConceptMapEquivalence.EQUIVALENT);
                    break;
                case SOURCEISNARROWERTHANTARGET:
                    tgt.setValue(ConceptMapEquivalence.WIDER);
                    break;
                case SOURCEISBROADERTHANTARGET:
                    tgt.setValue(ConceptMapEquivalence.NARROWER);
                    break;
                case NOTRELATEDTO:
                    tgt.setValue(ConceptMapEquivalence.DISJOINT);
                    break;
                default:
                    tgt.setValue(ConceptMapEquivalence.NULL);
                    break;
            }
        }
    }
    return tgt;
  }

  public static Enumeration<ConceptMapRelationship> convertConceptMapRelationship(org.hl7.fhir.r4.model.Enumeration<ConceptMapEquivalence> src, org.hl7.fhir.model.core.ConceptMap.TargetElementComponent tgtCtxt) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ConceptMapRelationship> tgt = new Enumeration<ConceptMapRelationship>(new Enumerations.ConceptMapRelationshipEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    org.hl7.fhir.model.extensions.ExtensionUtilities.setCodeExtensionMod(tgtCtxt, VersionConvertorConstants.EXT_OLD_CONCEPTMAP_EQUIVALENCE, src.getValueAsString());
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQUIVALENT:
                  tgt.setValue(ConceptMapRelationship.EQUIVALENT);
                  break;
              case EQUAL:
                  tgt.setValue(ConceptMapRelationship.EQUIVALENT);
                  break;
              case WIDER:
                  tgt.setValue(ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
                  break;
              case SUBSUMES:
                  tgt.setValue(ConceptMapRelationship.SOURCEISNARROWERTHANTARGET);
                  break;
              case NARROWER:
                  tgt.setValue(ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
                  break;
              case SPECIALIZES:
                  tgt.setValue(ConceptMapRelationship.SOURCEISBROADERTHANTARGET);
                  break;
              case RELATEDTO:
                  tgt.setValue(ConceptMapRelationship.RELATEDTO);
                  break;
              case INEXACT:
                  tgt.setValue(ConceptMapRelationship.RELATEDTO);
                  break;
              case UNMATCHED:
                  tgt.setValue(ConceptMapRelationship.NULL);
                  break;
              case DISJOINT:
                  tgt.setValue(ConceptMapRelationship.NOTRELATEDTO);
                  break;
              default:
                  tgt.setValue(ConceptMapRelationship.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent src, org.hl7.fhir.model.core.ConceptMap tgtMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.model.core.ConceptMap.OtherElementComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasProperty())
      tgt.setAttribute(tgtMap.registerAttribute(src.getProperty()));
    if (src.hasSystem()) {
      tgt.setValue(new Coding().setSystem(src.getSystem()).setCode(src.getValue()).setDisplay(src.getDisplay()));
    } else if (src.hasValueElement()) {
      tgt.setValue(String40_N.convertString(src.getValueElement()));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent convertOtherElementComponent(org.hl7.fhir.model.core.ConceptMap.OtherElementComponent src, org.hl7.fhir.model.core.ConceptMap srcMap) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
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

  public static org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupUnmappedComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    if (src.hasUrl())
      tgt.setOtherMapElement(Canonical40_N.convertCanonical(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent convertConceptMapGroupUnmappedComponent(org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupUnmappedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent tgt = new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertConceptMapGroupUnmappedMode(src.getModeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    if (src.hasOtherMap())
      tgt.setUrlElement(Canonical40_N.convertCanonical(src.getOtherMapElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ConceptMap.ConceptMapGroupUnmappedMode> tgt = new Enumeration<>(new ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROVIDED:
                  tgt.setValue(ConceptMap.ConceptMapGroupUnmappedMode.USESOURCECODE);
                  break;
              case FIXED:
                  tgt.setValue(ConceptMap.ConceptMapGroupUnmappedMode.FIXED);
                  break;
              case OTHERMAP:
                  tgt.setValue(ConceptMap.ConceptMapGroupUnmappedMode.OTHERMAP);
                  break;
              default:
                  tgt.setValue(ConceptMap.ConceptMapGroupUnmappedMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> convertConceptMapGroupUnmappedMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ConceptMap.ConceptMapGroupUnmappedMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}