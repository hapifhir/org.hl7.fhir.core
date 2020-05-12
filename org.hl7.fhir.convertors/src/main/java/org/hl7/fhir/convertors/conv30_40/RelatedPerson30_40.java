package org.hl7.fhir.convertors.conv30_40;

import java.util.List;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;

public class RelatedPerson30_40 {

    public static org.hl7.fhir.dstu3.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.r4.model.RelatedPerson src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.RelatedPerson tgt = new org.hl7.fhir.dstu3.model.RelatedPerson();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasActive()) {
            if (src.hasActiveElement())
                tgt.setActiveElement(VersionConvertor_30_40.convertBoolean(src.getActiveElement()));
        }
        if (src.hasPatient()) {
            if (src.hasPatient())
                tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        }
        List<CodeableConcept> relationships = src.getRelationship();
        if (relationships.size() > 0) {
            tgt.setRelationship(VersionConvertor_30_40.convertCodeableConcept(relationships.get(0)));
            if (relationships.size() > 1) {
            }
        }
        for (org.hl7.fhir.r4.model.HumanName t : src.getName()) {
            tgt.addName(VersionConvertor_30_40.convertHumanName(t));
        }
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) {
            tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasGender()) {
            tgt.setGenderElement(VersionConvertor_30_40.convertAdministrativeGender(src.getGenderElement()));
        }
        if (src.hasBirthDate()) {
            tgt.setBirthDate(tgt.getBirthDate());
        }
        for (org.hl7.fhir.r4.model.Address t : src.getAddress()) {
            tgt.addAddress(VersionConvertor_30_40.convertAddress(t));
        }
        for (org.hl7.fhir.r4.model.Attachment t : src.getPhoto()) {
            tgt.addPhoto(VersionConvertor_30_40.convertAttachment(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.dstu3.model.RelatedPerson src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.RelatedPerson tgt = new org.hl7.fhir.r4.model.RelatedPerson();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasActive()) {
            if (src.hasActiveElement())
                tgt.setActiveElement(VersionConvertor_30_40.convertBoolean(src.getActiveElement()));
        }
        if (src.hasPatient()) {
            if (src.hasPatient())
                tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        }
        if (src.hasRelationship()) {
            if (src.hasRelationship())
                tgt.addRelationship(VersionConvertor_30_40.convertCodeableConcept(src.getRelationship()));
        }
        for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) {
            tgt.addName(VersionConvertor_30_40.convertHumanName(t));
        }
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) {
            tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasGender()) {
            tgt.setGenderElement(VersionConvertor_30_40.convertAdministrativeGender(src.getGenderElement()));
        }
        if (src.hasBirthDate()) {
            tgt.setBirthDate(tgt.getBirthDate());
        }
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) {
            tgt.addAddress(VersionConvertor_30_40.convertAddress(t));
        }
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) {
            tgt.addPhoto(VersionConvertor_30_40.convertAttachment(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }
}