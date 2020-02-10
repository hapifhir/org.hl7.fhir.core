package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.StringType;

import java.util.Collections;

public class List30_40 {

    public static org.hl7.fhir.r4.model.ListResource convertList(org.hl7.fhir.dstu3.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ListResource tgt = new org.hl7.fhir.r4.model.ListResource();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertListStatus(src.getStatus()));
        if (src.hasMode())
            tgt.setMode(convertListMode(src.getMode()));
        if (src.hasTitleElement())
            tgt.setTitleElement((StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_40.convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_40.convertCodeableConcept(src.getOrderedBy()));
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        if (src.hasEntry()) {
            for (org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        }
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_30_40.convertCodeableConcept(src.getEmptyReason()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource convertList(org.hl7.fhir.r4.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ListResource tgt = new org.hl7.fhir.dstu3.model.ListResource();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertListStatus(src.getStatus()));
        if (src.hasMode())
            tgt.setMode(convertListMode(src.getMode()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_40.convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_40.convertCodeableConcept(src.getOrderedBy()));
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        if (src.hasEntry()) {
            for (org.hl7.fhir.r4.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        }
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_30_40.convertCodeableConcept(src.getEmptyReason()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent convertListEntryComponent(org.hl7.fhir.r4.model.ListResource.ListEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent tgt = new org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(VersionConvertor_30_40.convertCodeableConcept(src.getFlag()));
        if (src.hasDeletedElement())
            tgt.setDeletedElement((BooleanType) VersionConvertor_30_40.convertType(src.getDeletedElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(VersionConvertor_30_40.convertReference(src.getItem()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ListResource.ListEntryComponent convertListEntryComponent(org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ListResource.ListEntryComponent tgt = new org.hl7.fhir.r4.model.ListResource.ListEntryComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(VersionConvertor_30_40.convertCodeableConcept(src.getFlag()));
        if (src.hasDeletedElement())
            tgt.setDeletedElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getDeletedElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(VersionConvertor_30_40.convertReference(src.getItem()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.ListResource.ListMode convertListMode(org.hl7.fhir.dstu3.model.ListResource.ListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case WORKING:
                return org.hl7.fhir.r4.model.ListResource.ListMode.WORKING;
            case SNAPSHOT:
                return org.hl7.fhir.r4.model.ListResource.ListMode.SNAPSHOT;
            case CHANGES:
                return org.hl7.fhir.r4.model.ListResource.ListMode.CHANGES;
            default:
                return org.hl7.fhir.r4.model.ListResource.ListMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.ListResource.ListMode convertListMode(org.hl7.fhir.r4.model.ListResource.ListMode src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.ListResource.ListStatus convertListStatus(org.hl7.fhir.r4.model.ListResource.ListStatus src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.ListResource.ListStatus convertListStatus(org.hl7.fhir.dstu3.model.ListResource.ListStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CURRENT:
                return org.hl7.fhir.r4.model.ListResource.ListStatus.CURRENT;
            case RETIRED:
                return org.hl7.fhir.r4.model.ListResource.ListStatus.RETIRED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.ListResource.ListStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.ListResource.ListStatus.NULL;
        }
    }
}
