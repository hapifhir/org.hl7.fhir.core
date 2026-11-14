package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Instant43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer64_43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.r4b.model.Enumeration;
import org.hl7.fhir.r4b.model.Enumerations;
import org.hl7.fhir.r4b.model.SubscriptionStatus;

public class SubscriptionStatus43_N {
  public static org.hl7.fhir.r4b.model.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.model.core.SubscriptionStatus src) {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SubscriptionStatus tgt = new org.hl7.fhir.r4b.model.SubscriptionStatus();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyResource(src, tgt);
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);

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
      for (org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionStatusNotificationEventComponent element : src.getNotificationEventList()) {
        tgt.addNotificationEvent(convertSubscriptionStatusNotificationEventComponent(element));
      }
    }
    if (src.hasSubscription()) {
      tgt.setSubscription(Reference43_N.convertReference(src.getSubscription()));
    }
    if (src.hasTopic()) {
      tgt.setTopicElement(Canonical43_N.convertCanonical(src.getTopicElement()));
    }
    if (src.hasError()) {
      for (org.hl7.fhir.model.core.CodeableConcept srcError : src.getErrorList()) {
        tgt.addError(CodeableConcept43_N.convertCodeableConcept(srcError));
      }
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent convertSubscriptionStatusNotificationEventComponent(org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionStatusNotificationEventComponent src) {
    org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent tgt = new org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent();
    if (src.hasEventNumber()) {
      tgt.setEventNumberElement(Integer64_43_N.convertInteger64ToString(src.getEventNumberElement()));
    }
    if (src.hasTimestamp()) {
      tgt.setTimestampElement(Instant43_N.convertInstant(src.getTimestampElement()));
    }
    if (src.hasFocus()) {
      tgt.setFocus(Reference43_N.convertReference(src.getFocus()));
    }
    if (src.hasAdditionalContext()) {
      for (org.hl7.fhir.model.core.Reference ref : src.getAdditionalContextList()) {
        tgt.addAdditionalContext(Reference43_N.convertReference(ref));
      }
    }
    return tgt;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus> convertSubscriptionStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes> src) {
      Enumerations.SubscriptionStatusEnumFactory enumFactory = new Enumerations.SubscriptionStatusEnumFactory();
      if (src.getValue() == null) {
          return null;
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  return new Enumeration<>(enumFactory, Enumerations.SubscriptionStatus.ACTIVE);
              case ERROR:
                  return new Enumeration<>(enumFactory, Enumerations.SubscriptionStatus.ERROR);
              case ENTEREDINERROR:
                  return new Enumeration<>(enumFactory, Enumerations.SubscriptionStatus.ERROR);
              case OFF:
                  return new Enumeration<>(enumFactory, Enumerations.SubscriptionStatus.OFF);
              case REQUESTED:
                  return new Enumeration<>(enumFactory, Enumerations.SubscriptionStatus.REQUESTED);
              case NULL:
                  return new Enumeration<>(enumFactory, Enumerations.SubscriptionStatus.NULL);
          }
      }
      return null;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> convertSubscriptionNotificationType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType> src) {
      SubscriptionStatus.SubscriptionNotificationTypeEnumFactory enumFactory = new SubscriptionStatus.SubscriptionNotificationTypeEnumFactory();
      if (src.getValue() == null) {
         return null;
      } else {
          switch (src.getValue()) {
              case EVENTNOTIFICATION:
                  return new Enumeration<>(enumFactory, SubscriptionStatus.SubscriptionNotificationType.EVENTNOTIFICATION);
              case HANDSHAKE:
                  return new Enumeration<>(enumFactory, SubscriptionStatus.SubscriptionNotificationType.HANDSHAKE);
              case HEARTBEAT:
                  return new Enumeration<>(enumFactory, SubscriptionStatus.SubscriptionNotificationType.HEARTBEAT);
              case QUERYEVENT:
                  return new Enumeration<>(enumFactory, SubscriptionStatus.SubscriptionNotificationType.QUERYEVENT);
              case QUERYSTATUS:
                  return new Enumeration<>(enumFactory, SubscriptionStatus.SubscriptionNotificationType.QUERYSTATUS);
              case NULL:
                  return new Enumeration<>(enumFactory, SubscriptionStatus.SubscriptionNotificationType.NULL);
          }
      }
      return null;
  }


  public static org.hl7.fhir.model.core.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.r4b.model.SubscriptionStatus src) {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.SubscriptionStatus tgt = new org.hl7.fhir.model.core.SubscriptionStatus();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyResource(src, tgt);
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);

    if (src.hasType())
    {
      tgt.setTypeElement(convertSubscriptionNotificationType(src.getTypeElement()));
    }
    if (src.hasStatus()) {
      tgt.setStatusElement(convertSubscriptionStatus(src.getStatusElement()));
    }
    if (src.hasEventsSinceSubscriptionStart()) {
      org.hl7.fhir.model.core.Integer64Type value = new org.hl7.fhir.model.core.Integer64Type();
      value.fromStringValue(src.getEventsSinceSubscriptionStartElement().getValueAsString());
      tgt.setEventsSinceSubscriptionStartElement(value);
    }
    if (src.hasNotificationEvent()) {
      for (org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent element : src.getNotificationEvent()) {
        tgt.addNotificationEvent(convertSubscriptionStatusNotificationEventComponent(element));
      }
    }
    if (src.hasSubscription()) {
      tgt.setSubscription(Reference43_N.convertReference(src.getSubscription()));
    }
    if (src.hasTopic()) {
      tgt.setTopicElement(Canonical43_N.convertCanonical(src.getTopicElement()));
    }
    if (src.hasError()) {
      for (org.hl7.fhir.r4b.model.CodeableConcept srcError : src.getError()) {
        tgt.addError(CodeableConcept43_N.convertCodeableConcept(srcError));
      }
    }
    return tgt;
  }

  private static org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionStatusNotificationEventComponent convertSubscriptionStatusNotificationEventComponent(org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent src) {
    org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionStatusNotificationEventComponent tgt = new org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionStatusNotificationEventComponent();
    if (src.hasEventNumber()) {
      tgt.setEventNumberElement(Integer64_43_N.convertStringToInteger64(src.getEventNumberElement()));
    }
    if (src.hasTimestamp()) {
      tgt.setTimestampElement(Instant43_N.convertInstant(src.getTimestampElement()));
    }
    if (src.hasFocus()) {
      tgt.setFocus(Reference43_N.convertReference(src.getFocus()));
    }
    if (src.hasAdditionalContext()) {
      for (org.hl7.fhir.r4b.model.Reference ref : src.getAdditionalContext()) {
        tgt.addAdditionalContext(Reference43_N.convertReference(ref));
      }
    }
    return tgt;
  }

  private static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes> convertSubscriptionStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus> src) {
      org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodesEnumFactory enumFactory = new org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodesEnumFactory();
      if (src.getValue() == null) {
         return null;
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.ACTIVE);
              case ERROR:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.ERROR);
              case OFF:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.OFF);
              case REQUESTED:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.REQUESTED);
              case NULL:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.NULL);
          }
      }
      return null;
  }

  private static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType> convertSubscriptionNotificationType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> src) {
      org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory enumFactory = new org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory();
      if (src.getValue() == null) {
         return null;
      } else {
          switch (src.getValue()) {
              case EVENTNOTIFICATION:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.EVENTNOTIFICATION);
              case HANDSHAKE:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.HANDSHAKE);
              case HEARTBEAT:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.HEARTBEAT);
              case QUERYEVENT:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.QUERYEVENT);
              case QUERYSTATUS:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.QUERYSTATUS);
              case NULL:
                  return new org.hl7.fhir.model.core.Enumeration<>(enumFactory, org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.NULL);
          }
      }
      return null;
  }
}
