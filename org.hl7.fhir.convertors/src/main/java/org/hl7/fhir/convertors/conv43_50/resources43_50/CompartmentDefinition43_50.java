package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
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
public class CompartmentDefinition43_50 {

  public static org.hl7.fhir.r5.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.r4b.model.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CompartmentDefinition tgt = new org.hl7.fhir.r5.model.CompartmentDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean43_50.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.r5.model.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CompartmentDefinition tgt = new org.hl7.fhir.r4b.model.CompartmentDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean43_50.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> convertCompartmentType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompartmentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompartmentTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PATIENT);
        break;
      case ENCOUNTER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.ENCOUNTER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.RELATEDPERSON);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PRACTITIONER);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.DEVICE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompartmentType> convertCompartmentType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompartmentType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.CompartmentTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getParam()) tgt.getParam().add(String43_50.convertString(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_50.convertString(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.r5.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.r4b.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(Code43_50.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getParam()) tgt.getParam().add(String43_50.convertString(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(String43_50.convertString(src.getDocumentationElement()));
    return tgt;
  }
}