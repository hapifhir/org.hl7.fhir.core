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

// Generated on Fri, Jul 15, 2022 11:20+1000 for FHIR vcurrent

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
 * A financial tool for tracking value accrued for a particular purpose.  In the healthcare field, used to track charges for a patient, cost centers, etc.
 */
@ResourceDef(name="Account", profile="http://hl7.org/fhir/StructureDefinition/Account")
public class Account extends DomainResource {

    public enum AccountStatus {
        /**
         * This account is active and may be used.
         */
        ACTIVE, 
        /**
         * This account is inactive and should not be used to track financial information.
         */
        INACTIVE, 
        /**
         * This instance should not have been part of this patient's medical record.
         */
        ENTEREDINERROR, 
        /**
         * This account is on hold.
         */
        ONHOLD, 
        /**
         * The account status is unknown.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static AccountStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("on-hold".equals(codeString))
          return ONHOLD;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown AccountStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case INACTIVE: return "inactive";
            case ENTEREDINERROR: return "entered-in-error";
            case ONHOLD: return "on-hold";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/account-status";
            case INACTIVE: return "http://hl7.org/fhir/account-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/account-status";
            case ONHOLD: return "http://hl7.org/fhir/account-status";
            case UNKNOWN: return "http://hl7.org/fhir/account-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "This account is active and may be used.";
            case INACTIVE: return "This account is inactive and should not be used to track financial information.";
            case ENTEREDINERROR: return "This instance should not have been part of this patient's medical record.";
            case ONHOLD: return "This account is on hold.";
            case UNKNOWN: return "The account status is unknown.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case INACTIVE: return "Inactive";
            case ENTEREDINERROR: return "Entered in error";
            case ONHOLD: return "On Hold";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class AccountStatusEnumFactory implements EnumFactory<AccountStatus> {
    public AccountStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return AccountStatus.ACTIVE;
        if ("inactive".equals(codeString))
          return AccountStatus.INACTIVE;
        if ("entered-in-error".equals(codeString))
          return AccountStatus.ENTEREDINERROR;
        if ("on-hold".equals(codeString))
          return AccountStatus.ONHOLD;
        if ("unknown".equals(codeString))
          return AccountStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown AccountStatus code '"+codeString+"'");
        }
        public Enumeration<AccountStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<AccountStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<AccountStatus>(this, AccountStatus.ACTIVE);
        if ("inactive".equals(codeString))
          return new Enumeration<AccountStatus>(this, AccountStatus.INACTIVE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<AccountStatus>(this, AccountStatus.ENTEREDINERROR);
        if ("on-hold".equals(codeString))
          return new Enumeration<AccountStatus>(this, AccountStatus.ONHOLD);
        if ("unknown".equals(codeString))
          return new Enumeration<AccountStatus>(this, AccountStatus.UNKNOWN);
        throw new FHIRException("Unknown AccountStatus code '"+codeString+"'");
        }
    public String toCode(AccountStatus code) {
      if (code == AccountStatus.ACTIVE)
        return "active";
      if (code == AccountStatus.INACTIVE)
        return "inactive";
      if (code == AccountStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == AccountStatus.ONHOLD)
        return "on-hold";
      if (code == AccountStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(AccountStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class CoverageComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The party(s) that contribute to payment (or part of) of the charges applied to this account (including self-pay).

A coverage may only be responsible for specific types of charges, and the sequence of the coverages in the account could be important when processing billing.
         */
        @Child(name = "coverage", type = {Coverage.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The party(s), such as insurances, that may contribute to the payment of this account", formalDefinition="The party(s) that contribute to payment (or part of) of the charges applied to this account (including self-pay).\n\nA coverage may only be responsible for specific types of charges, and the sequence of the coverages in the account could be important when processing billing." )
        protected Reference coverage;

        /**
         * The priority of the coverage in the context of this account.
         */
        @Child(name = "priority", type = {PositiveIntType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The priority of the coverage in the context of this account", formalDefinition="The priority of the coverage in the context of this account." )
        protected PositiveIntType priority;

        private static final long serialVersionUID = 1695665065L;

    /**
     * Constructor
     */
      public CoverageComponent() {
        super();
      }

    /**
     * Constructor
     */
      public CoverageComponent(Reference coverage) {
        super();
        this.setCoverage(coverage);
      }

        /**
         * @return {@link #coverage} (The party(s) that contribute to payment (or part of) of the charges applied to this account (including self-pay).

A coverage may only be responsible for specific types of charges, and the sequence of the coverages in the account could be important when processing billing.)
         */
        public Reference getCoverage() { 
          if (this.coverage == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CoverageComponent.coverage");
            else if (Configuration.doAutoCreate())
              this.coverage = new Reference(); // cc
          return this.coverage;
        }

        public boolean hasCoverage() { 
          return this.coverage != null && !this.coverage.isEmpty();
        }

        /**
         * @param value {@link #coverage} (The party(s) that contribute to payment (or part of) of the charges applied to this account (including self-pay).

A coverage may only be responsible for specific types of charges, and the sequence of the coverages in the account could be important when processing billing.)
         */
        public CoverageComponent setCoverage(Reference value) { 
          this.coverage = value;
          return this;
        }

        /**
         * @return {@link #priority} (The priority of the coverage in the context of this account.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
         */
        public PositiveIntType getPriorityElement() { 
          if (this.priority == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create CoverageComponent.priority");
            else if (Configuration.doAutoCreate())
              this.priority = new PositiveIntType(); // bb
          return this.priority;
        }

        public boolean hasPriorityElement() { 
          return this.priority != null && !this.priority.isEmpty();
        }

        public boolean hasPriority() { 
          return this.priority != null && !this.priority.isEmpty();
        }

        /**
         * @param value {@link #priority} (The priority of the coverage in the context of this account.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
         */
        public CoverageComponent setPriorityElement(PositiveIntType value) { 
          this.priority = value;
          return this;
        }

        /**
         * @return The priority of the coverage in the context of this account.
         */
        public int getPriority() { 
          return this.priority == null || this.priority.isEmpty() ? 0 : this.priority.getValue();
        }

        /**
         * @param value The priority of the coverage in the context of this account.
         */
        public CoverageComponent setPriority(int value) { 
            if (this.priority == null)
              this.priority = new PositiveIntType();
            this.priority.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("coverage", "Reference(Coverage)", "The party(s) that contribute to payment (or part of) of the charges applied to this account (including self-pay).\n\nA coverage may only be responsible for specific types of charges, and the sequence of the coverages in the account could be important when processing billing.", 0, 1, coverage));
          children.add(new Property("priority", "positiveInt", "The priority of the coverage in the context of this account.", 0, 1, priority));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -351767064: /*coverage*/  return new Property("coverage", "Reference(Coverage)", "The party(s) that contribute to payment (or part of) of the charges applied to this account (including self-pay).\n\nA coverage may only be responsible for specific types of charges, and the sequence of the coverages in the account could be important when processing billing.", 0, 1, coverage);
          case -1165461084: /*priority*/  return new Property("priority", "positiveInt", "The priority of the coverage in the context of this account.", 0, 1, priority);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -351767064: /*coverage*/ return this.coverage == null ? new Base[0] : new Base[] {this.coverage}; // Reference
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // PositiveIntType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -351767064: // coverage
          this.coverage = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1165461084: // priority
          this.priority = TypeConvertor.castToPositiveInt(value); // PositiveIntType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("coverage")) {
          this.coverage = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("priority")) {
          this.priority = TypeConvertor.castToPositiveInt(value); // PositiveIntType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -351767064:  return getCoverage();
        case -1165461084:  return getPriorityElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -351767064: /*coverage*/ return new String[] {"Reference"};
        case -1165461084: /*priority*/ return new String[] {"positiveInt"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("coverage")) {
          this.coverage = new Reference();
          return this.coverage;
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type Account.coverage.priority");
        }
        else
          return super.addChild(name);
      }

      public CoverageComponent copy() {
        CoverageComponent dst = new CoverageComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CoverageComponent dst) {
        super.copyValues(dst);
        dst.coverage = coverage == null ? null : coverage.copy();
        dst.priority = priority == null ? null : priority.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CoverageComponent))
          return false;
        CoverageComponent o = (CoverageComponent) other_;
        return compareDeep(coverage, o.coverage, true) && compareDeep(priority, o.priority, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CoverageComponent))
          return false;
        CoverageComponent o = (CoverageComponent) other_;
        return compareValues(priority, o.priority, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(coverage, priority);
      }

  public String fhirType() {
    return "Account.coverage";

  }

  }

    @Block()
    public static class GuarantorComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The entity who is responsible.
         */
        @Child(name = "party", type = {Patient.class, RelatedPerson.class, Organization.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Responsible entity", formalDefinition="The entity who is responsible." )
        protected Reference party;

        /**
         * A guarantor may be placed on credit hold or otherwise have their role temporarily suspended.
         */
        @Child(name = "onHold", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Credit or other hold applied", formalDefinition="A guarantor may be placed on credit hold or otherwise have their role temporarily suspended." )
        protected BooleanType onHold;

        /**
         * The timeframe during which the guarantor accepts responsibility for the account.
         */
        @Child(name = "period", type = {Period.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Guarantee account during", formalDefinition="The timeframe during which the guarantor accepts responsibility for the account." )
        protected Period period;

        private static final long serialVersionUID = -523056773L;

    /**
     * Constructor
     */
      public GuarantorComponent() {
        super();
      }

    /**
     * Constructor
     */
      public GuarantorComponent(Reference party) {
        super();
        this.setParty(party);
      }

        /**
         * @return {@link #party} (The entity who is responsible.)
         */
        public Reference getParty() { 
          if (this.party == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GuarantorComponent.party");
            else if (Configuration.doAutoCreate())
              this.party = new Reference(); // cc
          return this.party;
        }

        public boolean hasParty() { 
          return this.party != null && !this.party.isEmpty();
        }

        /**
         * @param value {@link #party} (The entity who is responsible.)
         */
        public GuarantorComponent setParty(Reference value) { 
          this.party = value;
          return this;
        }

        /**
         * @return {@link #onHold} (A guarantor may be placed on credit hold or otherwise have their role temporarily suspended.). This is the underlying object with id, value and extensions. The accessor "getOnHold" gives direct access to the value
         */
        public BooleanType getOnHoldElement() { 
          if (this.onHold == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GuarantorComponent.onHold");
            else if (Configuration.doAutoCreate())
              this.onHold = new BooleanType(); // bb
          return this.onHold;
        }

        public boolean hasOnHoldElement() { 
          return this.onHold != null && !this.onHold.isEmpty();
        }

        public boolean hasOnHold() { 
          return this.onHold != null && !this.onHold.isEmpty();
        }

        /**
         * @param value {@link #onHold} (A guarantor may be placed on credit hold or otherwise have their role temporarily suspended.). This is the underlying object with id, value and extensions. The accessor "getOnHold" gives direct access to the value
         */
        public GuarantorComponent setOnHoldElement(BooleanType value) { 
          this.onHold = value;
          return this;
        }

        /**
         * @return A guarantor may be placed on credit hold or otherwise have their role temporarily suspended.
         */
        public boolean getOnHold() { 
          return this.onHold == null || this.onHold.isEmpty() ? false : this.onHold.getValue();
        }

        /**
         * @param value A guarantor may be placed on credit hold or otherwise have their role temporarily suspended.
         */
        public GuarantorComponent setOnHold(boolean value) { 
            if (this.onHold == null)
              this.onHold = new BooleanType();
            this.onHold.setValue(value);
          return this;
        }

        /**
         * @return {@link #period} (The timeframe during which the guarantor accepts responsibility for the account.)
         */
        public Period getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create GuarantorComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Period(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (The timeframe during which the guarantor accepts responsibility for the account.)
         */
        public GuarantorComponent setPeriod(Period value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("party", "Reference(Patient|RelatedPerson|Organization)", "The entity who is responsible.", 0, 1, party));
          children.add(new Property("onHold", "boolean", "A guarantor may be placed on credit hold or otherwise have their role temporarily suspended.", 0, 1, onHold));
          children.add(new Property("period", "Period", "The timeframe during which the guarantor accepts responsibility for the account.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 106437350: /*party*/  return new Property("party", "Reference(Patient|RelatedPerson|Organization)", "The entity who is responsible.", 0, 1, party);
          case -1013289154: /*onHold*/  return new Property("onHold", "boolean", "A guarantor may be placed on credit hold or otherwise have their role temporarily suspended.", 0, 1, onHold);
          case -991726143: /*period*/  return new Property("period", "Period", "The timeframe during which the guarantor accepts responsibility for the account.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 106437350: /*party*/ return this.party == null ? new Base[0] : new Base[] {this.party}; // Reference
        case -1013289154: /*onHold*/ return this.onHold == null ? new Base[0] : new Base[] {this.onHold}; // BooleanType
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 106437350: // party
          this.party = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1013289154: // onHold
          this.onHold = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("party")) {
          this.party = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("onHold")) {
          this.onHold = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106437350:  return getParty();
        case -1013289154:  return getOnHoldElement();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 106437350: /*party*/ return new String[] {"Reference"};
        case -1013289154: /*onHold*/ return new String[] {"boolean"};
        case -991726143: /*period*/ return new String[] {"Period"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("party")) {
          this.party = new Reference();
          return this.party;
        }
        else if (name.equals("onHold")) {
          throw new FHIRException("Cannot call addChild on a primitive type Account.guarantor.onHold");
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public GuarantorComponent copy() {
        GuarantorComponent dst = new GuarantorComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(GuarantorComponent dst) {
        super.copyValues(dst);
        dst.party = party == null ? null : party.copy();
        dst.onHold = onHold == null ? null : onHold.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof GuarantorComponent))
          return false;
        GuarantorComponent o = (GuarantorComponent) other_;
        return compareDeep(party, o.party, true) && compareDeep(onHold, o.onHold, true) && compareDeep(period, o.period, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof GuarantorComponent))
          return false;
        GuarantorComponent o = (GuarantorComponent) other_;
        return compareValues(onHold, o.onHold, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(party, onHold, period);
      }

  public String fhirType() {
    return "Account.guarantor";

  }

  }

    /**
     * Unique identifier used to reference the account.  Might or might not be intended for human use (e.g. credit card number).
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Account number", formalDefinition="Unique identifier used to reference the account.  Might or might not be intended for human use (e.g. credit card number)." )
    protected List<Identifier> identifier;

    /**
     * Indicates whether the account is presently used/usable or not.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | inactive | entered-in-error | on-hold | unknown", formalDefinition="Indicates whether the account is presently used/usable or not." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/account-status")
    protected Enumeration<AccountStatus> status;

    /**
     * The BillingStatus tracks the lifecycle of the account through the billing process. It indicates how transactions are treated when they are allocated to the account.
     */
    @Child(name = "billingStatus", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Tracks the lifecycle of the account through the billing process", formalDefinition="The BillingStatus tracks the lifecycle of the account through the billing process. It indicates how transactions are treated when they are allocated to the account." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/account-billing-status")
    protected CodeableConcept billingStatus;

    /**
     * Categorizes the account for reporting and searching purposes.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="E.g. patient, expense, depreciation", formalDefinition="Categorizes the account for reporting and searching purposes." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/account-type")
    protected CodeableConcept type;

    /**
     * Name used for the account when displaying it to humans in reports, etc.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Human-readable label", formalDefinition="Name used for the account when displaying it to humans in reports, etc." )
    protected StringType name;

    /**
     * Identifies the entity which incurs the expenses. While the immediate recipients of services or goods might be entities related to the subject, the expenses were ultimately incurred by the subject of the Account.
     */
    @Child(name = "subject", type = {Patient.class, Device.class, Practitioner.class, PractitionerRole.class, Location.class, HealthcareService.class, Organization.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The entity that caused the expenses", formalDefinition="Identifies the entity which incurs the expenses. While the immediate recipients of services or goods might be entities related to the subject, the expenses were ultimately incurred by the subject of the Account." )
    protected List<Reference> subject;

    /**
     * The date range of services associated with this account.
     */
    @Child(name = "servicePeriod", type = {Period.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Transaction window", formalDefinition="The date range of services associated with this account." )
    protected Period servicePeriod;

    /**
     * The party(s) that are responsible for covering the payment of this account, and what order should they be applied to the account.
     */
    @Child(name = "coverage", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The party(s) that are responsible for covering the payment of this account, and what order should they be applied to the account", formalDefinition="The party(s) that are responsible for covering the payment of this account, and what order should they be applied to the account." )
    protected List<CoverageComponent> coverage;

    /**
     * Indicates the service area, hospital, department, etc. with responsibility for managing the Account.
     */
    @Child(name = "owner", type = {Organization.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Entity managing the Account", formalDefinition="Indicates the service area, hospital, department, etc. with responsibility for managing the Account." )
    protected Reference owner;

    /**
     * Provides additional information about what the account tracks and how it is used.
     */
    @Child(name = "description", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Explanation of purpose/use", formalDefinition="Provides additional information about what the account tracks and how it is used." )
    protected StringType description;

    /**
     * The parties responsible for balancing the account if other payment options fall short.
     */
    @Child(name = "guarantor", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The parties ultimately responsible for balancing the Account", formalDefinition="The parties responsible for balancing the account if other payment options fall short." )
    protected List<GuarantorComponent> guarantor;

    /**
     * Reference to a parent Account.
     */
    @Child(name = "partOf", type = {Account.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to a parent Account", formalDefinition="Reference to a parent Account." )
    protected Reference partOf;

    private static final long serialVersionUID = 1419356403L;

  /**
   * Constructor
   */
    public Account() {
      super();
    }

  /**
   * Constructor
   */
    public Account(AccountStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #identifier} (Unique identifier used to reference the account.  Might or might not be intended for human use (e.g. credit card number).)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Account setIdentifier(List<Identifier> theIdentifier) { 
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

    public Account addIdentifier(Identifier t) { //3
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
     * @return {@link #status} (Indicates whether the account is presently used/usable or not.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<AccountStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Account.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<AccountStatus>(new AccountStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Indicates whether the account is presently used/usable or not.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Account setStatusElement(Enumeration<AccountStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return Indicates whether the account is presently used/usable or not.
     */
    public AccountStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value Indicates whether the account is presently used/usable or not.
     */
    public Account setStatus(AccountStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<AccountStatus>(new AccountStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #billingStatus} (The BillingStatus tracks the lifecycle of the account through the billing process. It indicates how transactions are treated when they are allocated to the account.)
     */
    public CodeableConcept getBillingStatus() { 
      if (this.billingStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Account.billingStatus");
        else if (Configuration.doAutoCreate())
          this.billingStatus = new CodeableConcept(); // cc
      return this.billingStatus;
    }

    public boolean hasBillingStatus() { 
      return this.billingStatus != null && !this.billingStatus.isEmpty();
    }

    /**
     * @param value {@link #billingStatus} (The BillingStatus tracks the lifecycle of the account through the billing process. It indicates how transactions are treated when they are allocated to the account.)
     */
    public Account setBillingStatus(CodeableConcept value) { 
      this.billingStatus = value;
      return this;
    }

    /**
     * @return {@link #type} (Categorizes the account for reporting and searching purposes.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Account.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Categorizes the account for reporting and searching purposes.)
     */
    public Account setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #name} (Name used for the account when displaying it to humans in reports, etc.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Account.name");
        else if (Configuration.doAutoCreate())
          this.name = new StringType(); // bb
      return this.name;
    }

    public boolean hasNameElement() { 
      return this.name != null && !this.name.isEmpty();
    }

    public boolean hasName() { 
      return this.name != null && !this.name.isEmpty();
    }

    /**
     * @param value {@link #name} (Name used for the account when displaying it to humans in reports, etc.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public Account setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return Name used for the account when displaying it to humans in reports, etc.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value Name used for the account when displaying it to humans in reports, etc.
     */
    public Account setName(String value) { 
      if (Utilities.noString(value))
        this.name = null;
      else {
        if (this.name == null)
          this.name = new StringType();
        this.name.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #subject} (Identifies the entity which incurs the expenses. While the immediate recipients of services or goods might be entities related to the subject, the expenses were ultimately incurred by the subject of the Account.)
     */
    public List<Reference> getSubject() { 
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      return this.subject;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Account setSubject(List<Reference> theSubject) { 
      this.subject = theSubject;
      return this;
    }

    public boolean hasSubject() { 
      if (this.subject == null)
        return false;
      for (Reference item : this.subject)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSubject() { //3
      Reference t = new Reference();
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      this.subject.add(t);
      return t;
    }

    public Account addSubject(Reference t) { //3
      if (t == null)
        return this;
      if (this.subject == null)
        this.subject = new ArrayList<Reference>();
      this.subject.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #subject}, creating it if it does not already exist {3}
     */
    public Reference getSubjectFirstRep() { 
      if (getSubject().isEmpty()) {
        addSubject();
      }
      return getSubject().get(0);
    }

    /**
     * @return {@link #servicePeriod} (The date range of services associated with this account.)
     */
    public Period getServicePeriod() { 
      if (this.servicePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Account.servicePeriod");
        else if (Configuration.doAutoCreate())
          this.servicePeriod = new Period(); // cc
      return this.servicePeriod;
    }

    public boolean hasServicePeriod() { 
      return this.servicePeriod != null && !this.servicePeriod.isEmpty();
    }

    /**
     * @param value {@link #servicePeriod} (The date range of services associated with this account.)
     */
    public Account setServicePeriod(Period value) { 
      this.servicePeriod = value;
      return this;
    }

    /**
     * @return {@link #coverage} (The party(s) that are responsible for covering the payment of this account, and what order should they be applied to the account.)
     */
    public List<CoverageComponent> getCoverage() { 
      if (this.coverage == null)
        this.coverage = new ArrayList<CoverageComponent>();
      return this.coverage;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Account setCoverage(List<CoverageComponent> theCoverage) { 
      this.coverage = theCoverage;
      return this;
    }

    public boolean hasCoverage() { 
      if (this.coverage == null)
        return false;
      for (CoverageComponent item : this.coverage)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CoverageComponent addCoverage() { //3
      CoverageComponent t = new CoverageComponent();
      if (this.coverage == null)
        this.coverage = new ArrayList<CoverageComponent>();
      this.coverage.add(t);
      return t;
    }

    public Account addCoverage(CoverageComponent t) { //3
      if (t == null)
        return this;
      if (this.coverage == null)
        this.coverage = new ArrayList<CoverageComponent>();
      this.coverage.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #coverage}, creating it if it does not already exist {3}
     */
    public CoverageComponent getCoverageFirstRep() { 
      if (getCoverage().isEmpty()) {
        addCoverage();
      }
      return getCoverage().get(0);
    }

    /**
     * @return {@link #owner} (Indicates the service area, hospital, department, etc. with responsibility for managing the Account.)
     */
    public Reference getOwner() { 
      if (this.owner == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Account.owner");
        else if (Configuration.doAutoCreate())
          this.owner = new Reference(); // cc
      return this.owner;
    }

    public boolean hasOwner() { 
      return this.owner != null && !this.owner.isEmpty();
    }

    /**
     * @param value {@link #owner} (Indicates the service area, hospital, department, etc. with responsibility for managing the Account.)
     */
    public Account setOwner(Reference value) { 
      this.owner = value;
      return this;
    }

    /**
     * @return {@link #description} (Provides additional information about what the account tracks and how it is used.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Account.description");
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
     * @param value {@link #description} (Provides additional information about what the account tracks and how it is used.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Account setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Provides additional information about what the account tracks and how it is used.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Provides additional information about what the account tracks and how it is used.
     */
    public Account setDescription(String value) { 
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
     * @return {@link #guarantor} (The parties responsible for balancing the account if other payment options fall short.)
     */
    public List<GuarantorComponent> getGuarantor() { 
      if (this.guarantor == null)
        this.guarantor = new ArrayList<GuarantorComponent>();
      return this.guarantor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Account setGuarantor(List<GuarantorComponent> theGuarantor) { 
      this.guarantor = theGuarantor;
      return this;
    }

    public boolean hasGuarantor() { 
      if (this.guarantor == null)
        return false;
      for (GuarantorComponent item : this.guarantor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public GuarantorComponent addGuarantor() { //3
      GuarantorComponent t = new GuarantorComponent();
      if (this.guarantor == null)
        this.guarantor = new ArrayList<GuarantorComponent>();
      this.guarantor.add(t);
      return t;
    }

    public Account addGuarantor(GuarantorComponent t) { //3
      if (t == null)
        return this;
      if (this.guarantor == null)
        this.guarantor = new ArrayList<GuarantorComponent>();
      this.guarantor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #guarantor}, creating it if it does not already exist {3}
     */
    public GuarantorComponent getGuarantorFirstRep() { 
      if (getGuarantor().isEmpty()) {
        addGuarantor();
      }
      return getGuarantor().get(0);
    }

    /**
     * @return {@link #partOf} (Reference to a parent Account.)
     */
    public Reference getPartOf() { 
      if (this.partOf == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Account.partOf");
        else if (Configuration.doAutoCreate())
          this.partOf = new Reference(); // cc
      return this.partOf;
    }

    public boolean hasPartOf() { 
      return this.partOf != null && !this.partOf.isEmpty();
    }

    /**
     * @param value {@link #partOf} (Reference to a parent Account.)
     */
    public Account setPartOf(Reference value) { 
      this.partOf = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique identifier used to reference the account.  Might or might not be intended for human use (e.g. credit card number).", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "Indicates whether the account is presently used/usable or not.", 0, 1, status));
        children.add(new Property("billingStatus", "CodeableConcept", "The BillingStatus tracks the lifecycle of the account through the billing process. It indicates how transactions are treated when they are allocated to the account.", 0, 1, billingStatus));
        children.add(new Property("type", "CodeableConcept", "Categorizes the account for reporting and searching purposes.", 0, 1, type));
        children.add(new Property("name", "string", "Name used for the account when displaying it to humans in reports, etc.", 0, 1, name));
        children.add(new Property("subject", "Reference(Patient|Device|Practitioner|PractitionerRole|Location|HealthcareService|Organization)", "Identifies the entity which incurs the expenses. While the immediate recipients of services or goods might be entities related to the subject, the expenses were ultimately incurred by the subject of the Account.", 0, java.lang.Integer.MAX_VALUE, subject));
        children.add(new Property("servicePeriod", "Period", "The date range of services associated with this account.", 0, 1, servicePeriod));
        children.add(new Property("coverage", "", "The party(s) that are responsible for covering the payment of this account, and what order should they be applied to the account.", 0, java.lang.Integer.MAX_VALUE, coverage));
        children.add(new Property("owner", "Reference(Organization)", "Indicates the service area, hospital, department, etc. with responsibility for managing the Account.", 0, 1, owner));
        children.add(new Property("description", "string", "Provides additional information about what the account tracks and how it is used.", 0, 1, description));
        children.add(new Property("guarantor", "", "The parties responsible for balancing the account if other payment options fall short.", 0, java.lang.Integer.MAX_VALUE, guarantor));
        children.add(new Property("partOf", "Reference(Account)", "Reference to a parent Account.", 0, 1, partOf));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique identifier used to reference the account.  Might or might not be intended for human use (e.g. credit card number).", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "Indicates whether the account is presently used/usable or not.", 0, 1, status);
        case -1524378035: /*billingStatus*/  return new Property("billingStatus", "CodeableConcept", "The BillingStatus tracks the lifecycle of the account through the billing process. It indicates how transactions are treated when they are allocated to the account.", 0, 1, billingStatus);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Categorizes the account for reporting and searching purposes.", 0, 1, type);
        case 3373707: /*name*/  return new Property("name", "string", "Name used for the account when displaying it to humans in reports, etc.", 0, 1, name);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Device|Practitioner|PractitionerRole|Location|HealthcareService|Organization)", "Identifies the entity which incurs the expenses. While the immediate recipients of services or goods might be entities related to the subject, the expenses were ultimately incurred by the subject of the Account.", 0, java.lang.Integer.MAX_VALUE, subject);
        case 2129104086: /*servicePeriod*/  return new Property("servicePeriod", "Period", "The date range of services associated with this account.", 0, 1, servicePeriod);
        case -351767064: /*coverage*/  return new Property("coverage", "", "The party(s) that are responsible for covering the payment of this account, and what order should they be applied to the account.", 0, java.lang.Integer.MAX_VALUE, coverage);
        case 106164915: /*owner*/  return new Property("owner", "Reference(Organization)", "Indicates the service area, hospital, department, etc. with responsibility for managing the Account.", 0, 1, owner);
        case -1724546052: /*description*/  return new Property("description", "string", "Provides additional information about what the account tracks and how it is used.", 0, 1, description);
        case -188629045: /*guarantor*/  return new Property("guarantor", "", "The parties responsible for balancing the account if other payment options fall short.", 0, java.lang.Integer.MAX_VALUE, guarantor);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(Account)", "Reference to a parent Account.", 0, 1, partOf);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<AccountStatus>
        case -1524378035: /*billingStatus*/ return this.billingStatus == null ? new Base[0] : new Base[] {this.billingStatus}; // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : this.subject.toArray(new Base[this.subject.size()]); // Reference
        case 2129104086: /*servicePeriod*/ return this.servicePeriod == null ? new Base[0] : new Base[] {this.servicePeriod}; // Period
        case -351767064: /*coverage*/ return this.coverage == null ? new Base[0] : this.coverage.toArray(new Base[this.coverage.size()]); // CoverageComponent
        case 106164915: /*owner*/ return this.owner == null ? new Base[0] : new Base[] {this.owner}; // Reference
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -188629045: /*guarantor*/ return this.guarantor == null ? new Base[0] : this.guarantor.toArray(new Base[this.guarantor.size()]); // GuarantorComponent
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : new Base[] {this.partOf}; // Reference
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
          value = new AccountStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<AccountStatus>
          return value;
        case -1524378035: // billingStatus
          this.billingStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case -1867885268: // subject
          this.getSubject().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 2129104086: // servicePeriod
          this.servicePeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case -351767064: // coverage
          this.getCoverage().add((CoverageComponent) value); // CoverageComponent
          return value;
        case 106164915: // owner
          this.owner = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -188629045: // guarantor
          this.getGuarantor().add((GuarantorComponent) value); // GuarantorComponent
          return value;
        case -995410646: // partOf
          this.partOf = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new AccountStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<AccountStatus>
        } else if (name.equals("billingStatus")) {
          this.billingStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subject")) {
          this.getSubject().add(TypeConvertor.castToReference(value));
        } else if (name.equals("servicePeriod")) {
          this.servicePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("coverage")) {
          this.getCoverage().add((CoverageComponent) value);
        } else if (name.equals("owner")) {
          this.owner = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("guarantor")) {
          this.getGuarantor().add((GuarantorComponent) value);
        } else if (name.equals("partOf")) {
          this.partOf = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -1524378035:  return getBillingStatus();
        case 3575610:  return getType();
        case 3373707:  return getNameElement();
        case -1867885268:  return addSubject(); 
        case 2129104086:  return getServicePeriod();
        case -351767064:  return addCoverage(); 
        case 106164915:  return getOwner();
        case -1724546052:  return getDescriptionElement();
        case -188629045:  return addGuarantor(); 
        case -995410646:  return getPartOf();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1524378035: /*billingStatus*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 2129104086: /*servicePeriod*/ return new String[] {"Period"};
        case -351767064: /*coverage*/ return new String[] {};
        case 106164915: /*owner*/ return new String[] {"Reference"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -188629045: /*guarantor*/ return new String[] {};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Account.status");
        }
        else if (name.equals("billingStatus")) {
          this.billingStatus = new CodeableConcept();
          return this.billingStatus;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type Account.name");
        }
        else if (name.equals("subject")) {
          return addSubject();
        }
        else if (name.equals("servicePeriod")) {
          this.servicePeriod = new Period();
          return this.servicePeriod;
        }
        else if (name.equals("coverage")) {
          return addCoverage();
        }
        else if (name.equals("owner")) {
          this.owner = new Reference();
          return this.owner;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Account.description");
        }
        else if (name.equals("guarantor")) {
          return addGuarantor();
        }
        else if (name.equals("partOf")) {
          this.partOf = new Reference();
          return this.partOf;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Account";

  }

      public Account copy() {
        Account dst = new Account();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Account dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.billingStatus = billingStatus == null ? null : billingStatus.copy();
        dst.type = type == null ? null : type.copy();
        dst.name = name == null ? null : name.copy();
        if (subject != null) {
          dst.subject = new ArrayList<Reference>();
          for (Reference i : subject)
            dst.subject.add(i.copy());
        };
        dst.servicePeriod = servicePeriod == null ? null : servicePeriod.copy();
        if (coverage != null) {
          dst.coverage = new ArrayList<CoverageComponent>();
          for (CoverageComponent i : coverage)
            dst.coverage.add(i.copy());
        };
        dst.owner = owner == null ? null : owner.copy();
        dst.description = description == null ? null : description.copy();
        if (guarantor != null) {
          dst.guarantor = new ArrayList<GuarantorComponent>();
          for (GuarantorComponent i : guarantor)
            dst.guarantor.add(i.copy());
        };
        dst.partOf = partOf == null ? null : partOf.copy();
      }

      protected Account typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Account))
          return false;
        Account o = (Account) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(billingStatus, o.billingStatus, true)
           && compareDeep(type, o.type, true) && compareDeep(name, o.name, true) && compareDeep(subject, o.subject, true)
           && compareDeep(servicePeriod, o.servicePeriod, true) && compareDeep(coverage, o.coverage, true)
           && compareDeep(owner, o.owner, true) && compareDeep(description, o.description, true) && compareDeep(guarantor, o.guarantor, true)
           && compareDeep(partOf, o.partOf, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Account))
          return false;
        Account o = (Account) other_;
        return compareValues(status, o.status, true) && compareValues(name, o.name, true) && compareValues(description, o.description, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, billingStatus
          , type, name, subject, servicePeriod, coverage, owner, description, guarantor
          , partOf);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Account;
   }


}

