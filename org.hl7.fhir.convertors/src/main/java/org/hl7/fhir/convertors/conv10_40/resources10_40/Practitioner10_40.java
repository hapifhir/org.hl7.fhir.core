package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Practitioner10_40 {

    public static org.hl7.fhir.dstu2.model.Practitioner convertPractitioner(org.hl7.fhir.r4.model.Practitioner src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Practitioner tgt = new org.hl7.fhir.dstu2.model.Practitioner();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasActiveElement())
            tgt.setActiveElement(VersionConvertor_10_40.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.setName(VersionConvertor_10_40.convertHumanName(t));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_10_40.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement(VersionConvertor_10_40.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_40.convertAttachment(t));
        for (org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(VersionConvertor_10_40.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Practitioner convertPractitioner(org.hl7.fhir.dstu2.model.Practitioner src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Practitioner tgt = new org.hl7.fhir.r4.model.Practitioner();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasActiveElement())
            tgt.setActiveElement(VersionConvertor_10_40.convertBoolean(src.getActiveElement()));
        if (src.hasName())
            tgt.addName(VersionConvertor_10_40.convertHumanName(src.getName()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_40.convertAddress(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_10_40.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement(VersionConvertor_10_40.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.dstu2.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_40.convertAttachment(t));
        for (org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(VersionConvertor_10_40.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        if (src.hasIssuer())
            tgt.setIssuer(VersionConvertor_10_40.convertReference(src.getIssuer()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.dstu2.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        if (src.hasIssuer())
            tgt.setIssuer(VersionConvertor_10_40.convertReference(src.getIssuer()));
        return tgt;
    }
}