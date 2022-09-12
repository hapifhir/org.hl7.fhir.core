package org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.BackboneElement40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Ratio40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.SimpleQuantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Timing40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Dosage40_50 {
  public static org.hl7.fhir.r5.model.Dosage convertDosage(org.hl7.fhir.r4.model.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Dosage tgt = new org.hl7.fhir.r5.model.Dosage();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasSequence()) tgt.setSequenceElement(Integer40_50.convertInteger(src.getSequenceElement()));
    if (src.hasText()) tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String40_50.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing40_50.convertTiming(src.getTiming()));
    if (src.hasAsNeededBooleanType())
      tgt.setAsNeededElement(Boolean40_50.convertBoolean(src.getAsNeededBooleanType()));
    if (src.hasAsNeededCodeableConcept()) {
      tgt.addAsNeededFor(CodeableConcept40_50.convertCodeableConcept(src.getAsNeededCodeableConcept()));      
    }
    if (src.hasSite()) tgt.setSite(CodeableConcept40_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept40_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept40_50.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    if (src.hasMaxDosePerPeriod()) tgt.addMaxDosePerPeriod(Ratio40_50.convertRatio(src.getMaxDosePerPeriod()));
    if (src.hasMaxDosePerAdministration())
      tgt.setMaxDosePerAdministration(SimpleQuantity40_50.convertSimpleQuantity(src.getMaxDosePerAdministration()));
    if (src.hasMaxDosePerLifetime())
      tgt.setMaxDosePerLifetime(SimpleQuantity40_50.convertSimpleQuantity(src.getMaxDosePerLifetime()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Dosage convertDosage(org.hl7.fhir.r5.model.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasSequence()) tgt.setSequenceElement(Integer40_50.convertInteger(src.getSequenceElement()));
    if (src.hasText()) tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String40_50.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing40_50.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(Boolean40_50.convertBoolean(src.getAsNeededElement()));
    if (src.hasAsNeededFor())
      tgt.setAsNeeded(CodeableConcept40_50.convertCodeableConcept(src.getAsNeededForFirstRep()));
    if (src.hasSite()) tgt.setSite(CodeableConcept40_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept40_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept40_50.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio40_50.convertRatio(src.getMaxDosePerPeriodFirstRep()));
    if (src.hasMaxDosePerAdministration())
      tgt.setMaxDosePerAdministration(SimpleQuantity40_50.convertSimpleQuantity(src.getMaxDosePerAdministration()));
    if (src.hasMaxDosePerLifetime())
      tgt.setMaxDosePerLifetime(SimpleQuantity40_50.convertSimpleQuantity(src.getMaxDosePerLifetime()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getRate()));
    return tgt;
  }
}
