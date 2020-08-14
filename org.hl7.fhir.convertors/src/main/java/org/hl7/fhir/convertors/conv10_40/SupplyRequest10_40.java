package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class SupplyRequest10_40 {

    public static org.hl7.fhir.r4.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.dstu2.model.SupplyRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.SupplyRequest tgt = new org.hl7.fhir.r4.model.SupplyRequest();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.r4.model.SupplyRequest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SupplyRequest tgt = new org.hl7.fhir.dstu2.model.SupplyRequest();
        return tgt;
    }
}