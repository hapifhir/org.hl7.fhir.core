package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Device10_30 {

    public static org.hl7.fhir.dstu2.model.Device convertDevice(org.hl7.fhir.dstu3.model.Device src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Device tgt = new org.hl7.fhir.dstu2.model.Device();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasUdi())
            tgt.setUdi(src.getUdi().getDeviceIdentifier());
        tgt.setStatus(convertDeviceStatus(src.getStatus()));
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setLotNumber(src.getLotNumber());
        tgt.setManufacturer(src.getManufacturer());
        tgt.setManufactureDate(src.getManufactureDate());
        tgt.setExpiry(src.getExpirationDate());
        tgt.setModel(src.getModel());
        tgt.setVersion(src.getVersion());
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setOwner(VersionConvertor_10_30.convertReference(src.getOwner()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_10_30.convertContactPoint(t));
        tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_10_30.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Device convertDevice(org.hl7.fhir.dstu2.model.Device src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Device tgt = new org.hl7.fhir.dstu3.model.Device();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setUdi((new org.hl7.fhir.dstu3.model.Device.DeviceUdiComponent()).setDeviceIdentifier(src.getUdi()));
        tgt.setStatus(convertDeviceStatus(src.getStatus()));
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setLotNumber(src.getLotNumber());
        tgt.setManufacturer(src.getManufacturer());
        tgt.setManufactureDate(src.getManufactureDate());
        tgt.setExpirationDate(src.getExpiry());
        tgt.setModel(src.getModel());
        tgt.setVersion(src.getVersion());
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setOwner(VersionConvertor_10_30.convertReference(src.getOwner()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_10_30.convertContactPoint(t));
        tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        tgt.setUrl(src.getUrl());
        for (org.hl7.fhir.dstu2.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_10_30.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus convertDeviceStatus(org.hl7.fhir.dstu2.model.Device.DeviceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case AVAILABLE:
                return org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.ACTIVE;
            case NOTAVAILABLE:
                return org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Device.DeviceStatus convertDeviceStatus(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.Device.DeviceStatus.AVAILABLE;
            case INACTIVE:
                return org.hl7.fhir.dstu2.model.Device.DeviceStatus.NOTAVAILABLE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Device.DeviceStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu2.model.Device.DeviceStatus.NULL;
        }
    }
}
