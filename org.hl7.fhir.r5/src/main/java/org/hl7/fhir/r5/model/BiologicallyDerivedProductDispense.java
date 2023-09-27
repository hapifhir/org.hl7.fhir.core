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
 * A record of dispensation of a biologically derived product.
 */
@ResourceDef(name="BiologicallyDerivedProductDispense", profile="http://hl7.org/fhir/StructureDefinition/BiologicallyDerivedProductDispense")
public class BiologicallyDerivedProductDispense extends DomainResource {

    public enum BiologicallyDerivedProductDispenseCodes {
        /**
         * The dispense process has started but not yet completed.
         */
        PREPARATION, 
        /**
         * The dispense process is in progress.
         */
        INPROGRESS, 
        /**
         * The requested product has been allocated and is ready for transport.
         */
        ALLOCATED, 
        /**
         * The dispensed product has been picked up.
         */
        ISSUED, 
        /**
         * The dispense could not be completed.
         */
        UNFULFILLED, 
        /**
         * The dispensed product was returned.
         */
        RETURNED, 
        /**
         * The dispense was entered in error and therefore nullified.
         */
        ENTEREDINERROR, 
        /**
         * The authoring system does not know which of the status values applies for this dispense. Note: this concept is not to be used for other - one of the listed statuses is presumed to apply, it's just not known which one.
         */
        UNKNOWN, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static BiologicallyDerivedProductDispenseCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return PREPARATION;
        if ("in-progress".equals(codeString))
          return INPROGRESS;
        if ("allocated".equals(codeString))
          return ALLOCATED;
        if ("issued".equals(codeString))
          return ISSUED;
        if ("unfulfilled".equals(codeString))
          return UNFULFILLED;
        if ("returned".equals(codeString))
          return RETURNED;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return UNKNOWN;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown BiologicallyDerivedProductDispenseCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PREPARATION: return "preparation";
            case INPROGRESS: return "in-progress";
            case ALLOCATED: return "allocated";
            case ISSUED: return "issued";
            case UNFULFILLED: return "unfulfilled";
            case RETURNED: return "returned";
            case ENTEREDINERROR: return "entered-in-error";
            case UNKNOWN: return "unknown";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PREPARATION: return "http://hl7.org/fhir/biologicallyderivedproductdispense-status";
            case INPROGRESS: return "http://hl7.org/fhir/biologicallyderivedproductdispense-status";
            case ALLOCATED: return "http://hl7.org/fhir/biologicallyderivedproductdispense-status";
            case ISSUED: return "http://hl7.org/fhir/biologicallyderivedproductdispense-status";
            case UNFULFILLED: return "http://hl7.org/fhir/biologicallyderivedproductdispense-status";
            case RETURNED: return "http://hl7.org/fhir/biologicallyderivedproductdispense-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/biologicallyderivedproductdispense-status";
            case UNKNOWN: return "http://hl7.org/fhir/biologicallyderivedproductdispense-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PREPARATION: return "The dispense process has started but not yet completed.";
            case INPROGRESS: return "The dispense process is in progress.";
            case ALLOCATED: return "The requested product has been allocated and is ready for transport.";
            case ISSUED: return "The dispensed product has been picked up.";
            case UNFULFILLED: return "The dispense could not be completed.";
            case RETURNED: return "The dispensed product was returned.";
            case ENTEREDINERROR: return "The dispense was entered in error and therefore nullified.";
            case UNKNOWN: return "The authoring system does not know which of the status values applies for this dispense. Note: this concept is not to be used for other - one of the listed statuses is presumed to apply, it's just not known which one.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PREPARATION: return "Preparation";
            case INPROGRESS: return "In Progress";
            case ALLOCATED: return "Allocated";
            case ISSUED: return "Issued";
            case UNFULFILLED: return "Unfulfilled";
            case RETURNED: return "Returned";
            case ENTEREDINERROR: return "Entered in Error";
            case UNKNOWN: return "Unknown";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class BiologicallyDerivedProductDispenseCodesEnumFactory implements EnumFactory<BiologicallyDerivedProductDispenseCodes> {
    public BiologicallyDerivedProductDispenseCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preparation".equals(codeString))
          return BiologicallyDerivedProductDispenseCodes.PREPARATION;
        if ("in-progress".equals(codeString))
          return BiologicallyDerivedProductDispenseCodes.INPROGRESS;
        if ("allocated".equals(codeString))
          return BiologicallyDerivedProductDispenseCodes.ALLOCATED;
        if ("issued".equals(codeString))
          return BiologicallyDerivedProductDispenseCodes.ISSUED;
        if ("unfulfilled".equals(codeString))
          return BiologicallyDerivedProductDispenseCodes.UNFULFILLED;
        if ("returned".equals(codeString))
          return BiologicallyDerivedProductDispenseCodes.RETURNED;
        if ("entered-in-error".equals(codeString))
          return BiologicallyDerivedProductDispenseCodes.ENTEREDINERROR;
        if ("unknown".equals(codeString))
          return BiologicallyDerivedProductDispenseCodes.UNKNOWN;
        throw new IllegalArgumentException("Unknown BiologicallyDerivedProductDispenseCodes code '"+codeString+"'");
        }
        public Enumeration<BiologicallyDerivedProductDispenseCodes> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.NULL, code);
        if ("preparation".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.PREPARATION, code);
        if ("in-progress".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.INPROGRESS, code);
        if ("allocated".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.ALLOCATED, code);
        if ("issued".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.ISSUED, code);
        if ("unfulfilled".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.UNFULFILLED, code);
        if ("returned".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.RETURNED, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.ENTEREDINERROR, code);
        if ("unknown".equals(codeString))
          return new Enumeration<BiologicallyDerivedProductDispenseCodes>(this, BiologicallyDerivedProductDispenseCodes.UNKNOWN, code);
        throw new FHIRException("Unknown BiologicallyDerivedProductDispenseCodes code '"+codeString+"'");
        }
    public String toCode(BiologicallyDerivedProductDispenseCodes code) {
      if (code == BiologicallyDerivedProductDispenseCodes.PREPARATION)
        return "preparation";
      if (code == BiologicallyDerivedProductDispenseCodes.INPROGRESS)
        return "in-progress";
      if (code == BiologicallyDerivedProductDispenseCodes.ALLOCATED)
        return "allocated";
      if (code == BiologicallyDerivedProductDispenseCodes.ISSUED)
        return "issued";
      if (code == BiologicallyDerivedProductDispenseCodes.UNFULFILLED)
        return "unfulfilled";
      if (code == BiologicallyDerivedProductDispenseCodes.RETURNED)
        return "returned";
      if (code == BiologicallyDerivedProductDispenseCodes.ENTEREDINERROR)
        return "entered-in-error";
      if (code == BiologicallyDerivedProductDispenseCodes.UNKNOWN)
        return "unknown";
      return "?";
      }
    public String toSystem(BiologicallyDerivedProductDispenseCodes code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class BiologicallyDerivedProductDispensePerformerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies the function of the performer during the dispense.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Identifies the function of the performer during the dispense", formalDefinition="Identifies the function of the performer during the dispense." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/biologicallyderivedproductdispense-performer-function")
        protected CodeableConcept function;

        /**
         * Identifies the person responsible for the action.
         */
        @Child(name = "actor", type = {Practitioner.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Who performed the action", formalDefinition="Identifies the person responsible for the action." )
        protected Reference actor;

        private static final long serialVersionUID = -576943815L;

    /**
     * Constructor
     */
      public BiologicallyDerivedProductDispensePerformerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public BiologicallyDerivedProductDispensePerformerComponent(Reference actor) {
        super();
        this.setActor(actor);
      }

        /**
         * @return {@link #function} (Identifies the function of the performer during the dispense.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BiologicallyDerivedProductDispensePerformerComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Identifies the function of the performer during the dispense.)
         */
        public BiologicallyDerivedProductDispensePerformerComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (Identifies the person responsible for the action.)
         */
        public Reference getActor() { 
          if (this.actor == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create BiologicallyDerivedProductDispensePerformerComponent.actor");
            else if (Configuration.doAutoCreate())
              this.actor = new Reference(); // cc
          return this.actor;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (Identifies the person responsible for the action.)
         */
        public BiologicallyDerivedProductDispensePerformerComponent setActor(Reference value) { 
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("function", "CodeableConcept", "Identifies the function of the performer during the dispense.", 0, 1, function));
          children.add(new Property("actor", "Reference(Practitioner)", "Identifies the person responsible for the action.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Identifies the function of the performer during the dispense.", 0, 1, function);
          case 92645877: /*actor*/  return new Property("actor", "Reference(Practitioner)", "Identifies the person responsible for the action.", 0, 1, actor);
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

      public BiologicallyDerivedProductDispensePerformerComponent copy() {
        BiologicallyDerivedProductDispensePerformerComponent dst = new BiologicallyDerivedProductDispensePerformerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BiologicallyDerivedProductDispensePerformerComponent dst) {
        super.copyValues(dst);
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProductDispensePerformerComponent))
          return false;
        BiologicallyDerivedProductDispensePerformerComponent o = (BiologicallyDerivedProductDispensePerformerComponent) other_;
        return compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProductDispensePerformerComponent))
          return false;
        BiologicallyDerivedProductDispensePerformerComponent o = (BiologicallyDerivedProductDispensePerformerComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(function, actor);
      }

  public String fhirType() {
    return "BiologicallyDerivedProductDispense.performer";

  }

  }

    /**
     * Unique instance identifiers assigned to a biologically derived product dispense. Note: This is a business identifier, not a resource identifier.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for this dispense", formalDefinition="Unique instance identifiers assigned to a biologically derived product dispense. Note: This is a business identifier, not a resource identifier." )
    protected List<Identifier> identifier;

    /**
     * The order or request that the dispense is fulfilling. This is a reference to a ServiceRequest resource.
     */
    @Child(name = "basedOn", type = {ServiceRequest.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The order or request that this dispense is fulfilling", formalDefinition="The order or request that the dispense is fulfilling. This is a reference to a ServiceRequest resource." )
    protected List<Reference> basedOn;

    /**
     * A larger event of which this particular event is a component.
     */
    @Child(name = "partOf", type = {BiologicallyDerivedProductDispense.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Short description", formalDefinition="A larger event of which this particular event is a component." )
    protected List<Reference> partOf;

    /**
     * A code specifying the state of the dispense event.
     */
    @Child(name = "status", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="preparation | in-progress | allocated | issued | unfulfilled | returned | entered-in-error | unknown", formalDefinition="A code specifying the state of the dispense event." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/biologicallyderivedproductdispense-status")
    protected Enumeration<BiologicallyDerivedProductDispenseCodes> status;

    /**
     * Indicates the relationship between the donor of the biologically derived product and the intended recipient.
     */
    @Child(name = "originRelationshipType", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Relationship between the donor and intended recipient", formalDefinition="Indicates the relationship between the donor of the biologically derived product and the intended recipient." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/biologicallyderivedproductdispense-origin-relationship")
    protected CodeableConcept originRelationshipType;

    /**
     * A link to a resource identifying the biologically derived product that is being dispensed.
     */
    @Child(name = "product", type = {BiologicallyDerivedProduct.class}, order=5, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The BiologicallyDerivedProduct that is dispensed", formalDefinition="A link to a resource identifying the biologically derived product that is being dispensed." )
    protected Reference product;

    /**
     * A link to a resource representing the patient that the product is dispensed for.
     */
    @Child(name = "patient", type = {Patient.class}, order=6, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The intended recipient of the dispensed product", formalDefinition="A link to a resource representing the patient that the product is dispensed for." )
    protected Reference patient;

    /**
     * Indicates the type of matching associated with the dispense.
     */
    @Child(name = "matchStatus", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Indicates the type of matching associated with the dispense", formalDefinition="Indicates the type of matching associated with the dispense." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/biologicallyderivedproductdispense-match-status")
    protected CodeableConcept matchStatus;

    /**
     * Indicates who or what performed an action.
     */
    @Child(name = "performer", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Indicates who or what performed an action", formalDefinition="Indicates who or what performed an action." )
    protected List<BiologicallyDerivedProductDispensePerformerComponent> performer;

    /**
     * The physical location where the dispense was performed.
     */
    @Child(name = "location", type = {Location.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where the dispense occurred", formalDefinition="The physical location where the dispense was performed." )
    protected Reference location;

    /**
     * The amount of product in the dispense. Quantity will depend on the product being dispensed. Examples are: volume; cell count; concentration.
     */
    @Child(name = "quantity", type = {Quantity.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Amount dispensed", formalDefinition="The amount of product in the dispense. Quantity will depend on the product being dispensed. Examples are: volume; cell count; concentration." )
    protected Quantity quantity;

    /**
     * When the product was selected/ matched.
     */
    @Child(name = "preparedDate", type = {DateTimeType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When product was selected/matched", formalDefinition="When the product was selected/ matched." )
    protected DateTimeType preparedDate;

    /**
     * When the product was dispatched for clinical use.
     */
    @Child(name = "whenHandedOver", type = {DateTimeType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the product was dispatched", formalDefinition="When the product was dispatched for clinical use." )
    protected DateTimeType whenHandedOver;

    /**
     * Link to a resource identifying the physical location that the product was dispatched to.
     */
    @Child(name = "destination", type = {Location.class}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Where the product was dispatched to", formalDefinition="Link to a resource identifying the physical location that the product was dispatched to." )
    protected Reference destination;

    /**
     * Additional notes.
     */
    @Child(name = "note", type = {Annotation.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional notes", formalDefinition="Additional notes." )
    protected List<Annotation> note;

    /**
     * Specific instructions for use.
     */
    @Child(name = "usageInstruction", type = {StringType.class}, order=15, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Specific instructions for use", formalDefinition="Specific instructions for use." )
    protected StringType usageInstruction;

    private static final long serialVersionUID = -109945994L;

  /**
   * Constructor
   */
    public BiologicallyDerivedProductDispense() {
      super();
    }

  /**
   * Constructor
   */
    public BiologicallyDerivedProductDispense(BiologicallyDerivedProductDispenseCodes status, Reference product, Reference patient) {
      super();
      this.setStatus(status);
      this.setProduct(product);
      this.setPatient(patient);
    }

    /**
     * @return {@link #identifier} (Unique instance identifiers assigned to a biologically derived product dispense. Note: This is a business identifier, not a resource identifier.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProductDispense setIdentifier(List<Identifier> theIdentifier) { 
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

    public BiologicallyDerivedProductDispense addIdentifier(Identifier t) { //3
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
     * @return {@link #basedOn} (The order or request that the dispense is fulfilling. This is a reference to a ServiceRequest resource.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProductDispense setBasedOn(List<Reference> theBasedOn) { 
      this.basedOn = theBasedOn;
      return this;
    }

    public boolean hasBasedOn() { 
      if (this.basedOn == null)
        return false;
      for (Reference item : this.basedOn)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addBasedOn() { //3
      Reference t = new Reference();
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return t;
    }

    public BiologicallyDerivedProductDispense addBasedOn(Reference t) { //3
      if (t == null)
        return this;
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      this.basedOn.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #basedOn}, creating it if it does not already exist {3}
     */
    public Reference getBasedOnFirstRep() { 
      if (getBasedOn().isEmpty()) {
        addBasedOn();
      }
      return getBasedOn().get(0);
    }

    /**
     * @return {@link #partOf} (A larger event of which this particular event is a component.)
     */
    public List<Reference> getPartOf() { 
      if (this.partOf == null)
        this.partOf = new ArrayList<Reference>();
      return this.partOf;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProductDispense setPartOf(List<Reference> thePartOf) { 
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

    public BiologicallyDerivedProductDispense addPartOf(Reference t) { //3
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
     * @return {@link #status} (A code specifying the state of the dispense event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<BiologicallyDerivedProductDispenseCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<BiologicallyDerivedProductDispenseCodes>(new BiologicallyDerivedProductDispenseCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code specifying the state of the dispense event.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public BiologicallyDerivedProductDispense setStatusElement(Enumeration<BiologicallyDerivedProductDispenseCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code specifying the state of the dispense event.
     */
    public BiologicallyDerivedProductDispenseCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code specifying the state of the dispense event.
     */
    public BiologicallyDerivedProductDispense setStatus(BiologicallyDerivedProductDispenseCodes value) { 
        if (this.status == null)
          this.status = new Enumeration<BiologicallyDerivedProductDispenseCodes>(new BiologicallyDerivedProductDispenseCodesEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #originRelationshipType} (Indicates the relationship between the donor of the biologically derived product and the intended recipient.)
     */
    public CodeableConcept getOriginRelationshipType() { 
      if (this.originRelationshipType == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.originRelationshipType");
        else if (Configuration.doAutoCreate())
          this.originRelationshipType = new CodeableConcept(); // cc
      return this.originRelationshipType;
    }

    public boolean hasOriginRelationshipType() { 
      return this.originRelationshipType != null && !this.originRelationshipType.isEmpty();
    }

    /**
     * @param value {@link #originRelationshipType} (Indicates the relationship between the donor of the biologically derived product and the intended recipient.)
     */
    public BiologicallyDerivedProductDispense setOriginRelationshipType(CodeableConcept value) { 
      this.originRelationshipType = value;
      return this;
    }

    /**
     * @return {@link #product} (A link to a resource identifying the biologically derived product that is being dispensed.)
     */
    public Reference getProduct() { 
      if (this.product == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.product");
        else if (Configuration.doAutoCreate())
          this.product = new Reference(); // cc
      return this.product;
    }

    public boolean hasProduct() { 
      return this.product != null && !this.product.isEmpty();
    }

    /**
     * @param value {@link #product} (A link to a resource identifying the biologically derived product that is being dispensed.)
     */
    public BiologicallyDerivedProductDispense setProduct(Reference value) { 
      this.product = value;
      return this;
    }

    /**
     * @return {@link #patient} (A link to a resource representing the patient that the product is dispensed for.)
     */
    public Reference getPatient() { 
      if (this.patient == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.patient");
        else if (Configuration.doAutoCreate())
          this.patient = new Reference(); // cc
      return this.patient;
    }

    public boolean hasPatient() { 
      return this.patient != null && !this.patient.isEmpty();
    }

    /**
     * @param value {@link #patient} (A link to a resource representing the patient that the product is dispensed for.)
     */
    public BiologicallyDerivedProductDispense setPatient(Reference value) { 
      this.patient = value;
      return this;
    }

    /**
     * @return {@link #matchStatus} (Indicates the type of matching associated with the dispense.)
     */
    public CodeableConcept getMatchStatus() { 
      if (this.matchStatus == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.matchStatus");
        else if (Configuration.doAutoCreate())
          this.matchStatus = new CodeableConcept(); // cc
      return this.matchStatus;
    }

    public boolean hasMatchStatus() { 
      return this.matchStatus != null && !this.matchStatus.isEmpty();
    }

    /**
     * @param value {@link #matchStatus} (Indicates the type of matching associated with the dispense.)
     */
    public BiologicallyDerivedProductDispense setMatchStatus(CodeableConcept value) { 
      this.matchStatus = value;
      return this;
    }

    /**
     * @return {@link #performer} (Indicates who or what performed an action.)
     */
    public List<BiologicallyDerivedProductDispensePerformerComponent> getPerformer() { 
      if (this.performer == null)
        this.performer = new ArrayList<BiologicallyDerivedProductDispensePerformerComponent>();
      return this.performer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProductDispense setPerformer(List<BiologicallyDerivedProductDispensePerformerComponent> thePerformer) { 
      this.performer = thePerformer;
      return this;
    }

    public boolean hasPerformer() { 
      if (this.performer == null)
        return false;
      for (BiologicallyDerivedProductDispensePerformerComponent item : this.performer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public BiologicallyDerivedProductDispensePerformerComponent addPerformer() { //3
      BiologicallyDerivedProductDispensePerformerComponent t = new BiologicallyDerivedProductDispensePerformerComponent();
      if (this.performer == null)
        this.performer = new ArrayList<BiologicallyDerivedProductDispensePerformerComponent>();
      this.performer.add(t);
      return t;
    }

    public BiologicallyDerivedProductDispense addPerformer(BiologicallyDerivedProductDispensePerformerComponent t) { //3
      if (t == null)
        return this;
      if (this.performer == null)
        this.performer = new ArrayList<BiologicallyDerivedProductDispensePerformerComponent>();
      this.performer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #performer}, creating it if it does not already exist {3}
     */
    public BiologicallyDerivedProductDispensePerformerComponent getPerformerFirstRep() { 
      if (getPerformer().isEmpty()) {
        addPerformer();
      }
      return getPerformer().get(0);
    }

    /**
     * @return {@link #location} (The physical location where the dispense was performed.)
     */
    public Reference getLocation() { 
      if (this.location == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.location");
        else if (Configuration.doAutoCreate())
          this.location = new Reference(); // cc
      return this.location;
    }

    public boolean hasLocation() { 
      return this.location != null && !this.location.isEmpty();
    }

    /**
     * @param value {@link #location} (The physical location where the dispense was performed.)
     */
    public BiologicallyDerivedProductDispense setLocation(Reference value) { 
      this.location = value;
      return this;
    }

    /**
     * @return {@link #quantity} (The amount of product in the dispense. Quantity will depend on the product being dispensed. Examples are: volume; cell count; concentration.)
     */
    public Quantity getQuantity() { 
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.quantity");
        else if (Configuration.doAutoCreate())
          this.quantity = new Quantity(); // cc
      return this.quantity;
    }

    public boolean hasQuantity() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (The amount of product in the dispense. Quantity will depend on the product being dispensed. Examples are: volume; cell count; concentration.)
     */
    public BiologicallyDerivedProductDispense setQuantity(Quantity value) { 
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #preparedDate} (When the product was selected/ matched.). This is the underlying object with id, value and extensions. The accessor "getPreparedDate" gives direct access to the value
     */
    public DateTimeType getPreparedDateElement() { 
      if (this.preparedDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.preparedDate");
        else if (Configuration.doAutoCreate())
          this.preparedDate = new DateTimeType(); // bb
      return this.preparedDate;
    }

    public boolean hasPreparedDateElement() { 
      return this.preparedDate != null && !this.preparedDate.isEmpty();
    }

    public boolean hasPreparedDate() { 
      return this.preparedDate != null && !this.preparedDate.isEmpty();
    }

    /**
     * @param value {@link #preparedDate} (When the product was selected/ matched.). This is the underlying object with id, value and extensions. The accessor "getPreparedDate" gives direct access to the value
     */
    public BiologicallyDerivedProductDispense setPreparedDateElement(DateTimeType value) { 
      this.preparedDate = value;
      return this;
    }

    /**
     * @return When the product was selected/ matched.
     */
    public Date getPreparedDate() { 
      return this.preparedDate == null ? null : this.preparedDate.getValue();
    }

    /**
     * @param value When the product was selected/ matched.
     */
    public BiologicallyDerivedProductDispense setPreparedDate(Date value) { 
      if (value == null)
        this.preparedDate = null;
      else {
        if (this.preparedDate == null)
          this.preparedDate = new DateTimeType();
        this.preparedDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #whenHandedOver} (When the product was dispatched for clinical use.). This is the underlying object with id, value and extensions. The accessor "getWhenHandedOver" gives direct access to the value
     */
    public DateTimeType getWhenHandedOverElement() { 
      if (this.whenHandedOver == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.whenHandedOver");
        else if (Configuration.doAutoCreate())
          this.whenHandedOver = new DateTimeType(); // bb
      return this.whenHandedOver;
    }

    public boolean hasWhenHandedOverElement() { 
      return this.whenHandedOver != null && !this.whenHandedOver.isEmpty();
    }

    public boolean hasWhenHandedOver() { 
      return this.whenHandedOver != null && !this.whenHandedOver.isEmpty();
    }

    /**
     * @param value {@link #whenHandedOver} (When the product was dispatched for clinical use.). This is the underlying object with id, value and extensions. The accessor "getWhenHandedOver" gives direct access to the value
     */
    public BiologicallyDerivedProductDispense setWhenHandedOverElement(DateTimeType value) { 
      this.whenHandedOver = value;
      return this;
    }

    /**
     * @return When the product was dispatched for clinical use.
     */
    public Date getWhenHandedOver() { 
      return this.whenHandedOver == null ? null : this.whenHandedOver.getValue();
    }

    /**
     * @param value When the product was dispatched for clinical use.
     */
    public BiologicallyDerivedProductDispense setWhenHandedOver(Date value) { 
      if (value == null)
        this.whenHandedOver = null;
      else {
        if (this.whenHandedOver == null)
          this.whenHandedOver = new DateTimeType();
        this.whenHandedOver.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #destination} (Link to a resource identifying the physical location that the product was dispatched to.)
     */
    public Reference getDestination() { 
      if (this.destination == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.destination");
        else if (Configuration.doAutoCreate())
          this.destination = new Reference(); // cc
      return this.destination;
    }

    public boolean hasDestination() { 
      return this.destination != null && !this.destination.isEmpty();
    }

    /**
     * @param value {@link #destination} (Link to a resource identifying the physical location that the product was dispatched to.)
     */
    public BiologicallyDerivedProductDispense setDestination(Reference value) { 
      this.destination = value;
      return this;
    }

    /**
     * @return {@link #note} (Additional notes.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public BiologicallyDerivedProductDispense setNote(List<Annotation> theNote) { 
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

    public BiologicallyDerivedProductDispense addNote(Annotation t) { //3
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
     * @return {@link #usageInstruction} (Specific instructions for use.). This is the underlying object with id, value and extensions. The accessor "getUsageInstruction" gives direct access to the value
     */
    public StringType getUsageInstructionElement() { 
      if (this.usageInstruction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create BiologicallyDerivedProductDispense.usageInstruction");
        else if (Configuration.doAutoCreate())
          this.usageInstruction = new StringType(); // bb
      return this.usageInstruction;
    }

    public boolean hasUsageInstructionElement() { 
      return this.usageInstruction != null && !this.usageInstruction.isEmpty();
    }

    public boolean hasUsageInstruction() { 
      return this.usageInstruction != null && !this.usageInstruction.isEmpty();
    }

    /**
     * @param value {@link #usageInstruction} (Specific instructions for use.). This is the underlying object with id, value and extensions. The accessor "getUsageInstruction" gives direct access to the value
     */
    public BiologicallyDerivedProductDispense setUsageInstructionElement(StringType value) { 
      this.usageInstruction = value;
      return this;
    }

    /**
     * @return Specific instructions for use.
     */
    public String getUsageInstruction() { 
      return this.usageInstruction == null ? null : this.usageInstruction.getValue();
    }

    /**
     * @param value Specific instructions for use.
     */
    public BiologicallyDerivedProductDispense setUsageInstruction(String value) { 
      if (Utilities.noString(value))
        this.usageInstruction = null;
      else {
        if (this.usageInstruction == null)
          this.usageInstruction = new StringType();
        this.usageInstruction.setValue(value);
      }
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique instance identifiers assigned to a biologically derived product dispense. Note: This is a business identifier, not a resource identifier.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("basedOn", "Reference(ServiceRequest)", "The order or request that the dispense is fulfilling. This is a reference to a ServiceRequest resource.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("partOf", "Reference(BiologicallyDerivedProductDispense)", "A larger event of which this particular event is a component.", 0, java.lang.Integer.MAX_VALUE, partOf));
        children.add(new Property("status", "code", "A code specifying the state of the dispense event.", 0, 1, status));
        children.add(new Property("originRelationshipType", "CodeableConcept", "Indicates the relationship between the donor of the biologically derived product and the intended recipient.", 0, 1, originRelationshipType));
        children.add(new Property("product", "Reference(BiologicallyDerivedProduct)", "A link to a resource identifying the biologically derived product that is being dispensed.", 0, 1, product));
        children.add(new Property("patient", "Reference(Patient)", "A link to a resource representing the patient that the product is dispensed for.", 0, 1, patient));
        children.add(new Property("matchStatus", "CodeableConcept", "Indicates the type of matching associated with the dispense.", 0, 1, matchStatus));
        children.add(new Property("performer", "", "Indicates who or what performed an action.", 0, java.lang.Integer.MAX_VALUE, performer));
        children.add(new Property("location", "Reference(Location)", "The physical location where the dispense was performed.", 0, 1, location));
        children.add(new Property("quantity", "Quantity", "The amount of product in the dispense. Quantity will depend on the product being dispensed. Examples are: volume; cell count; concentration.", 0, 1, quantity));
        children.add(new Property("preparedDate", "dateTime", "When the product was selected/ matched.", 0, 1, preparedDate));
        children.add(new Property("whenHandedOver", "dateTime", "When the product was dispatched for clinical use.", 0, 1, whenHandedOver));
        children.add(new Property("destination", "Reference(Location)", "Link to a resource identifying the physical location that the product was dispatched to.", 0, 1, destination));
        children.add(new Property("note", "Annotation", "Additional notes.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("usageInstruction", "string", "Specific instructions for use.", 0, 1, usageInstruction));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique instance identifiers assigned to a biologically derived product dispense. Note: This is a business identifier, not a resource identifier.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(ServiceRequest)", "The order or request that the dispense is fulfilling. This is a reference to a ServiceRequest resource.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -995410646: /*partOf*/  return new Property("partOf", "Reference(BiologicallyDerivedProductDispense)", "A larger event of which this particular event is a component.", 0, java.lang.Integer.MAX_VALUE, partOf);
        case -892481550: /*status*/  return new Property("status", "code", "A code specifying the state of the dispense event.", 0, 1, status);
        case 1746240728: /*originRelationshipType*/  return new Property("originRelationshipType", "CodeableConcept", "Indicates the relationship between the donor of the biologically derived product and the intended recipient.", 0, 1, originRelationshipType);
        case -309474065: /*product*/  return new Property("product", "Reference(BiologicallyDerivedProduct)", "A link to a resource identifying the biologically derived product that is being dispensed.", 0, 1, product);
        case -791418107: /*patient*/  return new Property("patient", "Reference(Patient)", "A link to a resource representing the patient that the product is dispensed for.", 0, 1, patient);
        case 1644523031: /*matchStatus*/  return new Property("matchStatus", "CodeableConcept", "Indicates the type of matching associated with the dispense.", 0, 1, matchStatus);
        case 481140686: /*performer*/  return new Property("performer", "", "Indicates who or what performed an action.", 0, java.lang.Integer.MAX_VALUE, performer);
        case 1901043637: /*location*/  return new Property("location", "Reference(Location)", "The physical location where the dispense was performed.", 0, 1, location);
        case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The amount of product in the dispense. Quantity will depend on the product being dispensed. Examples are: volume; cell count; concentration.", 0, 1, quantity);
        case -2024959605: /*preparedDate*/  return new Property("preparedDate", "dateTime", "When the product was selected/ matched.", 0, 1, preparedDate);
        case -940241380: /*whenHandedOver*/  return new Property("whenHandedOver", "dateTime", "When the product was dispatched for clinical use.", 0, 1, whenHandedOver);
        case -1429847026: /*destination*/  return new Property("destination", "Reference(Location)", "Link to a resource identifying the physical location that the product was dispatched to.", 0, 1, destination);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Additional notes.", 0, java.lang.Integer.MAX_VALUE, note);
        case 2138372141: /*usageInstruction*/  return new Property("usageInstruction", "string", "Specific instructions for use.", 0, 1, usageInstruction);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -995410646: /*partOf*/ return this.partOf == null ? new Base[0] : this.partOf.toArray(new Base[this.partOf.size()]); // Reference
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<BiologicallyDerivedProductDispenseCodes>
        case 1746240728: /*originRelationshipType*/ return this.originRelationshipType == null ? new Base[0] : new Base[] {this.originRelationshipType}; // CodeableConcept
        case -309474065: /*product*/ return this.product == null ? new Base[0] : new Base[] {this.product}; // Reference
        case -791418107: /*patient*/ return this.patient == null ? new Base[0] : new Base[] {this.patient}; // Reference
        case 1644523031: /*matchStatus*/ return this.matchStatus == null ? new Base[0] : new Base[] {this.matchStatus}; // CodeableConcept
        case 481140686: /*performer*/ return this.performer == null ? new Base[0] : this.performer.toArray(new Base[this.performer.size()]); // BiologicallyDerivedProductDispensePerformerComponent
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // Reference
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case -2024959605: /*preparedDate*/ return this.preparedDate == null ? new Base[0] : new Base[] {this.preparedDate}; // DateTimeType
        case -940241380: /*whenHandedOver*/ return this.whenHandedOver == null ? new Base[0] : new Base[] {this.whenHandedOver}; // DateTimeType
        case -1429847026: /*destination*/ return this.destination == null ? new Base[0] : new Base[] {this.destination}; // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 2138372141: /*usageInstruction*/ return this.usageInstruction == null ? new Base[0] : new Base[] {this.usageInstruction}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -995410646: // partOf
          this.getPartOf().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -892481550: // status
          value = new BiologicallyDerivedProductDispenseCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<BiologicallyDerivedProductDispenseCodes>
          return value;
        case 1746240728: // originRelationshipType
          this.originRelationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -309474065: // product
          this.product = TypeConvertor.castToReference(value); // Reference
          return value;
        case -791418107: // patient
          this.patient = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1644523031: // matchStatus
          this.matchStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 481140686: // performer
          this.getPerformer().add((BiologicallyDerivedProductDispensePerformerComponent) value); // BiologicallyDerivedProductDispensePerformerComponent
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -2024959605: // preparedDate
          this.preparedDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -940241380: // whenHandedOver
          this.whenHandedOver = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1429847026: // destination
          this.destination = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 2138372141: // usageInstruction
          this.usageInstruction = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("partOf")) {
          this.getPartOf().add(TypeConvertor.castToReference(value));
        } else if (name.equals("status")) {
          value = new BiologicallyDerivedProductDispenseCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<BiologicallyDerivedProductDispenseCodes>
        } else if (name.equals("originRelationshipType")) {
          this.originRelationshipType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("product")) {
          this.product = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("patient")) {
          this.patient = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("matchStatus")) {
          this.matchStatus = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("performer")) {
          this.getPerformer().add((BiologicallyDerivedProductDispensePerformerComponent) value);
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("preparedDate")) {
          this.preparedDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("whenHandedOver")) {
          this.whenHandedOver = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("destination")) {
          this.destination = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("usageInstruction")) {
          this.usageInstruction = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("basedOn")) {
          this.getBasedOn().remove(value);
        } else if (name.equals("partOf")) {
          this.getPartOf().remove(value);
        } else if (name.equals("status")) {
          value = new BiologicallyDerivedProductDispenseCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<BiologicallyDerivedProductDispenseCodes>
        } else if (name.equals("originRelationshipType")) {
          this.originRelationshipType = null;
        } else if (name.equals("product")) {
          this.product = null;
        } else if (name.equals("patient")) {
          this.patient = null;
        } else if (name.equals("matchStatus")) {
          this.matchStatus = null;
        } else if (name.equals("performer")) {
          this.getPerformer().remove((BiologicallyDerivedProductDispensePerformerComponent) value);
        } else if (name.equals("location")) {
          this.location = null;
        } else if (name.equals("quantity")) {
          this.quantity = null;
        } else if (name.equals("preparedDate")) {
          this.preparedDate = null;
        } else if (name.equals("whenHandedOver")) {
          this.whenHandedOver = null;
        } else if (name.equals("destination")) {
          this.destination = null;
        } else if (name.equals("note")) {
          this.getNote().remove(value);
        } else if (name.equals("usageInstruction")) {
          this.usageInstruction = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case -332612366:  return addBasedOn(); 
        case -995410646:  return addPartOf(); 
        case -892481550:  return getStatusElement();
        case 1746240728:  return getOriginRelationshipType();
        case -309474065:  return getProduct();
        case -791418107:  return getPatient();
        case 1644523031:  return getMatchStatus();
        case 481140686:  return addPerformer(); 
        case 1901043637:  return getLocation();
        case -1285004149:  return getQuantity();
        case -2024959605:  return getPreparedDateElement();
        case -940241380:  return getWhenHandedOverElement();
        case -1429847026:  return getDestination();
        case 3387378:  return addNote(); 
        case 2138372141:  return getUsageInstructionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -995410646: /*partOf*/ return new String[] {"Reference"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 1746240728: /*originRelationshipType*/ return new String[] {"CodeableConcept"};
        case -309474065: /*product*/ return new String[] {"Reference"};
        case -791418107: /*patient*/ return new String[] {"Reference"};
        case 1644523031: /*matchStatus*/ return new String[] {"CodeableConcept"};
        case 481140686: /*performer*/ return new String[] {};
        case 1901043637: /*location*/ return new String[] {"Reference"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case -2024959605: /*preparedDate*/ return new String[] {"dateTime"};
        case -940241380: /*whenHandedOver*/ return new String[] {"dateTime"};
        case -1429847026: /*destination*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 2138372141: /*usageInstruction*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("partOf")) {
          return addPartOf();
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property BiologicallyDerivedProductDispense.status");
        }
        else if (name.equals("originRelationshipType")) {
          this.originRelationshipType = new CodeableConcept();
          return this.originRelationshipType;
        }
        else if (name.equals("product")) {
          this.product = new Reference();
          return this.product;
        }
        else if (name.equals("patient")) {
          this.patient = new Reference();
          return this.patient;
        }
        else if (name.equals("matchStatus")) {
          this.matchStatus = new CodeableConcept();
          return this.matchStatus;
        }
        else if (name.equals("performer")) {
          return addPerformer();
        }
        else if (name.equals("location")) {
          this.location = new Reference();
          return this.location;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("preparedDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property BiologicallyDerivedProductDispense.preparedDate");
        }
        else if (name.equals("whenHandedOver")) {
          throw new FHIRException("Cannot call addChild on a singleton property BiologicallyDerivedProductDispense.whenHandedOver");
        }
        else if (name.equals("destination")) {
          this.destination = new Reference();
          return this.destination;
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("usageInstruction")) {
          throw new FHIRException("Cannot call addChild on a singleton property BiologicallyDerivedProductDispense.usageInstruction");
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "BiologicallyDerivedProductDispense";

  }

      public BiologicallyDerivedProductDispense copy() {
        BiologicallyDerivedProductDispense dst = new BiologicallyDerivedProductDispense();
        copyValues(dst);
        return dst;
      }

      public void copyValues(BiologicallyDerivedProductDispense dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (partOf != null) {
          dst.partOf = new ArrayList<Reference>();
          for (Reference i : partOf)
            dst.partOf.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.originRelationshipType = originRelationshipType == null ? null : originRelationshipType.copy();
        dst.product = product == null ? null : product.copy();
        dst.patient = patient == null ? null : patient.copy();
        dst.matchStatus = matchStatus == null ? null : matchStatus.copy();
        if (performer != null) {
          dst.performer = new ArrayList<BiologicallyDerivedProductDispensePerformerComponent>();
          for (BiologicallyDerivedProductDispensePerformerComponent i : performer)
            dst.performer.add(i.copy());
        };
        dst.location = location == null ? null : location.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.preparedDate = preparedDate == null ? null : preparedDate.copy();
        dst.whenHandedOver = whenHandedOver == null ? null : whenHandedOver.copy();
        dst.destination = destination == null ? null : destination.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.usageInstruction = usageInstruction == null ? null : usageInstruction.copy();
      }

      protected BiologicallyDerivedProductDispense typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProductDispense))
          return false;
        BiologicallyDerivedProductDispense o = (BiologicallyDerivedProductDispense) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(basedOn, o.basedOn, true) && compareDeep(partOf, o.partOf, true)
           && compareDeep(status, o.status, true) && compareDeep(originRelationshipType, o.originRelationshipType, true)
           && compareDeep(product, o.product, true) && compareDeep(patient, o.patient, true) && compareDeep(matchStatus, o.matchStatus, true)
           && compareDeep(performer, o.performer, true) && compareDeep(location, o.location, true) && compareDeep(quantity, o.quantity, true)
           && compareDeep(preparedDate, o.preparedDate, true) && compareDeep(whenHandedOver, o.whenHandedOver, true)
           && compareDeep(destination, o.destination, true) && compareDeep(note, o.note, true) && compareDeep(usageInstruction, o.usageInstruction, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof BiologicallyDerivedProductDispense))
          return false;
        BiologicallyDerivedProductDispense o = (BiologicallyDerivedProductDispense) other_;
        return compareValues(status, o.status, true) && compareValues(preparedDate, o.preparedDate, true) && compareValues(whenHandedOver, o.whenHandedOver, true)
           && compareValues(usageInstruction, o.usageInstruction, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, basedOn, partOf
          , status, originRelationshipType, product, patient, matchStatus, performer, location
          , quantity, preparedDate, whenHandedOver, destination, note, usageInstruction);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.BiologicallyDerivedProductDispense;
   }

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the dispense</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="BiologicallyDerivedProductDispense.identifier", description="The identifier of the dispense", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The identifier of the dispense</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="BiologicallyDerivedProductDispense.patient", description="The identity of a patient for whom to list dispenses", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>BiologicallyDerivedProductDispense:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("BiologicallyDerivedProductDispense:patient").toLocked();

 /**
   * Search parameter: <b>performer</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.performer.actor</b><br>
   * </p>
   */
  @SearchParamDefinition(name="performer", path="BiologicallyDerivedProductDispense.performer.actor", description="The identity of a patient for whom to list dispenses", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Practitioner.class } )
  public static final String SP_PERFORMER = "performer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>performer</b>
   * <p>
   * Description: <b>The identity of a patient for whom to list dispenses</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.performer.actor</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PERFORMER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PERFORMER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>BiologicallyDerivedProductDispense:performer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PERFORMER = new ca.uhn.fhir.model.api.Include("BiologicallyDerivedProductDispense:performer").toLocked();

 /**
   * Search parameter: <b>product</b>
   * <p>
   * Description: <b>Search for products that match this code</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.product</b><br>
   * </p>
   */
  @SearchParamDefinition(name="product", path="BiologicallyDerivedProductDispense.product", description="Search for products that match this code", type="reference", target={BiologicallyDerivedProduct.class } )
  public static final String SP_PRODUCT = "product";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>product</b>
   * <p>
   * Description: <b>Search for products that match this code</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.product</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PRODUCT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PRODUCT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>BiologicallyDerivedProductDispense:product</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PRODUCT = new ca.uhn.fhir.model.api.Include("BiologicallyDerivedProductDispense:product").toLocked();

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the dispense</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="BiologicallyDerivedProductDispense.status", description="The status of the dispense", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the dispense</b><br>
   * Type: <b>token</b><br>
   * Path: <b>BiologicallyDerivedProductDispense.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}

