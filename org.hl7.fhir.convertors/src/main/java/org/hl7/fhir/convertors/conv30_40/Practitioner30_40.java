package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Practitioner30_40 {

    public static org.hl7.fhir.r4.model.Practitioner convertPractitioner(org.hl7.fhir.dstu3.model.Practitioner src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Practitioner tgt = new org.hl7.fhir.r4.model.Practitioner();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_40.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_30_40.convertHumanName(t));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_30_40.convertAddress(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_30_40.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(VersionConvertor_30_40.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_30_40.convertAttachment(t));
        for (org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(VersionConvertor_30_40.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Practitioner convertPractitioner(org.hl7.fhir.r4.model.Practitioner src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Practitioner tgt = new org.hl7.fhir.dstu3.model.Practitioner();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(VersionConvertor_30_40.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.r4.model.HumanName t : src.getName()) tgt.addName(VersionConvertor_30_40.convertHumanName(t));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_30_40.convertAddress(t));
        if (src.hasGender())
            tgt.setGenderElement(VersionConvertor_30_40.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(VersionConvertor_30_40.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_30_40.convertAttachment(t));
        for (org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(VersionConvertor_30_40.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasIssuer())
            tgt.setIssuer(VersionConvertor_30_40.convertReference(src.getIssuer()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r4.model.Practitioner.PractitionerQualificationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasIssuer())
            tgt.setIssuer(VersionConvertor_30_40.convertReference(src.getIssuer()));
        return tgt;
    }
}