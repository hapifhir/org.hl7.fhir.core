package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class DocumentManifest10_30 {

    public static org.hl7.fhir.dstu2.model.DocumentManifest convertDocumentManifest(org.hl7.fhir.dstu3.model.DocumentManifest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentManifest tgt = new org.hl7.fhir.dstu2.model.DocumentManifest();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasMasterIdentifier())
            tgt.setMasterIdentifier(VersionConvertor_10_30.convertIdentifier(src.getMasterIdentifier()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_30.convertReference(t));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_30.convertReference(t));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(VersionConvertor_10_30.convertDateTime(src.getCreatedElement()));
        if (src.hasSourceElement())
            tgt.setSourceElement(VersionConvertor_10_30.convertUri(src.getSourceElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertDocumentReferenceStatus(src.getStatusElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent t : src.getContent()) tgt.addContent(convertDocumentManifestContentComponent(t));
        for (org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent t : src.getRelated()) tgt.addRelated(convertDocumentManifestRelatedComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentManifest convertDocumentManifest(org.hl7.fhir.dstu2.model.DocumentManifest src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DocumentManifest tgt = new org.hl7.fhir.dstu3.model.DocumentManifest();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasMasterIdentifier())
            tgt.setMasterIdentifier(VersionConvertor_10_30.convertIdentifier(src.getMasterIdentifier()));
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient()) tgt.addRecipient(VersionConvertor_10_30.convertReference(t));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_30.convertReference(t));
        if (src.hasCreatedElement())
            tgt.setCreatedElement(VersionConvertor_10_30.convertDateTime(src.getCreatedElement()));
        if (src.hasSourceElement())
            tgt.setSourceElement(VersionConvertor_10_30.convertUri(src.getSourceElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertDocumentReferenceStatus(src.getStatusElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent t : src.getContent()) tgt.addContent(convertDocumentManifestContentComponent(t));
        for (org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent t : src.getRelated()) tgt.addRelated(convertDocumentManifestRelatedComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent convertDocumentManifestContentComponent(org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent tgt = new org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasP())
            tgt.setP(VersionConvertor_10_30.convertType(src.getP()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent convertDocumentManifestContentComponent(org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent tgt = new org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasP())
            tgt.setP(VersionConvertor_10_30.convertType(src.getP()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasRef())
            tgt.setRef(VersionConvertor_10_30.convertReference(src.getRef()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasRef())
            tgt.setRef(VersionConvertor_10_30.convertReference(src.getRef()));
        return tgt;
    }
}