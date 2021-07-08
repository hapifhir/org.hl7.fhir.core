package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Type10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Ratio10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Timing10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationOrder10_30 {
  public static org.hl7.fhir.dstu3.model.Dosage convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
    Element10_30.copyElement(src, tgt);
    if (src.hasTextElement()) tgt.setTextElement(String10_30.convertString(src.getTextElement()));
    if (src.hasTiming()) tgt.setTiming(Timing10_30.convertTiming(src.getTiming()));
    if (src.hasAsNeeded()) tgt.setAsNeeded(Type10_30.convertType(src.getAsNeeded()));
    if (src.hasSiteCodeableConcept()) tgt.setSite(CodeableConcept10_30.convertCodeableConcept(src.getSiteCodeableConcept()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept10_30.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept10_30.convertCodeableConcept(src.getMethod()));
    if (src.hasDose()) tgt.setDose(Type10_30.convertType(src.getDose()));
    if (src.hasRate()) tgt.setRate(Type10_30.convertType(src.getRate()));
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio10_30.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent convertMedicationOrderDosageInstructionComponent(org.hl7.fhir.dstu3.model.Dosage src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationOrder.MedicationOrderDosageInstructionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasTextElement()) tgt.setTextElement(String10_30.convertString(src.getTextElement()));
    if (src.hasTiming()) tgt.setTiming(Timing10_30.convertTiming(src.getTiming()));
    if (src.hasAsNeeded()) tgt.setAsNeeded(Type10_30.convertType(src.getAsNeeded()));
    if (src.hasSite()) tgt.setSite(Type10_30.convertType(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept10_30.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept10_30.convertCodeableConcept(src.getMethod()));
    if (src.hasDose()) tgt.setDose(Type10_30.convertType(src.getDose()));
    if (src.hasRate()) tgt.setRate(Type10_30.convertType(src.getRate()));
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio10_30.convertRatio(src.getMaxDosePerPeriod()));
    return tgt;
  }
}
