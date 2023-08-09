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
 * The resource ChargeItem describes the provision of healthcare provider products for a certain patient, therefore referring not only to the product, but containing in addition details of the provision, like date, time, amounts and participating organizations and persons. Main Usage of the ChargeItem is to enable the billing process and internal cost allocation.
 */
@ResourceDef(name="ChargeItem", profile="http://hl7.org/fhir/StructureDefinition/ChargeItem")
public class ChargeItem extends DomainResource {

    public enum ChargeItemStatus {
        /**
         * The charge item has been entered, but the charged service is not  yet complete, so it shall not be billed yet but might be used in the context of pre-authorization.
         */
        PLANNED, 
        /**
         * The charge item is ready for billing.
         */
        BILLABLE, 
        /**
         * The charge item has been determined to be not billable (e.g. due to rules associated with the billing code).
         */
        NOTBILLABLE, 
        /**
         * The processing of the charge was aborted.
         */
        ABORTED, 
        /**
         * The charge item has been billed (e.g. a billing engine has generated financial transactions by applying the associated ruled for the charge item to the context of the Encounter, and placed them into Claims/Invoices.
         */
        BILLED, 
        /**
         * The charge item has been entered in error and should not be processed for billing.
         */
        ENTEREDINERROR, 
        /**
         * The authoring system does not know which of the status values currently applies for this charge item  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, it's just not known which one.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ChargeItemStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("planned".equals(codeString))
          return PLANNED;
        if ("billable".equals(codeString))
          return BILLABLE;
        if ("not-billable".equals(codeString))
          return NOTBILLABLE;
        if ("aborted".equals(codeString))
          return ABORTED;
        if ("billed".equals(codeString))
          return BILLED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ChargeItemStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PLANNED: return "planned";
            case BILLABLE: return "billable";
            case NOTBILLABLE: return "not-billable";
            case ABORTED: return "aborted";
            case BILLED: return "billed";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PLANNED: return "http://hl7.org/fhir/chargeitem-status";
            case BILLABLE: return "http://hl7.org/fhir/chargeitem-status";
            case NOTBILLABLE: return "http://hl7.org/fhir/chargeitem-status";
            case ABORTED: return "http://hl7.org/fhir/chargeitem-status";
            case BILLED: return "http://hl7.org/fhir/chargeitem-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/chargeitem-status";
            case UNKNOWN: return "http://hl7.org/fhir/chargeitem-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PLANNED: return "The charge item has been entered, but the charged service is not  yet complete, so it shall not be billed yet but might be used in the context of pre-authorization.";
            case BILLABLE: return "The charge item is ready for billing.";
            case NOTBILLABLE: return "The charge item has been determined to be not billable (e.g. due to rules associated with the billing code).";
            case ABORTED: return "The processing of the charge was aborted.";
            case BILLED: return "The charge item has been billed (e.g. a billing engine has generated financial transactions by applying the associated ruled for the charge item to the context of the Encounter, and placed them into Claims/Invoices.";
            case ENTEREDINERROR: return "The charge item has been entered in error and should not be processed for billing.";
            case UNKNOWN: return "The authoring system does not know which of the status values currently applies for this charge item  Note: This concept is not to be used for \"other\" - one of the listed statuses is presumed to apply, it's just not known which one.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PLANNED: return "Planned";
            case BILLABLE: return "Billable";
            case NOTBILLABLE: return "Not billable";
            case ABORTED: return "Aborted";
            case BILLED: return "Billed";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ChargeItemStatusEnumFactory implements EnumFactory<ChargeItemStatus> {
    public ChargeItemStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("planned".equals(codeString))
          return ChargeItemStatus.PLANNED;
        if ("billable".equals(codeString))
          return ChargeItemStatus.BILLABLE;
        if ("not-billable".equals(codeString))
          return ChargeItemStatus.NOTBILLABLE;
        if ("aborted".equals(codeString))
          return ChargeItemStatus.ABORTED;
        if ("billed".equals(codeString))
          return ChargeItemStatus.BILLED;
        if ("entered-in-error".equals(codeString))
          return ChargeItemStatus.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return ChargeItemStatus.UNKNOWN;
        throw new IllegalArgumentException("Unknown ChargeItemStatus code '"+codeString+"'");
        }
        public Enumeration<ChargeItemStatus> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ChargeItemStatus>(this, ChargeItemStatus.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ChargeItemStatus>(this, ChargeItemStatus.NULL, code);
        if ("planned".equals(codeString))
          return new Enumeration<ChargeItemStatus>(this, ChargeItemStatus.PLANNED, code);
        if ("billable".equals(codeString))
          return new Enumeration<ChargeItemStatus>(this, ChargeItemStatus.BILLABLE, code);
        if ("not-billable".equals(codeString))
          return new Enumeration<ChargeItemStatus>(this, ChargeItemStatus.NOTBILLABLE, code);
        if ("aborted".equals(codeString))
          return new Enumeration<ChargeItemStatus>(this, ChargeItemStatus.ABORTED, code);
        if ("billed".equals(codeString))
          return new Enumeration<ChargeItemStatus>(this, ChargeItemStatus.BILLED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<ChargeItemStatus>(this, ChargeItemStatus.ENTEREDINERROR, code);
        if ("unknown".equals(codeString))
          return new Enumeration<ChargeItemStatus>(this, ChargeItemStatus.UNKNOWN, code);
        throw new FHIRException("Unknown ChargeItemStatus code '"+codeString+"'");
        }
    public String toCode(ChargeItemStatus code) {
      if (code == ChargeItemStatus.PLANNED)
        return "planned";
      if (code == ChargeItemStatus.BILLABLE)
        return "billable";
      if (code == ChargeItemStatus.NOTBILLABLE)
        return "not-billable";
      if (code == ChargeItemStatus.ABORTED)
        return "aborted";
      if (code == ChargeItemStatus.BILLED)
        return "billed";
      if (code == ChargeItemStatus.ENTEREDINERROR)
        return "entered-in-error";
      if (code == ChargeItemStatus.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(ChargeItemStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ChargeItemPerformerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Describes the type of performance or participation(e.g. primary surgeon, anesthesiologiest, etc.).
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What type of performance was done", formalDefinition="Describes the type of performance or participation(e.g. primary surgeon, anesthesiologiest, etc.)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/performer-role")
        protected CodeableConcept function;

        /**
         * The device, practitioner, etc. who performed or participated in the service.
         */
        @Child(name = "actor", type = {Practitioner.class, PractitionerRole.class, Organization.class, HealthcareService.class, CareTeam.class, Patient.class, Device.class, RelatedPerson.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Individual who was performing", formalDefinition="The device, practitioner, etc. who performed or participated in the service." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

    /**
     * Constructor
     */
      public ChargeItemPerformerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ChargeItemPerformerComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #function} (Describes the type of performance or participation(e.g. primary surgeon, anesthesiologiest, etc.).)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ChargeItemPerformerComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Describes the type of performance or participation(e.g. primary surgeon, anesthesiologiest, etc.).)
         */
        public ChargeItemPerformerComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (The device, practitioner, etc. who performed or participated in the service.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ChargeItemPerformerComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (The device, practitioner, etc. who performed or participated in the service.)
         */
        public ChargeItemPerformerComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Describes the type of performance or participation(e.g. primary surgeon, anesthesiologiest, etc.).", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|HealthcareService|CareTeam|Patient|Device|RelatedPerson)", "The device, practitioner, etc. who performed or participated in the service.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Describes the type of performance or participation(e.g. primary surgeon, anesthesiologiest, etc.).", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner|PractitionerRole|Organization|HealthcareService|CareTeam|Patient|Device|RelatedPerson)", "The device, practitioner, etc. who performed or participated in the service.", 0, 1, actor);
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

      public ChargeItemPerformerComponent copy() {
        ChargeItemPerformerComponent dst = new ChargeItemPerformerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ChargeItemPerformerComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ChargeItemPerformerComponent))
          return false;
        ChargeItemPerformerComponent o = (ChargeItemPerformerComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ChargeItemPerformerComponent))
          return false;
        ChargeItemPerformerComponent o = (ChargeItemPerformerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "ChargeItem.performer";

  }

  }

