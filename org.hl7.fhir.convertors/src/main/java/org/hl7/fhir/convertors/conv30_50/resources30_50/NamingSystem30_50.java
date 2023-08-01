package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ContactDetail30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.UsageContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.MarkDown30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Uri30_50;
import org.hl7.fhir.dstu3.model.Extension;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.dstu3.model.UriType;
import org.hl7.fhir.exceptions.FHIRException;

public class NamingSystem30_50 {

  public static org.hl7.fhir.dstu3.model.NamingSystem convertNamingSystem(org.hl7.fhir.r5.model.NamingSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.NamingSystem tgt = new org.hl7.fhir.dstu3.model.NamingSystem();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUrlElement()) 
      tgt.getExtension().add(new Extension().setUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_URL).setValue(Uri30_50.convertUri(src.getUrlElement())));
    if (src.hasVersionElement()) 
      tgt.getExtension().add(new Extension().setUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION).setValue(String30_50.convertString(src.getVersionElement())));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasTitleElement()) 
      tgt.getExtension().add(new Extension().setUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE).setValue(String30_50.convertString(src.getTitleElement())));

    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    if (src.hasResponsible())
      tgt.setResponsibleElement(String30_50.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasUsage())
      tgt.setUsageElement(String30_50.convertString(src.getUsageElement()));
    for (org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu3.model.NamingSystem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NamingSystem tgt = new org.hl7.fhir.r5.model.NamingSystem();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_NAMINGSYSTEM_URL, VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION, VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE);

    if (src.hasExtension(VersionConvertorConstants.EXT_NAMINGSYSTEM_URL)) {
      tgt.setUrlElement(Uri30_50.convertUri((UriType) src.getExtensionByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_URL).getValue()));
    }
    if (src.hasExtension(VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION)) {
      tgt.setVersionElement(String30_50.convertString((StringType) src.getExtensionByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_VERSION).getValue()));
    }
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasExtension(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE)) {
      tgt.setTitleElement(String30_50.convertString((StringType) src.getExtensionByUrl(VersionConvertorConstants.EXT_NAMINGSYSTEM_TITLE).getValue()));
    }
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    if (src.hasResponsible())
      tgt.setResponsibleElement(String30_50.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasUsage())
      tgt.setUsageElement(String30_50.convertString(src.getUsageElement()));
    for (org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OID:
        tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.OID);
        break;
      case UUID:
        tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.UUID);
        break;
      case URI:
        tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.URI);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.OTHER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.NamingSystem.NamingSystemTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CODESYSTEM:
        tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.CODESYSTEM);
        break;
      case IDENTIFIER:
        tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.IDENTIFIER);
        break;
      case ROOT:
        tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.ROOT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValue())
      tgt.setValueElement(String30_50.convertString(src.getValueElement()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean30_50.convertBoolean(src.getPreferredElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValue())
      tgt.setValueElement(String30_50.convertString(src.getValueElement()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean30_50.convertBoolean(src.getPreferredElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    return tgt;
  }
}