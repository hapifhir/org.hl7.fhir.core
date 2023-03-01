package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
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
public class OperationDefinition40_50 {

  public static org.hl7.fhir.r5.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r4.model.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition tgt = new org.hl7.fhir.r5.model.OperationDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(Boolean40_50.convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown40_50.convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical40_50.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getResource()) tgt.getResource().add(new Enumeration<VersionIndependentResourceTypesAll>(new VersionIndependentResourceTypesAllEnumFactory(), Code40_50.convertCode(t)));
    if (src.hasSystem())
      tgt.setSystemElement(Boolean40_50.convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(Boolean40_50.convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(Boolean40_50.convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(Canonical40_50.convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(Canonical40_50.convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.r5.model.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition tgt = new org.hl7.fhir.r4.model.OperationDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(Boolean40_50.convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_50.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown40_50.convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical40_50.convertCanonical(src.getBaseElement()));
    for (Enumeration<VersionIndependentResourceTypesAll> t : src.getResource()) tgt.getResource().add(Code40_50.convertCode(t.getCodeType()));
    if (src.hasSystem())
      tgt.setSystemElement(Boolean40_50.convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(Boolean40_50.convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(Boolean40_50.convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(Canonical40_50.convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(Canonical40_50.convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.OperationDefinition.OperationKindEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationDefinition.OperationKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.OperationDefinition.OperationKindEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OPERATION:
        tgt.setValue(org.hl7.fhir.r4.model.OperationDefinition.OperationKind.OPERATION);
        break;
      case QUERY:
        tgt.setValue(org.hl7.fhir.r4.model.OperationDefinition.OperationKind.QUERY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.OperationDefinition.OperationKind.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code40_50.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer40_50.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_50.convertStringToMarkdown(src.getDocumentationElement()));
    if (src.hasType())
      tgt.getTypeElement().setValue(org.hl7.fhir.r5.model.Enumerations.FHIRTypes.fromCode(src.getType()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(Canonical40_50.convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations40_50.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFrom())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code40_50.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer40_50.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_50.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_50.convertString(src.getDocumentationElement()));
    if (src.hasType())
      tgt.setTypeElement(new org.hl7.fhir.r4.model.CodeType(src.getType().toCode()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfile().add(Canonical40_50.convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations40_50.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFrom())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.OperationParameterUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.OperationParameterUse> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUseEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case IN:
        tgt.setValue(org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.IN);
        break;
      case OUT:
        tgt.setValue(org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.OUT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations40_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical40_50.convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations40_50.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical40_50.convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(String40_50.convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(String40_50.convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(String40_50.convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(String40_50.convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.StringType t : src.getParameterName())
      tgt.getParameterName().add(String40_50.convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r5.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.StringType t : src.getParameterName())
      tgt.getParameterName().add(String40_50.convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    return tgt;
  }
}