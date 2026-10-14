package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Quantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.MeasureReport;

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

public class MeasureReport40_N {

  public static org.hl7.fhir.model.core.MeasureReport convertMeasureReport(org.hl7.fhir.r4.model.MeasureReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport tgt = new org.hl7.fhir.model.core.MeasureReport();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMeasureReportStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setTypeElement(convertMeasureReportType(src.getTypeElement()));
    if (src.hasMeasure())
      tgt.setMeasureElement(Canonical40_N.convertCanonical(src.getMeasureElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasReporter())
      tgt.setReporter(Reference40_N.convertReference(src.getReporter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent t : src.getGroup())
      tgt.addGroup(convertMeasureReportGroupComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEvaluatedResource())
      tgt.addEvaluatedResource(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport convertMeasureReport(org.hl7.fhir.model.core.MeasureReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport tgt = new org.hl7.fhir.r4.model.MeasureReport();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMeasureReportStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setTypeElement(convertMeasureReportType(src.getTypeElement()));
    if (src.hasMeasure())
      tgt.setMeasureElement(Canonical40_N.convertCanonical(src.getMeasureElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasReporter())
      tgt.setReporter(Reference40_N.convertReference(src.getReporter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent t : src.getGroupList())
      tgt.addGroup(convertMeasureReportGroupComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEvaluatedResourceList())
      tgt.addEvaluatedResource(Reference40_N.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MeasureReport.MeasureReportStatus> convertMeasureReportStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MeasureReport.MeasureReportStatus> tgt = new Enumeration<>(new MeasureReport.MeasureReportStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETE:
                  tgt.setValue(MeasureReport.MeasureReportStatus.COMPLETE);
                  break;
              case PENDING:
                  tgt.setValue(MeasureReport.MeasureReportStatus.PENDING);
                  break;
              case ERROR:
                  tgt.setValue(MeasureReport.MeasureReportStatus.ERROR);
                  break;
              default:
                  tgt.setValue(MeasureReport.MeasureReportStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus> convertMeasureReportStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MeasureReport.MeasureReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETE:
                  tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus.COMPLETE);
                  break;
              case PENDING:
                  tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus.PENDING);
                  break;
              case ERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus.ERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MeasureReport.MeasureReportType> convertMeasureReportType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MeasureReport.MeasureReportType> tgt = new Enumeration<>(new MeasureReport.MeasureReportTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INDIVIDUAL:
                  tgt.setValue(MeasureReport.MeasureReportType.INDIVIDUAL);
                  break;
              case SUBJECTLIST:
                  tgt.setValue(MeasureReport.MeasureReportType.SUBJECTLIST);
                  break;
              case SUMMARY:
                  tgt.setValue(MeasureReport.MeasureReportType.SUMMARY);
                  break;
              case DATACOLLECTION:
                  tgt.setValue(MeasureReport.MeasureReportType.DATAEXCHANGE);
                  break;
              default:
                  tgt.setValue(MeasureReport.MeasureReportType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportType> convertMeasureReportType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MeasureReport.MeasureReportType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MeasureReport.MeasureReportTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INDIVIDUAL:
                  tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.INDIVIDUAL);
                  break;
              case SUBJECTLIST:
                  tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.SUBJECTLIST);
                  break;
              case SUMMARY:
                  tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.SUMMARY);
                  break;
              case DATAEXCHANGE:
                  tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.DATACOLLECTION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent convertMeasureReportGroupComponent(org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent tgt = new org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertMeasureReportGroupPopulationComponent(t));
    if (src.hasMeasureScore())
      tgt.setMeasureScore(Quantity40_N.convertQuantity(src.getMeasureScore()));
    for (org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent t : src.getStratifier())
      tgt.addStratifier(convertMeasureReportGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent convertMeasureReportGroupComponent(org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent t : src.getPopulationList())
      tgt.addPopulation(convertMeasureReportGroupPopulationComponent(t));
    if (src.hasMeasureScoreQuantity())
      tgt.setMeasureScore(Quantity40_N.convertQuantity(src.getMeasureScoreQuantity()));
    for (org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent t : src.getStratifierList())
      tgt.addStratifier(convertMeasureReportGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent convertMeasureReportGroupPopulationComponent(org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent tgt = new org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(Integer40_N.convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(Reference40_N.convertReference(src.getSubjectResults()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent convertMeasureReportGroupPopulationComponent(org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(Integer40_N.convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(Reference40_N.convertReference(src.getSubjectResults()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent convertMeasureReportGroupStratifierComponent(org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent tgt = new org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent t : src.getStratum())
      tgt.addStratum(convertStratifierGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent convertMeasureReportGroupStratifierComponent(org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    tgt.addCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent t : src.getStratumList())
      tgt.addStratum(convertStratifierGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent convertStratifierGroupComponent(org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent tgt = new org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(CodeableConcept40_N.convertCodeableConcept(src.getValue()));
    for (org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent t : src.getComponent())
      tgt.addComponent(convertStratifierGroupComponentComponent(t));
    for (org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertStratifierGroupPopulationComponent(t));
    if (src.hasMeasureScore())
      tgt.setMeasureScore(Quantity40_N.convertQuantity(src.getMeasureScore()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent convertStratifierGroupComponent(org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasValueCodeableConcept())
      tgt.setValue(CodeableConcept40_N.convertCodeableConcept(src.getValueCodeableConcept()));
    for (org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent t : src.getComponentList())
      tgt.addComponent(convertStratifierGroupComponentComponent(t));
    for (org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent t : src.getPopulationList())
      tgt.addPopulation(convertStratifierGroupPopulationComponent(t));
    if (src.hasMeasureScoreQuantity())
      tgt.setMeasureScore(Quantity40_N.convertQuantity(src.getMeasureScoreQuantity()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent convertStratifierGroupComponentComponent(org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent tgt = new org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(CodeableConcept40_N.convertCodeableConcept(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent convertStratifierGroupComponentComponent(org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasValueCodeableConcept())
      tgt.setValue(CodeableConcept40_N.convertCodeableConcept(src.getValueCodeableConcept()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent convertStratifierGroupPopulationComponent(org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent tgt = new org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(Integer40_N.convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(Reference40_N.convertReference(src.getSubjectResults()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent convertStratifierGroupPopulationComponent(org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(Integer40_N.convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(Reference40_N.convertReference(src.getSubjectResults()));
    return tgt;
  }
}