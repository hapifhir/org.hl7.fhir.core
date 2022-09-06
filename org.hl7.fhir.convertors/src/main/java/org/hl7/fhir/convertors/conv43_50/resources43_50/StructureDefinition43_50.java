package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Id43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.ElementDefinition43_50;
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
public class StructureDefinition43_50 {

  public static org.hl7.fhir.r5.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.r4b.model.StructureDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureDefinition tgt = new org.hl7.fhir.r5.model.StructureDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
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
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.r4b.model.Coding t : src.getKeyword()) tgt.addKeyword(Coding43_50.convertCoding(t));
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Enumerations43_50.convertFHIRVersion(src.getFhirVersionElement()));
    for (org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertStructureDefinitionMappingComponent(t));
    if (src.hasKind())
      tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean43_50.convertBoolean(src.getAbstractElement()));
    for (org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent t : src.getContext())
      tgt.addContext(convertStructureDefinitionContextComponent(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getContextInvariant())
      tgt.getContextInvariant().add(String43_50.convertString(t));
    if (src.hasType())
      tgt.setTypeElement(Uri43_50.convertUri(src.getTypeElement()));
    if (src.hasBaseDefinition())
      tgt.setBaseDefinitionElement(Canonical43_50.convertCanonical(src.getBaseDefinitionElement()));
    if (src.hasDerivation())
      tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
    if (src.hasSnapshot())
      tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
    if (src.hasDifferential())
      tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition convertStructureDefinition(org.hl7.fhir.r5.model.StructureDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition tgt = new org.hl7.fhir.r4b.model.StructureDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
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
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getKeyword()) tgt.addKeyword(Coding43_50.convertCoding(t));
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Enumerations43_50.convertFHIRVersion(src.getFhirVersionElement()));
    for (org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent t : src.getMapping())
      tgt.addMapping(convertStructureDefinitionMappingComponent(t));
    if (src.hasKind())
      tgt.setKindElement(convertStructureDefinitionKind(src.getKindElement()));
    if (src.hasAbstract())
      tgt.setAbstractElement(Boolean43_50.convertBoolean(src.getAbstractElement()));
    for (org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent t : src.getContext())
      tgt.addContext(convertStructureDefinitionContextComponent(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getContextInvariant())
      tgt.getContextInvariant().add(String43_50.convertString(t));
    if (src.hasType())
      tgt.setTypeElement(Uri43_50.convertUri(src.getTypeElement()));
    if (src.hasBaseDefinition())
      tgt.setBaseDefinitionElement(Canonical43_50.convertCanonical(src.getBaseDefinitionElement()));
    if (src.hasDerivation())
      tgt.setDerivationElement(convertTypeDerivationRule(src.getDerivationElement()));
    if (src.hasSnapshot())
      tgt.setSnapshot(convertStructureDefinitionSnapshotComponent(src.getSnapshot()));
    if (src.hasDifferential())
      tgt.setDifferential(convertStructureDefinitionDifferentialComponent(src.getDifferential()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKindEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRIMITIVETYPE:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
        break;
      case COMPLEXTYPE:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
        break;
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
        break;
      case LOGICAL:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind> convertStructureDefinitionKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKindEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRIMITIVETYPE:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.PRIMITIVETYPE);
        break;
      case COMPLEXTYPE:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.COMPLEXTYPE);
        break;
      case RESOURCE:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.RESOURCE);
        break;
      case LOGICAL:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.LOGICAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRuleEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case SPECIALIZATION:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        break;
      case CONSTRAINT:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule> convertTypeDerivationRule(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRuleEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case SPECIALIZATION:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule.SPECIALIZATION);
        break;
      case CONSTRAINT:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule.CONSTRAINT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.TypeDerivationRule.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasIdentity())
      tgt.setIdentityElement(Id43_50.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_50.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent convertStructureDefinitionMappingComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionMappingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent tgt = new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionMappingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasIdentity())
      tgt.setIdentityElement(Id43_50.convertId(src.getIdentityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_50.convertUri(src.getUriElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent convertStructureDefinitionContextComponent(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertExtensionContextType(src.getTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String43_50.convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent convertStructureDefinitionContextComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionContextComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent tgt = new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionContextComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertExtensionContextType(src.getTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String43_50.convertString(src.getExpressionElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType> convertExtensionContextType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case FHIRPATH:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.FHIRPATH);
        break;
      case ELEMENT:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.ELEMENT);
        break;
      case EXTENSION:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.EXTENSION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType> convertExtensionContextType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.StructureDefinition.ExtensionContextType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case FHIRPATH:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType.FHIRPATH);
        break;
      case ELEMENT:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType.ELEMENT);
        break;
      case EXTENSION:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType.EXTENSION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.StructureDefinition.ExtensionContextType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition43_50.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionSnapshotComponent convertStructureDefinitionSnapshotComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionSnapshotComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionSnapshotComponent tgt = new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionSnapshotComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition43_50.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition43_50.convertElementDefinition(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionDifferentialComponent convertStructureDefinitionDifferentialComponent(org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionDifferentialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionDifferentialComponent tgt = new org.hl7.fhir.r4b.model.StructureDefinition.StructureDefinitionDifferentialComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.ElementDefinition t : src.getElement())
      tgt.addElement(ElementDefinition43_50.convertElementDefinition(t));
    return tgt;
  }
}