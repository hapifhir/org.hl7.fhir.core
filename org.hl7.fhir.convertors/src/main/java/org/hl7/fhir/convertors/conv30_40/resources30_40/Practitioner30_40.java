package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Date30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Practitioner30_40 {

  public static org.hl7.fhir.r4.model.Practitioner convertPractitioner(org.hl7.fhir.dstu3.model.Practitioner src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Practitioner tgt = new org.hl7.fhir.r4.model.Practitioner();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) tgt.addName(HumanName30_40.convertHumanName(t));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
    for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(Address30_40.convertAddress(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations30_40.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date30_40.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment30_40.convertAttachment(t));
    for (org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent t : src.getQualification())
      tgt.addQualification(convertPractitionerQualificationComponent(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCommunication())
      tgt.addCommunication(CodeableConcept30_40.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Practitioner convertPractitioner(org.hl7.fhir.r4.model.Practitioner src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Practitioner tgt = new org.hl7.fhir.dstu3.model.Practitioner();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(HumanName30_40.convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address30_40.convertAddress(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations30_40.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDate())
      tgt.setBirthDateElement(Date30_40.convertDate(src.getBirthDateElement()));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment30_40.convertAttachment(t));
    for (org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent t : src.getQualification())
      tgt.addQualification(convertPractitionerQualificationComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCommunication())
      tgt.addCommunication(CodeableConcept30_40.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    if (src.hasIssuer())
      tgt.setIssuer(Reference30_40.convertReference(src.getIssuer()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    if (src.hasIssuer())
      tgt.setIssuer(Reference30_40.convertReference(src.getIssuer()));
    return tgt;
  }
}