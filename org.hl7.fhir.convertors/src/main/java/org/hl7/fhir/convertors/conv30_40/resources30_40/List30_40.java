package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40; import org.hl7.fhir.convertors.context.ConversionContext30_40; import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class List30_40 {

    public static org.hl7.fhir.r4.model.ListResource convertList(org.hl7.fhir.dstu3.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ListResource tgt = new org.hl7.fhir.r4.model.ListResource();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertListStatus(src.getStatusElement()));
        if (src.hasMode())
            tgt.setModeElement(convertListMode(src.getModeElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(Reference30_40.convertReference(src.getEncounter()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasSource())
            tgt.setSource(Reference30_40.convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(CodeableConcept30_40.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(CodeableConcept30_40.convertCodeableConcept(src.getEmptyReason()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource convertList(org.hl7.fhir.r4.model.ListResource src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ListResource tgt = new org.hl7.fhir.dstu3.model.ListResource();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertListStatus(src.getStatusElement()));
        if (src.hasMode())
            tgt.setModeElement(convertListMode(src.getModeElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(Reference30_40.convertReference(src.getEncounter()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasSource())
            tgt.setSource(Reference30_40.convertReference(src.getSource()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(CodeableConcept30_40.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
        for (org.hl7.fhir.r4.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntryComponent(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(CodeableConcept30_40.convertCodeableConcept(src.getEmptyReason()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent convertListEntryComponent(org.hl7.fhir.r4.model.ListResource.ListEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent tgt = new org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(CodeableConcept30_40.convertCodeableConcept(src.getFlag()));
        if (src.hasDeleted())
            tgt.setDeletedElement(Boolean30_40.convertBoolean(src.getDeletedElement()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(Reference30_40.convertReference(src.getItem()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ListResource.ListEntryComponent convertListEntryComponent(org.hl7.fhir.dstu3.model.ListResource.ListEntryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ListResource.ListEntryComponent tgt = new org.hl7.fhir.r4.model.ListResource.ListEntryComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasFlag())
            tgt.setFlag(CodeableConcept30_40.convertCodeableConcept(src.getFlag()));
        if (src.hasDeleted())
            tgt.setDeletedElement(Boolean30_40.convertBoolean(src.getDeletedElement()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasItem())
            tgt.setItem(Reference30_40.convertReference(src.getItem()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListMode> convertListMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ListResource.ListModeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case WORKING:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListMode.WORKING);
                break;
            case SNAPSHOT:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListMode.SNAPSHOT);
                break;
            case CHANGES:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListMode.CHANGES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListMode> convertListMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ListResource.ListModeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListStatus> convertListStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.ListResource.ListStatusEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListStatus> convertListStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ListResource.ListStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ListResource.ListStatusEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListStatus.CURRENT);
                break;
            case RETIRED:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListStatus.RETIRED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ListResource.ListStatus.NULL);
                break;
        }
        return tgt;
    }
}