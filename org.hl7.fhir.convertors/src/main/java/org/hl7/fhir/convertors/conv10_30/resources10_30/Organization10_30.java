package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.*;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Organization10_30 {

  public static org.hl7.fhir.dstu3.model.Organization convertOrganization(org.hl7.fhir.dstu2.model.Organization src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Organization tgt = new org.hl7.fhir.dstu3.model.Organization();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_30.convertBoolean(src.getActiveElement()));
    if (src.hasType())
      tgt.addType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(Address10_30.convertAddress(t));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_30.convertReference(src.getPartOf()));
    for (org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent t : src.getContact())
      tgt.addContact(convertOrganizationContactComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Organization convertOrganization(org.hl7.fhir.dstu3.model.Organization src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Organization tgt = new org.hl7.fhir.dstu2.model.Organization();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_30.convertBoolean(src.getActiveElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getTypeFirstRep()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(Address10_30.convertAddress(t));
    if (src.hasPartOf())
      tgt.setPartOf(Reference10_30.convertReference(src.getPartOf()));
    for (org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent t : src.getContact())
      tgt.addContact(convertOrganizationContactComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept10_30.convertCodeableConcept(src.getPurpose()));
    if (src.hasName())
      tgt.setName(HumanName10_30.convertHumanName(src.getName()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address10_30.convertAddress(src.getAddress()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasPurpose())
      tgt.setPurpose(CodeableConcept10_30.convertCodeableConcept(src.getPurpose()));
    if (src.hasName())
      tgt.setName(HumanName10_30.convertHumanName(src.getName()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address10_30.convertAddress(src.getAddress()));
    return tgt;
  }
}