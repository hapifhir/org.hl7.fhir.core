package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.CodeableConcept14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.ContactPoint14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Period14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Boolean14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.DateTime14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class NamingSystem14_40 {

  public static org.hl7.fhir.r4.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu2016may.model.NamingSystem src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.NamingSystem tgt = new org.hl7.fhir.r4.model.NamingSystem();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_40.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent t : src.getContact())
      tgt.addContact(convertNamingSystemContactComponent(t));
    if (src.hasResponsible())
      tgt.setResponsibleElement(String14_40.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept14_40.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_14_40.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_40.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_40.convertCodeableConceptToUsageContext(t));
    if (src.hasUsage())
      tgt.setUsageElement(String14_40.convertString(src.getUsageElement()));
    for (org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.NamingSystem convertNamingSystem(org.hl7.fhir.r4.model.NamingSystem src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.NamingSystem tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyDomainResource(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_40.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasKind())
      tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertNamingSystemContactComponent(t));
    if (src.hasResponsible())
      tgt.setResponsibleElement(String14_40.convertString(src.getResponsibleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept14_40.convertCodeableConcept(src.getType()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept14_40.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept14_40.convertCodeableConcept(t));
    if (src.hasUsage())
      tgt.setUsageElement(String14_40.convertString(src.getUsageElement()));
    for (org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId())
      tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent convertNamingSystemContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ContactDetail convertNamingSystemContactComponent(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_40.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case OID:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.OID);
        break;
      case UUID:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.UUID);
        break;
      case URI:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.URI);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.OTHER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
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
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemTypeEnumFactory());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CODESYSTEM:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.CODESYSTEM);
        break;
      case IDENTIFIER:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.IDENTIFIER);
        break;
      case ROOT:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.ROOT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.NamingSystem.NamingSystemTypeEnumFactory());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
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
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String14_40.convertString(src.getValueElement()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean14_40.convertBoolean(src.getPreferredElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period14_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String14_40.convertString(src.getValueElement()));
    if (src.hasPreferred())
      tgt.setPreferredElement(Boolean14_40.convertBoolean(src.getPreferredElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period14_40.convertPeriod(src.getPeriod()));
    return tgt;
  }
}