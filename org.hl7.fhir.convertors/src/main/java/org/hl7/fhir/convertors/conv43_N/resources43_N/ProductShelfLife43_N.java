package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.conv43_N.datatypes43_N.BackboneElement43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Quantity43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Quantity;

public class ProductShelfLife43_N {
  public static org.hl7.fhir.model.core.ProductShelfLife convertProductShelfLife(org.hl7.fhir.r4b.model.ProductShelfLife src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.ProductShelfLife tgt = new org.hl7.fhir.model.core.ProductShelfLife();
    BackboneElement43_N.copyBackboneElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasPeriod()) tgt.setPeriod(Quantity43_N.convertQuantity((Quantity) src.getPeriod()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialPrecautionsForStorage())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept43_N.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ProductShelfLife convertProductShelfLife(org.hl7.fhir.model.core.ProductShelfLife src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.ProductShelfLife tgt = new org.hl7.fhir.r4b.model.ProductShelfLife();
    BackboneElement43_N.copyBackboneElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasPeriodDuration()) tgt.setPeriod(Quantity43_N.convertQuantity(src.getPeriodDuration()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSpecialPrecautionsForStorageList())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept43_N.convertCodeableConcept(t));
    return tgt;
  }
}
