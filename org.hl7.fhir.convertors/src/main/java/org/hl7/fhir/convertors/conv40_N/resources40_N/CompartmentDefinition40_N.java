package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CompartmentDefinition;
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

public class CompartmentDefinition40_N {

  // R6 compartment codes that R4 doesn't have
  public static final String CODE_EXTENSION_URL = "http://hl7.org/fhir/6.0/StructureDefinition/extension-CompartmentDefinition.code";

  public static org.hl7.fhir.model.core.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.r4.model.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CompartmentDefinition tgt = new org.hl7.fhir.model.core.CompartmentDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("CompartmentDefinition", "5.0", new String[] {"title"}, CrossVersionElements40_N.urls("CompartmentDefinition", "6.0", new String[] {}, VersionConvertorConstants.EXT_VERSION_ALGORITHM)));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "title");
    if (src.hasExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM))
      tgt.setVersionAlgorithm(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(VersionConvertorConstants.EXT_VERSION_ALGORITHM).getValue()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean40_N.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.model.core.CompartmentDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CompartmentDefinition tgt = new org.hl7.fhir.r4.model.CompartmentDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "title");
    if (src.hasVersionAlgorithm())
      tgt.addExtension(VersionConvertorConstants.EXT_VERSION_ALGORITHM, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getVersionAlgorithm()));
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
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
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
    if (src.hasSearch())
      tgt.setSearchElement(Boolean40_N.convertBoolean(src.getSearchElement()));
    for (org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResourceList())
      tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType> tgt = new org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType>(new org.hl7.fhir.model.core.CompartmentDefinition.CompartmentTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, CODE_EXTENSION_URL);
      if (src.hasExtension(CODE_EXTENSION_URL)) {
        tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType.fromCode(src.getExtensionByUrl(CODE_EXTENSION_URL).getValue().primitiveValue()));
        return tgt;
      }
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.CompartmentType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CompartmentDefinition.CompartmentType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CompartmentDefinition.CompartmentTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PATIENT:
                  tgt.setValue(CompartmentDefinition.CompartmentType.PATIENT);
                  break;
              case ENCOUNTER:
                  tgt.setValue(CompartmentDefinition.CompartmentType.ENCOUNTER);
                  break;
              case RELATEDPERSON:
                  tgt.setValue(CompartmentDefinition.CompartmentType.RELATEDPERSON);
                  break;
              case PRACTITIONER:
                  tgt.setValue(CompartmentDefinition.CompartmentType.PRACTITIONER);
                  break;
              case DEVICE:
                  tgt.setValue(CompartmentDefinition.CompartmentType.DEVICE);
                  break;
              default:
                  // a compartment R4 doesn't have (Group): keep the code
                  tgt.setValue(null);
                  tgt.addExtension(CODE_EXTENSION_URL, new org.hl7.fhir.r4.model.CodeType(src.getCode()));
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("CompartmentDefinition.resource", "5.0", new String[] {"startParam", "endParam"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "CompartmentDefinition.resource", "5.0", "startParam", "endParam");
    // R6 dropped documentation
    CrossVersionElements40_N.r4ElementsToExtensions(src, "CompartmentDefinition.resource", tgt.getExtension(), "documentation");
    if (src.hasCode())
      tgt.setCodeElement(convertResourceCode(src.getCodeElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getParam()) tgt.getParamList().add(String40_N.convertString(t));
    return tgt;
  }


  public static org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.model.core.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("CompartmentDefinition.resource", "4.0", "documentation"));
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "CompartmentDefinition.resource", tgt.getExtension(), "5.0", "startParam", "endParam");
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "CompartmentDefinition.resource", "documentation");
    if (src.hasCode())
      tgt.setCodeElement(convertResourceCode(src.getCodeElement()));
    for (org.hl7.fhir.model.core.StringType t : src.getParamList()) tgt.getParam().add(String40_N.convertString(t));
    return tgt;
  }

  private static Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes> convertResourceCode(CodeType src) {
    if (src == null || src.isEmpty())
      return null;
    Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes> tgt = new Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes>(new org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypesEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    try {
      tgt.setValue(org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes.fromCode(src.getCode()));
    } catch (Exception e) {
      // a resource type R6 doesn't have: no value, and the R4 code is kept
      tgt.setValue(null);
      tgt.addExtension(CODE_URL, new org.hl7.fhir.model.core.CodeType(src.getCode()));
    }
    return tgt;
  }

  private static CodeType convertResourceCode(Enumeration<org.hl7.fhir.model.core.CompartmentDefinition.ExtendedResourceTypes> src) {
    if (src == null || src.isEmpty())
      return null;
    CodeType tgt = new CodeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, CODE_URL);
    if (src.hasExtension(CODE_URL))
      tgt.setValue(src.getExtensionString(CODE_URL));
    else if (src.getValue() != null)
      tgt.setValue(src.getValue().toCode());
    return tgt;
  }

  private static final String CODE_URL = org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N.url("CompartmentDefinition.resource", "4.0", "code");

}