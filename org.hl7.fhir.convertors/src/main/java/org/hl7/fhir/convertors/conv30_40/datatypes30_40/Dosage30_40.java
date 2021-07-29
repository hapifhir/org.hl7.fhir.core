package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Ratio30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.SimpleQuantity30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Timing30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Integer30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Dosage30_40 {
    public static org.hl7.fhir.r4.model.Dosage convertDosage(org.hl7.fhir.dstu3.model.Dosage src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.hasSequence()) tgt.setSequenceElement(Integer30_40.convertInteger(src.getSequenceElement()));
      if (src.hasText()) tgt.setTextElement(String30_40.convertString(src.getTextElement()));
      for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAdditionalInstruction())
        tgt.addAdditionalInstruction(CodeableConcept30_40.convertCodeableConcept(t));
      if (src.hasPatientInstruction())
        tgt.setPatientInstructionElement(String30_40.convertString(src.getPatientInstructionElement()));
      if (src.hasTiming()) tgt.setTiming(Timing30_40.convertTiming(src.getTiming()));
      if (src.hasAsNeeded()) tgt.setAsNeeded(VersionConvertorFactory_30_40.convertType(src.getAsNeeded()));
      if (src.hasSite()) tgt.setSite(CodeableConcept30_40.convertCodeableConcept(src.getSite()));
      if (src.hasRoute()) tgt.setRoute(CodeableConcept30_40.convertCodeableConcept(src.getRoute()));
      if (src.hasMethod()) tgt.setMethod(CodeableConcept30_40.convertCodeableConcept(src.getMethod()));
      if (src.hasDose() || src.hasRate()) {
        org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
        if (src.hasDose()) dr.setDose(VersionConvertorFactory_30_40.convertType(src.getDose()));
        if (src.hasRate()) dr.setRate(VersionConvertorFactory_30_40.convertType(src.getRate()));
      }
      if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio30_40.convertRatio(src.getMaxDosePerPeriod()));
      if (src.hasMaxDosePerAdministration())
        tgt.setMaxDosePerAdministration(SimpleQuantity30_40.convertSimpleQuantity(src.getMaxDosePerAdministration()));
      if (src.hasMaxDosePerLifetime()) tgt.setMaxDosePerLifetime(SimpleQuantity30_40.convertSimpleQuantity(src.getMaxDosePerLifetime()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Dosage convertDosage(org.hl7.fhir.r4.model.Dosage src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.hasSequence()) tgt.setSequenceElement(Integer30_40.convertInteger(src.getSequenceElement()));
      if (src.hasText()) tgt.setTextElement(String30_40.convertString(src.getTextElement()));
      for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAdditionalInstruction())
        tgt.addAdditionalInstruction(CodeableConcept30_40.convertCodeableConcept(t));
      if (src.hasPatientInstruction())
        tgt.setPatientInstructionElement(String30_40.convertString(src.getPatientInstructionElement()));
      if (src.hasTiming()) tgt.setTiming(Timing30_40.convertTiming(src.getTiming()));
      if (src.hasAsNeeded()) tgt.setAsNeeded(VersionConvertorFactory_30_40.convertType(src.getAsNeeded()));
      if (src.hasSite()) tgt.setSite(CodeableConcept30_40.convertCodeableConcept(src.getSite()));
      if (src.hasRoute()) tgt.setRoute(CodeableConcept30_40.convertCodeableConcept(src.getRoute()));
      if (src.hasMethod()) tgt.setMethod(CodeableConcept30_40.convertCodeableConcept(src.getMethod()));
      if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasDose()) {
        if (src.getDoseAndRate().get(0).getDose() instanceof org.hl7.fhir.r4.model.Quantity) {
          tgt.setDose(SimpleQuantity30_40.convertSimpleQuantity((org.hl7.fhir.r4.model.Quantity) src.getDoseAndRate().get(0).getDose()));
        } else {
          tgt.setDose(VersionConvertorFactory_30_40.convertType(src.getDoseAndRate().get(0).getDose()));
        }
      }
      if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio30_40.convertRatio(src.getMaxDosePerPeriod()));
      if (src.hasMaxDosePerAdministration())
        tgt.setMaxDosePerAdministration(SimpleQuantity30_40.convertSimpleQuantity(src.getMaxDosePerAdministration()));
      if (src.hasMaxDosePerLifetime()) tgt.setMaxDosePerLifetime(SimpleQuantity30_40.convertSimpleQuantity(src.getMaxDosePerLifetime()));
      if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate()) {
        if (src.getDoseAndRate().get(0).getRate() instanceof org.hl7.fhir.r4.model.Quantity) {
          tgt.setRate(SimpleQuantity30_40.convertSimpleQuantity((org.hl7.fhir.r4.model.Quantity) src.getDoseAndRate().get(0).getRate()));
        } else {
          tgt.setRate(VersionConvertorFactory_30_40.convertType(src.getDoseAndRate().get(0).getRate()));
        }
      }
      return tgt;
    }
}
