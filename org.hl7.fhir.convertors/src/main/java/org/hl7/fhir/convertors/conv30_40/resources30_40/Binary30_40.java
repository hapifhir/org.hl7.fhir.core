package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Base64Binary30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Binary30_40 {

    public static org.hl7.fhir.dstu3.model.Binary convertBinary(org.hl7.fhir.r4.model.Binary src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Binary tgt = new org.hl7.fhir.dstu3.model.Binary();
        VersionConvertor_30_40.copyResource(src, tgt);
        if (src.hasContentType())
            tgt.setContentTypeElement(Code30_40.convertCode(src.getContentTypeElement()));
        if (src.hasSecurityContext())
            tgt.setSecurityContext(Reference30_40.convertReference(src.getSecurityContext()));
        if (src.hasData())
            tgt.setContentElement(Base64Binary30_40.convertBase64Binary(src.getDataElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Binary convertBinary(org.hl7.fhir.dstu3.model.Binary src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Binary tgt = new org.hl7.fhir.r4.model.Binary();
        VersionConvertor_30_40.copyResource(src, tgt);
        if (src.hasContentType())
            tgt.setContentTypeElement(Code30_40.convertCode(src.getContentTypeElement()));
        if (src.hasSecurityContext())
            tgt.setSecurityContext(Reference30_40.convertReference(src.getSecurityContext()));
        if (src.hasContent())
            tgt.setDataElement(Base64Binary30_40.convertBase64Binary(src.getContentElement()));
        return tgt;
    }
}