package org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.BackboneElement43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Ratio43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Timing43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;

public class Dosage43_N {
  public static org.hl7.fhir.model.core.Dosage convertDosage(org.hl7.fhir.r4b.model.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Dosage tgt = new org.hl7.fhir.model.core.Dosage();
    BackboneElement43_N.copyBackboneElement(src, tgt);
    if (src.hasText()) tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getAdditionalInstruction())
      tgt.addAdditionalInstruction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String43_N.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing43_N.convertTiming(src.getTiming()));
    if (src.hasAsNeededBooleanType())
      tgt.setAsNeededElement(Boolean43_N.convertBoolean(src.getAsNeededBooleanType()));
    if (src.hasAsNeededCodeableConcept()) {
      tgt.addAsNeededFor(CodeableConcept43_N.convertCodeableConcept(src.getAsNeededCodeableConcept()));      
    }
    if (src.hasSite()) tgt.setSite(new CodeableReference().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getSite())));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept43_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept43_N.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRate())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Dosage convertDosage(org.hl7.fhir.model.core.Dosage src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Dosage tgt = new org.hl7.fhir.r4b.model.Dosage();
    BackboneElement43_N.copyBackboneElement(src, tgt);
    if (src.hasText()) tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAdditionalInstructionList())
      tgt.addAdditionalInstruction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPatientInstruction())
      tgt.setPatientInstructionElement(String43_N.convertString(src.getPatientInstructionElement()));
    if (src.hasTiming()) tgt.setTiming(Timing43_N.convertTiming(src.getTiming()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(Boolean43_N.convertBoolean(src.getAsNeededElement()));
    if (src.hasAsNeededFor())
      tgt.setAsNeeded(CodeableConcept43_N.convertCodeableConcept(src.getAsNeededForFirstRep()));
    if (src.hasSite()) tgt.setSite(CodeableConcept43_N.convertCodeableConcept(src.getSite().getConcept()));
    if (src.hasRoute()) tgt.setRoute(CodeableConcept43_N.convertCodeableConcept(src.getRoute()));
    if (src.hasMethod()) tgt.setMethod(CodeableConcept43_N.convertCodeableConcept(src.getMethod()));
    for (org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent t : src.getDoseAndRateList())
      tgt.addDoseAndRate(convertDosageDoseAndRateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getRate()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent convertDosageDoseAndRateComponent(org.hl7.fhir.model.core.Dosage.DosageDoseAndRateComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent tgt = new org.hl7.fhir.r4b.model.Dosage.DosageDoseAndRateComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasDose())
      tgt.setDose(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDose()));
    if (src.hasRate())
      tgt.setRate(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getRate()));
    return tgt;
  }
}
