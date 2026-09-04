package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.BackboneElement40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Ratio40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Timing40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;

public class Dosage40_N {
  public static org.hl7.fhir.model.core.Dosage convertDosage(org.hl7.fhir.r4.model.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Dosage tgt = new org.hl7.fhir.model.core.Dosage();
    BackboneElement40_N.copyBackboneElement(src, tgt);
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String40_N.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing40_N.convertTiming(src.getTiming()));
    if (src.hasAsNeededBooleanType())
      tgt.setAsNeededElement(Boolean40_N.convertBoolean(src.getAsNeededBooleanType()));
    if (src.hasAsNeededCodeableConcept()) {
      tgt.addAsNeededFor(CodeableConcept40_N.convertCodeableConcept(src.getAsNeededCodeableConcept()));      
    }
    if (src.hasSite()) tgt.setSite(new CodeableReference().setConcept(CodeableConcept40_N.convertCodeableConcept(src.getSite())));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept40_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Dosage convertDosage(org.hl7.fhir.model.core.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
    BackboneElement40_N.copyBackboneElement(src, tgt);
    if (src.hasText()) tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAdditionalInstructionList())
      tgt.addAdditionalInstruction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String40_N.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing40_N.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(Boolean40_N.convertBoolean(src.getAsNeededElement()));
    if (src.hasAsNeededFor())
      tgt.setAsNeeded(CodeableConcept40_N.convertCodeableConcept(src.getAsNeededForFirstRep()));
    if (src.hasSite()) tgt.setSite(CodeableConcept40_N.convertCodeableConcept(src.getSite().getConcept()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept40_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRateList())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getRate()));
    return tgt;
  }
}
