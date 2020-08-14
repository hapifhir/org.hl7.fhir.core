package org.hl7.fhir.convertors.conv14_50;

import org.hl7.fhir.convertors.VersionConvertor_14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class NamingSystem14_50 {

    public static org.hl7.fhir.r5.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu2016may.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.NamingSystem tgt = new org.hl7.fhir.r5.model.NamingSystem();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_14_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        if (src.hasResponsible())
            tgt.setResponsibleElement(VersionConvertor_14_50.convertString(src.getResponsibleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_14_50.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_50.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_14_50.convertString(src.getUsageElement()));
        for (org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.NamingSystem convertNamingSystem(org.hl7.fhir.r5.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.NamingSystem tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_14_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        if (src.hasResponsible())
            tgt.setResponsibleElement(VersionConvertor_14_50.convertString(src.getResponsibleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_14_50.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_50.convertCodeableConcept(t));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_14_50.convertString(src.getUsageElement()));
        for (org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent convertNamingSystemContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertNamingSystemContactComponent(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_50.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case OID:
                tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.OID);
                break;
            case UUID:
                tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.UUID);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.URI);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case OID:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.OID);
                break;
            case UUID:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.UUID);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.URI);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemIdentifierType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODESYSTEM:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.CODESYSTEM);
                break;
            case IDENTIFIER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.IDENTIFIER);
                break;
            case ROOT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.ROOT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.NamingSystem.NamingSystemTypeEnumFactory());
        VersionConvertor_14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODESYSTEM:
                tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.CODESYSTEM);
                break;
            case IDENTIFIER:
                tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.IDENTIFIER);
                break;
            case ROOT:
                tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.ROOT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.NamingSystem.NamingSystemType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_14_50.convertString(src.getValueElement()));
        if (src.hasPreferred())
            tgt.setPreferredElement(VersionConvertor_14_50.convertBoolean(src.getPreferredElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_14_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu2016may.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r5.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_14_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_14_50.convertString(src.getValueElement()));
        if (src.hasPreferred())
            tgt.setPreferredElement(VersionConvertor_14_50.convertBoolean(src.getPreferredElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_14_50.convertPeriod(src.getPeriod()));
        return tgt;
    }
}