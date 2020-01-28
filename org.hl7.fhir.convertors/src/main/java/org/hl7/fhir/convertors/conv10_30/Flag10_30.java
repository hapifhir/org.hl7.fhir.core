package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Flag10_30 {

    public static org.hl7.fhir.dstu3.model.Flag convertFlag(org.hl7.fhir.dstu2.model.Flag src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Flag tgt = new org.hl7.fhir.dstu3.model.Flag();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        tgt.setStatus(convertFlagStatus(src.getStatus()));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        tgt.setAuthor(VersionConvertor_10_30.convertReference(src.getAuthor()));
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Flag convertFlag(org.hl7.fhir.dstu3.model.Flag src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Flag tgt = new org.hl7.fhir.dstu2.model.Flag();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        tgt.setStatus(convertFlagStatus(src.getStatus()));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        tgt.setAuthor(VersionConvertor_10_30.convertReference(src.getAuthor()));
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Flag.FlagStatus convertFlagStatus(org.hl7.fhir.dstu2.model.Flag.FlagStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.Flag.FlagStatus.ACTIVE;
            case INACTIVE:
                return org.hl7.fhir.dstu3.model.Flag.FlagStatus.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Flag.FlagStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Flag.FlagStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Flag.FlagStatus convertFlagStatus(org.hl7.fhir.dstu3.model.Flag.FlagStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.Flag.FlagStatus.ACTIVE;
            case INACTIVE:
                return org.hl7.fhir.dstu2.model.Flag.FlagStatus.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Flag.FlagStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu2.model.Flag.FlagStatus.NULL;
        }
    }
}
