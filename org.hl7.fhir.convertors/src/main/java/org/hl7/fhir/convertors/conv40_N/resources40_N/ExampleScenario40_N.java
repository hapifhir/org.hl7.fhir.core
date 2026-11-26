package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.*;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ExampleScenario;
import org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType;
import org.hl7.fhir.r4.model.StringType;
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

public class ExampleScenario40_N {
  private static final String VERSION_ALGORITHM = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.versionAlgorithm";
  private static final String TITLE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.title";
  private static final String DESCRIPTION = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.description";
  private static final String COPYRIGHT_LABEL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.copyrightLabel";
  private static final String WORKFLOW = "http://hl7.org/fhir/4.0/StructureDefinition/extension-ExampleScenario.workflow";
  private static final String INSTANCE_STRUCTURE_VERSION = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.structureVersion";
  private static final String INSTANCE_STRUCTURE_PROFILE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.structureProfile";
  private static final String INSTANCE_CONTENT = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.content";
  private static final String INSTANCE_STRUCTURE_TYPE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.structureType";
  private static final String INSTANCE_VERSION_TITLE = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.version.title";
  private static final String INSTANCE_VERSION_CONTENT = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.instance.version.content";
  private static final String PROCESS_STEP_NUMBER = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.process.step.number";
  private static final String PROCESS_STEP_WORKFLOW = "http://hl7.org/fhir/5.0/StructureDefinition/extension-ExampleScenario.process.step.workflow";

