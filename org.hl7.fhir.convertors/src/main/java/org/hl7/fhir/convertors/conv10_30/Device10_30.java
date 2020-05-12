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
        if (src.hasStatus())
            tgt.setStatusElement(convertDeviceStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasLotNumberElement())
            tgt.setLotNumberElement(VersionConvertor_10_30.convertString(src.getLotNumberElement()));
        if (src.hasManufacturerElement())
            tgt.setManufacturerElement(VersionConvertor_10_30.convertString(src.getManufacturerElement()));
        if (src.hasManufactureDateElement())
            tgt.setManufactureDateElement(VersionConvertor_10_30.convertDateTime(src.getManufactureDateElement()));
        if (src.hasExpirationDateElement())
            tgt.setExpiryElement(VersionConvertor_10_30.convertDateTime(src.getExpirationDateElement()));
        if (src.hasModelElement())
            tgt.setModelElement(VersionConvertor_10_30.convertString(src.getModelElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        if (src.hasOwner())
            tgt.setOwner(VersionConvertor_10_30.convertReference(src.getOwner()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_10_30.convertContactPoint(t));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_10_30.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Device convertDevice(org.hl7.fhir.dstu2.model.Device src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Device tgt = new org.hl7.fhir.dstu3.model.Device();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasUdi())
            tgt.setUdi((new org.hl7.fhir.dstu3.model.Device.DeviceUdiComponent()).setDeviceIdentifier(src.getUdi()));
        if (src.hasStatus())
            tgt.setStatusElement(convertDeviceStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasLotNumberElement())
            tgt.setLotNumberElement(VersionConvertor_10_30.convertString(src.getLotNumberElement()));
        if (src.hasManufacturerElement())
            tgt.setManufacturerElement(VersionConvertor_10_30.convertString(src.getManufacturerElement()));
        if (src.hasManufactureDateElement())
            tgt.setManufactureDateElement(VersionConvertor_10_30.convertDateTime(src.getManufactureDateElement()));
        if (src.hasExpiryElement())
            tgt.setExpirationDateElement(VersionConvertor_10_30.convertDateTime(src.getExpiryElement()));
        if (src.hasModelElement())
            tgt.setModelElement(VersionConvertor_10_30.convertString(src.getModelElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        if (src.hasOwner())
            tgt.setOwner(VersionConvertor_10_30.convertReference(src.getOwner()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_10_30.convertContactPoint(t));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu2.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_10_30.convertAnnotation(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus> convertDeviceStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Device.DeviceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case AVAILABLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.ACTIVE);
                break;
            case NOTAVAILABLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.INACTIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Device.DeviceStatus> convertDeviceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Device.FHIRDeviceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Device.DeviceStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Device.DeviceStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Device.DeviceStatus.AVAILABLE);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Device.DeviceStatus.NOTAVAILABLE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.Device.DeviceStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Device.DeviceStatus.NULL);
                break;
        }
        return tgt;
    }
}