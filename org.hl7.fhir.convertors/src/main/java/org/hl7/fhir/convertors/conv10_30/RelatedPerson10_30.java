package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class RelatedPerson10_30 {

    public static org.hl7.fhir.dstu3.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.dstu2.model.RelatedPerson src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.RelatedPerson tgt = new org.hl7.fhir.dstu3.model.RelatedPerson();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setRelationship(VersionConvertor_10_30.convertCodeableConcept(src.getRelationship()));
        tgt.addName(VersionConvertor_10_30.convertHumanName(src.getName()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        tgt.setGender(VersionConvertor_10_30.convertAdministrativeGender(src.getGender()));
        tgt.setBirthDate(src.getBirthDate());
        for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_30.convertAddress(t));
        for (org.hl7.fhir.dstu2.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_30.convertAttachment(t));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.dstu3.model.RelatedPerson src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.RelatedPerson tgt = new org.hl7.fhir.dstu2.model.RelatedPerson();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setRelationship(VersionConvertor_10_30.convertCodeableConcept(src.getRelationship()));
        if (!src.getName().isEmpty())
            tgt.setName(VersionConvertor_10_30.convertHumanName(src.getName().get(0)));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        tgt.setGender(VersionConvertor_10_30.convertAdministrativeGender(src.getGender()));
        tgt.setBirthDate(src.getBirthDate());
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(VersionConvertor_10_30.convertAddress(t));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) tgt.addPhoto(VersionConvertor_10_30.convertAttachment(t));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }
}
