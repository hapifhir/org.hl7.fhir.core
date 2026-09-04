package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.Utilities43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
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

public class OperationDefinition43_N {

  public static org.hl7.fhir.model.core.OperationDefinition convertOperationDefinition(org.hl7.fhir.r4b.model.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition tgt = new org.hl7.fhir.model.core.OperationDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
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
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(Boolean43_N.convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown43_N.convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical43_N.convertCanonical(src.getBaseElement()));
    for (org.hl7.fhir.r4b.model.CodeType t : src.getResource()) tgt.getResourceList().add(Code43_N.convertCodeToUri(t));
    if (src.hasSystem())
      tgt.setSystemElement(Boolean43_N.convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(Boolean43_N.convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(Boolean43_N.convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(Canonical43_N.convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(Canonical43_N.convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameter())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverload())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition convertOperationDefinition(org.hl7.fhir.model.core.OperationDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition tgt = new org.hl7.fhir.r4b.model.OperationDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertOperationKind(src.getKindElement()));
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
    if (src.hasAffectsState())
      tgt.setAffectsStateElement(Boolean43_N.convertBoolean(src.getAffectsStateElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code43_N.convertCode(src.getCodeElement()));
    if (src.hasComment())
      tgt.setCommentElement(MarkDown43_N.convertMarkdown(src.getCommentElement()));
    if (src.hasBase())
      tgt.setBaseElement(Canonical43_N.convertCanonical(src.getBaseElement()));
    for (UriType t : src.getResourceList()) tgt.getResource().add(Code43_N.convertCodeFromUri(t));
    if (src.hasSystem())
      tgt.setSystemElement(Boolean43_N.convertBoolean(src.getSystemElement()));
    if (src.hasType())
      tgt.setTypeElement(Boolean43_N.convertBoolean(src.getTypeElement()));
    if (src.hasInstance())
      tgt.setInstanceElement(Boolean43_N.convertBoolean(src.getInstanceElement()));
    if (src.hasInputProfile())
      tgt.setInputProfileElement(Canonical43_N.convertCanonical(src.getInputProfileElement()));
    if (src.hasOutputProfile())
      tgt.setOutputProfileElement(Canonical43_N.convertCanonical(src.getOutputProfileElement()));
    for (org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent t : src.getParameterList())
      tgt.addParameter(convertOperationDefinitionParameterComponent(t));
    for (org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent t : src.getOverloadList())
      tgt.addOverload(convertOperationDefinitionOverloadComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationDefinition.OperationKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<OperationDefinition.OperationKind> tgt = new Enumeration<>(new OperationDefinition.OperationKindEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationDefinition.OperationKind> convertOperationKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.OperationDefinition.OperationKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationDefinition.OperationKind> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.OperationDefinition.OperationKindEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code43_N.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer43_N.convertIntegerToUnsigned(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertStringToMarkdown(src.getDocumentationElement()));
    if (src.hasType()) {
      tgt.setType(src.getType().toCode());
    }
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getTargetProfile())
      tgt.getTargetProfileList().add(Canonical43_N.convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations43_N.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFrom())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent t : src.getPart())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent convertOperationDefinitionParameterComponent(org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent tgt = new org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(Code43_N.convertCode(src.getNameElement()));
    if (src.hasUse())
      tgt.setUseElement(convertOperationParameterUse(src.getUseElement()));
    if (src.hasMin())
      tgt.setMinElement(Integer43_N.convertInteger(src.getMinElement()));
    if (src.hasMax())
      tgt.setMaxElement(String43_N.convertString(src.getMaxElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_N.convertString(src.getDocumentationElement()));
    if (src.hasType()) {
      tgt.setType(org.hl7.fhir.r4b.model.Enumerations.FHIRAllTypes.fromCode(src.getType()));
    }
    for (org.hl7.fhir.model.core.CanonicalType t : src.getTargetProfileList())
      tgt.getTargetProfile().add(Canonical43_N.convertCanonical(t));
    if (src.hasSearchType())
      tgt.setSearchTypeElement(Enumerations43_N.convertSearchParamType(src.getSearchTypeElement()));
    if (src.hasBinding())
      tgt.setBinding(convertOperationDefinitionParameterBindingComponent(src.getBinding()));
    for (org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent t : src.getReferencedFromList())
      tgt.addReferencedFrom(convertOperationDefinitionParameterReferencedFromComponent(t));
    for (org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterComponent t : src.getPartList())
      tgt.addPart(convertOperationDefinitionParameterComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.OperationParameterUse> tgt = new Enumeration<>(new Enumerations.OperationParameterUseEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> convertOperationParameterUse(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.OperationParameterUse> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.OperationParameterUse> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.OperationParameterUseEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations43_N.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical43_N.convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterBindingComponent convertOperationDefinitionParameterBindingComponent(org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterBindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterBindingComponent tgt = new org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterBindingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasStrength())
      tgt.setStrengthElement(Enumerations43_N.convertBindingStrength(src.getStrengthElement()));
    if (src.hasValueSet())
      tgt.setValueSetElement(Canonical43_N.convertCanonical(src.getValueSetElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(String43_N.convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(String43_N.convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent convertOperationDefinitionParameterReferencedFromComponent(org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionParameterReferencedFromComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent tgt = new org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionParameterReferencedFromComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSource())
      tgt.setSourceElement(String43_N.convertString(src.getSourceElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(String43_N.convertString(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.StringType t : src.getParameterName())
      tgt.getParameterNameList().add(String43_N.convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(String43_N.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent convertOperationDefinitionOverloadComponent(org.hl7.fhir.model.core.OperationDefinition.OperationDefinitionOverloadComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent tgt = new org.hl7.fhir.r4b.model.OperationDefinition.OperationDefinitionOverloadComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.StringType t : src.getParameterNameList())
      tgt.getParameterName().add(String43_N.convertString(t));
    if (src.hasComment())
      tgt.setCommentElement(String43_N.convertString(src.getCommentElement()));
    return tgt;
  }
}