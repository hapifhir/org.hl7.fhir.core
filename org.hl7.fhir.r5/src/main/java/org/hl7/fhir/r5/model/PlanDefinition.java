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
 * This resource allows for the definition of various types of plans as a sharable, consumable, and executable artifact. The resource is general enough to support the description of a broad range of clinical and non-clinical artifacts such as clinical decision support rules, order sets, protocols, and drug quality specifications.
 */
@ResourceDef(name="PlanDefinition", profile="http://hl7.org/fhir/StructureDefinition/PlanDefinition")
public class PlanDefinition extends MetadataResource {

    @Block()
    public static class PlanDefinitionGoalComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * Indicates a category the goal falls within.
         */
        @Child(name = "category", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="E.g. Treatment, dietary, behavioral", formalDefinition="Indicates a category the goal falls within." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/goal-category")
        protected CodeableConcept category;

        /**
         * Human-readable and/or coded description of a specific desired objective of care, such as "control blood pressure" or "negotiate an obstacle course" or "dance with child at wedding".
         */
        @Child(name = "description", type = {CodeableConcept.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code or text describing the goal", formalDefinition="Human-readable and/or coded description of a specific desired objective of care, such as \"control blood pressure\" or \"negotiate an obstacle course\" or \"dance with child at wedding\"." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/clinical-findings")
        protected CodeableConcept description;

        /**
         * Identifies the expected level of importance associated with reaching/sustaining the defined goal.
         */
        @Child(name = "priority", type = {CodeableConcept.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="high-priority | medium-priority | low-priority", formalDefinition="Identifies the expected level of importance associated with reaching/sustaining the defined goal." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/goal-priority")
        protected CodeableConcept priority;

        /**
         * The event after which the goal should begin being pursued.
         */
        @Child(name = "start", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When goal pursuit begins", formalDefinition="The event after which the goal should begin being pursued." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/goal-start-event")
        protected CodeableConcept start;

        /**
         * Identifies problems, conditions, issues, or concerns the goal is intended to address.
         */
        @Child(name = "addresses", type = {CodeableConcept.class}, order=5, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What does the goal address", formalDefinition="Identifies problems, conditions, issues, or concerns the goal is intended to address." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/condition-code")
        protected List<CodeableConcept> addresses;

        /**
         * Didactic or other informational resources associated with the goal that provide further supporting information about the goal. Information resources can include inline text commentary and links to web resources.
         */
        @Child(name = "documentation", type = {RelatedArtifact.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Supporting documentation for the goal", formalDefinition="Didactic or other informational resources associated with the goal that provide further supporting information about the goal. Information resources can include inline text commentary and links to web resources." )
        protected List<RelatedArtifact> documentation;

        /**
         * Indicates what should be done and within what timeframe.
         */
        @Child(name = "target", type = {}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Target outcome for the goal", formalDefinition="Indicates what should be done and within what timeframe." )
        protected List<PlanDefinitionGoalTargetComponent> target;

        private static final long serialVersionUID = -795308926L;

    /**
     * Constructor
     */
      public PlanDefinitionGoalComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PlanDefinitionGoalComponent(CodeableConcept description) {
        super();
        this.setDescription(description);
      }

        /**
         * @return {@link #category} (Indicates a category the goal falls within.)
         */
        public CodeableConcept getCategory() { 
          if (this.category == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionGoalComponent.category");
            else if (Configuration.doAutoCreate())
              this.category = new CodeableConcept(); // cc
          return this.category;
        }

        public boolean hasCategory() { 
          return this.category != null && !this.category.isEmpty();
        }

        /**
         * @param value {@link #category} (Indicates a category the goal falls within.)
         */
        public PlanDefinitionGoalComponent setCategory(CodeableConcept value) { 
          this.category = value;
          return this;
        }

        /**
         * @return {@link #description} (Human-readable and/or coded description of a specific desired objective of care, such as "control blood pressure" or "negotiate an obstacle course" or "dance with child at wedding".)
         */
        public CodeableConcept getDescription() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionGoalComponent.description");
            else if (Configuration.doAutoCreate())
              this.description = new CodeableConcept(); // cc
          return this.description;
        }

        public boolean hasDescription() { 
          return this.description != null && !this.description.isEmpty();
        }

        /**
         * @param value {@link #description} (Human-readable and/or coded description of a specific desired objective of care, such as "control blood pressure" or "negotiate an obstacle course" or "dance with child at wedding".)
         */
        public PlanDefinitionGoalComponent setDescription(CodeableConcept value) { 
          this.description = value;
          return this;
        }

        /**
         * @return {@link #priority} (Identifies the expected level of importance associated with reaching/sustaining the defined goal.)
         */
        public CodeableConcept getPriority() { 
          if (this.priority == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionGoalComponent.priority");
            else if (Configuration.doAutoCreate())
              this.priority = new CodeableConcept(); // cc
          return this.priority;
        }

        public boolean hasPriority() { 
          return this.priority != null && !this.priority.isEmpty();
        }

        /**
         * @param value {@link #priority} (Identifies the expected level of importance associated with reaching/sustaining the defined goal.)
         */
        public PlanDefinitionGoalComponent setPriority(CodeableConcept value) { 
          this.priority = value;
          return this;
        }

        /**
         * @return {@link #start} (The event after which the goal should begin being pursued.)
         */
        public CodeableConcept getStart() { 
          if (this.start == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionGoalComponent.start");
            else if (Configuration.doAutoCreate())
              this.start = new CodeableConcept(); // cc
          return this.start;
        }

        public boolean hasStart() { 
          return this.start != null && !this.start.isEmpty();
        }

        /**
         * @param value {@link #start} (The event after which the goal should begin being pursued.)
         */
        public PlanDefinitionGoalComponent setStart(CodeableConcept value) { 
          this.start = value;
          return this;
        }

        /**
         * @return {@link #addresses} (Identifies problems, conditions, issues, or concerns the goal is intended to address.)
         */
        public List<CodeableConcept> getAddresses() { 
          if (this.addresses == null)
            this.addresses = new ArrayList<CodeableConcept>();
          return this.addresses;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionGoalComponent setAddresses(List<CodeableConcept> theAddresses) { 
          this.addresses = theAddresses;
          return this;
        }

        public boolean hasAddresses() { 
          if (this.addresses == null)
            return false;
          for (CodeableConcept item : this.addresses)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addAddresses() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.addresses == null)
            this.addresses = new ArrayList<CodeableConcept>();
          this.addresses.add(t);
          return t;
        }

        public PlanDefinitionGoalComponent addAddresses(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.addresses == null)
            this.addresses = new ArrayList<CodeableConcept>();
          this.addresses.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #addresses}, creating it if it does not already exist {3}
         */
        public CodeableConcept getAddressesFirstRep() { 
          if (getAddresses().isEmpty()) {
            addAddresses();
          }
          return getAddresses().get(0);
        }

        /**
         * @return {@link #documentation} (Didactic or other informational resources associated with the goal that provide further supporting information about the goal. Information resources can include inline text commentary and links to web resources.)
         */
        public List<RelatedArtifact> getDocumentation() { 
          if (this.documentation == null)
            this.documentation = new ArrayList<RelatedArtifact>();
          return this.documentation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionGoalComponent setDocumentation(List<RelatedArtifact> theDocumentation) { 
          this.documentation = theDocumentation;
          return this;
        }

        public boolean hasDocumentation() { 
          if (this.documentation == null)
            return false;
          for (RelatedArtifact item : this.documentation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RelatedArtifact addDocumentation() { //3
          RelatedArtifact t = new RelatedArtifact();
          if (this.documentation == null)
            this.documentation = new ArrayList<RelatedArtifact>();
          this.documentation.add(t);
          return t;
        }

        public PlanDefinitionGoalComponent addDocumentation(RelatedArtifact t) { //3
          if (t == null)
            return this;
          if (this.documentation == null)
            this.documentation = new ArrayList<RelatedArtifact>();
          this.documentation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #documentation}, creating it if it does not already exist {3}
         */
        public RelatedArtifact getDocumentationFirstRep() { 
          if (getDocumentation().isEmpty()) {
            addDocumentation();
          }
          return getDocumentation().get(0);
        }

        /**
         * @return {@link #target} (Indicates what should be done and within what timeframe.)
         */
        public List<PlanDefinitionGoalTargetComponent> getTarget() { 
          if (this.target == null)
            this.target = new ArrayList<PlanDefinitionGoalTargetComponent>();
          return this.target;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionGoalComponent setTarget(List<PlanDefinitionGoalTargetComponent> theTarget) { 
          this.target = theTarget;
          return this;
        }

        public boolean hasTarget() { 
          if (this.target == null)
            return false;
          for (PlanDefinitionGoalTargetComponent item : this.target)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PlanDefinitionGoalTargetComponent addTarget() { //3
          PlanDefinitionGoalTargetComponent t = new PlanDefinitionGoalTargetComponent();
          if (this.target == null)
            this.target = new ArrayList<PlanDefinitionGoalTargetComponent>();
          this.target.add(t);
          return t;
        }

        public PlanDefinitionGoalComponent addTarget(PlanDefinitionGoalTargetComponent t) { //3
          if (t == null)
            return this;
          if (this.target == null)
            this.target = new ArrayList<PlanDefinitionGoalTargetComponent>();
          this.target.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #target}, creating it if it does not already exist {3}
         */
        public PlanDefinitionGoalTargetComponent getTargetFirstRep() { 
          if (getTarget().isEmpty()) {
            addTarget();
          }
          return getTarget().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("category", "CodeableConcept", "Indicates a category the goal falls within.", 0, 1, category));
          children.add(new Property("description", "CodeableConcept", "Human-readable and/or coded description of a specific desired objective of care, such as \"control blood pressure\" or \"negotiate an obstacle course\" or \"dance with child at wedding\".", 0, 1, description));
          children.add(new Property("priority", "CodeableConcept", "Identifies the expected level of importance associated with reaching/sustaining the defined goal.", 0, 1, priority));
          children.add(new Property("start", "CodeableConcept", "The event after which the goal should begin being pursued.", 0, 1, start));
          children.add(new Property("addresses", "CodeableConcept", "Identifies problems, conditions, issues, or concerns the goal is intended to address.", 0, java.lang.Integer.MAX_VALUE, addresses));
          children.add(new Property("documentation", "RelatedArtifact", "Didactic or other informational resources associated with the goal that provide further supporting information about the goal. Information resources can include inline text commentary and links to web resources.", 0, java.lang.Integer.MAX_VALUE, documentation));
          children.add(new Property("target", "", "Indicates what should be done and within what timeframe.", 0, java.lang.Integer.MAX_VALUE, target));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 50511102: /*category*/  return new Property("category", "CodeableConcept", "Indicates a category the goal falls within.", 0, 1, category);
          case -1724546052: /*description*/  return new Property("description", "CodeableConcept", "Human-readable and/or coded description of a specific desired objective of care, such as \"control blood pressure\" or \"negotiate an obstacle course\" or \"dance with child at wedding\".", 0, 1, description);
          case -1165461084: /*priority*/  return new Property("priority", "CodeableConcept", "Identifies the expected level of importance associated with reaching/sustaining the defined goal.", 0, 1, priority);
          case 109757538: /*start*/  return new Property("start", "CodeableConcept", "The event after which the goal should begin being pursued.", 0, 1, start);
          case 874544034: /*addresses*/  return new Property("addresses", "CodeableConcept", "Identifies problems, conditions, issues, or concerns the goal is intended to address.", 0, java.lang.Integer.MAX_VALUE, addresses);
          case 1587405498: /*documentation*/  return new Property("documentation", "RelatedArtifact", "Didactic or other informational resources associated with the goal that provide further supporting information about the goal. Information resources can include inline text commentary and links to web resources.", 0, java.lang.Integer.MAX_VALUE, documentation);
          case -880905839: /*target*/  return new Property("target", "", "Indicates what should be done and within what timeframe.", 0, java.lang.Integer.MAX_VALUE, target);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return this.category == null ? new Base[0] : new Base[] {this.category}; // CodeableConcept
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // CodeableConcept
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // CodeableConcept
        case 109757538: /*start*/ return this.start == null ? new Base[0] : new Base[] {this.start}; // CodeableConcept
        case 874544034: /*addresses*/ return this.addresses == null ? new Base[0] : this.addresses.toArray(new Base[this.addresses.size()]); // CodeableConcept
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : this.documentation.toArray(new Base[this.documentation.size()]); // RelatedArtifact
        case -880905839: /*target*/ return this.target == null ? new Base[0] : this.target.toArray(new Base[this.target.size()]); // PlanDefinitionGoalTargetComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 50511102: // category
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1165461084: // priority
          this.priority = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 109757538: // start
          this.start = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 874544034: // addresses
          this.getAddresses().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1587405498: // documentation
          this.getDocumentation().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case -880905839: // target
          this.getTarget().add((PlanDefinitionGoalTargetComponent) value); // PlanDefinitionGoalTargetComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("priority")) {
          this.priority = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("start")) {
          this.start = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("addresses")) {
          this.getAddresses().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("documentation")) {
          this.getDocumentation().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("target")) {
          this.getTarget().add((PlanDefinitionGoalTargetComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("category")) {
          this.category = null;
        } else if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("priority")) {
          this.priority = null;
        } else if (name.equals("start")) {
          this.start = null;
        } else if (name.equals("addresses")) {
          this.getAddresses().remove(value);
        } else if (name.equals("documentation")) {
          this.getDocumentation().remove(value);
        } else if (name.equals("target")) {
          this.getTarget().add((PlanDefinitionGoalTargetComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102:  return getCategory();
        case -1724546052:  return getDescription();
        case -1165461084:  return getPriority();
        case 109757538:  return getStart();
        case 874544034:  return addAddresses(); 
        case 1587405498:  return addDocumentation(); 
        case -880905839:  return addTarget(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 50511102: /*category*/ return new String[] {"CodeableConcept"};
        case -1724546052: /*description*/ return new String[] {"CodeableConcept"};
        case -1165461084: /*priority*/ return new String[] {"CodeableConcept"};
        case 109757538: /*start*/ return new String[] {"CodeableConcept"};
        case 874544034: /*addresses*/ return new String[] {"CodeableConcept"};
        case 1587405498: /*documentation*/ return new String[] {"RelatedArtifact"};
        case -880905839: /*target*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("category")) {
          this.category = new CodeableConcept();
          return this.category;
        }
        else if (name.equals("description")) {
          this.description = new CodeableConcept();
          return this.description;
        }
        else if (name.equals("priority")) {
          this.priority = new CodeableConcept();
          return this.priority;
        }
        else if (name.equals("start")) {
          this.start = new CodeableConcept();
          return this.start;
        }
        else if (name.equals("addresses")) {
          return addAddresses();
        }
        else if (name.equals("documentation")) {
          return addDocumentation();
        }
        else if (name.equals("target")) {
          return addTarget();
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionGoalComponent copy() {
        PlanDefinitionGoalComponent dst = new PlanDefinitionGoalComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionGoalComponent dst) {
        super.copyValues(dst);
        dst.category = category == null ? null : category.copy();
        dst.description = description == null ? null : description.copy();
        dst.priority = priority == null ? null : priority.copy();
        dst.start = start == null ? null : start.copy();
        if (addresses != null) {
          dst.addresses = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : addresses)
            dst.addresses.add(i.copy());
        };
        if (documentation != null) {
          dst.documentation = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : documentation)
            dst.documentation.add(i.copy());
        };
        if (target != null) {
          dst.target = new ArrayList<PlanDefinitionGoalTargetComponent>();
          for (PlanDefinitionGoalTargetComponent i : target)
            dst.target.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionGoalComponent))
          return false;
        PlanDefinitionGoalComponent o = (PlanDefinitionGoalComponent) other_;
        return compareDeep(category, o.category, true) && compareDeep(description, o.description, true)
           && compareDeep(priority, o.priority, true) && compareDeep(start, o.start, true) && compareDeep(addresses, o.addresses, true)
           && compareDeep(documentation, o.documentation, true) && compareDeep(target, o.target, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionGoalComponent))
          return false;
        PlanDefinitionGoalComponent o = (PlanDefinitionGoalComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(category, description, priority
          , start, addresses, documentation, target);
      }

  public String fhirType() {
    return "PlanDefinition.goal";

  }

  }

    @Block()
    public static class PlanDefinitionGoalTargetComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The parameter whose value is to be tracked, e.g. body weight, blood pressure, or hemoglobin A1c level.
         */
        @Child(name = "measure", type = {CodeableConcept.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The parameter whose value is to be tracked", formalDefinition="The parameter whose value is to be tracked, e.g. body weight, blood pressure, or hemoglobin A1c level." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/observation-codes")
        protected CodeableConcept measure;

        /**
         * The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.
         */
        @Child(name = "detail", type = {Quantity.class, Range.class, CodeableConcept.class, StringType.class, BooleanType.class, IntegerType.class, Ratio.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The target value to be achieved", formalDefinition="The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value." )
        protected DataType detail;

        /**
         * Indicates the timeframe after the start of the goal in which the goal should be met.
         */
        @Child(name = "due", type = {Duration.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Reach goal within", formalDefinition="Indicates the timeframe after the start of the goal in which the goal should be met." )
        protected Duration due;

        private static final long serialVersionUID = -1464475626L;

    /**
     * Constructor
     */
      public PlanDefinitionGoalTargetComponent() {
        super();
      }

        /**
         * @return {@link #measure} (The parameter whose value is to be tracked, e.g. body weight, blood pressure, or hemoglobin A1c level.)
         */
        public CodeableConcept getMeasure() { 
          if (this.measure == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionGoalTargetComponent.measure");
            else if (Configuration.doAutoCreate())
              this.measure = new CodeableConcept(); // cc
          return this.measure;
        }

        public boolean hasMeasure() { 
          return this.measure != null && !this.measure.isEmpty();
        }

        /**
         * @param value {@link #measure} (The parameter whose value is to be tracked, e.g. body weight, blood pressure, or hemoglobin A1c level.)
         */
        public PlanDefinitionGoalTargetComponent setMeasure(CodeableConcept value) { 
          this.measure = value;
          return this;
        }

        /**
         * @return {@link #detail} (The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.)
         */
        public DataType getDetail() { 
          return this.detail;
        }

        /**
         * @return {@link #detail} (The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.)
         */
        public Quantity getDetailQuantity() throws FHIRException { 
          if (this.detail == null)
            this.detail = new Quantity();
          if (!(this.detail instanceof Quantity))
            throw new FHIRException("Type mismatch: the type Quantity was expected, but "+this.detail.getClass().getName()+" was encountered");
          return (Quantity) this.detail;
        }

        public boolean hasDetailQuantity() { 
          return this != null && this.detail instanceof Quantity;
        }

        /**
         * @return {@link #detail} (The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.)
         */
        public Range getDetailRange() throws FHIRException { 
          if (this.detail == null)
            this.detail = new Range();
          if (!(this.detail instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.detail.getClass().getName()+" was encountered");
          return (Range) this.detail;
        }

        public boolean hasDetailRange() { 
          return this != null && this.detail instanceof Range;
        }

        /**
         * @return {@link #detail} (The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.)
         */
        public CodeableConcept getDetailCodeableConcept() throws FHIRException { 
          if (this.detail == null)
            this.detail = new CodeableConcept();
          if (!(this.detail instanceof CodeableConcept))
            throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.detail.getClass().getName()+" was encountered");
          return (CodeableConcept) this.detail;
        }

        public boolean hasDetailCodeableConcept() { 
          return this != null && this.detail instanceof CodeableConcept;
        }

        /**
         * @return {@link #detail} (The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.)
         */
        public StringType getDetailStringType() throws FHIRException { 
          if (this.detail == null)
            this.detail = new StringType();
          if (!(this.detail instanceof StringType))
            throw new FHIRException("Type mismatch: the type StringType was expected, but "+this.detail.getClass().getName()+" was encountered");
          return (StringType) this.detail;
        }

        public boolean hasDetailStringType() { 
          return this != null && this.detail instanceof StringType;
        }

        /**
         * @return {@link #detail} (The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.)
         */
        public BooleanType getDetailBooleanType() throws FHIRException { 
          if (this.detail == null)
            this.detail = new BooleanType();
          if (!(this.detail instanceof BooleanType))
            throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.detail.getClass().getName()+" was encountered");
          return (BooleanType) this.detail;
        }

        public boolean hasDetailBooleanType() { 
          return this != null && this.detail instanceof BooleanType;
        }

        /**
         * @return {@link #detail} (The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.)
         */
        public IntegerType getDetailIntegerType() throws FHIRException { 
          if (this.detail == null)
            this.detail = new IntegerType();
          if (!(this.detail instanceof IntegerType))
            throw new FHIRException("Type mismatch: the type IntegerType was expected, but "+this.detail.getClass().getName()+" was encountered");
          return (IntegerType) this.detail;
        }

        public boolean hasDetailIntegerType() { 
          return this != null && this.detail instanceof IntegerType;
        }

        /**
         * @return {@link #detail} (The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.)
         */
        public Ratio getDetailRatio() throws FHIRException { 
          if (this.detail == null)
            this.detail = new Ratio();
          if (!(this.detail instanceof Ratio))
            throw new FHIRException("Type mismatch: the type Ratio was expected, but "+this.detail.getClass().getName()+" was encountered");
          return (Ratio) this.detail;
        }

        public boolean hasDetailRatio() { 
          return this != null && this.detail instanceof Ratio;
        }

        public boolean hasDetail() { 
          return this.detail != null && !this.detail.isEmpty();
        }

        /**
         * @param value {@link #detail} (The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.)
         */
        public PlanDefinitionGoalTargetComponent setDetail(DataType value) { 
          if (value != null && !(value instanceof Quantity || value instanceof Range || value instanceof CodeableConcept || value instanceof StringType || value instanceof BooleanType || value instanceof IntegerType || value instanceof Ratio))
            throw new FHIRException("Not the right type for PlanDefinition.goal.target.detail[x]: "+value.fhirType());
          this.detail = value;
          return this;
        }

        /**
         * @return {@link #due} (Indicates the timeframe after the start of the goal in which the goal should be met.)
         */
        public Duration getDue() { 
          if (this.due == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionGoalTargetComponent.due");
            else if (Configuration.doAutoCreate())
              this.due = new Duration(); // cc
          return this.due;
        }

        public boolean hasDue() { 
          return this.due != null && !this.due.isEmpty();
        }

        /**
         * @param value {@link #due} (Indicates the timeframe after the start of the goal in which the goal should be met.)
         */
        public PlanDefinitionGoalTargetComponent setDue(Duration value) { 
          this.due = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("measure", "CodeableConcept", "The parameter whose value is to be tracked, e.g. body weight, blood pressure, or hemoglobin A1c level.", 0, 1, measure));
          children.add(new Property("detail[x]", "Quantity|Range|CodeableConcept|string|boolean|integer|Ratio", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail));
          children.add(new Property("due", "Duration", "Indicates the timeframe after the start of the goal in which the goal should be met.", 0, 1, due));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 938321246: /*measure*/  return new Property("measure", "CodeableConcept", "The parameter whose value is to be tracked, e.g. body weight, blood pressure, or hemoglobin A1c level.", 0, 1, measure);
          case -1973084529: /*detail[x]*/  return new Property("detail[x]", "Quantity|Range|CodeableConcept|string|boolean|integer|Ratio", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail);
          case -1335224239: /*detail*/  return new Property("detail[x]", "Quantity|Range|CodeableConcept|string|boolean|integer|Ratio", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail);
          case -1313079300: /*detailQuantity*/  return new Property("detail[x]", "Quantity", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail);
          case -2062632084: /*detailRange*/  return new Property("detail[x]", "Range", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail);
          case -175586544: /*detailCodeableConcept*/  return new Property("detail[x]", "CodeableConcept", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail);
          case 529212354: /*detailString*/  return new Property("detail[x]", "string", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail);
          case 1172184727: /*detailBoolean*/  return new Property("detail[x]", "boolean", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail);
          case -1229442131: /*detailInteger*/  return new Property("detail[x]", "integer", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail);
          case -2062626246: /*detailRatio*/  return new Property("detail[x]", "Ratio", "The target value of the measure to be achieved to signify fulfillment of the goal, e.g. 150 pounds or 7.0%, or in the case of pharmaceutical quality - NMT 0.6%, Clear solution, etc. Either the high or low or both values of the range can be specified. When a low value is missing, it indicates that the goal is achieved at any value at or below the high value. Similarly, if the high value is missing, it indicates that the goal is achieved at any value at or above the low value.", 0, 1, detail);
          case 99828: /*due*/  return new Property("due", "Duration", "Indicates the timeframe after the start of the goal in which the goal should be met.", 0, 1, due);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 938321246: /*measure*/ return this.measure == null ? new Base[0] : new Base[] {this.measure}; // CodeableConcept
        case -1335224239: /*detail*/ return this.detail == null ? new Base[0] : new Base[] {this.detail}; // DataType
        case 99828: /*due*/ return this.due == null ? new Base[0] : new Base[] {this.due}; // Duration
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 938321246: // measure
          this.measure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1335224239: // detail
          this.detail = TypeConvertor.castToType(value); // DataType
          return value;
        case 99828: // due
          this.due = TypeConvertor.castToDuration(value); // Duration
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("measure")) {
          this.measure = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("detail[x]")) {
          this.detail = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("due")) {
          this.due = TypeConvertor.castToDuration(value); // Duration
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("measure")) {
          this.measure = null;
        } else if (name.equals("detail[x]")) {
          this.detail = null;
        } else if (name.equals("due")) {
          this.due = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938321246:  return getMeasure();
        case -1973084529:  return getDetail();
        case -1335224239:  return getDetail();
        case 99828:  return getDue();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 938321246: /*measure*/ return new String[] {"CodeableConcept"};
        case -1335224239: /*detail*/ return new String[] {"Quantity", "Range", "CodeableConcept", "string", "boolean", "integer", "Ratio"};
        case 99828: /*due*/ return new String[] {"Duration"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("measure")) {
          this.measure = new CodeableConcept();
          return this.measure;
        }
        else if (name.equals("detailQuantity")) {
          this.detail = new Quantity();
          return this.detail;
        }
        else if (name.equals("detailRange")) {
          this.detail = new Range();
          return this.detail;
        }
        else if (name.equals("detailCodeableConcept")) {
          this.detail = new CodeableConcept();
          return this.detail;
        }
        else if (name.equals("detailString")) {
          this.detail = new StringType();
          return this.detail;
        }
        else if (name.equals("detailBoolean")) {
          this.detail = new BooleanType();
          return this.detail;
        }
        else if (name.equals("detailInteger")) {
          this.detail = new IntegerType();
          return this.detail;
        }
        else if (name.equals("detailRatio")) {
          this.detail = new Ratio();
          return this.detail;
        }
        else if (name.equals("due")) {
          this.due = new Duration();
          return this.due;
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionGoalTargetComponent copy() {
        PlanDefinitionGoalTargetComponent dst = new PlanDefinitionGoalTargetComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionGoalTargetComponent dst) {
        super.copyValues(dst);
        dst.measure = measure == null ? null : measure.copy();
        dst.detail = detail == null ? null : detail.copy();
        dst.due = due == null ? null : due.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionGoalTargetComponent))
          return false;
        PlanDefinitionGoalTargetComponent o = (PlanDefinitionGoalTargetComponent) other_;
        return compareDeep(measure, o.measure, true) && compareDeep(detail, o.detail, true) && compareDeep(due, o.due, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionGoalTargetComponent))
          return false;
        PlanDefinitionGoalTargetComponent o = (PlanDefinitionGoalTargetComponent) other_;
        return true;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(measure, detail, due);
      }

  public String fhirType() {
    return "PlanDefinition.goal.target";

  }

  }

    @Block()
    public static class PlanDefinitionActorComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A descriptive label for the actor.
         */
        @Child(name = "title", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="User-visible title", formalDefinition="A descriptive label for the actor." )
        protected StringType title;

        /**
         * A description of how the actor fits into the overall actions of the plan definition.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Describes the actor", formalDefinition="A description of how the actor fits into the overall actions of the plan definition." )
        protected MarkdownType description;

        /**
         * The characteristics of the candidates that could serve as the actor.
         */
        @Child(name = "option", type = {}, order=3, min=1, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Who or what can be this actor", formalDefinition="The characteristics of the candidates that could serve as the actor." )
        protected List<PlanDefinitionActorOptionComponent> option;

        private static final long serialVersionUID = -571302300L;

    /**
     * Constructor
     */
      public PlanDefinitionActorComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PlanDefinitionActorComponent(PlanDefinitionActorOptionComponent option) {
        super();
        this.addOption(option);
      }

        /**
         * @return {@link #title} (A descriptive label for the actor.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActorComponent.title");
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
         * @param value {@link #title} (A descriptive label for the actor.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public PlanDefinitionActorComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return A descriptive label for the actor.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value A descriptive label for the actor.
         */
        public PlanDefinitionActorComponent setTitle(String value) { 
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
         * @return {@link #description} (A description of how the actor fits into the overall actions of the plan definition.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActorComponent.description");
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
         * @param value {@link #description} (A description of how the actor fits into the overall actions of the plan definition.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public PlanDefinitionActorComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A description of how the actor fits into the overall actions of the plan definition.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A description of how the actor fits into the overall actions of the plan definition.
         */
        public PlanDefinitionActorComponent setDescription(String value) { 
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
         * @return {@link #option} (The characteristics of the candidates that could serve as the actor.)
         */
        public List<PlanDefinitionActorOptionComponent> getOption() { 
          if (this.option == null)
            this.option = new ArrayList<PlanDefinitionActorOptionComponent>();
          return this.option;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActorComponent setOption(List<PlanDefinitionActorOptionComponent> theOption) { 
          this.option = theOption;
          return this;
        }

        public boolean hasOption() { 
          if (this.option == null)
            return false;
          for (PlanDefinitionActorOptionComponent item : this.option)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PlanDefinitionActorOptionComponent addOption() { //3
          PlanDefinitionActorOptionComponent t = new PlanDefinitionActorOptionComponent();
          if (this.option == null)
            this.option = new ArrayList<PlanDefinitionActorOptionComponent>();
          this.option.add(t);
          return t;
        }

        public PlanDefinitionActorComponent addOption(PlanDefinitionActorOptionComponent t) { //3
          if (t == null)
            return this;
          if (this.option == null)
            this.option = new ArrayList<PlanDefinitionActorOptionComponent>();
          this.option.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #option}, creating it if it does not already exist {3}
         */
        public PlanDefinitionActorOptionComponent getOptionFirstRep() { 
          if (getOption().isEmpty()) {
            addOption();
          }
          return getOption().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("title", "string", "A descriptive label for the actor.", 0, 1, title));
          children.add(new Property("description", "markdown", "A description of how the actor fits into the overall actions of the plan definition.", 0, 1, description));
          children.add(new Property("option", "", "The characteristics of the candidates that could serve as the actor.", 0, java.lang.Integer.MAX_VALUE, option));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 110371416: /*title*/  return new Property("title", "string", "A descriptive label for the actor.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "A description of how the actor fits into the overall actions of the plan definition.", 0, 1, description);
          case -1010136971: /*option*/  return new Property("option", "", "The characteristics of the candidates that could serve as the actor.", 0, java.lang.Integer.MAX_VALUE, option);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -1010136971: /*option*/ return this.option == null ? new Base[0] : this.option.toArray(new Base[this.option.size()]); // PlanDefinitionActorOptionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1010136971: // option
          this.getOption().add((PlanDefinitionActorOptionComponent) value); // PlanDefinitionActorOptionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("option")) {
          this.getOption().add((PlanDefinitionActorOptionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("option")) {
          this.getOption().add((PlanDefinitionActorOptionComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416:  return getTitleElement();
        case -1724546052:  return getDescriptionElement();
        case -1010136971:  return addOption(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -1010136971: /*option*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.actor.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.actor.description");
        }
        else if (name.equals("option")) {
          return addOption();
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionActorComponent copy() {
        PlanDefinitionActorComponent dst = new PlanDefinitionActorComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionActorComponent dst) {
        super.copyValues(dst);
        dst.title = title == null ? null : title.copy();
        dst.description = description == null ? null : description.copy();
        if (option != null) {
          dst.option = new ArrayList<PlanDefinitionActorOptionComponent>();
          for (PlanDefinitionActorOptionComponent i : option)
            dst.option.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActorComponent))
          return false;
        PlanDefinitionActorComponent o = (PlanDefinitionActorComponent) other_;
        return compareDeep(title, o.title, true) && compareDeep(description, o.description, true) && compareDeep(option, o.option, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActorComponent))
          return false;
        PlanDefinitionActorComponent o = (PlanDefinitionActorComponent) other_;
        return compareValues(title, o.title, true) && compareValues(description, o.description, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(title, description, option
          );
      }

  public String fhirType() {
    return "PlanDefinition.actor";

  }

  }

    @Block()
    public static class PlanDefinitionActorOptionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The type of participant in the action.
         */
        @Child(name = "type", type = {CodeType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="careteam | device | group | healthcareservice | location | organization | patient | practitioner | practitionerrole | relatedperson", formalDefinition="The type of participant in the action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-participant-type")
        protected Enumeration<ActionParticipantType> type;

        /**
         * The type of participant in the action.
         */
        @Child(name = "typeCanonical", type = {CanonicalType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who or what can participate", formalDefinition="The type of participant in the action." )
        protected CanonicalType typeCanonical;

        /**
         * The type of participant in the action.
         */
        @Child(name = "typeReference", type = {CareTeam.class, Device.class, DeviceDefinition.class, Endpoint.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who or what can participate", formalDefinition="The type of participant in the action." )
        protected Reference typeReference;

        /**
         * The role the participant should play in performing the described action.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="E.g. Nurse, Surgeon, Parent", formalDefinition="The role the participant should play in performing the described action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/action-participant-role")
        protected CodeableConcept role;

        private static final long serialVersionUID = 1881639157L;

    /**
     * Constructor
     */
      public PlanDefinitionActorOptionComponent() {
        super();
      }

        /**
         * @return {@link #type} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<ActionParticipantType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActorOptionComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<ActionParticipantType>(new ActionParticipantTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public PlanDefinitionActorOptionComponent setTypeElement(Enumeration<ActionParticipantType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of participant in the action.
         */
        public ActionParticipantType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of participant in the action.
         */
        public PlanDefinitionActorOptionComponent setType(ActionParticipantType value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Enumeration<ActionParticipantType>(new ActionParticipantTypeEnumFactory());
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #typeCanonical} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getTypeCanonical" gives direct access to the value
         */
        public CanonicalType getTypeCanonicalElement() { 
          if (this.typeCanonical == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActorOptionComponent.typeCanonical");
            else if (Configuration.doAutoCreate())
              this.typeCanonical = new CanonicalType(); // bb
          return this.typeCanonical;
        }

        public boolean hasTypeCanonicalElement() { 
          return this.typeCanonical != null && !this.typeCanonical.isEmpty();
        }

        public boolean hasTypeCanonical() { 
          return this.typeCanonical != null && !this.typeCanonical.isEmpty();
        }

        /**
         * @param value {@link #typeCanonical} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getTypeCanonical" gives direct access to the value
         */
        public PlanDefinitionActorOptionComponent setTypeCanonicalElement(CanonicalType value) { 
          this.typeCanonical = value;
          return this;
        }

        /**
         * @return The type of participant in the action.
         */
        public String getTypeCanonical() { 
          return this.typeCanonical == null ? null : this.typeCanonical.getValue();
        }

        /**
         * @param value The type of participant in the action.
         */
        public PlanDefinitionActorOptionComponent setTypeCanonical(String value) { 
          if (Utilities.noString(value))
            this.typeCanonical = null;
          else {
            if (this.typeCanonical == null)
              this.typeCanonical = new CanonicalType();
            this.typeCanonical.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #typeReference} (The type of participant in the action.)
         */
        public Reference getTypeReference() { 
          if (this.typeReference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActorOptionComponent.typeReference");
            else if (Configuration.doAutoCreate())
              this.typeReference = new Reference(); // cc
          return this.typeReference;
        }

        public boolean hasTypeReference() { 
          return this.typeReference != null && !this.typeReference.isEmpty();
        }

        /**
         * @param value {@link #typeReference} (The type of participant in the action.)
         */
        public PlanDefinitionActorOptionComponent setTypeReference(Reference value) { 
          this.typeReference = value;
          return this;
        }

        /**
         * @return {@link #role} (The role the participant should play in performing the described action.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActorOptionComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (The role the participant should play in performing the described action.)
         */
        public PlanDefinitionActorOptionComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "The type of participant in the action.", 0, 1, type));
          children.add(new Property("typeCanonical", "canonical(CapabilityStatement)", "The type of participant in the action.", 0, 1, typeCanonical));
          children.add(new Property("typeReference", "Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The type of participant in the action.", 0, 1, typeReference));
          children.add(new Property("role", "CodeableConcept", "The role the participant should play in performing the described action.", 0, 1, role));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "The type of participant in the action.", 0, 1, type);
          case -466635046: /*typeCanonical*/  return new Property("typeCanonical", "canonical(CapabilityStatement)", "The type of participant in the action.", 0, 1, typeCanonical);
          case 2074825009: /*typeReference*/  return new Property("typeReference", "Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The type of participant in the action.", 0, 1, typeReference);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "The role the participant should play in performing the described action.", 0, 1, role);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ActionParticipantType>
        case -466635046: /*typeCanonical*/ return this.typeCanonical == null ? new Base[0] : new Base[] {this.typeCanonical}; // CanonicalType
        case 2074825009: /*typeReference*/ return this.typeReference == null ? new Base[0] : new Base[] {this.typeReference}; // Reference
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3575610: // type
          value = new ActionParticipantTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ActionParticipantType>
          return value;
        case -466635046: // typeCanonical
          this.typeCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 2074825009: // typeReference
          this.typeReference = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new ActionParticipantTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ActionParticipantType>
        } else if (name.equals("typeCanonical")) {
          this.typeCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("typeReference")) {
          this.typeReference = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("type")) {
          value = new ActionParticipantTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ActionParticipantType>
        } else if (name.equals("typeCanonical")) {
          this.typeCanonical = null;
        } else if (name.equals("typeReference")) {
          this.typeReference = null;
        } else if (name.equals("role")) {
          this.role = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case -466635046:  return getTypeCanonicalElement();
        case 2074825009:  return getTypeReference();
        case 3506294:  return getRole();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610: /*type*/ return new String[] {"code"};
        case -466635046: /*typeCanonical*/ return new String[] {"canonical"};
        case 2074825009: /*typeReference*/ return new String[] {"Reference"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.actor.option.type");
        }
        else if (name.equals("typeCanonical")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.actor.option.typeCanonical");
        }
        else if (name.equals("typeReference")) {
          this.typeReference = new Reference();
          return this.typeReference;
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionActorOptionComponent copy() {
        PlanDefinitionActorOptionComponent dst = new PlanDefinitionActorOptionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionActorOptionComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.typeCanonical = typeCanonical == null ? null : typeCanonical.copy();
        dst.typeReference = typeReference == null ? null : typeReference.copy();
        dst.role = role == null ? null : role.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActorOptionComponent))
          return false;
        PlanDefinitionActorOptionComponent o = (PlanDefinitionActorOptionComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(typeCanonical, o.typeCanonical, true) && compareDeep(typeReference, o.typeReference, true)
           && compareDeep(role, o.role, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActorOptionComponent))
          return false;
        PlanDefinitionActorOptionComponent o = (PlanDefinitionActorOptionComponent) other_;
        return compareValues(type, o.type, true) && compareValues(typeCanonical, o.typeCanonical, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, typeCanonical, typeReference
          , role);
      }

  public String fhirType() {
    return "PlanDefinition.actor.option";

  }

  }

    @Block()
    public static class PlanDefinitionActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * An identifier that is unique within the PlanDefinition to allow linkage within the realized CarePlan and/or RequestOrchestration.
         */
        @Child(name = "linkId", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Unique id for the action in the PlanDefinition", formalDefinition="An identifier that is unique within the PlanDefinition to allow linkage within the realized CarePlan and/or RequestOrchestration." )
        protected StringType linkId;

        /**
         * A user-visible prefix for the action. For example a section or item numbering such as 1. or A.
         */
        @Child(name = "prefix", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="User-visible prefix for the action (e.g. 1. or A.)", formalDefinition="A user-visible prefix for the action. For example a section or item numbering such as 1. or A." )
        protected StringType prefix;

        /**
         * The textual description of the action displayed to a user. For example, when the action is a test to be performed, the title would be the title of the test such as Assay by HPLC.
         */
        @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="User-visible title", formalDefinition="The textual description of the action displayed to a user. For example, when the action is a test to be performed, the title would be the title of the test such as Assay by HPLC." )
        protected StringType title;

        /**
         * A brief description of the action used to provide a summary to display to the user.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Brief description of the action", formalDefinition="A brief description of the action used to provide a summary to display to the user." )
        protected MarkdownType description;

        /**
         * A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.
         */
        @Child(name = "textEquivalent", type = {MarkdownType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Static text equivalent of the action, used if the dynamic aspects cannot be interpreted by the receiving system", formalDefinition="A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically." )
        protected MarkdownType textEquivalent;

        /**
         * Indicates how quickly the action should be addressed with respect to other actions.
         */
        @Child(name = "priority", type = {CodeType.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="routine | urgent | asap | stat", formalDefinition="Indicates how quickly the action should be addressed with respect to other actions." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-priority")
        protected Enumeration<RequestPriority> priority;

        /**
         * A code that provides a meaning, grouping, or classification for the action or action group. For example, a section may have a LOINC code for the section of a documentation template. In pharmaceutical quality, an action (Test) such as pH could be classified as a physical property.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Code representing the meaning of the action or sub-actions", formalDefinition="A code that provides a meaning, grouping, or classification for the action or action group. For example, a section may have a LOINC code for the section of a documentation template. In pharmaceutical quality, an action (Test) such as pH could be classified as a physical property." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-code")
        protected CodeableConcept code;

        /**
         * A description of why this action is necessary or appropriate.
         */
        @Child(name = "reason", type = {CodeableConcept.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Why the action should be performed", formalDefinition="A description of why this action is necessary or appropriate." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-reason-code")
        protected List<CodeableConcept> reason;

        /**
         * Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.
         */
        @Child(name = "documentation", type = {RelatedArtifact.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Supporting documentation for the intended performer of the action", formalDefinition="Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources." )
        protected List<RelatedArtifact> documentation;

        /**
         * Identifies goals that this action supports. The reference must be to a goal element defined within this plan definition. In pharmaceutical quality, a goal represents acceptance criteria (Goal) for a given action (Test), so the goalId would be the unique id of a defined goal element establishing the acceptance criteria for the action.
         */
        @Child(name = "goalId", type = {IdType.class}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What goals this action supports", formalDefinition="Identifies goals that this action supports. The reference must be to a goal element defined within this plan definition. In pharmaceutical quality, a goal represents acceptance criteria (Goal) for a given action (Test), so the goalId would be the unique id of a defined goal element establishing the acceptance criteria for the action." )
        protected List<IdType> goalId;

        /**
         * A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.
         */
        @Child(name = "subject", type = {CodeableConcept.class, Group.class, CanonicalType.class}, order=11, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Type of individual the action is focused on", formalDefinition="A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participant-resource-types")
        protected DataType subject;

        /**
         * A description of when the action should be triggered. When multiple triggers are specified on an action, any triggering event invokes the action.
         */
        @Child(name = "trigger", type = {TriggerDefinition.class}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="When the action should be triggered", formalDefinition="A description of when the action should be triggered. When multiple triggers are specified on an action, any triggering event invokes the action." )
        protected List<TriggerDefinition> trigger;

        /**
         * An expression that describes applicability criteria or start/stop conditions for the action.
         */
        @Child(name = "condition", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Whether or not the action is applicable", formalDefinition="An expression that describes applicability criteria or start/stop conditions for the action." )
        protected List<PlanDefinitionActionConditionComponent> condition;

        /**
         * Defines input data requirements for the action.
         */
        @Child(name = "input", type = {}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Input data requirements", formalDefinition="Defines input data requirements for the action." )
        protected List<PlanDefinitionActionInputComponent> input;

        /**
         * Defines the outputs of the action, if any.
         */
        @Child(name = "output", type = {}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Output data definition", formalDefinition="Defines the outputs of the action, if any." )
        protected List<PlanDefinitionActionOutputComponent> output;

        /**
         * A relationship to another action such as "before" or "30-60 minutes after start of".
         */
        @Child(name = "relatedAction", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Relationship to another action", formalDefinition="A relationship to another action such as \"before\" or \"30-60 minutes after start of\"." )
        protected List<PlanDefinitionActionRelatedActionComponent> relatedAction;

        /**
         * An optional value describing when the action should be performed.
         */
        @Child(name = "timing", type = {Age.class, Duration.class, Range.class, Timing.class}, order=17, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the action should take place", formalDefinition="An optional value describing when the action should be performed." )
        protected DataType timing;

        /**
         * Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc.
         */
        @Child(name = "location", type = {CodeableReference.class}, order=18, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Where it should happen", formalDefinition="Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc." )
        protected CodeableReference location;

        /**
         * Indicates who should participate in performing the action described.
         */
        @Child(name = "participant", type = {}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Who should participate in the action", formalDefinition="Indicates who should participate in performing the action described." )
        protected List<PlanDefinitionActionParticipantComponent> participant;

        /**
         * The type of action to perform (create, update, remove).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=20, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="create | update | remove | fire-event", formalDefinition="The type of action to perform (create, update, remove)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-type")
        protected CodeableConcept type;

        /**
         * Defines the grouping behavior for the action and its children.
         */
        @Child(name = "groupingBehavior", type = {CodeType.class}, order=21, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="visual-group | logical-group | sentence-group", formalDefinition="Defines the grouping behavior for the action and its children." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-grouping-behavior")
        protected Enumeration<ActionGroupingBehavior> groupingBehavior;

        /**
         * Defines the selection behavior for the action and its children.
         */
        @Child(name = "selectionBehavior", type = {CodeType.class}, order=22, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="any | all | all-or-none | exactly-one | at-most-one | one-or-more", formalDefinition="Defines the selection behavior for the action and its children." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-selection-behavior")
        protected Enumeration<ActionSelectionBehavior> selectionBehavior;

        /**
         * Defines the required behavior for the action.
         */
        @Child(name = "requiredBehavior", type = {CodeType.class}, order=23, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="must | could | must-unless-documented", formalDefinition="Defines the required behavior for the action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-required-behavior")
        protected Enumeration<ActionRequiredBehavior> requiredBehavior;

        /**
         * Defines whether the action should usually be preselected.
         */
        @Child(name = "precheckBehavior", type = {CodeType.class}, order=24, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="yes | no", formalDefinition="Defines whether the action should usually be preselected." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-precheck-behavior")
        protected Enumeration<ActionPrecheckBehavior> precheckBehavior;

        /**
         * Defines whether the action can be selected multiple times.
         */
        @Child(name = "cardinalityBehavior", type = {CodeType.class}, order=25, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="single | multiple", formalDefinition="Defines whether the action can be selected multiple times." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-cardinality-behavior")
        protected Enumeration<ActionCardinalityBehavior> cardinalityBehavior;

        /**
         * A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.
         */
        @Child(name = "definition", type = {CanonicalType.class, UriType.class}, order=26, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the activity to be performed", formalDefinition="A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured." )
        protected DataType definition;

        /**
         * A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.
         */
        @Child(name = "transform", type = {CanonicalType.class}, order=27, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Transform to apply the template", formalDefinition="A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input." )
        protected CanonicalType transform;

        /**
         * Customizations that should be applied to the statically defined resource. For example, if the dosage of a medication must be computed based on the patient's weight, a customization would be used to specify an expression that calculated the weight, and the path on the resource that would contain the result.
         */
        @Child(name = "dynamicValue", type = {}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Dynamic aspects of the definition", formalDefinition="Customizations that should be applied to the statically defined resource. For example, if the dosage of a medication must be computed based on the patient's weight, a customization would be used to specify an expression that calculated the weight, and the path on the resource that would contain the result." )
        protected List<PlanDefinitionActionDynamicValueComponent> dynamicValue;

        /**
         * Sub actions that are contained within the action. The behavior of this action determines the functionality of the sub-actions. For example, a selection behavior of at-most-one indicates that of the sub-actions, at most one may be chosen as part of realizing the action definition.
         */
        @Child(name = "action", type = {PlanDefinitionActionComponent.class}, order=29, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="A sub-action", formalDefinition="Sub actions that are contained within the action. The behavior of this action determines the functionality of the sub-actions. For example, a selection behavior of at-most-one indicates that of the sub-actions, at most one may be chosen as part of realizing the action definition." )
        protected List<PlanDefinitionActionComponent> action;

        private static final long serialVersionUID = 1296604536L;

    /**
     * Constructor
     */
      public PlanDefinitionActionComponent() {
        super();
      }

        /**
         * @return {@link #linkId} (An identifier that is unique within the PlanDefinition to allow linkage within the realized CarePlan and/or RequestOrchestration.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StringType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.linkId");
            else if (Configuration.doAutoCreate())
              this.linkId = new StringType(); // bb
          return this.linkId;
        }

        public boolean hasLinkIdElement() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        public boolean hasLinkId() { 
          return this.linkId != null && !this.linkId.isEmpty();
        }

        /**
         * @param value {@link #linkId} (An identifier that is unique within the PlanDefinition to allow linkage within the realized CarePlan and/or RequestOrchestration.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public PlanDefinitionActionComponent setLinkIdElement(StringType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return An identifier that is unique within the PlanDefinition to allow linkage within the realized CarePlan and/or RequestOrchestration.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value An identifier that is unique within the PlanDefinition to allow linkage within the realized CarePlan and/or RequestOrchestration.
         */
        public PlanDefinitionActionComponent setLinkId(String value) { 
          if (Utilities.noString(value))
            this.linkId = null;
          else {
            if (this.linkId == null)
              this.linkId = new StringType();
            this.linkId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #prefix} (A user-visible prefix for the action. For example a section or item numbering such as 1. or A.). This is the underlying object with id, value and extensions. The accessor "getPrefix" gives direct access to the value
         */
        public StringType getPrefixElement() { 
          if (this.prefix == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.prefix");
            else if (Configuration.doAutoCreate())
              this.prefix = new StringType(); // bb
          return this.prefix;
        }

        public boolean hasPrefixElement() { 
          return this.prefix != null && !this.prefix.isEmpty();
        }

        public boolean hasPrefix() { 
          return this.prefix != null && !this.prefix.isEmpty();
        }

        /**
         * @param value {@link #prefix} (A user-visible prefix for the action. For example a section or item numbering such as 1. or A.). This is the underlying object with id, value and extensions. The accessor "getPrefix" gives direct access to the value
         */
        public PlanDefinitionActionComponent setPrefixElement(StringType value) { 
          this.prefix = value;
          return this;
        }

        /**
         * @return A user-visible prefix for the action. For example a section or item numbering such as 1. or A.
         */
        public String getPrefix() { 
          return this.prefix == null ? null : this.prefix.getValue();
        }

        /**
         * @param value A user-visible prefix for the action. For example a section or item numbering such as 1. or A.
         */
        public PlanDefinitionActionComponent setPrefix(String value) { 
          if (Utilities.noString(value))
            this.prefix = null;
          else {
            if (this.prefix == null)
              this.prefix = new StringType();
            this.prefix.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #title} (The textual description of the action displayed to a user. For example, when the action is a test to be performed, the title would be the title of the test such as Assay by HPLC.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.title");
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
         * @param value {@link #title} (The textual description of the action displayed to a user. For example, when the action is a test to be performed, the title would be the title of the test such as Assay by HPLC.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public PlanDefinitionActionComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return The textual description of the action displayed to a user. For example, when the action is a test to be performed, the title would be the title of the test such as Assay by HPLC.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value The textual description of the action displayed to a user. For example, when the action is a test to be performed, the title would be the title of the test such as Assay by HPLC.
         */
        public PlanDefinitionActionComponent setTitle(String value) { 
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
         * @return {@link #description} (A brief description of the action used to provide a summary to display to the user.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.description");
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
         * @param value {@link #description} (A brief description of the action used to provide a summary to display to the user.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public PlanDefinitionActionComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A brief description of the action used to provide a summary to display to the user.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A brief description of the action used to provide a summary to display to the user.
         */
        public PlanDefinitionActionComponent setDescription(String value) { 
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
         * @return {@link #textEquivalent} (A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.). This is the underlying object with id, value and extensions. The accessor "getTextEquivalent" gives direct access to the value
         */
        public MarkdownType getTextEquivalentElement() { 
          if (this.textEquivalent == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.textEquivalent");
            else if (Configuration.doAutoCreate())
              this.textEquivalent = new MarkdownType(); // bb
          return this.textEquivalent;
        }

        public boolean hasTextEquivalentElement() { 
          return this.textEquivalent != null && !this.textEquivalent.isEmpty();
        }

        public boolean hasTextEquivalent() { 
          return this.textEquivalent != null && !this.textEquivalent.isEmpty();
        }

        /**
         * @param value {@link #textEquivalent} (A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.). This is the underlying object with id, value and extensions. The accessor "getTextEquivalent" gives direct access to the value
         */
        public PlanDefinitionActionComponent setTextEquivalentElement(MarkdownType value) { 
          this.textEquivalent = value;
          return this;
        }

        /**
         * @return A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.
         */
        public String getTextEquivalent() { 
          return this.textEquivalent == null ? null : this.textEquivalent.getValue();
        }

        /**
         * @param value A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.
         */
        public PlanDefinitionActionComponent setTextEquivalent(String value) { 
          if (Utilities.noString(value))
            this.textEquivalent = null;
          else {
            if (this.textEquivalent == null)
              this.textEquivalent = new MarkdownType();
            this.textEquivalent.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #priority} (Indicates how quickly the action should be addressed with respect to other actions.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
         */
        public Enumeration<RequestPriority> getPriorityElement() { 
          if (this.priority == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.priority");
            else if (Configuration.doAutoCreate())
              this.priority = new Enumeration<RequestPriority>(new RequestPriorityEnumFactory()); // bb
          return this.priority;
        }

        public boolean hasPriorityElement() { 
          return this.priority != null && !this.priority.isEmpty();
        }

        public boolean hasPriority() { 
          return this.priority != null && !this.priority.isEmpty();
        }

        /**
         * @param value {@link #priority} (Indicates how quickly the action should be addressed with respect to other actions.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
         */
        public PlanDefinitionActionComponent setPriorityElement(Enumeration<RequestPriority> value) { 
          this.priority = value;
          return this;
        }

        /**
         * @return Indicates how quickly the action should be addressed with respect to other actions.
         */
        public RequestPriority getPriority() { 
          return this.priority == null ? null : this.priority.getValue();
        }

        /**
         * @param value Indicates how quickly the action should be addressed with respect to other actions.
         */
        public PlanDefinitionActionComponent setPriority(RequestPriority value) { 
          if (value == null)
            this.priority = null;
          else {
            if (this.priority == null)
              this.priority = new Enumeration<RequestPriority>(new RequestPriorityEnumFactory());
            this.priority.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #code} (A code that provides a meaning, grouping, or classification for the action or action group. For example, a section may have a LOINC code for the section of a documentation template. In pharmaceutical quality, an action (Test) such as pH could be classified as a physical property.)
         */
        public CodeableConcept getCode() { 
          if (this.code == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.code");
            else if (Configuration.doAutoCreate())
              this.code = new CodeableConcept(); // cc
          return this.code;
        }

        public boolean hasCode() { 
          return this.code != null && !this.code.isEmpty();
        }

        /**
         * @param value {@link #code} (A code that provides a meaning, grouping, or classification for the action or action group. For example, a section may have a LOINC code for the section of a documentation template. In pharmaceutical quality, an action (Test) such as pH could be classified as a physical property.)
         */
        public PlanDefinitionActionComponent setCode(CodeableConcept value) { 
          this.code = value;
          return this;
        }

        /**
         * @return {@link #reason} (A description of why this action is necessary or appropriate.)
         */
        public List<CodeableConcept> getReason() { 
          if (this.reason == null)
            this.reason = new ArrayList<CodeableConcept>();
          return this.reason;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setReason(List<CodeableConcept> theReason) { 
          this.reason = theReason;
          return this;
        }

        public boolean hasReason() { 
          if (this.reason == null)
            return false;
          for (CodeableConcept item : this.reason)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addReason() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.reason == null)
            this.reason = new ArrayList<CodeableConcept>();
          this.reason.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addReason(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.reason == null)
            this.reason = new ArrayList<CodeableConcept>();
          this.reason.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
         */
        public CodeableConcept getReasonFirstRep() { 
          if (getReason().isEmpty()) {
            addReason();
          }
          return getReason().get(0);
        }

        /**
         * @return {@link #documentation} (Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.)
         */
        public List<RelatedArtifact> getDocumentation() { 
          if (this.documentation == null)
            this.documentation = new ArrayList<RelatedArtifact>();
          return this.documentation;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setDocumentation(List<RelatedArtifact> theDocumentation) { 
          this.documentation = theDocumentation;
          return this;
        }

        public boolean hasDocumentation() { 
          if (this.documentation == null)
            return false;
          for (RelatedArtifact item : this.documentation)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RelatedArtifact addDocumentation() { //3
          RelatedArtifact t = new RelatedArtifact();
          if (this.documentation == null)
            this.documentation = new ArrayList<RelatedArtifact>();
          this.documentation.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addDocumentation(RelatedArtifact t) { //3
          if (t == null)
            return this;
          if (this.documentation == null)
            this.documentation = new ArrayList<RelatedArtifact>();
          this.documentation.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #documentation}, creating it if it does not already exist {3}
         */
        public RelatedArtifact getDocumentationFirstRep() { 
          if (getDocumentation().isEmpty()) {
            addDocumentation();
          }
          return getDocumentation().get(0);
        }

        /**
         * @return {@link #goalId} (Identifies goals that this action supports. The reference must be to a goal element defined within this plan definition. In pharmaceutical quality, a goal represents acceptance criteria (Goal) for a given action (Test), so the goalId would be the unique id of a defined goal element establishing the acceptance criteria for the action.)
         */
        public List<IdType> getGoalId() { 
          if (this.goalId == null)
            this.goalId = new ArrayList<IdType>();
          return this.goalId;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setGoalId(List<IdType> theGoalId) { 
          this.goalId = theGoalId;
          return this;
        }

        public boolean hasGoalId() { 
          if (this.goalId == null)
            return false;
          for (IdType item : this.goalId)
            if (!item.isEmpty())
              return true;
          return false;
        }

        /**
         * @return {@link #goalId} (Identifies goals that this action supports. The reference must be to a goal element defined within this plan definition. In pharmaceutical quality, a goal represents acceptance criteria (Goal) for a given action (Test), so the goalId would be the unique id of a defined goal element establishing the acceptance criteria for the action.)
         */
        public IdType addGoalIdElement() {//2 
          IdType t = new IdType();
          if (this.goalId == null)
            this.goalId = new ArrayList<IdType>();
          this.goalId.add(t);
          return t;
        }

        /**
         * @param value {@link #goalId} (Identifies goals that this action supports. The reference must be to a goal element defined within this plan definition. In pharmaceutical quality, a goal represents acceptance criteria (Goal) for a given action (Test), so the goalId would be the unique id of a defined goal element establishing the acceptance criteria for the action.)
         */
        public PlanDefinitionActionComponent addGoalId(String value) { //1
          IdType t = new IdType();
          t.setValue(value);
          if (this.goalId == null)
            this.goalId = new ArrayList<IdType>();
          this.goalId.add(t);
          return this;
        }

        /**
         * @param value {@link #goalId} (Identifies goals that this action supports. The reference must be to a goal element defined within this plan definition. In pharmaceutical quality, a goal represents acceptance criteria (Goal) for a given action (Test), so the goalId would be the unique id of a defined goal element establishing the acceptance criteria for the action.)
         */
        public boolean hasGoalId(String value) { 
          if (this.goalId == null)
            return false;
          for (IdType v : this.goalId)
            if (v.getValue().equals(value)) // id
              return true;
          return false;
        }

        /**
         * @return {@link #subject} (A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
         */
        public DataType getSubject() { 
          return this.subject;
        }

        /**
         * @return {@link #subject} (A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
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
         * @return {@link #subject} (A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
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

        /**
         * @return {@link #subject} (A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
         */
        public CanonicalType getSubjectCanonicalType() throws FHIRException { 
          if (this.subject == null)
            this.subject = new CanonicalType();
          if (!(this.subject instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.subject.getClass().getName()+" was encountered");
          return (CanonicalType) this.subject;
        }

        public boolean hasSubjectCanonicalType() { 
          return this != null && this.subject instanceof CanonicalType;
        }

        public boolean hasSubject() { 
          return this.subject != null && !this.subject.isEmpty();
        }

        /**
         * @param value {@link #subject} (A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
         */
        public PlanDefinitionActionComponent setSubject(DataType value) { 
          if (value != null && !(value instanceof CodeableConcept || value instanceof Reference || value instanceof CanonicalType))
            throw new FHIRException("Not the right type for PlanDefinition.action.subject[x]: "+value.fhirType());
          this.subject = value;
          return this;
        }

        /**
         * @return {@link #trigger} (A description of when the action should be triggered. When multiple triggers are specified on an action, any triggering event invokes the action.)
         */
        public List<TriggerDefinition> getTrigger() { 
          if (this.trigger == null)
            this.trigger = new ArrayList<TriggerDefinition>();
          return this.trigger;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setTrigger(List<TriggerDefinition> theTrigger) { 
          this.trigger = theTrigger;
          return this;
        }

        public boolean hasTrigger() { 
          if (this.trigger == null)
            return false;
          for (TriggerDefinition item : this.trigger)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public TriggerDefinition addTrigger() { //3
          TriggerDefinition t = new TriggerDefinition();
          if (this.trigger == null)
            this.trigger = new ArrayList<TriggerDefinition>();
          this.trigger.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addTrigger(TriggerDefinition t) { //3
          if (t == null)
            return this;
          if (this.trigger == null)
            this.trigger = new ArrayList<TriggerDefinition>();
          this.trigger.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #trigger}, creating it if it does not already exist {3}
         */
        public TriggerDefinition getTriggerFirstRep() { 
          if (getTrigger().isEmpty()) {
            addTrigger();
          }
          return getTrigger().get(0);
        }

        /**
         * @return {@link #condition} (An expression that describes applicability criteria or start/stop conditions for the action.)
         */
        public List<PlanDefinitionActionConditionComponent> getCondition() { 
          if (this.condition == null)
            this.condition = new ArrayList<PlanDefinitionActionConditionComponent>();
          return this.condition;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setCondition(List<PlanDefinitionActionConditionComponent> theCondition) { 
          this.condition = theCondition;
          return this;
        }

        public boolean hasCondition() { 
          if (this.condition == null)
            return false;
          for (PlanDefinitionActionConditionComponent item : this.condition)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PlanDefinitionActionConditionComponent addCondition() { //3
          PlanDefinitionActionConditionComponent t = new PlanDefinitionActionConditionComponent();
          if (this.condition == null)
            this.condition = new ArrayList<PlanDefinitionActionConditionComponent>();
          this.condition.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addCondition(PlanDefinitionActionConditionComponent t) { //3
          if (t == null)
            return this;
          if (this.condition == null)
            this.condition = new ArrayList<PlanDefinitionActionConditionComponent>();
          this.condition.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #condition}, creating it if it does not already exist {3}
         */
        public PlanDefinitionActionConditionComponent getConditionFirstRep() { 
          if (getCondition().isEmpty()) {
            addCondition();
          }
          return getCondition().get(0);
        }

        /**
         * @return {@link #input} (Defines input data requirements for the action.)
         */
        public List<PlanDefinitionActionInputComponent> getInput() { 
          if (this.input == null)
            this.input = new ArrayList<PlanDefinitionActionInputComponent>();
          return this.input;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setInput(List<PlanDefinitionActionInputComponent> theInput) { 
          this.input = theInput;
          return this;
        }

        public boolean hasInput() { 
          if (this.input == null)
            return false;
          for (PlanDefinitionActionInputComponent item : this.input)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PlanDefinitionActionInputComponent addInput() { //3
          PlanDefinitionActionInputComponent t = new PlanDefinitionActionInputComponent();
          if (this.input == null)
            this.input = new ArrayList<PlanDefinitionActionInputComponent>();
          this.input.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addInput(PlanDefinitionActionInputComponent t) { //3
          if (t == null)
            return this;
          if (this.input == null)
            this.input = new ArrayList<PlanDefinitionActionInputComponent>();
          this.input.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #input}, creating it if it does not already exist {3}
         */
        public PlanDefinitionActionInputComponent getInputFirstRep() { 
          if (getInput().isEmpty()) {
            addInput();
          }
          return getInput().get(0);
        }

        /**
         * @return {@link #output} (Defines the outputs of the action, if any.)
         */
        public List<PlanDefinitionActionOutputComponent> getOutput() { 
          if (this.output == null)
            this.output = new ArrayList<PlanDefinitionActionOutputComponent>();
          return this.output;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setOutput(List<PlanDefinitionActionOutputComponent> theOutput) { 
          this.output = theOutput;
          return this;
        }

        public boolean hasOutput() { 
          if (this.output == null)
            return false;
          for (PlanDefinitionActionOutputComponent item : this.output)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PlanDefinitionActionOutputComponent addOutput() { //3
          PlanDefinitionActionOutputComponent t = new PlanDefinitionActionOutputComponent();
          if (this.output == null)
            this.output = new ArrayList<PlanDefinitionActionOutputComponent>();
          this.output.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addOutput(PlanDefinitionActionOutputComponent t) { //3
          if (t == null)
            return this;
          if (this.output == null)
            this.output = new ArrayList<PlanDefinitionActionOutputComponent>();
          this.output.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #output}, creating it if it does not already exist {3}
         */
        public PlanDefinitionActionOutputComponent getOutputFirstRep() { 
          if (getOutput().isEmpty()) {
            addOutput();
          }
          return getOutput().get(0);
        }

        /**
         * @return {@link #relatedAction} (A relationship to another action such as "before" or "30-60 minutes after start of".)
         */
        public List<PlanDefinitionActionRelatedActionComponent> getRelatedAction() { 
          if (this.relatedAction == null)
            this.relatedAction = new ArrayList<PlanDefinitionActionRelatedActionComponent>();
          return this.relatedAction;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setRelatedAction(List<PlanDefinitionActionRelatedActionComponent> theRelatedAction) { 
          this.relatedAction = theRelatedAction;
          return this;
        }

        public boolean hasRelatedAction() { 
          if (this.relatedAction == null)
            return false;
          for (PlanDefinitionActionRelatedActionComponent item : this.relatedAction)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PlanDefinitionActionRelatedActionComponent addRelatedAction() { //3
          PlanDefinitionActionRelatedActionComponent t = new PlanDefinitionActionRelatedActionComponent();
          if (this.relatedAction == null)
            this.relatedAction = new ArrayList<PlanDefinitionActionRelatedActionComponent>();
          this.relatedAction.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addRelatedAction(PlanDefinitionActionRelatedActionComponent t) { //3
          if (t == null)
            return this;
          if (this.relatedAction == null)
            this.relatedAction = new ArrayList<PlanDefinitionActionRelatedActionComponent>();
          this.relatedAction.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #relatedAction}, creating it if it does not already exist {3}
         */
        public PlanDefinitionActionRelatedActionComponent getRelatedActionFirstRep() { 
          if (getRelatedAction().isEmpty()) {
            addRelatedAction();
          }
          return getRelatedAction().get(0);
        }

        /**
         * @return {@link #timing} (An optional value describing when the action should be performed.)
         */
        public DataType getTiming() { 
          return this.timing;
        }

        /**
         * @return {@link #timing} (An optional value describing when the action should be performed.)
         */
        public Age getTimingAge() throws FHIRException { 
          if (this.timing == null)
            this.timing = new Age();
          if (!(this.timing instanceof Age))
            throw new FHIRException("Type mismatch: the type Age was expected, but "+this.timing.getClass().getName()+" was encountered");
          return (Age) this.timing;
        }

        public boolean hasTimingAge() { 
          return this != null && this.timing instanceof Age;
        }

        /**
         * @return {@link #timing} (An optional value describing when the action should be performed.)
         */
        public Duration getTimingDuration() throws FHIRException { 
          if (this.timing == null)
            this.timing = new Duration();
          if (!(this.timing instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.timing.getClass().getName()+" was encountered");
          return (Duration) this.timing;
        }

        public boolean hasTimingDuration() { 
          return this != null && this.timing instanceof Duration;
        }

        /**
         * @return {@link #timing} (An optional value describing when the action should be performed.)
         */
        public Range getTimingRange() throws FHIRException { 
          if (this.timing == null)
            this.timing = new Range();
          if (!(this.timing instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.timing.getClass().getName()+" was encountered");
          return (Range) this.timing;
        }

        public boolean hasTimingRange() { 
          return this != null && this.timing instanceof Range;
        }

        /**
         * @return {@link #timing} (An optional value describing when the action should be performed.)
         */
        public Timing getTimingTiming() throws FHIRException { 
          if (this.timing == null)
            this.timing = new Timing();
          if (!(this.timing instanceof Timing))
            throw new FHIRException("Type mismatch: the type Timing was expected, but "+this.timing.getClass().getName()+" was encountered");
          return (Timing) this.timing;
        }

        public boolean hasTimingTiming() { 
          return this != null && this.timing instanceof Timing;
        }

        public boolean hasTiming() { 
          return this.timing != null && !this.timing.isEmpty();
        }

        /**
         * @param value {@link #timing} (An optional value describing when the action should be performed.)
         */
        public PlanDefinitionActionComponent setTiming(DataType value) { 
          if (value != null && !(value instanceof Age || value instanceof Duration || value instanceof Range || value instanceof Timing))
            throw new FHIRException("Not the right type for PlanDefinition.action.timing[x]: "+value.fhirType());
          this.timing = value;
          return this;
        }

        /**
         * @return {@link #location} (Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc.)
         */
        public CodeableReference getLocation() { 
          if (this.location == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.location");
            else if (Configuration.doAutoCreate())
              this.location = new CodeableReference(); // cc
          return this.location;
        }

        public boolean hasLocation() { 
          return this.location != null && !this.location.isEmpty();
        }

        /**
         * @param value {@link #location} (Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc.)
         */
        public PlanDefinitionActionComponent setLocation(CodeableReference value) { 
          this.location = value;
          return this;
        }

        /**
         * @return {@link #participant} (Indicates who should participate in performing the action described.)
         */
        public List<PlanDefinitionActionParticipantComponent> getParticipant() { 
          if (this.participant == null)
            this.participant = new ArrayList<PlanDefinitionActionParticipantComponent>();
          return this.participant;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setParticipant(List<PlanDefinitionActionParticipantComponent> theParticipant) { 
          this.participant = theParticipant;
          return this;
        }

        public boolean hasParticipant() { 
          if (this.participant == null)
            return false;
          for (PlanDefinitionActionParticipantComponent item : this.participant)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PlanDefinitionActionParticipantComponent addParticipant() { //3
          PlanDefinitionActionParticipantComponent t = new PlanDefinitionActionParticipantComponent();
          if (this.participant == null)
            this.participant = new ArrayList<PlanDefinitionActionParticipantComponent>();
          this.participant.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addParticipant(PlanDefinitionActionParticipantComponent t) { //3
          if (t == null)
            return this;
          if (this.participant == null)
            this.participant = new ArrayList<PlanDefinitionActionParticipantComponent>();
          this.participant.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
         */
        public PlanDefinitionActionParticipantComponent getParticipantFirstRep() { 
          if (getParticipant().isEmpty()) {
            addParticipant();
          }
          return getParticipant().get(0);
        }

        /**
         * @return {@link #type} (The type of action to perform (create, update, remove).)
         */
        public CodeableConcept getType() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new CodeableConcept(); // cc
          return this.type;
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of action to perform (create, update, remove).)
         */
        public PlanDefinitionActionComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #groupingBehavior} (Defines the grouping behavior for the action and its children.). This is the underlying object with id, value and extensions. The accessor "getGroupingBehavior" gives direct access to the value
         */
        public Enumeration<ActionGroupingBehavior> getGroupingBehaviorElement() { 
          if (this.groupingBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.groupingBehavior");
            else if (Configuration.doAutoCreate())
              this.groupingBehavior = new Enumeration<ActionGroupingBehavior>(new ActionGroupingBehaviorEnumFactory()); // bb
          return this.groupingBehavior;
        }

        public boolean hasGroupingBehaviorElement() { 
          return this.groupingBehavior != null && !this.groupingBehavior.isEmpty();
        }

        public boolean hasGroupingBehavior() { 
          return this.groupingBehavior != null && !this.groupingBehavior.isEmpty();
        }

        /**
         * @param value {@link #groupingBehavior} (Defines the grouping behavior for the action and its children.). This is the underlying object with id, value and extensions. The accessor "getGroupingBehavior" gives direct access to the value
         */
        public PlanDefinitionActionComponent setGroupingBehaviorElement(Enumeration<ActionGroupingBehavior> value) { 
          this.groupingBehavior = value;
          return this;
        }

        /**
         * @return Defines the grouping behavior for the action and its children.
         */
        public ActionGroupingBehavior getGroupingBehavior() { 
          return this.groupingBehavior == null ? null : this.groupingBehavior.getValue();
        }

        /**
         * @param value Defines the grouping behavior for the action and its children.
         */
        public PlanDefinitionActionComponent setGroupingBehavior(ActionGroupingBehavior value) { 
          if (value == null)
            this.groupingBehavior = null;
          else {
            if (this.groupingBehavior == null)
              this.groupingBehavior = new Enumeration<ActionGroupingBehavior>(new ActionGroupingBehaviorEnumFactory());
            this.groupingBehavior.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #selectionBehavior} (Defines the selection behavior for the action and its children.). This is the underlying object with id, value and extensions. The accessor "getSelectionBehavior" gives direct access to the value
         */
        public Enumeration<ActionSelectionBehavior> getSelectionBehaviorElement() { 
          if (this.selectionBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.selectionBehavior");
            else if (Configuration.doAutoCreate())
              this.selectionBehavior = new Enumeration<ActionSelectionBehavior>(new ActionSelectionBehaviorEnumFactory()); // bb
          return this.selectionBehavior;
        }

        public boolean hasSelectionBehaviorElement() { 
          return this.selectionBehavior != null && !this.selectionBehavior.isEmpty();
        }

        public boolean hasSelectionBehavior() { 
          return this.selectionBehavior != null && !this.selectionBehavior.isEmpty();
        }

        /**
         * @param value {@link #selectionBehavior} (Defines the selection behavior for the action and its children.). This is the underlying object with id, value and extensions. The accessor "getSelectionBehavior" gives direct access to the value
         */
        public PlanDefinitionActionComponent setSelectionBehaviorElement(Enumeration<ActionSelectionBehavior> value) { 
          this.selectionBehavior = value;
          return this;
        }

        /**
         * @return Defines the selection behavior for the action and its children.
         */
        public ActionSelectionBehavior getSelectionBehavior() { 
          return this.selectionBehavior == null ? null : this.selectionBehavior.getValue();
        }

        /**
         * @param value Defines the selection behavior for the action and its children.
         */
        public PlanDefinitionActionComponent setSelectionBehavior(ActionSelectionBehavior value) { 
          if (value == null)
            this.selectionBehavior = null;
          else {
            if (this.selectionBehavior == null)
              this.selectionBehavior = new Enumeration<ActionSelectionBehavior>(new ActionSelectionBehaviorEnumFactory());
            this.selectionBehavior.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #requiredBehavior} (Defines the required behavior for the action.). This is the underlying object with id, value and extensions. The accessor "getRequiredBehavior" gives direct access to the value
         */
        public Enumeration<ActionRequiredBehavior> getRequiredBehaviorElement() { 
          if (this.requiredBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.requiredBehavior");
            else if (Configuration.doAutoCreate())
              this.requiredBehavior = new Enumeration<ActionRequiredBehavior>(new ActionRequiredBehaviorEnumFactory()); // bb
          return this.requiredBehavior;
        }

        public boolean hasRequiredBehaviorElement() { 
          return this.requiredBehavior != null && !this.requiredBehavior.isEmpty();
        }

        public boolean hasRequiredBehavior() { 
          return this.requiredBehavior != null && !this.requiredBehavior.isEmpty();
        }

        /**
         * @param value {@link #requiredBehavior} (Defines the required behavior for the action.). This is the underlying object with id, value and extensions. The accessor "getRequiredBehavior" gives direct access to the value
         */
        public PlanDefinitionActionComponent setRequiredBehaviorElement(Enumeration<ActionRequiredBehavior> value) { 
          this.requiredBehavior = value;
          return this;
        }

        /**
         * @return Defines the required behavior for the action.
         */
        public ActionRequiredBehavior getRequiredBehavior() { 
          return this.requiredBehavior == null ? null : this.requiredBehavior.getValue();
        }

        /**
         * @param value Defines the required behavior for the action.
         */
        public PlanDefinitionActionComponent setRequiredBehavior(ActionRequiredBehavior value) { 
          if (value == null)
            this.requiredBehavior = null;
          else {
            if (this.requiredBehavior == null)
              this.requiredBehavior = new Enumeration<ActionRequiredBehavior>(new ActionRequiredBehaviorEnumFactory());
            this.requiredBehavior.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #precheckBehavior} (Defines whether the action should usually be preselected.). This is the underlying object with id, value and extensions. The accessor "getPrecheckBehavior" gives direct access to the value
         */
        public Enumeration<ActionPrecheckBehavior> getPrecheckBehaviorElement() { 
          if (this.precheckBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.precheckBehavior");
            else if (Configuration.doAutoCreate())
              this.precheckBehavior = new Enumeration<ActionPrecheckBehavior>(new ActionPrecheckBehaviorEnumFactory()); // bb
          return this.precheckBehavior;
        }

        public boolean hasPrecheckBehaviorElement() { 
          return this.precheckBehavior != null && !this.precheckBehavior.isEmpty();
        }

        public boolean hasPrecheckBehavior() { 
          return this.precheckBehavior != null && !this.precheckBehavior.isEmpty();
        }

        /**
         * @param value {@link #precheckBehavior} (Defines whether the action should usually be preselected.). This is the underlying object with id, value and extensions. The accessor "getPrecheckBehavior" gives direct access to the value
         */
        public PlanDefinitionActionComponent setPrecheckBehaviorElement(Enumeration<ActionPrecheckBehavior> value) { 
          this.precheckBehavior = value;
          return this;
        }

        /**
         * @return Defines whether the action should usually be preselected.
         */
        public ActionPrecheckBehavior getPrecheckBehavior() { 
          return this.precheckBehavior == null ? null : this.precheckBehavior.getValue();
        }

        /**
         * @param value Defines whether the action should usually be preselected.
         */
        public PlanDefinitionActionComponent setPrecheckBehavior(ActionPrecheckBehavior value) { 
          if (value == null)
            this.precheckBehavior = null;
          else {
            if (this.precheckBehavior == null)
              this.precheckBehavior = new Enumeration<ActionPrecheckBehavior>(new ActionPrecheckBehaviorEnumFactory());
            this.precheckBehavior.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #cardinalityBehavior} (Defines whether the action can be selected multiple times.). This is the underlying object with id, value and extensions. The accessor "getCardinalityBehavior" gives direct access to the value
         */
        public Enumeration<ActionCardinalityBehavior> getCardinalityBehaviorElement() { 
          if (this.cardinalityBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.cardinalityBehavior");
            else if (Configuration.doAutoCreate())
              this.cardinalityBehavior = new Enumeration<ActionCardinalityBehavior>(new ActionCardinalityBehaviorEnumFactory()); // bb
          return this.cardinalityBehavior;
        }

        public boolean hasCardinalityBehaviorElement() { 
          return this.cardinalityBehavior != null && !this.cardinalityBehavior.isEmpty();
        }

        public boolean hasCardinalityBehavior() { 
          return this.cardinalityBehavior != null && !this.cardinalityBehavior.isEmpty();
        }

        /**
         * @param value {@link #cardinalityBehavior} (Defines whether the action can be selected multiple times.). This is the underlying object with id, value and extensions. The accessor "getCardinalityBehavior" gives direct access to the value
         */
        public PlanDefinitionActionComponent setCardinalityBehaviorElement(Enumeration<ActionCardinalityBehavior> value) { 
          this.cardinalityBehavior = value;
          return this;
        }

        /**
         * @return Defines whether the action can be selected multiple times.
         */
        public ActionCardinalityBehavior getCardinalityBehavior() { 
          return this.cardinalityBehavior == null ? null : this.cardinalityBehavior.getValue();
        }

        /**
         * @param value Defines whether the action can be selected multiple times.
         */
        public PlanDefinitionActionComponent setCardinalityBehavior(ActionCardinalityBehavior value) { 
          if (value == null)
            this.cardinalityBehavior = null;
          else {
            if (this.cardinalityBehavior == null)
              this.cardinalityBehavior = new Enumeration<ActionCardinalityBehavior>(new ActionCardinalityBehaviorEnumFactory());
            this.cardinalityBehavior.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #definition} (A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.)
         */
        public DataType getDefinition() { 
          return this.definition;
        }

        /**
         * @return {@link #definition} (A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.)
         */
        public CanonicalType getDefinitionCanonicalType() throws FHIRException { 
          if (this.definition == null)
            this.definition = new CanonicalType();
          if (!(this.definition instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.definition.getClass().getName()+" was encountered");
          return (CanonicalType) this.definition;
        }

        public boolean hasDefinitionCanonicalType() { 
          return this != null && this.definition instanceof CanonicalType;
        }

        /**
         * @return {@link #definition} (A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.)
         */
        public UriType getDefinitionUriType() throws FHIRException { 
          if (this.definition == null)
            this.definition = new UriType();
          if (!(this.definition instanceof UriType))
            throw new FHIRException("Type mismatch: the type UriType was expected, but "+this.definition.getClass().getName()+" was encountered");
          return (UriType) this.definition;
        }

        public boolean hasDefinitionUriType() { 
          return this != null && this.definition instanceof UriType;
        }

        public boolean hasDefinition() { 
          return this.definition != null && !this.definition.isEmpty();
        }

        /**
         * @param value {@link #definition} (A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.)
         */
        public PlanDefinitionActionComponent setDefinition(DataType value) { 
          if (value != null && !(value instanceof CanonicalType || value instanceof UriType))
            throw new FHIRException("Not the right type for PlanDefinition.action.definition[x]: "+value.fhirType());
          this.definition = value;
          return this;
        }

        /**
         * @return {@link #transform} (A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.). This is the underlying object with id, value and extensions. The accessor "getTransform" gives direct access to the value
         */
        public CanonicalType getTransformElement() { 
          if (this.transform == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionComponent.transform");
            else if (Configuration.doAutoCreate())
              this.transform = new CanonicalType(); // bb
          return this.transform;
        }

        public boolean hasTransformElement() { 
          return this.transform != null && !this.transform.isEmpty();
        }

        public boolean hasTransform() { 
          return this.transform != null && !this.transform.isEmpty();
        }

        /**
         * @param value {@link #transform} (A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.). This is the underlying object with id, value and extensions. The accessor "getTransform" gives direct access to the value
         */
        public PlanDefinitionActionComponent setTransformElement(CanonicalType value) { 
          this.transform = value;
          return this;
        }

        /**
         * @return A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.
         */
        public String getTransform() { 
          return this.transform == null ? null : this.transform.getValue();
        }

        /**
         * @param value A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.
         */
        public PlanDefinitionActionComponent setTransform(String value) { 
          if (Utilities.noString(value))
            this.transform = null;
          else {
            if (this.transform == null)
              this.transform = new CanonicalType();
            this.transform.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #dynamicValue} (Customizations that should be applied to the statically defined resource. For example, if the dosage of a medication must be computed based on the patient's weight, a customization would be used to specify an expression that calculated the weight, and the path on the resource that would contain the result.)
         */
        public List<PlanDefinitionActionDynamicValueComponent> getDynamicValue() { 
          if (this.dynamicValue == null)
            this.dynamicValue = new ArrayList<PlanDefinitionActionDynamicValueComponent>();
          return this.dynamicValue;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setDynamicValue(List<PlanDefinitionActionDynamicValueComponent> theDynamicValue) { 
          this.dynamicValue = theDynamicValue;
          return this;
        }

        public boolean hasDynamicValue() { 
          if (this.dynamicValue == null)
            return false;
          for (PlanDefinitionActionDynamicValueComponent item : this.dynamicValue)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PlanDefinitionActionDynamicValueComponent addDynamicValue() { //3
          PlanDefinitionActionDynamicValueComponent t = new PlanDefinitionActionDynamicValueComponent();
          if (this.dynamicValue == null)
            this.dynamicValue = new ArrayList<PlanDefinitionActionDynamicValueComponent>();
          this.dynamicValue.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addDynamicValue(PlanDefinitionActionDynamicValueComponent t) { //3
          if (t == null)
            return this;
          if (this.dynamicValue == null)
            this.dynamicValue = new ArrayList<PlanDefinitionActionDynamicValueComponent>();
          this.dynamicValue.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dynamicValue}, creating it if it does not already exist {3}
         */
        public PlanDefinitionActionDynamicValueComponent getDynamicValueFirstRep() { 
          if (getDynamicValue().isEmpty()) {
            addDynamicValue();
          }
          return getDynamicValue().get(0);
        }

        /**
         * @return {@link #action} (Sub actions that are contained within the action. The behavior of this action determines the functionality of the sub-actions. For example, a selection behavior of at-most-one indicates that of the sub-actions, at most one may be chosen as part of realizing the action definition.)
         */
        public List<PlanDefinitionActionComponent> getAction() { 
          if (this.action == null)
            this.action = new ArrayList<PlanDefinitionActionComponent>();
          return this.action;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public PlanDefinitionActionComponent setAction(List<PlanDefinitionActionComponent> theAction) { 
          this.action = theAction;
          return this;
        }

        public boolean hasAction() { 
          if (this.action == null)
            return false;
          for (PlanDefinitionActionComponent item : this.action)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public PlanDefinitionActionComponent addAction() { //3
          PlanDefinitionActionComponent t = new PlanDefinitionActionComponent();
          if (this.action == null)
            this.action = new ArrayList<PlanDefinitionActionComponent>();
          this.action.add(t);
          return t;
        }

        public PlanDefinitionActionComponent addAction(PlanDefinitionActionComponent t) { //3
          if (t == null)
            return this;
          if (this.action == null)
            this.action = new ArrayList<PlanDefinitionActionComponent>();
          this.action.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
         */
        public PlanDefinitionActionComponent getActionFirstRep() { 
          if (getAction().isEmpty()) {
            addAction();
          }
          return getAction().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "string", "An identifier that is unique within the PlanDefinition to allow linkage within the realized CarePlan and/or RequestOrchestration.", 0, 1, linkId));
          children.add(new Property("prefix", "string", "A user-visible prefix for the action. For example a section or item numbering such as 1. or A.", 0, 1, prefix));
          children.add(new Property("title", "string", "The textual description of the action displayed to a user. For example, when the action is a test to be performed, the title would be the title of the test such as Assay by HPLC.", 0, 1, title));
          children.add(new Property("description", "markdown", "A brief description of the action used to provide a summary to display to the user.", 0, 1, description));
          children.add(new Property("textEquivalent", "markdown", "A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.", 0, 1, textEquivalent));
          children.add(new Property("priority", "code", "Indicates how quickly the action should be addressed with respect to other actions.", 0, 1, priority));
          children.add(new Property("code", "CodeableConcept", "A code that provides a meaning, grouping, or classification for the action or action group. For example, a section may have a LOINC code for the section of a documentation template. In pharmaceutical quality, an action (Test) such as pH could be classified as a physical property.", 0, 1, code));
          children.add(new Property("reason", "CodeableConcept", "A description of why this action is necessary or appropriate.", 0, java.lang.Integer.MAX_VALUE, reason));
          children.add(new Property("documentation", "RelatedArtifact", "Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.", 0, java.lang.Integer.MAX_VALUE, documentation));
          children.add(new Property("goalId", "id", "Identifies goals that this action supports. The reference must be to a goal element defined within this plan definition. In pharmaceutical quality, a goal represents acceptance criteria (Goal) for a given action (Test), so the goalId would be the unique id of a defined goal element establishing the acceptance criteria for the action.", 0, java.lang.Integer.MAX_VALUE, goalId));
          children.add(new Property("subject[x]", "CodeableConcept|Reference(Group)|canonical", "A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject));
          children.add(new Property("trigger", "TriggerDefinition", "A description of when the action should be triggered. When multiple triggers are specified on an action, any triggering event invokes the action.", 0, java.lang.Integer.MAX_VALUE, trigger));
          children.add(new Property("condition", "", "An expression that describes applicability criteria or start/stop conditions for the action.", 0, java.lang.Integer.MAX_VALUE, condition));
          children.add(new Property("input", "", "Defines input data requirements for the action.", 0, java.lang.Integer.MAX_VALUE, input));
          children.add(new Property("output", "", "Defines the outputs of the action, if any.", 0, java.lang.Integer.MAX_VALUE, output));
          children.add(new Property("relatedAction", "", "A relationship to another action such as \"before\" or \"30-60 minutes after start of\".", 0, java.lang.Integer.MAX_VALUE, relatedAction));
          children.add(new Property("timing[x]", "Age|Duration|Range|Timing", "An optional value describing when the action should be performed.", 0, 1, timing));
          children.add(new Property("location", "CodeableReference(Location)", "Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc.", 0, 1, location));
          children.add(new Property("participant", "", "Indicates who should participate in performing the action described.", 0, java.lang.Integer.MAX_VALUE, participant));
          children.add(new Property("type", "CodeableConcept", "The type of action to perform (create, update, remove).", 0, 1, type));
          children.add(new Property("groupingBehavior", "code", "Defines the grouping behavior for the action and its children.", 0, 1, groupingBehavior));
          children.add(new Property("selectionBehavior", "code", "Defines the selection behavior for the action and its children.", 0, 1, selectionBehavior));
          children.add(new Property("requiredBehavior", "code", "Defines the required behavior for the action.", 0, 1, requiredBehavior));
          children.add(new Property("precheckBehavior", "code", "Defines whether the action should usually be preselected.", 0, 1, precheckBehavior));
          children.add(new Property("cardinalityBehavior", "code", "Defines whether the action can be selected multiple times.", 0, 1, cardinalityBehavior));
          children.add(new Property("definition[x]", "canonical(ActivityDefinition|MessageDefinition|ObservationDefinition|PlanDefinition|Questionnaire|SpecimenDefinition)|uri", "A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition));
          children.add(new Property("transform", "canonical(StructureMap)", "A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.", 0, 1, transform));
          children.add(new Property("dynamicValue", "", "Customizations that should be applied to the statically defined resource. For example, if the dosage of a medication must be computed based on the patient's weight, a customization would be used to specify an expression that calculated the weight, and the path on the resource that would contain the result.", 0, java.lang.Integer.MAX_VALUE, dynamicValue));
          children.add(new Property("action", "@PlanDefinition.action", "Sub actions that are contained within the action. The behavior of this action determines the functionality of the sub-actions. For example, a selection behavior of at-most-one indicates that of the sub-actions, at most one may be chosen as part of realizing the action definition.", 0, java.lang.Integer.MAX_VALUE, action));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "string", "An identifier that is unique within the PlanDefinition to allow linkage within the realized CarePlan and/or RequestOrchestration.", 0, 1, linkId);
          case -980110702: /*prefix*/  return new Property("prefix", "string", "A user-visible prefix for the action. For example a section or item numbering such as 1. or A.", 0, 1, prefix);
          case 110371416: /*title*/  return new Property("title", "string", "The textual description of the action displayed to a user. For example, when the action is a test to be performed, the title would be the title of the test such as Assay by HPLC.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "A brief description of the action used to provide a summary to display to the user.", 0, 1, description);
          case -900391049: /*textEquivalent*/  return new Property("textEquivalent", "markdown", "A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.", 0, 1, textEquivalent);
          case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly the action should be addressed with respect to other actions.", 0, 1, priority);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that provides a meaning, grouping, or classification for the action or action group. For example, a section may have a LOINC code for the section of a documentation template. In pharmaceutical quality, an action (Test) such as pH could be classified as a physical property.", 0, 1, code);
          case -934964668: /*reason*/  return new Property("reason", "CodeableConcept", "A description of why this action is necessary or appropriate.", 0, java.lang.Integer.MAX_VALUE, reason);
          case 1587405498: /*documentation*/  return new Property("documentation", "RelatedArtifact", "Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.", 0, java.lang.Integer.MAX_VALUE, documentation);
          case -1240658034: /*goalId*/  return new Property("goalId", "id", "Identifies goals that this action supports. The reference must be to a goal element defined within this plan definition. In pharmaceutical quality, a goal represents acceptance criteria (Goal) for a given action (Test), so the goalId would be the unique id of a defined goal element establishing the acceptance criteria for the action.", 0, java.lang.Integer.MAX_VALUE, goalId);
          case -573640748: /*subject[x]*/  return new Property("subject[x]", "CodeableConcept|Reference(Group)|canonical", "A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
          case -1867885268: /*subject*/  return new Property("subject[x]", "CodeableConcept|Reference(Group)|canonical", "A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
          case -1257122603: /*subjectCodeableConcept*/  return new Property("subject[x]", "CodeableConcept", "A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
          case 772938623: /*subjectReference*/  return new Property("subject[x]", "Reference(Group)", "A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
          case -1768521432: /*subjectCanonical*/  return new Property("subject[x]", "canonical", "A code, group definition, or canonical reference that describes the intended subject of the action and its children, if any. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
          case -1059891784: /*trigger*/  return new Property("trigger", "TriggerDefinition", "A description of when the action should be triggered. When multiple triggers are specified on an action, any triggering event invokes the action.", 0, java.lang.Integer.MAX_VALUE, trigger);
          case -861311717: /*condition*/  return new Property("condition", "", "An expression that describes applicability criteria or start/stop conditions for the action.", 0, java.lang.Integer.MAX_VALUE, condition);
          case 100358090: /*input*/  return new Property("input", "", "Defines input data requirements for the action.", 0, java.lang.Integer.MAX_VALUE, input);
          case -1005512447: /*output*/  return new Property("output", "", "Defines the outputs of the action, if any.", 0, java.lang.Integer.MAX_VALUE, output);
          case -384107967: /*relatedAction*/  return new Property("relatedAction", "", "A relationship to another action such as \"before\" or \"30-60 minutes after start of\".", 0, java.lang.Integer.MAX_VALUE, relatedAction);
          case 164632566: /*timing[x]*/  return new Property("timing[x]", "Age|Duration|Range|Timing", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -873664438: /*timing*/  return new Property("timing[x]", "Age|Duration|Range|Timing", "An optional value describing when the action should be performed.", 0, 1, timing);
          case 164607061: /*timingAge*/  return new Property("timing[x]", "Age", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -1327253506: /*timingDuration*/  return new Property("timing[x]", "Duration", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -710871277: /*timingRange*/  return new Property("timing[x]", "Range", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -497554124: /*timingTiming*/  return new Property("timing[x]", "Timing", "An optional value describing when the action should be performed.", 0, 1, timing);
          case 1901043637: /*location*/  return new Property("location", "CodeableReference(Location)", "Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc.", 0, 1, location);
          case 767422259: /*participant*/  return new Property("participant", "", "Indicates who should participate in performing the action described.", 0, java.lang.Integer.MAX_VALUE, participant);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of action to perform (create, update, remove).", 0, 1, type);
          case 586678389: /*groupingBehavior*/  return new Property("groupingBehavior", "code", "Defines the grouping behavior for the action and its children.", 0, 1, groupingBehavior);
          case 168639486: /*selectionBehavior*/  return new Property("selectionBehavior", "code", "Defines the selection behavior for the action and its children.", 0, 1, selectionBehavior);
          case -1163906287: /*requiredBehavior*/  return new Property("requiredBehavior", "code", "Defines the required behavior for the action.", 0, 1, requiredBehavior);
          case -1174249033: /*precheckBehavior*/  return new Property("precheckBehavior", "code", "Defines whether the action should usually be preselected.", 0, 1, precheckBehavior);
          case -922577408: /*cardinalityBehavior*/  return new Property("cardinalityBehavior", "code", "Defines whether the action can be selected multiple times.", 0, 1, cardinalityBehavior);
          case -1139422643: /*definition[x]*/  return new Property("definition[x]", "canonical(ActivityDefinition|MessageDefinition|ObservationDefinition|PlanDefinition|Questionnaire|SpecimenDefinition)|uri", "A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition);
          case -1014418093: /*definition*/  return new Property("definition[x]", "canonical(ActivityDefinition|MessageDefinition|ObservationDefinition|PlanDefinition|Questionnaire|SpecimenDefinition)|uri", "A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition);
          case 933485793: /*definitionCanonical*/  return new Property("definition[x]", "canonical(ActivityDefinition|MessageDefinition|ObservationDefinition|PlanDefinition|Questionnaire|SpecimenDefinition)", "A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition);
          case -1139428583: /*definitionUri*/  return new Property("definition[x]", "uri", "A reference to an ActivityDefinition that describes the action to be taken in detail, a MessageDefinition describing a message to be snet, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition);
          case 1052666732: /*transform*/  return new Property("transform", "canonical(StructureMap)", "A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.", 0, 1, transform);
          case 572625010: /*dynamicValue*/  return new Property("dynamicValue", "", "Customizations that should be applied to the statically defined resource. For example, if the dosage of a medication must be computed based on the patient's weight, a customization would be used to specify an expression that calculated the weight, and the path on the resource that would contain the result.", 0, java.lang.Integer.MAX_VALUE, dynamicValue);
          case -1422950858: /*action*/  return new Property("action", "@PlanDefinition.action", "Sub actions that are contained within the action. The behavior of this action determines the functionality of the sub-actions. For example, a selection behavior of at-most-one indicates that of the sub-actions, at most one may be chosen as part of realizing the action definition.", 0, java.lang.Integer.MAX_VALUE, action);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return this.linkId == null ? new Base[0] : new Base[] {this.linkId}; // StringType
        case -980110702: /*prefix*/ return this.prefix == null ? new Base[0] : new Base[] {this.prefix}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -900391049: /*textEquivalent*/ return this.textEquivalent == null ? new Base[0] : new Base[] {this.textEquivalent}; // MarkdownType
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // Enumeration<RequestPriority>
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableConcept
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : this.documentation.toArray(new Base[this.documentation.size()]); // RelatedArtifact
        case -1240658034: /*goalId*/ return this.goalId == null ? new Base[0] : this.goalId.toArray(new Base[this.goalId.size()]); // IdType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // DataType
        case -1059891784: /*trigger*/ return this.trigger == null ? new Base[0] : this.trigger.toArray(new Base[this.trigger.size()]); // TriggerDefinition
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : this.condition.toArray(new Base[this.condition.size()]); // PlanDefinitionActionConditionComponent
        case 100358090: /*input*/ return this.input == null ? new Base[0] : this.input.toArray(new Base[this.input.size()]); // PlanDefinitionActionInputComponent
        case -1005512447: /*output*/ return this.output == null ? new Base[0] : this.output.toArray(new Base[this.output.size()]); // PlanDefinitionActionOutputComponent
        case -384107967: /*relatedAction*/ return this.relatedAction == null ? new Base[0] : this.relatedAction.toArray(new Base[this.relatedAction.size()]); // PlanDefinitionActionRelatedActionComponent
        case -873664438: /*timing*/ return this.timing == null ? new Base[0] : new Base[] {this.timing}; // DataType
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // CodeableReference
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // PlanDefinitionActionParticipantComponent
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 586678389: /*groupingBehavior*/ return this.groupingBehavior == null ? new Base[0] : new Base[] {this.groupingBehavior}; // Enumeration<ActionGroupingBehavior>
        case 168639486: /*selectionBehavior*/ return this.selectionBehavior == null ? new Base[0] : new Base[] {this.selectionBehavior}; // Enumeration<ActionSelectionBehavior>
        case -1163906287: /*requiredBehavior*/ return this.requiredBehavior == null ? new Base[0] : new Base[] {this.requiredBehavior}; // Enumeration<ActionRequiredBehavior>
        case -1174249033: /*precheckBehavior*/ return this.precheckBehavior == null ? new Base[0] : new Base[] {this.precheckBehavior}; // Enumeration<ActionPrecheckBehavior>
        case -922577408: /*cardinalityBehavior*/ return this.cardinalityBehavior == null ? new Base[0] : new Base[] {this.cardinalityBehavior}; // Enumeration<ActionCardinalityBehavior>
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // DataType
        case 1052666732: /*transform*/ return this.transform == null ? new Base[0] : new Base[] {this.transform}; // CanonicalType
        case 572625010: /*dynamicValue*/ return this.dynamicValue == null ? new Base[0] : this.dynamicValue.toArray(new Base[this.dynamicValue.size()]); // PlanDefinitionActionDynamicValueComponent
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // PlanDefinitionActionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1102667083: // linkId
          this.linkId = TypeConvertor.castToString(value); // StringType
          return value;
        case -980110702: // prefix
          this.prefix = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -900391049: // textEquivalent
          this.textEquivalent = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case -1165461084: // priority
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1587405498: // documentation
          this.getDocumentation().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case -1240658034: // goalId
          this.getGoalId().add(TypeConvertor.castToId(value)); // IdType
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToType(value); // DataType
          return value;
        case -1059891784: // trigger
          this.getTrigger().add(TypeConvertor.castToTriggerDefinition(value)); // TriggerDefinition
          return value;
        case -861311717: // condition
          this.getCondition().add((PlanDefinitionActionConditionComponent) value); // PlanDefinitionActionConditionComponent
          return value;
        case 100358090: // input
          this.getInput().add((PlanDefinitionActionInputComponent) value); // PlanDefinitionActionInputComponent
          return value;
        case -1005512447: // output
          this.getOutput().add((PlanDefinitionActionOutputComponent) value); // PlanDefinitionActionOutputComponent
          return value;
        case -384107967: // relatedAction
          this.getRelatedAction().add((PlanDefinitionActionRelatedActionComponent) value); // PlanDefinitionActionRelatedActionComponent
          return value;
        case -873664438: // timing
          this.timing = TypeConvertor.castToType(value); // DataType
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 767422259: // participant
          this.getParticipant().add((PlanDefinitionActionParticipantComponent) value); // PlanDefinitionActionParticipantComponent
          return value;
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 586678389: // groupingBehavior
          value = new ActionGroupingBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.groupingBehavior = (Enumeration) value; // Enumeration<ActionGroupingBehavior>
          return value;
        case 168639486: // selectionBehavior
          value = new ActionSelectionBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.selectionBehavior = (Enumeration) value; // Enumeration<ActionSelectionBehavior>
          return value;
        case -1163906287: // requiredBehavior
          value = new ActionRequiredBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.requiredBehavior = (Enumeration) value; // Enumeration<ActionRequiredBehavior>
          return value;
        case -1174249033: // precheckBehavior
          value = new ActionPrecheckBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.precheckBehavior = (Enumeration) value; // Enumeration<ActionPrecheckBehavior>
          return value;
        case -922577408: // cardinalityBehavior
          value = new ActionCardinalityBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.cardinalityBehavior = (Enumeration) value; // Enumeration<ActionCardinalityBehavior>
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToType(value); // DataType
          return value;
        case 1052666732: // transform
          this.transform = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 572625010: // dynamicValue
          this.getDynamicValue().add((PlanDefinitionActionDynamicValueComponent) value); // PlanDefinitionActionDynamicValueComponent
          return value;
        case -1422950858: // action
          this.getAction().add((PlanDefinitionActionComponent) value); // PlanDefinitionActionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("prefix")) {
          this.prefix = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("textEquivalent")) {
          this.textEquivalent = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("documentation")) {
          this.getDocumentation().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("goalId")) {
          this.getGoalId().add(TypeConvertor.castToId(value));
        } else if (name.equals("subject[x]")) {
          this.subject = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("trigger")) {
          this.getTrigger().add(TypeConvertor.castToTriggerDefinition(value));
        } else if (name.equals("condition")) {
          this.getCondition().add((PlanDefinitionActionConditionComponent) value);
        } else if (name.equals("input")) {
          this.getInput().add((PlanDefinitionActionInputComponent) value);
        } else if (name.equals("output")) {
          this.getOutput().add((PlanDefinitionActionOutputComponent) value);
        } else if (name.equals("relatedAction")) {
          this.getRelatedAction().add((PlanDefinitionActionRelatedActionComponent) value);
        } else if (name.equals("timing[x]")) {
          this.timing = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("participant")) {
          this.getParticipant().add((PlanDefinitionActionParticipantComponent) value);
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("groupingBehavior")) {
          value = new ActionGroupingBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.groupingBehavior = (Enumeration) value; // Enumeration<ActionGroupingBehavior>
        } else if (name.equals("selectionBehavior")) {
          value = new ActionSelectionBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.selectionBehavior = (Enumeration) value; // Enumeration<ActionSelectionBehavior>
        } else if (name.equals("requiredBehavior")) {
          value = new ActionRequiredBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.requiredBehavior = (Enumeration) value; // Enumeration<ActionRequiredBehavior>
        } else if (name.equals("precheckBehavior")) {
          value = new ActionPrecheckBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.precheckBehavior = (Enumeration) value; // Enumeration<ActionPrecheckBehavior>
        } else if (name.equals("cardinalityBehavior")) {
          value = new ActionCardinalityBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.cardinalityBehavior = (Enumeration) value; // Enumeration<ActionCardinalityBehavior>
        } else if (name.equals("definition[x]")) {
          this.definition = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("transform")) {
          this.transform = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("dynamicValue")) {
          this.getDynamicValue().add((PlanDefinitionActionDynamicValueComponent) value);
        } else if (name.equals("action")) {
          this.getAction().add((PlanDefinitionActionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("linkId")) {
          this.linkId = null;
        } else if (name.equals("prefix")) {
          this.prefix = null;
        } else if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("description")) {
          this.description = null;
        } else if (name.equals("textEquivalent")) {
          this.textEquivalent = null;
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("code")) {
          this.code = null;
        } else if (name.equals("reason")) {
          this.getReason().remove(value);
        } else if (name.equals("documentation")) {
          this.getDocumentation().remove(value);
        } else if (name.equals("goalId")) {
          this.getGoalId().remove(value);
        } else if (name.equals("subject[x]")) {
          this.subject = null;
        } else if (name.equals("trigger")) {
          this.getTrigger().remove(value);
        } else if (name.equals("condition")) {
          this.getCondition().add((PlanDefinitionActionConditionComponent) value);
        } else if (name.equals("input")) {
          this.getInput().add((PlanDefinitionActionInputComponent) value);
        } else if (name.equals("output")) {
          this.getOutput().add((PlanDefinitionActionOutputComponent) value);
        } else if (name.equals("relatedAction")) {
          this.getRelatedAction().add((PlanDefinitionActionRelatedActionComponent) value);
        } else if (name.equals("timing[x]")) {
          this.timing = null;
        } else if (name.equals("location")) {
          this.location = null;
        } else if (name.equals("participant")) {
          this.getParticipant().add((PlanDefinitionActionParticipantComponent) value);
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("groupingBehavior")) {
          value = new ActionGroupingBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.groupingBehavior = (Enumeration) value; // Enumeration<ActionGroupingBehavior>
        } else if (name.equals("selectionBehavior")) {
          value = new ActionSelectionBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.selectionBehavior = (Enumeration) value; // Enumeration<ActionSelectionBehavior>
        } else if (name.equals("requiredBehavior")) {
          value = new ActionRequiredBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.requiredBehavior = (Enumeration) value; // Enumeration<ActionRequiredBehavior>
        } else if (name.equals("precheckBehavior")) {
          value = new ActionPrecheckBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.precheckBehavior = (Enumeration) value; // Enumeration<ActionPrecheckBehavior>
        } else if (name.equals("cardinalityBehavior")) {
          value = new ActionCardinalityBehaviorEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.cardinalityBehavior = (Enumeration) value; // Enumeration<ActionCardinalityBehavior>
        } else if (name.equals("definition[x]")) {
          this.definition = null;
        } else if (name.equals("transform")) {
          this.transform = null;
        } else if (name.equals("dynamicValue")) {
          this.getDynamicValue().add((PlanDefinitionActionDynamicValueComponent) value);
        } else if (name.equals("action")) {
          this.getAction().add((PlanDefinitionActionComponent) value);
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083:  return getLinkIdElement();
        case -980110702:  return getPrefixElement();
        case 110371416:  return getTitleElement();
        case -1724546052:  return getDescriptionElement();
        case -900391049:  return getTextEquivalentElement();
        case -1165461084:  return getPriorityElement();
        case 3059181:  return getCode();
        case -934964668:  return addReason(); 
        case 1587405498:  return addDocumentation(); 
        case -1240658034:  return addGoalIdElement();
        case -573640748:  return getSubject();
        case -1867885268:  return getSubject();
        case -1059891784:  return addTrigger(); 
        case -861311717:  return addCondition(); 
        case 100358090:  return addInput(); 
        case -1005512447:  return addOutput(); 
        case -384107967:  return addRelatedAction(); 
        case 164632566:  return getTiming();
        case -873664438:  return getTiming();
        case 1901043637:  return getLocation();
        case 767422259:  return addParticipant(); 
        case 3575610:  return getType();
        case 586678389:  return getGroupingBehaviorElement();
        case 168639486:  return getSelectionBehaviorElement();
        case -1163906287:  return getRequiredBehaviorElement();
        case -1174249033:  return getPrecheckBehaviorElement();
        case -922577408:  return getCardinalityBehaviorElement();
        case -1139422643:  return getDefinition();
        case -1014418093:  return getDefinition();
        case 1052666732:  return getTransformElement();
        case 572625010:  return addDynamicValue(); 
        case -1422950858:  return addAction(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1102667083: /*linkId*/ return new String[] {"string"};
        case -980110702: /*prefix*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -900391049: /*textEquivalent*/ return new String[] {"markdown"};
        case -1165461084: /*priority*/ return new String[] {"code"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -934964668: /*reason*/ return new String[] {"CodeableConcept"};
        case 1587405498: /*documentation*/ return new String[] {"RelatedArtifact"};
        case -1240658034: /*goalId*/ return new String[] {"id"};
        case -1867885268: /*subject*/ return new String[] {"CodeableConcept", "Reference", "canonical"};
        case -1059891784: /*trigger*/ return new String[] {"TriggerDefinition"};
        case -861311717: /*condition*/ return new String[] {};
        case 100358090: /*input*/ return new String[] {};
        case -1005512447: /*output*/ return new String[] {};
        case -384107967: /*relatedAction*/ return new String[] {};
        case -873664438: /*timing*/ return new String[] {"Age", "Duration", "Range", "Timing"};
        case 1901043637: /*location*/ return new String[] {"CodeableReference"};
        case 767422259: /*participant*/ return new String[] {};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 586678389: /*groupingBehavior*/ return new String[] {"code"};
        case 168639486: /*selectionBehavior*/ return new String[] {"code"};
        case -1163906287: /*requiredBehavior*/ return new String[] {"code"};
        case -1174249033: /*precheckBehavior*/ return new String[] {"code"};
        case -922577408: /*cardinalityBehavior*/ return new String[] {"code"};
        case -1014418093: /*definition*/ return new String[] {"canonical", "uri"};
        case 1052666732: /*transform*/ return new String[] {"canonical"};
        case 572625010: /*dynamicValue*/ return new String[] {};
        case -1422950858: /*action*/ return new String[] {"@PlanDefinition.action"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.linkId");
        }
        else if (name.equals("prefix")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.prefix");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.description");
        }
        else if (name.equals("textEquivalent")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.textEquivalent");
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.priority");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("documentation")) {
          return addDocumentation();
        }
        else if (name.equals("goalId")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.goalId");
        }
        else if (name.equals("subjectCodeableConcept")) {
          this.subject = new CodeableConcept();
          return this.subject;
        }
        else if (name.equals("subjectReference")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("subjectCanonical")) {
          this.subject = new CanonicalType();
          return this.subject;
        }
        else if (name.equals("trigger")) {
          return addTrigger();
        }
        else if (name.equals("condition")) {
          return addCondition();
        }
        else if (name.equals("input")) {
          return addInput();
        }
        else if (name.equals("output")) {
          return addOutput();
        }
        else if (name.equals("relatedAction")) {
          return addRelatedAction();
        }
        else if (name.equals("timingAge")) {
          this.timing = new Age();
          return this.timing;
        }
        else if (name.equals("timingDuration")) {
          this.timing = new Duration();
          return this.timing;
        }
        else if (name.equals("timingRange")) {
          this.timing = new Range();
          return this.timing;
        }
        else if (name.equals("timingTiming")) {
          this.timing = new Timing();
          return this.timing;
        }
        else if (name.equals("location")) {
          this.location = new CodeableReference();
          return this.location;
        }
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("groupingBehavior")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.groupingBehavior");
        }
        else if (name.equals("selectionBehavior")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.selectionBehavior");
        }
        else if (name.equals("requiredBehavior")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.requiredBehavior");
        }
        else if (name.equals("precheckBehavior")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.precheckBehavior");
        }
        else if (name.equals("cardinalityBehavior")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.cardinalityBehavior");
        }
        else if (name.equals("definitionCanonical")) {
          this.definition = new CanonicalType();
          return this.definition;
        }
        else if (name.equals("definitionUri")) {
          this.definition = new UriType();
          return this.definition;
        }
        else if (name.equals("transform")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.transform");
        }
        else if (name.equals("dynamicValue")) {
          return addDynamicValue();
        }
        else if (name.equals("action")) {
          return addAction();
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionActionComponent copy() {
        PlanDefinitionActionComponent dst = new PlanDefinitionActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionActionComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.prefix = prefix == null ? null : prefix.copy();
        dst.title = title == null ? null : title.copy();
        dst.description = description == null ? null : description.copy();
        dst.textEquivalent = textEquivalent == null ? null : textEquivalent.copy();
        dst.priority = priority == null ? null : priority.copy();
        dst.code = code == null ? null : code.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : reason)
            dst.reason.add(i.copy());
        };
        if (documentation != null) {
          dst.documentation = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : documentation)
            dst.documentation.add(i.copy());
        };
        if (goalId != null) {
          dst.goalId = new ArrayList<IdType>();
          for (IdType i : goalId)
            dst.goalId.add(i.copy());
        };
        dst.subject = subject == null ? null : subject.copy();
        if (trigger != null) {
          dst.trigger = new ArrayList<TriggerDefinition>();
          for (TriggerDefinition i : trigger)
            dst.trigger.add(i.copy());
        };
        if (condition != null) {
          dst.condition = new ArrayList<PlanDefinitionActionConditionComponent>();
          for (PlanDefinitionActionConditionComponent i : condition)
            dst.condition.add(i.copy());
        };
        if (input != null) {
          dst.input = new ArrayList<PlanDefinitionActionInputComponent>();
          for (PlanDefinitionActionInputComponent i : input)
            dst.input.add(i.copy());
        };
        if (output != null) {
          dst.output = new ArrayList<PlanDefinitionActionOutputComponent>();
          for (PlanDefinitionActionOutputComponent i : output)
            dst.output.add(i.copy());
        };
        if (relatedAction != null) {
          dst.relatedAction = new ArrayList<PlanDefinitionActionRelatedActionComponent>();
          for (PlanDefinitionActionRelatedActionComponent i : relatedAction)
            dst.relatedAction.add(i.copy());
        };
        dst.timing = timing == null ? null : timing.copy();
        dst.location = location == null ? null : location.copy();
        if (participant != null) {
          dst.participant = new ArrayList<PlanDefinitionActionParticipantComponent>();
          for (PlanDefinitionActionParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.groupingBehavior = groupingBehavior == null ? null : groupingBehavior.copy();
        dst.selectionBehavior = selectionBehavior == null ? null : selectionBehavior.copy();
        dst.requiredBehavior = requiredBehavior == null ? null : requiredBehavior.copy();
        dst.precheckBehavior = precheckBehavior == null ? null : precheckBehavior.copy();
        dst.cardinalityBehavior = cardinalityBehavior == null ? null : cardinalityBehavior.copy();
        dst.definition = definition == null ? null : definition.copy();
        dst.transform = transform == null ? null : transform.copy();
        if (dynamicValue != null) {
          dst.dynamicValue = new ArrayList<PlanDefinitionActionDynamicValueComponent>();
          for (PlanDefinitionActionDynamicValueComponent i : dynamicValue)
            dst.dynamicValue.add(i.copy());
        };
        if (action != null) {
          dst.action = new ArrayList<PlanDefinitionActionComponent>();
          for (PlanDefinitionActionComponent i : action)
            dst.action.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionComponent))
          return false;
        PlanDefinitionActionComponent o = (PlanDefinitionActionComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(prefix, o.prefix, true) && compareDeep(title, o.title, true)
           && compareDeep(description, o.description, true) && compareDeep(textEquivalent, o.textEquivalent, true)
           && compareDeep(priority, o.priority, true) && compareDeep(code, o.code, true) && compareDeep(reason, o.reason, true)
           && compareDeep(documentation, o.documentation, true) && compareDeep(goalId, o.goalId, true) && compareDeep(subject, o.subject, true)
           && compareDeep(trigger, o.trigger, true) && compareDeep(condition, o.condition, true) && compareDeep(input, o.input, true)
           && compareDeep(output, o.output, true) && compareDeep(relatedAction, o.relatedAction, true) && compareDeep(timing, o.timing, true)
           && compareDeep(location, o.location, true) && compareDeep(participant, o.participant, true) && compareDeep(type, o.type, true)
           && compareDeep(groupingBehavior, o.groupingBehavior, true) && compareDeep(selectionBehavior, o.selectionBehavior, true)
           && compareDeep(requiredBehavior, o.requiredBehavior, true) && compareDeep(precheckBehavior, o.precheckBehavior, true)
           && compareDeep(cardinalityBehavior, o.cardinalityBehavior, true) && compareDeep(definition, o.definition, true)
           && compareDeep(transform, o.transform, true) && compareDeep(dynamicValue, o.dynamicValue, true)
           && compareDeep(action, o.action, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionComponent))
          return false;
        PlanDefinitionActionComponent o = (PlanDefinitionActionComponent) other_;
        return compareValues(linkId, o.linkId, true) && compareValues(prefix, o.prefix, true) && compareValues(title, o.title, true)
           && compareValues(description, o.description, true) && compareValues(textEquivalent, o.textEquivalent, true)
           && compareValues(priority, o.priority, true) && compareValues(goalId, o.goalId, true) && compareValues(groupingBehavior, o.groupingBehavior, true)
           && compareValues(selectionBehavior, o.selectionBehavior, true) && compareValues(requiredBehavior, o.requiredBehavior, true)
           && compareValues(precheckBehavior, o.precheckBehavior, true) && compareValues(cardinalityBehavior, o.cardinalityBehavior, true)
           && compareValues(transform, o.transform, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, prefix, title, description
          , textEquivalent, priority, code, reason, documentation, goalId, subject, trigger
          , condition, input, output, relatedAction, timing, location, participant, type
          , groupingBehavior, selectionBehavior, requiredBehavior, precheckBehavior, cardinalityBehavior
          , definition, transform, dynamicValue, action);
      }

  public String fhirType() {
    return "PlanDefinition.action";

  }

  }

    @Block()
    public static class PlanDefinitionActionConditionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The kind of condition.
         */
        @Child(name = "kind", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="applicability | start | stop", formalDefinition="The kind of condition." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-condition-kind")
        protected Enumeration<ActionConditionKind> kind;

        /**
         * An expression that returns true or false, indicating whether the condition is satisfied.
         */
        @Child(name = "expression", type = {Expression.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Boolean-valued expression", formalDefinition="An expression that returns true or false, indicating whether the condition is satisfied." )
        protected Expression expression;

        private static final long serialVersionUID = -455150438L;

    /**
     * Constructor
     */
      public PlanDefinitionActionConditionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PlanDefinitionActionConditionComponent(ActionConditionKind kind) {
        super();
        this.setKind(kind);
      }

        /**
         * @return {@link #kind} (The kind of condition.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
         */
        public Enumeration<ActionConditionKind> getKindElement() { 
          if (this.kind == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionConditionComponent.kind");
            else if (Configuration.doAutoCreate())
              this.kind = new Enumeration<ActionConditionKind>(new ActionConditionKindEnumFactory()); // bb
          return this.kind;
        }

        public boolean hasKindElement() { 
          return this.kind != null && !this.kind.isEmpty();
        }

        public boolean hasKind() { 
          return this.kind != null && !this.kind.isEmpty();
        }

        /**
         * @param value {@link #kind} (The kind of condition.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
         */
        public PlanDefinitionActionConditionComponent setKindElement(Enumeration<ActionConditionKind> value) { 
          this.kind = value;
          return this;
        }

        /**
         * @return The kind of condition.
         */
        public ActionConditionKind getKind() { 
          return this.kind == null ? null : this.kind.getValue();
        }

        /**
         * @param value The kind of condition.
         */
        public PlanDefinitionActionConditionComponent setKind(ActionConditionKind value) { 
            if (this.kind == null)
              this.kind = new Enumeration<ActionConditionKind>(new ActionConditionKindEnumFactory());
            this.kind.setValue(value);
          return this;
        }

        /**
         * @return {@link #expression} (An expression that returns true or false, indicating whether the condition is satisfied.)
         */
        public Expression getExpression() { 
          if (this.expression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionConditionComponent.expression");
            else if (Configuration.doAutoCreate())
              this.expression = new Expression(); // cc
          return this.expression;
        }

        public boolean hasExpression() { 
          return this.expression != null && !this.expression.isEmpty();
        }

        /**
         * @param value {@link #expression} (An expression that returns true or false, indicating whether the condition is satisfied.)
         */
        public PlanDefinitionActionConditionComponent setExpression(Expression value) { 
          this.expression = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("kind", "code", "The kind of condition.", 0, 1, kind));
          children.add(new Property("expression", "Expression", "An expression that returns true or false, indicating whether the condition is satisfied.", 0, 1, expression));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3292052: /*kind*/  return new Property("kind", "code", "The kind of condition.", 0, 1, kind);
          case -1795452264: /*expression*/  return new Property("expression", "Expression", "An expression that returns true or false, indicating whether the condition is satisfied.", 0, 1, expression);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3292052: /*kind*/ return this.kind == null ? new Base[0] : new Base[] {this.kind}; // Enumeration<ActionConditionKind>
        case -1795452264: /*expression*/ return this.expression == null ? new Base[0] : new Base[] {this.expression}; // Expression
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3292052: // kind
          value = new ActionConditionKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<ActionConditionKind>
          return value;
        case -1795452264: // expression
          this.expression = TypeConvertor.castToExpression(value); // Expression
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("kind")) {
          value = new ActionConditionKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<ActionConditionKind>
        } else if (name.equals("expression")) {
          this.expression = TypeConvertor.castToExpression(value); // Expression
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("kind")) {
          value = new ActionConditionKindEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.kind = (Enumeration) value; // Enumeration<ActionConditionKind>
        } else if (name.equals("expression")) {
          this.expression = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3292052:  return getKindElement();
        case -1795452264:  return getExpression();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3292052: /*kind*/ return new String[] {"code"};
        case -1795452264: /*expression*/ return new String[] {"Expression"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("kind")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.condition.kind");
        }
        else if (name.equals("expression")) {
          this.expression = new Expression();
          return this.expression;
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionActionConditionComponent copy() {
        PlanDefinitionActionConditionComponent dst = new PlanDefinitionActionConditionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionActionConditionComponent dst) {
        super.copyValues(dst);
        dst.kind = kind == null ? null : kind.copy();
        dst.expression = expression == null ? null : expression.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionConditionComponent))
          return false;
        PlanDefinitionActionConditionComponent o = (PlanDefinitionActionConditionComponent) other_;
        return compareDeep(kind, o.kind, true) && compareDeep(expression, o.expression, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionConditionComponent))
          return false;
        PlanDefinitionActionConditionComponent o = (PlanDefinitionActionConditionComponent) other_;
        return compareValues(kind, o.kind, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(kind, expression);
      }

  public String fhirType() {
    return "PlanDefinition.action.condition";

  }

  }

    @Block()
    public static class PlanDefinitionActionInputComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.
         */
        @Child(name = "title", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="User-visible title", formalDefinition="A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers." )
        protected StringType title;

        /**
         * Defines the data that is to be provided as input to the action.
         */
        @Child(name = "requirement", type = {DataRequirement.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What data is provided", formalDefinition="Defines the data that is to be provided as input to the action." )
        protected DataRequirement requirement;

        /**
         * Points to an existing input or output element that provides data to this input.
         */
        @Child(name = "relatedData", type = {IdType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What data is provided", formalDefinition="Points to an existing input or output element that provides data to this input." )
        protected IdType relatedData;

        private static final long serialVersionUID = -1064046709L;

    /**
     * Constructor
     */
      public PlanDefinitionActionInputComponent() {
        super();
      }

        /**
         * @return {@link #title} (A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionInputComponent.title");
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
         * @param value {@link #title} (A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public PlanDefinitionActionInputComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.
         */
        public PlanDefinitionActionInputComponent setTitle(String value) { 
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
         * @return {@link #requirement} (Defines the data that is to be provided as input to the action.)
         */
        public DataRequirement getRequirement() { 
          if (this.requirement == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionInputComponent.requirement");
            else if (Configuration.doAutoCreate())
              this.requirement = new DataRequirement(); // cc
          return this.requirement;
        }

        public boolean hasRequirement() { 
          return this.requirement != null && !this.requirement.isEmpty();
        }

        /**
         * @param value {@link #requirement} (Defines the data that is to be provided as input to the action.)
         */
        public PlanDefinitionActionInputComponent setRequirement(DataRequirement value) { 
          this.requirement = value;
          return this;
        }

        /**
         * @return {@link #relatedData} (Points to an existing input or output element that provides data to this input.). This is the underlying object with id, value and extensions. The accessor "getRelatedData" gives direct access to the value
         */
        public IdType getRelatedDataElement() { 
          if (this.relatedData == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionInputComponent.relatedData");
            else if (Configuration.doAutoCreate())
              this.relatedData = new IdType(); // bb
          return this.relatedData;
        }

        public boolean hasRelatedDataElement() { 
          return this.relatedData != null && !this.relatedData.isEmpty();
        }

        public boolean hasRelatedData() { 
          return this.relatedData != null && !this.relatedData.isEmpty();
        }

        /**
         * @param value {@link #relatedData} (Points to an existing input or output element that provides data to this input.). This is the underlying object with id, value and extensions. The accessor "getRelatedData" gives direct access to the value
         */
        public PlanDefinitionActionInputComponent setRelatedDataElement(IdType value) { 
          this.relatedData = value;
          return this;
        }

        /**
         * @return Points to an existing input or output element that provides data to this input.
         */
        public String getRelatedData() { 
          return this.relatedData == null ? null : this.relatedData.getValue();
        }

        /**
         * @param value Points to an existing input or output element that provides data to this input.
         */
        public PlanDefinitionActionInputComponent setRelatedData(String value) { 
          if (Utilities.noString(value))
            this.relatedData = null;
          else {
            if (this.relatedData == null)
              this.relatedData = new IdType();
            this.relatedData.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("title", "string", "A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.", 0, 1, title));
          children.add(new Property("requirement", "DataRequirement", "Defines the data that is to be provided as input to the action.", 0, 1, requirement));
          children.add(new Property("relatedData", "id", "Points to an existing input or output element that provides data to this input.", 0, 1, relatedData));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 110371416: /*title*/  return new Property("title", "string", "A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.", 0, 1, title);
          case 363387971: /*requirement*/  return new Property("requirement", "DataRequirement", "Defines the data that is to be provided as input to the action.", 0, 1, requirement);
          case 1112535669: /*relatedData*/  return new Property("relatedData", "id", "Points to an existing input or output element that provides data to this input.", 0, 1, relatedData);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case 363387971: /*requirement*/ return this.requirement == null ? new Base[0] : new Base[] {this.requirement}; // DataRequirement
        case 1112535669: /*relatedData*/ return this.relatedData == null ? new Base[0] : new Base[] {this.relatedData}; // IdType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case 363387971: // requirement
          this.requirement = TypeConvertor.castToDataRequirement(value); // DataRequirement
          return value;
        case 1112535669: // relatedData
          this.relatedData = TypeConvertor.castToId(value); // IdType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("requirement")) {
          this.requirement = TypeConvertor.castToDataRequirement(value); // DataRequirement
        } else if (name.equals("relatedData")) {
          this.relatedData = TypeConvertor.castToId(value); // IdType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("requirement")) {
          this.requirement = null;
        } else if (name.equals("relatedData")) {
          this.relatedData = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416:  return getTitleElement();
        case 363387971:  return getRequirement();
        case 1112535669:  return getRelatedDataElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return new String[] {"string"};
        case 363387971: /*requirement*/ return new String[] {"DataRequirement"};
        case 1112535669: /*relatedData*/ return new String[] {"id"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.input.title");
        }
        else if (name.equals("requirement")) {
          this.requirement = new DataRequirement();
          return this.requirement;
        }
        else if (name.equals("relatedData")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.input.relatedData");
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionActionInputComponent copy() {
        PlanDefinitionActionInputComponent dst = new PlanDefinitionActionInputComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionActionInputComponent dst) {
        super.copyValues(dst);
        dst.title = title == null ? null : title.copy();
        dst.requirement = requirement == null ? null : requirement.copy();
        dst.relatedData = relatedData == null ? null : relatedData.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionInputComponent))
          return false;
        PlanDefinitionActionInputComponent o = (PlanDefinitionActionInputComponent) other_;
        return compareDeep(title, o.title, true) && compareDeep(requirement, o.requirement, true) && compareDeep(relatedData, o.relatedData, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionInputComponent))
          return false;
        PlanDefinitionActionInputComponent o = (PlanDefinitionActionInputComponent) other_;
        return compareValues(title, o.title, true) && compareValues(relatedData, o.relatedData, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(title, requirement, relatedData
          );
      }

  public String fhirType() {
    return "PlanDefinition.action.input";

  }

  }

    @Block()
    public static class PlanDefinitionActionOutputComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.
         */
        @Child(name = "title", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="User-visible title", formalDefinition="A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers." )
        protected StringType title;

        /**
         * Defines the data that results as output from the action.
         */
        @Child(name = "requirement", type = {DataRequirement.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What data is provided", formalDefinition="Defines the data that results as output from the action." )
        protected DataRequirement requirement;

        /**
         * Points to an existing input or output element that is results as output from the action.
         */
        @Child(name = "relatedData", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What data is provided", formalDefinition="Points to an existing input or output element that is results as output from the action." )
        protected StringType relatedData;

        private static final long serialVersionUID = 1822414421L;

    /**
     * Constructor
     */
      public PlanDefinitionActionOutputComponent() {
        super();
      }

        /**
         * @return {@link #title} (A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionOutputComponent.title");
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
         * @param value {@link #title} (A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public PlanDefinitionActionOutputComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.
         */
        public PlanDefinitionActionOutputComponent setTitle(String value) { 
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
         * @return {@link #requirement} (Defines the data that results as output from the action.)
         */
        public DataRequirement getRequirement() { 
          if (this.requirement == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionOutputComponent.requirement");
            else if (Configuration.doAutoCreate())
              this.requirement = new DataRequirement(); // cc
          return this.requirement;
        }

        public boolean hasRequirement() { 
          return this.requirement != null && !this.requirement.isEmpty();
        }

        /**
         * @param value {@link #requirement} (Defines the data that results as output from the action.)
         */
        public PlanDefinitionActionOutputComponent setRequirement(DataRequirement value) { 
          this.requirement = value;
          return this;
        }

        /**
         * @return {@link #relatedData} (Points to an existing input or output element that is results as output from the action.). This is the underlying object with id, value and extensions. The accessor "getRelatedData" gives direct access to the value
         */
        public StringType getRelatedDataElement() { 
          if (this.relatedData == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionOutputComponent.relatedData");
            else if (Configuration.doAutoCreate())
              this.relatedData = new StringType(); // bb
          return this.relatedData;
        }

        public boolean hasRelatedDataElement() { 
          return this.relatedData != null && !this.relatedData.isEmpty();
        }

        public boolean hasRelatedData() { 
          return this.relatedData != null && !this.relatedData.isEmpty();
        }

        /**
         * @param value {@link #relatedData} (Points to an existing input or output element that is results as output from the action.). This is the underlying object with id, value and extensions. The accessor "getRelatedData" gives direct access to the value
         */
        public PlanDefinitionActionOutputComponent setRelatedDataElement(StringType value) { 
          this.relatedData = value;
          return this;
        }

        /**
         * @return Points to an existing input or output element that is results as output from the action.
         */
        public String getRelatedData() { 
          return this.relatedData == null ? null : this.relatedData.getValue();
        }

        /**
         * @param value Points to an existing input or output element that is results as output from the action.
         */
        public PlanDefinitionActionOutputComponent setRelatedData(String value) { 
          if (Utilities.noString(value))
            this.relatedData = null;
          else {
            if (this.relatedData == null)
              this.relatedData = new StringType();
            this.relatedData.setValue(value);
          }
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("title", "string", "A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.", 0, 1, title));
          children.add(new Property("requirement", "DataRequirement", "Defines the data that results as output from the action.", 0, 1, requirement));
          children.add(new Property("relatedData", "string", "Points to an existing input or output element that is results as output from the action.", 0, 1, relatedData));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 110371416: /*title*/  return new Property("title", "string", "A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.", 0, 1, title);
          case 363387971: /*requirement*/  return new Property("requirement", "DataRequirement", "Defines the data that results as output from the action.", 0, 1, requirement);
          case 1112535669: /*relatedData*/  return new Property("relatedData", "string", "Points to an existing input or output element that is results as output from the action.", 0, 1, relatedData);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case 363387971: /*requirement*/ return this.requirement == null ? new Base[0] : new Base[] {this.requirement}; // DataRequirement
        case 1112535669: /*relatedData*/ return this.relatedData == null ? new Base[0] : new Base[] {this.relatedData}; // StringType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case 363387971: // requirement
          this.requirement = TypeConvertor.castToDataRequirement(value); // DataRequirement
          return value;
        case 1112535669: // relatedData
          this.relatedData = TypeConvertor.castToString(value); // StringType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("requirement")) {
          this.requirement = TypeConvertor.castToDataRequirement(value); // DataRequirement
        } else if (name.equals("relatedData")) {
          this.relatedData = TypeConvertor.castToString(value); // StringType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("title")) {
          this.title = null;
        } else if (name.equals("requirement")) {
          this.requirement = null;
        } else if (name.equals("relatedData")) {
          this.relatedData = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416:  return getTitleElement();
        case 363387971:  return getRequirement();
        case 1112535669:  return getRelatedDataElement();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 110371416: /*title*/ return new String[] {"string"};
        case 363387971: /*requirement*/ return new String[] {"DataRequirement"};
        case 1112535669: /*relatedData*/ return new String[] {"string"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.output.title");
        }
        else if (name.equals("requirement")) {
          this.requirement = new DataRequirement();
          return this.requirement;
        }
        else if (name.equals("relatedData")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.output.relatedData");
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionActionOutputComponent copy() {
        PlanDefinitionActionOutputComponent dst = new PlanDefinitionActionOutputComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionActionOutputComponent dst) {
        super.copyValues(dst);
        dst.title = title == null ? null : title.copy();
        dst.requirement = requirement == null ? null : requirement.copy();
        dst.relatedData = relatedData == null ? null : relatedData.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionOutputComponent))
          return false;
        PlanDefinitionActionOutputComponent o = (PlanDefinitionActionOutputComponent) other_;
        return compareDeep(title, o.title, true) && compareDeep(requirement, o.requirement, true) && compareDeep(relatedData, o.relatedData, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionOutputComponent))
          return false;
        PlanDefinitionActionOutputComponent o = (PlanDefinitionActionOutputComponent) other_;
        return compareValues(title, o.title, true) && compareValues(relatedData, o.relatedData, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(title, requirement, relatedData
          );
      }

  public String fhirType() {
    return "PlanDefinition.action.output";

  }

  }

    @Block()
    public static class PlanDefinitionActionRelatedActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The element id of the target related action.
         */
        @Child(name = "targetId", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What action is this related to", formalDefinition="The element id of the target related action." )
        protected IdType targetId;

        /**
         * The relationship of the start of this action to the related action.
         */
        @Child(name = "relationship", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="before | before-start | before-end | concurrent | concurrent-with-start | concurrent-with-end | after | after-start | after-end", formalDefinition="The relationship of the start of this action to the related action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-relationship-type")
        protected Enumeration<ActionRelationshipType> relationship;

        /**
         * The relationship of the end of this action to the related action.
         */
        @Child(name = "endRelationship", type = {CodeType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="before | before-start | before-end | concurrent | concurrent-with-start | concurrent-with-end | after | after-start | after-end", formalDefinition="The relationship of the end of this action to the related action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-relationship-type")
        protected Enumeration<ActionRelationshipType> endRelationship;

        /**
         * A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.
         */
        @Child(name = "offset", type = {Duration.class, Range.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Time offset for the relationship", formalDefinition="A duration or range of durations to apply to the relationship. For example, 30-60 minutes before." )
        protected DataType offset;

        private static final long serialVersionUID = 1997058061L;

    /**
     * Constructor
     */
      public PlanDefinitionActionRelatedActionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public PlanDefinitionActionRelatedActionComponent(String targetId, ActionRelationshipType relationship) {
        super();
        this.setTargetId(targetId);
        this.setRelationship(relationship);
      }

        /**
         * @return {@link #targetId} (The element id of the target related action.). This is the underlying object with id, value and extensions. The accessor "getTargetId" gives direct access to the value
         */
        public IdType getTargetIdElement() { 
          if (this.targetId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionRelatedActionComponent.targetId");
            else if (Configuration.doAutoCreate())
              this.targetId = new IdType(); // bb
          return this.targetId;
        }

        public boolean hasTargetIdElement() { 
          return this.targetId != null && !this.targetId.isEmpty();
        }

        public boolean hasTargetId() { 
          return this.targetId != null && !this.targetId.isEmpty();
        }

        /**
         * @param value {@link #targetId} (The element id of the target related action.). This is the underlying object with id, value and extensions. The accessor "getTargetId" gives direct access to the value
         */
        public PlanDefinitionActionRelatedActionComponent setTargetIdElement(IdType value) { 
          this.targetId = value;
          return this;
        }

        /**
         * @return The element id of the target related action.
         */
        public String getTargetId() { 
          return this.targetId == null ? null : this.targetId.getValue();
        }

        /**
         * @param value The element id of the target related action.
         */
        public PlanDefinitionActionRelatedActionComponent setTargetId(String value) { 
            if (this.targetId == null)
              this.targetId = new IdType();
            this.targetId.setValue(value);
          return this;
        }

        /**
         * @return {@link #relationship} (The relationship of the start of this action to the related action.). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public Enumeration<ActionRelationshipType> getRelationshipElement() { 
          if (this.relationship == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionRelatedActionComponent.relationship");
            else if (Configuration.doAutoCreate())
              this.relationship = new Enumeration<ActionRelationshipType>(new ActionRelationshipTypeEnumFactory()); // bb
          return this.relationship;
        }

        public boolean hasRelationshipElement() { 
          return this.relationship != null && !this.relationship.isEmpty();
        }

        public boolean hasRelationship() { 
          return this.relationship != null && !this.relationship.isEmpty();
        }

        /**
         * @param value {@link #relationship} (The relationship of the start of this action to the related action.). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public PlanDefinitionActionRelatedActionComponent setRelationshipElement(Enumeration<ActionRelationshipType> value) { 
          this.relationship = value;
          return this;
        }

        /**
         * @return The relationship of the start of this action to the related action.
         */
        public ActionRelationshipType getRelationship() { 
          return this.relationship == null ? null : this.relationship.getValue();
        }

        /**
         * @param value The relationship of the start of this action to the related action.
         */
        public PlanDefinitionActionRelatedActionComponent setRelationship(ActionRelationshipType value) { 
            if (this.relationship == null)
              this.relationship = new Enumeration<ActionRelationshipType>(new ActionRelationshipTypeEnumFactory());
            this.relationship.setValue(value);
          return this;
        }

        /**
         * @return {@link #endRelationship} (The relationship of the end of this action to the related action.). This is the underlying object with id, value and extensions. The accessor "getEndRelationship" gives direct access to the value
         */
        public Enumeration<ActionRelationshipType> getEndRelationshipElement() { 
          if (this.endRelationship == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionRelatedActionComponent.endRelationship");
            else if (Configuration.doAutoCreate())
              this.endRelationship = new Enumeration<ActionRelationshipType>(new ActionRelationshipTypeEnumFactory()); // bb
          return this.endRelationship;
        }

        public boolean hasEndRelationshipElement() { 
          return this.endRelationship != null && !this.endRelationship.isEmpty();
        }

        public boolean hasEndRelationship() { 
          return this.endRelationship != null && !this.endRelationship.isEmpty();
        }

        /**
         * @param value {@link #endRelationship} (The relationship of the end of this action to the related action.). This is the underlying object with id, value and extensions. The accessor "getEndRelationship" gives direct access to the value
         */
        public PlanDefinitionActionRelatedActionComponent setEndRelationshipElement(Enumeration<ActionRelationshipType> value) { 
          this.endRelationship = value;
          return this;
        }

        /**
         * @return The relationship of the end of this action to the related action.
         */
        public ActionRelationshipType getEndRelationship() { 
          return this.endRelationship == null ? null : this.endRelationship.getValue();
        }

        /**
         * @param value The relationship of the end of this action to the related action.
         */
        public PlanDefinitionActionRelatedActionComponent setEndRelationship(ActionRelationshipType value) { 
          if (value == null)
            this.endRelationship = null;
          else {
            if (this.endRelationship == null)
              this.endRelationship = new Enumeration<ActionRelationshipType>(new ActionRelationshipTypeEnumFactory());
            this.endRelationship.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #offset} (A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.)
         */
        public DataType getOffset() { 
          return this.offset;
        }

        /**
         * @return {@link #offset} (A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.)
         */
        public Duration getOffsetDuration() throws FHIRException { 
          if (this.offset == null)
            this.offset = new Duration();
          if (!(this.offset instanceof Duration))
            throw new FHIRException("Type mismatch: the type Duration was expected, but "+this.offset.getClass().getName()+" was encountered");
          return (Duration) this.offset;
        }

        public boolean hasOffsetDuration() { 
          return this != null && this.offset instanceof Duration;
        }

        /**
         * @return {@link #offset} (A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.)
         */
        public Range getOffsetRange() throws FHIRException { 
          if (this.offset == null)
            this.offset = new Range();
          if (!(this.offset instanceof Range))
            throw new FHIRException("Type mismatch: the type Range was expected, but "+this.offset.getClass().getName()+" was encountered");
          return (Range) this.offset;
        }

        public boolean hasOffsetRange() { 
          return this != null && this.offset instanceof Range;
        }

        public boolean hasOffset() { 
          return this.offset != null && !this.offset.isEmpty();
        }

        /**
         * @param value {@link #offset} (A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.)
         */
        public PlanDefinitionActionRelatedActionComponent setOffset(DataType value) { 
          if (value != null && !(value instanceof Duration || value instanceof Range))
            throw new FHIRException("Not the right type for PlanDefinition.action.relatedAction.offset[x]: "+value.fhirType());
          this.offset = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("targetId", "id", "The element id of the target related action.", 0, 1, targetId));
          children.add(new Property("relationship", "code", "The relationship of the start of this action to the related action.", 0, 1, relationship));
          children.add(new Property("endRelationship", "code", "The relationship of the end of this action to the related action.", 0, 1, endRelationship));
          children.add(new Property("offset[x]", "Duration|Range", "A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.", 0, 1, offset));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -441951604: /*targetId*/  return new Property("targetId", "id", "The element id of the target related action.", 0, 1, targetId);
          case -261851592: /*relationship*/  return new Property("relationship", "code", "The relationship of the start of this action to the related action.", 0, 1, relationship);
          case -1506024781: /*endRelationship*/  return new Property("endRelationship", "code", "The relationship of the end of this action to the related action.", 0, 1, endRelationship);
          case -1960684787: /*offset[x]*/  return new Property("offset[x]", "Duration|Range", "A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.", 0, 1, offset);
          case -1019779949: /*offset*/  return new Property("offset[x]", "Duration|Range", "A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.", 0, 1, offset);
          case 134075207: /*offsetDuration*/  return new Property("offset[x]", "Duration", "A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.", 0, 1, offset);
          case 1263585386: /*offsetRange*/  return new Property("offset[x]", "Range", "A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.", 0, 1, offset);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -441951604: /*targetId*/ return this.targetId == null ? new Base[0] : new Base[] {this.targetId}; // IdType
        case -261851592: /*relationship*/ return this.relationship == null ? new Base[0] : new Base[] {this.relationship}; // Enumeration<ActionRelationshipType>
        case -1506024781: /*endRelationship*/ return this.endRelationship == null ? new Base[0] : new Base[] {this.endRelationship}; // Enumeration<ActionRelationshipType>
        case -1019779949: /*offset*/ return this.offset == null ? new Base[0] : new Base[] {this.offset}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -441951604: // targetId
          this.targetId = TypeConvertor.castToId(value); // IdType
          return value;
        case -261851592: // relationship
          value = new ActionRelationshipTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<ActionRelationshipType>
          return value;
        case -1506024781: // endRelationship
          value = new ActionRelationshipTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.endRelationship = (Enumeration) value; // Enumeration<ActionRelationshipType>
          return value;
        case -1019779949: // offset
          this.offset = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("targetId")) {
          this.targetId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("relationship")) {
          value = new ActionRelationshipTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<ActionRelationshipType>
        } else if (name.equals("endRelationship")) {
          value = new ActionRelationshipTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.endRelationship = (Enumeration) value; // Enumeration<ActionRelationshipType>
        } else if (name.equals("offset[x]")) {
          this.offset = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("targetId")) {
          this.targetId = null;
        } else if (name.equals("relationship")) {
          value = new ActionRelationshipTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<ActionRelationshipType>
        } else if (name.equals("endRelationship")) {
          value = new ActionRelationshipTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.endRelationship = (Enumeration) value; // Enumeration<ActionRelationshipType>
        } else if (name.equals("offset[x]")) {
          this.offset = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -441951604:  return getTargetIdElement();
        case -261851592:  return getRelationshipElement();
        case -1506024781:  return getEndRelationshipElement();
        case -1960684787:  return getOffset();
        case -1019779949:  return getOffset();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -441951604: /*targetId*/ return new String[] {"id"};
        case -261851592: /*relationship*/ return new String[] {"code"};
        case -1506024781: /*endRelationship*/ return new String[] {"code"};
        case -1019779949: /*offset*/ return new String[] {"Duration", "Range"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("targetId")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.relatedAction.targetId");
        }
        else if (name.equals("relationship")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.relatedAction.relationship");
        }
        else if (name.equals("endRelationship")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.relatedAction.endRelationship");
        }
        else if (name.equals("offsetDuration")) {
          this.offset = new Duration();
          return this.offset;
        }
        else if (name.equals("offsetRange")) {
          this.offset = new Range();
          return this.offset;
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionActionRelatedActionComponent copy() {
        PlanDefinitionActionRelatedActionComponent dst = new PlanDefinitionActionRelatedActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionActionRelatedActionComponent dst) {
        super.copyValues(dst);
        dst.targetId = targetId == null ? null : targetId.copy();
        dst.relationship = relationship == null ? null : relationship.copy();
        dst.endRelationship = endRelationship == null ? null : endRelationship.copy();
        dst.offset = offset == null ? null : offset.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionRelatedActionComponent))
          return false;
        PlanDefinitionActionRelatedActionComponent o = (PlanDefinitionActionRelatedActionComponent) other_;
        return compareDeep(targetId, o.targetId, true) && compareDeep(relationship, o.relationship, true)
           && compareDeep(endRelationship, o.endRelationship, true) && compareDeep(offset, o.offset, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionRelatedActionComponent))
          return false;
        PlanDefinitionActionRelatedActionComponent o = (PlanDefinitionActionRelatedActionComponent) other_;
        return compareValues(targetId, o.targetId, true) && compareValues(relationship, o.relationship, true)
           && compareValues(endRelationship, o.endRelationship, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(targetId, relationship, endRelationship
          , offset);
      }

  public String fhirType() {
    return "PlanDefinition.action.relatedAction";

  }

  }

    @Block()
    public static class PlanDefinitionActionParticipantComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A reference to the id element of the actor who will participate in this action.
         */
        @Child(name = "actorId", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What actor", formalDefinition="A reference to the id element of the actor who will participate in this action." )
        protected StringType actorId;

        /**
         * The type of participant in the action.
         */
        @Child(name = "type", type = {CodeType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="careteam | device | group | healthcareservice | location | organization | patient | practitioner | practitionerrole | relatedperson", formalDefinition="The type of participant in the action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-participant-type")
        protected Enumeration<ActionParticipantType> type;

        /**
         * The type of participant in the action.
         */
        @Child(name = "typeCanonical", type = {CanonicalType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who or what can participate", formalDefinition="The type of participant in the action." )
        protected CanonicalType typeCanonical;

        /**
         * The type of participant in the action.
         */
        @Child(name = "typeReference", type = {CareTeam.class, Device.class, DeviceDefinition.class, Endpoint.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class}, order=4, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who or what can participate", formalDefinition="The type of participant in the action." )
        protected Reference typeReference;

        /**
         * The role the participant should play in performing the described action.
         */
        @Child(name = "role", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="E.g. Nurse, Surgeon, Parent", formalDefinition="The role the participant should play in performing the described action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/action-participant-role")
        protected CodeableConcept role;

        /**
         * Indicates how the actor will be involved in the action - author, reviewer, witness, etc.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="E.g. Author, Reviewer, Witness, etc", formalDefinition="Indicates how the actor will be involved in the action - author, reviewer, witness, etc." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-participant-function")
        protected CodeableConcept function;

        private static final long serialVersionUID = -1467052283L;

    /**
     * Constructor
     */
      public PlanDefinitionActionParticipantComponent() {
        super();
      }

        /**
         * @return {@link #actorId} (A reference to the id element of the actor who will participate in this action.). This is the underlying object with id, value and extensions. The accessor "getActorId" gives direct access to the value
         */
        public StringType getActorIdElement() { 
          if (this.actorId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionParticipantComponent.actorId");
            else if (Configuration.doAutoCreate())
              this.actorId = new StringType(); // bb
          return this.actorId;
        }

        public boolean hasActorIdElement() { 
          return this.actorId != null && !this.actorId.isEmpty();
        }

        public boolean hasActorId() { 
          return this.actorId != null && !this.actorId.isEmpty();
        }

        /**
         * @param value {@link #actorId} (A reference to the id element of the actor who will participate in this action.). This is the underlying object with id, value and extensions. The accessor "getActorId" gives direct access to the value
         */
        public PlanDefinitionActionParticipantComponent setActorIdElement(StringType value) { 
          this.actorId = value;
          return this;
        }

        /**
         * @return A reference to the id element of the actor who will participate in this action.
         */
        public String getActorId() { 
          return this.actorId == null ? null : this.actorId.getValue();
        }

        /**
         * @param value A reference to the id element of the actor who will participate in this action.
         */
        public PlanDefinitionActionParticipantComponent setActorId(String value) { 
          if (Utilities.noString(value))
            this.actorId = null;
          else {
            if (this.actorId == null)
              this.actorId = new StringType();
            this.actorId.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #type} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<ActionParticipantType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionParticipantComponent.type");
            else if (Configuration.doAutoCreate())
              this.type = new Enumeration<ActionParticipantType>(new ActionParticipantTypeEnumFactory()); // bb
          return this.type;
        }

        public boolean hasTypeElement() { 
          return this.type != null && !this.type.isEmpty();
        }

        public boolean hasType() { 
          return this.type != null && !this.type.isEmpty();
        }

        /**
         * @param value {@link #type} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public PlanDefinitionActionParticipantComponent setTypeElement(Enumeration<ActionParticipantType> value) { 
          this.type = value;
          return this;
        }

        /**
         * @return The type of participant in the action.
         */
        public ActionParticipantType getType() { 
          return this.type == null ? null : this.type.getValue();
        }

        /**
         * @param value The type of participant in the action.
         */
        public PlanDefinitionActionParticipantComponent setType(ActionParticipantType value) { 
          if (value == null)
            this.type = null;
          else {
            if (this.type == null)
              this.type = new Enumeration<ActionParticipantType>(new ActionParticipantTypeEnumFactory());
            this.type.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #typeCanonical} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getTypeCanonical" gives direct access to the value
         */
        public CanonicalType getTypeCanonicalElement() { 
          if (this.typeCanonical == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionParticipantComponent.typeCanonical");
            else if (Configuration.doAutoCreate())
              this.typeCanonical = new CanonicalType(); // bb
          return this.typeCanonical;
        }

        public boolean hasTypeCanonicalElement() { 
          return this.typeCanonical != null && !this.typeCanonical.isEmpty();
        }

        public boolean hasTypeCanonical() { 
          return this.typeCanonical != null && !this.typeCanonical.isEmpty();
        }

        /**
         * @param value {@link #typeCanonical} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getTypeCanonical" gives direct access to the value
         */
        public PlanDefinitionActionParticipantComponent setTypeCanonicalElement(CanonicalType value) { 
          this.typeCanonical = value;
          return this;
        }

        /**
         * @return The type of participant in the action.
         */
        public String getTypeCanonical() { 
          return this.typeCanonical == null ? null : this.typeCanonical.getValue();
        }

        /**
         * @param value The type of participant in the action.
         */
        public PlanDefinitionActionParticipantComponent setTypeCanonical(String value) { 
          if (Utilities.noString(value))
            this.typeCanonical = null;
          else {
            if (this.typeCanonical == null)
              this.typeCanonical = new CanonicalType();
            this.typeCanonical.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #typeReference} (The type of participant in the action.)
         */
        public Reference getTypeReference() { 
          if (this.typeReference == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionParticipantComponent.typeReference");
            else if (Configuration.doAutoCreate())
              this.typeReference = new Reference(); // cc
          return this.typeReference;
        }

        public boolean hasTypeReference() { 
          return this.typeReference != null && !this.typeReference.isEmpty();
        }

        /**
         * @param value {@link #typeReference} (The type of participant in the action.)
         */
        public PlanDefinitionActionParticipantComponent setTypeReference(Reference value) { 
          this.typeReference = value;
          return this;
        }

        /**
         * @return {@link #role} (The role the participant should play in performing the described action.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionParticipantComponent.role");
            else if (Configuration.doAutoCreate())
              this.role = new CodeableConcept(); // cc
          return this.role;
        }

        public boolean hasRole() { 
          return this.role != null && !this.role.isEmpty();
        }

        /**
         * @param value {@link #role} (The role the participant should play in performing the described action.)
         */
        public PlanDefinitionActionParticipantComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #function} (Indicates how the actor will be involved in the action - author, reviewer, witness, etc.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionParticipantComponent.function");
            else if (Configuration.doAutoCreate())
              this.function = new CodeableConcept(); // cc
          return this.function;
        }

        public boolean hasFunction() { 
          return this.function != null && !this.function.isEmpty();
        }

        /**
         * @param value {@link #function} (Indicates how the actor will be involved in the action - author, reviewer, witness, etc.)
         */
        public PlanDefinitionActionParticipantComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("actorId", "string", "A reference to the id element of the actor who will participate in this action.", 0, 1, actorId));
          children.add(new Property("type", "code", "The type of participant in the action.", 0, 1, type));
          children.add(new Property("typeCanonical", "canonical(CapabilityStatement)", "The type of participant in the action.", 0, 1, typeCanonical));
          children.add(new Property("typeReference", "Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The type of participant in the action.", 0, 1, typeReference));
          children.add(new Property("role", "CodeableConcept", "The role the participant should play in performing the described action.", 0, 1, role));
          children.add(new Property("function", "CodeableConcept", "Indicates how the actor will be involved in the action - author, reviewer, witness, etc.", 0, 1, function));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1161623056: /*actorId*/  return new Property("actorId", "string", "A reference to the id element of the actor who will participate in this action.", 0, 1, actorId);
          case 3575610: /*type*/  return new Property("type", "code", "The type of participant in the action.", 0, 1, type);
          case -466635046: /*typeCanonical*/  return new Property("typeCanonical", "canonical(CapabilityStatement)", "The type of participant in the action.", 0, 1, typeCanonical);
          case 2074825009: /*typeReference*/  return new Property("typeReference", "Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The type of participant in the action.", 0, 1, typeReference);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "The role the participant should play in performing the described action.", 0, 1, role);
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Indicates how the actor will be involved in the action - author, reviewer, witness, etc.", 0, 1, function);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1161623056: /*actorId*/ return this.actorId == null ? new Base[0] : new Base[] {this.actorId}; // StringType
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // Enumeration<ActionParticipantType>
        case -466635046: /*typeCanonical*/ return this.typeCanonical == null ? new Base[0] : new Base[] {this.typeCanonical}; // CanonicalType
        case 2074825009: /*typeReference*/ return this.typeReference == null ? new Base[0] : new Base[] {this.typeReference}; // Reference
        case 3506294: /*role*/ return this.role == null ? new Base[0] : new Base[] {this.role}; // CodeableConcept
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // CodeableConcept
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1161623056: // actorId
          this.actorId = TypeConvertor.castToString(value); // StringType
          return value;
        case 3575610: // type
          value = new ActionParticipantTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ActionParticipantType>
          return value;
        case -466635046: // typeCanonical
          this.typeCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 2074825009: // typeReference
          this.typeReference = TypeConvertor.castToReference(value); // Reference
          return value;
        case 3506294: // role
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 1380938712: // function
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("actorId")) {
          this.actorId = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("type")) {
          value = new ActionParticipantTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ActionParticipantType>
        } else if (name.equals("typeCanonical")) {
          this.typeCanonical = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("typeReference")) {
          this.typeReference = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("role")) {
          this.role = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("function")) {
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("actorId")) {
          this.actorId = null;
        } else if (name.equals("type")) {
          value = new ActionParticipantTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.type = (Enumeration) value; // Enumeration<ActionParticipantType>
        } else if (name.equals("typeCanonical")) {
          this.typeCanonical = null;
        } else if (name.equals("typeReference")) {
          this.typeReference = null;
        } else if (name.equals("role")) {
          this.role = null;
        } else if (name.equals("function")) {
          this.function = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1161623056:  return getActorIdElement();
        case 3575610:  return getTypeElement();
        case -466635046:  return getTypeCanonicalElement();
        case 2074825009:  return getTypeReference();
        case 3506294:  return getRole();
        case 1380938712:  return getFunction();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1161623056: /*actorId*/ return new String[] {"string"};
        case 3575610: /*type*/ return new String[] {"code"};
        case -466635046: /*typeCanonical*/ return new String[] {"canonical"};
        case 2074825009: /*typeReference*/ return new String[] {"Reference"};
        case 3506294: /*role*/ return new String[] {"CodeableConcept"};
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("actorId")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.participant.actorId");
        }
        else if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.participant.type");
        }
        else if (name.equals("typeCanonical")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.participant.typeCanonical");
        }
        else if (name.equals("typeReference")) {
          this.typeReference = new Reference();
          return this.typeReference;
        }
        else if (name.equals("role")) {
          this.role = new CodeableConcept();
          return this.role;
        }
        else if (name.equals("function")) {
          this.function = new CodeableConcept();
          return this.function;
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionActionParticipantComponent copy() {
        PlanDefinitionActionParticipantComponent dst = new PlanDefinitionActionParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionActionParticipantComponent dst) {
        super.copyValues(dst);
        dst.actorId = actorId == null ? null : actorId.copy();
        dst.type = type == null ? null : type.copy();
        dst.typeCanonical = typeCanonical == null ? null : typeCanonical.copy();
        dst.typeReference = typeReference == null ? null : typeReference.copy();
        dst.role = role == null ? null : role.copy();
        dst.function = function == null ? null : function.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionParticipantComponent))
          return false;
        PlanDefinitionActionParticipantComponent o = (PlanDefinitionActionParticipantComponent) other_;
        return compareDeep(actorId, o.actorId, true) && compareDeep(type, o.type, true) && compareDeep(typeCanonical, o.typeCanonical, true)
           && compareDeep(typeReference, o.typeReference, true) && compareDeep(role, o.role, true) && compareDeep(function, o.function, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionParticipantComponent))
          return false;
        PlanDefinitionActionParticipantComponent o = (PlanDefinitionActionParticipantComponent) other_;
        return compareValues(actorId, o.actorId, true) && compareValues(type, o.type, true) && compareValues(typeCanonical, o.typeCanonical, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(actorId, type, typeCanonical
          , typeReference, role, function);
      }

  public String fhirType() {
    return "PlanDefinition.action.participant";

  }

  }

    @Block()
    public static class PlanDefinitionActionDynamicValueComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
         */
        @Child(name = "path", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The path to the element to be set dynamically", formalDefinition="The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details)." )
        protected StringType path;

        /**
         * An expression specifying the value of the customized element.
         */
        @Child(name = "expression", type = {Expression.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="An expression that provides the dynamic value for the customization", formalDefinition="An expression specifying the value of the customized element." )
        protected Expression expression;

        private static final long serialVersionUID = 1064529082L;

    /**
     * Constructor
     */
      public PlanDefinitionActionDynamicValueComponent() {
        super();
      }

        /**
         * @return {@link #path} (The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionDynamicValueComponent.path");
            else if (Configuration.doAutoCreate())
              this.path = new StringType(); // bb
          return this.path;
        }

        public boolean hasPathElement() { 
          return this.path != null && !this.path.isEmpty();
        }

        public boolean hasPath() { 
          return this.path != null && !this.path.isEmpty();
        }

        /**
         * @param value {@link #path} (The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public PlanDefinitionActionDynamicValueComponent setPathElement(StringType value) { 
          this.path = value;
          return this;
        }

        /**
         * @return The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
         */
        public String getPath() { 
          return this.path == null ? null : this.path.getValue();
        }

        /**
         * @param value The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).
         */
        public PlanDefinitionActionDynamicValueComponent setPath(String value) { 
          if (Utilities.noString(value))
            this.path = null;
          else {
            if (this.path == null)
              this.path = new StringType();
            this.path.setValue(value);
          }
          return this;
        }

        /**
         * @return {@link #expression} (An expression specifying the value of the customized element.)
         */
        public Expression getExpression() { 
          if (this.expression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create PlanDefinitionActionDynamicValueComponent.expression");
            else if (Configuration.doAutoCreate())
              this.expression = new Expression(); // cc
          return this.expression;
        }

        public boolean hasExpression() { 
          return this.expression != null && !this.expression.isEmpty();
        }

        /**
         * @param value {@link #expression} (An expression specifying the value of the customized element.)
         */
        public PlanDefinitionActionDynamicValueComponent setExpression(Expression value) { 
          this.expression = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("path", "string", "The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).", 0, 1, path));
          children.add(new Property("expression", "Expression", "An expression specifying the value of the customized element.", 0, 1, expression));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3433509: /*path*/  return new Property("path", "string", "The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).", 0, 1, path);
          case -1795452264: /*expression*/  return new Property("expression", "Expression", "An expression specifying the value of the customized element.", 0, 1, expression);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return this.path == null ? new Base[0] : new Base[] {this.path}; // StringType
        case -1795452264: /*expression*/ return this.expression == null ? new Base[0] : new Base[] {this.expression}; // Expression
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case 3433509: // path
          this.path = TypeConvertor.castToString(value); // StringType
          return value;
        case -1795452264: // expression
          this.expression = TypeConvertor.castToExpression(value); // Expression
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("expression")) {
          this.expression = TypeConvertor.castToExpression(value); // Expression
        } else
          return super.setProperty(name, value);
        return value;
      }

  @Override
  public void removeChild(String name, Base value) throws FHIRException {
        if (name.equals("path")) {
          this.path = null;
        } else if (name.equals("expression")) {
          this.expression = null;
        } else
          super.removeChild(name, value);
        
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509:  return getPathElement();
        case -1795452264:  return getExpression();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3433509: /*path*/ return new String[] {"string"};
        case -1795452264: /*expression*/ return new String[] {"Expression"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("path")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.action.dynamicValue.path");
        }
        else if (name.equals("expression")) {
          this.expression = new Expression();
          return this.expression;
        }
        else
          return super.addChild(name);
      }

      public PlanDefinitionActionDynamicValueComponent copy() {
        PlanDefinitionActionDynamicValueComponent dst = new PlanDefinitionActionDynamicValueComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinitionActionDynamicValueComponent dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
        dst.expression = expression == null ? null : expression.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionDynamicValueComponent))
          return false;
        PlanDefinitionActionDynamicValueComponent o = (PlanDefinitionActionDynamicValueComponent) other_;
        return compareDeep(path, o.path, true) && compareDeep(expression, o.expression, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinitionActionDynamicValueComponent))
          return false;
        PlanDefinitionActionDynamicValueComponent o = (PlanDefinitionActionDynamicValueComponent) other_;
        return compareValues(path, o.path, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path, expression);
      }

  public String fhirType() {
    return "PlanDefinition.action.dynamicValue";

  }

  }

    /**
     * An absolute URI that is used to identify this plan definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this plan definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the plan definition is stored on different servers.
     */
    @Child(name = "url", type = {UriType.class}, order=0, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Canonical identifier for this plan definition, represented as a URI (globally unique)", formalDefinition="An absolute URI that is used to identify this plan definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this plan definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the plan definition is stored on different servers." )
    protected UriType url;

    /**
     * A formal identifier that is used to identify this plan definition when it is represented in other formats, or referenced in a specification, model, design or an instance.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Additional identifier for the plan definition", formalDefinition="A formal identifier that is used to identify this plan definition when it is represented in other formats, or referenced in a specification, model, design or an instance." )
    protected List<Identifier> identifier;

    /**
     * The identifier that is used to identify this version of the plan definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the plan definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.
     */
    @Child(name = "version", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Business version of the plan definition", formalDefinition="The identifier that is used to identify this version of the plan definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the plan definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts." )
    protected StringType version;

    /**
     * Indicates the mechanism used to compare versions to determine which is more current.
     */
    @Child(name = "versionAlgorithm", type = {StringType.class, Coding.class}, order=3, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="How to compare versions", formalDefinition="Indicates the mechanism used to compare versions to determine which is more current." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/version-algorithm")
    protected DataType versionAlgorithm;

    /**
     * A natural language name identifying the plan definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    @Child(name = "name", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this plan definition (computer friendly)", formalDefinition="A natural language name identifying the plan definition. This name should be usable as an identifier for the module by machine processing applications such as code generation." )
    protected StringType name;

    /**
     * A short, descriptive, user-friendly title for the plan definition.
     */
    @Child(name = "title", type = {StringType.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name for this plan definition (human friendly)", formalDefinition="A short, descriptive, user-friendly title for the plan definition." )
    protected StringType title;

    /**
     * An explanatory or alternate title for the plan definition giving additional information about its content.
     */
    @Child(name = "subtitle", type = {StringType.class}, order=6, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Subordinate title of the plan definition", formalDefinition="An explanatory or alternate title for the plan definition giving additional information about its content." )
    protected StringType subtitle;

    /**
     * A high-level category for the plan definition that distinguishes the kinds of systems that would be interested in the plan definition.
     */
    @Child(name = "type", type = {CodeableConcept.class}, order=7, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="order-set | clinical-protocol | eca-rule | workflow-definition", formalDefinition="A high-level category for the plan definition that distinguishes the kinds of systems that would be interested in the plan definition." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/plan-definition-type")
    protected CodeableConcept type;

    /**
     * The status of this plan definition. Enables tracking the life-cycle of the content.
     */
    @Child(name = "status", type = {CodeType.class}, order=8, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | retired | unknown", formalDefinition="The status of this plan definition. Enables tracking the life-cycle of the content." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/publication-status")
    protected Enumeration<PublicationStatus> status;

    /**
     * A Boolean value to indicate that this plan definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    @Child(name = "experimental", type = {BooleanType.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="For testing purposes, not real usage", formalDefinition="A Boolean value to indicate that this plan definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage." )
    protected BooleanType experimental;

    /**
     * A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.
     */
    @Child(name = "subject", type = {CodeableConcept.class, Group.class, MedicinalProductDefinition.class, SubstanceDefinition.class, AdministrableProductDefinition.class, ManufacturedItemDefinition.class, PackagedProductDefinition.class, CanonicalType.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Type of individual the plan definition is focused on", formalDefinition="A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/participant-resource-types")
    protected DataType subject;

    /**
     * The date  (and optionally time) when the plan definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the plan definition changes.
     */
    @Child(name = "date", type = {DateTimeType.class}, order=11, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Date last changed", formalDefinition="The date  (and optionally time) when the plan definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the plan definition changes." )
    protected DateTimeType date;

    /**
     * The name of the organization or individual responsible for the release and ongoing maintenance of the plan definition.
     */
    @Child(name = "publisher", type = {StringType.class}, order=12, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Name of the publisher/steward (organization or individual)", formalDefinition="The name of the organization or individual responsible for the release and ongoing maintenance of the plan definition." )
    protected StringType publisher;

    /**
     * Contact details to assist a user in finding and communicating with the publisher.
     */
    @Child(name = "contact", type = {ContactDetail.class}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Contact details for the publisher", formalDefinition="Contact details to assist a user in finding and communicating with the publisher." )
    protected List<ContactDetail> contact;

    /**
     * A free text natural language description of the plan definition from a consumer's perspective.
     */
    @Child(name = "description", type = {MarkdownType.class}, order=14, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Natural language description of the plan definition", formalDefinition="A free text natural language description of the plan definition from a consumer's perspective." )
    protected MarkdownType description;

    /**
     * The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate plan definition instances.
     */
    @Child(name = "useContext", type = {UsageContext.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="The context that the content is intended to support", formalDefinition="The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate plan definition instances." )
    protected List<UsageContext> useContext;

    /**
     * A legal or geographic region in which the plan definition is intended to be used.
     */
    @Child(name = "jurisdiction", type = {CodeableConcept.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Intended jurisdiction for plan definition (if applicable)", formalDefinition="A legal or geographic region in which the plan definition is intended to be used." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/jurisdiction")
    protected List<CodeableConcept> jurisdiction;

    /**
     * Explanation of why this plan definition is needed and why it has been designed as it has.
     */
    @Child(name = "purpose", type = {MarkdownType.class}, order=17, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Why this plan definition is defined", formalDefinition="Explanation of why this plan definition is needed and why it has been designed as it has." )
    protected MarkdownType purpose;

    /**
     * A detailed description of how the plan definition is used from a clinical perspective.
     */
    @Child(name = "usage", type = {MarkdownType.class}, order=18, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Describes the clinical usage of the plan", formalDefinition="A detailed description of how the plan definition is used from a clinical perspective." )
    protected MarkdownType usage;

    /**
     * A copyright statement relating to the plan definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the plan definition.
     */
    @Child(name = "copyright", type = {MarkdownType.class}, order=19, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Use and/or publishing restrictions", formalDefinition="A copyright statement relating to the plan definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the plan definition." )
    protected MarkdownType copyright;

    /**
     * A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    @Child(name = "copyrightLabel", type = {StringType.class}, order=20, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Copyright holder and year(s)", formalDefinition="A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved')." )
    protected StringType copyrightLabel;

    /**
     * The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    @Child(name = "approvalDate", type = {DateType.class}, order=21, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the plan definition was approved by publisher", formalDefinition="The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage." )
    protected DateType approvalDate;

    /**
     * The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    @Child(name = "lastReviewDate", type = {DateType.class}, order=22, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the plan definition was last reviewed by the publisher", formalDefinition="The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date." )
    protected DateType lastReviewDate;

    /**
     * The period during which the plan definition content was or is planned to be in active use.
     */
    @Child(name = "effectivePeriod", type = {Period.class}, order=23, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="When the plan definition is expected to be used", formalDefinition="The period during which the plan definition content was or is planned to be in active use." )
    protected Period effectivePeriod;

    /**
     * Descriptive topics related to the content of the plan definition. Topics provide a high-level categorization of the definition that can be useful for filtering and searching.
     */
    @Child(name = "topic", type = {CodeableConcept.class}, order=24, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="E.g. Education, Treatment, Assessment", formalDefinition="Descriptive topics related to the content of the plan definition. Topics provide a high-level categorization of the definition that can be useful for filtering and searching." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/definition-topic")
    protected List<CodeableConcept> topic;

    /**
     * An individiual or organization primarily involved in the creation and maintenance of the content.
     */
    @Child(name = "author", type = {ContactDetail.class}, order=25, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who authored the content", formalDefinition="An individiual or organization primarily involved in the creation and maintenance of the content." )
    protected List<ContactDetail> author;

    /**
     * An individual or organization primarily responsible for internal coherence of the content.
     */
    @Child(name = "editor", type = {ContactDetail.class}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who edited the content", formalDefinition="An individual or organization primarily responsible for internal coherence of the content." )
    protected List<ContactDetail> editor;

    /**
     * An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the content.
     */
    @Child(name = "reviewer", type = {ContactDetail.class}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who reviewed the content", formalDefinition="An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the content." )
    protected List<ContactDetail> reviewer;

    /**
     * An individual or organization asserted by the publisher to be responsible for officially endorsing the content for use in some setting.
     */
    @Child(name = "endorser", type = {ContactDetail.class}, order=28, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Who endorsed the content", formalDefinition="An individual or organization asserted by the publisher to be responsible for officially endorsing the content for use in some setting." )
    protected List<ContactDetail> endorser;

    /**
     * Related artifacts such as additional documentation, justification, or bibliographic references.
     */
    @Child(name = "relatedArtifact", type = {RelatedArtifact.class}, order=29, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional documentation, citations", formalDefinition="Related artifacts such as additional documentation, justification, or bibliographic references." )
    protected List<RelatedArtifact> relatedArtifact;

    /**
     * A reference to a Library resource containing any formal logic used by the plan definition.
     */
    @Child(name = "library", type = {CanonicalType.class}, order=30, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Logic used by the plan definition", formalDefinition="A reference to a Library resource containing any formal logic used by the plan definition." )
    protected List<CanonicalType> library;

    /**
     * A goal describes an expected outcome that activities within the plan are intended to achieve. For example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, meeting the acceptance criteria for a test as specified by a quality specification, etc.
     */
    @Child(name = "goal", type = {}, order=31, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What the plan is trying to accomplish", formalDefinition="A goal describes an expected outcome that activities within the plan are intended to achieve. For example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, meeting the acceptance criteria for a test as specified by a quality specification, etc." )
    protected List<PlanDefinitionGoalComponent> goal;

    /**
     * Actors represent the individuals or groups involved in the execution of the defined set of activities.
     */
    @Child(name = "actor", type = {}, order=32, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Actors within the plan", formalDefinition="Actors represent the individuals or groups involved in the execution of the defined set of activities." )
    protected List<PlanDefinitionActorComponent> actor;

    /**
     * An action or group of actions to be taken as part of the plan. For example, in clinical care, an action would be to prescribe a particular indicated medication, or perform a particular test as appropriate. In pharmaceutical quality, an action would be the test that needs to be performed on a drug product as defined in the quality specification.
     */
    @Child(name = "action", type = {}, order=33, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Action defined by the plan", formalDefinition="An action or group of actions to be taken as part of the plan. For example, in clinical care, an action would be to prescribe a particular indicated medication, or perform a particular test as appropriate. In pharmaceutical quality, an action would be the test that needs to be performed on a drug product as defined in the quality specification." )
    protected List<PlanDefinitionActionComponent> action;

    /**
     * If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.
     */
    @Child(name = "asNeeded", type = {BooleanType.class, CodeableConcept.class}, order=34, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Preconditions for service", formalDefinition="If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/medication-as-needed-reason")
    protected DataType asNeeded;

    private static final long serialVersionUID = 324754414L;

  /**
   * Constructor
   */
    public PlanDefinition() {
      super();
    }

  /**
   * Constructor
   */
    public PlanDefinition(PublicationStatus status) {
      super();
      this.setStatus(status);
    }

    /**
     * @return {@link #url} (An absolute URI that is used to identify this plan definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this plan definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the plan definition is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public UriType getUrlElement() { 
      if (this.url == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.url");
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
     * @param value {@link #url} (An absolute URI that is used to identify this plan definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this plan definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the plan definition is stored on different servers.). This is the underlying object with id, value and extensions. The accessor "getUrl" gives direct access to the value
     */
    public PlanDefinition setUrlElement(UriType value) { 
      this.url = value;
      return this;
    }

    /**
     * @return An absolute URI that is used to identify this plan definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this plan definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the plan definition is stored on different servers.
     */
    public String getUrl() { 
      return this.url == null ? null : this.url.getValue();
    }

    /**
     * @param value An absolute URI that is used to identify this plan definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this plan definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the plan definition is stored on different servers.
     */
    public PlanDefinition setUrl(String value) { 
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
     * @return {@link #identifier} (A formal identifier that is used to identify this plan definition when it is represented in other formats, or referenced in a specification, model, design or an instance.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setIdentifier(List<Identifier> theIdentifier) { 
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

    public PlanDefinition addIdentifier(Identifier t) { //3
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
     * @return {@link #version} (The identifier that is used to identify this version of the plan definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the plan definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public StringType getVersionElement() { 
      if (this.version == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.version");
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
     * @param value {@link #version} (The identifier that is used to identify this version of the plan definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the plan definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.). This is the underlying object with id, value and extensions. The accessor "getVersion" gives direct access to the value
     */
    public PlanDefinition setVersionElement(StringType value) { 
      this.version = value;
      return this;
    }

    /**
     * @return The identifier that is used to identify this version of the plan definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the plan definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.
     */
    public String getVersion() { 
      return this.version == null ? null : this.version.getValue();
    }

    /**
     * @param value The identifier that is used to identify this version of the plan definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the plan definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.
     */
    public PlanDefinition setVersion(String value) { 
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
    public PlanDefinition setVersionAlgorithm(DataType value) { 
      if (value != null && !(value instanceof StringType || value instanceof Coding))
        throw new FHIRException("Not the right type for PlanDefinition.versionAlgorithm[x]: "+value.fhirType());
      this.versionAlgorithm = value;
      return this;
    }

    /**
     * @return {@link #name} (A natural language name identifying the plan definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public StringType getNameElement() { 
      if (this.name == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.name");
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
     * @param value {@link #name} (A natural language name identifying the plan definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.). This is the underlying object with id, value and extensions. The accessor "getName" gives direct access to the value
     */
    public PlanDefinition setNameElement(StringType value) { 
      this.name = value;
      return this;
    }

    /**
     * @return A natural language name identifying the plan definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public String getName() { 
      return this.name == null ? null : this.name.getValue();
    }

    /**
     * @param value A natural language name identifying the plan definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.
     */
    public PlanDefinition setName(String value) { 
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
     * @return {@link #title} (A short, descriptive, user-friendly title for the plan definition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public StringType getTitleElement() { 
      if (this.title == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.title");
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
     * @param value {@link #title} (A short, descriptive, user-friendly title for the plan definition.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
     */
    public PlanDefinition setTitleElement(StringType value) { 
      this.title = value;
      return this;
    }

    /**
     * @return A short, descriptive, user-friendly title for the plan definition.
     */
    public String getTitle() { 
      return this.title == null ? null : this.title.getValue();
    }

    /**
     * @param value A short, descriptive, user-friendly title for the plan definition.
     */
    public PlanDefinition setTitle(String value) { 
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
     * @return {@link #subtitle} (An explanatory or alternate title for the plan definition giving additional information about its content.). This is the underlying object with id, value and extensions. The accessor "getSubtitle" gives direct access to the value
     */
    public StringType getSubtitleElement() { 
      if (this.subtitle == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.subtitle");
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
     * @param value {@link #subtitle} (An explanatory or alternate title for the plan definition giving additional information about its content.). This is the underlying object with id, value and extensions. The accessor "getSubtitle" gives direct access to the value
     */
    public PlanDefinition setSubtitleElement(StringType value) { 
      this.subtitle = value;
      return this;
    }

    /**
     * @return An explanatory or alternate title for the plan definition giving additional information about its content.
     */
    public String getSubtitle() { 
      return this.subtitle == null ? null : this.subtitle.getValue();
    }

    /**
     * @param value An explanatory or alternate title for the plan definition giving additional information about its content.
     */
    public PlanDefinition setSubtitle(String value) { 
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
     * @return {@link #type} (A high-level category for the plan definition that distinguishes the kinds of systems that would be interested in the plan definition.)
     */
    public CodeableConcept getType() { 
      if (this.type == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.type");
        else if (Configuration.doAutoCreate())
          this.type = new CodeableConcept(); // cc
      return this.type;
    }

    public boolean hasType() { 
      return this.type != null && !this.type.isEmpty();
    }

    /**
     * @param value {@link #type} (A high-level category for the plan definition that distinguishes the kinds of systems that would be interested in the plan definition.)
     */
    public PlanDefinition setType(CodeableConcept value) { 
      this.type = value;
      return this;
    }

    /**
     * @return {@link #status} (The status of this plan definition. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<PublicationStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.status");
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
     * @param value {@link #status} (The status of this plan definition. Enables tracking the life-cycle of the content.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public PlanDefinition setStatusElement(Enumeration<PublicationStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The status of this plan definition. Enables tracking the life-cycle of the content.
     */
    public PublicationStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The status of this plan definition. Enables tracking the life-cycle of the content.
     */
    public PlanDefinition setStatus(PublicationStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<PublicationStatus>(new PublicationStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #experimental} (A Boolean value to indicate that this plan definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public BooleanType getExperimentalElement() { 
      if (this.experimental == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.experimental");
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
     * @param value {@link #experimental} (A Boolean value to indicate that this plan definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.). This is the underlying object with id, value and extensions. The accessor "getExperimental" gives direct access to the value
     */
    public PlanDefinition setExperimentalElement(BooleanType value) { 
      this.experimental = value;
      return this;
    }

    /**
     * @return A Boolean value to indicate that this plan definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public boolean getExperimental() { 
      return this.experimental == null || this.experimental.isEmpty() ? false : this.experimental.getValue();
    }

    /**
     * @param value A Boolean value to indicate that this plan definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.
     */
    public PlanDefinition setExperimental(boolean value) { 
        if (this.experimental == null)
          this.experimental = new BooleanType();
        this.experimental.setValue(value);
      return this;
    }

    /**
     * @return {@link #subject} (A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
     */
    public DataType getSubject() { 
      return this.subject;
    }

    /**
     * @return {@link #subject} (A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
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
     * @return {@link #subject} (A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
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

    /**
     * @return {@link #subject} (A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
     */
    public CanonicalType getSubjectCanonicalType() throws FHIRException { 
      if (this.subject == null)
        this.subject = new CanonicalType();
      if (!(this.subject instanceof CanonicalType))
        throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.subject.getClass().getName()+" was encountered");
      return (CanonicalType) this.subject;
    }

    public boolean hasSubjectCanonicalType() { 
      return this != null && this.subject instanceof CanonicalType;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.)
     */
    public PlanDefinition setSubject(DataType value) { 
      if (value != null && !(value instanceof CodeableConcept || value instanceof Reference || value instanceof CanonicalType))
        throw new FHIRException("Not the right type for PlanDefinition.subject[x]: "+value.fhirType());
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #date} (The date  (and optionally time) when the plan definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the plan definition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public DateTimeType getDateElement() { 
      if (this.date == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.date");
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
     * @param value {@link #date} (The date  (and optionally time) when the plan definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the plan definition changes.). This is the underlying object with id, value and extensions. The accessor "getDate" gives direct access to the value
     */
    public PlanDefinition setDateElement(DateTimeType value) { 
      this.date = value;
      return this;
    }

    /**
     * @return The date  (and optionally time) when the plan definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the plan definition changes.
     */
    public Date getDate() { 
      return this.date == null ? null : this.date.getValue();
    }

    /**
     * @param value The date  (and optionally time) when the plan definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the plan definition changes.
     */
    public PlanDefinition setDate(Date value) { 
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
     * @return {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the plan definition.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public StringType getPublisherElement() { 
      if (this.publisher == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.publisher");
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
     * @param value {@link #publisher} (The name of the organization or individual responsible for the release and ongoing maintenance of the plan definition.). This is the underlying object with id, value and extensions. The accessor "getPublisher" gives direct access to the value
     */
    public PlanDefinition setPublisherElement(StringType value) { 
      this.publisher = value;
      return this;
    }

    /**
     * @return The name of the organization or individual responsible for the release and ongoing maintenance of the plan definition.
     */
    public String getPublisher() { 
      return this.publisher == null ? null : this.publisher.getValue();
    }

    /**
     * @param value The name of the organization or individual responsible for the release and ongoing maintenance of the plan definition.
     */
    public PlanDefinition setPublisher(String value) { 
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
    public PlanDefinition setContact(List<ContactDetail> theContact) { 
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

    public PlanDefinition addContact(ContactDetail t) { //3
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
     * @return {@link #description} (A free text natural language description of the plan definition from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public MarkdownType getDescriptionElement() { 
      if (this.description == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.description");
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
     * @param value {@link #description} (A free text natural language description of the plan definition from a consumer's perspective.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
     */
    public PlanDefinition setDescriptionElement(MarkdownType value) { 
      this.description = value;
      return this;
    }

    /**
     * @return A free text natural language description of the plan definition from a consumer's perspective.
     */
    public String getDescription() { 
      return this.description == null ? null : this.description.getValue();
    }

    /**
     * @param value A free text natural language description of the plan definition from a consumer's perspective.
     */
    public PlanDefinition setDescription(String value) { 
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
     * @return {@link #useContext} (The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate plan definition instances.)
     */
    public List<UsageContext> getUseContext() { 
      if (this.useContext == null)
        this.useContext = new ArrayList<UsageContext>();
      return this.useContext;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setUseContext(List<UsageContext> theUseContext) { 
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

    public PlanDefinition addUseContext(UsageContext t) { //3
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
     * @return {@link #jurisdiction} (A legal or geographic region in which the plan definition is intended to be used.)
     */
    public List<CodeableConcept> getJurisdiction() { 
      if (this.jurisdiction == null)
        this.jurisdiction = new ArrayList<CodeableConcept>();
      return this.jurisdiction;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setJurisdiction(List<CodeableConcept> theJurisdiction) { 
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

    public PlanDefinition addJurisdiction(CodeableConcept t) { //3
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
     * @return {@link #purpose} (Explanation of why this plan definition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public MarkdownType getPurposeElement() { 
      if (this.purpose == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.purpose");
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
     * @param value {@link #purpose} (Explanation of why this plan definition is needed and why it has been designed as it has.). This is the underlying object with id, value and extensions. The accessor "getPurpose" gives direct access to the value
     */
    public PlanDefinition setPurposeElement(MarkdownType value) { 
      this.purpose = value;
      return this;
    }

    /**
     * @return Explanation of why this plan definition is needed and why it has been designed as it has.
     */
    public String getPurpose() { 
      return this.purpose == null ? null : this.purpose.getValue();
    }

    /**
     * @param value Explanation of why this plan definition is needed and why it has been designed as it has.
     */
    public PlanDefinition setPurpose(String value) { 
      if (Utilities.noString(value))
        this.purpose = null;
      else {
        if (this.purpose == null)
          this.purpose = new MarkdownType();
        this.purpose.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #usage} (A detailed description of how the plan definition is used from a clinical perspective.). This is the underlying object with id, value and extensions. The accessor "getUsage" gives direct access to the value
     */
    public MarkdownType getUsageElement() { 
      if (this.usage == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.usage");
        else if (Configuration.doAutoCreate())
          this.usage = new MarkdownType(); // bb
      return this.usage;
    }

    public boolean hasUsageElement() { 
      return this.usage != null && !this.usage.isEmpty();
    }

    public boolean hasUsage() { 
      return this.usage != null && !this.usage.isEmpty();
    }

    /**
     * @param value {@link #usage} (A detailed description of how the plan definition is used from a clinical perspective.). This is the underlying object with id, value and extensions. The accessor "getUsage" gives direct access to the value
     */
    public PlanDefinition setUsageElement(MarkdownType value) { 
      this.usage = value;
      return this;
    }

    /**
     * @return A detailed description of how the plan definition is used from a clinical perspective.
     */
    public String getUsage() { 
      return this.usage == null ? null : this.usage.getValue();
    }

    /**
     * @param value A detailed description of how the plan definition is used from a clinical perspective.
     */
    public PlanDefinition setUsage(String value) { 
      if (Utilities.noString(value))
        this.usage = null;
      else {
        if (this.usage == null)
          this.usage = new MarkdownType();
        this.usage.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyright} (A copyright statement relating to the plan definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the plan definition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public MarkdownType getCopyrightElement() { 
      if (this.copyright == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.copyright");
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
     * @param value {@link #copyright} (A copyright statement relating to the plan definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the plan definition.). This is the underlying object with id, value and extensions. The accessor "getCopyright" gives direct access to the value
     */
    public PlanDefinition setCopyrightElement(MarkdownType value) { 
      this.copyright = value;
      return this;
    }

    /**
     * @return A copyright statement relating to the plan definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the plan definition.
     */
    public String getCopyright() { 
      return this.copyright == null ? null : this.copyright.getValue();
    }

    /**
     * @param value A copyright statement relating to the plan definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the plan definition.
     */
    public PlanDefinition setCopyright(String value) { 
      if (Utilities.noString(value))
        this.copyright = null;
      else {
        if (this.copyright == null)
          this.copyright = new MarkdownType();
        this.copyright.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public StringType getCopyrightLabelElement() { 
      if (this.copyrightLabel == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.copyrightLabel");
        else if (Configuration.doAutoCreate())
          this.copyrightLabel = new StringType(); // bb
      return this.copyrightLabel;
    }

    public boolean hasCopyrightLabelElement() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    public boolean hasCopyrightLabel() { 
      return this.copyrightLabel != null && !this.copyrightLabel.isEmpty();
    }

    /**
     * @param value {@link #copyrightLabel} (A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').). This is the underlying object with id, value and extensions. The accessor "getCopyrightLabel" gives direct access to the value
     */
    public PlanDefinition setCopyrightLabelElement(StringType value) { 
      this.copyrightLabel = value;
      return this;
    }

    /**
     * @return A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public String getCopyrightLabel() { 
      return this.copyrightLabel == null ? null : this.copyrightLabel.getValue();
    }

    /**
     * @param value A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').
     */
    public PlanDefinition setCopyrightLabel(String value) { 
      if (Utilities.noString(value))
        this.copyrightLabel = null;
      else {
        if (this.copyrightLabel == null)
          this.copyrightLabel = new StringType();
        this.copyrightLabel.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public DateType getApprovalDateElement() { 
      if (this.approvalDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.approvalDate");
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
     * @param value {@link #approvalDate} (The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.). This is the underlying object with id, value and extensions. The accessor "getApprovalDate" gives direct access to the value
     */
    public PlanDefinition setApprovalDateElement(DateType value) { 
      this.approvalDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public Date getApprovalDate() { 
      return this.approvalDate == null ? null : this.approvalDate.getValue();
    }

    /**
     * @param value The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.
     */
    public PlanDefinition setApprovalDate(Date value) { 
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
     * @return {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public DateType getLastReviewDateElement() { 
      if (this.lastReviewDate == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.lastReviewDate");
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
     * @param value {@link #lastReviewDate} (The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.). This is the underlying object with id, value and extensions. The accessor "getLastReviewDate" gives direct access to the value
     */
    public PlanDefinition setLastReviewDateElement(DateType value) { 
      this.lastReviewDate = value;
      return this;
    }

    /**
     * @return The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public Date getLastReviewDate() { 
      return this.lastReviewDate == null ? null : this.lastReviewDate.getValue();
    }

    /**
     * @param value The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.
     */
    public PlanDefinition setLastReviewDate(Date value) { 
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
     * @return {@link #effectivePeriod} (The period during which the plan definition content was or is planned to be in active use.)
     */
    public Period getEffectivePeriod() { 
      if (this.effectivePeriod == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create PlanDefinition.effectivePeriod");
        else if (Configuration.doAutoCreate())
          this.effectivePeriod = new Period(); // cc
      return this.effectivePeriod;
    }

    public boolean hasEffectivePeriod() { 
      return this.effectivePeriod != null && !this.effectivePeriod.isEmpty();
    }

    /**
     * @param value {@link #effectivePeriod} (The period during which the plan definition content was or is planned to be in active use.)
     */
    public PlanDefinition setEffectivePeriod(Period value) { 
      this.effectivePeriod = value;
      return this;
    }

    /**
     * @return {@link #topic} (Descriptive topics related to the content of the plan definition. Topics provide a high-level categorization of the definition that can be useful for filtering and searching.)
     */
    public List<CodeableConcept> getTopic() { 
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      return this.topic;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setTopic(List<CodeableConcept> theTopic) { 
      this.topic = theTopic;
      return this;
    }

    public boolean hasTopic() { 
      if (this.topic == null)
        return false;
      for (CodeableConcept item : this.topic)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableConcept addTopic() { //3
      CodeableConcept t = new CodeableConcept();
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      this.topic.add(t);
      return t;
    }

    public PlanDefinition addTopic(CodeableConcept t) { //3
      if (t == null)
        return this;
      if (this.topic == null)
        this.topic = new ArrayList<CodeableConcept>();
      this.topic.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #topic}, creating it if it does not already exist {3}
     */
    public CodeableConcept getTopicFirstRep() { 
      if (getTopic().isEmpty()) {
        addTopic();
      }
      return getTopic().get(0);
    }

    /**
     * @return {@link #author} (An individiual or organization primarily involved in the creation and maintenance of the content.)
     */
    public List<ContactDetail> getAuthor() { 
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      return this.author;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setAuthor(List<ContactDetail> theAuthor) { 
      this.author = theAuthor;
      return this;
    }

    public boolean hasAuthor() { 
      if (this.author == null)
        return false;
      for (ContactDetail item : this.author)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addAuthor() { //3
      ContactDetail t = new ContactDetail();
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return t;
    }

    public PlanDefinition addAuthor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.author == null)
        this.author = new ArrayList<ContactDetail>();
      this.author.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #author}, creating it if it does not already exist {3}
     */
    public ContactDetail getAuthorFirstRep() { 
      if (getAuthor().isEmpty()) {
        addAuthor();
      }
      return getAuthor().get(0);
    }

    /**
     * @return {@link #editor} (An individual or organization primarily responsible for internal coherence of the content.)
     */
    public List<ContactDetail> getEditor() { 
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      return this.editor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setEditor(List<ContactDetail> theEditor) { 
      this.editor = theEditor;
      return this;
    }

    public boolean hasEditor() { 
      if (this.editor == null)
        return false;
      for (ContactDetail item : this.editor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addEditor() { //3
      ContactDetail t = new ContactDetail();
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return t;
    }

    public PlanDefinition addEditor(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.editor == null)
        this.editor = new ArrayList<ContactDetail>();
      this.editor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #editor}, creating it if it does not already exist {3}
     */
    public ContactDetail getEditorFirstRep() { 
      if (getEditor().isEmpty()) {
        addEditor();
      }
      return getEditor().get(0);
    }

    /**
     * @return {@link #reviewer} (An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the content.)
     */
    public List<ContactDetail> getReviewer() { 
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      return this.reviewer;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setReviewer(List<ContactDetail> theReviewer) { 
      this.reviewer = theReviewer;
      return this;
    }

    public boolean hasReviewer() { 
      if (this.reviewer == null)
        return false;
      for (ContactDetail item : this.reviewer)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addReviewer() { //3
      ContactDetail t = new ContactDetail();
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return t;
    }

    public PlanDefinition addReviewer(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.reviewer == null)
        this.reviewer = new ArrayList<ContactDetail>();
      this.reviewer.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reviewer}, creating it if it does not already exist {3}
     */
    public ContactDetail getReviewerFirstRep() { 
      if (getReviewer().isEmpty()) {
        addReviewer();
      }
      return getReviewer().get(0);
    }

    /**
     * @return {@link #endorser} (An individual or organization asserted by the publisher to be responsible for officially endorsing the content for use in some setting.)
     */
    public List<ContactDetail> getEndorser() { 
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      return this.endorser;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setEndorser(List<ContactDetail> theEndorser) { 
      this.endorser = theEndorser;
      return this;
    }

    public boolean hasEndorser() { 
      if (this.endorser == null)
        return false;
      for (ContactDetail item : this.endorser)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public ContactDetail addEndorser() { //3
      ContactDetail t = new ContactDetail();
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return t;
    }

    public PlanDefinition addEndorser(ContactDetail t) { //3
      if (t == null)
        return this;
      if (this.endorser == null)
        this.endorser = new ArrayList<ContactDetail>();
      this.endorser.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #endorser}, creating it if it does not already exist {3}
     */
    public ContactDetail getEndorserFirstRep() { 
      if (getEndorser().isEmpty()) {
        addEndorser();
      }
      return getEndorser().get(0);
    }

    /**
     * @return {@link #relatedArtifact} (Related artifacts such as additional documentation, justification, or bibliographic references.)
     */
    public List<RelatedArtifact> getRelatedArtifact() { 
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      return this.relatedArtifact;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setRelatedArtifact(List<RelatedArtifact> theRelatedArtifact) { 
      this.relatedArtifact = theRelatedArtifact;
      return this;
    }

    public boolean hasRelatedArtifact() { 
      if (this.relatedArtifact == null)
        return false;
      for (RelatedArtifact item : this.relatedArtifact)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RelatedArtifact addRelatedArtifact() { //3
      RelatedArtifact t = new RelatedArtifact();
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return t;
    }

    public PlanDefinition addRelatedArtifact(RelatedArtifact t) { //3
      if (t == null)
        return this;
      if (this.relatedArtifact == null)
        this.relatedArtifact = new ArrayList<RelatedArtifact>();
      this.relatedArtifact.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #relatedArtifact}, creating it if it does not already exist {3}
     */
    public RelatedArtifact getRelatedArtifactFirstRep() { 
      if (getRelatedArtifact().isEmpty()) {
        addRelatedArtifact();
      }
      return getRelatedArtifact().get(0);
    }

    /**
     * @return {@link #library} (A reference to a Library resource containing any formal logic used by the plan definition.)
     */
    public List<CanonicalType> getLibrary() { 
      if (this.library == null)
        this.library = new ArrayList<CanonicalType>();
      return this.library;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setLibrary(List<CanonicalType> theLibrary) { 
      this.library = theLibrary;
      return this;
    }

    public boolean hasLibrary() { 
      if (this.library == null)
        return false;
      for (CanonicalType item : this.library)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #library} (A reference to a Library resource containing any formal logic used by the plan definition.)
     */
    public CanonicalType addLibraryElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.library == null)
        this.library = new ArrayList<CanonicalType>();
      this.library.add(t);
      return t;
    }

    /**
     * @param value {@link #library} (A reference to a Library resource containing any formal logic used by the plan definition.)
     */
    public PlanDefinition addLibrary(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.library == null)
        this.library = new ArrayList<CanonicalType>();
      this.library.add(t);
      return this;
    }

    /**
     * @param value {@link #library} (A reference to a Library resource containing any formal logic used by the plan definition.)
     */
    public boolean hasLibrary(String value) { 
      if (this.library == null)
        return false;
      for (CanonicalType v : this.library)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #goal} (A goal describes an expected outcome that activities within the plan are intended to achieve. For example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, meeting the acceptance criteria for a test as specified by a quality specification, etc.)
     */
    public List<PlanDefinitionGoalComponent> getGoal() { 
      if (this.goal == null)
        this.goal = new ArrayList<PlanDefinitionGoalComponent>();
      return this.goal;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setGoal(List<PlanDefinitionGoalComponent> theGoal) { 
      this.goal = theGoal;
      return this;
    }

    public boolean hasGoal() { 
      if (this.goal == null)
        return false;
      for (PlanDefinitionGoalComponent item : this.goal)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PlanDefinitionGoalComponent addGoal() { //3
      PlanDefinitionGoalComponent t = new PlanDefinitionGoalComponent();
      if (this.goal == null)
        this.goal = new ArrayList<PlanDefinitionGoalComponent>();
      this.goal.add(t);
      return t;
    }

    public PlanDefinition addGoal(PlanDefinitionGoalComponent t) { //3
      if (t == null)
        return this;
      if (this.goal == null)
        this.goal = new ArrayList<PlanDefinitionGoalComponent>();
      this.goal.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #goal}, creating it if it does not already exist {3}
     */
    public PlanDefinitionGoalComponent getGoalFirstRep() { 
      if (getGoal().isEmpty()) {
        addGoal();
      }
      return getGoal().get(0);
    }

    /**
     * @return {@link #actor} (Actors represent the individuals or groups involved in the execution of the defined set of activities.)
     */
    public List<PlanDefinitionActorComponent> getActor() { 
      if (this.actor == null)
        this.actor = new ArrayList<PlanDefinitionActorComponent>();
      return this.actor;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setActor(List<PlanDefinitionActorComponent> theActor) { 
      this.actor = theActor;
      return this;
    }

    public boolean hasActor() { 
      if (this.actor == null)
        return false;
      for (PlanDefinitionActorComponent item : this.actor)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PlanDefinitionActorComponent addActor() { //3
      PlanDefinitionActorComponent t = new PlanDefinitionActorComponent();
      if (this.actor == null)
        this.actor = new ArrayList<PlanDefinitionActorComponent>();
      this.actor.add(t);
      return t;
    }

    public PlanDefinition addActor(PlanDefinitionActorComponent t) { //3
      if (t == null)
        return this;
      if (this.actor == null)
        this.actor = new ArrayList<PlanDefinitionActorComponent>();
      this.actor.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #actor}, creating it if it does not already exist {3}
     */
    public PlanDefinitionActorComponent getActorFirstRep() { 
      if (getActor().isEmpty()) {
        addActor();
      }
      return getActor().get(0);
    }

    /**
     * @return {@link #action} (An action or group of actions to be taken as part of the plan. For example, in clinical care, an action would be to prescribe a particular indicated medication, or perform a particular test as appropriate. In pharmaceutical quality, an action would be the test that needs to be performed on a drug product as defined in the quality specification.)
     */
    public List<PlanDefinitionActionComponent> getAction() { 
      if (this.action == null)
        this.action = new ArrayList<PlanDefinitionActionComponent>();
      return this.action;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public PlanDefinition setAction(List<PlanDefinitionActionComponent> theAction) { 
      this.action = theAction;
      return this;
    }

    public boolean hasAction() { 
      if (this.action == null)
        return false;
      for (PlanDefinitionActionComponent item : this.action)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public PlanDefinitionActionComponent addAction() { //3
      PlanDefinitionActionComponent t = new PlanDefinitionActionComponent();
      if (this.action == null)
        this.action = new ArrayList<PlanDefinitionActionComponent>();
      this.action.add(t);
      return t;
    }

    public PlanDefinition addAction(PlanDefinitionActionComponent t) { //3
      if (t == null)
        return this;
      if (this.action == null)
        this.action = new ArrayList<PlanDefinitionActionComponent>();
      this.action.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
     */
    public PlanDefinitionActionComponent getActionFirstRep() { 
      if (getAction().isEmpty()) {
        addAction();
      }
      return getAction().get(0);
    }

    /**
     * @return {@link #asNeeded} (If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.)
     */
    public DataType getAsNeeded() { 
      return this.asNeeded;
    }

    /**
     * @return {@link #asNeeded} (If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.)
     */
    public BooleanType getAsNeededBooleanType() throws FHIRException { 
      if (this.asNeeded == null)
        this.asNeeded = new BooleanType();
      if (!(this.asNeeded instanceof BooleanType))
        throw new FHIRException("Type mismatch: the type BooleanType was expected, but "+this.asNeeded.getClass().getName()+" was encountered");
      return (BooleanType) this.asNeeded;
    }

    public boolean hasAsNeededBooleanType() { 
      return this != null && this.asNeeded instanceof BooleanType;
    }

    /**
     * @return {@link #asNeeded} (If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.)
     */
    public CodeableConcept getAsNeededCodeableConcept() throws FHIRException { 
      if (this.asNeeded == null)
        this.asNeeded = new CodeableConcept();
      if (!(this.asNeeded instanceof CodeableConcept))
        throw new FHIRException("Type mismatch: the type CodeableConcept was expected, but "+this.asNeeded.getClass().getName()+" was encountered");
      return (CodeableConcept) this.asNeeded;
    }

    public boolean hasAsNeededCodeableConcept() { 
      return this != null && this.asNeeded instanceof CodeableConcept;
    }

    public boolean hasAsNeeded() { 
      return this.asNeeded != null && !this.asNeeded.isEmpty();
    }

    /**
     * @param value {@link #asNeeded} (If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example "pain", "on flare-up", etc.)
     */
    public PlanDefinition setAsNeeded(DataType value) { 
      if (value != null && !(value instanceof BooleanType || value instanceof CodeableConcept))
        throw new FHIRException("Not the right type for PlanDefinition.asNeeded[x]: "+value.fhirType());
      this.asNeeded = value;
      return this;
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("url", "uri", "An absolute URI that is used to identify this plan definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this plan definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the plan definition is stored on different servers.", 0, 1, url));
        children.add(new Property("identifier", "Identifier", "A formal identifier that is used to identify this plan definition when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("version", "string", "The identifier that is used to identify this version of the plan definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the plan definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.", 0, 1, version));
        children.add(new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm));
        children.add(new Property("name", "string", "A natural language name identifying the plan definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name));
        children.add(new Property("title", "string", "A short, descriptive, user-friendly title for the plan definition.", 0, 1, title));
        children.add(new Property("subtitle", "string", "An explanatory or alternate title for the plan definition giving additional information about its content.", 0, 1, subtitle));
        children.add(new Property("type", "CodeableConcept", "A high-level category for the plan definition that distinguishes the kinds of systems that would be interested in the plan definition.", 0, 1, type));
        children.add(new Property("status", "code", "The status of this plan definition. Enables tracking the life-cycle of the content.", 0, 1, status));
        children.add(new Property("experimental", "boolean", "A Boolean value to indicate that this plan definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental));
        children.add(new Property("subject[x]", "CodeableConcept|Reference(Group|MedicinalProductDefinition|SubstanceDefinition|AdministrableProductDefinition|ManufacturedItemDefinition|PackagedProductDefinition)|canonical(EvidenceVariable)", "A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject));
        children.add(new Property("date", "dateTime", "The date  (and optionally time) when the plan definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the plan definition changes.", 0, 1, date));
        children.add(new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the plan definition.", 0, 1, publisher));
        children.add(new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact));
        children.add(new Property("description", "markdown", "A free text natural language description of the plan definition from a consumer's perspective.", 0, 1, description));
        children.add(new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate plan definition instances.", 0, java.lang.Integer.MAX_VALUE, useContext));
        children.add(new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the plan definition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction));
        children.add(new Property("purpose", "markdown", "Explanation of why this plan definition is needed and why it has been designed as it has.", 0, 1, purpose));
        children.add(new Property("usage", "markdown", "A detailed description of how the plan definition is used from a clinical perspective.", 0, 1, usage));
        children.add(new Property("copyright", "markdown", "A copyright statement relating to the plan definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the plan definition.", 0, 1, copyright));
        children.add(new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel));
        children.add(new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate));
        children.add(new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate));
        children.add(new Property("effectivePeriod", "Period", "The period during which the plan definition content was or is planned to be in active use.", 0, 1, effectivePeriod));
        children.add(new Property("topic", "CodeableConcept", "Descriptive topics related to the content of the plan definition. Topics provide a high-level categorization of the definition that can be useful for filtering and searching.", 0, java.lang.Integer.MAX_VALUE, topic));
        children.add(new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author));
        children.add(new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor));
        children.add(new Property("reviewer", "ContactDetail", "An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer));
        children.add(new Property("endorser", "ContactDetail", "An individual or organization asserted by the publisher to be responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser));
        children.add(new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, or bibliographic references.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact));
        children.add(new Property("library", "canonical(Library)", "A reference to a Library resource containing any formal logic used by the plan definition.", 0, java.lang.Integer.MAX_VALUE, library));
        children.add(new Property("goal", "", "A goal describes an expected outcome that activities within the plan are intended to achieve. For example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, meeting the acceptance criteria for a test as specified by a quality specification, etc.", 0, java.lang.Integer.MAX_VALUE, goal));
        children.add(new Property("actor", "", "Actors represent the individuals or groups involved in the execution of the defined set of activities.", 0, java.lang.Integer.MAX_VALUE, actor));
        children.add(new Property("action", "", "An action or group of actions to be taken as part of the plan. For example, in clinical care, an action would be to prescribe a particular indicated medication, or perform a particular test as appropriate. In pharmaceutical quality, an action would be the test that needs to be performed on a drug product as defined in the quality specification.", 0, java.lang.Integer.MAX_VALUE, action));
        children.add(new Property("asNeeded[x]", "boolean|CodeableConcept", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case 116079: /*url*/  return new Property("url", "uri", "An absolute URI that is used to identify this plan definition when it is referenced in a specification, model, design or an instance; also called its canonical identifier. This SHOULD be globally unique and SHOULD be a literal address at which an authoritative instance of this plan definition is (or will be) published. This URL can be the target of a canonical reference. It SHALL remain the same when the plan definition is stored on different servers.", 0, 1, url);
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "A formal identifier that is used to identify this plan definition when it is represented in other formats, or referenced in a specification, model, design or an instance.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 351608024: /*version*/  return new Property("version", "string", "The identifier that is used to identify this version of the plan definition when it is referenced in a specification, model, design or instance. This is an arbitrary value managed by the plan definition author and is not expected to be globally unique. For example, it might be a timestamp (e.g. yyyymmdd) if a managed version is not available. There is also no expectation that versions can be placed in a lexicographical sequence. To provide a version consistent with the Decision Support Service specification, use the format Major.Minor.Revision (e.g. 1.0.0). For more information on versioning knowledge assets, refer to the Decision Support Service specification. Note that a version is required for non-experimental active artifacts.", 0, 1, version);
        case -115699031: /*versionAlgorithm[x]*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1508158071: /*versionAlgorithm*/  return new Property("versionAlgorithm[x]", "string|Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1836908904: /*versionAlgorithmString*/  return new Property("versionAlgorithm[x]", "string", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 1373807809: /*versionAlgorithmCoding*/  return new Property("versionAlgorithm[x]", "Coding", "Indicates the mechanism used to compare versions to determine which is more current.", 0, 1, versionAlgorithm);
        case 3373707: /*name*/  return new Property("name", "string", "A natural language name identifying the plan definition. This name should be usable as an identifier for the module by machine processing applications such as code generation.", 0, 1, name);
        case 110371416: /*title*/  return new Property("title", "string", "A short, descriptive, user-friendly title for the plan definition.", 0, 1, title);
        case -2060497896: /*subtitle*/  return new Property("subtitle", "string", "An explanatory or alternate title for the plan definition giving additional information about its content.", 0, 1, subtitle);
        case 3575610: /*type*/  return new Property("type", "CodeableConcept", "A high-level category for the plan definition that distinguishes the kinds of systems that would be interested in the plan definition.", 0, 1, type);
        case -892481550: /*status*/  return new Property("status", "code", "The status of this plan definition. Enables tracking the life-cycle of the content.", 0, 1, status);
        case -404562712: /*experimental*/  return new Property("experimental", "boolean", "A Boolean value to indicate that this plan definition is authored for testing purposes (or education/evaluation/marketing) and is not intended to be used for genuine usage.", 0, 1, experimental);
        case -573640748: /*subject[x]*/  return new Property("subject[x]", "CodeableConcept|Reference(Group|MedicinalProductDefinition|SubstanceDefinition|AdministrableProductDefinition|ManufacturedItemDefinition|PackagedProductDefinition)|canonical(EvidenceVariable)", "A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
        case -1867885268: /*subject*/  return new Property("subject[x]", "CodeableConcept|Reference(Group|MedicinalProductDefinition|SubstanceDefinition|AdministrableProductDefinition|ManufacturedItemDefinition|PackagedProductDefinition)|canonical(EvidenceVariable)", "A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
        case -1257122603: /*subjectCodeableConcept*/  return new Property("subject[x]", "CodeableConcept", "A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
        case 772938623: /*subjectReference*/  return new Property("subject[x]", "Reference(Group|MedicinalProductDefinition|SubstanceDefinition|AdministrableProductDefinition|ManufacturedItemDefinition|PackagedProductDefinition)", "A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
        case -1768521432: /*subjectCanonical*/  return new Property("subject[x]", "canonical(EvidenceVariable)", "A code, group definition, or canonical reference that describes  or identifies the intended subject of the plan definition. Canonical references are allowed to support the definition of protocols for drug and substance quality specifications, and is allowed to reference a MedicinalProductDefinition, SubstanceDefinition, AdministrableProductDefinition, ManufacturedItemDefinition, or PackagedProductDefinition resource.", 0, 1, subject);
        case 3076014: /*date*/  return new Property("date", "dateTime", "The date  (and optionally time) when the plan definition was last significantly changed. The date must change when the business version changes and it must change if the status code changes. In addition, it should change when the substantive content of the plan definition changes.", 0, 1, date);
        case 1447404028: /*publisher*/  return new Property("publisher", "string", "The name of the organization or individual responsible for the release and ongoing maintenance of the plan definition.", 0, 1, publisher);
        case 951526432: /*contact*/  return new Property("contact", "ContactDetail", "Contact details to assist a user in finding and communicating with the publisher.", 0, java.lang.Integer.MAX_VALUE, contact);
        case -1724546052: /*description*/  return new Property("description", "markdown", "A free text natural language description of the plan definition from a consumer's perspective.", 0, 1, description);
        case -669707736: /*useContext*/  return new Property("useContext", "UsageContext", "The content was developed with a focus and intent of supporting the contexts that are listed. These contexts may be general categories (gender, age, ...) or may be references to specific programs (insurance plans, studies, ...) and may be used to assist with indexing and searching for appropriate plan definition instances.", 0, java.lang.Integer.MAX_VALUE, useContext);
        case -507075711: /*jurisdiction*/  return new Property("jurisdiction", "CodeableConcept", "A legal or geographic region in which the plan definition is intended to be used.", 0, java.lang.Integer.MAX_VALUE, jurisdiction);
        case -220463842: /*purpose*/  return new Property("purpose", "markdown", "Explanation of why this plan definition is needed and why it has been designed as it has.", 0, 1, purpose);
        case 111574433: /*usage*/  return new Property("usage", "markdown", "A detailed description of how the plan definition is used from a clinical perspective.", 0, 1, usage);
        case 1522889671: /*copyright*/  return new Property("copyright", "markdown", "A copyright statement relating to the plan definition and/or its contents. Copyright statements are generally legal restrictions on the use and publishing of the plan definition.", 0, 1, copyright);
        case 765157229: /*copyrightLabel*/  return new Property("copyrightLabel", "string", "A short string (<50 characters), suitable for inclusion in a page footer that identifies the copyright holder, effective period, and optionally whether rights are resctricted. (e.g. 'All rights reserved', 'Some rights reserved').", 0, 1, copyrightLabel);
        case 223539345: /*approvalDate*/  return new Property("approvalDate", "date", "The date on which the resource content was approved by the publisher. Approval happens once when the content is officially approved for usage.", 0, 1, approvalDate);
        case -1687512484: /*lastReviewDate*/  return new Property("lastReviewDate", "date", "The date on which the resource content was last reviewed. Review happens periodically after approval but does not change the original approval date.", 0, 1, lastReviewDate);
        case -403934648: /*effectivePeriod*/  return new Property("effectivePeriod", "Period", "The period during which the plan definition content was or is planned to be in active use.", 0, 1, effectivePeriod);
        case 110546223: /*topic*/  return new Property("topic", "CodeableConcept", "Descriptive topics related to the content of the plan definition. Topics provide a high-level categorization of the definition that can be useful for filtering and searching.", 0, java.lang.Integer.MAX_VALUE, topic);
        case -1406328437: /*author*/  return new Property("author", "ContactDetail", "An individiual or organization primarily involved in the creation and maintenance of the content.", 0, java.lang.Integer.MAX_VALUE, author);
        case -1307827859: /*editor*/  return new Property("editor", "ContactDetail", "An individual or organization primarily responsible for internal coherence of the content.", 0, java.lang.Integer.MAX_VALUE, editor);
        case -261190139: /*reviewer*/  return new Property("reviewer", "ContactDetail", "An individual or organization asserted by the publisher to be primarily responsible for review of some aspect of the content.", 0, java.lang.Integer.MAX_VALUE, reviewer);
        case 1740277666: /*endorser*/  return new Property("endorser", "ContactDetail", "An individual or organization asserted by the publisher to be responsible for officially endorsing the content for use in some setting.", 0, java.lang.Integer.MAX_VALUE, endorser);
        case 666807069: /*relatedArtifact*/  return new Property("relatedArtifact", "RelatedArtifact", "Related artifacts such as additional documentation, justification, or bibliographic references.", 0, java.lang.Integer.MAX_VALUE, relatedArtifact);
        case 166208699: /*library*/  return new Property("library", "canonical(Library)", "A reference to a Library resource containing any formal logic used by the plan definition.", 0, java.lang.Integer.MAX_VALUE, library);
        case 3178259: /*goal*/  return new Property("goal", "", "A goal describes an expected outcome that activities within the plan are intended to achieve. For example, weight loss, restoring an activity of daily living, obtaining herd immunity via immunization, meeting a process improvement objective, meeting the acceptance criteria for a test as specified by a quality specification, etc.", 0, java.lang.Integer.MAX_VALUE, goal);
        case 92645877: /*actor*/  return new Property("actor", "", "Actors represent the individuals or groups involved in the execution of the defined set of activities.", 0, java.lang.Integer.MAX_VALUE, actor);
        case -1422950858: /*action*/  return new Property("action", "", "An action or group of actions to be taken as part of the plan. For example, in clinical care, an action would be to prescribe a particular indicated medication, or perform a particular test as appropriate. In pharmaceutical quality, an action would be the test that needs to be performed on a drug product as defined in the quality specification.", 0, java.lang.Integer.MAX_VALUE, action);
        case -544329575: /*asNeeded[x]*/  return new Property("asNeeded[x]", "boolean|CodeableConcept", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded);
        case -1432923513: /*asNeeded*/  return new Property("asNeeded[x]", "boolean|CodeableConcept", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded);
        case -591717471: /*asNeededBoolean*/  return new Property("asNeeded[x]", "boolean", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded);
        case 1556420122: /*asNeededCodeableConcept*/  return new Property("asNeeded[x]", "CodeableConcept", "If a CodeableConcept is present, it indicates the pre-condition for performing the service.  For example \"pain\", \"on flare-up\", etc.", 0, 1, asNeeded);
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
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<PublicationStatus>
        case -404562712: /*experimental*/ return this.experimental == null ? new Base[0] : new Base[] {this.experimental}; // BooleanType
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // DataType
        case 3076014: /*date*/ return this.date == null ? new Base[0] : new Base[] {this.date}; // DateTimeType
        case 1447404028: /*publisher*/ return this.publisher == null ? new Base[0] : new Base[] {this.publisher}; // StringType
        case 951526432: /*contact*/ return this.contact == null ? new Base[0] : this.contact.toArray(new Base[this.contact.size()]); // ContactDetail
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // MarkdownType
        case -669707736: /*useContext*/ return this.useContext == null ? new Base[0] : this.useContext.toArray(new Base[this.useContext.size()]); // UsageContext
        case -507075711: /*jurisdiction*/ return this.jurisdiction == null ? new Base[0] : this.jurisdiction.toArray(new Base[this.jurisdiction.size()]); // CodeableConcept
        case -220463842: /*purpose*/ return this.purpose == null ? new Base[0] : new Base[] {this.purpose}; // MarkdownType
        case 111574433: /*usage*/ return this.usage == null ? new Base[0] : new Base[] {this.usage}; // MarkdownType
        case 1522889671: /*copyright*/ return this.copyright == null ? new Base[0] : new Base[] {this.copyright}; // MarkdownType
        case 765157229: /*copyrightLabel*/ return this.copyrightLabel == null ? new Base[0] : new Base[] {this.copyrightLabel}; // StringType
        case 223539345: /*approvalDate*/ return this.approvalDate == null ? new Base[0] : new Base[] {this.approvalDate}; // DateType
        case -1687512484: /*lastReviewDate*/ return this.lastReviewDate == null ? new Base[0] : new Base[] {this.lastReviewDate}; // DateType
        case -403934648: /*effectivePeriod*/ return this.effectivePeriod == null ? new Base[0] : new Base[] {this.effectivePeriod}; // Period
        case 110546223: /*topic*/ return this.topic == null ? new Base[0] : this.topic.toArray(new Base[this.topic.size()]); // CodeableConcept
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : this.author.toArray(new Base[this.author.size()]); // ContactDetail
        case -1307827859: /*editor*/ return this.editor == null ? new Base[0] : this.editor.toArray(new Base[this.editor.size()]); // ContactDetail
        case -261190139: /*reviewer*/ return this.reviewer == null ? new Base[0] : this.reviewer.toArray(new Base[this.reviewer.size()]); // ContactDetail
        case 1740277666: /*endorser*/ return this.endorser == null ? new Base[0] : this.endorser.toArray(new Base[this.endorser.size()]); // ContactDetail
        case 666807069: /*relatedArtifact*/ return this.relatedArtifact == null ? new Base[0] : this.relatedArtifact.toArray(new Base[this.relatedArtifact.size()]); // RelatedArtifact
        case 166208699: /*library*/ return this.library == null ? new Base[0] : this.library.toArray(new Base[this.library.size()]); // CanonicalType
        case 3178259: /*goal*/ return this.goal == null ? new Base[0] : this.goal.toArray(new Base[this.goal.size()]); // PlanDefinitionGoalComponent
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : this.actor.toArray(new Base[this.actor.size()]); // PlanDefinitionActorComponent
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // PlanDefinitionActionComponent
        case -1432923513: /*asNeeded*/ return this.asNeeded == null ? new Base[0] : new Base[] {this.asNeeded}; // DataType
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
        case 3575610: // type
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
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
        case -220463842: // purpose
          this.purpose = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 111574433: // usage
          this.usage = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 1522889671: // copyright
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
          return value;
        case 765157229: // copyrightLabel
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
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
        case 110546223: // topic
          this.getTopic().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case -1406328437: // author
          this.getAuthor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -1307827859: // editor
          this.getEditor().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case -261190139: // reviewer
          this.getReviewer().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case 1740277666: // endorser
          this.getEndorser().add(TypeConvertor.castToContactDetail(value)); // ContactDetail
          return value;
        case 666807069: // relatedArtifact
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case 166208699: // library
          this.getLibrary().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case 3178259: // goal
          this.getGoal().add((PlanDefinitionGoalComponent) value); // PlanDefinitionGoalComponent
          return value;
        case 92645877: // actor
          this.getActor().add((PlanDefinitionActorComponent) value); // PlanDefinitionActorComponent
          return value;
        case -1422950858: // action
          this.getAction().add((PlanDefinitionActionComponent) value); // PlanDefinitionActionComponent
          return value;
        case -1432923513: // asNeeded
          this.asNeeded = TypeConvertor.castToType(value); // DataType
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
        } else if (name.equals("type")) {
          this.type = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
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
          this.publisher = TypeConvertor.castToString(value); // StringType
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
        } else if (name.equals("usage")) {
          this.usage = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyright")) {
          this.copyright = TypeConvertor.castToMarkdown(value); // MarkdownType
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("approvalDate")) {
          this.approvalDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = TypeConvertor.castToDate(value); // DateType
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = TypeConvertor.castToPeriod(value); // Period
        } else if (name.equals("topic")) {
          this.getTopic().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("author")) {
          this.getAuthor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("editor")) {
          this.getEditor().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("reviewer")) {
          this.getReviewer().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("endorser")) {
          this.getEndorser().add(TypeConvertor.castToContactDetail(value));
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("library")) {
          this.getLibrary().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("goal")) {
          this.getGoal().add((PlanDefinitionGoalComponent) value);
        } else if (name.equals("actor")) {
          this.getActor().add((PlanDefinitionActorComponent) value);
        } else if (name.equals("action")) {
          this.getAction().add((PlanDefinitionActionComponent) value);
        } else if (name.equals("asNeeded[x]")) {
          this.asNeeded = TypeConvertor.castToType(value); // DataType
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
        } else if (name.equals("type")) {
          this.type = null;
        } else if (name.equals("status")) {
          value = new PublicationStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<PublicationStatus>
        } else if (name.equals("experimental")) {
          this.experimental = null;
        } else if (name.equals("subject[x]")) {
          this.subject = null;
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
        } else if (name.equals("purpose")) {
          this.purpose = null;
        } else if (name.equals("usage")) {
          this.usage = null;
        } else if (name.equals("copyright")) {
          this.copyright = null;
        } else if (name.equals("copyrightLabel")) {
          this.copyrightLabel = null;
        } else if (name.equals("approvalDate")) {
          this.approvalDate = null;
        } else if (name.equals("lastReviewDate")) {
          this.lastReviewDate = null;
        } else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = null;
        } else if (name.equals("topic")) {
          this.getTopic().remove(value);
        } else if (name.equals("author")) {
          this.getAuthor().remove(value);
        } else if (name.equals("editor")) {
          this.getEditor().remove(value);
        } else if (name.equals("reviewer")) {
          this.getReviewer().remove(value);
        } else if (name.equals("endorser")) {
          this.getEndorser().remove(value);
        } else if (name.equals("relatedArtifact")) {
          this.getRelatedArtifact().remove(value);
        } else if (name.equals("library")) {
          this.getLibrary().remove(value);
        } else if (name.equals("goal")) {
          this.getGoal().add((PlanDefinitionGoalComponent) value);
        } else if (name.equals("actor")) {
          this.getActor().add((PlanDefinitionActorComponent) value);
        } else if (name.equals("action")) {
          this.getAction().add((PlanDefinitionActionComponent) value);
        } else if (name.equals("asNeeded[x]")) {
          this.asNeeded = null;
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
        case 3575610:  return getType();
        case -892481550:  return getStatusElement();
        case -404562712:  return getExperimentalElement();
        case -573640748:  return getSubject();
        case -1867885268:  return getSubject();
        case 3076014:  return getDateElement();
        case 1447404028:  return getPublisherElement();
        case 951526432:  return addContact(); 
        case -1724546052:  return getDescriptionElement();
        case -669707736:  return addUseContext(); 
        case -507075711:  return addJurisdiction(); 
        case -220463842:  return getPurposeElement();
        case 111574433:  return getUsageElement();
        case 1522889671:  return getCopyrightElement();
        case 765157229:  return getCopyrightLabelElement();
        case 223539345:  return getApprovalDateElement();
        case -1687512484:  return getLastReviewDateElement();
        case -403934648:  return getEffectivePeriod();
        case 110546223:  return addTopic(); 
        case -1406328437:  return addAuthor(); 
        case -1307827859:  return addEditor(); 
        case -261190139:  return addReviewer(); 
        case 1740277666:  return addEndorser(); 
        case 666807069:  return addRelatedArtifact(); 
        case 166208699:  return addLibraryElement();
        case 3178259:  return addGoal(); 
        case 92645877:  return addActor(); 
        case -1422950858:  return addAction(); 
        case -544329575:  return getAsNeeded();
        case -1432923513:  return getAsNeeded();
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
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -404562712: /*experimental*/ return new String[] {"boolean"};
        case -1867885268: /*subject*/ return new String[] {"CodeableConcept", "Reference", "canonical"};
        case 3076014: /*date*/ return new String[] {"dateTime"};
        case 1447404028: /*publisher*/ return new String[] {"string"};
        case 951526432: /*contact*/ return new String[] {"ContactDetail"};
        case -1724546052: /*description*/ return new String[] {"markdown"};
        case -669707736: /*useContext*/ return new String[] {"UsageContext"};
        case -507075711: /*jurisdiction*/ return new String[] {"CodeableConcept"};
        case -220463842: /*purpose*/ return new String[] {"markdown"};
        case 111574433: /*usage*/ return new String[] {"markdown"};
        case 1522889671: /*copyright*/ return new String[] {"markdown"};
        case 765157229: /*copyrightLabel*/ return new String[] {"string"};
        case 223539345: /*approvalDate*/ return new String[] {"date"};
        case -1687512484: /*lastReviewDate*/ return new String[] {"date"};
        case -403934648: /*effectivePeriod*/ return new String[] {"Period"};
        case 110546223: /*topic*/ return new String[] {"CodeableConcept"};
        case -1406328437: /*author*/ return new String[] {"ContactDetail"};
        case -1307827859: /*editor*/ return new String[] {"ContactDetail"};
        case -261190139: /*reviewer*/ return new String[] {"ContactDetail"};
        case 1740277666: /*endorser*/ return new String[] {"ContactDetail"};
        case 666807069: /*relatedArtifact*/ return new String[] {"RelatedArtifact"};
        case 166208699: /*library*/ return new String[] {"canonical"};
        case 3178259: /*goal*/ return new String[] {};
        case 92645877: /*actor*/ return new String[] {};
        case -1422950858: /*action*/ return new String[] {};
        case -1432923513: /*asNeeded*/ return new String[] {"boolean", "CodeableConcept"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("url")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.url");
        }
        else if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("version")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.version");
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
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.name");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.title");
        }
        else if (name.equals("subtitle")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.subtitle");
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.status");
        }
        else if (name.equals("experimental")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.experimental");
        }
        else if (name.equals("subjectCodeableConcept")) {
          this.subject = new CodeableConcept();
          return this.subject;
        }
        else if (name.equals("subjectReference")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("subjectCanonical")) {
          this.subject = new CanonicalType();
          return this.subject;
        }
        else if (name.equals("date")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.date");
        }
        else if (name.equals("publisher")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.publisher");
        }
        else if (name.equals("contact")) {
          return addContact();
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.description");
        }
        else if (name.equals("useContext")) {
          return addUseContext();
        }
        else if (name.equals("jurisdiction")) {
          return addJurisdiction();
        }
        else if (name.equals("purpose")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.purpose");
        }
        else if (name.equals("usage")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.usage");
        }
        else if (name.equals("copyright")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.copyright");
        }
        else if (name.equals("copyrightLabel")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.copyrightLabel");
        }
        else if (name.equals("approvalDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.approvalDate");
        }
        else if (name.equals("lastReviewDate")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.lastReviewDate");
        }
        else if (name.equals("effectivePeriod")) {
          this.effectivePeriod = new Period();
          return this.effectivePeriod;
        }
        else if (name.equals("topic")) {
          return addTopic();
        }
        else if (name.equals("author")) {
          return addAuthor();
        }
        else if (name.equals("editor")) {
          return addEditor();
        }
        else if (name.equals("reviewer")) {
          return addReviewer();
        }
        else if (name.equals("endorser")) {
          return addEndorser();
        }
        else if (name.equals("relatedArtifact")) {
          return addRelatedArtifact();
        }
        else if (name.equals("library")) {
          throw new FHIRException("Cannot call addChild on a singleton property PlanDefinition.library");
        }
        else if (name.equals("goal")) {
          return addGoal();
        }
        else if (name.equals("actor")) {
          return addActor();
        }
        else if (name.equals("action")) {
          return addAction();
        }
        else if (name.equals("asNeededBoolean")) {
          this.asNeeded = new BooleanType();
          return this.asNeeded;
        }
        else if (name.equals("asNeededCodeableConcept")) {
          this.asNeeded = new CodeableConcept();
          return this.asNeeded;
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "PlanDefinition";

  }

      public PlanDefinition copy() {
        PlanDefinition dst = new PlanDefinition();
        copyValues(dst);
        return dst;
      }

      public void copyValues(PlanDefinition dst) {
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
        dst.type = type == null ? null : type.copy();
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
        dst.usage = usage == null ? null : usage.copy();
        dst.copyright = copyright == null ? null : copyright.copy();
        dst.copyrightLabel = copyrightLabel == null ? null : copyrightLabel.copy();
        dst.approvalDate = approvalDate == null ? null : approvalDate.copy();
        dst.lastReviewDate = lastReviewDate == null ? null : lastReviewDate.copy();
        dst.effectivePeriod = effectivePeriod == null ? null : effectivePeriod.copy();
        if (topic != null) {
          dst.topic = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : topic)
            dst.topic.add(i.copy());
        };
        if (author != null) {
          dst.author = new ArrayList<ContactDetail>();
          for (ContactDetail i : author)
            dst.author.add(i.copy());
        };
        if (editor != null) {
          dst.editor = new ArrayList<ContactDetail>();
          for (ContactDetail i : editor)
            dst.editor.add(i.copy());
        };
        if (reviewer != null) {
          dst.reviewer = new ArrayList<ContactDetail>();
          for (ContactDetail i : reviewer)
            dst.reviewer.add(i.copy());
        };
        if (endorser != null) {
          dst.endorser = new ArrayList<ContactDetail>();
          for (ContactDetail i : endorser)
            dst.endorser.add(i.copy());
        };
        if (relatedArtifact != null) {
          dst.relatedArtifact = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : relatedArtifact)
            dst.relatedArtifact.add(i.copy());
        };
        if (library != null) {
          dst.library = new ArrayList<CanonicalType>();
          for (CanonicalType i : library)
            dst.library.add(i.copy());
        };
        if (goal != null) {
          dst.goal = new ArrayList<PlanDefinitionGoalComponent>();
          for (PlanDefinitionGoalComponent i : goal)
            dst.goal.add(i.copy());
        };
        if (actor != null) {
          dst.actor = new ArrayList<PlanDefinitionActorComponent>();
          for (PlanDefinitionActorComponent i : actor)
            dst.actor.add(i.copy());
        };
        if (action != null) {
          dst.action = new ArrayList<PlanDefinitionActionComponent>();
          for (PlanDefinitionActionComponent i : action)
            dst.action.add(i.copy());
        };
        dst.asNeeded = asNeeded == null ? null : asNeeded.copy();
      }

      protected PlanDefinition typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof PlanDefinition))
          return false;
        PlanDefinition o = (PlanDefinition) other_;
        return compareDeep(url, o.url, true) && compareDeep(identifier, o.identifier, true) && compareDeep(version, o.version, true)
           && compareDeep(versionAlgorithm, o.versionAlgorithm, true) && compareDeep(name, o.name, true) && compareDeep(title, o.title, true)
           && compareDeep(subtitle, o.subtitle, true) && compareDeep(type, o.type, true) && compareDeep(status, o.status, true)
           && compareDeep(experimental, o.experimental, true) && compareDeep(subject, o.subject, true) && compareDeep(date, o.date, true)
           && compareDeep(publisher, o.publisher, true) && compareDeep(contact, o.contact, true) && compareDeep(description, o.description, true)
           && compareDeep(useContext, o.useContext, true) && compareDeep(jurisdiction, o.jurisdiction, true)
           && compareDeep(purpose, o.purpose, true) && compareDeep(usage, o.usage, true) && compareDeep(copyright, o.copyright, true)
           && compareDeep(copyrightLabel, o.copyrightLabel, true) && compareDeep(approvalDate, o.approvalDate, true)
           && compareDeep(lastReviewDate, o.lastReviewDate, true) && compareDeep(effectivePeriod, o.effectivePeriod, true)
           && compareDeep(topic, o.topic, true) && compareDeep(author, o.author, true) && compareDeep(editor, o.editor, true)
           && compareDeep(reviewer, o.reviewer, true) && compareDeep(endorser, o.endorser, true) && compareDeep(relatedArtifact, o.relatedArtifact, true)
           && compareDeep(library, o.library, true) && compareDeep(goal, o.goal, true) && compareDeep(actor, o.actor, true)
           && compareDeep(action, o.action, true) && compareDeep(asNeeded, o.asNeeded, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof PlanDefinition))
          return false;
        PlanDefinition o = (PlanDefinition) other_;
        return compareValues(url, o.url, true) && compareValues(version, o.version, true) && compareValues(name, o.name, true)
           && compareValues(title, o.title, true) && compareValues(subtitle, o.subtitle, true) && compareValues(status, o.status, true)
           && compareValues(experimental, o.experimental, true) && compareValues(date, o.date, true) && compareValues(publisher, o.publisher, true)
           && compareValues(description, o.description, true) && compareValues(purpose, o.purpose, true) && compareValues(usage, o.usage, true)
           && compareValues(copyright, o.copyright, true) && compareValues(copyrightLabel, o.copyrightLabel, true)
           && compareValues(approvalDate, o.approvalDate, true) && compareValues(lastReviewDate, o.lastReviewDate, true)
           && compareValues(library, o.library, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(url, identifier, version
          , versionAlgorithm, name, title, subtitle, type, status, experimental, subject
          , date, publisher, contact, description, useContext, jurisdiction, purpose, usage
          , copyright, copyrightLabel, approvalDate, lastReviewDate, effectivePeriod, topic
          , author, editor, reviewer, endorser, relatedArtifact, library, goal, actor
          , action, asNeeded);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.PlanDefinition;
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

 /**
   * Search parameter: <b>composed-of</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='composed-of').resource | EventDefinition.relatedArtifact.where(type='composed-of').resource | EvidenceVariable.relatedArtifact.where(type='composed-of').resource | Library.relatedArtifact.where(type='composed-of').resource | Measure.relatedArtifact.where(type='composed-of').resource | PlanDefinition.relatedArtifact.where(type='composed-of').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="composed-of", path="ActivityDefinition.relatedArtifact.where(type='composed-of').resource | EventDefinition.relatedArtifact.where(type='composed-of').resource | EvidenceVariable.relatedArtifact.where(type='composed-of').resource | Library.relatedArtifact.where(type='composed-of').resource | Measure.relatedArtifact.where(type='composed-of').resource | PlanDefinition.relatedArtifact.where(type='composed-of').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_COMPOSED_OF = "composed-of";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>composed-of</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='composed-of').resource | EventDefinition.relatedArtifact.where(type='composed-of').resource | EvidenceVariable.relatedArtifact.where(type='composed-of').resource | Library.relatedArtifact.where(type='composed-of').resource | Measure.relatedArtifact.where(type='composed-of').resource | PlanDefinition.relatedArtifact.where(type='composed-of').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam COMPOSED_OF = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_COMPOSED_OF);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PlanDefinition:composed-of</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_COMPOSED_OF = new ca.uhn.fhir.model.api.Include("PlanDefinition:composed-of").toLocked();

 /**
   * Search parameter: <b>depends-on</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library | EventDefinition.relatedArtifact.where(type='depends-on').resource | EvidenceVariable.relatedArtifact.where(type='depends-on').resource | Library.relatedArtifact.where(type='depends-on').resource | Measure.relatedArtifact.where(type='depends-on').resource | Measure.library | PlanDefinition.relatedArtifact.where(type='depends-on').resource | PlanDefinition.library</b><br>
   * </p>
   */
  @SearchParamDefinition(name="depends-on", path="ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library | EventDefinition.relatedArtifact.where(type='depends-on').resource | EvidenceVariable.relatedArtifact.where(type='depends-on').resource | Library.relatedArtifact.where(type='depends-on').resource | Measure.relatedArtifact.where(type='depends-on').resource | Measure.library | PlanDefinition.relatedArtifact.where(type='depends-on').resource | PlanDefinition.library", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_DEPENDS_ON = "depends-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>depends-on</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='depends-on').resource | ActivityDefinition.library | EventDefinition.relatedArtifact.where(type='depends-on').resource | EvidenceVariable.relatedArtifact.where(type='depends-on').resource | Library.relatedArtifact.where(type='depends-on').resource | Measure.relatedArtifact.where(type='depends-on').resource | Measure.library | PlanDefinition.relatedArtifact.where(type='depends-on').resource | PlanDefinition.library</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEPENDS_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DEPENDS_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PlanDefinition:depends-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEPENDS_ON = new ca.uhn.fhir.model.api.Include("PlanDefinition:depends-on").toLocked();

 /**
   * Search parameter: <b>derived-from</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from
* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): A resource that the ValueSet is derived from
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="derived-from", path="ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from\r\n* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n* [ValueSet](valueset.html): A resource that the ValueSet is derived from\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_DERIVED_FROM = "derived-from";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>derived-from</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): A resource that the CodeSystem is derived from
* [ConceptMap](conceptmap.html): A resource that the ConceptMap is derived from
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): A resource that the NamingSystem is derived from
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): A resource that the ValueSet is derived from
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='derived-from').resource | CodeSystem.relatedArtifact.where(type='derived-from').resource | ConceptMap.relatedArtifact.where(type='derived-from').resource | EventDefinition.relatedArtifact.where(type='derived-from').resource | EvidenceVariable.relatedArtifact.where(type='derived-from').resource | Library.relatedArtifact.where(type='derived-from').resource | Measure.relatedArtifact.where(type='derived-from').resource | NamingSystem.relatedArtifact.where(type='derived-from').resource | PlanDefinition.relatedArtifact.where(type='derived-from').resource | ValueSet.relatedArtifact.where(type='derived-from').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DERIVED_FROM = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DERIVED_FROM);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PlanDefinition:derived-from</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DERIVED_FROM = new ca.uhn.fhir.model.api.Include("PlanDefinition:derived-from").toLocked();

 /**
   * Search parameter: <b>effective</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use
* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use
* [Citation](citation.html): The time during which the citation is intended to be in use
* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use
* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use
* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use
* [Library](library.html): The time during which the library is intended to be in use
* [Measure](measure.html): The time during which the measure is intended to be in use
* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use
* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use
* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use
* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod</b><br>
   * </p>
   */
  @SearchParamDefinition(name="effective", path="ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use\r\n* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use\r\n* [Citation](citation.html): The time during which the citation is intended to be in use\r\n* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use\r\n* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use\r\n* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use\r\n* [Library](library.html): The time during which the library is intended to be in use\r\n* [Measure](measure.html): The time during which the measure is intended to be in use\r\n* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use\r\n* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use\r\n* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use\r\n* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use\r\n", type="date" )
  public static final String SP_EFFECTIVE = "effective";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>effective</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): The time during which the activity definition is intended to be in use
* [ChargeItemDefinition](chargeitemdefinition.html): The time during which the charge item definition is intended to be in use
* [Citation](citation.html): The time during which the citation is intended to be in use
* [CodeSystem](codesystem.html): The time during which the CodeSystem is intended to be in use
* [ConceptMap](conceptmap.html): The time during which the ConceptMap is intended to be in use
* [EventDefinition](eventdefinition.html): The time during which the event definition is intended to be in use
* [Library](library.html): The time during which the library is intended to be in use
* [Measure](measure.html): The time during which the measure is intended to be in use
* [NamingSystem](namingsystem.html): The time during which the NamingSystem is intended to be in use
* [PlanDefinition](plandefinition.html): The time during which the plan definition is intended to be in use
* [Questionnaire](questionnaire.html): The time during which the questionnaire is intended to be in use
* [ValueSet](valueset.html): The time during which the ValueSet is intended to be in use
</b><br>
   * Type: <b>date</b><br>
   * Path: <b>ActivityDefinition.effectivePeriod | ChargeItemDefinition.applicability.effectivePeriod | Citation.effectivePeriod | CodeSystem.effectivePeriod | ConceptMap.effectivePeriod | EventDefinition.effectivePeriod | Library.effectivePeriod | Measure.effectivePeriod | NamingSystem.effectivePeriod | PlanDefinition.effectivePeriod | Questionnaire.effectivePeriod | ValueSet.effectivePeriod</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam EFFECTIVE = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_EFFECTIVE);

 /**
   * Search parameter: <b>predecessor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): The predecessor of the CodeSystem
* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): The predecessor of the ValueSet
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="predecessor", path="ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [CodeSystem](codesystem.html): The predecessor of the CodeSystem\r\n* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n* [ValueSet](valueset.html): The predecessor of the ValueSet\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_PREDECESSOR = "predecessor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>predecessor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [CodeSystem](codesystem.html): The predecessor of the CodeSystem
* [ConceptMap](conceptmap.html): The predecessor of the ConceptMap
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [NamingSystem](namingsystem.html): The predecessor of the NamingSystem
* [PlanDefinition](plandefinition.html): What resource is being referenced
* [ValueSet](valueset.html): The predecessor of the ValueSet
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='predecessor').resource | CodeSystem.relatedArtifact.where(type='predecessor').resource | ConceptMap.relatedArtifact.where(type='predecessor').resource | EventDefinition.relatedArtifact.where(type='predecessor').resource | EvidenceVariable.relatedArtifact.where(type='predecessor').resource | Library.relatedArtifact.where(type='predecessor').resource | Measure.relatedArtifact.where(type='predecessor').resource | NamingSystem.relatedArtifact.where(type='predecessor').resource | PlanDefinition.relatedArtifact.where(type='predecessor').resource | ValueSet.relatedArtifact.where(type='predecessor').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PREDECESSOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PREDECESSOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PlanDefinition:predecessor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PREDECESSOR = new ca.uhn.fhir.model.api.Include("PlanDefinition:predecessor").toLocked();

 /**
   * Search parameter: <b>successor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='successor').resource | EventDefinition.relatedArtifact.where(type='successor').resource | EvidenceVariable.relatedArtifact.where(type='successor').resource | Library.relatedArtifact.where(type='successor').resource | Measure.relatedArtifact.where(type='successor').resource | PlanDefinition.relatedArtifact.where(type='successor').resource</b><br>
   * </p>
   */
  @SearchParamDefinition(name="successor", path="ActivityDefinition.relatedArtifact.where(type='successor').resource | EventDefinition.relatedArtifact.where(type='successor').resource | EvidenceVariable.relatedArtifact.where(type='successor').resource | Library.relatedArtifact.where(type='successor').resource | Measure.relatedArtifact.where(type='successor').resource | PlanDefinition.relatedArtifact.where(type='successor').resource", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): What resource is being referenced\r\n* [EventDefinition](eventdefinition.html): What resource is being referenced\r\n* [EvidenceVariable](evidencevariable.html): What resource is being referenced\r\n* [Library](library.html): What resource is being referenced\r\n* [Measure](measure.html): What resource is being referenced\r\n* [PlanDefinition](plandefinition.html): What resource is being referenced\r\n", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_SUCCESSOR = "successor";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>successor</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): What resource is being referenced
* [EventDefinition](eventdefinition.html): What resource is being referenced
* [EvidenceVariable](evidencevariable.html): What resource is being referenced
* [Library](library.html): What resource is being referenced
* [Measure](measure.html): What resource is being referenced
* [PlanDefinition](plandefinition.html): What resource is being referenced
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>ActivityDefinition.relatedArtifact.where(type='successor').resource | EventDefinition.relatedArtifact.where(type='successor').resource | EvidenceVariable.relatedArtifact.where(type='successor').resource | Library.relatedArtifact.where(type='successor').resource | Measure.relatedArtifact.where(type='successor').resource | PlanDefinition.relatedArtifact.where(type='successor').resource</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUCCESSOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUCCESSOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PlanDefinition:successor</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUCCESSOR = new ca.uhn.fhir.model.api.Include("PlanDefinition:successor").toLocked();

 /**
   * Search parameter: <b>topic</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Topics associated with the module
* [CodeSystem](codesystem.html): Topics associated with the CodeSystem
* [ConceptMap](conceptmap.html): Topics associated with the ConceptMap
* [EventDefinition](eventdefinition.html): Topics associated with the module
* [EvidenceVariable](evidencevariable.html): Topics associated with the EvidenceVariable
* [Library](library.html): Topics associated with the module
* [Measure](measure.html): Topics associated with the measure
* [NamingSystem](namingsystem.html): Topics associated with the NamingSystem
* [PlanDefinition](plandefinition.html): Topics associated with the module
* [ValueSet](valueset.html): Topics associated with the ValueSet
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.topic | CodeSystem.topic | ConceptMap.topic | EventDefinition.topic | Library.topic | Measure.topic | NamingSystem.topic | PlanDefinition.topic | ValueSet.topic</b><br>
   * </p>
   */
  @SearchParamDefinition(name="topic", path="ActivityDefinition.topic | CodeSystem.topic | ConceptMap.topic | EventDefinition.topic | Library.topic | Measure.topic | NamingSystem.topic | PlanDefinition.topic | ValueSet.topic", description="Multiple Resources: \r\n\r\n* [ActivityDefinition](activitydefinition.html): Topics associated with the module\r\n* [CodeSystem](codesystem.html): Topics associated with the CodeSystem\r\n* [ConceptMap](conceptmap.html): Topics associated with the ConceptMap\r\n* [EventDefinition](eventdefinition.html): Topics associated with the module\r\n* [EvidenceVariable](evidencevariable.html): Topics associated with the EvidenceVariable\r\n* [Library](library.html): Topics associated with the module\r\n* [Measure](measure.html): Topics associated with the measure\r\n* [NamingSystem](namingsystem.html): Topics associated with the NamingSystem\r\n* [PlanDefinition](plandefinition.html): Topics associated with the module\r\n* [ValueSet](valueset.html): Topics associated with the ValueSet\r\n", type="token" )
  public static final String SP_TOPIC = "topic";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>topic</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [ActivityDefinition](activitydefinition.html): Topics associated with the module
* [CodeSystem](codesystem.html): Topics associated with the CodeSystem
* [ConceptMap](conceptmap.html): Topics associated with the ConceptMap
* [EventDefinition](eventdefinition.html): Topics associated with the module
* [EvidenceVariable](evidencevariable.html): Topics associated with the EvidenceVariable
* [Library](library.html): Topics associated with the module
* [Measure](measure.html): Topics associated with the measure
* [NamingSystem](namingsystem.html): Topics associated with the NamingSystem
* [PlanDefinition](plandefinition.html): Topics associated with the module
* [ValueSet](valueset.html): Topics associated with the ValueSet
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>ActivityDefinition.topic | CodeSystem.topic | ConceptMap.topic | EventDefinition.topic | Library.topic | Measure.topic | NamingSystem.topic | PlanDefinition.topic | ValueSet.topic</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TOPIC = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TOPIC);

 /**
   * Search parameter: <b>definition</b>
   * <p>
   * Description: <b>Activity or plan definitions used by plan definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PlanDefinition.action.definition.ofType(canonical) | PlanDefinition.action.definition.ofType(uri)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="definition", path="PlanDefinition.action.definition.ofType(canonical) | PlanDefinition.action.definition.ofType(uri)", description="Activity or plan definitions used by plan definition", type="reference", target={ActivityDefinition.class, MessageDefinition.class, ObservationDefinition.class, PlanDefinition.class, Questionnaire.class, SpecimenDefinition.class } )
  public static final String SP_DEFINITION = "definition";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>definition</b>
   * <p>
   * Description: <b>Activity or plan definitions used by plan definition</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>PlanDefinition.action.definition.ofType(canonical) | PlanDefinition.action.definition.ofType(uri)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam DEFINITION = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_DEFINITION);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>PlanDefinition:definition</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_DEFINITION = new ca.uhn.fhir.model.api.Include("PlanDefinition:definition").toLocked();

 /**
   * Search parameter: <b>type</b>
   * <p>
   * Description: <b>The type of artifact the plan (e.g. order-set, eca-rule, protocol)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PlanDefinition.type</b><br>
   * </p>
   */
  @SearchParamDefinition(name="type", path="PlanDefinition.type", description="The type of artifact the plan (e.g. order-set, eca-rule, protocol)", type="token" )
  public static final String SP_TYPE = "type";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>type</b>
   * <p>
   * Description: <b>The type of artifact the plan (e.g. order-set, eca-rule, protocol)</b><br>
   * Type: <b>token</b><br>
   * Path: <b>PlanDefinition.type</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam TYPE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_TYPE);


}

