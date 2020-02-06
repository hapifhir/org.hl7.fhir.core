package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Organization10_50 {

    public static org.hl7.fhir.r5.model.Organization convertOrganization(org.hl7.fhir.dstu2.model.Organization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Organization tgt = new org.hl7.fhir.r5.model.Organization();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasActive()) {
            tgt.setActive(src.getActive());
        }
        if (src.hasType()) {
            tgt.addType(VersionConvertor_10_50.convertCodeableConcept(src.getType()));
        }
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_50.convertAddress(t));
        }
        if (src.hasPartOf()) {
            tgt.setPartOf(VersionConvertor_10_50.convertReference(src.getPartOf()));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Organization convertOrganization(org.hl7.fhir.r5.model.Organization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Organization tgt = new org.hl7.fhir.dstu2.model.Organization();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        }
        if (src.hasActive()) {
            tgt.setActive(src.getActive());
        }
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_50.convertCodeableConcept(src.getTypeFirstRep()));
        }
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.r5.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_50.convertAddress(t));
        }
        if (src.hasPartOf()) {
            tgt.setPartOf(VersionConvertor_10_50.convertReference(src.getPartOf()));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.r5.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasPurpose()) {
            tgt.setPurpose(VersionConvertor_10_50.convertCodeableConcept(src.getPurpose()));
        }
        if (src.hasName()) {
            tgt.setName(VersionConvertor_10_50.convertHumanName(src.getName()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            tgt.setAddress(VersionConvertor_10_50.convertAddress(src.getAddress()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.r5.model.Organization.OrganizationContactComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasPurpose()) {
            tgt.setPurpose(VersionConvertor_10_50.convertCodeableConcept(src.getPurpose()));
        }
        if (src.hasName()) {
            tgt.setName(VersionConvertor_10_50.convertHumanName(src.getName()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            tgt.setAddress(VersionConvertor_10_50.convertAddress(src.getAddress()));
        }
        return tgt;
    }
}
