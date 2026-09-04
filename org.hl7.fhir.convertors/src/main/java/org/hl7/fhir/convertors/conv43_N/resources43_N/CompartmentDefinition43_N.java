package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.CodeType;
import org.hl7.fhir.r4b.model.CompartmentDefinition;
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

public class CompartmentDefinition43_N {

  public static org.hl7.fhir.model.core.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.r4b.model.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CompartmentDefinition tgt = new org.hl7.fhir.model.core.CompartmentDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean43_N.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.model.core.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CompartmentDefinition tgt = new org.hl7.fhir.r4b.model.CompartmentDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean43_N.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResourceList())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompartmentType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType> tgt = new org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType>(new org.hl7.fhir.model.core.CompartmentDefinition.CompartmentTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PATIENT:
                  tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType.PATIENT);
                  break;
              case ENCOUNTER:
                  tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType.ENCOUNTER);
                  break;
              case RELATEDPERSON:
                  tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType.RELATEDPERSON);
                  break;
              case PRACTITIONER:
                  tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType.PRACTITIONER);
                  break;
              case DEVICE:
                  tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType.DEVICE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompartmentType> convertCompartmentType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompartmentType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.CompartmentTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PATIENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.PATIENT);
                  break;
              case ENCOUNTER:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.ENCOUNTER);
                  break;
              case RELATEDPERSON:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.RELATEDPERSON);
                  break;
              case PRACTITIONER:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.PRACTITIONER);
                  break;
              case DEVICE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.DEVICE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompartmentType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertResourceCode(src.getCodeElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getParam()) tgt.setStartParamElement(String43_N.convertStringToUri(t));
    return tgt;
  }


  public static org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertResourceCode(src.getCodeElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getParamList()) tgt.getParam().add(String43_N.convertString(t));
    return tgt;
  }

  private static Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes> convertResourceCode(CodeType src) {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes> tgt = new Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes>(new org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypesEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    try {
      tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes.fromCode(src.getCode()));
    } catch (Exception e) {
      tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes.NULL);
    }
    return tgt;
  }

  private static CodeType convertResourceCode(Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes> src) {
    if (src == null || src.isEmpty())
      return null;
    CodeType tgt = new CodeType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    tgt.setValue(src.getValue().toCode());
    return tgt;
  }

}