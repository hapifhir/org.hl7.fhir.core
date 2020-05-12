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
 * An association between a patient and an organization / healthcare provider(s) during which time encounters may occur. The managing organization assumes a level of responsibility for the patient during this time.
 */
@ResourceDef(name="EpisodeOfCare", profile="http://hl7.org/fhir/StructureDefinition/EpisodeOfCare")
public class EpisodeOfCare extends DomainResource {

    public enum EpisodeOfCareStatus {
        /**
         * This episode of care is planned to start at the date specified in the period.start. During this status, an organization may perform assessments to determine if the patient is eligible to receive services, or be organizing to make resources available to provide care services.
         */
        PLANNED, 
        /**
         * This episode has been placed on a waitlist, pending the episode being made active (or cancelled).
         */
        WAITLIST, 
        /**
         * This episode of care is current.
         */
        ACTIVE, 
        /**
         * This episode of care is on hold; the organization has limited responsibility for the patient (such as while on respite).
         */
        ONHOLD, 
        /**
         * This episode of care is finished and the organization is not expecting to be providing further care to the patient. Can also be known as \"closed\", \"completed\" or other similar terms.
         */
        FINISHED, 
        /**
         * The episode of care was cancelled, or withdrawn from service, often selected during the planned stage as the patient may have gone elsewhere, or the circumstances have changed and the organization is unable to provide the care. It indicates that services terminated outside the planned/expected workflow.
         */
        CANCELLED, 
        /**
         * This instance should not have been part of this patient's medical record.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static EpisodeOfCareStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("planned".equals(codeString))
          return PLANNED;
        if ("waitlist".equals(codeString))
          return WAITLIST;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("onhold".equals(codeString))
          return ONHOLD;
        if ("finished".equals(codeString))
          return FINISHED;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown EpisodeOfCareStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PLANNED: return "planned";
            case WAITLIST: return "waitlist";
            case ACTIVE: return "active";
            case ONHOLD: return "onhold";
            case FINISHED: return "finished";
            case CANCELLED: return "cancelled";
            case ENTEREDINERROR: return "entered-in-error";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PLANNED: return "http://hl7.org/fhir/episode-of-care-status";
            case WAITLIST: return "http://hl7.org/fhir/episode-of-care-status";
            case ACTIVE: return "http://hl7.org/fhir/episode-of-care-status";
            case ONHOLD: return "http://hl7.org/fhir/episode-of-care-status";
            case FINISHED: return "http://hl7.org/fhir/episode-of-care-status";
            case CANCELLED: return "http://hl7.org/fhir/episode-of-care-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/episode-of-care-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PLANNED: return "This episode of care is planned to start at the date specified in the period.start. During this status, an organization may perform assessments to determine if the patient is eligible to receive services, or be organizing to make resources available to provide care services.";
            case WAITLIST: return "This episode has been placed on a waitlist, pending the episode being made active (or cancelled).";
            case ACTIVE: return "This episode of care is current.";
            case ONHOLD: return "This episode of care is on hold; the organization has limited responsibility for the patient (such as while on respite).";
            case FINISHED: return "This episode of care is finished and the organization is not expecting to be providing further care to the patient. Can also be known as \"closed\", \"completed\" or other similar terms.";
            case CANCELLED: return "The episode of care was cancelled, or withdrawn from service, often selected during the planned stage as the patient may have gone elsewhere, or the circumstances have changed and the organization is unable to provide the care. It indicates that services terminated outside the planned/expected workflow.";
            case ENTEREDINERROR: return "This instance should not have been part of this patient's medical record.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PLANNED: return "Planned";
            case WAITLIST: return "Waitlist";
            case ACTIVE: return "Active";
            case ONHOLD: return "On Hold";
            case FINISHED: return "Finished";
            case CANCELLED: return "Cancelled";
            case ENTEREDINERROR: return "Entered in Error";
            default: return "?";
          }
        }
    }

  public static class EpisodeOfCareStatusEnumFactory implements EnumFactory<EpisodeOfCareStatus> {
    public EpisodeOfCareStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("planned".equals(codeString))
          return EpisodeOfCareStatus.PLANNED;
        if ("waitlist".equals(codeString))
          return EpisodeOfCareStatus.WAITLIST;
        if ("active".equals(codeString))
          return EpisodeOfCareStatus.ACTIVE;
        if ("onhold".equals(codeString))
          return EpisodeOfCareStatus.ONHOLD;
        if ("finished".equals(codeString))
          return EpisodeOfCareStatus.FINISHED;
        if ("cancelled".equals(codeString))
          return EpisodeOfCareStatus.CANCELLED;
        if ("entered-in-error".equals(codeString))
          return EpisodeOfCareStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown EpisodeOfCareStatus code '"+codeString+"'");
        }
        public Enumeration<EpisodeOfCareStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EpisodeOfCareStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("planned".equals(codeString))
          return new Enumeration<EpisodeOfCareStatus>(this, EpisodeOfCareStatus.PLANNED);
        if ("waitlist".equals(codeString))
          return new Enumeration<EpisodeOfCareStatus>(this, EpisodeOfCareStatus.WAITLIST);
        if ("active".equals(codeString))
          return new Enumeration<EpisodeOfCareStatus>(this, EpisodeOfCareStatus.ACTIVE);
        if ("onhold".equals(codeString))
          return new Enumeration<EpisodeOfCareStatus>(this, EpisodeOfCareStatus.ONHOLD);
        if ("finished".equals(codeString))
          return new Enumeration<EpisodeOfCareStatus>(this, EpisodeOfCareStatus.FINISHED);
        if ("cancelled".equals(codeString))
          return new Enumeration<EpisodeOfCareStatus>(this, EpisodeOfCareStatus.CANCELLED);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<EpisodeOfCareStatus>(this, EpisodeOfCareStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown EpisodeOfCareStatus code '"+codeString+"'");
        }
    public String toCode(EpisodeOfCareStatus code) {
      if (code == EpisodeOfCareStatus.PLANNED)
        return "planned";
      if (code == EpisodeOfCareStatus.WAITLIST)
        return "waitlist";
      if (code == EpisodeOfCareStatus.ACTIVE)
        return "active";
      if (code == EpisodeOfCareStatus.ONHOLD)
        return "onhold";
      if (code == EpisodeOfCareStatus.FINISHED)
        return "finished";
      if (code == EpisodeOfCareStatus.CANCELLED)
        return "cancelled";
      if (code == EpisodeOfCareStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(EpisodeOfCareStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class EpisodeOfCareStatusHistoryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * planned | waitlist | active | onhold | finished | cancelled.
         */
        @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="planned | waitlist | active | onhold | finished | cancelled | entered-in-error", formalDefinition="planned | waitlist | active | onhold | finished | cancelled." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/episode-of-care-status")
        protected Enumeration<EpisodeOfCareStatus> status;

