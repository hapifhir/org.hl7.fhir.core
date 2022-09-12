package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.conv43_50.datatypes43_50.BackboneElement43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MarketingStatus43_50 extends BackboneElement43_50 {
  public static org.hl7.fhir.r5.model.MarketingStatus convertMarketingStatus(org.hl7.fhir.r4b.model.MarketingStatus src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.MarketingStatus tgt = new org.hl7.fhir.r5.model.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry()) tgt.setCountry(CodeableConcept43_50.convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction()) tgt.setJurisdiction(CodeableConcept43_50.convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus()) tgt.setStatus(CodeableConcept43_50.convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange()) tgt.setDateRange(Period43_50.convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate()) tgt.setRestoreDateElement(DateTime43_50.convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MarketingStatus convertMarketingStatus(org.hl7.fhir.r5.model.MarketingStatus src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.MarketingStatus tgt = new org.hl7.fhir.r4b.model.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry()) tgt.setCountry(CodeableConcept43_50.convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction()) tgt.setJurisdiction(CodeableConcept43_50.convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus()) tgt.setStatus(CodeableConcept43_50.convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange()) tgt.setDateRange(Period43_50.convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate()) tgt.setRestoreDateElement(DateTime43_50.convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }
}
