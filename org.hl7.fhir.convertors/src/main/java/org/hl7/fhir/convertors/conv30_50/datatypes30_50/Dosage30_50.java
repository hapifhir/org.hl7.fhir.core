package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Ratio30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.SimpleQuantity30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Timing30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Integer30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Dosage30_50 {
  public static org.hl7.fhir.r5.model.Dosage convertDosage(org.hl7.fhir.dstu3.model.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Dosage tgt = new org.hl7.fhir.r5.model.Dosage();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasSequence()) tgt.setSequenceElement(Integer30_50.convertInteger(src.getSequenceElement()));
    if (src.hasText()) tgt.setTextElement(String30_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String30_50.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing30_50.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getAsNeeded()));
    if (src.hasSite()) tgt.setSite(CodeableConcept30_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept30_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept30_50.convertCodeableConcept(src.getMethod()));
    if (src.hasDose() || src.hasRate()) {
      org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
      if (src.hasDose())
        dr.setDose(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getDose()));
      if (src.hasRate())
        dr.setRate(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getRate()));
    }
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio30_50.convertRatio(src.getMaxDosePerPeriod()));
    if (src.hasMaxDosePerAdministration())
      tgt.setMaxDosePerAdministration(SimpleQuantity30_50.convertSimpleQuantity(src.getMaxDosePerAdministration()));
    if (src.hasMaxDosePerLifetime())
      tgt.setMaxDosePerLifetime(SimpleQuantity30_50.convertSimpleQuantity(src.getMaxDosePerLifetime()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Dosage convertDosage(org.hl7.fhir.r5.model.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasSequence()) tgt.setSequenceElement(Integer30_50.convertInteger(src.getSequenceElement()));
    if (src.hasText()) tgt.setTextElement(String30_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String30_50.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing30_50.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getAsNeeded()));
    if (src.hasSite()) tgt.setSite(CodeableConcept30_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept30_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept30_50.convertCodeableConcept(src.getMethod()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose())
      tgt.setDose(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getDoseAndRate().get(0).getDose()));
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio30_50.convertRatio(src.getMaxDosePerPeriod()));
    if (src.hasMaxDosePerAdministration())
      tgt.setMaxDosePerAdministration(SimpleQuantity30_50.convertSimpleQuantity(src.getMaxDosePerAdministration()));
    if (src.hasMaxDosePerLifetime())
      tgt.setMaxDosePerLifetime(SimpleQuantity30_50.convertSimpleQuantity(src.getMaxDosePerLifetime()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
      tgt.setRate(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getDoseAndRate().get(0).getRate()));
    return tgt;
  }
}
