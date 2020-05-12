package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class List30_50 {

    public static org.hl7.fhir.r5.model.ListResource convertList(org.hl7.fhir.dstu3.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ListResource tgt = new org.hl7.fhir.r5.model.ListResource();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertListStatus(src.getStatusElement()));
        if (src.hasMode())
            tgt.setModeElement(convertListMode(src.getModeElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_50.convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_50.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_30_50.convertCodeableConcept(src.getEmptyReason()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource convertList(org.hl7.fhir.r5.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ListResource tgt = new org.hl7.fhir.dstu3.model.ListResource();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertListStatus(src.getStatusElement()));
        if (src.hasMode())
            tgt.setModeElement(convertListMode(src.getModeElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_50.convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_50.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_30_50.convertCodeableConcept(src.getEmptyReason()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent convertListEntryComponent(org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent tgt = new org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(VersionConvertor_30_50.convertCodeableConcept(src.getFlag()));
        if (src.hasDeleted())
            tgt.setDeletedElement(VersionConvertor_30_50.convertBoolean(src.getDeletedElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(VersionConvertor_30_50.convertReference(src.getItem()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent convertListEntryComponent(org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent tgt = new org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(VersionConvertor_30_50.convertCodeableConcept(src.getFlag()));
        if (src.hasDeleted())
            tgt.setDeletedElement(VersionConvertor_30_50.convertBoolean(src.getDeletedElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(VersionConvertor_30_50.convertReference(src.getItem()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> convertListMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ListModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case WORKING:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.WORKING);
                break;
            case SNAPSHOT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.SNAPSHOT);
                break;
            case CHANGES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.CHANGES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListMode> convertListMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ListResource.ListModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case WORKING:
                tgt.setValue(org.hl7.fhir.dstu3.model.ListResource.ListMode.WORKING);
                break;
            case SNAPSHOT:
                tgt.setValue(org.hl7.fhir.dstu3.model.ListResource.ListMode.SNAPSHOT);
                break;
            case CHANGES:
                tgt.setValue(org.hl7.fhir.dstu3.model.ListResource.ListMode.CHANGES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ListResource.ListMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ListResource.ListStatus> convertListStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ListResource.ListStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ListResource.ListStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.r5.model.ListResource.ListStatus.CURRENT);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.r5.model.ListResource.ListStatus.RETIRED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.ListResource.ListStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ListResource.ListStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListStatus> convertListStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ListResource.ListStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ListResource.ListStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.ListResource.ListStatus.CURRENT);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.dstu3.model.ListResource.ListStatus.RETIRED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.ListResource.ListStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.ListResource.ListStatus.NULL);
                break;
        }
        return tgt;
    }
}