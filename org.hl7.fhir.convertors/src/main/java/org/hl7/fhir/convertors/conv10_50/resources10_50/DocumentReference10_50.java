package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Attachment10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Period10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.MarkDown10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.dstu2.model.CodeableConcept;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceAttesterComponent;

public class DocumentReference10_50 {

  static public CodeableConcept convertDocStatus(org.hl7.fhir.r5.model.Enumerations.CompositionStatus docStatus) {
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

  static public org.hl7.fhir.r5.model.Enumerations.CompositionStatus convertDocStatus(CodeableConcept cc) {
    if (CodeableConcept10_50.hasConcept(cc, "http://hl7.org/fhir/composition-status", "preliminary"))
      return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.PRELIMINARY;
    if (CodeableConcept10_50.hasConcept(cc, "http://hl7.org/fhir/composition-status", "final"))
      return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.FINAL;
    if (CodeableConcept10_50.hasConcept(cc, "http://hl7.org/fhir/composition-status", "amended"))
      return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.AMENDED;
    if (CodeableConcept10_50.hasConcept(cc, "http://hl7.org/fhir/composition-status", "entered-in-error"))
      return org.hl7.fhir.r5.model.Enumerations.CompositionStatus.ENTEREDINERROR;
    return null;
  }

  public static org.hl7.fhir.dstu2.model.DocumentReference convertDocumentReference(org.hl7.fhir.r5.model.DocumentReference src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentReference tgt = new org.hl7.fhir.dstu2.model.DocumentReference();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    //        if (src.hasMasterIdentifier())
    //            tgt.setMasterIdentifier(VersionConvertor_10_50.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasCategory())
      tgt.setClass_(CodeableConcept10_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasCustodian())
      tgt.setCustodian(Reference10_50.convertReference(src.getCustodian()));
    for (DocumentReferenceAttesterComponent t : src.getAttester()) {
      if (t.getMode().hasCoding("http://hl7.org/fhir/composition-attestation-mode", "official"))
        tgt.setAuthenticator(Reference10_50.convertReference(t.getParty()));
    }
    if (src.hasDate())
      tgt.setCreated(src.getDate());
    if (src.hasStatus())
      tgt.setStatusElement(convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatus(convertDocStatus(src.getDocStatus()));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept10_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    convertDocumentReferenceContextComponent(tgt.getContext(), src);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference convertDocumentReference(org.hl7.fhir.dstu2.model.DocumentReference src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.DocumentReference tgt = new org.hl7.fhir.r5.model.DocumentReference();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasClass_())
      tgt.addCategory(CodeableConcept10_50.convertCodeableConcept(src.getClass_()));
    if (src.hasCustodian())
      tgt.setCustodian(Reference10_50.convertReference(src.getCustodian()));
    if (src.hasAuthenticator())
      tgt.addAttester().setMode(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/composition-attestation-mode","official", "Official")))
         .setParty(Reference10_50.convertReference(src.getAuthenticator()));
    if (src.hasCreated())
      tgt.setDate(src.getCreated());
    if (src.hasStatus())
      tgt.setStatusElement(convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatus(convertDocStatus(src.getDocStatus()));
    for (org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(MarkDown10_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept10_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    convertDocumentReferenceContextComponent(src.getContext(), tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment10_50.convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment10_50.convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.r5.model.DocumentReference src, org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent tgt) throws FHIRException {
    if (src.hasContext())
      tgt.setEncounter(Reference10_50.convertReference(src.getContextFirstRep()));
    for (CodeableReference t : src.getEvent())
      if (t.hasConcept())
        tgt.addEvent(CodeableConcept10_50.convertCodeableConcept(t.getConcept()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept10_50.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept10_50.convertCodeableConcept(src.getPracticeSetting()));
//    if (src.hasSourcePatientInfo())
//      tgt.setSourcePatientInfo(Reference10_50.convertReference(src.getSourcePatientInfo()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getRelated())
//      tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextComponent src, org.hl7.fhir.r5.model.DocumentReference tgt) throws FHIRException {
    if (src.hasEncounter())
      tgt.addContext(Reference10_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(new CodeableReference().setConcept(CodeableConcept10_50.convertCodeableConcept(t)));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept10_50.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept10_50.convertCodeableConcept(src.getPracticeSetting()));
//    if (src.hasSourcePatientInfo())
//      tgt.setSourcePatientInfo(Reference10_50.convertReference(src.getSourcePatientInfo()));
//    for (org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent t : src.getRelated())
//      tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
  }

  public static org.hl7.fhir.r5.model.Reference convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Reference tgt = Reference10_50.convertReference(src.getRef());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceContextRelatedComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
    tgt.setRef(Reference10_50.convertReference(src));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getCode()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_50.convertReference(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.dstu2.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCode(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference10_50.convertReference(src.getTarget()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
    case CURRENT:
      tgt.setValue(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus.CURRENT);
      break;
    case SUPERSEDED:
      tgt.setValue(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus.SUPERSEDED);
      break;
    case ENTEREDINERROR:
      tgt.setValue(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus.ENTEREDINERROR);
      break;
    default:
      tgt.setValue(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus.NULL);
      break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Enumerations.DocumentReferenceStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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
    return tgt;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertDocumentRelationshipType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
    case REPLACES:
      tgt.addCoding().setSystem("http://hl7.org/fhir/document-relationship-type").setCode("replaces");
      break;
    case TRANSFORMS:
      tgt.addCoding().setSystem("http://hl7.org/fhir/document-relationship-type").setCode("transforms");
      break;
    case SIGNS:
      tgt.addCoding().setSystem("http://hl7.org/fhir/document-relationship-type").setCode("signs");
      break;
    case APPENDS:
      tgt.addCoding().setSystem("http://hl7.org/fhir/document-relationship-type").setCode("appends");
      break;
    default:
      break;
    }

    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getCode("http://hl7.org/fhir/document-relationship-type")) {
    case "replaces":
      tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.REPLACES);
      break;
    case "transforms":
      tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.TRANSFORMS);
      break;
    case "signs":
      tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.SIGNS);
      break;
    case "appends":
      tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.APPENDS);
      break;
    default:
      tgt.setValue(org.hl7.fhir.dstu2.model.DocumentReference.DocumentRelationshipType.NULL);
      break;
    }

    return tgt;
  }
}