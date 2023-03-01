package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Attachment30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceAttesterComponent;

public class DocumentReference30_50 {

  public static org.hl7.fhir.r5.model.DocumentReference convertDocumentReference(org.hl7.fhir.dstu3.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference tgt = new org.hl7.fhir.r5.model.DocumentReference();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasClass_())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(src.getClass_()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasCreated())
      tgt.setDate(src.getCreated());
    if (src.hasAuthenticator())
      tgt.addAttester().setMode(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(new org.hl7.fhir.r5.model.Coding("http://hl7.org/fhir/composition-attestation-mode","official", "Official")))
        .setParty(Reference30_50.convertReference(src.getAuthenticator()));
    if (src.hasCustodian())
      tgt.setCustodian(Reference30_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    if (src.hasContext())
      convertDocumentReferenceContextComponent(src.getContext(), tgt);
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor())
      tgt.addAuthor(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentReference convertDocumentReference(org.hl7.fhir.r5.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DocumentReference tgt = new org.hl7.fhir.dstu3.model.DocumentReference();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    //        if (src.hasMasterIdentifier())
    //            tgt.setMasterIdentifier(VersionConvertor_30_50.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasCategory())
      tgt.setClass_(CodeableConcept30_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setCreated(src.getDate());
    for (DocumentReferenceAttesterComponent t : src.getAttester()) {
      if (t.getMode().hasCoding("http://hl7.org/fhir/composition-attestation-mode", "official"))
        tgt.setAuthenticator(Reference30_50.convertReference(t.getParty()));
    }
    if (src.hasCustodian())
      tgt.setCustodian(Reference30_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    convertDocumentReferenceContextComponent(src, tgt.getContext());
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor())
      tgt.addAuthor(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment30_50.convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment30_50.convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.r5.model.DocumentReference src, org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent tgt) throws FHIRException {
    if (src.hasContext())
      tgt.setEncounter(Reference30_50.convertReference(src.getContextFirstRep()));
    for (CodeableReference t : src.getEvent())
      if (t.hasConcept())
      tgt.addEvent(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept30_50.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept30_50.convertCodeableConcept(src.getPracticeSetting()));
//    if (src.hasSourcePatientInfo())
//      tgt.setSourcePatientInfo(Reference30_50.convertReference(src.getSourcePatientInfo()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getRelated())
//      tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextComponent src, org.hl7.fhir.r5.model.DocumentReference tgt) throws FHIRException {
    if (src.hasEncounter())
      tgt.addContext(Reference30_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(new CodeableReference().setConcept(CodeableConcept30_50.convertCodeableConcept(t)));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept30_50.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept30_50.convertCodeableConcept(src.getPracticeSetting()));
//    if (src.hasSourcePatientInfo())
//      tgt.setSourcePatientInfo(Reference30_50.convertReference(src.getSourcePatientInfo()));
//    for (org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent t : src.getRelated())
//      tgt.addRelated(convertDocumentReferenceContextRelatedComponent(t));
  }

  public static org.hl7.fhir.r5.model.Reference convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Reference tgt = Reference30_50.convertReference(src.getRef());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent convertDocumentReferenceContextRelatedComponent(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceContextRelatedComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    tgt.setRef(Reference30_50.convertReference(src));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCode(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference30_50.convertReference(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.dstu3.model.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType2(src.getCode()));
    if (src.hasTarget())
      tgt.setTarget(Reference30_50.convertReference(src.getTarget()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus> convertDocumentReferenceStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Enumerations.DocumentReferenceStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType> convertDocumentRelationshipType2(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getCode("http://hl7.org/fhir/document-relationship-type")) {
    case "replaces":
      tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.REPLACES);
      break;
    case "transforms":
      tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.TRANSFORMS);
      break;
    case "signs":
      tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.SIGNS);
      break;
    case "appends":
      tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.APPENDS);
      break;
    default:
      tgt.setValue(org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType.NULL);
      break;
    }

    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus> convertReferredDocumentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> convertReferredDocumentStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.ReferredDocumentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompositionStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
    case PRELIMINARY:
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.PRELIMINARY);
      break;
    case FINAL:
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.FINAL);
      break;
    case AMENDED:
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.AMENDED);
      break;
    case ENTEREDINERROR:
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.ENTEREDINERROR);
      break;
    default:
      tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.NULL);
      break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertDocumentRelationshipType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DocumentReference.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
    } else {
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

    }
    return tgt;
  }
}
