package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class PaymentNotice30_50 {

    public static org.hl7.fhir.dstu3.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.r5.model.PaymentNotice src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PaymentNotice tgt = new org.hl7.fhir.dstu3.model.PaymentNotice();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertPaymentNoticeStatus(src.getStatus()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_30_50.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_30_50.convertReference(src.getResponse()));
        if (src.hasPaymentDate())
            tgt.setStatusDate(src.getPaymentDate());
        if (src.hasCreated())
            tgt.setCreated(src.getCreated());
        if (src.hasRecipient())
            tgt.setTarget(VersionConvertor_30_50.convertReference(src.getRecipient()));
        if (src.hasProvider())
            tgt.setProvider(VersionConvertor_30_50.convertReference(src.getProvider()));
        if (src.hasPaymentStatus())
            tgt.setPaymentStatus(VersionConvertor_30_50.convertCodeableConcept(src.getPaymentStatus()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.dstu3.model.PaymentNotice src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PaymentNotice tgt = new org.hl7.fhir.r5.model.PaymentNotice();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertPaymentNoticeStatus(src.getStatus()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_30_50.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_30_50.convertReference(src.getResponse()));
        if (src.hasStatusDate())
            tgt.setPaymentDate(src.getStatusDate());
        if (src.hasCreated())
            tgt.setCreated(src.getCreated());
        if (src.hasTarget())
            tgt.setRecipient(VersionConvertor_30_50.convertReference(src.getTarget()));
        if (src.hasProvider())
            tgt.setProvider(VersionConvertor_30_50.convertReference(src.getProvider()));
        if (src.hasPaymentStatus())
            tgt.setPaymentStatus(VersionConvertor_30_50.convertCodeableConcept(src.getPaymentStatus()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes convertPaymentNoticeStatus(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ACTIVE;
            case CANCELLED:
                return org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.CANCELLED;
            case DRAFT:
                return org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.DRAFT;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus convertPaymentNoticeStatus(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.ACTIVE;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.CANCELLED;
            case DRAFT:
                return org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.DRAFT;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.NULL;
        }
    }
}
