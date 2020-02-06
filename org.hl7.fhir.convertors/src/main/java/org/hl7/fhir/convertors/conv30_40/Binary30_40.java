package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Binary30_40 {

    public static org.hl7.fhir.dstu3.model.Binary convertBinary(org.hl7.fhir.r4.model.Binary src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Binary tgt = new org.hl7.fhir.dstu3.model.Binary();
        VersionConvertor_30_40.copyResource(src, tgt);
        if (src.hasContentType())
            tgt.setContentType(src.getContentType());
        if (src.hasSecurityContext())
            tgt.setSecurityContext(VersionConvertor_30_40.convertReference(src.getSecurityContext()));
        if (src.hasData())
            tgt.setContent(src.getData());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Binary convertBinary(org.hl7.fhir.dstu3.model.Binary src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Binary tgt = new org.hl7.fhir.r4.model.Binary();
        VersionConvertor_30_40.copyResource(src, tgt);
        if (src.hasContentType())
            tgt.setContentType(src.getContentType());
        if (src.hasSecurityContext())
            tgt.setSecurityContext(VersionConvertor_30_40.convertReference(src.getSecurityContext()));
        if (src.hasContent())
            tgt.setData(src.getContent());
        return tgt;
    }
}
