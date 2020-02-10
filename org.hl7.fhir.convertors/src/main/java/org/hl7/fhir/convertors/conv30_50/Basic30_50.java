package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Basic30_50 {

    public static org.hl7.fhir.r5.model.Basic convertBasic(org.hl7.fhir.dstu3.model.Basic src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Basic tgt = new org.hl7.fhir.r5.model.Basic();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement((org.hl7.fhir.r5.model.DateType) VersionConvertor_30_50.convertType(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Basic convertBasic(org.hl7.fhir.r5.model.Basic src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Basic tgt = new org.hl7.fhir.dstu3.model.Basic();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement((org.hl7.fhir.dstu3.model.DateType) VersionConvertor_30_50.convertType(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_50.convertReference(src.getAuthor()));
        return tgt;
    }
}
