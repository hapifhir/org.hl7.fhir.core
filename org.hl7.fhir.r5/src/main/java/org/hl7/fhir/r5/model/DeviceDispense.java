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

// Generated on Thu, Mar 23, 2023 19:59+1100 for FHIR v5.0.0

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
 * Indicates that a device is to be or has been dispensed for a named person/patient.  This includes a description of the product (supply) provided and the instructions for using the device.
 */
@ResourceDef(name="DeviceDispense", profile="http://hl7.org/fhir/StructureDefinition/DeviceDispense")
public class DeviceDispense extends DomainResource {

    public enum DeviceDispenseStatusCodes {
        /**
         * The core event has not started yet, but some staging activities have begun (e.g. initial preparing of the device. Preparation stages may be tracked e.g. for planning, supply or billing purposes.
         */
        PREPARATION, 
        /**
         * The dispensed product is ready for pickup.
         */
        INPROGRESS, 
        /**
         * The dispensed product was not and will never be picked up by the patient.
         */
        CANCELLED, 
        /**
         * The dispense process is paused while waiting for an external event to reactivate the dispense.  For example, new stock has arrived or the prescriber has called.
         */
        ONHOLD, 
        /**
         * The dispensed product has been picked up.
         */
        COMPLETED, 
        /**
         * The dispense was entered in error and therefore nullified.
         */
        ENTEREDINERROR, 
        /**
         * Actions implied by the dispense have been permanently halted, before all of them occurred.
         */
        STOPPED, 
        /**
         * The dispense was declined and not performed.
         */
        DECLINED, 
        /**
         * The authoring system does not know which of the status values applies for this dispense.  Note: this concept is not to be used for other - one of the listed statuses is presumed to apply, it's just now known which one.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DeviceDispenseStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return PREPARATION;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("stopped".equals(codeString))
          return STOPPED;
        if ("declined".equals(codeString))
          return DECLINED;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DeviceDispenseStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PREPARATION: return "preparation";
            case INPROGRESS: return "in-progress";
            case CANCELLED: return "cancelled";
            case ONHOLD: return "on-hold";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case STOPPED: return "stopped";
            case DECLINED: return "declined";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PREPARATION: return "http://hl7.org/fhir/devicedispense-status";
            case INPROGRESS: return "http://hl7.org/fhir/devicedispense-status";
            case CANCELLED: return "http://hl7.org/fhir/devicedispense-status";
            case ONHOLD: return "http://hl7.org/fhir/devicedispense-status";
            case COMPLETED: return "http://hl7.org/fhir/devicedispense-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/devicedispense-status";
            case STOPPED: return "http://hl7.org/fhir/devicedispense-status";
            case DECLINED: return "http://hl7.org/fhir/devicedispense-status";
            case UNKNOWN: return "http://hl7.org/fhir/devicedispense-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PREPARATION: return "The core event has not started yet, but some staging activities have begun (e.g. initial preparing of the device. Preparation stages may be tracked e.g. for planning, supply or billing purposes.";
            case INPROGRESS: return "The dispensed product is ready for pickup.";
            case CANCELLED: return "The dispensed product was not and will never be picked up by the patient.";
            case ONHOLD: return "The dispense process is paused while waiting for an external event to reactivate the dispense.  For example, new stock has arrived or the prescriber has called.";
            case COMPLETED: return "The dispensed product has been picked up.";
            case ENTEREDINERROR: return "The dispense was entered in error and therefore nullified.";
            case STOPPED: return "Actions implied by the dispense have been permanently halted, before all of them occurred.";
            case DECLINED: return "The dispense was declined and not performed.";
            case UNKNOWN: return "The authoring system does not know which of the status values applies for this dispense.  Note: this concept is not to be used for other - one of the listed statuses is presumed to apply, it's just now known which one.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PREPARATION: return "Preparation";
            case INPROGRESS: return "In Progress";
            case CANCELLED: return "Cancelled";
            case ONHOLD: return "On Hold";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case STOPPED: return "Stopped";
            case DECLINED: return "Declined";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DeviceDispenseStatusCodesEnumFactory implements EnumFactory<DeviceDispenseStatusCodes> {
    public DeviceDispenseStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return DeviceDispenseStatusCodes.PREPARATION;
        if ("in-progress".equals(codeString))
          return DeviceDispenseStatusCodes.INPROGRESS;
        if ("cancelled".equals(codeString))
          return DeviceDispenseStatusCodes.CANCELLED;
        if ("on-hold".equals(codeString))
          return DeviceDispenseStatusCodes.ONHOLD;
        if ("completed".equals(codeString))
          return DeviceDispenseStatusCodes.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return DeviceDispenseStatusCodes.ENTEREDINERROR;
        if ("stopped".equals(codeString))
          return DeviceDispenseStatusCodes.STOPPED;
        if ("declined".equals(codeString))
          return DeviceDispenseStatusCodes.DECLINED;
        if ("unknown".equals(codeString))
          return DeviceDispenseStatusCodes.UNKNOWN;
        throw new IllegalArgumentException("Unknown DeviceDispenseStatusCodes code '"+codeString+"'");
        }
        public Enumeration<DeviceDispenseStatusCodes> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.NULL, code);
        if ("preparation".equals(codeString))
          return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.PREPARATION, code);
        if ("in-progress".equals(codeString))
          return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.INPROGRESS, code);
        if ("cancelled".equals(codeString))
          return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.CANCELLED, code);
        if ("on-hold".equals(codeString))
          return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.ONHOLD, code);
        if ("completed".equals(codeString))
          return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.COMPLETED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.ENTEREDINERROR, code);
        if ("stopped".equals(codeString))
          return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.STOPPED, code);
        if ("declined".equals(codeString))
          return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.DECLINED, code);
        if ("unknown".equals(codeString))
          return new Enumeration<DeviceDispenseStatusCodes>(this, DeviceDispenseStatusCodes.UNKNOWN, code);
        throw new FHIRException("Unknown DeviceDispenseStatusCodes code '"+codeString+"'");
        }
    public String toCode(DeviceDispenseStatusCodes code) {
      if (code == DeviceDispenseStatusCodes.PREPARATION)
        return "preparation";
      if (code == DeviceDispenseStatusCodes.INPROGRESS)
        return "in-progress";
      if (code == DeviceDispenseStatusCodes.CANCELLED)
        return "cancelled";
      if (code == DeviceDispenseStatusCodes.ONHOLD)
        return "on-hold";
      if (code == DeviceDispenseStatusCodes.COMPLETED)
        return "completed";
      if (code == DeviceDispenseStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      if (code == DeviceDispenseStatusCodes.STOPPED)
        return "stopped";
      if (code == DeviceDispenseStatusCodes.DECLINED)
        return "declined";
      if (code == DeviceDispenseStatusCodes.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(DeviceDispenseStatusCodes code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class DeviceDispensePerformerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who performed the dispense and what they did", formalDefinition="Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker." )
        protected CodeableConcept function;

        /**
         * The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the device.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Organization.class, Patient.class, Device.class, RelatedPerson.class, CareTeam.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Individual who was performing", formalDefinition="The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the device." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

    /**
     * Constructor
     */
      public DeviceDispensePerformerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceDispensePerformerComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #function} (Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDispensePerformerComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.)
         */
        public DeviceDispensePerformerComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the device.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceDispensePerformerComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the device.)
         */
        public DeviceDispensePerformerComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|Patient|Device|RelatedPerson|CareTeam)", "The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the device.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|Patient|Device|RelatedPerson|CareTeam)", "The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the device.", 0, 1, actor);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1380938712: // function
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actor")) {
          this.actor = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("function")) {
          this.function = null;
        } else if (name.equals("actor")) {
          this.actor = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712:  return getFunction();
        case 92645877:  return getActor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("function")) {
          this.function = new CodeableConcept();
          return this.function;
        }
        else if (name.equals("actor")) {
          this.actor = new Reference();
          return this.actor;
        }
        else
          return super.addChild(name);
      }

      public DeviceDispensePerformerComponent copy() {
        DeviceDispensePerformerComponent dst = new DeviceDispensePerformerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDispensePerformerComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDispensePerformerComponent))
          return false;
        DeviceDispensePerformerComponent o = (DeviceDispensePerformerComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDispensePerformerComponent))
          return false;
        DeviceDispensePerformerComponent o = (DeviceDispensePerformerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "DeviceDispense.performer";

  }

  }

    /**
     * Business identifier for this dispensation.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for this dispensation", formalDefinition="Business identifier for this dispensation." )
    protected List<Identifier> identifier;

    /**
     * The order or request that this dispense is fulfilling.
     */
    @Child(name = "basedOn", type = {CarePlan.class, DeviceRequest.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The order or request that this dispense is fulfilling", formalDefinition="The order or request that this dispense is fulfilling." )
    protected List<Reference> basedOn;

    /**
     * The bigger event that this dispense is a part of.
     */
    @Child(name = "partOf", type = {Procedure.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The bigger event that this dispense is a part of", formalDefinition="The bigger event that this dispense is a part of." )
    protected List<Reference> partOf;

    /**
     * A code specifying the state of the set of dispense events.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="preparation | in-progress | cancelled | on-hold | completed | entered-in-error | stopped | declined | unknown", formalDefinition="A code specifying the state of the set of dispense events." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/devicedispense-status")
    protected Enumeration<DeviceDispenseStatusCodes> status;

    /**
     * Indicates the reason why a dispense was or was not performed.
     */
    @Child(name = "statusReason", type = {CodeableReference.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why a dispense was or was not performed", formalDefinition="Indicates the reason why a dispense was or was not performed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/devicedispense-status-reason")
    protected CodeableReference statusReason;

    /**
     * Indicates the type of device dispense.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Type of device dispense", formalDefinition="Indicates the type of device dispense." )
    protected List<CodeableConcept> category;

    /**
     * Identifies the device being dispensed. This is either a link to a resource representing the details of the device or a simple attribute carrying a code that identifies the device from a known list of devices.
     */
    @Child(name = "device", type = {CodeableReference.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What device was supplied", formalDefinition="Identifies the device being dispensed. This is either a link to a resource representing the details of the device or a simple attribute carrying a code that identifies the device from a known list of devices." )
    protected CodeableReference device;

    /**
     * A link to a resource representing the person to whom the device is intended.
     */
    @Child(name = "subject", type = {Patient.class, Practitioner.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who the dispense is for", formalDefinition="A link to a resource representing the person to whom the device is intended." )
    protected Reference subject;

    /**
     * Identifies the person who picked up the device or the person or location where the device was delivered.  This may be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location.
     */
    @Child(name = "receiver", type = {Patient.class, Practitioner.class, RelatedPerson.class, Location.class, PractitionerRole.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Who collected the device or where the medication was delivered", formalDefinition="Identifies the person who picked up the device or the person or location where the device was delivered.  This may be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location." )
    protected Reference receiver;

    /**
     * The encounter that establishes the context for this event.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Encounter associated with event", formalDefinition="The encounter that establishes the context for this event." )
    protected Reference encounter;

    /**
     * Additional information that supports the device being dispensed.
     */
    @Child(name = "supportingInformation", type = {Reference.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information that supports the dispensing of the device", formalDefinition="Additional information that supports the device being dispensed." )
    protected List<Reference> supportingInformation;

    /**
     * Indicates who or what performed the event.
     */
    @Child(name = "performer", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who performed event", formalDefinition="Indicates who or what performed the event." )
    protected List<DeviceDispensePerformerComponent> performer;

    /**
     * The principal physical location where the dispense was performed.
     */
    @Child(name = "location", type = {Location.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where the dispense occurred", formalDefinition="The principal physical location where the dispense was performed." )
    protected Reference location;

    /**
     * Indicates the type of dispensing event that is performed.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Trial fill, partial fill, emergency fill, etc", formalDefinition="Indicates the type of dispensing event that is performed." )
    protected CodeableConcept type;

    /**
     * The number of devices that have been dispensed.
     */
    @Child(name = "quantity", type = {Quantity.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Amount dispensed", formalDefinition="The number of devices that have been dispensed." )
    protected Quantity quantity;

    /**
     * The time when the dispensed product was packaged and reviewed.
     */
    @Child(name = "preparedDate", type = {DateTimeType.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When product was packaged and reviewed", formalDefinition="The time when the dispensed product was packaged and reviewed." )
    protected DateTimeType preparedDate;

    /**
     * The time the dispensed product was made available to the patient or their representative.
     */
    @Child(name = "whenHandedOver", type = {DateTimeType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When product was given out", formalDefinition="The time the dispensed product was made available to the patient or their representative." )
    protected DateTimeType whenHandedOver;

    /**
     * Identification of the facility/location where the device was /should be shipped to, as part of the dispense process.
     */
    @Child(name = "destination", type = {Location.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where the device was sent or should be sent", formalDefinition="Identification of the facility/location where the device was /should be shipped to, as part of the dispense process." )
    protected Reference destination;

    /**
     * Extra information about the dispense that could not be conveyed in the other attributes.
     */
    @Child(name = "note", type = {Annotation.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information about the dispense", formalDefinition="Extra information about the dispense that could not be conveyed in the other attributes." )
    protected List<Annotation> note;

    /**
     * The full representation of the instructions.
     */
    @Child(name = "usageInstruction", type = {MarkdownType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Full representation of the usage instructions", formalDefinition="The full representation of the instructions." )
    protected MarkdownType usageInstruction;

    /**
     * A summary of the events of interest that have occurred, such as when the dispense was verified.
     */
    @Child(name = "eventHistory", type = {Provenance.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A list of relevant lifecycle events", formalDefinition="A summary of the events of interest that have occurred, such as when the dispense was verified." )
    protected List<Reference> eventHistory;

    private static final long serialVersionUID = 1740231007L;

  /**
   * Constructor
   */
    public DeviceDispense() {
      super();
    }

  /**
   * Constructor
   */
    public DeviceDispense(DeviceDispenseStatusCodes status, CodeableReference device, Reference subject) {
      super();
      this.setStatus(status);
      this.setDevice(device);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Business identifier for this dispensation.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDispense setIdentifier(List<Identifier> theIdentifier) { 
      this.identifier = theIdentifier;
      return this;
    }

    public boolean hasIdentifier() { 
      if (this.identifier == null)
        return false;
      for (Identifier item : this.identifier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Identifier addIdentifier() { //3
      Identifier t = new Identifier();
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return t;
    }

    public DeviceDispense addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist {3}
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #basedOn} (The order or request that this dispense is fulfilling.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDispense setBasedOn(List<Reference> theBasedOn) { 
      this.basedOn = theBasedOn;
      return this;
    }

    public boolean hasBasedOn() { 
      if (this.basedOn == null)
        return false;
      for (Reference item : this.basedOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasedOn() { //3
      Reference t = new Reference();
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return t;
    }

    public DeviceDispense addBasedOn(Reference t) { //3
      if (t == null)
        return this;
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist {3}
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @return {@link #partOf} (The bigger event that this dispense is a part of.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDispense setPartOf(List<Reference> thePartOf) { 
      this.partOf = thePartOf;
      return this;
    }

    public boolean hasPartOf() { 
      if (this.partOf == null)
        return false;
      for (Reference item : this.partOf)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPartOf() { //3
      Reference t = new Reference();
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return t;
    }

    public DeviceDispense addPartOf(Reference t) { //3
      if (t == null)
        return this;
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      this.partOf.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #partOf}, creating it if it does not already exist {3}
     */
    public Reference getPartOfFirstRep() { 
      if (getPartOf().isEmpty()) {
        addPartOf();
      }
      return getPartOf().get(0);
    }

    /**
     * @return {@link #status} (A code specifying the state of the set of dispense events.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<DeviceDispenseStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<DeviceDispenseStatusCodes>(new DeviceDispenseStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code specifying the state of the set of dispense events.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public DeviceDispense setStatusElement(Enumeration<DeviceDispenseStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code specifying the state of the set of dispense events.
     */
    public DeviceDispenseStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code specifying the state of the set of dispense events.
     */
    public DeviceDispense setStatus(DeviceDispenseStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<DeviceDispenseStatusCodes>(new DeviceDispenseStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #statusReason} (Indicates the reason why a dispense was or was not performed.)
     */
    public CodeableReference getStatusReason() { 
      if (this.statusReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.statusReason");
        else if (Configuration.doAutoCreate())
          this.statusReason = new CodeableReference(); // cc
      return this.statusReason;
    }

    public boolean hasStatusReason() { 
      return this.statusReason != null && !this.statusReason.isEmpty();
    }

    /**
     * @param value {@link #statusReason} (Indicates the reason why a dispense was or was not performed.)
     */
    public DeviceDispense setStatusReason(CodeableReference value) { 
      this.statusReason = value;
      return this;
    }

    /**
     * @return {@link #category} (Indicates the type of device dispense.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDispense setCategory(List<CodeableConcept> theCategory) { 
      this.category = theCategory;
      return this;
    }

    public boolean hasCategory() { 
      if (this.category == null)
        return false;
      for (CodeableConcept item : this.category)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCategory() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return t;
    }

    public DeviceDispense addCategory(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      this.category.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #category}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCategoryFirstRep() { 
      if (getCategory().isEmpty()) {
        addCategory();
      }
      return getCategory().get(0);
    }

    /**
     * @return {@link #device} (Identifies the device being dispensed. This is either a link to a resource representing the details of the device or a simple attribute carrying a code that identifies the device from a known list of devices.)
     */
    public CodeableReference getDevice() { 
      if (this.device == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.device");
        else if (Configuration.doAutoCreate())
          this.device = new CodeableReference(); // cc
      return this.device;
    }

    public boolean hasDevice() { 
      return this.device != null && !this.device.isEmpty();
    }

    /**
     * @param value {@link #device} (Identifies the device being dispensed. This is either a link to a resource representing the details of the device or a simple attribute carrying a code that identifies the device from a known list of devices.)
     */
    public DeviceDispense setDevice(CodeableReference value) { 
      this.device = value;
      return this;
    }

    /**
     * @return {@link #subject} (A link to a resource representing the person to whom the device is intended.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (A link to a resource representing the person to whom the device is intended.)
     */
    public DeviceDispense setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #receiver} (Identifies the person who picked up the device or the person or location where the device was delivered.  This may be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location.)
     */
    public Reference getReceiver() { 
      if (this.receiver == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.receiver");
        else if (Configuration.doAutoCreate())
          this.receiver = new Reference(); // cc
      return this.receiver;
    }

    public boolean hasReceiver() { 
      return this.receiver != null && !this.receiver.isEmpty();
    }

    /**
     * @param value {@link #receiver} (Identifies the person who picked up the device or the person or location where the device was delivered.  This may be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location.)
     */
    public DeviceDispense setReceiver(Reference value) { 
      this.receiver = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The encounter that establishes the context for this event.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The encounter that establishes the context for this event.)
     */
    public DeviceDispense setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #supportingInformation} (Additional information that supports the device being dispensed.)
     */
    public List<Reference> getSupportingInformation() { 
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      return this.supportingInformation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDispense setSupportingInformation(List<Reference> theSupportingInformation) { 
      this.supportingInformation = theSupportingInformation;
      return this;
    }

    public boolean hasSupportingInformation() { 
      if (this.supportingInformation == null)
        return false;
      for (Reference item : this.supportingInformation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupportingInformation() { //3
      Reference t = new Reference();
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      this.supportingInformation.add(t);
      return t;
    }

    public DeviceDispense addSupportingInformation(Reference t) { //3
      if (t == null)
        return this;
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      this.supportingInformation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supportingInformation}, creating it if it does not already exist {3}
     */
    public Reference getSupportingInformationFirstRep() { 
      if (getSupportingInformation().isEmpty()) {
        addSupportingInformation();
      }
      return getSupportingInformation().get(0);
    }

    /**
     * @return {@link #performer} (Indicates who or what performed the event.)
     */
    public List<DeviceDispensePerformerComponent> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<DeviceDispensePerformerComponent>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDispense setPerformer(List<DeviceDispensePerformerComponent> thePerformer) { 
      this.performer = thePerformer;
      return this;
    }

    public boolean hasPerformer() { 
      if (this.performer == null)
        return false;
      for (DeviceDispensePerformerComponent item : this.performer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DeviceDispensePerformerComponent addPerformer() { //3
      DeviceDispensePerformerComponent t = new DeviceDispensePerformerComponent();
      if (this.performer == null)
        this.performer = new ArrayList<DeviceDispensePerformerComponent>();
      this.performer.add(t);
      return t;
    }

    public DeviceDispense addPerformer(DeviceDispensePerformerComponent t) { //3
      if (t == null)
        return this;
      if (this.performer == null)
        this.performer = new ArrayList<DeviceDispensePerformerComponent>();
      this.performer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
     */
    public DeviceDispensePerformerComponent getPerformerFirstRep() { 
      if (getPerformer().isEmpty()) {
        addPerformer();
      }
      return getPerformer().get(0);
    }

    /**
     * @return {@link #location} (The principal physical location where the dispense was performed.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (The principal physical location where the dispense was performed.)
     */
    public DeviceDispense setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #type} (Indicates the type of dispensing event that is performed.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Indicates the type of dispensing event that is performed.)
     */
    public DeviceDispense setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #quantity} (The number of devices that have been dispensed.)
     */
    public Quantity getQuantity() { 
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.quantity");
        else if (Configuration.doAutoCreate())
          this.quantity = new Quantity(); // cc
      return this.quantity;
    }

    public boolean hasQuantity() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (The number of devices that have been dispensed.)
     */
    public DeviceDispense setQuantity(Quantity value) { 
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #preparedDate} (The time when the dispensed product was packaged and reviewed.). This is the underlying object with id, value and extensions. The accessor "getPreparedDate" gives direct access to the value
     */
    public DateTimeType getPreparedDateElement() { 
      if (this.preparedDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.preparedDate");
        else if (Configuration.doAutoCreate())
          this.preparedDate = new DateTimeType(); // bb
      return this.preparedDate;
    }

    public boolean hasPreparedDateElement() { 
      return this.preparedDate != null && !this.preparedDate.isEmpty();
    }

    public boolean hasPreparedDate() { 
      return this.preparedDate != null && !this.preparedDate.isEmpty();
    }

    /**
     * @param value {@link #preparedDate} (The time when the dispensed product was packaged and reviewed.). This is the underlying object with id, value and extensions. The accessor "getPreparedDate" gives direct access to the value
     */
    public DeviceDispense setPreparedDateElement(DateTimeType value) { 
      this.preparedDate = value;
      return this;
    }

    /**
     * @return The time when the dispensed product was packaged and reviewed.
     */
    public Date getPreparedDate() { 
      return this.preparedDate == null ? null : this.preparedDate.getValue();
    }

    /**
     * @param value The time when the dispensed product was packaged and reviewed.
     */
    public DeviceDispense setPreparedDate(Date value) { 
      if (value == null)
        this.preparedDate = null;
      else {
        if (this.preparedDate == null)
          this.preparedDate = new DateTimeType();
        this.preparedDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #whenHandedOver} (The time the dispensed product was made available to the patient or their representative.). This is the underlying object with id, value and extensions. The accessor "getWhenHandedOver" gives direct access to the value
     */
    public DateTimeType getWhenHandedOverElement() { 
      if (this.whenHandedOver == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.whenHandedOver");
        else if (Configuration.doAutoCreate())
          this.whenHandedOver = new DateTimeType(); // bb
      return this.whenHandedOver;
    }

    public boolean hasWhenHandedOverElement() { 
      return this.whenHandedOver != null && !this.whenHandedOver.isEmpty();
    }

    public boolean hasWhenHandedOver() { 
      return this.whenHandedOver != null && !this.whenHandedOver.isEmpty();
    }

    /**
     * @param value {@link #whenHandedOver} (The time the dispensed product was made available to the patient or their representative.). This is the underlying object with id, value and extensions. The accessor "getWhenHandedOver" gives direct access to the value
     */
    public DeviceDispense setWhenHandedOverElement(DateTimeType value) { 
      this.whenHandedOver = value;
      return this;
    }

    /**
     * @return The time the dispensed product was made available to the patient or their representative.
     */
    public Date getWhenHandedOver() { 
      return this.whenHandedOver == null ? null : this.whenHandedOver.getValue();
    }

    /**
     * @param value The time the dispensed product was made available to the patient or their representative.
     */
    public DeviceDispense setWhenHandedOver(Date value) { 
      if (value == null)
        this.whenHandedOver = null;
      else {
        if (this.whenHandedOver == null)
          this.whenHandedOver = new DateTimeType();
        this.whenHandedOver.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #destination} (Identification of the facility/location where the device was /should be shipped to, as part of the dispense process.)
     */
    public Reference getDestination() { 
      if (this.destination == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.destination");
        else if (Configuration.doAutoCreate())
          this.destination = new Reference(); // cc
      return this.destination;
    }

    public boolean hasDestination() { 
      return this.destination != null && !this.destination.isEmpty();
    }

    /**
     * @param value {@link #destination} (Identification of the facility/location where the device was /should be shipped to, as part of the dispense process.)
     */
    public DeviceDispense setDestination(Reference value) { 
      this.destination = value;
      return this;
    }

    /**
     * @return {@link #note} (Extra information about the dispense that could not be conveyed in the other attributes.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDispense setNote(List<Annotation> theNote) { 
      this.note = theNote;
      return this;
    }

    public boolean hasNote() { 
      if (this.note == null)
        return false;
      for (Annotation item : this.note)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Annotation addNote() { //3
      Annotation t = new Annotation();
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return t;
    }

    public DeviceDispense addNote(Annotation t) { //3
      if (t == null)
        return this;
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      this.note.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #note}, creating it if it does not already exist {3}
     */
    public Annotation getNoteFirstRep() { 
      if (getNote().isEmpty()) {
        addNote();
      }
      return getNote().get(0);
    }

    /**
     * @return {@link #usageInstruction} (The full representation of the instructions.). This is the underlying object with id, value and extensions. The accessor "getUsageInstruction" gives direct access to the value
     */
    public MarkdownType getUsageInstructionElement() { 
      if (this.usageInstruction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceDispense.usageInstruction");
        else if (Configuration.doAutoCreate())
          this.usageInstruction = new MarkdownType(); // bb
      return this.usageInstruction;
    }

    public boolean hasUsageInstructionElement() { 
      return this.usageInstruction != null && !this.usageInstruction.isEmpty();
    }

    public boolean hasUsageInstruction() { 
      return this.usageInstruction != null && !this.usageInstruction.isEmpty();
    }

    /**
     * @param value {@link #usageInstruction} (The full representation of the instructions.). This is the underlying object with id, value and extensions. The accessor "getUsageInstruction" gives direct access to the value
     */
    public DeviceDispense setUsageInstructionElement(MarkdownType value) { 
      this.usageInstruction = value;
      return this;
    }

    /**
     * @return The full representation of the instructions.
     */
    public String getUsageInstruction() { 
      return this.usageInstruction == null ? null : this.usageInstruction.getValue();
    }

    /**
     * @param value The full representation of the instructions.
     */
    public DeviceDispense setUsageInstruction(String value) { 
      if (Utilities.noString(value))
        this.usageInstruction = null;
      else {
        if (this.usageInstruction == null)
          this.usageInstruction = new MarkdownType();
        this.usageInstruction.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #eventHistory} (A summary of the events of interest that have occurred, such as when the dispense was verified.)
     */
    public List<Reference> getEventHistory() { 
      if (this.eventHistory == null)
        this.eventHistory = new ArrayList<Reference>();
      return this.eventHistory;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceDispense setEventHistory(List<Reference> theEventHistory) { 
      this.eventHistory = theEventHistory;
      return this;
    }

    public boolean hasEventHistory() { 
      if (this.eventHistory == null)
        return false;
      for (Reference item : this.eventHistory)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addEventHistory() { //3
      Reference t = new Reference();
      if (this.eventHistory == null)
        this.eventHistory = new ArrayList<Reference>();
      this.eventHistory.add(t);
      return t;
    }

    public DeviceDispense addEventHistory(Reference t) { //3
      if (t == null)
        return this;
      if (this.eventHistory == null)
        this.eventHistory = new ArrayList<Reference>();
      this.eventHistory.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #eventHistory}, creating it if it does not already exist {3}
     */
    public Reference getEventHistoryFirstRep() { 
      if (getEventHistory().isEmpty()) {
        addEventHistory();
      }
      return getEventHistory().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this dispensation.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(CarePlan|DeviceRequest)", "The order or request that this dispense is fulfilling.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(Procedure)", "The bigger event that this dispense is a part of.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code specifying the state of the set of dispense events.", 0, 1, status));
        children.add(new Property("statusReason", "CodeableReference(DetectedIssue)", "Indicates the reason why a dispense was or was not performed.", 0, 1, statusReason));
        children.add(new Property("category", "CodeableConcept", "Indicates the type of device dispense.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("device", "CodeableReference(Device|DeviceDefinition)", "Identifies the device being dispensed. This is either a link to a resource representing the details of the device or a simple attribute carrying a code that identifies the device from a known list of devices.", 0, 1, device));
        children.add(new Property("subject", "Reference(Patient|Practitioner)", "A link to a resource representing the person to whom the device is intended.", 0, 1, subject));
        children.add(new Property("receiver", "Reference(Patient|Practitioner|RelatedPerson|Location|PractitionerRole)", "Identifies the person who picked up the device or the person or location where the device was delivered.  This may be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location.", 0, 1, receiver));
        children.add(new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this event.", 0, 1, encounter));
        children.add(new Property("supportingInformation", "Reference(Any)", "Additional information that supports the device being dispensed.", 0, java.lang.Integer.MAX_VALUE, supportingInformation));
        children.add(new Property("performer", "", "Indicates who or what performed the event.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("location", "Reference(Location)", "The principal physical location where the dispense was performed.", 0, 1, location));
        children.add(new Property("type", "CodeableConcept", "Indicates the type of dispensing event that is performed.", 0, 1, type));
        children.add(new Property("quantity", "Quantity", "The number of devices that have been dispensed.", 0, 1, quantity));
        children.add(new Property("preparedDate", "dateTime", "The time when the dispensed product was packaged and reviewed.", 0, 1, preparedDate));
        children.add(new Property("whenHandedOver", "dateTime", "The time the dispensed product was made available to the patient or their representative.", 0, 1, whenHandedOver));
        children.add(new Property("destination", "Reference(Location)", "Identification of the facility/location where the device was /should be shipped to, as part of the dispense process.", 0, 1, destination));
        children.add(new Property("note", "Annotation", "Extra information about the dispense that could not be conveyed in the other attributes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("usageInstruction", "markdown", "The full representation of the instructions.", 0, 1, usageInstruction));
        children.add(new Property("eventHistory", "Reference(Provenance)", "A summary of the events of interest that have occurred, such as when the dispense was verified.", 0, java.lang.Integer.MAX_VALUE, eventHistory));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this dispensation.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(CarePlan|DeviceRequest)", "The order or request that this dispense is fulfilling.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Procedure)", "The bigger event that this dispense is a part of.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code specifying the state of the set of dispense events.", 0, 1, status);
        case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableReference(DetectedIssue)", "Indicates the reason why a dispense was or was not performed.", 0, 1, statusReason);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Indicates the type of device dispense.", 0, java.lang.Integer.MAX_VALUE, category);
        case -1335157162: /*device*/  return new Property("device", "CodeableReference(Device|DeviceDefinition)", "Identifies the device being dispensed. This is either a link to a resource representing the details of the device or a simple attribute carrying a code that identifies the device from a known list of devices.", 0, 1, device);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Practitioner)", "A link to a resource representing the person to whom the device is intended.", 0, 1, subject);
        case -808719889: /*receiver*/  return new Property("receiver", "Reference(Patient|Practitioner|RelatedPerson|Location|PractitionerRole)", "Identifies the person who picked up the device or the person or location where the device was delivered.  This may be a patient or their caregiver, but some cases exist where it can be a healthcare professional or a location.", 0, 1, receiver);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this event.", 0, 1, encounter);
        case -1248768647: /*supportingInformation*/  return new Property("supportingInformation", "Reference(Any)", "Additional information that supports the device being dispensed.", 0, java.lang.Integer.MAX_VALUE, supportingInformation);
        case 481140686: /*performer*/  return new Property("performer", "", "Indicates who or what performed the event.", 0, java.lang.Integer.MAX_VALUE, performer);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The principal physical location where the dispense was performed.", 0, 1, location);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Indicates the type of dispensing event that is performed.", 0, 1, type);
        case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The number of devices that have been dispensed.", 0, 1, quantity);
        case -2024959605: /*preparedDate*/  return new Property("preparedDate", "dateTime", "The time when the dispensed product was packaged and reviewed.", 0, 1, preparedDate);
        case -940241380: /*whenHandedOver*/  return new Property("whenHandedOver", "dateTime", "The time the dispensed product was made available to the patient or their representative.", 0, 1, whenHandedOver);
        case -1429847026: /*destination*/  return new Property("destination", "Reference(Location)", "Identification of the facility/location where the device was /should be shipped to, as part of the dispense process.", 0, 1, destination);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Extra information about the dispense that could not be conveyed in the other attributes.", 0, java.lang.Integer.MAX_VALUE, note);
        case 2138372141: /*usageInstruction*/  return new Property("usageInstruction", "markdown", "The full representation of the instructions.", 0, 1, usageInstruction);
        case 1835190426: /*eventHistory*/  return new Property("eventHistory", "Reference(Provenance)", "A summary of the events of interest that have occurred, such as when the dispense was verified.", 0, java.lang.Integer.MAX_VALUE, eventHistory);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<DeviceDispenseStatusCodes>
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : new Base[] {this.statusReason}; // CodeableReference
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // CodeableReference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case -808719889: /*receiver*/ return this.receiver == null ? new Base[0] : new Base[] {this.receiver}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1248768647: /*supportingInformation*/ return this.supportingInformation == null ? new Base[0] : this.supportingInformation.toArray(new Base[this.supportingInformation.size()]); // Reference
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // DeviceDispensePerformerComponent
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case -2024959605: /*preparedDate*/ return this.preparedDate == null ? new Base[0] : new Base[] {this.preparedDate}; // DateTimeType
        case -940241380: /*whenHandedOver*/ return this.whenHandedOver == null ? new Base[0] : new Base[] {this.whenHandedOver}; // DateTimeType
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : new Base[] {this.destination}; // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 2138372141: /*usageInstruction*/ return this.usageInstruction == null ? new Base[0] : new Base[] {this.usageInstruction}; // MarkdownType
        case 1835190426: /*eventHistory*/ return this.eventHistory == null ? new Base[0] : this.eventHistory.toArray(new Base[this.eventHistory.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new DeviceDispenseStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DeviceDispenseStatusCodes>
          return value;
        case 2051346646: // statusReason
          this.statusReason = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case -808719889: // receiver
          this.receiver = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1248768647: // supportingInformation
          this.getSupportingInformation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 481140686: // performer
          this.getPerformer().add((DeviceDispensePerformerComponent) value); // DeviceDispensePerformerComponent
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -2024959605: // preparedDate
          this.preparedDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -940241380: // whenHandedOver
          this.whenHandedOver = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1429847026: // destination
          this.destination = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 2138372141: // usageInstruction
          this.usageInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1835190426: // eventHistory
          this.getEventHistory().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new DeviceDispenseStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DeviceDispenseStatusCodes>
        } else if (name.equals("statusReason")) {
          this.statusReason = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("receiver")) {
          this.receiver = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("supportingInformation")) {
          this.getSupportingInformation().add(TypeConvertor.castToReference(value));
        } else if (name.equals("performer")) {
          this.getPerformer().add((DeviceDispensePerformerComponent) value);
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("preparedDate")) {
          this.preparedDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("whenHandedOver")) {
          this.whenHandedOver = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("destination")) {
          this.destination = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("usageInstruction")) {
          this.usageInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("eventHistory")) {
          this.getEventHistory().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("basedOn")) {
          this.getBasedOn().remove(value);
        } else if (name.equals("partOf")) {
          this.getPartOf().remove(value);
        } else if (name.equals("status")) {
          value = new DeviceDispenseStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DeviceDispenseStatusCodes>
        } else if (name.equals("statusReason")) {
          this.statusReason = null;
        } else if (name.equals("category")) {
          this.getCategory().remove(value);
        } else if (name.equals("device")) {
          this.device = null;
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("receiver")) {
          this.receiver = null;
        } else if (name.equals("encounter")) {
          this.encounter = null;
        } else if (name.equals("supportingInformation")) {
          this.getSupportingInformation().remove(value);
        } else if (name.equals("performer")) {
          this.getPerformer().remove((DeviceDispensePerformerComponent) value);
        } else if (name.equals("location")) {
          this.location = null;
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("quantity")) {
          this.quantity = null;
        } else if (name.equals("preparedDate")) {
          this.preparedDate = null;
        } else if (name.equals("whenHandedOver")) {
          this.whenHandedOver = null;
        } else if (name.equals("destination")) {
          this.destination = null;
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("usageInstruction")) {
          this.usageInstruction = null;
        } else if (name.equals("eventHistory")) {
          this.getEventHistory().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case 2051346646:  return getStatusReason();
        case 50511102:  return addCategory(); 
        case -1335157162:  return getDevice();
        case -1867885268:  return getSubject();
        case -808719889:  return getReceiver();
        case 1524132147:  return getEncounter();
        case -1248768647:  return addSupportingInformation(); 
        case 481140686:  return addPerformer(); 
        case 1901043637:  return getLocation();
        case 3575610:  return getType();
        case -1285004149:  return getQuantity();
        case -2024959605:  return getPreparedDateElement();
        case -940241380:  return getWhenHandedOverElement();
        case -1429847026:  return getDestination();
        case 3387378:  return addNote(); 
        case 2138372141:  return getUsageInstructionElement();
        case 1835190426:  return addEventHistory(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 2051346646: /*statusReason*/ return new String[] {"CodeableReference"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1335157162: /*device*/ return new String[] {"CodeableReference"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case -808719889: /*receiver*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1248768647: /*supportingInformation*/ return new String[] {"Reference"};
        case 481140686: /*performer*/ return new String[] {};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case -2024959605: /*preparedDate*/ return new String[] {"dateTime"};
        case -940241380: /*whenHandedOver*/ return new String[] {"dateTime"};
        case -1429847026: /*destination*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 2138372141: /*usageInstruction*/ return new String[] {"markdown"};
        case 1835190426: /*eventHistory*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property DeviceDispense.status");
        }
        else if (name.equals("statusReason")) {
          this.statusReason = new CodeableReference();
          return this.statusReason;
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("device")) {
          this.device = new CodeableReference();
          return this.device;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("receiver")) {
          this.receiver = new Reference();
          return this.receiver;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("supportingInformation")) {
          return addSupportingInformation();
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("preparedDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property DeviceDispense.preparedDate");
        }
        else if (name.equals("whenHandedOver")) {
          throw new FHIRException("Cannot call addChild on a singleton property DeviceDispense.whenHandedOver");
        }
        else if (name.equals("destination")) {
          this.destination = new Reference();
          return this.destination;
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("usageInstruction")) {
          throw new FHIRException("Cannot call addChild on a singleton property DeviceDispense.usageInstruction");
        }
        else if (name.equals("eventHistory")) {
          return addEventHistory();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DeviceDispense";

  }

      public DeviceDispense copy() {
        DeviceDispense dst = new DeviceDispense();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceDispense dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.statusReason = statusReason == null ? null : statusReason.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.device = device == null ? null : device.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.receiver = receiver == null ? null : receiver.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        if (supportingInformation != null) {
          dst.supportingInformation = new ArrayList<Reference>();
          for (Reference i : supportingInformation)
            dst.supportingInformation.add(i.copy());
        };
        if (performer != null) {
          dst.performer = new ArrayList<DeviceDispensePerformerComponent>();
          for (DeviceDispensePerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        dst.type = type == null ? null : type.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.preparedDate = preparedDate == null ? null : preparedDate.copy();
        dst.whenHandedOver = whenHandedOver == null ? null : whenHandedOver.copy();
        dst.destination = destination == null ? null : destination.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.usageInstruction = usageInstruction == null ? null : usageInstruction.copy();
        if (eventHistory != null) {
          dst.eventHistory = new ArrayList<Reference>();
          for (Reference i : eventHistory)
            dst.eventHistory.add(i.copy());
        };
      }

      protected DeviceDispense typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceDispense))
          return false;
        DeviceDispense o = (DeviceDispense) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true) && compareDeep(category, o.category, true)
           && compareDeep(device, o.device, true) && compareDeep(subject, o.subject, true) && compareDeep(receiver, o.receiver, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(supportingInformation, o.supportingInformation, true)
           && compareDeep(performer, o.performer, true) && compareDeep(location, o.location, true) && compareDeep(type, o.type, true)
           && compareDeep(quantity, o.quantity, true) && compareDeep(preparedDate, o.preparedDate, true) && compareDeep(whenHandedOver, o.whenHandedOver, true)
           && compareDeep(destination, o.destination, true) && compareDeep(note, o.note, true) && compareDeep(usageInstruction, o.usageInstruction, true)
           && compareDeep(eventHistory, o.eventHistory, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceDispense))
          return false;
        DeviceDispense o = (DeviceDispense) other_;
        return compareValues(status, o.status, true) && compareValues(preparedDate, o.preparedDate, true) && compareValues(whenHandedOver, o.whenHandedOver, true)
           && compareValues(usageInstruction, o.usageInstruction, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, partOf
          , status, statusReason, category, device, subject, receiver, encounter, supportingInformation
          , performer, location, type, quantity, preparedDate, whenHandedOver, destination
          , note, usageInstruction, eventHistory);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.DeviceDispense;
   }

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Search for devices that match this code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDispense.device.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="DeviceDispense.device.concept", description="Search for devices that match this code", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Search for devices that match this code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDispense.device.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the dispense</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDispense.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="DeviceDispense.identifier", description="The identifier of the dispense", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the dispense</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDispense.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Returns device dispenses for a specific patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceDispense.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="DeviceDispense.subject.where(resolve() is Patient)", description="Returns device dispenses for a specific patient", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Returns device dispenses for a specific patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceDispense.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceDispense:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("DeviceDispense:patient").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the dispense</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDispense.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="DeviceDispense.status", description="The status of the dispense", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the dispense</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceDispense.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceDispense.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="DeviceDispense.subject", description="The identity of a patient for whom to list dispenses", type="reference", target={Patient.class, Practitioner.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>DeviceDispense.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceDispense:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("DeviceDispense:subject").toLocked();


}

