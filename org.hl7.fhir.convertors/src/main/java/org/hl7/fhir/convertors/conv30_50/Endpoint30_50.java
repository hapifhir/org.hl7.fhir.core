package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Endpoint30_50 {

    public static org.hl7.fhir.dstu3.model.Endpoint convertEndpoint(org.hl7.fhir.r5.model.Endpoint src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Endpoint tgt = new org.hl7.fhir.dstu3.model.Endpoint();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertEndpointStatus(src.getStatus()));
        if (src.hasConnectionType())
            tgt.setConnectionType(VersionConvertor_30_50.convertCoding(src.getConnectionType()));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_50.convertReference(src.getManagingOrganization()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactPoint(t));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPayloadType()) tgt.addPayloadType(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeType t : src.getPayloadMimeType()) tgt.addPayloadMimeType(t.getValue());
        if (src.hasAddress())
            tgt.setAddress(src.getAddress());
        for (org.hl7.fhir.r5.model.StringType t : src.getHeader()) tgt.addHeader(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Endpoint convertEndpoint(org.hl7.fhir.dstu3.model.Endpoint src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Endpoint tgt = new org.hl7.fhir.r5.model.Endpoint();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertEndpointStatus(src.getStatus()));
        if (src.hasConnectionType())
            tgt.setConnectionType(VersionConvertor_30_50.convertCoding(src.getConnectionType()));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasManagingOrganization())
            tgt.setManagingOrganization(VersionConvertor_30_50.convertReference(src.getManagingOrganization()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactPoint(t));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPayloadType()) tgt.addPayloadType(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getPayloadMimeType()) tgt.addPayloadMimeType(t.getValue());
        if (src.hasAddress())
            tgt.setAddress(src.getAddress());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getHeader()) tgt.addHeader(t.getValue());
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Endpoint.EndpointStatus convertEndpointStatus(org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.SUSPENDED;
            case ERROR:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.ERROR;
            case OFF:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.OFF;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.ENTEREDINERROR;
            case TEST:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.TEST;
            default:
                return org.hl7.fhir.r5.model.Endpoint.EndpointStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus convertEndpointStatus(org.hl7.fhir.r5.model.Endpoint.EndpointStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.ACTIVE;
            case SUSPENDED:
                return org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.SUSPENDED;
            case ERROR:
                return org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.ERROR;
            case OFF:
                return org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.OFF;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.ENTEREDINERROR;
            case TEST:
                return org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.TEST;
            default:
                return org.hl7.fhir.dstu3.model.Endpoint.EndpointStatus.NULL;
        }
    }
}
