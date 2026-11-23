package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Instant43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Integer64_43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
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
      tgt.setEventsSinceSubscriptionStartElement(Integer64_43_N.convertInteger64ToString(src.getEventsSinceSubscriptionStartElement()));
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
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent tgt = new org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionStatusNotificationEventComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
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
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory);
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  private static org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> convertSubscriptionNotificationType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType> src) {
      SubscriptionStatus.SubscriptionNotificationTypeEnumFactory enumFactory = new SubscriptionStatus.SubscriptionNotificationTypeEnumFactory();
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(enumFactory);
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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
      tgt.setEventsSinceSubscriptionStartElement(Integer64_43_N.convertStringToInteger64(src.getEventsSinceSubscriptionStartElement()));
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
    if (src == null)
      return null;
    org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionStatusNotificationEventComponent tgt = new org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionStatusNotificationEventComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
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
      org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes> tgt = new org.hl7.fhir.model.core.Enumeration<>(enumFactory);
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
         tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.ACTIVE);
                  break;
              case ERROR:
                  tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.ERROR);
                  break;
              case OFF:
                  tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.OFF);
                  break;
              case REQUESTED:
                  tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.REQUESTED);
                  break;
              case NULL:
                  tgt.setValue(org.hl7.fhir.model.core.Enumerations.SubscriptionStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  private static org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType> convertSubscriptionNotificationType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SubscriptionStatus.SubscriptionNotificationType> src) {
      org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory enumFactory = new org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationTypeEnumFactory();
      org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType> tgt = new org.hl7.fhir.model.core.Enumeration<>(enumFactory);
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
         tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EVENTNOTIFICATION:
                  tgt.setValue(org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.EVENTNOTIFICATION);
                  break;
              case HANDSHAKE:
                  tgt.setValue(org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.HANDSHAKE);
                  break;
              case HEARTBEAT:
                  tgt.setValue(org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.HEARTBEAT);
                  break;
              case QUERYEVENT:
                  tgt.setValue(org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.QUERYEVENT);
                  break;
              case QUERYSTATUS:
                  tgt.setValue(org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.QUERYSTATUS);
                  break;
              case NULL:
                  tgt.setValue(org.hl7.fhir.model.core.SubscriptionStatus.SubscriptionNotificationType.NULL);
                  break;
          }
      }
      return tgt;
  }
}