  public static org.hl7.fhir.model.core.ExampleScenario convertExampleScenario(org.hl7.fhir.r4.model.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario tgt = new org.hl7.fhir.model.core.ExampleScenario();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, VERSION_ALGORITHM, TITLE, DESCRIPTION, COPYRIGHT_LABEL);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasExtension(VERSION_ALGORITHM)) {
      if (src.getExtensionByUrl(VERSION_ALGORITHM).getValue() instanceof org.hl7.fhir.r4.model.StringType)
        tgt.setVersionAlgorithm(String40_N.convertString((org.hl7.fhir.r4.model.StringType)src.getExtensionByUrl(VERSION_ALGORITHM).getValue()));
      else
        tgt.setVersionAlgorithm(Coding40_N.convertCoding((org.hl7.fhir.r4.model.Coding)src.getExtensionByUrl(VERSION_ALGORITHM).getValue()));
    }
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasExtension(TITLE))
      tgt.setTitleElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType)src.getExtensionByUrl(TITLE).getValue()));
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
    if (src.hasExtension(DESCRIPTION))
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType)src.getExtensionByUrl(DESCRIPTION).getValue()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasExtension(COPYRIGHT_LABEL))
      tgt.setCopyrightLabelElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType)src.getExtensionByUrl(COPYRIGHT_LABEL).getValue()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent t : src.getActor())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstance())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getWorkflow())
      tgt.addExtension(WORKFLOW, Canonical40_N.convertCanonical(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario convertExampleScenario(org.hl7.fhir.model.core.ExampleScenario src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario tgt = new org.hl7.fhir.r4.model.ExampleScenario();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, WORKFLOW);
    if (src.hasVersionAlgorithm()) {
      if (src.getVersionAlgorithm() instanceof org.hl7.fhir.model.core.StringType)
        tgt.addExtension(VERSION_ALGORITHM, String40_N.convertString((org.hl7.fhir.model.core.StringType)src.getVersionAlgorithm()));
      else
        tgt.addExtension(VERSION_ALGORITHM, Coding40_N.convertCoding((org.hl7.fhir.model.core.Coding)src.getVersionAlgorithm()));
    }
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.addExtension(TITLE, String40_N.convertString(src.getTitleElement()));
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
      tgt.addExtension(DESCRIPTION, MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCopyrightLabel())
      tgt.addExtension(COPYRIGHT_LABEL, String40_N.convertString(src.getCopyrightLabelElement()));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent t : src.getActorList())
      tgt.addActor(convertExampleScenarioActorComponent(t));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent t : src.getInstanceList())
      tgt.addInstance(convertExampleScenarioInstanceComponent(t));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcessList())
      tgt.addProcess(convertExampleScenarioProcessComponent(t));
    for (org.hl7.fhir.model.core.Extension e : src.getExtensionsByUrl(WORKFLOW))
      tgt.getWorkflow().add(Canonical40_N.convertCanonical(e.getValueCanonicalType()));

    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasActorId())
      tgt.setKeyElement(String40_N.convertString(src.getActorIdElement()));
    if (src.hasType())
      tgt.setTypeElement(CrossVersionElements40_N.toR6Code(src.getTypeElement(), convertExampleScenarioActorType(src.getTypeElement()), src.fhirType(), "type"));
    if (src.hasName())
      tgt.setTitleElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent convertExampleScenarioActorComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasKey())
      tgt.setActorIdElement(String40_N.convertString(src.getKeyElement()));
    if (src.hasType())
      tgt.setTypeElement(CrossVersionElements40_N.toR4Code(src.getTypeElement(), convertExampleScenarioActorType(src.getTypeElement()), src.fhirType(), "type"));
    if (src.hasTitle())
      tgt.setNameElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  // R6 actor types that R4 doesn't have (collective, other)
  public static final String ACTOR_TYPE_EXTENSION_URL = "http://hl7.org/fhir/6.0/StructureDefinition/extension-ExampleScenario.actor.type";

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType> convertExampleScenarioActorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActorDefinitionActorType> tgt = new Enumeration<>(new Enumerations.ActorDefinitionActorTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, ACTOR_TYPE_EXTENSION_URL);
      if (src.hasExtension(ACTOR_TYPE_EXTENSION_URL)) {
          tgt.setValueAsString(src.getExtensionByUrl(ACTOR_TYPE_EXTENSION_URL).getValue().primitiveValue());
      } else if (src.getValue() == null) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioActorType> convertExampleScenarioActorType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActorDefinitionActorType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ExampleScenario.ExampleScenarioActorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ExampleScenario.ExampleScenarioActorTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PERSON:
                  tgt.setValue(ExampleScenario.ExampleScenarioActorType.PERSON);
                  break;
              case SYSTEM:
                  tgt.setValue(ExampleScenario.ExampleScenarioActorType.ENTITY);
                  break;
              case COLLECTIVE:
              case OTHER:
                  // R4 has person and entity: anything that isn't a person is an entity, and the R6 code is kept
                  tgt.setValue(ExampleScenario.ExampleScenarioActorType.ENTITY);
                  tgt.addExtension(ACTOR_TYPE_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getValueAsString()));
                  break;
              default:
                  tgt.setValue(ExampleScenario.ExampleScenarioActorType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, INSTANCE_STRUCTURE_VERSION, INSTANCE_STRUCTURE_PROFILE, INSTANCE_CONTENT, INSTANCE_STRUCTURE_TYPE);
    if (src.hasResourceId())
      tgt.setKeyElement(String40_N.convertString(src.getResourceIdElement()));
    if (src.hasExtension(INSTANCE_STRUCTURE_TYPE))
      tgt.setStructureType(Coding40_N.convertCoding((org.hl7.fhir.r4.model.Coding) src.getExtensionByUrl(INSTANCE_STRUCTURE_TYPE).getValue()));
    else if (src.hasResourceType()) {
      tgt.getStructureType().setCode(src.getResourceType().toCode());
      tgt.getStructureType().setSystem("http://hl7.org/fhir/fhir-types");
    }
    if (src.hasExtension(INSTANCE_STRUCTURE_VERSION))
      tgt.setStructureVersionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType)src.getExtensionByUrl(INSTANCE_STRUCTURE_VERSION).getValue()));
    if (src.hasExtension(INSTANCE_STRUCTURE_PROFILE)) {
      if (src.getExtensionByUrl(INSTANCE_STRUCTURE_PROFILE).getValue() instanceof org.hl7.fhir.r4.model.CanonicalType)
        tgt.setStructureProfile(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType)src.getExtensionByUrl(INSTANCE_STRUCTURE_PROFILE).getValue()));
      else
        tgt.setStructureProfile(Uri40_N.convertUri((org.hl7.fhir.r4.model.UriType)src.getExtensionByUrl(INSTANCE_STRUCTURE_PROFILE).getValue()));
    }
    if (src.hasName())
      tgt.setTitleElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasExtension(INSTANCE_CONTENT))
      tgt.setContent(Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference)src.getExtensionByUrl(INSTANCE_CONTENT).getValue()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersion())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstance())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent convertExampleScenarioInstanceComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasStructureVersion())
      tgt.addExtension(INSTANCE_STRUCTURE_VERSION, String40_N.convertString(src.getStructureVersionElement()));
    if (src.hasStructureProfile()) {
      if (src.getStructureProfile() instanceof org.hl7.fhir.model.core.CanonicalType)
        tgt.addExtension(INSTANCE_STRUCTURE_PROFILE, Canonical40_N.convertCanonical((org.hl7.fhir.model.core.CanonicalType)src.getStructureProfile()));
      else
        tgt.addExtension(INSTANCE_STRUCTURE_PROFILE, Uri40_N.convertUri((org.hl7.fhir.model.core.UriType)src.getStructureProfile()));
    }
    if (src.hasContent())
      tgt.addExtension(INSTANCE_CONTENT, Reference40_N.convertReference(src.getContent()));
    if (src.hasKey())
      tgt.setResourceIdElement(String40_N.convertString(src.getKeyElement()));
    if (src.hasStructureType()) {
      // R4 only has the FHIR resource type code; any other structure type, or more than the code, goes in a 5.0 extension
      org.hl7.fhir.model.core.Coding st = src.getStructureType();
      FHIRResourceType rt = null;
      if ("http://hl7.org/fhir/fhir-types".equals(st.getSystem()) && st.hasCode()) {
        try {
          rt = FHIRResourceType.fromCode(st.getCode());
        } catch (FHIRException e) {
          rt = null;
        }
      }
      if (rt != null)
        tgt.setResourceType(rt);
      if (rt == null || st.hasDisplay() || st.hasVersion() || st.hasUserSelected() || st.hasId() || st.hasExtension())
        tgt.addExtension(INSTANCE_STRUCTURE_TYPE, Coding40_N.convertCoding(st));
    }
    if (src.hasTitle())
      tgt.setNameElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent t : src.getVersionList())
      tgt.addVersion(convertExampleScenarioInstanceVersionComponent(t));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent t : src.getContainedInstanceList())
      tgt.addContainedInstance(convertExampleScenarioInstanceContainedInstanceComponent(t));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.core.CodeType convertFHIRResourceType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType> src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CodeType tgt = new org.hl7.fhir.model.core.CodeType(src.asStringValue());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType> convertFHIRResourceType(org.hl7.fhir.model.core.CodeType src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType> tgt = new org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceType>(new org.hl7.fhir.r4.model.ExampleScenario.FHIRResourceTypeEnumFactory(), src.getCode());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, INSTANCE_VERSION_TITLE, INSTANCE_VERSION_CONTENT);
    if (src.hasVersionId())
      tgt.setKeyElement(String40_N.convertString(src.getVersionIdElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasExtension(INSTANCE_VERSION_TITLE))
      tgt.setTitleElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(INSTANCE_VERSION_TITLE).getValue()));
    if (src.hasExtension(INSTANCE_VERSION_CONTENT))
      tgt.setContent(Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference) src.getExtensionByUrl(INSTANCE_VERSION_CONTENT).getValue()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent convertExampleScenarioInstanceVersionComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceVersionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceVersionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasKey())
      tgt.setVersionIdElement(String40_N.convertString(src.getKeyElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasTitle())
      tgt.addExtension(INSTANCE_VERSION_TITLE, String40_N.convertString(src.getTitleElement()));
    if (src.hasContent())
      tgt.addExtension(INSTANCE_VERSION_CONTENT, Reference40_N.convertReference(src.getContent()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasResourceId())
      tgt.setInstanceReferenceElement(String40_N.convertString(src.getResourceIdElement()));
    if (src.hasVersionId())
      tgt.setVersionReferenceElement(String40_N.convertString(src.getVersionIdElement()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent convertExampleScenarioInstanceContainedInstanceComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioInstanceContainedInstanceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasInstanceReference())
      tgt.setResourceIdElement(String40_N.convertString(src.getInstanceReferenceElement()));
    if (src.hasVersionReference())
      tgt.setVersionIdElement(String40_N.convertString(src.getVersionReferenceElement()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(MarkDown40_N.convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(MarkDown40_N.convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent convertExampleScenarioProcessComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasPreConditions())
      tgt.setPreConditionsElement(MarkDown40_N.convertMarkdown(src.getPreConditionsElement()));
    if (src.hasPostConditions())
      tgt.setPostConditionsElement(MarkDown40_N.convertMarkdown(src.getPostConditionsElement()));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStepList())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, PROCESS_STEP_NUMBER, PROCESS_STEP_WORKFLOW);
    if (src.hasOperation())
      tgt.setNumberElement(String40_N.convertString(src.getOperation().getNumberElement()));
    else if (src.hasExtension(PROCESS_STEP_NUMBER))
      tgt.setNumberElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType)src.getExtensionByUrl(PROCESS_STEP_NUMBER).getValue()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessComponent t : src.getProcess())
      tgt.setProcess(convertExampleScenarioProcessComponent(t));
    if (src.hasExtension(PROCESS_STEP_WORKFLOW))
      tgt.setWorkflowElement(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType)src.getExtensionByUrl(PROCESS_STEP_WORKFLOW).getValue()));

    if (src.hasPause())
      tgt.setPauseElement(Boolean40_N.convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternative())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent convertExampleScenarioProcessStepComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);

    if (src.hasProcess())
      tgt.addProcess(convertExampleScenarioProcessComponent(src.getProcess()));
    if (src.hasWorkflow())
      tgt.addExtension(PROCESS_STEP_WORKFLOW, Canonical40_N.convertCanonical(src.getWorkflowElement()));
    if (src.hasPause())
      tgt.setPauseElement(Boolean40_N.convertBoolean(src.getPauseElement()));
    if (src.hasOperation())
      tgt.setOperation(convertExampleScenarioProcessStepOperationComponent(src.getOperation(), src.getNumber()));
    else if (src.hasNumber()) {
      tgt.addExtension(PROCESS_STEP_NUMBER, String40_N.convertString(src.getNumberElement()));
    }
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent t : src.getAlternativeList())
      tgt.addAlternative(convertExampleScenarioProcessStepAlternativeComponent(t));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasNumber())
