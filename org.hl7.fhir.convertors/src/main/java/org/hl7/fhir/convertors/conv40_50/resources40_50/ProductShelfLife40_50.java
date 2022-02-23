package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.conv40_50.datatypes40_50.BackboneElement40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Quantity40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ProductShelfLife40_50 {
  public static org.hl7.fhir.r5.model.ProductShelfLife convertProductShelfLife(org.hl7.fhir.r4.model.ProductShelfLife src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ProductShelfLife tgt = new org.hl7.fhir.r5.model.ProductShelfLife();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasPeriod()) tgt.setPeriod(Quantity40_50.convertQuantity(src.getPeriod()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialPrecautionsForStorage())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept40_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ProductShelfLife convertProductShelfLife(org.hl7.fhir.r5.model.ProductShelfLife src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ProductShelfLife tgt = new org.hl7.fhir.r4.model.ProductShelfLife();
    BackboneElement40_50.copyBackboneElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasPeriodDuration()) tgt.setPeriod(Quantity40_50.convertQuantity(src.getPeriodDuration()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialPrecautionsForStorage())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept40_50.convertCodeableConcept(t));
    return tgt;
  }
}
