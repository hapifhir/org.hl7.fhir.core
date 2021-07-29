package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40; import org.hl7.fhir.convertors.context.ConversionContext30_40; import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Date30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Basic30_40 {

    public static org.hl7.fhir.r4.model.Basic convertBasic(org.hl7.fhir.dstu3.model.Basic src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Basic tgt = new org.hl7.fhir.r4.model.Basic();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
        if (src.hasCreated())
            tgt.setCreatedElement(Date30_40.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference30_40.convertReference(src.getAuthor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Basic convertBasic(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Basic tgt = new org.hl7.fhir.dstu3.model.Basic();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
        if (src.hasCreated())
            tgt.setCreatedElement(Date30_40.convertDate(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference30_40.convertReference(src.getAuthor()));
        return tgt;
    }
}