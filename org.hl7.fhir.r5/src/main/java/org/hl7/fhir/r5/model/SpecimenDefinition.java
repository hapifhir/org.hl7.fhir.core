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
 * A kind of specimen with associated set of requirements.
 */
@ResourceDef(name="SpecimenDefinition", profile="http://hl7.org/fhir/StructureDefinition/SpecimenDefinition")
public class SpecimenDefinition extends DomainResource {

    public enum SpecimenContainedPreference {
        /**
         * This type of contained specimen is preferred to collect this kind of specimen.
         */
        PREFERRED, 
        /**
         * This type of conditioned specimen is an alternate.
         */
        ALTERNATE, 
        /**
         * added to help the parsers with the generic types
         */
        NULL;
        public static SpecimenContainedPreference fromCode(String codeString) throws FHIRException {
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preferred".equals(codeString))
          return PREFERRED;
        if ("alternate".equals(codeString))
          return ALTERNATE;
        if (Configuration.isAcceptInvalidEnums())
          return null;
        else
          throw new FHIRException("Unknown SpecimenContainedPreference code '"+codeString+"'");
        }
        public String toCode() {
          switch (this) {
            case PREFERRED: return "preferred";
            case ALTERNATE: return "alternate";
            default: return "?";
          }
        }
        public String getSystem() {
          switch (this) {
            case PREFERRED: return "http://hl7.org/fhir/specimen-contained-preference";
            case ALTERNATE: return "http://hl7.org/fhir/specimen-contained-preference";
            default: return "?";
          }
        }
        public String getDefinition() {
          switch (this) {
            case PREFERRED: return "This type of contained specimen is preferred to collect this kind of specimen.";
            case ALTERNATE: return "This type of conditioned specimen is an alternate.";
            default: return "?";
          }
        }
        public String getDisplay() {
          switch (this) {
            case PREFERRED: return "Preferred";
            case ALTERNATE: return "Alternate";
            default: return "?";
          }
        }
    }

  public static class SpecimenContainedPreferenceEnumFactory implements EnumFactory<SpecimenContainedPreference> {
    public SpecimenContainedPreference fromCode(String codeString) throws IllegalArgumentException {
      if (codeString == null || "".equals(codeString))
            if (codeString == null || "".equals(codeString))
                return null;
        if ("preferred".equals(codeString))
          return SpecimenContainedPreference.PREFERRED;
        if ("alternate".equals(codeString))
          return SpecimenContainedPreference.ALTERNATE;
        throw new IllegalArgumentException("Unknown SpecimenContainedPreference code '"+codeString+"'");
        }
        public Enumeration<SpecimenContainedPreference> fromType(Base code) throws FHIRException {
          if (code == null)
            return null;
          if (code.isEmpty())
            return new Enumeration<SpecimenContainedPreference>(this);
          String codeString = ((PrimitiveType) code).asStringValue();
          if (codeString == null || "".equals(codeString))
            return null;
        if ("preferred".equals(codeString))
          return new Enumeration<SpecimenContainedPreference>(this, SpecimenContainedPreference.PREFERRED);
        if ("alternate".equals(codeString))
          return new Enumeration<SpecimenContainedPreference>(this, SpecimenContainedPreference.ALTERNATE);
        throw new FHIRException("Unknown SpecimenContainedPreference code '"+codeString+"'");
        }
    public String toCode(SpecimenContainedPreference code) {
      if (code == SpecimenContainedPreference.PREFERRED)
        return "preferred";
      if (code == SpecimenContainedPreference.ALTERNATE)
        return "alternate";
      return "?";
      }
    public String toSystem(SpecimenContainedPreference code) {
      return code.getSystem();
      }
    }

