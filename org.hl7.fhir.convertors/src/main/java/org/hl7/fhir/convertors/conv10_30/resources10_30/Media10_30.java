package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Attachment10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.PositiveInt10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.UnsignedInt10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Media10_30 {

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Media.DigitalMediaType> convertDigitalMediaType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Media.DigitalMediaType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Media.DigitalMediaType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Media.DigitalMediaTypeEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case PHOTO:
        tgt.setValue(org.hl7.fhir.dstu2.model.Media.DigitalMediaType.PHOTO);
        break;
      case VIDEO:
        tgt.setValue(org.hl7.fhir.dstu2.model.Media.DigitalMediaType.VIDEO);
        break;
      case AUDIO:
        tgt.setValue(org.hl7.fhir.dstu2.model.Media.DigitalMediaType.AUDIO);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Media.DigitalMediaType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Media.DigitalMediaType> convertDigitalMediaType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Media.DigitalMediaType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Media.DigitalMediaType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Media.DigitalMediaTypeEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case PHOTO:
        tgt.setValue(org.hl7.fhir.dstu3.model.Media.DigitalMediaType.PHOTO);
        break;
      case VIDEO:
        tgt.setValue(org.hl7.fhir.dstu3.model.Media.DigitalMediaType.VIDEO);
        break;
      case AUDIO:
        tgt.setValue(org.hl7.fhir.dstu3.model.Media.DigitalMediaType.AUDIO);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Media.DigitalMediaType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Media convertMedia(org.hl7.fhir.dstu3.model.Media src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Media tgt = new org.hl7.fhir.dstu2.model.Media();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasType())
      tgt.setTypeElement(convertDigitalMediaType(src.getTypeElement()));
    if (src.hasSubtype())
      tgt.setSubtype(CodeableConcept10_30.convertCodeableConcept(src.getSubtype()));
    if (src.hasView())
      tgt.setView(CodeableConcept10_30.convertCodeableConcept(src.getView()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasOperator())
      tgt.setOperator(Reference10_30.convertReference(src.getOperator()));
    tgt.setDeviceName(src.getDevice().getDisplay());
    if (src.hasHeightElement())
      tgt.setHeightElement(PositiveInt10_30.convertPositiveInt(src.getHeightElement()));
    if (src.hasWidthElement())
      tgt.setWidthElement(PositiveInt10_30.convertPositiveInt(src.getWidthElement()));
    if (src.hasFramesElement())
      tgt.setFramesElement(PositiveInt10_30.convertPositiveInt(src.getFramesElement()));
    if (src.hasDurationElement())
      tgt.setDurationElement(UnsignedInt10_30.convertUnsignedInt(src.getDurationElement()));
    if (src.hasContent())
      tgt.setContent(Attachment10_30.convertAttachment(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Media convertMedia(org.hl7.fhir.dstu2.model.Media src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Media tgt = new org.hl7.fhir.dstu3.model.Media();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasType())
      tgt.setTypeElement(convertDigitalMediaType(src.getTypeElement()));
    if (src.hasSubtype())
      tgt.setSubtype(CodeableConcept10_30.convertCodeableConcept(src.getSubtype()));
    if (src.hasView())
      tgt.setView(CodeableConcept10_30.convertCodeableConcept(src.getView()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasOperator())
      tgt.setOperator(Reference10_30.convertReference(src.getOperator()));
    tgt.getDevice().setDisplay(src.getDeviceName());
    if (src.hasHeightElement())
      tgt.setHeightElement(PositiveInt10_30.convertPositiveInt(src.getHeightElement()));
    if (src.hasWidthElement())
      tgt.setWidthElement(PositiveInt10_30.convertPositiveInt(src.getWidthElement()));
    if (src.hasFramesElement())
      tgt.setFramesElement(PositiveInt10_30.convertPositiveInt(src.getFramesElement()));
    if (src.hasDurationElement())
      tgt.setDurationElement(UnsignedInt10_30.convertUnsignedInt(src.getDurationElement()));
    if (src.hasContent())
      tgt.setContent(Attachment10_30.convertAttachment(src.getContent()));
    return tgt;
  }
}