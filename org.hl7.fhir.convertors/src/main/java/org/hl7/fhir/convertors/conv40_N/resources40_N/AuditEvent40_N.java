package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Base64Binary40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.AuditEvent;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.Enumeration;

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

public class AuditEvent40_N {

  public static org.hl7.fhir.model.core.AuditEvent convertAuditEvent(org.hl7.fhir.r4.model.AuditEvent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AuditEvent tgt = new org.hl7.fhir.model.core.AuditEvent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasType())
      tgt.getType().addCoding(Coding40_N.convertCoding(src.getType()));
    for (org.hl7.fhir.r4.model.Coding t : src.getSubtype()) tgt.setType(new CodeableConcept().addCoding(Coding40_N.convertCoding(t)));
    if (src.hasAction())
      tgt.setActionElement(convertAuditEventAction(src.getActionElement()));
    if (src.hasPeriod())
      tgt.setOccurred(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant40_N.convertInstant(src.getRecordedElement()));
    if (src.hasOutcome())
      tgt.getOutcome().getCode().setSystem("http://terminology.hl7.org/CodeSystem/audit-event-outcome").setCode(src.getOutcome().toCode());
    if (src.hasOutcomeDesc())
      tgt.getOutcome().getDetailFirstRep().setTextElement(String40_N.convertString(src.getOutcomeDescElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPurposeOfEvent())
      tgt.addAuthorization(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent t : src.getAgent())
      tgt.addAgent(convertAuditEventAgentComponent(t));
    if (src.hasSource())
      tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
    for (org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent t : src.getEntity())
      tgt.addEntity(convertAuditEventEntityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AuditEvent convertAuditEvent(org.hl7.fhir.model.core.AuditEvent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AuditEvent tgt = new org.hl7.fhir.r4.model.AuditEvent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.getType().hasCoding()) {
      tgt.setType(Coding40_N.convertCoding(src.getType().getCodingFirstRep()));
    }
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSubtypeList()) tgt.addSubtype(Coding40_N.convertCoding(t.getCodingFirstRep()));
    if (src.hasAction())
      tgt.setActionElement(convertAuditEventAction(src.getActionElement()));
    if (src.hasOccurredPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getOccurredPeriod()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant40_N.convertInstant(src.getRecordedElement()));
    if (src.hasOutcome() && "http://terminology.hl7.org/CodeSystem/audit-event-outcome".equals(src.getOutcome().getCode().getSystem()))
      tgt.getOutcomeElement().setValueAsString(src.getOutcome().getCode().getCode());
    if (src.getOutcome().getDetailFirstRep().hasText())
      tgt.setOutcomeDescElement(String40_N.convertString(src.getOutcome().getDetailFirstRep().getTextElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAuthorizationList())
      tgt.addPurposeOfEvent(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.AuditEvent.AuditEventAgentComponent t : src.getAgentList())
      tgt.addAgent(convertAuditEventAgentComponent(t));
    if (src.hasSource())
      tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
    for (org.hl7.fhir.model.core.AuditEvent.AuditEventEntityComponent t : src.getEntityList())
      tgt.addEntity(convertAuditEventEntityComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAction> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<AuditEvent.AuditEventAction> tgt = new Enumeration<>(new AuditEvent.AuditEventActionEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case C:
                  tgt.setValue(AuditEvent.AuditEventAction.C);
                  break;
              case R:
                  tgt.setValue(AuditEvent.AuditEventAction.R);
                  break;
              case U:
                  tgt.setValue(AuditEvent.AuditEventAction.U);
                  break;
              case D:
                  tgt.setValue(AuditEvent.AuditEventAction.D);
                  break;
              case E:
                  tgt.setValue(AuditEvent.AuditEventAction.E);
                  break;
              default:
                  tgt.setValue(AuditEvent.AuditEventAction.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AuditEvent.AuditEventAction> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAction> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AuditEvent.AuditEventActionEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
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
      }
      return tgt;
  }


  public static org.hl7.fhir.model.core.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.model.core.AuditEvent.AuditEventAgentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRole())
      tgt.addRole(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasWho())
      tgt.setWho(Reference40_N.convertReference(src.getWho()));
//    if (src.hasAltId())
//      tgt.setAltIdElement(String40_N.convertString(src.getAltIdElement()));
//    if (src.hasName())
//      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasRequestor())
      tgt.setRequestorElement(Boolean40_N.convertBoolean(src.getRequestorElement()));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.UriType t : src.getPolicy()) tgt.getPolicyList().add(Uri40_N.convertUri(t));
//    if (src.hasMedia())
//      tgt.setMedia(Coding40_N.convertCoding(src.getMedia()));
//    if (src.hasNetwork())
//      tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPurposeOfUse())
      tgt.addAuthorization(CodeableConcept40_N.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.model.core.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRoleList())
      tgt.addRole(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasWho())
      tgt.setWho(Reference40_N.convertReference(src.getWho()));
//    if (src.hasAltId())
//      tgt.setAltIdElement(String40_N.convertString(src.getAltIdElement()));
//    if (src.hasName())
//      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasRequestor())
      tgt.setRequestorElement(Boolean40_N.convertBoolean(src.getRequestorElement()));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.model.core.UriType t : src.getPolicyList()) tgt.getPolicy().add(Uri40_N.convertUri(t));
//    if (src.hasMedia())
//      tgt.setMedia(Coding40_N.convertCoding(src.getMedia()));
//    if (src.hasNetwork())
//      tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAuthorizationList())
      tgt.addPurposeOfUse(CodeableConcept40_N.convertCodeableConcept(t));
    return tgt;
  }

