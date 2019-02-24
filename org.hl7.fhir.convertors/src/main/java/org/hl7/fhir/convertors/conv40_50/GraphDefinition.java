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


public class GraphDefinition extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r4.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.GraphDefinition tgt = new org.hl7.fhir.r5.model.GraphDefinition();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
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
    if (src.hasStart())
      tgt.setStartElement(convertCode(src.getStartElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r5.model.GraphDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition tgt = new org.hl7.fhir.r4.model.GraphDefinition();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
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
    if (src.hasStart())
      tgt.setStartElement(convertCode(src.getStartElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasSliceName())
      tgt.setSliceNameElement(convertString(src.getSliceNameElement()));
    if (src.hasMin())
      tgt.setMinElement(convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasSliceName())
      tgt.setSliceNameElement(convertString(src.getSliceNameElement()));
    if (src.hasMin())
      tgt.setMinElement(convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(convertString(src.getMaxElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget())
      tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    if (src.hasParams())
      tgt.setParamsElement(convertString(src.getParamsElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
    for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    if (src.hasParams())
      tgt.setParamsElement(convertString(src.getParamsElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment())
      tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
    for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink())
      tgt.addLink(convertGraphDefinitionLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUse(convertGraphCompartmentUse(src.getUse()));
    if (src.hasCode())
      tgt.setCode(convertCompartmentCode(src.getCode()));
    if (src.hasRule())
      tgt.setRule(convertGraphCompartmentRule(src.getRule()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
    copyElement(src, tgt);
    if (src.hasUse())
      tgt.setUse(convertGraphCompartmentUse(src.getUse()));
    if (src.hasCode())
      tgt.setCode(convertCompartmentCode(src.getCode()));
    if (src.hasRule())
      tgt.setRule(convertGraphCompartmentRule(src.getRule()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse convertGraphCompartmentUse(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CONDITION: return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse.CONDITION;
    case REQUIREMENT: return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse.REQUIREMENT;
    default: return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse.NULL;
  }
}

  public static org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse convertGraphCompartmentUse(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentUse src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CONDITION: return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse.CONDITION;
    case REQUIREMENT: return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse.REQUIREMENT;
    default: return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentUse.NULL;
  }
}

  public static org.hl7.fhir.r5.model.GraphDefinition.CompartmentCode convertCompartmentCode(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PATIENT: return org.hl7.fhir.r5.model.GraphDefinition.CompartmentCode.PATIENT;
    case ENCOUNTER: return org.hl7.fhir.r5.model.GraphDefinition.CompartmentCode.ENCOUNTER;
    case RELATEDPERSON: return org.hl7.fhir.r5.model.GraphDefinition.CompartmentCode.RELATEDPERSON;
    case PRACTITIONER: return org.hl7.fhir.r5.model.GraphDefinition.CompartmentCode.PRACTITIONER;
    case DEVICE: return org.hl7.fhir.r5.model.GraphDefinition.CompartmentCode.DEVICE;
    default: return org.hl7.fhir.r5.model.GraphDefinition.CompartmentCode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode convertCompartmentCode(org.hl7.fhir.r5.model.GraphDefinition.CompartmentCode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PATIENT: return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PATIENT;
    case ENCOUNTER: return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.ENCOUNTER;
    case RELATEDPERSON: return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.RELATEDPERSON;
    case PRACTITIONER: return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PRACTITIONER;
    case DEVICE: return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.DEVICE;
    default: return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule convertGraphCompartmentRule(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case IDENTICAL: return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.IDENTICAL;
    case MATCHING: return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.MATCHING;
    case DIFFERENT: return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.DIFFERENT;
    case CUSTOM: return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.CUSTOM;
    default: return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.NULL;
  }
}

  public static org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule convertGraphCompartmentRule(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case IDENTICAL: return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.IDENTICAL;
    case MATCHING: return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.MATCHING;
    case DIFFERENT: return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.DIFFERENT;
    case CUSTOM: return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.CUSTOM;
    default: return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.NULL;
  }
}


}