        /**
         * The period during this EpisodeOfCare that the specific status applied.
         */
        @Child(name = "period", type = {Period.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Duration the EpisodeOfCare was in the specified status", formalDefinition="The period during this EpisodeOfCare that the specific status applied." )
        protected Period period;

        private static final long serialVersionUID = -1192432864L;

    /**
     * Constructor
     */
      public EpisodeOfCareStatusHistoryComponent() {
        super();
      }

    /**
     * Constructor
     */
      public EpisodeOfCareStatusHistoryComponent(EpisodeOfCareStatus status, Period period) {
        super();
        this.setStatus(status);
        this.setPeriod(period);
      }

        /**
         * @return {@link #status} (planned | waitlist | active | onhold | finished | cancelled.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
         */
        public Enumeration<EpisodeOfCareStatus> getStatusElement() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EpisodeOfCareStatusHistoryComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new Enumeration<EpisodeOfCareStatus>(new EpisodeOfCareStatusEnumFactory()); // bb
          return this.status;
        }

        public boolean hasStatusElement() { 
          return this.status != null && !this.status.isEmpty();
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (planned | waitlist | active | onhold | finished | cancelled.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
         */
        public EpisodeOfCareStatusHistoryComponent setStatusElement(Enumeration<EpisodeOfCareStatus> value) { 
          this.status = value;
          return this;
        }

        /**
         * @return planned | waitlist | active | onhold | finished | cancelled.
         */
        public EpisodeOfCareStatus getStatus() { 
          return this.status == null ? null : this.status.getValue();
        }

        /**
         * @param value planned | waitlist | active | onhold | finished | cancelled.
         */
        public EpisodeOfCareStatusHistoryComponent setStatus(EpisodeOfCareStatus value) { 
            if (this.status == null)
              this.status = new Enumeration<EpisodeOfCareStatus>(new EpisodeOfCareStatusEnumFactory());
            this.status.setValue(value);
          return this;
        }

        /**
         * @return {@link #period} (The period during this EpisodeOfCare that the specific status applied.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create EpisodeOfCareStatusHistoryComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (The period during this EpisodeOfCare that the specific status applied.)
         */
        public EpisodeOfCareStatusHistoryComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("status", "code", "planned | waitlist | active | onhold | finished | cancelled.", 0, 1, status));
          children.add(new Property("period", "Period", "The period during this EpisodeOfCare that the specific status applied.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -892481550: /*status*/  return new Property("status", "code", "planned | waitlist | active | onhold | finished | cancelled.", 0, 1, status);
          case -991726143: /*period*/  return new Property("period", "Period", "The period during this EpisodeOfCare that the specific status applied.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EpisodeOfCareStatus>
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -892481550: // status
          value = new EpisodeOfCareStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EpisodeOfCareStatus>
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("status")) {
          value = new EpisodeOfCareStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EpisodeOfCareStatus>
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550:  return getStatusElement();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -892481550: /*status*/ return new String[] {"code"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type EpisodeOfCare.statusHistory.status");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public EpisodeOfCareStatusHistoryComponent copy() {
        EpisodeOfCareStatusHistoryComponent dst = new EpisodeOfCareStatusHistoryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EpisodeOfCareStatusHistoryComponent dst) {
        super.copyValues(dst);
        dst.status = status == null ? null : status.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EpisodeOfCareStatusHistoryComponent))
          return false;
        EpisodeOfCareStatusHistoryComponent o = (EpisodeOfCareStatusHistoryComponent) other_;
        return compareDeep(status, o.status, true) && compareDeep(period, o.period, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EpisodeOfCareStatusHistoryComponent))
          return false;
        EpisodeOfCareStatusHistoryComponent o = (EpisodeOfCareStatusHistoryComponent) other_;
        return compareValues(status, o.status, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(status, period);
      }

  public String fhirType() {
    return "EpisodeOfCare.statusHistory";

  }

  }

    @Block()
    public static class DiagnosisComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A list of conditions/problems/diagnoses that this episode of care is intended to be providing care for.
         */
        @Child(name = "condition", type = {Condition.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Conditions/problems/diagnoses this episode of care is for", formalDefinition="A list of conditions/problems/diagnoses that this episode of care is intended to be providing care for." )
        protected Reference condition;

        /**
         * Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge …).
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge …)", formalDefinition="Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge …)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/diagnosis-role")
        protected CodeableConcept role;

        /**
         * Ranking of the diagnosis (for each role type).
         */
        @Child(name = "rank", type = {PositiveIntType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Ranking of the diagnosis (for each role type)", formalDefinition="Ranking of the diagnosis (for each role type)." )
        protected PositiveIntType rank;

        private static final long serialVersionUID = -294944963L;

    /**
     * Constructor
     */
      public DiagnosisComponent() {
        super();
      }

    /**
     * Constructor
     */
      public DiagnosisComponent(Reference condition) {
        super();
        this.setCondition(condition);
      }

        /**
         * @return {@link #condition} (A list of conditions/problems/diagnoses that this episode of care is intended to be providing care for.)
         */
        public Reference getCondition() { 
          if (this.condition == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DiagnosisComponent.condition");
            else if (Configuration.doAutoCreate())
              this.condition = new Reference(); // cc
          return this.condition;
        }

        public boolean hasCondition() { 
          return this.condition != null && !this.condition.isEmpty();
        }

        /**
         * @param value {@link #condition} (A list of conditions/problems/diagnoses that this episode of care is intended to be providing care for.)
         */
        public DiagnosisComponent setCondition(Reference value) { 
          this.condition = value;
          return this;
        }

        /**
         * @return {@link #role} (Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge …).)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DiagnosisComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge …).)
         */
        public DiagnosisComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #rank} (Ranking of the diagnosis (for each role type).). This is the underlying object with id, value and extensions. The accessor "getRank" gives direct access to the value
         */
        public PositiveIntType getRankElement() { 
          if (this.rank == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create DiagnosisComponent.rank");
            else if (Configuration.doAutoCreate())
              this.rank = new PositiveIntType(); // bb
          return this.rank;
        }

        public boolean hasRankElement() { 
          return this.rank != null && !this.rank.isEmpty();
        }

        public boolean hasRank() { 
          return this.rank != null && !this.rank.isEmpty();
        }

        /**
         * @param value {@link #rank} (Ranking of the diagnosis (for each role type).). This is the underlying object with id, value and extensions. The accessor "getRank" gives direct access to the value
         */
        public DiagnosisComponent setRankElement(PositiveIntType value) { 
          this.rank = value;
          return this;
        }

        /**
         * @return Ranking of the diagnosis (for each role type).
         */
        public int getRank() { 
          return this.rank == null || this.rank.isEmpty() ? 0 : this.rank.getValue();
        }

        /**
         * @param value Ranking of the diagnosis (for each role type).
         */
        public DiagnosisComponent setRank(int value) { 
            if (this.rank == null)
              this.rank = new PositiveIntType();
            this.rank.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("condition", "Reference(Condition)", "A list of conditions/problems/diagnoses that this episode of care is intended to be providing care for.", 0, 1, condition));
          children.add(new Property("role", "CodeableConcept", "Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge …).", 0, 1, role));
          children.add(new Property("rank", "positiveInt", "Ranking of the diagnosis (for each role type).", 0, 1, rank));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -861311717: /*condition*/  return new Property("condition", "Reference(Condition)", "A list of conditions/problems/diagnoses that this episode of care is intended to be providing care for.", 0, 1, condition);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "Role that this diagnosis has within the episode of care (e.g. admission, billing, discharge …).", 0, 1, role);
          case 3492908: /*rank*/  return new Property("rank", "positiveInt", "Ranking of the diagnosis (for each role type).", 0, 1, rank);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : new Base[] {this.condition}; // Reference
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case 3492908: /*rank*/ return this.rank == null ? new Base[0] : new Base[] {this.rank}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -861311717: // condition
          this.condition = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3492908: // rank
          this.rank = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("condition")) {
          this.condition = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("rank")) {
          this.rank = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -861311717:  return getCondition();
        case 3506294:  return getRole();
        case 3492908:  return getRankElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -861311717: /*condition*/ return new String[] {"Reference"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case 3492908: /*rank*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("condition")) {
          this.condition = new Reference();
          return this.condition;
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("rank")) {
          throw new FHIRException("Cannot call addChild on a primitive type EpisodeOfCare.diagnosis.rank");
        }
        else
          return super.addChild(name);
      }

      public DiagnosisComponent copy() {
        DiagnosisComponent dst = new DiagnosisComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(DiagnosisComponent dst) {
        super.copyValues(dst);
        dst.condition = condition == null ? null : condition.copy();
        dst.role = role == null ? null : role.copy();
        dst.rank = rank == null ? null : rank.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof DiagnosisComponent))
          return false;
        DiagnosisComponent o = (DiagnosisComponent) other_;
        return compareDeep(condition, o.condition, true) && compareDeep(role, o.role, true) && compareDeep(rank, o.rank, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof DiagnosisComponent))
          return false;
        DiagnosisComponent o = (DiagnosisComponent) other_;
        return compareValues(rank, o.rank, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(condition, role, rank);
      }

  public String fhirType() {
    return "EpisodeOfCare.diagnosis";

  }

  }

    /**
     * The EpisodeOfCare may be known by different identifiers for different contexts of use, such as when an external agency is tracking the Episode for funding purposes.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Business Identifier(s) relevant for this EpisodeOfCare", formalDefinition="The EpisodeOfCare may be known by different identifiers for different contexts of use, such as when an external agency is tracking the Episode for funding purposes." )
    protected List<Identifier> identifier;

    /**
     * planned | waitlist | active | onhold | finished | cancelled.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="planned | waitlist | active | onhold | finished | cancelled | entered-in-error", formalDefinition="planned | waitlist | active | onhold | finished | cancelled." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/episode-of-care-status")
    protected Enumeration<EpisodeOfCareStatus> status;

    /**
     * The history of statuses that the EpisodeOfCare has been through (without requiring processing the history of the resource).
     */
    @Child(name = "statusHistory", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Past list of status codes (the current status may be included to cover the start date of the status)", formalDefinition="The history of statuses that the EpisodeOfCare has been through (without requiring processing the history of the resource)." )
    protected List<EpisodeOfCareStatusHistoryComponent> statusHistory;

    /**
     * A classification of the type of episode of care; e.g. specialist referral, disease management, type of funded care.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Type/class  - e.g. specialist referral, disease management", formalDefinition="A classification of the type of episode of care; e.g. specialist referral, disease management, type of funded care." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/episodeofcare-type")
    protected List<CodeableConcept> type;

    /**
     * The list of diagnosis relevant to this episode of care.
     */
    @Child(name = "diagnosis", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The list of diagnosis relevant to this episode of care", formalDefinition="The list of diagnosis relevant to this episode of care." )
    protected List<DiagnosisComponent> diagnosis;

    /**
     * The patient who is the focus of this episode of care.
     */
    @Child(name = "patient", type = {Patient.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The patient who is the focus of this episode of care", formalDefinition="The patient who is the focus of this episode of care." )
    protected Reference patient;

    /**
     * The organization that has assumed the specific responsibilities for the specified duration.
     */
    @Child(name = "managingOrganization", type = {Organization.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Organization that assumes care", formalDefinition="The organization that has assumed the specific responsibilities for the specified duration." )
    protected Reference managingOrganization;

    /**
     * The interval during which the managing organization assumes the defined responsibility.
     */
    @Child(name = "period", type = {Period.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Interval during responsibility is assumed", formalDefinition="The interval during which the managing organization assumes the defined responsibility." )
    protected Period period;

    /**
     * Referral Request(s) that are fulfilled by this EpisodeOfCare, incoming referrals.
     */
    @Child(name = "referralRequest", type = {ServiceRequest.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Originating Referral Request(s)", formalDefinition="Referral Request(s) that are fulfilled by this EpisodeOfCare, incoming referrals." )
    protected List<Reference> referralRequest;

    /**
     * The practitioner that is the care manager/care coordinator for this patient.
     */
    @Child(name = "careManager", type = {Practitioner.class, PractitionerRole.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Care manager/care coordinator for the patient", formalDefinition="The practitioner that is the care manager/care coordinator for this patient." )
    protected Reference careManager;

    /**
     * The list of practitioners that may be facilitating this episode of care for specific purposes.
     */
    @Child(name = "team", type = {CareTeam.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Other practitioners facilitating this episode of care", formalDefinition="The list of practitioners that may be facilitating this episode of care for specific purposes." )
    protected List<Reference> team;

    /**
     * The set of accounts that may be used for billing for this EpisodeOfCare.
     */
    @Child(name = "account", type = {Account.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The set of accounts that may be used for billing for this EpisodeOfCare", formalDefinition="The set of accounts that may be used for billing for this EpisodeOfCare." )
    protected List<Reference> account;

    private static final long serialVersionUID = 202200834L;

  /**
   * Constructor
   */
    public EpisodeOfCare() {
      super();
    }

  /**
   * Constructor
   */
    public EpisodeOfCare(EpisodeOfCareStatus status, Reference patient) {
      super();
      this.setStatus(status);
      this.setPatient(patient);
    }

    /**
     * @return {@link #identifier} (The EpisodeOfCare may be known by different identifiers for different contexts of use, such as when an external agency is tracking the Episode for funding purposes.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EpisodeOfCare setIdentifier(List<Identifier> theIdentifier) { 
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

    public EpisodeOfCare addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (planned | waitlist | active | onhold | finished | cancelled.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EpisodeOfCareStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EpisodeOfCare.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<EpisodeOfCareStatus>(new EpisodeOfCareStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (planned | waitlist | active | onhold | finished | cancelled.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public EpisodeOfCare setStatusElement(Enumeration<EpisodeOfCareStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return planned | waitlist | active | onhold | finished | cancelled.
     */
    public EpisodeOfCareStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value planned | waitlist | active | onhold | finished | cancelled.
     */
    public EpisodeOfCare setStatus(EpisodeOfCareStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<EpisodeOfCareStatus>(new EpisodeOfCareStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #statusHistory} (The history of statuses that the EpisodeOfCare has been through (without requiring processing the history of the resource).)
     */
    public List<EpisodeOfCareStatusHistoryComponent> getStatusHistory() { 
      if (this.statusHistory == null)
        this.statusHistory = new ArrayList<EpisodeOfCareStatusHistoryComponent>();
      return this.statusHistory;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EpisodeOfCare setStatusHistory(List<EpisodeOfCareStatusHistoryComponent> theStatusHistory) { 
      this.statusHistory = theStatusHistory;
      return this;
    }

    public boolean hasStatusHistory() { 
      if (this.statusHistory == null)
        return false;
      for (EpisodeOfCareStatusHistoryComponent item : this.statusHistory)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public EpisodeOfCareStatusHistoryComponent addStatusHistory() { //3
      EpisodeOfCareStatusHistoryComponent t = new EpisodeOfCareStatusHistoryComponent();
      if (this.statusHistory == null)
        this.statusHistory = new ArrayList<EpisodeOfCareStatusHistoryComponent>();
      this.statusHistory.add(t);
      return t;
    }

    public EpisodeOfCare addStatusHistory(EpisodeOfCareStatusHistoryComponent t) { //3
      if (t == null)
        return this;
      if (this.statusHistory == null)
        this.statusHistory = new ArrayList<EpisodeOfCareStatusHistoryComponent>();
      this.statusHistory.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #statusHistory}, creating it if it does not already exist {3}
     */
    public EpisodeOfCareStatusHistoryComponent getStatusHistoryFirstRep() { 
      if (getStatusHistory().isEmpty()) {
        addStatusHistory();
      }
      return getStatusHistory().get(0);
    }

    /**
     * @return {@link #type} (A classification of the type of episode of care; e.g. specialist referral, disease management, type of funded care.)
     */
    public List<CodeableConcept> getType() { 
      if (this.type == null)
        this.type = new ArrayList<CodeableConcept>();
      return this.type;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EpisodeOfCare setType(List<CodeableConcept> theType) { 
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

    public EpisodeOfCare addType(CodeableConcept t) { //3
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
     * @return {@link #diagnosis} (The list of diagnosis relevant to this episode of care.)
     */
    public List<DiagnosisComponent> getDiagnosis() { 
      if (this.diagnosis == null)
        this.diagnosis = new ArrayList<DiagnosisComponent>();
      return this.diagnosis;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EpisodeOfCare setDiagnosis(List<DiagnosisComponent> theDiagnosis) { 
      this.diagnosis = theDiagnosis;
      return this;
    }

    public boolean hasDiagnosis() { 
      if (this.diagnosis == null)
        return false;
      for (DiagnosisComponent item : this.diagnosis)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public DiagnosisComponent addDiagnosis() { //3
      DiagnosisComponent t = new DiagnosisComponent();
      if (this.diagnosis == null)
        this.diagnosis = new ArrayList<DiagnosisComponent>();
      this.diagnosis.add(t);
      return t;
    }

    public EpisodeOfCare addDiagnosis(DiagnosisComponent t) { //3
      if (t == null)
        return this;
      if (this.diagnosis == null)
        this.diagnosis = new ArrayList<DiagnosisComponent>();
      this.diagnosis.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #diagnosis}, creating it if it does not already exist {3}
     */
    public DiagnosisComponent getDiagnosisFirstRep() { 
      if (getDiagnosis().isEmpty()) {
        addDiagnosis();
      }
      return getDiagnosis().get(0);
    }

    /**
     * @return {@link #patient} (The patient who is the focus of this episode of care.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EpisodeOfCare.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (The patient who is the focus of this episode of care.)
     */
    public EpisodeOfCare setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #managingOrganization} (The organization that has assumed the specific responsibilities for the specified duration.)
     */
    public Reference getManagingOrganization() { 
      if (this.managingOrganization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EpisodeOfCare.managingOrganization");
        else if (Configuration.doAutoCreate())
          this.managingOrganization = new Reference(); // cc
      return this.managingOrganization;
    }

    public boolean hasManagingOrganization() { 
      return this.managingOrganization != null && !this.managingOrganization.isEmpty();
    }

    /**
     * @param value {@link #managingOrganization} (The organization that has assumed the specific responsibilities for the specified duration.)
     */
    public EpisodeOfCare setManagingOrganization(Reference value) { 
      this.managingOrganization = value;
      return this;
    }

    /**
     * @return {@link #period} (The interval during which the managing organization assumes the defined responsibility.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EpisodeOfCare.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The interval during which the managing organization assumes the defined responsibility.)
     */
    public EpisodeOfCare setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #referralRequest} (Referral Request(s) that are fulfilled by this EpisodeOfCare, incoming referrals.)
     */
    public List<Reference> getReferralRequest() { 
      if (this.referralRequest == null)
        this.referralRequest = new ArrayList<Reference>();
      return this.referralRequest;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EpisodeOfCare setReferralRequest(List<Reference> theReferralRequest) { 
      this.referralRequest = theReferralRequest;
      return this;
    }

    public boolean hasReferralRequest() { 
      if (this.referralRequest == null)
        return false;
      for (Reference item : this.referralRequest)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addReferralRequest() { //3
      Reference t = new Reference();
      if (this.referralRequest == null)
        this.referralRequest = new ArrayList<Reference>();
      this.referralRequest.add(t);
      return t;
    }

    public EpisodeOfCare addReferralRequest(Reference t) { //3
      if (t == null)
        return this;
      if (this.referralRequest == null)
        this.referralRequest = new ArrayList<Reference>();
      this.referralRequest.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #referralRequest}, creating it if it does not already exist {3}
     */
    public Reference getReferralRequestFirstRep() { 
      if (getReferralRequest().isEmpty()) {
        addReferralRequest();
      }
      return getReferralRequest().get(0);
    }

    /**
     * @return {@link #careManager} (The practitioner that is the care manager/care coordinator for this patient.)
     */
    public Reference getCareManager() { 
      if (this.careManager == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create EpisodeOfCare.careManager");
        else if (Configuration.doAutoCreate())
          this.careManager = new Reference(); // cc
      return this.careManager;
    }

    public boolean hasCareManager() { 
      return this.careManager != null && !this.careManager.isEmpty();
    }

    /**
     * @param value {@link #careManager} (The practitioner that is the care manager/care coordinator for this patient.)
     */
    public EpisodeOfCare setCareManager(Reference value) { 
      this.careManager = value;
      return this;
    }

    /**
     * @return {@link #team} (The list of practitioners that may be facilitating this episode of care for specific purposes.)
     */
    public List<Reference> getTeam() { 
      if (this.team == null)
        this.team = new ArrayList<Reference>();
      return this.team;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EpisodeOfCare setTeam(List<Reference> theTeam) { 
      this.team = theTeam;
      return this;
    }

    public boolean hasTeam() { 
      if (this.team == null)
        return false;
      for (Reference item : this.team)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addTeam() { //3
      Reference t = new Reference();
      if (this.team == null)
        this.team = new ArrayList<Reference>();
      this.team.add(t);
      return t;
    }

    public EpisodeOfCare addTeam(Reference t) { //3
      if (t == null)
        return this;
      if (this.team == null)
        this.team = new ArrayList<Reference>();
      this.team.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #team}, creating it if it does not already exist {3}
     */
    public Reference getTeamFirstRep() { 
      if (getTeam().isEmpty()) {
        addTeam();
      }
      return getTeam().get(0);
    }

    /**
     * @return {@link #account} (The set of accounts that may be used for billing for this EpisodeOfCare.)
     */
    public List<Reference> getAccount() { 
      if (this.account == null)
        this.account = new ArrayList<Reference>();
      return this.account;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public EpisodeOfCare setAccount(List<Reference> theAccount) { 
      this.account = theAccount;
      return this;
    }

    public boolean hasAccount() { 
      if (this.account == null)
        return false;
      for (Reference item : this.account)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addAccount() { //3
      Reference t = new Reference();
      if (this.account == null)
        this.account = new ArrayList<Reference>();
      this.account.add(t);
      return t;
    }

    public EpisodeOfCare addAccount(Reference t) { //3
      if (t == null)
        return this;
      if (this.account == null)
        this.account = new ArrayList<Reference>();
      this.account.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #account}, creating it if it does not already exist {3}
     */
    public Reference getAccountFirstRep() { 
      if (getAccount().isEmpty()) {
        addAccount();
      }
      return getAccount().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "The EpisodeOfCare may be known by different identifiers for different contexts of use, such as when an external agency is tracking the Episode for funding purposes.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "planned | waitlist | active | onhold | finished | cancelled.", 0, 1, status));
        children.add(new Property("statusHistory", "", "The history of statuses that the EpisodeOfCare has been through (without requiring processing the history of the resource).", 0, java.lang.Integer.MAX_VALUE, statusHistory));
        children.add(new Property("type", "CodeableConcept", "A classification of the type of episode of care; e.g. specialist referral, disease management, type of funded care.", 0, java.lang.Integer.MAX_VALUE, type));
        children.add(new Property("diagnosis", "", "The list of diagnosis relevant to this episode of care.", 0, java.lang.Integer.MAX_VALUE, diagnosis));
        children.add(new Property("patient", "Reference(Patient)", "The patient who is the focus of this episode of care.", 0, 1, patient));
        children.add(new Property("managingOrganization", "Reference(Organization)", "The organization that has assumed the specific responsibilities for the specified duration.", 0, 1, managingOrganization));
        children.add(new Property("period", "Period", "The interval during which the managing organization assumes the defined responsibility.", 0, 1, period));
        children.add(new Property("referralRequest", "Reference(ServiceRequest)", "Referral Request(s) that are fulfilled by this EpisodeOfCare, incoming referrals.", 0, java.lang.Integer.MAX_VALUE, referralRequest));
        children.add(new Property("careManager", "Reference(Practitioner|PractitionerRole)", "The practitioner that is the care manager/care coordinator for this patient.", 0, 1, careManager));
        children.add(new Property("team", "Reference(CareTeam)", "The list of practitioners that may be facilitating this episode of care for specific purposes.", 0, java.lang.Integer.MAX_VALUE, team));
        children.add(new Property("account", "Reference(Account)", "The set of accounts that may be used for billing for this EpisodeOfCare.", 0, java.lang.Integer.MAX_VALUE, account));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "The EpisodeOfCare may be known by different identifiers for different contexts of use, such as when an external agency is tracking the Episode for funding purposes.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "planned | waitlist | active | onhold | finished | cancelled.", 0, 1, status);
        case -986695614: /*statusHistory*/  return new Property("statusHistory", "", "The history of statuses that the EpisodeOfCare has been through (without requiring processing the history of the resource).", 0, java.lang.Integer.MAX_VALUE, statusHistory);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A classification of the type of episode of care; e.g. specialist referral, disease management, type of funded care.", 0, java.lang.Integer.MAX_VALUE, type);
        case 1196993265: /*diagnosis*/  return new Property("diagnosis", "", "The list of diagnosis relevant to this episode of care.", 0, java.lang.Integer.MAX_VALUE, diagnosis);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "The patient who is the focus of this episode of care.", 0, 1, patient);
        case -2058947787: /*managingOrganization*/  return new Property("managingOrganization", "Reference(Organization)", "The organization that has assumed the specific responsibilities for the specified duration.", 0, 1, managingOrganization);
        case -991726143: /*period*/  return new Property("period", "Period", "The interval during which the managing organization assumes the defined responsibility.", 0, 1, period);
        case -310299598: /*referralRequest*/  return new Property("referralRequest", "Reference(ServiceRequest)", "Referral Request(s) that are fulfilled by this EpisodeOfCare, incoming referrals.", 0, java.lang.Integer.MAX_VALUE, referralRequest);
        case -1147746468: /*careManager*/  return new Property("careManager", "Reference(Practitioner|PractitionerRole)", "The practitioner that is the care manager/care coordinator for this patient.", 0, 1, careManager);
        case 3555933: /*team*/  return new Property("team", "Reference(CareTeam)", "The list of practitioners that may be facilitating this episode of care for specific purposes.", 0, java.lang.Integer.MAX_VALUE, team);
        case -1177318867: /*account*/  return new Property("account", "Reference(Account)", "The set of accounts that may be used for billing for this EpisodeOfCare.", 0, java.lang.Integer.MAX_VALUE, account);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EpisodeOfCareStatus>
        case -986695614: /*statusHistory*/ return this.statusHistory == null ? new Base[0] : this.statusHistory.toArray(new Base[this.statusHistory.size()]); // EpisodeOfCareStatusHistoryComponent
        case 3575610: /*type*/ return this.type == null ? new Base[0] : this.type.toArray(new Base[this.type.size()]); // CodeableConcept
        case 1196993265: /*diagnosis*/ return this.diagnosis == null ? new Base[0] : this.diagnosis.toArray(new Base[this.diagnosis.size()]); // DiagnosisComponent
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case -2058947787: /*managingOrganization*/ return this.managingOrganization == null ? new Base[0] : new Base[] {this.managingOrganization}; // Reference
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case -310299598: /*referralRequest*/ return this.referralRequest == null ? new Base[0] : this.referralRequest.toArray(new Base[this.referralRequest.size()]); // Reference
        case -1147746468: /*careManager*/ return this.careManager == null ? new Base[0] : new Base[] {this.careManager}; // Reference
        case 3555933: /*team*/ return this.team == null ? new Base[0] : this.team.toArray(new Base[this.team.size()]); // Reference
        case -1177318867: /*account*/ return this.account == null ? new Base[0] : this.account.toArray(new Base[this.account.size()]); // Reference
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
          value = new EpisodeOfCareStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EpisodeOfCareStatus>
          return value;
        case -986695614: // statusHistory
          this.getStatusHistory().add((EpisodeOfCareStatusHistoryComponent) value); // EpisodeOfCareStatusHistoryComponent
          return value;
        case 3575610: // type
          this.getType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1196993265: // diagnosis
          this.getDiagnosis().add((DiagnosisComponent) value); // DiagnosisComponent
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        case -2058947787: // managingOrganization
          this.managingOrganization = TypeConvertor.castToReference(value); // Reference
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -310299598: // referralRequest
          this.getReferralRequest().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1147746468: // careManager
          this.careManager = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3555933: // team
          this.getTeam().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1177318867: // account
          this.getAccount().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new EpisodeOfCareStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EpisodeOfCareStatus>
        } else if (name.equals("statusHistory")) {
          this.getStatusHistory().add((EpisodeOfCareStatusHistoryComponent) value);
        } else if (name.equals("type")) {
          this.getType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("diagnosis")) {
          this.getDiagnosis().add((DiagnosisComponent) value);
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("managingOrganization")) {
          this.managingOrganization = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("referralRequest")) {
          this.getReferralRequest().add(TypeConvertor.castToReference(value));
        } else if (name.equals("careManager")) {
          this.careManager = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("team")) {
          this.getTeam().add(TypeConvertor.castToReference(value));
        } else if (name.equals("account")) {
          this.getAccount().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -986695614:  return addStatusHistory(); 
        case 3575610:  return addType(); 
        case 1196993265:  return addDiagnosis(); 
        case -791418107:  return getPatient();
        case -2058947787:  return getManagingOrganization();
        case -991726143:  return getPeriod();
        case -310299598:  return addReferralRequest(); 
        case -1147746468:  return getCareManager();
        case 3555933:  return addTeam(); 
        case -1177318867:  return addAccount(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -986695614: /*statusHistory*/ return new String[] {};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 1196993265: /*diagnosis*/ return new String[] {};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case -2058947787: /*managingOrganization*/ return new String[] {"Reference"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case -310299598: /*referralRequest*/ return new String[] {"Reference"};
        case -1147746468: /*careManager*/ return new String[] {"Reference"};
        case 3555933: /*team*/ return new String[] {"Reference"};
        case -1177318867: /*account*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type EpisodeOfCare.status");
        }
        else if (name.equals("statusHistory")) {
          return addStatusHistory();
        }
        else if (name.equals("type")) {
          return addType();
        }
        else if (name.equals("diagnosis")) {
          return addDiagnosis();
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("managingOrganization")) {
          this.managingOrganization = new Reference();
          return this.managingOrganization;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("referralRequest")) {
          return addReferralRequest();
        }
        else if (name.equals("careManager")) {
          this.careManager = new Reference();
          return this.careManager;
        }
        else if (name.equals("team")) {
          return addTeam();
        }
        else if (name.equals("account")) {
          return addAccount();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "EpisodeOfCare";

  }

      public EpisodeOfCare copy() {
        EpisodeOfCare dst = new EpisodeOfCare();
        copyValues(dst);
        return dst;
      }

      public void copyValues(EpisodeOfCare dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (statusHistory != null) {
          dst.statusHistory = new ArrayList<EpisodeOfCareStatusHistoryComponent>();
          for (EpisodeOfCareStatusHistoryComponent i : statusHistory)
            dst.statusHistory.add(i.copy());
        };
        if (type != null) {
          dst.type = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : type)
            dst.type.add(i.copy());
        };
        if (diagnosis != null) {
          dst.diagnosis = new ArrayList<DiagnosisComponent>();
          for (DiagnosisComponent i : diagnosis)
            dst.diagnosis.add(i.copy());
        };
        dst.patient = patient == null ? null : patient.copy();
        dst.managingOrganization = managingOrganization == null ? null : managingOrganization.copy();
        dst.period = period == null ? null : period.copy();
        if (referralRequest != null) {
          dst.referralRequest = new ArrayList<Reference>();
          for (Reference i : referralRequest)
            dst.referralRequest.add(i.copy());
        };
        dst.careManager = careManager == null ? null : careManager.copy();
        if (team != null) {
          dst.team = new ArrayList<Reference>();
          for (Reference i : team)
            dst.team.add(i.copy());
        };
        if (account != null) {
          dst.account = new ArrayList<Reference>();
          for (Reference i : account)
            dst.account.add(i.copy());
        };
      }

      protected EpisodeOfCare typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof EpisodeOfCare))
          return false;
        EpisodeOfCare o = (EpisodeOfCare) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(statusHistory, o.statusHistory, true)
           && compareDeep(type, o.type, true) && compareDeep(diagnosis, o.diagnosis, true) && compareDeep(patient, o.patient, true)
           && compareDeep(managingOrganization, o.managingOrganization, true) && compareDeep(period, o.period, true)
           && compareDeep(referralRequest, o.referralRequest, true) && compareDeep(careManager, o.careManager, true)
           && compareDeep(team, o.team, true) && compareDeep(account, o.account, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof EpisodeOfCare))
          return false;
        EpisodeOfCare o = (EpisodeOfCare) other_;
        return compareValues(status, o.status, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, statusHistory
          , type, diagnosis, patient, managingOrganization, period, referralRequest, careManager
          , team, account);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.EpisodeOfCare;
   }

 /**
   * Search parameter: <b>care-manager</b>
   * <p>
   * Description: <b>Care manager/care coordinator for the patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EpisodeOfCare.careManager.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="care-manager", path="EpisodeOfCare.careManager.where(resolve() is Practitioner)", description="Care manager/care coordinator for the patient", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Practitioner.class } )
  public static final String SP_CARE_MANAGER = "care-manager";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>care-manager</b>
   * <p>
   * Description: <b>Care manager/care coordinator for the patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EpisodeOfCare.careManager.where(resolve() is Practitioner)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CARE_MANAGER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CARE_MANAGER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EpisodeOfCare:care-manager</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CARE_MANAGER = new ca.uhn.fhir.model.api.Include("EpisodeOfCare:care-manager").toLocked();

 /**
   * Search parameter: <b>condition</b>
   * <p>
   * Description: <b>Conditions/problems/diagnoses this episode of care is for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EpisodeOfCare.diagnosis.condition</b><br>
   * </p>
   */
  @SearchParamDefinition(name="condition", path="EpisodeOfCare.diagnosis.condition", description="Conditions/problems/diagnoses this episode of care is for", type="reference", target={Condition.class } )
  public static final String SP_CONDITION = "condition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>condition</b>
   * <p>
   * Description: <b>Conditions/problems/diagnoses this episode of care is for</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EpisodeOfCare.diagnosis.condition</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CONDITION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CONDITION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EpisodeOfCare:condition</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CONDITION = new ca.uhn.fhir.model.api.Include("EpisodeOfCare:condition").toLocked();

 /**
   * Search parameter: <b>incoming-referral</b>
   * <p>
   * Description: <b>Incoming Referral Request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EpisodeOfCare.referralRequest</b><br>
   * </p>
   */
  @SearchParamDefinition(name="incoming-referral", path="EpisodeOfCare.referralRequest", description="Incoming Referral Request", type="reference", target={ServiceRequest.class } )
  public static final String SP_INCOMING_REFERRAL = "incoming-referral";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>incoming-referral</b>
   * <p>
   * Description: <b>Incoming Referral Request</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EpisodeOfCare.referralRequest</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INCOMING_REFERRAL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INCOMING_REFERRAL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EpisodeOfCare:incoming-referral</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INCOMING_REFERRAL = new ca.uhn.fhir.model.api.Include("EpisodeOfCare:incoming-referral").toLocked();

 /**
   * Search parameter: <b>organization</b>
   * <p>
   * Description: <b>The organization that has assumed the specific responsibilities of this EpisodeOfCare</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EpisodeOfCare.managingOrganization</b><br>
   * </p>
   */
  @SearchParamDefinition(name="organization", path="EpisodeOfCare.managingOrganization", description="The organization that has assumed the specific responsibilities of this EpisodeOfCare", type="reference", target={Organization.class } )
  public static final String SP_ORGANIZATION = "organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>organization</b>
   * <p>
   * Description: <b>The organization that has assumed the specific responsibilities of this EpisodeOfCare</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>EpisodeOfCare.managingOrganization</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>EpisodeOfCare:organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ORGANIZATION = new ca.uhn.fhir.model.api.Include("EpisodeOfCare:organization").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The current status of the Episode of Care as provided (does not check the status history collection)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EpisodeOfCare.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="EpisodeOfCare.status", description="The current status of the Episode of Care as provided (does not check the status history collection)", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The current status of the Episode of Care as provided (does not check the status history collection)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>EpisodeOfCare.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [Encounter](encounter.html): A date within the period the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [List](list.html): When the list was prepared
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.dateTime | DiagnosticReport.effective | Encounter.period | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective | Procedure.occurrence | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.dateTime | DiagnosticReport.effective | Encounter.period | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective | Procedure.occurrence | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded\r\n* [CarePlan](careplan.html): Time period plan covers\r\n* [CareTeam](careteam.html): A date within the coverage time period.\r\n* [ClinicalImpression](clinicalimpression.html): When the assessment was documented\r\n* [Composition](composition.html): Composition editing time\r\n* [Consent](consent.html): When consent was agreed to\r\n* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report\r\n* [Encounter](encounter.html): A date within the period the Encounter lasted\r\n* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period\r\n* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated\r\n* [Flag](flag.html): Time period when flag is active\r\n* [Immunization](immunization.html): Vaccination  (non)-Administration Date\r\n* [List](list.html): When the list was prepared\r\n* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period\r\n* [Procedure](procedure.html): When the procedure occurred or is occurring\r\n* [RiskAssessment](riskassessment.html): When was assessment made?\r\n* [SupplyRequest](supplyrequest.html): When the request was made\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): Date first version of the resource instance was recorded
* [CarePlan](careplan.html): Time period plan covers
* [CareTeam](careteam.html): A date within the coverage time period.
* [ClinicalImpression](clinicalimpression.html): When the assessment was documented
* [Composition](composition.html): Composition editing time
* [Consent](consent.html): When consent was agreed to
* [DiagnosticReport](diagnosticreport.html): The clinically relevant time of the report
* [Encounter](encounter.html): A date within the period the Encounter lasted
* [EpisodeOfCare](episodeofcare.html): The provided date search value falls within the episode of care's period
* [FamilyMemberHistory](familymemberhistory.html): When history was recorded or last updated
* [Flag](flag.html): Time period when flag is active
* [Immunization](immunization.html): Vaccination  (non)-Administration Date
* [List](list.html): When the list was prepared
* [Observation](observation.html): Obtained date/time. If the obtained element is a period, a date that falls in the period
* [Procedure](procedure.html): When the procedure occurred or is occurring
* [RiskAssessment](riskassessment.html): When was assessment made?
* [SupplyRequest](supplyrequest.html): When the request was made
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>AllergyIntolerance.recordedDate | CarePlan.period | ClinicalImpression.date | Composition.date | Consent.dateTime | DiagnosticReport.effective | Encounter.period | EpisodeOfCare.period | FamilyMemberHistory.date | Flag.period | (Immunization.occurrence as dateTime) | List.date | Observation.effective | Procedure.occurrence | (RiskAssessment.occurrence as dateTime) | SupplyRequest.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

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
  @SearchParamDefinition(name="patient", path="AllergyIntolerance.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ClinicalImpression.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | DetectedIssue.patient | DeviceRequest.subject.where(resolve() is Patient) | DeviceUseStatement.subject | DiagnosticReport.subject.where(resolve() is Patient) | DocumentManifest.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EpisodeOfCare.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | List.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationUsage.subject.where(resolve() is Patient) | NutritionOrder.patient | Observation.subject.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | SupplyDelivery.patient | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ClinicalImpression](clinicalimpression.html): Patient or group assessed\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUseStatement](deviceusestatement.html): Search by subject - a patient\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentManifest](documentmanifest.html): The subject of the set of documents\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient or group present at the encounter\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [List](list.html): If all resources have the same subject\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationUsage](medicationusage.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the person who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
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
   * the path value of "<b>EpisodeOfCare:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("EpisodeOfCare:patient").toLocked();

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [DocumentManifest](documentmanifest.html): Kind of document set
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.type | Composition.type | DocumentManifest.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="AllergyIntolerance.type | Composition.type | DocumentManifest.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type", description="Multiple Resources: \r\n\r\n* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)\r\n* [Composition](composition.html): Kind of composition (LOINC if possible)\r\n* [DocumentManifest](documentmanifest.html): Kind of document set\r\n* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)\r\n* [Encounter](encounter.html): Specific type of encounter\r\n* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management\r\n", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AllergyIntolerance](allergyintolerance.html): allergy | intolerance - Underlying mechanism (if known)
* [Composition](composition.html): Kind of composition (LOINC if possible)
* [DocumentManifest](documentmanifest.html): Kind of document set
* [DocumentReference](documentreference.html): Kind of document (LOINC if possible)
* [Encounter](encounter.html): Specific type of encounter
* [EpisodeOfCare](episodeofcare.html): Type/class  - e.g. specialist referral, disease management
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AllergyIntolerance.type | Composition.type | DocumentManifest.type | DocumentReference.type | Encounter.type | EpisodeOfCare.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}