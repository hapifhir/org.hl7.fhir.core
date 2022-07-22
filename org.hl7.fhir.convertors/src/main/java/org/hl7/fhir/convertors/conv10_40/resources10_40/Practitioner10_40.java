package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.*;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Date10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Practitioner10_40 {

  public static org.hl7.fhir.dstu2.model.Practitioner convertPractitioner(org.hl7.fhir.r4.model.Practitioner src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Practitioner tgt = new org.hl7.fhir.dstu2.model.Practitioner();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_40.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.setName(HumanName10_40.convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address10_40.convertAddress(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_40.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDateElement())
      tgt.setBirthDateElement(Date10_40.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment10_40.convertAttachment(t));
    for (org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent t : src.getQualification())
      tgt.addQualification(convertPractitionerQualificationComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCommunication())
      tgt.addCommunication(CodeableConcept10_40.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Practitioner convertPractitioner(org.hl7.fhir.dstu2.model.Practitioner src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Practitioner tgt = new org.hl7.fhir.r4.model.Practitioner();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_40.convertBoolean(src.getActiveElement()));
    if (src.hasName())
      tgt.addName(HumanName10_40.convertHumanName(src.getName()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
    for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(Address10_40.convertAddress(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_40.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDateElement())
      tgt.setBirthDateElement(Date10_40.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.dstu2.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment10_40.convertAttachment(t));
    for (org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent t : src.getQualification())
      tgt.addQualification(convertPractitionerQualificationComponent(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCommunication())
      tgt.addCommunication(CodeableConcept10_40.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasIssuer())
      tgt.setIssuer(Reference10_40.convertReference(src.getIssuer()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasIssuer())
      tgt.setIssuer(Reference10_40.convertReference(src.getIssuer()));
    return tgt;
  }
}