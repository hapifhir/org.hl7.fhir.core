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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR v5.0.0-snapshot2

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
         * The action of recording the medication statement is finished.
         */
        RECORDED, 
        /**
         * Some of the actions that are implied by the medication usage may have occurred.  For example, the patient may have taken some of the medication.  Clinical decision support systems should take this status into account.
         */
        ENTEREDINERROR, 
        /**
         * The medication usage is draft or preliminary.
         */
        DRAFT, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static MedicationUsageStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("recorded".equals(codeString))
          return RECORDED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("draft".equals(codeString))
          return DRAFT;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown MedicationUsageStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case RECORDED: return "recorded";
            case ENTEREDINERROR: return "entered-in-error";
            case DRAFT: return "draft";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case RECORDED: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case DRAFT: return "http://hl7.org/fhir/CodeSystem/medication-usage-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case RECORDED: return "The action of recording the medication statement is finished.";
            case ENTEREDINERROR: return "Some of the actions that are implied by the medication usage may have occurred.  For example, the patient may have taken some of the medication.  Clinical decision support systems should take this status into account.";
            case DRAFT: return "The medication usage is draft or preliminary.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case RECORDED: return "Recorded";
            case ENTEREDINERROR: return "Entered in Error";
            case DRAFT: return "Draft";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class MedicationUsageStatusCodesEnumFactory implements EnumFactory<MedicationUsageStatusCodes> {
    public MedicationUsageStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("recorded".equals(codeString))
          return MedicationUsageStatusCodes.RECORDED;
        if ("entered-in-error".equals(codeString))
          return MedicationUsageStatusCodes.ENTEREDINERROR;
        if ("draft".equals(codeString))
          return MedicationUsageStatusCodes.DRAFT;
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
        if ("recorded".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.RECORDED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.ENTEREDINERROR);
        if ("draft".equals(codeString))
          return new Enumeration<MedicationUsageStatusCodes>(this, MedicationUsageStatusCodes.DRAFT);
        throw new FHIRException("Unknown MedicationUsageStatusCodes code '"+codeString+"'");
        }
    public String toCode(MedicationUsageStatusCodes code) {
      if (code == MedicationUsageStatusCodes.RECORDED)
        return "recorded";
      if (code == MedicationUsageStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      if (code == MedicationUsageStatusCodes.DRAFT)
        return "draft";
      return "?";
      }
    public String toSystem(MedicationUsageStatusCodes code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class MedicationUsageAdherenceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Type of the adherence for the medication.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of adherence", formalDefinition="Type of the adherence for the medication." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-usage-adherence")
        protected CodeableConcept code;

        /**
         * Captures the reason for the current use or adherence of a medication.
         */
        @Child(name = "reason", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Details of the reason for the current use of the medication", formalDefinition="Captures the reason for the current use or adherence of a medication." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/reason-medication-status-codes")
        protected CodeableConcept reason;

        private static final long serialVersionUID = -1479626679L;

    /**
     * Constructor
     */
      public MedicationUsageAdherenceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationUsageAdherenceComponent(CodeableConcept code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (Type of the adherence for the medication.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationUsageAdherenceComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Type of the adherence for the medication.)
         */
        public MedicationUsageAdherenceComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #reason} (Captures the reason for the current use or adherence of a medication.)
         */
        public CodeableConcept getReason() { 
          if (this.reason == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationUsageAdherenceComponent.reason");
            else if (Configuration.doAutoCreate())
              this.reason = new CodeableConcept(); // cc
          return this.reason;
        }

        public boolean hasReason() { 
          return this.reason != null && !this.reason.isEmpty();
        }

        /**
         * @param value {@link #reason} (Captures the reason for the current use or adherence of a medication.)
         */
        public MedicationUsageAdherenceComponent setReason(CodeableConcept value) { 
          this.reason = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "Type of the adherence for the medication.", 0, 1, code));
          children.add(new Property("reason", "CodeableConcept", "Captures the reason for the current use or adherence of a medication.", 0, 1, reason));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Type of the adherence for the medication.", 0, 1, code);
          case -934964668: /*reason*/  return new Property("reason", "CodeableConcept", "Captures the reason for the current use or adherence of a medication.", 0, 1, reason);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : new Base[] {this.reason}; // CodeableConcept
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
          this.reason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reason")) {
          this.reason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -934964668:  return getReason();
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
          this.reason = new CodeableConcept();
          return this.reason;
        }
        else
          return super.addChild(name);
      }

      public MedicationUsageAdherenceComponent copy() {
        MedicationUsageAdherenceComponent dst = new MedicationUsageAdherenceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationUsageAdherenceComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.reason = reason == null ? null : reason.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationUsageAdherenceComponent))
          return false;
        MedicationUsageAdherenceComponent o = (MedicationUsageAdherenceComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(reason, o.reason, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationUsageAdherenceComponent))
          return false;
        MedicationUsageAdherenceComponent o = (MedicationUsageAdherenceComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, reason);
      }

  public String fhirType() {
    return "MedicationUsage.adherence";

  }

  }

    /**
     * Identifiers associated with this Medication Usage that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External identifier", formalDefinition="Identifiers associated with this Medication Usage that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * A larger event of which this particular MedicationUsage is a component or step.
     */
    @Child(name = "partOf", type = {Procedure.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Part of referenced event", formalDefinition="A larger event of which this particular MedicationUsage is a component or step." )
    protected List<Reference> partOf;

    /**
     * A code representing the status of recording the medication usage.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="recorded | entered-in-error | draft", formalDefinition="A code representing the status of recording the medication usage." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-usage-status")
    protected Enumeration<MedicationUsageStatusCodes> status;

    /**
     * Type of medication usage (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type of medication usage", formalDefinition="Type of medication usage (for example, drug classification like ATC, where meds would be administered, legal category of the medication.)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicationrequest-admin-location")
    protected List<CodeableConcept> category;

    /**
     * Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.
     */
    @Child(name = "medication", type = {CodeableReference.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What medication was taken", formalDefinition="Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
    protected CodeableReference medication;

    /**
     * The person, animal or group who is/was taking the medication.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who is/was taking  the medication", formalDefinition="The person, animal or group who is/was taking the medication." )
    protected Reference subject;

    /**
     * The encounter that establishes the context for this MedicationUsage.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Encounter associated with MedicationUsage", formalDefinition="The encounter that establishes the context for this MedicationUsage." )
    protected Reference encounter;

    /**
     * The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).
     */
    @Child(name = "effective", type = {DateTimeType.class, Period.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The date/time or interval when the medication is/was/will be taken", formalDefinition="The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking)." )
    protected DataType effective;

    /**
     * The date when the Medication Usage was asserted by the information source.
     */
    @Child(name = "dateAsserted", type = {DateTimeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the usage was asserted?", formalDefinition="The date when the Medication Usage was asserted by the information source." )
    protected DateTimeType dateAsserted;

    /**
     * The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest.
     */
    @Child(name = "informationSource", type = {Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Organization.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Person or organization that provided the information about the taking of this medication", formalDefinition="The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest." )
    protected List<Reference> informationSource;

    /**
     * Allows linking the MedicationUsage to the underlying MedicationRequest, or to other information that supports or is used to derive the MedicationUsage.
     */
    @Child(name = "derivedFrom", type = {Reference.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Link to information used to derive the MedicationUsage", formalDefinition="Allows linking the MedicationUsage to the underlying MedicationRequest, or to other information that supports or is used to derive the MedicationUsage." )
    protected List<Reference> derivedFrom;

    /**
     * A concept, Condition or observation that supports why the medication is being/was taken.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Reason for why the medication is being/was taken", formalDefinition="A concept, Condition or observation that supports why the medication is being/was taken." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
    protected List<CodeableReference> reason;

    /**
     * Provides extra information about the Medication Usage that is not conveyed by the other attributes.
     */
    @Child(name = "note", type = {Annotation.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Further information about the usage", formalDefinition="Provides extra information about the Medication Usage that is not conveyed by the other attributes." )
    protected List<Annotation> note;

    /**
     * Link to information that is relevant to a medication usage, for example, illicit drug use, gestational age, etc.
     */
    @Child(name = "relatedClinicalInformation", type = {Observation.class, Condition.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Link to information relevant to the usage of a medication", formalDefinition="Link to information that is relevant to a medication usage, for example, illicit drug use, gestational age, etc." )
    protected List<Reference> relatedClinicalInformation;

    /**
     * The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.
     */
    @Child(name = "renderedDosageInstruction", type = {StringType.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Full representation of the dosage instructions", formalDefinition="The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses." )
    protected StringType renderedDosageInstruction;

    /**
     * Indicates how the medication is/was or should be taken by the patient.
     */
    @Child(name = "dosage", type = {Dosage.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Details of how medication is/was taken or should be taken", formalDefinition="Indicates how the medication is/was or should be taken by the patient." )
    protected List<Dosage> dosage;

    /**
     * Indicates if the medication is being consumed or administered as instructed.
     */
    @Child(name = "adherence", type = {}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Indicates if the medication is being consumed or administered as instructed", formalDefinition="Indicates if the medication is being consumed or administered as instructed." )
    protected MedicationUsageAdherenceComponent adherence;

    private static final long serialVersionUID = -483194372L;

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
     * @return {@link #partOf} (A larger event of which this particular MedicationUsage is a component or step.)
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
     * @return {@link #status} (A code representing the status of recording the medication usage.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
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
     * @param value {@link #status} (A code representing the status of recording the medication usage.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public MedicationUsage setStatusElement(Enumeration<MedicationUsageStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code representing the status of recording the medication usage.
     */
    public MedicationUsageStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code representing the status of recording the medication usage.
     */
    public MedicationUsage setStatus(MedicationUsageStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<MedicationUsageStatusCodes>(new MedicationUsageStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
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
     * @return {@link #effective} (The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).)
     */
    public DataType getEffective() { 
      return this.effective;
    }

    /**
     * @return {@link #effective} (The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).)
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
     * @return {@link #effective} (The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).)
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
     * @param value {@link #effective} (The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).)
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
    public List<Reference> getInformationSource() { 
      if (this.informationSource == null)
        this.informationSource = new ArrayList<Reference>();
      return this.informationSource;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setInformationSource(List<Reference> theInformationSource) { 
      this.informationSource = theInformationSource;
      return this;
    }

    public boolean hasInformationSource() { 
      if (this.informationSource == null)
        return false;
      for (Reference item : this.informationSource)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addInformationSource() { //3
      Reference t = new Reference();
      if (this.informationSource == null)
        this.informationSource = new ArrayList<Reference>();
      this.informationSource.add(t);
      return t;
    }

    public MedicationUsage addInformationSource(Reference t) { //3
      if (t == null)
        return this;
      if (this.informationSource == null)
        this.informationSource = new ArrayList<Reference>();
      this.informationSource.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #informationSource}, creating it if it does not already exist {3}
     */
    public Reference getInformationSourceFirstRep() { 
      if (getInformationSource().isEmpty()) {
        addInformationSource();
      }
      return getInformationSource().get(0);
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
     * @return {@link #relatedClinicalInformation} (Link to information that is relevant to a medication usage, for example, illicit drug use, gestational age, etc.)
     */
    public List<Reference> getRelatedClinicalInformation() { 
      if (this.relatedClinicalInformation == null)
        this.relatedClinicalInformation = new ArrayList<Reference>();
      return this.relatedClinicalInformation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationUsage setRelatedClinicalInformation(List<Reference> theRelatedClinicalInformation) { 
      this.relatedClinicalInformation = theRelatedClinicalInformation;
      return this;
    }

    public boolean hasRelatedClinicalInformation() { 
      if (this.relatedClinicalInformation == null)
        return false;
      for (Reference item : this.relatedClinicalInformation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addRelatedClinicalInformation() { //3
      Reference t = new Reference();
      if (this.relatedClinicalInformation == null)
        this.relatedClinicalInformation = new ArrayList<Reference>();
      this.relatedClinicalInformation.add(t);
      return t;
    }

    public MedicationUsage addRelatedClinicalInformation(Reference t) { //3
      if (t == null)
        return this;
      if (this.relatedClinicalInformation == null)
        this.relatedClinicalInformation = new ArrayList<Reference>();
      this.relatedClinicalInformation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedClinicalInformation}, creating it if it does not already exist {3}
     */
    public Reference getRelatedClinicalInformationFirstRep() { 
      if (getRelatedClinicalInformation().isEmpty()) {
        addRelatedClinicalInformation();
      }
      return getRelatedClinicalInformation().get(0);
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
     * @return {@link #adherence} (Indicates if the medication is being consumed or administered as instructed.)
     */
    public MedicationUsageAdherenceComponent getAdherence() { 
      if (this.adherence == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationUsage.adherence");
        else if (Configuration.doAutoCreate())
          this.adherence = new MedicationUsageAdherenceComponent(); // cc
      return this.adherence;
    }

    public boolean hasAdherence() { 
      return this.adherence != null && !this.adherence.isEmpty();
    }

    /**
     * @param value {@link #adherence} (Indicates if the medication is being consumed or administered as instructed.)
     */
    public MedicationUsage setAdherence(MedicationUsageAdherenceComponent value) { 
      this.adherence = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers associated with this Medication Usage that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("partOf", "Reference(Procedure)", "A larger event of which this particular MedicationUsage is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code representing the status of recording the medication usage.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "Type of medication usage (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("medication", "CodeableReference(Medication)", "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.", 0, 1, medication));
        children.add(new Property("subject", "Reference(Patient|Group)", "The person, animal or group who is/was taking the medication.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this MedicationUsage.", 0, 1, encounter));
        children.add(new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).", 0, 1, effective));
        children.add(new Property("dateAsserted", "dateTime", "The date when the Medication Usage was asserted by the information source.", 0, 1, dateAsserted));
        children.add(new Property("informationSource", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Organization)", "The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest.", 0, java.lang.Integer.MAX_VALUE, informationSource));
        children.add(new Property("derivedFrom", "Reference(Any)", "Allows linking the MedicationUsage to the underlying MedicationRequest, or to other information that supports or is used to derive the MedicationUsage.", 0, java.lang.Integer.MAX_VALUE, derivedFrom));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport)", "A concept, Condition or observation that supports why the medication is being/was taken.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("note", "Annotation", "Provides extra information about the Medication Usage that is not conveyed by the other attributes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("relatedClinicalInformation", "Reference(Observation|Condition)", "Link to information that is relevant to a medication usage, for example, illicit drug use, gestational age, etc.", 0, java.lang.Integer.MAX_VALUE, relatedClinicalInformation));
        children.add(new Property("renderedDosageInstruction", "string", "The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.", 0, 1, renderedDosageInstruction));
        children.add(new Property("dosage", "Dosage", "Indicates how the medication is/was or should be taken by the patient.", 0, java.lang.Integer.MAX_VALUE, dosage));
        children.add(new Property("adherence", "", "Indicates if the medication is being consumed or administered as instructed.", 0, 1, adherence));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers associated with this Medication Usage that are defined by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate. They are business identifiers assigned to this resource by the performer or other systems and remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Procedure)", "A larger event of which this particular MedicationUsage is a component or step.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code representing the status of recording the medication usage.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Type of medication usage (for example, drug classification like ATC, where meds would be administered, legal category of the medication.).", 0, java.lang.Integer.MAX_VALUE, category);
        case 1998965455: /*medication*/  return new Property("medication", "CodeableReference(Medication)", "Identifies the medication being administered. This is either a link to a resource representing the details of the medication or a simple attribute carrying a code that identifies the medication from a known list of medications.", 0, 1, medication);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The person, animal or group who is/was taking the medication.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The encounter that establishes the context for this MedicationUsage.", 0, 1, encounter);
        case 247104889: /*effective[x]*/  return new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).", 0, 1, effective);
        case -1468651097: /*effective*/  return new Property("effective[x]", "dateTime|Period", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).", 0, 1, effective);
        case -275306910: /*effectiveDateTime*/  return new Property("effective[x]", "dateTime", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).", 0, 1, effective);
        case -403934648: /*effectivePeriod*/  return new Property("effective[x]", "Period", "The interval of time during which it is being asserted that the patient is/was/will be taking the medication (or was not taking, when the MedicationUsage.adherence element is Not Taking).", 0, 1, effective);
        case -1980855245: /*dateAsserted*/  return new Property("dateAsserted", "dateTime", "The date when the Medication Usage was asserted by the information source.", 0, 1, dateAsserted);
        case -2123220889: /*informationSource*/  return new Property("informationSource", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Organization)", "The person or organization that provided the information about the taking of this medication. Note: Use derivedFrom when a MedicationUsage is derived from other resources, e.g. Claim or MedicationRequest.", 0, java.lang.Integer.MAX_VALUE, informationSource);
        case 1077922663: /*derivedFrom*/  return new Property("derivedFrom", "Reference(Any)", "Allows linking the MedicationUsage to the underlying MedicationRequest, or to other information that supports or is used to derive the MedicationUsage.", 0, java.lang.Integer.MAX_VALUE, derivedFrom);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport)", "A concept, Condition or observation that supports why the medication is being/was taken.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Provides extra information about the Medication Usage that is not conveyed by the other attributes.", 0, java.lang.Integer.MAX_VALUE, note);
        case 1040787950: /*relatedClinicalInformation*/  return new Property("relatedClinicalInformation", "Reference(Observation|Condition)", "Link to information that is relevant to a medication usage, for example, illicit drug use, gestational age, etc.", 0, java.lang.Integer.MAX_VALUE, relatedClinicalInformation);
        case 1718902050: /*renderedDosageInstruction*/  return new Property("renderedDosageInstruction", "string", "The full representation of the dose of the medication included in all dosage instructions.  To be used when multiple dosage instructions are included to represent complex dosing such as increasing or tapering doses.", 0, 1, renderedDosageInstruction);
        case -1326018889: /*dosage*/  return new Property("dosage", "Dosage", "Indicates how the medication is/was or should be taken by the patient.", 0, java.lang.Integer.MAX_VALUE, dosage);
        case -231003683: /*adherence*/  return new Property("adherence", "", "Indicates if the medication is being consumed or administered as instructed.", 0, 1, adherence);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<MedicationUsageStatusCodes>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 1998965455: /*medication*/ return this.medication == null ? new Base[0] : new Base[] {this.medication}; // CodeableReference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1468651097: /*effective*/ return this.effective == null ? new Base[0] : new Base[] {this.effective}; // DataType
        case -1980855245: /*dateAsserted*/ return this.dateAsserted == null ? new Base[0] : new Base[] {this.dateAsserted}; // DateTimeType
        case -2123220889: /*informationSource*/ return this.informationSource == null ? new Base[0] : this.informationSource.toArray(new Base[this.informationSource.size()]); // Reference
        case 1077922663: /*derivedFrom*/ return this.derivedFrom == null ? new Base[0] : this.derivedFrom.toArray(new Base[this.derivedFrom.size()]); // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1040787950: /*relatedClinicalInformation*/ return this.relatedClinicalInformation == null ? new Base[0] : this.relatedClinicalInformation.toArray(new Base[this.relatedClinicalInformation.size()]); // Reference
        case 1718902050: /*renderedDosageInstruction*/ return this.renderedDosageInstruction == null ? new Base[0] : new Base[] {this.renderedDosageInstruction}; // StringType
        case -1326018889: /*dosage*/ return this.dosage == null ? new Base[0] : this.dosage.toArray(new Base[this.dosage.size()]); // Dosage
        case -231003683: /*adherence*/ return this.adherence == null ? new Base[0] : new Base[] {this.adherence}; // MedicationUsageAdherenceComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new MedicationUsageStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationUsageStatusCodes>
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
          this.getInformationSource().add(TypeConvertor.castToReference(value)); // Reference
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
        case 1040787950: // relatedClinicalInformation
          this.getRelatedClinicalInformation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1718902050: // renderedDosageInstruction
          this.renderedDosageInstruction = TypeConvertor.castToString(value); // StringType
          return value;
        case -1326018889: // dosage
          this.getDosage().add(TypeConvertor.castToDosage(value)); // Dosage
          return value;
        case -231003683: // adherence
          this.adherence = (MedicationUsageAdherenceComponent) value; // MedicationUsageAdherenceComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new MedicationUsageStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationUsageStatusCodes>
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
          this.getInformationSource().add(TypeConvertor.castToReference(value));
        } else if (name.equals("derivedFrom")) {
          this.getDerivedFrom().add(TypeConvertor.castToReference(value));
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("relatedClinicalInformation")) {
          this.getRelatedClinicalInformation().add(TypeConvertor.castToReference(value));
        } else if (name.equals("renderedDosageInstruction")) {
          this.renderedDosageInstruction = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("dosage")) {
          this.getDosage().add(TypeConvertor.castToDosage(value));
        } else if (name.equals("adherence")) {
          this.adherence = (MedicationUsageAdherenceComponent) value; // MedicationUsageAdherenceComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case 50511102:  return addCategory(); 
        case 1998965455:  return getMedication();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case 247104889:  return getEffective();
        case -1468651097:  return getEffective();
        case -1980855245:  return getDateAssertedElement();
        case -2123220889:  return addInformationSource(); 
        case 1077922663:  return addDerivedFrom(); 
        case -934964668:  return addReason(); 
        case 3387378:  return addNote(); 
        case 1040787950:  return addRelatedClinicalInformation(); 
        case 1718902050:  return getRenderedDosageInstructionElement();
        case -1326018889:  return addDosage(); 
        case -231003683:  return getAdherence();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
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
        case 1040787950: /*relatedClinicalInformation*/ return new String[] {"Reference"};
        case 1718902050: /*renderedDosageInstruction*/ return new String[] {"string"};
        case -1326018889: /*dosage*/ return new String[] {"Dosage"};
        case -231003683: /*adherence*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationUsage.status");
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
          return addInformationSource();
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
        else if (name.equals("relatedClinicalInformation")) {
          return addRelatedClinicalInformation();
        }
        else if (name.equals("renderedDosageInstruction")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationUsage.renderedDosageInstruction");
        }
        else if (name.equals("dosage")) {
          return addDosage();
        }
        else if (name.equals("adherence")) {
          this.adherence = new MedicationUsageAdherenceComponent();
          return this.adherence;
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
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
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
        if (informationSource != null) {
          dst.informationSource = new ArrayList<Reference>();
          for (Reference i : informationSource)
            dst.informationSource.add(i.copy());
        };
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
        if (relatedClinicalInformation != null) {
          dst.relatedClinicalInformation = new ArrayList<Reference>();
          for (Reference i : relatedClinicalInformation)
            dst.relatedClinicalInformation.add(i.copy());
        };
        dst.renderedDosageInstruction = renderedDosageInstruction == null ? null : renderedDosageInstruction.copy();
        if (dosage != null) {
          dst.dosage = new ArrayList<Dosage>();
          for (Dosage i : dosage)
            dst.dosage.add(i.copy());
        };
        dst.adherence = adherence == null ? null : adherence.copy();
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
        return compareDeep(identifier, o.identifier, true) && compareDeep(partOf, o.partOf, true) && compareDeep(status, o.status, true)
           && compareDeep(category, o.category, true) && compareDeep(medication, o.medication, true) && compareDeep(subject, o.subject, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(effective, o.effective, true) && compareDeep(dateAsserted, o.dateAsserted, true)
           && compareDeep(informationSource, o.informationSource, true) && compareDeep(derivedFrom, o.derivedFrom, true)
           && compareDeep(reason, o.reason, true) && compareDeep(note, o.note, true) && compareDeep(relatedClinicalInformation, o.relatedClinicalInformation, true)
           && compareDeep(renderedDosageInstruction, o.renderedDosageInstruction, true) && compareDeep(dosage, o.dosage, true)
           && compareDeep(adherence, o.adherence, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationUsage))
          return false;
        MedicationUsage o = (MedicationUsage) other_;
        return compareValues(status, o.status, true) && compareValues(dateAsserted, o.dateAsserted, true) && compareValues(renderedDosageInstruction, o.renderedDosageInstruction, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, partOf, status
          , category, medication, subject, encounter, effective, dateAsserted, informationSource
          , derivedFrom, reason, note, relatedClinicalInformation, renderedDosageInstruction
          , dosage, adherence);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicationUsage;
   }


}

