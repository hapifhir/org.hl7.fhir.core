package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.BackboneElement43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Population43_50 {
  public static org.hl7.fhir.r5.model.Population convertPopulation(org.hl7.fhir.r4b.model.Population src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Population tgt = new org.hl7.fhir.r5.model.Population();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasAge()) tgt.setAge(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAge()));
    if (src.hasGender()) tgt.setGender(CodeableConcept43_50.convertCodeableConcept(src.getGender()));
    if (src.hasRace()) tgt.setRace(CodeableConcept43_50.convertCodeableConcept(src.getRace()));
    if (src.hasPhysiologicalCondition())
      tgt.setPhysiologicalCondition(CodeableConcept43_50.convertCodeableConcept(src.getPhysiologicalCondition()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Population convertPopulation(org.hl7.fhir.r5.model.Population src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Population tgt = new org.hl7.fhir.r4b.model.Population();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasAge()) tgt.setAge(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAge()));
    if (src.hasGender()) tgt.setGender(CodeableConcept43_50.convertCodeableConcept(src.getGender()));
    if (src.hasRace()) tgt.setRace(CodeableConcept43_50.convertCodeableConcept(src.getRace()));
    if (src.hasPhysiologicalCondition())
      tgt.setPhysiologicalCondition(CodeableConcept43_50.convertCodeableConcept(src.getPhysiologicalCondition()));
    return tgt;
  }
}
