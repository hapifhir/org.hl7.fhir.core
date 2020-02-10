package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.InstantType;

import java.util.Collections;

public class DocumentReference30_50 {

    public static org.hl7.fhir.r5.model.DocumentReference convertDocumentReference(org.hl7.fhir.dstu3.model.DocumentReference src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DocumentReference tgt = new org.hl7.fhir.r5.model.DocumentReference();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasMasterIdentifier())
            tgt.setMasterIdentifier(VersionConvertor_30_50.convertIdentifier(src.getMasterIdentifier()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertDocumentReferenceStatus(src.getStatus()));
        if (src.hasDocStatus())
            tgt.setDocStatus(convertReferredDocumentStatus(src.getDocStatus()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasClass_())
            tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(src.getClass_()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasCreatedElement())
            tgt.setDateElement((InstantType) VersionConvertor_30_50.convertType(src.getCreatedElement()));
        if (src.hasAuthenticator())
            tgt.setAuthenticator(VersionConvertor_30_50.convertReference(src.getAuthenticator()));
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_30_50.convertReference(src.getCustodian()));
        if (src.hasRelatesTo()) {
            for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasSecurityLabel()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasContent()) {
            for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent()) tgt.addContent(convertDocumentReferenceContentComponent(t));
        }
        if (src.hasContext())
            tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference convertDocumentReference(org.hl7.fhir.r5.model.DocumentReference src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference tgt = new org.hl7.fhir.dstu3.model.DocumentReference();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasMasterIdentifier())
            tgt.setMasterIdentifier(VersionConvertor_30_50.convertIdentifier(src.getMasterIdentifier()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertDocumentReferenceStatus(src.getStatus()));
        if (src.hasDocStatus())
            tgt.setDocStatus(convertReferredDocumentStatus(src.getDocStatus()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasCategory())
            tgt.setClass_(VersionConvertor_30_50.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasDateElement())
            tgt.setCreatedElement((DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasAuthenticator())
            tgt.setAuthenticator(VersionConvertor_30_50.convertReference(src.getAuthenticator()));
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_30_50.convertReference(src.getCustodian()));
        if (src.hasRelatesTo()) {
            for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasSecurityLabel()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasContent()) {
            for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent()) tgt.addContent(convertDocumentReferenceContentComponent(t));
        }
        if (src.hasContext())
            tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasAttachment())
            tgt.setAttachment(VersionConvertor_30_50.convertAttachment(src.getAttachment()));
        if (src.hasFormat())
            tgt.setFormat(VersionConvertor_30_50.convertCoding(src.getFormat()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasAttachment())
            tgt.setAttachment(VersionConvertor_30_50.convertAttachment(src.getAttachment()));
        if (src.hasFormat())
            tgt.setFormat(VersionConvertor_30_50.convertCoding(src.getFormat()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getEncounterFirstRep()));
        if (src.hasEvent()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getEvent()) tgt.addEvent(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        if (src.hasFacilityType())
            tgt.setFacilityType(VersionConvertor_30_50.convertCodeableConcept(src.getFacilityType()));
        if (src.hasPracticeSetting())
            tgt.setPracticeSetting(VersionConvertor_30_50.convertCodeableConcept(src.getPracticeSetting()));
        if (src.hasSourcePatientInfo())
            tgt.setSourcePatientInfo(VersionConvertor_30_50.convertReference(src.getSourcePatientInfo()));
        if (src.hasRelated()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getRelated()) tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContextComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasEncounter())
            tgt.addEncounter(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasEvent()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getEvent()) tgt.addEvent(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        if (src.hasFacilityType())
            tgt.setFacilityType(VersionConvertor_30_50.convertCodeableConcept(src.getFacilityType()));
        if (src.hasPracticeSetting())
            tgt.setPracticeSetting(VersionConvertor_30_50.convertCodeableConcept(src.getPracticeSetting()));
        if (src.hasSourcePatientInfo())
            tgt.setSourcePatientInfo(VersionConvertor_30_50.convertReference(src.getSourcePatientInfo()));
        if (src.hasRelated()) {
            for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent t : src.getRelated()) tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Reference convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Reference tgt = VersionConvertor_30_50.convertReference(src.getRef());
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        tgt.setRef(VersionConvertor_30_50.convertReference(src));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertDocumentRelationshipType(src.getCode()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_50.convertReference(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertDocumentRelationshipType2(src.getCode()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_50.convertReference(src.getTarget()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus convertDocumentReferenceStatus(org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CURRENT:
                return org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.CURRENT;
            case SUPERSEDED:
                return org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.SUPERSEDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus convertDocumentReferenceStatus(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CURRENT:
                return org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.CURRENT;
            case SUPERSEDED:
                return org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.SUPERSEDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.Enumerations.DocumentReferenceStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType convertDocumentRelationshipType2(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REPLACES:
                return org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.REPLACES;
            case TRANSFORMS:
                return org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.TRANSFORMS;
            case SIGNS:
                return org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.SIGNS;
            case APPENDS:
                return org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.APPENDS;
            default:
                return org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus convertReferredDocumentStatus(org.hl7.fhir.r5.model.Enumerations.CompositionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRELIMINARY:
                return org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.AMENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Enumerations.CompositionStatus convertReferredDocumentStatus(org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRELIMINARY:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.AMENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.NULL;
        }
    }
}
