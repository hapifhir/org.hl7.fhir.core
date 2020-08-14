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
            tgt.setStatusElement(convertPaymentNoticeStatus(src.getStatusElement()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_30_50.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_30_50.convertReference(src.getResponse()));
        if (src.hasPaymentDate())
            tgt.setStatusDateElement(VersionConvertor_30_50.convertDate(src.getPaymentDateElement()));
        if (src.hasCreated())
            tgt.setCreatedElement(VersionConvertor_30_50.convertDateTime(src.getCreatedElement()));
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
            tgt.setStatusElement(convertPaymentNoticeStatus(src.getStatusElement()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_30_50.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_30_50.convertReference(src.getResponse()));
        if (src.hasStatusDate())
            tgt.setPaymentDateElement(VersionConvertor_30_50.convertDate(src.getStatusDateElement()));
        if (src.hasCreated())
            tgt.setCreatedElement(VersionConvertor_30_50.convertDateTime(src.getCreatedElement()));
        if (src.hasTarget())
            tgt.setRecipient(VersionConvertor_30_50.convertReference(src.getTarget()));
        if (src.hasProvider())
            tgt.setProvider(VersionConvertor_30_50.convertReference(src.getProvider()));
        if (src.hasPaymentStatus())
            tgt.setPaymentStatus(VersionConvertor_30_50.convertCodeableConcept(src.getPaymentStatus()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertPaymentNoticeStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus> convertPaymentNoticeStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.ACTIVE);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.CANCELLED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.DRAFT);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus.NULL);
                break;
        }
        return tgt;
    }
}