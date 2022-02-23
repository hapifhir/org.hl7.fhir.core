package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.BackboneElement40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Quantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SubstanceAmount40_50 {
  public static org.hl7.fhir.r4.model.SubstanceAmount convertSubstanceAmount(org.hl7.fhir.r5.model.SubstanceAmount src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.SubstanceAmount tgt = new org.hl7.fhir.r4.model.SubstanceAmount();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmount(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAmount()));
    if (src.hasAmountType()) tgt.setAmountType(CodeableConcept40_50.convertCodeableConcept(src.getAmountType()));
    if (src.hasAmountText()) tgt.setAmountTextElement(String40_50.convertString(src.getAmountTextElement()));
    if (src.hasReferenceRange())
      tgt.setReferenceRange(convertSubstanceAmountReferenceRangeComponent(src.getReferenceRange()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceAmount convertSubstanceAmount(org.hl7.fhir.r4.model.SubstanceAmount src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.SubstanceAmount tgt = new org.hl7.fhir.r5.model.SubstanceAmount();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasAmount())
      tgt.setAmount(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAmount()));
    if (src.hasAmountType()) tgt.setAmountType(CodeableConcept40_50.convertCodeableConcept(src.getAmountType()));
    if (src.hasAmountText()) tgt.setAmountTextElement(String40_50.convertString(src.getAmountTextElement()));
    if (src.hasReferenceRange())
      tgt.setReferenceRange(convertSubstanceAmountReferenceRangeComponent(src.getReferenceRange()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent convertSubstanceAmountReferenceRangeComponent(org.hl7.fhir.r4.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent tgt = new org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasLowLimit()) tgt.setLowLimit(Quantity40_50.convertQuantity(src.getLowLimit()));
    if (src.hasHighLimit()) tgt.setHighLimit(Quantity40_50.convertQuantity(src.getHighLimit()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent convertSubstanceAmountReferenceRangeComponent(org.hl7.fhir.r5.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent tgt = new org.hl7.fhir.r4.model.SubstanceAmount.SubstanceAmountReferenceRangeComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasLowLimit()) tgt.setLowLimit(Quantity40_50.convertQuantity(src.getLowLimit()));
    if (src.hasHighLimit()) tgt.setHighLimit(Quantity40_50.convertQuantity(src.getHighLimit()));
    return tgt;
  }
}
