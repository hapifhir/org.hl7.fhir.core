package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.Base64BinaryType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Binary10_30 {

    public static org.hl7.fhir.dstu2.model.Binary convertBinary(org.hl7.fhir.dstu3.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Binary tgt = new org.hl7.fhir.dstu2.model.Binary();
        VersionConvertor_10_30.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement((org.hl7.fhir.dstu2.model.CodeType) VersionConvertor_10_30.convertType(src.getContentTypeElement()));
        if (src.hasContentElement()) {
            tgt.setContentElement((Base64BinaryType) VersionConvertor_10_30.convertType(src.getContentElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Binary convertBinary(org.hl7.fhir.dstu2.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Binary tgt = new org.hl7.fhir.dstu3.model.Binary();
        VersionConvertor_10_30.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_10_30.convertType(src.getContentTypeElement()));
        if (src.hasContentElement()) {
            tgt.setContentElement((org.hl7.fhir.dstu3.model.Base64BinaryType) VersionConvertor_10_30.convertType(src.getContentElement()));
        }
        return tgt;
    }
}
