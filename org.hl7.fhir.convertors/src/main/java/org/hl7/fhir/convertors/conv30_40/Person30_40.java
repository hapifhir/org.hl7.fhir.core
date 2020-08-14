package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Person30_40 {

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Person.IdentityAssuranceLevelEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case LEVEL1:
                tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL1);
                break;
            case LEVEL2:
                tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL2);
                break;
            case LEVEL3:
                tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL3);
                break;
            case LEVEL4:
                tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.LEVEL4);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Person.IdentityAssuranceLevelEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
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

    public static org.hl7.fhir.r4.model.Person convertPerson(org.hl7.fhir.dstu3.model.Person src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Person tgt = new org.hl7.fhir.r4.model.Person();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_30_40.convertHumanName(t));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_30_40.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(VersionConvertor_30_40.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_30_40.convertAddress(t));
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_30_40.convertAttachment(src.getPhoto()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_40.convertReference(src.getManagingOrganization()));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_40.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.dstu3.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Person convertPerson(org.hl7.fhir.r4.model.Person src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Person tgt = new org.hl7.fhir.dstu3.model.Person();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_30_40.convertHumanName(t));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_30_40.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(VersionConvertor_30_40.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_30_40.convertAddress(t));
        if (src.hasPhoto())
            tgt.setPhoto(VersionConvertor_30_40.convertAttachment(src.getPhoto()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_40.convertReference(src.getManagingOrganization()));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_40.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.r4.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.dstu3.model.Person.PersonLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r4.model.Person.PersonLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_40.convertReference(src.getTarget()));
        if (src.hasAssurance())
            tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r4.model.Person.PersonLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.dstu3.model.Person.PersonLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_40.convertReference(src.getTarget()));
        if (src.hasAssurance())
            tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
        return tgt;
    }
}