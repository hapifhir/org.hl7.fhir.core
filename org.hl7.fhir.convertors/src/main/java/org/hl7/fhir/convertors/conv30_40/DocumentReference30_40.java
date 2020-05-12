package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DocumentReference30_40 {

    public static org.hl7.fhir.r4.model.InstantType convertDateTimeToInstant(org.hl7.fhir.dstu3.model.DateTimeType src) throws FHIRException {
        org.hl7.fhir.r4.model.InstantType tgt = new org.hl7.fhir.r4.model.InstantType(src.getValueAsString());
        VersionConvertor_30_40.copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference convertDocumentReference(org.hl7.fhir.r4.model.DocumentReference src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference tgt = new org.hl7.fhir.dstu3.model.DocumentReference();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasMasterIdentifier())
            tgt.setMasterIdentifier(VersionConvertor_30_40.convertIdentifier(src.getMasterIdentifier()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertDocumentReferenceStatus(src.getStatusElement()));
        if (src.hasDocStatus())
            tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasCategory())
            tgt.setClass_(VersionConvertor_30_40.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasDateElement())
            tgt.setCreatedElement(convertInstantToDateTime(src.getDateElement()));
        if (src.hasAuthenticator())
            tgt.setAuthenticator(VersionConvertor_30_40.convertReference(src.getAuthenticator()));
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_30_40.convertReference(src.getCustodian()));
        for (org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent()) tgt.addContent(convertDocumentReferenceContentComponent(t));
        if (src.hasContext())
            tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DocumentReference convertDocumentReference(org.hl7.fhir.dstu3.model.DocumentReference src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DocumentReference tgt = new org.hl7.fhir.r4.model.DocumentReference();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasMasterIdentifier())
            tgt.setMasterIdentifier(VersionConvertor_30_40.convertIdentifier(src.getMasterIdentifier()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertDocumentReferenceStatus(src.getStatusElement()));
        if (src.hasDocStatus())
            tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasClass_())
            tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(src.getClass_()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasCreated())
            tgt.setDateElement(convertDateTimeToInstant(src.getCreatedElement()));
        if (src.hasAuthenticator())
            tgt.setAuthenticator(VersionConvertor_30_40.convertReference(src.getAuthenticator()));
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_30_40.convertReference(src.getCustodian()));
        for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent()) tgt.addContent(convertDocumentReferenceContentComponent(t));
        if (src.hasContext())
            tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAttachment())
            tgt.setAttachment(VersionConvertor_30_40.convertAttachment(src.getAttachment()));
        if (src.hasFormat())
            tgt.setFormat(VersionConvertor_30_40.convertCoding(src.getFormat()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAttachment())
            tgt.setAttachment(VersionConvertor_30_40.convertAttachment(src.getAttachment()));
        if (src.hasFormat())
            tgt.setFormat(VersionConvertor_30_40.convertCoding(src.getFormat()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getEncounterFirstRep()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getEvent()) tgt.addEvent(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasFacilityType())
            tgt.setFacilityType(VersionConvertor_30_40.convertCodeableConcept(src.getFacilityType()));
        if (src.hasPracticeSetting())
            tgt.setPracticeSetting(VersionConvertor_30_40.convertCodeableConcept(src.getPracticeSetting()));
        if (src.hasSourcePatientInfo())
            tgt.setSourcePatientInfo(VersionConvertor_30_40.convertReference(src.getSourcePatientInfo()));
        for (org.hl7.fhir.r4.model.Reference t : src.getRelated()) tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasEncounter())
            tgt.addEncounter(VersionConvertor_30_40.convertReference(src.getEncounter()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getEvent()) tgt.addEvent(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasFacilityType())
            tgt.setFacilityType(VersionConvertor_30_40.convertCodeableConcept(src.getFacilityType()));
        if (src.hasPracticeSetting())
            tgt.setPracticeSetting(VersionConvertor_30_40.convertCodeableConcept(src.getPracticeSetting()));
        if (src.hasSourcePatientInfo())
            tgt.setSourcePatientInfo(VersionConvertor_30_40.convertReference(src.getSourcePatientInfo()));
        for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent t : src.getRelated()) tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Reference convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Reference tgt = VersionConvertor_30_40.convertReference(src.getRef());
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        tgt.setRef(VersionConvertor_30_40.convertReference(src));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_40.convertDocumentRelationshipType(src.getCodeElement()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_40.convertReference(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(VersionConvertor_30_40.convertDocumentRelationshipType(src.getCodeElement()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_40.convertReference(src.getTarget()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.CURRENT);
                break;
            case SUPERSEDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.SUPERSEDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CURRENT:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.CURRENT);
                break;
            case SUPERSEDED:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.SUPERSEDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Enumerations.DocumentReferenceStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DateTimeType convertInstantToDateTime(org.hl7.fhir.dstu3.model.InstantType src) throws FHIRException {
        org.hl7.fhir.r4.model.DateTimeType tgt = new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString());
        VersionConvertor_30_40.copyElement(src, tgt);
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DateTimeType convertInstantToDateTime(org.hl7.fhir.r4.model.InstantType src) throws FHIRException {
        org.hl7.fhir.dstu3.model.DateTimeType tgt = new org.hl7.fhir.dstu3.model.DateTimeType(src.getValueAsString());
        VersionConvertor_30_40.copyElement(src, tgt);
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus> convertReferredDocumentStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.AMENDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus> convertReferredDocumentStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.AMENDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.NULL);
                break;
        }
        return tgt;
    }
}