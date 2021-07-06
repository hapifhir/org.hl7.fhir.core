package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.*;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Organization10_40 {

    public static org.hl7.fhir.r4.model.Organization convertOrganization(org.hl7.fhir.dstu2.model.Organization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Organization tgt = new org.hl7.fhir.r4.model.Organization();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasActiveElement())
            tgt.setActiveElement(Boolean10_40.convertBoolean(src.getActiveElement()));
        if (src.hasType())
            tgt.addType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(Address10_40.convertAddress(t));
        if (src.hasPartOf())
            tgt.setPartOf(Reference10_40.convertReference(src.getPartOf()));
        for (org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Organization convertOrganization(org.hl7.fhir.r4.model.Organization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Organization tgt = new org.hl7.fhir.dstu2.model.Organization();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasActiveElement())
            tgt.setActiveElement(Boolean10_40.convertBoolean(src.getActiveElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept10_40.convertCodeableConcept(src.getTypeFirstRep()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address10_40.convertAddress(t));
        if (src.hasPartOf())
            tgt.setPartOf(Reference10_40.convertReference(src.getPartOf()));
        for (org.hl7.fhir.r4.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.r4.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasPurpose())
            tgt.setPurpose(CodeableConcept10_40.convertCodeableConcept(src.getPurpose()));
        if (src.hasName())
            tgt.setName(HumanName10_40.convertHumanName(src.getName()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(Address10_40.convertAddress(src.getAddress()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.r4.model.Organization.OrganizationContactComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasPurpose())
            tgt.setPurpose(CodeableConcept10_40.convertCodeableConcept(src.getPurpose()));
        if (src.hasName())
            tgt.setName(HumanName10_40.convertHumanName(src.getName()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_40.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(Address10_40.convertAddress(src.getAddress()));
        return tgt;
    }
}