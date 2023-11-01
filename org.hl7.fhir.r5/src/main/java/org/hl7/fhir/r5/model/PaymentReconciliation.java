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
 * This resource provides the details including amount of a payment and allocates the payment items being paid.
 */
@ResourceDef(name="PaymentReconciliation", profile="http://hl7.org/fhir/StructureDefinition/PaymentReconciliation")
public class PaymentReconciliation extends DomainResource {

    public enum NoteType {
        /**
         * Display the note.
         */
        DISPLAY, 
        /**
         * Print the note on the form.
         */
        PRINT, 
        /**
         * Print the note for the operator.
         */
        PRINTOPER, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static NoteType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("display".equals(codeString))
          return DISPLAY;
        if ("print".equals(codeString))
          return PRINT;
        if ("printoper".equals(codeString))
          return PRINTOPER;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown NoteType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case DISPLAY: return "display";
            case PRINT: return "print";
            case PRINTOPER: return "printoper";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case DISPLAY: return "http://hl7.org/fhir/note-type";
            case PRINT: return "http://hl7.org/fhir/note-type";
            case PRINTOPER: return "http://hl7.org/fhir/note-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case DISPLAY: return "Display the note.";
            case PRINT: return "Print the note on the form.";
            case PRINTOPER: return "Print the note for the operator.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case DISPLAY: return "Display";
            case PRINT: return "Print (Form)";
            case PRINTOPER: return "Print (Operator)";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class NoteTypeEnumFactory implements EnumFactory<NoteType> {
    public NoteType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("display".equals(codeString))
          return NoteType.DISPLAY;
        if ("print".equals(codeString))
          return NoteType.PRINT;
        if ("printoper".equals(codeString))
          return NoteType.PRINTOPER;
        throw new IllegalArgumentException("Unknown NoteType code '"+codeString+"'");
        }
        public Enumeration<NoteType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<NoteType>(this, NoteType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<NoteType>(this, NoteType.NULL, code);
        if ("display".equals(codeString))
          return new Enumeration<NoteType>(this, NoteType.DISPLAY, code);
        if ("print".equals(codeString))
          return new Enumeration<NoteType>(this, NoteType.PRINT, code);
        if ("printoper".equals(codeString))
          return new Enumeration<NoteType>(this, NoteType.PRINTOPER, code);
        throw new FHIRException("Unknown NoteType code '"+codeString+"'");
        }
    public String toCode(NoteType code) {
      if (code == NoteType.DISPLAY)
        return "display";
      if (code == NoteType.PRINT)
        return "print";
      if (code == NoteType.PRINTOPER)
        return "printoper";
      return "?";
      }
    public String toSystem(NoteType code) {
      return code.getSystem();
      }
    }

