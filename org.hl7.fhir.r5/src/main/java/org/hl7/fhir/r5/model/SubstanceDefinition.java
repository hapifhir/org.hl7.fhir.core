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
 * The detailed description of a substance, typically at a level beyond what is used for prescribing.
 */
@ResourceDef(name="SubstanceDefinition", profile="http://hl7.org/fhir/StructureDefinition/SubstanceDefinition")
public class SubstanceDefinition extends DomainResource {

    @Block()
    public static class SubstanceDefinitionMoietyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Role that the moiety is playing.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Role that the moiety is playing", formalDefinition="Role that the moiety is playing." )
        protected CodeableConcept role;

        /**
         * Identifier by which this moiety substance is known.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Identifier by which this moiety substance is known", formalDefinition="Identifier by which this moiety substance is known." )
        protected Identifier identifier;

        /**
         * Textual name for this moiety substance.
         */
        @Child(name = "name", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Textual name for this moiety substance", formalDefinition="Textual name for this moiety substance." )
        protected StringType name;

        /**
         * Stereochemistry type.
         */
        @Child(name = "stereochemistry", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Stereochemistry type", formalDefinition="Stereochemistry type." )
        protected CodeableConcept stereochemistry;

        /**
         * Optical activity type.
         */
        @Child(name = "opticalActivity", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Optical activity type", formalDefinition="Optical activity type." )
        protected CodeableConcept opticalActivity;

        /**
         * Molecular formula for this moiety of this substance, typically using the Hill system.
         */
        @Child(name = "molecularFormula", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Molecular formula for this moiety of this substance, typically using the Hill system", formalDefinition="Molecular formula for this moiety of this substance, typically using the Hill system." )
        protected StringType molecularFormula;

        /**
         * Quantitative value for this moiety.
         */
        @Child(name = "amount", type = {Quantity.class, StringType.class}, order=7, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Quantitative value for this moiety", formalDefinition="Quantitative value for this moiety." )
        protected DataType amount;

        /**
         * The measurement type of the quantitative value.
         */
        @Child(name = "amountType", type = {CodeableConcept.class}, order=8, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The measurement type of the quantitative value", formalDefinition="The measurement type of the quantitative value." )
        protected CodeableConcept amountType;

        private static final long serialVersionUID = -1330905924L;

    /**
     * Constructor
     */
      public SubstanceDefinitionMoietyComponent() {
        super();
      }

        /**
         * @return {@link #role} (Role that the moiety is playing.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionMoietyComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (Role that the moiety is playing.)
         */
        public SubstanceDefinitionMoietyComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #identifier} (Identifier by which this moiety substance is known.)
         */
        public Identifier getIdentifier() { 
          if (this.identifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionMoietyComponent.identifier");
            else if (Configuration.doAutoCreate())
              this.identifier = new Identifier(); // cc
          return this.identifier;
        }

        public boolean hasIdentifier() { 
          return this.identifier != null && !this.identifier.isEmpty();
        }

        /**
         * @param value {@link #identifier} (Identifier by which this moiety substance is known.)
         */
        public SubstanceDefinitionMoietyComponent setIdentifier(Identifier value) { 
          this.identifier = value;
          return this;
        }

        /**
         * @return {@link #name} (Textual name for this moiety substance.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionMoietyComponent.name");
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
         * @param value {@link #name} (Textual name for this moiety substance.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public SubstanceDefinitionMoietyComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Textual name for this moiety substance.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Textual name for this moiety substance.
         */
        public SubstanceDefinitionMoietyComponent setName(String value) { 
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
         * @return {@link #stereochemistry} (Stereochemistry type.)
         */
        public CodeableConcept getStereochemistry() { 
          if (this.stereochemistry == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionMoietyComponent.stereochemistry");
            else if (Configuration.doAutoCreate())
              this.stereochemistry = new CodeableConcept(); // cc
          return this.stereochemistry;
        }

        public boolean hasStereochemistry() { 
          return this.stereochemistry != null && !this.stereochemistry.isEmpty();
        }

        /**
         * @param value {@link #stereochemistry} (Stereochemistry type.)
         */
        public SubstanceDefinitionMoietyComponent setStereochemistry(CodeableConcept value) { 
          this.stereochemistry = value;
          return this;
        }

        /**
         * @return {@link #opticalActivity} (Optical activity type.)
         */
        public CodeableConcept getOpticalActivity() { 
          if (this.opticalActivity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionMoietyComponent.opticalActivity");
            else if (Configuration.doAutoCreate())
              this.opticalActivity = new CodeableConcept(); // cc
          return this.opticalActivity;
        }

        public boolean hasOpticalActivity() { 
          return this.opticalActivity != null && !this.opticalActivity.isEmpty();
        }

        /**
         * @param value {@link #opticalActivity} (Optical activity type.)
         */
        public SubstanceDefinitionMoietyComponent setOpticalActivity(CodeableConcept value) { 
          this.opticalActivity = value;
          return this;
        }

        /**
         * @return {@link #molecularFormula} (Molecular formula for this moiety of this substance, typically using the Hill system.). This is the underlying object with id, value and extensions. The accessor "getMolecularFormula" gives direct access to the value
         */
        public StringType getMolecularFormulaElement() { 
          if (this.molecularFormula == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionMoietyComponent.molecularFormula");
            else if (Configuration.doAutoCreate())
              this.molecularFormula = new StringType(); // bb
          return this.molecularFormula;
        }

        public boolean hasMolecularFormulaElement() { 
          return this.molecularFormula != null && !this.molecularFormula.isEmpty();
        }

        public boolean hasMolecularFormula() { 
          return this.molecularFormula != null && !this.molecularFormula.isEmpty();
        }

        /**
         * @param value {@link #molecularFormula} (Molecular formula for this moiety of this substance, typically using the Hill system.). This is the underlying object with id, value and extensions. The accessor "getMolecularFormula" gives direct access to the value
         */
        public SubstanceDefinitionMoietyComponent setMolecularFormulaElement(StringType value) { 
          this.molecularFormula = value;
          return this;
        }

        /**
         * @return Molecular formula for this moiety of this substance, typically using the Hill system.
         */
        public String getMolecularFormula() { 
          return this.molecularFormula == null ? null : this.molecularFormula.getValue();
        }

        /**
         * @param value Molecular formula for this moiety of this substance, typically using the Hill system.
         */
        public SubstanceDefinitionMoietyComponent setMolecularFormula(String value) { 
          if (Utilities.noString(value))
            this.molecularFormula = null;
          else {
            if (this.molecularFormula == null)
              this.molecularFormula = new StringType();
            this.molecularFormula.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #amount} (Quantitative value for this moiety.)
         */
        public DataType getAmount() { 
          return this.amount;
        }

        /**
         * @return {@link #amount} (Quantitative value for this moiety.)
         */
        public Quantity getAmountQuantity() throws FHIRException { 
          if (this.amount == null)
            this.amount = new Quantity();
          if (!(this.amount instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (Quantity) this.amount;
        }

        public boolean hasAmountQuantity() { 
          return this != null && this.amount instanceof Quantity;
        }

        /**
         * @return {@link #amount} (Quantitative value for this moiety.)
         */
        public StringType getAmountStringType() throws FHIRException { 
          if (this.amount == null)
            this.amount = new StringType();
          if (!(this.amount instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (StringType) this.amount;
        }

        public boolean hasAmountStringType() { 
          return this != null && this.amount instanceof StringType;
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (Quantitative value for this moiety.)
         */
        public SubstanceDefinitionMoietyComponent setAmount(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof StringType))
            throw new Error("Not the right type for SubstanceDefinition.moiety.amount[x]: "+value.fhirType());
          this.amount = value;
          return this;
        }

        /**
         * @return {@link #amountType} (The measurement type of the quantitative value.)
         */
        public CodeableConcept getAmountType() { 
          if (this.amountType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionMoietyComponent.amountType");
            else if (Configuration.doAutoCreate())
              this.amountType = new CodeableConcept(); // cc
          return this.amountType;
        }

        public boolean hasAmountType() { 
          return this.amountType != null && !this.amountType.isEmpty();
        }

        /**
         * @param value {@link #amountType} (The measurement type of the quantitative value.)
         */
        public SubstanceDefinitionMoietyComponent setAmountType(CodeableConcept value) { 
          this.amountType = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("role", "CodeableConcept", "Role that the moiety is playing.", 0, 1, role));
          children.add(new Property("identifier", "Identifier", "Identifier by which this moiety substance is known.", 0, 1, identifier));
          children.add(new Property("name", "string", "Textual name for this moiety substance.", 0, 1, name));
          children.add(new Property("stereochemistry", "CodeableConcept", "Stereochemistry type.", 0, 1, stereochemistry));
          children.add(new Property("opticalActivity", "CodeableConcept", "Optical activity type.", 0, 1, opticalActivity));
          children.add(new Property("molecularFormula", "string", "Molecular formula for this moiety of this substance, typically using the Hill system.", 0, 1, molecularFormula));
          children.add(new Property("amount[x]", "Quantity|string", "Quantitative value for this moiety.", 0, 1, amount));
          children.add(new Property("amountType", "CodeableConcept", "The measurement type of the quantitative value.", 0, 1, amountType));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "Role that the moiety is playing.", 0, 1, role);
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier by which this moiety substance is known.", 0, 1, identifier);
          case 3373707: /*name*/  return new Property("name", "string", "Textual name for this moiety substance.", 0, 1, name);
          case 263475116: /*stereochemistry*/  return new Property("stereochemistry", "CodeableConcept", "Stereochemistry type.", 0, 1, stereochemistry);
          case 1420900135: /*opticalActivity*/  return new Property("opticalActivity", "CodeableConcept", "Optical activity type.", 0, 1, opticalActivity);
          case 616660246: /*molecularFormula*/  return new Property("molecularFormula", "string", "Molecular formula for this moiety of this substance, typically using the Hill system.", 0, 1, molecularFormula);
          case 646780200: /*amount[x]*/  return new Property("amount[x]", "Quantity|string", "Quantitative value for this moiety.", 0, 1, amount);
          case -1413853096: /*amount*/  return new Property("amount[x]", "Quantity|string", "Quantitative value for this moiety.", 0, 1, amount);
          case 1664303363: /*amountQuantity*/  return new Property("amount[x]", "Quantity", "Quantitative value for this moiety.", 0, 1, amount);
          case 773651081: /*amountString*/  return new Property("amount[x]", "string", "Quantitative value for this moiety.", 0, 1, amount);
          case -1424857166: /*amountType*/  return new Property("amountType", "CodeableConcept", "The measurement type of the quantitative value.", 0, 1, amountType);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 263475116: /*stereochemistry*/ return this.stereochemistry == null ? new Base[0] : new Base[] {this.stereochemistry}; // CodeableConcept
        case 1420900135: /*opticalActivity*/ return this.opticalActivity == null ? new Base[0] : new Base[] {this.opticalActivity}; // CodeableConcept
        case 616660246: /*molecularFormula*/ return this.molecularFormula == null ? new Base[0] : new Base[] {this.molecularFormula}; // StringType
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // DataType
        case -1424857166: /*amountType*/ return this.amountType == null ? new Base[0] : new Base[] {this.amountType}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1618432855: // identifier
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 263475116: // stereochemistry
          this.stereochemistry = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1420900135: // opticalActivity
          this.opticalActivity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 616660246: // molecularFormula
          this.molecularFormula = TypeConvertor.castToString(value); // StringType
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToType(value); // DataType
          return value;
        case -1424857166: // amountType
          this.amountType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("stereochemistry")) {
          this.stereochemistry = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("opticalActivity")) {
          this.opticalActivity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("molecularFormula")) {
          this.molecularFormula = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("amount[x]")) {
          this.amount = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("amountType")) {
          this.amountType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294:  return getRole();
        case -1618432855:  return getIdentifier();
        case 3373707:  return getNameElement();
        case 263475116:  return getStereochemistry();
        case 1420900135:  return getOpticalActivity();
        case 616660246:  return getMolecularFormulaElement();
        case 646780200:  return getAmount();
        case -1413853096:  return getAmount();
        case -1424857166:  return getAmountType();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 263475116: /*stereochemistry*/ return new String[] {"CodeableConcept"};
        case 1420900135: /*opticalActivity*/ return new String[] {"CodeableConcept"};
        case 616660246: /*molecularFormula*/ return new String[] {"string"};
        case -1413853096: /*amount*/ return new String[] {"Quantity", "string"};
        case -1424857166: /*amountType*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.moiety.name");
        }
        else if (name.equals("stereochemistry")) {
          this.stereochemistry = new CodeableConcept();
          return this.stereochemistry;
        }
        else if (name.equals("opticalActivity")) {
          this.opticalActivity = new CodeableConcept();
          return this.opticalActivity;
        }
        else if (name.equals("molecularFormula")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.moiety.molecularFormula");
        }
        else if (name.equals("amountQuantity")) {
          this.amount = new Quantity();
          return this.amount;
        }
        else if (name.equals("amountString")) {
          this.amount = new StringType();
          return this.amount;
        }
        else if (name.equals("amountType")) {
          this.amountType = new CodeableConcept();
          return this.amountType;
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionMoietyComponent copy() {
        SubstanceDefinitionMoietyComponent dst = new SubstanceDefinitionMoietyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionMoietyComponent dst) {
        super.copyValues(dst);
        dst.role = role == null ? null : role.copy();
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.name = name == null ? null : name.copy();
        dst.stereochemistry = stereochemistry == null ? null : stereochemistry.copy();
        dst.opticalActivity = opticalActivity == null ? null : opticalActivity.copy();
        dst.molecularFormula = molecularFormula == null ? null : molecularFormula.copy();
        dst.amount = amount == null ? null : amount.copy();
        dst.amountType = amountType == null ? null : amountType.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionMoietyComponent))
          return false;
        SubstanceDefinitionMoietyComponent o = (SubstanceDefinitionMoietyComponent) other_;
        return compareDeep(role, o.role, true) && compareDeep(identifier, o.identifier, true) && compareDeep(name, o.name, true)
           && compareDeep(stereochemistry, o.stereochemistry, true) && compareDeep(opticalActivity, o.opticalActivity, true)
           && compareDeep(molecularFormula, o.molecularFormula, true) && compareDeep(amount, o.amount, true)
           && compareDeep(amountType, o.amountType, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionMoietyComponent))
          return false;
        SubstanceDefinitionMoietyComponent o = (SubstanceDefinitionMoietyComponent) other_;
        return compareValues(name, o.name, true) && compareValues(molecularFormula, o.molecularFormula, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(role, identifier, name, stereochemistry
          , opticalActivity, molecularFormula, amount, amountType);
      }

  public String fhirType() {
    return "SubstanceDefinition.moiety";

  }

  }

    @Block()
    public static class SubstanceDefinitionPropertyComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A category for this property, e.g. Physical, Chemical, Enzymatic.
         */
        @Child(name = "category", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A category for this property, e.g. Physical, Chemical, Enzymatic", formalDefinition="A category for this property, e.g. Physical, Chemical, Enzymatic." )
        protected CodeableConcept category;

        /**
         * Property type e.g. viscosity, pH, isoelectric point.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Property type e.g. viscosity, pH, isoelectric point", formalDefinition="Property type e.g. viscosity, pH, isoelectric point." )
        protected CodeableConcept code;

        /**
         * Parameters that were used in the measurement of a property (e.g. for viscosity: measured at 20C with a pH of 7.1).
         */
        @Child(name = "parameters", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Parameters that were used in the measurement of a property (e.g. for viscosity: measured at 20C with a pH of 7.1)", formalDefinition="Parameters that were used in the measurement of a property (e.g. for viscosity: measured at 20C with a pH of 7.1)." )
        protected StringType parameters;

        /**
         * A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).
         */
        @Child(name = "definingSubstance", type = {SubstanceDefinition.class, Substance.class, CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol)", formalDefinition="A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol)." )
        protected DataType definingSubstance;

        /**
         * Quantitative value for this property.
         */
        @Child(name = "amount", type = {Quantity.class, StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Quantitative value for this property", formalDefinition="Quantitative value for this property." )
        protected DataType amount;

        /**
         * Range of typical values.
         */
        @Child(name = "referenceRange", type = {Range.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Range of typical values", formalDefinition="Range of typical values." )
        protected Range referenceRange;

        /**
         * Supporting literature.
         */
        @Child(name = "source", type = {DocumentReference.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Supporting literature", formalDefinition="Supporting literature." )
        protected List<Reference> source;

        private static final long serialVersionUID = 1019727375L;

    /**
     * Constructor
     */
      public SubstanceDefinitionPropertyComponent() {
        super();
      }

        /**
         * @return {@link #category} (A category for this property, e.g. Physical, Chemical, Enzymatic.)
         */
        public CodeableConcept getCategory() { 
          if (this.category == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionPropertyComponent.category");
            else if (Configuration.doAutoCreate())
              this.category = new CodeableConcept(); // cc
          return this.category;
        }

        public boolean hasCategory() { 
          return this.category != null && !this.category.isEmpty();
        }

        /**
         * @param value {@link #category} (A category for this property, e.g. Physical, Chemical, Enzymatic.)
         */
        public SubstanceDefinitionPropertyComponent setCategory(CodeableConcept value) { 
          this.category = value;
          return this;
        }

        /**
         * @return {@link #code} (Property type e.g. viscosity, pH, isoelectric point.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionPropertyComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Property type e.g. viscosity, pH, isoelectric point.)
         */
        public SubstanceDefinitionPropertyComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #parameters} (Parameters that were used in the measurement of a property (e.g. for viscosity: measured at 20C with a pH of 7.1).). This is the underlying object with id, value and extensions. The accessor "getParameters" gives direct access to the value
         */
        public StringType getParametersElement() { 
          if (this.parameters == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionPropertyComponent.parameters");
            else if (Configuration.doAutoCreate())
              this.parameters = new StringType(); // bb
          return this.parameters;
        }

        public boolean hasParametersElement() { 
          return this.parameters != null && !this.parameters.isEmpty();
        }

        public boolean hasParameters() { 
          return this.parameters != null && !this.parameters.isEmpty();
        }

        /**
         * @param value {@link #parameters} (Parameters that were used in the measurement of a property (e.g. for viscosity: measured at 20C with a pH of 7.1).). This is the underlying object with id, value and extensions. The accessor "getParameters" gives direct access to the value
         */
        public SubstanceDefinitionPropertyComponent setParametersElement(StringType value) { 
          this.parameters = value;
          return this;
        }

        /**
         * @return Parameters that were used in the measurement of a property (e.g. for viscosity: measured at 20C with a pH of 7.1).
         */
        public String getParameters() { 
          return this.parameters == null ? null : this.parameters.getValue();
        }

        /**
         * @param value Parameters that were used in the measurement of a property (e.g. for viscosity: measured at 20C with a pH of 7.1).
         */
        public SubstanceDefinitionPropertyComponent setParameters(String value) { 
          if (Utilities.noString(value))
            this.parameters = null;
          else {
            if (this.parameters == null)
              this.parameters = new StringType();
            this.parameters.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #definingSubstance} (A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).)
         */
        public DataType getDefiningSubstance() { 
          return this.definingSubstance;
        }

        /**
         * @return {@link #definingSubstance} (A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).)
         */
        public Reference getDefiningSubstanceReference() throws FHIRException { 
          if (this.definingSubstance == null)
            this.definingSubstance = new Reference();
          if (!(this.definingSubstance instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.definingSubstance.getClass().getName()+" was encountered");
          return (Reference) this.definingSubstance;
        }

        public boolean hasDefiningSubstanceReference() { 
          return this != null && this.definingSubstance instanceof Reference;
        }

        /**
         * @return {@link #definingSubstance} (A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).)
         */
        public CodeableConcept getDefiningSubstanceCodeableConcept() throws FHIRException { 
          if (this.definingSubstance == null)
            this.definingSubstance = new CodeableConcept();
          if (!(this.definingSubstance instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.definingSubstance.getClass().getName()+" was encountered");
          return (CodeableConcept) this.definingSubstance;
        }

        public boolean hasDefiningSubstanceCodeableConcept() { 
          return this != null && this.definingSubstance instanceof CodeableConcept;
        }

        public boolean hasDefiningSubstance() { 
          return this.definingSubstance != null && !this.definingSubstance.isEmpty();
        }

        /**
         * @param value {@link #definingSubstance} (A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).)
         */
        public SubstanceDefinitionPropertyComponent setDefiningSubstance(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
            throw new Error("Not the right type for SubstanceDefinition.property.definingSubstance[x]: "+value.fhirType());
          this.definingSubstance = value;
          return this;
        }

        /**
         * @return {@link #amount} (Quantitative value for this property.)
         */
        public DataType getAmount() { 
          return this.amount;
        }

        /**
         * @return {@link #amount} (Quantitative value for this property.)
         */
        public Quantity getAmountQuantity() throws FHIRException { 
          if (this.amount == null)
            this.amount = new Quantity();
          if (!(this.amount instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (Quantity) this.amount;
        }

        public boolean hasAmountQuantity() { 
          return this != null && this.amount instanceof Quantity;
        }

        /**
         * @return {@link #amount} (Quantitative value for this property.)
         */
        public StringType getAmountStringType() throws FHIRException { 
          if (this.amount == null)
            this.amount = new StringType();
          if (!(this.amount instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (StringType) this.amount;
        }

        public boolean hasAmountStringType() { 
          return this != null && this.amount instanceof StringType;
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (Quantitative value for this property.)
         */
        public SubstanceDefinitionPropertyComponent setAmount(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof StringType))
            throw new Error("Not the right type for SubstanceDefinition.property.amount[x]: "+value.fhirType());
          this.amount = value;
          return this;
        }

        /**
         * @return {@link #referenceRange} (Range of typical values.)
         */
        public Range getReferenceRange() { 
          if (this.referenceRange == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionPropertyComponent.referenceRange");
            else if (Configuration.doAutoCreate())
              this.referenceRange = new Range(); // cc
          return this.referenceRange;
        }

        public boolean hasReferenceRange() { 
          return this.referenceRange != null && !this.referenceRange.isEmpty();
        }

        /**
         * @param value {@link #referenceRange} (Range of typical values.)
         */
        public SubstanceDefinitionPropertyComponent setReferenceRange(Range value) { 
          this.referenceRange = value;
          return this;
        }

        /**
         * @return {@link #source} (Supporting literature.)
         */
        public List<Reference> getSource() { 
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          return this.source;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionPropertyComponent setSource(List<Reference> theSource) { 
          this.source = theSource;
          return this;
        }

        public boolean hasSource() { 
          if (this.source == null)
            return false;
          for (Reference item : this.source)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addSource() { //3
          Reference t = new Reference();
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          this.source.add(t);
          return t;
        }

        public SubstanceDefinitionPropertyComponent addSource(Reference t) { //3
          if (t == null)
            return this;
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          this.source.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #source}, creating it if it does not already exist {3}
         */
        public Reference getSourceFirstRep() { 
          if (getSource().isEmpty()) {
            addSource();
          }
          return getSource().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("category", "CodeableConcept", "A category for this property, e.g. Physical, Chemical, Enzymatic.", 0, 1, category));
          children.add(new Property("code", "CodeableConcept", "Property type e.g. viscosity, pH, isoelectric point.", 0, 1, code));
          children.add(new Property("parameters", "string", "Parameters that were used in the measurement of a property (e.g. for viscosity: measured at 20C with a pH of 7.1).", 0, 1, parameters));
          children.add(new Property("definingSubstance[x]", "Reference(SubstanceDefinition|Substance)|CodeableConcept", "A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).", 0, 1, definingSubstance));
          children.add(new Property("amount[x]", "Quantity|string", "Quantitative value for this property.", 0, 1, amount));
          children.add(new Property("referenceRange", "Range", "Range of typical values.", 0, 1, referenceRange));
          children.add(new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 50511102: /*category*/  return new Property("category", "CodeableConcept", "A category for this property, e.g. Physical, Chemical, Enzymatic.", 0, 1, category);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Property type e.g. viscosity, pH, isoelectric point.", 0, 1, code);
          case 458736106: /*parameters*/  return new Property("parameters", "string", "Parameters that were used in the measurement of a property (e.g. for viscosity: measured at 20C with a pH of 7.1).", 0, 1, parameters);
          case 1535270120: /*definingSubstance[x]*/  return new Property("definingSubstance[x]", "Reference(SubstanceDefinition|Substance)|CodeableConcept", "A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).", 0, 1, definingSubstance);
          case 1901076632: /*definingSubstance*/  return new Property("definingSubstance[x]", "Reference(SubstanceDefinition|Substance)|CodeableConcept", "A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).", 0, 1, definingSubstance);
          case -2101581421: /*definingSubstanceReference*/  return new Property("definingSubstance[x]", "Reference(SubstanceDefinition|Substance)", "A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).", 0, 1, definingSubstance);
          case -1438235671: /*definingSubstanceCodeableConcept*/  return new Property("definingSubstance[x]", "CodeableConcept", "A substance upon which a defining property depends (e.g. for solubility: in water, in alcohol).", 0, 1, definingSubstance);
          case 646780200: /*amount[x]*/  return new Property("amount[x]", "Quantity|string", "Quantitative value for this property.", 0, 1, amount);
          case -1413853096: /*amount*/  return new Property("amount[x]", "Quantity|string", "Quantitative value for this property.", 0, 1, amount);
          case 1664303363: /*amountQuantity*/  return new Property("amount[x]", "Quantity", "Quantitative value for this property.", 0, 1, amount);
          case 773651081: /*amountString*/  return new Property("amount[x]", "string", "Quantitative value for this property.", 0, 1, amount);
          case -1912545102: /*referenceRange*/  return new Property("referenceRange", "Range", "Range of typical values.", 0, 1, referenceRange);
          case -896505829: /*source*/  return new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 458736106: /*parameters*/ return this.parameters == null ? new Base[0] : new Base[] {this.parameters}; // StringType
        case 1901076632: /*definingSubstance*/ return this.definingSubstance == null ? new Base[0] : new Base[] {this.definingSubstance}; // DataType
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // DataType
        case -1912545102: /*referenceRange*/ return this.referenceRange == null ? new Base[0] : new Base[] {this.referenceRange}; // Range
        case -896505829: /*source*/ return this.source == null ? new Base[0] : this.source.toArray(new Base[this.source.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 50511102: // category
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 458736106: // parameters
          this.parameters = TypeConvertor.castToString(value); // StringType
          return value;
        case 1901076632: // definingSubstance
          this.definingSubstance = TypeConvertor.castToType(value); // DataType
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToType(value); // DataType
          return value;
        case -1912545102: // referenceRange
          this.referenceRange = TypeConvertor.castToRange(value); // Range
          return value;
        case -896505829: // source
          this.getSource().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("parameters")) {
          this.parameters = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("definingSubstance[x]")) {
          this.definingSubstance = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("amount[x]")) {
          this.amount = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("referenceRange")) {
          this.referenceRange = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("source")) {
          this.getSource().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102:  return getCategory();
        case 3059181:  return getCode();
        case 458736106:  return getParametersElement();
        case 1535270120:  return getDefiningSubstance();
        case 1901076632:  return getDefiningSubstance();
        case 646780200:  return getAmount();
        case -1413853096:  return getAmount();
        case -1912545102:  return getReferenceRange();
        case -896505829:  return addSource(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 458736106: /*parameters*/ return new String[] {"string"};
        case 1901076632: /*definingSubstance*/ return new String[] {"Reference", "CodeableConcept"};
        case -1413853096: /*amount*/ return new String[] {"Quantity", "string"};
        case -1912545102: /*referenceRange*/ return new String[] {"Range"};
        case -896505829: /*source*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("category")) {
          this.category = new CodeableConcept();
          return this.category;
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("parameters")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.property.parameters");
        }
        else if (name.equals("definingSubstanceReference")) {
          this.definingSubstance = new Reference();
          return this.definingSubstance;
        }
        else if (name.equals("definingSubstanceCodeableConcept")) {
          this.definingSubstance = new CodeableConcept();
          return this.definingSubstance;
        }
        else if (name.equals("amountQuantity")) {
          this.amount = new Quantity();
          return this.amount;
        }
        else if (name.equals("amountString")) {
          this.amount = new StringType();
          return this.amount;
        }
        else if (name.equals("referenceRange")) {
          this.referenceRange = new Range();
          return this.referenceRange;
        }
        else if (name.equals("source")) {
          return addSource();
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionPropertyComponent copy() {
        SubstanceDefinitionPropertyComponent dst = new SubstanceDefinitionPropertyComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionPropertyComponent dst) {
        super.copyValues(dst);
        dst.category = category == null ? null : category.copy();
        dst.code = code == null ? null : code.copy();
        dst.parameters = parameters == null ? null : parameters.copy();
        dst.definingSubstance = definingSubstance == null ? null : definingSubstance.copy();
        dst.amount = amount == null ? null : amount.copy();
        dst.referenceRange = referenceRange == null ? null : referenceRange.copy();
        if (source != null) {
          dst.source = new ArrayList<Reference>();
          for (Reference i : source)
            dst.source.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionPropertyComponent))
          return false;
        SubstanceDefinitionPropertyComponent o = (SubstanceDefinitionPropertyComponent) other_;
        return compareDeep(category, o.category, true) && compareDeep(code, o.code, true) && compareDeep(parameters, o.parameters, true)
           && compareDeep(definingSubstance, o.definingSubstance, true) && compareDeep(amount, o.amount, true)
           && compareDeep(referenceRange, o.referenceRange, true) && compareDeep(source, o.source, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionPropertyComponent))
          return false;
        SubstanceDefinitionPropertyComponent o = (SubstanceDefinitionPropertyComponent) other_;
        return compareValues(parameters, o.parameters, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(category, code, parameters
          , definingSubstance, amount, referenceRange, source);
      }

  public String fhirType() {
    return "SubstanceDefinition.property";

  }

  }

    @Block()
    public static class SubstanceDefinitionStructureComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Stereochemistry type.
         */
        @Child(name = "stereochemistry", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Stereochemistry type", formalDefinition="Stereochemistry type." )
        protected CodeableConcept stereochemistry;

        /**
         * Optical activity type.
         */
        @Child(name = "opticalActivity", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Optical activity type", formalDefinition="Optical activity type." )
        protected CodeableConcept opticalActivity;

        /**
         * Molecular formula of this substance, typically using the Hill system.
         */
        @Child(name = "molecularFormula", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Molecular formula of this substance, typically using the Hill system", formalDefinition="Molecular formula of this substance, typically using the Hill system." )
        protected StringType molecularFormula;

        /**
         * Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical, each moiety separated by a dot.
         */
        @Child(name = "molecularFormulaByMoiety", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical, each moiety separated by a dot", formalDefinition="Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical, each moiety separated by a dot." )
        protected StringType molecularFormulaByMoiety;

        /**
         * Applicable for single substances that contain a radionuclide or a non-natural isotopic ratio.
         */
        @Child(name = "isotope", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Applicable for single substances that contain a radionuclide or a non-natural isotopic ratio", formalDefinition="Applicable for single substances that contain a radionuclide or a non-natural isotopic ratio." )
        protected List<SubstanceDefinitionStructureIsotopeComponent> isotope;

        /**
         * The molecular weight or weight range (for proteins, polymers or nucleic acids).
         */
        @Child(name = "molecularWeight", type = {SubstanceDefinitionStructureIsotopeMolecularWeightComponent.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The molecular weight or weight range (for proteins, polymers or nucleic acids)", formalDefinition="The molecular weight or weight range (for proteins, polymers or nucleic acids)." )
        protected SubstanceDefinitionStructureIsotopeMolecularWeightComponent molecularWeight;

        /**
         * The method used to elucidate the structure or characterization of the drug substance. Examples: X-ray, HPLC, NMR, Peptide mapping, Ligand binding assay.
         */
        @Child(name = "technique", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The method used to elucidate the structure or characterization of the drug substance. Examples: X-ray, HPLC, NMR, Peptide mapping, Ligand binding assay", formalDefinition="The method used to elucidate the structure or characterization of the drug substance. Examples: X-ray, HPLC, NMR, Peptide mapping, Ligand binding assay." )
        protected List<CodeableConcept> technique;

        /**
         * Supporting literature about the source of information.
         */
        @Child(name = "sourceDocument", type = {DocumentReference.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Supporting literature about the source of information", formalDefinition="Supporting literature about the source of information." )
        protected List<Reference> sourceDocument;

        /**
         * Molecular structural representation.
         */
        @Child(name = "representation", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Molecular structural representation", formalDefinition="Molecular structural representation." )
        protected List<SubstanceDefinitionStructureRepresentationComponent> representation;

        private static final long serialVersionUID = -1648605311L;

    /**
     * Constructor
     */
      public SubstanceDefinitionStructureComponent() {
        super();
      }

        /**
         * @return {@link #stereochemistry} (Stereochemistry type.)
         */
        public CodeableConcept getStereochemistry() { 
          if (this.stereochemistry == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureComponent.stereochemistry");
            else if (Configuration.doAutoCreate())
              this.stereochemistry = new CodeableConcept(); // cc
          return this.stereochemistry;
        }

        public boolean hasStereochemistry() { 
          return this.stereochemistry != null && !this.stereochemistry.isEmpty();
        }

        /**
         * @param value {@link #stereochemistry} (Stereochemistry type.)
         */
        public SubstanceDefinitionStructureComponent setStereochemistry(CodeableConcept value) { 
          this.stereochemistry = value;
          return this;
        }

        /**
         * @return {@link #opticalActivity} (Optical activity type.)
         */
        public CodeableConcept getOpticalActivity() { 
          if (this.opticalActivity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureComponent.opticalActivity");
            else if (Configuration.doAutoCreate())
              this.opticalActivity = new CodeableConcept(); // cc
          return this.opticalActivity;
        }

        public boolean hasOpticalActivity() { 
          return this.opticalActivity != null && !this.opticalActivity.isEmpty();
        }

        /**
         * @param value {@link #opticalActivity} (Optical activity type.)
         */
        public SubstanceDefinitionStructureComponent setOpticalActivity(CodeableConcept value) { 
          this.opticalActivity = value;
          return this;
        }

        /**
         * @return {@link #molecularFormula} (Molecular formula of this substance, typically using the Hill system.). This is the underlying object with id, value and extensions. The accessor "getMolecularFormula" gives direct access to the value
         */
        public StringType getMolecularFormulaElement() { 
          if (this.molecularFormula == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureComponent.molecularFormula");
            else if (Configuration.doAutoCreate())
              this.molecularFormula = new StringType(); // bb
          return this.molecularFormula;
        }

        public boolean hasMolecularFormulaElement() { 
          return this.molecularFormula != null && !this.molecularFormula.isEmpty();
        }

        public boolean hasMolecularFormula() { 
          return this.molecularFormula != null && !this.molecularFormula.isEmpty();
        }

        /**
         * @param value {@link #molecularFormula} (Molecular formula of this substance, typically using the Hill system.). This is the underlying object with id, value and extensions. The accessor "getMolecularFormula" gives direct access to the value
         */
        public SubstanceDefinitionStructureComponent setMolecularFormulaElement(StringType value) { 
          this.molecularFormula = value;
          return this;
        }

        /**
         * @return Molecular formula of this substance, typically using the Hill system.
         */
        public String getMolecularFormula() { 
          return this.molecularFormula == null ? null : this.molecularFormula.getValue();
        }

        /**
         * @param value Molecular formula of this substance, typically using the Hill system.
         */
        public SubstanceDefinitionStructureComponent setMolecularFormula(String value) { 
          if (Utilities.noString(value))
            this.molecularFormula = null;
          else {
            if (this.molecularFormula == null)
              this.molecularFormula = new StringType();
            this.molecularFormula.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #molecularFormulaByMoiety} (Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical, each moiety separated by a dot.). This is the underlying object with id, value and extensions. The accessor "getMolecularFormulaByMoiety" gives direct access to the value
         */
        public StringType getMolecularFormulaByMoietyElement() { 
          if (this.molecularFormulaByMoiety == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureComponent.molecularFormulaByMoiety");
            else if (Configuration.doAutoCreate())
              this.molecularFormulaByMoiety = new StringType(); // bb
          return this.molecularFormulaByMoiety;
        }

        public boolean hasMolecularFormulaByMoietyElement() { 
          return this.molecularFormulaByMoiety != null && !this.molecularFormulaByMoiety.isEmpty();
        }

        public boolean hasMolecularFormulaByMoiety() { 
          return this.molecularFormulaByMoiety != null && !this.molecularFormulaByMoiety.isEmpty();
        }

        /**
         * @param value {@link #molecularFormulaByMoiety} (Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical, each moiety separated by a dot.). This is the underlying object with id, value and extensions. The accessor "getMolecularFormulaByMoiety" gives direct access to the value
         */
        public SubstanceDefinitionStructureComponent setMolecularFormulaByMoietyElement(StringType value) { 
          this.molecularFormulaByMoiety = value;
          return this;
        }

        /**
         * @return Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical, each moiety separated by a dot.
         */
        public String getMolecularFormulaByMoiety() { 
          return this.molecularFormulaByMoiety == null ? null : this.molecularFormulaByMoiety.getValue();
        }

        /**
         * @param value Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical, each moiety separated by a dot.
         */
        public SubstanceDefinitionStructureComponent setMolecularFormulaByMoiety(String value) { 
          if (Utilities.noString(value))
            this.molecularFormulaByMoiety = null;
          else {
            if (this.molecularFormulaByMoiety == null)
              this.molecularFormulaByMoiety = new StringType();
            this.molecularFormulaByMoiety.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #isotope} (Applicable for single substances that contain a radionuclide or a non-natural isotopic ratio.)
         */
        public List<SubstanceDefinitionStructureIsotopeComponent> getIsotope() { 
          if (this.isotope == null)
            this.isotope = new ArrayList<SubstanceDefinitionStructureIsotopeComponent>();
          return this.isotope;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionStructureComponent setIsotope(List<SubstanceDefinitionStructureIsotopeComponent> theIsotope) { 
          this.isotope = theIsotope;
          return this;
        }

        public boolean hasIsotope() { 
          if (this.isotope == null)
            return false;
          for (SubstanceDefinitionStructureIsotopeComponent item : this.isotope)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SubstanceDefinitionStructureIsotopeComponent addIsotope() { //3
          SubstanceDefinitionStructureIsotopeComponent t = new SubstanceDefinitionStructureIsotopeComponent();
          if (this.isotope == null)
            this.isotope = new ArrayList<SubstanceDefinitionStructureIsotopeComponent>();
          this.isotope.add(t);
          return t;
        }

        public SubstanceDefinitionStructureComponent addIsotope(SubstanceDefinitionStructureIsotopeComponent t) { //3
          if (t == null)
            return this;
          if (this.isotope == null)
            this.isotope = new ArrayList<SubstanceDefinitionStructureIsotopeComponent>();
          this.isotope.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #isotope}, creating it if it does not already exist {3}
         */
        public SubstanceDefinitionStructureIsotopeComponent getIsotopeFirstRep() { 
          if (getIsotope().isEmpty()) {
            addIsotope();
          }
          return getIsotope().get(0);
        }

        /**
         * @return {@link #molecularWeight} (The molecular weight or weight range (for proteins, polymers or nucleic acids).)
         */
        public SubstanceDefinitionStructureIsotopeMolecularWeightComponent getMolecularWeight() { 
          if (this.molecularWeight == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureComponent.molecularWeight");
            else if (Configuration.doAutoCreate())
              this.molecularWeight = new SubstanceDefinitionStructureIsotopeMolecularWeightComponent(); // cc
          return this.molecularWeight;
        }

        public boolean hasMolecularWeight() { 
          return this.molecularWeight != null && !this.molecularWeight.isEmpty();
        }

        /**
         * @param value {@link #molecularWeight} (The molecular weight or weight range (for proteins, polymers or nucleic acids).)
         */
        public SubstanceDefinitionStructureComponent setMolecularWeight(SubstanceDefinitionStructureIsotopeMolecularWeightComponent value) { 
          this.molecularWeight = value;
          return this;
        }

        /**
         * @return {@link #technique} (The method used to elucidate the structure or characterization of the drug substance. Examples: X-ray, HPLC, NMR, Peptide mapping, Ligand binding assay.)
         */
        public List<CodeableConcept> getTechnique() { 
          if (this.technique == null)
            this.technique = new ArrayList<CodeableConcept>();
          return this.technique;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionStructureComponent setTechnique(List<CodeableConcept> theTechnique) { 
          this.technique = theTechnique;
          return this;
        }

        public boolean hasTechnique() { 
          if (this.technique == null)
            return false;
          for (CodeableConcept item : this.technique)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addTechnique() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.technique == null)
            this.technique = new ArrayList<CodeableConcept>();
          this.technique.add(t);
          return t;
        }

        public SubstanceDefinitionStructureComponent addTechnique(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.technique == null)
            this.technique = new ArrayList<CodeableConcept>();
          this.technique.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #technique}, creating it if it does not already exist {3}
         */
        public CodeableConcept getTechniqueFirstRep() { 
          if (getTechnique().isEmpty()) {
            addTechnique();
          }
          return getTechnique().get(0);
        }

        /**
         * @return {@link #sourceDocument} (Supporting literature about the source of information.)
         */
        public List<Reference> getSourceDocument() { 
          if (this.sourceDocument == null)
            this.sourceDocument = new ArrayList<Reference>();
          return this.sourceDocument;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionStructureComponent setSourceDocument(List<Reference> theSourceDocument) { 
          this.sourceDocument = theSourceDocument;
          return this;
        }

        public boolean hasSourceDocument() { 
          if (this.sourceDocument == null)
            return false;
          for (Reference item : this.sourceDocument)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addSourceDocument() { //3
          Reference t = new Reference();
          if (this.sourceDocument == null)
            this.sourceDocument = new ArrayList<Reference>();
          this.sourceDocument.add(t);
          return t;
        }

        public SubstanceDefinitionStructureComponent addSourceDocument(Reference t) { //3
          if (t == null)
            return this;
          if (this.sourceDocument == null)
            this.sourceDocument = new ArrayList<Reference>();
          this.sourceDocument.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #sourceDocument}, creating it if it does not already exist {3}
         */
        public Reference getSourceDocumentFirstRep() { 
          if (getSourceDocument().isEmpty()) {
            addSourceDocument();
          }
          return getSourceDocument().get(0);
        }

        /**
         * @return {@link #representation} (Molecular structural representation.)
         */
        public List<SubstanceDefinitionStructureRepresentationComponent> getRepresentation() { 
          if (this.representation == null)
            this.representation = new ArrayList<SubstanceDefinitionStructureRepresentationComponent>();
          return this.representation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionStructureComponent setRepresentation(List<SubstanceDefinitionStructureRepresentationComponent> theRepresentation) { 
          this.representation = theRepresentation;
          return this;
        }

        public boolean hasRepresentation() { 
          if (this.representation == null)
            return false;
          for (SubstanceDefinitionStructureRepresentationComponent item : this.representation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SubstanceDefinitionStructureRepresentationComponent addRepresentation() { //3
          SubstanceDefinitionStructureRepresentationComponent t = new SubstanceDefinitionStructureRepresentationComponent();
          if (this.representation == null)
            this.representation = new ArrayList<SubstanceDefinitionStructureRepresentationComponent>();
          this.representation.add(t);
          return t;
        }

        public SubstanceDefinitionStructureComponent addRepresentation(SubstanceDefinitionStructureRepresentationComponent t) { //3
          if (t == null)
            return this;
          if (this.representation == null)
            this.representation = new ArrayList<SubstanceDefinitionStructureRepresentationComponent>();
          this.representation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #representation}, creating it if it does not already exist {3}
         */
        public SubstanceDefinitionStructureRepresentationComponent getRepresentationFirstRep() { 
          if (getRepresentation().isEmpty()) {
            addRepresentation();
          }
          return getRepresentation().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("stereochemistry", "CodeableConcept", "Stereochemistry type.", 0, 1, stereochemistry));
          children.add(new Property("opticalActivity", "CodeableConcept", "Optical activity type.", 0, 1, opticalActivity));
          children.add(new Property("molecularFormula", "string", "Molecular formula of this substance, typically using the Hill system.", 0, 1, molecularFormula));
          children.add(new Property("molecularFormulaByMoiety", "string", "Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical, each moiety separated by a dot.", 0, 1, molecularFormulaByMoiety));
          children.add(new Property("isotope", "", "Applicable for single substances that contain a radionuclide or a non-natural isotopic ratio.", 0, java.lang.Integer.MAX_VALUE, isotope));
          children.add(new Property("molecularWeight", "@SubstanceDefinition.structure.isotope.molecularWeight", "The molecular weight or weight range (for proteins, polymers or nucleic acids).", 0, 1, molecularWeight));
          children.add(new Property("technique", "CodeableConcept", "The method used to elucidate the structure or characterization of the drug substance. Examples: X-ray, HPLC, NMR, Peptide mapping, Ligand binding assay.", 0, java.lang.Integer.MAX_VALUE, technique));
          children.add(new Property("sourceDocument", "Reference(DocumentReference)", "Supporting literature about the source of information.", 0, java.lang.Integer.MAX_VALUE, sourceDocument));
          children.add(new Property("representation", "", "Molecular structural representation.", 0, java.lang.Integer.MAX_VALUE, representation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 263475116: /*stereochemistry*/  return new Property("stereochemistry", "CodeableConcept", "Stereochemistry type.", 0, 1, stereochemistry);
          case 1420900135: /*opticalActivity*/  return new Property("opticalActivity", "CodeableConcept", "Optical activity type.", 0, 1, opticalActivity);
          case 616660246: /*molecularFormula*/  return new Property("molecularFormula", "string", "Molecular formula of this substance, typically using the Hill system.", 0, 1, molecularFormula);
          case 1315452848: /*molecularFormulaByMoiety*/  return new Property("molecularFormulaByMoiety", "string", "Specified per moiety according to the Hill system, i.e. first C, then H, then alphabetical, each moiety separated by a dot.", 0, 1, molecularFormulaByMoiety);
          case 2097035189: /*isotope*/  return new Property("isotope", "", "Applicable for single substances that contain a radionuclide or a non-natural isotopic ratio.", 0, java.lang.Integer.MAX_VALUE, isotope);
          case 635625672: /*molecularWeight*/  return new Property("molecularWeight", "@SubstanceDefinition.structure.isotope.molecularWeight", "The molecular weight or weight range (for proteins, polymers or nucleic acids).", 0, 1, molecularWeight);
          case 1469675088: /*technique*/  return new Property("technique", "CodeableConcept", "The method used to elucidate the structure or characterization of the drug substance. Examples: X-ray, HPLC, NMR, Peptide mapping, Ligand binding assay.", 0, java.lang.Integer.MAX_VALUE, technique);
          case -501788074: /*sourceDocument*/  return new Property("sourceDocument", "Reference(DocumentReference)", "Supporting literature about the source of information.", 0, java.lang.Integer.MAX_VALUE, sourceDocument);
          case -671065907: /*representation*/  return new Property("representation", "", "Molecular structural representation.", 0, java.lang.Integer.MAX_VALUE, representation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 263475116: /*stereochemistry*/ return this.stereochemistry == null ? new Base[0] : new Base[] {this.stereochemistry}; // CodeableConcept
        case 1420900135: /*opticalActivity*/ return this.opticalActivity == null ? new Base[0] : new Base[] {this.opticalActivity}; // CodeableConcept
        case 616660246: /*molecularFormula*/ return this.molecularFormula == null ? new Base[0] : new Base[] {this.molecularFormula}; // StringType
        case 1315452848: /*molecularFormulaByMoiety*/ return this.molecularFormulaByMoiety == null ? new Base[0] : new Base[] {this.molecularFormulaByMoiety}; // StringType
        case 2097035189: /*isotope*/ return this.isotope == null ? new Base[0] : this.isotope.toArray(new Base[this.isotope.size()]); // SubstanceDefinitionStructureIsotopeComponent
        case 635625672: /*molecularWeight*/ return this.molecularWeight == null ? new Base[0] : new Base[] {this.molecularWeight}; // SubstanceDefinitionStructureIsotopeMolecularWeightComponent
        case 1469675088: /*technique*/ return this.technique == null ? new Base[0] : this.technique.toArray(new Base[this.technique.size()]); // CodeableConcept
        case -501788074: /*sourceDocument*/ return this.sourceDocument == null ? new Base[0] : this.sourceDocument.toArray(new Base[this.sourceDocument.size()]); // Reference
        case -671065907: /*representation*/ return this.representation == null ? new Base[0] : this.representation.toArray(new Base[this.representation.size()]); // SubstanceDefinitionStructureRepresentationComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 263475116: // stereochemistry
          this.stereochemistry = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1420900135: // opticalActivity
          this.opticalActivity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 616660246: // molecularFormula
          this.molecularFormula = TypeConvertor.castToString(value); // StringType
          return value;
        case 1315452848: // molecularFormulaByMoiety
          this.molecularFormulaByMoiety = TypeConvertor.castToString(value); // StringType
          return value;
        case 2097035189: // isotope
          this.getIsotope().add((SubstanceDefinitionStructureIsotopeComponent) value); // SubstanceDefinitionStructureIsotopeComponent
          return value;
        case 635625672: // molecularWeight
          this.molecularWeight = (SubstanceDefinitionStructureIsotopeMolecularWeightComponent) value; // SubstanceDefinitionStructureIsotopeMolecularWeightComponent
          return value;
        case 1469675088: // technique
          this.getTechnique().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -501788074: // sourceDocument
          this.getSourceDocument().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -671065907: // representation
          this.getRepresentation().add((SubstanceDefinitionStructureRepresentationComponent) value); // SubstanceDefinitionStructureRepresentationComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("stereochemistry")) {
          this.stereochemistry = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("opticalActivity")) {
          this.opticalActivity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("molecularFormula")) {
          this.molecularFormula = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("molecularFormulaByMoiety")) {
          this.molecularFormulaByMoiety = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("isotope")) {
          this.getIsotope().add((SubstanceDefinitionStructureIsotopeComponent) value);
        } else if (name.equals("molecularWeight")) {
          this.molecularWeight = (SubstanceDefinitionStructureIsotopeMolecularWeightComponent) value; // SubstanceDefinitionStructureIsotopeMolecularWeightComponent
        } else if (name.equals("technique")) {
          this.getTechnique().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("sourceDocument")) {
          this.getSourceDocument().add(TypeConvertor.castToReference(value));
        } else if (name.equals("representation")) {
          this.getRepresentation().add((SubstanceDefinitionStructureRepresentationComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 263475116:  return getStereochemistry();
        case 1420900135:  return getOpticalActivity();
        case 616660246:  return getMolecularFormulaElement();
        case 1315452848:  return getMolecularFormulaByMoietyElement();
        case 2097035189:  return addIsotope(); 
        case 635625672:  return getMolecularWeight();
        case 1469675088:  return addTechnique(); 
        case -501788074:  return addSourceDocument(); 
        case -671065907:  return addRepresentation(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 263475116: /*stereochemistry*/ return new String[] {"CodeableConcept"};
        case 1420900135: /*opticalActivity*/ return new String[] {"CodeableConcept"};
        case 616660246: /*molecularFormula*/ return new String[] {"string"};
        case 1315452848: /*molecularFormulaByMoiety*/ return new String[] {"string"};
        case 2097035189: /*isotope*/ return new String[] {};
        case 635625672: /*molecularWeight*/ return new String[] {"@SubstanceDefinition.structure.isotope.molecularWeight"};
        case 1469675088: /*technique*/ return new String[] {"CodeableConcept"};
        case -501788074: /*sourceDocument*/ return new String[] {"Reference"};
        case -671065907: /*representation*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("stereochemistry")) {
          this.stereochemistry = new CodeableConcept();
          return this.stereochemistry;
        }
        else if (name.equals("opticalActivity")) {
          this.opticalActivity = new CodeableConcept();
          return this.opticalActivity;
        }
        else if (name.equals("molecularFormula")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.structure.molecularFormula");
        }
        else if (name.equals("molecularFormulaByMoiety")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.structure.molecularFormulaByMoiety");
        }
        else if (name.equals("isotope")) {
          return addIsotope();
        }
        else if (name.equals("molecularWeight")) {
          this.molecularWeight = new SubstanceDefinitionStructureIsotopeMolecularWeightComponent();
          return this.molecularWeight;
        }
        else if (name.equals("technique")) {
          return addTechnique();
        }
        else if (name.equals("sourceDocument")) {
          return addSourceDocument();
        }
        else if (name.equals("representation")) {
          return addRepresentation();
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionStructureComponent copy() {
        SubstanceDefinitionStructureComponent dst = new SubstanceDefinitionStructureComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionStructureComponent dst) {
        super.copyValues(dst);
        dst.stereochemistry = stereochemistry == null ? null : stereochemistry.copy();
        dst.opticalActivity = opticalActivity == null ? null : opticalActivity.copy();
        dst.molecularFormula = molecularFormula == null ? null : molecularFormula.copy();
        dst.molecularFormulaByMoiety = molecularFormulaByMoiety == null ? null : molecularFormulaByMoiety.copy();
        if (isotope != null) {
          dst.isotope = new ArrayList<SubstanceDefinitionStructureIsotopeComponent>();
          for (SubstanceDefinitionStructureIsotopeComponent i : isotope)
            dst.isotope.add(i.copy());
        };
        dst.molecularWeight = molecularWeight == null ? null : molecularWeight.copy();
        if (technique != null) {
          dst.technique = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : technique)
            dst.technique.add(i.copy());
        };
        if (sourceDocument != null) {
          dst.sourceDocument = new ArrayList<Reference>();
          for (Reference i : sourceDocument)
            dst.sourceDocument.add(i.copy());
        };
        if (representation != null) {
          dst.representation = new ArrayList<SubstanceDefinitionStructureRepresentationComponent>();
          for (SubstanceDefinitionStructureRepresentationComponent i : representation)
            dst.representation.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionStructureComponent))
          return false;
        SubstanceDefinitionStructureComponent o = (SubstanceDefinitionStructureComponent) other_;
        return compareDeep(stereochemistry, o.stereochemistry, true) && compareDeep(opticalActivity, o.opticalActivity, true)
           && compareDeep(molecularFormula, o.molecularFormula, true) && compareDeep(molecularFormulaByMoiety, o.molecularFormulaByMoiety, true)
           && compareDeep(isotope, o.isotope, true) && compareDeep(molecularWeight, o.molecularWeight, true)
           && compareDeep(technique, o.technique, true) && compareDeep(sourceDocument, o.sourceDocument, true)
           && compareDeep(representation, o.representation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionStructureComponent))
          return false;
        SubstanceDefinitionStructureComponent o = (SubstanceDefinitionStructureComponent) other_;
        return compareValues(molecularFormula, o.molecularFormula, true) && compareValues(molecularFormulaByMoiety, o.molecularFormulaByMoiety, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(stereochemistry, opticalActivity
          , molecularFormula, molecularFormulaByMoiety, isotope, molecularWeight, technique
          , sourceDocument, representation);
      }

  public String fhirType() {
    return "SubstanceDefinition.structure";

  }

  }

    @Block()
    public static class SubstanceDefinitionStructureIsotopeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Substance identifier for each non-natural or radioisotope.
         */
        @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Substance identifier for each non-natural or radioisotope", formalDefinition="Substance identifier for each non-natural or radioisotope." )
        protected Identifier identifier;

        /**
         * Substance name for each non-natural or radioisotope.
         */
        @Child(name = "name", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Substance name for each non-natural or radioisotope", formalDefinition="Substance name for each non-natural or radioisotope." )
        protected CodeableConcept name;

        /**
         * The type of isotopic substitution present in a single substance.
         */
        @Child(name = "substitution", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of isotopic substitution present in a single substance", formalDefinition="The type of isotopic substitution present in a single substance." )
        protected CodeableConcept substitution;

        /**
         * Half life - for a non-natural nuclide.
         */
        @Child(name = "halfLife", type = {Quantity.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Half life - for a non-natural nuclide", formalDefinition="Half life - for a non-natural nuclide." )
        protected Quantity halfLife;

        /**
         * The molecular weight or weight range (for proteins, polymers or nucleic acids).
         */
        @Child(name = "molecularWeight", type = {}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The molecular weight or weight range (for proteins, polymers or nucleic acids)", formalDefinition="The molecular weight or weight range (for proteins, polymers or nucleic acids)." )
        protected SubstanceDefinitionStructureIsotopeMolecularWeightComponent molecularWeight;

        private static final long serialVersionUID = 1897382758L;

    /**
     * Constructor
     */
      public SubstanceDefinitionStructureIsotopeComponent() {
        super();
      }

        /**
         * @return {@link #identifier} (Substance identifier for each non-natural or radioisotope.)
         */
        public Identifier getIdentifier() { 
          if (this.identifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureIsotopeComponent.identifier");
            else if (Configuration.doAutoCreate())
              this.identifier = new Identifier(); // cc
          return this.identifier;
        }

        public boolean hasIdentifier() { 
          return this.identifier != null && !this.identifier.isEmpty();
        }

        /**
         * @param value {@link #identifier} (Substance identifier for each non-natural or radioisotope.)
         */
        public SubstanceDefinitionStructureIsotopeComponent setIdentifier(Identifier value) { 
          this.identifier = value;
          return this;
        }

        /**
         * @return {@link #name} (Substance name for each non-natural or radioisotope.)
         */
        public CodeableConcept getName() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureIsotopeComponent.name");
            else if (Configuration.doAutoCreate())
              this.name = new CodeableConcept(); // cc
          return this.name;
        }

        public boolean hasName() { 
          return this.name != null && !this.name.isEmpty();
        }

        /**
         * @param value {@link #name} (Substance name for each non-natural or radioisotope.)
         */
        public SubstanceDefinitionStructureIsotopeComponent setName(CodeableConcept value) { 
          this.name = value;
          return this;
        }

        /**
         * @return {@link #substitution} (The type of isotopic substitution present in a single substance.)
         */
        public CodeableConcept getSubstitution() { 
          if (this.substitution == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureIsotopeComponent.substitution");
            else if (Configuration.doAutoCreate())
              this.substitution = new CodeableConcept(); // cc
          return this.substitution;
        }

        public boolean hasSubstitution() { 
          return this.substitution != null && !this.substitution.isEmpty();
        }

        /**
         * @param value {@link #substitution} (The type of isotopic substitution present in a single substance.)
         */
        public SubstanceDefinitionStructureIsotopeComponent setSubstitution(CodeableConcept value) { 
          this.substitution = value;
          return this;
        }

        /**
         * @return {@link #halfLife} (Half life - for a non-natural nuclide.)
         */
        public Quantity getHalfLife() { 
          if (this.halfLife == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureIsotopeComponent.halfLife");
            else if (Configuration.doAutoCreate())
              this.halfLife = new Quantity(); // cc
          return this.halfLife;
        }

        public boolean hasHalfLife() { 
          return this.halfLife != null && !this.halfLife.isEmpty();
        }

        /**
         * @param value {@link #halfLife} (Half life - for a non-natural nuclide.)
         */
        public SubstanceDefinitionStructureIsotopeComponent setHalfLife(Quantity value) { 
          this.halfLife = value;
          return this;
        }

        /**
         * @return {@link #molecularWeight} (The molecular weight or weight range (for proteins, polymers or nucleic acids).)
         */
        public SubstanceDefinitionStructureIsotopeMolecularWeightComponent getMolecularWeight() { 
          if (this.molecularWeight == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureIsotopeComponent.molecularWeight");
            else if (Configuration.doAutoCreate())
              this.molecularWeight = new SubstanceDefinitionStructureIsotopeMolecularWeightComponent(); // cc
          return this.molecularWeight;
        }

        public boolean hasMolecularWeight() { 
          return this.molecularWeight != null && !this.molecularWeight.isEmpty();
        }

        /**
         * @param value {@link #molecularWeight} (The molecular weight or weight range (for proteins, polymers or nucleic acids).)
         */
        public SubstanceDefinitionStructureIsotopeComponent setMolecularWeight(SubstanceDefinitionStructureIsotopeMolecularWeightComponent value) { 
          this.molecularWeight = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("identifier", "Identifier", "Substance identifier for each non-natural or radioisotope.", 0, 1, identifier));
          children.add(new Property("name", "CodeableConcept", "Substance name for each non-natural or radioisotope.", 0, 1, name));
          children.add(new Property("substitution", "CodeableConcept", "The type of isotopic substitution present in a single substance.", 0, 1, substitution));
          children.add(new Property("halfLife", "Quantity", "Half life - for a non-natural nuclide.", 0, 1, halfLife));
          children.add(new Property("molecularWeight", "", "The molecular weight or weight range (for proteins, polymers or nucleic acids).", 0, 1, molecularWeight));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Substance identifier for each non-natural or radioisotope.", 0, 1, identifier);
          case 3373707: /*name*/  return new Property("name", "CodeableConcept", "Substance name for each non-natural or radioisotope.", 0, 1, name);
          case 826147581: /*substitution*/  return new Property("substitution", "CodeableConcept", "The type of isotopic substitution present in a single substance.", 0, 1, substitution);
          case -54292017: /*halfLife*/  return new Property("halfLife", "Quantity", "Half life - for a non-natural nuclide.", 0, 1, halfLife);
          case 635625672: /*molecularWeight*/  return new Property("molecularWeight", "", "The molecular weight or weight range (for proteins, polymers or nucleic acids).", 0, 1, molecularWeight);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // CodeableConcept
        case 826147581: /*substitution*/ return this.substitution == null ? new Base[0] : new Base[] {this.substitution}; // CodeableConcept
        case -54292017: /*halfLife*/ return this.halfLife == null ? new Base[0] : new Base[] {this.halfLife}; // Quantity
        case 635625672: /*molecularWeight*/ return this.molecularWeight == null ? new Base[0] : new Base[] {this.molecularWeight}; // SubstanceDefinitionStructureIsotopeMolecularWeightComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 826147581: // substitution
          this.substitution = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -54292017: // halfLife
          this.halfLife = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case 635625672: // molecularWeight
          this.molecularWeight = (SubstanceDefinitionStructureIsotopeMolecularWeightComponent) value; // SubstanceDefinitionStructureIsotopeMolecularWeightComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("substitution")) {
          this.substitution = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("halfLife")) {
          this.halfLife = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("molecularWeight")) {
          this.molecularWeight = (SubstanceDefinitionStructureIsotopeMolecularWeightComponent) value; // SubstanceDefinitionStructureIsotopeMolecularWeightComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return getIdentifier();
        case 3373707:  return getName();
        case 826147581:  return getSubstitution();
        case -54292017:  return getHalfLife();
        case 635625672:  return getMolecularWeight();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3373707: /*name*/ return new String[] {"CodeableConcept"};
        case 826147581: /*substitution*/ return new String[] {"CodeableConcept"};
        case -54292017: /*halfLife*/ return new String[] {"Quantity"};
        case 635625672: /*molecularWeight*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("name")) {
          this.name = new CodeableConcept();
          return this.name;
        }
        else if (name.equals("substitution")) {
          this.substitution = new CodeableConcept();
          return this.substitution;
        }
        else if (name.equals("halfLife")) {
          this.halfLife = new Quantity();
          return this.halfLife;
        }
        else if (name.equals("molecularWeight")) {
          this.molecularWeight = new SubstanceDefinitionStructureIsotopeMolecularWeightComponent();
          return this.molecularWeight;
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionStructureIsotopeComponent copy() {
        SubstanceDefinitionStructureIsotopeComponent dst = new SubstanceDefinitionStructureIsotopeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionStructureIsotopeComponent dst) {
        super.copyValues(dst);
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.name = name == null ? null : name.copy();
        dst.substitution = substitution == null ? null : substitution.copy();
        dst.halfLife = halfLife == null ? null : halfLife.copy();
        dst.molecularWeight = molecularWeight == null ? null : molecularWeight.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionStructureIsotopeComponent))
          return false;
        SubstanceDefinitionStructureIsotopeComponent o = (SubstanceDefinitionStructureIsotopeComponent) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(name, o.name, true) && compareDeep(substitution, o.substitution, true)
           && compareDeep(halfLife, o.halfLife, true) && compareDeep(molecularWeight, o.molecularWeight, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionStructureIsotopeComponent))
          return false;
        SubstanceDefinitionStructureIsotopeComponent o = (SubstanceDefinitionStructureIsotopeComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, name, substitution
          , halfLife, molecularWeight);
      }

  public String fhirType() {
    return "SubstanceDefinition.structure.isotope";

  }

  }

    @Block()
    public static class SubstanceDefinitionStructureIsotopeMolecularWeightComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The method by which the molecular weight was determined.
         */
        @Child(name = "method", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The method by which the molecular weight was determined", formalDefinition="The method by which the molecular weight was determined." )
        protected CodeableConcept method;

        /**
         * Type of molecular weight such as exact, average (also known as. number average), weight average.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Type of molecular weight such as exact, average (also known as. number average), weight average", formalDefinition="Type of molecular weight such as exact, average (also known as. number average), weight average." )
        protected CodeableConcept type;

        /**
         * Used to capture quantitative values for a variety of elements. If only limits are given, the arithmetic mean would be the average. If only a single definite value for a given element is given, it would be captured in this field.
         */
        @Child(name = "amount", type = {Quantity.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Used to capture quantitative values for a variety of elements. If only limits are given, the arithmetic mean would be the average. If only a single definite value for a given element is given, it would be captured in this field", formalDefinition="Used to capture quantitative values for a variety of elements. If only limits are given, the arithmetic mean would be the average. If only a single definite value for a given element is given, it would be captured in this field." )
        protected Quantity amount;

        private static final long serialVersionUID = 805939780L;

    /**
     * Constructor
     */
      public SubstanceDefinitionStructureIsotopeMolecularWeightComponent() {
        super();
      }

        /**
         * @return {@link #method} (The method by which the molecular weight was determined.)
         */
        public CodeableConcept getMethod() { 
          if (this.method == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureIsotopeMolecularWeightComponent.method");
            else if (Configuration.doAutoCreate())
              this.method = new CodeableConcept(); // cc
          return this.method;
        }

        public boolean hasMethod() { 
          return this.method != null && !this.method.isEmpty();
        }

        /**
         * @param value {@link #method} (The method by which the molecular weight was determined.)
         */
        public SubstanceDefinitionStructureIsotopeMolecularWeightComponent setMethod(CodeableConcept value) { 
          this.method = value;
          return this;
        }

        /**
         * @return {@link #type} (Type of molecular weight such as exact, average (also known as. number average), weight average.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureIsotopeMolecularWeightComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Type of molecular weight such as exact, average (also known as. number average), weight average.)
         */
        public SubstanceDefinitionStructureIsotopeMolecularWeightComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #amount} (Used to capture quantitative values for a variety of elements. If only limits are given, the arithmetic mean would be the average. If only a single definite value for a given element is given, it would be captured in this field.)
         */
        public Quantity getAmount() { 
          if (this.amount == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureIsotopeMolecularWeightComponent.amount");
            else if (Configuration.doAutoCreate())
              this.amount = new Quantity(); // cc
          return this.amount;
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (Used to capture quantitative values for a variety of elements. If only limits are given, the arithmetic mean would be the average. If only a single definite value for a given element is given, it would be captured in this field.)
         */
        public SubstanceDefinitionStructureIsotopeMolecularWeightComponent setAmount(Quantity value) { 
          this.amount = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("method", "CodeableConcept", "The method by which the molecular weight was determined.", 0, 1, method));
          children.add(new Property("type", "CodeableConcept", "Type of molecular weight such as exact, average (also known as. number average), weight average.", 0, 1, type));
          children.add(new Property("amount", "Quantity", "Used to capture quantitative values for a variety of elements. If only limits are given, the arithmetic mean would be the average. If only a single definite value for a given element is given, it would be captured in this field.", 0, 1, amount));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1077554975: /*method*/  return new Property("method", "CodeableConcept", "The method by which the molecular weight was determined.", 0, 1, method);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Type of molecular weight such as exact, average (also known as. number average), weight average.", 0, 1, type);
          case -1413853096: /*amount*/  return new Property("amount", "Quantity", "Used to capture quantitative values for a variety of elements. If only limits are given, the arithmetic mean would be the average. If only a single definite value for a given element is given, it would be captured in this field.", 0, 1, amount);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1077554975: /*method*/ return this.method == null ? new Base[0] : new Base[] {this.method}; // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Quantity
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1077554975: // method
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("method")) {
          this.method = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1077554975:  return getMethod();
        case 3575610:  return getType();
        case -1413853096:  return getAmount();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1077554975: /*method*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1413853096: /*amount*/ return new String[] {"Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("method")) {
          this.method = new CodeableConcept();
          return this.method;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("amount")) {
          this.amount = new Quantity();
          return this.amount;
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionStructureIsotopeMolecularWeightComponent copy() {
        SubstanceDefinitionStructureIsotopeMolecularWeightComponent dst = new SubstanceDefinitionStructureIsotopeMolecularWeightComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionStructureIsotopeMolecularWeightComponent dst) {
        super.copyValues(dst);
        dst.method = method == null ? null : method.copy();
        dst.type = type == null ? null : type.copy();
        dst.amount = amount == null ? null : amount.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionStructureIsotopeMolecularWeightComponent))
          return false;
        SubstanceDefinitionStructureIsotopeMolecularWeightComponent o = (SubstanceDefinitionStructureIsotopeMolecularWeightComponent) other_;
        return compareDeep(method, o.method, true) && compareDeep(type, o.type, true) && compareDeep(amount, o.amount, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionStructureIsotopeMolecularWeightComponent))
          return false;
        SubstanceDefinitionStructureIsotopeMolecularWeightComponent o = (SubstanceDefinitionStructureIsotopeMolecularWeightComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(method, type, amount);
      }

  public String fhirType() {
    return "SubstanceDefinition.structure.isotope.molecularWeight";

  }

  }

    @Block()
    public static class SubstanceDefinitionStructureRepresentationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of structure (e.g. Full, Partial, Representative).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The type of structure (e.g. Full, Partial, Representative)", formalDefinition="The type of structure (e.g. Full, Partial, Representative)." )
        protected CodeableConcept type;

        /**
         * The structural representation as text string in a standard format e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.
         */
        @Child(name = "representation", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The structural representation as text string in a standard format e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF", formalDefinition="The structural representation as text string in a standard format e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF." )
        protected StringType representation;

        /**
         * The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.
         */
        @Child(name = "format", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF", formalDefinition="The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF." )
        protected CodeableConcept format;

        /**
         * An attached file with the structural representation.
         */
        @Child(name = "attachment", type = {Attachment.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="An attached file with the structural representation", formalDefinition="An attached file with the structural representation." )
        protected Attachment attachment;

        private static final long serialVersionUID = -1385695515L;

    /**
     * Constructor
     */
      public SubstanceDefinitionStructureRepresentationComponent() {
        super();
      }

        /**
         * @return {@link #type} (The type of structure (e.g. Full, Partial, Representative).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureRepresentationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of structure (e.g. Full, Partial, Representative).)
         */
        public SubstanceDefinitionStructureRepresentationComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #representation} (The structural representation as text string in a standard format e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.). This is the underlying object with id, value and extensions. The accessor "getRepresentation" gives direct access to the value
         */
        public StringType getRepresentationElement() { 
          if (this.representation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureRepresentationComponent.representation");
            else if (Configuration.doAutoCreate())
              this.representation = new StringType(); // bb
          return this.representation;
        }

        public boolean hasRepresentationElement() { 
          return this.representation != null && !this.representation.isEmpty();
        }

        public boolean hasRepresentation() { 
          return this.representation != null && !this.representation.isEmpty();
        }

        /**
         * @param value {@link #representation} (The structural representation as text string in a standard format e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.). This is the underlying object with id, value and extensions. The accessor "getRepresentation" gives direct access to the value
         */
        public SubstanceDefinitionStructureRepresentationComponent setRepresentationElement(StringType value) { 
          this.representation = value;
          return this;
        }

        /**
         * @return The structural representation as text string in a standard format e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.
         */
        public String getRepresentation() { 
          return this.representation == null ? null : this.representation.getValue();
        }

        /**
         * @param value The structural representation as text string in a standard format e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.
         */
        public SubstanceDefinitionStructureRepresentationComponent setRepresentation(String value) { 
          if (Utilities.noString(value))
            this.representation = null;
          else {
            if (this.representation == null)
              this.representation = new StringType();
            this.representation.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #format} (The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.)
         */
        public CodeableConcept getFormat() { 
          if (this.format == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureRepresentationComponent.format");
            else if (Configuration.doAutoCreate())
              this.format = new CodeableConcept(); // cc
          return this.format;
        }

        public boolean hasFormat() { 
          return this.format != null && !this.format.isEmpty();
        }

        /**
         * @param value {@link #format} (The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.)
         */
        public SubstanceDefinitionStructureRepresentationComponent setFormat(CodeableConcept value) { 
          this.format = value;
          return this;
        }

        /**
         * @return {@link #attachment} (An attached file with the structural representation.)
         */
        public Attachment getAttachment() { 
          if (this.attachment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionStructureRepresentationComponent.attachment");
            else if (Configuration.doAutoCreate())
              this.attachment = new Attachment(); // cc
          return this.attachment;
        }

        public boolean hasAttachment() { 
          return this.attachment != null && !this.attachment.isEmpty();
        }

        /**
         * @param value {@link #attachment} (An attached file with the structural representation.)
         */
        public SubstanceDefinitionStructureRepresentationComponent setAttachment(Attachment value) { 
          this.attachment = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The type of structure (e.g. Full, Partial, Representative).", 0, 1, type));
          children.add(new Property("representation", "string", "The structural representation as text string in a standard format e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.", 0, 1, representation));
          children.add(new Property("format", "CodeableConcept", "The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.", 0, 1, format));
          children.add(new Property("attachment", "Attachment", "An attached file with the structural representation.", 0, 1, attachment));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of structure (e.g. Full, Partial, Representative).", 0, 1, type);
          case -671065907: /*representation*/  return new Property("representation", "string", "The structural representation as text string in a standard format e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.", 0, 1, representation);
          case -1268779017: /*format*/  return new Property("format", "CodeableConcept", "The format of the representation e.g. InChI, SMILES, MOLFILE, CDX, SDF, PDB, mmCIF.", 0, 1, format);
          case -1963501277: /*attachment*/  return new Property("attachment", "Attachment", "An attached file with the structural representation.", 0, 1, attachment);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -671065907: /*representation*/ return this.representation == null ? new Base[0] : new Base[] {this.representation}; // StringType
        case -1268779017: /*format*/ return this.format == null ? new Base[0] : new Base[] {this.format}; // CodeableConcept
        case -1963501277: /*attachment*/ return this.attachment == null ? new Base[0] : new Base[] {this.attachment}; // Attachment
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -671065907: // representation
          this.representation = TypeConvertor.castToString(value); // StringType
          return value;
        case -1268779017: // format
          this.format = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1963501277: // attachment
          this.attachment = TypeConvertor.castToAttachment(value); // Attachment
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("representation")) {
          this.representation = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("format")) {
          this.format = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("attachment")) {
          this.attachment = TypeConvertor.castToAttachment(value); // Attachment
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -671065907:  return getRepresentationElement();
        case -1268779017:  return getFormat();
        case -1963501277:  return getAttachment();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -671065907: /*representation*/ return new String[] {"string"};
        case -1268779017: /*format*/ return new String[] {"CodeableConcept"};
        case -1963501277: /*attachment*/ return new String[] {"Attachment"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("representation")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.structure.representation.representation");
        }
        else if (name.equals("format")) {
          this.format = new CodeableConcept();
          return this.format;
        }
        else if (name.equals("attachment")) {
          this.attachment = new Attachment();
          return this.attachment;
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionStructureRepresentationComponent copy() {
        SubstanceDefinitionStructureRepresentationComponent dst = new SubstanceDefinitionStructureRepresentationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionStructureRepresentationComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.representation = representation == null ? null : representation.copy();
        dst.format = format == null ? null : format.copy();
        dst.attachment = attachment == null ? null : attachment.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionStructureRepresentationComponent))
          return false;
        SubstanceDefinitionStructureRepresentationComponent o = (SubstanceDefinitionStructureRepresentationComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(representation, o.representation, true) && compareDeep(format, o.format, true)
           && compareDeep(attachment, o.attachment, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionStructureRepresentationComponent))
          return false;
        SubstanceDefinitionStructureRepresentationComponent o = (SubstanceDefinitionStructureRepresentationComponent) other_;
        return compareValues(representation, o.representation, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, representation, format
          , attachment);
      }

  public String fhirType() {
    return "SubstanceDefinition.structure.representation";

  }

  }

    @Block()
    public static class SubstanceDefinitionCodeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The specific code.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The specific code", formalDefinition="The specific code." )
        protected CodeableConcept code;

        /**
         * Status of the code assignment, for example 'provisional', 'approved'.
         */
        @Child(name = "status", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Status of the code assignment, for example 'provisional', 'approved'", formalDefinition="Status of the code assignment, for example 'provisional', 'approved'." )
        protected CodeableConcept status;

        /**
         * The date at which the code status is changed as part of the terminology maintenance.
         */
        @Child(name = "statusDate", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The date at which the code status is changed as part of the terminology maintenance", formalDefinition="The date at which the code status is changed as part of the terminology maintenance." )
        protected DateTimeType statusDate;

        /**
         * Any comment can be provided in this field, if necessary.
         */
        @Child(name = "note", type = {Annotation.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Any comment can be provided in this field, if necessary", formalDefinition="Any comment can be provided in this field, if necessary." )
        protected List<Annotation> note;

        /**
         * Supporting literature.
         */
        @Child(name = "source", type = {DocumentReference.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Supporting literature", formalDefinition="Supporting literature." )
        protected List<Reference> source;

        private static final long serialVersionUID = 1140562105L;

    /**
     * Constructor
     */
      public SubstanceDefinitionCodeComponent() {
        super();
      }

        /**
         * @return {@link #code} (The specific code.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionCodeComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (The specific code.)
         */
        public SubstanceDefinitionCodeComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #status} (Status of the code assignment, for example 'provisional', 'approved'.)
         */
        public CodeableConcept getStatus() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionCodeComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new CodeableConcept(); // cc
          return this.status;
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (Status of the code assignment, for example 'provisional', 'approved'.)
         */
        public SubstanceDefinitionCodeComponent setStatus(CodeableConcept value) { 
          this.status = value;
          return this;
        }

        /**
         * @return {@link #statusDate} (The date at which the code status is changed as part of the terminology maintenance.). This is the underlying object with id, value and extensions. The accessor "getStatusDate" gives direct access to the value
         */
        public DateTimeType getStatusDateElement() { 
          if (this.statusDate == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionCodeComponent.statusDate");
            else if (Configuration.doAutoCreate())
              this.statusDate = new DateTimeType(); // bb
          return this.statusDate;
        }

        public boolean hasStatusDateElement() { 
          return this.statusDate != null && !this.statusDate.isEmpty();
        }

        public boolean hasStatusDate() { 
          return this.statusDate != null && !this.statusDate.isEmpty();
        }

        /**
         * @param value {@link #statusDate} (The date at which the code status is changed as part of the terminology maintenance.). This is the underlying object with id, value and extensions. The accessor "getStatusDate" gives direct access to the value
         */
        public SubstanceDefinitionCodeComponent setStatusDateElement(DateTimeType value) { 
          this.statusDate = value;
          return this;
        }

        /**
         * @return The date at which the code status is changed as part of the terminology maintenance.
         */
        public Date getStatusDate() { 
          return this.statusDate == null ? null : this.statusDate.getValue();
        }

        /**
         * @param value The date at which the code status is changed as part of the terminology maintenance.
         */
        public SubstanceDefinitionCodeComponent setStatusDate(Date value) { 
          if (value == null)
            this.statusDate = null;
          else {
            if (this.statusDate == null)
              this.statusDate = new DateTimeType();
            this.statusDate.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #note} (Any comment can be provided in this field, if necessary.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionCodeComponent setNote(List<Annotation> theNote) { 
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

        public SubstanceDefinitionCodeComponent addNote(Annotation t) { //3
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
         * @return {@link #source} (Supporting literature.)
         */
        public List<Reference> getSource() { 
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          return this.source;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionCodeComponent setSource(List<Reference> theSource) { 
          this.source = theSource;
          return this;
        }

        public boolean hasSource() { 
          if (this.source == null)
            return false;
          for (Reference item : this.source)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addSource() { //3
          Reference t = new Reference();
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          this.source.add(t);
          return t;
        }

        public SubstanceDefinitionCodeComponent addSource(Reference t) { //3
          if (t == null)
            return this;
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          this.source.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #source}, creating it if it does not already exist {3}
         */
        public Reference getSourceFirstRep() { 
          if (getSource().isEmpty()) {
            addSource();
          }
          return getSource().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("code", "CodeableConcept", "The specific code.", 0, 1, code));
          children.add(new Property("status", "CodeableConcept", "Status of the code assignment, for example 'provisional', 'approved'.", 0, 1, status));
          children.add(new Property("statusDate", "dateTime", "The date at which the code status is changed as part of the terminology maintenance.", 0, 1, statusDate));
          children.add(new Property("note", "Annotation", "Any comment can be provided in this field, if necessary.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "The specific code.", 0, 1, code);
          case -892481550: /*status*/  return new Property("status", "CodeableConcept", "Status of the code assignment, for example 'provisional', 'approved'.", 0, 1, status);
          case 247524032: /*statusDate*/  return new Property("statusDate", "dateTime", "The date at which the code status is changed as part of the terminology maintenance.", 0, 1, statusDate);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Any comment can be provided in this field, if necessary.", 0, java.lang.Integer.MAX_VALUE, note);
          case -896505829: /*source*/  return new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 247524032: /*statusDate*/ return this.statusDate == null ? new Base[0] : new Base[] {this.statusDate}; // DateTimeType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -896505829: /*source*/ return this.source == null ? new Base[0] : this.source.toArray(new Base[this.source.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 247524032: // statusDate
          this.statusDate = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -896505829: // source
          this.getSource().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("statusDate")) {
          this.statusDate = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("source")) {
          this.getSource().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181:  return getCode();
        case -892481550:  return getStatus();
        case 247524032:  return getStatusDateElement();
        case 3387378:  return addNote(); 
        case -896505829:  return addSource(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case 247524032: /*statusDate*/ return new String[] {"dateTime"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -896505829: /*source*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("statusDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.code.statusDate");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("source")) {
          return addSource();
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionCodeComponent copy() {
        SubstanceDefinitionCodeComponent dst = new SubstanceDefinitionCodeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionCodeComponent dst) {
        super.copyValues(dst);
        dst.code = code == null ? null : code.copy();
        dst.status = status == null ? null : status.copy();
        dst.statusDate = statusDate == null ? null : statusDate.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (source != null) {
          dst.source = new ArrayList<Reference>();
          for (Reference i : source)
            dst.source.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionCodeComponent))
          return false;
        SubstanceDefinitionCodeComponent o = (SubstanceDefinitionCodeComponent) other_;
        return compareDeep(code, o.code, true) && compareDeep(status, o.status, true) && compareDeep(statusDate, o.statusDate, true)
           && compareDeep(note, o.note, true) && compareDeep(source, o.source, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionCodeComponent))
          return false;
        SubstanceDefinitionCodeComponent o = (SubstanceDefinitionCodeComponent) other_;
        return compareValues(statusDate, o.statusDate, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(code, status, statusDate
          , note, source);
      }

  public String fhirType() {
    return "SubstanceDefinition.code";

  }

  }

    @Block()
    public static class SubstanceDefinitionNameComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The actual name.
         */
        @Child(name = "name", type = {StringType.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The actual name", formalDefinition="The actual name." )
        protected StringType name;

        /**
         * Name type, for example 'systematic',  'scientific, 'brand'.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Name type, for example 'systematic',  'scientific, 'brand'", formalDefinition="Name type, for example 'systematic',  'scientific, 'brand'." )
        protected CodeableConcept type;

        /**
         * The status of the name, for example 'current', 'proposed'.
         */
        @Child(name = "status", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The status of the name, for example 'current', 'proposed'", formalDefinition="The status of the name, for example 'current', 'proposed'." )
        protected CodeableConcept status;

        /**
         * If this is the preferred name for this substance.
         */
        @Child(name = "preferred", type = {BooleanType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="If this is the preferred name for this substance", formalDefinition="If this is the preferred name for this substance." )
        protected BooleanType preferred;

        /**
         * Human language that the name is written in.
         */
        @Child(name = "language", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Human language that the name is written in", formalDefinition="Human language that the name is written in." )
        protected List<CodeableConcept> language;

        /**
         * The use context of this name for example if there is a different name a drug active ingredient as opposed to a food colour additive.
         */
        @Child(name = "domain", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The use context of this name for example if there is a different name a drug active ingredient as opposed to a food colour additive", formalDefinition="The use context of this name for example if there is a different name a drug active ingredient as opposed to a food colour additive." )
        protected List<CodeableConcept> domain;

        /**
         * The jurisdiction where this name applies.
         */
        @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="The jurisdiction where this name applies", formalDefinition="The jurisdiction where this name applies." )
        protected List<CodeableConcept> jurisdiction;

        /**
         * A synonym of this particular name, by which the substance is also known.
         */
        @Child(name = "synonym", type = {SubstanceDefinitionNameComponent.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A synonym of this particular name, by which the substance is also known", formalDefinition="A synonym of this particular name, by which the substance is also known." )
        protected List<SubstanceDefinitionNameComponent> synonym;

        /**
         * A translation for this name into another human language.
         */
        @Child(name = "translation", type = {SubstanceDefinitionNameComponent.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="A translation for this name into another human language", formalDefinition="A translation for this name into another human language." )
        protected List<SubstanceDefinitionNameComponent> translation;

        /**
         * Details of the official nature of this name.
         */
        @Child(name = "official", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Details of the official nature of this name", formalDefinition="Details of the official nature of this name." )
        protected List<SubstanceDefinitionNameOfficialComponent> official;

        /**
         * Supporting literature.
         */
        @Child(name = "source", type = {DocumentReference.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Supporting literature", formalDefinition="Supporting literature." )
        protected List<Reference> source;

        private static final long serialVersionUID = -1184238780L;

    /**
     * Constructor
     */
      public SubstanceDefinitionNameComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SubstanceDefinitionNameComponent(String name) {
        super();
        this.setName(name);
      }

        /**
         * @return {@link #name} (The actual name.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionNameComponent.name");
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
         * @param value {@link #name} (The actual name.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public SubstanceDefinitionNameComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return The actual name.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value The actual name.
         */
        public SubstanceDefinitionNameComponent setName(String value) { 
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (Name type, for example 'systematic',  'scientific, 'brand'.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionNameComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Name type, for example 'systematic',  'scientific, 'brand'.)
         */
        public SubstanceDefinitionNameComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #status} (The status of the name, for example 'current', 'proposed'.)
         */
        public CodeableConcept getStatus() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionNameComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new CodeableConcept(); // cc
          return this.status;
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (The status of the name, for example 'current', 'proposed'.)
         */
        public SubstanceDefinitionNameComponent setStatus(CodeableConcept value) { 
          this.status = value;
          return this;
        }

        /**
         * @return {@link #preferred} (If this is the preferred name for this substance.). This is the underlying object with id, value and extensions. The accessor "getPreferred" gives direct access to the value
         */
        public BooleanType getPreferredElement() { 
          if (this.preferred == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionNameComponent.preferred");
            else if (Configuration.doAutoCreate())
              this.preferred = new BooleanType(); // bb
          return this.preferred;
        }

        public boolean hasPreferredElement() { 
          return this.preferred != null && !this.preferred.isEmpty();
        }

        public boolean hasPreferred() { 
          return this.preferred != null && !this.preferred.isEmpty();
        }

        /**
         * @param value {@link #preferred} (If this is the preferred name for this substance.). This is the underlying object with id, value and extensions. The accessor "getPreferred" gives direct access to the value
         */
        public SubstanceDefinitionNameComponent setPreferredElement(BooleanType value) { 
          this.preferred = value;
          return this;
        }

        /**
         * @return If this is the preferred name for this substance.
         */
        public boolean getPreferred() { 
          return this.preferred == null || this.preferred.isEmpty() ? false : this.preferred.getValue();
        }

        /**
         * @param value If this is the preferred name for this substance.
         */
        public SubstanceDefinitionNameComponent setPreferred(boolean value) { 
            if (this.preferred == null)
              this.preferred = new BooleanType();
            this.preferred.setValue(value);
          return this;
        }

        /**
         * @return {@link #language} (Human language that the name is written in.)
         */
        public List<CodeableConcept> getLanguage() { 
          if (this.language == null)
            this.language = new ArrayList<CodeableConcept>();
          return this.language;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionNameComponent setLanguage(List<CodeableConcept> theLanguage) { 
          this.language = theLanguage;
          return this;
        }

        public boolean hasLanguage() { 
          if (this.language == null)
            return false;
          for (CodeableConcept item : this.language)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addLanguage() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.language == null)
            this.language = new ArrayList<CodeableConcept>();
          this.language.add(t);
          return t;
        }

        public SubstanceDefinitionNameComponent addLanguage(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.language == null)
            this.language = new ArrayList<CodeableConcept>();
          this.language.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #language}, creating it if it does not already exist {3}
         */
        public CodeableConcept getLanguageFirstRep() { 
          if (getLanguage().isEmpty()) {
            addLanguage();
          }
          return getLanguage().get(0);
        }

        /**
         * @return {@link #domain} (The use context of this name for example if there is a different name a drug active ingredient as opposed to a food colour additive.)
         */
        public List<CodeableConcept> getDomain() { 
          if (this.domain == null)
            this.domain = new ArrayList<CodeableConcept>();
          return this.domain;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionNameComponent setDomain(List<CodeableConcept> theDomain) { 
          this.domain = theDomain;
          return this;
        }

        public boolean hasDomain() { 
          if (this.domain == null)
            return false;
          for (CodeableConcept item : this.domain)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addDomain() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.domain == null)
            this.domain = new ArrayList<CodeableConcept>();
          this.domain.add(t);
          return t;
        }

        public SubstanceDefinitionNameComponent addDomain(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.domain == null)
            this.domain = new ArrayList<CodeableConcept>();
          this.domain.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #domain}, creating it if it does not already exist {3}
         */
        public CodeableConcept getDomainFirstRep() { 
          if (getDomain().isEmpty()) {
            addDomain();
          }
          return getDomain().get(0);
        }

        /**
         * @return {@link #jurisdiction} (The jurisdiction where this name applies.)
         */
        public List<CodeableConcept> getJurisdiction() { 
          if (this.jurisdiction == null)
            this.jurisdiction = new ArrayList<CodeableConcept>();
          return this.jurisdiction;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionNameComponent setJurisdiction(List<CodeableConcept> theJurisdiction) { 
          this.jurisdiction = theJurisdiction;
          return this;
        }

        public boolean hasJurisdiction() { 
          if (this.jurisdiction == null)
            return false;
          for (CodeableConcept item : this.jurisdiction)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addJurisdiction() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.jurisdiction == null)
            this.jurisdiction = new ArrayList<CodeableConcept>();
          this.jurisdiction.add(t);
          return t;
        }

        public SubstanceDefinitionNameComponent addJurisdiction(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.jurisdiction == null)
            this.jurisdiction = new ArrayList<CodeableConcept>();
          this.jurisdiction.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #jurisdiction}, creating it if it does not already exist {3}
         */
        public CodeableConcept getJurisdictionFirstRep() { 
          if (getJurisdiction().isEmpty()) {
            addJurisdiction();
          }
          return getJurisdiction().get(0);
        }

        /**
         * @return {@link #synonym} (A synonym of this particular name, by which the substance is also known.)
         */
        public List<SubstanceDefinitionNameComponent> getSynonym() { 
          if (this.synonym == null)
            this.synonym = new ArrayList<SubstanceDefinitionNameComponent>();
          return this.synonym;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionNameComponent setSynonym(List<SubstanceDefinitionNameComponent> theSynonym) { 
          this.synonym = theSynonym;
          return this;
        }

        public boolean hasSynonym() { 
          if (this.synonym == null)
            return false;
          for (SubstanceDefinitionNameComponent item : this.synonym)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SubstanceDefinitionNameComponent addSynonym() { //3
          SubstanceDefinitionNameComponent t = new SubstanceDefinitionNameComponent();
          if (this.synonym == null)
            this.synonym = new ArrayList<SubstanceDefinitionNameComponent>();
          this.synonym.add(t);
          return t;
        }

        public SubstanceDefinitionNameComponent addSynonym(SubstanceDefinitionNameComponent t) { //3
          if (t == null)
            return this;
          if (this.synonym == null)
            this.synonym = new ArrayList<SubstanceDefinitionNameComponent>();
          this.synonym.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #synonym}, creating it if it does not already exist {3}
         */
        public SubstanceDefinitionNameComponent getSynonymFirstRep() { 
          if (getSynonym().isEmpty()) {
            addSynonym();
          }
          return getSynonym().get(0);
        }

        /**
         * @return {@link #translation} (A translation for this name into another human language.)
         */
        public List<SubstanceDefinitionNameComponent> getTranslation() { 
          if (this.translation == null)
            this.translation = new ArrayList<SubstanceDefinitionNameComponent>();
          return this.translation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionNameComponent setTranslation(List<SubstanceDefinitionNameComponent> theTranslation) { 
          this.translation = theTranslation;
          return this;
        }

        public boolean hasTranslation() { 
          if (this.translation == null)
            return false;
          for (SubstanceDefinitionNameComponent item : this.translation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SubstanceDefinitionNameComponent addTranslation() { //3
          SubstanceDefinitionNameComponent t = new SubstanceDefinitionNameComponent();
          if (this.translation == null)
            this.translation = new ArrayList<SubstanceDefinitionNameComponent>();
          this.translation.add(t);
          return t;
        }

        public SubstanceDefinitionNameComponent addTranslation(SubstanceDefinitionNameComponent t) { //3
          if (t == null)
            return this;
          if (this.translation == null)
            this.translation = new ArrayList<SubstanceDefinitionNameComponent>();
          this.translation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #translation}, creating it if it does not already exist {3}
         */
        public SubstanceDefinitionNameComponent getTranslationFirstRep() { 
          if (getTranslation().isEmpty()) {
            addTranslation();
          }
          return getTranslation().get(0);
        }

        /**
         * @return {@link #official} (Details of the official nature of this name.)
         */
        public List<SubstanceDefinitionNameOfficialComponent> getOfficial() { 
          if (this.official == null)
            this.official = new ArrayList<SubstanceDefinitionNameOfficialComponent>();
          return this.official;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionNameComponent setOfficial(List<SubstanceDefinitionNameOfficialComponent> theOfficial) { 
          this.official = theOfficial;
          return this;
        }

        public boolean hasOfficial() { 
          if (this.official == null)
            return false;
          for (SubstanceDefinitionNameOfficialComponent item : this.official)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SubstanceDefinitionNameOfficialComponent addOfficial() { //3
          SubstanceDefinitionNameOfficialComponent t = new SubstanceDefinitionNameOfficialComponent();
          if (this.official == null)
            this.official = new ArrayList<SubstanceDefinitionNameOfficialComponent>();
          this.official.add(t);
          return t;
        }

        public SubstanceDefinitionNameComponent addOfficial(SubstanceDefinitionNameOfficialComponent t) { //3
          if (t == null)
            return this;
          if (this.official == null)
            this.official = new ArrayList<SubstanceDefinitionNameOfficialComponent>();
          this.official.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #official}, creating it if it does not already exist {3}
         */
        public SubstanceDefinitionNameOfficialComponent getOfficialFirstRep() { 
          if (getOfficial().isEmpty()) {
            addOfficial();
          }
          return getOfficial().get(0);
        }

        /**
         * @return {@link #source} (Supporting literature.)
         */
        public List<Reference> getSource() { 
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          return this.source;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionNameComponent setSource(List<Reference> theSource) { 
          this.source = theSource;
          return this;
        }

        public boolean hasSource() { 
          if (this.source == null)
            return false;
          for (Reference item : this.source)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addSource() { //3
          Reference t = new Reference();
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          this.source.add(t);
          return t;
        }

        public SubstanceDefinitionNameComponent addSource(Reference t) { //3
          if (t == null)
            return this;
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          this.source.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #source}, creating it if it does not already exist {3}
         */
        public Reference getSourceFirstRep() { 
          if (getSource().isEmpty()) {
            addSource();
          }
          return getSource().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("name", "string", "The actual name.", 0, 1, name));
          children.add(new Property("type", "CodeableConcept", "Name type, for example 'systematic',  'scientific, 'brand'.", 0, 1, type));
          children.add(new Property("status", "CodeableConcept", "The status of the name, for example 'current', 'proposed'.", 0, 1, status));
          children.add(new Property("preferred", "boolean", "If this is the preferred name for this substance.", 0, 1, preferred));
          children.add(new Property("language", "CodeableConcept", "Human language that the name is written in.", 0, java.lang.Integer.MAX_VALUE, language));
          children.add(new Property("domain", "CodeableConcept", "The use context of this name for example if there is a different name a drug active ingredient as opposed to a food colour additive.", 0, java.lang.Integer.MAX_VALUE, domain));
          children.add(new Property("jurisdiction", "CodeableConcept", "The jurisdiction where this name applies.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
          children.add(new Property("synonym", "@SubstanceDefinition.name", "A synonym of this particular name, by which the substance is also known.", 0, java.lang.Integer.MAX_VALUE, synonym));
          children.add(new Property("translation", "@SubstanceDefinition.name", "A translation for this name into another human language.", 0, java.lang.Integer.MAX_VALUE, translation));
          children.add(new Property("official", "", "Details of the official nature of this name.", 0, java.lang.Integer.MAX_VALUE, official));
          children.add(new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3373707: /*name*/  return new Property("name", "string", "The actual name.", 0, 1, name);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Name type, for example 'systematic',  'scientific, 'brand'.", 0, 1, type);
          case -892481550: /*status*/  return new Property("status", "CodeableConcept", "The status of the name, for example 'current', 'proposed'.", 0, 1, status);
          case -1294005119: /*preferred*/  return new Property("preferred", "boolean", "If this is the preferred name for this substance.", 0, 1, preferred);
          case -1613589672: /*language*/  return new Property("language", "CodeableConcept", "Human language that the name is written in.", 0, java.lang.Integer.MAX_VALUE, language);
          case -1326197564: /*domain*/  return new Property("domain", "CodeableConcept", "The use context of this name for example if there is a different name a drug active ingredient as opposed to a food colour additive.", 0, java.lang.Integer.MAX_VALUE, domain);
          case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "The jurisdiction where this name applies.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
          case -1742128133: /*synonym*/  return new Property("synonym", "@SubstanceDefinition.name", "A synonym of this particular name, by which the substance is also known.", 0, java.lang.Integer.MAX_VALUE, synonym);
          case -1840647503: /*translation*/  return new Property("translation", "@SubstanceDefinition.name", "A translation for this name into another human language.", 0, java.lang.Integer.MAX_VALUE, translation);
          case -765289749: /*official*/  return new Property("official", "", "Details of the official nature of this name.", 0, java.lang.Integer.MAX_VALUE, official);
          case -896505829: /*source*/  return new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case -1294005119: /*preferred*/ return this.preferred == null ? new Base[0] : new Base[] {this.preferred}; // BooleanType
        case -1613589672: /*language*/ return this.language == null ? new Base[0] : this.language.toArray(new Base[this.language.size()]); // CodeableConcept
        case -1326197564: /*domain*/ return this.domain == null ? new Base[0] : this.domain.toArray(new Base[this.domain.size()]); // CodeableConcept
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -1742128133: /*synonym*/ return this.synonym == null ? new Base[0] : this.synonym.toArray(new Base[this.synonym.size()]); // SubstanceDefinitionNameComponent
        case -1840647503: /*translation*/ return this.translation == null ? new Base[0] : this.translation.toArray(new Base[this.translation.size()]); // SubstanceDefinitionNameComponent
        case -765289749: /*official*/ return this.official == null ? new Base[0] : this.official.toArray(new Base[this.official.size()]); // SubstanceDefinitionNameOfficialComponent
        case -896505829: /*source*/ return this.source == null ? new Base[0] : this.source.toArray(new Base[this.source.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1294005119: // preferred
          this.preferred = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1613589672: // language
          this.getLanguage().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1326197564: // domain
          this.getDomain().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -507075711: // jurisdiction
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1742128133: // synonym
          this.getSynonym().add((SubstanceDefinitionNameComponent) value); // SubstanceDefinitionNameComponent
          return value;
        case -1840647503: // translation
          this.getTranslation().add((SubstanceDefinitionNameComponent) value); // SubstanceDefinitionNameComponent
          return value;
        case -765289749: // official
          this.getOfficial().add((SubstanceDefinitionNameOfficialComponent) value); // SubstanceDefinitionNameOfficialComponent
          return value;
        case -896505829: // source
          this.getSource().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("preferred")) {
          this.preferred = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("language")) {
          this.getLanguage().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("domain")) {
          this.getDomain().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("synonym")) {
          this.getSynonym().add((SubstanceDefinitionNameComponent) value);
        } else if (name.equals("translation")) {
          this.getTranslation().add((SubstanceDefinitionNameComponent) value);
        } else if (name.equals("official")) {
          this.getOfficial().add((SubstanceDefinitionNameOfficialComponent) value);
        } else if (name.equals("source")) {
          this.getSource().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707:  return getNameElement();
        case 3575610:  return getType();
        case -892481550:  return getStatus();
        case -1294005119:  return getPreferredElement();
        case -1613589672:  return addLanguage(); 
        case -1326197564:  return addDomain(); 
        case -507075711:  return addJurisdiction(); 
        case -1742128133:  return addSynonym(); 
        case -1840647503:  return addTranslation(); 
        case -765289749:  return addOfficial(); 
        case -896505829:  return addSource(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3373707: /*name*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case -1294005119: /*preferred*/ return new String[] {"boolean"};
        case -1613589672: /*language*/ return new String[] {"CodeableConcept"};
        case -1326197564: /*domain*/ return new String[] {"CodeableConcept"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -1742128133: /*synonym*/ return new String[] {"@SubstanceDefinition.name"};
        case -1840647503: /*translation*/ return new String[] {"@SubstanceDefinition.name"};
        case -765289749: /*official*/ return new String[] {};
        case -896505829: /*source*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.name.name");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("preferred")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.name.preferred");
        }
        else if (name.equals("language")) {
          return addLanguage();
        }
        else if (name.equals("domain")) {
          return addDomain();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("synonym")) {
          return addSynonym();
        }
        else if (name.equals("translation")) {
          return addTranslation();
        }
        else if (name.equals("official")) {
          return addOfficial();
        }
        else if (name.equals("source")) {
          return addSource();
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionNameComponent copy() {
        SubstanceDefinitionNameComponent dst = new SubstanceDefinitionNameComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionNameComponent dst) {
        super.copyValues(dst);
        dst.name = name == null ? null : name.copy();
        dst.type = type == null ? null : type.copy();
        dst.status = status == null ? null : status.copy();
        dst.preferred = preferred == null ? null : preferred.copy();
        if (language != null) {
          dst.language = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : language)
            dst.language.add(i.copy());
        };
        if (domain != null) {
          dst.domain = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : domain)
            dst.domain.add(i.copy());
        };
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        if (synonym != null) {
          dst.synonym = new ArrayList<SubstanceDefinitionNameComponent>();
          for (SubstanceDefinitionNameComponent i : synonym)
            dst.synonym.add(i.copy());
        };
        if (translation != null) {
          dst.translation = new ArrayList<SubstanceDefinitionNameComponent>();
          for (SubstanceDefinitionNameComponent i : translation)
            dst.translation.add(i.copy());
        };
        if (official != null) {
          dst.official = new ArrayList<SubstanceDefinitionNameOfficialComponent>();
          for (SubstanceDefinitionNameOfficialComponent i : official)
            dst.official.add(i.copy());
        };
        if (source != null) {
          dst.source = new ArrayList<Reference>();
          for (Reference i : source)
            dst.source.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionNameComponent))
          return false;
        SubstanceDefinitionNameComponent o = (SubstanceDefinitionNameComponent) other_;
        return compareDeep(name, o.name, true) && compareDeep(type, o.type, true) && compareDeep(status, o.status, true)
           && compareDeep(preferred, o.preferred, true) && compareDeep(language, o.language, true) && compareDeep(domain, o.domain, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(synonym, o.synonym, true) && compareDeep(translation, o.translation, true)
           && compareDeep(official, o.official, true) && compareDeep(source, o.source, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionNameComponent))
          return false;
        SubstanceDefinitionNameComponent o = (SubstanceDefinitionNameComponent) other_;
        return compareValues(name, o.name, true) && compareValues(preferred, o.preferred, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(name, type, status, preferred
          , language, domain, jurisdiction, synonym, translation, official, source);
      }

  public String fhirType() {
    return "SubstanceDefinition.name";

  }

  }

    @Block()
    public static class SubstanceDefinitionNameOfficialComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Which authority uses this official name.
         */
        @Child(name = "authority", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Which authority uses this official name", formalDefinition="Which authority uses this official name." )
        protected CodeableConcept authority;

        /**
         * The status of the official name, for example 'provisional', 'approved'.
         */
        @Child(name = "status", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="The status of the official name, for example 'provisional', 'approved'", formalDefinition="The status of the official name, for example 'provisional', 'approved'." )
        protected CodeableConcept status;

        /**
         * Date of official name change.
         */
        @Child(name = "date", type = {DateTimeType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Date of official name change", formalDefinition="Date of official name change." )
        protected DateTimeType date;

        private static final long serialVersionUID = -2040011008L;

    /**
     * Constructor
     */
      public SubstanceDefinitionNameOfficialComponent() {
        super();
      }

        /**
         * @return {@link #authority} (Which authority uses this official name.)
         */
        public CodeableConcept getAuthority() { 
          if (this.authority == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionNameOfficialComponent.authority");
            else if (Configuration.doAutoCreate())
              this.authority = new CodeableConcept(); // cc
          return this.authority;
        }

        public boolean hasAuthority() { 
          return this.authority != null && !this.authority.isEmpty();
        }

        /**
         * @param value {@link #authority} (Which authority uses this official name.)
         */
        public SubstanceDefinitionNameOfficialComponent setAuthority(CodeableConcept value) { 
          this.authority = value;
          return this;
        }

        /**
         * @return {@link #status} (The status of the official name, for example 'provisional', 'approved'.)
         */
        public CodeableConcept getStatus() { 
          if (this.status == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionNameOfficialComponent.status");
            else if (Configuration.doAutoCreate())
              this.status = new CodeableConcept(); // cc
          return this.status;
        }

        public boolean hasStatus() { 
          return this.status != null && !this.status.isEmpty();
        }

        /**
         * @param value {@link #status} (The status of the official name, for example 'provisional', 'approved'.)
         */
        public SubstanceDefinitionNameOfficialComponent setStatus(CodeableConcept value) { 
          this.status = value;
          return this;
        }

        /**
         * @return {@link #date} (Date of official name change.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public DateTimeType getDateElement() { 
          if (this.date == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionNameOfficialComponent.date");
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
         * @param value {@link #date} (Date of official name change.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
         */
        public SubstanceDefinitionNameOfficialComponent setDateElement(DateTimeType value) { 
          this.date = value;
          return this;
        }

        /**
         * @return Date of official name change.
         */
        public Date getDate() { 
          return this.date == null ? null : this.date.getValue();
        }

        /**
         * @param value Date of official name change.
         */
        public SubstanceDefinitionNameOfficialComponent setDate(Date value) { 
          if (value == null)
            this.date = null;
          else {
            if (this.date == null)
              this.date = new DateTimeType();
            this.date.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("authority", "CodeableConcept", "Which authority uses this official name.", 0, 1, authority));
          children.add(new Property("status", "CodeableConcept", "The status of the official name, for example 'provisional', 'approved'.", 0, 1, status));
          children.add(new Property("date", "dateTime", "Date of official name change.", 0, 1, date));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1475610435: /*authority*/  return new Property("authority", "CodeableConcept", "Which authority uses this official name.", 0, 1, authority);
          case -892481550: /*status*/  return new Property("status", "CodeableConcept", "The status of the official name, for example 'provisional', 'approved'.", 0, 1, status);
          case 3076014: /*date*/  return new Property("date", "dateTime", "Date of official name change.", 0, 1, date);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1475610435: /*authority*/ return this.authority == null ? new Base[0] : new Base[] {this.authority}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1475610435: // authority
          this.authority = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("authority")) {
          this.authority = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1475610435:  return getAuthority();
        case -892481550:  return getStatus();
        case 3076014:  return getDateElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1475610435: /*authority*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("authority")) {
          this.authority = new CodeableConcept();
          return this.authority;
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.name.official.date");
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionNameOfficialComponent copy() {
        SubstanceDefinitionNameOfficialComponent dst = new SubstanceDefinitionNameOfficialComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionNameOfficialComponent dst) {
        super.copyValues(dst);
        dst.authority = authority == null ? null : authority.copy();
        dst.status = status == null ? null : status.copy();
        dst.date = date == null ? null : date.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionNameOfficialComponent))
          return false;
        SubstanceDefinitionNameOfficialComponent o = (SubstanceDefinitionNameOfficialComponent) other_;
        return compareDeep(authority, o.authority, true) && compareDeep(status, o.status, true) && compareDeep(date, o.date, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionNameOfficialComponent))
          return false;
        SubstanceDefinitionNameOfficialComponent o = (SubstanceDefinitionNameOfficialComponent) other_;
        return compareValues(date, o.date, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(authority, status, date
          );
      }

  public String fhirType() {
    return "SubstanceDefinition.name.official";

  }

  }

    @Block()
    public static class SubstanceDefinitionRelationshipComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A pointer to another substance, as a resource or just a representational code.
         */
        @Child(name = "substanceDefinition", type = {SubstanceDefinition.class, CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A pointer to another substance, as a resource or just a representational code", formalDefinition="A pointer to another substance, as a resource or just a representational code." )
        protected DataType substanceDefinition;

        /**
         * For example "salt to parent", "active moiety", "starting material", "polymorph".
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="For example \"salt to parent\", \"active moiety\", \"starting material\", \"polymorph\"", formalDefinition="For example \"salt to parent\", \"active moiety\", \"starting material\", \"polymorph\"." )
        protected CodeableConcept type;

        /**
         * For example where an enzyme strongly bonds with a particular substance, this is a defining relationship for that enzyme, out of several possible substance relationships.
         */
        @Child(name = "isDefining", type = {BooleanType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="For example where an enzyme strongly bonds with a particular substance, this is a defining relationship for that enzyme, out of several possible substance relationships", formalDefinition="For example where an enzyme strongly bonds with a particular substance, this is a defining relationship for that enzyme, out of several possible substance relationships." )
        protected BooleanType isDefining;

        /**
         * A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.
         */
        @Child(name = "amount", type = {Quantity.class, Range.class, Ratio.class, StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other", formalDefinition="A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other." )
        protected DataType amount;

        /**
         * For use when the numeric has an uncertain range.
         */
        @Child(name = "amountRatioHighLimit", type = {Ratio.class}, order=5, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="For use when the numeric has an uncertain range", formalDefinition="For use when the numeric has an uncertain range." )
        protected Ratio amountRatioHighLimit;

        /**
         * An operator for the amount, for example "average", "approximately", "less than".
         */
        @Child(name = "amountType", type = {CodeableConcept.class}, order=6, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="An operator for the amount, for example \"average\", \"approximately\", \"less than\"", formalDefinition="An operator for the amount, for example \"average\", \"approximately\", \"less than\"." )
        protected CodeableConcept amountType;

        /**
         * Supporting literature.
         */
        @Child(name = "source", type = {DocumentReference.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Supporting literature", formalDefinition="Supporting literature." )
        protected List<Reference> source;

        private static final long serialVersionUID = 447426308L;

    /**
     * Constructor
     */
      public SubstanceDefinitionRelationshipComponent() {
        super();
      }

        /**
         * @return {@link #substanceDefinition} (A pointer to another substance, as a resource or just a representational code.)
         */
        public DataType getSubstanceDefinition() { 
          return this.substanceDefinition;
        }

        /**
         * @return {@link #substanceDefinition} (A pointer to another substance, as a resource or just a representational code.)
         */
        public Reference getSubstanceDefinitionReference() throws FHIRException { 
          if (this.substanceDefinition == null)
            this.substanceDefinition = new Reference();
          if (!(this.substanceDefinition instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.substanceDefinition.getClass().getName()+" was encountered");
          return (Reference) this.substanceDefinition;
        }

        public boolean hasSubstanceDefinitionReference() { 
          return this != null && this.substanceDefinition instanceof Reference;
        }

        /**
         * @return {@link #substanceDefinition} (A pointer to another substance, as a resource or just a representational code.)
         */
        public CodeableConcept getSubstanceDefinitionCodeableConcept() throws FHIRException { 
          if (this.substanceDefinition == null)
            this.substanceDefinition = new CodeableConcept();
          if (!(this.substanceDefinition instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.substanceDefinition.getClass().getName()+" was encountered");
          return (CodeableConcept) this.substanceDefinition;
        }

        public boolean hasSubstanceDefinitionCodeableConcept() { 
          return this != null && this.substanceDefinition instanceof CodeableConcept;
        }

        public boolean hasSubstanceDefinition() { 
          return this.substanceDefinition != null && !this.substanceDefinition.isEmpty();
        }

        /**
         * @param value {@link #substanceDefinition} (A pointer to another substance, as a resource or just a representational code.)
         */
        public SubstanceDefinitionRelationshipComponent setSubstanceDefinition(DataType value) { 
          if (value != null && !(value instanceof Reference || value instanceof CodeableConcept))
            throw new Error("Not the right type for SubstanceDefinition.relationship.substanceDefinition[x]: "+value.fhirType());
          this.substanceDefinition = value;
          return this;
        }

        /**
         * @return {@link #type} (For example "salt to parent", "active moiety", "starting material", "polymorph".)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionRelationshipComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (For example "salt to parent", "active moiety", "starting material", "polymorph".)
         */
        public SubstanceDefinitionRelationshipComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #isDefining} (For example where an enzyme strongly bonds with a particular substance, this is a defining relationship for that enzyme, out of several possible substance relationships.). This is the underlying object with id, value and extensions. The accessor "getIsDefining" gives direct access to the value
         */
        public BooleanType getIsDefiningElement() { 
          if (this.isDefining == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionRelationshipComponent.isDefining");
            else if (Configuration.doAutoCreate())
              this.isDefining = new BooleanType(); // bb
          return this.isDefining;
        }

        public boolean hasIsDefiningElement() { 
          return this.isDefining != null && !this.isDefining.isEmpty();
        }

        public boolean hasIsDefining() { 
          return this.isDefining != null && !this.isDefining.isEmpty();
        }

        /**
         * @param value {@link #isDefining} (For example where an enzyme strongly bonds with a particular substance, this is a defining relationship for that enzyme, out of several possible substance relationships.). This is the underlying object with id, value and extensions. The accessor "getIsDefining" gives direct access to the value
         */
        public SubstanceDefinitionRelationshipComponent setIsDefiningElement(BooleanType value) { 
          this.isDefining = value;
          return this;
        }

        /**
         * @return For example where an enzyme strongly bonds with a particular substance, this is a defining relationship for that enzyme, out of several possible substance relationships.
         */
        public boolean getIsDefining() { 
          return this.isDefining == null || this.isDefining.isEmpty() ? false : this.isDefining.getValue();
        }

        /**
         * @param value For example where an enzyme strongly bonds with a particular substance, this is a defining relationship for that enzyme, out of several possible substance relationships.
         */
        public SubstanceDefinitionRelationshipComponent setIsDefining(boolean value) { 
            if (this.isDefining == null)
              this.isDefining = new BooleanType();
            this.isDefining.setValue(value);
          return this;
        }

        /**
         * @return {@link #amount} (A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.)
         */
        public DataType getAmount() { 
          return this.amount;
        }

        /**
         * @return {@link #amount} (A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.)
         */
        public Quantity getAmountQuantity() throws FHIRException { 
          if (this.amount == null)
            this.amount = new Quantity();
          if (!(this.amount instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (Quantity) this.amount;
        }

        public boolean hasAmountQuantity() { 
          return this != null && this.amount instanceof Quantity;
        }

        /**
         * @return {@link #amount} (A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.)
         */
        public Range getAmountRange() throws FHIRException { 
          if (this.amount == null)
            this.amount = new Range();
          if (!(this.amount instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (Range) this.amount;
        }

        public boolean hasAmountRange() { 
          return this != null && this.amount instanceof Range;
        }

        /**
         * @return {@link #amount} (A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.)
         */
        public Ratio getAmountRatio() throws FHIRException { 
          if (this.amount == null)
            this.amount = new Ratio();
          if (!(this.amount instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (Ratio) this.amount;
        }

        public boolean hasAmountRatio() { 
          return this != null && this.amount instanceof Ratio;
        }

        /**
         * @return {@link #amount} (A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.)
         */
        public StringType getAmountStringType() throws FHIRException { 
          if (this.amount == null)
            this.amount = new StringType();
          if (!(this.amount instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.amount.getClass().getName()+" was encountered");
          return (StringType) this.amount;
        }

        public boolean hasAmountStringType() { 
          return this != null && this.amount instanceof StringType;
        }

        public boolean hasAmount() { 
          return this.amount != null && !this.amount.isEmpty();
        }

        /**
         * @param value {@link #amount} (A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.)
         */
        public SubstanceDefinitionRelationshipComponent setAmount(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof Range || value instanceof Ratio || value instanceof StringType))
            throw new Error("Not the right type for SubstanceDefinition.relationship.amount[x]: "+value.fhirType());
          this.amount = value;
          return this;
        }

        /**
         * @return {@link #amountRatioHighLimit} (For use when the numeric has an uncertain range.)
         */
        public Ratio getAmountRatioHighLimit() { 
          if (this.amountRatioHighLimit == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionRelationshipComponent.amountRatioHighLimit");
            else if (Configuration.doAutoCreate())
              this.amountRatioHighLimit = new Ratio(); // cc
          return this.amountRatioHighLimit;
        }

        public boolean hasAmountRatioHighLimit() { 
          return this.amountRatioHighLimit != null && !this.amountRatioHighLimit.isEmpty();
        }

        /**
         * @param value {@link #amountRatioHighLimit} (For use when the numeric has an uncertain range.)
         */
        public SubstanceDefinitionRelationshipComponent setAmountRatioHighLimit(Ratio value) { 
          this.amountRatioHighLimit = value;
          return this;
        }

        /**
         * @return {@link #amountType} (An operator for the amount, for example "average", "approximately", "less than".)
         */
        public CodeableConcept getAmountType() { 
          if (this.amountType == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SubstanceDefinitionRelationshipComponent.amountType");
            else if (Configuration.doAutoCreate())
              this.amountType = new CodeableConcept(); // cc
          return this.amountType;
        }

        public boolean hasAmountType() { 
          return this.amountType != null && !this.amountType.isEmpty();
        }

        /**
         * @param value {@link #amountType} (An operator for the amount, for example "average", "approximately", "less than".)
         */
        public SubstanceDefinitionRelationshipComponent setAmountType(CodeableConcept value) { 
          this.amountType = value;
          return this;
        }

        /**
         * @return {@link #source} (Supporting literature.)
         */
        public List<Reference> getSource() { 
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          return this.source;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SubstanceDefinitionRelationshipComponent setSource(List<Reference> theSource) { 
          this.source = theSource;
          return this;
        }

        public boolean hasSource() { 
          if (this.source == null)
            return false;
          for (Reference item : this.source)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addSource() { //3
          Reference t = new Reference();
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          this.source.add(t);
          return t;
        }

        public SubstanceDefinitionRelationshipComponent addSource(Reference t) { //3
          if (t == null)
            return this;
          if (this.source == null)
            this.source = new ArrayList<Reference>();
          this.source.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #source}, creating it if it does not already exist {3}
         */
        public Reference getSourceFirstRep() { 
          if (getSource().isEmpty()) {
            addSource();
          }
          return getSource().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("substanceDefinition[x]", "Reference(SubstanceDefinition)|CodeableConcept", "A pointer to another substance, as a resource or just a representational code.", 0, 1, substanceDefinition));
          children.add(new Property("type", "CodeableConcept", "For example \"salt to parent\", \"active moiety\", \"starting material\", \"polymorph\".", 0, 1, type));
          children.add(new Property("isDefining", "boolean", "For example where an enzyme strongly bonds with a particular substance, this is a defining relationship for that enzyme, out of several possible substance relationships.", 0, 1, isDefining));
          children.add(new Property("amount[x]", "Quantity|Range|Ratio|string", "A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.", 0, 1, amount));
          children.add(new Property("amountRatioHighLimit", "Ratio", "For use when the numeric has an uncertain range.", 0, 1, amountRatioHighLimit));
          children.add(new Property("amountType", "CodeableConcept", "An operator for the amount, for example \"average\", \"approximately\", \"less than\".", 0, 1, amountType));
          children.add(new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1767011651: /*substanceDefinition[x]*/  return new Property("substanceDefinition[x]", "Reference(SubstanceDefinition)|CodeableConcept", "A pointer to another substance, as a resource or just a representational code.", 0, 1, substanceDefinition);
          case 718195427: /*substanceDefinition*/  return new Property("substanceDefinition[x]", "Reference(SubstanceDefinition)|CodeableConcept", "A pointer to another substance, as a resource or just a representational code.", 0, 1, substanceDefinition);
          case -308206680: /*substanceDefinitionReference*/  return new Property("substanceDefinition[x]", "Reference(SubstanceDefinition)", "A pointer to another substance, as a resource or just a representational code.", 0, 1, substanceDefinition);
          case -132490690: /*substanceDefinitionCodeableConcept*/  return new Property("substanceDefinition[x]", "CodeableConcept", "A pointer to another substance, as a resource or just a representational code.", 0, 1, substanceDefinition);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "For example \"salt to parent\", \"active moiety\", \"starting material\", \"polymorph\".", 0, 1, type);
          case -141812990: /*isDefining*/  return new Property("isDefining", "boolean", "For example where an enzyme strongly bonds with a particular substance, this is a defining relationship for that enzyme, out of several possible substance relationships.", 0, 1, isDefining);
          case 646780200: /*amount[x]*/  return new Property("amount[x]", "Quantity|Range|Ratio|string", "A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.", 0, 1, amount);
          case -1413853096: /*amount*/  return new Property("amount[x]", "Quantity|Range|Ratio|string", "A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.", 0, 1, amount);
          case 1664303363: /*amountQuantity*/  return new Property("amount[x]", "Quantity", "A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.", 0, 1, amount);
          case -1223462971: /*amountRange*/  return new Property("amount[x]", "Range", "A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.", 0, 1, amount);
          case -1223457133: /*amountRatio*/  return new Property("amount[x]", "Ratio", "A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.", 0, 1, amount);
          case 773651081: /*amountString*/  return new Property("amount[x]", "string", "A numeric factor for the relationship, for instance to express that the salt of a substance has some percentage of the active substance in relation to some other.", 0, 1, amount);
          case -1832648218: /*amountRatioHighLimit*/  return new Property("amountRatioHighLimit", "Ratio", "For use when the numeric has an uncertain range.", 0, 1, amountRatioHighLimit);
          case -1424857166: /*amountType*/  return new Property("amountType", "CodeableConcept", "An operator for the amount, for example \"average\", \"approximately\", \"less than\".", 0, 1, amountType);
          case -896505829: /*source*/  return new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 718195427: /*substanceDefinition*/ return this.substanceDefinition == null ? new Base[0] : new Base[] {this.substanceDefinition}; // DataType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -141812990: /*isDefining*/ return this.isDefining == null ? new Base[0] : new Base[] {this.isDefining}; // BooleanType
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // DataType
        case -1832648218: /*amountRatioHighLimit*/ return this.amountRatioHighLimit == null ? new Base[0] : new Base[] {this.amountRatioHighLimit}; // Ratio
        case -1424857166: /*amountType*/ return this.amountType == null ? new Base[0] : new Base[] {this.amountType}; // CodeableConcept
        case -896505829: /*source*/ return this.source == null ? new Base[0] : this.source.toArray(new Base[this.source.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 718195427: // substanceDefinition
          this.substanceDefinition = TypeConvertor.castToType(value); // DataType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -141812990: // isDefining
          this.isDefining = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToType(value); // DataType
          return value;
        case -1832648218: // amountRatioHighLimit
          this.amountRatioHighLimit = TypeConvertor.castToRatio(value); // Ratio
          return value;
        case -1424857166: // amountType
          this.amountType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -896505829: // source
          this.getSource().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("substanceDefinition[x]")) {
          this.substanceDefinition = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("isDefining")) {
          this.isDefining = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("amount[x]")) {
          this.amount = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("amountRatioHighLimit")) {
          this.amountRatioHighLimit = TypeConvertor.castToRatio(value); // Ratio
        } else if (name.equals("amountType")) {
          this.amountType = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("source")) {
          this.getSource().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1767011651:  return getSubstanceDefinition();
        case 718195427:  return getSubstanceDefinition();
        case 3575610:  return getType();
        case -141812990:  return getIsDefiningElement();
        case 646780200:  return getAmount();
        case -1413853096:  return getAmount();
        case -1832648218:  return getAmountRatioHighLimit();
        case -1424857166:  return getAmountType();
        case -896505829:  return addSource(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 718195427: /*substanceDefinition*/ return new String[] {"Reference", "CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -141812990: /*isDefining*/ return new String[] {"boolean"};
        case -1413853096: /*amount*/ return new String[] {"Quantity", "Range", "Ratio", "string"};
        case -1832648218: /*amountRatioHighLimit*/ return new String[] {"Ratio"};
        case -1424857166: /*amountType*/ return new String[] {"CodeableConcept"};
        case -896505829: /*source*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("substanceDefinitionReference")) {
          this.substanceDefinition = new Reference();
          return this.substanceDefinition;
        }
        else if (name.equals("substanceDefinitionCodeableConcept")) {
          this.substanceDefinition = new CodeableConcept();
          return this.substanceDefinition;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("isDefining")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.relationship.isDefining");
        }
        else if (name.equals("amountQuantity")) {
          this.amount = new Quantity();
          return this.amount;
        }
        else if (name.equals("amountRange")) {
          this.amount = new Range();
          return this.amount;
        }
        else if (name.equals("amountRatio")) {
          this.amount = new Ratio();
          return this.amount;
        }
        else if (name.equals("amountString")) {
          this.amount = new StringType();
          return this.amount;
        }
        else if (name.equals("amountRatioHighLimit")) {
          this.amountRatioHighLimit = new Ratio();
          return this.amountRatioHighLimit;
        }
        else if (name.equals("amountType")) {
          this.amountType = new CodeableConcept();
          return this.amountType;
        }
        else if (name.equals("source")) {
          return addSource();
        }
        else
          return super.addChild(name);
      }

      public SubstanceDefinitionRelationshipComponent copy() {
        SubstanceDefinitionRelationshipComponent dst = new SubstanceDefinitionRelationshipComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinitionRelationshipComponent dst) {
        super.copyValues(dst);
        dst.substanceDefinition = substanceDefinition == null ? null : substanceDefinition.copy();
        dst.type = type == null ? null : type.copy();
        dst.isDefining = isDefining == null ? null : isDefining.copy();
        dst.amount = amount == null ? null : amount.copy();
        dst.amountRatioHighLimit = amountRatioHighLimit == null ? null : amountRatioHighLimit.copy();
        dst.amountType = amountType == null ? null : amountType.copy();
        if (source != null) {
          dst.source = new ArrayList<Reference>();
          for (Reference i : source)
            dst.source.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionRelationshipComponent))
          return false;
        SubstanceDefinitionRelationshipComponent o = (SubstanceDefinitionRelationshipComponent) other_;
        return compareDeep(substanceDefinition, o.substanceDefinition, true) && compareDeep(type, o.type, true)
           && compareDeep(isDefining, o.isDefining, true) && compareDeep(amount, o.amount, true) && compareDeep(amountRatioHighLimit, o.amountRatioHighLimit, true)
           && compareDeep(amountType, o.amountType, true) && compareDeep(source, o.source, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinitionRelationshipComponent))
          return false;
        SubstanceDefinitionRelationshipComponent o = (SubstanceDefinitionRelationshipComponent) other_;
        return compareValues(isDefining, o.isDefining, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(substanceDefinition, type
          , isDefining, amount, amountRatioHighLimit, amountType, source);
      }

  public String fhirType() {
    return "SubstanceDefinition.relationship";

  }

  }

    /**
     * Identifier by which this substance is known.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Identifier by which this substance is known", formalDefinition="Identifier by which this substance is known." )
    protected Identifier identifier;

    /**
     * A business level identifier of the substance.
     */
    @Child(name = "version", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="A business level identifier of the substance", formalDefinition="A business level identifier of the substance." )
    protected StringType version;

    /**
     * Status of substance within the catalogue e.g. approved.
     */
    @Child(name = "status", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Status of substance within the catalogue e.g. approved", formalDefinition="Status of substance within the catalogue e.g. approved." )
    protected CodeableConcept status;

    /**
     * High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological.
     */
    @Child(name = "category", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological", formalDefinition="High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological." )
    protected CodeableConcept category;

    /**
     * If the substance applies to only human or veterinary use.
     */
    @Child(name = "domain", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="If the substance applies to only human or veterinary use", formalDefinition="If the substance applies to only human or veterinary use." )
    protected CodeableConcept domain;

    /**
     * Textual description of the substance.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Textual description of the substance", formalDefinition="Textual description of the substance." )
    protected MarkdownType description;

    /**
     * Supporting literature.
     */
    @Child(name = "source", type = {DocumentReference.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Supporting literature", formalDefinition="Supporting literature." )
    protected List<Reference> source;

    /**
     * Textual comment about this record of a substance.
     */
    @Child(name = "note", type = {Annotation.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Textual comment about this record of a substance", formalDefinition="Textual comment about this record of a substance." )
    protected List<Annotation> note;

    /**
     * A company that makes this substance.
     */
    @Child(name = "manufacturer", type = {Organization.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A company that makes this substance", formalDefinition="A company that makes this substance." )
    protected List<Reference> manufacturer;

    /**
     * A company that supplies this substance.
     */
    @Child(name = "supplier", type = {Organization.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A company that supplies this substance", formalDefinition="A company that supplies this substance." )
    protected List<Reference> supplier;

    /**
     * Moiety, for structural modifications.
     */
    @Child(name = "moiety", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Moiety, for structural modifications", formalDefinition="Moiety, for structural modifications." )
    protected List<SubstanceDefinitionMoietyComponent> moiety;

    /**
     * General specifications for this substance, including how it is related to other substances.
     */
    @Child(name = "property", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="General specifications for this substance, including how it is related to other substances", formalDefinition="General specifications for this substance, including how it is related to other substances." )
    protected List<SubstanceDefinitionPropertyComponent> property;

    /**
     * General information detailing this substance.
     */
    @Child(name = "referenceInformation", type = {SubstanceReferenceInformation.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="General information detailing this substance", formalDefinition="General information detailing this substance." )
    protected Reference referenceInformation;

    /**
     * Structural information.
     */
    @Child(name = "structure", type = {}, order=13, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Structural information", formalDefinition="Structural information." )
    protected SubstanceDefinitionStructureComponent structure;

    /**
     * Codes associated with the substance.
     */
    @Child(name = "code", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Codes associated with the substance", formalDefinition="Codes associated with the substance." )
    protected List<SubstanceDefinitionCodeComponent> code;

    /**
     * Names applicable to this substance.
     */
    @Child(name = "name", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Names applicable to this substance", formalDefinition="Names applicable to this substance." )
    protected List<SubstanceDefinitionNameComponent> name;

    /**
     * The molecular weight or weight range (for proteins, polymers or nucleic acids).
     */
    @Child(name = "molecularWeight", type = {SubstanceDefinitionStructureIsotopeMolecularWeightComponent.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The molecular weight or weight range (for proteins, polymers or nucleic acids)", formalDefinition="The molecular weight or weight range (for proteins, polymers or nucleic acids)." )
    protected List<SubstanceDefinitionStructureIsotopeMolecularWeightComponent> molecularWeight;

    /**
     * A link between this substance and another, with details of the relationship.
     */
    @Child(name = "relationship", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A link between this substance and another, with details of the relationship", formalDefinition="A link between this substance and another, with details of the relationship." )
    protected List<SubstanceDefinitionRelationshipComponent> relationship;

    /**
     * Data items specific to nucleic acids.
     */
    @Child(name = "nucleicAcid", type = {SubstanceNucleicAcid.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Data items specific to nucleic acids", formalDefinition="Data items specific to nucleic acids." )
    protected Reference nucleicAcid;

    /**
     * Data items specific to polymers.
     */
    @Child(name = "polymer", type = {SubstancePolymer.class}, order=19, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Data items specific to polymers", formalDefinition="Data items specific to polymers." )
    protected Reference polymer;

    /**
     * Data items specific to proteins.
     */
    @Child(name = "protein", type = {SubstanceProtein.class}, order=20, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Data items specific to proteins", formalDefinition="Data items specific to proteins." )
    protected Reference protein;

    /**
     * Material or taxonomic/anatomical source for the substance.
     */
    @Child(name = "sourceMaterial", type = {SubstanceSourceMaterial.class}, order=21, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Material or taxonomic/anatomical source for the substance", formalDefinition="Material or taxonomic/anatomical source for the substance." )
    protected Reference sourceMaterial;

    private static final long serialVersionUID = 63520388L;

  /**
   * Constructor
   */
    public SubstanceDefinition() {
      super();
    }

    /**
     * @return {@link #identifier} (Identifier by which this substance is known.)
     */
    public Identifier getIdentifier() { 
      if (this.identifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.identifier");
        else if (Configuration.doAutoCreate())
          this.identifier = new Identifier(); // cc
      return this.identifier;
    }

    public boolean hasIdentifier() { 
      return this.identifier != null && !this.identifier.isEmpty();
    }

    /**
     * @param value {@link #identifier} (Identifier by which this substance is known.)
     */
    public SubstanceDefinition setIdentifier(Identifier value) { 
      this.identifier = value;
      return this;
    }

    /**
     * @return {@link #version} (A business level identifier of the substance.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.version");
        else if (Configuration.doAutoCreate())
          this.version = new StringType(); // bb
      return this.version;
    }

    public boolean hasVersionElement() { 
      return this.version != null && !this.version.isEmpty();
    }

    public boolean hasVersion() { 
      return this.version != null && !this.version.isEmpty();
    }

    /**
     * @param value {@link #version} (A business level identifier of the substance.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public SubstanceDefinition setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return A business level identifier of the substance.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value A business level identifier of the substance.
     */
    public SubstanceDefinition setVersion(String value) { 
      if (Utilities.noString(value))
        this.version = null;
      else {
        if (this.version == null)
          this.version = new StringType();
        this.version.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (Status of substance within the catalogue e.g. approved.)
     */
    public CodeableConcept getStatus() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.status");
        else if (Configuration.doAutoCreate())
          this.status = new CodeableConcept(); // cc
      return this.status;
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (Status of substance within the catalogue e.g. approved.)
     */
    public SubstanceDefinition setStatus(CodeableConcept value) { 
      this.status = value;
      return this;
    }

    /**
     * @return {@link #category} (High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological.)
     */
    public CodeableConcept getCategory() { 
      if (this.category == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.category");
        else if (Configuration.doAutoCreate())
          this.category = new CodeableConcept(); // cc
      return this.category;
    }

    public boolean hasCategory() { 
      return this.category != null && !this.category.isEmpty();
    }

    /**
     * @param value {@link #category} (High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological.)
     */
    public SubstanceDefinition setCategory(CodeableConcept value) { 
      this.category = value;
      return this;
    }

    /**
     * @return {@link #domain} (If the substance applies to only human or veterinary use.)
     */
    public CodeableConcept getDomain() { 
      if (this.domain == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.domain");
        else if (Configuration.doAutoCreate())
          this.domain = new CodeableConcept(); // cc
      return this.domain;
    }

    public boolean hasDomain() { 
      return this.domain != null && !this.domain.isEmpty();
    }

    /**
     * @param value {@link #domain} (If the substance applies to only human or veterinary use.)
     */
    public SubstanceDefinition setDomain(CodeableConcept value) { 
      this.domain = value;
      return this;
    }

    /**
     * @return {@link #description} (Textual description of the substance.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.description");
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
     * @param value {@link #description} (Textual description of the substance.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public SubstanceDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return Textual description of the substance.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value Textual description of the substance.
     */
    public SubstanceDefinition setDescription(String value) { 
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
     * @return {@link #source} (Supporting literature.)
     */
    public List<Reference> getSource() { 
      if (this.source == null)
        this.source = new ArrayList<Reference>();
      return this.source;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setSource(List<Reference> theSource) { 
      this.source = theSource;
      return this;
    }

    public boolean hasSource() { 
      if (this.source == null)
        return false;
      for (Reference item : this.source)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSource() { //3
      Reference t = new Reference();
      if (this.source == null)
        this.source = new ArrayList<Reference>();
      this.source.add(t);
      return t;
    }

    public SubstanceDefinition addSource(Reference t) { //3
      if (t == null)
        return this;
      if (this.source == null)
        this.source = new ArrayList<Reference>();
      this.source.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #source}, creating it if it does not already exist {3}
     */
    public Reference getSourceFirstRep() { 
      if (getSource().isEmpty()) {
        addSource();
      }
      return getSource().get(0);
    }

    /**
     * @return {@link #note} (Textual comment about this record of a substance.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setNote(List<Annotation> theNote) { 
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

    public SubstanceDefinition addNote(Annotation t) { //3
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
     * @return {@link #manufacturer} (A company that makes this substance.)
     */
    public List<Reference> getManufacturer() { 
      if (this.manufacturer == null)
        this.manufacturer = new ArrayList<Reference>();
      return this.manufacturer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setManufacturer(List<Reference> theManufacturer) { 
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

    public SubstanceDefinition addManufacturer(Reference t) { //3
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
     * @return {@link #supplier} (A company that supplies this substance.)
     */
    public List<Reference> getSupplier() { 
      if (this.supplier == null)
        this.supplier = new ArrayList<Reference>();
      return this.supplier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setSupplier(List<Reference> theSupplier) { 
      this.supplier = theSupplier;
      return this;
    }

    public boolean hasSupplier() { 
      if (this.supplier == null)
        return false;
      for (Reference item : this.supplier)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addSupplier() { //3
      Reference t = new Reference();
      if (this.supplier == null)
        this.supplier = new ArrayList<Reference>();
      this.supplier.add(t);
      return t;
    }

    public SubstanceDefinition addSupplier(Reference t) { //3
      if (t == null)
        return this;
      if (this.supplier == null)
        this.supplier = new ArrayList<Reference>();
      this.supplier.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #supplier}, creating it if it does not already exist {3}
     */
    public Reference getSupplierFirstRep() { 
      if (getSupplier().isEmpty()) {
        addSupplier();
      }
      return getSupplier().get(0);
    }

    /**
     * @return {@link #moiety} (Moiety, for structural modifications.)
     */
    public List<SubstanceDefinitionMoietyComponent> getMoiety() { 
      if (this.moiety == null)
        this.moiety = new ArrayList<SubstanceDefinitionMoietyComponent>();
      return this.moiety;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setMoiety(List<SubstanceDefinitionMoietyComponent> theMoiety) { 
      this.moiety = theMoiety;
      return this;
    }

    public boolean hasMoiety() { 
      if (this.moiety == null)
        return false;
      for (SubstanceDefinitionMoietyComponent item : this.moiety)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubstanceDefinitionMoietyComponent addMoiety() { //3
      SubstanceDefinitionMoietyComponent t = new SubstanceDefinitionMoietyComponent();
      if (this.moiety == null)
        this.moiety = new ArrayList<SubstanceDefinitionMoietyComponent>();
      this.moiety.add(t);
      return t;
    }

    public SubstanceDefinition addMoiety(SubstanceDefinitionMoietyComponent t) { //3
      if (t == null)
        return this;
      if (this.moiety == null)
        this.moiety = new ArrayList<SubstanceDefinitionMoietyComponent>();
      this.moiety.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #moiety}, creating it if it does not already exist {3}
     */
    public SubstanceDefinitionMoietyComponent getMoietyFirstRep() { 
      if (getMoiety().isEmpty()) {
        addMoiety();
      }
      return getMoiety().get(0);
    }

    /**
     * @return {@link #property} (General specifications for this substance, including how it is related to other substances.)
     */
    public List<SubstanceDefinitionPropertyComponent> getProperty() { 
      if (this.property == null)
        this.property = new ArrayList<SubstanceDefinitionPropertyComponent>();
      return this.property;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setProperty(List<SubstanceDefinitionPropertyComponent> theProperty) { 
      this.property = theProperty;
      return this;
    }

    public boolean hasProperty() { 
      if (this.property == null)
        return false;
      for (SubstanceDefinitionPropertyComponent item : this.property)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubstanceDefinitionPropertyComponent addProperty() { //3
      SubstanceDefinitionPropertyComponent t = new SubstanceDefinitionPropertyComponent();
      if (this.property == null)
        this.property = new ArrayList<SubstanceDefinitionPropertyComponent>();
      this.property.add(t);
      return t;
    }

    public SubstanceDefinition addProperty(SubstanceDefinitionPropertyComponent t) { //3
      if (t == null)
        return this;
      if (this.property == null)
        this.property = new ArrayList<SubstanceDefinitionPropertyComponent>();
      this.property.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #property}, creating it if it does not already exist {3}
     */
    public SubstanceDefinitionPropertyComponent getPropertyFirstRep() { 
      if (getProperty().isEmpty()) {
        addProperty();
      }
      return getProperty().get(0);
    }

    /**
     * @return {@link #referenceInformation} (General information detailing this substance.)
     */
    public Reference getReferenceInformation() { 
      if (this.referenceInformation == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.referenceInformation");
        else if (Configuration.doAutoCreate())
          this.referenceInformation = new Reference(); // cc
      return this.referenceInformation;
    }

    public boolean hasReferenceInformation() { 
      return this.referenceInformation != null && !this.referenceInformation.isEmpty();
    }

    /**
     * @param value {@link #referenceInformation} (General information detailing this substance.)
     */
    public SubstanceDefinition setReferenceInformation(Reference value) { 
      this.referenceInformation = value;
      return this;
    }

    /**
     * @return {@link #structure} (Structural information.)
     */
    public SubstanceDefinitionStructureComponent getStructure() { 
      if (this.structure == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.structure");
        else if (Configuration.doAutoCreate())
          this.structure = new SubstanceDefinitionStructureComponent(); // cc
      return this.structure;
    }

    public boolean hasStructure() { 
      return this.structure != null && !this.structure.isEmpty();
    }

    /**
     * @param value {@link #structure} (Structural information.)
     */
    public SubstanceDefinition setStructure(SubstanceDefinitionStructureComponent value) { 
      this.structure = value;
      return this;
    }

    /**
     * @return {@link #code} (Codes associated with the substance.)
     */
    public List<SubstanceDefinitionCodeComponent> getCode() { 
      if (this.code == null)
        this.code = new ArrayList<SubstanceDefinitionCodeComponent>();
      return this.code;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setCode(List<SubstanceDefinitionCodeComponent> theCode) { 
      this.code = theCode;
      return this;
    }

    public boolean hasCode() { 
      if (this.code == null)
        return false;
      for (SubstanceDefinitionCodeComponent item : this.code)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubstanceDefinitionCodeComponent addCode() { //3
      SubstanceDefinitionCodeComponent t = new SubstanceDefinitionCodeComponent();
      if (this.code == null)
        this.code = new ArrayList<SubstanceDefinitionCodeComponent>();
      this.code.add(t);
      return t;
    }

    public SubstanceDefinition addCode(SubstanceDefinitionCodeComponent t) { //3
      if (t == null)
        return this;
      if (this.code == null)
        this.code = new ArrayList<SubstanceDefinitionCodeComponent>();
      this.code.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #code}, creating it if it does not already exist {3}
     */
    public SubstanceDefinitionCodeComponent getCodeFirstRep() { 
      if (getCode().isEmpty()) {
        addCode();
      }
      return getCode().get(0);
    }

    /**
     * @return {@link #name} (Names applicable to this substance.)
     */
    public List<SubstanceDefinitionNameComponent> getName() { 
      if (this.name == null)
        this.name = new ArrayList<SubstanceDefinitionNameComponent>();
      return this.name;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setName(List<SubstanceDefinitionNameComponent> theName) { 
      this.name = theName;
      return this;
    }

    public boolean hasName() { 
      if (this.name == null)
        return false;
      for (SubstanceDefinitionNameComponent item : this.name)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubstanceDefinitionNameComponent addName() { //3
      SubstanceDefinitionNameComponent t = new SubstanceDefinitionNameComponent();
      if (this.name == null)
        this.name = new ArrayList<SubstanceDefinitionNameComponent>();
      this.name.add(t);
      return t;
    }

    public SubstanceDefinition addName(SubstanceDefinitionNameComponent t) { //3
      if (t == null)
        return this;
      if (this.name == null)
        this.name = new ArrayList<SubstanceDefinitionNameComponent>();
      this.name.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #name}, creating it if it does not already exist {3}
     */
    public SubstanceDefinitionNameComponent getNameFirstRep() { 
      if (getName().isEmpty()) {
        addName();
      }
      return getName().get(0);
    }

    /**
     * @return {@link #molecularWeight} (The molecular weight or weight range (for proteins, polymers or nucleic acids).)
     */
    public List<SubstanceDefinitionStructureIsotopeMolecularWeightComponent> getMolecularWeight() { 
      if (this.molecularWeight == null)
        this.molecularWeight = new ArrayList<SubstanceDefinitionStructureIsotopeMolecularWeightComponent>();
      return this.molecularWeight;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setMolecularWeight(List<SubstanceDefinitionStructureIsotopeMolecularWeightComponent> theMolecularWeight) { 
      this.molecularWeight = theMolecularWeight;
      return this;
    }

    public boolean hasMolecularWeight() { 
      if (this.molecularWeight == null)
        return false;
      for (SubstanceDefinitionStructureIsotopeMolecularWeightComponent item : this.molecularWeight)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubstanceDefinitionStructureIsotopeMolecularWeightComponent addMolecularWeight() { //3
      SubstanceDefinitionStructureIsotopeMolecularWeightComponent t = new SubstanceDefinitionStructureIsotopeMolecularWeightComponent();
      if (this.molecularWeight == null)
        this.molecularWeight = new ArrayList<SubstanceDefinitionStructureIsotopeMolecularWeightComponent>();
      this.molecularWeight.add(t);
      return t;
    }

    public SubstanceDefinition addMolecularWeight(SubstanceDefinitionStructureIsotopeMolecularWeightComponent t) { //3
      if (t == null)
        return this;
      if (this.molecularWeight == null)
        this.molecularWeight = new ArrayList<SubstanceDefinitionStructureIsotopeMolecularWeightComponent>();
      this.molecularWeight.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #molecularWeight}, creating it if it does not already exist {3}
     */
    public SubstanceDefinitionStructureIsotopeMolecularWeightComponent getMolecularWeightFirstRep() { 
      if (getMolecularWeight().isEmpty()) {
        addMolecularWeight();
      }
      return getMolecularWeight().get(0);
    }

    /**
     * @return {@link #relationship} (A link between this substance and another, with details of the relationship.)
     */
    public List<SubstanceDefinitionRelationshipComponent> getRelationship() { 
      if (this.relationship == null)
        this.relationship = new ArrayList<SubstanceDefinitionRelationshipComponent>();
      return this.relationship;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SubstanceDefinition setRelationship(List<SubstanceDefinitionRelationshipComponent> theRelationship) { 
      this.relationship = theRelationship;
      return this;
    }

    public boolean hasRelationship() { 
      if (this.relationship == null)
        return false;
      for (SubstanceDefinitionRelationshipComponent item : this.relationship)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SubstanceDefinitionRelationshipComponent addRelationship() { //3
      SubstanceDefinitionRelationshipComponent t = new SubstanceDefinitionRelationshipComponent();
      if (this.relationship == null)
        this.relationship = new ArrayList<SubstanceDefinitionRelationshipComponent>();
      this.relationship.add(t);
      return t;
    }

    public SubstanceDefinition addRelationship(SubstanceDefinitionRelationshipComponent t) { //3
      if (t == null)
        return this;
      if (this.relationship == null)
        this.relationship = new ArrayList<SubstanceDefinitionRelationshipComponent>();
      this.relationship.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relationship}, creating it if it does not already exist {3}
     */
    public SubstanceDefinitionRelationshipComponent getRelationshipFirstRep() { 
      if (getRelationship().isEmpty()) {
        addRelationship();
      }
      return getRelationship().get(0);
    }

    /**
     * @return {@link #nucleicAcid} (Data items specific to nucleic acids.)
     */
    public Reference getNucleicAcid() { 
      if (this.nucleicAcid == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.nucleicAcid");
        else if (Configuration.doAutoCreate())
          this.nucleicAcid = new Reference(); // cc
      return this.nucleicAcid;
    }

    public boolean hasNucleicAcid() { 
      return this.nucleicAcid != null && !this.nucleicAcid.isEmpty();
    }

    /**
     * @param value {@link #nucleicAcid} (Data items specific to nucleic acids.)
     */
    public SubstanceDefinition setNucleicAcid(Reference value) { 
      this.nucleicAcid = value;
      return this;
    }

    /**
     * @return {@link #polymer} (Data items specific to polymers.)
     */
    public Reference getPolymer() { 
      if (this.polymer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.polymer");
        else if (Configuration.doAutoCreate())
          this.polymer = new Reference(); // cc
      return this.polymer;
    }

    public boolean hasPolymer() { 
      return this.polymer != null && !this.polymer.isEmpty();
    }

    /**
     * @param value {@link #polymer} (Data items specific to polymers.)
     */
    public SubstanceDefinition setPolymer(Reference value) { 
      this.polymer = value;
      return this;
    }

    /**
     * @return {@link #protein} (Data items specific to proteins.)
     */
    public Reference getProtein() { 
      if (this.protein == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.protein");
        else if (Configuration.doAutoCreate())
          this.protein = new Reference(); // cc
      return this.protein;
    }

    public boolean hasProtein() { 
      return this.protein != null && !this.protein.isEmpty();
    }

    /**
     * @param value {@link #protein} (Data items specific to proteins.)
     */
    public SubstanceDefinition setProtein(Reference value) { 
      this.protein = value;
      return this;
    }

    /**
     * @return {@link #sourceMaterial} (Material or taxonomic/anatomical source for the substance.)
     */
    public Reference getSourceMaterial() { 
      if (this.sourceMaterial == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SubstanceDefinition.sourceMaterial");
        else if (Configuration.doAutoCreate())
          this.sourceMaterial = new Reference(); // cc
      return this.sourceMaterial;
    }

    public boolean hasSourceMaterial() { 
      return this.sourceMaterial != null && !this.sourceMaterial.isEmpty();
    }

    /**
     * @param value {@link #sourceMaterial} (Material or taxonomic/anatomical source for the substance.)
     */
    public SubstanceDefinition setSourceMaterial(Reference value) { 
      this.sourceMaterial = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Identifier by which this substance is known.", 0, 1, identifier));
        children.add(new Property("version", "string", "A business level identifier of the substance.", 0, 1, version));
        children.add(new Property("status", "CodeableConcept", "Status of substance within the catalogue e.g. approved.", 0, 1, status));
        children.add(new Property("category", "CodeableConcept", "High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological.", 0, 1, category));
        children.add(new Property("domain", "CodeableConcept", "If the substance applies to only human or veterinary use.", 0, 1, domain));
        children.add(new Property("description", "markdown", "Textual description of the substance.", 0, 1, description));
        children.add(new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source));
        children.add(new Property("note", "Annotation", "Textual comment about this record of a substance.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("manufacturer", "Reference(Organization)", "A company that makes this substance.", 0, java.lang.Integer.MAX_VALUE, manufacturer));
        children.add(new Property("supplier", "Reference(Organization)", "A company that supplies this substance.", 0, java.lang.Integer.MAX_VALUE, supplier));
        children.add(new Property("moiety", "", "Moiety, for structural modifications.", 0, java.lang.Integer.MAX_VALUE, moiety));
        children.add(new Property("property", "", "General specifications for this substance, including how it is related to other substances.", 0, java.lang.Integer.MAX_VALUE, property));
        children.add(new Property("referenceInformation", "Reference(SubstanceReferenceInformation)", "General information detailing this substance.", 0, 1, referenceInformation));
        children.add(new Property("structure", "", "Structural information.", 0, 1, structure));
        children.add(new Property("code", "", "Codes associated with the substance.", 0, java.lang.Integer.MAX_VALUE, code));
        children.add(new Property("name", "", "Names applicable to this substance.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("molecularWeight", "@SubstanceDefinition.structure.isotope.molecularWeight", "The molecular weight or weight range (for proteins, polymers or nucleic acids).", 0, java.lang.Integer.MAX_VALUE, molecularWeight));
        children.add(new Property("relationship", "", "A link between this substance and another, with details of the relationship.", 0, java.lang.Integer.MAX_VALUE, relationship));
        children.add(new Property("nucleicAcid", "Reference(SubstanceNucleicAcid)", "Data items specific to nucleic acids.", 0, 1, nucleicAcid));
        children.add(new Property("polymer", "Reference(SubstancePolymer)", "Data items specific to polymers.", 0, 1, polymer));
        children.add(new Property("protein", "Reference(SubstanceProtein)", "Data items specific to proteins.", 0, 1, protein));
        children.add(new Property("sourceMaterial", "Reference(SubstanceSourceMaterial)", "Material or taxonomic/anatomical source for the substance.", 0, 1, sourceMaterial));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Identifier by which this substance is known.", 0, 1, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "A business level identifier of the substance.", 0, 1, version);
        case -892481550: /*status*/  return new Property("status", "CodeableConcept", "Status of substance within the catalogue e.g. approved.", 0, 1, status);
        case 50511102: /*category*/  return new Property("category", "CodeableConcept", "High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological.", 0, 1, category);
        case -1326197564: /*domain*/  return new Property("domain", "CodeableConcept", "If the substance applies to only human or veterinary use.", 0, 1, domain);
        case -1724546052: /*description*/  return new Property("description", "markdown", "Textual description of the substance.", 0, 1, description);
        case -896505829: /*source*/  return new Property("source", "Reference(DocumentReference)", "Supporting literature.", 0, java.lang.Integer.MAX_VALUE, source);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Textual comment about this record of a substance.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "A company that makes this substance.", 0, java.lang.Integer.MAX_VALUE, manufacturer);
        case -1663305268: /*supplier*/  return new Property("supplier", "Reference(Organization)", "A company that supplies this substance.", 0, java.lang.Integer.MAX_VALUE, supplier);
        case -1068650173: /*moiety*/  return new Property("moiety", "", "Moiety, for structural modifications.", 0, java.lang.Integer.MAX_VALUE, moiety);
        case -993141291: /*property*/  return new Property("property", "", "General specifications for this substance, including how it is related to other substances.", 0, java.lang.Integer.MAX_VALUE, property);
        case -2117930783: /*referenceInformation*/  return new Property("referenceInformation", "Reference(SubstanceReferenceInformation)", "General information detailing this substance.", 0, 1, referenceInformation);
        case 144518515: /*structure*/  return new Property("structure", "", "Structural information.", 0, 1, structure);
        case 3059181: /*code*/  return new Property("code", "", "Codes associated with the substance.", 0, java.lang.Integer.MAX_VALUE, code);
        case 3373707: /*name*/  return new Property("name", "", "Names applicable to this substance.", 0, java.lang.Integer.MAX_VALUE, name);
        case 635625672: /*molecularWeight*/  return new Property("molecularWeight", "@SubstanceDefinition.structure.isotope.molecularWeight", "The molecular weight or weight range (for proteins, polymers or nucleic acids).", 0, java.lang.Integer.MAX_VALUE, molecularWeight);
        case -261851592: /*relationship*/  return new Property("relationship", "", "A link between this substance and another, with details of the relationship.", 0, java.lang.Integer.MAX_VALUE, relationship);
        case 1625275180: /*nucleicAcid*/  return new Property("nucleicAcid", "Reference(SubstanceNucleicAcid)", "Data items specific to nucleic acids.", 0, 1, nucleicAcid);
        case -397514098: /*polymer*/  return new Property("polymer", "Reference(SubstancePolymer)", "Data items specific to polymers.", 0, 1, polymer);
        case -309012605: /*protein*/  return new Property("protein", "Reference(SubstanceProtein)", "Data items specific to proteins.", 0, 1, protein);
        case -1064442270: /*sourceMaterial*/  return new Property("sourceMaterial", "Reference(SubstanceSourceMaterial)", "Material or taxonomic/anatomical source for the substance.", 0, 1, sourceMaterial);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // CodeableConcept
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case -1326197564: /*domain*/ return this.domain == null ? new Base[0] : new Base[] {this.domain}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -896505829: /*source*/ return this.source == null ? new Base[0] : this.source.toArray(new Base[this.source.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : this.manufacturer.toArray(new Base[this.manufacturer.size()]); // Reference
        case -1663305268: /*supplier*/ return this.supplier == null ? new Base[0] : this.supplier.toArray(new Base[this.supplier.size()]); // Reference
        case -1068650173: /*moiety*/ return this.moiety == null ? new Base[0] : this.moiety.toArray(new Base[this.moiety.size()]); // SubstanceDefinitionMoietyComponent
        case -993141291: /*property*/ return this.property == null ? new Base[0] : this.property.toArray(new Base[this.property.size()]); // SubstanceDefinitionPropertyComponent
        case -2117930783: /*referenceInformation*/ return this.referenceInformation == null ? new Base[0] : new Base[] {this.referenceInformation}; // Reference
        case 144518515: /*structure*/ return this.structure == null ? new Base[0] : new Base[] {this.structure}; // SubstanceDefinitionStructureComponent
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // SubstanceDefinitionCodeComponent
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // SubstanceDefinitionNameComponent
        case 635625672: /*molecularWeight*/ return this.molecularWeight == null ? new Base[0] : this.molecularWeight.toArray(new Base[this.molecularWeight.size()]); // SubstanceDefinitionStructureIsotopeMolecularWeightComponent
        case -261851592: /*relationship*/ return this.relationship == null ? new Base[0] : this.relationship.toArray(new Base[this.relationship.size()]); // SubstanceDefinitionRelationshipComponent
        case 1625275180: /*nucleicAcid*/ return this.nucleicAcid == null ? new Base[0] : new Base[] {this.nucleicAcid}; // Reference
        case -397514098: /*polymer*/ return this.polymer == null ? new Base[0] : new Base[] {this.polymer}; // Reference
        case -309012605: /*protein*/ return this.protein == null ? new Base[0] : new Base[] {this.protein}; // Reference
        case -1064442270: /*sourceMaterial*/ return this.sourceMaterial == null ? new Base[0] : new Base[] {this.sourceMaterial}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 50511102: // category
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1326197564: // domain
          this.domain = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -896505829: // source
          this.getSource().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1969347631: // manufacturer
          this.getManufacturer().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1663305268: // supplier
          this.getSupplier().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1068650173: // moiety
          this.getMoiety().add((SubstanceDefinitionMoietyComponent) value); // SubstanceDefinitionMoietyComponent
          return value;
        case -993141291: // property
          this.getProperty().add((SubstanceDefinitionPropertyComponent) value); // SubstanceDefinitionPropertyComponent
          return value;
        case -2117930783: // referenceInformation
          this.referenceInformation = TypeConvertor.castToReference(value); // Reference
          return value;
        case 144518515: // structure
          this.structure = (SubstanceDefinitionStructureComponent) value; // SubstanceDefinitionStructureComponent
          return value;
        case 3059181: // code
          this.getCode().add((SubstanceDefinitionCodeComponent) value); // SubstanceDefinitionCodeComponent
          return value;
        case 3373707: // name
          this.getName().add((SubstanceDefinitionNameComponent) value); // SubstanceDefinitionNameComponent
          return value;
        case 635625672: // molecularWeight
          this.getMolecularWeight().add((SubstanceDefinitionStructureIsotopeMolecularWeightComponent) value); // SubstanceDefinitionStructureIsotopeMolecularWeightComponent
          return value;
        case -261851592: // relationship
          this.getRelationship().add((SubstanceDefinitionRelationshipComponent) value); // SubstanceDefinitionRelationshipComponent
          return value;
        case 1625275180: // nucleicAcid
          this.nucleicAcid = TypeConvertor.castToReference(value); // Reference
          return value;
        case -397514098: // polymer
          this.polymer = TypeConvertor.castToReference(value); // Reference
          return value;
        case -309012605: // protein
          this.protein = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1064442270: // sourceMaterial
          this.sourceMaterial = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          this.status = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("domain")) {
          this.domain = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("source")) {
          this.getSource().add(TypeConvertor.castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("manufacturer")) {
          this.getManufacturer().add(TypeConvertor.castToReference(value));
        } else if (name.equals("supplier")) {
          this.getSupplier().add(TypeConvertor.castToReference(value));
        } else if (name.equals("moiety")) {
          this.getMoiety().add((SubstanceDefinitionMoietyComponent) value);
        } else if (name.equals("property")) {
          this.getProperty().add((SubstanceDefinitionPropertyComponent) value);
        } else if (name.equals("referenceInformation")) {
          this.referenceInformation = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("structure")) {
          this.structure = (SubstanceDefinitionStructureComponent) value; // SubstanceDefinitionStructureComponent
        } else if (name.equals("code")) {
          this.getCode().add((SubstanceDefinitionCodeComponent) value);
        } else if (name.equals("name")) {
          this.getName().add((SubstanceDefinitionNameComponent) value);
        } else if (name.equals("molecularWeight")) {
          this.getMolecularWeight().add((SubstanceDefinitionStructureIsotopeMolecularWeightComponent) value);
        } else if (name.equals("relationship")) {
          this.getRelationship().add((SubstanceDefinitionRelationshipComponent) value);
        } else if (name.equals("nucleicAcid")) {
          this.nucleicAcid = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("polymer")) {
          this.polymer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("protein")) {
          this.protein = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("sourceMaterial")) {
          this.sourceMaterial = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return getIdentifier();
        case 351608024:  return getVersionElement();
        case -892481550:  return getStatus();
        case 50511102:  return getCategory();
        case -1326197564:  return getDomain();
        case -1724546052:  return getDescriptionElement();
        case -896505829:  return addSource(); 
        case 3387378:  return addNote(); 
        case -1969347631:  return addManufacturer(); 
        case -1663305268:  return addSupplier(); 
        case -1068650173:  return addMoiety(); 
        case -993141291:  return addProperty(); 
        case -2117930783:  return getReferenceInformation();
        case 144518515:  return getStructure();
        case 3059181:  return addCode(); 
        case 3373707:  return addName(); 
        case 635625672:  return addMolecularWeight(); 
        case -261851592:  return addRelationship(); 
        case 1625275180:  return getNucleicAcid();
        case -397514098:  return getPolymer();
        case -309012605:  return getProtein();
        case -1064442270:  return getSourceMaterial();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"CodeableConcept"};
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1326197564: /*domain*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -896505829: /*source*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case -1663305268: /*supplier*/ return new String[] {"Reference"};
        case -1068650173: /*moiety*/ return new String[] {};
        case -993141291: /*property*/ return new String[] {};
        case -2117930783: /*referenceInformation*/ return new String[] {"Reference"};
        case 144518515: /*structure*/ return new String[] {};
        case 3059181: /*code*/ return new String[] {};
        case 3373707: /*name*/ return new String[] {};
        case 635625672: /*molecularWeight*/ return new String[] {"@SubstanceDefinition.structure.isotope.molecularWeight"};
        case -261851592: /*relationship*/ return new String[] {};
        case 1625275180: /*nucleicAcid*/ return new String[] {"Reference"};
        case -397514098: /*polymer*/ return new String[] {"Reference"};
        case -309012605: /*protein*/ return new String[] {"Reference"};
        case -1064442270: /*sourceMaterial*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.version");
        }
        else if (name.equals("status")) {
          this.status = new CodeableConcept();
          return this.status;
        }
        else if (name.equals("category")) {
          this.category = new CodeableConcept();
          return this.category;
        }
        else if (name.equals("domain")) {
          this.domain = new CodeableConcept();
          return this.domain;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type SubstanceDefinition.description");
        }
        else if (name.equals("source")) {
          return addSource();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("manufacturer")) {
          return addManufacturer();
        }
        else if (name.equals("supplier")) {
          return addSupplier();
        }
        else if (name.equals("moiety")) {
          return addMoiety();
        }
        else if (name.equals("property")) {
          return addProperty();
        }
        else if (name.equals("referenceInformation")) {
          this.referenceInformation = new Reference();
          return this.referenceInformation;
        }
        else if (name.equals("structure")) {
          this.structure = new SubstanceDefinitionStructureComponent();
          return this.structure;
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("name")) {
          return addName();
        }
        else if (name.equals("molecularWeight")) {
          return addMolecularWeight();
        }
        else if (name.equals("relationship")) {
          return addRelationship();
        }
        else if (name.equals("nucleicAcid")) {
          this.nucleicAcid = new Reference();
          return this.nucleicAcid;
        }
        else if (name.equals("polymer")) {
          this.polymer = new Reference();
          return this.polymer;
        }
        else if (name.equals("protein")) {
          this.protein = new Reference();
          return this.protein;
        }
        else if (name.equals("sourceMaterial")) {
          this.sourceMaterial = new Reference();
          return this.sourceMaterial;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "SubstanceDefinition";

  }

      public SubstanceDefinition copy() {
        SubstanceDefinition dst = new SubstanceDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SubstanceDefinition dst) {
        super.copyValues(dst);
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.version = version == null ? null : version.copy();
        dst.status = status == null ? null : status.copy();
        dst.category = category == null ? null : category.copy();
        dst.domain = domain == null ? null : domain.copy();
        dst.description = description == null ? null : description.copy();
        if (source != null) {
          dst.source = new ArrayList<Reference>();
          for (Reference i : source)
            dst.source.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (manufacturer != null) {
          dst.manufacturer = new ArrayList<Reference>();
          for (Reference i : manufacturer)
            dst.manufacturer.add(i.copy());
        };
        if (supplier != null) {
          dst.supplier = new ArrayList<Reference>();
          for (Reference i : supplier)
            dst.supplier.add(i.copy());
        };
        if (moiety != null) {
          dst.moiety = new ArrayList<SubstanceDefinitionMoietyComponent>();
          for (SubstanceDefinitionMoietyComponent i : moiety)
            dst.moiety.add(i.copy());
        };
        if (property != null) {
          dst.property = new ArrayList<SubstanceDefinitionPropertyComponent>();
          for (SubstanceDefinitionPropertyComponent i : property)
            dst.property.add(i.copy());
        };
        dst.referenceInformation = referenceInformation == null ? null : referenceInformation.copy();
        dst.structure = structure == null ? null : structure.copy();
        if (code != null) {
          dst.code = new ArrayList<SubstanceDefinitionCodeComponent>();
          for (SubstanceDefinitionCodeComponent i : code)
            dst.code.add(i.copy());
        };
        if (name != null) {
          dst.name = new ArrayList<SubstanceDefinitionNameComponent>();
          for (SubstanceDefinitionNameComponent i : name)
            dst.name.add(i.copy());
        };
        if (molecularWeight != null) {
          dst.molecularWeight = new ArrayList<SubstanceDefinitionStructureIsotopeMolecularWeightComponent>();
          for (SubstanceDefinitionStructureIsotopeMolecularWeightComponent i : molecularWeight)
            dst.molecularWeight.add(i.copy());
        };
        if (relationship != null) {
          dst.relationship = new ArrayList<SubstanceDefinitionRelationshipComponent>();
          for (SubstanceDefinitionRelationshipComponent i : relationship)
            dst.relationship.add(i.copy());
        };
        dst.nucleicAcid = nucleicAcid == null ? null : nucleicAcid.copy();
        dst.polymer = polymer == null ? null : polymer.copy();
        dst.protein = protein == null ? null : protein.copy();
        dst.sourceMaterial = sourceMaterial == null ? null : sourceMaterial.copy();
      }

      protected SubstanceDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinition))
          return false;
        SubstanceDefinition o = (SubstanceDefinition) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true) && compareDeep(status, o.status, true)
           && compareDeep(category, o.category, true) && compareDeep(domain, o.domain, true) && compareDeep(description, o.description, true)
           && compareDeep(source, o.source, true) && compareDeep(note, o.note, true) && compareDeep(manufacturer, o.manufacturer, true)
           && compareDeep(supplier, o.supplier, true) && compareDeep(moiety, o.moiety, true) && compareDeep(property, o.property, true)
           && compareDeep(referenceInformation, o.referenceInformation, true) && compareDeep(structure, o.structure, true)
           && compareDeep(code, o.code, true) && compareDeep(name, o.name, true) && compareDeep(molecularWeight, o.molecularWeight, true)
           && compareDeep(relationship, o.relationship, true) && compareDeep(nucleicAcid, o.nucleicAcid, true)
           && compareDeep(polymer, o.polymer, true) && compareDeep(protein, o.protein, true) && compareDeep(sourceMaterial, o.sourceMaterial, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SubstanceDefinition))
          return false;
        SubstanceDefinition o = (SubstanceDefinition) other_;
        return compareValues(version, o.version, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, version, status
          , category, domain, description, source, note, manufacturer, supplier, moiety
          , property, referenceInformation, structure, code, name, molecularWeight, relationship
          , nucleicAcid, polymer, protein, sourceMaterial);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.SubstanceDefinition;
   }

 /**
   * Search parameter: <b>category</b>
   * <p>
   * Description: <b>High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SubstanceDefinition.category</b><br>
   * </p>
   */
  @SearchParamDefinition(name="category", path="SubstanceDefinition.category", description="High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological", type="token" )
  public static final String SP_CATEGORY = "category";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>category</b>
   * <p>
   * Description: <b>High level categorization, e.g. polymer or nucleic acid, or food, chemical, biological</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SubstanceDefinition.category</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CATEGORY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CATEGORY);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>The specific code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SubstanceDefinition.code.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="SubstanceDefinition.code.code", description="The specific code", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>The specific code</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SubstanceDefinition.code.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>domain</b>
   * <p>
   * Description: <b>If the substance applies to only human or veterinary use</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SubstanceDefinition.domain</b><br>
   * </p>
   */
  @SearchParamDefinition(name="domain", path="SubstanceDefinition.domain", description="If the substance applies to only human or veterinary use", type="token" )
  public static final String SP_DOMAIN = "domain";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>domain</b>
   * <p>
   * Description: <b>If the substance applies to only human or veterinary use</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SubstanceDefinition.domain</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DOMAIN = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DOMAIN);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Identifier by which this substance is known</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SubstanceDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="SubstanceDefinition.identifier", description="Identifier by which this substance is known", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Identifier by which this substance is known</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SubstanceDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>The actual name</b><br>
   * Type: <b>string</b><br>
   * Path: <b>SubstanceDefinition.name.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="SubstanceDefinition.name.name", description="The actual name", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>The actual name</b><br>
   * Type: <b>string</b><br>
   * Path: <b>SubstanceDefinition.name.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);


}