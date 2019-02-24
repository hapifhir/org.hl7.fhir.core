package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0


public class MeasureReport extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.MeasureReport convertMeasureReport(org.hl7.fhir.r4.model.MeasureReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MeasureReport tgt = new org.hl7.fhir.r5.model.MeasureReport();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertMeasureReportStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertMeasureReportType(src.getType()));
    if (src.hasMeasure())
      tgt.setMeasureElement(convertCanonical(src.getMeasureElement()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasReporter())
      tgt.setReporter(convertReference(src.getReporter()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasImprovementNotation())
      tgt.setImprovementNotation(convertCodeableConcept(src.getImprovementNotation()));
    for (org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent t : src.getGroup())
      tgt.addGroup(convertMeasureReportGroupComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEvaluatedResource())
      tgt.addEvaluatedResource(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport convertMeasureReport(org.hl7.fhir.r5.model.MeasureReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport tgt = new org.hl7.fhir.r4.model.MeasureReport();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertMeasureReportStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertMeasureReportType(src.getType()));
    if (src.hasMeasure())
      tgt.setMeasureElement(convertCanonical(src.getMeasureElement()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasReporter())
      tgt.setReporter(convertReference(src.getReporter()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasImprovementNotation())
      tgt.setImprovementNotation(convertCodeableConcept(src.getImprovementNotation()));
    for (org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent t : src.getGroup())
      tgt.addGroup(convertMeasureReportGroupComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEvaluatedResource())
      tgt.addEvaluatedResource(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus convertMeasureReportStatus(org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case COMPLETE: return org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus.COMPLETE;
    case PENDING: return org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus.PENDING;
    case ERROR: return org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus.ERROR;
    default: return org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus convertMeasureReportStatus(org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case COMPLETE: return org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus.COMPLETE;
    case PENDING: return org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus.PENDING;
    case ERROR: return org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus.ERROR;
    default: return org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MeasureReport.MeasureReportType convertMeasureReportType(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INDIVIDUAL: return org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.INDIVIDUAL;
    case SUBJECTLIST: return org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.SUBJECTLIST;
    case SUMMARY: return org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.SUMMARY;
    case DATACOLLECTION: return org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.DATACOLLECTION;
    default: return org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportType convertMeasureReportType(org.hl7.fhir.r5.model.MeasureReport.MeasureReportType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INDIVIDUAL: return org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.INDIVIDUAL;
    case SUBJECTLIST: return org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.SUBJECTLIST;
    case SUMMARY: return org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.SUMMARY;
    case DATACOLLECTION: return org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.DATACOLLECTION;
    default: return org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent convertMeasureReportGroupComponent(org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent tgt = new org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertMeasureReportGroupPopulationComponent(t));
    if (src.hasMeasureScore())
      tgt.setMeasureScore(convertQuantity(src.getMeasureScore()));
    for (org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent t : src.getStratifier())
      tgt.addStratifier(convertMeasureReportGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent convertMeasureReportGroupComponent(org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertMeasureReportGroupPopulationComponent(t));
    if (src.hasMeasureScore())
      tgt.setMeasureScore(convertQuantity(src.getMeasureScore()));
    for (org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupStratifierComponent t : src.getStratifier())
      tgt.addStratifier(convertMeasureReportGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupPopulationComponent convertMeasureReportGroupPopulationComponent(org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupPopulationComponent tgt = new org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupPopulationComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(convertReference(src.getSubjectResults()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent convertMeasureReportGroupPopulationComponent(org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(convertReference(src.getSubjectResults()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupStratifierComponent convertMeasureReportGroupStratifierComponent(org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupStratifierComponent tgt = new org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupStratifierComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent t : src.getStratum())
      tgt.addStratum(convertStratifierGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent convertMeasureReportGroupStratifierComponent(org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponent t : src.getStratum())
      tgt.addStratum(convertStratifierGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponent convertStratifierGroupComponent(org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponent tgt = new org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponent();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(convertCodeableConcept(src.getValue()));
    for (org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent t : src.getComponent())
      tgt.addComponent(convertStratifierGroupComponentComponent(t));
    for (org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertStratifierGroupPopulationComponent(t));
    if (src.hasMeasureScore())
      tgt.setMeasureScore(convertQuantity(src.getMeasureScore()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent convertStratifierGroupComponent(org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent();
    copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(convertCodeableConcept(src.getValue()));
    for (org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponentComponent t : src.getComponent())
      tgt.addComponent(convertStratifierGroupComponentComponent(t));
    for (org.hl7.fhir.r5.model.MeasureReport.StratifierGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertStratifierGroupPopulationComponent(t));
    if (src.hasMeasureScore())
      tgt.setMeasureScore(convertQuantity(src.getMeasureScore()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponentComponent convertStratifierGroupComponentComponent(org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponentComponent tgt = new org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponentComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(convertCodeableConcept(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent convertStratifierGroupComponentComponent(org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(convertCodeableConcept(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MeasureReport.StratifierGroupPopulationComponent convertStratifierGroupPopulationComponent(org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MeasureReport.StratifierGroupPopulationComponent tgt = new org.hl7.fhir.r5.model.MeasureReport.StratifierGroupPopulationComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(convertReference(src.getSubjectResults()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent convertStratifierGroupPopulationComponent(org.hl7.fhir.r5.model.MeasureReport.StratifierGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(convertReference(src.getSubjectResults()));
    return tgt;
  }


}
