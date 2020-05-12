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
 * A group of related requests that can be used to capture intended activities that have inter-dependencies such as "give this medication after that one".
 */
@ResourceDef(name="RequestGroup", profile="http://hl7.org/fhir/StructureDefinition/RequestGroup")
public class RequestGroup extends DomainResource {

    @Block()
    public static class RequestGroupActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * A user-visible prefix for the action.
         */
        @Child(name = "prefix", type = {StringType.class}, order=1, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="User-visible prefix for the action (e.g. 1. or A.)", formalDefinition="A user-visible prefix for the action." )
        protected StringType prefix;

        /**
         * The title of the action displayed to a user.
         */
        @Child(name = "title", type = {StringType.class}, order=2, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="User-visible title", formalDefinition="The title of the action displayed to a user." )
        protected StringType title;

        /**
         * A short description of the action used to provide a summary to display to the user.
         */
        @Child(name = "description", type = {StringType.class}, order=3, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Short description of the action", formalDefinition="A short description of the action used to provide a summary to display to the user." )
        protected StringType description;

        /**
         * A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.
         */
        @Child(name = "textEquivalent", type = {StringType.class}, order=4, min=0, max=1, modifier=false, summary=true)
        @Description(shortDefinition="Static text equivalent of the action, used if the dynamic aspects cannot be interpreted by the receiving system", formalDefinition="A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically." )
        protected StringType textEquivalent;

        /**
         * Indicates how quickly the action should be addressed with respect to other actions.
         */
        @Child(name = "priority", type = {CodeType.class}, order=5, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="routine | urgent | asap | stat", formalDefinition="Indicates how quickly the action should be addressed with respect to other actions." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/request-priority")
        protected Enumeration<RequestPriority> priority;

        /**
         * A code that provides meaning for the action or action group. For example, a section may have a LOINC code for a section of a documentation template.
         */
        @Child(name = "code", type = {CodeableConcept.class}, order=6, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Code representing the meaning of the action or sub-actions", formalDefinition="A code that provides meaning for the action or action group. For example, a section may have a LOINC code for a section of a documentation template." )
        protected List<CodeableConcept> code;

        /**
         * Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.
         */
        @Child(name = "documentation", type = {RelatedArtifact.class}, order=7, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Supporting documentation for the intended performer of the action", formalDefinition="Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources." )
        protected List<RelatedArtifact> documentation;

        /**
         * An expression that describes applicability criteria, or start/stop conditions for the action.
         */
        @Child(name = "condition", type = {}, order=8, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Whether or not the action is applicable", formalDefinition="An expression that describes applicability criteria, or start/stop conditions for the action." )
        protected List<RequestGroupActionConditionComponent> condition;

        /**
         * A relationship to another action such as "before" or "30-60 minutes after start of".
         */
        @Child(name = "relatedAction", type = {}, order=9, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Relationship to another action", formalDefinition="A relationship to another action such as \"before\" or \"30-60 minutes after start of\"." )
        protected List<RequestGroupActionRelatedActionComponent> relatedAction;

        /**
         * An optional value describing when the action should be performed.
         */
        @Child(name = "timing", type = {DateTimeType.class, Age.class, Period.class, Duration.class, Range.class, Timing.class}, order=10, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="When the action should take place", formalDefinition="An optional value describing when the action should be performed." )
        protected DataType timing;

        /**
         * The participant that should perform or be responsible for this action.
         */
        @Child(name = "participant", type = {Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class, Device.class}, order=11, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Who should perform the action", formalDefinition="The participant that should perform or be responsible for this action." )
        protected List<Reference> participant;

        /**
         * The type of action to perform (create, update, remove).
         */
        @Child(name = "type", type = {CodeableConcept.class}, order=12, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="create | update | remove | fire-event", formalDefinition="The type of action to perform (create, update, remove)." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-type")
        protected CodeableConcept type;

        /**
         * Defines the grouping behavior for the action and its children.
         */
        @Child(name = "groupingBehavior", type = {CodeType.class}, order=13, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="visual-group | logical-group | sentence-group", formalDefinition="Defines the grouping behavior for the action and its children." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-grouping-behavior")
        protected Enumeration<ActionGroupingBehavior> groupingBehavior;

        /**
         * Defines the selection behavior for the action and its children.
         */
        @Child(name = "selectionBehavior", type = {CodeType.class}, order=14, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="any | all | all-or-none | exactly-one | at-most-one | one-or-more", formalDefinition="Defines the selection behavior for the action and its children." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-selection-behavior")
        protected Enumeration<ActionSelectionBehavior> selectionBehavior;

        /**
         * Defines expectations around whether an action is required.
         */
        @Child(name = "requiredBehavior", type = {CodeType.class}, order=15, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="must | could | must-unless-documented", formalDefinition="Defines expectations around whether an action is required." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-required-behavior")
        protected Enumeration<ActionRequiredBehavior> requiredBehavior;

        /**
         * Defines whether the action should usually be preselected.
         */
        @Child(name = "precheckBehavior", type = {CodeType.class}, order=16, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="yes | no", formalDefinition="Defines whether the action should usually be preselected." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-precheck-behavior")
        protected Enumeration<ActionPrecheckBehavior> precheckBehavior;

        /**
         * Defines whether the action can be selected multiple times.
         */
        @Child(name = "cardinalityBehavior", type = {CodeType.class}, order=17, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="single | multiple", formalDefinition="Defines whether the action can be selected multiple times." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-cardinality-behavior")
        protected Enumeration<ActionCardinalityBehavior> cardinalityBehavior;

        /**
         * The resource that is the target of the action (e.g. CommunicationRequest).
         */
        @Child(name = "resource", type = {Reference.class}, order=18, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="The target of the action", formalDefinition="The resource that is the target of the action (e.g. CommunicationRequest)." )
        protected Reference resource;

        /**
         * Sub actions.
         */
        @Child(name = "action", type = {RequestGroupActionComponent.class}, order=19, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
        @Description(shortDefinition="Sub action", formalDefinition="Sub actions." )
        protected List<RequestGroupActionComponent> action;

        private static final long serialVersionUID = -919880448L;

    /**
     * Constructor
     */
      public RequestGroupActionComponent() {
        super();
      }

        /**
         * @return {@link #prefix} (A user-visible prefix for the action.). This is the underlying object with id, value and extensions. The accessor "getPrefix" gives direct access to the value
         */
        public StringType getPrefixElement() { 
          if (this.prefix == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestGroupActionComponent.prefix");
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
         * @param value {@link #prefix} (A user-visible prefix for the action.). This is the underlying object with id, value and extensions. The accessor "getPrefix" gives direct access to the value
         */
        public RequestGroupActionComponent setPrefixElement(StringType value) { 
          this.prefix = value;
          return this;
        }

        /**
         * @return A user-visible prefix for the action.
         */
        public String getPrefix() { 
          return this.prefix == null ? null : this.prefix.getValue();
        }

        /**
         * @param value A user-visible prefix for the action.
         */
        public RequestGroupActionComponent setPrefix(String value) { 
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
              throw new Error("Attempt to auto-create RequestGroupActionComponent.title");
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
        public RequestGroupActionComponent setTitleElement(StringType value) { 
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
        public RequestGroupActionComponent setTitle(String value) { 
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
        public StringType getDescriptionElement() { 
          if (this.description == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestGroupActionComponent.description");
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
         * @param value {@link #description} (A short description of the action used to provide a summary to display to the user.). This is the underlying object with id, value and extensions. The accessor "getDescription" gives direct access to the value
         */
        public RequestGroupActionComponent setDescriptionElement(StringType value) { 
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
        public RequestGroupActionComponent setDescription(String value) { 
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
         * @return {@link #textEquivalent} (A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.). This is the underlying object with id, value and extensions. The accessor "getTextEquivalent" gives direct access to the value
         */
        public StringType getTextEquivalentElement() { 
          if (this.textEquivalent == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestGroupActionComponent.textEquivalent");
            else if (Configuration.doAutoCreate())
              this.textEquivalent = new StringType(); // bb
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
        public RequestGroupActionComponent setTextEquivalentElement(StringType value) { 
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
        public RequestGroupActionComponent setTextEquivalent(String value) { 
          if (Utilities.noString(value))
            this.textEquivalent = null;
          else {
            if (this.textEquivalent == null)
              this.textEquivalent = new StringType();
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
              throw new Error("Attempt to auto-create RequestGroupActionComponent.priority");
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
        public RequestGroupActionComponent setPriorityElement(Enumeration<RequestPriority> value) { 
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
        public RequestGroupActionComponent setPriority(RequestPriority value) { 
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
        public RequestGroupActionComponent setCode(List<CodeableConcept> theCode) { 
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

        public RequestGroupActionComponent addCode(CodeableConcept t) { //3
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
        public RequestGroupActionComponent setDocumentation(List<RelatedArtifact> theDocumentation) { 
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

        public RequestGroupActionComponent addDocumentation(RelatedArtifact t) { //3
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
         * @return {@link #condition} (An expression that describes applicability criteria, or start/stop conditions for the action.)
         */
        public List<RequestGroupActionConditionComponent> getCondition() { 
          if (this.condition == null)
            this.condition = new ArrayList<RequestGroupActionConditionComponent>();
          return this.condition;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestGroupActionComponent setCondition(List<RequestGroupActionConditionComponent> theCondition) { 
          this.condition = theCondition;
          return this;
        }

        public boolean hasCondition() { 
          if (this.condition == null)
            return false;
          for (RequestGroupActionConditionComponent item : this.condition)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestGroupActionConditionComponent addCondition() { //3
          RequestGroupActionConditionComponent t = new RequestGroupActionConditionComponent();
          if (this.condition == null)
            this.condition = new ArrayList<RequestGroupActionConditionComponent>();
          this.condition.add(t);
          return t;
        }

        public RequestGroupActionComponent addCondition(RequestGroupActionConditionComponent t) { //3
          if (t == null)
            return this;
          if (this.condition == null)
            this.condition = new ArrayList<RequestGroupActionConditionComponent>();
          this.condition.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #condition}, creating it if it does not already exist {3}
         */
        public RequestGroupActionConditionComponent getConditionFirstRep() { 
          if (getCondition().isEmpty()) {
            addCondition();
          }
          return getCondition().get(0);
        }

        /**
         * @return {@link #relatedAction} (A relationship to another action such as "before" or "30-60 minutes after start of".)
         */
        public List<RequestGroupActionRelatedActionComponent> getRelatedAction() { 
          if (this.relatedAction == null)
            this.relatedAction = new ArrayList<RequestGroupActionRelatedActionComponent>();
          return this.relatedAction;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestGroupActionComponent setRelatedAction(List<RequestGroupActionRelatedActionComponent> theRelatedAction) { 
          this.relatedAction = theRelatedAction;
          return this;
        }

        public boolean hasRelatedAction() { 
          if (this.relatedAction == null)
            return false;
          for (RequestGroupActionRelatedActionComponent item : this.relatedAction)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestGroupActionRelatedActionComponent addRelatedAction() { //3
          RequestGroupActionRelatedActionComponent t = new RequestGroupActionRelatedActionComponent();
          if (this.relatedAction == null)
            this.relatedAction = new ArrayList<RequestGroupActionRelatedActionComponent>();
          this.relatedAction.add(t);
          return t;
        }

        public RequestGroupActionComponent addRelatedAction(RequestGroupActionRelatedActionComponent t) { //3
          if (t == null)
            return this;
          if (this.relatedAction == null)
            this.relatedAction = new ArrayList<RequestGroupActionRelatedActionComponent>();
          this.relatedAction.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #relatedAction}, creating it if it does not already exist {3}
         */
        public RequestGroupActionRelatedActionComponent getRelatedActionFirstRep() { 
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
        public RequestGroupActionComponent setTiming(DataType value) { 
          if (value != null && !(value instanceof DateTimeType || value instanceof Age || value instanceof Period || value instanceof Duration || value instanceof Range || value instanceof Timing))
            throw new Error("Not the right type for RequestGroup.action.timing[x]: "+value.fhirType());
          this.timing = value;
          return this;
        }

        /**
         * @return {@link #participant} (The participant that should perform or be responsible for this action.)
         */
        public List<Reference> getParticipant() { 
          if (this.participant == null)
            this.participant = new ArrayList<Reference>();
          return this.participant;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestGroupActionComponent setParticipant(List<Reference> theParticipant) { 
          this.participant = theParticipant;
          return this;
        }

        public boolean hasParticipant() { 
          if (this.participant == null)
            return false;
          for (Reference item : this.participant)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public Reference addParticipant() { //3
          Reference t = new Reference();
          if (this.participant == null)
            this.participant = new ArrayList<Reference>();
          this.participant.add(t);
          return t;
        }

        public RequestGroupActionComponent addParticipant(Reference t) { //3
          if (t == null)
            return this;
          if (this.participant == null)
            this.participant = new ArrayList<Reference>();
          this.participant.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #participant}, creating it if it does not already exist {3}
         */
        public Reference getParticipantFirstRep() { 
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
              throw new Error("Attempt to auto-create RequestGroupActionComponent.type");
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
        public RequestGroupActionComponent setType(CodeableConcept value) { 
          this.type = value;
          return this;
        }

        /**
         * @return {@link #groupingBehavior} (Defines the grouping behavior for the action and its children.). This is the underlying object with id, value and extensions. The accessor "getGroupingBehavior" gives direct access to the value
         */
        public Enumeration<ActionGroupingBehavior> getGroupingBehaviorElement() { 
          if (this.groupingBehavior == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestGroupActionComponent.groupingBehavior");
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
        public RequestGroupActionComponent setGroupingBehaviorElement(Enumeration<ActionGroupingBehavior> value) { 
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
        public RequestGroupActionComponent setGroupingBehavior(ActionGroupingBehavior value) { 
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
              throw new Error("Attempt to auto-create RequestGroupActionComponent.selectionBehavior");
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
        public RequestGroupActionComponent setSelectionBehaviorElement(Enumeration<ActionSelectionBehavior> value) { 
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
        public RequestGroupActionComponent setSelectionBehavior(ActionSelectionBehavior value) { 
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
              throw new Error("Attempt to auto-create RequestGroupActionComponent.requiredBehavior");
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
        public RequestGroupActionComponent setRequiredBehaviorElement(Enumeration<ActionRequiredBehavior> value) { 
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
        public RequestGroupActionComponent setRequiredBehavior(ActionRequiredBehavior value) { 
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
              throw new Error("Attempt to auto-create RequestGroupActionComponent.precheckBehavior");
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
        public RequestGroupActionComponent setPrecheckBehaviorElement(Enumeration<ActionPrecheckBehavior> value) { 
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
        public RequestGroupActionComponent setPrecheckBehavior(ActionPrecheckBehavior value) { 
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
              throw new Error("Attempt to auto-create RequestGroupActionComponent.cardinalityBehavior");
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
        public RequestGroupActionComponent setCardinalityBehaviorElement(Enumeration<ActionCardinalityBehavior> value) { 
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
        public RequestGroupActionComponent setCardinalityBehavior(ActionCardinalityBehavior value) { 
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
              throw new Error("Attempt to auto-create RequestGroupActionComponent.resource");
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
        public RequestGroupActionComponent setResource(Reference value) { 
          this.resource = value;
          return this;
        }

        /**
         * @return {@link #action} (Sub actions.)
         */
        public List<RequestGroupActionComponent> getAction() { 
          if (this.action == null)
            this.action = new ArrayList<RequestGroupActionComponent>();
          return this.action;
        }

        /**
         * @return Returns a reference to <code>this</code> for easy method chaining
         */
        public RequestGroupActionComponent setAction(List<RequestGroupActionComponent> theAction) { 
          this.action = theAction;
          return this;
        }

        public boolean hasAction() { 
          if (this.action == null)
            return false;
          for (RequestGroupActionComponent item : this.action)
            if (!item.isEmpty())
              return true;
          return false;
        }

        public RequestGroupActionComponent addAction() { //3
          RequestGroupActionComponent t = new RequestGroupActionComponent();
          if (this.action == null)
            this.action = new ArrayList<RequestGroupActionComponent>();
          this.action.add(t);
          return t;
        }

        public RequestGroupActionComponent addAction(RequestGroupActionComponent t) { //3
          if (t == null)
            return this;
          if (this.action == null)
            this.action = new ArrayList<RequestGroupActionComponent>();
          this.action.add(t);
          return this;
        }

        /**
         * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
         */
        public RequestGroupActionComponent getActionFirstRep() { 
          if (getAction().isEmpty()) {
            addAction();
          }
          return getAction().get(0);
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("prefix", "string", "A user-visible prefix for the action.", 0, 1, prefix));
          children.add(new Property("title", "string", "The title of the action displayed to a user.", 0, 1, title));
          children.add(new Property("description", "string", "A short description of the action used to provide a summary to display to the user.", 0, 1, description));
          children.add(new Property("textEquivalent", "string", "A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.", 0, 1, textEquivalent));
          children.add(new Property("priority", "code", "Indicates how quickly the action should be addressed with respect to other actions.", 0, 1, priority));
          children.add(new Property("code", "CodeableConcept", "A code that provides meaning for the action or action group. For example, a section may have a LOINC code for a section of a documentation template.", 0, java.lang.Integer.MAX_VALUE, code));
          children.add(new Property("documentation", "RelatedArtifact", "Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.", 0, java.lang.Integer.MAX_VALUE, documentation));
          children.add(new Property("condition", "", "An expression that describes applicability criteria, or start/stop conditions for the action.", 0, java.lang.Integer.MAX_VALUE, condition));
          children.add(new Property("relatedAction", "", "A relationship to another action such as \"before\" or \"30-60 minutes after start of\".", 0, java.lang.Integer.MAX_VALUE, relatedAction));
          children.add(new Property("timing[x]", "dateTime|Age|Period|Duration|Range|Timing", "An optional value describing when the action should be performed.", 0, 1, timing));
          children.add(new Property("participant", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Device)", "The participant that should perform or be responsible for this action.", 0, java.lang.Integer.MAX_VALUE, participant));
          children.add(new Property("type", "CodeableConcept", "The type of action to perform (create, update, remove).", 0, 1, type));
          children.add(new Property("groupingBehavior", "code", "Defines the grouping behavior for the action and its children.", 0, 1, groupingBehavior));
          children.add(new Property("selectionBehavior", "code", "Defines the selection behavior for the action and its children.", 0, 1, selectionBehavior));
          children.add(new Property("requiredBehavior", "code", "Defines expectations around whether an action is required.", 0, 1, requiredBehavior));
          children.add(new Property("precheckBehavior", "code", "Defines whether the action should usually be preselected.", 0, 1, precheckBehavior));
          children.add(new Property("cardinalityBehavior", "code", "Defines whether the action can be selected multiple times.", 0, 1, cardinalityBehavior));
          children.add(new Property("resource", "Reference(Any)", "The resource that is the target of the action (e.g. CommunicationRequest).", 0, 1, resource));
          children.add(new Property("action", "@RequestGroup.action", "Sub actions.", 0, java.lang.Integer.MAX_VALUE, action));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -980110702: /*prefix*/  return new Property("prefix", "string", "A user-visible prefix for the action.", 0, 1, prefix);
          case 110371416: /*title*/  return new Property("title", "string", "The title of the action displayed to a user.", 0, 1, title);
          case -1724546052: /*description*/  return new Property("description", "string", "A short description of the action used to provide a summary to display to the user.", 0, 1, description);
          case -900391049: /*textEquivalent*/  return new Property("textEquivalent", "string", "A text equivalent of the action to be performed. This provides a human-interpretable description of the action when the definition is consumed by a system that might not be capable of interpreting it dynamically.", 0, 1, textEquivalent);
          case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly the action should be addressed with respect to other actions.", 0, 1, priority);
          case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that provides meaning for the action or action group. For example, a section may have a LOINC code for a section of a documentation template.", 0, java.lang.Integer.MAX_VALUE, code);
          case 1587405498: /*documentation*/  return new Property("documentation", "RelatedArtifact", "Didactic or other informational resources associated with the action that can be provided to the CDS recipient. Information resources can include inline text commentary and links to web resources.", 0, java.lang.Integer.MAX_VALUE, documentation);
          case -861311717: /*condition*/  return new Property("condition", "", "An expression that describes applicability criteria, or start/stop conditions for the action.", 0, java.lang.Integer.MAX_VALUE, condition);
          case -384107967: /*relatedAction*/  return new Property("relatedAction", "", "A relationship to another action such as \"before\" or \"30-60 minutes after start of\".", 0, java.lang.Integer.MAX_VALUE, relatedAction);
          case 164632566: /*timing[x]*/  return new Property("timing[x]", "dateTime|Age|Period|Duration|Range|Timing", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -873664438: /*timing*/  return new Property("timing[x]", "dateTime|Age|Period|Duration|Range|Timing", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -1837458939: /*timingDateTime*/  return new Property("timing[x]", "dateTime", "An optional value describing when the action should be performed.", 0, 1, timing);
          case 164607061: /*timingAge*/  return new Property("timing[x]", "Age", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -615615829: /*timingPeriod*/  return new Property("timing[x]", "Period", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -1327253506: /*timingDuration*/  return new Property("timing[x]", "Duration", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -710871277: /*timingRange*/  return new Property("timing[x]", "Range", "An optional value describing when the action should be performed.", 0, 1, timing);
          case -497554124: /*timingTiming*/  return new Property("timing[x]", "Timing", "An optional value describing when the action should be performed.", 0, 1, timing);
          case 767422259: /*participant*/  return new Property("participant", "Reference(Patient|Practitioner|PractitionerRole|RelatedPerson|Device)", "The participant that should perform or be responsible for this action.", 0, java.lang.Integer.MAX_VALUE, participant);
          case 3575610: /*type*/  return new Property("type", "CodeableConcept", "The type of action to perform (create, update, remove).", 0, 1, type);
          case 586678389: /*groupingBehavior*/  return new Property("groupingBehavior", "code", "Defines the grouping behavior for the action and its children.", 0, 1, groupingBehavior);
          case 168639486: /*selectionBehavior*/  return new Property("selectionBehavior", "code", "Defines the selection behavior for the action and its children.", 0, 1, selectionBehavior);
          case -1163906287: /*requiredBehavior*/  return new Property("requiredBehavior", "code", "Defines expectations around whether an action is required.", 0, 1, requiredBehavior);
          case -1174249033: /*precheckBehavior*/  return new Property("precheckBehavior", "code", "Defines whether the action should usually be preselected.", 0, 1, precheckBehavior);
          case -922577408: /*cardinalityBehavior*/  return new Property("cardinalityBehavior", "code", "Defines whether the action can be selected multiple times.", 0, 1, cardinalityBehavior);
          case -341064690: /*resource*/  return new Property("resource", "Reference(Any)", "The resource that is the target of the action (e.g. CommunicationRequest).", 0, 1, resource);
          case -1422950858: /*action*/  return new Property("action", "@RequestGroup.action", "Sub actions.", 0, java.lang.Integer.MAX_VALUE, action);
          default: return super.getNamedProperty(_hash, _name, _checkValid);
          }

        }

      @Override
      public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
        switch (hash) {
        case -980110702: /*prefix*/ return this.prefix == null ? new Base[0] : new Base[] {this.prefix}; // StringType
        case 110371416: /*title*/ return this.title == null ? new Base[0] : new Base[] {this.title}; // StringType
        case -1724546052: /*description*/ return this.description == null ? new Base[0] : new Base[] {this.description}; // StringType
        case -900391049: /*textEquivalent*/ return this.textEquivalent == null ? new Base[0] : new Base[] {this.textEquivalent}; // StringType
        case -1165461084: /*priority*/ return this.priority == null ? new Base[0] : new Base[] {this.priority}; // Enumeration<RequestPriority>
        case 3059181: /*code*/ return this.code == null ? new Base[0] : this.code.toArray(new Base[this.code.size()]); // CodeableConcept
        case 1587405498: /*documentation*/ return this.documentation == null ? new Base[0] : this.documentation.toArray(new Base[this.documentation.size()]); // RelatedArtifact
        case -861311717: /*condition*/ return this.condition == null ? new Base[0] : this.condition.toArray(new Base[this.condition.size()]); // RequestGroupActionConditionComponent
        case -384107967: /*relatedAction*/ return this.relatedAction == null ? new Base[0] : this.relatedAction.toArray(new Base[this.relatedAction.size()]); // RequestGroupActionRelatedActionComponent
        case -873664438: /*timing*/ return this.timing == null ? new Base[0] : new Base[] {this.timing}; // DataType
        case 767422259: /*participant*/ return this.participant == null ? new Base[0] : this.participant.toArray(new Base[this.participant.size()]); // Reference
        case 3575610: /*type*/ return this.type == null ? new Base[0] : new Base[] {this.type}; // CodeableConcept
        case 586678389: /*groupingBehavior*/ return this.groupingBehavior == null ? new Base[0] : new Base[] {this.groupingBehavior}; // Enumeration<ActionGroupingBehavior>
        case 168639486: /*selectionBehavior*/ return this.selectionBehavior == null ? new Base[0] : new Base[] {this.selectionBehavior}; // Enumeration<ActionSelectionBehavior>
        case -1163906287: /*requiredBehavior*/ return this.requiredBehavior == null ? new Base[0] : new Base[] {this.requiredBehavior}; // Enumeration<ActionRequiredBehavior>
        case -1174249033: /*precheckBehavior*/ return this.precheckBehavior == null ? new Base[0] : new Base[] {this.precheckBehavior}; // Enumeration<ActionPrecheckBehavior>
        case -922577408: /*cardinalityBehavior*/ return this.cardinalityBehavior == null ? new Base[0] : new Base[] {this.cardinalityBehavior}; // Enumeration<ActionCardinalityBehavior>
        case -341064690: /*resource*/ return this.resource == null ? new Base[0] : new Base[] {this.resource}; // Reference
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // RequestGroupActionComponent
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -980110702: // prefix
          this.prefix = TypeConvertor.castToString(value); // StringType
          return value;
        case 110371416: // title
          this.title = TypeConvertor.castToString(value); // StringType
          return value;
        case -1724546052: // description
          this.description = TypeConvertor.castToString(value); // StringType
          return value;
        case -900391049: // textEquivalent
          this.textEquivalent = TypeConvertor.castToString(value); // StringType
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
        case -861311717: // condition
          this.getCondition().add((RequestGroupActionConditionComponent) value); // RequestGroupActionConditionComponent
          return value;
        case -384107967: // relatedAction
          this.getRelatedAction().add((RequestGroupActionRelatedActionComponent) value); // RequestGroupActionRelatedActionComponent
          return value;
        case -873664438: // timing
          this.timing = TypeConvertor.castToType(value); // DataType
          return value;
        case 767422259: // participant
          this.getParticipant().add(TypeConvertor.castToReference(value)); // Reference
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
        case -1422950858: // action
          this.getAction().add((RequestGroupActionComponent) value); // RequestGroupActionComponent
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("prefix")) {
          this.prefix = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("title")) {
          this.title = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("description")) {
          this.description = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("textEquivalent")) {
          this.textEquivalent = TypeConvertor.castToString(value); // StringType
        } else if (name.equals("priority")) {
          value = new RequestPriorityEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.priority = (Enumeration) value; // Enumeration<RequestPriority>
        } else if (name.equals("code")) {
          this.getCode().add(TypeConvertor.castToCodeableConcept(value));
        } else if (name.equals("documentation")) {
          this.getDocumentation().add(TypeConvertor.castToRelatedArtifact(value));
        } else if (name.equals("condition")) {
          this.getCondition().add((RequestGroupActionConditionComponent) value);
        } else if (name.equals("relatedAction")) {
          this.getRelatedAction().add((RequestGroupActionRelatedActionComponent) value);
        } else if (name.equals("timing[x]")) {
          this.timing = TypeConvertor.castToType(value); // DataType
        } else if (name.equals("participant")) {
          this.getParticipant().add(TypeConvertor.castToReference(value));
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
        } else if (name.equals("action")) {
          this.getAction().add((RequestGroupActionComponent) value);
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -980110702:  return getPrefixElement();
        case 110371416:  return getTitleElement();
        case -1724546052:  return getDescriptionElement();
        case -900391049:  return getTextEquivalentElement();
        case -1165461084:  return getPriorityElement();
        case 3059181:  return addCode(); 
        case 1587405498:  return addDocumentation(); 
        case -861311717:  return addCondition(); 
        case -384107967:  return addRelatedAction(); 
        case 164632566:  return getTiming();
        case -873664438:  return getTiming();
        case 767422259:  return addParticipant(); 
        case 3575610:  return getType();
        case 586678389:  return getGroupingBehaviorElement();
        case 168639486:  return getSelectionBehaviorElement();
        case -1163906287:  return getRequiredBehaviorElement();
        case -1174249033:  return getPrecheckBehaviorElement();
        case -922577408:  return getCardinalityBehaviorElement();
        case -341064690:  return getResource();
        case -1422950858:  return addAction(); 
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -980110702: /*prefix*/ return new String[] {"string"};
        case 110371416: /*title*/ return new String[] {"string"};
        case -1724546052: /*description*/ return new String[] {"string"};
        case -900391049: /*textEquivalent*/ return new String[] {"string"};
        case -1165461084: /*priority*/ return new String[] {"code"};
        case 3059181: /*code*/ return new String[] {"CodeableConcept"};
        case 1587405498: /*documentation*/ return new String[] {"RelatedArtifact"};
        case -861311717: /*condition*/ return new String[] {};
        case -384107967: /*relatedAction*/ return new String[] {};
        case -873664438: /*timing*/ return new String[] {"dateTime", "Age", "Period", "Duration", "Range", "Timing"};
        case 767422259: /*participant*/ return new String[] {"Reference"};
        case 3575610: /*type*/ return new String[] {"CodeableConcept"};
        case 586678389: /*groupingBehavior*/ return new String[] {"code"};
        case 168639486: /*selectionBehavior*/ return new String[] {"code"};
        case -1163906287: /*requiredBehavior*/ return new String[] {"code"};
        case -1174249033: /*precheckBehavior*/ return new String[] {"code"};
        case -922577408: /*cardinalityBehavior*/ return new String[] {"code"};
        case -341064690: /*resource*/ return new String[] {"Reference"};
        case -1422950858: /*action*/ return new String[] {"@RequestGroup.action"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("prefix")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.prefix");
        }
        else if (name.equals("title")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.title");
        }
        else if (name.equals("description")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.description");
        }
        else if (name.equals("textEquivalent")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.textEquivalent");
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.priority");
        }
        else if (name.equals("code")) {
          return addCode();
        }
        else if (name.equals("documentation")) {
          return addDocumentation();
        }
        else if (name.equals("condition")) {
          return addCondition();
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
        else if (name.equals("participant")) {
          return addParticipant();
        }
        else if (name.equals("type")) {
          this.type = new CodeableConcept();
          return this.type;
        }
        else if (name.equals("groupingBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.groupingBehavior");
        }
        else if (name.equals("selectionBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.selectionBehavior");
        }
        else if (name.equals("requiredBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.requiredBehavior");
        }
        else if (name.equals("precheckBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.precheckBehavior");
        }
        else if (name.equals("cardinalityBehavior")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.cardinalityBehavior");
        }
        else if (name.equals("resource")) {
          this.resource = new Reference();
          return this.resource;
        }
        else if (name.equals("action")) {
          return addAction();
        }
        else
          return super.addChild(name);
      }

      public RequestGroupActionComponent copy() {
        RequestGroupActionComponent dst = new RequestGroupActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestGroupActionComponent dst) {
        super.copyValues(dst);
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
        if (condition != null) {
          dst.condition = new ArrayList<RequestGroupActionConditionComponent>();
          for (RequestGroupActionConditionComponent i : condition)
            dst.condition.add(i.copy());
        };
        if (relatedAction != null) {
          dst.relatedAction = new ArrayList<RequestGroupActionRelatedActionComponent>();
          for (RequestGroupActionRelatedActionComponent i : relatedAction)
            dst.relatedAction.add(i.copy());
        };
        dst.timing = timing == null ? null : timing.copy();
        if (participant != null) {
          dst.participant = new ArrayList<Reference>();
          for (Reference i : participant)
            dst.participant.add(i.copy());
        };
        dst.type = type == null ? null : type.copy();
        dst.groupingBehavior = groupingBehavior == null ? null : groupingBehavior.copy();
        dst.selectionBehavior = selectionBehavior == null ? null : selectionBehavior.copy();
        dst.requiredBehavior = requiredBehavior == null ? null : requiredBehavior.copy();
        dst.precheckBehavior = precheckBehavior == null ? null : precheckBehavior.copy();
        dst.cardinalityBehavior = cardinalityBehavior == null ? null : cardinalityBehavior.copy();
        dst.resource = resource == null ? null : resource.copy();
        if (action != null) {
          dst.action = new ArrayList<RequestGroupActionComponent>();
          for (RequestGroupActionComponent i : action)
            dst.action.add(i.copy());
        };
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestGroupActionComponent))
          return false;
        RequestGroupActionComponent o = (RequestGroupActionComponent) other_;
        return compareDeep(prefix, o.prefix, true) && compareDeep(title, o.title, true) && compareDeep(description, o.description, true)
           && compareDeep(textEquivalent, o.textEquivalent, true) && compareDeep(priority, o.priority, true)
           && compareDeep(code, o.code, true) && compareDeep(documentation, o.documentation, true) && compareDeep(condition, o.condition, true)
           && compareDeep(relatedAction, o.relatedAction, true) && compareDeep(timing, o.timing, true) && compareDeep(participant, o.participant, true)
           && compareDeep(type, o.type, true) && compareDeep(groupingBehavior, o.groupingBehavior, true) && compareDeep(selectionBehavior, o.selectionBehavior, true)
           && compareDeep(requiredBehavior, o.requiredBehavior, true) && compareDeep(precheckBehavior, o.precheckBehavior, true)
           && compareDeep(cardinalityBehavior, o.cardinalityBehavior, true) && compareDeep(resource, o.resource, true)
           && compareDeep(action, o.action, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestGroupActionComponent))
          return false;
        RequestGroupActionComponent o = (RequestGroupActionComponent) other_;
        return compareValues(prefix, o.prefix, true) && compareValues(title, o.title, true) && compareValues(description, o.description, true)
           && compareValues(textEquivalent, o.textEquivalent, true) && compareValues(priority, o.priority, true)
           && compareValues(groupingBehavior, o.groupingBehavior, true) && compareValues(selectionBehavior, o.selectionBehavior, true)
           && compareValues(requiredBehavior, o.requiredBehavior, true) && compareValues(precheckBehavior, o.precheckBehavior, true)
           && compareValues(cardinalityBehavior, o.cardinalityBehavior, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(prefix, title, description
          , textEquivalent, priority, code, documentation, condition, relatedAction, timing
          , participant, type, groupingBehavior, selectionBehavior, requiredBehavior, precheckBehavior
          , cardinalityBehavior, resource, action);
      }

  public String fhirType() {
    return "RequestGroup.action";

  }

  }

    @Block()
    public static class RequestGroupActionConditionComponent extends BackboneElement implements IBaseBackboneElement {
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
      public RequestGroupActionConditionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public RequestGroupActionConditionComponent(ActionConditionKind kind) {
        super();
        this.setKind(kind);
      }

        /**
         * @return {@link #kind} (The kind of condition.). This is the underlying object with id, value and extensions. The accessor "getKind" gives direct access to the value
         */
        public Enumeration<ActionConditionKind> getKindElement() { 
          if (this.kind == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestGroupActionConditionComponent.kind");
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
        public RequestGroupActionConditionComponent setKindElement(Enumeration<ActionConditionKind> value) { 
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
        public RequestGroupActionConditionComponent setKind(ActionConditionKind value) { 
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
              throw new Error("Attempt to auto-create RequestGroupActionConditionComponent.expression");
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
        public RequestGroupActionConditionComponent setExpression(Expression value) { 
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.condition.kind");
        }
        else if (name.equals("expression")) {
          this.expression = new Expression();
          return this.expression;
        }
        else
          return super.addChild(name);
      }

      public RequestGroupActionConditionComponent copy() {
        RequestGroupActionConditionComponent dst = new RequestGroupActionConditionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestGroupActionConditionComponent dst) {
        super.copyValues(dst);
        dst.kind = kind == null ? null : kind.copy();
        dst.expression = expression == null ? null : expression.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestGroupActionConditionComponent))
          return false;
        RequestGroupActionConditionComponent o = (RequestGroupActionConditionComponent) other_;
        return compareDeep(kind, o.kind, true) && compareDeep(expression, o.expression, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestGroupActionConditionComponent))
          return false;
        RequestGroupActionConditionComponent o = (RequestGroupActionConditionComponent) other_;
        return compareValues(kind, o.kind, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(kind, expression);
      }

  public String fhirType() {
    return "RequestGroup.action.condition";

  }

  }

    @Block()
    public static class RequestGroupActionRelatedActionComponent extends BackboneElement implements IBaseBackboneElement {
        /**
         * The element id of the action this is related to.
         */
        @Child(name = "actionId", type = {IdType.class}, order=1, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="What action this is related to", formalDefinition="The element id of the action this is related to." )
        protected IdType actionId;

        /**
         * The relationship of this action to the related action.
         */
        @Child(name = "relationship", type = {CodeType.class}, order=2, min=1, max=1, modifier=false, summary=false)
        @Description(shortDefinition="before-start | before | before-end | concurrent-with-start | concurrent | concurrent-with-end | after-start | after | after-end", formalDefinition="The relationship of this action to the related action." )
        @ca.uhn.fhir.model.api.annotation.Binding(valueSet="http://hl7.org/fhir/ValueSet/action-relationship-type")
        protected Enumeration<ActionRelationshipType> relationship;

        /**
         * A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.
         */
        @Child(name = "offset", type = {Duration.class, Range.class}, order=3, min=0, max=1, modifier=false, summary=false)
        @Description(shortDefinition="Time offset for the relationship", formalDefinition="A duration or range of durations to apply to the relationship. For example, 30-60 minutes before." )
        protected DataType offset;

        private static final long serialVersionUID = 621784796L;

    /**
     * Constructor
     */
      public RequestGroupActionRelatedActionComponent() {
        super();
      }

    /**
     * Constructor
     */
      public RequestGroupActionRelatedActionComponent(String actionId, ActionRelationshipType relationship) {
        super();
        this.setActionId(actionId);
        this.setRelationship(relationship);
      }

        /**
         * @return {@link #actionId} (The element id of the action this is related to.). This is the underlying object with id, value and extensions. The accessor "getActionId" gives direct access to the value
         */
        public IdType getActionIdElement() { 
          if (this.actionId == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestGroupActionRelatedActionComponent.actionId");
            else if (Configuration.doAutoCreate())
              this.actionId = new IdType(); // bb
          return this.actionId;
        }

        public boolean hasActionIdElement() { 
          return this.actionId != null && !this.actionId.isEmpty();
        }

        public boolean hasActionId() { 
          return this.actionId != null && !this.actionId.isEmpty();
        }

        /**
         * @param value {@link #actionId} (The element id of the action this is related to.). This is the underlying object with id, value and extensions. The accessor "getActionId" gives direct access to the value
         */
        public RequestGroupActionRelatedActionComponent setActionIdElement(IdType value) { 
          this.actionId = value;
          return this;
        }

        /**
         * @return The element id of the action this is related to.
         */
        public String getActionId() { 
          return this.actionId == null ? null : this.actionId.getValue();
        }

        /**
         * @param value The element id of the action this is related to.
         */
        public RequestGroupActionRelatedActionComponent setActionId(String value) { 
            if (this.actionId == null)
              this.actionId = new IdType();
            this.actionId.setValue(value);
          return this;
        }

        /**
         * @return {@link #relationship} (The relationship of this action to the related action.). This is the underlying object with id, value and extensions. The accessor "getRelationship" gives direct access to the value
         */
        public Enumeration<ActionRelationshipType> getRelationshipElement() { 
          if (this.relationship == null)
            if (Configuration.errorOnAutoCreate())
              throw new Error("Attempt to auto-create RequestGroupActionRelatedActionComponent.relationship");
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
        public RequestGroupActionRelatedActionComponent setRelationshipElement(Enumeration<ActionRelationshipType> value) { 
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
        public RequestGroupActionRelatedActionComponent setRelationship(ActionRelationshipType value) { 
            if (this.relationship == null)
              this.relationship = new Enumeration<ActionRelationshipType>(new ActionRelationshipTypeEnumFactory());
            this.relationship.setValue(value);
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
        public RequestGroupActionRelatedActionComponent setOffset(DataType value) { 
          if (value != null && !(value instanceof Duration || value instanceof Range))
            throw new Error("Not the right type for RequestGroup.action.relatedAction.offset[x]: "+value.fhirType());
          this.offset = value;
          return this;
        }

        protected void listChildren(List<Property> children) {
          super.listChildren(children);
          children.add(new Property("actionId", "id", "The element id of the action this is related to.", 0, 1, actionId));
          children.add(new Property("relationship", "code", "The relationship of this action to the related action.", 0, 1, relationship));
          children.add(new Property("offset[x]", "Duration|Range", "A duration or range of durations to apply to the relationship. For example, 30-60 minutes before.", 0, 1, offset));
        }

        @Override
        public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
          switch (_hash) {
          case -1656172047: /*actionId*/  return new Property("actionId", "id", "The element id of the action this is related to.", 0, 1, actionId);
          case -261851592: /*relationship*/  return new Property("relationship", "code", "The relationship of this action to the related action.", 0, 1, relationship);
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
        case -1656172047: /*actionId*/ return this.actionId == null ? new Base[0] : new Base[] {this.actionId}; // IdType
        case -261851592: /*relationship*/ return this.relationship == null ? new Base[0] : new Base[] {this.relationship}; // Enumeration<ActionRelationshipType>
        case -1019779949: /*offset*/ return this.offset == null ? new Base[0] : new Base[] {this.offset}; // DataType
        default: return super.getProperty(hash, name, checkValid);
        }

      }

      @Override
      public Base setProperty(int hash, String name, Base value) throws FHIRException {
        switch (hash) {
        case -1656172047: // actionId
          this.actionId = TypeConvertor.castToId(value); // IdType
          return value;
        case -261851592: // relationship
          value = new ActionRelationshipTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<ActionRelationshipType>
          return value;
        case -1019779949: // offset
          this.offset = TypeConvertor.castToType(value); // DataType
          return value;
        default: return super.setProperty(hash, name, value);
        }

      }

      @Override
      public Base setProperty(String name, Base value) throws FHIRException {
        if (name.equals("actionId")) {
          this.actionId = TypeConvertor.castToId(value); // IdType
        } else if (name.equals("relationship")) {
          value = new ActionRelationshipTypeEnumFactory().fromType(TypeConvertor.castToCode(value));
          this.relationship = (Enumeration) value; // Enumeration<ActionRelationshipType>
        } else if (name.equals("offset[x]")) {
          this.offset = TypeConvertor.castToType(value); // DataType
        } else
          return super.setProperty(name, value);
        return value;
      }

      @Override
      public Base makeProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1656172047:  return getActionIdElement();
        case -261851592:  return getRelationshipElement();
        case -1960684787:  return getOffset();
        case -1019779949:  return getOffset();
        default: return super.makeProperty(hash, name);
        }

      }

      @Override
      public String[] getTypesForProperty(int hash, String name) throws FHIRException {
        switch (hash) {
        case -1656172047: /*actionId*/ return new String[] {"id"};
        case -261851592: /*relationship*/ return new String[] {"code"};
        case -1019779949: /*offset*/ return new String[] {"Duration", "Range"};
        default: return super.getTypesForProperty(hash, name);
        }

      }

      @Override
      public Base addChild(String name) throws FHIRException {
        if (name.equals("actionId")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.relatedAction.actionId");
        }
        else if (name.equals("relationship")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.action.relatedAction.relationship");
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

      public RequestGroupActionRelatedActionComponent copy() {
        RequestGroupActionRelatedActionComponent dst = new RequestGroupActionRelatedActionComponent();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestGroupActionRelatedActionComponent dst) {
        super.copyValues(dst);
        dst.actionId = actionId == null ? null : actionId.copy();
        dst.relationship = relationship == null ? null : relationship.copy();
        dst.offset = offset == null ? null : offset.copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestGroupActionRelatedActionComponent))
          return false;
        RequestGroupActionRelatedActionComponent o = (RequestGroupActionRelatedActionComponent) other_;
        return compareDeep(actionId, o.actionId, true) && compareDeep(relationship, o.relationship, true)
           && compareDeep(offset, o.offset, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestGroupActionRelatedActionComponent))
          return false;
        RequestGroupActionRelatedActionComponent o = (RequestGroupActionRelatedActionComponent) other_;
        return compareValues(actionId, o.actionId, true) && compareValues(relationship, o.relationship, true)
          ;
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(actionId, relationship, offset
          );
      }

  public String fhirType() {
    return "RequestGroup.action.relatedAction";

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
     * A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.
     */
    @Child(name = "groupIdentifier", type = {Identifier.class}, order=5, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="Composite request this is part of", formalDefinition="A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form." )
    protected Identifier groupIdentifier;

    /**
     * The current state of the request. For request groups, the status reflects the status of all the requests in the group.
     */
    @Child(name = "status", type = {CodeType.class}, order=6, min=1, max=1, modifier=true, summary=true)
    @Description(shortDefinition="draft | active | on-hold | revoked | completed | entered-in-error | unknown", formalDefinition="The current state of the request. For request groups, the status reflects the status of all the requests in the group." )
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
     * A code that identifies what the overall request group is.
     */
    @Child(name = "code", type = {CodeableConcept.class}, order=9, min=0, max=1, modifier=false, summary=true)
    @Description(shortDefinition="What's being requested/ordered", formalDefinition="A code that identifies what the overall request group is." )
    protected CodeableConcept code;

    /**
     * The subject for which the request group was created.
     */
    @Child(name = "subject", type = {Patient.class, Group.class}, order=10, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Who the request group is about", formalDefinition="The subject for which the request group was created." )
    protected Reference subject;

    /**
     * Describes the context of the request group, if any.
     */
    @Child(name = "encounter", type = {Encounter.class}, order=11, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Created as part of", formalDefinition="Describes the context of the request group, if any." )
    protected Reference encounter;

    /**
     * Indicates when the request group was created.
     */
    @Child(name = "authoredOn", type = {DateTimeType.class}, order=12, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="When the request group was authored", formalDefinition="Indicates when the request group was created." )
    protected DateTimeType authoredOn;

    /**
     * Provides a reference to the author of the request group.
     */
    @Child(name = "author", type = {Device.class, Practitioner.class, PractitionerRole.class}, order=13, min=0, max=1, modifier=false, summary=false)
    @Description(shortDefinition="Device or practitioner that authored the request group", formalDefinition="Provides a reference to the author of the request group." )
    protected Reference author;

    /**
     * Describes the reason for the request group in coded or textual form.
     */
    @Child(name = "reason", type = {CodeableReference.class}, order=14, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Why the request group is needed", formalDefinition="Describes the reason for the request group in coded or textual form." )
    protected List<CodeableReference> reason;

    /**
     * Provides a mechanism to communicate additional information about the response.
     */
    @Child(name = "note", type = {Annotation.class}, order=15, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Additional notes about the response", formalDefinition="Provides a mechanism to communicate additional information about the response." )
    protected List<Annotation> note;

    /**
     * The actions, if any, produced by the evaluation of the artifact.
     */
    @Child(name = "action", type = {}, order=16, min=0, max=Child.MAX_UNLIMITED, modifier=false, summary=false)
    @Description(shortDefinition="Proposed actions, if any", formalDefinition="The actions, if any, produced by the evaluation of the artifact." )
    protected List<RequestGroupActionComponent> action;

    private static final long serialVersionUID = 1379590221L;

  /**
   * Constructor
   */
    public RequestGroup() {
      super();
    }

  /**
   * Constructor
   */
    public RequestGroup(RequestStatus status, RequestIntent intent) {
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
    public RequestGroup setIdentifier(List<Identifier> theIdentifier) { 
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

    public RequestGroup addIdentifier(Identifier t) { //3
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
    public RequestGroup setInstantiatesCanonical(List<CanonicalType> theInstantiatesCanonical) { 
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
    public RequestGroup addInstantiatesCanonical(String value) { //1
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
    public RequestGroup setInstantiatesUri(List<UriType> theInstantiatesUri) { 
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
    public RequestGroup addInstantiatesUri(String value) { //1
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
    public RequestGroup setBasedOn(List<Reference> theBasedOn) { 
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

    public RequestGroup addBasedOn(Reference t) { //3
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
    public RequestGroup setReplaces(List<Reference> theReplaces) { 
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

    public RequestGroup addReplaces(Reference t) { //3
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
     * @return {@link #groupIdentifier} (A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.)
     */
    public Identifier getGroupIdentifier() { 
      if (this.groupIdentifier == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestGroup.groupIdentifier");
        else if (Configuration.doAutoCreate())
          this.groupIdentifier = new Identifier(); // cc
      return this.groupIdentifier;
    }

    public boolean hasGroupIdentifier() { 
      return this.groupIdentifier != null && !this.groupIdentifier.isEmpty();
    }

    /**
     * @param value {@link #groupIdentifier} (A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.)
     */
    public RequestGroup setGroupIdentifier(Identifier value) { 
      this.groupIdentifier = value;
      return this;
    }

    /**
     * @return {@link #status} (The current state of the request. For request groups, the status reflects the status of all the requests in the group.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public Enumeration<RequestStatus> getStatusElement() { 
      if (this.status == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestGroup.status");
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
     * @param value {@link #status} (The current state of the request. For request groups, the status reflects the status of all the requests in the group.). This is the underlying object with id, value and extensions. The accessor "getStatus" gives direct access to the value
     */
    public RequestGroup setStatusElement(Enumeration<RequestStatus> value) { 
      this.status = value;
      return this;
    }

    /**
     * @return The current state of the request. For request groups, the status reflects the status of all the requests in the group.
     */
    public RequestStatus getStatus() { 
      return this.status == null ? null : this.status.getValue();
    }

    /**
     * @param value The current state of the request. For request groups, the status reflects the status of all the requests in the group.
     */
    public RequestGroup setStatus(RequestStatus value) { 
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
          throw new Error("Attempt to auto-create RequestGroup.intent");
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
    public RequestGroup setIntentElement(Enumeration<RequestIntent> value) { 
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
    public RequestGroup setIntent(RequestIntent value) { 
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
          throw new Error("Attempt to auto-create RequestGroup.priority");
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
    public RequestGroup setPriorityElement(Enumeration<RequestPriority> value) { 
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
    public RequestGroup setPriority(RequestPriority value) { 
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
     * @return {@link #code} (A code that identifies what the overall request group is.)
     */
    public CodeableConcept getCode() { 
      if (this.code == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestGroup.code");
        else if (Configuration.doAutoCreate())
          this.code = new CodeableConcept(); // cc
      return this.code;
    }

    public boolean hasCode() { 
      return this.code != null && !this.code.isEmpty();
    }

    /**
     * @param value {@link #code} (A code that identifies what the overall request group is.)
     */
    public RequestGroup setCode(CodeableConcept value) { 
      this.code = value;
      return this;
    }

    /**
     * @return {@link #subject} (The subject for which the request group was created.)
     */
    public Reference getSubject() { 
      if (this.subject == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestGroup.subject");
        else if (Configuration.doAutoCreate())
          this.subject = new Reference(); // cc
      return this.subject;
    }

    public boolean hasSubject() { 
      return this.subject != null && !this.subject.isEmpty();
    }

    /**
     * @param value {@link #subject} (The subject for which the request group was created.)
     */
    public RequestGroup setSubject(Reference value) { 
      this.subject = value;
      return this;
    }

    /**
     * @return {@link #encounter} (Describes the context of the request group, if any.)
     */
    public Reference getEncounter() { 
      if (this.encounter == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestGroup.encounter");
        else if (Configuration.doAutoCreate())
          this.encounter = new Reference(); // cc
      return this.encounter;
    }

    public boolean hasEncounter() { 
      return this.encounter != null && !this.encounter.isEmpty();
    }

    /**
     * @param value {@link #encounter} (Describes the context of the request group, if any.)
     */
    public RequestGroup setEncounter(Reference value) { 
      this.encounter = value;
      return this;
    }

    /**
     * @return {@link #authoredOn} (Indicates when the request group was created.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public DateTimeType getAuthoredOnElement() { 
      if (this.authoredOn == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestGroup.authoredOn");
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
     * @param value {@link #authoredOn} (Indicates when the request group was created.). This is the underlying object with id, value and extensions. The accessor "getAuthoredOn" gives direct access to the value
     */
    public RequestGroup setAuthoredOnElement(DateTimeType value) { 
      this.authoredOn = value;
      return this;
    }

    /**
     * @return Indicates when the request group was created.
     */
    public Date getAuthoredOn() { 
      return this.authoredOn == null ? null : this.authoredOn.getValue();
    }

    /**
     * @param value Indicates when the request group was created.
     */
    public RequestGroup setAuthoredOn(Date value) { 
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
     * @return {@link #author} (Provides a reference to the author of the request group.)
     */
    public Reference getAuthor() { 
      if (this.author == null)
        if (Configuration.errorOnAutoCreate())
          throw new Error("Attempt to auto-create RequestGroup.author");
        else if (Configuration.doAutoCreate())
          this.author = new Reference(); // cc
      return this.author;
    }

    public boolean hasAuthor() { 
      return this.author != null && !this.author.isEmpty();
    }

    /**
     * @param value {@link #author} (Provides a reference to the author of the request group.)
     */
    public RequestGroup setAuthor(Reference value) { 
      this.author = value;
      return this;
    }

    /**
     * @return {@link #reason} (Describes the reason for the request group in coded or textual form.)
     */
    public List<CodeableReference> getReason() { 
      if (this.reason == null)
        this.reason = new ArrayList<CodeableReference>();
      return this.reason;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestGroup setReason(List<CodeableReference> theReason) { 
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

    public RequestGroup addReason(CodeableReference t) { //3
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
    public RequestGroup setNote(List<Annotation> theNote) { 
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

    public RequestGroup addNote(Annotation t) { //3
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
    public List<RequestGroupActionComponent> getAction() { 
      if (this.action == null)
        this.action = new ArrayList<RequestGroupActionComponent>();
      return this.action;
    }

    /**
     * @return Returns a reference to <code>this</code> for easy method chaining
     */
    public RequestGroup setAction(List<RequestGroupActionComponent> theAction) { 
      this.action = theAction;
      return this;
    }

    public boolean hasAction() { 
      if (this.action == null)
        return false;
      for (RequestGroupActionComponent item : this.action)
        if (!item.isEmpty())
          return true;
      return false;
    }

    public RequestGroupActionComponent addAction() { //3
      RequestGroupActionComponent t = new RequestGroupActionComponent();
      if (this.action == null)
        this.action = new ArrayList<RequestGroupActionComponent>();
      this.action.add(t);
      return t;
    }

    public RequestGroup addAction(RequestGroupActionComponent t) { //3
      if (t == null)
        return this;
      if (this.action == null)
        this.action = new ArrayList<RequestGroupActionComponent>();
      this.action.add(t);
      return this;
    }

    /**
     * @return The first repetition of repeating field {@link #action}, creating it if it does not already exist {3}
     */
    public RequestGroupActionComponent getActionFirstRep() { 
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
        children.add(new Property("groupIdentifier", "Identifier", "A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.", 0, 1, groupIdentifier));
        children.add(new Property("status", "code", "The current state of the request. For request groups, the status reflects the status of all the requests in the group.", 0, 1, status));
        children.add(new Property("intent", "code", "Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain.", 0, 1, intent));
        children.add(new Property("priority", "code", "Indicates how quickly the request should be addressed with respect to other requests.", 0, 1, priority));
        children.add(new Property("code", "CodeableConcept", "A code that identifies what the overall request group is.", 0, 1, code));
        children.add(new Property("subject", "Reference(Patient|Group)", "The subject for which the request group was created.", 0, 1, subject));
        children.add(new Property("encounter", "Reference(Encounter)", "Describes the context of the request group, if any.", 0, 1, encounter));
        children.add(new Property("authoredOn", "dateTime", "Indicates when the request group was created.", 0, 1, authoredOn));
        children.add(new Property("author", "Reference(Device|Practitioner|PractitionerRole)", "Provides a reference to the author of the request group.", 0, 1, author));
        children.add(new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Describes the reason for the request group in coded or textual form.", 0, java.lang.Integer.MAX_VALUE, reason));
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
        case -445338488: /*groupIdentifier*/  return new Property("groupIdentifier", "Identifier", "A shared identifier common to all requests that were authorized more or less simultaneously by a single author, representing the identifier of the requisition, prescription or similar form.", 0, 1, groupIdentifier);
        case -892481550: /*status*/  return new Property("status", "code", "The current state of the request. For request groups, the status reflects the status of all the requests in the group.", 0, 1, status);
        case -1183762788: /*intent*/  return new Property("intent", "code", "Indicates the level of authority/intentionality associated with the request and where the request fits into the workflow chain.", 0, 1, intent);
        case -1165461084: /*priority*/  return new Property("priority", "code", "Indicates how quickly the request should be addressed with respect to other requests.", 0, 1, priority);
        case 3059181: /*code*/  return new Property("code", "CodeableConcept", "A code that identifies what the overall request group is.", 0, 1, code);
        case -1867885268: /*subject*/  return new Property("subject", "Reference(Patient|Group)", "The subject for which the request group was created.", 0, 1, subject);
        case 1524132147: /*encounter*/  return new Property("encounter", "Reference(Encounter)", "Describes the context of the request group, if any.", 0, 1, encounter);
        case -1500852503: /*authoredOn*/  return new Property("authoredOn", "dateTime", "Indicates when the request group was created.", 0, 1, authoredOn);
        case -1406328437: /*author*/  return new Property("author", "Reference(Device|Practitioner|PractitionerRole)", "Provides a reference to the author of the request group.", 0, 1, author);
        case -934964668: /*reason*/  return new Property("reason", "CodeableReference(Condition|Observation|DiagnosticReport|DocumentReference)", "Describes the reason for the request group in coded or textual form.", 0, java.lang.Integer.MAX_VALUE, reason);
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
        case 3387378: /*note*/ return this.note == null ? new Base[0] : this.note.toArray(new Base[this.note.size()]); // Annotation
        case -1422950858: /*action*/ return this.action == null ? new Base[0] : this.action.toArray(new Base[this.action.size()]); // RequestGroupActionComponent
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
        case 3387378: // note
          this.getNote().add(TypeConvertor.castToAnnotation(value)); // Annotation
          return value;
        case -1422950858: // action
          this.getAction().add((RequestGroupActionComponent) value); // RequestGroupActionComponent
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
        } else if (name.equals("note")) {
          this.getNote().add(TypeConvertor.castToAnnotation(value));
        } else if (name.equals("action")) {
          this.getAction().add((RequestGroupActionComponent) value);
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.instantiatesCanonical");
        }
        else if (name.equals("instantiatesUri")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.instantiatesUri");
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.status");
        }
        else if (name.equals("intent")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.intent");
        }
        else if (name.equals("priority")) {
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.priority");
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
          throw new FHIRException("Cannot call addChild on a primitive type RequestGroup.authoredOn");
        }
        else if (name.equals("author")) {
          this.author = new Reference();
          return this.author;
        }
        else if (name.equals("reason")) {
          return addReason();
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
    return "RequestGroup";

  }

      public RequestGroup copy() {
        RequestGroup dst = new RequestGroup();
        copyValues(dst);
        return dst;
      }

      public void copyValues(RequestGroup dst) {
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
        if (note != null) {
          dst.note = new ArrayList<Annotation>();
          for (Annotation i : note)
            dst.note.add(i.copy());
        };
        if (action != null) {
          dst.action = new ArrayList<RequestGroupActionComponent>();
          for (RequestGroupActionComponent i : action)
            dst.action.add(i.copy());
        };
      }

      protected RequestGroup typedCopy() {
        return copy();
      }

      @Override
      public boolean equalsDeep(Base other_) {
        if (!super.equalsDeep(other_))
          return false;
        if (!(other_ instanceof RequestGroup))
          return false;
        RequestGroup o = (RequestGroup) other_;
        return compareDeep(identifier, o.identifier, true) && compareDeep(instantiatesCanonical, o.instantiatesCanonical, true)
           && compareDeep(instantiatesUri, o.instantiatesUri, true) && compareDeep(basedOn, o.basedOn, true)
           && compareDeep(replaces, o.replaces, true) && compareDeep(groupIdentifier, o.groupIdentifier, true)
           && compareDeep(status, o.status, true) && compareDeep(intent, o.intent, true) && compareDeep(priority, o.priority, true)
           && compareDeep(code, o.code, true) && compareDeep(subject, o.subject, true) && compareDeep(encounter, o.encounter, true)
           && compareDeep(authoredOn, o.authoredOn, true) && compareDeep(author, o.author, true) && compareDeep(reason, o.reason, true)
           && compareDeep(note, o.note, true) && compareDeep(action, o.action, true);
      }

      @Override
      public boolean equalsShallow(Base other_) {
        if (!super.equalsShallow(other_))
          return false;
        if (!(other_ instanceof RequestGroup))
          return false;
        RequestGroup o = (RequestGroup) other_;
        return compareValues(instantiatesCanonical, o.instantiatesCanonical, true) && compareValues(instantiatesUri, o.instantiatesUri, true)
           && compareValues(status, o.status, true) && compareValues(intent, o.intent, true) && compareValues(priority, o.priority, true)
           && compareValues(authoredOn, o.authoredOn, true);
      }

      public boolean isEmpty() {
        return super.isEmpty() && ca.uhn.fhir.util.ElementUtil.isEmpty(identifier, instantiatesCanonical
          , instantiatesUri, basedOn, replaces, groupIdentifier, status, intent, priority
          , code, subject, encounter, authoredOn, author, reason, note, action);
      }

  @Override
  public ResourceType getResourceType() {
    return ResourceType.RequestGroup;
   }

 /**
   * Search parameter: <b>author</b>
   * <p>
   * Description: <b>The author of the request group</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.author</b><br>
   * </p>
   */
  @SearchParamDefinition(name="author", path="RequestGroup.author", description="The author of the request group", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Device"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner") }, target={Device.class, Practitioner.class, PractitionerRole.class } )
  public static final String SP_AUTHOR = "author";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>author</b>
   * <p>
   * Description: <b>The author of the request group</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.author</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam AUTHOR = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_AUTHOR);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestGroup:author</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_AUTHOR = new ca.uhn.fhir.model.api.Include("RequestGroup:author").toLocked();

 /**
   * Search parameter: <b>authored</b>
   * <p>
   * Description: <b>The date the request group was authored</b><br>
   * Type: <b>date</b><br>
   * Path: <b>RequestGroup.authoredOn</b><br>
   * </p>
   */
  @SearchParamDefinition(name="authored", path="RequestGroup.authoredOn", description="The date the request group was authored", type="date" )
  public static final String SP_AUTHORED = "authored";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>authored</b>
   * <p>
   * Description: <b>The date the request group was authored</b><br>
   * Type: <b>date</b><br>
   * Path: <b>RequestGroup.authoredOn</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.DateClientParam AUTHORED = new ca.uhn.fhir.rest.gclient.DateClientParam(SP_AUTHORED);

 /**
   * Search parameter: <b>code</b>
   * <p>
   * Description: <b>The code of the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.code</b><br>
   * </p>
   */
  @SearchParamDefinition(name="code", path="RequestGroup.code", description="The code of the request group", type="token" )
  public static final String SP_CODE = "code";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>code</b>
   * <p>
   * Description: <b>The code of the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.code</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam CODE = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_CODE);

 /**
   * Search parameter: <b>encounter</b>
   * <p>
   * Description: <b>The encounter the request group applies to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.encounter</b><br>
   * </p>
   */
  @SearchParamDefinition(name="encounter", path="RequestGroup.encounter", description="The encounter the request group applies to", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Encounter") }, target={Encounter.class } )
  public static final String SP_ENCOUNTER = "encounter";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>encounter</b>
   * <p>
   * Description: <b>The encounter the request group applies to</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.encounter</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam ENCOUNTER = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_ENCOUNTER);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestGroup:encounter</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_ENCOUNTER = new ca.uhn.fhir.model.api.Include("RequestGroup:encounter").toLocked();

 /**
   * Search parameter: <b>group-identifier</b>
   * <p>
   * Description: <b>The group identifier for the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.groupIdentifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="group-identifier", path="RequestGroup.groupIdentifier", description="The group identifier for the request group", type="token" )
  public static final String SP_GROUP_IDENTIFIER = "group-identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>group-identifier</b>
   * <p>
   * Description: <b>The group identifier for the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.groupIdentifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam GROUP_IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_GROUP_IDENTIFIER);

 /**
   * Search parameter: <b>identifier</b>
   * <p>
   * Description: <b>External identifiers for the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.identifier</b><br>
   * </p>
   */
  @SearchParamDefinition(name="identifier", path="RequestGroup.identifier", description="External identifiers for the request group", type="token" )
  public static final String SP_IDENTIFIER = "identifier";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>identifier</b>
   * <p>
   * Description: <b>External identifiers for the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.identifier</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam IDENTIFIER = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_IDENTIFIER);

 /**
   * Search parameter: <b>instantiates-canonical</b>
   * <p>
   * Description: <b>The FHIR-based definition from which the request group is realized</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.instantiatesCanonical</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-canonical", path="RequestGroup.instantiatesCanonical", description="The FHIR-based definition from which the request group is realized", type="reference" )
  public static final String SP_INSTANTIATES_CANONICAL = "instantiates-canonical";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-canonical</b>
   * <p>
   * Description: <b>The FHIR-based definition from which the request group is realized</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.instantiatesCanonical</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam INSTANTIATES_CANONICAL = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_INSTANTIATES_CANONICAL);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestGroup:instantiates-canonical</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_INSTANTIATES_CANONICAL = new ca.uhn.fhir.model.api.Include("RequestGroup:instantiates-canonical").toLocked();

 /**
   * Search parameter: <b>instantiates-uri</b>
   * <p>
   * Description: <b>The external definition from which the request group is realized</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>RequestGroup.instantiatesUri</b><br>
   * </p>
   */
  @SearchParamDefinition(name="instantiates-uri", path="RequestGroup.instantiatesUri", description="The external definition from which the request group is realized", type="uri" )
  public static final String SP_INSTANTIATES_URI = "instantiates-uri";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>instantiates-uri</b>
   * <p>
   * Description: <b>The external definition from which the request group is realized</b><br>
   * Type: <b>uri</b><br>
   * Path: <b>RequestGroup.instantiatesUri</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.UriClientParam INSTANTIATES_URI = new ca.uhn.fhir.rest.gclient.UriClientParam(SP_INSTANTIATES_URI);

 /**
   * Search parameter: <b>intent</b>
   * <p>
   * Description: <b>The intent of the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.intent</b><br>
   * </p>
   */
  @SearchParamDefinition(name="intent", path="RequestGroup.intent", description="The intent of the request group", type="token" )
  public static final String SP_INTENT = "intent";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>intent</b>
   * <p>
   * Description: <b>The intent of the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.intent</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam INTENT = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_INTENT);

 /**
   * Search parameter: <b>participant</b>
   * <p>
   * Description: <b>The participant in the requests in the group</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.action.participant</b><br>
   * </p>
   */
  @SearchParamDefinition(name="participant", path="RequestGroup.action.participant", description="The participant in the requests in the group", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Practitioner"), @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for RelatedPerson") }, target={Device.class, Patient.class, Practitioner.class, PractitionerRole.class, RelatedPerson.class } )
  public static final String SP_PARTICIPANT = "participant";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>participant</b>
   * <p>
   * Description: <b>The participant in the requests in the group</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.action.participant</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PARTICIPANT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PARTICIPANT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestGroup:participant</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PARTICIPANT = new ca.uhn.fhir.model.api.Include("RequestGroup:participant").toLocked();

 /**
   * Search parameter: <b>patient</b>
   * <p>
   * Description: <b>The identity of a patient to search for request groups</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  @SearchParamDefinition(name="patient", path="RequestGroup.subject.where(resolve() is Patient)", description="The identity of a patient to search for request groups", type="reference", target={Patient.class } )
  public static final String SP_PATIENT = "patient";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>patient</b>
   * <p>
   * Description: <b>The identity of a patient to search for request groups</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.subject.where(resolve() is Patient)</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam PATIENT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_PATIENT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestGroup:patient</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_PATIENT = new ca.uhn.fhir.model.api.Include("RequestGroup:patient").toLocked();

 /**
   * Search parameter: <b>priority</b>
   * <p>
   * Description: <b>The priority of the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.priority</b><br>
   * </p>
   */
  @SearchParamDefinition(name="priority", path="RequestGroup.priority", description="The priority of the request group", type="token" )
  public static final String SP_PRIORITY = "priority";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>priority</b>
   * <p>
   * Description: <b>The priority of the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.priority</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam PRIORITY = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_PRIORITY);

 /**
   * Search parameter: <b>status</b>
   * <p>
   * Description: <b>The status of the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.status</b><br>
   * </p>
   */
  @SearchParamDefinition(name="status", path="RequestGroup.status", description="The status of the request group", type="token" )
  public static final String SP_STATUS = "status";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>status</b>
   * <p>
   * Description: <b>The status of the request group</b><br>
   * Type: <b>token</b><br>
   * Path: <b>RequestGroup.status</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.TokenClientParam STATUS = new ca.uhn.fhir.rest.gclient.TokenClientParam(SP_STATUS);

 /**
   * Search parameter: <b>subject</b>
   * <p>
   * Description: <b>The subject that the request group is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.subject</b><br>
   * </p>
   */
  @SearchParamDefinition(name="subject", path="RequestGroup.subject", description="The subject that the request group is about", type="reference", providesMembershipIn={ @ca.uhn.fhir.model.api.annotation.Compartment(name="Base FHIR compartment definition for Patient") }, target={Group.class, Patient.class } )
  public static final String SP_SUBJECT = "subject";
 /**
   * <b>Fluent Client</b> search parameter constant for <b>subject</b>
   * <p>
   * Description: <b>The subject that the request group is about</b><br>
   * Type: <b>reference</b><br>
   * Path: <b>RequestGroup.subject</b><br>
   * </p>
   */
  public static final ca.uhn.fhir.rest.gclient.ReferenceClientParam SUBJECT = new ca.uhn.fhir.rest.gclient.ReferenceClientParam(SP_SUBJECT);

/**
   * Constant for fluent queries to be used to add include statements. Specifies
   * the path value of "<b>RequestGroup:subject</b>".
   */
  public static final ca.uhn.fhir.model.api.Include INCLUDE_SUBJECT = new ca.uhn.fhir.model.api.Include("RequestGroup:subject").toLocked();


}