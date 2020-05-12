package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Binary10_50 {

    public static org.hl7.fhir.r5.model.Binary convertBinary(org.hl7.fhir.dstu2.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Binary tgt = new org.hl7.fhir.r5.model.Binary();
        VersionConvertor_10_50.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement(VersionConvertor_10_50.convertCode(src.getContentTypeElement()));
        if (src.hasContent())
            tgt.setContent(src.getContent());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Binary convertBinary(org.hl7.fhir.r5.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Binary tgt = new org.hl7.fhir.dstu2.model.Binary();
        VersionConvertor_10_50.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement(VersionConvertor_10_50.convertCode(src.getContentTypeElement()));
        tgt.setContent(src.getContent());
        return tgt;
    }
}