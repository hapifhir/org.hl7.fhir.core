package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Base64BinaryType;

import java.util.Collections;

public class Binary30_50 {

    public static org.hl7.fhir.r5.model.Binary convertBinary(org.hl7.fhir.dstu3.model.Binary src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Binary tgt = new org.hl7.fhir.r5.model.Binary();
        VersionConvertor_30_50.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement((org.hl7.fhir.r5.model.CodeType) VersionConvertor_30_50.convertType(src.getContentTypeElement()));
        if (src.hasSecurityContext())
            tgt.setSecurityContext(VersionConvertor_30_50.convertReference(src.getSecurityContext()));
        if (src.hasContentElement())
            tgt.setDataElement((Base64BinaryType) VersionConvertor_30_50.convertType(src.getContentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Binary convertBinary(org.hl7.fhir.r5.model.Binary src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Binary tgt = new org.hl7.fhir.dstu3.model.Binary();
        VersionConvertor_30_50.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_50.convertType(src.getContentTypeElement()));
        if (src.hasSecurityContext())
            tgt.setSecurityContext(VersionConvertor_30_50.convertReference(src.getSecurityContext()));
        if (src.hasDataElement())
            tgt.setContentElement((org.hl7.fhir.dstu3.model.Base64BinaryType) VersionConvertor_30_50.convertType(src.getDataElement()));
        return tgt;
    }
}
