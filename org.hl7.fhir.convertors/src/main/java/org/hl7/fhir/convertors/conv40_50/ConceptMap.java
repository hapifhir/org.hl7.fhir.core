package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class ConceptMap extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.ConceptMap convertConceptMap(org.hl7.fhir.r4.model.ConceptMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ConceptMap tgt = new org.hl7.fhir.r5.model.ConceptMap();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasSource())
      tgt.setSource(convertType(src.getSource()));
    if (src.hasTarget())
      tgt.setTarget(convertType(src.getTarget()));
    for (org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertConceptMapGroupComponent(t));
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
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasSource())
      tgt.setSource(convertType(src.getSource()));
    if (src.hasTarget())
      tgt.setTarget(convertType(src.getTarget()));
    for (org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertConceptMapGroupComponent(t));
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
    for (org.hl7.fhir.r4.model.ConceptMap.SourceElementComponent t : src.getElement())
      tgt.addElement(convertSourceElementComponent(t));
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
    for (org.hl7.fhir.r5.model.ConceptMap.SourceElementComponent t : src.getElement())
      tgt.addElement(convertSourceElementComponent(t));
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
    for (org.hl7.fhir.r4.model.ConceptMap.TargetElementComponent t : src.getTarget())
      tgt.addTarget(convertTargetElementComponent(t));
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
    for (org.hl7.fhir.r5.model.ConceptMap.TargetElementComponent t : src.getTarget())
      tgt.addTarget(convertTargetElementComponent(t));
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
      tgt.setEquivalence(Enumerations.convertConceptMapEquivalence(src.getEquivalence()));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getDependsOn())
      tgt.addDependsOn(convertOtherElementComponent(t));
    for (org.hl7.fhir.r4.model.ConceptMap.OtherElementComponent t : src.getProduct())
      tgt.addProduct(convertOtherElementComponent(t));
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
    if (src.hasEquivalence())
      tgt.setEquivalence(Enumerations.convertConceptMapEquivalence(src.getEquivalence()));
    if (src.hasComment())
      tgt.setCommentElement(convertString(src.getCommentElement()));
    for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getDependsOn())
      tgt.addDependsOn(convertOtherElementComponent(t));
    for (org.hl7.fhir.r5.model.ConceptMap.OtherElementComponent t : src.getProduct())
      tgt.addProduct(convertOtherElementComponent(t));
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
      tgt.setMode(convertConceptMapGroupUnmappedMode(src.getMode()));
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
      tgt.setMode(convertConceptMapGroupUnmappedMode(src.getMode()));
    if (src.hasCode())
      tgt.setCodeElement(convertCode(src.getCodeElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    if (src.hasUrl())
      tgt.setUrlElement(convertCanonical(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode convertConceptMapGroupUnmappedMode(org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROVIDED: return org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.PROVIDED;
    case FIXED: return org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.FIXED;
    case OTHERMAP: return org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.OTHERMAP;
    default: return org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode convertConceptMapGroupUnmappedMode(org.hl7.fhir.r5.model.ConceptMap.ConceptMapGroupUnmappedMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROVIDED: return org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode.PROVIDED;
    case FIXED: return org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode.FIXED;
    case OTHERMAP: return org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode.OTHERMAP;
    default: return org.hl7.fhir.r4.model.ConceptMap.ConceptMapGroupUnmappedMode.NULL;
  }
}


}
