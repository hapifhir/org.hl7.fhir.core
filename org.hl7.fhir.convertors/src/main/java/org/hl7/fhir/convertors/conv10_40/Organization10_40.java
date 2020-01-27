package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Organization10_40 {

    public static org.hl7.fhir.r4.model.Organization convertOrganization(org.hl7.fhir.dstu2.model.Organization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Organization tgt = new org.hl7.fhir.r4.model.Organization();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setActive(src.getActive());
        tgt.addType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        tgt.setPartOf(VersionConvertor_10_40.convertReference(src.getPartOf()));
        for (org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Organization convertOrganization(org.hl7.fhir.r4.model.Organization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Organization tgt = new org.hl7.fhir.dstu2.model.Organization();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setActive(src.getActive());
        tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getTypeFirstRep()));
        tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        tgt.setPartOf(VersionConvertor_10_40.convertReference(src.getPartOf()));
        for (org.hl7.fhir.r4.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.r4.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setPurpose(VersionConvertor_10_40.convertCodeableConcept(src.getPurpose()));
        tgt.setName(VersionConvertor_10_40.convertHumanName(src.getName()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        tgt.setAddress(VersionConvertor_10_40.convertAddress(src.getAddress()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.r4.model.Organization.OrganizationContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setPurpose(VersionConvertor_10_40.convertCodeableConcept(src.getPurpose()));
        tgt.setName(VersionConvertor_10_40.convertHumanName(src.getName()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        tgt.setAddress(VersionConvertor_10_40.convertAddress(src.getAddress()));
        return tgt;
    }
}
