package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class NamingSystem10_40 {

    public static org.hl7.fhir.r4.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu2.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.NamingSystem tgt = new org.hl7.fhir.r4.model.NamingSystem();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasKind()) {
            tgt.setKind(convertNamingSystemType(src.getKind()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher()) {
            tgt.setPublisher(src.getPublisher());
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        }
        if (src.hasResponsible()) {
            tgt.setResponsible(src.getResponsible());
        }
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConceptToUsageContext(t));
        if (src.hasUsage()) {
            tgt.setUsage(src.getUsage());
        }
        if (src.hasUniqueId()) {
            for (org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem convertNamingSystem(org.hl7.fhir.r4.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.NamingSystem tgt = new org.hl7.fhir.dstu2.model.NamingSystem();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasKind()) {
            tgt.setKind(convertNamingSystemType(src.getKind()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher()) {
            tgt.setPublisher(src.getPublisher());
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        }
        if (src.hasResponsible()) {
            tgt.setResponsible(src.getResponsible());
        }
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t));
        }
        if (src.hasUsage()) {
            tgt.setUsage(src.getUsage());
        }
        if (src.hasUniqueId()) {
            for (org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertNamingSystemContactComponent(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent convertNamingSystemContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent tgt = new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType convertNamingSystemIdentifierType(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OID:
                return org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.OID;
            case UUID:
                return org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.UUID;
            case URI:
                return org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.URI;
            case OTHER:
                return org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.OTHER;
            default:
                return org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType convertNamingSystemIdentifierType(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType convertNamingSystemType(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CODESYSTEM:
                return org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.CODESYSTEM;
            case IDENTIFIER:
                return org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.IDENTIFIER;
            case ROOT:
                return org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.ROOT;
            default:
                return org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.NamingSystem.NamingSystemType convertNamingSystemType(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType src) throws FHIRException {
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

    public static org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(convertNamingSystemIdentifierType(src.getType()));
        }
        if (src.hasValue()) {
            tgt.setValue(src.getValue());
        }
        if (src.hasPreferred()) {
            tgt.setPreferred(src.getPreferred());
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(convertNamingSystemIdentifierType(src.getType()));
        }
        if (src.hasValue()) {
            tgt.setValue(src.getValue());
        }
        if (src.hasPreferred()) {
            tgt.setPreferred(src.getPreferred());
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }
}
