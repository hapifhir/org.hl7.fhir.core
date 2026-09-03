package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.UriType;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.NamingSystem;

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

public class NamingSystem40_N {

  public static org.hl7.fhir.model.core.NamingSystem convertNamingSystem(org.hl7.fhir.r4.model.NamingSystem src) throws FHIRException {
    if (src == null)
      return null;
  
    org.hl7.fhir.model.core.NamingSystem tgt = new org.hl7.fhir.model.core.NamingSystem();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_NAMINGSYSTEM_URL, VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION, VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE);

    if (src.getExtensionsByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_URL).size() == 1) {
      tgt.setUrlElement(Uri40_N.convertUri((UriType) src.getExtensionByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_URL).getValue()));
    }
    if (src.hasExtension(VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION)) {
      tgt.setVersionElement(String40_N.convertString((StringType) src.getExtensionByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION).getValue()));
    }
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasExtension(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE)) {
      tgt.setTitleElement(String40_N.convertString((StringType) src.getExtensionByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE).getValue()));
    }

    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasResponsible())
      tgt.setResponsibleElement(String40_N.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasUsage())
      tgt.setUsageElement(String40_N.convertStringToMarkdown(src.getUsageElement()));
    for (org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NamingSystem convertNamingSystem(org.hl7.fhir.model.core.NamingSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NamingSystem tgt = new org.hl7.fhir.r4.model.NamingSystem();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_NAMINGSYSTEM_URL);
    if (src.hasUrlElement()) {
      tgt.getExtension().add(new Extension().setUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_URL).setValue(Uri40_N.convertUri(src.getUrlElement())));
    }
    if (src.hasVersionElement()) 
      tgt.getExtension().add(new Extension().setUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION).setValue(String40_N.convertString(src.getVersionElement())));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitleElement()) 
      tgt.getExtension().add(new Extension().setUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE).setValue(String40_N.convertString(src.getTitleElement())));

    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasResponsible())
      tgt.setResponsibleElement(String40_N.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasUsage())
      tgt.setUsageElement(String40_N.convertString(src.getUsageElement()));
    for (org.hl7.fhir.model.core.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueIdList())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<NamingSystem.NamingSystemType> tgt = new Enumeration<>(new NamingSystem.NamingSystemTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CODESYSTEM:
                  tgt.setValue(NamingSystem.NamingSystemType.CODESYSTEM);
                  break;
              case IDENTIFIER:
                  tgt.setValue(NamingSystem.NamingSystemType.IDENTIFIER);
                  break;
              case ROOT:
                  tgt.setValue(NamingSystem.NamingSystemType.ROOT);
                  break;
              default:
                  tgt.setValue(NamingSystem.NamingSystemType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.NamingSystem.NamingSystemType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.NamingSystem.NamingSystemTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CODESYSTEM:
                  tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.CODESYSTEM);
                  break;
              case IDENTIFIER:
                  tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.IDENTIFIER);
                  break;
              case ROOT:
                  tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.ROOT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.model.core.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean40_N.convertBoolean(src.getPreferredElement()));
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertString(src.getCommentElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.model.core.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean40_N.convertBoolean(src.getPreferredElement()));
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertString(src.getCommentElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<NamingSystem.NamingSystemIdentifierType> tgt = new Enumeration<>(new NamingSystem.NamingSystemIdentifierTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OID:
                  tgt.setValue(NamingSystem.NamingSystemIdentifierType.OID);
                  break;
              case UUID:
                  tgt.setValue(NamingSystem.NamingSystemIdentifierType.UUID);
                  break;
              case URI:
                  tgt.setValue(NamingSystem.NamingSystemIdentifierType.URI);
                  break;
              case OTHER:
                  tgt.setValue(NamingSystem.NamingSystemIdentifierType.OTHER);
                  break;
              default:
                  tgt.setValue(NamingSystem.NamingSystemIdentifierType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OID:
                  tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.OID);
                  break;
              case UUID:
                  tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.UUID);
                  break;
              case URI:
                  tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.URI);
                  break;
              case OTHER:
                  tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.OTHER);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.NULL);
                  break;
          }
      }
      return tgt;
  }
}