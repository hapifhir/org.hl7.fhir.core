package org.hl7.fhir.convertors.conv30_50.resources30_50;

import java.util.List;
import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.*;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;

public class RelatedPerson30_50 {

    public static org.hl7.fhir.dstu3.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.r5.model.RelatedPerson src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.RelatedPerson tgt = new org.hl7.fhir.dstu3.model.RelatedPerson();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
        }
        if (src.hasActive()) {
            if (src.hasActiveElement())
                tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
        }
        if (src.hasPatient()) {
            if (src.hasPatient())
                tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
        }
        List<CodeableConcept> relationships = src.getRelationship();
        if (relationships.size() > 0) {
            tgt.setRelationship(CodeableConcept30_50.convertCodeableConcept(relationships.get(0)));
            if (relationships.size() > 1) {
            }
        }
        for (org.hl7.fhir.r5.model.HumanName t : src.getName()) {
            tgt.addName(HumanName30_50.convertHumanName(t));
        }
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) {
            tgt.addTelecom(ContactPoint30_50.convertContactPoint(t));
        }
        if (src.hasGender()) {
            tgt.setGenderElement(Enumerations30_50.convertAdministrativeGender(src.getGenderElement()));
        }
        if (src.hasBirthDate()) {
            tgt.setBirthDate(tgt.getBirthDate());
        }
        for (org.hl7.fhir.r5.model.Address t : src.getAddress()) {
            tgt.addAddress(Address30_50.convertAddress(t));
        }
        for (org.hl7.fhir.r5.model.Attachment t : src.getPhoto()) {
            tgt.addPhoto(Attachment30_50.convertAttachment(t));
        }
        if (src.hasPeriod()) {
            if (src.hasPeriod())
                tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.dstu3.model.RelatedPerson src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RelatedPerson tgt = new org.hl7.fhir.r5.model.RelatedPerson();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
            tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
        }
        if (src.hasActive()) {
            if (src.hasActiveElement())
                tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
        }
        if (src.hasPatient()) {
            if (src.hasPatient())
                tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
        }
        if (src.hasRelationship()) {
            if (src.hasRelationship())
                tgt.addRelationship(CodeableConcept30_50.convertCodeableConcept(src.getRelationship()));
        }
        for (org.hl7.fhir.dstu3.model.HumanName t : src.getName()) {
            tgt.addName(HumanName30_50.convertHumanName(t));
        }
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) {
            tgt.addTelecom(ContactPoint30_50.convertContactPoint(t));
        }
        if (src.hasGender()) {
            tgt.setGenderElement(Enumerations30_50.convertAdministrativeGender(src.getGenderElement()));
        }
        if (src.hasBirthDate()) {
            tgt.setBirthDate(tgt.getBirthDate());
        }
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) {
            tgt.addAddress(Address30_50.convertAddress(t));
        }
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) {
            tgt.addPhoto(Attachment30_50.convertAttachment(t));
        }
        if (src.hasPeriod()) {
            if (src.hasPeriod())
                tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }
}