//  public static org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasAddress())
//      tgt.setAddressElement(String40_N.convertString(src.getAddressElement()));
//    if (src.hasType())
//      tgt.setTypeElement(convertAuditEventAgentNetworkType(src.getTypeElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasAddress())
//      tgt.setAddressElement(String40_N.convertString(src.getAddressElement()));
//    if (src.hasType())
//      tgt.setTypeElement(convertAuditEventAgentNetworkType(src.getTypeElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkType> convertAuditEventAgentNetworkType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkType> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkTypeEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case _1:
//        tgt.setValue(org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkType._1);
//        break;
//      case _2:
//        tgt.setValue(org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkType._2);
//        break;
//      case _3:
//        tgt.setValue(org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkType._3);
//        break;
//      case _4:
//        tgt.setValue(org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkType._4);
//        break;
//      case _5:
//        tgt.setValue(org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkType._5);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkType.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType> convertAuditEventAgentNetworkType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AuditEvent.AuditEventAgentNetworkType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkTypeEnumFactory());
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case _1:
//        tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._1);
//        break;
//      case _2:
//        tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._2);
//        break;
//      case _3:
//        tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._3);
//        break;
//      case _4:
//        tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._4);
//        break;
//      case _5:
//        tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._5);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType.NULL);
//        break;
//    }
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.model.core.AuditEvent.AuditEventSourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasSite())
//      tgt.setSiteElement(String40_N.convertString(src.getSiteElement()));
    if (src.hasObserver())
      tgt.setObserver(Reference40_N.convertReference(src.getObserver()));
    for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType().addCoding(Coding40_N.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.model.core.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasSite())
//      tgt.setSiteElement(String40_N.convertString(src.getSiteElement()));
    if (src.hasObserver())
      tgt.setObserver(Reference40_N.convertReference(src.getObserver()));
    for (CodeableConcept t : src.getTypeList()) tgt.addType(Coding40_N.convertCoding(t.getCodingFirstRep()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.model.core.AuditEvent.AuditEventEntityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasWhat())
      tgt.setWhat(Reference40_N.convertReference(src.getWhat()));
//    if (src.hasType())
//      tgt.setType(Coding40_N.convertCoding(src.getType()));
    if (src.hasRole())
      tgt.getRole().addCoding(Coding40_N.convertCoding(src.getRole()));
//    if (src.hasLifecycle())
//      tgt.setLifecycle(Coding40_N.convertCoding(src.getLifecycle()));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel().addCoding(Coding40_N.convertCoding(t));
//    if (src.hasName())
//      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    // if (src.hasDescription())
    // tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasQuery())
      tgt.setQueryElement(Base64Binary40_N.convertBase64Binary(src.getQueryElement()));
    for (org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail())
      tgt.addDetail(convertAuditEventEntityDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.model.core.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasWhat())
      tgt.setWhat(Reference40_N.convertReference(src.getWhat()));
//    if (src.hasType())
//      tgt.setType(Coding40_N.convertCoding(src.getType()));
    if (src.hasRole())
      tgt.setRole(Coding40_N.convertCoding(src.getRole().getCodingFirstRep()));
//    if (src.hasLifecycle())
//      tgt.setLifecycle(Coding40_N.convertCoding(src.getLifecycle()));
    for (CodeableConcept t : src.getSecurityLabelList()) tgt.addSecurityLabel(Coding40_N.convertCoding(t.getCodingFirstRep()));
//    if (src.hasName())
//      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    // if (src.hasDescription())
    // tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasQuery())
      tgt.setQueryElement(Base64Binary40_N.convertBase64Binary(src.getQueryElement()));
    for (org.hl7.fhir.model.core.AuditEvent.AuditEventEntityDetailComponent t : src.getDetailList())
      tgt.addDetail(convertAuditEventEntityDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.model.core.AuditEvent.AuditEventEntityDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.getType().setTextElement(String40_N.convertString(src.getTypeElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.model.core.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.getType().hasTextElement())
      tgt.setTypeElement(String40_N.convertString(src.getType().getTextElement()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }
}
