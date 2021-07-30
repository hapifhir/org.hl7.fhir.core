package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.*;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Instant10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus;
import org.hl7.fhir.exceptions.FHIRException;

public class DocumentReference10_30 {

  static public ReferredDocumentStatus convertDocStatus(CodeableConcept cc) {
    if (CodeableConcept10_30.hasConcept(cc, "http://hl7.org/fhir/composition-status", "preliminary"))
      return ReferredDocumentStatus.PRELIMINARY;
    if (CodeableConcept10_30.hasConcept(cc, "http://hl7.org/fhir/composition-status", "final"))
      return ReferredDocumentStatus.FINAL;
    if (CodeableConcept10_30.hasConcept(cc, "http://hl7.org/fhir/composition-status", "amended"))
      return ReferredDocumentStatus.AMENDED;
    if (CodeableConcept10_30.hasConcept(cc, "http://hl7.org/fhir/composition-status", "entered-in-error"))
      return ReferredDocumentStatus.ENTEREDINERROR;
    return null;
  }

  static public CodeableConcept convertDocStatus(ReferredDocumentStatus docStatus) {
    CodeableConcept cc = new CodeableConcept();
    switch (docStatus) {
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
    if (src.hasMasterIdentifier())
      tgt.setMasterIdentifier(Identifier10_30.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasClass_())
      tgt.setClass_(CodeableConcept10_30.convertCodeableConcept(src.getClass_()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference10_30.convertReference(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference10_30.convertReference(src.getCustodian()));
    if (src.hasAuthenticator())
      tgt.setAuthenticator(Reference10_30.convertReference(src.getAuthenticator()));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_30.convertDateTime(src.getCreatedElement()));
    if (src.hasIndexedElement())
      tgt.setIndexedElement(Instant10_30.convertInstant(src.getIndexedElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatus(convertDocStatus(src.getDocStatus()));
    for (org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    if (src.hasContext())
      tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentReference convertDocumentReference(org.hl7.fhir.dstu3.model.DocumentReference src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentReference tgt = new org.hl7.fhir.dstu2.model.DocumentReference();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.setMasterIdentifier(Identifier10_30.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasClass_())
      tgt.setClass_(CodeableConcept10_30.convertCodeableConcept(src.getClass_()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference10_30.convertReference(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference10_30.convertReference(src.getCustodian()));
    if (src.hasAuthenticator())
      tgt.setAuthenticator(Reference10_30.convertReference(src.getAuthenticator()));
    if (src.hasCreatedElement())
      tgt.setCreatedElement(DateTime10_30.convertDateTime(src.getCreatedElement()));
    if (src.hasIndexedElement())
      tgt.setIndexedElement(Instant10_30.convertInstant(src.getIndexedElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatus(convertDocStatus(src.getDocStatus()));
    for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    if (src.hasContext())
      tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment10_30.convertAttachment(src.getAttachment()));
    if (src.hasFormat())
      tgt.addFormat(Coding10_30.convertCoding(src.getFormat()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment10_30.convertAttachment(src.getAttachment()));
    for (org.hl7.fhir.dstu2.model.Coding t : src.getFormat()) tgt.setFormat(Coding10_30.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_30.convertReference(src.getEncounter()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept10_30.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept10_30.convertCodeableConcept(src.getPracticeSetting()));
    if (src.hasSourcePatientInfo())
      tgt.setSourcePatientInfo(Reference10_30.convertReference(src.getSourcePatientInfo()));
    for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent t : src.getRelated())
      tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_30.convertReference(src.getEncounter()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept10_30.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept10_30.convertCodeableConcept(src.getPracticeSetting()));
    if (src.hasSourcePatientInfo())
      tgt.setSourcePatientInfo(Reference10_30.convertReference(src.getSourcePatientInfo()));
    for (org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent t : src.getRelated())
      tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasRef())
      tgt.setRef(Reference10_30.convertReference(src.getRef()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasRef())
      tgt.setRef(Reference10_30.convertReference(src.getRef()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_30.convertReference(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_30.convertReference(src.getTarget()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipTypeEnumFactory());
    Element10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACES:
        tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.REPLACES);
        break;
      case TRANSFORMS:
        tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.TRANSFORMS);
        break;
      case SIGNS:
        tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.SIGNS);
        break;
      case APPENDS:
        tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.APPENDS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipTypeEnumFactory());
    Element10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACES:
        tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.REPLACES);
        break;
      case TRANSFORMS:
        tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.TRANSFORMS);
        break;
      case SIGNS:
        tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.SIGNS);
        break;
      case APPENDS:
        tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.APPENDS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus.NULL);
    } else {
      switch (src.getValue()) {
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
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.NULL);
    } else {
      switch (src.getValue()) {
        case CURRENT:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.CURRENT);
          break;
        case SUPERSEDED:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.SUPERSEDED);
          break;
        case ENTEREDINERROR:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.ENTEREDINERROR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus.NULL);
          break;
      }
    }
    return tgt;
  }
}