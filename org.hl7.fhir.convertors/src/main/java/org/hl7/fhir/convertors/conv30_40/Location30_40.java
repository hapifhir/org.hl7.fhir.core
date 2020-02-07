package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Location30_40 {

    public static org.hl7.fhir.r4.model.Location convertLocation(org.hl7.fhir.dstu3.model.Location src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Location tgt = new org.hl7.fhir.r4.model.Location();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertLocationStatus(src.getStatus()));
        if (src.hasOperationalStatus())
            tgt.setOperationalStatus(VersionConvertor_30_40.convertCoding(src.getOperationalStatus()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasAlias()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasMode())
            tgt.setMode(convertLocationMode(src.getMode()));
        if (src.hasType())
            tgt.addType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_30_40.convertAddress(src.getAddress()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(VersionConvertor_30_40.convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPosition())
            tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_40.convertReference(src.getManagingOrganization()));
        if (src.hasPartOf())
            tgt.setPartOf(VersionConvertor_30_40.convertReference(src.getPartOf()));
        if (src.hasEndpoint()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Location convertLocation(org.hl7.fhir.r4.model.Location src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Location tgt = new org.hl7.fhir.dstu3.model.Location();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertLocationStatus(src.getStatus()));
        if (src.hasOperationalStatus())
            tgt.setOperationalStatus(VersionConvertor_30_40.convertCoding(src.getOperationalStatus()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasAlias()) {
            for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.addAlias(t.getValue());
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasMode())
            tgt.setMode(convertLocationMode(src.getMode()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getTypeFirstRep()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasAddress())
            tgt.setAddress(VersionConvertor_30_40.convertAddress(src.getAddress()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(VersionConvertor_30_40.convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPosition())
            tgt.setPosition(convertLocationPositionComponent(src.getPosition()));
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_40.convertReference(src.getManagingOrganization()));
        if (src.hasPartOf())
            tgt.setPartOf(VersionConvertor_30_40.convertReference(src.getPartOf()));
        if (src.hasEndpoint()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Location.LocationMode convertLocationMode(org.hl7.fhir.dstu3.model.Location.LocationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.r4.model.Location.LocationMode.INSTANCE;
            case KIND:
                return org.hl7.fhir.r4.model.Location.LocationMode.KIND;
            default:
                return org.hl7.fhir.r4.model.Location.LocationMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Location.LocationMode convertLocationMode(org.hl7.fhir.r4.model.Location.LocationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.dstu3.model.Location.LocationMode.INSTANCE;
            case KIND:
                return org.hl7.fhir.dstu3.model.Location.LocationMode.KIND;
            default:
                return org.hl7.fhir.dstu3.model.Location.LocationMode.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.dstu3.model.Location.LocationPositionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.r4.model.Location.LocationPositionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLongitudeElement())
            tgt.setLongitudeElement((org.hl7.fhir.r4.model.DecimalType) VersionConvertor_30_40.convertType(src.getLongitudeElement()));
        if (src.hasLatitudeElement())
            tgt.setLatitudeElement((org.hl7.fhir.r4.model.DecimalType) VersionConvertor_30_40.convertType(src.getLatitudeElement()));
        if (src.hasAltitudeElement())
            tgt.setAltitudeElement((org.hl7.fhir.r4.model.DecimalType) VersionConvertor_30_40.convertType(src.getAltitudeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Location.LocationPositionComponent convertLocationPositionComponent(org.hl7.fhir.r4.model.Location.LocationPositionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Location.LocationPositionComponent tgt = new org.hl7.fhir.dstu3.model.Location.LocationPositionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLongitudeElement())
            tgt.setLongitudeElement((org.hl7.fhir.dstu3.model.DecimalType) VersionConvertor_30_40.convertType(src.getLongitudeElement()));
        if (src.hasLatitudeElement())
            tgt.setLatitudeElement((org.hl7.fhir.dstu3.model.DecimalType) VersionConvertor_30_40.convertType(src.getLatitudeElement()));
        if (src.hasAltitudeElement())
            tgt.setAltitudeElement((org.hl7.fhir.dstu3.model.DecimalType) VersionConvertor_30_40.convertType(src.getAltitudeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Location.LocationStatus convertLocationStatus(org.hl7.fhir.dstu3.model.Location.LocationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r4.model.Location.LocationStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.r4.model.Location.LocationStatus.SUSPENDED;
            case INACTIVE:
                return org.hl7.fhir.r4.model.Location.LocationStatus.INACTIVE;
            default:
                return org.hl7.fhir.r4.model.Location.LocationStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Location.LocationStatus convertLocationStatus(org.hl7.fhir.r4.model.Location.LocationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.Location.LocationStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.dstu3.model.Location.LocationStatus.SUSPENDED;
            case INACTIVE:
                return org.hl7.fhir.dstu3.model.Location.LocationStatus.INACTIVE;
            default:
                return org.hl7.fhir.dstu3.model.Location.LocationStatus.NULL;
        }
    }
}
