package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;
import org.hl7.fhir.exceptions.FHIRException;

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
public class ExampleScenario43_50 {

  public static org.hl7.fhir.r5.model.ExampleScenario convertExampleScenario(org.hl7.fhir.r4b.model.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario tgt = new org.hl7.fhir.r5.model.ExampleScenario();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
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
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getWorkflow())
      tgt.getWorkflow().add(Canonical43_50.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario convertExampleScenario(org.hl7.fhir.r5.model.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario tgt = new org.hl7.fhir.r4b.model.ExampleScenario();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
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
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getWorkflow())
      tgt.getWorkflow().add(Canonical43_50.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasActorId())
      tgt.setActorIdElement(String43_50.convertString(src.getActorIdElement()));
    if (src.hasType())
      tgt.setTypeElement(convertExampleScenarioActorType(src.getTypeElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasActorId())
      tgt.setActorIdElement(String43_50.convertString(src.getActorIdElement()));
    if (src.hasType())
      tgt.setTypeElement(convertExampleScenarioActorType(src.getTypeElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType> convertExampleScenarioActorType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PERSON:
        tgt.setValue(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType.PERSON);
        break;
      case ENTITY:
        tgt.setValue(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType.ENTITY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType> convertExampleScenarioActorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PERSON:
        tgt.setValue(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType.PERSON);
        break;
      case ENTITY:
        tgt.setValue(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType.ENTITY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasResourceId())
      tgt.setResourceIdElement(String43_50.convertString(src.getResourceIdElement()));
    if (src.hasResourceType())
      tgt.setTypeElement(Code43_50.convertCode(src.getResourceTypeElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasResourceId())
      tgt.setResourceIdElement(String43_50.convertString(src.getResourceIdElement()));
    if (src.hasType())
      tgt.setResourceTypeElement(Code43_50.convertCode(src.getTypeElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    return tgt;
  }


  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasVersionId())
      tgt.setVersionIdElement(String43_50.convertString(src.getVersionIdElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasVersionId())
      tgt.setVersionIdElement(String43_50.convertString(src.getVersionIdElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasResourceId())
      tgt.setResourceIdElement(String43_50.convertString(src.getResourceIdElement()));
    if (src.hasVersionId())
      tgt.setVersionIdElement(String43_50.convertString(src.getVersionIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasResourceId())
      tgt.setResourceIdElement(String43_50.convertString(src.getResourceIdElement()));
    if (src.hasVersionId())
      tgt.setVersionIdElement(String43_50.convertString(src.getVersionIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(MarkDown43_50.convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(MarkDown43_50.convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(MarkDown43_50.convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(MarkDown43_50.convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    if (src.hasPause())
      tgt.setPauseElement(Boolean43_50.convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    if (src.hasPause())
      tgt.setPauseElement(Boolean43_50.convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(String43_50.convertString(src.getNumberElement()));
    if (src.hasType())
      tgt.setTypeElement(String43_50.convertString(src.getTypeElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(String43_50.convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(String43_50.convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(Boolean43_50.convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(Boolean43_50.convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasNumber())
      tgt.setNumberElement(String43_50.convertString(src.getNumberElement()));
    if (src.hasType())
      tgt.setTypeElement(String43_50.convertString(src.getTypeElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(String43_50.convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(String43_50.convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(Boolean43_50.convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(Boolean43_50.convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }
}