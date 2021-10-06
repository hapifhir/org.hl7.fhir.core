package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Period10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Flag10_50 {

  public static org.hl7.fhir.r5.model.Flag convertFlag(org.hl7.fhir.dstu2.model.Flag src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Flag tgt = new org.hl7.fhir.r5.model.Flag();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept10_50.convertCodeableConcept(src.getCategory()));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_50.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Flag convertFlag(org.hl7.fhir.r5.model.Flag src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Flag tgt = new org.hl7.fhir.dstu2.model.Flag();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_50.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Flag.FlagStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Flag.FlagStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Flag.FlagStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Flag.FlagStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Flag.FlagStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Flag.FlagStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Flag.FlagStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Flag.FlagStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Flag.FlagStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Flag.FlagStatus.NULL);
        break;
    }
    return tgt;
  }
}