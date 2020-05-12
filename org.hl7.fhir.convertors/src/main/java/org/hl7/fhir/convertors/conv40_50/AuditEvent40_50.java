package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;

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
public class AuditEvent40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.AuditEvent convertAuditEvent(org.hl7.fhir.r4.model.AuditEvent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent tgt = new org.hl7.fhir.r5.model.AuditEvent();
        copyDomainResource(src, tgt);
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        for (org.hl7.fhir.r4.model.Coding t : src.getSubtype()) tgt.addSubtype(convertCoding(t));
        if (src.hasAction())
            tgt.setActionElement(convertAuditEventAction(src.getActionElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasRecorded())
            tgt.setRecordedElement(convertInstant(src.getRecordedElement()));
        if (src.hasOutcome())
            tgt.getOutcome().addCoding().setSystem("http://terminology.hl7.org/CodeSystem/audit-event-outcome").setCode(src.getOutcome().toCode());
        if (src.hasOutcomeDesc())
            tgt.getOutcome().setTextElement(convertString(src.getOutcomeDescElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPurposeOfEvent()) tgt.addPurposeOfEvent(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent t : src.getAgent()) tgt.addAgent(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent t : src.getEntity()) tgt.addEntity(convertAuditEventEntityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent convertAuditEvent(org.hl7.fhir.r5.model.AuditEvent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent tgt = new org.hl7.fhir.r4.model.AuditEvent();
        copyDomainResource(src, tgt);
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        for (org.hl7.fhir.r5.model.Coding t : src.getSubtype()) tgt.addSubtype(convertCoding(t));
        if (src.hasAction())
            tgt.setActionElement(convertAuditEventAction(src.getActionElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasRecorded())
            tgt.setRecordedElement(convertInstant(src.getRecordedElement()));
        if (src.hasOutcome() && src.getOutcome().hasCoding("http://terminology.hl7.org/CodeSystem/audit-event-outcome"))
          tgt.getOutcomeElement().setValueAsString(src.getOutcome().getCode("http://terminology.hl7.org/CodeSystem/audit-event-outcome"));
      if (src.getOutcome().hasText())
          tgt.setOutcomeDescElement(VersionConvertor_40_50.convertString(src.getOutcome().getTextElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPurposeOfEvent()) tgt.addPurposeOfEvent(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent t : src.getAgent()) tgt.addAgent(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent t : src.getEntity()) tgt.addEntity(convertAuditEventEntityComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAction> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.AuditEvent.AuditEventActionEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case C:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.C);
                break;
            case R:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.R);
                break;
            case U:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.U);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.D);
                break;
            case E:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.E);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAction> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AuditEvent.AuditEventActionEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case C:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.C);
                break;
            case R:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.R);
                break;
            case U:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.U);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.D);
                break;
            case E:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.E);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.NULL);
                break;
        }
        return tgt;
    }


    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRole()) tgt.addRole(convertCodeableConcept(t));
        if (src.hasWho())
            tgt.setWho(convertReference(src.getWho()));
        if (src.hasAltId())
            tgt.setAltIdElement(convertString(src.getAltIdElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasRequestor())
            tgt.setRequestorElement(convertBoolean(src.getRequestorElement()));
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        for (org.hl7.fhir.r4.model.UriType t : src.getPolicy()) tgt.getPolicy().add(convertUri(t));
        if (src.hasMedia())
            tgt.setMedia(convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPurposeOfUse()) tgt.addPurposeOfUse(convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRole()) tgt.addRole(convertCodeableConcept(t));
        if (src.hasWho())
            tgt.setWho(convertReference(src.getWho()));
        if (src.hasAltId())
            tgt.setAltIdElement(convertString(src.getAltIdElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasRequestor())
            tgt.setRequestorElement(convertBoolean(src.getRequestorElement()));
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        for (org.hl7.fhir.r5.model.UriType t : src.getPolicy()) tgt.getPolicy().add(convertUri(t));
        if (src.hasMedia())
            tgt.setMedia(convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPurposeOfUse()) tgt.addPurposeOfUse(convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent();
        copyElement(src, tgt);
        if (src.hasAddress())
            tgt.setAddressElement(convertString(src.getAddressElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAuditEventAgentNetworkType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent();
        copyElement(src, tgt);
        if (src.hasAddress())
            tgt.setAddressElement(convertString(src.getAddressElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAuditEventAgentNetworkType(src.getTypeElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType> convertAuditEventAgentNetworkType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case _1:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._1);
                break;
            case _2:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._2);
                break;
            case _3:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._3);
                break;
            case _4:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._4);
                break;
            case _5:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._5);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType> convertAuditEventAgentNetworkType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case _1:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._1);
                break;
            case _2:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._2);
                break;
            case _3:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._3);
                break;
            case _4:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._4);
                break;
            case _5:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._5);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent();
        copyElement(src, tgt);
        if (src.hasSite())
            tgt.setSiteElement(convertString(src.getSiteElement()));
        if (src.hasObserver())
            tgt.setObserver(convertReference(src.getObserver()));
        for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent();
        copyElement(src, tgt);
        if (src.hasSite())
            tgt.setSiteElement(convertString(src.getSiteElement()));
        if (src.hasObserver())
            tgt.setObserver(convertReference(src.getObserver()));
        for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent();
        copyElement(src, tgt);
        if (src.hasWhat())
            tgt.setWhat(convertReference(src.getWhat()));
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(convertCoding(t));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        // if (src.hasDescription())
        // tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasQuery())
            tgt.setQueryElement(convertBase64Binary(src.getQueryElement()));
        for (org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent();
        copyElement(src, tgt);
        if (src.hasWhat())
            tgt.setWhat(convertReference(src.getWhat()));
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.r5.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(convertCoding(t));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        // if (src.hasDescription())
        // tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasQuery())
            tgt.setQueryElement(convertBase64Binary(src.getQueryElement()));
        for (org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertString(src.getTypeElement()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertString(src.getTypeElement()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }
}