package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Quantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
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

public class MeasureReport43_N {

  public static org.hl7.fhir.model.core.MeasureReport convertMeasureReport(org.hl7.fhir.r4b.model.MeasureReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport tgt = new org.hl7.fhir.model.core.MeasureReport();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMeasureReportStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setTypeElement(convertMeasureReportType(src.getTypeElement()));
    if (src.hasMeasure())
      tgt.setMeasureElement(Canonical43_N.convertCanonical(src.getMeasureElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasReporter())
      tgt.setReporter(Reference43_N.convertReference(src.getReporter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupComponent t : src.getGroup())
      tgt.addGroup(convertMeasureReportGroupComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEvaluatedResource())
      tgt.addEvaluatedResource(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MeasureReport convertMeasureReport(org.hl7.fhir.model.core.MeasureReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MeasureReport tgt = new org.hl7.fhir.r4b.model.MeasureReport();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertMeasureReportStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setTypeElement(convertMeasureReportType(src.getTypeElement()));
    if (src.hasMeasure())
      tgt.setMeasureElement(Canonical43_N.convertCanonical(src.getMeasureElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasReporter())
      tgt.setReporter(Reference43_N.convertReference(src.getReporter()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent t : src.getGroupList())
      tgt.addGroup(convertMeasureReportGroupComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEvaluatedResourceList())
      tgt.addEvaluatedResource(Reference43_N.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MeasureReport.MeasureReportStatus> convertMeasureReportStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MeasureReport.MeasureReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MeasureReport.MeasureReportStatus> tgt = new Enumeration<>(new MeasureReport.MeasureReportStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MeasureReport.MeasureReportStatus> convertMeasureReportStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MeasureReport.MeasureReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MeasureReport.MeasureReportStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MeasureReport.MeasureReportStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETE:
                  tgt.setValue(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportStatus.COMPLETE);
                  break;
              case PENDING:
                  tgt.setValue(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportStatus.PENDING);
                  break;
              case ERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportStatus.ERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MeasureReport.MeasureReportType> convertMeasureReportType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MeasureReport.MeasureReportType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<MeasureReport.MeasureReportType> tgt = new Enumeration<>(new MeasureReport.MeasureReportTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MeasureReport.MeasureReportType> convertMeasureReportType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.MeasureReport.MeasureReportType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.MeasureReport.MeasureReportType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.MeasureReport.MeasureReportTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INDIVIDUAL:
                  tgt.setValue(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportType.INDIVIDUAL);
                  break;
              case SUBJECTLIST:
                  tgt.setValue(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportType.SUBJECTLIST);
                  break;
              case SUMMARY:
                  tgt.setValue(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportType.SUMMARY);
                  break;
              case DATAEXCHANGE:
                  tgt.setValue(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportType.DATACOLLECTION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent convertMeasureReportGroupComponent(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent tgt = new org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertMeasureReportGroupPopulationComponent(t));
    if (src.hasMeasureScore())
      tgt.setMeasureScore(Quantity43_N.convertQuantity(src.getMeasureScore()));
    for (org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupStratifierComponent t : src.getStratifier())
      tgt.addStratifier(convertMeasureReportGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupComponent convertMeasureReportGroupComponent(org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupComponent tgt = new org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent t : src.getPopulationList())
      tgt.addPopulation(convertMeasureReportGroupPopulationComponent(t));
    if (src.hasMeasureScoreQuantity())
      tgt.setMeasureScore(Quantity43_N.convertQuantity(src.getMeasureScoreQuantity()));
    for (org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent t : src.getStratifierList())
      tgt.addStratifier(convertMeasureReportGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent convertMeasureReportGroupPopulationComponent(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent tgt = new org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(Integer43_N.convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(Reference43_N.convertReference(src.getSubjectResults()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupPopulationComponent convertMeasureReportGroupPopulationComponent(org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupPopulationComponent tgt = new org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupPopulationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(Integer43_N.convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(Reference43_N.convertReference(src.getSubjectResults()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent convertMeasureReportGroupStratifierComponent(org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent tgt = new org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponent t : src.getStratum())
      tgt.addStratum(convertStratifierGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupStratifierComponent convertMeasureReportGroupStratifierComponent(org.hl7.fhir.model.core.MeasureReport.MeasureReportGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupStratifierComponent tgt = new org.hl7.fhir.r4b.model.MeasureReport.MeasureReportGroupStratifierComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    tgt.addCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent t : src.getStratumList())
      tgt.addStratum(convertStratifierGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent convertStratifierGroupComponent(org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent tgt = new org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(CodeableConcept43_N.convertCodeableConcept(src.getValue()));
    for (org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponentComponent t : src.getComponent())
      tgt.addComponent(convertStratifierGroupComponentComponent(t));
    for (org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertStratifierGroupPopulationComponent(t));
    if (src.hasMeasureScore())
      tgt.setMeasureScore(Quantity43_N.convertQuantity(src.getMeasureScore()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponent convertStratifierGroupComponent(org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponent tgt = new org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasValueCodeableConcept())
      tgt.setValue(CodeableConcept43_N.convertCodeableConcept(src.getValueCodeableConcept()));
    for (org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent t : src.getComponentList())
      tgt.addComponent(convertStratifierGroupComponentComponent(t));
    for (org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent t : src.getPopulationList())
      tgt.addPopulation(convertStratifierGroupPopulationComponent(t));
    if (src.hasMeasureScoreQuantity())
      tgt.setMeasureScore(Quantity43_N.convertQuantity(src.getMeasureScoreQuantity()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent convertStratifierGroupComponentComponent(org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent tgt = new org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(CodeableConcept43_N.convertCodeableConcept(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponentComponent convertStratifierGroupComponentComponent(org.hl7.fhir.model.core.MeasureReport.StratifierGroupComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponentComponent tgt = new org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupComponentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasValueCodeableConcept())
      tgt.setValue(CodeableConcept43_N.convertCodeableConcept(src.getValueCodeableConcept()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent convertStratifierGroupPopulationComponent(org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent tgt = new org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(Integer43_N.convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(Reference43_N.convertReference(src.getSubjectResults()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupPopulationComponent convertStratifierGroupPopulationComponent(org.hl7.fhir.model.core.MeasureReport.StratifierGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupPopulationComponent tgt = new org.hl7.fhir.r4b.model.MeasureReport.StratifierGroupPopulationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasCount())
      tgt.setCountElement(Integer43_N.convertInteger(src.getCountElement()));
    if (src.hasSubjectResults())
      tgt.setSubjectResults(Reference43_N.convertReference(src.getSubjectResults()));
    return tgt;
  }
}