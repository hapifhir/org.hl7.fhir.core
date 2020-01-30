package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class List10_30 {

    public static org.hl7.fhir.dstu2.model.List_ convertList(org.hl7.fhir.dstu3.model.ListResource src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.List_ tgt = new org.hl7.fhir.dstu2.model.List_();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasTitle()) {
            tgt.setTitle(src.getTitle());
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_10_30.convertReference(src.getSource()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertListStatus(src.getStatus()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasOrderedBy()) {
            tgt.setOrderedBy(VersionConvertor_10_30.convertCodeableConcept(src.getOrderedBy()));
        }
        if (src.hasMode()) {
            tgt.setMode(convertListMode(src.getMode()));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        }
        if (src.hasEntry()) {
            for (org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntry(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource convertList(org.hl7.fhir.dstu2.model.List_ src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ListResource tgt = new org.hl7.fhir.dstu3.model.ListResource();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasTitle()) {
            tgt.setTitle(src.getTitle());
        }
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasSubject()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasSource()) {
            tgt.setSource(VersionConvertor_10_30.convertReference(src.getSource()));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertListStatus(src.getStatus()));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasOrderedBy()) {
            tgt.setOrderedBy(VersionConvertor_10_30.convertCodeableConcept(src.getOrderedBy()));
        }
        if (src.hasMode()) {
            tgt.setMode(convertListMode(src.getMode()));
        }
        if (src.hasNote())
            tgt.addNote(new org.hl7.fhir.dstu3.model.Annotation().setText(src.getNote()));
        if (src.hasEntry()) {
            for (org.hl7.fhir.dstu2.model.List_.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntry(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent convertListEntry(org.hl7.fhir.dstu2.model.List_.ListEntryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent tgt = new org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent();
        copyBackboneElement(src, tgt);
        if (src.hasFlag()) {
            tgt.setFlag(VersionConvertor_10_30.convertCodeableConcept(src.getFlag()));
        }
        if (src.hasDeleted()) {
            tgt.setDeleted(src.getDeleted());
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasItem()) {
            tgt.setItem(VersionConvertor_10_30.convertReference(src.getItem()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.List_.ListEntryComponent convertListEntry(org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.List_.ListEntryComponent tgt = new org.hl7.fhir.dstu2.model.List_.ListEntryComponent();
        copyBackboneElement(src, tgt);
        if (src.hasFlag()) {
            tgt.setFlag(VersionConvertor_10_30.convertCodeableConcept(src.getFlag()));
        }
        if (src.hasDeleted()) {
            tgt.setDeleted(src.getDeleted());
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasItem()) {
            tgt.setItem(VersionConvertor_10_30.convertReference(src.getItem()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource.ListMode convertListMode(org.hl7.fhir.dstu2.model.List_.ListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case WORKING:
                return org.hl7.fhir.dstu3.model.ListResource.ListMode.WORKING;
            case SNAPSHOT:
                return org.hl7.fhir.dstu3.model.ListResource.ListMode.SNAPSHOT;
            case CHANGES:
                return org.hl7.fhir.dstu3.model.ListResource.ListMode.CHANGES;
            default:
                return org.hl7.fhir.dstu3.model.ListResource.ListMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.List_.ListMode convertListMode(org.hl7.fhir.dstu3.model.ListResource.ListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case WORKING:
                return org.hl7.fhir.dstu2.model.List_.ListMode.WORKING;
            case SNAPSHOT:
                return org.hl7.fhir.dstu2.model.List_.ListMode.SNAPSHOT;
            case CHANGES:
                return org.hl7.fhir.dstu2.model.List_.ListMode.CHANGES;
            default:
                return org.hl7.fhir.dstu2.model.List_.ListMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.List_.ListStatus convertListStatus(org.hl7.fhir.dstu3.model.ListResource.ListStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CURRENT:
                return org.hl7.fhir.dstu2.model.List_.ListStatus.CURRENT;
            case RETIRED:
                return org.hl7.fhir.dstu2.model.List_.ListStatus.RETIRED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.List_.ListStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu2.model.List_.ListStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.ListResource.ListStatus convertListStatus(org.hl7.fhir.dstu2.model.List_.ListStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CURRENT:
                return org.hl7.fhir.dstu3.model.ListResource.ListStatus.CURRENT;
            case RETIRED:
                return org.hl7.fhir.dstu3.model.ListResource.ListStatus.RETIRED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.ListResource.ListStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.ListResource.ListStatus.NULL;
        }
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
