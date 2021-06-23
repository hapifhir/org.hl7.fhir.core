package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.conv40_50.datatypes40_50.BackboneElement40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MarketingStatus40_50 extends BackboneElement40_50 {
  public static org.hl7.fhir.r5.model.MarketingStatus convertMarketingStatus(org.hl7.fhir.r4.model.MarketingStatus src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.MarketingStatus tgt = new org.hl7.fhir.r5.model.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry()) tgt.setCountry(CodeableConcept40_50.convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction()) tgt.setJurisdiction(CodeableConcept40_50.convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus()) tgt.setStatus(CodeableConcept40_50.convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange()) tgt.setDateRange(Period40_50.convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate()) tgt.setRestoreDateElement(DateTime40_50.convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MarketingStatus convertMarketingStatus(org.hl7.fhir.r5.model.MarketingStatus src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.MarketingStatus tgt = new org.hl7.fhir.r4.model.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry()) tgt.setCountry(CodeableConcept40_50.convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction()) tgt.setJurisdiction(CodeableConcept40_50.convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus()) tgt.setStatus(CodeableConcept40_50.convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange()) tgt.setDateRange(Period40_50.convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate()) tgt.setRestoreDateElement(DateTime40_50.convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }
}
