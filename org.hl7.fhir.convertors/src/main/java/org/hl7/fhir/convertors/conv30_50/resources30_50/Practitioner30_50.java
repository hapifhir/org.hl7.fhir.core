package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Element30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.*;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Date30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Practitioner30_50 {

    public static org.hl7.fhir.r5.model.Practitioner convertPractitioner(org.hl7.fhir.dstu3.model.Practitioner src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Practitioner tgt = new org.hl7.fhir.r5.model.Practitioner();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) tgt.addName(HumanName30_50.convertHumanName(t));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_50.convertContactPoint(t));
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(Address30_50.convertAddress(t));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations30_50.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(Date30_50.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment30_50.convertAttachment(t));
        for (org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(CodeableConcept30_50.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Practitioner convertPractitioner(org.hl7.fhir.r5.model.Practitioner src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Practitioner tgt = new org.hl7.fhir.dstu3.model.Practitioner();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
        if (src.hasActive())
            tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
        for (org.hl7.fhir.r5.model.HumanName t : src.getName()) tgt.addName(HumanName30_50.convertHumanName(t));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint30_50.convertContactPoint(t));
        for (org.hl7.fhir.r5.model.Address t : src.getAddress()) tgt.addAddress(Address30_50.convertAddress(t));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations30_50.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDate())
            tgt.setBirthDateElement(Date30_50.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.r5.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment30_50.convertAttachment(t));
        for (org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent t : src.getQualification()) tgt.addQualification(convertPractitionerQualificationComponent(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCommunication()) tgt.addCommunication(CodeableConcept30_50.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent();
        Element30_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
        if (src.hasPeriod())
            tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
        if (src.hasIssuer())
            tgt.setIssuer(Reference30_50.convertReference(src.getIssuer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent convertPractitionerQualificationComponent(org.hl7.fhir.r5.model.Practitioner.PractitionerQualificationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent tgt = new org.hl7.fhir.dstu3.model.Practitioner.PractitionerQualificationComponent();
        Element30_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
        if (src.hasPeriod())
            tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
        if (src.hasIssuer())
            tgt.setIssuer(Reference30_50.convertReference(src.getIssuer()));
        return tgt;
    }
}