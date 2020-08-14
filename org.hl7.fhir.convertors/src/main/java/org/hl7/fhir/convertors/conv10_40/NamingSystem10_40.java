package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class NamingSystem10_40 {

    public static org.hl7.fhir.r4.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu2.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.NamingSystem tgt = new org.hl7.fhir.r4.model.NamingSystem();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        if (src.hasResponsibleElement())
            tgt.setResponsibleElement(VersionConvertor_10_40.convertString(src.getResponsibleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConceptToUsageContext(t));
        if (src.hasUsageElement())
            tgt.setUsageElement(VersionConvertor_10_40.convertString(src.getUsageElement()));
        for (org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem convertNamingSystem(org.hl7.fhir.r4.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.NamingSystem tgt = new org.hl7.fhir.dstu2.model.NamingSystem();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        if (src.hasResponsibleElement())
            tgt.setResponsibleElement(VersionConvertor_10_40.convertString(src.getResponsibleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t));
        if (src.hasUsageElement())
            tgt.setUsageElement(VersionConvertor_10_40.convertString(src.getUsageElement()));
        for (org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertNamingSystemContactComponent(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent convertNamingSystemContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent tgt = new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case OID:
                tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.OID);
                break;
            case UUID:
                tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.UUID);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.URI);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case OID:
                tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.OID);
                break;
            case UUID:
                tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.UUID);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.URI);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemTypeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODESYSTEM:
                tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.CODESYSTEM);
                break;
            case IDENTIFIER:
                tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.IDENTIFIER);
                break;
            case ROOT:
                tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.ROOT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.NamingSystem.NamingSystemTypeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODESYSTEM:
                tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.CODESYSTEM);
                break;
            case IDENTIFIER:
                tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.IDENTIFIER);
                break;
            case ROOT:
                tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.ROOT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.NamingSystem.NamingSystemType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_10_40.convertString(src.getValueElement()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement(VersionConvertor_10_40.convertBoolean(src.getPreferredElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_10_40.convertString(src.getValueElement()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement(VersionConvertor_10_40.convertBoolean(src.getPreferredElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        return tgt;
    }
}