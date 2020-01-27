package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus;
import org.hl7.fhir.exceptions.FHIRException;

public class DocumentReference10_30 {

    static public ReferredDocumentStatus convertDocStatus(CodeableConcept cc) {
        if (VersionConvertor_10_30.hasConcept(cc, "http://hl7.org/fhir/composition-status", "preliminary"))
            return ReferredDocumentStatus.PRELIMINARY;
        if (VersionConvertor_10_30.hasConcept(cc, "http://hl7.org/fhir/composition-status", "final"))
            return ReferredDocumentStatus.FINAL;
        if (VersionConvertor_10_30.hasConcept(cc, "http://hl7.org/fhir/composition-status", "amended"))
            return ReferredDocumentStatus.AMENDED;
        if (VersionConvertor_10_30.hasConcept(cc, "http://hl7.org/fhir/composition-status", "entered-in-error"))
            return ReferredDocumentStatus.ENTEREDINERROR;
        return null;
    }

    static public CodeableConcept convertDocStatus(ReferredDocumentStatus docStatus) {
        CodeableConcept cc = new CodeableConcept();
        switch(docStatus) {
            case AMENDED:
                cc.addCoding().setSystem("http://hl7.org/fhir/composition-status").setCode("amended");
                break;
            case ENTEREDINERROR:
                cc.addCoding().setSystem("http://hl7.org/fhir/composition-status").setCode("entered-in-error");
                break;
            case FINAL:
                cc.addCoding().setSystem("http://hl7.org/fhir/composition-status").setCode("final");
                break;
            case PRELIMINARY:
                cc.addCoding().setSystem("http://hl7.org/fhir/composition-status").setCode("preliminary");
                break;
            default:
                return null;
        }
        return cc;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference convertDocumentReference(org.hl7.fhir.dstu2.model.DocumentReference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference tgt = new org.hl7.fhir.dstu3.model.DocumentReference();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setMasterIdentifier(VersionConvertor_10_30.convertIdentifier(src.getMasterIdentifier()));
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setClass_(VersionConvertor_10_30.convertCodeableConcept(src.getClass_()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_30.convertReference(t));
        tgt.setCustodian(VersionConvertor_10_30.convertReference(src.getCustodian()));
        tgt.setAuthenticator(VersionConvertor_10_30.convertReference(src.getAuthenticator()));
        tgt.setCreated(src.getCreated());
        tgt.setIndexed(src.getIndexed());
        tgt.setStatus(VersionConvertor_10_30.convertDocumentReferenceStatus(src.getStatus()));
        tgt.setDocStatus(convertDocStatus(src.getDocStatus()));
        for (org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent()) tgt.addContent(convertDocumentReferenceContentComponent(t));
        tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentReference convertDocumentReference(org.hl7.fhir.dstu3.model.DocumentReference src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentReference tgt = new org.hl7.fhir.dstu2.model.DocumentReference();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setMasterIdentifier(VersionConvertor_10_30.convertIdentifier(src.getMasterIdentifier()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setClass_(VersionConvertor_10_30.convertCodeableConcept(src.getClass_()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_30.convertReference(t));
        tgt.setCustodian(VersionConvertor_10_30.convertReference(src.getCustodian()));
        tgt.setAuthenticator(VersionConvertor_10_30.convertReference(src.getAuthenticator()));
        tgt.setCreated(src.getCreated());
        tgt.setIndexed(src.getIndexed());
        tgt.setStatus(VersionConvertor_10_30.convertDocumentReferenceStatus(src.getStatus()));
        tgt.setDocStatus(convertDocStatus(src.getDocStatus()));
        for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent()) tgt.addContent(convertDocumentReferenceContentComponent(t));
        tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setAttachment(VersionConvertor_10_30.convertAttachment(src.getAttachment()));
        tgt.addFormat(VersionConvertor_10_30.convertCoding(src.getFormat()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setAttachment(VersionConvertor_10_30.convertAttachment(src.getAttachment()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getFormat()) tgt.setFormat(VersionConvertor_10_30.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getEvent()) tgt.addEvent(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        tgt.setFacilityType(VersionConvertor_10_30.convertCodeableConcept(src.getFacilityType()));
        tgt.setPracticeSetting(VersionConvertor_10_30.convertCodeableConcept(src.getPracticeSetting()));
        tgt.setSourcePatientInfo(VersionConvertor_10_30.convertReference(src.getSourcePatientInfo()));
        for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent t : src.getRelated()) tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getEvent()) tgt.addEvent(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        tgt.setFacilityType(VersionConvertor_10_30.convertCodeableConcept(src.getFacilityType()));
        tgt.setPracticeSetting(VersionConvertor_10_30.convertCodeableConcept(src.getPracticeSetting()));
        tgt.setSourcePatientInfo(VersionConvertor_10_30.convertReference(src.getSourcePatientInfo()));
        for (org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent t : src.getRelated()) tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setRef(VersionConvertor_10_30.convertReference(src.getRef()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        tgt.setRef(VersionConvertor_10_30.convertReference(src.getRef()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setCode(convertDocumentRelationshipType(src.getCode()));
        tgt.setTarget(VersionConvertor_10_30.convertReference(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setCode(convertDocumentRelationshipType(src.getCode()));
        tgt.setTarget(VersionConvertor_10_30.convertReference(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType convertDocumentRelationshipType(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REPLACES:
                return org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.REPLACES;
            case TRANSFORMS:
                return org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.TRANSFORMS;
            case SIGNS:
                return org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.SIGNS;
            case APPENDS:
                return org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.APPENDS;
            default:
                return org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType convertDocumentRelationshipType(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType src) throws FHIRException {
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
}
