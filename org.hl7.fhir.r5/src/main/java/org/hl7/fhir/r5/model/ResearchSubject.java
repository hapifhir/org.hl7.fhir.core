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
 * A ResearchSubject is a participant or object which is the recipient of investigative activities in a research study.
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
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/state-change-reason")
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
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("subjectState")) {
          this.subjectState = null;
        } else if (name.equals("milestone")) {
          this.milestone = null;
        } else if (name.equals("reason")) {
          this.reason = null;
        } else if (name.equals("startDate")) {
          this.startDate = null;
        } else if (name.equals("endDate")) {
          this.endDate = null;
        } else
          super.removeChild(name, value);
        
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
          throw new FHIRException("Cannot call addChild on a singleton property ResearchSubject.progress.startDate");
        }
        else if (name.equals("endDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchSubject.progress.endDate");
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
    @Child(name = "assignedComparisonGroup", type = {IdType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="What path should be followed", formalDefinition="The name of the arm in the study the subject is expected to follow as part of this study." )
    protected IdType assignedComparisonGroup;

    /**
     * The name of the arm in the study the subject actually followed as part of this study.
     */
    @Child(name = "actualComparisonGroup", type = {IdType.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="What path was followed", formalDefinition="The name of the arm in the study the subject actually followed as part of this study." )
    protected IdType actualComparisonGroup;

    /**
     * A record of the patient's informed agreement to participate in the study.
     */
    @Child(name = "consent", type = {Consent.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Agreement to participate in study", formalDefinition="A record of the patient's informed agreement to participate in the study." )
    protected List<Reference> consent;

    private static final long serialVersionUID = -1058527147L;

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
     * @return {@link #assignedComparisonGroup} (The name of the arm in the study the subject is expected to follow as part of this study.). This is the underlying object with id, value and extensions. The accessor "getAssignedComparisonGroup" gives direct access to the value
     */
    public IdType getAssignedComparisonGroupElement() { 
      if (this.assignedComparisonGroup == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchSubject.assignedComparisonGroup");
        else if (Configuration.doAutoCreate())
          this.assignedComparisonGroup = new IdType(); // bb
      return this.assignedComparisonGroup;
    }

    public boolean hasAssignedComparisonGroupElement() { 
      return this.assignedComparisonGroup != null && !this.assignedComparisonGroup.isEmpty();
    }

    public boolean hasAssignedComparisonGroup() { 
      return this.assignedComparisonGroup != null && !this.assignedComparisonGroup.isEmpty();
    }

    /**
     * @param value {@link #assignedComparisonGroup} (The name of the arm in the study the subject is expected to follow as part of this study.). This is the underlying object with id, value and extensions. The accessor "getAssignedComparisonGroup" gives direct access to the value
     */
    public ResearchSubject setAssignedComparisonGroupElement(IdType value) { 
      this.assignedComparisonGroup = value;
      return this;
    }

    /**
     * @return The name of the arm in the study the subject is expected to follow as part of this study.
     */
    public String getAssignedComparisonGroup() { 
      return this.assignedComparisonGroup == null ? null : this.assignedComparisonGroup.getValue();
    }

    /**
     * @param value The name of the arm in the study the subject is expected to follow as part of this study.
     */
    public ResearchSubject setAssignedComparisonGroup(String value) { 
      if (Utilities.noString(value))
        this.assignedComparisonGroup = null;
      else {
        if (this.assignedComparisonGroup == null)
          this.assignedComparisonGroup = new IdType();
        this.assignedComparisonGroup.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #actualComparisonGroup} (The name of the arm in the study the subject actually followed as part of this study.). This is the underlying object with id, value and extensions. The accessor "getActualComparisonGroup" gives direct access to the value
     */
    public IdType getActualComparisonGroupElement() { 
      if (this.actualComparisonGroup == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ResearchSubject.actualComparisonGroup");
        else if (Configuration.doAutoCreate())
          this.actualComparisonGroup = new IdType(); // bb
      return this.actualComparisonGroup;
    }

    public boolean hasActualComparisonGroupElement() { 
      return this.actualComparisonGroup != null && !this.actualComparisonGroup.isEmpty();
    }

    public boolean hasActualComparisonGroup() { 
      return this.actualComparisonGroup != null && !this.actualComparisonGroup.isEmpty();
    }

    /**
     * @param value {@link #actualComparisonGroup} (The name of the arm in the study the subject actually followed as part of this study.). This is the underlying object with id, value and extensions. The accessor "getActualComparisonGroup" gives direct access to the value
     */
    public ResearchSubject setActualComparisonGroupElement(IdType value) { 
      this.actualComparisonGroup = value;
      return this;
    }

    /**
     * @return The name of the arm in the study the subject actually followed as part of this study.
     */
    public String getActualComparisonGroup() { 
      return this.actualComparisonGroup == null ? null : this.actualComparisonGroup.getValue();
    }

    /**
     * @param value The name of the arm in the study the subject actually followed as part of this study.
     */
    public ResearchSubject setActualComparisonGroup(String value) { 
      if (Utilities.noString(value))
        this.actualComparisonGroup = null;
      else {
        if (this.actualComparisonGroup == null)
          this.actualComparisonGroup = new IdType();
        this.actualComparisonGroup.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #consent} (A record of the patient's informed agreement to participate in the study.)
     */
    public List<Reference> getConsent() { 
      if (this.consent == null)
        this.consent = new ArrayList<Reference>();
      return this.consent;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ResearchSubject setConsent(List<Reference> theConsent) { 
      this.consent = theConsent;
      return this;
    }

    public boolean hasConsent() { 
      if (this.consent == null)
        return false;
      for (Reference item : this.consent)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addConsent() { //3
      Reference t = new Reference();
      if (this.consent == null)
        this.consent = new ArrayList<Reference>();
      this.consent.add(t);
      return t;
    }

    public ResearchSubject addConsent(Reference t) { //3
      if (t == null)
        return this;
      if (this.consent == null)
        this.consent = new ArrayList<Reference>();
      this.consent.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #consent}, creating it if it does not already exist {3}
     */
    public Reference getConsentFirstRep() { 
      if (getConsent().isEmpty()) {
        addConsent();
      }
      return getConsent().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers assigned to this research subject for a study.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The publication state of the resource (not of the subject).", 0, 1, status));
        children.add(new Property("progress", "", "The current state (status) of the subject and resons for status change where appropriate.", 0, java.lang.Integer.MAX_VALUE, progress));
        children.add(new Property("period", "Period", "The dates the subject began and ended their participation in the study.", 0, 1, period));
        children.add(new Property("study", "Reference(ResearchStudy)", "Reference to the study the subject is participating in.", 0, 1, study));
        children.add(new Property("subject", "Reference(Patient|Group|Specimen|Device|Medication|Substance|BiologicallyDerivedProduct)", "The record of the person, animal or other entity involved in the study.", 0, 1, subject));
        children.add(new Property("assignedComparisonGroup", "id", "The name of the arm in the study the subject is expected to follow as part of this study.", 0, 1, assignedComparisonGroup));
        children.add(new Property("actualComparisonGroup", "id", "The name of the arm in the study the subject actually followed as part of this study.", 0, 1, actualComparisonGroup));
        children.add(new Property("consent", "Reference(Consent)", "A record of the patient's informed agreement to participate in the study.", 0, java.lang.Integer.MAX_VALUE, consent));
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
        case 394644552: /*assignedComparisonGroup*/  return new Property("assignedComparisonGroup", "id", "The name of the arm in the study the subject is expected to follow as part of this study.", 0, 1, assignedComparisonGroup);
        case -676906872: /*actualComparisonGroup*/  return new Property("actualComparisonGroup", "id", "The name of the arm in the study the subject actually followed as part of this study.", 0, 1, actualComparisonGroup);
        case 951500826: /*consent*/  return new Property("consent", "Reference(Consent)", "A record of the patient's informed agreement to participate in the study.", 0, java.lang.Integer.MAX_VALUE, consent);
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
        case 394644552: /*assignedComparisonGroup*/ return this.assignedComparisonGroup == null ? new Base[0] : new Base[] {this.assignedComparisonGroup}; // IdType
        case -676906872: /*actualComparisonGroup*/ return this.actualComparisonGroup == null ? new Base[0] : new Base[] {this.actualComparisonGroup}; // IdType
        case 951500826: /*consent*/ return this.consent == null ? new Base[0] : this.consent.toArray(new Base[this.consent.size()]); // Reference
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
        case 394644552: // assignedComparisonGroup
          this.assignedComparisonGroup = TypeConvertor.castToId(value); // IdType
          return value;
        case -676906872: // actualComparisonGroup
          this.actualComparisonGroup = TypeConvertor.castToId(value); // IdType
          return value;
        case 951500826: // consent
          this.getConsent().add(TypeConvertor.castToReference(value)); // Reference
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
        } else if (name.equals("assignedComparisonGroup")) {
          this.assignedComparisonGroup = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("actualComparisonGroup")) {
          this.actualComparisonGroup = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("consent")) {
          this.getConsent().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("progress")) {
          this.getProgress().add((ResearchSubjectProgressComponent) value);
        } else if (name.equals("period")) {
          this.period = null;
        } else if (name.equals("study")) {
          this.study = null;
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("assignedComparisonGroup")) {
          this.assignedComparisonGroup = null;
        } else if (name.equals("actualComparisonGroup")) {
          this.actualComparisonGroup = null;
        } else if (name.equals("consent")) {
          this.getConsent().remove(value);
        } else
          super.removeChild(name, value);
        
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
        case 394644552:  return getAssignedComparisonGroupElement();
        case -676906872:  return getActualComparisonGroupElement();
        case 951500826:  return addConsent(); 
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
        case 394644552: /*assignedComparisonGroup*/ return new String[] {"id"};
        case -676906872: /*actualComparisonGroup*/ return new String[] {"id"};
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
          throw new FHIRException("Cannot call addChild on a singleton property ResearchSubject.status");
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
        else if (name.equals("assignedComparisonGroup")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchSubject.assignedComparisonGroup");
        }
        else if (name.equals("actualComparisonGroup")) {
          throw new FHIRException("Cannot call addChild on a singleton property ResearchSubject.actualComparisonGroup");
        }
        else if (name.equals("consent")) {
          return addConsent();
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
        dst.assignedComparisonGroup = assignedComparisonGroup == null ? null : assignedComparisonGroup.copy();
        dst.actualComparisonGroup = actualComparisonGroup == null ? null : actualComparisonGroup.copy();
        if (consent != null) {
          dst.consent = new ArrayList<Reference>();
          for (Reference i : consent)
            dst.consent.add(i.copy());
        };
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
           && compareDeep(assignedComparisonGroup, o.assignedComparisonGroup, true) && compareDeep(actualComparisonGroup, o.actualComparisonGroup, true)
           && compareDeep(consent, o.consent, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ResearchSubject))
          return false;
        ResearchSubject o = (ResearchSubject) other_;
        return compareValues(status, o.status, true) && compareValues(assignedComparisonGroup, o.assignedComparisonGroup, true)
           && compareValues(actualComparisonGroup, o.actualComparisonGroup, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, progress
          , period, study, subject, assignedComparisonGroup, actualComparisonGroup, consent
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ResearchSubject;
   }

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

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): When the event occurred
* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [Appointment](appointment.html): Appointment date/time.
* [AuditEvent](auditevent.html): Time when the event was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [DocumentReference](documentreference.html): When this document reference was created
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated
* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created
* [Invoice](invoice.html): Invoice date / posting date
* [List](list.html): When the list was prepared
* [MeasureReport](measurereport.html): The date of the measure report
* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication
* [Observation](observation.html): Clinically relevant time/time-period for observation
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [ResearchSubject](researchsubject.html): Start and end of participation
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn", description="Multiple Resources: \r\n\r\n* [AdverseEvent](adverseevent.html): When the event occurred\r\n* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded\r\n* [Appointment](appointment.html): Appointment date/time.\r\n* [AuditEvent](auditevent.html): Time when the event was recorded\r\n* [CarePlan](careplan.html): Time period plan covers\r\n* [CareTeam](careteam.html): A date within the coverage time period.\r\n* [ClinicalImpression](clinicalimpression.html): When the assessment was documented\r\n* [Composition](composition.html): Composition editing time\r\n* [Consent](consent.html): When consent was agreed to\r\n* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report\r\n* [DocumentReference](documentreference.html): When this document reference was created\r\n* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted\r\n* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period\r\n* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated\r\n* [Flag](flag.html): Time period when flag is active\r\n* [Immunization](immunization.html): Vaccination  (non)-Administration Date\r\n* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created\r\n* [Invoice](invoice.html): Invoice date / posting date\r\n* [List](list.html): When the list was prepared\r\n* [MeasureReport](measurereport.html): The date of the measure report\r\n* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication\r\n* [Observation](observation.html): Clinically relevant time/time-period for observation\r\n* [Procedure](procedure.html): When the procedure occurred or is occurring\r\n* [ResearchSubject](researchsubject.html): Start and end of participation\r\n* [RiskAssessment](riskassessment.html): When was assessment made?\r\n* [SupplyRequest](supplyrequest.html): When the request was made\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): When the event occurred
* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [Appointment](appointment.html): Appointment date/time.
* [AuditEvent](auditevent.html): Time when the event was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [DocumentReference](documentreference.html): When this document reference was created
* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated
* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created
* [Invoice](invoice.html): Invoice date / posting date
* [List](list.html): When the list was prepared
* [MeasureReport](measurereport.html): The date of the measure report
* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication
* [Observation](observation.html): Clinically relevant time/time-period for observation
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [ResearchSubject](researchsubject.html): Start and end of participation
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [Account](account.html): Account number\r\n* [AdverseEvent](adverseevent.html): Business identifier for the event\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [Appointment](appointment.html): An Identifier of the Appointment\r\n* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response\r\n* [Basic](basic.html): Business identifier\r\n* [BodyStructure](bodystructure.html): Bodystructure identifier\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [ChargeItem](chargeitem.html): Business Identifier for item\r\n* [Claim](claim.html): The primary identifier of the financial resource\r\n* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse\r\n* [ClinicalImpression](clinicalimpression.html): Business identifier\r\n* [Communication](communication.html): Unique identifier\r\n* [CommunicationRequest](communicationrequest.html): Unique identifier\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [Contract](contract.html): The identity of the contract\r\n* [Coverage](coverage.html): The primary identifier of the insured and the coverage\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DeviceUsage](deviceusage.html): Search by identifier\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Flag](flag.html): Business identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response\r\n* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier\r\n* [Invoice](invoice.html): Business Identifier for item\r\n* [List](list.html): Business identifier\r\n* [MeasureReport](measurereport.html): External identifier of the measure report to be returned\r\n* [Medication](medication.html): Returns medications with this external identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationStatement](medicationstatement.html): Return statements with this external identifier\r\n* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence\r\n* [NutritionIntake](nutritionintake.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Person](person.html): A person Identifier\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response\r\n* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson\r\n* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration\r\n* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [Specimen](specimen.html): The unique identifier associated with the specimen\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [Task](task.html): Search for a task instance by its business identifier\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ResearchSubject:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("ResearchSubject:patient").toLocked();


}

