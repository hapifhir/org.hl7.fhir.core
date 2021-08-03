package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Extension10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext10_40;

public class List10_40 {

  public static org.hl7.fhir.r4.model.ListResource convertList(org.hl7.fhir.dstu2.model.List_ src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.ListResource tgt = new org.hl7.fhir.r4.model.ListResource();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_40.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasSource())
      tgt.setSource(Reference10_40.convertReference(src.getSource()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
    if (src.hasStatus())
      tgt.setStatusElement(convertListStatus(src.getStatusElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_40.convertDateTime(src.getDateElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept10_40.convertCodeableConcept(src.getOrderedBy()));
    if (src.hasMode())
      tgt.setModeElement(convertListMode(src.getModeElement()));
    if (src.hasNote())
      tgt.addNote(new org.hl7.fhir.r4.model.Annotation().setText(src.getNote()));
    for (org.hl7.fhir.dstu2.model.List_.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntry(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.List_ convertList(org.hl7.fhir.r4.model.ListResource src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.List_ tgt = new org.hl7.fhir.dstu2.model.List_();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_40.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasSource())
      tgt.setSource(Reference10_40.convertReference(src.getSource()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
    if (src.hasStatus())
      tgt.setStatusElement(convertListStatus(src.getStatusElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_40.convertDateTime(src.getDateElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept10_40.convertCodeableConcept(src.getOrderedBy()));
    if (src.hasMode())
      tgt.setModeElement(convertListMode(src.getModeElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
    for (org.hl7.fhir.r4.model.ListResource.ListEntryComponent t : src.getEntry()) tgt.addEntry(convertListEntry(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ListResource.ListEntryComponent convertListEntry(org.hl7.fhir.dstu2.model.List_.ListEntryComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.ListResource.ListEntryComponent tgt = new org.hl7.fhir.r4.model.ListResource.ListEntryComponent();
    copyBackboneElement(src, tgt);
    if (src.hasFlag())
      tgt.setFlag(CodeableConcept10_40.convertCodeableConcept(src.getFlag()));
    if (src.hasDeletedElement())
      tgt.setDeletedElement(Boolean10_40.convertBoolean(src.getDeletedElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_40.convertDateTime(src.getDateElement()));
    if (src.hasItem())
      tgt.setItem(Reference10_40.convertReference(src.getItem()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.List_.ListEntryComponent convertListEntry(org.hl7.fhir.r4.model.ListResource.ListEntryComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.List_.ListEntryComponent tgt = new org.hl7.fhir.dstu2.model.List_.ListEntryComponent();
    copyBackboneElement(src, tgt);
    if (src.hasFlag())
      tgt.setFlag(CodeableConcept10_40.convertCodeableConcept(src.getFlag()));
    if (src.hasDeletedElement())
      tgt.setDeletedElement(Boolean10_40.convertBoolean(src.getDeletedElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_40.convertDateTime(src.getDateElement()));
    if (src.hasItem())
      tgt.setItem(Reference10_40.convertReference(src.getItem()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListMode> convertListMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.List_.ListModeEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case WORKING:
        tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListMode.WORKING);
        break;
      case SNAPSHOT:
        tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListMode.SNAPSHOT);
        break;
      case CHANGES:
        tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListMode.CHANGES);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListMode> convertListMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ListResource.ListModeEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListStatus> convertListStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ListResource.ListStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListStatus> convertListStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ListResource.ListStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.List_.ListStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.List_.ListStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case CURRENT:
        tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListStatus.CURRENT);
        break;
      case RETIRED:
        tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListStatus.RETIRED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.List_.ListStatus.NULL);
        break;
    }
    return tgt;
  }

  public static void copyBackboneElement(org.hl7.fhir.r4.model.BackboneElement src, org.hl7.fhir.dstu2.model.BackboneElement tgt) throws FHIRException {
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension10_40.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.dstu2.model.BackboneElement src, org.hl7.fhir.r4.model.BackboneElement tgt) throws FHIRException {
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension10_40.convertExtension(e));
    }
  }
}