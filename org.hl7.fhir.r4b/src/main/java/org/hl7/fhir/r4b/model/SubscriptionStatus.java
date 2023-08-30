package org.hl7.fhir.r4b.model;


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

// Generated on Mon, Jun 13, 2022 17:19+0300 for FHIR v4.3.0

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r4b.model.Enumerations.*;
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
         * The status was generated as part of the setup or verification of a communications channel.
         */
        HANDSHAKE, 
        /**
         * The status was generated to perform a heartbeat notification to the subscriber.
         */
        HEARTBEAT, 
        /**
         * The status was generated for an event to the subscriber.
         */
        EVENTNOTIFICATION, 
        /**
         * The status was generated in response to a status query/request.
         */
        QUERYSTATUS, 
        /**
         * The status was generated in response to an event query/request.
         */
        QUERYEVENT, 
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
        if ("query-status".equals(codeString))
          return QUERYSTATUS;
        if ("query-event".equals(codeString))
          return QUERYEVENT;
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
            case QUERYSTATUS: return "query-status";
            case QUERYEVENT: return "query-event";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case HANDSHAKE: return "http://hl7.org/fhir/subscription-notification-type";
            case HEARTBEAT: return "http://hl7.org/fhir/subscription-notification-type";
            case EVENTNOTIFICATION: return "http://hl7.org/fhir/subscription-notification-type";
            case QUERYSTATUS: return "http://hl7.org/fhir/subscription-notification-type";
            case QUERYEVENT: return "http://hl7.org/fhir/subscription-notification-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case HANDSHAKE: return "The status was generated as part of the setup or verification of a communications channel.";
            case HEARTBEAT: return "The status was generated to perform a heartbeat notification to the subscriber.";
            case EVENTNOTIFICATION: return "The status was generated for an event to the subscriber.";
            case QUERYSTATUS: return "The status was generated in response to a status query/request.";
            case QUERYEVENT: return "The status was generated in response to an event query/request.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case HANDSHAKE: return "Handshake";
            case HEARTBEAT: return "Heartbeat";
            case EVENTNOTIFICATION: return "Event Notification";
            case QUERYSTATUS: return "Query Status";
            case QUERYEVENT: return "Query Event";
            case NULL: return null;
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
        if ("query-status".equals(codeString))
          return SubscriptionNotificationType.QUERYSTATUS;
        if ("query-event".equals(codeString))
          return SubscriptionNotificationType.QUERYEVENT;
        throw new IllegalArgumentException("Unknown SubscriptionNotificationType code '"+codeString+"'");
        }
        public Enumeration<SubscriptionNotificationType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.NULL, code);
          String codeString = code.asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.NULL, code);
        if ("handshake".equals(codeString))
          return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.HANDSHAKE, code);
        if ("heartbeat".equals(codeString))
          return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.HEARTBEAT, code);
        if ("event-notification".equals(codeString))
          return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.EVENTNOTIFICATION, code);
        if ("query-status".equals(codeString))
          return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.QUERYSTATUS, code);
        if ("query-event".equals(codeString))
          return new Enumeration<SubscriptionNotificationType>(this, SubscriptionNotificationType.QUERYEVENT, code);
        throw new FHIRException("Unknown SubscriptionNotificationType code '"+codeString+"'");
        }
    public String toCode(SubscriptionNotificationType code) {
      if (code == SubscriptionNotificationType.HANDSHAKE)
        return "handshake";
      if (code == SubscriptionNotificationType.HEARTBEAT)
        return "heartbeat";
      if (code == SubscriptionNotificationType.EVENTNOTIFICATION)
        return "event-notification";
      if (code == SubscriptionNotificationType.QUERYSTATUS)
        return "query-status";
      if (code == SubscriptionNotificationType.QUERYEVENT)
        return "query-event";
      return "?";
      }
    public String toSystem(SubscriptionNotificationType code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class SubscriptionStatusNotificationEventComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The sequential number of this event in this subscription context. Note that this value is a 64-bit integer value, encoded as a string.
         */
        @Child(name = "eventNumber", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Event number", formalDefinition="The sequential number of this event in this subscription context. Note that this value is a 64-bit integer value, encoded as a string." )
        protected StringType eventNumber;

        /**
         * The actual time this event occured on the server.
         */
        @Child(name = "timestamp", type = {InstantType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The instant this event occurred", formalDefinition="The actual time this event occured on the server." )
        protected InstantType timestamp;

        /**
         * The focus of this event. While this will usually be a reference to the focus resource of the event, it MAY contain a reference to a non-FHIR object.
         */
        @Child(name = "focus", type = {Reference.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The focus of this event", formalDefinition="The focus of this event. While this will usually be a reference to the focus resource of the event, it MAY contain a reference to a non-FHIR object." )
        protected Reference focus;

        /**
         * Additional context information for this event. Generally, this will contain references to additional resources included with the event (e.g., the Patient relevant to an Encounter), however it MAY refer to non-FHIR objects.
         */
        @Child(name = "additionalContext", type = {Reference.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Additional context for this event", formalDefinition="Additional context information for this event. Generally, this will contain references to additional resources included with the event (e.g., the Patient relevant to an Encounter), however it MAY refer to non-FHIR objects." )
        protected List<Reference> additionalContext;

        private static final long serialVersionUID = -1582756503L;

    /**
     * Constructor
     */
      public SubscriptionStatusNotificationEventComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubscriptionStatusNotificationEventComponent(String eventNumber) {
        super();
        this.setEventNumber(eventNumber);
      }

        /**
         * @return {@link #eventNumber} (The sequential number of this event in this subscription context. Note that this value is a 64-bit integer value, encoded as a string.). This is the underlying object with id, value and extensions. The accessor "getEventNumber" gives direct access to the value
         */
        public StringType getEventNumberElement() { 
          if (this.eventNumber == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionStatusNotificationEventComponent.eventNumber");
            else if (Configuration.doAutoCreate())
              this.eventNumber = new StringType(); // bb
          return this.eventNumber;
        }

        public boolean hasEventNumberElement() { 
          return this.eventNumber != null && !this.eventNumber.isEmpty();
        }

        public boolean hasEventNumber() { 
          return this.eventNumber != null && !this.eventNumber.isEmpty();
        }

        /**
         * @param value {@link #eventNumber} (The sequential number of this event in this subscription context. Note that this value is a 64-bit integer value, encoded as a string.). This is the underlying object with id, value and extensions. The accessor "getEventNumber" gives direct access to the value
         */
        public SubscriptionStatusNotificationEventComponent setEventNumberElement(StringType value) { 
          this.eventNumber = value;
          return this;
        }

        /**
         * @return The sequential number of this event in this subscription context. Note that this value is a 64-bit integer value, encoded as a string.
         */
        public String getEventNumber() { 
          return this.eventNumber == null ? null : this.eventNumber.getValue();
        }

        /**
         * @param value The sequential number of this event in this subscription context. Note that this value is a 64-bit integer value, encoded as a string.
         */
        public SubscriptionStatusNotificationEventComponent setEventNumber(String value) { 
            if (this.eventNumber == null)
              this.eventNumber = new StringType();
            this.eventNumber.setValue(value);
          return this;
        }

        /**
         * @return {@link #timestamp} (The actual time this event occured on the server.). This is the underlying object with id, value and extensions. The accessor "getTimestamp" gives direct access to the value
         */
        public InstantType getTimestampElement() { 
          if (this.timestamp == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionStatusNotificationEventComponent.timestamp");
            else if (Configuration.doAutoCreate())
              this.timestamp = new InstantType(); // bb
          return this.timestamp;
        }

        public boolean hasTimestampElement() { 
          return this.timestamp != null && !this.timestamp.isEmpty();
        }

        public boolean hasTimestamp() { 
          return this.timestamp != null && !this.timestamp.isEmpty();
        }

        /**
         * @param value {@link #timestamp} (The actual time this event occured on the server.). This is the underlying object with id, value and extensions. The accessor "getTimestamp" gives direct access to the value
         */
        public SubscriptionStatusNotificationEventComponent setTimestampElement(InstantType value) { 
          this.timestamp = value;
          return this;
        }

        /**
         * @return The actual time this event occured on the server.
         */
        public Date getTimestamp() { 
          return this.timestamp == null ? null : this.timestamp.getValue();
        }

        /**
         * @param value The actual time this event occured on the server.
         */
        public SubscriptionStatusNotificationEventComponent setTimestamp(Date value) { 
          if (value == null)
            this.timestamp = null;
          else {
            if (this.timestamp == null)
              this.timestamp = new InstantType();
            this.timestamp.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #focus} (The focus of this event. While this will usually be a reference to the focus resource of the event, it MAY contain a reference to a non-FHIR object.)
         */
        public Reference getFocus() { 
          if (this.focus == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubscriptionStatusNotificationEventComponent.focus");
            else if (Configuration.doAutoCreate())
              this.focus = new Reference(); // cc
          return this.focus;
        }

        public boolean hasFocus() { 
          return this.focus != null && !this.focus.isEmpty();
        }

        /**
         * @param value {@link #focus} (The focus of this event. While this will usually be a reference to the focus resource of the event, it MAY contain a reference to a non-FHIR object.)
         */
        public SubscriptionStatusNotificationEventComponent setFocus(Reference value) { 
          this.focus = value;
          return this;
        }

        /**
         * @return {@link #additionalContext} (Additional context information for this event. Generally, this will contain references to additional resources included with the event (e.g., the Patient relevant to an Encounter), however it MAY refer to non-FHIR objects.)
         */
        public List<Reference> getAdditionalContext() { 
          if (this.additionalContext == null)
            this.additionalContext = new ArrayList<Reference>();
          return this.additionalContext;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubscriptionStatusNotificationEventComponent setAdditionalContext(List<Reference> theAdditionalContext) { 
          this.additionalContext = theAdditionalContext;
          return this;
        }

        public boolean hasAdditionalContext() { 
          if (this.additionalContext == null)
            return false;
          for (Reference item : this.additionalContext)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addAdditionalContext() { //3
          Reference t = new Reference();
          if (this.additionalContext == null)
            this.additionalContext = new ArrayList<Reference>();
          this.additionalContext.add(t);
          return t;
        }

        public SubscriptionStatusNotificationEventComponent addAdditionalContext(Reference t) { //3
          if (t == null)
            return this;
          if (this.additionalContext == null)
            this.additionalContext = new ArrayList<Reference>();
          this.additionalContext.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #additionalContext}, creating it if it does not already exist {3}
         */
        public Reference getAdditionalContextFirstRep() { 
          if (getAdditionalContext().isEmpty()) {
            addAdditionalContext();
          }
          return getAdditionalContext().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("eventNumber", "string", "The sequential number of this event in this subscription context. Note that this value is a 64-bit integer value, encoded as a string.", 0, 1, eventNumber));
          children.add(new Property("timestamp", "instant", "The actual time this event occured on the server.", 0, 1, timestamp));
          children.add(new Property("focus", "Reference(Any)", "The focus of this event. While this will usually be a reference to the focus resource of the event, it MAY contain a reference to a non-FHIR object.", 0, 1, focus));
          children.add(new Property("additionalContext", "Reference(Any)", "Additional context information for this event. Generally, this will contain references to additional resources included with the event (e.g., the Patient relevant to an Encounter), however it MAY refer to non-FHIR objects.", 0, java.lang.Integer.MAX_VALUE, additionalContext));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -35234173: /*eventNumber*/  return new Property("eventNumber", "string", "The sequential number of this event in this subscription context. Note that this value is a 64-bit integer value, encoded as a string.", 0, 1, eventNumber);
          case 55126294: /*timestamp*/  return new Property("timestamp", "instant", "The actual time this event occured on the server.", 0, 1, timestamp);
          case 97604824: /*focus*/  return new Property("focus", "Reference(Any)", "The focus of this event. While this will usually be a reference to the focus resource of the event, it MAY contain a reference to a non-FHIR object.", 0, 1, focus);
          case -908743800: /*additionalContext*/  return new Property("additionalContext", "Reference(Any)", "Additional context information for this event. Generally, this will contain references to additional resources included with the event (e.g., the Patient relevant to an Encounter), however it MAY refer to non-FHIR objects.", 0, java.lang.Integer.MAX_VALUE, additionalContext);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -35234173: /*eventNumber*/ return this.eventNumber == null ? new Base[0] : new Base[] {this.eventNumber}; // StringType
        case 55126294: /*timestamp*/ return this.timestamp == null ? new Base[0] : new Base[] {this.timestamp}; // InstantType
        case 97604824: /*focus*/ return this.focus == null ? new Base[0] : new Base[] {this.focus}; // Reference
        case -908743800: /*additionalContext*/ return this.additionalContext == null ? new Base[0] : this.additionalContext.toArray(new Base[this.additionalContext.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -35234173: // eventNumber
          this.eventNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case 55126294: // timestamp
          this.timestamp = TypeConvertor.castToInstant(value); // InstantType
          return value;
        case 97604824: // focus
          this.focus = TypeConvertor.castToReference(value); // Reference
          return value;
        case -908743800: // additionalContext
          this.getAdditionalContext().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("eventNumber")) {
          this.eventNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("timestamp")) {
          this.timestamp = TypeConvertor.castToInstant(value); // InstantType
        } else if (name.equals("focus")) {
          this.focus = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("additionalContext")) {
          this.getAdditionalContext().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -35234173:  return getEventNumberElement();
        case 55126294:  return getTimestampElement();
        case 97604824:  return getFocus();
        case -908743800:  return addAdditionalContext(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -35234173: /*eventNumber*/ return new String[] {"string"};
        case 55126294: /*timestamp*/ return new String[] {"instant"};
        case 97604824: /*focus*/ return new String[] {"Reference"};
        case -908743800: /*additionalContext*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("eventNumber")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.notificationEvent.eventNumber");
        }
        else if (name.equals("timestamp")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.notificationEvent.timestamp");
        }
        else if (name.equals("focus")) {
          this.focus = new Reference();
          return this.focus;
        }
        else if (name.equals("additionalContext")) {
          return addAdditionalContext();
        }
        else
          return super.addChild(name);
      }

      public SubscriptionStatusNotificationEventComponent copy() {
        SubscriptionStatusNotificationEventComponent dst = new SubscriptionStatusNotificationEventComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubscriptionStatusNotificationEventComponent dst) {
        super.copyValues(dst);
        dst.eventNumber = eventNumber == null ? null : eventNumber.copy();
        dst.timestamp = timestamp == null ? null : timestamp.copy();
        dst.focus = focus == null ? null : focus.copy();
        if (additionalContext != null) {
          dst.additionalContext = new ArrayList<Reference>();
          for (Reference i : additionalContext)
            dst.additionalContext.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubscriptionStatusNotificationEventComponent))
          return false;
        SubscriptionStatusNotificationEventComponent o = (SubscriptionStatusNotificationEventComponent) other_;
        return compareDeep(eventNumber, o.eventNumber, true) && compareDeep(timestamp, o.timestamp, true)
           && compareDeep(focus, o.focus, true) && compareDeep(additionalContext, o.additionalContext, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionStatusNotificationEventComponent))
          return false;
        SubscriptionStatusNotificationEventComponent o = (SubscriptionStatusNotificationEventComponent) other_;
        return compareValues(eventNumber, o.eventNumber, true) && compareValues(timestamp, o.timestamp, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(eventNumber, timestamp, focus
          , additionalContext);
      }

  public String fhirType() {
    return "SubscriptionStatus.notificationEvent";

  }

  }

    /**
     * The status of the subscription, which marks the server state for managing the subscription.
     */
    @Child(name = "status", type = {CodeType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="requested | active | error | off | entered-in-error", formalDefinition="The status of the subscription, which marks the server state for managing the subscription." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-status")
    protected Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus> status;

    /**
     * The type of event being conveyed with this notificaiton.
     */
    @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="handshake | heartbeat | event-notification | query-status | query-event", formalDefinition="The type of event being conveyed with this notificaiton." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-notification-type")
    protected Enumeration<SubscriptionNotificationType> type;

    /**
     * The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.
     */
    @Child(name = "eventsSinceSubscriptionStart", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Events since the Subscription was created", formalDefinition="The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications." )
    protected StringType eventsSinceSubscriptionStart;

    /**
     * The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.
     */
    @Child(name = "eventsInNotification", type = {IntegerType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The number of actual notifications represented by this bundle", formalDefinition="The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching." )
    protected IntegerType eventsInNotification;

    /**
     * Detailed information about events relevant to this subscription notification.
     */
    @Child(name = "notificationEvent", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Detailed information about any events relevant to this notification", formalDefinition="Detailed information about events relevant to this subscription notification." )
    protected List<SubscriptionStatusNotificationEventComponent> notificationEvent;

    /**
     * The reference to the Subscription which generated this notification.
     */
    @Child(name = "subscription", type = {Subscription.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to the Subscription responsible for this notification", formalDefinition="The reference to the Subscription which generated this notification." )
    protected Reference subscription;

    /**
     * The reference to the SubscriptionTopic for the Subscription which generated this notification.
     */
    @Child(name = "topic", type = {CanonicalType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Reference to the SubscriptionTopic this notification relates to", formalDefinition="The reference to the SubscriptionTopic for the Subscription which generated this notification." )
    protected CanonicalType topic;

    /**
     * A record of errors that occurred when the server processed a notification.
     */
    @Child(name = "error", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="List of errors on the subscription", formalDefinition="A record of errors that occurred when the server processed a notification." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/subscription-error")
    protected List<CodeableConcept> error;

    private static final long serialVersionUID = 509923202L;

  /**
   * Constructor
   */
    public SubscriptionStatus() {
      super();
    }

  /**
   * Constructor
   */
    public SubscriptionStatus(SubscriptionNotificationType type, Reference subscription) {
      super();
      this.setType(type);
      this.setSubscription(subscription);
    }

    /**
     * @return {@link #status} (The status of the subscription, which marks the server state for managing the subscription.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus>(new org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatusEnumFactory()); // bb
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
    public SubscriptionStatus setStatusElement(Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the subscription, which marks the server state for managing the subscription.
     */
    public org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the subscription, which marks the server state for managing the subscription.
     */
    public SubscriptionStatus setStatus(org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus>(new org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #type} (The type of event being conveyed with this notificaiton.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public Enumeration<SubscriptionNotificationType> getTypeElement() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.type");
        else if (Configuration.doAutoCreate())
          this.type = new Enumeration<SubscriptionNotificationType>(new SubscriptionNotificationTypeEnumFactory()); // bb
      return this.type;
    }

    public boolean hasTypeElement() { 
      return this.type != null && !this.type.isEmpty();
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (The type of event being conveyed with this notificaiton.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
     */
    public SubscriptionStatus setTypeElement(Enumeration<SubscriptionNotificationType> value) { 
      this.type = value;
      return this;
    }

    /**
     * @return The type of event being conveyed with this notificaiton.
     */
    public SubscriptionNotificationType getType() { 
      return this.type == null ? null : this.type.getValue();
    }

    /**
     * @param value The type of event being conveyed with this notificaiton.
     */
    public SubscriptionStatus setType(SubscriptionNotificationType value) { 
        if (this.type == null)
          this.type = new Enumeration<SubscriptionNotificationType>(new SubscriptionNotificationTypeEnumFactory());
        this.type.setValue(value);
      return this;
    }

    /**
     * @return {@link #eventsSinceSubscriptionStart} (The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.). This is the underlying object with id, value and extensions. The accessor "getEventsSinceSubscriptionStart" gives direct access to the value
     */
    public StringType getEventsSinceSubscriptionStartElement() { 
      if (this.eventsSinceSubscriptionStart == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.eventsSinceSubscriptionStart");
        else if (Configuration.doAutoCreate())
          this.eventsSinceSubscriptionStart = new StringType(); // bb
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
    public SubscriptionStatus setEventsSinceSubscriptionStartElement(StringType value) { 
      this.eventsSinceSubscriptionStart = value;
      return this;
    }

    /**
     * @return The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.
     */
    public String getEventsSinceSubscriptionStart() { 
      return this.eventsSinceSubscriptionStart == null ? null : this.eventsSinceSubscriptionStart.getValue();
    }

    /**
     * @param value The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.
     */
    public SubscriptionStatus setEventsSinceSubscriptionStart(String value) { 
      if (Utilities.noString(value))
        this.eventsSinceSubscriptionStart = null;
      else {
        if (this.eventsSinceSubscriptionStart == null)
          this.eventsSinceSubscriptionStart = new StringType();
        this.eventsSinceSubscriptionStart.setValue(value);
      }
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
     * @return {@link #notificationEvent} (Detailed information about events relevant to this subscription notification.)
     */
    public List<SubscriptionStatusNotificationEventComponent> getNotificationEvent() { 
      if (this.notificationEvent == null)
        this.notificationEvent = new ArrayList<SubscriptionStatusNotificationEventComponent>();
      return this.notificationEvent;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionStatus setNotificationEvent(List<SubscriptionStatusNotificationEventComponent> theNotificationEvent) { 
      this.notificationEvent = theNotificationEvent;
      return this;
    }

    public boolean hasNotificationEvent() { 
      if (this.notificationEvent == null)
        return false;
      for (SubscriptionStatusNotificationEventComponent item : this.notificationEvent)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubscriptionStatusNotificationEventComponent addNotificationEvent() { //3
      SubscriptionStatusNotificationEventComponent t = new SubscriptionStatusNotificationEventComponent();
      if (this.notificationEvent == null)
        this.notificationEvent = new ArrayList<SubscriptionStatusNotificationEventComponent>();
      this.notificationEvent.add(t);
      return t;
    }

    public SubscriptionStatus addNotificationEvent(SubscriptionStatusNotificationEventComponent t) { //3
      if (t == null)
        return this;
      if (this.notificationEvent == null)
        this.notificationEvent = new ArrayList<SubscriptionStatusNotificationEventComponent>();
      this.notificationEvent.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #notificationEvent}, creating it if it does not already exist {3}
     */
    public SubscriptionStatusNotificationEventComponent getNotificationEventFirstRep() { 
      if (getNotificationEvent().isEmpty()) {
        addNotificationEvent();
      }
      return getNotificationEvent().get(0);
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
     * @return {@link #topic} (The reference to the SubscriptionTopic for the Subscription which generated this notification.). This is the underlying object with id, value and extensions. The accessor "getTopic" gives direct access to the value
     */
    public CanonicalType getTopicElement() { 
      if (this.topic == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubscriptionStatus.topic");
        else if (Configuration.doAutoCreate())
          this.topic = new CanonicalType(); // bb
      return this.topic;
    }

    public boolean hasTopicElement() { 
      return this.topic != null && !this.topic.isEmpty();
    }

    public boolean hasTopic() { 
      return this.topic != null && !this.topic.isEmpty();
    }

    /**
     * @param value {@link #topic} (The reference to the SubscriptionTopic for the Subscription which generated this notification.). This is the underlying object with id, value and extensions. The accessor "getTopic" gives direct access to the value
     */
    public SubscriptionStatus setTopicElement(CanonicalType value) { 
      this.topic = value;
      return this;
    }

    /**
     * @return The reference to the SubscriptionTopic for the Subscription which generated this notification.
     */
    public String getTopic() { 
      return this.topic == null ? null : this.topic.getValue();
    }

    /**
     * @param value The reference to the SubscriptionTopic for the Subscription which generated this notification.
     */
    public SubscriptionStatus setTopic(String value) { 
      if (Utilities.noString(value))
        this.topic = null;
      else {
        if (this.topic == null)
          this.topic = new CanonicalType();
        this.topic.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #error} (A record of errors that occurred when the server processed a notification.)
     */
    public List<CodeableConcept> getError() { 
      if (this.error == null)
        this.error = new ArrayList<CodeableConcept>();
      return this.error;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubscriptionStatus setError(List<CodeableConcept> theError) { 
      this.error = theError;
      return this;
    }

    public boolean hasError() { 
      if (this.error == null)
        return false;
      for (CodeableConcept item : this.error)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addError() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.error == null)
        this.error = new ArrayList<CodeableConcept>();
      this.error.add(t);
      return t;
    }

    public SubscriptionStatus addError(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.error == null)
        this.error = new ArrayList<CodeableConcept>();
      this.error.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #error}, creating it if it does not already exist {3}
     */
    public CodeableConcept getErrorFirstRep() { 
      if (getError().isEmpty()) {
        addError();
      }
      return getError().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("status", "code", "The status of the subscription, which marks the server state for managing the subscription.", 0, 1, status));
        children.add(new Property("type", "code", "The type of event being conveyed with this notificaiton.", 0, 1, type));
        children.add(new Property("eventsSinceSubscriptionStart", "string", "The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.", 0, 1, eventsSinceSubscriptionStart));
        children.add(new Property("eventsInNotification", "integer", "The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.", 0, 1, eventsInNotification));
        children.add(new Property("notificationEvent", "", "Detailed information about events relevant to this subscription notification.", 0, java.lang.Integer.MAX_VALUE, notificationEvent));
        children.add(new Property("subscription", "Reference(Subscription)", "The reference to the Subscription which generated this notification.", 0, 1, subscription));
        children.add(new Property("topic", "canonical(SubscriptionTopic)", "The reference to the SubscriptionTopic for the Subscription which generated this notification.", 0, 1, topic));
        children.add(new Property("error", "CodeableConcept", "A record of errors that occurred when the server processed a notification.", 0, java.lang.Integer.MAX_VALUE, error));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -892481550: /*status*/  return new Property("status", "code", "The status of the subscription, which marks the server state for managing the subscription.", 0, 1, status);
        case 3575610: /*type*/  return new Property("type", "code", "The type of event being conveyed with this notificaiton.", 0, 1, type);
        case 304566692: /*eventsSinceSubscriptionStart*/  return new Property("eventsSinceSubscriptionStart", "string", "The total number of actual events which have been generated since the Subscription was created (inclusive of this notification) - regardless of how many have been successfully communicated.  This number is NOT incremented for handshake and heartbeat notifications.", 0, 1, eventsSinceSubscriptionStart);
        case 191408169: /*eventsInNotification*/  return new Property("eventsInNotification", "integer", "The total number of actual events represented within this notification.  For handshake and heartbeat notifications, this will be zero or not present.  For event-notifications, this number may be one or more, depending on server batching.", 0, 1, eventsInNotification);
        case -1595878289: /*notificationEvent*/  return new Property("notificationEvent", "", "Detailed information about events relevant to this subscription notification.", 0, java.lang.Integer.MAX_VALUE, notificationEvent);
        case 341203229: /*subscription*/  return new Property("subscription", "Reference(Subscription)", "The reference to the Subscription which generated this notification.", 0, 1, subscription);
        case 110546223: /*topic*/  return new Property("topic", "canonical(SubscriptionTopic)", "The reference to the SubscriptionTopic for the Subscription which generated this notification.", 0, 1, topic);
        case 96784904: /*error*/  return new Property("error", "CodeableConcept", "A record of errors that occurred when the server processed a notification.", 0, java.lang.Integer.MAX_VALUE, error);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus>
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<SubscriptionNotificationType>
        case 304566692: /*eventsSinceSubscriptionStart*/ return this.eventsSinceSubscriptionStart == null ? new Base[0] : new Base[] {this.eventsSinceSubscriptionStart}; // StringType
        case 191408169: /*eventsInNotification*/ return this.eventsInNotification == null ? new Base[0] : new Base[] {this.eventsInNotification}; // IntegerType
        case -1595878289: /*notificationEvent*/ return this.notificationEvent == null ? new Base[0] : this.notificationEvent.toArray(new Base[this.notificationEvent.size()]); // SubscriptionStatusNotificationEventComponent
        case 341203229: /*subscription*/ return this.subscription == null ? new Base[0] : new Base[] {this.subscription}; // Reference
        case 110546223: /*topic*/ return this.topic == null ? new Base[0] : new Base[] {this.topic}; // CanonicalType
        case 96784904: /*error*/ return this.error == null ? new Base[0] : this.error.toArray(new Base[this.error.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -892481550: // status
          value = new org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus>
          return value;
        case 3575610: // type
          value = new SubscriptionNotificationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SubscriptionNotificationType>
          return value;
        case 304566692: // eventsSinceSubscriptionStart
          this.eventsSinceSubscriptionStart = TypeConvertor.castToString(value); // StringType
          return value;
        case 191408169: // eventsInNotification
          this.eventsInNotification = TypeConvertor.castToInteger(value); // IntegerType
          return value;
        case -1595878289: // notificationEvent
          this.getNotificationEvent().add((SubscriptionStatusNotificationEventComponent) value); // SubscriptionStatusNotificationEventComponent
          return value;
        case 341203229: // subscription
          this.subscription = TypeConvertor.castToReference(value); // Reference
          return value;
        case 110546223: // topic
          this.topic = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 96784904: // error
          this.getError().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("status")) {
          value = new org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<org.hl7.fhir.r4b.model.Enumerations.SubscriptionStatus>
        } else if (name.equals("type")) {
          value = new SubscriptionNotificationTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<SubscriptionNotificationType>
        } else if (name.equals("eventsSinceSubscriptionStart")) {
          this.eventsSinceSubscriptionStart = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("eventsInNotification")) {
          this.eventsInNotification = TypeConvertor.castToInteger(value); // IntegerType
        } else if (name.equals("notificationEvent")) {
          this.getNotificationEvent().add((SubscriptionStatusNotificationEventComponent) value);
        } else if (name.equals("subscription")) {
          this.subscription = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("topic")) {
          this.topic = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("error")) {
          this.getError().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550:  return getStatusElement();
        case 3575610:  return getTypeElement();
        case 304566692:  return getEventsSinceSubscriptionStartElement();
        case 191408169:  return getEventsInNotificationElement();
        case -1595878289:  return addNotificationEvent(); 
        case 341203229:  return getSubscription();
        case 110546223:  return getTopicElement();
        case 96784904:  return addError(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return new String[] {"code"};
        case 3575610: /*type*/ return new String[] {"code"};
        case 304566692: /*eventsSinceSubscriptionStart*/ return new String[] {"string"};
        case 191408169: /*eventsInNotification*/ return new String[] {"integer"};
        case -1595878289: /*notificationEvent*/ return new String[] {};
        case 341203229: /*subscription*/ return new String[] {"Reference"};
        case 110546223: /*topic*/ return new String[] {"canonical"};
        case 96784904: /*error*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.status");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.type");
        }
        else if (name.equals("eventsSinceSubscriptionStart")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.eventsSinceSubscriptionStart");
        }
        else if (name.equals("eventsInNotification")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.eventsInNotification");
        }
        else if (name.equals("notificationEvent")) {
          return addNotificationEvent();
        }
        else if (name.equals("subscription")) {
          this.subscription = new Reference();
          return this.subscription;
        }
        else if (name.equals("topic")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubscriptionStatus.topic");
        }
        else if (name.equals("error")) {
          return addError();
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
        dst.status = status == null ? null : status.copy();
        dst.type = type == null ? null : type.copy();
        dst.eventsSinceSubscriptionStart = eventsSinceSubscriptionStart == null ? null : eventsSinceSubscriptionStart.copy();
        dst.eventsInNotification = eventsInNotification == null ? null : eventsInNotification.copy();
        if (notificationEvent != null) {
          dst.notificationEvent = new ArrayList<SubscriptionStatusNotificationEventComponent>();
          for (SubscriptionStatusNotificationEventComponent i : notificationEvent)
            dst.notificationEvent.add(i.copy());
        };
        dst.subscription = subscription == null ? null : subscription.copy();
        dst.topic = topic == null ? null : topic.copy();
        if (error != null) {
          dst.error = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : error)
            dst.error.add(i.copy());
        };
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
        return compareDeep(status, o.status, true) && compareDeep(type, o.type, true) && compareDeep(eventsSinceSubscriptionStart, o.eventsSinceSubscriptionStart, true)
           && compareDeep(eventsInNotification, o.eventsInNotification, true) && compareDeep(notificationEvent, o.notificationEvent, true)
           && compareDeep(subscription, o.subscription, true) && compareDeep(topic, o.topic, true) && compareDeep(error, o.error, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubscriptionStatus))
          return false;
        SubscriptionStatus o = (SubscriptionStatus) other_;
        return compareValues(status, o.status, true) && compareValues(type, o.type, true) && compareValues(eventsSinceSubscriptionStart, o.eventsSinceSubscriptionStart, true)
           && compareValues(eventsInNotification, o.eventsInNotification, true) && compareValues(topic, o.topic, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(status, type, eventsSinceSubscriptionStart
          , eventsInNotification, notificationEvent, subscription, topic, error);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.SubscriptionStatus;
   }


}
