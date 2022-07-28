package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.BackboneElement43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Quantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SubstanceAmount43_50 {
  public static org.hl7.fhir.r4b.model.SubstanceAmount convertSubstanceAmount(org.hl7.fhir.r5.model.SubstanceAmount src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.SubstanceAmount tgt = new org.hl7.fhir.r4b.model.SubstanceAmount();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmount(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAmount()));
    if (src.hasAmountType()) tgt.setAmountType(CodeableConcept43_50.convertCodeableConcept(src.getAmountType()));
    if (src.hasAmountText()) tgt.setAmountTextElement(String43_50.convertString(src.getAmountTextElement()));
    if (src.hasReferenceRange())
      tgt.setReferenceRange(convertSubstanceAmountReferenceRangeComponent(src.getReferenceRange()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceAmount convertSubstanceAmount(org.hl7.fhir.r4b.model.SubstanceAmount src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.SubstanceAmount tgt = new org.hl7.fhir.r5.model.SubstanceAmount();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmount(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAmount()));
    if (src.hasAmountType()) tgt.setAmountType(CodeableConcept43_50.convertCodeableConcept(src.getAmountType()));
    if (src.hasAmountText()) tgt.setAmountTextElement(String43_50.convertString(src.getAmountTextElement()));
    if (src.hasReferenceRange())
      tgt.setReferenceRange(convertSubstanceAmountReferenceRangeComponent(src.getReferenceRange()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent convertSubstanceAmountReferenceRangeComponent(org.hl7.fhir.r4b.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent tgt = new org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasLowLimit()) tgt.setLowLimit(Quantity43_50.convertQuantity(src.getLowLimit()));
    if (src.hasHighLimit()) tgt.setHighLimit(Quantity43_50.convertQuantity(src.getHighLimit()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent convertSubstanceAmountReferenceRangeComponent(org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent tgt = new org.hl7.fhir.r4b.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasLowLimit()) tgt.setLowLimit(Quantity43_50.convertQuantity(src.getLowLimit()));
    if (src.hasHighLimit()) tgt.setHighLimit(Quantity43_50.convertQuantity(src.getHighLimit()));
    return tgt;
  }
}
