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
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasResponsible())
            tgt.setResponsibleElement(VersionConvertor_30_40.convertString(src.getResponsibleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_30_40.convertString(src.getUsageElement()));
        for (org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu3.model.NamingSystem src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.NamingSystem tgt = new org.hl7.fhir.r4.model.NamingSystem();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasResponsible())
            tgt.setResponsibleElement(VersionConvertor_30_40.convertString(src.getResponsibleElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasUsage())
            tgt.setUsageElement(VersionConvertor_30_40.convertString(src.getUsageElement()));
        for (org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case OID:
                tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.OID);
                break;
            case UUID:
                tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.UUID);
                break;
            case URI:
                tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.URI);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CODESYSTEM:
                tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.CODESYSTEM);
                break;
            case IDENTIFIER:
                tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.IDENTIFIER);
                break;
            case ROOT:
                tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.ROOT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.NamingSystem.NamingSystemTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
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

    public static org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.r4.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
        if (src.hasValue())
            tgt.setValueElement(VersionConvertor_30_40.convertString(src.getValueElement()));
        if (src.hasPreferred())
            tgt.setPreferredElement(VersionConvertor_30_40.convertBoolean(src.getPreferredElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
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
            tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
        if (src.hasValue())
            tgt.setValueElement(VersionConvertor_30_40.convertString(src.getValueElement()));
        if (src.hasPreferred())
            tgt.setPreferredElement(VersionConvertor_30_40.convertBoolean(src.getPreferredElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        return tgt;
    }
}