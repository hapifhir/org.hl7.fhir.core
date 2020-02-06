package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Organization10_30 {

    public static org.hl7.fhir.dstu3.model.Organization convertOrganization(org.hl7.fhir.dstu2.model.Organization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Organization tgt = new org.hl7.fhir.dstu3.model.Organization();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasActiveElement()) {
            tgt.setActiveElement((BooleanType) VersionConvertor_10_30.convertType(src.getActiveElement()));
        }
        if (src.hasType()) {
            tgt.addType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        }
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_30.convertAddress(t));
        }
        if (src.hasPartOf()) {
            tgt.setPartOf(VersionConvertor_10_30.convertReference(src.getPartOf()));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Organization convertOrganization(org.hl7.fhir.dstu3.model.Organization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Organization tgt = new org.hl7.fhir.dstu2.model.Organization();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasActiveElement()) {
            tgt.setActiveElement((org.hl7.fhir.dstu2.model.BooleanType) VersionConvertor_10_30.convertType(src.getActiveElement()));
        }
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getTypeFirstRep()));
        }
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_30.convertAddress(t));
        }
        if (src.hasPartOf()) {
            tgt.setPartOf(VersionConvertor_10_30.convertReference(src.getPartOf()));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasPurpose()) {
            tgt.setPurpose(VersionConvertor_10_30.convertCodeableConcept(src.getPurpose()));
        }
        if (src.hasName()) {
            tgt.setName(VersionConvertor_10_30.convertHumanName(src.getName()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            tgt.setAddress(VersionConvertor_10_30.convertAddress(src.getAddress()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.dstu2.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasPurpose()) {
            tgt.setPurpose(VersionConvertor_10_30.convertCodeableConcept(src.getPurpose()));
        }
        if (src.hasName()) {
            tgt.setName(VersionConvertor_10_30.convertHumanName(src.getName()));
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        if (src.hasAddress()) {
            tgt.setAddress(VersionConvertor_10_30.convertAddress(src.getAddress()));
        }
        return tgt;
    }
}
