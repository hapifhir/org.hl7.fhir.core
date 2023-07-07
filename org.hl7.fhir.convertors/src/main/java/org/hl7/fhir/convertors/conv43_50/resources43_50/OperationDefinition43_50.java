package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Utilities40_50;
import org.hl7.fhir.convertors.conv43_50.Utilities43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Integer43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAll;
import org.hl7.fhir.r5.model.Enumerations.VersionIndependentResourceTypesAllEnumFactory;

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
public class OperationDefinition43_50 {

  public static org.hl7.fhir.r5.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r4b.model.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition tgt = new org.hl7.fhir.r5.model.OperationDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
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
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(Boolean43_50.convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown43_50.convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical43_50.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getResource()) tgt.getResource().add(new Enumeration<VersionIndependentResourceTypesAll>(new VersionIndependentResourceTypesAllEnumFactory(), Code43_50.convertCode(t)));
    if (src.hasSystem())
      tgt.setSystemElement(Boolean43_50.convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(Boolean43_50.convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(Boolean43_50.convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(Canonical43_50.convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(Canonical43_50.convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r5.model.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition tgt = new org.hl7.fhir.r4b.model.OperationDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
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
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(Boolean43_50.convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown43_50.convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical43_50.convertCanonical(src.getBaseElement()));
    for (Enumeration<VersionIndependentResourceTypesAll> t : src.getResource()) tgt.getResource().add(Code43_50.convertCode(t.getCodeType()));
    if (src.hasSystem())
      tgt.setSystemElement(Boolean43_50.convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(Boolean43_50.convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(Boolean43_50.convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(Canonical43_50.convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(Canonical43_50.convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationDefinition.OperationKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.OperationDefinition.OperationKindEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OPERATION:
        tgt.setValue(org.hl7.fhir.r5.model.OperationDefinition.OperationKind.OPERATION);
        break;
      case QUERY:
        tgt.setValue(org.hl7.fhir.r5.model.OperationDefinition.OperationKind.QUERY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.OperationDefinition.OperationKind.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.OperationDefinition.OperationKindEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OPERATION:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationDefinition.OperationKind.OPERATION);
        break;
      case QUERY:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationDefinition.OperationKind.QUERY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationDefinition.OperationKind.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code43_50.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer43_50.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String43_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_50.convertStringToMarkdown(src.getDocumentationElement()));
    if (src.hasType()) {
      Utilities43_50.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(Canonical43_50.convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations43_50.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFrom())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code43_50.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer43_50.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String43_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_50.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      Utilities43_50.convertType(src.getTypeElement(), tgt.getTypeElement());   
    }
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(Canonical43_50.convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations43_50.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFrom())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case IN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.IN);
        break;
      case OUT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.OUT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.OperationParameterUse.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case IN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse.IN);
        break;
      case OUT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse.OUT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations43_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical43_50.convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations43_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical43_50.convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(String43_50.convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(String43_50.convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(String43_50.convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(String43_50.convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.StringType t : src.getParameterName())
      tgt.getParameterName().add(String43_50.convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.StringType t : src.getParameterName())
      tgt.getParameterName().add(String43_50.convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    return tgt;
  }
}