//      tgt.setNumberElement(String40_N.convertString(src.getNumberElement()));
    // the whole Coding, if R4 couldn't carry it (see below)
    String typeUrl = CrossVersionElements40_N.url("ExampleScenario.process.step.operation", "5.0", "type");
    if (src.getTypeElement().hasExtension(typeUrl))
      tgt.setType(Coding40_N.convertCoding((org.hl7.fhir.r4.model.Coding) src.getTypeElement().getExtensionByUrl(typeUrl).getValue()));
    else if (src.hasType()) {
      tgt.getType().setSystem("http://hl7.org/fhir/restful-interaction");
      tgt.getType().setCode(src.getType());
    }
    if (src.hasName())
      tgt.setTitleElement(String40_N.convertString(src.getNameElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(String40_N.convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(String40_N.convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(Boolean40_N.convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(Boolean40_N.convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent convertExampleScenarioProcessStepOperationComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepOperationComponent src, String stepPosition) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasExtension("http://hl7.org/fhir/4.0/StructureDefinition/extension-ExampleScenario.process.step.operation.number"))
      tgt.setNumber(src.getExtensionByUrl("http://hl7.org/fhir/4.0/StructureDefinition/extension-ExampleScenario.process.step.operation.number").getValueStringType().toString());
    else
      tgt.setNumber(stepPosition);
    if (src.hasType()) {
      tgt.setType(src.getType().getCode());
      // R4 has just the code (of a restful interaction): anything else, the Coding is a 5.0 extension on it
      org.hl7.fhir.model.core.Coding c = src.getType();
      if (!"http://hl7.org/fhir/restful-interaction".equals(c.getSystem()) || c.hasDisplay() || c.hasVersion() || c.hasUserSelected() || c.hasId() || c.hasExtension())
        tgt.getTypeElement().addExtension(CrossVersionElements40_N.url("ExampleScenario.process.step.operation", "5.0", "type"), Coding40_N.convertCoding(c));
    }
    if (src.hasTitle())
      tgt.setNameElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasInitiator())
      tgt.setInitiatorElement(String40_N.convertString(src.getInitiatorElement()));
    if (src.hasReceiver())
      tgt.setReceiverElement(String40_N.convertString(src.getReceiverElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    if (src.hasInitiatorActive())
      tgt.setInitiatorActiveElement(Boolean40_N.convertBoolean(src.getInitiatorActiveElement()));
    if (src.hasReceiverActive())
      tgt.setReceiverActiveElement(Boolean40_N.convertBoolean(src.getReceiverActiveElement()));
    if (src.hasRequest())
      tgt.setRequest(convertExampleScenarioInstanceContainedInstanceComponent(src.getRequest()));
    if (src.hasResponse())
      tgt.setResponse(convertExampleScenarioInstanceContainedInstanceComponent(src.getResponse()));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStep())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    CrossVersionElements40_N.newElementsToR6(src.getExtension(), tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent convertExampleScenarioProcessStepAlternativeComponent(org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent tgt = new org.hl7.fhir.r4.model.ExampleScenario.ExampleScenarioProcessStepAlternativeComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.ExampleScenario.ExampleScenarioProcessStepComponent t : src.getStepList())
      tgt.addStep(convertExampleScenarioProcessStepComponent(t));
    CrossVersionElements40_N.newElementsToR4(src, tgt, tgt.getExtension());
    return tgt;
  }
}