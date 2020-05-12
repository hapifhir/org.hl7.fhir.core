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
 * An event (i.e. any change to current patient status) that may be related to unintended effects on a patient or research subject.  The unintended effects may require additional monitoring, treatment or hospitalization or may result in death.  The AdverseEvent resource also extends to potential or avoided events that could have had such effects.
 */
@ResourceDef(name="AdverseEvent", profile="http://hl7.org/fhir/StructureDefinition/AdverseEvent")
public class AdverseEvent extends DomainResource {

    public enum AdverseEventActuality {
        /**
         * The adverse event actually happened regardless of whether anyone was affected or harmed.
         */
        ACTUAL, 
        /**
         * A potential adverse event.
         */
        POTENTIAL, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AdverseEventActuality fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("actual".equals(codeString))
          return ACTUAL;
        if ("potential".equals(codeString))
          return POTENTIAL;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AdverseEventActuality code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTUAL: return "actual";
            case POTENTIAL: return "potential";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTUAL: return "http://hl7.org/fhir/adverse-event-actuality";
            case POTENTIAL: return "http://hl7.org/fhir/adverse-event-actuality";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTUAL: return "The adverse event actually happened regardless of whether anyone was affected or harmed.";
            case POTENTIAL: return "A potential adverse event.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTUAL: return "Adverse Event";
            case POTENTIAL: return "Potential Adverse Event";
            default: return "?";
          }
        }
    }

  public static class AdverseEventActualityEnumFactory implements EnumFactory<AdverseEventActuality> {
    public AdverseEventActuality fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("actual".equals(codeString))
          return AdverseEventActuality.ACTUAL;
        if ("potential".equals(codeString))
          return AdverseEventActuality.POTENTIAL;
        throw new IllegalArgumentException("Unknown AdverseEventActuality code '"+codeString+"'");
        }
        public Enumeration<AdverseEventActuality> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AdverseEventActuality>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("actual".equals(codeString))
          return new Enumeration<AdverseEventActuality>(this, AdverseEventActuality.ACTUAL);
        if ("potential".equals(codeString))
          return new Enumeration<AdverseEventActuality>(this, AdverseEventActuality.POTENTIAL);
        throw new FHIRException("Unknown AdverseEventActuality code '"+codeString+"'");
        }
    public String toCode(AdverseEventActuality code) {
      if (code == AdverseEventActuality.ACTUAL)
        return "actual";
      if (code == AdverseEventActuality.POTENTIAL)
        return "potential";
      return "?";
      }
    public String toSystem(AdverseEventActuality code) {
      return code.getSystem();
      }
    }

    public enum AdverseEventStatus {
        /**
         * The event is currently occurring.
         */
        INPROGRESS, 
        /**
         * The event has now concluded.
         */
        COMPLETED, 
        /**
         * This electronic record should never have existed, though it is possible that real-world decisions were based on it.  (If real-world activity has occurred, the status should be \"stopped\" rather than \"entered-in-error\".).
         */
        ENTEREDINERROR, 
        /**
         * The authoring/source system does not know which of the status values currently applies for this event.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AdverseEventStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AdverseEventStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case INPROGRESS: return "in-progress";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case INPROGRESS: return "http://hl7.org/fhir/event-status";
            case COMPLETED: return "http://hl7.org/fhir/event-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/event-status";
            case UNKNOWN: return "http://hl7.org/fhir/event-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case INPROGRESS: return "The event is currently occurring.";
            case COMPLETED: return "The event has now concluded.";
            case ENTEREDINERROR: return "This electronic record should never have existed, though it is possible that real-world decisions were based on it.  (If real-world activity has occurred, the status should be \"stopped\" rather than \"entered-in-error\".).";
            case UNKNOWN: return "The authoring/source system does not know which of the status values currently applies for this event.  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply,  but the authoring/source system does not know which.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case INPROGRESS: return "In Progress";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            default: return "?";
          }
        }
    }

  public static class AdverseEventStatusEnumFactory implements EnumFactory<AdverseEventStatus> {
    public AdverseEventStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("in-progress".equals(codeString))
          return AdverseEventStatus.INPROGRESS;
        if ("completed".equals(codeString))
          return AdverseEventStatus.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return AdverseEventStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return AdverseEventStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown AdverseEventStatus code '"+codeString+"'");
        }
        public Enumeration<AdverseEventStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AdverseEventStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("in-progress".equals(codeString))
          return new Enumeration<AdverseEventStatus>(this, AdverseEventStatus.INPROGRESS);
        if ("completed".equals(codeString))
          return new Enumeration<AdverseEventStatus>(this, AdverseEventStatus.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<AdverseEventStatus>(this, AdverseEventStatus.ENTEREDINERROR);
        if ("unknown".equals(codeString))
          return new Enumeration<AdverseEventStatus>(this, AdverseEventStatus.UNKNOWN);
        throw new FHIRException("Unknown AdverseEventStatus code '"+codeString+"'");
        }
    public String toCode(AdverseEventStatus code) {
      if (code == AdverseEventStatus.INPROGRESS)
        return "in-progress";
      if (code == AdverseEventStatus.COMPLETED)
        return "completed";
      if (code == AdverseEventStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == AdverseEventStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(AdverseEventStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class AdverseEventParticipantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Distinguishes the type of involvement of the actor in the adverse event, such as contributor or informant.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of involvement", formalDefinition="Distinguishes the type of involvement of the actor in the adverse event, such as contributor or informant." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-participant-function")
        protected CodeableConcept function;

        /**
         * Indicates who or what participated in the event.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Organization.class, CareTeam.class, Patient.class, Device.class, RelatedPerson.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Who was involved in the adverse event or the potential adverse event", formalDefinition="Indicates who or what participated in the event." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

    /**
     * Constructor
     */
      public AdverseEventParticipantComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdverseEventParticipantComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #function} (Distinguishes the type of involvement of the actor in the adverse event, such as contributor or informant.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdverseEventParticipantComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Distinguishes the type of involvement of the actor in the adverse event, such as contributor or informant.)
         */
        public AdverseEventParticipantComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (Indicates who or what participated in the event.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdverseEventParticipantComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (Indicates who or what participated in the event.)
         */
        public AdverseEventParticipantComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the actor in the adverse event, such as contributor or informant.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Indicates who or what participated in the event.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the actor in the adverse event, such as contributor or informant.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|CareTeam|Patient|Device|RelatedPerson)", "Indicates who or what participated in the event.", 0, 1, actor);
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

      public AdverseEventParticipantComponent copy() {
        AdverseEventParticipantComponent dst = new AdverseEventParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdverseEventParticipantComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdverseEventParticipantComponent))
          return false;
        AdverseEventParticipantComponent o = (AdverseEventParticipantComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdverseEventParticipantComponent))
          return false;
        AdverseEventParticipantComponent o = (AdverseEventParticipantComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "AdverseEvent.participant";

  }

  }

    @Block()
    public static class AdverseEventSuspectEntityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.
         */
        @Child(name = "instance", type = {CodeableConcept.class, Immunization.class, Procedure.class, Substance.class, Medication.class, MedicationAdministration.class, MedicationUsage.class, Device.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Refers to the specific entity that caused the adverse event", formalDefinition="Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device." )
        protected DataType instance;

        /**
         * Information on the possible cause of the event.
         */
        @Child(name = "causality", type = {}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Information on the possible cause of the event", formalDefinition="Information on the possible cause of the event." )
        protected AdverseEventSuspectEntityCausalityComponent causality;

        private static final long serialVersionUID = -1455097004L;

    /**
     * Constructor
     */
      public AdverseEventSuspectEntityComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdverseEventSuspectEntityComponent(DataType instance) {
        super();
        this.setInstance(instance);
      }

        /**
         * @return {@link #instance} (Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.)
         */
        public DataType getInstance() { 
          return this.instance;
        }

        /**
         * @return {@link #instance} (Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.)
         */
        public CodeableConcept getInstanceCodeableConcept() throws FHIRException { 
          if (this.instance == null)
            this.instance = new CodeableConcept();
          if (!(this.instance instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.instance.getClass().getName()+" was encountered");
          return (CodeableConcept) this.instance;
        }

        public boolean hasInstanceCodeableConcept() { 
          return this != null && this.instance instanceof CodeableConcept;
        }

        /**
         * @return {@link #instance} (Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.)
         */
        public Reference getInstanceReference() throws FHIRException { 
          if (this.instance == null)
            this.instance = new Reference();
          if (!(this.instance instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.instance.getClass().getName()+" was encountered");
          return (Reference) this.instance;
        }

        public boolean hasInstanceReference() { 
          return this != null && this.instance instanceof Reference;
        }

        public boolean hasInstance() { 
          return this.instance != null && !this.instance.isEmpty();
        }

        /**
         * @param value {@link #instance} (Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.)
         */
        public AdverseEventSuspectEntityComponent setInstance(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
            throw new Error("Not the right type for AdverseEvent.suspectEntity.instance[x]: "+value.fhirType());
          this.instance = value;
          return this;
        }

        /**
         * @return {@link #causality} (Information on the possible cause of the event.)
         */
        public AdverseEventSuspectEntityCausalityComponent getCausality() { 
          if (this.causality == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdverseEventSuspectEntityComponent.causality");
            else if (Configuration.doAutoCreate())
              this.causality = new AdverseEventSuspectEntityCausalityComponent(); // cc
          return this.causality;
        }

        public boolean hasCausality() { 
          return this.causality != null && !this.causality.isEmpty();
        }

        /**
         * @param value {@link #causality} (Information on the possible cause of the event.)
         */
        public AdverseEventSuspectEntityComponent setCausality(AdverseEventSuspectEntityCausalityComponent value) { 
          this.causality = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("instance[x]", "CodeableConcept|Reference(Immunization|Procedure|Substance|Medication|MedicationAdministration|MedicationUsage|Device)", "Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.", 0, 1, instance));
          children.add(new Property("causality", "", "Information on the possible cause of the event.", 0, 1, causality));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -2101998645: /*instance[x]*/  return new Property("instance[x]", "CodeableConcept|Reference(Immunization|Procedure|Substance|Medication|MedicationAdministration|MedicationUsage|Device)", "Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.", 0, 1, instance);
          case 555127957: /*instance*/  return new Property("instance[x]", "CodeableConcept|Reference(Immunization|Procedure|Substance|Medication|MedicationAdministration|MedicationUsage|Device)", "Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.", 0, 1, instance);
          case 697546316: /*instanceCodeableConcept*/  return new Property("instance[x]", "CodeableConcept", "Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.", 0, 1, instance);
          case -1675877834: /*instanceReference*/  return new Property("instance[x]", "Reference(Immunization|Procedure|Substance|Medication|MedicationAdministration|MedicationUsage|Device)", "Identifies the actual instance of what caused the adverse event.  May be a substance, medication, medication administration, medication statement or a device.", 0, 1, instance);
          case -1446450521: /*causality*/  return new Property("causality", "", "Information on the possible cause of the event.", 0, 1, causality);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 555127957: /*instance*/ return this.instance == null ? new Base[0] : new Base[] {this.instance}; // DataType
        case -1446450521: /*causality*/ return this.causality == null ? new Base[0] : new Base[] {this.causality}; // AdverseEventSuspectEntityCausalityComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 555127957: // instance
          this.instance = TypeConvertor.castToType(value); // DataType
          return value;
        case -1446450521: // causality
          this.causality = (AdverseEventSuspectEntityCausalityComponent) value; // AdverseEventSuspectEntityCausalityComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("instance[x]")) {
          this.instance = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("causality")) {
          this.causality = (AdverseEventSuspectEntityCausalityComponent) value; // AdverseEventSuspectEntityCausalityComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -2101998645:  return getInstance();
        case 555127957:  return getInstance();
        case -1446450521:  return getCausality();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 555127957: /*instance*/ return new String[] {"CodeableConcept", "Reference"};
        case -1446450521: /*causality*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("instanceCodeableConcept")) {
          this.instance = new CodeableConcept();
          return this.instance;
        }
        else if (name.equals("instanceReference")) {
          this.instance = new Reference();
          return this.instance;
        }
        else if (name.equals("causality")) {
          this.causality = new AdverseEventSuspectEntityCausalityComponent();
          return this.causality;
        }
        else
          return super.addChild(name);
      }

      public AdverseEventSuspectEntityComponent copy() {
        AdverseEventSuspectEntityComponent dst = new AdverseEventSuspectEntityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdverseEventSuspectEntityComponent dst) {
        super.copyValues(dst);
        dst.instance = instance == null ? null : instance.copy();
        dst.causality = causality == null ? null : causality.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdverseEventSuspectEntityComponent))
          return false;
        AdverseEventSuspectEntityComponent o = (AdverseEventSuspectEntityComponent) other_;
        return compareDeep(instance, o.instance, true) && compareDeep(causality, o.causality, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdverseEventSuspectEntityComponent))
          return false;
        AdverseEventSuspectEntityComponent o = (AdverseEventSuspectEntityComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(instance, causality);
      }

  public String fhirType() {
    return "AdverseEvent.suspectEntity";

  }

  }

    @Block()
    public static class AdverseEventSuspectEntityCausalityComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The method of evaluating the relatedness of the suspected entity to the event.
         */
        @Child(name = "assessmentMethod", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Method of evaluating the relatedness of the suspected entity to the event", formalDefinition="The method of evaluating the relatedness of the suspected entity to the event." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-causality-method")
        protected CodeableConcept assessmentMethod;

        /**
         * The result of the assessment regarding the relatedness of the suspected entity to the event.
         */
        @Child(name = "entityRelatedness", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Result of the assessment regarding the relatedness of the suspected entity to the event", formalDefinition="The result of the assessment regarding the relatedness of the suspected entity to the event." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-causality-assess")
        protected CodeableConcept entityRelatedness;

        /**
         * The author of the information on the possible cause of the event.
         */
        @Child(name = "author", type = {Practitioner.class, PractitionerRole.class, Patient.class, RelatedPerson.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Author of the information on the possible cause of the event", formalDefinition="The author of the information on the possible cause of the event." )
        protected Reference author;

        private static final long serialVersionUID = 486112728L;

    /**
     * Constructor
     */
      public AdverseEventSuspectEntityCausalityComponent() {
        super();
      }

        /**
         * @return {@link #assessmentMethod} (The method of evaluating the relatedness of the suspected entity to the event.)
         */
        public CodeableConcept getAssessmentMethod() { 
          if (this.assessmentMethod == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdverseEventSuspectEntityCausalityComponent.assessmentMethod");
            else if (Configuration.doAutoCreate())
              this.assessmentMethod = new CodeableConcept(); // cc
          return this.assessmentMethod;
        }

        public boolean hasAssessmentMethod() { 
          return this.assessmentMethod != null && !this.assessmentMethod.isEmpty();
        }

        /**
         * @param value {@link #assessmentMethod} (The method of evaluating the relatedness of the suspected entity to the event.)
         */
        public AdverseEventSuspectEntityCausalityComponent setAssessmentMethod(CodeableConcept value) { 
          this.assessmentMethod = value;
          return this;
        }

        /**
         * @return {@link #entityRelatedness} (The result of the assessment regarding the relatedness of the suspected entity to the event.)
         */
        public CodeableConcept getEntityRelatedness() { 
          if (this.entityRelatedness == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdverseEventSuspectEntityCausalityComponent.entityRelatedness");
            else if (Configuration.doAutoCreate())
              this.entityRelatedness = new CodeableConcept(); // cc
          return this.entityRelatedness;
        }

        public boolean hasEntityRelatedness() { 
          return this.entityRelatedness != null && !this.entityRelatedness.isEmpty();
        }

        /**
         * @param value {@link #entityRelatedness} (The result of the assessment regarding the relatedness of the suspected entity to the event.)
         */
        public AdverseEventSuspectEntityCausalityComponent setEntityRelatedness(CodeableConcept value) { 
          this.entityRelatedness = value;
          return this;
        }

        /**
         * @return {@link #author} (The author of the information on the possible cause of the event.)
         */
        public Reference getAuthor() { 
          if (this.author == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create AdverseEventSuspectEntityCausalityComponent.author");
            else if (Configuration.doAutoCreate())
              this.author = new Reference(); // cc
          return this.author;
        }

        public boolean hasAuthor() { 
          return this.author != null && !this.author.isEmpty();
        }

        /**
         * @param value {@link #author} (The author of the information on the possible cause of the event.)
         */
        public AdverseEventSuspectEntityCausalityComponent setAuthor(Reference value) { 
          this.author = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("assessmentMethod", "CodeableConcept", "The method of evaluating the relatedness of the suspected entity to the event.", 0, 1, assessmentMethod));
          children.add(new Property("entityRelatedness", "CodeableConcept", "The result of the assessment regarding the relatedness of the suspected entity to the event.", 0, 1, entityRelatedness));
          children.add(new Property("author", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson)", "The author of the information on the possible cause of the event.", 0, 1, author));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1681283651: /*assessmentMethod*/  return new Property("assessmentMethod", "CodeableConcept", "The method of evaluating the relatedness of the suspected entity to the event.", 0, 1, assessmentMethod);
          case 2000199967: /*entityRelatedness*/  return new Property("entityRelatedness", "CodeableConcept", "The result of the assessment regarding the relatedness of the suspected entity to the event.", 0, 1, entityRelatedness);
          case -1406328437: /*author*/  return new Property("author", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson)", "The author of the information on the possible cause of the event.", 0, 1, author);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1681283651: /*assessmentMethod*/ return this.assessmentMethod == null ? new Base[0] : new Base[] {this.assessmentMethod}; // CodeableConcept
        case 2000199967: /*entityRelatedness*/ return this.entityRelatedness == null ? new Base[0] : new Base[] {this.entityRelatedness}; // CodeableConcept
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : new Base[] {this.author}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1681283651: // assessmentMethod
          this.assessmentMethod = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 2000199967: // entityRelatedness
          this.entityRelatedness = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1406328437: // author
          this.author = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("assessmentMethod")) {
          this.assessmentMethod = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("entityRelatedness")) {
          this.entityRelatedness = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("author")) {
          this.author = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1681283651:  return getAssessmentMethod();
        case 2000199967:  return getEntityRelatedness();
        case -1406328437:  return getAuthor();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1681283651: /*assessmentMethod*/ return new String[] {"CodeableConcept"};
        case 2000199967: /*entityRelatedness*/ return new String[] {"CodeableConcept"};
        case -1406328437: /*author*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("assessmentMethod")) {
          this.assessmentMethod = new CodeableConcept();
          return this.assessmentMethod;
        }
        else if (name.equals("entityRelatedness")) {
          this.entityRelatedness = new CodeableConcept();
          return this.entityRelatedness;
        }
        else if (name.equals("author")) {
          this.author = new Reference();
          return this.author;
        }
        else
          return super.addChild(name);
      }

      public AdverseEventSuspectEntityCausalityComponent copy() {
        AdverseEventSuspectEntityCausalityComponent dst = new AdverseEventSuspectEntityCausalityComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdverseEventSuspectEntityCausalityComponent dst) {
        super.copyValues(dst);
        dst.assessmentMethod = assessmentMethod == null ? null : assessmentMethod.copy();
        dst.entityRelatedness = entityRelatedness == null ? null : entityRelatedness.copy();
        dst.author = author == null ? null : author.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdverseEventSuspectEntityCausalityComponent))
          return false;
        AdverseEventSuspectEntityCausalityComponent o = (AdverseEventSuspectEntityCausalityComponent) other_;
        return compareDeep(assessmentMethod, o.assessmentMethod, true) && compareDeep(entityRelatedness, o.entityRelatedness, true)
           && compareDeep(author, o.author, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdverseEventSuspectEntityCausalityComponent))
          return false;
        AdverseEventSuspectEntityCausalityComponent o = (AdverseEventSuspectEntityCausalityComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(assessmentMethod, entityRelatedness
          , author);
      }

  public String fhirType() {
    return "AdverseEvent.suspectEntity.causality";

  }

  }

    @Block()
    public static class AdverseEventContributingFactorComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The item that is suspected to have increased the probability or severity of the adverse event.
         */
        @Child(name = "item", type = {Condition.class, Observation.class, AllergyIntolerance.class, FamilyMemberHistory.class, Immunization.class, Procedure.class, DocumentReference.class, CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Item suspected to have increased the probability or severity of the adverse event", formalDefinition="The item that is suspected to have increased the probability or severity of the adverse event." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-contributing-factor")
        protected DataType item;

        private static final long serialVersionUID = 1847936859L;

    /**
     * Constructor
     */
      public AdverseEventContributingFactorComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdverseEventContributingFactorComponent(DataType item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (The item that is suspected to have increased the probability or severity of the adverse event.)
         */
        public DataType getItem() { 
          return this.item;
        }

        /**
         * @return {@link #item} (The item that is suspected to have increased the probability or severity of the adverse event.)
         */
        public Reference getItemReference() throws FHIRException { 
          if (this.item == null)
            this.item = new Reference();
          if (!(this.item instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.item.getClass().getName()+" was encountered");
          return (Reference) this.item;
        }

        public boolean hasItemReference() { 
          return this != null && this.item instanceof Reference;
        }

        /**
         * @return {@link #item} (The item that is suspected to have increased the probability or severity of the adverse event.)
         */
        public CodeableConcept getItemCodeableConcept() throws FHIRException { 
          if (this.item == null)
            this.item = new CodeableConcept();
          if (!(this.item instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.item.getClass().getName()+" was encountered");
          return (CodeableConcept) this.item;
        }

        public boolean hasItemCodeableConcept() { 
          return this != null && this.item instanceof CodeableConcept;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (The item that is suspected to have increased the probability or severity of the adverse event.)
         */
        public AdverseEventContributingFactorComponent setItem(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
            throw new Error("Not the right type for AdverseEvent.contributingFactor.item[x]: "+value.fhirType());
          this.item = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item[x]", "Reference(Condition|Observation|AllergyIntolerance|FamilyMemberHistory|Immunization|Procedure|DocumentReference)|CodeableConcept", "The item that is suspected to have increased the probability or severity of the adverse event.", 0, 1, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2116201613: /*item[x]*/  return new Property("item[x]", "Reference(Condition|Observation|AllergyIntolerance|FamilyMemberHistory|Immunization|Procedure|DocumentReference)|CodeableConcept", "The item that is suspected to have increased the probability or severity of the adverse event.", 0, 1, item);
          case 3242771: /*item*/  return new Property("item[x]", "Reference(Condition|Observation|AllergyIntolerance|FamilyMemberHistory|Immunization|Procedure|DocumentReference)|CodeableConcept", "The item that is suspected to have increased the probability or severity of the adverse event.", 0, 1, item);
          case 1376364920: /*itemReference*/  return new Property("item[x]", "Reference(Condition|Observation|AllergyIntolerance|FamilyMemberHistory|Immunization|Procedure|DocumentReference)", "The item that is suspected to have increased the probability or severity of the adverse event.", 0, 1, item);
          case 106644494: /*itemCodeableConcept*/  return new Property("item[x]", "CodeableConcept", "The item that is suspected to have increased the probability or severity of the adverse event.", 0, 1, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item[x]")) {
          this.item = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2116201613:  return getItem();
        case 3242771:  return getItem();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"Reference", "CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("itemReference")) {
          this.item = new Reference();
          return this.item;
        }
        else if (name.equals("itemCodeableConcept")) {
          this.item = new CodeableConcept();
          return this.item;
        }
        else
          return super.addChild(name);
      }

      public AdverseEventContributingFactorComponent copy() {
        AdverseEventContributingFactorComponent dst = new AdverseEventContributingFactorComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdverseEventContributingFactorComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdverseEventContributingFactorComponent))
          return false;
        AdverseEventContributingFactorComponent o = (AdverseEventContributingFactorComponent) other_;
        return compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdverseEventContributingFactorComponent))
          return false;
        AdverseEventContributingFactorComponent o = (AdverseEventContributingFactorComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item);
      }

  public String fhirType() {
    return "AdverseEvent.contributingFactor";

  }

  }

    @Block()
    public static class AdverseEventPreventiveActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The action that contributed to avoiding the adverse event.
         */
        @Child(name = "item", type = {Immunization.class, Procedure.class, DocumentReference.class, MedicationAdministration.class, MedicationRequest.class, CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Action that contributed to avoiding the adverse event", formalDefinition="The action that contributed to avoiding the adverse event." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-preventive-action")
        protected DataType item;

        private static final long serialVersionUID = 1847936859L;

    /**
     * Constructor
     */
      public AdverseEventPreventiveActionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdverseEventPreventiveActionComponent(DataType item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (The action that contributed to avoiding the adverse event.)
         */
        public DataType getItem() { 
          return this.item;
        }

        /**
         * @return {@link #item} (The action that contributed to avoiding the adverse event.)
         */
        public Reference getItemReference() throws FHIRException { 
          if (this.item == null)
            this.item = new Reference();
          if (!(this.item instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.item.getClass().getName()+" was encountered");
          return (Reference) this.item;
        }

        public boolean hasItemReference() { 
          return this != null && this.item instanceof Reference;
        }

        /**
         * @return {@link #item} (The action that contributed to avoiding the adverse event.)
         */
        public CodeableConcept getItemCodeableConcept() throws FHIRException { 
          if (this.item == null)
            this.item = new CodeableConcept();
          if (!(this.item instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.item.getClass().getName()+" was encountered");
          return (CodeableConcept) this.item;
        }

        public boolean hasItemCodeableConcept() { 
          return this != null && this.item instanceof CodeableConcept;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (The action that contributed to avoiding the adverse event.)
         */
        public AdverseEventPreventiveActionComponent setItem(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
            throw new Error("Not the right type for AdverseEvent.preventiveAction.item[x]: "+value.fhirType());
          this.item = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item[x]", "Reference(Immunization|Procedure|DocumentReference|MedicationAdministration|MedicationRequest)|CodeableConcept", "The action that contributed to avoiding the adverse event.", 0, 1, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2116201613: /*item[x]*/  return new Property("item[x]", "Reference(Immunization|Procedure|DocumentReference|MedicationAdministration|MedicationRequest)|CodeableConcept", "The action that contributed to avoiding the adverse event.", 0, 1, item);
          case 3242771: /*item*/  return new Property("item[x]", "Reference(Immunization|Procedure|DocumentReference|MedicationAdministration|MedicationRequest)|CodeableConcept", "The action that contributed to avoiding the adverse event.", 0, 1, item);
          case 1376364920: /*itemReference*/  return new Property("item[x]", "Reference(Immunization|Procedure|DocumentReference|MedicationAdministration|MedicationRequest)", "The action that contributed to avoiding the adverse event.", 0, 1, item);
          case 106644494: /*itemCodeableConcept*/  return new Property("item[x]", "CodeableConcept", "The action that contributed to avoiding the adverse event.", 0, 1, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item[x]")) {
          this.item = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2116201613:  return getItem();
        case 3242771:  return getItem();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"Reference", "CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("itemReference")) {
          this.item = new Reference();
          return this.item;
        }
        else if (name.equals("itemCodeableConcept")) {
          this.item = new CodeableConcept();
          return this.item;
        }
        else
          return super.addChild(name);
      }

      public AdverseEventPreventiveActionComponent copy() {
        AdverseEventPreventiveActionComponent dst = new AdverseEventPreventiveActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdverseEventPreventiveActionComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdverseEventPreventiveActionComponent))
          return false;
        AdverseEventPreventiveActionComponent o = (AdverseEventPreventiveActionComponent) other_;
        return compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdverseEventPreventiveActionComponent))
          return false;
        AdverseEventPreventiveActionComponent o = (AdverseEventPreventiveActionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item);
      }

  public String fhirType() {
    return "AdverseEvent.preventiveAction";

  }

  }

    @Block()
    public static class AdverseEventMitigatingActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.
         */
        @Child(name = "item", type = {Procedure.class, DocumentReference.class, MedicationAdministration.class, MedicationRequest.class, CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Ameliorating action taken after the adverse event occured in order to reduce the extent of harm", formalDefinition="The ameliorating action taken after the adverse event occured in order to reduce the extent of harm." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-mitigating-action")
        protected DataType item;

        private static final long serialVersionUID = 1847936859L;

    /**
     * Constructor
     */
      public AdverseEventMitigatingActionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdverseEventMitigatingActionComponent(DataType item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.)
         */
        public DataType getItem() { 
          return this.item;
        }

        /**
         * @return {@link #item} (The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.)
         */
        public Reference getItemReference() throws FHIRException { 
          if (this.item == null)
            this.item = new Reference();
          if (!(this.item instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.item.getClass().getName()+" was encountered");
          return (Reference) this.item;
        }

        public boolean hasItemReference() { 
          return this != null && this.item instanceof Reference;
        }

        /**
         * @return {@link #item} (The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.)
         */
        public CodeableConcept getItemCodeableConcept() throws FHIRException { 
          if (this.item == null)
            this.item = new CodeableConcept();
          if (!(this.item instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.item.getClass().getName()+" was encountered");
          return (CodeableConcept) this.item;
        }

        public boolean hasItemCodeableConcept() { 
          return this != null && this.item instanceof CodeableConcept;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.)
         */
        public AdverseEventMitigatingActionComponent setItem(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
            throw new Error("Not the right type for AdverseEvent.mitigatingAction.item[x]: "+value.fhirType());
          this.item = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item[x]", "Reference(Procedure|DocumentReference|MedicationAdministration|MedicationRequest)|CodeableConcept", "The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.", 0, 1, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2116201613: /*item[x]*/  return new Property("item[x]", "Reference(Procedure|DocumentReference|MedicationAdministration|MedicationRequest)|CodeableConcept", "The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.", 0, 1, item);
          case 3242771: /*item*/  return new Property("item[x]", "Reference(Procedure|DocumentReference|MedicationAdministration|MedicationRequest)|CodeableConcept", "The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.", 0, 1, item);
          case 1376364920: /*itemReference*/  return new Property("item[x]", "Reference(Procedure|DocumentReference|MedicationAdministration|MedicationRequest)", "The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.", 0, 1, item);
          case 106644494: /*itemCodeableConcept*/  return new Property("item[x]", "CodeableConcept", "The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.", 0, 1, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item[x]")) {
          this.item = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2116201613:  return getItem();
        case 3242771:  return getItem();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"Reference", "CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("itemReference")) {
          this.item = new Reference();
          return this.item;
        }
        else if (name.equals("itemCodeableConcept")) {
          this.item = new CodeableConcept();
          return this.item;
        }
        else
          return super.addChild(name);
      }

      public AdverseEventMitigatingActionComponent copy() {
        AdverseEventMitigatingActionComponent dst = new AdverseEventMitigatingActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdverseEventMitigatingActionComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdverseEventMitigatingActionComponent))
          return false;
        AdverseEventMitigatingActionComponent o = (AdverseEventMitigatingActionComponent) other_;
        return compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdverseEventMitigatingActionComponent))
          return false;
        AdverseEventMitigatingActionComponent o = (AdverseEventMitigatingActionComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item);
      }

  public String fhirType() {
    return "AdverseEvent.mitigatingAction";

  }

  }

    @Block()
    public static class AdverseEventSupportingInfoComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.
         */
        @Child(name = "item", type = {Condition.class, Observation.class, AllergyIntolerance.class, FamilyMemberHistory.class, Immunization.class, Procedure.class, DocumentReference.class, CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Subject medical history or document relevant to this adverse event", formalDefinition="Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-supporting-info")
        protected DataType item;

        private static final long serialVersionUID = 1847936859L;

    /**
     * Constructor
     */
      public AdverseEventSupportingInfoComponent() {
        super();
      }

    /**
     * Constructor
     */
      public AdverseEventSupportingInfoComponent(DataType item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.)
         */
        public DataType getItem() { 
          return this.item;
        }

        /**
         * @return {@link #item} (Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.)
         */
        public Reference getItemReference() throws FHIRException { 
          if (this.item == null)
            this.item = new Reference();
          if (!(this.item instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.item.getClass().getName()+" was encountered");
          return (Reference) this.item;
        }

        public boolean hasItemReference() { 
          return this != null && this.item instanceof Reference;
        }

        /**
         * @return {@link #item} (Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.)
         */
        public CodeableConcept getItemCodeableConcept() throws FHIRException { 
          if (this.item == null)
            this.item = new CodeableConcept();
          if (!(this.item instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.item.getClass().getName()+" was encountered");
          return (CodeableConcept) this.item;
        }

        public boolean hasItemCodeableConcept() { 
          return this != null && this.item instanceof CodeableConcept;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.)
         */
        public AdverseEventSupportingInfoComponent setItem(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
            throw new Error("Not the right type for AdverseEvent.supportingInfo.item[x]: "+value.fhirType());
          this.item = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item[x]", "Reference(Condition|Observation|AllergyIntolerance|FamilyMemberHistory|Immunization|Procedure|DocumentReference)|CodeableConcept", "Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.", 0, 1, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2116201613: /*item[x]*/  return new Property("item[x]", "Reference(Condition|Observation|AllergyIntolerance|FamilyMemberHistory|Immunization|Procedure|DocumentReference)|CodeableConcept", "Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.", 0, 1, item);
          case 3242771: /*item*/  return new Property("item[x]", "Reference(Condition|Observation|AllergyIntolerance|FamilyMemberHistory|Immunization|Procedure|DocumentReference)|CodeableConcept", "Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.", 0, 1, item);
          case 1376364920: /*itemReference*/  return new Property("item[x]", "Reference(Condition|Observation|AllergyIntolerance|FamilyMemberHistory|Immunization|Procedure|DocumentReference)", "Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.", 0, 1, item);
          case 106644494: /*itemCodeableConcept*/  return new Property("item[x]", "CodeableConcept", "Relevant past history for the subject. In a clinical care context, an example being a patient had an adverse event following a pencillin administration and the patient had a previously documented penicillin allergy. In a clinical trials context, an example is a bunion or rash that was present prior to the study. Additionally, the supporting item can be a document that is relevant to this instance of the adverse event that is not part of the subject's medical history. For example, a clinical note, staff list, or material safety data sheet (MSDS).  Supporting information is not a contributing factor, preventive action, or mitigating action.", 0, 1, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item[x]")) {
          this.item = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 2116201613:  return getItem();
        case 3242771:  return getItem();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"Reference", "CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("itemReference")) {
          this.item = new Reference();
          return this.item;
        }
        else if (name.equals("itemCodeableConcept")) {
          this.item = new CodeableConcept();
          return this.item;
        }
        else
          return super.addChild(name);
      }

      public AdverseEventSupportingInfoComponent copy() {
        AdverseEventSupportingInfoComponent dst = new AdverseEventSupportingInfoComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdverseEventSupportingInfoComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdverseEventSupportingInfoComponent))
          return false;
        AdverseEventSupportingInfoComponent o = (AdverseEventSupportingInfoComponent) other_;
        return compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdverseEventSupportingInfoComponent))
          return false;
        AdverseEventSupportingInfoComponent o = (AdverseEventSupportingInfoComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item);
      }

  public String fhirType() {
    return "AdverseEvent.supportingInfo";

  }

  }

    /**
     * Business identifiers assigned to this adverse event by the performer or other systems which remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for the event", formalDefinition="Business identifiers assigned to this adverse event by the performer or other systems which remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * The current state of the adverse event or potential adverse event.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="in-progress | completed | entered-in-error | unknown", formalDefinition="The current state of the adverse event or potential adverse event." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-status")
    protected Enumeration<AdverseEventStatus> status;

    /**
     * Whether the event actually happened, or just had the potential to. Note that this is independent of whether anyone was affected or harmed or how severely.
     */
    @Child(name = "actuality", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="actual | potential", formalDefinition="Whether the event actually happened, or just had the potential to. Note that this is independent of whether anyone was affected or harmed or how severely." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-actuality")
    protected Enumeration<AdverseEventActuality> actuality;

    /**
     * The overall type of event, intended for search and filtering purposes.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="wrong-patient | procedure-mishap | medication-mishap | device | unsafe-physical-environment | hospital-aquired-infection | wrong-body-site", formalDefinition="The overall type of event, intended for search and filtering purposes." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-category")
    protected List<CodeableConcept> category;

    /**
     * Specific event that occurred or that was averted, such as patient fall, wrong organ removed, or wrong blood transfused.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Event or incident that occurred or was averted", formalDefinition="Specific event that occurred or that was averted, such as patient fall, wrong organ removed, or wrong blood transfused." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-type")
    protected CodeableConcept code;

    /**
     * This subject or group impacted by the event.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Practitioner.class, RelatedPerson.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Subject impacted by event", formalDefinition="This subject or group impacted by the event." )
    protected Reference subject;

    /**
     * The Encounter associated with the start of the AdverseEvent.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The Encounter associated with the start of the AdverseEvent", formalDefinition="The Encounter associated with the start of the AdverseEvent." )
    protected Reference encounter;

    /**
     * The date (and perhaps time) when the adverse event occurred.
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class, Timing.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the event occurred", formalDefinition="The date (and perhaps time) when the adverse event occurred." )
    protected DataType occurrence;

    /**
     * Estimated or actual date the AdverseEvent began, in the opinion of the reporter.
     */
    @Child(name = "detected", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the event was detected", formalDefinition="Estimated or actual date the AdverseEvent began, in the opinion of the reporter." )
    protected DateTimeType detected;

    /**
     * The date on which the existence of the AdverseEvent was first recorded.
     */
    @Child(name = "recordedDate", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the event was recorded", formalDefinition="The date on which the existence of the AdverseEvent was first recorded." )
    protected DateTimeType recordedDate;

    /**
     * Includes information about the reaction that occurred as a result of exposure to a substance (for example, a drug or a chemical).
     */
    @Child(name = "resultingCondition", type = {Condition.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Effect on the subject due to this event", formalDefinition="Includes information about the reaction that occurred as a result of exposure to a substance (for example, a drug or a chemical)." )
    protected List<Reference> resultingCondition;

    /**
     * The information about where the adverse event occurred.
     */
    @Child(name = "location", type = {Location.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Location where adverse event occurred", formalDefinition="The information about where the adverse event occurred." )
    protected Reference location;

    /**
     * Assessment whether this event, or averted event, was of clinical importance.
     */
    @Child(name = "seriousness", type = {CodeableConcept.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Seriousness or gravity of the event", formalDefinition="Assessment whether this event, or averted event, was of clinical importance." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-seriousness")
    protected CodeableConcept seriousness;

    /**
     * Describes the type of outcome from the adverse event, such as resolved, recovering, ongoing, resolved-with-sequelae, or fatal.
     */
    @Child(name = "outcome", type = {CodeableConcept.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Type of outcome from the adverse event", formalDefinition="Describes the type of outcome from the adverse event, such as resolved, recovering, ongoing, resolved-with-sequelae, or fatal." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adverse-event-outcome")
    protected CodeableConcept outcome;

    /**
     * Information on who recorded the adverse event.  May be the patient or a practitioner.
     */
    @Child(name = "recorder", type = {Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who recorded the adverse event", formalDefinition="Information on who recorded the adverse event.  May be the patient or a practitioner." )
    protected Reference recorder;

    /**
     * Indicates who or what participated in the adverse event and how they were involved.
     */
    @Child(name = "participant", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who was involved in the adverse event or the potential adverse event and what they did", formalDefinition="Indicates who or what participated in the adverse event and how they were involved." )
    protected List<AdverseEventParticipantComponent> participant;

    /**
     * Describes the entity that is suspected to have caused the adverse event.
     */
    @Child(name = "suspectEntity", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The suspected agent causing the adverse event", formalDefinition="Describes the entity that is suspected to have caused the adverse event." )
    protected List<AdverseEventSuspectEntityComponent> suspectEntity;

    /**
     * The contributing factors suspected to have increased the probability or severity of the adverse event.
     */
    @Child(name = "contributingFactor", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contributing factors suspected to have increased the probability or severity of the adverse event", formalDefinition="The contributing factors suspected to have increased the probability or severity of the adverse event." )
    protected List<AdverseEventContributingFactorComponent> contributingFactor;

    /**
     * Preventive actions that contributed to avoiding the adverse event.
     */
    @Child(name = "preventiveAction", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Preventive actions that contributed to avoiding the adverse event", formalDefinition="Preventive actions that contributed to avoiding the adverse event." )
    protected List<AdverseEventPreventiveActionComponent> preventiveAction;

    /**
     * The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.
     */
    @Child(name = "mitigatingAction", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Ameliorating actions taken after the adverse event occured in order to reduce the extent of harm", formalDefinition="The ameliorating action taken after the adverse event occured in order to reduce the extent of harm." )
    protected List<AdverseEventMitigatingActionComponent> mitigatingAction;

    /**
     * Supporting information relevant to the event.
     */
    @Child(name = "supportingInfo", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Supporting information relevant to the event", formalDefinition="Supporting information relevant to the event." )
    protected List<AdverseEventSupportingInfoComponent> supportingInfo;

    /**
     * The research study that the subject is enrolled in.
     */
    @Child(name = "study", type = {ResearchStudy.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Research study that the subject is enrolled in", formalDefinition="The research study that the subject is enrolled in." )
    protected List<Reference> study;

    private static final long serialVersionUID = -162346876L;

  /**
   * Constructor
   */
    public AdverseEvent() {
      super();
    }

  /**
   * Constructor
   */
    public AdverseEvent(AdverseEventStatus status, AdverseEventActuality actuality, Reference subject) {
      super();
      this.setStatus(status);
      this.setActuality(actuality);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this adverse event by the performer or other systems which remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setIdentifier(List<Identifier> theIdentifier) { 
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

    public AdverseEvent addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The current state of the adverse event or potential adverse event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<AdverseEventStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<AdverseEventStatus>(new AdverseEventStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The current state of the adverse event or potential adverse event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public AdverseEvent setStatusElement(Enumeration<AdverseEventStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the adverse event or potential adverse event.
     */
    public AdverseEventStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the adverse event or potential adverse event.
     */
    public AdverseEvent setStatus(AdverseEventStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<AdverseEventStatus>(new AdverseEventStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #actuality} (Whether the event actually happened, or just had the potential to. Note that this is independent of whether anyone was affected or harmed or how severely.). This is the underlying object with id, value and extensions. The accessor "getActuality" gives direct access to the value
     */
    public Enumeration<AdverseEventActuality> getActualityElement() { 
      if (this.actuality == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.actuality");
        else if (Configuration.doAutoCreate())
          this.actuality = new Enumeration<AdverseEventActuality>(new AdverseEventActualityEnumFactory()); // bb
      return this.actuality;
    }

    public boolean hasActualityElement() { 
      return this.actuality != null && !this.actuality.isEmpty();
    }

    public boolean hasActuality() { 
      return this.actuality != null && !this.actuality.isEmpty();
    }

    /**
     * @param value {@link #actuality} (Whether the event actually happened, or just had the potential to. Note that this is independent of whether anyone was affected or harmed or how severely.). This is the underlying object with id, value and extensions. The accessor "getActuality" gives direct access to the value
     */
    public AdverseEvent setActualityElement(Enumeration<AdverseEventActuality> value) { 
      this.actuality = value;
      return this;
    }

    /**
     * @return Whether the event actually happened, or just had the potential to. Note that this is independent of whether anyone was affected or harmed or how severely.
     */
    public AdverseEventActuality getActuality() { 
      return this.actuality == null ? null : this.actuality.getValue();
    }

    /**
     * @param value Whether the event actually happened, or just had the potential to. Note that this is independent of whether anyone was affected or harmed or how severely.
     */
    public AdverseEvent setActuality(AdverseEventActuality value) { 
        if (this.actuality == null)
          this.actuality = new Enumeration<AdverseEventActuality>(new AdverseEventActualityEnumFactory());
        this.actuality.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (The overall type of event, intended for search and filtering purposes.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setCategory(List<CodeableConcept> theCategory) { 
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

    public AdverseEvent addCategory(CodeableConcept t) { //3
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
     * @return {@link #code} (Specific event that occurred or that was averted, such as patient fall, wrong organ removed, or wrong blood transfused.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Specific event that occurred or that was averted, such as patient fall, wrong organ removed, or wrong blood transfused.)
     */
    public AdverseEvent setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (This subject or group impacted by the event.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (This subject or group impacted by the event.)
     */
    public AdverseEvent setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The Encounter associated with the start of the AdverseEvent.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The Encounter associated with the start of the AdverseEvent.)
     */
    public AdverseEvent setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #occurrence} (The date (and perhaps time) when the adverse event occurred.)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (The date (and perhaps time) when the adverse event occurred.)
     */
    public DateTimeType getOccurrenceDateTimeType() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new DateTimeType();
      if (!(this.occurrence instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (DateTimeType) this.occurrence;
    }

    public boolean hasOccurrenceDateTimeType() { 
      return this != null && this.occurrence instanceof DateTimeType;
    }

    /**
     * @return {@link #occurrence} (The date (and perhaps time) when the adverse event occurred.)
     */
    public Period getOccurrencePeriod() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Period();
      if (!(this.occurrence instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Period) this.occurrence;
    }

    public boolean hasOccurrencePeriod() { 
      return this != null && this.occurrence instanceof Period;
    }

    /**
     * @return {@link #occurrence} (The date (and perhaps time) when the adverse event occurred.)
     */
    public Timing getOccurrenceTiming() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Timing();
      if (!(this.occurrence instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Timing) this.occurrence;
    }

    public boolean hasOccurrenceTiming() { 
      return this != null && this.occurrence instanceof Timing;
    }

    public boolean hasOccurrence() { 
      return this.occurrence != null && !this.occurrence.isEmpty();
    }

    /**
     * @param value {@link #occurrence} (The date (and perhaps time) when the adverse event occurred.)
     */
    public AdverseEvent setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof Timing))
        throw new Error("Not the right type for AdverseEvent.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #detected} (Estimated or actual date the AdverseEvent began, in the opinion of the reporter.). This is the underlying object with id, value and extensions. The accessor "getDetected" gives direct access to the value
     */
    public DateTimeType getDetectedElement() { 
      if (this.detected == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.detected");
        else if (Configuration.doAutoCreate())
          this.detected = new DateTimeType(); // bb
      return this.detected;
    }

    public boolean hasDetectedElement() { 
      return this.detected != null && !this.detected.isEmpty();
    }

    public boolean hasDetected() { 
      return this.detected != null && !this.detected.isEmpty();
    }

    /**
     * @param value {@link #detected} (Estimated or actual date the AdverseEvent began, in the opinion of the reporter.). This is the underlying object with id, value and extensions. The accessor "getDetected" gives direct access to the value
     */
    public AdverseEvent setDetectedElement(DateTimeType value) { 
      this.detected = value;
      return this;
    }

    /**
     * @return Estimated or actual date the AdverseEvent began, in the opinion of the reporter.
     */
    public Date getDetected() { 
      return this.detected == null ? null : this.detected.getValue();
    }

    /**
     * @param value Estimated or actual date the AdverseEvent began, in the opinion of the reporter.
     */
    public AdverseEvent setDetected(Date value) { 
      if (value == null)
        this.detected = null;
      else {
        if (this.detected == null)
          this.detected = new DateTimeType();
        this.detected.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #recordedDate} (The date on which the existence of the AdverseEvent was first recorded.). This is the underlying object with id, value and extensions. The accessor "getRecordedDate" gives direct access to the value
     */
    public DateTimeType getRecordedDateElement() { 
      if (this.recordedDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.recordedDate");
        else if (Configuration.doAutoCreate())
          this.recordedDate = new DateTimeType(); // bb
      return this.recordedDate;
    }

    public boolean hasRecordedDateElement() { 
      return this.recordedDate != null && !this.recordedDate.isEmpty();
    }

    public boolean hasRecordedDate() { 
      return this.recordedDate != null && !this.recordedDate.isEmpty();
    }

    /**
     * @param value {@link #recordedDate} (The date on which the existence of the AdverseEvent was first recorded.). This is the underlying object with id, value and extensions. The accessor "getRecordedDate" gives direct access to the value
     */
    public AdverseEvent setRecordedDateElement(DateTimeType value) { 
      this.recordedDate = value;
      return this;
    }

    /**
     * @return The date on which the existence of the AdverseEvent was first recorded.
     */
    public Date getRecordedDate() { 
      return this.recordedDate == null ? null : this.recordedDate.getValue();
    }

    /**
     * @param value The date on which the existence of the AdverseEvent was first recorded.
     */
    public AdverseEvent setRecordedDate(Date value) { 
      if (value == null)
        this.recordedDate = null;
      else {
        if (this.recordedDate == null)
          this.recordedDate = new DateTimeType();
        this.recordedDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #resultingCondition} (Includes information about the reaction that occurred as a result of exposure to a substance (for example, a drug or a chemical).)
     */
    public List<Reference> getResultingCondition() { 
      if (this.resultingCondition == null)
        this.resultingCondition = new ArrayList<Reference>();
      return this.resultingCondition;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setResultingCondition(List<Reference> theResultingCondition) { 
      this.resultingCondition = theResultingCondition;
      return this;
    }

    public boolean hasResultingCondition() { 
      if (this.resultingCondition == null)
        return false;
      for (Reference item : this.resultingCondition)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addResultingCondition() { //3
      Reference t = new Reference();
      if (this.resultingCondition == null)
        this.resultingCondition = new ArrayList<Reference>();
      this.resultingCondition.add(t);
      return t;
    }

    public AdverseEvent addResultingCondition(Reference t) { //3
      if (t == null)
        return this;
      if (this.resultingCondition == null)
        this.resultingCondition = new ArrayList<Reference>();
      this.resultingCondition.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #resultingCondition}, creating it if it does not already exist {3}
     */
    public Reference getResultingConditionFirstRep() { 
      if (getResultingCondition().isEmpty()) {
        addResultingCondition();
      }
      return getResultingCondition().get(0);
    }

    /**
     * @return {@link #location} (The information about where the adverse event occurred.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (The information about where the adverse event occurred.)
     */
    public AdverseEvent setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #seriousness} (Assessment whether this event, or averted event, was of clinical importance.)
     */
    public CodeableConcept getSeriousness() { 
      if (this.seriousness == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.seriousness");
        else if (Configuration.doAutoCreate())
          this.seriousness = new CodeableConcept(); // cc
      return this.seriousness;
    }

    public boolean hasSeriousness() { 
      return this.seriousness != null && !this.seriousness.isEmpty();
    }

    /**
     * @param value {@link #seriousness} (Assessment whether this event, or averted event, was of clinical importance.)
     */
    public AdverseEvent setSeriousness(CodeableConcept value) { 
      this.seriousness = value;
      return this;
    }

    /**
     * @return {@link #outcome} (Describes the type of outcome from the adverse event, such as resolved, recovering, ongoing, resolved-with-sequelae, or fatal.)
     */
    public CodeableConcept getOutcome() { 
      if (this.outcome == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.outcome");
        else if (Configuration.doAutoCreate())
          this.outcome = new CodeableConcept(); // cc
      return this.outcome;
    }

    public boolean hasOutcome() { 
      return this.outcome != null && !this.outcome.isEmpty();
    }

    /**
     * @param value {@link #outcome} (Describes the type of outcome from the adverse event, such as resolved, recovering, ongoing, resolved-with-sequelae, or fatal.)
     */
    public AdverseEvent setOutcome(CodeableConcept value) { 
      this.outcome = value;
      return this;
    }

    /**
     * @return {@link #recorder} (Information on who recorded the adverse event.  May be the patient or a practitioner.)
     */
    public Reference getRecorder() { 
      if (this.recorder == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create AdverseEvent.recorder");
        else if (Configuration.doAutoCreate())
          this.recorder = new Reference(); // cc
      return this.recorder;
    }

    public boolean hasRecorder() { 
      return this.recorder != null && !this.recorder.isEmpty();
    }

    /**
     * @param value {@link #recorder} (Information on who recorded the adverse event.  May be the patient or a practitioner.)
     */
    public AdverseEvent setRecorder(Reference value) { 
      this.recorder = value;
      return this;
    }

    /**
     * @return {@link #participant} (Indicates who or what participated in the adverse event and how they were involved.)
     */
    public List<AdverseEventParticipantComponent> getParticipant() { 
      if (this.participant == null)
        this.participant = new ArrayList<AdverseEventParticipantComponent>();
      return this.participant;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setParticipant(List<AdverseEventParticipantComponent> theParticipant) { 
      this.participant = theParticipant;
      return this;
    }

    public boolean hasParticipant() { 
      if (this.participant == null)
        return false;
      for (AdverseEventParticipantComponent item : this.participant)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AdverseEventParticipantComponent addParticipant() { //3
      AdverseEventParticipantComponent t = new AdverseEventParticipantComponent();
      if (this.participant == null)
        this.participant = new ArrayList<AdverseEventParticipantComponent>();
      this.participant.add(t);
      return t;
    }

    public AdverseEvent addParticipant(AdverseEventParticipantComponent t) { //3
      if (t == null)
        return this;
      if (this.participant == null)
        this.participant = new ArrayList<AdverseEventParticipantComponent>();
      this.participant.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
     */
    public AdverseEventParticipantComponent getParticipantFirstRep() { 
      if (getParticipant().isEmpty()) {
        addParticipant();
      }
      return getParticipant().get(0);
    }

    /**
     * @return {@link #suspectEntity} (Describes the entity that is suspected to have caused the adverse event.)
     */
    public List<AdverseEventSuspectEntityComponent> getSuspectEntity() { 
      if (this.suspectEntity == null)
        this.suspectEntity = new ArrayList<AdverseEventSuspectEntityComponent>();
      return this.suspectEntity;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setSuspectEntity(List<AdverseEventSuspectEntityComponent> theSuspectEntity) { 
      this.suspectEntity = theSuspectEntity;
      return this;
    }

    public boolean hasSuspectEntity() { 
      if (this.suspectEntity == null)
        return false;
      for (AdverseEventSuspectEntityComponent item : this.suspectEntity)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AdverseEventSuspectEntityComponent addSuspectEntity() { //3
      AdverseEventSuspectEntityComponent t = new AdverseEventSuspectEntityComponent();
      if (this.suspectEntity == null)
        this.suspectEntity = new ArrayList<AdverseEventSuspectEntityComponent>();
      this.suspectEntity.add(t);
      return t;
    }

    public AdverseEvent addSuspectEntity(AdverseEventSuspectEntityComponent t) { //3
      if (t == null)
        return this;
      if (this.suspectEntity == null)
        this.suspectEntity = new ArrayList<AdverseEventSuspectEntityComponent>();
      this.suspectEntity.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #suspectEntity}, creating it if it does not already exist {3}
     */
    public AdverseEventSuspectEntityComponent getSuspectEntityFirstRep() { 
      if (getSuspectEntity().isEmpty()) {
        addSuspectEntity();
      }
      return getSuspectEntity().get(0);
    }

    /**
     * @return {@link #contributingFactor} (The contributing factors suspected to have increased the probability or severity of the adverse event.)
     */
    public List<AdverseEventContributingFactorComponent> getContributingFactor() { 
      if (this.contributingFactor == null)
        this.contributingFactor = new ArrayList<AdverseEventContributingFactorComponent>();
      return this.contributingFactor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setContributingFactor(List<AdverseEventContributingFactorComponent> theContributingFactor) { 
      this.contributingFactor = theContributingFactor;
      return this;
    }

    public boolean hasContributingFactor() { 
      if (this.contributingFactor == null)
        return false;
      for (AdverseEventContributingFactorComponent item : this.contributingFactor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AdverseEventContributingFactorComponent addContributingFactor() { //3
      AdverseEventContributingFactorComponent t = new AdverseEventContributingFactorComponent();
      if (this.contributingFactor == null)
        this.contributingFactor = new ArrayList<AdverseEventContributingFactorComponent>();
      this.contributingFactor.add(t);
      return t;
    }

    public AdverseEvent addContributingFactor(AdverseEventContributingFactorComponent t) { //3
      if (t == null)
        return this;
      if (this.contributingFactor == null)
        this.contributingFactor = new ArrayList<AdverseEventContributingFactorComponent>();
      this.contributingFactor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contributingFactor}, creating it if it does not already exist {3}
     */
    public AdverseEventContributingFactorComponent getContributingFactorFirstRep() { 
      if (getContributingFactor().isEmpty()) {
        addContributingFactor();
      }
      return getContributingFactor().get(0);
    }

    /**
     * @return {@link #preventiveAction} (Preventive actions that contributed to avoiding the adverse event.)
     */
    public List<AdverseEventPreventiveActionComponent> getPreventiveAction() { 
      if (this.preventiveAction == null)
        this.preventiveAction = new ArrayList<AdverseEventPreventiveActionComponent>();
      return this.preventiveAction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setPreventiveAction(List<AdverseEventPreventiveActionComponent> thePreventiveAction) { 
      this.preventiveAction = thePreventiveAction;
      return this;
    }

    public boolean hasPreventiveAction() { 
      if (this.preventiveAction == null)
        return false;
      for (AdverseEventPreventiveActionComponent item : this.preventiveAction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AdverseEventPreventiveActionComponent addPreventiveAction() { //3
      AdverseEventPreventiveActionComponent t = new AdverseEventPreventiveActionComponent();
      if (this.preventiveAction == null)
        this.preventiveAction = new ArrayList<AdverseEventPreventiveActionComponent>();
      this.preventiveAction.add(t);
      return t;
    }

    public AdverseEvent addPreventiveAction(AdverseEventPreventiveActionComponent t) { //3
      if (t == null)
        return this;
      if (this.preventiveAction == null)
        this.preventiveAction = new ArrayList<AdverseEventPreventiveActionComponent>();
      this.preventiveAction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #preventiveAction}, creating it if it does not already exist {3}
     */
    public AdverseEventPreventiveActionComponent getPreventiveActionFirstRep() { 
      if (getPreventiveAction().isEmpty()) {
        addPreventiveAction();
      }
      return getPreventiveAction().get(0);
    }

    /**
     * @return {@link #mitigatingAction} (The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.)
     */
    public List<AdverseEventMitigatingActionComponent> getMitigatingAction() { 
      if (this.mitigatingAction == null)
        this.mitigatingAction = new ArrayList<AdverseEventMitigatingActionComponent>();
      return this.mitigatingAction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setMitigatingAction(List<AdverseEventMitigatingActionComponent> theMitigatingAction) { 
      this.mitigatingAction = theMitigatingAction;
      return this;
    }

    public boolean hasMitigatingAction() { 
      if (this.mitigatingAction == null)
        return false;
      for (AdverseEventMitigatingActionComponent item : this.mitigatingAction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AdverseEventMitigatingActionComponent addMitigatingAction() { //3
      AdverseEventMitigatingActionComponent t = new AdverseEventMitigatingActionComponent();
      if (this.mitigatingAction == null)
        this.mitigatingAction = new ArrayList<AdverseEventMitigatingActionComponent>();
      this.mitigatingAction.add(t);
      return t;
    }

    public AdverseEvent addMitigatingAction(AdverseEventMitigatingActionComponent t) { //3
      if (t == null)
        return this;
      if (this.mitigatingAction == null)
        this.mitigatingAction = new ArrayList<AdverseEventMitigatingActionComponent>();
      this.mitigatingAction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #mitigatingAction}, creating it if it does not already exist {3}
     */
    public AdverseEventMitigatingActionComponent getMitigatingActionFirstRep() { 
      if (getMitigatingAction().isEmpty()) {
        addMitigatingAction();
      }
      return getMitigatingAction().get(0);
    }

    /**
     * @return {@link #supportingInfo} (Supporting information relevant to the event.)
     */
    public List<AdverseEventSupportingInfoComponent> getSupportingInfo() { 
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<AdverseEventSupportingInfoComponent>();
      return this.supportingInfo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setSupportingInfo(List<AdverseEventSupportingInfoComponent> theSupportingInfo) { 
      this.supportingInfo = theSupportingInfo;
      return this;
    }

    public boolean hasSupportingInfo() { 
      if (this.supportingInfo == null)
        return false;
      for (AdverseEventSupportingInfoComponent item : this.supportingInfo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public AdverseEventSupportingInfoComponent addSupportingInfo() { //3
      AdverseEventSupportingInfoComponent t = new AdverseEventSupportingInfoComponent();
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<AdverseEventSupportingInfoComponent>();
      this.supportingInfo.add(t);
      return t;
    }

    public AdverseEvent addSupportingInfo(AdverseEventSupportingInfoComponent t) { //3
      if (t == null)
        return this;
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<AdverseEventSupportingInfoComponent>();
      this.supportingInfo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supportingInfo}, creating it if it does not already exist {3}
     */
    public AdverseEventSupportingInfoComponent getSupportingInfoFirstRep() { 
      if (getSupportingInfo().isEmpty()) {
        addSupportingInfo();
      }
      return getSupportingInfo().get(0);
    }

    /**
     * @return {@link #study} (The research study that the subject is enrolled in.)
     */
    public List<Reference> getStudy() { 
      if (this.study == null)
        this.study = new ArrayList<Reference>();
      return this.study;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public AdverseEvent setStudy(List<Reference> theStudy) { 
      this.study = theStudy;
      return this;
    }

    public boolean hasStudy() { 
      if (this.study == null)
        return false;
      for (Reference item : this.study)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addStudy() { //3
      Reference t = new Reference();
      if (this.study == null)
        this.study = new ArrayList<Reference>();
      this.study.add(t);
      return t;
    }

    public AdverseEvent addStudy(Reference t) { //3
      if (t == null)
        return this;
      if (this.study == null)
        this.study = new ArrayList<Reference>();
      this.study.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #study}, creating it if it does not already exist {3}
     */
    public Reference getStudyFirstRep() { 
      if (getStudy().isEmpty()) {
        addStudy();
      }
      return getStudy().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this adverse event by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The current state of the adverse event or potential adverse event.", 0, 1, status));
        children.add(new Property("actuality", "code", "Whether the event actually happened, or just had the potential to. Note that this is independent of whether anyone was affected or harmed or how severely.", 0, 1, actuality));
        children.add(new Property("category", "CodeableConcept", "The overall type of event, intended for search and filtering purposes.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("code", "CodeableConcept", "Specific event that occurred or that was averted, such as patient fall, wrong organ removed, or wrong blood transfused.", 0, 1, code));
        children.add(new Property("subject", "Reference(Patient|Group|Practitioner|RelatedPerson)", "This subject or group impacted by the event.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The Encounter associated with the start of the AdverseEvent.", 0, 1, encounter));
        children.add(new Property("occurrence[x]", "dateTime|Period|Timing", "The date (and perhaps time) when the adverse event occurred.", 0, 1, occurrence));
        children.add(new Property("detected", "dateTime", "Estimated or actual date the AdverseEvent began, in the opinion of the reporter.", 0, 1, detected));
        children.add(new Property("recordedDate", "dateTime", "The date on which the existence of the AdverseEvent was first recorded.", 0, 1, recordedDate));
        children.add(new Property("resultingCondition", "Reference(Condition)", "Includes information about the reaction that occurred as a result of exposure to a substance (for example, a drug or a chemical).", 0, java.lang.Integer.MAX_VALUE, resultingCondition));
        children.add(new Property("location", "Reference(Location)", "The information about where the adverse event occurred.", 0, 1, location));
        children.add(new Property("seriousness", "CodeableConcept", "Assessment whether this event, or averted event, was of clinical importance.", 0, 1, seriousness));
        children.add(new Property("outcome", "CodeableConcept", "Describes the type of outcome from the adverse event, such as resolved, recovering, ongoing, resolved-with-sequelae, or fatal.", 0, 1, outcome));
        children.add(new Property("recorder", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson)", "Information on who recorded the adverse event.  May be the patient or a practitioner.", 0, 1, recorder));
        children.add(new Property("participant", "", "Indicates who or what participated in the adverse event and how they were involved.", 0, java.lang.Integer.MAX_VALUE, participant));
        children.add(new Property("suspectEntity", "", "Describes the entity that is suspected to have caused the adverse event.", 0, java.lang.Integer.MAX_VALUE, suspectEntity));
        children.add(new Property("contributingFactor", "", "The contributing factors suspected to have increased the probability or severity of the adverse event.", 0, java.lang.Integer.MAX_VALUE, contributingFactor));
        children.add(new Property("preventiveAction", "", "Preventive actions that contributed to avoiding the adverse event.", 0, java.lang.Integer.MAX_VALUE, preventiveAction));
        children.add(new Property("mitigatingAction", "", "The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.", 0, java.lang.Integer.MAX_VALUE, mitigatingAction));
        children.add(new Property("supportingInfo", "", "Supporting information relevant to the event.", 0, java.lang.Integer.MAX_VALUE, supportingInfo));
        children.add(new Property("study", "Reference(ResearchStudy)", "The research study that the subject is enrolled in.", 0, java.lang.Integer.MAX_VALUE, study));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this adverse event by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the adverse event or potential adverse event.", 0, 1, status);
        case 528866400: /*actuality*/  return new Property("actuality", "code", "Whether the event actually happened, or just had the potential to. Note that this is independent of whether anyone was affected or harmed or how severely.", 0, 1, actuality);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "The overall type of event, intended for search and filtering purposes.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Specific event that occurred or that was averted, such as patient fall, wrong organ removed, or wrong blood transfused.", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Practitioner|RelatedPerson)", "This subject or group impacted by the event.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The Encounter associated with the start of the AdverseEvent.", 0, 1, encounter);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "The date (and perhaps time) when the adverse event occurred.", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "The date (and perhaps time) when the adverse event occurred.", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "The date (and perhaps time) when the adverse event occurred.", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "The date (and perhaps time) when the adverse event occurred.", 0, 1, occurrence);
        case 1515218299: /*occurrenceTiming*/  return new Property("occurrence[x]", "Timing", "The date (and perhaps time) when the adverse event occurred.", 0, 1, occurrence);
        case 1048254082: /*detected*/  return new Property("detected", "dateTime", "Estimated or actual date the AdverseEvent began, in the opinion of the reporter.", 0, 1, detected);
        case -1952893826: /*recordedDate*/  return new Property("recordedDate", "dateTime", "The date on which the existence of the AdverseEvent was first recorded.", 0, 1, recordedDate);
        case -830261258: /*resultingCondition*/  return new Property("resultingCondition", "Reference(Condition)", "Includes information about the reaction that occurred as a result of exposure to a substance (for example, a drug or a chemical).", 0, java.lang.Integer.MAX_VALUE, resultingCondition);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The information about where the adverse event occurred.", 0, 1, location);
        case -1551003909: /*seriousness*/  return new Property("seriousness", "CodeableConcept", "Assessment whether this event, or averted event, was of clinical importance.", 0, 1, seriousness);
        case -1106507950: /*outcome*/  return new Property("outcome", "CodeableConcept", "Describes the type of outcome from the adverse event, such as resolved, recovering, ongoing, resolved-with-sequelae, or fatal.", 0, 1, outcome);
        case -799233858: /*recorder*/  return new Property("recorder", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson)", "Information on who recorded the adverse event.  May be the patient or a practitioner.", 0, 1, recorder);
        case 767422259: /*participant*/  return new Property("participant", "", "Indicates who or what participated in the adverse event and how they were involved.", 0, java.lang.Integer.MAX_VALUE, participant);
        case -1957422662: /*suspectEntity*/  return new Property("suspectEntity", "", "Describes the entity that is suspected to have caused the adverse event.", 0, java.lang.Integer.MAX_VALUE, suspectEntity);
        case -219647527: /*contributingFactor*/  return new Property("contributingFactor", "", "The contributing factors suspected to have increased the probability or severity of the adverse event.", 0, java.lang.Integer.MAX_VALUE, contributingFactor);
        case 2052341334: /*preventiveAction*/  return new Property("preventiveAction", "", "Preventive actions that contributed to avoiding the adverse event.", 0, java.lang.Integer.MAX_VALUE, preventiveAction);
        case 1992862383: /*mitigatingAction*/  return new Property("mitigatingAction", "", "The ameliorating action taken after the adverse event occured in order to reduce the extent of harm.", 0, java.lang.Integer.MAX_VALUE, mitigatingAction);
        case 1922406657: /*supportingInfo*/  return new Property("supportingInfo", "", "Supporting information relevant to the event.", 0, java.lang.Integer.MAX_VALUE, supportingInfo);
        case 109776329: /*study*/  return new Property("study", "Reference(ResearchStudy)", "The research study that the subject is enrolled in.", 0, java.lang.Integer.MAX_VALUE, study);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<AdverseEventStatus>
        case 528866400: /*actuality*/ return this.actuality == null ? new Base[0] : new Base[] {this.actuality}; // Enumeration<AdverseEventActuality>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case 1048254082: /*detected*/ return this.detected == null ? new Base[0] : new Base[] {this.detected}; // DateTimeType
        case -1952893826: /*recordedDate*/ return this.recordedDate == null ? new Base[0] : new Base[] {this.recordedDate}; // DateTimeType
        case -830261258: /*resultingCondition*/ return this.resultingCondition == null ? new Base[0] : this.resultingCondition.toArray(new Base[this.resultingCondition.size()]); // Reference
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -1551003909: /*seriousness*/ return this.seriousness == null ? new Base[0] : new Base[] {this.seriousness}; // CodeableConcept
        case -1106507950: /*outcome*/ return this.outcome == null ? new Base[0] : new Base[] {this.outcome}; // CodeableConcept
        case -799233858: /*recorder*/ return this.recorder == null ? new Base[0] : new Base[] {this.recorder}; // Reference
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // AdverseEventParticipantComponent
        case -1957422662: /*suspectEntity*/ return this.suspectEntity == null ? new Base[0] : this.suspectEntity.toArray(new Base[this.suspectEntity.size()]); // AdverseEventSuspectEntityComponent
        case -219647527: /*contributingFactor*/ return this.contributingFactor == null ? new Base[0] : this.contributingFactor.toArray(new Base[this.contributingFactor.size()]); // AdverseEventContributingFactorComponent
        case 2052341334: /*preventiveAction*/ return this.preventiveAction == null ? new Base[0] : this.preventiveAction.toArray(new Base[this.preventiveAction.size()]); // AdverseEventPreventiveActionComponent
        case 1992862383: /*mitigatingAction*/ return this.mitigatingAction == null ? new Base[0] : this.mitigatingAction.toArray(new Base[this.mitigatingAction.size()]); // AdverseEventMitigatingActionComponent
        case 1922406657: /*supportingInfo*/ return this.supportingInfo == null ? new Base[0] : this.supportingInfo.toArray(new Base[this.supportingInfo.size()]); // AdverseEventSupportingInfoComponent
        case 109776329: /*study*/ return this.study == null ? new Base[0] : this.study.toArray(new Base[this.study.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new AdverseEventStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<AdverseEventStatus>
          return value;
        case 528866400: // actuality
          value = new AdverseEventActualityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.actuality = (Enumeration) value; // Enumeration<AdverseEventActuality>
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1687874001: // occurrence
          this.occurrence = TypeConvertor.castToType(value); // DataType
          return value;
        case 1048254082: // detected
          this.detected = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1952893826: // recordedDate
          this.recordedDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -830261258: // resultingCondition
          this.getResultingCondition().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1551003909: // seriousness
          this.seriousness = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1106507950: // outcome
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -799233858: // recorder
          this.recorder = TypeConvertor.castToReference(value); // Reference
          return value;
        case 767422259: // participant
          this.getParticipant().add((AdverseEventParticipantComponent) value); // AdverseEventParticipantComponent
          return value;
        case -1957422662: // suspectEntity
          this.getSuspectEntity().add((AdverseEventSuspectEntityComponent) value); // AdverseEventSuspectEntityComponent
          return value;
        case -219647527: // contributingFactor
          this.getContributingFactor().add((AdverseEventContributingFactorComponent) value); // AdverseEventContributingFactorComponent
          return value;
        case 2052341334: // preventiveAction
          this.getPreventiveAction().add((AdverseEventPreventiveActionComponent) value); // AdverseEventPreventiveActionComponent
          return value;
        case 1992862383: // mitigatingAction
          this.getMitigatingAction().add((AdverseEventMitigatingActionComponent) value); // AdverseEventMitigatingActionComponent
          return value;
        case 1922406657: // supportingInfo
          this.getSupportingInfo().add((AdverseEventSupportingInfoComponent) value); // AdverseEventSupportingInfoComponent
          return value;
        case 109776329: // study
          this.getStudy().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new AdverseEventStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<AdverseEventStatus>
        } else if (name.equals("actuality")) {
          value = new AdverseEventActualityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.actuality = (Enumeration) value; // Enumeration<AdverseEventActuality>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("detected")) {
          this.detected = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("recordedDate")) {
          this.recordedDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("resultingCondition")) {
          this.getResultingCondition().add(TypeConvertor.castToReference(value));
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("seriousness")) {
          this.seriousness = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("outcome")) {
          this.outcome = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("recorder")) {
          this.recorder = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("participant")) {
          this.getParticipant().add((AdverseEventParticipantComponent) value);
        } else if (name.equals("suspectEntity")) {
          this.getSuspectEntity().add((AdverseEventSuspectEntityComponent) value);
        } else if (name.equals("contributingFactor")) {
          this.getContributingFactor().add((AdverseEventContributingFactorComponent) value);
        } else if (name.equals("preventiveAction")) {
          this.getPreventiveAction().add((AdverseEventPreventiveActionComponent) value);
        } else if (name.equals("mitigatingAction")) {
          this.getMitigatingAction().add((AdverseEventMitigatingActionComponent) value);
        } else if (name.equals("supportingInfo")) {
          this.getSupportingInfo().add((AdverseEventSupportingInfoComponent) value);
        } else if (name.equals("study")) {
          this.getStudy().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 528866400:  return getActualityElement();
        case 50511102:  return addCategory(); 
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case 1048254082:  return getDetectedElement();
        case -1952893826:  return getRecordedDateElement();
        case -830261258:  return addResultingCondition(); 
        case 1901043637:  return getLocation();
        case -1551003909:  return getSeriousness();
        case -1106507950:  return getOutcome();
        case -799233858:  return getRecorder();
        case 767422259:  return addParticipant(); 
        case -1957422662:  return addSuspectEntity(); 
        case -219647527:  return addContributingFactor(); 
        case 2052341334:  return addPreventiveAction(); 
        case 1992862383:  return addMitigatingAction(); 
        case 1922406657:  return addSupportingInfo(); 
        case 109776329:  return addStudy(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 528866400: /*actuality*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period", "Timing"};
        case 1048254082: /*detected*/ return new String[] {"dateTime"};
        case -1952893826: /*recordedDate*/ return new String[] {"dateTime"};
        case -830261258: /*resultingCondition*/ return new String[] {"Reference"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -1551003909: /*seriousness*/ return new String[] {"CodeableConcept"};
        case -1106507950: /*outcome*/ return new String[] {"CodeableConcept"};
        case -799233858: /*recorder*/ return new String[] {"Reference"};
        case 767422259: /*participant*/ return new String[] {};
        case -1957422662: /*suspectEntity*/ return new String[] {};
        case -219647527: /*contributingFactor*/ return new String[] {};
        case 2052341334: /*preventiveAction*/ return new String[] {};
        case 1992862383: /*mitigatingAction*/ return new String[] {};
        case 1922406657: /*supportingInfo*/ return new String[] {};
        case 109776329: /*study*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type AdverseEvent.status");
        }
        else if (name.equals("actuality")) {
          throw new FHIRException("Cannot call addChild on a primitive type AdverseEvent.actuality");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("occurrenceDateTime")) {
          this.occurrence = new DateTimeType();
          return this.occurrence;
        }
        else if (name.equals("occurrencePeriod")) {
          this.occurrence = new Period();
          return this.occurrence;
        }
        else if (name.equals("occurrenceTiming")) {
          this.occurrence = new Timing();
          return this.occurrence;
        }
        else if (name.equals("detected")) {
          throw new FHIRException("Cannot call addChild on a primitive type AdverseEvent.detected");
        }
        else if (name.equals("recordedDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type AdverseEvent.recordedDate");
        }
        else if (name.equals("resultingCondition")) {
          return addResultingCondition();
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("seriousness")) {
          this.seriousness = new CodeableConcept();
          return this.seriousness;
        }
        else if (name.equals("outcome")) {
          this.outcome = new CodeableConcept();
          return this.outcome;
        }
        else if (name.equals("recorder")) {
          this.recorder = new Reference();
          return this.recorder;
        }
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("suspectEntity")) {
          return addSuspectEntity();
        }
        else if (name.equals("contributingFactor")) {
          return addContributingFactor();
        }
        else if (name.equals("preventiveAction")) {
          return addPreventiveAction();
        }
        else if (name.equals("mitigatingAction")) {
          return addMitigatingAction();
        }
        else if (name.equals("supportingInfo")) {
          return addSupportingInfo();
        }
        else if (name.equals("study")) {
          return addStudy();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "AdverseEvent";

  }

      public AdverseEvent copy() {
        AdverseEvent dst = new AdverseEvent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(AdverseEvent dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.actuality = actuality == null ? null : actuality.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        dst.detected = detected == null ? null : detected.copy();
        dst.recordedDate = recordedDate == null ? null : recordedDate.copy();
        if (resultingCondition != null) {
          dst.resultingCondition = new ArrayList<Reference>();
          for (Reference i : resultingCondition)
            dst.resultingCondition.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        dst.seriousness = seriousness == null ? null : seriousness.copy();
        dst.outcome = outcome == null ? null : outcome.copy();
        dst.recorder = recorder == null ? null : recorder.copy();
        if (participant != null) {
          dst.participant = new ArrayList<AdverseEventParticipantComponent>();
          for (AdverseEventParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        if (suspectEntity != null) {
          dst.suspectEntity = new ArrayList<AdverseEventSuspectEntityComponent>();
          for (AdverseEventSuspectEntityComponent i : suspectEntity)
            dst.suspectEntity.add(i.copy());
        };
        if (contributingFactor != null) {
          dst.contributingFactor = new ArrayList<AdverseEventContributingFactorComponent>();
          for (AdverseEventContributingFactorComponent i : contributingFactor)
            dst.contributingFactor.add(i.copy());
        };
        if (preventiveAction != null) {
          dst.preventiveAction = new ArrayList<AdverseEventPreventiveActionComponent>();
          for (AdverseEventPreventiveActionComponent i : preventiveAction)
            dst.preventiveAction.add(i.copy());
        };
        if (mitigatingAction != null) {
          dst.mitigatingAction = new ArrayList<AdverseEventMitigatingActionComponent>();
          for (AdverseEventMitigatingActionComponent i : mitigatingAction)
            dst.mitigatingAction.add(i.copy());
        };
        if (supportingInfo != null) {
          dst.supportingInfo = new ArrayList<AdverseEventSupportingInfoComponent>();
          for (AdverseEventSupportingInfoComponent i : supportingInfo)
            dst.supportingInfo.add(i.copy());
        };
        if (study != null) {
          dst.study = new ArrayList<Reference>();
          for (Reference i : study)
            dst.study.add(i.copy());
        };
      }

      protected AdverseEvent typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof AdverseEvent))
          return false;
        AdverseEvent o = (AdverseEvent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(actuality, o.actuality, true)
           && compareDeep(category, o.category, true) && compareDeep(code, o.code, true) && compareDeep(subject, o.subject, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(occurrence, o.occurrence, true) && compareDeep(detected, o.detected, true)
           && compareDeep(recordedDate, o.recordedDate, true) && compareDeep(resultingCondition, o.resultingCondition, true)
           && compareDeep(location, o.location, true) && compareDeep(seriousness, o.seriousness, true) && compareDeep(outcome, o.outcome, true)
           && compareDeep(recorder, o.recorder, true) && compareDeep(participant, o.participant, true) && compareDeep(suspectEntity, o.suspectEntity, true)
           && compareDeep(contributingFactor, o.contributingFactor, true) && compareDeep(preventiveAction, o.preventiveAction, true)
           && compareDeep(mitigatingAction, o.mitigatingAction, true) && compareDeep(supportingInfo, o.supportingInfo, true)
           && compareDeep(study, o.study, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof AdverseEvent))
          return false;
        AdverseEvent o = (AdverseEvent) other_;
        return compareValues(status, o.status, true) && compareValues(actuality, o.actuality, true) && compareValues(detected, o.detected, true)
           && compareValues(recordedDate, o.recordedDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, actuality
          , category, code, subject, encounter, occurrence, detected, recordedDate, resultingCondition
          , location, seriousness, outcome, recorder, participant, suspectEntity, contributingFactor
          , preventiveAction, mitigatingAction, supportingInfo, study);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.AdverseEvent;
   }

 /**
   * Search parameter: <b>actuality</b>
   * <p>
   * Description: <b>actual | potential</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.actuality</b><br>
   * </p>
   */
  @SearchParamDefinition(name="actuality", path="AdverseEvent.actuality", description="actual | potential", type="token" )
  public static final String SP_ACTUALITY = "actuality";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>actuality</b>
   * <p>
   * Description: <b>actual | potential</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.actuality</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ACTUALITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ACTUALITY);

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>wrong-patient | procedure-mishap | medication-mishap | device | unsafe-physical-environment | hospital-aquired-infection | wrong-body-site</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="AdverseEvent.category", description="wrong-patient | procedure-mishap | medication-mishap | device | unsafe-physical-environment | hospital-aquired-infection | wrong-body-site", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>wrong-patient | procedure-mishap | medication-mishap | device | unsafe-physical-environment | hospital-aquired-infection | wrong-body-site</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Event or incident that occurred or was averted</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AdverseEvent.code", description="Event or incident that occurred or was averted", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Event or incident that occurred or was averted</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>When the event occurred</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AdverseEvent.occurrence", description="When the event occurred", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>When the event occurred</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="AdverseEvent.identifier", description="Business identifier for the event", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>location</b>
   * <p>
   * Description: <b>Location where adverse event occurred</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.location</b><br>
   * </p>
   */
  @SearchParamDefinition(name="location", path="AdverseEvent.location", description="Location where adverse event occurred", type="reference", target={Location.class } )
  public static final String SP_LOCATION = "location";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>location</b>
   * <p>
   * Description: <b>Location where adverse event occurred</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.location</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam LOCATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_LOCATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdverseEvent:location</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_LOCATION = new ca.uhn.fhir.model.api.Include("AdverseEvent:location").toLocked();

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Subject impacted by event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AdverseEvent.subject", description="Subject impacted by event", type="reference", target={Group.class, Patient.class, Practitioner.class, RelatedPerson.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Subject impacted by event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdverseEvent:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("AdverseEvent:patient").toLocked();

 /**
   * Search parameter: <b>recorder</b>
   * <p>
   * Description: <b>Who recorded the adverse event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.recorder</b><br>
   * </p>
   */
  @SearchParamDefinition(name="recorder", path="AdverseEvent.recorder", description="Who recorded the adverse event", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_RECORDER = "recorder";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>recorder</b>
   * <p>
   * Description: <b>Who recorded the adverse event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.recorder</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RECORDER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RECORDER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdverseEvent:recorder</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RECORDER = new ca.uhn.fhir.model.api.Include("AdverseEvent:recorder").toLocked();

 /**
   * Search parameter: <b>resultingcondition</b>
   * <p>
   * Description: <b>Effect on the subject due to this event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.resultingCondition</b><br>
   * </p>
   */
  @SearchParamDefinition(name="resultingcondition", path="AdverseEvent.resultingCondition", description="Effect on the subject due to this event", type="reference", target={Condition.class } )
  public static final String SP_RESULTINGCONDITION = "resultingcondition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>resultingcondition</b>
   * <p>
   * Description: <b>Effect on the subject due to this event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.resultingCondition</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RESULTINGCONDITION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_RESULTINGCONDITION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdverseEvent:resultingcondition</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RESULTINGCONDITION = new ca.uhn.fhir.model.api.Include("AdverseEvent:resultingcondition").toLocked();

 /**
   * Search parameter: <b>seriousness</b>
   * <p>
   * Description: <b>Seriousness or gravity of the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.seriousness</b><br>
   * </p>
   */
  @SearchParamDefinition(name="seriousness", path="AdverseEvent.seriousness", description="Seriousness or gravity of the event", type="token" )
  public static final String SP_SERIOUSNESS = "seriousness";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>seriousness</b>
   * <p>
   * Description: <b>Seriousness or gravity of the event</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.seriousness</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SERIOUSNESS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SERIOUSNESS);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>in-progress | completed | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="AdverseEvent.status", description="in-progress | completed | entered-in-error | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>in-progress | completed | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>study</b>
   * <p>
   * Description: <b>Research study that the subject is enrolled in</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.study</b><br>
   * </p>
   */
  @SearchParamDefinition(name="study", path="AdverseEvent.study", description="Research study that the subject is enrolled in", type="reference", target={ResearchStudy.class } )
  public static final String SP_STUDY = "study";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>study</b>
   * <p>
   * Description: <b>Research study that the subject is enrolled in</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.study</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam STUDY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_STUDY);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdverseEvent:study</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_STUDY = new ca.uhn.fhir.model.api.Include("AdverseEvent:study").toLocked();

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Subject impacted by event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="AdverseEvent.subject", description="Subject impacted by event", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class, Practitioner.class, RelatedPerson.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Subject impacted by event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AdverseEvent.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdverseEvent:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("AdverseEvent:subject").toLocked();

 /**
   * Search parameter: <b>substance</b>
   * <p>
   * Description: <b>Refers to the specific entity that caused the adverse event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(AdverseEvent.suspectEntity.instance as Reference)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="substance", path="(AdverseEvent.suspectEntity.instance as Reference)", description="Refers to the specific entity that caused the adverse event", type="reference", target={Device.class, Immunization.class, Medication.class, MedicationAdministration.class, MedicationUsage.class, Procedure.class, Substance.class } )
  public static final String SP_SUBSTANCE = "substance";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>substance</b>
   * <p>
   * Description: <b>Refers to the specific entity that caused the adverse event</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(AdverseEvent.suspectEntity.instance as Reference)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBSTANCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBSTANCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>AdverseEvent:substance</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBSTANCE = new ca.uhn.fhir.model.api.Include("AdverseEvent:substance").toLocked();


}