package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Patient30_50 {

    public static org.hl7.fhir.dstu3.model.Patient.AnimalComponent convertAnimalComponent(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Patient.AnimalComponent tgt = new org.hl7.fhir.dstu3.model.Patient.AnimalComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasExtension("species"))
            tgt.setSpecies(VersionConvertor_30_50.convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src.getExtensionByUrl("species").getValue()));
        if (src.hasExtension("breed"))
            tgt.setBreed(VersionConvertor_30_50.convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src.getExtensionByUrl("breed").getValue()));
        if (src.hasExtension("genderStatus"))
            tgt.setGenderStatus(VersionConvertor_30_50.convertCodeableConcept((org.hl7.fhir.r5.model.CodeableConcept) src.getExtensionByUrl("genderStatus").getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Extension convertAnimalComponent(org.hl7.fhir.dstu3.model.Patient.AnimalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Extension tgt = new org.hl7.fhir.r5.model.Extension();
        tgt.setUrl("http://hl7.org/fhir/StructureDefinition/patient-animal");
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSpecies())
            tgt.addExtension("species", VersionConvertor_30_50.convertCodeableConcept(src.getSpecies()));
        if (src.hasBreed())
            tgt.addExtension("breed", VersionConvertor_30_50.convertCodeableConcept(src.getBreed()));
        if (src.hasGenderStatus())
            tgt.addExtension("genderStatus", VersionConvertor_30_50.convertCodeableConcept(src.getGenderStatus()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.dstu3.model.Patient.ContactComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Patient.ContactComponent tgt = new org.hl7.fhir.r5.model.Patient.ContactComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRelationship()) tgt.addRelationship(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setName(VersionConvertor_30_50.convertHumanName(src.getName()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_30_50.convertAddress(src.getAddress()));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_30_50.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_50.convertReference(src.getOrganization()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r5.model.Patient.ContactComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Patient.ContactComponent tgt = new org.hl7.fhir.dstu3.model.Patient.ContactComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRelationship()) tgt.addRelationship(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setName(VersionConvertor_30_50.convertHumanName(src.getName()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_30_50.convertAddress(src.getAddress()));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_30_50.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_50.convertReference(src.getOrganization()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Patient.LinkType> convertLinkType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Patient.LinkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Patient.LinkType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Patient.LinkTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REPLACEDBY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Patient.LinkType.REPLACEDBY);
                break;
            case REPLACES:
                tgt.setValue(org.hl7.fhir.dstu3.model.Patient.LinkType.REPLACES);
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Patient.LinkType> convertLinkType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Patient.LinkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Patient.LinkType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Patient.LinkTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REPLACEDBY:
                tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.REPLACEDBY);
                break;
            case REPLACES:
                tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.REPLACES);
                break;
            case REFER:
                tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.REFER);
                break;
            case SEEALSO:
                tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.SEEALSO);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Patient.LinkType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Patient convertPatient(org.hl7.fhir.dstu3.model.Patient src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Patient tgt = new org.hl7.fhir.r5.model.Patient();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_30_50.convertHumanName(t));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_30_50.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(VersionConvertor_30_50.convertDate(src.getBirthDateElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_50.convertType(src.getDeceased()));
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_30_50.convertAddress(t));
        if (src.hasMaritalStatus())
            tgt.setMaritalStatus(VersionConvertor_30_50.convertCodeableConcept(src.getMaritalStatus()));
        if (src.hasMultipleBirth())
            tgt.setMultipleBirth(VersionConvertor_30_50.convertType(src.getMultipleBirth()));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_30_50.convertAttachment(t));
        for (org.hl7.fhir.dstu3.model.Patient.ContactComponent t : src.getContact()) tgt.addContact(convertContactComponent(t));
        if (src.hasAnimal())
            tgt.addExtension(convertAnimalComponent(src.getAnimal()));
        for (org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent t : src.getCommunication()) tgt.addCommunication(convertPatientCommunicationComponent(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getGeneralPractitioner()) tgt.addGeneralPractitioner(VersionConvertor_30_50.convertReference(t));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_50.convertReference(src.getManagingOrganization()));
        for (org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent t : src.getLink()) tgt.addLink(convertPatientLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient convertPatient(org.hl7.fhir.r5.model.Patient src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Patient tgt = new org.hl7.fhir.dstu3.model.Patient();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_50.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.r5.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_30_50.convertHumanName(t));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_30_50.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(VersionConvertor_30_50.convertDate(src.getBirthDateElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_50.convertType(src.getDeceased()));
        for (org.hl7.fhir.r5.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_30_50.convertAddress(t));
        if (src.hasMaritalStatus())
            tgt.setMaritalStatus(VersionConvertor_30_50.convertCodeableConcept(src.getMaritalStatus()));
        if (src.hasMultipleBirth())
            tgt.setMultipleBirth(VersionConvertor_30_50.convertType(src.getMultipleBirth()));
        for (org.hl7.fhir.r5.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_30_50.convertAttachment(t));
        for (org.hl7.fhir.r5.model.Patient.ContactComponent t : src.getContact()) tgt.addContact(convertContactComponent(t));
        if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/patient-animal"))
            tgt.setAnimal(convertAnimalComponent(src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/patient-animal")));
        for (org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent t : src.getCommunication()) tgt.addCommunication(convertPatientCommunicationComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getGeneralPractitioner()) tgt.addGeneralPractitioner(VersionConvertor_30_50.convertReference(t));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_50.convertReference(src.getManagingOrganization()));
        for (org.hl7.fhir.r5.model.Patient.PatientLinkComponent t : src.getLink()) tgt.addLink(convertPatientLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguage(VersionConvertor_30_50.convertCodeableConcept(src.getLanguage()));
        if (src.hasPreferred())
            tgt.setPreferredElement(VersionConvertor_30_50.convertBoolean(src.getPreferredElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r5.model.Patient.PatientCommunicationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguage(VersionConvertor_30_50.convertCodeableConcept(src.getLanguage()));
        if (src.hasPreferred())
            tgt.setPreferredElement(VersionConvertor_30_50.convertBoolean(src.getPreferredElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r5.model.Patient.PatientLinkComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasOther())
            tgt.setOther(VersionConvertor_30_50.convertReference(src.getOther()));
        if (src.hasType())
            tgt.setTypeElement(convertLinkType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r5.model.Patient.PatientLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasOther())
            tgt.setOther(VersionConvertor_30_50.convertReference(src.getOther()));
        if (src.hasType())
            tgt.setTypeElement(convertLinkType(src.getTypeElement()));
        return tgt;
    }
}