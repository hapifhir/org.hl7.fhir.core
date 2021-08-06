package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Ratio10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Timing10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Dosage;

public class MedicationOrder10_50 {
  public static org.hl7.fhir.r5.model.Dosage convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Dosage tgt = new org.hl7.fhir.r5.model.Dosage();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasTextElement()) tgt.setTextElement(String10_50.convertString(src.getTextElement()));
    if (src.hasTiming()) tgt.setTiming(Timing10_50.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getAsNeeded()));
    if (src.hasSiteCodeableConcept())
      tgt.setSite(CodeableConcept10_50.convertCodeableConcept(src.getSiteCodeableConcept()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept10_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept10_50.convertCodeableConcept(src.getMethod()));
    if (src.hasDose() || src.hasRate()) {
      Dosage.DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
      if (src.hasDose())
        dr.setDose(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getDose()));
      if (src.hasRate())
        dr.setRate(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getRate()));
    }
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio10_50.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent convertMedicationOrderDosageInstructionComponent(Dosage src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasTextElement()) tgt.setTextElement(String10_50.convertString(src.getTextElement()));
    if (src.hasTiming()) tgt.setTiming(Timing10_50.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getAsNeeded()));
    if (src.hasSite())
      tgt.setSite(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept10_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept10_50.convertCodeableConcept(src.getMethod()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose())
      tgt.setDose(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getDoseAndRate().get(0).getDose()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
      tgt.setRate(ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().convertType(src.getDoseAndRate().get(0).getRate()));
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio10_50.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }
}
