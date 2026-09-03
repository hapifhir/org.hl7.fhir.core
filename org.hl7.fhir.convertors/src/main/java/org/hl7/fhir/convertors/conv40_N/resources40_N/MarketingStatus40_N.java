package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.BackboneElement40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class MarketingStatus40_N extends BackboneElement40_N {
  public static org.hl7.fhir.model.core.MarketingStatus convertMarketingStatus(org.hl7.fhir.r4.model.MarketingStatus src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.MarketingStatus tgt = new org.hl7.fhir.model.core.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry()) tgt.setCountry(CodeableConcept40_N.convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction()) tgt.setJurisdiction(CodeableConcept40_N.convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus()) tgt.setStatus(CodeableConcept40_N.convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange()) tgt.setDateRange(Period40_N.convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate()) tgt.setRestoreDateElement(DateTime40_N.convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MarketingStatus convertMarketingStatus(org.hl7.fhir.model.core.MarketingStatus src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.MarketingStatus tgt = new org.hl7.fhir.r4.model.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry()) tgt.setCountry(CodeableConcept40_N.convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction()) tgt.setJurisdiction(CodeableConcept40_N.convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus()) tgt.setStatus(CodeableConcept40_N.convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange()) tgt.setDateRange(Period40_N.convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate()) tgt.setRestoreDateElement(DateTime40_N.convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }
}
