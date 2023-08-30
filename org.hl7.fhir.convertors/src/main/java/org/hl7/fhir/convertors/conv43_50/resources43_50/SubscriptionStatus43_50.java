package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;

import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Integer64_43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Time43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;

public class SubscriptionStatus43_50 {
  public static org.hl7.fhir.r4b.model.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.r5.model.SubscriptionStatus src) {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SubscriptionStatus tgt = new org.hl7.fhir.r4b.model.SubscriptionStatus();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyResource(src, tgt);
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);

    if (src.hasType())
    {
      tgt.setTypeElement(convertSubscriptionNotificationType(src.getTypeElement()));
    }
    if (src.hasStatus()) {
      tgt.setStatusElement(convertSubscriptionStatus(src.getStatusElement()));
    }
    if (src.hasEventsSinceSubscriptionStart()) {
      org.hl7.fhir.r4b.model.StringType value = new org.hl7.fhir.r4b.model.StringType();
      value.setValue(src.getEventsSinceSubscriptionStartElement().getValueAsString());
      tgt.setEventsSinceSubscriptionStartElement(value);
    }
    if (src.hasNotificationEvent()) {
      for (org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent element : src.getNotificationEvent()) {
        tgt.addNotificationEvent(convertSubscriptionStatusNotificationEventComponent(element));
      }
    }
    if (src.hasSubscription()) {
      tgt.setSubscription(Reference43_50.convertReference(src.getSubscription()));
    }
    if (src.hasTopic()) {
      tgt.setTopicElement(Canonical43_50.convertCanonical(src.getTopicElement()));
    }
    if (src.hasError()) {
      for (org.hl7.fhir.r5.model.CodeableConcept srcError : src.getError()) {
        tgt.addError(CodeableConcept43_50.convertCodeableConcept(srcError));
      }
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent convertSubscriptionStatusNotificationEventComponent(org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent src) {
    org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent tgt = new org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent();
    if (src.hasEventNumber()) {
      tgt.setEventNumberElement(Integer64_43_50.convertInteger64ToString(src.getEventNumberElement()));
    }
    if (src.hasTimestamp()) {
      tgt.setTimestampElement(Instant43_50.convertInstant(src.getTimestampElement()));
    }
    if (src.hasFocus()) {
      tgt.setFocus(Reference43_50.convertReference(src.getFocus()));
    }
    if (src.hasAdditionalContext()) {
      for (org.hl7.fhir.r5.model.Reference ref : src.getAdditionalContext()) {
        tgt.addAdditionalContext(Reference43_50.convertReference(ref));
      }
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus> convertSubscriptionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes> src) {
    org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatusEnumFactory enumFactory = new org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatusEnumFactory();
    switch(src.getValue()) {
      case ACTIVE: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus.ACTIVE);
      case ERROR: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus.ERROR);
      case ENTEREDINERROR: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus.ERROR);
      case OFF: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus.OFF);
      case REQUESTED: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus.REQUESTED);
      case NULL: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus.NULL);
    }
    return null;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> convertSubscriptionNotificationType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType> src) {
    org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory enumFactory = new org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory();
    switch(src.getValue()) {
      case EVENTNOTIFICATION: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType.EVENTNOTIFICATION);
      case HANDSHAKE: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType.HANDSHAKE);
      case HEARTBEAT: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType.HEARTBEAT);
      case QUERYEVENT: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType.QUERYEVENT);
      case QUERYSTATUS: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType.QUERYSTATUS);
      case NULL: return new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory, org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType.NULL);
    }
    return null;
  }


  public static org.hl7.fhir.r5.model.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.r4b.model.SubscriptionStatus src) {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubscriptionStatus tgt = new org.hl7.fhir.r5.model.SubscriptionStatus();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyResource(src, tgt);
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);

    if (src.hasType())
    {
      tgt.setTypeElement(convertSubscriptionNotificationType(src.getTypeElement()));
    }
    if (src.hasStatus()) {
      tgt.setStatusElement(convertSubscriptionStatus(src.getStatusElement()));
    }
    if (src.hasEventsSinceSubscriptionStart()) {
      org.hl7.fhir.r5.model.Integer64Type value = new org.hl7.fhir.r5.model.Integer64Type();
      value.fromStringValue(src.getEventsSinceSubscriptionStartElement().getValueAsString());
      tgt.setEventsSinceSubscriptionStartElement(value);
    }
    if (src.hasNotificationEvent()) {
      for (org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent element : src.getNotificationEvent()) {
        tgt.addNotificationEvent(convertSubscriptionStatusNotificationEventComponent(element));
      }
    }
    if (src.hasSubscription()) {
      tgt.setSubscription(Reference43_50.convertReference(src.getSubscription()));
    }
    if (src.hasTopic()) {
      tgt.setTopicElement(Canonical43_50.convertCanonical(src.getTopicElement()));
    }
    if (src.hasError()) {
      for (org.hl7.fhir.r4b.model.CodeableConcept srcError : src.getError()) {
        tgt.addError(CodeableConcept43_50.convertCodeableConcept(srcError));
      }
    }
    return tgt;
  }

  private static org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent convertSubscriptionStatusNotificationEventComponent(org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent src) {
    org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent tgt = new org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent();
    if (src.hasEventNumber()) {
      tgt.setEventNumberElement(Integer64_43_50.convertStringToInteger64(src.getEventNumberElement()));
    }
    if (src.hasTimestamp()) {
      tgt.setTimestampElement(Instant43_50.convertInstant(src.getTimestampElement()));
    }
    if (src.hasFocus()) {
      tgt.setFocus(Reference43_50.convertReference(src.getFocus()));
    }
    if (src.hasAdditionalContext()) {
      for (org.hl7.fhir.r4b.model.Reference ref : src.getAdditionalContext()) {
        tgt.addAdditionalContext(Reference43_50.convertReference(ref));
      }
    }
    return tgt;
  }

  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes> convertSubscriptionStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus> src) {
    org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodesEnumFactory enumFactory = new org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodesEnumFactory();
    switch(src.getValue()) {
      case ACTIVE: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.ACTIVE);
      case ERROR: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.ERROR);
      case OFF: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.OFF);
      case REQUESTED: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.REQUESTED);
      case NULL: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.NULL);
    }
    return null;
  }

  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType> convertSubscriptionNotificationType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> src) {
    org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory enumFactory = new org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory();
    switch(src.getValue()) {
      case EVENTNOTIFICATION: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.EVENTNOTIFICATION);
      case HANDSHAKE: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.HANDSHAKE);
      case HEARTBEAT: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.HEARTBEAT);
      case QUERYEVENT: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.QUERYEVENT);
      case QUERYSTATUS: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.QUERYSTATUS);
      case NULL: return new org.hl7.fhir.r5.model.Enumeration<>(enumFactory, org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.NULL);
    }
    return null;
  }
}
