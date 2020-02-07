package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.dstu2016may.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class NamingSystem14_50 {

    public static org.hl7.fhir.r5.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu2016may.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.NamingSystem tgt = new org.hl7.fhir.r5.model.NamingSystem();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasKind()) {
            tgt.setKind(convertNamingSystemType(src.getKind()));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_14_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        }
        if (src.hasResponsibleElement())
            tgt.setResponsibleElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getResponsibleElement()));
        if (src.hasType()) {
            tgt.setType(VersionConvertor_14_50.convertCodeableConcept(src.getType()));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasUsageElement())
            tgt.setUsageElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getUsageElement()));
        if (src.hasUniqueId()) {
            for (org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.NamingSystem convertNamingSystem(org.hl7.fhir.r5.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.NamingSystem tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasKind()) {
            tgt.setKind(convertNamingSystemType(src.getKind()));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2016may.model.DateTimeType) VersionConvertor_14_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        }
        if (src.hasResponsibleElement())
            tgt.setResponsibleElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getResponsibleElement()));
        if (src.hasType()) {
            tgt.setType(VersionConvertor_14_50.convertCodeableConcept(src.getType()));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t));
        }
        if (src.hasUsageElement())
            tgt.setUsageElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getUsageElement()));
        if (src.hasUniqueId()) {
            for (org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent convertNamingSystemContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertNamingSystemContactComponent(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        }
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
        if (src.hasType()) {
            tgt.setType(convertNamingSystemIdentifierType(src.getType()));
        }
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_50.convertType(src.getValueElement()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_50.convertType(src.getPreferredElement()));
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_14_50.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(convertNamingSystemIdentifierType(src.getType()));
        }
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_14_50.convertType(src.getValueElement()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_14_50.convertType(src.getPreferredElement()));
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_14_50.convertPeriod(src.getPeriod()));
        }
        return tgt;
    }
}
