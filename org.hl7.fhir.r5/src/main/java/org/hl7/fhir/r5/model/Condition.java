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
 * A clinical condition, problem, diagnosis, or other event, situation, issue, or clinical concept that has risen to a level of concern.
 */
@ResourceDef(name="Condition", profile="http://hl7.org/fhir/StructureDefinition/Condition")
public class Condition extends DomainResource {

    @Block()
    public static class ConditionParticipantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Distinguishes the type of involvement of the actor in the activities related to the condition.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of involvement", formalDefinition="Distinguishes the type of involvement of the actor in the activities related to the condition." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participation-role-type")
        protected CodeableConcept function;

        /**
         * Indicates who or what participated in the activities related to the condition.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Patient.class, RelatedPerson.class, Device.class, Organization.class, CareTeam.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Who or what participated in the activities related to the condition", formalDefinition="Indicates who or what participated in the activities related to the condition." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

    /**
     * Constructor
     */
      public ConditionParticipantComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ConditionParticipantComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #function} (Distinguishes the type of involvement of the actor in the activities related to the condition.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionParticipantComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Distinguishes the type of involvement of the actor in the activities related to the condition.)
         */
        public ConditionParticipantComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (Indicates who or what participated in the activities related to the condition.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionParticipantComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (Indicates who or what participated in the activities related to the condition.)
         */
        public ConditionParticipantComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the actor in the activities related to the condition.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson|Device|Organization|CareTeam)", "Indicates who or what participated in the activities related to the condition.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Distinguishes the type of involvement of the actor in the activities related to the condition.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Patient|RelatedPerson|Device|Organization|CareTeam)", "Indicates who or what participated in the activities related to the condition.", 0, 1, actor);
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

      public ConditionParticipantComponent copy() {
        ConditionParticipantComponent dst = new ConditionParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConditionParticipantComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConditionParticipantComponent))
          return false;
        ConditionParticipantComponent o = (ConditionParticipantComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConditionParticipantComponent))
          return false;
        ConditionParticipantComponent o = (ConditionParticipantComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "Condition.participant";

  }

  }

    @Block()
    public static class ConditionStageComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease.
         */
        @Child(name = "summary", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Simple summary (disease specific)", formalDefinition="A simple summary of the stage such as \"Stage 3\" or \"Early Onset\". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-stage")
        protected CodeableConcept summary;

        /**
         * Reference to a formal record of the evidence on which the staging assessment is based.
         */
        @Child(name = "assessment", type = {ClinicalImpression.class, DiagnosticReport.class, Observation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Formal record of assessment", formalDefinition="Reference to a formal record of the evidence on which the staging assessment is based." )
        protected List<Reference> assessment;

        /**
         * The kind of staging, such as pathological or clinical staging.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Kind of staging", formalDefinition="The kind of staging, such as pathological or clinical staging." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-stage-type")
        protected CodeableConcept type;

        private static final long serialVersionUID = -394541797L;

    /**
     * Constructor
     */
      public ConditionStageComponent() {
        super();
      }

        /**
         * @return {@link #summary} (A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease.)
         */
        public CodeableConcept getSummary() { 
          if (this.summary == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionStageComponent.summary");
            else if (Configuration.doAutoCreate())
              this.summary = new CodeableConcept(); // cc
          return this.summary;
        }

        public boolean hasSummary() { 
          return this.summary != null && !this.summary.isEmpty();
        }

        /**
         * @param value {@link #summary} (A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease.)
         */
        public ConditionStageComponent setSummary(CodeableConcept value) { 
          this.summary = value;
          return this;
        }

        /**
         * @return {@link #assessment} (Reference to a formal record of the evidence on which the staging assessment is based.)
         */
        public List<Reference> getAssessment() { 
          if (this.assessment == null)
            this.assessment = new ArrayList<Reference>();
          return this.assessment;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ConditionStageComponent setAssessment(List<Reference> theAssessment) { 
          this.assessment = theAssessment;
          return this;
        }

        public boolean hasAssessment() { 
          if (this.assessment == null)
            return false;
          for (Reference item : this.assessment)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addAssessment() { //3
          Reference t = new Reference();
          if (this.assessment == null)
            this.assessment = new ArrayList<Reference>();
          this.assessment.add(t);
          return t;
        }

        public ConditionStageComponent addAssessment(Reference t) { //3
          if (t == null)
            return this;
          if (this.assessment == null)
            this.assessment = new ArrayList<Reference>();
          this.assessment.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #assessment}, creating it if it does not already exist {3}
         */
        public Reference getAssessmentFirstRep() { 
          if (getAssessment().isEmpty()) {
            addAssessment();
          }
          return getAssessment().get(0);
        }

        /**
         * @return {@link #type} (The kind of staging, such as pathological or clinical staging.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionStageComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The kind of staging, such as pathological or clinical staging.)
         */
        public ConditionStageComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("summary", "CodeableConcept", "A simple summary of the stage such as \"Stage 3\" or \"Early Onset\". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease.", 0, 1, summary));
          children.add(new Property("assessment", "Reference(ClinicalImpression|DiagnosticReport|Observation)", "Reference to a formal record of the evidence on which the staging assessment is based.", 0, java.lang.Integer.MAX_VALUE, assessment));
          children.add(new Property("type", "CodeableConcept", "The kind of staging, such as pathological or clinical staging.", 0, 1, type));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1857640538: /*summary*/  return new Property("summary", "CodeableConcept", "A simple summary of the stage such as \"Stage 3\" or \"Early Onset\". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease.", 0, 1, summary);
          case 2119382722: /*assessment*/  return new Property("assessment", "Reference(ClinicalImpression|DiagnosticReport|Observation)", "Reference to a formal record of the evidence on which the staging assessment is based.", 0, java.lang.Integer.MAX_VALUE, assessment);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The kind of staging, such as pathological or clinical staging.", 0, 1, type);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1857640538: /*summary*/ return this.summary == null ? new Base[0] : new Base[] {this.summary}; // CodeableConcept
        case 2119382722: /*assessment*/ return this.assessment == null ? new Base[0] : this.assessment.toArray(new Base[this.assessment.size()]); // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1857640538: // summary
          this.summary = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 2119382722: // assessment
          this.getAssessment().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("summary")) {
          this.summary = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("assessment")) {
          this.getAssessment().add(TypeConvertor.castToReference(value));
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("summary")) {
          this.summary = null;
        } else if (name.equals("assessment")) {
          this.getAssessment().remove(value);
        } else if (name.equals("type")) {
          this.type = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1857640538:  return getSummary();
        case 2119382722:  return addAssessment(); 
        case 3575610:  return getType();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1857640538: /*summary*/ return new String[] {"CodeableConcept"};
        case 2119382722: /*assessment*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("summary")) {
          this.summary = new CodeableConcept();
          return this.summary;
        }
        else if (name.equals("assessment")) {
          return addAssessment();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else
          return super.addChild(name);
      }

      public ConditionStageComponent copy() {
        ConditionStageComponent dst = new ConditionStageComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConditionStageComponent dst) {
        super.copyValues(dst);
        dst.summary = summary == null ? null : summary.copy();
        if (assessment != null) {
          dst.assessment = new ArrayList<Reference>();
          for (Reference i : assessment)
            dst.assessment.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConditionStageComponent))
          return false;
        ConditionStageComponent o = (ConditionStageComponent) other_;
        return compareDeep(summary, o.summary, true) && compareDeep(assessment, o.assessment, true) && compareDeep(type, o.type, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConditionStageComponent))
          return false;
        ConditionStageComponent o = (ConditionStageComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(summary, assessment, type
          );
      }

  public String fhirType() {
    return "Condition.stage";

  }

  }

    /**
     * Business identifiers assigned to this condition by the performer or other systems which remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="External Ids for this condition", formalDefinition="Business identifiers assigned to this condition by the performer or other systems which remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * The clinical status of the condition.
     */
    @Child(name = "clinicalStatus", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | recurrence | relapse | inactive | remission | resolved | unknown", formalDefinition="The clinical status of the condition." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-clinical")
    protected CodeableConcept clinicalStatus;

    /**
     * The verification status to support the clinical status of the condition.  The verification status pertains to the condition, itself, not to any specific condition attribute.
     */
    @Child(name = "verificationStatus", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="unconfirmed | provisional | differential | confirmed | refuted | entered-in-error", formalDefinition="The verification status to support the clinical status of the condition.  The verification status pertains to the condition, itself, not to any specific condition attribute." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-ver-status")
    protected CodeableConcept verificationStatus;

    /**
     * A category assigned to the condition.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="problem-list-item | encounter-diagnosis", formalDefinition="A category assigned to the condition." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-category")
    protected List<CodeableConcept> category;

    /**
     * A subjective assessment of the severity of the condition as evaluated by the clinician.
     */
    @Child(name = "severity", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Subjective severity of condition", formalDefinition="A subjective assessment of the severity of the condition as evaluated by the clinician." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-severity")
    protected CodeableConcept severity;

    /**
     * Identification of the condition, problem or diagnosis.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Identification of the condition, problem or diagnosis", formalDefinition="Identification of the condition, problem or diagnosis." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
    protected CodeableConcept code;

    /**
     * The anatomical location where this condition manifests itself.
     */
    @Child(name = "bodySite", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Anatomical location, if relevant", formalDefinition="The anatomical location where this condition manifests itself." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected List<CodeableConcept> bodySite;

    /**
     * Indicates the patient or group who the condition record is associated with.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Who has the condition?", formalDefinition="Indicates the patient or group who the condition record is associated with." )
    protected Reference subject;

    /**
     * The Encounter during which this Condition was created or to which the creation of this record is tightly associated.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The Encounter during which this Condition was created", formalDefinition="The Encounter during which this Condition was created or to which the creation of this record is tightly associated." )
    protected Reference encounter;

    /**
     * Estimated or actual date or date-time  the condition began, in the opinion of the clinician.
     */
    @Child(name = "onset", type = {DateTimeType.class, Age.class, Period.class, Range.class, StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Estimated or actual date,  date-time, or age", formalDefinition="Estimated or actual date or date-time  the condition began, in the opinion of the clinician." )
    protected DataType onset;

    /**
     * The date or estimated date that the condition resolved or went into remission. This is called "abatement" because of the many overloaded connotations associated with "remission" or "resolution" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.
     */
    @Child(name = "abatement", type = {DateTimeType.class, Age.class, Period.class, Range.class, StringType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When in resolution/remission", formalDefinition="The date or estimated date that the condition resolved or went into remission. This is called \"abatement\" because of the many overloaded connotations associated with \"remission\" or \"resolution\" - Some conditions, such as chronic conditions, are never really resolved, but they can abate." )
    protected DataType abatement;

    /**
     * The recordedDate represents when this particular Condition record was created in the system, which is often a system-generated date.
     */
    @Child(name = "recordedDate", type = {DateTimeType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date condition was first recorded", formalDefinition="The recordedDate represents when this particular Condition record was created in the system, which is often a system-generated date." )
    protected DateTimeType recordedDate;

    /**
     * Indicates who or what participated in the activities related to the condition and how they were involved.
     */
    @Child(name = "participant", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Who or what participated in the activities related to the condition and how they were involved", formalDefinition="Indicates who or what participated in the activities related to the condition and how they were involved." )
    protected List<ConditionParticipantComponent> participant;

    /**
     * A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease.
     */
    @Child(name = "stage", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Stage/grade, usually assessed formally", formalDefinition="A simple summary of the stage such as \"Stage 3\" or \"Early Onset\". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease." )
    protected List<ConditionStageComponent> stage;

    /**
     * Supporting evidence / manifestations that are the basis of the Condition's verification status, such as evidence that confirmed or refuted the condition.
     */
    @Child(name = "evidence", type = {CodeableReference.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Supporting evidence for the verification status", formalDefinition="Supporting evidence / manifestations that are the basis of the Condition's verification status, such as evidence that confirmed or refuted the condition." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-findings")
    protected List<CodeableReference> evidence;

    /**
     * Additional information about the Condition. This is a general notes/comments entry  for description of the Condition, its diagnosis and prognosis.
     */
    @Child(name = "note", type = {Annotation.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional information about the Condition", formalDefinition="Additional information about the Condition. This is a general notes/comments entry  for description of the Condition, its diagnosis and prognosis." )
    protected List<Annotation> note;

    private static final long serialVersionUID = -610903427L;

  /**
   * Constructor
   */
    public Condition() {
      super();
    }

  /**
   * Constructor
   */
    public Condition(CodeableConcept clinicalStatus, Reference subject) {
      super();
      this.setClinicalStatus(clinicalStatus);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this condition by the performer or other systems which remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Condition setIdentifier(List<Identifier> theIdentifier) { 
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

    public Condition addIdentifier(Identifier t) { //3
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
     * @return {@link #clinicalStatus} (The clinical status of the condition.)
     */
    public CodeableConcept getClinicalStatus() { 
      if (this.clinicalStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Condition.clinicalStatus");
        else if (Configuration.doAutoCreate())
          this.clinicalStatus = new CodeableConcept(); // cc
      return this.clinicalStatus;
    }

    public boolean hasClinicalStatus() { 
      return this.clinicalStatus != null && !this.clinicalStatus.isEmpty();
    }

    /**
     * @param value {@link #clinicalStatus} (The clinical status of the condition.)
     */
    public Condition setClinicalStatus(CodeableConcept value) { 
      this.clinicalStatus = value;
      return this;
    }

    /**
     * @return {@link #verificationStatus} (The verification status to support the clinical status of the condition.  The verification status pertains to the condition, itself, not to any specific condition attribute.)
     */
    public CodeableConcept getVerificationStatus() { 
      if (this.verificationStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Condition.verificationStatus");
        else if (Configuration.doAutoCreate())
          this.verificationStatus = new CodeableConcept(); // cc
      return this.verificationStatus;
    }

    public boolean hasVerificationStatus() { 
      return this.verificationStatus != null && !this.verificationStatus.isEmpty();
    }

    /**
     * @param value {@link #verificationStatus} (The verification status to support the clinical status of the condition.  The verification status pertains to the condition, itself, not to any specific condition attribute.)
     */
    public Condition setVerificationStatus(CodeableConcept value) { 
      this.verificationStatus = value;
      return this;
    }

    /**
     * @return {@link #category} (A category assigned to the condition.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Condition setCategory(List<CodeableConcept> theCategory) { 
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

    public Condition addCategory(CodeableConcept t) { //3
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
     * @return {@link #severity} (A subjective assessment of the severity of the condition as evaluated by the clinician.)
     */
    public CodeableConcept getSeverity() { 
      if (this.severity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Condition.severity");
        else if (Configuration.doAutoCreate())
          this.severity = new CodeableConcept(); // cc
      return this.severity;
    }

    public boolean hasSeverity() { 
      return this.severity != null && !this.severity.isEmpty();
    }

    /**
     * @param value {@link #severity} (A subjective assessment of the severity of the condition as evaluated by the clinician.)
     */
    public Condition setSeverity(CodeableConcept value) { 
      this.severity = value;
      return this;
    }

    /**
     * @return {@link #code} (Identification of the condition, problem or diagnosis.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Condition.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Identification of the condition, problem or diagnosis.)
     */
    public Condition setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #bodySite} (The anatomical location where this condition manifests itself.)
     */
    public List<CodeableConcept> getBodySite() { 
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      return this.bodySite;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Condition setBodySite(List<CodeableConcept> theBodySite) { 
      this.bodySite = theBodySite;
      return this;
    }

    public boolean hasBodySite() { 
      if (this.bodySite == null)
        return false;
      for (CodeableConcept item : this.bodySite)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addBodySite() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      this.bodySite.add(t);
      return t;
    }

    public Condition addBodySite(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.bodySite == null)
        this.bodySite = new ArrayList<CodeableConcept>();
      this.bodySite.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #bodySite}, creating it if it does not already exist {3}
     */
    public CodeableConcept getBodySiteFirstRep() { 
      if (getBodySite().isEmpty()) {
        addBodySite();
      }
      return getBodySite().get(0);
    }

    /**
     * @return {@link #subject} (Indicates the patient or group who the condition record is associated with.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Condition.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (Indicates the patient or group who the condition record is associated with.)
     */
    public Condition setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The Encounter during which this Condition was created or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Condition.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The Encounter during which this Condition was created or to which the creation of this record is tightly associated.)
     */
    public Condition setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #onset} (Estimated or actual date or date-time  the condition began, in the opinion of the clinician.)
     */
    public DataType getOnset() { 
      return this.onset;
    }

    /**
     * @return {@link #onset} (Estimated or actual date or date-time  the condition began, in the opinion of the clinician.)
     */
    public DateTimeType getOnsetDateTimeType() throws FHIRException { 
      if (this.onset == null)
        this.onset = new DateTimeType();
      if (!(this.onset instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.onset.getClass().getName()+" was encountered");
      return (DateTimeType) this.onset;
    }

    public boolean hasOnsetDateTimeType() { 
      return this != null && this.onset instanceof DateTimeType;
    }

    /**
     * @return {@link #onset} (Estimated or actual date or date-time  the condition began, in the opinion of the clinician.)
     */
    public Age getOnsetAge() throws FHIRException { 
      if (this.onset == null)
        this.onset = new Age();
      if (!(this.onset instanceof Age))
        throw new FHIRException("Type mismatch: the type Age was expected, but "+this.onset.getClass().getName()+" was encountered");
      return (Age) this.onset;
    }

    public boolean hasOnsetAge() { 
      return this != null && this.onset instanceof Age;
    }

    /**
     * @return {@link #onset} (Estimated or actual date or date-time  the condition began, in the opinion of the clinician.)
     */
    public Period getOnsetPeriod() throws FHIRException { 
      if (this.onset == null)
        this.onset = new Period();
      if (!(this.onset instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.onset.getClass().getName()+" was encountered");
      return (Period) this.onset;
    }

    public boolean hasOnsetPeriod() { 
      return this != null && this.onset instanceof Period;
    }

    /**
     * @return {@link #onset} (Estimated or actual date or date-time  the condition began, in the opinion of the clinician.)
     */
    public Range getOnsetRange() throws FHIRException { 
      if (this.onset == null)
        this.onset = new Range();
      if (!(this.onset instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.onset.getClass().getName()+" was encountered");
      return (Range) this.onset;
    }

    public boolean hasOnsetRange() { 
      return this != null && this.onset instanceof Range;
    }

    /**
     * @return {@link #onset} (Estimated or actual date or date-time  the condition began, in the opinion of the clinician.)
     */
    public StringType getOnsetStringType() throws FHIRException { 
      if (this.onset == null)
        this.onset = new StringType();
      if (!(this.onset instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.onset.getClass().getName()+" was encountered");
      return (StringType) this.onset;
    }

    public boolean hasOnsetStringType() { 
      return this != null && this.onset instanceof StringType;
    }

    public boolean hasOnset() { 
      return this.onset != null && !this.onset.isEmpty();
    }

    /**
     * @param value {@link #onset} (Estimated or actual date or date-time  the condition began, in the opinion of the clinician.)
     */
    public Condition setOnset(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Age || value instanceof Period || value instanceof Range || value instanceof StringType))
        throw new FHIRException("Not the right type for Condition.onset[x]: "+value.fhirType());
      this.onset = value;
      return this;
    }

    /**
     * @return {@link #abatement} (The date or estimated date that the condition resolved or went into remission. This is called "abatement" because of the many overloaded connotations associated with "remission" or "resolution" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.)
     */
    public DataType getAbatement() { 
      return this.abatement;
    }

    /**
     * @return {@link #abatement} (The date or estimated date that the condition resolved or went into remission. This is called "abatement" because of the many overloaded connotations associated with "remission" or "resolution" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.)
     */
    public DateTimeType getAbatementDateTimeType() throws FHIRException { 
      if (this.abatement == null)
        this.abatement = new DateTimeType();
      if (!(this.abatement instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.abatement.getClass().getName()+" was encountered");
      return (DateTimeType) this.abatement;
    }

    public boolean hasAbatementDateTimeType() { 
      return this != null && this.abatement instanceof DateTimeType;
    }

    /**
     * @return {@link #abatement} (The date or estimated date that the condition resolved or went into remission. This is called "abatement" because of the many overloaded connotations associated with "remission" or "resolution" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.)
     */
    public Age getAbatementAge() throws FHIRException { 
      if (this.abatement == null)
        this.abatement = new Age();
      if (!(this.abatement instanceof Age))
        throw new FHIRException("Type mismatch: the type Age was expected, but "+this.abatement.getClass().getName()+" was encountered");
      return (Age) this.abatement;
    }

    public boolean hasAbatementAge() { 
      return this != null && this.abatement instanceof Age;
    }

    /**
     * @return {@link #abatement} (The date or estimated date that the condition resolved or went into remission. This is called "abatement" because of the many overloaded connotations associated with "remission" or "resolution" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.)
     */
    public Period getAbatementPeriod() throws FHIRException { 
      if (this.abatement == null)
        this.abatement = new Period();
      if (!(this.abatement instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.abatement.getClass().getName()+" was encountered");
      return (Period) this.abatement;
    }

    public boolean hasAbatementPeriod() { 
      return this != null && this.abatement instanceof Period;
    }

    /**
     * @return {@link #abatement} (The date or estimated date that the condition resolved or went into remission. This is called "abatement" because of the many overloaded connotations associated with "remission" or "resolution" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.)
     */
    public Range getAbatementRange() throws FHIRException { 
      if (this.abatement == null)
        this.abatement = new Range();
      if (!(this.abatement instanceof Range))
        throw new FHIRException("Type mismatch: the type Range was expected, but "+this.abatement.getClass().getName()+" was encountered");
      return (Range) this.abatement;
    }

    public boolean hasAbatementRange() { 
      return this != null && this.abatement instanceof Range;
    }

    /**
     * @return {@link #abatement} (The date or estimated date that the condition resolved or went into remission. This is called "abatement" because of the many overloaded connotations associated with "remission" or "resolution" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.)
     */
    public StringType getAbatementStringType() throws FHIRException { 
      if (this.abatement == null)
        this.abatement = new StringType();
      if (!(this.abatement instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.abatement.getClass().getName()+" was encountered");
      return (StringType) this.abatement;
    }

    public boolean hasAbatementStringType() { 
      return this != null && this.abatement instanceof StringType;
    }

    public boolean hasAbatement() { 
      return this.abatement != null && !this.abatement.isEmpty();
    }

    /**
     * @param value {@link #abatement} (The date or estimated date that the condition resolved or went into remission. This is called "abatement" because of the many overloaded connotations associated with "remission" or "resolution" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.)
     */
    public Condition setAbatement(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Age || value instanceof Period || value instanceof Range || value instanceof StringType))
        throw new FHIRException("Not the right type for Condition.abatement[x]: "+value.fhirType());
      this.abatement = value;
      return this;
    }

    /**
     * @return {@link #recordedDate} (The recordedDate represents when this particular Condition record was created in the system, which is often a system-generated date.). This is the underlying object with id, value and extensions. The accessor "getRecordedDate" gives direct access to the value
     */
    public DateTimeType getRecordedDateElement() { 
      if (this.recordedDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Condition.recordedDate");
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
     * @param value {@link #recordedDate} (The recordedDate represents when this particular Condition record was created in the system, which is often a system-generated date.). This is the underlying object with id, value and extensions. The accessor "getRecordedDate" gives direct access to the value
     */
    public Condition setRecordedDateElement(DateTimeType value) { 
      this.recordedDate = value;
      return this;
    }

    /**
     * @return The recordedDate represents when this particular Condition record was created in the system, which is often a system-generated date.
     */
    public Date getRecordedDate() { 
      return this.recordedDate == null ? null : this.recordedDate.getValue();
    }

    /**
     * @param value The recordedDate represents when this particular Condition record was created in the system, which is often a system-generated date.
     */
    public Condition setRecordedDate(Date value) { 
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
     * @return {@link #participant} (Indicates who or what participated in the activities related to the condition and how they were involved.)
     */
    public List<ConditionParticipantComponent> getParticipant() { 
      if (this.participant == null)
        this.participant = new ArrayList<ConditionParticipantComponent>();
      return this.participant;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Condition setParticipant(List<ConditionParticipantComponent> theParticipant) { 
      this.participant = theParticipant;
      return this;
    }

    public boolean hasParticipant() { 
      if (this.participant == null)
        return false;
      for (ConditionParticipantComponent item : this.participant)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ConditionParticipantComponent addParticipant() { //3
      ConditionParticipantComponent t = new ConditionParticipantComponent();
      if (this.participant == null)
        this.participant = new ArrayList<ConditionParticipantComponent>();
      this.participant.add(t);
      return t;
    }

    public Condition addParticipant(ConditionParticipantComponent t) { //3
      if (t == null)
        return this;
      if (this.participant == null)
        this.participant = new ArrayList<ConditionParticipantComponent>();
      this.participant.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
     */
    public ConditionParticipantComponent getParticipantFirstRep() { 
      if (getParticipant().isEmpty()) {
        addParticipant();
      }
      return getParticipant().get(0);
    }

    /**
     * @return {@link #stage} (A simple summary of the stage such as "Stage 3" or "Early Onset". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease.)
     */
    public List<ConditionStageComponent> getStage() { 
      if (this.stage == null)
        this.stage = new ArrayList<ConditionStageComponent>();
      return this.stage;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Condition setStage(List<ConditionStageComponent> theStage) { 
      this.stage = theStage;
      return this;
    }

    public boolean hasStage() { 
      if (this.stage == null)
        return false;
      for (ConditionStageComponent item : this.stage)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ConditionStageComponent addStage() { //3
      ConditionStageComponent t = new ConditionStageComponent();
      if (this.stage == null)
        this.stage = new ArrayList<ConditionStageComponent>();
      this.stage.add(t);
      return t;
    }

    public Condition addStage(ConditionStageComponent t) { //3
      if (t == null)
        return this;
      if (this.stage == null)
        this.stage = new ArrayList<ConditionStageComponent>();
      this.stage.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #stage}, creating it if it does not already exist {3}
     */
    public ConditionStageComponent getStageFirstRep() { 
      if (getStage().isEmpty()) {
        addStage();
      }
      return getStage().get(0);
    }

    /**
     * @return {@link #evidence} (Supporting evidence / manifestations that are the basis of the Condition's verification status, such as evidence that confirmed or refuted the condition.)
     */
    public List<CodeableReference> getEvidence() { 
      if (this.evidence == null)
        this.evidence = new ArrayList<CodeableReference>();
      return this.evidence;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Condition setEvidence(List<CodeableReference> theEvidence) { 
      this.evidence = theEvidence;
      return this;
    }

    public boolean hasEvidence() { 
      if (this.evidence == null)
        return false;
      for (CodeableReference item : this.evidence)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addEvidence() { //3
      CodeableReference t = new CodeableReference();
      if (this.evidence == null)
        this.evidence = new ArrayList<CodeableReference>();
      this.evidence.add(t);
      return t;
    }

    public Condition addEvidence(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.evidence == null)
        this.evidence = new ArrayList<CodeableReference>();
      this.evidence.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #evidence}, creating it if it does not already exist {3}
     */
    public CodeableReference getEvidenceFirstRep() { 
      if (getEvidence().isEmpty()) {
        addEvidence();
      }
      return getEvidence().get(0);
    }

    /**
     * @return {@link #note} (Additional information about the Condition. This is a general notes/comments entry  for description of the Condition, its diagnosis and prognosis.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Condition setNote(List<Annotation> theNote) { 
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

    public Condition addNote(Annotation t) { //3
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
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this condition by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("clinicalStatus", "CodeableConcept", "The clinical status of the condition.", 0, 1, clinicalStatus));
        children.add(new Property("verificationStatus", "CodeableConcept", "The verification status to support the clinical status of the condition.  The verification status pertains to the condition, itself, not to any specific condition attribute.", 0, 1, verificationStatus));
        children.add(new Property("category", "CodeableConcept", "A category assigned to the condition.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("severity", "CodeableConcept", "A subjective assessment of the severity of the condition as evaluated by the clinician.", 0, 1, severity));
        children.add(new Property("code", "CodeableConcept", "Identification of the condition, problem or diagnosis.", 0, 1, code));
        children.add(new Property("bodySite", "CodeableConcept", "The anatomical location where this condition manifests itself.", 0, java.lang.Integer.MAX_VALUE, bodySite));
        children.add(new Property("subject", "Reference(Patient|Group)", "Indicates the patient or group who the condition record is associated with.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The Encounter during which this Condition was created or to which the creation of this record is tightly associated.", 0, 1, encounter));
        children.add(new Property("onset[x]", "dateTime|Age|Period|Range|string", "Estimated or actual date or date-time  the condition began, in the opinion of the clinician.", 0, 1, onset));
        children.add(new Property("abatement[x]", "dateTime|Age|Period|Range|string", "The date or estimated date that the condition resolved or went into remission. This is called \"abatement\" because of the many overloaded connotations associated with \"remission\" or \"resolution\" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.", 0, 1, abatement));
        children.add(new Property("recordedDate", "dateTime", "The recordedDate represents when this particular Condition record was created in the system, which is often a system-generated date.", 0, 1, recordedDate));
        children.add(new Property("participant", "", "Indicates who or what participated in the activities related to the condition and how they were involved.", 0, java.lang.Integer.MAX_VALUE, participant));
        children.add(new Property("stage", "", "A simple summary of the stage such as \"Stage 3\" or \"Early Onset\". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease.", 0, java.lang.Integer.MAX_VALUE, stage));
        children.add(new Property("evidence", "CodeableReference(Any)", "Supporting evidence / manifestations that are the basis of the Condition's verification status, such as evidence that confirmed or refuted the condition.", 0, java.lang.Integer.MAX_VALUE, evidence));
        children.add(new Property("note", "Annotation", "Additional information about the Condition. This is a general notes/comments entry  for description of the Condition, its diagnosis and prognosis.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this condition by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -462853915: /*clinicalStatus*/  return new Property("clinicalStatus", "CodeableConcept", "The clinical status of the condition.", 0, 1, clinicalStatus);
        case -842509843: /*verificationStatus*/  return new Property("verificationStatus", "CodeableConcept", "The verification status to support the clinical status of the condition.  The verification status pertains to the condition, itself, not to any specific condition attribute.", 0, 1, verificationStatus);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A category assigned to the condition.", 0, java.lang.Integer.MAX_VALUE, category);
        case 1478300413: /*severity*/  return new Property("severity", "CodeableConcept", "A subjective assessment of the severity of the condition as evaluated by the clinician.", 0, 1, severity);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Identification of the condition, problem or diagnosis.", 0, 1, code);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableConcept", "The anatomical location where this condition manifests itself.", 0, java.lang.Integer.MAX_VALUE, bodySite);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "Indicates the patient or group who the condition record is associated with.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The Encounter during which this Condition was created or to which the creation of this record is tightly associated.", 0, 1, encounter);
        case -1886216323: /*onset[x]*/  return new Property("onset[x]", "dateTime|Age|Period|Range|string", "Estimated or actual date or date-time  the condition began, in the opinion of the clinician.", 0, 1, onset);
        case 105901603: /*onset*/  return new Property("onset[x]", "dateTime|Age|Period|Range|string", "Estimated or actual date or date-time  the condition began, in the opinion of the clinician.", 0, 1, onset);
        case -1701663010: /*onsetDateTime*/  return new Property("onset[x]", "dateTime", "Estimated or actual date or date-time  the condition began, in the opinion of the clinician.", 0, 1, onset);
        case -1886241828: /*onsetAge*/  return new Property("onset[x]", "Age", "Estimated or actual date or date-time  the condition began, in the opinion of the clinician.", 0, 1, onset);
        case -1545082428: /*onsetPeriod*/  return new Property("onset[x]", "Period", "Estimated or actual date or date-time  the condition began, in the opinion of the clinician.", 0, 1, onset);
        case -186664742: /*onsetRange*/  return new Property("onset[x]", "Range", "Estimated or actual date or date-time  the condition began, in the opinion of the clinician.", 0, 1, onset);
        case -1445342188: /*onsetString*/  return new Property("onset[x]", "string", "Estimated or actual date or date-time  the condition began, in the opinion of the clinician.", 0, 1, onset);
        case -584196495: /*abatement[x]*/  return new Property("abatement[x]", "dateTime|Age|Period|Range|string", "The date or estimated date that the condition resolved or went into remission. This is called \"abatement\" because of the many overloaded connotations associated with \"remission\" or \"resolution\" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.", 0, 1, abatement);
        case -921554001: /*abatement*/  return new Property("abatement[x]", "dateTime|Age|Period|Range|string", "The date or estimated date that the condition resolved or went into remission. This is called \"abatement\" because of the many overloaded connotations associated with \"remission\" or \"resolution\" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.", 0, 1, abatement);
        case 44869738: /*abatementDateTime*/  return new Property("abatement[x]", "dateTime", "The date or estimated date that the condition resolved or went into remission. This is called \"abatement\" because of the many overloaded connotations associated with \"remission\" or \"resolution\" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.", 0, 1, abatement);
        case -584222000: /*abatementAge*/  return new Property("abatement[x]", "Age", "The date or estimated date that the condition resolved or went into remission. This is called \"abatement\" because of the many overloaded connotations associated with \"remission\" or \"resolution\" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.", 0, 1, abatement);
        case -922036656: /*abatementPeriod*/  return new Property("abatement[x]", "Period", "The date or estimated date that the condition resolved or went into remission. This is called \"abatement\" because of the many overloaded connotations associated with \"remission\" or \"resolution\" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.", 0, 1, abatement);
        case 1218906830: /*abatementRange*/  return new Property("abatement[x]", "Range", "The date or estimated date that the condition resolved or went into remission. This is called \"abatement\" because of the many overloaded connotations associated with \"remission\" or \"resolution\" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.", 0, 1, abatement);
        case -822296416: /*abatementString*/  return new Property("abatement[x]", "string", "The date or estimated date that the condition resolved or went into remission. This is called \"abatement\" because of the many overloaded connotations associated with \"remission\" or \"resolution\" - Some conditions, such as chronic conditions, are never really resolved, but they can abate.", 0, 1, abatement);
        case -1952893826: /*recordedDate*/  return new Property("recordedDate", "dateTime", "The recordedDate represents when this particular Condition record was created in the system, which is often a system-generated date.", 0, 1, recordedDate);
        case 767422259: /*participant*/  return new Property("participant", "", "Indicates who or what participated in the activities related to the condition and how they were involved.", 0, java.lang.Integer.MAX_VALUE, participant);
        case 109757182: /*stage*/  return new Property("stage", "", "A simple summary of the stage such as \"Stage 3\" or \"Early Onset\". The determination of the stage is disease-specific, such as cancer, retinopathy of prematurity, kidney diseases, Alzheimer's, or Parkinson disease.", 0, java.lang.Integer.MAX_VALUE, stage);
        case 382967383: /*evidence*/  return new Property("evidence", "CodeableReference(Any)", "Supporting evidence / manifestations that are the basis of the Condition's verification status, such as evidence that confirmed or refuted the condition.", 0, java.lang.Integer.MAX_VALUE, evidence);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Additional information about the Condition. This is a general notes/comments entry  for description of the Condition, its diagnosis and prognosis.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -462853915: /*clinicalStatus*/ return this.clinicalStatus == null ? new Base[0] : new Base[] {this.clinicalStatus}; // CodeableConcept
        case -842509843: /*verificationStatus*/ return this.verificationStatus == null ? new Base[0] : new Base[] {this.verificationStatus}; // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 1478300413: /*severity*/ return this.severity == null ? new Base[0] : new Base[] {this.severity}; // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : this.bodySite.toArray(new Base[this.bodySite.size()]); // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 105901603: /*onset*/ return this.onset == null ? new Base[0] : new Base[] {this.onset}; // DataType
        case -921554001: /*abatement*/ return this.abatement == null ? new Base[0] : new Base[] {this.abatement}; // DataType
        case -1952893826: /*recordedDate*/ return this.recordedDate == null ? new Base[0] : new Base[] {this.recordedDate}; // DateTimeType
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // ConditionParticipantComponent
        case 109757182: /*stage*/ return this.stage == null ? new Base[0] : this.stage.toArray(new Base[this.stage.size()]); // ConditionStageComponent
        case 382967383: /*evidence*/ return this.evidence == null ? new Base[0] : this.evidence.toArray(new Base[this.evidence.size()]); // CodeableReference
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
        case -462853915: // clinicalStatus
          this.clinicalStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -842509843: // verificationStatus
          this.verificationStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1478300413: // severity
          this.severity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1702620169: // bodySite
          this.getBodySite().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 105901603: // onset
          this.onset = TypeConvertor.castToType(value); // DataType
          return value;
        case -921554001: // abatement
          this.abatement = TypeConvertor.castToType(value); // DataType
          return value;
        case -1952893826: // recordedDate
          this.recordedDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 767422259: // participant
          this.getParticipant().add((ConditionParticipantComponent) value); // ConditionParticipantComponent
          return value;
        case 109757182: // stage
          this.getStage().add((ConditionStageComponent) value); // ConditionStageComponent
          return value;
        case 382967383: // evidence
          this.getEvidence().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
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
        } else if (name.equals("clinicalStatus")) {
          this.clinicalStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("verificationStatus")) {
          this.verificationStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("severity")) {
          this.severity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("bodySite")) {
          this.getBodySite().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("onset[x]")) {
          this.onset = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("abatement[x]")) {
          this.abatement = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("recordedDate")) {
          this.recordedDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("participant")) {
          this.getParticipant().add((ConditionParticipantComponent) value);
        } else if (name.equals("stage")) {
          this.getStage().add((ConditionStageComponent) value);
        } else if (name.equals("evidence")) {
          this.getEvidence().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("clinicalStatus")) {
          this.clinicalStatus = null;
        } else if (name.equals("verificationStatus")) {
          this.verificationStatus = null;
        } else if (name.equals("category")) {
          this.getCategory().remove(value);
        } else if (name.equals("severity")) {
          this.severity = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("bodySite")) {
          this.getBodySite().remove(value);
        } else if (name.equals("subject")) {
          this.subject = null;
        } else if (name.equals("encounter")) {
          this.encounter = null;
        } else if (name.equals("onset[x]")) {
          this.onset = null;
        } else if (name.equals("abatement[x]")) {
          this.abatement = null;
        } else if (name.equals("recordedDate")) {
          this.recordedDate = null;
        } else if (name.equals("participant")) {
          this.getParticipant().add((ConditionParticipantComponent) value);
        } else if (name.equals("stage")) {
          this.getStage().add((ConditionStageComponent) value);
        } else if (name.equals("evidence")) {
          this.getEvidence().remove(value);
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -462853915:  return getClinicalStatus();
        case -842509843:  return getVerificationStatus();
        case 50511102:  return addCategory(); 
        case 1478300413:  return getSeverity();
        case 3059181:  return getCode();
        case 1702620169:  return addBodySite(); 
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -1886216323:  return getOnset();
        case 105901603:  return getOnset();
        case -584196495:  return getAbatement();
        case -921554001:  return getAbatement();
        case -1952893826:  return getRecordedDateElement();
        case 767422259:  return addParticipant(); 
        case 109757182:  return addStage(); 
        case 382967383:  return addEvidence(); 
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -462853915: /*clinicalStatus*/ return new String[] {"CodeableConcept"};
        case -842509843: /*verificationStatus*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 1478300413: /*severity*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 105901603: /*onset*/ return new String[] {"dateTime", "Age", "Period", "Range", "string"};
        case -921554001: /*abatement*/ return new String[] {"dateTime", "Age", "Period", "Range", "string"};
        case -1952893826: /*recordedDate*/ return new String[] {"dateTime"};
        case 767422259: /*participant*/ return new String[] {};
        case 109757182: /*stage*/ return new String[] {};
        case 382967383: /*evidence*/ return new String[] {"CodeableReference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("clinicalStatus")) {
          this.clinicalStatus = new CodeableConcept();
          return this.clinicalStatus;
        }
        else if (name.equals("verificationStatus")) {
          this.verificationStatus = new CodeableConcept();
          return this.verificationStatus;
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("severity")) {
          this.severity = new CodeableConcept();
          return this.severity;
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("bodySite")) {
          return addBodySite();
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("onsetDateTime")) {
          this.onset = new DateTimeType();
          return this.onset;
        }
        else if (name.equals("onsetAge")) {
          this.onset = new Age();
          return this.onset;
        }
        else if (name.equals("onsetPeriod")) {
          this.onset = new Period();
          return this.onset;
        }
        else if (name.equals("onsetRange")) {
          this.onset = new Range();
          return this.onset;
        }
        else if (name.equals("onsetString")) {
          this.onset = new StringType();
          return this.onset;
        }
        else if (name.equals("abatementDateTime")) {
          this.abatement = new DateTimeType();
          return this.abatement;
        }
        else if (name.equals("abatementAge")) {
          this.abatement = new Age();
          return this.abatement;
        }
        else if (name.equals("abatementPeriod")) {
          this.abatement = new Period();
          return this.abatement;
        }
        else if (name.equals("abatementRange")) {
          this.abatement = new Range();
          return this.abatement;
        }
        else if (name.equals("abatementString")) {
          this.abatement = new StringType();
          return this.abatement;
        }
        else if (name.equals("recordedDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property Condition.recordedDate");
        }
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("stage")) {
          return addStage();
        }
        else if (name.equals("evidence")) {
          return addEvidence();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Condition";

  }

      public Condition copy() {
        Condition dst = new Condition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Condition dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.clinicalStatus = clinicalStatus == null ? null : clinicalStatus.copy();
        dst.verificationStatus = verificationStatus == null ? null : verificationStatus.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.severity = severity == null ? null : severity.copy();
        dst.code = code == null ? null : code.copy();
        if (bodySite != null) {
          dst.bodySite = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : bodySite)
            dst.bodySite.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.onset = onset == null ? null : onset.copy();
        dst.abatement = abatement == null ? null : abatement.copy();
        dst.recordedDate = recordedDate == null ? null : recordedDate.copy();
        if (participant != null) {
          dst.participant = new ArrayList<ConditionParticipantComponent>();
          for (ConditionParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        if (stage != null) {
          dst.stage = new ArrayList<ConditionStageComponent>();
          for (ConditionStageComponent i : stage)
            dst.stage.add(i.copy());
        };
        if (evidence != null) {
          dst.evidence = new ArrayList<CodeableReference>();
          for (CodeableReference i : evidence)
            dst.evidence.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected Condition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Condition))
          return false;
        Condition o = (Condition) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(clinicalStatus, o.clinicalStatus, true)
           && compareDeep(verificationStatus, o.verificationStatus, true) && compareDeep(category, o.category, true)
           && compareDeep(severity, o.severity, true) && compareDeep(code, o.code, true) && compareDeep(bodySite, o.bodySite, true)
           && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true) && compareDeep(onset, o.onset, true)
           && compareDeep(abatement, o.abatement, true) && compareDeep(recordedDate, o.recordedDate, true)
           && compareDeep(participant, o.participant, true) && compareDeep(stage, o.stage, true) && compareDeep(evidence, o.evidence, true)
           && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Condition))
          return false;
        Condition o = (Condition) other_;
        return compareValues(recordedDate, o.recordedDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, clinicalStatus
          , verificationStatus, category, severity, code, bodySite, subject, encounter, onset
          , abatement, recordedDate, participant, stage, evidence, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Condition;
   }

 /**
   * Search parameter: <b>abatement-age</b>
   * <p>
   * Description: <b>Abatement as age or age range</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Condition.abatement.ofType(Age) | Condition.abatement.ofType(Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="abatement-age", path="Condition.abatement.ofType(Age) | Condition.abatement.ofType(Range)", description="Abatement as age or age range", type="quantity" )
  public static final String SP_ABATEMENT_AGE = "abatement-age";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>abatement-age</b>
   * <p>
   * Description: <b>Abatement as age or age range</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Condition.abatement.ofType(Age) | Condition.abatement.ofType(Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam ABATEMENT_AGE = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_ABATEMENT_AGE);

 /**
   * Search parameter: <b>abatement-date</b>
   * <p>
   * Description: <b>Date-related abatements (dateTime and period)</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Condition.abatement.ofType(dateTime) | Condition.abatement.ofType(Period)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="abatement-date", path="Condition.abatement.ofType(dateTime) | Condition.abatement.ofType(Period)", description="Date-related abatements (dateTime and period)", type="date" )
  public static final String SP_ABATEMENT_DATE = "abatement-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>abatement-date</b>
   * <p>
   * Description: <b>Date-related abatements (dateTime and period)</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Condition.abatement.ofType(dateTime) | Condition.abatement.ofType(Period)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam ABATEMENT_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_ABATEMENT_DATE);

 /**
   * Search parameter: <b>abatement-string</b>
   * <p>
   * Description: <b>Abatement as a string</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Condition.abatement.ofType(string)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="abatement-string", path="Condition.abatement.ofType(string)", description="Abatement as a string", type="string" )
  public static final String SP_ABATEMENT_STRING = "abatement-string";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>abatement-string</b>
   * <p>
   * Description: <b>Abatement as a string</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Condition.abatement.ofType(string)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ABATEMENT_STRING = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ABATEMENT_STRING);

 /**
   * Search parameter: <b>body-site</b>
   * <p>
   * Description: <b>Anatomical location, if relevant</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.bodySite</b><br>
   * </p>
   */
  @SearchParamDefinition(name="body-site", path="Condition.bodySite", description="Anatomical location, if relevant", type="token" )
  public static final String SP_BODY_SITE = "body-site";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>body-site</b>
   * <p>
   * Description: <b>Anatomical location, if relevant</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.bodySite</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam BODY_SITE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_BODY_SITE);

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>The category of the condition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="Condition.category", description="The category of the condition", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>The category of the condition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>clinical-status</b>
   * <p>
   * Description: <b>The clinical status of the condition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.clinicalStatus</b><br>
   * </p>
   */
  @SearchParamDefinition(name="clinical-status", path="Condition.clinicalStatus", description="The clinical status of the condition", type="token" )
  public static final String SP_CLINICAL_STATUS = "clinical-status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>clinical-status</b>
   * <p>
   * Description: <b>The clinical status of the condition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.clinicalStatus</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CLINICAL_STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CLINICAL_STATUS);

 /**
   * Search parameter: <b>evidence-detail</b>
   * <p>
   * Description: <b>Supporting information found elsewhere</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Condition.evidence.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="evidence-detail", path="Condition.evidence.reference", description="Supporting information found elsewhere", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_EVIDENCE_DETAIL = "evidence-detail";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>evidence-detail</b>
   * <p>
   * Description: <b>Supporting information found elsewhere</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Condition.evidence.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam EVIDENCE_DETAIL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_EVIDENCE_DETAIL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Condition:evidence-detail</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_EVIDENCE_DETAIL = new ca.uhn.fhir.model.api.Include("Condition:evidence-detail").toLocked();

 /**
   * Search parameter: <b>evidence</b>
   * <p>
   * Description: <b>Manifestation/symptom</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.evidence.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="evidence", path="Condition.evidence.concept", description="Manifestation/symptom", type="token" )
  public static final String SP_EVIDENCE = "evidence";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>evidence</b>
   * <p>
   * Description: <b>Manifestation/symptom</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.evidence.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EVIDENCE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EVIDENCE);

 /**
   * Search parameter: <b>onset-age</b>
   * <p>
   * Description: <b>Onsets as age or age range</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Condition.onset.ofType(Age) | Condition.onset.ofType(Range)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="onset-age", path="Condition.onset.ofType(Age) | Condition.onset.ofType(Range)", description="Onsets as age or age range", type="quantity" )
  public static final String SP_ONSET_AGE = "onset-age";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>onset-age</b>
   * <p>
   * Description: <b>Onsets as age or age range</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Condition.onset.ofType(Age) | Condition.onset.ofType(Range)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam ONSET_AGE = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_ONSET_AGE);

 /**
   * Search parameter: <b>onset-date</b>
   * <p>
   * Description: <b>Date related onsets (dateTime and Period)</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Condition.onset.ofType(dateTime) | Condition.onset.ofType(Period)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="onset-date", path="Condition.onset.ofType(dateTime) | Condition.onset.ofType(Period)", description="Date related onsets (dateTime and Period)", type="date" )
  public static final String SP_ONSET_DATE = "onset-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>onset-date</b>
   * <p>
   * Description: <b>Date related onsets (dateTime and Period)</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Condition.onset.ofType(dateTime) | Condition.onset.ofType(Period)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam ONSET_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_ONSET_DATE);

 /**
   * Search parameter: <b>onset-info</b>
   * <p>
   * Description: <b>Onsets as a string</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Condition.onset.ofType(string)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="onset-info", path="Condition.onset.ofType(string)", description="Onsets as a string", type="string" )
  public static final String SP_ONSET_INFO = "onset-info";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>onset-info</b>
   * <p>
   * Description: <b>Onsets as a string</b><br>
   * Type: <b>string</b><br>
   * Path: <b>Condition.onset.ofType(string)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam ONSET_INFO = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_ONSET_INFO);

 /**
   * Search parameter: <b>participant-actor</b>
   * <p>
   * Description: <b>Who or what participated in the activities related to the condition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Condition.participant.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="participant-actor", path="Condition.participant.actor", description="Who or what participated in the activities related to the condition", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={CareTeam.class, Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PARTICIPANT_ACTOR = "participant-actor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>participant-actor</b>
   * <p>
   * Description: <b>Who or what participated in the activities related to the condition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Condition.participant.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PARTICIPANT_ACTOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PARTICIPANT_ACTOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Condition:participant-actor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PARTICIPANT_ACTOR = new ca.uhn.fhir.model.api.Include("Condition:participant-actor").toLocked();

 /**
   * Search parameter: <b>participant-function</b>
   * <p>
   * Description: <b>Type of involvement of the actor in the activities related to the condition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.participant.function</b><br>
   * </p>
   */
  @SearchParamDefinition(name="participant-function", path="Condition.participant.function", description="Type of involvement of the actor in the activities related to the condition", type="token" )
  public static final String SP_PARTICIPANT_FUNCTION = "participant-function";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>participant-function</b>
   * <p>
   * Description: <b>Type of involvement of the actor in the activities related to the condition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.participant.function</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PARTICIPANT_FUNCTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PARTICIPANT_FUNCTION);

 /**
   * Search parameter: <b>recorded-date</b>
   * <p>
   * Description: <b>Date record was first recorded</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Condition.recordedDate</b><br>
   * </p>
   */
  @SearchParamDefinition(name="recorded-date", path="Condition.recordedDate", description="Date record was first recorded", type="date" )
  public static final String SP_RECORDED_DATE = "recorded-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>recorded-date</b>
   * <p>
   * Description: <b>Date record was first recorded</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Condition.recordedDate</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam RECORDED_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_RECORDED_DATE);

 /**
   * Search parameter: <b>severity</b>
   * <p>
   * Description: <b>The severity of the condition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.severity</b><br>
   * </p>
   */
  @SearchParamDefinition(name="severity", path="Condition.severity", description="The severity of the condition", type="token" )
  public static final String SP_SEVERITY = "severity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>severity</b>
   * <p>
   * Description: <b>The severity of the condition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.severity</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SEVERITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SEVERITY);

 /**
   * Search parameter: <b>stage</b>
   * <p>
   * Description: <b>Simple summary (disease specific)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.stage.summary</b><br>
   * </p>
   */
  @SearchParamDefinition(name="stage", path="Condition.stage.summary", description="Simple summary (disease specific)", type="token" )
  public static final String SP_STAGE = "stage";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>stage</b>
   * <p>
   * Description: <b>Simple summary (disease specific)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.stage.summary</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STAGE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STAGE);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Who has the condition?</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Condition.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="Condition.subject", description="Who has the condition?", type="reference", target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Who has the condition?</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Condition.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Condition:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("Condition:subject").toLocked();

 /**
   * Search parameter: <b>verification-status</b>
   * <p>
   * Description: <b>unconfirmed | provisional | differential | confirmed | refuted | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.verificationStatus</b><br>
   * </p>
   */
  @SearchParamDefinition(name="verification-status", path="Condition.verificationStatus", description="unconfirmed | provisional | differential | confirmed | refuted | entered-in-error", type="token" )
  public static final String SP_VERIFICATION_STATUS = "verification-status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>verification-status</b>
   * <p>
   * Description: <b>unconfirmed | provisional | differential | confirmed | refuted | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Condition.verificationStatus</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERIFICATION_STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERIFICATION_STATUS);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted
* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [AuditEvent](auditevent.html): More specific code for the event
* [Basic](basic.html): Kind of Resource
* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code
* [Condition](condition.html): Code for the condition
* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [ImagingSelection](imagingselection.html): The imaging selection status
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationStatement](medicationstatement.html): Return statements of this medication code
* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [RequestOrchestration](requestorchestration.html): The code of the request orchestration
* [Task](task.html): Search by task code
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code", description="Multiple Resources: \r\n\r\n* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted\r\n* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance\r\n* [AuditEvent](auditevent.html): More specific code for the event\r\n* [Basic](basic.html): Kind of Resource\r\n* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code\r\n* [Condition](condition.html): Code for the condition\r\n* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.\r\n* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered\r\n* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code\r\n* [ImagingSelection](imagingselection.html): The imaging selection status\r\n* [List](list.html): What the purpose of this list is\r\n* [Medication](medication.html): Returns medications for a specific code\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code\r\n* [MedicationStatement](medicationstatement.html): Return statements of this medication code\r\n* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake\r\n* [Observation](observation.html): The code of the observation type\r\n* [Procedure](procedure.html): A code to identify a  procedure\r\n* [RequestOrchestration](requestorchestration.html): The code of the request orchestration\r\n* [Task](task.html): Search by task code\r\n", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted
* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [AuditEvent](auditevent.html): More specific code for the event
* [Basic](basic.html): Kind of Resource
* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code
* [Condition](condition.html): Code for the condition
* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [ImagingSelection](imagingselection.html): The imaging selection status
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationStatement](medicationstatement.html): Return statements of this medication code
* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [RequestOrchestration](requestorchestration.html): The code of the request orchestration
* [Task](task.html): Search by task code
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

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
   * the path value of "<b>Condition:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("Condition:encounter").toLocked();

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
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
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
   * the path value of "<b>Condition:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("Condition:patient").toLocked();


}

