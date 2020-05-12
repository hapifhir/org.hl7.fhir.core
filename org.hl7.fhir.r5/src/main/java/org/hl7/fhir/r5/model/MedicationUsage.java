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
 * A record of a medication that is being consumed by a patient.   A MedicationUsage may indicate that the patient may be taking the medication now or has taken the medication in the past or will be taking the medication in the future.  The source of this information can be the patient, significant other (such as a family member or spouse), or a clinician.  A common scenario where this information is captured is during the history taking process during a patient visit or stay.   The medication information may come from sources such as the patient's memory, from a prescription bottle,  or from a list of medications the patient, clinician or other party maintains. 

The primary difference between a medicationusage and a medicationadministration is that the medication administration has complete administration information and is based on actual administration information from the person who administered the medication.  A medicationusage is often, if not always, less specific.  There is no required date/time when the medication was administered, in fact we only know that a source has reported the patient is taking this medication, where details such as time, quantity, or rate or even medication product may be incomplete or missing or less precise.  As stated earlier, the Medication Usage information may come from the patient's memory, from a prescription bottle or from a list of medications the patient, clinician or other party maintains.  Medication administration is more formal and is not missing detailed information.
 */
@ResourceDef(name="MedicationUsage", profile="http://hl7.org/fhir/StructureDefinition/MedicationUsage")
public class MedicationUsage extends DomainResource {

