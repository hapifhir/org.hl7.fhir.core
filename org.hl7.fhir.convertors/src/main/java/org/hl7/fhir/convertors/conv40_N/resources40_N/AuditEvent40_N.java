package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
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

  public static final String OUTCOME_SYSTEM = "http://terminology.hl7.org/CodeSystem/audit-event-outcome";
  // R6 outcome when it's more than R4's code and description
  public static final String OUTCOME_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.outcome";
  // R6 occurred[x] when it's not a period
  public static final String OCCURRED_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.occurred";
  // R6 agent.network[x] when it's a reference, and R4 agent.network.type when it isn't a URI
  public static final String NETWORK_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.agent.network";
  public static final String NETWORK_TYPE_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-AuditEvent.agent.network.type";
  // R6 source.site when it's more than a name
  public static final String SITE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.source.site";

  /**
   * true if R4 outcome and outcomeDesc can carry all of R6 outcome
   */
  private static boolean isR4Outcome(org.hl7.fhir.model.core.AuditEvent.AuditEventOutcomeComponent src) {
    org.hl7.fhir.model.core.Coding c = src.getCode();
    if (src.hasId() || src.hasExtension() || src.hasModifierExtension() || src.getDetailList().size() > 1)
      return false;
    if (src.hasCode() && (!OUTCOME_SYSTEM.equals(c.getSystem()) || c.hasDisplay() || c.hasVersion() || c.hasUserSelected() || c.hasId() || c.hasExtension()))
      return false;
    if (src.hasDetail()) {
      org.hl7.fhir.model.core.CodeableConcept d = src.getDetailFirstRep();
      if (d.hasCoding() || d.hasId() || d.hasExtension())
        return false;
    }
    return true;
  }

  public static org.hl7.fhir.model.core.AuditEvent convertAuditEvent(org.hl7.fhir.r4.model.AuditEvent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AuditEvent tgt = new org.hl7.fhir.model.core.AuditEvent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("AuditEvent", "5.0", new String[] {"severity", "basedOn", "patient", "encounter"}, CrossVersionElements40_N.urls("AuditEvent", "6.0", new String[] {}, OUTCOME_EXTENSION_URL, OCCURRED_EXTENSION_URL)));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "severity", "basedOn", "patient", "encounter");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodingToCodeableConcept(src.getType(), "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.type"));
    for (org.hl7.fhir.r4.model.Coding t : src.getSubtype())
      tgt.addSubtype(CodeableConcept40_N.convertCodingToCodeableConcept(t, "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.subtype"));
    if (src.hasAction())
      tgt.setActionElement(CrossVersionElements40_N.toR6Code(src.getActionElement(), convertAuditEventAction(src.getActionElement()), src.fhirType(), "action"));
    if (src.hasPeriod())
      tgt.setOccurred(Period40_N.convertPeriod(src.getPeriod()));
    else if (src.hasExtension(OCCURRED_EXTENSION_URL))
      tgt.setOccurred(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(OCCURRED_EXTENSION_URL).getValue()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant40_N.convertInstant(src.getRecordedElement()));
    // R6 outcome is a structure: unless it was kept whole in the extension, R4 outcome is its code and outcomeDesc its detail
    if (src.hasExtension(OUTCOME_EXTENSION_URL)) {
      CrossVersionDatatype40_N.populateDatatype(src.getExtensionByUrl(OUTCOME_EXTENSION_URL), tgt.getOutcome());
    } else {
      if (src.hasOutcome())
        tgt.getOutcome().getCode().setSystem(OUTCOME_SYSTEM).setCode(src.getOutcome().toCode());
      if (src.hasOutcomeDesc())
        tgt.getOutcome().getDetailFirstRep().setTextElement(String40_N.convertString(src.getOutcomeDescElement()));
    }
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
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "severity", "basedOn", "patient", "encounter");
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConceptToCoding(src.getType(), "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.type"));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSubtypeList())
      tgt.addSubtype(CodeableConcept40_N.convertCodeableConceptToCoding(t, "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.subtype"));
    if (src.hasAction())
      tgt.setActionElement(CrossVersionElements40_N.toR4Code(src.getActionElement(), convertAuditEventAction(src.getActionElement()), src.fhirType(), "action"));
    if (src.hasOccurredPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getOccurredPeriod()));
    else if (src.hasOccurred())
      tgt.addExtension(OCCURRED_EXTENSION_URL, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOccurred()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant40_N.convertInstant(src.getRecordedElement()));
    if (src.hasOutcome()) {
      if (OUTCOME_SYSTEM.equals(src.getOutcome().getCode().getSystem()))
        tgt.getOutcomeElement().setValueAsString(src.getOutcome().getCode().getCode());
      if (src.getOutcome().getDetailFirstRep().hasText())
        tgt.setOutcomeDescElement(String40_N.convertString(src.getOutcome().getDetailFirstRep().getTextElement()));
      if (!isR4Outcome(src.getOutcome()))
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(OUTCOME_EXTENSION_URL, src.getOutcome()));
    }
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("AuditEvent.agent", "4.0", new String[] {"altId", "name", "media"}, NETWORK_TYPE_EXTENSION_URL));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRole())
      tgt.addRole(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasWho())
      tgt.setWho(Reference40_N.convertReference(src.getWho()));
    // R6 dropped altId, name and media
    CrossVersionElements40_N.r4ElementsToExtensions(src, "AuditEvent.agent", tgt.getExtension(), "altId", "name", "media");
    if (src.hasRequestor())
      tgt.setRequestorElement(Boolean40_N.convertBoolean(src.getRequestorElement()));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.UriType t : src.getPolicy()) tgt.getPolicyList().add(Uri40_N.convertUri(t));
    // R4 network address is R6 network[x]: a uri if R4 says it is (type 5), otherwise a string, with the R4 type kept
    if (src.hasNetwork()) {
      if (src.getNetwork().hasExtension(NETWORK_EXTENSION_URL))
        tgt.setNetwork(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getNetwork().getExtensionByUrl(NETWORK_EXTENSION_URL).getValue()));
      else if (src.getNetwork().hasAddress()) {
        if (src.getNetwork().getType() == org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._5)
          tgt.setNetwork(new org.hl7.fhir.model.core.UriType(src.getNetwork().getAddress()));
        else
          tgt.setNetwork(new org.hl7.fhir.model.core.StringType(src.getNetwork().getAddress()));
      }
      if (src.getNetwork().hasType() && src.getNetwork().getType() != org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._5)
        tgt.addExtension(NETWORK_TYPE_EXTENSION_URL, new org.hl7.fhir.model.core.CodeType(src.getNetwork().getTypeElement().getValueAsString()));
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPurposeOfUse())
      tgt.addAuthorization(CodeableConcept40_N.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.model.core.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("AuditEvent.agent", "4.0", new String[] {"altId", "name", "media"}, NETWORK_TYPE_EXTENSION_URL));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getRoleList())
      tgt.addRole(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasWho())
      tgt.setWho(Reference40_N.convertReference(src.getWho()));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "AuditEvent.agent", "altId", "name", "media");
    if (src.hasRequestor())
      tgt.setRequestorElement(Boolean40_N.convertBoolean(src.getRequestorElement()));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.model.core.UriType t : src.getPolicyList()) tgt.getPolicy().add(Uri40_N.convertUri(t));
    if (src.hasNetworkStringType() || src.hasNetworkUriType()) {
      tgt.getNetwork().setAddress(src.getNetwork().primitiveValue());
      if (src.hasExtension(NETWORK_TYPE_EXTENSION_URL))
        tgt.getNetwork().getTypeElement().setValueAsString(src.getExtensionByUrl(NETWORK_TYPE_EXTENSION_URL).getValue().primitiveValue());
      else if (src.hasNetworkUriType())
        tgt.getNetwork().setType(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._5);
    } else if (src.hasNetwork()) {
      // a reference: R4 has nowhere for it
      tgt.getNetwork().addExtension(NETWORK_EXTENSION_URL, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getNetwork()));
    }
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
//      tgt.setTypeElement(CrossVersionElements40_N.toR6Code(src.getTypeElement(), convertAuditEventAgentNetworkType(src.getTypeElement()), src.fhirType(), "type"));
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
//      tgt.setTypeElement(CrossVersionElements40_N.toR4Code(src.getTypeElement(), convertAuditEventAgentNetworkType(src.getTypeElement()), src.fhirType(), "type"));
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
    // R4 site is a name; R6 site is a reference (to a Location): the name is its display, unless the whole reference was kept
    if (src.hasSite()) {
      if (src.getSiteElement().hasExtension(SITE_EXTENSION_URL))
        tgt.setSite(Reference40_N.convertReference((org.hl7.fhir.r4.model.Reference) src.getSiteElement().getExtensionByUrl(SITE_EXTENSION_URL).getValue()));
      else
        tgt.getSite().setDisplay(src.getSite());
    }
    if (src.hasObserver())
      tgt.setObserver(Reference40_N.convertReference(src.getObserver()));
    for (org.hl7.fhir.r4.model.Coding t : src.getType())
      tgt.addType(CodeableConcept40_N.convertCodingToCodeableConcept(t, "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.source.type"));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.model.core.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSite()) {
      tgt.setSite(src.getSite().getDisplay());
      org.hl7.fhir.model.core.Reference r = src.getSite();
      if (r.hasReference() || r.hasIdentifier() || r.hasType() || r.hasId() || r.hasExtension() || !r.hasDisplay())
        tgt.getSiteElement().addExtension(SITE_EXTENSION_URL, Reference40_N.convertReference(r));
    }
    if (src.hasObserver())
      tgt.setObserver(Reference40_N.convertReference(src.getObserver()));
    for (CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept40_N.convertCodeableConceptToCoding(t, "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.source.type"));
    return tgt;
  }

  public static org.hl7.fhir.model.core.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.model.core.AuditEvent.AuditEventEntityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("AuditEvent.entity", "5.0", new String[] {"agent"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "AuditEvent.entity", "5.0", "agent");
    if (src.hasWhat())
      tgt.setWhat(Reference40_N.convertReference(src.getWhat()));
    // R6 dropped type, lifecycle and name
    CrossVersionElements40_N.r4ElementsToExtensions(src, "AuditEvent.entity", tgt.getExtension(), "type", "lifecycle", "name");
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodingToCodeableConcept(src.getRole(), "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.entity.role"));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept40_N.convertCodingToCodeableConcept(t, "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.entity.securityLabel"));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("AuditEvent.entity", "4.0", new String[] {"type", "lifecycle", "name"}));
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "AuditEvent.entity", tgt.getExtension(), "5.0", "agent");
    if (src.hasWhat())
      tgt.setWhat(Reference40_N.convertReference(src.getWhat()));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "AuditEvent.entity", "type", "lifecycle", "name");
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConceptToCoding(src.getRole(), "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.entity.role"));
    for (CodeableConcept t : src.getSecurityLabelList())
      tgt.addSecurityLabel(CodeableConcept40_N.convertCodeableConceptToCoding(t, "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.entity.securityLabel"));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
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
      tgt.setType(CodeableConcept40_N.convertStringToCodeableConcept(src.getTypeElement(), "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.entity.detail.type"));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "value", tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.model.core.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(CodeableConcept40_N.convertCodeableConceptToString(src.getType(), "http://hl7.org/fhir/5.0/StructureDefinition/extension-AuditEvent.entity.detail.type"));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "value", tgt, tgt.getExtension());
    return tgt;
  }
}
