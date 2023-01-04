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
 * A physical entity which is the primary unit of operational and/or administrative interest in a study.
 */
@ResourceDef(name="ResearchSubject", profile="http://hl7.org/fhir/StructureDefinition/ResearchSubject")
public class ResearchSubject extends DomainResource {

    @Block()
    public static class ResearchSubjectProgressComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies the aspect of the subject's journey that the state refers to.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="state | milestone", formalDefinition="Identifies the aspect of the subject's journey that the state refers to." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-subject-state-type")
        protected CodeableConcept type;

        /**
         * The current state of the subject.
         */
        @Child(name = "subjectState", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="candidate | eligible | follow-up | ineligible | not-registered | off-study | on-study | on-study-intervention | on-study-observation | pending-on-study | potential-candidate | screening | withdrawn", formalDefinition="The current state of the subject." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-subject-state")
        protected CodeableConcept subjectState;

        /**
         * The milestones the subject has passed through.
         */
        @Child(name = "milestone", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="SignedUp | Screened | Randomized", formalDefinition="The milestones the subject has passed through." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/research-subject-milestone")
        protected CodeableConcept milestone;

        /**
         * The reason for the state change.  If coded it should follow the formal subject state model.
         */
        @Child(name = "reason", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="State change reason", formalDefinition="The reason for the state change.  If coded it should follow the formal subject state model." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/state-change-reason")
        protected CodeableConcept reason;

        /**
         * The date when the new status started.
         */
        @Child(name = "startDate", type = {DateTimeType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="State change date", formalDefinition="The date when the new status started." )
        protected DateTimeType startDate;

        /**
         * The date when the state ended.
         */
        @Child(name = "endDate", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="State change date", formalDefinition="The date when the state ended." )
        protected DateTimeType endDate;

        private static final long serialVersionUID = -330838916L;

    /**
     * Constructor
     */
      public ResearchSubjectProgressComponent() {
        super();
      }

        /**
         * @return {@link #type} (Identifies the aspect of the subject's journey that the state refers to.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchSubjectProgressComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Identifies the aspect of the subject's journey that the state refers to.)
         */
        public ResearchSubjectProgressComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #subjectState} (The current state of the subject.)
         */
        public CodeableConcept getSubjectState() { 
          if (this.subjectState == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchSubjectProgressComponent.subjectState");
            else if (Configuration.doAutoCreate())
              this.subjectState = new CodeableConcept(); // cc
          return this.subjectState;
        }

        public boolean hasSubjectState() { 
          return this.subjectState != null && !this.subjectState.isEmpty();
        }

        /**
         * @param value {@link #subjectState} (The current state of the subject.)
         */
        public ResearchSubjectProgressComponent setSubjectState(CodeableConcept value) { 
          this.subjectState = value;
          return this;
        }

        /**
         * @return {@link #milestone} (The milestones the subject has passed through.)
         */
        public CodeableConcept getMilestone() { 
          if (this.milestone == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchSubjectProgressComponent.milestone");
            else if (Configuration.doAutoCreate())
              this.milestone = new CodeableConcept(); // cc
          return this.milestone;
        }

        public boolean hasMilestone() { 
          return this.milestone != null && !this.milestone.isEmpty();
        }

        /**
         * @param value {@link #milestone} (The milestones the subject has passed through.)
         */
        public ResearchSubjectProgressComponent setMilestone(CodeableConcept value) { 
          this.milestone = value;
          return this;
        }

        /**
         * @return {@link #reason} (The reason for the state change.  If coded it should follow the formal subject state model.)
         */
        public CodeableConcept getReason() { 
          if (this.reason == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchSubjectProgressComponent.reason");
            else if (Configuration.doAutoCreate())
              this.reason = new CodeableConcept(); // cc
          return this.reason;
        }

        public boolean hasReason() { 
          return this.reason != null && !this.reason.isEmpty();
        }

        /**
         * @param value {@link #reason} (The reason for the state change.  If coded it should follow the formal subject state model.)
         */
        public ResearchSubjectProgressComponent setReason(CodeableConcept value) { 
          this.reason = value;
          return this;
        }

        /**
         * @return {@link #startDate} (The date when the new status started.). This is the underlying object with id, value and extensions. The accessor "getStartDate" gives direct access to the value
         */
        public DateTimeType getStartDateElement() { 
          if (this.startDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchSubjectProgressComponent.startDate");
            else if (Configuration.doAutoCreate())
              this.startDate = new DateTimeType(); // bb
          return this.startDate;
        }

        public boolean hasStartDateElement() { 
          return this.startDate != null && !this.startDate.isEmpty();
        }

        public boolean hasStartDate() { 
          return this.startDate != null && !this.startDate.isEmpty();
        }

        /**
         * @param value {@link #startDate} (The date when the new status started.). This is the underlying object with id, value and extensions. The accessor "getStartDate" gives direct access to the value
         */
        public ResearchSubjectProgressComponent setStartDateElement(DateTimeType value) { 
          this.startDate = value;
          return this;
        }

        /**
         * @return The date when the new status started.
         */
        public Date getStartDate() { 
          return this.startDate == null ? null : this.startDate.getValue();
        }

        /**
         * @param value The date when the new status started.
         */
        public ResearchSubjectProgressComponent setStartDate(Date value) { 
          if (value == null)
            this.startDate = null;
          else {
            if (this.startDate == null)
              this.startDate = new DateTimeType();
            this.startDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #endDate} (The date when the state ended.). This is the underlying object with id, value and extensions. The accessor "getEndDate" gives direct access to the value
         */
        public DateTimeType getEndDateElement() { 
          if (this.endDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ResearchSubjectProgressComponent.endDate");
            else if (Configuration.doAutoCreate())
              this.endDate = new DateTimeType(); // bb
          return this.endDate;
        }

        public boolean hasEndDateElement() { 
          return this.endDate != null && !this.endDate.isEmpty();
        }

        public boolean hasEndDate() { 
          return this.endDate != null && !this.endDate.isEmpty();
        }

        /**
         * @param value {@link #endDate} (The date when the state ended.). This is the underlying object with id, value and extensions. The accessor "getEndDate" gives direct access to the value
         */
        public ResearchSubjectProgressComponent setEndDateElement(DateTimeType value) { 
          this.endDate = value;
          return this;
        }

        /**
         * @return The date when the state ended.
         */
        public Date getEndDate() { 
          return this.endDate == null ? null : this.endDate.getValue();
        }

        /**
         * @param value The date when the state ended.
         */
        public ResearchSubjectProgressComponent setEndDate(Date value) { 
          if (value == null)
            this.endDate = null;
          else {
            if (this.endDate == null)
              this.endDate = new DateTimeType();
            this.endDate.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Identifies the aspect of the subject's journey that the state refers to.", 0, 1, type));
          children.add(new Property("subjectState", "CodeableConcept", "The current state of the subject.", 0, 1, subjectState));
          children.add(new Property("milestone", "CodeableConcept", "The milestones the subject has passed through.", 0, 1, milestone));
          children.add(new Property("reason", "CodeableConcept", "The reason for the state change.  If coded it should follow the formal subject state model.", 0, 1, reason));
          children.add(new Property("startDate", "dateTime", "The date when the new status started.", 0, 1, startDate));
          children.add(new Property("endDate", "dateTime", "The date when the state ended.", 0, 1, endDate));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Identifies the aspect of the subject's journey that the state refers to.", 0, 1, type);
          case -1520444731: /*subjectState*/  return new Property("subjectState", "CodeableConcept", "The current state of the subject.", 0, 1, subjectState);
          case -1065084560: /*milestone*/  return new Property("milestone", "CodeableConcept", "The milestones the subject has passed through.", 0, 1, milestone);
          case -934964668: /*reason*/  return new Property("reason", "CodeableConcept", "The reason for the state change.  If coded it should follow the formal subject state model.", 0, 1, reason);
          case -2129778896: /*startDate*/  return new Property("startDate", "dateTime", "The date when the new status started.", 0, 1, startDate);
          case -1607727319: /*endDate*/  return new Property("endDate", "dateTime", "The date when the state ended.", 0, 1, endDate);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1520444731: /*subjectState*/ return this.subjectState == null ? new Base[0] : new Base[] {this.subjectState}; // CodeableConcept
        case -1065084560: /*milestone*/ return this.milestone == null ? new Base[0] : new Base[] {this.milestone}; // CodeableConcept
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : new Base[] {this.reason}; // CodeableConcept
        case -2129778896: /*startDate*/ return this.startDate == null ? new Base[0] : new Base[] {this.startDate}; // DateTimeType
        case -1607727319: /*endDate*/ return this.endDate == null ? new Base[0] : new Base[] {this.endDate}; // DateTimeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1520444731: // subjectState
          this.subjectState = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1065084560: // milestone
          this.milestone = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -934964668: // reason
          this.reason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -2129778896: // startDate
          this.startDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1607727319: // endDate
          this.endDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subjectState")) {
          this.subjectState = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("milestone")) {
          this.milestone = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reason")) {
          this.reason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("startDate")) {
          this.startDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("endDate")) {
          this.endDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1520444731:  return getSubjectState();
        case -1065084560:  return getMilestone();
        case -934964668:  return getReason();
        case -2129778896:  return getStartDateElement();
        case -1607727319:  return getEndDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1520444731: /*subjectState*/ return new String[] {"CodeableConcept"};
        case -1065084560: /*milestone*/ return new String[] {"CodeableConcept"};
        case -934964668: /*reason*/ return new String[] {"CodeableConcept"};
        case -2129778896: /*startDate*/ return new String[] {"dateTime"};
        case -1607727319: /*endDate*/ return new String[] {"dateTime"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("subjectState")) {
          this.subjectState = new CodeableConcept();
          return this.subjectState;
        }
        else if (name.equals("milestone")) {
          this.milestone = new CodeableConcept();
          return this.milestone;
        }
        else if (name.equals("reason")) {
          this.reason = new CodeableConcept();
          return this.reason;
        }
        else if (name.equals("startDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ResearchSubject.progress.startDate");
        }
        else if (name.equals("endDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type ResearchSubject.progress.endDate");
        }
        else
          return super.addChild(name);
      }

      public ResearchSubjectProgressComponent copy() {
        ResearchSubjectProgressComponent dst = new ResearchSubjectProgressComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchSubjectProgressComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.subjectState = subjectState == null ? null : subjectState.copy();
        dst.milestone = milestone == null ? null : milestone.copy();
        dst.reason = reason == null ? null : reason.copy();
        dst.startDate = startDate == null ? null : startDate.copy();
        dst.endDate = endDate == null ? null : endDate.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchSubjectProgressComponent))
          return false;
        ResearchSubjectProgressComponent o = (ResearchSubjectProgressComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(subjectState, o.subjectState, true) && compareDeep(milestone, o.milestone, true)
           && compareDeep(reason, o.reason, true) && compareDeep(startDate, o.startDate, true) && compareDeep(endDate, o.endDate, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchSubjectProgressComponent))
          return false;
        ResearchSubjectProgressComponent o = (ResearchSubjectProgressComponent) other_;
        return compareValues(startDate, o.startDate, true) && compareValues(endDate, o.endDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, subjectState, milestone
          , reason, startDate, endDate);
      }

  public String fhirType() {
    return "ResearchSubject.progress";

  }

  }

    /**
     * Identifiers assigned to this research subject for a study.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for research subject in a study", formalDefinition="Identifiers assigned to this research subject for a study." )
    protected List<Identifier> identifier;

    /**
     * The publication state of the resource (not of the subject).
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The publication state of the resource (not of the subject)." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * The current state (status) of the subject and resons for status change where appropriate.
     */
    @Child(name = "progress", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Subject status", formalDefinition="The current state (status) of the subject and resons for status change where appropriate." )
    protected List<ResearchSubjectProgressComponent> progress;

    /**
     * The dates the subject began and ended their participation in the study.
     */
    @Child(name = "period", type = {Period.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Start and end of participation", formalDefinition="The dates the subject began and ended their participation in the study." )
    protected Period period;

    /**
     * Reference to the study the subject is participating in.
     */
    @Child(name = "study", type = {ResearchStudy.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Study subject is part of", formalDefinition="Reference to the study the subject is participating in." )
    protected Reference study;

    /**
     * The record of the person, animal or other entity involved in the study.
     */
    @Child(name = "subject", type = {Patient.class, Group.class, Specimen.class, Device.class, Medication.class, Substance.class, BiologicallyDerivedProduct.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who or what is part of study", formalDefinition="The record of the person, animal or other entity involved in the study." )
    protected Reference subject;

    /**
     * The name of the arm in the study the subject is expected to follow as part of this study.
     */
    @Child(name = "assignedArm", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="What path should be followed", formalDefinition="The name of the arm in the study the subject is expected to follow as part of this study." )
    protected StringType assignedArm;

    /**
     * The name of the arm in the study the subject actually followed as part of this study.
     */
    @Child(name = "actualArm", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="What path was followed", formalDefinition="The name of the arm in the study the subject actually followed as part of this study." )
    protected StringType actualArm;

    /**
     * A record of the patient's informed agreement to participate in the study.
     */
    @Child(name = "consent", type = {Consent.class}, order=8, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Agreement to participate in study", formalDefinition="A record of the patient's informed agreement to participate in the study." )
    protected Reference consent;

    private static final long serialVersionUID = -398870757L;

  /**
   * Constructor
   */
    public ResearchSubject() {
      super();
    }

  /**
   * Constructor
   */
    public ResearchSubject(PublicationStatus status, Reference study, Reference subject) {
      super();
      this.setStatus(status);
      this.setStudy(study);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Identifiers assigned to this research subject for a study.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchSubject setIdentifier(List<Identifier> theIdentifier) { 
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

    public ResearchSubject addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (The publication state of the resource (not of the subject).). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchSubject.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The publication state of the resource (not of the subject).). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ResearchSubject setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The publication state of the resource (not of the subject).
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The publication state of the resource (not of the subject).
     */
    public ResearchSubject setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #progress} (The current state (status) of the subject and resons for status change where appropriate.)
     */
    public List<ResearchSubjectProgressComponent> getProgress() { 
      if (this.progress == null)
        this.progress = new ArrayList<ResearchSubjectProgressComponent>();
      return this.progress;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchSubject setProgress(List<ResearchSubjectProgressComponent> theProgress) { 
      this.progress = theProgress;
      return this;
    }

    public boolean hasProgress() { 
      if (this.progress == null)
        return false;
      for (ResearchSubjectProgressComponent item : this.progress)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ResearchSubjectProgressComponent addProgress() { //3
      ResearchSubjectProgressComponent t = new ResearchSubjectProgressComponent();
      if (this.progress == null)
        this.progress = new ArrayList<ResearchSubjectProgressComponent>();
      this.progress.add(t);
      return t;
    }

    public ResearchSubject addProgress(ResearchSubjectProgressComponent t) { //3
      if (t == null)
        return this;
      if (this.progress == null)
        this.progress = new ArrayList<ResearchSubjectProgressComponent>();
      this.progress.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #progress}, creating it if it does not already exist {3}
     */
    public ResearchSubjectProgressComponent getProgressFirstRep() { 
      if (getProgress().isEmpty()) {
        addProgress();
      }
      return getProgress().get(0);
    }

    /**
     * @return {@link #period} (The dates the subject began and ended their participation in the study.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchSubject.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The dates the subject began and ended their participation in the study.)
     */
    public ResearchSubject setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #study} (Reference to the study the subject is participating in.)
     */
    public Reference getStudy() { 
      if (this.study == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchSubject.study");
        else if (Configuration.doAutoCreate())
          this.study = new Reference(); // cc
      return this.study;
    }

    public boolean hasStudy() { 
      return this.study != null && !this.study.isEmpty();
    }

    /**
     * @param value {@link #study} (Reference to the study the subject is participating in.)
     */
    public ResearchSubject setStudy(Reference value) { 
      this.study = value;
      return this;
    }

    /**
     * @return {@link #subject} (The record of the person, animal or other entity involved in the study.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchSubject.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The record of the person, animal or other entity involved in the study.)
     */
    public ResearchSubject setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #assignedArm} (The name of the arm in the study the subject is expected to follow as part of this study.). This is the underlying object with id, value and extensions. The accessor "getAssignedArm" gives direct access to the value
     */
    public StringType getAssignedArmElement() { 
      if (this.assignedArm == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchSubject.assignedArm");
        else if (Configuration.doAutoCreate())
          this.assignedArm = new StringType(); // bb
      return this.assignedArm;
    }

    public boolean hasAssignedArmElement() { 
      return this.assignedArm != null && !this.assignedArm.isEmpty();
    }

    public boolean hasAssignedArm() { 
      return this.assignedArm != null && !this.assignedArm.isEmpty();
    }

    /**
     * @param value {@link #assignedArm} (The name of the arm in the study the subject is expected to follow as part of this study.). This is the underlying object with id, value and extensions. The accessor "getAssignedArm" gives direct access to the value
     */
    public ResearchSubject setAssignedArmElement(StringType value) { 
      this.assignedArm = value;
      return this;
    }

    /**
     * @return The name of the arm in the study the subject is expected to follow as part of this study.
     */
    public String getAssignedArm() { 
      return this.assignedArm == null ? null : this.assignedArm.getValue();
    }

    /**
     * @param value The name of the arm in the study the subject is expected to follow as part of this study.
     */
    public ResearchSubject setAssignedArm(String value) { 
      if (Utilities.noString(value))
        this.assignedArm = null;
      else {
        if (this.assignedArm == null)
          this.assignedArm = new StringType();
        this.assignedArm.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #actualArm} (The name of the arm in the study the subject actually followed as part of this study.). This is the underlying object with id, value and extensions. The accessor "getActualArm" gives direct access to the value
     */
    public StringType getActualArmElement() { 
      if (this.actualArm == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchSubject.actualArm");
        else if (Configuration.doAutoCreate())
          this.actualArm = new StringType(); // bb
      return this.actualArm;
    }

    public boolean hasActualArmElement() { 
      return this.actualArm != null && !this.actualArm.isEmpty();
    }

    public boolean hasActualArm() { 
      return this.actualArm != null && !this.actualArm.isEmpty();
    }

    /**
     * @param value {@link #actualArm} (The name of the arm in the study the subject actually followed as part of this study.). This is the underlying object with id, value and extensions. The accessor "getActualArm" gives direct access to the value
     */
    public ResearchSubject setActualArmElement(StringType value) { 
      this.actualArm = value;
      return this;
    }

    /**
     * @return The name of the arm in the study the subject actually followed as part of this study.
     */
    public String getActualArm() { 
      return this.actualArm == null ? null : this.actualArm.getValue();
    }

    /**
     * @param value The name of the arm in the study the subject actually followed as part of this study.
     */
    public ResearchSubject setActualArm(String value) { 
      if (Utilities.noString(value))
        this.actualArm = null;
      else {
        if (this.actualArm == null)
          this.actualArm = new StringType();
        this.actualArm.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #consent} (A record of the patient's informed agreement to participate in the study.)
     */
    public Reference getConsent() { 
      if (this.consent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchSubject.consent");
        else if (Configuration.doAutoCreate())
          this.consent = new Reference(); // cc
      return this.consent;
    }

    public boolean hasConsent() { 
      return this.consent != null && !this.consent.isEmpty();
    }

    /**
     * @param value {@link #consent} (A record of the patient's informed agreement to participate in the study.)
     */
    public ResearchSubject setConsent(Reference value) { 
      this.consent = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers assigned to this research subject for a study.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The publication state of the resource (not of the subject).", 0, 1, status));
        children.add(new Property("progress", "", "The current state (status) of the subject and resons for status change where appropriate.", 0, java.lang.Integer.MAX_VALUE, progress));
        children.add(new Property("period", "Period", "The dates the subject began and ended their participation in the study.", 0, 1, period));
        children.add(new Property("study", "Reference(ResearchStudy)", "Reference to the study the subject is participating in.", 0, 1, study));
        children.add(new Property("subject", "Reference(Patient|Group|Specimen|Device|Medication|Substance|BiologicallyDerivedProduct)", "The record of the person, animal or other entity involved in the study.", 0, 1, subject));
        children.add(new Property("assignedArm", "string", "The name of the arm in the study the subject is expected to follow as part of this study.", 0, 1, assignedArm));
        children.add(new Property("actualArm", "string", "The name of the arm in the study the subject actually followed as part of this study.", 0, 1, actualArm));
        children.add(new Property("consent", "Reference(Consent)", "A record of the patient's informed agreement to participate in the study.", 0, 1, consent));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers assigned to this research subject for a study.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The publication state of the resource (not of the subject).", 0, 1, status);
        case -1001078227: /*progress*/  return new Property("progress", "", "The current state (status) of the subject and resons for status change where appropriate.", 0, java.lang.Integer.MAX_VALUE, progress);
        case -991726143: /*period*/  return new Property("period", "Period", "The dates the subject began and ended their participation in the study.", 0, 1, period);
        case 109776329: /*study*/  return new Property("study", "Reference(ResearchStudy)", "Reference to the study the subject is participating in.", 0, 1, study);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group|Specimen|Device|Medication|Substance|BiologicallyDerivedProduct)", "The record of the person, animal or other entity involved in the study.", 0, 1, subject);
        case 1741912494: /*assignedArm*/  return new Property("assignedArm", "string", "The name of the arm in the study the subject is expected to follow as part of this study.", 0, 1, assignedArm);
        case 528827886: /*actualArm*/  return new Property("actualArm", "string", "The name of the arm in the study the subject actually followed as part of this study.", 0, 1, actualArm);
        case 951500826: /*consent*/  return new Property("consent", "Reference(Consent)", "A record of the patient's informed agreement to participate in the study.", 0, 1, consent);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -1001078227: /*progress*/ return this.progress == null ? new Base[0] : this.progress.toArray(new Base[this.progress.size()]); // ResearchSubjectProgressComponent
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 109776329: /*study*/ return this.study == null ? new Base[0] : new Base[] {this.study}; // Reference
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1741912494: /*assignedArm*/ return this.assignedArm == null ? new Base[0] : new Base[] {this.assignedArm}; // StringType
        case 528827886: /*actualArm*/ return this.actualArm == null ? new Base[0] : new Base[] {this.actualArm}; // StringType
        case 951500826: /*consent*/ return this.consent == null ? new Base[0] : new Base[] {this.consent}; // Reference
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
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -1001078227: // progress
          this.getProgress().add((ResearchSubjectProgressComponent) value); // ResearchSubjectProgressComponent
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 109776329: // study
          this.study = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1741912494: // assignedArm
          this.assignedArm = TypeConvertor.castToString(value); // StringType
          return value;
        case 528827886: // actualArm
          this.actualArm = TypeConvertor.castToString(value); // StringType
          return value;
        case 951500826: // consent
          this.consent = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("progress")) {
          this.getProgress().add((ResearchSubjectProgressComponent) value);
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("study")) {
          this.study = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("assignedArm")) {
          this.assignedArm = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("actualArm")) {
          this.actualArm = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("consent")) {
          this.consent = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -1001078227:  return addProgress(); 
        case -991726143:  return getPeriod();
        case 109776329:  return getStudy();
        case -1867885268:  return getSubject();
        case 1741912494:  return getAssignedArmElement();
        case 528827886:  return getActualArmElement();
        case 951500826:  return getConsent();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1001078227: /*progress*/ return new String[] {};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 109776329: /*study*/ return new String[] {"Reference"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1741912494: /*assignedArm*/ return new String[] {"string"};
        case 528827886: /*actualArm*/ return new String[] {"string"};
        case 951500826: /*consent*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ResearchSubject.status");
        }
        else if (name.equals("progress")) {
          return addProgress();
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("study")) {
          this.study = new Reference();
          return this.study;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("assignedArm")) {
          throw new FHIRException("Cannot call addChild on a primitive type ResearchSubject.assignedArm");
        }
        else if (name.equals("actualArm")) {
          throw new FHIRException("Cannot call addChild on a primitive type ResearchSubject.actualArm");
        }
        else if (name.equals("consent")) {
          this.consent = new Reference();
          return this.consent;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ResearchSubject";

  }

      public ResearchSubject copy() {
        ResearchSubject dst = new ResearchSubject();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ResearchSubject dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (progress != null) {
          dst.progress = new ArrayList<ResearchSubjectProgressComponent>();
          for (ResearchSubjectProgressComponent i : progress)
            dst.progress.add(i.copy());
        };
        dst.period = period == null ? null : period.copy();
        dst.study = study == null ? null : study.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.assignedArm = assignedArm == null ? null : assignedArm.copy();
        dst.actualArm = actualArm == null ? null : actualArm.copy();
        dst.consent = consent == null ? null : consent.copy();
      }

      protected ResearchSubject typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ResearchSubject))
          return false;
        ResearchSubject o = (ResearchSubject) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(progress, o.progress, true)
           && compareDeep(period, o.period, true) && compareDeep(study, o.study, true) && compareDeep(subject, o.subject, true)
           && compareDeep(assignedArm, o.assignedArm, true) && compareDeep(actualArm, o.actualArm, true) && compareDeep(consent, o.consent, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchSubject))
          return false;
        ResearchSubject o = (ResearchSubject) other_;
        return compareValues(status, o.status, true) && compareValues(assignedArm, o.assignedArm, true) && compareValues(actualArm, o.actualArm, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, progress
          , period, study, subject, assignedArm, actualArm, consent);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ResearchSubject;
   }

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Start and end of participation</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ResearchSubject.period</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ResearchSubject.period", description="Start and end of participation", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Start and end of participation</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ResearchSubject.period</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business Identifier for research subject in a study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchSubject.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ResearchSubject.identifier", description="Business Identifier for research subject in a study", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business Identifier for research subject in a study</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchSubject.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Who or what is part of study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchSubject.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="ResearchSubject.subject", description="Who or what is part of study", type="reference", target={BiologicallyDerivedProduct.class, Device.class, Group.class, Medication.class, Patient.class, Specimen.class, Substance.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Who or what is part of study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchSubject.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ResearchSubject:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("ResearchSubject:patient").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>draft | active | retired | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchSubject.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ResearchSubject.status", description="draft | active | retired | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>draft | active | retired | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchSubject.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>study</b>
   * <p>
   * Description: <b>Study subject is part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchSubject.study</b><br>
   * </p>
   */
  @SearchParamDefinition(name="study", path="ResearchSubject.study", description="Study subject is part of", type="reference", target={ResearchStudy.class } )
  public static final String SP_STUDY = "study";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>study</b>
   * <p>
   * Description: <b>Study subject is part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchSubject.study</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam STUDY = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_STUDY);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ResearchSubject:study</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_STUDY = new ca.uhn.fhir.model.api.Include("ResearchSubject:study").toLocked();

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Who or what is part of study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchSubject.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="ResearchSubject.subject", description="Who or what is part of study", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={BiologicallyDerivedProduct.class, Device.class, Group.class, Medication.class, Patient.class, Specimen.class, Substance.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Who or what is part of study</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ResearchSubject.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ResearchSubject:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("ResearchSubject:subject").toLocked();

 /**
   * Search parameter: <b>subject_state</b>
   * <p>
   * Description: <b>candidate | eligible | follow-up | ineligible | not-registered | off-study | on-study | on-study-intervention | on-study-observation | pending-on-study | potential-candidate | screening | withdrawn</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchSubject.progress.subjectState</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject_state", path="ResearchSubject.progress.subjectState", description="candidate | eligible | follow-up | ineligible | not-registered | off-study | on-study | on-study-intervention | on-study-observation | pending-on-study | potential-candidate | screening | withdrawn", type="token" )
  public static final String SP_SUBJECTSTATE = "subject_state";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject_state</b>
   * <p>
   * Description: <b>candidate | eligible | follow-up | ineligible | not-registered | off-study | on-study | on-study-intervention | on-study-observation | pending-on-study | potential-candidate | screening | withdrawn</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ResearchSubject.progress.subjectState</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SUBJECTSTATE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SUBJECTSTATE);


}

