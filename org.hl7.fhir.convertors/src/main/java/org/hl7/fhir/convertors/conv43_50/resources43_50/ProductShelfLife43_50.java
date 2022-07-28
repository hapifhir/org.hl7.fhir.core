package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.conv43_50.datatypes43_50.BackboneElement43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Quantity43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class ProductShelfLife43_50 {
  public static org.hl7.fhir.r5.model.ProductShelfLife convertProductShelfLife(org.hl7.fhir.r4b.model.ProductShelfLife src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.ProductShelfLife tgt = new org.hl7.fhir.r5.model.ProductShelfLife();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasPeriodDuration()) tgt.setPeriod(Quantity43_50.convertQuantity(src.getPeriodDuration()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialPrecautionsForStorage())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept43_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ProductShelfLife convertProductShelfLife(org.hl7.fhir.r5.model.ProductShelfLife src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ProductShelfLife tgt = new org.hl7.fhir.r4b.model.ProductShelfLife();
    BackboneElement43_50.copyBackboneElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasPeriodDuration()) tgt.setPeriod(Quantity43_50.convertQuantity(src.getPeriodDuration()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialPrecautionsForStorage())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept43_50.convertCodeableConcept(t));
    return tgt;
  }
}
