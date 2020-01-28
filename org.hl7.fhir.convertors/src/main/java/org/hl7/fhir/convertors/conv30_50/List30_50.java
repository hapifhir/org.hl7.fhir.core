package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class List30_50 {

    public static org.hl7.fhir.r5.model.ListResource convertList(org.hl7.fhir.dstu3.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ListResource tgt = new org.hl7.fhir.r5.model.ListResource();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertListStatus(src.getStatus()));
        if (src.hasMode())
            tgt.setMode(convertListMode(src.getMode()));
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_50.convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_50.convertCodeableConcept(src.getOrderedBy()));
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        if (src.hasEntry()) {
            for (org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        }
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_30_50.convertCodeableConcept(src.getEmptyReason()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource convertList(org.hl7.fhir.r5.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ListResource tgt = new org.hl7.fhir.dstu3.model.ListResource();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertListStatus(src.getStatus()));
        if (src.hasMode())
            tgt.setMode(convertListMode(src.getMode()));
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_50.convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_50.convertCodeableConcept(src.getOrderedBy()));
        if (src.hasNote()) {
            for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        if (src.hasEntry()) {
            for (org.hl7.fhir.r5.model.ListResource.ListResourceEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        }
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
            tgt.setDeleted(src.getDeleted());
        if (src.hasDate())
            tgt.setDate(src.getDate());
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
            tgt.setDeleted(src.getDeleted());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasItem())
            tgt.setItem(VersionConvertor_30_50.convertReference(src.getItem()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumerations.ListMode convertListMode(org.hl7.fhir.dstu3.model.ListResource.ListMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case WORKING:
                return org.hl7.fhir.r5.model.Enumerations.ListMode.WORKING;
            case SNAPSHOT:
                return org.hl7.fhir.r5.model.Enumerations.ListMode.SNAPSHOT;
            case CHANGES:
                return org.hl7.fhir.r5.model.Enumerations.ListMode.CHANGES;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ListMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.ListResource.ListMode convertListMode(org.hl7.fhir.r5.model.Enumerations.ListMode src) throws FHIRException {
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

    static public org.hl7.fhir.r5.model.ListResource.ListStatus convertListStatus(org.hl7.fhir.dstu3.model.ListResource.ListStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CURRENT:
                return org.hl7.fhir.r5.model.ListResource.ListStatus.CURRENT;
            case RETIRED:
                return org.hl7.fhir.r5.model.ListResource.ListStatus.RETIRED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.ListResource.ListStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.ListResource.ListStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.ListResource.ListStatus convertListStatus(org.hl7.fhir.r5.model.ListResource.ListStatus src) throws FHIRException {
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
}