    public enum PaymentOutcome {
        /**
         * The Claim/Pre-authorization/Pre-determination has been received but processing has not begun.
         */
        QUEUED, 
        /**
         * The processing has completed without errors
         */
        COMPLETE, 
        /**
         * One or more errors have been detected in the Claim
         */
        ERROR, 
        /**
         * No errors have been detected in the Claim and some of the adjudication has been performed.
         */
        PARTIAL, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static PaymentOutcome fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("queued".equals(codeString))
          return QUEUED;
        if ("complete".equals(codeString))
          return COMPLETE;
        if ("error".equals(codeString))
          return ERROR;
        if ("partial".equals(codeString))
          return PARTIAL;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown PaymentOutcome code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case QUEUED: return "queued";
            case COMPLETE: return "complete";
            case ERROR: return "error";
            case PARTIAL: return "partial";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case QUEUED: return "http://hl7.org/fhir/payment-outcome";
            case COMPLETE: return "http://hl7.org/fhir/payment-outcome";
            case ERROR: return "http://hl7.org/fhir/payment-outcome";
            case PARTIAL: return "http://hl7.org/fhir/payment-outcome";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case QUEUED: return "The Claim/Pre-authorization/Pre-determination has been received but processing has not begun.";
            case COMPLETE: return "The processing has completed without errors";
            case ERROR: return "One or more errors have been detected in the Claim";
            case PARTIAL: return "No errors have been detected in the Claim and some of the adjudication has been performed.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case QUEUED: return "Queued";
            case COMPLETE: return "Processing Complete";
            case ERROR: return "Error";
            case PARTIAL: return "Partial Processing";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class PaymentOutcomeEnumFactory implements EnumFactory<PaymentOutcome> {
    public PaymentOutcome fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("queued".equals(codeString))
          return PaymentOutcome.QUEUED;
        if ("complete".equals(codeString))
          return PaymentOutcome.COMPLETE;
        if ("error".equals(codeString))
          return PaymentOutcome.ERROR;
        if ("partial".equals(codeString))
          return PaymentOutcome.PARTIAL;
        throw new IllegalArgumentException("Unknown PaymentOutcome code '"+codeString+"'");
        }
        public Enumeration<PaymentOutcome> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<PaymentOutcome>(this, PaymentOutcome.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<PaymentOutcome>(this, PaymentOutcome.NULL, code);
        if ("queued".equals(codeString))
          return new Enumeration<PaymentOutcome>(this, PaymentOutcome.QUEUED, code);
        if ("complete".equals(codeString))
          return new Enumeration<PaymentOutcome>(this, PaymentOutcome.COMPLETE, code);
        if ("error".equals(codeString))
          return new Enumeration<PaymentOutcome>(this, PaymentOutcome.ERROR, code);
        if ("partial".equals(codeString))
          return new Enumeration<PaymentOutcome>(this, PaymentOutcome.PARTIAL, code);
        throw new FHIRException("Unknown PaymentOutcome code '"+codeString+"'");
        }
    public String toCode(PaymentOutcome code) {
      if (code == PaymentOutcome.QUEUED)
        return "queued";
      if (code == PaymentOutcome.COMPLETE)
        return "complete";
      if (code == PaymentOutcome.ERROR)
        return "error";
      if (code == PaymentOutcome.PARTIAL)
        return "partial";
      return "?";
      }
    public String toSystem(PaymentOutcome code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class PaymentReconciliationAllocationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Unique identifier for the current payment item for the referenced payable.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Business identifier of the payment detail", formalDefinition="Unique identifier for the current payment item for the referenced payable." )
        protected Identifier identifier;

        /**
         * Unique identifier for the prior payment item for the referenced payable.
         */
        @Child(name = "predecessor", type = {Identifier.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Business identifier of the prior payment detail", formalDefinition="Unique identifier for the prior payment item for the referenced payable." )
        protected Identifier predecessor;

        /**
         * Specific resource to which the payment/adjustment/advance applies.
         */
        @Child(name = "target", type = {Claim.class, Account.class, Invoice.class, ChargeItem.class, Encounter.class, Contract.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Subject of the payment", formalDefinition="Specific resource to which the payment/adjustment/advance applies." )
        protected Reference target;

        /**
         *  Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.
         */
        @Child(name = "targetItem", type = {StringType.class, Identifier.class, PositiveIntType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Sub-element of the subject", formalDefinition=" Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred." )
        protected DataType targetItem;

        /**
         * The Encounter to which this payment applies, may be completed by the receiver, used for search.
         */
        @Child(name = "encounter", type = {Encounter.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Applied-to encounter", formalDefinition="The Encounter to which this payment applies, may be completed by the receiver, used for search." )
        protected Reference encounter;

        /**
         * The Account to which this payment applies, may be completed by the receiver, used for search.
         */
        @Child(name = "account", type = {Account.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Applied-to account", formalDefinition="The Account to which this payment applies, may be completed by the receiver, used for search." )
        protected Reference account;

        /**
         * Code to indicate the nature of the payment.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Category of payment", formalDefinition="Code to indicate the nature of the payment." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/payment-type")
        protected CodeableConcept type;

        /**
         * The party which submitted the claim or financial transaction.
         */
        @Child(name = "submitter", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Submitter of the request", formalDefinition="The party which submitted the claim or financial transaction." )
        protected Reference submitter;

        /**
         * A resource, such as a ClaimResponse, which contains a commitment to payment.
         */
        @Child(name = "response", type = {ClaimResponse.class}, order=9, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Response committing to a payment", formalDefinition="A resource, such as a ClaimResponse, which contains a commitment to payment." )
        protected Reference response;

        /**
         * The date from the response resource containing a commitment to pay.
         */
        @Child(name = "date", type = {DateType.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Date of commitment to pay", formalDefinition="The date from the response resource containing a commitment to pay." )
        protected DateType date;

        /**
         * A reference to the individual who is responsible for inquiries regarding the response and its payment.
         */
        @Child(name = "responsible", type = {PractitionerRole.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Contact for the response", formalDefinition="A reference to the individual who is responsible for inquiries regarding the response and its payment." )
        protected Reference responsible;

        /**
         * The party which is receiving the payment.
         */
        @Child(name = "payee", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Recipient of the payment", formalDefinition="The party which is receiving the payment." )
        protected Reference payee;

        /**
         * The monetary amount allocated from the total payment to the payable.
         */
        @Child(name = "amount", type = {Money.class}, order=13, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Amount allocated to this payable", formalDefinition="The monetary amount allocated from the total payment to the payable." )
        protected Money amount;

        private static final long serialVersionUID = -1153705409L;

    /**
     * Constructor
     */
      public PaymentReconciliationAllocationComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (Unique identifier for the current payment item for the referenced payable.)
         */
        public Identifier getIdentifier() { 
          if (this.identifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.identifier");
            else if (Configuration.doAutoCreate())
              this.identifier = new Identifier(); // cc
          return this.identifier;
        }

        public boolean hasIdentifier() { 
          return this.identifier != null && !this.identifier.isEmpty();
        }

        /**
         * @param value {@link #identifier} (Unique identifier for the current payment item for the referenced payable.)
         */
        public PaymentReconciliationAllocationComponent setIdentifier(Identifier value) { 
          this.identifier = value;
          return this;
        }

        /**
         * @return {@link #predecessor} (Unique identifier for the prior payment item for the referenced payable.)
         */
        public Identifier getPredecessor() { 
          if (this.predecessor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.predecessor");
            else if (Configuration.doAutoCreate())
              this.predecessor = new Identifier(); // cc
          return this.predecessor;
        }

        public boolean hasPredecessor() { 
          return this.predecessor != null && !this.predecessor.isEmpty();
        }

        /**
         * @param value {@link #predecessor} (Unique identifier for the prior payment item for the referenced payable.)
         */
        public PaymentReconciliationAllocationComponent setPredecessor(Identifier value) { 
          this.predecessor = value;
          return this;
        }

        /**
         * @return {@link #target} (Specific resource to which the payment/adjustment/advance applies.)
         */
        public Reference getTarget() { 
          if (this.target == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.target");
            else if (Configuration.doAutoCreate())
              this.target = new Reference(); // cc
          return this.target;
        }

        public boolean hasTarget() { 
          return this.target != null && !this.target.isEmpty();
        }

        /**
         * @param value {@link #target} (Specific resource to which the payment/adjustment/advance applies.)
         */
        public PaymentReconciliationAllocationComponent setTarget(Reference value) { 
          this.target = value;
          return this;
        }

        /**
         * @return {@link #targetItem} ( Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.)
         */
        public DataType getTargetItem() { 
          return this.targetItem;
        }

        /**
         * @return {@link #targetItem} ( Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.)
         */
        public StringType getTargetItemStringType() throws FHIRException { 
          if (this.targetItem == null)
            this.targetItem = new StringType();
          if (!(this.targetItem instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.targetItem.getClass().getName()+" was encountered");
          return (StringType) this.targetItem;
        }

        public boolean hasTargetItemStringType() { 
          return this != null && this.targetItem instanceof StringType;
        }

        /**
         * @return {@link #targetItem} ( Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.)
         */
        public Identifier getTargetItemIdentifier() throws FHIRException { 
          if (this.targetItem == null)
            this.targetItem = new Identifier();
          if (!(this.targetItem instanceof Identifier))
            throw new FHIRException("Type mismatch: the type Identifier was expected, but "+this.targetItem.getClass().getName()+" was encountered");
          return (Identifier) this.targetItem;
        }

        public boolean hasTargetItemIdentifier() { 
          return this != null && this.targetItem instanceof Identifier;
        }

        /**
         * @return {@link #targetItem} ( Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.)
         */
        public PositiveIntType getTargetItemPositiveIntType() throws FHIRException { 
          if (this.targetItem == null)
            this.targetItem = new PositiveIntType();
          if (!(this.targetItem instanceof PositiveIntType))
            throw new FHIRException("Type mismatch: the type PositiveIntType was expected, but "+this.targetItem.getClass().getName()+" was encountered");
          return (PositiveIntType) this.targetItem;
        }

        public boolean hasTargetItemPositiveIntType() { 
          return this != null && this.targetItem instanceof PositiveIntType;
        }

        public boolean hasTargetItem() { 
          return this.targetItem != null && !this.targetItem.isEmpty();
        }

        /**
         * @param value {@link #targetItem} ( Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.)
         */
        public PaymentReconciliationAllocationComponent setTargetItem(DataType value) { 
          if (value != null && !(value instanceof StringType || value instanceof Identifier || value instanceof PositiveIntType))
            throw new FHIRException("Not the right type for PaymentReconciliation.allocation.targetItem[x]: "+value.fhirType());
          this.targetItem = value;
          return this;
        }

        /**
         * @return {@link #encounter} (The Encounter to which this payment applies, may be completed by the receiver, used for search.)
         */
        public Reference getEncounter() { 
          if (this.encounter == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.encounter");
            else if (Configuration.doAutoCreate())
              this.encounter = new Reference(); // cc
          return this.encounter;
        }

        public boolean hasEncounter() { 
          return this.encounter != null && !this.encounter.isEmpty();
        }

        /**
         * @param value {@link #encounter} (The Encounter to which this payment applies, may be completed by the receiver, used for search.)
         */
        public PaymentReconciliationAllocationComponent setEncounter(Reference value) { 
          this.encounter = value;
          return this;
        }

        /**
         * @return {@link #account} (The Account to which this payment applies, may be completed by the receiver, used for search.)
         */
        public Reference getAccount() { 
          if (this.account == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.account");
            else if (Configuration.doAutoCreate())
              this.account = new Reference(); // cc
          return this.account;
        }

        public boolean hasAccount() { 
          return this.account != null && !this.account.isEmpty();
        }

        /**
         * @param value {@link #account} (The Account to which this payment applies, may be completed by the receiver, used for search.)
         */
        public PaymentReconciliationAllocationComponent setAccount(Reference value) { 
          this.account = value;
          return this;
        }

        /**
         * @return {@link #type} (Code to indicate the nature of the payment.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Code to indicate the nature of the payment.)
         */
        public PaymentReconciliationAllocationComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #submitter} (The party which submitted the claim or financial transaction.)
         */
        public Reference getSubmitter() { 
          if (this.submitter == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.submitter");
            else if (Configuration.doAutoCreate())
              this.submitter = new Reference(); // cc
          return this.submitter;
        }

        public boolean hasSubmitter() { 
          return this.submitter != null && !this.submitter.isEmpty();
        }

        /**
         * @param value {@link #submitter} (The party which submitted the claim or financial transaction.)
         */
        public PaymentReconciliationAllocationComponent setSubmitter(Reference value) { 
          this.submitter = value;
          return this;
        }

        /**
         * @return {@link #response} (A resource, such as a ClaimResponse, which contains a commitment to payment.)
         */
        public Reference getResponse() { 
          if (this.response == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.response");
            else if (Configuration.doAutoCreate())
              this.response = new Reference(); // cc
          return this.response;
        }

        public boolean hasResponse() { 
          return this.response != null && !this.response.isEmpty();
        }

        /**
         * @param value {@link #response} (A resource, such as a ClaimResponse, which contains a commitment to payment.)
         */
        public PaymentReconciliationAllocationComponent setResponse(Reference value) { 
          this.response = value;
          return this;
        }

        /**
         * @return {@link #date} (The date from the response resource containing a commitment to pay.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public DateType getDateElement() { 
          if (this.date == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.date");
            else if (Configuration.doAutoCreate())
              this.date = new DateType(); // bb
          return this.date;
        }

        public boolean hasDateElement() { 
          return this.date != null && !this.date.isEmpty();
        }

        public boolean hasDate() { 
          return this.date != null && !this.date.isEmpty();
        }

        /**
         * @param value {@link #date} (The date from the response resource containing a commitment to pay.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public PaymentReconciliationAllocationComponent setDateElement(DateType value) { 
          this.date = value;
          return this;
        }

        /**
         * @return The date from the response resource containing a commitment to pay.
         */
        public Date getDate() { 
          return this.date == null ? null : this.date.getValue();
        }

        /**
         * @param value The date from the response resource containing a commitment to pay.
         */
        public PaymentReconciliationAllocationComponent setDate(Date value) { 
          if (value == null)
            this.date = null;
          else {
            if (this.date == null)
              this.date = new DateType();
            this.date.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #responsible} (A reference to the individual who is responsible for inquiries regarding the response and its payment.)
         */
        public Reference getResponsible() { 
          if (this.responsible == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.responsible");
            else if (Configuration.doAutoCreate())
              this.responsible = new Reference(); // cc
          return this.responsible;
        }

        public boolean hasResponsible() { 
          return this.responsible != null && !this.responsible.isEmpty();
        }

        /**
         * @param value {@link #responsible} (A reference to the individual who is responsible for inquiries regarding the response and its payment.)
         */
        public PaymentReconciliationAllocationComponent setResponsible(Reference value) { 
          this.responsible = value;
          return this;
        }

        /**
         * @return {@link #payee} (The party which is receiving the payment.)
         */
        public Reference getPayee() { 
          if (this.payee == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.payee");
            else if (Configuration.doAutoCreate())
              this.payee = new Reference(); // cc
          return this.payee;
        }

        public boolean hasPayee() { 
          return this.payee != null && !this.payee.isEmpty();
        }

        /**
         * @param value {@link #payee} (The party which is receiving the payment.)
         */
        public PaymentReconciliationAllocationComponent setPayee(Reference value) { 
          this.payee = value;
          return this;
        }

        /**
         * @return {@link #amount} (The monetary amount allocated from the total payment to the payable.)
         */
        public Money getAmount() { 
          if (this.amount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PaymentReconciliationAllocationComponent.amount");
            else if (Configuration.doAutoCreate())
              this.amount = new Money(); // cc
          return this.amount;
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (The monetary amount allocated from the total payment to the payable.)
         */
        public PaymentReconciliationAllocationComponent setAmount(Money value) { 
          this.amount = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "Unique identifier for the current payment item for the referenced payable.", 0, 1, identifier));
          children.add(new Property("predecessor", "Identifier", "Unique identifier for the prior payment item for the referenced payable.", 0, 1, predecessor));
          children.add(new Property("target", "Reference(Claim|Account|Invoice|ChargeItem|Encounter|Contract)", "Specific resource to which the payment/adjustment/advance applies.", 0, 1, target));
          children.add(new Property("targetItem[x]", "string|Identifier|positiveInt", " Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.", 0, 1, targetItem));
          children.add(new Property("encounter", "Reference(Encounter)", "The Encounter to which this payment applies, may be completed by the receiver, used for search.", 0, 1, encounter));
          children.add(new Property("account", "Reference(Account)", "The Account to which this payment applies, may be completed by the receiver, used for search.", 0, 1, account));
          children.add(new Property("type", "CodeableConcept", "Code to indicate the nature of the payment.", 0, 1, type));
          children.add(new Property("submitter", "Reference(Practitioner|PractitionerRole|Organization)", "The party which submitted the claim or financial transaction.", 0, 1, submitter));
          children.add(new Property("response", "Reference(ClaimResponse)", "A resource, such as a ClaimResponse, which contains a commitment to payment.", 0, 1, response));
          children.add(new Property("date", "date", "The date from the response resource containing a commitment to pay.", 0, 1, date));
          children.add(new Property("responsible", "Reference(PractitionerRole)", "A reference to the individual who is responsible for inquiries regarding the response and its payment.", 0, 1, responsible));
          children.add(new Property("payee", "Reference(Practitioner|PractitionerRole|Organization)", "The party which is receiving the payment.", 0, 1, payee));
          children.add(new Property("amount", "Money", "The monetary amount allocated from the total payment to the payable.", 0, 1, amount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique identifier for the current payment item for the referenced payable.", 0, 1, identifier);
          case -1925032183: /*predecessor*/  return new Property("predecessor", "Identifier", "Unique identifier for the prior payment item for the referenced payable.", 0, 1, predecessor);
          case -880905839: /*target*/  return new Property("target", "Reference(Claim|Account|Invoice|ChargeItem|Encounter|Contract)", "Specific resource to which the payment/adjustment/advance applies.", 0, 1, target);
          case 125181372: /*targetItem[x]*/  return new Property("targetItem[x]", "string|Identifier|positiveInt", " Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.", 0, 1, targetItem);
          case 486289476: /*targetItem*/  return new Property("targetItem[x]", "string|Identifier|positiveInt", " Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.", 0, 1, targetItem);
          case 1014643061: /*targetItemString*/  return new Property("targetItem[x]", "string", " Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.", 0, 1, targetItem);
          case -1768279027: /*targetItemIdentifier*/  return new Property("targetItem[x]", "Identifier", " Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.", 0, 1, targetItem);
          case -481526702: /*targetItemPositiveInt*/  return new Property("targetItem[x]", "positiveInt", " Identifies the claim line item, encounter or other sub-element being paid. Note payment may be partial, that is not match the then outstanding balance or amount incurred.", 0, 1, targetItem);
          case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "The Encounter to which this payment applies, may be completed by the receiver, used for search.", 0, 1, encounter);
          case -1177318867: /*account*/  return new Property("account", "Reference(Account)", "The Account to which this payment applies, may be completed by the receiver, used for search.", 0, 1, account);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Code to indicate the nature of the payment.", 0, 1, type);
          case 348678409: /*submitter*/  return new Property("submitter", "Reference(Practitioner|PractitionerRole|Organization)", "The party which submitted the claim or financial transaction.", 0, 1, submitter);
          case -340323263: /*response*/  return new Property("response", "Reference(ClaimResponse)", "A resource, such as a ClaimResponse, which contains a commitment to payment.", 0, 1, response);
          case 3076014: /*date*/  return new Property("date", "date", "The date from the response resource containing a commitment to pay.", 0, 1, date);
          case 1847674614: /*responsible*/  return new Property("responsible", "Reference(PractitionerRole)", "A reference to the individual who is responsible for inquiries regarding the response and its payment.", 0, 1, responsible);
          case 106443592: /*payee*/  return new Property("payee", "Reference(Practitioner|PractitionerRole|Organization)", "The party which is receiving the payment.", 0, 1, payee);
          case -1413853096: /*amount*/  return new Property("amount", "Money", "The monetary amount allocated from the total payment to the payable.", 0, 1, amount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case -1925032183: /*predecessor*/ return this.predecessor == null ? new Base[0] : new Base[] {this.predecessor}; // Identifier
        case -880905839: /*target*/ return this.target == null ? new Base[0] : new Base[] {this.target}; // Reference
        case 486289476: /*targetItem*/ return this.targetItem == null ? new Base[0] : new Base[] {this.targetItem}; // DataType
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1177318867: /*account*/ return this.account == null ? new Base[0] : new Base[] {this.account}; // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 348678409: /*submitter*/ return this.submitter == null ? new Base[0] : new Base[] {this.submitter}; // Reference
        case -340323263: /*response*/ return this.response == null ? new Base[0] : new Base[] {this.response}; // Reference
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateType
        case 1847674614: /*responsible*/ return this.responsible == null ? new Base[0] : new Base[] {this.responsible}; // Reference
        case 106443592: /*payee*/ return this.payee == null ? new Base[0] : new Base[] {this.payee}; // Reference
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Money
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -1925032183: // predecessor
          this.predecessor = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -880905839: // target
          this.target = TypeConvertor.castToReference(value); // Reference
          return value;
        case 486289476: // targetItem
          this.targetItem = TypeConvertor.castToType(value); // DataType
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1177318867: // account
          this.account = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 348678409: // submitter
          this.submitter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -340323263: // response
          this.response = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDate(value); // DateType
          return value;
        case 1847674614: // responsible
          this.responsible = TypeConvertor.castToReference(value); // Reference
          return value;
        case 106443592: // payee
          this.payee = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToMoney(value); // Money
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("predecessor")) {
          this.predecessor = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("target")) {
          this.target = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("targetItem[x]")) {
          this.targetItem = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("account")) {
          this.account = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("submitter")) {
          this.submitter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("response")) {
          this.response = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("responsible")) {
          this.responsible = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("payee")) {
          this.payee = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToMoney(value); // Money
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = null;
        } else if (name.equals("predecessor")) {
          this.predecessor = null;
        } else if (name.equals("target")) {
          this.target = null;
        } else if (name.equals("targetItem[x]")) {
          this.targetItem = null;
        } else if (name.equals("encounter")) {
          this.encounter = null;
        } else if (name.equals("account")) {
          this.account = null;
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("submitter")) {
          this.submitter = null;
        } else if (name.equals("response")) {
          this.response = null;
        } else if (name.equals("date")) {
          this.date = null;
        } else if (name.equals("responsible")) {
          this.responsible = null;
        } else if (name.equals("payee")) {
          this.payee = null;
        } else if (name.equals("amount")) {
          this.amount = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return getIdentifier();
        case -1925032183:  return getPredecessor();
        case -880905839:  return getTarget();
        case 125181372:  return getTargetItem();
        case 486289476:  return getTargetItem();
        case 1524132147:  return getEncounter();
        case -1177318867:  return getAccount();
        case 3575610:  return getType();
        case 348678409:  return getSubmitter();
        case -340323263:  return getResponse();
        case 3076014:  return getDateElement();
        case 1847674614:  return getResponsible();
        case 106443592:  return getPayee();
        case -1413853096:  return getAmount();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -1925032183: /*predecessor*/ return new String[] {"Identifier"};
        case -880905839: /*target*/ return new String[] {"Reference"};
        case 486289476: /*targetItem*/ return new String[] {"string", "Identifier", "positiveInt"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1177318867: /*account*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 348678409: /*submitter*/ return new String[] {"Reference"};
        case -340323263: /*response*/ return new String[] {"Reference"};
        case 3076014: /*date*/ return new String[] {"date"};
        case 1847674614: /*responsible*/ return new String[] {"Reference"};
        case 106443592: /*payee*/ return new String[] {"Reference"};
        case -1413853096: /*amount*/ return new String[] {"Money"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("predecessor")) {
          this.predecessor = new Identifier();
          return this.predecessor;
        }
        else if (name.equals("target")) {
          this.target = new Reference();
          return this.target;
        }
        else if (name.equals("targetItemString")) {
          this.targetItem = new StringType();
          return this.targetItem;
        }
        else if (name.equals("targetItemIdentifier")) {
          this.targetItem = new Identifier();
          return this.targetItem;
        }
        else if (name.equals("targetItemPositiveInt")) {
          this.targetItem = new PositiveIntType();
          return this.targetItem;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("account")) {
          this.account = new Reference();
          return this.account;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("submitter")) {
          this.submitter = new Reference();
          return this.submitter;
        }
        else if (name.equals("response")) {
          this.response = new Reference();
          return this.response;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.allocation.date");
        }
        else if (name.equals("responsible")) {
          this.responsible = new Reference();
          return this.responsible;
        }
        else if (name.equals("payee")) {
          this.payee = new Reference();
          return this.payee;
        }
        else if (name.equals("amount")) {
          this.amount = new Money();
          return this.amount;
        }
        else
          return super.addChild(name);
      }

      public PaymentReconciliationAllocationComponent copy() {
        PaymentReconciliationAllocationComponent dst = new PaymentReconciliationAllocationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PaymentReconciliationAllocationComponent dst) {
        super.copyValues(dst);
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.predecessor = predecessor == null ? null : predecessor.copy();
        dst.target = target == null ? null : target.copy();
        dst.targetItem = targetItem == null ? null : targetItem.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.account = account == null ? null : account.copy();
        dst.type = type == null ? null : type.copy();
        dst.submitter = submitter == null ? null : submitter.copy();
        dst.response = response == null ? null : response.copy();
        dst.date = date == null ? null : date.copy();
        dst.responsible = responsible == null ? null : responsible.copy();
        dst.payee = payee == null ? null : payee.copy();
        dst.amount = amount == null ? null : amount.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PaymentReconciliationAllocationComponent))
          return false;
        PaymentReconciliationAllocationComponent o = (PaymentReconciliationAllocationComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(predecessor, o.predecessor, true)
           && compareDeep(target, o.target, true) && compareDeep(targetItem, o.targetItem, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(account, o.account, true) && compareDeep(type, o.type, true) && compareDeep(submitter, o.submitter, true)
           && compareDeep(response, o.response, true) && compareDeep(date, o.date, true) && compareDeep(responsible, o.responsible, true)
           && compareDeep(payee, o.payee, true) && compareDeep(amount, o.amount, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PaymentReconciliationAllocationComponent))
          return false;
        PaymentReconciliationAllocationComponent o = (PaymentReconciliationAllocationComponent) other_;
        return compareValues(date, o.date, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, predecessor, target
          , targetItem, encounter, account, type, submitter, response, date, responsible
          , payee, amount);
      }

  public String fhirType() {
    return "PaymentReconciliation.allocation";

  }

  }

    @Block()
    public static class NotesComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The business purpose of the note text.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="display | print | printoper", formalDefinition="The business purpose of the note text." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/note-type")
        protected Enumeration<NoteType> type;

        /**
         * The explanation or description associated with the processing.
         */
        @Child(name = "text", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Note explanatory text", formalDefinition="The explanation or description associated with the processing." )
        protected StringType text;

        private static final long serialVersionUID = 529250161L;

    /**
     * Constructor
     */
      public NotesComponent() {
        super();
      }

        /**
         * @return {@link #type} (The business purpose of the note text.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<NoteType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NotesComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<NoteType>(new NoteTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The business purpose of the note text.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public NotesComponent setTypeElement(Enumeration<NoteType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The business purpose of the note text.
         */
        public NoteType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The business purpose of the note text.
         */
        public NotesComponent setType(NoteType value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Enumeration<NoteType>(new NoteTypeEnumFactory());
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #text} (The explanation or description associated with the processing.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public StringType getTextElement() { 
          if (this.text == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create NotesComponent.text");
            else if (Configuration.doAutoCreate())
              this.text = new StringType(); // bb
          return this.text;
        }

        public boolean hasTextElement() { 
          return this.text != null && !this.text.isEmpty();
        }

        public boolean hasText() { 
          return this.text != null && !this.text.isEmpty();
        }

        /**
         * @param value {@link #text} (The explanation or description associated with the processing.). This is the underlying object with id, value and extensions. The accessor "getText" gives direct access to the value
         */
        public NotesComponent setTextElement(StringType value) { 
          this.text = value;
          return this;
        }

        /**
         * @return The explanation or description associated with the processing.
         */
        public String getText() { 
          return this.text == null ? null : this.text.getValue();
        }

        /**
         * @param value The explanation or description associated with the processing.
         */
        public NotesComponent setText(String value) { 
          if (Utilities.noString(value))
            this.text = null;
          else {
            if (this.text == null)
              this.text = new StringType();
            this.text.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "The business purpose of the note text.", 0, 1, type));
          children.add(new Property("text", "string", "The explanation or description associated with the processing.", 0, 1, text));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "The business purpose of the note text.", 0, 1, type);
          case 3556653: /*text*/  return new Property("text", "string", "The explanation or description associated with the processing.", 0, 1, text);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<NoteType>
        case 3556653: /*text*/ return this.text == null ? new Base[0] : new Base[] {this.text}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new NoteTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<NoteType>
          return value;
        case 3556653: // text
          this.text = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new NoteTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<NoteType>
        } else if (name.equals("text")) {
          this.text = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new NoteTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<NoteType>
        } else if (name.equals("text")) {
          this.text = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case 3556653:  return getTextElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case 3556653: /*text*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.processNote.type");
        }
        else if (name.equals("text")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.processNote.text");
        }
        else
          return super.addChild(name);
      }

      public NotesComponent copy() {
        NotesComponent dst = new NotesComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(NotesComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.text = text == null ? null : text.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof NotesComponent))
          return false;
        NotesComponent o = (NotesComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(text, o.text, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof NotesComponent))
          return false;
        NotesComponent o = (NotesComponent) other_;
        return compareValues(type, o.type, true) && compareValues(text, o.text, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, text);
      }

  public String fhirType() {
    return "PaymentReconciliation.processNote";

  }

  }

    /**
     * A unique identifier assigned to this payment reconciliation.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Business Identifier for a payment reconciliation", formalDefinition="A unique identifier assigned to this payment reconciliation." )
    protected List<Identifier> identifier;

    /**
     * Code to indicate the nature of the payment such as payment, adjustment.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Category of payment", formalDefinition="Code to indicate the nature of the payment such as payment, adjustment." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/payment-type")
    protected CodeableConcept type;

    /**
     * The status of the resource instance.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | cancelled | draft | entered-in-error", formalDefinition="The status of the resource instance." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/fm-status")
    protected Enumeration<FinancialResourceStatusCodes> status;

    /**
     * The workflow or activity which gave rise to or during which the payment ocurred such as a kiosk, deposit on account, periodic payment etc.
     */
    @Child(name = "kind", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Workflow originating payment", formalDefinition="The workflow or activity which gave rise to or during which the payment ocurred such as a kiosk, deposit on account, periodic payment etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/payment-kind")
    protected CodeableConcept kind;

    /**
     * The period of time for which payments have been gathered into this bulk payment for settlement.
     */
    @Child(name = "period", type = {Period.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Period covered", formalDefinition="The period of time for which payments have been gathered into this bulk payment for settlement." )
    protected Period period;

    /**
     * The date when the resource was created.
     */
    @Child(name = "created", type = {DateTimeType.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Creation date", formalDefinition="The date when the resource was created." )
    protected DateTimeType created;

    /**
     * Payment enterer if not the actual payment issuer.
     */
    @Child(name = "enterer", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Who entered the payment", formalDefinition="Payment enterer if not the actual payment issuer." )
    protected Reference enterer;

    /**
     * The type of the source such as patient or insurance.
     */
    @Child(name = "issuerType", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Nature of the source", formalDefinition="The type of the source such as patient or insurance." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/payment-issuertype")
    protected CodeableConcept issuerType;

    /**
     * The party who generated the payment.
     */
    @Child(name = "paymentIssuer", type = {Organization.class, Patient.class, RelatedPerson.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Party generating payment", formalDefinition="The party who generated the payment." )
    protected Reference paymentIssuer;

    /**
     * Original request resource reference.
     */
    @Child(name = "request", type = {Task.class}, order=9, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Reference to requesting resource", formalDefinition="Original request resource reference." )
    protected Reference request;

    /**
     * The practitioner who is responsible for the services rendered to the patient.
     */
    @Child(name = "requestor", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Responsible practitioner", formalDefinition="The practitioner who is responsible for the services rendered to the patient." )
    protected Reference requestor;

    /**
     * The outcome of a request for a reconciliation.
     */
    @Child(name = "outcome", type = {CodeType.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="queued | complete | error | partial", formalDefinition="The outcome of a request for a reconciliation." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/payment-outcome")
    protected Enumeration<PaymentOutcome> outcome;

    /**
     * A human readable description of the status of the request for the reconciliation.
     */
    @Child(name = "disposition", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Disposition message", formalDefinition="A human readable description of the status of the request for the reconciliation." )
    protected StringType disposition;

    /**
     * The date of payment as indicated on the financial instrument.
     */
    @Child(name = "date", type = {DateType.class}, order=13, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When payment issued", formalDefinition="The date of payment as indicated on the financial instrument." )
    protected DateType date;

    /**
     * The location of the site or device for electronic transfers or physical location for cash payments.
     */
    @Child(name = "location", type = {Location.class}, order=14, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Where payment collected", formalDefinition="The location of the site or device for electronic transfers or physical location for cash payments." )
    protected Reference location;

    /**
     * The means of payment such as check, card cash, or electronic funds transfer.
     */
    @Child(name = "method", type = {CodeableConcept.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Payment instrument", formalDefinition="The means of payment such as check, card cash, or electronic funds transfer." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0570")
    protected CodeableConcept method;

    /**
     * The card brand such as debit, Visa, Amex etc. used if a card is the method of payment.
     */
    @Child(name = "cardBrand", type = {StringType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Type of card", formalDefinition="The card brand such as debit, Visa, Amex etc. used if a card is the method of payment." )
    protected StringType cardBrand;

    /**
     * A portion of the account number, often the last 4 digits, used for verification not charging purposes.
     */
    @Child(name = "accountNumber", type = {StringType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Digits for verification", formalDefinition="A portion of the account number, often the last 4 digits, used for verification not charging purposes." )
    protected StringType accountNumber;

    /**
     * The year and month (YYYY-MM) when the instrument, typically card, expires.
     */
    @Child(name = "expirationDate", type = {DateType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Expiration year-month", formalDefinition="The year and month (YYYY-MM) when the instrument, typically card, expires." )
    protected DateType expirationDate;

    /**
     * The name of the card processor, etf processor, bank for checks.
     */
    @Child(name = "processor", type = {StringType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Processor name", formalDefinition="The name of the card processor, etf processor, bank for checks." )
    protected StringType processor;

    /**
     * The check number, eft reference, car processor reference.
     */
    @Child(name = "referenceNumber", type = {StringType.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Check number or payment reference", formalDefinition="The check number, eft reference, car processor reference." )
    protected StringType referenceNumber;

    /**
     * An alphanumeric issued by the processor to confirm the successful issuance of payment.
     */
    @Child(name = "authorization", type = {StringType.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Authorization number", formalDefinition="An alphanumeric issued by the processor to confirm the successful issuance of payment." )
    protected StringType authorization;

    /**
     * The amount offered by the issuer, typically applies to cash when the issuer provides an amount in bank note denominations equal to or excess of the amount actually being paid.
     */
    @Child(name = "tenderedAmount", type = {Money.class}, order=22, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Amount offered by the issuer", formalDefinition="The amount offered by the issuer, typically applies to cash when the issuer provides an amount in bank note denominations equal to or excess of the amount actually being paid." )
    protected Money tenderedAmount;

    /**
     * The amount returned by the receiver which is excess to the amount payable, often referred to as 'change'.
     */
    @Child(name = "returnedAmount", type = {Money.class}, order=23, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Amount returned by the receiver", formalDefinition="The amount returned by the receiver which is excess to the amount payable, often referred to as 'change'." )
    protected Money returnedAmount;

    /**
     * Total payment amount as indicated on the financial instrument.
     */
    @Child(name = "amount", type = {Money.class}, order=24, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Total amount of Payment", formalDefinition="Total payment amount as indicated on the financial instrument." )
    protected Money amount;

    /**
     * Issuer's unique identifier for the payment instrument.
     */
    @Child(name = "paymentIdentifier", type = {Identifier.class}, order=25, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Business identifier for the payment", formalDefinition="Issuer's unique identifier for the payment instrument." )
    protected Identifier paymentIdentifier;

    /**
     * Distribution of the payment amount for a previously acknowledged payable.
     */
    @Child(name = "allocation", type = {}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Settlement particulars", formalDefinition="Distribution of the payment amount for a previously acknowledged payable." )
    protected List<PaymentReconciliationAllocationComponent> allocation;

    /**
     * A code for the form to be used for printing the content.
     */
    @Child(name = "formCode", type = {CodeableConcept.class}, order=27, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Printed form identifier", formalDefinition="A code for the form to be used for printing the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/forms")
    protected CodeableConcept formCode;

    /**
     * A note that describes or explains the processing in a human readable form.
     */
    @Child(name = "processNote", type = {}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Note concerning processing", formalDefinition="A note that describes or explains the processing in a human readable form." )
    protected List<NotesComponent> processNote;

    private static final long serialVersionUID = 705873820L;

  /**
   * Constructor
   */
    public PaymentReconciliation() {
      super();
    }

  /**
   * Constructor
   */
    public PaymentReconciliation(CodeableConcept type, FinancialResourceStatusCodes status, Date created, Date date, Money amount) {
      super();
      this.setType(type);
      this.setStatus(status);
      this.setCreated(created);
      this.setDate(date);
      this.setAmount(amount);
    }

    /**
     * @return {@link #identifier} (A unique identifier assigned to this payment reconciliation.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PaymentReconciliation setIdentifier(List<Identifier> theIdentifier) { 
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

    public PaymentReconciliation addIdentifier(Identifier t) { //3
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
     * @return {@link #type} (Code to indicate the nature of the payment such as payment, adjustment.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (Code to indicate the nature of the payment such as payment, adjustment.)
     */
    public PaymentReconciliation setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of the resource instance.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<FinancialResourceStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<FinancialResourceStatusCodes>(new FinancialResourceStatusCodesEnumFactory()); // bb
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
    public PaymentReconciliation setStatusElement(Enumeration<FinancialResourceStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of the resource instance.
     */
    public FinancialResourceStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of the resource instance.
     */
    public PaymentReconciliation setStatus(FinancialResourceStatusCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<FinancialResourceStatusCodes>(new FinancialResourceStatusCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #kind} (The workflow or activity which gave rise to or during which the payment ocurred such as a kiosk, deposit on account, periodic payment etc.)
     */
    public CodeableConcept getKind() { 
      if (this.kind == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.kind");
        else if (Configuration.doAutoCreate())
          this.kind = new CodeableConcept(); // cc
      return this.kind;
    }

    public boolean hasKind() { 
      return this.kind != null && !this.kind.isEmpty();
    }

    /**
     * @param value {@link #kind} (The workflow or activity which gave rise to or during which the payment ocurred such as a kiosk, deposit on account, periodic payment etc.)
     */
    public PaymentReconciliation setKind(CodeableConcept value) { 
      this.kind = value;
      return this;
    }

    /**
     * @return {@link #period} (The period of time for which payments have been gathered into this bulk payment for settlement.)
     */
    public Period getPeriod() { 
      if (this.period == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.period");
        else if (Configuration.doAutoCreate())
          this.period = new Period(); // cc
      return this.period;
    }

    public boolean hasPeriod() { 
      return this.period != null && !this.period.isEmpty();
    }

    /**
     * @param value {@link #period} (The period of time for which payments have been gathered into this bulk payment for settlement.)
     */
    public PaymentReconciliation setPeriod(Period value) { 
      this.period = value;
      return this;
    }

    /**
     * @return {@link #created} (The date when the resource was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public DateTimeType getCreatedElement() { 
      if (this.created == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.created");
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
     * @param value {@link #created} (The date when the resource was created.). This is the underlying object with id, value and extensions. The accessor "getCreated" gives direct access to the value
     */
    public PaymentReconciliation setCreatedElement(DateTimeType value) { 
      this.created = value;
      return this;
    }

    /**
     * @return The date when the resource was created.
     */
    public Date getCreated() { 
      return this.created == null ? null : this.created.getValue();
    }

    /**
     * @param value The date when the resource was created.
     */
    public PaymentReconciliation setCreated(Date value) { 
        if (this.created == null)
          this.created = new DateTimeType();
        this.created.setValue(value);
      return this;
    }

    /**
     * @return {@link #enterer} (Payment enterer if not the actual payment issuer.)
     */
    public Reference getEnterer() { 
      if (this.enterer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.enterer");
        else if (Configuration.doAutoCreate())
          this.enterer = new Reference(); // cc
      return this.enterer;
    }

    public boolean hasEnterer() { 
      return this.enterer != null && !this.enterer.isEmpty();
    }

    /**
     * @param value {@link #enterer} (Payment enterer if not the actual payment issuer.)
     */
    public PaymentReconciliation setEnterer(Reference value) { 
      this.enterer = value;
      return this;
    }

    /**
     * @return {@link #issuerType} (The type of the source such as patient or insurance.)
     */
    public CodeableConcept getIssuerType() { 
      if (this.issuerType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.issuerType");
        else if (Configuration.doAutoCreate())
          this.issuerType = new CodeableConcept(); // cc
      return this.issuerType;
    }

    public boolean hasIssuerType() { 
      return this.issuerType != null && !this.issuerType.isEmpty();
    }

    /**
     * @param value {@link #issuerType} (The type of the source such as patient or insurance.)
     */
    public PaymentReconciliation setIssuerType(CodeableConcept value) { 
      this.issuerType = value;
      return this;
    }

    /**
     * @return {@link #paymentIssuer} (The party who generated the payment.)
     */
    public Reference getPaymentIssuer() { 
      if (this.paymentIssuer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.paymentIssuer");
        else if (Configuration.doAutoCreate())
          this.paymentIssuer = new Reference(); // cc
      return this.paymentIssuer;
    }

    public boolean hasPaymentIssuer() { 
      return this.paymentIssuer != null && !this.paymentIssuer.isEmpty();
    }

    /**
     * @param value {@link #paymentIssuer} (The party who generated the payment.)
     */
    public PaymentReconciliation setPaymentIssuer(Reference value) { 
      this.paymentIssuer = value;
      return this;
    }

    /**
     * @return {@link #request} (Original request resource reference.)
     */
    public Reference getRequest() { 
      if (this.request == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.request");
        else if (Configuration.doAutoCreate())
          this.request = new Reference(); // cc
      return this.request;
    }

    public boolean hasRequest() { 
      return this.request != null && !this.request.isEmpty();
    }

    /**
     * @param value {@link #request} (Original request resource reference.)
     */
    public PaymentReconciliation setRequest(Reference value) { 
      this.request = value;
      return this;
    }

    /**
     * @return {@link #requestor} (The practitioner who is responsible for the services rendered to the patient.)
     */
    public Reference getRequestor() { 
      if (this.requestor == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.requestor");
        else if (Configuration.doAutoCreate())
          this.requestor = new Reference(); // cc
      return this.requestor;
    }

    public boolean hasRequestor() { 
      return this.requestor != null && !this.requestor.isEmpty();
    }

    /**
     * @param value {@link #requestor} (The practitioner who is responsible for the services rendered to the patient.)
     */
    public PaymentReconciliation setRequestor(Reference value) { 
      this.requestor = value;
      return this;
    }

    /**
     * @return {@link #outcome} (The outcome of a request for a reconciliation.). This is the underlying object with id, value and extensions. The accessor "getOutcome" gives direct access to the value
     */
    public Enumeration<PaymentOutcome> getOutcomeElement() { 
      if (this.outcome == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.outcome");
        else if (Configuration.doAutoCreate())
          this.outcome = new Enumeration<PaymentOutcome>(new PaymentOutcomeEnumFactory()); // bb
      return this.outcome;
    }

    public boolean hasOutcomeElement() { 
      return this.outcome != null && !this.outcome.isEmpty();
    }

    public boolean hasOutcome() { 
      return this.outcome != null && !this.outcome.isEmpty();
    }

    /**
     * @param value {@link #outcome} (The outcome of a request for a reconciliation.). This is the underlying object with id, value and extensions. The accessor "getOutcome" gives direct access to the value
     */
    public PaymentReconciliation setOutcomeElement(Enumeration<PaymentOutcome> value) { 
      this.outcome = value;
      return this;
    }

    /**
     * @return The outcome of a request for a reconciliation.
     */
    public PaymentOutcome getOutcome() { 
      return this.outcome == null ? null : this.outcome.getValue();
    }

    /**
     * @param value The outcome of a request for a reconciliation.
     */
    public PaymentReconciliation setOutcome(PaymentOutcome value) { 
      if (value == null)
        this.outcome = null;
      else {
        if (this.outcome == null)
          this.outcome = new Enumeration<PaymentOutcome>(new PaymentOutcomeEnumFactory());
        this.outcome.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #disposition} (A human readable description of the status of the request for the reconciliation.). This is the underlying object with id, value and extensions. The accessor "getDisposition" gives direct access to the value
     */
    public StringType getDispositionElement() { 
      if (this.disposition == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.disposition");
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
     * @param value {@link #disposition} (A human readable description of the status of the request for the reconciliation.). This is the underlying object with id, value and extensions. The accessor "getDisposition" gives direct access to the value
     */
    public PaymentReconciliation setDispositionElement(StringType value) { 
      this.disposition = value;
      return this;
    }

    /**
     * @return A human readable description of the status of the request for the reconciliation.
     */
    public String getDisposition() { 
      return this.disposition == null ? null : this.disposition.getValue();
    }

    /**
     * @param value A human readable description of the status of the request for the reconciliation.
     */
    public PaymentReconciliation setDisposition(String value) { 
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
     * @return {@link #date} (The date of payment as indicated on the financial instrument.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.date");
        else if (Configuration.doAutoCreate())
          this.date = new DateType(); // bb
      return this.date;
    }

    public boolean hasDateElement() { 
      return this.date != null && !this.date.isEmpty();
    }

    public boolean hasDate() { 
      return this.date != null && !this.date.isEmpty();
    }

    /**
     * @param value {@link #date} (The date of payment as indicated on the financial instrument.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public PaymentReconciliation setDateElement(DateType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date of payment as indicated on the financial instrument.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date of payment as indicated on the financial instrument.
     */
    public PaymentReconciliation setDate(Date value) { 
        if (this.date == null)
          this.date = new DateType();
        this.date.setValue(value);
      return this;
    }

    /**
     * @return {@link #location} (The location of the site or device for electronic transfers or physical location for cash payments.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (The location of the site or device for electronic transfers or physical location for cash payments.)
     */
    public PaymentReconciliation setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #method} (The means of payment such as check, card cash, or electronic funds transfer.)
     */
    public CodeableConcept getMethod() { 
      if (this.method == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.method");
        else if (Configuration.doAutoCreate())
          this.method = new CodeableConcept(); // cc
      return this.method;
    }

    public boolean hasMethod() { 
      return this.method != null && !this.method.isEmpty();
    }

    /**
     * @param value {@link #method} (The means of payment such as check, card cash, or electronic funds transfer.)
     */
    public PaymentReconciliation setMethod(CodeableConcept value) { 
      this.method = value;
      return this;
    }

    /**
     * @return {@link #cardBrand} (The card brand such as debit, Visa, Amex etc. used if a card is the method of payment.). This is the underlying object with id, value and extensions. The accessor "getCardBrand" gives direct access to the value
     */
    public StringType getCardBrandElement() { 
      if (this.cardBrand == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.cardBrand");
        else if (Configuration.doAutoCreate())
          this.cardBrand = new StringType(); // bb
      return this.cardBrand;
    }

    public boolean hasCardBrandElement() { 
      return this.cardBrand != null && !this.cardBrand.isEmpty();
    }

    public boolean hasCardBrand() { 
      return this.cardBrand != null && !this.cardBrand.isEmpty();
    }

    /**
     * @param value {@link #cardBrand} (The card brand such as debit, Visa, Amex etc. used if a card is the method of payment.). This is the underlying object with id, value and extensions. The accessor "getCardBrand" gives direct access to the value
     */
    public PaymentReconciliation setCardBrandElement(StringType value) { 
      this.cardBrand = value;
      return this;
    }

    /**
     * @return The card brand such as debit, Visa, Amex etc. used if a card is the method of payment.
     */
    public String getCardBrand() { 
      return this.cardBrand == null ? null : this.cardBrand.getValue();
    }

    /**
     * @param value The card brand such as debit, Visa, Amex etc. used if a card is the method of payment.
     */
    public PaymentReconciliation setCardBrand(String value) { 
      if (Utilities.noString(value))
        this.cardBrand = null;
      else {
        if (this.cardBrand == null)
          this.cardBrand = new StringType();
        this.cardBrand.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #accountNumber} (A portion of the account number, often the last 4 digits, used for verification not charging purposes.). This is the underlying object with id, value and extensions. The accessor "getAccountNumber" gives direct access to the value
     */
    public StringType getAccountNumberElement() { 
      if (this.accountNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.accountNumber");
        else if (Configuration.doAutoCreate())
          this.accountNumber = new StringType(); // bb
      return this.accountNumber;
    }

    public boolean hasAccountNumberElement() { 
      return this.accountNumber != null && !this.accountNumber.isEmpty();
    }

    public boolean hasAccountNumber() { 
      return this.accountNumber != null && !this.accountNumber.isEmpty();
    }

    /**
     * @param value {@link #accountNumber} (A portion of the account number, often the last 4 digits, used for verification not charging purposes.). This is the underlying object with id, value and extensions. The accessor "getAccountNumber" gives direct access to the value
     */
    public PaymentReconciliation setAccountNumberElement(StringType value) { 
      this.accountNumber = value;
      return this;
    }

    /**
     * @return A portion of the account number, often the last 4 digits, used for verification not charging purposes.
     */
    public String getAccountNumber() { 
      return this.accountNumber == null ? null : this.accountNumber.getValue();
    }

    /**
     * @param value A portion of the account number, often the last 4 digits, used for verification not charging purposes.
     */
    public PaymentReconciliation setAccountNumber(String value) { 
      if (Utilities.noString(value))
        this.accountNumber = null;
      else {
        if (this.accountNumber == null)
          this.accountNumber = new StringType();
        this.accountNumber.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #expirationDate} (The year and month (YYYY-MM) when the instrument, typically card, expires.). This is the underlying object with id, value and extensions. The accessor "getExpirationDate" gives direct access to the value
     */
    public DateType getExpirationDateElement() { 
      if (this.expirationDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.expirationDate");
        else if (Configuration.doAutoCreate())
          this.expirationDate = new DateType(); // bb
      return this.expirationDate;
    }

    public boolean hasExpirationDateElement() { 
      return this.expirationDate != null && !this.expirationDate.isEmpty();
    }

    public boolean hasExpirationDate() { 
      return this.expirationDate != null && !this.expirationDate.isEmpty();
    }

    /**
     * @param value {@link #expirationDate} (The year and month (YYYY-MM) when the instrument, typically card, expires.). This is the underlying object with id, value and extensions. The accessor "getExpirationDate" gives direct access to the value
     */
    public PaymentReconciliation setExpirationDateElement(DateType value) { 
      this.expirationDate = value;
      return this;
    }

    /**
     * @return The year and month (YYYY-MM) when the instrument, typically card, expires.
     */
    public Date getExpirationDate() { 
      return this.expirationDate == null ? null : this.expirationDate.getValue();
    }

    /**
     * @param value The year and month (YYYY-MM) when the instrument, typically card, expires.
     */
    public PaymentReconciliation setExpirationDate(Date value) { 
      if (value == null)
        this.expirationDate = null;
      else {
        if (this.expirationDate == null)
          this.expirationDate = new DateType();
        this.expirationDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #processor} (The name of the card processor, etf processor, bank for checks.). This is the underlying object with id, value and extensions. The accessor "getProcessor" gives direct access to the value
     */
    public StringType getProcessorElement() { 
      if (this.processor == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.processor");
        else if (Configuration.doAutoCreate())
          this.processor = new StringType(); // bb
      return this.processor;
    }

    public boolean hasProcessorElement() { 
      return this.processor != null && !this.processor.isEmpty();
    }

    public boolean hasProcessor() { 
      return this.processor != null && !this.processor.isEmpty();
    }

    /**
     * @param value {@link #processor} (The name of the card processor, etf processor, bank for checks.). This is the underlying object with id, value and extensions. The accessor "getProcessor" gives direct access to the value
     */
    public PaymentReconciliation setProcessorElement(StringType value) { 
      this.processor = value;
      return this;
    }

    /**
     * @return The name of the card processor, etf processor, bank for checks.
     */
    public String getProcessor() { 
      return this.processor == null ? null : this.processor.getValue();
    }

    /**
     * @param value The name of the card processor, etf processor, bank for checks.
     */
    public PaymentReconciliation setProcessor(String value) { 
      if (Utilities.noString(value))
        this.processor = null;
      else {
        if (this.processor == null)
          this.processor = new StringType();
        this.processor.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #referenceNumber} (The check number, eft reference, car processor reference.). This is the underlying object with id, value and extensions. The accessor "getReferenceNumber" gives direct access to the value
     */
    public StringType getReferenceNumberElement() { 
      if (this.referenceNumber == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.referenceNumber");
        else if (Configuration.doAutoCreate())
          this.referenceNumber = new StringType(); // bb
      return this.referenceNumber;
    }

    public boolean hasReferenceNumberElement() { 
      return this.referenceNumber != null && !this.referenceNumber.isEmpty();
    }

    public boolean hasReferenceNumber() { 
      return this.referenceNumber != null && !this.referenceNumber.isEmpty();
    }

    /**
     * @param value {@link #referenceNumber} (The check number, eft reference, car processor reference.). This is the underlying object with id, value and extensions. The accessor "getReferenceNumber" gives direct access to the value
     */
    public PaymentReconciliation setReferenceNumberElement(StringType value) { 
      this.referenceNumber = value;
      return this;
    }

    /**
     * @return The check number, eft reference, car processor reference.
     */
    public String getReferenceNumber() { 
      return this.referenceNumber == null ? null : this.referenceNumber.getValue();
    }

    /**
     * @param value The check number, eft reference, car processor reference.
     */
    public PaymentReconciliation setReferenceNumber(String value) { 
      if (Utilities.noString(value))
        this.referenceNumber = null;
      else {
        if (this.referenceNumber == null)
          this.referenceNumber = new StringType();
        this.referenceNumber.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #authorization} (An alphanumeric issued by the processor to confirm the successful issuance of payment.). This is the underlying object with id, value and extensions. The accessor "getAuthorization" gives direct access to the value
     */
    public StringType getAuthorizationElement() { 
      if (this.authorization == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.authorization");
        else if (Configuration.doAutoCreate())
          this.authorization = new StringType(); // bb
      return this.authorization;
    }

    public boolean hasAuthorizationElement() { 
      return this.authorization != null && !this.authorization.isEmpty();
    }

    public boolean hasAuthorization() { 
      return this.authorization != null && !this.authorization.isEmpty();
    }

    /**
     * @param value {@link #authorization} (An alphanumeric issued by the processor to confirm the successful issuance of payment.). This is the underlying object with id, value and extensions. The accessor "getAuthorization" gives direct access to the value
     */
    public PaymentReconciliation setAuthorizationElement(StringType value) { 
      this.authorization = value;
      return this;
    }

    /**
     * @return An alphanumeric issued by the processor to confirm the successful issuance of payment.
     */
    public String getAuthorization() { 
      return this.authorization == null ? null : this.authorization.getValue();
    }

    /**
     * @param value An alphanumeric issued by the processor to confirm the successful issuance of payment.
     */
    public PaymentReconciliation setAuthorization(String value) { 
      if (Utilities.noString(value))
        this.authorization = null;
      else {
        if (this.authorization == null)
          this.authorization = new StringType();
        this.authorization.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #tenderedAmount} (The amount offered by the issuer, typically applies to cash when the issuer provides an amount in bank note denominations equal to or excess of the amount actually being paid.)
     */
    public Money getTenderedAmount() { 
      if (this.tenderedAmount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.tenderedAmount");
        else if (Configuration.doAutoCreate())
          this.tenderedAmount = new Money(); // cc
      return this.tenderedAmount;
    }

    public boolean hasTenderedAmount() { 
      return this.tenderedAmount != null && !this.tenderedAmount.isEmpty();
    }

    /**
     * @param value {@link #tenderedAmount} (The amount offered by the issuer, typically applies to cash when the issuer provides an amount in bank note denominations equal to or excess of the amount actually being paid.)
     */
    public PaymentReconciliation setTenderedAmount(Money value) { 
      this.tenderedAmount = value;
      return this;
    }

    /**
     * @return {@link #returnedAmount} (The amount returned by the receiver which is excess to the amount payable, often referred to as 'change'.)
     */
    public Money getReturnedAmount() { 
      if (this.returnedAmount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.returnedAmount");
        else if (Configuration.doAutoCreate())
          this.returnedAmount = new Money(); // cc
      return this.returnedAmount;
    }

    public boolean hasReturnedAmount() { 
      return this.returnedAmount != null && !this.returnedAmount.isEmpty();
    }

    /**
     * @param value {@link #returnedAmount} (The amount returned by the receiver which is excess to the amount payable, often referred to as 'change'.)
     */
    public PaymentReconciliation setReturnedAmount(Money value) { 
      this.returnedAmount = value;
      return this;
    }

    /**
     * @return {@link #amount} (Total payment amount as indicated on the financial instrument.)
     */
    public Money getAmount() { 
      if (this.amount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.amount");
        else if (Configuration.doAutoCreate())
          this.amount = new Money(); // cc
      return this.amount;
    }

    public boolean hasAmount() { 
      return this.amount != null && !this.amount.isEmpty();
    }

    /**
     * @param value {@link #amount} (Total payment amount as indicated on the financial instrument.)
     */
    public PaymentReconciliation setAmount(Money value) { 
      this.amount = value;
      return this;
    }

    /**
     * @return {@link #paymentIdentifier} (Issuer's unique identifier for the payment instrument.)
     */
    public Identifier getPaymentIdentifier() { 
      if (this.paymentIdentifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.paymentIdentifier");
        else if (Configuration.doAutoCreate())
          this.paymentIdentifier = new Identifier(); // cc
      return this.paymentIdentifier;
    }

    public boolean hasPaymentIdentifier() { 
      return this.paymentIdentifier != null && !this.paymentIdentifier.isEmpty();
    }

    /**
     * @param value {@link #paymentIdentifier} (Issuer's unique identifier for the payment instrument.)
     */
    public PaymentReconciliation setPaymentIdentifier(Identifier value) { 
      this.paymentIdentifier = value;
      return this;
    }

    /**
     * @return {@link #allocation} (Distribution of the payment amount for a previously acknowledged payable.)
     */
    public List<PaymentReconciliationAllocationComponent> getAllocation() { 
      if (this.allocation == null)
        this.allocation = new ArrayList<PaymentReconciliationAllocationComponent>();
      return this.allocation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PaymentReconciliation setAllocation(List<PaymentReconciliationAllocationComponent> theAllocation) { 
      this.allocation = theAllocation;
      return this;
    }

    public boolean hasAllocation() { 
      if (this.allocation == null)
        return false;
      for (PaymentReconciliationAllocationComponent item : this.allocation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PaymentReconciliationAllocationComponent addAllocation() { //3
      PaymentReconciliationAllocationComponent t = new PaymentReconciliationAllocationComponent();
      if (this.allocation == null)
        this.allocation = new ArrayList<PaymentReconciliationAllocationComponent>();
      this.allocation.add(t);
      return t;
    }

    public PaymentReconciliation addAllocation(PaymentReconciliationAllocationComponent t) { //3
      if (t == null)
        return this;
      if (this.allocation == null)
        this.allocation = new ArrayList<PaymentReconciliationAllocationComponent>();
      this.allocation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #allocation}, creating it if it does not already exist {3}
     */
    public PaymentReconciliationAllocationComponent getAllocationFirstRep() { 
      if (getAllocation().isEmpty()) {
        addAllocation();
      }
      return getAllocation().get(0);
    }

    /**
     * @return {@link #formCode} (A code for the form to be used for printing the content.)
     */
    public CodeableConcept getFormCode() { 
      if (this.formCode == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PaymentReconciliation.formCode");
        else if (Configuration.doAutoCreate())
          this.formCode = new CodeableConcept(); // cc
      return this.formCode;
    }

    public boolean hasFormCode() { 
      return this.formCode != null && !this.formCode.isEmpty();
    }

    /**
     * @param value {@link #formCode} (A code for the form to be used for printing the content.)
     */
    public PaymentReconciliation setFormCode(CodeableConcept value) { 
      this.formCode = value;
      return this;
    }

    /**
     * @return {@link #processNote} (A note that describes or explains the processing in a human readable form.)
     */
    public List<NotesComponent> getProcessNote() { 
      if (this.processNote == null)
        this.processNote = new ArrayList<NotesComponent>();
      return this.processNote;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PaymentReconciliation setProcessNote(List<NotesComponent> theProcessNote) { 
      this.processNote = theProcessNote;
      return this;
    }

    public boolean hasProcessNote() { 
      if (this.processNote == null)
        return false;
      for (NotesComponent item : this.processNote)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public NotesComponent addProcessNote() { //3
      NotesComponent t = new NotesComponent();
      if (this.processNote == null)
        this.processNote = new ArrayList<NotesComponent>();
      this.processNote.add(t);
      return t;
    }

    public PaymentReconciliation addProcessNote(NotesComponent t) { //3
      if (t == null)
        return this;
      if (this.processNote == null)
        this.processNote = new ArrayList<NotesComponent>();
      this.processNote.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #processNote}, creating it if it does not already exist {3}
     */
    public NotesComponent getProcessNoteFirstRep() { 
      if (getProcessNote().isEmpty()) {
        addProcessNote();
      }
      return getProcessNote().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "A unique identifier assigned to this payment reconciliation.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("type", "CodeableConcept", "Code to indicate the nature of the payment such as payment, adjustment.", 0, 1, type));
        children.add(new Property("status", "code", "The status of the resource instance.", 0, 1, status));
        children.add(new Property("kind", "CodeableConcept", "The workflow or activity which gave rise to or during which the payment ocurred such as a kiosk, deposit on account, periodic payment etc.", 0, 1, kind));
        children.add(new Property("period", "Period", "The period of time for which payments have been gathered into this bulk payment for settlement.", 0, 1, period));
        children.add(new Property("created", "dateTime", "The date when the resource was created.", 0, 1, created));
        children.add(new Property("enterer", "Reference(Practitioner|PractitionerRole|Organization)", "Payment enterer if not the actual payment issuer.", 0, 1, enterer));
        children.add(new Property("issuerType", "CodeableConcept", "The type of the source such as patient or insurance.", 0, 1, issuerType));
        children.add(new Property("paymentIssuer", "Reference(Organization|Patient|RelatedPerson)", "The party who generated the payment.", 0, 1, paymentIssuer));
        children.add(new Property("request", "Reference(Task)", "Original request resource reference.", 0, 1, request));
        children.add(new Property("requestor", "Reference(Practitioner|PractitionerRole|Organization)", "The practitioner who is responsible for the services rendered to the patient.", 0, 1, requestor));
        children.add(new Property("outcome", "code", "The outcome of a request for a reconciliation.", 0, 1, outcome));
        children.add(new Property("disposition", "string", "A human readable description of the status of the request for the reconciliation.", 0, 1, disposition));
        children.add(new Property("date", "date", "The date of payment as indicated on the financial instrument.", 0, 1, date));
        children.add(new Property("location", "Reference(Location)", "The location of the site or device for electronic transfers or physical location for cash payments.", 0, 1, location));
        children.add(new Property("method", "CodeableConcept", "The means of payment such as check, card cash, or electronic funds transfer.", 0, 1, method));
        children.add(new Property("cardBrand", "string", "The card brand such as debit, Visa, Amex etc. used if a card is the method of payment.", 0, 1, cardBrand));
        children.add(new Property("accountNumber", "string", "A portion of the account number, often the last 4 digits, used for verification not charging purposes.", 0, 1, accountNumber));
        children.add(new Property("expirationDate", "date", "The year and month (YYYY-MM) when the instrument, typically card, expires.", 0, 1, expirationDate));
        children.add(new Property("processor", "string", "The name of the card processor, etf processor, bank for checks.", 0, 1, processor));
        children.add(new Property("referenceNumber", "string", "The check number, eft reference, car processor reference.", 0, 1, referenceNumber));
        children.add(new Property("authorization", "string", "An alphanumeric issued by the processor to confirm the successful issuance of payment.", 0, 1, authorization));
        children.add(new Property("tenderedAmount", "Money", "The amount offered by the issuer, typically applies to cash when the issuer provides an amount in bank note denominations equal to or excess of the amount actually being paid.", 0, 1, tenderedAmount));
        children.add(new Property("returnedAmount", "Money", "The amount returned by the receiver which is excess to the amount payable, often referred to as 'change'.", 0, 1, returnedAmount));
        children.add(new Property("amount", "Money", "Total payment amount as indicated on the financial instrument.", 0, 1, amount));
        children.add(new Property("paymentIdentifier", "Identifier", "Issuer's unique identifier for the payment instrument.", 0, 1, paymentIdentifier));
        children.add(new Property("allocation", "", "Distribution of the payment amount for a previously acknowledged payable.", 0, java.lang.Integer.MAX_VALUE, allocation));
        children.add(new Property("formCode", "CodeableConcept", "A code for the form to be used for printing the content.", 0, 1, formCode));
        children.add(new Property("processNote", "", "A note that describes or explains the processing in a human readable form.", 0, java.lang.Integer.MAX_VALUE, processNote));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A unique identifier assigned to this payment reconciliation.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Code to indicate the nature of the payment such as payment, adjustment.", 0, 1, type);
        case -892481550: /*status*/  return new Property("status", "code", "The status of the resource instance.", 0, 1, status);
        case 3292052: /*kind*/  return new Property("kind", "CodeableConcept", "The workflow or activity which gave rise to or during which the payment ocurred such as a kiosk, deposit on account, periodic payment etc.", 0, 1, kind);
        case -991726143: /*period*/  return new Property("period", "Period", "The period of time for which payments have been gathered into this bulk payment for settlement.", 0, 1, period);
        case 1028554472: /*created*/  return new Property("created", "dateTime", "The date when the resource was created.", 0, 1, created);
        case -1591951995: /*enterer*/  return new Property("enterer", "Reference(Practitioner|PractitionerRole|Organization)", "Payment enterer if not the actual payment issuer.", 0, 1, enterer);
        case 1459974547: /*issuerType*/  return new Property("issuerType", "CodeableConcept", "The type of the source such as patient or insurance.", 0, 1, issuerType);
        case 1144026207: /*paymentIssuer*/  return new Property("paymentIssuer", "Reference(Organization|Patient|RelatedPerson)", "The party who generated the payment.", 0, 1, paymentIssuer);
        case 1095692943: /*request*/  return new Property("request", "Reference(Task)", "Original request resource reference.", 0, 1, request);
        case 693934258: /*requestor*/  return new Property("requestor", "Reference(Practitioner|PractitionerRole|Organization)", "The practitioner who is responsible for the services rendered to the patient.", 0, 1, requestor);
        case -1106507950: /*outcome*/  return new Property("outcome", "code", "The outcome of a request for a reconciliation.", 0, 1, outcome);
        case 583380919: /*disposition*/  return new Property("disposition", "string", "A human readable description of the status of the request for the reconciliation.", 0, 1, disposition);
        case 3076014: /*date*/  return new Property("date", "date", "The date of payment as indicated on the financial instrument.", 0, 1, date);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The location of the site or device for electronic transfers or physical location for cash payments.", 0, 1, location);
        case -1077554975: /*method*/  return new Property("method", "CodeableConcept", "The means of payment such as check, card cash, or electronic funds transfer.", 0, 1, method);
        case -271889833: /*cardBrand*/  return new Property("cardBrand", "string", "The card brand such as debit, Visa, Amex etc. used if a card is the method of payment.", 0, 1, cardBrand);
        case -1011205162: /*accountNumber*/  return new Property("accountNumber", "string", "A portion of the account number, often the last 4 digits, used for verification not charging purposes.", 0, 1, accountNumber);
        case -668811523: /*expirationDate*/  return new Property("expirationDate", "date", "The year and month (YYYY-MM) when the instrument, typically card, expires.", 0, 1, expirationDate);
        case -1094759278: /*processor*/  return new Property("processor", "string", "The name of the card processor, etf processor, bank for checks.", 0, 1, processor);
        case 744563316: /*referenceNumber*/  return new Property("referenceNumber", "string", "The check number, eft reference, car processor reference.", 0, 1, referenceNumber);
        case -1385570183: /*authorization*/  return new Property("authorization", "string", "An alphanumeric issued by the processor to confirm the successful issuance of payment.", 0, 1, authorization);
        case 1815344299: /*tenderedAmount*/  return new Property("tenderedAmount", "Money", "The amount offered by the issuer, typically applies to cash when the issuer provides an amount in bank note denominations equal to or excess of the amount actually being paid.", 0, 1, tenderedAmount);
        case -797236473: /*returnedAmount*/  return new Property("returnedAmount", "Money", "The amount returned by the receiver which is excess to the amount payable, often referred to as 'change'.", 0, 1, returnedAmount);
        case -1413853096: /*amount*/  return new Property("amount", "Money", "Total payment amount as indicated on the financial instrument.", 0, 1, amount);
        case 1555852111: /*paymentIdentifier*/  return new Property("paymentIdentifier", "Identifier", "Issuer's unique identifier for the payment instrument.", 0, 1, paymentIdentifier);
        case -1912450848: /*allocation*/  return new Property("allocation", "", "Distribution of the payment amount for a previously acknowledged payable.", 0, java.lang.Integer.MAX_VALUE, allocation);
        case 473181393: /*formCode*/  return new Property("formCode", "CodeableConcept", "A code for the form to be used for printing the content.", 0, 1, formCode);
        case 202339073: /*processNote*/  return new Property("processNote", "", "A note that describes or explains the processing in a human readable form.", 0, java.lang.Integer.MAX_VALUE, processNote);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<FinancialResourceStatusCodes>
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // CodeableConcept
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Period
        case 1028554472: /*created*/ return this.created == null ? new Base[0] : new Base[] {this.created}; // DateTimeType
        case -1591951995: /*enterer*/ return this.enterer == null ? new Base[0] : new Base[] {this.enterer}; // Reference
        case 1459974547: /*issuerType*/ return this.issuerType == null ? new Base[0] : new Base[] {this.issuerType}; // CodeableConcept
        case 1144026207: /*paymentIssuer*/ return this.paymentIssuer == null ? new Base[0] : new Base[] {this.paymentIssuer}; // Reference
        case 1095692943: /*request*/ return this.request == null ? new Base[0] : new Base[] {this.request}; // Reference
        case 693934258: /*requestor*/ return this.requestor == null ? new Base[0] : new Base[] {this.requestor}; // Reference
        case -1106507950: /*outcome*/ return this.outcome == null ? new Base[0] : new Base[] {this.outcome}; // Enumeration<PaymentOutcome>
        case 583380919: /*disposition*/ return this.disposition == null ? new Base[0] : new Base[] {this.disposition}; // StringType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateType
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -1077554975: /*method*/ return this.method == null ? new Base[0] : new Base[] {this.method}; // CodeableConcept
        case -271889833: /*cardBrand*/ return this.cardBrand == null ? new Base[0] : new Base[] {this.cardBrand}; // StringType
        case -1011205162: /*accountNumber*/ return this.accountNumber == null ? new Base[0] : new Base[] {this.accountNumber}; // StringType
        case -668811523: /*expirationDate*/ return this.expirationDate == null ? new Base[0] : new Base[] {this.expirationDate}; // DateType
        case -1094759278: /*processor*/ return this.processor == null ? new Base[0] : new Base[] {this.processor}; // StringType
        case 744563316: /*referenceNumber*/ return this.referenceNumber == null ? new Base[0] : new Base[] {this.referenceNumber}; // StringType
        case -1385570183: /*authorization*/ return this.authorization == null ? new Base[0] : new Base[] {this.authorization}; // StringType
        case 1815344299: /*tenderedAmount*/ return this.tenderedAmount == null ? new Base[0] : new Base[] {this.tenderedAmount}; // Money
        case -797236473: /*returnedAmount*/ return this.returnedAmount == null ? new Base[0] : new Base[] {this.returnedAmount}; // Money
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Money
        case 1555852111: /*paymentIdentifier*/ return this.paymentIdentifier == null ? new Base[0] : new Base[] {this.paymentIdentifier}; // Identifier
        case -1912450848: /*allocation*/ return this.allocation == null ? new Base[0] : this.allocation.toArray(new Base[this.allocation.size()]); // PaymentReconciliationAllocationComponent
        case 473181393: /*formCode*/ return this.formCode == null ? new Base[0] : new Base[] {this.formCode}; // CodeableConcept
        case 202339073: /*processNote*/ return this.processNote == null ? new Base[0] : this.processNote.toArray(new Base[this.processNote.size()]); // NotesComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -892481550: // status
          value = new FinancialResourceStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FinancialResourceStatusCodes>
          return value;
        case 3292052: // kind
          this.kind = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 1028554472: // created
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1591951995: // enterer
          this.enterer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1459974547: // issuerType
          this.issuerType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1144026207: // paymentIssuer
          this.paymentIssuer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1095692943: // request
          this.request = TypeConvertor.castToReference(value); // Reference
          return value;
        case 693934258: // requestor
          this.requestor = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1106507950: // outcome
          value = new PaymentOutcomeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.outcome = (Enumeration) value; // Enumeration<PaymentOutcome>
          return value;
        case 583380919: // disposition
          this.disposition = TypeConvertor.castToString(value); // StringType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDate(value); // DateType
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1077554975: // method
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -271889833: // cardBrand
          this.cardBrand = TypeConvertor.castToString(value); // StringType
          return value;
        case -1011205162: // accountNumber
          this.accountNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case -668811523: // expirationDate
          this.expirationDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1094759278: // processor
          this.processor = TypeConvertor.castToString(value); // StringType
          return value;
        case 744563316: // referenceNumber
          this.referenceNumber = TypeConvertor.castToString(value); // StringType
          return value;
        case -1385570183: // authorization
          this.authorization = TypeConvertor.castToString(value); // StringType
          return value;
        case 1815344299: // tenderedAmount
          this.tenderedAmount = TypeConvertor.castToMoney(value); // Money
          return value;
        case -797236473: // returnedAmount
          this.returnedAmount = TypeConvertor.castToMoney(value); // Money
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToMoney(value); // Money
          return value;
        case 1555852111: // paymentIdentifier
          this.paymentIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -1912450848: // allocation
          this.getAllocation().add((PaymentReconciliationAllocationComponent) value); // PaymentReconciliationAllocationComponent
          return value;
        case 473181393: // formCode
          this.formCode = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 202339073: // processNote
          this.getProcessNote().add((NotesComponent) value); // NotesComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("status")) {
          value = new FinancialResourceStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FinancialResourceStatusCodes>
        } else if (name.equals("kind")) {
          this.kind = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("created")) {
          this.created = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("enterer")) {
          this.enterer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("issuerType")) {
          this.issuerType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("paymentIssuer")) {
          this.paymentIssuer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("request")) {
          this.request = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("requestor")) {
          this.requestor = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("outcome")) {
          value = new PaymentOutcomeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.outcome = (Enumeration) value; // Enumeration<PaymentOutcome>
        } else if (name.equals("disposition")) {
          this.disposition = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("method")) {
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("cardBrand")) {
          this.cardBrand = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("accountNumber")) {
          this.accountNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("expirationDate")) {
          this.expirationDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("processor")) {
          this.processor = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("referenceNumber")) {
          this.referenceNumber = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("authorization")) {
          this.authorization = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("tenderedAmount")) {
          this.tenderedAmount = TypeConvertor.castToMoney(value); // Money
        } else if (name.equals("returnedAmount")) {
          this.returnedAmount = TypeConvertor.castToMoney(value); // Money
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToMoney(value); // Money
        } else if (name.equals("paymentIdentifier")) {
          this.paymentIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("allocation")) {
          this.getAllocation().add((PaymentReconciliationAllocationComponent) value);
        } else if (name.equals("formCode")) {
          this.formCode = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("processNote")) {
          this.getProcessNote().add((NotesComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("status")) {
          value = new FinancialResourceStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FinancialResourceStatusCodes>
        } else if (name.equals("kind")) {
          this.kind = null;
        } else if (name.equals("period")) {
          this.period = null;
        } else if (name.equals("created")) {
          this.created = null;
        } else if (name.equals("enterer")) {
          this.enterer = null;
        } else if (name.equals("issuerType")) {
          this.issuerType = null;
        } else if (name.equals("paymentIssuer")) {
          this.paymentIssuer = null;
        } else if (name.equals("request")) {
          this.request = null;
        } else if (name.equals("requestor")) {
          this.requestor = null;
        } else if (name.equals("outcome")) {
          value = new PaymentOutcomeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.outcome = (Enumeration) value; // Enumeration<PaymentOutcome>
        } else if (name.equals("disposition")) {
          this.disposition = null;
        } else if (name.equals("date")) {
          this.date = null;
        } else if (name.equals("location")) {
          this.location = null;
        } else if (name.equals("method")) {
          this.method = null;
        } else if (name.equals("cardBrand")) {
          this.cardBrand = null;
        } else if (name.equals("accountNumber")) {
          this.accountNumber = null;
        } else if (name.equals("expirationDate")) {
          this.expirationDate = null;
        } else if (name.equals("processor")) {
          this.processor = null;
        } else if (name.equals("referenceNumber")) {
          this.referenceNumber = null;
        } else if (name.equals("authorization")) {
          this.authorization = null;
        } else if (name.equals("tenderedAmount")) {
          this.tenderedAmount = null;
        } else if (name.equals("returnedAmount")) {
          this.returnedAmount = null;
        } else if (name.equals("amount")) {
          this.amount = null;
        } else if (name.equals("paymentIdentifier")) {
          this.paymentIdentifier = null;
        } else if (name.equals("allocation")) {
          this.getAllocation().remove((PaymentReconciliationAllocationComponent) value);
        } else if (name.equals("formCode")) {
          this.formCode = null;
        } else if (name.equals("processNote")) {
          this.getProcessNote().remove((NotesComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3575610:  return getType();
        case -892481550:  return getStatusElement();
        case 3292052:  return getKind();
        case -991726143:  return getPeriod();
        case 1028554472:  return getCreatedElement();
        case -1591951995:  return getEnterer();
        case 1459974547:  return getIssuerType();
        case 1144026207:  return getPaymentIssuer();
        case 1095692943:  return getRequest();
        case 693934258:  return getRequestor();
        case -1106507950:  return getOutcomeElement();
        case 583380919:  return getDispositionElement();
        case 3076014:  return getDateElement();
        case 1901043637:  return getLocation();
        case -1077554975:  return getMethod();
        case -271889833:  return getCardBrandElement();
        case -1011205162:  return getAccountNumberElement();
        case -668811523:  return getExpirationDateElement();
        case -1094759278:  return getProcessorElement();
        case 744563316:  return getReferenceNumberElement();
        case -1385570183:  return getAuthorizationElement();
        case 1815344299:  return getTenderedAmount();
        case -797236473:  return getReturnedAmount();
        case -1413853096:  return getAmount();
        case 1555852111:  return getPaymentIdentifier();
        case -1912450848:  return addAllocation(); 
        case 473181393:  return getFormCode();
        case 202339073:  return addProcessNote(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 3292052: /*kind*/ return new String[] {"CodeableConcept"};
        case -991726143: /*period*/ return new String[] {"Period"};
        case 1028554472: /*created*/ return new String[] {"dateTime"};
        case -1591951995: /*enterer*/ return new String[] {"Reference"};
        case 1459974547: /*issuerType*/ return new String[] {"CodeableConcept"};
        case 1144026207: /*paymentIssuer*/ return new String[] {"Reference"};
        case 1095692943: /*request*/ return new String[] {"Reference"};
        case 693934258: /*requestor*/ return new String[] {"Reference"};
        case -1106507950: /*outcome*/ return new String[] {"code"};
        case 583380919: /*disposition*/ return new String[] {"string"};
        case 3076014: /*date*/ return new String[] {"date"};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -1077554975: /*method*/ return new String[] {"CodeableConcept"};
        case -271889833: /*cardBrand*/ return new String[] {"string"};
        case -1011205162: /*accountNumber*/ return new String[] {"string"};
        case -668811523: /*expirationDate*/ return new String[] {"date"};
        case -1094759278: /*processor*/ return new String[] {"string"};
        case 744563316: /*referenceNumber*/ return new String[] {"string"};
        case -1385570183: /*authorization*/ return new String[] {"string"};
        case 1815344299: /*tenderedAmount*/ return new String[] {"Money"};
        case -797236473: /*returnedAmount*/ return new String[] {"Money"};
        case -1413853096: /*amount*/ return new String[] {"Money"};
        case 1555852111: /*paymentIdentifier*/ return new String[] {"Identifier"};
        case -1912450848: /*allocation*/ return new String[] {};
        case 473181393: /*formCode*/ return new String[] {"CodeableConcept"};
        case 202339073: /*processNote*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.status");
        }
        else if (name.equals("kind")) {
          this.kind = new CodeableConcept();
          return this.kind;
        }
        else if (name.equals("period")) {
          this.period = new Period();
          return this.period;
        }
        else if (name.equals("created")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.created");
        }
        else if (name.equals("enterer")) {
          this.enterer = new Reference();
          return this.enterer;
        }
        else if (name.equals("issuerType")) {
          this.issuerType = new CodeableConcept();
          return this.issuerType;
        }
        else if (name.equals("paymentIssuer")) {
          this.paymentIssuer = new Reference();
          return this.paymentIssuer;
        }
        else if (name.equals("request")) {
          this.request = new Reference();
          return this.request;
        }
        else if (name.equals("requestor")) {
          this.requestor = new Reference();
          return this.requestor;
        }
        else if (name.equals("outcome")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.outcome");
        }
        else if (name.equals("disposition")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.disposition");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.date");
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("method")) {
          this.method = new CodeableConcept();
          return this.method;
        }
        else if (name.equals("cardBrand")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.cardBrand");
        }
        else if (name.equals("accountNumber")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.accountNumber");
        }
        else if (name.equals("expirationDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.expirationDate");
        }
        else if (name.equals("processor")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.processor");
        }
        else if (name.equals("referenceNumber")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.referenceNumber");
        }
        else if (name.equals("authorization")) {
          throw new FHIRException("Cannot call addChild on a singleton property PaymentReconciliation.authorization");
        }
        else if (name.equals("tenderedAmount")) {
          this.tenderedAmount = new Money();
          return this.tenderedAmount;
        }
        else if (name.equals("returnedAmount")) {
          this.returnedAmount = new Money();
          return this.returnedAmount;
        }
        else if (name.equals("amount")) {
          this.amount = new Money();
          return this.amount;
        }
        else if (name.equals("paymentIdentifier")) {
          this.paymentIdentifier = new Identifier();
          return this.paymentIdentifier;
        }
        else if (name.equals("allocation")) {
          return addAllocation();
        }
        else if (name.equals("formCode")) {
          this.formCode = new CodeableConcept();
          return this.formCode;
        }
        else if (name.equals("processNote")) {
          return addProcessNote();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PaymentReconciliation";

  }

      public PaymentReconciliation copy() {
        PaymentReconciliation dst = new PaymentReconciliation();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PaymentReconciliation dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.status = status == null ? null : status.copy();
        dst.kind = kind == null ? null : kind.copy();
        dst.period = period == null ? null : period.copy();
        dst.created = created == null ? null : created.copy();
        dst.enterer = enterer == null ? null : enterer.copy();
        dst.issuerType = issuerType == null ? null : issuerType.copy();
        dst.paymentIssuer = paymentIssuer == null ? null : paymentIssuer.copy();
        dst.request = request == null ? null : request.copy();
        dst.requestor = requestor == null ? null : requestor.copy();
        dst.outcome = outcome == null ? null : outcome.copy();
        dst.disposition = disposition == null ? null : disposition.copy();
        dst.date = date == null ? null : date.copy();
        dst.location = location == null ? null : location.copy();
        dst.method = method == null ? null : method.copy();
        dst.cardBrand = cardBrand == null ? null : cardBrand.copy();
        dst.accountNumber = accountNumber == null ? null : accountNumber.copy();
        dst.expirationDate = expirationDate == null ? null : expirationDate.copy();
        dst.processor = processor == null ? null : processor.copy();
        dst.referenceNumber = referenceNumber == null ? null : referenceNumber.copy();
        dst.authorization = authorization == null ? null : authorization.copy();
        dst.tenderedAmount = tenderedAmount == null ? null : tenderedAmount.copy();
        dst.returnedAmount = returnedAmount == null ? null : returnedAmount.copy();
        dst.amount = amount == null ? null : amount.copy();
        dst.paymentIdentifier = paymentIdentifier == null ? null : paymentIdentifier.copy();
        if (allocation != null) {
          dst.allocation = new ArrayList<PaymentReconciliationAllocationComponent>();
          for (PaymentReconciliationAllocationComponent i : allocation)
            dst.allocation.add(i.copy());
        };
        dst.formCode = formCode == null ? null : formCode.copy();
        if (processNote != null) {
          dst.processNote = new ArrayList<NotesComponent>();
          for (NotesComponent i : processNote)
            dst.processNote.add(i.copy());
        };
      }

      protected PaymentReconciliation typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PaymentReconciliation))
          return false;
        PaymentReconciliation o = (PaymentReconciliation) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(type, o.type, true) && compareDeep(status, o.status, true)
           && compareDeep(kind, o.kind, true) && compareDeep(period, o.period, true) && compareDeep(created, o.created, true)
           && compareDeep(enterer, o.enterer, true) && compareDeep(issuerType, o.issuerType, true) && compareDeep(paymentIssuer, o.paymentIssuer, true)
           && compareDeep(request, o.request, true) && compareDeep(requestor, o.requestor, true) && compareDeep(outcome, o.outcome, true)
           && compareDeep(disposition, o.disposition, true) && compareDeep(date, o.date, true) && compareDeep(location, o.location, true)
           && compareDeep(method, o.method, true) && compareDeep(cardBrand, o.cardBrand, true) && compareDeep(accountNumber, o.accountNumber, true)
           && compareDeep(expirationDate, o.expirationDate, true) && compareDeep(processor, o.processor, true)
           && compareDeep(referenceNumber, o.referenceNumber, true) && compareDeep(authorization, o.authorization, true)
           && compareDeep(tenderedAmount, o.tenderedAmount, true) && compareDeep(returnedAmount, o.returnedAmount, true)
           && compareDeep(amount, o.amount, true) && compareDeep(paymentIdentifier, o.paymentIdentifier, true)
           && compareDeep(allocation, o.allocation, true) && compareDeep(formCode, o.formCode, true) && compareDeep(processNote, o.processNote, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PaymentReconciliation))
          return false;
        PaymentReconciliation o = (PaymentReconciliation) other_;
        return compareValues(status, o.status, true) && compareValues(created, o.created, true) && compareValues(outcome, o.outcome, true)
           && compareValues(disposition, o.disposition, true) && compareValues(date, o.date, true) && compareValues(cardBrand, o.cardBrand, true)
           && compareValues(accountNumber, o.accountNumber, true) && compareValues(expirationDate, o.expirationDate, true)
           && compareValues(processor, o.processor, true) && compareValues(referenceNumber, o.referenceNumber, true)
           && compareValues(authorization, o.authorization, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, type, status
          , kind, period, created, enterer, issuerType, paymentIssuer, request, requestor
          , outcome, disposition, date, location, method, cardBrand, accountNumber, expirationDate
          , processor, referenceNumber, authorization, tenderedAmount, returnedAmount, amount
          , paymentIdentifier, allocation, formCode, processNote);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.PaymentReconciliation;
   }

 /**
   * Search parameter: <b>allocation-account</b>
   * <p>
   * Description: <b>The account to which payment or adjustment was applied.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.allocation.account</b><br>
   * </p>
   */
  @SearchParamDefinition(name="allocation-account", path="PaymentReconciliation.allocation.account", description="The account to which payment or adjustment was applied.", type="reference", target={Account.class } )
  public static final String SP_ALLOCATION_ACCOUNT = "allocation-account";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>allocation-account</b>
   * <p>
   * Description: <b>The account to which payment or adjustment was applied.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.allocation.account</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ALLOCATION_ACCOUNT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ALLOCATION_ACCOUNT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PaymentReconciliation:allocation-account</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ALLOCATION_ACCOUNT = new ca.uhn.fhir.model.api.Include("PaymentReconciliation:allocation-account").toLocked();

 /**
   * Search parameter: <b>allocation-encounter</b>
   * <p>
   * Description: <b>The encounter to which payment or adjustment was applied.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.allocation.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="allocation-encounter", path="PaymentReconciliation.allocation.encounter", description="The encounter to which payment or adjustment was applied.", type="reference", target={Encounter.class } )
  public static final String SP_ALLOCATION_ENCOUNTER = "allocation-encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>allocation-encounter</b>
   * <p>
   * Description: <b>The encounter to which payment or adjustment was applied.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.allocation.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ALLOCATION_ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ALLOCATION_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PaymentReconciliation:allocation-encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ALLOCATION_ENCOUNTER = new ca.uhn.fhir.model.api.Include("PaymentReconciliation:allocation-encounter").toLocked();

 /**
   * Search parameter: <b>created</b>
   * <p>
   * Description: <b>The creation date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>PaymentReconciliation.created</b><br>
   * </p>
   */
  @SearchParamDefinition(name="created", path="PaymentReconciliation.created", description="The creation date", type="date" )
  public static final String SP_CREATED = "created";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>created</b>
   * <p>
   * Description: <b>The creation date</b><br>
   * Type: <b>date</b><br>
   * Path: <b>PaymentReconciliation.created</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam CREATED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_CREATED);

 /**
   * Search parameter: <b>disposition</b>
   * <p>
   * Description: <b>The contents of the disposition message</b><br>
   * Type: <b>string</b><br>
   * Path: <b>PaymentReconciliation.disposition</b><br>
   * </p>
   */
  @SearchParamDefinition(name="disposition", path="PaymentReconciliation.disposition", description="The contents of the disposition message", type="string" )
  public static final String SP_DISPOSITION = "disposition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>disposition</b>
   * <p>
   * Description: <b>The contents of the disposition message</b><br>
   * Type: <b>string</b><br>
   * Path: <b>PaymentReconciliation.disposition</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DISPOSITION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DISPOSITION);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The business identifier of the ExplanationOfBenefit</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PaymentReconciliation.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="PaymentReconciliation.identifier", description="The business identifier of the ExplanationOfBenefit", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The business identifier of the ExplanationOfBenefit</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PaymentReconciliation.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>outcome</b>
   * <p>
   * Description: <b>The processing outcome</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PaymentReconciliation.outcome</b><br>
   * </p>
   */
  @SearchParamDefinition(name="outcome", path="PaymentReconciliation.outcome", description="The processing outcome", type="token" )
  public static final String SP_OUTCOME = "outcome";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>outcome</b>
   * <p>
   * Description: <b>The processing outcome</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PaymentReconciliation.outcome</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam OUTCOME = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_OUTCOME);

 /**
   * Search parameter: <b>payment-issuer</b>
   * <p>
   * Description: <b>The organization which generated this resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.paymentIssuer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="payment-issuer", path="PaymentReconciliation.paymentIssuer", description="The organization which generated this resource", type="reference", target={Organization.class, Patient.class, RelatedPerson.class } )
  public static final String SP_PAYMENT_ISSUER = "payment-issuer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>payment-issuer</b>
   * <p>
   * Description: <b>The organization which generated this resource</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.paymentIssuer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PAYMENT_ISSUER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PAYMENT_ISSUER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PaymentReconciliation:payment-issuer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PAYMENT_ISSUER = new ca.uhn.fhir.model.api.Include("PaymentReconciliation:payment-issuer").toLocked();

 /**
   * Search parameter: <b>request</b>
   * <p>
   * Description: <b>The reference to the claim</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.request</b><br>
   * </p>
   */
  @SearchParamDefinition(name="request", path="PaymentReconciliation.request", description="The reference to the claim", type="reference", target={Task.class } )
  public static final String SP_REQUEST = "request";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>request</b>
   * <p>
   * Description: <b>The reference to the claim</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.request</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUEST = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REQUEST);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PaymentReconciliation:request</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUEST = new ca.uhn.fhir.model.api.Include("PaymentReconciliation:request").toLocked();

 /**
   * Search parameter: <b>requestor</b>
   * <p>
   * Description: <b>The reference to the provider who submitted the claim</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.requestor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="requestor", path="PaymentReconciliation.requestor", description="The reference to the provider who submitted the claim", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Organization.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_REQUESTOR = "requestor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>requestor</b>
   * <p>
   * Description: <b>The reference to the provider who submitted the claim</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PaymentReconciliation.requestor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam REQUESTOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_REQUESTOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PaymentReconciliation:requestor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_REQUESTOR = new ca.uhn.fhir.model.api.Include("PaymentReconciliation:requestor").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the payment reconciliation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PaymentReconciliation.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="PaymentReconciliation.status", description="The status of the payment reconciliation", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the payment reconciliation</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PaymentReconciliation.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}

