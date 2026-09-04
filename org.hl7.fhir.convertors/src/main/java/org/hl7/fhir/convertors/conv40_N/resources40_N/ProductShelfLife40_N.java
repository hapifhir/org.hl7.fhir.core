package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.BackboneElement40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Quantity40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class ProductShelfLife40_N {
  public static org.hl7.fhir.model.core.ProductShelfLife convertProductShelfLife(org.hl7.fhir.r4.model.ProductShelfLife src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ProductShelfLife tgt = new org.hl7.fhir.model.core.ProductShelfLife();
    BackboneElement40_N.copyBackboneElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasPeriod()) tgt.setPeriod(Quantity40_N.convertQuantity(src.getPeriod()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialPrecautionsForStorage())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept40_N.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ProductShelfLife convertProductShelfLife(org.hl7.fhir.model.core.ProductShelfLife src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ProductShelfLife tgt = new org.hl7.fhir.r4.model.ProductShelfLife();
    BackboneElement40_N.copyBackboneElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasPeriodDuration()) tgt.setPeriod(Quantity40_N.convertQuantity(src.getPeriodDuration()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSpecialPrecautionsForStorageList())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept40_N.convertCodeableConcept(t));
    return tgt;
  }
}
