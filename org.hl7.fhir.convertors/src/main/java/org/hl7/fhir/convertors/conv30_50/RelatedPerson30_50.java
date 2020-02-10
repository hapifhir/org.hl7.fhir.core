package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.List;
import java.util.Collections;

public class RelatedPerson30_50 {

    public static org.hl7.fhir.dstu3.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.r5.model.RelatedPerson src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.RelatedPerson tgt = new org.hl7.fhir.dstu3.model.RelatedPerson();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasActiveElement())
            tgt.setActiveElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getActiveElement()));
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        }
        List<org.hl7.fhir.r5.model.CodeableConcept> relationships = src.getRelationship();
        if (relationships.size() > 0) {
            tgt.setRelationship(VersionConvertor_30_50.convertCodeableConcept(relationships.get(0)));
            if (relationships.size() > 1) {
            }
        }
        for (org.hl7.fhir.r5.model.HumanName t : src.getName()) {
            tgt.addName(VersionConvertor_30_50.convertHumanName(t));
        }
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) {
            tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_30_50.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement((org.hl7.fhir.dstu3.model.DateType) VersionConvertor_30_50.convertType(src.getBirthDateElement()));
        for (org.hl7.fhir.r5.model.Address t : src.getAddress()) {
            tgt.addAddress(VersionConvertor_30_50.convertAddress(t));
        }
        for (org.hl7.fhir.r5.model.Attachment t : src.getPhoto()) {
            tgt.addPhoto(VersionConvertor_30_50.convertAttachment(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.dstu3.model.RelatedPerson src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RelatedPerson tgt = new org.hl7.fhir.r5.model.RelatedPerson();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasActiveElement())
            tgt.setActiveElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getActiveElement()));
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        }
        if (src.hasRelationship()) {
            tgt.addRelationship(VersionConvertor_30_50.convertCodeableConcept(src.getRelationship()));
        }
        for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) {
            tgt.addName(VersionConvertor_30_50.convertHumanName(t));
        }
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) {
            tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        }
        if (src.hasGender()) {
            tgt.setGender(VersionConvertor_30_50.convertAdministrativeGender(src.getGender()));
        }
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement((org.hl7.fhir.r5.model.DateType) VersionConvertor_30_50.convertType(src.getBirthDateElement()));
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) {
            tgt.addAddress(VersionConvertor_30_50.convertAddress(t));
        }
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) {
            tgt.addPhoto(VersionConvertor_30_50.convertAttachment(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }
}
