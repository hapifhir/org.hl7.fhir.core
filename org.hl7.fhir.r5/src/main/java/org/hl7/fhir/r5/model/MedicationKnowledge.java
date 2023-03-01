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

// Generated on Wed, Mar 1, 2023 15:32+1100 for FHIR v5.0.0-draft-final

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
         * The medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system.
         */
        ACTIVE, 
        /**
         * The medication referred to by this MedicationKnowledge was entered in error within the drug database or inventory system.
         */
        ENTEREDINERROR, 
        /**
         * The medication referred to by this MedicationKnowledge is not in active use within the drug database or inventory system.
         */
        INACTIVE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static MedicationKnowledgeStatusCodes fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("active".equals(codeString))
          return ACTIVE;
        if ("entered-in-error".equals(codeString))
          return ENTEREDINERROR;
        if ("inactive".equals(codeString))
          return INACTIVE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown MedicationKnowledgeStatusCodes code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case ACTIVE: return "active";
            case ENTEREDINERROR: return "entered-in-error";
            case INACTIVE: return "inactive";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case ACTIVE: return "http://hl7.org/fhir/CodeSystem/medicationknowledge-status";
            case ENTEREDINERROR: return "http://hl7.org/fhir/CodeSystem/medicationknowledge-status";
            case INACTIVE: return "http://hl7.org/fhir/CodeSystem/medicationknowledge-status";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case ACTIVE: return "The medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system.";
            case ENTEREDINERROR: return "The medication referred to by this MedicationKnowledge was entered in error within the drug database or inventory system.";
            case INACTIVE: return "The medication referred to by this MedicationKnowledge is not in active use within the drug database or inventory system.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case ACTIVE: return "Active";
            case ENTEREDINERROR: return "Entered in Error";
            case INACTIVE: return "Inactive";
            case NULL: return null;
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
        if ("entered-in-error".equals(codeString))
          return MedicationKnowledgeStatusCodes.ENTEREDINERROR;
        if ("inactive".equals(codeString))
          return MedicationKnowledgeStatusCodes.INACTIVE;
        throw new IllegalArgumentException("Unknown MedicationKnowledgeStatusCodes code '"+codeString+"'");
        }
        public Enumeration<MedicationKnowledgeStatusCodes> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<MedicationKnowledgeStatusCodes>(this, MedicationKnowledgeStatusCodes.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<MedicationKnowledgeStatusCodes>(this, MedicationKnowledgeStatusCodes.NULL, code);
        if ("active".equals(codeString))
          return new Enumeration<MedicationKnowledgeStatusCodes>(this, MedicationKnowledgeStatusCodes.ACTIVE, code);
        if ("entered-in-error".equals(codeString))
          return new Enumeration<MedicationKnowledgeStatusCodes>(this, MedicationKnowledgeStatusCodes.ENTEREDINERROR, code);
        if ("inactive".equals(codeString))
          return new Enumeration<MedicationKnowledgeStatusCodes>(this, MedicationKnowledgeStatusCodes.INACTIVE, code);
        throw new FHIRException("Unknown MedicationKnowledgeStatusCodes code '"+codeString+"'");
        }
    public String toCode(MedicationKnowledgeStatusCodes code) {
      if (code == MedicationKnowledgeStatusCodes.ACTIVE)
        return "active";
      if (code == MedicationKnowledgeStatusCodes.ENTEREDINERROR)
        return "entered-in-error";
      if (code == MedicationKnowledgeStatusCodes.INACTIVE)
        return "inactive";
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
    public static class MedicationKnowledgeCostComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The date range for which the cost information of the medication is effective.
         */
        @Child(name = "effectiveDate", type = {Period.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The date range for which the cost is effective", formalDefinition="The date range for which the cost information of the medication is effective." )
        protected List<Period> effectiveDate;

        /**
         * The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The category of the cost information", formalDefinition="The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost." )
        protected CodeableConcept type;

        /**
         * The source or owner that assigns the price to the medication.
         */
        @Child(name = "source", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The source or owner for the price information", formalDefinition="The source or owner that assigns the price to the medication." )
        protected StringType source;

        /**
         * The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.
         */
        @Child(name = "cost", type = {Money.class, CodeableConcept.class}, order=4, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The price or category of the cost of the medication", formalDefinition="The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-cost-category")
        protected DataType cost;

        private static final long serialVersionUID = 747402134L;

    /**
     * Constructor
     */
      public MedicationKnowledgeCostComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeCostComponent(CodeableConcept type, DataType cost) {
        super();
        this.setType(type);
        this.setCost(cost);
      }

        /**
         * @return {@link #effectiveDate} (The date range for which the cost information of the medication is effective.)
         */
        public List<Period> getEffectiveDate() { 
          if (this.effectiveDate == null)
            this.effectiveDate = new ArrayList<Period>();
          return this.effectiveDate;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeCostComponent setEffectiveDate(List<Period> theEffectiveDate) { 
          this.effectiveDate = theEffectiveDate;
          return this;
        }

        public boolean hasEffectiveDate() { 
          if (this.effectiveDate == null)
            return false;
          for (Period item : this.effectiveDate)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Period addEffectiveDate() { //3
          Period t = new Period();
          if (this.effectiveDate == null)
            this.effectiveDate = new ArrayList<Period>();
          this.effectiveDate.add(t);
          return t;
        }

        public MedicationKnowledgeCostComponent addEffectiveDate(Period t) { //3
          if (t == null)
            return this;
          if (this.effectiveDate == null)
            this.effectiveDate = new ArrayList<Period>();
          this.effectiveDate.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #effectiveDate}, creating it if it does not already exist {3}
         */
        public Period getEffectiveDateFirstRep() { 
          if (getEffectiveDate().isEmpty()) {
            addEffectiveDate();
          }
          return getEffectiveDate().get(0);
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
         * @return {@link #cost} (The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.)
         */
        public DataType getCost() { 
          return this.cost;
        }

        /**
         * @return {@link #cost} (The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.)
         */
        public Money getCostMoney() throws FHIRException { 
          if (this.cost == null)
            this.cost = new Money();
          if (!(this.cost instanceof Money))
            throw new FHIRException("Type mismatch: the type Money was expected, but "+this.cost.getClass().getName()+" was encountered");
          return (Money) this.cost;
        }

        public boolean hasCostMoney() { 
          return this != null && this.cost instanceof Money;
        }

        /**
         * @return {@link #cost} (The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.)
         */
        public CodeableConcept getCostCodeableConcept() throws FHIRException { 
          if (this.cost == null)
            this.cost = new CodeableConcept();
          if (!(this.cost instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.cost.getClass().getName()+" was encountered");
          return (CodeableConcept) this.cost;
        }

        public boolean hasCostCodeableConcept() { 
          return this != null && this.cost instanceof CodeableConcept;
        }

        public boolean hasCost() { 
          return this.cost != null && !this.cost.isEmpty();
        }

        /**
         * @param value {@link #cost} (The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.)
         */
        public MedicationKnowledgeCostComponent setCost(DataType value) { 
          if (value != null && !(value instanceof Money || value instanceof CodeableConcept))
            throw new Error("Not the right type for MedicationKnowledge.cost.cost[x]: "+value.fhirType());
          this.cost = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("effectiveDate", "Period", "The date range for which the cost information of the medication is effective.", 0, java.lang.Integer.MAX_VALUE, effectiveDate));
          children.add(new Property("type", "CodeableConcept", "The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost.", 0, 1, type));
          children.add(new Property("source", "string", "The source or owner that assigns the price to the medication.", 0, 1, source));
          children.add(new Property("cost[x]", "Money|CodeableConcept", "The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.", 0, 1, cost));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -930389515: /*effectiveDate*/  return new Property("effectiveDate", "Period", "The date range for which the cost information of the medication is effective.", 0, java.lang.Integer.MAX_VALUE, effectiveDate);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The category of the cost information.  For example, manufacturers' cost, patient cost, claim reimbursement cost, actual acquisition cost.", 0, 1, type);
          case -896505829: /*source*/  return new Property("source", "string", "The source or owner that assigns the price to the medication.", 0, 1, source);
          case 956138899: /*cost[x]*/  return new Property("cost[x]", "Money|CodeableConcept", "The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.", 0, 1, cost);
          case 3059661: /*cost*/  return new Property("cost[x]", "Money|CodeableConcept", "The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.", 0, 1, cost);
          case -286697229: /*costMoney*/  return new Property("cost[x]", "Money", "The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.", 0, 1, cost);
          case -238369772: /*costCodeableConcept*/  return new Property("cost[x]", "CodeableConcept", "The price or representation of the cost (for example, Band A, Band B or $, $$) of the medication.", 0, 1, cost);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -930389515: /*effectiveDate*/ return this.effectiveDate == null ? new Base[0] : this.effectiveDate.toArray(new Base[this.effectiveDate.size()]); // Period
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // StringType
        case 3059661: /*cost*/ return this.cost == null ? new Base[0] : new Base[] {this.cost}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -930389515: // effectiveDate
          this.getEffectiveDate().add(TypeConvertor.castToPeriod(value)); // Period
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -896505829: // source
          this.source = TypeConvertor.castToString(value); // StringType
          return value;
        case 3059661: // cost
          this.cost = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("effectiveDate")) {
          this.getEffectiveDate().add(TypeConvertor.castToPeriod(value));
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("source")) {
          this.source = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("cost[x]")) {
          this.cost = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -930389515:  return addEffectiveDate(); 
        case 3575610:  return getType();
        case -896505829:  return getSourceElement();
        case 956138899:  return getCost();
        case 3059661:  return getCost();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -930389515: /*effectiveDate*/ return new String[] {"Period"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -896505829: /*source*/ return new String[] {"string"};
        case 3059661: /*cost*/ return new String[] {"Money", "CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("effectiveDate")) {
          return addEffectiveDate();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("source")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.cost.source");
        }
        else if (name.equals("costMoney")) {
          this.cost = new Money();
          return this.cost;
        }
        else if (name.equals("costCodeableConcept")) {
          this.cost = new CodeableConcept();
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
        if (effectiveDate != null) {
          dst.effectiveDate = new ArrayList<Period>();
          for (Period i : effectiveDate)
            dst.effectiveDate.add(i.copy());
        };
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
        return compareDeep(effectiveDate, o.effectiveDate, true) && compareDeep(type, o.type, true) && compareDeep(source, o.source, true)
           && compareDeep(cost, o.cost, true);
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
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(effectiveDate, type, source
          , cost);
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
    public static class MedicationKnowledgeIndicationGuidelineComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indication or reason for use of the medication that applies to the specific administration guideline.
         */
        @Child(name = "indication", type = {CodeableReference.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Indication for use that applies to the specific administration guideline", formalDefinition="Indication or reason for use of the medication that applies to the specific administration guideline." )
        protected List<CodeableReference> indication;

        /**
         * The guidelines for the dosage of the medication for the indication.
         */
        @Child(name = "dosingGuideline", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Guidelines for dosage of the medication", formalDefinition="The guidelines for the dosage of the medication for the indication." )
        protected List<MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent> dosingGuideline;

        private static final long serialVersionUID = 256409722L;

    /**
     * Constructor
     */
      public MedicationKnowledgeIndicationGuidelineComponent() {
        super();
      }

        /**
         * @return {@link #indication} (Indication or reason for use of the medication that applies to the specific administration guideline.)
         */
        public List<CodeableReference> getIndication() { 
          if (this.indication == null)
            this.indication = new ArrayList<CodeableReference>();
          return this.indication;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeIndicationGuidelineComponent setIndication(List<CodeableReference> theIndication) { 
          this.indication = theIndication;
          return this;
        }

        public boolean hasIndication() { 
          if (this.indication == null)
            return false;
          for (CodeableReference item : this.indication)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableReference addIndication() { //3
          CodeableReference t = new CodeableReference();
          if (this.indication == null)
            this.indication = new ArrayList<CodeableReference>();
          this.indication.add(t);
          return t;
        }

        public MedicationKnowledgeIndicationGuidelineComponent addIndication(CodeableReference t) { //3
          if (t == null)
            return this;
          if (this.indication == null)
            this.indication = new ArrayList<CodeableReference>();
          this.indication.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #indication}, creating it if it does not already exist {3}
         */
        public CodeableReference getIndicationFirstRep() { 
          if (getIndication().isEmpty()) {
            addIndication();
          }
          return getIndication().get(0);
        }

        /**
         * @return {@link #dosingGuideline} (The guidelines for the dosage of the medication for the indication.)
         */
        public List<MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent> getDosingGuideline() { 
          if (this.dosingGuideline == null)
            this.dosingGuideline = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent>();
          return this.dosingGuideline;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeIndicationGuidelineComponent setDosingGuideline(List<MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent> theDosingGuideline) { 
          this.dosingGuideline = theDosingGuideline;
          return this;
        }

        public boolean hasDosingGuideline() { 
          if (this.dosingGuideline == null)
            return false;
          for (MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent item : this.dosingGuideline)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent addDosingGuideline() { //3
          MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent t = new MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent();
          if (this.dosingGuideline == null)
            this.dosingGuideline = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent>();
          this.dosingGuideline.add(t);
          return t;
        }

        public MedicationKnowledgeIndicationGuidelineComponent addDosingGuideline(MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent t) { //3
          if (t == null)
            return this;
          if (this.dosingGuideline == null)
            this.dosingGuideline = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent>();
          this.dosingGuideline.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dosingGuideline}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent getDosingGuidelineFirstRep() { 
          if (getDosingGuideline().isEmpty()) {
            addDosingGuideline();
          }
          return getDosingGuideline().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("indication", "CodeableReference(ClinicalUseDefinition)", "Indication or reason for use of the medication that applies to the specific administration guideline.", 0, java.lang.Integer.MAX_VALUE, indication));
          children.add(new Property("dosingGuideline", "", "The guidelines for the dosage of the medication for the indication.", 0, java.lang.Integer.MAX_VALUE, dosingGuideline));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -597168804: /*indication*/  return new Property("indication", "CodeableReference(ClinicalUseDefinition)", "Indication or reason for use of the medication that applies to the specific administration guideline.", 0, java.lang.Integer.MAX_VALUE, indication);
          case -1792856970: /*dosingGuideline*/  return new Property("dosingGuideline", "", "The guidelines for the dosage of the medication for the indication.", 0, java.lang.Integer.MAX_VALUE, dosingGuideline);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -597168804: /*indication*/ return this.indication == null ? new Base[0] : this.indication.toArray(new Base[this.indication.size()]); // CodeableReference
        case -1792856970: /*dosingGuideline*/ return this.dosingGuideline == null ? new Base[0] : this.dosingGuideline.toArray(new Base[this.dosingGuideline.size()]); // MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -597168804: // indication
          this.getIndication().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case -1792856970: // dosingGuideline
          this.getDosingGuideline().add((MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent) value); // MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("indication")) {
          this.getIndication().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("dosingGuideline")) {
          this.getDosingGuideline().add((MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -597168804:  return addIndication(); 
        case -1792856970:  return addDosingGuideline(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -597168804: /*indication*/ return new String[] {"CodeableReference"};
        case -1792856970: /*dosingGuideline*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("indication")) {
          return addIndication();
        }
        else if (name.equals("dosingGuideline")) {
          return addDosingGuideline();
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeIndicationGuidelineComponent copy() {
        MedicationKnowledgeIndicationGuidelineComponent dst = new MedicationKnowledgeIndicationGuidelineComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeIndicationGuidelineComponent dst) {
        super.copyValues(dst);
        if (indication != null) {
          dst.indication = new ArrayList<CodeableReference>();
          for (CodeableReference i : indication)
            dst.indication.add(i.copy());
        };
        if (dosingGuideline != null) {
          dst.dosingGuideline = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent>();
          for (MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent i : dosingGuideline)
            dst.dosingGuideline.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeIndicationGuidelineComponent))
          return false;
        MedicationKnowledgeIndicationGuidelineComponent o = (MedicationKnowledgeIndicationGuidelineComponent) other_;
        return compareDeep(indication, o.indication, true) && compareDeep(dosingGuideline, o.dosingGuideline, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeIndicationGuidelineComponent))
          return false;
        MedicationKnowledgeIndicationGuidelineComponent o = (MedicationKnowledgeIndicationGuidelineComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(indication, dosingGuideline
          );
      }

  public String fhirType() {
    return "MedicationKnowledge.indicationGuideline";

  }

  }

    @Block()
    public static class MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The overall intention of the treatment, for example, prophylactic, supporative, curative, etc.
         */
        @Child(name = "treatmentIntent", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Intention of the treatment", formalDefinition="The overall intention of the treatment, for example, prophylactic, supporative, curative, etc." )
        protected CodeableConcept treatmentIntent;

        /**
         * Dosage for the medication for the specific guidelines.
         */
        @Child(name = "dosage", type = {}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Dosage for the medication for the specific guidelines", formalDefinition="Dosage for the medication for the specific guidelines." )
        protected List<MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent> dosage;

        /**
         * The type of the treatment that the guideline applies to, for example, long term therapy, first line treatment, etc.
         */
        @Child(name = "administrationTreatment", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of treatment the guideline applies to", formalDefinition="The type of the treatment that the guideline applies to, for example, long term therapy, first line treatment, etc." )
        protected CodeableConcept administrationTreatment;

        /**
         * Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.).
         */
        @Child(name = "patientCharacteristic", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Characteristics of the patient that are relevant to the administration guidelines", formalDefinition="Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.)." )
        protected List<MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent> patientCharacteristic;

        private static final long serialVersionUID = 882198366L;

    /**
     * Constructor
     */
      public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent() {
        super();
      }

        /**
         * @return {@link #treatmentIntent} (The overall intention of the treatment, for example, prophylactic, supporative, curative, etc.)
         */
        public CodeableConcept getTreatmentIntent() { 
          if (this.treatmentIntent == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent.treatmentIntent");
            else if (Configuration.doAutoCreate())
              this.treatmentIntent = new CodeableConcept(); // cc
          return this.treatmentIntent;
        }

        public boolean hasTreatmentIntent() { 
          return this.treatmentIntent != null && !this.treatmentIntent.isEmpty();
        }

        /**
         * @param value {@link #treatmentIntent} (The overall intention of the treatment, for example, prophylactic, supporative, curative, etc.)
         */
        public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent setTreatmentIntent(CodeableConcept value) { 
          this.treatmentIntent = value;
          return this;
        }

        /**
         * @return {@link #dosage} (Dosage for the medication for the specific guidelines.)
         */
        public List<MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent> getDosage() { 
          if (this.dosage == null)
            this.dosage = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent>();
          return this.dosage;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent setDosage(List<MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent> theDosage) { 
          this.dosage = theDosage;
          return this;
        }

        public boolean hasDosage() { 
          if (this.dosage == null)
            return false;
          for (MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent item : this.dosage)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent addDosage() { //3
          MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent t = new MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent();
          if (this.dosage == null)
            this.dosage = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent>();
          this.dosage.add(t);
          return t;
        }

        public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent addDosage(MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent t) { //3
          if (t == null)
            return this;
          if (this.dosage == null)
            this.dosage = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent>();
          this.dosage.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dosage}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent getDosageFirstRep() { 
          if (getDosage().isEmpty()) {
            addDosage();
          }
          return getDosage().get(0);
        }

        /**
         * @return {@link #administrationTreatment} (The type of the treatment that the guideline applies to, for example, long term therapy, first line treatment, etc.)
         */
        public CodeableConcept getAdministrationTreatment() { 
          if (this.administrationTreatment == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent.administrationTreatment");
            else if (Configuration.doAutoCreate())
              this.administrationTreatment = new CodeableConcept(); // cc
          return this.administrationTreatment;
        }

        public boolean hasAdministrationTreatment() { 
          return this.administrationTreatment != null && !this.administrationTreatment.isEmpty();
        }

        /**
         * @param value {@link #administrationTreatment} (The type of the treatment that the guideline applies to, for example, long term therapy, first line treatment, etc.)
         */
        public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent setAdministrationTreatment(CodeableConcept value) { 
          this.administrationTreatment = value;
          return this;
        }

        /**
         * @return {@link #patientCharacteristic} (Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.).)
         */
        public List<MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent> getPatientCharacteristic() { 
          if (this.patientCharacteristic == null)
            this.patientCharacteristic = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent>();
          return this.patientCharacteristic;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent setPatientCharacteristic(List<MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent> thePatientCharacteristic) { 
          this.patientCharacteristic = thePatientCharacteristic;
          return this;
        }

        public boolean hasPatientCharacteristic() { 
          if (this.patientCharacteristic == null)
            return false;
          for (MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent item : this.patientCharacteristic)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent addPatientCharacteristic() { //3
          MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent t = new MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent();
          if (this.patientCharacteristic == null)
            this.patientCharacteristic = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent>();
          this.patientCharacteristic.add(t);
          return t;
        }

        public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent addPatientCharacteristic(MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent t) { //3
          if (t == null)
            return this;
          if (this.patientCharacteristic == null)
            this.patientCharacteristic = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent>();
          this.patientCharacteristic.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #patientCharacteristic}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent getPatientCharacteristicFirstRep() { 
          if (getPatientCharacteristic().isEmpty()) {
            addPatientCharacteristic();
          }
          return getPatientCharacteristic().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("treatmentIntent", "CodeableConcept", "The overall intention of the treatment, for example, prophylactic, supporative, curative, etc.", 0, 1, treatmentIntent));
          children.add(new Property("dosage", "", "Dosage for the medication for the specific guidelines.", 0, java.lang.Integer.MAX_VALUE, dosage));
          children.add(new Property("administrationTreatment", "CodeableConcept", "The type of the treatment that the guideline applies to, for example, long term therapy, first line treatment, etc.", 0, 1, administrationTreatment));
          children.add(new Property("patientCharacteristic", "", "Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.).", 0, java.lang.Integer.MAX_VALUE, patientCharacteristic));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 1744920884: /*treatmentIntent*/  return new Property("treatmentIntent", "CodeableConcept", "The overall intention of the treatment, for example, prophylactic, supporative, curative, etc.", 0, 1, treatmentIntent);
          case -1326018889: /*dosage*/  return new Property("dosage", "", "Dosage for the medication for the specific guidelines.", 0, java.lang.Integer.MAX_VALUE, dosage);
          case 1197121978: /*administrationTreatment*/  return new Property("administrationTreatment", "CodeableConcept", "The type of the treatment that the guideline applies to, for example, long term therapy, first line treatment, etc.", 0, 1, administrationTreatment);
          case 1770130432: /*patientCharacteristic*/  return new Property("patientCharacteristic", "", "Characteristics of the patient that are relevant to the administration guidelines (for example, height, weight, gender, etc.).", 0, java.lang.Integer.MAX_VALUE, patientCharacteristic);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 1744920884: /*treatmentIntent*/ return this.treatmentIntent == null ? new Base[0] : new Base[] {this.treatmentIntent}; // CodeableConcept
        case -1326018889: /*dosage*/ return this.dosage == null ? new Base[0] : this.dosage.toArray(new Base[this.dosage.size()]); // MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent
        case 1197121978: /*administrationTreatment*/ return this.administrationTreatment == null ? new Base[0] : new Base[] {this.administrationTreatment}; // CodeableConcept
        case 1770130432: /*patientCharacteristic*/ return this.patientCharacteristic == null ? new Base[0] : this.patientCharacteristic.toArray(new Base[this.patientCharacteristic.size()]); // MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 1744920884: // treatmentIntent
          this.treatmentIntent = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1326018889: // dosage
          this.getDosage().add((MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent) value); // MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent
          return value;
        case 1197121978: // administrationTreatment
          this.administrationTreatment = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1770130432: // patientCharacteristic
          this.getPatientCharacteristic().add((MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent) value); // MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("treatmentIntent")) {
          this.treatmentIntent = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("dosage")) {
          this.getDosage().add((MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent) value);
        } else if (name.equals("administrationTreatment")) {
          this.administrationTreatment = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("patientCharacteristic")) {
          this.getPatientCharacteristic().add((MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1744920884:  return getTreatmentIntent();
        case -1326018889:  return addDosage(); 
        case 1197121978:  return getAdministrationTreatment();
        case 1770130432:  return addPatientCharacteristic(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 1744920884: /*treatmentIntent*/ return new String[] {"CodeableConcept"};
        case -1326018889: /*dosage*/ return new String[] {};
        case 1197121978: /*administrationTreatment*/ return new String[] {"CodeableConcept"};
        case 1770130432: /*patientCharacteristic*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("treatmentIntent")) {
          this.treatmentIntent = new CodeableConcept();
          return this.treatmentIntent;
        }
        else if (name.equals("dosage")) {
          return addDosage();
        }
        else if (name.equals("administrationTreatment")) {
          this.administrationTreatment = new CodeableConcept();
          return this.administrationTreatment;
        }
        else if (name.equals("patientCharacteristic")) {
          return addPatientCharacteristic();
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent copy() {
        MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent dst = new MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent dst) {
        super.copyValues(dst);
        dst.treatmentIntent = treatmentIntent == null ? null : treatmentIntent.copy();
        if (dosage != null) {
          dst.dosage = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent>();
          for (MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent i : dosage)
            dst.dosage.add(i.copy());
        };
        dst.administrationTreatment = administrationTreatment == null ? null : administrationTreatment.copy();
        if (patientCharacteristic != null) {
          dst.patientCharacteristic = new ArrayList<MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent>();
          for (MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent i : patientCharacteristic)
            dst.patientCharacteristic.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent))
          return false;
        MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent o = (MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent) other_;
        return compareDeep(treatmentIntent, o.treatmentIntent, true) && compareDeep(dosage, o.dosage, true)
           && compareDeep(administrationTreatment, o.administrationTreatment, true) && compareDeep(patientCharacteristic, o.patientCharacteristic, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent))
          return false;
        MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent o = (MedicationKnowledgeIndicationGuidelineDosingGuidelineComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(treatmentIntent, dosage, administrationTreatment
          , patientCharacteristic);
      }

  public String fhirType() {
    return "MedicationKnowledge.indicationGuideline.dosingGuideline";

  }

  }

    @Block()
    public static class MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent extends BackboneElement implements IBaseBackboneElement {
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
      public MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent(CodeableConcept type, Dosage dosage) {
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
              throw new Error("Attempt to auto-create MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent.type");
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
        public MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent setType(CodeableConcept value) { 
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
        public MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent setDosage(List<Dosage> theDosage) { 
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

        public MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent addDosage(Dosage t) { //3
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

      public MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent copy() {
        MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent dst = new MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent dst) {
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
        if (!(other_ instanceof MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent))
          return false;
        MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent o = (MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(dosage, o.dosage, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent))
          return false;
        MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent o = (MedicationKnowledgeIndicationGuidelineDosingGuidelineDosageComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, dosage);
      }

  public String fhirType() {
    return "MedicationKnowledge.indicationGuideline.dosingGuideline.dosage";

  }

  }

    @Block()
    public static class MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Categorization of specific characteristic that is relevant to the administration guideline", formalDefinition="The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender)." )
        protected CodeableConcept type;

        /**
         * The specific characteristic (e.g. height, weight, gender, etc.).
         */
        @Child(name = "value", type = {CodeableConcept.class, Quantity.class, Range.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specific characteristic", formalDefinition="The specific characteristic (e.g. height, weight, gender, etc.)." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent(CodeableConcept type) {
        super();
        this.setType(type);
      }

        /**
         * @return {@link #type} (The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent.type");
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
        public MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent setType(CodeableConcept value) { 
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

        /**
         * @return {@link #value} (The specific characteristic (e.g. height, weight, gender, etc.).)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (The specific characteristic (e.g. height, weight, gender, etc.).)
         */
        public MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity || value instanceof Range))
            throw new Error("Not the right type for MedicationKnowledge.indicationGuideline.dosingGuideline.patientCharacteristic.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender).", 0, 1, type));
          children.add(new Property("value[x]", "CodeableConcept|Quantity|Range", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The categorization of the specific characteristic that is relevant to the administration guideline (e.g. height, weight, gender).", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|Quantity|Range", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|Quantity|Range", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "The specific characteristic (e.g. height, weight, gender, etc.).", 0, 1, value);
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
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "Quantity", "Range"};
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
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent copy() {
        MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent dst = new MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent))
          return false;
        MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent o = (MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent))
          return false;
        MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent o = (MedicationKnowledgeIndicationGuidelineDosingGuidelinePatientCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "MedicationKnowledge.indicationGuideline.dosingGuideline.patientCharacteristic";

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
         * Either a textual source of the classification or a reference to an online source.
         */
        @Child(name = "source", type = {StringType.class, UriType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The source of the classification", formalDefinition="Either a textual source of the classification or a reference to an online source." )
        protected DataType source;

        /**
         * Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive, antibiotic, etc.).
         */
        @Child(name = "classification", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specific category assigned to the medication", formalDefinition="Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive, antibiotic, etc.)." )
        protected List<CodeableConcept> classification;

        private static final long serialVersionUID = 1598220123L;

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
         * @return {@link #source} (Either a textual source of the classification or a reference to an online source.)
         */
        public DataType getSource() { 
          return this.source;
        }

        /**
         * @return {@link #source} (Either a textual source of the classification or a reference to an online source.)
         */
        public StringType getSourceStringType() throws FHIRException { 
          if (this.source == null)
            this.source = new StringType();
          if (!(this.source instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.source.getClass().getName()+" was encountered");
          return (StringType) this.source;
        }

        public boolean hasSourceStringType() { 
          return this != null && this.source instanceof StringType;
        }

        /**
         * @return {@link #source} (Either a textual source of the classification or a reference to an online source.)
         */
        public UriType getSourceUriType() throws FHIRException { 
          if (this.source == null)
            this.source = new UriType();
          if (!(this.source instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.source.getClass().getName()+" was encountered");
          return (UriType) this.source;
        }

        public boolean hasSourceUriType() { 
          return this != null && this.source instanceof UriType;
        }

        public boolean hasSource() { 
          return this.source != null && !this.source.isEmpty();
        }

        /**
         * @param value {@link #source} (Either a textual source of the classification or a reference to an online source.)
         */
        public MedicationKnowledgeMedicineClassificationComponent setSource(DataType value) { 
          if (value != null && !(value instanceof StringType || value instanceof UriType))
            throw new Error("Not the right type for MedicationKnowledge.medicineClassification.source[x]: "+value.fhirType());
          this.source = value;
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
          children.add(new Property("source[x]", "string|uri", "Either a textual source of the classification or a reference to an online source.", 0, 1, source));
          children.add(new Property("classification", "CodeableConcept", "Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive, antibiotic, etc.).", 0, java.lang.Integer.MAX_VALUE, classification));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of category for the medication (for example, therapeutic classification, therapeutic sub-classification).", 0, 1, type);
          case -1698413947: /*source[x]*/  return new Property("source[x]", "string|uri", "Either a textual source of the classification or a reference to an online source.", 0, 1, source);
          case -896505829: /*source*/  return new Property("source[x]", "string|uri", "Either a textual source of the classification or a reference to an online source.", 0, 1, source);
          case 1327821836: /*sourceString*/  return new Property("source[x]", "string", "Either a textual source of the classification or a reference to an online source.", 0, 1, source);
          case -1698419887: /*sourceUri*/  return new Property("source[x]", "uri", "Either a textual source of the classification or a reference to an online source.", 0, 1, source);
          case 382350310: /*classification*/  return new Property("classification", "CodeableConcept", "Specific category assigned to the medication (e.g. anti-infective, anti-hypertensive, antibiotic, etc.).", 0, java.lang.Integer.MAX_VALUE, classification);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -896505829: /*source*/ return this.source == null ? new Base[0] : new Base[] {this.source}; // DataType
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
        case -896505829: // source
          this.source = TypeConvertor.castToType(value); // DataType
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
        } else if (name.equals("source[x]")) {
          this.source = TypeConvertor.castToType(value); // DataType
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
        case -1698413947:  return getSource();
        case -896505829:  return getSource();
        case 382350310:  return addClassification(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -896505829: /*source*/ return new String[] {"string", "uri"};
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
        else if (name.equals("sourceString")) {
          this.source = new StringType();
          return this.source;
        }
        else if (name.equals("sourceUri")) {
          this.source = new UriType();
          return this.source;
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
        dst.source = source == null ? null : source.copy();
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
        return compareDeep(type, o.type, true) && compareDeep(source, o.source, true) && compareDeep(classification, o.classification, true)
          ;
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
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, source, classification
          );
      }

  public String fhirType() {
    return "MedicationKnowledge.medicineClassification";

  }

  }

    @Block()
    public static class MedicationKnowledgePackagingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The cost of the packaged medication.
         */
        @Child(name = "cost", type = {MedicationKnowledgeCostComponent.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Cost of the packaged medication", formalDefinition="The cost of the packaged medication." )
        protected List<MedicationKnowledgeCostComponent> cost;

        /**
         * A reference to a PackagedProductDefinition that provides the details of the product that is in the packaging and is being priced.
         */
        @Child(name = "packagedProduct", type = {PackagedProductDefinition.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The packaged medication that is being priced", formalDefinition="A reference to a PackagedProductDefinition that provides the details of the product that is in the packaging and is being priced." )
        protected Reference packagedProduct;

        private static final long serialVersionUID = -337249398L;

    /**
     * Constructor
     */
      public MedicationKnowledgePackagingComponent() {
        super();
      }

        /**
         * @return {@link #cost} (The cost of the packaged medication.)
         */
        public List<MedicationKnowledgeCostComponent> getCost() { 
          if (this.cost == null)
            this.cost = new ArrayList<MedicationKnowledgeCostComponent>();
          return this.cost;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgePackagingComponent setCost(List<MedicationKnowledgeCostComponent> theCost) { 
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

        public MedicationKnowledgePackagingComponent addCost(MedicationKnowledgeCostComponent t) { //3
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
         * @return {@link #packagedProduct} (A reference to a PackagedProductDefinition that provides the details of the product that is in the packaging and is being priced.)
         */
        public Reference getPackagedProduct() { 
          if (this.packagedProduct == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgePackagingComponent.packagedProduct");
            else if (Configuration.doAutoCreate())
              this.packagedProduct = new Reference(); // cc
          return this.packagedProduct;
        }

        public boolean hasPackagedProduct() { 
          return this.packagedProduct != null && !this.packagedProduct.isEmpty();
        }

        /**
         * @param value {@link #packagedProduct} (A reference to a PackagedProductDefinition that provides the details of the product that is in the packaging and is being priced.)
         */
        public MedicationKnowledgePackagingComponent setPackagedProduct(Reference value) { 
          this.packagedProduct = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("cost", "@MedicationKnowledge.cost", "The cost of the packaged medication.", 0, java.lang.Integer.MAX_VALUE, cost));
          children.add(new Property("packagedProduct", "Reference(PackagedProductDefinition)", "A reference to a PackagedProductDefinition that provides the details of the product that is in the packaging and is being priced.", 0, 1, packagedProduct));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3059661: /*cost*/  return new Property("cost", "@MedicationKnowledge.cost", "The cost of the packaged medication.", 0, java.lang.Integer.MAX_VALUE, cost);
          case 1893956145: /*packagedProduct*/  return new Property("packagedProduct", "Reference(PackagedProductDefinition)", "A reference to a PackagedProductDefinition that provides the details of the product that is in the packaging and is being priced.", 0, 1, packagedProduct);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3059661: /*cost*/ return this.cost == null ? new Base[0] : this.cost.toArray(new Base[this.cost.size()]); // MedicationKnowledgeCostComponent
        case 1893956145: /*packagedProduct*/ return this.packagedProduct == null ? new Base[0] : new Base[] {this.packagedProduct}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3059661: // cost
          this.getCost().add((MedicationKnowledgeCostComponent) value); // MedicationKnowledgeCostComponent
          return value;
        case 1893956145: // packagedProduct
          this.packagedProduct = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("cost")) {
          this.getCost().add((MedicationKnowledgeCostComponent) value);
        } else if (name.equals("packagedProduct")) {
          this.packagedProduct = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059661:  return addCost(); 
        case 1893956145:  return getPackagedProduct();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3059661: /*cost*/ return new String[] {"@MedicationKnowledge.cost"};
        case 1893956145: /*packagedProduct*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("cost")) {
          return addCost();
        }
        else if (name.equals("packagedProduct")) {
          this.packagedProduct = new Reference();
          return this.packagedProduct;
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
        if (cost != null) {
          dst.cost = new ArrayList<MedicationKnowledgeCostComponent>();
          for (MedicationKnowledgeCostComponent i : cost)
            dst.cost.add(i.copy());
        };
        dst.packagedProduct = packagedProduct == null ? null : packagedProduct.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgePackagingComponent))
          return false;
        MedicationKnowledgePackagingComponent o = (MedicationKnowledgePackagingComponent) other_;
        return compareDeep(cost, o.cost, true) && compareDeep(packagedProduct, o.packagedProduct, true)
          ;
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
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(cost, packagedProduct);
      }

  public String fhirType() {
    return "MedicationKnowledge.packaging";

  }

  }

    @Block()
    public static class MedicationKnowledgeStorageGuidelineComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Reference to additional information about the storage guidelines.
         */
        @Child(name = "reference", type = {UriType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reference to additional information", formalDefinition="Reference to additional information about the storage guidelines." )
        protected UriType reference;

        /**
         * Additional notes about the storage.
         */
        @Child(name = "note", type = {Annotation.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Additional storage notes", formalDefinition="Additional notes about the storage." )
        protected List<Annotation> note;

        /**
         * Duration that the medication remains stable if the environmentalSetting is respected.
         */
        @Child(name = "stabilityDuration", type = {Duration.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Duration remains stable", formalDefinition="Duration that the medication remains stable if the environmentalSetting is respected." )
        protected Duration stabilityDuration;

        /**
         * Describes a setting/value on the environment for the adequate storage of the medication and other substances.  Environment settings may involve temperature, humidity, or exposure to light.
         */
        @Child(name = "environmentalSetting", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Setting or value of environment for adequate storage", formalDefinition="Describes a setting/value on the environment for the adequate storage of the medication and other substances.  Environment settings may involve temperature, humidity, or exposure to light." )
        protected List<MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent> environmentalSetting;

        private static final long serialVersionUID = -304442588L;

    /**
     * Constructor
     */
      public MedicationKnowledgeStorageGuidelineComponent() {
        super();
      }

        /**
         * @return {@link #reference} (Reference to additional information about the storage guidelines.). This is the underlying object with id, value and extensions. The accessor "getReference" gives direct access to the value
         */
        public UriType getReferenceElement() { 
          if (this.reference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeStorageGuidelineComponent.reference");
            else if (Configuration.doAutoCreate())
              this.reference = new UriType(); // bb
          return this.reference;
        }

        public boolean hasReferenceElement() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        public boolean hasReference() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        /**
         * @param value {@link #reference} (Reference to additional information about the storage guidelines.). This is the underlying object with id, value and extensions. The accessor "getReference" gives direct access to the value
         */
        public MedicationKnowledgeStorageGuidelineComponent setReferenceElement(UriType value) { 
          this.reference = value;
          return this;
        }

        /**
         * @return Reference to additional information about the storage guidelines.
         */
        public String getReference() { 
          return this.reference == null ? null : this.reference.getValue();
        }

        /**
         * @param value Reference to additional information about the storage guidelines.
         */
        public MedicationKnowledgeStorageGuidelineComponent setReference(String value) { 
          if (Utilities.noString(value))
            this.reference = null;
          else {
            if (this.reference == null)
              this.reference = new UriType();
            this.reference.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #note} (Additional notes about the storage.)
         */
        public List<Annotation> getNote() { 
          if (this.note == null)
            this.note = new ArrayList<Annotation>();
          return this.note;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeStorageGuidelineComponent setNote(List<Annotation> theNote) { 
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

        public MedicationKnowledgeStorageGuidelineComponent addNote(Annotation t) { //3
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
         * @return {@link #stabilityDuration} (Duration that the medication remains stable if the environmentalSetting is respected.)
         */
        public Duration getStabilityDuration() { 
          if (this.stabilityDuration == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeStorageGuidelineComponent.stabilityDuration");
            else if (Configuration.doAutoCreate())
              this.stabilityDuration = new Duration(); // cc
          return this.stabilityDuration;
        }

        public boolean hasStabilityDuration() { 
          return this.stabilityDuration != null && !this.stabilityDuration.isEmpty();
        }

        /**
         * @param value {@link #stabilityDuration} (Duration that the medication remains stable if the environmentalSetting is respected.)
         */
        public MedicationKnowledgeStorageGuidelineComponent setStabilityDuration(Duration value) { 
          this.stabilityDuration = value;
          return this;
        }

        /**
         * @return {@link #environmentalSetting} (Describes a setting/value on the environment for the adequate storage of the medication and other substances.  Environment settings may involve temperature, humidity, or exposure to light.)
         */
        public List<MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent> getEnvironmentalSetting() { 
          if (this.environmentalSetting == null)
            this.environmentalSetting = new ArrayList<MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent>();
          return this.environmentalSetting;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeStorageGuidelineComponent setEnvironmentalSetting(List<MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent> theEnvironmentalSetting) { 
          this.environmentalSetting = theEnvironmentalSetting;
          return this;
        }

        public boolean hasEnvironmentalSetting() { 
          if (this.environmentalSetting == null)
            return false;
          for (MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent item : this.environmentalSetting)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent addEnvironmentalSetting() { //3
          MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent t = new MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent();
          if (this.environmentalSetting == null)
            this.environmentalSetting = new ArrayList<MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent>();
          this.environmentalSetting.add(t);
          return t;
        }

        public MedicationKnowledgeStorageGuidelineComponent addEnvironmentalSetting(MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent t) { //3
          if (t == null)
            return this;
          if (this.environmentalSetting == null)
            this.environmentalSetting = new ArrayList<MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent>();
          this.environmentalSetting.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #environmentalSetting}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent getEnvironmentalSettingFirstRep() { 
          if (getEnvironmentalSetting().isEmpty()) {
            addEnvironmentalSetting();
          }
          return getEnvironmentalSetting().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("reference", "uri", "Reference to additional information about the storage guidelines.", 0, 1, reference));
          children.add(new Property("note", "Annotation", "Additional notes about the storage.", 0, java.lang.Integer.MAX_VALUE, note));
          children.add(new Property("stabilityDuration", "Duration", "Duration that the medication remains stable if the environmentalSetting is respected.", 0, 1, stabilityDuration));
          children.add(new Property("environmentalSetting", "", "Describes a setting/value on the environment for the adequate storage of the medication and other substances.  Environment settings may involve temperature, humidity, or exposure to light.", 0, java.lang.Integer.MAX_VALUE, environmentalSetting));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -925155509: /*reference*/  return new Property("reference", "uri", "Reference to additional information about the storage guidelines.", 0, 1, reference);
          case 3387378: /*note*/  return new Property("note", "Annotation", "Additional notes about the storage.", 0, java.lang.Integer.MAX_VALUE, note);
          case 1823268957: /*stabilityDuration*/  return new Property("stabilityDuration", "Duration", "Duration that the medication remains stable if the environmentalSetting is respected.", 0, 1, stabilityDuration);
          case 105846514: /*environmentalSetting*/  return new Property("environmentalSetting", "", "Describes a setting/value on the environment for the adequate storage of the medication and other substances.  Environment settings may involve temperature, humidity, or exposure to light.", 0, java.lang.Integer.MAX_VALUE, environmentalSetting);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // UriType
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case 1823268957: /*stabilityDuration*/ return this.stabilityDuration == null ? new Base[0] : new Base[] {this.stabilityDuration}; // Duration
        case 105846514: /*environmentalSetting*/ return this.environmentalSetting == null ? new Base[0] : this.environmentalSetting.toArray(new Base[this.environmentalSetting.size()]); // MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -925155509: // reference
          this.reference = TypeConvertor.castToUri(value); // UriType
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case 1823268957: // stabilityDuration
          this.stabilityDuration = TypeConvertor.castToDuration(value); // Duration
          return value;
        case 105846514: // environmentalSetting
          this.getEnvironmentalSetting().add((MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent) value); // MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("reference")) {
          this.reference = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("stabilityDuration")) {
          this.stabilityDuration = TypeConvertor.castToDuration(value); // Duration
        } else if (name.equals("environmentalSetting")) {
          this.getEnvironmentalSetting().add((MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -925155509:  return getReferenceElement();
        case 3387378:  return addNote(); 
        case 1823268957:  return getStabilityDuration();
        case 105846514:  return addEnvironmentalSetting(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -925155509: /*reference*/ return new String[] {"uri"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case 1823268957: /*stabilityDuration*/ return new String[] {"Duration"};
        case 105846514: /*environmentalSetting*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("reference")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.storageGuideline.reference");
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("stabilityDuration")) {
          this.stabilityDuration = new Duration();
          return this.stabilityDuration;
        }
        else if (name.equals("environmentalSetting")) {
          return addEnvironmentalSetting();
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeStorageGuidelineComponent copy() {
        MedicationKnowledgeStorageGuidelineComponent dst = new MedicationKnowledgeStorageGuidelineComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeStorageGuidelineComponent dst) {
        super.copyValues(dst);
        dst.reference = reference == null ? null : reference.copy();
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        dst.stabilityDuration = stabilityDuration == null ? null : stabilityDuration.copy();
        if (environmentalSetting != null) {
          dst.environmentalSetting = new ArrayList<MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent>();
          for (MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent i : environmentalSetting)
            dst.environmentalSetting.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeStorageGuidelineComponent))
          return false;
        MedicationKnowledgeStorageGuidelineComponent o = (MedicationKnowledgeStorageGuidelineComponent) other_;
        return compareDeep(reference, o.reference, true) && compareDeep(note, o.note, true) && compareDeep(stabilityDuration, o.stabilityDuration, true)
           && compareDeep(environmentalSetting, o.environmentalSetting, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeStorageGuidelineComponent))
          return false;
        MedicationKnowledgeStorageGuidelineComponent o = (MedicationKnowledgeStorageGuidelineComponent) other_;
        return compareValues(reference, o.reference, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(reference, note, stabilityDuration
          , environmentalSetting);
      }

  public String fhirType() {
    return "MedicationKnowledge.storageGuideline";

  }

  }

    @Block()
    public static class MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Identifies the category or type of setting (e.g., type of location, temperature, humidity).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Categorization of the setting", formalDefinition="Identifies the category or type of setting (e.g., type of location, temperature, humidity)." )
        protected CodeableConcept type;

        /**
         * Value associated to the setting. E.g., 40° – 50°F for temperature.
         */
        @Child(name = "value", type = {Quantity.class, Range.class, CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value of the setting", formalDefinition="Value associated to the setting. E.g., 40° – 50°F for temperature." )
        protected DataType value;

        private static final long serialVersionUID = -1659186716L;

    /**
     * Constructor
     */
      public MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent(CodeableConcept type, DataType value) {
        super();
        this.setType(type);
        this.setValue(value);
      }

        /**
         * @return {@link #type} (Identifies the category or type of setting (e.g., type of location, temperature, humidity).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Identifies the category or type of setting (e.g., type of location, temperature, humidity).)
         */
        public MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #value} (Value associated to the setting. E.g., 40° – 50°F for temperature.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Value associated to the setting. E.g., 40° – 50°F for temperature.)
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
         * @return {@link #value} (Value associated to the setting. E.g., 40° – 50°F for temperature.)
         */
        public Range getValueRange() throws FHIRException { 
          if (this.value == null)
            this.value = new Range();
          if (!(this.value instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.value.getClass().getName()+" was encountered");
          return (Range) this.value;
        }

        public boolean hasValueRange() { 
          return this != null && this.value instanceof Range;
        }

        /**
         * @return {@link #value} (Value associated to the setting. E.g., 40° – 50°F for temperature.)
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

        public boolean hasValue() { 
          return this.value != null && !this.value.isEmpty();
        }

        /**
         * @param value {@link #value} (Value associated to the setting. E.g., 40° – 50°F for temperature.)
         */
        public MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent setValue(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof Range || value instanceof CodeableConcept))
            throw new Error("Not the right type for MedicationKnowledge.storageGuideline.environmentalSetting.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "CodeableConcept", "Identifies the category or type of setting (e.g., type of location, temperature, humidity).", 0, 1, type));
          children.add(new Property("value[x]", "Quantity|Range|CodeableConcept", "Value associated to the setting. E.g., 40° – 50°F for temperature.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Identifies the category or type of setting (e.g., type of location, temperature, humidity).", 0, 1, type);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "Quantity|Range|CodeableConcept", "Value associated to the setting. E.g., 40° – 50°F for temperature.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "Quantity|Range|CodeableConcept", "Value associated to the setting. E.g., 40° – 50°F for temperature.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Value associated to the setting. E.g., 40° – 50°F for temperature.", 0, 1, value);
          case 2030761548: /*valueRange*/  return new Property("value[x]", "Range", "Value associated to the setting. E.g., 40° – 50°F for temperature.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "Value associated to the setting. E.g., 40° – 50°F for temperature.", 0, 1, value);
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
        case 111972721: /*value*/ return new String[] {"Quantity", "Range", "CodeableConcept"};
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
        else if (name.equals("valueRange")) {
          this.value = new Range();
          return this.value;
        }
        else if (name.equals("valueCodeableConcept")) {
          this.value = new CodeableConcept();
          return this.value;
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent copy() {
        MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent dst = new MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent))
          return false;
        MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent o = (MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent))
          return false;
        MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent o = (MedicationKnowledgeStorageGuidelineEnvironmentalSettingComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "MedicationKnowledge.storageGuideline.environmentalSetting";

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
    public static class MedicationKnowledgeDefinitionalComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Associated definitions for this medication.
         */
        @Child(name = "definition", type = {MedicinalProductDefinition.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Definitional resources that provide more information about this medication", formalDefinition="Associated definitions for this medication." )
        protected List<Reference> definition;

        /**
         * Describes the form of the item.  Powder; tablets; capsule.
         */
        @Child(name = "doseForm", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="powder | tablets | capsule +", formalDefinition="Describes the form of the item.  Powder; tablets; capsule." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-form-codes")
        protected CodeableConcept doseForm;

        /**
         * The intended or approved route of administration.
         */
        @Child(name = "intendedRoute", type = {CodeableConcept.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="The intended or approved route of administration", formalDefinition="The intended or approved route of administration." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/route-codes")
        protected List<CodeableConcept> intendedRoute;

        /**
         * Identifies a particular constituent of interest in the product.
         */
        @Child(name = "ingredient", type = {}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
        @Description(shortDefinition="Active or inactive ingredient", formalDefinition="Identifies a particular constituent of interest in the product." )
        protected List<MedicationKnowledgeDefinitionalIngredientComponent> ingredient;

        /**
         * Specifies descriptive properties of the medicine, such as color, shape, imprints, etc.
         */
        @Child(name = "drugCharacteristic", type = {}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specifies descriptive properties of the medicine", formalDefinition="Specifies descriptive properties of the medicine, such as color, shape, imprints, etc." )
        protected List<MedicationKnowledgeDefinitionalDrugCharacteristicComponent> drugCharacteristic;

        private static final long serialVersionUID = 2050532775L;

    /**
     * Constructor
     */
      public MedicationKnowledgeDefinitionalComponent() {
        super();
      }

        /**
         * @return {@link #definition} (Associated definitions for this medication.)
         */
        public List<Reference> getDefinition() { 
          if (this.definition == null)
            this.definition = new ArrayList<Reference>();
          return this.definition;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeDefinitionalComponent setDefinition(List<Reference> theDefinition) { 
          this.definition = theDefinition;
          return this;
        }

        public boolean hasDefinition() { 
          if (this.definition == null)
            return false;
          for (Reference item : this.definition)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addDefinition() { //3
          Reference t = new Reference();
          if (this.definition == null)
            this.definition = new ArrayList<Reference>();
          this.definition.add(t);
          return t;
        }

        public MedicationKnowledgeDefinitionalComponent addDefinition(Reference t) { //3
          if (t == null)
            return this;
          if (this.definition == null)
            this.definition = new ArrayList<Reference>();
          this.definition.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #definition}, creating it if it does not already exist {3}
         */
        public Reference getDefinitionFirstRep() { 
          if (getDefinition().isEmpty()) {
            addDefinition();
          }
          return getDefinition().get(0);
        }

        /**
         * @return {@link #doseForm} (Describes the form of the item.  Powder; tablets; capsule.)
         */
        public CodeableConcept getDoseForm() { 
          if (this.doseForm == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeDefinitionalComponent.doseForm");
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
        public MedicationKnowledgeDefinitionalComponent setDoseForm(CodeableConcept value) { 
          this.doseForm = value;
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
        public MedicationKnowledgeDefinitionalComponent setIntendedRoute(List<CodeableConcept> theIntendedRoute) { 
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

        public MedicationKnowledgeDefinitionalComponent addIntendedRoute(CodeableConcept t) { //3
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
         * @return {@link #ingredient} (Identifies a particular constituent of interest in the product.)
         */
        public List<MedicationKnowledgeDefinitionalIngredientComponent> getIngredient() { 
          if (this.ingredient == null)
            this.ingredient = new ArrayList<MedicationKnowledgeDefinitionalIngredientComponent>();
          return this.ingredient;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeDefinitionalComponent setIngredient(List<MedicationKnowledgeDefinitionalIngredientComponent> theIngredient) { 
          this.ingredient = theIngredient;
          return this;
        }

        public boolean hasIngredient() { 
          if (this.ingredient == null)
            return false;
          for (MedicationKnowledgeDefinitionalIngredientComponent item : this.ingredient)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgeDefinitionalIngredientComponent addIngredient() { //3
          MedicationKnowledgeDefinitionalIngredientComponent t = new MedicationKnowledgeDefinitionalIngredientComponent();
          if (this.ingredient == null)
            this.ingredient = new ArrayList<MedicationKnowledgeDefinitionalIngredientComponent>();
          this.ingredient.add(t);
          return t;
        }

        public MedicationKnowledgeDefinitionalComponent addIngredient(MedicationKnowledgeDefinitionalIngredientComponent t) { //3
          if (t == null)
            return this;
          if (this.ingredient == null)
            this.ingredient = new ArrayList<MedicationKnowledgeDefinitionalIngredientComponent>();
          this.ingredient.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #ingredient}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgeDefinitionalIngredientComponent getIngredientFirstRep() { 
          if (getIngredient().isEmpty()) {
            addIngredient();
          }
          return getIngredient().get(0);
        }

        /**
         * @return {@link #drugCharacteristic} (Specifies descriptive properties of the medicine, such as color, shape, imprints, etc.)
         */
        public List<MedicationKnowledgeDefinitionalDrugCharacteristicComponent> getDrugCharacteristic() { 
          if (this.drugCharacteristic == null)
            this.drugCharacteristic = new ArrayList<MedicationKnowledgeDefinitionalDrugCharacteristicComponent>();
          return this.drugCharacteristic;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public MedicationKnowledgeDefinitionalComponent setDrugCharacteristic(List<MedicationKnowledgeDefinitionalDrugCharacteristicComponent> theDrugCharacteristic) { 
          this.drugCharacteristic = theDrugCharacteristic;
          return this;
        }

        public boolean hasDrugCharacteristic() { 
          if (this.drugCharacteristic == null)
            return false;
          for (MedicationKnowledgeDefinitionalDrugCharacteristicComponent item : this.drugCharacteristic)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public MedicationKnowledgeDefinitionalDrugCharacteristicComponent addDrugCharacteristic() { //3
          MedicationKnowledgeDefinitionalDrugCharacteristicComponent t = new MedicationKnowledgeDefinitionalDrugCharacteristicComponent();
          if (this.drugCharacteristic == null)
            this.drugCharacteristic = new ArrayList<MedicationKnowledgeDefinitionalDrugCharacteristicComponent>();
          this.drugCharacteristic.add(t);
          return t;
        }

        public MedicationKnowledgeDefinitionalComponent addDrugCharacteristic(MedicationKnowledgeDefinitionalDrugCharacteristicComponent t) { //3
          if (t == null)
            return this;
          if (this.drugCharacteristic == null)
            this.drugCharacteristic = new ArrayList<MedicationKnowledgeDefinitionalDrugCharacteristicComponent>();
          this.drugCharacteristic.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #drugCharacteristic}, creating it if it does not already exist {3}
         */
        public MedicationKnowledgeDefinitionalDrugCharacteristicComponent getDrugCharacteristicFirstRep() { 
          if (getDrugCharacteristic().isEmpty()) {
            addDrugCharacteristic();
          }
          return getDrugCharacteristic().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("definition", "Reference(MedicinalProductDefinition)", "Associated definitions for this medication.", 0, java.lang.Integer.MAX_VALUE, definition));
          children.add(new Property("doseForm", "CodeableConcept", "Describes the form of the item.  Powder; tablets; capsule.", 0, 1, doseForm));
          children.add(new Property("intendedRoute", "CodeableConcept", "The intended or approved route of administration.", 0, java.lang.Integer.MAX_VALUE, intendedRoute));
          children.add(new Property("ingredient", "", "Identifies a particular constituent of interest in the product.", 0, java.lang.Integer.MAX_VALUE, ingredient));
          children.add(new Property("drugCharacteristic", "", "Specifies descriptive properties of the medicine, such as color, shape, imprints, etc.", 0, java.lang.Integer.MAX_VALUE, drugCharacteristic));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1014418093: /*definition*/  return new Property("definition", "Reference(MedicinalProductDefinition)", "Associated definitions for this medication.", 0, java.lang.Integer.MAX_VALUE, definition);
          case 1303858817: /*doseForm*/  return new Property("doseForm", "CodeableConcept", "Describes the form of the item.  Powder; tablets; capsule.", 0, 1, doseForm);
          case -767798050: /*intendedRoute*/  return new Property("intendedRoute", "CodeableConcept", "The intended or approved route of administration.", 0, java.lang.Integer.MAX_VALUE, intendedRoute);
          case -206409263: /*ingredient*/  return new Property("ingredient", "", "Identifies a particular constituent of interest in the product.", 0, java.lang.Integer.MAX_VALUE, ingredient);
          case -844126885: /*drugCharacteristic*/  return new Property("drugCharacteristic", "", "Specifies descriptive properties of the medicine, such as color, shape, imprints, etc.", 0, java.lang.Integer.MAX_VALUE, drugCharacteristic);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : this.definition.toArray(new Base[this.definition.size()]); // Reference
        case 1303858817: /*doseForm*/ return this.doseForm == null ? new Base[0] : new Base[] {this.doseForm}; // CodeableConcept
        case -767798050: /*intendedRoute*/ return this.intendedRoute == null ? new Base[0] : this.intendedRoute.toArray(new Base[this.intendedRoute.size()]); // CodeableConcept
        case -206409263: /*ingredient*/ return this.ingredient == null ? new Base[0] : this.ingredient.toArray(new Base[this.ingredient.size()]); // MedicationKnowledgeDefinitionalIngredientComponent
        case -844126885: /*drugCharacteristic*/ return this.drugCharacteristic == null ? new Base[0] : this.drugCharacteristic.toArray(new Base[this.drugCharacteristic.size()]); // MedicationKnowledgeDefinitionalDrugCharacteristicComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1014418093: // definition
          this.getDefinition().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1303858817: // doseForm
          this.doseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -767798050: // intendedRoute
          this.getIntendedRoute().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -206409263: // ingredient
          this.getIngredient().add((MedicationKnowledgeDefinitionalIngredientComponent) value); // MedicationKnowledgeDefinitionalIngredientComponent
          return value;
        case -844126885: // drugCharacteristic
          this.getDrugCharacteristic().add((MedicationKnowledgeDefinitionalDrugCharacteristicComponent) value); // MedicationKnowledgeDefinitionalDrugCharacteristicComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("definition")) {
          this.getDefinition().add(TypeConvertor.castToReference(value));
        } else if (name.equals("doseForm")) {
          this.doseForm = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("intendedRoute")) {
          this.getIntendedRoute().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("ingredient")) {
          this.getIngredient().add((MedicationKnowledgeDefinitionalIngredientComponent) value);
        } else if (name.equals("drugCharacteristic")) {
          this.getDrugCharacteristic().add((MedicationKnowledgeDefinitionalDrugCharacteristicComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1014418093:  return addDefinition(); 
        case 1303858817:  return getDoseForm();
        case -767798050:  return addIntendedRoute(); 
        case -206409263:  return addIngredient(); 
        case -844126885:  return addDrugCharacteristic(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1014418093: /*definition*/ return new String[] {"Reference"};
        case 1303858817: /*doseForm*/ return new String[] {"CodeableConcept"};
        case -767798050: /*intendedRoute*/ return new String[] {"CodeableConcept"};
        case -206409263: /*ingredient*/ return new String[] {};
        case -844126885: /*drugCharacteristic*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("definition")) {
          return addDefinition();
        }
        else if (name.equals("doseForm")) {
          this.doseForm = new CodeableConcept();
          return this.doseForm;
        }
        else if (name.equals("intendedRoute")) {
          return addIntendedRoute();
        }
        else if (name.equals("ingredient")) {
          return addIngredient();
        }
        else if (name.equals("drugCharacteristic")) {
          return addDrugCharacteristic();
        }
        else
          return super.addChild(name);
      }

      public MedicationKnowledgeDefinitionalComponent copy() {
        MedicationKnowledgeDefinitionalComponent dst = new MedicationKnowledgeDefinitionalComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeDefinitionalComponent dst) {
        super.copyValues(dst);
        if (definition != null) {
          dst.definition = new ArrayList<Reference>();
          for (Reference i : definition)
            dst.definition.add(i.copy());
        };
        dst.doseForm = doseForm == null ? null : doseForm.copy();
        if (intendedRoute != null) {
          dst.intendedRoute = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : intendedRoute)
            dst.intendedRoute.add(i.copy());
        };
        if (ingredient != null) {
          dst.ingredient = new ArrayList<MedicationKnowledgeDefinitionalIngredientComponent>();
          for (MedicationKnowledgeDefinitionalIngredientComponent i : ingredient)
            dst.ingredient.add(i.copy());
        };
        if (drugCharacteristic != null) {
          dst.drugCharacteristic = new ArrayList<MedicationKnowledgeDefinitionalDrugCharacteristicComponent>();
          for (MedicationKnowledgeDefinitionalDrugCharacteristicComponent i : drugCharacteristic)
            dst.drugCharacteristic.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeDefinitionalComponent))
          return false;
        MedicationKnowledgeDefinitionalComponent o = (MedicationKnowledgeDefinitionalComponent) other_;
        return compareDeep(definition, o.definition, true) && compareDeep(doseForm, o.doseForm, true) && compareDeep(intendedRoute, o.intendedRoute, true)
           && compareDeep(ingredient, o.ingredient, true) && compareDeep(drugCharacteristic, o.drugCharacteristic, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeDefinitionalComponent))
          return false;
        MedicationKnowledgeDefinitionalComponent o = (MedicationKnowledgeDefinitionalComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(definition, doseForm, intendedRoute
          , ingredient, drugCharacteristic);
      }

  public String fhirType() {
    return "MedicationKnowledge.definitional";

  }

  }

    @Block()
    public static class MedicationKnowledgeDefinitionalIngredientComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A reference to the resource that provides information about the ingredient.
         */
        @Child(name = "item", type = {CodeableReference.class}, order=1, min=1, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Substances contained in the medication", formalDefinition="A reference to the resource that provides information about the ingredient." )
        protected CodeableReference item;

        /**
         * Indication of whether this ingredient affects the therapeutic action of the drug.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="A code that defines the type of ingredient, active, base, etc", formalDefinition="Indication of whether this ingredient affects the therapeutic action of the drug." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v3-RoleClassIngredientEntity")
        protected CodeableConcept type;

        /**
         * Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.
         */
        @Child(name = "strength", type = {Ratio.class, CodeableConcept.class, Quantity.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Quantity of ingredient present", formalDefinition="Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-ingredientstrength")
        protected DataType strength;

        private static final long serialVersionUID = 1772676131L;

    /**
     * Constructor
     */
      public MedicationKnowledgeDefinitionalIngredientComponent() {
        super();
      }

    /**
     * Constructor
     */
      public MedicationKnowledgeDefinitionalIngredientComponent(CodeableReference item) {
        super();
        this.setItem(item);
      }

        /**
         * @return {@link #item} (A reference to the resource that provides information about the ingredient.)
         */
        public CodeableReference getItem() { 
          if (this.item == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeDefinitionalIngredientComponent.item");
            else if (Configuration.doAutoCreate())
              this.item = new CodeableReference(); // cc
          return this.item;
        }

        public boolean hasItem() { 
          return this.item != null && !this.item.isEmpty();
        }

        /**
         * @param value {@link #item} (A reference to the resource that provides information about the ingredient.)
         */
        public MedicationKnowledgeDefinitionalIngredientComponent setItem(CodeableReference value) { 
          this.item = value;
          return this;
        }

        /**
         * @return {@link #type} (Indication of whether this ingredient affects the therapeutic action of the drug.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeDefinitionalIngredientComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Indication of whether this ingredient affects the therapeutic action of the drug.)
         */
        public MedicationKnowledgeDefinitionalIngredientComponent setType(CodeableConcept value) { 
          this.type = value;
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
        public MedicationKnowledgeDefinitionalIngredientComponent setStrength(DataType value) { 
          if (value != null && !(value instanceof Ratio || value instanceof CodeableConcept || value instanceof Quantity))
            throw new Error("Not the right type for MedicationKnowledge.definitional.ingredient.strength[x]: "+value.fhirType());
          this.strength = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("item", "CodeableReference(Substance)", "A reference to the resource that provides information about the ingredient.", 0, 1, item));
          children.add(new Property("type", "CodeableConcept", "Indication of whether this ingredient affects the therapeutic action of the drug.", 0, 1, type));
          children.add(new Property("strength[x]", "Ratio|CodeableConcept|Quantity", "Specifies how many (or how much) of the items there are in this Medication.  For example, 250 mg per tablet.  This is expressed as a ratio where the numerator is 250mg and the denominator is 1 tablet but can also be expressed a quantity when the denominator is assumed to be 1 tablet.", 0, 1, strength));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3242771: /*item*/  return new Property("item", "CodeableReference(Substance)", "A reference to the resource that provides information about the ingredient.", 0, 1, item);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "Indication of whether this ingredient affects the therapeutic action of the drug.", 0, 1, type);
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
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
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
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
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
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
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
        case 3575610:  return getType();
        case 127377567:  return getStrength();
        case 1791316033:  return getStrength();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3242771: /*item*/ return new String[] {"CodeableReference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
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
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
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

      public MedicationKnowledgeDefinitionalIngredientComponent copy() {
        MedicationKnowledgeDefinitionalIngredientComponent dst = new MedicationKnowledgeDefinitionalIngredientComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeDefinitionalIngredientComponent dst) {
        super.copyValues(dst);
        dst.item = item == null ? null : item.copy();
        dst.type = type == null ? null : type.copy();
        dst.strength = strength == null ? null : strength.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeDefinitionalIngredientComponent))
          return false;
        MedicationKnowledgeDefinitionalIngredientComponent o = (MedicationKnowledgeDefinitionalIngredientComponent) other_;
        return compareDeep(item, o.item, true) && compareDeep(type, o.type, true) && compareDeep(strength, o.strength, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeDefinitionalIngredientComponent))
          return false;
        MedicationKnowledgeDefinitionalIngredientComponent o = (MedicationKnowledgeDefinitionalIngredientComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(item, type, strength);
      }

  public String fhirType() {
    return "MedicationKnowledge.definitional.ingredient";

  }

  }

    @Block()
    public static class MedicationKnowledgeDefinitionalDrugCharacteristicComponent extends BackboneElement implements IBaseBackboneElement {
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
      public MedicationKnowledgeDefinitionalDrugCharacteristicComponent() {
        super();
      }

        /**
         * @return {@link #type} (A code specifying which characteristic of the medicine is being described (for example, colour, shape, imprint).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create MedicationKnowledgeDefinitionalDrugCharacteristicComponent.type");
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
        public MedicationKnowledgeDefinitionalDrugCharacteristicComponent setType(CodeableConcept value) { 
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
        public MedicationKnowledgeDefinitionalDrugCharacteristicComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof StringType || value instanceof Quantity || value instanceof Base64BinaryType || value instanceof Attachment))
            throw new Error("Not the right type for MedicationKnowledge.definitional.drugCharacteristic.value[x]: "+value.fhirType());
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

      public MedicationKnowledgeDefinitionalDrugCharacteristicComponent copy() {
        MedicationKnowledgeDefinitionalDrugCharacteristicComponent dst = new MedicationKnowledgeDefinitionalDrugCharacteristicComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(MedicationKnowledgeDefinitionalDrugCharacteristicComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeDefinitionalDrugCharacteristicComponent))
          return false;
        MedicationKnowledgeDefinitionalDrugCharacteristicComponent o = (MedicationKnowledgeDefinitionalDrugCharacteristicComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(value, o.value, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledgeDefinitionalDrugCharacteristicComponent))
          return false;
        MedicationKnowledgeDefinitionalDrugCharacteristicComponent o = (MedicationKnowledgeDefinitionalDrugCharacteristicComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, value);
      }

  public String fhirType() {
    return "MedicationKnowledge.definitional.drugCharacteristic";

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
     * A code to indicate if the medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system. The status refers to the validity about the information of the medication and not to its medicinal properties.
     */
    @Child(name = "status", type = {CodeType.class}, order=2, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="active | entered-in-error | inactive", formalDefinition="A code to indicate if the medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system. The status refers to the validity about the information of the medication and not to its medicinal properties." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medicationknowledge-status")
    protected Enumeration<MedicationKnowledgeStatusCodes> status;

    /**
     * The creator or owner of the knowledge or information about the medication.
     */
    @Child(name = "author", type = {Organization.class}, order=3, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Creator or owner of the knowledge or information about the medication", formalDefinition="The creator or owner of the knowledge or information about the medication." )
    protected Reference author;

    /**
     * Lists the jurisdictions that this medication knowledge was written for.
     */
    @Child(name = "intendedJurisdiction", type = {CodeableConcept.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Codes that identify the different jurisdictions for which the information of this resource was created", formalDefinition="Lists the jurisdictions that this medication knowledge was written for." )
    protected List<CodeableConcept> intendedJurisdiction;

    /**
     * All of the names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.
     */
    @Child(name = "name", type = {StringType.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="A name associated with the medication being described", formalDefinition="All of the names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol." )
    protected List<StringType> name;

    /**
     * Associated or related medications. For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor.
     */
    @Child(name = "relatedMedicationKnowledge", type = {}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Associated or related medication information", formalDefinition="Associated or related medications. For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor." )
    protected List<MedicationKnowledgeRelatedMedicationKnowledgeComponent> relatedMedicationKnowledge;

    /**
     * Links to associated medications that could be prescribed, dispensed or administered.
     */
    @Child(name = "associatedMedication", type = {Medication.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The set of medication resources that are associated with this medication", formalDefinition="Links to associated medications that could be prescribed, dispensed or administered." )
    protected List<Reference> associatedMedication;

    /**
     * Category of the medication or product (e.g. branded product, therapeutic moeity, generic product, innovator product, etc.).
     */
    @Child(name = "productType", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Category of the medication or product", formalDefinition="Category of the medication or product (e.g. branded product, therapeutic moeity, generic product, innovator product, etc.)." )
    protected List<CodeableConcept> productType;

    /**
     * Associated documentation about the medication.
     */
    @Child(name = "monograph", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Associated documentation about the medication", formalDefinition="Associated documentation about the medication." )
    protected List<MedicationKnowledgeMonographComponent> monograph;

    /**
     * The instructions for preparing the medication.
     */
    @Child(name = "preparationInstruction", type = {MarkdownType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The instructions for preparing the medication", formalDefinition="The instructions for preparing the medication." )
    protected MarkdownType preparationInstruction;

    /**
     * The price of the medication.
     */
    @Child(name = "cost", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="The pricing of the medication", formalDefinition="The price of the medication." )
    protected List<MedicationKnowledgeCostComponent> cost;

    /**
     * The program under which the medication is reviewed.
     */
    @Child(name = "monitoringProgram", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Program under which a medication is reviewed", formalDefinition="The program under which the medication is reviewed." )
    protected List<MedicationKnowledgeMonitoringProgramComponent> monitoringProgram;

    /**
     * Guidelines or protocols that are applicable for the administration of the medication based on indication.
     */
    @Child(name = "indicationGuideline", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Guidelines or protocols for administration of the medication for an indication", formalDefinition="Guidelines or protocols that are applicable for the administration of the medication based on indication." )
    protected List<MedicationKnowledgeIndicationGuidelineComponent> indicationGuideline;

    /**
     * Categorization of the medication within a formulary or classification system.
     */
    @Child(name = "medicineClassification", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Categorization of the medication within a formulary or classification system", formalDefinition="Categorization of the medication within a formulary or classification system." )
    protected List<MedicationKnowledgeMedicineClassificationComponent> medicineClassification;

    /**
     * Information that only applies to packages (not products).
     */
    @Child(name = "packaging", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Details about packaged medications", formalDefinition="Information that only applies to packages (not products)." )
    protected List<MedicationKnowledgePackagingComponent> packaging;

    /**
     * Potential clinical issue with or between medication(s) (for example, drug-drug interaction, drug-disease contraindication, drug-allergy interaction, etc.).
     */
    @Child(name = "clinicalUseIssue", type = {ClinicalUseDefinition.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Potential clinical issue with or between medication(s)", formalDefinition="Potential clinical issue with or between medication(s) (for example, drug-drug interaction, drug-disease contraindication, drug-allergy interaction, etc.)." )
    protected List<Reference> clinicalUseIssue;

    /**
     * Information on how the medication should be stored, for example, refrigeration temperatures and length of stability at a given temperature.
     */
    @Child(name = "storageGuideline", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="How the medication should be stored", formalDefinition="Information on how the medication should be stored, for example, refrigeration temperatures and length of stability at a given temperature." )
    protected List<MedicationKnowledgeStorageGuidelineComponent> storageGuideline;

    /**
     * Regulatory information about a medication.
     */
    @Child(name = "regulatory", type = {}, order=18, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Regulatory information about a medication", formalDefinition="Regulatory information about a medication." )
    protected List<MedicationKnowledgeRegulatoryComponent> regulatory;

    /**
     * Along with the link to a Medicinal Product Definition resource, this information provides common definitional elements that are needed to understand the specific medication that is being described.
     */
    @Child(name = "definitional", type = {}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Minimal definition information about the medication", formalDefinition="Along with the link to a Medicinal Product Definition resource, this information provides common definitional elements that are needed to understand the specific medication that is being described." )
    protected MedicationKnowledgeDefinitionalComponent definitional;

    private static final long serialVersionUID = -814493741L;

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
     * @return {@link #status} (A code to indicate if the medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system. The status refers to the validity about the information of the medication and not to its medicinal properties.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
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
     * @param value {@link #status} (A code to indicate if the medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system. The status refers to the validity about the information of the medication and not to its medicinal properties.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public MedicationKnowledge setStatusElement(Enumeration<MedicationKnowledgeStatusCodes> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return A code to indicate if the medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system. The status refers to the validity about the information of the medication and not to its medicinal properties.
     */
    public MedicationKnowledgeStatusCodes getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value A code to indicate if the medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system. The status refers to the validity about the information of the medication and not to its medicinal properties.
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
     * @return {@link #author} (The creator or owner of the knowledge or information about the medication.)
     */
    public Reference getAuthor() { 
      if (this.author == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationKnowledge.author");
        else if (Configuration.doAutoCreate())
          this.author = new Reference(); // cc
      return this.author;
    }

    public boolean hasAuthor() { 
      return this.author != null && !this.author.isEmpty();
    }

    /**
     * @param value {@link #author} (The creator or owner of the knowledge or information about the medication.)
     */
    public MedicationKnowledge setAuthor(Reference value) { 
      this.author = value;
      return this;
    }

    /**
     * @return {@link #intendedJurisdiction} (Lists the jurisdictions that this medication knowledge was written for.)
     */
    public List<CodeableConcept> getIntendedJurisdiction() { 
      if (this.intendedJurisdiction == null)
        this.intendedJurisdiction = new ArrayList<CodeableConcept>();
      return this.intendedJurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setIntendedJurisdiction(List<CodeableConcept> theIntendedJurisdiction) { 
      this.intendedJurisdiction = theIntendedJurisdiction;
      return this;
    }

    public boolean hasIntendedJurisdiction() { 
      if (this.intendedJurisdiction == null)
        return false;
      for (CodeableConcept item : this.intendedJurisdiction)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addIntendedJurisdiction() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.intendedJurisdiction == null)
        this.intendedJurisdiction = new ArrayList<CodeableConcept>();
      this.intendedJurisdiction.add(t);
      return t;
    }

    public MedicationKnowledge addIntendedJurisdiction(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.intendedJurisdiction == null)
        this.intendedJurisdiction = new ArrayList<CodeableConcept>();
      this.intendedJurisdiction.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #intendedJurisdiction}, creating it if it does not already exist {3}
     */
    public CodeableConcept getIntendedJurisdictionFirstRep() { 
      if (getIntendedJurisdiction().isEmpty()) {
        addIntendedJurisdiction();
      }
      return getIntendedJurisdiction().get(0);
    }

    /**
     * @return {@link #name} (All of the names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.)
     */
    public List<StringType> getName() { 
      if (this.name == null)
        this.name = new ArrayList<StringType>();
      return this.name;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setName(List<StringType> theName) { 
      this.name = theName;
      return this;
    }

    public boolean hasName() { 
      if (this.name == null)
        return false;
      for (StringType item : this.name)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #name} (All of the names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.)
     */
    public StringType addNameElement() {//2 
      StringType t = new StringType();
      if (this.name == null)
        this.name = new ArrayList<StringType>();
      this.name.add(t);
      return t;
    }

    /**
     * @param value {@link #name} (All of the names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.)
     */
    public MedicationKnowledge addName(String value) { //1
      StringType t = new StringType();
      t.setValue(value);
      if (this.name == null)
        this.name = new ArrayList<StringType>();
      this.name.add(t);
      return this;
    }

    /**
     * @param value {@link #name} (All of the names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.)
     */
    public boolean hasName(String value) { 
      if (this.name == null)
        return false;
      for (StringType v : this.name)
        if (v.getValue().equals(value)) // string
          return true;
      return false;
    }

    /**
     * @return {@link #relatedMedicationKnowledge} (Associated or related medications. For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor.)
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
     * @return {@link #associatedMedication} (Links to associated medications that could be prescribed, dispensed or administered.)
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
      if (Utilities.noString(value))
        this.preparationInstruction = null;
      else {
        if (this.preparationInstruction == null)
          this.preparationInstruction = new MarkdownType();
        this.preparationInstruction.setValue(value);
      }
      return this;
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
     * @return {@link #indicationGuideline} (Guidelines or protocols that are applicable for the administration of the medication based on indication.)
     */
    public List<MedicationKnowledgeIndicationGuidelineComponent> getIndicationGuideline() { 
      if (this.indicationGuideline == null)
        this.indicationGuideline = new ArrayList<MedicationKnowledgeIndicationGuidelineComponent>();
      return this.indicationGuideline;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setIndicationGuideline(List<MedicationKnowledgeIndicationGuidelineComponent> theIndicationGuideline) { 
      this.indicationGuideline = theIndicationGuideline;
      return this;
    }

    public boolean hasIndicationGuideline() { 
      if (this.indicationGuideline == null)
        return false;
      for (MedicationKnowledgeIndicationGuidelineComponent item : this.indicationGuideline)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeIndicationGuidelineComponent addIndicationGuideline() { //3
      MedicationKnowledgeIndicationGuidelineComponent t = new MedicationKnowledgeIndicationGuidelineComponent();
      if (this.indicationGuideline == null)
        this.indicationGuideline = new ArrayList<MedicationKnowledgeIndicationGuidelineComponent>();
      this.indicationGuideline.add(t);
      return t;
    }

    public MedicationKnowledge addIndicationGuideline(MedicationKnowledgeIndicationGuidelineComponent t) { //3
      if (t == null)
        return this;
      if (this.indicationGuideline == null)
        this.indicationGuideline = new ArrayList<MedicationKnowledgeIndicationGuidelineComponent>();
      this.indicationGuideline.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #indicationGuideline}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeIndicationGuidelineComponent getIndicationGuidelineFirstRep() { 
      if (getIndicationGuideline().isEmpty()) {
        addIndicationGuideline();
      }
      return getIndicationGuideline().get(0);
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
    public List<MedicationKnowledgePackagingComponent> getPackaging() { 
      if (this.packaging == null)
        this.packaging = new ArrayList<MedicationKnowledgePackagingComponent>();
      return this.packaging;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setPackaging(List<MedicationKnowledgePackagingComponent> thePackaging) { 
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

    public MedicationKnowledge addPackaging(MedicationKnowledgePackagingComponent t) { //3
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
     * @return {@link #storageGuideline} (Information on how the medication should be stored, for example, refrigeration temperatures and length of stability at a given temperature.)
     */
    public List<MedicationKnowledgeStorageGuidelineComponent> getStorageGuideline() { 
      if (this.storageGuideline == null)
        this.storageGuideline = new ArrayList<MedicationKnowledgeStorageGuidelineComponent>();
      return this.storageGuideline;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public MedicationKnowledge setStorageGuideline(List<MedicationKnowledgeStorageGuidelineComponent> theStorageGuideline) { 
      this.storageGuideline = theStorageGuideline;
      return this;
    }

    public boolean hasStorageGuideline() { 
      if (this.storageGuideline == null)
        return false;
      for (MedicationKnowledgeStorageGuidelineComponent item : this.storageGuideline)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public MedicationKnowledgeStorageGuidelineComponent addStorageGuideline() { //3
      MedicationKnowledgeStorageGuidelineComponent t = new MedicationKnowledgeStorageGuidelineComponent();
      if (this.storageGuideline == null)
        this.storageGuideline = new ArrayList<MedicationKnowledgeStorageGuidelineComponent>();
      this.storageGuideline.add(t);
      return t;
    }

    public MedicationKnowledge addStorageGuideline(MedicationKnowledgeStorageGuidelineComponent t) { //3
      if (t == null)
        return this;
      if (this.storageGuideline == null)
        this.storageGuideline = new ArrayList<MedicationKnowledgeStorageGuidelineComponent>();
      this.storageGuideline.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #storageGuideline}, creating it if it does not already exist {3}
     */
    public MedicationKnowledgeStorageGuidelineComponent getStorageGuidelineFirstRep() { 
      if (getStorageGuideline().isEmpty()) {
        addStorageGuideline();
      }
      return getStorageGuideline().get(0);
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
     * @return {@link #definitional} (Along with the link to a Medicinal Product Definition resource, this information provides common definitional elements that are needed to understand the specific medication that is being described.)
     */
    public MedicationKnowledgeDefinitionalComponent getDefinitional() { 
      if (this.definitional == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create MedicationKnowledge.definitional");
        else if (Configuration.doAutoCreate())
          this.definitional = new MedicationKnowledgeDefinitionalComponent(); // cc
      return this.definitional;
    }

    public boolean hasDefinitional() { 
      return this.definitional != null && !this.definitional.isEmpty();
    }

    /**
     * @param value {@link #definitional} (Along with the link to a Medicinal Product Definition resource, this information provides common definitional elements that are needed to understand the specific medication that is being described.)
     */
    public MedicationKnowledge setDefinitional(MedicationKnowledgeDefinitionalComponent value) { 
      this.definitional = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Business identifier for this medication.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("code", "CodeableConcept", "A code that specifies this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.", 0, 1, code));
        children.add(new Property("status", "code", "A code to indicate if the medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system. The status refers to the validity about the information of the medication and not to its medicinal properties.", 0, 1, status));
        children.add(new Property("author", "Reference(Organization)", "The creator or owner of the knowledge or information about the medication.", 0, 1, author));
        children.add(new Property("intendedJurisdiction", "CodeableConcept", "Lists the jurisdictions that this medication knowledge was written for.", 0, java.lang.Integer.MAX_VALUE, intendedJurisdiction));
        children.add(new Property("name", "string", "All of the names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.", 0, java.lang.Integer.MAX_VALUE, name));
        children.add(new Property("relatedMedicationKnowledge", "", "Associated or related medications. For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor.", 0, java.lang.Integer.MAX_VALUE, relatedMedicationKnowledge));
        children.add(new Property("associatedMedication", "Reference(Medication)", "Links to associated medications that could be prescribed, dispensed or administered.", 0, java.lang.Integer.MAX_VALUE, associatedMedication));
        children.add(new Property("productType", "CodeableConcept", "Category of the medication or product (e.g. branded product, therapeutic moeity, generic product, innovator product, etc.).", 0, java.lang.Integer.MAX_VALUE, productType));
        children.add(new Property("monograph", "", "Associated documentation about the medication.", 0, java.lang.Integer.MAX_VALUE, monograph));
        children.add(new Property("preparationInstruction", "markdown", "The instructions for preparing the medication.", 0, 1, preparationInstruction));
        children.add(new Property("cost", "", "The price of the medication.", 0, java.lang.Integer.MAX_VALUE, cost));
        children.add(new Property("monitoringProgram", "", "The program under which the medication is reviewed.", 0, java.lang.Integer.MAX_VALUE, monitoringProgram));
        children.add(new Property("indicationGuideline", "", "Guidelines or protocols that are applicable for the administration of the medication based on indication.", 0, java.lang.Integer.MAX_VALUE, indicationGuideline));
        children.add(new Property("medicineClassification", "", "Categorization of the medication within a formulary or classification system.", 0, java.lang.Integer.MAX_VALUE, medicineClassification));
        children.add(new Property("packaging", "", "Information that only applies to packages (not products).", 0, java.lang.Integer.MAX_VALUE, packaging));
        children.add(new Property("clinicalUseIssue", "Reference(ClinicalUseDefinition)", "Potential clinical issue with or between medication(s) (for example, drug-drug interaction, drug-disease contraindication, drug-allergy interaction, etc.).", 0, java.lang.Integer.MAX_VALUE, clinicalUseIssue));
        children.add(new Property("storageGuideline", "", "Information on how the medication should be stored, for example, refrigeration temperatures and length of stability at a given temperature.", 0, java.lang.Integer.MAX_VALUE, storageGuideline));
        children.add(new Property("regulatory", "", "Regulatory information about a medication.", 0, java.lang.Integer.MAX_VALUE, regulatory));
        children.add(new Property("definitional", "", "Along with the link to a Medicinal Product Definition resource, this information provides common definitional elements that are needed to understand the specific medication that is being described.", 0, 1, definitional));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Business identifier for this medication.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that specifies this medication, or a textual description if no code is available. Usage note: This could be a standard medication code such as a code from RxNorm, SNOMED CT, IDMP etc. It could also be a national or local formulary code, optionally with translations to other code systems.", 0, 1, code);
        case -892481550: /*status*/  return new Property("status", "code", "A code to indicate if the medication referred to by this MedicationKnowledge is in active use within the drug database or inventory system. The status refers to the validity about the information of the medication and not to its medicinal properties.", 0, 1, status);
        case -1406328437: /*author*/  return new Property("author", "Reference(Organization)", "The creator or owner of the knowledge or information about the medication.", 0, 1, author);
        case 2136596300: /*intendedJurisdiction*/  return new Property("intendedJurisdiction", "CodeableConcept", "Lists the jurisdictions that this medication knowledge was written for.", 0, java.lang.Integer.MAX_VALUE, intendedJurisdiction);
        case 3373707: /*name*/  return new Property("name", "string", "All of the names for a medication, for example, the name(s) given to a medication in different countries.  For example, acetaminophen and paracetamol or salbutamol and albuterol.", 0, java.lang.Integer.MAX_VALUE, name);
        case 723067972: /*relatedMedicationKnowledge*/  return new Property("relatedMedicationKnowledge", "", "Associated or related medications. For example, if the medication is a branded product (e.g. Crestor), this is the Therapeutic Moeity (e.g. Rosuvastatin) or if this is a generic medication (e.g. Rosuvastatin), this would link to a branded product (e.g. Crestor.", 0, java.lang.Integer.MAX_VALUE, relatedMedicationKnowledge);
        case 1312779381: /*associatedMedication*/  return new Property("associatedMedication", "Reference(Medication)", "Links to associated medications that could be prescribed, dispensed or administered.", 0, java.lang.Integer.MAX_VALUE, associatedMedication);
        case -1491615543: /*productType*/  return new Property("productType", "CodeableConcept", "Category of the medication or product (e.g. branded product, therapeutic moeity, generic product, innovator product, etc.).", 0, java.lang.Integer.MAX_VALUE, productType);
        case -1442980789: /*monograph*/  return new Property("monograph", "", "Associated documentation about the medication.", 0, java.lang.Integer.MAX_VALUE, monograph);
        case 1025456503: /*preparationInstruction*/  return new Property("preparationInstruction", "markdown", "The instructions for preparing the medication.", 0, 1, preparationInstruction);
        case 3059661: /*cost*/  return new Property("cost", "", "The price of the medication.", 0, java.lang.Integer.MAX_VALUE, cost);
        case 569848092: /*monitoringProgram*/  return new Property("monitoringProgram", "", "The program under which the medication is reviewed.", 0, java.lang.Integer.MAX_VALUE, monitoringProgram);
        case -347044108: /*indicationGuideline*/  return new Property("indicationGuideline", "", "Guidelines or protocols that are applicable for the administration of the medication based on indication.", 0, java.lang.Integer.MAX_VALUE, indicationGuideline);
        case 1791551680: /*medicineClassification*/  return new Property("medicineClassification", "", "Categorization of the medication within a formulary or classification system.", 0, java.lang.Integer.MAX_VALUE, medicineClassification);
        case 1802065795: /*packaging*/  return new Property("packaging", "", "Information that only applies to packages (not products).", 0, java.lang.Integer.MAX_VALUE, packaging);
        case 251885509: /*clinicalUseIssue*/  return new Property("clinicalUseIssue", "Reference(ClinicalUseDefinition)", "Potential clinical issue with or between medication(s) (for example, drug-drug interaction, drug-disease contraindication, drug-allergy interaction, etc.).", 0, java.lang.Integer.MAX_VALUE, clinicalUseIssue);
        case 1618773173: /*storageGuideline*/  return new Property("storageGuideline", "", "Information on how the medication should be stored, for example, refrigeration temperatures and length of stability at a given temperature.", 0, java.lang.Integer.MAX_VALUE, storageGuideline);
        case -27327848: /*regulatory*/  return new Property("regulatory", "", "Regulatory information about a medication.", 0, java.lang.Integer.MAX_VALUE, regulatory);
        case 101791934: /*definitional*/  return new Property("definitional", "", "Along with the link to a Medicinal Product Definition resource, this information provides common definitional elements that are needed to understand the specific medication that is being described.", 0, 1, definitional);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<MedicationKnowledgeStatusCodes>
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : new Base[] {this.author}; // Reference
        case 2136596300: /*intendedJurisdiction*/ return this.intendedJurisdiction == null ? new Base[0] : this.intendedJurisdiction.toArray(new Base[this.intendedJurisdiction.size()]); // CodeableConcept
        case 3373707: /*name*/ return this.name == null ? new Base[0] : this.name.toArray(new Base[this.name.size()]); // StringType
        case 723067972: /*relatedMedicationKnowledge*/ return this.relatedMedicationKnowledge == null ? new Base[0] : this.relatedMedicationKnowledge.toArray(new Base[this.relatedMedicationKnowledge.size()]); // MedicationKnowledgeRelatedMedicationKnowledgeComponent
        case 1312779381: /*associatedMedication*/ return this.associatedMedication == null ? new Base[0] : this.associatedMedication.toArray(new Base[this.associatedMedication.size()]); // Reference
        case -1491615543: /*productType*/ return this.productType == null ? new Base[0] : this.productType.toArray(new Base[this.productType.size()]); // CodeableConcept
        case -1442980789: /*monograph*/ return this.monograph == null ? new Base[0] : this.monograph.toArray(new Base[this.monograph.size()]); // MedicationKnowledgeMonographComponent
        case 1025456503: /*preparationInstruction*/ return this.preparationInstruction == null ? new Base[0] : new Base[] {this.preparationInstruction}; // MarkdownType
        case 3059661: /*cost*/ return this.cost == null ? new Base[0] : this.cost.toArray(new Base[this.cost.size()]); // MedicationKnowledgeCostComponent
        case 569848092: /*monitoringProgram*/ return this.monitoringProgram == null ? new Base[0] : this.monitoringProgram.toArray(new Base[this.monitoringProgram.size()]); // MedicationKnowledgeMonitoringProgramComponent
        case -347044108: /*indicationGuideline*/ return this.indicationGuideline == null ? new Base[0] : this.indicationGuideline.toArray(new Base[this.indicationGuideline.size()]); // MedicationKnowledgeIndicationGuidelineComponent
        case 1791551680: /*medicineClassification*/ return this.medicineClassification == null ? new Base[0] : this.medicineClassification.toArray(new Base[this.medicineClassification.size()]); // MedicationKnowledgeMedicineClassificationComponent
        case 1802065795: /*packaging*/ return this.packaging == null ? new Base[0] : this.packaging.toArray(new Base[this.packaging.size()]); // MedicationKnowledgePackagingComponent
        case 251885509: /*clinicalUseIssue*/ return this.clinicalUseIssue == null ? new Base[0] : this.clinicalUseIssue.toArray(new Base[this.clinicalUseIssue.size()]); // Reference
        case 1618773173: /*storageGuideline*/ return this.storageGuideline == null ? new Base[0] : this.storageGuideline.toArray(new Base[this.storageGuideline.size()]); // MedicationKnowledgeStorageGuidelineComponent
        case -27327848: /*regulatory*/ return this.regulatory == null ? new Base[0] : this.regulatory.toArray(new Base[this.regulatory.size()]); // MedicationKnowledgeRegulatoryComponent
        case 101791934: /*definitional*/ return this.definitional == null ? new Base[0] : new Base[] {this.definitional}; // MedicationKnowledgeDefinitionalComponent
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
        case -1406328437: // author
          this.author = TypeConvertor.castToReference(value); // Reference
          return value;
        case 2136596300: // intendedJurisdiction
          this.getIntendedJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3373707: // name
          this.getName().add(TypeConvertor.castToString(value)); // StringType
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
        case 1025456503: // preparationInstruction
          this.preparationInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 3059661: // cost
          this.getCost().add((MedicationKnowledgeCostComponent) value); // MedicationKnowledgeCostComponent
          return value;
        case 569848092: // monitoringProgram
          this.getMonitoringProgram().add((MedicationKnowledgeMonitoringProgramComponent) value); // MedicationKnowledgeMonitoringProgramComponent
          return value;
        case -347044108: // indicationGuideline
          this.getIndicationGuideline().add((MedicationKnowledgeIndicationGuidelineComponent) value); // MedicationKnowledgeIndicationGuidelineComponent
          return value;
        case 1791551680: // medicineClassification
          this.getMedicineClassification().add((MedicationKnowledgeMedicineClassificationComponent) value); // MedicationKnowledgeMedicineClassificationComponent
          return value;
        case 1802065795: // packaging
          this.getPackaging().add((MedicationKnowledgePackagingComponent) value); // MedicationKnowledgePackagingComponent
          return value;
        case 251885509: // clinicalUseIssue
          this.getClinicalUseIssue().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 1618773173: // storageGuideline
          this.getStorageGuideline().add((MedicationKnowledgeStorageGuidelineComponent) value); // MedicationKnowledgeStorageGuidelineComponent
          return value;
        case -27327848: // regulatory
          this.getRegulatory().add((MedicationKnowledgeRegulatoryComponent) value); // MedicationKnowledgeRegulatoryComponent
          return value;
        case 101791934: // definitional
          this.definitional = (MedicationKnowledgeDefinitionalComponent) value; // MedicationKnowledgeDefinitionalComponent
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
        } else if (name.equals("author")) {
          this.author = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("intendedJurisdiction")) {
          this.getIntendedJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("name")) {
          this.getName().add(TypeConvertor.castToString(value));
        } else if (name.equals("relatedMedicationKnowledge")) {
          this.getRelatedMedicationKnowledge().add((MedicationKnowledgeRelatedMedicationKnowledgeComponent) value);
        } else if (name.equals("associatedMedication")) {
          this.getAssociatedMedication().add(TypeConvertor.castToReference(value));
        } else if (name.equals("productType")) {
          this.getProductType().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("monograph")) {
          this.getMonograph().add((MedicationKnowledgeMonographComponent) value);
        } else if (name.equals("preparationInstruction")) {
          this.preparationInstruction = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("cost")) {
          this.getCost().add((MedicationKnowledgeCostComponent) value);
        } else if (name.equals("monitoringProgram")) {
          this.getMonitoringProgram().add((MedicationKnowledgeMonitoringProgramComponent) value);
        } else if (name.equals("indicationGuideline")) {
          this.getIndicationGuideline().add((MedicationKnowledgeIndicationGuidelineComponent) value);
        } else if (name.equals("medicineClassification")) {
          this.getMedicineClassification().add((MedicationKnowledgeMedicineClassificationComponent) value);
        } else if (name.equals("packaging")) {
          this.getPackaging().add((MedicationKnowledgePackagingComponent) value);
        } else if (name.equals("clinicalUseIssue")) {
          this.getClinicalUseIssue().add(TypeConvertor.castToReference(value));
        } else if (name.equals("storageGuideline")) {
          this.getStorageGuideline().add((MedicationKnowledgeStorageGuidelineComponent) value);
        } else if (name.equals("regulatory")) {
          this.getRegulatory().add((MedicationKnowledgeRegulatoryComponent) value);
        } else if (name.equals("definitional")) {
          this.definitional = (MedicationKnowledgeDefinitionalComponent) value; // MedicationKnowledgeDefinitionalComponent
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
        case -1406328437:  return getAuthor();
        case 2136596300:  return addIntendedJurisdiction(); 
        case 3373707:  return addNameElement();
        case 723067972:  return addRelatedMedicationKnowledge(); 
        case 1312779381:  return addAssociatedMedication(); 
        case -1491615543:  return addProductType(); 
        case -1442980789:  return addMonograph(); 
        case 1025456503:  return getPreparationInstructionElement();
        case 3059661:  return addCost(); 
        case 569848092:  return addMonitoringProgram(); 
        case -347044108:  return addIndicationGuideline(); 
        case 1791551680:  return addMedicineClassification(); 
        case 1802065795:  return addPackaging(); 
        case 251885509:  return addClinicalUseIssue(); 
        case 1618773173:  return addStorageGuideline(); 
        case -27327848:  return addRegulatory(); 
        case 101791934:  return getDefinitional();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1406328437: /*author*/ return new String[] {"Reference"};
        case 2136596300: /*intendedJurisdiction*/ return new String[] {"CodeableConcept"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 723067972: /*relatedMedicationKnowledge*/ return new String[] {};
        case 1312779381: /*associatedMedication*/ return new String[] {"Reference"};
        case -1491615543: /*productType*/ return new String[] {"CodeableConcept"};
        case -1442980789: /*monograph*/ return new String[] {};
        case 1025456503: /*preparationInstruction*/ return new String[] {"markdown"};
        case 3059661: /*cost*/ return new String[] {};
        case 569848092: /*monitoringProgram*/ return new String[] {};
        case -347044108: /*indicationGuideline*/ return new String[] {};
        case 1791551680: /*medicineClassification*/ return new String[] {};
        case 1802065795: /*packaging*/ return new String[] {};
        case 251885509: /*clinicalUseIssue*/ return new String[] {"Reference"};
        case 1618773173: /*storageGuideline*/ return new String[] {};
        case -27327848: /*regulatory*/ return new String[] {};
        case 101791934: /*definitional*/ return new String[] {};
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
        else if (name.equals("author")) {
          this.author = new Reference();
          return this.author;
        }
        else if (name.equals("intendedJurisdiction")) {
          return addIntendedJurisdiction();
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.name");
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
        else if (name.equals("preparationInstruction")) {
          throw new FHIRException("Cannot call addChild on a primitive type MedicationKnowledge.preparationInstruction");
        }
        else if (name.equals("cost")) {
          return addCost();
        }
        else if (name.equals("monitoringProgram")) {
          return addMonitoringProgram();
        }
        else if (name.equals("indicationGuideline")) {
          return addIndicationGuideline();
        }
        else if (name.equals("medicineClassification")) {
          return addMedicineClassification();
        }
        else if (name.equals("packaging")) {
          return addPackaging();
        }
        else if (name.equals("clinicalUseIssue")) {
          return addClinicalUseIssue();
        }
        else if (name.equals("storageGuideline")) {
          return addStorageGuideline();
        }
        else if (name.equals("regulatory")) {
          return addRegulatory();
        }
        else if (name.equals("definitional")) {
          this.definitional = new MedicationKnowledgeDefinitionalComponent();
          return this.definitional;
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
        dst.author = author == null ? null : author.copy();
        if (intendedJurisdiction != null) {
          dst.intendedJurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : intendedJurisdiction)
            dst.intendedJurisdiction.add(i.copy());
        };
        if (name != null) {
          dst.name = new ArrayList<StringType>();
          for (StringType i : name)
            dst.name.add(i.copy());
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
        dst.preparationInstruction = preparationInstruction == null ? null : preparationInstruction.copy();
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
        if (indicationGuideline != null) {
          dst.indicationGuideline = new ArrayList<MedicationKnowledgeIndicationGuidelineComponent>();
          for (MedicationKnowledgeIndicationGuidelineComponent i : indicationGuideline)
            dst.indicationGuideline.add(i.copy());
        };
        if (medicineClassification != null) {
          dst.medicineClassification = new ArrayList<MedicationKnowledgeMedicineClassificationComponent>();
          for (MedicationKnowledgeMedicineClassificationComponent i : medicineClassification)
            dst.medicineClassification.add(i.copy());
        };
        if (packaging != null) {
          dst.packaging = new ArrayList<MedicationKnowledgePackagingComponent>();
          for (MedicationKnowledgePackagingComponent i : packaging)
            dst.packaging.add(i.copy());
        };
        if (clinicalUseIssue != null) {
          dst.clinicalUseIssue = new ArrayList<Reference>();
          for (Reference i : clinicalUseIssue)
            dst.clinicalUseIssue.add(i.copy());
        };
        if (storageGuideline != null) {
          dst.storageGuideline = new ArrayList<MedicationKnowledgeStorageGuidelineComponent>();
          for (MedicationKnowledgeStorageGuidelineComponent i : storageGuideline)
            dst.storageGuideline.add(i.copy());
        };
        if (regulatory != null) {
          dst.regulatory = new ArrayList<MedicationKnowledgeRegulatoryComponent>();
          for (MedicationKnowledgeRegulatoryComponent i : regulatory)
            dst.regulatory.add(i.copy());
        };
        dst.definitional = definitional == null ? null : definitional.copy();
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
           && compareDeep(author, o.author, true) && compareDeep(intendedJurisdiction, o.intendedJurisdiction, true)
           && compareDeep(name, o.name, true) && compareDeep(relatedMedicationKnowledge, o.relatedMedicationKnowledge, true)
           && compareDeep(associatedMedication, o.associatedMedication, true) && compareDeep(productType, o.productType, true)
           && compareDeep(monograph, o.monograph, true) && compareDeep(preparationInstruction, o.preparationInstruction, true)
           && compareDeep(cost, o.cost, true) && compareDeep(monitoringProgram, o.monitoringProgram, true)
           && compareDeep(indicationGuideline, o.indicationGuideline, true) && compareDeep(medicineClassification, o.medicineClassification, true)
           && compareDeep(packaging, o.packaging, true) && compareDeep(clinicalUseIssue, o.clinicalUseIssue, true)
           && compareDeep(storageGuideline, o.storageGuideline, true) && compareDeep(regulatory, o.regulatory, true)
           && compareDeep(definitional, o.definitional, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof MedicationKnowledge))
          return false;
        MedicationKnowledge o = (MedicationKnowledge) other_;
        return compareValues(status, o.status, true) && compareValues(name, o.name, true) && compareValues(preparationInstruction, o.preparationInstruction, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, code, status
          , author, intendedJurisdiction, name, relatedMedicationKnowledge, associatedMedication
          , productType, monograph, preparationInstruction, cost, monitoringProgram, indicationGuideline
          , medicineClassification, packaging, clinicalUseIssue, storageGuideline, regulatory
          , definitional);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.MedicationKnowledge;
   }

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [GraphDefinition](graphdefinition.html): External identifier for the graph definition\r\n* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [OperationDefinition](operationdefinition.html): External identifier for the search parameter\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SearchParameter](searchparameter.html): External identifier for the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition
* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition
* [Citation](citation.html): External identifier for the citation
* [CodeSystem](codesystem.html): External identifier for the code system
* [ConceptMap](conceptmap.html): External identifier for the concept map
* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition
* [EventDefinition](eventdefinition.html): External identifier for the event definition
* [Evidence](evidence.html): External identifier for the evidence
* [EvidenceReport](evidencereport.html): External identifier for the evidence report
* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable
* [ExampleScenario](examplescenario.html): External identifier for the example scenario
* [GraphDefinition](graphdefinition.html): External identifier for the graph definition
* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide
* [Library](library.html): External identifier for the library
* [Measure](measure.html): External identifier for the measure
* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication
* [MessageDefinition](messagedefinition.html): External identifier for the message definition
* [NamingSystem](namingsystem.html): External identifier for the naming system
* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition
* [OperationDefinition](operationdefinition.html): External identifier for the search parameter
* [PlanDefinition](plandefinition.html): External identifier for the plan definition
* [Questionnaire](questionnaire.html): External identifier for the questionnaire
* [Requirements](requirements.html): External identifier for the requirements
* [SearchParameter](searchparameter.html): External identifier for the search parameter
* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): External identifier for the structure definition
* [StructureMap](structuremap.html): External identifier for the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestScript.status | ValueSet.status", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The current status of the activity definition\r\n* [ActorDefinition](actordefinition.html): The current status of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition\r\n* [Citation](citation.html): The current status of the citation\r\n* [CodeSystem](codesystem.html): The current status of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition\r\n* [ConceptMap](conceptmap.html): The current status of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition\r\n* [EventDefinition](eventdefinition.html): The current status of the event definition\r\n* [Evidence](evidence.html): The current status of the evidence\r\n* [EvidenceReport](evidencereport.html): The current status of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The current status of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The current status of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The current status of the implementation guide\r\n* [Library](library.html): The current status of the library\r\n* [Measure](measure.html): The current status of the measure\r\n* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error\r\n* [MessageDefinition](messagedefinition.html): The current status of the message definition\r\n* [NamingSystem](namingsystem.html): The current status of the naming system\r\n* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown\r\n* [OperationDefinition](operationdefinition.html): The current status of the operation definition\r\n* [PlanDefinition](plandefinition.html): The current status of the plan definition\r\n* [Questionnaire](questionnaire.html): The current status of the questionnaire\r\n* [Requirements](requirements.html): The current status of the requirements\r\n* [SearchParameter](searchparameter.html): The current status of the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown\r\n* [StructureDefinition](structuredefinition.html): The current status of the structure definition\r\n* [StructureMap](structuremap.html): The current status of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown\r\n* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities\r\n* [TestScript](testscript.html): The current status of the test script\r\n* [ValueSet](valueset.html): The current status of the value set\r\n", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The current status of the activity definition
* [ActorDefinition](actordefinition.html): The current status of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition
* [Citation](citation.html): The current status of the citation
* [CodeSystem](codesystem.html): The current status of the code system
* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition
* [ConceptMap](conceptmap.html): The current status of the concept map
* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition
* [EventDefinition](eventdefinition.html): The current status of the event definition
* [Evidence](evidence.html): The current status of the evidence
* [EvidenceReport](evidencereport.html): The current status of the evidence report
* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable
* [ExampleScenario](examplescenario.html): The current status of the example scenario
* [GraphDefinition](graphdefinition.html): The current status of the graph definition
* [ImplementationGuide](implementationguide.html): The current status of the implementation guide
* [Library](library.html): The current status of the library
* [Measure](measure.html): The current status of the measure
* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error
* [MessageDefinition](messagedefinition.html): The current status of the message definition
* [NamingSystem](namingsystem.html): The current status of the naming system
* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown
* [OperationDefinition](operationdefinition.html): The current status of the operation definition
* [PlanDefinition](plandefinition.html): The current status of the plan definition
* [Questionnaire](questionnaire.html): The current status of the questionnaire
* [Requirements](requirements.html): The current status of the requirements
* [SearchParameter](searchparameter.html): The current status of the search parameter
* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown
* [StructureDefinition](structuredefinition.html): The current status of the structure definition
* [StructureMap](structuremap.html): The current status of the structure map
* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown
* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

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
   * Path: <b>MedicationKnowledge.definitional.doseForm</b><br>
   * </p>
   */
  @SearchParamDefinition(name="doseform", path="MedicationKnowledge.definitional.doseForm", description="powder | tablets | capsule +", type="token" )
  public static final String SP_DOSEFORM = "doseform";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>doseform</b>
   * <p>
   * Description: <b>powder | tablets | capsule +</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.definitional.doseForm</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam DOSEFORM = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_DOSEFORM);

 /**
   * Search parameter: <b>ingredient-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.definitional.ingredient.item.concept</b><br>
   * </p>
   */
  @SearchParamDefinition(name="ingredient-code", path="MedicationKnowledge.definitional.ingredient.item.concept", description="Reference to a concept (by class)", type="token" )
  public static final String SP_INGREDIENT_CODE = "ingredient-code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>ingredient-code</b>
   * <p>
   * Description: <b>Reference to a concept (by class)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>MedicationKnowledge.definitional.ingredient.item.concept</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INGREDIENT_CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INGREDIENT_CODE);

 /**
   * Search parameter: <b>ingredient</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationKnowledge.definitional.ingredient.item.reference</b><br>
   * </p>
   */
  @SearchParamDefinition(name="ingredient", path="MedicationKnowledge.definitional.ingredient.item.reference", description="Reference to a resource (by instance)", type="reference", target={Substance.class } )
  public static final String SP_INGREDIENT = "ingredient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>ingredient</b>
   * <p>
   * Description: <b>Reference to a resource (by instance)</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>MedicationKnowledge.definitional.ingredient.item.reference</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INGREDIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INGREDIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>MedicationKnowledge:ingredient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INGREDIENT = new ca.uhn.fhir.model.api.Include("MedicationKnowledge:ingredient").toLocked();

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
   * Search parameter: <b>packaging-cost-concept</b>
   * <p>
   * Description: <b>The cost of the packaged medication, if the cost is a CodeableConcept</b><br>
   * Type: <b>token</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  @SearchParamDefinition(name="packaging-cost-concept", path="", description="The cost of the packaged medication, if the cost is a CodeableConcept", type="token" )
  public static final String SP_PACKAGING_COST_CONCEPT = "packaging-cost-concept";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>packaging-cost-concept</b>
   * <p>
   * Description: <b>The cost of the packaged medication, if the cost is a CodeableConcept</b><br>
   * Type: <b>token</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PACKAGING_COST_CONCEPT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PACKAGING_COST_CONCEPT);

 /**
   * Search parameter: <b>packaging-cost</b>
   * <p>
   * Description: <b>The cost of the packaged medication, if the cost is Money</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  @SearchParamDefinition(name="packaging-cost", path="", description="The cost of the packaged medication, if the cost is Money", type="quantity" )
  public static final String SP_PACKAGING_COST = "packaging-cost";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>packaging-cost</b>
   * <p>
   * Description: <b>The cost of the packaged medication, if the cost is Money</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>null</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam PACKAGING_COST = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_PACKAGING_COST);

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


}

