package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.exceptions.FHIRException;

public class Consent30_50 {

    public static org.hl7.fhir.dstu3.model.Consent convertConsent(org.hl7.fhir.r5.model.Consent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Consent tgt = new org.hl7.fhir.dstu3.model.Consent();
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Consent convertConsent(org.hl7.fhir.dstu3.model.Consent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Consent tgt = new org.hl7.fhir.r5.model.Consent();
        return tgt;
    }
}