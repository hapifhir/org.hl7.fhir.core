package org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.BackboneElement43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Ratio43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Timing43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Integer43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Dosage43_50 {
  public static org.hl7.fhir.r5.model.Dosage convertDosage(org.hl7.fhir.r4b.model.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Dosage tgt = new org.hl7.fhir.r5.model.Dosage();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasSequence()) tgt.setSequenceElement(Integer43_50.convertInteger(src.getSequenceElement()));
    if (src.hasText()) tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String43_50.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing43_50.convertTiming(src.getTiming()));
    if (src.hasAsNeededBooleanType())
      tgt.setAsNeededElement(Boolean43_50.convertBoolean(src.getAsNeededBooleanType()));
    if (src.hasAsNeededCodeableConcept()) {
      tgt.addAsNeededFor(CodeableConcept43_50.convertCodeableConcept(src.getAsNeededCodeableConcept()));      
    }
    if (src.hasSite()) tgt.setSite(CodeableConcept43_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept43_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    if (src.hasMaxDosePerPeriod()) tgt.addMaxDosePerPeriod(Ratio43_50.convertRatio(src.getMaxDosePerPeriod()));
    if (src.hasMaxDosePerAdministration())
      tgt.setMaxDosePerAdministration(SimpleQuantity43_50.convertSimpleQuantity(src.getMaxDosePerAdministration()));
    if (src.hasMaxDosePerLifetime())
      tgt.setMaxDosePerLifetime(SimpleQuantity43_50.convertSimpleQuantity(src.getMaxDosePerLifetime()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Dosage convertDosage(org.hl7.fhir.r5.model.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Dosage tgt = new org.hl7.fhir.r4b.model.Dosage();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasSequence()) tgt.setSequenceElement(Integer43_50.convertInteger(src.getSequenceElement()));
    if (src.hasText()) tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String43_50.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing43_50.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(Boolean43_50.convertBoolean(src.getAsNeededElement()));
    if (src.hasAsNeededFor())
      tgt.setAsNeeded(CodeableConcept43_50.convertCodeableConcept(src.getAsNeededForFirstRep()));
    if (src.hasSite()) tgt.setSite(CodeableConcept43_50.convertCodeableConcept(src.getSite()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept43_50.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    if (src.hasMaxDosePerPeriod()) tgt.setMaxDosePerPeriod(Ratio43_50.convertRatio(src.getMaxDosePerPeriodFirstRep()));
    if (src.hasMaxDosePerAdministration())
      tgt.setMaxDosePerAdministration(SimpleQuantity43_50.convertSimpleQuantity(src.getMaxDosePerAdministration()));
    if (src.hasMaxDosePerLifetime())
      tgt.setMaxDosePerLifetime(SimpleQuantity43_50.convertSimpleQuantity(src.getMaxDosePerLifetime()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getRate()));
    return tgt;
  }
}
