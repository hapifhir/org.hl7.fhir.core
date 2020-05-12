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
public class ResearchSubject40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ResearchSubject convertResearchSubject(org.hl7.fhir.r4.model.ResearchSubject src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ResearchSubject tgt = new org.hl7.fhir.r5.model.ResearchSubject();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertResearchSubjectStatus(src.getStatusElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasStudy())
            tgt.setStudy(convertReference(src.getStudy()));
        if (src.hasIndividual())
            tgt.setIndividual(convertReference(src.getIndividual()));
        if (src.hasAssignedArm())
            tgt.setAssignedArmElement(convertString(src.getAssignedArmElement()));
        if (src.hasActualArm())
            tgt.setActualArmElement(convertString(src.getActualArmElement()));
        if (src.hasConsent())
            tgt.setConsent(convertReference(src.getConsent()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ResearchSubject convertResearchSubject(org.hl7.fhir.r5.model.ResearchSubject src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ResearchSubject tgt = new org.hl7.fhir.r4.model.ResearchSubject();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertResearchSubjectStatus(src.getStatusElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasStudy())
            tgt.setStudy(convertReference(src.getStudy()));
        if (src.hasIndividual())
            tgt.setIndividual(convertReference(src.getIndividual()));
        if (src.hasAssignedArm())
            tgt.setAssignedArmElement(convertString(src.getAssignedArmElement()));
        if (src.hasActualArm())
            tgt.setActualArmElement(convertString(src.getActualArmElement()));
        if (src.hasConsent())
            tgt.setConsent(convertReference(src.getConsent()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus> convertResearchSubjectStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CANDIDATE:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.CANDIDATE);
                break;
            case ELIGIBLE:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.ELIGIBLE);
                break;
            case FOLLOWUP:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.FOLLOWUP);
                break;
            case INELIGIBLE:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.INELIGIBLE);
                break;
            case NOTREGISTERED:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.NOTREGISTERED);
                break;
            case OFFSTUDY:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.OFFSTUDY);
                break;
            case ONSTUDY:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.ONSTUDY);
                break;
            case ONSTUDYINTERVENTION:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.ONSTUDYINTERVENTION);
                break;
            case ONSTUDYOBSERVATION:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.ONSTUDYOBSERVATION);
                break;
            case PENDINGONSTUDY:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.PENDINGONSTUDY);
                break;
            case POTENTIALCANDIDATE:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.POTENTIALCANDIDATE);
                break;
            case SCREENING:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.SCREENING);
                break;
            case WITHDRAWN:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.WITHDRAWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus> convertResearchSubjectStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ResearchSubject.ResearchSubjectStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CANDIDATE:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.CANDIDATE);
                break;
            case ELIGIBLE:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.ELIGIBLE);
                break;
            case FOLLOWUP:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.FOLLOWUP);
                break;
            case INELIGIBLE:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.INELIGIBLE);
                break;
            case NOTREGISTERED:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.NOTREGISTERED);
                break;
            case OFFSTUDY:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.OFFSTUDY);
                break;
            case ONSTUDY:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.ONSTUDY);
                break;
            case ONSTUDYINTERVENTION:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.ONSTUDYINTERVENTION);
                break;
            case ONSTUDYOBSERVATION:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.ONSTUDYOBSERVATION);
                break;
            case PENDINGONSTUDY:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.PENDINGONSTUDY);
                break;
            case POTENTIALCANDIDATE:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.POTENTIALCANDIDATE);
                break;
            case SCREENING:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.SCREENING);
                break;
            case WITHDRAWN:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.WITHDRAWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchSubject.ResearchSubjectStatus.NULL);
                break;
        }
        return tgt;
    }
}