package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
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
    // R6 has no identifier
    CrossVersionElements40_N.r4ElementsToExtensions(src, "ProductShelfLife", tgt.getExtension(), "identifier");
    // R4 period is a Quantity, and R6 is a Duration (or a string, which is a 5.0 extension in R4)
    String url5 = CrossVersionElements40_N.url("ProductShelfLife", "5.0", "period");
    tgt.getExtension().removeIf(e -> url5.equals(e.getUrl()));
    if (src.hasPeriod()) {
      org.hl7.fhir.model.core.Duration d = new org.hl7.fhir.model.core.Duration();
      Quantity40_N.copyQuantity(src.getPeriod(), d);
      tgt.setPeriod(d);
    }
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "ProductShelfLife", "5.0", "period");
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialPrecautionsForStorage())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept40_N.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ProductShelfLife convertProductShelfLife(org.hl7.fhir.model.core.ProductShelfLife src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.ProductShelfLife tgt = new org.hl7.fhir.r4.model.ProductShelfLife();
    BackboneElement40_N.copyBackboneElement(src, tgt);
    if (src.hasType()) tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    String idUrl = CrossVersionElements40_N.url("ProductShelfLife", "4.0", "identifier");
    tgt.getExtension().removeIf(e -> idUrl.equals(e.getUrl()));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "ProductShelfLife", "identifier");
    if (src.hasPeriodDuration())
      tgt.setPeriod(Quantity40_N.convertQuantity(src.getPeriodDuration()));
    else if (src.hasPeriod())
      CrossVersionElements40_N.elementsToExtensionsForPath(src, "ProductShelfLife", tgt.getExtension(), "5.0", "period");
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSpecialPrecautionsForStorageList())
      tgt.addSpecialPrecautionsForStorage(CodeableConcept40_N.convertCodeableConcept(t));
    return tgt;
  }
}
