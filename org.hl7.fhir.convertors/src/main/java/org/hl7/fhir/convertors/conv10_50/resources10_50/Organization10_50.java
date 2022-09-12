package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Address10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.HumanName10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.ExtendedContactDetail;

public class Organization10_50 {

  public static org.hl7.fhir.r5.model.Organization convertOrganization(org.hl7.fhir.dstu2.model.Organization src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Organization tgt = new org.hl7.fhir.r5.model.Organization();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_50.convertBoolean(src.getActiveElement()));
    if (src.hasType())
      tgt.addType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addContact().setAddress(Address10_50.convertAddress(t));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.getContactFirstRep().addTelecom(ContactPoint10_50.convertContactPoint(t));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_50.convertReference(src.getPartOf()));
    for (org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent t : src.getContact())
      tgt.addContact(convertOrganizationContactComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Organization convertOrganization(org.hl7.fhir.r5.model.Organization src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Organization tgt = new org.hl7.fhir.dstu2.model.Organization();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_50.convertBoolean(src.getActiveElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getTypeFirstRep()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    for (ExtendedContactDetail t1 : src.getContact())
      for (org.hl7.fhir.r5.model.ContactPoint t : t1.getTelecom())
        tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    for (ExtendedContactDetail t : src.getContact())
      if (t.hasAddress())
        tgt.addAddress(Address10_50.convertAddress(t.getAddress()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_50.convertReference(src.getPartOf()));
    for (org.hl7.fhir.r5.model.ExtendedContactDetail t : src.getContact())
      tgt.addContact(convertOrganizationContactComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.r5.model.ExtendedContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept10_50.convertCodeableConcept(src.getPurpose()));
    for (org.hl7.fhir.r5.model.HumanName t : src.getName())
      tgt.setName(HumanName10_50.convertHumanName(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address10_50.convertAddress(src.getAddress()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ExtendedContactDetail convertOrganizationContactComponent(org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ExtendedContactDetail tgt = new org.hl7.fhir.r5.model.ExtendedContactDetail();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept10_50.convertCodeableConcept(src.getPurpose()));
    if (src.hasName())
      tgt.addName(HumanName10_50.convertHumanName(src.getName()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address10_50.convertAddress(src.getAddress()));
    return tgt;
  }
}