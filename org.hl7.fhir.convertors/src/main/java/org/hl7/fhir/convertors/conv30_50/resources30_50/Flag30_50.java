package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Flag30_50 {

  public static org.hl7.fhir.r5.model.Flag convertFlag(org.hl7.fhir.dstu3.model.Flag src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Flag tgt = new org.hl7.fhir.r5.model.Flag();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference30_50.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Flag convertFlag(org.hl7.fhir.r5.model.Flag src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Flag tgt = new org.hl7.fhir.dstu3.model.Flag();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference30_50.convertReference(src.getAuthor()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Flag.FlagStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Flag.FlagStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Flag.FlagStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Flag.FlagStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Flag.FlagStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Flag.FlagStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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