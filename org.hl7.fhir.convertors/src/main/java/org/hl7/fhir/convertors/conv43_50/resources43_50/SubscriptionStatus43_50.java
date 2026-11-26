package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Integer64_43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.r4b.model.Enumerations;
import org.hl7.fhir.r4b.model.SubscriptionStatus;

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
      tgt.setEventsSinceSubscriptionStartElement(Integer64_43_50.convertInteger64ToString(src.getEventsSinceSubscriptionStartElement()));
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
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent tgt = new org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
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
      Enumerations.SubscriptionStatusEnumFactory enumFactory = new Enumerations.SubscriptionStatusEnumFactory();
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory);
      ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Enumerations.SubscriptionStatus.ACTIVE);
                  break;
              case ERROR:
                  tgt.setValue(Enumerations.SubscriptionStatus.ERROR);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.SubscriptionStatus.ERROR);
                  break;
              case OFF:
                  tgt.setValue(Enumerations.SubscriptionStatus.OFF);
                  break;
              case REQUESTED:
                  tgt.setValue(Enumerations.SubscriptionStatus.REQUESTED);
                  break;
              case NULL:
                  tgt.setValue(Enumerations.SubscriptionStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> convertSubscriptionNotificationType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType> src) {
      SubscriptionStatus.SubscriptionNotificationTypeEnumFactory enumFactory = new SubscriptionStatus.SubscriptionNotificationTypeEnumFactory();
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory);
      ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
      if (src.getValue() == null) {
         tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EVENTNOTIFICATION:
                  tgt.setValue(SubscriptionStatus.SubscriptionNotificationType.EVENTNOTIFICATION);
                  break;
              case HANDSHAKE:
                  tgt.setValue(SubscriptionStatus.SubscriptionNotificationType.HANDSHAKE);
                  break;
              case HEARTBEAT:
                  tgt.setValue(SubscriptionStatus.SubscriptionNotificationType.HEARTBEAT);
                  break;
              case QUERYEVENT:
                  tgt.setValue(SubscriptionStatus.SubscriptionNotificationType.QUERYEVENT);
                  break;
              case QUERYSTATUS:
                  tgt.setValue(SubscriptionStatus.SubscriptionNotificationType.QUERYSTATUS);
                  break;
              case NULL:
                  tgt.setValue(SubscriptionStatus.SubscriptionNotificationType.NULL);
                  break;
          }
      }
      return tgt;
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
      tgt.setEventsSinceSubscriptionStartElement(Integer64_43_50.convertStringToInteger64(src.getEventsSinceSubscriptionStartElement()));
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
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent tgt = new org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
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
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(enumFactory);
      ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
      if (src.getValue() == null) {
         tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.ACTIVE);
                  break;
              case ERROR:
                  tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.ERROR);
                  break;
              case OFF:
                  tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.OFF);
                  break;
              case REQUESTED:
                  tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.REQUESTED);
                  break;
              case NULL:
                  tgt.setValue(org.hl7.fhir.r5.model.Enumerations.SubscriptionStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  private static org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType> convertSubscriptionNotificationType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> src) {
      org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory enumFactory = new org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory();
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(enumFactory);
      ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
      if (src.getValue() == null) {
         tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EVENTNOTIFICATION:
                  tgt.setValue(org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.EVENTNOTIFICATION);
                  break;
              case HANDSHAKE:
                  tgt.setValue(org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.HANDSHAKE);
                  break;
              case HEARTBEAT:
                  tgt.setValue(org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.HEARTBEAT);
                  break;
              case QUERYEVENT:
                  tgt.setValue(org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.QUERYEVENT);
                  break;
              case QUERYSTATUS:
                  tgt.setValue(org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.QUERYSTATUS);
                  break;
              case NULL:
                  tgt.setValue(org.hl7.fhir.r5.model.SubscriptionStatus.SubscriptionNotificationType.NULL);
                  break;
          }
      }
      return tgt;
  }
}
