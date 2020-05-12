package org.hl7.fhir.r5.model;




/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

// Generated on Mon, May 11, 2020 09:58+1000 for FHIR vcurrent

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r5.model.Enumerations.*;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.ICompositeType;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;

/**
 * The SubscriptionStatus resource describes the state of a Subscription during notifications.
 */
@ResourceDef(name="SubscriptionStatus", profile="http://hl7.org/fhir/StructureDefinition/SubscriptionStatus")
public class SubscriptionStatus extends DomainResource {

    public enum SubscriptionNotificationType {
        /**
         * The notification is being sent as part of the setup or verification of a communications channel.
         */
        HANDSHAKE, 
        /**
         * The notification is being sent because there has not been a notification generated over an extended period of time.
         */
        HEARTBEAT, 
        /**
         * The notification is being sent due to an event for the subscriber.
         */
        EVENTNOTIFICATION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SubscriptionNotificationType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("handshake".equals(codeString))
          return HANDSHAKE;
        if ("heartbeat".equals(codeString))
          return HEARTBEAT;
        if ("event-notification".equals(codeString))
          return EVENTNOTIFICATION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SubscriptionNotificationType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case HANDSHAKE: return "handshake";
            case HEARTBEAT: return "heartbeat";
            case EVENTNOTIFICATION: return "event-notification";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case HANDSHAKE: return "http://hl7.org/fhir/subscription-notification-type";
            case HEARTBEAT: return "http://hl7.org/fhir/subscription-notification-type";
            case EVENTNOTIFICATION: return "http://hl7.org/fhir/subscription-notification-type";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case HANDSHAKE: return "The notification is being sent as part of the setup or verification of a communications channel.";
            case HEARTBEAT: return "The notification is being sent because there has not been a notification generated over an extended period of time.";
            case EVENTNOTIFICATION: return "The notification is being sent due to an event for the subscriber.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case HANDSHAKE: return "Handshake";
            case HEARTBEAT: return "Heartbeat";
            case EVENTNOTIFICATION: return "Event Notification";
            default: return "?";
          }
        }
    }

  public static class SubscriptionNotificationTypeEnumFactory implements EnumFactory<SubscriptionNotificationType> {
    public SubscriptionNotificationType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("handshake".equals(codeString))
          return SubscriptionNotificationType.HANDSHAKE;
        if ("heartbeat".equals(codeString))
          return SubscriptionNotificationType.HEARTBEAT;
        if ("event-notification".equals(codeString))
          return SubscriptionNotificationType.EVENTNOTIFICATION;
        throw new IllegalArgumentException("Unknown SubscriptionNotificationType code '"+codeString+"'");
        }
        public Enumeration<SubscriptionNotificationType> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SubscriptionNotificationType>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("handshake".equals(codeString))
          return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.HANDSHAKE);
        if ("heartbeat".equals(codeString))
          return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.HEARTBEAT);
        if ("event-notification".equals(codeString))
          return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.EVENTNOTIFICATION);
        throw new FHIRException("Unknown SubscriptionNotificationType code '"+codeString+"'");
        }
    public String toCode(SubscriptionNotificationType code) {
      if (code == SubscriptionNotificationType.HANDSHAKE)
        return "handshake";
      if (code == SubscriptionNotificationType.HEARTBEAT)
        return "heartbeat";
      if (code == SubscriptionNotificationType.EVENTNOTIFICATION)
        return "event-notification";
      return "?";
      }
    public String toSystem(SubscriptionNotificationType code) {
      return code.getSystem();
      }
    }

    /**
     * The type of event being conveyed with this notificaiton.
     */
    @Child(name = "notificationType", type = {CodeType.class}, order=0, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="handshake | heartbeat | event-notification", formalDefinition="The type of event being conveyed with this notificaiton." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-notification-type")
    protected Enumeration<SubscriptionNotificationType> notificationType;

    /**
     * The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.
     */
    @Child(name = "eventsSinceSubscriptionStart", type = {Integer64Type.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Events since the Subscription was created", formalDefinition="The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications." )
    protected Integer64Type eventsSinceSubscriptionStart;

    /**
     * The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.
     */
    @Child(name = "eventsInNotification", type = {IntegerType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Events in this notification", formalDefinition="The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching." )
    protected IntegerType eventsInNotification;

    /**
     * The reference to the Subscription which generated this notification.
     */
    @Child(name = "subscription", type = {Subscription.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to the Subscription responsible for this notification", formalDefinition="The reference to the Subscription which generated this notification." )
    protected Reference subscription;

    /**
     * The status of the subscription, which marks the server state for managing the subscription.
     */
    @Child(name = "status", type = {CodeType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="requested | active | error | off", formalDefinition="The status of the subscription, which marks the server state for managing the subscription." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-state")
    protected Enumeration<SubscriptionState> status;

    /**
     * The reference to the SubscriptionTopic for the Subscription which generated this notification.
     */
    @Child(name = "topic", type = {SubscriptionTopic.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to the SubscriptionTopic this notification relates to", formalDefinition="The reference to the SubscriptionTopic for the Subscription which generated this notification." )
    protected Reference topic;

    private static final long serialVersionUID = -1378030794L;

  /**
   * Constructor
   */
    public SubscriptionStatus() {
      super();
    }

  /**
   * Constructor
   */
    public SubscriptionStatus(SubscriptionNotificationType notificationType, Reference subscription, Reference topic) {
      super();
      this.setNotificationType(notificationType);
      this.setSubscription(subscription);
      this.setTopic(topic);
    }

    /**
     * @return {@link #notificationType} (The type of event being conveyed with this notificaiton.). This is the underlying object with id, value and extensions. The accessor "getNotificationType" gives direct access to the value
     */
    public Enumeration<SubscriptionNotificationType> getNotificationTypeElement() { 
      if (this.notificationType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.notificationType");
        else if (Configuration.doAutoCreate())
          this.notificationType = new Enumeration<SubscriptionNotificationType>(new SubscriptionNotificationTypeEnumFactory()); // bb
      return this.notificationType;
    }

    public boolean hasNotificationTypeElement() { 
      return this.notificationType != null && !this.notificationType.isEmpty();
    }

    public boolean hasNotificationType() { 
      return this.notificationType != null && !this.notificationType.isEmpty();
    }

    /**
     * @param value {@link #notificationType} (The type of event being conveyed with this notificaiton.). This is the underlying object with id, value and extensions. The accessor "getNotificationType" gives direct access to the value
     */
    public SubscriptionStatus setNotificationTypeElement(Enumeration<SubscriptionNotificationType> value) { 
      this.notificationType = value;
      return this;
    }

    /**
     * @return The type of event being conveyed with this notificaiton.
     */
    public SubscriptionNotificationType getNotificationType() { 
      return this.notificationType == null ? null : this.notificationType.getValue();
    }

    /**
     * @param value The type of event being conveyed with this notificaiton.
     */
    public SubscriptionStatus setNotificationType(SubscriptionNotificationType value) { 
        if (this.notificationType == null)
          this.notificationType = new Enumeration<SubscriptionNotificationType>(new SubscriptionNotificationTypeEnumFactory());
        this.notificationType.setValue(value);
      return this;
    }

    /**
     * @return {@link #eventsSinceSubscriptionStart} (The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.). This is the underlying object with id, value and extensions. The accessor "getEventsSinceSubscriptionStart" gives direct access to the value
     */
    public Integer64Type getEventsSinceSubscriptionStartElement() { 
      if (this.eventsSinceSubscriptionStart == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.eventsSinceSubscriptionStart");
        else if (Configuration.doAutoCreate())
          this.eventsSinceSubscriptionStart = new Integer64Type(); // bb
      return this.eventsSinceSubscriptionStart;
    }

    public boolean hasEventsSinceSubscriptionStartElement() { 
      return this.eventsSinceSubscriptionStart != null && !this.eventsSinceSubscriptionStart.isEmpty();
    }

    public boolean hasEventsSinceSubscriptionStart() { 
      return this.eventsSinceSubscriptionStart != null && !this.eventsSinceSubscriptionStart.isEmpty();
    }

    /**
     * @param value {@link #eventsSinceSubscriptionStart} (The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.). This is the underlying object with id, value and extensions. The accessor "getEventsSinceSubscriptionStart" gives direct access to the value
     */
    public SubscriptionStatus setEventsSinceSubscriptionStartElement(Integer64Type value) { 
      this.eventsSinceSubscriptionStart = value;
      return this;
    }

    /**
     * @return The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.
     */
    public long getEventsSinceSubscriptionStart() { 
      return this.eventsSinceSubscriptionStart == null || this.eventsSinceSubscriptionStart.isEmpty() ? 0 : this.eventsSinceSubscriptionStart.getValue();
    }

    /**
     * @param value The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.
     */
    public SubscriptionStatus setEventsSinceSubscriptionStart(long value) { 
          this.eventsSinceSubscriptionStart = new Integer64Type();
        this.eventsSinceSubscriptionStart.setValue(value);
      return this;
    }

    /**
     * @return {@link #eventsInNotification} (The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.). This is the underlying object with id, value and extensions. The accessor "getEventsInNotification" gives direct access to the value
     */
    public IntegerType getEventsInNotificationElement() { 
      if (this.eventsInNotification == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.eventsInNotification");
        else if (Configuration.doAutoCreate())
          this.eventsInNotification = new IntegerType(); // bb
      return this.eventsInNotification;
    }

    public boolean hasEventsInNotificationElement() { 
      return this.eventsInNotification != null && !this.eventsInNotification.isEmpty();
    }

    public boolean hasEventsInNotification() { 
      return this.eventsInNotification != null && !this.eventsInNotification.isEmpty();
    }

    /**
     * @param value {@link #eventsInNotification} (The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.). This is the underlying object with id, value and extensions. The accessor "getEventsInNotification" gives direct access to the value
     */
    public SubscriptionStatus setEventsInNotificationElement(IntegerType value) { 
      this.eventsInNotification = value;
      return this;
    }

    /**
     * @return The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.
     */
    public int getEventsInNotification() { 
      return this.eventsInNotification == null || this.eventsInNotification.isEmpty() ? 0 : this.eventsInNotification.getValue();
    }

    /**
     * @param value The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.
     */
    public SubscriptionStatus setEventsInNotification(int value) { 
        if (this.eventsInNotification == null)
          this.eventsInNotification = new IntegerType();
        this.eventsInNotification.setValue(value);
      return this;
    }

    /**
     * @return {@link #subscription} (The reference to the Subscription which generated this notification.)
     */
    public Reference getSubscription() { 
      if (this.subscription == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.subscription");
        else if (Configuration.doAutoCreate())
          this.subscription = new Reference(); // cc
      return this.subscription;
    }

    public boolean hasSubscription() { 
      return this.subscription != null && !this.subscription.isEmpty();
    }

    /**
     * @param value {@link #subscription} (The reference to the Subscription which generated this notification.)
     */
    public SubscriptionStatus setSubscription(Reference value) { 
      this.subscription = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of the subscription, which marks the server state for managing the subscription.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<SubscriptionState> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<SubscriptionState>(new SubscriptionStateEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the subscription, which marks the server state for managing the subscription.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public SubscriptionStatus setStatusElement(Enumeration<SubscriptionState> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the subscription, which marks the server state for managing the subscription.
     */
    public SubscriptionState getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the subscription, which marks the server state for managing the subscription.
     */
    public SubscriptionStatus setStatus(SubscriptionState value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<SubscriptionState>(new SubscriptionStateEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #topic} (The reference to the SubscriptionTopic for the Subscription which generated this notification.)
     */
    public Reference getTopic() { 
      if (this.topic == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.topic");
        else if (Configuration.doAutoCreate())
          this.topic = new Reference(); // cc
      return this.topic;
    }

    public boolean hasTopic() { 
      return this.topic != null && !this.topic.isEmpty();
    }

    /**
     * @param value {@link #topic} (The reference to the SubscriptionTopic for the Subscription which generated this notification.)
     */
    public SubscriptionStatus setTopic(Reference value) { 
      this.topic = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("notificationType", "code", "The type of event being conveyed with this notificaiton.", 0, 1, notificationType));
        children.add(new Property("eventsSinceSubscriptionStart", "integer64", "The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.", 0, 1, eventsSinceSubscriptionStart));
        children.add(new Property("eventsInNotification", "integer", "The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.", 0, 1, eventsInNotification));
        children.add(new Property("subscription", "Reference(Subscription)", "The reference to the Subscription which generated this notification.", 0, 1, subscription));
        children.add(new Property("status", "code", "The status of the subscription, which marks the server state for managing the subscription.", 0, 1, status));
        children.add(new Property("topic", "Reference(SubscriptionTopic)", "The reference to the SubscriptionTopic for the Subscription which generated this notification.", 0, 1, topic));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1611538117: /*notificationType*/  return new Property("notificationType", "code", "The type of event being conveyed with this notificaiton.", 0, 1, notificationType);
        case 304566692: /*eventsSinceSubscriptionStart*/  return new Property("eventsSinceSubscriptionStart", "integer64", "The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.", 0, 1, eventsSinceSubscriptionStart);
        case 191408169: /*eventsInNotification*/  return new Property("eventsInNotification", "integer", "The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.", 0, 1, eventsInNotification);
        case 341203229: /*subscription*/  return new Property("subscription", "Reference(Subscription)", "The reference to the Subscription which generated this notification.", 0, 1, subscription);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the subscription, which marks the server state for managing the subscription.", 0, 1, status);
        case 110546223: /*topic*/  return new Property("topic", "Reference(SubscriptionTopic)", "The reference to the SubscriptionTopic for the Subscription which generated this notification.", 0, 1, topic);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1611538117: /*notificationType*/ return this.notificationType == null ? new Base[0] : new Base[] {this.notificationType}; // Enumeration<SubscriptionNotificationType>
        case 304566692: /*eventsSinceSubscriptionStart*/ return this.eventsSinceSubscriptionStart == null ? new Base[0] : new Base[] {this.eventsSinceSubscriptionStart}; // Integer64Type
        case 191408169: /*eventsInNotification*/ return this.eventsInNotification == null ? new Base[0] : new Base[] {this.eventsInNotification}; // IntegerType
        case 341203229: /*subscription*/ return this.subscription == null ? new Base[0] : new Base[] {this.subscription}; // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<SubscriptionState>
        case 110546223: /*topic*/ return this.topic == null ? new Base[0] : new Base[] {this.topic}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1611538117: // notificationType
          value = new SubscriptionNotificationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.notificationType = (Enumeration) value; // Enumeration<SubscriptionNotificationType>
          return value;
        case 304566692: // eventsSinceSubscriptionStart
          this.eventsSinceSubscriptionStart = TypeConvertor.castToInteger64(value); // Integer64Type
          return value;
        case 191408169: // eventsInNotification
          this.eventsInNotification = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case 341203229: // subscription
          this.subscription = TypeConvertor.castToReference(value); // Reference
          return value;
        case -892481550: // status
          value = new SubscriptionStateEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SubscriptionState>
          return value;
        case 110546223: // topic
          this.topic = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("notificationType")) {
          value = new SubscriptionNotificationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.notificationType = (Enumeration) value; // Enumeration<SubscriptionNotificationType>
        } else if (name.equals("eventsSinceSubscriptionStart")) {
          this.eventsSinceSubscriptionStart = TypeConvertor.castToInteger64(value); // Integer64Type
        } else if (name.equals("eventsInNotification")) {
          this.eventsInNotification = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("subscription")) {
          this.subscription = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("status")) {
          value = new SubscriptionStateEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<SubscriptionState>
        } else if (name.equals("topic")) {
          this.topic = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1611538117:  return getNotificationTypeElement();
        case 304566692:  return getEventsSinceSubscriptionStartElement();
        case 191408169:  return getEventsInNotificationElement();
        case 341203229:  return getSubscription();
        case -892481550:  return getStatusElement();
        case 110546223:  return getTopic();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1611538117: /*notificationType*/ return new String[] {"code"};
        case 304566692: /*eventsSinceSubscriptionStart*/ return new String[] {"integer64"};
        case 191408169: /*eventsInNotification*/ return new String[] {"integer"};
        case 341203229: /*subscription*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 110546223: /*topic*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("notificationType")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.notificationType");
        }
        else if (name.equals("eventsSinceSubscriptionStart")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.eventsSinceSubscriptionStart");
        }
        else if (name.equals("eventsInNotification")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.eventsInNotification");
        }
        else if (name.equals("subscription")) {
          this.subscription = new Reference();
          return this.subscription;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.status");
        }
        else if (name.equals("topic")) {
          this.topic = new Reference();
          return this.topic;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "SubscriptionStatus";

  }

      public SubscriptionStatus copy() {
        SubscriptionStatus dst = new SubscriptionStatus();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionStatus dst) {
        super.copyValues(dst);
        dst.notificationType = notificationType == null ? null : notificationType.copy();
        dst.eventsSinceSubscriptionStart = eventsSinceSubscriptionStart == null ? null : eventsSinceSubscriptionStart.copy();
        dst.eventsInNotification = eventsInNotification == null ? null : eventsInNotification.copy();
        dst.subscription = subscription == null ? null : subscription.copy();
        dst.status = status == null ? null : status.copy();
        dst.topic = topic == null ? null : topic.copy();
      }

      protected SubscriptionStatus typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionStatus))
          return false;
        SubscriptionStatus o = (SubscriptionStatus) other_;
        return compareDeep(notificationType, o.notificationType, true) && compareDeep(eventsSinceSubscriptionStart, o.eventsSinceSubscriptionStart, true)
           && compareDeep(eventsInNotification, o.eventsInNotification, true) && compareDeep(subscription, o.subscription, true)
           && compareDeep(status, o.status, true) && compareDeep(topic, o.topic, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionStatus))
          return false;
        SubscriptionStatus o = (SubscriptionStatus) other_;
        return compareValues(notificationType, o.notificationType, true) && compareValues(eventsSinceSubscriptionStart, o.eventsSinceSubscriptionStart, true)
           && compareValues(eventsInNotification, o.eventsInNotification, true) && compareValues(status, o.status, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(notificationType, eventsSinceSubscriptionStart
          , eventsInNotification, subscription, status, topic);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.SubscriptionStatus;
   }


}