package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class NamingSystem14_50 {

    public static org.hl7.fhir.r5.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu2016may.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.NamingSystem tgt = new org.hl7.fhir.r5.model.NamingSystem();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatus()));
        tgt.setKind(convertNamingSystemType(src.getKind()));
        tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        if (src.hasResponsible())
            tgt.setResponsible(src.getResponsible());
        tgt.setType(VersionConvertor_14_50.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasUsage())
            tgt.setUsage(src.getUsage());
        for (org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.NamingSystem convertNamingSystem(org.hl7.fhir.r5.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.NamingSystem tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatus()));
        tgt.setKind(convertNamingSystemType(src.getKind()));
        tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        if (src.hasResponsible())
            tgt.setResponsible(src.getResponsible());
        tgt.setType(VersionConvertor_14_50.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t));
        if (src.hasUsage())
            tgt.setUsage(src.getUsage());
        for (org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent convertNamingSystemContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertNamingSystemContactComponent(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType convertNamingSystemIdentifierType(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OID:
                return org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.OID;
            case UUID:
                return org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.UUID;
            case URI:
                return org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.URI;
            case OTHER:
                return org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.OTHER;
            default:
                return org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType convertNamingSystemIdentifierType(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OID:
                return org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.OID;
            case UUID:
                return org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.UUID;
            case URI:
                return org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.URI;
            case OTHER:
                return org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.OTHER;
            default:
                return org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType convertNamingSystemType(org.hl7.fhir.r5.model.NamingSystem.NamingSystemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODESYSTEM:
                return org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.CODESYSTEM;
            case IDENTIFIER:
                return org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.IDENTIFIER;
            case ROOT:
                return org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.ROOT;
            default:
                return org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.NamingSystem.NamingSystemType convertNamingSystemType(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODESYSTEM:
                return org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.CODESYSTEM;
            case IDENTIFIER:
                return org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.IDENTIFIER;
            case ROOT:
                return org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.ROOT;
            default:
                return org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        tgt.setType(convertNamingSystemIdentifierType(src.getType()));
        tgt.setValue(src.getValue());
        if (src.hasPreferred())
            tgt.setPreferred(src.getPreferred());
        tgt.setPeriod(VersionConvertor_14_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        tgt.setType(convertNamingSystemIdentifierType(src.getType()));
        tgt.setValue(src.getValue());
        if (src.hasPreferred())
            tgt.setPreferred(src.getPreferred());
        tgt.setPeriod(VersionConvertor_14_50.convertPeriod(src.getPeriod()));
        return tgt;
    }
}
