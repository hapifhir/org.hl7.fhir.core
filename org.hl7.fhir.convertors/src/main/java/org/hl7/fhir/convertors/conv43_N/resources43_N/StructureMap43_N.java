package org.hl7.fhir.convertors.conv43_N.resources43_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.utilities.FHIRPathConstant;
import org.hl7.fhir.r4b.utils.ToolingExtensions;
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
public class StructureMap43_N {

  public static org.hl7.fhir.model.fml.StructureMap convertStructureMap(org.hl7.fhir.r4b.model.StructureMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap tgt = new org.hl7.fhir.model.fml.StructureMap();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
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
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.r4b.model.StructureMap.StructureMapStructureComponent t : src.getStructure())
      tgt.addStructure(convertStructureMapStructureComponent(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getImport())
      tgt.getImportList().add(Canonical43_N.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupComponent t : src.getGroup())
      tgt.addGroup(convertStructureMapGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureMap convertStructureMap(org.hl7.fhir.model.fml.StructureMap src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureMap tgt = new org.hl7.fhir.r4b.model.StructureMap();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
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
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent t : src.getStructureList())
      tgt.addStructure(convertStructureMapStructureComponent(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getImportList())
      tgt.getImport().add(Canonical43_N.convertCanonical(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent t : src.getGroupList())
      tgt.addGroup(convertStructureMapGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.r4b.model.StructureMap.StructureMapStructureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Canonical43_N.convertCanonical(src.getUrlElement()));
    if (src.hasMode())
      tgt.setModeElement(convertStructureMapModelMode(src.getModeElement()));
    if (src.hasAlias())
      tgt.setAliasElement(String43_N.convertString(src.getAliasElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureMap.StructureMapStructureComponent convertStructureMapStructureComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapStructureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureMap.StructureMapStructureComponent tgt = new org.hl7.fhir.r4b.model.StructureMap.StructureMapStructureComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Canonical43_N.convertCanonical(src.getUrlElement()));
    if (src.hasMode())
      tgt.setModeElement(convertStructureMapModelMode(src.getModeElement()));
    if (src.hasAlias())
      tgt.setAliasElement(String43_N.convertString(src.getAliasElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode> convertStructureMapModelMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapModelMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapModelModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapModelMode> convertStructureMapModelMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapModelMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapModelMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureMap.StructureMapModelModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case SOURCE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapModelMode.SOURCE);
          break;
        case QUERIED:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapModelMode.QUERIED);
          break;
        case TARGET:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapModelMode.TARGET);
          break;
        case PRODUCED:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapModelMode.PRODUCED);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapModelMode.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id43_N.convertIdToString(src.getNameElement()));
    if (src.hasExtends())
      tgt.setExtendsElement(Id43_N.convertId(src.getExtendsElement()));
    if (src.hasTypeMode())
      tgt.setTypeModeElement(convertStructureMapGroupTypeMode(src.getTypeModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    for (org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupInputComponent t : src.getInput())
      tgt.addInput(convertStructureMapGroupInputComponent(t));
    for (org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupComponent convertStructureMapGroupComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupComponent tgt = new org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id43_N.convertId(src.getNameElement()));
    if (src.hasExtends())
      tgt.setExtendsElement(Id43_N.convertId(src.getExtendsElement()));
    if (src.hasTypeMode()) {
      tgt.setTypeModeElement(convertStructureMapGroupTypeMode(src.getTypeModeElement()));
    } else {
      tgt.setTypeMode(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeMode.NULL);
    }
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent t : src.getInputList())
      tgt.addInput(convertStructureMapGroupInputComponent(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent t : src.getRuleList())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeMode> convertStructureMapGroupTypeMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeMode> convertStructureMapGroupTypeMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapGroupTypeMode> src) throws FHIRException {
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeModeEnumFactory());
    if (src == null || src.isEmpty()) {
      tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeMode.NULL);
      return tgt;
    }
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case TYPES:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeMode.TYPES);
          break;
        case TYPEANDTYPES:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeMode.TYPEANDTYPES);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupTypeMode.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id43_N.convertId(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(String43_N.convertString(src.getTypeElement()));
    if (src.hasMode())
      tgt.setModeElement(convertStructureMapInputMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupInputComponent convertStructureMapGroupInputComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupInputComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupInputComponent tgt = new org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupInputComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id43_N.convertId(src.getNameElement()));
    if (src.hasType())
      tgt.setTypeElement(String43_N.convertString(src.getTypeElement()));
    if (src.hasMode())
      tgt.setModeElement(convertStructureMapInputMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapInputMode> convertStructureMapInputMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapInputMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapInputMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapInputModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapInputMode> convertStructureMapInputMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapInputMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapInputMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureMap.StructureMapInputModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case SOURCE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapInputMode.SOURCE);
          break;
        case TARGET:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapInputMode.TARGET);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapInputMode.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id43_N.convertId(src.getNameElement()));
    for (org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSource())
      tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
    for (org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTarget())
      tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
    for (org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleComponent t : src.getRule())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    for (org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependent())
      tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleComponent convertStructureMapGroupRuleComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleComponent tgt = new org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id43_N.convertId(src.getNameElement()));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent t : src.getSourceList())
      tgt.addSource(convertStructureMapGroupRuleSourceComponent(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent t : src.getTargetList())
      tgt.addTarget(convertStructureMapGroupRuleTargetComponent(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleComponent t : src.getRuleList())
      tgt.addRule(convertStructureMapGroupRuleComponent(t));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent t : src.getDependentList())
      tgt.addDependent(convertStructureMapGroupRuleDependentComponent(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(Id43_N.convertId(src.getContextElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer43_N.convertIntegerToUnsigned(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    if (src.hasType())
      tgt.setTypeElement(String43_N.convertString(src.getTypeElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement((org.hl7.fhir.model.core.StringType) ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDefaultValue()));
    if (src.hasElement())
      tgt.getElementList().add(String43_N.convertString(src.getElementElement()));
    if (src.hasListMode())
      tgt.setListModeElement(convertStructureMapSourceListMode(src.getListModeElement()));
    if (src.hasVariable())
      tgt.setVariableElement(Id43_N.convertId(src.getVariableElement()));
    if (src.hasCondition())
      tgt.setConditionElement(String43_N.convertString(src.getConditionElement()));
    if (src.hasCheck())
      tgt.setCheckElement(String43_N.convertString(src.getCheckElement()));
    if (src.hasLogMessage())
      tgt.setLogMessageElement(String43_N.convertString(src.getLogMessageElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleSourceComponent convertStructureMapGroupRuleSourceComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleSourceComponent tgt = new org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleSourceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(Id43_N.convertId(src.getContextElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer43_N.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    if (src.hasType())
      tgt.setTypeElement(String43_N.convertString(src.getTypeElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDefaultValueElement()));
    if (src.hasElement())
      tgt.setElementElement(String43_N.convertString(src.getElementElement()));
    if (src.hasListMode())
      tgt.setListModeElement(convertStructureMapSourceListMode(src.getListModeElement()));
    if (src.hasVariable())
      tgt.setVariableElement(Id43_N.convertId(src.getVariableElement()));
    if (src.hasCondition())
      tgt.setConditionElement(String43_N.convertString(src.getConditionElement()));
    if (src.hasCheck())
      tgt.setCheckElement(String43_N.convertString(src.getCheckElement()));
    if (src.hasLogMessage())
      tgt.setLogMessageElement(String43_N.convertString(src.getLogMessageElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode> convertStructureMapSourceListMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListMode> convertStructureMapSourceListMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapSourceListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case FIRST:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListMode.FIRST);
          break;
        case NOTFIRST:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListMode.NOTFIRST);
          break;
        case LAST:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListMode.LAST);
          break;
        case NOTLAST:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListMode.NOTLAST);
          break;
        case ONLYONE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListMode.ONLYONE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapSourceListMode.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(Id43_N.convertIdToString(src.getContextElement()));
    if (src.hasContextType() && src.getContextType() != org.hl7.fhir.r4b.model.StructureMap.StructureMapContextType.VARIABLE)
      throw new Error("This conversion is not supported. Consult code maintainers"); // this should never happens - no one knows what the intent was here.
    if (src.hasElement())
      tgt.getElementList().add(String43_N.convertString(src.getElementElement()));
    if (src.hasVariable())
      tgt.setVariableElement(Id43_N.convertId(src.getVariableElement()));
    tgt.setListModeList(src.getListMode().stream()
      .map(StructureMap43_N::convertStructureMapTargetListMode)
      .collect(Collectors.toList()));
    if (src.hasListRuleId())
      tgt.setListRuleIdElement(Id43_N.convertId(src.getListRuleIdElement()));
    if (src.hasTransform())
      tgt.setTransformElement(convertStructureMapTransform(src.getTransformElement()));
    for (org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameter())
      tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetComponent convertStructureMapGroupRuleTargetComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetComponent tgt = new org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasContext())
      tgt.setContextElement(Id43_N.convertId(src.getContextElement()));
    tgt.setContextType(org.hl7.fhir.r4b.model.StructureMap.StructureMapContextType.VARIABLE);
    if (src.hasElement())
      tgt.setElementElement(String43_N.convertString(src.getElementElement()));
    if (src.hasVariable())
      tgt.setVariableElement(Id43_N.convertId(src.getVariableElement()));
    tgt.setListMode(src.getListModeList().stream()
      .map(StructureMap43_N::convertStructureMapTargetListMode)
      .collect(Collectors.toList()));
    if (src.hasListRuleId())
      tgt.setListRuleIdElement(Id43_N.convertId(src.getListRuleIdElement()));
    if (src.hasTransform())
      tgt.setTransformElement(convertStructureMapTransform(src.getTransformElement()));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameterList())
      tgt.addParameter(convertStructureMapGroupRuleTargetParameterComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode> convertStructureMapTargetListMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapTargetListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapTargetListMode> convertStructureMapTargetListMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTargetListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapTargetListMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureMap.StructureMapTargetListModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case FIRST:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTargetListMode.FIRST);
          break;
        case SHARE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTargetListMode.SHARE);
          break;
        case LAST:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTargetListMode.LAST);
          break;
        case SINGLE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTargetListMode.COLLATE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTargetListMode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTransform> convertStructureMapTransform(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTransform> tgt = new Enumeration<>(new org.hl7.fhir.model.fml.StructureMap.StructureMapTransformEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform> convertStructureMapTransform(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.fml.StructureMap.StructureMapTransform> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureMap.StructureMapTransformEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case CREATE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.CREATE);
          break;
        case COPY:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.COPY);
          break;
        case TRUNCATE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.TRUNCATE);
          break;
        case ESCAPE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.ESCAPE);
          break;
        case CAST:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.CAST);
          break;
        case APPEND:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.APPEND);
          break;
        case TRANSLATE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.TRANSLATE);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.REFERENCE);
          break;
        case DATEOP:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.DATEOP);
          break;
        case UUID:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.UUID);
          break;
        case POINTER:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.POINTER);
          break;
        case EVALUATE:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.EVALUATE);
          break;
        case CC:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.CC);
          break;
        case C:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.C);
          break;
        case QTY:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.QTY);
          break;
        case ID:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.ID);
          break;
        case CP:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.CP);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4b.model.StructureMap.StructureMapTransform.NULL);
          break;
      }
    }
    return tgt;
  }

  //DIRTY
  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }


  public static org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetParameterComponent convertStructureMapGroupRuleTargetParameterComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetParameterComponent tgt = new org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    return tgt;
  }

  //DIRTY
  public static org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id43_N.convertId(src.getNameElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getVariable()) tgt.addParameter().setValue(convertVariableStringToParameterDataType(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DataType convertVariableStringToParameterDataType(org.hl7.fhir.r4b.model.StringType src) {
    if (src.hasExtension(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE)) {
      return ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE).getValue());
    } else {
      org.hl7.fhir.model.core.IdType tgt = new org.hl7.fhir.model.core.IdType();
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.hasValue()) {
        tgt.setValueAsString(src.getValueAsString());
      }
      return tgt;
    }
  }

  public static org.hl7.fhir.model.core.DataType convertVariableStringToGuessedParameterDataType(org.hl7.fhir.r4b.model.StringType it) {
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
  public static org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleDependentComponent convertStructureMapGroupRuleDependentComponent(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleDependentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleDependentComponent tgt = new org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleDependentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Id43_N.convertId(src.getNameElement()));
    for (org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent t : src.getParameterList()) {
      tgt.getVariable().add(convertStructureMapGroupRuleTargetParameterComponentToString(t));
    }
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StringType convertStructureMapGroupRuleTargetParameterComponentToString(org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent src) {
    org.hl7.fhir.r4b.model.StringType tgt = new org.hl7.fhir.r4b.model.StringType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasValueIdType()) {
      tgt.setValueAsString(src.getValueIdType().getValueAsString());
    } else if (src.hasValue()) {
      tgt.addExtension(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE,ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    }
    return tgt;
  }
}