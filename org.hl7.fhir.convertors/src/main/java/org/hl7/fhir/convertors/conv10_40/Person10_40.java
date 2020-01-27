package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Person10_40 {

    public static org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel convertIdentityAssuranceLevel(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LEVEL1:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL1;
            case LEVEL2:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL2;
            case LEVEL3:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL3;
            case LEVEL4:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL4;
            default:
                return org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel convertIdentityAssuranceLevel(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LEVEL1:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL1;
            case LEVEL2:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL2;
            case LEVEL3:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL3;
            case LEVEL4:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL4;
            default:
                return org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Person convertPerson(org.hl7.fhir.dstu2.model.Person src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Person tgt = new org.hl7.fhir.r4.model.Person();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu2.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_10_40.convertHumanName(t));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        tgt.setGender(VersionConvertor_10_40.convertAdministrativeGender(src.getGender()));
        tgt.setBirthDate(src.getBirthDate());
        for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        tgt.setPhoto(VersionConvertor_10_40.convertAttachment(src.getPhoto()));
        tgt.setManagingOrganization(VersionConvertor_10_40.convertReference(src.getManagingOrganization()));
        tgt.setActive(src.getActive());
        for (org.hl7.fhir.dstu2.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Person convertPerson(org.hl7.fhir.r4.model.Person src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Person tgt = new org.hl7.fhir.dstu2.model.Person();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_10_40.convertHumanName(t));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        tgt.setGender(VersionConvertor_10_40.convertAdministrativeGender(src.getGender()));
        tgt.setBirthDate(src.getBirthDate());
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        tgt.setPhoto(VersionConvertor_10_40.convertAttachment(src.getPhoto()));
        tgt.setManagingOrganization(VersionConvertor_10_40.convertReference(src.getManagingOrganization()));
        tgt.setActive(src.getActive());
        for (org.hl7.fhir.r4.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r4.model.Person.PersonLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.dstu2.model.Person.PersonLinkComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setTarget(VersionConvertor_10_40.convertReference(src.getTarget()));
        tgt.setAssurance(convertIdentityAssuranceLevel(src.getAssurance()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.dstu2.model.Person.PersonLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r4.model.Person.PersonLinkComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setTarget(VersionConvertor_10_40.convertReference(src.getTarget()));
        tgt.setAssurance(convertIdentityAssuranceLevel(src.getAssurance()));
        return tgt;
    }
}
