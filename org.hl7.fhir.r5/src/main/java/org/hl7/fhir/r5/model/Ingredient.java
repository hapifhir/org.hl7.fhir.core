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

// Generated on Thu, Aug 20, 2020 19:42+1000 for FHIR vcurrent

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

    @Block()
    public static class IngredientSubstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code or full resource that represents the ingredient substance.
         */
        @Child(name = "code", type = {CodeableConcept.class, SubstanceDefinition.class, Substance.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A code or full resource that represents the ingredient substance", formalDefinition="A code or full resource that represents the ingredient substance." )
        protected DataType code;

        /**
         * Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product.
         */
        @Child(name = "strength", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product", formalDefinition="Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product." )
        protected List<IngredientSubstanceStrengthComponent> strength;

        private static final long serialVersionUID = -70189331L;

    /**
     * Constructor
     */
      public IngredientSubstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public IngredientSubstanceComponent(DataType code) {
        super();
        this.setCode(code);
      }

        /**
         * @return {@link #code} (A code or full resource that represents the ingredient substance.)
         */
        public DataType getCode() { 
          return this.code;
        }

        /**
         * @return {@link #code} (A code or full resource that represents the ingredient substance.)
         */
        public CodeableConcept getCodeCodeableConcept() throws FHIRException { 
          if (this.code == null)
            this.code = new CodeableConcept();
          if (!(this.code instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.code.getClass().getName()+" was encountered");
          return (CodeableConcept) this.code;
        }

        public boolean hasCodeCodeableConcept() { 
          return this != null && this.code instanceof CodeableConcept;
        }

        /**
         * @return {@link #code} (A code or full resource that represents the ingredient substance.)
         */
        public Reference getCodeReference() throws FHIRException { 
          if (this.code == null)
            this.code = new Reference();
          if (!(this.code instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.code.getClass().getName()+" was encountered");
          return (Reference) this.code;
        }

        public boolean hasCodeReference() { 
          return this != null && this.code instanceof Reference;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A code or full resource that represents the ingredient substance.)
         */
        public IngredientSubstanceComponent setCode(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
            throw new Error("Not the right type for Ingredient.substance.code[x]: "+value.fhirType());
          this.code = value;
          return this;
        }

        /**
         * @return {@link #strength} (Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product.)
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
          children.add(new Property("code[x]", "CodeableConcept|Reference(SubstanceDefinition|Substance)", "A code or full resource that represents the ingredient substance.", 0, 1, code));
          children.add(new Property("strength", "", "Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product.", 0, java.lang.Integer.MAX_VALUE, strength));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 941839219: /*code[x]*/  return new Property("code[x]", "CodeableConcept|Reference(SubstanceDefinition|Substance)", "A code or full resource that represents the ingredient substance.", 0, 1, code);
          case 3059181: /*code*/  return new Property("code[x]", "CodeableConcept|Reference(SubstanceDefinition|Substance)", "A code or full resource that represents the ingredient substance.", 0, 1, code);
          case 4899316: /*codeCodeableConcept*/  return new Property("code[x]", "CodeableConcept", "A code or full resource that represents the ingredient substance.", 0, 1, code);
          case 1565461470: /*codeReference*/  return new Property("code[x]", "Reference(SubstanceDefinition|Substance)", "A code or full resource that represents the ingredient substance.", 0, 1, code);
          case 1791316033: /*strength*/  return new Property("strength", "", "Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product.", 0, java.lang.Integer.MAX_VALUE, strength);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // DataType
        case 1791316033: /*strength*/ return this.strength == null ? new Base[0] : this.strength.toArray(new Base[this.strength.size()]); // IngredientSubstanceStrengthComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToType(value); // DataType
          return value;
        case 1791316033: // strength
          this.getStrength().add((IngredientSubstanceStrengthComponent) value); // IngredientSubstanceStrengthComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code[x]")) {
          this.code = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("strength")) {
          this.getStrength().add((IngredientSubstanceStrengthComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 941839219:  return getCode();
        case 3059181:  return getCode();
        case 1791316033:  return addStrength(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept", "Reference"};
        case 1791316033: /*strength*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("codeCodeableConcept")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("codeReference")) {
          this.code = new Reference();
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
         * The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item.
         */
        @Child(name = "presentation", type = {Ratio.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item", formalDefinition="The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item." )
        protected Ratio presentation;

        /**
         * An upper limit for the quantity of substance in the unit of presentation. For use when there is a range of strengths, this is the high limit, with the presentation attribute becoming the lower limit.
         */
        @Child(name = "presentationHighLimit", type = {Ratio.class}, order=2, min=0, max=1, modifier=true, summary=true)
        @Description(shortDefinition="An upper limit for the quantity of substance in the unit of presentation. For use when there is a range of strengths, this is the high limit, with the presentation attribute becoming the lower limit", formalDefinition="An upper limit for the quantity of substance in the unit of presentation. For use when there is a range of strengths, this is the high limit, with the presentation attribute becoming the lower limit." )
        protected Ratio presentationHighLimit;

        /**
         * A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.
         */
        @Child(name = "presentationText", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio", formalDefinition="A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio." )
        protected StringType presentationText;

        /**
         * The strength per unitary volume (or mass).
         */
        @Child(name = "concentration", type = {Ratio.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The strength per unitary volume (or mass)", formalDefinition="The strength per unitary volume (or mass)." )
        protected Ratio concentration;

        /**
         * An upper limit for the strength per unitary volume (or mass), for when there is a range. The concentration attribute then becomes the lower limit.
         */
        @Child(name = "concentrationHighLimit", type = {Ratio.class}, order=5, min=0, max=1, modifier=true, summary=true)
        @Description(shortDefinition="An upper limit for the strength per unitary volume (or mass), for when there is a range. The concentration attribute then becomes the lower limit", formalDefinition="An upper limit for the strength per unitary volume (or mass), for when there is a range. The concentration attribute then becomes the lower limit." )
        protected Ratio concentrationHighLimit;

        /**
         * A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.
         */
        @Child(name = "concentrationText", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio", formalDefinition="A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio." )
        protected StringType concentrationText;

        /**
         * For when strength is measured at a particular point or distance.
         */
        @Child(name = "measurementPoint", type = {StringType.class}, order=7, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="For when strength is measured at a particular point or distance", formalDefinition="For when strength is measured at a particular point or distance." )
        protected StringType measurementPoint;

        /**
         * The country or countries for which the strength range applies.
         */
        @Child(name = "country", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The country or countries for which the strength range applies", formalDefinition="The country or countries for which the strength range applies." )
        protected List<CodeableConcept> country;

        /**
         * Strength expressed in terms of a reference substance.
         */
        @Child(name = "referenceStrength", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Strength expressed in terms of a reference substance", formalDefinition="Strength expressed in terms of a reference substance." )
        protected List<IngredientSubstanceStrengthReferenceStrengthComponent> referenceStrength;

        private static final long serialVersionUID = 475292608L;

    /**
     * Constructor
     */
      public IngredientSubstanceStrengthComponent() {
        super();
      }

        /**
         * @return {@link #presentation} (The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item.)
         */
        public Ratio getPresentation() { 
          if (this.presentation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.presentation");
            else if (Configuration.doAutoCreate())
              this.presentation = new Ratio(); // cc
          return this.presentation;
        }

        public boolean hasPresentation() { 
          return this.presentation != null && !this.presentation.isEmpty();
        }

        /**
         * @param value {@link #presentation} (The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item.)
         */
        public IngredientSubstanceStrengthComponent setPresentation(Ratio value) { 
          this.presentation = value;
          return this;
        }

        /**
         * @return {@link #presentationHighLimit} (An upper limit for the quantity of substance in the unit of presentation. For use when there is a range of strengths, this is the high limit, with the presentation attribute becoming the lower limit.)
         */
        public Ratio getPresentationHighLimit() { 
          if (this.presentationHighLimit == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.presentationHighLimit");
            else if (Configuration.doAutoCreate())
              this.presentationHighLimit = new Ratio(); // cc
          return this.presentationHighLimit;
        }

        public boolean hasPresentationHighLimit() { 
          return this.presentationHighLimit != null && !this.presentationHighLimit.isEmpty();
        }

        /**
         * @param value {@link #presentationHighLimit} (An upper limit for the quantity of substance in the unit of presentation. For use when there is a range of strengths, this is the high limit, with the presentation attribute becoming the lower limit.)
         */
        public IngredientSubstanceStrengthComponent setPresentationHighLimit(Ratio value) { 
          this.presentationHighLimit = value;
          return this;
        }

        /**
         * @return {@link #presentationText} (A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.). This is the underlying object with id, value and extensions. The accessor "getPresentationText" gives direct access to the value
         */
        public StringType getPresentationTextElement() { 
          if (this.presentationText == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.presentationText");
            else if (Configuration.doAutoCreate())
              this.presentationText = new StringType(); // bb
          return this.presentationText;
        }

        public boolean hasPresentationTextElement() { 
          return this.presentationText != null && !this.presentationText.isEmpty();
        }

        public boolean hasPresentationText() { 
          return this.presentationText != null && !this.presentationText.isEmpty();
        }

        /**
         * @param value {@link #presentationText} (A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.). This is the underlying object with id, value and extensions. The accessor "getPresentationText" gives direct access to the value
         */
        public IngredientSubstanceStrengthComponent setPresentationTextElement(StringType value) { 
          this.presentationText = value;
          return this;
        }

        /**
         * @return A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.
         */
        public String getPresentationText() { 
          return this.presentationText == null ? null : this.presentationText.getValue();
        }

        /**
         * @param value A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.
         */
        public IngredientSubstanceStrengthComponent setPresentationText(String value) { 
          if (Utilities.noString(value))
            this.presentationText = null;
          else {
            if (this.presentationText == null)
              this.presentationText = new StringType();
            this.presentationText.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #concentration} (The strength per unitary volume (or mass).)
         */
        public Ratio getConcentration() { 
          if (this.concentration == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.concentration");
            else if (Configuration.doAutoCreate())
              this.concentration = new Ratio(); // cc
          return this.concentration;
        }

        public boolean hasConcentration() { 
          return this.concentration != null && !this.concentration.isEmpty();
        }

        /**
         * @param value {@link #concentration} (The strength per unitary volume (or mass).)
         */
        public IngredientSubstanceStrengthComponent setConcentration(Ratio value) { 
          this.concentration = value;
          return this;
        }

        /**
         * @return {@link #concentrationHighLimit} (An upper limit for the strength per unitary volume (or mass), for when there is a range. The concentration attribute then becomes the lower limit.)
         */
        public Ratio getConcentrationHighLimit() { 
          if (this.concentrationHighLimit == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.concentrationHighLimit");
            else if (Configuration.doAutoCreate())
              this.concentrationHighLimit = new Ratio(); // cc
          return this.concentrationHighLimit;
        }

        public boolean hasConcentrationHighLimit() { 
          return this.concentrationHighLimit != null && !this.concentrationHighLimit.isEmpty();
        }

        /**
         * @param value {@link #concentrationHighLimit} (An upper limit for the strength per unitary volume (or mass), for when there is a range. The concentration attribute then becomes the lower limit.)
         */
        public IngredientSubstanceStrengthComponent setConcentrationHighLimit(Ratio value) { 
          this.concentrationHighLimit = value;
          return this;
        }

        /**
         * @return {@link #concentrationText} (A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.). This is the underlying object with id, value and extensions. The accessor "getConcentrationText" gives direct access to the value
         */
        public StringType getConcentrationTextElement() { 
          if (this.concentrationText == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthComponent.concentrationText");
            else if (Configuration.doAutoCreate())
              this.concentrationText = new StringType(); // bb
          return this.concentrationText;
        }

        public boolean hasConcentrationTextElement() { 
          return this.concentrationText != null && !this.concentrationText.isEmpty();
        }

        public boolean hasConcentrationText() { 
          return this.concentrationText != null && !this.concentrationText.isEmpty();
        }

        /**
         * @param value {@link #concentrationText} (A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.). This is the underlying object with id, value and extensions. The accessor "getConcentrationText" gives direct access to the value
         */
        public IngredientSubstanceStrengthComponent setConcentrationTextElement(StringType value) { 
          this.concentrationText = value;
          return this;
        }

        /**
         * @return A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.
         */
        public String getConcentrationText() { 
          return this.concentrationText == null ? null : this.concentrationText.getValue();
        }

        /**
         * @param value A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.
         */
        public IngredientSubstanceStrengthComponent setConcentrationText(String value) { 
          if (Utilities.noString(value))
            this.concentrationText = null;
          else {
            if (this.concentrationText == null)
              this.concentrationText = new StringType();
            this.concentrationText.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #measurementPoint} (For when strength is measured at a particular point or distance.). This is the underlying object with id, value and extensions. The accessor "getMeasurementPoint" gives direct access to the value
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
         * @param value {@link #measurementPoint} (For when strength is measured at a particular point or distance.). This is the underlying object with id, value and extensions. The accessor "getMeasurementPoint" gives direct access to the value
         */
        public IngredientSubstanceStrengthComponent setMeasurementPointElement(StringType value) { 
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
         * @return {@link #referenceStrength} (Strength expressed in terms of a reference substance.)
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
          children.add(new Property("presentation", "Ratio", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item.", 0, 1, presentation));
          children.add(new Property("presentationHighLimit", "Ratio", "An upper limit for the quantity of substance in the unit of presentation. For use when there is a range of strengths, this is the high limit, with the presentation attribute becoming the lower limit.", 0, 1, presentationHighLimit));
          children.add(new Property("presentationText", "string", "A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.", 0, 1, presentationText));
          children.add(new Property("concentration", "Ratio", "The strength per unitary volume (or mass).", 0, 1, concentration));
          children.add(new Property("concentrationHighLimit", "Ratio", "An upper limit for the strength per unitary volume (or mass), for when there is a range. The concentration attribute then becomes the lower limit.", 0, 1, concentrationHighLimit));
          children.add(new Property("concentrationText", "string", "A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.", 0, 1, concentrationText));
          children.add(new Property("measurementPoint", "string", "For when strength is measured at a particular point or distance.", 0, 1, measurementPoint));
          children.add(new Property("country", "CodeableConcept", "The country or countries for which the strength range applies.", 0, java.lang.Integer.MAX_VALUE, country));
          children.add(new Property("referenceStrength", "", "Strength expressed in terms of a reference substance.", 0, java.lang.Integer.MAX_VALUE, referenceStrength));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 696975130: /*presentation*/  return new Property("presentation", "Ratio", "The quantity of substance in the unit of presentation, or in the volume (or mass) of the single pharmaceutical product or manufactured item.", 0, 1, presentation);
          case 904802623: /*presentationHighLimit*/  return new Property("presentationHighLimit", "Ratio", "An upper limit for the quantity of substance in the unit of presentation. For use when there is a range of strengths, this is the high limit, with the presentation attribute becoming the lower limit.", 0, 1, presentationHighLimit);
          case 1602853735: /*presentationText*/  return new Property("presentationText", "string", "A textual represention of either the whole of the presentation strength or a part of it - with the rest being in Strength.presentation as a ratio.", 0, 1, presentationText);
          case -410557331: /*concentration*/  return new Property("concentration", "Ratio", "The strength per unitary volume (or mass).", 0, 1, concentration);
          case -1595729588: /*concentrationHighLimit*/  return new Property("concentrationHighLimit", "Ratio", "An upper limit for the strength per unitary volume (or mass), for when there is a range. The concentration attribute then becomes the lower limit.", 0, 1, concentrationHighLimit);
          case 1398611770: /*concentrationText*/  return new Property("concentrationText", "string", "A textual represention of either the whole of the concentration strength or a part of it - with the rest being in Strength.concentration as a ratio.", 0, 1, concentrationText);
          case 235437876: /*measurementPoint*/  return new Property("measurementPoint", "string", "For when strength is measured at a particular point or distance.", 0, 1, measurementPoint);
          case 957831062: /*country*/  return new Property("country", "CodeableConcept", "The country or countries for which the strength range applies.", 0, java.lang.Integer.MAX_VALUE, country);
          case 1943566508: /*referenceStrength*/  return new Property("referenceStrength", "", "Strength expressed in terms of a reference substance.", 0, java.lang.Integer.MAX_VALUE, referenceStrength);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 696975130: /*presentation*/ return this.presentation == null ? new Base[0] : new Base[] {this.presentation}; // Ratio
        case 904802623: /*presentationHighLimit*/ return this.presentationHighLimit == null ? new Base[0] : new Base[] {this.presentationHighLimit}; // Ratio
        case 1602853735: /*presentationText*/ return this.presentationText == null ? new Base[0] : new Base[] {this.presentationText}; // StringType
        case -410557331: /*concentration*/ return this.concentration == null ? new Base[0] : new Base[] {this.concentration}; // Ratio
        case -1595729588: /*concentrationHighLimit*/ return this.concentrationHighLimit == null ? new Base[0] : new Base[] {this.concentrationHighLimit}; // Ratio
        case 1398611770: /*concentrationText*/ return this.concentrationText == null ? new Base[0] : new Base[] {this.concentrationText}; // StringType
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
          this.presentation = TypeConvertor.castToRatio(value); // Ratio
          return value;
        case 904802623: // presentationHighLimit
          this.presentationHighLimit = TypeConvertor.castToRatio(value); // Ratio
          return value;
        case 1602853735: // presentationText
          this.presentationText = TypeConvertor.castToString(value); // StringType
          return value;
        case -410557331: // concentration
          this.concentration = TypeConvertor.castToRatio(value); // Ratio
          return value;
        case -1595729588: // concentrationHighLimit
          this.concentrationHighLimit = TypeConvertor.castToRatio(value); // Ratio
          return value;
        case 1398611770: // concentrationText
          this.concentrationText = TypeConvertor.castToString(value); // StringType
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
        if (name.equals("presentation")) {
          this.presentation = TypeConvertor.castToRatio(value); // Ratio
        } else if (name.equals("presentationHighLimit")) {
          this.presentationHighLimit = TypeConvertor.castToRatio(value); // Ratio
        } else if (name.equals("presentationText")) {
          this.presentationText = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("concentration")) {
          this.concentration = TypeConvertor.castToRatio(value); // Ratio
        } else if (name.equals("concentrationHighLimit")) {
          this.concentrationHighLimit = TypeConvertor.castToRatio(value); // Ratio
        } else if (name.equals("concentrationText")) {
          this.concentrationText = TypeConvertor.castToString(value); // StringType
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
        case 696975130:  return getPresentation();
        case 904802623:  return getPresentationHighLimit();
        case 1602853735:  return getPresentationTextElement();
        case -410557331:  return getConcentration();
        case -1595729588:  return getConcentrationHighLimit();
        case 1398611770:  return getConcentrationTextElement();
        case 235437876:  return getMeasurementPointElement();
        case 957831062:  return addCountry(); 
        case 1943566508:  return addReferenceStrength(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 696975130: /*presentation*/ return new String[] {"Ratio"};
        case 904802623: /*presentationHighLimit*/ return new String[] {"Ratio"};
        case 1602853735: /*presentationText*/ return new String[] {"string"};
        case -410557331: /*concentration*/ return new String[] {"Ratio"};
        case -1595729588: /*concentrationHighLimit*/ return new String[] {"Ratio"};
        case 1398611770: /*concentrationText*/ return new String[] {"string"};
        case 235437876: /*measurementPoint*/ return new String[] {"string"};
        case 957831062: /*country*/ return new String[] {"CodeableConcept"};
        case 1943566508: /*referenceStrength*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("presentation")) {
          this.presentation = new Ratio();
          return this.presentation;
        }
        else if (name.equals("presentationHighLimit")) {
          this.presentationHighLimit = new Ratio();
          return this.presentationHighLimit;
        }
        else if (name.equals("presentationText")) {
          throw new FHIRException("Cannot call addChild on a primitive type Ingredient.substance.strength.presentationText");
        }
        else if (name.equals("concentration")) {
          this.concentration = new Ratio();
          return this.concentration;
        }
        else if (name.equals("concentrationHighLimit")) {
          this.concentrationHighLimit = new Ratio();
          return this.concentrationHighLimit;
        }
        else if (name.equals("concentrationText")) {
          throw new FHIRException("Cannot call addChild on a primitive type Ingredient.substance.strength.concentrationText");
        }
        else if (name.equals("measurementPoint")) {
          throw new FHIRException("Cannot call addChild on a primitive type Ingredient.substance.strength.measurementPoint");
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
        dst.presentationHighLimit = presentationHighLimit == null ? null : presentationHighLimit.copy();
        dst.presentationText = presentationText == null ? null : presentationText.copy();
        dst.concentration = concentration == null ? null : concentration.copy();
        dst.concentrationHighLimit = concentrationHighLimit == null ? null : concentrationHighLimit.copy();
        dst.concentrationText = concentrationText == null ? null : concentrationText.copy();
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
        return compareDeep(presentation, o.presentation, true) && compareDeep(presentationHighLimit, o.presentationHighLimit, true)
           && compareDeep(presentationText, o.presentationText, true) && compareDeep(concentration, o.concentration, true)
           && compareDeep(concentrationHighLimit, o.concentrationHighLimit, true) && compareDeep(concentrationText, o.concentrationText, true)
           && compareDeep(measurementPoint, o.measurementPoint, true) && compareDeep(country, o.country, true)
           && compareDeep(referenceStrength, o.referenceStrength, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof IngredientSubstanceStrengthComponent))
          return false;
        IngredientSubstanceStrengthComponent o = (IngredientSubstanceStrengthComponent) other_;
        return compareValues(presentationText, o.presentationText, true) && compareValues(concentrationText, o.concentrationText, true)
           && compareValues(measurementPoint, o.measurementPoint, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(presentation, presentationHighLimit
          , presentationText, concentration, concentrationHighLimit, concentrationText, measurementPoint
          , country, referenceStrength);
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
        @Child(name = "substance", type = {CodeableConcept.class, SubstanceDefinition.class, Substance.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Relevant reference substance", formalDefinition="Relevant reference substance." )
        protected DataType substance;

        /**
         * Strength expressed in terms of a reference substance.
         */
        @Child(name = "strength", type = {Ratio.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Strength expressed in terms of a reference substance", formalDefinition="Strength expressed in terms of a reference substance." )
        protected Ratio strength;

        /**
         * Strength expressed in terms of a reference substance, upper limit.
         */
        @Child(name = "strengthHighLimit", type = {Ratio.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Strength expressed in terms of a reference substance, upper limit", formalDefinition="Strength expressed in terms of a reference substance, upper limit." )
        protected Ratio strengthHighLimit;

        /**
         * For when strength is measured at a particular point or distance.
         */
        @Child(name = "measurementPoint", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="For when strength is measured at a particular point or distance", formalDefinition="For when strength is measured at a particular point or distance." )
        protected StringType measurementPoint;

        /**
         * The country or countries for which the strength range applies.
         */
        @Child(name = "country", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The country or countries for which the strength range applies", formalDefinition="The country or countries for which the strength range applies." )
        protected List<CodeableConcept> country;

        private static final long serialVersionUID = 1274073375L;

    /**
     * Constructor
     */
      public IngredientSubstanceStrengthReferenceStrengthComponent() {
        super();
      }

    /**
     * Constructor
     */
      public IngredientSubstanceStrengthReferenceStrengthComponent(Ratio strength) {
        super();
        this.setStrength(strength);
      }

        /**
         * @return {@link #substance} (Relevant reference substance.)
         */
        public DataType getSubstance() { 
          return this.substance;
        }

        /**
         * @return {@link #substance} (Relevant reference substance.)
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
         * @return {@link #substance} (Relevant reference substance.)
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
         * @param value {@link #substance} (Relevant reference substance.)
         */
        public IngredientSubstanceStrengthReferenceStrengthComponent setSubstance(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
            throw new Error("Not the right type for Ingredient.substance.strength.referenceStrength.substance[x]: "+value.fhirType());
          this.substance = value;
          return this;
        }

        /**
         * @return {@link #strength} (Strength expressed in terms of a reference substance.)
         */
        public Ratio getStrength() { 
          if (this.strength == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthReferenceStrengthComponent.strength");
            else if (Configuration.doAutoCreate())
              this.strength = new Ratio(); // cc
          return this.strength;
        }

        public boolean hasStrength() { 
          return this.strength != null && !this.strength.isEmpty();
        }

        /**
         * @param value {@link #strength} (Strength expressed in terms of a reference substance.)
         */
        public IngredientSubstanceStrengthReferenceStrengthComponent setStrength(Ratio value) { 
          this.strength = value;
          return this;
        }

        /**
         * @return {@link #strengthHighLimit} (Strength expressed in terms of a reference substance, upper limit.)
         */
        public Ratio getStrengthHighLimit() { 
          if (this.strengthHighLimit == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSubstanceStrengthReferenceStrengthComponent.strengthHighLimit");
            else if (Configuration.doAutoCreate())
              this.strengthHighLimit = new Ratio(); // cc
          return this.strengthHighLimit;
        }

        public boolean hasStrengthHighLimit() { 
          return this.strengthHighLimit != null && !this.strengthHighLimit.isEmpty();
        }

        /**
         * @param value {@link #strengthHighLimit} (Strength expressed in terms of a reference substance, upper limit.)
         */
        public IngredientSubstanceStrengthReferenceStrengthComponent setStrengthHighLimit(Ratio value) { 
          this.strengthHighLimit = value;
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
          children.add(new Property("substance[x]", "CodeableConcept|Reference(SubstanceDefinition|Substance)", "Relevant reference substance.", 0, 1, substance));
          children.add(new Property("strength", "Ratio", "Strength expressed in terms of a reference substance.", 0, 1, strength));
          children.add(new Property("strengthHighLimit", "Ratio", "Strength expressed in terms of a reference substance, upper limit.", 0, 1, strengthHighLimit));
          children.add(new Property("measurementPoint", "string", "For when strength is measured at a particular point or distance.", 0, 1, measurementPoint));
          children.add(new Property("country", "CodeableConcept", "The country or countries for which the strength range applies.", 0, java.lang.Integer.MAX_VALUE, country));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 2127194384: /*substance[x]*/  return new Property("substance[x]", "CodeableConcept|Reference(SubstanceDefinition|Substance)", "Relevant reference substance.", 0, 1, substance);
          case 530040176: /*substance*/  return new Property("substance[x]", "CodeableConcept|Reference(SubstanceDefinition|Substance)", "Relevant reference substance.", 0, 1, substance);
          case -1974119407: /*substanceCodeableConcept*/  return new Property("substance[x]", "CodeableConcept", "Relevant reference substance.", 0, 1, substance);
          case 516208571: /*substanceReference*/  return new Property("substance[x]", "Reference(SubstanceDefinition|Substance)", "Relevant reference substance.", 0, 1, substance);
          case 1791316033: /*strength*/  return new Property("strength", "Ratio", "Strength expressed in terms of a reference substance.", 0, 1, strength);
          case 703544312: /*strengthHighLimit*/  return new Property("strengthHighLimit", "Ratio", "Strength expressed in terms of a reference substance, upper limit.", 0, 1, strengthHighLimit);
          case 235437876: /*measurementPoint*/  return new Property("measurementPoint", "string", "For when strength is measured at a particular point or distance.", 0, 1, measurementPoint);
          case 957831062: /*country*/  return new Property("country", "CodeableConcept", "The country or countries for which the strength range applies.", 0, java.lang.Integer.MAX_VALUE, country);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 530040176: /*substance*/ return this.substance == null ? new Base[0] : new Base[] {this.substance}; // DataType
        case 1791316033: /*strength*/ return this.strength == null ? new Base[0] : new Base[] {this.strength}; // Ratio
        case 703544312: /*strengthHighLimit*/ return this.strengthHighLimit == null ? new Base[0] : new Base[] {this.strengthHighLimit}; // Ratio
        case 235437876: /*measurementPoint*/ return this.measurementPoint == null ? new Base[0] : new Base[] {this.measurementPoint}; // StringType
        case 957831062: /*country*/ return this.country == null ? new Base[0] : this.country.toArray(new Base[this.country.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 530040176: // substance
          this.substance = TypeConvertor.castToType(value); // DataType
          return value;
        case 1791316033: // strength
          this.strength = TypeConvertor.castToRatio(value); // Ratio
          return value;
        case 703544312: // strengthHighLimit
          this.strengthHighLimit = TypeConvertor.castToRatio(value); // Ratio
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
        if (name.equals("substance[x]")) {
          this.substance = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("strength")) {
          this.strength = TypeConvertor.castToRatio(value); // Ratio
        } else if (name.equals("strengthHighLimit")) {
          this.strengthHighLimit = TypeConvertor.castToRatio(value); // Ratio
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
        case 2127194384:  return getSubstance();
        case 530040176:  return getSubstance();
        case 1791316033:  return getStrength();
        case 703544312:  return getStrengthHighLimit();
        case 235437876:  return getMeasurementPointElement();
        case 957831062:  return addCountry(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 530040176: /*substance*/ return new String[] {"CodeableConcept", "Reference"};
        case 1791316033: /*strength*/ return new String[] {"Ratio"};
        case 703544312: /*strengthHighLimit*/ return new String[] {"Ratio"};
        case 235437876: /*measurementPoint*/ return new String[] {"string"};
        case 957831062: /*country*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("substanceCodeableConcept")) {
          this.substance = new CodeableConcept();
          return this.substance;
        }
        else if (name.equals("substanceReference")) {
          this.substance = new Reference();
          return this.substance;
        }
        else if (name.equals("strength")) {
          this.strength = new Ratio();
          return this.strength;
        }
        else if (name.equals("strengthHighLimit")) {
          this.strengthHighLimit = new Ratio();
          return this.strengthHighLimit;
        }
        else if (name.equals("measurementPoint")) {
          throw new FHIRException("Cannot call addChild on a primitive type Ingredient.substance.strength.referenceStrength.measurementPoint");
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
        dst.strengthHighLimit = strengthHighLimit == null ? null : strengthHighLimit.copy();
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
        return compareDeep(substance, o.substance, true) && compareDeep(strength, o.strength, true) && compareDeep(strengthHighLimit, o.strengthHighLimit, true)
           && compareDeep(measurementPoint, o.measurementPoint, true) && compareDeep(country, o.country, true)
          ;
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
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(substance, strength, strengthHighLimit
          , measurementPoint, country);
      }

  public String fhirType() {
    return "Ingredient.substance.strength.referenceStrength";

  }

  }

    @Block()
    public static class IngredientSpecifiedSubstanceComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Substance as a 'specified substance', implying extra substance related characteristics.
         */
        @Child(name = "code", type = {CodeableConcept.class, SubstanceDefinition.class, Substance.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Substance as a 'specified substance', implying extra substance related characteristics", formalDefinition="Substance as a 'specified substance', implying extra substance related characteristics." )
        protected DataType code;

        /**
         * The group of specified substance, e.g. group 1 to 4.
         */
        @Child(name = "group", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The group of specified substance, e.g. group 1 to 4", formalDefinition="The group of specified substance, e.g. group 1 to 4." )
        protected CodeableConcept group;

        /**
         * Confidentiality level of the specified substance as the ingredient.
         */
        @Child(name = "confidentiality", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Confidentiality level of the specified substance as the ingredient", formalDefinition="Confidentiality level of the specified substance as the ingredient." )
        protected CodeableConcept confidentiality;

        /**
         * Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product.
         */
        @Child(name = "strength", type = {IngredientSubstanceStrengthComponent.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product", formalDefinition="Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product." )
        protected List<IngredientSubstanceStrengthComponent> strength;

        private static final long serialVersionUID = 99263290L;

    /**
     * Constructor
     */
      public IngredientSpecifiedSubstanceComponent() {
        super();
      }

    /**
     * Constructor
     */
      public IngredientSpecifiedSubstanceComponent(DataType code, CodeableConcept group) {
        super();
        this.setCode(code);
        this.setGroup(group);
      }

        /**
         * @return {@link #code} (Substance as a 'specified substance', implying extra substance related characteristics.)
         */
        public DataType getCode() { 
          return this.code;
        }

        /**
         * @return {@link #code} (Substance as a 'specified substance', implying extra substance related characteristics.)
         */
        public CodeableConcept getCodeCodeableConcept() throws FHIRException { 
          if (this.code == null)
            this.code = new CodeableConcept();
          if (!(this.code instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.code.getClass().getName()+" was encountered");
          return (CodeableConcept) this.code;
        }

        public boolean hasCodeCodeableConcept() { 
          return this != null && this.code instanceof CodeableConcept;
        }

        /**
         * @return {@link #code} (Substance as a 'specified substance', implying extra substance related characteristics.)
         */
        public Reference getCodeReference() throws FHIRException { 
          if (this.code == null)
            this.code = new Reference();
          if (!(this.code instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.code.getClass().getName()+" was encountered");
          return (Reference) this.code;
        }

        public boolean hasCodeReference() { 
          return this != null && this.code instanceof Reference;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Substance as a 'specified substance', implying extra substance related characteristics.)
         */
        public IngredientSpecifiedSubstanceComponent setCode(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
            throw new Error("Not the right type for Ingredient.specifiedSubstance.code[x]: "+value.fhirType());
          this.code = value;
          return this;
        }

        /**
         * @return {@link #group} (The group of specified substance, e.g. group 1 to 4.)
         */
        public CodeableConcept getGroup() { 
          if (this.group == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSpecifiedSubstanceComponent.group");
            else if (Configuration.doAutoCreate())
              this.group = new CodeableConcept(); // cc
          return this.group;
        }

        public boolean hasGroup() { 
          return this.group != null && !this.group.isEmpty();
        }

        /**
         * @param value {@link #group} (The group of specified substance, e.g. group 1 to 4.)
         */
        public IngredientSpecifiedSubstanceComponent setGroup(CodeableConcept value) { 
          this.group = value;
          return this;
        }

        /**
         * @return {@link #confidentiality} (Confidentiality level of the specified substance as the ingredient.)
         */
        public CodeableConcept getConfidentiality() { 
          if (this.confidentiality == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create IngredientSpecifiedSubstanceComponent.confidentiality");
            else if (Configuration.doAutoCreate())
              this.confidentiality = new CodeableConcept(); // cc
          return this.confidentiality;
        }

        public boolean hasConfidentiality() { 
          return this.confidentiality != null && !this.confidentiality.isEmpty();
        }

        /**
         * @param value {@link #confidentiality} (Confidentiality level of the specified substance as the ingredient.)
         */
        public IngredientSpecifiedSubstanceComponent setConfidentiality(CodeableConcept value) { 
          this.confidentiality = value;
          return this;
        }

        /**
         * @return {@link #strength} (Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product.)
         */
        public List<IngredientSubstanceStrengthComponent> getStrength() { 
          if (this.strength == null)
            this.strength = new ArrayList<IngredientSubstanceStrengthComponent>();
          return this.strength;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public IngredientSpecifiedSubstanceComponent setStrength(List<IngredientSubstanceStrengthComponent> theStrength) { 
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

        public IngredientSpecifiedSubstanceComponent addStrength(IngredientSubstanceStrengthComponent t) { //3
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
          children.add(new Property("code[x]", "CodeableConcept|Reference(SubstanceDefinition|Substance)", "Substance as a 'specified substance', implying extra substance related characteristics.", 0, 1, code));
          children.add(new Property("group", "CodeableConcept", "The group of specified substance, e.g. group 1 to 4.", 0, 1, group));
          children.add(new Property("confidentiality", "CodeableConcept", "Confidentiality level of the specified substance as the ingredient.", 0, 1, confidentiality));
          children.add(new Property("strength", "@Ingredient.substance.strength", "Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product.", 0, java.lang.Integer.MAX_VALUE, strength));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 941839219: /*code[x]*/  return new Property("code[x]", "CodeableConcept|Reference(SubstanceDefinition|Substance)", "Substance as a 'specified substance', implying extra substance related characteristics.", 0, 1, code);
          case 3059181: /*code*/  return new Property("code[x]", "CodeableConcept|Reference(SubstanceDefinition|Substance)", "Substance as a 'specified substance', implying extra substance related characteristics.", 0, 1, code);
          case 4899316: /*codeCodeableConcept*/  return new Property("code[x]", "CodeableConcept", "Substance as a 'specified substance', implying extra substance related characteristics.", 0, 1, code);
          case 1565461470: /*codeReference*/  return new Property("code[x]", "Reference(SubstanceDefinition|Substance)", "Substance as a 'specified substance', implying extra substance related characteristics.", 0, 1, code);
          case 98629247: /*group*/  return new Property("group", "CodeableConcept", "The group of specified substance, e.g. group 1 to 4.", 0, 1, group);
          case -1923018202: /*confidentiality*/  return new Property("confidentiality", "CodeableConcept", "Confidentiality level of the specified substance as the ingredient.", 0, 1, confidentiality);
          case 1791316033: /*strength*/  return new Property("strength", "@Ingredient.substance.strength", "Quantity of the substance or specified substance present in the manufactured item or pharmaceutical product.", 0, java.lang.Integer.MAX_VALUE, strength);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // DataType
        case 98629247: /*group*/ return this.group == null ? new Base[0] : new Base[] {this.group}; // CodeableConcept
        case -1923018202: /*confidentiality*/ return this.confidentiality == null ? new Base[0] : new Base[] {this.confidentiality}; // CodeableConcept
        case 1791316033: /*strength*/ return this.strength == null ? new Base[0] : this.strength.toArray(new Base[this.strength.size()]); // IngredientSubstanceStrengthComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToType(value); // DataType
          return value;
        case 98629247: // group
          this.group = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1923018202: // confidentiality
          this.confidentiality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1791316033: // strength
          this.getStrength().add((IngredientSubstanceStrengthComponent) value); // IngredientSubstanceStrengthComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code[x]")) {
          this.code = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("group")) {
          this.group = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("confidentiality")) {
          this.confidentiality = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("strength")) {
          this.getStrength().add((IngredientSubstanceStrengthComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 941839219:  return getCode();
        case 3059181:  return getCode();
        case 98629247:  return getGroup();
        case -1923018202:  return getConfidentiality();
        case 1791316033:  return addStrength(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept", "Reference"};
        case 98629247: /*group*/ return new String[] {"CodeableConcept"};
        case -1923018202: /*confidentiality*/ return new String[] {"CodeableConcept"};
        case 1791316033: /*strength*/ return new String[] {"@Ingredient.substance.strength"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("codeCodeableConcept")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("codeReference")) {
          this.code = new Reference();
          return this.code;
        }
        else if (name.equals("group")) {
          this.group = new CodeableConcept();
          return this.group;
        }
        else if (name.equals("confidentiality")) {
          this.confidentiality = new CodeableConcept();
          return this.confidentiality;
        }
        else if (name.equals("strength")) {
          return addStrength();
        }
        else
          return super.addChild(name);
      }

      public IngredientSpecifiedSubstanceComponent copy() {
        IngredientSpecifiedSubstanceComponent dst = new IngredientSpecifiedSubstanceComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(IngredientSpecifiedSubstanceComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.group = group == null ? null : group.copy();
        dst.confidentiality = confidentiality == null ? null : confidentiality.copy();
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
        if (!(other_ instanceof IngredientSpecifiedSubstanceComponent))
          return false;
        IngredientSpecifiedSubstanceComponent o = (IngredientSpecifiedSubstanceComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(group, o.group, true) && compareDeep(confidentiality, o.confidentiality, true)
           && compareDeep(strength, o.strength, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof IngredientSpecifiedSubstanceComponent))
          return false;
        IngredientSpecifiedSubstanceComponent o = (IngredientSpecifiedSubstanceComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, group, confidentiality
          , strength);
      }

  public String fhirType() {
    return "Ingredient.specifiedSubstance";

  }

  }

    /**
     * The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="An identifier or code by which the ingredient can be referenced", formalDefinition="The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate." )
    protected Identifier identifier;

    /**
     * Ingredient role within a drug product e.g. Active ingredient, Excipient.
     */
    @Child(name = "role", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Ingredient role within a drug product e.g. Active ingredient, Excipient", formalDefinition="Ingredient role within a drug product e.g. Active ingredient, Excipient." )
    protected CodeableConcept role;

    /**
     * A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: Antioxidant, Alkalizing Agent.
     */
    @Child(name = "function", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: Antioxidant, Alkalizing Agent", formalDefinition="A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: Antioxidant, Alkalizing Agent." )
    protected List<CodeableConcept> function;

    /**
     * A general description of the ingredient, or any supporting text. May be used for an unstructured list of excipients.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A general description of the ingredient, or any supporting text. May be used for an unstructured list of excipients", formalDefinition="A general description of the ingredient, or any supporting text. May be used for an unstructured list of excipients." )
    protected MarkdownType description;

    /**
     * If the ingredient is a known or suspected allergen.
     */
    @Child(name = "allergenicIndicator", type = {BooleanType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If the ingredient is a known or suspected allergen", formalDefinition="If the ingredient is a known or suspected allergen." )
    protected BooleanType allergenicIndicator;

    /**
     * The organization that manufactures this ingredient.
     */
    @Child(name = "manufacturer", type = {Organization.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The organization that manufactures this ingredient", formalDefinition="The organization that manufactures this ingredient." )
    protected List<Reference> manufacturer;

    /**
     * The substance that comprises this ingredient.
     */
    @Child(name = "substance", type = {}, order=6, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The substance that comprises this ingredient", formalDefinition="The substance that comprises this ingredient." )
    protected IngredientSubstanceComponent substance;

    /**
     * A specified substance that comprises this ingredient.
     */
    @Child(name = "specifiedSubstance", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A specified substance that comprises this ingredient", formalDefinition="A specified substance that comprises this ingredient." )
    protected List<IngredientSpecifiedSubstanceComponent> specifiedSubstance;

    private static final long serialVersionUID = -1831018128L;

  /**
   * Constructor
   */
    public Ingredient() {
      super();
    }

  /**
   * Constructor
   */
    public Ingredient(CodeableConcept role) {
      super();
      this.setRole(role);
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
     * @return {@link #role} (Ingredient role within a drug product e.g. Active ingredient, Excipient.)
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
     * @param value {@link #role} (Ingredient role within a drug product e.g. Active ingredient, Excipient.)
     */
    public Ingredient setRole(CodeableConcept value) { 
      this.role = value;
      return this;
    }

    /**
     * @return {@link #function} (A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: Antioxidant, Alkalizing Agent.)
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
     * @return {@link #description} (A general description of the ingredient, or any supporting text. May be used for an unstructured list of excipients.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create Ingredient.description");
        else if (Configuration.doAutoCreate())
          this.description = new MarkdownType(); // bb
      return this.description;
    }

    public boolean hasDescriptionElement() { 
      return this.description != null && !this.description.isEmpty();
    }

    public boolean hasDescription() { 
      return this.description != null && !this.description.isEmpty();
    }

    /**
     * @param value {@link #description} (A general description of the ingredient, or any supporting text. May be used for an unstructured list of excipients.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public Ingredient setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A general description of the ingredient, or any supporting text. May be used for an unstructured list of excipients.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A general description of the ingredient, or any supporting text. May be used for an unstructured list of excipients.
     */
    public Ingredient setDescription(String value) { 
      if (value == null)
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #allergenicIndicator} (If the ingredient is a known or suspected allergen.). This is the underlying object with id, value and extensions. The accessor "getAllergenicIndicator" gives direct access to the value
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
     * @param value {@link #allergenicIndicator} (If the ingredient is a known or suspected allergen.). This is the underlying object with id, value and extensions. The accessor "getAllergenicIndicator" gives direct access to the value
     */
    public Ingredient setAllergenicIndicatorElement(BooleanType value) { 
      this.allergenicIndicator = value;
      return this;
    }

    /**
     * @return If the ingredient is a known or suspected allergen.
     */
    public boolean getAllergenicIndicator() { 
      return this.allergenicIndicator == null || this.allergenicIndicator.isEmpty() ? false : this.allergenicIndicator.getValue();
    }

    /**
     * @param value If the ingredient is a known or suspected allergen.
     */
    public Ingredient setAllergenicIndicator(boolean value) { 
        if (this.allergenicIndicator == null)
          this.allergenicIndicator = new BooleanType();
        this.allergenicIndicator.setValue(value);
      return this;
    }

    /**
     * @return {@link #manufacturer} (The organization that manufactures this ingredient.)
     */
    public List<Reference> getManufacturer() { 
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<Reference>();
      return this.manufacturer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Ingredient setManufacturer(List<Reference> theManufacturer) { 
      this.manufacturer = theManufacturer;
      return this;
    }

    public boolean hasManufacturer() { 
      if (this.manufacturer == null)
        return false;
      for (Reference item : this.manufacturer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addManufacturer() { //3
      Reference t = new Reference();
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<Reference>();
      this.manufacturer.add(t);
      return t;
    }

    public Ingredient addManufacturer(Reference t) { //3
      if (t == null)
        return this;
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<Reference>();
      this.manufacturer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #manufacturer}, creating it if it does not already exist {3}
     */
    public Reference getManufacturerFirstRep() { 
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

    /**
     * @return {@link #specifiedSubstance} (A specified substance that comprises this ingredient.)
     */
    public List<IngredientSpecifiedSubstanceComponent> getSpecifiedSubstance() { 
      if (this.specifiedSubstance == null)
        this.specifiedSubstance = new ArrayList<IngredientSpecifiedSubstanceComponent>();
      return this.specifiedSubstance;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public Ingredient setSpecifiedSubstance(List<IngredientSpecifiedSubstanceComponent> theSpecifiedSubstance) { 
      this.specifiedSubstance = theSpecifiedSubstance;
      return this;
    }

    public boolean hasSpecifiedSubstance() { 
      if (this.specifiedSubstance == null)
        return false;
      for (IngredientSpecifiedSubstanceComponent item : this.specifiedSubstance)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public IngredientSpecifiedSubstanceComponent addSpecifiedSubstance() { //3
      IngredientSpecifiedSubstanceComponent t = new IngredientSpecifiedSubstanceComponent();
      if (this.specifiedSubstance == null)
        this.specifiedSubstance = new ArrayList<IngredientSpecifiedSubstanceComponent>();
      this.specifiedSubstance.add(t);
      return t;
    }

    public Ingredient addSpecifiedSubstance(IngredientSpecifiedSubstanceComponent t) { //3
      if (t == null)
        return this;
      if (this.specifiedSubstance == null)
        this.specifiedSubstance = new ArrayList<IngredientSpecifiedSubstanceComponent>();
      this.specifiedSubstance.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #specifiedSubstance}, creating it if it does not already exist {3}
     */
    public IngredientSpecifiedSubstanceComponent getSpecifiedSubstanceFirstRep() { 
      if (getSpecifiedSubstance().isEmpty()) {
        addSpecifiedSubstance();
      }
      return getSpecifiedSubstance().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate.", 0, 1, identifier));
        children.add(new Property("role", "CodeableConcept", "Ingredient role within a drug product e.g. Active ingredient, Excipient.", 0, 1, role));
        children.add(new Property("function", "CodeableConcept", "A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: Antioxidant, Alkalizing Agent.", 0, java.lang.Integer.MAX_VALUE, function));
        children.add(new Property("description", "markdown", "A general description of the ingredient, or any supporting text. May be used for an unstructured list of excipients.", 0, 1, description));
        children.add(new Property("allergenicIndicator", "boolean", "If the ingredient is a known or suspected allergen.", 0, 1, allergenicIndicator));
        children.add(new Property("manufacturer", "Reference(Organization)", "The organization that manufactures this ingredient.", 0, java.lang.Integer.MAX_VALUE, manufacturer));
        children.add(new Property("substance", "", "The substance that comprises this ingredient.", 0, 1, substance));
        children.add(new Property("specifiedSubstance", "", "A specified substance that comprises this ingredient.", 0, java.lang.Integer.MAX_VALUE, specifiedSubstance));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "The identifier(s) of this Ingredient that are assigned by business processes and/or used to refer to it when a direct URL reference to the resource itself is not appropriate.", 0, 1, identifier);
        case 3506294: /*role*/  return new Property("role", "CodeableConcept", "Ingredient role within a drug product e.g. Active ingredient, Excipient.", 0, 1, role);
        case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "A classification of the ingredient identifying its precise purpose(s) in the drug product. This extends the Ingredient.role to add more detail. Example: Antioxidant, Alkalizing Agent.", 0, java.lang.Integer.MAX_VALUE, function);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A general description of the ingredient, or any supporting text. May be used for an unstructured list of excipients.", 0, 1, description);
        case 75406931: /*allergenicIndicator*/  return new Property("allergenicIndicator", "boolean", "If the ingredient is a known or suspected allergen.", 0, 1, allergenicIndicator);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "The organization that manufactures this ingredient.", 0, java.lang.Integer.MAX_VALUE, manufacturer);
        case 530040176: /*substance*/  return new Property("substance", "", "The substance that comprises this ingredient.", 0, 1, substance);
        case -331477600: /*specifiedSubstance*/  return new Property("specifiedSubstance", "", "A specified substance that comprises this ingredient.", 0, java.lang.Integer.MAX_VALUE, specifiedSubstance);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : this.function.toArray(new Base[this.function.size()]); // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case 75406931: /*allergenicIndicator*/ return this.allergenicIndicator == null ? new Base[0] : new Base[] {this.allergenicIndicator}; // BooleanType
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // Reference
        case 530040176: /*substance*/ return this.substance == null ? new Base[0] : new Base[] {this.substance}; // IngredientSubstanceComponent
        case -331477600: /*specifiedSubstance*/ return this.specifiedSubstance == null ? new Base[0] : this.specifiedSubstance.toArray(new Base[this.specifiedSubstance.size()]); // IngredientSpecifiedSubstanceComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1380938712: // function
          this.getFunction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 75406931: // allergenicIndicator
          this.allergenicIndicator = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1969347631: // manufacturer
          this.getManufacturer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 530040176: // substance
          this.substance = (IngredientSubstanceComponent) value; // IngredientSubstanceComponent
          return value;
        case -331477600: // specifiedSubstance
          this.getSpecifiedSubstance().add((IngredientSpecifiedSubstanceComponent) value); // IngredientSpecifiedSubstanceComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("function")) {
          this.getFunction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("allergenicIndicator")) {
          this.allergenicIndicator = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("substance")) {
          this.substance = (IngredientSubstanceComponent) value; // IngredientSubstanceComponent
        } else if (name.equals("specifiedSubstance")) {
          this.getSpecifiedSubstance().add((IngredientSpecifiedSubstanceComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return getIdentifier();
        case 3506294:  return getRole();
        case 1380938712:  return addFunction(); 
        case -1724546052:  return getDescriptionElement();
        case 75406931:  return getAllergenicIndicatorElement();
        case -1969347631:  return addManufacturer(); 
        case 530040176:  return getSubstance();
        case -331477600:  return addSpecifiedSubstance(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case 75406931: /*allergenicIndicator*/ return new String[] {"boolean"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case 530040176: /*substance*/ return new String[] {};
        case -331477600: /*specifiedSubstance*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("function")) {
          return addFunction();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type Ingredient.description");
        }
        else if (name.equals("allergenicIndicator")) {
          throw new FHIRException("Cannot call addChild on a primitive type Ingredient.allergenicIndicator");
        }
        else if (name.equals("manufacturer")) {
          return addManufacturer();
        }
        else if (name.equals("substance")) {
          this.substance = new IngredientSubstanceComponent();
          return this.substance;
        }
        else if (name.equals("specifiedSubstance")) {
          return addSpecifiedSubstance();
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
        dst.role = role == null ? null : role.copy();
        if (function != null) {
          dst.function = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : function)
            dst.function.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        dst.allergenicIndicator = allergenicIndicator == null ? null : allergenicIndicator.copy();
        if (manufacturer != null) {
          dst.manufacturer = new ArrayList<Reference>();
          for (Reference i : manufacturer)
            dst.manufacturer.add(i.copy());
        };
        dst.substance = substance == null ? null : substance.copy();
        if (specifiedSubstance != null) {
          dst.specifiedSubstance = new ArrayList<IngredientSpecifiedSubstanceComponent>();
          for (IngredientSpecifiedSubstanceComponent i : specifiedSubstance)
            dst.specifiedSubstance.add(i.copy());
        };
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
        return compareDeep(identifier, o.identifier, true) && compareDeep(role, o.role, true) && compareDeep(function, o.function, true)
           && compareDeep(description, o.description, true) && compareDeep(allergenicIndicator, o.allergenicIndicator, true)
           && compareDeep(manufacturer, o.manufacturer, true) && compareDeep(substance, o.substance, true)
           && compareDeep(specifiedSubstance, o.specifiedSubstance, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof Ingredient))
          return false;
        Ingredient o = (Ingredient) other_;
        return compareValues(description, o.description, true) && compareValues(allergenicIndicator, o.allergenicIndicator, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, role, function
          , description, allergenicIndicator, manufacturer, substance, specifiedSubstance);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.Ingredient;
   }

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
   * Path: <b>Ingredient.manufacturer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manufacturer", path="Ingredient.manufacturer", description="The organization that manufactures this ingredient", type="reference", target={Organization.class } )
  public static final String SP_MANUFACTURER = "manufacturer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manufacturer</b>
   * <p>
   * Description: <b>The organization that manufactures this ingredient</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.manufacturer</b><br>
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
   * Description: <b>Ingredient role within a drug product e.g. Active ingredient, Excipient</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.role</b><br>
   * </p>
   */
  @SearchParamDefinition(name="role", path="Ingredient.role", description="Ingredient role within a drug product e.g. Active ingredient, Excipient", type="token" )
  public static final String SP_ROLE = "role";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>role</b>
   * <p>
   * Description: <b>Ingredient role within a drug product e.g. Active ingredient, Excipient</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.role</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam ROLE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_ROLE);

 /**
   * Search parameter: <b>specified-substance-code</b>
   * <p>
   * Description: <b>Substance as a 'specified substance', implying extra substance related characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.specifiedSubstance.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specified-substance-code", path="Ingredient.specifiedSubstance.code", description="Substance as a 'specified substance', implying extra substance related characteristics", type="token" )
  public static final String SP_SPECIFIED_SUBSTANCE_CODE = "specified-substance-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specified-substance-code</b>
   * <p>
   * Description: <b>Substance as a 'specified substance', implying extra substance related characteristics</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.specifiedSubstance.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SPECIFIED_SUBSTANCE_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SPECIFIED_SUBSTANCE_CODE);

 /**
   * Search parameter: <b>specified-substance-definition</b>
   * <p>
   * Description: <b>Substance as a 'specified substance', implying extra substance related characteristics</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.specifiedSubstance.code.where(resolve() is SubstanceDefinition)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specified-substance-definition", path="Ingredient.specifiedSubstance.code.where(resolve() is SubstanceDefinition)", description="Substance as a 'specified substance', implying extra substance related characteristics", type="reference", target={SubstanceDefinition.class } )
  public static final String SP_SPECIFIED_SUBSTANCE_DEFINITION = "specified-substance-definition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specified-substance-definition</b>
   * <p>
   * Description: <b>Substance as a 'specified substance', implying extra substance related characteristics</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.specifiedSubstance.code.where(resolve() is SubstanceDefinition)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SPECIFIED_SUBSTANCE_DEFINITION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SPECIFIED_SUBSTANCE_DEFINITION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Ingredient:specified-substance-definition</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SPECIFIED_SUBSTANCE_DEFINITION = new ca.uhn.fhir.model.api.Include("Ingredient:specified-substance-definition").toLocked();

 /**
   * Search parameter: <b>specified-substance</b>
   * <p>
   * Description: <b>Substance as a 'specified substance', implying extra substance related characteristics</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.specifiedSubstance.code.where(resolve() is Substance)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="specified-substance", path="Ingredient.specifiedSubstance.code.where(resolve() is Substance)", description="Substance as a 'specified substance', implying extra substance related characteristics", type="reference", target={Substance.class } )
  public static final String SP_SPECIFIED_SUBSTANCE = "specified-substance";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>specified-substance</b>
   * <p>
   * Description: <b>Substance as a 'specified substance', implying extra substance related characteristics</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.specifiedSubstance.code.where(resolve() is Substance)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SPECIFIED_SUBSTANCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SPECIFIED_SUBSTANCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Ingredient:specified-substance</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SPECIFIED_SUBSTANCE = new ca.uhn.fhir.model.api.Include("Ingredient:specified-substance").toLocked();

 /**
   * Search parameter: <b>substance-code</b>
   * <p>
   * Description: <b>A code or full resource that represents the ingredient substance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.substance.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="substance-code", path="Ingredient.substance.code", description="A code or full resource that represents the ingredient substance", type="token" )
  public static final String SP_SUBSTANCE_CODE = "substance-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>substance-code</b>
   * <p>
   * Description: <b>A code or full resource that represents the ingredient substance</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Ingredient.substance.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SUBSTANCE_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SUBSTANCE_CODE);

 /**
   * Search parameter: <b>substance-definition</b>
   * <p>
   * Description: <b>A code or full resource that represents the ingredient substance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.substance.code.where(resolve() is SubstanceDefinition)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="substance-definition", path="Ingredient.substance.code.where(resolve() is SubstanceDefinition)", description="A code or full resource that represents the ingredient substance", type="reference", target={SubstanceDefinition.class } )
  public static final String SP_SUBSTANCE_DEFINITION = "substance-definition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>substance-definition</b>
   * <p>
   * Description: <b>A code or full resource that represents the ingredient substance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.substance.code.where(resolve() is SubstanceDefinition)</b><br>
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
   * Description: <b>A code or full resource that represents the ingredient substance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.substance.code.where(resolve() is Substance)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="substance", path="Ingredient.substance.code.where(resolve() is Substance)", description="A code or full resource that represents the ingredient substance", type="reference", target={Substance.class } )
  public static final String SP_SUBSTANCE = "substance";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>substance</b>
   * <p>
   * Description: <b>A code or full resource that represents the ingredient substance</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Ingredient.substance.code.where(resolve() is Substance)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBSTANCE = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBSTANCE);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>Ingredient:substance</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBSTANCE = new ca.uhn.fhir.model.api.Include("Ingredient:substance").toLocked();


}

