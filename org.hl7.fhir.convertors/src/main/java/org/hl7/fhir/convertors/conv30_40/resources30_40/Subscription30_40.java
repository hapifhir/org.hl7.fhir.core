package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.ContactPoint30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Instant30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Subscription30_40 {

  public static org.hl7.fhir.r4.model.Subscription convertSubscription(org.hl7.fhir.dstu3.model.Subscription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Subscription tgt = new org.hl7.fhir.r4.model.Subscription();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertSubscriptionStatus(src.getStatusElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint30_40.convertContactPoint(t));
    if (src.hasEnd())
      tgt.setEndElement(Instant30_40.convertInstant(src.getEndElement()));
    if (src.hasReason())
      tgt.setReasonElement(String30_40.convertString(src.getReasonElement()));
    if (src.hasCriteria())
      tgt.setCriteriaElement(String30_40.convertString(src.getCriteriaElement()));
    if (src.hasError())
      tgt.setErrorElement(String30_40.convertString(src.getErrorElement()));
    if (src.hasChannel())
      tgt.setChannel(convertSubscriptionChannelComponent(src.getChannel()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Subscription convertSubscription(org.hl7.fhir.r4.model.Subscription src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Subscription tgt = new org.hl7.fhir.dstu3.model.Subscription();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertSubscriptionStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact())
      tgt.addContact(ContactPoint30_40.convertContactPoint(t));
    if (src.hasEnd())
      tgt.setEndElement(Instant30_40.convertInstant(src.getEndElement()));
    if (src.hasReason())
      tgt.setReasonElement(String30_40.convertString(src.getReasonElement()));
    if (src.hasCriteria())
      tgt.setCriteriaElement(String30_40.convertString(src.getCriteriaElement()));
    if (src.hasError())
      tgt.setErrorElement(String30_40.convertString(src.getErrorElement()));
    if (src.hasChannel())
      tgt.setChannel(convertSubscriptionChannelComponent(src.getChannel()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent convertSubscriptionChannelComponent(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent tgt = new org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertSubscriptionChannelType(src.getTypeElement()));
    if (src.hasEndpoint())
      tgt.setEndpoint(src.getEndpoint());
    if (src.hasPayload())
      tgt.setPayload(src.getPayload());
    for (org.hl7.fhir.r4.model.StringType t : src.getHeader()) tgt.addHeader(t.getValue());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent convertSubscriptionChannelComponent(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent tgt = new org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertSubscriptionChannelType(src.getTypeElement()));
    if (src.hasEndpoint())
      tgt.setEndpoint(src.getEndpoint());
    if (src.hasPayload())
      tgt.setPayload(src.getPayload());
    for (org.hl7.fhir.dstu3.model.StringType t : src.getHeader()) tgt.addHeader(t.getValue());
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType> convertSubscriptionChannelType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESTHOOK:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.RESTHOOK);
        break;
      case WEBSOCKET:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.WEBSOCKET);
        break;
      case EMAIL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.EMAIL);
        break;
      case SMS:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.SMS);
        break;
      case MESSAGE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.MESSAGE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType> convertSubscriptionChannelType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Subscription.SubscriptionChannelTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESTHOOK:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.RESTHOOK);
        break;
      case WEBSOCKET:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.WEBSOCKET);
        break;
      case EMAIL:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.EMAIL);
        break;
      case SMS:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.SMS);
        break;
      case MESSAGE:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.MESSAGE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Subscription.SubscriptionStatus> convertSubscriptionStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Subscription.SubscriptionStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Subscription.SubscriptionStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUESTED:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.REQUESTED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.ACTIVE);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.ERROR);
        break;
      case OFF:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.OFF);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus> convertSubscriptionStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Subscription.SubscriptionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUESTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.REQUESTED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.ACTIVE);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.ERROR);
        break;
      case OFF:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.OFF);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.NULL);
        break;
    }
    return tgt;
  }
}