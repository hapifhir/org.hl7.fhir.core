package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.*;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Date10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Person10_30 {

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevelEnumFactory());
    Element10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case LEVEL1:
        tgt.setValue(org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel.LEVEL1);
        break;
      case LEVEL2:
        tgt.setValue(org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel.LEVEL2);
        break;
      case LEVEL3:
        tgt.setValue(org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel.LEVEL3);
        break;
      case LEVEL4:
        tgt.setValue(org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel.LEVEL4);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevelEnumFactory());
    Element10_30.copyElement(src, tgt);
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

  public static org.hl7.fhir.dstu3.model.Person convertPerson(org.hl7.fhir.dstu2.model.Person src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Person tgt = new org.hl7.fhir.dstu3.model.Person();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    for (org.hl7.fhir.dstu2.model.HumanName t : src.getName()) tgt.addName(HumanName10_30.convertHumanName(t));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_30.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDateElement())
      tgt.setBirthDateElement(Date10_30.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(Address10_30.convertAddress(t));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_30.convertAttachment(src.getPhoto()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_30.convertReference(src.getManagingOrganization()));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_30.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.dstu2.model.Person.PersonLinkComponent t : src.getLink())
      tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Person convertPerson(org.hl7.fhir.dstu3.model.Person src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Person tgt = new org.hl7.fhir.dstu2.model.Person();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) tgt.addName(HumanName10_30.convertHumanName(t));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_30.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDateElement())
      tgt.setBirthDateElement(Date10_30.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(Address10_30.convertAddress(t));
    if (src.hasPhoto())
      tgt.setPhoto(Attachment10_30.convertAttachment(src.getPhoto()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_30.convertReference(src.getManagingOrganization()));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_30.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.dstu3.model.Person.PersonLinkComponent t : src.getLink())
      tgt.addLink(convertPersonLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.dstu2.model.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.dstu3.model.Person.PersonLinkComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Reference10_30.convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.dstu3.model.Person.PersonLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.dstu2.model.Person.PersonLinkComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasTarget())
      tgt.setTarget(Reference10_30.convertReference(src.getTarget()));
    if (src.hasAssurance())
      tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
    return tgt;
  }
}