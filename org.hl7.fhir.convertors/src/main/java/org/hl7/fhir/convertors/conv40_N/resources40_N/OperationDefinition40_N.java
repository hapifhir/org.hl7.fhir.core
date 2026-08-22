package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.Utilities40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.OperationDefinition;
import org.hl7.fhir.model.core.UriType;

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

public class OperationDefinition40_N {

  public static org.hl7.fhir.model.core.OperationDefinition convertOperationDefinition(org.hl7.fhir.r4.model.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition tgt = new org.hl7.fhir.model.core.OperationDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
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
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(Boolean40_N.convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown40_N.convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical40_N.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getResource()) tgt.getResourceList().add(Code40_N.convertCodeToUri(t));
    if (src.hasSystem())
      tgt.setSystemElement(Boolean40_N.convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(Boolean40_N.convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(Boolean40_N.convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(Canonical40_N.convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(Canonical40_N.convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.model.core.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition tgt = new org.hl7.fhir.r4.model.OperationDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
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
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(Boolean40_N.convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code40_N.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown40_N.convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical40_N.convertCanonical(src.getBaseElement()));
    for (UriType t : src.getResourceList()) tgt.getResource().add(Code40_N.convertCodeFromUri(t));
    if (src.hasSystem())
      tgt.setSystemElement(Boolean40_N.convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(Boolean40_N.convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(Boolean40_N.convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(Canonical40_N.convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(Canonical40_N.convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameterList())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverloadList())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<OperationDefinition.OperationKind> tgt = new Enumeration<>(new OperationDefinition.OperationKindEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OPERATION:
                  tgt.setValue(OperationDefinition.OperationKind.OPERATION);
                  break;
              case QUERY:
                  tgt.setValue(OperationDefinition.OperationKind.QUERY);
                  break;
              default:
                  tgt.setValue(OperationDefinition.OperationKind.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.OperationDefinition.OperationKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.OperationDefinition.OperationKindEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code40_N.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer40_N.convertIntegerToUnsigned(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertStringToMarkdown(src.getDocumentationElement()));
    if (src.hasType()) {
      tgt.setTypeElement(Uri40_N.convertUriFromCode(src.getTypeElement()));
    }
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfileList().add(Canonical40_N.convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations40_N.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFrom())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code40_N.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer40_N.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String40_N.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String40_N.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      tgt.setTypeElement(Uri40_N.convertUriToCode(src.getTypeElement()));
    }
    for (org.hl7.fhir.model.core.CanonicalType t : src.getTargetProfileList())
      tgt.getTargetProfile().add(Canonical40_N.convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations40_N.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFromList())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent t : src.getPartList())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.OperationParameterUse> tgt = new Enumeration<>(new Enumerations.OperationParameterUseEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case IN:
                  tgt.setValue(Enumerations.OperationParameterUse.IN);
                  break;
              case OUT:
                  tgt.setValue(Enumerations.OperationParameterUse.OUT);
                  break;
              default:
                  tgt.setValue(Enumerations.OperationParameterUse.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUse> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.OperationDefinition.OperationParameterUseEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations40_N.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical40_N.convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations40_N.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical40_N.convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(String40_N.convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(String40_N.convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(String40_N.convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(String40_N.convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.StringType t : src.getParameterName())
      tgt.getParameterNameList().add(String40_N.convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r4.model.OperationDefinition.OperationDefinitionOverloadComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.StringType t : src.getParameterNameList())
      tgt.getParameterName().add(String40_N.convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertString(src.getCommentElement()));
    return tgt;
  }
}