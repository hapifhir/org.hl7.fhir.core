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
 * An ingredient of a manufactured item or pharmaceutical product.
 */
@ResourceDef(name="Ingredient", profile="http://hl7.org/fhir/StructureDefinition/Ingredient")
public class Ingredient extends DomainResource {

    public enum IngredientManufacturerRole {
        /**
         * 
         */
        ALLOWED, 
        /**
         * 
         */
        POSSIBLE, 
        /**
         * 
         */
        ACTUAL, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static IngredientManufacturerRole fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("allowed".equals(codeString))
          return ALLOWED;
        if ("possible".equals(codeString))
          return POSSIBLE;
        if ("actual".equals(codeString))
          return ACTUAL;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown IngredientManufacturerRole code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ALLOWED: return "allowed";
            case POSSIBLE: return "possible";
            case ACTUAL: return "actual";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ALLOWED: return "http://hl7.org/fhir/ingredient-manufacturer-role";
            case POSSIBLE: return "http://hl7.org/fhir/ingredient-manufacturer-role";
            case ACTUAL: return "http://hl7.org/fhir/ingredient-manufacturer-role";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ALLOWED: return "";
            case POSSIBLE: return "";
            case ACTUAL: return "";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ALLOWED: return "Manufacturer is specifically allowed for this ingredient";
            case POSSIBLE: return "Manufacturer is known to make this ingredient in general";
            case ACTUAL: return "Manufacturer actually makes this particular ingredient";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class IngredientManufacturerRoleEnumFactory implements EnumFactory<IngredientManufacturerRole> {
    public IngredientManufacturerRole fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("allowed".equals(codeString))
          return IngredientManufacturerRole.ALLOWED;
        if ("possible".equals(codeString))
          return IngredientManufacturerRole.POSSIBLE;
        if ("actual".equals(codeString))
          return IngredientManufacturerRole.ACTUAL;
        throw new IllegalArgumentException("Unknown IngredientManufacturerRole code '"+codeString+"'");
        }
        public Enumeration<IngredientManufacturerRole> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<IngredientManufacturerRole>(this, IngredientManufacturerRole.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<IngredientManufacturerRole>(this, IngredientManufacturerRole.NULL, code);
        if ("allowed".equals(codeString))
          return new Enumeration<IngredientManufacturerRole>(this, IngredientManufacturerRole.ALLOWED, code);
        if ("possible".equals(codeString))
          return new Enumeration<IngredientManufacturerRole>(this, IngredientManufacturerRole.POSSIBLE, code);
        if ("actual".equals(codeString))
          return new Enumeration<IngredientManufacturerRole>(this, IngredientManufacturerRole.ACTUAL, code);
        throw new FHIRException("Unknown IngredientManufacturerRole code '"+codeString+"'");
        }
    public String toCode(IngredientManufacturerRole code) {
      if (code == IngredientManufacturerRole.ALLOWED)
        return "allowed";
      if (code == IngredientManufacturerRole.POSSIBLE)
        return "possible";
      if (code == IngredientManufacturerRole.ACTUAL)
        return "actual";
      return "?";
      }
    public String toSystem(IngredientManufacturerRole code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class IngredientManufacturerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The way in which this manufacturer is associated with the ingredient. For example whether it is a possible one (others allowed), or an exclusive authorized one for this ingredient. Note that this is not the manufacturing process role.
         */
        @Child(name = "role", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="allowed | possible | actual", formalDefinition="The way in which this manufacturer is associated with the ingredient. For example whether it is a possible one (others allowed), or an exclusive authorized one for this ingredient. Note that this is not the manufacturing process role." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/ingredient-manufacturer-role")
        protected Enumeration<IngredientManufacturerRole> role;

        /**
         * An organization that manufactures this ingredient.
         */
        @Child(name = "manufacturer", type = {Organization.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="An organization that manufactures this ingredient", formalDefinition="An organization that manufactures this ingredient." )
        protected Reference manufacturer;

        private static final long serialVersionUID = -1226688097L;

    /**
     * Constructor
     */
      public IngredientManufacturerComponent() {
        super();
      }

    /**
     * Constructor
     */
      public IngredientManufacturerComponent(Reference manufacturer) {
        super();
        this.setManufacturer(manufacturer);
      }

        /**
         * @return {@link #role} (The way in which this manufacturer is associated with the ingredient. For example whether it is a possible one (others allowed), or an exclusive authorized one for this ingredient. Note that this is not the manufacturing process role.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public Enumeration<IngredientManufacturerRole> getRoleElement() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientManufacturerComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new Enumeration<IngredientManufacturerRole>(new IngredientManufacturerRoleEnumFactory()); // bb
          return this.role;
        }

        public boolean hasRoleElement() { 
          return this.role != null && !this.role.isEmpty();
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (The way in which this manufacturer is associated with the ingredient. For example whether it is a possible one (others allowed), or an exclusive authorized one for this ingredient. Note that this is not the manufacturing process role.). This is the underlying object with id, value and extensions. The accessor "getRole" gives direct access to the value
         */
        public IngredientManufacturerComponent setRoleElement(Enumeration<IngredientManufacturerRole> value) { 
          this.role = value;
          return this;
        }

        /**
         * @return The way in which this manufacturer is associated with the ingredient. For example whether it is a possible one (others allowed), or an exclusive authorized one for this ingredient. Note that this is not the manufacturing process role.
         */
        public IngredientManufacturerRole getRole() { 
          return this.role == null ? null : this.role.getValue();
        }

        /**
         * @param value The way in which this manufacturer is associated with the ingredient. For example whether it is a possible one (others allowed), or an exclusive authorized one for this ingredient. Note that this is not the manufacturing process role.
         */
        public IngredientManufacturerComponent setRole(IngredientManufacturerRole value) { 
          if (value == null)
            this.role = null;
          else {
            if (this.role == null)
              this.role = new Enumeration<IngredientManufacturerRole>(new IngredientManufacturerRoleEnumFactory());
            this.role.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #manufacturer} (An organization that manufactures this ingredient.)
         */
        public Reference getManufacturer() { 
          if (this.manufacturer == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientManufacturerComponent.manufacturer");
            else if (Configuration.doAutoCreate())
              this.manufacturer = new Reference(); // cc
          return this.manufacturer;
        }

        public boolean hasManufacturer() { 
          return this.manufacturer != null && !this.manufacturer.isEmpty();
        }

        /**
         * @param value {@link #manufacturer} (An organization that manufactures this ingredient.)
         */
        public IngredientManufacturerComponent setManufacturer(Reference value) { 
          this.manufacturer = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("role", "code", "The way in which this manufacturer is associated with the ingredient. For example whether it is a possible one (others allowed), or an exclusive authorized one for this ingredient. Note that this is not the manufacturing process role.", 0, 1, role));
          children.add(new Property("manufacturer", "Reference(Organization)", "An organization that manufactures this ingredient.", 0, 1, manufacturer));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3506294: /*role*/  return new Property("role", "code", "The way in which this manufacturer is associated with the ingredient. For example whether it is a possible one (others allowed), or an exclusive authorized one for this ingredient. Note that this is not the manufacturing process role.", 0, 1, role);
          case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "An organization that manufactures this ingredient.", 0, 1, manufacturer);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // Enumeration<IngredientManufacturerRole>
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : new Base[] {this.manufacturer}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3506294: // role
          value = new IngredientManufacturerRoleEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.role = (Enumeration) value; // Enumeration<IngredientManufacturerRole>
          return value;
        case -1969347631: // manufacturer
          this.manufacturer = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          value = new IngredientManufacturerRoleEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.role = (Enumeration) value; // Enumeration<IngredientManufacturerRole>
        } else if (name.equals("manufacturer")) {
          this.manufacturer = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294:  return getRoleElement();
        case -1969347631:  return getManufacturer();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return new String[] {"code"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("role")) {
          throw new FHIRException("Cannot call addChild on a singleton property Ingredient.manufacturer.role");
        }
        else if (name.equals("manufacturer")) {
          this.manufacturer = new Reference();
          return this.manufacturer;
        }
        else
          return super.addChild(name);
      }

      public IngredientManufacturerComponent copy() {
        IngredientManufacturerComponent dst = new IngredientManufacturerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(IngredientManufacturerComponent dst) {
        super.copyValues(dst);
        dst.role = role == null ? null : role.copy();
        dst.manufacturer = manufacturer == null ? null : manufacturer.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof IngredientManufacturerComponent))
          return false;
        IngredientManufacturerComponent o = (IngredientManufacturerComponent) other_;
        return compareDeep(role, o.role, true) && compareDeep(manufacturer, o.manufacturer, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof IngredientManufacturerComponent))
          return false;
        IngredientManufacturerComponent o = (IngredientManufacturerComponent) other_;
        return compareValues(role, o.role, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(role, manufacturer);
      }

  public String fhirType() {
    return "Ingredient.manufacturer";

  }

  }

    @Block()
    public static class IngredientSubstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code or full resource that represents the ingredient's substance.
         */
        @Child(name = "code", type = {CodeableReference.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A code or full resource that represents the ingredient substance", formalDefinition="A code or full resource that represents the ingredient's substance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-codes")
        protected CodeableReference code;

        /**
         * The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. The allowed repetitions do not represent different strengths, but are different representations - mathematically equivalent - of a single strength.
         */
        @Child(name = "strength", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The quantity of substance, per presentation, or per volume or mass, and type of quantity", formalDefinition="The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. The allowed repetitions do not represent different strengths, but are different representations - mathematically equivalent - of a single strength." )
        protected List<IngredientSubstanceStrengthComponent> strength;

        private static final long serialVersionUID = 538347209L;

    /**
     * Constructor
     */
      public IngredientSubstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public IngredientSubstanceComponent(CodeableReference code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (A code or full resource that represents the ingredient's substance.)
         */
        public CodeableReference getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableReference(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A code or full resource that represents the ingredient's substance.)
         */
        public IngredientSubstanceComponent setCode(CodeableReference value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #strength} (The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. The allowed repetitions do not represent different strengths, but are different representations - mathematically equivalent - of a single strength.)
         */
        public List<IngredientSubstanceStrengthComponent> getStrength() { 
          if (this.strength == null)
            this.strength = new ArrayList<IngredientSubstanceStrengthComponent>();
          return this.strength;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public IngredientSubstanceComponent setStrength(List<IngredientSubstanceStrengthComponent> theStrength) { 
          this.strength = theStrength;
          return this;
        }

        public boolean hasStrength() { 
          if (this.strength == null)
            return false;
          for (IngredientSubstanceStrengthComponent item : this.strength)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public IngredientSubstanceStrengthComponent addStrength() { //3
          IngredientSubstanceStrengthComponent t = new IngredientSubstanceStrengthComponent();
          if (this.strength == null)
            this.strength = new ArrayList<IngredientSubstanceStrengthComponent>();
          this.strength.add(t);
          return t;
        }

        public IngredientSubstanceComponent addStrength(IngredientSubstanceStrengthComponent t) { //3
          if (t == null)
            return this;
          if (this.strength == null)
            this.strength = new ArrayList<IngredientSubstanceStrengthComponent>();
          this.strength.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #strength}, creating it if it does not already exist {3}
         */
        public IngredientSubstanceStrengthComponent getStrengthFirstRep() { 
          if (getStrength().isEmpty()) {
            addStrength();
          }
          return getStrength().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableReference(SubstanceDefinition)", "A code or full resource that represents the ingredient's substance.", 0, 1, code));
          children.add(new Property("strength", "", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. The allowed repetitions do not represent different strengths, but are different representations - mathematically equivalent - of a single strength.", 0, java.lang.Integer.MAX_VALUE, strength));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableReference(SubstanceDefinition)", "A code or full resource that represents the ingredient's substance.", 0, 1, code);
          case 1791316033: /*strength*/  return new Property("strength", "", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. The allowed repetitions do not represent different strengths, but are different representations - mathematically equivalent - of a single strength.", 0, java.lang.Integer.MAX_VALUE, strength);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableReference
        case 1791316033: /*strength*/ return this.strength == null ? new Base[0] : this.strength.toArray(new Base[this.strength.size()]); // IngredientSubstanceStrengthComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 1791316033: // strength
          this.getStrength().add((IngredientSubstanceStrengthComponent) value); // IngredientSubstanceStrengthComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("strength")) {
          this.getStrength().add((IngredientSubstanceStrengthComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case 1791316033:  return addStrength(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableReference"};
        case 1791316033: /*strength*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableReference();
          return this.code;
        }
        else if (name.equals("strength")) {
          return addStrength();
        }
        else
          return super.addChild(name);
      }

      public IngredientSubstanceComponent copy() {
        IngredientSubstanceComponent dst = new IngredientSubstanceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(IngredientSubstanceComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        if (strength != null) {
          dst.strength = new ArrayList<IngredientSubstanceStrengthComponent>();
          for (IngredientSubstanceStrengthComponent i : strength)
            dst.strength.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof IngredientSubstanceComponent))
          return false;
        IngredientSubstanceComponent o = (IngredientSubstanceComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(strength, o.strength, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof IngredientSubstanceComponent))
          return false;
        IngredientSubstanceComponent o = (IngredientSubstanceComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, strength);
      }

  public String fhirType() {
    return "Ingredient.substance";

  }

  }

    @Block()
    public static class IngredientSubstanceStrengthComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').
         */
        @Child(name = "presentation", type = {Ratio.class, RatioRange.class, CodeableConcept.class, Quantity.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The quantity of substance in the unit of presentation", formalDefinition="The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg')." )
        protected DataType presentation;

        /**
         * A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.
         */
        @Child(name = "textPresentation", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Text of either the whole presentation strength or a part of it (rest being in Strength.presentation as a ratio)", formalDefinition="A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio." )
        protected StringType textPresentation;

        /**
         * The strength per unitary volume (or mass).
         */
        @Child(name = "concentration", type = {Ratio.class, RatioRange.class, CodeableConcept.class, Quantity.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The strength per unitary volume (or mass)", formalDefinition="The strength per unitary volume (or mass)." )
        protected DataType concentration;

        /**
         * A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.
         */
        @Child(name = "textConcentration", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Text of either the whole concentration strength or a part of it (rest being in Strength.concentration as a ratio)", formalDefinition="A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio." )
        protected StringType textConcentration;

        /**
         * A code that indicates if the strength is, for example, based on the ingredient substance as stated or on the substance base (when the ingredient is a salt).
         */
        @Child(name = "basis", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A code that indicates if the strength is, for example, based on the ingredient substance as stated or on the substance base (when the ingredient is a salt)", formalDefinition="A code that indicates if the strength is, for example, based on the ingredient substance as stated or on the substance base (when the ingredient is a salt)." )
        protected CodeableConcept basis;

        /**
         * For when strength is measured at a particular point or distance. There are products where strength is measured at a particular point. For example, the strength of the ingredient in some inhalers is measured at a particular position relative to the point of aerosolization.
         */
        @Child(name = "measurementPoint", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="When strength is measured at a particular point or distance", formalDefinition="For when strength is measured at a particular point or distance. There are products where strength is measured at a particular point. For example, the strength of the ingredient in some inhalers is measured at a particular position relative to the point of aerosolization." )
        protected StringType measurementPoint;

        /**
         * The country or countries for which the strength range applies.
         */
        @Child(name = "country", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Where the strength range applies", formalDefinition="The country or countries for which the strength range applies." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/country")
        protected List<CodeableConcept> country;

        /**
         * Strength expressed in terms of a reference substance. For when the ingredient strength is additionally expressed as equivalent to the strength of some other closely related substance (e.g. salt vs. base). Reference strength represents the strength (quantitative composition) of the active moiety of the active substance. There are situations when the active substance and active moiety are different, therefore both a strength and a reference strength are needed.
         */
        @Child(name = "referenceStrength", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Strength expressed in terms of a reference substance", formalDefinition="Strength expressed in terms of a reference substance. For when the ingredient strength is additionally expressed as equivalent to the strength of some other closely related substance (e.g. salt vs. base). Reference strength represents the strength (quantitative composition) of the active moiety of the active substance. There are situations when the active substance and active moiety are different, therefore both a strength and a reference strength are needed." )
        protected List<IngredientSubstanceStrengthReferenceStrengthComponent> referenceStrength;

        private static final long serialVersionUID = 1409093088L;

    /**
     * Constructor
     */
      public IngredientSubstanceStrengthComponent() {
        super();
      }

        /**
         * @return {@link #presentation} (The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').)
         */
        public DataType getPresentation() { 
          return this.presentation;
        }

        /**
         * @return {@link #presentation} (The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').)
         */
        public Ratio getPresentationRatio() throws FHIRException { 
          if (this.presentation == null)
            this.presentation = new Ratio();
          if (!(this.presentation instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.presentation.getClass().getName()+" was encountered");
          return (Ratio) this.presentation;
        }

        public boolean hasPresentationRatio() { 
          return this != null && this.presentation instanceof Ratio;
        }

        /**
         * @return {@link #presentation} (The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').)
         */
        public RatioRange getPresentationRatioRange() throws FHIRException { 
          if (this.presentation == null)
            this.presentation = new RatioRange();
          if (!(this.presentation instanceof RatioRange))
            throw new FHIRException("Type mismatch: the type RatioRange was expected, but "+this.presentation.getClass().getName()+" was encountered");
          return (RatioRange) this.presentation;
        }

        public boolean hasPresentationRatioRange() { 
          return this != null && this.presentation instanceof RatioRange;
        }

        /**
         * @return {@link #presentation} (The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').)
         */
        public CodeableConcept getPresentationCodeableConcept() throws FHIRException { 
          if (this.presentation == null)
            this.presentation = new CodeableConcept();
          if (!(this.presentation instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.presentation.getClass().getName()+" was encountered");
          return (CodeableConcept) this.presentation;
        }

        public boolean hasPresentationCodeableConcept() { 
          return this != null && this.presentation instanceof CodeableConcept;
        }

        /**
         * @return {@link #presentation} (The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').)
         */
        public Quantity getPresentationQuantity() throws FHIRException { 
          if (this.presentation == null)
            this.presentation = new Quantity();
          if (!(this.presentation instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.presentation.getClass().getName()+" was encountered");
          return (Quantity) this.presentation;
        }

        public boolean hasPresentationQuantity() { 
          return this != null && this.presentation instanceof Quantity;
        }

        public boolean hasPresentation() { 
          return this.presentation != null && !this.presentation.isEmpty();
        }

        /**
         * @param value {@link #presentation} (The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').)
         */
        public IngredientSubstanceStrengthComponent setPresentation(DataType value) { 
          if (value != null && !(value instanceof Ratio || value instanceof RatioRange || value instanceof CodeableConcept || value instanceof Quantity))
            throw new FHIRException("Not the right type for Ingredient.substance.strength.presentation[x]: "+value.fhirType());
          this.presentation = value;
          return this;
        }

        /**
         * @return {@link #textPresentation} (A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.). This is the underlying object with id, value and extensions. The accessor "getTextPresentation" gives direct access to the value
         */
        public StringType getTextPresentationElement() { 
          if (this.textPresentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.textPresentation");
            else if (Configuration.doAutoCreate())
              this.textPresentation = new StringType(); // bb
          return this.textPresentation;
        }

        public boolean hasTextPresentationElement() { 
          return this.textPresentation != null && !this.textPresentation.isEmpty();
        }

        public boolean hasTextPresentation() { 
          return this.textPresentation != null && !this.textPresentation.isEmpty();
        }

        /**
         * @param value {@link #textPresentation} (A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.). This is the underlying object with id, value and extensions. The accessor "getTextPresentation" gives direct access to the value
         */
        public IngredientSubstanceStrengthComponent setTextPresentationElement(StringType value) { 
          this.textPresentation = value;
          return this;
        }

        /**
         * @return A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.
         */
        public String getTextPresentation() { 
          return this.textPresentation == null ? null : this.textPresentation.getValue();
        }

        /**
         * @param value A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.
         */
        public IngredientSubstanceStrengthComponent setTextPresentation(String value) { 
          if (Utilities.noString(value))
            this.textPresentation = null;
          else {
            if (this.textPresentation == null)
              this.textPresentation = new StringType();
            this.textPresentation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #concentration} (The strength per unitary volume (or mass).)
         */
        public DataType getConcentration() { 
          return this.concentration;
        }

        /**
         * @return {@link #concentration} (The strength per unitary volume (or mass).)
         */
        public Ratio getConcentrationRatio() throws FHIRException { 
          if (this.concentration == null)
            this.concentration = new Ratio();
          if (!(this.concentration instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.concentration.getClass().getName()+" was encountered");
          return (Ratio) this.concentration;
        }

        public boolean hasConcentrationRatio() { 
          return this != null && this.concentration instanceof Ratio;
        }

        /**
         * @return {@link #concentration} (The strength per unitary volume (or mass).)
         */
        public RatioRange getConcentrationRatioRange() throws FHIRException { 
          if (this.concentration == null)
            this.concentration = new RatioRange();
          if (!(this.concentration instanceof RatioRange))
            throw new FHIRException("Type mismatch: the type RatioRange was expected, but "+this.concentration.getClass().getName()+" was encountered");
          return (RatioRange) this.concentration;
        }

        public boolean hasConcentrationRatioRange() { 
          return this != null && this.concentration instanceof RatioRange;
        }

        /**
         * @return {@link #concentration} (The strength per unitary volume (or mass).)
         */
        public CodeableConcept getConcentrationCodeableConcept() throws FHIRException { 
          if (this.concentration == null)
            this.concentration = new CodeableConcept();
          if (!(this.concentration instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.concentration.getClass().getName()+" was encountered");
          return (CodeableConcept) this.concentration;
        }

        public boolean hasConcentrationCodeableConcept() { 
          return this != null && this.concentration instanceof CodeableConcept;
        }

        /**
         * @return {@link #concentration} (The strength per unitary volume (or mass).)
         */
        public Quantity getConcentrationQuantity() throws FHIRException { 
          if (this.concentration == null)
            this.concentration = new Quantity();
          if (!(this.concentration instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.concentration.getClass().getName()+" was encountered");
          return (Quantity) this.concentration;
        }

        public boolean hasConcentrationQuantity() { 
          return this != null && this.concentration instanceof Quantity;
        }

        public boolean hasConcentration() { 
          return this.concentration != null && !this.concentration.isEmpty();
        }

        /**
         * @param value {@link #concentration} (The strength per unitary volume (or mass).)
         */
        public IngredientSubstanceStrengthComponent setConcentration(DataType value) { 
          if (value != null && !(value instanceof Ratio || value instanceof RatioRange || value instanceof CodeableConcept || value instanceof Quantity))
            throw new FHIRException("Not the right type for Ingredient.substance.strength.concentration[x]: "+value.fhirType());
          this.concentration = value;
          return this;
        }

        /**
         * @return {@link #textConcentration} (A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.). This is the underlying object with id, value and extensions. The accessor "getTextConcentration" gives direct access to the value
         */
        public StringType getTextConcentrationElement() { 
          if (this.textConcentration == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.textConcentration");
            else if (Configuration.doAutoCreate())
              this.textConcentration = new StringType(); // bb
          return this.textConcentration;
        }

        public boolean hasTextConcentrationElement() { 
          return this.textConcentration != null && !this.textConcentration.isEmpty();
        }

        public boolean hasTextConcentration() { 
          return this.textConcentration != null && !this.textConcentration.isEmpty();
        }

        /**
         * @param value {@link #textConcentration} (A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.). This is the underlying object with id, value and extensions. The accessor "getTextConcentration" gives direct access to the value
         */
        public IngredientSubstanceStrengthComponent setTextConcentrationElement(StringType value) { 
          this.textConcentration = value;
          return this;
        }

        /**
         * @return A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.
         */
        public String getTextConcentration() { 
          return this.textConcentration == null ? null : this.textConcentration.getValue();
        }

        /**
         * @param value A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.
         */
        public IngredientSubstanceStrengthComponent setTextConcentration(String value) { 
          if (Utilities.noString(value))
            this.textConcentration = null;
          else {
            if (this.textConcentration == null)
              this.textConcentration = new StringType();
            this.textConcentration.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #basis} (A code that indicates if the strength is, for example, based on the ingredient substance as stated or on the substance base (when the ingredient is a salt).)
         */
        public CodeableConcept getBasis() { 
          if (this.basis == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.basis");
            else if (Configuration.doAutoCreate())
              this.basis = new CodeableConcept(); // cc
          return this.basis;
        }

        public boolean hasBasis() { 
          return this.basis != null && !this.basis.isEmpty();
        }

        /**
         * @param value {@link #basis} (A code that indicates if the strength is, for example, based on the ingredient substance as stated or on the substance base (when the ingredient is a salt).)
         */
        public IngredientSubstanceStrengthComponent setBasis(CodeableConcept value) { 
          this.basis = value;
          return this;
        }

        /**
         * @return {@link #measurementPoint} (For when strength is measured at a particular point or distance. There are products where strength is measured at a particular point. For example, the strength of the ingredient in some inhalers is measured at a particular position relative to the point of aerosolization.). This is the underlying object with id, value and extensions. The accessor "getMeasurementPoint" gives direct access to the value
         */
        public StringType getMeasurementPointElement() { 
          if (this.measurementPoint == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.measurementPoint");
            else if (Configuration.doAutoCreate())
              this.measurementPoint = new StringType(); // bb
          return this.measurementPoint;
        }

        public boolean hasMeasurementPointElement() { 
          return this.measurementPoint != null && !this.measurementPoint.isEmpty();
        }

        public boolean hasMeasurementPoint() { 
          return this.measurementPoint != null && !this.measurementPoint.isEmpty();
        }

        /**
         * @param value {@link #measurementPoint} (For when strength is measured at a particular point or distance. There are products where strength is measured at a particular point. For example, the strength of the ingredient in some inhalers is measured at a particular position relative to the point of aerosolization.). This is the underlying object with id, value and extensions. The accessor "getMeasurementPoint" gives direct access to the value
         */
        public IngredientSubstanceStrengthComponent setMeasurementPointElement(StringType value) { 
          this.measurementPoint = value;
          return this;
        }

        /**
         * @return For when strength is measured at a particular point or distance. There are products where strength is measured at a particular point. For example, the strength of the ingredient in some inhalers is measured at a particular position relative to the point of aerosolization.
         */
        public String getMeasurementPoint() { 
          return this.measurementPoint == null ? null : this.measurementPoint.getValue();
        }

        /**
         * @param value For when strength is measured at a particular point or distance. There are products where strength is measured at a particular point. For example, the strength of the ingredient in some inhalers is measured at a particular position relative to the point of aerosolization.
         */
        public IngredientSubstanceStrengthComponent setMeasurementPoint(String value) { 
          if (Utilities.noString(value))
            this.measurementPoint = null;
          else {
            if (this.measurementPoint == null)
              this.measurementPoint = new StringType();
            this.measurementPoint.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #country} (The country or countries for which the strength range applies.)
         */
        public List<CodeableConcept> getCountry() { 
          if (this.country == null)
            this.country = new ArrayList<CodeableConcept>();
          return this.country;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public IngredientSubstanceStrengthComponent setCountry(List<CodeableConcept> theCountry) { 
          this.country = theCountry;
          return this;
        }

        public boolean hasCountry() { 
          if (this.country == null)
            return false;
          for (CodeableConcept item : this.country)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addCountry() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.country == null)
            this.country = new ArrayList<CodeableConcept>();
          this.country.add(t);
          return t;
        }

        public IngredientSubstanceStrengthComponent addCountry(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.country == null)
            this.country = new ArrayList<CodeableConcept>();
          this.country.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #country}, creating it if it does not already exist {3}
         */
        public CodeableConcept getCountryFirstRep() { 
          if (getCountry().isEmpty()) {
            addCountry();
          }
          return getCountry().get(0);
        }

        /**
         * @return {@link #referenceStrength} (Strength expressed in terms of a reference substance. For when the ingredient strength is additionally expressed as equivalent to the strength of some other closely related substance (e.g. salt vs. base). Reference strength represents the strength (quantitative composition) of the active moiety of the active substance. There are situations when the active substance and active moiety are different, therefore both a strength and a reference strength are needed.)
         */
        public List<IngredientSubstanceStrengthReferenceStrengthComponent> getReferenceStrength() { 
          if (this.referenceStrength == null)
            this.referenceStrength = new ArrayList<IngredientSubstanceStrengthReferenceStrengthComponent>();
          return this.referenceStrength;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public IngredientSubstanceStrengthComponent setReferenceStrength(List<IngredientSubstanceStrengthReferenceStrengthComponent> theReferenceStrength) { 
          this.referenceStrength = theReferenceStrength;
          return this;
        }

        public boolean hasReferenceStrength() { 
          if (this.referenceStrength == null)
            return false;
          for (IngredientSubstanceStrengthReferenceStrengthComponent item : this.referenceStrength)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public IngredientSubstanceStrengthReferenceStrengthComponent addReferenceStrength() { //3
          IngredientSubstanceStrengthReferenceStrengthComponent t = new IngredientSubstanceStrengthReferenceStrengthComponent();
          if (this.referenceStrength == null)
            this.referenceStrength = new ArrayList<IngredientSubstanceStrengthReferenceStrengthComponent>();
          this.referenceStrength.add(t);
          return t;
        }

        public IngredientSubstanceStrengthComponent addReferenceStrength(IngredientSubstanceStrengthReferenceStrengthComponent t) { //3
          if (t == null)
            return this;
          if (this.referenceStrength == null)
            this.referenceStrength = new ArrayList<IngredientSubstanceStrengthReferenceStrengthComponent>();
          this.referenceStrength.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #referenceStrength}, creating it if it does not already exist {3}
         */
        public IngredientSubstanceStrengthReferenceStrengthComponent getReferenceStrengthFirstRep() { 
          if (getReferenceStrength().isEmpty()) {
            addReferenceStrength();
          }
          return getReferenceStrength().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("presentation[x]", "Ratio|RatioRange|CodeableConcept|Quantity", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').", 0, 1, presentation));
          children.add(new Property("textPresentation", "string", "A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.", 0, 1, textPresentation));
          children.add(new Property("concentration[x]", "Ratio|RatioRange|CodeableConcept|Quantity", "The strength per unitary volume (or mass).", 0, 1, concentration));
          children.add(new Property("textConcentration", "string", "A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.", 0, 1, textConcentration));
          children.add(new Property("basis", "CodeableConcept", "A code that indicates if the strength is, for example, based on the ingredient substance as stated or on the substance base (when the ingredient is a salt).", 0, 1, basis));
          children.add(new Property("measurementPoint", "string", "For when strength is measured at a particular point or distance. There are products where strength is measured at a particular point. For example, the strength of the ingredient in some inhalers is measured at a particular position relative to the point of aerosolization.", 0, 1, measurementPoint));
          children.add(new Property("country", "CodeableConcept", "The country or countries for which the strength range applies.", 0, java.lang.Integer.MAX_VALUE, country));
          children.add(new Property("referenceStrength", "", "Strength expressed in terms of a reference substance. For when the ingredient strength is additionally expressed as equivalent to the strength of some other closely related substance (e.g. salt vs. base). Reference strength represents the strength (quantitative composition) of the active moiety of the active substance. There are situations when the active substance and active moiety are different, therefore both a strength and a reference strength are needed.", 0, java.lang.Integer.MAX_VALUE, referenceStrength));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1714280230: /*presentation[x]*/  return new Property("presentation[x]", "Ratio|RatioRange|CodeableConcept|Quantity", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').", 0, 1, presentation);
          case 696975130: /*presentation*/  return new Property("presentation[x]", "Ratio|RatioRange|CodeableConcept|Quantity", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').", 0, 1, presentation);
          case -1853112047: /*presentationRatio*/  return new Property("presentation[x]", "Ratio", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').", 0, 1, presentation);
          case 643336876: /*presentationRatioRange*/  return new Property("presentation[x]", "RatioRange", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').", 0, 1, presentation);
          case 1095127335: /*presentationCodeableConcept*/  return new Property("presentation[x]", "CodeableConcept", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').", 0, 1, presentation);
          case -263057979: /*presentationQuantity*/  return new Property("presentation[x]", "Quantity", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item. Unit of presentation refers to the quantity that the item occurs in e.g. a strength per tablet size, perhaps 'per 20mg' (the size of the tablet). It is not generally normalized as a unitary unit, which would be 'per mg').", 0, 1, presentation);
          case -799720217: /*textPresentation*/  return new Property("textPresentation", "string", "A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.", 0, 1, textPresentation);
          case 1153502451: /*concentration[x]*/  return new Property("concentration[x]", "Ratio|RatioRange|CodeableConcept|Quantity", "The strength per unitary volume (or mass).", 0, 1, concentration);
          case -410557331: /*concentration*/  return new Property("concentration[x]", "Ratio|RatioRange|CodeableConcept|Quantity", "The strength per unitary volume (or mass).", 0, 1, concentration);
          case 405321630: /*concentrationRatio*/  return new Property("concentration[x]", "Ratio", "The strength per unitary volume (or mass).", 0, 1, concentration);
          case 436249663: /*concentrationRatioRange*/  return new Property("concentration[x]", "RatioRange", "The strength per unitary volume (or mass).", 0, 1, concentration);
          case -90293388: /*concentrationCodeableConcept*/  return new Property("concentration[x]", "CodeableConcept", "The strength per unitary volume (or mass).", 0, 1, concentration);
          case 71921688: /*concentrationQuantity*/  return new Property("concentration[x]", "Quantity", "The strength per unitary volume (or mass).", 0, 1, concentration);
          case 436527168: /*textConcentration*/  return new Property("textConcentration", "string", "A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.", 0, 1, textConcentration);
          case 93508670: /*basis*/  return new Property("basis", "CodeableConcept", "A code that indicates if the strength is, for example, based on the ingredient substance as stated or on the substance base (when the ingredient is a salt).", 0, 1, basis);
          case 235437876: /*measurementPoint*/  return new Property("measurementPoint", "string", "For when strength is measured at a particular point or distance. There are products where strength is measured at a particular point. For example, the strength of the ingredient in some inhalers is measured at a particular position relative to the point of aerosolization.", 0, 1, measurementPoint);
          case 957831062: /*country*/  return new Property("country", "CodeableConcept", "The country or countries for which the strength range applies.", 0, java.lang.Integer.MAX_VALUE, country);
          case 1943566508: /*referenceStrength*/  return new Property("referenceStrength", "", "Strength expressed in terms of a reference substance. For when the ingredient strength is additionally expressed as equivalent to the strength of some other closely related substance (e.g. salt vs. base). Reference strength represents the strength (quantitative composition) of the active moiety of the active substance. There are situations when the active substance and active moiety are different, therefore both a strength and a reference strength are needed.", 0, java.lang.Integer.MAX_VALUE, referenceStrength);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 696975130: /*presentation*/ return this.presentation == null ? new Base[0] : new Base[] {this.presentation}; // DataType
        case -799720217: /*textPresentation*/ return this.textPresentation == null ? new Base[0] : new Base[] {this.textPresentation}; // StringType
        case -410557331: /*concentration*/ return this.concentration == null ? new Base[0] : new Base[] {this.concentration}; // DataType
        case 436527168: /*textConcentration*/ return this.textConcentration == null ? new Base[0] : new Base[] {this.textConcentration}; // StringType
        case 93508670: /*basis*/ return this.basis == null ? new Base[0] : new Base[] {this.basis}; // CodeableConcept
        case 235437876: /*measurementPoint*/ return this.measurementPoint == null ? new Base[0] : new Base[] {this.measurementPoint}; // StringType
        case 957831062: /*country*/ return this.country == null ? new Base[0] : this.country.toArray(new Base[this.country.size()]); // CodeableConcept
        case 1943566508: /*referenceStrength*/ return this.referenceStrength == null ? new Base[0] : this.referenceStrength.toArray(new Base[this.referenceStrength.size()]); // IngredientSubstanceStrengthReferenceStrengthComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 696975130: // presentation
          this.presentation = TypeConvertor.castToType(value); // DataType
          return value;
        case -799720217: // textPresentation
          this.textPresentation = TypeConvertor.castToString(value); // StringType
          return value;
        case -410557331: // concentration
          this.concentration = TypeConvertor.castToType(value); // DataType
          return value;
        case 436527168: // textConcentration
          this.textConcentration = TypeConvertor.castToString(value); // StringType
          return value;
        case 93508670: // basis
          this.basis = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 235437876: // measurementPoint
          this.measurementPoint = TypeConvertor.castToString(value); // StringType
          return value;
        case 957831062: // country
          this.getCountry().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1943566508: // referenceStrength
          this.getReferenceStrength().add((IngredientSubstanceStrengthReferenceStrengthComponent) value); // IngredientSubstanceStrengthReferenceStrengthComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("presentation[x]")) {
          this.presentation = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("textPresentation")) {
          this.textPresentation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("concentration[x]")) {
          this.concentration = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("textConcentration")) {
          this.textConcentration = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("basis")) {
          this.basis = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("measurementPoint")) {
          this.measurementPoint = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("country")) {
          this.getCountry().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("referenceStrength")) {
          this.getReferenceStrength().add((IngredientSubstanceStrengthReferenceStrengthComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1714280230:  return getPresentation();
        case 696975130:  return getPresentation();
        case -799720217:  return getTextPresentationElement();
        case 1153502451:  return getConcentration();
        case -410557331:  return getConcentration();
        case 436527168:  return getTextConcentrationElement();
        case 93508670:  return getBasis();
        case 235437876:  return getMeasurementPointElement();
        case 957831062:  return addCountry(); 
        case 1943566508:  return addReferenceStrength(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 696975130: /*presentation*/ return new String[] {"Ratio", "RatioRange", "CodeableConcept", "Quantity"};
        case -799720217: /*textPresentation*/ return new String[] {"string"};
        case -410557331: /*concentration*/ return new String[] {"Ratio", "RatioRange", "CodeableConcept", "Quantity"};
        case 436527168: /*textConcentration*/ return new String[] {"string"};
        case 93508670: /*basis*/ return new String[] {"CodeableConcept"};
        case 235437876: /*measurementPoint*/ return new String[] {"string"};
        case 957831062: /*country*/ return new String[] {"CodeableConcept"};
        case 1943566508: /*referenceStrength*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("presentationRatio")) {
          this.presentation = new Ratio();
          return this.presentation;
        }
        else if (name.equals("presentationRatioRange")) {
          this.presentation = new RatioRange();
          return this.presentation;
        }
        else if (name.equals("presentationCodeableConcept")) {
          this.presentation = new CodeableConcept();
          return this.presentation;
        }
        else if (name.equals("presentationQuantity")) {
          this.presentation = new Quantity();
          return this.presentation;
        }
        else if (name.equals("textPresentation")) {
          throw new FHIRException("Cannot call addChild on a singleton property Ingredient.substance.strength.textPresentation");
        }
        else if (name.equals("concentrationRatio")) {
          this.concentration = new Ratio();
          return this.concentration;
        }
        else if (name.equals("concentrationRatioRange")) {
          this.concentration = new RatioRange();
          return this.concentration;
        }
        else if (name.equals("concentrationCodeableConcept")) {
          this.concentration = new CodeableConcept();
          return this.concentration;
        }
        else if (name.equals("concentrationQuantity")) {
          this.concentration = new Quantity();
          return this.concentration;
        }
        else if (name.equals("textConcentration")) {
          throw new FHIRException("Cannot call addChild on a singleton property Ingredient.substance.strength.textConcentration");
        }
        else if (name.equals("basis")) {
          this.basis = new CodeableConcept();
          return this.basis;
        }
        else if (name.equals("measurementPoint")) {
          throw new FHIRException("Cannot call addChild on a singleton property Ingredient.substance.strength.measurementPoint");
        }
        else if (name.equals("country")) {
          return addCountry();
        }
        else if (name.equals("referenceStrength")) {
          return addReferenceStrength();
        }
        else
          return super.addChild(name);
      }

      public IngredientSubstanceStrengthComponent copy() {
        IngredientSubstanceStrengthComponent dst = new IngredientSubstanceStrengthComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(IngredientSubstanceStrengthComponent dst) {
        super.copyValues(dst);
        dst.presentation = presentation == null ? null : presentation.copy();
        dst.textPresentation = textPresentation == null ? null : textPresentation.copy();
        dst.concentration = concentration == null ? null : concentration.copy();
        dst.textConcentration = textConcentration == null ? null : textConcentration.copy();
        dst.basis = basis == null ? null : basis.copy();
        dst.measurementPoint = measurementPoint == null ? null : measurementPoint.copy();
        if (country != null) {
          dst.country = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : country)
            dst.country.add(i.copy());
        };
        if (referenceStrength != null) {
          dst.referenceStrength = new ArrayList<IngredientSubstanceStrengthReferenceStrengthComponent>();
          for (IngredientSubstanceStrengthReferenceStrengthComponent i : referenceStrength)
            dst.referenceStrength.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof IngredientSubstanceStrengthComponent))
          return false;
        IngredientSubstanceStrengthComponent o = (IngredientSubstanceStrengthComponent) other_;
        return compareDeep(presentation, o.presentation, true) && compareDeep(textPresentation, o.textPresentation, true)
           && compareDeep(concentration, o.concentration, true) && compareDeep(textConcentration, o.textConcentration, true)
           && compareDeep(basis, o.basis, true) && compareDeep(measurementPoint, o.measurementPoint, true)
           && compareDeep(country, o.country, true) && compareDeep(referenceStrength, o.referenceStrength, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof IngredientSubstanceStrengthComponent))
          return false;
        IngredientSubstanceStrengthComponent o = (IngredientSubstanceStrengthComponent) other_;
        return compareValues(textPresentation, o.textPresentation, true) && compareValues(textConcentration, o.textConcentration, true)
           && compareValues(measurementPoint, o.measurementPoint, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(presentation, textPresentation
          , concentration, textConcentration, basis, measurementPoint, country, referenceStrength
          );
      }

  public String fhirType() {
    return "Ingredient.substance.strength";

  }

  }

    @Block()
    public static class IngredientSubstanceStrengthReferenceStrengthComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Relevant reference substance.
         */
        @Child(name = "substance", type = {CodeableReference.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Relevant reference substance", formalDefinition="Relevant reference substance." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/substance-codes")
        protected CodeableReference substance;

        /**
         * Strength expressed in terms of a reference substance.
         */
        @Child(name = "strength", type = {Ratio.class, RatioRange.class, Quantity.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Strength expressed in terms of a reference substance", formalDefinition="Strength expressed in terms of a reference substance." )
        protected DataType strength;

        /**
         * For when strength is measured at a particular point or distance.
         */
        @Child(name = "measurementPoint", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="When strength is measured at a particular point or distance", formalDefinition="For when strength is measured at a particular point or distance." )
        protected StringType measurementPoint;

        /**
         * The country or countries for which the strength range applies.
         */
        @Child(name = "country", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Where the strength range applies", formalDefinition="The country or countries for which the strength range applies." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/country")
        protected List<CodeableConcept> country;

        private static final long serialVersionUID = 1700529245L;

    /**
     * Constructor
     */
      public IngredientSubstanceStrengthReferenceStrengthComponent() {
        super();
      }

    /**
     * Constructor
     */
      public IngredientSubstanceStrengthReferenceStrengthComponent(CodeableReference substance, DataType strength) {
        super();
        this.setSubstance(substance);
        this.setStrength(strength);
      }

        /**
         * @return {@link #substance} (Relevant reference substance.)
         */
        public CodeableReference getSubstance() { 
          if (this.substance == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthReferenceStrengthComponent.substance");
            else if (Configuration.doAutoCreate())
              this.substance = new CodeableReference(); // cc
          return this.substance;
        }

        public boolean hasSubstance() { 
          return this.substance != null && !this.substance.isEmpty();
        }

        /**
         * @param value {@link #substance} (Relevant reference substance.)
         */
        public IngredientSubstanceStrengthReferenceStrengthComponent setSubstance(CodeableReference value) { 
          this.substance = value;
          return this;
        }

        /**
         * @return {@link #strength} (Strength expressed in terms of a reference substance.)
         */
        public DataType getStrength() { 
          return this.strength;
        }

        /**
         * @return {@link #strength} (Strength expressed in terms of a reference substance.)
         */
        public Ratio getStrengthRatio() throws FHIRException { 
          if (this.strength == null)
            this.strength = new Ratio();
          if (!(this.strength instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.strength.getClass().getName()+" was encountered");
          return (Ratio) this.strength;
        }

        public boolean hasStrengthRatio() { 
          return this != null && this.strength instanceof Ratio;
        }

        /**
         * @return {@link #strength} (Strength expressed in terms of a reference substance.)
         */
        public RatioRange getStrengthRatioRange() throws FHIRException { 
          if (this.strength == null)
            this.strength = new RatioRange();
          if (!(this.strength instanceof RatioRange))
            throw new FHIRException("Type mismatch: the type RatioRange was expected, but "+this.strength.getClass().getName()+" was encountered");
          return (RatioRange) this.strength;
        }

        public boolean hasStrengthRatioRange() { 
          return this != null && this.strength instanceof RatioRange;
        }

        /**
         * @return {@link #strength} (Strength expressed in terms of a reference substance.)
         */
        public Quantity getStrengthQuantity() throws FHIRException { 
          if (this.strength == null)
            this.strength = new Quantity();
          if (!(this.strength instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.strength.getClass().getName()+" was encountered");
          return (Quantity) this.strength;
        }

        public boolean hasStrengthQuantity() { 
          return this != null && this.strength instanceof Quantity;
        }

        public boolean hasStrength() { 
          return this.strength != null && !this.strength.isEmpty();
        }

        /**
         * @param value {@link #strength} (Strength expressed in terms of a reference substance.)
         */
        public IngredientSubstanceStrengthReferenceStrengthComponent setStrength(DataType value) { 
          if (value != null && !(value instanceof Ratio || value instanceof RatioRange || value instanceof Quantity))
            throw new FHIRException("Not the right type for Ingredient.substance.strength.referenceStrength.strength[x]: "+value.fhirType());
          this.strength = value;
          return this;
        }

        /**
         * @return {@link #measurementPoint} (For when strength is measured at a particular point or distance.). This is the underlying object with id, value and extensions. The accessor "getMeasurementPoint" gives direct access to the value
         */
        public StringType getMeasurementPointElement() { 
          if (this.measurementPoint == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthReferenceStrengthComponent.measurementPoint");
            else if (Configuration.doAutoCreate())
              this.measurementPoint = new StringType(); // bb
          return this.measurementPoint;
        }

        public boolean hasMeasurementPointElement() { 
          return this.measurementPoint != null && !this.measurementPoint.isEmpty();
        }

        public boolean hasMeasurementPoint() { 
          return this.measurementPoint != null && !this.measurementPoint.isEmpty();
        }

        /**
         * @param value {@link #measurementPoint} (For when strength is measured at a particular point or distance.). This is the underlying object with id, value and extensions. The accessor "getMeasurementPoint" gives direct access to the value
         */
        public IngredientSubstanceStrengthReferenceStrengthComponent setMeasurementPointElement(StringType value) { 
          this.measurementPoint = value;
          return this;
        }

        /**
         * @return For when strength is measured at a particular point or distance.
         */
        public String getMeasurementPoint() { 
          return this.measurementPoint == null ? null : this.measurementPoint.getValue();
        }

        /**
         * @param value For when strength is measured at a particular point or distance.
         */
        public IngredientSubstanceStrengthReferenceStrengthComponent setMeasurementPoint(String value) { 
          if (Utilities.noString(value))
            this.measurementPoint = null;
          else {
            if (this.measurementPoint == null)
              this.measurementPoint = new StringType();
            this.measurementPoint.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #country} (The country or countries for which the strength range applies.)
         */
        public List<CodeableConcept> getCountry() { 
          if (this.country == null)
            this.country = new ArrayList<CodeableConcept>();
          return this.country;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public IngredientSubstanceStrengthReferenceStrengthComponent setCountry(List<CodeableConcept> theCountry) { 
          this.country = theCountry;
          return this;
        }

        public boolean hasCountry() { 
          if (this.country == null)
            return false;
          for (CodeableConcept item : this.country)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addCountry() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.country == null)
            this.country = new ArrayList<CodeableConcept>();
          this.country.add(t);
          return t;
        }

        public IngredientSubstanceStrengthReferenceStrengthComponent addCountry(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.country == null)
            this.country = new ArrayList<CodeableConcept>();
          this.country.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #country}, creating it if it does not already exist {3}
         */
        public CodeableConcept getCountryFirstRep() { 
          if (getCountry().isEmpty()) {
            addCountry();
          }
          return getCountry().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("substance", "CodeableReference(SubstanceDefinition)", "Relevant reference substance.", 0, 1, substance));
          children.add(new Property("strength[x]", "Ratio|RatioRange|Quantity", "Strength expressed in terms of a reference substance.", 0, 1, strength));
          children.add(new Property("measurementPoint", "string", "For when strength is measured at a particular point or distance.", 0, 1, measurementPoint));
          children.add(new Property("country", "CodeableConcept", "The country or countries for which the strength range applies.", 0, java.lang.Integer.MAX_VALUE, country));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 530040176: /*substance*/  return new Property("substance", "CodeableReference(SubstanceDefinition)", "Relevant reference substance.", 0, 1, substance);
          case 127377567: /*strength[x]*/  return new Property("strength[x]", "Ratio|RatioRange|Quantity", "Strength expressed in terms of a reference substance.", 0, 1, strength);
          case 1791316033: /*strength*/  return new Property("strength[x]", "Ratio|RatioRange|Quantity", "Strength expressed in terms of a reference substance.", 0, 1, strength);
          case 2141786186: /*strengthRatio*/  return new Property("strength[x]", "Ratio", "Strength expressed in terms of a reference substance.", 0, 1, strength);
          case -1300703469: /*strengthRatioRange*/  return new Property("strength[x]", "RatioRange", "Strength expressed in terms of a reference substance.", 0, 1, strength);
          case -1793570836: /*strengthQuantity*/  return new Property("strength[x]", "Quantity", "Strength expressed in terms of a reference substance.", 0, 1, strength);
          case 235437876: /*measurementPoint*/  return new Property("measurementPoint", "string", "For when strength is measured at a particular point or distance.", 0, 1, measurementPoint);
          case 957831062: /*country*/  return new Property("country", "CodeableConcept", "The country or countries for which the strength range applies.", 0, java.lang.Integer.MAX_VALUE, country);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 530040176: /*substance*/ return this.substance == null ? new Base[0] : new Base[] {this.substance}; // CodeableReference
        case 1791316033: /*strength*/ return this.strength == null ? new Base[0] : new Base[] {this.strength}; // DataType
        case 235437876: /*measurementPoint*/ return this.measurementPoint == null ? new Base[0] : new Base[] {this.measurementPoint}; // StringType
        case 957831062: /*country*/ return this.country == null ? new Base[0] : this.country.toArray(new Base[this.country.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 530040176: // substance
          this.substance = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 1791316033: // strength
          this.strength = TypeConvertor.castToType(value); // DataType
          return value;
        case 235437876: // measurementPoint
          this.measurementPoint = TypeConvertor.castToString(value); // StringType
          return value;
        case 957831062: // country
          this.getCountry().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("substance")) {
          this.substance = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("strength[x]")) {
          this.strength = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("measurementPoint")) {
          this.measurementPoint = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("country")) {
          this.getCountry().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 530040176:  return getSubstance();
        case 127377567:  return getStrength();
        case 1791316033:  return getStrength();
        case 235437876:  return getMeasurementPointElement();
        case 957831062:  return addCountry(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 530040176: /*substance*/ return new String[] {"CodeableReference"};
        case 1791316033: /*strength*/ return new String[] {"Ratio", "RatioRange", "Quantity"};
        case 235437876: /*measurementPoint*/ return new String[] {"string"};
        case 957831062: /*country*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("substance")) {
          this.substance = new CodeableReference();
          return this.substance;
        }
        else if (name.equals("strengthRatio")) {
          this.strength = new Ratio();
          return this.strength;
        }
        else if (name.equals("strengthRatioRange")) {
          this.strength = new RatioRange();
          return this.strength;
        }
        else if (name.equals("strengthQuantity")) {
          this.strength = new Quantity();
          return this.strength;
        }
        else if (name.equals("measurementPoint")) {
          throw new FHIRException("Cannot call addChild on a singleton property Ingredient.substance.strength.referenceStrength.measurementPoint");
        }
        else if (name.equals("country")) {
          return addCountry();
        }
        else
          return super.addChild(name);
      }

      public IngredientSubstanceStrengthReferenceStrengthComponent copy() {
        IngredientSubstanceStrengthReferenceStrengthComponent dst = new IngredientSubstanceStrengthReferenceStrengthComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(IngredientSubstanceStrengthReferenceStrengthComponent dst) {
        super.copyValues(dst);
        dst.substance = substance == null ? null : substance.copy();
        dst.strength = strength == null ? null : strength.copy();
        dst.measurementPoint = measurementPoint == null ? null : measurementPoint.copy();
        if (country != null) {
          dst.country = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : country)
            dst.country.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof IngredientSubstanceStrengthReferenceStrengthComponent))
          return false;
        IngredientSubstanceStrengthReferenceStrengthComponent o = (IngredientSubstanceStrengthReferenceStrengthComponent) other_;
        return compareDeep(substance, o.substance, true) && compareDeep(strength, o.strength, true) && compareDeep(measurementPoint, o.measurementPoint, true)
           && compareDeep(country, o.country, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof IngredientSubstanceStrengthReferenceStrengthComponent))
          return false;
        IngredientSubstanceStrengthReferenceStrengthComponent o = (IngredientSubstanceStrengthReferenceStrengthComponent) other_;
        return compareValues(measurementPoint, o.measurementPoint, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(substance, strength, measurementPoint
          , country);
      }

  public String fhirType() {
    return "Ingredient.substance.strength.referenceStrength";

  }

  }

    /**
     * The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="An identifier or code by which the ingredient can be referenced", formalDefinition="The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate." )
    protected Identifier identifier;

    /**
     * The status of this ingredient. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=1, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this ingredient. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * The product which this ingredient is a constituent part of.
     */
    @Child(name = "for", type = {MedicinalProductDefinition.class, AdministrableProductDefinition.class, ManufacturedItemDefinition.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The product which this ingredient is a constituent part of", formalDefinition="The product which this ingredient is a constituent part of." )
    protected List<Reference> for_;

    /**
     * A classification of the ingredient identifying its purpose within the product, e.g. active, inactive.
     */
    @Child(name = "role", type = {CodeableConcept.class}, order=3, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Purpose of the ingredient within the product, e.g. active, inactive", formalDefinition="A classification of the ingredient identifying its purpose within the product, e.g. active, inactive." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/ingredient-role")
    protected CodeableConcept role;

    /**
     * A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: antioxidant, alkalizing agent.
     */
    @Child(name = "function", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Precise action within the drug product, e.g. antioxidant, alkalizing agent", formalDefinition="A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: antioxidant, alkalizing agent." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/ingredient-function")
    protected List<CodeableConcept> function;

    /**
     * A classification of the ingredient according to where in the physical item it tends to be used, such the outer shell of a tablet, inner body or ink.
     */
    @Child(name = "group", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A classification of the ingredient according to where in the physical item it tends to be used, such the outer shell of a tablet, inner body or ink", formalDefinition="A classification of the ingredient according to where in the physical item it tends to be used, such the outer shell of a tablet, inner body or ink." )
    protected CodeableConcept group;

    /**
     * If the ingredient is a known or suspected allergen. Note that this is a property of the substance, so if a reference to a SubstanceDefinition is used to decribe that (rather than just a code), the allergen information should go there, not here.
     */
    @Child(name = "allergenicIndicator", type = {BooleanType.class}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If the ingredient is a known or suspected allergen", formalDefinition="If the ingredient is a known or suspected allergen. Note that this is a property of the substance, so if a reference to a SubstanceDefinition is used to decribe that (rather than just a code), the allergen information should go there, not here." )
    protected BooleanType allergenicIndicator;

    /**
     * A place for providing any notes that are relevant to the component, e.g. removed during process, adjusted for loss on drying.
     */
    @Child(name = "comment", type = {MarkdownType.class}, order=7, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="A place for providing any notes that are relevant to the component, e.g. removed during process, adjusted for loss on drying", formalDefinition="A place for providing any notes that are relevant to the component, e.g. removed during process, adjusted for loss on drying." )
    protected MarkdownType comment;

    /**
     * The organization(s) that manufacture this ingredient. Can be used to indicate:         1) Organizations we are aware of that manufacture this ingredient         2) Specific Manufacturer(s) currently being used         3) Set of organisations allowed to manufacture this ingredient for this product         Users must be clear on the application of context relevant to their use case.
     */
    @Child(name = "manufacturer", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="An organization that manufactures this ingredient", formalDefinition="The organization(s) that manufacture this ingredient. Can be used to indicate:         1) Organizations we are aware of that manufacture this ingredient         2) Specific Manufacturer(s) currently being used         3) Set of organisations allowed to manufacture this ingredient for this product         Users must be clear on the application of context relevant to their use case." )
    protected List<IngredientManufacturerComponent> manufacturer;

    /**
     * The substance that comprises this ingredient.
     */
    @Child(name = "substance", type = {}, order=9, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The substance that comprises this ingredient", formalDefinition="The substance that comprises this ingredient." )
    protected IngredientSubstanceComponent substance;

    private static final long serialVersionUID = 701648703L;

  /**
   * Constructor
   */
    public Ingredient() {
      super();
    }

  /**
   * Constructor
   */
    public Ingredient(PublicationStatus status, CodeableConcept role, IngredientSubstanceComponent substance) {
      super();
      this.setStatus(status);
      this.setRole(role);
      this.setSubstance(substance);
    }

    /**
     * @return {@link #identifier} (The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate.)
     */
    public Identifier getIdentifier() { 
      if (this.identifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Ingredient.identifier");
        else if (Configuration.doAutoCreate())
          this.identifier = new Identifier(); // cc
      return this.identifier;
    }

    public boolean hasIdentifier() { 
      return this.identifier != null && !this.identifier.isEmpty();
    }

    /**
     * @param value {@link #identifier} (The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate.)
     */
    public Ingredient setIdentifier(Identifier value) { 
      this.identifier = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of this ingredient. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Ingredient.status");
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
     * @param value {@link #status} (The status of this ingredient. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Ingredient setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this ingredient. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this ingredient. Enables tracking the life-cycle of the content.
     */
    public Ingredient setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #for_} (The product which this ingredient is a constituent part of.)
     */
    public List<Reference> getFor() { 
      if (this.for_ == null)
        this.for_ = new ArrayList<Reference>();
      return this.for_;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Ingredient setFor(List<Reference> theFor) { 
      this.for_ = theFor;
      return this;
    }

    public boolean hasFor() { 
      if (this.for_ == null)
        return false;
      for (Reference item : this.for_)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addFor() { //3
      Reference t = new Reference();
      if (this.for_ == null)
        this.for_ = new ArrayList<Reference>();
      this.for_.add(t);
      return t;
    }

    public Ingredient addFor(Reference t) { //3
      if (t == null)
        return this;
      if (this.for_ == null)
        this.for_ = new ArrayList<Reference>();
      this.for_.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #for_}, creating it if it does not already exist {3}
     */
    public Reference getForFirstRep() { 
      if (getFor().isEmpty()) {
        addFor();
      }
      return getFor().get(0);
    }

    /**
     * @return {@link #role} (A classification of the ingredient identifying its purpose within the product, e.g. active, inactive.)
     */
    public CodeableConcept getRole() { 
      if (this.role == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Ingredient.role");
        else if (Configuration.doAutoCreate())
          this.role = new CodeableConcept(); // cc
      return this.role;
    }

    public boolean hasRole() { 
      return this.role != null && !this.role.isEmpty();
    }

    /**
     * @param value {@link #role} (A classification of the ingredient identifying its purpose within the product, e.g. active, inactive.)
     */
    public Ingredient setRole(CodeableConcept value) { 
      this.role = value;
      return this;
    }

    /**
     * @return {@link #function} (A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: antioxidant, alkalizing agent.)
     */
    public List<CodeableConcept> getFunction() { 
      if (this.function == null)
        this.function = new ArrayList<CodeableConcept>();
      return this.function;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Ingredient setFunction(List<CodeableConcept> theFunction) { 
      this.function = theFunction;
      return this;
    }

    public boolean hasFunction() { 
      if (this.function == null)
        return false;
      for (CodeableConcept item : this.function)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addFunction() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.function == null)
        this.function = new ArrayList<CodeableConcept>();
      this.function.add(t);
      return t;
    }

    public Ingredient addFunction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.function == null)
        this.function = new ArrayList<CodeableConcept>();
      this.function.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #function}, creating it if it does not already exist {3}
     */
    public CodeableConcept getFunctionFirstRep() { 
      if (getFunction().isEmpty()) {
        addFunction();
      }
      return getFunction().get(0);
    }

    /**
     * @return {@link #group} (A classification of the ingredient according to where in the physical item it tends to be used, such the outer shell of a tablet, inner body or ink.)
     */
    public CodeableConcept getGroup() { 
      if (this.group == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Ingredient.group");
        else if (Configuration.doAutoCreate())
          this.group = new CodeableConcept(); // cc
      return this.group;
    }

    public boolean hasGroup() { 
      return this.group != null && !this.group.isEmpty();
    }

    /**
     * @param value {@link #group} (A classification of the ingredient according to where in the physical item it tends to be used, such the outer shell of a tablet, inner body or ink.)
     */
    public Ingredient setGroup(CodeableConcept value) { 
      this.group = value;
      return this;
    }

    /**
     * @return {@link #allergenicIndicator} (If the ingredient is a known or suspected allergen. Note that this is a property of the substance, so if a reference to a SubstanceDefinition is used to decribe that (rather than just a code), the allergen information should go there, not here.). This is the underlying object with id, value and extensions. The accessor "getAllergenicIndicator" gives direct access to the value
     */
    public BooleanType getAllergenicIndicatorElement() { 
      if (this.allergenicIndicator == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Ingredient.allergenicIndicator");
        else if (Configuration.doAutoCreate())
          this.allergenicIndicator = new BooleanType(); // bb
      return this.allergenicIndicator;
    }

    public boolean hasAllergenicIndicatorElement() { 
      return this.allergenicIndicator != null && !this.allergenicIndicator.isEmpty();
    }

    public boolean hasAllergenicIndicator() { 
      return this.allergenicIndicator != null && !this.allergenicIndicator.isEmpty();
    }

    /**
     * @param value {@link #allergenicIndicator} (If the ingredient is a known or suspected allergen. Note that this is a property of the substance, so if a reference to a SubstanceDefinition is used to decribe that (rather than just a code), the allergen information should go there, not here.). This is the underlying object with id, value and extensions. The accessor "getAllergenicIndicator" gives direct access to the value
     */
    public Ingredient setAllergenicIndicatorElement(BooleanType value) { 
      this.allergenicIndicator = value;
      return this;
    }

    /**
     * @return If the ingredient is a known or suspected allergen. Note that this is a property of the substance, so if a reference to a SubstanceDefinition is used to decribe that (rather than just a code), the allergen information should go there, not here.
     */
    public boolean getAllergenicIndicator() { 
      return this.allergenicIndicator == null || this.allergenicIndicator.isEmpty() ? false : this.allergenicIndicator.getValue();
    }

    /**
     * @param value If the ingredient is a known or suspected allergen. Note that this is a property of the substance, so if a reference to a SubstanceDefinition is used to decribe that (rather than just a code), the allergen information should go there, not here.
     */
    public Ingredient setAllergenicIndicator(boolean value) { 
        if (this.allergenicIndicator == null)
          this.allergenicIndicator = new BooleanType();
        this.allergenicIndicator.setValue(value);
      return this;
    }

    /**
     * @return {@link #comment} (A place for providing any notes that are relevant to the component, e.g. removed during process, adjusted for loss on drying.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public MarkdownType getCommentElement() { 
      if (this.comment == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Ingredient.comment");
        else if (Configuration.doAutoCreate())
          this.comment = new MarkdownType(); // bb
      return this.comment;
    }

    public boolean hasCommentElement() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    public boolean hasComment() { 
      return this.comment != null && !this.comment.isEmpty();
    }

    /**
     * @param value {@link #comment} (A place for providing any notes that are relevant to the component, e.g. removed during process, adjusted for loss on drying.). This is the underlying object with id, value and extensions. The accessor "getComment" gives direct access to the value
     */
    public Ingredient setCommentElement(MarkdownType value) { 
      this.comment = value;
      return this;
    }

    /**
     * @return A place for providing any notes that are relevant to the component, e.g. removed during process, adjusted for loss on drying.
     */
    public String getComment() { 
      return this.comment == null ? null : this.comment.getValue();
    }

    /**
     * @param value A place for providing any notes that are relevant to the component, e.g. removed during process, adjusted for loss on drying.
     */
    public Ingredient setComment(String value) { 
      if (Utilities.noString(value))
        this.comment = null;
      else {
        if (this.comment == null)
          this.comment = new MarkdownType();
        this.comment.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #manufacturer} (The organization(s) that manufacture this ingredient. Can be used to indicate:         1) Organizations we are aware of that manufacture this ingredient         2) Specific Manufacturer(s) currently being used         3) Set of organisations allowed to manufacture this ingredient for this product         Users must be clear on the application of context relevant to their use case.)
     */
    public List<IngredientManufacturerComponent> getManufacturer() { 
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<IngredientManufacturerComponent>();
      return this.manufacturer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Ingredient setManufacturer(List<IngredientManufacturerComponent> theManufacturer) { 
      this.manufacturer = theManufacturer;
      return this;
    }

    public boolean hasManufacturer() { 
      if (this.manufacturer == null)
        return false;
      for (IngredientManufacturerComponent item : this.manufacturer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public IngredientManufacturerComponent addManufacturer() { //3
      IngredientManufacturerComponent t = new IngredientManufacturerComponent();
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<IngredientManufacturerComponent>();
      this.manufacturer.add(t);
      return t;
    }

    public Ingredient addManufacturer(IngredientManufacturerComponent t) { //3
      if (t == null)
        return this;
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<IngredientManufacturerComponent>();
      this.manufacturer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #manufacturer}, creating it if it does not already exist {3}
     */
    public IngredientManufacturerComponent getManufacturerFirstRep() { 
      if (getManufacturer().isEmpty()) {
        addManufacturer();
      }
      return getManufacturer().get(0);
    }

    /**
     * @return {@link #substance} (The substance that comprises this ingredient.)
     */
    public IngredientSubstanceComponent getSubstance() { 
      if (this.substance == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Ingredient.substance");
        else if (Configuration.doAutoCreate())
          this.substance = new IngredientSubstanceComponent(); // cc
      return this.substance;
    }

    public boolean hasSubstance() { 
      return this.substance != null && !this.substance.isEmpty();
    }

    /**
     * @param value {@link #substance} (The substance that comprises this ingredient.)
     */
    public Ingredient setSubstance(IngredientSubstanceComponent value) { 
      this.substance = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate.", 0, 1, identifier));
        children.add(new Property("status", "code", "The status of this ingredient. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("for", "Reference(MedicinalProductDefinition|AdministrableProductDefinition|ManufacturedItemDefinition)", "The product which this ingredient is a constituent part of.", 0, java.lang.Integer.MAX_VALUE, for_));
        children.add(new Property("role", "CodeableConcept", "A classification of the ingredient identifying its purpose within the product, e.g. active, inactive.", 0, 1, role));
        children.add(new Property("function", "CodeableConcept", "A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: antioxidant, alkalizing agent.", 0, java.lang.Integer.MAX_VALUE, function));
        children.add(new Property("group", "CodeableConcept", "A classification of the ingredient according to where in the physical item it tends to be used, such the outer shell of a tablet, inner body or ink.", 0, 1, group));
        children.add(new Property("allergenicIndicator", "boolean", "If the ingredient is a known or suspected allergen. Note that this is a property of the substance, so if a reference to a SubstanceDefinition is used to decribe that (rather than just a code), the allergen information should go there, not here.", 0, 1, allergenicIndicator));
        children.add(new Property("comment", "markdown", "A place for providing any notes that are relevant to the component, e.g. removed during process, adjusted for loss on drying.", 0, 1, comment));
        children.add(new Property("manufacturer", "", "The organization(s) that manufacture this ingredient. Can be used to indicate:         1) Organizations we are aware of that manufacture this ingredient         2) Specific Manufacturer(s) currently being used         3) Set of organisations allowed to manufacture this ingredient for this product         Users must be clear on the application of context relevant to their use case.", 0, java.lang.Integer.MAX_VALUE, manufacturer));
        children.add(new Property("substance", "", "The substance that comprises this ingredient.", 0, 1, substance));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate.", 0, 1, identifier);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this ingredient. Enables tracking the life-cycle of the content.", 0, 1, status);
        case 101577: /*for*/  return new Property("for", "Reference(MedicinalProductDefinition|AdministrableProductDefinition|ManufacturedItemDefinition)", "The product which this ingredient is a constituent part of.", 0, java.lang.Integer.MAX_VALUE, for_);
        case 3506294: /*role*/  return new Property("role", "CodeableConcept", "A classification of the ingredient identifying its purpose within the product, e.g. active, inactive.", 0, 1, role);
        case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: antioxidant, alkalizing agent.", 0, java.lang.Integer.MAX_VALUE, function);
        case 98629247: /*group*/  return new Property("group", "CodeableConcept", "A classification of the ingredient according to where in the physical item it tends to be used, such the outer shell of a tablet, inner body or ink.", 0, 1, group);
        case 75406931: /*allergenicIndicator*/  return new Property("allergenicIndicator", "boolean", "If the ingredient is a known or suspected allergen. Note that this is a property of the substance, so if a reference to a SubstanceDefinition is used to decribe that (rather than just a code), the allergen information should go there, not here.", 0, 1, allergenicIndicator);
        case 950398559: /*comment*/  return new Property("comment", "markdown", "A place for providing any notes that are relevant to the component, e.g. removed during process, adjusted for loss on drying.", 0, 1, comment);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "", "The organization(s) that manufacture this ingredient. Can be used to indicate:         1) Organizations we are aware of that manufacture this ingredient         2) Specific Manufacturer(s) currently being used         3) Set of organisations allowed to manufacture this ingredient for this product         Users must be clear on the application of context relevant to their use case.", 0, java.lang.Integer.MAX_VALUE, manufacturer);
        case 530040176: /*substance*/  return new Property("substance", "", "The substance that comprises this ingredient.", 0, 1, substance);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case 101577: /*for*/ return this.for_ == null ? new Base[0] : this.for_.toArray(new Base[this.for_.size()]); // Reference
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : this.function.toArray(new Base[this.function.size()]); // CodeableConcept
        case 98629247: /*group*/ return this.group == null ? new Base[0] : new Base[] {this.group}; // CodeableConcept
        case 75406931: /*allergenicIndicator*/ return this.allergenicIndicator == null ? new Base[0] : new Base[] {this.allergenicIndicator}; // BooleanType
        case 950398559: /*comment*/ return this.comment == null ? new Base[0] : new Base[] {this.comment}; // MarkdownType
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // IngredientManufacturerComponent
        case 530040176: /*substance*/ return this.substance == null ? new Base[0] : new Base[] {this.substance}; // IngredientSubstanceComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case 101577: // for
          this.getFor().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1380938712: // function
          this.getFunction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 98629247: // group
          this.group = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 75406931: // allergenicIndicator
          this.allergenicIndicator = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 950398559: // comment
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1969347631: // manufacturer
          this.getManufacturer().add((IngredientManufacturerComponent) value); // IngredientManufacturerComponent
          return value;
        case 530040176: // substance
          this.substance = (IngredientSubstanceComponent) value; // IngredientSubstanceComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("for")) {
          this.getFor().add(TypeConvertor.castToReference(value));
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("function")) {
          this.getFunction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("group")) {
          this.group = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("allergenicIndicator")) {
          this.allergenicIndicator = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("comment")) {
          this.comment = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add((IngredientManufacturerComponent) value);
        } else if (name.equals("substance")) {
          this.substance = (IngredientSubstanceComponent) value; // IngredientSubstanceComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return getIdentifier();
        case -892481550:  return getStatusElement();
        case 101577:  return addFor(); 
        case 3506294:  return getRole();
        case 1380938712:  return addFunction(); 
        case 98629247:  return getGroup();
        case 75406931:  return getAllergenicIndicatorElement();
        case 950398559:  return getCommentElement();
        case -1969347631:  return addManufacturer(); 
        case 530040176:  return getSubstance();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case 101577: /*for*/ return new String[] {"Reference"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case 98629247: /*group*/ return new String[] {"CodeableConcept"};
        case 75406931: /*allergenicIndicator*/ return new String[] {"boolean"};
        case 950398559: /*comment*/ return new String[] {"markdown"};
        case -1969347631: /*manufacturer*/ return new String[] {};
        case 530040176: /*substance*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property Ingredient.status");
        }
        else if (name.equals("for")) {
          return addFor();
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("function")) {
          return addFunction();
        }
        else if (name.equals("group")) {
          this.group = new CodeableConcept();
          return this.group;
        }
        else if (name.equals("allergenicIndicator")) {
          throw new FHIRException("Cannot call addChild on a singleton property Ingredient.allergenicIndicator");
        }
        else if (name.equals("comment")) {
          throw new FHIRException("Cannot call addChild on a singleton property Ingredient.comment");
        }
        else if (name.equals("manufacturer")) {
          return addManufacturer();
        }
        else if (name.equals("substance")) {
          this.substance = new IngredientSubstanceComponent();
          return this.substance;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "Ingredient";

  }

      public Ingredient copy() {
        Ingredient dst = new Ingredient();
        copyValues(dst);
        return dst;
      }

      public void copyValues(Ingredient dst) {
        super.copyValues(dst);
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.status = status == null ? null : status.copy();
        if (for_ != null) {
          dst.for_ = new ArrayList<Reference>();
          for (Reference i : for_)
            dst.for_.add(i.copy());
        };
        dst.role = role == null ? null : role.copy();
        if (function != null) {
          dst.function = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : function)
            dst.function.add(i.copy());
        };
        dst.group = group == null ? null : group.copy();
        dst.allergenicIndicator = allergenicIndicator == null ? null : allergenicIndicator.copy();
        dst.comment = comment == null ? null : comment.copy();
        if (manufacturer != null) {
          dst.manufacturer = new ArrayList<IngredientManufacturerComponent>();
          for (IngredientManufacturerComponent i : manufacturer)
            dst.manufacturer.add(i.copy());
        };
        dst.substance = substance == null ? null : substance.copy();
      }

      protected Ingredient typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof Ingredient))
          return false;
        Ingredient o = (Ingredient) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(status, o.status, true) && compareDeep(for_, o.for_, true)
           && compareDeep(role, o.role, true) && compareDeep(function, o.function, true) && compareDeep(group, o.group, true)
           && compareDeep(allergenicIndicator, o.allergenicIndicator, true) && compareDeep(comment, o.comment, true)
           && compareDeep(manufacturer, o.manufacturer, true) && compareDeep(substance, o.substance, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Ingredient))
          return false;
        Ingredient o = (Ingredient) other_;
        return compareValues(status, o.status, true) && compareValues(allergenicIndicator, o.allergenicIndicator, true)
           && compareValues(comment, o.comment, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, status, for_
          , role, function, group, allergenicIndicator, comment, manufacturer, substance
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Ingredient;
   }

 /**
   * Search parameter: <b>for</b>
   * <p>
   * Description: <b>The product which this ingredient is a constituent part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.for</b><br>
   * </p>
   */
  @SearchParamDefinition(name="for", path="Ingredient.for", description="The product which this ingredient is a constituent part of", type="reference", target={AdministrableProductDefinition.class, ManufacturedItemDefinition.class, MedicinalProductDefinition.class } )
  public static final String SP_FOR = "for";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>for</b>
   * <p>
   * Description: <b>The product which this ingredient is a constituent part of</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.for</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam FOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_FOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Ingredient:for</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_FOR = new ca.uhn.fhir.model.api.Include("Ingredient:for").toLocked();

 /**
   * Search parameter: <b>function</b>
   * <p>
   * Description: <b>A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: Antioxidant, Alkalizing Agent</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.function</b><br>
   * </p>
   */
  @SearchParamDefinition(name="function", path="Ingredient.function", description="A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: Antioxidant, Alkalizing Agent", type="token" )
  public static final String SP_FUNCTION = "function";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>function</b>
   * <p>
   * Description: <b>A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: Antioxidant, Alkalizing Agent</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.function</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam FUNCTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_FUNCTION);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>An identifier or code by which the ingredient can be referenced</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Ingredient.identifier", description="An identifier or code by which the ingredient can be referenced", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>An identifier or code by which the ingredient can be referenced</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>manufacturer</b>
   * <p>
   * Description: <b>The organization that manufactures this ingredient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.manufacturer.manufacturer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manufacturer", path="Ingredient.manufacturer.manufacturer", description="The organization that manufactures this ingredient", type="reference", target={Organization.class } )
  public static final String SP_MANUFACTURER = "manufacturer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manufacturer</b>
   * <p>
   * Description: <b>The organization that manufactures this ingredient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.manufacturer.manufacturer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MANUFACTURER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MANUFACTURER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Ingredient:manufacturer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MANUFACTURER = new ca.uhn.fhir.model.api.Include("Ingredient:manufacturer").toLocked();

 /**
   * Search parameter: <b>role</b>
   * <p>
   * Description: <b>A classification of the ingredient identifying its purpose within the product, e.g. active, inactive</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.role</b><br>
   * </p>
   */
  @SearchParamDefinition(name="role", path="Ingredient.role", description="A classification of the ingredient identifying its purpose within the product, e.g. active, inactive", type="token" )
  public static final String SP_ROLE = "role";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>role</b>
   * <p>
   * Description: <b>A classification of the ingredient identifying its purpose within the product, e.g. active, inactive</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.role</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ROLE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ROLE);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of this ingredient. Enables tracking the life-cycle of the content</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="Ingredient.status", description="The status of this ingredient. Enables tracking the life-cycle of the content", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of this ingredient. Enables tracking the life-cycle of the content</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>strength-concentration-quantity</b>
   * <p>
   * Description: <b>Ingredient concentration strength as quantity</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Ingredient.substance.strength.concentration.ofType(Quantity)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="strength-concentration-quantity", path="Ingredient.substance.strength.concentration.ofType(Quantity)", description="Ingredient concentration strength as quantity", type="quantity" )
  public static final String SP_STRENGTH_CONCENTRATION_QUANTITY = "strength-concentration-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>strength-concentration-quantity</b>
   * <p>
   * Description: <b>Ingredient concentration strength as quantity</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Ingredient.substance.strength.concentration.ofType(Quantity)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam STRENGTH_CONCENTRATION_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_STRENGTH_CONCENTRATION_QUANTITY);

 /**
   * Search parameter: <b>strength-presentation-quantity</b>
   * <p>
   * Description: <b>Ingredient presentation strength as quantity</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Ingredient.substance.strength.presentation.ofType(Quantity)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="strength-presentation-quantity", path="Ingredient.substance.strength.presentation.ofType(Quantity)", description="Ingredient presentation strength as quantity", type="quantity" )
  public static final String SP_STRENGTH_PRESENTATION_QUANTITY = "strength-presentation-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>strength-presentation-quantity</b>
   * <p>
   * Description: <b>Ingredient presentation strength as quantity</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>Ingredient.substance.strength.presentation.ofType(Quantity)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam STRENGTH_PRESENTATION_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_STRENGTH_PRESENTATION_QUANTITY);

 /**
   * Search parameter: <b>substance-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.substance.code.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="substance-code", path="Ingredient.substance.code.concept", description="Reference to a concept (by class)", type="token" )
  public static final String SP_SUBSTANCE_CODE = "substance-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>substance-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.substance.code.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SUBSTANCE_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SUBSTANCE_CODE);

 /**
   * Search parameter: <b>substance-definition</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.substance.code.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="substance-definition", path="Ingredient.substance.code.reference", description="Reference to a resource (by instance)", type="reference", target={SubstanceDefinition.class } )
  public static final String SP_SUBSTANCE_DEFINITION = "substance-definition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>substance-definition</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.substance.code.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBSTANCE_DEFINITION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBSTANCE_DEFINITION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Ingredient:substance-definition</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBSTANCE_DEFINITION = new ca.uhn.fhir.model.api.Include("Ingredient:substance-definition").toLocked();

 /**
   * Search parameter: <b>substance</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.substance.code.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="substance", path="Ingredient.substance.code.reference", description="Reference to a resource (by instance)", type="reference", target={SubstanceDefinition.class } )
  public static final String SP_SUBSTANCE = "substance";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>substance</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.substance.code.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBSTANCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBSTANCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Ingredient:substance</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBSTANCE = new ca.uhn.fhir.model.api.Include("Ingredient:substance").toLocked();


}

