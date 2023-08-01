package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Extension;

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
public class NamingSystem43_50 {

  public static org.hl7.fhir.r5.model.NamingSystem convertNamingSystem(org.hl7.fhir.r4b.model.NamingSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NamingSystem tgt = new org.hl7.fhir.r5.model.NamingSystem();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE);

    if (src.hasExtension(VersionConvertorConstants.EXT_NAMINGSYSTEM_URL)) {
      tgt.setUrlElement(Uri43_50.convertToUri(src.getExtensionByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_URL).getValue()));
    }
    if (src.hasExtension(VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION)) {
      tgt.setVersionElement(String43_50.convertString(src.getExtensionByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION).getValueStringType()));
    }
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasExtension(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE)) {
      tgt.setTitleElement(String43_50.convertString(src.getExtensionByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE).getValueStringType()));
    }
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasResponsible())
      tgt.setResponsibleElement(String43_50.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasUsage())
      tgt.setUsageElement(String43_50.convertString(src.getUsageElement()));
    for (org.hl7.fhir.r4b.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NamingSystem convertNamingSystem(org.hl7.fhir.r5.model.NamingSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NamingSystem tgt = new org.hl7.fhir.r4b.model.NamingSystem();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);

    if (src.hasUrlElement()) 
      tgt.getExtension().add(new Extension().setUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_URL).setValue(Uri43_50.convertUri(src.getUrlElement())));
    if (src.hasVersionElement()) 
      tgt.getExtension().add(new Extension().setUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION).setValue(String43_50.convertString(src.getVersionElement())));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitleElement()) 
      tgt.getExtension().add(new Extension().setUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE).setValue(String43_50.convertString(src.getTitleElement())));

    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasResponsible())
      tgt.setResponsibleElement(String43_50.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasUsage())
      tgt.setUsageElement(String43_50.convertString(src.getUsageElement()));
    for (org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.NamingSystem.NamingSystemType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.NamingSystem.NamingSystemTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CODESYSTEM:
        tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.CODESYSTEM);
        break;
      case IDENTIFIER:
        tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.IDENTIFIER);
        break;
      case ROOT:
        tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.ROOT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.NamingSystem.NamingSystemTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CODESYSTEM:
        tgt.setValue(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemType.CODESYSTEM);
        break;
      case IDENTIFIER:
        tgt.setValue(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemType.IDENTIFIER);
        break;
      case ROOT:
        tgt.setValue(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemType.ROOT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean43_50.convertBoolean(src.getPreferredElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r4b.model.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValue())
      tgt.setValueElement(String43_50.convertString(src.getValueElement()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean43_50.convertBoolean(src.getPreferredElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OID:
        tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.OID);
        break;
      case UUID:
        tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.UUID);
        break;
      case URI:
        tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.URI);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.OTHER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OID:
        tgt.setValue(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemIdentifierType.OID);
        break;
      case UUID:
        tgt.setValue(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemIdentifierType.UUID);
        break;
      case URI:
        tgt.setValue(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemIdentifierType.URI);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemIdentifierType.OTHER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.NamingSystem.NamingSystemIdentifierType.NULL);
        break;
    }
    return tgt;
  }
}