package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Base64Binary30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Instant30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;

public class AuditEvent30_50 {

  public static org.hl7.fhir.r5.model.AuditEvent convertAuditEvent(org.hl7.fhir.dstu3.model.AuditEvent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AuditEvent tgt = new org.hl7.fhir.r5.model.AuditEvent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasType())
      tgt.getCategoryFirstRep().addCoding(Coding30_50.convertCoding(src.getType()));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getSubtype()) tgt.getCode().addCoding(Coding30_50.convertCoding(t));
    if (src.hasAction())
      tgt.setActionElement(convertAuditEventAction(src.getActionElement()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant30_50.convertInstant(src.getRecordedElement()));
    if (src.hasOutcome())
      tgt.getOutcome().getCode().setSystem("http://terminology.hl7.org/CodeSystem/audit-event-outcome").setCode(src.getOutcome().toCode());
    if (src.hasOutcomeDesc())
      tgt.getOutcome().getDetailFirstRep().setTextElement(String30_50.convertString(src.getOutcomeDescElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPurposeOfEvent())
      tgt.addAuthorization(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent t : src.getAgent())
      tgt.addAgent(convertAuditEventAgentComponent(t));
    if (src.hasSource())
      tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
    for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent t : src.getEntity())
      tgt.addEntity(convertAuditEventEntityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.AuditEvent convertAuditEvent(org.hl7.fhir.r5.model.AuditEvent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AuditEvent tgt = new org.hl7.fhir.dstu3.model.AuditEvent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.getCategoryFirstRep().hasCoding()) {
      tgt.setType(Coding30_50.convertCoding(src.getCategoryFirstRep().getCodingFirstRep()));
    }
    for (org.hl7.fhir.r5.model.Coding t : src.getCode().getCoding()) tgt.addSubtype(Coding30_50.convertCoding(t));
    if (src.hasAction())
      tgt.setActionElement(convertAuditEventAction(src.getActionElement()));
    if (src.hasRecorded())
      tgt.setRecordedElement(Instant30_50.convertInstant(src.getRecordedElement()));
    if (src.hasOutcome() && "http://terminology.hl7.org/CodeSystem/audit-event-outcome".equals(src.getOutcome().getCode().getSystem()))
      tgt.getOutcomeElement().setValueAsString(src.getOutcome().getCode().getCode());
    if (src.getOutcome().getDetailFirstRep().hasText())
      tgt.setOutcomeDescElement(String30_50.convertString(src.getOutcome().getDetailFirstRep().getTextElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAuthorization())
      tgt.addPurposeOfEvent(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent t : src.getAgent())
      tgt.addAgent(convertAuditEventAgentComponent(t));
    if (src.hasSource())
      tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
    for (org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent t : src.getEntity())
      tgt.addEntity(convertAuditEventEntityComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAction> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.AuditEvent.AuditEventActionEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAction> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventActionEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case C:
        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.C);
        break;
      case R:
        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.R);
        break;
      case U:
        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.U);
        break;
      case D:
        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.D);
        break;
      case E:
        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.E);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole())
      tgt.addRole(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasReference())
      tgt.setWho(Reference30_50.convertReference(src.getReference()));
    if (src.hasUserId())
      tgt.getWho().setIdentifier(Identifier30_50.convertIdentifier(src.getUserId()));
//    if (src.hasAltId())
//      tgt.setAltIdElement(String30_50.convertString(src.getAltIdElement()));
//    if (src.hasName())
//      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasRequestor())
      tgt.setRequestorElement(Boolean30_50.convertBoolean(src.getRequestorElement()));
    if (src.hasLocation())
      tgt.setLocation(Reference30_50.convertReference(src.getLocation()));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
