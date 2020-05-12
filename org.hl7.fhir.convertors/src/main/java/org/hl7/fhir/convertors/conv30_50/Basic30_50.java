package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Basic30_50 {

    public static org.hl7.fhir.r5.model.Basic convertBasic(org.hl7.fhir.dstu3.model.Basic src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Basic tgt = new org.hl7.fhir.r5.model.Basic();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasCreated())
            tgt.setCreatedElement(VersionConvertor_30_50.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Basic convertBasic(org.hl7.fhir.r5.model.Basic src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Basic tgt = new org.hl7.fhir.dstu3.model.Basic();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasCreated())
            tgt.setCreatedElement(VersionConvertor_30_50.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        return tgt;
    }
}