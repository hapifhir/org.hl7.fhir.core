package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Location30_50 {

    public static org.hl7.fhir.r5.model.Location convertLocation(org.hl7.fhir.dstu3.model.Location src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Location tgt = new org.hl7.fhir.r5.model.Location();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertLocationStatus(src.getStatusElement()));
        if (src.hasOperationalStatus())
            tgt.setOperationalStatus(VersionConvertor_30_50.convertCoding(src.getOperationalStatus()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasMode())
            tgt.setModeElement(convertLocationMode(src.getModeElement()));
        if (src.hasType())
            tgt.addType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_30_50.convertAddress(src.getAddress()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(VersionConvertor_30_50.convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPosition())
            tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_50.convertReference(src.getManagingOrganization()));
        if (src.hasPartOf())
            tgt.setPartOf(VersionConvertor_30_50.convertReference(src.getPartOf()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Location convertLocation(org.hl7.fhir.r5.model.Location src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Location tgt = new org.hl7.fhir.dstu3.model.Location();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertLocationStatus(src.getStatusElement()));
        if (src.hasOperationalStatus())
            tgt.setOperationalStatus(VersionConvertor_30_50.convertCoding(src.getOperationalStatus()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasMode())
            tgt.setModeElement(convertLocationMode(src.getModeElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getTypeFirstRep()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_50.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_30_50.convertAddress(src.getAddress()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(VersionConvertor_30_50.convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPosition())
            tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_50.convertReference(src.getManagingOrganization()));
        if (src.hasPartOf())
            tgt.setPartOf(VersionConvertor_30_50.convertReference(src.getPartOf()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Location.LocationMode> convertLocationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Location.LocationMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Location.LocationModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Location.LocationMode.INSTANCE);
                break;
            case KIND:
                tgt.setValue(org.hl7.fhir.dstu3.model.Location.LocationMode.KIND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Location.LocationMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationMode> convertLocationMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Location.LocationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Location.LocationModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.r5.model.Location.LocationMode.INSTANCE);
                break;
            case KIND:
                tgt.setValue(org.hl7.fhir.r5.model.Location.LocationMode.KIND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Location.LocationMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.r5.model.Location.LocationPositionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.dstu3.model.Location.LocationPositionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLongitude())
            tgt.setLongitudeElement(VersionConvertor_30_50.convertDecimal(src.getLongitudeElement()));
        if (src.hasLatitude())
            tgt.setLatitudeElement(VersionConvertor_30_50.convertDecimal(src.getLatitudeElement()));
        if (src.hasAltitude())
            tgt.setAltitudeElement(VersionConvertor_30_50.convertDecimal(src.getAltitudeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.dstu3.model.Location.LocationPositionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.r5.model.Location.LocationPositionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLongitude())
            tgt.setLongitudeElement(VersionConvertor_30_50.convertDecimal(src.getLongitudeElement()));
        if (src.hasLatitude())
            tgt.setLatitudeElement(VersionConvertor_30_50.convertDecimal(src.getLatitudeElement()));
        if (src.hasAltitude())
            tgt.setAltitudeElement(VersionConvertor_30_50.convertDecimal(src.getAltitudeElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Location.LocationStatus> convertLocationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Location.LocationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Location.LocationStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Location.LocationStatus.ACTIVE);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Location.LocationStatus.SUSPENDED);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Location.LocationStatus.INACTIVE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Location.LocationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> convertLocationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Location.LocationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Location.LocationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Location.LocationStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.ACTIVE);
                break;
            case SUSPENDED:
                tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.SUSPENDED);
                break;
            case INACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.INACTIVE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Location.LocationStatus.NULL);
                break;
        }
        return tgt;
    }
}