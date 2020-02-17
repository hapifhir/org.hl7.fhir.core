package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Location10_50 {

    public static org.hl7.fhir.dstu2.model.Location convertLocation(org.hl7.fhir.r5.model.Location src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Location tgt = new org.hl7.fhir.dstu2.model.Location();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertLocationStatus(src.getStatus()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        if (src.hasMode())
            tgt.setMode(convertLocationMode(src.getMode()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_50.convertCodeableConcept(src.getTypeFirstRep()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_10_50.convertAddress(src.getAddress()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(VersionConvertor_10_50.convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPosition())
            tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_10_50.convertReference(src.getManagingOrganization()));
        if (src.hasPartOf())
            tgt.setPartOf(VersionConvertor_10_50.convertReference(src.getPartOf()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Location convertLocation(org.hl7.fhir.dstu2.model.Location src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Location tgt = new org.hl7.fhir.r5.model.Location();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertLocationStatus(src.getStatus()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        if (src.hasMode())
            tgt.setMode(convertLocationMode(src.getMode()));
        if (src.hasType())
            tgt.addType(VersionConvertor_10_50.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_10_50.convertAddress(src.getAddress()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(VersionConvertor_10_50.convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPosition())
            tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_10_50.convertReference(src.getManagingOrganization()));
        if (src.hasPartOf())
            tgt.setPartOf(VersionConvertor_10_50.convertReference(src.getPartOf()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Location.LocationMode convertLocationMode(org.hl7.fhir.dstu2.model.Location.LocationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.r5.model.Location.LocationMode.INSTANCE;
            case KIND:
                return org.hl7.fhir.r5.model.Location.LocationMode.KIND;
            default:
                return org.hl7.fhir.r5.model.Location.LocationMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Location.LocationMode convertLocationMode(org.hl7.fhir.r5.model.Location.LocationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.dstu2.model.Location.LocationMode.INSTANCE;
            case KIND:
                return org.hl7.fhir.dstu2.model.Location.LocationMode.KIND;
            default:
                return org.hl7.fhir.dstu2.model.Location.LocationMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.dstu2.model.Location.LocationPositionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.r5.model.Location.LocationPositionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasLongitudeElement())
            tgt.setLongitudeElement(VersionConvertor_10_50.convertDecimal(src.getLongitudeElement()));
        if (src.hasLatitudeElement())
            tgt.setLatitudeElement(VersionConvertor_10_50.convertDecimal(src.getLatitudeElement()));
        if (src.hasAltitudeElement())
            tgt.setAltitudeElement(VersionConvertor_10_50.convertDecimal(src.getAltitudeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.r5.model.Location.LocationPositionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.dstu2.model.Location.LocationPositionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasLongitudeElement())
            tgt.setLongitudeElement(VersionConvertor_10_50.convertDecimal(src.getLongitudeElement()));
        if (src.hasLatitudeElement())
            tgt.setLatitudeElement(VersionConvertor_10_50.convertDecimal(src.getLatitudeElement()));
        if (src.hasAltitudeElement())
            tgt.setAltitudeElement(VersionConvertor_10_50.convertDecimal(src.getAltitudeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Location.LocationStatus convertLocationStatus(org.hl7.fhir.r5.model.Location.LocationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.Location.LocationStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.dstu2.model.Location.LocationStatus.SUSPENDED;
            case INACTIVE:
                return org.hl7.fhir.dstu2.model.Location.LocationStatus.INACTIVE;
            default:
                return org.hl7.fhir.dstu2.model.Location.LocationStatus.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Location.LocationStatus convertLocationStatus(org.hl7.fhir.dstu2.model.Location.LocationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r5.model.Location.LocationStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.r5.model.Location.LocationStatus.SUSPENDED;
            case INACTIVE:
                return org.hl7.fhir.r5.model.Location.LocationStatus.INACTIVE;
            default:
                return org.hl7.fhir.r5.model.Location.LocationStatus.NULL;
        }
    }
}
