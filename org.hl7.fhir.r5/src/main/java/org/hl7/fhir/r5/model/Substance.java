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

// Generated on Tue, Dec 28, 2021 07:16+1100 for FHIR v5.0.0-snapshot1

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
 * A homogeneous material with a definite composition.
 */
@ResourceDef(name="Substance", profile="http://hl7.org/fhir/StructureDefinition/Substance")
public class Substance extends DomainResource {

    public enum FHIRSubstanceStatus {
        /**
         * The substance is considered for use or reference.
         */
        ACTIVE, 
        /**
         * The substance is considered for reference, but not for use.
         */
        INACTIVE, 
        /**
         * The substance was entered in error.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static FHIRSubstanceStatus fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown FHIRSubstanceStatus code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case INACTIVE: return "inactive";
            case ENTEREDINERROR: return "entered-in-error";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/substance-status";
            case INACTIVE: return "http://hl7.org/fhir/substance-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/substance-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The substance is considered for use or reference.";
            case INACTIVE: return "The substance is considered for reference, but not for use.";
            case ENTEREDINERROR: return "The substance was entered in error.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case INACTIVE: return "Inactive";
            case ENTEREDINERROR: return "Entered in Error";
            default: return "?";
          }
        }
    }

  public static class FHIRSubstanceStatusEnumFactory implements EnumFactory<FHIRSubstanceStatus> {
    public FHIRSubstanceStatus fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return FHIRSubstanceStatus.ACTIVE;
        if ("inactive".equals(codeString))
          return FHIRSubstanceStatus.INACTIVE;
        if ("entered-in-error".equals(codeString))
          return FHIRSubstanceStatus.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown FHIRSubstanceStatus code '"+codeString+"'");
        }
        public Enumeration<FHIRSubstanceStatus> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<FHIRSubstanceStatus>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<FHIRSubstanceStatus>(this, FHIRSubstanceStatus.ACTIVE);
        if ("inactive".equals(codeString))
          return new Enumeration<FHIRSubstanceStatus>(this, FHIRSubstanceStatus.INACTIVE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<FHIRSubstanceStatus>(this, FHIRSubstanceStatus.ENTEREDINERROR);
        throw new FHIRException("Unknown FHIRSubstanceStatus code '"+codeString+"'");
        }
    public String toCode(FHIRSubstanceStatus code) {
      if (code == FHIRSubstanceStatus.ACTIVE)
        return "active";
      if (code == FHIRSubstanceStatus.INACTIVE)
        return "inactive";
      if (code == FHIRSubstanceStatus.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(FHIRSubstanceStatus code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class SubstanceIngredientComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The amount of the ingredient in the substance - a concentration ratio.
         */
        @Child(name = "quantity", type = {Ratio.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Optional amount (concentration)", formalDefinition="The amount of the ingredient in the substance - a concentration ratio." )
        protected Ratio quantity;

        /**
         * Another substance that is a component of this substance.
         */
        @Child(name = "substance", type = {CodeableConcept.class, Substance.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A component of the substance", formalDefinition="Another substance that is a component of this substance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-code")
        protected DataType substance;

        private static final long serialVersionUID = 2068995180L;

    /**
     * Constructor
     */
      public SubstanceIngredientComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubstanceIngredientComponent(DataType substance) {
        super();
        this.setSubstance(substance);
      }

        /**
         * @return {@link #quantity} (The amount of the ingredient in the substance - a concentration ratio.)
         */
        public Ratio getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceIngredientComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Ratio(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The amount of the ingredient in the substance - a concentration ratio.)
         */
        public SubstanceIngredientComponent setQuantity(Ratio value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #substance} (Another substance that is a component of this substance.)
         */
        public DataType getSubstance() { 
          return this.substance;
        }

        /**
         * @return {@link #substance} (Another substance that is a component of this substance.)
         */
        public CodeableConcept getSubstanceCodeableConcept() throws FHIRException { 
          if (this.substance == null)
            this.substance = new CodeableConcept();
          if (!(this.substance instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.substance.getClass().getName()+" was encountered");
          return (CodeableConcept) this.substance;
        }

        public boolean hasSubstanceCodeableConcept() { 
          return this != null && this.substance instanceof CodeableConcept;
        }

        /**
         * @return {@link #substance} (Another substance that is a component of this substance.)
         */
        public Reference getSubstanceReference() throws FHIRException { 
          if (this.substance == null)
            this.substance = new Reference();
          if (!(this.substance instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.substance.getClass().getName()+" was encountered");
          return (Reference) this.substance;
        }

        public boolean hasSubstanceReference() { 
          return this != null && this.substance instanceof Reference;
        }

        public boolean hasSubstance() { 
          return this.substance != null && !this.substance.isEmpty();
        }

        /**
         * @param value {@link #substance} (Another substance that is a component of this substance.)
         */
        public SubstanceIngredientComponent setSubstance(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
            throw new Error("Not the right type for Substance.ingredient.substance[x]: "+value.fhirType());
          this.substance = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("quantity", "Ratio", "The amount of the ingredient in the substance - a concentration ratio.", 0, 1, quantity));
          children.add(new Property("substance[x]", "CodeableConcept|Reference(Substance)", "Another substance that is a component of this substance.", 0, 1, substance));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1285004149: /*quantity*/  return new Property("quantity", "Ratio", "The amount of the ingredient in the substance - a concentration ratio.", 0, 1, quantity);
          case 2127194384: /*substance[x]*/  return new Property("substance[x]", "CodeableConcept|Reference(Substance)", "Another substance that is a component of this substance.", 0, 1, substance);
          case 530040176: /*substance*/  return new Property("substance[x]", "CodeableConcept|Reference(Substance)", "Another substance that is a component of this substance.", 0, 1, substance);
          case -1974119407: /*substanceCodeableConcept*/  return new Property("substance[x]", "CodeableConcept", "Another substance that is a component of this substance.", 0, 1, substance);
          case 516208571: /*substanceReference*/  return new Property("substance[x]", "Reference(Substance)", "Another substance that is a component of this substance.", 0, 1, substance);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Ratio
        case 530040176: /*substance*/ return this.substance == null ? new Base[0] : new Base[] {this.substance}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToRatio(value); // Ratio
          return value;
        case 530040176: // substance
          this.substance = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToRatio(value); // Ratio
        } else if (name.equals("substance[x]")) {
          this.substance = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1285004149:  return getQuantity();
        case 2127194384:  return getSubstance();
        case 530040176:  return getSubstance();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1285004149: /*quantity*/ return new String[] {"Ratio"};
        case 530040176: /*substance*/ return new String[] {"CodeableConcept", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("quantity")) {
          this.quantity = new Ratio();
          return this.quantity;
        }
        else if (name.equals("substanceCodeableConcept")) {
          this.substance = new CodeableConcept();
          return this.substance;
        }
        else if (name.equals("substanceReference")) {
          this.substance = new Reference();
          return this.substance;
        }
        else
          return super.addChild(name);
      }

      public SubstanceIngredientComponent copy() {
        SubstanceIngredientComponent dst = new SubstanceIngredientComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceIngredientComponent dst) {
        super.copyValues(dst);
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.substance = substance == null ? null : substance.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceIngredientComponent))
          return false;
        SubstanceIngredientComponent o = (SubstanceIngredientComponent) other_;
        return compareDeep(quantity, o.quantity, true) && compareDeep(substance, o.substance, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceIngredientComponent))
          return false;
        SubstanceIngredientComponent o = (SubstanceIngredientComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(quantity, substance);
      }

  public String fhirType() {
    return "Substance.ingredient";

  }

  }

    /**
     * Unique identifier for the substance. For an instance, an identifier associated with the package/container (usually a label affixed directly).
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Unique identifier", formalDefinition="Unique identifier for the substance. For an instance, an identifier associated with the package/container (usually a label affixed directly)." )
    protected List<Identifier> identifier;

    /**
     * A boolean to indicate if this an instance of a substance or a kind of one (a definition).
     */
    @Child(name = "instance", type = {BooleanType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="Is this an instance of a substance or a kind of one", formalDefinition="A boolean to indicate if this an instance of a substance or a kind of one (a definition)." )
    protected BooleanType instance;

    /**
     * A code to indicate if the substance is actively used.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | inactive | entered-in-error", formalDefinition="A code to indicate if the substance is actively used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-status")
    protected Enumeration<FHIRSubstanceStatus> status;

    /**
     * A code that classifies the general type of substance.  This is used  for searching, sorting and display purposes.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="What class/type of substance this is", formalDefinition="A code that classifies the general type of substance.  This is used  for searching, sorting and display purposes." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-category")
    protected List<CodeableConcept> category;

    /**
     * A code (or set of codes) that identify this substance.
     */
    @Child(name = "code", type = {CodeableReference.class}, order=4, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What substance this is", formalDefinition="A code (or set of codes) that identify this substance." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-code")
    protected CodeableReference code;

    /**
     * A description of the substance - its appearance, handling requirements, and other usage notes.
     */
    @Child(name = "description", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Textual description of the substance, comments", formalDefinition="A description of the substance - its appearance, handling requirements, and other usage notes." )
    protected StringType description;

    /**
     * When the substance is no longer valid to use. For some substances, a single arbitrary date is used for expiry.
     */
    @Child(name = "expiry", type = {DateTimeType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When no longer valid to use", formalDefinition="When the substance is no longer valid to use. For some substances, a single arbitrary date is used for expiry." )
    protected DateTimeType expiry;

    /**
     * The amount of the substance.
     */
    @Child(name = "quantity", type = {Quantity.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Amount of substance in the package", formalDefinition="The amount of the substance." )
    protected Quantity quantity;

    /**
     * A substance can be composed of other substances.
     */
    @Child(name = "ingredient", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Composition information about the substance", formalDefinition="A substance can be composed of other substances." )
    protected List<SubstanceIngredientComponent> ingredient;

    private static final long serialVersionUID = -15918775L;

  /**
   * Constructor
   */
    public Substance() {
      super();
    }

  /**
   * Constructor
   */
    public Substance(boolean instance, CodeableReference code) {
      super();
      this.setInstance(instance);
      this.setCode(code);
    }

    /**
     * @return {@link #identifier} (Unique identifier for the substance. For an instance, an identifier associated with the package/container (usually a label affixed directly).)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Substance setIdentifier(List<Identifier> theIdentifier) { 
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

    public Substance addIdentifier(Identifier t) { //3
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
     * @return {@link #instance} (A boolean to indicate if this an instance of a substance or a kind of one (a definition).). This is the underlying object with id, value and extensions. The accessor "getInstance" gives direct access to the value
     */
    public BooleanType getInstanceElement() { 
      if (this.instance == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Substance.instance");
        else if (Configuration.doAutoCreate())
          this.instance = new BooleanType(); // bb
      return this.instance;
    }

    public boolean hasInstanceElement() { 
      return this.instance != null && !this.instance.isEmpty();
    }

    public boolean hasInstance() { 
      return this.instance != null && !this.instance.isEmpty();
    }

    /**
     * @param value {@link #instance} (A boolean to indicate if this an instance of a substance or a kind of one (a definition).). This is the underlying object with id, value and extensions. The accessor "getInstance" gives direct access to the value
     */
    public Substance setInstanceElement(BooleanType value) { 
      this.instance = value;
      return this;
    }

    /**
     * @return A boolean to indicate if this an instance of a substance or a kind of one (a definition).
     */
    public boolean getInstance() { 
      return this.instance == null || this.instance.isEmpty() ? false : this.instance.getValue();
    }

    /**
     * @param value A boolean to indicate if this an instance of a substance or a kind of one (a definition).
     */
    public Substance setInstance(boolean value) { 
        if (this.instance == null)
          this.instance = new BooleanType();
        this.instance.setValue(value);
      return this;
    }

    /**
     * @return {@link #status} (A code to indicate if the substance is actively used.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<FHIRSubstanceStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Substance.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<FHIRSubstanceStatus>(new FHIRSubstanceStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code to indicate if the substance is actively used.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Substance setStatusElement(Enumeration<FHIRSubstanceStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code to indicate if the substance is actively used.
     */
    public FHIRSubstanceStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code to indicate if the substance is actively used.
     */
    public Substance setStatus(FHIRSubstanceStatus value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<FHIRSubstanceStatus>(new FHIRSubstanceStatusEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #category} (A code that classifies the general type of substance.  This is used  for searching, sorting and display purposes.)
     */
    public List<CodeableConcept> getCategory() { 
      if (this.category == null)
        this.category = new ArrayList<CodeableConcept>();
      return this.category;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Substance setCategory(List<CodeableConcept> theCategory) { 
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

    public Substance addCategory(CodeableConcept t) { //3
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
     * @return {@link #code} (A code (or set of codes) that identify this substance.)
     */
    public CodeableReference getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Substance.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableReference(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code (or set of codes) that identify this substance.)
     */
    public Substance setCode(CodeableReference value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #description} (A description of the substance - its appearance, handling requirements, and other usage notes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public StringType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Substance.description");
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
     * @param value {@link #description} (A description of the substance - its appearance, handling requirements, and other usage notes.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Substance setDescriptionElement(StringType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A description of the substance - its appearance, handling requirements, and other usage notes.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A description of the substance - its appearance, handling requirements, and other usage notes.
     */
    public Substance setDescription(String value) { 
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
     * @return {@link #expiry} (When the substance is no longer valid to use. For some substances, a single arbitrary date is used for expiry.). This is the underlying object with id, value and extensions. The accessor "getExpiry" gives direct access to the value
     */
    public DateTimeType getExpiryElement() { 
      if (this.expiry == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Substance.expiry");
        else if (Configuration.doAutoCreate())
          this.expiry = new DateTimeType(); // bb
      return this.expiry;
    }

    public boolean hasExpiryElement() { 
      return this.expiry != null && !this.expiry.isEmpty();
    }

    public boolean hasExpiry() { 
      return this.expiry != null && !this.expiry.isEmpty();
    }

    /**
     * @param value {@link #expiry} (When the substance is no longer valid to use. For some substances, a single arbitrary date is used for expiry.). This is the underlying object with id, value and extensions. The accessor "getExpiry" gives direct access to the value
     */
    public Substance setExpiryElement(DateTimeType value) { 
      this.expiry = value;
      return this;
    }

    /**
     * @return When the substance is no longer valid to use. For some substances, a single arbitrary date is used for expiry.
     */
    public Date getExpiry() { 
      return this.expiry == null ? null : this.expiry.getValue();
    }

    /**
     * @param value When the substance is no longer valid to use. For some substances, a single arbitrary date is used for expiry.
     */
    public Substance setExpiry(Date value) { 
      if (value == null)
        this.expiry = null;
      else {
        if (this.expiry == null)
          this.expiry = new DateTimeType();
        this.expiry.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #quantity} (The amount of the substance.)
     */
    public Quantity getQuantity() { 
      if (this.quantity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Substance.quantity");
        else if (Configuration.doAutoCreate())
          this.quantity = new Quantity(); // cc
      return this.quantity;
    }

    public boolean hasQuantity() { 
      return this.quantity != null && !this.quantity.isEmpty();
    }

    /**
     * @param value {@link #quantity} (The amount of the substance.)
     */
    public Substance setQuantity(Quantity value) { 
      this.quantity = value;
      return this;
    }

    /**
     * @return {@link #ingredient} (A substance can be composed of other substances.)
     */
    public List<SubstanceIngredientComponent> getIngredient() { 
      if (this.ingredient == null)
        this.ingredient = new ArrayList<SubstanceIngredientComponent>();
      return this.ingredient;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Substance setIngredient(List<SubstanceIngredientComponent> theIngredient) { 
      this.ingredient = theIngredient;
      return this;
    }

    public boolean hasIngredient() { 
      if (this.ingredient == null)
        return false;
      for (SubstanceIngredientComponent item : this.ingredient)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubstanceIngredientComponent addIngredient() { //3
      SubstanceIngredientComponent t = new SubstanceIngredientComponent();
      if (this.ingredient == null)
        this.ingredient = new ArrayList<SubstanceIngredientComponent>();
      this.ingredient.add(t);
      return t;
    }

    public Substance addIngredient(SubstanceIngredientComponent t) { //3
      if (t == null)
        return this;
      if (this.ingredient == null)
        this.ingredient = new ArrayList<SubstanceIngredientComponent>();
      this.ingredient.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #ingredient}, creating it if it does not already exist {3}
     */
    public SubstanceIngredientComponent getIngredientFirstRep() { 
      if (getIngredient().isEmpty()) {
        addIngredient();
      }
      return getIngredient().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Unique identifier for the substance. For an instance, an identifier associated with the package/container (usually a label affixed directly).", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instance", "boolean", "A boolean to indicate if this an instance of a substance or a kind of one (a definition).", 0, 1, instance));
        children.add(new Property("status", "code", "A code to indicate if the substance is actively used.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "A code that classifies the general type of substance.  This is used  for searching, sorting and display purposes.", 0, java.lang.Integer.MAX_VALUE, category));
        children.add(new Property("code", "CodeableReference(SubstanceDefinition)", "A code (or set of codes) that identify this substance.", 0, 1, code));
        children.add(new Property("description", "string", "A description of the substance - its appearance, handling requirements, and other usage notes.", 0, 1, description));
        children.add(new Property("expiry", "dateTime", "When the substance is no longer valid to use. For some substances, a single arbitrary date is used for expiry.", 0, 1, expiry));
        children.add(new Property("quantity", "Quantity", "The amount of the substance.", 0, 1, quantity));
        children.add(new Property("ingredient", "", "A substance can be composed of other substances.", 0, java.lang.Integer.MAX_VALUE, ingredient));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Unique identifier for the substance. For an instance, an identifier associated with the package/container (usually a label affixed directly).", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 555127957: /*instance*/  return new Property("instance", "boolean", "A boolean to indicate if this an instance of a substance or a kind of one (a definition).", 0, 1, instance);
        case -892481550: /*status*/  return new Property("status", "code", "A code to indicate if the substance is actively used.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A code that classifies the general type of substance.  This is used  for searching, sorting and display purposes.", 0, java.lang.Integer.MAX_VALUE, category);
        case 3059181: /*code*/  return new Property("code", "CodeableReference(SubstanceDefinition)", "A code (or set of codes) that identify this substance.", 0, 1, code);
        case -1724546052: /*description*/  return new Property("description", "string", "A description of the substance - its appearance, handling requirements, and other usage notes.", 0, 1, description);
        case -1289159373: /*expiry*/  return new Property("expiry", "dateTime", "When the substance is no longer valid to use. For some substances, a single arbitrary date is used for expiry.", 0, 1, expiry);
        case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The amount of the substance.", 0, 1, quantity);
        case -206409263: /*ingredient*/  return new Property("ingredient", "", "A substance can be composed of other substances.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 555127957: /*instance*/ return this.instance == null ? new Base[0] : new Base[] {this.instance}; // BooleanType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<FHIRSubstanceStatus>
        case 50511102: /*category*/ return this.category == null ? new Base[0] : this.category.toArray(new Base[this.category.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableReference
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -1289159373: /*expiry*/ return this.expiry == null ? new Base[0] : new Base[] {this.expiry}; // DateTimeType
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // SubstanceIngredientComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 555127957: // instance
          this.instance = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -892481550: // status
          value = new FHIRSubstanceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FHIRSubstanceStatus>
          return value;
        case 50511102: // category
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -1289159373: // expiry
          this.expiry = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -206409263: // ingredient
          this.getIngredient().add((SubstanceIngredientComponent) value); // SubstanceIngredientComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("instance")) {
          this.instance = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("status")) {
          value = new FHIRSubstanceStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<FHIRSubstanceStatus>
        } else if (name.equals("category")) {
          this.getCategory().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("expiry")) {
          this.expiry = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("ingredient")) {
          this.getIngredient().add((SubstanceIngredientComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 555127957:  return getInstanceElement();
        case -892481550:  return getStatusElement();
        case 50511102:  return addCategory(); 
        case 3059181:  return getCode();
        case -1724546052:  return getDescriptionElement();
        case -1289159373:  return getExpiryElement();
        case -1285004149:  return getQuantity();
        case -206409263:  return addIngredient(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 555127957: /*instance*/ return new String[] {"boolean"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableReference"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -1289159373: /*expiry*/ return new String[] {"dateTime"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case -206409263: /*ingredient*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instance")) {
          throw new FHIRException("Cannot call addChild on a primitive type Substance.instance");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type Substance.status");
        }
        else if (name.equals("category")) {
          return addCategory();
        }
        else if (name.equals("code")) {
          this.code = new CodeableReference();
          return this.code;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Substance.description");
        }
        else if (name.equals("expiry")) {
          throw new FHIRException("Cannot call addChild on a primitive type Substance.expiry");
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Substance";

  }

      public Substance copy() {
        Substance dst = new Substance();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Substance dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.instance = instance == null ? null : instance.copy();
        dst.status = status == null ? null : status.copy();
        if (category != null) {
          dst.category = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : category)
            dst.category.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.description = description == null ? null : description.copy();
        dst.expiry = expiry == null ? null : expiry.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        if (ingredient != null) {
          dst.ingredient = new ArrayList<SubstanceIngredientComponent>();
          for (SubstanceIngredientComponent i : ingredient)
            dst.ingredient.add(i.copy());
        };
      }

      protected Substance typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Substance))
          return false;
        Substance o = (Substance) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instance, o.instance, true) && compareDeep(status, o.status, true)
           && compareDeep(category, o.category, true) && compareDeep(code, o.code, true) && compareDeep(description, o.description, true)
           && compareDeep(expiry, o.expiry, true) && compareDeep(quantity, o.quantity, true) && compareDeep(ingredient, o.ingredient, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Substance))
          return false;
        Substance o = (Substance) other_;
        return compareValues(instance, o.instance, true) && compareValues(status, o.status, true) && compareValues(description, o.description, true)
           && compareValues(expiry, o.expiry, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instance, status
          , category, code, description, expiry, quantity, ingredient);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Substance;
   }

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>The category of the substance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Substance.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="Substance.category", description="The category of the substance", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>The category of the substance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Substance.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>code-reference</b>
   * <p>
   * Description: <b>A reference to the defining substance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Substance.code.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code-reference", path="Substance.code.reference", description="A reference to the defining substance", type="reference" )
  public static final String SP_CODE_REFERENCE = "code-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code-reference</b>
   * <p>
   * Description: <b>A reference to the defining substance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Substance.code.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam CODE_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_CODE_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Substance:code-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_CODE_REFERENCE = new ca.uhn.fhir.model.api.Include("Substance:code-reference").toLocked();

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>The code of the substance or ingredient</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Substance.code.concept | (Substance.ingredient.substance as CodeableConcept)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="Substance.code.concept | (Substance.ingredient.substance as CodeableConcept)", description="The code of the substance or ingredient", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>The code of the substance or ingredient</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Substance.code.concept | (Substance.ingredient.substance as CodeableConcept)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>expiry</b>
   * <p>
   * Description: <b>Expiry date of package or container of substance</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Substance.expiry</b><br>
   * </p>
   */
  @SearchParamDefinition(name="expiry", path="Substance.expiry", description="Expiry date of package or container of substance", type="date" )
  public static final String SP_EXPIRY = "expiry";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>expiry</b>
   * <p>
   * Description: <b>Expiry date of package or container of substance</b><br>
   * Type: <b>date</b><br>
   * Path: <b>Substance.expiry</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EXPIRY = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EXPIRY);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier for the substance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Substance.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Substance.identifier", description="Unique identifier for the substance", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Unique identifier for the substance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Substance.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>quantity</b>
   * <p>
   * Description: <b>Amount of substance in the package</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Substance.quantity</b><br>
   * </p>
   */
  @SearchParamDefinition(name="quantity", path="Substance.quantity", description="Amount of substance in the package", type="quantity" )
  public static final String SP_QUANTITY = "quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>quantity</b>
   * <p>
   * Description: <b>Amount of substance in the package</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Substance.quantity</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_QUANTITY);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>active | inactive | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Substance.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Substance.status", description="active | inactive | entered-in-error", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>active | inactive | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Substance.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>substance-reference</b>
   * <p>
   * Description: <b>A component of the substance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(Substance.ingredient.substance as Reference)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="substance-reference", path="(Substance.ingredient.substance as Reference)", description="A component of the substance", type="reference", target={Substance.class } )
  public static final String SP_SUBSTANCE_REFERENCE = "substance-reference";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>substance-reference</b>
   * <p>
   * Description: <b>A component of the substance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>(Substance.ingredient.substance as Reference)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBSTANCE_REFERENCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBSTANCE_REFERENCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Substance:substance-reference</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBSTANCE_REFERENCE = new ca.uhn.fhir.model.api.Include("Substance:substance-reference").toLocked();


}

