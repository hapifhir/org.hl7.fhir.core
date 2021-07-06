package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Date10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Basic10_40 {

    public static org.hl7.fhir.r4.model.Basic convertBasic(org.hl7.fhir.dstu2.model.Basic src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Basic tgt = new org.hl7.fhir.r4.model.Basic();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(Date10_40.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Basic convertBasic(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Basic tgt = new org.hl7.fhir.dstu2.model.Basic();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(Date10_40.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
        return tgt;
    }
}