package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.*;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Date10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Person10_50 {

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Person.IdentityAssuranceLevelEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case LEVEL1:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL1);
        break;
      case LEVEL2:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL2);
        break;
      case LEVEL3:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL3);
        break;
      case LEVEL4:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.LEVEL4);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevelEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case LEVEL1:
        tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL1);
        break;
      case LEVEL2:
        tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL2);
        break;
      case LEVEL3:
        tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL3);
        break;
      case LEVEL4:
        tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL4);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Person convertPerson(org.hl7.fhir.dstu2.model.Person src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Person tgt = new org.hl7.fhir.r5.model.Person();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    for (org.hl7.fhir.dstu2.model.HumanName t : src.getName()) tgt.addName(HumanName10_50.convertHumanName(t));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDateElement())
      tgt.setBirthDateElement(Date10_50.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(Address10_50.convertAddress(t));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_50.convertAttachment(src.getPhoto()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_50.convertReference(src.getManagingOrganization()));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.dstu2.model.Person.PersonLinkComponent t : src.getLink())
      tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Person convertPerson(org.hl7.fhir.r5.model.Person src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Person tgt = new org.hl7.fhir.dstu2.model.Person();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.HumanName t : src.getName()) tgt.addName(HumanName10_50.convertHumanName(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_50.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDateElement())
      tgt.setBirthDateElement(Date10_50.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r5.model.Address t : src.getAddress()) tgt.addAddress(Address10_50.convertAddress(t));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_50.convertAttachment(src.getPhoto()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_50.convertReference(src.getManagingOrganization()));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_50.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r5.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r5.model.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.dstu2.model.Person.PersonLinkComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Reference10_50.convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.dstu2.model.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r5.model.Person.PersonLinkComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Reference10_50.convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
    return tgt;
  }
}