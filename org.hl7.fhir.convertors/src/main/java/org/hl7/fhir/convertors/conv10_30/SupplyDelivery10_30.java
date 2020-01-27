package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class SupplyDelivery10_30 {

    public static org.hl7.fhir.dstu3.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.dstu2.model.SupplyDelivery src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.SupplyDelivery tgt = new org.hl7.fhir.dstu3.model.SupplyDelivery();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setStatus(convertSupplyDeliveryStatus(src.getStatus()));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setSupplier(VersionConvertor_10_30.convertReference(src.getSupplier()));
        tgt.setDestination(VersionConvertor_10_30.convertReference(src.getDestination()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.dstu3.model.SupplyDelivery src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SupplyDelivery tgt = new org.hl7.fhir.dstu2.model.SupplyDelivery();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setStatus(convertSupplyDeliveryStatus(src.getStatus()));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setSupplier(VersionConvertor_10_30.convertReference(src.getSupplier()));
        tgt.setDestination(VersionConvertor_10_30.convertReference(src.getDestination()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus convertSupplyDeliveryStatus(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED;
            case ABANDONED:
                return org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED;
            default:
                return org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus convertSupplyDeliveryStatus(org.hl7.fhir.dstu2.model.SupplyDelivery.SupplyDeliveryStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED;
            case ABANDONED:
                return org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED;
            default:
                return org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.NULL;
        }
    }
}
