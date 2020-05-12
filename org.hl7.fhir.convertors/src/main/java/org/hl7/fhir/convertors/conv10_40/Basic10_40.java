package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Basic10_40 {

    public static org.hl7.fhir.r4.model.Basic convertBasic(org.hl7.fhir.dstu2.model.Basic src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Basic tgt = new org.hl7.fhir.r4.model.Basic();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(VersionConvertor_10_40.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_10_40.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Basic convertBasic(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Basic tgt = new org.hl7.fhir.dstu2.model.Basic();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(VersionConvertor_10_40.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_10_40.convertReference(src.getAuthor()));
        return tgt;
    }
}