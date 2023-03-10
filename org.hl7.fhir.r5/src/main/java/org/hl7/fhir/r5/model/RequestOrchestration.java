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
 * A set of related requests that can be used to capture intended activities that have inter-dependencies such as "give this medication after that one".
 */
@ResourceDef(name="RequestOrchestration", profile="http://hl7.org/fhir/StructureDefinition/RequestOrchestration")
public class RequestOrchestration extends DomainResource {

    @Block()
    public static class RequestOrchestrationActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The linkId of the action from the PlanDefinition that corresponds to this action in the RequestOrchestration resource.
         */
        @Child(name = "linkId", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Pointer to specific item from the PlanDefinition", formalDefinition="The linkId of the action from the PlanDefinition that corresponds to this action in the RequestOrchestration resource." )
        protected StringType linkId;

        /**
         * A user-visible prefix for the action. For example a section or item numbering such as 1. or A.
         */
        @Child(name = "prefix", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="User-visible prefix for the action (e.g. 1. or A.)", formalDefinition="A user-visible prefix for the action. For example a section or item numbering such as 1. or A." )
        protected StringType prefix;

        /**
         * The title of the action displayed to a user.
         */
        @Child(name = "title", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="User-visible title", formalDefinition="The title of the action displayed to a user." )
        protected StringType title;

        /**
         * A short description of the action used to provide a summary to display to the user.
         */
        @Child(name = "description", type = {MarkdownType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Short description of the action", formalDefinition="A short description of the action used to provide a summary to display to the user." )
        protected MarkdownType description;

        /**
         * A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.
         */
        @Child(name = "textEquivalent", type = {MarkdownType.class}, order=5, min=0, max=1, modifier=false, summary=true)
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
         * A code that provides meaning for the action or action group. For example, a section may have a LOINC code for a section of a documentation template.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Code representing the meaning of the action or sub-actions", formalDefinition="A code that provides meaning for the action or action group. For example, a section may have a LOINC code for a section of a documentation template." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-code")
        protected List<CodeableConcept> code;

        /**
         * Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.
         */
        @Child(name = "documentation", type = {RelatedArtifact.class}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Supporting documentation for the intended performer of the action", formalDefinition="Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources." )
        protected List<RelatedArtifact> documentation;

        /**
         * Goals that are intended to be achieved by following the requests in this action.
         */
        @Child(name = "goal", type = {Goal.class}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="What goals", formalDefinition="Goals that are intended to be achieved by following the requests in this action." )
        protected List<Reference> goal;

        /**
         * An expression that describes applicability criteria, or start/stop conditions for the action.
         */
        @Child(name = "condition", type = {}, order=10, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Whether or not the action is applicable", formalDefinition="An expression that describes applicability criteria, or start/stop conditions for the action." )
        protected List<RequestOrchestrationActionConditionComponent> condition;

        /**
         * Defines input data requirements for the action.
         */
        @Child(name = "input", type = {}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Input data requirements", formalDefinition="Defines input data requirements for the action." )
        protected List<RequestOrchestrationActionInputComponent> input;

        /**
         * Defines the outputs of the action, if any.
         */
        @Child(name = "output", type = {}, order=12, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Output data definition", formalDefinition="Defines the outputs of the action, if any." )
        protected List<RequestOrchestrationActionOutputComponent> output;

        /**
         * A relationship to another action such as "before" or "30-60 minutes after start of".
         */
        @Child(name = "relatedAction", type = {}, order=13, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Relationship to another action", formalDefinition="A relationship to another action such as \"before\" or \"30-60 minutes after start of\"." )
        protected List<RequestOrchestrationActionRelatedActionComponent> relatedAction;

        /**
         * An optional value describing when the action should be performed.
         */
        @Child(name = "timing", type = {DateTimeType.class, Age.class, Period.class, Duration.class, Range.class, Timing.class}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the action should take place", formalDefinition="An optional value describing when the action should be performed." )
        protected DataType timing;

        /**
         * Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc.
         */
        @Child(name = "location", type = {CodeableReference.class}, order=15, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Where it should happen", formalDefinition="Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc." )
        protected CodeableReference location;

        /**
         * The participant that should perform or be responsible for this action.
         */
        @Child(name = "participant", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Who should perform the action", formalDefinition="The participant that should perform or be responsible for this action." )
        protected List<RequestOrchestrationActionParticipantComponent> participant;

        /**
         * The type of action to perform (create, update, remove).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=17, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="create | update | remove | fire-event", formalDefinition="The type of action to perform (create, update, remove)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-type")
        protected CodeableConcept type;

        /**
         * Defines the grouping behavior for the action and its children.
         */
        @Child(name = "groupingBehavior", type = {CodeType.class}, order=18, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="visual-group | logical-group | sentence-group", formalDefinition="Defines the grouping behavior for the action and its children." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-grouping-behavior")
        protected Enumeration<ActionGroupingBehavior> groupingBehavior;

        /**
         * Defines the selection behavior for the action and its children.
         */
        @Child(name = "selectionBehavior", type = {CodeType.class}, order=19, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="any | all | all-or-none | exactly-one | at-most-one | one-or-more", formalDefinition="Defines the selection behavior for the action and its children." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-selection-behavior")
        protected Enumeration<ActionSelectionBehavior> selectionBehavior;

        /**
         * Defines expectations around whether an action is required.
         */
        @Child(name = "requiredBehavior", type = {CodeType.class}, order=20, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="must | could | must-unless-documented", formalDefinition="Defines expectations around whether an action is required." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-required-behavior")
        protected Enumeration<ActionRequiredBehavior> requiredBehavior;

        /**
         * Defines whether the action should usually be preselected.
         */
        @Child(name = "precheckBehavior", type = {CodeType.class}, order=21, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="yes | no", formalDefinition="Defines whether the action should usually be preselected." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-precheck-behavior")
        protected Enumeration<ActionPrecheckBehavior> precheckBehavior;

        /**
         * Defines whether the action can be selected multiple times.
         */
        @Child(name = "cardinalityBehavior", type = {CodeType.class}, order=22, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="single | multiple", formalDefinition="Defines whether the action can be selected multiple times." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-cardinality-behavior")
        protected Enumeration<ActionCardinalityBehavior> cardinalityBehavior;

        /**
         * The resource that is the target of the action (e.g. CommunicationRequest).
         */
        @Child(name = "resource", type = {Reference.class}, order=23, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The target of the action", formalDefinition="The resource that is the target of the action (e.g. CommunicationRequest)." )
        protected Reference resource;

        /**
         * A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.
         */
        @Child(name = "definition", type = {CanonicalType.class, UriType.class}, order=24, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Description of the activity to be performed", formalDefinition="A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured." )
        protected DataType definition;

        /**
         * A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.
         */
        @Child(name = "transform", type = {CanonicalType.class}, order=25, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Transform to apply the template", formalDefinition="A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input." )
        protected CanonicalType transform;

        /**
         * Customizations that should be applied to the statically defined resource. For example, if the dosage of a medication must be computed based on the patient's weight, a customization would be used to specify an expression that calculated the weight, and the path on the resource that would contain the result.
         */
        @Child(name = "dynamicValue", type = {}, order=26, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Dynamic aspects of the definition", formalDefinition="Customizations that should be applied to the statically defined resource. For example, if the dosage of a medication must be computed based on the patient's weight, a customization would be used to specify an expression that calculated the weight, and the path on the resource that would contain the result." )
        protected List<RequestOrchestrationActionDynamicValueComponent> dynamicValue;

        /**
         * Sub actions.
         */
        @Child(name = "action", type = {RequestOrchestrationActionComponent.class}, order=27, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Sub action", formalDefinition="Sub actions." )
        protected List<RequestOrchestrationActionComponent> action;

        private static final long serialVersionUID = -1292193514L;

    /**
     * Constructor
     */
      public RequestOrchestrationActionComponent() {
        super();
      }

        /**
         * @return {@link #linkId} (The linkId of the action from the PlanDefinition that corresponds to this action in the RequestOrchestration resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public StringType getLinkIdElement() { 
          if (this.linkId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.linkId");
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
         * @param value {@link #linkId} (The linkId of the action from the PlanDefinition that corresponds to this action in the RequestOrchestration resource.). This is the underlying object with id, value and extensions. The accessor "getLinkId" gives direct access to the value
         */
        public RequestOrchestrationActionComponent setLinkIdElement(StringType value) { 
          this.linkId = value;
          return this;
        }

        /**
         * @return The linkId of the action from the PlanDefinition that corresponds to this action in the RequestOrchestration resource.
         */
        public String getLinkId() { 
          return this.linkId == null ? null : this.linkId.getValue();
        }

        /**
         * @param value The linkId of the action from the PlanDefinition that corresponds to this action in the RequestOrchestration resource.
         */
        public RequestOrchestrationActionComponent setLinkId(String value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.prefix");
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
        public RequestOrchestrationActionComponent setPrefixElement(StringType value) { 
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
        public RequestOrchestrationActionComponent setPrefix(String value) { 
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
         * @return {@link #title} (The title of the action displayed to a user.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.title");
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
         * @param value {@link #title} (The title of the action displayed to a user.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public RequestOrchestrationActionComponent setTitleElement(StringType value) { 
          this.title = value;
          return this;
        }

        /**
         * @return The title of the action displayed to a user.
         */
        public String getTitle() { 
          return this.title == null ? null : this.title.getValue();
        }

        /**
         * @param value The title of the action displayed to a user.
         */
        public RequestOrchestrationActionComponent setTitle(String value) { 
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
         * @return {@link #description} (A short description of the action used to provide a summary to display to the user.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public MarkdownType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.description");
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
         * @param value {@link #description} (A short description of the action used to provide a summary to display to the user.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public RequestOrchestrationActionComponent setDescriptionElement(MarkdownType value) { 
          this.description = value;
          return this;
        }

        /**
         * @return A short description of the action used to provide a summary to display to the user.
         */
        public String getDescription() { 
          return this.description == null ? null : this.description.getValue();
        }

        /**
         * @param value A short description of the action used to provide a summary to display to the user.
         */
        public RequestOrchestrationActionComponent setDescription(String value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.textEquivalent");
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
        public RequestOrchestrationActionComponent setTextEquivalentElement(MarkdownType value) { 
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
        public RequestOrchestrationActionComponent setTextEquivalent(String value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.priority");
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
        public RequestOrchestrationActionComponent setPriorityElement(Enumeration<RequestPriority> value) { 
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
        public RequestOrchestrationActionComponent setPriority(RequestPriority value) { 
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
         * @return {@link #code} (A code that provides meaning for the action or action group. For example, a section may have a LOINC code for a section of a documentation template.)
         */
        public List<CodeableConcept> getCode() { 
          if (this.code == null)
            this.code = new ArrayList<CodeableConcept>();
          return this.code;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestOrchestrationActionComponent setCode(List<CodeableConcept> theCode) { 
          this.code = theCode;
          return this;
        }

        public boolean hasCode() { 
          if (this.code == null)
            return false;
          for (CodeableConcept item : this.code)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public CodeableConcept addCode() { //3
          CodeableConcept t = new CodeableConcept();
          if (this.code == null)
            this.code = new ArrayList<CodeableConcept>();
          this.code.add(t);
          return t;
        }

        public RequestOrchestrationActionComponent addCode(CodeableConcept t) { //3
          if (t == null)
            return this;
          if (this.code == null)
            this.code = new ArrayList<CodeableConcept>();
          this.code.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #code}, creating it if it does not already exist {3}
         */
        public CodeableConcept getCodeFirstRep() { 
          if (getCode().isEmpty()) {
            addCode();
          }
          return getCode().get(0);
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
        public RequestOrchestrationActionComponent setDocumentation(List<RelatedArtifact> theDocumentation) { 
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

        public RequestOrchestrationActionComponent addDocumentation(RelatedArtifact t) { //3
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
         * @return {@link #goal} (Goals that are intended to be achieved by following the requests in this action.)
         */
        public List<Reference> getGoal() { 
          if (this.goal == null)
            this.goal = new ArrayList<Reference>();
          return this.goal;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestOrchestrationActionComponent setGoal(List<Reference> theGoal) { 
          this.goal = theGoal;
          return this;
        }

        public boolean hasGoal() { 
          if (this.goal == null)
            return false;
          for (Reference item : this.goal)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addGoal() { //3
          Reference t = new Reference();
          if (this.goal == null)
            this.goal = new ArrayList<Reference>();
          this.goal.add(t);
          return t;
        }

        public RequestOrchestrationActionComponent addGoal(Reference t) { //3
          if (t == null)
            return this;
          if (this.goal == null)
            this.goal = new ArrayList<Reference>();
          this.goal.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #goal}, creating it if it does not already exist {3}
         */
        public Reference getGoalFirstRep() { 
          if (getGoal().isEmpty()) {
            addGoal();
          }
          return getGoal().get(0);
        }

        /**
         * @return {@link #condition} (An expression that describes applicability criteria, or start/stop conditions for the action.)
         */
        public List<RequestOrchestrationActionConditionComponent> getCondition() { 
          if (this.condition == null)
            this.condition = new ArrayList<RequestOrchestrationActionConditionComponent>();
          return this.condition;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestOrchestrationActionComponent setCondition(List<RequestOrchestrationActionConditionComponent> theCondition) { 
          this.condition = theCondition;
          return this;
        }

        public boolean hasCondition() { 
          if (this.condition == null)
            return false;
          for (RequestOrchestrationActionConditionComponent item : this.condition)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestOrchestrationActionConditionComponent addCondition() { //3
          RequestOrchestrationActionConditionComponent t = new RequestOrchestrationActionConditionComponent();
          if (this.condition == null)
            this.condition = new ArrayList<RequestOrchestrationActionConditionComponent>();
          this.condition.add(t);
          return t;
        }

        public RequestOrchestrationActionComponent addCondition(RequestOrchestrationActionConditionComponent t) { //3
          if (t == null)
            return this;
          if (this.condition == null)
            this.condition = new ArrayList<RequestOrchestrationActionConditionComponent>();
          this.condition.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #condition}, creating it if it does not already exist {3}
         */
        public RequestOrchestrationActionConditionComponent getConditionFirstRep() { 
          if (getCondition().isEmpty()) {
            addCondition();
          }
          return getCondition().get(0);
        }

        /**
         * @return {@link #input} (Defines input data requirements for the action.)
         */
        public List<RequestOrchestrationActionInputComponent> getInput() { 
          if (this.input == null)
            this.input = new ArrayList<RequestOrchestrationActionInputComponent>();
          return this.input;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestOrchestrationActionComponent setInput(List<RequestOrchestrationActionInputComponent> theInput) { 
          this.input = theInput;
          return this;
        }

        public boolean hasInput() { 
          if (this.input == null)
            return false;
          for (RequestOrchestrationActionInputComponent item : this.input)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestOrchestrationActionInputComponent addInput() { //3
          RequestOrchestrationActionInputComponent t = new RequestOrchestrationActionInputComponent();
          if (this.input == null)
            this.input = new ArrayList<RequestOrchestrationActionInputComponent>();
          this.input.add(t);
          return t;
        }

        public RequestOrchestrationActionComponent addInput(RequestOrchestrationActionInputComponent t) { //3
          if (t == null)
            return this;
          if (this.input == null)
            this.input = new ArrayList<RequestOrchestrationActionInputComponent>();
          this.input.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #input}, creating it if it does not already exist {3}
         */
        public RequestOrchestrationActionInputComponent getInputFirstRep() { 
          if (getInput().isEmpty()) {
            addInput();
          }
          return getInput().get(0);
        }

        /**
         * @return {@link #output} (Defines the outputs of the action, if any.)
         */
        public List<RequestOrchestrationActionOutputComponent> getOutput() { 
          if (this.output == null)
            this.output = new ArrayList<RequestOrchestrationActionOutputComponent>();
          return this.output;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestOrchestrationActionComponent setOutput(List<RequestOrchestrationActionOutputComponent> theOutput) { 
          this.output = theOutput;
          return this;
        }

        public boolean hasOutput() { 
          if (this.output == null)
            return false;
          for (RequestOrchestrationActionOutputComponent item : this.output)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestOrchestrationActionOutputComponent addOutput() { //3
          RequestOrchestrationActionOutputComponent t = new RequestOrchestrationActionOutputComponent();
          if (this.output == null)
            this.output = new ArrayList<RequestOrchestrationActionOutputComponent>();
          this.output.add(t);
          return t;
        }

        public RequestOrchestrationActionComponent addOutput(RequestOrchestrationActionOutputComponent t) { //3
          if (t == null)
            return this;
          if (this.output == null)
            this.output = new ArrayList<RequestOrchestrationActionOutputComponent>();
          this.output.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #output}, creating it if it does not already exist {3}
         */
        public RequestOrchestrationActionOutputComponent getOutputFirstRep() { 
          if (getOutput().isEmpty()) {
            addOutput();
          }
          return getOutput().get(0);
        }

        /**
         * @return {@link #relatedAction} (A relationship to another action such as "before" or "30-60 minutes after start of".)
         */
        public List<RequestOrchestrationActionRelatedActionComponent> getRelatedAction() { 
          if (this.relatedAction == null)
            this.relatedAction = new ArrayList<RequestOrchestrationActionRelatedActionComponent>();
          return this.relatedAction;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestOrchestrationActionComponent setRelatedAction(List<RequestOrchestrationActionRelatedActionComponent> theRelatedAction) { 
          this.relatedAction = theRelatedAction;
          return this;
        }

        public boolean hasRelatedAction() { 
          if (this.relatedAction == null)
            return false;
          for (RequestOrchestrationActionRelatedActionComponent item : this.relatedAction)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestOrchestrationActionRelatedActionComponent addRelatedAction() { //3
          RequestOrchestrationActionRelatedActionComponent t = new RequestOrchestrationActionRelatedActionComponent();
          if (this.relatedAction == null)
            this.relatedAction = new ArrayList<RequestOrchestrationActionRelatedActionComponent>();
          this.relatedAction.add(t);
          return t;
        }

        public RequestOrchestrationActionComponent addRelatedAction(RequestOrchestrationActionRelatedActionComponent t) { //3
          if (t == null)
            return this;
          if (this.relatedAction == null)
            this.relatedAction = new ArrayList<RequestOrchestrationActionRelatedActionComponent>();
          this.relatedAction.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #relatedAction}, creating it if it does not already exist {3}
         */
        public RequestOrchestrationActionRelatedActionComponent getRelatedActionFirstRep() { 
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
        public DateTimeType getTimingDateTimeType() throws FHIRException { 
          if (this.timing == null)
            this.timing = new DateTimeType();
          if (!(this.timing instanceof DateTimeType))
            throw new FHIRException("Type mismatch: the type DateTimeType was expected, but "+this.timing.getClass().getName()+" was encountered");
          return (DateTimeType) this.timing;
        }

        public boolean hasTimingDateTimeType() { 
          return this != null && this.timing instanceof DateTimeType;
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
        public Period getTimingPeriod() throws FHIRException { 
          if (this.timing == null)
            this.timing = new Period();
          if (!(this.timing instanceof Period))
            throw new FHIRException("Type mismatch: the type Period was expected, but "+this.timing.getClass().getName()+" was encountered");
          return (Period) this.timing;
        }

        public boolean hasTimingPeriod() { 
          return this != null && this.timing instanceof Period;
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
        public RequestOrchestrationActionComponent setTiming(DataType value) { 
          if (value != null && !(value instanceof DateTimeType || value instanceof Age || value instanceof Period || value instanceof Duration || value instanceof Range || value instanceof Timing))
            throw new FHIRException("Not the right type for RequestOrchestration.action.timing[x]: "+value.fhirType());
          this.timing = value;
          return this;
        }

        /**
         * @return {@link #location} (Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc.)
         */
        public CodeableReference getLocation() { 
          if (this.location == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.location");
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
        public RequestOrchestrationActionComponent setLocation(CodeableReference value) { 
          this.location = value;
          return this;
        }

        /**
         * @return {@link #participant} (The participant that should perform or be responsible for this action.)
         */
        public List<RequestOrchestrationActionParticipantComponent> getParticipant() { 
          if (this.participant == null)
            this.participant = new ArrayList<RequestOrchestrationActionParticipantComponent>();
          return this.participant;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestOrchestrationActionComponent setParticipant(List<RequestOrchestrationActionParticipantComponent> theParticipant) { 
          this.participant = theParticipant;
          return this;
        }

        public boolean hasParticipant() { 
          if (this.participant == null)
            return false;
          for (RequestOrchestrationActionParticipantComponent item : this.participant)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestOrchestrationActionParticipantComponent addParticipant() { //3
          RequestOrchestrationActionParticipantComponent t = new RequestOrchestrationActionParticipantComponent();
          if (this.participant == null)
            this.participant = new ArrayList<RequestOrchestrationActionParticipantComponent>();
          this.participant.add(t);
          return t;
        }

        public RequestOrchestrationActionComponent addParticipant(RequestOrchestrationActionParticipantComponent t) { //3
          if (t == null)
            return this;
          if (this.participant == null)
            this.participant = new ArrayList<RequestOrchestrationActionParticipantComponent>();
          this.participant.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
         */
        public RequestOrchestrationActionParticipantComponent getParticipantFirstRep() { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.type");
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
        public RequestOrchestrationActionComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #groupingBehavior} (Defines the grouping behavior for the action and its children.). This is the underlying object with id, value and extensions. The accessor "getGroupingBehavior" gives direct access to the value
         */
        public Enumeration<ActionGroupingBehavior> getGroupingBehaviorElement() { 
          if (this.groupingBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.groupingBehavior");
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
        public RequestOrchestrationActionComponent setGroupingBehaviorElement(Enumeration<ActionGroupingBehavior> value) { 
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
        public RequestOrchestrationActionComponent setGroupingBehavior(ActionGroupingBehavior value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.selectionBehavior");
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
        public RequestOrchestrationActionComponent setSelectionBehaviorElement(Enumeration<ActionSelectionBehavior> value) { 
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
        public RequestOrchestrationActionComponent setSelectionBehavior(ActionSelectionBehavior value) { 
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
         * @return {@link #requiredBehavior} (Defines expectations around whether an action is required.). This is the underlying object with id, value and extensions. The accessor "getRequiredBehavior" gives direct access to the value
         */
        public Enumeration<ActionRequiredBehavior> getRequiredBehaviorElement() { 
          if (this.requiredBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.requiredBehavior");
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
         * @param value {@link #requiredBehavior} (Defines expectations around whether an action is required.). This is the underlying object with id, value and extensions. The accessor "getRequiredBehavior" gives direct access to the value
         */
        public RequestOrchestrationActionComponent setRequiredBehaviorElement(Enumeration<ActionRequiredBehavior> value) { 
          this.requiredBehavior = value;
          return this;
        }

        /**
         * @return Defines expectations around whether an action is required.
         */
        public ActionRequiredBehavior getRequiredBehavior() { 
          return this.requiredBehavior == null ? null : this.requiredBehavior.getValue();
        }

        /**
         * @param value Defines expectations around whether an action is required.
         */
        public RequestOrchestrationActionComponent setRequiredBehavior(ActionRequiredBehavior value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.precheckBehavior");
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
        public RequestOrchestrationActionComponent setPrecheckBehaviorElement(Enumeration<ActionPrecheckBehavior> value) { 
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
        public RequestOrchestrationActionComponent setPrecheckBehavior(ActionPrecheckBehavior value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.cardinalityBehavior");
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
        public RequestOrchestrationActionComponent setCardinalityBehaviorElement(Enumeration<ActionCardinalityBehavior> value) { 
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
        public RequestOrchestrationActionComponent setCardinalityBehavior(ActionCardinalityBehavior value) { 
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
         * @return {@link #resource} (The resource that is the target of the action (e.g. CommunicationRequest).)
         */
        public Reference getResource() { 
          if (this.resource == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.resource");
            else if (Configuration.doAutoCreate())
              this.resource = new Reference(); // cc
          return this.resource;
        }

        public boolean hasResource() { 
          return this.resource != null && !this.resource.isEmpty();
        }

        /**
         * @param value {@link #resource} (The resource that is the target of the action (e.g. CommunicationRequest).)
         */
        public RequestOrchestrationActionComponent setResource(Reference value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return {@link #definition} (A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.)
         */
        public DataType getDefinition() { 
          return this.definition;
        }

        /**
         * @return {@link #definition} (A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.)
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
         * @return {@link #definition} (A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.)
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
         * @param value {@link #definition} (A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.)
         */
        public RequestOrchestrationActionComponent setDefinition(DataType value) { 
          if (value != null && !(value instanceof CanonicalType || value instanceof UriType))
            throw new FHIRException("Not the right type for RequestOrchestration.action.definition[x]: "+value.fhirType());
          this.definition = value;
          return this;
        }

        /**
         * @return {@link #transform} (A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.). This is the underlying object with id, value and extensions. The accessor "getTransform" gives direct access to the value
         */
        public CanonicalType getTransformElement() { 
          if (this.transform == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionComponent.transform");
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
        public RequestOrchestrationActionComponent setTransformElement(CanonicalType value) { 
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
        public RequestOrchestrationActionComponent setTransform(String value) { 
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
        public List<RequestOrchestrationActionDynamicValueComponent> getDynamicValue() { 
          if (this.dynamicValue == null)
            this.dynamicValue = new ArrayList<RequestOrchestrationActionDynamicValueComponent>();
          return this.dynamicValue;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestOrchestrationActionComponent setDynamicValue(List<RequestOrchestrationActionDynamicValueComponent> theDynamicValue) { 
          this.dynamicValue = theDynamicValue;
          return this;
        }

        public boolean hasDynamicValue() { 
          if (this.dynamicValue == null)
            return false;
          for (RequestOrchestrationActionDynamicValueComponent item : this.dynamicValue)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestOrchestrationActionDynamicValueComponent addDynamicValue() { //3
          RequestOrchestrationActionDynamicValueComponent t = new RequestOrchestrationActionDynamicValueComponent();
          if (this.dynamicValue == null)
            this.dynamicValue = new ArrayList<RequestOrchestrationActionDynamicValueComponent>();
          this.dynamicValue.add(t);
          return t;
        }

        public RequestOrchestrationActionComponent addDynamicValue(RequestOrchestrationActionDynamicValueComponent t) { //3
          if (t == null)
            return this;
          if (this.dynamicValue == null)
            this.dynamicValue = new ArrayList<RequestOrchestrationActionDynamicValueComponent>();
          this.dynamicValue.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #dynamicValue}, creating it if it does not already exist {3}
         */
        public RequestOrchestrationActionDynamicValueComponent getDynamicValueFirstRep() { 
          if (getDynamicValue().isEmpty()) {
            addDynamicValue();
          }
          return getDynamicValue().get(0);
        }

        /**
         * @return {@link #action} (Sub actions.)
         */
        public List<RequestOrchestrationActionComponent> getAction() { 
          if (this.action == null)
            this.action = new ArrayList<RequestOrchestrationActionComponent>();
          return this.action;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestOrchestrationActionComponent setAction(List<RequestOrchestrationActionComponent> theAction) { 
          this.action = theAction;
          return this;
        }

        public boolean hasAction() { 
          if (this.action == null)
            return false;
          for (RequestOrchestrationActionComponent item : this.action)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestOrchestrationActionComponent addAction() { //3
          RequestOrchestrationActionComponent t = new RequestOrchestrationActionComponent();
          if (this.action == null)
            this.action = new ArrayList<RequestOrchestrationActionComponent>();
          this.action.add(t);
          return t;
        }

        public RequestOrchestrationActionComponent addAction(RequestOrchestrationActionComponent t) { //3
          if (t == null)
            return this;
          if (this.action == null)
            this.action = new ArrayList<RequestOrchestrationActionComponent>();
          this.action.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
         */
        public RequestOrchestrationActionComponent getActionFirstRep() { 
          if (getAction().isEmpty()) {
            addAction();
          }
          return getAction().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("linkId", "string", "The linkId of the action from the PlanDefinition that corresponds to this action in the RequestOrchestration resource.", 0, 1, linkId));
          children.add(new Property("prefix", "string", "A user-visible prefix for the action. For example a section or item numbering such as 1. or A.", 0, 1, prefix));
          children.add(new Property("title", "string", "The title of the action displayed to a user.", 0, 1, title));
          children.add(new Property("description", "markdown", "A short description of the action used to provide a summary to display to the user.", 0, 1, description));
          children.add(new Property("textEquivalent", "markdown", "A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.", 0, 1, textEquivalent));
          children.add(new Property("priority", "code", "Indicates how quickly the action should be addressed with respect to other actions.", 0, 1, priority));
          children.add(new Property("code", "CodeableConcept", "A code that provides meaning for the action or action group. For example, a section may have a LOINC code for a section of a documentation template.", 0, java.lang.Integer.MAX_VALUE, code));
          children.add(new Property("documentation", "RelatedArtifact", "Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.", 0, java.lang.Integer.MAX_VALUE, documentation));
          children.add(new Property("goal", "Reference(Goal)", "Goals that are intended to be achieved by following the requests in this action.", 0, java.lang.Integer.MAX_VALUE, goal));
          children.add(new Property("condition", "", "An expression that describes applicability criteria, or start/stop conditions for the action.", 0, java.lang.Integer.MAX_VALUE, condition));
          children.add(new Property("input", "", "Defines input data requirements for the action.", 0, java.lang.Integer.MAX_VALUE, input));
          children.add(new Property("output", "", "Defines the outputs of the action, if any.", 0, java.lang.Integer.MAX_VALUE, output));
          children.add(new Property("relatedAction", "", "A relationship to another action such as \"before\" or \"30-60 minutes after start of\".", 0, java.lang.Integer.MAX_VALUE, relatedAction));
          children.add(new Property("timing[x]", "dateTime|Age|Period|Duration|Range|Timing", "An optional value describing when the action should be performed.", 0, 1, timing));
          children.add(new Property("location", "CodeableReference(Location)", "Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc.", 0, 1, location));
          children.add(new Property("participant", "", "The participant that should perform or be responsible for this action.", 0, java.lang.Integer.MAX_VALUE, participant));
          children.add(new Property("type", "CodeableConcept", "The type of action to perform (create, update, remove).", 0, 1, type));
          children.add(new Property("groupingBehavior", "code", "Defines the grouping behavior for the action and its children.", 0, 1, groupingBehavior));
          children.add(new Property("selectionBehavior", "code", "Defines the selection behavior for the action and its children.", 0, 1, selectionBehavior));
          children.add(new Property("requiredBehavior", "code", "Defines expectations around whether an action is required.", 0, 1, requiredBehavior));
          children.add(new Property("precheckBehavior", "code", "Defines whether the action should usually be preselected.", 0, 1, precheckBehavior));
          children.add(new Property("cardinalityBehavior", "code", "Defines whether the action can be selected multiple times.", 0, 1, cardinalityBehavior));
          children.add(new Property("resource", "Reference(Any)", "The resource that is the target of the action (e.g. CommunicationRequest).", 0, 1, resource));
          children.add(new Property("definition[x]", "canonical(ActivityDefinition|ObservationDefinition|PlanDefinition|Questionnaire|SpecimenDefinition)|uri", "A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition));
          children.add(new Property("transform", "canonical(StructureMap)", "A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.", 0, 1, transform));
          children.add(new Property("dynamicValue", "", "Customizations that should be applied to the statically defined resource. For example, if the dosage of a medication must be computed based on the patient's weight, a customization would be used to specify an expression that calculated the weight, and the path on the resource that would contain the result.", 0, java.lang.Integer.MAX_VALUE, dynamicValue));
          children.add(new Property("action", "@RequestOrchestration.action", "Sub actions.", 0, java.lang.Integer.MAX_VALUE, action));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1102667083: /*linkId*/  return new Property("linkId", "string", "The linkId of the action from the PlanDefinition that corresponds to this action in the RequestOrchestration resource.", 0, 1, linkId);
          case -980110702: /*prefix*/  return new Property("prefix", "string", "A user-visible prefix for the action. For example a section or item numbering such as 1. or A.", 0, 1, prefix);
          case 110371416: /*title*/  return new Property("title", "string", "The title of the action displayed to a user.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "markdown", "A short description of the action used to provide a summary to display to the user.", 0, 1, description);
          case -900391049: /*textEquivalent*/  return new Property("textEquivalent", "markdown", "A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.", 0, 1, textEquivalent);
          case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly the action should be addressed with respect to other actions.", 0, 1, priority);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that provides meaning for the action or action group. For example, a section may have a LOINC code for a section of a documentation template.", 0, java.lang.Integer.MAX_VALUE, code);
          case 1587405498: /*documentation*/  return new Property("documentation", "RelatedArtifact", "Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.", 0, java.lang.Integer.MAX_VALUE, documentation);
          case 3178259: /*goal*/  return new Property("goal", "Reference(Goal)", "Goals that are intended to be achieved by following the requests in this action.", 0, java.lang.Integer.MAX_VALUE, goal);
          case -861311717: /*condition*/  return new Property("condition", "", "An expression that describes applicability criteria, or start/stop conditions for the action.", 0, java.lang.Integer.MAX_VALUE, condition);
          case 100358090: /*input*/  return new Property("input", "", "Defines input data requirements for the action.", 0, java.lang.Integer.MAX_VALUE, input);
          case -1005512447: /*output*/  return new Property("output", "", "Defines the outputs of the action, if any.", 0, java.lang.Integer.MAX_VALUE, output);
          case -384107967: /*relatedAction*/  return new Property("relatedAction", "", "A relationship to another action such as \"before\" or \"30-60 minutes after start of\".", 0, java.lang.Integer.MAX_VALUE, relatedAction);
          case 164632566: /*timing[x]*/  return new Property("timing[x]", "dateTime|Age|Period|Duration|Range|Timing", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -873664438: /*timing*/  return new Property("timing[x]", "dateTime|Age|Period|Duration|Range|Timing", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -1837458939: /*timingDateTime*/  return new Property("timing[x]", "dateTime", "An optional value describing when the action should be performed.", 0, 1, timing);
          case 164607061: /*timingAge*/  return new Property("timing[x]", "Age", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -615615829: /*timingPeriod*/  return new Property("timing[x]", "Period", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -1327253506: /*timingDuration*/  return new Property("timing[x]", "Duration", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -710871277: /*timingRange*/  return new Property("timing[x]", "Range", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -497554124: /*timingTiming*/  return new Property("timing[x]", "Timing", "An optional value describing when the action should be performed.", 0, 1, timing);
          case 1901043637: /*location*/  return new Property("location", "CodeableReference(Location)", "Identifies the facility where the action will occur; e.g. home, hospital, specific clinic, etc.", 0, 1, location);
          case 767422259: /*participant*/  return new Property("participant", "", "The participant that should perform or be responsible for this action.", 0, java.lang.Integer.MAX_VALUE, participant);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of action to perform (create, update, remove).", 0, 1, type);
          case 586678389: /*groupingBehavior*/  return new Property("groupingBehavior", "code", "Defines the grouping behavior for the action and its children.", 0, 1, groupingBehavior);
          case 168639486: /*selectionBehavior*/  return new Property("selectionBehavior", "code", "Defines the selection behavior for the action and its children.", 0, 1, selectionBehavior);
          case -1163906287: /*requiredBehavior*/  return new Property("requiredBehavior", "code", "Defines expectations around whether an action is required.", 0, 1, requiredBehavior);
          case -1174249033: /*precheckBehavior*/  return new Property("precheckBehavior", "code", "Defines whether the action should usually be preselected.", 0, 1, precheckBehavior);
          case -922577408: /*cardinalityBehavior*/  return new Property("cardinalityBehavior", "code", "Defines whether the action can be selected multiple times.", 0, 1, cardinalityBehavior);
          case -341064690: /*resource*/  return new Property("resource", "Reference(Any)", "The resource that is the target of the action (e.g. CommunicationRequest).", 0, 1, resource);
          case -1139422643: /*definition[x]*/  return new Property("definition[x]", "canonical(ActivityDefinition|ObservationDefinition|PlanDefinition|Questionnaire|SpecimenDefinition)|uri", "A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition);
          case -1014418093: /*definition*/  return new Property("definition[x]", "canonical(ActivityDefinition|ObservationDefinition|PlanDefinition|Questionnaire|SpecimenDefinition)|uri", "A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition);
          case 933485793: /*definitionCanonical*/  return new Property("definition[x]", "canonical(ActivityDefinition|ObservationDefinition|PlanDefinition|Questionnaire|SpecimenDefinition)", "A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition);
          case -1139428583: /*definitionUri*/  return new Property("definition[x]", "uri", "A reference to an ActivityDefinition that describes the action to be taken in detail, a PlanDefinition that describes a series of actions to be taken, a Questionnaire that should be filled out, a SpecimenDefinition describing a specimen to be collected, or an ObservationDefinition that specifies what observation should be captured.", 0, 1, definition);
          case 1052666732: /*transform*/  return new Property("transform", "canonical(StructureMap)", "A reference to a StructureMap resource that defines a transform that can be executed to produce the intent resource using the ActivityDefinition instance as the input.", 0, 1, transform);
          case 572625010: /*dynamicValue*/  return new Property("dynamicValue", "", "Customizations that should be applied to the statically defined resource. For example, if the dosage of a medication must be computed based on the patient's weight, a customization would be used to specify an expression that calculated the weight, and the path on the resource that would contain the result.", 0, java.lang.Integer.MAX_VALUE, dynamicValue);
          case -1422950858: /*action*/  return new Property("action", "@RequestOrchestration.action", "Sub actions.", 0, java.lang.Integer.MAX_VALUE, action);
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
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // CodeableConcept
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : this.documentation.toArray(new Base[this.documentation.size()]); // RelatedArtifact
        case 3178259: /*goal*/ return this.goal == null ? new Base[0] : this.goal.toArray(new Base[this.goal.size()]); // Reference
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : this.condition.toArray(new Base[this.condition.size()]); // RequestOrchestrationActionConditionComponent
        case 100358090: /*input*/ return this.input == null ? new Base[0] : this.input.toArray(new Base[this.input.size()]); // RequestOrchestrationActionInputComponent
        case -1005512447: /*output*/ return this.output == null ? new Base[0] : this.output.toArray(new Base[this.output.size()]); // RequestOrchestrationActionOutputComponent
        case -384107967: /*relatedAction*/ return this.relatedAction == null ? new Base[0] : this.relatedAction.toArray(new Base[this.relatedAction.size()]); // RequestOrchestrationActionRelatedActionComponent
        case -873664438: /*timing*/ return this.timing == null ? new Base[0] : new Base[] {this.timing}; // DataType
        case 1901043637: /*location*/ return this.location == null ? new Base[0] : new Base[] {this.location}; // CodeableReference
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // RequestOrchestrationActionParticipantComponent
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 586678389: /*groupingBehavior*/ return this.groupingBehavior == null ? new Base[0] : new Base[] {this.groupingBehavior}; // Enumeration<ActionGroupingBehavior>
        case 168639486: /*selectionBehavior*/ return this.selectionBehavior == null ? new Base[0] : new Base[] {this.selectionBehavior}; // Enumeration<ActionSelectionBehavior>
        case -1163906287: /*requiredBehavior*/ return this.requiredBehavior == null ? new Base[0] : new Base[] {this.requiredBehavior}; // Enumeration<ActionRequiredBehavior>
        case -1174249033: /*precheckBehavior*/ return this.precheckBehavior == null ? new Base[0] : new Base[] {this.precheckBehavior}; // Enumeration<ActionPrecheckBehavior>
        case -922577408: /*cardinalityBehavior*/ return this.cardinalityBehavior == null ? new Base[0] : new Base[] {this.cardinalityBehavior}; // Enumeration<ActionCardinalityBehavior>
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // Reference
        case -1014418093: /*definition*/ return this.definition == null ? new Base[0] : new Base[] {this.definition}; // DataType
        case 1052666732: /*transform*/ return this.transform == null ? new Base[0] : new Base[] {this.transform}; // CanonicalType
        case 572625010: /*dynamicValue*/ return this.dynamicValue == null ? new Base[0] : this.dynamicValue.toArray(new Base[this.dynamicValue.size()]); // RequestOrchestrationActionDynamicValueComponent
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // RequestOrchestrationActionComponent
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
          this.getCode().add(TypeConvertor.castToCodeableConcept(value)); // CodeableConcept
          return value;
        case 1587405498: // documentation
          this.getDocumentation().add(TypeConvertor.castToRelatedArtifact(value)); // RelatedArtifact
          return value;
        case 3178259: // goal
          this.getGoal().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -861311717: // condition
          this.getCondition().add((RequestOrchestrationActionConditionComponent) value); // RequestOrchestrationActionConditionComponent
          return value;
        case 100358090: // input
          this.getInput().add((RequestOrchestrationActionInputComponent) value); // RequestOrchestrationActionInputComponent
          return value;
        case -1005512447: // output
          this.getOutput().add((RequestOrchestrationActionOutputComponent) value); // RequestOrchestrationActionOutputComponent
          return value;
        case -384107967: // relatedAction
          this.getRelatedAction().add((RequestOrchestrationActionRelatedActionComponent) value); // RequestOrchestrationActionRelatedActionComponent
          return value;
        case -873664438: // timing
          this.timing = TypeConvertor.castToType(value); // DataType
          return value;
        case 1901043637: // location
          this.location = TypeConvertor.castToCodeableReference(value); // CodeableReference
          return value;
        case 767422259: // participant
          this.getParticipant().add((RequestOrchestrationActionParticipantComponent) value); // RequestOrchestrationActionParticipantComponent
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
        case -341064690: // resource
          this.resource = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1014418093: // definition
          this.definition = TypeConvertor.castToType(value); // DataType
          return value;
        case 1052666732: // transform
          this.transform = TypeConvertor.castToCanonical(value); // CanonicalType
          return value;
        case 572625010: // dynamicValue
          this.getDynamicValue().add((RequestOrchestrationActionDynamicValueComponent) value); // RequestOrchestrationActionDynamicValueComponent
          return value;
        case -1422950858: // action
          this.getAction().add((RequestOrchestrationActionComponent) value); // RequestOrchestrationActionComponent
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
          this.getCode().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("documentation")) {
          this.getDocumentation().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("goal")) {
          this.getGoal().add(TypeConvertor.castToReference(value));
        } else if (name.equals("condition")) {
          this.getCondition().add((RequestOrchestrationActionConditionComponent) value);
        } else if (name.equals("input")) {
          this.getInput().add((RequestOrchestrationActionInputComponent) value);
        } else if (name.equals("output")) {
          this.getOutput().add((RequestOrchestrationActionOutputComponent) value);
        } else if (name.equals("relatedAction")) {
          this.getRelatedAction().add((RequestOrchestrationActionRelatedActionComponent) value);
        } else if (name.equals("timing[x]")) {
          this.timing = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("location")) {
          this.location = TypeConvertor.castToCodeableReference(value); // CodeableReference
        } else if (name.equals("participant")) {
          this.getParticipant().add((RequestOrchestrationActionParticipantComponent) value);
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
        } else if (name.equals("resource")) {
          this.resource = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("definition[x]")) {
          this.definition = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("transform")) {
          this.transform = TypeConvertor.castToCanonical(value); // CanonicalType
        } else if (name.equals("dynamicValue")) {
          this.getDynamicValue().add((RequestOrchestrationActionDynamicValueComponent) value);
        } else if (name.equals("action")) {
          this.getAction().add((RequestOrchestrationActionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
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
        case 3059181:  return addCode(); 
        case 1587405498:  return addDocumentation(); 
        case 3178259:  return addGoal(); 
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
        case -341064690:  return getResource();
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
        case 1587405498: /*documentation*/ return new String[] {"RelatedArtifact"};
        case 3178259: /*goal*/ return new String[] {"Reference"};
        case -861311717: /*condition*/ return new String[] {};
        case 100358090: /*input*/ return new String[] {};
        case -1005512447: /*output*/ return new String[] {};
        case -384107967: /*relatedAction*/ return new String[] {};
        case -873664438: /*timing*/ return new String[] {"dateTime", "Age", "Period", "Duration", "Range", "Timing"};
        case 1901043637: /*location*/ return new String[] {"CodeableReference"};
        case 767422259: /*participant*/ return new String[] {};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 586678389: /*groupingBehavior*/ return new String[] {"code"};
        case 168639486: /*selectionBehavior*/ return new String[] {"code"};
        case -1163906287: /*requiredBehavior*/ return new String[] {"code"};
        case -1174249033: /*precheckBehavior*/ return new String[] {"code"};
        case -922577408: /*cardinalityBehavior*/ return new String[] {"code"};
        case -341064690: /*resource*/ return new String[] {"Reference"};
        case -1014418093: /*definition*/ return new String[] {"canonical", "uri"};
        case 1052666732: /*transform*/ return new String[] {"canonical"};
        case 572625010: /*dynamicValue*/ return new String[] {};
        case -1422950858: /*action*/ return new String[] {"@RequestOrchestration.action"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("linkId")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.linkId");
        }
        else if (name.equals("prefix")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.prefix");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.description");
        }
        else if (name.equals("textEquivalent")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.textEquivalent");
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.priority");
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("documentation")) {
          return addDocumentation();
        }
        else if (name.equals("goal")) {
          return addGoal();
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
        else if (name.equals("timingDateTime")) {
          this.timing = new DateTimeType();
          return this.timing;
        }
        else if (name.equals("timingAge")) {
          this.timing = new Age();
          return this.timing;
        }
        else if (name.equals("timingPeriod")) {
          this.timing = new Period();
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.groupingBehavior");
        }
        else if (name.equals("selectionBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.selectionBehavior");
        }
        else if (name.equals("requiredBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.requiredBehavior");
        }
        else if (name.equals("precheckBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.precheckBehavior");
        }
        else if (name.equals("cardinalityBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.cardinalityBehavior");
        }
        else if (name.equals("resource")) {
          this.resource = new Reference();
          return this.resource;
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.transform");
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

      public RequestOrchestrationActionComponent copy() {
        RequestOrchestrationActionComponent dst = new RequestOrchestrationActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestOrchestrationActionComponent dst) {
        super.copyValues(dst);
        dst.linkId = linkId == null ? null : linkId.copy();
        dst.prefix = prefix == null ? null : prefix.copy();
        dst.title = title == null ? null : title.copy();
        dst.description = description == null ? null : description.copy();
        dst.textEquivalent = textEquivalent == null ? null : textEquivalent.copy();
        dst.priority = priority == null ? null : priority.copy();
        if (code != null) {
          dst.code = new ArrayList<CodeableConcept>();
          for (CodeableConcept i : code)
            dst.code.add(i.copy());
        };
        if (documentation != null) {
          dst.documentation = new ArrayList<RelatedArtifact>();
          for (RelatedArtifact i : documentation)
            dst.documentation.add(i.copy());
        };
        if (goal != null) {
          dst.goal = new ArrayList<Reference>();
          for (Reference i : goal)
            dst.goal.add(i.copy());
        };
        if (condition != null) {
          dst.condition = new ArrayList<RequestOrchestrationActionConditionComponent>();
          for (RequestOrchestrationActionConditionComponent i : condition)
            dst.condition.add(i.copy());
        };
        if (input != null) {
          dst.input = new ArrayList<RequestOrchestrationActionInputComponent>();
          for (RequestOrchestrationActionInputComponent i : input)
            dst.input.add(i.copy());
        };
        if (output != null) {
          dst.output = new ArrayList<RequestOrchestrationActionOutputComponent>();
          for (RequestOrchestrationActionOutputComponent i : output)
            dst.output.add(i.copy());
        };
        if (relatedAction != null) {
          dst.relatedAction = new ArrayList<RequestOrchestrationActionRelatedActionComponent>();
          for (RequestOrchestrationActionRelatedActionComponent i : relatedAction)
            dst.relatedAction.add(i.copy());
        };
        dst.timing = timing == null ? null : timing.copy();
        dst.location = location == null ? null : location.copy();
        if (participant != null) {
          dst.participant = new ArrayList<RequestOrchestrationActionParticipantComponent>();
          for (RequestOrchestrationActionParticipantComponent i : participant)
            dst.participant.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.groupingBehavior = groupingBehavior == null ? null : groupingBehavior.copy();
        dst.selectionBehavior = selectionBehavior == null ? null : selectionBehavior.copy();
        dst.requiredBehavior = requiredBehavior == null ? null : requiredBehavior.copy();
        dst.precheckBehavior = precheckBehavior == null ? null : precheckBehavior.copy();
        dst.cardinalityBehavior = cardinalityBehavior == null ? null : cardinalityBehavior.copy();
        dst.resource = resource == null ? null : resource.copy();
        dst.definition = definition == null ? null : definition.copy();
        dst.transform = transform == null ? null : transform.copy();
        if (dynamicValue != null) {
          dst.dynamicValue = new ArrayList<RequestOrchestrationActionDynamicValueComponent>();
          for (RequestOrchestrationActionDynamicValueComponent i : dynamicValue)
            dst.dynamicValue.add(i.copy());
        };
        if (action != null) {
          dst.action = new ArrayList<RequestOrchestrationActionComponent>();
          for (RequestOrchestrationActionComponent i : action)
            dst.action.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionComponent))
          return false;
        RequestOrchestrationActionComponent o = (RequestOrchestrationActionComponent) other_;
        return compareDeep(linkId, o.linkId, true) && compareDeep(prefix, o.prefix, true) && compareDeep(title, o.title, true)
           && compareDeep(description, o.description, true) && compareDeep(textEquivalent, o.textEquivalent, true)
           && compareDeep(priority, o.priority, true) && compareDeep(code, o.code, true) && compareDeep(documentation, o.documentation, true)
           && compareDeep(goal, o.goal, true) && compareDeep(condition, o.condition, true) && compareDeep(input, o.input, true)
           && compareDeep(output, o.output, true) && compareDeep(relatedAction, o.relatedAction, true) && compareDeep(timing, o.timing, true)
           && compareDeep(location, o.location, true) && compareDeep(participant, o.participant, true) && compareDeep(type, o.type, true)
           && compareDeep(groupingBehavior, o.groupingBehavior, true) && compareDeep(selectionBehavior, o.selectionBehavior, true)
           && compareDeep(requiredBehavior, o.requiredBehavior, true) && compareDeep(precheckBehavior, o.precheckBehavior, true)
           && compareDeep(cardinalityBehavior, o.cardinalityBehavior, true) && compareDeep(resource, o.resource, true)
           && compareDeep(definition, o.definition, true) && compareDeep(transform, o.transform, true) && compareDeep(dynamicValue, o.dynamicValue, true)
           && compareDeep(action, o.action, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionComponent))
          return false;
        RequestOrchestrationActionComponent o = (RequestOrchestrationActionComponent) other_;
        return compareValues(linkId, o.linkId, true) && compareValues(prefix, o.prefix, true) && compareValues(title, o.title, true)
           && compareValues(description, o.description, true) && compareValues(textEquivalent, o.textEquivalent, true)
           && compareValues(priority, o.priority, true) && compareValues(groupingBehavior, o.groupingBehavior, true)
           && compareValues(selectionBehavior, o.selectionBehavior, true) && compareValues(requiredBehavior, o.requiredBehavior, true)
           && compareValues(precheckBehavior, o.precheckBehavior, true) && compareValues(cardinalityBehavior, o.cardinalityBehavior, true)
           && compareValues(transform, o.transform, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(linkId, prefix, title, description
          , textEquivalent, priority, code, documentation, goal, condition, input, output
          , relatedAction, timing, location, participant, type, groupingBehavior, selectionBehavior
          , requiredBehavior, precheckBehavior, cardinalityBehavior, resource, definition, transform
          , dynamicValue, action);
      }

  public String fhirType() {
    return "RequestOrchestration.action";

  }

  }

    @Block()
    public static class RequestOrchestrationActionConditionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The kind of condition.
         */
        @Child(name = "kind", type = {CodeType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="applicability | start | stop", formalDefinition="The kind of condition." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-condition-kind")
        protected Enumeration<ActionConditionKind> kind;

        /**
         * An expression that returns true or false, indicating whether or not the condition is satisfied.
         */
        @Child(name = "expression", type = {Expression.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Boolean-valued expression", formalDefinition="An expression that returns true or false, indicating whether or not the condition is satisfied." )
        protected Expression expression;

        private static final long serialVersionUID = -455150438L;

    /**
     * Constructor
     */
      public RequestOrchestrationActionConditionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public RequestOrchestrationActionConditionComponent(ActionConditionKind kind) {
        super();
        this.setKind(kind);
      }

        /**
         * @return {@link #kind} (The kind of condition.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
         */
        public Enumeration<ActionConditionKind> getKindElement() { 
          if (this.kind == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionConditionComponent.kind");
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
        public RequestOrchestrationActionConditionComponent setKindElement(Enumeration<ActionConditionKind> value) { 
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
        public RequestOrchestrationActionConditionComponent setKind(ActionConditionKind value) { 
            if (this.kind == null)
              this.kind = new Enumeration<ActionConditionKind>(new ActionConditionKindEnumFactory());
            this.kind.setValue(value);
          return this;
        }

        /**
         * @return {@link #expression} (An expression that returns true or false, indicating whether or not the condition is satisfied.)
         */
        public Expression getExpression() { 
          if (this.expression == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionConditionComponent.expression");
            else if (Configuration.doAutoCreate())
              this.expression = new Expression(); // cc
          return this.expression;
        }

        public boolean hasExpression() { 
          return this.expression != null && !this.expression.isEmpty();
        }

        /**
         * @param value {@link #expression} (An expression that returns true or false, indicating whether or not the condition is satisfied.)
         */
        public RequestOrchestrationActionConditionComponent setExpression(Expression value) { 
          this.expression = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("kind", "code", "The kind of condition.", 0, 1, kind));
          children.add(new Property("expression", "Expression", "An expression that returns true or false, indicating whether or not the condition is satisfied.", 0, 1, expression));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3292052: /*kind*/  return new Property("kind", "code", "The kind of condition.", 0, 1, kind);
          case -1795452264: /*expression*/  return new Property("expression", "Expression", "An expression that returns true or false, indicating whether or not the condition is satisfied.", 0, 1, expression);
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.condition.kind");
        }
        else if (name.equals("expression")) {
          this.expression = new Expression();
          return this.expression;
        }
        else
          return super.addChild(name);
      }

      public RequestOrchestrationActionConditionComponent copy() {
        RequestOrchestrationActionConditionComponent dst = new RequestOrchestrationActionConditionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestOrchestrationActionConditionComponent dst) {
        super.copyValues(dst);
        dst.kind = kind == null ? null : kind.copy();
        dst.expression = expression == null ? null : expression.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionConditionComponent))
          return false;
        RequestOrchestrationActionConditionComponent o = (RequestOrchestrationActionConditionComponent) other_;
        return compareDeep(kind, o.kind, true) && compareDeep(expression, o.expression, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionConditionComponent))
          return false;
        RequestOrchestrationActionConditionComponent o = (RequestOrchestrationActionConditionComponent) other_;
        return compareValues(kind, o.kind, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(kind, expression);
      }

  public String fhirType() {
    return "RequestOrchestration.action.condition";

  }

  }

    @Block()
    public static class RequestOrchestrationActionInputComponent extends BackboneElement implements IBaseBackboneElement {
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
      public RequestOrchestrationActionInputComponent() {
        super();
      }

        /**
         * @return {@link #title} (A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionInputComponent.title");
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
        public RequestOrchestrationActionInputComponent setTitleElement(StringType value) { 
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
        public RequestOrchestrationActionInputComponent setTitle(String value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionInputComponent.requirement");
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
        public RequestOrchestrationActionInputComponent setRequirement(DataRequirement value) { 
          this.requirement = value;
          return this;
        }

        /**
         * @return {@link #relatedData} (Points to an existing input or output element that provides data to this input.). This is the underlying object with id, value and extensions. The accessor "getRelatedData" gives direct access to the value
         */
        public IdType getRelatedDataElement() { 
          if (this.relatedData == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionInputComponent.relatedData");
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
        public RequestOrchestrationActionInputComponent setRelatedDataElement(IdType value) { 
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
        public RequestOrchestrationActionInputComponent setRelatedData(String value) { 
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.input.title");
        }
        else if (name.equals("requirement")) {
          this.requirement = new DataRequirement();
          return this.requirement;
        }
        else if (name.equals("relatedData")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.input.relatedData");
        }
        else
          return super.addChild(name);
      }

      public RequestOrchestrationActionInputComponent copy() {
        RequestOrchestrationActionInputComponent dst = new RequestOrchestrationActionInputComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestOrchestrationActionInputComponent dst) {
        super.copyValues(dst);
        dst.title = title == null ? null : title.copy();
        dst.requirement = requirement == null ? null : requirement.copy();
        dst.relatedData = relatedData == null ? null : relatedData.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionInputComponent))
          return false;
        RequestOrchestrationActionInputComponent o = (RequestOrchestrationActionInputComponent) other_;
        return compareDeep(title, o.title, true) && compareDeep(requirement, o.requirement, true) && compareDeep(relatedData, o.relatedData, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionInputComponent))
          return false;
        RequestOrchestrationActionInputComponent o = (RequestOrchestrationActionInputComponent) other_;
        return compareValues(title, o.title, true) && compareValues(relatedData, o.relatedData, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(title, requirement, relatedData
          );
      }

  public String fhirType() {
    return "RequestOrchestration.action.input";

  }

  }

    @Block()
    public static class RequestOrchestrationActionOutputComponent extends BackboneElement implements IBaseBackboneElement {
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
      public RequestOrchestrationActionOutputComponent() {
        super();
      }

        /**
         * @return {@link #title} (A human-readable label for the data requirement used to label data flows in BPMN or similar diagrams. Also provides a human readable label when rendering the data requirement that conveys its purpose to human readers.). This is the underlying object with id, value and extensions. The accessor "getTitle" gives direct access to the value
         */
        public StringType getTitleElement() { 
          if (this.title == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionOutputComponent.title");
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
        public RequestOrchestrationActionOutputComponent setTitleElement(StringType value) { 
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
        public RequestOrchestrationActionOutputComponent setTitle(String value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionOutputComponent.requirement");
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
        public RequestOrchestrationActionOutputComponent setRequirement(DataRequirement value) { 
          this.requirement = value;
          return this;
        }

        /**
         * @return {@link #relatedData} (Points to an existing input or output element that is results as output from the action.). This is the underlying object with id, value and extensions. The accessor "getRelatedData" gives direct access to the value
         */
        public StringType getRelatedDataElement() { 
          if (this.relatedData == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionOutputComponent.relatedData");
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
        public RequestOrchestrationActionOutputComponent setRelatedDataElement(StringType value) { 
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
        public RequestOrchestrationActionOutputComponent setRelatedData(String value) { 
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.output.title");
        }
        else if (name.equals("requirement")) {
          this.requirement = new DataRequirement();
          return this.requirement;
        }
        else if (name.equals("relatedData")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.output.relatedData");
        }
        else
          return super.addChild(name);
      }

      public RequestOrchestrationActionOutputComponent copy() {
        RequestOrchestrationActionOutputComponent dst = new RequestOrchestrationActionOutputComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestOrchestrationActionOutputComponent dst) {
        super.copyValues(dst);
        dst.title = title == null ? null : title.copy();
        dst.requirement = requirement == null ? null : requirement.copy();
        dst.relatedData = relatedData == null ? null : relatedData.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionOutputComponent))
          return false;
        RequestOrchestrationActionOutputComponent o = (RequestOrchestrationActionOutputComponent) other_;
        return compareDeep(title, o.title, true) && compareDeep(requirement, o.requirement, true) && compareDeep(relatedData, o.relatedData, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionOutputComponent))
          return false;
        RequestOrchestrationActionOutputComponent o = (RequestOrchestrationActionOutputComponent) other_;
        return compareValues(title, o.title, true) && compareValues(relatedData, o.relatedData, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(title, requirement, relatedData
          );
      }

  public String fhirType() {
    return "RequestOrchestration.action.output";

  }

  }

    @Block()
    public static class RequestOrchestrationActionRelatedActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The element id of the target related action.
         */
        @Child(name = "targetId", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What action this is related to", formalDefinition="The element id of the target related action." )
        protected IdType targetId;

        /**
         * The relationship of this action to the related action.
         */
        @Child(name = "relationship", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="before | before-start | before-end | concurrent | concurrent-with-start | concurrent-with-end | after | after-start | after-end", formalDefinition="The relationship of this action to the related action." )
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
      public RequestOrchestrationActionRelatedActionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public RequestOrchestrationActionRelatedActionComponent(String targetId, ActionRelationshipType relationship) {
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionRelatedActionComponent.targetId");
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
        public RequestOrchestrationActionRelatedActionComponent setTargetIdElement(IdType value) { 
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
        public RequestOrchestrationActionRelatedActionComponent setTargetId(String value) { 
            if (this.targetId == null)
              this.targetId = new IdType();
            this.targetId.setValue(value);
          return this;
        }

        /**
         * @return {@link #relationship} (The relationship of this action to the related action.). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public Enumeration<ActionRelationshipType> getRelationshipElement() { 
          if (this.relationship == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionRelatedActionComponent.relationship");
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
         * @param value {@link #relationship} (The relationship of this action to the related action.). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public RequestOrchestrationActionRelatedActionComponent setRelationshipElement(Enumeration<ActionRelationshipType> value) { 
          this.relationship = value;
          return this;
        }

        /**
         * @return The relationship of this action to the related action.
         */
        public ActionRelationshipType getRelationship() { 
          return this.relationship == null ? null : this.relationship.getValue();
        }

        /**
         * @param value The relationship of this action to the related action.
         */
        public RequestOrchestrationActionRelatedActionComponent setRelationship(ActionRelationshipType value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionRelatedActionComponent.endRelationship");
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
        public RequestOrchestrationActionRelatedActionComponent setEndRelationshipElement(Enumeration<ActionRelationshipType> value) { 
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
        public RequestOrchestrationActionRelatedActionComponent setEndRelationship(ActionRelationshipType value) { 
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
        public RequestOrchestrationActionRelatedActionComponent setOffset(DataType value) { 
          if (value != null && !(value instanceof Duration || value instanceof Range))
            throw new FHIRException("Not the right type for RequestOrchestration.action.relatedAction.offset[x]: "+value.fhirType());
          this.offset = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("targetId", "id", "The element id of the target related action.", 0, 1, targetId));
          children.add(new Property("relationship", "code", "The relationship of this action to the related action.", 0, 1, relationship));
          children.add(new Property("endRelationship", "code", "The relationship of the end of this action to the related action.", 0, 1, endRelationship));
          children.add(new Property("offset[x]", "Duration|Range", "A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.", 0, 1, offset));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -441951604: /*targetId*/  return new Property("targetId", "id", "The element id of the target related action.", 0, 1, targetId);
          case -261851592: /*relationship*/  return new Property("relationship", "code", "The relationship of this action to the related action.", 0, 1, relationship);
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.relatedAction.targetId");
        }
        else if (name.equals("relationship")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.relatedAction.relationship");
        }
        else if (name.equals("endRelationship")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.relatedAction.endRelationship");
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

      public RequestOrchestrationActionRelatedActionComponent copy() {
        RequestOrchestrationActionRelatedActionComponent dst = new RequestOrchestrationActionRelatedActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestOrchestrationActionRelatedActionComponent dst) {
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
        if (!(other_ instanceof RequestOrchestrationActionRelatedActionComponent))
          return false;
        RequestOrchestrationActionRelatedActionComponent o = (RequestOrchestrationActionRelatedActionComponent) other_;
        return compareDeep(targetId, o.targetId, true) && compareDeep(relationship, o.relationship, true)
           && compareDeep(endRelationship, o.endRelationship, true) && compareDeep(offset, o.offset, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionRelatedActionComponent))
          return false;
        RequestOrchestrationActionRelatedActionComponent o = (RequestOrchestrationActionRelatedActionComponent) other_;
        return compareValues(targetId, o.targetId, true) && compareValues(relationship, o.relationship, true)
           && compareValues(endRelationship, o.endRelationship, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(targetId, relationship, endRelationship
          , offset);
      }

  public String fhirType() {
    return "RequestOrchestration.action.relatedAction";

  }

  }

    @Block()
    public static class RequestOrchestrationActionParticipantComponent extends BackboneElement implements IBaseBackboneElement {
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
        @Description(shortDefinition="E.g. Nurse, Surgeon, Parent, etc", formalDefinition="The role the participant should play in performing the described action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://terminology.hl7.org/ValueSet/action-participant-role")
        protected CodeableConcept role;

        /**
         * Indicates how the actor will be involved in the action - author, reviewer, witness, etc.
         */
        @Child(name = "function", type = {CodeableConcept.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="E.g. Author, Reviewer, Witness, etc", formalDefinition="Indicates how the actor will be involved in the action - author, reviewer, witness, etc." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-participant-function")
        protected CodeableConcept function;

        /**
         * A reference to the actual participant.
         */
        @Child(name = "actor", type = {CanonicalType.class, CareTeam.class, Device.class, DeviceDefinition.class, Endpoint.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class}, order=6, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Who/what is participating?", formalDefinition="A reference to the actual participant." )
        protected DataType actor;

        private static final long serialVersionUID = -147206285L;

    /**
     * Constructor
     */
      public RequestOrchestrationActionParticipantComponent() {
        super();
      }

        /**
         * @return {@link #type} (The type of participant in the action.). This is the underlying object with id, value and extensions. The accessor "getType" gives direct access to the value
         */
        public Enumeration<ActionParticipantType> getTypeElement() { 
          if (this.type == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionParticipantComponent.type");
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
        public RequestOrchestrationActionParticipantComponent setTypeElement(Enumeration<ActionParticipantType> value) { 
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
        public RequestOrchestrationActionParticipantComponent setType(ActionParticipantType value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionParticipantComponent.typeCanonical");
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
        public RequestOrchestrationActionParticipantComponent setTypeCanonicalElement(CanonicalType value) { 
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
        public RequestOrchestrationActionParticipantComponent setTypeCanonical(String value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionParticipantComponent.typeReference");
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
        public RequestOrchestrationActionParticipantComponent setTypeReference(Reference value) { 
          this.typeReference = value;
          return this;
        }

        /**
         * @return {@link #role} (The role the participant should play in performing the described action.)
         */
        public CodeableConcept getRole() { 
          if (this.role == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionParticipantComponent.role");
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
        public RequestOrchestrationActionParticipantComponent setRole(CodeableConcept value) { 
          this.role = value;
          return this;
        }

        /**
         * @return {@link #function} (Indicates how the actor will be involved in the action - author, reviewer, witness, etc.)
         */
        public CodeableConcept getFunction() { 
          if (this.function == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionParticipantComponent.function");
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
        public RequestOrchestrationActionParticipantComponent setFunction(CodeableConcept value) { 
          this.function = value;
          return this;
        }

        /**
         * @return {@link #actor} (A reference to the actual participant.)
         */
        public DataType getActor() { 
          return this.actor;
        }

        /**
         * @return {@link #actor} (A reference to the actual participant.)
         */
        public CanonicalType getActorCanonicalType() throws FHIRException { 
          if (this.actor == null)
            this.actor = new CanonicalType();
          if (!(this.actor instanceof CanonicalType))
            throw new FHIRException("Type mismatch: the type CanonicalType was expected, but "+this.actor.getClass().getName()+" was encountered");
          return (CanonicalType) this.actor;
        }

        public boolean hasActorCanonicalType() { 
          return this != null && this.actor instanceof CanonicalType;
        }

        /**
         * @return {@link #actor} (A reference to the actual participant.)
         */
        public Reference getActorReference() throws FHIRException { 
          if (this.actor == null)
            this.actor = new Reference();
          if (!(this.actor instanceof Reference))
            throw new FHIRException("Type mismatch: the type Reference was expected, but "+this.actor.getClass().getName()+" was encountered");
          return (Reference) this.actor;
        }

        public boolean hasActorReference() { 
          return this != null && this.actor instanceof Reference;
        }

        public boolean hasActor() { 
          return this.actor != null && !this.actor.isEmpty();
        }

        /**
         * @param value {@link #actor} (A reference to the actual participant.)
         */
        public RequestOrchestrationActionParticipantComponent setActor(DataType value) { 
          if (value != null && !(value instanceof CanonicalType || value instanceof Reference))
            throw new FHIRException("Not the right type for RequestOrchestration.action.participant.actor[x]: "+value.fhirType());
          this.actor = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("type", "code", "The type of participant in the action.", 0, 1, type));
          children.add(new Property("typeCanonical", "canonical(CapabilityStatement)", "The type of participant in the action.", 0, 1, typeCanonical));
          children.add(new Property("typeReference", "Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The type of participant in the action.", 0, 1, typeReference));
          children.add(new Property("role", "CodeableConcept", "The role the participant should play in performing the described action.", 0, 1, role));
          children.add(new Property("function", "CodeableConcept", "Indicates how the actor will be involved in the action - author, reviewer, witness, etc.", 0, 1, function));
          children.add(new Property("actor[x]", "canonical(CapabilityStatement)|Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "A reference to the actual participant.", 0, 1, actor));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case 3575610: /*type*/  return new Property("type", "code", "The type of participant in the action.", 0, 1, type);
          case -466635046: /*typeCanonical*/  return new Property("typeCanonical", "canonical(CapabilityStatement)", "The type of participant in the action.", 0, 1, typeCanonical);
          case 2074825009: /*typeReference*/  return new Property("typeReference", "Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The type of participant in the action.", 0, 1, typeReference);
          case 3506294: /*role*/  return new Property("role", "CodeableConcept", "The role the participant should play in performing the described action.", 0, 1, role);
          case 1380938712: /*function*/  return new Property("function", "CodeableConcept", "Indicates how the actor will be involved in the action - author, reviewer, witness, etc.", 0, 1, function);
          case -1650558357: /*actor[x]*/  return new Property("actor[x]", "canonical(CapabilityStatement)|Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "A reference to the actual participant.", 0, 1, actor);
          case 92645877: /*actor*/  return new Property("actor[x]", "canonical(CapabilityStatement)|Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "A reference to the actual participant.", 0, 1, actor);
          case 1323531903: /*actorCanonical*/  return new Property("actor[x]", "canonical(CapabilityStatement)", "A reference to the actual participant.", 0, 1, actor);
          case -429975338: /*actorReference*/  return new Property("actor[x]", "Reference(CareTeam|Device|DeviceDefinition|Endpoint|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "A reference to the actual participant.", 0, 1, actor);
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
        case 1380938712: /*function*/ return this.function == null ? new Base[0] : new Base[] {this.function}; // CodeableConcept
        case 92645877: /*actor*/ return this.actor == null ? new Base[0] : new Base[] {this.actor}; // DataType
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
        case 1380938712: // function
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case 92645877: // actor
          this.actor = TypeConvertor.castToType(value); // DataType
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
        } else if (name.equals("function")) {
          this.function = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("actor[x]")) {
          this.actor = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case 3575610:  return getTypeElement();
        case -466635046:  return getTypeCanonicalElement();
        case 2074825009:  return getTypeReference();
        case 3506294:  return getRole();
        case 1380938712:  return getFunction();
        case -1650558357:  return getActor();
        case 92645877:  return getActor();
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
        case 1380938712: /*function*/ return new String[] {"CodeableConcept"};
        case 92645877: /*actor*/ return new String[] {"canonical", "Reference"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("type")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.participant.type");
        }
        else if (name.equals("typeCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.participant.typeCanonical");
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
        else if (name.equals("actorCanonical")) {
          this.actor = new CanonicalType();
          return this.actor;
        }
        else if (name.equals("actorReference")) {
          this.actor = new Reference();
          return this.actor;
        }
        else
          return super.addChild(name);
      }

      public RequestOrchestrationActionParticipantComponent copy() {
        RequestOrchestrationActionParticipantComponent dst = new RequestOrchestrationActionParticipantComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestOrchestrationActionParticipantComponent dst) {
        super.copyValues(dst);
        dst.type = type == null ? null : type.copy();
        dst.typeCanonical = typeCanonical == null ? null : typeCanonical.copy();
        dst.typeReference = typeReference == null ? null : typeReference.copy();
        dst.role = role == null ? null : role.copy();
        dst.function = function == null ? null : function.copy();
        dst.actor = actor == null ? null : actor.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionParticipantComponent))
          return false;
        RequestOrchestrationActionParticipantComponent o = (RequestOrchestrationActionParticipantComponent) other_;
        return compareDeep(type, o.type, true) && compareDeep(typeCanonical, o.typeCanonical, true) && compareDeep(typeReference, o.typeReference, true)
           && compareDeep(role, o.role, true) && compareDeep(function, o.function, true) && compareDeep(actor, o.actor, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionParticipantComponent))
          return false;
        RequestOrchestrationActionParticipantComponent o = (RequestOrchestrationActionParticipantComponent) other_;
        return compareValues(type, o.type, true) && compareValues(typeCanonical, o.typeCanonical, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(type, typeCanonical, typeReference
          , role, function, actor);
      }

  public String fhirType() {
    return "RequestOrchestration.action.participant";

  }

  }

    @Block()
    public static class RequestOrchestrationActionDynamicValueComponent extends BackboneElement implements IBaseBackboneElement {
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
      public RequestOrchestrationActionDynamicValueComponent() {
        super();
      }

        /**
         * @return {@link #path} (The path to the element to be customized. This is the path on the resource that will hold the result of the calculation defined by the expression. The specified path SHALL be a FHIRPath resolvable on the specified target type of the ActivityDefinition, and SHALL consist only of identifiers, constant indexers, and a restricted subset of functions. The path is allowed to contain qualifiers (.) to traverse sub-elements, as well as indexers ([x]) to traverse multiple-cardinality sub-elements (see the [Simple FHIRPath Profile](fhirpath.html#simple) for full details).). This is the underlying object with id, value and extensions. The accessor "getPath" gives direct access to the value
         */
        public StringType getPathElement() { 
          if (this.path == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestOrchestrationActionDynamicValueComponent.path");
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
        public RequestOrchestrationActionDynamicValueComponent setPathElement(StringType value) { 
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
        public RequestOrchestrationActionDynamicValueComponent setPath(String value) { 
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
              throw new Error("Attempt to auto-create RequestOrchestrationActionDynamicValueComponent.expression");
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
        public RequestOrchestrationActionDynamicValueComponent setExpression(Expression value) { 
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.action.dynamicValue.path");
        }
        else if (name.equals("expression")) {
          this.expression = new Expression();
          return this.expression;
        }
        else
          return super.addChild(name);
      }

      public RequestOrchestrationActionDynamicValueComponent copy() {
        RequestOrchestrationActionDynamicValueComponent dst = new RequestOrchestrationActionDynamicValueComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestOrchestrationActionDynamicValueComponent dst) {
        super.copyValues(dst);
        dst.path = path == null ? null : path.copy();
        dst.expression = expression == null ? null : expression.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionDynamicValueComponent))
          return false;
        RequestOrchestrationActionDynamicValueComponent o = (RequestOrchestrationActionDynamicValueComponent) other_;
        return compareDeep(path, o.path, true) && compareDeep(expression, o.expression, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestOrchestrationActionDynamicValueComponent))
          return false;
        RequestOrchestrationActionDynamicValueComponent o = (RequestOrchestrationActionDynamicValueComponent) other_;
        return compareValues(path, o.path, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(path, expression);
      }

  public String fhirType() {
    return "RequestOrchestration.action.dynamicValue";

  }

  }

    /**
     * Allows a service to provide a unique, business identifier for the request.
     */
    @Child(name = "identifier", type = {Identifier.class}, order=0, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Business identifier", formalDefinition="Allows a service to provide a unique, business identifier for the request." )
    protected List<Identifier> identifier;

    /**
     * A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.
     */
    @Child(name = "instantiatesCanonical", type = {CanonicalType.class}, order=1, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates FHIR protocol or definition", formalDefinition="A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request." )
    protected List<CanonicalType> instantiatesCanonical;

    /**
     * A URL referencing an externally defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.
     */
    @Child(name = "instantiatesUri", type = {UriType.class}, order=2, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=true)
    @Description(shortDefinition="Instantiates external protocol or definition", formalDefinition="A URL referencing an externally defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request." )
    protected List<UriType> instantiatesUri;

    /**
     * A plan, proposal or order that is fulfilled in whole or in part by this request.
     */
    @Child(name = "basedOn", type = {Reference.class}, order=3, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Fulfills plan, proposal, or order", formalDefinition="A plan, proposal or order that is fulfilled in whole or in part by this request." )
    protected List<Reference> basedOn;

    /**
     * Completed or terminated request(s) whose function is taken by this new request.
     */
    @Child(name = "replaces", type = {Reference.class}, order=4, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Request(s) replaced by this request", formalDefinition="Completed or terminated request(s) whose function is taken by this new request." )
    protected List<Reference> replaces;

    /**
     * A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.
     */
    @Child(name = "groupIdentifier", type = {Identifier.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Composite request this is part of", formalDefinition="A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time." )
    protected Identifier groupIdentifier;

    /**
     * The current state of the request. For request orchestrations, the status reflects the status of all the requests in the orchestration.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | on-hold | revoked | completed | entered-in-error | unknown", formalDefinition="The current state of the request. For request orchestrations, the status reflects the status of all the requests in the orchestration." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-status")
    protected Enumeration<RequestStatus> status;

    /**
     * Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain.
     */
    @Child(name = "intent", type = {CodeType.class}, order=7, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="proposal | plan | directive | order | original-order | reflex-order | filler-order | instance-order | option", formalDefinition="Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-intent")
    protected Enumeration<RequestIntent> intent;

    /**
     * Indicates how quickly the request should be addressed with respect to other requests.
     */
    @Child(name = "priority", type = {CodeType.class}, order=8, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="routine | urgent | asap | stat", formalDefinition="Indicates how quickly the request should be addressed with respect to other requests." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-priority")
    protected Enumeration<RequestPriority> priority;

    /**
     * A code that identifies what the overall request orchestration is.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What's being requested/ordered", formalDefinition="A code that identifies what the overall request orchestration is." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-code")
    protected CodeableConcept code;

    /**
     * The subject for which the request orchestration was created.
     */
    @Child(name = "subject", type = {CareTeam.class, Device.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Who the request orchestration is about", formalDefinition="The subject for which the request orchestration was created." )
    protected Reference subject;

    /**
     * Describes the context of the request orchestration, if any.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Created as part of", formalDefinition="Describes the context of the request orchestration, if any." )
    protected Reference encounter;

    /**
     * Indicates when the request orchestration was created.
     */
    @Child(name = "authoredOn", type = {DateTimeType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the request orchestration was authored", formalDefinition="Indicates when the request orchestration was created." )
    protected DateTimeType authoredOn;

    /**
     * Provides a reference to the author of the request orchestration.
     */
    @Child(name = "author", type = {Device.class, Practitioner.class, PractitionerRole.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Device or practitioner that authored the request orchestration", formalDefinition="Provides a reference to the author of the request orchestration." )
    protected Reference author;

    /**
     * Describes the reason for the request orchestration in coded or textual form.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Why the request orchestration is needed", formalDefinition="Describes the reason for the request orchestration in coded or textual form." )
    @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-reason-code")
    protected List<CodeableReference> reason;

    /**
     * Goals that are intended to be achieved by following the requests in this RequestOrchestration.
     */
    @Child(name = "goal", type = {Goal.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="What goals", formalDefinition="Goals that are intended to be achieved by following the requests in this RequestOrchestration." )
    protected List<Reference> goal;

    /**
     * Provides a mechanism to communicate additional information about the response.
     */
    @Child(name = "note", type = {Annotation.class}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional notes about the response", formalDefinition="Provides a mechanism to communicate additional information about the response." )
    protected List<Annotation> note;

    /**
     * The actions, if any, produced by the evaluation of the artifact.
     */
    @Child(name = "action", type = {}, order=17, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Proposed actions, if any", formalDefinition="The actions, if any, produced by the evaluation of the artifact." )
    protected List<RequestOrchestrationActionComponent> action;

    private static final long serialVersionUID = -683989911L;

  /**
   * Constructor
   */
    public RequestOrchestration() {
      super();
    }

  /**
   * Constructor
   */
    public RequestOrchestration(RequestStatus status, RequestIntent intent) {
      super();
      this.setStatus(status);
      this.setIntent(intent);
    }

    /**
     * @return {@link #identifier} (Allows a service to provide a unique, business identifier for the request.)
     */
    public List<Identifier> getIdentifier() { 
      if (this.identifier == null)
        this.identifier = new ArrayList<Identifier>();
      return this.identifier;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestOrchestration setIdentifier(List<Identifier> theIdentifier) { 
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

    public RequestOrchestration addIdentifier(Identifier t) { //3
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
     * @return {@link #instantiatesCanonical} (A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.)
     */
    public List<CanonicalType> getInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      return this.instantiatesCanonical;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestOrchestration setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) { 
      this.instantiatesCanonical = theInstantiatesCanonical;
      return this;
    }

    public boolean hasInstantiatesCanonical() { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType item : this.instantiatesCanonical)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesCanonical} (A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.)
     */
    public CanonicalType addInstantiatesCanonicalElement() {//2 
      CanonicalType t = new CanonicalType();
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesCanonical} (A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.)
     */
    public RequestOrchestration addInstantiatesCanonical(String value) { //1
      CanonicalType t = new CanonicalType();
      t.setValue(value);
      if (this.instantiatesCanonical == null)
        this.instantiatesCanonical = new ArrayList<CanonicalType>();
      this.instantiatesCanonical.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesCanonical} (A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.)
     */
    public boolean hasInstantiatesCanonical(String value) { 
      if (this.instantiatesCanonical == null)
        return false;
      for (CanonicalType v : this.instantiatesCanonical)
        if (v.getValue().equals(value)) // canonical
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (A URL referencing an externally defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.)
     */
    public List<UriType> getInstantiatesUri() { 
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      return this.instantiatesUri;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestOrchestration setInstantiatesUri(List<UriType> theInstantiatesUri) { 
      this.instantiatesUri = theInstantiatesUri;
      return this;
    }

    public boolean hasInstantiatesUri() { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType item : this.instantiatesUri)
        if (!item.isEmpty())
          return true;
      return false;
    }

    /**
     * @return {@link #instantiatesUri} (A URL referencing an externally defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.)
     */
    public UriType addInstantiatesUriElement() {//2 
      UriType t = new UriType();
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return t;
    }

    /**
     * @param value {@link #instantiatesUri} (A URL referencing an externally defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.)
     */
    public RequestOrchestration addInstantiatesUri(String value) { //1
      UriType t = new UriType();
      t.setValue(value);
      if (this.instantiatesUri == null)
        this.instantiatesUri = new ArrayList<UriType>();
      this.instantiatesUri.add(t);
      return this;
    }

    /**
     * @param value {@link #instantiatesUri} (A URL referencing an externally defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.)
     */
    public boolean hasInstantiatesUri(String value) { 
      if (this.instantiatesUri == null)
        return false;
      for (UriType v : this.instantiatesUri)
        if (v.getValue().equals(value)) // uri
          return true;
      return false;
    }

    /**
     * @return {@link #basedOn} (A plan, proposal or order that is fulfilled in whole or in part by this request.)
     */
    public List<Reference> getBasedOn() { 
      if (this.basedOn == null)
        this.basedOn = new ArrayList<Reference>();
      return this.basedOn;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestOrchestration setBasedOn(List<Reference> theBasedOn) { 
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

    public RequestOrchestration addBasedOn(Reference t) { //3
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
     * @return {@link #replaces} (Completed or terminated request(s) whose function is taken by this new request.)
     */
    public List<Reference> getReplaces() { 
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      return this.replaces;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestOrchestration setReplaces(List<Reference> theReplaces) { 
      this.replaces = theReplaces;
      return this;
    }

    public boolean hasReplaces() { 
      if (this.replaces == null)
        return false;
      for (Reference item : this.replaces)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addReplaces() { //3
      Reference t = new Reference();
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      this.replaces.add(t);
      return t;
    }

    public RequestOrchestration addReplaces(Reference t) { //3
      if (t == null)
        return this;
      if (this.replaces == null)
        this.replaces = new ArrayList<Reference>();
      this.replaces.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #replaces}, creating it if it does not already exist {3}
     */
    public Reference getReplacesFirstRep() { 
      if (getReplaces().isEmpty()) {
        addReplaces();
      }
      return getReplaces().get(0);
    }

    /**
     * @return {@link #groupIdentifier} (A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.)
     */
    public Identifier getGroupIdentifier() { 
      if (this.groupIdentifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestOrchestration.groupIdentifier");
        else if (Configuration.doAutoCreate())
          this.groupIdentifier = new Identifier(); // cc
      return this.groupIdentifier;
    }

    public boolean hasGroupIdentifier() { 
      return this.groupIdentifier != null && !this.groupIdentifier.isEmpty();
    }

    /**
     * @param value {@link #groupIdentifier} (A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.)
     */
    public RequestOrchestration setGroupIdentifier(Identifier value) { 
      this.groupIdentifier = value;
      return this;
    }

    /**
     * @return {@link #status} (The current state of the request. For request orchestrations, the status reflects the status of all the requests in the orchestration.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<RequestStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestOrchestration.status");
        else if (Configuration.doAutoCreate())
          this.status = new Enumeration<RequestStatus>(new RequestStatusEnumFactory()); // bb
      return this.status;
    }

    public boolean hasStatusElement() { 
      return this.status != null && !this.status.isEmpty();
    }

    public boolean hasStatus() { 
      return this.status != null && !this.status.isEmpty();
    }

    /**
     * @param value {@link #status} (The current state of the request. For request orchestrations, the status reflects the status of all the requests in the orchestration.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public RequestOrchestration setStatusElement(Enumeration<RequestStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the request. For request orchestrations, the status reflects the status of all the requests in the orchestration.
     */
    public RequestStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the request. For request orchestrations, the status reflects the status of all the requests in the orchestration.
     */
    public RequestOrchestration setStatus(RequestStatus value) { 
        if (this.status == null)
          this.status = new Enumeration<RequestStatus>(new RequestStatusEnumFactory());
        this.status.setValue(value);
      return this;
    }

    /**
     * @return {@link #intent} (Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public Enumeration<RequestIntent> getIntentElement() { 
      if (this.intent == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestOrchestration.intent");
        else if (Configuration.doAutoCreate())
          this.intent = new Enumeration<RequestIntent>(new RequestIntentEnumFactory()); // bb
      return this.intent;
    }

    public boolean hasIntentElement() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    public boolean hasIntent() { 
      return this.intent != null && !this.intent.isEmpty();
    }

    /**
     * @param value {@link #intent} (Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain.). This is the underlying object with id, value and extensions. The accessor "getIntent" gives direct access to the value
     */
    public RequestOrchestration setIntentElement(Enumeration<RequestIntent> value) { 
      this.intent = value;
      return this;
    }

    /**
     * @return Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain.
     */
    public RequestIntent getIntent() { 
      return this.intent == null ? null : this.intent.getValue();
    }

    /**
     * @param value Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain.
     */
    public RequestOrchestration setIntent(RequestIntent value) { 
        if (this.intent == null)
          this.intent = new Enumeration<RequestIntent>(new RequestIntentEnumFactory());
        this.intent.setValue(value);
      return this;
    }

    /**
     * @return {@link #priority} (Indicates how quickly the request should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public Enumeration<RequestPriority> getPriorityElement() { 
      if (this.priority == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestOrchestration.priority");
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
     * @param value {@link #priority} (Indicates how quickly the request should be addressed with respect to other requests.). This is the underlying object with id, value and extensions. The accessor "getPriority" gives direct access to the value
     */
    public RequestOrchestration setPriorityElement(Enumeration<RequestPriority> value) { 
      this.priority = value;
      return this;
    }

    /**
     * @return Indicates how quickly the request should be addressed with respect to other requests.
     */
    public RequestPriority getPriority() { 
      return this.priority == null ? null : this.priority.getValue();
    }

    /**
     * @param value Indicates how quickly the request should be addressed with respect to other requests.
     */
    public RequestOrchestration setPriority(RequestPriority value) { 
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
     * @return {@link #code} (A code that identifies what the overall request orchestration is.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestOrchestration.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code that identifies what the overall request orchestration is.)
     */
    public RequestOrchestration setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (The subject for which the request orchestration was created.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestOrchestration.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The subject for which the request orchestration was created.)
     */
    public RequestOrchestration setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (Describes the context of the request orchestration, if any.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestOrchestration.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (Describes the context of the request orchestration, if any.)
     */
    public RequestOrchestration setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #authoredOn} (Indicates when the request orchestration was created.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DateTimeType getAuthoredOnElement() { 
      if (this.authoredOn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestOrchestration.authoredOn");
        else if (Configuration.doAutoCreate())
          this.authoredOn = new DateTimeType(); // bb
      return this.authoredOn;
    }

    public boolean hasAuthoredOnElement() { 
      return this.authoredOn != null && !this.authoredOn.isEmpty();
    }

    public boolean hasAuthoredOn() { 
      return this.authoredOn != null && !this.authoredOn.isEmpty();
    }

    /**
     * @param value {@link #authoredOn} (Indicates when the request orchestration was created.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public RequestOrchestration setAuthoredOnElement(DateTimeType value) { 
      this.authoredOn = value;
      return this;
    }

    /**
     * @return Indicates when the request orchestration was created.
     */
    public Date getAuthoredOn() { 
      return this.authoredOn == null ? null : this.authoredOn.getValue();
    }

    /**
     * @param value Indicates when the request orchestration was created.
     */
    public RequestOrchestration setAuthoredOn(Date value) { 
      if (value == null)
        this.authoredOn = null;
      else {
        if (this.authoredOn == null)
          this.authoredOn = new DateTimeType();
        this.authoredOn.setValue(value);
      }
      return this;
    }

    /**
     * @return {@link #author} (Provides a reference to the author of the request orchestration.)
     */
    public Reference getAuthor() { 
      if (this.author == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestOrchestration.author");
        else if (Configuration.doAutoCreate())
          this.author = new Reference(); // cc
      return this.author;
    }

    public boolean hasAuthor() { 
      return this.author != null && !this.author.isEmpty();
    }

    /**
     * @param value {@link #author} (Provides a reference to the author of the request orchestration.)
     */
    public RequestOrchestration setAuthor(Reference value) { 
      this.author = value;
      return this;
    }

    /**
     * @return {@link #reason} (Describes the reason for the request orchestration in coded or textual form.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestOrchestration setReason(List<CodeableReference> theReason) { 
      this.reason = theReason;
      return this;
    }

    public boolean hasReason() { 
      if (this.reason == null)
        return false;
      for (CodeableReference item : this.reason)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public CodeableReference addReason() { //3
      CodeableReference t = new CodeableReference();
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return t;
    }

    public RequestOrchestration addReason(CodeableReference t) { //3
      if (t == null)
        return this;
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      this.reason.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #reason}, creating it if it does not already exist {3}
     */
    public CodeableReference getReasonFirstRep() { 
      if (getReason().isEmpty()) {
        addReason();
      }
      return getReason().get(0);
    }

    /**
     * @return {@link #goal} (Goals that are intended to be achieved by following the requests in this RequestOrchestration.)
     */
    public List<Reference> getGoal() { 
      if (this.goal == null)
        this.goal = new ArrayList<Reference>();
      return this.goal;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestOrchestration setGoal(List<Reference> theGoal) { 
      this.goal = theGoal;
      return this;
    }

    public boolean hasGoal() { 
      if (this.goal == null)
        return false;
      for (Reference item : this.goal)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public Reference addGoal() { //3
      Reference t = new Reference();
      if (this.goal == null)
        this.goal = new ArrayList<Reference>();
      this.goal.add(t);
      return t;
    }

    public RequestOrchestration addGoal(Reference t) { //3
      if (t == null)
        return this;
      if (this.goal == null)
        this.goal = new ArrayList<Reference>();
      this.goal.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #goal}, creating it if it does not already exist {3}
     */
    public Reference getGoalFirstRep() { 
      if (getGoal().isEmpty()) {
        addGoal();
      }
      return getGoal().get(0);
    }

    /**
     * @return {@link #note} (Provides a mechanism to communicate additional information about the response.)
     */
    public List<Annotation> getNote() { 
      if (this.note == null)
        this.note = new ArrayList<Annotation>();
      return this.note;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestOrchestration setNote(List<Annotation> theNote) { 
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

    public RequestOrchestration addNote(Annotation t) { //3
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
     * @return {@link #action} (The actions, if any, produced by the evaluation of the artifact.)
     */
    public List<RequestOrchestrationActionComponent> getAction() { 
      if (this.action == null)
        this.action = new ArrayList<RequestOrchestrationActionComponent>();
      return this.action;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestOrchestration setAction(List<RequestOrchestrationActionComponent> theAction) { 
      this.action = theAction;
      return this;
    }

    public boolean hasAction() { 
      if (this.action == null)
        return false;
      for (RequestOrchestrationActionComponent item : this.action)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RequestOrchestrationActionComponent addAction() { //3
      RequestOrchestrationActionComponent t = new RequestOrchestrationActionComponent();
      if (this.action == null)
        this.action = new ArrayList<RequestOrchestrationActionComponent>();
      this.action.add(t);
      return t;
    }

    public RequestOrchestration addAction(RequestOrchestrationActionComponent t) { //3
      if (t == null)
        return this;
      if (this.action == null)
        this.action = new ArrayList<RequestOrchestrationActionComponent>();
      this.action.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
     */
    public RequestOrchestrationActionComponent getActionFirstRep() { 
      if (getAction().isEmpty()) {
        addAction();
      }
      return getAction().get(0);
    }

      protected void listChildren(List<Property> children) {
        super.listChildren(children);
        children.add(new Property("identifier", "Identifier", "Allows a service to provide a unique, business identifier for the request.", 0, java.lang.Integer.MAX_VALUE, identifier));
        children.add(new Property("instantiatesCanonical", "canonical", "A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical));
        children.add(new Property("instantiatesUri", "uri", "A URL referencing an externally defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri));
        children.add(new Property("basedOn", "Reference(Any)", "A plan, proposal or order that is fulfilled in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE, basedOn));
        children.add(new Property("replaces", "Reference(Any)", "Completed or terminated request(s) whose function is taken by this new request.", 0, java.lang.Integer.MAX_VALUE, replaces));
        children.add(new Property("groupIdentifier", "Identifier", "A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.", 0, 1, groupIdentifier));
        children.add(new Property("status", "code", "The current state of the request. For request orchestrations, the status reflects the status of all the requests in the orchestration.", 0, 1, status));
        children.add(new Property("intent", "code", "Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain.", 0, 1, intent));
        children.add(new Property("priority", "code", "Indicates how quickly the request should be addressed with respect to other requests.", 0, 1, priority));
        children.add(new Property("code", "CodeableConcept", "A code that identifies what the overall request orchestration is.", 0, 1, code));
        children.add(new Property("subject", "Reference(CareTeam|Device|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The subject for which the request orchestration was created.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "Describes the context of the request orchestration, if any.", 0, 1, encounter));
        children.add(new Property("authoredOn", "dateTime", "Indicates when the request orchestration was created.", 0, 1, authoredOn));
        children.add(new Property("author", "Reference(Device|Practitioner|PractitionerRole)", "Provides a reference to the author of the request orchestration.", 0, 1, author));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Describes the reason for the request orchestration in coded or textual form.", 0, java.lang.Integer.MAX_VALUE, reason));
        children.add(new Property("goal", "Reference(Goal)", "Goals that are intended to be achieved by following the requests in this RequestOrchestration.", 0, java.lang.Integer.MAX_VALUE, goal));
        children.add(new Property("note", "Annotation", "Provides a mechanism to communicate additional information about the response.", 0, java.lang.Integer.MAX_VALUE, note));
        children.add(new Property("action", "", "The actions, if any, produced by the evaluation of the artifact.", 0, java.lang.Integer.MAX_VALUE, action));
      }

      @Override
      public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
        switch (_hash) {
        case -1618432855: /*identifier*/  return new Property("identifier", "Identifier", "Allows a service to provide a unique, business identifier for the request.", 0, java.lang.Integer.MAX_VALUE, identifier);
        case 8911915: /*instantiatesCanonical*/  return new Property("instantiatesCanonical", "canonical", "A canonical URL referencing a FHIR-defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE, instantiatesCanonical);
        case -1926393373: /*instantiatesUri*/  return new Property("instantiatesUri", "uri", "A URL referencing an externally defined protocol, guideline, orderset or other definition that is adhered to in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE, instantiatesUri);
        case -332612366: /*basedOn*/  return new Property("basedOn", "Reference(Any)", "A plan, proposal or order that is fulfilled in whole or in part by this request.", 0, java.lang.Integer.MAX_VALUE, basedOn);
        case -430332865: /*replaces*/  return new Property("replaces", "Reference(Any)", "Completed or terminated request(s) whose function is taken by this new request.", 0, java.lang.Integer.MAX_VALUE, replaces);
        case -445338488: /*groupIdentifier*/  return new Property("groupIdentifier", "Identifier", "A shared identifier common to multiple independent Request instances that were activated/authorized more or less simultaneously by a single author.  The presence of the same identifier on each request ties those requests together and may have business ramifications in terms of reporting of results, billing, etc.  E.g. a requisition number shared by a set of lab tests ordered together, or a prescription number shared by all meds ordered at one time.", 0, 1, groupIdentifier);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the request. For request orchestrations, the status reflects the status of all the requests in the orchestration.", 0, 1, status);
        case -1183762788: /*intent*/  return new Property("intent", "code", "Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain.", 0, 1, intent);
        case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly the request should be addressed with respect to other requests.", 0, 1, priority);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that identifies what the overall request orchestration is.", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(CareTeam|Device|Group|HealthcareService|Location|Organization|Patient|Practitioner|PractitionerRole|RelatedPerson)", "The subject for which the request orchestration was created.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "Describes the context of the request orchestration, if any.", 0, 1, encounter);
        case -1500852503: /*authoredOn*/  return new Property("authoredOn", "dateTime", "Indicates when the request orchestration was created.", 0, 1, authoredOn);
        case -1406328437: /*author*/  return new Property("author", "Reference(Device|Practitioner|PractitionerRole)", "Provides a reference to the author of the request orchestration.", 0, 1, author);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Describes the reason for the request orchestration in coded or textual form.", 0, java.lang.Integer.MAX_VALUE, reason);
        case 3178259: /*goal*/  return new Property("goal", "Reference(Goal)", "Goals that are intended to be achieved by following the requests in this RequestOrchestration.", 0, java.lang.Integer.MAX_VALUE, goal);
        case 3387378: /*note*/  return new Property("note", "Annotation", "Provides a mechanism to communicate additional information about the response.", 0, java.lang.Integer.MAX_VALUE, note);
        case -1422950858: /*action*/  return new Property("action", "", "The actions, if any, produced by the evaluation of the artifact.", 0, java.lang.Integer.MAX_VALUE, action);
        default: return super.getNamedProperty(_hash, _name, _checkValid);
        }

      }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return this.identifier == null ? new Base[0] : this.identifier.toArray(new Base[this.identifier.size()]); // Identifier
        case 8911915: /*instantiatesCanonical*/ return this.instantiatesCanonical == null ? new Base[0] : this.instantiatesCanonical.toArray(new Base[this.instantiatesCanonical.size()]); // CanonicalType
        case -1926393373: /*instantiatesUri*/ return this.instantiatesUri == null ? new Base[0] : this.instantiatesUri.toArray(new Base[this.instantiatesUri.size()]); // UriType
        case -332612366: /*basedOn*/ return this.basedOn == null ? new Base[0] : this.basedOn.toArray(new Base[this.basedOn.size()]); // Reference
        case -430332865: /*replaces*/ return this.replaces == null ? new Base[0] : this.replaces.toArray(new Base[this.replaces.size()]); // Reference
        case -445338488: /*groupIdentifier*/ return this.groupIdentifier == null ? new Base[0] : new Base[] {this.groupIdentifier}; // Identifier
        case -892481550: /*status*/ return this.status == null ? new Base[0] : new Base[] {this.status}; // Enumeration<RequestStatus>
        case -1183762788: /*intent*/ return this.intent == null ? new Base[0] : new Base[] {this.intent}; // Enumeration<RequestIntent>
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // Enumeration<RequestPriority>
        case 3059181: /*code*/ return this.code == null ? new Base[0] : new Base[] {this.code}; // CodeableConcept
        case -1867885268: /*subject*/ return this.subject == null ? new Base[0] : new Base[] {this.subject}; // Reference
        case 1524132147: /*encounter*/ return this.encounter == null ? new Base[0] : new Base[] {this.encounter}; // Reference
        case -1500852503: /*authoredOn*/ return this.authoredOn == null ? new Base[0] : new Base[] {this.authoredOn}; // DateTimeType
        case -1406328437: /*author*/ return this.author == null ? new Base[0] : new Base[] {this.author}; // Reference
        case -934964668: /*reason*/ return this.reason == null ? new Base[0] : this.reason.toArray(new Base[this.reason.size()]); // CodeableReference
        case 3178259: /*goal*/ return this.goal == null ? new Base[0] : this.goal.toArray(new Base[this.goal.size()]); // Reference
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // RequestOrchestrationActionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1618432855: // identifier
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value)); // Identifier
          return value;
        case 8911915: // instantiatesCanonical
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value)); // CanonicalType
          return value;
        case -1926393373: // instantiatesUri
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value)); // UriType
          return value;
        case -332612366: // basedOn
          this.getBasedOn().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -430332865: // replaces
          this.getReplaces().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case -445338488: // groupIdentifier
          this.groupIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
          return value;
        case -892481550: // status
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
          return value;
        case -1183762788: // intent
          value = new RequestIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<RequestIntent>
          return value;
        case -1165461084: // priority
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
          return value;
        case 3059181: // code
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
          return value;
        case -1867885268: // subject
          this.subject = TypeConvertor.castToReference(value); // Reference
          return value;
        case 1524132147: // encounter
          this.encounter = TypeConvertor.castToReference(value); // Reference
          return value;
        case -1500852503: // authoredOn
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
          return value;
        case -1406328437: // author
          this.author = TypeConvertor.castToReference(value); // Reference
          return value;
        case -934964668: // reason
          this.getReason().add(TypeConvertor.castToCodeableReference(value)); // CodeableReference
          return value;
        case 3178259: // goal
          this.getGoal().add(TypeConvertor.castToReference(value)); // Reference
          return value;
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1422950858: // action
          this.getAction().add((RequestOrchestrationActionComponent) value); // RequestOrchestrationActionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("identifier")) {
          this.getIdentifier().add(TypeConvertor.castToIdentifier(value));
        } else if (name.equals("instantiatesCanonical")) {
          this.getInstantiatesCanonical().add(TypeConvertor.castToCanonical(value));
        } else if (name.equals("instantiatesUri")) {
          this.getInstantiatesUri().add(TypeConvertor.castToUri(value));
        } else if (name.equals("basedOn")) {
          this.getBasedOn().add(TypeConvertor.castToReference(value));
        } else if (name.equals("replaces")) {
          this.getReplaces().add(TypeConvertor.castToReference(value));
        } else if (name.equals("groupIdentifier")) {
          this.groupIdentifier = TypeConvertor.castToIdentifier(value); // Identifier
        } else if (name.equals("status")) {
          value = new RequestStatusEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.status = (Enumeration) value; // Enumeration<RequestStatus>
        } else if (name.equals("intent")) {
          value = new RequestIntentEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.intent = (Enumeration) value; // Enumeration<RequestIntent>
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("code")) {
          this.code = TypeConvertor.castToCodeableConcept(value); // CodeableConcept
        } else if (name.equals("subject")) {
          this.subject = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("encounter")) {
          this.encounter = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("authoredOn")) {
          this.authoredOn = TypeConvertor.castToDateTime(value); // DateTimeType
        } else if (name.equals("author")) {
          this.author = TypeConvertor.castToReference(value); // Reference
        } else if (name.equals("reason")) {
          this.getReason().add(TypeConvertor.castToCodeableReference(value));
        } else if (name.equals("goal")) {
          this.getGoal().add(TypeConvertor.castToReference(value));
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("action")) {
          this.getAction().add((RequestOrchestrationActionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855:  return addIdentifier(); 
        case 8911915:  return addInstantiatesCanonicalElement();
        case -1926393373:  return addInstantiatesUriElement();
        case -332612366:  return addBasedOn(); 
        case -430332865:  return addReplaces(); 
        case -445338488:  return getGroupIdentifier();
        case -892481550:  return getStatusElement();
        case -1183762788:  return getIntentElement();
        case -1165461084:  return getPriorityElement();
        case 3059181:  return getCode();
        case -1867885268:  return getSubject();
        case 1524132147:  return getEncounter();
        case -1500852503:  return getAuthoredOnElement();
        case -1406328437:  return getAuthor();
        case -934964668:  return addReason(); 
        case 3178259:  return addGoal(); 
        case 3387378:  return addNote(); 
        case -1422950858:  return addAction(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1618432855: /*identifier*/ return new String[] {"Identifier"};
        case 8911915: /*instantiatesCanonical*/ return new String[] {"canonical"};
        case -1926393373: /*instantiatesUri*/ return new String[] {"uri"};
        case -332612366: /*basedOn*/ return new String[] {"Reference"};
        case -430332865: /*replaces*/ return new String[] {"Reference"};
        case -445338488: /*groupIdentifier*/ return new String[] {"Identifier"};
        case -892481550: /*status*/ return new String[] {"code"};
        case -1183762788: /*intent*/ return new String[] {"code"};
        case -1165461084: /*priority*/ return new String[] {"code"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case -1867885268: /*subject*/ return new String[] {"Reference"};
        case 1524132147: /*encounter*/ return new String[] {"Reference"};
        case -1500852503: /*authoredOn*/ return new String[] {"dateTime"};
        case -1406328437: /*author*/ return new String[] {"Reference"};
        case -934964668: /*reason*/ return new String[] {"CodeableReference"};
        case 3178259: /*goal*/ return new String[] {"Reference"};
        case 3387378: /*note*/ return new String[] {"Annotation"};
        case -1422950858: /*action*/ return new String[] {};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("identifier")) {
          return addIdentifier();
        }
        else if (name.equals("instantiatesCanonical")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.instantiatesUri");
        }
        else if (name.equals("basedOn")) {
          return addBasedOn();
        }
        else if (name.equals("replaces")) {
          return addReplaces();
        }
        else if (name.equals("groupIdentifier")) {
          this.groupIdentifier = new Identifier();
          return this.groupIdentifier;
        }
        else if (name.equals("status")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.status");
        }
        else if (name.equals("intent")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.intent");
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.priority");
        }
        else if (name.equals("code")) {
          this.code = new CodeableConcept();
          return this.code;
        }
        else if (name.equals("subject")) {
          this.subject = new Reference();
          return this.subject;
        }
        else if (name.equals("encounter")) {
          this.encounter = new Reference();
          return this.encounter;
        }
        else if (name.equals("authoredOn")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestOrchestration.authoredOn");
        }
        else if (name.equals("author")) {
          this.author = new Reference();
          return this.author;
        }
        else if (name.equals("reason")) {
          return addReason();
        }
        else if (name.equals("goal")) {
          return addGoal();
        }
        else if (name.equals("note")) {
          return addNote();
        }
        else if (name.equals("action")) {
          return addAction();
        }
        else
          return super.addChild(name);
      }

  public String fhirType() {
    return "RequestOrchestration";

  }

      public RequestOrchestration copy() {
        RequestOrchestration dst = new RequestOrchestration();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestOrchestration dst) {
        super.copyValues(dst);
        if (identifier != null) {
          dst.identifier = new ArrayList<Identifier>();
          for (Identifier i : identifier)
            dst.identifier.add(i.copy());
        };
        if (instantiatesCanonical != null) {
          dst.instantiatesCanonical = new ArrayList<CanonicalType>();
          for (CanonicalType i : instantiatesCanonical)
            dst.instantiatesCanonical.add(i.copy());
        };
        if (instantiatesUri != null) {
          dst.instantiatesUri = new ArrayList<UriType>();
          for (UriType i : instantiatesUri)
            dst.instantiatesUri.add(i.copy());
        };
        if (basedOn != null) {
          dst.basedOn = new ArrayList<Reference>();
          for (Reference i : basedOn)
            dst.basedOn.add(i.copy());
        };
        if (replaces != null) {
          dst.replaces = new ArrayList<Reference>();
          for (Reference i : replaces)
            dst.replaces.add(i.copy());
        };
        dst.groupIdentifier = groupIdentifier == null ? null : groupIdentifier.copy();
        dst.status = status == null ? null : status.copy();
        dst.intent = intent == null ? null : intent.copy();
        dst.priority = priority == null ? null : priority.copy();
        dst.code = code == null ? null : code.copy();
        dst.subject = subject == null ? null : subject.copy();
        dst.encounter = encounter == null ? null : encounter.copy();
        dst.authoredOn = authoredOn == null ? null : authoredOn.copy();
        dst.author = author == null ? null : author.copy();
        if (reason != null) {
          dst.reason = new ArrayList<CodeableReference>();
          for (CodeableReference i : reason)
            dst.reason.add(i.copy());
        };
        if (goal != null) {
          dst.goal = new ArrayList<Reference>();
          for (Reference i : goal)
            dst.goal.add(i.copy());
        };
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (action != null) {
          dst.action = new ArrayList<RequestOrchestrationActionComponent>();
          for (RequestOrchestrationActionComponent i : action)
            dst.action.add(i.copy());
        };
      }

      protected RequestOrchestration typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestOrchestration))
          return false;
        RequestOrchestration o = (RequestOrchestration) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(replaces, o.replaces, true) && compareDeep(groupIdentifier, o.groupIdentifier, true)
           && compareDeep(status, o.status, true) && compareDeep(intent, o.intent, true) && compareDeep(priority, o.priority, true)
           && compareDeep(code, o.code, true) && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(authoredOn, o.authoredOn, true) && compareDeep(author, o.author, true) && compareDeep(reason, o.reason, true)
           && compareDeep(goal, o.goal, true) && compareDeep(note, o.note, true) && compareDeep(action, o.action, true)
          ;
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestOrchestration))
          return false;
        RequestOrchestration o = (RequestOrchestration) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(status, o.status, true) && compareValues(intent, o.intent, true) && compareValues(priority, o.priority, true)
           && compareValues(authoredOn, o.authoredOn, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiatesCanonical
          , instantiatesUri, basedOn, replaces, groupIdentifier, status, intent, priority
          , code, subject, encounter, authoredOn, author, reason, goal, note, action
          );
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.RequestOrchestration;
   }

 /**
   * Search parameter: <b>author</b>
   * <p>
   * Description: <b>The author of the request orchestration</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.author</b><br>
   * </p>
   */
  @SearchParamDefinition(name="author", path="RequestOrchestration.author", description="The author of the request orchestration", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Device.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_AUTHOR = "author";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>author</b>
   * <p>
   * Description: <b>The author of the request orchestration</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.author</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam AUTHOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_AUTHOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestOrchestration:author</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_AUTHOR = new ca.uhn.fhir.model.api.Include("RequestOrchestration:author").toLocked();

 /**
   * Search parameter: <b>authored</b>
   * <p>
   * Description: <b>The date the request orchestration was authored</b><br>
   * Type: <b>date</b><br>
   * Path: <b>RequestOrchestration.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="authored", path="RequestOrchestration.authoredOn", description="The date the request orchestration was authored", type="date" )
  public static final String SP_AUTHORED = "authored";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>authored</b>
   * <p>
   * Description: <b>The date the request orchestration was authored</b><br>
   * Type: <b>date</b><br>
   * Path: <b>RequestOrchestration.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam AUTHORED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_AUTHORED);

 /**
   * Search parameter: <b>based-on</b>
   * <p>
   * Description: <b>What this request fullfills.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.basedOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="based-on", path="RequestOrchestration.basedOn", description="What this request fullfills.", type="reference", target={Account.class, ActivityDefinition.class, ActorDefinition.class, AdministrableProductDefinition.class, AdverseEvent.class, AllergyIntolerance.class, Appointment.class, AppointmentResponse.class, ArtifactAssessment.class, AuditEvent.class, Basic.class, Binary.class, BiologicallyDerivedProduct.class, BiologicallyDerivedProductDispense.class, BodyStructure.class, Bundle.class, CapabilityStatement.class, CarePlan.class, CareTeam.class, ChargeItem.class, ChargeItemDefinition.class, Citation.class, Claim.class, ClaimResponse.class, ClinicalImpression.class, ClinicalUseDefinition.class, CodeSystem.class, Communication.class, CommunicationRequest.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, Condition.class, ConditionDefinition.class, Consent.class, Contract.class, Coverage.class, CoverageEligibilityRequest.class, CoverageEligibilityResponse.class, DetectedIssue.class, Device.class, DeviceAssociation.class, DeviceDefinition.class, DeviceDispense.class, DeviceMetric.class, DeviceRequest.class, DeviceUsage.class, DiagnosticReport.class, DocumentReference.class, Encounter.class, EncounterHistory.class, Endpoint.class, EnrollmentRequest.class, EnrollmentResponse.class, EpisodeOfCare.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, ExplanationOfBenefit.class, FamilyMemberHistory.class, Flag.class, FormularyItem.class, GenomicStudy.class, Goal.class, GraphDefinition.class, Group.class, GuidanceResponse.class, HealthcareService.class, ImagingSelection.class, ImagingStudy.class, Immunization.class, ImmunizationEvaluation.class, ImmunizationRecommendation.class, ImplementationGuide.class, Ingredient.class, InsurancePlan.class, InventoryItem.class, InventoryReport.class, Invoice.class, Library.class, Linkage.class, ListResource.class, Location.class, ManufacturedItemDefinition.class, Measure.class, MeasureReport.class, Medication.class, MedicationAdministration.class, MedicationDispense.class, MedicationKnowledge.class, MedicationRequest.class, MedicationStatement.class, MedicinalProductDefinition.class, MessageDefinition.class, MessageHeader.class, MolecularSequence.class, NamingSystem.class, NutritionIntake.class, NutritionOrder.class, NutritionProduct.class, Observation.class, ObservationDefinition.class, OperationDefinition.class, OperationOutcome.class, Organization.class, OrganizationAffiliation.class, PackagedProductDefinition.class, Parameters.class, Patient.class, PaymentNotice.class, PaymentReconciliation.class, Permission.class, Person.class, PlanDefinition.class, Practitioner.class, PractitionerRole.class, Procedure.class, Provenance.class, Questionnaire.class, QuestionnaireResponse.class, RegulatedAuthorization.class, RelatedPerson.class, RequestOrchestration.class, Requirements.class, ResearchStudy.class, ResearchSubject.class, RiskAssessment.class, Schedule.class, SearchParameter.class, ServiceRequest.class, Slot.class, Specimen.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, Subscription.class, SubscriptionStatus.class, SubscriptionTopic.class, Substance.class, SubstanceDefinition.class, SubstanceNucleicAcid.class, SubstancePolymer.class, SubstanceProtein.class, SubstanceReferenceInformation.class, SubstanceSourceMaterial.class, SupplyDelivery.class, SupplyRequest.class, Task.class, TerminologyCapabilities.class, TestPlan.class, TestReport.class, TestScript.class, Transport.class, ValueSet.class, VerificationResult.class, VisionPrescription.class } )
  public static final String SP_BASED_ON = "based-on";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>based-on</b>
   * <p>
   * Description: <b>What this request fullfills.</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.basedOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam BASED_ON = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_BASED_ON);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestOrchestration:based-on</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_BASED_ON = new ca.uhn.fhir.model.api.Include("RequestOrchestration:based-on").toLocked();

 /**
   * Search parameter: <b>group-identifier</b>
   * <p>
   * Description: <b>The group identifier for the request orchestration</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestOrchestration.groupIdentifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="group-identifier", path="RequestOrchestration.groupIdentifier", description="The group identifier for the request orchestration", type="token" )
  public static final String SP_GROUP_IDENTIFIER = "group-identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>group-identifier</b>
   * <p>
   * Description: <b>The group identifier for the request orchestration</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestOrchestration.groupIdentifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam GROUP_IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_GROUP_IDENTIFIER);

 /**
   * Search parameter: <b>instantiates-canonical</b>
   * <p>
   * Description: <b>The FHIR-based definition from which the request orchestration is realized</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.instantiatesCanonical</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-canonical", path="RequestOrchestration.instantiatesCanonical", description="The FHIR-based definition from which the request orchestration is realized", type="reference", target={ActivityDefinition.class, ActorDefinition.class, CapabilityStatement.class, ChargeItemDefinition.class, Citation.class, CodeSystem.class, CompartmentDefinition.class, Composition.class, ConceptMap.class, ConditionDefinition.class, Contract.class, Device.class, EventDefinition.class, Evidence.class, EvidenceReport.class, EvidenceVariable.class, ExampleScenario.class, GraphDefinition.class, ImplementationGuide.class, Library.class, Measure.class, MessageDefinition.class, NamingSystem.class, ObservationDefinition.class, OperationDefinition.class, PlanDefinition.class, Questionnaire.class, Requirements.class, ResearchStudy.class, SearchParameter.class, SpecimenDefinition.class, StructureDefinition.class, StructureMap.class, SubscriptionTopic.class, TerminologyCapabilities.class, TestPlan.class, TestScript.class, ValueSet.class } )
  public static final String SP_INSTANTIATES_CANONICAL = "instantiates-canonical";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-canonical</b>
   * <p>
   * Description: <b>The FHIR-based definition from which the request orchestration is realized</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.instantiatesCanonical</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INSTANTIATES_CANONICAL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INSTANTIATES_CANONICAL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestOrchestration:instantiates-canonical</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INSTANTIATES_CANONICAL = new ca.uhn.fhir.model.api.Include("RequestOrchestration:instantiates-canonical").toLocked();

 /**
   * Search parameter: <b>instantiates-uri</b>
   * <p>
   * Description: <b>The external definition from which the request orchestration is realized</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>RequestOrchestration.instantiatesUri</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-uri", path="RequestOrchestration.instantiatesUri", description="The external definition from which the request orchestration is realized", type="uri" )
  public static final String SP_INSTANTIATES_URI = "instantiates-uri";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-uri</b>
   * <p>
   * Description: <b>The external definition from which the request orchestration is realized</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>RequestOrchestration.instantiatesUri</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam INSTANTIATES_URI = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_INSTANTIATES_URI);

 /**
   * Search parameter: <b>intent</b>
   * <p>
   * Description: <b>The intent of the request orchestration</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestOrchestration.intent</b><br>
   * </p>
   */
  @SearchParamDefinition(name="intent", path="RequestOrchestration.intent", description="The intent of the request orchestration", type="token" )
  public static final String SP_INTENT = "intent";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>intent</b>
   * <p>
   * Description: <b>The intent of the request orchestration</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestOrchestration.intent</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INTENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INTENT);

 /**
   * Search parameter: <b>participant</b>
   * <p>
   * Description: <b>The participant in the requests in the orchestration</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.action.participant.actor.ofType(Reference) | RequestOrchestration.action.participant.actor.ofType(canonical)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="participant", path="RequestOrchestration.action.participant.actor.ofType(Reference) | RequestOrchestration.action.participant.actor.ofType(canonical)", description="The participant in the requests in the orchestration", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={CapabilityStatement.class, CareTeam.class, Device.class, DeviceDefinition.class, Endpoint.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PARTICIPANT = "participant";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>participant</b>
   * <p>
   * Description: <b>The participant in the requests in the orchestration</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.action.participant.actor.ofType(Reference) | RequestOrchestration.action.participant.actor.ofType(canonical)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PARTICIPANT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PARTICIPANT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestOrchestration:participant</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PARTICIPANT = new ca.uhn.fhir.model.api.Include("RequestOrchestration:participant").toLocked();

 /**
   * Search parameter: <b>priority</b>
   * <p>
   * Description: <b>The priority of the request orchestration</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestOrchestration.priority</b><br>
   * </p>
   */
  @SearchParamDefinition(name="priority", path="RequestOrchestration.priority", description="The priority of the request orchestration", type="token" )
  public static final String SP_PRIORITY = "priority";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>priority</b>
   * <p>
   * Description: <b>The priority of the request orchestration</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestOrchestration.priority</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PRIORITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PRIORITY);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the request orchestration</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestOrchestration.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="RequestOrchestration.status", description="The status of the request orchestration", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the request orchestration</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestOrchestration.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The subject that the request orchestration is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="RequestOrchestration.subject", description="The subject that the request orchestration is about", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={CareTeam.class, Device.class, Group.class, HealthcareService.class, Location.class, Organization.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The subject that the request orchestration is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestOrchestration.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestOrchestration:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("RequestOrchestration:subject").toLocked();

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted
* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [AuditEvent](auditevent.html): More specific code for the event
* [Basic](basic.html): Kind of Resource
* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code
* [Condition](condition.html): Code for the condition
* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [ImagingSelection](imagingselection.html): The imaging selection status
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationStatement](medicationstatement.html): Return statements of this medication code
* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [RequestOrchestration](requestorchestration.html): The code of the request orchestration
* [Task](task.html): Search by task code
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code", description="Multiple Resources: \r\n\r\n* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted\r\n* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance\r\n* [AuditEvent](auditevent.html): More specific code for the event\r\n* [Basic](basic.html): Kind of Resource\r\n* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code\r\n* [Condition](condition.html): Code for the condition\r\n* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.\r\n* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered\r\n* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code\r\n* [ImagingSelection](imagingselection.html): The imaging selection status\r\n* [List](list.html): What the purpose of this list is\r\n* [Medication](medication.html): Returns medications for a specific code\r\n* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code\r\n* [MedicationStatement](medicationstatement.html): Return statements of this medication code\r\n* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake\r\n* [Observation](observation.html): The code of the observation type\r\n* [Procedure](procedure.html): A code to identify a  procedure\r\n* [RequestOrchestration](requestorchestration.html): The code of the request orchestration\r\n* [Task](task.html): Search by task code\r\n", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AdverseEvent](adverseevent.html): Event or incident that occurred or was averted
* [AllergyIntolerance](allergyintolerance.html): Code that identifies the allergy or intolerance
* [AuditEvent](auditevent.html): More specific code for the event
* [Basic](basic.html): Kind of Resource
* [ChargeItem](chargeitem.html): A code that identifies the charge, like a billing code
* [Condition](condition.html): Code for the condition
* [DetectedIssue](detectedissue.html): Issue Type, e.g. drug-drug, duplicate therapy, etc.
* [DeviceRequest](devicerequest.html): Code for what is being requested/ordered
* [DiagnosticReport](diagnosticreport.html): The code for the report, as opposed to codes for the atomic results, which are the names on the observation resource referred to from the result
* [FamilyMemberHistory](familymemberhistory.html): A search by a condition code
* [ImagingSelection](imagingselection.html): The imaging selection status
* [List](list.html): What the purpose of this list is
* [Medication](medication.html): Returns medications for a specific code
* [MedicationAdministration](medicationadministration.html): Return administrations of this medication code
* [MedicationDispense](medicationdispense.html): Returns dispenses of this medicine code
* [MedicationRequest](medicationrequest.html): Return prescriptions of this medication code
* [MedicationStatement](medicationstatement.html): Return statements of this medication code
* [NutritionIntake](nutritionintake.html): Returns statements of this code of NutritionIntake
* [Observation](observation.html): The code of the observation type
* [Procedure](procedure.html): A code to identify a  procedure
* [RequestOrchestration](requestorchestration.html): The code of the request orchestration
* [Task](task.html): Search by task code
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>AdverseEvent.code | AllergyIntolerance.code | AllergyIntolerance.reaction.substance | AuditEvent.code | Basic.code | ChargeItem.code | Condition.code | DetectedIssue.code | DeviceRequest.code.concept | DiagnosticReport.code | FamilyMemberHistory.condition.code | ImagingSelection.status | List.code | Medication.code | MedicationAdministration.medication.concept | MedicationDispense.medication.concept | MedicationRequest.medication.concept | MedicationStatement.medication.concept | NutritionIntake.code | Observation.code | Procedure.code | RequestOrchestration.code | Task.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter", description="Multiple Resources: \r\n\r\n* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent\r\n* [CarePlan](careplan.html): The Encounter during which this CarePlan was created\r\n* [ChargeItem](chargeitem.html): Encounter associated with event\r\n* [Claim](claim.html): Encounters associated with a billed line item\r\n* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created\r\n* [Communication](communication.html): The Encounter during which this Communication was created\r\n* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created\r\n* [Composition](composition.html): Context of the Composition\r\n* [Condition](condition.html): The Encounter during which this Condition was created\r\n* [DeviceRequest](devicerequest.html): Encounter during which request was created\r\n* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made\r\n* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values\r\n* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item\r\n* [Flag](flag.html): Alert relevant during encounter\r\n* [ImagingStudy](imagingstudy.html): The context of the study\r\n* [List](list.html): Context in which list created\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier\r\n* [Observation](observation.html): Encounter related to the observation\r\n* [Procedure](procedure.html): The Encounter during which this Procedure was created\r\n* [Provenance](provenance.html): Encounter related to the Provenance\r\n* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response\r\n* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to\r\n* [RiskAssessment](riskassessment.html): Where was assessment performed?\r\n* [ServiceRequest](servicerequest.html): An encounter in which this request is made\r\n* [Task](task.html): Search by encounter\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier\r\n", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [AuditEvent](auditevent.html): Encounter related to the activity recorded in the AuditEvent
* [CarePlan](careplan.html): The Encounter during which this CarePlan was created
* [ChargeItem](chargeitem.html): Encounter associated with event
* [Claim](claim.html): Encounters associated with a billed line item
* [ClinicalImpression](clinicalimpression.html): The Encounter during which this ClinicalImpression was created
* [Communication](communication.html): The Encounter during which this Communication was created
* [CommunicationRequest](communicationrequest.html): The Encounter during which this CommunicationRequest was created
* [Composition](composition.html): Context of the Composition
* [Condition](condition.html): The Encounter during which this Condition was created
* [DeviceRequest](devicerequest.html): Encounter during which request was created
* [DiagnosticReport](diagnosticreport.html): The Encounter when the order was made
* [EncounterHistory](encounterhistory.html): The Encounter associated with this set of history values
* [ExplanationOfBenefit](explanationofbenefit.html): Encounters associated with a billed line item
* [Flag](flag.html): Alert relevant during encounter
* [ImagingStudy](imagingstudy.html): The context of the study
* [List](list.html): Context in which list created
* [MedicationDispense](medicationdispense.html): Returns dispenses with a specific encounter
* [MedicationStatement](medicationstatement.html): Returns statements for a specific encounter
* [NutritionIntake](nutritionintake.html): Returns statements for a specific encounter
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this encounter identifier
* [Observation](observation.html): Encounter related to the observation
* [Procedure](procedure.html): The Encounter during which this Procedure was created
* [Provenance](provenance.html): Encounter related to the Provenance
* [QuestionnaireResponse](questionnaireresponse.html): Encounter associated with the questionnaire response
* [RequestOrchestration](requestorchestration.html): The encounter the request orchestration applies to
* [RiskAssessment](riskassessment.html): Where was assessment performed?
* [ServiceRequest](servicerequest.html): An encounter in which this request is made
* [Task](task.html): Search by encounter
* [VisionPrescription](visionprescription.html): Return prescriptions with this encounter identifier
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>AuditEvent.encounter | CarePlan.encounter | ChargeItem.encounter | Claim.item.encounter | ClinicalImpression.encounter | Communication.encounter | CommunicationRequest.encounter | Composition.encounter | Condition.encounter | DeviceRequest.encounter | DiagnosticReport.encounter | EncounterHistory.encounter | ExplanationOfBenefit.item.encounter | Flag.encounter | ImagingStudy.encounter | List.encounter | MedicationDispense.encounter | MedicationStatement.encounter | NutritionIntake.encounter | NutritionOrder.encounter | Observation.encounter | Procedure.encounter | Provenance.encounter | QuestionnaireResponse.encounter | RequestOrchestration.encounter | RiskAssessment.encounter | ServiceRequest.encounter | Task.encounter | VisionPrescription.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestOrchestration:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("RequestOrchestration:encounter").toLocked();

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier", description="Multiple Resources: \r\n\r\n* [Account](account.html): Account number\r\n* [AdverseEvent](adverseevent.html): Business identifier for the event\r\n* [AllergyIntolerance](allergyintolerance.html): External ids for this item\r\n* [Appointment](appointment.html): An Identifier of the Appointment\r\n* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response\r\n* [Basic](basic.html): Business identifier\r\n* [BodyStructure](bodystructure.html): Bodystructure identifier\r\n* [CarePlan](careplan.html): External Ids for this plan\r\n* [CareTeam](careteam.html): External Ids for this team\r\n* [ChargeItem](chargeitem.html): Business Identifier for item\r\n* [Claim](claim.html): The primary identifier of the financial resource\r\n* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse\r\n* [ClinicalImpression](clinicalimpression.html): Business identifier\r\n* [Communication](communication.html): Unique identifier\r\n* [CommunicationRequest](communicationrequest.html): Unique identifier\r\n* [Composition](composition.html): Version-independent identifier for the Composition\r\n* [Condition](condition.html): A unique identifier of the condition record\r\n* [Consent](consent.html): Identifier for this record (external references)\r\n* [Contract](contract.html): The identity of the contract\r\n* [Coverage](coverage.html): The primary identifier of the insured and the coverage\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier\r\n* [DetectedIssue](detectedissue.html): Unique id for the detected issue\r\n* [DeviceRequest](devicerequest.html): Business identifier for request/order\r\n* [DeviceUsage](deviceusage.html): Search by identifier\r\n* [DiagnosticReport](diagnosticreport.html): An identifier for the report\r\n* [DocumentReference](documentreference.html): Identifier of the attachment binary\r\n* [Encounter](encounter.html): Identifier(s) by which this encounter is known\r\n* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment\r\n* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit\r\n* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier\r\n* [Flag](flag.html): Business identifier\r\n* [Goal](goal.html): External Ids for this goal\r\n* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response\r\n* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection\r\n* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID\r\n* [Immunization](immunization.html): Business identifier\r\n* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier\r\n* [Invoice](invoice.html): Business Identifier for item\r\n* [List](list.html): Business identifier\r\n* [MeasureReport](measurereport.html): External identifier of the measure report to be returned\r\n* [Medication](medication.html): Returns medications with this external identifier\r\n* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier\r\n* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier\r\n* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier\r\n* [MedicationStatement](medicationstatement.html): Return statements with this external identifier\r\n* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence\r\n* [NutritionIntake](nutritionintake.html): Return statements with this external identifier\r\n* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier\r\n* [Observation](observation.html): The unique id for a particular observation\r\n* [Person](person.html): A person Identifier\r\n* [Procedure](procedure.html): A unique identifier for a procedure\r\n* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response\r\n* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson\r\n* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration\r\n* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study\r\n* [RiskAssessment](riskassessment.html): Unique identifier for the assessment\r\n* [ServiceRequest](servicerequest.html): Identifiers assigned to this order\r\n* [Specimen](specimen.html): The unique identifier associated with the specimen\r\n* [SupplyDelivery](supplydelivery.html): External identifier\r\n* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest\r\n* [Task](task.html): Search for a task instance by its business identifier\r\n* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier\r\n", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): Account number
* [AdverseEvent](adverseevent.html): Business identifier for the event
* [AllergyIntolerance](allergyintolerance.html): External ids for this item
* [Appointment](appointment.html): An Identifier of the Appointment
* [AppointmentResponse](appointmentresponse.html): An Identifier in this appointment response
* [Basic](basic.html): Business identifier
* [BodyStructure](bodystructure.html): Bodystructure identifier
* [CarePlan](careplan.html): External Ids for this plan
* [CareTeam](careteam.html): External Ids for this team
* [ChargeItem](chargeitem.html): Business Identifier for item
* [Claim](claim.html): The primary identifier of the financial resource
* [ClaimResponse](claimresponse.html): The identity of the ClaimResponse
* [ClinicalImpression](clinicalimpression.html): Business identifier
* [Communication](communication.html): Unique identifier
* [CommunicationRequest](communicationrequest.html): Unique identifier
* [Composition](composition.html): Version-independent identifier for the Composition
* [Condition](condition.html): A unique identifier of the condition record
* [Consent](consent.html): Identifier for this record (external references)
* [Contract](contract.html): The identity of the contract
* [Coverage](coverage.html): The primary identifier of the insured and the coverage
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The business identifier of the Eligibility
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The business identifier
* [DetectedIssue](detectedissue.html): Unique id for the detected issue
* [DeviceRequest](devicerequest.html): Business identifier for request/order
* [DeviceUsage](deviceusage.html): Search by identifier
* [DiagnosticReport](diagnosticreport.html): An identifier for the report
* [DocumentReference](documentreference.html): Identifier of the attachment binary
* [Encounter](encounter.html): Identifier(s) by which this encounter is known
* [EnrollmentRequest](enrollmentrequest.html): The business identifier of the Enrollment
* [EpisodeOfCare](episodeofcare.html): Business Identifier(s) relevant for this EpisodeOfCare
* [ExplanationOfBenefit](explanationofbenefit.html): The business identifier of the Explanation of Benefit
* [FamilyMemberHistory](familymemberhistory.html): A search by a record identifier
* [Flag](flag.html): Business identifier
* [Goal](goal.html): External Ids for this goal
* [GuidanceResponse](guidanceresponse.html): The identifier of the guidance response
* [ImagingSelection](imagingselection.html): Identifiers for the imaging selection
* [ImagingStudy](imagingstudy.html): Identifiers for the Study, such as DICOM Study Instance UID
* [Immunization](immunization.html): Business identifier
* [ImmunizationEvaluation](immunizationevaluation.html): ID of the evaluation
* [ImmunizationRecommendation](immunizationrecommendation.html): Business identifier
* [Invoice](invoice.html): Business Identifier for item
* [List](list.html): Business identifier
* [MeasureReport](measurereport.html): External identifier of the measure report to be returned
* [Medication](medication.html): Returns medications with this external identifier
* [MedicationAdministration](medicationadministration.html): Return administrations with this external identifier
* [MedicationDispense](medicationdispense.html): Returns dispenses with this external identifier
* [MedicationRequest](medicationrequest.html): Return prescriptions with this external identifier
* [MedicationStatement](medicationstatement.html): Return statements with this external identifier
* [MolecularSequence](molecularsequence.html): The unique identity for a particular sequence
* [NutritionIntake](nutritionintake.html): Return statements with this external identifier
* [NutritionOrder](nutritionorder.html): Return nutrition orders with this external identifier
* [Observation](observation.html): The unique id for a particular observation
* [Person](person.html): A person Identifier
* [Procedure](procedure.html): A unique identifier for a procedure
* [QuestionnaireResponse](questionnaireresponse.html): The unique identifier for the questionnaire response
* [RelatedPerson](relatedperson.html): An Identifier of the RelatedPerson
* [RequestOrchestration](requestorchestration.html): External identifiers for the request orchestration
* [ResearchSubject](researchsubject.html): Business Identifier for research subject in a study
* [RiskAssessment](riskassessment.html): Unique identifier for the assessment
* [ServiceRequest](servicerequest.html): Identifiers assigned to this order
* [Specimen](specimen.html): The unique identifier associated with the specimen
* [SupplyDelivery](supplydelivery.html): External identifier
* [SupplyRequest](supplyrequest.html): Business Identifier for SupplyRequest
* [Task](task.html): Search for a task instance by its business identifier
* [VisionPrescription](visionprescription.html): Return prescriptions with this external identifier
</b><br>
   * Type: <b>token</b><br>
   * Path: <b>Account.identifier | AdverseEvent.identifier | AllergyIntolerance.identifier | Appointment.identifier | AppointmentResponse.identifier | Basic.identifier | BodyStructure.identifier | CarePlan.identifier | CareTeam.identifier | ChargeItem.identifier | Claim.identifier | ClaimResponse.identifier | ClinicalImpression.identifier | Communication.identifier | CommunicationRequest.identifier | Composition.identifier | Condition.identifier | Consent.identifier | Contract.identifier | Coverage.identifier | CoverageEligibilityRequest.identifier | CoverageEligibilityResponse.identifier | DetectedIssue.identifier | DeviceRequest.identifier | DeviceUsage.identifier | DiagnosticReport.identifier | DocumentReference.identifier | Encounter.identifier | EnrollmentRequest.identifier | EpisodeOfCare.identifier | ExplanationOfBenefit.identifier | FamilyMemberHistory.identifier | Flag.identifier | Goal.identifier | GuidanceResponse.identifier | ImagingSelection.identifier | ImagingStudy.identifier | Immunization.identifier | ImmunizationEvaluation.identifier | ImmunizationRecommendation.identifier | Invoice.identifier | List.identifier | MeasureReport.identifier | Medication.identifier | MedicationAdministration.identifier | MedicationDispense.identifier | MedicationRequest.identifier | MedicationStatement.identifier | MolecularSequence.identifier | NutritionIntake.identifier | NutritionOrder.identifier | Observation.identifier | Person.identifier | Procedure.identifier | QuestionnaireResponse.identifier | RelatedPerson.identifier | RequestOrchestration.identifier | ResearchSubject.identifier | RiskAssessment.identifier | ServiceRequest.identifier | Specimen.identifier | SupplyDelivery.identifier | SupplyRequest.identifier | Task.identifier | VisionPrescription.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient", description="Multiple Resources: \r\n\r\n* [Account](account.html): The entity that caused the expenses\r\n* [AdverseEvent](adverseevent.html): Subject impacted by event\r\n* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for\r\n* [Appointment](appointment.html): One of the individuals of the appointment is this patient\r\n* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient\r\n* [AuditEvent](auditevent.html): Where the activity involved patient data\r\n* [Basic](basic.html): Identifies the focus of this resource\r\n* [BodyStructure](bodystructure.html): Who this is about\r\n* [CarePlan](careplan.html): Who the care plan is for\r\n* [CareTeam](careteam.html): Who care team is for\r\n* [ChargeItem](chargeitem.html): Individual service was done for/to\r\n* [Claim](claim.html): Patient receiving the products or services\r\n* [ClaimResponse](claimresponse.html): The subject of care\r\n* [ClinicalImpression](clinicalimpression.html): Patient assessed\r\n* [Communication](communication.html): Focus of message\r\n* [CommunicationRequest](communicationrequest.html): Focus of message\r\n* [Composition](composition.html): Who and/or what the composition is about\r\n* [Condition](condition.html): Who has the condition?\r\n* [Consent](consent.html): Who the consent applies to\r\n* [Contract](contract.html): The identity of the subject of the contract (if a patient)\r\n* [Coverage](coverage.html): Retrieve coverages for a patient\r\n* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient\r\n* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient\r\n* [DetectedIssue](detectedissue.html): Associated patient\r\n* [DeviceRequest](devicerequest.html): Individual the service is ordered for\r\n* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device\r\n* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient\r\n* [DocumentReference](documentreference.html): Who/what is the subject of the document\r\n* [Encounter](encounter.html): The patient present at the encounter\r\n* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled\r\n* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care\r\n* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient\r\n* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for\r\n* [Flag](flag.html): The identity of a subject to list flags for\r\n* [Goal](goal.html): Who this goal is intended for\r\n* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results\r\n* [ImagingSelection](imagingselection.html): Who the study is about\r\n* [ImagingStudy](imagingstudy.html): Who the study is about\r\n* [Immunization](immunization.html): The patient for the vaccination record\r\n* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated\r\n* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for\r\n* [Invoice](invoice.html): Recipient(s) of goods and services\r\n* [List](list.html): If all resources have the same subject\r\n* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for\r\n* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for\r\n* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for\r\n* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient\r\n* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.\r\n* [MolecularSequence](molecularsequence.html): The subject that the sequence is about\r\n* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.\r\n* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement\r\n* [Observation](observation.html): The subject that the observation is about (if patient)\r\n* [Person](person.html): The Person links to this Patient\r\n* [Procedure](procedure.html): Search by subject - a patient\r\n* [Provenance](provenance.html): Where the activity involved patient data\r\n* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response\r\n* [RelatedPerson](relatedperson.html): The patient this related person is related to\r\n* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations\r\n* [ResearchSubject](researchsubject.html): Who or what is part of study\r\n* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?\r\n* [ServiceRequest](servicerequest.html): Search by subject - a patient\r\n* [Specimen](specimen.html): The patient the specimen comes from\r\n* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied\r\n* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined\r\n* [Task](task.html): Search by patient\r\n* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for\r\n", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>Multiple Resources: 

* [Account](account.html): The entity that caused the expenses
* [AdverseEvent](adverseevent.html): Subject impacted by event
* [AllergyIntolerance](allergyintolerance.html): Who the sensitivity is for
* [Appointment](appointment.html): One of the individuals of the appointment is this patient
* [AppointmentResponse](appointmentresponse.html): This Response is for this Patient
* [AuditEvent](auditevent.html): Where the activity involved patient data
* [Basic](basic.html): Identifies the focus of this resource
* [BodyStructure](bodystructure.html): Who this is about
* [CarePlan](careplan.html): Who the care plan is for
* [CareTeam](careteam.html): Who care team is for
* [ChargeItem](chargeitem.html): Individual service was done for/to
* [Claim](claim.html): Patient receiving the products or services
* [ClaimResponse](claimresponse.html): The subject of care
* [ClinicalImpression](clinicalimpression.html): Patient assessed
* [Communication](communication.html): Focus of message
* [CommunicationRequest](communicationrequest.html): Focus of message
* [Composition](composition.html): Who and/or what the composition is about
* [Condition](condition.html): Who has the condition?
* [Consent](consent.html): Who the consent applies to
* [Contract](contract.html): The identity of the subject of the contract (if a patient)
* [Coverage](coverage.html): Retrieve coverages for a patient
* [CoverageEligibilityRequest](coverageeligibilityrequest.html): The reference to the patient
* [CoverageEligibilityResponse](coverageeligibilityresponse.html): The reference to the patient
* [DetectedIssue](detectedissue.html): Associated patient
* [DeviceRequest](devicerequest.html): Individual the service is ordered for
* [DeviceUsage](deviceusage.html): Search by patient who used / uses the device
* [DiagnosticReport](diagnosticreport.html): The subject of the report if a patient
* [DocumentReference](documentreference.html): Who/what is the subject of the document
* [Encounter](encounter.html): The patient present at the encounter
* [EnrollmentRequest](enrollmentrequest.html): The party to be enrolled
* [EpisodeOfCare](episodeofcare.html): The patient who is the focus of this episode of care
* [ExplanationOfBenefit](explanationofbenefit.html): The reference to the patient
* [FamilyMemberHistory](familymemberhistory.html): The identity of a subject to list family member history items for
* [Flag](flag.html): The identity of a subject to list flags for
* [Goal](goal.html): Who this goal is intended for
* [GuidanceResponse](guidanceresponse.html): The identity of a patient to search for guidance response results
* [ImagingSelection](imagingselection.html): Who the study is about
* [ImagingStudy](imagingstudy.html): Who the study is about
* [Immunization](immunization.html): The patient for the vaccination record
* [ImmunizationEvaluation](immunizationevaluation.html): The patient being evaluated
* [ImmunizationRecommendation](immunizationrecommendation.html): Who this profile is for
* [Invoice](invoice.html): Recipient(s) of goods and services
* [List](list.html): If all resources have the same subject
* [MeasureReport](measurereport.html): The identity of a patient to search for individual measure report results for
* [MedicationAdministration](medicationadministration.html): The identity of a patient to list administrations  for
* [MedicationDispense](medicationdispense.html): The identity of a patient to list dispenses  for
* [MedicationRequest](medicationrequest.html): Returns prescriptions for a specific patient
* [MedicationStatement](medicationstatement.html): Returns statements for a specific patient.
* [MolecularSequence](molecularsequence.html): The subject that the sequence is about
* [NutritionIntake](nutritionintake.html): Returns statements for a specific patient.
* [NutritionOrder](nutritionorder.html): The identity of the individual or set of individuals who requires the diet, formula or nutritional supplement
* [Observation](observation.html): The subject that the observation is about (if patient)
* [Person](person.html): The Person links to this Patient
* [Procedure](procedure.html): Search by subject - a patient
* [Provenance](provenance.html): Where the activity involved patient data
* [QuestionnaireResponse](questionnaireresponse.html): The patient that is the subject of the questionnaire response
* [RelatedPerson](relatedperson.html): The patient this related person is related to
* [RequestOrchestration](requestorchestration.html): The identity of a patient to search for request orchestrations
* [ResearchSubject](researchsubject.html): Who or what is part of study
* [RiskAssessment](riskassessment.html): Who/what does assessment apply to?
* [ServiceRequest](servicerequest.html): Search by subject - a patient
* [Specimen](specimen.html): The patient the specimen comes from
* [SupplyDelivery](supplydelivery.html): Patient for whom the item is supplied
* [SupplyRequest](supplyrequest.html): The patient or subject for whom the supply is destined
* [Task](task.html): Search by patient
* [VisionPrescription](visionprescription.html): The identity of a patient to list dispenses for
</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>Account.subject.where(resolve() is Patient) | AdverseEvent.subject.where(resolve() is Patient) | AllergyIntolerance.patient | Appointment.participant.actor.where(resolve() is Patient) | Appointment.subject.where(resolve() is Patient) | AppointmentResponse.actor.where(resolve() is Patient) | AuditEvent.patient | Basic.subject.where(resolve() is Patient) | BodyStructure.patient | CarePlan.subject.where(resolve() is Patient) | CareTeam.subject.where(resolve() is Patient) | ChargeItem.subject.where(resolve() is Patient) | Claim.patient | ClaimResponse.patient | ClinicalImpression.subject.where(resolve() is Patient) | Communication.subject.where(resolve() is Patient) | CommunicationRequest.subject.where(resolve() is Patient) | Composition.subject.where(resolve() is Patient) | Condition.subject.where(resolve() is Patient) | Consent.subject.where(resolve() is Patient) | Contract.subject.where(resolve() is Patient) | Coverage.beneficiary | CoverageEligibilityRequest.patient | CoverageEligibilityResponse.patient | DetectedIssue.subject.where(resolve() is Patient) | DeviceRequest.subject.where(resolve() is Patient) | DeviceUsage.patient | DiagnosticReport.subject.where(resolve() is Patient) | DocumentReference.subject.where(resolve() is Patient) | Encounter.subject.where(resolve() is Patient) | EnrollmentRequest.candidate | EpisodeOfCare.patient | ExplanationOfBenefit.patient | FamilyMemberHistory.patient | Flag.subject.where(resolve() is Patient) | Goal.subject.where(resolve() is Patient) | GuidanceResponse.subject.where(resolve() is Patient) | ImagingSelection.subject.where(resolve() is Patient) | ImagingStudy.subject.where(resolve() is Patient) | Immunization.patient | ImmunizationEvaluation.patient | ImmunizationRecommendation.patient | Invoice.subject.where(resolve() is Patient) | List.subject.where(resolve() is Patient) | MeasureReport.subject.where(resolve() is Patient) | MedicationAdministration.subject.where(resolve() is Patient) | MedicationDispense.subject.where(resolve() is Patient) | MedicationRequest.subject.where(resolve() is Patient) | MedicationStatement.subject.where(resolve() is Patient) | MolecularSequence.subject.where(resolve() is Patient) | NutritionIntake.subject.where(resolve() is Patient) | NutritionOrder.subject.where(resolve() is Patient) | Observation.subject.where(resolve() is Patient) | Person.link.target.where(resolve() is Patient) | Procedure.subject.where(resolve() is Patient) | Provenance.patient | QuestionnaireResponse.subject.where(resolve() is Patient) | RelatedPerson.patient | RequestOrchestration.subject.where(resolve() is Patient) | ResearchSubject.subject.where(resolve() is Patient) | RiskAssessment.subject.where(resolve() is Patient) | ServiceRequest.subject.where(resolve() is Patient) | Specimen.subject.where(resolve() is Patient) | SupplyDelivery.patient | SupplyRequest.deliverFor | Task.for.where(resolve() is Patient) | VisionPrescription.patient</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestOrchestration:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("RequestOrchestration:patient").toLocked();


}

