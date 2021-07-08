package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.*;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Date10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Person10_40 {

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Person.IdentityAssuranceLevelEnumFactory());
        Element10_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel> convertIdentityAssuranceLevel(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Person.IdentityAssuranceLevel> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevelEnumFactory());
        Element10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case LEVEL1:
                tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL1);
                break;
            case LEVEL2:
                tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL2);
                break;
            case LEVEL3:
                tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL3);
                break;
            case LEVEL4:
                tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.LEVEL4);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Person.IdentityAssuranceLevel.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Person convertPerson(org.hl7.fhir.dstu2.model.Person src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Person tgt = new org.hl7.fhir.r4.model.Person();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu2.model.HumanName t : src.getName()) tgt.addName(HumanName10_40.convertHumanName(t));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations10_40.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement(Date10_40.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(Address10_40.convertAddress(t));
        if (src.hasPhoto())
            tgt.setPhoto(Attachment10_40.convertAttachment(src.getPhoto()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(Reference10_40.convertReference(src.getManagingOrganization()));
        if (src.hasActiveElement())
            tgt.setActiveElement(Boolean10_40.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.dstu2.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Person convertPerson(org.hl7.fhir.r4.model.Person src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Person tgt = new org.hl7.fhir.dstu2.model.Person();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(HumanName10_40.convertHumanName(t));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations10_40.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement(Date10_40.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address10_40.convertAddress(t));
        if (src.hasPhoto())
            tgt.setPhoto(Attachment10_40.convertAttachment(src.getPhoto()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(Reference10_40.convertReference(src.getManagingOrganization()));
        if (src.hasActiveElement())
            tgt.setActiveElement(Boolean10_40.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.r4.model.Person.PersonLinkComponent t : src.getLink()) tgt.addLink(convertPersonLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.r4.model.Person.PersonLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.dstu2.model.Person.PersonLinkComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasTarget())
            tgt.setTarget(Reference10_40.convertReference(src.getTarget()));
        if (src.hasAssurance())
            tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Person.PersonLinkComponent convertPersonLinkComponent(org.hl7.fhir.dstu2.model.Person.PersonLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Person.PersonLinkComponent tgt = new org.hl7.fhir.r4.model.Person.PersonLinkComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasTarget())
            tgt.setTarget(Reference10_40.convertReference(src.getTarget()));
        if (src.hasAssurance())
            tgt.setAssuranceElement(convertIdentityAssuranceLevel(src.getAssuranceElement()));
        return tgt;
    }
}