package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class SupplyDelivery30_40 {

    public static org.hl7.fhir.r4.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.dstu3.model.SupplyDelivery src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SupplyDelivery tgt = new org.hl7.fhir.r4.model.SupplyDelivery();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertSupplyDeliveryStatus(src.getStatus()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasSuppliedItem())
            tgt.setSuppliedItem(convertSupplyDeliverySuppliedItemComponent(src.getSuppliedItem()));
        if (src.hasOccurrence())
            tgt.setOccurrence(VersionConvertor_30_40.convertType(src.getOccurrence()));
        if (src.hasSupplier())
            tgt.setSupplier(VersionConvertor_30_40.convertReference(src.getSupplier()));
        if (src.hasDestination())
            tgt.setDestination(VersionConvertor_30_40.convertReference(src.getDestination()));
        if (src.hasReceiver()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.r4.model.SupplyDelivery src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.SupplyDelivery tgt = new org.hl7.fhir.dstu3.model.SupplyDelivery();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertSupplyDeliveryStatus(src.getStatus()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasSuppliedItem())
            tgt.setSuppliedItem(convertSupplyDeliverySuppliedItemComponent(src.getSuppliedItem()));
        if (src.hasOccurrence())
            tgt.setOccurrence(VersionConvertor_30_40.convertType(src.getOccurrence()));
        if (src.hasSupplier())
            tgt.setSupplier(VersionConvertor_30_40.convertReference(src.getSupplier()));
        if (src.hasDestination())
            tgt.setDestination(VersionConvertor_30_40.convertReference(src.getDestination()));
        if (src.hasReceiver()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus convertSupplyDeliveryStatus(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED;
            case ABANDONED:
                return org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus convertSupplyDeliveryStatus(org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliveryStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED;
            case ABANDONED:
                return org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliveryStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent convertSupplyDeliverySuppliedItemComponent(org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent tgt = new org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasItem())
            tgt.setItem(VersionConvertor_30_40.convertType(src.getItem()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent convertSupplyDeliverySuppliedItemComponent(org.hl7.fhir.r4.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent tgt = new org.hl7.fhir.dstu3.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasItem())
            tgt.setItem(VersionConvertor_30_40.convertType(src.getItem()));
        return tgt;
    }
}