//    if (src.hasMedia())
//      tgt.setMedia(Coding30_50.convertCoding(src.getMedia()));
//    if (src.hasNetwork())
//      tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPurposeOfUse())
      tgt.addAuthorization(CodeableConcept30_50.convertCodeableConcept(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRole())
      tgt.addRole(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasWho()) {
      if (src.getWho().hasIdentifier())
        tgt.setUserId(Identifier30_50.convertIdentifier(src.getWho().getIdentifier()));
      if (src.getWho().hasReference() || src.getWho().hasDisplay() || src.getWho().hasExtension() || src.getWho().hasId())
        tgt.setReference(Reference30_50.convertReference(src.getWho()));
    }
//    if (src.hasAltId())
//      tgt.setAltIdElement(String30_50.convertString(src.getAltIdElement()));
//    if (src.hasName())
//      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasRequestor())
      tgt.setRequestorElement(Boolean30_50.convertBoolean(src.getRequestorElement()));
    if (src.hasLocation())
      tgt.setLocation(Reference30_50.convertReference(src.getLocation()));
    for (org.hl7.fhir.r5.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
//    if (src.hasMedia())
//      tgt.setMedia(Coding30_50.convertCoding(src.getMedia()));
//    if (src.hasNetwork())
//      tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAuthorization())
      tgt.addPurposeOfUse(CodeableConcept30_50.convertCodeableConcept(t));
    return tgt;
  }
//
//  public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
//    if (src.hasAddress())
//      tgt.setAddressElement(String30_50.convertString(src.getAddressElement()));
//    if (src.hasType())
//      tgt.setTypeElement(convertAuditEventAgentNetworkType(src.getTypeElement()));
//    return tgt;
//  }

//  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent();
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
//    if (src.hasAddress())
//      tgt.setAddressElement(String30_50.convertString(src.getAddressElement()));
//    if (src.hasType())
//      tgt.setTypeElement(convertAuditEventAgentNetworkType(src.getTypeElement()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType> convertAuditEventAgentNetworkType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkTypeEnumFactory());
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case _1:
//        tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._1);
//        break;
//      case _2:
//        tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._2);
//        break;
//      case _3:
//        tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._3);
//        break;
//      case _4:
//        tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._4);
//        break;
//      case _5:
//        tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._5);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType> convertAuditEventAgentNetworkType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkTypeEnumFactory());
//    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case _1:
//        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._1);
//        break;
//      case _2:
//        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._2);
//        break;
//      case _3:
//        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._3);
//        break;
//      case _4:
//        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._4);
//        break;
//      case _5:
//        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._5);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType.NULL);
//        break;
//    }
//    return tgt;
//  }
//
  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasIdentifier())
      tgt.getWhat().setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    if (src.hasReference())
      tgt.setWhat(Reference30_50.convertReference(src.getReference()));
//    if (src.hasType())
//      tgt.setType(Coding30_50.convertCoding(src.getType()));
    if (src.hasRole())
      tgt.getRole().addCoding(Coding30_50.convertCoding(src.getRole()));
//    if (src.hasLifecycle())
//      tgt.setLifecycle(Coding30_50.convertCoding(src.getLifecycle()));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel().addCoding(Coding30_50.convertCoding(t));
//    if (src.hasName())
//      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasQuery())
      tgt.setQueryElement(Base64Binary30_50.convertBase64Binary(src.getQueryElement()));
    for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail())
      tgt.addDetail(convertAuditEventEntityDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasWhat()) {
      if (src.getWhat().hasIdentifier())
        tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getWhat().getIdentifier()));
      if (src.getWhat().hasReference() || src.getWhat().hasDisplay() || src.getWhat().hasExtension() || src.getWhat().hasId())
        tgt.setReference(Reference30_50.convertReference(src.getWhat()));
    }
//    if (src.hasType())
//      tgt.setType(Coding30_50.convertCoding(src.getType()));
    if (src.hasRole())
      tgt.setRole(Coding30_50.convertCoding(src.getRole()));
//    if (src.hasLifecycle())
//      tgt.setLifecycle(Coding30_50.convertCoding(src.getLifecycle()));
    for (CodeableConcept t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding30_50.convertCoding(t.getCodingFirstRep()));
//    if (src.hasName())
//      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasQuery())
      tgt.setQueryElement(Base64Binary30_50.convertBase64Binary(src.getQueryElement()));
    for (org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail())
      tgt.addDetail(convertAuditEventEntityDetailComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getType().hasTextElement())
      tgt.setTypeElement(String30_50.convertString(src.getType().getTextElement()));
    if (src.hasValueStringType())
      tgt.setValue(src.getValueStringType().getValue().getBytes());
    else if (src.hasValueBase64BinaryType())
      tgt.setValue(src.getValueBase64BinaryType().getValue());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasType())
      tgt.getType().setTextElement(String30_50.convertString(src.getTypeElement()));
    if (src.hasValue())
      tgt.setValue(new org.hl7.fhir.r5.model.Base64BinaryType(src.getValue()));
    return tgt;
  }


  public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
//    if (src.hasSite())
//      tgt.setSiteElement(String30_50.convertString(src.getSiteElement()));
    if (src.hasObserver())
      tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getObserver().getIdentifier()));
    for (CodeableConcept t : src.getType()) tgt.addType(Coding30_50.convertCoding(t.getCodingFirstRep()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
//    if (src.hasSite())
//      tgt.setSiteElement(String30_50.convertString(src.getSiteElement()));
    if (src.hasIdentifier())
      tgt.getObserver().setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType().addCoding(Coding30_50.convertCoding(t));
    return tgt;
  }
}