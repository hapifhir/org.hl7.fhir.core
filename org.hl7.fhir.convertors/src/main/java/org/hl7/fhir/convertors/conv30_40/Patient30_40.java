package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Patient30_40 {

    public static org.hl7.fhir.dstu3.model.Patient.AnimalComponent convertAnimalComponent(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Patient.AnimalComponent tgt = new org.hl7.fhir.dstu3.model.Patient.AnimalComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasExtension("species"))
            tgt.setSpecies(VersionConvertor_30_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("species").getValue()));
        if (src.hasExtension("breed"))
            tgt.setBreed(VersionConvertor_30_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("breed").getValue()));
        if (src.hasExtension("genderStatus"))
            tgt.setGenderStatus(VersionConvertor_30_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl("genderStatus").getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Extension convertAnimalComponent(org.hl7.fhir.dstu3.model.Patient.AnimalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Extension tgt = new org.hl7.fhir.r4.model.Extension();
        tgt.setUrl("http://hl7.org/fhir/StructureDefinition/patient-animal");
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasSpecies())
            tgt.addExtension("species", VersionConvertor_30_40.convertCodeableConcept(src.getSpecies()));
        if (src.hasBreed())
            tgt.addExtension("breed", VersionConvertor_30_40.convertCodeableConcept(src.getBreed()));
        if (src.hasGenderStatus())
            tgt.addExtension("genderStatus", VersionConvertor_30_40.convertCodeableConcept(src.getGenderStatus()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.dstu3.model.Patient.ContactComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Patient.ContactComponent tgt = new org.hl7.fhir.r4.model.Patient.ContactComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRelationship()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRelationship()) tgt.addRelationship(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasName())
            tgt.setName(VersionConvertor_30_40.convertHumanName(src.getName()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_30_40.convertAddress(src.getAddress()));
        if (src.hasGender())
            tgt.setGender(VersionConvertor_30_40.convertAdministrativeGender(src.getGender()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_40.convertReference(src.getOrganization()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient.ContactComponent convertContactComponent(org.hl7.fhir.r4.model.Patient.ContactComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Patient.ContactComponent tgt = new org.hl7.fhir.dstu3.model.Patient.ContactComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRelationship()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRelationship()) tgt.addRelationship(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasName())
            tgt.setName(VersionConvertor_30_40.convertHumanName(src.getName()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_30_40.convertAddress(src.getAddress()));
        if (src.hasGender())
            tgt.setGender(VersionConvertor_30_40.convertAdministrativeGender(src.getGender()));
        if (src.hasOrganization())
            tgt.setOrganization(VersionConvertor_30_40.convertReference(src.getOrganization()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Patient.LinkType convertLinkType(org.hl7.fhir.r4.model.Patient.LinkType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REPLACEDBY:
                return org.hl7.fhir.dstu3.model.Patient.LinkType.REPLACEDBY;
            case REPLACES:
                return org.hl7.fhir.dstu3.model.Patient.LinkType.REPLACES;
            case REFER:
                return org.hl7.fhir.dstu3.model.Patient.LinkType.REFER;
            case SEEALSO:
                return org.hl7.fhir.dstu3.model.Patient.LinkType.SEEALSO;
            default:
                return org.hl7.fhir.dstu3.model.Patient.LinkType.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Patient.LinkType convertLinkType(org.hl7.fhir.dstu3.model.Patient.LinkType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REPLACEDBY:
                return org.hl7.fhir.r4.model.Patient.LinkType.REPLACEDBY;
            case REPLACES:
                return org.hl7.fhir.r4.model.Patient.LinkType.REPLACES;
            case REFER:
                return org.hl7.fhir.r4.model.Patient.LinkType.REFER;
            case SEEALSO:
                return org.hl7.fhir.r4.model.Patient.LinkType.SEEALSO;
            default:
                return org.hl7.fhir.r4.model.Patient.LinkType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Patient convertPatient(org.hl7.fhir.r4.model.Patient src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Patient tgt = new org.hl7.fhir.dstu3.model.Patient();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasActiveElement())
            tgt.setActiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getActiveElement()));
        if (src.hasName()) {
            for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_30_40.convertHumanName(t));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasGender())
            tgt.setGender(VersionConvertor_30_40.convertAdministrativeGender(src.getGender()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(VersionConvertor_30_40.convertDate(src.getBirthDateElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_40.convertType(src.getDeceased()));
        if (src.hasAddress()) {
            for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_30_40.convertAddress(t));
        }
        if (src.hasMaritalStatus())
            tgt.setMaritalStatus(VersionConvertor_30_40.convertCodeableConcept(src.getMaritalStatus()));
        if (src.hasMultipleBirth())
            tgt.setMultipleBirth(VersionConvertor_30_40.convertType(src.getMultipleBirth()));
        if (src.hasPhoto()) {
            for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_30_40.convertAttachment(t));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.Patient.ContactComponent t : src.getContact()) tgt.addContact(convertContactComponent(t));
        }
        if (src.hasExtension("http://hl7.org/fhir/StructureDefinition/patient-animal"))
            tgt.setAnimal(convertAnimalComponent(src.getExtensionByUrl("http://hl7.org/fhir/StructureDefinition/patient-animal")));
        if (src.hasCommunication()) {
            for (org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent t : src.getCommunication()) tgt.addCommunication(convertPatientCommunicationComponent(t));
        }
        if (src.hasGeneralPractitioner()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getGeneralPractitioner()) tgt.addGeneralPractitioner(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_40.convertReference(src.getManagingOrganization()));
        if (src.hasLink()) {
            for (org.hl7.fhir.r4.model.Patient.PatientLinkComponent t : src.getLink()) tgt.addLink(convertPatientLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Patient convertPatient(org.hl7.fhir.dstu3.model.Patient src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Patient tgt = new org.hl7.fhir.r4.model.Patient();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasActiveElement())
            tgt.setActiveElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getActiveElement()));
        if (src.hasName()) {
            for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_30_40.convertHumanName(t));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasGender())
            tgt.setGender(VersionConvertor_30_40.convertAdministrativeGender(src.getGender()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(VersionConvertor_30_40.convertDate(src.getBirthDateElement()));
        if (src.hasDeceased())
            tgt.setDeceased(VersionConvertor_30_40.convertType(src.getDeceased()));
        if (src.hasAddress()) {
            for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_30_40.convertAddress(t));
        }
        if (src.hasMaritalStatus())
            tgt.setMaritalStatus(VersionConvertor_30_40.convertCodeableConcept(src.getMaritalStatus()));
        if (src.hasMultipleBirth())
            tgt.setMultipleBirth(VersionConvertor_30_40.convertType(src.getMultipleBirth()));
        if (src.hasPhoto()) {
            for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_30_40.convertAttachment(t));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.Patient.ContactComponent t : src.getContact()) tgt.addContact(convertContactComponent(t));
        }
        if (src.hasAnimal())
            tgt.addExtension(convertAnimalComponent(src.getAnimal()));
        if (src.hasCommunication()) {
            for (org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent t : src.getCommunication()) tgt.addCommunication(convertPatientCommunicationComponent(t));
        }
        if (src.hasGeneralPractitioner()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getGeneralPractitioner()) tgt.addGeneralPractitioner(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_40.convertReference(src.getManagingOrganization()));
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent t : src.getLink()) tgt.addLink(convertPatientLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguage(VersionConvertor_30_40.convertCodeableConcept(src.getLanguage()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getPreferredElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent convertPatientCommunicationComponent(org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLanguage())
            tgt.setLanguage(VersionConvertor_30_40.convertCodeableConcept(src.getLanguage()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getPreferredElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.r4.model.Patient.PatientLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasOther())
            tgt.setOther(VersionConvertor_30_40.convertReference(src.getOther()));
        if (src.hasType())
            tgt.setType(convertLinkType(src.getType()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Patient.PatientLinkComponent convertPatientLinkComponent(org.hl7.fhir.dstu3.model.Patient.PatientLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Patient.PatientLinkComponent tgt = new org.hl7.fhir.r4.model.Patient.PatientLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasOther())
            tgt.setOther(VersionConvertor_30_40.convertReference(src.getOther()));
        if (src.hasType())
            tgt.setType(convertLinkType(src.getType()));
        return tgt;
    }
}
