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
 * A definition of a condition and information relevant to managing it.
 */
@ResourceDef(name="ConditionDefinition", profile="http://hl7.org/fhir/StructureDefinition/ConditionDefinition")
public class ConditionDefinition extends MetadataResource {

    public enum ConditionPreconditionType {
        /**
         * The observation is very sensitive for the condition, but may also indicate other conditions.
         */
        SENSITIVE, 
        /**
         * The observation is very specific for this condition, but not particularly sensitive.
         */
        SPECIFIC, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ConditionPreconditionType fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sensitive".equals(codeString))
          return SENSITIVE;
        if ("specific".equals(codeString))
          return SPECIFIC;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ConditionPreconditionType code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case SENSITIVE: return "sensitive";
            case SPECIFIC: return "specific";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case SENSITIVE: return "http://hl7.org/fhir/condition-precondition-type";
            case SPECIFIC: return "http://hl7.org/fhir/condition-precondition-type";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case SENSITIVE: return "The observation is very sensitive for the condition, but may also indicate other conditions.";
            case SPECIFIC: return "The observation is very specific for this condition, but not particularly sensitive.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case SENSITIVE: return "Sensitive";
            case SPECIFIC: return "Specific";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConditionPreconditionTypeEnumFactory implements EnumFactory<ConditionPreconditionType> {
    public ConditionPreconditionType fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("sensitive".equals(codeString))
          return ConditionPreconditionType.SENSITIVE;
        if ("specific".equals(codeString))
          return ConditionPreconditionType.SPECIFIC;
        throw new IllegalArgumentException("Unknown ConditionPreconditionType code '"+codeString+"'");
        }
        public Enumeration<ConditionPreconditionType> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConditionPreconditionType>(this, ConditionPreconditionType.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ConditionPreconditionType>(this, ConditionPreconditionType.NULL, code);
        if ("sensitive".equals(codeString))
          return new Enumeration<ConditionPreconditionType>(this, ConditionPreconditionType.SENSITIVE, code);
        if ("specific".equals(codeString))
          return new Enumeration<ConditionPreconditionType>(this, ConditionPreconditionType.SPECIFIC, code);
        throw new FHIRException("Unknown ConditionPreconditionType code '"+codeString+"'");
        }
    public String toCode(ConditionPreconditionType code) {
      if (code == ConditionPreconditionType.SENSITIVE)
        return "sensitive";
      if (code == ConditionPreconditionType.SPECIFIC)
        return "specific";
      return "?";
      }
    public String toSystem(ConditionPreconditionType code) {
      return code.getSystem();
      }
    }

