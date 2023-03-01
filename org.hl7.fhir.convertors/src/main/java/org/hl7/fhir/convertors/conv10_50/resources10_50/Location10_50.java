package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Address10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Decimal10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ContactPoint;
import org.hl7.fhir.r5.model.ExtendedContactDetail;

public class Location10_50 {

  public static org.hl7.fhir.dstu2.model.Location convertLocation(org.hl7.fhir.r5.model.Location src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Location tgt = new org.hl7.fhir.dstu2.model.Location();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertLocationStatus(src.getStatusElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    if (src.hasMode())
      tgt.setModeElement(convertLocationMode(src.getModeElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getTypeFirstRep()));
    for (ExtendedContactDetail t1 : src.getContact())
      for (ContactPoint t : t1.getTelecom())
        tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address10_50.convertAddress(src.getAddress()));
    if (src.hasForm())
      tgt.setPhysicalType(CodeableConcept10_50.convertCodeableConcept(src.getForm()));
    if (src.hasPosition())
      tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_50.convertReference(src.getManagingOrganization()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_50.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Location convertLocation(org.hl7.fhir.dstu2.model.Location src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Location tgt = new org.hl7.fhir.r5.model.Location();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertLocationStatus(src.getStatusElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasMode())
      tgt.setModeElement(convertLocationMode(src.getModeElement()));
    if (src.hasType())
      tgt.addType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint10_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address10_50.convertAddress(src.getAddress()));
    if (src.hasPhysicalType())
      tgt.setForm(CodeableConcept10_50.convertCodeableConcept(src.getPhysicalType()));
    if (src.hasPosition())
      tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_50.convertReference(src.getManagingOrganization()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_50.convertReference(src.getPartOf()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationMode> convertLocationMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Location.LocationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Location.LocationModeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationMode.INSTANCE);
        break;
      case KIND:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationMode.KIND);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Location.LocationMode> convertLocationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Location.LocationMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Location.LocationModeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Location.LocationMode.INSTANCE);
        break;
      case KIND:
        tgt.setValue(org.hl7.fhir.dstu2.model.Location.LocationMode.KIND);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Location.LocationMode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.dstu2.model.Location.LocationPositionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.r5.model.Location.LocationPositionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLongitudeElement())
      tgt.setLongitudeElement(Decimal10_50.convertDecimal(src.getLongitudeElement()));
    if (src.hasLatitudeElement())
      tgt.setLatitudeElement(Decimal10_50.convertDecimal(src.getLatitudeElement()));
    if (src.hasAltitudeElement())
      tgt.setAltitudeElement(Decimal10_50.convertDecimal(src.getAltitudeElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.r5.model.Location.LocationPositionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.dstu2.model.Location.LocationPositionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLongitudeElement())
      tgt.setLongitudeElement(Decimal10_50.convertDecimal(src.getLongitudeElement()));
    if (src.hasLatitudeElement())
      tgt.setLatitudeElement(Decimal10_50.convertDecimal(src.getLatitudeElement()));
    if (src.hasAltitudeElement())
      tgt.setAltitudeElement(Decimal10_50.convertDecimal(src.getAltitudeElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Location.LocationStatus> convertLocationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Location.LocationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Location.LocationStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Location.LocationStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Location.LocationStatus.SUSPENDED);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Location.LocationStatus.INACTIVE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Location.LocationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> convertLocationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Location.LocationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Location.LocationStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.SUSPENDED);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.INACTIVE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.NULL);
        break;
    }
    return tgt;
  }
}