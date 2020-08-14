package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class List10_30 {

    public static org.hl7.fhir.dstu2.model.List_ convertList(org.hl7.fhir.dstu3.model.ListResource src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.List_ tgt = new org.hl7.fhir.dstu2.model.List_();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasTitleElement())
            tgt.setTitleElement(VersionConvertor_10_30.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_10_30.convertReference(src.getSource()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        if (src.hasStatus())
            tgt.setStatusElement(convertListStatus(src.getStatusElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_10_30.convertCodeableConcept(src.getOrderedBy()));
        if (src.hasMode())
            tgt.setModeElement(convertListMode(src.getModeElement()));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        for (org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntry(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource convertList(org.hl7.fhir.dstu2.model.List_ src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ListResource tgt = new org.hl7.fhir.dstu3.model.ListResource();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasTitleElement())
            tgt.setTitleElement(VersionConvertor_10_30.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_10_30.convertReference(src.getSource()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        if (src.hasStatus())
            tgt.setStatusElement(convertListStatus(src.getStatusElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_10_30.convertCodeableConcept(src.getOrderedBy()));
        if (src.hasMode())
            tgt.setModeElement(convertListMode(src.getModeElement()));
        if (src.hasNote())
            tgt.addNote(new org.hl7.fhir.dstu3.model.Annotation().setText(src.getNote()));
        for (org.hl7.fhir.dstu2.model.List_.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntry(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent convertListEntry(org.hl7.fhir.dstu2.model.List_.ListEntryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent tgt = new org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent();
        copyBackboneElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(VersionConvertor_10_30.convertCodeableConcept(src.getFlag()));
        if (src.hasDeletedElement())
            tgt.setDeletedElement(VersionConvertor_10_30.convertBoolean(src.getDeletedElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(VersionConvertor_10_30.convertReference(src.getItem()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.List_.ListEntryComponent convertListEntry(org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.List_.ListEntryComponent tgt = new org.hl7.fhir.dstu2.model.List_.ListEntryComponent();
        copyBackboneElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(VersionConvertor_10_30.convertCodeableConcept(src.getFlag()));
        if (src.hasDeletedElement())
            tgt.setDeletedElement(VersionConvertor_10_30.convertBoolean(src.getDeletedElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(VersionConvertor_10_30.convertReference(src.getItem()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListMode> convertListMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ListResource.ListModeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListMode> convertListMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.List_.ListModeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case WORKING:
                tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListMode.WORKING);
                break;
            case SNAPSHOT:
                tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListMode.SNAPSHOT);
                break;
            case CHANGES:
                tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListMode.CHANGES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListStatus> convertListStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.List_.ListStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListStatus.CURRENT);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListStatus.RETIRED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListStatus> convertListStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ListResource.ListStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
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

    public static void copyBackboneElement(org.hl7.fhir.dstu2.model.BackboneElement src, org.hl7.fhir.dstu3.model.BackboneElement tgt) throws FHIRException {
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(VersionConvertor_10_30.convertExtension(e));
        }
    }

    public static void copyBackboneElement(org.hl7.fhir.dstu3.model.BackboneElement src, org.hl7.fhir.dstu2.model.BackboneElement tgt) throws FHIRException {
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Extension e : src.getModifierExtension()) {
            tgt.addModifierExtension(VersionConvertor_10_30.convertExtension(e));
        }
    }
}