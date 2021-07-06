package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Base64Binary10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Code10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Binary10_30 {

    public static org.hl7.fhir.dstu2.model.Binary convertBinary(org.hl7.fhir.dstu3.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Binary tgt = new org.hl7.fhir.dstu2.model.Binary();
        VersionConvertor_10_30.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement(Code10_30.convertCode(src.getContentTypeElement()));
        if (src.hasContentElement())
            tgt.setContentElement(Base64Binary10_30.convertBase64Binary(src.getContentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Binary convertBinary(org.hl7.fhir.dstu2.model.Binary src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Binary tgt = new org.hl7.fhir.dstu3.model.Binary();
        VersionConvertor_10_30.copyResource(src, tgt);
        if (src.hasContentTypeElement())
            tgt.setContentTypeElement(Code10_30.convertCode(src.getContentTypeElement()));
        if (src.hasContentElement())
            tgt.setContentElement(Base64Binary10_30.convertBase64Binary(src.getContentElement()));
        return tgt;
    }
}