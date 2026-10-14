package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.*;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class ExampleScenario43_N {
  private static final String VERSION_ALGORITHM = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.versionAlgorithm";
  private static final String TITLE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.title";
  private static final String DESCRIPTION = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.description";
  private static final String COPYRIGHT_LABEL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.copyrightLabel";
  private static final String WORKFLOW = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ExampleScenario.workflow";
  private static final String INSTANCE_STRUCTURE_VERSION = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.structureVersion";
  private static final String INSTANCE_STRUCTURE_PROFILE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.structureProfile";
  private static final String INSTANCE_CONTENT = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.content";
  private static final String INSTANCE_VERSION_TITLE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.version.title";
  private static final String INSTANCE_VERSION_CONTENT = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.version.content";
  private static final String PROCESS_STEP_NUMBER = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.process.step.number";
  private static final String PROCESS_STEP_WORKFLOW = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.process.step.workflow";

  public static org.hl7.fhir.model.core.ExampleScenario convertExampleScenario(org.hl7.fhir.r4b.model.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario tgt = new org.hl7.fhir.model.core.ExampleScenario();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt, VERSION_ALGORITHM, TITLE, DESCRIPTION, COPYRIGHT_LABEL);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasExtension(VERSION_ALGORITHM)) {
      if (src.getExtensionByUrl(VERSION_ALGORITHM).getValue() instanceof org.hl7.fhir.r4b.model.StringType)
        tgt.setVersionAlgorithm(String43_N.convertString((org.hl7.fhir.r4b.model.StringType)src.getExtensionByUrl(VERSION_ALGORITHM).getValue()));
      else
        tgt.setVersionAlgorithm(Coding43_N.convertCoding((org.hl7.fhir.r4b.model.Coding)src.getExtensionByUrl(VERSION_ALGORITHM).getValue()));
    }
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasExtension(TITLE))
      tgt.setTitleElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType)src.getExtensionByUrl(TITLE).getValue()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasExtension(DESCRIPTION))
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown((org.hl7.fhir.r4b.model.MarkdownType)src.getExtensionByUrl(DESCRIPTION).getValue()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasExtension(COPYRIGHT_LABEL))
      tgt.setCopyrightLabelElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType)src.getExtensionByUrl(COPYRIGHT_LABEL).getValue()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getWorkflow())
      tgt.addExtension(WORKFLOW, Canonical43_N.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario convertExampleScenario(org.hl7.fhir.model.core.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario tgt = new org.hl7.fhir.r4b.model.ExampleScenario();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt, WORKFLOW);
    if (src.hasVersionAlgorithm()) {
      if (src.getVersionAlgorithm() instanceof org.hl7.fhir.model.core.StringType)
        tgt.addExtension(VERSION_ALGORITHM, String43_N.convertString((org.hl7.fhir.model.core.StringType)src.getVersionAlgorithm()));
      else
        tgt.addExtension(VERSION_ALGORITHM, Coding43_N.convertCoding((org.hl7.fhir.model.core.Coding)src.getVersionAlgorithm()));
    }
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.addExtension(TITLE, String43_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.addExtension(DESCRIPTION, MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCopyrightLabel())
      tgt.addExtension(COPYRIGHT_LABEL, String43_N.convertString(src.getCopyrightLabelElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent t : src.getActorList())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstanceList())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcessList())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    for (org.hl7.fhir.model.core.Extension e : src.getExtensionsByUrl(WORKFLOW))
      tgt.getWorkflow().add(Canonical43_N.convertCanonical(e.getValueCanonicalType()));

    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasActorId())
      tgt.setKeyElement(String43_N.convertString(src.getActorIdElement()));
    if (src.hasType())
      tgt.setTypeElement(convertExampleScenarioActorType(src.getTypeElement()));
    if (src.hasName())
      tgt.setTitleElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasKey())
      tgt.setActorIdElement(String43_N.convertString(src.getKeyElement()));
    if (src.hasType())
      tgt.setTypeElement(convertExampleScenarioActorType(src.getTypeElement()));
    if (src.hasTitle())
      tgt.setNameElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType> convertExampleScenarioActorType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActorDefinitionActorType> tgt = new Enumeration<>(new Enumerations.ActorDefinitionActorTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PERSON:
                  tgt.setValue(Enumerations.ActorDefinitionActorType.PERSON);
                  break;
              case ENTITY:
                  tgt.setValue(Enumerations.ActorDefinitionActorType.SYSTEM);
                  break;
              default:
                  tgt.setValue(Enumerations.ActorDefinitionActorType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType> convertExampleScenarioActorType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PERSON:
                  tgt.setValue(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType.PERSON);
                  break;
              case SYSTEM:
                  tgt.setValue(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType.ENTITY);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioActorType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, INSTANCE_STRUCTURE_VERSION, INSTANCE_STRUCTURE_PROFILE, INSTANCE_CONTENT);
    if (src.hasResourceId())
      tgt.setKeyElement(String43_N.convertString(src.getResourceIdElement()));
    if (src.hasResourceType()) {
      tgt.getStructureType().setCode(src.getResourceType());
      tgt.getStructureType().setSystem("http://hl7.org/fhir/fhir-types");
    }
    if (src.hasExtension(INSTANCE_STRUCTURE_VERSION))
      tgt.setStructureVersionElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType)src.getExtensionByUrl(INSTANCE_STRUCTURE_VERSION).getValue()));
    if (src.hasExtension(INSTANCE_STRUCTURE_PROFILE)) {
      if (src.getExtensionByUrl(INSTANCE_STRUCTURE_PROFILE).getValue() instanceof org.hl7.fhir.r4b.model.CanonicalType)
        tgt.setStructureProfile(Canonical43_N.convertCanonical((org.hl7.fhir.r4b.model.CanonicalType)src.getExtensionByUrl(INSTANCE_STRUCTURE_PROFILE).getValue()));
      else
        tgt.setStructureProfile(Uri43_N.convertUri((org.hl7.fhir.r4b.model.UriType)src.getExtensionByUrl(INSTANCE_STRUCTURE_PROFILE).getValue()));
    }
    if (src.hasName())
      tgt.setTitleElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasExtension(INSTANCE_CONTENT))
      tgt.setContent(Reference43_N.convertReference((org.hl7.fhir.r4b.model.Reference)src.getExtensionByUrl(INSTANCE_CONTENT).getValue()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasStructureVersion())
      tgt.addExtension(INSTANCE_STRUCTURE_VERSION, String43_N.convertString(src.getStructureVersionElement()));
    if (src.hasStructureProfile()) {
      if (src.getStructureProfile() instanceof org.hl7.fhir.model.core.CanonicalType)
        tgt.addExtension(INSTANCE_STRUCTURE_PROFILE, Canonical43_N.convertCanonical((org.hl7.fhir.model.core.CanonicalType)src.getStructureProfile()));
      else
        tgt.addExtension(INSTANCE_STRUCTURE_PROFILE, Uri43_N.convertUri((org.hl7.fhir.model.core.UriType)src.getStructureProfile()));
    }
    if (src.hasContent())
      tgt.addExtension(INSTANCE_CONTENT, Reference43_N.convertReference(src.getContent()));
    if (src.hasKey())
      tgt.setResourceIdElement(String43_N.convertString(src.getKeyElement()));
    if (src.hasStructureType())
      tgt.setResourceTypeElement(Code43_N.convertCode(src.getStructureType().getCodeElement()));
    if (src.hasTitle())
      tgt.setNameElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersionList())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstanceList())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, INSTANCE_VERSION_TITLE, INSTANCE_VERSION_CONTENT);
    if (src.hasVersionId())
      tgt.setKeyElement(String43_N.convertString(src.getVersionIdElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasExtension(INSTANCE_VERSION_TITLE))
      tgt.setTitleElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType) src.getExtensionByUrl(INSTANCE_VERSION_TITLE).getValue()));
    if (src.hasExtension(INSTANCE_VERSION_CONTENT))
      tgt.setContent(Reference43_N.convertReference((org.hl7.fhir.r4b.model.Reference) src.getExtensionByUrl(INSTANCE_VERSION_CONTENT).getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasKey())
      tgt.setVersionIdElement(String43_N.convertString(src.getKeyElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasTitle())
      tgt.addExtension(INSTANCE_VERSION_TITLE, String43_N.convertString(src.getTitleElement()));
    if (src.hasContent())
      tgt.addExtension(INSTANCE_VERSION_CONTENT, Reference43_N.convertReference(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasResourceId())
      tgt.setInstanceReferenceElement(String43_N.convertString(src.getResourceIdElement()));
    if (src.hasVersionId())
      tgt.setVersionReferenceElement(String43_N.convertString(src.getVersionIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasInstanceReference())
      tgt.setResourceIdElement(String43_N.convertString(src.getInstanceReferenceElement()));
    if (src.hasVersionReference())
      tgt.setVersionIdElement(String43_N.convertString(src.getVersionReferenceElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(MarkDown43_N.convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(MarkDown43_N.convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(MarkDown43_N.convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(MarkDown43_N.convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStepList())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt, PROCESS_STEP_NUMBER, PROCESS_STEP_WORKFLOW);
    if (src.hasOperation())
      tgt.setNumberElement(String43_N.convertString(src.getOperation().getNumberElement()));
    else if (src.hasExtension(PROCESS_STEP_NUMBER))
      tgt.setNumberElement(String43_N.convertString((org.hl7.fhir.r4b.model.StringType)src.getExtensionByUrl(PROCESS_STEP_NUMBER).getValue()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.setProcess(convertExampleScenarioProcessComponent(t));
    if (src.hasExtension(PROCESS_STEP_WORKFLOW))
      tgt.setWorkflowElement(Canonical43_N.convertCanonical((org.hl7.fhir.r4b.model.CanonicalType)src.getExtensionByUrl(PROCESS_STEP_WORKFLOW).getValue()));

    if (src.hasPause())
      tgt.setPauseElement(Boolean43_N.convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);

    if (src.hasProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(src.getProcess()));
    if (src.hasWorkflow())
      tgt.addExtension(PROCESS_STEP_WORKFLOW, Canonical43_N.convertCanonical(src.getWorkflowElement()));
    if (src.hasPause())
      tgt.setPauseElement(Boolean43_N.convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation(), src.getNumber()));
    else if (src.hasNumber()) {
      tgt.addExtension(PROCESS_STEP_NUMBER, String43_N.convertString(src.getNumberElement()));
    }
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternativeList())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasNumber())
//      tgt.setNumberElement(String43_N.convertString(src.getNumberElement()));
    if (src.hasType()) {
      tgt.getType().setSystem("http://hl7.org/fhir/restful-interaction");
      tgt.getType().setCode(src.getType());
    }
    if (src.hasName())
      tgt.setTitleElement(String43_N.convertString(src.getNameElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(String43_N.convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(String43_N.convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(Boolean43_N.convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(Boolean43_N.convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepOperationComponent src, String stepPosition) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasExtension("http://hl7.org/fhir/4.0/StructureDefinition/extension-ExampleScenario.process.step.operation.number"))
      tgt.setNumber(src.getExtensionByUrl("http://hl7.org/fhir/4.0/StructureDefinition/extension-ExampleScenario.process.step.operation.number").getValueStringType().toString());
    else
      tgt.setNumber(stepPosition);
    if (src.hasType())
      tgt.setType(src.getType().getCode());
    if (src.hasTitle())
      tgt.setNameElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(String43_N.convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(String43_N.convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(Boolean43_N.convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(Boolean43_N.convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r4b.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStepList())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    return tgt;
  }
}