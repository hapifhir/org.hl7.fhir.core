package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Address10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Attachment10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.ContactPoint10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.HumanName10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Period10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Date10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Patient10_40 {

  public static org.hl7.fhir.r4.model.Extension convertAnimalComponent(org.hl7.fhir.dstu2.model.Patient.AnimalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
    tgt.setUrl("http://hl7.org/fhir/StructureDefinition/patient-animal");
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasSpecies())
      tgt.addExtension("species", CodeableConcept10_40.convertCodeableConcept(src.getSpecies()));
    if (src.hasBreed())
      tgt.addExtension("breed", CodeableConcept10_40.convertCodeableConcept(src.getBreed()));
    if (src.hasGenderStatus())
      tgt.addExtension("genderStatus", CodeableConcept10_40.convertCodeableConcept(src.getGenderStatus()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Patient.AnimalComponent convertAnimalComponent(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Patient.AnimalComponent tgt = new org.hl7.fhir.dstu2.model.Patient.AnimalComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasExtension("species"))
      tgt.setSpecies(CodeableConcept10_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("species").getValue()));
    if (src.hasExtension("breed"))
      tgt.setBreed(CodeableConcept10_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("breed").getValue()));
    if (src.hasExtension("genderStatus"))
      tgt.setGenderStatus(CodeableConcept10_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("genderStatus").getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.dstu2.model.Patient.ContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Patient.ContactComponent tgt = new org.hl7.fhir.r4.model.Patient.ContactComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(HumanName10_40.convertHumanName(src.getName()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address10_40.convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_40.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference10_40.convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r4.model.Patient.ContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Patient.ContactComponent tgt = new org.hl7.fhir.dstu2.model.Patient.ContactComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRelationship())
      tgt.addRelationship(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setName(HumanName10_40.convertHumanName(src.getName()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
    if (src.hasAddress())
      tgt.setAddress(Address10_40.convertAddress(src.getAddress()));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_40.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasOrganization())
      tgt.setOrganization(Reference10_40.convertReference(src.getOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Patient.LinkType> convertLinkType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Patient.LinkType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Patient.LinkType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Patient.LinkTypeEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACE:
        tgt.setValue(org.hl7.fhir.r4.model.Patient.LinkType.REPLACEDBY);
        break;
      case REFER:
        tgt.setValue(org.hl7.fhir.r4.model.Patient.LinkType.REFER);
        break;
      case SEEALSO:
        tgt.setValue(org.hl7.fhir.r4.model.Patient.LinkType.SEEALSO);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Patient.LinkType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Patient.LinkType> convertLinkType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Patient.LinkType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Patient.LinkType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Patient.LinkTypeEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACEDBY:
        tgt.setValue(org.hl7.fhir.dstu2.model.Patient.LinkType.REPLACE);
        break;
      case REPLACES:
        tgt.setValue(org.hl7.fhir.dstu2.model.Patient.LinkType.REPLACE);
        break;
      case REFER:
        tgt.setValue(org.hl7.fhir.dstu2.model.Patient.LinkType.REFER);
        break;
      case SEEALSO:
        tgt.setValue(org.hl7.fhir.dstu2.model.Patient.LinkType.SEEALSO);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Patient.LinkType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient convertPatient(org.hl7.fhir.dstu2.model.Patient src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Patient tgt = new org.hl7.fhir.r4.model.Patient();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_40.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.dstu2.model.HumanName t : src.getName()) tgt.addName(HumanName10_40.convertHumanName(t));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_40.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDateElement())
      tgt.setBirthDateElement(Date10_40.convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getDeceased()));
    for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(Address10_40.convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(CodeableConcept10_40.convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.dstu2.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment10_40.convertAttachment(t));
    for (org.hl7.fhir.dstu2.model.Patient.ContactComponent t : src.getContact())
      tgt.addContact(convertContactComponent(t));
    if (src.hasAnimal())
      tgt.addExtension(convertAnimalComponent(src.getAnimal()));
    for (org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getCareProvider())
      tgt.addGeneralPractitioner(Reference10_40.convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_40.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent t : src.getLink())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Patient convertPatient(org.hl7.fhir.r4.model.Patient src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Patient tgt = new org.hl7.fhir.dstu2.model.Patient();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasActiveElement())
      tgt.setActiveElement(Boolean10_40.convertBoolean(src.getActiveElement()));
    for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(HumanName10_40.convertHumanName(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
    if (src.hasGender())
      tgt.setGenderElement(Enumerations10_40.convertAdministrativeGender(src.getGenderElement()));
    if (src.hasBirthDateElement())
      tgt.setBirthDateElement(Date10_40.convertDate(src.getBirthDateElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getDeceased()));
    for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address10_40.convertAddress(t));
    if (src.hasMaritalStatus())
      tgt.setMaritalStatus(CodeableConcept10_40.convertCodeableConcept(src.getMaritalStatus()));
    if (src.hasMultipleBirth())
      tgt.setMultipleBirth(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getMultipleBirth()));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment10_40.convertAttachment(t));
    for (org.hl7.fhir.r4.model.Patient.ContactComponent t : src.getContact())
      tgt.addContact(convertContactComponent(t));
    if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/patient-animal"))
      tgt.setAnimal(convertAnimalComponent(src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/patient-animal")));
    for (org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent t : src.getCommunication())
      tgt.addCommunication(convertPatientCommunicationComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getGeneralPractitioner())
      tgt.addCareProvider(Reference10_40.convertReference(t));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference10_40.convertReference(src.getManagingOrganization()));
    for (org.hl7.fhir.r4.model.Patient.PatientLinkComponent t : src.getLink())
      tgt.addLink(convertPatientLinkComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept10_40.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferredElement())
      tgt.setPreferredElement(Boolean10_40.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasLanguage())
      tgt.setLanguage(CodeableConcept10_40.convertCodeableConcept(src.getLanguage()));
    if (src.hasPreferredElement())
      tgt.setPreferredElement(Boolean10_40.convertBoolean(src.getPreferredElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r4.model.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasOther())
      tgt.setOther(Reference10_40.convertReference(src.getOther()));
    if (src.hasType())
      tgt.setTypeElement(convertLinkType(src.getTypeElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientLinkComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasOther())
      tgt.setOther(Reference10_40.convertReference(src.getOther()));
    if (src.hasType())
      tgt.setTypeElement(convertLinkType(src.getTypeElement()));
    return tgt;
  }
}