    /**
     * Identifiers assigned to this event performer or other systems.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business Identifier for item", formalDefinition="Identifiers assigned to this event performer or other systems." )
    protected List<Identifier> identifier;

    /**
     * References the (external) source of pricing information, rules of application for the code this ChargeItem uses.
     */
    @Child(name = "definitionUri", type = {UriType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Defining information about the code of this charge item", formalDefinition="References the (external) source of pricing information, rules of application for the code this ChargeItem uses." )
    protected List<UriType> definitionUri;

    /**
     * References the source of pricing information, rules of application for the code this ChargeItem uses.
     */
    @Child(name = "definitionCanonical", type = {CanonicalType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Resource defining the code of this ChargeItem", formalDefinition="References the source of pricing information, rules of application for the code this ChargeItem uses." )
    protected List<CanonicalType> definitionCanonical;

    /**
     * The current state of the ChargeItem.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="planned | billable | not-billable | aborted | billed | entered-in-error | unknown", formalDefinition="The current state of the ChargeItem." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/chargeitem-status")
    protected Enumeration<ChargeItemStatus> status;

    /**
     * ChargeItems can be grouped to larger ChargeItems covering the whole set.
     */
    @Child(name = "partOf", type = {ChargeItem.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Part of referenced ChargeItem", formalDefinition="ChargeItems can be grouped to larger ChargeItems covering the whole set." )
    protected List<Reference> partOf;

    /**
     * A code that identifies the charge, like a billing code.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A code that identifies the charge, like a billing code", formalDefinition="A code that identifies the charge, like a billing code." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/chargeitem-billingcodes")
    protected CodeableConcept code;

    /**
     * The individual or set of individuals the action is being or was performed on.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Individual service was done for/to", formalDefinition="The individual or set of individuals the action is being or was performed on." )
    protected Reference subject;

    /**
     * This ChargeItem has the details of how the associated Encounter should be billed or otherwise be handled by finance systems.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Encounter associated with this ChargeItem", formalDefinition="This ChargeItem has the details of how the associated Encounter should be billed or otherwise be handled by finance systems." )
    protected Reference encounter;

    /**
     * Date/time(s) or duration when the charged service was applied.
     */
    @Child(name = "occurrence", type = {DateTimeType.class, Period.class, Timing.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the charged service was applied", formalDefinition="Date/time(s) or duration when the charged service was applied." )
    protected DataType occurrence;

    /**
     * Indicates who or what performed or participated in the charged service.
     */
    @Child(name = "performer", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who performed charged service", formalDefinition="Indicates who or what performed or participated in the charged service." )
    protected List<ChargeItemPerformerComponent> performer;

    /**
     * The organization performing the service.
     */
    @Child(name = "performingOrganization", type = {Organization.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Organization providing the charged service", formalDefinition="The organization performing the service." )
    protected Reference performingOrganization;

    /**
     * The organization requesting the service.
     */
    @Child(name = "requestingOrganization", type = {Organization.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Organization requesting the charged service", formalDefinition="The organization requesting the service." )
    protected Reference requestingOrganization;

    /**
     * The financial cost center permits the tracking of charge attribution.
     */
    @Child(name = "costCenter", type = {Organization.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Organization that has ownership of the (potential, future) revenue", formalDefinition="The financial cost center permits the tracking of charge attribution." )
    protected Reference costCenter;

    /**
     * Quantity of which the charge item has been serviced.
     */
    @Child(name = "quantity", type = {Quantity.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Quantity of which the charge item has been serviced", formalDefinition="Quantity of which the charge item has been serviced." )
    protected Quantity quantity;

    /**
     * The anatomical location where the related service has been applied.
     */
    @Child(name = "bodysite", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Anatomical location, if relevant", formalDefinition="The anatomical location where the related service has been applied." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected List<CodeableConcept> bodysite;

    /**
     * The unit price of the chargable item.
     */
    @Child(name = "unitPriceComponent", type = {MonetaryComponent.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Unit price overriding the associated rules", formalDefinition="The unit price of the chargable item." )
    protected MonetaryComponent unitPriceComponent;

    /**
     * The total price for the chargable item, accounting for the quantity.
     */
    @Child(name = "totalPriceComponent", type = {MonetaryComponent.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Total price overriding the associated rules", formalDefinition="The total price for the chargable item, accounting for the quantity." )
    protected MonetaryComponent totalPriceComponent;

    /**
     * If the list price or the rule-based factor associated with the code is overridden, this attribute can capture a text to indicate the  reason for this action.
     */
    @Child(name = "overrideReason", type = {CodeableConcept.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reason for overriding the list price/factor", formalDefinition="If the list price or the rule-based factor associated with the code is overridden, this attribute can capture a text to indicate the  reason for this action." )
    protected CodeableConcept overrideReason;

    /**
     * The device, practitioner, etc. who entered the charge item.
     */
    @Child(name = "enterer", type = {Practitioner.class, PractitionerRole.class, Organization.class, Patient.class, Device.class, RelatedPerson.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Individual who was entering", formalDefinition="The device, practitioner, etc. who entered the charge item." )
    protected Reference enterer;

    /**
     * Date the charge item was entered.
     */
    @Child(name = "enteredDate", type = {DateTimeType.class}, order=19, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date the charge item was entered", formalDefinition="Date the charge item was entered." )
    protected DateTimeType enteredDate;

    /**
     * Describes why the event occurred in coded or textual form.
     */
    @Child(name = "reason", type = {CodeableConcept.class}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Why was the charged  service rendered?", formalDefinition="Describes why the event occurred in coded or textual form." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/icd-10")
    protected List<CodeableConcept> reason;

    /**
     * Indicated the rendered service that caused this charge.
     */
    @Child(name = "service", type = {CodeableReference.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Which rendered service is being charged?", formalDefinition="Indicated the rendered service that caused this charge." )
    protected List<CodeableReference> service;

    /**
     * Identifies the device, food, drug or other product being charged either by type code or reference to an instance.
     */
    @Child(name = "product", type = {CodeableReference.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Product charged", formalDefinition="Identifies the device, food, drug or other product being charged either by type code or reference to an instance." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/device-type")
    protected List<CodeableReference> product;

    /**
     * Account into which this ChargeItems belongs.
     */
    @Child(name = "account", type = {Account.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Account to place this charge", formalDefinition="Account into which this ChargeItems belongs." )
    protected List<Reference> account;

    /**
     * Comments made about the event by the performer, subject or other participants.
     */
    @Child(name = "note", type = {Annotation.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Comments made about the ChargeItem", formalDefinition="Comments made about the event by the performer, subject or other participants." )
    protected List<Annotation> note;

    /**
     * Further information supporting this charge.
     */
    @Child(name = "supportingInformation", type = {Reference.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Further information supporting this charge", formalDefinition="Further information supporting this charge." )
    protected List<Reference> supportingInformation;

    private static final long serialVersionUID = -766813613L;

  /**
   * Constructor
   */
    public ChargeItem() {
      super();
    }

  /**
   * Constructor
   */
    public ChargeItem(ChargeItemStatus status, CodeableConcept code, Reference subject) {
      super();
      this.setStatus(status);
      this.setCode(code);
      this.setSubject(subject);
    }

    /**
     * @return {@link #identifier} (Identifiers assigned to this event performer or other systems.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setIdentifier(List<Identifier> theIdentifier) { 
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

    public ChargeItem addIdentifier(Identifier t) { //3
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
     * @return {@link #definitionUri} (References the (external) source of pricing information, rules of application for the code this ChargeItem uses.)
     */
    public List<UriType> getDefinitionUri() { 
      if (this.definitionUri == null)
        this.definitionUri = new ArrayList<UriType>();
      return this.definitionUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setDefinitionUri(List<UriType> theDefinitionUri) { 
      this.definitionUri = theDefinitionUri;
      return this;
    }

    public boolean hasDefinitionUri() { 
      if (this.definitionUri == null)
        return false;
      for (UriType item : this.definitionUri)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #definitionUri} (References the (external) source of pricing information, rules of application for the code this ChargeItem uses.)
     */
    public UriType addDefinitionUriElement() {//2 
      UriType t = new UriType();
      if (this.definitionUri == null)
        this.definitionUri = new ArrayList<UriType>();
      this.definitionUri.add(t);
      return t;
    }

    /**
     * @param value {@link #definitionUri} (References the (external) source of pricing information, rules of application for the code this ChargeItem uses.)
     */
    public ChargeItem addDefinitionUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.definitionUri == null)
        this.definitionUri = new ArrayList<UriType>();
      this.definitionUri.add(t);
      return this;
    }

    /**
     * @param value {@link #definitionUri} (References the (external) source of pricing information, rules of application for the code this ChargeItem uses.)
     */
    public boolean hasDefinitionUri(String value) { 
      if (this.definitionUri == null)
        return false;
      for (UriType v : this.definitionUri)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #definitionCanonical} (References the source of pricing information, rules of application for the code this ChargeItem uses.)
     */
    public List<CanonicalType> getDefinitionCanonical() { 
      if (this.definitionCanonical == null)
        this.definitionCanonical = new ArrayList<CanonicalType>();
      return this.definitionCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setDefinitionCanonical(List<CanonicalType> theDefinitionCanonical) { 
      this.definitionCanonical = theDefinitionCanonical;
      return this;
    }

    public boolean hasDefinitionCanonical() { 
      if (this.definitionCanonical == null)
        return false;
      for (CanonicalType item : this.definitionCanonical)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #definitionCanonical} (References the source of pricing information, rules of application for the code this ChargeItem uses.)
     */
    public CanonicalType addDefinitionCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.definitionCanonical == null)
        this.definitionCanonical = new ArrayList<CanonicalType>();
      this.definitionCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #definitionCanonical} (References the source of pricing information, rules of application for the code this ChargeItem uses.)
     */
    public ChargeItem addDefinitionCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.definitionCanonical == null)
        this.definitionCanonical = new ArrayList<CanonicalType>();
      this.definitionCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #definitionCanonical} (References the source of pricing information, rules of application for the code this ChargeItem uses.)
     */
    public boolean hasDefinitionCanonical(String value) { 
      if (this.definitionCanonical == null)
        return false;
      for (CanonicalType v : this.definitionCanonical)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #status} (The current state of the ChargeItem.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<ChargeItemStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<ChargeItemStatus>(new ChargeItemStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The current state of the ChargeItem.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ChargeItem setStatusElement(Enumeration<ChargeItemStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the ChargeItem.
     */
    public ChargeItemStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the ChargeItem.
     */
    public ChargeItem setStatus(ChargeItemStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<ChargeItemStatus>(new ChargeItemStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #partOf} (ChargeItems can be grouped to larger ChargeItems covering the whole set.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setPartOf(List<Reference> thePartOf) { 
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

    public ChargeItem addPartOf(Reference t) { //3
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
     * @return {@link #code} (A code that identifies the charge, like a billing code.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code that identifies the charge, like a billing code.)
     */
    public ChargeItem setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (The individual or set of individuals the action is being or was performed on.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The individual or set of individuals the action is being or was performed on.)
     */
    public ChargeItem setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (This ChargeItem has the details of how the associated Encounter should be billed or otherwise be handled by finance systems.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (This ChargeItem has the details of how the associated Encounter should be billed or otherwise be handled by finance systems.)
     */
    public ChargeItem setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #occurrence} (Date/time(s) or duration when the charged service was applied.)
     */
    public DataType getOccurrence() { 
      return this.occurrence;
    }

    /**
     * @return {@link #occurrence} (Date/time(s) or duration when the charged service was applied.)
     */
    public DateTimeType getOccurrenceDateTimeType() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new DateTimeType();
      if (!(this.occurrence instanceof DateTimeType))
        throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (DateTimeType) this.occurrence;
    }

    public boolean hasOccurrenceDateTimeType() { 
      return this != null && this.occurrence instanceof DateTimeType;
    }

    /**
     * @return {@link #occurrence} (Date/time(s) or duration when the charged service was applied.)
     */
    public Period getOccurrencePeriod() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Period();
      if (!(this.occurrence instanceof Period))
        throw new FHIRException("Type mismatch: the type Period was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Period) this.occurrence;
    }

    public boolean hasOccurrencePeriod() { 
      return this != null && this.occurrence instanceof Period;
    }

    /**
     * @return {@link #occurrence} (Date/time(s) or duration when the charged service was applied.)
     */
    public Timing getOccurrenceTiming() throws FHIRException { 
      if (this.occurrence == null)
        this.occurrence = new Timing();
      if (!(this.occurrence instanceof Timing))
        throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.occurrence.getClass().getName()+" was encountered");
      return (Timing) this.occurrence;
    }

    public boolean hasOccurrenceTiming() { 
      return this != null && this.occurrence instanceof Timing;
    }

    public boolean hasOccurrence() { 
      return this.occurrence != null && !this.occurrence.isEmpty();
    }

    /**
     * @param value {@link #occurrence} (Date/time(s) or duration when the charged service was applied.)
     */
    public ChargeItem setOccurrence(DataType value) { 
      if (value != null && !(value instanceof DateTimeType || value instanceof Period || value instanceof Timing))
        throw new FHIRException("Not the right type for ChargeItem.occurrence[x]: "+value.fhirType());
      this.occurrence = value;
      return this;
    }

    /**
     * @return {@link #performer} (Indicates who or what performed or participated in the charged service.)
     */
    public List<ChargeItemPerformerComponent> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<ChargeItemPerformerComponent>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setPerformer(List<ChargeItemPerformerComponent> thePerformer) { 
      this.performer = thePerformer;
      return this;
    }

    public boolean hasPerformer() { 
      if (this.performer == null)
        return false;
      for (ChargeItemPerformerComponent item : this.performer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ChargeItemPerformerComponent addPerformer() { //3
      ChargeItemPerformerComponent t = new ChargeItemPerformerComponent();
      if (this.performer == null)
        this.performer = new ArrayList<ChargeItemPerformerComponent>();
      this.performer.add(t);
      return t;
    }

    public ChargeItem addPerformer(ChargeItemPerformerComponent t) { //3
      if (t == null)
        return this;
      if (this.performer == null)
        this.performer = new ArrayList<ChargeItemPerformerComponent>();
      this.performer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
     */
    public ChargeItemPerformerComponent getPerformerFirstRep() { 
      if (getPerformer().isEmpty()) {
        addPerformer();
      }
      return getPerformer().get(0);
    }

    /**
     * @return {@link #performingOrganization} (The organization performing the service.)
     */
    public Reference getPerformingOrganization() { 
      if (this.performingOrganization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.performingOrganization");
        else if (Configuration.doAutoCreate())
          this.performingOrganization = new Reference(); // cc
      return this.performingOrganization;
    }

    public boolean hasPerformingOrganization() { 
      return this.performingOrganization != null && !this.performingOrganization.isEmpty();
    }

    /**
     * @param value {@link #performingOrganization} (The organization performing the service.)
     */
    public ChargeItem setPerformingOrganization(Reference value) { 
      this.performingOrganization = value;
      return this;
    }

    /**
     * @return {@link #requestingOrganization} (The organization requesting the service.)
     */
    public Reference getRequestingOrganization() { 
      if (this.requestingOrganization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.requestingOrganization");
        else if (Configuration.doAutoCreate())
          this.requestingOrganization = new Reference(); // cc
      return this.requestingOrganization;
    }

    public boolean hasRequestingOrganization() { 
      return this.requestingOrganization != null && !this.requestingOrganization.isEmpty();
    }

    /**
     * @param value {@link #requestingOrganization} (The organization requesting the service.)
     */
    public ChargeItem setRequestingOrganization(Reference value) { 
      this.requestingOrganization = value;
      return this;
    }

    /**
     * @return {@link #costCenter} (The financial cost center permits the tracking of charge attribution.)
     */
    public Reference getCostCenter() { 
      if (this.costCenter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.costCenter");
        else if (Configuration.doAutoCreate())
          this.costCenter = new Reference(); // cc
      return this.costCenter;
    }

    public boolean hasCostCenter() { 
      return this.costCenter != null && !this.costCenter.isEmpty();
    }

    /**
     * @param value {@link #costCenter} (The financial cost center permits the tracking of charge attribution.)
     */
    public ChargeItem setCostCenter(Reference value) { 
      this.costCenter = value;
      return this;
    }

    /**
     * @return {@link #quantity} (Quantity of which the charge item has been serviced.)
     */
    public Quantity getQuantity() { 
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.quantity");
        else if (Configuration.doAutoCreate())
          this.quantity = new Quantity(); // cc
      return this.quantity;
    }

    public boolean hasQuantity() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (Quantity of which the charge item has been serviced.)
     */
    public ChargeItem setQuantity(Quantity value) { 
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #bodysite} (The anatomical location where the related service has been applied.)
     */
    public List<CodeableConcept> getBodysite() { 
      if (this.bodysite == null)
        this.bodysite = new ArrayList<CodeableConcept>();
      return this.bodysite;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setBodysite(List<CodeableConcept> theBodysite) { 
      this.bodysite = theBodysite;
      return this;
    }

    public boolean hasBodysite() { 
      if (this.bodysite == null)
        return false;
      for (CodeableConcept item : this.bodysite)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addBodysite() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.bodysite == null)
        this.bodysite = new ArrayList<CodeableConcept>();
      this.bodysite.add(t);
      return t;
    }

    public ChargeItem addBodysite(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.bodysite == null)
        this.bodysite = new ArrayList<CodeableConcept>();
      this.bodysite.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #bodysite}, creating it if it does not already exist {3}
     */
    public CodeableConcept getBodysiteFirstRep() { 
      if (getBodysite().isEmpty()) {
        addBodysite();
      }
      return getBodysite().get(0);
    }

    /**
     * @return {@link #unitPriceComponent} (The unit price of the chargable item.)
     */
    public MonetaryComponent getUnitPriceComponent() { 
      if (this.unitPriceComponent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.unitPriceComponent");
        else if (Configuration.doAutoCreate())
          this.unitPriceComponent = new MonetaryComponent(); // cc
      return this.unitPriceComponent;
    }

    public boolean hasUnitPriceComponent() { 
      return this.unitPriceComponent != null && !this.unitPriceComponent.isEmpty();
    }

    /**
     * @param value {@link #unitPriceComponent} (The unit price of the chargable item.)
     */
    public ChargeItem setUnitPriceComponent(MonetaryComponent value) { 
      this.unitPriceComponent = value;
      return this;
    }

    /**
     * @return {@link #totalPriceComponent} (The total price for the chargable item, accounting for the quantity.)
     */
    public MonetaryComponent getTotalPriceComponent() { 
      if (this.totalPriceComponent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.totalPriceComponent");
        else if (Configuration.doAutoCreate())
          this.totalPriceComponent = new MonetaryComponent(); // cc
      return this.totalPriceComponent;
    }

    public boolean hasTotalPriceComponent() { 
      return this.totalPriceComponent != null && !this.totalPriceComponent.isEmpty();
    }

    /**
     * @param value {@link #totalPriceComponent} (The total price for the chargable item, accounting for the quantity.)
     */
    public ChargeItem setTotalPriceComponent(MonetaryComponent value) { 
      this.totalPriceComponent = value;
      return this;
    }

    /**
     * @return {@link #overrideReason} (If the list price or the rule-based factor associated with the code is overridden, this attribute can capture a text to indicate the  reason for this action.)
     */
    public CodeableConcept getOverrideReason() { 
      if (this.overrideReason == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.overrideReason");
        else if (Configuration.doAutoCreate())
          this.overrideReason = new CodeableConcept(); // cc
      return this.overrideReason;
    }

    public boolean hasOverrideReason() { 
      return this.overrideReason != null && !this.overrideReason.isEmpty();
    }

    /**
     * @param value {@link #overrideReason} (If the list price or the rule-based factor associated with the code is overridden, this attribute can capture a text to indicate the  reason for this action.)
     */
    public ChargeItem setOverrideReason(CodeableConcept value) { 
      this.overrideReason = value;
      return this;
    }

    /**
     * @return {@link #enterer} (The device, practitioner, etc. who entered the charge item.)
     */
    public Reference getEnterer() { 
      if (this.enterer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.enterer");
        else if (Configuration.doAutoCreate())
          this.enterer = new Reference(); // cc
      return this.enterer;
    }

    public boolean hasEnterer() { 
      return this.enterer != null && !this.enterer.isEmpty();
    }

    /**
     * @param value {@link #enterer} (The device, practitioner, etc. who entered the charge item.)
     */
    public ChargeItem setEnterer(Reference value) { 
      this.enterer = value;
      return this;
    }

    /**
     * @return {@link #enteredDate} (Date the charge item was entered.). This is the underlying object with id, value and extensions. The accessor "getEnteredDate" gives direct access to the value
     */
    public DateTimeType getEnteredDateElement() { 
      if (this.enteredDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ChargeItem.enteredDate");
        else if (Configuration.doAutoCreate())
          this.enteredDate = new DateTimeType(); // bb
      return this.enteredDate;
    }

    public boolean hasEnteredDateElement() { 
      return this.enteredDate != null && !this.enteredDate.isEmpty();
    }

    public boolean hasEnteredDate() { 
      return this.enteredDate != null && !this.enteredDate.isEmpty();
    }

    /**
     * @param value {@link #enteredDate} (Date the charge item was entered.). This is the underlying object with id, value and extensions. The accessor "getEnteredDate" gives direct access to the value
     */
    public ChargeItem setEnteredDateElement(DateTimeType value) { 
      this.enteredDate = value;
      return this;
    }

    /**
     * @return Date the charge item was entered.
     */
    public Date getEnteredDate() { 
      return this.enteredDate == null ? null : this.enteredDate.getValue();
    }

    /**
     * @param value Date the charge item was entered.
     */
    public ChargeItem setEnteredDate(Date value) { 
      if (value == null)
        this.enteredDate = null;
      else {
        if (this.enteredDate == null)
          this.enteredDate = new DateTimeType();
        this.enteredDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #reason} (Describes why the event occurred in coded or textual form.)
     */
    public List<CodeableConcept> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableConcept>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setReason(List<CodeableConcept> theReason) { 
      this.reason = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reason == null)
        return false;
      for (CodeableConcept item : this.reason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addReason() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.reason == null)
        this.reason = new ArrayList<CodeableConcept>();
      this.reason.add(t);
      return t;
    }

    public ChargeItem addReason(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<CodeableConcept>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public CodeableConcept getReasonFirstRep() { 
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
    }

    /**
     * @return {@link #service} (Indicated the rendered service that caused this charge.)
     */
    public List<CodeableReference> getService() { 
      if (this.service == null)
        this.service = new ArrayList<CodeableReference>();
      return this.service;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setService(List<CodeableReference> theService) { 
      this.service = theService;
      return this;
    }

    public boolean hasService() { 
      if (this.service == null)
        return false;
      for (CodeableReference item : this.service)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addService() { //3
      CodeableReference t = new CodeableReference();
      if (this.service == null)
        this.service = new ArrayList<CodeableReference>();
      this.service.add(t);
      return t;
    }

    public ChargeItem addService(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.service == null)
        this.service = new ArrayList<CodeableReference>();
      this.service.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #service}, creating it if it does not already exist {3}
     */
    public CodeableReference getServiceFirstRep() { 
      if (getService().isEmpty()) {
        addService();
      }
      return getService().get(0);
    }

    /**
     * @return {@link #product} (Identifies the device, food, drug or other product being charged either by type code or reference to an instance.)
     */
    public List<CodeableReference> getProduct() { 
      if (this.product == null)
        this.product = new ArrayList<CodeableReference>();
      return this.product;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setProduct(List<CodeableReference> theProduct) { 
      this.product = theProduct;
      return this;
    }

    public boolean hasProduct() { 
      if (this.product == null)
        return false;
      for (CodeableReference item : this.product)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addProduct() { //3
      CodeableReference t = new CodeableReference();
      if (this.product == null)
        this.product = new ArrayList<CodeableReference>();
      this.product.add(t);
      return t;
    }

    public ChargeItem addProduct(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.product == null)
        this.product = new ArrayList<CodeableReference>();
      this.product.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #product}, creating it if it does not already exist {3}
     */
    public CodeableReference getProductFirstRep() { 
      if (getProduct().isEmpty()) {
        addProduct();
      }
      return getProduct().get(0);
    }

    /**
     * @return {@link #account} (Account into which this ChargeItems belongs.)
     */
    public List<Reference> getAccount() { 
      if (this.account == null)
        this.account = new ArrayList<Reference>();
      return this.account;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setAccount(List<Reference> theAccount) { 
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

    public ChargeItem addAccount(Reference t) { //3
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

    /**
     * @return {@link #note} (Comments made about the event by the performer, subject or other participants.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setNote(List<Annotation> theNote) { 
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

    public ChargeItem addNote(Annotation t) { //3
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
     * @return {@link #supportingInformation} (Further information supporting this charge.)
     */
    public List<Reference> getSupportingInformation() { 
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      return this.supportingInformation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ChargeItem setSupportingInformation(List<Reference> theSupportingInformation) { 
      this.supportingInformation = theSupportingInformation;
      return this;
    }

    public boolean hasSupportingInformation() { 
      if (this.supportingInformation == null)
        return false;
      for (Reference item : this.supportingInformation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupportingInformation() { //3
      Reference t = new Reference();
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      this.supportingInformation.add(t);
      return t;
    }

    public ChargeItem addSupportingInformation(Reference t) { //3
      if (t == null)
        return this;
      if (this.supportingInformation == null)
        this.supportingInformation = new ArrayList<Reference>();
      this.supportingInformation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supportingInformation}, creating it if it does not already exist {3}
     */
    public Reference getSupportingInformationFirstRep() { 
      if (getSupportingInformation().isEmpty()) {
        addSupportingInformation();
      }
      return getSupportingInformation().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifiers assigned to this event performer or other systems.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("definitionUri", "uri", "References the (external) source of pricing information, rules of application for the code this ChargeItem uses.", 0, java.lang.Integer.MAX_VALUE, definitionUri));
        children.add(new Property("definitionCanonical", "canonical(ChargeItemDefinition)", "References the source of pricing information, rules of application for the code this ChargeItem uses.", 0, java.lang.Integer.MAX_VALUE, definitionCanonical));
        children.add(new Property("status", "code", "The current state of the ChargeItem.", 0, 1, status));
        children.add(new Property("partOf", "Reference(ChargeItem)", "ChargeItems can be grouped to larger ChargeItems covering the whole set.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("code", "CodeableConcept", "A code that identifies the charge, like a billing code.", 0, 1, code));
        children.add(new Property("subject", "Reference(Patient|Group)", "The individual or set of individuals the action is being or was performed on.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "This ChargeItem has the details of how the associated Encounter should be billed or otherwise be handled by finance systems.", 0, 1, encounter));
        children.add(new Property("occurrence[x]", "dateTime|Period|Timing", "Date/time(s) or duration when the charged service was applied.", 0, 1, occurrence));
        children.add(new Property("performer", "", "Indicates who or what performed or participated in the charged service.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("performingOrganization", "Reference(Organization)", "The organization performing the service.", 0, 1, performingOrganization));
        children.add(new Property("requestingOrganization", "Reference(Organization)", "The organization requesting the service.", 0, 1, requestingOrganization));
        children.add(new Property("costCenter", "Reference(Organization)", "The financial cost center permits the tracking of charge attribution.", 0, 1, costCenter));
        children.add(new Property("quantity", "Quantity", "Quantity of which the charge item has been serviced.", 0, 1, quantity));
        children.add(new Property("bodysite", "CodeableConcept", "The anatomical location where the related service has been applied.", 0, java.lang.Integer.MAX_VALUE, bodysite));
        children.add(new Property("unitPriceComponent", "MonetaryComponent", "The unit price of the chargable item.", 0, 1, unitPriceComponent));
        children.add(new Property("totalPriceComponent", "MonetaryComponent", "The total price for the chargable item, accounting for the quantity.", 0, 1, totalPriceComponent));
        children.add(new Property("overrideReason", "CodeableConcept", "If the list price or the rule-based factor associated with the code is overridden, this attribute can capture a text to indicate the  reason for this action.", 0, 1, overrideReason));
        children.add(new Property("enterer", "Reference(Practitioner|PractitionerRole|Organization|Patient|Device|RelatedPerson)", "The device, practitioner, etc. who entered the charge item.", 0, 1, enterer));
        children.add(new Property("enteredDate", "dateTime", "Date the charge item was entered.", 0, 1, enteredDate));
        children.add(new Property("reason", "CodeableConcept", "Describes why the event occurred in coded or textual form.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("service", "CodeableReference(DiagnosticReport|ImagingStudy|Immunization|MedicationAdministration|MedicationDispense|MedicationRequest|Observation|Procedure|ServiceRequest|SupplyDelivery)", "Indicated the rendered service that caused this charge.", 0, java.lang.Integer.MAX_VALUE, service));
        children.add(new Property("product", "CodeableReference(Device|Medication|Substance)", "Identifies the device, food, drug or other product being charged either by type code or reference to an instance.", 0, java.lang.Integer.MAX_VALUE, product));
        children.add(new Property("account", "Reference(Account)", "Account into which this ChargeItems belongs.", 0, java.lang.Integer.MAX_VALUE, account));
        children.add(new Property("note", "Annotation", "Comments made about the event by the performer, subject or other participants.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("supportingInformation", "Reference(Any)", "Further information supporting this charge.", 0, java.lang.Integer.MAX_VALUE, supportingInformation));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifiers assigned to this event performer or other systems.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -1139428583: /*definitionUri*/  return new Property("definitionUri", "uri", "References the (external) source of pricing information, rules of application for the code this ChargeItem uses.", 0, java.lang.Integer.MAX_VALUE, definitionUri);
        case 933485793: /*definitionCanonical*/  return new Property("definitionCanonical", "canonical(ChargeItemDefinition)", "References the source of pricing information, rules of application for the code this ChargeItem uses.", 0, java.lang.Integer.MAX_VALUE, definitionCanonical);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the ChargeItem.", 0, 1, status);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(ChargeItem)", "ChargeItems can be grouped to larger ChargeItems covering the whole set.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that identifies the charge, like a billing code.", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The individual or set of individuals the action is being or was performed on.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "This ChargeItem has the details of how the associated Encounter should be billed or otherwise be handled by finance systems.", 0, 1, encounter);
        case -2022646513: /*occurrence[x]*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "Date/time(s) or duration when the charged service was applied.", 0, 1, occurrence);
        case 1687874001: /*occurrence*/  return new Property("occurrence[x]", "dateTime|Period|Timing", "Date/time(s) or duration when the charged service was applied.", 0, 1, occurrence);
        case -298443636: /*occurrenceDateTime*/  return new Property("occurrence[x]", "dateTime", "Date/time(s) or duration when the charged service was applied.", 0, 1, occurrence);
        case 1397156594: /*occurrencePeriod*/  return new Property("occurrence[x]", "Period", "Date/time(s) or duration when the charged service was applied.", 0, 1, occurrence);
        case 1515218299: /*occurrenceTiming*/  return new Property("occurrence[x]", "Timing", "Date/time(s) or duration when the charged service was applied.", 0, 1, occurrence);
        case 481140686: /*performer*/  return new Property("performer", "", "Indicates who or what performed or participated in the charged service.", 0, java.lang.Integer.MAX_VALUE, performer);
        case 1273192628: /*performingOrganization*/  return new Property("performingOrganization", "Reference(Organization)", "The organization performing the service.", 0, 1, performingOrganization);
        case 1279054790: /*requestingOrganization*/  return new Property("requestingOrganization", "Reference(Organization)", "The organization requesting the service.", 0, 1, requestingOrganization);
        case -593192318: /*costCenter*/  return new Property("costCenter", "Reference(Organization)", "The financial cost center permits the tracking of charge attribution.", 0, 1, costCenter);
        case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "Quantity of which the charge item has been serviced.", 0, 1, quantity);
        case 1703573481: /*bodysite*/  return new Property("bodysite", "CodeableConcept", "The anatomical location where the related service has been applied.", 0, java.lang.Integer.MAX_VALUE, bodysite);
        case -925197224: /*unitPriceComponent*/  return new Property("unitPriceComponent", "MonetaryComponent", "The unit price of the chargable item.", 0, 1, unitPriceComponent);
        case 1731497496: /*totalPriceComponent*/  return new Property("totalPriceComponent", "MonetaryComponent", "The total price for the chargable item, accounting for the quantity.", 0, 1, totalPriceComponent);
        case -742878928: /*overrideReason*/  return new Property("overrideReason", "CodeableConcept", "If the list price or the rule-based factor associated with the code is overridden, this attribute can capture a text to indicate the  reason for this action.", 0, 1, overrideReason);
        case -1591951995: /*enterer*/  return new Property("enterer", "Reference(Practitioner|PractitionerRole|Organization|Patient|Device|RelatedPerson)", "The device, practitioner, etc. who entered the charge item.", 0, 1, enterer);
        case 555978181: /*enteredDate*/  return new Property("enteredDate", "dateTime", "Date the charge item was entered.", 0, 1, enteredDate);
        case -934964668: /*reason*/  return new Property("reason", "CodeableConcept", "Describes why the event occurred in coded or textual form.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 1984153269: /*service*/  return new Property("service", "CodeableReference(DiagnosticReport|ImagingStudy|Immunization|MedicationAdministration|MedicationDispense|MedicationRequest|Observation|Procedure|ServiceRequest|SupplyDelivery)", "Indicated the rendered service that caused this charge.", 0, java.lang.Integer.MAX_VALUE, service);
        case -309474065: /*product*/  return new Property("product", "CodeableReference(Device|Medication|Substance)", "Identifies the device, food, drug or other product being charged either by type code or reference to an instance.", 0, java.lang.Integer.MAX_VALUE, product);
        case -1177318867: /*account*/  return new Property("account", "Reference(Account)", "Account into which this ChargeItems belongs.", 0, java.lang.Integer.MAX_VALUE, account);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Comments made about the event by the performer, subject or other participants.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1248768647: /*supportingInformation*/  return new Property("supportingInformation", "Reference(Any)", "Further information supporting this charge.", 0, java.lang.Integer.MAX_VALUE, supportingInformation);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -1139428583: /*definitionUri*/ return this.definitionUri == null ? new Base[0] : this.definitionUri.toArray(new Base[this.definitionUri.size()]); // UriType
        case 933485793: /*definitionCanonical*/ return this.definitionCanonical == null ? new Base[0] : this.definitionCanonical.toArray(new Base[this.definitionCanonical.size()]); // CanonicalType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<ChargeItemStatus>
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case 1687874001: /*occurrence*/ return this.occurrence == null ? new Base[0] : new Base[] {this.occurrence}; // DataType
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // ChargeItemPerformerComponent
        case 1273192628: /*performingOrganization*/ return this.performingOrganization == null ? new Base[0] : new Base[] {this.performingOrganization}; // Reference
        case 1279054790: /*requestingOrganization*/ return this.requestingOrganization == null ? new Base[0] : new Base[] {this.requestingOrganization}; // Reference
        case -593192318: /*costCenter*/ return this.costCenter == null ? new Base[0] : new Base[] {this.costCenter}; // Reference
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case 1703573481: /*bodysite*/ return this.bodysite == null ? new Base[0] : this.bodysite.toArray(new Base[this.bodysite.size()]); // CodeableConcept
        case -925197224: /*unitPriceComponent*/ return this.unitPriceComponent == null ? new Base[0] : new Base[] {this.unitPriceComponent}; // MonetaryComponent
        case 1731497496: /*totalPriceComponent*/ return this.totalPriceComponent == null ? new Base[0] : new Base[] {this.totalPriceComponent}; // MonetaryComponent
        case -742878928: /*overrideReason*/ return this.overrideReason == null ? new Base[0] : new Base[] {this.overrideReason}; // CodeableConcept
        case -1591951995: /*enterer*/ return this.enterer == null ? new Base[0] : new Base[] {this.enterer}; // Reference
        case 555978181: /*enteredDate*/ return this.enteredDate == null ? new Base[0] : new Base[] {this.enteredDate}; // DateTimeType
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableConcept
        case 1984153269: /*service*/ return this.service == null ? new Base[0] : this.service.toArray(new Base[this.service.size()]); // CodeableReference
        case -309474065: /*product*/ return this.product == null ? new Base[0] : this.product.toArray(new Base[this.product.size()]); // CodeableReference
        case -1177318867: /*account*/ return this.account == null ? new Base[0] : this.account.toArray(new Base[this.account.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1248768647: /*supportingInformation*/ return this.supportingInformation == null ? new Base[0] : this.supportingInformation.toArray(new Base[this.supportingInformation.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -1139428583: // definitionUri
          this.getDefinitionUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case 933485793: // definitionCanonical
          this.getDefinitionCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -892481550: // status
          value = new ChargeItemStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ChargeItemStatus>
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1687874001: // occurrence
          this.occurrence = TypeConvertor.castToType(value); // DataType
          return value;
        case 481140686: // performer
          this.getPerformer().add((ChargeItemPerformerComponent) value); // ChargeItemPerformerComponent
          return value;
        case 1273192628: // performingOrganization
          this.performingOrganization = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1279054790: // requestingOrganization
          this.requestingOrganization = TypeConvertor.castToReference(value); // Reference
          return value;
        case -593192318: // costCenter
          this.costCenter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 1703573481: // bodysite
          this.getBodysite().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -925197224: // unitPriceComponent
          this.unitPriceComponent = TypeConvertor.castToMonetaryComponent(value); // MonetaryComponent
          return value;
        case 1731497496: // totalPriceComponent
          this.totalPriceComponent = TypeConvertor.castToMonetaryComponent(value); // MonetaryComponent
          return value;
        case -742878928: // overrideReason
          this.overrideReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1591951995: // enterer
          this.enterer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 555978181: // enteredDate
          this.enteredDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1984153269: // service
          this.getService().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -309474065: // product
          this.getProduct().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -1177318867: // account
          this.getAccount().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1248768647: // supportingInformation
          this.getSupportingInformation().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("definitionUri")) {
          this.getDefinitionUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("definitionCanonical")) {
          this.getDefinitionCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("status")) {
          value = new ChargeItemStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<ChargeItemStatus>
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("occurrence[x]")) {
          this.occurrence = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("performer")) {
          this.getPerformer().add((ChargeItemPerformerComponent) value);
        } else if (name.equals("performingOrganization")) {
          this.performingOrganization = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("requestingOrganization")) {
          this.requestingOrganization = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("costCenter")) {
          this.costCenter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("bodysite")) {
          this.getBodysite().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("unitPriceComponent")) {
          this.unitPriceComponent = TypeConvertor.castToMonetaryComponent(value); // MonetaryComponent
        } else if (name.equals("totalPriceComponent")) {
          this.totalPriceComponent = TypeConvertor.castToMonetaryComponent(value); // MonetaryComponent
        } else if (name.equals("overrideReason")) {
          this.overrideReason = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("enterer")) {
          this.enterer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("enteredDate")) {
          this.enteredDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("service")) {
          this.getService().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("product")) {
          this.getProduct().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("account")) {
          this.getAccount().add(TypeConvertor.castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("supportingInformation")) {
          this.getSupportingInformation().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -1139428583:  return addDefinitionUriElement();
        case 933485793:  return addDefinitionCanonicalElement();
        case -892481550:  return getStatusElement();
        case -995410646:  return addPartOf(); 
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -2022646513:  return getOccurrence();
        case 1687874001:  return getOccurrence();
        case 481140686:  return addPerformer(); 
        case 1273192628:  return getPerformingOrganization();
        case 1279054790:  return getRequestingOrganization();
        case -593192318:  return getCostCenter();
        case -1285004149:  return getQuantity();
        case 1703573481:  return addBodysite(); 
        case -925197224:  return getUnitPriceComponent();
        case 1731497496:  return getTotalPriceComponent();
        case -742878928:  return getOverrideReason();
        case -1591951995:  return getEnterer();
        case 555978181:  return getEnteredDateElement();
        case -934964668:  return addReason(); 
        case 1984153269:  return addService(); 
        case -309474065:  return addProduct(); 
        case -1177318867:  return addAccount(); 
        case 3387378:  return addNote(); 
        case -1248768647:  return addSupportingInformation(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1139428583: /*definitionUri*/ return new String[] {"uri"};
        case 933485793: /*definitionCanonical*/ return new String[] {"canonical"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case 1687874001: /*occurrence*/ return new String[] {"dateTime", "Period", "Timing"};
        case 481140686: /*performer*/ return new String[] {};
        case 1273192628: /*performingOrganization*/ return new String[] {"Reference"};
        case 1279054790: /*requestingOrganization*/ return new String[] {"Reference"};
        case -593192318: /*costCenter*/ return new String[] {"Reference"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case 1703573481: /*bodysite*/ return new String[] {"CodeableConcept"};
        case -925197224: /*unitPriceComponent*/ return new String[] {"MonetaryComponent"};
        case 1731497496: /*totalPriceComponent*/ return new String[] {"MonetaryComponent"};
        case -742878928: /*overrideReason*/ return new String[] {"CodeableConcept"};
        case -1591951995: /*enterer*/ return new String[] {"Reference"};
        case 555978181: /*enteredDate*/ return new String[] {"dateTime"};
        case -934964668: /*reason*/ return new String[] {"CodeableConcept"};
        case 1984153269: /*service*/ return new String[] {"CodeableReference"};
        case -309474065: /*product*/ return new String[] {"CodeableReference"};
        case -1177318867: /*account*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1248768647: /*supportingInformation*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("definitionUri")) {
          throw new FHIRException("Cannot call addChild on a singleton property ChargeItem.definitionUri");
        }
        else if (name.equals("definitionCanonical")) {
          throw new FHIRException("Cannot call addChild on a singleton property ChargeItem.definitionCanonical");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property ChargeItem.status");
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("occurrenceDateTime")) {
          this.occurrence = new DateTimeType();
          return this.occurrence;
        }
        else if (name.equals("occurrencePeriod")) {
          this.occurrence = new Period();
          return this.occurrence;
        }
        else if (name.equals("occurrenceTiming")) {
          this.occurrence = new Timing();
          return this.occurrence;
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("performingOrganization")) {
          this.performingOrganization = new Reference();
          return this.performingOrganization;
        }
        else if (name.equals("requestingOrganization")) {
          this.requestingOrganization = new Reference();
          return this.requestingOrganization;
        }
        else if (name.equals("costCenter")) {
          this.costCenter = new Reference();
          return this.costCenter;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("bodysite")) {
          return addBodysite();
        }
        else if (name.equals("unitPriceComponent")) {
          this.unitPriceComponent = new MonetaryComponent();
          return this.unitPriceComponent;
        }
        else if (name.equals("totalPriceComponent")) {
          this.totalPriceComponent = new MonetaryComponent();
          return this.totalPriceComponent;
        }
        else if (name.equals("overrideReason")) {
          this.overrideReason = new CodeableConcept();
          return this.overrideReason;
        }
        else if (name.equals("enterer")) {
          this.enterer = new Reference();
          return this.enterer;
        }
        else if (name.equals("enteredDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property ChargeItem.enteredDate");
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("service")) {
          return addService();
        }
        else if (name.equals("product")) {
          return addProduct();
        }
        else if (name.equals("account")) {
          return addAccount();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("supportingInformation")) {
          return addSupportingInformation();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ChargeItem";

  }

      public ChargeItem copy() {
        ChargeItem dst = new ChargeItem();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ChargeItem dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (definitionUri != null) {
          dst.definitionUri = new ArrayList<UriType>();
          for (UriType i : definitionUri)
            dst.definitionUri.add(i.copy());
        };
        if (definitionCanonical != null) {
          dst.definitionCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : definitionCanonical)
            dst.definitionCanonical.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.occurrence = occurrence == null ? null : occurrence.copy();
        if (performer != null) {
          dst.performer = new ArrayList<ChargeItemPerformerComponent>();
          for (ChargeItemPerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        dst.performingOrganization = performingOrganization == null ? null : performingOrganization.copy();
        dst.requestingOrganization = requestingOrganization == null ? null : requestingOrganization.copy();
        dst.costCenter = costCenter == null ? null : costCenter.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        if (bodysite != null) {
          dst.bodysite = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : bodysite)
            dst.bodysite.add(i.copy());
        };
        dst.unitPriceComponent = unitPriceComponent == null ? null : unitPriceComponent.copy();
        dst.totalPriceComponent = totalPriceComponent == null ? null : totalPriceComponent.copy();
        dst.overrideReason = overrideReason == null ? null : overrideReason.copy();
        dst.enterer = enterer == null ? null : enterer.copy();
        dst.enteredDate = enteredDate == null ? null : enteredDate.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : reason)
            dst.reason.add(i.copy());
        };
        if (service != null) {
          dst.service = new ArrayList<CodeableReference>();
          for (CodeableReference i : service)
            dst.service.add(i.copy());
        };
        if (product != null) {
          dst.product = new ArrayList<CodeableReference>();
          for (CodeableReference i : product)
            dst.product.add(i.copy());
        };
        if (account != null) {
          dst.account = new ArrayList<Reference>();
          for (Reference i : account)
            dst.account.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (supportingInformation != null) {
          dst.supportingInformation = new ArrayList<Reference>();
          for (Reference i : supportingInformation)
            dst.supportingInformation.add(i.copy());
        };
      }

      protected ChargeItem typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ChargeItem))
          return false;
        ChargeItem o = (ChargeItem) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(definitionUri, o.definitionUri, true)
           && compareDeep(definitionCanonical, o.definitionCanonical, true) && compareDeep(status, o.status, true)
           && compareDeep(partOf, o.partOf, true) && compareDeep(code, o.code, true) && compareDeep(subject, o.subject, true)
           && compareDeep(encounter, o.encounter, true) && compareDeep(occurrence, o.occurrence, true) && compareDeep(performer, o.performer, true)
           && compareDeep(performingOrganization, o.performingOrganization, true) && compareDeep(requestingOrganization, o.requestingOrganization, true)
           && compareDeep(costCenter, o.costCenter, true) && compareDeep(quantity, o.quantity, true) && compareDeep(bodysite, o.bodysite, true)
           && compareDeep(unitPriceComponent, o.unitPriceComponent, true) && compareDeep(totalPriceComponent, o.totalPriceComponent, true)
           && compareDeep(overrideReason, o.overrideReason, true) && compareDeep(enterer, o.enterer, true)
           && compareDeep(enteredDate, o.enteredDate, true) && compareDeep(reason, o.reason, true) && compareDeep(service, o.service, true)
           && compareDeep(product, o.product, true) && compareDeep(account, o.account, true) && compareDeep(note, o.note, true)
           && compareDeep(supportingInformation, o.supportingInformation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ChargeItem))
          return false;
        ChargeItem o = (ChargeItem) other_;
        return compareValues(definitionUri, o.definitionUri, true) && compareValues(definitionCanonical, o.definitionCanonical, true)
           && compareValues(status, o.status, true) && compareValues(enteredDate, o.enteredDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, definitionUri
          , definitionCanonical, status, partOf, code, subject, encounter, occurrence, performer
          , performingOrganization, requestingOrganization, costCenter, quantity, bodysite, unitPriceComponent
          , totalPriceComponent, overrideReason, enterer, enteredDate, reason, service, product
          , account, note, supportingInformation);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ChargeItem;
   }

 /**
   * Search parameter: <b>account</b>
   * <p>
   * Description: <b>Account to place this charge</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.account</b><br>
   * </p>
   */
  @SearchParamDefinition(name="account", path="ChargeItem.account", description="Account to place this charge", type="reference", target={Account.class } )
  public static final String SP_ACCOUNT = "account";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>account</b>
   * <p>
   * Description: <b>Account to place this charge</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.account</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ACCOUNT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ACCOUNT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ChargeItem:account</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ACCOUNT = new ca.uhn.fhir.model.api.Include("ChargeItem:account").toLocked();

 /**
   * Search parameter: <b>entered-date</b>
   * <p>
   * Description: <b>Date the charge item was entered</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ChargeItem.enteredDate</b><br>
   * </p>
   */
  @SearchParamDefinition(name="entered-date", path="ChargeItem.enteredDate", description="Date the charge item was entered", type="date" )
  public static final String SP_ENTERED_DATE = "entered-date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>entered-date</b>
   * <p>
   * Description: <b>Date the charge item was entered</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ChargeItem.enteredDate</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam ENTERED_DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_ENTERED_DATE);

 /**
   * Search parameter: <b>enterer</b>
   * <p>
   * Description: <b>Individual who was entering</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.enterer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="enterer", path="ChargeItem.enterer", description="Individual who was entering", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Device.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_ENTERER = "enterer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>enterer</b>
   * <p>
   * Description: <b>Individual who was entering</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.enterer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENTERER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENTERER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ChargeItem:enterer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENTERER = new ca.uhn.fhir.model.api.Include("ChargeItem:enterer").toLocked();

 /**
   * Search parameter: <b>factor-override</b>
   * <p>
   * Description: <b>Factor overriding the associated rules</b><br>
   * Type: <b>number</b><br>
   * Path: <b>ChargeItem.totalPriceComponent.factor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="factor-override", path="ChargeItem.totalPriceComponent.factor", description="Factor overriding the associated rules", type="number" )
  public static final String SP_FACTOR_OVERRIDE = "factor-override";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>factor-override</b>
   * <p>
   * Description: <b>Factor overriding the associated rules</b><br>
   * Type: <b>number</b><br>
   * Path: <b>ChargeItem.totalPriceComponent.factor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.NumberClientParam FACTOR_OVERRIDE = new ca.uhn.fhir.rest.gclient.NumberClientParam(SP_FACTOR_OVERRIDE);

 /**
   * Search parameter: <b>occurrence</b>
   * <p>
   * Description: <b>When the charged service was applied</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ChargeItem.occurrence.ofType(dateTime) | ChargeItem.occurrence.ofType(Period) | ChargeItem.occurrence.ofType(Timing)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="occurrence", path="ChargeItem.occurrence.ofType(dateTime) | ChargeItem.occurrence.ofType(Period) | ChargeItem.occurrence.ofType(Timing)", description="When the charged service was applied", type="date" )
  public static final String SP_OCCURRENCE = "occurrence";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>occurrence</b>
   * <p>
   * Description: <b>When the charged service was applied</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ChargeItem.occurrence.ofType(dateTime) | ChargeItem.occurrence.ofType(Period) | ChargeItem.occurrence.ofType(Timing)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam OCCURRENCE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_OCCURRENCE);

 /**
   * Search parameter: <b>performer-actor</b>
   * <p>
   * Description: <b>Individual who was performing</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.performer.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer-actor", path="ChargeItem.performer.actor", description="Individual who was performing", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={CareTeam.class, Device.class, HealthcareService.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PERFORMER_ACTOR = "performer-actor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer-actor</b>
   * <p>
   * Description: <b>Individual who was performing</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.performer.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMER_ACTOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PERFORMER_ACTOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ChargeItem:performer-actor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMER_ACTOR = new ca.uhn.fhir.model.api.Include("ChargeItem:performer-actor").toLocked();

 /**
   * Search parameter: <b>performer-function</b>
   * <p>
   * Description: <b>What type of performance was done</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ChargeItem.performer.function</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer-function", path="ChargeItem.performer.function", description="What type of performance was done", type="token" )
  public static final String SP_PERFORMER_FUNCTION = "performer-function";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer-function</b>
   * <p>
   * Description: <b>What type of performance was done</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ChargeItem.performer.function</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PERFORMER_FUNCTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PERFORMER_FUNCTION);

 /**
   * Search parameter: <b>performing-organization</b>
   * <p>
   * Description: <b>Organization providing the charged service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.performingOrganization</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performing-organization", path="ChargeItem.performingOrganization", description="Organization providing the charged service", type="reference", target={Organization.class } )
  public static final String SP_PERFORMING_ORGANIZATION = "performing-organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performing-organization</b>
   * <p>
   * Description: <b>Organization providing the charged service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.performingOrganization</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMING_ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PERFORMING_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ChargeItem:performing-organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMING_ORGANIZATION = new ca.uhn.fhir.model.api.Include("ChargeItem:performing-organization").toLocked();

 /**
   * Search parameter: <b>price-override</b>
   * <p>
   * Description: <b>Price overriding the associated rules</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>ChargeItem.totalPriceComponent.amount</b><br>
   * </p>
   */
  @SearchParamDefinition(name="price-override", path="ChargeItem.totalPriceComponent.amount", description="Price overriding the associated rules", type="quantity" )
  public static final String SP_PRICE_OVERRIDE = "price-override";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>price-override</b>
   * <p>
   * Description: <b>Price overriding the associated rules</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>ChargeItem.totalPriceComponent.amount</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam PRICE_OVERRIDE = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_PRICE_OVERRIDE);

 /**
   * Search parameter: <b>quantity</b>
   * <p>
   * Description: <b>Quantity of which the charge item has been serviced</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>ChargeItem.quantity</b><br>
   * </p>
   */
  @SearchParamDefinition(name="quantity", path="ChargeItem.quantity", description="Quantity of which the charge item has been serviced", type="quantity" )
  public static final String SP_QUANTITY = "quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>quantity</b>
   * <p>
   * Description: <b>Quantity of which the charge item has been serviced</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>ChargeItem.quantity</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_QUANTITY);

 /**
   * Search parameter: <b>requesting-organization</b>
   * <p>
   * Description: <b>Organization requesting the charged service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.requestingOrganization</b><br>
   * </p>
   */
  @SearchParamDefinition(name="requesting-organization", path="ChargeItem.requestingOrganization", description="Organization requesting the charged service", type="reference", target={Organization.class } )
  public static final String SP_REQUESTING_ORGANIZATION = "requesting-organization";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>requesting-organization</b>
   * <p>
   * Description: <b>Organization requesting the charged service</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.requestingOrganization</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUESTING_ORGANIZATION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REQUESTING_ORGANIZATION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ChargeItem:requesting-organization</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUESTING_ORGANIZATION = new ca.uhn.fhir.model.api.Include("ChargeItem:requesting-organization").toLocked();

 /**
   * Search parameter: <b>service</b>
   * <p>
   * Description: <b>Which rendered service is being charged?</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.service.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="service", path="ChargeItem.service.reference", description="Which rendered service is being charged?", type="reference", target={DiagnosticReport.class, ImagingStudy.class, Immunization.class, MedicationAdministration.class, MedicationDispense.class, MedicationRequest.class, Observation.class, Procedure.class, ServiceRequest.class, SupplyDelivery.class } )
  public static final String SP_SERVICE = "service";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>service</b>
   * <p>
   * Description: <b>Which rendered service is being charged?</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.service.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SERVICE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SERVICE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ChargeItem:service</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SERVICE = new ca.uhn.fhir.model.api.Include("ChargeItem:service").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Is this charge item active</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ChargeItem.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ChargeItem.status", description="Is this charge item active", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Is this charge item active</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ChargeItem.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>Individual service was done for/to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="ChargeItem.subject", description="Individual service was done for/to", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>Individual service was done for/to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ChargeItem.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>ChargeItem:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("ChargeItem:subject").toLocked();

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
   * the path value of "<b>ChargeItem:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("ChargeItem:encounter").toLocked();

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
   * the path value of "<b>ChargeItem:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("ChargeItem:patient").toLocked();


}

