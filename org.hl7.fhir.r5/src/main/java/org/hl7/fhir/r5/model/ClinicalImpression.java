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
 * A record of a clinical assessment performed to determine what problem(s) may affect the patient and before planning the treatments or management strategies that are best to manage a patient's condition. Assessments are often 1:1 with a clinical consultation / encounter,  but this varies greatly depending on the clinical workflow. This resource is called "ClinicalImpression" rather than "ClinicalAssessment" to avoid confusion with the recording of assessment tools such as Apgar score.
 */
@ResourceDef(name="ClinicalImpression", profile="http://hl7.org/fhir/StructureDefinition/ClinicalImpression")
public class ClinicalImpression extends DomainResource {

    @Block()
    public static class ClinicalImpressionFindingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Specific text, code or reference for finding or diagnosis, which may include ruled-out or resolved conditions.
         */
        @Child(name = "item", type = {CodeableReference.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What was found", formalDefinition="Specific text, code or reference for finding or diagnosis, which may include ruled-out or resolved conditions." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
        protected CodeableReference item;

        /**
         * Which investigations support finding or diagnosis.
         */
        @Child(name = "basis", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Which investigations support finding", formalDefinition="Which investigations support finding or diagnosis." )
        protected StringType basis;

        private static final long serialVersionUID = -1363589306L;

    /**
     * Constructor
     */
      public ClinicalImpressionFindingComponent() {
        super();
      }

        /**
         * @return {@link #item} (Specific text, code or reference for finding or diagnosis, which may include ruled-out or resolved conditions.)
         */
        public CodeableReference getItem() { 
          if (this.item == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalImpressionFindingComponent.item");
            else if (Configuration.doAutoCreate())
              this.item = new CodeableReference(); // cc
          return this.item;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (Specific text, code or reference for finding or diagnosis, which may include ruled-out or resolved conditions.)
         */
        public ClinicalImpressionFindingComponent setItem(CodeableReference value) { 
          this.item = value;
          return this;
        }

        /**
         * @return {@link #basis} (Which investigations support finding or diagnosis.). This is the underlying object with id, value and extensions. The accessor "getBasis" gives direct access to the value
         */
        public StringType getBasisElement() { 
          if (this.basis == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ClinicalImpressionFindingComponent.basis");
            else if (Configuration.doAutoCreate())
              this.basis = new StringType(); // bb
          return this.basis;
        }

        public boolean hasBasisElement() { 
          return this.basis != null && !this.basis.isEmpty();
        }

        public boolean hasBasis() { 
          return this.basis != null && !this.basis.isEmpty();
        }

        /**
         * @param value {@link #basis} (Which investigations support finding or diagnosis.). This is the underlying object with id, value and extensions. The accessor "getBasis" gives direct access to the value
         */
        public ClinicalImpressionFindingComponent setBasisElement(StringType value) { 
          this.basis = value;
          return this;
        }

        /**
         * @return Which investigations support finding or diagnosis.
         */
        public String getBasis() { 
          return this.basis == null ? null : this.basis.getValue();
        }

        /**
         * @param value Which investigations support finding or diagnosis.
         */
        public ClinicalImpressionFindingComponent setBasis(String value) { 
          if (Utilities.noString(value))
            this.basis = null;
          else {
            if (this.basis == null)
              this.basis = new StringType();
            this.basis.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item", "CodeableReference(Condition|Observation|DocumentReference)", "Specific text, code or reference for finding or diagnosis, which may include ruled-out or resolved conditions.", 0, 1, item));
          children.add(new Property("basis", "string", "Which investigations support finding or diagnosis.", 0, 1, basis));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3242771: /*item*/  return new Property("item", "CodeableReference(Condition|Observation|DocumentReference)", "Specific text, code or reference for finding or diagnosis, which may include ruled-out or resolved conditions.", 0, 1, item);
          case 93508670: /*basis*/  return new Property("basis", "string", "Which investigations support finding or diagnosis.", 0, 1, basis);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // CodeableReference
        case 93508670: /*basis*/ return this.basis == null ? new Base[0] : new Base[] {this.basis}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 93508670: // basis
          this.basis = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item")) {
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("basis")) {
          this.basis = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771:  return getItem();
        case 93508670:  return getBasisElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"CodeableReference"};
        case 93508670: /*basis*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("item")) {
          this.item = new CodeableReference();
          return this.item;
        }
        else if (name.equals("basis")) {
          throw new FHIRException("Cannot call addChild on a primitive type ClinicalImpression.finding.basis");
        }
        else
          return super.addChild(name);
      }

      public ClinicalImpressionFindingComponent copy() {
        ClinicalImpressionFindingComponent dst = new ClinicalImpressionFindingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalImpressionFindingComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
        dst.basis = basis == null ? null : basis.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalImpressionFindingComponent))
          return false;
        ClinicalImpressionFindingComponent o = (ClinicalImpressionFindingComponent) other_;
        return compareDeep(item, o.item, true) && compareDeep(basis, o.basis, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalImpressionFindingComponent))
          return false;
        ClinicalImpressionFindingComponent o = (ClinicalImpressionFindingComponent) other_;
        return compareValues(basis, o.basis, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item, basis);
      }

  public String fhirType() {
    return "ClinicalImpression.finding";

  }

  }

    /**
     * Business identifiers assigned to this clinical impression by the performer or other systems which remain constant as the resource is updated and propagates from server to server.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier", formalDefinition="Business identifiers assigned to this clinical impression by the performer or other systems which remain constant as the resource is updated and propagates from server to server." )
    protected List<Identifier> identifier;

    /**
     * Identifies the workflow status of the assessment.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown", formalDefinition="Identifies the workflow status of the assessment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/event-status")
    protected Enumeration<EventStatus> status;

    /**
     * Captures the reason for the current state of the ClinicalImpression.
     */
    @Child(name = "statusReason", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reason for current status", formalDefinition="Captures the reason for the current state of the ClinicalImpression." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinicalimpression-status-reason")
    protected CodeableConcept statusReason;

    /**
     * A summary of the context and/or cause of the assessment - why / where it was performed, and what patient events/status prompted it.
     */
    @Child(name = "description", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Why/how the assessment was performed", formalDefinition="A summary of the context and/or cause of the assessment - why / where it was performed, and what patient events/status prompted it." )
    protected StringType description;

    /**
     * The patient or group of individuals assessed as part of this record.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Patient or group assessed", formalDefinition="The patient or group of individuals assessed as part of this record." )
    protected Reference subject;

    /**
     * The Encounter during which this ClinicalImpression was created or to which the creation of this record is tightly associated.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The Encounter during which this ClinicalImpression was created", formalDefinition="The Encounter during which this ClinicalImpression was created or to which the creation of this record is tightly associated." )
    protected Reference encounter;

    /**
     * The point in time or period over which the subject was assessed.
     */
    @Child(name = "effective", type = {DateTimeType.class, Period.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Time of assessment", formalDefinition="The point in time or period over which the subject was assessed." )
    protected DataType effective;

    /**
     * Indicates when the documentation of the assessment was complete.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the assessment was documented", formalDefinition="Indicates when the documentation of the assessment was complete." )
    protected DateTimeType date;

    /**
     * The clinician performing the assessment.
     */
    @Child(name = "performer", type = {Practitioner.class, PractitionerRole.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The clinician performing the assessment", formalDefinition="The clinician performing the assessment." )
    protected Reference performer;

    /**
     * A reference to the last assessment that was conducted on this patient. Assessments are often/usually ongoing in nature; a care provider (practitioner or team) will make new assessments on an ongoing basis as new data arises or the patient's conditions changes.
     */
    @Child(name = "previous", type = {ClinicalImpression.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to last assessment", formalDefinition="A reference to the last assessment that was conducted on this patient. Assessments are often/usually ongoing in nature; a care provider (practitioner or team) will make new assessments on an ongoing basis as new data arises or the patient's conditions changes." )
    protected Reference previous;

    /**
     * A list of the relevant problems/conditions for a patient.
     */
    @Child(name = "problem", type = {Condition.class, AllergyIntolerance.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Relevant impressions of patient state", formalDefinition="A list of the relevant problems/conditions for a patient." )
    protected List<Reference> problem;

    /**
     * Change in the status/pattern of a subject's condition since previously assessed, such as worsening, improving, or no change.  It is a subjective assessment of the direction of the change.
     */
    @Child(name = "changePattern", type = {CodeableConcept.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Change in the status/pattern of a subject's condition since previously assessed, such as worsening, improving, or no change", formalDefinition="Change in the status/pattern of a subject's condition since previously assessed, such as worsening, improving, or no change.  It is a subjective assessment of the direction of the change." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinicalimpression-change-pattern")
    protected CodeableConcept changePattern;

    /**
     * Reference to a specific published clinical protocol that was followed during this assessment, and/or that provides evidence in support of the diagnosis.
     */
    @Child(name = "protocol", type = {UriType.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Clinical Protocol followed", formalDefinition="Reference to a specific published clinical protocol that was followed during this assessment, and/or that provides evidence in support of the diagnosis." )
    protected List<UriType> protocol;

    /**
     * A text summary of the investigations and the diagnosis.
     */
    @Child(name = "summary", type = {StringType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Summary of the assessment", formalDefinition="A text summary of the investigations and the diagnosis." )
    protected StringType summary;

    /**
     * Specific findings or diagnoses that were considered likely or relevant to ongoing treatment.
     */
    @Child(name = "finding", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Possible or likely findings and diagnoses", formalDefinition="Specific findings or diagnoses that were considered likely or relevant to ongoing treatment." )
    protected List<ClinicalImpressionFindingComponent> finding;

    /**
     * Estimate of likely outcome.
     */
    @Child(name = "prognosisCodeableConcept", type = {CodeableConcept.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Estimate of likely outcome", formalDefinition="Estimate of likely outcome." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinicalimpression-prognosis")
    protected List<CodeableConcept> prognosisCodeableConcept;

    /**
     * RiskAssessment expressing likely outcome.
     */
    @Child(name = "prognosisReference", type = {RiskAssessment.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="RiskAssessment expressing likely outcome", formalDefinition="RiskAssessment expressing likely outcome." )
    protected List<Reference> prognosisReference;

    /**
     * Information supporting the clinical impression, which can contain investigation results.
     */
    @Child(name = "supportingInfo", type = {Reference.class}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Information supporting the clinical impression", formalDefinition="Information supporting the clinical impression, which can contain investigation results." )
    protected List<Reference> supportingInfo;

    /**
     * Commentary about the impression, typically recorded after the impression itself was made, though supplemental notes by the original author could also appear.
     */
    @Child(name = "note", type = {Annotation.class}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments made about the ClinicalImpression", formalDefinition="Commentary about the impression, typically recorded after the impression itself was made, though supplemental notes by the original author could also appear." )
    protected List<Annotation> note;

    private static final long serialVersionUID = -1360437701L;

  /**
   * Constructor
   */
    public ClinicalImpression() {
      super();
    }

  /**
   * Constructor
   */
    public ClinicalImpression(EventStatus status, Reference subject) {
      super();
      this.setStatus(status);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Business identifiers assigned to this clinical impression by the performer or other systems which remain constant as the resource is updated and propagates from server to server.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalImpression setIdentifier(List<Identifier> theIdentifier) { 
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

    public ClinicalImpression addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (Identifies the workflow status of the assessment.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EventStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<EventStatus>(new EventStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Identifies the workflow status of the assessment.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ClinicalImpression setStatusElement(Enumeration<EventStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Identifies the workflow status of the assessment.
     */
    public EventStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Identifies the workflow status of the assessment.
     */
    public ClinicalImpression setStatus(EventStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<EventStatus>(new EventStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #statusReason} (Captures the reason for the current state of the ClinicalImpression.)
     */
    public CodeableConcept getStatusReason() { 
      if (this.statusReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.statusReason");
        else if (Configuration.doAutoCreate())
          this.statusReason = new CodeableConcept(); // cc
      return this.statusReason;
    }

    public boolean hasStatusReason() { 
      return this.statusReason != null && !this.statusReason.isEmpty();
    }

    /**
     * @param value {@link #statusReason} (Captures the reason for the current state of the ClinicalImpression.)
     */
    public ClinicalImpression setStatusReason(CodeableConcept value) { 
      this.statusReason = value;
      return this;
    }

    /**
     * @return {@link #description} (A summary of the context and/or cause of the assessment - why / where it was performed, and what patient events/status prompted it.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.description");
        else if (Configuration.doAutoCreate())
          this.description = new StringType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (A summary of the context and/or cause of the assessment - why / where it was performed, and what patient events/status prompted it.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ClinicalImpression setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A summary of the context and/or cause of the assessment - why / where it was performed, and what patient events/status prompted it.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A summary of the context and/or cause of the assessment - why / where it was performed, and what patient events/status prompted it.
     */
    public ClinicalImpression setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new StringType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #subject} (The patient or group of individuals assessed as part of this record.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The patient or group of individuals assessed as part of this record.)
     */
    public ClinicalImpression setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (The Encounter during which this ClinicalImpression was created or to which the creation of this record is tightly associated.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (The Encounter during which this ClinicalImpression was created or to which the creation of this record is tightly associated.)
     */
    public ClinicalImpression setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #effective} (The point in time or period over which the subject was assessed.)
     */
    public DataType getEffective() { 
      return this.effective;
    }

    /**
     * @return {@link #effective} (The point in time or period over which the subject was assessed.)
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
     * @return {@link #effective} (The point in time or period over which the subject was assessed.)
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
     * @param value {@link #effective} (The point in time or period over which the subject was assessed.)
     */
    public ClinicalImpression setEffective(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period))
        throw new FHIRException("Not the right type for ClinicalImpression.effective[x]: "+value.fhirType());
      this.effective = value;
      return this;
    }

    /**
     * @return {@link #date} (Indicates when the documentation of the assessment was complete.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateTimeType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (Indicates when the documentation of the assessment was complete.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ClinicalImpression setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return Indicates when the documentation of the assessment was complete.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value Indicates when the documentation of the assessment was complete.
     */
    public ClinicalImpression setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #performer} (The clinician performing the assessment.)
     */
    public Reference getPerformer() { 
      if (this.performer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.performer");
        else if (Configuration.doAutoCreate())
          this.performer = new Reference(); // cc
      return this.performer;
    }

    public boolean hasPerformer() { 
      return this.performer != null && !this.performer.isEmpty();
    }

    /**
     * @param value {@link #performer} (The clinician performing the assessment.)
     */
    public ClinicalImpression setPerformer(Reference value) { 
      this.performer = value;
      return this;
    }

    /**
     * @return {@link #previous} (A reference to the last assessment that was conducted on this patient. Assessments are often/usually ongoing in nature; a care provider (practitioner or team) will make new assessments on an ongoing basis as new data arises or the patient's conditions changes.)
     */
    public Reference getPrevious() { 
      if (this.previous == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.previous");
        else if (Configuration.doAutoCreate())
          this.previous = new Reference(); // cc
      return this.previous;
    }

    public boolean hasPrevious() { 
      return this.previous != null && !this.previous.isEmpty();
    }

    /**
     * @param value {@link #previous} (A reference to the last assessment that was conducted on this patient. Assessments are often/usually ongoing in nature; a care provider (practitioner or team) will make new assessments on an ongoing basis as new data arises or the patient's conditions changes.)
     */
    public ClinicalImpression setPrevious(Reference value) { 
      this.previous = value;
      return this;
    }

    /**
     * @return {@link #problem} (A list of the relevant problems/conditions for a patient.)
     */
    public List<Reference> getProblem() { 
      if (this.problem == null)
        this.problem = new ArrayList<Reference>();
      return this.problem;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalImpression setProblem(List<Reference> theProblem) { 
      this.problem = theProblem;
      return this;
    }

    public boolean hasProblem() { 
      if (this.problem == null)
        return false;
      for (Reference item : this.problem)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addProblem() { //3
      Reference t = new Reference();
      if (this.problem == null)
        this.problem = new ArrayList<Reference>();
      this.problem.add(t);
      return t;
    }

    public ClinicalImpression addProblem(Reference t) { //3
      if (t == null)
        return this;
      if (this.problem == null)
        this.problem = new ArrayList<Reference>();
      this.problem.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #problem}, creating it if it does not already exist {3}
     */
    public Reference getProblemFirstRep() { 
      if (getProblem().isEmpty()) {
        addProblem();
      }
      return getProblem().get(0);
    }

    /**
     * @return {@link #changePattern} (Change in the status/pattern of a subject's condition since previously assessed, such as worsening, improving, or no change.  It is a subjective assessment of the direction of the change.)
     */
    public CodeableConcept getChangePattern() { 
      if (this.changePattern == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.changePattern");
        else if (Configuration.doAutoCreate())
          this.changePattern = new CodeableConcept(); // cc
      return this.changePattern;
    }

    public boolean hasChangePattern() { 
      return this.changePattern != null && !this.changePattern.isEmpty();
    }

    /**
     * @param value {@link #changePattern} (Change in the status/pattern of a subject's condition since previously assessed, such as worsening, improving, or no change.  It is a subjective assessment of the direction of the change.)
     */
    public ClinicalImpression setChangePattern(CodeableConcept value) { 
      this.changePattern = value;
      return this;
    }

    /**
     * @return {@link #protocol} (Reference to a specific published clinical protocol that was followed during this assessment, and/or that provides evidence in support of the diagnosis.)
     */
    public List<UriType> getProtocol() { 
      if (this.protocol == null)
        this.protocol = new ArrayList<UriType>();
      return this.protocol;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalImpression setProtocol(List<UriType> theProtocol) { 
      this.protocol = theProtocol;
      return this;
    }

    public boolean hasProtocol() { 
      if (this.protocol == null)
        return false;
      for (UriType item : this.protocol)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #protocol} (Reference to a specific published clinical protocol that was followed during this assessment, and/or that provides evidence in support of the diagnosis.)
     */
    public UriType addProtocolElement() {//2 
      UriType t = new UriType();
      if (this.protocol == null)
        this.protocol = new ArrayList<UriType>();
      this.protocol.add(t);
      return t;
    }

    /**
     * @param value {@link #protocol} (Reference to a specific published clinical protocol that was followed during this assessment, and/or that provides evidence in support of the diagnosis.)
     */
    public ClinicalImpression addProtocol(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.protocol == null)
        this.protocol = new ArrayList<UriType>();
      this.protocol.add(t);
      return this;
    }

    /**
     * @param value {@link #protocol} (Reference to a specific published clinical protocol that was followed during this assessment, and/or that provides evidence in support of the diagnosis.)
     */
    public boolean hasProtocol(String value) { 
      if (this.protocol == null)
        return false;
      for (UriType v : this.protocol)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #summary} (A text summary of the investigations and the diagnosis.). This is the underlying object with id, value and extensions. The accessor "getSummary" gives direct access to the value
     */
    public StringType getSummaryElement() { 
      if (this.summary == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ClinicalImpression.summary");
        else if (Configuration.doAutoCreate())
          this.summary = new StringType(); // bb
      return this.summary;
    }

    public boolean hasSummaryElement() { 
      return this.summary != null && !this.summary.isEmpty();
    }

    public boolean hasSummary() { 
      return this.summary != null && !this.summary.isEmpty();
    }

    /**
     * @param value {@link #summary} (A text summary of the investigations and the diagnosis.). This is the underlying object with id, value and extensions. The accessor "getSummary" gives direct access to the value
     */
    public ClinicalImpression setSummaryElement(StringType value) { 
      this.summary = value;
      return this;
    }

    /**
     * @return A text summary of the investigations and the diagnosis.
     */
    public String getSummary() { 
      return this.summary == null ? null : this.summary.getValue();
    }

    /**
     * @param value A text summary of the investigations and the diagnosis.
     */
    public ClinicalImpression setSummary(String value) { 
      if (Utilities.noString(value))
        this.summary = null;
      else {
        if (this.summary == null)
          this.summary = new StringType();
        this.summary.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #finding} (Specific findings or diagnoses that were considered likely or relevant to ongoing treatment.)
     */
    public List<ClinicalImpressionFindingComponent> getFinding() { 
      if (this.finding == null)
        this.finding = new ArrayList<ClinicalImpressionFindingComponent>();
      return this.finding;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalImpression setFinding(List<ClinicalImpressionFindingComponent> theFinding) { 
      this.finding = theFinding;
      return this;
    }

    public boolean hasFinding() { 
      if (this.finding == null)
        return false;
      for (ClinicalImpressionFindingComponent item : this.finding)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ClinicalImpressionFindingComponent addFinding() { //3
      ClinicalImpressionFindingComponent t = new ClinicalImpressionFindingComponent();
      if (this.finding == null)
        this.finding = new ArrayList<ClinicalImpressionFindingComponent>();
      this.finding.add(t);
      return t;
    }

    public ClinicalImpression addFinding(ClinicalImpressionFindingComponent t) { //3
      if (t == null)
        return this;
      if (this.finding == null)
        this.finding = new ArrayList<ClinicalImpressionFindingComponent>();
      this.finding.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #finding}, creating it if it does not already exist {3}
     */
    public ClinicalImpressionFindingComponent getFindingFirstRep() { 
      if (getFinding().isEmpty()) {
        addFinding();
      }
      return getFinding().get(0);
    }

    /**
     * @return {@link #prognosisCodeableConcept} (Estimate of likely outcome.)
     */
    public List<CodeableConcept> getPrognosisCodeableConcept() { 
      if (this.prognosisCodeableConcept == null)
        this.prognosisCodeableConcept = new ArrayList<CodeableConcept>();
      return this.prognosisCodeableConcept;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalImpression setPrognosisCodeableConcept(List<CodeableConcept> thePrognosisCodeableConcept) { 
      this.prognosisCodeableConcept = thePrognosisCodeableConcept;
      return this;
    }

    public boolean hasPrognosisCodeableConcept() { 
      if (this.prognosisCodeableConcept == null)
        return false;
      for (CodeableConcept item : this.prognosisCodeableConcept)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addPrognosisCodeableConcept() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.prognosisCodeableConcept == null)
        this.prognosisCodeableConcept = new ArrayList<CodeableConcept>();
      this.prognosisCodeableConcept.add(t);
      return t;
    }

    public ClinicalImpression addPrognosisCodeableConcept(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.prognosisCodeableConcept == null)
        this.prognosisCodeableConcept = new ArrayList<CodeableConcept>();
      this.prognosisCodeableConcept.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #prognosisCodeableConcept}, creating it if it does not already exist {3}
     */
    public CodeableConcept getPrognosisCodeableConceptFirstRep() { 
      if (getPrognosisCodeableConcept().isEmpty()) {
        addPrognosisCodeableConcept();
      }
      return getPrognosisCodeableConcept().get(0);
    }

    /**
     * @return {@link #prognosisReference} (RiskAssessment expressing likely outcome.)
     */
    public List<Reference> getPrognosisReference() { 
      if (this.prognosisReference == null)
        this.prognosisReference = new ArrayList<Reference>();
      return this.prognosisReference;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalImpression setPrognosisReference(List<Reference> thePrognosisReference) { 
      this.prognosisReference = thePrognosisReference;
      return this;
    }

    public boolean hasPrognosisReference() { 
      if (this.prognosisReference == null)
        return false;
      for (Reference item : this.prognosisReference)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addPrognosisReference() { //3
      Reference t = new Reference();
      if (this.prognosisReference == null)
        this.prognosisReference = new ArrayList<Reference>();
      this.prognosisReference.add(t);
      return t;
    }

    public ClinicalImpression addPrognosisReference(Reference t) { //3
      if (t == null)
        return this;
      if (this.prognosisReference == null)
        this.prognosisReference = new ArrayList<Reference>();
      this.prognosisReference.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #prognosisReference}, creating it if it does not already exist {3}
     */
    public Reference getPrognosisReferenceFirstRep() { 
      if (getPrognosisReference().isEmpty()) {
        addPrognosisReference();
      }
      return getPrognosisReference().get(0);
    }

    /**
     * @return {@link #supportingInfo} (Information supporting the clinical impression, which can contain investigation results.)
     */
    public List<Reference> getSupportingInfo() { 
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      return this.supportingInfo;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalImpression setSupportingInfo(List<Reference> theSupportingInfo) { 
      this.supportingInfo = theSupportingInfo;
      return this;
    }

    public boolean hasSupportingInfo() { 
      if (this.supportingInfo == null)
        return false;
      for (Reference item : this.supportingInfo)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupportingInfo() { //3
      Reference t = new Reference();
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      this.supportingInfo.add(t);
      return t;
    }

    public ClinicalImpression addSupportingInfo(Reference t) { //3
      if (t == null)
        return this;
      if (this.supportingInfo == null)
        this.supportingInfo = new ArrayList<Reference>();
      this.supportingInfo.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supportingInfo}, creating it if it does not already exist {3}
     */
    public Reference getSupportingInfoFirstRep() { 
      if (getSupportingInfo().isEmpty()) {
        addSupportingInfo();
      }
      return getSupportingInfo().get(0);
    }

    /**
     * @return {@link #note} (Commentary about the impression, typically recorded after the impression itself was made, though supplemental notes by the original author could also appear.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ClinicalImpression setNote(List<Annotation> theNote) { 
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

    public ClinicalImpression addNote(Annotation t) { //3
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
        children.add(new Property("identifier", "Identifier", "Business identifiers assigned to this clinical impression by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "Identifies the workflow status of the assessment.", 0, 1, status));
        children.add(new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the ClinicalImpression.", 0, 1, statusReason));
        children.add(new Property("description", "string", "A summary of the context and/or cause of the assessment - why / where it was performed, and what patient events/status prompted it.", 0, 1, description));
        children.add(new Property("subject", "Reference(Patient|Group)", "The patient or group of individuals assessed as part of this record.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "The Encounter during which this ClinicalImpression was created or to which the creation of this record is tightly associated.", 0, 1, encounter));
        children.add(new Property("effective[x]", "dateTime|Period", "The point in time or period over which the subject was assessed.", 0, 1, effective));
        children.add(new Property("date", "dateTime", "Indicates when the documentation of the assessment was complete.", 0, 1, date));
        children.add(new Property("performer", "Reference(Practitioner|PractitionerRole)", "The clinician performing the assessment.", 0, 1, performer));
        children.add(new Property("previous", "Reference(ClinicalImpression)", "A reference to the last assessment that was conducted on this patient. Assessments are often/usually ongoing in nature; a care provider (practitioner or team) will make new assessments on an ongoing basis as new data arises or the patient's conditions changes.", 0, 1, previous));
        children.add(new Property("problem", "Reference(Condition|AllergyIntolerance)", "A list of the relevant problems/conditions for a patient.", 0, java.lang.Integer.MAX_VALUE, problem));
        children.add(new Property("changePattern", "CodeableConcept", "Change in the status/pattern of a subject's condition since previously assessed, such as worsening, improving, or no change.  It is a subjective assessment of the direction of the change.", 0, 1, changePattern));
        children.add(new Property("protocol", "uri", "Reference to a specific published clinical protocol that was followed during this assessment, and/or that provides evidence in support of the diagnosis.", 0, java.lang.Integer.MAX_VALUE, protocol));
        children.add(new Property("summary", "string", "A text summary of the investigations and the diagnosis.", 0, 1, summary));
        children.add(new Property("finding", "", "Specific findings or diagnoses that were considered likely or relevant to ongoing treatment.", 0, java.lang.Integer.MAX_VALUE, finding));
        children.add(new Property("prognosisCodeableConcept", "CodeableConcept", "Estimate of likely outcome.", 0, java.lang.Integer.MAX_VALUE, prognosisCodeableConcept));
        children.add(new Property("prognosisReference", "Reference(RiskAssessment)", "RiskAssessment expressing likely outcome.", 0, java.lang.Integer.MAX_VALUE, prognosisReference));
        children.add(new Property("supportingInfo", "Reference(Any)", "Information supporting the clinical impression, which can contain investigation results.", 0, java.lang.Integer.MAX_VALUE, supportingInfo));
        children.add(new Property("note", "Annotation", "Commentary about the impression, typically recorded after the impression itself was made, though supplemental notes by the original author could also appear.", 0, java.lang.Integer.MAX_VALUE, note));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifiers assigned to this clinical impression by the performer or other systems which remain constant as the resource is updated and propagates from server to server.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "Identifies the workflow status of the assessment.", 0, 1, status);
        case 2051346646: /*statusReason*/  return new Property("statusReason", "CodeableConcept", "Captures the reason for the current state of the ClinicalImpression.", 0, 1, statusReason);
        case -1724546052: /*description*/  return new Property("description", "string", "A summary of the context and/or cause of the assessment - why / where it was performed, and what patient events/status prompted it.", 0, 1, description);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The patient or group of individuals assessed as part of this record.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The Encounter during which this ClinicalImpression was created or to which the creation of this record is tightly associated.", 0, 1, encounter);
        case 247104889: /*effective[x]*/  return new Property("effective[x]", "dateTime|Period", "The point in time or period over which the subject was assessed.", 0, 1, effective);
        case -1468651097: /*effective*/  return new Property("effective[x]", "dateTime|Period", "The point in time or period over which the subject was assessed.", 0, 1, effective);
        case -275306910: /*effectiveDateTime*/  return new Property("effective[x]", "dateTime", "The point in time or period over which the subject was assessed.", 0, 1, effective);
        case -403934648: /*effectivePeriod*/  return new Property("effective[x]", "Period", "The point in time or period over which the subject was assessed.", 0, 1, effective);
        case 3076014: /*date*/  return new Property("date", "dateTime", "Indicates when the documentation of the assessment was complete.", 0, 1, date);
        case 481140686: /*performer*/  return new Property("performer", "Reference(Practitioner|PractitionerRole)", "The clinician performing the assessment.", 0, 1, performer);
        case -1273775369: /*previous*/  return new Property("previous", "Reference(ClinicalImpression)", "A reference to the last assessment that was conducted on this patient. Assessments are often/usually ongoing in nature; a care provider (practitioner or team) will make new assessments on an ongoing basis as new data arises or the patient's conditions changes.", 0, 1, previous);
        case -309542241: /*problem*/  return new Property("problem", "Reference(Condition|AllergyIntolerance)", "A list of the relevant problems/conditions for a patient.", 0, java.lang.Integer.MAX_VALUE, problem);
        case -1770133056: /*changePattern*/  return new Property("changePattern", "CodeableConcept", "Change in the status/pattern of a subject's condition since previously assessed, such as worsening, improving, or no change.  It is a subjective assessment of the direction of the change.", 0, 1, changePattern);
        case -989163880: /*protocol*/  return new Property("protocol", "uri", "Reference to a specific published clinical protocol that was followed during this assessment, and/or that provides evidence in support of the diagnosis.", 0, java.lang.Integer.MAX_VALUE, protocol);
        case -1857640538: /*summary*/  return new Property("summary", "string", "A text summary of the investigations and the diagnosis.", 0, 1, summary);
        case -853173367: /*finding*/  return new Property("finding", "", "Specific findings or diagnoses that were considered likely or relevant to ongoing treatment.", 0, java.lang.Integer.MAX_VALUE, finding);
        case -676337953: /*prognosisCodeableConcept*/  return new Property("prognosisCodeableConcept", "CodeableConcept", "Estimate of likely outcome.", 0, java.lang.Integer.MAX_VALUE, prognosisCodeableConcept);
        case -587137783: /*prognosisReference*/  return new Property("prognosisReference", "Reference(RiskAssessment)", "RiskAssessment expressing likely outcome.", 0, java.lang.Integer.MAX_VALUE, prognosisReference);
        case 1922406657: /*supportingInfo*/  return new Property("supportingInfo", "Reference(Any)", "Information supporting the clinical impression, which can contain investigation results.", 0, java.lang.Integer.MAX_VALUE, supportingInfo);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Commentary about the impression, typically recorded after the impression itself was made, though supplemental notes by the original author could also appear.", 0, java.lang.Integer.MAX_VALUE, note);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EventStatus>
        case 2051346646: /*statusReason*/ return this.statusReason == null ? new Base[0] : new Base[] {this.statusReason}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1468651097: /*effective*/ return this.effective == null ? new Base[0] : new Base[] {this.effective}; // DataType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : new Base[] {this.performer}; // Reference
        case -1273775369: /*previous*/ return this.previous == null ? new Base[0] : new Base[] {this.previous}; // Reference
        case -309542241: /*problem*/ return this.problem == null ? new Base[0] : this.problem.toArray(new Base[this.problem.size()]); // Reference
        case -1770133056: /*changePattern*/ return this.changePattern == null ? new Base[0] : new Base[] {this.changePattern}; // CodeableConcept
        case -989163880: /*protocol*/ return this.protocol == null ? new Base[0] : this.protocol.toArray(new Base[this.protocol.size()]); // UriType
        case -1857640538: /*summary*/ return this.summary == null ? new Base[0] : new Base[] {this.summary}; // StringType
        case -853173367: /*finding*/ return this.finding == null ? new Base[0] : this.finding.toArray(new Base[this.finding.size()]); // ClinicalImpressionFindingComponent
        case -676337953: /*prognosisCodeableConcept*/ return this.prognosisCodeableConcept == null ? new Base[0] : this.prognosisCodeableConcept.toArray(new Base[this.prognosisCodeableConcept.size()]); // CodeableConcept
        case -587137783: /*prognosisReference*/ return this.prognosisReference == null ? new Base[0] : this.prognosisReference.toArray(new Base[this.prognosisReference.size()]); // Reference
        case 1922406657: /*supportingInfo*/ return this.supportingInfo == null ? new Base[0] : this.supportingInfo.toArray(new Base[this.supportingInfo.size()]); // Reference
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
        case -892481550: // status
          value = new EventStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EventStatus>
          return value;
        case 2051346646: // statusReason
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
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
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 481140686: // performer
          this.performer = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1273775369: // previous
          this.previous = TypeConvertor.castToReference(value); // Reference
          return value;
        case -309542241: // problem
          this.getProblem().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1770133056: // changePattern
          this.changePattern = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -989163880: // protocol
          this.getProtocol().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -1857640538: // summary
          this.summary = TypeConvertor.castToString(value); // StringType
          return value;
        case -853173367: // finding
          this.getFinding().add((ClinicalImpressionFindingComponent) value); // ClinicalImpressionFindingComponent
          return value;
        case -676337953: // prognosisCodeableConcept
          this.getPrognosisCodeableConcept().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -587137783: // prognosisReference
          this.getPrognosisReference().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1922406657: // supportingInfo
          this.getSupportingInfo().add(TypeConvertor.castToReference(value)); // Reference
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
        } else if (name.equals("status")) {
          value = new EventStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EventStatus>
        } else if (name.equals("statusReason")) {
          this.statusReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("effective[x]")) {
          this.effective = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("performer")) {
          this.performer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("previous")) {
          this.previous = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("problem")) {
          this.getProblem().add(TypeConvertor.castToReference(value));
        } else if (name.equals("changePattern")) {
          this.changePattern = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("protocol")) {
          this.getProtocol().add(TypeConvertor.castToUri(value));
        } else if (name.equals("summary")) {
          this.summary = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("finding")) {
          this.getFinding().add((ClinicalImpressionFindingComponent) value);
        } else if (name.equals("prognosisCodeableConcept")) {
          this.getPrognosisCodeableConcept().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("prognosisReference")) {
          this.getPrognosisReference().add(TypeConvertor.castToReference(value));
        } else if (name.equals("supportingInfo")) {
          this.getSupportingInfo().add(TypeConvertor.castToReference(value));
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
        case -892481550:  return getStatusElement();
        case 2051346646:  return getStatusReason();
        case -1724546052:  return getDescriptionElement();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case 247104889:  return getEffective();
        case -1468651097:  return getEffective();
        case 3076014:  return getDateElement();
        case 481140686:  return getPerformer();
        case -1273775369:  return getPrevious();
        case -309542241:  return addProblem(); 
        case -1770133056:  return getChangePattern();
        case -989163880:  return addProtocolElement();
        case -1857640538:  return getSummaryElement();
        case -853173367:  return addFinding(); 
        case -676337953:  return addPrognosisCodeableConcept(); 
        case -587137783:  return addPrognosisReference(); 
        case 1922406657:  return addSupportingInfo(); 
        case 3387378:  return addNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 2051346646: /*statusReason*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1468651097: /*effective*/ return new String[] {"dateTime", "Period"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 481140686: /*performer*/ return new String[] {"Reference"};
        case -1273775369: /*previous*/ return new String[] {"Reference"};
        case -309542241: /*problem*/ return new String[] {"Reference"};
        case -1770133056: /*changePattern*/ return new String[] {"CodeableConcept"};
        case -989163880: /*protocol*/ return new String[] {"uri"};
        case -1857640538: /*summary*/ return new String[] {"string"};
        case -853173367: /*finding*/ return new String[] {};
        case -676337953: /*prognosisCodeableConcept*/ return new String[] {"CodeableConcept"};
        case -587137783: /*prognosisReference*/ return new String[] {"Reference"};
        case 1922406657: /*supportingInfo*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type ClinicalImpression.status");
        }
        else if (name.equals("statusReason")) {
          this.statusReason = new CodeableConcept();
          return this.statusReason;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type ClinicalImpression.description");
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
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type ClinicalImpression.date");
        }
        else if (name.equals("performer")) {
          this.performer = new Reference();
          return this.performer;
        }
        else if (name.equals("previous")) {
          this.previous = new Reference();
          return this.previous;
        }
        else if (name.equals("problem")) {
          return addProblem();
        }
        else if (name.equals("changePattern")) {
          this.changePattern = new CodeableConcept();
          return this.changePattern;
        }
        else if (name.equals("protocol")) {
          throw new FHIRException("Cannot call addChild on a primitive type ClinicalImpression.protocol");
        }
        else if (name.equals("summary")) {
          throw new FHIRException("Cannot call addChild on a primitive type ClinicalImpression.summary");
        }
        else if (name.equals("finding")) {
          return addFinding();
        }
        else if (name.equals("prognosisCodeableConcept")) {
          return addPrognosisCodeableConcept();
        }
        else if (name.equals("prognosisReference")) {
          return addPrognosisReference();
        }
        else if (name.equals("supportingInfo")) {
          return addSupportingInfo();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ClinicalImpression";

  }

      public ClinicalImpression copy() {
        ClinicalImpression dst = new ClinicalImpression();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ClinicalImpression dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.statusReason = statusReason == null ? null : statusReason.copy();
        dst.description = description == null ? null : description.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.effective = effective == null ? null : effective.copy();
        dst.date = date == null ? null : date.copy();
        dst.performer = performer == null ? null : performer.copy();
        dst.previous = previous == null ? null : previous.copy();
        if (problem != null) {
          dst.problem = new ArrayList<Reference>();
          for (Reference i : problem)
            dst.problem.add(i.copy());
        };
        dst.changePattern = changePattern == null ? null : changePattern.copy();
        if (protocol != null) {
          dst.protocol = new ArrayList<UriType>();
          for (UriType i : protocol)
            dst.protocol.add(i.copy());
        };
        dst.summary = summary == null ? null : summary.copy();
        if (finding != null) {
          dst.finding = new ArrayList<ClinicalImpressionFindingComponent>();
          for (ClinicalImpressionFindingComponent i : finding)
            dst.finding.add(i.copy());
        };
        if (prognosisCodeableConcept != null) {
          dst.prognosisCodeableConcept = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : prognosisCodeableConcept)
            dst.prognosisCodeableConcept.add(i.copy());
        };
        if (prognosisReference != null) {
          dst.prognosisReference = new ArrayList<Reference>();
          for (Reference i : prognosisReference)
            dst.prognosisReference.add(i.copy());
        };
        if (supportingInfo != null) {
          dst.supportingInfo = new ArrayList<Reference>();
          for (Reference i : supportingInfo)
            dst.supportingInfo.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
      }

      protected ClinicalImpression typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ClinicalImpression))
          return false;
        ClinicalImpression o = (ClinicalImpression) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(statusReason, o.statusReason, true)
           && compareDeep(description, o.description, true) && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(effective, o.effective, true) && compareDeep(date, o.date, true) && compareDeep(performer, o.performer, true)
           && compareDeep(previous, o.previous, true) && compareDeep(problem, o.problem, true) && compareDeep(changePattern, o.changePattern, true)
           && compareDeep(protocol, o.protocol, true) && compareDeep(summary, o.summary, true) && compareDeep(finding, o.finding, true)
           && compareDeep(prognosisCodeableConcept, o.prognosisCodeableConcept, true) && compareDeep(prognosisReference, o.prognosisReference, true)
           && compareDeep(supportingInfo, o.supportingInfo, true) && compareDeep(note, o.note, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ClinicalImpression))
          return false;
        ClinicalImpression o = (ClinicalImpression) other_;
        return compareValues(status, o.status, true) && compareValues(description, o.description, true) && compareValues(date, o.date, true)
           && compareValues(protocol, o.protocol, true) && compareValues(summary, o.summary, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, statusReason
          , description, subject, encounter, effective, date, performer, previous, problem
          , changePattern, protocol, summary, finding, prognosisCodeableConcept, prognosisReference
          , supportingInfo, note);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ClinicalImpression;
   }

 /**
   * Search parameter: <b>finding-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalImpression.finding.item.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="finding-code", path="ClinicalImpression.finding.item.concept", description="Reference to a concept (by class)", type="token" )
  public static final String SP_FINDING_CODE = "finding-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>finding-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalImpression.finding.item.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FINDING_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FINDING_CODE);

 /**
   * Search parameter: <b>finding-ref</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.finding.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="finding-ref", path="ClinicalImpression.finding.item.reference", description="Reference to a resource (by instance)", type="reference", target={Condition.class, DocumentReference.class, Observation.class } )
  public static final String SP_FINDING_REF = "finding-ref";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>finding-ref</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.finding.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam FINDING_REF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_FINDING_REF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalImpression:finding-ref</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_FINDING_REF = new ca.uhn.fhir.model.api.Include("ClinicalImpression:finding-ref").toLocked();

 /**
   * Search parameter: <b>performer</b>
   * <p>
   * Description: <b>The clinician performing the assessment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.performer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer", path="ClinicalImpression.performer", description="The clinician performing the assessment", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Practitioner.class, PractitionerRole.class } )
  public static final String SP_PERFORMER = "performer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer</b>
   * <p>
   * Description: <b>The clinician performing the assessment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.performer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PERFORMER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalImpression:performer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMER = new ca.uhn.fhir.model.api.Include("ClinicalImpression:performer").toLocked();

 /**
   * Search parameter: <b>previous</b>
   * <p>
   * Description: <b>Reference to last assessment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.previous</b><br>
   * </p>
   */
  @SearchParamDefinition(name="previous", path="ClinicalImpression.previous", description="Reference to last assessment", type="reference", target={ClinicalImpression.class } )
  public static final String SP_PREVIOUS = "previous";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>previous</b>
   * <p>
   * Description: <b>Reference to last assessment</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.previous</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PREVIOUS = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PREVIOUS);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalImpression:previous</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PREVIOUS = new ca.uhn.fhir.model.api.Include("ClinicalImpression:previous").toLocked();

 /**
   * Search parameter: <b>problem</b>
   * <p>
   * Description: <b>Relevant impressions of patient state</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.problem</b><br>
   * </p>
   */
  @SearchParamDefinition(name="problem", path="ClinicalImpression.problem", description="Relevant impressions of patient state", type="reference", target={AllergyIntolerance.class, Condition.class } )
  public static final String SP_PROBLEM = "problem";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>problem</b>
   * <p>
   * Description: <b>Relevant impressions of patient state</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.problem</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PROBLEM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PROBLEM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalImpression:problem</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PROBLEM = new ca.uhn.fhir.model.api.Include("ClinicalImpression:problem").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalImpression.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ClinicalImpression.status", description="preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>preparation | in-progress | not-done | on-hold | stopped | completed | entered-in-error | unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ClinicalImpression.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Patient or group assessed</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="ClinicalImpression.subject", description="Patient or group assessed", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Patient or group assessed</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalImpression:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("ClinicalImpression:subject").toLocked();

 /**
   * Search parameter: <b>supporting-info</b>
   * <p>
   * Description: <b>Information supporting the clinical impression</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.supportingInfo</b><br>
   * </p>
   */
  @SearchParamDefinition(name="supporting-info", path="ClinicalImpression.supportingInfo", description="Information supporting the clinical impression", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_SUPPORTING_INFO = "supporting-info";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>supporting-info</b>
   * <p>
   * Description: <b>Information supporting the clinical impression</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ClinicalImpression.supportingInfo</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUPPORTING_INFO = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUPPORTING_INFO);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ClinicalImpression:supporting-info</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUPPORTING_INFO = new ca.uhn.fhir.model.api.Include("ClinicalImpression:supporting-info").toLocked();

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
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [ResearchSubject](researchsubject.html): Start and end of participation
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AdverseEvent.occurrence.ofType(dateTime) | AdverseEvent.occurrence.ofType(Period) | AdverseEvent.occurrence.ofType(Timing) | AllergyIntolerance.recordedDate | (start | requestedPeriod.start).first() | AuditEvent.recorded | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.date | DiagnosticReport.effective.ofType(dateTime) | DiagnosticReport.effective.ofType(Period) | DocumentReference.date | Encounter.actualPeriod | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence.ofType(dateTime)) | ImmunizationEvaluation.date | ImmunizationRecommendation.date | Invoice.date | List.date | MeasureReport.date | NutritionIntake.occurrence.ofType(dateTime) | NutritionIntake.occurrence.ofType(Period) | Observation.effective.ofType(dateTime) | Observation.effective.ofType(Period) | Observation.effective.ofType(Timing) | Observation.effective.ofType(instant) | Procedure.occurrence.ofType(dateTime) | Procedure.occurrence.ofType(Period) | Procedure.occurrence.ofType(Timing) | ResearchSubject.period | (RiskAssessment.occurrence.ofType(dateTime)) | SupplyRequest.authoredOn", description="Multiple Resources: \r\n\r\n* [AdverseEvent](adverseevent.html): When the event occurred\r\n* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded\r\n* [Appointment](appointment.html): Appointment date/time.\r\n* [AuditEvent](auditevent.html): Time when the event was recorded\r\n* [CarePlan](careplan.html): Time period plan covers\r\n* [CareTeam](careteam.html): A date within the coverage time period.\r\n* [ClinicalImpression](clinicalimpression.html): When the assessment was documented\r\n* [Composition](composition.html): Composition editing time\r\n* [Consent](consent.html): When consent was agreed to\r\n* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report\r\n* [DocumentReference](documentreference.html): When this document reference was created\r\n* [Encounter](encounter.html): A date within the actualPeriod the Encounter lasted\r\n* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period\r\n* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated\r\n* [Flag](flag.html): Time period when flag is active\r\n* [Immunization](immunization.html): Vaccination  (non)-Administration Date\r\n* [ImmunizationEvaluation](immunizationevaluation.html): Date the evaluation was generated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Date recommendation(s) created\r\n* [Invoice](invoice.html): Invoice date / posting date\r\n* [List](list.html): When the list was prepared\r\n* [MeasureReport](measurereport.html): The date of the measure report\r\n* [NutritionIntake](nutritionintake.html): Date when patient was taking (or not taking) the medication\r\n* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period\r\n* [Procedure](procedure.html): When the procedure occurred or is occurring\r\n* [ResearchSubject](researchsubject.html): Start and end of participation\r\n* [RiskAssessment](riskassessment.html): When was assessment made?\r\n* [SupplyRequest](supplyrequest.html): When the request was made\r\n", type="date" )
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
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
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
   * the path value of "<b>ClinicalImpression:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("ClinicalImpression:encounter").toLocked();

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
   * the path value of "<b>ClinicalImpression:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("ClinicalImpression:patient").toLocked();


}

