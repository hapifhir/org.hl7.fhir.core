package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Account10_30 {

    public static org.hl7.fhir.dstu2.model.Account convertAccount(org.hl7.fhir.dstu3.model.Account src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Account tgt = new org.hl7.fhir.dstu2.model.Account();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setName(src.getName());
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setStatus(convertAccountStatus(src.getStatus()));
        tgt.setActivePeriod(VersionConvertor_10_30.convertPeriod(src.getActive()));
        tgt.setBalance(VersionConvertor_10_30.convertMoney(src.getBalance()));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setOwner(VersionConvertor_10_30.convertReference(src.getOwner()));
        tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Account convertAccount(org.hl7.fhir.dstu2.model.Account src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Account tgt = new org.hl7.fhir.dstu3.model.Account();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setStatus(convertAccountStatus(src.getStatus()));
        tgt.setActive(VersionConvertor_10_30.convertPeriod(src.getActivePeriod()));
        tgt.setBalance(VersionConvertor_10_30.convertMoney(src.getBalance()));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setOwner(VersionConvertor_10_30.convertReference(src.getOwner()));
        tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Account.AccountStatus convertAccountStatus(org.hl7.fhir.dstu2.model.Account.AccountStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.Account.AccountStatus.ACTIVE;
            case INACTIVE:
                return org.hl7.fhir.dstu3.model.Account.AccountStatus.INACTIVE;
            default:
                return org.hl7.fhir.dstu3.model.Account.AccountStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Account.AccountStatus convertAccountStatus(org.hl7.fhir.dstu3.model.Account.AccountStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.Account.AccountStatus.ACTIVE;
            case INACTIVE:
                return org.hl7.fhir.dstu2.model.Account.AccountStatus.INACTIVE;
            default:
                return org.hl7.fhir.dstu2.model.Account.AccountStatus.NULL;
        }
    }
}
