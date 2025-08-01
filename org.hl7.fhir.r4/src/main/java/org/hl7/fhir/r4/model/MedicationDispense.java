package org.hl7.fhir.r4.model;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

// Generated on Tue, May 12, 2020 07:26+1000 for FHIR v4.0.1
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseBackboneElement;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;

/**
 * Indicates that a medication product is to be or has been dispensed for a
 * named person/patient. This includes a description of the medication product
 * (supply) provided and the instructions for administering the medication. The
 * medication dispense is the result of a pharmacy system responding to a
 * medication order.
 */
@ResourceDef(name = "MedicationDispense", profile = "http://hl7.org/fhir/StructureDefinition/MedicationDispense")
public class MedicationDispense extends DomainResource {

  public enum MedicationDispenseStatus {
    /**
     * The core event has not started yet, but some staging activities have begun
     * (e.g. initial compounding or packaging of medication). Preparation stages may
     * be tracked for billing purposes.
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
     * The dispense process is paused while waiting for an external event to
     * reactivate the dispense. For example, new stock has arrived or the prescriber
     * has called.
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
     * Actions implied by the dispense have been permanently halted, before all of
     * them occurred.
     */
    STOPPED,
    /**
     * The dispense was declined and not performed.
     */
    DECLINED,
    /**
     * The authoring system does not know which of the status values applies for
     * this medication dispense. Note: this concept is not to be used for other -
     * one of the listed statuses is presumed to apply, it's just now known which
     * one.
     */
    UNKNOWN,
    /**
     * added to help the parsers with the generic types
     */
    NULL;

    public static MedicationDispenseStatus fromCode(String codeString) throws FHIRException {
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
        throw new FHIRException("Unknown MedicationDispenseStatus code '" + codeString + "'");
    }

    public String toCode() {
      switch (this) {
      case PREPARATION:
        return "preparation";
      case INPROGRESS:
        return "in-progress";
      case CANCELLED:
        return "cancelled";
      case ONHOLD:
        return "on-hold";
      case COMPLETED:
        return "completed";
      case ENTEREDINERROR:
        return "entered-in-error";
      case STOPPED:
        return "stopped";
      case DECLINED:
        return "declined";
      case UNKNOWN:
        return "unknown";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getSystem() {
      switch (this) {
      case PREPARATION:
        return "http://terminology.hl7.org/CodeSystem/medicationdispense-status";
      case INPROGRESS:
        return "http://terminology.hl7.org/CodeSystem/medicationdispense-status";
      case CANCELLED:
        return "http://terminology.hl7.org/CodeSystem/medicationdispense-status";
      case ONHOLD:
        return "http://terminology.hl7.org/CodeSystem/medicationdispense-status";
      case COMPLETED:
        return "http://terminology.hl7.org/CodeSystem/medicationdispense-status";
      case ENTEREDINERROR:
        return "http://terminology.hl7.org/CodeSystem/medicationdispense-status";
      case STOPPED:
        return "http://terminology.hl7.org/CodeSystem/medicationdispense-status";
      case DECLINED:
        return "http://terminology.hl7.org/CodeSystem/medicationdispense-status";
      case UNKNOWN:
        return "http://terminology.hl7.org/CodeSystem/medicationdispense-status";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDefinition() {
      switch (this) {
      case PREPARATION:
        return "The core event has not started yet, but some staging activities have begun (e.g. initial compounding or packaging of medication). Preparation stages may be tracked for billing purposes.";
      case INPROGRESS:
        return "The dispensed product is ready for pickup.";
      case CANCELLED:
        return "The dispensed product was not and will never be picked up by the patient.";
      case ONHOLD:
        return "The dispense process is paused while waiting for an external event to reactivate the dispense.  For example, new stock has arrived or the prescriber has called.";
      case COMPLETED:
        return "The dispensed product has been picked up.";
      case ENTEREDINERROR:
        return "The dispense was entered in error and therefore nullified.";
      case STOPPED:
        return "Actions implied by the dispense have been permanently halted, before all of them occurred.";
      case DECLINED:
        return "The dispense was declined and not performed.";
      case UNKNOWN:
        return "The authoring system does not know which of the status values applies for this medication dispense.  Note: this concept is not to be used for other - one of the listed statuses is presumed to apply, it's just now known which one.";
      case NULL:
        return null;
      default:
        return "?";
      }
    }

    public String getDisplay() {
      switch (this) {
      case PREPARATION:
        return "Preparation";
      case INPROGRESS:
        return "In Progress";
      case CANCELLED:
        return "Cancelled";
      case ONHOLD:
        return "On Hold";
      case COMPLETED:
        return "Completed";
      case ENTEREDINERROR:
        return "Entered in Error";
      case STOPPED:
        return "Stopped";
      case DECLINED:
        return "Declined";
      case UNKNOWN:
        return "Unknown";
      case NULL:
        return null;
      default:
        return "?";
      }
    }
  }

  public static class MedicationDispenseStatusEnumFactory implements EnumFactory<MedicationDispenseStatus> {
    public MedicationDispenseStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
        if (codeString == null || "".equals(codeString))
          return null;
      if ("preparation".equals(codeString))
        return MedicationDispenseStatus.PREPARATION;
      if ("in-progress".equals(codeString))
        return MedicationDispenseStatus.INPROGRESS;
      if ("cancelled".equals(codeString))
        return MedicationDispenseStatus.CANCELLED;
      if ("on-hold".equals(codeString))
        return MedicationDispenseStatus.ONHOLD;
      if ("completed".equals(codeString))
        return MedicationDispenseStatus.COMPLETED;
      if ("entered-in-error".equals(codeString))
        return MedicationDispenseStatus.ENTEREDINERROR;
      if ("stopped".equals(codeString))
        return MedicationDispenseStatus.STOPPED;
      if ("declined".equals(codeString))
        return MedicationDispenseStatus.DECLINED;
      if ("unknown".equals(codeString))
        return MedicationDispenseStatus.UNKNOWN;
      throw new IllegalArgumentException("Unknown MedicationDispenseStatus code '" + codeString + "'");
    }

    public Enumeration<MedicationDispenseStatus> fromType(PrimitiveType<?> code) throws FHIRException {
      if (code == null)
        return null;
      if (code.isEmpty())
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.NULL, code);
      String codeString = code.asStringValue();
      if (codeString == null || "".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.NULL, code);
      if ("preparation".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.PREPARATION, code);
      if ("in-progress".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.INPROGRESS, code);
      if ("cancelled".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.CANCELLED, code);
      if ("on-hold".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.ONHOLD, code);
      if ("completed".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.COMPLETED, code);
      if ("entered-in-error".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.ENTEREDINERROR, code);
      if ("stopped".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.STOPPED, code);
      if ("declined".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.DECLINED, code);
      if ("unknown".equals(codeString))
        return new Enumeration<MedicationDispenseStatus>(this, MedicationDispenseStatus.UNKNOWN, code);
      throw new FHIRException("Unknown MedicationDispenseStatus code '" + codeString + "'");
    }

    public String toCode(MedicationDispenseStatus code) {
       if (code == MedicationDispenseStatus.NULL)
           return null;
       if (code == MedicationDispenseStatus.PREPARATION)
        return "preparation";
      if (code == MedicationDispenseStatus.INPROGRESS)
        return "in-progress";
      if (code == MedicationDispenseStatus.CANCELLED)
        return "cancelled";
      if (code == MedicationDispenseStatus.ONHOLD)
        return "on-hold";
      if (code == MedicationDispenseStatus.COMPLETED)
        return "completed";
      if (code == MedicationDispenseStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == MedicationDispenseStatus.STOPPED)
        return "stopped";
      if (code == MedicationDispenseStatus.DECLINED)
        return "declined";
      if (code == MedicationDispenseStatus.UNKNOWN)
        return "unknown";
      return "?";
   }

    public String toSystem(MedicationDispenseStatus code) {
      return code.getSystem();
    }
  }

  @Block()
  public static class MedicationDispensePerformerComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * Distinguishes the type of performer in the dispense. For example, date
     * enterer, packager, final checker.
     */
    @Child(name = "function", type = {
        CodeableConcept.class }, order = 1, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Who performed the dispense and what they did", formalDefinition = "Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/medicationdispense-performer-function")
    protected CodeableConcept function;

    /**
     * The device, practitioner, etc. who performed the action. It should be assumed
     * that the actor is the dispenser of the medication.
     */
    @Child(name = "actor", type = { Practitioner.class, PractitionerRole.class, Organization.class, Patient.class,
        Device.class, RelatedPerson.class }, order = 2, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Individual who was performing", formalDefinition = "The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the medication.")
    protected Reference actor;

    /**
     * The actual object that is the target of the reference (The device,
     * practitioner, etc. who performed the action. It should be assumed that the
     * actor is the dispenser of the medication.)
     */
    protected Resource actorTarget;

    private static final long serialVersionUID = 1424001049L;

    /**
     * Constructor
     */
    public MedicationDispensePerformerComponent() {
      super();
    }

    /**
     * Constructor
     */
    public MedicationDispensePerformerComponent(Reference actor) {
      super();
      this.actor = actor;
    }

    /**
     * @return {@link #function} (Distinguishes the type of performer in the
     *         dispense. For example, date enterer, packager, final checker.)
     */
    public CodeableConcept getFunction() {
      if (this.function == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispensePerformerComponent.function");
        else if (Configuration.doAutoCreate())
          this.function = new CodeableConcept(); // cc
      return this.function;
    }

    public boolean hasFunction() {
      return this.function != null && !this.function.isEmpty();
    }

    /**
     * @param value {@link #function} (Distinguishes the type of performer in the
     *              dispense. For example, date enterer, packager, final checker.)
     */
    public MedicationDispensePerformerComponent setFunction(CodeableConcept value) {
      this.function = value;
      return this;
    }

    /**
     * @return {@link #actor} (The device, practitioner, etc. who performed the
     *         action. It should be assumed that the actor is the dispenser of the
     *         medication.)
     */
    public Reference getActor() {
      if (this.actor == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispensePerformerComponent.actor");
        else if (Configuration.doAutoCreate())
          this.actor = new Reference(); // cc
      return this.actor;
    }

    public boolean hasActor() {
      return this.actor != null && !this.actor.isEmpty();
    }

    /**
     * @param value {@link #actor} (The device, practitioner, etc. who performed the
     *              action. It should be assumed that the actor is the dispenser of
     *              the medication.)
     */
    public MedicationDispensePerformerComponent setActor(Reference value) {
      this.actor = value;
      return this;
    }

    /**
     * @return {@link #actor} The actual object that is the target of the reference.
     *         The reference library doesn't populate this, but you can use it to
     *         hold the resource if you resolve it. (The device, practitioner, etc.
     *         who performed the action. It should be assumed that the actor is the
     *         dispenser of the medication.)
     */
    public Resource getActorTarget() {
      return this.actorTarget;
    }

    /**
     * @param value {@link #actor} The actual object that is the target of the
     *              reference. The reference library doesn't use these, but you can
     *              use it to hold the resource if you resolve it. (The device,
     *              practitioner, etc. who performed the action. It should be
     *              assumed that the actor is the dispenser of the medication.)
     */
    public MedicationDispensePerformerComponent setActorTarget(Resource value) {
      this.actorTarget = value;
      return this;
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("function", "CodeableConcept",
          "Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.",
          0, 1, function));
      children.add(new Property("actor",
          "Reference(Practitioner|PractitionerRole|Organization|Patient|Device|RelatedPerson)",
          "The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the medication.",
          0, 1, actor));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case 1380938712:
        /* function */ return new Property("function", "CodeableConcept",
            "Distinguishes the type of performer in the dispense.  For example, date enterer, packager, final checker.",
            0, 1, function);
      case 92645877:
        /* actor */ return new Property("actor",
            "Reference(Practitioner|PractitionerRole|Organization|Patient|Device|RelatedPerson)",
            "The device, practitioner, etc. who performed the action.  It should be assumed that the actor is the dispenser of the medication.",
            0, 1, actor);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case 1380938712:
        /* function */ return this.function == null ? new Base[0] : new Base[] { this.function }; // CodeableConcept
      case 92645877:
        /* actor */ return this.actor == null ? new Base[0] : new Base[] { this.actor }; // Reference
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case 1380938712: // function
        this.function = castToCodeableConcept(value); // CodeableConcept
        return value;
      case 92645877: // actor
        this.actor = castToReference(value); // Reference
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("function")) {
        this.function = castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("actor")) {
        this.actor = castToReference(value); // Reference
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
      case 1380938712:
        return getFunction();
      case 92645877:
        return getActor();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case 1380938712:
        /* function */ return new String[] { "CodeableConcept" };
      case 92645877:
        /* actor */ return new String[] { "Reference" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("function")) {
        this.function = new CodeableConcept();
        return this.function;
      } else if (name.equals("actor")) {
        this.actor = new Reference();
        return this.actor;
      } else
        return super.addChild(name);
    }

    public MedicationDispensePerformerComponent copy() {
      MedicationDispensePerformerComponent dst = new MedicationDispensePerformerComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(MedicationDispensePerformerComponent dst) {
      super.copyValues(dst);
      dst.function = function == null ? null : function.copy();
      dst.actor = actor == null ? null : actor.copy();
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof MedicationDispensePerformerComponent))
        return false;
      MedicationDispensePerformerComponent o = (MedicationDispensePerformerComponent) other_;
      return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof MedicationDispensePerformerComponent))
        return false;
      MedicationDispensePerformerComponent o = (MedicationDispensePerformerComponent) other_;
      return true;
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
    }

    public String fhirType() {
      return "MedicationDispense.performer";

    }

  }

