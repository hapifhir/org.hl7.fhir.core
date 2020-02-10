package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.dstu2.model.Base64BinaryType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;

import java.util.Collections;

public class Binary10_50 {

    public static org.hl7.fhir.r5.model.Binary convertBinary(org.hl7.fhir.dstu2.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Binary tgt = new org.hl7.fhir.r5.model.Binary();
        VersionConvertor_10_50.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_10_50.convertType(src.getContentTypeElement()));
        if (src.hasContentElement()) {
            tgt.setContentTypeElement((CodeType) VersionConvertor_10_50.convertType(src.getContentElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Binary convertBinary(org.hl7.fhir.r5.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Binary tgt = new org.hl7.fhir.dstu2.model.Binary();
        VersionConvertor_10_50.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement((org.hl7.fhir.dstu2.model.CodeType) VersionConvertor_10_50.convertType(src.getContentTypeElement()));
        tgt.setContentElement((Base64BinaryType) VersionConvertor_10_50.convertType(src.getContentElement()));
        return tgt;
    }
}
