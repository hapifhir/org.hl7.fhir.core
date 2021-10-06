package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Ratio10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Timing10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Dosage;

public class MedicationOrder10_40 {
  public static org.hl7.fhir.r4.model.Dosage convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasTextElement()) tgt.setTextElement(String10_40.convertString(src.getTextElement()));
    if (src.hasTiming()) tgt.setTiming(Timing10_40.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getAsNeeded()));
    if (src.hasSiteCodeableConcept())
      tgt.setSite(CodeableConcept10_40.convertCodeableConcept(src.getSiteCodeableConcept()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept10_40.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept10_40.convertCodeableConcept(src.getMethod()));
    if (src.hasDose() || src.hasRate()) {
      Dosage.DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
      if (src.hasDose())
        dr.setDose(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getDose()));
      if (src.hasRate())
        dr.setRate(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getRate()));
    }
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio10_40.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent convertMedicationOrderDosageInstructionComponent(Dosage src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.hasTextElement()) tgt.setTextElement(String10_40.convertString(src.getTextElement()));
    if (src.hasTiming()) tgt.setTiming(Timing10_40.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getAsNeeded()));
    if (src.hasSite())
      tgt.setSite(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept10_40.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept10_40.convertCodeableConcept(src.getMethod()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose())
      tgt.setDose(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getDoseAndRate().get(0).getDose()));
    if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
      tgt.setRate(ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().convertType(src.getDoseAndRate().get(0).getRate()));
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio10_40.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }
}
