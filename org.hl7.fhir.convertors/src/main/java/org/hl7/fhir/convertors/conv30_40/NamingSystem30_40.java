package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class NamingSystem30_40 {

    public static org.hl7.fhir.dstu3.model.NamingSystem convertNamingSystem(org.hl7.fhir.r4.model.NamingSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.NamingSystem tgt = new org.hl7.fhir.dstu3.model.NamingSystem();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasKind())
            tgt.setKind(convertNamingSystemType(src.getKind()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasResponsible())
            tgt.setResponsible(src.getResponsible());
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasUsage())
            tgt.setUsage(src.getUsage());
        for (org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu3.model.NamingSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.NamingSystem tgt = new org.hl7.fhir.r4.model.NamingSystem();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasKind())
            tgt.setKind(convertNamingSystemType(src.getKind()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasResponsible())
            tgt.setResponsible(src.getResponsible());
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasUsage())
            tgt.setUsage(src.getUsage());
        for (org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType convertNamingSystemIdentifierType(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OID:
                return org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.OID;
            case UUID:
                return org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.UUID;
            case URI:
                return org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.URI;
            case OTHER:
                return org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.OTHER;
            default:
                return org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType convertNamingSystemIdentifierType(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OID:
                return org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.OID;
            case UUID:
                return org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.UUID;
            case URI:
                return org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.URI;
            case OTHER:
                return org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.OTHER;
            default:
                return org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType convertNamingSystemType(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODESYSTEM:
                return org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.CODESYSTEM;
            case IDENTIFIER:
                return org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.IDENTIFIER;
            case ROOT:
                return org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.ROOT;
            default:
                return org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.NamingSystem.NamingSystemType convertNamingSystemType(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODESYSTEM:
                return org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.CODESYSTEM;
            case IDENTIFIER:
                return org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.IDENTIFIER;
            case ROOT:
                return org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.ROOT;
            default:
                return org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertNamingSystemIdentifierType(src.getType()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        if (src.hasPreferred())
            tgt.setPreferred(src.getPreferred());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertNamingSystemIdentifierType(src.getType()));
        if (src.hasValue())
            tgt.setValue(src.getValue());
        if (src.hasPreferred())
            tgt.setPreferred(src.getPreferred());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }
}
