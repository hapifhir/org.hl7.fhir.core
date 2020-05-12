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
 * Information about a medication that is used to support knowledge.
 */
@ResourceDef(name="MedicationKnowledge", profile="http://hl7.org/fhir/StructureDefinition/MedicationKnowledge")
public class MedicationKnowledge extends DomainResource {

    public enum MedicationKnowledgeStatusCodes {
        /**
         * The medication is available for use.
         */
        ACTIVE, 
        /**
         * The medication is not available for use.
         */
        INACTIVE, 
        /**
         * The medication was entered in error.
         */
        ENTEREDINERROR, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static MedicationKnowledgeStatusCodes fromCode(String codeString) throws FHIRException {
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
          throw new FHIRException("Unknown MedicationKnowledgeStatusCodes code '"+codeString+"'");
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
            case ACTIVE: return "http://terminology.hl7.org/CodeSystem/medicationknowledge-status";
            case INACTIVE: return "http://terminology.hl7.org/CodeSystem/medicationknowledge-status";
            case ENTEREDINERROR: return "http://terminology.hl7.org/CodeSystem/medicationknowledge-status";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The medication is available for use.";
            case INACTIVE: return "The medication is not available for use.";
            case ENTEREDINERROR: return "The medication was entered in error.";
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

  public static class MedicationKnowledgeStatusCodesEnumFactory implements EnumFactory<MedicationKnowledgeStatusCodes> {
    public MedicationKnowledgeStatusCodes fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return MedicationKnowledgeStatusCodes.ACTIVE;
        if ("inactive".equals(codeString))
          return MedicationKnowledgeStatusCodes.INACTIVE;
        if ("entered-in-error".equals(codeString))
          return MedicationKnowledgeStatusCodes.ENTEREDINERROR;
        throw new IllegalArgumentException("Unknown MedicationKnowledgeStatusCodes code '"+codeString+"'");
        }
        public Enumeration<MedicationKnowledgeStatusCodes> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MedicationKnowledgeStatusCodes>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("active".equals(codeString))
          return new Enumeration<MedicationKnowledgeStatusCodes>(this, MedicationKnowledgeStatusCodes.ACTIVE);
        if ("inactive".equals(codeString))
          return new Enumeration<MedicationKnowledgeStatusCodes>(this, MedicationKnowledgeStatusCodes.INACTIVE);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<MedicationKnowledgeStatusCodes>(this, MedicationKnowledgeStatusCodes.ENTEREDINERROR);
        throw new FHIRException("Unknown MedicationKnowledgeStatusCodes code '"+codeString+"'");
        }
    public String toCode(MedicationKnowledgeStatusCodes code) {
      if (code == MedicationKnowledgeStatusCodes.ACTIVE)
        return "active";
      if (code == MedicationKnowledgeStatusCodes.INACTIVE)
        return "inactive";
      if (code == MedicationKnowledgeStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      return "?";
      }
    public String toSystem(MedicationKnowledgeStatusCodes code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class MedicationKnowledgeRelatedMedicationKnowledgeComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The category of the associated medication knowledge reference.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Category of medicationKnowledge", formalDefinition="The category of the associated medication knowledge reference." )
        protected CodeableConcept type;

        /**
         * Associated documentation about the associated medication knowledge.
         */
        @Child(name = "reference", type = {MedicationKnowledge.class}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Associated documentation about the associated medication knowledge", formalDefinition="Associated documentation about the associated medication knowledge." )
        protected List<Reference> reference;

        private static final long serialVersionUID = 1687147899L;

    /**
     * Constructor
     */
      public MedicationKnowledgeRelatedMedicationKnowledgeComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeRelatedMedicationKnowledgeComponent(CodeableConcept type, Reference reference) {
        super();
        this.setType(type);
        this.addReference(reference);
      }

        /**
         * @return {@link #type} (The category of the associated medication knowledge reference.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeRelatedMedicationKnowledgeComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The category of the associated medication knowledge reference.)
         */
        public MedicationKnowledgeRelatedMedicationKnowledgeComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #reference} (Associated documentation about the associated medication knowledge.)
         */
        public List<Reference> getReference() { 
          if (this.reference == null)
            this.reference = new ArrayList<Reference>();
          return this.reference;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeRelatedMedicationKnowledgeComponent setReference(List<Reference> theReference) { 
          this.reference = theReference;
          return this;
        }

        public boolean hasReference() { 
          if (this.reference == null)
            return false;
          for (Reference item : this.reference)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addReference() { //3
          Reference t = new Reference();
          if (this.reference == null)
            this.reference = new ArrayList<Reference>();
          this.reference.add(t);
          return t;
        }

        public MedicationKnowledgeRelatedMedicationKnowledgeComponent addReference(Reference t) { //3
          if (t == null)
            return this;
          if (this.reference == null)
            this.reference = new ArrayList<Reference>();
          this.reference.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #reference}, creating it if it does not already exist {3}
         */
        public Reference getReferenceFirstRep() { 
          if (getReference().isEmpty()) {
            addReference();
          }
          return getReference().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The category of the associated medication knowledge reference.", 0, 1, type));
          children.add(new Property("reference", "Reference(MedicationKnowledge)", "Associated documentation about the associated medication knowledge.", 0, java.lang.Integer.MAX_VALUE, reference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The category of the associated medication knowledge reference.", 0, 1, type);
          case -925155509: /*reference*/  return new Property("reference", "Reference(MedicationKnowledge)", "Associated documentation about the associated medication knowledge.", 0, java.lang.Integer.MAX_VALUE, reference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : this.reference.toArray(new Base[this.reference.size()]); // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -925155509: // reference
          this.getReference().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reference")) {
          this.getReference().add(TypeConvertor.castToReference(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -925155509:  return addReference(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -925155509: /*reference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("reference")) {
          return addReference();
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeRelatedMedicationKnowledgeComponent copy() {
        MedicationKnowledgeRelatedMedicationKnowledgeComponent dst = new MedicationKnowledgeRelatedMedicationKnowledgeComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeRelatedMedicationKnowledgeComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (reference != null) {
          dst.reference = new ArrayList<Reference>();
          for (Reference i : reference)
            dst.reference.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeRelatedMedicationKnowledgeComponent))
          return false;
        MedicationKnowledgeRelatedMedicationKnowledgeComponent o = (MedicationKnowledgeRelatedMedicationKnowledgeComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(reference, o.reference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeRelatedMedicationKnowledgeComponent))
          return false;
        MedicationKnowledgeRelatedMedicationKnowledgeComponent o = (MedicationKnowledgeRelatedMedicationKnowledgeComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, reference);
      }

  public String fhirType() {
    return "MedicationKnowledge.relatedMedicationKnowledge";

  }

  }

    @Block()
    public static class MedicationKnowledgeMonographComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The category of documentation about the medication. (e.g. professional monograph, patient education monograph).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The category of medication document", formalDefinition="The category of documentation about the medication. (e.g. professional monograph, patient education monograph)." )
        protected CodeableConcept type;

        /**
         * Associated documentation about the medication.
         */
        @Child(name = "source", type = {DocumentReference.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Associated documentation about the medication", formalDefinition="Associated documentation about the medication." )
        protected Reference source;

        private static final long serialVersionUID = -197893751L;

    /**
     * Constructor
     */
      public MedicationKnowledgeMonographComponent() {
        super();
      }

        /**
         * @return {@link #type} (The category of documentation about the medication. (e.g. professional monograph, patient education monograph).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeMonographComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The category of documentation about the medication. (e.g. professional monograph, patient education monograph).)
         */
        public MedicationKnowledgeMonographComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #source} (Associated documentation about the medication.)
         */
        public Reference getSource() { 
          if (this.source == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeMonographComponent.source");
            else if (Configuration.doAutoCreate())
              this.source = new Reference(); // cc
          return this.source;
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (Associated documentation about the medication.)
         */
        public MedicationKnowledgeMonographComponent setSource(Reference value) { 
          this.source = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The category of documentation about the medication. (e.g. professional monograph, patient education monograph).", 0, 1, type));
          children.add(new Property("source", "Reference(DocumentReference)", "Associated documentation about the medication.", 0, 1, source));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The category of documentation about the medication. (e.g. professional monograph, patient education monograph).", 0, 1, type);
          case -896505829: /*source*/  return new Property("source", "Reference(DocumentReference)", "Associated documentation about the medication.", 0, 1, source);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("source")) {
          this.source = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -896505829:  return getSource();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -896505829: /*source*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("source")) {
          this.source = new Reference();
          return this.source;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeMonographComponent copy() {
        MedicationKnowledgeMonographComponent dst = new MedicationKnowledgeMonographComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeMonographComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.source = source == null ? null : source.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeMonographComponent))
          return false;
        MedicationKnowledgeMonographComponent o = (MedicationKnowledgeMonographComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(source, o.source, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeMonographComponent))
          return false;
        MedicationKnowledgeMonographComponent o = (MedicationKnowledgeMonographComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, source);
      }

  public String fhirType() {
    return "MedicationKnowledge.monograph";

  }

  }

    @Block()
    public static class MedicationKnowledgeIngredientComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The actual ingredient - either a substance (simple ingredient) or another medication.
         */
        @Child(name = "item", type = {CodeableReference.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Medication(s) or MedicinalProductIngredient(s) contained in the medication", formalDefinition="The actual ingredient - either a substance (simple ingredient) or another medication." )
        protected CodeableReference item;

        /**
         * Indication of whether this ingredient affects the therapeutic action of the drug.
         */
        @Child(name = "isActive", type = {BooleanType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Active ingredient indicator", formalDefinition="Indication of whether this ingredient affects the therapeutic action of the drug." )
        protected BooleanType isActive;

        /**
         * Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.
         */
        @Child(name = "strength", type = {Ratio.class, CodeableConcept.class, Quantity.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Quantity of ingredient present", formalDefinition="Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-ingredientstrength")
        protected DataType strength;

        private static final long serialVersionUID = -979760018L;

    /**
     * Constructor
     */
      public MedicationKnowledgeIngredientComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeIngredientComponent(CodeableReference item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (The actual ingredient - either a substance (simple ingredient) or another medication.)
         */
        public CodeableReference getItem() { 
          if (this.item == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeIngredientComponent.item");
            else if (Configuration.doAutoCreate())
              this.item = new CodeableReference(); // cc
          return this.item;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (The actual ingredient - either a substance (simple ingredient) or another medication.)
         */
        public MedicationKnowledgeIngredientComponent setItem(CodeableReference value) { 
          this.item = value;
          return this;
        }

        /**
         * @return {@link #isActive} (Indication of whether this ingredient affects the therapeutic action of the drug.). This is the underlying object with id, value and extensions. The accessor "getIsActive" gives direct access to the value
         */
        public BooleanType getIsActiveElement() { 
          if (this.isActive == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeIngredientComponent.isActive");
            else if (Configuration.doAutoCreate())
              this.isActive = new BooleanType(); // bb
          return this.isActive;
        }

        public boolean hasIsActiveElement() { 
          return this.isActive != null && !this.isActive.isEmpty();
        }

        public boolean hasIsActive() { 
          return this.isActive != null && !this.isActive.isEmpty();
        }

        /**
         * @param value {@link #isActive} (Indication of whether this ingredient affects the therapeutic action of the drug.). This is the underlying object with id, value and extensions. The accessor "getIsActive" gives direct access to the value
         */
        public MedicationKnowledgeIngredientComponent setIsActiveElement(BooleanType value) { 
          this.isActive = value;
          return this;
        }

        /**
         * @return Indication of whether this ingredient affects the therapeutic action of the drug.
         */
        public boolean getIsActive() { 
          return this.isActive == null || this.isActive.isEmpty() ? false : this.isActive.getValue();
        }

        /**
         * @param value Indication of whether this ingredient affects the therapeutic action of the drug.
         */
        public MedicationKnowledgeIngredientComponent setIsActive(boolean value) { 
            if (this.isActive == null)
              this.isActive = new BooleanType();
            this.isActive.setValue(value);
          return this;
        }

        /**
         * @return {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
         */
        public DataType getStrength() { 
          return this.strength;
        }

        /**
         * @return {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
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
         * @return {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
         */
        public CodeableConcept getStrengthCodeableConcept() throws FHIRException { 
          if (this.strength == null)
            this.strength = new CodeableConcept();
          if (!(this.strength instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.strength.getClass().getName()+" was encountered");
          return (CodeableConcept) this.strength;
        }

        public boolean hasStrengthCodeableConcept() { 
          return this != null && this.strength instanceof CodeableConcept;
        }

        /**
         * @return {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
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
         * @param value {@link #strength} (Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.)
         */
        public MedicationKnowledgeIngredientComponent setStrength(DataType value) { 
          if (value != null && !(value instanceof Ratio || value instanceof CodeableConcept || value instanceof Quantity))
            throw new Error("Not the right type for MedicationKnowledge.ingredient.strength[x]: "+value.fhirType());
          this.strength = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item", "CodeableReference(Ingredient)", "The actual ingredient - either a substance (simple ingredient) or another medication.", 0, 1, item));
          children.add(new Property("isActive", "boolean", "Indication of whether this ingredient affects the therapeutic action of the drug.", 0, 1, isActive));
          children.add(new Property("strength[x]", "Ratio|CodeableConcept|Quantity", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3242771: /*item*/  return new Property("item", "CodeableReference(Ingredient)", "The actual ingredient - either a substance (simple ingredient) or another medication.", 0, 1, item);
          case -748916528: /*isActive*/  return new Property("isActive", "boolean", "Indication of whether this ingredient affects the therapeutic action of the drug.", 0, 1, isActive);
          case 127377567: /*strength[x]*/  return new Property("strength[x]", "Ratio|CodeableConcept|Quantity", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          case 1791316033: /*strength*/  return new Property("strength[x]", "Ratio|CodeableConcept|Quantity", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          case 2141786186: /*strengthRatio*/  return new Property("strength[x]", "Ratio", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          case -1455903456: /*strengthCodeableConcept*/  return new Property("strength[x]", "CodeableConcept", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          case -1793570836: /*strengthQuantity*/  return new Property("strength[x]", "Quantity", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return this.item == null ? new Base[0] : new Base[] {this.item}; // CodeableReference
        case -748916528: /*isActive*/ return this.isActive == null ? new Base[0] : new Base[] {this.isActive}; // BooleanType
        case 1791316033: /*strength*/ return this.strength == null ? new Base[0] : new Base[] {this.strength}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3242771: // item
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case -748916528: // isActive
          this.isActive = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 1791316033: // strength
          this.strength = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("item")) {
          this.item = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("isActive")) {
          this.isActive = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("strength[x]")) {
          this.strength = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771:  return getItem();
        case -748916528:  return getIsActiveElement();
        case 127377567:  return getStrength();
        case 1791316033:  return getStrength();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"CodeableReference"};
        case -748916528: /*isActive*/ return new String[] {"boolean"};
        case 1791316033: /*strength*/ return new String[] {"Ratio", "CodeableConcept", "Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("item")) {
          this.item = new CodeableReference();
          return this.item;
        }
        else if (name.equals("isActive")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.ingredient.isActive");
        }
        else if (name.equals("strengthRatio")) {
          this.strength = new Ratio();
          return this.strength;
        }
        else if (name.equals("strengthCodeableConcept")) {
          this.strength = new CodeableConcept();
          return this.strength;
        }
        else if (name.equals("strengthQuantity")) {
          this.strength = new Quantity();
          return this.strength;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeIngredientComponent copy() {
        MedicationKnowledgeIngredientComponent dst = new MedicationKnowledgeIngredientComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeIngredientComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
        dst.isActive = isActive == null ? null : isActive.copy();
        dst.strength = strength == null ? null : strength.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeIngredientComponent))
          return false;
        MedicationKnowledgeIngredientComponent o = (MedicationKnowledgeIngredientComponent) other_;
        return compareDeep(item, o.item, true) && compareDeep(isActive, o.isActive, true) && compareDeep(strength, o.strength, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeIngredientComponent))
          return false;
        MedicationKnowledgeIngredientComponent o = (MedicationKnowledgeIngredientComponent) other_;
        return compareValues(isActive, o.isActive, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item, isActive, strength
          );
      }

  public String fhirType() {
    return "MedicationKnowledge.ingredient";

  }

  }

    @Block()
    public static class MedicationKnowledgeCostComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The category of the cost information", formalDefinition="The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost." )
        protected CodeableConcept type;

        /**
         * The source or owner that assigns the price to the medication.
         */
        @Child(name = "source", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The source or owner for the price information", formalDefinition="The source or owner that assigns the price to the medication." )
        protected StringType source;

        /**
         * The price of the medication.
         */
        @Child(name = "cost", type = {Money.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The price of the medication", formalDefinition="The price of the medication." )
        protected Money cost;

        private static final long serialVersionUID = 244671378L;

    /**
     * Constructor
     */
      public MedicationKnowledgeCostComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeCostComponent(CodeableConcept type, Money cost) {
        super();
        this.setType(type);
        this.setCost(cost);
      }

        /**
         * @return {@link #type} (The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeCostComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost.)
         */
        public MedicationKnowledgeCostComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #source} (The source or owner that assigns the price to the medication.). This is the underlying object with id, value and extensions. The accessor "getSource" gives direct access to the value
         */
        public StringType getSourceElement() { 
          if (this.source == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeCostComponent.source");
            else if (Configuration.doAutoCreate())
              this.source = new StringType(); // bb
          return this.source;
        }

        public boolean hasSourceElement() { 
          return this.source != null && !this.source.isEmpty();
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (The source or owner that assigns the price to the medication.). This is the underlying object with id, value and extensions. The accessor "getSource" gives direct access to the value
         */
        public MedicationKnowledgeCostComponent setSourceElement(StringType value) { 
          this.source = value;
          return this;
        }

        /**
         * @return The source or owner that assigns the price to the medication.
         */
        public String getSource() { 
          return this.source == null ? null : this.source.getValue();
        }

        /**
         * @param value The source or owner that assigns the price to the medication.
         */
        public MedicationKnowledgeCostComponent setSource(String value) { 
          if (Utilities.noString(value))
            this.source = null;
          else {
            if (this.source == null)
              this.source = new StringType();
            this.source.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #cost} (The price of the medication.)
         */
        public Money getCost() { 
          if (this.cost == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeCostComponent.cost");
            else if (Configuration.doAutoCreate())
              this.cost = new Money(); // cc
          return this.cost;
        }

        public boolean hasCost() { 
          return this.cost != null && !this.cost.isEmpty();
        }

        /**
         * @param value {@link #cost} (The price of the medication.)
         */
        public MedicationKnowledgeCostComponent setCost(Money value) { 
          this.cost = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost.", 0, 1, type));
          children.add(new Property("source", "string", "The source or owner that assigns the price to the medication.", 0, 1, source));
          children.add(new Property("cost", "Money", "The price of the medication.", 0, 1, cost));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost.", 0, 1, type);
          case -896505829: /*source*/  return new Property("source", "string", "The source or owner that assigns the price to the medication.", 0, 1, source);
          case 3059661: /*cost*/  return new Property("cost", "Money", "The price of the medication.", 0, 1, cost);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // StringType
        case 3059661: /*cost*/ return this.cost == null ? new Base[0] : new Base[] {this.cost}; // Money
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToString(value); // StringType
          return value;
        case 3059661: // cost
          this.cost = TypeConvertor.castToMoney(value); // Money
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("source")) {
          this.source = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("cost")) {
          this.cost = TypeConvertor.castToMoney(value); // Money
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -896505829:  return getSourceElement();
        case 3059661:  return getCost();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -896505829: /*source*/ return new String[] {"string"};
        case 3059661: /*cost*/ return new String[] {"Money"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("source")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.cost.source");
        }
        else if (name.equals("cost")) {
          this.cost = new Money();
          return this.cost;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeCostComponent copy() {
        MedicationKnowledgeCostComponent dst = new MedicationKnowledgeCostComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeCostComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.source = source == null ? null : source.copy();
        dst.cost = cost == null ? null : cost.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeCostComponent))
          return false;
        MedicationKnowledgeCostComponent o = (MedicationKnowledgeCostComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(source, o.source, true) && compareDeep(cost, o.cost, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeCostComponent))
          return false;
        MedicationKnowledgeCostComponent o = (MedicationKnowledgeCostComponent) other_;
        return compareValues(source, o.source, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, source, cost);
      }

  public String fhirType() {
    return "MedicationKnowledge.cost";

  }

  }

    @Block()
    public static class MedicationKnowledgeMonitoringProgramComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Type of program under which the medication is monitored.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of program under which the medication is monitored", formalDefinition="Type of program under which the medication is monitored." )
        protected CodeableConcept type;

        /**
         * Name of the reviewing program.
         */
        @Child(name = "name", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Name of the reviewing program", formalDefinition="Name of the reviewing program." )
        protected StringType name;

        private static final long serialVersionUID = -280346281L;

    /**
     * Constructor
     */
      public MedicationKnowledgeMonitoringProgramComponent() {
        super();
      }

        /**
         * @return {@link #type} (Type of program under which the medication is monitored.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeMonitoringProgramComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Type of program under which the medication is monitored.)
         */
        public MedicationKnowledgeMonitoringProgramComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #name} (Name of the reviewing program.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public StringType getNameElement() { 
          if (this.name == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeMonitoringProgramComponent.name");
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
         * @param value {@link #name} (Name of the reviewing program.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
         */
        public MedicationKnowledgeMonitoringProgramComponent setNameElement(StringType value) { 
          this.name = value;
          return this;
        }

        /**
         * @return Name of the reviewing program.
         */
        public String getName() { 
          return this.name == null ? null : this.name.getValue();
        }

        /**
         * @param value Name of the reviewing program.
         */
        public MedicationKnowledgeMonitoringProgramComponent setName(String value) { 
          if (Utilities.noString(value))
            this.name = null;
          else {
            if (this.name == null)
              this.name = new StringType();
            this.name.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Type of program under which the medication is monitored.", 0, 1, type));
          children.add(new Property("name", "string", "Name of the reviewing program.", 0, 1, name));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Type of program under which the medication is monitored.", 0, 1, type);
          case 3373707: /*name*/  return new Property("name", "string", "Name of the reviewing program.", 0, 1, name);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 3373707:  return getNameElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.monitoringProgram.name");
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeMonitoringProgramComponent copy() {
        MedicationKnowledgeMonitoringProgramComponent dst = new MedicationKnowledgeMonitoringProgramComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeMonitoringProgramComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.name = name == null ? null : name.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeMonitoringProgramComponent))
          return false;
        MedicationKnowledgeMonitoringProgramComponent o = (MedicationKnowledgeMonitoringProgramComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(name, o.name, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeMonitoringProgramComponent))
          return false;
        MedicationKnowledgeMonitoringProgramComponent o = (MedicationKnowledgeMonitoringProgramComponent) other_;
        return compareValues(name, o.name, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, name);
      }

  public String fhirType() {
    return "MedicationKnowledge.monitoringProgram";

  }

  }

    @Block()
    public static class MedicationKnowledgeAdministrationGuidelineComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Dosage for the medication for the specific guidelines.
         */
        @Child(name = "dosage", type = {}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Dosage for the medication for the specific guidelines", formalDefinition="Dosage for the medication for the specific guidelines." )
        protected List<MedicationKnowledgeAdministrationGuidelineDosageComponent> dosage;

        /**
         * Indication or reason for use of the medication that applies to the specific administration guidelines.
         */
        @Child(name = "indication", type = {CodeableReference.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Indication for use that apply to the specific administration guidelines", formalDefinition="Indication or reason for use of the medication that applies to the specific administration guidelines." )
        protected CodeableReference indication;

        /**
         * Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.).
         */
        @Child(name = "patientCharacteristic", type = {}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Characteristics of the patient that are relevant to the administration guidelines", formalDefinition="Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.)." )
        protected List<MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent> patientCharacteristic;

        private static final long serialVersionUID = 1786736896L;

    /**
     * Constructor
     */
      public MedicationKnowledgeAdministrationGuidelineComponent() {
        super();
      }

        /**
         * @return {@link #dosage} (Dosage for the medication for the specific guidelines.)
         */
        public List<MedicationKnowledgeAdministrationGuidelineDosageComponent> getDosage() { 
          if (this.dosage == null)
            this.dosage = new ArrayList<MedicationKnowledgeAdministrationGuidelineDosageComponent>();
          return this.dosage;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeAdministrationGuidelineComponent setDosage(List<MedicationKnowledgeAdministrationGuidelineDosageComponent> theDosage) { 
          this.dosage = theDosage;
          return this;
        }

        public boolean hasDosage() { 
          if (this.dosage == null)
            return false;
          for (MedicationKnowledgeAdministrationGuidelineDosageComponent item : this.dosage)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgeAdministrationGuidelineDosageComponent addDosage() { //3
          MedicationKnowledgeAdministrationGuidelineDosageComponent t = new MedicationKnowledgeAdministrationGuidelineDosageComponent();
          if (this.dosage == null)
            this.dosage = new ArrayList<MedicationKnowledgeAdministrationGuidelineDosageComponent>();
          this.dosage.add(t);
          return t;
        }

        public MedicationKnowledgeAdministrationGuidelineComponent addDosage(MedicationKnowledgeAdministrationGuidelineDosageComponent t) { //3
          if (t == null)
            return this;
          if (this.dosage == null)
            this.dosage = new ArrayList<MedicationKnowledgeAdministrationGuidelineDosageComponent>();
          this.dosage.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dosage}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgeAdministrationGuidelineDosageComponent getDosageFirstRep() { 
          if (getDosage().isEmpty()) {
            addDosage();
          }
          return getDosage().get(0);
        }

        /**
         * @return {@link #indication} (Indication or reason for use of the medication that applies to the specific administration guidelines.)
         */
        public CodeableReference getIndication() { 
          if (this.indication == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeAdministrationGuidelineComponent.indication");
            else if (Configuration.doAutoCreate())
              this.indication = new CodeableReference(); // cc
          return this.indication;
        }

        public boolean hasIndication() { 
          return this.indication != null && !this.indication.isEmpty();
        }

        /**
         * @param value {@link #indication} (Indication or reason for use of the medication that applies to the specific administration guidelines.)
         */
        public MedicationKnowledgeAdministrationGuidelineComponent setIndication(CodeableReference value) { 
          this.indication = value;
          return this;
        }

        /**
         * @return {@link #patientCharacteristic} (Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.).)
         */
        public List<MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent> getPatientCharacteristic() { 
          if (this.patientCharacteristic == null)
            this.patientCharacteristic = new ArrayList<MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent>();
          return this.patientCharacteristic;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeAdministrationGuidelineComponent setPatientCharacteristic(List<MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent> thePatientCharacteristic) { 
          this.patientCharacteristic = thePatientCharacteristic;
          return this;
        }

        public boolean hasPatientCharacteristic() { 
          if (this.patientCharacteristic == null)
            return false;
          for (MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent item : this.patientCharacteristic)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent addPatientCharacteristic() { //3
          MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent t = new MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent();
          if (this.patientCharacteristic == null)
            this.patientCharacteristic = new ArrayList<MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent>();
          this.patientCharacteristic.add(t);
          return t;
        }

        public MedicationKnowledgeAdministrationGuidelineComponent addPatientCharacteristic(MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent t) { //3
          if (t == null)
            return this;
          if (this.patientCharacteristic == null)
            this.patientCharacteristic = new ArrayList<MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent>();
          this.patientCharacteristic.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #patientCharacteristic}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent getPatientCharacteristicFirstRep() { 
          if (getPatientCharacteristic().isEmpty()) {
            addPatientCharacteristic();
          }
          return getPatientCharacteristic().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("dosage", "", "Dosage for the medication for the specific guidelines.", 0, java.lang.Integer.MAX_VALUE, dosage));
          children.add(new Property("indication", "CodeableReference(ClinicalUseIssue)", "Indication or reason for use of the medication that applies to the specific administration guidelines.", 0, 1, indication));
          children.add(new Property("patientCharacteristic", "", "Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.).", 0, java.lang.Integer.MAX_VALUE, patientCharacteristic));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1326018889: /*dosage*/  return new Property("dosage", "", "Dosage for the medication for the specific guidelines.", 0, java.lang.Integer.MAX_VALUE, dosage);
          case -597168804: /*indication*/  return new Property("indication", "CodeableReference(ClinicalUseIssue)", "Indication or reason for use of the medication that applies to the specific administration guidelines.", 0, 1, indication);
          case 1770130432: /*patientCharacteristic*/  return new Property("patientCharacteristic", "", "Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.).", 0, java.lang.Integer.MAX_VALUE, patientCharacteristic);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1326018889: /*dosage*/ return this.dosage == null ? new Base[0] : this.dosage.toArray(new Base[this.dosage.size()]); // MedicationKnowledgeAdministrationGuidelineDosageComponent
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : new Base[] {this.indication}; // CodeableReference
        case 1770130432: /*patientCharacteristic*/ return this.patientCharacteristic == null ? new Base[0] : this.patientCharacteristic.toArray(new Base[this.patientCharacteristic.size()]); // MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1326018889: // dosage
          this.getDosage().add((MedicationKnowledgeAdministrationGuidelineDosageComponent) value); // MedicationKnowledgeAdministrationGuidelineDosageComponent
          return value;
        case -597168804: // indication
          this.indication = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 1770130432: // patientCharacteristic
          this.getPatientCharacteristic().add((MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent) value); // MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("dosage")) {
          this.getDosage().add((MedicationKnowledgeAdministrationGuidelineDosageComponent) value);
        } else if (name.equals("indication")) {
          this.indication = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("patientCharacteristic")) {
          this.getPatientCharacteristic().add((MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1326018889:  return addDosage(); 
        case -597168804:  return getIndication();
        case 1770130432:  return addPatientCharacteristic(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1326018889: /*dosage*/ return new String[] {};
        case -597168804: /*indication*/ return new String[] {"CodeableReference"};
        case 1770130432: /*patientCharacteristic*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("dosage")) {
          return addDosage();
        }
        else if (name.equals("indication")) {
          this.indication = new CodeableReference();
          return this.indication;
        }
        else if (name.equals("patientCharacteristic")) {
          return addPatientCharacteristic();
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeAdministrationGuidelineComponent copy() {
        MedicationKnowledgeAdministrationGuidelineComponent dst = new MedicationKnowledgeAdministrationGuidelineComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeAdministrationGuidelineComponent dst) {
        super.copyValues(dst);
        if (dosage != null) {
          dst.dosage = new ArrayList<MedicationKnowledgeAdministrationGuidelineDosageComponent>();
          for (MedicationKnowledgeAdministrationGuidelineDosageComponent i : dosage)
            dst.dosage.add(i.copy());
        };
        dst.indication = indication == null ? null : indication.copy();
        if (patientCharacteristic != null) {
          dst.patientCharacteristic = new ArrayList<MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent>();
          for (MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent i : patientCharacteristic)
            dst.patientCharacteristic.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeAdministrationGuidelineComponent))
          return false;
        MedicationKnowledgeAdministrationGuidelineComponent o = (MedicationKnowledgeAdministrationGuidelineComponent) other_;
        return compareDeep(dosage, o.dosage, true) && compareDeep(indication, o.indication, true) && compareDeep(patientCharacteristic, o.patientCharacteristic, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeAdministrationGuidelineComponent))
          return false;
        MedicationKnowledgeAdministrationGuidelineComponent o = (MedicationKnowledgeAdministrationGuidelineComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(dosage, indication, patientCharacteristic
          );
      }

  public String fhirType() {
    return "MedicationKnowledge.administrationGuideline";

  }

  }

    @Block()
    public static class MedicationKnowledgeAdministrationGuidelineDosageComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type or category of dosage for a given medication (for example, prophylaxis, maintenance, therapeutic, etc.).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Category of dosage for a medication", formalDefinition="The type or category of dosage for a given medication (for example, prophylaxis, maintenance, therapeutic, etc.)." )
        protected CodeableConcept type;

        /**
         * Dosage for the medication for the specific guidelines.
         */
        @Child(name = "dosage", type = {Dosage.class}, order=2, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Dosage for the medication for the specific guidelines", formalDefinition="Dosage for the medication for the specific guidelines." )
        protected List<Dosage> dosage;

        private static final long serialVersionUID = 1578257961L;

    /**
     * Constructor
     */
      public MedicationKnowledgeAdministrationGuidelineDosageComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeAdministrationGuidelineDosageComponent(CodeableConcept type, Dosage dosage) {
        super();
        this.setType(type);
        this.addDosage(dosage);
      }

        /**
         * @return {@link #type} (The type or category of dosage for a given medication (for example, prophylaxis, maintenance, therapeutic, etc.).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeAdministrationGuidelineDosageComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type or category of dosage for a given medication (for example, prophylaxis, maintenance, therapeutic, etc.).)
         */
        public MedicationKnowledgeAdministrationGuidelineDosageComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #dosage} (Dosage for the medication for the specific guidelines.)
         */
        public List<Dosage> getDosage() { 
          if (this.dosage == null)
            this.dosage = new ArrayList<Dosage>();
          return this.dosage;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeAdministrationGuidelineDosageComponent setDosage(List<Dosage> theDosage) { 
          this.dosage = theDosage;
          return this;
        }

        public boolean hasDosage() { 
          if (this.dosage == null)
            return false;
          for (Dosage item : this.dosage)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Dosage addDosage() { //3
          Dosage t = new Dosage();
          if (this.dosage == null)
            this.dosage = new ArrayList<Dosage>();
          this.dosage.add(t);
          return t;
        }

        public MedicationKnowledgeAdministrationGuidelineDosageComponent addDosage(Dosage t) { //3
          if (t == null)
            return this;
          if (this.dosage == null)
            this.dosage = new ArrayList<Dosage>();
          this.dosage.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dosage}, creating it if it does not already exist {3}
         */
        public Dosage getDosageFirstRep() { 
          if (getDosage().isEmpty()) {
            addDosage();
          }
          return getDosage().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The type or category of dosage for a given medication (for example, prophylaxis, maintenance, therapeutic, etc.).", 0, 1, type));
          children.add(new Property("dosage", "Dosage", "Dosage for the medication for the specific guidelines.", 0, java.lang.Integer.MAX_VALUE, dosage));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type or category of dosage for a given medication (for example, prophylaxis, maintenance, therapeutic, etc.).", 0, 1, type);
          case -1326018889: /*dosage*/  return new Property("dosage", "Dosage", "Dosage for the medication for the specific guidelines.", 0, java.lang.Integer.MAX_VALUE, dosage);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1326018889: /*dosage*/ return this.dosage == null ? new Base[0] : this.dosage.toArray(new Base[this.dosage.size()]); // Dosage
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1326018889: // dosage
          this.getDosage().add(TypeConvertor.castToDosage(value)); // Dosage
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("dosage")) {
          this.getDosage().add(TypeConvertor.castToDosage(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1326018889:  return addDosage(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1326018889: /*dosage*/ return new String[] {"Dosage"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("dosage")) {
          return addDosage();
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeAdministrationGuidelineDosageComponent copy() {
        MedicationKnowledgeAdministrationGuidelineDosageComponent dst = new MedicationKnowledgeAdministrationGuidelineDosageComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeAdministrationGuidelineDosageComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (dosage != null) {
          dst.dosage = new ArrayList<Dosage>();
          for (Dosage i : dosage)
            dst.dosage.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeAdministrationGuidelineDosageComponent))
          return false;
        MedicationKnowledgeAdministrationGuidelineDosageComponent o = (MedicationKnowledgeAdministrationGuidelineDosageComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(dosage, o.dosage, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeAdministrationGuidelineDosageComponent))
          return false;
        MedicationKnowledgeAdministrationGuidelineDosageComponent o = (MedicationKnowledgeAdministrationGuidelineDosageComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, dosage);
      }

  public String fhirType() {
    return "MedicationKnowledge.administrationGuideline.dosage";

  }

  }

    @Block()
    public static class MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Categorization of specific characteristic that is relevant to the administration guideline", formalDefinition="The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender)." )
        protected CodeableConcept type;

        /**
         * The specific characteristic (e.g. height, weight, gender, etc.).
         */
        @Child(name = "value", type = {CodeableConcept.class, Quantity.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specific characteristic", formalDefinition="The specific characteristic (e.g. height, weight, gender, etc.)." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender).)
         */
        public MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (The specific characteristic (e.g. height, weight, gender, etc.).)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (The specific characteristic (e.g. height, weight, gender, etc.).)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (The specific characteristic (e.g. height, weight, gender, etc.).)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The specific characteristic (e.g. height, weight, gender, etc.).)
         */
        public MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity))
            throw new Error("Not the right type for MedicationKnowledge.administrationGuideline.patientCharacteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender).", 0, 1, type));
          children.add(new Property("value[x]", "CodeableConcept|Quantity", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender).", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|Quantity", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|Quantity", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent copy() {
        MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent dst = new MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent))
          return false;
        MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent o = (MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent))
          return false;
        MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent o = (MedicationKnowledgeAdministrationGuidelinePatientCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "MedicationKnowledge.administrationGuideline.patientCharacteristic";

  }

  }

    @Block()
    public static class MedicationKnowledgeMedicineClassificationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification)", formalDefinition="The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification)." )
        protected CodeableConcept type;

        /**
         * Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive, antibiotic, etc.).
         */
        @Child(name = "classification", type = {CodeableConcept.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specific category assigned to the medication", formalDefinition="Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive, antibiotic, etc.)." )
        protected List<CodeableConcept> classification;

        private static final long serialVersionUID = 1562996046L;

    /**
     * Constructor
     */
      public MedicationKnowledgeMedicineClassificationComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeMedicineClassificationComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeMedicineClassificationComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification).)
         */
        public MedicationKnowledgeMedicineClassificationComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #classification} (Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive, antibiotic, etc.).)
         */
        public List<CodeableConcept> getClassification() { 
          if (this.classification == null)
            this.classification = new ArrayList<CodeableConcept>();
          return this.classification;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeMedicineClassificationComponent setClassification(List<CodeableConcept> theClassification) { 
          this.classification = theClassification;
          return this;
        }

        public boolean hasClassification() { 
          if (this.classification == null)
            return false;
          for (CodeableConcept item : this.classification)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addClassification() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.classification == null)
            this.classification = new ArrayList<CodeableConcept>();
          this.classification.add(t);
          return t;
        }

        public MedicationKnowledgeMedicineClassificationComponent addClassification(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.classification == null)
            this.classification = new ArrayList<CodeableConcept>();
          this.classification.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #classification}, creating it if it does not already exist {3}
         */
        public CodeableConcept getClassificationFirstRep() { 
          if (getClassification().isEmpty()) {
            addClassification();
          }
          return getClassification().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification).", 0, 1, type));
          children.add(new Property("classification", "CodeableConcept", "Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive, antibiotic, etc.).", 0, java.lang.Integer.MAX_VALUE, classification));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification).", 0, 1, type);
          case 382350310: /*classification*/  return new Property("classification", "CodeableConcept", "Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive, antibiotic, etc.).", 0, java.lang.Integer.MAX_VALUE, classification);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 382350310: /*classification*/ return this.classification == null ? new Base[0] : this.classification.toArray(new Base[this.classification.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 382350310: // classification
          this.getClassification().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("classification")) {
          this.getClassification().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case 382350310:  return addClassification(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 382350310: /*classification*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("classification")) {
          return addClassification();
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeMedicineClassificationComponent copy() {
        MedicationKnowledgeMedicineClassificationComponent dst = new MedicationKnowledgeMedicineClassificationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeMedicineClassificationComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        if (classification != null) {
          dst.classification = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : classification)
            dst.classification.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeMedicineClassificationComponent))
          return false;
        MedicationKnowledgeMedicineClassificationComponent o = (MedicationKnowledgeMedicineClassificationComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(classification, o.classification, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeMedicineClassificationComponent))
          return false;
        MedicationKnowledgeMedicineClassificationComponent o = (MedicationKnowledgeMedicineClassificationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, classification);
      }

  public String fhirType() {
    return "MedicationKnowledge.medicineClassification";

  }

  }

    @Block()
    public static class MedicationKnowledgePackagingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code that defines the specific type of packaging that the medication can be found in (e.g. blister sleeve, tube, bottle).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A code that defines the specific type of packaging that the medication can be found in", formalDefinition="A code that defines the specific type of packaging that the medication can be found in (e.g. blister sleeve, tube, bottle)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicationknowledge-package-type")
        protected CodeableConcept type;

        /**
         * The number of product units the package would contain if fully loaded.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The number of product units the package would contain if fully loaded", formalDefinition="The number of product units the package would contain if fully loaded." )
        protected Quantity quantity;

        /**
         * The device used to administer the medication (e.g. scoop, applicator, syringe).
         */
        @Child(name = "device", type = {Device.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The device used to administer the medication (e.g. scoop, applicator, syringe)", formalDefinition="The device used to administer the medication (e.g. scoop, applicator, syringe)." )
        protected Reference device;

        /**
         * Material type of the package item.
         */
        @Child(name = "material", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Material type of the package item", formalDefinition="Material type of the package item." )
        protected CodeableConcept material;

        /**
         * Allows packages within packages (e.g. blister packages within a box or vials of medications within a box).
         */
        @Child(name = "packaging", type = {MedicationKnowledgePackagingComponent.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Allows packages within packages", formalDefinition="Allows packages within packages (e.g. blister packages within a box or vials of medications within a box)." )
        protected List<MedicationKnowledgePackagingComponent> packaging;

        private static final long serialVersionUID = 574843440L;

    /**
     * Constructor
     */
      public MedicationKnowledgePackagingComponent() {
        super();
      }

        /**
         * @return {@link #type} (A code that defines the specific type of packaging that the medication can be found in (e.g. blister sleeve, tube, bottle).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgePackagingComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A code that defines the specific type of packaging that the medication can be found in (e.g. blister sleeve, tube, bottle).)
         */
        public MedicationKnowledgePackagingComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #quantity} (The number of product units the package would contain if fully loaded.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgePackagingComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The number of product units the package would contain if fully loaded.)
         */
        public MedicationKnowledgePackagingComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #device} (The device used to administer the medication (e.g. scoop, applicator, syringe).)
         */
        public Reference getDevice() { 
          if (this.device == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgePackagingComponent.device");
            else if (Configuration.doAutoCreate())
              this.device = new Reference(); // cc
          return this.device;
        }

        public boolean hasDevice() { 
          return this.device != null && !this.device.isEmpty();
        }

        /**
         * @param value {@link #device} (The device used to administer the medication (e.g. scoop, applicator, syringe).)
         */
        public MedicationKnowledgePackagingComponent setDevice(Reference value) { 
          this.device = value;
          return this;
        }

        /**
         * @return {@link #material} (Material type of the package item.)
         */
        public CodeableConcept getMaterial() { 
          if (this.material == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgePackagingComponent.material");
            else if (Configuration.doAutoCreate())
              this.material = new CodeableConcept(); // cc
          return this.material;
        }

        public boolean hasMaterial() { 
          return this.material != null && !this.material.isEmpty();
        }

        /**
         * @param value {@link #material} (Material type of the package item.)
         */
        public MedicationKnowledgePackagingComponent setMaterial(CodeableConcept value) { 
          this.material = value;
          return this;
        }

        /**
         * @return {@link #packaging} (Allows packages within packages (e.g. blister packages within a box or vials of medications within a box).)
         */
        public List<MedicationKnowledgePackagingComponent> getPackaging() { 
          if (this.packaging == null)
            this.packaging = new ArrayList<MedicationKnowledgePackagingComponent>();
          return this.packaging;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgePackagingComponent setPackaging(List<MedicationKnowledgePackagingComponent> thePackaging) { 
          this.packaging = thePackaging;
          return this;
        }

        public boolean hasPackaging() { 
          if (this.packaging == null)
            return false;
          for (MedicationKnowledgePackagingComponent item : this.packaging)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgePackagingComponent addPackaging() { //3
          MedicationKnowledgePackagingComponent t = new MedicationKnowledgePackagingComponent();
          if (this.packaging == null)
            this.packaging = new ArrayList<MedicationKnowledgePackagingComponent>();
          this.packaging.add(t);
          return t;
        }

        public MedicationKnowledgePackagingComponent addPackaging(MedicationKnowledgePackagingComponent t) { //3
          if (t == null)
            return this;
          if (this.packaging == null)
            this.packaging = new ArrayList<MedicationKnowledgePackagingComponent>();
          this.packaging.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #packaging}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgePackagingComponent getPackagingFirstRep() { 
          if (getPackaging().isEmpty()) {
            addPackaging();
          }
          return getPackaging().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "A code that defines the specific type of packaging that the medication can be found in (e.g. blister sleeve, tube, bottle).", 0, 1, type));
          children.add(new Property("quantity", "Quantity", "The number of product units the package would contain if fully loaded.", 0, 1, quantity));
          children.add(new Property("device", "Reference(Device)", "The device used to administer the medication (e.g. scoop, applicator, syringe).", 0, 1, device));
          children.add(new Property("material", "CodeableConcept", "Material type of the package item.", 0, 1, material));
          children.add(new Property("packaging", "@MedicationKnowledge.packaging", "Allows packages within packages (e.g. blister packages within a box or vials of medications within a box).", 0, java.lang.Integer.MAX_VALUE, packaging));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A code that defines the specific type of packaging that the medication can be found in (e.g. blister sleeve, tube, bottle).", 0, 1, type);
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The number of product units the package would contain if fully loaded.", 0, 1, quantity);
          case -1335157162: /*device*/  return new Property("device", "Reference(Device)", "The device used to administer the medication (e.g. scoop, applicator, syringe).", 0, 1, device);
          case 299066663: /*material*/  return new Property("material", "CodeableConcept", "Material type of the package item.", 0, 1, material);
          case 1802065795: /*packaging*/  return new Property("packaging", "@MedicationKnowledge.packaging", "Allows packages within packages (e.g. blister packages within a box or vials of medications within a box).", 0, java.lang.Integer.MAX_VALUE, packaging);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : new Base[] {this.device}; // Reference
        case 299066663: /*material*/ return this.material == null ? new Base[0] : new Base[] {this.material}; // CodeableConcept
        case 1802065795: /*packaging*/ return this.packaging == null ? new Base[0] : this.packaging.toArray(new Base[this.packaging.size()]); // MedicationKnowledgePackagingComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1335157162: // device
          this.device = TypeConvertor.castToReference(value); // Reference
          return value;
        case 299066663: // material
          this.material = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1802065795: // packaging
          this.getPackaging().add((MedicationKnowledgePackagingComponent) value); // MedicationKnowledgePackagingComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("device")) {
          this.device = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("material")) {
          this.material = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("packaging")) {
          this.getPackaging().add((MedicationKnowledgePackagingComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1285004149:  return getQuantity();
        case -1335157162:  return getDevice();
        case 299066663:  return getMaterial();
        case 1802065795:  return addPackaging(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case 299066663: /*material*/ return new String[] {"CodeableConcept"};
        case 1802065795: /*packaging*/ return new String[] {"@MedicationKnowledge.packaging"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("device")) {
          this.device = new Reference();
          return this.device;
        }
        else if (name.equals("material")) {
          this.material = new CodeableConcept();
          return this.material;
        }
        else if (name.equals("packaging")) {
          return addPackaging();
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgePackagingComponent copy() {
        MedicationKnowledgePackagingComponent dst = new MedicationKnowledgePackagingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgePackagingComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.device = device == null ? null : device.copy();
        dst.material = material == null ? null : material.copy();
        if (packaging != null) {
          dst.packaging = new ArrayList<MedicationKnowledgePackagingComponent>();
          for (MedicationKnowledgePackagingComponent i : packaging)
            dst.packaging.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgePackagingComponent))
          return false;
        MedicationKnowledgePackagingComponent o = (MedicationKnowledgePackagingComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(quantity, o.quantity, true) && compareDeep(device, o.device, true)
           && compareDeep(material, o.material, true) && compareDeep(packaging, o.packaging, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgePackagingComponent))
          return false;
        MedicationKnowledgePackagingComponent o = (MedicationKnowledgePackagingComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, quantity, device, material
          , packaging);
      }

  public String fhirType() {
    return "MedicationKnowledge.packaging";

  }

  }

    @Block()
    public static class MedicationKnowledgeDrugCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A code specifying which characteristic of the medicine is being described (for example, colour, shape, imprint).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code specifying the type of characteristic of medication", formalDefinition="A code specifying which characteristic of the medicine is being described (for example, colour, shape, imprint)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicationknowledge-characteristic")
        protected CodeableConcept type;

        /**
         * Description of the characteristic.
         */
        @Child(name = "value", type = {CodeableConcept.class, StringType.class, Quantity.class, Base64BinaryType.class, Attachment.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the characteristic", formalDefinition="Description of the characteristic." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public MedicationKnowledgeDrugCharacteristicComponent() {
        super();
      }

        /**
         * @return {@link #type} (A code specifying which characteristic of the medicine is being described (for example, colour, shape, imprint).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeDrugCharacteristicComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (A code specifying which characteristic of the medicine is being described (for example, colour, shape, imprint).)
         */
        public MedicationKnowledgeDrugCharacteristicComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (Description of the characteristic.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Description of the characteristic.)
         */
        public CodeableConcept getValueCodeableConcept() throws FHIRException { 
          if (this.value == null)
            this.value = new CodeableConcept();
          if (!(this.value instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.value.getClass().getName()+" was encountered");
          return (CodeableConcept) this.value;
        }

        public boolean hasValueCodeableConcept() { 
          return this != null && this.value instanceof CodeableConcept;
        }

        /**
         * @return {@link #value} (Description of the characteristic.)
         */
        public StringType getValueStringType() throws FHIRException { 
          if (this.value == null)
            this.value = new StringType();
          if (!(this.value instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (StringType) this.value;
        }

        public boolean hasValueStringType() { 
          return this != null && this.value instanceof StringType;
        }

        /**
         * @return {@link #value} (Description of the characteristic.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (Description of the characteristic.)
         */
        public Base64BinaryType getValueBase64BinaryType() throws FHIRException { 
          if (this.value == null)
            this.value = new Base64BinaryType();
          if (!(this.value instanceof Base64BinaryType))
            throw new FHIRException("Type mismatch: the type Base64BinaryType was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Base64BinaryType) this.value;
        }

        public boolean hasValueBase64BinaryType() { 
          return this != null && this.value instanceof Base64BinaryType;
        }

        /**
         * @return {@link #value} (Description of the characteristic.)
         */
        public Attachment getValueAttachment() throws FHIRException { 
          if (this.value == null)
            this.value = new Attachment();
          if (!(this.value instanceof Attachment))
            throw new FHIRException("Type mismatch: the type Attachment was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Attachment) this.value;
        }

        public boolean hasValueAttachment() { 
          return this != null && this.value instanceof Attachment;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Description of the characteristic.)
         */
        public MedicationKnowledgeDrugCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof StringType || value instanceof Quantity || value instanceof Base64BinaryType || value instanceof Attachment))
            throw new Error("Not the right type for MedicationKnowledge.drugCharacteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "A code specifying which characteristic of the medicine is being described (for example, colour, shape, imprint).", 0, 1, type));
          children.add(new Property("value[x]", "CodeableConcept|string|Quantity|base64Binary|Attachment", "Description of the characteristic.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A code specifying which characteristic of the medicine is being described (for example, colour, shape, imprint).", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|string|Quantity|base64Binary|Attachment", "Description of the characteristic.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|string|Quantity|base64Binary|Attachment", "Description of the characteristic.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "Description of the characteristic.", 0, 1, value);
          case -1424603934: /*valueString*/  return new Property("value[x]", "string", "Description of the characteristic.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Description of the characteristic.", 0, 1, value);
          case -1535024575: /*valueBase64Binary*/  return new Property("value[x]", "base64Binary", "Description of the characteristic.", 0, 1, value);
          case -475566732: /*valueAttachment*/  return new Property("value[x]", "Attachment", "Description of the characteristic.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "string", "Quantity", "base64Binary", "Attachment"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else if (name.equals("valueString")) {
          this.value = new StringType();
          return this.value;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueBase64Binary")) {
          this.value = new Base64BinaryType();
          return this.value;
        }
        else if (name.equals("valueAttachment")) {
          this.value = new Attachment();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeDrugCharacteristicComponent copy() {
        MedicationKnowledgeDrugCharacteristicComponent dst = new MedicationKnowledgeDrugCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeDrugCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeDrugCharacteristicComponent))
          return false;
        MedicationKnowledgeDrugCharacteristicComponent o = (MedicationKnowledgeDrugCharacteristicComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeDrugCharacteristicComponent))
          return false;
        MedicationKnowledgeDrugCharacteristicComponent o = (MedicationKnowledgeDrugCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "MedicationKnowledge.drugCharacteristic";

  }

  }

    @Block()
    public static class MedicationKnowledgeRegulatoryComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The authority that is specifying the regulations.
         */
        @Child(name = "regulatoryAuthority", type = {Organization.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Specifies the authority of the regulation", formalDefinition="The authority that is specifying the regulations." )
        protected Reference regulatoryAuthority;

        /**
         * Specifies if changes are allowed when dispensing a medication from a regulatory perspective.
         */
        @Child(name = "substitution", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specifies if changes are allowed when dispensing a medication from a regulatory perspective", formalDefinition="Specifies if changes are allowed when dispensing a medication from a regulatory perspective." )
        protected List<MedicationKnowledgeRegulatorySubstitutionComponent> substitution;

        /**
         * Specifies the schedule of a medication in jurisdiction.
         */
        @Child(name = "schedule", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specifies the schedule of a medication in jurisdiction", formalDefinition="Specifies the schedule of a medication in jurisdiction." )
        protected List<CodeableConcept> schedule;

        /**
         * The maximum number of units of the medication that can be dispensed in a period.
         */
        @Child(name = "maxDispense", type = {}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The maximum number of units of the medication that can be dispensed in a period", formalDefinition="The maximum number of units of the medication that can be dispensed in a period." )
        protected MedicationKnowledgeRegulatoryMaxDispenseComponent maxDispense;

        private static final long serialVersionUID = -2005823416L;

    /**
     * Constructor
     */
      public MedicationKnowledgeRegulatoryComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeRegulatoryComponent(Reference regulatoryAuthority) {
        super();
        this.setRegulatoryAuthority(regulatoryAuthority);
      }

        /**
         * @return {@link #regulatoryAuthority} (The authority that is specifying the regulations.)
         */
        public Reference getRegulatoryAuthority() { 
          if (this.regulatoryAuthority == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeRegulatoryComponent.regulatoryAuthority");
            else if (Configuration.doAutoCreate())
              this.regulatoryAuthority = new Reference(); // cc
          return this.regulatoryAuthority;
        }

        public boolean hasRegulatoryAuthority() { 
          return this.regulatoryAuthority != null && !this.regulatoryAuthority.isEmpty();
        }

        /**
         * @param value {@link #regulatoryAuthority} (The authority that is specifying the regulations.)
         */
        public MedicationKnowledgeRegulatoryComponent setRegulatoryAuthority(Reference value) { 
          this.regulatoryAuthority = value;
          return this;
        }

        /**
         * @return {@link #substitution} (Specifies if changes are allowed when dispensing a medication from a regulatory perspective.)
         */
        public List<MedicationKnowledgeRegulatorySubstitutionComponent> getSubstitution() { 
          if (this.substitution == null)
            this.substitution = new ArrayList<MedicationKnowledgeRegulatorySubstitutionComponent>();
          return this.substitution;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeRegulatoryComponent setSubstitution(List<MedicationKnowledgeRegulatorySubstitutionComponent> theSubstitution) { 
          this.substitution = theSubstitution;
          return this;
        }

        public boolean hasSubstitution() { 
          if (this.substitution == null)
            return false;
          for (MedicationKnowledgeRegulatorySubstitutionComponent item : this.substitution)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgeRegulatorySubstitutionComponent addSubstitution() { //3
          MedicationKnowledgeRegulatorySubstitutionComponent t = new MedicationKnowledgeRegulatorySubstitutionComponent();
          if (this.substitution == null)
            this.substitution = new ArrayList<MedicationKnowledgeRegulatorySubstitutionComponent>();
          this.substitution.add(t);
          return t;
        }

        public MedicationKnowledgeRegulatoryComponent addSubstitution(MedicationKnowledgeRegulatorySubstitutionComponent t) { //3
          if (t == null)
            return this;
          if (this.substitution == null)
            this.substitution = new ArrayList<MedicationKnowledgeRegulatorySubstitutionComponent>();
          this.substitution.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #substitution}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgeRegulatorySubstitutionComponent getSubstitutionFirstRep() { 
          if (getSubstitution().isEmpty()) {
            addSubstitution();
          }
          return getSubstitution().get(0);
        }

        /**
         * @return {@link #schedule} (Specifies the schedule of a medication in jurisdiction.)
         */
        public List<CodeableConcept> getSchedule() { 
          if (this.schedule == null)
            this.schedule = new ArrayList<CodeableConcept>();
          return this.schedule;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeRegulatoryComponent setSchedule(List<CodeableConcept> theSchedule) { 
          this.schedule = theSchedule;
          return this;
        }

        public boolean hasSchedule() { 
          if (this.schedule == null)
            return false;
          for (CodeableConcept item : this.schedule)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addSchedule() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.schedule == null)
            this.schedule = new ArrayList<CodeableConcept>();
          this.schedule.add(t);
          return t;
        }

        public MedicationKnowledgeRegulatoryComponent addSchedule(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.schedule == null)
            this.schedule = new ArrayList<CodeableConcept>();
          this.schedule.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #schedule}, creating it if it does not already exist {3}
         */
        public CodeableConcept getScheduleFirstRep() { 
          if (getSchedule().isEmpty()) {
            addSchedule();
          }
          return getSchedule().get(0);
        }

        /**
         * @return {@link #maxDispense} (The maximum number of units of the medication that can be dispensed in a period.)
         */
        public MedicationKnowledgeRegulatoryMaxDispenseComponent getMaxDispense() { 
          if (this.maxDispense == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeRegulatoryComponent.maxDispense");
            else if (Configuration.doAutoCreate())
              this.maxDispense = new MedicationKnowledgeRegulatoryMaxDispenseComponent(); // cc
          return this.maxDispense;
        }

        public boolean hasMaxDispense() { 
          return this.maxDispense != null && !this.maxDispense.isEmpty();
        }

        /**
         * @param value {@link #maxDispense} (The maximum number of units of the medication that can be dispensed in a period.)
         */
        public MedicationKnowledgeRegulatoryComponent setMaxDispense(MedicationKnowledgeRegulatoryMaxDispenseComponent value) { 
          this.maxDispense = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("regulatoryAuthority", "Reference(Organization)", "The authority that is specifying the regulations.", 0, 1, regulatoryAuthority));
          children.add(new Property("substitution", "", "Specifies if changes are allowed when dispensing a medication from a regulatory perspective.", 0, java.lang.Integer.MAX_VALUE, substitution));
          children.add(new Property("schedule", "CodeableConcept", "Specifies the schedule of a medication in jurisdiction.", 0, java.lang.Integer.MAX_VALUE, schedule));
          children.add(new Property("maxDispense", "", "The maximum number of units of the medication that can be dispensed in a period.", 0, 1, maxDispense));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 711233419: /*regulatoryAuthority*/  return new Property("regulatoryAuthority", "Reference(Organization)", "The authority that is specifying the regulations.", 0, 1, regulatoryAuthority);
          case 826147581: /*substitution*/  return new Property("substitution", "", "Specifies if changes are allowed when dispensing a medication from a regulatory perspective.", 0, java.lang.Integer.MAX_VALUE, substitution);
          case -697920873: /*schedule*/  return new Property("schedule", "CodeableConcept", "Specifies the schedule of a medication in jurisdiction.", 0, java.lang.Integer.MAX_VALUE, schedule);
          case -1977784607: /*maxDispense*/  return new Property("maxDispense", "", "The maximum number of units of the medication that can be dispensed in a period.", 0, 1, maxDispense);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 711233419: /*regulatoryAuthority*/ return this.regulatoryAuthority == null ? new Base[0] : new Base[] {this.regulatoryAuthority}; // Reference
        case 826147581: /*substitution*/ return this.substitution == null ? new Base[0] : this.substitution.toArray(new Base[this.substitution.size()]); // MedicationKnowledgeRegulatorySubstitutionComponent
        case -697920873: /*schedule*/ return this.schedule == null ? new Base[0] : this.schedule.toArray(new Base[this.schedule.size()]); // CodeableConcept
        case -1977784607: /*maxDispense*/ return this.maxDispense == null ? new Base[0] : new Base[] {this.maxDispense}; // MedicationKnowledgeRegulatoryMaxDispenseComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 711233419: // regulatoryAuthority
          this.regulatoryAuthority = TypeConvertor.castToReference(value); // Reference
          return value;
        case 826147581: // substitution
          this.getSubstitution().add((MedicationKnowledgeRegulatorySubstitutionComponent) value); // MedicationKnowledgeRegulatorySubstitutionComponent
          return value;
        case -697920873: // schedule
          this.getSchedule().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1977784607: // maxDispense
          this.maxDispense = (MedicationKnowledgeRegulatoryMaxDispenseComponent) value; // MedicationKnowledgeRegulatoryMaxDispenseComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("regulatoryAuthority")) {
          this.regulatoryAuthority = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("substitution")) {
          this.getSubstitution().add((MedicationKnowledgeRegulatorySubstitutionComponent) value);
        } else if (name.equals("schedule")) {
          this.getSchedule().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("maxDispense")) {
          this.maxDispense = (MedicationKnowledgeRegulatoryMaxDispenseComponent) value; // MedicationKnowledgeRegulatoryMaxDispenseComponent
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 711233419:  return getRegulatoryAuthority();
        case 826147581:  return addSubstitution(); 
        case -697920873:  return addSchedule(); 
        case -1977784607:  return getMaxDispense();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 711233419: /*regulatoryAuthority*/ return new String[] {"Reference"};
        case 826147581: /*substitution*/ return new String[] {};
        case -697920873: /*schedule*/ return new String[] {"CodeableConcept"};
        case -1977784607: /*maxDispense*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("regulatoryAuthority")) {
          this.regulatoryAuthority = new Reference();
          return this.regulatoryAuthority;
        }
        else if (name.equals("substitution")) {
          return addSubstitution();
        }
        else if (name.equals("schedule")) {
          return addSchedule();
        }
        else if (name.equals("maxDispense")) {
          this.maxDispense = new MedicationKnowledgeRegulatoryMaxDispenseComponent();
          return this.maxDispense;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeRegulatoryComponent copy() {
        MedicationKnowledgeRegulatoryComponent dst = new MedicationKnowledgeRegulatoryComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeRegulatoryComponent dst) {
        super.copyValues(dst);
        dst.regulatoryAuthority = regulatoryAuthority == null ? null : regulatoryAuthority.copy();
        if (substitution != null) {
          dst.substitution = new ArrayList<MedicationKnowledgeRegulatorySubstitutionComponent>();
          for (MedicationKnowledgeRegulatorySubstitutionComponent i : substitution)
            dst.substitution.add(i.copy());
        };
        if (schedule != null) {
          dst.schedule = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : schedule)
            dst.schedule.add(i.copy());
        };
        dst.maxDispense = maxDispense == null ? null : maxDispense.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeRegulatoryComponent))
          return false;
        MedicationKnowledgeRegulatoryComponent o = (MedicationKnowledgeRegulatoryComponent) other_;
        return compareDeep(regulatoryAuthority, o.regulatoryAuthority, true) && compareDeep(substitution, o.substitution, true)
           && compareDeep(schedule, o.schedule, true) && compareDeep(maxDispense, o.maxDispense, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeRegulatoryComponent))
          return false;
        MedicationKnowledgeRegulatoryComponent o = (MedicationKnowledgeRegulatoryComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(regulatoryAuthority, substitution
          , schedule, maxDispense);
      }

  public String fhirType() {
    return "MedicationKnowledge.regulatory";

  }

  }

    @Block()
    public static class MedicationKnowledgeRegulatorySubstitutionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Specifies the type of substitution allowed.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Specifies the type of substitution allowed", formalDefinition="Specifies the type of substitution allowed." )
        protected CodeableConcept type;

        /**
         * Specifies if regulation allows for changes in the medication when dispensing.
         */
        @Child(name = "allowed", type = {BooleanType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Specifies if regulation allows for changes in the medication when dispensing", formalDefinition="Specifies if regulation allows for changes in the medication when dispensing." )
        protected BooleanType allowed;

        private static final long serialVersionUID = 396354861L;

    /**
     * Constructor
     */
      public MedicationKnowledgeRegulatorySubstitutionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeRegulatorySubstitutionComponent(CodeableConcept type, boolean allowed) {
        super();
        this.setType(type);
        this.setAllowed(allowed);
      }

        /**
         * @return {@link #type} (Specifies the type of substitution allowed.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeRegulatorySubstitutionComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Specifies the type of substitution allowed.)
         */
        public MedicationKnowledgeRegulatorySubstitutionComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #allowed} (Specifies if regulation allows for changes in the medication when dispensing.). This is the underlying object with id, value and extensions. The accessor "getAllowed" gives direct access to the value
         */
        public BooleanType getAllowedElement() { 
          if (this.allowed == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeRegulatorySubstitutionComponent.allowed");
            else if (Configuration.doAutoCreate())
              this.allowed = new BooleanType(); // bb
          return this.allowed;
        }

        public boolean hasAllowedElement() { 
          return this.allowed != null && !this.allowed.isEmpty();
        }

        public boolean hasAllowed() { 
          return this.allowed != null && !this.allowed.isEmpty();
        }

        /**
         * @param value {@link #allowed} (Specifies if regulation allows for changes in the medication when dispensing.). This is the underlying object with id, value and extensions. The accessor "getAllowed" gives direct access to the value
         */
        public MedicationKnowledgeRegulatorySubstitutionComponent setAllowedElement(BooleanType value) { 
          this.allowed = value;
          return this;
        }

        /**
         * @return Specifies if regulation allows for changes in the medication when dispensing.
         */
        public boolean getAllowed() { 
          return this.allowed == null || this.allowed.isEmpty() ? false : this.allowed.getValue();
        }

        /**
         * @param value Specifies if regulation allows for changes in the medication when dispensing.
         */
        public MedicationKnowledgeRegulatorySubstitutionComponent setAllowed(boolean value) { 
            if (this.allowed == null)
              this.allowed = new BooleanType();
            this.allowed.setValue(value);
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Specifies the type of substitution allowed.", 0, 1, type));
          children.add(new Property("allowed", "boolean", "Specifies if regulation allows for changes in the medication when dispensing.", 0, 1, allowed));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Specifies the type of substitution allowed.", 0, 1, type);
          case -911343192: /*allowed*/  return new Property("allowed", "boolean", "Specifies if regulation allows for changes in the medication when dispensing.", 0, 1, allowed);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -911343192: /*allowed*/ return this.allowed == null ? new Base[0] : new Base[] {this.allowed}; // BooleanType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -911343192: // allowed
          this.allowed = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("allowed")) {
          this.allowed = TypeConvertor.castToBoolean(value); // BooleanType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -911343192:  return getAllowedElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -911343192: /*allowed*/ return new String[] {"boolean"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("allowed")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.regulatory.substitution.allowed");
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeRegulatorySubstitutionComponent copy() {
        MedicationKnowledgeRegulatorySubstitutionComponent dst = new MedicationKnowledgeRegulatorySubstitutionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeRegulatorySubstitutionComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.allowed = allowed == null ? null : allowed.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeRegulatorySubstitutionComponent))
          return false;
        MedicationKnowledgeRegulatorySubstitutionComponent o = (MedicationKnowledgeRegulatorySubstitutionComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(allowed, o.allowed, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeRegulatorySubstitutionComponent))
          return false;
        MedicationKnowledgeRegulatorySubstitutionComponent o = (MedicationKnowledgeRegulatorySubstitutionComponent) other_;
        return compareValues(allowed, o.allowed, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, allowed);
      }

  public String fhirType() {
    return "MedicationKnowledge.regulatory.substitution";

  }

  }

    @Block()
    public static class MedicationKnowledgeRegulatoryMaxDispenseComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The maximum number of units of the medication that can be dispensed.
         */
        @Child(name = "quantity", type = {Quantity.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The maximum number of units of the medication that can be dispensed", formalDefinition="The maximum number of units of the medication that can be dispensed." )
        protected Quantity quantity;

        /**
         * The period that applies to the maximum number of units.
         */
        @Child(name = "period", type = {Duration.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The period that applies to the maximum number of units", formalDefinition="The period that applies to the maximum number of units." )
        protected Duration period;

        private static final long serialVersionUID = -441724185L;

    /**
     * Constructor
     */
      public MedicationKnowledgeRegulatoryMaxDispenseComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeRegulatoryMaxDispenseComponent(Quantity quantity) {
        super();
        this.setQuantity(quantity);
      }

        /**
         * @return {@link #quantity} (The maximum number of units of the medication that can be dispensed.)
         */
        public Quantity getQuantity() { 
          if (this.quantity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeRegulatoryMaxDispenseComponent.quantity");
            else if (Configuration.doAutoCreate())
              this.quantity = new Quantity(); // cc
          return this.quantity;
        }

        public boolean hasQuantity() { 
          return this.quantity != null && !this.quantity.isEmpty();
        }

        /**
         * @param value {@link #quantity} (The maximum number of units of the medication that can be dispensed.)
         */
        public MedicationKnowledgeRegulatoryMaxDispenseComponent setQuantity(Quantity value) { 
          this.quantity = value;
          return this;
        }

        /**
         * @return {@link #period} (The period that applies to the maximum number of units.)
         */
        public Duration getPeriod() { 
          if (this.period == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeRegulatoryMaxDispenseComponent.period");
            else if (Configuration.doAutoCreate())
              this.period = new Duration(); // cc
          return this.period;
        }

        public boolean hasPeriod() { 
          return this.period != null && !this.period.isEmpty();
        }

        /**
         * @param value {@link #period} (The period that applies to the maximum number of units.)
         */
        public MedicationKnowledgeRegulatoryMaxDispenseComponent setPeriod(Duration value) { 
          this.period = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("quantity", "Quantity", "The maximum number of units of the medication that can be dispensed.", 0, 1, quantity));
          children.add(new Property("period", "Duration", "The period that applies to the maximum number of units.", 0, 1, period));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1285004149: /*quantity*/  return new Property("quantity", "Quantity", "The maximum number of units of the medication that can be dispensed.", 0, 1, quantity);
          case -991726143: /*period*/  return new Property("period", "Duration", "The period that applies to the maximum number of units.", 0, 1, period);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1285004149: /*quantity*/ return this.quantity == null ? new Base[0] : new Base[] {this.quantity}; // Quantity
        case -991726143: /*period*/ return this.period == null ? new Base[0] : new Base[] {this.period}; // Duration
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1285004149: // quantity
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -991726143: // period
          this.period = TypeConvertor.castToDuration(value); // Duration
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("quantity")) {
          this.quantity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("period")) {
          this.period = TypeConvertor.castToDuration(value); // Duration
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1285004149:  return getQuantity();
        case -991726143:  return getPeriod();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1285004149: /*quantity*/ return new String[] {"Quantity"};
        case -991726143: /*period*/ return new String[] {"Duration"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("quantity")) {
          this.quantity = new Quantity();
          return this.quantity;
        }
        else if (name.equals("period")) {
          this.period = new Duration();
          return this.period;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeRegulatoryMaxDispenseComponent copy() {
        MedicationKnowledgeRegulatoryMaxDispenseComponent dst = new MedicationKnowledgeRegulatoryMaxDispenseComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeRegulatoryMaxDispenseComponent dst) {
        super.copyValues(dst);
        dst.quantity = quantity == null ? null : quantity.copy();
        dst.period = period == null ? null : period.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeRegulatoryMaxDispenseComponent))
          return false;
        MedicationKnowledgeRegulatoryMaxDispenseComponent o = (MedicationKnowledgeRegulatoryMaxDispenseComponent) other_;
        return compareDeep(quantity, o.quantity, true) && compareDeep(period, o.period, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeRegulatoryMaxDispenseComponent))
          return false;
        MedicationKnowledgeRegulatoryMaxDispenseComponent o = (MedicationKnowledgeRegulatoryMaxDispenseComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(quantity, period);
      }

  public String fhirType() {
    return "MedicationKnowledge.regulatory.maxDispense";

  }

  }

    @Block()
    public static class MedicationKnowledgeKineticCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Code specifying the type of kinetics (e.g. area under the curve, half life period, lethal dose 50.).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code specifying the type of kinetics", formalDefinition="Code specifying the type of kinetics (e.g. area under the curve, half life period, lethal dose 50.)." )
        protected CodeableConcept type;

        /**
         * Description of the characteristic.
         */
        @Child(name = "value", type = {Quantity.class, Duration.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the characteristic", formalDefinition="Description of the characteristic." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public MedicationKnowledgeKineticCharacteristicComponent() {
        super();
      }

        /**
         * @return {@link #type} (Code specifying the type of kinetics (e.g. area under the curve, half life period, lethal dose 50.).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeKineticCharacteristicComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Code specifying the type of kinetics (e.g. area under the curve, half life period, lethal dose 50.).)
         */
        public MedicationKnowledgeKineticCharacteristicComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (Description of the characteristic.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Description of the characteristic.)
         */
        public Quantity getValueQuantity() throws FHIRException { 
          if (this.value == null)
            this.value = new Quantity();
          if (!(this.value instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Quantity) this.value;
        }

        public boolean hasValueQuantity() { 
          return this != null && this.value instanceof Quantity;
        }

        /**
         * @return {@link #value} (Description of the characteristic.)
         */
        public Duration getValueDuration() throws FHIRException { 
          if (this.value == null)
            this.value = new Duration();
          if (!(this.value instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Duration) this.value;
        }

        public boolean hasValueDuration() { 
          return this != null && this.value instanceof Duration;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Description of the characteristic.)
         */
        public MedicationKnowledgeKineticCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof Duration))
            throw new Error("Not the right type for MedicationKnowledge.kineticCharacteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Code specifying the type of kinetics (e.g. area under the curve, half life period, lethal dose 50.).", 0, 1, type));
          children.add(new Property("value[x]", "Quantity|Duration", "Description of the characteristic.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Code specifying the type of kinetics (e.g. area under the curve, half life period, lethal dose 50.).", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Quantity|Duration", "Description of the characteristic.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Quantity|Duration", "Description of the characteristic.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Description of the characteristic.", 0, 1, value);
          case 1558135333: /*valueDuration*/  return new Property("value[x]", "Duration", "Description of the characteristic.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 111972721: // value
          this.value = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getType();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"Quantity", "Duration"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("valueQuantity")) {
          this.value = new Quantity();
          return this.value;
        }
        else if (name.equals("valueDuration")) {
          this.value = new Duration();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeKineticCharacteristicComponent copy() {
        MedicationKnowledgeKineticCharacteristicComponent dst = new MedicationKnowledgeKineticCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeKineticCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeKineticCharacteristicComponent))
          return false;
        MedicationKnowledgeKineticCharacteristicComponent o = (MedicationKnowledgeKineticCharacteristicComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeKineticCharacteristicComponent))
          return false;
        MedicationKnowledgeKineticCharacteristicComponent o = (MedicationKnowledgeKineticCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "MedicationKnowledge.kineticCharacteristic";

  }

  }

    /**
     * Business identifier for this medication.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier for this medication", formalDefinition="Business identifier for this medication." )
    protected List<Identifier> identifier;

    /**
     * A code that specifies this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Code that identifies this medication", formalDefinition="A code that specifies this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
    protected CodeableConcept code;

    /**
     * A code to indicate if the medication is in active use.  The status refers to the validity about the information of the medication and not to its medicinal properties.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | inactive | entered-in-error", formalDefinition="A code to indicate if the medication is in active use.  The status refers to the validity about the information of the medication and not to its medicinal properties." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicationknowledge-status")
    protected Enumeration<MedicationKnowledgeStatusCodes> status;

    /**
     * Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.
     */
    @Child(name = "manufacturer", type = {Organization.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Manufacturer of the item", formalDefinition="Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product." )
    protected Reference manufacturer;

    /**
     * Describes the form of the item.  Powder; tablets; capsule.
     */
    @Child(name = "doseForm", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="powder | tablets | capsule +", formalDefinition="Describes the form of the item.  Powder; tablets; capsule." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-form-codes")
    protected CodeableConcept doseForm;

    /**
     * Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).
     */
    @Child(name = "amount", type = {Quantity.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Amount of drug in package", formalDefinition="Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.)." )
    protected Quantity amount;

    /**
     * Additional names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.
     */
    @Child(name = "synonym", type = {StringType.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional names for a medication", formalDefinition="Additional names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol." )
    protected List<StringType> synonym;

    /**
     * Associated or related knowledge about a medication.
     */
    @Child(name = "relatedMedicationKnowledge", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Associated or related medication information", formalDefinition="Associated or related knowledge about a medication." )
    protected List<MedicationKnowledgeRelatedMedicationKnowledgeComponent> relatedMedicationKnowledge;

    /**
     * Associated or related medications.  For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor).
     */
    @Child(name = "associatedMedication", type = {Medication.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A medication resource that is associated with this medication", formalDefinition="Associated or related medications.  For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor)." )
    protected List<Reference> associatedMedication;

    /**
     * Category of the medication or product (e.g. branded product, therapeutic moeity, generic product, innovator product, etc.).
     */
    @Child(name = "productType", type = {CodeableConcept.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Category of the medication or product", formalDefinition="Category of the medication or product (e.g. branded product, therapeutic moeity, generic product, innovator product, etc.)." )
    protected List<CodeableConcept> productType;

    /**
     * Associated documentation about the medication.
     */
    @Child(name = "monograph", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Associated documentation about the medication", formalDefinition="Associated documentation about the medication." )
    protected List<MedicationKnowledgeMonographComponent> monograph;

    /**
     * Identifies a particular constituent of interest in the product.
     */
    @Child(name = "ingredient", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Active or inactive ingredient", formalDefinition="Identifies a particular constituent of interest in the product." )
    protected List<MedicationKnowledgeIngredientComponent> ingredient;

    /**
     * A device associated with the medication (for example, a drug coated catheter or a drug impregnated dressing).
     */
    @Child(name = "device", type = {Device.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="A device associated with the medication (for example, a drug coated catheter or a drug impregnated dressing)", formalDefinition="A device associated with the medication (for example, a drug coated catheter or a drug impregnated dressing)." )
    protected List<Reference> device;

    /**
     * The instructions for preparing the medication.
     */
    @Child(name = "preparationInstruction", type = {MarkdownType.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The instructions for preparing the medication", formalDefinition="The instructions for preparing the medication." )
    protected MarkdownType preparationInstruction;

    /**
     * The intended or approved route of administration.
     */
    @Child(name = "intendedRoute", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The intended or approved route of administration", formalDefinition="The intended or approved route of administration." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/route-codes")
    protected List<CodeableConcept> intendedRoute;

    /**
     * The price of the medication.
     */
    @Child(name = "cost", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The pricing of the medication", formalDefinition="The price of the medication." )
    protected List<MedicationKnowledgeCostComponent> cost;

    /**
     * The program under which the medication is reviewed.
     */
    @Child(name = "monitoringProgram", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Program under which a medication is reviewed", formalDefinition="The program under which the medication is reviewed." )
    protected List<MedicationKnowledgeMonitoringProgramComponent> monitoringProgram;

    /**
     * Guidelines or protocols that are applicable for the administration of the medication.
     */
    @Child(name = "administrationGuideline", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Guidelines or protocols for administration of the medication", formalDefinition="Guidelines or protocols that are applicable for the administration of the medication." )
    protected List<MedicationKnowledgeAdministrationGuidelineComponent> administrationGuideline;

    /**
     * Categorization of the medication within a formulary or classification system.
     */
    @Child(name = "medicineClassification", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Categorization of the medication within a formulary or classification system", formalDefinition="Categorization of the medication within a formulary or classification system." )
    protected List<MedicationKnowledgeMedicineClassificationComponent> medicineClassification;

    /**
     * Information that only applies to packages (not products).
     */
    @Child(name = "packaging", type = {}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Details about packaged medications", formalDefinition="Information that only applies to packages (not products)." )
    protected MedicationKnowledgePackagingComponent packaging;

    /**
     * Specifies descriptive properties of the medicine, such as color, shape, imprints, etc.
     */
    @Child(name = "drugCharacteristic", type = {}, order=20, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Specifies descriptive properties of the medicine", formalDefinition="Specifies descriptive properties of the medicine, such as color, shape, imprints, etc." )
    protected List<MedicationKnowledgeDrugCharacteristicComponent> drugCharacteristic;

    /**
     * Potential clinical issue with or between medication(s) (for example, drug-drug interaction, drug-disease contraindication, drug-allergy interaction, etc.).
     */
    @Child(name = "clinicalUseIssue", type = {ClinicalUseIssue.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Potential clinical issue with or between medication(s)", formalDefinition="Potential clinical issue with or between medication(s) (for example, drug-drug interaction, drug-disease contraindication, drug-allergy interaction, etc.)." )
    protected List<Reference> clinicalUseIssue;

    /**
     * Regulatory information about a medication.
     */
    @Child(name = "regulatory", type = {}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Regulatory information about a medication", formalDefinition="Regulatory information about a medication." )
    protected List<MedicationKnowledgeRegulatoryComponent> regulatory;

    /**
     * The time course of drug absorption, distribution, metabolism and excretion of a medication from the body.
     */
    @Child(name = "kineticCharacteristic", type = {}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The time course of drug absorption, distribution, metabolism and excretion of a medication from the body", formalDefinition="The time course of drug absorption, distribution, metabolism and excretion of a medication from the body." )
    protected List<MedicationKnowledgeKineticCharacteristicComponent> kineticCharacteristic;

    private static final long serialVersionUID = -489255977L;

  /**
   * Constructor
   */
    public MedicationKnowledge() {
      super();
    }

    /**
     * @return {@link #identifier} (Business identifier for this medication.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setIdentifier(List<Identifier> theIdentifier) { 
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

    public MedicationKnowledge addIdentifier(Identifier t) { //3
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
     * @return {@link #code} (A code that specifies this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationKnowledge.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code that specifies this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.)
     */
    public MedicationKnowledge setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #status} (A code to indicate if the medication is in active use.  The status refers to the validity about the information of the medication and not to its medicinal properties.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<MedicationKnowledgeStatusCodes> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationKnowledge.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<MedicationKnowledgeStatusCodes>(new MedicationKnowledgeStatusCodesEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (A code to indicate if the medication is in active use.  The status refers to the validity about the information of the medication and not to its medicinal properties.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public MedicationKnowledge setStatusElement(Enumeration<MedicationKnowledgeStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code to indicate if the medication is in active use.  The status refers to the validity about the information of the medication and not to its medicinal properties.
     */
    public MedicationKnowledgeStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code to indicate if the medication is in active use.  The status refers to the validity about the information of the medication and not to its medicinal properties.
     */
    public MedicationKnowledge setStatus(MedicationKnowledgeStatusCodes value) { 
      if (value == null)
        this.status = null;
      else {
        if (this.status == null)
          this.status = new Enumeration<MedicationKnowledgeStatusCodes>(new MedicationKnowledgeStatusCodesEnumFactory());
        this.status.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #manufacturer} (Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.)
     */
    public Reference getManufacturer() { 
      if (this.manufacturer == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationKnowledge.manufacturer");
        else if (Configuration.doAutoCreate())
          this.manufacturer = new Reference(); // cc
      return this.manufacturer;
    }

    public boolean hasManufacturer() { 
      return this.manufacturer != null && !this.manufacturer.isEmpty();
    }

    /**
     * @param value {@link #manufacturer} (Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.)
     */
    public MedicationKnowledge setManufacturer(Reference value) { 
      this.manufacturer = value;
      return this;
    }

    /**
     * @return {@link #doseForm} (Describes the form of the item.  Powder; tablets; capsule.)
     */
    public CodeableConcept getDoseForm() { 
      if (this.doseForm == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationKnowledge.doseForm");
        else if (Configuration.doAutoCreate())
          this.doseForm = new CodeableConcept(); // cc
      return this.doseForm;
    }

    public boolean hasDoseForm() { 
      return this.doseForm != null && !this.doseForm.isEmpty();
    }

    /**
     * @param value {@link #doseForm} (Describes the form of the item.  Powder; tablets; capsule.)
     */
    public MedicationKnowledge setDoseForm(CodeableConcept value) { 
      this.doseForm = value;
      return this;
    }

    /**
     * @return {@link #amount} (Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).)
     */
    public Quantity getAmount() { 
      if (this.amount == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationKnowledge.amount");
        else if (Configuration.doAutoCreate())
          this.amount = new Quantity(); // cc
      return this.amount;
    }

    public boolean hasAmount() { 
      return this.amount != null && !this.amount.isEmpty();
    }

    /**
     * @param value {@link #amount} (Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).)
     */
    public MedicationKnowledge setAmount(Quantity value) { 
      this.amount = value;
      return this;
    }

    /**
     * @return {@link #synonym} (Additional names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.)
     */
    public List<StringType> getSynonym() { 
      if (this.synonym == null)
        this.synonym = new ArrayList<StringType>();
      return this.synonym;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setSynonym(List<StringType> theSynonym) { 
      this.synonym = theSynonym;
      return this;
    }

    public boolean hasSynonym() { 
      if (this.synonym == null)
        return false;
      for (StringType item : this.synonym)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #synonym} (Additional names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.)
     */
    public StringType addSynonymElement() {//2 
      StringType t = new StringType();
      if (this.synonym == null)
        this.synonym = new ArrayList<StringType>();
      this.synonym.add(t);
      return t;
    }

    /**
     * @param value {@link #synonym} (Additional names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.)
     */
    public MedicationKnowledge addSynonym(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.synonym == null)
        this.synonym = new ArrayList<StringType>();
      this.synonym.add(t);
      return this;
    }

    /**
     * @param value {@link #synonym} (Additional names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.)
     */
    public boolean hasSynonym(String value) { 
      if (this.synonym == null)
        return false;
      for (StringType v : this.synonym)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #relatedMedicationKnowledge} (Associated or related knowledge about a medication.)
     */
    public List<MedicationKnowledgeRelatedMedicationKnowledgeComponent> getRelatedMedicationKnowledge() { 
      if (this.relatedMedicationKnowledge == null)
        this.relatedMedicationKnowledge = new ArrayList<MedicationKnowledgeRelatedMedicationKnowledgeComponent>();
      return this.relatedMedicationKnowledge;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setRelatedMedicationKnowledge(List<MedicationKnowledgeRelatedMedicationKnowledgeComponent> theRelatedMedicationKnowledge) { 
      this.relatedMedicationKnowledge = theRelatedMedicationKnowledge;
      return this;
    }

    public boolean hasRelatedMedicationKnowledge() { 
      if (this.relatedMedicationKnowledge == null)
        return false;
      for (MedicationKnowledgeRelatedMedicationKnowledgeComponent item : this.relatedMedicationKnowledge)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeRelatedMedicationKnowledgeComponent addRelatedMedicationKnowledge() { //3
      MedicationKnowledgeRelatedMedicationKnowledgeComponent t = new MedicationKnowledgeRelatedMedicationKnowledgeComponent();
      if (this.relatedMedicationKnowledge == null)
        this.relatedMedicationKnowledge = new ArrayList<MedicationKnowledgeRelatedMedicationKnowledgeComponent>();
      this.relatedMedicationKnowledge.add(t);
      return t;
    }

    public MedicationKnowledge addRelatedMedicationKnowledge(MedicationKnowledgeRelatedMedicationKnowledgeComponent t) { //3
      if (t == null)
        return this;
      if (this.relatedMedicationKnowledge == null)
        this.relatedMedicationKnowledge = new ArrayList<MedicationKnowledgeRelatedMedicationKnowledgeComponent>();
      this.relatedMedicationKnowledge.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedMedicationKnowledge}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeRelatedMedicationKnowledgeComponent getRelatedMedicationKnowledgeFirstRep() { 
      if (getRelatedMedicationKnowledge().isEmpty()) {
        addRelatedMedicationKnowledge();
      }
      return getRelatedMedicationKnowledge().get(0);
    }

    /**
     * @return {@link #associatedMedication} (Associated or related medications.  For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor).)
     */
    public List<Reference> getAssociatedMedication() { 
      if (this.associatedMedication == null)
        this.associatedMedication = new ArrayList<Reference>();
      return this.associatedMedication;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setAssociatedMedication(List<Reference> theAssociatedMedication) { 
      this.associatedMedication = theAssociatedMedication;
      return this;
    }

    public boolean hasAssociatedMedication() { 
      if (this.associatedMedication == null)
        return false;
      for (Reference item : this.associatedMedication)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addAssociatedMedication() { //3
      Reference t = new Reference();
      if (this.associatedMedication == null)
        this.associatedMedication = new ArrayList<Reference>();
      this.associatedMedication.add(t);
      return t;
    }

    public MedicationKnowledge addAssociatedMedication(Reference t) { //3
      if (t == null)
        return this;
      if (this.associatedMedication == null)
        this.associatedMedication = new ArrayList<Reference>();
      this.associatedMedication.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #associatedMedication}, creating it if it does not already exist {3}
     */
    public Reference getAssociatedMedicationFirstRep() { 
      if (getAssociatedMedication().isEmpty()) {
        addAssociatedMedication();
      }
      return getAssociatedMedication().get(0);
    }

    /**
     * @return {@link #productType} (Category of the medication or product (e.g. branded product, therapeutic moeity, generic product, innovator product, etc.).)
     */
    public List<CodeableConcept> getProductType() { 
      if (this.productType == null)
        this.productType = new ArrayList<CodeableConcept>();
      return this.productType;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setProductType(List<CodeableConcept> theProductType) { 
      this.productType = theProductType;
      return this;
    }

    public boolean hasProductType() { 
      if (this.productType == null)
        return false;
      for (CodeableConcept item : this.productType)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addProductType() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.productType == null)
        this.productType = new ArrayList<CodeableConcept>();
      this.productType.add(t);
      return t;
    }

    public MedicationKnowledge addProductType(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.productType == null)
        this.productType = new ArrayList<CodeableConcept>();
      this.productType.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #productType}, creating it if it does not already exist {3}
     */
    public CodeableConcept getProductTypeFirstRep() { 
      if (getProductType().isEmpty()) {
        addProductType();
      }
      return getProductType().get(0);
    }

    /**
     * @return {@link #monograph} (Associated documentation about the medication.)
     */
    public List<MedicationKnowledgeMonographComponent> getMonograph() { 
      if (this.monograph == null)
        this.monograph = new ArrayList<MedicationKnowledgeMonographComponent>();
      return this.monograph;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setMonograph(List<MedicationKnowledgeMonographComponent> theMonograph) { 
      this.monograph = theMonograph;
      return this;
    }

    public boolean hasMonograph() { 
      if (this.monograph == null)
        return false;
      for (MedicationKnowledgeMonographComponent item : this.monograph)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeMonographComponent addMonograph() { //3
      MedicationKnowledgeMonographComponent t = new MedicationKnowledgeMonographComponent();
      if (this.monograph == null)
        this.monograph = new ArrayList<MedicationKnowledgeMonographComponent>();
      this.monograph.add(t);
      return t;
    }

    public MedicationKnowledge addMonograph(MedicationKnowledgeMonographComponent t) { //3
      if (t == null)
        return this;
      if (this.monograph == null)
        this.monograph = new ArrayList<MedicationKnowledgeMonographComponent>();
      this.monograph.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #monograph}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeMonographComponent getMonographFirstRep() { 
      if (getMonograph().isEmpty()) {
        addMonograph();
      }
      return getMonograph().get(0);
    }

    /**
     * @return {@link #ingredient} (Identifies a particular constituent of interest in the product.)
     */
    public List<MedicationKnowledgeIngredientComponent> getIngredient() { 
      if (this.ingredient == null)
        this.ingredient = new ArrayList<MedicationKnowledgeIngredientComponent>();
      return this.ingredient;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setIngredient(List<MedicationKnowledgeIngredientComponent> theIngredient) { 
      this.ingredient = theIngredient;
      return this;
    }

    public boolean hasIngredient() { 
      if (this.ingredient == null)
        return false;
      for (MedicationKnowledgeIngredientComponent item : this.ingredient)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeIngredientComponent addIngredient() { //3
      MedicationKnowledgeIngredientComponent t = new MedicationKnowledgeIngredientComponent();
      if (this.ingredient == null)
        this.ingredient = new ArrayList<MedicationKnowledgeIngredientComponent>();
      this.ingredient.add(t);
      return t;
    }

    public MedicationKnowledge addIngredient(MedicationKnowledgeIngredientComponent t) { //3
      if (t == null)
        return this;
      if (this.ingredient == null)
        this.ingredient = new ArrayList<MedicationKnowledgeIngredientComponent>();
      this.ingredient.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #ingredient}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeIngredientComponent getIngredientFirstRep() { 
      if (getIngredient().isEmpty()) {
        addIngredient();
      }
      return getIngredient().get(0);
    }

    /**
     * @return {@link #device} (A device associated with the medication (for example, a drug coated catheter or a drug impregnated dressing).)
     */
    public List<Reference> getDevice() { 
      if (this.device == null)
        this.device = new ArrayList<Reference>();
      return this.device;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setDevice(List<Reference> theDevice) { 
      this.device = theDevice;
      return this;
    }

    public boolean hasDevice() { 
      if (this.device == null)
        return false;
      for (Reference item : this.device)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addDevice() { //3
      Reference t = new Reference();
      if (this.device == null)
        this.device = new ArrayList<Reference>();
      this.device.add(t);
      return t;
    }

    public MedicationKnowledge addDevice(Reference t) { //3
      if (t == null)
        return this;
      if (this.device == null)
        this.device = new ArrayList<Reference>();
      this.device.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #device}, creating it if it does not already exist {3}
     */
    public Reference getDeviceFirstRep() { 
      if (getDevice().isEmpty()) {
        addDevice();
      }
      return getDevice().get(0);
    }

    /**
     * @return {@link #preparationInstruction} (The instructions for preparing the medication.). This is the underlying object with id, value and extensions. The accessor "getPreparationInstruction" gives direct access to the value
     */
    public MarkdownType getPreparationInstructionElement() { 
      if (this.preparationInstruction == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationKnowledge.preparationInstruction");
        else if (Configuration.doAutoCreate())
          this.preparationInstruction = new MarkdownType(); // bb
      return this.preparationInstruction;
    }

    public boolean hasPreparationInstructionElement() { 
      return this.preparationInstruction != null && !this.preparationInstruction.isEmpty();
    }

    public boolean hasPreparationInstruction() { 
      return this.preparationInstruction != null && !this.preparationInstruction.isEmpty();
    }

    /**
     * @param value {@link #preparationInstruction} (The instructions for preparing the medication.). This is the underlying object with id, value and extensions. The accessor "getPreparationInstruction" gives direct access to the value
     */
    public MedicationKnowledge setPreparationInstructionElement(MarkdownType value) { 
      this.preparationInstruction = value;
      return this;
    }

    /**
     * @return The instructions for preparing the medication.
     */
    public String getPreparationInstruction() { 
      return this.preparationInstruction == null ? null : this.preparationInstruction.getValue();
    }

    /**
     * @param value The instructions for preparing the medication.
     */
    public MedicationKnowledge setPreparationInstruction(String value) { 
      if (value == null)
        this.preparationInstruction = null;
      else {
        if (this.preparationInstruction == null)
          this.preparationInstruction = new MarkdownType();
        this.preparationInstruction.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #intendedRoute} (The intended or approved route of administration.)
     */
    public List<CodeableConcept> getIntendedRoute() { 
      if (this.intendedRoute == null)
        this.intendedRoute = new ArrayList<CodeableConcept>();
      return this.intendedRoute;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setIntendedRoute(List<CodeableConcept> theIntendedRoute) { 
      this.intendedRoute = theIntendedRoute;
      return this;
    }

    public boolean hasIntendedRoute() { 
      if (this.intendedRoute == null)
        return false;
      for (CodeableConcept item : this.intendedRoute)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addIntendedRoute() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.intendedRoute == null)
        this.intendedRoute = new ArrayList<CodeableConcept>();
      this.intendedRoute.add(t);
      return t;
    }

    public MedicationKnowledge addIntendedRoute(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.intendedRoute == null)
        this.intendedRoute = new ArrayList<CodeableConcept>();
      this.intendedRoute.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #intendedRoute}, creating it if it does not already exist {3}
     */
    public CodeableConcept getIntendedRouteFirstRep() { 
      if (getIntendedRoute().isEmpty()) {
        addIntendedRoute();
      }
      return getIntendedRoute().get(0);
    }

    /**
     * @return {@link #cost} (The price of the medication.)
     */
    public List<MedicationKnowledgeCostComponent> getCost() { 
      if (this.cost == null)
        this.cost = new ArrayList<MedicationKnowledgeCostComponent>();
      return this.cost;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setCost(List<MedicationKnowledgeCostComponent> theCost) { 
      this.cost = theCost;
      return this;
    }

    public boolean hasCost() { 
      if (this.cost == null)
        return false;
      for (MedicationKnowledgeCostComponent item : this.cost)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeCostComponent addCost() { //3
      MedicationKnowledgeCostComponent t = new MedicationKnowledgeCostComponent();
      if (this.cost == null)
        this.cost = new ArrayList<MedicationKnowledgeCostComponent>();
      this.cost.add(t);
      return t;
    }

    public MedicationKnowledge addCost(MedicationKnowledgeCostComponent t) { //3
      if (t == null)
        return this;
      if (this.cost == null)
        this.cost = new ArrayList<MedicationKnowledgeCostComponent>();
      this.cost.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #cost}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeCostComponent getCostFirstRep() { 
      if (getCost().isEmpty()) {
        addCost();
      }
      return getCost().get(0);
    }

    /**
     * @return {@link #monitoringProgram} (The program under which the medication is reviewed.)
     */
    public List<MedicationKnowledgeMonitoringProgramComponent> getMonitoringProgram() { 
      if (this.monitoringProgram == null)
        this.monitoringProgram = new ArrayList<MedicationKnowledgeMonitoringProgramComponent>();
      return this.monitoringProgram;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setMonitoringProgram(List<MedicationKnowledgeMonitoringProgramComponent> theMonitoringProgram) { 
      this.monitoringProgram = theMonitoringProgram;
      return this;
    }

    public boolean hasMonitoringProgram() { 
      if (this.monitoringProgram == null)
        return false;
      for (MedicationKnowledgeMonitoringProgramComponent item : this.monitoringProgram)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeMonitoringProgramComponent addMonitoringProgram() { //3
      MedicationKnowledgeMonitoringProgramComponent t = new MedicationKnowledgeMonitoringProgramComponent();
      if (this.monitoringProgram == null)
        this.monitoringProgram = new ArrayList<MedicationKnowledgeMonitoringProgramComponent>();
      this.monitoringProgram.add(t);
      return t;
    }

    public MedicationKnowledge addMonitoringProgram(MedicationKnowledgeMonitoringProgramComponent t) { //3
      if (t == null)
        return this;
      if (this.monitoringProgram == null)
        this.monitoringProgram = new ArrayList<MedicationKnowledgeMonitoringProgramComponent>();
      this.monitoringProgram.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #monitoringProgram}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeMonitoringProgramComponent getMonitoringProgramFirstRep() { 
      if (getMonitoringProgram().isEmpty()) {
        addMonitoringProgram();
      }
      return getMonitoringProgram().get(0);
    }

    /**
     * @return {@link #administrationGuideline} (Guidelines or protocols that are applicable for the administration of the medication.)
     */
    public List<MedicationKnowledgeAdministrationGuidelineComponent> getAdministrationGuideline() { 
      if (this.administrationGuideline == null)
        this.administrationGuideline = new ArrayList<MedicationKnowledgeAdministrationGuidelineComponent>();
      return this.administrationGuideline;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setAdministrationGuideline(List<MedicationKnowledgeAdministrationGuidelineComponent> theAdministrationGuideline) { 
      this.administrationGuideline = theAdministrationGuideline;
      return this;
    }

    public boolean hasAdministrationGuideline() { 
      if (this.administrationGuideline == null)
        return false;
      for (MedicationKnowledgeAdministrationGuidelineComponent item : this.administrationGuideline)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeAdministrationGuidelineComponent addAdministrationGuideline() { //3
      MedicationKnowledgeAdministrationGuidelineComponent t = new MedicationKnowledgeAdministrationGuidelineComponent();
      if (this.administrationGuideline == null)
        this.administrationGuideline = new ArrayList<MedicationKnowledgeAdministrationGuidelineComponent>();
      this.administrationGuideline.add(t);
      return t;
    }

    public MedicationKnowledge addAdministrationGuideline(MedicationKnowledgeAdministrationGuidelineComponent t) { //3
      if (t == null)
        return this;
      if (this.administrationGuideline == null)
        this.administrationGuideline = new ArrayList<MedicationKnowledgeAdministrationGuidelineComponent>();
      this.administrationGuideline.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #administrationGuideline}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeAdministrationGuidelineComponent getAdministrationGuidelineFirstRep() { 
      if (getAdministrationGuideline().isEmpty()) {
        addAdministrationGuideline();
      }
      return getAdministrationGuideline().get(0);
    }

    /**
     * @return {@link #medicineClassification} (Categorization of the medication within a formulary or classification system.)
     */
    public List<MedicationKnowledgeMedicineClassificationComponent> getMedicineClassification() { 
      if (this.medicineClassification == null)
        this.medicineClassification = new ArrayList<MedicationKnowledgeMedicineClassificationComponent>();
      return this.medicineClassification;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setMedicineClassification(List<MedicationKnowledgeMedicineClassificationComponent> theMedicineClassification) { 
      this.medicineClassification = theMedicineClassification;
      return this;
    }

    public boolean hasMedicineClassification() { 
      if (this.medicineClassification == null)
        return false;
      for (MedicationKnowledgeMedicineClassificationComponent item : this.medicineClassification)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeMedicineClassificationComponent addMedicineClassification() { //3
      MedicationKnowledgeMedicineClassificationComponent t = new MedicationKnowledgeMedicineClassificationComponent();
      if (this.medicineClassification == null)
        this.medicineClassification = new ArrayList<MedicationKnowledgeMedicineClassificationComponent>();
      this.medicineClassification.add(t);
      return t;
    }

    public MedicationKnowledge addMedicineClassification(MedicationKnowledgeMedicineClassificationComponent t) { //3
      if (t == null)
        return this;
      if (this.medicineClassification == null)
        this.medicineClassification = new ArrayList<MedicationKnowledgeMedicineClassificationComponent>();
      this.medicineClassification.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #medicineClassification}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeMedicineClassificationComponent getMedicineClassificationFirstRep() { 
      if (getMedicineClassification().isEmpty()) {
        addMedicineClassification();
      }
      return getMedicineClassification().get(0);
    }

    /**
     * @return {@link #packaging} (Information that only applies to packages (not products).)
     */
    public MedicationKnowledgePackagingComponent getPackaging() { 
      if (this.packaging == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationKnowledge.packaging");
        else if (Configuration.doAutoCreate())
          this.packaging = new MedicationKnowledgePackagingComponent(); // cc
      return this.packaging;
    }

    public boolean hasPackaging() { 
      return this.packaging != null && !this.packaging.isEmpty();
    }

    /**
     * @param value {@link #packaging} (Information that only applies to packages (not products).)
     */
    public MedicationKnowledge setPackaging(MedicationKnowledgePackagingComponent value) { 
      this.packaging = value;
      return this;
    }

    /**
     * @return {@link #drugCharacteristic} (Specifies descriptive properties of the medicine, such as color, shape, imprints, etc.)
     */
    public List<MedicationKnowledgeDrugCharacteristicComponent> getDrugCharacteristic() { 
      if (this.drugCharacteristic == null)
        this.drugCharacteristic = new ArrayList<MedicationKnowledgeDrugCharacteristicComponent>();
      return this.drugCharacteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setDrugCharacteristic(List<MedicationKnowledgeDrugCharacteristicComponent> theDrugCharacteristic) { 
      this.drugCharacteristic = theDrugCharacteristic;
      return this;
    }

    public boolean hasDrugCharacteristic() { 
      if (this.drugCharacteristic == null)
        return false;
      for (MedicationKnowledgeDrugCharacteristicComponent item : this.drugCharacteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeDrugCharacteristicComponent addDrugCharacteristic() { //3
      MedicationKnowledgeDrugCharacteristicComponent t = new MedicationKnowledgeDrugCharacteristicComponent();
      if (this.drugCharacteristic == null)
        this.drugCharacteristic = new ArrayList<MedicationKnowledgeDrugCharacteristicComponent>();
      this.drugCharacteristic.add(t);
      return t;
    }

    public MedicationKnowledge addDrugCharacteristic(MedicationKnowledgeDrugCharacteristicComponent t) { //3
      if (t == null)
        return this;
      if (this.drugCharacteristic == null)
        this.drugCharacteristic = new ArrayList<MedicationKnowledgeDrugCharacteristicComponent>();
      this.drugCharacteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #drugCharacteristic}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeDrugCharacteristicComponent getDrugCharacteristicFirstRep() { 
      if (getDrugCharacteristic().isEmpty()) {
        addDrugCharacteristic();
      }
      return getDrugCharacteristic().get(0);
    }

    /**
     * @return {@link #clinicalUseIssue} (Potential clinical issue with or between medication(s) (for example, drug-drug interaction, drug-disease contraindication, drug-allergy interaction, etc.).)
     */
    public List<Reference> getClinicalUseIssue() { 
      if (this.clinicalUseIssue == null)
        this.clinicalUseIssue = new ArrayList<Reference>();
      return this.clinicalUseIssue;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setClinicalUseIssue(List<Reference> theClinicalUseIssue) { 
      this.clinicalUseIssue = theClinicalUseIssue;
      return this;
    }

    public boolean hasClinicalUseIssue() { 
      if (this.clinicalUseIssue == null)
        return false;
      for (Reference item : this.clinicalUseIssue)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addClinicalUseIssue() { //3
      Reference t = new Reference();
      if (this.clinicalUseIssue == null)
        this.clinicalUseIssue = new ArrayList<Reference>();
      this.clinicalUseIssue.add(t);
      return t;
    }

    public MedicationKnowledge addClinicalUseIssue(Reference t) { //3
      if (t == null)
        return this;
      if (this.clinicalUseIssue == null)
        this.clinicalUseIssue = new ArrayList<Reference>();
      this.clinicalUseIssue.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #clinicalUseIssue}, creating it if it does not already exist {3}
     */
    public Reference getClinicalUseIssueFirstRep() { 
      if (getClinicalUseIssue().isEmpty()) {
        addClinicalUseIssue();
      }
      return getClinicalUseIssue().get(0);
    }

    /**
     * @return {@link #regulatory} (Regulatory information about a medication.)
     */
    public List<MedicationKnowledgeRegulatoryComponent> getRegulatory() { 
      if (this.regulatory == null)
        this.regulatory = new ArrayList<MedicationKnowledgeRegulatoryComponent>();
      return this.regulatory;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setRegulatory(List<MedicationKnowledgeRegulatoryComponent> theRegulatory) { 
      this.regulatory = theRegulatory;
      return this;
    }

    public boolean hasRegulatory() { 
      if (this.regulatory == null)
        return false;
      for (MedicationKnowledgeRegulatoryComponent item : this.regulatory)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeRegulatoryComponent addRegulatory() { //3
      MedicationKnowledgeRegulatoryComponent t = new MedicationKnowledgeRegulatoryComponent();
      if (this.regulatory == null)
        this.regulatory = new ArrayList<MedicationKnowledgeRegulatoryComponent>();
      this.regulatory.add(t);
      return t;
    }

    public MedicationKnowledge addRegulatory(MedicationKnowledgeRegulatoryComponent t) { //3
      if (t == null)
        return this;
      if (this.regulatory == null)
        this.regulatory = new ArrayList<MedicationKnowledgeRegulatoryComponent>();
      this.regulatory.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #regulatory}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeRegulatoryComponent getRegulatoryFirstRep() { 
      if (getRegulatory().isEmpty()) {
        addRegulatory();
      }
      return getRegulatory().get(0);
    }

    /**
     * @return {@link #kineticCharacteristic} (The time course of drug absorption, distribution, metabolism and excretion of a medication from the body.)
     */
    public List<MedicationKnowledgeKineticCharacteristicComponent> getKineticCharacteristic() { 
      if (this.kineticCharacteristic == null)
        this.kineticCharacteristic = new ArrayList<MedicationKnowledgeKineticCharacteristicComponent>();
      return this.kineticCharacteristic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setKineticCharacteristic(List<MedicationKnowledgeKineticCharacteristicComponent> theKineticCharacteristic) { 
      this.kineticCharacteristic = theKineticCharacteristic;
      return this;
    }

    public boolean hasKineticCharacteristic() { 
      if (this.kineticCharacteristic == null)
        return false;
      for (MedicationKnowledgeKineticCharacteristicComponent item : this.kineticCharacteristic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeKineticCharacteristicComponent addKineticCharacteristic() { //3
      MedicationKnowledgeKineticCharacteristicComponent t = new MedicationKnowledgeKineticCharacteristicComponent();
      if (this.kineticCharacteristic == null)
        this.kineticCharacteristic = new ArrayList<MedicationKnowledgeKineticCharacteristicComponent>();
      this.kineticCharacteristic.add(t);
      return t;
    }

    public MedicationKnowledge addKineticCharacteristic(MedicationKnowledgeKineticCharacteristicComponent t) { //3
      if (t == null)
        return this;
      if (this.kineticCharacteristic == null)
        this.kineticCharacteristic = new ArrayList<MedicationKnowledgeKineticCharacteristicComponent>();
      this.kineticCharacteristic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #kineticCharacteristic}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeKineticCharacteristicComponent getKineticCharacteristicFirstRep() { 
      if (getKineticCharacteristic().isEmpty()) {
        addKineticCharacteristic();
      }
      return getKineticCharacteristic().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this medication.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("code", "CodeableConcept", "A code that specifies this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.", 0, 1, code));
        children.add(new Property("status", "code", "A code to indicate if the medication is in active use.  The status refers to the validity about the information of the medication and not to its medicinal properties.", 0, 1, status));
        children.add(new Property("manufacturer", "Reference(Organization)", "Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.", 0, 1, manufacturer));
        children.add(new Property("doseForm", "CodeableConcept", "Describes the form of the item.  Powder; tablets; capsule.", 0, 1, doseForm));
        children.add(new Property("amount", "Quantity", "Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).", 0, 1, amount));
        children.add(new Property("synonym", "string", "Additional names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.", 0, java.lang.Integer.MAX_VALUE, synonym));
        children.add(new Property("relatedMedicationKnowledge", "", "Associated or related knowledge about a medication.", 0, java.lang.Integer.MAX_VALUE, relatedMedicationKnowledge));
        children.add(new Property("associatedMedication", "Reference(Medication)", "Associated or related medications.  For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor).", 0, java.lang.Integer.MAX_VALUE, associatedMedication));
        children.add(new Property("productType", "CodeableConcept", "Category of the medication or product (e.g. branded product, therapeutic moeity, generic product, innovator product, etc.).", 0, java.lang.Integer.MAX_VALUE, productType));
        children.add(new Property("monograph", "", "Associated documentation about the medication.", 0, java.lang.Integer.MAX_VALUE, monograph));
        children.add(new Property("ingredient", "", "Identifies a particular constituent of interest in the product.", 0, java.lang.Integer.MAX_VALUE, ingredient));
        children.add(new Property("device", "Reference(Device)", "A device associated with the medication (for example, a drug coated catheter or a drug impregnated dressing).", 0, java.lang.Integer.MAX_VALUE, device));
        children.add(new Property("preparationInstruction", "markdown", "The instructions for preparing the medication.", 0, 1, preparationInstruction));
        children.add(new Property("intendedRoute", "CodeableConcept", "The intended or approved route of administration.", 0, java.lang.Integer.MAX_VALUE, intendedRoute));
        children.add(new Property("cost", "", "The price of the medication.", 0, java.lang.Integer.MAX_VALUE, cost));
        children.add(new Property("monitoringProgram", "", "The program under which the medication is reviewed.", 0, java.lang.Integer.MAX_VALUE, monitoringProgram));
        children.add(new Property("administrationGuideline", "", "Guidelines or protocols that are applicable for the administration of the medication.", 0, java.lang.Integer.MAX_VALUE, administrationGuideline));
        children.add(new Property("medicineClassification", "", "Categorization of the medication within a formulary or classification system.", 0, java.lang.Integer.MAX_VALUE, medicineClassification));
        children.add(new Property("packaging", "", "Information that only applies to packages (not products).", 0, 1, packaging));
        children.add(new Property("drugCharacteristic", "", "Specifies descriptive properties of the medicine, such as color, shape, imprints, etc.", 0, java.lang.Integer.MAX_VALUE, drugCharacteristic));
        children.add(new Property("clinicalUseIssue", "Reference(ClinicalUseIssue)", "Potential clinical issue with or between medication(s) (for example, drug-drug interaction, drug-disease contraindication, drug-allergy interaction, etc.).", 0, java.lang.Integer.MAX_VALUE, clinicalUseIssue));
        children.add(new Property("regulatory", "", "Regulatory information about a medication.", 0, java.lang.Integer.MAX_VALUE, regulatory));
        children.add(new Property("kineticCharacteristic", "", "The time course of drug absorption, distribution, metabolism and excretion of a medication from the body.", 0, java.lang.Integer.MAX_VALUE, kineticCharacteristic));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this medication.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that specifies this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.", 0, 1, code);
        case -892481550: /*status*/  return new Property("status", "code", "A code to indicate if the medication is in active use.  The status refers to the validity about the information of the medication and not to its medicinal properties.", 0, 1, status);
        case -1969347631: /*manufacturer*/  return new Property("manufacturer", "Reference(Organization)", "Describes the details of the manufacturer of the medication product.  This is not intended to represent the distributor of a medication product.", 0, 1, manufacturer);
        case 1303858817: /*doseForm*/  return new Property("doseForm", "CodeableConcept", "Describes the form of the item.  Powder; tablets; capsule.", 0, 1, doseForm);
        case -1413853096: /*amount*/  return new Property("amount", "Quantity", "Specific amount of the drug in the packaged product.  For example, when specifying a product that has the same strength (For example, Insulin glargine 100 unit per mL solution for injection), this attribute provides additional clarification of the package amount (For example, 3 mL, 10mL, etc.).", 0, 1, amount);
        case -1742128133: /*synonym*/  return new Property("synonym", "string", "Additional names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.", 0, java.lang.Integer.MAX_VALUE, synonym);
        case 723067972: /*relatedMedicationKnowledge*/  return new Property("relatedMedicationKnowledge", "", "Associated or related knowledge about a medication.", 0, java.lang.Integer.MAX_VALUE, relatedMedicationKnowledge);
        case 1312779381: /*associatedMedication*/  return new Property("associatedMedication", "Reference(Medication)", "Associated or related medications.  For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor).", 0, java.lang.Integer.MAX_VALUE, associatedMedication);
        case -1491615543: /*productType*/  return new Property("productType", "CodeableConcept", "Category of the medication or product (e.g. branded product, therapeutic moeity, generic product, innovator product, etc.).", 0, java.lang.Integer.MAX_VALUE, productType);
        case -1442980789: /*monograph*/  return new Property("monograph", "", "Associated documentation about the medication.", 0, java.lang.Integer.MAX_VALUE, monograph);
        case -206409263: /*ingredient*/  return new Property("ingredient", "", "Identifies a particular constituent of interest in the product.", 0, java.lang.Integer.MAX_VALUE, ingredient);
        case -1335157162: /*device*/  return new Property("device", "Reference(Device)", "A device associated with the medication (for example, a drug coated catheter or a drug impregnated dressing).", 0, java.lang.Integer.MAX_VALUE, device);
        case 1025456503: /*preparationInstruction*/  return new Property("preparationInstruction", "markdown", "The instructions for preparing the medication.", 0, 1, preparationInstruction);
        case -767798050: /*intendedRoute*/  return new Property("intendedRoute", "CodeableConcept", "The intended or approved route of administration.", 0, java.lang.Integer.MAX_VALUE, intendedRoute);
        case 3059661: /*cost*/  return new Property("cost", "", "The price of the medication.", 0, java.lang.Integer.MAX_VALUE, cost);
        case 569848092: /*monitoringProgram*/  return new Property("monitoringProgram", "", "The program under which the medication is reviewed.", 0, java.lang.Integer.MAX_VALUE, monitoringProgram);
        case -815253966: /*administrationGuideline*/  return new Property("administrationGuideline", "", "Guidelines or protocols that are applicable for the administration of the medication.", 0, java.lang.Integer.MAX_VALUE, administrationGuideline);
        case 1791551680: /*medicineClassification*/  return new Property("medicineClassification", "", "Categorization of the medication within a formulary or classification system.", 0, java.lang.Integer.MAX_VALUE, medicineClassification);
        case 1802065795: /*packaging*/  return new Property("packaging", "", "Information that only applies to packages (not products).", 0, 1, packaging);
        case -844126885: /*drugCharacteristic*/  return new Property("drugCharacteristic", "", "Specifies descriptive properties of the medicine, such as color, shape, imprints, etc.", 0, java.lang.Integer.MAX_VALUE, drugCharacteristic);
        case 251885509: /*clinicalUseIssue*/  return new Property("clinicalUseIssue", "Reference(ClinicalUseIssue)", "Potential clinical issue with or between medication(s) (for example, drug-drug interaction, drug-disease contraindication, drug-allergy interaction, etc.).", 0, java.lang.Integer.MAX_VALUE, clinicalUseIssue);
        case -27327848: /*regulatory*/  return new Property("regulatory", "", "Regulatory information about a medication.", 0, java.lang.Integer.MAX_VALUE, regulatory);
        case -573129004: /*kineticCharacteristic*/  return new Property("kineticCharacteristic", "", "The time course of drug absorption, distribution, metabolism and excretion of a medication from the body.", 0, java.lang.Integer.MAX_VALUE, kineticCharacteristic);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<MedicationKnowledgeStatusCodes>
        case -1969347631: /*manufacturer*/ return this.manufacturer == null ? new Base[0] : new Base[] {this.manufacturer}; // Reference
        case 1303858817: /*doseForm*/ return this.doseForm == null ? new Base[0] : new Base[] {this.doseForm}; // CodeableConcept
        case -1413853096: /*amount*/ return this.amount == null ? new Base[0] : new Base[] {this.amount}; // Quantity
        case -1742128133: /*synonym*/ return this.synonym == null ? new Base[0] : this.synonym.toArray(new Base[this.synonym.size()]); // StringType
        case 723067972: /*relatedMedicationKnowledge*/ return this.relatedMedicationKnowledge == null ? new Base[0] : this.relatedMedicationKnowledge.toArray(new Base[this.relatedMedicationKnowledge.size()]); // MedicationKnowledgeRelatedMedicationKnowledgeComponent
        case 1312779381: /*associatedMedication*/ return this.associatedMedication == null ? new Base[0] : this.associatedMedication.toArray(new Base[this.associatedMedication.size()]); // Reference
        case -1491615543: /*productType*/ return this.productType == null ? new Base[0] : this.productType.toArray(new Base[this.productType.size()]); // CodeableConcept
        case -1442980789: /*monograph*/ return this.monograph == null ? new Base[0] : this.monograph.toArray(new Base[this.monograph.size()]); // MedicationKnowledgeMonographComponent
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // MedicationKnowledgeIngredientComponent
        case -1335157162: /*device*/ return this.device == null ? new Base[0] : this.device.toArray(new Base[this.device.size()]); // Reference
        case 1025456503: /*preparationInstruction*/ return this.preparationInstruction == null ? new Base[0] : new Base[] {this.preparationInstruction}; // MarkdownType
        case -767798050: /*intendedRoute*/ return this.intendedRoute == null ? new Base[0] : this.intendedRoute.toArray(new Base[this.intendedRoute.size()]); // CodeableConcept
        case 3059661: /*cost*/ return this.cost == null ? new Base[0] : this.cost.toArray(new Base[this.cost.size()]); // MedicationKnowledgeCostComponent
        case 569848092: /*monitoringProgram*/ return this.monitoringProgram == null ? new Base[0] : this.monitoringProgram.toArray(new Base[this.monitoringProgram.size()]); // MedicationKnowledgeMonitoringProgramComponent
        case -815253966: /*administrationGuideline*/ return this.administrationGuideline == null ? new Base[0] : this.administrationGuideline.toArray(new Base[this.administrationGuideline.size()]); // MedicationKnowledgeAdministrationGuidelineComponent
        case 1791551680: /*medicineClassification*/ return this.medicineClassification == null ? new Base[0] : this.medicineClassification.toArray(new Base[this.medicineClassification.size()]); // MedicationKnowledgeMedicineClassificationComponent
        case 1802065795: /*packaging*/ return this.packaging == null ? new Base[0] : new Base[] {this.packaging}; // MedicationKnowledgePackagingComponent
        case -844126885: /*drugCharacteristic*/ return this.drugCharacteristic == null ? new Base[0] : this.drugCharacteristic.toArray(new Base[this.drugCharacteristic.size()]); // MedicationKnowledgeDrugCharacteristicComponent
        case 251885509: /*clinicalUseIssue*/ return this.clinicalUseIssue == null ? new Base[0] : this.clinicalUseIssue.toArray(new Base[this.clinicalUseIssue.size()]); // Reference
        case -27327848: /*regulatory*/ return this.regulatory == null ? new Base[0] : this.regulatory.toArray(new Base[this.regulatory.size()]); // MedicationKnowledgeRegulatoryComponent
        case -573129004: /*kineticCharacteristic*/ return this.kineticCharacteristic == null ? new Base[0] : this.kineticCharacteristic.toArray(new Base[this.kineticCharacteristic.size()]); // MedicationKnowledgeKineticCharacteristicComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -892481550: // status
          value = new MedicationKnowledgeStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationKnowledgeStatusCodes>
          return value;
        case -1969347631: // manufacturer
          this.manufacturer = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1303858817: // doseForm
          this.doseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1413853096: // amount
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1742128133: // synonym
          this.getSynonym().add(TypeConvertor.castToString(value)); // StringType
          return value;
        case 723067972: // relatedMedicationKnowledge
          this.getRelatedMedicationKnowledge().add((MedicationKnowledgeRelatedMedicationKnowledgeComponent) value); // MedicationKnowledgeRelatedMedicationKnowledgeComponent
          return value;
        case 1312779381: // associatedMedication
          this.getAssociatedMedication().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1491615543: // productType
          this.getProductType().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1442980789: // monograph
          this.getMonograph().add((MedicationKnowledgeMonographComponent) value); // MedicationKnowledgeMonographComponent
          return value;
        case -206409263: // ingredient
          this.getIngredient().add((MedicationKnowledgeIngredientComponent) value); // MedicationKnowledgeIngredientComponent
          return value;
        case -1335157162: // device
          this.getDevice().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1025456503: // preparationInstruction
          this.preparationInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -767798050: // intendedRoute
          this.getIntendedRoute().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059661: // cost
          this.getCost().add((MedicationKnowledgeCostComponent) value); // MedicationKnowledgeCostComponent
          return value;
        case 569848092: // monitoringProgram
          this.getMonitoringProgram().add((MedicationKnowledgeMonitoringProgramComponent) value); // MedicationKnowledgeMonitoringProgramComponent
          return value;
        case -815253966: // administrationGuideline
          this.getAdministrationGuideline().add((MedicationKnowledgeAdministrationGuidelineComponent) value); // MedicationKnowledgeAdministrationGuidelineComponent
          return value;
        case 1791551680: // medicineClassification
          this.getMedicineClassification().add((MedicationKnowledgeMedicineClassificationComponent) value); // MedicationKnowledgeMedicineClassificationComponent
          return value;
        case 1802065795: // packaging
          this.packaging = (MedicationKnowledgePackagingComponent) value; // MedicationKnowledgePackagingComponent
          return value;
        case -844126885: // drugCharacteristic
          this.getDrugCharacteristic().add((MedicationKnowledgeDrugCharacteristicComponent) value); // MedicationKnowledgeDrugCharacteristicComponent
          return value;
        case 251885509: // clinicalUseIssue
          this.getClinicalUseIssue().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -27327848: // regulatory
          this.getRegulatory().add((MedicationKnowledgeRegulatoryComponent) value); // MedicationKnowledgeRegulatoryComponent
          return value;
        case -573129004: // kineticCharacteristic
          this.getKineticCharacteristic().add((MedicationKnowledgeKineticCharacteristicComponent) value); // MedicationKnowledgeKineticCharacteristicComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("status")) {
          value = new MedicationKnowledgeStatusCodesEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<MedicationKnowledgeStatusCodes>
        } else if (name.equals("manufacturer")) {
          this.manufacturer = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("doseForm")) {
          this.doseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("amount")) {
          this.amount = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("synonym")) {
          this.getSynonym().add(TypeConvertor.castToString(value));
        } else if (name.equals("relatedMedicationKnowledge")) {
          this.getRelatedMedicationKnowledge().add((MedicationKnowledgeRelatedMedicationKnowledgeComponent) value);
        } else if (name.equals("associatedMedication")) {
          this.getAssociatedMedication().add(TypeConvertor.castToReference(value));
        } else if (name.equals("productType")) {
          this.getProductType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("monograph")) {
          this.getMonograph().add((MedicationKnowledgeMonographComponent) value);
        } else if (name.equals("ingredient")) {
          this.getIngredient().add((MedicationKnowledgeIngredientComponent) value);
        } else if (name.equals("device")) {
          this.getDevice().add(TypeConvertor.castToReference(value));
        } else if (name.equals("preparationInstruction")) {
          this.preparationInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("intendedRoute")) {
          this.getIntendedRoute().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("cost")) {
          this.getCost().add((MedicationKnowledgeCostComponent) value);
        } else if (name.equals("monitoringProgram")) {
          this.getMonitoringProgram().add((MedicationKnowledgeMonitoringProgramComponent) value);
        } else if (name.equals("administrationGuideline")) {
          this.getAdministrationGuideline().add((MedicationKnowledgeAdministrationGuidelineComponent) value);
        } else if (name.equals("medicineClassification")) {
          this.getMedicineClassification().add((MedicationKnowledgeMedicineClassificationComponent) value);
        } else if (name.equals("packaging")) {
          this.packaging = (MedicationKnowledgePackagingComponent) value; // MedicationKnowledgePackagingComponent
        } else if (name.equals("drugCharacteristic")) {
          this.getDrugCharacteristic().add((MedicationKnowledgeDrugCharacteristicComponent) value);
        } else if (name.equals("clinicalUseIssue")) {
          this.getClinicalUseIssue().add(TypeConvertor.castToReference(value));
        } else if (name.equals("regulatory")) {
          this.getRegulatory().add((MedicationKnowledgeRegulatoryComponent) value);
        } else if (name.equals("kineticCharacteristic")) {
          this.getKineticCharacteristic().add((MedicationKnowledgeKineticCharacteristicComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 3059181:  return getCode();
        case -892481550:  return getStatusElement();
        case -1969347631:  return getManufacturer();
        case 1303858817:  return getDoseForm();
        case -1413853096:  return getAmount();
        case -1742128133:  return addSynonymElement();
        case 723067972:  return addRelatedMedicationKnowledge(); 
        case 1312779381:  return addAssociatedMedication(); 
        case -1491615543:  return addProductType(); 
        case -1442980789:  return addMonograph(); 
        case -206409263:  return addIngredient(); 
        case -1335157162:  return addDevice(); 
        case 1025456503:  return getPreparationInstructionElement();
        case -767798050:  return addIntendedRoute(); 
        case 3059661:  return addCost(); 
        case 569848092:  return addMonitoringProgram(); 
        case -815253966:  return addAdministrationGuideline(); 
        case 1791551680:  return addMedicineClassification(); 
        case 1802065795:  return getPackaging();
        case -844126885:  return addDrugCharacteristic(); 
        case 251885509:  return addClinicalUseIssue(); 
        case -27327848:  return addRegulatory(); 
        case -573129004:  return addKineticCharacteristic(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1969347631: /*manufacturer*/ return new String[] {"Reference"};
        case 1303858817: /*doseForm*/ return new String[] {"CodeableConcept"};
        case -1413853096: /*amount*/ return new String[] {"Quantity"};
        case -1742128133: /*synonym*/ return new String[] {"string"};
        case 723067972: /*relatedMedicationKnowledge*/ return new String[] {};
        case 1312779381: /*associatedMedication*/ return new String[] {"Reference"};
        case -1491615543: /*productType*/ return new String[] {"CodeableConcept"};
        case -1442980789: /*monograph*/ return new String[] {};
        case -206409263: /*ingredient*/ return new String[] {};
        case -1335157162: /*device*/ return new String[] {"Reference"};
        case 1025456503: /*preparationInstruction*/ return new String[] {"markdown"};
        case -767798050: /*intendedRoute*/ return new String[] {"CodeableConcept"};
        case 3059661: /*cost*/ return new String[] {};
        case 569848092: /*monitoringProgram*/ return new String[] {};
        case -815253966: /*administrationGuideline*/ return new String[] {};
        case 1791551680: /*medicineClassification*/ return new String[] {};
        case 1802065795: /*packaging*/ return new String[] {};
        case -844126885: /*drugCharacteristic*/ return new String[] {};
        case 251885509: /*clinicalUseIssue*/ return new String[] {"Reference"};
        case -27327848: /*regulatory*/ return new String[] {};
        case -573129004: /*kineticCharacteristic*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.status");
        }
        else if (name.equals("manufacturer")) {
          this.manufacturer = new Reference();
          return this.manufacturer;
        }
        else if (name.equals("doseForm")) {
          this.doseForm = new CodeableConcept();
          return this.doseForm;
        }
        else if (name.equals("amount")) {
          this.amount = new Quantity();
          return this.amount;
        }
        else if (name.equals("synonym")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.synonym");
        }
        else if (name.equals("relatedMedicationKnowledge")) {
          return addRelatedMedicationKnowledge();
        }
        else if (name.equals("associatedMedication")) {
          return addAssociatedMedication();
        }
        else if (name.equals("productType")) {
          return addProductType();
        }
        else if (name.equals("monograph")) {
          return addMonograph();
        }
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else if (name.equals("device")) {
          return addDevice();
        }
        else if (name.equals("preparationInstruction")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.preparationInstruction");
        }
        else if (name.equals("intendedRoute")) {
          return addIntendedRoute();
        }
        else if (name.equals("cost")) {
          return addCost();
        }
        else if (name.equals("monitoringProgram")) {
          return addMonitoringProgram();
        }
        else if (name.equals("administrationGuideline")) {
          return addAdministrationGuideline();
        }
        else if (name.equals("medicineClassification")) {
          return addMedicineClassification();
        }
        else if (name.equals("packaging")) {
          this.packaging = new MedicationKnowledgePackagingComponent();
          return this.packaging;
        }
        else if (name.equals("drugCharacteristic")) {
          return addDrugCharacteristic();
        }
        else if (name.equals("clinicalUseIssue")) {
          return addClinicalUseIssue();
        }
        else if (name.equals("regulatory")) {
          return addRegulatory();
        }
        else if (name.equals("kineticCharacteristic")) {
          return addKineticCharacteristic();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "MedicationKnowledge";

  }

      public MedicationKnowledge copy() {
        MedicationKnowledge dst = new MedicationKnowledge();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledge dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.status = status == null ? null : status.copy();
        dst.manufacturer = manufacturer == null ? null : manufacturer.copy();
        dst.doseForm = doseForm == null ? null : doseForm.copy();
        dst.amount = amount == null ? null : amount.copy();
        if (synonym != null) {
          dst.synonym = new ArrayList<StringType>();
          for (StringType i : synonym)
            dst.synonym.add(i.copy());
        };
        if (relatedMedicationKnowledge != null) {
          dst.relatedMedicationKnowledge = new ArrayList<MedicationKnowledgeRelatedMedicationKnowledgeComponent>();
          for (MedicationKnowledgeRelatedMedicationKnowledgeComponent i : relatedMedicationKnowledge)
            dst.relatedMedicationKnowledge.add(i.copy());
        };
        if (associatedMedication != null) {
          dst.associatedMedication = new ArrayList<Reference>();
          for (Reference i : associatedMedication)
            dst.associatedMedication.add(i.copy());
        };
        if (productType != null) {
          dst.productType = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : productType)
            dst.productType.add(i.copy());
        };
        if (monograph != null) {
          dst.monograph = new ArrayList<MedicationKnowledgeMonographComponent>();
          for (MedicationKnowledgeMonographComponent i : monograph)
            dst.monograph.add(i.copy());
        };
        if (ingredient != null) {
          dst.ingredient = new ArrayList<MedicationKnowledgeIngredientComponent>();
          for (MedicationKnowledgeIngredientComponent i : ingredient)
            dst.ingredient.add(i.copy());
        };
        if (device != null) {
          dst.device = new ArrayList<Reference>();
          for (Reference i : device)
            dst.device.add(i.copy());
        };
        dst.preparationInstruction = preparationInstruction == null ? null : preparationInstruction.copy();
        if (intendedRoute != null) {
          dst.intendedRoute = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : intendedRoute)
            dst.intendedRoute.add(i.copy());
        };
        if (cost != null) {
          dst.cost = new ArrayList<MedicationKnowledgeCostComponent>();
          for (MedicationKnowledgeCostComponent i : cost)
            dst.cost.add(i.copy());
        };
        if (monitoringProgram != null) {
          dst.monitoringProgram = new ArrayList<MedicationKnowledgeMonitoringProgramComponent>();
          for (MedicationKnowledgeMonitoringProgramComponent i : monitoringProgram)
            dst.monitoringProgram.add(i.copy());
        };
        if (administrationGuideline != null) {
          dst.administrationGuideline = new ArrayList<MedicationKnowledgeAdministrationGuidelineComponent>();
          for (MedicationKnowledgeAdministrationGuidelineComponent i : administrationGuideline)
            dst.administrationGuideline.add(i.copy());
        };
        if (medicineClassification != null) {
          dst.medicineClassification = new ArrayList<MedicationKnowledgeMedicineClassificationComponent>();
          for (MedicationKnowledgeMedicineClassificationComponent i : medicineClassification)
            dst.medicineClassification.add(i.copy());
        };
        dst.packaging = packaging == null ? null : packaging.copy();
        if (drugCharacteristic != null) {
          dst.drugCharacteristic = new ArrayList<MedicationKnowledgeDrugCharacteristicComponent>();
          for (MedicationKnowledgeDrugCharacteristicComponent i : drugCharacteristic)
            dst.drugCharacteristic.add(i.copy());
        };
        if (clinicalUseIssue != null) {
          dst.clinicalUseIssue = new ArrayList<Reference>();
          for (Reference i : clinicalUseIssue)
            dst.clinicalUseIssue.add(i.copy());
        };
        if (regulatory != null) {
          dst.regulatory = new ArrayList<MedicationKnowledgeRegulatoryComponent>();
          for (MedicationKnowledgeRegulatoryComponent i : regulatory)
            dst.regulatory.add(i.copy());
        };
        if (kineticCharacteristic != null) {
          dst.kineticCharacteristic = new ArrayList<MedicationKnowledgeKineticCharacteristicComponent>();
          for (MedicationKnowledgeKineticCharacteristicComponent i : kineticCharacteristic)
            dst.kineticCharacteristic.add(i.copy());
        };
      }

      protected MedicationKnowledge typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledge))
          return false;
        MedicationKnowledge o = (MedicationKnowledge) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(code, o.code, true) && compareDeep(status, o.status, true)
           && compareDeep(manufacturer, o.manufacturer, true) && compareDeep(doseForm, o.doseForm, true) && compareDeep(amount, o.amount, true)
           && compareDeep(synonym, o.synonym, true) && compareDeep(relatedMedicationKnowledge, o.relatedMedicationKnowledge, true)
           && compareDeep(associatedMedication, o.associatedMedication, true) && compareDeep(productType, o.productType, true)
           && compareDeep(monograph, o.monograph, true) && compareDeep(ingredient, o.ingredient, true) && compareDeep(device, o.device, true)
           && compareDeep(preparationInstruction, o.preparationInstruction, true) && compareDeep(intendedRoute, o.intendedRoute, true)
           && compareDeep(cost, o.cost, true) && compareDeep(monitoringProgram, o.monitoringProgram, true)
           && compareDeep(administrationGuideline, o.administrationGuideline, true) && compareDeep(medicineClassification, o.medicineClassification, true)
           && compareDeep(packaging, o.packaging, true) && compareDeep(drugCharacteristic, o.drugCharacteristic, true)
           && compareDeep(clinicalUseIssue, o.clinicalUseIssue, true) && compareDeep(regulatory, o.regulatory, true)
           && compareDeep(kineticCharacteristic, o.kineticCharacteristic, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledge))
          return false;
        MedicationKnowledge o = (MedicationKnowledge) other_;
        return compareValues(status, o.status, true) && compareValues(synonym, o.synonym, true) && compareValues(preparationInstruction, o.preparationInstruction, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, code, status
          , manufacturer, doseForm, amount, synonym, relatedMedicationKnowledge, associatedMedication
          , productType, monograph, ingredient, device, preparationInstruction, intendedRoute
          , cost, monitoringProgram, administrationGuideline, medicineClassification, packaging
          , drugCharacteristic, clinicalUseIssue, regulatory, kineticCharacteristic);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicationKnowledge;
   }

 /**
   * Search parameter: <b>classification-type</b>
   * <p>
   * Description: <b>The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.medicineClassification.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="classification-type", path="MedicationKnowledge.medicineClassification.type", description="The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification)", type="token" )
  public static final String SP_CLASSIFICATION_TYPE = "classification-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>classification-type</b>
   * <p>
   * Description: <b>The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.medicineClassification.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CLASSIFICATION_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CLASSIFICATION_TYPE);

 /**
   * Search parameter: <b>classification</b>
   * <p>
   * Description: <b>Specific category assigned to the medication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.medicineClassification.classification</b><br>
   * </p>
   */
  @SearchParamDefinition(name="classification", path="MedicationKnowledge.medicineClassification.classification", description="Specific category assigned to the medication", type="token" )
  public static final String SP_CLASSIFICATION = "classification";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>classification</b>
   * <p>
   * Description: <b>Specific category assigned to the medication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.medicineClassification.classification</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CLASSIFICATION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CLASSIFICATION);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Code that identifies this medication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="MedicationKnowledge.code", description="Code that identifies this medication", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Code that identifies this medication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>doseform</b>
   * <p>
   * Description: <b>powder | tablets | capsule +</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.doseForm</b><br>
   * </p>
   */
  @SearchParamDefinition(name="doseform", path="MedicationKnowledge.doseForm", description="powder | tablets | capsule +", type="token" )
  public static final String SP_DOSEFORM = "doseform";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>doseform</b>
   * <p>
   * Description: <b>powder | tablets | capsule +</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.doseForm</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DOSEFORM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DOSEFORM);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for this medication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="MedicationKnowledge.identifier", description="Business identifier for this medication", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Business identifier for this medication</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>ingredient-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.ingredient.item.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="ingredient-code", path="MedicationKnowledge.ingredient.item.concept", description="Reference to a concept (by class)", type="token" )
  public static final String SP_INGREDIENT_CODE = "ingredient-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>ingredient-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.ingredient.item.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INGREDIENT_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INGREDIENT_CODE);

 /**
   * Search parameter: <b>ingredient</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationKnowledge.ingredient.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="ingredient", path="MedicationKnowledge.ingredient.item.reference", description="Reference to a resource (by instance)", type="reference" )
  public static final String SP_INGREDIENT = "ingredient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>ingredient</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationKnowledge.ingredient.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INGREDIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INGREDIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationKnowledge:ingredient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INGREDIENT = new ca.uhn.fhir.model.api.Include("MedicationKnowledge:ingredient").toLocked();

 /**
   * Search parameter: <b>manufacturer</b>
   * <p>
   * Description: <b>Manufacturer of the item</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationKnowledge.manufacturer</b><br>
   * </p>
   */
  @SearchParamDefinition(name="manufacturer", path="MedicationKnowledge.manufacturer", description="Manufacturer of the item", type="reference", target={Organization.class } )
  public static final String SP_MANUFACTURER = "manufacturer";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>manufacturer</b>
   * <p>
   * Description: <b>Manufacturer of the item</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationKnowledge.manufacturer</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MANUFACTURER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MANUFACTURER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationKnowledge:manufacturer</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MANUFACTURER = new ca.uhn.fhir.model.api.Include("MedicationKnowledge:manufacturer").toLocked();

 /**
   * Search parameter: <b>monitoring-program-name</b>
   * <p>
   * Description: <b>Name of the reviewing program</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.monitoringProgram.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="monitoring-program-name", path="MedicationKnowledge.monitoringProgram.name", description="Name of the reviewing program", type="token" )
  public static final String SP_MONITORING_PROGRAM_NAME = "monitoring-program-name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>monitoring-program-name</b>
   * <p>
   * Description: <b>Name of the reviewing program</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.monitoringProgram.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MONITORING_PROGRAM_NAME = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MONITORING_PROGRAM_NAME);

 /**
   * Search parameter: <b>monitoring-program-type</b>
   * <p>
   * Description: <b>Type of program under which the medication is monitored</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.monitoringProgram.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="monitoring-program-type", path="MedicationKnowledge.monitoringProgram.type", description="Type of program under which the medication is monitored", type="token" )
  public static final String SP_MONITORING_PROGRAM_TYPE = "monitoring-program-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>monitoring-program-type</b>
   * <p>
   * Description: <b>Type of program under which the medication is monitored</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.monitoringProgram.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MONITORING_PROGRAM_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MONITORING_PROGRAM_TYPE);

 /**
   * Search parameter: <b>monograph-type</b>
   * <p>
   * Description: <b>The category of medication document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.monograph.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="monograph-type", path="MedicationKnowledge.monograph.type", description="The category of medication document", type="token" )
  public static final String SP_MONOGRAPH_TYPE = "monograph-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>monograph-type</b>
   * <p>
   * Description: <b>The category of medication document</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.monograph.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam MONOGRAPH_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_MONOGRAPH_TYPE);

 /**
   * Search parameter: <b>monograph</b>
   * <p>
   * Description: <b>Associated documentation about the medication</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationKnowledge.monograph.source</b><br>
   * </p>
   */
  @SearchParamDefinition(name="monograph", path="MedicationKnowledge.monograph.source", description="Associated documentation about the medication", type="reference", target={DocumentReference.class } )
  public static final String SP_MONOGRAPH = "monograph";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>monograph</b>
   * <p>
   * Description: <b>Associated documentation about the medication</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationKnowledge.monograph.source</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam MONOGRAPH = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_MONOGRAPH);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationKnowledge:monograph</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_MONOGRAPH = new ca.uhn.fhir.model.api.Include("MedicationKnowledge:monograph").toLocked();

 /**
   * Search parameter: <b>product-type</b>
   * <p>
   * Description: <b>Category of the medication or product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.productType</b><br>
   * </p>
   */
  @SearchParamDefinition(name="product-type", path="MedicationKnowledge.productType", description="Category of the medication or product", type="token" )
  public static final String SP_PRODUCT_TYPE = "product-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>product-type</b>
   * <p>
   * Description: <b>Category of the medication or product</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.productType</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PRODUCT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PRODUCT_TYPE);

 /**
   * Search parameter: <b>source-cost</b>
   * <p>
   * Description: <b>The source or owner for the price information</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.cost.source</b><br>
   * </p>
   */
  @SearchParamDefinition(name="source-cost", path="MedicationKnowledge.cost.source", description="The source or owner for the price information", type="token" )
  public static final String SP_SOURCE_COST = "source-cost";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>source-cost</b>
   * <p>
   * Description: <b>The source or owner for the price information</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.cost.source</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam SOURCE_COST = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_SOURCE_COST);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>active | inactive | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="MedicationKnowledge.status", description="active | inactive | entered-in-error", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>active | inactive | entered-in-error</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);


}