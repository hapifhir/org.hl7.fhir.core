package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.*;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Date10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class RelatedPerson10_30 {

    public static org.hl7.fhir.dstu3.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.dstu2.model.RelatedPerson src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.RelatedPerson tgt = new org.hl7.fhir.dstu3.model.RelatedPerson();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
        if (src.hasRelationship())
            tgt.setRelationship(CodeableConcept10_30.convertCodeableConcept(src.getRelationship()));
        if (src.hasName())
            tgt.addName(HumanName10_30.convertHumanName(src.getName()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations10_30.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement(Date10_30.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.dstu2.model.Address t : src.getAddress()) tgt.addAddress(Address10_30.convertAddress(t));
        for (org.hl7.fhir.dstu2.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment10_30.convertAttachment(t));
        if (src.hasPeriod())
            tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.RelatedPerson convertRelatedPerson(org.hl7.fhir.dstu3.model.RelatedPerson src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.RelatedPerson tgt = new org.hl7.fhir.dstu2.model.RelatedPerson();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        if (src.hasPatient())
            tgt.setPatient(Reference10_30.convertReference(src.getPatient()));
        if (src.hasRelationship())
            tgt.setRelationship(CodeableConcept10_30.convertCodeableConcept(src.getRelationship()));
        if (!src.getName().isEmpty())
            tgt.setName(HumanName10_30.convertHumanName(src.getName().get(0)));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
        if (src.hasGender())
            tgt.setGenderElement(Enumerations10_30.convertAdministrativeGender(src.getGenderElement()));
        if (src.hasBirthDateElement())
            tgt.setBirthDateElement(Date10_30.convertDate(src.getBirthDateElement()));
        for (org.hl7.fhir.dstu3.model.Address t : src.getAddress()) tgt.addAddress(Address10_30.convertAddress(t));
        for (org.hl7.fhir.dstu3.model.Attachment t : src.getPhoto()) tgt.addPhoto(Attachment10_30.convertAttachment(t));
        if (src.hasPeriod())
            tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }
}