package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Period10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class NamingSystem10_50 {

  public static org.hl7.fhir.dstu2.model.NamingSystem convertNamingSystem(org.hl7.fhir.r5.model.NamingSystem src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.NamingSystem tgt = new org.hl7.fhir.dstu2.model.NamingSystem();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertNamingSystemContactComponent(t));
    if (src.hasResponsibleElement())
      tgt.setResponsibleElement(String10_50.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept10_50.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasUsageElement())
      tgt.setUsageElement(String10_50.convertString(src.getUsageElement()));
    for (org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu2.model.NamingSystem src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.NamingSystem tgt = new org.hl7.fhir.r5.model.NamingSystem();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent t : src.getContact())
      tgt.addContact(convertNamingSystemContactComponent(t));
    if (src.hasResponsibleElement())
      tgt.setResponsibleElement(String10_50.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_10_50.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept10_50.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept10_50.convertCodeableConceptToUsageContext(t));
    if (src.hasUsageElement())
      tgt.setUsageElement(String10_50.convertString(src.getUsageElement()));
    for (org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactDetail convertNamingSystemContactComponent(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent convertNamingSystemContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent tgt = new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OID:
        tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.OID);
        break;
      case UUID:
        tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.UUID);
        break;
      case URI:
        tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.URI);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.OTHER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case CODESYSTEM:
        tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.CODESYSTEM);
        break;
      case IDENTIFIER:
        tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.IDENTIFIER);
        break;
      case ROOT:
        tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.ROOT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.NamingSystem.NamingSystemTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    if (src.hasPreferredElement())
      tgt.setPreferredElement(Boolean10_50.convertBoolean(src.getPreferredElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    if (src.hasPreferredElement())
      tgt.setPreferredElement(Boolean10_50.convertBoolean(src.getPreferredElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    return tgt;
  }
}