    public enum MedicationUsageStatusCodes {
        /**
         * The medication is still being taken.
         */
        ACTIVE, 
        /**
         * The medication is no longer being taken.
         */
        COMPLETED, 
        /**
         * Some of the actions that are implied by the medication usage may have occurred.  For example, the patient may have taken some of the medication.  Clinical decision support systems should take this status into account.
         */
        ENTEREDINERROR, 
        /**
         * The medication may be taken at some time in the future.
         */
        INTENDED, 
        /**
         * Actions implied by the usage have been permanently halted, before all of them occurred. This should not be used if the statement was entered in error.
         */
        STOPPED, 
        /**
         * Actions implied by the usage have been temporarily halted, but are expected to continue later. May also be called 'suspended'.
         */
        ONHOLD, 
        /**
         * The state of the medication use is not currently known.
         */
        UNKNOWN, 
        /**
         * The medication was not consumed by the patient
         */
        NOTTAKEN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static MedicationUsageStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("completed".equals(codeString))
          return COMPLETED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("intended".equals(codeString))
          return INTENDED;
        if ("stopped".equals(codeString))
          return STOPPED;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if ("not-taken".equals(codeString))
          return NOTTAKEN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown MedicationUsageStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case COMPLETED: return "completed";
            case ENTEREDINERROR: return "entered-in-error";
            case INTENDED: return "intended";
            case STOPPED: return "stopped";
            case ONHOLD: return "on-hold";
            case UNKNOWN: return "unknown";
            case NOTTAKEN: return "not-taken";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case COMPLETED: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case INTENDED: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case STOPPED: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case ONHOLD: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case UNKNOWN: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case NOTTAKEN: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The medication is still being taken.";
            case COMPLETED: return "The medication is no longer being taken.";
            case ENTEREDINERROR: return "Some of the actions that are implied by the medication usage may have occurred.  For example, the patient may have taken some of the medication.  Clinical decision support systems should take this status into account.";
            case INTENDED: return "The medication may be taken at some time in the future.";
            case STOPPED: return "Actions implied by the usage have been permanently halted, before all of them occurred. This should not be used if the statement was entered in error.";
            case ONHOLD: return "Actions implied by the usage have been temporarily halted, but are expected to continue later. May also be called 'suspended'.";
            case UNKNOWN: return "The state of the medication use is not currently known.";
            case NOTTAKEN: return "The medication was not consumed by the patient";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case COMPLETED: return "Completed";
            case ENTEREDINERROR: return "Entered in Error";
            case INTENDED: return "Intended";
            case STOPPED: return "Stopped";
            case ONHOLD: return "On Hold";
            case UNKNOWN: return "Unknown";
            case NOTTAKEN: return "Not Taken";
            default: return "?";
          }
        }
    }

  public static class MedicationUsageStatusCodesEnumFactory implements EnumFactory<MedicationUsageStatusCodes> {
    public MedicationUsageStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return MedicationUsageStatusCodes.ACTIVE;
        if ("completed".equals(codeString))
          return MedicationUsageStatusCodes.COMPLETED;
        if ("entered-in-error".equals(codeString))
          return MedicationUsageStatusCodes.ENTEREDINERROR;
        if ("intended".equals(codeString))
          return MedicationUsageStatusCodes.INTENDED;
        if ("stopped".equals(codeString))
          return MedicationUsageStatusCodes.STOPPED;
        if ("on-hold".equals(codeString))
          return MedicationUsageStatusCodes.ONHOLD;
        if ("unknown".equals(codeString))
          return MedicationUsageStatusCodes.UNKNOWN;
        if ("not-taken".equals(codeString))
          return MedicationUsageStatusCodes.NOTTAKEN;
        throw new IllegalArgumentException("Unknown MedicationUsageStatusCodes code '"+codeString+"'");
        }
        public Enumeration<MedicationUsageStatusCodes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MedicationUsageStatusCodes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.ACTIVE);
        if ("completed".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.COMPLETED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.ENTEREDINERROR);
        if ("intended".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.INTENDED);
        if ("stopped".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.STOPPED);
        if ("on-hold".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.ONHOLD);
        if ("unknown".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.UNKNOWN);
        if ("not-taken".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.NOTTAKEN);
        throw new FHIRException("Unknown MedicationUsageStatusCodes code '"+codeString+"'");
        }
    public String toCode(MedicationUsageStatusCodes code) {
      if (code == MedicationUsageStatusCodes.ACTIVE)
        return "active";
      if (code == MedicationUsageStatusCodes.COMPLETED)
        return "completed";
      if (code == MedicationUsageStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      if (code == MedicationUsageStatusCodes.INTENDED)
        return "intended";
      if (code == MedicationUsageStatusCodes.STOPPED)
        return "stopped";
      if (code == MedicationUsageStatusCodes.ONHOLD)
        return "on-hold";
      if (code == MedicationUsageStatusCodes.UNKNOWN)
        return "unknown";
      if (code == MedicationUsageStatusCodes.NOTTAKEN)
        return "not-taken";
      return "?";
      }
    public String toSystem(MedicationUsageStatusCodes code) {
      return code.getSystem();
      }
    }

    /**
     * Identifiers associated with this Medication Usage that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External identifier", formalDefinition="Identifiers associated with this Medication Usage that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * A plan, proposal or order that is fulfilled in whole or in part by this event.
     */
    @Child(name = "basedOn", type = {MedicationRequest.class, CarePlan.class, ServiceRequest.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Fulfils plan, proposal or order", formalDefinition="A plan, proposal or order that is fulfilled in whole or in part by this event." )
    protected List<Reference> basedOn;

    /**
     * A larger event of which this particular event is a component or step.
     */
    @Child(name = "partOf", type = {MedicationAdministration.class, MedicationDispense.class, MedicationUsage.class, Procedure.class, Observation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A larger event of which this particular event is a component or step." )
    protected List<Reference> partOf;

    /**
     * A code representing the patient or other source's judgment about the state of the medication used that this usage is about.  Generally, this will be active or completed.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | completed | entered-in-error | intended | stopped | on-hold | unknown | not-taken", formalDefinition="A code representing the patient or other source's judgment about the state of the medication used that this usage is about.  Generally, this will be active or completed." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-usage-status")
    protected Enumeration<MedicationUsageStatusCodes> status;

    /**
     * Captures the reason for the current state of the MedicationUsage.
     */
    @Child(name = "statusReason", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reason for current status", formalDefinition="Captures the reason for the current state of the MedicationUsage." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/reason-medication-status-codes")
    protected List<CodeableConcept> statusReason;

    /**
     * Type of medication usage (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type of medication usage", formalDefinition="Type of medication usage (for example, drug classification like ATC, where meds would be administered, legal category of the medication.)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-usage-admin-location")
    protected List<CodeableConcept> category;

    /**
     * Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.
     */
    @Child(name = "medication", type = {CodeableReference.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What medication was taken", formalDefinition="Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
    protected CodeableReference medication;

    /**
     * The person, animal or group who is/was taking the medication.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who is/was taking  the medication", formalDefinition="The person, animal or group who is/was taking the medication." )
    protected Reference subject;

    /**
     * The encounter that establishes the context for this MedicationUsage.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Encounter associated with MedicationUsage", formalDefinition="The encounter that establishes the context for this MedicationUsage." )
    protected Reference encounter;

    /**
     * The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).
     */
    @Child(name = "effective", type = {DateTimeType.class, Period.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date/time or interval when the medication is/was/will be taken", formalDefinition="The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken)." )
    protected DataType effective;

    /**
     * The date when the Medication Usage was asserted by the information source.
     */
    @Child(name = "dateAsserted", type = {DateTimeType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the usage was asserted?", formalDefinition="The date when the Medication Usage was asserted by the information source." )
    protected DateTimeType dateAsserted;

    /**
     * The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest.
     */
    @Child(name = "informationSource", type = {Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Organization.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Person or organization that provided the information about the taking of this medication", formalDefinition="The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest." )
    protected Reference informationSource;

    /**
     * Allows linking the MedicationUsage to the underlying MedicationRequest, or to other information that supports or is used to derive the MedicationUsage.
     */
    @Child(name = "derivedFrom", type = {Reference.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Link to information used to derive the MedicationUsage", formalDefinition="Allows linking the MedicationUsage to the underlying MedicationRequest, or to other information that supports or is used to derive the MedicationUsage." )
    protected List<Reference> derivedFrom;

    /**
     * A concept, Condition or observation that supports why the medication is being/was taken.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reason for why the medication is being/was taken", formalDefinition="A concept, Condition or observation that supports why the medication is being/was taken." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
    protected List<CodeableReference> reason;

    /**
     * Provides extra information about the Medication Usage that is not conveyed by the other attributes.
     */
    @Child(name = "note", type = {Annotation.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Further information about the usage", formalDefinition="Provides extra information about the Medication Usage that is not conveyed by the other attributes." )
    protected List<Annotation> note;

    /**
     * The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.
     */
    @Child(name = "renderedDosageInstruction", type = {StringType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Full representation of the dosage instructions", formalDefinition="The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses." )
    protected StringType renderedDosageInstruction;

    /**
     * Indicates how the medication is/was or should be taken by the patient.
     */
    @Child(name = "dosage", type = {Dosage.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Details of how medication is/was taken or should be taken", formalDefinition="Indicates how the medication is/was or should be taken by the patient." )
    protected List<Dosage> dosage;

    /**
     * Indicates if the medication is being consumed or administered as prescribed.
     */
    @Child(name = "takenAsOrdered", type = {BooleanType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Indicates if the medication is being consumed or administered as prescribed", formalDefinition="Indicates if the medication is being consumed or administered as prescribed." )
    protected BooleanType takenAsOrdered;

    private static final long serialVersionUID = 1177242918L;

  /**
   * Constructor
   */
    public MedicationUsage() {
      super();
    }

  /**
   * Constructor
   */
    public MedicationUsage(MedicationUsageStatusCodes status, CodeableReference medication, Reference subject) {
      super();
      this.setStatus(status);
      this.setMedication(medication);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Identifiers associated with this Medication Usage that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setIdentifier(List<Identifier> theIdentifier) { 
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

    public MedicationUsage addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (A plan, proposal or order that is fulfilled in whole or in part by this event.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setBasedOn(List<Reference> theBasedOn) { 
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

    public MedicationUsage addBasedOn(Reference t) { //3
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
     * @return {@link #partOf} (A larger event of which this particular event is a component or step.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setPartOf(List<Reference> thePartOf) { 
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

    public MedicationUsage addPartOf(Reference t) { //3
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
     * @return {@link #status} (A code representing the patient or other source's judgment about the state of the medication used that this usage is about.  Generally, this will be active or completed.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<MedicationUsageStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationUsage.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<MedicationUsageStatusCodes>(new MedicationUsageStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code representing the patient or other source's judgment about the state of the medication used that this usage is about.  Generally, this will be active or completed.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public MedicationUsage setStatusElement(Enumeration<MedicationUsageStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code representing the patient or other source's judgment about the state of the medication used that this usage is about.  Generally, this will be active or completed.
     */
    public MedicationUsageStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code representing the patient or other source's judgment about the state of the medication used that this usage is about.  Generally, this will be active or completed.
     */
    public MedicationUsage setStatus(MedicationUsageStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<MedicationUsageStatusCodes>(new MedicationUsageStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #statusReason} (Captures the reason for the current state of the MedicationUsage.)
     */
    public List<CodeableConcept> getStatusReason() { 
      if (this.statusReason == null)
        this.statusReason = new ArrayList<CodeableConcept>();
      return this.statusReason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setStatusReason(List<CodeableConcept> theStatusReason) { 
      this.statusReason = theStatusReason;
      return this;
    }

    public boolean hasStatusReason() { 
      if (this.statusReason == null)
        return false;
      for (CodeableConcept item : this.statusReason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addStatusReason() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.statusReason == null)
        this.statusReason = new ArrayList<CodeableConcept>();
      this.statusReason.add(t);
      return t;
    }

    public MedicationUsage addStatusReason(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.statusReason == null)
        this.statusReason = new ArrayList<CodeableConcept>();
      this.statusReason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #statusReason}, creating it if it does not already exist {3}
     */
    public CodeableConcept getStatusReasonFirstRep() { 
      if (getStatusReason().isEmpty()) {
        addStatusReason();
      }
      return getStatusReason().get(0);
    }

    /**
     * @return {@link #category} (Type of medication usage (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setCategory(List<CodeableConcept> theCategory) { 
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

    public MedicationUsage addCategory(CodeableConcept t) { //3
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
     * @return {@link #medication} (Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.)
     */
    public CodeableReference getMedication() { 
      if (this.medication == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationUsage.medication");
        else if (Configuration.doAutoCreate())
          this.medication = new CodeableReference(); // cc
      return this.medication;
    }

    public boolean hasMedication() { 
      return this.medication != null && !this.medication.isEmpty();
    }

    /**
     * @param value {@link #medication} (Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.)
     */
    public MedicationUsage setMedication(CodeableReference value) { 
      this.medication = value;
      return this;
    }

    /**
     * @return {@link #subject} (The person, animal or group who is/was taking the medication.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationUsage.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The person, animal or group who is/was taking the medication.)
     */
    public MedicationUsage setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The encounter that establishes the context for this MedicationUsage.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationUsage.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The encounter that establishes the context for this MedicationUsage.)
     */
    public MedicationUsage setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #effective} (The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).)
     */
    public DataType getEffective() { 
      return this.effective;
    }

    /**
     * @return {@link #effective} (The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).)
     */
    public DateTimeType getEffectiveDateTimeType() throws FHIRException { 
      if (this.effective == null)
        this.effective = new DateTimeType();
      if (!(this.effective instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (DateTimeType) this.effective;
    }

    public boolean hasEffectiveDateTimeType() { 
      return this != null && this.effective instanceof DateTimeType;
    }

    /**
     * @return {@link #effective} (The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).)
     */
    public Period getEffectivePeriod() throws FHIRException { 
      if (this.effective == null)
        this.effective = new Period();
      if (!(this.effective instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.effective.getClass().getName()+" was encountered");
      return (Period) this.effective;
    }

    public boolean hasEffectivePeriod() { 
      return this != null && this.effective instanceof Period;
    }

    public boolean hasEffective() { 
      return this.effective != null && !this.effective.isEmpty();
    }

    /**
     * @param value {@link #effective} (The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).)
     */
    public MedicationUsage setEffective(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period))
        throw new Error("Not the right type for MedicationUsage.effective[x]: "+value.fhirType());
      this.effective = value;
      return this;
    }

    /**
     * @return {@link #dateAsserted} (The date when the Medication Usage was asserted by the information source.). This is the underlying object with id, value and extensions. The accessor "getDateAsserted" gives direct access to the value
     */
    public DateTimeType getDateAssertedElement() { 
      if (this.dateAsserted == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationUsage.dateAsserted");
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
     * @param value {@link #dateAsserted} (The date when the Medication Usage was asserted by the information source.). This is the underlying object with id, value and extensions. The accessor "getDateAsserted" gives direct access to the value
     */
    public MedicationUsage setDateAssertedElement(DateTimeType value) { 
      this.dateAsserted = value;
      return this;
    }

    /**
     * @return The date when the Medication Usage was asserted by the information source.
     */
    public Date getDateAsserted() { 
      return this.dateAsserted == null ? null : this.dateAsserted.getValue();
    }

    /**
     * @param value The date when the Medication Usage was asserted by the information source.
     */
    public MedicationUsage setDateAsserted(Date value) { 
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
     * @return {@link #informationSource} (The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest.)
     */
    public Reference getInformationSource() { 
      if (this.informationSource == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationUsage.informationSource");
        else if (Configuration.doAutoCreate())
          this.informationSource = new Reference(); // cc
      return this.informationSource;
    }

    public boolean hasInformationSource() { 
      return this.informationSource != null && !this.informationSource.isEmpty();
    }

    /**
     * @param value {@link #informationSource} (The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest.)
     */
    public MedicationUsage setInformationSource(Reference value) { 
      this.informationSource = value;
      return this;
    }

    /**
     * @return {@link #derivedFrom} (Allows linking the MedicationUsage to the underlying MedicationRequest, or to other information that supports or is used to derive the MedicationUsage.)
     */
    public List<Reference> getDerivedFrom() { 
      if (this.derivedFrom == null)
        this.derivedFrom = new ArrayList<Reference>();
      return this.derivedFrom;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setDerivedFrom(List<Reference> theDerivedFrom) { 
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

    public MedicationUsage addDerivedFrom(Reference t) { //3
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
     * @return {@link #reason} (A concept, Condition or observation that supports why the medication is being/was taken.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setReason(List<CodeableReference> theReason) { 
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

    public MedicationUsage addReason(CodeableReference t) { //3
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
     * @return {@link #note} (Provides extra information about the Medication Usage that is not conveyed by the other attributes.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setNote(List<Annotation> theNote) { 
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

    public MedicationUsage addNote(Annotation t) { //3
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
     * @return {@link #renderedDosageInstruction} (The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.). This is the underlying object with id, value and extensions. The accessor "getRenderedDosageInstruction" gives direct access to the value
     */
    public StringType getRenderedDosageInstructionElement() { 
      if (this.renderedDosageInstruction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationUsage.renderedDosageInstruction");
        else if (Configuration.doAutoCreate())
          this.renderedDosageInstruction = new StringType(); // bb
      return this.renderedDosageInstruction;
    }

    public boolean hasRenderedDosageInstructionElement() { 
      return this.renderedDosageInstruction != null && !this.renderedDosageInstruction.isEmpty();
    }

    public boolean hasRenderedDosageInstruction() { 
      return this.renderedDosageInstruction != null && !this.renderedDosageInstruction.isEmpty();
    }

    /**
     * @param value {@link #renderedDosageInstruction} (The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.). This is the underlying object with id, value and extensions. The accessor "getRenderedDosageInstruction" gives direct access to the value
     */
    public MedicationUsage setRenderedDosageInstructionElement(StringType value) { 
      this.renderedDosageInstruction = value;
      return this;
    }

    /**
     * @return The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.
     */
    public String getRenderedDosageInstruction() { 
      return this.renderedDosageInstruction == null ? null : this.renderedDosageInstruction.getValue();
    }

    /**
     * @param value The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.
     */
    public MedicationUsage setRenderedDosageInstruction(String value) { 
      if (Utilities.noString(value))
        this.renderedDosageInstruction = null;
      else {
        if (this.renderedDosageInstruction == null)
          this.renderedDosageInstruction = new StringType();
        this.renderedDosageInstruction.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #dosage} (Indicates how the medication is/was or should be taken by the patient.)
     */
    public List<Dosage> getDosage() { 
      if (this.dosage == null)
        this.dosage = new ArrayList<Dosage>();
      return this.dosage;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setDosage(List<Dosage> theDosage) { 
      this.dosage = theDosage;
      return this;
    }

    public boolean hasDosage() { 
      if (this.dosage == null)
        return false;
      for (Dosage item : this.dosage)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Dosage addDosage() { //3
      Dosage t = new Dosage();
      if (this.dosage == null)
        this.dosage = new ArrayList<Dosage>();
      this.dosage.add(t);
      return t;
    }

    public MedicationUsage addDosage(Dosage t) { //3
      if (t == null)
        return this;
      if (this.dosage == null)
        this.dosage = new ArrayList<Dosage>();
      this.dosage.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #dosage}, creating it if it does not already exist {3}
     */
    public Dosage getDosageFirstRep() { 
      if (getDosage().isEmpty()) {
        addDosage();
      }
      return getDosage().get(0);
    }

    /**
     * @return {@link #takenAsOrdered} (Indicates if the medication is being consumed or administered as prescribed.). This is the underlying object with id, value and extensions. The accessor "getTakenAsOrdered" gives direct access to the value
     */
    public BooleanType getTakenAsOrderedElement() { 
      if (this.takenAsOrdered == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationUsage.takenAsOrdered");
        else if (Configuration.doAutoCreate())
          this.takenAsOrdered = new BooleanType(); // bb
      return this.takenAsOrdered;
    }

    public boolean hasTakenAsOrderedElement() { 
      return this.takenAsOrdered != null && !this.takenAsOrdered.isEmpty();
    }

    public boolean hasTakenAsOrdered() { 
      return this.takenAsOrdered != null && !this.takenAsOrdered.isEmpty();
    }

    /**
     * @param value {@link #takenAsOrdered} (Indicates if the medication is being consumed or administered as prescribed.). This is the underlying object with id, value and extensions. The accessor "getTakenAsOrdered" gives direct access to the value
     */
    public MedicationUsage setTakenAsOrderedElement(BooleanType value) { 
      this.takenAsOrdered = value;
      return this;
    }

    /**
     * @return Indicates if the medication is being consumed or administered as prescribed.
     */
    public boolean getTakenAsOrdered() { 
      return this.takenAsOrdered == null || this.takenAsOrdered.isEmpty() ? false : this.takenAsOrdered.getValue();
    }

    /**
     * @param value Indicates if the medication is being consumed or administered as prescribed.
     */
    public MedicationUsage setTakenAsOrdered(boolean value) { 
        if (this.takenAsOrdered == null)
          this.takenAsOrdered = new BooleanType();
        this.takenAsOrdered.setValue(value);
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers associated with this Medication Usage that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(MedicationRequest|CarePlan|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(MedicationAdministration|MedicationDispense|MedicationUsage|Procedure|Observation)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code representing the patient or other source's judgment about the state of the medication used that this usage is about.  Generally, this will be active or completed.", 0, 1, status));
        children.add(new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the MedicationUsage.", 0, java.lang.Integer.MAX_VALUE, statusReason));
        children.add(new Property("category", "CodeableConcept", "Type of medication usage (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("medication", "CodeableReference(Medication)", "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.", 0, 1, medication));
        children.add(new Property("subject", "Reference(Patient|Group)", "The person, animal or group who is/was taking the medication.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this MedicationUsage.", 0, 1, encounter));
        children.add(new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).", 0, 1, effective));
        children.add(new Property("dateAsserted", "dateTime", "The date when the Medication Usage was asserted by the information source.", 0, 1, dateAsserted));
        children.add(new Property("informationSource", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Organization)", "The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest.", 0, 1, informationSource));
        children.add(new Property("derivedFrom", "Reference(Any)", "Allows linking the MedicationUsage to the underlying MedicationRequest, or to other information that supports or is used to derive the MedicationUsage.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport)", "A concept, Condition or observation that supports why the medication is being/was taken.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("note", "Annotation", "Provides extra information about the Medication Usage that is not conveyed by the other attributes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("renderedDosageInstruction", "string", "The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.", 0, 1, renderedDosageInstruction));
        children.add(new Property("dosage", "Dosage", "Indicates how the medication is/was or should be taken by the patient.", 0, java.lang.Integer.MAX_VALUE, dosage));
        children.add(new Property("takenAsOrdered", "boolean", "Indicates if the medication is being consumed or administered as prescribed.", 0, 1, takenAsOrdered));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers associated with this Medication Usage that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(MedicationRequest|CarePlan|ServiceRequest)", "A plan, proposal or order that is fulfilled in whole or in part by this event.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(MedicationAdministration|MedicationDispense|MedicationUsage|Procedure|Observation)", "A larger event of which this particular event is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code representing the patient or other source's judgment about the state of the medication used that this usage is about.  Generally, this will be active or completed.", 0, 1, status);
        case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the MedicationUsage.", 0, java.lang.Integer.MAX_VALUE, statusReason);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Type of medication usage (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).", 0, java.lang.Integer.MAX_VALUE, category);
        case 1998965455: /*medication*/  return new Property("medication", "CodeableReference(Medication)", "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.", 0, 1, medication);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The person, animal or group who is/was taking the medication.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this MedicationUsage.", 0, 1, encounter);
        case 247104889: /*effective[x]*/  return new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).", 0, 1, effective);
        case -1468651097: /*effective*/  return new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).", 0, 1, effective);
        case -275306910: /*effectiveDateTime*/  return new Property("effective[x]", "dateTime", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).", 0, 1, effective);
        case -403934648: /*effectivePeriod*/  return new Property("effective[x]", "Period", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.status element is NotTaken).", 0, 1, effective);
        case -1980855245: /*dateAsserted*/  return new Property("dateAsserted", "dateTime", "The date when the Medication Usage was asserted by the information source.", 0, 1, dateAsserted);
        case -2123220889: /*informationSource*/  return new Property("informationSource", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Organization)", "The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest.", 0, 1, informationSource);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "Reference(Any)", "Allows linking the MedicationUsage to the underlying MedicationRequest, or to other information that supports or is used to derive the MedicationUsage.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport)", "A concept, Condition or observation that supports why the medication is being/was taken.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Provides extra information about the Medication Usage that is not conveyed by the other attributes.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1718902050: /*renderedDosageInstruction*/  return new Property("renderedDosageInstruction", "string", "The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.", 0, 1, renderedDosageInstruction);
        case -1326018889: /*dosage*/  return new Property("dosage", "Dosage", "Indicates how the medication is/was or should be taken by the patient.", 0, java.lang.Integer.MAX_VALUE, dosage);
        case 268106452: /*takenAsOrdered*/  return new Property("takenAsOrdered", "boolean", "Indicates if the medication is being consumed or administered as prescribed.", 0, 1, takenAsOrdered);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<MedicationUsageStatusCodes>
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : this.statusReason.toArray(new Base[this.statusReason.size()]); // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 1998965455: /*medication*/ return this.medication == null ? new Base[0] : new Base[] {this.medication}; // CodeableReference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1468651097: /*effective*/ return this.effective == null ? new Base[0] : new Base[] {this.effective}; // DataType
        case -1980855245: /*dateAsserted*/ return this.dateAsserted == null ? new Base[0] : new Base[] {this.dateAsserted}; // DateTimeType
        case -2123220889: /*informationSource*/ return this.informationSource == null ? new Base[0] : new Base[] {this.informationSource}; // Reference
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1718902050: /*renderedDosageInstruction*/ return this.renderedDosageInstruction == null ? new Base[0] : new Base[] {this.renderedDosageInstruction}; // StringType
        case -1326018889: /*dosage*/ return this.dosage == null ? new Base[0] : this.dosage.toArray(new Base[this.dosage.size()]); // Dosage
        case 268106452: /*takenAsOrdered*/ return this.takenAsOrdered == null ? new Base[0] : new Base[] {this.takenAsOrdered}; // BooleanType
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
          value = new MedicationUsageStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationUsageStatusCodes>
          return value;
        case 2051346646: // statusReason
          this.getStatusReason().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1998965455: // medication
          this.medication = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1468651097: // effective
          this.effective = TypeConvertor.castToType(value); // DataType
          return value;
        case -1980855245: // dateAsserted
          this.dateAsserted = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -2123220889: // informationSource
          this.informationSource = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1077922663: // derivedFrom
          this.getDerivedFrom().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1718902050: // renderedDosageInstruction
          this.renderedDosageInstruction = TypeConvertor.castToString(value); // StringType
          return value;
        case -1326018889: // dosage
          this.getDosage().add(TypeConvertor.castToDosage(value)); // Dosage
          return value;
        case 268106452: // takenAsOrdered
          this.takenAsOrdered = TypeConvertor.castToBoolean(value); // BooleanType
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
          value = new MedicationUsageStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationUsageStatusCodes>
        } else if (name.equals("statusReason")) {
          this.getStatusReason().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("medication")) {
          this.medication = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("effective[x]")) {
          this.effective = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("dateAsserted")) {
          this.dateAsserted = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("informationSource")) {
          this.informationSource = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(TypeConvertor.castToReference(value));
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("renderedDosageInstruction")) {
          this.renderedDosageInstruction = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("dosage")) {
          this.getDosage().add(TypeConvertor.castToDosage(value));
        } else if (name.equals("takenAsOrdered")) {
          this.takenAsOrdered = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case 2051346646:  return addStatusReason(); 
        case 50511102:  return addCategory(); 
        case 1998965455:  return getMedication();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case 247104889:  return getEffective();
        case -1468651097:  return getEffective();
        case -1980855245:  return getDateAssertedElement();
        case -2123220889:  return getInformationSource();
        case 1077922663:  return addDerivedFrom(); 
        case -934964668:  return addReason(); 
        case 3387378:  return addNote(); 
        case 1718902050:  return getRenderedDosageInstructionElement();
        case -1326018889:  return addDosage(); 
        case 268106452:  return getTakenAsOrderedElement();
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
        case 2051346646: /*statusReason*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 1998965455: /*medication*/ return new String[] {"CodeableReference"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1468651097: /*effective*/ return new String[] {"dateTime", "Period"};
        case -1980855245: /*dateAsserted*/ return new String[] {"dateTime"};
        case -2123220889: /*informationSource*/ return new String[] {"Reference"};
        case 1077922663: /*derivedFrom*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1718902050: /*renderedDosageInstruction*/ return new String[] {"string"};
        case -1326018889: /*dosage*/ return new String[] {"Dosage"};
        case 268106452: /*takenAsOrdered*/ return new String[] {"boolean"};
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
          throw new FHIRException("Cannot call addChild on a primitive type MedicationUsage.status");
        }
        else if (name.equals("statusReason")) {
          return addStatusReason();
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("medication")) {
          this.medication = new CodeableReference();
          return this.medication;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("effectiveDateTime")) {
          this.effective = new DateTimeType();
          return this.effective;
        }
        else if (name.equals("effectivePeriod")) {
          this.effective = new Period();
          return this.effective;
        }
        else if (name.equals("dateAsserted")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationUsage.dateAsserted");
        }
        else if (name.equals("informationSource")) {
          this.informationSource = new Reference();
          return this.informationSource;
        }
        else if (name.equals("derivedFrom")) {
          return addDerivedFrom();
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("renderedDosageInstruction")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationUsage.renderedDosageInstruction");
        }
        else if (name.equals("dosage")) {
          return addDosage();
        }
        else if (name.equals("takenAsOrdered")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationUsage.takenAsOrdered");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "MedicationUsage";

  }

      public MedicationUsage copy() {
        MedicationUsage dst = new MedicationUsage();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationUsage dst) {
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
        if (statusReason != null) {
          dst.statusReason = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : statusReason)
            dst.statusReason.add(i.copy());
        };
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.medication = medication == null ? null : medication.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.effective = effective == null ? null : effective.copy();
        dst.dateAsserted = dateAsserted == null ? null : dateAsserted.copy();
        dst.informationSource = informationSource == null ? null : informationSource.copy();
        if (derivedFrom != null) {
          dst.derivedFrom = new ArrayList<Reference>();
          for (Reference i : derivedFrom)
            dst.derivedFrom.add(i.copy());
        };
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.renderedDosageInstruction = renderedDosageInstruction == null ? null : renderedDosageInstruction.copy();
        if (dosage != null) {
          dst.dosage = new ArrayList<Dosage>();
          for (Dosage i : dosage)
            dst.dosage.add(i.copy());
        };
        dst.takenAsOrdered = takenAsOrdered == null ? null : takenAsOrdered.copy();
      }

      protected MedicationUsage typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationUsage))
          return false;
        MedicationUsage o = (MedicationUsage) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true) && compareDeep(category, o.category, true)
           && compareDeep(medication, o.medication, true) && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(effective, o.effective, true) && compareDeep(dateAsserted, o.dateAsserted, true)
           && compareDeep(informationSource, o.informationSource, true) && compareDeep(derivedFrom, o.derivedFrom, true)
           && compareDeep(reason, o.reason, true) && compareDeep(note, o.note, true) && compareDeep(renderedDosageInstruction, o.renderedDosageInstruction, true)
           && compareDeep(dosage, o.dosage, true) && compareDeep(takenAsOrdered, o.takenAsOrdered, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationUsage))
          return false;
        MedicationUsage o = (MedicationUsage) other_;
        return compareValues(status, o.status, true) && compareValues(dateAsserted, o.dateAsserted, true) && compareValues(renderedDosageInstruction, o.renderedDosageInstruction, true)
           && compareValues(takenAsOrdered, o.takenAsOrdered, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, partOf
          , status, statusReason, category, medication, subject, encounter, effective, dateAsserted
          , informationSource, derivedFrom, reason, note, renderedDosageInstruction, dosage
          , takenAsOrdered);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicationUsage;
   }

 /**
   * Search parameter: <b>adherence</b>
   * <p>
   * Description: <b>Returns statements based on adherence or compliance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationUsage.takenAsOrdered</b><br>
   * </p>
   */
  @SearchParamDefinition(name="adherence", path="MedicationUsage.takenAsOrdered", description="Returns statements based on adherence or compliance", type="token" )
  public static final String SP_ADHERENCE = "adherence";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>adherence</b>
   * <p>
   * Description: <b>Returns statements based on adherence or compliance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationUsage.takenAsOrdered</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ADHERENCE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ADHERENCE);

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>Returns statements of this category of MedicationUsage</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationUsage.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="MedicationUsage.category", description="Returns statements of this category of MedicationUsage", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>Returns statements of this category of MedicationUsage</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationUsage.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>effective</b>
   * <p>
   * Description: <b>Date when patient was taking (or not taking) the medication</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationUsage.effective</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effective", path="MedicationUsage.effective", description="Date when patient was taking (or not taking) the medication", type="date" )
  public static final String SP_EFFECTIVE = "effective";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effective</b>
   * <p>
   * Description: <b>Date when patient was taking (or not taking) the medication</b><br>
   * Type: <b>date</b><br>
   * Path: <b>MedicationUsage.effective</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EFFECTIVE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EFFECTIVE);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Returns statements for a specific encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationUsage.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="MedicationUsage.encounter", description="Returns statements for a specific encounter", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Returns statements for a specific encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationUsage.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationUsage:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("MedicationUsage:encounter").toLocked();

 /**
   * Search parameter: <b>part-of</b>
   * <p>
   * Description: <b>Returns statements that are part of another event.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationUsage.partOf</b><br>
   * </p>
   */
  @SearchParamDefinition(name="part-of", path="MedicationUsage.partOf", description="Returns statements that are part of another event.", type="reference", target={MedicationAdministration.class, MedicationDispense.class, MedicationUsage.class, Observation.class, Procedure.class } )
  public static final String SP_PART_OF = "part-of";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>part-of</b>
   * <p>
   * Description: <b>Returns statements that are part of another event.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationUsage.partOf</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PART_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PART_OF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationUsage:part-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PART_OF = new ca.uhn.fhir.model.api.Include("MedicationUsage:part-of").toLocked();

 /**
   * Search parameter: <b>source</b>
   * <p>
   * Description: <b>Who or where the information in the statement came from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationUsage.informationSource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source", path="MedicationUsage.informationSource", description="Who or where the information in the statement came from", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_SOURCE = "source";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source</b>
   * <p>
   * Description: <b>Who or where the information in the statement came from</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationUsage.informationSource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SOURCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SOURCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationUsage:source</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SOURCE = new ca.uhn.fhir.model.api.Include("MedicationUsage:source").toLocked();

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient, animal or group to list statements for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationUsage.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="MedicationUsage.subject", description="The identity of a patient, animal or group to list statements for", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The identity of a patient, animal or group to list statements for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationUsage.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationUsage:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("MedicationUsage:subject").toLocked();

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [Condition](condition.html): Code for the condition
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationUsage](medicationusage.html): Return statements of this medication code
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [ServiceRequest](servicerequest.html): What is being requested/ordered
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code | ServiceRequest.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code | ServiceRequest.code", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance\r\n* [Condition](condition.html): Code for the condition\r\n* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered\r\n* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code\r\n* [List](list.html): What the purpose of this list is\r\n* [Medication](medication.html): Returns medications for a specific code\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code\r\n* [MedicationUsage](medicationusage.html): Return statements of this medication code\r\n* [Observation](observation.html): The code of the observation type\r\n* [Procedure](procedure.html): A code to identify a  procedure\r\n* [ServiceRequest](servicerequest.html): What is being requested/ordered\r\n", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [Condition](condition.html): Code for the condition
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationUsage](medicationusage.html): Return statements of this medication code
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [ServiceRequest](servicerequest.html): What is being requested/ordered
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.code | AllergyIntolerance.reaction.substance | Condition.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationUsage.medication.concept | Observation.code | Procedure.code | ServiceRequest.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Master Version Specific Identifier
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents\r\n* [DocumentReference](documentreference.html): Master Version Specific Identifier\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number\r\n* [Immunization](immunization.html): Business identifier\r\n* [List](list.html): Business identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationUsage](medicationusage.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentManifest](documentmanifest.html): Unique Identifier for the set of documents
* [DocumentReference](documentreference.html): Master Version Specific Identifier
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Goal](goal.html): External Ids for this goal
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID and Accession number
* [Immunization](immunization.html): Business identifier
* [List](list.html): Business identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationUsage](medicationusage.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Procedure](procedure.html): A unique identifier for a procedure
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.identifier | CarePlan.identifier | CareTeam.identifier | Composition.identifier | Condition.identifier | Consent.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DiagnosticReport.identifier | DocumentManifest.masterIdentifier | DocumentManifest.identifier | DocumentReference.masterIdentifier | DocumentReference.identifier | Encounter.identifier | EpisodeOfCare.identifier | FamilyMemberHistory.identifier | Goal.identifier | ImagingStudy.identifier | Immunization.identifier | List.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationUsage.identifier | NutritionOrder.identifier | Observation.identifier | Procedure.identifier | RiskAssessment.identifier | ServiceRequest.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | VisionPrescription.identifier</b><br>
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
* [ClinicalImpression](clinicalimpression.html): Patient or group assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient or group present at the encounter
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
* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ClinicalImpression](clinicalimpression.html): Patient or group assessed\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentManifest](documentmanifest.html): The subject of the set of documents\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient or group present at the encounter\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [List](list.html): If all resources have the same subject\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Group.class, Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ClinicalImpression](clinicalimpression.html): Patient or group assessed
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentManifest](documentmanifest.html): The subject of the set of documents
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient or group present at the encounter
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
* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Procedure](procedure.html): Search by subject - a patient
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationUsage:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("MedicationUsage:patient").toLocked();

 /**
   * Search parameter: <b>medication</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationAdministration](medicationadministration.html): Return administrations of this medication reference
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine resource
* [MedicationRequest](medicationrequest.html): Return prescriptions for this medication reference
* [MedicationUsage](medicationusage.html): Return statements of this medication reference
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationAdministration.medication.reference | MedicationDispense.medication.reference | MedicationRequest.medication.reference | MedicationUsage.medication.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="medication", path="MedicationAdministration.medication.reference | MedicationDispense.medication.reference | MedicationRequest.medication.reference | MedicationUsage.medication.reference", description="Multiple Resources: \r\n\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication reference\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine resource\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions for this medication reference\r\n* [MedicationUsage](medicationusage.html): Return statements of this medication reference\r\n", type="reference" )
  public static final String SP_MEDICATION = "medication";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>medication</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationAdministration](medicationadministration.html): Return administrations of this medication reference
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine resource
* [MedicationRequest](medicationrequest.html): Return prescriptions for this medication reference
* [MedicationUsage](medicationusage.html): Return statements of this medication reference
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationAdministration.medication.reference | MedicationDispense.medication.reference | MedicationRequest.medication.reference | MedicationUsage.medication.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MEDICATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MEDICATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationUsage:medication</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MEDICATION = new ca.uhn.fhir.model.api.Include("MedicationUsage:medication").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationAdministration](medicationadministration.html): MedicationAdministration event status (for example one of active/paused/completed/nullified)
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specified dispense status
* [MedicationRequest](medicationrequest.html): Status of the prescription
* [MedicationUsage](medicationusage.html): Return statements that match the given status
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationAdministration.status | MedicationDispense.status | MedicationRequest.status | MedicationUsage.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="MedicationAdministration.status | MedicationDispense.status | MedicationRequest.status | MedicationUsage.status", description="Multiple Resources: \r\n\r\n* [MedicationAdministration](medicationadministration.html): MedicationAdministration event status (for example one of active/paused/completed/nullified)\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with a specified dispense status\r\n* [MedicationRequest](medicationrequest.html): Status of the prescription\r\n* [MedicationUsage](medicationusage.html): Return statements that match the given status\r\n", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [MedicationAdministration](medicationadministration.html): MedicationAdministration event status (for example one of active/paused/completed/nullified)
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specified dispense status
* [MedicationRequest](medicationrequest.html): Status of the prescription
* [MedicationUsage](medicationusage.html): Return statements that match the given status
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationAdministration.status | MedicationDispense.status | MedicationRequest.status | MedicationUsage.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}