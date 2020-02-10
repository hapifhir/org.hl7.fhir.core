package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.dstu3.model.Base64BinaryType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Binary30_40 {

    public static org.hl7.fhir.dstu3.model.Binary convertBinary(org.hl7.fhir.r4.model.Binary src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Binary tgt = new org.hl7.fhir.dstu3.model.Binary();
        VersionConvertor_30_40.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getContentTypeElement()));
        if (src.hasSecurityContext())
            tgt.setSecurityContext(VersionConvertor_30_40.convertReference(src.getSecurityContext()));
        if (src.hasDataElement())
            tgt.setContentElement((Base64BinaryType) VersionConvertor_30_40.convertType(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Binary convertBinary(org.hl7.fhir.dstu3.model.Binary src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Binary tgt = new org.hl7.fhir.r4.model.Binary();
        VersionConvertor_30_40.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getContentTypeElement()));
        if (src.hasSecurityContext())
            tgt.setSecurityContext(VersionConvertor_30_40.convertReference(src.getSecurityContext()));
        if (src.hasContentElement())
            tgt.setDataElement((org.hl7.fhir.r4.model.Base64BinaryType) VersionConvertor_30_40.convertType(src.getContentElement()));
        return tgt;
    }
}
