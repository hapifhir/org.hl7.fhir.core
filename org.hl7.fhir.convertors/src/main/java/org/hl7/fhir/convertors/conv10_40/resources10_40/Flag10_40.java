package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Period10_40;
import org.hl7.fhir.dstu2.model.Enumeration;
import org.hl7.fhir.dstu2.model.Flag;
import org.hl7.fhir.exceptions.FHIRException;

public class Flag10_40 {

  public static org.hl7.fhir.r4.model.Flag convertFlag(org.hl7.fhir.dstu2.model.Flag src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Flag tgt = new org.hl7.fhir.r4.model.Flag();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept10_40.convertCodeableConcept(src.getCategory()));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Flag convertFlag(org.hl7.fhir.r4.model.Flag src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Flag tgt = new org.hl7.fhir.dstu2.model.Flag();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_40.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasStatus())
      tgt.setStatusElement(convertFlagStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_40.convertPeriod(src.getPeriod()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_40.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_40.convertReference(src.getEncounter()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Flag.FlagStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Flag.FlagStatus> tgt = new Enumeration<>(new Flag.FlagStatusEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Flag.FlagStatus.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(Flag.FlagStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Flag.FlagStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Flag.FlagStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Flag.FlagStatus> convertFlagStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Flag.FlagStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Flag.FlagStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Flag.FlagStatusEnumFactory());
      ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Flag.FlagStatus.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Flag.FlagStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.Flag.FlagStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Flag.FlagStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}