package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.BackboneElement40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Population40_50 {
  public static org.hl7.fhir.r5.model.Population convertPopulation(org.hl7.fhir.r4.model.Population src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Population tgt = new org.hl7.fhir.r5.model.Population();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasAge()) tgt.setAge(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAge()));
    if (src.hasGender()) tgt.setGender(CodeableConcept40_50.convertCodeableConcept(src.getGender()));
    if (src.hasRace()) tgt.setRace(CodeableConcept40_50.convertCodeableConcept(src.getRace()));
    if (src.hasPhysiologicalCondition())
      tgt.setPhysiologicalCondition(CodeableConcept40_50.convertCodeableConcept(src.getPhysiologicalCondition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Population convertPopulation(org.hl7.fhir.r5.model.Population src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Population tgt = new org.hl7.fhir.r4.model.Population();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasAge()) tgt.setAge(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAge()));
    if (src.hasGender()) tgt.setGender(CodeableConcept40_50.convertCodeableConcept(src.getGender()));
    if (src.hasRace()) tgt.setRace(CodeableConcept40_50.convertCodeableConcept(src.getRace()));
    if (src.hasPhysiologicalCondition())
      tgt.setPhysiologicalCondition(CodeableConcept40_50.convertCodeableConcept(src.getPhysiologicalCondition()));
    return tgt;
  }
}