  @Block()
  public static class MedicationDispenseSubstitutionComponent extends BackboneElement implements IBaseBackboneElement {
    /**
     * True if the dispenser dispensed a different drug or product from what was
     * prescribed.
     */
    @Child(name = "wasSubstituted", type = {
        BooleanType.class }, order = 1, min = 1, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Whether a substitution was or was not performed on the dispense", formalDefinition = "True if the dispenser dispensed a different drug or product from what was prescribed.")
    protected BooleanType wasSubstituted;

    /**
     * A code signifying whether a different drug was dispensed from what was
     * prescribed.
     */
    @Child(name = "type", type = {
        CodeableConcept.class }, order = 2, min = 0, max = 1, modifier = false, summary = false)
    @Description(shortDefinition = "Code signifying whether a different drug was dispensed from what was prescribed", formalDefinition = "A code signifying whether a different drug was dispensed from what was prescribed.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://terminology.hl7.org/ValueSet/v3-ActSubstanceAdminSubstitutionCode")
    protected CodeableConcept type;

    /**
     * Indicates the reason for the substitution (or lack of substitution) from what
     * was prescribed.
     */
    @Child(name = "reason", type = {
        CodeableConcept.class }, order = 3, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Why was substitution made", formalDefinition = "Indicates the reason for the substitution (or lack of substitution) from what was prescribed.")
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://terminology.hl7.org/ValueSet/v3-SubstanceAdminSubstitutionReason")
    protected List<CodeableConcept> reason;

    /**
     * The person or organization that has primary responsibility for the
     * substitution.
     */
    @Child(name = "responsibleParty", type = { Practitioner.class,
        PractitionerRole.class }, order = 4, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
    @Description(shortDefinition = "Who is responsible for the substitution", formalDefinition = "The person or organization that has primary responsibility for the substitution.")
    protected List<Reference> responsibleParty;
    /**
     * The actual objects that are the target of the reference (The person or
     * organization that has primary responsibility for the substitution.)
     */
    protected List<Resource> responsiblePartyTarget;

    private static final long serialVersionUID = 357914571L;

    /**
     * Constructor
     */
    public MedicationDispenseSubstitutionComponent() {
      super();
    }

    /**
     * Constructor
     */
    public MedicationDispenseSubstitutionComponent(BooleanType wasSubstituted) {
      super();
      this.wasSubstituted = wasSubstituted;
    }

    /**
     * @return {@link #wasSubstituted} (True if the dispenser dispensed a different
     *         drug or product from what was prescribed.). This is the underlying
     *         object with id, value and extensions. The accessor
     *         "getWasSubstituted" gives direct access to the value
     */
    public BooleanType getWasSubstitutedElement() {
      if (this.wasSubstituted == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispenseSubstitutionComponent.wasSubstituted");
        else if (Configuration.doAutoCreate())
          this.wasSubstituted = new BooleanType(); // bb
      return this.wasSubstituted;
    }

    public boolean hasWasSubstitutedElement() {
      return this.wasSubstituted != null && !this.wasSubstituted.isEmpty();
    }

    public boolean hasWasSubstituted() {
      return this.wasSubstituted != null && !this.wasSubstituted.isEmpty();
    }

    /**
     * @param value {@link #wasSubstituted} (True if the dispenser dispensed a
     *              different drug or product from what was prescribed.). This is
     *              the underlying object with id, value and extensions. The
     *              accessor "getWasSubstituted" gives direct access to the value
     */
    public MedicationDispenseSubstitutionComponent setWasSubstitutedElement(BooleanType value) {
      this.wasSubstituted = value;
      return this;
    }

    /**
     * @return True if the dispenser dispensed a different drug or product from what
     *         was prescribed.
     */
    public boolean getWasSubstituted() {
      return this.wasSubstituted == null || this.wasSubstituted.isEmpty() ? false : this.wasSubstituted.getValue();
    }

    /**
     * @param value True if the dispenser dispensed a different drug or product from
     *              what was prescribed.
     */
    public MedicationDispenseSubstitutionComponent setWasSubstituted(boolean value) {
      if (this.wasSubstituted == null)
        this.wasSubstituted = new BooleanType();
      this.wasSubstituted.setValue(value);
      return this;
    }

    /**
     * @return {@link #type} (A code signifying whether a different drug was
     *         dispensed from what was prescribed.)
     */
    public CodeableConcept getType() {
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationDispenseSubstitutionComponent.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() {
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (A code signifying whether a different drug was
     *              dispensed from what was prescribed.)
     */
    public MedicationDispenseSubstitutionComponent setType(CodeableConcept value) {
      this.type = value;
      return this;
    }

    /**
     * @return {@link #reason} (Indicates the reason for the substitution (or lack
     *         of substitution) from what was prescribed.)
     */
    public List<CodeableConcept> getReason() {
      if (this.reason == null)
        this.reason = new ArrayList<CodeableConcept>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispenseSubstitutionComponent setReason(List<CodeableConcept> theReason) {
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

    public CodeableConcept addReason() { // 3
      CodeableConcept t = new CodeableConcept();
      if (this.reason == null)
        this.reason = new ArrayList<CodeableConcept>();
      this.reason.add(t);
      return t;
    }

    public MedicationDispenseSubstitutionComponent addReason(CodeableConcept t) { // 3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<CodeableConcept>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it
     *         if it does not already exist
     */
    public CodeableConcept getReasonFirstRep() {
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
    }

    /**
     * @return {@link #responsibleParty} (The person or organization that has
     *         primary responsibility for the substitution.)
     */
    public List<Reference> getResponsibleParty() {
      if (this.responsibleParty == null)
        this.responsibleParty = new ArrayList<Reference>();
      return this.responsibleParty;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationDispenseSubstitutionComponent setResponsibleParty(List<Reference> theResponsibleParty) {
      this.responsibleParty = theResponsibleParty;
      return this;
    }

    public boolean hasResponsibleParty() {
      if (this.responsibleParty == null)
        return false;
      for (Reference item : this.responsibleParty)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addResponsibleParty() { // 3
      Reference t = new Reference();
      if (this.responsibleParty == null)
        this.responsibleParty = new ArrayList<Reference>();
      this.responsibleParty.add(t);
      return t;
    }

    public MedicationDispenseSubstitutionComponent addResponsibleParty(Reference t) { // 3
      if (t == null)
        return this;
      if (this.responsibleParty == null)
        this.responsibleParty = new ArrayList<Reference>();
      this.responsibleParty.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #responsibleParty},
     *         creating it if it does not already exist
     */
    public Reference getResponsiblePartyFirstRep() {
      if (getResponsibleParty().isEmpty()) {
        addResponsibleParty();
      }
      return getResponsibleParty().get(0);
    }

    protected void listChildren(List<Property> children) {
      super.listChildren(children);
      children.add(new Property("wasSubstituted", "boolean",
          "True if the dispenser dispensed a different drug or product from what was prescribed.", 0, 1,
          wasSubstituted));
      children.add(new Property("type", "CodeableConcept",
          "A code signifying whether a different drug was dispensed from what was prescribed.", 0, 1, type));
      children.add(new Property("reason", "CodeableConcept",
          "Indicates the reason for the substitution (or lack of substitution) from what was prescribed.", 0,
          java.lang.Integer.MAX_VALUE, reason));
      children.add(new Property("responsibleParty", "Reference(Practitioner|PractitionerRole)",
          "The person or organization that has primary responsibility for the substitution.", 0,
          java.lang.Integer.MAX_VALUE, responsibleParty));
    }

    @Override
    public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
      switch (_hash) {
      case -592113567:
        /* wasSubstituted */ return new Property("wasSubstituted", "boolean",
            "True if the dispenser dispensed a different drug or product from what was prescribed.", 0, 1,
            wasSubstituted);
      case 3575610:
        /* type */ return new Property("type", "CodeableConcept",
            "A code signifying whether a different drug was dispensed from what was prescribed.", 0, 1, type);
      case -934964668:
        /* reason */ return new Property("reason", "CodeableConcept",
            "Indicates the reason for the substitution (or lack of substitution) from what was prescribed.", 0,
            java.lang.Integer.MAX_VALUE, reason);
      case 1511509392:
        /* responsibleParty */ return new Property("responsibleParty", "Reference(Practitioner|PractitionerRole)",
            "The person or organization that has primary responsibility for the substitution.", 0,
            java.lang.Integer.MAX_VALUE, responsibleParty);
      default:
        return super.getNamedProperty(_hash, _name, _checkValid);
      }

    }

    @Override
    public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
      switch (hash) {
      case -592113567:
        /* wasSubstituted */ return this.wasSubstituted == null ? new Base[0] : new Base[] { this.wasSubstituted }; // BooleanType
      case 3575610:
        /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
      case -934964668:
        /* reason */ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableConcept
      case 1511509392:
        /* responsibleParty */ return this.responsibleParty == null ? new Base[0]
            : this.responsibleParty.toArray(new Base[this.responsibleParty.size()]); // Reference
      default:
        return super.getProperty(hash, name, checkValid);
      }

    }

    @Override
    public Base setProperty(int hash, String name, Base value) throws FHIRException {
      switch (hash) {
      case -592113567: // wasSubstituted
        this.wasSubstituted = castToBoolean(value); // BooleanType
        return value;
      case 3575610: // type
        this.type = castToCodeableConcept(value); // CodeableConcept
        return value;
      case -934964668: // reason
        this.getReason().add(castToCodeableConcept(value)); // CodeableConcept
        return value;
      case 1511509392: // responsibleParty
        this.getResponsibleParty().add(castToReference(value)); // Reference
        return value;
      default:
        return super.setProperty(hash, name, value);
      }

    }

    @Override
    public Base setProperty(String name, Base value) throws FHIRException {
      if (name.equals("wasSubstituted")) {
        this.wasSubstituted = castToBoolean(value); // BooleanType
      } else if (name.equals("type")) {
        this.type = castToCodeableConcept(value); // CodeableConcept
      } else if (name.equals("reason")) {
        this.getReason().add(castToCodeableConcept(value));
      } else if (name.equals("responsibleParty")) {
        this.getResponsibleParty().add(castToReference(value));
      } else
        return super.setProperty(name, value);
      return value;
    }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
      if (name.equals("wasSubstituted")) {
        this.wasSubstituted = null;
      } else if (name.equals("type")) {
        this.type = null;
      } else if (name.equals("reason")) {
        this.getReason().remove(castToCodeableConcept(value));
      } else if (name.equals("responsibleParty")) {
        this.getResponsibleParty().remove(castToReference(value));
      } else
        super.removeChild(name, value);
      
    }

    @Override
    public Base makeProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -592113567:
        return getWasSubstitutedElement();
      case 3575610:
        return getType();
      case -934964668:
        return addReason();
      case 1511509392:
        return addResponsibleParty();
      default:
        return super.makeProperty(hash, name);
      }

    }

    @Override
    public String[] getTypesForProperty(int hash, String name) throws FHIRException {
      switch (hash) {
      case -592113567:
        /* wasSubstituted */ return new String[] { "boolean" };
      case 3575610:
        /* type */ return new String[] { "CodeableConcept" };
      case -934964668:
        /* reason */ return new String[] { "CodeableConcept" };
      case 1511509392:
        /* responsibleParty */ return new String[] { "Reference" };
      default:
        return super.getTypesForProperty(hash, name);
      }

    }

    @Override
    public Base addChild(String name) throws FHIRException {
      if (name.equals("wasSubstituted")) {
        throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.wasSubstituted");
      } else if (name.equals("type")) {
        this.type = new CodeableConcept();
        return this.type;
      } else if (name.equals("reason")) {
        return addReason();
      } else if (name.equals("responsibleParty")) {
        return addResponsibleParty();
      } else
        return super.addChild(name);
    }

    public MedicationDispenseSubstitutionComponent copy() {
      MedicationDispenseSubstitutionComponent dst = new MedicationDispenseSubstitutionComponent();
      copyValues(dst);
      return dst;
    }

    public void copyValues(MedicationDispenseSubstitutionComponent dst) {
      super.copyValues(dst);
      dst.wasSubstituted = wasSubstituted == null ? null : wasSubstituted.copy();
      dst.type = type == null ? null : type.copy();
      if (reason != null) {
        dst.reason = new ArrayList<CodeableConcept>();
        for (CodeableConcept i : reason)
          dst.reason.add(i.copy());
      }
      ;
      if (responsibleParty != null) {
        dst.responsibleParty = new ArrayList<Reference>();
        for (Reference i : responsibleParty)
          dst.responsibleParty.add(i.copy());
      }
      ;
    }

    @Override
    public boolean equalsDeep(Base other_) {
      if (!super.equalsDeep(other_))
        return false;
      if (!(other_ instanceof MedicationDispenseSubstitutionComponent))
        return false;
      MedicationDispenseSubstitutionComponent o = (MedicationDispenseSubstitutionComponent) other_;
      return compareDeep(wasSubstituted, o.wasSubstituted, true) && compareDeep(type, o.type, true)
          && compareDeep(reason, o.reason, true) && compareDeep(responsibleParty, o.responsibleParty, true);
    }

    @Override
    public boolean equalsShallow(Base other_) {
      if (!super.equalsShallow(other_))
        return false;
      if (!(other_ instanceof MedicationDispenseSubstitutionComponent))
        return false;
      MedicationDispenseSubstitutionComponent o = (MedicationDispenseSubstitutionComponent) other_;
      return compareValues(wasSubstituted, o.wasSubstituted, true);
    }

    public boolean isEmpty() {
      return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(wasSubstituted, type, reason, responsibleParty);
    }

    public String fhirType() {
      return "MedicationDispense.substitution";

    }

  }

  /**
   * Identifiers associated with this Medication Dispense that are defined by
   * business processes and/or used to refer to it when a direct URL reference to
   * the resource itself is not appropriate. They are business identifiers
   * assigned to this resource by the performer or other systems and remain
   * constant as the resource is updated and propagates from server to server.
   */
  @Child(name = "identifier", type = {
      Identifier.class }, order = 0, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "External identifier", formalDefinition = "Identifiers associated with this Medication Dispense that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.")
  protected List<Identifier> identifier;

  /**
   * The procedure that trigger the dispense.
   */
  @Child(name = "partOf", type = {
      Procedure.class }, order = 1, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Event that dispense is part of", formalDefinition = "The procedure that trigger the dispense.")
  protected List<Reference> partOf;
  /**
   * The actual objects that are the target of the reference (The procedure that
   * trigger the dispense.)
   */
  protected List<Procedure> partOfTarget;

  /**
   * A code specifying the state of the set of dispense events.
   */
  @Child(name = "status", type = { CodeType.class }, order = 2, min = 1, max = 1, modifier = true, summary = true)
  @Description(shortDefinition = "preparation | in-progress | cancelled | on-hold | completed | entered-in-error | stopped | declined | unknown", formalDefinition = "A code specifying the state of the set of dispense events.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/medicationdispense-status")
  protected Enumeration<MedicationDispenseStatus> status;

  /**
   * Indicates the reason why a dispense was not performed.
   */
  @Child(name = "statusReason", type = { CodeableConcept.class,
      DetectedIssue.class }, order = 3, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Why a dispense was not performed", formalDefinition = "Indicates the reason why a dispense was not performed.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/medicationdispense-status-reason")
  protected Type statusReason;

  /**
   * Indicates the type of medication dispense (for example, where the medication
   * is expected to be consumed or administered (i.e. inpatient or outpatient)).
   */
  @Child(name = "category", type = {
      CodeableConcept.class }, order = 4, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Type of medication dispense", formalDefinition = "Indicates the type of medication dispense (for example, where the medication is expected to be consumed or administered (i.e. inpatient or outpatient)).")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/medicationdispense-category")
  protected CodeableConcept category;

  /**
   * Identifies the medication being administered. This is either a link to a
   * resource representing the details of the medication or a simple attribute
   * carrying a code that identifies the medication from a known list of
   * medications.
   */
  @Child(name = "medication", type = { CodeableConcept.class,
      Medication.class }, order = 5, min = 1, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "What medication was supplied", formalDefinition = "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://hl7.org/fhir/ValueSet/medication-codes")
  protected Type medication;

  /**
   * A link to a resource representing the person or the group to whom the
   * medication will be given.
   */
  @Child(name = "subject", type = { Patient.class,
      Group.class }, order = 6, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "Who the dispense is for", formalDefinition = "A link to a resource representing the person or the group to whom the medication will be given.")
  protected Reference subject;

  /**
   * The actual object that is the target of the reference (A link to a resource
   * representing the person or the group to whom the medication will be given.)
   */
  protected Resource subjectTarget;

  /**
   * The encounter or episode of care that establishes the context for this event.
   */
  @Child(name = "context", type = { Encounter.class,
      EpisodeOfCare.class }, order = 7, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Encounter / Episode associated with event", formalDefinition = "The encounter or episode of care that establishes the context for this event.")
  protected Reference context;

  /**
   * The actual object that is the target of the reference (The encounter or
   * episode of care that establishes the context for this event.)
   */
  protected Resource contextTarget;

  /**
   * Additional information that supports the medication being dispensed.
   */
  @Child(name = "supportingInformation", type = {
      Reference.class }, order = 8, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Information that supports the dispensing of the medication", formalDefinition = "Additional information that supports the medication being dispensed.")
  protected List<Reference> supportingInformation;
  /**
   * The actual objects that are the target of the reference (Additional
   * information that supports the medication being dispensed.)
   */
  protected List<Resource> supportingInformationTarget;

  /**
   * Indicates who or what performed the event.
   */
  @Child(name = "performer", type = {}, order = 9, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who performed event", formalDefinition = "Indicates who or what performed the event.")
  protected List<MedicationDispensePerformerComponent> performer;

  /**
   * The principal physical location where the dispense was performed.
   */
  @Child(name = "location", type = { Location.class }, order = 10, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Where the dispense occurred", formalDefinition = "The principal physical location where the dispense was performed.")
  protected Reference location;

  /**
   * The actual object that is the target of the reference (The principal physical
   * location where the dispense was performed.)
   */
  protected Location locationTarget;

  /**
   * Indicates the medication order that is being dispensed against.
   */
  @Child(name = "authorizingPrescription", type = {
      MedicationRequest.class }, order = 11, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Medication order that authorizes the dispense", formalDefinition = "Indicates the medication order that is being dispensed against.")
  protected List<Reference> authorizingPrescription;
  /**
   * The actual objects that are the target of the reference (Indicates the
   * medication order that is being dispensed against.)
   */
  protected List<MedicationRequest> authorizingPrescriptionTarget;

  /**
   * Indicates the type of dispensing event that is performed. For example, Trial
   * Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc.
   */
  @Child(name = "type", type = {
      CodeableConcept.class }, order = 12, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Trial fill, partial fill, emergency fill, etc.", formalDefinition = "Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc.")
  @ca.uhn.fhir.model.api.annotation.Binding(valueSet = "http://terminology.hl7.org/ValueSet/v3-ActPharmacySupplyType")
  protected CodeableConcept type;

  /**
   * The amount of medication that has been dispensed. Includes unit of measure.
   */
  @Child(name = "quantity", type = { Quantity.class }, order = 13, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Amount dispensed", formalDefinition = "The amount of medication that has been dispensed. Includes unit of measure.")
  protected Quantity quantity;

  /**
   * The amount of medication expressed as a timing amount.
   */
  @Child(name = "daysSupply", type = {
      Quantity.class }, order = 14, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Amount of medication expressed as a timing amount", formalDefinition = "The amount of medication expressed as a timing amount.")
  protected Quantity daysSupply;

  /**
   * The time when the dispensed product was packaged and reviewed.
   */
  @Child(name = "whenPrepared", type = {
      DateTimeType.class }, order = 15, min = 0, max = 1, modifier = false, summary = true)
  @Description(shortDefinition = "When product was packaged and reviewed", formalDefinition = "The time when the dispensed product was packaged and reviewed.")
  protected DateTimeType whenPrepared;

  /**
   * The time the dispensed product was provided to the patient or their
   * representative.
   */
  @Child(name = "whenHandedOver", type = {
      DateTimeType.class }, order = 16, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "When product was given out", formalDefinition = "The time the dispensed product was provided to the patient or their representative.")
  protected DateTimeType whenHandedOver;

  /**
   * Identification of the facility/location where the medication was shipped to,
   * as part of the dispense event.
   */
  @Child(name = "destination", type = {
      Location.class }, order = 17, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Where the medication was sent", formalDefinition = "Identification of the facility/location where the medication was shipped to, as part of the dispense event.")
  protected Reference destination;

  /**
   * The actual object that is the target of the reference (Identification of the
   * facility/location where the medication was shipped to, as part of the
   * dispense event.)
   */
  protected Location destinationTarget;

  /**
   * Identifies the person who picked up the medication. This will usually be a
   * patient or their caregiver, but some cases exist where it can be a healthcare
   * professional.
   */
  @Child(name = "receiver", type = { Patient.class,
      Practitioner.class }, order = 18, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Who collected the medication", formalDefinition = "Identifies the person who picked up the medication.  This will usually be a patient or their caregiver, but some cases exist where it can be a healthcare professional.")
  protected List<Reference> receiver;
  /**
   * The actual objects that are the target of the reference (Identifies the
   * person who picked up the medication. This will usually be a patient or their
   * caregiver, but some cases exist where it can be a healthcare professional.)
   */
  protected List<Resource> receiverTarget;

  /**
   * Extra information about the dispense that could not be conveyed in the other
   * attributes.
   */
  @Child(name = "note", type = {
      Annotation.class }, order = 19, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Information about the dispense", formalDefinition = "Extra information about the dispense that could not be conveyed in the other attributes.")
  protected List<Annotation> note;

  /**
   * Indicates how the medication is to be used by the patient.
   */
  @Child(name = "dosageInstruction", type = {
      Dosage.class }, order = 20, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "How the medication is to be used by the patient or administered by the caregiver", formalDefinition = "Indicates how the medication is to be used by the patient.")
  protected List<Dosage> dosageInstruction;

  /**
   * Indicates whether or not substitution was made as part of the dispense. In
   * some cases, substitution will be expected but does not happen, in other cases
   * substitution is not expected but does happen. This block explains what
   * substitution did or did not happen and why. If nothing is specified,
   * substitution was not done.
   */
  @Child(name = "substitution", type = {}, order = 21, min = 0, max = 1, modifier = false, summary = false)
  @Description(shortDefinition = "Whether a substitution was performed on the dispense", formalDefinition = "Indicates whether or not substitution was made as part of the dispense.  In some cases, substitution will be expected but does not happen, in other cases substitution is not expected but does happen.  This block explains what substitution did or did not happen and why.  If nothing is specified, substitution was not done.")
  protected MedicationDispenseSubstitutionComponent substitution;

  /**
   * Indicates an actual or potential clinical issue with or between one or more
   * active or proposed clinical actions for a patient; e.g. drug-drug
   * interaction, duplicate therapy, dosage alert etc.
   */
  @Child(name = "detectedIssue", type = {
      DetectedIssue.class }, order = 22, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "Clinical issue with action", formalDefinition = "Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. drug-drug interaction, duplicate therapy, dosage alert etc.")
  protected List<Reference> detectedIssue;
  /**
   * The actual objects that are the target of the reference (Indicates an actual
   * or potential clinical issue with or between one or more active or proposed
   * clinical actions for a patient; e.g. drug-drug interaction, duplicate
   * therapy, dosage alert etc.)
   */
  protected List<DetectedIssue> detectedIssueTarget;

  /**
   * A summary of the events of interest that have occurred, such as when the
   * dispense was verified.
   */
  @Child(name = "eventHistory", type = {
      Provenance.class }, order = 23, min = 0, max = Child.MAX_UNLIMITED, modifier = false, summary = false)
  @Description(shortDefinition = "A list of relevant lifecycle events", formalDefinition = "A summary of the events of interest that have occurred, such as when the dispense was verified.")
  protected List<Reference> eventHistory;
  /**
   * The actual objects that are the target of the reference (A summary of the
   * events of interest that have occurred, such as when the dispense was
   * verified.)
   */
  protected List<Provenance> eventHistoryTarget;

  private static final long serialVersionUID = -976967238L;

  /**
   * Constructor
   */
  public MedicationDispense() {
    super();
  }

  /**
   * Constructor
   */
  public MedicationDispense(Enumeration<MedicationDispenseStatus> status, Type medication) {
    super();
    this.status = status;
    this.medication = medication;
  }

  /**
   * @return {@link #identifier} (Identifiers associated with this Medication
   *         Dispense that are defined by business processes and/or used to refer
   *         to it when a direct URL reference to the resource itself is not
   *         appropriate. They are business identifiers assigned to this resource
   *         by the performer or other systems and remain constant as the resource
   *         is updated and propagates from server to server.)
   */
  public List<Identifier> getIdentifier() {
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    return this.identifier;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setIdentifier(List<Identifier> theIdentifier) {
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

  public Identifier addIdentifier() { // 3
    Identifier t = new Identifier();
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return t;
  }

  public MedicationDispense addIdentifier(Identifier t) { // 3
    if (t == null)
      return this;
    if (this.identifier == null)
      this.identifier = new ArrayList<Identifier>();
    this.identifier.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #identifier}, creating
   *         it if it does not already exist
   */
  public Identifier getIdentifierFirstRep() {
    if (getIdentifier().isEmpty()) {
      addIdentifier();
    }
    return getIdentifier().get(0);
  }

  /**
   * @return {@link #partOf} (The procedure that trigger the dispense.)
   */
  public List<Reference> getPartOf() {
    if (this.partOf == null)
      this.partOf = new ArrayList<Reference>();
    return this.partOf;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setPartOf(List<Reference> thePartOf) {
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

  public Reference addPartOf() { // 3
    Reference t = new Reference();
    if (this.partOf == null)
      this.partOf = new ArrayList<Reference>();
    this.partOf.add(t);
    return t;
  }

  public MedicationDispense addPartOf(Reference t) { // 3
    if (t == null)
      return this;
    if (this.partOf == null)
      this.partOf = new ArrayList<Reference>();
    this.partOf.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #partOf}, creating it
   *         if it does not already exist
   */
  public Reference getPartOfFirstRep() {
    if (getPartOf().isEmpty()) {
      addPartOf();
    }
    return getPartOf().get(0);
  }

  /**
   * @return {@link #status} (A code specifying the state of the set of dispense
   *         events.). This is the underlying object with id, value and
   *         extensions. The accessor "getStatus" gives direct access to the value
   */
  public Enumeration<MedicationDispenseStatus> getStatusElement() {
    if (this.status == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.status");
      else if (Configuration.doAutoCreate())
        this.status = new Enumeration<MedicationDispenseStatus>(new MedicationDispenseStatusEnumFactory()); // bb
    return this.status;
  }

  public boolean hasStatusElement() {
    return this.status != null && !this.status.isEmpty();
  }

  public boolean hasStatus() {
    return this.status != null && !this.status.isEmpty();
  }

  /**
   * @param value {@link #status} (A code specifying the state of the set of
   *              dispense events.). This is the underlying object with id, value
   *              and extensions. The accessor "getStatus" gives direct access to
   *              the value
   */
  public MedicationDispense setStatusElement(Enumeration<MedicationDispenseStatus> value) {
    this.status = value;
    return this;
  }

  /**
   * @return A code specifying the state of the set of dispense events.
   */
  public MedicationDispenseStatus getStatus() {
    return this.status == null ? null : this.status.getValue();
  }

  /**
   * @param value A code specifying the state of the set of dispense events.
   */
  public MedicationDispense setStatus(MedicationDispenseStatus value) {
    if (this.status == null)
      this.status = new Enumeration<MedicationDispenseStatus>(new MedicationDispenseStatusEnumFactory());
    this.status.setValue(value);
    return this;
  }

  /**
   * @return {@link #statusReason} (Indicates the reason why a dispense was not
   *         performed.)
   */
  public Type getStatusReason() {
    return this.statusReason;
  }

  /**
   * @return {@link #statusReason} (Indicates the reason why a dispense was not
   *         performed.)
   */
  public CodeableConcept getStatusReasonCodeableConcept() throws FHIRException {
    if (this.statusReason == null)
      this.statusReason = new CodeableConcept();
    if (!(this.statusReason instanceof CodeableConcept))
      throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "
          + this.statusReason.getClass().getName() + " was encountered");
    return (CodeableConcept) this.statusReason;
  }

  public boolean hasStatusReasonCodeableConcept() {
      return this.statusReason instanceof CodeableConcept;
  }

  /**
   * @return {@link #statusReason} (Indicates the reason why a dispense was not
   *         performed.)
   */
  public Reference getStatusReasonReference() throws FHIRException {
    if (this.statusReason == null)
      this.statusReason = new Reference();
    if (!(this.statusReason instanceof Reference))
      throw new FHIRException("Type mismatch: the type Reference was expected, but "
          + this.statusReason.getClass().getName() + " was encountered");
    return (Reference) this.statusReason;
  }

  public boolean hasStatusReasonReference() {
      return this.statusReason instanceof Reference;
  }

  public boolean hasStatusReason() {
    return this.statusReason != null && !this.statusReason.isEmpty();
  }

  /**
   * @param value {@link #statusReason} (Indicates the reason why a dispense was
   *              not performed.)
   */
  public MedicationDispense setStatusReason(Type value) {
    if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
      throw new Error("Not the right type for MedicationDispense.statusReason[x]: " + value.fhirType());
    this.statusReason = value;
    return this;
  }

  /**
   * @return {@link #category} (Indicates the type of medication dispense (for
   *         example, where the medication is expected to be consumed or
   *         administered (i.e. inpatient or outpatient)).)
   */
  public CodeableConcept getCategory() {
    if (this.category == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.category");
      else if (Configuration.doAutoCreate())
        this.category = new CodeableConcept(); // cc
    return this.category;
  }

  public boolean hasCategory() {
    return this.category != null && !this.category.isEmpty();
  }

  /**
   * @param value {@link #category} (Indicates the type of medication dispense
   *              (for example, where the medication is expected to be consumed or
   *              administered (i.e. inpatient or outpatient)).)
   */
  public MedicationDispense setCategory(CodeableConcept value) {
    this.category = value;
    return this;
  }

  /**
   * @return {@link #medication} (Identifies the medication being administered.
   *         This is either a link to a resource representing the details of the
   *         medication or a simple attribute carrying a code that identifies the
   *         medication from a known list of medications.)
   */
  public Type getMedication() {
    return this.medication;
  }

  /**
   * @return {@link #medication} (Identifies the medication being administered.
   *         This is either a link to a resource representing the details of the
   *         medication or a simple attribute carrying a code that identifies the
   *         medication from a known list of medications.)
   */
  public CodeableConcept getMedicationCodeableConcept() throws FHIRException {
    if (this.medication == null)
      this.medication = new CodeableConcept();
    if (!(this.medication instanceof CodeableConcept))
      throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "
          + this.medication.getClass().getName() + " was encountered");
    return (CodeableConcept) this.medication;
  }

  public boolean hasMedicationCodeableConcept() {
      return this.medication instanceof CodeableConcept;
  }

  /**
   * @return {@link #medication} (Identifies the medication being administered.
   *         This is either a link to a resource representing the details of the
   *         medication or a simple attribute carrying a code that identifies the
   *         medication from a known list of medications.)
   */
  public Reference getMedicationReference() throws FHIRException {
    if (this.medication == null)
      this.medication = new Reference();
    if (!(this.medication instanceof Reference))
      throw new FHIRException("Type mismatch: the type Reference was expected, but "
          + this.medication.getClass().getName() + " was encountered");
    return (Reference) this.medication;
  }

  public boolean hasMedicationReference() {
      return this.medication instanceof Reference;
  }

  public boolean hasMedication() {
    return this.medication != null && !this.medication.isEmpty();
  }

  /**
   * @param value {@link #medication} (Identifies the medication being
   *              administered. This is either a link to a resource representing
   *              the details of the medication or a simple attribute carrying a
   *              code that identifies the medication from a known list of
   *              medications.)
   */
  public MedicationDispense setMedication(Type value) {
    if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
      throw new Error("Not the right type for MedicationDispense.medication[x]: " + value.fhirType());
    this.medication = value;
    return this;
  }

  /**
   * @return {@link #subject} (A link to a resource representing the person or the
   *         group to whom the medication will be given.)
   */
  public Reference getSubject() {
    if (this.subject == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.subject");
      else if (Configuration.doAutoCreate())
        this.subject = new Reference(); // cc
    return this.subject;
  }

  public boolean hasSubject() {
    return this.subject != null && !this.subject.isEmpty();
  }

  /**
   * @param value {@link #subject} (A link to a resource representing the person
   *              or the group to whom the medication will be given.)
   */
  public MedicationDispense setSubject(Reference value) {
    this.subject = value;
    return this;
  }

  /**
   * @return {@link #subject} The actual object that is the target of the
   *         reference. The reference library doesn't populate this, but you can
   *         use it to hold the resource if you resolve it. (A link to a resource
   *         representing the person or the group to whom the medication will be
   *         given.)
   */
  public Resource getSubjectTarget() {
    return this.subjectTarget;
  }

  /**
   * @param value {@link #subject} The actual object that is the target of the
   *              reference. The reference library doesn't use these, but you can
   *              use it to hold the resource if you resolve it. (A link to a
   *              resource representing the person or the group to whom the
   *              medication will be given.)
   */
  public MedicationDispense setSubjectTarget(Resource value) {
    this.subjectTarget = value;
    return this;
  }

  /**
   * @return {@link #context} (The encounter or episode of care that establishes
   *         the context for this event.)
   */
  public Reference getContext() {
    if (this.context == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.context");
      else if (Configuration.doAutoCreate())
        this.context = new Reference(); // cc
    return this.context;
  }

  public boolean hasContext() {
    return this.context != null && !this.context.isEmpty();
  }

  /**
   * @param value {@link #context} (The encounter or episode of care that
   *              establishes the context for this event.)
   */
  public MedicationDispense setContext(Reference value) {
    this.context = value;
    return this;
  }

  /**
   * @return {@link #context} The actual object that is the target of the
   *         reference. The reference library doesn't populate this, but you can
   *         use it to hold the resource if you resolve it. (The encounter or
   *         episode of care that establishes the context for this event.)
   */
  public Resource getContextTarget() {
    return this.contextTarget;
  }

  /**
   * @param value {@link #context} The actual object that is the target of the
   *              reference. The reference library doesn't use these, but you can
   *              use it to hold the resource if you resolve it. (The encounter or
   *              episode of care that establishes the context for this event.)
   */
  public MedicationDispense setContextTarget(Resource value) {
    this.contextTarget = value;
    return this;
  }

  /**
   * @return {@link #supportingInformation} (Additional information that supports
   *         the medication being dispensed.)
   */
  public List<Reference> getSupportingInformation() {
    if (this.supportingInformation == null)
      this.supportingInformation = new ArrayList<Reference>();
    return this.supportingInformation;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setSupportingInformation(List<Reference> theSupportingInformation) {
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

  public Reference addSupportingInformation() { // 3
    Reference t = new Reference();
    if (this.supportingInformation == null)
      this.supportingInformation = new ArrayList<Reference>();
    this.supportingInformation.add(t);
    return t;
  }

  public MedicationDispense addSupportingInformation(Reference t) { // 3
    if (t == null)
      return this;
    if (this.supportingInformation == null)
      this.supportingInformation = new ArrayList<Reference>();
    this.supportingInformation.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field
   *         {@link #supportingInformation}, creating it if it does not already
   *         exist
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
  public List<MedicationDispensePerformerComponent> getPerformer() {
    if (this.performer == null)
      this.performer = new ArrayList<MedicationDispensePerformerComponent>();
    return this.performer;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setPerformer(List<MedicationDispensePerformerComponent> thePerformer) {
    this.performer = thePerformer;
    return this;
  }

  public boolean hasPerformer() {
    if (this.performer == null)
      return false;
    for (MedicationDispensePerformerComponent item : this.performer)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public MedicationDispensePerformerComponent addPerformer() { // 3
    MedicationDispensePerformerComponent t = new MedicationDispensePerformerComponent();
    if (this.performer == null)
      this.performer = new ArrayList<MedicationDispensePerformerComponent>();
    this.performer.add(t);
    return t;
  }

  public MedicationDispense addPerformer(MedicationDispensePerformerComponent t) { // 3
    if (t == null)
      return this;
    if (this.performer == null)
      this.performer = new ArrayList<MedicationDispensePerformerComponent>();
    this.performer.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #performer}, creating
   *         it if it does not already exist
   */
  public MedicationDispensePerformerComponent getPerformerFirstRep() {
    if (getPerformer().isEmpty()) {
      addPerformer();
    }
    return getPerformer().get(0);
  }

  /**
   * @return {@link #location} (The principal physical location where the dispense
   *         was performed.)
   */
  public Reference getLocation() {
    if (this.location == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.location");
      else if (Configuration.doAutoCreate())
        this.location = new Reference(); // cc
    return this.location;
  }

  public boolean hasLocation() {
    return this.location != null && !this.location.isEmpty();
  }

  /**
   * @param value {@link #location} (The principal physical location where the
   *              dispense was performed.)
   */
  public MedicationDispense setLocation(Reference value) {
    this.location = value;
    return this;
  }

  /**
   * @return {@link #location} The actual object that is the target of the
   *         reference. The reference library doesn't populate this, but you can
   *         use it to hold the resource if you resolve it. (The principal
   *         physical location where the dispense was performed.)
   */
  public Location getLocationTarget() {
    if (this.locationTarget == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.location");
      else if (Configuration.doAutoCreate())
        this.locationTarget = new Location(); // aa
    return this.locationTarget;
  }

  /**
   * @param value {@link #location} The actual object that is the target of the
   *              reference. The reference library doesn't use these, but you can
   *              use it to hold the resource if you resolve it. (The principal
   *              physical location where the dispense was performed.)
   */
  public MedicationDispense setLocationTarget(Location value) {
    this.locationTarget = value;
    return this;
  }

  /**
   * @return {@link #authorizingPrescription} (Indicates the medication order that
   *         is being dispensed against.)
   */
  public List<Reference> getAuthorizingPrescription() {
    if (this.authorizingPrescription == null)
      this.authorizingPrescription = new ArrayList<Reference>();
    return this.authorizingPrescription;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setAuthorizingPrescription(List<Reference> theAuthorizingPrescription) {
    this.authorizingPrescription = theAuthorizingPrescription;
    return this;
  }

  public boolean hasAuthorizingPrescription() {
    if (this.authorizingPrescription == null)
      return false;
    for (Reference item : this.authorizingPrescription)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Reference addAuthorizingPrescription() { // 3
    Reference t = new Reference();
    if (this.authorizingPrescription == null)
      this.authorizingPrescription = new ArrayList<Reference>();
    this.authorizingPrescription.add(t);
    return t;
  }

  public MedicationDispense addAuthorizingPrescription(Reference t) { // 3
    if (t == null)
      return this;
    if (this.authorizingPrescription == null)
      this.authorizingPrescription = new ArrayList<Reference>();
    this.authorizingPrescription.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field
   *         {@link #authorizingPrescription}, creating it if it does not already
   *         exist
   */
  public Reference getAuthorizingPrescriptionFirstRep() {
    if (getAuthorizingPrescription().isEmpty()) {
      addAuthorizingPrescription();
    }
    return getAuthorizingPrescription().get(0);
  }

  /**
   * @return {@link #type} (Indicates the type of dispensing event that is
   *         performed. For example, Trial Fill, Completion of Trial, Partial
   *         Fill, Emergency Fill, Samples, etc.)
   */
  public CodeableConcept getType() {
    if (this.type == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.type");
      else if (Configuration.doAutoCreate())
        this.type = new CodeableConcept(); // cc
    return this.type;
  }

  public boolean hasType() {
    return this.type != null && !this.type.isEmpty();
  }

  /**
   * @param value {@link #type} (Indicates the type of dispensing event that is
   *              performed. For example, Trial Fill, Completion of Trial, Partial
   *              Fill, Emergency Fill, Samples, etc.)
   */
  public MedicationDispense setType(CodeableConcept value) {
    this.type = value;
    return this;
  }

  /**
   * @return {@link #quantity} (The amount of medication that has been dispensed.
   *         Includes unit of measure.)
   */
  public Quantity getQuantity() {
    if (this.quantity == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.quantity");
      else if (Configuration.doAutoCreate())
        this.quantity = new Quantity(); // cc
    return this.quantity;
  }

  public boolean hasQuantity() {
    return this.quantity != null && !this.quantity.isEmpty();
  }

  /**
   * @param value {@link #quantity} (The amount of medication that has been
   *              dispensed. Includes unit of measure.)
   */
  public MedicationDispense setQuantity(Quantity value) {
    this.quantity = value;
    return this;
  }

  /**
   * @return {@link #daysSupply} (The amount of medication expressed as a timing
   *         amount.)
   */
  public Quantity getDaysSupply() {
    if (this.daysSupply == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.daysSupply");
      else if (Configuration.doAutoCreate())
        this.daysSupply = new Quantity(); // cc
    return this.daysSupply;
  }

  public boolean hasDaysSupply() {
    return this.daysSupply != null && !this.daysSupply.isEmpty();
  }

  /**
   * @param value {@link #daysSupply} (The amount of medication expressed as a
   *              timing amount.)
   */
  public MedicationDispense setDaysSupply(Quantity value) {
    this.daysSupply = value;
    return this;
  }

  /**
   * @return {@link #whenPrepared} (The time when the dispensed product was
   *         packaged and reviewed.). This is the underlying object with id, value
   *         and extensions. The accessor "getWhenPrepared" gives direct access to
   *         the value
   */
  public DateTimeType getWhenPreparedElement() {
    if (this.whenPrepared == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.whenPrepared");
      else if (Configuration.doAutoCreate())
        this.whenPrepared = new DateTimeType(); // bb
    return this.whenPrepared;
  }

  public boolean hasWhenPreparedElement() {
    return this.whenPrepared != null && !this.whenPrepared.isEmpty();
  }

  public boolean hasWhenPrepared() {
    return this.whenPrepared != null && !this.whenPrepared.isEmpty();
  }

  /**
   * @param value {@link #whenPrepared} (The time when the dispensed product was
   *              packaged and reviewed.). This is the underlying object with id,
   *              value and extensions. The accessor "getWhenPrepared" gives
   *              direct access to the value
   */
  public MedicationDispense setWhenPreparedElement(DateTimeType value) {
    this.whenPrepared = value;
    return this;
  }

  /**
   * @return The time when the dispensed product was packaged and reviewed.
   */
  public Date getWhenPrepared() {
    return this.whenPrepared == null ? null : this.whenPrepared.getValue();
  }

  /**
   * @param value The time when the dispensed product was packaged and reviewed.
   */
  public MedicationDispense setWhenPrepared(Date value) {
    if (value == null)
      this.whenPrepared = null;
    else {
      if (this.whenPrepared == null)
        this.whenPrepared = new DateTimeType();
      this.whenPrepared.setValue(value);
    }
    return this;
  }

  /**
   * @return {@link #whenHandedOver} (The time the dispensed product was provided
   *         to the patient or their representative.). This is the underlying
   *         object with id, value and extensions. The accessor
   *         "getWhenHandedOver" gives direct access to the value
   */
  public DateTimeType getWhenHandedOverElement() {
    if (this.whenHandedOver == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.whenHandedOver");
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
   * @param value {@link #whenHandedOver} (The time the dispensed product was
   *              provided to the patient or their representative.). This is the
   *              underlying object with id, value and extensions. The accessor
   *              "getWhenHandedOver" gives direct access to the value
   */
  public MedicationDispense setWhenHandedOverElement(DateTimeType value) {
    this.whenHandedOver = value;
    return this;
  }

  /**
   * @return The time the dispensed product was provided to the patient or their
   *         representative.
   */
  public Date getWhenHandedOver() {
    return this.whenHandedOver == null ? null : this.whenHandedOver.getValue();
  }

  /**
   * @param value The time the dispensed product was provided to the patient or
   *              their representative.
   */
  public MedicationDispense setWhenHandedOver(Date value) {
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
   * @return {@link #destination} (Identification of the facility/location where
   *         the medication was shipped to, as part of the dispense event.)
   */
  public Reference getDestination() {
    if (this.destination == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.destination");
      else if (Configuration.doAutoCreate())
        this.destination = new Reference(); // cc
    return this.destination;
  }

  public boolean hasDestination() {
    return this.destination != null && !this.destination.isEmpty();
  }

  /**
   * @param value {@link #destination} (Identification of the facility/location
   *              where the medication was shipped to, as part of the dispense
   *              event.)
   */
  public MedicationDispense setDestination(Reference value) {
    this.destination = value;
    return this;
  }

  /**
   * @return {@link #destination} The actual object that is the target of the
   *         reference. The reference library doesn't populate this, but you can
   *         use it to hold the resource if you resolve it. (Identification of the
   *         facility/location where the medication was shipped to, as part of the
   *         dispense event.)
   */
  public Location getDestinationTarget() {
    if (this.destinationTarget == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.destination");
      else if (Configuration.doAutoCreate())
        this.destinationTarget = new Location(); // aa
    return this.destinationTarget;
  }

  /**
   * @param value {@link #destination} The actual object that is the target of the
   *              reference. The reference library doesn't use these, but you can
   *              use it to hold the resource if you resolve it. (Identification
   *              of the facility/location where the medication was shipped to, as
   *              part of the dispense event.)
   */
  public MedicationDispense setDestinationTarget(Location value) {
    this.destinationTarget = value;
    return this;
  }

  /**
   * @return {@link #receiver} (Identifies the person who picked up the
   *         medication. This will usually be a patient or their caregiver, but
   *         some cases exist where it can be a healthcare professional.)
   */
  public List<Reference> getReceiver() {
    if (this.receiver == null)
      this.receiver = new ArrayList<Reference>();
    return this.receiver;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setReceiver(List<Reference> theReceiver) {
    this.receiver = theReceiver;
    return this;
  }

  public boolean hasReceiver() {
    if (this.receiver == null)
      return false;
    for (Reference item : this.receiver)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Reference addReceiver() { // 3
    Reference t = new Reference();
    if (this.receiver == null)
      this.receiver = new ArrayList<Reference>();
    this.receiver.add(t);
    return t;
  }

  public MedicationDispense addReceiver(Reference t) { // 3
    if (t == null)
      return this;
    if (this.receiver == null)
      this.receiver = new ArrayList<Reference>();
    this.receiver.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #receiver}, creating
   *         it if it does not already exist
   */
  public Reference getReceiverFirstRep() {
    if (getReceiver().isEmpty()) {
      addReceiver();
    }
    return getReceiver().get(0);
  }

  /**
   * @return {@link #note} (Extra information about the dispense that could not be
   *         conveyed in the other attributes.)
   */
  public List<Annotation> getNote() {
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    return this.note;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setNote(List<Annotation> theNote) {
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

  public Annotation addNote() { // 3
    Annotation t = new Annotation();
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    this.note.add(t);
    return t;
  }

  public MedicationDispense addNote(Annotation t) { // 3
    if (t == null)
      return this;
    if (this.note == null)
      this.note = new ArrayList<Annotation>();
    this.note.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #note}, creating it if
   *         it does not already exist
   */
  public Annotation getNoteFirstRep() {
    if (getNote().isEmpty()) {
      addNote();
    }
    return getNote().get(0);
  }

  /**
   * @return {@link #dosageInstruction} (Indicates how the medication is to be
   *         used by the patient.)
   */
  public List<Dosage> getDosageInstruction() {
    if (this.dosageInstruction == null)
      this.dosageInstruction = new ArrayList<Dosage>();
    return this.dosageInstruction;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setDosageInstruction(List<Dosage> theDosageInstruction) {
    this.dosageInstruction = theDosageInstruction;
    return this;
  }

  public boolean hasDosageInstruction() {
    if (this.dosageInstruction == null)
      return false;
    for (Dosage item : this.dosageInstruction)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Dosage addDosageInstruction() { // 3
    Dosage t = new Dosage();
    if (this.dosageInstruction == null)
      this.dosageInstruction = new ArrayList<Dosage>();
    this.dosageInstruction.add(t);
    return t;
  }

  public MedicationDispense addDosageInstruction(Dosage t) { // 3
    if (t == null)
      return this;
    if (this.dosageInstruction == null)
      this.dosageInstruction = new ArrayList<Dosage>();
    this.dosageInstruction.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #dosageInstruction},
   *         creating it if it does not already exist
   */
  public Dosage getDosageInstructionFirstRep() {
    if (getDosageInstruction().isEmpty()) {
      addDosageInstruction();
    }
    return getDosageInstruction().get(0);
  }

  /**
   * @return {@link #substitution} (Indicates whether or not substitution was made
   *         as part of the dispense. In some cases, substitution will be expected
   *         but does not happen, in other cases substitution is not expected but
   *         does happen. This block explains what substitution did or did not
   *         happen and why. If nothing is specified, substitution was not done.)
   */
  public MedicationDispenseSubstitutionComponent getSubstitution() {
    if (this.substitution == null)
      if (Configuration.errorOnAutoCreate())
        throw new Error("Attempt to auto-create MedicationDispense.substitution");
      else if (Configuration.doAutoCreate())
        this.substitution = new MedicationDispenseSubstitutionComponent(); // cc
    return this.substitution;
  }

  public boolean hasSubstitution() {
    return this.substitution != null && !this.substitution.isEmpty();
  }

  /**
   * @param value {@link #substitution} (Indicates whether or not substitution was
   *              made as part of the dispense. In some cases, substitution will
   *              be expected but does not happen, in other cases substitution is
   *              not expected but does happen. This block explains what
   *              substitution did or did not happen and why. If nothing is
   *              specified, substitution was not done.)
   */
  public MedicationDispense setSubstitution(MedicationDispenseSubstitutionComponent value) {
    this.substitution = value;
    return this;
  }

  /**
   * @return {@link #detectedIssue} (Indicates an actual or potential clinical
   *         issue with or between one or more active or proposed clinical actions
   *         for a patient; e.g. drug-drug interaction, duplicate therapy, dosage
   *         alert etc.)
   */
  public List<Reference> getDetectedIssue() {
    if (this.detectedIssue == null)
      this.detectedIssue = new ArrayList<Reference>();
    return this.detectedIssue;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setDetectedIssue(List<Reference> theDetectedIssue) {
    this.detectedIssue = theDetectedIssue;
    return this;
  }

  public boolean hasDetectedIssue() {
    if (this.detectedIssue == null)
      return false;
    for (Reference item : this.detectedIssue)
      if (!item.isEmpty())
        return true;
    return false;
  }

  public Reference addDetectedIssue() { // 3
    Reference t = new Reference();
    if (this.detectedIssue == null)
      this.detectedIssue = new ArrayList<Reference>();
    this.detectedIssue.add(t);
    return t;
  }

  public MedicationDispense addDetectedIssue(Reference t) { // 3
    if (t == null)
      return this;
    if (this.detectedIssue == null)
      this.detectedIssue = new ArrayList<Reference>();
    this.detectedIssue.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #detectedIssue},
   *         creating it if it does not already exist
   */
  public Reference getDetectedIssueFirstRep() {
    if (getDetectedIssue().isEmpty()) {
      addDetectedIssue();
    }
    return getDetectedIssue().get(0);
  }

  /**
   * @return {@link #eventHistory} (A summary of the events of interest that have
   *         occurred, such as when the dispense was verified.)
   */
  public List<Reference> getEventHistory() {
    if (this.eventHistory == null)
      this.eventHistory = new ArrayList<Reference>();
    return this.eventHistory;
  }

  /**
   * @return Returns a reference to <code>this</code> for easy method chaining
   */
  public MedicationDispense setEventHistory(List<Reference> theEventHistory) {
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

  public Reference addEventHistory() { // 3
    Reference t = new Reference();
    if (this.eventHistory == null)
      this.eventHistory = new ArrayList<Reference>();
    this.eventHistory.add(t);
    return t;
  }

  public MedicationDispense addEventHistory(Reference t) { // 3
    if (t == null)
      return this;
    if (this.eventHistory == null)
      this.eventHistory = new ArrayList<Reference>();
    this.eventHistory.add(t);
    return this;
  }

  /**
   * @return The first repetition of repeating field {@link #eventHistory},
   *         creating it if it does not already exist
   */
  public Reference getEventHistoryFirstRep() {
    if (getEventHistory().isEmpty()) {
      addEventHistory();
    }
    return getEventHistory().get(0);
  }

  protected void listChildren(List<Property> children) {
    super.listChildren(children);
    children.add(new Property("identifier", "Identifier",
        "Identifiers associated with this Medication Dispense that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.",
        0, java.lang.Integer.MAX_VALUE, identifier));
    children.add(new Property("partOf", "Reference(Procedure)", "The procedure that trigger the dispense.", 0,
        java.lang.Integer.MAX_VALUE, partOf));
    children.add(
        new Property("status", "code", "A code specifying the state of the set of dispense events.", 0, 1, status));
    children.add(new Property("statusReason[x]", "CodeableConcept|Reference(DetectedIssue)",
        "Indicates the reason why a dispense was not performed.", 0, 1, statusReason));
    children.add(new Property("category", "CodeableConcept",
        "Indicates the type of medication dispense (for example, where the medication is expected to be consumed or administered (i.e. inpatient or outpatient)).",
        0, 1, category));
    children.add(new Property("medication[x]", "CodeableConcept|Reference(Medication)",
        "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.",
        0, 1, medication));
    children.add(new Property("subject", "Reference(Patient|Group)",
        "A link to a resource representing the person or the group to whom the medication will be given.", 0, 1,
        subject));
    children.add(new Property("context", "Reference(Encounter|EpisodeOfCare)",
        "The encounter or episode of care that establishes the context for this event.", 0, 1, context));
    children.add(new Property("supportingInformation", "Reference(Any)",
        "Additional information that supports the medication being dispensed.", 0, java.lang.Integer.MAX_VALUE,
        supportingInformation));
    children.add(new Property("performer", "", "Indicates who or what performed the event.", 0,
        java.lang.Integer.MAX_VALUE, performer));
    children.add(new Property("location", "Reference(Location)",
        "The principal physical location where the dispense was performed.", 0, 1, location));
    children.add(new Property("authorizingPrescription", "Reference(MedicationRequest)",
        "Indicates the medication order that is being dispensed against.", 0, java.lang.Integer.MAX_VALUE,
        authorizingPrescription));
    children.add(new Property("type", "CodeableConcept",
        "Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc.",
        0, 1, type));
    children.add(new Property("quantity", "SimpleQuantity",
        "The amount of medication that has been dispensed. Includes unit of measure.", 0, 1, quantity));
    children.add(new Property("daysSupply", "SimpleQuantity", "The amount of medication expressed as a timing amount.",
        0, 1, daysSupply));
    children.add(new Property("whenPrepared", "dateTime",
        "The time when the dispensed product was packaged and reviewed.", 0, 1, whenPrepared));
    children.add(new Property("whenHandedOver", "dateTime",
        "The time the dispensed product was provided to the patient or their representative.", 0, 1, whenHandedOver));
    children.add(new Property("destination", "Reference(Location)",
        "Identification of the facility/location where the medication was shipped to, as part of the dispense event.",
        0, 1, destination));
    children.add(new Property("receiver", "Reference(Patient|Practitioner)",
        "Identifies the person who picked up the medication.  This will usually be a patient or their caregiver, but some cases exist where it can be a healthcare professional.",
        0, java.lang.Integer.MAX_VALUE, receiver));
    children.add(new Property("note", "Annotation",
        "Extra information about the dispense that could not be conveyed in the other attributes.", 0,
        java.lang.Integer.MAX_VALUE, note));
    children
        .add(new Property("dosageInstruction", "Dosage", "Indicates how the medication is to be used by the patient.",
            0, java.lang.Integer.MAX_VALUE, dosageInstruction));
    children.add(new Property("substitution", "",
        "Indicates whether or not substitution was made as part of the dispense.  In some cases, substitution will be expected but does not happen, in other cases substitution is not expected but does happen.  This block explains what substitution did or did not happen and why.  If nothing is specified, substitution was not done.",
        0, 1, substitution));
    children.add(new Property("detectedIssue", "Reference(DetectedIssue)",
        "Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. drug-drug interaction, duplicate therapy, dosage alert etc.",
        0, java.lang.Integer.MAX_VALUE, detectedIssue));
    children.add(new Property("eventHistory", "Reference(Provenance)",
        "A summary of the events of interest that have occurred, such as when the dispense was verified.", 0,
        java.lang.Integer.MAX_VALUE, eventHistory));
  }

  @Override
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    switch (_hash) {
    case -1618432855:
      /* identifier */ return new Property("identifier", "Identifier",
          "Identifiers associated with this Medication Dispense that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.",
          0, java.lang.Integer.MAX_VALUE, identifier);
    case -995410646:
      /* partOf */ return new Property("partOf", "Reference(Procedure)", "The procedure that trigger the dispense.", 0,
          java.lang.Integer.MAX_VALUE, partOf);
    case -892481550:
      /* status */ return new Property("status", "code", "A code specifying the state of the set of dispense events.",
          0, 1, status);
    case -1421632534:
      /* statusReason[x] */ return new Property("statusReason[x]", "CodeableConcept|Reference(DetectedIssue)",
          "Indicates the reason why a dispense was not performed.", 0, 1, statusReason);
    case 2051346646:
      /* statusReason */ return new Property("statusReason[x]", "CodeableConcept|Reference(DetectedIssue)",
          "Indicates the reason why a dispense was not performed.", 0, 1, statusReason);
    case 2082934763:
      /* statusReasonCodeableConcept */ return new Property("statusReason[x]",
          "CodeableConcept|Reference(DetectedIssue)", "Indicates the reason why a dispense was not performed.", 0, 1,
          statusReason);
    case 1344200469:
      /* statusReasonReference */ return new Property("statusReason[x]", "CodeableConcept|Reference(DetectedIssue)",
          "Indicates the reason why a dispense was not performed.", 0, 1, statusReason);
    case 50511102:
      /* category */ return new Property("category", "CodeableConcept",
          "Indicates the type of medication dispense (for example, where the medication is expected to be consumed or administered (i.e. inpatient or outpatient)).",
          0, 1, category);
    case 1458402129:
      /* medication[x] */ return new Property("medication[x]", "CodeableConcept|Reference(Medication)",
          "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.",
          0, 1, medication);
    case 1998965455:
      /* medication */ return new Property("medication[x]", "CodeableConcept|Reference(Medication)",
          "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.",
          0, 1, medication);
    case -209845038:
      /* medicationCodeableConcept */ return new Property("medication[x]", "CodeableConcept|Reference(Medication)",
          "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.",
          0, 1, medication);
    case 2104315196:
      /* medicationReference */ return new Property("medication[x]", "CodeableConcept|Reference(Medication)",
          "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.",
          0, 1, medication);
    case -1867885268:
      /* subject */ return new Property("subject", "Reference(Patient|Group)",
          "A link to a resource representing the person or the group to whom the medication will be given.", 0, 1,
          subject);
    case 951530927:
      /* context */ return new Property("context", "Reference(Encounter|EpisodeOfCare)",
          "The encounter or episode of care that establishes the context for this event.", 0, 1, context);
    case -1248768647:
      /* supportingInformation */ return new Property("supportingInformation", "Reference(Any)",
          "Additional information that supports the medication being dispensed.", 0, java.lang.Integer.MAX_VALUE,
          supportingInformation);
    case 481140686:
      /* performer */ return new Property("performer", "", "Indicates who or what performed the event.", 0,
          java.lang.Integer.MAX_VALUE, performer);
    case 1901043637:
      /* location */ return new Property("location", "Reference(Location)",
          "The principal physical location where the dispense was performed.", 0, 1, location);
    case -1237557856:
      /* authorizingPrescription */ return new Property("authorizingPrescription", "Reference(MedicationRequest)",
          "Indicates the medication order that is being dispensed against.", 0, java.lang.Integer.MAX_VALUE,
          authorizingPrescription);
    case 3575610:
      /* type */ return new Property("type", "CodeableConcept",
          "Indicates the type of dispensing event that is performed. For example, Trial Fill, Completion of Trial, Partial Fill, Emergency Fill, Samples, etc.",
          0, 1, type);
    case -1285004149:
      /* quantity */ return new Property("quantity", "SimpleQuantity",
          "The amount of medication that has been dispensed. Includes unit of measure.", 0, 1, quantity);
    case 197175334:
      /* daysSupply */ return new Property("daysSupply", "SimpleQuantity",
          "The amount of medication expressed as a timing amount.", 0, 1, daysSupply);
    case -562837097:
      /* whenPrepared */ return new Property("whenPrepared", "dateTime",
          "The time when the dispensed product was packaged and reviewed.", 0, 1, whenPrepared);
    case -940241380:
      /* whenHandedOver */ return new Property("whenHandedOver", "dateTime",
          "The time the dispensed product was provided to the patient or their representative.", 0, 1, whenHandedOver);
    case -1429847026:
      /* destination */ return new Property("destination", "Reference(Location)",
          "Identification of the facility/location where the medication was shipped to, as part of the dispense event.",
          0, 1, destination);
    case -808719889:
      /* receiver */ return new Property("receiver", "Reference(Patient|Practitioner)",
          "Identifies the person who picked up the medication.  This will usually be a patient or their caregiver, but some cases exist where it can be a healthcare professional.",
          0, java.lang.Integer.MAX_VALUE, receiver);
    case 3387378:
      /* note */ return new Property("note", "Annotation",
          "Extra information about the dispense that could not be conveyed in the other attributes.", 0,
          java.lang.Integer.MAX_VALUE, note);
    case -1201373865:
      /* dosageInstruction */ return new Property("dosageInstruction", "Dosage",
          "Indicates how the medication is to be used by the patient.", 0, java.lang.Integer.MAX_VALUE,
          dosageInstruction);
    case 826147581:
      /* substitution */ return new Property("substitution", "",
          "Indicates whether or not substitution was made as part of the dispense.  In some cases, substitution will be expected but does not happen, in other cases substitution is not expected but does happen.  This block explains what substitution did or did not happen and why.  If nothing is specified, substitution was not done.",
          0, 1, substitution);
    case 51602295:
      /* detectedIssue */ return new Property("detectedIssue", "Reference(DetectedIssue)",
          "Indicates an actual or potential clinical issue with or between one or more active or proposed clinical actions for a patient; e.g. drug-drug interaction, duplicate therapy, dosage alert etc.",
          0, java.lang.Integer.MAX_VALUE, detectedIssue);
    case 1835190426:
      /* eventHistory */ return new Property("eventHistory", "Reference(Provenance)",
          "A summary of the events of interest that have occurred, such as when the dispense was verified.", 0,
          java.lang.Integer.MAX_VALUE, eventHistory);
    default:
      return super.getNamedProperty(_hash, _name, _checkValid);
    }

  }

  @Override
  public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
    switch (hash) {
    case -1618432855:
      /* identifier */ return this.identifier == null ? new Base[0]
          : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
    case -995410646:
      /* partOf */ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
    case -892481550:
      /* status */ return this.status == null ? new Base[0] : new Base[] { this.status }; // Enumeration<MedicationDispenseStatus>
    case 2051346646:
      /* statusReason */ return this.statusReason == null ? new Base[0] : new Base[] { this.statusReason }; // Type
    case 50511102:
      /* category */ return this.category == null ? new Base[0] : new Base[] { this.category }; // CodeableConcept
    case 1998965455:
      /* medication */ return this.medication == null ? new Base[0] : new Base[] { this.medication }; // Type
    case -1867885268:
      /* subject */ return this.subject == null ? new Base[0] : new Base[] { this.subject }; // Reference
    case 951530927:
      /* context */ return this.context == null ? new Base[0] : new Base[] { this.context }; // Reference
    case -1248768647:
      /* supportingInformation */ return this.supportingInformation == null ? new Base[0]
          : this.supportingInformation.toArray(new Base[this.supportingInformation.size()]); // Reference
    case 481140686:
      /* performer */ return this.performer == null ? new Base[0]
          : this.performer.toArray(new Base[this.performer.size()]); // MedicationDispensePerformerComponent
    case 1901043637:
      /* location */ return this.location == null ? new Base[0] : new Base[] { this.location }; // Reference
    case -1237557856:
      /* authorizingPrescription */ return this.authorizingPrescription == null ? new Base[0]
          : this.authorizingPrescription.toArray(new Base[this.authorizingPrescription.size()]); // Reference
    case 3575610:
      /* type */ return this.type == null ? new Base[0] : new Base[] { this.type }; // CodeableConcept
    case -1285004149:
      /* quantity */ return this.quantity == null ? new Base[0] : new Base[] { this.quantity }; // Quantity
    case 197175334:
      /* daysSupply */ return this.daysSupply == null ? new Base[0] : new Base[] { this.daysSupply }; // Quantity
    case -562837097:
      /* whenPrepared */ return this.whenPrepared == null ? new Base[0] : new Base[] { this.whenPrepared }; // DateTimeType
    case -940241380:
      /* whenHandedOver */ return this.whenHandedOver == null ? new Base[0] : new Base[] { this.whenHandedOver }; // DateTimeType
    case -1429847026:
      /* destination */ return this.destination == null ? new Base[0] : new Base[] { this.destination }; // Reference
    case -808719889:
      /* receiver */ return this.receiver == null ? new Base[0] : this.receiver.toArray(new Base[this.receiver.size()]); // Reference
    case 3387378:
      /* note */ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
    case -1201373865:
      /* dosageInstruction */ return this.dosageInstruction == null ? new Base[0]
          : this.dosageInstruction.toArray(new Base[this.dosageInstruction.size()]); // Dosage
    case 826147581:
      /* substitution */ return this.substitution == null ? new Base[0] : new Base[] { this.substitution }; // MedicationDispenseSubstitutionComponent
    case 51602295:
      /* detectedIssue */ return this.detectedIssue == null ? new Base[0]
          : this.detectedIssue.toArray(new Base[this.detectedIssue.size()]); // Reference
    case 1835190426:
      /* eventHistory */ return this.eventHistory == null ? new Base[0]
          : this.eventHistory.toArray(new Base[this.eventHistory.size()]); // Reference
    default:
      return super.getProperty(hash, name, checkValid);
    }

  }

  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    switch (hash) {
    case -1618432855: // identifier
      this.getIdentifier().add(castToIdentifier(value)); // Identifier
      return value;
    case -995410646: // partOf
      this.getPartOf().add(castToReference(value)); // Reference
      return value;
    case -892481550: // status
      value = new MedicationDispenseStatusEnumFactory().fromType(castToCode(value));
      this.status = (Enumeration) value; // Enumeration<MedicationDispenseStatus>
      return value;
    case 2051346646: // statusReason
      this.statusReason = castToType(value); // Type
      return value;
    case 50511102: // category
      this.category = castToCodeableConcept(value); // CodeableConcept
      return value;
    case 1998965455: // medication
      this.medication = castToType(value); // Type
      return value;
    case -1867885268: // subject
      this.subject = castToReference(value); // Reference
      return value;
    case 951530927: // context
      this.context = castToReference(value); // Reference
      return value;
    case -1248768647: // supportingInformation
      this.getSupportingInformation().add(castToReference(value)); // Reference
      return value;
    case 481140686: // performer
      this.getPerformer().add((MedicationDispensePerformerComponent) value); // MedicationDispensePerformerComponent
      return value;
    case 1901043637: // location
      this.location = castToReference(value); // Reference
      return value;
    case -1237557856: // authorizingPrescription
      this.getAuthorizingPrescription().add(castToReference(value)); // Reference
      return value;
    case 3575610: // type
      this.type = castToCodeableConcept(value); // CodeableConcept
      return value;
    case -1285004149: // quantity
      this.quantity = castToQuantity(value); // Quantity
      return value;
    case 197175334: // daysSupply
      this.daysSupply = castToQuantity(value); // Quantity
      return value;
    case -562837097: // whenPrepared
      this.whenPrepared = castToDateTime(value); // DateTimeType
      return value;
    case -940241380: // whenHandedOver
      this.whenHandedOver = castToDateTime(value); // DateTimeType
      return value;
    case -1429847026: // destination
      this.destination = castToReference(value); // Reference
      return value;
    case -808719889: // receiver
      this.getReceiver().add(castToReference(value)); // Reference
      return value;
    case 3387378: // note
      this.getNote().add(castToAnnotation(value)); // Annotation
      return value;
    case -1201373865: // dosageInstruction
      this.getDosageInstruction().add(castToDosage(value)); // Dosage
      return value;
    case 826147581: // substitution
      this.substitution = (MedicationDispenseSubstitutionComponent) value; // MedicationDispenseSubstitutionComponent
      return value;
    case 51602295: // detectedIssue
      this.getDetectedIssue().add(castToReference(value)); // Reference
      return value;
    case 1835190426: // eventHistory
      this.getEventHistory().add(castToReference(value)); // Reference
      return value;
    default:
      return super.setProperty(hash, name, value);
    }

  }

  @Override
  public Base setProperty(String name, Base value) throws FHIRException {
    if (name.equals("identifier")) {
      this.getIdentifier().add(castToIdentifier(value));
    } else if (name.equals("partOf")) {
      this.getPartOf().add(castToReference(value));
    } else if (name.equals("status")) {
      value = new MedicationDispenseStatusEnumFactory().fromType(castToCode(value));
      this.status = (Enumeration) value; // Enumeration<MedicationDispenseStatus>
    } else if (name.equals("statusReason[x]")) {
      this.statusReason = castToType(value); // Type
    } else if (name.equals("category")) {
      this.category = castToCodeableConcept(value); // CodeableConcept
    } else if (name.equals("medication[x]")) {
      this.medication = castToType(value); // Type
    } else if (name.equals("subject")) {
      this.subject = castToReference(value); // Reference
    } else if (name.equals("context")) {
      this.context = castToReference(value); // Reference
    } else if (name.equals("supportingInformation")) {
      this.getSupportingInformation().add(castToReference(value));
    } else if (name.equals("performer")) {
      this.getPerformer().add((MedicationDispensePerformerComponent) value);
    } else if (name.equals("location")) {
      this.location = castToReference(value); // Reference
    } else if (name.equals("authorizingPrescription")) {
      this.getAuthorizingPrescription().add(castToReference(value));
    } else if (name.equals("type")) {
      this.type = castToCodeableConcept(value); // CodeableConcept
    } else if (name.equals("quantity")) {
      this.quantity = castToQuantity(value); // Quantity
    } else if (name.equals("daysSupply")) {
      this.daysSupply = castToQuantity(value); // Quantity
    } else if (name.equals("whenPrepared")) {
      this.whenPrepared = castToDateTime(value); // DateTimeType
    } else if (name.equals("whenHandedOver")) {
      this.whenHandedOver = castToDateTime(value); // DateTimeType
    } else if (name.equals("destination")) {
      this.destination = castToReference(value); // Reference
    } else if (name.equals("receiver")) {
      this.getReceiver().add(castToReference(value));
    } else if (name.equals("note")) {
      this.getNote().add(castToAnnotation(value));
    } else if (name.equals("dosageInstruction")) {
      this.getDosageInstruction().add(castToDosage(value));
    } else if (name.equals("substitution")) {
      this.substitution = (MedicationDispenseSubstitutionComponent) value; // MedicationDispenseSubstitutionComponent
    } else if (name.equals("detectedIssue")) {
      this.getDetectedIssue().add(castToReference(value));
    } else if (name.equals("eventHistory")) {
      this.getEventHistory().add(castToReference(value));
    } else
      return super.setProperty(name, value);
    return value;
  }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
    if (name.equals("identifier")) {
      this.getIdentifier().remove(castToIdentifier(value));
    } else if (name.equals("partOf")) {
      this.getPartOf().remove(castToReference(value));
    } else if (name.equals("status")) {
      this.status = null;
    } else if (name.equals("statusReason[x]")) {
      this.statusReason = null;
    } else if (name.equals("category")) {
      this.category = null;
    } else if (name.equals("medication[x]")) {
      this.medication = null;
    } else if (name.equals("subject")) {
      this.subject = null;
    } else if (name.equals("context")) {
      this.context = null;
    } else if (name.equals("supportingInformation")) {
      this.getSupportingInformation().remove(castToReference(value));
    } else if (name.equals("performer")) {
      this.getPerformer().remove((MedicationDispensePerformerComponent) value);
    } else if (name.equals("location")) {
      this.location = null;
    } else if (name.equals("authorizingPrescription")) {
      this.getAuthorizingPrescription().remove(castToReference(value));
    } else if (name.equals("type")) {
      this.type = null;
    } else if (name.equals("quantity")) {
      this.quantity = null;
    } else if (name.equals("daysSupply")) {
      this.daysSupply = null;
    } else if (name.equals("whenPrepared")) {
      this.whenPrepared = null;
    } else if (name.equals("whenHandedOver")) {
      this.whenHandedOver = null;
    } else if (name.equals("destination")) {
      this.destination = null;
    } else if (name.equals("receiver")) {
      this.getReceiver().remove(castToReference(value));
    } else if (name.equals("note")) {
      this.getNote().remove(castToAnnotation(value));
    } else if (name.equals("dosageInstruction")) {
      this.getDosageInstruction().remove(castToDosage(value));
    } else if (name.equals("substitution")) {
      this.substitution = (MedicationDispenseSubstitutionComponent) value; // MedicationDispenseSubstitutionComponent
    } else if (name.equals("detectedIssue")) {
      this.getDetectedIssue().remove(castToReference(value));
    } else if (name.equals("eventHistory")) {
      this.getEventHistory().remove(castToReference(value));
    } else
      super.removeChild(name, value);
    
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -1618432855:
      return addIdentifier();
    case -995410646:
      return addPartOf();
    case -892481550:
      return getStatusElement();
    case -1421632534:
      return getStatusReason();
    case 2051346646:
      return getStatusReason();
    case 50511102:
      return getCategory();
    case 1458402129:
      return getMedication();
    case 1998965455:
      return getMedication();
    case -1867885268:
      return getSubject();
    case 951530927:
      return getContext();
    case -1248768647:
      return addSupportingInformation();
    case 481140686:
      return addPerformer();
    case 1901043637:
      return getLocation();
    case -1237557856:
      return addAuthorizingPrescription();
    case 3575610:
      return getType();
    case -1285004149:
      return getQuantity();
    case 197175334:
      return getDaysSupply();
    case -562837097:
      return getWhenPreparedElement();
    case -940241380:
      return getWhenHandedOverElement();
    case -1429847026:
      return getDestination();
    case -808719889:
      return addReceiver();
    case 3387378:
      return addNote();
    case -1201373865:
      return addDosageInstruction();
    case 826147581:
      return getSubstitution();
    case 51602295:
      return addDetectedIssue();
    case 1835190426:
      return addEventHistory();
    default:
      return super.makeProperty(hash, name);
    }

  }

  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    switch (hash) {
    case -1618432855:
      /* identifier */ return new String[] { "Identifier" };
    case -995410646:
      /* partOf */ return new String[] { "Reference" };
    case -892481550:
      /* status */ return new String[] { "code" };
    case 2051346646:
      /* statusReason */ return new String[] { "CodeableConcept", "Reference" };
    case 50511102:
      /* category */ return new String[] { "CodeableConcept" };
    case 1998965455:
      /* medication */ return new String[] { "CodeableConcept", "Reference" };
    case -1867885268:
      /* subject */ return new String[] { "Reference" };
    case 951530927:
      /* context */ return new String[] { "Reference" };
    case -1248768647:
      /* supportingInformation */ return new String[] { "Reference" };
    case 481140686:
      /* performer */ return new String[] {};
    case 1901043637:
      /* location */ return new String[] { "Reference" };
    case -1237557856:
      /* authorizingPrescription */ return new String[] { "Reference" };
    case 3575610:
      /* type */ return new String[] { "CodeableConcept" };
    case -1285004149:
      /* quantity */ return new String[] { "SimpleQuantity" };
    case 197175334:
      /* daysSupply */ return new String[] { "SimpleQuantity" };
    case -562837097:
      /* whenPrepared */ return new String[] { "dateTime" };
    case -940241380:
      /* whenHandedOver */ return new String[] { "dateTime" };
    case -1429847026:
      /* destination */ return new String[] { "Reference" };
    case -808719889:
      /* receiver */ return new String[] { "Reference" };
    case 3387378:
      /* note */ return new String[] { "Annotation" };
    case -1201373865:
      /* dosageInstruction */ return new String[] { "Dosage" };
    case 826147581:
      /* substitution */ return new String[] {};
    case 51602295:
      /* detectedIssue */ return new String[] { "Reference" };
    case 1835190426:
      /* eventHistory */ return new String[] { "Reference" };
    default:
      return super.getTypesForProperty(hash, name);
    }

  }

  @Override
  public Base addChild(String name) throws FHIRException {
    if (name.equals("identifier")) {
      return addIdentifier();
    } else if (name.equals("partOf")) {
      return addPartOf();
    } else if (name.equals("status")) {
      throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.status");
    } else if (name.equals("statusReasonCodeableConcept")) {
      this.statusReason = new CodeableConcept();
      return this.statusReason;
    } else if (name.equals("statusReasonReference")) {
      this.statusReason = new Reference();
      return this.statusReason;
    } else if (name.equals("category")) {
      this.category = new CodeableConcept();
      return this.category;
    } else if (name.equals("medicationCodeableConcept")) {
      this.medication = new CodeableConcept();
      return this.medication;
    } else if (name.equals("medicationReference")) {
      this.medication = new Reference();
      return this.medication;
    } else if (name.equals("subject")) {
      this.subject = new Reference();
      return this.subject;
    } else if (name.equals("context")) {
      this.context = new Reference();
      return this.context;
    } else if (name.equals("supportingInformation")) {
      return addSupportingInformation();
    } else if (name.equals("performer")) {
      return addPerformer();
    } else if (name.equals("location")) {
      this.location = new Reference();
      return this.location;
    } else if (name.equals("authorizingPrescription")) {
      return addAuthorizingPrescription();
    } else if (name.equals("type")) {
      this.type = new CodeableConcept();
      return this.type;
    } else if (name.equals("quantity")) {
      this.quantity = new Quantity();
      return this.quantity;
    } else if (name.equals("daysSupply")) {
      this.daysSupply = new Quantity();
      return this.daysSupply;
    } else if (name.equals("whenPrepared")) {
      throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.whenPrepared");
    } else if (name.equals("whenHandedOver")) {
      throw new FHIRException("Cannot call addChild on a singleton property MedicationDispense.whenHandedOver");
    } else if (name.equals("destination")) {
      this.destination = new Reference();
      return this.destination;
    } else if (name.equals("receiver")) {
      return addReceiver();
    } else if (name.equals("note")) {
      return addNote();
    } else if (name.equals("dosageInstruction")) {
      return addDosageInstruction();
    } else if (name.equals("substitution")) {
      this.substitution = new MedicationDispenseSubstitutionComponent();
      return this.substitution;
    } else if (name.equals("detectedIssue")) {
      return addDetectedIssue();
    } else if (name.equals("eventHistory")) {
      return addEventHistory();
    } else
      return super.addChild(name);
  }

  public String fhirType() {
    return "MedicationDispense";

  }

  public MedicationDispense copy() {
    MedicationDispense dst = new MedicationDispense();
    copyValues(dst);
    return dst;
  }

  public void copyValues(MedicationDispense dst) {
    super.copyValues(dst);
    if (identifier != null) {
      dst.identifier = new ArrayList<Identifier>();
      for (Identifier i : identifier)
        dst.identifier.add(i.copy());
    }
    ;
    if (partOf != null) {
      dst.partOf = new ArrayList<Reference>();
      for (Reference i : partOf)
        dst.partOf.add(i.copy());
    }
    ;
    dst.status = status == null ? null : status.copy();
    dst.statusReason = statusReason == null ? null : statusReason.copy();
    dst.category = category == null ? null : category.copy();
    dst.medication = medication == null ? null : medication.copy();
    dst.subject = subject == null ? null : subject.copy();
    dst.context = context == null ? null : context.copy();
    if (supportingInformation != null) {
      dst.supportingInformation = new ArrayList<Reference>();
      for (Reference i : supportingInformation)
        dst.supportingInformation.add(i.copy());
    }
    ;
    if (performer != null) {
      dst.performer = new ArrayList<MedicationDispensePerformerComponent>();
      for (MedicationDispensePerformerComponent i : performer)
        dst.performer.add(i.copy());
    }
    ;
    dst.location = location == null ? null : location.copy();
    if (authorizingPrescription != null) {
      dst.authorizingPrescription = new ArrayList<Reference>();
      for (Reference i : authorizingPrescription)
        dst.authorizingPrescription.add(i.copy());
    }
    ;
    dst.type = type == null ? null : type.copy();
    dst.quantity = quantity == null ? null : quantity.copy();
    dst.daysSupply = daysSupply == null ? null : daysSupply.copy();
    dst.whenPrepared = whenPrepared == null ? null : whenPrepared.copy();
    dst.whenHandedOver = whenHandedOver == null ? null : whenHandedOver.copy();
    dst.destination = destination == null ? null : destination.copy();
    if (receiver != null) {
      dst.receiver = new ArrayList<Reference>();
      for (Reference i : receiver)
        dst.receiver.add(i.copy());
    }
    ;
    if (note != null) {
      dst.note = new ArrayList<Annotation>();
      for (Annotation i : note)
        dst.note.add(i.copy());
    }
    ;
    if (dosageInstruction != null) {
      dst.dosageInstruction = new ArrayList<Dosage>();
      for (Dosage i : dosageInstruction)
        dst.dosageInstruction.add(i.copy());
    }
    ;
    dst.substitution = substitution == null ? null : substitution.copy();
    if (detectedIssue != null) {
      dst.detectedIssue = new ArrayList<Reference>();
      for (Reference i : detectedIssue)
        dst.detectedIssue.add(i.copy());
    }
    ;
    if (eventHistory != null) {
      dst.eventHistory = new ArrayList<Reference>();
      for (Reference i : eventHistory)
        dst.eventHistory.add(i.copy());
    }
    ;
  }

  protected MedicationDispense typedCopy() {
    return copy();
  }

  @Override
  public boolean equalsDeep(Base other_) {
    if (!super.equalsDeep(other_))
      return false;
    if (!(other_ instanceof MedicationDispense))
      return false;
    MedicationDispense o = (MedicationDispense) other_;
    return compareDeep(identifier, o.identifier, true) && compareDeep(partOf, o.partOf, true)
        && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true)
        && compareDeep(category, o.category, true) && compareDeep(medication, o.medication, true)
        && compareDeep(subject, o.subject, true) && compareDeep(context, o.context, true)
        && compareDeep(supportingInformation, o.supportingInformation, true)
        && compareDeep(performer, o.performer, true) && compareDeep(location, o.location, true)
        && compareDeep(authorizingPrescription, o.authorizingPrescription, true) && compareDeep(type, o.type, true)
        && compareDeep(quantity, o.quantity, true) && compareDeep(daysSupply, o.daysSupply, true)
        && compareDeep(whenPrepared, o.whenPrepared, true) && compareDeep(whenHandedOver, o.whenHandedOver, true)
        && compareDeep(destination, o.destination, true) && compareDeep(receiver, o.receiver, true)
        && compareDeep(note, o.note, true) && compareDeep(dosageInstruction, o.dosageInstruction, true)
        && compareDeep(substitution, o.substitution, true) && compareDeep(detectedIssue, o.detectedIssue, true)
        && compareDeep(eventHistory, o.eventHistory, true);
  }

  @Override
  public boolean equalsShallow(Base other_) {
    if (!super.equalsShallow(other_))
      return false;
    if (!(other_ instanceof MedicationDispense))
      return false;
    MedicationDispense o = (MedicationDispense) other_;
    return compareValues(status, o.status, true) && compareValues(whenPrepared, o.whenPrepared, true)
        && compareValues(whenHandedOver, o.whenHandedOver, true);
  }

  public boolean isEmpty() {
    return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, partOf, status, statusReason, category,
        medication, subject, context, supportingInformation, performer, location, authorizingPrescription, type,
        quantity, daysSupply, whenPrepared, whenHandedOver, destination, receiver, note, dosageInstruction,
        substitution, detectedIssue, eventHistory);
  }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicationDispense;
  }

  /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Returns dispenses with this external identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationDispense.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "identifier", path = "MedicationDispense.identifier", description = "Returns dispenses with this external identifier", type = "token")
  public static final String SP_IDENTIFIER = "identifier";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Returns dispenses with this external identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationDispense.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_IDENTIFIER);

  /**
   * Search parameter: <b>performer</b>
   * <p>
   * Description: <b>Returns dispenses performed by a specific individual</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.performer.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "performer", path = "MedicationDispense.performer.actor", description = "Returns dispenses performed by a specific individual", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Practitioner") }, target = { Device.class,
          Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class })
  public static final String SP_PERFORMER = "performer";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>performer</b>
   * <p>
   * Description: <b>Returns dispenses performed by a specific individual</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.performer.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_PERFORMER);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:performer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMER = new ca.uhn.fhir.model.api.Include(
      "MedicationDispense:performer").toLocked();

  /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Returns dispenses of this medicine code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationDispense.medicationCodeableConcept</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "code", path = "(MedicationDispense.medication as CodeableConcept)", description = "Returns dispenses of this medicine code", type = "token")
  public static final String SP_CODE = "code";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Returns dispenses of this medicine code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationDispense.medicationCodeableConcept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_CODE);

  /**
   * Search parameter: <b>receiver</b>
   * <p>
   * Description: <b>The identity of a receiver to list dispenses for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.receiver</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "receiver", path = "MedicationDispense.receiver", description = "The identity of a receiver to list dispenses for", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Patient"),
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Practitioner") }, target = { Patient.class,
          Practitioner.class })
  public static final String SP_RECEIVER = "receiver";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>receiver</b>
   * <p>
   * Description: <b>The identity of a receiver to list dispenses for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.receiver</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RECEIVER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_RECEIVER);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:receiver</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RECEIVER = new ca.uhn.fhir.model.api.Include(
      "MedicationDispense:receiver").toLocked();

  /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "subject", path = "MedicationDispense.subject", description = "The identity of a patient for whom to list dispenses", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Patient") }, target = { Group.class, Patient.class })
  public static final String SP_SUBJECT = "subject";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_SUBJECT);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include(
      "MedicationDispense:subject").toLocked();

  /**
   * Search parameter: <b>destination</b>
   * <p>
   * Description: <b>Returns dispenses that should be sent to a specific
   * destination</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.destination</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "destination", path = "MedicationDispense.destination", description = "Returns dispenses that should be sent to a specific destination", type = "reference", target = {
      Location.class })
  public static final String SP_DESTINATION = "destination";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>destination</b>
   * <p>
   * Description: <b>Returns dispenses that should be sent to a specific
   * destination</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.destination</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DESTINATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_DESTINATION);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:destination</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DESTINATION = new ca.uhn.fhir.model.api.Include(
      "MedicationDispense:destination").toLocked();

  /**
   * Search parameter: <b>medication</b>
   * <p>
   * Description: <b>Returns dispenses of this medicine resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.medicationReference</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "medication", path = "(MedicationDispense.medication as Reference)", description = "Returns dispenses of this medicine resource", type = "reference", target = {
      Medication.class })
  public static final String SP_MEDICATION = "medication";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>medication</b>
   * <p>
   * Description: <b>Returns dispenses of this medicine resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.medicationReference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MEDICATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_MEDICATION);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:medication</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MEDICATION = new ca.uhn.fhir.model.api.Include(
      "MedicationDispense:medication").toLocked();

  /**
   * Search parameter: <b>responsibleparty</b>
   * <p>
   * Description: <b>Returns dispenses with the specified responsible
   * party</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.substitution.responsibleParty</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "responsibleparty", path = "MedicationDispense.substitution.responsibleParty", description = "Returns dispenses with the specified responsible party", type = "reference", target = {
      Practitioner.class, PractitionerRole.class })
  public static final String SP_RESPONSIBLEPARTY = "responsibleparty";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>responsibleparty</b>
   * <p>
   * Description: <b>Returns dispenses with the specified responsible
   * party</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.substitution.responsibleParty</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam RESPONSIBLEPARTY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_RESPONSIBLEPARTY);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:responsibleparty</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_RESPONSIBLEPARTY = new ca.uhn.fhir.model.api.Include(
      "MedicationDispense:responsibleparty").toLocked();

  /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Returns dispenses of a specific type</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationDispense.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "type", path = "MedicationDispense.type", description = "Returns dispenses of a specific type", type = "token")
  public static final String SP_TYPE = "type";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Returns dispenses of a specific type</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationDispense.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_TYPE);

  /**
   * Search parameter: <b>whenhandedover</b>
   * <p>
   * Description: <b>Returns dispenses handed over on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.whenHandedOver</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "whenhandedover", path = "MedicationDispense.whenHandedOver", description = "Returns dispenses handed over on this date", type = "date")
  public static final String SP_WHENHANDEDOVER = "whenhandedover";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>whenhandedover</b>
   * <p>
   * Description: <b>Returns dispenses handed over on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.whenHandedOver</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam WHENHANDEDOVER = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_WHENHANDEDOVER);

  /**
   * Search parameter: <b>whenprepared</b>
   * <p>
   * Description: <b>Returns dispenses prepared on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.whenPrepared</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "whenprepared", path = "MedicationDispense.whenPrepared", description = "Returns dispenses prepared on this date", type = "date")
  public static final String SP_WHENPREPARED = "whenprepared";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>whenprepared</b>
   * <p>
   * Description: <b>Returns dispenses prepared on this date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationDispense.whenPrepared</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam WHENPREPARED = new ca.uhn.fhir.rest.gclient.DateClientParam(
      SP_WHENPREPARED);

  /**
   * Search parameter: <b>prescription</b>
   * <p>
   * Description: <b>The identity of a prescription to list dispenses from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.authorizingPrescription</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "prescription", path = "MedicationDispense.authorizingPrescription", description = "The identity of a prescription to list dispenses from", type = "reference", target = {
      MedicationRequest.class })
  public static final String SP_PRESCRIPTION = "prescription";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>prescription</b>
   * <p>
   * Description: <b>The identity of a prescription to list dispenses from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.authorizingPrescription</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRESCRIPTION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_PRESCRIPTION);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:prescription</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRESCRIPTION = new ca.uhn.fhir.model.api.Include(
      "MedicationDispense:prescription").toLocked();

  /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>The identity of a patient to list dispenses for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "patient", path = "MedicationDispense.subject.where(resolve() is Patient)", description = "The identity of a patient to list dispenses  for", type = "reference", providesMembershipIn = {
      @ca.uhn.fhir.model.api.annotation.Compartment(name = "Patient") }, target = { Patient.class })
  public static final String SP_PATIENT = "patient";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>The identity of a patient to list dispenses for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_PATIENT);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include(
      "MedicationDispense:patient").toLocked();

  /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>Returns dispenses with a specific context (episode or episode
   * of care)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.context</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "context", path = "MedicationDispense.context", description = "Returns dispenses with a specific context (episode or episode of care)", type = "reference", target = {
      Encounter.class, EpisodeOfCare.class })
  public static final String SP_CONTEXT = "context";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>Returns dispenses with a specific context (episode or episode
   * of care)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationDispense.context</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(
      SP_CONTEXT);

  /**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationDispense:context</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CONTEXT = new ca.uhn.fhir.model.api.Include(
      "MedicationDispense:context").toLocked();

  /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Returns dispenses with a specified dispense status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationDispense.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name = "status", path = "MedicationDispense.status", description = "Returns dispenses with a specified dispense status", type = "token")
  public static final String SP_STATUS = "status";
  /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Returns dispenses with a specified dispense status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationDispense.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(
      SP_STATUS);

}
