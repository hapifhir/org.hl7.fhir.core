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

import java.util.*;

import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.r4.model.Enumerations.*;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.api.annotation.SearchParamDefinition;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.ChildOrder;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Block;
import org.hl7.fhir.instance.model.api.*;
import org.hl7.fhir.exceptions.FHIRException;
/**
 * This resource provides eligibility and plan details from the processing of an CoverageEligibilityRequest resource.
 */
@ResourceDef(name="CoverageEligibilityResponse", profile="http://hl7.org/fhir/StructureDefinition/CoverageEligibilityResponse")
public class CoverageEligibilityResponse extends DomainResource {

    public enum EligibilityResponseStatus {
        /**
         * The instance is currently in-force.
         */
        ACTIVE, 
        /**
         * The instance is withdrawn, rescinded or reversed.
         */
        CANCELLED, 
        /**
         * A new instance the contents of which is not complete.
         */
        DRAFT, 
        /**
         * The instance was entered in error.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static EligibilityResponseStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("cancelled".equals(codeString))
          return CANCELLED;
        if ("draft".equals(codeString))
          return DRAFT;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown EligibilityResponseStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case CANCELLED: return "cancelled";
            case DRAFT: return "draft";
            case ENTEREDINERROR: return "entered-in-error";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/fm-status";
            case CANCELLED: return "http://hl7.org/fhir/fm-status";
            case DRAFT: return "http://hl7.org/fhir/fm-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/fm-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The instance is currently in-force.";
            case CANCELLED: return "The instance is withdrawn, rescinded or reversed.";
            case DRAFT: return "A new instance the contents of which is not complete.";
            case ENTEREDINERROR: return "The instance was entered in error.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case CANCELLED: return "Cancelled";
            case DRAFT: return "Draft";
            case ENTEREDINERROR: return "Entered in Error";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class EligibilityResponseStatusEnumFactory implements EnumFactory<EligibilityResponseStatus> {
    public EligibilityResponseStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return EligibilityResponseStatus.ACTIVE;
        if ("cancelled".equals(codeString))
          return EligibilityResponseStatus.CANCELLED;
        if ("draft".equals(codeString))
          return EligibilityResponseStatus.DRAFT;
        if ("entered-in-error".equals(codeString))
          return EligibilityResponseStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown EligibilityResponseStatus code '"+codeString+"'");
        }
        public Enumeration<EligibilityResponseStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EligibilityResponseStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<EligibilityResponseStatus>(this, EligibilityResponseStatus.ACTIVE);
        if ("cancelled".equals(codeString))
          return new Enumeration<EligibilityResponseStatus>(this, EligibilityResponseStatus.CANCELLED);
        if ("draft".equals(codeString))
          return new Enumeration<EligibilityResponseStatus>(this, EligibilityResponseStatus.DRAFT);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<EligibilityResponseStatus>(this, EligibilityResponseStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown EligibilityResponseStatus code '"+codeString+"'");
        }
    public String toCode(EligibilityResponseStatus code) {
      if (code == EligibilityResponseStatus.ACTIVE)
        return "active";
      if (code == EligibilityResponseStatus.CANCELLED)
        return "cancelled";
      if (code == EligibilityResponseStatus.DRAFT)
        return "draft";
      if (code == EligibilityResponseStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(EligibilityResponseStatus code) {
      return code.getSystem();
      }
    }

    public enum EligibilityResponsePurpose {
        /**
         * The prior authorization requirements for the listed, or discovered if specified, converages for the categories of service and/or specifed biling codes are requested.
         */
        AUTHREQUIREMENTS, 
        /**
         * The plan benefits and optionally benefits consumed  for the listed, or discovered if specified, converages are requested.
         */
        BENEFITS, 
        /**
         * The insurer is requested to report on any coverages which they are aware of in addition to any specifed.
         */
        DISCOVERY, 
        /**
         * A check that the specified coverages are in-force is requested.
         */
        VALIDATION, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static EligibilityResponsePurpose fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("auth-requirements".equals(codeString))
          return AUTHREQUIREMENTS;
        if ("benefits".equals(codeString))
          return BENEFITS;
        if ("discovery".equals(codeString))
          return DISCOVERY;
        if ("validation".equals(codeString))
          return VALIDATION;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown EligibilityResponsePurpose code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case AUTHREQUIREMENTS: return "auth-requirements";
            case BENEFITS: return "benefits";
            case DISCOVERY: return "discovery";
            case VALIDATION: return "validation";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case AUTHREQUIREMENTS: return "http://hl7.org/fhir/eligibilityresponse-purpose";
            case BENEFITS: return "http://hl7.org/fhir/eligibilityresponse-purpose";
            case DISCOVERY: return "http://hl7.org/fhir/eligibilityresponse-purpose";
            case VALIDATION: return "http://hl7.org/fhir/eligibilityresponse-purpose";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case AUTHREQUIREMENTS: return "The prior authorization requirements for the listed, or discovered if specified, converages for the categories of service and/or specifed biling codes are requested.";
            case BENEFITS: return "The plan benefits and optionally benefits consumed  for the listed, or discovered if specified, converages are requested.";
            case DISCOVERY: return "The insurer is requested to report on any coverages which they are aware of in addition to any specifed.";
            case VALIDATION: return "A check that the specified coverages are in-force is requested.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case AUTHREQUIREMENTS: return "Coverage auth-requirements";
            case BENEFITS: return "Coverage benefits";
            case DISCOVERY: return "Coverage Discovery";
            case VALIDATION: return "Coverage Validation";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class EligibilityResponsePurposeEnumFactory implements EnumFactory<EligibilityResponsePurpose> {
    public EligibilityResponsePurpose fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("auth-requirements".equals(codeString))
          return EligibilityResponsePurpose.AUTHREQUIREMENTS;
        if ("benefits".equals(codeString))
          return EligibilityResponsePurpose.BENEFITS;
        if ("discovery".equals(codeString))
          return EligibilityResponsePurpose.DISCOVERY;
        if ("validation".equals(codeString))
          return EligibilityResponsePurpose.VALIDATION;
        throw new IllegalArgumentException("Unknown EligibilityResponsePurpose code '"+codeString+"'");
        }
        public Enumeration<EligibilityResponsePurpose> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<EligibilityResponsePurpose>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("auth-requirements".equals(codeString))
          return new Enumeration<EligibilityResponsePurpose>(this, EligibilityResponsePurpose.AUTHREQUIREMENTS);
        if ("benefits".equals(codeString))
          return new Enumeration<EligibilityResponsePurpose>(this, EligibilityResponsePurpose.BENEFITS);
        if ("discovery".equals(codeString))
          return new Enumeration<EligibilityResponsePurpose>(this, EligibilityResponsePurpose.DISCOVERY);
        if ("validation".equals(codeString))
          return new Enumeration<EligibilityResponsePurpose>(this, EligibilityResponsePurpose.VALIDATION);
        throw new FHIRException("Unknown EligibilityResponsePurpose code '"+codeString+"'");
        }
    public String toCode(EligibilityResponsePurpose code) {
      if (code == EligibilityResponsePurpose.AUTHREQUIREMENTS)
        return "auth-requirements";
      if (code == EligibilityResponsePurpose.BENEFITS)
        return "benefits";
      if (code == EligibilityResponsePurpose.DISCOVERY)
        return "discovery";
      if (code == EligibilityResponsePurpose.VALIDATION)
        return "validation";
      return "?";
      }
    public String toSystem(EligibilityResponsePurpose code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class InsuranceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer will use these details to locate the patient's actual coverage within the insurer's information system.
         */
        @Child(name = "coverage", type = {Coverage.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Insurance information", formalDefinition="Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer will use these details to locate the patient's actual coverage within the insurer's information system." )
        protected Reference coverage;

        /**
         * The actual object that is the target of the reference (Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer will use these details to locate the patient's actual coverage within the insurer's information system.)
         */
        protected Coverage coverageTarget;

        /**
         * Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole duration of the service dates.
         */
        @Child(name = "inforce", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Coverage inforce indicator", formalDefinition="Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole duration of the service dates." )
        protected BooleanType inforce;

        /**
         * The term of the benefits documented in this response.
         */
        @Child(name = "benefitPeriod", type = {Period.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the benefits are applicable", formalDefinition="The term of the benefits documented in this response." )
        protected Period benefitPeriod;

        /**
         * Benefits and optionally current balances, and authorization details by category or service.
         */
        @Child(name = "item", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Benefits and authorization details", formalDefinition="Benefits and optionally current balances, and authorization details by category or service." )
        protected List<ItemsComponent> item;

        private static final long serialVersionUID = -567336701L;

    /**
     * Constructor
     */
      public InsuranceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public InsuranceComponent(Reference coverage) {
        super();
        this.coverage = coverage;
      }

        /**
         * @return {@link #coverage} (Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer will use these details to locate the patient's actual coverage within the insurer's information system.)
         */
        public Reference getCoverage() { 
          if (this.coverage == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InsuranceComponent.coverage");
            else if (Configuration.doAutoCreate())
              this.coverage = new Reference(); // cc
          return this.coverage;
        }

        public boolean hasCoverage() { 
          return this.coverage != null && !this.coverage.isEmpty();
        }

        /**
         * @param value {@link #coverage} (Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer will use these details to locate the patient's actual coverage within the insurer's information system.)
         */
        public InsuranceComponent setCoverage(Reference value) { 
          this.coverage = value;
          return this;
        }

        /**
         * @return {@link #coverage} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer will use these details to locate the patient's actual coverage within the insurer's information system.)
         */
        public Coverage getCoverageTarget() { 
          if (this.coverageTarget == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InsuranceComponent.coverage");
            else if (Configuration.doAutoCreate())
              this.coverageTarget = new Coverage(); // aa
          return this.coverageTarget;
        }

        /**
         * @param value {@link #coverage} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer will use these details to locate the patient's actual coverage within the insurer's information system.)
         */
        public InsuranceComponent setCoverageTarget(Coverage value) { 
          this.coverageTarget = value;
          return this;
        }

        /**
         * @return {@link #inforce} (Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole duration of the service dates.). This is the underlying object with id, value and extensions. The accessor "getInforce" gives direct access to the value
         */
        public BooleanType getInforceElement() { 
          if (this.inforce == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InsuranceComponent.inforce");
            else if (Configuration.doAutoCreate())
              this.inforce = new BooleanType(); // bb
          return this.inforce;
        }

        public boolean hasInforceElement() { 
          return this.inforce != null && !this.inforce.isEmpty();
        }

        public boolean hasInforce() { 
          return this.inforce != null && !this.inforce.isEmpty();
        }

        /**
         * @param value {@link #inforce} (Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole duration of the service dates.). This is the underlying object with id, value and extensions. The accessor "getInforce" gives direct access to the value
         */
        public InsuranceComponent setInforceElement(BooleanType value) { 
          this.inforce = value;
          return this;
        }

        /**
         * @return Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole duration of the service dates.
         */
        public boolean getInforce() { 
          return this.inforce == null || this.inforce.isEmpty() ? false : this.inforce.getValue();
        }

        /**
         * @param value Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole duration of the service dates.
         */
        public InsuranceComponent setInforce(boolean value) { 
            if (this.inforce == null)
              this.inforce = new BooleanType();
            this.inforce.setValue(value);
          return this;
        }

        /**
         * @return {@link #benefitPeriod} (The term of the benefits documented in this response.)
         */
        public Period getBenefitPeriod() { 
          if (this.benefitPeriod == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create InsuranceComponent.benefitPeriod");
            else if (Configuration.doAutoCreate())
              this.benefitPeriod = new Period(); // cc
          return this.benefitPeriod;
        }

        public boolean hasBenefitPeriod() { 
          return this.benefitPeriod != null && !this.benefitPeriod.isEmpty();
        }

        /**
         * @param value {@link #benefitPeriod} (The term of the benefits documented in this response.)
         */
        public InsuranceComponent setBenefitPeriod(Period value) { 
          this.benefitPeriod = value;
          return this;
        }

        /**
         * @return {@link #item} (Benefits and optionally current balances, and authorization details by category or service.)
         */
        public List<ItemsComponent> getItem() { 
          if (this.item == null)
            this.item = new ArrayList<ItemsComponent>();
          return this.item;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public InsuranceComponent setItem(List<ItemsComponent> theItem) { 
          this.item = theItem;
          return this;
        }

        public boolean hasItem() { 
          if (this.item == null)
            return false;
          for (ItemsComponent item : this.item)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public ItemsComponent addItem() { //3
          ItemsComponent t = new ItemsComponent();
          if (this.item == null)
            this.item = new ArrayList<ItemsComponent>();
          this.item.add(t);
          return t;
        }

        public InsuranceComponent addItem(ItemsComponent t) { //3
          if (t == null)
            return this;
          if (this.item == null)
            this.item = new ArrayList<ItemsComponent>();
          this.item.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #item}, creating it if it does not already exist
         */
        public ItemsComponent getItemFirstRep() { 
          if (getItem().isEmpty()) {
            addItem();
          }
          return getItem().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("coverage", "Reference(Coverage)", "Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer will use these details to locate the patient's actual coverage within the insurer's information system.", 0, 1, coverage));
          children.add(new Property("inforce", "boolean", "Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole duration of the service dates.", 0, 1, inforce));
          children.add(new Property("benefitPeriod", "Period", "The term of the benefits documented in this response.", 0, 1, benefitPeriod));
          children.add(new Property("item", "", "Benefits and optionally current balances, and authorization details by category or service.", 0, java.lang.Integer.MAX_VALUE, item));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -351767064: /*coverage*/  return new Property("coverage", "Reference(Coverage)", "Reference to the insurance card level information contained in the Coverage resource. The coverage issuing insurer will use these details to locate the patient's actual coverage within the insurer's information system.", 0, 1, coverage);
          case 1945431270: /*inforce*/  return new Property("inforce", "boolean", "Flag indicating if the coverage provided is inforce currently if no service date(s) specified or for the whole duration of the service dates.", 0, 1, inforce);
          case -407369416: /*benefitPeriod*/  return new Property("benefitPeriod", "Period", "The term of the benefits documented in this response.", 0, 1, benefitPeriod);
          case 3242771: /*item*/  return new Property("item", "", "Benefits and optionally current balances, and authorization details by category or service.", 0, java.lang.Integer.MAX_VALUE, item);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -351767064: /*coverage*/ return this.coverage == null ? new Base[0] : new Base[] {this.coverage}; // Reference
        case 1945431270: /*inforce*/ return this.inforce == null ? new Base[0] : new Base[] {this.inforce}; // BooleanType
        case -407369416: /*benefitPeriod*/ return this.benefitPeriod == null ? new Base[0] : new Base[] {this.benefitPeriod}; // Period
        case 3242771: /*item*/ return this.item == null ? new Base[0] : this.item.toArray(new Base[this.item.size()]); // ItemsComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -351767064: // coverage
          this.coverage = castToReference(value); // Reference
          return value;
        case 1945431270: // inforce
          this.inforce = castToBoolean(value); // BooleanType
          return value;
        case -407369416: // benefitPeriod
          this.benefitPeriod = castToPeriod(value); // Period
          return value;
        case 3242771: // item
          this.getItem().add((ItemsComponent) value); // ItemsComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("coverage")) {
          this.coverage = castToReference(value); // Reference
        } else if (name.equals("inforce")) {
          this.inforce = castToBoolean(value); // BooleanType
        } else if (name.equals("benefitPeriod")) {
          this.benefitPeriod = castToPeriod(value); // Period
        } else if (name.equals("item")) {
          this.getItem().add((ItemsComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -351767064:  return getCoverage(); 
        case 1945431270:  return getInforceElement();
        case -407369416:  return getBenefitPeriod(); 
        case 3242771:  return addItem(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -351767064: /*coverage*/ return new String[] {"Reference"};
        case 1945431270: /*inforce*/ return new String[] {"boolean"};
        case -407369416: /*benefitPeriod*/ return new String[] {"Period"};
        case 3242771: /*item*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("coverage")) {
          this.coverage = new Reference();
          return this.coverage;
        }
        else if (name.equals("inforce")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.inforce");
        }
        else if (name.equals("benefitPeriod")) {
          this.benefitPeriod = new Period();
          return this.benefitPeriod;
        }
        else if (name.equals("item")) {
          return addItem();
        }
        else
          return super.addChild(name);
      }

      public InsuranceComponent copy() {
        InsuranceComponent dst = new InsuranceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(InsuranceComponent dst) {
        super.copyValues(dst);
        dst.coverage = coverage == null ? null : coverage.copy();
        dst.inforce = inforce == null ? null : inforce.copy();
        dst.benefitPeriod = benefitPeriod == null ? null : benefitPeriod.copy();
        if (item != null) {
          dst.item = new ArrayList<ItemsComponent>();
          for (ItemsComponent i : item)
            dst.item.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof InsuranceComponent))
          return false;
        InsuranceComponent o = (InsuranceComponent) other_;
        return compareDeep(coverage, o.coverage, true) && compareDeep(inforce, o.inforce, true) && compareDeep(benefitPeriod, o.benefitPeriod, true)
           && compareDeep(item, o.item, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof InsuranceComponent))
          return false;
        InsuranceComponent o = (InsuranceComponent) other_;
        return compareValues(inforce, o.inforce, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(coverage, inforce, benefitPeriod
          , item);
      }

  public String fhirType() {
    return "CoverageEligibilityResponse.insurance";

  }

  }

    @Block()
    public static class ItemsComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code to identify the general type of benefits under which products and services are provided.
         */
        @Child(name = "category", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Benefit classification", formalDefinition="Code to identify the general type of benefits under which products and services are provided." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/ex-benefitcategory")
        protected CodeableConcept category;

        /**
         * This contains the product, service, drug or other billing code for the item.
         */
        @Child(name = "productOrService", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Billing, service, product, or drug code", formalDefinition="This contains the product, service, drug or other billing code for the item." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/service-uscls")
        protected CodeableConcept productOrService;

        /**
         * Item typification or modifiers codes to convey additional context for the product or service.
         */
        @Child(name = "modifier", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Product or service billing modifiers", formalDefinition="Item typification or modifiers codes to convey additional context for the product or service." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/claim-modifiers")
        protected List<CodeableConcept> modifier;

        /**
         * The practitioner who is eligible for the provision of the product or service.
         */
        @Child(name = "provider", type = {Practitioner.class, PractitionerRole.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Performing practitioner", formalDefinition="The practitioner who is eligible for the provision of the product or service." )
        protected Reference provider;

        /**
         * The actual object that is the target of the reference (The practitioner who is eligible for the provision of the product or service.)
         */
        protected Resource providerTarget;

        /**
         * True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is included in the coverage.
         */
        @Child(name = "excluded", type = {BooleanType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Excluded from the plan", formalDefinition="True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is included in the coverage." )
        protected BooleanType excluded;

        /**
         * A short name or tag for the benefit.
         */
        @Child(name = "name", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Short name for the benefit", formalDefinition="A short name or tag for the benefit." )
        protected StringType name;

        /**
         * A richer description of the benefit or services covered.
         */
        @Child(name = "description", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the benefit or services covered", formalDefinition="A richer description of the benefit or services covered." )
        protected StringType description;

        /**
         * Is a flag to indicate whether the benefits refer to in-network providers or out-of-network providers.
         */
        @Child(name = "network", type = {CodeableConcept.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="In or out of network", formalDefinition="Is a flag to indicate whether the benefits refer to in-network providers or out-of-network providers." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/benefit-network")
        protected CodeableConcept network;

        /**
         * Indicates if the benefits apply to an individual or to the family.
         */
        @Child(name = "unit", type = {CodeableConcept.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Individual or family", formalDefinition="Indicates if the benefits apply to an individual or to the family." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/benefit-unit")
        protected CodeableConcept unit;

        /**
         * The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual visits'.
         */
        @Child(name = "term", type = {CodeableConcept.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Annual or lifetime", formalDefinition="The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual visits'." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/benefit-term")
        protected CodeableConcept term;

        /**
         * Benefits used to date.
         */
        @Child(name = "benefit", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Benefit Summary", formalDefinition="Benefits used to date." )
        protected List<BenefitComponent> benefit;

        /**
         * A boolean flag indicating whether a preauthorization is required prior to actual service delivery.
         */
        @Child(name = "authorizationRequired", type = {BooleanType.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Authorization required flag", formalDefinition="A boolean flag indicating whether a preauthorization is required prior to actual service delivery." )
        protected BooleanType authorizationRequired;

        /**
         * Codes or comments regarding information or actions associated with the preauthorization.
         */
        @Child(name = "authorizationSupporting", type = {CodeableConcept.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Type of required supporting materials", formalDefinition="Codes or comments regarding information or actions associated with the preauthorization." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/coverageeligibilityresponse-ex-auth-support")
        protected List<CodeableConcept> authorizationSupporting;

        /**
         * A web location for obtaining requirements or descriptive information regarding the preauthorization.
         */
        @Child(name = "authorizationUrl", type = {UriType.class}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Preauthorization requirements endpoint", formalDefinition="A web location for obtaining requirements or descriptive information regarding the preauthorization." )
        protected UriType authorizationUrl;

        private static final long serialVersionUID = 1779114111L;

    /**
     * Constructor
     */
      public ItemsComponent() {
        super();
      }

        /**
         * @return {@link #category} (Code to identify the general type of benefits under which products and services are provided.)
         */
        public CodeableConcept getCategory() { 
          if (this.category == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.category");
            else if (Configuration.doAutoCreate())
              this.category = new CodeableConcept(); // cc
          return this.category;
        }

        public boolean hasCategory() { 
          return this.category != null && !this.category.isEmpty();
        }

        /**
         * @param value {@link #category} (Code to identify the general type of benefits under which products and services are provided.)
         */
        public ItemsComponent setCategory(CodeableConcept value) { 
          this.category = value;
          return this;
        }

        /**
         * @return {@link #productOrService} (This contains the product, service, drug or other billing code for the item.)
         */
        public CodeableConcept getProductOrService() { 
          if (this.productOrService == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.productOrService");
            else if (Configuration.doAutoCreate())
              this.productOrService = new CodeableConcept(); // cc
          return this.productOrService;
        }

        public boolean hasProductOrService() { 
          return this.productOrService != null && !this.productOrService.isEmpty();
        }

        /**
         * @param value {@link #productOrService} (This contains the product, service, drug or other billing code for the item.)
         */
        public ItemsComponent setProductOrService(CodeableConcept value) { 
          this.productOrService = value;
          return this;
        }

        /**
         * @return {@link #modifier} (Item typification or modifiers codes to convey additional context for the product or service.)
         */
        public List<CodeableConcept> getModifier() { 
          if (this.modifier == null)
            this.modifier = new ArrayList<CodeableConcept>();
          return this.modifier;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ItemsComponent setModifier(List<CodeableConcept> theModifier) { 
          this.modifier = theModifier;
          return this;
        }

        public boolean hasModifier() { 
          if (this.modifier == null)
            return false;
          for (CodeableConcept item : this.modifier)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addModifier() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.modifier == null)
            this.modifier = new ArrayList<CodeableConcept>();
          this.modifier.add(t);
          return t;
        }

        public ItemsComponent addModifier(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.modifier == null)
            this.modifier = new ArrayList<CodeableConcept>();
          this.modifier.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #modifier}, creating it if it does not already exist
         */
        public CodeableConcept getModifierFirstRep() { 
          if (getModifier().isEmpty()) {
            addModifier();
          }
          return getModifier().get(0);
        }

        /**
         * @return {@link #provider} (The practitioner who is eligible for the provision of the product or service.)
         */
        public Reference getProvider() { 
          if (this.provider == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.provider");
            else if (Configuration.doAutoCreate())
              this.provider = new Reference(); // cc
          return this.provider;
        }

        public boolean hasProvider() { 
          return this.provider != null && !this.provider.isEmpty();
        }

        /**
         * @param value {@link #provider} (The practitioner who is eligible for the provision of the product or service.)
         */
        public ItemsComponent setProvider(Reference value) { 
          this.provider = value;
          return this;
        }

        /**
         * @return {@link #provider} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The practitioner who is eligible for the provision of the product or service.)
         */
        public Resource getProviderTarget() { 
          return this.providerTarget;
        }

        /**
         * @param value {@link #provider} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The practitioner who is eligible for the provision of the product or service.)
         */
        public ItemsComponent setProviderTarget(Resource value) { 
          this.providerTarget = value;
          return this;
        }

        /**
         * @return {@link #excluded} (True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is included in the coverage.). This is the underlying object with id, value and extensions. The accessor "getExcluded" gives direct access to the value
         */
        public BooleanType getExcludedElement() { 
          if (this.excluded == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.excluded");
            else if (Configuration.doAutoCreate())
              this.excluded = new BooleanType(); // bb
          return this.excluded;
        }

        public boolean hasExcludedElement() { 
          return this.excluded != null && !this.excluded.isEmpty();
        }

        public boolean hasExcluded() { 
          return this.excluded != null && !this.excluded.isEmpty();
        }

        /**
         * @param value {@link #excluded} (True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is included in the coverage.). This is the underlying object with id, value and extensions. The accessor "getExcluded" gives direct access to the value
         */
        public ItemsComponent setExcludedElement(BooleanType value) { 
          this.excluded = value;
          return this;
        }

        /**
         * @return True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is included in the coverage.
         */
        public boolean getExcluded() { 
          return this.excluded == null || this.excluded.isEmpty() ? false : this.excluded.getValue();
        }

        /**
         * @param value True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is included in the coverage.
         */
        public ItemsComponent setExcluded(boolean value) { 
            if (this.excluded == null)
              this.excluded = new BooleanType();
            this.excluded.setValue(value);
          return this;
        }

        /**
         * @return {@link #name} (A short name or tag for the benefit.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.name");
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
         * @param value {@link #name} (A short name or tag for the benefit.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public ItemsComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return A short name or tag for the benefit.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value A short name or tag for the benefit.
         */
        public ItemsComponent setName(String value) { 
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
         * @return {@link #description} (A richer description of the benefit or services covered.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.description");
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
         * @param value {@link #description} (A richer description of the benefit or services covered.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public ItemsComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A richer description of the benefit or services covered.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A richer description of the benefit or services covered.
         */
        public ItemsComponent setDescription(String value) { 
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
         * @return {@link #network} (Is a flag to indicate whether the benefits refer to in-network providers or out-of-network providers.)
         */
        public CodeableConcept getNetwork() { 
          if (this.network == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.network");
            else if (Configuration.doAutoCreate())
              this.network = new CodeableConcept(); // cc
          return this.network;
        }

        public boolean hasNetwork() { 
          return this.network != null && !this.network.isEmpty();
        }

        /**
         * @param value {@link #network} (Is a flag to indicate whether the benefits refer to in-network providers or out-of-network providers.)
         */
        public ItemsComponent setNetwork(CodeableConcept value) { 
          this.network = value;
          return this;
        }

        /**
         * @return {@link #unit} (Indicates if the benefits apply to an individual or to the family.)
         */
        public CodeableConcept getUnit() { 
          if (this.unit == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.unit");
            else if (Configuration.doAutoCreate())
              this.unit = new CodeableConcept(); // cc
          return this.unit;
        }

        public boolean hasUnit() { 
          return this.unit != null && !this.unit.isEmpty();
        }

        /**
         * @param value {@link #unit} (Indicates if the benefits apply to an individual or to the family.)
         */
        public ItemsComponent setUnit(CodeableConcept value) { 
          this.unit = value;
          return this;
        }

        /**
         * @return {@link #term} (The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual visits'.)
         */
        public CodeableConcept getTerm() { 
          if (this.term == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.term");
            else if (Configuration.doAutoCreate())
              this.term = new CodeableConcept(); // cc
          return this.term;
        }

        public boolean hasTerm() { 
          return this.term != null && !this.term.isEmpty();
        }

        /**
         * @param value {@link #term} (The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual visits'.)
         */
        public ItemsComponent setTerm(CodeableConcept value) { 
          this.term = value;
          return this;
        }

        /**
         * @return {@link #benefit} (Benefits used to date.)
         */
        public List<BenefitComponent> getBenefit() { 
          if (this.benefit == null)
            this.benefit = new ArrayList<BenefitComponent>();
          return this.benefit;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ItemsComponent setBenefit(List<BenefitComponent> theBenefit) { 
          this.benefit = theBenefit;
          return this;
        }

        public boolean hasBenefit() { 
          if (this.benefit == null)
            return false;
          for (BenefitComponent item : this.benefit)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public BenefitComponent addBenefit() { //3
          BenefitComponent t = new BenefitComponent();
          if (this.benefit == null)
            this.benefit = new ArrayList<BenefitComponent>();
          this.benefit.add(t);
          return t;
        }

        public ItemsComponent addBenefit(BenefitComponent t) { //3
          if (t == null)
            return this;
          if (this.benefit == null)
            this.benefit = new ArrayList<BenefitComponent>();
          this.benefit.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #benefit}, creating it if it does not already exist
         */
        public BenefitComponent getBenefitFirstRep() { 
          if (getBenefit().isEmpty()) {
            addBenefit();
          }
          return getBenefit().get(0);
        }

        /**
         * @return {@link #authorizationRequired} (A boolean flag indicating whether a preauthorization is required prior to actual service delivery.). This is the underlying object with id, value and extensions. The accessor "getAuthorizationRequired" gives direct access to the value
         */
        public BooleanType getAuthorizationRequiredElement() { 
          if (this.authorizationRequired == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.authorizationRequired");
            else if (Configuration.doAutoCreate())
              this.authorizationRequired = new BooleanType(); // bb
          return this.authorizationRequired;
        }

        public boolean hasAuthorizationRequiredElement() { 
          return this.authorizationRequired != null && !this.authorizationRequired.isEmpty();
        }

        public boolean hasAuthorizationRequired() { 
          return this.authorizationRequired != null && !this.authorizationRequired.isEmpty();
        }

        /**
         * @param value {@link #authorizationRequired} (A boolean flag indicating whether a preauthorization is required prior to actual service delivery.). This is the underlying object with id, value and extensions. The accessor "getAuthorizationRequired" gives direct access to the value
         */
        public ItemsComponent setAuthorizationRequiredElement(BooleanType value) { 
          this.authorizationRequired = value;
          return this;
        }

        /**
         * @return A boolean flag indicating whether a preauthorization is required prior to actual service delivery.
         */
        public boolean getAuthorizationRequired() { 
          return this.authorizationRequired == null || this.authorizationRequired.isEmpty() ? false : this.authorizationRequired.getValue();
        }

        /**
         * @param value A boolean flag indicating whether a preauthorization is required prior to actual service delivery.
         */
        public ItemsComponent setAuthorizationRequired(boolean value) { 
            if (this.authorizationRequired == null)
              this.authorizationRequired = new BooleanType();
            this.authorizationRequired.setValue(value);
          return this;
        }

        /**
         * @return {@link #authorizationSupporting} (Codes or comments regarding information or actions associated with the preauthorization.)
         */
        public List<CodeableConcept> getAuthorizationSupporting() { 
          if (this.authorizationSupporting == null)
            this.authorizationSupporting = new ArrayList<CodeableConcept>();
          return this.authorizationSupporting;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public ItemsComponent setAuthorizationSupporting(List<CodeableConcept> theAuthorizationSupporting) { 
          this.authorizationSupporting = theAuthorizationSupporting;
          return this;
        }

        public boolean hasAuthorizationSupporting() { 
          if (this.authorizationSupporting == null)
            return false;
          for (CodeableConcept item : this.authorizationSupporting)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addAuthorizationSupporting() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.authorizationSupporting == null)
            this.authorizationSupporting = new ArrayList<CodeableConcept>();
          this.authorizationSupporting.add(t);
          return t;
        }

        public ItemsComponent addAuthorizationSupporting(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.authorizationSupporting == null)
            this.authorizationSupporting = new ArrayList<CodeableConcept>();
          this.authorizationSupporting.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #authorizationSupporting}, creating it if it does not already exist
         */
        public CodeableConcept getAuthorizationSupportingFirstRep() { 
          if (getAuthorizationSupporting().isEmpty()) {
            addAuthorizationSupporting();
          }
          return getAuthorizationSupporting().get(0);
        }

        /**
         * @return {@link #authorizationUrl} (A web location for obtaining requirements or descriptive information regarding the preauthorization.). This is the underlying object with id, value and extensions. The accessor "getAuthorizationUrl" gives direct access to the value
         */
        public UriType getAuthorizationUrlElement() { 
          if (this.authorizationUrl == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ItemsComponent.authorizationUrl");
            else if (Configuration.doAutoCreate())
              this.authorizationUrl = new UriType(); // bb
          return this.authorizationUrl;
        }

        public boolean hasAuthorizationUrlElement() { 
          return this.authorizationUrl != null && !this.authorizationUrl.isEmpty();
        }

        public boolean hasAuthorizationUrl() { 
          return this.authorizationUrl != null && !this.authorizationUrl.isEmpty();
        }

        /**
         * @param value {@link #authorizationUrl} (A web location for obtaining requirements or descriptive information regarding the preauthorization.). This is the underlying object with id, value and extensions. The accessor "getAuthorizationUrl" gives direct access to the value
         */
        public ItemsComponent setAuthorizationUrlElement(UriType value) { 
          this.authorizationUrl = value;
          return this;
        }

        /**
         * @return A web location for obtaining requirements or descriptive information regarding the preauthorization.
         */
        public String getAuthorizationUrl() { 
          return this.authorizationUrl == null ? null : this.authorizationUrl.getValue();
        }

        /**
         * @param value A web location for obtaining requirements or descriptive information regarding the preauthorization.
         */
        public ItemsComponent setAuthorizationUrl(String value) { 
          if (Utilities.noString(value))
            this.authorizationUrl = null;
          else {
            if (this.authorizationUrl == null)
              this.authorizationUrl = new UriType();
            this.authorizationUrl.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("category", "CodeableConcept", "Code to identify the general type of benefits under which products and services are provided.", 0, 1, category));
          children.add(new Property("productOrService", "CodeableConcept", "This contains the product, service, drug or other billing code for the item.", 0, 1, productOrService));
          children.add(new Property("modifier", "CodeableConcept", "Item typification or modifiers codes to convey additional context for the product or service.", 0, java.lang.Integer.MAX_VALUE, modifier));
          children.add(new Property("provider", "Reference(Practitioner|PractitionerRole)", "The practitioner who is eligible for the provision of the product or service.", 0, 1, provider));
          children.add(new Property("excluded", "boolean", "True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is included in the coverage.", 0, 1, excluded));
          children.add(new Property("name", "string", "A short name or tag for the benefit.", 0, 1, name));
          children.add(new Property("description", "string", "A richer description of the benefit or services covered.", 0, 1, description));
          children.add(new Property("network", "CodeableConcept", "Is a flag to indicate whether the benefits refer to in-network providers or out-of-network providers.", 0, 1, network));
          children.add(new Property("unit", "CodeableConcept", "Indicates if the benefits apply to an individual or to the family.", 0, 1, unit));
          children.add(new Property("term", "CodeableConcept", "The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual visits'.", 0, 1, term));
          children.add(new Property("benefit", "", "Benefits used to date.", 0, java.lang.Integer.MAX_VALUE, benefit));
          children.add(new Property("authorizationRequired", "boolean", "A boolean flag indicating whether a preauthorization is required prior to actual service delivery.", 0, 1, authorizationRequired));
          children.add(new Property("authorizationSupporting", "CodeableConcept", "Codes or comments regarding information or actions associated with the preauthorization.", 0, java.lang.Integer.MAX_VALUE, authorizationSupporting));
          children.add(new Property("authorizationUrl", "uri", "A web location for obtaining requirements or descriptive information regarding the preauthorization.", 0, 1, authorizationUrl));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Code to identify the general type of benefits under which products and services are provided.", 0, 1, category);
          case 1957227299: /*productOrService*/  return new Property("productOrService", "CodeableConcept", "This contains the product, service, drug or other billing code for the item.", 0, 1, productOrService);
          case -615513385: /*modifier*/  return new Property("modifier", "CodeableConcept", "Item typification or modifiers codes to convey additional context for the product or service.", 0, java.lang.Integer.MAX_VALUE, modifier);
          case -987494927: /*provider*/  return new Property("provider", "Reference(Practitioner|PractitionerRole)", "The practitioner who is eligible for the provision of the product or service.", 0, 1, provider);
          case 1994055114: /*excluded*/  return new Property("excluded", "boolean", "True if the indicated class of service is excluded from the plan, missing or False indicates the product or service is included in the coverage.", 0, 1, excluded);
          case 3373707: /*name*/  return new Property("name", "string", "A short name or tag for the benefit.", 0, 1, name);
          case -1724546052: /*description*/  return new Property("description", "string", "A richer description of the benefit or services covered.", 0, 1, description);
          case 1843485230: /*network*/  return new Property("network", "CodeableConcept", "Is a flag to indicate whether the benefits refer to in-network providers or out-of-network providers.", 0, 1, network);
          case 3594628: /*unit*/  return new Property("unit", "CodeableConcept", "Indicates if the benefits apply to an individual or to the family.", 0, 1, unit);
          case 3556460: /*term*/  return new Property("term", "CodeableConcept", "The term or period of the values such as 'maximum lifetime benefit' or 'maximum annual visits'.", 0, 1, term);
          case -222710633: /*benefit*/  return new Property("benefit", "", "Benefits used to date.", 0, java.lang.Integer.MAX_VALUE, benefit);
          case 374204216: /*authorizationRequired*/  return new Property("authorizationRequired", "boolean", "A boolean flag indicating whether a preauthorization is required prior to actual service delivery.", 0, 1, authorizationRequired);
          case -1931146484: /*authorizationSupporting*/  return new Property("authorizationSupporting", "CodeableConcept", "Codes or comments regarding information or actions associated with the preauthorization.", 0, java.lang.Integer.MAX_VALUE, authorizationSupporting);
          case 1409445430: /*authorizationUrl*/  return new Property("authorizationUrl", "uri", "A web location for obtaining requirements or descriptive information regarding the preauthorization.", 0, 1, authorizationUrl);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case 1957227299: /*productOrService*/ return this.productOrService == null ? new Base[0] : new Base[] {this.productOrService}; // CodeableConcept
        case -615513385: /*modifier*/ return this.modifier == null ? new Base[0] : this.modifier.toArray(new Base[this.modifier.size()]); // CodeableConcept
        case -987494927: /*provider*/ return this.provider == null ? new Base[0] : new Base[] {this.provider}; // Reference
        case 1994055114: /*excluded*/ return this.excluded == null ? new Base[0] : new Base[] {this.excluded}; // BooleanType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case 1843485230: /*network*/ return this.network == null ? new Base[0] : new Base[] {this.network}; // CodeableConcept
        case 3594628: /*unit*/ return this.unit == null ? new Base[0] : new Base[] {this.unit}; // CodeableConcept
        case 3556460: /*term*/ return this.term == null ? new Base[0] : new Base[] {this.term}; // CodeableConcept
        case -222710633: /*benefit*/ return this.benefit == null ? new Base[0] : this.benefit.toArray(new Base[this.benefit.size()]); // BenefitComponent
        case 374204216: /*authorizationRequired*/ return this.authorizationRequired == null ? new Base[0] : new Base[] {this.authorizationRequired}; // BooleanType
        case -1931146484: /*authorizationSupporting*/ return this.authorizationSupporting == null ? new Base[0] : this.authorizationSupporting.toArray(new Base[this.authorizationSupporting.size()]); // CodeableConcept
        case 1409445430: /*authorizationUrl*/ return this.authorizationUrl == null ? new Base[0] : new Base[] {this.authorizationUrl}; // UriType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 50511102: // category
          this.category = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1957227299: // productOrService
          this.productOrService = castToCodeableConcept(value); // CodeableConcept
          return value;
        case -615513385: // modifier
          this.getModifier().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -987494927: // provider
          this.provider = castToReference(value); // Reference
          return value;
        case 1994055114: // excluded
          this.excluded = castToBoolean(value); // BooleanType
          return value;
        case 3373707: // name
          this.name = castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = castToString(value); // StringType
          return value;
        case 1843485230: // network
          this.network = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3594628: // unit
          this.unit = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3556460: // term
          this.term = castToCodeableConcept(value); // CodeableConcept
          return value;
        case -222710633: // benefit
          this.getBenefit().add((BenefitComponent) value); // BenefitComponent
          return value;
        case 374204216: // authorizationRequired
          this.authorizationRequired = castToBoolean(value); // BooleanType
          return value;
        case -1931146484: // authorizationSupporting
          this.getAuthorizationSupporting().add(castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1409445430: // authorizationUrl
          this.authorizationUrl = castToUri(value); // UriType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("productOrService")) {
          this.productOrService = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("modifier")) {
          this.getModifier().add(castToCodeableConcept(value));
        } else if (name.equals("provider")) {
          this.provider = castToReference(value); // Reference
        } else if (name.equals("excluded")) {
          this.excluded = castToBoolean(value); // BooleanType
        } else if (name.equals("name")) {
          this.name = castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = castToString(value); // StringType
        } else if (name.equals("network")) {
          this.network = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("unit")) {
          this.unit = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("term")) {
          this.term = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("benefit")) {
          this.getBenefit().add((BenefitComponent) value);
        } else if (name.equals("authorizationRequired")) {
          this.authorizationRequired = castToBoolean(value); // BooleanType
        } else if (name.equals("authorizationSupporting")) {
          this.getAuthorizationSupporting().add(castToCodeableConcept(value));
        } else if (name.equals("authorizationUrl")) {
          this.authorizationUrl = castToUri(value); // UriType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102:  return getCategory(); 
        case 1957227299:  return getProductOrService(); 
        case -615513385:  return addModifier(); 
        case -987494927:  return getProvider(); 
        case 1994055114:  return getExcludedElement();
        case 3373707:  return getNameElement();
        case -1724546052:  return getDescriptionElement();
        case 1843485230:  return getNetwork(); 
        case 3594628:  return getUnit(); 
        case 3556460:  return getTerm(); 
        case -222710633:  return addBenefit(); 
        case 374204216:  return getAuthorizationRequiredElement();
        case -1931146484:  return addAuthorizationSupporting(); 
        case 1409445430:  return getAuthorizationUrlElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 1957227299: /*productOrService*/ return new String[] {"CodeableConcept"};
        case -615513385: /*modifier*/ return new String[] {"CodeableConcept"};
        case -987494927: /*provider*/ return new String[] {"Reference"};
        case 1994055114: /*excluded*/ return new String[] {"boolean"};
        case 3373707: /*name*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case 1843485230: /*network*/ return new String[] {"CodeableConcept"};
        case 3594628: /*unit*/ return new String[] {"CodeableConcept"};
        case 3556460: /*term*/ return new String[] {"CodeableConcept"};
        case -222710633: /*benefit*/ return new String[] {};
        case 374204216: /*authorizationRequired*/ return new String[] {"boolean"};
        case -1931146484: /*authorizationSupporting*/ return new String[] {"CodeableConcept"};
        case 1409445430: /*authorizationUrl*/ return new String[] {"uri"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("category")) {
          this.category = new CodeableConcept();
          return this.category;
        }
        else if (name.equals("productOrService")) {
          this.productOrService = new CodeableConcept();
          return this.productOrService;
        }
        else if (name.equals("modifier")) {
          return addModifier();
        }
        else if (name.equals("provider")) {
          this.provider = new Reference();
          return this.provider;
        }
        else if (name.equals("excluded")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.excluded");
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.name");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.description");
        }
        else if (name.equals("network")) {
          this.network = new CodeableConcept();
          return this.network;
        }
        else if (name.equals("unit")) {
          this.unit = new CodeableConcept();
          return this.unit;
        }
        else if (name.equals("term")) {
          this.term = new CodeableConcept();
          return this.term;
        }
        else if (name.equals("benefit")) {
          return addBenefit();
        }
        else if (name.equals("authorizationRequired")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.authorizationRequired");
        }
        else if (name.equals("authorizationSupporting")) {
          return addAuthorizationSupporting();
        }
        else if (name.equals("authorizationUrl")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.authorizationUrl");
        }
        else
          return super.addChild(name);
      }

      public ItemsComponent copy() {
        ItemsComponent dst = new ItemsComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ItemsComponent dst) {
        super.copyValues(dst);
        dst.category = category == null ? null : category.copy();
        dst.productOrService = productOrService == null ? null : productOrService.copy();
        if (modifier != null) {
          dst.modifier = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : modifier)
            dst.modifier.add(i.copy());
        };
        dst.provider = provider == null ? null : provider.copy();
        dst.excluded = excluded == null ? null : excluded.copy();
        dst.name = name == null ? null : name.copy();
        dst.description = description == null ? null : description.copy();
        dst.network = network == null ? null : network.copy();
        dst.unit = unit == null ? null : unit.copy();
        dst.term = term == null ? null : term.copy();
        if (benefit != null) {
          dst.benefit = new ArrayList<BenefitComponent>();
          for (BenefitComponent i : benefit)
            dst.benefit.add(i.copy());
        };
        dst.authorizationRequired = authorizationRequired == null ? null : authorizationRequired.copy();
        if (authorizationSupporting != null) {
          dst.authorizationSupporting = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : authorizationSupporting)
            dst.authorizationSupporting.add(i.copy());
        };
        dst.authorizationUrl = authorizationUrl == null ? null : authorizationUrl.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ItemsComponent))
          return false;
        ItemsComponent o = (ItemsComponent) other_;
        return compareDeep(category, o.category, true) && compareDeep(productOrService, o.productOrService, true)
           && compareDeep(modifier, o.modifier, true) && compareDeep(provider, o.provider, true) && compareDeep(excluded, o.excluded, true)
           && compareDeep(name, o.name, true) && compareDeep(description, o.description, true) && compareDeep(network, o.network, true)
           && compareDeep(unit, o.unit, true) && compareDeep(term, o.term, true) && compareDeep(benefit, o.benefit, true)
           && compareDeep(authorizationRequired, o.authorizationRequired, true) && compareDeep(authorizationSupporting, o.authorizationSupporting, true)
           && compareDeep(authorizationUrl, o.authorizationUrl, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ItemsComponent))
          return false;
        ItemsComponent o = (ItemsComponent) other_;
        return compareValues(excluded, o.excluded, true) && compareValues(name, o.name, true) && compareValues(description, o.description, true)
           && compareValues(authorizationRequired, o.authorizationRequired, true) && compareValues(authorizationUrl, o.authorizationUrl, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(category, productOrService
          , modifier, provider, excluded, name, description, network, unit, term, benefit
          , authorizationRequired, authorizationSupporting, authorizationUrl);
      }

  public String fhirType() {
    return "CoverageEligibilityResponse.insurance.item";

  }

  }

    @Block()
    public static class BenefitComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Classification of benefit being provided.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Benefit classification", formalDefinition="Classification of benefit being provided." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/benefit-type")
        protected CodeableConcept type;

        /**
         * The quantity of the benefit which is permitted under the coverage.
         */
        @Child(name = "allowed", type = {UnsignedIntType.class, StringType.class, Money.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Benefits allowed", formalDefinition="The quantity of the benefit which is permitted under the coverage." )
        protected Type allowed;

        /**
         * The quantity of the benefit which have been consumed to date.
         */
        @Child(name = "used", type = {UnsignedIntType.class, StringType.class, Money.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Benefits used", formalDefinition="The quantity of the benefit which have been consumed to date." )
        protected Type used;

        private static final long serialVersionUID = -1506285314L;

    /**
     * Constructor
     */
      public BenefitComponent() {
        super();
      }

    /**
     * Constructor
     */
      public BenefitComponent(CodeableConcept type) {
        super();
        this.type = type;
      }

        /**
         * @return {@link #type} (Classification of benefit being provided.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BenefitComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Classification of benefit being provided.)
         */
        public BenefitComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #allowed} (The quantity of the benefit which is permitted under the coverage.)
         */
        public Type getAllowed() { 
          return this.allowed;
        }

        /**
         * @return {@link #allowed} (The quantity of the benefit which is permitted under the coverage.)
         */
        public UnsignedIntType getAllowedUnsignedIntType() throws FHIRException { 
          if (this.allowed == null)
            this.allowed = new UnsignedIntType();
          if (!(this.allowed instanceof UnsignedIntType))
            throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.allowed.getClass().getName()+" was encountered");
          return (UnsignedIntType) this.allowed;
        }

        public boolean hasAllowedUnsignedIntType() { 
          return this != null && this.allowed instanceof UnsignedIntType;
        }

        /**
         * @return {@link #allowed} (The quantity of the benefit which is permitted under the coverage.)
         */
        public StringType getAllowedStringType() throws FHIRException { 
          if (this.allowed == null)
            this.allowed = new StringType();
          if (!(this.allowed instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.allowed.getClass().getName()+" was encountered");
          return (StringType) this.allowed;
        }

        public boolean hasAllowedStringType() { 
          return this != null && this.allowed instanceof StringType;
        }

        /**
         * @return {@link #allowed} (The quantity of the benefit which is permitted under the coverage.)
         */
        public Money getAllowedMoney() throws FHIRException { 
          if (this.allowed == null)
            this.allowed = new Money();
          if (!(this.allowed instanceof Money))
            throw new FHIRException("Type mismatch: the type Money was expected, but "+this.allowed.getClass().getName()+" was encountered");
          return (Money) this.allowed;
        }

        public boolean hasAllowedMoney() { 
          return this != null && this.allowed instanceof Money;
        }

        public boolean hasAllowed() { 
          return this.allowed != null && !this.allowed.isEmpty();
        }

        /**
         * @param value {@link #allowed} (The quantity of the benefit which is permitted under the coverage.)
         */
        public BenefitComponent setAllowed(Type value) { 
          if (value != null && !(value instanceof UnsignedIntType || value instanceof StringType || value instanceof Money))
            throw new Error("Not the right type for CoverageEligibilityResponse.insurance.item.benefit.allowed[x]: "+value.fhirType());
          this.allowed = value;
          return this;
        }

        /**
         * @return {@link #used} (The quantity of the benefit which have been consumed to date.)
         */
        public Type getUsed() { 
          return this.used;
        }

        /**
         * @return {@link #used} (The quantity of the benefit which have been consumed to date.)
         */
        public UnsignedIntType getUsedUnsignedIntType() throws FHIRException { 
          if (this.used == null)
            this.used = new UnsignedIntType();
          if (!(this.used instanceof UnsignedIntType))
            throw new FHIRException("Type mismatch: the type UnsignedIntType was expected, but "+this.used.getClass().getName()+" was encountered");
          return (UnsignedIntType) this.used;
        }

        public boolean hasUsedUnsignedIntType() { 
          return this != null && this.used instanceof UnsignedIntType;
        }

        /**
         * @return {@link #used} (The quantity of the benefit which have been consumed to date.)
         */
        public StringType getUsedStringType() throws FHIRException { 
          if (this.used == null)
            this.used = new StringType();
          if (!(this.used instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.used.getClass().getName()+" was encountered");
          return (StringType) this.used;
        }

        public boolean hasUsedStringType() { 
          return this != null && this.used instanceof StringType;
        }

        /**
         * @return {@link #used} (The quantity of the benefit which have been consumed to date.)
         */
        public Money getUsedMoney() throws FHIRException { 
          if (this.used == null)
            this.used = new Money();
          if (!(this.used instanceof Money))
            throw new FHIRException("Type mismatch: the type Money was expected, but "+this.used.getClass().getName()+" was encountered");
          return (Money) this.used;
        }

        public boolean hasUsedMoney() { 
          return this != null && this.used instanceof Money;
        }

        public boolean hasUsed() { 
          return this.used != null && !this.used.isEmpty();
        }

        /**
         * @param value {@link #used} (The quantity of the benefit which have been consumed to date.)
         */
        public BenefitComponent setUsed(Type value) { 
          if (value != null && !(value instanceof UnsignedIntType || value instanceof StringType || value instanceof Money))
            throw new Error("Not the right type for CoverageEligibilityResponse.insurance.item.benefit.used[x]: "+value.fhirType());
          this.used = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Classification of benefit being provided.", 0, 1, type));
          children.add(new Property("allowed[x]", "unsignedInt|string|Money", "The quantity of the benefit which is permitted under the coverage.", 0, 1, allowed));
          children.add(new Property("used[x]", "unsignedInt|string|Money", "The quantity of the benefit which have been consumed to date.", 0, 1, used));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Classification of benefit being provided.", 0, 1, type);
          case -1336663592: /*allowed[x]*/  return new Property("allowed[x]", "unsignedInt|string|Money", "The quantity of the benefit which is permitted under the coverage.", 0, 1, allowed);
          case -911343192: /*allowed*/  return new Property("allowed[x]", "unsignedInt|string|Money", "The quantity of the benefit which is permitted under the coverage.", 0, 1, allowed);
          case 1668802034: /*allowedUnsignedInt*/  return new Property("allowed[x]", "unsignedInt|string|Money", "The quantity of the benefit which is permitted under the coverage.", 0, 1, allowed);
          case -2135265319: /*allowedString*/  return new Property("allowed[x]", "unsignedInt|string|Money", "The quantity of the benefit which is permitted under the coverage.", 0, 1, allowed);
          case -351668232: /*allowedMoney*/  return new Property("allowed[x]", "unsignedInt|string|Money", "The quantity of the benefit which is permitted under the coverage.", 0, 1, allowed);
          case -147553373: /*used[x]*/  return new Property("used[x]", "unsignedInt|string|Money", "The quantity of the benefit which have been consumed to date.", 0, 1, used);
          case 3599293: /*used*/  return new Property("used[x]", "unsignedInt|string|Money", "The quantity of the benefit which have been consumed to date.", 0, 1, used);
          case 1252740285: /*usedUnsignedInt*/  return new Property("used[x]", "unsignedInt|string|Money", "The quantity of the benefit which have been consumed to date.", 0, 1, used);
          case 2051978798: /*usedString*/  return new Property("used[x]", "unsignedInt|string|Money", "The quantity of the benefit which have been consumed to date.", 0, 1, used);
          case -78048509: /*usedMoney*/  return new Property("used[x]", "unsignedInt|string|Money", "The quantity of the benefit which have been consumed to date.", 0, 1, used);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -911343192: /*allowed*/ return this.allowed == null ? new Base[0] : new Base[] {this.allowed}; // Type
        case 3599293: /*used*/ return this.used == null ? new Base[0] : new Base[] {this.used}; // Type
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = castToCodeableConcept(value); // CodeableConcept
          return value;
        case -911343192: // allowed
          this.allowed = castToType(value); // Type
          return value;
        case 3599293: // used
          this.used = castToType(value); // Type
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("allowed[x]")) {
          this.allowed = castToType(value); // Type
        } else if (name.equals("used[x]")) {
          this.used = castToType(value); // Type
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType(); 
        case -1336663592:  return getAllowed(); 
        case -911343192:  return getAllowed(); 
        case -147553373:  return getUsed(); 
        case 3599293:  return getUsed(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -911343192: /*allowed*/ return new String[] {"unsignedInt", "string", "Money"};
        case 3599293: /*used*/ return new String[] {"unsignedInt", "string", "Money"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("allowedUnsignedInt")) {
          this.allowed = new UnsignedIntType();
          return this.allowed;
        }
        else if (name.equals("allowedString")) {
          this.allowed = new StringType();
          return this.allowed;
        }
        else if (name.equals("allowedMoney")) {
          this.allowed = new Money();
          return this.allowed;
        }
        else if (name.equals("usedUnsignedInt")) {
          this.used = new UnsignedIntType();
          return this.used;
        }
        else if (name.equals("usedString")) {
          this.used = new StringType();
          return this.used;
        }
        else if (name.equals("usedMoney")) {
          this.used = new Money();
          return this.used;
        }
        else
          return super.addChild(name);
      }

      public BenefitComponent copy() {
        BenefitComponent dst = new BenefitComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BenefitComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.allowed = allowed == null ? null : allowed.copy();
        dst.used = used == null ? null : used.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BenefitComponent))
          return false;
        BenefitComponent o = (BenefitComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(allowed, o.allowed, true) && compareDeep(used, o.used, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BenefitComponent))
          return false;
        BenefitComponent o = (BenefitComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, allowed, used);
      }

  public String fhirType() {
    return "CoverageEligibilityResponse.insurance.item.benefit";

  }

  }

    @Block()
    public static class ErrorsComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * An error code,from a specified code system, which details why the eligibility check could not be performed.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Error code detailing processing issues", formalDefinition="An error code,from a specified code system, which details why the eligibility check could not be performed." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/adjudication-error")
        protected CodeableConcept code;

        private static final long serialVersionUID = -1048343046L;

    /**
     * Constructor
     */
      public ErrorsComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ErrorsComponent(CodeableConcept code) {
        super();
        this.code = code;
      }

        /**
         * @return {@link #code} (An error code,from a specified code system, which details why the eligibility check could not be performed.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ErrorsComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (An error code,from a specified code system, which details why the eligibility check could not be performed.)
         */
        public ErrorsComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "An error code,from a specified code system, which details why the eligibility check could not be performed.", 0, 1, code));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "An error code,from a specified code system, which details why the eligibility check could not be performed.", 0, 1, code);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else
          return super.addChild(name);
      }

      public ErrorsComponent copy() {
        ErrorsComponent dst = new ErrorsComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ErrorsComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ErrorsComponent))
          return false;
        ErrorsComponent o = (ErrorsComponent) other_;
        return compareDeep(code, o.code, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ErrorsComponent))
          return false;
        ErrorsComponent o = (ErrorsComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code);
      }

  public String fhirType() {
    return "CoverageEligibilityResponse.error";

  }

  }

    /**
     * A unique identifier assigned to this coverage eligiblity request.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Business Identifier for coverage eligiblity request", formalDefinition="A unique identifier assigned to this coverage eligiblity request." )
    protected List<Identifier> identifier;

    /**
     * The status of the resource instance.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | cancelled | draft | entered-in-error", formalDefinition="The status of the resource instance." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/fm-status")
    protected Enumeration<EligibilityResponseStatus> status;

    /**
     * Code to specify whether requesting: prior authorization requirements for some service categories or billing codes; benefits for coverages specified or discovered; discovery and return of coverages for the patient; and/or validation that the specified coverage is in-force at the date/period specified or 'now' if not specified.
     */
    @Child(name = "purpose", type = {CodeType.class}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="auth-requirements | benefits | discovery | validation", formalDefinition="Code to specify whether requesting: prior authorization requirements for some service categories or billing codes; benefits for coverages specified or discovered; discovery and return of coverages for the patient; and/or validation that the specified coverage is in-force at the date/period specified or 'now' if not specified." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/eligibilityresponse-purpose")
    protected List<Enumeration<EligibilityResponsePurpose>> purpose;

    /**
     * The party who is the beneficiary of the supplied coverage and for whom eligibility is sought.
     */
    @Child(name = "patient", type = {Patient.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Intended recipient of products and services", formalDefinition="The party who is the beneficiary of the supplied coverage and for whom eligibility is sought." )
    protected Reference patient;

    /**
     * The actual object that is the target of the reference (The party who is the beneficiary of the supplied coverage and for whom eligibility is sought.)
     */
    protected Patient patientTarget;

    /**
     * The date or dates when the enclosed suite of services were performed or completed.
     */
    @Child(name = "serviced", type = {DateType.class, Period.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Estimated date or dates of service", formalDefinition="The date or dates when the enclosed suite of services were performed or completed." )
    protected Type serviced;

    /**
     * The date this resource was created.
     */
    @Child(name = "created", type = {DateTimeType.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Response creation date", formalDefinition="The date this resource was created." )
    protected DateTimeType created;

    /**
     * The provider which is responsible for the request.
     */
    @Child(name = "requestor", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Party responsible for the request", formalDefinition="The provider which is responsible for the request." )
    protected Reference requestor;

    /**
     * The actual object that is the target of the reference (The provider which is responsible for the request.)
     */
    protected Resource requestorTarget;

    /**
     * Reference to the original request resource.
     */
    @Child(name = "request", type = {CoverageEligibilityRequest.class}, order=7, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Eligibility request reference", formalDefinition="Reference to the original request resource." )
    protected Reference request;

    /**
     * The actual object that is the target of the reference (Reference to the original request resource.)
     */
    protected CoverageEligibilityRequest requestTarget;

    /**
     * The outcome of the request processing.
     */
    @Child(name = "outcome", type = {CodeType.class}, order=8, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="queued | complete | error | partial", formalDefinition="The outcome of the request processing." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/remittance-outcome")
    protected Enumeration<RemittanceOutcome> outcome;

    /**
     * A human readable description of the status of the adjudication.
     */
    @Child(name = "disposition", type = {StringType.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Disposition Message", formalDefinition="A human readable description of the status of the adjudication." )
    protected StringType disposition;

    /**
     * The Insurer who issued the coverage in question and is the author of the response.
     */
    @Child(name = "insurer", type = {Organization.class}, order=10, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Coverage issuer", formalDefinition="The Insurer who issued the coverage in question and is the author of the response." )
    protected Reference insurer;

    /**
     * The actual object that is the target of the reference (The Insurer who issued the coverage in question and is the author of the response.)
     */
    protected Organization insurerTarget;

    /**
     * Financial instruments for reimbursement for the health care products and services.
     */
    @Child(name = "insurance", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Patient insurance information", formalDefinition="Financial instruments for reimbursement for the health care products and services." )
    protected List<InsuranceComponent> insurance;

    /**
     * A reference from the Insurer to which these services pertain to be used on further communication and as proof that the request occurred.
     */
    @Child(name = "preAuthRef", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Preauthorization reference", formalDefinition="A reference from the Insurer to which these services pertain to be used on further communication and as proof that the request occurred." )
    protected StringType preAuthRef;

    /**
     * A code for the form to be used for printing the content.
     */
    @Child(name = "form", type = {CodeableConcept.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Printed form identifier", formalDefinition="A code for the form to be used for printing the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/forms")
    protected CodeableConcept form;

    /**
     * Errors encountered during the processing of the request.
     */
    @Child(name = "error", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Processing errors", formalDefinition="Errors encountered during the processing of the request." )
    protected List<ErrorsComponent> error;

    private static final long serialVersionUID = -266280848L;

  /**
   * Constructor
   */
    public CoverageEligibilityResponse() {
      super();
    }

  /**
   * Constructor
   */
    public CoverageEligibilityResponse(Enumeration<EligibilityResponseStatus> status, Reference patient, DateTimeType created, Reference request, Enumeration<RemittanceOutcome> outcome, Reference insurer) {
      super();
      this.status = status;
      this.patient = patient;
      this.created = created;
      this.request = request;
      this.outcome = outcome;
      this.insurer = insurer;
    }

    /**
     * @return {@link #identifier} (A unique identifier assigned to this coverage eligiblity request.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CoverageEligibilityResponse setIdentifier(List<Identifier> theIdentifier) { 
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

    public CoverageEligibilityResponse addIdentifier(Identifier t) { //3
      if (t == null)
        return this;
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      this.identifier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #identifier}, creating it if it does not already exist
     */
    public Identifier getIdentifierFirstRep() { 
      if (getIdentifier().isEmpty()) {
        addIdentifier();
      }
      return getIdentifier().get(0);
    }

    /**
     * @return {@link #status} (The status of the resource instance.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<EligibilityResponseStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<EligibilityResponseStatus>(new EligibilityResponseStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The status of the resource instance.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public CoverageEligibilityResponse setStatusElement(Enumeration<EligibilityResponseStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the resource instance.
     */
    public EligibilityResponseStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the resource instance.
     */
    public CoverageEligibilityResponse setStatus(EligibilityResponseStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<EligibilityResponseStatus>(new EligibilityResponseStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #purpose} (Code to specify whether requesting: prior authorization requirements for some service categories or billing codes; benefits for coverages specified or discovered; discovery and return of coverages for the patient; and/or validation that the specified coverage is in-force at the date/period specified or 'now' if not specified.)
     */
    public List<Enumeration<EligibilityResponsePurpose>> getPurpose() { 
      if (this.purpose == null)
        this.purpose = new ArrayList<Enumeration<EligibilityResponsePurpose>>();
      return this.purpose;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CoverageEligibilityResponse setPurpose(List<Enumeration<EligibilityResponsePurpose>> thePurpose) { 
      this.purpose = thePurpose;
      return this;
    }

    public boolean hasPurpose() { 
      if (this.purpose == null)
        return false;
      for (Enumeration<EligibilityResponsePurpose> item : this.purpose)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #purpose} (Code to specify whether requesting: prior authorization requirements for some service categories or billing codes; benefits for coverages specified or discovered; discovery and return of coverages for the patient; and/or validation that the specified coverage is in-force at the date/period specified or 'now' if not specified.)
     */
    public Enumeration<EligibilityResponsePurpose> addPurposeElement() {//2 
      Enumeration<EligibilityResponsePurpose> t = new Enumeration<EligibilityResponsePurpose>(new EligibilityResponsePurposeEnumFactory());
      if (this.purpose == null)
        this.purpose = new ArrayList<Enumeration<EligibilityResponsePurpose>>();
      this.purpose.add(t);
      return t;
    }

    /**
     * @param value {@link #purpose} (Code to specify whether requesting: prior authorization requirements for some service categories or billing codes; benefits for coverages specified or discovered; discovery and return of coverages for the patient; and/or validation that the specified coverage is in-force at the date/period specified or 'now' if not specified.)
     */
    public CoverageEligibilityResponse addPurpose(EligibilityResponsePurpose value) { //1
      Enumeration<EligibilityResponsePurpose> t = new Enumeration<EligibilityResponsePurpose>(new EligibilityResponsePurposeEnumFactory());
      t.setValue(value);
      if (this.purpose == null)
        this.purpose = new ArrayList<Enumeration<EligibilityResponsePurpose>>();
      this.purpose.add(t);
      return this;
    }

    /**
     * @param value {@link #purpose} (Code to specify whether requesting: prior authorization requirements for some service categories or billing codes; benefits for coverages specified or discovered; discovery and return of coverages for the patient; and/or validation that the specified coverage is in-force at the date/period specified or 'now' if not specified.)
     */
    public boolean hasPurpose(EligibilityResponsePurpose value) { 
      if (this.purpose == null)
        return false;
      for (Enumeration<EligibilityResponsePurpose> v : this.purpose)
        if (v.getValue().equals(value)) // code
          return true;
      return false;
    }

    /**
     * @return {@link #patient} (The party who is the beneficiary of the supplied coverage and for whom eligibility is sought.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (The party who is the beneficiary of the supplied coverage and for whom eligibility is sought.)
     */
    public CoverageEligibilityResponse setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #patient} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The party who is the beneficiary of the supplied coverage and for whom eligibility is sought.)
     */
    public Patient getPatientTarget() { 
      if (this.patientTarget == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.patient");
        else if (Configuration.doAutoCreate())
          this.patientTarget = new Patient(); // aa
      return this.patientTarget;
    }

    /**
     * @param value {@link #patient} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The party who is the beneficiary of the supplied coverage and for whom eligibility is sought.)
     */
    public CoverageEligibilityResponse setPatientTarget(Patient value) { 
      this.patientTarget = value;
      return this;
    }

    /**
     * @return {@link #serviced} (The date or dates when the enclosed suite of services were performed or completed.)
     */
    public Type getServiced() { 
      return this.serviced;
    }

    /**
     * @return {@link #serviced} (The date or dates when the enclosed suite of services were performed or completed.)
     */
    public DateType getServicedDateType() throws FHIRException { 
      if (this.serviced == null)
        this.serviced = new DateType();
      if (!(this.serviced instanceof DateType))
        throw new FHIRException("Type mismatch: the type DateType was expected, but "+this.serviced.getClass().getName()+" was encountered");
      return (DateType) this.serviced;
    }

    public boolean hasServicedDateType() { 
      return this != null && this.serviced instanceof DateType;
    }

    /**
     * @return {@link #serviced} (The date or dates when the enclosed suite of services were performed or completed.)
     */
    public Period getServicedPeriod() throws FHIRException { 
      if (this.serviced == null)
        this.serviced = new Period();
      if (!(this.serviced instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.serviced.getClass().getName()+" was encountered");
      return (Period) this.serviced;
    }

    public boolean hasServicedPeriod() { 
      return this != null && this.serviced instanceof Period;
    }

    public boolean hasServiced() { 
      return this.serviced != null && !this.serviced.isEmpty();
    }

    /**
     * @param value {@link #serviced} (The date or dates when the enclosed suite of services were performed or completed.)
     */
    public CoverageEligibilityResponse setServiced(Type value) { 
      if (value != null && !(value instanceof DateType || value instanceof Period))
        throw new Error("Not the right type for CoverageEligibilityResponse.serviced[x]: "+value.fhirType());
      this.serviced = value;
      return this;
    }

    /**
     * @return {@link #created} (The date this resource was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public DateTimeType getCreatedElement() { 
      if (this.created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.created");
        else if (Configuration.doAutoCreate())
          this.created = new DateTimeType(); // bb
      return this.created;
    }

    public boolean hasCreatedElement() { 
      return this.created != null && !this.created.isEmpty();
    }

    public boolean hasCreated() { 
      return this.created != null && !this.created.isEmpty();
    }

    /**
     * @param value {@link #created} (The date this resource was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public CoverageEligibilityResponse setCreatedElement(DateTimeType value) { 
      this.created = value;
      return this;
    }

    /**
     * @return The date this resource was created.
     */
    public Date getCreated() { 
      return this.created == null ? null : this.created.getValue();
    }

    /**
     * @param value The date this resource was created.
     */
    public CoverageEligibilityResponse setCreated(Date value) { 
        if (this.created == null)
          this.created = new DateTimeType();
        this.created.setValue(value);
      return this;
    }

    /**
     * @return {@link #requestor} (The provider which is responsible for the request.)
     */
    public Reference getRequestor() { 
      if (this.requestor == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.requestor");
        else if (Configuration.doAutoCreate())
          this.requestor = new Reference(); // cc
      return this.requestor;
    }

    public boolean hasRequestor() { 
      return this.requestor != null && !this.requestor.isEmpty();
    }

    /**
     * @param value {@link #requestor} (The provider which is responsible for the request.)
     */
    public CoverageEligibilityResponse setRequestor(Reference value) { 
      this.requestor = value;
      return this;
    }

    /**
     * @return {@link #requestor} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The provider which is responsible for the request.)
     */
    public Resource getRequestorTarget() { 
      return this.requestorTarget;
    }

    /**
     * @param value {@link #requestor} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The provider which is responsible for the request.)
     */
    public CoverageEligibilityResponse setRequestorTarget(Resource value) { 
      this.requestorTarget = value;
      return this;
    }

    /**
     * @return {@link #request} (Reference to the original request resource.)
     */
    public Reference getRequest() { 
      if (this.request == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.request");
        else if (Configuration.doAutoCreate())
          this.request = new Reference(); // cc
      return this.request;
    }

    public boolean hasRequest() { 
      return this.request != null && !this.request.isEmpty();
    }

    /**
     * @param value {@link #request} (Reference to the original request resource.)
     */
    public CoverageEligibilityResponse setRequest(Reference value) { 
      this.request = value;
      return this;
    }

    /**
     * @return {@link #request} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (Reference to the original request resource.)
     */
    public CoverageEligibilityRequest getRequestTarget() { 
      if (this.requestTarget == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.request");
        else if (Configuration.doAutoCreate())
          this.requestTarget = new CoverageEligibilityRequest(); // aa
      return this.requestTarget;
    }

    /**
     * @param value {@link #request} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (Reference to the original request resource.)
     */
    public CoverageEligibilityResponse setRequestTarget(CoverageEligibilityRequest value) { 
      this.requestTarget = value;
      return this;
    }

    /**
     * @return {@link #outcome} (The outcome of the request processing.). This is the underlying object with id, value and extensions. The accessor "getOutcome" gives direct access to the value
     */
    public Enumeration<RemittanceOutcome> getOutcomeElement() { 
      if (this.outcome == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.outcome");
        else if (Configuration.doAutoCreate())
          this.outcome = new Enumeration<RemittanceOutcome>(new RemittanceOutcomeEnumFactory()); // bb
      return this.outcome;
    }

    public boolean hasOutcomeElement() { 
      return this.outcome != null && !this.outcome.isEmpty();
    }

    public boolean hasOutcome() { 
      return this.outcome != null && !this.outcome.isEmpty();
    }

    /**
     * @param value {@link #outcome} (The outcome of the request processing.). This is the underlying object with id, value and extensions. The accessor "getOutcome" gives direct access to the value
     */
    public CoverageEligibilityResponse setOutcomeElement(Enumeration<RemittanceOutcome> value) { 
      this.outcome = value;
      return this;
    }

    /**
     * @return The outcome of the request processing.
     */
    public RemittanceOutcome getOutcome() { 
      return this.outcome == null ? null : this.outcome.getValue();
    }

    /**
     * @param value The outcome of the request processing.
     */
    public CoverageEligibilityResponse setOutcome(RemittanceOutcome value) { 
        if (this.outcome == null)
          this.outcome = new Enumeration<RemittanceOutcome>(new RemittanceOutcomeEnumFactory());
        this.outcome.setValue(value);
      return this;
    }

    /**
     * @return {@link #disposition} (A human readable description of the status of the adjudication.). This is the underlying object with id, value and extensions. The accessor "getDisposition" gives direct access to the value
     */
    public StringType getDispositionElement() { 
      if (this.disposition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.disposition");
        else if (Configuration.doAutoCreate())
          this.disposition = new StringType(); // bb
      return this.disposition;
    }

    public boolean hasDispositionElement() { 
      return this.disposition != null && !this.disposition.isEmpty();
    }

    public boolean hasDisposition() { 
      return this.disposition != null && !this.disposition.isEmpty();
    }

    /**
     * @param value {@link #disposition} (A human readable description of the status of the adjudication.). This is the underlying object with id, value and extensions. The accessor "getDisposition" gives direct access to the value
     */
    public CoverageEligibilityResponse setDispositionElement(StringType value) { 
      this.disposition = value;
      return this;
    }

    /**
     * @return A human readable description of the status of the adjudication.
     */
    public String getDisposition() { 
      return this.disposition == null ? null : this.disposition.getValue();
    }

    /**
     * @param value A human readable description of the status of the adjudication.
     */
    public CoverageEligibilityResponse setDisposition(String value) { 
      if (Utilities.noString(value))
        this.disposition = null;
      else {
        if (this.disposition == null)
          this.disposition = new StringType();
        this.disposition.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #insurer} (The Insurer who issued the coverage in question and is the author of the response.)
     */
    public Reference getInsurer() { 
      if (this.insurer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.insurer");
        else if (Configuration.doAutoCreate())
          this.insurer = new Reference(); // cc
      return this.insurer;
    }

    public boolean hasInsurer() { 
      return this.insurer != null && !this.insurer.isEmpty();
    }

    /**
     * @param value {@link #insurer} (The Insurer who issued the coverage in question and is the author of the response.)
     */
    public CoverageEligibilityResponse setInsurer(Reference value) { 
      this.insurer = value;
      return this;
    }

    /**
     * @return {@link #insurer} The actual object that is the target of the reference. The reference library doesn't populate this, but you can use it to hold the resource if you resolve it. (The Insurer who issued the coverage in question and is the author of the response.)
     */
    public Organization getInsurerTarget() { 
      if (this.insurerTarget == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.insurer");
        else if (Configuration.doAutoCreate())
          this.insurerTarget = new Organization(); // aa
      return this.insurerTarget;
    }

    /**
     * @param value {@link #insurer} The actual object that is the target of the reference. The reference library doesn't use these, but you can use it to hold the resource if you resolve it. (The Insurer who issued the coverage in question and is the author of the response.)
     */
    public CoverageEligibilityResponse setInsurerTarget(Organization value) { 
      this.insurerTarget = value;
      return this;
    }

    /**
     * @return {@link #insurance} (Financial instruments for reimbursement for the health care products and services.)
     */
    public List<InsuranceComponent> getInsurance() { 
      if (this.insurance == null)
        this.insurance = new ArrayList<InsuranceComponent>();
      return this.insurance;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CoverageEligibilityResponse setInsurance(List<InsuranceComponent> theInsurance) { 
      this.insurance = theInsurance;
      return this;
    }

    public boolean hasInsurance() { 
      if (this.insurance == null)
        return false;
      for (InsuranceComponent item : this.insurance)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public InsuranceComponent addInsurance() { //3
      InsuranceComponent t = new InsuranceComponent();
      if (this.insurance == null)
        this.insurance = new ArrayList<InsuranceComponent>();
      this.insurance.add(t);
      return t;
    }

    public CoverageEligibilityResponse addInsurance(InsuranceComponent t) { //3
      if (t == null)
        return this;
      if (this.insurance == null)
        this.insurance = new ArrayList<InsuranceComponent>();
      this.insurance.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #insurance}, creating it if it does not already exist
     */
    public InsuranceComponent getInsuranceFirstRep() { 
      if (getInsurance().isEmpty()) {
        addInsurance();
      }
      return getInsurance().get(0);
    }

    /**
     * @return {@link #preAuthRef} (A reference from the Insurer to which these services pertain to be used on further communication and as proof that the request occurred.). This is the underlying object with id, value and extensions. The accessor "getPreAuthRef" gives direct access to the value
     */
    public StringType getPreAuthRefElement() { 
      if (this.preAuthRef == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.preAuthRef");
        else if (Configuration.doAutoCreate())
          this.preAuthRef = new StringType(); // bb
      return this.preAuthRef;
    }

    public boolean hasPreAuthRefElement() { 
      return this.preAuthRef != null && !this.preAuthRef.isEmpty();
    }

    public boolean hasPreAuthRef() { 
      return this.preAuthRef != null && !this.preAuthRef.isEmpty();
    }

    /**
     * @param value {@link #preAuthRef} (A reference from the Insurer to which these services pertain to be used on further communication and as proof that the request occurred.). This is the underlying object with id, value and extensions. The accessor "getPreAuthRef" gives direct access to the value
     */
    public CoverageEligibilityResponse setPreAuthRefElement(StringType value) { 
      this.preAuthRef = value;
      return this;
    }

    /**
     * @return A reference from the Insurer to which these services pertain to be used on further communication and as proof that the request occurred.
     */
    public String getPreAuthRef() { 
      return this.preAuthRef == null ? null : this.preAuthRef.getValue();
    }

    /**
     * @param value A reference from the Insurer to which these services pertain to be used on further communication and as proof that the request occurred.
     */
    public CoverageEligibilityResponse setPreAuthRef(String value) { 
      if (Utilities.noString(value))
        this.preAuthRef = null;
      else {
        if (this.preAuthRef == null)
          this.preAuthRef = new StringType();
        this.preAuthRef.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #form} (A code for the form to be used for printing the content.)
     */
    public CodeableConcept getForm() { 
      if (this.form == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create CoverageEligibilityResponse.form");
        else if (Configuration.doAutoCreate())
          this.form = new CodeableConcept(); // cc
      return this.form;
    }

    public boolean hasForm() { 
      return this.form != null && !this.form.isEmpty();
    }

    /**
     * @param value {@link #form} (A code for the form to be used for printing the content.)
     */
    public CoverageEligibilityResponse setForm(CodeableConcept value) { 
      this.form = value;
      return this;
    }

    /**
     * @return {@link #error} (Errors encountered during the processing of the request.)
     */
    public List<ErrorsComponent> getError() { 
      if (this.error == null)
        this.error = new ArrayList<ErrorsComponent>();
      return this.error;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public CoverageEligibilityResponse setError(List<ErrorsComponent> theError) { 
      this.error = theError;
      return this;
    }

    public boolean hasError() { 
      if (this.error == null)
        return false;
      for (ErrorsComponent item : this.error)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ErrorsComponent addError() { //3
      ErrorsComponent t = new ErrorsComponent();
      if (this.error == null)
        this.error = new ArrayList<ErrorsComponent>();
      this.error.add(t);
      return t;
    }

    public CoverageEligibilityResponse addError(ErrorsComponent t) { //3
      if (t == null)
        return this;
      if (this.error == null)
        this.error = new ArrayList<ErrorsComponent>();
      this.error.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #error}, creating it if it does not already exist
     */
    public ErrorsComponent getErrorFirstRep() { 
      if (getError().isEmpty()) {
        addError();
      }
      return getError().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier assigned to this coverage eligiblity request.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("status", "code", "The status of the resource instance.", 0, 1, status));
        children.add(new Property("purpose", "code", "Code to specify whether requesting: prior authorization requirements for some service categories or billing codes; benefits for coverages specified or discovered; discovery and return of coverages for the patient; and/or validation that the specified coverage is in-force at the date/period specified or 'now' if not specified.", 0, java.lang.Integer.MAX_VALUE, purpose));
        children.add(new Property("patient", "Reference(Patient)", "The party who is the beneficiary of the supplied coverage and for whom eligibility is sought.", 0, 1, patient));
        children.add(new Property("serviced[x]", "date|Period", "The date or dates when the enclosed suite of services were performed or completed.", 0, 1, serviced));
        children.add(new Property("created", "dateTime", "The date this resource was created.", 0, 1, created));
        children.add(new Property("requestor", "Reference(Practitioner|PractitionerRole|Organization)", "The provider which is responsible for the request.", 0, 1, requestor));
        children.add(new Property("request", "Reference(CoverageEligibilityRequest)", "Reference to the original request resource.", 0, 1, request));
        children.add(new Property("outcome", "code", "The outcome of the request processing.", 0, 1, outcome));
        children.add(new Property("disposition", "string", "A human readable description of the status of the adjudication.", 0, 1, disposition));
        children.add(new Property("insurer", "Reference(Organization)", "The Insurer who issued the coverage in question and is the author of the response.", 0, 1, insurer));
        children.add(new Property("insurance", "", "Financial instruments for reimbursement for the health care products and services.", 0, java.lang.Integer.MAX_VALUE, insurance));
        children.add(new Property("preAuthRef", "string", "A reference from the Insurer to which these services pertain to be used on further communication and as proof that the request occurred.", 0, 1, preAuthRef));
        children.add(new Property("form", "CodeableConcept", "A code for the form to be used for printing the content.", 0, 1, form));
        children.add(new Property("error", "", "Errors encountered during the processing of the request.", 0, java.lang.Integer.MAX_VALUE, error));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier assigned to this coverage eligiblity request.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the resource instance.", 0, 1, status);
        case -220463842: /*purpose*/  return new Property("purpose", "code", "Code to specify whether requesting: prior authorization requirements for some service categories or billing codes; benefits for coverages specified or discovered; discovery and return of coverages for the patient; and/or validation that the specified coverage is in-force at the date/period specified or 'now' if not specified.", 0, java.lang.Integer.MAX_VALUE, purpose);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "The party who is the beneficiary of the supplied coverage and for whom eligibility is sought.", 0, 1, patient);
        case -1927922223: /*serviced[x]*/  return new Property("serviced[x]", "date|Period", "The date or dates when the enclosed suite of services were performed or completed.", 0, 1, serviced);
        case 1379209295: /*serviced*/  return new Property("serviced[x]", "date|Period", "The date or dates when the enclosed suite of services were performed or completed.", 0, 1, serviced);
        case 363246749: /*servicedDate*/  return new Property("serviced[x]", "date|Period", "The date or dates when the enclosed suite of services were performed or completed.", 0, 1, serviced);
        case 1534966512: /*servicedPeriod*/  return new Property("serviced[x]", "date|Period", "The date or dates when the enclosed suite of services were performed or completed.", 0, 1, serviced);
        case 1028554472: /*created*/  return new Property("created", "dateTime", "The date this resource was created.", 0, 1, created);
        case 693934258: /*requestor*/  return new Property("requestor", "Reference(Practitioner|PractitionerRole|Organization)", "The provider which is responsible for the request.", 0, 1, requestor);
        case 1095692943: /*request*/  return new Property("request", "Reference(CoverageEligibilityRequest)", "Reference to the original request resource.", 0, 1, request);
        case -1106507950: /*outcome*/  return new Property("outcome", "code", "The outcome of the request processing.", 0, 1, outcome);
        case 583380919: /*disposition*/  return new Property("disposition", "string", "A human readable description of the status of the adjudication.", 0, 1, disposition);
        case 1957615864: /*insurer*/  return new Property("insurer", "Reference(Organization)", "The Insurer who issued the coverage in question and is the author of the response.", 0, 1, insurer);
        case 73049818: /*insurance*/  return new Property("insurance", "", "Financial instruments for reimbursement for the health care products and services.", 0, java.lang.Integer.MAX_VALUE, insurance);
        case 522246568: /*preAuthRef*/  return new Property("preAuthRef", "string", "A reference from the Insurer to which these services pertain to be used on further communication and as proof that the request occurred.", 0, 1, preAuthRef);
        case 3148996: /*form*/  return new Property("form", "CodeableConcept", "A code for the form to be used for printing the content.", 0, 1, form);
        case 96784904: /*error*/  return new Property("error", "", "Errors encountered during the processing of the request.", 0, java.lang.Integer.MAX_VALUE, error);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<EligibilityResponseStatus>
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : this.purpose.toArray(new Base[this.purpose.size()]); // Enumeration<EligibilityResponsePurpose>
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case 1379209295: /*serviced*/ return this.serviced == null ? new Base[0] : new Base[] {this.serviced}; // Type
        case 1028554472: /*created*/ return this.created == null ? new Base[0] : new Base[] {this.created}; // DateTimeType
        case 693934258: /*requestor*/ return this.requestor == null ? new Base[0] : new Base[] {this.requestor}; // Reference
        case 1095692943: /*request*/ return this.request == null ? new Base[0] : new Base[] {this.request}; // Reference
        case -1106507950: /*outcome*/ return this.outcome == null ? new Base[0] : new Base[] {this.outcome}; // Enumeration<RemittanceOutcome>
        case 583380919: /*disposition*/ return this.disposition == null ? new Base[0] : new Base[] {this.disposition}; // StringType
        case 1957615864: /*insurer*/ return this.insurer == null ? new Base[0] : new Base[] {this.insurer}; // Reference
        case 73049818: /*insurance*/ return this.insurance == null ? new Base[0] : this.insurance.toArray(new Base[this.insurance.size()]); // InsuranceComponent
        case 522246568: /*preAuthRef*/ return this.preAuthRef == null ? new Base[0] : new Base[] {this.preAuthRef}; // StringType
        case 3148996: /*form*/ return this.form == null ? new Base[0] : new Base[] {this.form}; // CodeableConcept
        case 96784904: /*error*/ return this.error == null ? new Base[0] : this.error.toArray(new Base[this.error.size()]); // ErrorsComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(castToIdentifier(value)); // Identifier
          return value;
        case -892481550: // status
          value = new EligibilityResponseStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EligibilityResponseStatus>
          return value;
        case -220463842: // purpose
          value = new EligibilityResponsePurposeEnumFactory().fromType(castToCode(value));
          this.getPurpose().add((Enumeration) value); // Enumeration<EligibilityResponsePurpose>
          return value;
        case -791418107: // patient
          this.patient = castToReference(value); // Reference
          return value;
        case 1379209295: // serviced
          this.serviced = castToType(value); // Type
          return value;
        case 1028554472: // created
          this.created = castToDateTime(value); // DateTimeType
          return value;
        case 693934258: // requestor
          this.requestor = castToReference(value); // Reference
          return value;
        case 1095692943: // request
          this.request = castToReference(value); // Reference
          return value;
        case -1106507950: // outcome
          value = new RemittanceOutcomeEnumFactory().fromType(castToCode(value));
          this.outcome = (Enumeration) value; // Enumeration<RemittanceOutcome>
          return value;
        case 583380919: // disposition
          this.disposition = castToString(value); // StringType
          return value;
        case 1957615864: // insurer
          this.insurer = castToReference(value); // Reference
          return value;
        case 73049818: // insurance
          this.getInsurance().add((InsuranceComponent) value); // InsuranceComponent
          return value;
        case 522246568: // preAuthRef
          this.preAuthRef = castToString(value); // StringType
          return value;
        case 3148996: // form
          this.form = castToCodeableConcept(value); // CodeableConcept
          return value;
        case 96784904: // error
          this.getError().add((ErrorsComponent) value); // ErrorsComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(castToIdentifier(value));
        } else if (name.equals("status")) {
          value = new EligibilityResponseStatusEnumFactory().fromType(castToCode(value));
          this.status = (Enumeration) value; // Enumeration<EligibilityResponseStatus>
        } else if (name.equals("purpose")) {
          value = new EligibilityResponsePurposeEnumFactory().fromType(castToCode(value));
          this.getPurpose().add((Enumeration) value);
        } else if (name.equals("patient")) {
          this.patient = castToReference(value); // Reference
        } else if (name.equals("serviced[x]")) {
          this.serviced = castToType(value); // Type
        } else if (name.equals("created")) {
          this.created = castToDateTime(value); // DateTimeType
        } else if (name.equals("requestor")) {
          this.requestor = castToReference(value); // Reference
        } else if (name.equals("request")) {
          this.request = castToReference(value); // Reference
        } else if (name.equals("outcome")) {
          value = new RemittanceOutcomeEnumFactory().fromType(castToCode(value));
          this.outcome = (Enumeration) value; // Enumeration<RemittanceOutcome>
        } else if (name.equals("disposition")) {
          this.disposition = castToString(value); // StringType
        } else if (name.equals("insurer")) {
          this.insurer = castToReference(value); // Reference
        } else if (name.equals("insurance")) {
          this.getInsurance().add((InsuranceComponent) value);
        } else if (name.equals("preAuthRef")) {
          this.preAuthRef = castToString(value); // StringType
        } else if (name.equals("form")) {
          this.form = castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("error")) {
          this.getError().add((ErrorsComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -892481550:  return getStatusElement();
        case -220463842:  return addPurposeElement();
        case -791418107:  return getPatient(); 
        case -1927922223:  return getServiced(); 
        case 1379209295:  return getServiced(); 
        case 1028554472:  return getCreatedElement();
        case 693934258:  return getRequestor(); 
        case 1095692943:  return getRequest(); 
        case -1106507950:  return getOutcomeElement();
        case 583380919:  return getDispositionElement();
        case 1957615864:  return getInsurer(); 
        case 73049818:  return addInsurance(); 
        case 522246568:  return getPreAuthRefElement();
        case 3148996:  return getForm(); 
        case 96784904:  return addError(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -220463842: /*purpose*/ return new String[] {"code"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case 1379209295: /*serviced*/ return new String[] {"date", "Period"};
        case 1028554472: /*created*/ return new String[] {"dateTime"};
        case 693934258: /*requestor*/ return new String[] {"Reference"};
        case 1095692943: /*request*/ return new String[] {"Reference"};
        case -1106507950: /*outcome*/ return new String[] {"code"};
        case 583380919: /*disposition*/ return new String[] {"string"};
        case 1957615864: /*insurer*/ return new String[] {"Reference"};
        case 73049818: /*insurance*/ return new String[] {};
        case 522246568: /*preAuthRef*/ return new String[] {"string"};
        case 3148996: /*form*/ return new String[] {"CodeableConcept"};
        case 96784904: /*error*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.status");
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.purpose");
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("servicedDate")) {
          this.serviced = new DateType();
          return this.serviced;
        }
        else if (name.equals("servicedPeriod")) {
          this.serviced = new Period();
          return this.serviced;
        }
        else if (name.equals("created")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.created");
        }
        else if (name.equals("requestor")) {
          this.requestor = new Reference();
          return this.requestor;
        }
        else if (name.equals("request")) {
          this.request = new Reference();
          return this.request;
        }
        else if (name.equals("outcome")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.outcome");
        }
        else if (name.equals("disposition")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.disposition");
        }
        else if (name.equals("insurer")) {
          this.insurer = new Reference();
          return this.insurer;
        }
        else if (name.equals("insurance")) {
          return addInsurance();
        }
        else if (name.equals("preAuthRef")) {
          throw new FHIRException("Cannot call addChild on a primitive type CoverageEligibilityResponse.preAuthRef");
        }
        else if (name.equals("form")) {
          this.form = new CodeableConcept();
          return this.form;
        }
        else if (name.equals("error")) {
          return addError();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "CoverageEligibilityResponse";

  }

      public CoverageEligibilityResponse copy() {
        CoverageEligibilityResponse dst = new CoverageEligibilityResponse();
        copyValues(dst);
        return dst;
      }

      public void copyValues(CoverageEligibilityResponse dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (purpose != null) {
          dst.purpose = new ArrayList<Enumeration<EligibilityResponsePurpose>>();
          for (Enumeration<EligibilityResponsePurpose> i : purpose)
            dst.purpose.add(i.copy());
        };
        dst.patient = patient == null ? null : patient.copy();
        dst.serviced = serviced == null ? null : serviced.copy();
        dst.created = created == null ? null : created.copy();
        dst.requestor = requestor == null ? null : requestor.copy();
        dst.request = request == null ? null : request.copy();
        dst.outcome = outcome == null ? null : outcome.copy();
        dst.disposition = disposition == null ? null : disposition.copy();
        dst.insurer = insurer == null ? null : insurer.copy();
        if (insurance != null) {
          dst.insurance = new ArrayList<InsuranceComponent>();
          for (InsuranceComponent i : insurance)
            dst.insurance.add(i.copy());
        };
        dst.preAuthRef = preAuthRef == null ? null : preAuthRef.copy();
        dst.form = form == null ? null : form.copy();
        if (error != null) {
          dst.error = new ArrayList<ErrorsComponent>();
          for (ErrorsComponent i : error)
            dst.error.add(i.copy());
        };
      }

      protected CoverageEligibilityResponse typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof CoverageEligibilityResponse))
          return false;
        CoverageEligibilityResponse o = (CoverageEligibilityResponse) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(purpose, o.purpose, true)
           && compareDeep(patient, o.patient, true) && compareDeep(serviced, o.serviced, true) && compareDeep(created, o.created, true)
           && compareDeep(requestor, o.requestor, true) && compareDeep(request, o.request, true) && compareDeep(outcome, o.outcome, true)
           && compareDeep(disposition, o.disposition, true) && compareDeep(insurer, o.insurer, true) && compareDeep(insurance, o.insurance, true)
           && compareDeep(preAuthRef, o.preAuthRef, true) && compareDeep(form, o.form, true) && compareDeep(error, o.error, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof CoverageEligibilityResponse))
          return false;
        CoverageEligibilityResponse o = (CoverageEligibilityResponse) other_;
        return compareValues(status, o.status, true) && compareValues(purpose, o.purpose, true) && compareValues(created, o.created, true)
           && compareValues(outcome, o.outcome, true) && compareValues(disposition, o.disposition, true) && compareValues(preAuthRef, o.preAuthRef, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, purpose
          , patient, serviced, created, requestor, request, outcome, disposition, insurer
          , insurance, preAuthRef, form, error);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.CoverageEligibilityResponse;
   }

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The business identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CoverageEligibilityResponse.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="CoverageEligibilityResponse.identifier", description="The business identifier", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The business identifier</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CoverageEligibilityResponse.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>request</b>
   * <p>
   * Description: <b>The EligibilityRequest reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CoverageEligibilityResponse.request</b><br>
   * </p>
   */
  @SearchParamDefinition(name="request", path="CoverageEligibilityResponse.request", description="The EligibilityRequest reference", type="reference", target={CoverageEligibilityRequest.class } )
  public static final String SP_REQUEST = "request";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>request</b>
   * <p>
   * Description: <b>The EligibilityRequest reference</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CoverageEligibilityResponse.request</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUEST = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REQUEST);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CoverageEligibilityResponse:request</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUEST = new ca.uhn.fhir.model.api.Include("CoverageEligibilityResponse:request").toLocked();

 /**
   * Search parameter: <b>disposition</b>
   * <p>
   * Description: <b>The contents of the disposition message</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CoverageEligibilityResponse.disposition</b><br>
   * </p>
   */
  @SearchParamDefinition(name="disposition", path="CoverageEligibilityResponse.disposition", description="The contents of the disposition message", type="string" )
  public static final String SP_DISPOSITION = "disposition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>disposition</b>
   * <p>
   * Description: <b>The contents of the disposition message</b><br>
   * Type: <b>string</b><br>
   * Path: <b>CoverageEligibilityResponse.disposition</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DISPOSITION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DISPOSITION);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>The reference to the patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CoverageEligibilityResponse.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="CoverageEligibilityResponse.patient", description="The reference to the patient", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>The reference to the patient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CoverageEligibilityResponse.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CoverageEligibilityResponse:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("CoverageEligibilityResponse:patient").toLocked();

 /**
   * Search parameter: <b>insurer</b>
   * <p>
   * Description: <b>The organization which generated this resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CoverageEligibilityResponse.insurer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="insurer", path="CoverageEligibilityResponse.insurer", description="The organization which generated this resource", type="reference", target={Organization.class } )
  public static final String SP_INSURER = "insurer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>insurer</b>
   * <p>
   * Description: <b>The organization which generated this resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CoverageEligibilityResponse.insurer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INSURER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INSURER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CoverageEligibilityResponse:insurer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INSURER = new ca.uhn.fhir.model.api.Include("CoverageEligibilityResponse:insurer").toLocked();

 /**
   * Search parameter: <b>created</b>
   * <p>
   * Description: <b>The creation date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CoverageEligibilityResponse.created</b><br>
   * </p>
   */
  @SearchParamDefinition(name="created", path="CoverageEligibilityResponse.created", description="The creation date", type="date" )
  public static final String SP_CREATED = "created";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>created</b>
   * <p>
   * Description: <b>The creation date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>CoverageEligibilityResponse.created</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam CREATED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_CREATED);

 /**
   * Search parameter: <b>outcome</b>
   * <p>
   * Description: <b>The processing outcome</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CoverageEligibilityResponse.outcome</b><br>
   * </p>
   */
  @SearchParamDefinition(name="outcome", path="CoverageEligibilityResponse.outcome", description="The processing outcome", type="token" )
  public static final String SP_OUTCOME = "outcome";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>outcome</b>
   * <p>
   * Description: <b>The processing outcome</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CoverageEligibilityResponse.outcome</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam OUTCOME = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_OUTCOME);

 /**
   * Search parameter: <b>requestor</b>
   * <p>
   * Description: <b>The EligibilityRequest provider</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CoverageEligibilityResponse.requestor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="requestor", path="CoverageEligibilityResponse.requestor", description="The EligibilityRequest provider", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Practitioner") }, target={Organization.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_REQUESTOR = "requestor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>requestor</b>
   * <p>
   * Description: <b>The EligibilityRequest provider</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>CoverageEligibilityResponse.requestor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUESTOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REQUESTOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>CoverageEligibilityResponse:requestor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUESTOR = new ca.uhn.fhir.model.api.Include("CoverageEligibilityResponse:requestor").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The EligibilityRequest status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CoverageEligibilityResponse.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="CoverageEligibilityResponse.status", description="The EligibilityRequest status", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The EligibilityRequest status</b><br>
   * Type: <b>token</b><br>
   * Path: <b>CoverageEligibilityResponse.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}