package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Patient10_30 {

    public static org.hl7.fhir.dstu3.model.Patient.AnimalComponent convertAnimalComponent(org.hl7.fhir.dstu2.model.Patient.AnimalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Patient.AnimalComponent tgt = new org.hl7.fhir.dstu3.model.Patient.AnimalComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSpecies())
            tgt.setSpecies(VersionConvertor_10_30.convertCodeableConcept(src.getSpecies()));
        if (src.hasBreed())
            tgt.setBreed(VersionConvertor_10_30.convertCodeableConcept(src.getBreed()));
        if (src.hasGenderStatus())
            tgt.setGenderStatus(VersionConvertor_10_30.convertCodeableConcept(src.getGenderStatus()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient.AnimalComponent convertAnimalComponent(org.hl7.fhir.dstu3.model.Patient.AnimalComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient.AnimalComponent tgt = new org.hl7.fhir.dstu2.model.Patient.AnimalComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSpecies())
            tgt.setSpecies(VersionConvertor_10_30.convertCodeableConcept(src.getSpecies()));
        if (src.hasBreed())
            tgt.setBreed(VersionConvertor_10_30.convertCodeableConcept(src.getBreed()));
        if (src.hasGenderStatus())
            tgt.setGenderStatus(VersionConvertor_10_30.convertCodeableConcept(src.getGenderStatus()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.dstu2.model.Patient.ContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Patient.ContactComponent tgt = new org.hl7.fhir.dstu3.model.Patient.ContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getRelationship()) tgt.addRelationship(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setName(VersionConvertor_10_30.convertHumanName(src.getName()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_10_30.convertAddress(src.getAddress()));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_10_30.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_10_30.convertReference(src.getOrganization()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.dstu3.model.Patient.ContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient.ContactComponent tgt = new org.hl7.fhir.dstu2.model.Patient.ContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRelationship()) tgt.addRelationship(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setName(VersionConvertor_10_30.convertHumanName(src.getName()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_10_30.convertAddress(src.getAddress()));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_10_30.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_10_30.convertReference(src.getOrganization()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Patient.LinkType> convertLinkType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Patient.LinkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Patient.LinkType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Patient.LinkTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Patient.LinkType> convertLinkType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Patient.LinkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Patient.LinkType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Patient.LinkTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case REPLACE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Patient.LinkType.REPLACEDBY);
                break;
            case REFER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Patient.LinkType.REFER);
                break;
            case SEEALSO:
                tgt.setValue(org.hl7.fhir.dstu3.model.Patient.LinkType.SEEALSO);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Patient.LinkType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient convertPatient(org.hl7.fhir.dstu2.model.Patient src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Patient tgt = new org.hl7.fhir.dstu3.model.Patient();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasActiveElement())
            tgt.setActiveElement(VersionConvertor_10_30.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.dstu2.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_10_30.convertHumanName(t));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_10_30.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement(VersionConvertor_10_30.convertDate(src.getBirthDateElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_10_30.convertType(src.getDeceased()));
        for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_30.convertAddress(t));
        if (src.hasMaritalStatus())
            tgt.setMaritalStatus(VersionConvertor_10_30.convertCodeableConcept(src.getMaritalStatus()));
        if (src.hasMultipleBirth())
            tgt.setMultipleBirth(VersionConvertor_10_30.convertType(src.getMultipleBirth()));
        for (org.hl7.fhir.dstu2.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_30.convertAttachment(t));
        for (org.hl7.fhir.dstu2.model.Patient.ContactComponent t : src.getContact()) tgt.addContact(convertContactComponent(t));
        if (src.hasAnimal())
            tgt.setAnimal(convertAnimalComponent(src.getAnimal()));
        for (org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent t : src.getCommunication()) tgt.addCommunication(convertPatientCommunicationComponent(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getCareProvider()) tgt.addGeneralPractitioner(VersionConvertor_10_30.convertReference(t));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_10_30.convertReference(src.getManagingOrganization()));
        for (org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent t : src.getLink()) tgt.addLink(convertPatientLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient convertPatient(org.hl7.fhir.dstu3.model.Patient src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient tgt = new org.hl7.fhir.dstu2.model.Patient();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasActiveElement())
            tgt.setActiveElement(VersionConvertor_10_30.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_10_30.convertHumanName(t));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_10_30.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement(VersionConvertor_10_30.convertDate(src.getBirthDateElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_10_30.convertType(src.getDeceased()));
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_30.convertAddress(t));
        if (src.hasMaritalStatus())
            tgt.setMaritalStatus(VersionConvertor_10_30.convertCodeableConcept(src.getMaritalStatus()));
        if (src.hasMultipleBirth())
            tgt.setMultipleBirth(VersionConvertor_10_30.convertType(src.getMultipleBirth()));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_30.convertAttachment(t));
        for (org.hl7.fhir.dstu3.model.Patient.ContactComponent t : src.getContact()) tgt.addContact(convertContactComponent(t));
        if (src.hasAnimal())
            tgt.setAnimal(convertAnimalComponent(src.getAnimal()));
        for (org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent t : src.getCommunication()) tgt.addCommunication(convertPatientCommunicationComponent(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getGeneralPractitioner()) tgt.addCareProvider(VersionConvertor_10_30.convertReference(t));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_10_30.convertReference(src.getManagingOrganization()));
        for (org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent t : src.getLink()) tgt.addLink(convertPatientLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguage(VersionConvertor_10_30.convertCodeableConcept(src.getLanguage()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement(VersionConvertor_10_30.convertBoolean(src.getPreferredElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.dstu2.model.Patient.PatientCommunicationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguage(VersionConvertor_10_30.convertCodeableConcept(src.getLanguage()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement(VersionConvertor_10_30.convertBoolean(src.getPreferredElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOther())
            tgt.setOther(VersionConvertor_10_30.convertReference(src.getOther()));
        if (src.hasType())
            tgt.setTypeElement(convertLinkType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.dstu2.model.Patient.PatientLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOther())
            tgt.setOther(VersionConvertor_10_30.convertReference(src.getOther()));
        if (src.hasType())
            tgt.setTypeElement(convertLinkType(src.getTypeElement()));
        return tgt;
    }
}