    @Block()
    public static class SpecimenDefinitionTypeTestedComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Primary of secondary specimen.
         */
        @Child(name = "isDerived", type = {BooleanType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Primary or secondary specimen", formalDefinition="Primary of secondary specimen." )
        protected BooleanType isDerived;

        /**
         * The kind of specimen conditioned for testing expected by lab.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of intended specimen", formalDefinition="The kind of specimen conditioned for testing expected by lab." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0487")
        protected CodeableConcept type;

        /**
         * The preference for this type of conditioned specimen.
         */
        @Child(name = "preference", type = {CodeType.class}, order=3, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="preferred | alternate", formalDefinition="The preference for this type of conditioned specimen." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/specimen-contained-preference")
        protected Enumeration<SpecimenContainedPreference> preference;

        /**
         * The specimen's container.
         */
        @Child(name = "container", type = {}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The specimen's container", formalDefinition="The specimen's container." )
        protected SpecimenDefinitionTypeTestedContainerComponent container;

        /**
         * Requirements for delivery and special handling of this kind of conditioned specimen.
         */
        @Child(name = "requirement", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Requirements for specimen delivery and special handling", formalDefinition="Requirements for delivery and special handling of this kind of conditioned specimen." )
        protected StringType requirement;

        /**
         * The usual time that a specimen of this kind is retained after the ordered tests are completed, for the purpose of additional testing.
         */
        @Child(name = "retentionTime", type = {Duration.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The usual time for retaining this kind of specimen", formalDefinition="The usual time that a specimen of this kind is retained after the ordered tests are completed, for the purpose of additional testing." )
        protected Duration retentionTime;

        /**
         * Specimen can be used by only one test or panel if the value is "true".
         */
        @Child(name = "singleUse", type = {BooleanType.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Specimen for single use only", formalDefinition="Specimen can be used by only one test or panel if the value is \"true\"." )
        protected BooleanType singleUse;

        /**
         * Criterion for rejection of the specimen in its container by the laboratory.
         */
        @Child(name = "rejectionCriterion", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Criterion specified for specimen rejection", formalDefinition="Criterion for rejection of the specimen in its container by the laboratory." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/rejection-criteria")
        protected List<CodeableConcept> rejectionCriterion;

        /**
         * Set of instructions for preservation/transport of the specimen at a defined temperature interval, prior the testing process.
         */
        @Child(name = "handling", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Specimen handling before testing", formalDefinition="Set of instructions for preservation/transport of the specimen at a defined temperature interval, prior the testing process." )
        protected List<SpecimenDefinitionTypeTestedHandlingComponent> handling;

        /**
         * Where the specimen will be tested: e.g., lab, sector, device or any combination of these.
         */
        @Child(name = "testingDestination", type = {CodeableConcept.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Where the specimen will be tested", formalDefinition="Where the specimen will be tested: e.g., lab, sector, device or any combination of these." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/diagnostic-service-sections")
        protected List<CodeableConcept> testingDestination;

        private static final long serialVersionUID = 1859673754L;

    /**
     * Constructor
     */
      public SpecimenDefinitionTypeTestedComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SpecimenDefinitionTypeTestedComponent(SpecimenContainedPreference preference) {
        super();
        this.setPreference(preference);
      }

        /**
         * @return {@link #isDerived} (Primary of secondary specimen.). This is the underlying object with id, value and extensions. The accessor "getIsDerived" gives direct access to the value
         */
        public BooleanType getIsDerivedElement() { 
          if (this.isDerived == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedComponent.isDerived");
            else if (Configuration.doAutoCreate())
              this.isDerived = new BooleanType(); // bb
          return this.isDerived;
        }

        public boolean hasIsDerivedElement() { 
          return this.isDerived != null && !this.isDerived.isEmpty();
        }

        public boolean hasIsDerived() { 
          return this.isDerived != null && !this.isDerived.isEmpty();
        }

        /**
         * @param value {@link #isDerived} (Primary of secondary specimen.). This is the underlying object with id, value and extensions. The accessor "getIsDerived" gives direct access to the value
         */
        public SpecimenDefinitionTypeTestedComponent setIsDerivedElement(BooleanType value) { 
          this.isDerived = value;
          return this;
        }

        /**
         * @return Primary of secondary specimen.
         */
        public boolean getIsDerived() { 
          return this.isDerived == null || this.isDerived.isEmpty() ? false : this.isDerived.getValue();
        }

        /**
         * @param value Primary of secondary specimen.
         */
        public SpecimenDefinitionTypeTestedComponent setIsDerived(boolean value) { 
            if (this.isDerived == null)
              this.isDerived = new BooleanType();
            this.isDerived.setValue(value);
          return this;
        }

        /**
         * @return {@link #type} (The kind of specimen conditioned for testing expected by lab.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The kind of specimen conditioned for testing expected by lab.)
         */
        public SpecimenDefinitionTypeTestedComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #preference} (The preference for this type of conditioned specimen.). This is the underlying object with id, value and extensions. The accessor "getPreference" gives direct access to the value
         */
        public Enumeration<SpecimenContainedPreference> getPreferenceElement() { 
          if (this.preference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedComponent.preference");
            else if (Configuration.doAutoCreate())
              this.preference = new Enumeration<SpecimenContainedPreference>(new SpecimenContainedPreferenceEnumFactory()); // bb
          return this.preference;
        }

        public boolean hasPreferenceElement() { 
          return this.preference != null && !this.preference.isEmpty();
        }

        public boolean hasPreference() { 
          return this.preference != null && !this.preference.isEmpty();
        }

        /**
         * @param value {@link #preference} (The preference for this type of conditioned specimen.). This is the underlying object with id, value and extensions. The accessor "getPreference" gives direct access to the value
         */
        public SpecimenDefinitionTypeTestedComponent setPreferenceElement(Enumeration<SpecimenContainedPreference> value) { 
          this.preference = value;
          return this;
        }

        /**
         * @return The preference for this type of conditioned specimen.
         */
        public SpecimenContainedPreference getPreference() { 
          return this.preference == null ? null : this.preference.getValue();
        }

        /**
         * @param value The preference for this type of conditioned specimen.
         */
        public SpecimenDefinitionTypeTestedComponent setPreference(SpecimenContainedPreference value) { 
            if (this.preference == null)
              this.preference = new Enumeration<SpecimenContainedPreference>(new SpecimenContainedPreferenceEnumFactory());
            this.preference.setValue(value);
          return this;
        }

        /**
         * @return {@link #container} (The specimen's container.)
         */
        public SpecimenDefinitionTypeTestedContainerComponent getContainer() { 
          if (this.container == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedComponent.container");
            else if (Configuration.doAutoCreate())
              this.container = new SpecimenDefinitionTypeTestedContainerComponent(); // cc
          return this.container;
        }

        public boolean hasContainer() { 
          return this.container != null && !this.container.isEmpty();
        }

        /**
         * @param value {@link #container} (The specimen's container.)
         */
        public SpecimenDefinitionTypeTestedComponent setContainer(SpecimenDefinitionTypeTestedContainerComponent value) { 
          this.container = value;
          return this;
        }

        /**
         * @return {@link #requirement} (Requirements for delivery and special handling of this kind of conditioned specimen.). This is the underlying object with id, value and extensions. The accessor "getRequirement" gives direct access to the value
         */
        public StringType getRequirementElement() { 
          if (this.requirement == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedComponent.requirement");
            else if (Configuration.doAutoCreate())
              this.requirement = new StringType(); // bb
          return this.requirement;
        }

        public boolean hasRequirementElement() { 
          return this.requirement != null && !this.requirement.isEmpty();
        }

        public boolean hasRequirement() { 
          return this.requirement != null && !this.requirement.isEmpty();
        }

        /**
         * @param value {@link #requirement} (Requirements for delivery and special handling of this kind of conditioned specimen.). This is the underlying object with id, value and extensions. The accessor "getRequirement" gives direct access to the value
         */
        public SpecimenDefinitionTypeTestedComponent setRequirementElement(StringType value) { 
          this.requirement = value;
          return this;
        }

        /**
         * @return Requirements for delivery and special handling of this kind of conditioned specimen.
         */
        public String getRequirement() { 
          return this.requirement == null ? null : this.requirement.getValue();
        }

        /**
         * @param value Requirements for delivery and special handling of this kind of conditioned specimen.
         */
        public SpecimenDefinitionTypeTestedComponent setRequirement(String value) { 
          if (Utilities.noString(value))
            this.requirement = null;
          else {
            if (this.requirement == null)
              this.requirement = new StringType();
            this.requirement.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #retentionTime} (The usual time that a specimen of this kind is retained after the ordered tests are completed, for the purpose of additional testing.)
         */
        public Duration getRetentionTime() { 
          if (this.retentionTime == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedComponent.retentionTime");
            else if (Configuration.doAutoCreate())
              this.retentionTime = new Duration(); // cc
          return this.retentionTime;
        }

        public boolean hasRetentionTime() { 
          return this.retentionTime != null && !this.retentionTime.isEmpty();
        }

        /**
         * @param value {@link #retentionTime} (The usual time that a specimen of this kind is retained after the ordered tests are completed, for the purpose of additional testing.)
         */
        public SpecimenDefinitionTypeTestedComponent setRetentionTime(Duration value) { 
          this.retentionTime = value;
          return this;
        }

        /**
         * @return {@link #singleUse} (Specimen can be used by only one test or panel if the value is "true".). This is the underlying object with id, value and extensions. The accessor "getSingleUse" gives direct access to the value
         */
        public BooleanType getSingleUseElement() { 
          if (this.singleUse == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedComponent.singleUse");
            else if (Configuration.doAutoCreate())
              this.singleUse = new BooleanType(); // bb
          return this.singleUse;
        }

        public boolean hasSingleUseElement() { 
          return this.singleUse != null && !this.singleUse.isEmpty();
        }

        public boolean hasSingleUse() { 
          return this.singleUse != null && !this.singleUse.isEmpty();
        }

        /**
         * @param value {@link #singleUse} (Specimen can be used by only one test or panel if the value is "true".). This is the underlying object with id, value and extensions. The accessor "getSingleUse" gives direct access to the value
         */
        public SpecimenDefinitionTypeTestedComponent setSingleUseElement(BooleanType value) { 
          this.singleUse = value;
          return this;
        }

        /**
         * @return Specimen can be used by only one test or panel if the value is "true".
         */
        public boolean getSingleUse() { 
          return this.singleUse == null || this.singleUse.isEmpty() ? false : this.singleUse.getValue();
        }

        /**
         * @param value Specimen can be used by only one test or panel if the value is "true".
         */
        public SpecimenDefinitionTypeTestedComponent setSingleUse(boolean value) { 
            if (this.singleUse == null)
              this.singleUse = new BooleanType();
            this.singleUse.setValue(value);
          return this;
        }

        /**
         * @return {@link #rejectionCriterion} (Criterion for rejection of the specimen in its container by the laboratory.)
         */
        public List<CodeableConcept> getRejectionCriterion() { 
          if (this.rejectionCriterion == null)
            this.rejectionCriterion = new ArrayList<CodeableConcept>();
          return this.rejectionCriterion;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SpecimenDefinitionTypeTestedComponent setRejectionCriterion(List<CodeableConcept> theRejectionCriterion) { 
          this.rejectionCriterion = theRejectionCriterion;
          return this;
        }

        public boolean hasRejectionCriterion() { 
          if (this.rejectionCriterion == null)
            return false;
          for (CodeableConcept item : this.rejectionCriterion)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addRejectionCriterion() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.rejectionCriterion == null)
            this.rejectionCriterion = new ArrayList<CodeableConcept>();
          this.rejectionCriterion.add(t);
          return t;
        }

        public SpecimenDefinitionTypeTestedComponent addRejectionCriterion(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.rejectionCriterion == null)
            this.rejectionCriterion = new ArrayList<CodeableConcept>();
          this.rejectionCriterion.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #rejectionCriterion}, creating it if it does not already exist {3}
         */
        public CodeableConcept getRejectionCriterionFirstRep() { 
          if (getRejectionCriterion().isEmpty()) {
            addRejectionCriterion();
          }
          return getRejectionCriterion().get(0);
        }

        /**
         * @return {@link #handling} (Set of instructions for preservation/transport of the specimen at a defined temperature interval, prior the testing process.)
         */
        public List<SpecimenDefinitionTypeTestedHandlingComponent> getHandling() { 
          if (this.handling == null)
            this.handling = new ArrayList<SpecimenDefinitionTypeTestedHandlingComponent>();
          return this.handling;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SpecimenDefinitionTypeTestedComponent setHandling(List<SpecimenDefinitionTypeTestedHandlingComponent> theHandling) { 
          this.handling = theHandling;
          return this;
        }

        public boolean hasHandling() { 
          if (this.handling == null)
            return false;
          for (SpecimenDefinitionTypeTestedHandlingComponent item : this.handling)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SpecimenDefinitionTypeTestedHandlingComponent addHandling() { //3
          SpecimenDefinitionTypeTestedHandlingComponent t = new SpecimenDefinitionTypeTestedHandlingComponent();
          if (this.handling == null)
            this.handling = new ArrayList<SpecimenDefinitionTypeTestedHandlingComponent>();
          this.handling.add(t);
          return t;
        }

        public SpecimenDefinitionTypeTestedComponent addHandling(SpecimenDefinitionTypeTestedHandlingComponent t) { //3
          if (t == null)
            return this;
          if (this.handling == null)
            this.handling = new ArrayList<SpecimenDefinitionTypeTestedHandlingComponent>();
          this.handling.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #handling}, creating it if it does not already exist {3}
         */
        public SpecimenDefinitionTypeTestedHandlingComponent getHandlingFirstRep() { 
          if (getHandling().isEmpty()) {
            addHandling();
          }
          return getHandling().get(0);
        }

        /**
         * @return {@link #testingDestination} (Where the specimen will be tested: e.g., lab, sector, device or any combination of these.)
         */
        public List<CodeableConcept> getTestingDestination() { 
          if (this.testingDestination == null)
            this.testingDestination = new ArrayList<CodeableConcept>();
          return this.testingDestination;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SpecimenDefinitionTypeTestedComponent setTestingDestination(List<CodeableConcept> theTestingDestination) { 
          this.testingDestination = theTestingDestination;
          return this;
        }

        public boolean hasTestingDestination() { 
          if (this.testingDestination == null)
            return false;
          for (CodeableConcept item : this.testingDestination)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addTestingDestination() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.testingDestination == null)
            this.testingDestination = new ArrayList<CodeableConcept>();
          this.testingDestination.add(t);
          return t;
        }

        public SpecimenDefinitionTypeTestedComponent addTestingDestination(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.testingDestination == null)
            this.testingDestination = new ArrayList<CodeableConcept>();
          this.testingDestination.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #testingDestination}, creating it if it does not already exist {3}
         */
        public CodeableConcept getTestingDestinationFirstRep() { 
          if (getTestingDestination().isEmpty()) {
            addTestingDestination();
          }
          return getTestingDestination().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("isDerived", "boolean", "Primary of secondary specimen.", 0, 1, isDerived));
          children.add(new Property("type", "CodeableConcept", "The kind of specimen conditioned for testing expected by lab.", 0, 1, type));
          children.add(new Property("preference", "code", "The preference for this type of conditioned specimen.", 0, 1, preference));
          children.add(new Property("container", "", "The specimen's container.", 0, 1, container));
          children.add(new Property("requirement", "string", "Requirements for delivery and special handling of this kind of conditioned specimen.", 0, 1, requirement));
          children.add(new Property("retentionTime", "Duration", "The usual time that a specimen of this kind is retained after the ordered tests are completed, for the purpose of additional testing.", 0, 1, retentionTime));
          children.add(new Property("singleUse", "boolean", "Specimen can be used by only one test or panel if the value is \"true\".", 0, 1, singleUse));
          children.add(new Property("rejectionCriterion", "CodeableConcept", "Criterion for rejection of the specimen in its container by the laboratory.", 0, java.lang.Integer.MAX_VALUE, rejectionCriterion));
          children.add(new Property("handling", "", "Set of instructions for preservation/transport of the specimen at a defined temperature interval, prior the testing process.", 0, java.lang.Integer.MAX_VALUE, handling));
          children.add(new Property("testingDestination", "CodeableConcept", "Where the specimen will be tested: e.g., lab, sector, device or any combination of these.", 0, java.lang.Integer.MAX_VALUE, testingDestination));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 976346515: /*isDerived*/  return new Property("isDerived", "boolean", "Primary of secondary specimen.", 0, 1, isDerived);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The kind of specimen conditioned for testing expected by lab.", 0, 1, type);
          case -1459831589: /*preference*/  return new Property("preference", "code", "The preference for this type of conditioned specimen.", 0, 1, preference);
          case -410956671: /*container*/  return new Property("container", "", "The specimen's container.", 0, 1, container);
          case 363387971: /*requirement*/  return new Property("requirement", "string", "Requirements for delivery and special handling of this kind of conditioned specimen.", 0, 1, requirement);
          case 1434969867: /*retentionTime*/  return new Property("retentionTime", "Duration", "The usual time that a specimen of this kind is retained after the ordered tests are completed, for the purpose of additional testing.", 0, 1, retentionTime);
          case -1494547425: /*singleUse*/  return new Property("singleUse", "boolean", "Specimen can be used by only one test or panel if the value is \"true\".", 0, 1, singleUse);
          case -553706344: /*rejectionCriterion*/  return new Property("rejectionCriterion", "CodeableConcept", "Criterion for rejection of the specimen in its container by the laboratory.", 0, java.lang.Integer.MAX_VALUE, rejectionCriterion);
          case 2072805: /*handling*/  return new Property("handling", "", "Set of instructions for preservation/transport of the specimen at a defined temperature interval, prior the testing process.", 0, java.lang.Integer.MAX_VALUE, handling);
          case 939511774: /*testingDestination*/  return new Property("testingDestination", "CodeableConcept", "Where the specimen will be tested: e.g., lab, sector, device or any combination of these.", 0, java.lang.Integer.MAX_VALUE, testingDestination);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 976346515: /*isDerived*/ return this.isDerived == null ? new Base[0] : new Base[] {this.isDerived}; // BooleanType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -1459831589: /*preference*/ return this.preference == null ? new Base[0] : new Base[] {this.preference}; // Enumeration<SpecimenContainedPreference>
        case -410956671: /*container*/ return this.container == null ? new Base[0] : new Base[] {this.container}; // SpecimenDefinitionTypeTestedContainerComponent
        case 363387971: /*requirement*/ return this.requirement == null ? new Base[0] : new Base[] {this.requirement}; // StringType
        case 1434969867: /*retentionTime*/ return this.retentionTime == null ? new Base[0] : new Base[] {this.retentionTime}; // Duration
        case -1494547425: /*singleUse*/ return this.singleUse == null ? new Base[0] : new Base[] {this.singleUse}; // BooleanType
        case -553706344: /*rejectionCriterion*/ return this.rejectionCriterion == null ? new Base[0] : this.rejectionCriterion.toArray(new Base[this.rejectionCriterion.size()]); // CodeableConcept
        case 2072805: /*handling*/ return this.handling == null ? new Base[0] : this.handling.toArray(new Base[this.handling.size()]); // SpecimenDefinitionTypeTestedHandlingComponent
        case 939511774: /*testingDestination*/ return this.testingDestination == null ? new Base[0] : this.testingDestination.toArray(new Base[this.testingDestination.size()]); // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 976346515: // isDerived
          this.isDerived = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1459831589: // preference
          value = new SpecimenContainedPreferenceEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.preference = (Enumeration) value; // Enumeration<SpecimenContainedPreference>
          return value;
        case -410956671: // container
          this.container = (SpecimenDefinitionTypeTestedContainerComponent) value; // SpecimenDefinitionTypeTestedContainerComponent
          return value;
        case 363387971: // requirement
          this.requirement = TypeConvertor.castToString(value); // StringType
          return value;
        case 1434969867: // retentionTime
          this.retentionTime = TypeConvertor.castToDuration(value); // Duration
          return value;
        case -1494547425: // singleUse
          this.singleUse = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -553706344: // rejectionCriterion
          this.getRejectionCriterion().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 2072805: // handling
          this.getHandling().add((SpecimenDefinitionTypeTestedHandlingComponent) value); // SpecimenDefinitionTypeTestedHandlingComponent
          return value;
        case 939511774: // testingDestination
          this.getTestingDestination().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("isDerived")) {
          this.isDerived = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("preference")) {
          value = new SpecimenContainedPreferenceEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.preference = (Enumeration) value; // Enumeration<SpecimenContainedPreference>
        } else if (name.equals("container")) {
          this.container = (SpecimenDefinitionTypeTestedContainerComponent) value; // SpecimenDefinitionTypeTestedContainerComponent
        } else if (name.equals("requirement")) {
          this.requirement = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("retentionTime")) {
          this.retentionTime = TypeConvertor.castToDuration(value); // Duration
        } else if (name.equals("singleUse")) {
          this.singleUse = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("rejectionCriterion")) {
          this.getRejectionCriterion().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("handling")) {
          this.getHandling().add((SpecimenDefinitionTypeTestedHandlingComponent) value);
        } else if (name.equals("testingDestination")) {
          this.getTestingDestination().add(TypeConvertor.castToCodeableConcept(value));
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 976346515:  return getIsDerivedElement();
        case 3575610:  return getType();
        case -1459831589:  return getPreferenceElement();
        case -410956671:  return getContainer();
        case 363387971:  return getRequirementElement();
        case 1434969867:  return getRetentionTime();
        case -1494547425:  return getSingleUseElement();
        case -553706344:  return addRejectionCriterion(); 
        case 2072805:  return addHandling(); 
        case 939511774:  return addTestingDestination(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 976346515: /*isDerived*/ return new String[] {"boolean"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -1459831589: /*preference*/ return new String[] {"code"};
        case -410956671: /*container*/ return new String[] {};
        case 363387971: /*requirement*/ return new String[] {"string"};
        case 1434969867: /*retentionTime*/ return new String[] {"Duration"};
        case -1494547425: /*singleUse*/ return new String[] {"boolean"};
        case -553706344: /*rejectionCriterion*/ return new String[] {"CodeableConcept"};
        case 2072805: /*handling*/ return new String[] {};
        case 939511774: /*testingDestination*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("isDerived")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.typeTested.isDerived");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("preference")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.typeTested.preference");
        }
        else if (name.equals("container")) {
          this.container = new SpecimenDefinitionTypeTestedContainerComponent();
          return this.container;
        }
        else if (name.equals("requirement")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.typeTested.requirement");
        }
        else if (name.equals("retentionTime")) {
          this.retentionTime = new Duration();
          return this.retentionTime;
        }
        else if (name.equals("singleUse")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.typeTested.singleUse");
        }
        else if (name.equals("rejectionCriterion")) {
          return addRejectionCriterion();
        }
        else if (name.equals("handling")) {
          return addHandling();
        }
        else if (name.equals("testingDestination")) {
          return addTestingDestination();
        }
        else
          return super.addChild(name);
      }

      public SpecimenDefinitionTypeTestedComponent copy() {
        SpecimenDefinitionTypeTestedComponent dst = new SpecimenDefinitionTypeTestedComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SpecimenDefinitionTypeTestedComponent dst) {
        super.copyValues(dst);
        dst.isDerived = isDerived == null ? null : isDerived.copy();
        dst.type = type == null ? null : type.copy();
        dst.preference = preference == null ? null : preference.copy();
        dst.container = container == null ? null : container.copy();
        dst.requirement = requirement == null ? null : requirement.copy();
        dst.retentionTime = retentionTime == null ? null : retentionTime.copy();
        dst.singleUse = singleUse == null ? null : singleUse.copy();
        if (rejectionCriterion != null) {
          dst.rejectionCriterion = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : rejectionCriterion)
            dst.rejectionCriterion.add(i.copy());
        };
        if (handling != null) {
          dst.handling = new ArrayList<SpecimenDefinitionTypeTestedHandlingComponent>();
          for (SpecimenDefinitionTypeTestedHandlingComponent i : handling)
            dst.handling.add(i.copy());
        };
        if (testingDestination != null) {
          dst.testingDestination = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : testingDestination)
            dst.testingDestination.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinitionTypeTestedComponent))
          return false;
        SpecimenDefinitionTypeTestedComponent o = (SpecimenDefinitionTypeTestedComponent) other_;
        return compareDeep(isDerived, o.isDerived, true) && compareDeep(type, o.type, true) && compareDeep(preference, o.preference, true)
           && compareDeep(container, o.container, true) && compareDeep(requirement, o.requirement, true) && compareDeep(retentionTime, o.retentionTime, true)
           && compareDeep(singleUse, o.singleUse, true) && compareDeep(rejectionCriterion, o.rejectionCriterion, true)
           && compareDeep(handling, o.handling, true) && compareDeep(testingDestination, o.testingDestination, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinitionTypeTestedComponent))
          return false;
        SpecimenDefinitionTypeTestedComponent o = (SpecimenDefinitionTypeTestedComponent) other_;
        return compareValues(isDerived, o.isDerived, true) && compareValues(preference, o.preference, true)
           && compareValues(requirement, o.requirement, true) && compareValues(singleUse, o.singleUse, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(isDerived, type, preference
          , container, requirement, retentionTime, singleUse, rejectionCriterion, handling
          , testingDestination);
      }

  public String fhirType() {
    return "SpecimenDefinition.typeTested";

  }

  }

    @Block()
    public static class SpecimenDefinitionTypeTestedContainerComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of material of the container.
         */
        @Child(name = "material", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The material type used for the container", formalDefinition="The type of material of the container." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/container-material")
        protected CodeableConcept material;

        /**
         * The type of container used to contain this kind of specimen.
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Kind of container associated with the kind of specimen", formalDefinition="The type of container used to contain this kind of specimen." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/specimen-container-type")
        protected CodeableConcept type;

        /**
         * Color of container cap.
         */
        @Child(name = "cap", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Color of container cap", formalDefinition="Color of container cap." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/container-cap")
        protected CodeableConcept cap;

        /**
         * The textual description of the kind of container.
         */
        @Child(name = "description", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The description of the kind of container", formalDefinition="The textual description of the kind of container." )
        protected StringType description;

        /**
         * The capacity (volume or other measure) of this kind of container.
         */
        @Child(name = "capacity", type = {Quantity.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The capacity of this kind of container", formalDefinition="The capacity (volume or other measure) of this kind of container." )
        protected Quantity capacity;

        /**
         * The minimum volume to be conditioned in the container.
         */
        @Child(name = "minimumVolume", type = {Quantity.class, StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Minimum volume", formalDefinition="The minimum volume to be conditioned in the container." )
        protected DataType minimumVolume;

        /**
         * Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.
         */
        @Child(name = "additive", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Additive associated with container", formalDefinition="Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA." )
        protected List<SpecimenDefinitionTypeTestedContainerAdditiveComponent> additive;

        /**
         * Special processing that should be applied to the container for this kind of specimen.
         */
        @Child(name = "preparation", type = {StringType.class}, order=8, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Special processing applied to the container for this specimen type", formalDefinition="Special processing that should be applied to the container for this kind of specimen." )
        protected StringType preparation;

        private static final long serialVersionUID = -1498817064L;

    /**
     * Constructor
     */
      public SpecimenDefinitionTypeTestedContainerComponent() {
        super();
      }

        /**
         * @return {@link #material} (The type of material of the container.)
         */
        public CodeableConcept getMaterial() { 
          if (this.material == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedContainerComponent.material");
            else if (Configuration.doAutoCreate())
              this.material = new CodeableConcept(); // cc
          return this.material;
        }

        public boolean hasMaterial() { 
          return this.material != null && !this.material.isEmpty();
        }

        /**
         * @param value {@link #material} (The type of material of the container.)
         */
        public SpecimenDefinitionTypeTestedContainerComponent setMaterial(CodeableConcept value) { 
          this.material = value;
          return this;
        }

        /**
         * @return {@link #type} (The type of container used to contain this kind of specimen.)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedContainerComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of container used to contain this kind of specimen.)
         */
        public SpecimenDefinitionTypeTestedContainerComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #cap} (Color of container cap.)
         */
        public CodeableConcept getCap() { 
          if (this.cap == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedContainerComponent.cap");
            else if (Configuration.doAutoCreate())
              this.cap = new CodeableConcept(); // cc
          return this.cap;
        }

        public boolean hasCap() { 
          return this.cap != null && !this.cap.isEmpty();
        }

        /**
         * @param value {@link #cap} (Color of container cap.)
         */
        public SpecimenDefinitionTypeTestedContainerComponent setCap(CodeableConcept value) { 
          this.cap = value;
          return this;
        }

        /**
         * @return {@link #description} (The textual description of the kind of container.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedContainerComponent.description");
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
         * @param value {@link #description} (The textual description of the kind of container.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public SpecimenDefinitionTypeTestedContainerComponent setDescriptionElement(StringType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return The textual description of the kind of container.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value The textual description of the kind of container.
         */
        public SpecimenDefinitionTypeTestedContainerComponent setDescription(String value) { 
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
         * @return {@link #capacity} (The capacity (volume or other measure) of this kind of container.)
         */
        public Quantity getCapacity() { 
          if (this.capacity == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedContainerComponent.capacity");
            else if (Configuration.doAutoCreate())
              this.capacity = new Quantity(); // cc
          return this.capacity;
        }

        public boolean hasCapacity() { 
          return this.capacity != null && !this.capacity.isEmpty();
        }

        /**
         * @param value {@link #capacity} (The capacity (volume or other measure) of this kind of container.)
         */
        public SpecimenDefinitionTypeTestedContainerComponent setCapacity(Quantity value) { 
          this.capacity = value;
          return this;
        }

        /**
         * @return {@link #minimumVolume} (The minimum volume to be conditioned in the container.)
         */
        public DataType getMinimumVolume() { 
          return this.minimumVolume;
        }

        /**
         * @return {@link #minimumVolume} (The minimum volume to be conditioned in the container.)
         */
        public Quantity getMinimumVolumeQuantity() throws FHIRException { 
          if (this.minimumVolume == null)
            this.minimumVolume = new Quantity();
          if (!(this.minimumVolume instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.minimumVolume.getClass().getName()+" was encountered");
          return (Quantity) this.minimumVolume;
        }

        public boolean hasMinimumVolumeQuantity() { 
          return this != null && this.minimumVolume instanceof Quantity;
        }

        /**
         * @return {@link #minimumVolume} (The minimum volume to be conditioned in the container.)
         */
        public StringType getMinimumVolumeStringType() throws FHIRException { 
          if (this.minimumVolume == null)
            this.minimumVolume = new StringType();
          if (!(this.minimumVolume instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.minimumVolume.getClass().getName()+" was encountered");
          return (StringType) this.minimumVolume;
        }

        public boolean hasMinimumVolumeStringType() { 
          return this != null && this.minimumVolume instanceof StringType;
        }

        public boolean hasMinimumVolume() { 
          return this.minimumVolume != null && !this.minimumVolume.isEmpty();
        }

        /**
         * @param value {@link #minimumVolume} (The minimum volume to be conditioned in the container.)
         */
        public SpecimenDefinitionTypeTestedContainerComponent setMinimumVolume(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof StringType))
            throw new Error("Not the right type for SpecimenDefinition.typeTested.container.minimumVolume[x]: "+value.fhirType());
          this.minimumVolume = value;
          return this;
        }

        /**
         * @return {@link #additive} (Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.)
         */
        public List<SpecimenDefinitionTypeTestedContainerAdditiveComponent> getAdditive() { 
          if (this.additive == null)
            this.additive = new ArrayList<SpecimenDefinitionTypeTestedContainerAdditiveComponent>();
          return this.additive;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public SpecimenDefinitionTypeTestedContainerComponent setAdditive(List<SpecimenDefinitionTypeTestedContainerAdditiveComponent> theAdditive) { 
          this.additive = theAdditive;
          return this;
        }

        public boolean hasAdditive() { 
          if (this.additive == null)
            return false;
          for (SpecimenDefinitionTypeTestedContainerAdditiveComponent item : this.additive)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public SpecimenDefinitionTypeTestedContainerAdditiveComponent addAdditive() { //3
          SpecimenDefinitionTypeTestedContainerAdditiveComponent t = new SpecimenDefinitionTypeTestedContainerAdditiveComponent();
          if (this.additive == null)
            this.additive = new ArrayList<SpecimenDefinitionTypeTestedContainerAdditiveComponent>();
          this.additive.add(t);
          return t;
        }

        public SpecimenDefinitionTypeTestedContainerComponent addAdditive(SpecimenDefinitionTypeTestedContainerAdditiveComponent t) { //3
          if (t == null)
            return this;
          if (this.additive == null)
            this.additive = new ArrayList<SpecimenDefinitionTypeTestedContainerAdditiveComponent>();
          this.additive.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #additive}, creating it if it does not already exist {3}
         */
        public SpecimenDefinitionTypeTestedContainerAdditiveComponent getAdditiveFirstRep() { 
          if (getAdditive().isEmpty()) {
            addAdditive();
          }
          return getAdditive().get(0);
        }

        /**
         * @return {@link #preparation} (Special processing that should be applied to the container for this kind of specimen.). This is the underlying object with id, value and extensions. The accessor "getPreparation" gives direct access to the value
         */
        public StringType getPreparationElement() { 
          if (this.preparation == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedContainerComponent.preparation");
            else if (Configuration.doAutoCreate())
              this.preparation = new StringType(); // bb
          return this.preparation;
        }

        public boolean hasPreparationElement() { 
          return this.preparation != null && !this.preparation.isEmpty();
        }

        public boolean hasPreparation() { 
          return this.preparation != null && !this.preparation.isEmpty();
        }

        /**
         * @param value {@link #preparation} (Special processing that should be applied to the container for this kind of specimen.). This is the underlying object with id, value and extensions. The accessor "getPreparation" gives direct access to the value
         */
        public SpecimenDefinitionTypeTestedContainerComponent setPreparationElement(StringType value) { 
          this.preparation = value;
          return this;
        }

        /**
         * @return Special processing that should be applied to the container for this kind of specimen.
         */
        public String getPreparation() { 
          return this.preparation == null ? null : this.preparation.getValue();
        }

        /**
         * @param value Special processing that should be applied to the container for this kind of specimen.
         */
        public SpecimenDefinitionTypeTestedContainerComponent setPreparation(String value) { 
          if (Utilities.noString(value))
            this.preparation = null;
          else {
            if (this.preparation == null)
              this.preparation = new StringType();
            this.preparation.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("material", "CodeableConcept", "The type of material of the container.", 0, 1, material));
          children.add(new Property("type", "CodeableConcept", "The type of container used to contain this kind of specimen.", 0, 1, type));
          children.add(new Property("cap", "CodeableConcept", "Color of container cap.", 0, 1, cap));
          children.add(new Property("description", "string", "The textual description of the kind of container.", 0, 1, description));
          children.add(new Property("capacity", "Quantity", "The capacity (volume or other measure) of this kind of container.", 0, 1, capacity));
          children.add(new Property("minimumVolume[x]", "Quantity|string", "The minimum volume to be conditioned in the container.", 0, 1, minimumVolume));
          children.add(new Property("additive", "", "Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.", 0, java.lang.Integer.MAX_VALUE, additive));
          children.add(new Property("preparation", "string", "Special processing that should be applied to the container for this kind of specimen.", 0, 1, preparation));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 299066663: /*material*/  return new Property("material", "CodeableConcept", "The type of material of the container.", 0, 1, material);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of container used to contain this kind of specimen.", 0, 1, type);
          case 98258: /*cap*/  return new Property("cap", "CodeableConcept", "Color of container cap.", 0, 1, cap);
          case -1724546052: /*description*/  return new Property("description", "string", "The textual description of the kind of container.", 0, 1, description);
          case -67824454: /*capacity*/  return new Property("capacity", "Quantity", "The capacity (volume or other measure) of this kind of container.", 0, 1, capacity);
          case 371830456: /*minimumVolume[x]*/  return new Property("minimumVolume[x]", "Quantity|string", "The minimum volume to be conditioned in the container.", 0, 1, minimumVolume);
          case -1674665784: /*minimumVolume*/  return new Property("minimumVolume[x]", "Quantity|string", "The minimum volume to be conditioned in the container.", 0, 1, minimumVolume);
          case -532143757: /*minimumVolumeQuantity*/  return new Property("minimumVolume[x]", "Quantity", "The minimum volume to be conditioned in the container.", 0, 1, minimumVolume);
          case 248461049: /*minimumVolumeString*/  return new Property("minimumVolume[x]", "string", "The minimum volume to be conditioned in the container.", 0, 1, minimumVolume);
          case -1226589236: /*additive*/  return new Property("additive", "", "Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.", 0, java.lang.Integer.MAX_VALUE, additive);
          case -1315428713: /*preparation*/  return new Property("preparation", "string", "Special processing that should be applied to the container for this kind of specimen.", 0, 1, preparation);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 299066663: /*material*/ return this.material == null ? new Base[0] : new Base[] {this.material}; // CodeableConcept
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 98258: /*cap*/ return this.cap == null ? new Base[0] : new Base[] {this.cap}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -67824454: /*capacity*/ return this.capacity == null ? new Base[0] : new Base[] {this.capacity}; // Quantity
        case -1674665784: /*minimumVolume*/ return this.minimumVolume == null ? new Base[0] : new Base[] {this.minimumVolume}; // DataType
        case -1226589236: /*additive*/ return this.additive == null ? new Base[0] : this.additive.toArray(new Base[this.additive.size()]); // SpecimenDefinitionTypeTestedContainerAdditiveComponent
        case -1315428713: /*preparation*/ return this.preparation == null ? new Base[0] : new Base[] {this.preparation}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 299066663: // material
          this.material = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 98258: // cap
          this.cap = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -67824454: // capacity
          this.capacity = TypeConvertor.castToQuantity(value); // Quantity
          return value;
        case -1674665784: // minimumVolume
          this.minimumVolume = TypeConvertor.castToType(value); // DataType
          return value;
        case -1226589236: // additive
          this.getAdditive().add((SpecimenDefinitionTypeTestedContainerAdditiveComponent) value); // SpecimenDefinitionTypeTestedContainerAdditiveComponent
          return value;
        case -1315428713: // preparation
          this.preparation = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("material")) {
          this.material = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("cap")) {
          this.cap = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("capacity")) {
          this.capacity = TypeConvertor.castToQuantity(value); // Quantity
        } else if (name.equals("minimumVolume[x]")) {
          this.minimumVolume = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("additive")) {
          this.getAdditive().add((SpecimenDefinitionTypeTestedContainerAdditiveComponent) value);
        } else if (name.equals("preparation")) {
          this.preparation = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 299066663:  return getMaterial();
        case 3575610:  return getType();
        case 98258:  return getCap();
        case -1724546052:  return getDescriptionElement();
        case -67824454:  return getCapacity();
        case 371830456:  return getMinimumVolume();
        case -1674665784:  return getMinimumVolume();
        case -1226589236:  return addAdditive(); 
        case -1315428713:  return getPreparationElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 299066663: /*material*/ return new String[] {"CodeableConcept"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 98258: /*cap*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -67824454: /*capacity*/ return new String[] {"Quantity"};
        case -1674665784: /*minimumVolume*/ return new String[] {"Quantity", "string"};
        case -1226589236: /*additive*/ return new String[] {};
        case -1315428713: /*preparation*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("material")) {
          this.material = new CodeableConcept();
          return this.material;
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("cap")) {
          this.cap = new CodeableConcept();
          return this.cap;
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.typeTested.container.description");
        }
        else if (name.equals("capacity")) {
          this.capacity = new Quantity();
          return this.capacity;
        }
        else if (name.equals("minimumVolumeQuantity")) {
          this.minimumVolume = new Quantity();
          return this.minimumVolume;
        }
        else if (name.equals("minimumVolumeString")) {
          this.minimumVolume = new StringType();
          return this.minimumVolume;
        }
        else if (name.equals("additive")) {
          return addAdditive();
        }
        else if (name.equals("preparation")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.typeTested.container.preparation");
        }
        else
          return super.addChild(name);
      }

      public SpecimenDefinitionTypeTestedContainerComponent copy() {
        SpecimenDefinitionTypeTestedContainerComponent dst = new SpecimenDefinitionTypeTestedContainerComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SpecimenDefinitionTypeTestedContainerComponent dst) {
        super.copyValues(dst);
        dst.material = material == null ? null : material.copy();
        dst.type = type == null ? null : type.copy();
        dst.cap = cap == null ? null : cap.copy();
        dst.description = description == null ? null : description.copy();
        dst.capacity = capacity == null ? null : capacity.copy();
        dst.minimumVolume = minimumVolume == null ? null : minimumVolume.copy();
        if (additive != null) {
          dst.additive = new ArrayList<SpecimenDefinitionTypeTestedContainerAdditiveComponent>();
          for (SpecimenDefinitionTypeTestedContainerAdditiveComponent i : additive)
            dst.additive.add(i.copy());
        };
        dst.preparation = preparation == null ? null : preparation.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinitionTypeTestedContainerComponent))
          return false;
        SpecimenDefinitionTypeTestedContainerComponent o = (SpecimenDefinitionTypeTestedContainerComponent) other_;
        return compareDeep(material, o.material, true) && compareDeep(type, o.type, true) && compareDeep(cap, o.cap, true)
           && compareDeep(description, o.description, true) && compareDeep(capacity, o.capacity, true) && compareDeep(minimumVolume, o.minimumVolume, true)
           && compareDeep(additive, o.additive, true) && compareDeep(preparation, o.preparation, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinitionTypeTestedContainerComponent))
          return false;
        SpecimenDefinitionTypeTestedContainerComponent o = (SpecimenDefinitionTypeTestedContainerComponent) other_;
        return compareValues(description, o.description, true) && compareValues(preparation, o.preparation, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(material, type, cap, description
          , capacity, minimumVolume, additive, preparation);
      }

  public String fhirType() {
    return "SpecimenDefinition.typeTested.container";

  }

  }

    @Block()
    public static class SpecimenDefinitionTypeTestedContainerAdditiveComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.
         */
        @Child(name = "additive", type = {CodeableConcept.class, Substance.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Additive associated with container", formalDefinition="Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0371")
        protected DataType additive;

        private static final long serialVersionUID = 201856258L;

    /**
     * Constructor
     */
      public SpecimenDefinitionTypeTestedContainerAdditiveComponent() {
        super();
      }

    /**
     * Constructor
     */
      public SpecimenDefinitionTypeTestedContainerAdditiveComponent(DataType additive) {
        super();
        this.setAdditive(additive);
      }

        /**
         * @return {@link #additive} (Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.)
         */
        public DataType getAdditive() { 
          return this.additive;
        }

        /**
         * @return {@link #additive} (Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.)
         */
        public CodeableConcept getAdditiveCodeableConcept() throws FHIRException { 
          if (this.additive == null)
            this.additive = new CodeableConcept();
          if (!(this.additive instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.additive.getClass().getName()+" was encountered");
          return (CodeableConcept) this.additive;
        }

        public boolean hasAdditiveCodeableConcept() { 
          return this != null && this.additive instanceof CodeableConcept;
        }

        /**
         * @return {@link #additive} (Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.)
         */
        public Reference getAdditiveReference() throws FHIRException { 
          if (this.additive == null)
            this.additive = new Reference();
          if (!(this.additive instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.additive.getClass().getName()+" was encountered");
          return (Reference) this.additive;
        }

        public boolean hasAdditiveReference() { 
          return this != null && this.additive instanceof Reference;
        }

        public boolean hasAdditive() { 
          return this.additive != null && !this.additive.isEmpty();
        }

        /**
         * @param value {@link #additive} (Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.)
         */
        public SpecimenDefinitionTypeTestedContainerAdditiveComponent setAdditive(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
            throw new Error("Not the right type for SpecimenDefinition.typeTested.container.additive.additive[x]: "+value.fhirType());
          this.additive = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("additive[x]", "CodeableConcept|Reference(Substance)", "Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.", 0, 1, additive));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 261915956: /*additive[x]*/  return new Property("additive[x]", "CodeableConcept|Reference(Substance)", "Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.", 0, 1, additive);
          case -1226589236: /*additive*/  return new Property("additive[x]", "CodeableConcept|Reference(Substance)", "Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.", 0, 1, additive);
          case 1330272821: /*additiveCodeableConcept*/  return new Property("additive[x]", "CodeableConcept", "Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.", 0, 1, additive);
          case -386783009: /*additiveReference*/  return new Property("additive[x]", "Reference(Substance)", "Substance introduced in the kind of container to preserve, maintain or enhance the specimen. Examples: Formalin, Citrate, EDTA.", 0, 1, additive);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1226589236: /*additive*/ return this.additive == null ? new Base[0] : new Base[] {this.additive}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1226589236: // additive
          this.additive = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("additive[x]")) {
          this.additive = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 261915956:  return getAdditive();
        case -1226589236:  return getAdditive();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1226589236: /*additive*/ return new String[] {"CodeableConcept", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("additiveCodeableConcept")) {
          this.additive = new CodeableConcept();
          return this.additive;
        }
        else if (name.equals("additiveReference")) {
          this.additive = new Reference();
          return this.additive;
        }
        else
          return super.addChild(name);
      }

      public SpecimenDefinitionTypeTestedContainerAdditiveComponent copy() {
        SpecimenDefinitionTypeTestedContainerAdditiveComponent dst = new SpecimenDefinitionTypeTestedContainerAdditiveComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SpecimenDefinitionTypeTestedContainerAdditiveComponent dst) {
        super.copyValues(dst);
        dst.additive = additive == null ? null : additive.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinitionTypeTestedContainerAdditiveComponent))
          return false;
        SpecimenDefinitionTypeTestedContainerAdditiveComponent o = (SpecimenDefinitionTypeTestedContainerAdditiveComponent) other_;
        return compareDeep(additive, o.additive, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinitionTypeTestedContainerAdditiveComponent))
          return false;
        SpecimenDefinitionTypeTestedContainerAdditiveComponent o = (SpecimenDefinitionTypeTestedContainerAdditiveComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(additive);
      }

  public String fhirType() {
    return "SpecimenDefinition.typeTested.container.additive";

  }

  }

    @Block()
    public static class SpecimenDefinitionTypeTestedHandlingComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * It qualifies the interval of temperature, which characterizes an occurrence of handling. Conditions that are not related to temperature may be handled in the instruction element.
         */
        @Child(name = "temperatureQualifier", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Qualifies the interval of temperature", formalDefinition="It qualifies the interval of temperature, which characterizes an occurrence of handling. Conditions that are not related to temperature may be handled in the instruction element." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/handling-condition")
        protected CodeableConcept temperatureQualifier;

        /**
         * The temperature interval for this set of handling instructions.
         */
        @Child(name = "temperatureRange", type = {Range.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Temperature range for these handling instructions", formalDefinition="The temperature interval for this set of handling instructions." )
        protected Range temperatureRange;

        /**
         * The maximum time interval of preservation of the specimen with these conditions.
         */
        @Child(name = "maxDuration", type = {Duration.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Maximum preservation time", formalDefinition="The maximum time interval of preservation of the specimen with these conditions." )
        protected Duration maxDuration;

        /**
         * Additional textual instructions for the preservation or transport of the specimen. For instance, 'Protect from light exposure'.
         */
        @Child(name = "instruction", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Preservation instruction", formalDefinition="Additional textual instructions for the preservation or transport of the specimen. For instance, 'Protect from light exposure'." )
        protected StringType instruction;

        private static final long serialVersionUID = 2130906844L;

    /**
     * Constructor
     */
      public SpecimenDefinitionTypeTestedHandlingComponent() {
        super();
      }

        /**
         * @return {@link #temperatureQualifier} (It qualifies the interval of temperature, which characterizes an occurrence of handling. Conditions that are not related to temperature may be handled in the instruction element.)
         */
        public CodeableConcept getTemperatureQualifier() { 
          if (this.temperatureQualifier == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedHandlingComponent.temperatureQualifier");
            else if (Configuration.doAutoCreate())
              this.temperatureQualifier = new CodeableConcept(); // cc
          return this.temperatureQualifier;
        }

        public boolean hasTemperatureQualifier() { 
          return this.temperatureQualifier != null && !this.temperatureQualifier.isEmpty();
        }

        /**
         * @param value {@link #temperatureQualifier} (It qualifies the interval of temperature, which characterizes an occurrence of handling. Conditions that are not related to temperature may be handled in the instruction element.)
         */
        public SpecimenDefinitionTypeTestedHandlingComponent setTemperatureQualifier(CodeableConcept value) { 
          this.temperatureQualifier = value;
          return this;
        }

        /**
         * @return {@link #temperatureRange} (The temperature interval for this set of handling instructions.)
         */
        public Range getTemperatureRange() { 
          if (this.temperatureRange == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedHandlingComponent.temperatureRange");
            else if (Configuration.doAutoCreate())
              this.temperatureRange = new Range(); // cc
          return this.temperatureRange;
        }

        public boolean hasTemperatureRange() { 
          return this.temperatureRange != null && !this.temperatureRange.isEmpty();
        }

        /**
         * @param value {@link #temperatureRange} (The temperature interval for this set of handling instructions.)
         */
        public SpecimenDefinitionTypeTestedHandlingComponent setTemperatureRange(Range value) { 
          this.temperatureRange = value;
          return this;
        }

        /**
         * @return {@link #maxDuration} (The maximum time interval of preservation of the specimen with these conditions.)
         */
        public Duration getMaxDuration() { 
          if (this.maxDuration == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedHandlingComponent.maxDuration");
            else if (Configuration.doAutoCreate())
              this.maxDuration = new Duration(); // cc
          return this.maxDuration;
        }

        public boolean hasMaxDuration() { 
          return this.maxDuration != null && !this.maxDuration.isEmpty();
        }

        /**
         * @param value {@link #maxDuration} (The maximum time interval of preservation of the specimen with these conditions.)
         */
        public SpecimenDefinitionTypeTestedHandlingComponent setMaxDuration(Duration value) { 
          this.maxDuration = value;
          return this;
        }

        /**
         * @return {@link #instruction} (Additional textual instructions for the preservation or transport of the specimen. For instance, 'Protect from light exposure'.). This is the underlying object with id, value and extensions. The accessor "getInstruction" gives direct access to the value
         */
        public StringType getInstructionElement() { 
          if (this.instruction == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create SpecimenDefinitionTypeTestedHandlingComponent.instruction");
            else if (Configuration.doAutoCreate())
              this.instruction = new StringType(); // bb
          return this.instruction;
        }

        public boolean hasInstructionElement() { 
          return this.instruction != null && !this.instruction.isEmpty();
        }

        public boolean hasInstruction() { 
          return this.instruction != null && !this.instruction.isEmpty();
        }

        /**
         * @param value {@link #instruction} (Additional textual instructions for the preservation or transport of the specimen. For instance, 'Protect from light exposure'.). This is the underlying object with id, value and extensions. The accessor "getInstruction" gives direct access to the value
         */
        public SpecimenDefinitionTypeTestedHandlingComponent setInstructionElement(StringType value) { 
          this.instruction = value;
          return this;
        }

        /**
         * @return Additional textual instructions for the preservation or transport of the specimen. For instance, 'Protect from light exposure'.
         */
        public String getInstruction() { 
          return this.instruction == null ? null : this.instruction.getValue();
        }

        /**
         * @param value Additional textual instructions for the preservation or transport of the specimen. For instance, 'Protect from light exposure'.
         */
        public SpecimenDefinitionTypeTestedHandlingComponent setInstruction(String value) { 
          if (Utilities.noString(value))
            this.instruction = null;
          else {
            if (this.instruction == null)
              this.instruction = new StringType();
            this.instruction.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("temperatureQualifier", "CodeableConcept", "It qualifies the interval of temperature, which characterizes an occurrence of handling. Conditions that are not related to temperature may be handled in the instruction element.", 0, 1, temperatureQualifier));
          children.add(new Property("temperatureRange", "Range", "The temperature interval for this set of handling instructions.", 0, 1, temperatureRange));
          children.add(new Property("maxDuration", "Duration", "The maximum time interval of preservation of the specimen with these conditions.", 0, 1, maxDuration));
          children.add(new Property("instruction", "string", "Additional textual instructions for the preservation or transport of the specimen. For instance, 'Protect from light exposure'.", 0, 1, instruction));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 548941206: /*temperatureQualifier*/  return new Property("temperatureQualifier", "CodeableConcept", "It qualifies the interval of temperature, which characterizes an occurrence of handling. Conditions that are not related to temperature may be handled in the instruction element.", 0, 1, temperatureQualifier);
          case -39203799: /*temperatureRange*/  return new Property("temperatureRange", "Range", "The temperature interval for this set of handling instructions.", 0, 1, temperatureRange);
          case 40284952: /*maxDuration*/  return new Property("maxDuration", "Duration", "The maximum time interval of preservation of the specimen with these conditions.", 0, 1, maxDuration);
          case 301526158: /*instruction*/  return new Property("instruction", "string", "Additional textual instructions for the preservation or transport of the specimen. For instance, 'Protect from light exposure'.", 0, 1, instruction);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 548941206: /*temperatureQualifier*/ return this.temperatureQualifier == null ? new Base[0] : new Base[] {this.temperatureQualifier}; // CodeableConcept
        case -39203799: /*temperatureRange*/ return this.temperatureRange == null ? new Base[0] : new Base[] {this.temperatureRange}; // Range
        case 40284952: /*maxDuration*/ return this.maxDuration == null ? new Base[0] : new Base[] {this.maxDuration}; // Duration
        case 301526158: /*instruction*/ return this.instruction == null ? new Base[0] : new Base[] {this.instruction}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 548941206: // temperatureQualifier
          this.temperatureQualifier = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -39203799: // temperatureRange
          this.temperatureRange = TypeConvertor.castToRange(value); // Range
          return value;
        case 40284952: // maxDuration
          this.maxDuration = TypeConvertor.castToDuration(value); // Duration
          return value;
        case 301526158: // instruction
          this.instruction = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("temperatureQualifier")) {
          this.temperatureQualifier = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("temperatureRange")) {
          this.temperatureRange = TypeConvertor.castToRange(value); // Range
        } else if (name.equals("maxDuration")) {
          this.maxDuration = TypeConvertor.castToDuration(value); // Duration
        } else if (name.equals("instruction")) {
          this.instruction = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 548941206:  return getTemperatureQualifier();
        case -39203799:  return getTemperatureRange();
        case 40284952:  return getMaxDuration();
        case 301526158:  return getInstructionElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 548941206: /*temperatureQualifier*/ return new String[] {"CodeableConcept"};
        case -39203799: /*temperatureRange*/ return new String[] {"Range"};
        case 40284952: /*maxDuration*/ return new String[] {"Duration"};
        case 301526158: /*instruction*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("temperatureQualifier")) {
          this.temperatureQualifier = new CodeableConcept();
          return this.temperatureQualifier;
        }
        else if (name.equals("temperatureRange")) {
          this.temperatureRange = new Range();
          return this.temperatureRange;
        }
        else if (name.equals("maxDuration")) {
          this.maxDuration = new Duration();
          return this.maxDuration;
        }
        else if (name.equals("instruction")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.typeTested.handling.instruction");
        }
        else
          return super.addChild(name);
      }

      public SpecimenDefinitionTypeTestedHandlingComponent copy() {
        SpecimenDefinitionTypeTestedHandlingComponent dst = new SpecimenDefinitionTypeTestedHandlingComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SpecimenDefinitionTypeTestedHandlingComponent dst) {
        super.copyValues(dst);
        dst.temperatureQualifier = temperatureQualifier == null ? null : temperatureQualifier.copy();
        dst.temperatureRange = temperatureRange == null ? null : temperatureRange.copy();
        dst.maxDuration = maxDuration == null ? null : maxDuration.copy();
        dst.instruction = instruction == null ? null : instruction.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinitionTypeTestedHandlingComponent))
          return false;
        SpecimenDefinitionTypeTestedHandlingComponent o = (SpecimenDefinitionTypeTestedHandlingComponent) other_;
        return compareDeep(temperatureQualifier, o.temperatureQualifier, true) && compareDeep(temperatureRange, o.temperatureRange, true)
           && compareDeep(maxDuration, o.maxDuration, true) && compareDeep(instruction, o.instruction, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinitionTypeTestedHandlingComponent))
          return false;
        SpecimenDefinitionTypeTestedHandlingComponent o = (SpecimenDefinitionTypeTestedHandlingComponent) other_;
        return compareValues(instruction, o.instruction, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(temperatureQualifier, temperatureRange
          , maxDuration, instruction);
      }

  public String fhirType() {
    return "SpecimenDefinition.typeTested.handling";

  }

  }

    /**
     * An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL SHOULD include the major version of the SpecimenDefinition. For more information see Technical and Business Versions.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Logical canonical URL to reference this SpecimenDefinition (globally unique)", formalDefinition="An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL SHOULD include the major version of the SpecimenDefinition. For more information see Technical and Business Versions." )
    protected UriType url;

    /**
     * A business identifier assigned to this SpecimenDefinition.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier", formalDefinition="A business identifier assigned to this SpecimenDefinition." )
    protected Identifier identifier;

    /**
     * The identifier that is used to identify this version of the SpecimenDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the SpecimenDefinition author and is not expected to be globally unique.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the SpecimenDefinition", formalDefinition="The identifier that is used to identify this version of the SpecimenDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the SpecimenDefinition author and is not expected to be globally unique." )
    protected StringType version;

    /**
     * A short, descriptive, user-friendly title for the SpecimenDefinition.
     */
    @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this SpecimenDefinition (Human friendly)", formalDefinition="A short, descriptive, user-friendly title for the SpecimenDefinition." )
    protected StringType title;

    /**
     * The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in whole or in part by this definition.
     */
    @Child(name = "derivedFromCanonical", type = {CanonicalType.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Based on FHIR definition of another SpecimenDefinition", formalDefinition="The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in whole or in part by this definition." )
    protected List<CanonicalType> derivedFromCanonical;

    /**
     * The URL pointing to an externally-defined type of specimen, guideline or other definition that is adhered to in whole or in part by this definition.
     */
    @Child(name = "derivedFromUri", type = {UriType.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Based on external definition", formalDefinition="The URL pointing to an externally-defined type of specimen, guideline or other definition that is adhered to in whole or in part by this definition." )
    protected List<UriType> derivedFromUri;

    /**
     * The current state of theSpecimenDefinition.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The current state of theSpecimenDefinition." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A flag to indicate that this SpecimenDefinition is not authored for  genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=7, min=0, max=1, modifier=true, summary=true)
    @Description(shortDefinition="If this SpecimenDefinition is not for real usage", formalDefinition="A flag to indicate that this SpecimenDefinition is not authored for  genuine usage." )
    protected BooleanType experimental;

    /**
     * A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.
     */
    @Child(name = "subject", type = {CodeableConcept.class, Group.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Type of subject for specimen collection", formalDefinition="A code or group definition that describes the intended subject  from which this kind of specimen is to be collected." )
    protected DataType subject;

    /**
     * For draft definitions, indicates the date of initial creation. For active definitions, represents the date of activation. For withdrawn definitions, indicates the date of withdrawal.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date status first applied", formalDefinition="For draft definitions, indicates the date of initial creation. For active definitions, represents the date of activation. For withdrawn definitions, indicates the date of withdrawal." )
    protected DateTimeType date;

    /**
     * Helps establish the "authority/credibility" of the SpecimenDefinition. May also allow for contact.
     */
    @Child(name = "publisher", type = {Practitioner.class, PractitionerRole.class, Organization.class}, order=10, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The name of the individual or organization that published the SpecimenDefinition", formalDefinition="Helps establish the \"authority/credibility\" of the SpecimenDefinition. May also allow for contact." )
    protected Reference publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the SpecimenDefinition from the consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Natural language description of the SpecimenDefinition", formalDefinition="A free text natural language description of the SpecimenDefinition from the consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of specimen definitions.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Content intends to support these contexts", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of specimen definitions." )
    protected List<UsageContext> useContext;

    /**
     * A jurisdiction in which the SpecimenDefinition is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for this SpecimenDefinition (if applicable)", formalDefinition="A jurisdiction in which the SpecimenDefinition is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explains why this SpecimeDefinition is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=15, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this SpecimenDefinition is defined", formalDefinition="Explains why this SpecimeDefinition is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SpecimenDefinition.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=16, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SpecimenDefinition." )
    protected MarkdownType copyright;

    /**
     * The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When SpecimenDefinition was approved by publisher", formalDefinition="The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="The date on which the asset content was last reviewed", formalDefinition="The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the SpecimenDefinition content was or is planned to be effective.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=19, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="The effective date range for the SpecimenDefinition", formalDefinition="The period during which the SpecimenDefinition content was or is planned to be effective." )
    protected Period effectivePeriod;

    /**
     * The kind of material to be collected.
     */
    @Child(name = "typeCollected", type = {CodeableConcept.class}, order=20, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Kind of material to collect", formalDefinition="The kind of material to be collected." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/v2-0487")
    protected CodeableConcept typeCollected;

    /**
     * Preparation of the patient for specimen collection.
     */
    @Child(name = "patientPreparation", type = {CodeableConcept.class}, order=21, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Patient preparation for collection", formalDefinition="Preparation of the patient for specimen collection." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/prepare-patient-prior-specimen-collection")
    protected List<CodeableConcept> patientPreparation;

    /**
     * Time aspect of specimen collection (duration or offset).
     */
    @Child(name = "timeAspect", type = {StringType.class}, order=22, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Time aspect for collection", formalDefinition="Time aspect of specimen collection (duration or offset)." )
    protected StringType timeAspect;

    /**
     * The action to be performed for collecting the specimen.
     */
    @Child(name = "collection", type = {CodeableConcept.class}, order=23, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Specimen collection procedure", formalDefinition="The action to be performed for collecting the specimen." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/specimen-collection")
    protected List<CodeableConcept> collection;

    /**
     * Specimen conditioned in a container as expected by the testing laboratory.
     */
    @Child(name = "typeTested", type = {}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Specimen in container intended for testing by lab", formalDefinition="Specimen conditioned in a container as expected by the testing laboratory." )
    protected List<SpecimenDefinitionTypeTestedComponent> typeTested;

    private static final long serialVersionUID = 830184995L;

  /**
   * Constructor
   */
    public SpecimenDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public SpecimenDefinition(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL SHOULD include the major version of the SpecimenDefinition. For more information see Technical and Business Versions.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.url");
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
     * @param value {@link #url} (An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL SHOULD include the major version of the SpecimenDefinition. For more information see Technical and Business Versions.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public SpecimenDefinition setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL SHOULD include the major version of the SpecimenDefinition. For more information see Technical and Business Versions.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL SHOULD include the major version of the SpecimenDefinition. For more information see Technical and Business Versions.
     */
    public SpecimenDefinition setUrl(String value) { 
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
     * @return {@link #identifier} (A business identifier assigned to this SpecimenDefinition.)
     */
    public Identifier getIdentifier() { 
      if (this.identifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.identifier");
        else if (Configuration.doAutoCreate())
          this.identifier = new Identifier(); // cc
      return this.identifier;
    }

    public boolean hasIdentifier() { 
      return this.identifier != null && !this.identifier.isEmpty();
    }

    /**
     * @param value {@link #identifier} (A business identifier assigned to this SpecimenDefinition.)
     */
    public SpecimenDefinition setIdentifier(Identifier value) { 
      this.identifier = value;
      return this;
    }

    /**
     * @return {@link #version} (The identifier that is used to identify this version of the SpecimenDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the SpecimenDefinition author and is not expected to be globally unique.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the SpecimenDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the SpecimenDefinition author and is not expected to be globally unique.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public SpecimenDefinition setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the SpecimenDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the SpecimenDefinition author and is not expected to be globally unique.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the SpecimenDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the SpecimenDefinition author and is not expected to be globally unique.
     */
    public SpecimenDefinition setVersion(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the SpecimenDefinition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the SpecimenDefinition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public SpecimenDefinition setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the SpecimenDefinition.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the SpecimenDefinition.
     */
    public SpecimenDefinition setTitle(String value) { 
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
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in whole or in part by this definition.)
     */
    public List<CanonicalType> getDerivedFromCanonical() { 
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      return this.derivedFromCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SpecimenDefinition setDerivedFromCanonical(List<CanonicalType> theDerivedFromCanonical) { 
      this.derivedFromCanonical = theDerivedFromCanonical;
      return this;
    }

    public boolean hasDerivedFromCanonical() { 
      if (this.derivedFromCanonical == null)
        return false;
      for (CanonicalType item : this.derivedFromCanonical)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in whole or in part by this definition.)
     */
    public CanonicalType addDerivedFromCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      this.derivedFromCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in whole or in part by this definition.)
     */
    public SpecimenDefinition addDerivedFromCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.derivedFromCanonical == null)
        this.derivedFromCanonical = new ArrayList<CanonicalType>();
      this.derivedFromCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFromCanonical} (The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in whole or in part by this definition.)
     */
    public boolean hasDerivedFromCanonical(String value) { 
      if (this.derivedFromCanonical == null)
        return false;
      for (CanonicalType v : this.derivedFromCanonical)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined type of specimen, guideline or other definition that is adhered to in whole or in part by this definition.)
     */
    public List<UriType> getDerivedFromUri() { 
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      return this.derivedFromUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SpecimenDefinition setDerivedFromUri(List<UriType> theDerivedFromUri) { 
      this.derivedFromUri = theDerivedFromUri;
      return this;
    }

    public boolean hasDerivedFromUri() { 
      if (this.derivedFromUri == null)
        return false;
      for (UriType item : this.derivedFromUri)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #derivedFromUri} (The URL pointing to an externally-defined type of specimen, guideline or other definition that is adhered to in whole or in part by this definition.)
     */
    public UriType addDerivedFromUriElement() {//2 
      UriType t = new UriType();
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      this.derivedFromUri.add(t);
      return t;
    }

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined type of specimen, guideline or other definition that is adhered to in whole or in part by this definition.)
     */
    public SpecimenDefinition addDerivedFromUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.derivedFromUri == null)
        this.derivedFromUri = new ArrayList<UriType>();
      this.derivedFromUri.add(t);
      return this;
    }

    /**
     * @param value {@link #derivedFromUri} (The URL pointing to an externally-defined type of specimen, guideline or other definition that is adhered to in whole or in part by this definition.)
     */
    public boolean hasDerivedFromUri(String value) { 
      if (this.derivedFromUri == null)
        return false;
      for (UriType v : this.derivedFromUri)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #status} (The current state of theSpecimenDefinition.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.status");
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
     * @param value {@link #status} (The current state of theSpecimenDefinition.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public SpecimenDefinition setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of theSpecimenDefinition.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of theSpecimenDefinition.
     */
    public SpecimenDefinition setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A flag to indicate that this SpecimenDefinition is not authored for  genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.experimental");
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
     * @param value {@link #experimental} (A flag to indicate that this SpecimenDefinition is not authored for  genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public SpecimenDefinition setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A flag to indicate that this SpecimenDefinition is not authored for  genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A flag to indicate that this SpecimenDefinition is not authored for  genuine usage.
     */
    public SpecimenDefinition setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.)
     */
    public DataType getSubject() { 
      return this.subject;
    }

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.)
     */
    public CodeableConcept getSubjectCodeableConcept() throws FHIRException { 
      if (this.subject == null)
        this.subject = new CodeableConcept();
      if (!(this.subject instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.subject.getClass().getName()+" was encountered");
      return (CodeableConcept) this.subject;
    }

    public boolean hasSubjectCodeableConcept() { 
      return this != null && this.subject instanceof CodeableConcept;
    }

    /**
     * @return {@link #subject} (A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.)
     */
    public Reference getSubjectReference() throws FHIRException { 
      if (this.subject == null)
        this.subject = new Reference();
      if (!(this.subject instanceof Reference))
        throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.subject.getClass().getName()+" was encountered");
      return (Reference) this.subject;
    }

    public boolean hasSubjectReference() { 
      return this != null && this.subject instanceof Reference;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.)
     */
    public SpecimenDefinition setSubject(DataType value) { 
      if (value != null && !(value instanceof CodeableConcept || value instanceof Reference))
        throw new Error("Not the right type for SpecimenDefinition.subject[x]: "+value.fhirType());
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #date} (For draft definitions, indicates the date of initial creation. For active definitions, represents the date of activation. For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.date");
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
     * @param value {@link #date} (For draft definitions, indicates the date of initial creation. For active definitions, represents the date of activation. For withdrawn definitions, indicates the date of withdrawal.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public SpecimenDefinition setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return For draft definitions, indicates the date of initial creation. For active definitions, represents the date of activation. For withdrawn definitions, indicates the date of withdrawal.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value For draft definitions, indicates the date of initial creation. For active definitions, represents the date of activation. For withdrawn definitions, indicates the date of withdrawal.
     */
    public SpecimenDefinition setDate(Date value) { 
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
     * @return {@link #publisher} (Helps establish the "authority/credibility" of the SpecimenDefinition. May also allow for contact.)
     */
    public Reference getPublisher() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.publisher");
        else if (Configuration.doAutoCreate())
          this.publisher = new Reference(); // cc
      return this.publisher;
    }

    public boolean hasPublisher() { 
      return this.publisher != null && !this.publisher.isEmpty();
    }

    /**
     * @param value {@link #publisher} (Helps establish the "authority/credibility" of the SpecimenDefinition. May also allow for contact.)
     */
    public SpecimenDefinition setPublisher(Reference value) { 
      this.publisher = value;
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
    public SpecimenDefinition setContact(List<ContactDetail> theContact) { 
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

    public SpecimenDefinition addContact(ContactDetail t) { //3
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
     * @return {@link #description} (A free text natural language description of the SpecimenDefinition from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.description");
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
     * @param value {@link #description} (A free text natural language description of the SpecimenDefinition from the consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public SpecimenDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the SpecimenDefinition from the consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the SpecimenDefinition from the consumer's perspective.
     */
    public SpecimenDefinition setDescription(String value) { 
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of specimen definitions.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SpecimenDefinition setUseContext(List<UsageContext> theUseContext) { 
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

    public SpecimenDefinition addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A jurisdiction in which the SpecimenDefinition is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SpecimenDefinition setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public SpecimenDefinition addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (Explains why this SpecimeDefinition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.purpose");
        else if (Configuration.doAutoCreate())
          this.purpose = new MarkdownType(); // bb
      return this.purpose;
    }

    public boolean hasPurposeElement() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    public boolean hasPurpose() { 
      return this.purpose != null && !this.purpose.isEmpty();
    }

    /**
     * @param value {@link #purpose} (Explains why this SpecimeDefinition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public SpecimenDefinition setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explains why this SpecimeDefinition is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explains why this SpecimeDefinition is needed and why it has been designed as it has.
     */
    public SpecimenDefinition setPurpose(String value) { 
      if (value == null)
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SpecimenDefinition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.copyright");
        else if (Configuration.doAutoCreate())
          this.copyright = new MarkdownType(); // bb
      return this.copyright;
    }

    public boolean hasCopyrightElement() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    public boolean hasCopyright() { 
      return this.copyright != null && !this.copyright.isEmpty();
    }

    /**
     * @param value {@link #copyright} (Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SpecimenDefinition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public SpecimenDefinition setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SpecimenDefinition.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SpecimenDefinition.
     */
    public SpecimenDefinition setCopyright(String value) { 
      if (value == null)
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.approvalDate");
        else if (Configuration.doAutoCreate())
          this.approvalDate = new DateType(); // bb
      return this.approvalDate;
    }

    public boolean hasApprovalDateElement() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    public boolean hasApprovalDate() { 
      return this.approvalDate != null && !this.approvalDate.isEmpty();
    }

    /**
     * @param value {@link #approvalDate} (The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public SpecimenDefinition setApprovalDateElement(DateType value) { 
      this.approvalDate = value;
      return this;
    }

    /**
     * @return The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() { 
      return this.approvalDate == null ? null : this.approvalDate.getValue();
    }

    /**
     * @param value The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public SpecimenDefinition setApprovalDate(Date value) { 
      if (value == null)
        this.approvalDate = null;
      else {
        if (this.approvalDate == null)
          this.approvalDate = new DateType();
        this.approvalDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      if (this.lastReviewDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.lastReviewDate");
        else if (Configuration.doAutoCreate())
          this.lastReviewDate = new DateType(); // bb
      return this.lastReviewDate;
    }

    public boolean hasLastReviewDateElement() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    public boolean hasLastReviewDate() { 
      return this.lastReviewDate != null && !this.lastReviewDate.isEmpty();
    }

    /**
     * @param value {@link #lastReviewDate} (The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public SpecimenDefinition setLastReviewDateElement(DateType value) { 
      this.lastReviewDate = value;
      return this;
    }

    /**
     * @return The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public Date getLastReviewDate() { 
      return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
    }

    /**
     * @param value The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.
     */
    public SpecimenDefinition setLastReviewDate(Date value) { 
      if (value == null)
        this.lastReviewDate = null;
      else {
        if (this.lastReviewDate == null)
          this.lastReviewDate = new DateType();
        this.lastReviewDate.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #effectivePeriod} (The period during which the SpecimenDefinition content was or is planned to be effective.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the SpecimenDefinition content was or is planned to be effective.)
     */
    public SpecimenDefinition setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #typeCollected} (The kind of material to be collected.)
     */
    public CodeableConcept getTypeCollected() { 
      if (this.typeCollected == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.typeCollected");
        else if (Configuration.doAutoCreate())
          this.typeCollected = new CodeableConcept(); // cc
      return this.typeCollected;
    }

    public boolean hasTypeCollected() { 
      return this.typeCollected != null && !this.typeCollected.isEmpty();
    }

    /**
     * @param value {@link #typeCollected} (The kind of material to be collected.)
     */
    public SpecimenDefinition setTypeCollected(CodeableConcept value) { 
      this.typeCollected = value;
      return this;
    }

    /**
     * @return {@link #patientPreparation} (Preparation of the patient for specimen collection.)
     */
    public List<CodeableConcept> getPatientPreparation() { 
      if (this.patientPreparation == null)
        this.patientPreparation = new ArrayList<CodeableConcept>();
      return this.patientPreparation;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SpecimenDefinition setPatientPreparation(List<CodeableConcept> thePatientPreparation) { 
      this.patientPreparation = thePatientPreparation;
      return this;
    }

    public boolean hasPatientPreparation() { 
      if (this.patientPreparation == null)
        return false;
      for (CodeableConcept item : this.patientPreparation)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addPatientPreparation() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.patientPreparation == null)
        this.patientPreparation = new ArrayList<CodeableConcept>();
      this.patientPreparation.add(t);
      return t;
    }

    public SpecimenDefinition addPatientPreparation(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.patientPreparation == null)
        this.patientPreparation = new ArrayList<CodeableConcept>();
      this.patientPreparation.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #patientPreparation}, creating it if it does not already exist {3}
     */
    public CodeableConcept getPatientPreparationFirstRep() { 
      if (getPatientPreparation().isEmpty()) {
        addPatientPreparation();
      }
      return getPatientPreparation().get(0);
    }

    /**
     * @return {@link #timeAspect} (Time aspect of specimen collection (duration or offset).). This is the underlying object with id, value and extensions. The accessor "getTimeAspect" gives direct access to the value
     */
    public StringType getTimeAspectElement() { 
      if (this.timeAspect == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create SpecimenDefinition.timeAspect");
        else if (Configuration.doAutoCreate())
          this.timeAspect = new StringType(); // bb
      return this.timeAspect;
    }

    public boolean hasTimeAspectElement() { 
      return this.timeAspect != null && !this.timeAspect.isEmpty();
    }

    public boolean hasTimeAspect() { 
      return this.timeAspect != null && !this.timeAspect.isEmpty();
    }

    /**
     * @param value {@link #timeAspect} (Time aspect of specimen collection (duration or offset).). This is the underlying object with id, value and extensions. The accessor "getTimeAspect" gives direct access to the value
     */
    public SpecimenDefinition setTimeAspectElement(StringType value) { 
      this.timeAspect = value;
      return this;
    }

    /**
     * @return Time aspect of specimen collection (duration or offset).
     */
    public String getTimeAspect() { 
      return this.timeAspect == null ? null : this.timeAspect.getValue();
    }

    /**
     * @param value Time aspect of specimen collection (duration or offset).
     */
    public SpecimenDefinition setTimeAspect(String value) { 
      if (Utilities.noString(value))
        this.timeAspect = null;
      else {
        if (this.timeAspect == null)
          this.timeAspect = new StringType();
        this.timeAspect.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #collection} (The action to be performed for collecting the specimen.)
     */
    public List<CodeableConcept> getCollection() { 
      if (this.collection == null)
        this.collection = new ArrayList<CodeableConcept>();
      return this.collection;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SpecimenDefinition setCollection(List<CodeableConcept> theCollection) { 
      this.collection = theCollection;
      return this;
    }

    public boolean hasCollection() { 
      if (this.collection == null)
        return false;
      for (CodeableConcept item : this.collection)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addCollection() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.collection == null)
        this.collection = new ArrayList<CodeableConcept>();
      this.collection.add(t);
      return t;
    }

    public SpecimenDefinition addCollection(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.collection == null)
        this.collection = new ArrayList<CodeableConcept>();
      this.collection.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #collection}, creating it if it does not already exist {3}
     */
    public CodeableConcept getCollectionFirstRep() { 
      if (getCollection().isEmpty()) {
        addCollection();
      }
      return getCollection().get(0);
    }

    /**
     * @return {@link #typeTested} (Specimen conditioned in a container as expected by the testing laboratory.)
     */
    public List<SpecimenDefinitionTypeTestedComponent> getTypeTested() { 
      if (this.typeTested == null)
        this.typeTested = new ArrayList<SpecimenDefinitionTypeTestedComponent>();
      return this.typeTested;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public SpecimenDefinition setTypeTested(List<SpecimenDefinitionTypeTestedComponent> theTypeTested) { 
      this.typeTested = theTypeTested;
      return this;
    }

    public boolean hasTypeTested() { 
      if (this.typeTested == null)
        return false;
      for (SpecimenDefinitionTypeTestedComponent item : this.typeTested)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public SpecimenDefinitionTypeTestedComponent addTypeTested() { //3
      SpecimenDefinitionTypeTestedComponent t = new SpecimenDefinitionTypeTestedComponent();
      if (this.typeTested == null)
        this.typeTested = new ArrayList<SpecimenDefinitionTypeTestedComponent>();
      this.typeTested.add(t);
      return t;
    }

    public SpecimenDefinition addTypeTested(SpecimenDefinitionTypeTestedComponent t) { //3
      if (t == null)
        return this;
      if (this.typeTested == null)
        this.typeTested = new ArrayList<SpecimenDefinitionTypeTestedComponent>();
      this.typeTested.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #typeTested}, creating it if it does not already exist {3}
     */
    public SpecimenDefinitionTypeTestedComponent getTypeTestedFirstRep() { 
      if (getTypeTested().isEmpty()) {
        addTypeTested();
      }
      return getTypeTested().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL SHOULD include the major version of the SpecimenDefinition. For more information see Technical and Business Versions.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A business identifier assigned to this SpecimenDefinition.", 0, 1, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the SpecimenDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the SpecimenDefinition author and is not expected to be globally unique.", 0, 1, version));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the SpecimenDefinition.", 0, 1, title));
        children.add(new Property("derivedFromCanonical", "canonical(SpecimenDefinition)", "The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromCanonical));
        children.add(new Property("derivedFromUri", "uri", "The URL pointing to an externally-defined type of specimen, guideline or other definition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromUri));
        children.add(new Property("status", "code", "The current state of theSpecimenDefinition.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A flag to indicate that this SpecimenDefinition is not authored for  genuine usage.", 0, 1, experimental));
        children.add(new Property("subject[x]", "CodeableConcept|Reference(Group)", "A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.", 0, 1, subject));
        children.add(new Property("date", "dateTime", "For draft definitions, indicates the date of initial creation. For active definitions, represents the date of activation. For withdrawn definitions, indicates the date of withdrawal.", 0, 1, date));
        children.add(new Property("publisher", "Reference(Practitioner|PractitionerRole|Organization)", "Helps establish the \"authority/credibility\" of the SpecimenDefinition. May also allow for contact.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the SpecimenDefinition from the consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of specimen definitions.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the SpecimenDefinition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explains why this SpecimeDefinition is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("copyright", "markdown", "Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SpecimenDefinition.", 0, 1, copyright));
        children.add(new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the SpecimenDefinition content was or is planned to be effective.", 0, 1, effectivePeriod));
        children.add(new Property("typeCollected", "CodeableConcept", "The kind of material to be collected.", 0, 1, typeCollected));
        children.add(new Property("patientPreparation", "CodeableConcept", "Preparation of the patient for specimen collection.", 0, java.lang.Integer.MAX_VALUE, patientPreparation));
        children.add(new Property("timeAspect", "string", "Time aspect of specimen collection (duration or offset).", 0, 1, timeAspect));
        children.add(new Property("collection", "CodeableConcept", "The action to be performed for collecting the specimen.", 0, java.lang.Integer.MAX_VALUE, collection));
        children.add(new Property("typeTested", "", "Specimen conditioned in a container as expected by the testing laboratory.", 0, java.lang.Integer.MAX_VALUE, typeTested));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URL that is used to identify this SpecimenDefinition when it is referenced in a specification, model, design or an instance. This SHALL be a URL, SHOULD be globally unique, and SHOULD be an address at which this SpecimenDefinition is (or will be) published. The URL SHOULD include the major version of the SpecimenDefinition. For more information see Technical and Business Versions.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A business identifier assigned to this SpecimenDefinition.", 0, 1, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the SpecimenDefinition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the SpecimenDefinition author and is not expected to be globally unique.", 0, 1, version);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the SpecimenDefinition.", 0, 1, title);
        case -978133683: /*derivedFromCanonical*/  return new Property("derivedFromCanonical", "canonical(SpecimenDefinition)", "The canonical URL pointing to another FHIR-defined SpecimenDefinition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromCanonical);
        case -1076333435: /*derivedFromUri*/  return new Property("derivedFromUri", "uri", "The URL pointing to an externally-defined type of specimen, guideline or other definition that is adhered to in whole or in part by this definition.", 0, java.lang.Integer.MAX_VALUE, derivedFromUri);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of theSpecimenDefinition.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A flag to indicate that this SpecimenDefinition is not authored for  genuine usage.", 0, 1, experimental);
        case -573640748: /*subject[x]*/  return new Property("subject[x]", "CodeableConcept|Reference(Group)", "A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.", 0, 1, subject);
        case -1867885268: /*subject*/  return new Property("subject[x]", "CodeableConcept|Reference(Group)", "A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.", 0, 1, subject);
        case -1257122603: /*subjectCodeableConcept*/  return new Property("subject[x]", "CodeableConcept", "A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.", 0, 1, subject);
        case 772938623: /*subjectReference*/  return new Property("subject[x]", "Reference(Group)", "A code or group definition that describes the intended subject  from which this kind of specimen is to be collected.", 0, 1, subject);
        case 3076014: /*date*/  return new Property("date", "dateTime", "For draft definitions, indicates the date of initial creation. For active definitions, represents the date of activation. For withdrawn definitions, indicates the date of withdrawal.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "Reference(Practitioner|PractitionerRole|Organization)", "Helps establish the \"authority/credibility\" of the SpecimenDefinition. May also allow for contact.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the SpecimenDefinition from the consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These terms may be used to assist with indexing and searching of specimen definitions.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A jurisdiction in which the SpecimenDefinition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explains why this SpecimeDefinition is needed and why it has been designed as it has.", 0, 1, purpose);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "Copyright statement relating to the SpecimenDefinition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the SpecimenDefinition.", 0, 1, copyright);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the asset content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the asset content was last reviewed. Review happens periodically after that, but doesn't change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the SpecimenDefinition content was or is planned to be effective.", 0, 1, effectivePeriod);
        case 588504367: /*typeCollected*/  return new Property("typeCollected", "CodeableConcept", "The kind of material to be collected.", 0, 1, typeCollected);
        case -879411630: /*patientPreparation*/  return new Property("patientPreparation", "CodeableConcept", "Preparation of the patient for specimen collection.", 0, java.lang.Integer.MAX_VALUE, patientPreparation);
        case 276972933: /*timeAspect*/  return new Property("timeAspect", "string", "Time aspect of specimen collection (duration or offset).", 0, 1, timeAspect);
        case -1741312354: /*collection*/  return new Property("collection", "CodeableConcept", "The action to be performed for collecting the specimen.", 0, java.lang.Integer.MAX_VALUE, collection);
        case -1407902581: /*typeTested*/  return new Property("typeTested", "", "Specimen conditioned in a container as expected by the testing laboratory.", 0, java.lang.Integer.MAX_VALUE, typeTested);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return this.url == null ? new Base[0] : new Base[] {this.url}; // UriType
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : new Base[] {this.identifier}; // Identifier
        case 351608024: /*version*/ return this.version == null ? new Base[0] : new Base[] {this.version}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -978133683: /*derivedFromCanonical*/ return this.derivedFromCanonical == null ? new Base[0] : this.derivedFromCanonical.toArray(new Base[this.derivedFromCanonical.size()]); // CanonicalType
        case -1076333435: /*derivedFromUri*/ return this.derivedFromUri == null ? new Base[0] : this.derivedFromUri.toArray(new Base[this.derivedFromUri.size()]); // UriType
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // DataType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // Reference
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case 588504367: /*typeCollected*/ return this.typeCollected == null ? new Base[0] : new Base[] {this.typeCollected}; // CodeableConcept
        case -879411630: /*patientPreparation*/ return this.patientPreparation == null ? new Base[0] : this.patientPreparation.toArray(new Base[this.patientPreparation.size()]); // CodeableConcept
        case 276972933: /*timeAspect*/ return this.timeAspect == null ? new Base[0] : new Base[] {this.timeAspect}; // StringType
        case -1741312354: /*collection*/ return this.collection == null ? new Base[0] : this.collection.toArray(new Base[this.collection.size()]); // CodeableConcept
        case -1407902581: /*typeTested*/ return this.typeTested == null ? new Base[0] : this.typeTested.toArray(new Base[this.typeTested.size()]); // SpecimenDefinitionTypeTestedComponent
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
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case 351608024: // version
          this.version = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -978133683: // derivedFromCanonical
          this.getDerivedFromCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1076333435: // derivedFromUri
          this.getDerivedFromUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -892481550: // status
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
          return value;
        case -404562712: // experimental
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToType(value); // DataType
          return value;
        case 3076014: // date
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case 1447404028: // publisher
          this.publisher = TypeConvertor.castToReference(value); // Reference
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
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 223539345: // approvalDate
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -1687512484: // lastReviewDate
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
          return value;
        case -403934648: // effectivePeriod
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
          return value;
        case 588504367: // typeCollected
          this.typeCollected = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -879411630: // patientPreparation
          this.getPatientPreparation().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 276972933: // timeAspect
          this.timeAspect = TypeConvertor.castToString(value); // StringType
          return value;
        case -1741312354: // collection
          this.getCollection().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1407902581: // typeTested
          this.getTypeTested().add((SpecimenDefinitionTypeTestedComponent) value); // SpecimenDefinitionTypeTestedComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("url")) {
          this.url = TypeConvertor.castToUri(value); // UriType
        } else if (name.equals("identifier")) {
          this.identifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("version")) {
          this.version = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("derivedFromCanonical")) {
          this.getDerivedFromCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("derivedFromUri")) {
          this.getDerivedFromUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = TypeConvertor.castToBoolean(value); // BooleanType
        } else if (name.equals("subject[x]")) {
          this.subject = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("date")) {
          this.date = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("publisher")) {
          this.publisher = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("contact")) {
          this.getContact().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("useContext")) {
          this.getUseContext().add(TypeConvertor.castToUsageContext(value));
        } else if (name.equals("jurisdiction")) {
          this.getJurisdiction().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("purpose")) {
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("typeCollected")) {
          this.typeCollected = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("patientPreparation")) {
          this.getPatientPreparation().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("timeAspect")) {
          this.timeAspect = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("collection")) {
          this.getCollection().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("typeTested")) {
          this.getTypeTested().add((SpecimenDefinitionTypeTestedComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079:  return getUrlElement();
        case -1618432855:  return getIdentifier();
        case 351608024:  return getVersionElement();
        case 110371416:  return getTitleElement();
        case -978133683:  return addDerivedFromCanonicalElement();
        case -1076333435:  return addDerivedFromUriElement();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case -573640748:  return getSubject();
        case -1867885268:  return getSubject();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisher();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 1522889671:  return getCopyrightElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case 588504367:  return getTypeCollected();
        case -879411630:  return addPatientPreparation(); 
        case 276972933:  return getTimeAspectElement();
        case -1741312354:  return addCollection(); 
        case -1407902581:  return addTypeTested(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 116079: /*url*/ return new String[] {"uri"};
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 351608024: /*version*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -978133683: /*derivedFromCanonical*/ return new String[] {"canonical"};
        case -1076333435: /*derivedFromUri*/ return new String[] {"uri"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case -1867885268: /*subject*/ return new String[] {"CodeableConcept", "Reference"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"Reference"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case 588504367: /*typeCollected*/ return new String[] {"CodeableConcept"};
        case -879411630: /*patientPreparation*/ return new String[] {"CodeableConcept"};
        case 276972933: /*timeAspect*/ return new String[] {"string"};
        case -1741312354: /*collection*/ return new String[] {"CodeableConcept"};
        case -1407902581: /*typeTested*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.url");
        }
        else if (name.equals("identifier")) {
          this.identifier = new Identifier();
          return this.identifier;
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.version");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.title");
        }
        else if (name.equals("derivedFromCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.derivedFromCanonical");
        }
        else if (name.equals("derivedFromUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.derivedFromUri");
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.experimental");
        }
        else if (name.equals("subjectCodeableConcept")) {
          this.subject = new CodeableConcept();
          return this.subject;
        }
        else if (name.equals("subjectReference")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.date");
        }
        else if (name.equals("publisher")) {
          this.publisher = new Reference();
          return this.publisher;
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.purpose");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.copyright");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("typeCollected")) {
          this.typeCollected = new CodeableConcept();
          return this.typeCollected;
        }
        else if (name.equals("patientPreparation")) {
          return addPatientPreparation();
        }
        else if (name.equals("timeAspect")) {
          throw new FHIRException("Cannot call addChild on a primitive type SpecimenDefinition.timeAspect");
        }
        else if (name.equals("collection")) {
          return addCollection();
        }
        else if (name.equals("typeTested")) {
          return addTypeTested();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "SpecimenDefinition";

  }

      public SpecimenDefinition copy() {
        SpecimenDefinition dst = new SpecimenDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(SpecimenDefinition dst) {
        super.copyValues(dst);
        dst.url = url == null ? null : url.copy();
        dst.identifier = identifier == null ? null : identifier.copy();
        dst.version = version == null ? null : version.copy();
        dst.title = title == null ? null : title.copy();
        if (derivedFromCanonical != null) {
          dst.derivedFromCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : derivedFromCanonical)
            dst.derivedFromCanonical.add(i.copy());
        };
        if (derivedFromUri != null) {
          dst.derivedFromUri = new ArrayList<UriType>();
          for (UriType i : derivedFromUri)
            dst.derivedFromUri.add(i.copy());
        };
        dst.status = status == null ? null : status.copy();
        dst.experimental = experimental == null ? null : experimental.copy();
        dst.subject = subject == null ? null : subject.copy();
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
        dst.purpose = purpose == null ? null : purpose.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        dst.typeCollected = typeCollected == null ? null : typeCollected.copy();
        if (patientPreparation != null) {
          dst.patientPreparation = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : patientPreparation)
            dst.patientPreparation.add(i.copy());
        };
        dst.timeAspect = timeAspect == null ? null : timeAspect.copy();
        if (collection != null) {
          dst.collection = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : collection)
            dst.collection.add(i.copy());
        };
        if (typeTested != null) {
          dst.typeTested = new ArrayList<SpecimenDefinitionTypeTestedComponent>();
          for (SpecimenDefinitionTypeTestedComponent i : typeTested)
            dst.typeTested.add(i.copy());
        };
      }

      protected SpecimenDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinition))
          return false;
        SpecimenDefinition o = (SpecimenDefinition) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(title, o.title, true) && compareDeep(derivedFromCanonical, o.derivedFromCanonical, true)
           && compareDeep(derivedFromUri, o.derivedFromUri, true) && compareDeep(status, o.status, true) && compareDeep(experimental, o.experimental, true)
           && compareDeep(subject, o.subject, true) && compareDeep(date, o.date, true) && compareDeep(publisher, o.publisher, true)
           && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true) && compareDeep(useContext, o.useContext, true)
           && compareDeep(jurisdiction, o.jurisdiction, true) && compareDeep(purpose, o.purpose, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(approvalDate, o.approvalDate, true) && compareDeep(lastReviewDate, o.lastReviewDate, true)
           && compareDeep(effectivePeriod, o.effectivePeriod, true) && compareDeep(typeCollected, o.typeCollected, true)
           && compareDeep(patientPreparation, o.patientPreparation, true) && compareDeep(timeAspect, o.timeAspect, true)
           && compareDeep(collection, o.collection, true) && compareDeep(typeTested, o.typeTested, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof SpecimenDefinition))
          return false;
        SpecimenDefinition o = (SpecimenDefinition) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(title, o.title, true)
           && compareValues(derivedFromCanonical, o.derivedFromCanonical, true) && compareValues(derivedFromUri, o.derivedFromUri, true)
           && compareValues(status, o.status, true) && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true)
           && compareValues(description, o.description, true) && compareValues(purpose, o.purpose, true) && compareValues(copyright, o.copyright, true)
           && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
           && compareValues(timeAspect, o.timeAspect, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , title, derivedFromCanonical, derivedFromUri, status, experimental, subject, date
          , publisher, contact, description, useContext, jurisdiction, purpose, copyright
          , approvalDate, lastReviewDate, effectivePeriod, typeCollected, patientPreparation
          , timeAspect, collection, typeTested);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.SpecimenDefinition;
   }

 /**
   * Search parameter: <b>container</b>
   * <p>
   * Description: <b>The type of specimen conditioned in container expected by the lab</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.typeTested.container.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="container", path="SpecimenDefinition.typeTested.container.type", description="The type of specimen conditioned in container expected by the lab", type="token" )
  public static final String SP_CONTAINER = "container";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>container</b>
   * <p>
   * Description: <b>The type of specimen conditioned in container expected by the lab</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.typeTested.container.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CONTAINER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CONTAINER);

 /**
   * Search parameter: <b>experimental</b>
   * <p>
   * Description: <b>Not for genuine usage (true)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.experimental</b><br>
   * </p>
   */
  @SearchParamDefinition(name="experimental", path="SpecimenDefinition.experimental", description="Not for genuine usage (true)", type="token" )
  public static final String SP_EXPERIMENTAL = "experimental";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>experimental</b>
   * <p>
   * Description: <b>Not for genuine usage (true)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.experimental</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam EXPERIMENTAL = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_EXPERIMENTAL);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>The unique identifier associated with the SpecimenDefinition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="SpecimenDefinition.identifier", description="The unique identifier associated with the SpecimenDefinition", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>The unique identifier associated with the SpecimenDefinition</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>is-derived</b>
   * <p>
   * Description: <b>Primary specimen (false) or derived specimen (true)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.typeTested.isDerived</b><br>
   * </p>
   */
  @SearchParamDefinition(name="is-derived", path="SpecimenDefinition.typeTested.isDerived", description="Primary specimen (false) or derived specimen (true)", type="token" )
  public static final String SP_IS_DERIVED = "is-derived";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>is-derived</b>
   * <p>
   * Description: <b>Primary specimen (false) or derived specimen (true)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.typeTested.isDerived</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IS_DERIVED = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IS_DERIVED);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>Publication status of the SpecimenDefinition: draft, active, retired, unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="SpecimenDefinition.status", description="Publication status of the SpecimenDefinition: draft, active, retired, unknown", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>Publication status of the SpecimenDefinition: draft, active, retired, unknown</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>title</b>
   * <p>
   * Description: <b>Human-friendly name of the SpecimenDefinition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>SpecimenDefinition.title</b><br>
   * </p>
   */
  @SearchParamDefinition(name="title", path="SpecimenDefinition.title", description="Human-friendly name of the SpecimenDefinition", type="string" )
  public static final String SP_TITLE = "title";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>title</b>
   * <p>
   * Description: <b>Human-friendly name of the SpecimenDefinition</b><br>
   * Type: <b>string</b><br>
   * Path: <b>SpecimenDefinition.title</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.StringClientParam TITLE = new ca.uhn.fhir.rest.gclient.StringClientParam(SP_TITLE);

 /**
   * Search parameter: <b>type-tested</b>
   * <p>
   * Description: <b>The type of specimen conditioned for testing</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.typeTested.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type-tested", path="SpecimenDefinition.typeTested.type", description="The type of specimen conditioned for testing", type="token" )
  public static final String SP_TYPE_TESTED = "type-tested";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type-tested</b>
   * <p>
   * Description: <b>The type of specimen conditioned for testing</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.typeTested.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE_TESTED = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE_TESTED);

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>The type of collected specimen</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.typeCollected</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="SpecimenDefinition.typeCollected", description="The type of collected specimen", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>The type of collected specimen</b><br>
   * Type: <b>token</b><br>
   * Path: <b>SpecimenDefinition.typeCollected</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);

 /**
   * Search parameter: <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the specimen definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>SpecimenDefinition.url</b><br>
   * </p>
   */
  @SearchParamDefinition(name="url", path="SpecimenDefinition.url", description="The uri that identifies the specimen definition", type="uri" )
  public static final String SP_URL = "url";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>url</b>
   * <p>
   * Description: <b>The uri that identifies the specimen definition</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>SpecimenDefinition.url</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam URL = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_URL);


}