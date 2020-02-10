package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class PaymentNotice30_40 {

    public static org.hl7.fhir.r4.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.dstu3.model.PaymentNotice src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PaymentNotice tgt = new org.hl7.fhir.r4.model.PaymentNotice();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertPaymentNoticeStatus(src.getStatus()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_30_40.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_30_40.convertReference(src.getResponse()));
        if (src.hasStatusDate())
            tgt.setPaymentDateElement(VersionConvertor_30_40.convertDate(src.getStatusDateElement()));
        if (src.hasCreated())
            tgt.setCreatedElement(VersionConvertor_30_40.convertDateTime(src.getCreatedElement()));
        if (src.hasTarget())
            tgt.setRecipient(VersionConvertor_30_40.convertReference(src.getTarget()));
        if (src.hasProvider())
            tgt.setProvider(VersionConvertor_30_40.convertReference(src.getProvider()));
        if (src.hasPaymentStatus())
            tgt.setPaymentStatus(VersionConvertor_30_40.convertCodeableConcept(src.getPaymentStatus()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.PaymentNotice convertPaymentNotice(org.hl7.fhir.r4.model.PaymentNotice src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.PaymentNotice tgt = new org.hl7.fhir.dstu3.model.PaymentNotice();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertPaymentNoticeStatus(src.getStatus()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_30_40.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_30_40.convertReference(src.getResponse()));
        if (src.hasPaymentDate())
            tgt.setStatusDateElement(VersionConvertor_30_40.convertDate(src.getPaymentDateElement()));
        if (src.hasCreated())
            tgt.setCreatedElement(VersionConvertor_30_40.convertDateTime(src.getCreatedElement()));
        if (src.hasRecipient())
            tgt.setTarget(VersionConvertor_30_40.convertReference(src.getRecipient()));
        if (src.hasProvider())
            tgt.setProvider(VersionConvertor_30_40.convertReference(src.getProvider()));
        if (src.hasPaymentStatus())
            tgt.setPaymentStatus(VersionConvertor_30_40.convertCodeableConcept(src.getPaymentStatus()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus convertPaymentNoticeStatus(org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.ACTIVE;
            case CANCELLED:
                return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.CANCELLED;
            case DRAFT:
                return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.DRAFT;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.PaymentNotice.PaymentNoticeStatus convertPaymentNoticeStatus(org.hl7.fhir.r4.model.PaymentNotice.PaymentNoticeStatus src) throws FHIRException {
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
