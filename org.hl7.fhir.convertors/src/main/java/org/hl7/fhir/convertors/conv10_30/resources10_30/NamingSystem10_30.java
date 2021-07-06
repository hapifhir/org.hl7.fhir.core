package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.ContactPoint10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Period10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class NamingSystem10_30 {

    public static org.hl7.fhir.dstu3.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu2.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.NamingSystem tgt = new org.hl7.fhir.dstu3.model.NamingSystem();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(String10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        if (src.hasResponsibleElement())
            tgt.setResponsibleElement(String10_30.convertString(src.getResponsibleElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept10_30.convertCodeableConceptToUsageContext(t));
        if (src.hasUsageElement())
            tgt.setUsageElement(String10_30.convertString(src.getUsageElement()));
        for (org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        if (src.hasReplacedBy())
            tgt.setReplacedBy(Reference10_30.convertReference(src.getReplacedBy()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem convertNamingSystem(org.hl7.fhir.dstu3.model.NamingSystem src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.NamingSystem tgt = new org.hl7.fhir.dstu2.model.NamingSystem();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasKind())
            tgt.setKindElement(convertNamingSystemType(src.getKindElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(String10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertNamingSystemContactComponent(t));
        if (src.hasResponsibleElement())
            tgt.setResponsibleElement(String10_30.convertString(src.getResponsibleElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(CodeableConcept10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept10_30.convertCodeableConcept(t));
        if (src.hasUsageElement())
            tgt.setUsageElement(String10_30.convertString(src.getUsageElement()));
        for (org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent t : src.getUniqueId()) tgt.addUniqueId(convertNamingSystemUniqueIdComponent(t));
        if (src.hasReplacedBy())
            tgt.setReplacedBy(Reference10_30.convertReference(src.getReplacedBy()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent convertNamingSystemContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent tgt = new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertNamingSystemContactComponent(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        Element10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
        Element10_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType> convertNamingSystemIdentifierType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemIdentifierType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemIdentifierTypeEnumFactory());
        Element10_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemTypeEnumFactory());
        Element10_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType> convertNamingSystemType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemTypeEnumFactory());
        Element10_30.copyElement(src, tgt);
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

    public static org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
        if (src.hasValueElement())
            tgt.setValueElement(String10_30.convertString(src.getValueElement()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement(Boolean10_30.convertBoolean(src.getPreferredElement()));
        if (src.hasPeriod())
            tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent convertNamingSystemUniqueIdComponent(org.hl7.fhir.dstu3.model.NamingSystem.NamingSystemUniqueIdComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent tgt = new org.hl7.fhir.dstu2.model.NamingSystem.NamingSystemUniqueIdComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertNamingSystemIdentifierType(src.getTypeElement()));
        if (src.hasValueElement())
            tgt.setValueElement(String10_30.convertString(src.getValueElement()));
        if (src.hasPreferredElement())
            tgt.setPreferredElement(Boolean10_30.convertBoolean(src.getPreferredElement()));
        if (src.hasPeriod())
            tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
        return tgt;
    }
}