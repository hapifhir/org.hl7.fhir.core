package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Period10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Flag10_30 {

  public static org.hl7.fhir.dstu3.model.Flag convertFlag(org.hl7.fhir.dstu2.model.Flag src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Flag tgt = new org.hl7.fhir.dstu3.model.Flag();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_30.convertCodeableConcept(src.getCategory()));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_30.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_30.convertReference(src.getAuthor()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Flag convertFlag(org.hl7.fhir.dstu3.model.Flag src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Flag tgt = new org.hl7.fhir.dstu2.model.Flag();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_30.convertCodeableConcept(src.getCategory()));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_30.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_30.convertReference(src.getAuthor()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Flag.FlagStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Flag.FlagStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Flag.FlagStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Flag.FlagStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Flag.FlagStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Flag.FlagStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Flag.FlagStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Flag.FlagStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Flag.FlagStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Flag.FlagStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Flag.FlagStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Flag.FlagStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.Flag.FlagStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Flag.FlagStatus.NULL);
        break;
    }
    return tgt;
  }
}