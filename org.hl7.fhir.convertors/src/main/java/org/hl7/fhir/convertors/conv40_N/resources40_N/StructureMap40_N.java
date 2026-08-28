package org.hl7.fhir.convertors.conv40_N.resources40_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.utilities.FHIRPathConstant;
import org.hl7.fhir.r4.utils.ToolingExtensions;
import org.hl7.fhir.utilities.Utilities;

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
public class StructureMap40_N {

  public static org.hl7.fhir.model.fml.StructureMap convertStructureMap(org.hl7.fhir.r4.model.StructureMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap tgt = new org.hl7.fhir.model.fml.StructureMap();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
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
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent t : src.getStructure())
      tgt.addStructure(convertStructureMapStructureComponent(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getImport())
      tgt.getImportList().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertStructureMapGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap convertStructureMap(org.hl7.fhir.model.fml.StructureMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap tgt = new org.hl7.fhir.r4.model.StructureMap();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
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
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent t : src.getStructureList())
      tgt.addStructure(convertStructureMapStructureComponent(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getImportList())
      tgt.getImport().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent t : src.getGroupList())
      tgt.addGroup(convertStructureMapGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Canonical40_N.convertCanonical(src.getUrlElement()));
    if (src.hasMode())
      tgt.setModeElement(convertStructureMapModelMode(src.getModeElement()));
    if (src.hasAlias())
      tgt.setAliasElement(String40_N.convertString(src.getAliasElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapStructureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Canonical40_N.convertCanonical(src.getUrlElement()));
    if (src.hasMode())
      tgt.setModeElement(convertStructureMapModelMode(src.getModeElement()));
    if (src.hasAlias())
      tgt.setAliasElement(String40_N.convertString(src.getAliasElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode> convertStructureMapModelMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapModelModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case SOURCE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode.SOURCE);
          break;
        case QUERIED:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode.QUERIED);
          break;
        case TARGET:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode.TARGET);
          break;
        case PRODUCED:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode.PRODUCED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode> convertStructureMapModelMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapModelModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case SOURCE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.SOURCE);
          break;
        case QUERIED:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.QUERIED);
          break;
        case TARGET:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.TARGET);
          break;
        case PRODUCED:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.PRODUCED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapModelMode.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id40_N.convertIdToString(src.getNameElement()));
    if (src.hasExtends())
      tgt.setExtendsElement(Id40_N.convertId(src.getExtendsElement()));
    if (src.hasTypeMode())
      tgt.setTypeModeElement(convertStructureMapGroupTypeMode(src.getTypeModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent t : src.getInput())
      tgt.addInput(convertStructureMapGroupInputComponent(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id40_N.convertId(src.getNameElement()));
    if (src.hasExtends())
      tgt.setExtendsElement(Id40_N.convertId(src.getExtendsElement()));
    if (src.hasTypeMode()) {
      tgt.setTypeModeElement(convertStructureMapGroupTypeMode(src.getTypeModeElement()));
    } else {
      tgt.setTypeMode(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NULL);
    }
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent t : src.getInputList())
      tgt.addInput(convertStructureMapGroupInputComponent(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent t : src.getRuleList())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeMode> convertStructureMapGroupTypeMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case NONE:
          return null;
        case TYPES:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeMode.TYPES);
          break;
        case TYPEANDTYPES:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeMode.TYPEANDTYPES);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeMode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode> convertStructureMapGroupTypeMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeMode> src) throws FHIRException {
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeModeEnumFactory());
    if (src == null || src.isEmpty()) {
      tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NULL);
      return tgt;
    }
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case TYPES:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.TYPES);
          break;
        case TYPEANDTYPES:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.TYPEANDTYPES);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupTypeMode.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id40_N.convertId(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(String40_N.convertString(src.getTypeElement()));
    if (src.hasMode())
      tgt.setModeElement(convertStructureMapInputMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupInputComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id40_N.convertId(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(String40_N.convertString(src.getTypeElement()));
    if (src.hasMode())
      tgt.setModeElement(convertStructureMapInputMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapInputMode> convertStructureMapInputMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapInputMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapInputModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case SOURCE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapInputMode.SOURCE);
          break;
        case TARGET:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapInputMode.TARGET);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapInputMode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode> convertStructureMapInputMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapInputMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapInputModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case SOURCE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.SOURCE);
          break;
        case TARGET:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.TARGET);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapInputMode.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id40_N.convertId(src.getNameElement()));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource())
      tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget())
      tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent())
      tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id40_N.convertId(src.getNameElement()));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSourceList())
      tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTargetList())
      tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent t : src.getRuleList())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependentList())
      tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(Id40_N.convertId(src.getContextElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer40_N.convertIntegerToUnsigned(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    if (src.hasType())
      tgt.setTypeElement(String40_N.convertString(src.getTypeElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement((org.hl7.fhir.model.core.StringType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDefaultValue()));
    if (src.hasElement())
      tgt.getElementList().add(String40_N.convertString(src.getElementElement()));
    if (src.hasListMode())
      tgt.setListModeElement(convertStructureMapSourceListMode(src.getListModeElement()));
    if (src.hasVariable())
      tgt.setVariableElement(Id40_N.convertId(src.getVariableElement()));
    if (src.hasCondition())
      tgt.setConditionElement(String40_N.convertString(src.getConditionElement()));
    if (src.hasCheck())
      tgt.setCheckElement(String40_N.convertString(src.getCheckElement()));
    if (src.hasLogMessage())
      tgt.setLogMessageElement(String40_N.convertString(src.getLogMessageElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleSourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(Id40_N.convertId(src.getContextElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer40_N.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    if (src.hasType())
      tgt.setTypeElement(String40_N.convertString(src.getTypeElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDefaultValueElement()));
    if (src.hasElement())
      tgt.setElementElement(String40_N.convertString(src.getElementElement()));
    if (src.hasListMode())
      tgt.setListModeElement(convertStructureMapSourceListMode(src.getListModeElement()));
    if (src.hasVariable())
      tgt.setVariableElement(Id40_N.convertId(src.getVariableElement()));
    if (src.hasCondition())
      tgt.setConditionElement(String40_N.convertString(src.getConditionElement()));
    if (src.hasCheck())
      tgt.setCheckElement(String40_N.convertString(src.getCheckElement()));
    if (src.hasLogMessage())
      tgt.setLogMessageElement(String40_N.convertString(src.getLogMessageElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode> convertStructureMapSourceListMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case FIRST:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode.FIRST);
          break;
        case NOTFIRST:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode.NOTFIRST);
          break;
        case LAST:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode.LAST);
          break;
        case NOTLAST:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode.NOTLAST);
          break;
        case ONLYONE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode.ONLYONE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode> convertStructureMapSourceListMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case FIRST:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.FIRST);
          break;
        case NOTFIRST:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NOTFIRST);
          break;
        case LAST:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.LAST);
          break;
        case NOTLAST:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NOTLAST);
          break;
        case ONLYONE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.ONLYONE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapSourceListMode.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(Id40_N.convertIdToString(src.getContextElement()));
    if (src.hasContextType() && src.getContextType() != org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.VARIABLE)
      throw new Error("This conversion is not supported. Consult code maintainers"); // this should never happens - no one knows what the intent was here.
    if (src.hasElement())
      tgt.getElementList().add(String40_N.convertString(src.getElementElement()));
    if (src.hasVariable())
      tgt.setVariableElement(Id40_N.convertId(src.getVariableElement()));
    tgt.setListModeList(src.getListMode().stream()
      .map(StructureMap40_N::convertStructureMapTargetListMode)
      .collect(Collectors.toList()));
    if (src.hasListRuleId())
      tgt.setListRuleIdElement(Id40_N.convertId(src.getListRuleIdElement()));
    if (src.hasTransform())
      tgt.setTransformElement(convertStructureMapTransform(src.getTransformElement()));
    for (org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter())
      tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(Id40_N.convertId(src.getContextElement()));
    tgt.setContextType(org.hl7.fhir.r4.model.StructureMap.StructureMapContextType.VARIABLE);
    if (src.hasElement())
      tgt.setElementElement(String40_N.convertString(src.getElementElement()));
    if (src.hasVariable())
      tgt.setVariableElement(Id40_N.convertId(src.getVariableElement()));
    tgt.setListMode(src.getListModeList().stream()
      .map(StructureMap40_N::convertStructureMapTargetListMode)
      .collect(Collectors.toList()));
    if (src.hasListRuleId())
      tgt.setListRuleIdElement(Id40_N.convertId(src.getListRuleIdElement()));
    if (src.hasTransform())
      tgt.setTransformElement(convertStructureMapTransform(src.getTransformElement()));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameterList())
      tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode> convertStructureMapTargetListMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case FIRST:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode.FIRST);
          break;
        case SHARE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode.SHARE);
          break;
        case LAST:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode.LAST);
          break;
        case COLLATE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode.SINGLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode> convertStructureMapTargetListMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case FIRST:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.FIRST);
          break;
        case SHARE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.SHARE);
          break;
        case LAST:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.LAST);
          break;
        case SINGLE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.COLLATE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTargetListMode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTransform> convertStructureMapTransform(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTransform> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTransform> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapTransformEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case CREATE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.CREATE);
          break;
        case COPY:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.COPY);
          break;
        case TRUNCATE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.TRUNCATE);
          break;
        case ESCAPE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.ESCAPE);
          break;
        case CAST:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.CAST);
          break;
        case APPEND:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.APPEND);
          break;
        case TRANSLATE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.TRANSLATE);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.REFERENCE);
          break;
        case DATEOP:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.DATEOP);
          break;
        case UUID:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.UUID);
          break;
        case POINTER:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.POINTER);
          break;
        case EVALUATE:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.EVALUATE);
          break;
        case CC:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.CC);
          break;
        case C:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.C);
          break;
        case QTY:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.QTY);
          break;
        case ID:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.ID);
          break;
        case CP:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.CP);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.fml.StructureMap.StructureMapTransform.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTransform> convertStructureMapTransform(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTransform> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.StructureMap.StructureMapTransform> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.StructureMap.StructureMapTransformEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case CREATE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CREATE);
          break;
        case COPY:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.COPY);
          break;
        case TRUNCATE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.TRUNCATE);
          break;
        case ESCAPE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.ESCAPE);
          break;
        case CAST:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CAST);
          break;
        case APPEND:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.APPEND);
          break;
        case TRANSLATE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.TRANSLATE);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.REFERENCE);
          break;
        case DATEOP:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.DATEOP);
          break;
        case UUID:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.UUID);
          break;
        case POINTER:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.POINTER);
          break;
        case EVALUATE:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.EVALUATE);
          break;
        case CC:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CC);
          break;
        case C:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.C);
          break;
        case QTY:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.QTY);
          break;
        case ID:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.ID);
          break;
        case CP:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.CP);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.StructureMap.StructureMapTransform.NULL);
          break;
      }
    }
    return tgt;
  }

  //DIRTY
  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }


  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  //DIRTY
  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id40_N.convertId(src.getNameElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getVariable()) tgt.addParameter().setValue(convertVariableStringToParameterDataType(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DataType convertVariableStringToParameterDataType(org.hl7.fhir.r4.model.StringType src) {
    if (src.hasExtension(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE)) {
      return ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE).getValue());
    } else {
      org.hl7.fhir.model.core.IdType tgt = new org.hl7.fhir.model.core.IdType();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.hasValue()) {
        tgt.setValueAsString(src.getValueAsString());
      }
      return tgt;
    }
  }

  public static org.hl7.fhir.model.core.DataType convertVariableStringToGuessedParameterDataType(org.hl7.fhir.r4.model.StringType it) {
    final String stringValue = it.asStringValue();
    if (!org.hl7.fhir.model.utilities.FHIRPathConstant.isFHIRPathConstant(stringValue)) {
      return new org.hl7.fhir.model.core.IdType(stringValue);
    } else if (FHIRPathConstant.isFHIRPathStringConstant(stringValue))
      return new org.hl7.fhir.model.core.StringType(stringValue);
    else {
      return convertVariableStringToGuessedParameterConstantType(stringValue);
    }
  }

  public static org.hl7.fhir.model.core.DataType convertVariableStringToGuessedParameterConstantType(String stringValue) {
    if (Utilities.isInteger(stringValue))
      return new org.hl7.fhir.model.core.IntegerType(stringValue);
    else if (Utilities.isDecimal(stringValue, false))
      return new org.hl7.fhir.model.core.DecimalType(stringValue);
    else if (Utilities.existsInList(stringValue, "true", "false"))
      return new org.hl7.fhir.model.core.BooleanType(stringValue.equals("true"));
    else
      return new org.hl7.fhir.model.core.StringType(stringValue);
  }

  //DIRTY
  public static org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.r4.model.StructureMap.StructureMapGroupRuleDependentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id40_N.convertId(src.getNameElement()));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameterList()) {
      tgt.getVariable().add(convertStructureMapGroupRuleTargetParameterComponentToString(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.StringType convertStructureMapGroupRuleTargetParameterComponentToString(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent src) {
    org.hl7.fhir.r4.model.StringType tgt = new org.hl7.fhir.r4.model.StringType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasValueIdType()) {
      tgt.setValueAsString(src.getValueIdType().getValueAsString());
    } else if (src.hasValue()) {
      tgt.addExtension(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE,ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    }
    return tgt;
  }
}