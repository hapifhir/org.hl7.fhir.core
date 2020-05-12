package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class MeasureReport40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.MeasureReport convertMeasureReport(org.hl7.fhir.r4.model.MeasureReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MeasureReport tgt = new org.hl7.fhir.r5.model.MeasureReport();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMeasureReportStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setTypeElement(convertMeasureReportType(src.getTypeElement()));
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
        for (org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent t : src.getGroup()) tgt.addGroup(convertMeasureReportGroupComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getEvaluatedResource()) tgt.addEvaluatedResource(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MeasureReport convertMeasureReport(org.hl7.fhir.r5.model.MeasureReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MeasureReport tgt = new org.hl7.fhir.r4.model.MeasureReport();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMeasureReportStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setTypeElement(convertMeasureReportType(src.getTypeElement()));
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
        for (org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent t : src.getGroup()) tgt.addGroup(convertMeasureReportGroupComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getEvaluatedResource()) tgt.addEvaluatedResource(convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus> convertMeasureReportStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case COMPLETE:
                tgt.setValue(org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus.COMPLETE);
                break;
            case PENDING:
                tgt.setValue(org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus.PENDING);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus.ERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus> convertMeasureReportStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MeasureReport.MeasureReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MeasureReport.MeasureReportStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MeasureReport.MeasureReportType> convertMeasureReportType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MeasureReport.MeasureReportType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MeasureReport.MeasureReportTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INDIVIDUAL:
                tgt.setValue(org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.INDIVIDUAL);
                break;
            case SUBJECTLIST:
                tgt.setValue(org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.SUBJECTLIST);
                break;
            case SUMMARY:
                tgt.setValue(org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.SUMMARY);
                break;
            case DATACOLLECTION:
                tgt.setValue(org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.DATACOLLECTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MeasureReport.MeasureReportType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportType> convertMeasureReportType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MeasureReport.MeasureReportType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MeasureReport.MeasureReportType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MeasureReport.MeasureReportTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INDIVIDUAL:
                tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.INDIVIDUAL);
                break;
            case SUBJECTLIST:
                tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.SUBJECTLIST);
                break;
            case SUMMARY:
                tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.SUMMARY);
                break;
            case DATACOLLECTION:
                tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.DATACOLLECTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MeasureReport.MeasureReportType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent convertMeasureReportGroupComponent(org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent tgt = new org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupPopulationComponent t : src.getPopulation()) tgt.addPopulation(convertMeasureReportGroupPopulationComponent(t));
        if (src.hasMeasureScore())
            tgt.setMeasureScore(convertQuantity(src.getMeasureScore()));
        for (org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent t : src.getStratifier()) tgt.addStratifier(convertMeasureReportGroupStratifierComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent convertMeasureReportGroupComponent(org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupPopulationComponent t : src.getPopulation()) tgt.addPopulation(convertMeasureReportGroupPopulationComponent(t));
        if (src.hasMeasureScore())
            tgt.setMeasureScore(convertQuantity(src.getMeasureScore()));
        for (org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupStratifierComponent t : src.getStratifier()) tgt.addStratifier(convertMeasureReportGroupStratifierComponent(t));
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
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent t : src.getStratum()) tgt.addStratum(convertStratifierGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent convertMeasureReportGroupStratifierComponent(org.hl7.fhir.r5.model.MeasureReport.MeasureReportGroupStratifierComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent tgt = new org.hl7.fhir.r4.model.MeasureReport.MeasureReportGroupStratifierComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponent t : src.getStratum()) tgt.addStratum(convertStratifierGroupComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponent convertStratifierGroupComponent(org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponent tgt = new org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponent();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(convertCodeableConcept(src.getValue()));
        for (org.hl7.fhir.r4.model.MeasureReport.StratifierGroupComponentComponent t : src.getComponent()) tgt.addComponent(convertStratifierGroupComponentComponent(t));
        for (org.hl7.fhir.r4.model.MeasureReport.StratifierGroupPopulationComponent t : src.getPopulation()) tgt.addPopulation(convertStratifierGroupPopulationComponent(t));
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
        for (org.hl7.fhir.r5.model.MeasureReport.StratifierGroupComponentComponent t : src.getComponent()) tgt.addComponent(convertStratifierGroupComponentComponent(t));
        for (org.hl7.fhir.r5.model.MeasureReport.StratifierGroupPopulationComponent t : src.getPopulation()) tgt.addPopulation(convertStratifierGroupPopulationComponent(t));
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