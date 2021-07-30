package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Type10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Uri10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class DocumentManifest10_30 {

  public static org.hl7.fhir.dstu2.model.DocumentManifest convertDocumentManifest(org.hl7.fhir.dstu3.model.DocumentManifest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentManifest tgt = new org.hl7.fhir.dstu2.model.DocumentManifest();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.setMasterIdentifier(Identifier10_30.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient())
      tgt.addRecipient(Reference10_30.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference10_30.convertReference(t));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_30.convertDateTime(src.getCreatedElement()));
    if (src.hasSourceElement())
      tgt.setSourceElement(Uri10_30.convertUri(src.getSourceElement()));
    if (src.hasStatus())
      tgt.setStatusElement(DocumentReference10_30.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent t : src.getContent())
      tgt.addContent(convertDocumentManifestContentComponent(t));
    for (org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent t : src.getRelated())
      tgt.addRelated(convertDocumentManifestRelatedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentManifest convertDocumentManifest(org.hl7.fhir.dstu2.model.DocumentManifest src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DocumentManifest tgt = new org.hl7.fhir.dstu3.model.DocumentManifest();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.setMasterIdentifier(Identifier10_30.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getRecipient())
      tgt.addRecipient(Reference10_30.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference10_30.convertReference(t));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_30.convertDateTime(src.getCreatedElement()));
    if (src.hasSourceElement())
      tgt.setSourceElement(Uri10_30.convertUri(src.getSourceElement()));
    if (src.hasStatus())
      tgt.setStatusElement(DocumentReference10_30.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent t : src.getContent())
      tgt.addContent(convertDocumentManifestContentComponent(t));
    for (org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent t : src.getRelated())
      tgt.addRelated(convertDocumentManifestRelatedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent convertDocumentManifestContentComponent(org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent tgt = new org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasP())
      tgt.setP(Type10_30.convertType(src.getP()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent convertDocumentManifestContentComponent(org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestContentComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent tgt = new org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestContentComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasP())
      tgt.setP(Type10_30.convertType(src.getP()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasRef())
      tgt.setRef(Reference10_30.convertReference(src.getRef()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent convertDocumentManifestRelatedComponent(org.hl7.fhir.dstu3.model.DocumentManifest.DocumentManifestRelatedComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent tgt = new org.hl7.fhir.dstu2.model.DocumentManifest.DocumentManifestRelatedComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasRef())
      tgt.setRef(Reference10_30.convertReference(src.getRef()));
    return tgt;
  }
}