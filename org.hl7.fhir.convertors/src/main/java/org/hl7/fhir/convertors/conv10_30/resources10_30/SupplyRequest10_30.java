package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class SupplyRequest10_30 {

    public static org.hl7.fhir.dstu3.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.dstu2.model.SupplyRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.SupplyRequest tgt = new org.hl7.fhir.dstu3.model.SupplyRequest();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.dstu3.model.SupplyRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SupplyRequest tgt = new org.hl7.fhir.dstu2.model.SupplyRequest();
        return tgt;
    }
}