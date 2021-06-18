package org.hl7.fhir.convertors.conv40_50.datatypes40_50;

import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Extension40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement40_50 {
  public static void copyBackboneElement(org.hl7.fhir.r4.model.BackboneElement src, org.hl7.fhir.r5.model.BackboneElement tgt) throws FHIRException {
    Element40_50.copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension40_50.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneElement src, org.hl7.fhir.r4.model.BackboneElement tgt) throws FHIRException {
    Element40_50.copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension40_50.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneType src, org.hl7.fhir.r4.model.BackboneType tgt) throws FHIRException {
    Element40_50.copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension40_50.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.r4.model.BackboneType src, org.hl7.fhir.r5.model.BackboneType tgt) throws FHIRException {
    Element40_50.copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension40_50.convertExtension(e));
    }
  }
}
