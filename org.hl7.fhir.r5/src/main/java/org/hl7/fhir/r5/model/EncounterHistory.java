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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final

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
 * A record of significant events/milestones key data throughout the history of an Encounter
 */
@ResourceDef(name="EncounterHistory", profile="http://hl7.org/fhir/StructureDefinition/EncounterHistory")
public class EncounterHistory extends DomainResource {

    @Block()
    public static class EncounterHistoryLocationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The location where the encounter takes place.
         */
        @Child(name = "location", type = {Location.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Location the encounter takes place", formalDefinition="The location where the encounter takes place." )
        protected Reference location;

        /**
         * This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.
         */
        @Child(name = "form", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The physical type of the location (usually the level in the location hierarchy - bed, room, ward, virtual etc.)", formalDefinition="This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/location-form")
        protected CodeableConcept form;

        private static final long serialVersionUID = -1306742681L;

    /**
     * Constructor
     */
      public EncounterHistoryLocationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public EncounterHistoryLocationComponent(Reference location) {
        super();
        this.setLocation(location);
      }

        /**
         * @return {@link #location} (The location where the encounter takes place.)
         */
        public Reference getLocation() { 
          if (this.location == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterHistoryLocationComponent.location");
            else if (Configuration.doAutoCreate())
              this.location = new Reference(); // cc
          return this.location;
        }

        public boolean hasLocation() { 
          return this.location != null && !this.location.isEmpty();
        }

        /**
         * @param value {@link #location} (The location where the encounter takes place.)
         */
        public EncounterHistoryLocationComponent setLocation(Reference value) { 
          this.location = value;
          return this;
        }

        /**
         * @return {@link #form} (This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.)
         */
        public CodeableConcept getForm() { 
          if (this.form == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EncounterHistoryLocationComponent.form");
            else if (Configuration.doAutoCreate())
              this.form = new CodeableConcept(); // cc
          return this.form;
        }

        public boolean hasForm() { 
          return this.form != null && !this.form.isEmpty();
        }

        /**
         * @param value {@link #form} (This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.)
         */
        public EncounterHistoryLocationComponent setForm(CodeableConcept value) { 
          this.form = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("location", "Reference(Location)", "The location where the encounter takes place.", 0, 1, location));
          children.add(new Property("form", "CodeableConcept", "This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.", 0, 1, form));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The location where the encounter takes place.", 0, 1, location);
          case 3148996: /*form*/  return new Property("form", "CodeableConcept", "This will be used to specify the required levels (bed/ward/room/etc.) desired to be recorded to simplify either messaging or query.", 0, 1, form);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case 3148996: /*form*/ return this.form == null ? new Base[0] : new Base[] {this.form}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3148996: // form
          this.form = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("form")) {
          this.form = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1901043637:  return getLocation();
        case 3148996:  return getForm();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case 3148996: /*form*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("form")) {
          this.form = new CodeableConcept();
          return this.form;
        }
        else
          return super.addChild(name);
      }

      public EncounterHistoryLocationComponent copy() {
        EncounterHistoryLocationComponent dst = new EncounterHistoryLocationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EncounterHistoryLocationComponent dst) {
        super.copyValues(dst);
        dst.location = location == null ? null : location.copy();
        dst.form = form == null ? null : form.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EncounterHistoryLocationComponent))
          return false;
        EncounterHistoryLocationComponent o = (EncounterHistoryLocationComponent) other_;
        return compareDeep(location, o.location, true) && compareDeep(form, o.form, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EncounterHistoryLocationComponent))
          return false;
        EncounterHistoryLocationComponent o = (EncounterHistoryLocationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(location, form);
      }

  public String fhirType() {
    return "EncounterHistory.location";

  }

  }

    /**
     * The Encounter associated with this set of historic values.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=0, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The Encounter associated with this set of historic values", formalDefinition="The Encounter associated with this set of historic values." )
    protected Reference encounter;

    /**
     * Identifier(s) by which this encounter is known.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Identifier(s) by which this encounter is known", formalDefinition="Identifier(s) by which this encounter is known." )
    protected List<Identifier> identifier;

    /**
     * planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown", formalDefinition="planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-status")
    protected Enumeration<EncounterStatus> status;

    /**
     * Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.
     */
    @Child(name = "class", type = {CodeableConcept.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Classification of patient encounter", formalDefinition="Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-ActEncounterCode")
    protected CodeableConcept class_;

    /**
     * Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation).
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Specific type of encounter", formalDefinition="Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-type")
    protected List<CodeableConcept> type;

    /**
     * Broad categorization of the service that is to be provided (e.g. cardiology).
     */
    @Child(name = "serviceType", type = {CodeableReference.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Specific type of service", formalDefinition="Broad categorization of the service that is to be provided (e.g. cardiology)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-type")
    protected List<CodeableReference> serviceType;

    /**
     * The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The patient or group related to this encounter", formalDefinition="The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam." )
    protected Reference subject;

    /**
     * The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.
     */
    @Child(name = "subjectStatus", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The current status of the subject in relation to the Encounter", formalDefinition="The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/encounter-subject-status")
    protected CodeableConcept subjectStatus;

    /**
     * The start and end time associated with this set of values associated with the encounter, may be different to the planned times for various reasons.
     */
    @Child(name = "actualPeriod", type = {Period.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The actual start and end time associated with this set of values associated with the encounter", formalDefinition="The start and end time associated with this set of values associated with the encounter, may be different to the planned times for various reasons." )
    protected Period actualPeriod;

    /**
     * The planned start date/time (or admission date) of the encounter.
     */
    @Child(name = "plannedStartDate", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The planned start date/time (or admission date) of the encounter", formalDefinition="The planned start date/time (or admission date) of the encounter." )
    protected DateTimeType plannedStartDate;

    /**
     * The planned end date/time (or discharge date) of the encounter.
     */
    @Child(name = "plannedEndDate", type = {DateTimeType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The planned end date/time (or discharge date) of the encounter", formalDefinition="The planned end date/time (or discharge date) of the encounter." )
    protected DateTimeType plannedEndDate;

    /**
     * Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.When missing it is the time in between the start and end values.
     */
    @Child(name = "length", type = {Duration.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Actual quantity of time the encounter lasted (less time absent)", formalDefinition="Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.\r\rWhen missing it is the time in between the start and end values." )
    protected Duration length;

    /**
     * The location of the patient at this point in the encounter, the multiple cardinality permits de-normalizing the levels of the location hierarchy, such as site/ward/room/bed.
     */
    @Child(name = "location", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Location of the patient at this point in the encounter", formalDefinition="The location of the patient at this point in the encounter, the multiple cardinality permits de-normalizing the levels of the location hierarchy, such as site/ward/room/bed." )
    protected List<EncounterHistoryLocationComponent> location;

    private static final long serialVersionUID = 775989939L;

  /**
   * Constructor
   */
    public EncounterHistory() {
      super();
    }

  /**
   * Constructor
   */
    public EncounterHistory(EncounterStatus status, CodeableConcept class_) {
      super();
      this.setStatus(status);
      this.setClass_(class_);
    }

    /**
     * @return {@link #encounter} (The Encounter associated with this set of historic values.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EncounterHistory.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The Encounter associated with this set of historic values.)
     */
    public EncounterHistory setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #identifier} (Identifier(s) by which this encounter is known.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EncounterHistory setIdentifier(List<Identifier> theIdentifier) { 
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

    public EncounterHistory addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EncounterStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EncounterHistory.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<EncounterStatus>(new EncounterStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public EncounterHistory setStatusElement(Enumeration<EncounterStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown.
     */
    public EncounterStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown.
     */
    public EncounterHistory setStatus(EncounterStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<EncounterStatus>(new EncounterStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #class_} (Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.)
     */
    public CodeableConcept getClass_() { 
      if (this.class_ == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EncounterHistory.class_");
        else if (Configuration.doAutoCreate())
          this.class_ = new CodeableConcept(); // cc
      return this.class_;
    }

    public boolean hasClass_() { 
      return this.class_ != null && !this.class_.isEmpty();
    }

    /**
     * @param value {@link #class_} (Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.)
     */
    public EncounterHistory setClass_(CodeableConcept value) { 
      this.class_ = value;
      return this;
    }

    /**
     * @return {@link #type} (Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation).)
     */
    public List<CodeableConcept> getType() { 
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EncounterHistory setType(List<CodeableConcept> theType) { 
      this.type = theType;
      return this;
    }

    public boolean hasType() { 
      if (this.type == null)
        return false;
      for (CodeableConcept item : this.type)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return t;
    }

    public EncounterHistory addType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      this.type.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #type}, creating it if it does not already exist {3}
     */
    public CodeableConcept getTypeFirstRep() { 
      if (getType().isEmpty()) {
        addType();
      }
      return getType().get(0);
    }

    /**
     * @return {@link #serviceType} (Broad categorization of the service that is to be provided (e.g. cardiology).)
     */
    public List<CodeableReference> getServiceType() { 
      if (this.serviceType == null)
        this.serviceType = new ArrayList<CodeableReference>();
      return this.serviceType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EncounterHistory setServiceType(List<CodeableReference> theServiceType) { 
      this.serviceType = theServiceType;
      return this;
    }

    public boolean hasServiceType() { 
      if (this.serviceType == null)
        return false;
      for (CodeableReference item : this.serviceType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addServiceType() { //3
      CodeableReference t = new CodeableReference();
      if (this.serviceType == null)
        this.serviceType = new ArrayList<CodeableReference>();
      this.serviceType.add(t);
      return t;
    }

    public EncounterHistory addServiceType(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.serviceType == null)
        this.serviceType = new ArrayList<CodeableReference>();
      this.serviceType.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #serviceType}, creating it if it does not already exist {3}
     */
    public CodeableReference getServiceTypeFirstRep() { 
      if (getServiceType().isEmpty()) {
        addServiceType();
      }
      return getServiceType().get(0);
    }

    /**
     * @return {@link #subject} (The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EncounterHistory.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.)
     */
    public EncounterHistory setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #subjectStatus} (The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.)
     */
    public CodeableConcept getSubjectStatus() { 
      if (this.subjectStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EncounterHistory.subjectStatus");
        else if (Configuration.doAutoCreate())
          this.subjectStatus = new CodeableConcept(); // cc
      return this.subjectStatus;
    }

    public boolean hasSubjectStatus() { 
      return this.subjectStatus != null && !this.subjectStatus.isEmpty();
    }

    /**
     * @param value {@link #subjectStatus} (The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.)
     */
    public EncounterHistory setSubjectStatus(CodeableConcept value) { 
      this.subjectStatus = value;
      return this;
    }

    /**
     * @return {@link #actualPeriod} (The start and end time associated with this set of values associated with the encounter, may be different to the planned times for various reasons.)
     */
    public Period getActualPeriod() { 
      if (this.actualPeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EncounterHistory.actualPeriod");
        else if (Configuration.doAutoCreate())
          this.actualPeriod = new Period(); // cc
      return this.actualPeriod;
    }

    public boolean hasActualPeriod() { 
      return this.actualPeriod != null && !this.actualPeriod.isEmpty();
    }

    /**
     * @param value {@link #actualPeriod} (The start and end time associated with this set of values associated with the encounter, may be different to the planned times for various reasons.)
     */
    public EncounterHistory setActualPeriod(Period value) { 
      this.actualPeriod = value;
      return this;
    }

    /**
     * @return {@link #plannedStartDate} (The planned start date/time (or admission date) of the encounter.). This is the underlying object with id, value and extensions. The accessor "getPlannedStartDate" gives direct access to the value
     */
    public DateTimeType getPlannedStartDateElement() { 
      if (this.plannedStartDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EncounterHistory.plannedStartDate");
        else if (Configuration.doAutoCreate())
          this.plannedStartDate = new DateTimeType(); // bb
      return this.plannedStartDate;
    }

    public boolean hasPlannedStartDateElement() { 
      return this.plannedStartDate != null && !this.plannedStartDate.isEmpty();
    }

    public boolean hasPlannedStartDate() { 
      return this.plannedStartDate != null && !this.plannedStartDate.isEmpty();
    }

    /**
     * @param value {@link #plannedStartDate} (The planned start date/time (or admission date) of the encounter.). This is the underlying object with id, value and extensions. The accessor "getPlannedStartDate" gives direct access to the value
     */
    public EncounterHistory setPlannedStartDateElement(DateTimeType value) { 
      this.plannedStartDate = value;
      return this;
    }

    /**
     * @return The planned start date/time (or admission date) of the encounter.
     */
    public Date getPlannedStartDate() { 
      return this.plannedStartDate == null ? null : this.plannedStartDate.getValue();
    }

    /**
     * @param value The planned start date/time (or admission date) of the encounter.
     */
    public EncounterHistory setPlannedStartDate(Date value) { 
      if (value == null)
        this.plannedStartDate = null;
      else {
        if (this.plannedStartDate == null)
          this.plannedStartDate = new DateTimeType();
        this.plannedStartDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #plannedEndDate} (The planned end date/time (or discharge date) of the encounter.). This is the underlying object with id, value and extensions. The accessor "getPlannedEndDate" gives direct access to the value
     */
    public DateTimeType getPlannedEndDateElement() { 
      if (this.plannedEndDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EncounterHistory.plannedEndDate");
        else if (Configuration.doAutoCreate())
          this.plannedEndDate = new DateTimeType(); // bb
      return this.plannedEndDate;
    }

    public boolean hasPlannedEndDateElement() { 
      return this.plannedEndDate != null && !this.plannedEndDate.isEmpty();
    }

    public boolean hasPlannedEndDate() { 
      return this.plannedEndDate != null && !this.plannedEndDate.isEmpty();
    }

    /**
     * @param value {@link #plannedEndDate} (The planned end date/time (or discharge date) of the encounter.). This is the underlying object with id, value and extensions. The accessor "getPlannedEndDate" gives direct access to the value
     */
    public EncounterHistory setPlannedEndDateElement(DateTimeType value) { 
      this.plannedEndDate = value;
      return this;
    }

    /**
     * @return The planned end date/time (or discharge date) of the encounter.
     */
    public Date getPlannedEndDate() { 
      return this.plannedEndDate == null ? null : this.plannedEndDate.getValue();
    }

    /**
     * @param value The planned end date/time (or discharge date) of the encounter.
     */
    public EncounterHistory setPlannedEndDate(Date value) { 
      if (value == null)
        this.plannedEndDate = null;
      else {
        if (this.plannedEndDate == null)
          this.plannedEndDate = new DateTimeType();
        this.plannedEndDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #length} (Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.When missing it is the time in between the start and end values.)
     */
    public Duration getLength() { 
      if (this.length == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EncounterHistory.length");
        else if (Configuration.doAutoCreate())
          this.length = new Duration(); // cc
      return this.length;
    }

    public boolean hasLength() { 
      return this.length != null && !this.length.isEmpty();
    }

    /**
     * @param value {@link #length} (Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.When missing it is the time in between the start and end values.)
     */
    public EncounterHistory setLength(Duration value) { 
      this.length = value;
      return this;
    }

    /**
     * @return {@link #location} (The location of the patient at this point in the encounter, the multiple cardinality permits de-normalizing the levels of the location hierarchy, such as site/ward/room/bed.)
     */
    public List<EncounterHistoryLocationComponent> getLocation() { 
      if (this.location == null)
        this.location = new ArrayList<EncounterHistoryLocationComponent>();
      return this.location;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EncounterHistory setLocation(List<EncounterHistoryLocationComponent> theLocation) { 
      this.location = theLocation;
      return this;
    }

    public boolean hasLocation() { 
      if (this.location == null)
        return false;
      for (EncounterHistoryLocationComponent item : this.location)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EncounterHistoryLocationComponent addLocation() { //3
      EncounterHistoryLocationComponent t = new EncounterHistoryLocationComponent();
      if (this.location == null)
        this.location = new ArrayList<EncounterHistoryLocationComponent>();
      this.location.add(t);
      return t;
    }

    public EncounterHistory addLocation(EncounterHistoryLocationComponent t) { //3
      if (t == null)
        return this;
      if (this.location == null)
        this.location = new ArrayList<EncounterHistoryLocationComponent>();
      this.location.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #location}, creating it if it does not already exist {3}
     */
    public EncounterHistoryLocationComponent getLocationFirstRep() { 
      if (getLocation().isEmpty()) {
        addLocation();
      }
      return getLocation().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("encounter", "Reference(Encounter)", "The Encounter associated with this set of historic values.", 0, 1, encounter));
        children.add(new Property("identifier", "Identifier", "Identifier(s) by which this encounter is known.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown.", 0, 1, status));
        children.add(new Property("class", "CodeableConcept", "Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.", 0, 1, class_));
        children.add(new Property("type", "CodeableConcept", "Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation).", 0, java.lang.Integer.MAX_VALUE, type));
        children.add(new Property("serviceType", "CodeableReference(HealthcareService)", "Broad categorization of the service that is to be provided (e.g. cardiology).", 0, java.lang.Integer.MAX_VALUE, serviceType));
        children.add(new Property("subject", "Reference(Patient|Group)", "The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.", 0, 1, subject));
        children.add(new Property("subjectStatus", "CodeableConcept", "The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.", 0, 1, subjectStatus));
        children.add(new Property("actualPeriod", "Period", "The start and end time associated with this set of values associated with the encounter, may be different to the planned times for various reasons.", 0, 1, actualPeriod));
        children.add(new Property("plannedStartDate", "dateTime", "The planned start date/time (or admission date) of the encounter.", 0, 1, plannedStartDate));
        children.add(new Property("plannedEndDate", "dateTime", "The planned end date/time (or discharge date) of the encounter.", 0, 1, plannedEndDate));
        children.add(new Property("length", "Duration", "Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.\r\rWhen missing it is the time in between the start and end values.", 0, 1, length));
        children.add(new Property("location", "", "The location of the patient at this point in the encounter, the multiple cardinality permits de-normalizing the levels of the location hierarchy, such as site/ward/room/bed.", 0, java.lang.Integer.MAX_VALUE, location));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The Encounter associated with this set of historic values.", 0, 1, encounter);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier(s) by which this encounter is known.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "planned | in-progress | on-hold | discharged | completed | cancelled | discontinued | entered-in-error | unknown.", 0, 1, status);
        case 94742904: /*class*/  return new Property("class", "CodeableConcept", "Concepts representing classification of patient encounter such as ambulatory (outpatient), inpatient, emergency, home health or others due to local variations.", 0, 1, class_);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Specific type of encounter (e.g. e-mail consultation, surgical day-care, skilled nursing, rehabilitation).", 0, java.lang.Integer.MAX_VALUE, type);
        case -1928370289: /*serviceType*/  return new Property("serviceType", "CodeableReference(HealthcareService)", "Broad categorization of the service that is to be provided (e.g. cardiology).", 0, java.lang.Integer.MAX_VALUE, serviceType);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The patient or group related to this encounter. In some use-cases the patient MAY not be present, such as a case meeting about a patient between several practitioners or a careteam.", 0, 1, subject);
        case 110854206: /*subjectStatus*/  return new Property("subjectStatus", "CodeableConcept", "The subjectStatus value can be used to track the patient's status within the encounter. It details whether the patient has arrived or departed, has been triaged or is currently in a waiting status.", 0, 1, subjectStatus);
        case 789194991: /*actualPeriod*/  return new Property("actualPeriod", "Period", "The start and end time associated with this set of values associated with the encounter, may be different to the planned times for various reasons.", 0, 1, actualPeriod);
        case 460857804: /*plannedStartDate*/  return new Property("plannedStartDate", "dateTime", "The planned start date/time (or admission date) of the encounter.", 0, 1, plannedStartDate);
        case 1657534661: /*plannedEndDate*/  return new Property("plannedEndDate", "dateTime", "The planned end date/time (or discharge date) of the encounter.", 0, 1, plannedEndDate);
        case -1106363674: /*length*/  return new Property("length", "Duration", "Actual quantity of time the encounter lasted. This excludes the time during leaves of absence.\r\rWhen missing it is the time in between the start and end values.", 0, 1, length);
        case 1901043637: /*location*/  return new Property("location", "", "The location of the patient at this point in the encounter, the multiple cardinality permits de-normalizing the levels of the location hierarchy, such as site/ward/room/bed.", 0, java.lang.Integer.MAX_VALUE, location);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EncounterStatus>
        case 94742904: /*class*/ return this.class_ == null ? new Base[0] : new Base[] {this.class_}; // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case -1928370289: /*serviceType*/ return this.serviceType == null ? new Base[0] : this.serviceType.toArray(new Base[this.serviceType.size()]); // CodeableReference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 110854206: /*subjectStatus*/ return this.subjectStatus == null ? new Base[0] : new Base[] {this.subjectStatus}; // CodeableConcept
        case 789194991: /*actualPeriod*/ return this.actualPeriod == null ? new Base[0] : new Base[] {this.actualPeriod}; // Period
        case 460857804: /*plannedStartDate*/ return this.plannedStartDate == null ? new Base[0] : new Base[] {this.plannedStartDate}; // DateTimeType
        case 1657534661: /*plannedEndDate*/ return this.plannedEndDate == null ? new Base[0] : new Base[] {this.plannedEndDate}; // DateTimeType
        case -1106363674: /*length*/ return this.length == null ? new Base[0] : new Base[] {this.length}; // Duration
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : this.location.toArray(new Base[this.location.size()]); // EncounterHistoryLocationComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new EncounterStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EncounterStatus>
          return value;
        case 94742904: // class
          this.class_ = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1928370289: // serviceType
          this.getServiceType().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 110854206: // subjectStatus
          this.subjectStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 789194991: // actualPeriod
          this.actualPeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 460857804: // plannedStartDate
          this.plannedStartDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1657534661: // plannedEndDate
          this.plannedEndDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1106363674: // length
          this.length = TypeConvertor.castToDuration(value); // Duration
          return value;
        case 1901043637: // location
          this.getLocation().add((EncounterHistoryLocationComponent) value); // EncounterHistoryLocationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new EncounterStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EncounterStatus>
        } else if (name.equals("class")) {
          this.class_ = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("serviceType")) {
          this.getServiceType().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("subjectStatus")) {
          this.subjectStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actualPeriod")) {
          this.actualPeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("plannedStartDate")) {
          this.plannedStartDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("plannedEndDate")) {
          this.plannedEndDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("length")) {
          this.length = TypeConvertor.castToDuration(value); // Duration
        } else if (name.equals("location")) {
          this.getLocation().add((EncounterHistoryLocationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1524132147:  return getEncounter();
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case 94742904:  return getClass_();
        case 3575610:  return addType(); 
        case -1928370289:  return addServiceType(); 
        case -1867885268:  return getSubject();
        case 110854206:  return getSubjectStatus();
        case 789194991:  return getActualPeriod();
        case 460857804:  return getPlannedStartDateElement();
        case 1657534661:  return getPlannedEndDateElement();
        case -1106363674:  return getLength();
        case 1901043637:  return addLocation(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 94742904: /*class*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1928370289: /*serviceType*/ return new String[] {"CodeableReference"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 110854206: /*subjectStatus*/ return new String[] {"CodeableConcept"};
        case 789194991: /*actualPeriod*/ return new String[] {"Period"};
        case 460857804: /*plannedStartDate*/ return new String[] {"dateTime"};
        case 1657534661: /*plannedEndDate*/ return new String[] {"dateTime"};
        case -1106363674: /*length*/ return new String[] {"Duration"};
        case 1901043637: /*location*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type EncounterHistory.status");
        }
        else if (name.equals("class")) {
          this.class_ = new CodeableConcept();
          return this.class_;
        }
        else if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("serviceType")) {
          return addServiceType();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("subjectStatus")) {
          this.subjectStatus = new CodeableConcept();
          return this.subjectStatus;
        }
        else if (name.equals("actualPeriod")) {
          this.actualPeriod = new Period();
          return this.actualPeriod;
        }
        else if (name.equals("plannedStartDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type EncounterHistory.plannedStartDate");
        }
        else if (name.equals("plannedEndDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type EncounterHistory.plannedEndDate");
        }
        else if (name.equals("length")) {
          this.length = new Duration();
          return this.length;
        }
        else if (name.equals("location")) {
          return addLocation();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EncounterHistory";

  }

      public EncounterHistory copy() {
        EncounterHistory dst = new EncounterHistory();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EncounterHistory dst) {
        super.copyValues(dst);
        dst.encounter = encounter == null ? null : encounter.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.class_ = class_ == null ? null : class_.copy();
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        if (serviceType != null) {
          dst.serviceType = new ArrayList<CodeableReference>();
          for (CodeableReference i : serviceType)
            dst.serviceType.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.subjectStatus = subjectStatus == null ? null : subjectStatus.copy();
        dst.actualPeriod = actualPeriod == null ? null : actualPeriod.copy();
        dst.plannedStartDate = plannedStartDate == null ? null : plannedStartDate.copy();
        dst.plannedEndDate = plannedEndDate == null ? null : plannedEndDate.copy();
        dst.length = length == null ? null : length.copy();
        if (location != null) {
          dst.location = new ArrayList<EncounterHistoryLocationComponent>();
          for (EncounterHistoryLocationComponent i : location)
            dst.location.add(i.copy());
        };
      }

      protected EncounterHistory typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EncounterHistory))
          return false;
        EncounterHistory o = (EncounterHistory) other_;
        return compareDeep(encounter, o.encounter, true) && compareDeep(identifier, o.identifier, true)
           && compareDeep(status, o.status, true) && compareDeep(class_, o.class_, true) && compareDeep(type, o.type, true)
           && compareDeep(serviceType, o.serviceType, true) && compareDeep(subject, o.subject, true) && compareDeep(subjectStatus, o.subjectStatus, true)
           && compareDeep(actualPeriod, o.actualPeriod, true) && compareDeep(plannedStartDate, o.plannedStartDate, true)
           && compareDeep(plannedEndDate, o.plannedEndDate, true) && compareDeep(length, o.length, true) && compareDeep(location, o.location, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EncounterHistory))
          return false;
        EncounterHistory o = (EncounterHistory) other_;
        return compareValues(status, o.status, true) && compareValues(plannedStartDate, o.plannedStartDate, true)
           && compareValues(plannedEndDate, o.plannedEndDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(encounter, identifier, status
          , class_, type, serviceType, subject, subjectStatus, actualPeriod, plannedStartDate
          , plannedEndDate, length, location);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.EncounterHistory;
   }

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Identifier(s) by which this encounter is known</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EncounterHistory.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="EncounterHistory.identifier", description="Identifier(s) by which this encounter is known", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Identifier(s) by which this encounter is known</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EncounterHistory.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>The patient present at the encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EncounterHistory.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="EncounterHistory.subject.where(resolve() is Patient)", description="The patient present at the encounter", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>The patient present at the encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EncounterHistory.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EncounterHistory:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("EncounterHistory:patient").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Status of the Encounter history entry</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EncounterHistory.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="EncounterHistory.status", description="Status of the Encounter history entry", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Status of the Encounter history entry</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EncounterHistory.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The patient or group present at the encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EncounterHistory.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="EncounterHistory.subject", description="The patient or group present at the encounter", type="reference", target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The patient or group present at the encounter</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EncounterHistory.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EncounterHistory:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("EncounterHistory:subject").toLocked();

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter", description="Multiple Resources: \r\n\r\n* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent\r\n* [CarePlan](careplan.html): The Encounter during which this CarePlan was created\r\n* [ChargeItem](chargeitem.html): Encounter associated with event\r\n* [Claim](claim.html): Encounters associated with a billed line item\r\n* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created\r\n* [Communication](communication.html): The Encounter during which this Communication was created\r\n* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created\r\n* [Composition](composition.html): Context of the Composition\r\n* [Condition](condition.html): The Encounter during which this Condition was created\r\n* [DeviceRequest](devicerequest.html): Encounter during which request was created\r\n* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made\r\n* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values\r\n* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item\r\n* [Flag](flag.html): Alert relevant during encounter\r\n* [ImagingStudy](imagingstudy.html): The context of the study\r\n* [List](list.html): Context in which list created\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier\r\n* [Observation](observation.html): Encounter related to the observation\r\n* [Procedure](procedure.html): The Encounter during which this Procedure was created\r\n* [Provenance](provenance.html): Encounter related to the Provenance\r\n* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response\r\n* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to\r\n* [RiskAssessment](riskassessment.html): Where was assessment performed?\r\n* [ServiceRequest](servicerequest.html): An encounter in which this request is made\r\n* [Task](task.html): Search by encounter\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EncounterHistory:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("EncounterHistory:encounter").toLocked();


}

