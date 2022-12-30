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

// Generated on Tue, Dec 13, 2022 17:53+1100 for FHIR vcurrent

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
 * A record of a device being used by a patient where the record is the result of a report from the patient or a clinician.
 */
@ResourceDef(name="DeviceUsage", profile="http://hl7.org/fhir/StructureDefinition/DeviceUsage")
public class DeviceUsage extends DomainResource {

    public enum DeviceUsageStatus {
        /**
         * The device is still being used.
         */
        ACTIVE, 
        /**
         * The device is no longer being used.
         */
        COMPLETED, 
        /**
         * The device was not used.
         */
        NOTDONE, 
        /**
         * The statement was recorded incorrectly.
         */
        ENTEREDINERROR, 
        /**
         * The device may be used at some time in the future.
         */
        INTENDED, 
        /**
         * Actions implied by the statement have been permanently halted, before all of them occurred.
         */
        STOPPED, 
        /**
         * Actions implied by the statement have been temporarily halted, but are expected to continue later. May also be called \"suspended\".
         */
        ONHOLD, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static DeviceUsageStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("not-done".equals(codeString))
          return NOTDONE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("intended".equals(codeString))
          return INTENDED;
        if ("stopped".equals(codeString))
          return STOPPED;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown DeviceUsageStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case COMPLETED: return "completed";
            case NOTDONE: return "not-done";
            case ENTEREDINERROR: return "entered-in-error";
            case INTENDED: return "intended";
            case STOPPED: return "stopped";
            case ONHOLD: return "on-hold";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/deviceusage-status";
            case COMPLETED: return "http://hl7.org/fhir/deviceusage-status";
            case NOTDONE: return "http://hl7.org/fhir/deviceusage-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/deviceusage-status";
            case INTENDED: return "http://hl7.org/fhir/deviceusage-status";
            case STOPPED: return "http://hl7.org/fhir/deviceusage-status";
            case ONHOLD: return "http://hl7.org/fhir/deviceusage-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The device is still being used.";
            case COMPLETED: return "The device is no longer being used.";
            case NOTDONE: return "The device was not used.";
            case ENTEREDINERROR: return "The statement was recorded incorrectly.";
            case INTENDED: return "The device may be used at some time in the future.";
            case STOPPED: return "Actions implied by the statement have been permanently halted, before all of them occurred.";
            case ONHOLD: return "Actions implied by the statement have been temporarily halted, but are expected to continue later. May also be called \"suspended\".";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case COMPLETED: return "Completed";
            case NOTDONE: return "Not done";
            case ENTEREDINERROR: return "Entered in Error";
            case INTENDED: return "Intended";
            case STOPPED: return "Stopped";
            case ONHOLD: return "On Hold";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class DeviceUsageStatusEnumFactory implements EnumFactory<DeviceUsageStatus> {
    public DeviceUsageStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return DeviceUsageStatus.ACTIVE;
        if ("completed".equals(codeString))
          return DeviceUsageStatus.COMPLETED;
        if ("not-done".equals(codeString))
          return DeviceUsageStatus.NOTDONE;
        if ("entered-in-error".equals(codeString))
          return DeviceUsageStatus.ENTEREDINERROR;
        if ("intended".equals(codeString))
          return DeviceUsageStatus.INTENDED;
        if ("stopped".equals(codeString))
          return DeviceUsageStatus.STOPPED;
        if ("on-hold".equals(codeString))
          return DeviceUsageStatus.ONHOLD;
        throw new IllegalArgumentException("Unknown DeviceUsageStatus code '"+codeString+"'");
        }
        public Enumeration<DeviceUsageStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<DeviceUsageStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<DeviceUsageStatus>(this, DeviceUsageStatus.ACTIVE);
        if ("completed".equals(codeString))
          return new Enumeration<DeviceUsageStatus>(this, DeviceUsageStatus.COMPLETED);
        if ("not-done".equals(codeString))
          return new Enumeration<DeviceUsageStatus>(this, DeviceUsageStatus.NOTDONE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<DeviceUsageStatus>(this, DeviceUsageStatus.ENTEREDINERROR);
        if ("intended".equals(codeString))
          return new Enumeration<DeviceUsageStatus>(this, DeviceUsageStatus.INTENDED);
        if ("stopped".equals(codeString))
          return new Enumeration<DeviceUsageStatus>(this, DeviceUsageStatus.STOPPED);
        if ("on-hold".equals(codeString))
          return new Enumeration<DeviceUsageStatus>(this, DeviceUsageStatus.ONHOLD);
        throw new FHIRException("Unknown DeviceUsageStatus code '"+codeString+"'");
        }
    public String toCode(DeviceUsageStatus code) {
      if (code == DeviceUsageStatus.ACTIVE)
        return "active";
      if (code == DeviceUsageStatus.COMPLETED)
        return "completed";
      if (code == DeviceUsageStatus.NOTDONE)
        return "not-done";
      if (code == DeviceUsageStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == DeviceUsageStatus.INTENDED)
        return "intended";
      if (code == DeviceUsageStatus.STOPPED)
        return "stopped";
      if (code == DeviceUsageStatus.ONHOLD)
        return "on-hold";
      return "?";
      }
    public String toSystem(DeviceUsageStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class DeviceUsageAdherenceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Type of adherence.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="always | never | sometimes", formalDefinition="Type of adherence." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/deviceusage-adherence-code")
        protected CodeableConcept code;

        /**
         * Reason for adherence type.
         */
        @Child(name = "reason", type = {CodeableConcept.class}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="lost | stolen | prescribed | broken | burned | forgot", formalDefinition="Reason for adherence type." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/deviceusage-adherence-reason")
        protected List<CodeableConcept> reason;

        private static final long serialVersionUID = -1932336797L;

    /**
     * Constructor
     */
      public DeviceUsageAdherenceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DeviceUsageAdherenceComponent(CodeableConcept code, CodeableConcept reason) {
        super();
        this.setCode(code);
        this.addReason(reason);
      }

        /**
         * @return {@link #code} (Type of adherence.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DeviceUsageAdherenceComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Type of adherence.)
         */
        public DeviceUsageAdherenceComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #reason} (Reason for adherence type.)
         */
        public List<CodeableConcept> getReason() { 
          if (this.reason == null)
            this.reason = new ArrayList<CodeableConcept>();
          return this.reason;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public DeviceUsageAdherenceComponent setReason(List<CodeableConcept> theReason) { 
          this.reason = theReason;
          return this;
        }

        public boolean hasReason() { 
          if (this.reason == null)
            return false;
          for (CodeableConcept item : this.reason)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addReason() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.reason == null)
            this.reason = new ArrayList<CodeableConcept>();
          this.reason.add(t);
          return t;
        }

        public DeviceUsageAdherenceComponent addReason(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.reason == null)
            this.reason = new ArrayList<CodeableConcept>();
          this.reason.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
         */
        public CodeableConcept getReasonFirstRep() { 
          if (getReason().isEmpty()) {
            addReason();
          }
          return getReason().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "Type of adherence.", 0, 1, code));
          children.add(new Property("reason", "CodeableConcept", "Reason for adherence type.", 0, java.lang.Integer.MAX_VALUE, reason));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Type of adherence.", 0, 1, code);
          case -934964668: /*reason*/  return new Property("reason", "CodeableConcept", "Reason for adherence type.", 0, java.lang.Integer.MAX_VALUE, reason);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -934964668:  return addReason(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -934964668: /*reason*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else
          return super.addChild(name);
      }

      public DeviceUsageAdherenceComponent copy() {
        DeviceUsageAdherenceComponent dst = new DeviceUsageAdherenceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceUsageAdherenceComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : reason)
            dst.reason.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceUsageAdherenceComponent))
          return false;
        DeviceUsageAdherenceComponent o = (DeviceUsageAdherenceComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(reason, o.reason, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceUsageAdherenceComponent))
          return false;
        DeviceUsageAdherenceComponent o = (DeviceUsageAdherenceComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, reason);
      }

  public String fhirType() {
    return "DeviceUsage.adherence";

  }

  }

    /**
     * An external identifier for this statement such as an IRI.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External identifier for this record", formalDefinition="An external identifier for this statement such as an IRI." )
    protected List<Identifier> identifier;

    /**
     * A plan, proposal or order that is fulfilled in whole or in part by this DeviceUsage.
     */
    @Child(name = "basedOn", type = {ServiceRequest.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Fulfills plan, proposal or order", formalDefinition="A plan, proposal or order that is fulfilled in whole or in part by this DeviceUsage." )
    protected List<Reference> basedOn;

    /**
     * A code representing the patient or other source's judgment about the state of the device used that this statement is about.  Generally this will be active or completed.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | completed | not-done | entered-in-error +", formalDefinition="A code representing the patient or other source's judgment about the state of the device used that this statement is about.  Generally this will be active or completed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/deviceusage-status")
    protected Enumeration<DeviceUsageStatus> status;

    /**
     * This attribute indicates a category for the statement - The device statement may be made in an inpatient or outpatient settting (inpatient | outpatient | community | patientspecified).
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The category of the statement - classifying how the statement is made", formalDefinition="This attribute indicates a category for the statement - The device statement may be made in an inpatient or outpatient settting (inpatient | outpatient | community | patientspecified)." )
    protected List<CodeableConcept> category;

    /**
     * The patient who used the device.
     */
    @Child(name = "patient", type = {Patient.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Patient using device", formalDefinition="The patient who used the device." )
    protected Reference patient;

    /**
     * Allows linking the DeviceUsage to the underlying Request, or to other information that supports or is used to derive the DeviceUsage.
     */
    @Child(name = "derivedFrom", type = {ServiceRequest.class, Procedure.class, Claim.class, Observation.class, QuestionnaireResponse.class, DocumentReference.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Supporting information", formalDefinition="Allows linking the DeviceUsage to the underlying Request, or to other information that supports or is used to derive the DeviceUsage." )
    protected List<Reference> derivedFrom;

    /**
     * The encounter or episode of care that establishes the context for this device use statement.
     */
    @Child(name = "context", type = {Encounter.class, EpisodeOfCare.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The encounter or episode of care that establishes the context for this device use statement", formalDefinition="The encounter or episode of care that establishes the context for this device use statement." )
    protected Reference context;

    /**
     * How often the device was used.
     */
    @Child(name = "timing", type = {Timing.class, Period.class, DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How often  the device was used", formalDefinition="How often the device was used." )
    protected DataType timing;

    /**
     * The time at which the statement was recorded by informationSource.
     */
    @Child(name = "dateAsserted", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the statement was made (and recorded)", formalDefinition="The time at which the statement was recorded by informationSource." )
    protected DateTimeType dateAsserted;

    /**
     * The status of the device usage, for example always, sometimes, never. This is not the same as the status of the statement.
     */
    @Child(name = "usageStatus", type = {CodeableConcept.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The status of the device usage, for example always, sometimes, never. This is not the same as the status of the statement", formalDefinition="The status of the device usage, for example always, sometimes, never. This is not the same as the status of the statement." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/deviceusage-status")
    protected CodeableConcept usageStatus;

    /**
     * The reason for asserting the usage status - for example forgot, lost, stolen, broken.
     */
    @Child(name = "usageReason", type = {CodeableConcept.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The reason for asserting the usage status - for example forgot, lost, stolen, broken", formalDefinition="The reason for asserting the usage status - for example forgot, lost, stolen, broken." )
    protected List<CodeableConcept> usageReason;

    /**
     * This indicates how or if the device is being used.
     */
    @Child(name = "adherence", type = {}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="How device is being used", formalDefinition="This indicates how or if the device is being used." )
    protected DeviceUsageAdherenceComponent adherence;

    /**
     * Who reported the device was being used by the patient.
     */
    @Child(name = "informationSource", type = {Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Organization.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who made the statement", formalDefinition="Who reported the device was being used by the patient." )
    protected Reference informationSource;

    /**
     * Code or Reference to device used.
     */
    @Child(name = "device", type = {CodeableReference.class}, order=13, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Code or Reference to device used", formalDefinition="Code or Reference to device used." )
    protected CodeableReference device;

    /**
     * Reason or justification for the use of the device. A coded concept, or another resource whose existence justifies this DeviceUsage.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Why device was used", formalDefinition="Reason or justification for the use of the device. A coded concept, or another resource whose existence justifies this DeviceUsage." )
    protected List<CodeableReference> reason;

    /**
     * Indicates the anotomic location on the subject's body where the device was used ( i.e. the target).
     */
    @Child(name = "bodySite", type = {CodeableReference.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Target body site", formalDefinition="Indicates the anotomic location on the subject's body where the device was used ( i.e. the target)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected CodeableReference bodySite;

    /**
     * Details about the device statement that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement.
     */
    @Child(name = "note", type = {Annotation.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Addition details (comments, instructions)", formalDefinition="Details about the device statement that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement." )
    protected List<Annotation> note;

    private static final long serialVersionUID = -10803928L;

  /**
   * Constructor
   */
    public DeviceUsage() {
      super();
    }

  /**
   * Constructor
   */
    public DeviceUsage(DeviceUsageStatus status, Reference patient, CodeableReference device) {
      super();
      this.setStatus(status);
      this.setPatient(patient);
      this.setDevice(device);
    }

    /**
     * @return {@link #identifier} (An external identifier for this statement such as an IRI.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceUsage setIdentifier(List<Identifier> theIdentifier) { 
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

    public DeviceUsage addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (A plan, proposal or order that is fulfilled in whole or in part by this DeviceUsage.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceUsage setBasedOn(List<Reference> theBasedOn) { 
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

    public DeviceUsage addBasedOn(Reference t) { //3
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
     * @return {@link #status} (A code representing the patient or other source's judgment about the state of the device used that this statement is about.  Generally this will be active or completed.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<DeviceUsageStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceUsage.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<DeviceUsageStatus>(new DeviceUsageStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code representing the patient or other source's judgment about the state of the device used that this statement is about.  Generally this will be active or completed.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public DeviceUsage setStatusElement(Enumeration<DeviceUsageStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code representing the patient or other source's judgment about the state of the device used that this statement is about.  Generally this will be active or completed.
     */
    public DeviceUsageStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code representing the patient or other source's judgment about the state of the device used that this statement is about.  Generally this will be active or completed.
     */
    public DeviceUsage setStatus(DeviceUsageStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<DeviceUsageStatus>(new DeviceUsageStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #category} (This attribute indicates a category for the statement - The device statement may be made in an inpatient or outpatient settting (inpatient | outpatient | community | patientspecified).)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceUsage setCategory(List<CodeableConcept> theCategory) { 
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

    public DeviceUsage addCategory(CodeableConcept t) { //3
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
     * @return {@link #patient} (The patient who used the device.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceUsage.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (The patient who used the device.)
     */
    public DeviceUsage setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #derivedFrom} (Allows linking the DeviceUsage to the underlying Request, or to other information that supports or is used to derive the DeviceUsage.)
     */
    public List<Reference> getDerivedFrom() { 
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      return this.derivedFrom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceUsage setDerivedFrom(List<Reference> theDerivedFrom) { 
      this.derivedFrom = theDerivedFrom;
      return this;
    }

    public boolean hasDerivedFrom() { 
      if (this.derivedFrom == null)
        return false;
      for (Reference item : this.derivedFrom)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addDerivedFrom() { //3
      Reference t = new Reference();
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      this.derivedFrom.add(t);
      return t;
    }

    public DeviceUsage addDerivedFrom(Reference t) { //3
      if (t == null)
        return this;
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      this.derivedFrom.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #derivedFrom}, creating it if it does not already exist {3}
     */
    public Reference getDerivedFromFirstRep() { 
      if (getDerivedFrom().isEmpty()) {
        addDerivedFrom();
      }
      return getDerivedFrom().get(0);
    }

    /**
     * @return {@link #context} (The encounter or episode of care that establishes the context for this device use statement.)
     */
    public Reference getContext() { 
      if (this.context == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceUsage.context");
        else if (Configuration.doAutoCreate())
          this.context = new Reference(); // cc
      return this.context;
    }

    public boolean hasContext() { 
      return this.context != null && !this.context.isEmpty();
    }

    /**
     * @param value {@link #context} (The encounter or episode of care that establishes the context for this device use statement.)
     */
    public DeviceUsage setContext(Reference value) { 
      this.context = value;
      return this;
    }

    /**
     * @return {@link #timing} (How often the device was used.)
     */
    public DataType getTiming() { 
      return this.timing;
    }

    /**
     * @return {@link #timing} (How often the device was used.)
     */
    public Timing getTimingTiming() throws FHIRException { 
      if (this.timing == null)
        this.timing = new Timing();
      if (!(this.timing instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.timing.getClass().getName()+" was encountered");
      return (Timing) this.timing;
    }

    public boolean hasTimingTiming() { 
      return this != null && this.timing instanceof Timing;
    }

    /**
     * @return {@link #timing} (How often the device was used.)
     */
    public Period getTimingPeriod() throws FHIRException { 
      if (this.timing == null)
        this.timing = new Period();
      if (!(this.timing instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.timing.getClass().getName()+" was encountered");
      return (Period) this.timing;
    }

    public boolean hasTimingPeriod() { 
      return this != null && this.timing instanceof Period;
    }

    /**
     * @return {@link #timing} (How often the device was used.)
     */
    public DateTimeType getTimingDateTimeType() throws FHIRException { 
      if (this.timing == null)
        this.timing = new DateTimeType();
      if (!(this.timing instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.timing.getClass().getName()+" was encountered");
      return (DateTimeType) this.timing;
    }

    public boolean hasTimingDateTimeType() { 
      return this != null && this.timing instanceof DateTimeType;
    }

    public boolean hasTiming() { 
      return this.timing != null && !this.timing.isEmpty();
    }

    /**
     * @param value {@link #timing} (How often the device was used.)
     */
    public DeviceUsage setTiming(DataType value) { 
      if (value != null && !(value instanceof Timing || value instanceof Period || value instanceof DateTimeType))
        throw new Error("Not the right type for DeviceUsage.timing[x]: "+value.fhirType());
      this.timing = value;
      return this;
    }

    /**
     * @return {@link #dateAsserted} (The time at which the statement was recorded by informationSource.). This is the underlying object with id, value and extensions. The accessor "getDateAsserted" gives direct access to the value
     */
    public DateTimeType getDateAssertedElement() { 
      if (this.dateAsserted == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceUsage.dateAsserted");
        else if (Configuration.doAutoCreate())
          this.dateAsserted = new DateTimeType(); // bb
      return this.dateAsserted;
    }

    public boolean hasDateAssertedElement() { 
      return this.dateAsserted != null && !this.dateAsserted.isEmpty();
    }

    public boolean hasDateAsserted() { 
      return this.dateAsserted != null && !this.dateAsserted.isEmpty();
    }

    /**
     * @param value {@link #dateAsserted} (The time at which the statement was recorded by informationSource.). This is the underlying object with id, value and extensions. The accessor "getDateAsserted" gives direct access to the value
     */
    public DeviceUsage setDateAssertedElement(DateTimeType value) { 
      this.dateAsserted = value;
      return this;
    }

    /**
     * @return The time at which the statement was recorded by informationSource.
     */
    public Date getDateAsserted() { 
      return this.dateAsserted == null ? null : this.dateAsserted.getValue();
    }

    /**
     * @param value The time at which the statement was recorded by informationSource.
     */
    public DeviceUsage setDateAsserted(Date value) { 
      if (value == null)
        this.dateAsserted = null;
      else {
        if (this.dateAsserted == null)
          this.dateAsserted = new DateTimeType();
        this.dateAsserted.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #usageStatus} (The status of the device usage, for example always, sometimes, never. This is not the same as the status of the statement.)
     */
    public CodeableConcept getUsageStatus() { 
      if (this.usageStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceUsage.usageStatus");
        else if (Configuration.doAutoCreate())
          this.usageStatus = new CodeableConcept(); // cc
      return this.usageStatus;
    }

    public boolean hasUsageStatus() { 
      return this.usageStatus != null && !this.usageStatus.isEmpty();
    }

    /**
     * @param value {@link #usageStatus} (The status of the device usage, for example always, sometimes, never. This is not the same as the status of the statement.)
     */
    public DeviceUsage setUsageStatus(CodeableConcept value) { 
      this.usageStatus = value;
      return this;
    }

    /**
     * @return {@link #usageReason} (The reason for asserting the usage status - for example forgot, lost, stolen, broken.)
     */
    public List<CodeableConcept> getUsageReason() { 
      if (this.usageReason == null)
        this.usageReason = new ArrayList<CodeableConcept>();
      return this.usageReason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceUsage setUsageReason(List<CodeableConcept> theUsageReason) { 
      this.usageReason = theUsageReason;
      return this;
    }

    public boolean hasUsageReason() { 
      if (this.usageReason == null)
        return false;
      for (CodeableConcept item : this.usageReason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addUsageReason() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.usageReason == null)
        this.usageReason = new ArrayList<CodeableConcept>();
      this.usageReason.add(t);
      return t;
    }

    public DeviceUsage addUsageReason(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.usageReason == null)
        this.usageReason = new ArrayList<CodeableConcept>();
      this.usageReason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #usageReason}, creating it if it does not already exist {3}
     */
    public CodeableConcept getUsageReasonFirstRep() { 
      if (getUsageReason().isEmpty()) {
        addUsageReason();
      }
      return getUsageReason().get(0);
    }

    /**
     * @return {@link #adherence} (This indicates how or if the device is being used.)
     */
    public DeviceUsageAdherenceComponent getAdherence() { 
      if (this.adherence == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceUsage.adherence");
        else if (Configuration.doAutoCreate())
          this.adherence = new DeviceUsageAdherenceComponent(); // cc
      return this.adherence;
    }

    public boolean hasAdherence() { 
      return this.adherence != null && !this.adherence.isEmpty();
    }

    /**
     * @param value {@link #adherence} (This indicates how or if the device is being used.)
     */
    public DeviceUsage setAdherence(DeviceUsageAdherenceComponent value) { 
      this.adherence = value;
      return this;
    }

    /**
     * @return {@link #informationSource} (Who reported the device was being used by the patient.)
     */
    public Reference getInformationSource() { 
      if (this.informationSource == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceUsage.informationSource");
        else if (Configuration.doAutoCreate())
          this.informationSource = new Reference(); // cc
      return this.informationSource;
    }

    public boolean hasInformationSource() { 
      return this.informationSource != null && !this.informationSource.isEmpty();
    }

    /**
     * @param value {@link #informationSource} (Who reported the device was being used by the patient.)
     */
    public DeviceUsage setInformationSource(Reference value) { 
      this.informationSource = value;
      return this;
    }

    /**
     * @return {@link #device} (Code or Reference to device used.)
     */
    public CodeableReference getDevice() { 
      if (this.device == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceUsage.device");
        else if (Configuration.doAutoCreate())
          this.device = new CodeableReference(); // cc
      return this.device;
    }

    public boolean hasDevice() { 
      return this.device != null && !this.device.isEmpty();
    }

    /**
     * @param value {@link #device} (Code or Reference to device used.)
     */
    public DeviceUsage setDevice(CodeableReference value) { 
      this.device = value;
      return this;
    }

    /**
     * @return {@link #reason} (Reason or justification for the use of the device. A coded concept, or another resource whose existence justifies this DeviceUsage.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceUsage setReason(List<CodeableReference> theReason) { 
      this.reason = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reason == null)
        return false;
      for (CodeableReference item : this.reason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addReason() { //3
      CodeableReference t = new CodeableReference();
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return t;
    }

    public DeviceUsage addReason(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public CodeableReference getReasonFirstRep() { 
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
    }

    /**
     * @return {@link #bodySite} (Indicates the anotomic location on the subject's body where the device was used ( i.e. the target).)
     */
    public CodeableReference getBodySite() { 
      if (this.bodySite == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create DeviceUsage.bodySite");
        else if (Configuration.doAutoCreate())
          this.bodySite = new CodeableReference(); // cc
      return this.bodySite;
    }

    public boolean hasBodySite() { 
      return this.bodySite != null && !this.bodySite.isEmpty();
    }

    /**
     * @param value {@link #bodySite} (Indicates the anotomic location on the subject's body where the device was used ( i.e. the target).)
     */
    public DeviceUsage setBodySite(CodeableReference value) { 
      this.bodySite = value;
      return this;
    }

    /**
     * @return {@link #note} (Details about the device statement that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public DeviceUsage setNote(List<Annotation> theNote) { 
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

    public DeviceUsage addNote(Annotation t) { //3
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

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "An external identifier for this statement such as an IRI.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this DeviceUsage.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("status", "code", "A code representing the patient or other source's judgment about the state of the device used that this statement is about.  Generally this will be active or completed.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "This attribute indicates a category for the statement - The device statement may be made in an inpatient or outpatient settting (inpatient | outpatient | community | patientspecified).", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("patient", "Reference(Patient)", "The patient who used the device.", 0, 1, patient));
        children.add(new Property("derivedFrom", "Reference(ServiceRequest|Procedure|Claim|Observation|QuestionnaireResponse|DocumentReference)", "Allows linking the DeviceUsage to the underlying Request, or to other information that supports or is used to derive the DeviceUsage.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("context", "Reference(Encounter|EpisodeOfCare)", "The encounter or episode of care that establishes the context for this device use statement.", 0, 1, context));
        children.add(new Property("timing[x]", "Timing|Period|dateTime", "How often the device was used.", 0, 1, timing));
        children.add(new Property("dateAsserted", "dateTime", "The time at which the statement was recorded by informationSource.", 0, 1, dateAsserted));
        children.add(new Property("usageStatus", "CodeableConcept", "The status of the device usage, for example always, sometimes, never. This is not the same as the status of the statement.", 0, 1, usageStatus));
        children.add(new Property("usageReason", "CodeableConcept", "The reason for asserting the usage status - for example forgot, lost, stolen, broken.", 0, java.lang.Integer.MAX_VALUE, usageReason));
        children.add(new Property("adherence", "", "This indicates how or if the device is being used.", 0, 1, adherence));
        children.add(new Property("informationSource", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Organization)", "Who reported the device was being used by the patient.", 0, 1, informationSource));
        children.add(new Property("device", "CodeableReference(Device|DeviceDefinition)", "Code or Reference to device used.", 0, 1, device));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference|Procedure)", "Reason or justification for the use of the device. A coded concept, or another resource whose existence justifies this DeviceUsage.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("bodySite", "CodeableReference(BodyStructure)", "Indicates the anotomic location on the subject's body where the device was used ( i.e. the target).", 0, 1, bodySite));
        children.add(new Property("note", "Annotation", "Details about the device statement that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "An external identifier for this statement such as an IRI.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this DeviceUsage.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -892481550: /*status*/  return new Property("status", "code", "A code representing the patient or other source's judgment about the state of the device used that this statement is about.  Generally this will be active or completed.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "This attribute indicates a category for the statement - The device statement may be made in an inpatient or outpatient settting (inpatient | outpatient | community | patientspecified).", 0, java.lang.Integer.MAX_VALUE, category);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "The patient who used the device.", 0, 1, patient);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "Reference(ServiceRequest|Procedure|Claim|Observation|QuestionnaireResponse|DocumentReference)", "Allows linking the DeviceUsage to the underlying Request, or to other information that supports or is used to derive the DeviceUsage.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case 951530927: /*context*/  return new Property("context", "Reference(Encounter|EpisodeOfCare)", "The encounter or episode of care that establishes the context for this device use statement.", 0, 1, context);
        case 164632566: /*timing[x]*/  return new Property("timing[x]", "Timing|Period|dateTime", "How often the device was used.", 0, 1, timing);
        case -873664438: /*timing*/  return new Property("timing[x]", "Timing|Period|dateTime", "How often the device was used.", 0, 1, timing);
        case -497554124: /*timingTiming*/  return new Property("timing[x]", "Timing", "How often the device was used.", 0, 1, timing);
        case -615615829: /*timingPeriod*/  return new Property("timing[x]", "Period", "How often the device was used.", 0, 1, timing);
        case -1837458939: /*timingDateTime*/  return new Property("timing[x]", "dateTime", "How often the device was used.", 0, 1, timing);
        case -1980855245: /*dateAsserted*/  return new Property("dateAsserted", "dateTime", "The time at which the statement was recorded by informationSource.", 0, 1, dateAsserted);
        case 907197683: /*usageStatus*/  return new Property("usageStatus", "CodeableConcept", "The status of the device usage, for example always, sometimes, never. This is not the same as the status of the statement.", 0, 1, usageStatus);
        case 864714565: /*usageReason*/  return new Property("usageReason", "CodeableConcept", "The reason for asserting the usage status - for example forgot, lost, stolen, broken.", 0, java.lang.Integer.MAX_VALUE, usageReason);
        case -231003683: /*adherence*/  return new Property("adherence", "", "This indicates how or if the device is being used.", 0, 1, adherence);
        case -2123220889: /*informationSource*/  return new Property("informationSource", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Organization)", "Who reported the device was being used by the patient.", 0, 1, informationSource);
        case -1335157162: /*device*/  return new Property("device", "CodeableReference(Device|DeviceDefinition)", "Code or Reference to device used.", 0, 1, device);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference|Procedure)", "Reason or justification for the use of the device. A coded concept, or another resource whose existence justifies this DeviceUsage.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableReference(BodyStructure)", "Indicates the anotomic location on the subject's body where the device was used ( i.e. the target).", 0, 1, bodySite);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Details about the device statement that were not represented at all or sufficiently in one of the attributes provided in a class. These may include for example a comment, an instruction, or a note associated with the statement.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<DeviceUsageStatus>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // Reference
        case 951530927: /*context*/ return this.context == null ? new Base[0] : new Base[] {this.context}; // Reference
        case -873664438: /*timing*/ return this.timing == null ? new Base[0] : new Base[] {this.timing}; // DataType
        case -1980855245: /*dateAsserted*/ return this.dateAsserted == null ? new Base[0] : new Base[] {this.dateAsserted}; // DateTimeType
        case 907197683: /*usageStatus*/ return this.usageStatus == null ? new Base[0] : new Base[] {this.usageStatus}; // CodeableConcept
        case 864714565: /*usageReason*/ return this.usageReason == null ? new Base[0] : this.usageReason.toArray(new Base[this.usageReason.size()]); // CodeableConcept
        case -231003683: /*adherence*/ return this.adherence == null ? new Base[0] : new Base[] {this.adherence}; // DeviceUsageAdherenceComponent
        case -2123220889: /*informationSource*/ return this.informationSource == null ? new Base[0] : new Base[] {this.informationSource}; // Reference
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // CodeableReference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : new Base[] {this.bodySite}; // CodeableReference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
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
        case -892481550: // status
          value = new DeviceUsageStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DeviceUsageStatus>
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1077922663: // derivedFrom
          this.getDerivedFrom().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 951530927: // context
          this.context = TypeConvertor.castToReference(value); // Reference
          return value;
        case -873664438: // timing
          this.timing = TypeConvertor.castToType(value); // DataType
          return value;
        case -1980855245: // dateAsserted
          this.dateAsserted = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 907197683: // usageStatus
          this.usageStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 864714565: // usageReason
          this.getUsageReason().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -231003683: // adherence
          this.adherence = (DeviceUsageAdherenceComponent) value; // DeviceUsageAdherenceComponent
          return value;
        case -2123220889: // informationSource
          this.informationSource = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 1702620169: // bodySite
          this.bodySite = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
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
        } else if (name.equals("status")) {
          value = new DeviceUsageStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<DeviceUsageStatus>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(TypeConvertor.castToReference(value));
        } else if (name.equals("context")) {
          this.context = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("timing[x]")) {
          this.timing = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("dateAsserted")) {
          this.dateAsserted = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("usageStatus")) {
          this.usageStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("usageReason")) {
          this.getUsageReason().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("adherence")) {
          this.adherence = (DeviceUsageAdherenceComponent) value; // DeviceUsageAdherenceComponent
        } else if (name.equals("informationSource")) {
          this.informationSource = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("bodySite")) {
          this.bodySite = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -892481550:  return getStatusElement();
        case 50511102:  return addCategory(); 
        case -791418107:  return getPatient();
        case 1077922663:  return addDerivedFrom(); 
        case 951530927:  return getContext();
        case 164632566:  return getTiming();
        case -873664438:  return getTiming();
        case -1980855245:  return getDateAssertedElement();
        case 907197683:  return getUsageStatus();
        case 864714565:  return addUsageReason(); 
        case -231003683:  return getAdherence();
        case -2123220889:  return getInformationSource();
        case -1335157162:  return getDevice();
        case -934964668:  return addReason(); 
        case 1702620169:  return getBodySite();
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case 1077922663: /*derivedFrom*/ return new String[] {"Reference"};
        case 951530927: /*context*/ return new String[] {"Reference"};
        case -873664438: /*timing*/ return new String[] {"Timing", "Period", "dateTime"};
        case -1980855245: /*dateAsserted*/ return new String[] {"dateTime"};
        case 907197683: /*usageStatus*/ return new String[] {"CodeableConcept"};
        case 864714565: /*usageReason*/ return new String[] {"CodeableConcept"};
        case -231003683: /*adherence*/ return new String[] {};
        case -2123220889: /*informationSource*/ return new String[] {"Reference"};
        case -1335157162: /*device*/ return new String[] {"CodeableReference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableReference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
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
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceUsage.status");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("derivedFrom")) {
          return addDerivedFrom();
        }
        else if (name.equals("context")) {
          this.context = new Reference();
          return this.context;
        }
        else if (name.equals("timingTiming")) {
          this.timing = new Timing();
          return this.timing;
        }
        else if (name.equals("timingPeriod")) {
          this.timing = new Period();
          return this.timing;
        }
        else if (name.equals("timingDateTime")) {
          this.timing = new DateTimeType();
          return this.timing;
        }
        else if (name.equals("dateAsserted")) {
          throw new FHIRException("Cannot call addChild on a primitive type DeviceUsage.dateAsserted");
        }
        else if (name.equals("usageStatus")) {
          this.usageStatus = new CodeableConcept();
          return this.usageStatus;
        }
        else if (name.equals("usageReason")) {
          return addUsageReason();
        }
        else if (name.equals("adherence")) {
          this.adherence = new DeviceUsageAdherenceComponent();
          return this.adherence;
        }
        else if (name.equals("informationSource")) {
          this.informationSource = new Reference();
          return this.informationSource;
        }
        else if (name.equals("device")) {
          this.device = new CodeableReference();
          return this.device;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("bodySite")) {
          this.bodySite = new CodeableReference();
          return this.bodySite;
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "DeviceUsage";

  }

      public DeviceUsage copy() {
        DeviceUsage dst = new DeviceUsage();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DeviceUsage dst) {
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
        dst.status = status == null ? null : status.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.patient = patient == null ? null : patient.copy();
        if (derivedFrom != null) {
          dst.derivedFrom = new ArrayList<Reference>();
          for (Reference i : derivedFrom)
            dst.derivedFrom.add(i.copy());
        };
        dst.context = context == null ? null : context.copy();
        dst.timing = timing == null ? null : timing.copy();
        dst.dateAsserted = dateAsserted == null ? null : dateAsserted.copy();
        dst.usageStatus = usageStatus == null ? null : usageStatus.copy();
        if (usageReason != null) {
          dst.usageReason = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : usageReason)
            dst.usageReason.add(i.copy());
        };
        dst.adherence = adherence == null ? null : adherence.copy();
        dst.informationSource = informationSource == null ? null : informationSource.copy();
        dst.device = device == null ? null : device.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        dst.bodySite = bodySite == null ? null : bodySite.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected DeviceUsage typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DeviceUsage))
          return false;
        DeviceUsage o = (DeviceUsage) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(status, o.status, true)
           && compareDeep(category, o.category, true) && compareDeep(patient, o.patient, true) && compareDeep(derivedFrom, o.derivedFrom, true)
           && compareDeep(context, o.context, true) && compareDeep(timing, o.timing, true) && compareDeep(dateAsserted, o.dateAsserted, true)
           && compareDeep(usageStatus, o.usageStatus, true) && compareDeep(usageReason, o.usageReason, true)
           && compareDeep(adherence, o.adherence, true) && compareDeep(informationSource, o.informationSource, true)
           && compareDeep(device, o.device, true) && compareDeep(reason, o.reason, true) && compareDeep(bodySite, o.bodySite, true)
           && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DeviceUsage))
          return false;
        DeviceUsage o = (DeviceUsage) other_;
        return compareValues(status, o.status, true) && compareValues(dateAsserted, o.dateAsserted, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, status
          , category, patient, derivedFrom, context, timing, dateAsserted, usageStatus, usageReason
          , adherence, informationSource, device, reason, bodySite, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.DeviceUsage;
   }

 /**
   * Search parameter: <b>device</b>
   * <p>
   * Description: <b>Search by device</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceUsage.device.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="device", path="DeviceUsage.device.concept", description="Search by device", type="token" )
  public static final String SP_DEVICE = "device";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>device</b>
   * <p>
   * Description: <b>Search by device</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceUsage.device.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DEVICE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DEVICE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Search by identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceUsage.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="DeviceUsage.identifier", description="Search by identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Search by identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>DeviceUsage.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.subject | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.subject | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentManifest](documentmanifest.html): The subject of the set of documents\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [List](list.html): If all resources have the same subject\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={BiologicallyDerivedProduct.class, Device.class, Group.class, Location.class, Medication.class, NutritionProduct.class, Organization.class, Patient.class, Practitioner.class, Procedure.class, Substance.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [List](list.html): If all resources have the same subject
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.subject | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>DeviceUsage:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("DeviceUsage:patient").toLocked();


}

