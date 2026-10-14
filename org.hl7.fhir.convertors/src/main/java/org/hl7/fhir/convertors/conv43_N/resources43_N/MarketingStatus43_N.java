package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.conv43_N.datatypes43_N.BackboneElement43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class MarketingStatus43_N extends BackboneElement43_N {
  public static org.hl7.fhir.model.core.MarketingStatus convertMarketingStatus(org.hl7.fhir.r4b.model.MarketingStatus src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.MarketingStatus tgt = new org.hl7.fhir.model.core.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry()) tgt.setCountry(CodeableConcept43_N.convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction()) tgt.setJurisdiction(CodeableConcept43_N.convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus()) tgt.setStatus(CodeableConcept43_N.convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange()) tgt.setDateRange(Period43_N.convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate()) tgt.setRestoreDateElement(DateTime43_N.convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MarketingStatus convertMarketingStatus(org.hl7.fhir.model.core.MarketingStatus src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.MarketingStatus tgt = new org.hl7.fhir.r4b.model.MarketingStatus();
    copyBackboneElement(src, tgt);
    if (src.hasCountry()) tgt.setCountry(CodeableConcept43_N.convertCodeableConcept(src.getCountry()));
    if (src.hasJurisdiction()) tgt.setJurisdiction(CodeableConcept43_N.convertCodeableConcept(src.getJurisdiction()));
    if (src.hasStatus()) tgt.setStatus(CodeableConcept43_N.convertCodeableConcept(src.getStatus()));
    if (src.hasDateRange()) tgt.setDateRange(Period43_N.convertPeriod(src.getDateRange()));
    if (src.hasRestoreDate()) tgt.setRestoreDateElement(DateTime43_N.convertDateTime(src.getRestoreDateElement()));
    return tgt;
  }
}
