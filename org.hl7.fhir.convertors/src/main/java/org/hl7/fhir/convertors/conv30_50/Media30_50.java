package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Media30_50 {

    public static org.hl7.fhir.r5.model.DocumentReference convertMedia(org.hl7.fhir.dstu3.model.Media src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DocumentReference tgt = new org.hl7.fhir.r5.model.DocumentReference();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Media convertMedia(org.hl7.fhir.r5.model.DocumentReference src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Media tgt = new org.hl7.fhir.dstu3.model.Media();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        return tgt;
    }
}