    public enum ConditionQuestionnairePurpose {
        /**
         * A pre-admit questionnaire.
         */
        PREADMIT, 
        /**
         * A questionnaire that helps with diferential diagnosis.
         */
        DIFFDIAGNOSIS, 
        /**
         * A questionnaire to check on outcomes for the patient.
         */
        OUTCOME, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static ConditionQuestionnairePurpose fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preadmit".equals(codeString))
          return PREADMIT;
        if ("diff-diagnosis".equals(codeString))
          return DIFFDIAGNOSIS;
        if ("outcome".equals(codeString))
          return OUTCOME;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown ConditionQuestionnairePurpose code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PREADMIT: return "preadmit";
            case DIFFDIAGNOSIS: return "diff-diagnosis";
            case OUTCOME: return "outcome";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PREADMIT: return "http://hl7.org/fhir/condition-questionnaire-purpose";
            case DIFFDIAGNOSIS: return "http://hl7.org/fhir/condition-questionnaire-purpose";
            case OUTCOME: return "http://hl7.org/fhir/condition-questionnaire-purpose";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PREADMIT: return "A pre-admit questionnaire.";
            case DIFFDIAGNOSIS: return "A questionnaire that helps with diferential diagnosis.";
            case OUTCOME: return "A questionnaire to check on outcomes for the patient.";
            case NULL: return null;
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PREADMIT: return "Pre-admit";
            case DIFFDIAGNOSIS: return "Diff Diagnosis";
            case OUTCOME: return "Outcome";
            case NULL: return null;
            default: return "?";
          }
        }
    }

  public static class ConditionQuestionnairePurposeEnumFactory implements EnumFactory<ConditionQuestionnairePurpose> {
    public ConditionQuestionnairePurpose fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preadmit".equals(codeString))
          return ConditionQuestionnairePurpose.PREADMIT;
        if ("diff-diagnosis".equals(codeString))
          return ConditionQuestionnairePurpose.DIFFDIAGNOSIS;
        if ("outcome".equals(codeString))
          return ConditionQuestionnairePurpose.OUTCOME;
        throw new IllegalArgumentException("Unknown ConditionQuestionnairePurpose code '"+codeString+"'");
        }
        public Enumeration<ConditionQuestionnairePurpose> fromType(PrimitiveType<?> code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<ConditionQuestionnairePurpose>(this, ConditionQuestionnairePurpose.NULL, code);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return new Enumeration<ConditionQuestionnairePurpose>(this, ConditionQuestionnairePurpose.NULL, code);
        if ("preadmit".equals(codeString))
          return new Enumeration<ConditionQuestionnairePurpose>(this, ConditionQuestionnairePurpose.PREADMIT, code);
        if ("diff-diagnosis".equals(codeString))
          return new Enumeration<ConditionQuestionnairePurpose>(this, ConditionQuestionnairePurpose.DIFFDIAGNOSIS, code);
        if ("outcome".equals(codeString))
          return new Enumeration<ConditionQuestionnairePurpose>(this, ConditionQuestionnairePurpose.OUTCOME, code);
        throw new FHIRException("Unknown ConditionQuestionnairePurpose code '"+codeString+"'");
        }
    public String toCode(ConditionQuestionnairePurpose code) {
      if (code == ConditionQuestionnairePurpose.PREADMIT)
        return "preadmit";
      if (code == ConditionQuestionnairePurpose.DIFFDIAGNOSIS)
        return "diff-diagnosis";
      if (code == ConditionQuestionnairePurpose.OUTCOME)
        return "outcome";
      return "?";
      }
    public String toSystem(ConditionQuestionnairePurpose code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class ConditionDefinitionObservationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Category that is relevant.
         */
        @Child(name = "category", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Category that is relevant", formalDefinition="Category that is relevant." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-category")
        protected CodeableConcept category;

        /**
         * Code for relevant Observation.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code for relevant Observation", formalDefinition="Code for relevant Observation." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-codes")
        protected CodeableConcept code;

        private static final long serialVersionUID = -1433986479L;

    /**
     * Constructor
     */
      public ConditionDefinitionObservationComponent() {
        super();
      }

        /**
         * @return {@link #category} (Category that is relevant.)
         */
        public CodeableConcept getCategory() { 
          if (this.category == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionObservationComponent.category");
            else if (Configuration.doAutoCreate())
              this.category = new CodeableConcept(); // cc
          return this.category;
        }

        public boolean hasCategory() { 
          return this.category != null && !this.category.isEmpty();
        }

        /**
         * @param value {@link #category} (Category that is relevant.)
         */
        public ConditionDefinitionObservationComponent setCategory(CodeableConcept value) { 
          this.category = value;
          return this;
        }

        /**
         * @return {@link #code} (Code for relevant Observation.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionObservationComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Code for relevant Observation.)
         */
        public ConditionDefinitionObservationComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("category", "CodeableConcept", "Category that is relevant.", 0, 1, category));
          children.add(new Property("code", "CodeableConcept", "Code for relevant Observation.", 0, 1, code));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Category that is relevant.", 0, 1, category);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Code for relevant Observation.", 0, 1, code);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
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
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102:  return getCategory();
        case 3059181:  return getCode();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
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
        else
          return super.addChild(name);
      }

      public ConditionDefinitionObservationComponent copy() {
        ConditionDefinitionObservationComponent dst = new ConditionDefinitionObservationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConditionDefinitionObservationComponent dst) {
        super.copyValues(dst);
        dst.category = category == null ? null : category.copy();
        dst.code = code == null ? null : code.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionObservationComponent))
          return false;
        ConditionDefinitionObservationComponent o = (ConditionDefinitionObservationComponent) other_;
        return compareDeep(category, o.category, true) && compareDeep(code, o.code, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionObservationComponent))
          return false;
        ConditionDefinitionObservationComponent o = (ConditionDefinitionObservationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(category, code);
      }

  public String fhirType() {
    return "ConditionDefinition.observation";

  }

  }

    @Block()
    public static class ConditionDefinitionMedicationComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Category that is relevant.
         */
        @Child(name = "category", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Category that is relevant", formalDefinition="Category that is relevant." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/medicationrequest-category")
        protected CodeableConcept category;

        /**
         * Code for relevant Medication.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code for relevant Medication", formalDefinition="Code for relevant Medication." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-codes")
        protected CodeableConcept code;

        private static final long serialVersionUID = -1433986479L;

    /**
     * Constructor
     */
      public ConditionDefinitionMedicationComponent() {
        super();
      }

        /**
         * @return {@link #category} (Category that is relevant.)
         */
        public CodeableConcept getCategory() { 
          if (this.category == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionMedicationComponent.category");
            else if (Configuration.doAutoCreate())
              this.category = new CodeableConcept(); // cc
          return this.category;
        }

        public boolean hasCategory() { 
          return this.category != null && !this.category.isEmpty();
        }

        /**
         * @param value {@link #category} (Category that is relevant.)
         */
        public ConditionDefinitionMedicationComponent setCategory(CodeableConcept value) { 
          this.category = value;
          return this;
        }

        /**
         * @return {@link #code} (Code for relevant Medication.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionMedicationComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Code for relevant Medication.)
         */
        public ConditionDefinitionMedicationComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("category", "CodeableConcept", "Category that is relevant.", 0, 1, category));
          children.add(new Property("code", "CodeableConcept", "Code for relevant Medication.", 0, 1, code));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Category that is relevant.", 0, 1, category);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Code for relevant Medication.", 0, 1, code);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
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
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = null;
        } else if (name.equals("code")) {
          this.code = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102:  return getCategory();
        case 3059181:  return getCode();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
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
        else
          return super.addChild(name);
      }

      public ConditionDefinitionMedicationComponent copy() {
        ConditionDefinitionMedicationComponent dst = new ConditionDefinitionMedicationComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConditionDefinitionMedicationComponent dst) {
        super.copyValues(dst);
        dst.category = category == null ? null : category.copy();
        dst.code = code == null ? null : code.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionMedicationComponent))
          return false;
        ConditionDefinitionMedicationComponent o = (ConditionDefinitionMedicationComponent) other_;
        return compareDeep(category, o.category, true) && compareDeep(code, o.code, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionMedicationComponent))
          return false;
        ConditionDefinitionMedicationComponent o = (ConditionDefinitionMedicationComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(category, code);
      }

  public String fhirType() {
    return "ConditionDefinition.medication";

  }

  }

    @Block()
    public static class ConditionDefinitionPreconditionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Kind of pre-condition.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="sensitive | specific", formalDefinition="Kind of pre-condition." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-precondition-type")
        protected Enumeration<ConditionPreconditionType> type;

        /**
         * Code for relevant Observation.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code for relevant Observation", formalDefinition="Code for relevant Observation." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-codes")
        protected CodeableConcept code;

        /**
         * Value of Observation.
         */
        @Child(name = "value", type = {CodeableConcept.class, Quantity.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Value of Observation", formalDefinition="Value of Observation." )
        protected DataType value;

        private static final long serialVersionUID = -1210333235L;

    /**
     * Constructor
     */
      public ConditionDefinitionPreconditionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ConditionDefinitionPreconditionComponent(ConditionPreconditionType type, CodeableConcept code) {
        super();
        this.setType(type);
        this.setCode(code);
      }

        /**
         * @return {@link #type} (Kind of pre-condition.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<ConditionPreconditionType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionPreconditionComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<ConditionPreconditionType>(new ConditionPreconditionTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (Kind of pre-condition.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public ConditionDefinitionPreconditionComponent setTypeElement(Enumeration<ConditionPreconditionType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return Kind of pre-condition.
         */
        public ConditionPreconditionType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value Kind of pre-condition.
         */
        public ConditionDefinitionPreconditionComponent setType(ConditionPreconditionType value) { 
            if (this.type == null)
              this.type = new Enumeration<ConditionPreconditionType>(new ConditionPreconditionTypeEnumFactory());
            this.type.setValue(value);
          return this;
        }

        /**
         * @return {@link #code} (Code for relevant Observation.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionPreconditionComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (Code for relevant Observation.)
         */
        public ConditionDefinitionPreconditionComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #value} (Value of Observation.)
         */
        public DataType getValue() { 
          return this.value;
        }

        /**
         * @return {@link #value} (Value of Observation.)
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
         * @return {@link #value} (Value of Observation.)
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
         * @param value {@link #value} (Value of Observation.)
         */
        public ConditionDefinitionPreconditionComponent setValue(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Quantity))
            throw new FHIRException("Not the right type for ConditionDefinition.precondition.value[x]: "+value.fhirType());
          this.value = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "Kind of pre-condition.", 0, 1, type));
          children.add(new Property("code", "CodeableConcept", "Code for relevant Observation.", 0, 1, code));
          children.add(new Property("value[x]", "CodeableConcept|Quantity", "Value of Observation.", 0, 1, value));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "Kind of pre-condition.", 0, 1, type);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Code for relevant Observation.", 0, 1, code);
          case -1410166417: /*value[x]*/  return new Property("value[x]", "CodeableConcept|Quantity", "Value of Observation.", 0, 1, value);
          case 111972721: /*value*/  return new Property("value[x]", "CodeableConcept|Quantity", "Value of Observation.", 0, 1, value);
          case 924902896: /*valueCodeableConcept*/  return new Property("value[x]", "CodeableConcept", "Value of Observation.", 0, 1, value);
          case -2029823716: /*valueQuantity*/  return new Property("value[x]", "Quantity", "Value of Observation.", 0, 1, value);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ConditionPreconditionType>
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 111972721: /*value*/ return this.value == null ? new Base[0] : new Base[] {this.value}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new ConditionPreconditionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ConditionPreconditionType>
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
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
          value = new ConditionPreconditionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ConditionPreconditionType>
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("value[x]")) {
          this.value = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new ConditionPreconditionTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ConditionPreconditionType>
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("value[x]")) {
          this.value = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case 3059181:  return getCode();
        case -1410166417:  return getValue();
        case 111972721:  return getValue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 111972721: /*value*/ return new String[] {"CodeableConcept", "Quantity"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.precondition.type");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
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

      public ConditionDefinitionPreconditionComponent copy() {
        ConditionDefinitionPreconditionComponent dst = new ConditionDefinitionPreconditionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConditionDefinitionPreconditionComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.code = code == null ? null : code.copy();
        dst.value = value == null ? null : value.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionPreconditionComponent))
          return false;
        ConditionDefinitionPreconditionComponent o = (ConditionDefinitionPreconditionComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(code, o.code, true) && compareDeep(value, o.value, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionPreconditionComponent))
          return false;
        ConditionDefinitionPreconditionComponent o = (ConditionDefinitionPreconditionComponent) other_;
        return compareValues(type, o.type, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, code, value);
      }

  public String fhirType() {
    return "ConditionDefinition.precondition";

  }

  }

    @Block()
    public static class ConditionDefinitionQuestionnaireComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Use of the questionnaire.
         */
        @Child(name = "purpose", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="preadmit | diff-diagnosis | outcome", formalDefinition="Use of the questionnaire." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-questionnaire-purpose")
        protected Enumeration<ConditionQuestionnairePurpose> purpose;

        /**
         * Specific Questionnaire.
         */
        @Child(name = "reference", type = {Questionnaire.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Specific Questionnaire", formalDefinition="Specific Questionnaire." )
        protected Reference reference;

        private static final long serialVersionUID = -1791379681L;

    /**
     * Constructor
     */
      public ConditionDefinitionQuestionnaireComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ConditionDefinitionQuestionnaireComponent(ConditionQuestionnairePurpose purpose, Reference reference) {
        super();
        this.setPurpose(purpose);
        this.setReference(reference);
      }

        /**
         * @return {@link #purpose} (Use of the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
         */
        public Enumeration<ConditionQuestionnairePurpose> getPurposeElement() { 
          if (this.purpose == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionQuestionnaireComponent.purpose");
            else if (Configuration.doAutoCreate())
              this.purpose = new Enumeration<ConditionQuestionnairePurpose>(new ConditionQuestionnairePurposeEnumFactory()); // bb
          return this.purpose;
        }

        public boolean hasPurposeElement() { 
          return this.purpose != null && !this.purpose.isEmpty();
        }

        public boolean hasPurpose() { 
          return this.purpose != null && !this.purpose.isEmpty();
        }

        /**
         * @param value {@link #purpose} (Use of the questionnaire.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
         */
        public ConditionDefinitionQuestionnaireComponent setPurposeElement(Enumeration<ConditionQuestionnairePurpose> value) { 
          this.purpose = value;
          return this;
        }

        /**
         * @return Use of the questionnaire.
         */
        public ConditionQuestionnairePurpose getPurpose() { 
          return this.purpose == null ? null : this.purpose.getValue();
        }

        /**
         * @param value Use of the questionnaire.
         */
        public ConditionDefinitionQuestionnaireComponent setPurpose(ConditionQuestionnairePurpose value) { 
            if (this.purpose == null)
              this.purpose = new Enumeration<ConditionQuestionnairePurpose>(new ConditionQuestionnairePurposeEnumFactory());
            this.purpose.setValue(value);
          return this;
        }

        /**
         * @return {@link #reference} (Specific Questionnaire.)
         */
        public Reference getReference() { 
          if (this.reference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionQuestionnaireComponent.reference");
            else if (Configuration.doAutoCreate())
              this.reference = new Reference(); // cc
          return this.reference;
        }

        public boolean hasReference() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        /**
         * @param value {@link #reference} (Specific Questionnaire.)
         */
        public ConditionDefinitionQuestionnaireComponent setReference(Reference value) { 
          this.reference = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("purpose", "code", "Use of the questionnaire.", 0, 1, purpose));
          children.add(new Property("reference", "Reference(Questionnaire)", "Specific Questionnaire.", 0, 1, reference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -220463842: /*purpose*/  return new Property("purpose", "code", "Use of the questionnaire.", 0, 1, purpose);
          case -925155509: /*reference*/  return new Property("reference", "Reference(Questionnaire)", "Specific Questionnaire.", 0, 1, reference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // Enumeration<ConditionQuestionnairePurpose>
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -220463842: // purpose
          value = new ConditionQuestionnairePurposeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.purpose = (Enumeration) value; // Enumeration<ConditionQuestionnairePurpose>
          return value;
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("purpose")) {
          value = new ConditionQuestionnairePurposeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.purpose = (Enumeration) value; // Enumeration<ConditionQuestionnairePurpose>
        } else if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("purpose")) {
          value = new ConditionQuestionnairePurposeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.purpose = (Enumeration) value; // Enumeration<ConditionQuestionnairePurpose>
        } else if (name.equals("reference")) {
          this.reference = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -220463842:  return getPurposeElement();
        case -925155509:  return getReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -220463842: /*purpose*/ return new String[] {"code"};
        case -925155509: /*reference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.questionnaire.purpose");
        }
        else if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else
          return super.addChild(name);
      }

      public ConditionDefinitionQuestionnaireComponent copy() {
        ConditionDefinitionQuestionnaireComponent dst = new ConditionDefinitionQuestionnaireComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConditionDefinitionQuestionnaireComponent dst) {
        super.copyValues(dst);
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.reference = reference == null ? null : reference.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionQuestionnaireComponent))
          return false;
        ConditionDefinitionQuestionnaireComponent o = (ConditionDefinitionQuestionnaireComponent) other_;
        return compareDeep(purpose, o.purpose, true) && compareDeep(reference, o.reference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionQuestionnaireComponent))
          return false;
        ConditionDefinitionQuestionnaireComponent o = (ConditionDefinitionQuestionnaireComponent) other_;
        return compareValues(purpose, o.purpose, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(purpose, reference);
      }

  public String fhirType() {
    return "ConditionDefinition.questionnaire";

  }

  }

    @Block()
    public static class ConditionDefinitionPlanComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Use for the plan.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Use for the plan", formalDefinition="Use for the plan." )
        protected CodeableConcept role;

        /**
         * The actual plan.
         */
        @Child(name = "reference", type = {PlanDefinition.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The actual plan", formalDefinition="The actual plan." )
        protected Reference reference;

        private static final long serialVersionUID = -1992921787L;

    /**
     * Constructor
     */
      public ConditionDefinitionPlanComponent() {
        super();
      }

    /**
     * Constructor
     */
      public ConditionDefinitionPlanComponent(Reference reference) {
        super();
        this.setReference(reference);
      }

        /**
         * @return {@link #role} (Use for the plan.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionPlanComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (Use for the plan.)
         */
        public ConditionDefinitionPlanComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #reference} (The actual plan.)
         */
        public Reference getReference() { 
          if (this.reference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create ConditionDefinitionPlanComponent.reference");
            else if (Configuration.doAutoCreate())
              this.reference = new Reference(); // cc
          return this.reference;
        }

        public boolean hasReference() { 
          return this.reference != null && !this.reference.isEmpty();
        }

        /**
         * @param value {@link #reference} (The actual plan.)
         */
        public ConditionDefinitionPlanComponent setReference(Reference value) { 
          this.reference = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("role", "CodeableConcept", "Use for the plan.", 0, 1, role));
          children.add(new Property("reference", "Reference(PlanDefinition)", "The actual plan.", 0, 1, reference));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "Use for the plan.", 0, 1, role);
          case -925155509: /*reference*/  return new Property("reference", "Reference(PlanDefinition)", "The actual plan.", 0, 1, reference);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case -925155509: /*reference*/ return this.reference == null ? new Base[0] : new Base[] {this.reference}; // Reference
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -925155509: // reference
          this.reference = TypeConvertor.castToReference(value); // Reference
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reference")) {
          this.reference = TypeConvertor.castToReference(value); // Reference
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("role")) {
          this.role = null;
        } else if (name.equals("reference")) {
          this.reference = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294:  return getRole();
        case -925155509:  return getReference();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case -925155509: /*reference*/ return new String[] {"Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("reference")) {
          this.reference = new Reference();
          return this.reference;
        }
        else
          return super.addChild(name);
      }

      public ConditionDefinitionPlanComponent copy() {
        ConditionDefinitionPlanComponent dst = new ConditionDefinitionPlanComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConditionDefinitionPlanComponent dst) {
        super.copyValues(dst);
        dst.role = role == null ? null : role.copy();
        dst.reference = reference == null ? null : reference.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionPlanComponent))
          return false;
        ConditionDefinitionPlanComponent o = (ConditionDefinitionPlanComponent) other_;
        return compareDeep(role, o.role, true) && compareDeep(reference, o.reference, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConditionDefinitionPlanComponent))
          return false;
        ConditionDefinitionPlanComponent o = (ConditionDefinitionPlanComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(role, reference);
      }

  public String fhirType() {
    return "ConditionDefinition.plan";

  }

  }

    /**
     * An absolute URI that is used to identify this condition definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this condition definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the condition definition is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this condition definition, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this condition definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this condition definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the condition definition is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this condition definition when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the condition definition", formalDefinition="A formal identifier that is used to identify this condition definition when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the condition definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the condition definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the condition definition", formalDefinition="The identifier that is used to identify this version of the condition definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the condition definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence." )
    protected StringType version;

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the condition definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this condition definition (computer friendly)", formalDefinition="A natural language name identifying the condition definition. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the condition definition.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this condition definition (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the condition definition." )
    protected StringType title;

    /**
     * An explanatory or alternate title for the event definition giving additional information about its content.
     */
    @Child(name = "subtitle", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Subordinate title of the event definition", formalDefinition="An explanatory or alternate title for the event definition giving additional information about its content." )
    protected StringType subtitle;

    /**
     * The status of this condition definition. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this condition definition. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this condition definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this condition definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * The date  (and optionally time) when the condition definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the condition definition changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the condition definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the condition definition changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the condition definition.
     */
    @Child(name = "publisher", type = {StringType.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the condition definition." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the condition definition from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the condition definition", formalDefinition="A free text natural language description of the condition definition from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate condition definition instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate condition definition instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the condition definition is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for condition definition (if applicable)", formalDefinition="A legal or geographic region in which the condition definition is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Identification of the condition, problem or diagnosis.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=15, min=1, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Identification of the condition, problem or diagnosis", formalDefinition="Identification of the condition, problem or diagnosis." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
    protected CodeableConcept code;

    /**
     * A subjective assessment of the severity of the condition as evaluated by the clinician.
     */
    @Child(name = "severity", type = {CodeableConcept.class}, order=16, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Subjective severity of condition", formalDefinition="A subjective assessment of the severity of the condition as evaluated by the clinician." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-severity")
    protected CodeableConcept severity;

    /**
     * The anatomical location where this condition manifests itself.
     */
    @Child(name = "bodySite", type = {CodeableConcept.class}, order=17, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Anatomical location, if relevant", formalDefinition="The anatomical location where this condition manifests itself." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/body-site")
    protected CodeableConcept bodySite;

    /**
     * Clinical stage or grade of a condition. May include formal severity assessments.
     */
    @Child(name = "stage", type = {CodeableConcept.class}, order=18, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Stage/grade, usually assessed formally", formalDefinition="Clinical stage or grade of a condition. May include formal severity assessments." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-stage")
    protected CodeableConcept stage;

    /**
     * Whether Severity is appropriate to collect for this condition.
     */
    @Child(name = "hasSeverity", type = {BooleanType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Whether Severity is appropriate", formalDefinition="Whether Severity is appropriate to collect for this condition." )
    protected BooleanType hasSeverity;

    /**
     * Whether bodySite is appropriate to collect for this condition.
     */
    @Child(name = "hasBodySite", type = {BooleanType.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Whether bodySite is appropriate", formalDefinition="Whether bodySite is appropriate to collect for this condition." )
    protected BooleanType hasBodySite;

    /**
     * Whether stage is appropriate to collect for this condition.
     */
    @Child(name = "hasStage", type = {BooleanType.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Whether stage is appropriate", formalDefinition="Whether stage is appropriate to collect for this condition." )
    protected BooleanType hasStage;

    /**
     * Formal definitions of the condition. These may be references to ontologies, published clinical protocols or research papers.
     */
    @Child(name = "definition", type = {UriType.class}, order=22, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Formal Definition for the condition", formalDefinition="Formal definitions of the condition. These may be references to ontologies, published clinical protocols or research papers." )
    protected List<UriType> definition;

    /**
     * Observations particularly relevant to this condition.
     */
    @Child(name = "observation", type = {}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Observations particularly relevant to this condition", formalDefinition="Observations particularly relevant to this condition." )
    protected List<ConditionDefinitionObservationComponent> observation;

    /**
     * Medications particularly relevant for this condition.
     */
    @Child(name = "medication", type = {}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Medications particularly relevant for this condition", formalDefinition="Medications particularly relevant for this condition." )
    protected List<ConditionDefinitionMedicationComponent> medication;

    /**
     * An observation that suggests that this condition applies.
     */
    @Child(name = "precondition", type = {}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Observation that suggets this condition", formalDefinition="An observation that suggests that this condition applies." )
    protected List<ConditionDefinitionPreconditionComponent> precondition;

    /**
     * Appropriate team for this condition.
     */
    @Child(name = "team", type = {CareTeam.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Appropriate team for this condition", formalDefinition="Appropriate team for this condition." )
    protected List<Reference> team;

    /**
     * Questionnaire for this condition.
     */
    @Child(name = "questionnaire", type = {}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Questionnaire for this condition", formalDefinition="Questionnaire for this condition." )
    protected List<ConditionDefinitionQuestionnaireComponent> questionnaire;

    /**
     * Plan that is appropriate.
     */
    @Child(name = "plan", type = {}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Plan that is appropriate", formalDefinition="Plan that is appropriate." )
    protected List<ConditionDefinitionPlanComponent> plan;

    private static final long serialVersionUID = 1055220331L;

  /**
   * Constructor
   */
    public ConditionDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public ConditionDefinition(PublicationStatus status, CodeableConcept code) {
      super();
      this.setStatus(status);
      this.setCode(code);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this condition definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this condition definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the condition definition is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.url");
        else if (Configuration.doAutoCreate())
          this.url = new UriType(); // bb
      return this.url;
    }

    public boolean hasUrlElement() { 
      return this.url != null && !this.url.isEmpty();
    }

    public boolean hasUrl() { 
      return this.url != null && !this.url.isEmpty();
    }

    /**
     * @param value {@link #url} (An absolute URI that is used to identify this condition definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this condition definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the condition definition is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public ConditionDefinition setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this condition definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this condition definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the condition definition is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this condition definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this condition definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the condition definition is stored on different servers.
     */
    public ConditionDefinition setUrl(String value) { 
      if (Utilities.noString(value))
        this.url = null;
      else {
        if (this.url == null)
          this.url = new UriType();
        this.url.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #identifier} (A formal identifier that is used to identify this condition definition when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setIdentifier(List<Identifier> theIdentifier) { 
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

    public ConditionDefinition addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the condition definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the condition definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the condition definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the condition definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public ConditionDefinition setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the condition definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the condition definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the condition definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the condition definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.
     */
    public ConditionDefinition setVersion(String value) { 
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
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public DataType getVersionAlgorithm() { 
      return this.versionAlgorithm;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public StringType getVersionAlgorithmStringType() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new StringType();
      if (!(this.versionAlgorithm instanceof StringType))
        throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (StringType) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmStringType() { 
      return this != null && this.versionAlgorithm instanceof StringType;
    }

    /**
     * @return {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public Coding getVersionAlgorithmCoding() throws FHIRException { 
      if (this.versionAlgorithm == null)
        this.versionAlgorithm = new Coding();
      if (!(this.versionAlgorithm instanceof Coding))
        throw new FHIRException("Type mismatch: the type Coding was expected, but "+this.versionAlgorithm.getClass().getName()+" was encountered");
      return (Coding) this.versionAlgorithm;
    }

    public boolean hasVersionAlgorithmCoding() { 
      return this != null && this.versionAlgorithm instanceof Coding;
    }

    public boolean hasVersionAlgorithm() { 
      return this.versionAlgorithm != null && !this.versionAlgorithm.isEmpty();
    }

    /**
     * @param value {@link #versionAlgorithm} (Indicates the mechanism used to compare versions to determine which is more current.)
     */
    public ConditionDefinition setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new FHIRException("Not the right type for ConditionDefinition.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the condition definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.name");
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
     * @param value {@link #name} (A natural language name identifying the condition definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public ConditionDefinition setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the condition definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the condition definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public ConditionDefinition setName(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the condition definition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.title");
        else if (Configuration.doAutoCreate())
          this.title = new StringType(); // bb
      return this.title;
    }

    public boolean hasTitleElement() { 
      return this.title != null && !this.title.isEmpty();
    }

    public boolean hasTitle() { 
      return this.title != null && !this.title.isEmpty();
    }

    /**
     * @param value {@link #title} (A short, descriptive, user-friendly title for the condition definition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public ConditionDefinition setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the condition definition.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the condition definition.
     */
    public ConditionDefinition setTitle(String value) { 
      if (Utilities.noString(value))
        this.title = null;
      else {
        if (this.title == null)
          this.title = new StringType();
        this.title.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #subtitle} (An explanatory or alternate title for the event definition giving additional information about its content.). This is the underlying object with id, value and extensions. The accessor "getSubtitle" gives direct access to the value
     */
    public StringType getSubtitleElement() { 
      if (this.subtitle == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.subtitle");
        else if (Configuration.doAutoCreate())
          this.subtitle = new StringType(); // bb
      return this.subtitle;
    }

    public boolean hasSubtitleElement() { 
      return this.subtitle != null && !this.subtitle.isEmpty();
    }

    public boolean hasSubtitle() { 
      return this.subtitle != null && !this.subtitle.isEmpty();
    }

    /**
     * @param value {@link #subtitle} (An explanatory or alternate title for the event definition giving additional information about its content.). This is the underlying object with id, value and extensions. The accessor "getSubtitle" gives direct access to the value
     */
    public ConditionDefinition setSubtitleElement(StringType value) { 
      this.subtitle = value;
      return this;
    }

    /**
     * @return An explanatory or alternate title for the event definition giving additional information about its content.
     */
    public String getSubtitle() { 
      return this.subtitle == null ? null : this.subtitle.getValue();
    }

    /**
     * @param value An explanatory or alternate title for the event definition giving additional information about its content.
     */
    public ConditionDefinition setSubtitle(String value) { 
      if (Utilities.noString(value))
        this.subtitle = null;
      else {
        if (this.subtitle == null)
          this.subtitle = new StringType();
        this.subtitle.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #status} (The status of this condition definition. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.status");
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
     * @param value {@link #status} (The status of this condition definition. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public ConditionDefinition setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this condition definition. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this condition definition. Enables tracking the life-cycle of the content.
     */
    public ConditionDefinition setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this condition definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.experimental");
        else if (Configuration.doAutoCreate())
          this.experimental = new BooleanType(); // bb
      return this.experimental;
    }

    public boolean hasExperimentalElement() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    public boolean hasExperimental() { 
      return this.experimental != null && !this.experimental.isEmpty();
    }

    /**
     * @param value {@link #experimental} (A Boolean value to indicate that this condition definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public ConditionDefinition setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this condition definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this condition definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public ConditionDefinition setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the condition definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the condition definition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the condition definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the condition definition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public ConditionDefinition setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the condition definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the condition definition changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the condition definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the condition definition changes.
     */
    public ConditionDefinition setDate(Date value) { 
      if (value == null)
        this.date = null;
      else {
        if (this.date == null)
          this.date = new DateTimeType();
        this.date.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the condition definition.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new StringType(); // bb
      return this.publisher;
    }

    public boolean hasPublisherElement() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    public boolean hasPublisher() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the condition definition.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public ConditionDefinition setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the condition definition.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the condition definition.
     */
    public ConditionDefinition setPublisher(String value) { 
      if (Utilities.noString(value))
        this.publisher = null;
      else {
        if (this.publisher == null)
          this.publisher = new StringType();
        this.publisher.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #contact} (Contact details to assist a user in finding and communicating with the publisher.)
     */
    public List<ContactDetail> getContact() { 
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      return this.contact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setContact(List<ContactDetail> theContact) { 
      this.contact = theContact;
      return this;
    }

    public boolean hasContact() { 
      if (this.contact == null)
        return false;
      for (ContactDetail item : this.contact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addContact() { //3
      ContactDetail t = new ContactDetail();
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return t;
    }

    public ConditionDefinition addContact(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.contact == null)
        this.contact = new ArrayList<ContactDetail>();
      this.contact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #contact}, creating it if it does not already exist {3}
     */
    public ContactDetail getContactFirstRep() { 
      if (getContact().isEmpty()) {
        addContact();
      }
      return getContact().get(0);
    }

    /**
     * @return {@link #description} (A free text natural language description of the condition definition from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.description");
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
     * @param value {@link #description} (A free text natural language description of the condition definition from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public ConditionDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the condition definition from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the condition definition from a consumer's perspective.
     */
    public ConditionDefinition setDescription(String value) { 
      if (Utilities.noString(value))
        this.description = null;
      else {
        if (this.description == null)
          this.description = new MarkdownType();
        this.description.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate condition definition instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setUseContext(List<UsageContext> theUseContext) { 
      this.useContext = theUseContext;
      return this;
    }

    public boolean hasUseContext() { 
      if (this.useContext == null)
        return false;
      for (UsageContext item : this.useContext)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public UsageContext addUseContext() { //3
      UsageContext t = new UsageContext();
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return t;
    }

    public ConditionDefinition addUseContext(UsageContext t) { //3
      if (t == null)
        return this;
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      this.useContext.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #useContext}, creating it if it does not already exist {3}
     */
    public UsageContext getUseContextFirstRep() { 
      if (getUseContext().isEmpty()) {
        addUseContext();
      }
      return getUseContext().get(0);
    }

    /**
     * @return {@link #jurisdiction} (A legal or geographic region in which the condition definition is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public ConditionDefinition addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #code} (Identification of the condition, problem or diagnosis.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (Identification of the condition, problem or diagnosis.)
     */
    public ConditionDefinition setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #severity} (A subjective assessment of the severity of the condition as evaluated by the clinician.)
     */
    public CodeableConcept getSeverity() { 
      if (this.severity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.severity");
        else if (Configuration.doAutoCreate())
          this.severity = new CodeableConcept(); // cc
      return this.severity;
    }

    public boolean hasSeverity() { 
      return this.severity != null && !this.severity.isEmpty();
    }

    /**
     * @param value {@link #severity} (A subjective assessment of the severity of the condition as evaluated by the clinician.)
     */
    public ConditionDefinition setSeverity(CodeableConcept value) { 
      this.severity = value;
      return this;
    }

    /**
     * @return {@link #bodySite} (The anatomical location where this condition manifests itself.)
     */
    public CodeableConcept getBodySite() { 
      if (this.bodySite == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.bodySite");
        else if (Configuration.doAutoCreate())
          this.bodySite = new CodeableConcept(); // cc
      return this.bodySite;
    }

    public boolean hasBodySite() { 
      return this.bodySite != null && !this.bodySite.isEmpty();
    }

    /**
     * @param value {@link #bodySite} (The anatomical location where this condition manifests itself.)
     */
    public ConditionDefinition setBodySite(CodeableConcept value) { 
      this.bodySite = value;
      return this;
    }

    /**
     * @return {@link #stage} (Clinical stage or grade of a condition. May include formal severity assessments.)
     */
    public CodeableConcept getStage() { 
      if (this.stage == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.stage");
        else if (Configuration.doAutoCreate())
          this.stage = new CodeableConcept(); // cc
      return this.stage;
    }

    public boolean hasStage() { 
      return this.stage != null && !this.stage.isEmpty();
    }

    /**
     * @param value {@link #stage} (Clinical stage or grade of a condition. May include formal severity assessments.)
     */
    public ConditionDefinition setStage(CodeableConcept value) { 
      this.stage = value;
      return this;
    }

    /**
     * @return {@link #hasSeverity} (Whether Severity is appropriate to collect for this condition.). This is the underlying object with id, value and extensions. The accessor "getHasSeverity" gives direct access to the value
     */
    public BooleanType getHasSeverityElement() { 
      if (this.hasSeverity == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.hasSeverity");
        else if (Configuration.doAutoCreate())
          this.hasSeverity = new BooleanType(); // bb
      return this.hasSeverity;
    }

    public boolean hasHasSeverityElement() { 
      return this.hasSeverity != null && !this.hasSeverity.isEmpty();
    }

    public boolean hasHasSeverity() { 
      return this.hasSeverity != null && !this.hasSeverity.isEmpty();
    }

    /**
     * @param value {@link #hasSeverity} (Whether Severity is appropriate to collect for this condition.). This is the underlying object with id, value and extensions. The accessor "getHasSeverity" gives direct access to the value
     */
    public ConditionDefinition setHasSeverityElement(BooleanType value) { 
      this.hasSeverity = value;
      return this;
    }

    /**
     * @return Whether Severity is appropriate to collect for this condition.
     */
    public boolean getHasSeverity() { 
      return this.hasSeverity == null || this.hasSeverity.isEmpty() ? false : this.hasSeverity.getValue();
    }

    /**
     * @param value Whether Severity is appropriate to collect for this condition.
     */
    public ConditionDefinition setHasSeverity(boolean value) { 
        if (this.hasSeverity == null)
          this.hasSeverity = new BooleanType();
        this.hasSeverity.setValue(value);
      return this;
    }

    /**
     * @return {@link #hasBodySite} (Whether bodySite is appropriate to collect for this condition.). This is the underlying object with id, value and extensions. The accessor "getHasBodySite" gives direct access to the value
     */
    public BooleanType getHasBodySiteElement() { 
      if (this.hasBodySite == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.hasBodySite");
        else if (Configuration.doAutoCreate())
          this.hasBodySite = new BooleanType(); // bb
      return this.hasBodySite;
    }

    public boolean hasHasBodySiteElement() { 
      return this.hasBodySite != null && !this.hasBodySite.isEmpty();
    }

    public boolean hasHasBodySite() { 
      return this.hasBodySite != null && !this.hasBodySite.isEmpty();
    }

    /**
     * @param value {@link #hasBodySite} (Whether bodySite is appropriate to collect for this condition.). This is the underlying object with id, value and extensions. The accessor "getHasBodySite" gives direct access to the value
     */
    public ConditionDefinition setHasBodySiteElement(BooleanType value) { 
      this.hasBodySite = value;
      return this;
    }

    /**
     * @return Whether bodySite is appropriate to collect for this condition.
     */
    public boolean getHasBodySite() { 
      return this.hasBodySite == null || this.hasBodySite.isEmpty() ? false : this.hasBodySite.getValue();
    }

    /**
     * @param value Whether bodySite is appropriate to collect for this condition.
     */
    public ConditionDefinition setHasBodySite(boolean value) { 
        if (this.hasBodySite == null)
          this.hasBodySite = new BooleanType();
        this.hasBodySite.setValue(value);
      return this;
    }

    /**
     * @return {@link #hasStage} (Whether stage is appropriate to collect for this condition.). This is the underlying object with id, value and extensions. The accessor "getHasStage" gives direct access to the value
     */
    public BooleanType getHasStageElement() { 
      if (this.hasStage == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create ConditionDefinition.hasStage");
        else if (Configuration.doAutoCreate())
          this.hasStage = new BooleanType(); // bb
      return this.hasStage;
    }

    public boolean hasHasStageElement() { 
      return this.hasStage != null && !this.hasStage.isEmpty();
    }

    public boolean hasHasStage() { 
      return this.hasStage != null && !this.hasStage.isEmpty();
    }

    /**
     * @param value {@link #hasStage} (Whether stage is appropriate to collect for this condition.). This is the underlying object with id, value and extensions. The accessor "getHasStage" gives direct access to the value
     */
    public ConditionDefinition setHasStageElement(BooleanType value) { 
      this.hasStage = value;
      return this;
    }

    /**
     * @return Whether stage is appropriate to collect for this condition.
     */
    public boolean getHasStage() { 
      return this.hasStage == null || this.hasStage.isEmpty() ? false : this.hasStage.getValue();
    }

    /**
     * @param value Whether stage is appropriate to collect for this condition.
     */
    public ConditionDefinition setHasStage(boolean value) { 
        if (this.hasStage == null)
          this.hasStage = new BooleanType();
        this.hasStage.setValue(value);
      return this;
    }

    /**
     * @return {@link #definition} (Formal definitions of the condition. These may be references to ontologies, published clinical protocols or research papers.)
     */
    public List<UriType> getDefinition() { 
      if (this.definition == null)
        this.definition = new ArrayList<UriType>();
      return this.definition;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setDefinition(List<UriType> theDefinition) { 
      this.definition = theDefinition;
      return this;
    }

    public boolean hasDefinition() { 
      if (this.definition == null)
        return false;
      for (UriType item : this.definition)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #definition} (Formal definitions of the condition. These may be references to ontologies, published clinical protocols or research papers.)
     */
    public UriType addDefinitionElement() {//2 
      UriType t = new UriType();
      if (this.definition == null)
        this.definition = new ArrayList<UriType>();
      this.definition.add(t);
      return t;
    }

    /**
     * @param value {@link #definition} (Formal definitions of the condition. These may be references to ontologies, published clinical protocols or research papers.)
     */
    public ConditionDefinition addDefinition(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.definition == null)
        this.definition = new ArrayList<UriType>();
      this.definition.add(t);
      return this;
    }

    /**
     * @param value {@link #definition} (Formal definitions of the condition. These may be references to ontologies, published clinical protocols or research papers.)
     */
    public boolean hasDefinition(String value) { 
      if (this.definition == null)
        return false;
      for (UriType v : this.definition)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #observation} (Observations particularly relevant to this condition.)
     */
    public List<ConditionDefinitionObservationComponent> getObservation() { 
      if (this.observation == null)
        this.observation = new ArrayList<ConditionDefinitionObservationComponent>();
      return this.observation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setObservation(List<ConditionDefinitionObservationComponent> theObservation) { 
      this.observation = theObservation;
      return this;
    }

    public boolean hasObservation() { 
      if (this.observation == null)
        return false;
      for (ConditionDefinitionObservationComponent item : this.observation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ConditionDefinitionObservationComponent addObservation() { //3
      ConditionDefinitionObservationComponent t = new ConditionDefinitionObservationComponent();
      if (this.observation == null)
        this.observation = new ArrayList<ConditionDefinitionObservationComponent>();
      this.observation.add(t);
      return t;
    }

    public ConditionDefinition addObservation(ConditionDefinitionObservationComponent t) { //3
      if (t == null)
        return this;
      if (this.observation == null)
        this.observation = new ArrayList<ConditionDefinitionObservationComponent>();
      this.observation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #observation}, creating it if it does not already exist {3}
     */
    public ConditionDefinitionObservationComponent getObservationFirstRep() { 
      if (getObservation().isEmpty()) {
        addObservation();
      }
      return getObservation().get(0);
    }

    /**
     * @return {@link #medication} (Medications particularly relevant for this condition.)
     */
    public List<ConditionDefinitionMedicationComponent> getMedication() { 
      if (this.medication == null)
        this.medication = new ArrayList<ConditionDefinitionMedicationComponent>();
      return this.medication;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setMedication(List<ConditionDefinitionMedicationComponent> theMedication) { 
      this.medication = theMedication;
      return this;
    }

    public boolean hasMedication() { 
      if (this.medication == null)
        return false;
      for (ConditionDefinitionMedicationComponent item : this.medication)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ConditionDefinitionMedicationComponent addMedication() { //3
      ConditionDefinitionMedicationComponent t = new ConditionDefinitionMedicationComponent();
      if (this.medication == null)
        this.medication = new ArrayList<ConditionDefinitionMedicationComponent>();
      this.medication.add(t);
      return t;
    }

    public ConditionDefinition addMedication(ConditionDefinitionMedicationComponent t) { //3
      if (t == null)
        return this;
      if (this.medication == null)
        this.medication = new ArrayList<ConditionDefinitionMedicationComponent>();
      this.medication.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #medication}, creating it if it does not already exist {3}
     */
    public ConditionDefinitionMedicationComponent getMedicationFirstRep() { 
      if (getMedication().isEmpty()) {
        addMedication();
      }
      return getMedication().get(0);
    }

    /**
     * @return {@link #precondition} (An observation that suggests that this condition applies.)
     */
    public List<ConditionDefinitionPreconditionComponent> getPrecondition() { 
      if (this.precondition == null)
        this.precondition = new ArrayList<ConditionDefinitionPreconditionComponent>();
      return this.precondition;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setPrecondition(List<ConditionDefinitionPreconditionComponent> thePrecondition) { 
      this.precondition = thePrecondition;
      return this;
    }

    public boolean hasPrecondition() { 
      if (this.precondition == null)
        return false;
      for (ConditionDefinitionPreconditionComponent item : this.precondition)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ConditionDefinitionPreconditionComponent addPrecondition() { //3
      ConditionDefinitionPreconditionComponent t = new ConditionDefinitionPreconditionComponent();
      if (this.precondition == null)
        this.precondition = new ArrayList<ConditionDefinitionPreconditionComponent>();
      this.precondition.add(t);
      return t;
    }

    public ConditionDefinition addPrecondition(ConditionDefinitionPreconditionComponent t) { //3
      if (t == null)
        return this;
      if (this.precondition == null)
        this.precondition = new ArrayList<ConditionDefinitionPreconditionComponent>();
      this.precondition.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #precondition}, creating it if it does not already exist {3}
     */
    public ConditionDefinitionPreconditionComponent getPreconditionFirstRep() { 
      if (getPrecondition().isEmpty()) {
        addPrecondition();
      }
      return getPrecondition().get(0);
    }

    /**
     * @return {@link #team} (Appropriate team for this condition.)
     */
    public List<Reference> getTeam() { 
      if (this.team == null)
        this.team = new ArrayList<Reference>();
      return this.team;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setTeam(List<Reference> theTeam) { 
      this.team = theTeam;
      return this;
    }

    public boolean hasTeam() { 
      if (this.team == null)
        return false;
      for (Reference item : this.team)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addTeam() { //3
      Reference t = new Reference();
      if (this.team == null)
        this.team = new ArrayList<Reference>();
      this.team.add(t);
      return t;
    }

    public ConditionDefinition addTeam(Reference t) { //3
      if (t == null)
        return this;
      if (this.team == null)
        this.team = new ArrayList<Reference>();
      this.team.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #team}, creating it if it does not already exist {3}
     */
    public Reference getTeamFirstRep() { 
      if (getTeam().isEmpty()) {
        addTeam();
      }
      return getTeam().get(0);
    }

    /**
     * @return {@link #questionnaire} (Questionnaire for this condition.)
     */
    public List<ConditionDefinitionQuestionnaireComponent> getQuestionnaire() { 
      if (this.questionnaire == null)
        this.questionnaire = new ArrayList<ConditionDefinitionQuestionnaireComponent>();
      return this.questionnaire;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setQuestionnaire(List<ConditionDefinitionQuestionnaireComponent> theQuestionnaire) { 
      this.questionnaire = theQuestionnaire;
      return this;
    }

    public boolean hasQuestionnaire() { 
      if (this.questionnaire == null)
        return false;
      for (ConditionDefinitionQuestionnaireComponent item : this.questionnaire)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ConditionDefinitionQuestionnaireComponent addQuestionnaire() { //3
      ConditionDefinitionQuestionnaireComponent t = new ConditionDefinitionQuestionnaireComponent();
      if (this.questionnaire == null)
        this.questionnaire = new ArrayList<ConditionDefinitionQuestionnaireComponent>();
      this.questionnaire.add(t);
      return t;
    }

    public ConditionDefinition addQuestionnaire(ConditionDefinitionQuestionnaireComponent t) { //3
      if (t == null)
        return this;
      if (this.questionnaire == null)
        this.questionnaire = new ArrayList<ConditionDefinitionQuestionnaireComponent>();
      this.questionnaire.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #questionnaire}, creating it if it does not already exist {3}
     */
    public ConditionDefinitionQuestionnaireComponent getQuestionnaireFirstRep() { 
      if (getQuestionnaire().isEmpty()) {
        addQuestionnaire();
      }
      return getQuestionnaire().get(0);
    }

    /**
     * @return {@link #plan} (Plan that is appropriate.)
     */
    public List<ConditionDefinitionPlanComponent> getPlan() { 
      if (this.plan == null)
        this.plan = new ArrayList<ConditionDefinitionPlanComponent>();
      return this.plan;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setPlan(List<ConditionDefinitionPlanComponent> thePlan) { 
      this.plan = thePlan;
      return this;
    }

    public boolean hasPlan() { 
      if (this.plan == null)
        return false;
      for (ConditionDefinitionPlanComponent item : this.plan)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ConditionDefinitionPlanComponent addPlan() { //3
      ConditionDefinitionPlanComponent t = new ConditionDefinitionPlanComponent();
      if (this.plan == null)
        this.plan = new ArrayList<ConditionDefinitionPlanComponent>();
      this.plan.add(t);
      return t;
    }

    public ConditionDefinition addPlan(ConditionDefinitionPlanComponent t) { //3
      if (t == null)
        return this;
      if (this.plan == null)
        this.plan = new ArrayList<ConditionDefinitionPlanComponent>();
      this.plan.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #plan}, creating it if it does not already exist {3}
     */
    public ConditionDefinitionPlanComponent getPlanFirstRep() { 
      if (getPlan().isEmpty()) {
        addPlan();
      }
      return getPlan().get(0);
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getPurposeMax() { 
      return 0;
    }
    /**
     * @return {@link #purpose} (Explanation of why this condition definition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"purpose\"");
    }

    public boolean hasPurposeElement() { 
      return false;
    }
    public boolean hasPurpose() {
      return false;
    }

    /**
     * @param value {@link #purpose} (Explanation of why this condition definition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public ConditionDefinition setPurposeElement(MarkdownType value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"purpose\""); 
    }
    public String getPurpose() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"purpose\""); 
    }
    /**
     * @param value Explanation of why this condition definition is needed and why it has been designed as it has.
     */
    public ConditionDefinition setPurpose(String value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"purpose\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getCopyrightMax() { 
      return 0;
    }
    /**
     * @return {@link #copyright} (A copyright statement relating to the condition definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the condition definition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"copyright\"");
    }

    public boolean hasCopyrightElement() { 
      return false;
    }
    public boolean hasCopyright() {
      return false;
    }

    /**
     * @param value {@link #copyright} (A copyright statement relating to the condition definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the condition definition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public ConditionDefinition setCopyrightElement(MarkdownType value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"copyright\""); 
    }
    public String getCopyright() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"copyright\""); 
    }
    /**
     * @param value A copyright statement relating to the condition definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the condition definition.
     */
    public ConditionDefinition setCopyright(String value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"copyright\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getCopyrightLabelMax() { 
      return 0;
    }
    /**
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"copyrightLabel\"");
    }

    public boolean hasCopyrightLabelElement() { 
      return false;
    }
    public boolean hasCopyrightLabel() {
      return false;
    }

    /**
     * @param value {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public ConditionDefinition setCopyrightLabelElement(StringType value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"copyrightLabel\""); 
    }
    public String getCopyrightLabel() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"copyrightLabel\""); 
    }
    /**
     * @param value A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public ConditionDefinition setCopyrightLabel(String value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"copyrightLabel\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getApprovalDateMax() { 
      return 0;
    }
    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"approvalDate\"");
    }

    public boolean hasApprovalDateElement() { 
      return false;
    }
    public boolean hasApprovalDate() {
      return false;
    }

    /**
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public ConditionDefinition setApprovalDateElement(DateType value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"approvalDate\""); 
    }
    public Date getApprovalDate() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"approvalDate\""); 
    }
    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public ConditionDefinition setApprovalDate(Date value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"approvalDate\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getLastReviewDateMax() { 
      return 0;
    }
    /**
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"lastReviewDate\"");
    }

    public boolean hasLastReviewDateElement() { 
      return false;
    }
    public boolean hasLastReviewDate() {
      return false;
    }

    /**
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public ConditionDefinition setLastReviewDateElement(DateType value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"lastReviewDate\""); 
    }
    public Date getLastReviewDate() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"lastReviewDate\""); 
    }
    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public ConditionDefinition setLastReviewDate(Date value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"lastReviewDate\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEffectivePeriodMax() { 
      return 0;
    }
    /**
     * @return {@link #effectivePeriod} (The period during which the condition definition content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"effectivePeriod\""); 
    }
    public boolean hasEffectivePeriod() { 
      return false;
    }
    /**
     * @param value {@link #effectivePeriod} (The period during which the condition definition content was or is planned to be in active use.)
     */
    public ConditionDefinition setEffectivePeriod(Period value) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"effectivePeriod\""); 
    }

    /**
     * not supported on this implementation
     */
    @Override
    public int getTopicMax() { 
      return 0;
    }
    /**
     * @return {@link #topic} (Descriptive topics related to the content of the condition definition. Topics provide a high-level categorization as well as keywords for the condition definition that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setTopic(List<CodeableConcept> theTopic) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"topic\""); 
    }
    public boolean hasTopic() { 
      return false;
    }

    public CodeableConcept addTopic() { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"topic\""); 
    }
    public ConditionDefinition addTopic(CodeableConcept t) { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"topic\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {2}
     */
    public CodeableConcept getTopicFirstRep() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"topic\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getAuthorMax() { 
      return 0;
    }
    /**
     * @return {@link #author} (An individiual or organization primarily involved in the creation and maintenance of the condition definition.)
     */
    public List<ContactDetail> getAuthor() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setAuthor(List<ContactDetail> theAuthor) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"author\""); 
    }
    public boolean hasAuthor() { 
      return false;
    }

    public ContactDetail addAuthor() { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"author\""); 
    }
    public ConditionDefinition addAuthor(ContactDetail t) { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"author\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {2}
     */
    public ContactDetail getAuthorFirstRep() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"author\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEditorMax() { 
      return 0;
    }
    /**
     * @return {@link #editor} (An individual or organization primarily responsible for internal coherence of the condition definition.)
     */
    public List<ContactDetail> getEditor() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setEditor(List<ContactDetail> theEditor) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"editor\""); 
    }
    public boolean hasEditor() { 
      return false;
    }

    public ContactDetail addEditor() { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"editor\""); 
    }
    public ConditionDefinition addEditor(ContactDetail t) { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"editor\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #editor}, creating it if it does not already exist {2}
     */
    public ContactDetail getEditorFirstRep() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"editor\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getReviewerMax() { 
      return 0;
    }
    /**
     * @return {@link #reviewer} (An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the condition definition.)
     */
    public List<ContactDetail> getReviewer() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setReviewer(List<ContactDetail> theReviewer) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"reviewer\""); 
    }
    public boolean hasReviewer() { 
      return false;
    }

    public ContactDetail addReviewer() { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"reviewer\""); 
    }
    public ConditionDefinition addReviewer(ContactDetail t) { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"reviewer\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #reviewer}, creating it if it does not already exist {2}
     */
    public ContactDetail getReviewerFirstRep() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"reviewer\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getEndorserMax() { 
      return 0;
    }
    /**
     * @return {@link #endorser} (An individual or organization asserted by the publisher to be responsible for officially endorsing the condition definition for use in some setting.)
     */
    public List<ContactDetail> getEndorser() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setEndorser(List<ContactDetail> theEndorser) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"endorser\""); 
    }
    public boolean hasEndorser() { 
      return false;
    }

    public ContactDetail addEndorser() { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"endorser\""); 
    }
    public ConditionDefinition addEndorser(ContactDetail t) { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"endorser\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #endorser}, creating it if it does not already exist {2}
     */
    public ContactDetail getEndorserFirstRep() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"endorser\""); 
    }
    /**
     * not supported on this implementation
     */
    @Override
    public int getRelatedArtifactMax() { 
      return 0;
    }
    /**
     * @return {@link #relatedArtifact} (Related artifacts such as additional documentation, justification, dependencies, bibliographic references, and predecessor and successor artifacts.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      return new ArrayList<>();
    }
    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public ConditionDefinition setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"relatedArtifact\""); 
    }
    public boolean hasRelatedArtifact() { 
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"relatedArtifact\""); 
    }
    public ConditionDefinition addRelatedArtifact(RelatedArtifact t) { //3
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"relatedArtifact\""); 
    }
    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {2}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      throw new Error("The resource type \"ConditionDefinition\" does not implement the property \"relatedArtifact\""); 
    }
      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this condition definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this condition definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the condition definition is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this condition definition when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the condition definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the condition definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the condition definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the condition definition.", 0, 1, title));
        children.add(new Property("subtitle", "string", "An explanatory or alternate title for the event definition giving additional information about its content.", 0, 1, subtitle));
        children.add(new Property("status", "code", "The status of this condition definition. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this condition definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the condition definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the condition definition changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the condition definition.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the condition definition from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate condition definition instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the condition definition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("code", "CodeableConcept", "Identification of the condition, problem or diagnosis.", 0, 1, code));
        children.add(new Property("severity", "CodeableConcept", "A subjective assessment of the severity of the condition as evaluated by the clinician.", 0, 1, severity));
        children.add(new Property("bodySite", "CodeableConcept", "The anatomical location where this condition manifests itself.", 0, 1, bodySite));
        children.add(new Property("stage", "CodeableConcept", "Clinical stage or grade of a condition. May include formal severity assessments.", 0, 1, stage));
        children.add(new Property("hasSeverity", "boolean", "Whether Severity is appropriate to collect for this condition.", 0, 1, hasSeverity));
        children.add(new Property("hasBodySite", "boolean", "Whether bodySite is appropriate to collect for this condition.", 0, 1, hasBodySite));
        children.add(new Property("hasStage", "boolean", "Whether stage is appropriate to collect for this condition.", 0, 1, hasStage));
        children.add(new Property("definition", "uri", "Formal definitions of the condition. These may be references to ontologies, published clinical protocols or research papers.", 0, java.lang.Integer.MAX_VALUE, definition));
        children.add(new Property("observation", "", "Observations particularly relevant to this condition.", 0, java.lang.Integer.MAX_VALUE, observation));
        children.add(new Property("medication", "", "Medications particularly relevant for this condition.", 0, java.lang.Integer.MAX_VALUE, medication));
        children.add(new Property("precondition", "", "An observation that suggests that this condition applies.", 0, java.lang.Integer.MAX_VALUE, precondition));
        children.add(new Property("team", "Reference(CareTeam)", "Appropriate team for this condition.", 0, java.lang.Integer.MAX_VALUE, team));
        children.add(new Property("questionnaire", "", "Questionnaire for this condition.", 0, java.lang.Integer.MAX_VALUE, questionnaire));
        children.add(new Property("plan", "", "Plan that is appropriate.", 0, java.lang.Integer.MAX_VALUE, plan));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this condition definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this condition definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the condition definition is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this condition definition when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the condition definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the condition definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the condition definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the condition definition.", 0, 1, title);
        case -2060497896: /*subtitle*/  return new Property("subtitle", "string", "An explanatory or alternate title for the event definition giving additional information about its content.", 0, 1, subtitle);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this condition definition. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this condition definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the condition definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the condition definition changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the condition definition.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the condition definition from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate condition definition instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the condition definition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "Identification of the condition, problem or diagnosis.", 0, 1, code);
        case 1478300413: /*severity*/  return new Property("severity", "CodeableConcept", "A subjective assessment of the severity of the condition as evaluated by the clinician.", 0, 1, severity);
        case 1702620169: /*bodySite*/  return new Property("bodySite", "CodeableConcept", "The anatomical location where this condition manifests itself.", 0, 1, bodySite);
        case 109757182: /*stage*/  return new Property("stage", "CodeableConcept", "Clinical stage or grade of a condition. May include formal severity assessments.", 0, 1, stage);
        case 57790391: /*hasSeverity*/  return new Property("hasSeverity", "boolean", "Whether Severity is appropriate to collect for this condition.", 0, 1, hasSeverity);
        case 282110147: /*hasBodySite*/  return new Property("hasBodySite", "boolean", "Whether bodySite is appropriate to collect for this condition.", 0, 1, hasBodySite);
        case 129749124: /*hasStage*/  return new Property("hasStage", "boolean", "Whether stage is appropriate to collect for this condition.", 0, 1, hasStage);
        case -1014418093: /*definition*/  return new Property("definition", "uri", "Formal definitions of the condition. These may be references to ontologies, published clinical protocols or research papers.", 0, java.lang.Integer.MAX_VALUE, definition);
        case 122345516: /*observation*/  return new Property("observation", "", "Observations particularly relevant to this condition.", 0, java.lang.Integer.MAX_VALUE, observation);
        case 1998965455: /*medication*/  return new Property("medication", "", "Medications particularly relevant for this condition.", 0, java.lang.Integer.MAX_VALUE, medication);
        case -650968616: /*precondition*/  return new Property("precondition", "", "An observation that suggests that this condition applies.", 0, java.lang.Integer.MAX_VALUE, precondition);
        case 3555933: /*team*/  return new Property("team", "Reference(CareTeam)", "Appropriate team for this condition.", 0, java.lang.Integer.MAX_VALUE, team);
        case -1017049693: /*questionnaire*/  return new Property("questionnaire", "", "Questionnaire for this condition.", 0, java.lang.Integer.MAX_VALUE, questionnaire);
        case 3443497: /*plan*/  return new Property("plan", "", "Plan that is appropriate.", 0, java.lang.Integer.MAX_VALUE, plan);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 1508158071: /*versionAlgorithm*/ return this.versionAlgorithm == null ? new Base[0] : new Base[] {this.versionAlgorithm}; // DataType
        case 3373707: /*name*/ return this.name == null ? new Base[0] : new Base[] {this.name}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -2060497896: /*subtitle*/ return this.subtitle == null ? new Base[0] : new Base[] {this.subtitle}; // StringType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case 1478300413: /*severity*/ return this.severity == null ? new Base[0] : new Base[] {this.severity}; // CodeableConcept
        case 1702620169: /*bodySite*/ return this.bodySite == null ? new Base[0] : new Base[] {this.bodySite}; // CodeableConcept
        case 109757182: /*stage*/ return this.stage == null ? new Base[0] : new Base[] {this.stage}; // CodeableConcept
        case 57790391: /*hasSeverity*/ return this.hasSeverity == null ? new Base[0] : new Base[] {this.hasSeverity}; // BooleanType
        case 282110147: /*hasBodySite*/ return this.hasBodySite == null ? new Base[0] : new Base[] {this.hasBodySite}; // BooleanType
        case 129749124: /*hasStage*/ return this.hasStage == null ? new Base[0] : new Base[] {this.hasStage}; // BooleanType
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : this.definition.toArray(new Base[this.definition.size()]); // UriType
        case 122345516: /*observation*/ return this.observation == null ? new Base[0] : this.observation.toArray(new Base[this.observation.size()]); // ConditionDefinitionObservationComponent
        case 1998965455: /*medication*/ return this.medication == null ? new Base[0] : this.medication.toArray(new Base[this.medication.size()]); // ConditionDefinitionMedicationComponent
        case -650968616: /*precondition*/ return this.precondition == null ? new Base[0] : this.precondition.toArray(new Base[this.precondition.size()]); // ConditionDefinitionPreconditionComponent
        case 3555933: /*team*/ return this.team == null ? new Base[0] : this.team.toArray(new Base[this.team.size()]); // Reference
        case -1017049693: /*questionnaire*/ return this.questionnaire == null ? new Base[0] : this.questionnaire.toArray(new Base[this.questionnaire.size()]); // ConditionDefinitionQuestionnaireComponent
        case 3443497: /*plan*/ return this.plan == null ? new Base[0] : this.plan.toArray(new Base[this.plan.size()]); // ConditionDefinitionPlanComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 116079: // url
          this.url = TypeConvertor.castToUri(value); // UriType
          return value;
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 1508158071: // versionAlgorithm
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
          return value;
        case 3373707: // name
          this.name = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -2060497896: // subtitle
          this.subtitle = TypeConvertor.castToString(value); // StringType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToString(value); // StringType
          return value;
        case 951526432: // contact
          this.getContact().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -669707736: // useContext
          this.getUseContext().add(TypeConvertor.castToUsageContext(value)); // UsageContext
          return value;
        case -507075711: // jurisdiction
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1478300413: // severity
          this.severity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1702620169: // bodySite
          this.bodySite = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 109757182: // stage
          this.stage = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 57790391: // hasSeverity
          this.hasSeverity = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 282110147: // hasBodySite
          this.hasBodySite = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 129749124: // hasStage
          this.hasStage = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1014418093: // definition
          this.getDefinition().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case 122345516: // observation
          this.getObservation().add((ConditionDefinitionObservationComponent) value); // ConditionDefinitionObservationComponent
          return value;
        case 1998965455: // medication
          this.getMedication().add((ConditionDefinitionMedicationComponent) value); // ConditionDefinitionMedicationComponent
          return value;
        case -650968616: // precondition
          this.getPrecondition().add((ConditionDefinitionPreconditionComponent) value); // ConditionDefinitionPreconditionComponent
          return value;
        case 3555933: // team
          this.getTeam().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -1017049693: // questionnaire
          this.getQuestionnaire().add((ConditionDefinitionQuestionnaireComponent) value); // ConditionDefinitionQuestionnaireComponent
          return value;
        case 3443497: // plan
          this.getPlan().add((ConditionDefinitionPlanComponent) value); // ConditionDefinitionPlanComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("name")) {
          this.name = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("subtitle")) {
          this.subtitle = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("severity")) {
          this.severity = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("bodySite")) {
          this.bodySite = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("stage")) {
          this.stage = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("hasSeverity")) {
          this.hasSeverity = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("hasBodySite")) {
          this.hasBodySite = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("hasStage")) {
          this.hasStage = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("definition")) {
          this.getDefinition().add(TypeConvertor.castToUri(value));
        } else if (name.equals("observation")) {
          this.getObservation().add((ConditionDefinitionObservationComponent) value);
        } else if (name.equals("medication")) {
          this.getMedication().add((ConditionDefinitionMedicationComponent) value);
        } else if (name.equals("precondition")) {
          this.getPrecondition().add((ConditionDefinitionPreconditionComponent) value);
        } else if (name.equals("team")) {
          this.getTeam().add(TypeConvertor.castToReference(value));
        } else if (name.equals("questionnaire")) {
          this.getQuestionnaire().add((ConditionDefinitionQuestionnaireComponent) value);
        } else if (name.equals("plan")) {
          this.getPlan().add((ConditionDefinitionPlanComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = null;
        } else if (name.equals("identifier")) {
          this.getIdentifier().remove(value);
        } else if (name.equals("version")) {
          this.version = null;
        } else if (name.equals("versionAlgorithm[x]")) {
          this.versionAlgorithm = null;
        } else if (name.equals("name")) {
          this.name = null;
        } else if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("subtitle")) {
          this.subtitle = null;
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = null;
        } else if (name.equals("date")) {
          this.date = null;
        } else if (name.equals("publisher")) {
          this.publisher = null;
        } else if (name.equals("contact")) {
          this.getContact().remove(value);
        } else if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("useContext")) {
          this.getUseContext().remove(value);
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().remove(value);
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("severity")) {
          this.severity = null;
        } else if (name.equals("bodySite")) {
          this.bodySite = null;
        } else if (name.equals("stage")) {
          this.stage = null;
        } else if (name.equals("hasSeverity")) {
          this.hasSeverity = null;
        } else if (name.equals("hasBodySite")) {
          this.hasBodySite = null;
        } else if (name.equals("hasStage")) {
          this.hasStage = null;
        } else if (name.equals("definition")) {
          this.getDefinition().remove(value);
        } else if (name.equals("observation")) {
          this.getObservation().remove((ConditionDefinitionObservationComponent) value);
        } else if (name.equals("medication")) {
          this.getMedication().remove((ConditionDefinitionMedicationComponent) value);
        } else if (name.equals("precondition")) {
          this.getPrecondition().remove((ConditionDefinitionPreconditionComponent) value);
        } else if (name.equals("team")) {
          this.getTeam().remove(value);
        } else if (name.equals("questionnaire")) {
          this.getQuestionnaire().remove((ConditionDefinitionQuestionnaireComponent) value);
        } else if (name.equals("plan")) {
          this.getPlan().remove((ConditionDefinitionPlanComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return addIdentifier(); 
        case 351608024:  return getVersionElement();
        case -115699031:  return getVersionAlgorithm();
        case 1508158071:  return getVersionAlgorithm();
        case 3373707:  return getNameElement();
        case 110371416:  return getTitleElement();
        case -2060497896:  return getSubtitleElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case 3059181:  return getCode();
        case 1478300413:  return getSeverity();
        case 1702620169:  return getBodySite();
        case 109757182:  return getStage();
        case 57790391:  return getHasSeverityElement();
        case 282110147:  return getHasBodySiteElement();
        case 129749124:  return getHasStageElement();
        case -1014418093:  return addDefinitionElement();
        case 122345516:  return addObservation(); 
        case 1998965455:  return addMedication(); 
        case -650968616:  return addPrecondition(); 
        case 3555933:  return addTeam(); 
        case -1017049693:  return addQuestionnaire(); 
        case 3443497:  return addPlan(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 1508158071: /*versionAlgorithm*/ return new String[] {"string", "Coding"};
        case 3373707: /*name*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -2060497896: /*subtitle*/ return new String[] {"string"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 1478300413: /*severity*/ return new String[] {"CodeableConcept"};
        case 1702620169: /*bodySite*/ return new String[] {"CodeableConcept"};
        case 109757182: /*stage*/ return new String[] {"CodeableConcept"};
        case 57790391: /*hasSeverity*/ return new String[] {"boolean"};
        case 282110147: /*hasBodySite*/ return new String[] {"boolean"};
        case 129749124: /*hasStage*/ return new String[] {"boolean"};
        case -1014418093: /*definition*/ return new String[] {"uri"};
        case 122345516: /*observation*/ return new String[] {};
        case 1998965455: /*medication*/ return new String[] {};
        case -650968616: /*precondition*/ return new String[] {};
        case 3555933: /*team*/ return new String[] {"Reference"};
        case -1017049693: /*questionnaire*/ return new String[] {};
        case 3443497: /*plan*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.version");
        }
        else if (name.equals("versionAlgorithmString")) {
          this.versionAlgorithm = new StringType();
          return this.versionAlgorithm;
        }
        else if (name.equals("versionAlgorithmCoding")) {
          this.versionAlgorithm = new Coding();
          return this.versionAlgorithm;
        }
        else if (name.equals("name")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.title");
        }
        else if (name.equals("subtitle")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.subtitle");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.experimental");
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("severity")) {
          this.severity = new CodeableConcept();
          return this.severity;
        }
        else if (name.equals("bodySite")) {
          this.bodySite = new CodeableConcept();
          return this.bodySite;
        }
        else if (name.equals("stage")) {
          this.stage = new CodeableConcept();
          return this.stage;
        }
        else if (name.equals("hasSeverity")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.hasSeverity");
        }
        else if (name.equals("hasBodySite")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.hasBodySite");
        }
        else if (name.equals("hasStage")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.hasStage");
        }
        else if (name.equals("definition")) {
          throw new FHIRException("Cannot call addChild on a singleton property ConditionDefinition.definition");
        }
        else if (name.equals("observation")) {
          return addObservation();
        }
        else if (name.equals("medication")) {
          return addMedication();
        }
        else if (name.equals("precondition")) {
          return addPrecondition();
        }
        else if (name.equals("team")) {
          return addTeam();
        }
        else if (name.equals("questionnaire")) {
          return addQuestionnaire();
        }
        else if (name.equals("plan")) {
          return addPlan();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "ConditionDefinition";

  }

      public ConditionDefinition copy() {
        ConditionDefinition dst = new ConditionDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(ConditionDefinition dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        dst.version = version == null ? null : version.copy();
        dst.versionAlgorithm = versionAlgorithm == null ? null : versionAlgorithm.copy();
        dst.name = name == null ? null : name.copy();
        dst.title = title == null ? null : title.copy();
        dst.subtitle = subtitle == null ? null : subtitle.copy();
        dst.status = status == null ? null : status.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.date = date == null ? null : date.copy();
        dst.publisher = publisher == null ? null : publisher.copy();
        if (contact != null) {
          dst.contact = new ArrayList<ContactDetail>();
          for (ContactDetail i : contact)
            dst.contact.add(i.copy());
        };
        dst.description = description == null ? null : description.copy();
        if (useContext != null) {
          dst.useContext = new ArrayList<UsageContext>();
          for (UsageContext i : useContext)
            dst.useContext.add(i.copy());
        };
        if (jurisdiction != null) {
          dst.jurisdiction = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : jurisdiction)
            dst.jurisdiction.add(i.copy());
        };
        dst.code = code == null ? null : code.copy();
        dst.severity = severity == null ? null : severity.copy();
        dst.bodySite = bodySite == null ? null : bodySite.copy();
        dst.stage = stage == null ? null : stage.copy();
        dst.hasSeverity = hasSeverity == null ? null : hasSeverity.copy();
        dst.hasBodySite = hasBodySite == null ? null : hasBodySite.copy();
        dst.hasStage = hasStage == null ? null : hasStage.copy();
        if (definition != null) {
          dst.definition = new ArrayList<UriType>();
          for (UriType i : definition)
            dst.definition.add(i.copy());
        };
        if (observation != null) {
          dst.observation = new ArrayList<ConditionDefinitionObservationComponent>();
          for (ConditionDefinitionObservationComponent i : observation)
            dst.observation.add(i.copy());
        };
        if (medication != null) {
          dst.medication = new ArrayList<ConditionDefinitionMedicationComponent>();
          for (ConditionDefinitionMedicationComponent i : medication)
            dst.medication.add(i.copy());
        };
        if (precondition != null) {
          dst.precondition = new ArrayList<ConditionDefinitionPreconditionComponent>();
          for (ConditionDefinitionPreconditionComponent i : precondition)
            dst.precondition.add(i.copy());
        };
        if (team != null) {
          dst.team = new ArrayList<Reference>();
          for (Reference i : team)
            dst.team.add(i.copy());
        };
        if (questionnaire != null) {
          dst.questionnaire = new ArrayList<ConditionDefinitionQuestionnaireComponent>();
          for (ConditionDefinitionQuestionnaireComponent i : questionnaire)
            dst.questionnaire.add(i.copy());
        };
        if (plan != null) {
          dst.plan = new ArrayList<ConditionDefinitionPlanComponent>();
          for (ConditionDefinitionPlanComponent i : plan)
            dst.plan.add(i.copy());
        };
      }

      protected ConditionDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof ConditionDefinition))
          return false;
        ConditionDefinition o = (ConditionDefinition) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(subtitle, o.subtitle, true) && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true)
           && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(code, o.code, true) && compareDeep(severity, o.severity, true)
           && compareDeep(bodySite, o.bodySite, true) && compareDeep(stage, o.stage, true) && compareDeep(hasSeverity, o.hasSeverity, true)
           && compareDeep(hasBodySite, o.hasBodySite, true) && compareDeep(hasStage, o.hasStage, true) && compareDeep(definition, o.definition, true)
           && compareDeep(observation, o.observation, true) && compareDeep(medication, o.medication, true)
           && compareDeep(precondition, o.precondition, true) && compareDeep(team, o.team, true) && compareDeep(questionnaire, o.questionnaire, true)
           && compareDeep(plan, o.plan, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof ConditionDefinition))
          return false;
        ConditionDefinition o = (ConditionDefinition) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(subtitle, o.subtitle, true) && compareValues(status, o.status, true)
           && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true)
           && compareValues(description, o.description, true) && compareValues(hasSeverity, o.hasSeverity, true)
           && compareValues(hasBodySite, o.hasBodySite, true) && compareValues(hasStage, o.hasStage, true) && compareValues(definition, o.definition, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, subtitle, status, experimental, date, publisher
          , contact, description, useContext, jurisdiction, code, severity, bodySite, stage
          , hasSeverity, hasBodySite, hasStage, definition, observation, medication, precondition
          , team, questionnaire, plan);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.ConditionDefinition;
   }

 /**
   * Search parameter: <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-quantity", path="(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition\r\n* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition\r\n* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide\r\n* [Library](library.html): A quantity- or range-valued use context assigned to the library\r\n* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script\r\n* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set\r\n", type="quantity" )
  public static final String SP_CONTEXT_QUANTITY = "context-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A quantity- or range-valued use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A quantity- or range-valued use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A quantity- or range-valued use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A quantity- or range-valued use context assigned to the charge item definition
* [Citation](citation.html): A quantity- or range-valued use context assigned to the citation
* [CodeSystem](codesystem.html): A quantity- or range-valued use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A quantity- or range-valued use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A quantity- or range-valued use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A quantity- or range-valued use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A quantity- or range-valued use context assigned to the event definition
* [Evidence](evidence.html): A quantity- or range-valued use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A quantity- or range-valued use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A quantity- or range-valued use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A quantity- or range-valued use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A quantity- or range-valued use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A quantity- or range-valued use context assigned to the implementation guide
* [Library](library.html): A quantity- or range-valued use context assigned to the library
* [Measure](measure.html): A quantity- or range-valued use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A quantity- or range-valued use context assigned to the message definition
* [NamingSystem](namingsystem.html): A quantity- or range-valued use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A quantity- or range-valued use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A quantity- or range-valued use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A quantity- or range-valued use context assigned to the questionnaire
* [Requirements](requirements.html): A quantity- or range-valued use context assigned to the requirements
* [SearchParameter](searchparameter.html): A quantity- or range-valued use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A quantity- or range-valued use context assigned to the structure definition
* [StructureMap](structuremap.html): A quantity- or range-valued use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A quantity- or range-valued use context assigned to the terminology capabilities
* [TestScript](testscript.html): A quantity- or range-valued use context assigned to the test script
* [ValueSet](valueset.html): A quantity- or range-valued use context assigned to the value set
</b><br>
   * Type: <b>quantity</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(Quantity)) | (ActivityDefinition.useContext.value.ofType(Range)) | (ActorDefinition.useContext.value.ofType(Quantity)) | (ActorDefinition.useContext.value.ofType(Range)) | (CapabilityStatement.useContext.value.ofType(Quantity)) | (CapabilityStatement.useContext.value.ofType(Range)) | (ChargeItemDefinition.useContext.value.ofType(Quantity)) | (ChargeItemDefinition.useContext.value.ofType(Range)) | (Citation.useContext.value.ofType(Quantity)) | (Citation.useContext.value.ofType(Range)) | (CodeSystem.useContext.value.ofType(Quantity)) | (CodeSystem.useContext.value.ofType(Range)) | (CompartmentDefinition.useContext.value.ofType(Quantity)) | (CompartmentDefinition.useContext.value.ofType(Range)) | (ConceptMap.useContext.value.ofType(Quantity)) | (ConceptMap.useContext.value.ofType(Range)) | (ConditionDefinition.useContext.value.ofType(Quantity)) | (ConditionDefinition.useContext.value.ofType(Range)) | (EventDefinition.useContext.value.ofType(Quantity)) | (EventDefinition.useContext.value.ofType(Range)) | (Evidence.useContext.value.ofType(Quantity)) | (Evidence.useContext.value.ofType(Range)) | (EvidenceReport.useContext.value.ofType(Quantity)) | (EvidenceReport.useContext.value.ofType(Range)) | (EvidenceVariable.useContext.value.ofType(Quantity)) | (EvidenceVariable.useContext.value.ofType(Range)) | (ExampleScenario.useContext.value.ofType(Quantity)) | (ExampleScenario.useContext.value.ofType(Range)) | (GraphDefinition.useContext.value.ofType(Quantity)) | (GraphDefinition.useContext.value.ofType(Range)) | (ImplementationGuide.useContext.value.ofType(Quantity)) | (ImplementationGuide.useContext.value.ofType(Range)) | (Library.useContext.value.ofType(Quantity)) | (Library.useContext.value.ofType(Range)) | (Measure.useContext.value.ofType(Quantity)) | (Measure.useContext.value.ofType(Range)) | (MessageDefinition.useContext.value.ofType(Quantity)) | (MessageDefinition.useContext.value.ofType(Range)) | (NamingSystem.useContext.value.ofType(Quantity)) | (NamingSystem.useContext.value.ofType(Range)) | (OperationDefinition.useContext.value.ofType(Quantity)) | (OperationDefinition.useContext.value.ofType(Range)) | (PlanDefinition.useContext.value.ofType(Quantity)) | (PlanDefinition.useContext.value.ofType(Range)) | (Questionnaire.useContext.value.ofType(Quantity)) | (Questionnaire.useContext.value.ofType(Range)) | (Requirements.useContext.value.ofType(Quantity)) | (Requirements.useContext.value.ofType(Range)) | (SearchParameter.useContext.value.ofType(Quantity)) | (SearchParameter.useContext.value.ofType(Range)) | (StructureDefinition.useContext.value.ofType(Quantity)) | (StructureDefinition.useContext.value.ofType(Range)) | (StructureMap.useContext.value.ofType(Quantity)) | (StructureMap.useContext.value.ofType(Range)) | (TerminologyCapabilities.useContext.value.ofType(Quantity)) | (TerminologyCapabilities.useContext.value.ofType(Range)) | (TestScript.useContext.value.ofType(Quantity)) | (TestScript.useContext.value.ofType(Range)) | (ValueSet.useContext.value.ofType(Quantity)) | (ValueSet.useContext.value.ofType(Range))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.QuantityClientParam CONTEXT_QUANTITY = new ca.uhn.fhir.rest.gclient.QuantityClientParam(SP_CONTEXT_QUANTITY);

 /**
   * Search parameter: <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-quantity", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide\r\n* [Library](library.html): A use context type and quantity- or range-based value assigned to the library\r\n* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context-quantity"} )
  public static final String SP_CONTEXT_TYPE_QUANTITY = "context-type-quantity";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-quantity</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and quantity- or range-based value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and quantity- or range-based value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and quantity- or range-based value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and quantity- or range-based value assigned to the charge item definition
* [Citation](citation.html): A use context type and quantity- or range-based value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and quantity- or range-based value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and quantity- or range-based value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and quantity- or range-based value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and quantity- or range-based value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and quantity- or range-based value assigned to the event definition
* [Evidence](evidence.html): A use context type and quantity- or range-based value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and quantity- or range-based value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and quantity- or range-based value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and quantity- or range-based value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and quantity- or range-based value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and quantity- or range-based value assigned to the implementation guide
* [Library](library.html): A use context type and quantity- or range-based value assigned to the library
* [Measure](measure.html): A use context type and quantity- or range-based value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and quantity- or range-based value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and quantity- or range-based value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and quantity- or range-based value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and quantity- or range-based value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and quantity- or range-based value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and quantity- or range-based value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and quantity- or range-based value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and quantity- or range-based value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and quantity- or range-based value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and quantity- or range-based value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and quantity- or range-based value assigned to the test script
* [ValueSet](valueset.html): A use context type and quantity- or range-based value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam> CONTEXT_TYPE_QUANTITY = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.QuantityClientParam>(SP_CONTEXT_TYPE_QUANTITY);

 /**
   * Search parameter: <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type-value", path="ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition\r\n* [Citation](citation.html): A use context type and value assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context type and value assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition\r\n* [Evidence](evidence.html): A use context type and value assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide\r\n* [Library](library.html): A use context type and value assigned to the library\r\n* [Measure](measure.html): A use context type and value assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context type and value assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context type and value assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context type and value assigned to the test script\r\n* [ValueSet](valueset.html): A use context type and value assigned to the value set\r\n", type="composite", compositeOf={"context-type", "context"} )
  public static final String SP_CONTEXT_TYPE_VALUE = "context-type-value";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type-value</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context type and value assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context type and value assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context type and value assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context type and value assigned to the charge item definition
* [Citation](citation.html): A use context type and value assigned to the citation
* [CodeSystem](codesystem.html): A use context type and value assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context type and value assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context type and value assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context type and value assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context type and value assigned to the event definition
* [Evidence](evidence.html): A use context type and value assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context type and value assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context type and value assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context type and value assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context type and value assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context type and value assigned to the implementation guide
* [Library](library.html): A use context type and value assigned to the library
* [Measure](measure.html): A use context type and value assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context type and value assigned to the message definition
* [NamingSystem](namingsystem.html): A use context type and value assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context type and value assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context type and value assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context type and value assigned to the questionnaire
* [Requirements](requirements.html): A use context type and value assigned to the requirements
* [SearchParameter](searchparameter.html): A use context type and value assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context type and value assigned to the structure definition
* [StructureMap](structuremap.html): A use context type and value assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context type and value assigned to the terminology capabilities
* [TestScript](testscript.html): A use context type and value assigned to the test script
* [ValueSet](valueset.html): A use context type and value assigned to the value set
</b><br>
   * Type: <b>composite</b><br>
   * Path: <b>ActivityDefinition.useContext | ActorDefinition.useContext | CapabilityStatement.useContext | ChargeItemDefinition.useContext | Citation.useContext | CodeSystem.useContext | CompartmentDefinition.useContext | ConceptMap.useContext | ConditionDefinition.useContext | EventDefinition.useContext | Evidence.useContext | EvidenceReport.useContext | EvidenceVariable.useContext | ExampleScenario.useContext | GraphDefinition.useContext | ImplementationGuide.useContext | Library.useContext | Measure.useContext | MessageDefinition.useContext | NamingSystem.useContext | OperationDefinition.useContext | PlanDefinition.useContext | Questionnaire.useContext | Requirements.useContext | SearchParameter.useContext | StructureDefinition.useContext | StructureMap.useContext | TerminologyCapabilities.useContext | TestScript.useContext | ValueSet.useContext</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam> CONTEXT_TYPE_VALUE = new ca.uhn.fhir.rest.gclient.CompositeClientParam<ca.uhn.fhir.rest.gclient.TokenClientParam, ca.uhn.fhir.rest.gclient.TokenClientParam>(SP_CONTEXT_TYPE_VALUE);

 /**
   * Search parameter: <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context-type", path="ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition\r\n* [Citation](citation.html): A type of use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A type of use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition\r\n* [Evidence](evidence.html): A type of use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide\r\n* [Library](library.html): A type of use context assigned to the library\r\n* [Measure](measure.html): A type of use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A type of use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A type of use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A type of use context assigned to the test script\r\n* [ValueSet](valueset.html): A type of use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT_TYPE = "context-type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context-type</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A type of use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A type of use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A type of use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A type of use context assigned to the charge item definition
* [Citation](citation.html): A type of use context assigned to the citation
* [CodeSystem](codesystem.html): A type of use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A type of use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A type of use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A type of use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A type of use context assigned to the event definition
* [Evidence](evidence.html): A type of use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A type of use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A type of use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A type of use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A type of use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A type of use context assigned to the implementation guide
* [Library](library.html): A type of use context assigned to the library
* [Measure](measure.html): A type of use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A type of use context assigned to the message definition
* [NamingSystem](namingsystem.html): A type of use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A type of use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A type of use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A type of use context assigned to the questionnaire
* [Requirements](requirements.html): A type of use context assigned to the requirements
* [SearchParameter](searchparameter.html): A type of use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A type of use context assigned to the structure definition
* [StructureMap](structuremap.html): A type of use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A type of use context assigned to the terminology capabilities
* [TestScript](testscript.html): A type of use context assigned to the test script
* [ValueSet](valueset.html): A type of use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.useContext.code | ActorDefinition.useContext.code | CapabilityStatement.useContext.code | ChargeItemDefinition.useContext.code | Citation.useContext.code | CodeSystem.useContext.code | CompartmentDefinition.useContext.code | ConceptMap.useContext.code | ConditionDefinition.useContext.code | EventDefinition.useContext.code | Evidence.useContext.code | EvidenceReport.useContext.code | EvidenceVariable.useContext.code | ExampleScenario.useContext.code | GraphDefinition.useContext.code | ImplementationGuide.useContext.code | Library.useContext.code | Measure.useContext.code | MessageDefinition.useContext.code | NamingSystem.useContext.code | OperationDefinition.useContext.code | PlanDefinition.useContext.code | Questionnaire.useContext.code | Requirements.useContext.code | SearchParameter.useContext.code | StructureDefinition.useContext.code | StructureMap.useContext.code | TerminologyCapabilities.useContext.code | TestScript.useContext.code | ValueSet.useContext.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT_TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT_TYPE);

 /**
   * Search parameter: <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
   * </p>
   */
  @SearchParamDefinition(name="context", path="(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition\r\n* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition\r\n* [Citation](citation.html): A use context assigned to the citation\r\n* [CodeSystem](codesystem.html): A use context assigned to the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition\r\n* [ConceptMap](conceptmap.html): A use context assigned to the concept map\r\n* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition\r\n* [EventDefinition](eventdefinition.html): A use context assigned to the event definition\r\n* [Evidence](evidence.html): A use context assigned to the evidence\r\n* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report\r\n* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable\r\n* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario\r\n* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition\r\n* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide\r\n* [Library](library.html): A use context assigned to the library\r\n* [Measure](measure.html): A use context assigned to the measure\r\n* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition\r\n* [NamingSystem](namingsystem.html): A use context assigned to the naming system\r\n* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition\r\n* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition\r\n* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire\r\n* [Requirements](requirements.html): A use context assigned to the requirements\r\n* [SearchParameter](searchparameter.html): A use context assigned to the search parameter\r\n* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition\r\n* [StructureMap](structuremap.html): A use context assigned to the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities\r\n* [TestScript](testscript.html): A use context assigned to the test script\r\n* [ValueSet](valueset.html): A use context assigned to the value set\r\n", type="token" )
  public static final String SP_CONTEXT = "context";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>context</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): A use context assigned to the activity definition
* [ActorDefinition](actordefinition.html): A use context assigned to the Actor Definition
* [CapabilityStatement](capabilitystatement.html): A use context assigned to the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): A use context assigned to the charge item definition
* [Citation](citation.html): A use context assigned to the citation
* [CodeSystem](codesystem.html): A use context assigned to the code system
* [CompartmentDefinition](compartmentdefinition.html): A use context assigned to the compartment definition
* [ConceptMap](conceptmap.html): A use context assigned to the concept map
* [ConditionDefinition](conditiondefinition.html): A use context assigned to the condition definition
* [EventDefinition](eventdefinition.html): A use context assigned to the event definition
* [Evidence](evidence.html): A use context assigned to the evidence
* [EvidenceReport](evidencereport.html): A use context assigned to the evidence report
* [EvidenceVariable](evidencevariable.html): A use context assigned to the evidence variable
* [ExampleScenario](examplescenario.html): A use context assigned to the example scenario
* [GraphDefinition](graphdefinition.html): A use context assigned to the graph definition
* [ImplementationGuide](implementationguide.html): A use context assigned to the implementation guide
* [Library](library.html): A use context assigned to the library
* [Measure](measure.html): A use context assigned to the measure
* [MessageDefinition](messagedefinition.html): A use context assigned to the message definition
* [NamingSystem](namingsystem.html): A use context assigned to the naming system
* [OperationDefinition](operationdefinition.html): A use context assigned to the operation definition
* [PlanDefinition](plandefinition.html): A use context assigned to the plan definition
* [Questionnaire](questionnaire.html): A use context assigned to the questionnaire
* [Requirements](requirements.html): A use context assigned to the requirements
* [SearchParameter](searchparameter.html): A use context assigned to the search parameter
* [StructureDefinition](structuredefinition.html): A use context assigned to the structure definition
* [StructureMap](structuremap.html): A use context assigned to the structure map
* [TerminologyCapabilities](terminologycapabilities.html): A use context assigned to the terminology capabilities
* [TestScript](testscript.html): A use context assigned to the test script
* [ValueSet](valueset.html): A use context assigned to the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>(ActivityDefinition.useContext.value.ofType(CodeableConcept)) | (ActorDefinition.useContext.value.ofType(CodeableConcept)) | (CapabilityStatement.useContext.value.ofType(CodeableConcept)) | (ChargeItemDefinition.useContext.value.ofType(CodeableConcept)) | (Citation.useContext.value.ofType(CodeableConcept)) | (CodeSystem.useContext.value.ofType(CodeableConcept)) | (CompartmentDefinition.useContext.value.ofType(CodeableConcept)) | (ConceptMap.useContext.value.ofType(CodeableConcept)) | (ConditionDefinition.useContext.value.ofType(CodeableConcept)) | (EventDefinition.useContext.value.ofType(CodeableConcept)) | (Evidence.useContext.value.ofType(CodeableConcept)) | (EvidenceReport.useContext.value.ofType(CodeableConcept)) | (EvidenceVariable.useContext.value.ofType(CodeableConcept)) | (ExampleScenario.useContext.value.ofType(CodeableConcept)) | (GraphDefinition.useContext.value.ofType(CodeableConcept)) | (ImplementationGuide.useContext.value.ofType(CodeableConcept)) | (Library.useContext.value.ofType(CodeableConcept)) | (Measure.useContext.value.ofType(CodeableConcept)) | (MessageDefinition.useContext.value.ofType(CodeableConcept)) | (NamingSystem.useContext.value.ofType(CodeableConcept)) | (OperationDefinition.useContext.value.ofType(CodeableConcept)) | (PlanDefinition.useContext.value.ofType(CodeableConcept)) | (Questionnaire.useContext.value.ofType(CodeableConcept)) | (Requirements.useContext.value.ofType(CodeableConcept)) | (SearchParameter.useContext.value.ofType(CodeableConcept)) | (StructureDefinition.useContext.value.ofType(CodeableConcept)) | (StructureMap.useContext.value.ofType(CodeableConcept)) | (TerminologyCapabilities.useContext.value.ofType(CodeableConcept)) | (TestScript.useContext.value.ofType(CodeableConcept)) | (ValueSet.useContext.value.ofType(CodeableConcept))</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTEXT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTEXT);

 /**
   * Search parameter: <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  @SearchParamDefinition(name="date", path="ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The activity definition publication date\r\n* [ActorDefinition](actordefinition.html): The Actor Definition publication date\r\n* [CapabilityStatement](capabilitystatement.html): The capability statement publication date\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date\r\n* [Citation](citation.html): The citation publication date\r\n* [CodeSystem](codesystem.html): The code system publication date\r\n* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date\r\n* [ConceptMap](conceptmap.html): The concept map publication date\r\n* [ConditionDefinition](conditiondefinition.html): The condition definition publication date\r\n* [EventDefinition](eventdefinition.html): The event definition publication date\r\n* [Evidence](evidence.html): The evidence publication date\r\n* [EvidenceVariable](evidencevariable.html): The evidence variable publication date\r\n* [ExampleScenario](examplescenario.html): The example scenario publication date\r\n* [GraphDefinition](graphdefinition.html): The graph definition publication date\r\n* [ImplementationGuide](implementationguide.html): The implementation guide publication date\r\n* [Library](library.html): The library publication date\r\n* [Measure](measure.html): The measure publication date\r\n* [MessageDefinition](messagedefinition.html): The message definition publication date\r\n* [NamingSystem](namingsystem.html): The naming system publication date\r\n* [OperationDefinition](operationdefinition.html): The operation definition publication date\r\n* [PlanDefinition](plandefinition.html): The plan definition publication date\r\n* [Questionnaire](questionnaire.html): The questionnaire publication date\r\n* [Requirements](requirements.html): The requirements publication date\r\n* [SearchParameter](searchparameter.html): The search parameter publication date\r\n* [StructureDefinition](structuredefinition.html): The structure definition publication date\r\n* [StructureMap](structuremap.html): The structure map publication date\r\n* [SubscriptionTopic](subscriptiontopic.html): Date status first applied\r\n* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date\r\n* [TestScript](testscript.html): The test script publication date\r\n* [ValueSet](valueset.html): The value set publication date\r\n", type="date" )
  public static final String SP_DATE = "date";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>date</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The activity definition publication date
* [ActorDefinition](actordefinition.html): The Actor Definition publication date
* [CapabilityStatement](capabilitystatement.html): The capability statement publication date
* [ChargeItemDefinition](chargeitemdefinition.html): The charge item definition publication date
* [Citation](citation.html): The citation publication date
* [CodeSystem](codesystem.html): The code system publication date
* [CompartmentDefinition](compartmentdefinition.html): The compartment definition publication date
* [ConceptMap](conceptmap.html): The concept map publication date
* [ConditionDefinition](conditiondefinition.html): The condition definition publication date
* [EventDefinition](eventdefinition.html): The event definition publication date
* [Evidence](evidence.html): The evidence publication date
* [EvidenceVariable](evidencevariable.html): The evidence variable publication date
* [ExampleScenario](examplescenario.html): The example scenario publication date
* [GraphDefinition](graphdefinition.html): The graph definition publication date
* [ImplementationGuide](implementationguide.html): The implementation guide publication date
* [Library](library.html): The library publication date
* [Measure](measure.html): The measure publication date
* [MessageDefinition](messagedefinition.html): The message definition publication date
* [NamingSystem](namingsystem.html): The naming system publication date
* [OperationDefinition](operationdefinition.html): The operation definition publication date
* [PlanDefinition](plandefinition.html): The plan definition publication date
* [Questionnaire](questionnaire.html): The questionnaire publication date
* [Requirements](requirements.html): The requirements publication date
* [SearchParameter](searchparameter.html): The search parameter publication date
* [StructureDefinition](structuredefinition.html): The structure definition publication date
* [StructureMap](structuremap.html): The structure map publication date
* [SubscriptionTopic](subscriptiontopic.html): Date status first applied
* [TerminologyCapabilities](terminologycapabilities.html): The terminology capabilities publication date
* [TestScript](testscript.html): The test script publication date
* [ValueSet](valueset.html): The value set publication date
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.date | ActorDefinition.date | CapabilityStatement.date | ChargeItemDefinition.date | Citation.date | CodeSystem.date | CompartmentDefinition.date | ConceptMap.date | ConditionDefinition.date | EventDefinition.date | Evidence.date | EvidenceVariable.date | ExampleScenario.date | GraphDefinition.date | ImplementationGuide.date | Library.date | Measure.date | MessageDefinition.date | NamingSystem.date | OperationDefinition.date | PlanDefinition.date | Questionnaire.date | Requirements.date | SearchParameter.date | StructureDefinition.date | StructureMap.date | SubscriptionTopic.date | TerminologyCapabilities.date | TestScript.date | ValueSet.date</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam DATE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_DATE);

 /**
   * Search parameter: <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  @SearchParamDefinition(name="description", path="ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The description of the activity definition\r\n* [ActorDefinition](actordefinition.html): The description of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The description of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition\r\n* [Citation](citation.html): The description of the citation\r\n* [CodeSystem](codesystem.html): The description of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition\r\n* [ConceptMap](conceptmap.html): The description of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The description of the condition definition\r\n* [EventDefinition](eventdefinition.html): The description of the event definition\r\n* [Evidence](evidence.html): The description of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The description of the evidence variable\r\n* [GraphDefinition](graphdefinition.html): The description of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The description of the implementation guide\r\n* [Library](library.html): The description of the library\r\n* [Measure](measure.html): The description of the measure\r\n* [MessageDefinition](messagedefinition.html): The description of the message definition\r\n* [NamingSystem](namingsystem.html): The description of the naming system\r\n* [OperationDefinition](operationdefinition.html): The description of the operation definition\r\n* [PlanDefinition](plandefinition.html): The description of the plan definition\r\n* [Questionnaire](questionnaire.html): The description of the questionnaire\r\n* [Requirements](requirements.html): The description of the requirements\r\n* [SearchParameter](searchparameter.html): The description of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The description of the structure definition\r\n* [StructureMap](structuremap.html): The description of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities\r\n* [TestScript](testscript.html): The description of the test script\r\n* [ValueSet](valueset.html): The description of the value set\r\n", type="string" )
  public static final String SP_DESCRIPTION = "description";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>description</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The description of the activity definition
* [ActorDefinition](actordefinition.html): The description of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The description of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The description of the charge item definition
* [Citation](citation.html): The description of the citation
* [CodeSystem](codesystem.html): The description of the code system
* [CompartmentDefinition](compartmentdefinition.html): The description of the compartment definition
* [ConceptMap](conceptmap.html): The description of the concept map
* [ConditionDefinition](conditiondefinition.html): The description of the condition definition
* [EventDefinition](eventdefinition.html): The description of the event definition
* [Evidence](evidence.html): The description of the evidence
* [EvidenceVariable](evidencevariable.html): The description of the evidence variable
* [GraphDefinition](graphdefinition.html): The description of the graph definition
* [ImplementationGuide](implementationguide.html): The description of the implementation guide
* [Library](library.html): The description of the library
* [Measure](measure.html): The description of the measure
* [MessageDefinition](messagedefinition.html): The description of the message definition
* [NamingSystem](namingsystem.html): The description of the naming system
* [OperationDefinition](operationdefinition.html): The description of the operation definition
* [PlanDefinition](plandefinition.html): The description of the plan definition
* [Questionnaire](questionnaire.html): The description of the questionnaire
* [Requirements](requirements.html): The description of the requirements
* [SearchParameter](searchparameter.html): The description of the search parameter
* [StructureDefinition](structuredefinition.html): The description of the structure definition
* [StructureMap](structuremap.html): The description of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): The description of the terminology capabilities
* [TestScript](testscript.html): The description of the test script
* [ValueSet](valueset.html): The description of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.description | ActorDefinition.description | CapabilityStatement.description | ChargeItemDefinition.description | Citation.description | CodeSystem.description | CompartmentDefinition.description | ConceptMap.description | ConditionDefinition.description | EventDefinition.description | Evidence.description | EvidenceVariable.description | GraphDefinition.description | ImplementationGuide.description | Library.description | Measure.description | MessageDefinition.description | NamingSystem.description | OperationDefinition.description | PlanDefinition.description | Questionnaire.description | Requirements.description | SearchParameter.description | StructureDefinition.description | StructureMap.description | TerminologyCapabilities.description | TestScript.description | ValueSet.description</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam DESCRIPTION = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_DESCRIPTION);

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
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): External identifier for the activity definition\r\n* [ActorDefinition](actordefinition.html): External identifier for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): External identifier for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): External identifier for the charge item definition\r\n* [Citation](citation.html): External identifier for the citation\r\n* [CodeSystem](codesystem.html): External identifier for the code system\r\n* [ConceptMap](conceptmap.html): External identifier for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): External identifier for the condition definition\r\n* [EventDefinition](eventdefinition.html): External identifier for the event definition\r\n* [Evidence](evidence.html): External identifier for the evidence\r\n* [EvidenceReport](evidencereport.html): External identifier for the evidence report\r\n* [EvidenceVariable](evidencevariable.html): External identifier for the evidence variable\r\n* [ExampleScenario](examplescenario.html): External identifier for the example scenario\r\n* [GraphDefinition](graphdefinition.html): External identifier for the graph definition\r\n* [ImplementationGuide](implementationguide.html): External identifier for the implementation guide\r\n* [Library](library.html): External identifier for the library\r\n* [Measure](measure.html): External identifier for the measure\r\n* [MedicationKnowledge](medicationknowledge.html): Business identifier for this medication\r\n* [MessageDefinition](messagedefinition.html): External identifier for the message definition\r\n* [NamingSystem](namingsystem.html): External identifier for the naming system\r\n* [ObservationDefinition](observationdefinition.html): The unique identifier associated with the specimen definition\r\n* [OperationDefinition](operationdefinition.html): External identifier for the search parameter\r\n* [PlanDefinition](plandefinition.html): External identifier for the plan definition\r\n* [Questionnaire](questionnaire.html): External identifier for the questionnaire\r\n* [Requirements](requirements.html): External identifier for the requirements\r\n* [SearchParameter](searchparameter.html): External identifier for the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The unique identifier associated with the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): External identifier for the structure definition\r\n* [StructureMap](structuremap.html): External identifier for the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business Identifier for SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): External identifier for the terminology capabilities\r\n* [TestPlan](testplan.html): An identifier for the test plan\r\n* [TestScript](testscript.html): External identifier for the test script\r\n* [ValueSet](valueset.html): External identifier for the value set\r\n", type="token" )
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
* [TestPlan](testplan.html): An identifier for the test plan
* [TestScript](testscript.html): External identifier for the test script
* [ValueSet](valueset.html): External identifier for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.identifier | ActorDefinition.identifier | CapabilityStatement.identifier | ChargeItemDefinition.identifier | Citation.identifier | CodeSystem.identifier | ConceptMap.identifier | ConditionDefinition.identifier | EventDefinition.identifier | Evidence.identifier | EvidenceReport.identifier | EvidenceVariable.identifier | ExampleScenario.identifier | GraphDefinition.identifier | ImplementationGuide.identifier | Library.identifier | Measure.identifier | MedicationKnowledge.identifier | MessageDefinition.identifier | NamingSystem.identifier | ObservationDefinition.identifier | OperationDefinition.identifier | PlanDefinition.identifier | Questionnaire.identifier | Requirements.identifier | SearchParameter.identifier | SpecimenDefinition.identifier | StructureDefinition.identifier | StructureMap.identifier | SubscriptionTopic.identifier | TerminologyCapabilities.identifier | TestPlan.identifier | TestScript.identifier | ValueSet.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  @SearchParamDefinition(name="jurisdiction", path="ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition\r\n* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition\r\n* [Citation](citation.html): Intended jurisdiction for the citation\r\n* [CodeSystem](codesystem.html): Intended jurisdiction for the code system\r\n* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition\r\n* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition\r\n* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario\r\n* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition\r\n* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide\r\n* [Library](library.html): Intended jurisdiction for the library\r\n* [Measure](measure.html): Intended jurisdiction for the measure\r\n* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition\r\n* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system\r\n* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition\r\n* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition\r\n* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire\r\n* [Requirements](requirements.html): Intended jurisdiction for the requirements\r\n* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter\r\n* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition\r\n* [StructureMap](structuremap.html): Intended jurisdiction for the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities\r\n* [TestScript](testscript.html): Intended jurisdiction for the test script\r\n* [ValueSet](valueset.html): Intended jurisdiction for the value set\r\n", type="token" )
  public static final String SP_JURISDICTION = "jurisdiction";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>jurisdiction</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Intended jurisdiction for the activity definition
* [ActorDefinition](actordefinition.html): Intended jurisdiction for the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Intended jurisdiction for the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Intended jurisdiction for the charge item definition
* [Citation](citation.html): Intended jurisdiction for the citation
* [CodeSystem](codesystem.html): Intended jurisdiction for the code system
* [ConceptMap](conceptmap.html): Intended jurisdiction for the concept map
* [ConditionDefinition](conditiondefinition.html): Intended jurisdiction for the condition definition
* [EventDefinition](eventdefinition.html): Intended jurisdiction for the event definition
* [ExampleScenario](examplescenario.html): Intended jurisdiction for the example scenario
* [GraphDefinition](graphdefinition.html): Intended jurisdiction for the graph definition
* [ImplementationGuide](implementationguide.html): Intended jurisdiction for the implementation guide
* [Library](library.html): Intended jurisdiction for the library
* [Measure](measure.html): Intended jurisdiction for the measure
* [MessageDefinition](messagedefinition.html): Intended jurisdiction for the message definition
* [NamingSystem](namingsystem.html): Intended jurisdiction for the naming system
* [OperationDefinition](operationdefinition.html): Intended jurisdiction for the operation definition
* [PlanDefinition](plandefinition.html): Intended jurisdiction for the plan definition
* [Questionnaire](questionnaire.html): Intended jurisdiction for the questionnaire
* [Requirements](requirements.html): Intended jurisdiction for the requirements
* [SearchParameter](searchparameter.html): Intended jurisdiction for the search parameter
* [StructureDefinition](structuredefinition.html): Intended jurisdiction for the structure definition
* [StructureMap](structuremap.html): Intended jurisdiction for the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Intended jurisdiction for the terminology capabilities
* [TestScript](testscript.html): Intended jurisdiction for the test script
* [ValueSet](valueset.html): Intended jurisdiction for the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.jurisdiction | ActorDefinition.jurisdiction | CapabilityStatement.jurisdiction | ChargeItemDefinition.jurisdiction | Citation.jurisdiction | CodeSystem.jurisdiction | ConceptMap.jurisdiction | ConditionDefinition.jurisdiction | EventDefinition.jurisdiction | ExampleScenario.jurisdiction | GraphDefinition.jurisdiction | ImplementationGuide.jurisdiction | Library.jurisdiction | Measure.jurisdiction | MessageDefinition.jurisdiction | NamingSystem.jurisdiction | OperationDefinition.jurisdiction | PlanDefinition.jurisdiction | Questionnaire.jurisdiction | Requirements.jurisdiction | SearchParameter.jurisdiction | StructureDefinition.jurisdiction | StructureMap.jurisdiction | TerminologyCapabilities.jurisdiction | TestScript.jurisdiction | ValueSet.jurisdiction</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam JURISDICTION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_JURISDICTION);

 /**
   * Search parameter: <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  @SearchParamDefinition(name="name", path="ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition\r\n* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement\r\n* [Citation](citation.html): Computationally friendly name of the citation\r\n* [CodeSystem](codesystem.html): Computationally friendly name of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition\r\n* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition\r\n* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide\r\n* [Library](library.html): Computationally friendly name of the library\r\n* [Measure](measure.html): Computationally friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition\r\n* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system\r\n* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire\r\n* [Requirements](requirements.html): Computationally friendly name of the requirements\r\n* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition\r\n* [StructureMap](structuremap.html): Computationally friendly name of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): Computationally friendly name of the test script\r\n* [ValueSet](valueset.html): Computationally friendly name of the value set\r\n", type="string" )
  public static final String SP_NAME = "name";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>name</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Computationally friendly name of the activity definition
* [CapabilityStatement](capabilitystatement.html): Computationally friendly name of the capability statement
* [Citation](citation.html): Computationally friendly name of the citation
* [CodeSystem](codesystem.html): Computationally friendly name of the code system
* [CompartmentDefinition](compartmentdefinition.html): Computationally friendly name of the compartment definition
* [ConceptMap](conceptmap.html): Computationally friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): Computationally friendly name of the condition definition
* [EventDefinition](eventdefinition.html): Computationally friendly name of the event definition
* [EvidenceVariable](evidencevariable.html): Computationally friendly name of the evidence variable
* [ExampleScenario](examplescenario.html): Computationally friendly name of the example scenario
* [GraphDefinition](graphdefinition.html): Computationally friendly name of the graph definition
* [ImplementationGuide](implementationguide.html): Computationally friendly name of the implementation guide
* [Library](library.html): Computationally friendly name of the library
* [Measure](measure.html): Computationally friendly name of the measure
* [MessageDefinition](messagedefinition.html): Computationally friendly name of the message definition
* [NamingSystem](namingsystem.html): Computationally friendly name of the naming system
* [OperationDefinition](operationdefinition.html): Computationally friendly name of the operation definition
* [PlanDefinition](plandefinition.html): Computationally friendly name of the plan definition
* [Questionnaire](questionnaire.html): Computationally friendly name of the questionnaire
* [Requirements](requirements.html): Computationally friendly name of the requirements
* [SearchParameter](searchparameter.html): Computationally friendly name of the search parameter
* [StructureDefinition](structuredefinition.html): Computationally friendly name of the structure definition
* [StructureMap](structuremap.html): Computationally friendly name of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Computationally friendly name of the terminology capabilities
* [TestScript](testscript.html): Computationally friendly name of the test script
* [ValueSet](valueset.html): Computationally friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.name | CapabilityStatement.name | Citation.name | CodeSystem.name | CompartmentDefinition.name | ConceptMap.name | ConditionDefinition.name | EventDefinition.name | EvidenceVariable.name | ExampleScenario.name | GraphDefinition.name | ImplementationGuide.name | Library.name | Measure.name | MessageDefinition.name | NamingSystem.name | OperationDefinition.name | PlanDefinition.name | Questionnaire.name | Requirements.name | SearchParameter.name | StructureDefinition.name | StructureMap.name | TerminologyCapabilities.name | TestScript.name | ValueSet.name</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam NAME = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_NAME);

 /**
   * Search parameter: <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  @SearchParamDefinition(name="publisher", path="ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition\r\n* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition\r\n* [Citation](citation.html): Name of the publisher of the citation\r\n* [CodeSystem](codesystem.html): Name of the publisher of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition\r\n* [ConceptMap](conceptmap.html): Name of the publisher of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition\r\n* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition\r\n* [Evidence](evidence.html): Name of the publisher of the evidence\r\n* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable\r\n* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario\r\n* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition\r\n* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide\r\n* [Library](library.html): Name of the publisher of the library\r\n* [Measure](measure.html): Name of the publisher of the measure\r\n* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition\r\n* [NamingSystem](namingsystem.html): Name of the publisher of the naming system\r\n* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition\r\n* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition\r\n* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire\r\n* [Requirements](requirements.html): Name of the publisher of the requirements\r\n* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter\r\n* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition\r\n* [StructureMap](structuremap.html): Name of the publisher of the structure map\r\n* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities\r\n* [TestScript](testscript.html): Name of the publisher of the test script\r\n* [ValueSet](valueset.html): Name of the publisher of the value set\r\n", type="string" )
  public static final String SP_PUBLISHER = "publisher";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>publisher</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Name of the publisher of the activity definition
* [ActorDefinition](actordefinition.html): Name of the publisher of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): Name of the publisher of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): Name of the publisher of the charge item definition
* [Citation](citation.html): Name of the publisher of the citation
* [CodeSystem](codesystem.html): Name of the publisher of the code system
* [CompartmentDefinition](compartmentdefinition.html): Name of the publisher of the compartment definition
* [ConceptMap](conceptmap.html): Name of the publisher of the concept map
* [ConditionDefinition](conditiondefinition.html): Name of the publisher of the condition definition
* [EventDefinition](eventdefinition.html): Name of the publisher of the event definition
* [Evidence](evidence.html): Name of the publisher of the evidence
* [EvidenceReport](evidencereport.html): Name of the publisher of the evidence report
* [EvidenceVariable](evidencevariable.html): Name of the publisher of the evidence variable
* [ExampleScenario](examplescenario.html): Name of the publisher of the example scenario
* [GraphDefinition](graphdefinition.html): Name of the publisher of the graph definition
* [ImplementationGuide](implementationguide.html): Name of the publisher of the implementation guide
* [Library](library.html): Name of the publisher of the library
* [Measure](measure.html): Name of the publisher of the measure
* [MessageDefinition](messagedefinition.html): Name of the publisher of the message definition
* [NamingSystem](namingsystem.html): Name of the publisher of the naming system
* [OperationDefinition](operationdefinition.html): Name of the publisher of the operation definition
* [PlanDefinition](plandefinition.html): Name of the publisher of the plan definition
* [Questionnaire](questionnaire.html): Name of the publisher of the questionnaire
* [Requirements](requirements.html): Name of the publisher of the requirements
* [SearchParameter](searchparameter.html): Name of the publisher of the search parameter
* [StructureDefinition](structuredefinition.html): Name of the publisher of the structure definition
* [StructureMap](structuremap.html): Name of the publisher of the structure map
* [TerminologyCapabilities](terminologycapabilities.html): Name of the publisher of the terminology capabilities
* [TestScript](testscript.html): Name of the publisher of the test script
* [ValueSet](valueset.html): Name of the publisher of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.publisher | ActorDefinition.publisher | CapabilityStatement.publisher | ChargeItemDefinition.publisher | Citation.publisher | CodeSystem.publisher | CompartmentDefinition.publisher | ConceptMap.publisher | ConditionDefinition.publisher | EventDefinition.publisher | Evidence.publisher | EvidenceReport.publisher | EvidenceVariable.publisher | ExampleScenario.publisher | GraphDefinition.publisher | ImplementationGuide.publisher | Library.publisher | Measure.publisher | MessageDefinition.publisher | NamingSystem.publisher | OperationDefinition.publisher | PlanDefinition.publisher | Questionnaire.publisher | Requirements.publisher | SearchParameter.publisher | StructureDefinition.publisher | StructureMap.publisher | TerminologyCapabilities.publisher | TestScript.publisher | ValueSet.publisher</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam PUBLISHER = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_PUBLISHER);

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
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The current status of the activity definition\r\n* [ActorDefinition](actordefinition.html): The current status of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The current status of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The current status of the charge item definition\r\n* [Citation](citation.html): The current status of the citation\r\n* [CodeSystem](codesystem.html): The current status of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The current status of the compartment definition\r\n* [ConceptMap](conceptmap.html): The current status of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The current status of the condition definition\r\n* [EventDefinition](eventdefinition.html): The current status of the event definition\r\n* [Evidence](evidence.html): The current status of the evidence\r\n* [EvidenceReport](evidencereport.html): The current status of the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The current status of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The current status of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The current status of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The current status of the implementation guide\r\n* [Library](library.html): The current status of the library\r\n* [Measure](measure.html): The current status of the measure\r\n* [MedicationKnowledge](medicationknowledge.html): active | inactive | entered-in-error\r\n* [MessageDefinition](messagedefinition.html): The current status of the message definition\r\n* [NamingSystem](namingsystem.html): The current status of the naming system\r\n* [ObservationDefinition](observationdefinition.html): Publication status of the ObservationDefinition: draft, active, retired, unknown\r\n* [OperationDefinition](operationdefinition.html): The current status of the operation definition\r\n* [PlanDefinition](plandefinition.html): The current status of the plan definition\r\n* [Questionnaire](questionnaire.html): The current status of the questionnaire\r\n* [Requirements](requirements.html): The current status of the requirements\r\n* [SearchParameter](searchparameter.html): The current status of the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): Publication status of the SpecimenDefinition: draft, active, retired, unknown\r\n* [StructureDefinition](structuredefinition.html): The current status of the structure definition\r\n* [StructureMap](structuremap.html): The current status of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): draft | active | retired | unknown\r\n* [TerminologyCapabilities](terminologycapabilities.html): The current status of the terminology capabilities\r\n* [TestPlan](testplan.html): The current status of the test plan\r\n* [TestScript](testscript.html): The current status of the test script\r\n* [ValueSet](valueset.html): The current status of the value set\r\n", type="token" )
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
* [TestPlan](testplan.html): The current status of the test plan
* [TestScript](testscript.html): The current status of the test script
* [ValueSet](valueset.html): The current status of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.status | ActorDefinition.status | CapabilityStatement.status | ChargeItemDefinition.status | Citation.status | CodeSystem.status | CompartmentDefinition.status | ConceptMap.status | ConditionDefinition.status | EventDefinition.status | Evidence.status | EvidenceReport.status | EvidenceVariable.status | ExampleScenario.status | GraphDefinition.status | ImplementationGuide.status | Library.status | Measure.status | MedicationKnowledge.status | MessageDefinition.status | NamingSystem.status | ObservationDefinition.status | OperationDefinition.status | PlanDefinition.status | Questionnaire.status | Requirements.status | SearchParameter.status | SpecimenDefinition.status | StructureDefinition.status | StructureMap.status | SubscriptionTopic.status | TerminologyCapabilities.status | TestPlan.status | TestScript.status | ValueSet.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition\r\n* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition\r\n* [Citation](citation.html): The human-friendly name of the citation\r\n* [CodeSystem](codesystem.html): The human-friendly name of the code system\r\n* [ConceptMap](conceptmap.html): The human-friendly name of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition\r\n* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition\r\n* [Evidence](evidence.html): The human-friendly name of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable\r\n* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide\r\n* [Library](library.html): The human-friendly name of the library\r\n* [Measure](measure.html): The human-friendly name of the measure\r\n* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition\r\n* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition\r\n* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition\r\n* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition\r\n* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire\r\n* [Requirements](requirements.html): The human-friendly name of the requirements\r\n* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition\r\n* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition\r\n* [StructureMap](structuremap.html): The human-friendly name of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities\r\n* [TestScript](testscript.html): The human-friendly name of the test script\r\n* [ValueSet](valueset.html): The human-friendly name of the value set\r\n", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The human-friendly name of the activity definition
* [ActorDefinition](actordefinition.html): The human-friendly name of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The human-friendly name of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The human-friendly name of the charge item definition
* [Citation](citation.html): The human-friendly name of the citation
* [CodeSystem](codesystem.html): The human-friendly name of the code system
* [ConceptMap](conceptmap.html): The human-friendly name of the concept map
* [ConditionDefinition](conditiondefinition.html): The human-friendly name of the condition definition
* [EventDefinition](eventdefinition.html): The human-friendly name of the event definition
* [Evidence](evidence.html): The human-friendly name of the evidence
* [EvidenceVariable](evidencevariable.html): The human-friendly name of the evidence variable
* [ImplementationGuide](implementationguide.html): The human-friendly name of the implementation guide
* [Library](library.html): The human-friendly name of the library
* [Measure](measure.html): The human-friendly name of the measure
* [MessageDefinition](messagedefinition.html): The human-friendly name of the message definition
* [ObservationDefinition](observationdefinition.html): Human-friendly name of the ObservationDefinition
* [OperationDefinition](operationdefinition.html): The human-friendly name of the operation definition
* [PlanDefinition](plandefinition.html): The human-friendly name of the plan definition
* [Questionnaire](questionnaire.html): The human-friendly name of the questionnaire
* [Requirements](requirements.html): The human-friendly name of the requirements
* [SpecimenDefinition](specimendefinition.html): Human-friendly name of the SpecimenDefinition
* [StructureDefinition](structuredefinition.html): The human-friendly name of the structure definition
* [StructureMap](structuremap.html): The human-friendly name of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Name for this SubscriptionTopic (Human friendly)
* [TerminologyCapabilities](terminologycapabilities.html): The human-friendly name of the terminology capabilities
* [TestScript](testscript.html): The human-friendly name of the test script
* [ValueSet](valueset.html): The human-friendly name of the value set
</b><br>
   * Type: <b>string</b><br>
   * Path: <b>ActivityDefinition.title | ActorDefinition.title | CapabilityStatement.title | ChargeItemDefinition.title | Citation.title | CodeSystem.title | ConceptMap.title | ConditionDefinition.title | EventDefinition.title | Evidence.title | EvidenceVariable.title | ImplementationGuide.title | Library.title | Measure.title | MessageDefinition.title | ObservationDefinition.title | OperationDefinition.title | PlanDefinition.title | Questionnaire.title | Requirements.title | SpecimenDefinition.title | StructureDefinition.title | StructureMap.title | SubscriptionTopic.title | TerminologyCapabilities.title | TestScript.title | ValueSet.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition\r\n* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition\r\n* [Citation](citation.html): The uri that identifies the citation\r\n* [CodeSystem](codesystem.html): The uri that identifies the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition\r\n* [ConceptMap](conceptmap.html): The URI that identifies the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition\r\n* [EventDefinition](eventdefinition.html): The uri that identifies the event definition\r\n* [Evidence](evidence.html): The uri that identifies the evidence\r\n* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report\r\n* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable\r\n* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario\r\n* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition\r\n* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide\r\n* [Library](library.html): The uri that identifies the library\r\n* [Measure](measure.html): The uri that identifies the measure\r\n* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition\r\n* [NamingSystem](namingsystem.html): The uri that identifies the naming system\r\n* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition\r\n* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition\r\n* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition\r\n* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire\r\n* [Requirements](requirements.html): The uri that identifies the requirements\r\n* [SearchParameter](searchparameter.html): The uri that identifies the search parameter\r\n* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition\r\n* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition\r\n* [StructureMap](structuremap.html): The uri that identifies the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)\r\n* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities\r\n* [TestPlan](testplan.html): The uri that identifies the test plan\r\n* [TestScript](testscript.html): The uri that identifies the test script\r\n* [ValueSet](valueset.html): The uri that identifies the value set\r\n", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The uri that identifies the activity definition
* [ActorDefinition](actordefinition.html): The uri that identifies the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The uri that identifies the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The uri that identifies the charge item definition
* [Citation](citation.html): The uri that identifies the citation
* [CodeSystem](codesystem.html): The uri that identifies the code system
* [CompartmentDefinition](compartmentdefinition.html): The uri that identifies the compartment definition
* [ConceptMap](conceptmap.html): The URI that identifies the concept map
* [ConditionDefinition](conditiondefinition.html): The uri that identifies the condition definition
* [EventDefinition](eventdefinition.html): The uri that identifies the event definition
* [Evidence](evidence.html): The uri that identifies the evidence
* [EvidenceReport](evidencereport.html): The uri that identifies the evidence report
* [EvidenceVariable](evidencevariable.html): The uri that identifies the evidence variable
* [ExampleScenario](examplescenario.html): The uri that identifies the example scenario
* [GraphDefinition](graphdefinition.html): The uri that identifies the graph definition
* [ImplementationGuide](implementationguide.html): The uri that identifies the implementation guide
* [Library](library.html): The uri that identifies the library
* [Measure](measure.html): The uri that identifies the measure
* [MessageDefinition](messagedefinition.html): The uri that identifies the message definition
* [NamingSystem](namingsystem.html): The uri that identifies the naming system
* [ObservationDefinition](observationdefinition.html): The uri that identifies the observation definition
* [OperationDefinition](operationdefinition.html): The uri that identifies the operation definition
* [PlanDefinition](plandefinition.html): The uri that identifies the plan definition
* [Questionnaire](questionnaire.html): The uri that identifies the questionnaire
* [Requirements](requirements.html): The uri that identifies the requirements
* [SearchParameter](searchparameter.html): The uri that identifies the search parameter
* [SpecimenDefinition](specimendefinition.html): The uri that identifies the specimen definition
* [StructureDefinition](structuredefinition.html): The uri that identifies the structure definition
* [StructureMap](structuremap.html): The uri that identifies the structure map
* [SubscriptionTopic](subscriptiontopic.html): Logical canonical URL to reference this SubscriptionTopic (globally unique)
* [TerminologyCapabilities](terminologycapabilities.html): The uri that identifies the terminology capabilities
* [TestPlan](testplan.html): The uri that identifies the test plan
* [TestScript](testscript.html): The uri that identifies the test script
* [ValueSet](valueset.html): The uri that identifies the value set
</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>ActivityDefinition.url | ActorDefinition.url | CapabilityStatement.url | ChargeItemDefinition.url | Citation.url | CodeSystem.url | CompartmentDefinition.url | ConceptMap.url | ConditionDefinition.url | EventDefinition.url | Evidence.url | EvidenceReport.url | EvidenceVariable.url | ExampleScenario.url | GraphDefinition.url | ImplementationGuide.url | Library.url | Measure.url | MessageDefinition.url | NamingSystem.url | ObservationDefinition.url | OperationDefinition.url | PlanDefinition.url | Questionnaire.url | Requirements.url | SearchParameter.url | SpecimenDefinition.url | StructureDefinition.url | StructureMap.url | SubscriptionTopic.url | TerminologyCapabilities.url | TestPlan.url | TestScript.url | ValueSet.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);

 /**
   * Search parameter: <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  @SearchParamDefinition(name="version", path="ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The business version of the activity definition\r\n* [ActorDefinition](actordefinition.html): The business version of the Actor Definition\r\n* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition\r\n* [Citation](citation.html): The business version of the citation\r\n* [CodeSystem](codesystem.html): The business version of the code system\r\n* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition\r\n* [ConceptMap](conceptmap.html): The business version of the concept map\r\n* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition\r\n* [EventDefinition](eventdefinition.html): The business version of the event definition\r\n* [Evidence](evidence.html): The business version of the evidence\r\n* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable\r\n* [ExampleScenario](examplescenario.html): The business version of the example scenario\r\n* [GraphDefinition](graphdefinition.html): The business version of the graph definition\r\n* [ImplementationGuide](implementationguide.html): The business version of the implementation guide\r\n* [Library](library.html): The business version of the library\r\n* [Measure](measure.html): The business version of the measure\r\n* [MessageDefinition](messagedefinition.html): The business version of the message definition\r\n* [NamingSystem](namingsystem.html): The business version of the naming system\r\n* [OperationDefinition](operationdefinition.html): The business version of the operation definition\r\n* [PlanDefinition](plandefinition.html): The business version of the plan definition\r\n* [Questionnaire](questionnaire.html): The business version of the questionnaire\r\n* [Requirements](requirements.html): The business version of the requirements\r\n* [SearchParameter](searchparameter.html): The business version of the search parameter\r\n* [StructureDefinition](structuredefinition.html): The business version of the structure definition\r\n* [StructureMap](structuremap.html): The business version of the structure map\r\n* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic\r\n* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities\r\n* [TestScript](testscript.html): The business version of the test script\r\n* [ValueSet](valueset.html): The business version of the value set\r\n", type="token" )
  public static final String SP_VERSION = "version";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>version</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The business version of the activity definition
* [ActorDefinition](actordefinition.html): The business version of the Actor Definition
* [CapabilityStatement](capabilitystatement.html): The business version of the capability statement
* [ChargeItemDefinition](chargeitemdefinition.html): The business version of the charge item definition
* [Citation](citation.html): The business version of the citation
* [CodeSystem](codesystem.html): The business version of the code system
* [CompartmentDefinition](compartmentdefinition.html): The business version of the compartment definition
* [ConceptMap](conceptmap.html): The business version of the concept map
* [ConditionDefinition](conditiondefinition.html): The business version of the condition definition
* [EventDefinition](eventdefinition.html): The business version of the event definition
* [Evidence](evidence.html): The business version of the evidence
* [EvidenceVariable](evidencevariable.html): The business version of the evidence variable
* [ExampleScenario](examplescenario.html): The business version of the example scenario
* [GraphDefinition](graphdefinition.html): The business version of the graph definition
* [ImplementationGuide](implementationguide.html): The business version of the implementation guide
* [Library](library.html): The business version of the library
* [Measure](measure.html): The business version of the measure
* [MessageDefinition](messagedefinition.html): The business version of the message definition
* [NamingSystem](namingsystem.html): The business version of the naming system
* [OperationDefinition](operationdefinition.html): The business version of the operation definition
* [PlanDefinition](plandefinition.html): The business version of the plan definition
* [Questionnaire](questionnaire.html): The business version of the questionnaire
* [Requirements](requirements.html): The business version of the requirements
* [SearchParameter](searchparameter.html): The business version of the search parameter
* [StructureDefinition](structuredefinition.html): The business version of the structure definition
* [StructureMap](structuremap.html): The business version of the structure map
* [SubscriptionTopic](subscriptiontopic.html): Business version of the SubscriptionTopic
* [TerminologyCapabilities](terminologycapabilities.html): The business version of the terminology capabilities
* [TestScript](testscript.html): The business version of the test script
* [ValueSet](valueset.html): The business version of the value set
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.version | ActorDefinition.version | CapabilityStatement.version | ChargeItemDefinition.version | Citation.version | CodeSystem.version | CompartmentDefinition.version | ConceptMap.version | ConditionDefinition.version | EventDefinition.version | Evidence.version | EvidenceVariable.version | ExampleScenario.version | GraphDefinition.version | ImplementationGuide.version | Library.version | Measure.version | MessageDefinition.version | NamingSystem.version | OperationDefinition.version | PlanDefinition.version | Questionnaire.version | Requirements.version | SearchParameter.version | StructureDefinition.version | StructureMap.version | SubscriptionTopic.version | TerminologyCapabilities.version | TestScript.version | ValueSet.version</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam VERSION = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_VERSION);


}

