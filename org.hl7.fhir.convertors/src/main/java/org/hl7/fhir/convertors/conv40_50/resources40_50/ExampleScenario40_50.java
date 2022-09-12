package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType;

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
public class ExampleScenario40_50 {

  public static org.hl7.fhir.r5.model.ExampleScenario convertExampleScenario(org.hl7.fhir.r4.model.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario tgt = new org.hl7.fhir.r5.model.ExampleScenario();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
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
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
//    for (org.hl7.fhir.r4.model.CanonicalType t : src.getWorkflow())
//      tgt.getWorkflow().add(Canonical40_50.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario convertExampleScenario(org.hl7.fhir.r5.model.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario tgt = new org.hl7.fhir.r4.model.ExampleScenario();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
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
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
//    for (org.hl7.fhir.r5.model.CanonicalType t : src.getWorkflow())
//      tgt.getWorkflow().add(Canonical40_50.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasActorId())
      tgt.setKeyElement(String40_50.convertString(src.getActorIdElement()));
    if (src.hasType())
      tgt.setTypeElement(convertExampleScenarioActorType(src.getTypeElement()));
    if (src.hasName())
      tgt.setTitleElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasKey())
      tgt.setActorIdElement(String40_50.convertString(src.getKeyElement()));
    if (src.hasType())
      tgt.setTypeElement(convertExampleScenarioActorType(src.getTypeElement()));
    if (src.hasTitle())
      tgt.setNameElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ExampleScenarioActorType> convertExampleScenarioActorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ExampleScenarioActorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ExampleScenarioActorTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PERSON:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ExampleScenarioActorType.PERSON);
        break;
      case ENTITY:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ExampleScenarioActorType.SYSTEM);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ExampleScenarioActorType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType> convertExampleScenarioActorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ExampleScenarioActorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PERSON:
        tgt.setValue(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType.PERSON);
        break;
      case SYSTEM:
        tgt.setValue(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType.ENTITY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasResourceId())
      tgt.setKeyElement(String40_50.convertString(src.getResourceIdElement()));
    if (src.hasResourceType())
      tgt.getStructureType().setCode(src.getResourceType().toCode());
    if (src.hasName())
      tgt.setTitleElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasKey())
      tgt.setResourceIdElement(String40_50.convertString(src.getKeyElement()));
    if (src.hasType())
      tgt.setResourceType(FHIRResourceType.fromCode(src.getStructureType().getCode()));
    if (src.hasTitle())
      tgt.setNameElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeType convertFHIRResourceType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType> src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CodeType tgt = new org.hl7.fhir.r5.model.CodeType(src.asStringValue());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType> convertFHIRResourceType(org.hl7.fhir.r5.model.CodeType src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType> tgt = new org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType>(new org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceTypeEnumFactory(), src.getCode());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasVersionId())
      tgt.setKeyElement(String40_50.convertString(src.getVersionIdElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasKey())
      tgt.setVersionIdElement(String40_50.convertString(src.getKeyElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasResourceId())
      tgt.setInstanceReferenceElement(String40_50.convertString(src.getResourceIdElement()));
    if (src.hasVersionId())
      tgt.setVersionReferenceElement(String40_50.convertString(src.getVersionIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasInstanceReference())
      tgt.setResourceIdElement(String40_50.convertString(src.getInstanceReferenceElement()));
    if (src.hasVersionReference())
      tgt.setVersionIdElement(String40_50.convertString(src.getVersionReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(MarkDown40_50.convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(MarkDown40_50.convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(MarkDown40_50.convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(MarkDown40_50.convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.setProcess(convertExampleScenarioProcessComponent(t));
    if (src.hasPause())
      tgt.setPauseElement(Boolean40_50.convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    tgt.addProcess(convertExampleScenarioProcessComponent(src.getProcess()));
    if (src.hasPause())
      tgt.setPauseElement(Boolean40_50.convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasNumber())
//      tgt.setNumberElement(String40_50.convertString(src.getNumberElement()));
    if (src.hasType())
      tgt.getType().setCode(src.getType());
    if (src.hasName())
      tgt.setTitleElement(String40_50.convertString(src.getNameElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(String40_50.convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(String40_50.convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(Boolean40_50.convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(Boolean40_50.convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasNumber())
//      tgt.setNumberElement(String40_50.convertString(src.getNumberElement()));
    if (src.hasType())
      tgt.setType(src.getType().getCode());
    if (src.hasTitle())
      tgt.setNameElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(String40_50.convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(String40_50.convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(Boolean40_50.convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(Boolean40_50.convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }
}