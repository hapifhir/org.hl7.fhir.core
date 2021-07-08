package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Organization30_40 {

    public static org.hl7.fhir.dstu3.model.Organization convertOrganization(org.hl7.fhir.r4.model.Organization src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Organization tgt = new org.hl7.fhir.dstu3.model.Organization();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(Address30_40.convertAddress(t));
        if (src.hasPartOf())
            tgt.setPartOf(Reference30_40.convertReference(src.getPartOf()));
        for (org.hl7.fhir.r4.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Organization convertOrganization(org.hl7.fhir.dstu3.model.Organization src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Organization tgt = new org.hl7.fhir.r4.model.Organization();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_40.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(Address30_40.convertAddress(t));
        if (src.hasPartOf())
            tgt.setPartOf(Reference30_40.convertReference(src.getPartOf()));
        for (org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent t : src.getContact()) tgt.addContact(convertOrganizationContactComponent(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.r4.model.Organization.OrganizationContactComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasPurpose())
            tgt.setPurpose(CodeableConcept30_40.convertCodeableConcept(src.getPurpose()));
        if (src.hasName())
            tgt.setName(HumanName30_40.convertHumanName(src.getName()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(Address30_40.convertAddress(src.getAddress()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent convertOrganizationContactComponent(org.hl7.fhir.r4.model.Organization.OrganizationContactComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent tgt = new org.hl7.fhir.dstu3.model.Organization.OrganizationContactComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasPurpose())
            tgt.setPurpose(CodeableConcept30_40.convertCodeableConcept(src.getPurpose()));
        if (src.hasName())
            tgt.setName(HumanName30_40.convertHumanName(src.getName()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_40.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(Address30_40.convertAddress(src.getAddress()));
        return tgt;
    }
}