package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complexTypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complexTypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Date10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Basic10_50 {

    public static org.hl7.fhir.r5.model.Basic convertBasic(org.hl7.fhir.dstu2.model.Basic src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Basic tgt = new org.hl7.fhir.r5.model.Basic();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(Date10_50.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Basic convertBasic(org.hl7.fhir.r5.model.Basic src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Basic tgt = new org.hl7.fhir.dstu2.model.Basic();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(Date10_50.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
        return tgt;
    }
}